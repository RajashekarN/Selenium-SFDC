package testscripts.SF.SmokeTest_API;

import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.cognizant.framework.selenium.SeleniumTestParameters;

import supportlibraries.DriverScript;
import supportlibraries.TestCase;

public class TC_SF_API_Opportunities  extends TestCase  {

	@Test(groups = { "SF API_Test", "Salesforce Portal API Test Scripts" })
	@Parameters("environment")
	public void run_TC_SF_API_Opportunities(@Optional("Sandbox") String environment) {
		driverScript = new DriverScript(testParameters);
		String purpose = "Test API Opportunities related functions for Salesforce Portal";
		runDriverScript( driverScript, testParameters, environment, purpose );
	}
	private void runDriverScript(DriverScript driverScript, SeleniumTestParameters testParameters, String environment, String purpose){
		testParameters.setCurrentTestDescription(purpose);
		driverScript.setAPITestFlag(true);
		driverScript.setEnv(environment);
		driverScript.setClient("SF");
		driverScript.driveTestExecution();
	}
}
