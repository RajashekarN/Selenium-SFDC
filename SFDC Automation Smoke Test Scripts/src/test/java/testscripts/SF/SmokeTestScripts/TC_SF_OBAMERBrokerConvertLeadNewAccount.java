package testscripts.SF.SmokeTestScripts;

import org.openqa.selenium.Platform;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import com.cognizant.Craft.CRAFTTestCase;
import com.cognizant.framework.IterationOptions;
import com.cognizant.framework.selenium.Browser;
import com.cognizant.framework.selenium.ExecutionMode;
import com.cognizant.framework.selenium.SeleniumTestParameters;

import com.cognizant.Craft.*;
/**
 * Test Script to do the ConvertLead by adding the new account in the Convert Lead page
 * 
 * @author Vishnuvardhan
 *
 */

public class TC_SF_OBAMERBrokerConvertLeadNewAccount extends CRAFTTestCase
{
	@Test(dataProvider = "SmokeTestScripts")
	public void runTC_SF_OBAMERBrokerConvertLeadNewAccount(String testInstance, ExecutionMode executionMode, Platform platform
			/*MobileToolName mobileToolName,
			MobileExecutionPlatform executionPlatform, String deviceName*/)
	{
		SeleniumTestParameters testParameters = new SeleniumTestParameters(currentScenario, currentTestcase);
		testParameters.setCurrentTestDescription("Test to do the ConvertLead by adding the new account in the Convert Lead page");
		testParameters.setIterationMode(IterationOptions.RUN_ONE_ITERATION_ONLY);
		testParameters.setBrowser(Browser.CHROME);
		testParameters.setExecutionMode(executionMode);
		testParameters.setPlatform(platform);
		DriverScript driverScript = new DriverScript(testParameters);
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



