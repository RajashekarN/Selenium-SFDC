package com.cognizant.Craft;

import com.cognizant.framework.FrameworkParameters;
import com.cognizant.framework.selenium.*;

import runners.Allocator;

import java.util.HashMap;

import org.openqa.selenium.Platform;
import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.SkipException;
import org.testng.annotations.AfterMethod;
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
	public static int testStatus_Success;

	public static int getTestStatus_Success() {
		return testStatus_Success;
	}

	public static void setTestStatus_Success(int testStatus_Success) {
		CRAFTTestCase.testStatus_Success = testStatus_Success;
	}

	public static int testStatus_Fail;
	public static int getTestStatus_Fail() {
		return testStatus_Fail;
	}

	public static void setTestStatus_Fail(int testStatus_Fail) {
		CRAFTTestCase.testStatus_Fail = testStatus_Fail;
	}

	public static int testStatus_Skip;
	public static int getTestStatus_Skip() {
		return testStatus_Skip;
	}

	public static void setTestStatus_Skip(int testStatus_Skip) {
		CRAFTTestCase.testStatus_Skip = testStatus_Skip;
	}

	/**
	 * The current scenario
	 */
	protected String currentScenario;
	/**
	 * The current test case
	 */
	protected String currentTestcase;

	private ResultSummaryManager resultSummaryManager = ResultSummaryManager
			.getInstance();

	/**
	 * Function to do the required framework setup activities before executing
	 * the overall test suite
	 * 
	 * @param testContext
	 *            The TestNG {@link ITestContext} of the current test suite
	 */
	@BeforeSuite
	public void setUpTestSuite(ITestContext testContext) {
		resultSummaryManager.setRelativePath();
		resultSummaryManager.initializeTestBatch(testContext.getSuite()
				.getName());

		int nThreads;
		if ("false".equalsIgnoreCase(testContext.getSuite().getParallel())) {
			nThreads = 1;
		} else {
			nThreads = testContext.getCurrentXmlTest().getThreadCount();
		}

		// Note: Separate threads may be spawned through usage of DataProvider
		// testContext.getSuite().getXmlSuite().getDataProviderThreadCount();
		// This will be at test case level (multiple instances on same test case
		// in parallel)
		// This level of threading will not be reflected in the summary report

		resultSummaryManager.initializeSummaryReport(nThreads);
		resultSummaryManager.setupErrorLog();
	}

	/**
	 * Function to do the required framework setup activities before executing
	 * each test case
	 */
	@BeforeMethod
	public void setUpTestRunner() {
		FrameworkParameters frameworkParameters = FrameworkParameters
				.getInstance();
		if (frameworkParameters.getStopExecution()) {
			tearDownTestSuite();

			// Throwing TestNG SkipException within a configuration method
			// causes all subsequent test methods to be skipped/aborted
			throw new SkipException(
					"Test execution terminated by user! All subsequent tests aborted...");
		} else {
			currentScenario = this.getClass().getPackage().getName()
					.substring(12);
			currentTestcase = this.getClass().getSimpleName();
		}
	}

	@AfterMethod
	public void fetchMostRecentTestResult(ITestResult result) {
	    int status = result.getStatus();
	    switch (status) {
	        case ITestResult.SUCCESS:
	        	testStatus_Success++;
	            break;
	        case ITestResult.FAILURE:
	        	testStatus_Fail++;
	            break;
	        case ITestResult.SKIP:
	        	testStatus_Skip++;
	            break;
	        default:
	            throw new RuntimeException("Invalid Status");
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
	protected synchronized void tearDownTestRunner(
			SeleniumTestParameters testParameters, DriverScript driverScript) {
		String testReportName = driverScript.getReportName();
		String executionTime = driverScript.getExecutionTime();
		String testStatus = driverScript.getTestStatus();

		resultSummaryManager.updateResultSummary(testParameters,
				testReportName, executionTime, testStatus);

		if ("Failed".equalsIgnoreCase(testStatus)) {
			Assert.fail(driverScript.getFailureDescription());
		}
	}

	/**
	 * Function to do the required framework teardown activities after executing
	 * the overall test suite
	 */
	@AfterSuite
	public void tearDownTestSuite() {		
		resultSummaryManager.wrapUp(true);
		//resultSummaryManager.copyReportsFolder();
	}
 

	@DataProvider(name = "GlobalTestConfigurations", parallel = true)
	public Object[][] dataGlobal() {
		return new Object[][] { { "Instance4", ExecutionMode.LOCAL,
				MobileToolName.APPIUM, MobileExecutionPlatform.ANDROID, "4.4",
				"N/A", Browser.FIREFOX, Platform.WINDOWS } };
	}
}