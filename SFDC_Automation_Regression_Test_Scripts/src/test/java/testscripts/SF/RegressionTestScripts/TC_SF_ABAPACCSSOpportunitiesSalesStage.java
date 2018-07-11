package testscripts.SF.RegressionTestScripts;

import org.openqa.selenium.Platform;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.cognizant.Craft.CRAFTTestCase;
import com.cognizant.Craft.DriverScript;
import com.cognizant.framework.IterationOptions;
import com.cognizant.framework.selenium.ExecutionMode;
import com.cognizant.framework.selenium.SeleniumTestParameters;

/**
 * Function for validating the Sales Stage Value on Opportunity page layout
 * 
 * @author Haritha
 */

public class TC_SF_ABAPACCSSOpportunitiesSalesStage extends CRAFTTestCase {
	
		@Test(groups= {"REGRESSION","API","Support Staff","Opportunities","Picklist value"},dataProvider = "RegressionTestScripts")
		public void runTC_SF_ABAPACCSSOpportunitiesSalesStage(String testInstance, ExecutionMode executionMode, Platform platform
				/*MobileToolName mobileToolName,
				MobileExecutionPlatform executionPlatform, String deviceName*/)
		{
			SeleniumTestParameters testParameters = new SeleniumTestParameters(currentScenario, currentTestcase);
			testParameters.setCurrentTestDescription("Test for validating the Sales Stage Value on Opportunity page layout");
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
