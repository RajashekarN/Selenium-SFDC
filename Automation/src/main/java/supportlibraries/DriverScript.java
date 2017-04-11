package supportlibraries;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import com.cognizant.framework.*;
import com.cognizant.framework.ReportThemeFactory.Theme;
import com.cognizant.framework.selenium.*;

import org.apache.commons.io.FileUtils;
import org.testng.Assert;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Platform;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.lang.reflect.*;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Driver script class which encapsulates the core logic of the framework
 * 
 * @author Cognizant
 */
public class DriverScript {
	private static final CraftDriver CraftDriver = null;
	private List<String> businessFlowData;
	private int currentIteration, currentSubIteration;
	private Date startTime, endTime;

	private CraftDataTable dataTable;
	private ReportSettings reportSettings;
	private SeleniumReport report;
	private WebDriver driver;
	// private IMobileDevice device;
	private ScriptHelper scriptHelper;

	private EnvParameters envParameters = new EnvParameters();

	private Properties properties;
	private ExecutionMode executionMode = ExecutionMode.LOCAL;
	private final FrameworkParameters frameworkParameters = FrameworkParameters.getInstance();
	private Boolean testExecutedInUnitTestFramework = true;
	private Boolean linkScreenshotsToTestLog = true;
	private String testStatus;
	private boolean isAPITest = false;
	private final SeleniumTestParameters testParameters;
	private String reportPath;

	/**
	 * Function to indicate whether the test is executed in JUnit/TestNG or not
	 * 
	 * @param testExecutedInUnitTestFramework
	 *            Boolean variable indicating whether the test is executed in
	 *            JUnit/TestNG
	 */
	public void setTestExecutedInUnitTestFramework(Boolean testExecutedInUnitTestFramework) {
		this.testExecutedInUnitTestFramework = testExecutedInUnitTestFramework;
	}

	/**
	 * Function to confugure the linking of screenshots to the corresponding
	 * test log
	 * 
	 * @param linkScreenshotsToTestLog
	 *            Boolean variable indicating whether screenshots should be
	 *            linked to the corresponding test log
	 */
	public void setLinkScreenshotsToTestLog(Boolean linkScreenshotsToTestLog) {
		this.linkScreenshotsToTestLog = linkScreenshotsToTestLog;
	}

	/**
	 * Function to get the status of the test case executed
	 * 
	 * @return The test status
	 */
	public String getTestStatus() {
		return testStatus;
	}

	/**
	 * DriverScript constructor
	 * 
	 * @param testParameters
	 *            A {@link SeleniumTestParameters} object
	 */
	public DriverScript(SeleniumTestParameters testParameters) {
		this.testParameters = testParameters;
	}

	public void setAPITestFlag(boolean isAPITest) {
		this.isAPITest = isAPITest;
	}

	/**
	 * Function to execute the given test case
	 */
	public void driveTestExecution() {

		startUp();
		initializeTestIterations();
		if (!isAPITest) {
			initializeWebDriver();
		}
		initializeTestReport();
		initializeDatatable();

		/*
		 * Added for focus specific test cases
		 */
		initializeEnvParameters();
		initializeTestScript();

		/*
		 * setDBParameters()
		 */
		//setDBParameters();
		executeTestIterations();

		if (!isAPITest) {
			quitWebDriver();
		}
		wrapUp();
	}

	private void initializeEnvParameters() {
		String Env = envParameters.getEnv().toLowerCase();
		if (Env.contains("sandbox") || Env.contains("Sandbox") || Env.contains("sand"))
			Env = "Sandbox";
/*		if (Env.contains("bet") || Env.contains("testb") || Env.contains("test b"))
			Env = "BETA";
		if (Env.contains("dev"))
			Env = "DEVI";
		if (Env.contains("char") || Env.contains("testc") || Env.contains("test c"))
			Env = "CHARLIE";*/
		envParameters.setEnv(Env);
		envParameters.setBrowser(testParameters.getBrowser());
		// envParameters.setClient("SPI");
		envParameters.setRunMode(System.getProperty("runMode"));
	}

/*	public void setDBParameters() {
		Utility_Functions utility = new Utility_Functions(scriptHelper);
		utility.getDBDetails(envParameters.getClient());
	}
*/
	public void setEnv(String envirnoment) {
		if (!(envirnoment.isEmpty()) && !(envirnoment.equals("")))
			envParameters.setEnv(envirnoment);
		else
			envParameters.setEnv("sandbox");
	}

