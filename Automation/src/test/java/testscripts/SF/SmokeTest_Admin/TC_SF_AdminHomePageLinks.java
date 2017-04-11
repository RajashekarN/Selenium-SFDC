package testscripts.SF.SmokeTest_Admin;

import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.cognizant.framework.IterationOptions;
import com.cognizant.framework.selenium.Browser;

import supportlibraries.DriverScript;
import supportlibraries.TestCase;


/* *
 * Test for login with valid user credentials
 * @author Cognizant
 */
public class TC_SF_AdminHomePageLinks extends TestCase
{
	@Test(groups = {"SF SmokeTestScripts" , "Salesforce Portal"})
	@Parameters("environment")
	public void runTC_SF_AdminHomePageLinks(@Optional("Sandbox") String environment)
	{
		testParameters.setCurrentTestDescription("Test for validating the links present in Home Page by logging as Admin");
		testParameters.setIterationMode(IterationOptions.RUN_ONE_ITERATION_ONLY);
		testParameters.setBrowser(Browser.CHROME);
		
		driverScript = new DriverScript(testParameters);
		driverScript.setEnv(environment);
		driverScript.setClient("SF");

		driverScript.driveTestExecution();

	}
}