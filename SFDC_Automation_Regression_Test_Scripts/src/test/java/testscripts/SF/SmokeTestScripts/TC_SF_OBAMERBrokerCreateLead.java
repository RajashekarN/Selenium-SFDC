package testscripts.SF.SmokeTestScripts;

import org.openqa.selenium.Platform;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import com.cognizant.framework.IterationOptions;
import com.cognizant.framework.selenium.ExecutionMode;
import com.cognizant.framework.selenium.SeleniumTestParameters;
import com.cognizant.Craft.*;
/**
 * Test Script for validating the Lead Creation and for verifying the elements present in Lead Related tab
 * 
 * @author Vishnuvardhan
 *
 */

public class TC_SF_OBAMERBrokerCreateLead extends CRAFTTestCase
{
	@Test(groups= {"SMOKE","API","Broker","Lead","Create"},dataProvider = "SmokeTestScripts")
	public void runTC_SF_OBAMERBrokerCreateLead(String testInstance, ExecutionMode executionMode, Platform platform
			/*MobileToolName mobileToolName,
			MobileExecutionPlatform executionPlatform, String deviceName*/)
	{
		SeleniumTestParameters testParameters = new SeleniumTestParameters(currentScenario, currentTestcase);
		testParameters.setCurrentTestDescription("Test for validating the Lead Creation and for verifying the elements present in Lead Related tab");
		testParameters.setIterationMode(IterationOptions.RUN_ONE_ITERATION_ONLY);
		testParameters.setExecutionMode(executionMode);
		testParameters.setPlatform(platform);
		DriverScript driverScript = new DriverScript(testParameters);		
		driverScript = new DriverScript(testParameters);
		runDriverScript(driverScript, testParameters);
	}

	private void runDriverScript(DriverScript driverScript, SeleniumTestParameters testParameters){
		driverScript.setIsAPITest(true);
		driverScript.driveTestExecution();
		tearDownTestRunner(testParameters, driverScript);
	}
	
	@DataProvider(name = "SmokeTestScripts", parallel = false)
	public Object[][] dataTC2() {
		return new Object[][] { { "Instance1", ExecutionMode.LOCAL, Platform.WINDOWS /*ExecutionMode.LOCAL,
				MobileToolName.APPIUM, MobileExecutionPlatform.IOS,
				"4d005cb2c4938197"*/ },
		};
	}

}