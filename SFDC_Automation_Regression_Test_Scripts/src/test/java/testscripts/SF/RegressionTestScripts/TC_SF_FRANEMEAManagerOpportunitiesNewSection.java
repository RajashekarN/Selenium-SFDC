package testscripts.SF.RegressionTestScripts;

import org.openqa.selenium.Platform;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.cognizant.Craft.CRAFTTestCase;
import com.cognizant.Craft.DriverScript;
import com.cognizant.framework.IterationOptions;
import com.cognizant.framework.selenium.Browser;
import com.cognizant.framework.selenium.ExecutionMode;
import com.cognizant.framework.selenium.SeleniumTestParameters;

	
/**
 * Test Script for validating the Mandate Field on the Opportunities Page for France Manager profile
 * 
 * @author Haritha
 *
 */


public class TC_SF_FRANEMEAManagerOpportunitiesNewSection extends CRAFTTestCase{
	@Test(groups= {"REGRESSION","API","Manager","Opportunity","New Section"},dataProvider = "RegressionTestScripts")
	public void runTC_SF_FRANEMEAManagerOpportunitiesNewSection(String testInstance, ExecutionMode executionMode, Platform platform
			/*MobileToolName mobileToolName,
			MobileExecutionPlatform executionPlatform, String deviceName*/)
	{

		
		SeleniumTestParameters testParameters = new SeleniumTestParameters(currentScenario, currentTestcase);
		testParameters.setCurrentTestDescription("Test Script for validating the Opportunities New Section");
		testParameters.setIterationMode(IterationOptions.RUN_ONE_ITERATION_ONLY);
		testParameters.setBrowser(Browser.CHROME);
		testParameters.setExecutionMode(executionMode);
		testParameters.setPlatform(platform);
		DriverScript driverScript = new DriverScript(testParameters);		
		driverScript.driveTestExecution();
		tearDownTestRunner(testParameters, driverScript);
		
		
	}
	
	private void runDriverScript(DriverScript driverScript, SeleniumTestParameters testParameters){
		driverScript.setIsAPITest(true);
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