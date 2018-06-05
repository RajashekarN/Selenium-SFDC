package pageObjects;

import java.util.ArrayList;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.cognizant.Craft.ReusableLibrary;
import com.cognizant.Craft.ScriptHelper;
import com.cognizant.framework.Status;

import supportLibraries.Utility_Functions;

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
		PageFactory.initElements(driver.getWebDriver(), this);
	}

	@FindBy(id = "username")
	WebElement txt_userName;

	@FindBy(id = "password")
	WebElement txt_password;

	@FindBy(id = "Login")
	WebElement btn_LogIn;

	@FindBy(xpath = "//div[@class='bBottom']//span[text()='Home']")
	WebElement menu_Home;

	@FindBy(xpath = "//button[contains(@class,'forceHeaderButton') and contains(@class,'oneUserProfileCardTrigger')]")
	WebElement logOutButton;

	@FindBy(xpath = "//div[contains(@class,'profile')]//a[contains(text(),'Log') and contains(text(),'Out')]")
	WebElement logOut;

	@FindBy(xpath = "//a[@class='continue'][text()='Continue']")
	WebElement continueLink;

	@FindBy(xpath = "//*[@id='userNavLabel']")
	WebElement userName;

	@FindBy(xpath = "//*[@id='userNav-menuItems']/a[text()='Switch to Lightning Experience']")
	WebElement switchLightningExperience;

	@FindBy(xpath = "//h2[@id='header']")
	WebElement changePasswordHeader;

	@FindBy(xpath = "//h2[@id='header'][text()='Change Your Password']")
	WebElement changeExpiredPasswordHeader;

	@FindBy(xpath = "//input[@id='currentpassword']")
	WebElement currentPassword;

	@FindBy(xpath = "//input[@id='newpassword']")
	WebElement newPassword;

	@FindBy(xpath = "//input[@id='confirmpassword']")
	WebElement confirmNewPassword;

	@FindBy(xpath = "//input[@id='answer']")
	WebElement securityAnswer;

	@FindBy(xpath = "//*[@id='password-button']")
	WebElement changePassword;

	@FindBy(xpath = "//div[@id='error']")
	WebElement errorMessage;

	@FindBy(xpath = "//a[@class='continue'][text()='Continue']")
	WebElement continueButtonMaiteinance;

	@FindBy(xpath = "//span[contains(text(),'Sandbox')]")
	WebElement sandbox;
	
	/**
	 * Validating the browser launch functionality
	 * 
	 * @author Vishnuvardhan
	 *
	 */

	// public String environment = properties.getProperty("RunEnvironment");
	public static String environment = System.getProperty("RunEnvironment");

	public String initializeEnvironment() {
		try {
			if (environment.equals(null)) {

			} /*
				 * else { System.out.
				 * println("Environment is set as per the parameters passed from Jenkins:::"
				 * + environment );
				 * report.updateTestLog("Intialize Environment",
				 * "Environment is set as per the parameters passed from Jenkins:::"
				 * , Status.PASS); }
				 */
		} catch (Exception e) {
			environment = properties.getProperty("RunEnvironment");
			System.out.println(
					"Environment is set as per the RunEnvironment value in Global Settings file:::" + environment);
		}
		return environment;
	}

	public void invokeApplication() {
		String environment = initializeEnvironment();
		report.updateTestLog("Invoke Application",
				"Invoke the application under test @ " + properties.getProperty("Application" + environment + "Url"),
				Status.PASS);
/*		if (environment.equals("UAT")) {
			driver.get(properties.getProperty("ApplicationUATUrl"));
		} else if (environment.equals("UAT2")) {
			driver.get(properties.getProperty("ApplicationUAT2Url"));
		} else if (environment.equals("FTE")) {
			driver.get(properties.getProperty("ApplicationFTEUrl"));
		} else if (environment.equals("FTE2")) {
			driver.get(properties.getProperty("ApplicationFTE2Url"));
		}*/
		String sApplicationUrl = properties.getProperty("ApplicationUrl");
		driver.get(sApplicationUrl);
		Utility_Functions.timeWait(3);
		Utility_Functions.xWaitForElementPresent(driver, txt_userName, 10);
	}

	/**
	 * Validating the Login functionality
	 * 
	 * @author Vishnuvardhan
	 *
	 */
	public void login() {
		invokeApplication();
		try {
			if ((environment.equals("UAT")) || (environment.equals("UAT2")) || (environment.equals("FTE"))
					|| (environment.equals("FTE2"))) {
				if (dataTable.getData("General_Data", "TC_ID").contains("Admin")) {
					Utility_Functions.xSendKeys(driver, txt_userName, properties.getProperty("SystemAdminUsername") + "." + environment);
				} else if ((dataTable.getData("General_Data", "TC_ID").contains("OBAMER")) && (dataTable.getData("General_Data", "TC_ID").contains("CSS"))) {
					Utility_Functions.xSendKeys(driver, txt_userName, properties.getProperty("OBAMERCSS") + "." + environment);
				} else if ((dataTable.getData("General_Data", "TC_ID").contains("OBAMER")) && (dataTable.getData("General_Data", "TC_ID").contains("Manager"))) {
					Utility_Functions.xSendKeys(driver, txt_userName, properties.getProperty("OBAMERManager") + "." + environment);
				} else if ((dataTable.getData("General_Data", "TC_ID").contains("OBAMER")) && (dataTable.getData("General_Data", "TC_ID").contains("Broker"))) {
					Utility_Functions.xSendKeys(driver, txt_userName, properties.getProperty("OBAMERBroker") + "." + environment);
				} else if ((dataTable.getData("General_Data", "TC_ID").contains("OBEMEA")) && (dataTable.getData("General_Data", "TC_ID").contains("CSS"))) {
					Utility_Functions.xSendKeys(driver, txt_userName, properties.getProperty("OBEMEACSS") + "." + environment);
				} else if ((dataTable.getData("General_Data", "TC_ID").contains("OBEMEA")) && (dataTable.getData("General_Data", "TC_ID").contains("Manager"))) {
					Utility_Functions.xSendKeys(driver, txt_userName, properties.getProperty("OBEMEAManager") + "." + environment);				
				} else if ((dataTable.getData("General_Data", "TC_ID").contains("OBEMEA")) && (dataTable.getData("General_Data", "TC_ID").contains("OccupierClientCare")) && (!dataTable.getData("General_Data", "TC_ID").contains("OBEMEABroker")) && (!dataTable.getData("General_Data", "TC_ID").contains("OBEMEAManager")) && (!dataTable.getData("General_Data", "TC_ID").contains("OBEMEACSS"))) {
					Utility_Functions.xSendKeys(driver, txt_userName, properties.getProperty("OBEMEAOccupierClientCare") + "." + environment);				
				} else if ((dataTable.getData("General_Data", "TC_ID").contains("OBEMEA")) && (dataTable.getData("General_Data", "TC_ID").contains("Broker"))) {
					Utility_Functions.xSendKeys(driver, txt_userName, properties.getProperty("OBEMEABroker") + "." + environment);
				} else if ((dataTable.getData("General_Data", "TC_ID").contains("OBAPAC")) && (dataTable.getData("General_Data", "TC_ID").contains("CSS"))) {
					Utility_Functions.xSendKeys(driver, txt_userName, properties.getProperty("OBAPACCSS") + "." + environment);
				} else if ((dataTable.getData("General_Data", "TC_ID").contains("OBAPAC")) && (dataTable.getData("General_Data", "TC_ID").contains("Manager"))) {
					Utility_Functions.xSendKeys(driver, txt_userName, properties.getProperty("OBAPACManager") + "." + environment);
				} else if ((dataTable.getData("General_Data", "TC_ID").contains("OBAPAC")) && (dataTable.getData("General_Data", "TC_ID").contains("Broker"))) {
					Utility_Functions.xSendKeys(driver, txt_userName, properties.getProperty("OBAPACBroker") + "." + environment);

				} else if ((dataTable.getData("General_Data", "TC_ID").contains("ABAMER")) && (dataTable.getData("General_Data", "TC_ID").contains("CSS"))) {
					Utility_Functions.xSendKeys(driver, txt_userName, properties.getProperty("ABAMERCSS") + "." + environment);
				} else if ((dataTable.getData("General_Data", "TC_ID").contains("ABAMER")) && (dataTable.getData("General_Data", "TC_ID").contains("Manager"))) {
					Utility_Functions.xSendKeys(driver, txt_userName, properties.getProperty("ABAMERManager") + "." + environment);
				} else if ((dataTable.getData("General_Data", "TC_ID").contains("ABAMER")) && (dataTable.getData("General_Data", "TC_ID").contains("Broker"))) {
					Utility_Functions.xSendKeys(driver, txt_userName, properties.getProperty("ABAMERBroker")+ "." + environment);
				} else if ((dataTable.getData("General_Data", "TC_ID").contains("ABEMEA")) && (dataTable.getData("General_Data", "TC_ID").contains("CSS"))) {
					Utility_Functions.xSendKeys(driver, txt_userName, properties.getProperty("ABEMEACSS") + "." + environment);
				} else if ((dataTable.getData("General_Data", "TC_ID").contains("ABEMEA")) && (dataTable.getData("General_Data", "TC_ID").contains("Manager"))) {
					Utility_Functions.xSendKeys(driver, txt_userName, properties.getProperty("ABEMEAManager") + "." + environment);
				} else if ((dataTable.getData("General_Data", "TC_ID").contains("ABEMEA")) && (dataTable.getData("General_Data", "TC_ID").contains("Broker"))) {
					Utility_Functions.xSendKeys(driver, txt_userName, properties.getProperty("ABEMEABroker") + "." + environment);
				} else if ((dataTable.getData("General_Data", "TC_ID").contains("ABAPAC")) && (dataTable.getData("General_Data", "TC_ID").contains("CSS"))) {
					Utility_Functions.xSendKeys(driver, txt_userName, properties.getProperty("ABAPACCSS") + "." + environment);
				} else if ((dataTable.getData("General_Data", "TC_ID").contains("ABAPAC")) && (dataTable.getData("General_Data", "TC_ID").contains("Manager"))) {
					Utility_Functions.xSendKeys(driver, txt_userName, properties.getProperty("ABAPACManager") + "." + environment);
				} else if ((dataTable.getData("General_Data", "TC_ID").contains("ABAPAC")) && (dataTable.getData("General_Data", "TC_ID").contains("Broker"))) {
					Utility_Functions.xSendKeys(driver, txt_userName, properties.getProperty("ABAPACBroker") + "." + environment);

				} else if ((dataTable.getData("General_Data", "TC_ID").contains("CMAMER")) && (dataTable.getData("General_Data", "TC_ID").contains("CSS"))) {
					Utility_Functions.xSendKeys(driver, txt_userName, properties.getProperty("CMAMERCSS") + "." + environment);
				} else if ((dataTable.getData("General_Data", "TC_ID").contains("CMAMER")) && (dataTable.getData("General_Data", "TC_ID").contains("Manager"))) {
					Utility_Functions.xSendKeys(driver, txt_userName, properties.getProperty("CMAMERManager") + "." + environment);
				} else if ((dataTable.getData("General_Data", "TC_ID").contains("CMAMER")) && (dataTable.getData("General_Data", "TC_ID").contains("Broker"))) {
					Utility_Functions.xSendKeys(driver, txt_userName, properties.getProperty("CMAMERBroker") + "." + environment);
				} else if ((dataTable.getData("General_Data", "TC_ID").contains("CMEMEA")) && (dataTable.getData("General_Data", "TC_ID").contains("CSS")) && (!dataTable.getData("General_Data", "TC_ID").contains("BCP")) 
						&& (!dataTable.getData("General_Data", "TC_ID").contains("Dev")) && (!dataTable.getData("General_Data", "TC_ID").contains("IP") && (!dataTable.getData("General_Data", "TC_ID").contains("CA")
						&& (!dataTable.getData("General_Data", "TC_ID").contains("SuperUser"))))){
					Utility_Functions.xSendKeys(driver, txt_userName, properties.getProperty("CMEMEACSS") + "." + environment);
				} else if ((dataTable.getData("General_Data", "TC_ID").contains("CMEMEA")) && (dataTable.getData("General_Data", "TC_ID").contains("Manager")) && (!dataTable.getData("General_Data", "TC_ID").contains("BCP")) 
						&& (!dataTable.getData("General_Data", "TC_ID").contains("Dev"))  && (!dataTable.getData("General_Data", "TC_ID").contains("IP") && (!dataTable.getData("General_Data", "TC_ID").contains("CA")))) {
					Utility_Functions.xSendKeys(driver, txt_userName, properties.getProperty("CMEMEAManager") + "." + environment);
				} else if ((dataTable.getData("General_Data", "TC_ID").contains("CMEMEA")) && (dataTable.getData("General_Data", "TC_ID").contains("Broker")) && (!dataTable.getData("General_Data", "TC_ID").contains("BCP")) 
						&& (!dataTable.getData("General_Data", "TC_ID").contains("Dev"))  && (!dataTable.getData("General_Data", "TC_ID").contains("IP")&& (!dataTable.getData("General_Data", "TC_ID").contains("CA")))) {
					Utility_Functions.xSendKeys(driver, txt_userName, properties.getProperty("CMEMEABroker") + "." + environment);
				} else if ((dataTable.getData("General_Data", "TC_ID").contains("CMAPAC")) && (dataTable.getData("General_Data", "TC_ID").contains("CSS"))) {
					Utility_Functions.xSendKeys(driver, txt_userName, properties.getProperty("CMAPACCSS") + "." + environment);
				} else if ((dataTable.getData("General_Data", "TC_ID").contains("CMAPAC")) && (dataTable.getData("General_Data", "TC_ID").contains("Manager"))) {
					Utility_Functions.xSendKeys(driver, txt_userName, properties.getProperty("CMAPACManager") + "." + environment);
				} else if ((dataTable.getData("General_Data", "TC_ID").contains("CMAPAC")) && (dataTable.getData("General_Data", "TC_ID").contains("Broker") && (!dataTable.getData("General_Data", "TC_ID").contains("NZL") 
						&& (!dataTable.getData("General_Data", "TC_ID").contains("MetroNZL") && (!dataTable.getData("General_Data", "TC_ID").contains("Metro")&& (!dataTable.getData("General_Data", "TC_ID").contains("AUC") 
						&& (!dataTable.getData("General_Data", "TC_ID").contains("AUS") && (!dataTable.getData("General_Data", "TC_ID").contains("NSW") && (!dataTable.getData("General_Data", "TC_ID").contains("ChristChurch")
						&& (!dataTable.getData("General_Data", "TC_ID").contains("MVP") && (!dataTable.getData("General_Data", "TC_ID").contains("India")&& (!dataTable.getData("General_Data", "TC_ID").contains("Japan"))))))))))))) {
					Utility_Functions.xSendKeys(driver, txt_userName, properties.getProperty("CMAPACBroker") + "." + environment);
				} else if ((dataTable.getData("General_Data", "TC_ID").contains("CMAPAC")) && (dataTable.getData("General_Data", "TC_ID").contains("Broker")&& (dataTable.getData("General_Data", "TC_ID").contains("AUC")))) {
					Utility_Functions.xSendKeys(driver, txt_userName, properties.getProperty("CMAPACBrokerAUC") + "." + environment);			
				}else if ((dataTable.getData("General_Data", "TC_ID").contains("CMAPAC")) && (dataTable.getData("General_Data", "TC_ID").contains("Broker")&& (dataTable.getData("General_Data", "TC_ID").contains("Japan")))) {
					Utility_Functions.xSendKeys(driver, txt_userName, properties.getProperty("CMAPACBrokerJapan") + "." + environment);				
				}else if ((dataTable.getData("General_Data", "TC_ID").contains("CMAPAC")) && (dataTable.getData("General_Data", "TC_ID").contains("Broker")&& (dataTable.getData("General_Data", "TC_ID").contains("India")))) {
					Utility_Functions.xSendKeys(driver, txt_userName, properties.getProperty("CMAPACBrokerIndia") + "." + environment);				
				}else if ((dataTable.getData("General_Data", "TC_ID").contains("CMAPAC")) && (dataTable.getData("General_Data", "TC_ID").contains("Broker")&& (dataTable.getData("General_Data", "TC_ID").contains("AUS")))) {
					Utility_Functions.xSendKeys(driver, txt_userName, properties.getProperty("CMAPACBrokerAUS") + "." + environment);				
				}else if ((dataTable.getData("General_Data", "TC_ID").contains("CMAPAC")) && (dataTable.getData("General_Data", "TC_ID").contains("Broker")&& (dataTable.getData("General_Data", "TC_ID").contains("ChristChurch")))) {
					Utility_Functions.xSendKeys(driver, txt_userName, properties.getProperty("CMAPACBrokerChristChurch") + "." + environment);				
				}else if ((dataTable.getData("General_Data", "TC_ID").contains("CMAPAC")) && (dataTable.getData("General_Data", "TC_ID").contains("Broker")&& (dataTable.getData("General_Data", "TC_ID").contains("NSW")))) {
					Utility_Functions.xSendKeys(driver, txt_userName, properties.getProperty("CMAPACBrokerNSW") + "." + environment);				
				}else if ((dataTable.getData("General_Data", "TC_ID").contains("CMAPAC")) && (dataTable.getData("General_Data", "TC_ID").contains("Broker")&& (dataTable.getData("General_Data", "TC_ID").contains("NZL")))) {
					Utility_Functions.xSendKeys(driver, txt_userName, properties.getProperty("CMAPACBrokerNZL") + "." + environment);				
				}else if ((dataTable.getData("General_Data", "TC_ID").contains("CMAPAC")) && (dataTable.getData("General_Data", "TC_ID").contains("Broker")&& (dataTable.getData("General_Data", "TC_ID").contains("MetroNZL")))) {
					Utility_Functions.xSendKeys(driver, txt_userName, properties.getProperty("CMAPACBrokerMetroNZL")+ "." + environment);				
				}else if ((dataTable.getData("General_Data", "TC_ID").contains("CMAPAC")) && (dataTable.getData("General_Data", "TC_ID").contains("Broker")&& (dataTable.getData("General_Data", "TC_ID").contains("Metro")))) {
					Utility_Functions.xSendKeys(driver, txt_userName, properties.getProperty("CMAPACBrokerMetro")+ "." + environment);				
				}else if ((dataTable.getData("General_Data", "TC_ID").contains("CMAPAC")) && (dataTable.getData("General_Data", "TC_ID").contains("Broker")&& (dataTable.getData("General_Data", "TC_ID").contains("MVP")))) {
					Utility_Functions.xSendKeys(driver, txt_userName, properties.getProperty("CMAPACBrokerMVP") + "." + environment);

				}else if ((dataTable.getData("General_Data", "TC_ID").contains("CMEMEA")) && (dataTable.getData("General_Data", "TC_ID").contains("CSS")) && (dataTable.getData("General_Data", "TC_ID").contains("IP"))) {
					Utility_Functions.xSendKeys(driver, txt_userName, properties.getProperty("CMEMEACSSIP")+ "." + environment);
				} else if ((dataTable.getData("General_Data", "TC_ID").contains("CMEMEA")) && (dataTable.getData("General_Data", "TC_ID").contains("Manager")) && (dataTable.getData("General_Data", "TC_ID").contains("IP"))) {
					Utility_Functions.xSendKeys(driver, txt_userName, properties.getProperty("CMEMEAManagerIP")+ "." + environment);
				} else if ((dataTable.getData("General_Data", "TC_ID").contains("CMEMEA")) && (dataTable.getData("General_Data", "TC_ID").contains("Broker")) && (dataTable.getData("General_Data", "TC_ID").contains("IP"))) {
					Utility_Functions.xSendKeys(driver, txt_userName, properties.getProperty("CMEMEABrokerIP")+ "." + environment);
				}else if ((dataTable.getData("General_Data", "TC_ID").contains("CMEMEA")) && (dataTable.getData("General_Data", "TC_ID").contains("Broker")) && (dataTable.getData("General_Data", "TC_ID").contains("BCP"))) {
					Utility_Functions.xSendKeys(driver, txt_userName, properties.getProperty("CMEMEABrokerBCP")+ "." + environment);
				}else if ((dataTable.getData("General_Data", "TC_ID").contains("CMEMEA")) && (dataTable.getData("General_Data", "TC_ID").contains("Broker")) && (dataTable.getData("General_Data", "TC_ID").contains("BCP"))) {
					Utility_Functions.xSendKeys(driver, txt_userName, properties.getProperty("CMEMEAManagerBCP")+ "." + environment);
				} else if ((dataTable.getData("General_Data", "TC_ID").contains("CMEMEA")) && (dataTable.getData("General_Data", "TC_ID").contains("Broker")) && (dataTable.getData("General_Data", "TC_ID").contains("CA"))) {
					Utility_Functions.xSendKeys(driver, txt_userName, properties.getProperty("CMEMEABrokerCA")+ "." + environment);
				} else if ((dataTable.getData("General_Data", "TC_ID").contains("CMEMEA")) && (dataTable.getData("General_Data", "TC_ID").contains("Manager")) && (dataTable.getData("General_Data", "TC_ID").contains("CA"))) {
					Utility_Functions.xSendKeys(driver, txt_userName, properties.getProperty("CMEMEAManagerCA")+ "." + environment);
				}else if ((dataTable.getData("General_Data", "TC_ID").contains("CMEMEA")) && (dataTable.getData("General_Data", "TC_ID").contains("Broker")) && (dataTable.getData("General_Data", "TC_ID").contains("Dev"))) {
					Utility_Functions.xSendKeys(driver, txt_userName, properties.getProperty("CMEMEABrokerDev")+ "." + environment);
				}else if ((dataTable.getData("General_Data", "TC_ID").contains("CMEMEA")) && (dataTable.getData("General_Data", "TC_ID").contains("Manager")) && (dataTable.getData("General_Data", "TC_ID").contains("Dev"))) {
					Utility_Functions.xSendKeys(driver, txt_userName, properties.getProperty("CMEMEAManagerDev")+ "." + environment);
				}else if ((dataTable.getData("General_Data", "TC_ID").contains("CMEMEA")) && (dataTable.getData("General_Data", "TC_ID").contains("CSS")) && (dataTable.getData("General_Data", "TC_ID").contains("Dev"))) {
					Utility_Functions.xSendKeys(driver, txt_userName, properties.getProperty("CMEMEACSSDev")+ "." + environment);
				}else if ((dataTable.getData("General_Data", "TC_ID").contains("CMEMEA")) && (dataTable.getData("General_Data", "TC_ID").contains("CSS")) && (dataTable.getData("General_Data", "TC_ID").contains("SuperUser"))) {
					Utility_Functions.xSendKeys(driver, txt_userName, properties.getProperty("CMEMEACSSSuperUser")+ "." + environment);
		
				} else if ((dataTable.getData("General_Data", "TC_ID").contains("CMEMEA")) && (dataTable.getData("General_Data", "TC_ID").contains("Broker")) && (dataTable.getData("General_Data", "TC_ID").contains("BCP"))) {
					Utility_Functions.xSendKeys(driver, txt_userName, properties.getProperty("CMEMEABrokerBCP")+ "." + environment); 
				} else if ((dataTable.getData("General_Data", "TC_ID").contains("CMEMEA")) && (dataTable.getData("General_Data", "TC_ID").contains("Manager")) && (dataTable.getData("General_Data", "TC_ID").contains("BCP"))) {
					Utility_Functions.xSendKeys(driver, txt_userName, properties.getProperty("CMEMEAManagerBCP")+ "." + environment); 
				} else if ((dataTable.getData("General_Data", "TC_ID").contains("CMEMEA")) && (dataTable.getData("General_Data", "TC_ID").contains("CSS")) && (dataTable.getData("General_Data", "TC_ID").contains("BCP"))) {
					Utility_Functions.xSendKeys(driver, txt_userName, properties.getProperty("CMEMEACSSBCP")+ "." + environment); 
				} else if ((dataTable.getData("General_Data", "TC_ID").contains("CMEMEA")) && (dataTable.getData("General_Data", "TC_ID").contains("Broker")) && (dataTable.getData("General_Data", "TC_ID").contains("Dev"))) {
					Utility_Functions.xSendKeys(driver, txt_userName, properties.getProperty("CMEMEABrokerDev")+ "." + environment); 
				} else if ((dataTable.getData("General_Data", "TC_ID").contains("CMEMEA")) && (dataTable.getData("General_Data", "TC_ID").contains("Manager")) && (dataTable.getData("General_Data", "TC_ID").contains("Dev"))) {
					Utility_Functions.xSendKeys(driver, txt_userName, properties.getProperty("CMEMEAManagerDev")+ "." + environment); 
				} else if ((dataTable.getData("General_Data", "TC_ID").contains("CMEMEA")) && (dataTable.getData("General_Data", "TC_ID").contains("CSS")) && (dataTable.getData("General_Data", "TC_ID").contains("Dev"))) {
					Utility_Functions.xSendKeys(driver, txt_userName, properties.getProperty("CMEMEACSSDev")+ "." + environment); 
										
				}else if ((dataTable.getData("General_Data", "TC_ID").contains("APAC")) && (dataTable.getData("General_Data", "TC_ID").contains("Project")&& (dataTable.getData("General_Data", "TC_ID").contains("Manager")))) {
					Utility_Functions.xSendKeys(driver, txt_userName, properties.getProperty("APACProjectManager")+ "." + environment);
					
				}else if ((dataTable.getData("General_Data", "TC_ID").contains("VASAMER")) && (dataTable.getData("General_Data", "TC_ID").contains("Manager"))) {
					Utility_Functions.xSendKeys(driver, txt_userName, properties.getProperty("VASAMERManager")+ "." + environment);
				} else if ((dataTable.getData("General_Data", "TC_ID").contains("VASAMER")) && (dataTable.getData("General_Data", "TC_ID").contains("Broker"))) {
					Utility_Functions.xSendKeys(driver, txt_userName, properties.getProperty("VASAMERBroker")+ "." + environment);
				} else if ((dataTable.getData("General_Data", "TC_ID").contains("VASAMER")) && (dataTable.getData("General_Data", "TC_ID").contains("CSS"))) {
					Utility_Functions.xSendKeys(driver, txt_userName, properties.getProperty("VASAMERCSS")+ "." + environment);
				} else if ((dataTable.getData("General_Data", "TC_ID").contains("VASEMEA")) && (dataTable.getData("General_Data", "TC_ID").contains("Manager"))) {
					Utility_Functions.xSendKeys(driver, txt_userName, properties.getProperty("VASEMEAManager")+ "." + environment);
				} else if ((dataTable.getData("General_Data", "TC_ID").contains("VASEMEA")) && (dataTable.getData("General_Data", "TC_ID").contains("Broker")&& (!dataTable.getData("General_Data", "TC_ID").contains("SuperUser")))) {
					Utility_Functions.xSendKeys(driver, txt_userName, properties.getProperty("VASEMEABroker")+ "." + environment);				
				}else if ((dataTable.getData("General_Data", "TC_ID").contains("VASEMEA")) && (dataTable.getData("General_Data", "TC_ID").contains("Broker")&& (dataTable.getData("General_Data", "TC_ID").contains("SuperUser")))) {
					Utility_Functions.xSendKeys(driver, txt_userName, properties.getProperty("VASEMEABrokerSuperUser")+ "." + environment);				
				}  else if ((dataTable.getData("General_Data", "TC_ID").contains("VASEMEA")) && (dataTable.getData("General_Data", "TC_ID").contains("CSS"))) {
					Utility_Functions.xSendKeys(driver, txt_userName, properties.getProperty("VASEMEACSS")+ "." + environment);
				} else if ((dataTable.getData("General_Data", "TC_ID").contains("VASAPAC")) && (dataTable.getData("General_Data", "TC_ID").contains("Manager"))) {
					Utility_Functions.xSendKeys(driver, txt_userName, properties.getProperty("VASAPACManager")+ "." + environment);
				} else if ((dataTable.getData("General_Data", "TC_ID").contains("VASAPAC")) && (dataTable.getData("General_Data", "TC_ID").contains("Broker"))) {
					Utility_Functions.xSendKeys(driver, txt_userName, properties.getProperty("VASAPACBroker")+ "." + environment);
				} else if ((dataTable.getData("General_Data", "TC_ID").contains("VASAPAC")) && (dataTable.getData("General_Data", "TC_ID").contains("CSS"))) {
					Utility_Functions.xSendKeys(driver, txt_userName, properties.getProperty("VASAPACCSS")+ "." + environment);
					
				} else if ((dataTable.getData("General_Data", "TC_ID").contains("ASAMER")) && (dataTable.getData("General_Data", "TC_ID").contains("Manager"))) {
					Utility_Functions.xSendKeys(driver, txt_userName, properties.getProperty("ASAMERManager")+ "." + environment);
				} else if ((dataTable.getData("General_Data", "TC_ID").contains("ASAMER")) && (dataTable.getData("General_Data", "TC_ID").contains("Broker"))) {
					Utility_Functions.xSendKeys(driver, txt_userName, properties.getProperty("ASAMERBroker")+ "." + environment);
				} else if ((dataTable.getData("General_Data", "TC_ID").contains("ASAMER")) && (dataTable.getData("General_Data", "TC_ID").contains("CSS"))) {
					Utility_Functions.xSendKeys(driver, txt_userName, properties.getProperty("ASAMERCSS")+ "." + environment);
				} else if ((dataTable.getData("General_Data", "TC_ID").contains("ASEMEA")) && (dataTable.getData("General_Data", "TC_ID").contains("Manager"))) {
					Utility_Functions.xSendKeys(driver, txt_userName, properties.getProperty("ASEMEAManager")+ "." + environment);
				} else if ((dataTable.getData("General_Data", "TC_ID").contains("ASEMEA")) && (dataTable.getData("General_Data", "TC_ID").contains("Broker")&& (!dataTable.getData("General_Data", "TC_ID").contains("SuperUser")))) {
					Utility_Functions.xSendKeys(driver, txt_userName, properties.getProperty("ASEMEABroker")+ "." + environment);
				}else if ((dataTable.getData("General_Data", "TC_ID").contains("ASEMEA")) && (dataTable.getData("General_Data", "TC_ID").contains("Broker") && (dataTable.getData("General_Data", "TC_ID").contains("SuperUser")))) {
					Utility_Functions.xSendKeys(driver, txt_userName, properties.getProperty("ASEMEABrokerSuperUser")+ "." + environment);		
				}  else if ((dataTable.getData("General_Data", "TC_ID").contains("ASEMEA")) && (dataTable.getData("General_Data", "TC_ID").contains("CSS"))) {
					Utility_Functions.xSendKeys(driver, txt_userName, properties.getProperty("ASEMEACSS")+ "." + environment);
				} else if ((dataTable.getData("General_Data", "TC_ID").contains("ASAPAC")) && (dataTable.getData("General_Data", "TC_ID").contains("Manager"))) {
					Utility_Functions.xSendKeys(driver, txt_userName, properties.getProperty("ASAPACManager")+ "." + environment);
				} else if ((dataTable.getData("General_Data", "TC_ID").contains("ASAPAC")) && (dataTable.getData("General_Data", "TC_ID").contains("Broker"))) {
					Utility_Functions.xSendKeys(driver, txt_userName, properties.getProperty("ASAPACBroker")+ "." + environment);
				} else if ((dataTable.getData("General_Data", "TC_ID").contains("ASAPAC")) && (dataTable.getData("General_Data", "TC_ID").contains("CSS"))) {
					Utility_Functions.xSendKeys(driver, txt_userName, properties.getProperty("ASAPACCSS")+ "." + environment);

				} else if ((dataTable.getData("General_Data", "TC_ID").contains("GWSAMER"))	&& (dataTable.getData("General_Data", "TC_ID").contains("Manager"))) {
					Utility_Functions.xSendKeys(driver, txt_userName, properties.getProperty("GWSAMERManager")+ "." + environment);
				} else if ((dataTable.getData("General_Data", "TC_ID").contains("GWSAMER"))	&& (dataTable.getData("General_Data", "TC_ID").contains("Broker"))) {
					Utility_Functions.xSendKeys(driver, txt_userName, properties.getProperty("GWSAMERBroker")+ "." + environment);
				} else if ((dataTable.getData("General_Data", "TC_ID").contains("GWSAMER"))	&& (dataTable.getData("General_Data", "TC_ID").contains("CSS"))) {
					Utility_Functions.xSendKeys(driver, txt_userName, properties.getProperty("GWSAMERCSS")+ "." + environment);
				} else if ((dataTable.getData("General_Data", "TC_ID").contains("GWSEMEA"))	&& (dataTable.getData("General_Data", "TC_ID").contains("Manager"))) {
					Utility_Functions.xSendKeys(driver, txt_userName, properties.getProperty("GWSEMEAManager")+ "." + environment);
				} else if ((dataTable.getData("General_Data", "TC_ID").contains("GWSEMEA"))	&& (dataTable.getData("General_Data", "TC_ID").contains("Broker")&& (!dataTable.getData("General_Data", "TC_ID").contains("SuperUser")))) {
					Utility_Functions.xSendKeys(driver, txt_userName, properties.getProperty("GWSEMEABroker")+ "." + environment);
				} else if ((dataTable.getData("General_Data", "TC_ID").contains("GWSEMEA"))	&& (dataTable.getData("General_Data", "TC_ID").contains("Broker")&& (dataTable.getData("General_Data", "TC_ID").contains("SuperUser")))) {
					Utility_Functions.xSendKeys(driver, txt_userName, properties.getProperty("GWSEMEABrokerSuperUser")+ "." + environment);				
				} else if ((dataTable.getData("General_Data", "TC_ID").contains("GWSEMEA"))	&& (dataTable.getData("General_Data", "TC_ID").contains("CSS"))) {
					Utility_Functions.xSendKeys(driver, txt_userName, properties.getProperty("GWSEMEACSS")+ "." + environment);
				} else if ((dataTable.getData("General_Data", "TC_ID").contains("GWSAPAC")) && (dataTable.getData("General_Data", "TC_ID").contains("Manager"))) {
					Utility_Functions.xSendKeys(driver, txt_userName, properties.getProperty("GWSAPACManager")+ "." + environment);
				} else if ((dataTable.getData("General_Data", "TC_ID").contains("GWSAPAC")) && (dataTable.getData("General_Data", "TC_ID").contains("Broker"))) {
					Utility_Functions.xSendKeys(driver, txt_userName, properties.getProperty("GWSAPACBroker")+ "." + environment);
				} else if ((dataTable.getData("General_Data", "TC_ID").contains("GWSAPAC"))	&& (dataTable.getData("General_Data", "TC_ID").contains("CSS"))) {
					Utility_Functions.xSendKeys(driver, txt_userName, properties.getProperty("GWSAPACCSS")+ "." + environment);

				} else if ((dataTable.getData("General_Data", "TC_ID").contains("DAAMER")) && (dataTable.getData("General_Data", "TC_ID").contains("Data"))) {
					Utility_Functions.xSendKeys(driver, txt_userName, properties.getProperty("DAAMERData")+ "." + environment);
				} else if ((dataTable.getData("General_Data", "TC_ID").contains("DAEMEA")) && (dataTable.getData("General_Data", "TC_ID").contains("Data"))) {
					Utility_Functions.xSendKeys(driver, txt_userName, properties.getProperty("DAEMEAData")+ "." + environment);
				} else if ((dataTable.getData("General_Data", "TC_ID").contains("DAAPAC")) && (dataTable.getData("General_Data", "TC_ID").contains("Data"))) {
					Utility_Functions.xSendKeys(driver, txt_userName, properties.getProperty("DAAPACData")+ "." + environment);
					
				} else if ((dataTable.getData("General_Data", "TC_ID").contains("AUCAPAC")) && (dataTable.getData("General_Data", "TC_ID").contains("Broker"))) {
					Utility_Functions.xSendKeys(driver, txt_userName, properties.getProperty("AUCAPACBroker")+ "." + environment);
						
				} else if ((dataTable.getData("General_Data", "TC_ID").contains("FRANEMEA")) && (dataTable.getData("General_Data", "TC_ID").contains("Manager"))) {
					Utility_Functions.xSendKeys(driver, txt_userName, properties.getProperty("FRANEMEAManager")+ "." + environment);
				} else if ((dataTable.getData("General_Data", "TC_ID").contains("FDIGEMEA")) && (dataTable.getData("General_Data", "TC_ID").contains("Manager"))) {
					Utility_Functions.xSendKeys(driver, txt_userName, properties.getProperty("FDIGEMEAManager")+ "." + environment);
				} else if ((dataTable.getData("General_Data", "TC_ID").contains("FDIREMEA")) && (dataTable.getData("General_Data", "TC_ID").contains("Manager"))) {
					Utility_Functions.xSendKeys(driver, txt_userName, properties.getProperty("FDIREMEAManager")+ "." + environment);
				} else if ((dataTable.getData("General_Data", "TC_ID").contains("FDIGEMEA")) && (dataTable.getData("General_Data", "TC_ID").contains("Data"))) {
					Utility_Functions.xSendKeys(driver, txt_userName, properties.getProperty("FDIGEMEAData")+ "." + environment);
				
				} else if ((dataTable.getData("General_Data", "TC_ID").contains("DAASIA")) && (dataTable.getData("General_Data", "TC_ID").contains("Data"))) {
					Utility_Functions.xSendKeys(driver, txt_userName, properties.getProperty("DAASIAData")+ "." + environment);
				} else if ((dataTable.getData("General_Data", "TC_ID").contains("DAPACI")) && (dataTable.getData("General_Data", "TC_ID").contains("Data"))) {
					Utility_Functions.xSendKeys(driver, txt_userName, properties.getProperty("DAPACIData")+ "." + environment);
				}
			}
			Utility_Functions.timeWait(1);
			if (environment.equals("UAT")) {
				if (dataTable.getData("General_Data", "TC_ID").contains("Admin")) {
					Utility_Functions.xSendKeys(driver, txt_password, properties.getProperty("UATAdminPassword"));
				} else {
					Utility_Functions.xSendKeys(driver, txt_password, properties.getProperty("UATPassword"));
				}
			} else if (environment.equals("FTE")) {
				if (dataTable.getData("General_Data", "TC_ID").contains("Admin")) {
					Utility_Functions.xSendKeys(driver, txt_password, properties.getProperty("FTEAdminPassword"));
				} else {
					Utility_Functions.xSendKeys(driver, txt_password, properties.getProperty("FTEPassword"));
				}
			} else if (environment.equals("FTE2")) {
				if (dataTable.getData("General_Data", "TC_ID").contains("Admin")) {
					Utility_Functions.xSendKeys(driver, txt_password, properties.getProperty("FTE2AdminPassword"));
				} else {
					Utility_Functions.xSendKeys(driver, txt_password, properties.getProperty("FTE2Password"));
				}
			}
			if (environment.equals("UAT2")) {
				if (dataTable.getData("General_Data", "TC_ID").contains("Admin")) {
					Utility_Functions.xSendKeys(driver, txt_password, properties.getProperty("UAT2AdminPassword"));
				} else {
					Utility_Functions.xSendKeys(driver, txt_password, properties.getProperty("UAT2Password"));
				}
			}
			// Utility_Functions.timeWait(1);
			report.updateTestLog("Login", "Click the sign-in button", Status.PASS);
			Utility_Functions.xClick(driver, btn_LogIn, true);
			Utility_Functions.timeWait(5);
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
			if (continueLink.isDisplayed()) {
				Utility_Functions.xClick(driver, continueLink, true);
				report.updateTestLog("Scheduled Maintenance Window",
						"Clicking on continue link from the scheduled maintenance window", Status.PASS);
			} else {
				report.updateTestLog("Scheduled Maintenance Window",
						"Failed to click on continue link from the scheduled maintenance window", Status.FAIL);
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
		try {
			try {
				try {
					Utility_Functions.xWaitForElementPresent(driver, menu_Home, 3);
					Utility_Functions.xWaitForElementPresent(driver, sandbox, 3);
					Utility_Functions.xClick(driver, sandbox, true);
					report.updateTestLog("Verify Login", "Login is successful", Status.PASS);
				} catch (Exception e) {
					if (continueButtonMaiteinance.isDisplayed()) {
						Utility_Functions.xClick(driver, continueButtonMaiteinance, true);
						report.updateTestLog("Verify Login", "Scheduled Maintenance Notification popped up",
								Status.PASS);
					}
				}
			} catch (Exception e) {
				Utility_Functions.xWaitForElementPresent(driver, userName, 3);
				Utility_Functions.xClick(driver, userName, true);
				Utility_Functions.timeWait(2);
				Utility_Functions.xWaitForElementPresent(driver, switchLightningExperience, 3);
				Utility_Functions.xClick(driver, switchLightningExperience, true);
				report.updateTestLog("Verify Login", "Switched to Lightning Experience Page", Status.PASS);
				Utility_Functions.xWaitForElementPresent(driver, menu_Home, 3);
				report.updateTestLog("Verify Login", "Login is successful", Status.PASS);
			}
		} catch (Exception e) {
			try {
				if (errorMessage.isDisplayed()) {
					report.updateTestLog("Verify Login",
							"UserName and Password entered are invalid please check the credentials:::",
							Status.WARNING);
					driver.close();
				}
			} catch (Exception e1) {
				System.out.println("Login wasn't successful:::");
				driver.close();
			}
			/*
			 * frameworkParameters.setStopExecution(true); throw new
			 * FrameworkException("Verify Login", "Login failed");
			 */
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
			Utility_Functions.xWaitForElementPresent(driver, logOutButton, 3);
			Utility_Functions.xClick(driver, logOutButton, true);
			Utility_Functions.xWaitForElementPresent(driver, logOut, 3);
			Utility_Functions.xClick(driver, logOut, true);
			report.updateTestLog("Verify Logout", "User has been logged out successfully:::", Status.PASS);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Function for Change Passwords
	 * 
	 * @author Vishnuvardhan
	 *
	 */

	public void changePassword() {
		userNames();
		String environment = properties.getProperty("RunEnvironment");
		String sCurrentPassword = dataTable.getData("General_Data", "Password");
		String sNewPassword = dataTable.getData("General_Data", "NewPassword");
		if ((environment.equals("UAT")) || (environment.equals("UAT2")) || (environment.equals("FTE"))
				|| (environment.equals("FTE2"))) {
			for (int i = 0; i < userNamesList.size(); i++) {
				Utility_Functions.timeWait(1);
				invokeApplication();
				String userName = userNamesList.get(i);
				Utility_Functions.xSendKeys(driver, txt_userName, userName);
				Utility_Functions.xWaitForElementPresent(driver, txt_password, 3);
				Utility_Functions.xSendKeys(driver, txt_password, sCurrentPassword);
				Utility_Functions.xWaitForElementPresent(driver, btn_LogIn, 3);
				Utility_Functions.xClick(driver, btn_LogIn, true);
				try {
					Utility_Functions.xWaitForElementPresent(driver, changePasswordHeader, 6);
				} catch (Exception e) {
					if (continueLink.isDisplayed()) {
						Utility_Functions.xClick(driver, continueLink, true);
						report.updateTestLog("Scheduled Maintenance Window", "Clicking on continue link from the scheduled maintenance window", Status.PASS);
					}
				}
				Utility_Functions.xWaitForElementPresent(driver, currentPassword, 3);
				Utility_Functions.xSendKeys(driver, currentPassword, sCurrentPassword);
				Utility_Functions.xWaitForElementPresent(driver, newPassword, 3);
				Utility_Functions.xSendKeys(driver, newPassword,sNewPassword);
				Utility_Functions.xWaitForElementPresent(driver, confirmNewPassword, 3);
				Utility_Functions.xSendKeys(driver, confirmNewPassword,sNewPassword);
				/*
				 * Utility_Functions.xScrollWindowOnce(driver);
				 * Utility_Functions.timeWait(1);
				 * Utility_Functions.xScrollWindowTop(driver);
				 * Utility_Functions.timeWait(1);
				 */
				Utility_Functions.xWaitForElementPresent(driver, securityAnswer, 3);
				Utility_Functions.xSendKeys(driver, securityAnswer,
						dataTable.getData("General_Data", "SecurityAnswer"));
				Utility_Functions.xWaitForElementPresent(driver, changePassword, 3);
				Utility_Functions.xClick(driver, changePassword, true);
				report.updateTestLog("Verify Change Password",
						"Password has been changed successfully to:::" + sNewPassword,
						Status.PASS);
				Utility_Functions.timeWait(8);
				logout();
				System.out.println("Password has been changed successfully:::" + userName);
				Utility_Functions.timeWait(5);
				// driver.quit();
			}
		}
	}

	/**
	 * Function for Change Passwords
	 * 
	 * @author Vishnuvardhan
	 *
	 */

	public void changeExpiredPassword() {
		userNames();
		String sCurrentPassword = environment+dataTable.getData("General_Data", "Password");
		if ((environment.equals("UAT")) || (environment.equals("UAT2")) || (environment.equals("FTE"))
				|| (environment.equals("FTE2"))) {
			for (int i = 0; i < userNamesList.size(); i++) {
				Utility_Functions.timeWait(1);
				invokeApplication();
				Utility_Functions.timeWait(3);
				String userName = userNamesList.get(i);
				Utility_Functions.xWaitForElementPresent(driver, txt_userName, 3);
				Utility_Functions.xSendKeys(driver, txt_userName, userName);
				Utility_Functions.xWaitForElementPresent(driver, txt_password, 3);
				Utility_Functions.xSendKeys(driver, txt_password, sCurrentPassword);
				Utility_Functions.timeWait(2);
				Utility_Functions.xWaitForElementPresent(driver, btn_LogIn, 3);
				Utility_Functions.xClick(driver, btn_LogIn, true);
				try {
					Utility_Functions.xWaitForElementPresent(driver, changeExpiredPasswordHeader, 3);
					Utility_Functions.xWaitForElementPresent(driver, newPassword, 3);
					Utility_Functions.xSendKeys(driver, newPassword, environment+dataTable.getData("General_Data", "NewPassword"));
					Utility_Functions.xWaitForElementPresent(driver, confirmNewPassword, 3);
					Utility_Functions.xSendKeys(driver, confirmNewPassword,
							environment+dataTable.getData("General_Data", "NewPassword"));
					Utility_Functions.xWaitForElementPresent(driver, changePassword, 3);
					Utility_Functions.xClick(driver, changePassword, true);
					report.updateTestLog(
							"Verify Change Password", "Expired Password has been changed successfully:::"
									+ userNamesList.get(i) + (environment+dataTable.getData("General_Data", "NewPassword")),
							Status.PASS);
					Utility_Functions.timeWait(4);
					logout();
					Utility_Functions.timeWait(3);
				} catch (Exception e) {
					Utility_Functions.timeWait(4);
					logout();
					report.updateTestLog("Verify Change Password",
							"Password didn't get expired:::" + userNamesList.get(i), Status.PASS);
					Utility_Functions.timeWait(3);
				}
			}
		}
	}

	/**
	 * User Names for different environments
	 * 
	 * @author Vishnuvardhan
	 *
	 */
	public static ArrayList<String> userNamesList = new ArrayList<String>();

	public void userNames() {
		String environment = initializeEnvironment();
		environment = environment.toLowerCase();

		//userNamesList.add("testuser1@cbre.com.crm." + environment);
		userNamesList.add("testuser10@cbre.com.crm." + environment);
		userNamesList.add("testuser11@cbre.com.crm." + environment);
		userNamesList.add("testuser12@cbre.com.crm." + environment);
		userNamesList.add("testuser13@cbre.com.crm." + environment);
		userNamesList.add("testuser15@cbre.com.crm." + environment);
		userNamesList.add("testuser16@cbre.com.crm." + environment);
		userNamesList.add("testuser17@cbre.com.crm." + environment);
		userNamesList.add("testuser18@cbre.com.crm." + environment);
		userNamesList.add("testuser19@cbre.com.crm." + environment);
		userNamesList.add("testuser2@cbre.com.crm." + environment);
		userNamesList.add("testuser20@cbre.com.crm." + environment);
		userNamesList.add("testuser21@cbre.com.crm." + environment);
		userNamesList.add("testuser22@cbre.com.crm." + environment);
		userNamesList.add("testuser23@cbre.com.crm." + environment);
		userNamesList.add("testuser24@cbre.com.crm." + environment);
		userNamesList.add("testuser25@cbre.com.crm." + environment);
		userNamesList.add("testuser26@cbre.com.crm." + environment);
		userNamesList.add("testuser27@cbre.com.crm." + environment);
		userNamesList.add("testuser28@cbre.com.crm." + environment);
		userNamesList.add("testuser29@cbre.com.crm." + environment);
		userNamesList.add("testuser3@cbre.com.crm." + environment);
		userNamesList.add("testuser30@cbre.com.crm." + environment);
		userNamesList.add("testuser31@cbre.com.crm." + environment);
		userNamesList.add("testuser32@cbre.com.crm." + environment);
		userNamesList.add("testuser36@cbre.com.crm." + environment);
		userNamesList.add("testuser37@cbre.com.crm." + environment);
		userNamesList.add("testuser38@cbre.com.crm." + environment);
		userNamesList.add("testuser39@cbre.com.crm." + environment);
		userNamesList.add("testuser4@cbre.com.crm." + environment);
		userNamesList.add("testuser40@cbre.com.crm." + environment);
		userNamesList.add("testuser41@cbre.com.crm." + environment);
		userNamesList.add("testuser45@cbre.com.crm." + environment);
		userNamesList.add("testuser46@cbre.com.crm." + environment);
		userNamesList.add("testuser47@cbre.com.crm." + environment);
		userNamesList.add("testuser48@cbre.com.crm." + environment);
		userNamesList.add("testuser49@cbre.com.crm." + environment);
		userNamesList.add("testuser5@cbre.com.crm." + environment);
		userNamesList.add("testuser50@cbre.com.crm." + environment);
		userNamesList.add("testuser51@cbre.com.crm." + environment);
		userNamesList.add("testuser6@cbre.com.crm." + environment);
		userNamesList.add("testuser62@cbre.com.crm." + environment);
		userNamesList.add("testuser65@cbre.com.crm." + environment);
		userNamesList.add("testuser66@cbre.com.crm." + environment);
		userNamesList.add("testuser67@cbre.com.crm." + environment);
		userNamesList.add("testuser68@cbre.com.crm." + environment);
		userNamesList.add("testuser69@cbre.com.crm." + environment);
		userNamesList.add("testuser7@cbre.com.crm." + environment);
		userNamesList.add("testuser70@cbre.com.crm." + environment);
		userNamesList.add("testuser71@cbre.com.crm." + environment);
		userNamesList.add("testuser72@cbre.com.crm." + environment);
		userNamesList.add("testuser73@cbre.com.crm." + environment);
		userNamesList.add("testuser74@cbre.com.crm." + environment);
		userNamesList.add("testuser75@cbre.com.crm." + environment);
		userNamesList.add("testuser76@cbre.com.crm." + environment);
		userNamesList.add("testuser78@cbre.com.crm." + environment);
		userNamesList.add("testuser79@cbre.com.crm." + environment);
		userNamesList.add("testuser8@cbre.com.crm." + environment);
		userNamesList.add("testuser80@cbre.com.crm." + environment);
		userNamesList.add("testuser81@cbre.com.crm." + environment);
		userNamesList.add("testuser82@cbre.com.crm." + environment);
		userNamesList.add("testuser83@cbre.com.crm." + environment);
		userNamesList.add("testuser84@cbre.com.crm." + environment);
		userNamesList.add("testuser85@cbre.com.crm." + environment);
		userNamesList.add("testuser86@cbre.com.crm." + environment);
		userNamesList.add("testuser87@cbre.com.crm." + environment);
		userNamesList.add("testuser88@cbre.com.crm." + environment);
		userNamesList.add("testuser9@cbre.com.crm." + environment);
		userNamesList.add("testuser90@cbre.com.crm." + environment);
		userNamesList.add("testuser91@cbre.com.crm." + environment);
		userNamesList.add("testuser92@cbre.com.crm." + environment);   
		userNamesList.add("testuser93@cbre.com.crm." + environment);
		userNamesList.add("testuser94@cbre.com.crm." + environment);
		userNamesList.add("testuser95@cbre.com.crm." + environment);
		userNamesList.add("testuser96@cbre.com.crm." + environment);
		userNamesList.add("testuser97@cbre.com.crm." + environment);   
		userNamesList.add("testuser98@cbre.com.crm." + environment);
		userNamesList.add("testuser99@cbre.com.crm." + environment);
		userNamesList.add("testuser100@cbre.com.crm." + environment);
		
		System.out.println("User Names List are::::" + userNamesList);
	}

	/**
	 * Function for verifying the User ID's are working or not
	 * 
	 * @author Vishnuvardhan
	 *
	 */
	static ArrayList<String> userIDsNotWorking = new ArrayList<String>();
	static ArrayList<String> userIDsWorking = new ArrayList<String>();

	public void verifyUserIDs() {
		userNames();
		String sPassword = properties.getProperty(environment + "Password");
		int count = 0;
		try {
			if ((environment.equals("UAT")) || (environment.equals("UAT2")) || (environment.equals("FTE"))
					|| (environment.equals("FTE2"))) {
				for (int i = 0; i < userNamesList.size(); i++) {
					Utility_Functions.timeWait(1);
					invokeApplication();
					String sUserName = userNamesList.get(i);
					Utility_Functions.xWaitForElementPresent(driver, txt_userName, 3);
					Utility_Functions.xSendKeys(driver, txt_userName, sUserName);
					Utility_Functions.xWaitForElementPresent(driver, txt_password, 3);
					Utility_Functions.xSendKeys(driver, txt_password, sPassword);
					Utility_Functions.timeWait(3);
					Utility_Functions.xWaitForElementPresent(driver, btn_LogIn, 3);
					Utility_Functions.xClick(driver, btn_LogIn, true);
					try {
						try {
							Utility_Functions.xWaitForElementPresent(driver, menu_Home, 9);
							report.updateTestLog("Verify Login", "Login is successful", Status.PASS);
						} catch (Exception e) {
							Utility_Functions.xWaitForElementPresent(driver, userName, 3);
							Utility_Functions.xClick(driver, userName, true);
							Utility_Functions.timeWait(2);
							Utility_Functions.xWaitForElementPresent(driver, switchLightningExperience, 3);
							Utility_Functions.xClick(driver, switchLightningExperience, true);
							report.updateTestLog("Verify Login", "Switched to Lightning Experience Page", Status.PASS);
							Utility_Functions.xWaitForElementPresent(driver, menu_Home, 3);
							report.updateTestLog("Verify Login", "Login is successful", Status.PASS);
						}
						count++;
					} catch (Exception e) {
						report.updateTestLog("Verify Login",
								sUserName + "  :::isn't working unable to login" + "---Count is:::" + count,
								Status.FAIL);
						userIDsNotWorking.add(sUserName);
					}
					report.updateTestLog("Verify Login",
							sUserName + "  :::has been logged in successfully" + "---Count is:::" + count, Status.PASS);
					userIDsWorking.add(sUserName);
					Utility_Functions.timeWait(4);
					logout();
					Utility_Functions.timeWait(8);
					// Utility_Functions.timeWait(3);
				}
				if (userNamesList.size() == count) {
					report.updateTestLog("Verify Login", "All the UserID's are working successfully", Status.PASS);
				} else {
					report.updateTestLog("Verify Login", "Not all the UserID's are working successfully", Status.FAIL);
				}
			}
			System.out.println("User ID's which aren't working are::" + userIDsNotWorking);
			report.updateTestLog("Verify Login", "User IDs which aren't working are::::" + userIDsNotWorking,
					Status.WARNING);
			report.updateTestLog("Verify Login", "User IDs which are working successfully::::" + userIDsWorking,
					Status.PASS);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
}
