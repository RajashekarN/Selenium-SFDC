package com.cognizant.Craft;

import com.cognizant.framework.FrameworkParameters;
import com.cognizant.framework.Settings;
import com.cognizant.framework.selenium.*;

import supportLibraries.CreateDefectTFS;
import supportLibraries.DefectFiling;
import supportLibraries.XmlGenerator;

import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import org.openqa.selenium.Platform;
import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.SkipException;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;

/**
 * Abstract base class for all the test cases to be automated
 * 
 * @author Cognizant
 */
public abstract class CRAFTTestCase {

	/**
	 * The current scenario
	 */
	protected String currentScenario;
	/**
	 * The current test case
	 */
	protected String currentTestcase;
	private Properties properties;
	private ResultSummaryManager resultSummaryManager = ResultSummaryManager.getInstance();
	public static int countReRunFailedTestCase = 1;
	public static boolean rerun = false;
	public static int rerunCounter=0;
	public static boolean sResponseMessage;

	public static int getCounter(){
		return rerunCounter;
	}
	public static void updateCounter(){
		rerunCounter++;
	}
	public static boolean getRerun(){
		return rerun;
	}
	public static void toggleRerun(){
		rerun=!rerun;
	}
	public static void updateReRun(){
		rerun=true;
	}
	/**
	 * Function to do the required framework setup activities before executing
	 * the overall test suite
	 * 
	 * @param testContext
	 *            The TestNG {@link ITestContext} of the current test suite
	 */
	@BeforeSuite(alwaysRun = true)
	public void setUpTestSuite(ITestContext testContext) {
		resultSummaryManager.setRelativePath();
		resultSummaryManager.initializeTestBatch(testContext.getSuite().getName());

		int nThreads;
		if ("false".equalsIgnoreCase(testContext.getSuite().getParallel())) {
			nThreads = 1;
		} else {
			nThreads = testContext.getCurrentXmlTest().getThreadCount();
		}
		resultSummaryManager.initializeSummaryReport(nThreads);
		resultSummaryManager.setupErrorLog();
	}

	/**
	 * Function to do the required framework setup activities before executing
	 * each test case
	 */
	@BeforeMethod(alwaysRun = true)
	public void setUpTestRunner() {
		FrameworkParameters frameworkParameters = FrameworkParameters.getInstance();
		if (frameworkParameters.getStopExecution()) {
			tearDownTestSuite();

			// Throwing TestNG SkipException within a configuration method
			// causes all subsequent test methods to be skipped/aborted
			throw new SkipException("Test execution terminated by user! All subsequent tests aborted...");
		} else {
			currentScenario = this.getClass().getPackage().getName().substring(12);
			currentTestcase = this.getClass().getSimpleName();
		}
	}

	/**
	 * Function to do the required framework teardown activities after executing
	 * each test case
	 * 
	 * @param testParameters
	 *            The {@link SeleniumTestParameters} object passed from the test
	 *            case
	 * @param driverScript
	 *            The {@link DriverScript} object passed from the test case
	 */

	public static List<String> failedTestCase = new ArrayList<String>();
	public static String currentPacakage;

	protected synchronized void tearDownTestRunner(SeleniumTestParameters testParameters, DriverScript driverScript) {
		String testReportName = driverScript.getReportName();
		String executionTime = driverScript.getExecutionTime();
		String testStatus = driverScript.getTestStatus();

		resultSummaryManager.updateResultSummary(testParameters, testReportName, executionTime, testStatus);	

		if ("Failed".equalsIgnoreCase(testStatus)) {
			currentPacakage = testParameters.getCurrentScenario();
			failedTestCase.add("testscripts." + testParameters.getCurrentScenario() + "." + testParameters.getCurrentTestcase());
			properties = Settings.getInstance();
			if(getCounter()<Integer.parseInt(properties.getProperty("ReRunTimes"))) {
				Assert.fail(driverScript.getFailureDescription());				
			} else if((getCounter()==Integer.parseInt(properties.getProperty("ReRunTimes")))) {
				if(properties.get("DefectLogging").equals("True")) {
					//sResponseMessage = DefectFiling.searchDefect(testParameters.getCurrentTestDescription());		
					sResponseMessage = CreateDefectTFS.searchBugInTFS(testParameters.getCurrentTestDescription());					
					if(sResponseMessage==false) {
						System.out.println("Defect doesn't exists:::");						
						/*sResponseMessage = DefectFiling.createDefect(currentPacakage + "_" + testParameters.getCurrentTestcase() + "-" +testParameters.getCurrentTestDescription(), 
								testParameters.getCurrentTestDescription() + "_" + driverScript.getFailureDescription());*/
						sResponseMessage = CreateDefectTFS.createBugInTFS(currentPacakage + "_" + testParameters.getCurrentTestcase() + "-" +testParameters.getCurrentTestDescription(), 
								testParameters.getCurrentTestDescription() + "_" + driverScript.getFailureDescription());
								if(sResponseMessage==false) 
									System.out.println("Defect filing failed to log the defect for the issue:::" + driverScript.getFailureDescription());
								else if (sResponseMessage==true)
							System.out.println("Defect filed successfully for the issue:::" + testParameters.getCurrentTestcase() + "-" + driverScript.getFailureDescription());
					} else if(sResponseMessage==true) {
						System.out.println("Defect already exists, no need to log a new defect:::");						
					}
				} else {
					System.out.println("Defect logging feature disabled:::");						
				}
				Assert.fail(driverScript.getFailureDescription());
			}						
		}
	}

	/**
	 * Function to do the required framework teardown activities after executing
	 * the overall test suite
	 */

	@AfterSuite(alwaysRun = true)
	public void tearDownTestSuite() {
		resultSummaryManager.wrapUp(true);
		try {
			if(getCounter()<Integer.parseInt(System.getProperty("ReRunTimes"))) {
				System.out.println("ReRunCount is set as per the value passed from Jenkin:::");
				updateReRun();
				updateCounter();
				XmlGenerator.reRunFailedTestCases();
			}
		} catch(Exception e) {
			properties = Settings.getInstance();
			if(getCounter()<Integer.parseInt(properties.getProperty("ReRunTimes"))){
				updateReRun();
				updateCounter();
				XmlGenerator.reRunFailedTestCases();
			}		
		}
	}

	@DataProvider(name = "GlobalTestConfigurations", parallel = true)
	public Object[][] dataGlobal() {
		return new Object[][] { { "Instance4", ExecutionMode.LOCAL, MobileToolName.APPIUM,
			MobileExecutionPlatform.ANDROID, "4.4", "N/A", Browser.FIREFOX, Platform.WINDOWS } };
	}
}