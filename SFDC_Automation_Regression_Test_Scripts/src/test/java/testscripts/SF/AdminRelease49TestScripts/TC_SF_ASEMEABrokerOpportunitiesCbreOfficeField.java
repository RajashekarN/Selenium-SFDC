package testscripts.SF.AdminRelease49TestScripts;

import org.openqa.selenium.Platform;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.cognizant.Craft.CRAFTTestCase;
import com.cognizant.Craft.DriverScript;
import com.cognizant.framework.IterationOptions;
import com.cognizant.framework.selenium.ExecutionMode;
import com.cognizant.framework.selenium.SeleniumTestParameters;

	
	/**
	 * Test Script for validating the CBRE office picklist value for Asset service profile
	 * 
	 * @author Haritha
	 *
	 */

public class TC_SF_ASEMEABrokerOpportunitiesCbreOfficeField  extends CRAFTTestCase
	{
		@Test(groups= {"REGRESSION","API","Broker","Opportunity","Layout"},dataProvider = "RegressionTestScripts")
		public void runTC_SF_ASEMEABrokerOpportunitiesCbreOfficeField(String testInstance, ExecutionMode executionMode, Platform platform
				/*MobileToolName mobileToolName,
				MobileExecutionPlatform executionPlatform, String deviceName*/)
		{
			SeleniumTestParameters testParameters = new SeleniumTestParameters(currentScenario, currentTestcase);
			testParameters.setCurrentTestDescription("Validating the CBRE office picklist value for Asset service profile");
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
		
		@DataProvider(name = "RegressionTestScripts", parallel = false)
		public Object[][] dataTC2() {
			return new Object[][] { { "Instance1", ExecutionMode.LOCAL, Platform.WINDOWS /*ExecutionMode.LOCAL,
					MobileToolName.APPIUM, MobileExecutionPlatform.IOS,
					"4d005cb2c4938197"*/ },
			};
		}

}
