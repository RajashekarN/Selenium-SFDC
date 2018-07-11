package testscripts.SF.Release50TestScripts;

import org.openqa.selenium.Platform;
import org.testng.annotations.Test;

import com.cognizant.Craft.CRAFTTestCase;
import com.cognizant.Craft.DriverScript;
import com.cognizant.framework.IterationOptions;
import com.cognizant.framework.selenium.Browser;
import com.cognizant.framework.selenium.ExecutionMode;
import com.cognizant.framework.selenium.SeleniumTestParameters;

public class TC_SF_GlobalAdminValidateUOMForUserAndCountry extends CRAFTTestCase{

	@Test(groups= {"Regression"})
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
}
