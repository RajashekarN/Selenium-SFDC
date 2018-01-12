package testscripts.SF.SmokeTest_API;

import org.openqa.selenium.Platform;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import com.cognizant.Craft.CRAFTTestCase;
import com.cognizant.framework.IterationOptions;
import com.cognizant.framework.selenium.Browser;
import com.cognizant.framework.selenium.ExecutionMode;
import com.cognizant.framework.selenium.SeleniumTestParameters;

/*import supportlibraries.DriverScript;
import supportlibraries.TestCase;*/

import com.cognizant.Craft.*;
/**
 * Test Script for validating the Permission Sets
 * 
 * @author Vishnuvardhan
 *
 */
public class TC_SF_API_Admin_UpdateRoleProfile extends CRAFTTestCase
{
	@Test(groups= {"SMOKE","API","Admin","Role"},dataProvider = "SmokeTestScripts")
	public void runTC_SF_API_Admin_UpdateRoleProfile(String testInstance, ExecutionMode executionMode, Platform platform
			/*MobileToolName mobileToolName,
			MobileExecutionPlatform executionPlatform, String deviceName*/)
	{
		SeleniumTestParameters testParameters = new SeleniumTestParameters(currentScenario, currentTestcase);
		testParameters.setCurrentTestDescription("Test scripts for validating the Permission Sets");
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

