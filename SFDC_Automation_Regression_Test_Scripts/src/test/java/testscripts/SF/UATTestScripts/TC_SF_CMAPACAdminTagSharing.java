package testscripts.SF.UATTestScripts;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.openqa.selenium.Platform;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.cognizant.Craft.CRAFTTestCase;
import com.cognizant.Craft.DriverScript;
import com.cognizant.Craft.ReusableLibrary;
import com.cognizant.Craft.ScriptHelper;
import com.cognizant.framework.IterationOptions;
import com.cognizant.framework.selenium.Browser;
import com.cognizant.framework.selenium.ExecutionMode;
import com.cognizant.framework.selenium.SeleniumTestParameters;
import com.sforce.soap.partner.DeleteResult;
import com.sforce.soap.partner.SaveResult;
import com.sforce.soap.partner.sobject.SObject;

import supportLibraries.Utility_Functions;


public class TC_SF_CMAPACAdminTagSharing extends CRAFTTestCase{

	@Test(dataProvider = "UATTestScripts")
	public void runTC_SF_CMAPACAdminTagSharing(String testInstance, ExecutionMode executionMode, Platform platform
			/*MobileToolName mobileToolName,
			MobileExecutionPlatform executionPlatform, String deviceName*/)
	{
		SeleniumTestParameters testParameters = new SeleniumTestParameters(currentScenario, currentTestcase);
		testParameters.setCurrentTestDescription("Test for validating property preference fields");
		testParameters.setIterationMode(IterationOptions.RUN_ONE_ITERATION_ONLY);
		testParameters.setBrowser(Browser.CHROME);
		testParameters.setExecutionMode(executionMode);
		testParameters.setPlatform(platform);
		DriverScript driverScript = new DriverScript(testParameters);
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