	public void setClient(String client) {
		envParameters.setClient(client);
	}

	private void startUp() {
		startTime = Util.getCurrentTime();

		properties = Settings.getInstance();

		setDefaultTestParameters();
	}

	private void setDefaultTestParameters() {
		if (testParameters.getIterationMode() == null) {
			testParameters.setIterationMode(IterationOptions.RUN_ALL_ITERATIONS);
		}
		if (System.getProperty("Browser") != null) {
			if (testParameters.getBrowser() == null)
				testParameters.setBrowser(Browser.valueOf(System.getProperty("Browser")));
		} else {
			if (testParameters.getBrowser() == null) {
				testParameters.setBrowser(Browser.valueOf(properties.getProperty("DefaultBrowser")));
			}
		}

		if (System.getProperty("BrowserVersion") != null) {
			testParameters.setBrowserVersion(System.getProperty("BrowserVersion"));
		}

		if (System.getProperty("Platform") != null) {
			testParameters.setPlatform(Platform.valueOf(System.getProperty("Platform")));
		} else {
			if (testParameters.getPlatform() == null) {
				testParameters.setPlatform(Platform.valueOf(properties.getProperty("DefaultPlatform")));
			}
		}

		/*
		 * if(System.getProperty("PerfectoDeviceId") != null) {
		 * testParameters.setPerfectoDeviceId(System.getProperty(
		 * "PerfectoDeviceId")); } else { if
		 * (testParameters.getPerfectoDeviceId() == null) {
		 * testParameters.setPerfectoDeviceId(properties.getProperty(
		 * "DefaultDeviceId")); } }
		 */
	}

	private void initializeTestIterations() {
		switch (testParameters.getIterationMode()) {
		case RUN_ALL_ITERATIONS:
			String datatablePath = frameworkParameters.getRelativePath() + Util.getFileSeparator() + "Datatables";
			ExcelDataAccess testDataAccess = new ExcelDataAccess(datatablePath, testParameters.getCurrentScenario());
			testDataAccess.setDatasheetName(properties.getProperty("DefaultDataSheet"));

			int startRowNum = testDataAccess.getRowNum(testParameters.getCurrentTestcase(), 0);
			int nTestcaseRows = testDataAccess.getRowCount(testParameters.getCurrentTestcase(), 0, startRowNum);
			int nSubIterations = testDataAccess.getRowCount("1", 1, startRowNum); // Assumption:
																					// Every
																					// test
																					// case
																					// will
																					// have
																					// at
																					// least
																					// one
																					// iteration
			int nIterations = nTestcaseRows / nSubIterations;
			testParameters.setEndIteration(nIterations);

			currentIteration = 1;
			break;

		case RUN_ONE_ITERATION_ONLY:
			currentIteration = 1;
			break;

		case RUN_RANGE_OF_ITERATIONS:
			if (testParameters.getStartIteration() > testParameters.getEndIteration()) {
				throw new FrameworkException("Error", "StartIteration cannot be greater than EndIteration!");
			}
			currentIteration = testParameters.getStartIteration();
			break;

		default:
			throw new FrameworkException("Unhandled Iteration Mode!");
		}
	}

