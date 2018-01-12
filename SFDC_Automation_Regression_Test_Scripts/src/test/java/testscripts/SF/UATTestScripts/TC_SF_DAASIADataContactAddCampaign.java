package testscripts.SF.UATTestScripts;


import org.openqa.selenium.Platform;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import com.cognizant.framework.IterationOptions;
import com.cognizant.framework.selenium.ExecutionMode;
import com.cognizant.framework.selenium.SeleniumTestParameters;
import com.cognizant.Craft.*;
/**
 * Validating the Lead tagging with private tag
 * 
 * @author Vishnu
 *
 */

public class TC_SF_DAASIADataContactAddCampaign extends CRAFTTestCase {
	@Test(groups= {"UAT","API","DataAdmin","Contact","Campaign"},dataProvider = "UATTestScripts")
	public void runTC_SF_DAASIADataContactAddCampaign(String testInstance, ExecutionMode executionMode, Platform platform
			/*MobileToolName mobileToolName,
			MobileExecutionPlatform executionPlatform, String deviceName*/)
	{
		SeleniumTestParameters testParameters = new SeleniumTestParameters(currentScenario, currentTestcase);
		testParameters.setCurrentTestDescription("Test for the validating the Leads creation and available sections");
		testParameters.setIterationMode(IterationOptions.RUN_ONE_ITERATION_ONLY);
		testParameters.setExecutionMode(executionMode);
		testParameters.setPlatform(platform);
		DriverScript driverScript = new DriverScript(testParameters);		
		driverScript = new DriverScript(testParameters);
		runDriverScript(driverScript, testParameters);
	}

	private void runDriverScript(DriverScript driverScript, SeleniumTestParameters testParameters){
		driverScript.setIsAPITest(true);
		driverScript.driveTestExecution();
		tearDownTestRunner(testParameters, driverScript);
	}
	
	@DataProvider(name = "UATTestScripts", parallel = false)
	public Object[][] dataTC2() {
		return new Object[][] { { "Instance1", ExecutionMode.LOCAL, Platform.WINDOWS /*ExecutionMode.LOCAL,
				MobileToolName.APPIUM, MobileExecutionPlatform.IOS,
				"4d005cb2c4938197"*/ },
		};
	}

}