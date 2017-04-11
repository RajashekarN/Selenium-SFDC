package supportlibraries;

import java.io.File;
import java.util.Arrays;
import java.util.Date;
import java.util.Properties;

import com.cognizant.framework.FrameworkParameters;
import com.cognizant.framework.Settings;
import com.cognizant.framework.TimeStamp;
import com.cognizant.framework.Util;
import com.cognizant.framework.selenium.*;

//import supportlibraries.api.JunitFailureResultHelper;

import org.testng.ITestContext;
import org.testng.SkipException;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

/**
 * Abstract base class for all the test cases to be automated
 * 
 * @author Cognizant
 */
public abstract class TestCase {
	/**
	 * The {@link SeleniumTestParameters} object to be used to specify the test
	 * parameters
	 */
	protected SeleniumTestParameters testParameters;
	protected SeleniumTestParameters testReportName;

	/**
	 * The {@link DriverScript} object to be used to execute the required test
	 * case
	 */
	protected DriverScript driverScript;

	private ResultSummaryManager resultSummaryManager = new ResultSummaryManager();
	private Date startTime, endTime;

	/**
	 * Function to do the required set-up activities before executing the
	 * overall test suite in TestNG
	 * 
	 * @param testContext
	 *            The TestNG {@link ITestContext} of the current test suite
	 */
	@BeforeSuite(alwaysRun = true)
	@Parameters("reportPath")
	public void suiteSetup(ITestContext testContext, @Optional("") String reportPath) {
//		String ENV = 
//		if(ENV.equals("")){
//			System.setProperty("envirnoment", "");
//		}else{
//			ENV = ENV  + " : ";
//		}
		resultSummaryManager.setRelativePath();
		resultSummaryManager.initializeTestBatch(System.getProperty("environment", "BETA").toUpperCase() + " - " + testContext.getSuite().getName());

		if(reportPath.equals("")){
			System.setProperty("ReportPath", TimeStamp.getInstance());
		}else{
		System.setProperty("ReportPath", reportPath);
		File file = new File(System.getProperty("ReportPath"));
		if(!file.exists()){
			if (!file.mkdirs()) {
				System.out.println("Failed to create directory! : " + reportPath);
			}
		}
		}
		

		int nThreads;
		if (testContext.getSuite().getParallel().equalsIgnoreCase("false")) {
			nThreads = 1;
		} else {
			nThreads = testContext.getCurrentXmlTest().getThreadCount();
		}
		resultSummaryManager.initializeSummaryReport(nThreads);
		resultSummaryManager.setupErrorLog();
	}

	/**
	 * Function to do the required set-up activities before executing each test
	 * case in TestNG
	 */
	@BeforeMethod(alwaysRun = true)
	public void testMethodSetup() {
		FrameworkParameters frameworkParameters = FrameworkParameters.getInstance();
		if (frameworkParameters.getStopExecution()) {
			suiteTearDown();

			throw new SkipException("Aborting all subsequent tests!");
		} else {
			startTime = Util.getCurrentTime();

			String currentScenario = capitalizeFirstLetter(this.getClass().getPackage().getName().substring(12));
			String currentTestcase = this.getClass().getSimpleName();
			testParameters = new SeleniumTestParameters(currentScenario, currentTestcase);
		}
	}

	private String capitalizeFirstLetter(String myString) {
		StringBuilder stringBuilder = new StringBuilder(myString);
		stringBuilder.setCharAt(0, Character.toUpperCase(stringBuilder.charAt(0)));
		return stringBuilder.toString();
	}

	/**
	 * Function to do the required wrap-up activities after executing each test
	 * case in TestNG
	 */
	@AfterMethod(alwaysRun = true)
	public void testMethodTearDown() {
		String testStatus = driverScript.getTestStatus();
		endTime = Util.getCurrentTime();
		String executionTime = Util.getTimeDifference(startTime, endTime);
		/*resultSummaryManager.updateResultSummary(testParameters,
				testReportName.toString(), executionTime, testStatus);*/
	}

	/**
	 * Function to do the required wrap-up activities after executing the
	 * overall test suite in TestNG
	 */
	@AfterSuite(alwaysRun = true)
	public void suiteTearDown() {
		resultSummaryManager.wrapUp(true);
//		 resultSummaryManager.launchResultSummary()
		Properties 	properties = Settings.getInstance();
		
		if(properties.getProperty("ZipReport").equalsIgnoreCase("True")){
/*			try{
			new JunitFailureResultHelper(System.getProperty("ReportPath")).GenerateHTMLReport();
			Utility_Functions.ZipResults(System.getProperty("ReportPath"));
			}catch(Exception e){
				e.printStackTrace();
			}*/
			/*try{
			if(!(ReusableLibrary.teamMessage.size() ==0 ))
				new MailHelper().sendMail(properties.getProperty("AutomationMail"), Arrays.toString(ReusableLibrary.teamMessage.toArray()).replace("[", "").replace("]", ""));
			}catch(Exception e){
				e.printStackTrace();
			}*/
				
		}

//		}
	}
}