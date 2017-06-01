package testscripts.SF.Release37TestScripts;


import org.openqa.selenium.Platform;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.cognizant.framework.IterationOptions;
import com.cognizant.framework.selenium.Browser;
import com.cognizant.framework.selenium.ExecutionMode;
import com.cognizant.framework.selenium.SeleniumTestParameters;

import com.cognizant.Craft.*;
/**
 * Validating the Quick create Opportunities page from the Opportunities page for the Reasons for Loss pick list values
 * 
 * @author Ramya
 *
 */

public class TC_SF_ASAMERManagerOpportunitiesVerifyingCapitalMarketsRevenueField extends CRAFTTestCase {
	@Test(dataProvider = "RegressionTestScripts")
	public void runTC_SF_ASAMERManagerOpportunitiesVerifyingCapitalMarketsRevenueField(String testInstance, ExecutionMode executionMode, Platform platform
			/*MobileToolName mobileToolName,
			MobileExecutionPlatform executionPlatform, String deviceName*/)
	{
		SeleniumTestParameters testParameters = new SeleniumTestParameters(currentScenario, currentTestcase);
		testParameters.setCurrentTestDescription("Test for validating the Creation of Activity for Contacts");
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

