package testscripts.SF.Release38TestScripts;


import org.openqa.selenium.Platform;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.cognizant.framework.IterationOptions;
import com.cognizant.framework.selenium.Browser;
import com.cognizant.framework.selenium.ExecutionMode;
import com.cognizant.framework.selenium.SeleniumTestParameters;

import com.cognizant.Craft.*;
/**
 * Validating the Opportunities Quick create Page for the Net Fee Field Mandatory when the Sales Stage is set to closed
 * 
 * @author Ramya
 *
 */

public class TC_SF_OBAMERManagerOpportunitiesNetFeeFieldMandatory extends CRAFTTestCase {
	@Test(dataProvider = "RegressionTestScripts")
	public void runTC_SF_OBAMERManagerOpportunitiesNetFeeFieldMandatory(String testInstance, ExecutionMode executionMode, Platform platform
			/*MobileToolName mobileToolName,
			MobileExecutionPlatform executionPlatform, String deviceName*/)
	{
		SeleniumTestParameters testParameters = new SeleniumTestParameters(currentScenario, currentTestcase);
		testParameters.setCurrentTestDescription("Test for Validating the Opportunities Quick create Page for the Net Fee Field Mandatory when the Sales Stage is set to closed");
		testParameters.setIterationMode(IterationOptions.RUN_ONE_ITERATION_ONLY);
		testParameters.setBrowser(Browser.CHROME);
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



































