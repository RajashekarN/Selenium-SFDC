package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.cognizant.framework.FrameworkException;
import com.cognizant.framework.Status;

import supportlibraries.ReusableLibrary;
import supportlibraries.ScriptHelper;
import supportlibraries.Utility_Functions;

public class loginPage extends ReusableLibrary {

	/*
	 * Constructor to initialize the business component library
	 * 
	 * @param scriptHelper The {@link ScriptHelper} object passed from the
	 * {@link DriverScript}
	 */
	public loginPage(ScriptHelper scriptHelper) {
		super(scriptHelper);
		PageFactory.initElements(driver, this);
		// new WebDriverUtil(driver);
		utility = new Utility_Functions(scriptHelper);
	}

	@FindBy(id = "username")
	WebElement txt_userName;

	@FindBy(id = "password")
	WebElement txt_password;

	@FindBy(id = "Login")
	WebElement btn_LogIn;

	@FindBy(css = "#DATA > a.tabNoIco > span")
	WebElement menu_Data;
	
	@FindBy(xpath = "//*[text()='Home']")
	WebElement home_Tab;

	public void invokeApplication() {
		report.updateTestLog("Invoke Application",
				"Invoke the application under test @ " + properties.getProperty("ApplicationUrl"), Status.PASS);
		driver.get(properties.getProperty("ApplicationUrl"));
	}

	public void login() {
		try {
			Utility_Functions.xSendKeys(driver, txt_userName, dataTable.getData("General_Data", "Username"));
			Utility_Functions.xSendKeys(driver, txt_password, dataTable.getData("General_Data", "Password"));
			report.updateTestLog("Login", "Click the sign-in button", Status.PASS);
			Utility_Functions.xClick(driver, btn_LogIn, true);
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
		}
	}

	public void verifyLoginSuccessful() {
		Utility_Functions.timeWait(5);
		try {
			if (home_Tab.isDisplayed()) {
				report.updateTestLog("Verify Login", "Login is successful", Status.PASS);
			} else {
				frameworkParameters.setStopExecution(true);
				throw new FrameworkException("Verify Login", "Login failed");
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
		}
	}
}
