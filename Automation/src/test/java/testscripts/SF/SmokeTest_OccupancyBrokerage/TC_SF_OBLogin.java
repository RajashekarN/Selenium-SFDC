package testscripts.SF.SmokeTest_OccupancyBrokerage;

import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.cognizant.framework.IterationOptions;
import com.cognizant.framework.selenium.Browser;

import supportlibraries.DriverScript;
import supportlibraries.TestCase;


/**
 * Test Script for validating the Login functionality
 * 
 * @author Vishnuvardhan
 *
 */
public class TC_SF_OBLogin extends TestCase
{
	@Test(groups = {"SF SmokeTestScripts" , "Salesforce Portal"})
	@Parameters("environment")
	public void runTC_SF_OBLogin(@Optional("Sandbox") String environment)
	{
		testParameters.setCurrentTestDescription("Test for logging into Salesforce Portal as Occupier Brokerage");
		testParameters.setIterationMode(IterationOptions.RUN_ONE_ITERATION_ONLY);
		testParameters.setBrowser(Browser.CHROME);
		
		driverScript = new DriverScript(testParameters);
		driverScript.setEnv(environment);
		driverScript.setClient("SF");

		driverScript.driveTestExecution();

	}
}