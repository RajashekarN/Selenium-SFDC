package testscripts.SF.SmokeTest_OccupancyBrokerage;

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
public class TC_SF_OBActivityLightningTimeline extends TestCase
{
	@Test(groups = {"SF SmokeTestScripts" , "Salesforce Portal"})
	@Parameters("environment")
	public void run_TC_SF_OBActivityLightningTimeline(@Optional("Sandbox") String environment)
	{
		testParameters.setCurrentTestDescription("Test for validating the Activity Lightning Timeline contacts page");
		testParameters.setIterationMode(IterationOptions.RUN_ONE_ITERATION_ONLY);
		testParameters.setBrowser(Browser.CHROME);
		
		driverScript = new DriverScript(testParameters);
		driverScript.setEnv(environment);
		driverScript.setClient("SF");

		driverScript.driveTestExecution();

	}
}