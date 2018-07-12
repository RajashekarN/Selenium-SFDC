/*package testscripts.SF.Release50TestScripts;

import org.openqa.selenium.Platform;
import org.testng.annotations.Test;

import com.cognizant.Craft.CRAFTTestCase;
import com.cognizant.Craft.DriverScript;
import com.cognizant.framework.IterationOptions;
import com.cognizant.framework.selenium.Browser;
import com.cognizant.framework.selenium.ExecutionMode;
import com.cognizant.framework.selenium.SeleniumTestParameters;

public class TC_SF_GlobalAdminValidateUOMForUserAndCountry extends CRAFTTestCase{

	@Test(groups= {"Regression","UI","UOM","Users"})
	public void runTC_SF_GlobalAdminValidateUOMForUserAndCountry(String testInstance, ExecutionMode executionMode, Platform platform)
	{
		SeleniumTestParameters testParameters = new SeleniumTestParameters(currentScenario, currentTestcase);
		testParameters.setCurrentTestDescription("Validating Unit of measurement for User and Country");
		testParameters.setIterationMode(IterationOptions.RUN_ONE_ITERATION_ONLY);
		testParameters.setBrowser(Browser.CHROME);
		testParameters.setExecutionMode(executionMode);
		testParameters.setPlatform(platform);
		
		DriverScript driverScript = new DriverScript(testParameters);
		driverScript.driveTestExecution();
		tearDownTestRunner(testParameters, driverScript);
	}
}*/

package testscripts.SF.Release50TestScripts;

import org.openqa.selenium.Platform;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import com.cognizant.framework.IterationOptions;
import com.cognizant.framework.selenium.ExecutionMode;
import com.cognizant.framework.selenium.SeleniumTestParameters;

import com.cognizant.Craft.*;

/**
 * Test Script for validating Unit of Measurement for Countries and Users
 * When UOM for a country is changed, all the users belonging to that country should also have their UOM value updated
 * When the country of a User is changed, the UOM value of the user should get updated accordingly
 * 
 * @author SChandran
 *
 */


public class TC_SF_GlobalAdminValidateUOMForUserAndCountry extends CRAFTTestCase
{
	@Test(groups= {"Regression","UI","Users","UOM"},dataProvider = "RegressionTestScripts")
	public void runTC_SF_GlobalAdminValidateUOMForUserAndCountry(String testInstance, ExecutionMode executionMode, Platform platform)
	{
		SeleniumTestParameters testParameters = new SeleniumTestParameters(currentScenario, currentTestcase);
		testParameters.setCurrentTestDescription("Test for validating Unit of Measurement for Users and Countries");
		testParameters.setIterationMode(IterationOptions.RUN_ONE_ITERATION_ONLY);
		testParameters.setExecutionMode(executionMode);
		testParameters.setPlatform(platform);
		DriverScript driverScript = new DriverScript(testParameters);
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