	private void initializeWebDriver() {
		executionMode = ExecutionMode.valueOf(properties.getProperty("ExecutionMode"));

		DesiredCapabilities d = null;
		if (testParameters.getBrowser().equals(Browser.INTERNET_EXPLORER)) {
			d = DesiredCapabilities.internetExplorer();
			// d.setCapability("nativeEvents", false);
//			d.setCapability(InternetExplorerDriver.REQUIRE_WINDOW_FOCUS, true);
			d.setCapability(InternetExplorerDriver.UNEXPECTED_ALERT_BEHAVIOR, true);
			d.setCapability(InternetExplorerDriver.IE_ENSURE_CLEAN_SESSION, true);
			d.setCapability(InternetExplorerDriver.IGNORE_ZOOM_SETTING, true);


		}

		/*
		 * 09/26/2016 DJM - Update to allow for additional DesiredCapabilities
		 * If there are additional Desired Capabilities, update locally.
		 * Otherwise, rely on standard builder. Please note that this update
		 * ignores updating Proxy Settings.
		 */
		switch (executionMode) {
		case LOCAL:
			if (d != null) {
				if (testParameters.getBrowser().equals(Browser.INTERNET_EXPLORER)) {
					System.out.println(
							"INTERNET EXPLORER ALERT:" + "\nFor Test Stability: please move the mouse to the middle"
									+ "\nof the browser and do not move it until the test is complete."
									+ "\nThe mouse will move intermittently as part of testing." + "\nThank you.");
					System.setProperty("webdriver.ie.driver", properties.getProperty("InternetExplorerDriverPath"));
					driver = new InternetExplorerDriver(d);
				}
			} else {
				driver = WebDriverFactory.getWebDriver(testParameters.getBrowser());
			}
			break;

		case REMOTE:
			if (d != null) {
				URL url = null;
				try {
					url = new URL(properties.getProperty("RemoteUrl"));
				} catch (MalformedURLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				d.setJavascriptEnabled(true);
				d.setBrowserName(testParameters.getBrowser().getValue());

				if (testParameters.getBrowser().equals(Browser.INTERNET_EXPLORER)) {
					// If there are browser specific updates, add those here
				}

				driver = new RemoteWebDriver(url, d);
			} else {
				driver = WebDriverFactory.getRemoteWebDriver(testParameters.getBrowser(), properties.getProperty("RemoteUrl"));
			}
			break;

		case GRID:
			if (d != null) {

			d.setJavascriptEnabled(true);
				d.setPlatform(testParameters.getPlatform());
				d.setVersion(testParameters.getBrowserVersion());
			d.setBrowserName(testParameters.getBrowser().getValue());

				if (testParameters.getBrowser().equals(Browser.INTERNET_EXPLORER)) {
					// If there are browser specific updates, add those here
				}

				try {
					driver = new RemoteWebDriver(new URL(System.getProperty("RemoteUrl", properties.getProperty("RemoteUrl"))), d);
				} catch (MalformedURLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			} else {
				driver = WebDriverFactory.getRemoteWebDriver(testParameters.getBrowser(), testParameters.getBrowserVersion(),
						testParameters.getPlatform(),
						System.getProperty("RemoteUrl", properties.getProperty("RemoteUrl")));
			}
			break;

		/*
		 * case Perfecto: IMobileDevice device =
		 * WebDriverFactory.getDevice(testParameters.getPerfectoDeviceId());
		 * driver = device.getDOMDriver(); break;
		 */

		default:
			throw new FrameworkException("Unhandled Execution Mode!");
		}

		if (testParameters.getBrowser().equals(Browser.INTERNET_EXPLORER)) {
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		}
		driver.manage().window().maximize();
//		driver.manage().window().setPosition(new Point(0, 0));
//		System.out.println(envParameters.getClient() + " before:" + driver.manage().window().getSize());
//		driver.manage().window().setSize(new Dimension(1296, 800));
//		System.out.println(envParameters.getClient() + " after:" + driver.manage().window().getSize());
				// Sets it to regular zoom every time for starting
//		Utility_Functions.HtmlZoomOut(driver, 0);
	}

	private void initializeTestReport() {
		initializeReportSettings();
		ReportTheme reportTheme = ReportThemeFactory
				.getReportsTheme(Theme.valueOf(properties.getProperty("ReportsTheme")));

		report = new SeleniumReport(reportSettings, reportTheme, testParameters);
		System.out.println("Report for this Execution can be found at : " + reportSettings.getReportPath());

		report.initialize();
/*		if (!isAPITest) {
			reportSettings.takeScreenshotFailedStep = true;
			report.setDriver(CraftDriver);
		} else {
			reportSettings.takeScreenshotFailedStep = false;
		}*/
		report.initializeTestLog();
		createTestLogHeader();
	}

	private void initializeReportSettings() {
		if (System.getProperty("ReportPath") != null || System.getProperty("ReportPath").equals("")) {
			reportPath = System.getProperty("ReportPath");
		} else {
			reportPath = TimeStamp.getInstance();
		}

		reportSettings = new ReportSettings(reportPath,
				testParameters.getCurrentScenario() + "_" + testParameters.getCurrentTestcase());

		reportSettings.setDateFormatString(properties.getProperty("DateFormatString"));
		reportSettings.setLogLevel(Integer.parseInt(properties.getProperty("LogLevel")));
		reportSettings.setProjectName(properties.getProperty("ProjectName"));
		reportSettings.generateExcelReports = Boolean.parseBoolean(properties.getProperty("ExcelReport"));
		reportSettings.generateHtmlReports = Boolean.parseBoolean(properties.getProperty("HtmlReport"));
		reportSettings.takeScreenshotFailedStep = Boolean
				.parseBoolean(properties.getProperty("TakeScreenshotFailedStep"));
		reportSettings.takeScreenshotPassedStep = Boolean
				.parseBoolean(properties.getProperty("TakeScreenshotPassedStep"));
		reportSettings.consolidateScreenshotsInWordDoc = Boolean
				.parseBoolean(properties.getProperty("ConsolidateScreenshotsInWordDoc"));
		if (testParameters.getBrowser().equals(Browser.HTML_UNIT)) {
			// Screenshots not supported in headless mode
			reportSettings.linkScreenshotsToTestLog = false;
		} else {
			reportSettings.linkScreenshotsToTestLog = this.linkScreenshotsToTestLog;
		}
	}

	private void createTestLogHeader() {
		report.addTestLogHeading(reportSettings.getProjectName() + " - " + reportSettings.getReportName()
				+ " Automation Execution Results");
		report.addTestLogSubHeading("Date & Time",
				": " + Util.getCurrentFormattedTime(properties.getProperty("DateFormatString")), "Iteration Mode",
				": " + testParameters.getIterationMode());
		report.addTestLogSubHeading("Start Iteration", ": " + testParameters.getStartIteration(), "End Iteration",
				": " + testParameters.getEndIteration());

		switch (executionMode) {
		case LOCAL:
			report.addTestLogSubHeading("Browser", ": " + testParameters.getBrowser(), "Executed on",
					": " + "Local Machine");
			break;

		case REMOTE:
			report.addTestLogSubHeading("Browser", ": " + testParameters.getBrowser(), "Executed on",
					": " + properties.getProperty("RemoteUrl"));
			break;

		case GRID:
			String browserVersion = testParameters.getBrowserVersion();
			if (browserVersion == null) {
				browserVersion = "Not specified";
			}
			report.addTestLogSubHeading("Browser", ": " + testParameters.getBrowser(), "Version",
					": " + browserVersion);
			report.addTestLogSubHeading("Platform", ": " + testParameters.getPlatform().toString(), "Executed on",
					": " + "Grid @ " + System.getProperty("RemoteUrl", properties.getProperty("RemoteUrl")));
			break;

		/*
		 * case Perfecto: report.addTestLogSubHeading("Device ID", ": " +
		 * testParameters.getPerfectoDeviceId(), "Executed on", ": " +
		 * "Perfecto MobileCloud"); report.addTestLogSubHeading("Perfecto Host",
		 * ": " + properties.getProperty("PerfectoHost"), "Perfecto User", ": "
		 * + properties.getProperty("PerfectoUser")); break;
		 */

		default:
			throw new FrameworkException("Unhandled Execution Mode!");
		}

		report.addTestLogTableHeadings();
	}

	private void initializeDatatable() {
		String datatablePath = frameworkParameters.getRelativePath() + Util.getFileSeparator() + "Datatables";

		String runTimeDatatablePath;
		Boolean includeTestDataInReport = Boolean.parseBoolean(properties.getProperty("IncludeTestDataInReport"));
		if (includeTestDataInReport) {
			runTimeDatatablePath = reportPath + Util.getFileSeparator() + "Datatables";

			File runTimeDatatable = new File(
					runTimeDatatablePath + Util.getFileSeparator() + testParameters.getCurrentScenario() + ".xls");
			if (!runTimeDatatable.exists()) {
				File datatable = new File(
						datatablePath + Util.getFileSeparator() + testParameters.getCurrentScenario() + ".xls");

				try {
					FileUtils.copyFile(datatable, runTimeDatatable);
				} catch (IOException e) {
					e.printStackTrace();
					throw new FrameworkException(
							"Error in creating run-time datatable: Copying the datatable failed...");
				}
			}

			File runTimeCommonDatatable = new File(
					runTimeDatatablePath + Util.getFileSeparator() + "Common_Testdata.xls");
			if (!runTimeCommonDatatable.exists()) {
				File commonDatatable = new File(datatablePath + Util.getFileSeparator() + "Common_Testdata.xls");

				try {
					FileUtils.copyFile(commonDatatable, runTimeCommonDatatable);
				} catch (IOException e) {
					e.printStackTrace();
					throw new FrameworkException(
							"Error in creating run-time datatable: Copying the common datatable failed...");
				}
			}
		} else {
			runTimeDatatablePath = datatablePath;
		}

		dataTable = new CraftDataTable(runTimeDatatablePath, testParameters.getCurrentScenario());
		dataTable.setDataReferenceIdentifier(properties.getProperty("DataReferenceIdentifier"));
	}

	private void initializeTestScript() {
		scriptHelper = new ScriptHelper(dataTable, report, driver, envParameters);

		businessFlowData = getBusinessFlow();
	}

	private List<String> getBusinessFlow() {
		ExcelDataAccess businessFlowAccess = new ExcelDataAccess(
				frameworkParameters.getRelativePath() + Util.getFileSeparator() + "Datatables",
				testParameters.getCurrentScenario());
		businessFlowAccess.setDatasheetName("Business_Flow");

		int rowNum = businessFlowAccess.getRowNum(testParameters.getCurrentTestcase(), 0);
		if (rowNum == -1) {
			throw new FrameworkException("The test case \"" + testParameters.getCurrentTestcase()
					+ "\" is not found in the Business Flow sheet!");
		}

		String dataValue;
		List<String> businessFlowData = new ArrayList<String>();
		int currentColumnNum = 1;
		while (true) {
			dataValue = businessFlowAccess.getValue(rowNum, currentColumnNum);
			if (dataValue.equals("")) {
				break;
			}
			businessFlowData.add(dataValue);
			currentColumnNum++;
		}

		if (businessFlowData.isEmpty()) {
			throw new FrameworkException(
					"No business flow found against the test case \"" + testParameters.getCurrentTestcase() + "\"");
		}

		return businessFlowData;
	}

	private void executeTestIterations() {
		while (currentIteration <= testParameters.getEndIteration()) {
			report.addTestLogSection("Iteration: " + Integer.toString(currentIteration));

			// Evaluate each test iteration for any errors
			try {
				executeTestcase(businessFlowData);
			} catch (FrameworkException fx) {
				exceptionHandler(fx, fx.errorName);
			} catch (InvocationTargetException ix) {
				exceptionHandler((Exception) ix.getCause(), "Error");
			} catch (Exception ex) {
				exceptionHandler(ex, "Error");
			}

			currentIteration++;
		}
	}

	private void executeTestcase(List<String> businessFlowData)
			throws IllegalAccessException, InvocationTargetException, ClassNotFoundException, InstantiationException {
		HashMap<String, Integer> keywordDirectory = new HashMap<String, Integer>();

		for (int currentKeywordNum = 0; currentKeywordNum < businessFlowData.size(); currentKeywordNum++) {
			String[] currentFlowData = businessFlowData.get(currentKeywordNum).split(",");
			String currentKeyword = currentFlowData[0];

			int nKeywordIterations;
			if (currentFlowData.length > 1) {
				nKeywordIterations = Integer.parseInt(currentFlowData[1]);
			} else {
				nKeywordIterations = 1;
			}

			for (int currentKeywordIteration = 0; currentKeywordIteration < nKeywordIterations; currentKeywordIteration++) {
				if (keywordDirectory.containsKey(currentKeyword)) {
					keywordDirectory.put(currentKeyword, keywordDirectory.get(currentKeyword) + 1);
				} else {
					keywordDirectory.put(currentKeyword, 1);
				}
				currentSubIteration = keywordDirectory.get(currentKeyword);

				dataTable.setCurrentRow(testParameters.getCurrentTestcase(), currentIteration, currentSubIteration);

				if (currentSubIteration > 1) {
					report.addTestLogSubSection(currentKeyword + " (Sub-Iteration: " + currentSubIteration + ")");
				} else {
					report.addTestLogSubSection(currentKeyword);
				}

				invokeBusinessComponent(currentKeyword);
			}
		}
	}

	private void invokeBusinessComponent(String currentKeyword)
			throws IllegalAccessException, InvocationTargetException, ClassNotFoundException, InstantiationException {
		Boolean isMethodFound = false;
		final String CLASS_FILE_EXTENSION = ".class";
		File[] packageDirectories = {
				new File(frameworkParameters.getRelativePath() + Util.getFileSeparator() + "bin"
						+ Util.getFileSeparator() + "businesscomponents"),
				new File(frameworkParameters.getRelativePath() + Util.getFileSeparator() + "build"
						+ Util.getFileSeparator() + "classes" + Util.getFileSeparator() + "main"
						+ Util.getFileSeparator() + "businesscomponents" + Util.getFileSeparator()
						+ "componentgroups") };

		for (File packageDirectory : packageDirectories) {
			if (packageDirectory.exists()) {
				File[] packageFiles = packageDirectory.listFiles();
				String packageName = packageDirectory.getName();

				for (int i = 0; i < packageFiles.length; i++) {
					File packageFile = packageFiles[i];
					String fileName = packageFile.getName();

					// We only want the .class files
					if (fileName.endsWith(CLASS_FILE_EXTENSION)) {
						// Remove the .class extension to get the class name
						String className = fileName.substring(0, fileName.length() - CLASS_FILE_EXTENSION.length());

						Class<?> reusableComponents = Class.forName(packageName + "." + className);
						Method executeComponent;

						try {
							// Convert the first letter of the method to
							// lowercase (in line with java naming conventions)
							currentKeyword = currentKeyword.substring(0, 1).toLowerCase() + currentKeyword.substring(1);
							executeComponent = reusableComponents.getMethod(currentKeyword, (Class<?>[]) null);
						} catch (NoSuchMethodException ex) {
							// If the method is not found in this class, search
							// the next class
							continue;
						}

						isMethodFound = true;

						Constructor<?> ctor = reusableComponents.getDeclaredConstructors()[0];
						Object businessComponent = ctor.newInstance(scriptHelper);

						executeComponent.invoke(businessComponent, (Object[]) null);

						break;
					}
				}
			}
		}

		if (!isMethodFound) {
			throw new FrameworkException("Keyword " + currentKeyword + " not found within any class "
					+ "inside the businesscomponents package");
		}
	}

	private void exceptionHandler(Exception ex, String exceptionName) {
		// Error reporting
		String exceptionDescription = ex.getMessage();
		if (exceptionDescription == null) {
			exceptionDescription = ex.toString();
		}

		if (ex.getCause() != null) {
			report.updateTestLog(exceptionName, exceptionDescription + " <b>Caused by: </b>" + ex.getCause(),
					Status.FAIL);
		} else {
			report.updateTestLog(exceptionName, exceptionDescription, Status.FAIL);
		}
		ex.printStackTrace();

		// Error response
		if (frameworkParameters.getStopExecution()) {
			report.updateTestLog("CRAFT Info", "Test execution terminated by user! All subsequent tests aborted...",
					Status.DONE);
			currentIteration = testParameters.getEndIteration();
		} else {
			OnError onError = OnError.valueOf(properties.getProperty("OnError"));
			switch (onError) {
			// Stop option is not relevant when run from QC
			case NEXT_ITERATION:
				report.updateTestLog("CRAFT Info",
						"Test case iteration terminated by user! Proceeding to next iteration (if applicable)...",
						Status.DONE);
				break;

			case NEXT_TESTCASE:
				report.updateTestLog("CRAFT Info",
						"Test case terminated by user! Proceeding to next test case (if applicable)...", Status.DONE);
				currentIteration = testParameters.getEndIteration();
				break;

			case STOP:
				frameworkParameters.setStopExecution(true);
				report.updateTestLog("CRAFT Info", "Test execution terminated by user! All subsequent tests aborted...",
						Status.DONE);
				currentIteration = testParameters.getEndIteration();
				break;

			default:
				throw new FrameworkException("Unhandled OnError option!");
			}
		}
	}

	private void quitWebDriver() {

		/*
		 * if (executionMode.equals(ExecutionMode.Perfecto)) { device.close(); }
		 */
		if (testParameters.getBrowser().equals(Browser.INTERNET_EXPLORER)) {
			driver.close();
			driver.quit();
			// try {
			// Runtime.getRuntime().exec("taskkill /F /IM IEDriverServer.exe");
			// Utility_Functions.timeWait(10);
			// } catch (IOException e) {
			// // TODO Auto-generated catch block
			// e.printStackTrace();
			// }
		} else {
			driver.quit();
		}
	}

	private void wrapUp() {
		endTime = Util.getCurrentTime();
		closeTestReport();

		testStatus = report.getTestStatus();

		if (testExecutedInUnitTestFramework && testStatus.equalsIgnoreCase("Failed")) {
			Assert.fail(report.getFailureDescription());
		}

	}

	private void closeTestReport() {
		String executionTime = Util.getTimeDifference(startTime, endTime);
		report.addTestLogFooter(executionTime);

		if (reportSettings.consolidateScreenshotsInWordDoc) {
			report.consolidateScreenshotsInWordDoc();
		}
	}
}