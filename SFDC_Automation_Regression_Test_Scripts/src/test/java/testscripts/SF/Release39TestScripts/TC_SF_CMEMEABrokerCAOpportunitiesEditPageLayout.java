package testscripts.SF.Release39TestScripts;


import org.openqa.selenium.Platform;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.cognizant.framework.IterationOptions;
import com.cognizant.framework.selenium.Browser;
import com.cognizant.framework.selenium.ExecutionMode;
import com.cognizant.framework.selenium.SeleniumTestParameters;

import com.cognizant.Craft.*;
/**
 * Validating the Opportunities Edit Page layout
 * 
 * @author Ramya
 *
 */

public class TC_SF_CMEMEABrokerCAOpportunitiesEditPageLayout extends CRAFTTestCase {
	@Test(dataProvider = "RegressionTestScripts")
	public void runTC_SF_CMEMEABrokerCAOpportunitiesEditPageLayout(String testInstance, ExecutionMode executionMode, Platform platform
			/*MobileToolName mobileToolName,
			MobileExecutionPlatform executionPlatform, String deviceName*/)
	{
		SeleniumTestParameters testParameters = new SeleniumTestParameters(currentScenario, currentTestcase);
		testParameters.setCurrentTestDescription("Test for Validating the Opportunities edit page layout");
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







































