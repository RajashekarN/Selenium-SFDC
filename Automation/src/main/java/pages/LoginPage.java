package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.cognizant.framework.FrameworkException;
import com.cognizant.framework.Status;

import supportlibraries.ReusableLibrary;
import supportlibraries.ScriptHelper;
import supportlibraries.Utility_Functions;

/**
 * Page Object Class for Login Page
 * 
 * @author Vishnuvardhan
 *
 */

public class LoginPage extends ReusableLibrary {

	/*
	 * Constructor to initialize the business component library
	 * 
	 * @param scriptHelper The {@link ScriptHelper} object passed from the
	 * {@link DriverScript}
	 */
	public LoginPage(ScriptHelper scriptHelper) {
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
	
	@FindBy(xpath = "//div[@class='slds-context-bar oneGlobalNav']//span[text()='Home']")
	WebElement home_Tab;
	
	@FindBy(xpath = "//button[@class='bare slds-button uiButton forceHeaderButton oneUserProfileCardTrigger']")
	WebElement logOutButton;

	@FindBy(xpath = "//div[@class='profile-card-indent']//a[text()='Log Out']")
	WebElement logOut;
	
	@FindBy(xpath = "//a[text()='Continue']")
	WebElement continueLink;	
	

	/**
	 * Validating the browser launch functionality
	 * 
	 * @author Vishnuvardhan
	 *
	 */
	
	public void invokeApplication() {
		report.updateTestLog("Invoke Application",
				"Invoke the application under test @ " + properties.getProperty("ApplicationUrl"), Status.PASS);
		driver.get(properties.getProperty("ApplicationUrl"));
		Utility_Functions.timeWait(2);
	}
	
	/**
	 * Validating the Login functionality
	 * 
	 * @author Vishnuvardhan
	 *
	 */
	
	public void login() {
		try {
			Utility_Functions.xSendKeys(driver, txt_userName, dataTable.getData("General_Data", "Username"));
			Utility_Functions.timeWait(1);
			Utility_Functions.xSendKeys(driver, txt_password, dataTable.getData("General_Data", "Password"));
			Utility_Functions.timeWait(1);
			report.updateTestLog("Login", "Click the sign-in button", Status.PASS);
			Utility_Functions.xClick(driver, btn_LogIn, true);
			Utility_Functions.timeWait(1);
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
			if(continueLink.isDisplayed()) {
				Utility_Functions.xClick(driver, continueLink, true);
				report.updateTestLog("Scheduled Maintenance Window", "Clicking on continue link from the scheduled maintenance window", Status.PASS);
			} else {
				report.updateTestLog("Scheduled Maintenance Window", "Failed to click on continue link from the scheduled maintenance window", Status.FAIL);
			}			
		}
	}

	/**
	 * Validating the Login functionality
	 * 
	 * @author Vishnuvardhan
	 *
	 */
	
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
	
	/**
	 * Validating the logout functionality
	 * 
	 * @author Vishnuvardhan
	 *
	 */
	
	public void logout() {
		try {
			Utility_Functions.timeWait(2);
			Utility_Functions.xClick(driver, logOutButton, true);
			Utility_Functions.timeWait(1);
			Utility_Functions.xClick(driver, logOut, true);		
			report.updateTestLog("Verify Logout", "User has been logged out successfully:::",Status.PASS);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
