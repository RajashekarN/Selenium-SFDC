package pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.cognizant.Craft.ReusableLibrary;
import com.cognizant.Craft.ScriptHelper;
import com.cognizant.framework.FrameworkException;
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
		// new WebDriverUtil(driver);
		// Utility_Functions utility = new Utility_Functions(scriptHelper);
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

	@FindBy(xpath = "//a[@class='continue][text()='Continue']")
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
			if(properties.getProperty("RunEnvironment").equals("UAT")) { 
				if(dataTable.getData("General_Data", "TC_ID").contains("Admin")) {
					Utility_Functions.xSendKeys(driver, txt_userName, properties.getProperty("UATSystemAdminUsername"));					
				} else if((dataTable.getData("General_Data", "TC_ID").contains("OB")) && (dataTable.getData("General_Data", "TC_ID").contains("AMER")) && 
						(dataTable.getData("General_Data", "TC_ID").contains("CSS")))  {					
					Utility_Functions.xSendKeys(driver, txt_userName, properties.getProperty("UATOBAMERCSS"));
				} else if((dataTable.getData("General_Data", "TC_ID").contains("OB")) && (dataTable.getData("General_Data", "TC_ID").contains("AMER")) && 
						(dataTable.getData("General_Data", "TC_ID").contains("Manager")))  { 
					Utility_Functions.xSendKeys(driver, txt_userName, properties.getProperty("UATOBAMERManager"));					
				} else if((dataTable.getData("General_Data", "TC_ID").contains("OB")) && (dataTable.getData("General_Data", "TC_ID").contains("AMER")) && 
						(dataTable.getData("General_Data", "TC_ID").contains("Broker")))  { 
					Utility_Functions.xSendKeys(driver, txt_userName, properties.getProperty("UATOBAMERBroker"));
				} else if((dataTable.getData("General_Data", "TC_ID").contains("OB")) && (dataTable.getData("General_Data", "TC_ID").contains("EMEA")) && 
						(dataTable.getData("General_Data", "TC_ID").contains("CSS")))  {					
					Utility_Functions.xSendKeys(driver, txt_userName, properties.getProperty("UATOBEMEACSS"));
				} else if((dataTable.getData("General_Data", "TC_ID").contains("OB")) && (dataTable.getData("General_Data", "TC_ID").contains("EMEA")) && 
						(dataTable.getData("General_Data", "TC_ID").contains("Manager")))  { 
					Utility_Functions.xSendKeys(driver, txt_userName, properties.getProperty("UATOBEMEAManager"));
				} else if((dataTable.getData("General_Data", "TC_ID").contains("OB")) && (dataTable.getData("General_Data", "TC_ID").contains("EMEA")) && 
						(dataTable.getData("General_Data", "TC_ID").contains("Broker")))  { 
					Utility_Functions.xSendKeys(driver, txt_userName, properties.getProperty("UATOBEMEABroker"));
				} else if((dataTable.getData("General_Data", "TC_ID").contains("OB")) && (dataTable.getData("General_Data", "TC_ID").contains("APAC")) && 
						(dataTable.getData("General_Data", "TC_ID").contains("CSS")))  {					
					Utility_Functions.xSendKeys(driver, txt_userName, properties.getProperty("UATOBAPACCSS"));
				} else if((dataTable.getData("General_Data", "TC_ID").contains("OB")) && (dataTable.getData("General_Data", "TC_ID").contains("APAC")) && 
						(dataTable.getData("General_Data", "TC_ID").contains("Manager")))  { 
					Utility_Functions.xSendKeys(driver, txt_userName, properties.getProperty("UATOBAPACManager"));
				} else if((dataTable.getData("General_Data", "TC_ID").contains("OB")) && (dataTable.getData("General_Data", "TC_ID").contains("APAC")) && 
						(dataTable.getData("General_Data", "TC_ID").contains("Broker")))  { 
					Utility_Functions.xSendKeys(driver, txt_userName, properties.getProperty("UATOBAPACBroker"));
				} else if((dataTable.getData("General_Data", "TC_ID").contains("AB")) && (dataTable.getData("General_Data", "TC_ID").contains("AMER")) && 
						(dataTable.getData("General_Data", "TC_ID").contains("CSS")))  {					
					Utility_Functions.xSendKeys(driver, txt_userName, properties.getProperty("UATABAMERCSS"));
				} else if((dataTable.getData("General_Data", "TC_ID").contains("AB")) && (dataTable.getData("General_Data", "TC_ID").contains("AMER")) && 
						(dataTable.getData("General_Data", "TC_ID").contains("Manager")))  { 
					Utility_Functions.xSendKeys(driver, txt_userName, properties.getProperty("UATABAMEManager"));
				} else if((dataTable.getData("General_Data", "TC_ID").contains("AB")) && (dataTable.getData("General_Data", "TC_ID").contains("AMER")) && 
						(dataTable.getData("General_Data", "TC_ID").contains("Broker")))  { 
					Utility_Functions.xSendKeys(driver, txt_userName, properties.getProperty("UATABAMERBroker"));
				} else if((dataTable.getData("General_Data", "TC_ID").contains("AB")) && (dataTable.getData("General_Data", "TC_ID").contains("EMEA")) && 
						(dataTable.getData("General_Data", "TC_ID").contains("CSS")))  {					
					Utility_Functions.xSendKeys(driver, txt_userName, properties.getProperty("UATABEMEACSS"));
				} else if((dataTable.getData("General_Data", "TC_ID").contains("AB")) && (dataTable.getData("General_Data", "TC_ID").contains("EMEA")) && 
						(dataTable.getData("General_Data", "TC_ID").contains("Manager")))  { 
					Utility_Functions.xSendKeys(driver, txt_userName, properties.getProperty("UATABEMEAManager"));
				} else if((dataTable.getData("General_Data", "TC_ID").contains("AB")) && (dataTable.getData("General_Data", "TC_ID").contains("EMEA")) && 
						(dataTable.getData("General_Data", "TC_ID").contains("Broker")))  { 
					Utility_Functions.xSendKeys(driver, txt_userName, properties.getProperty("UATABEMEBroker"));
				} else if((dataTable.getData("General_Data", "TC_ID").contains("AB")) && (dataTable.getData("General_Data", "TC_ID").contains("APAC")) && 
						(dataTable.getData("General_Data", "TC_ID").contains("CSS")))  {					
					Utility_Functions.xSendKeys(driver, txt_userName, properties.getProperty("UATABAPACCSS"));
				} else if((dataTable.getData("General_Data", "TC_ID").contains("AB")) && (dataTable.getData("General_Data", "TC_ID").contains("APAC")) && 
						(dataTable.getData("General_Data", "TC_ID").contains("Manager")))  { 
					Utility_Functions.xSendKeys(driver, txt_userName, properties.getProperty("UATABAPACManager"));
				} else if((dataTable.getData("General_Data", "TC_ID").contains("AB")) && (dataTable.getData("General_Data", "TC_ID").contains("APAC")) && 
						(dataTable.getData("General_Data", "TC_ID").contains("Broker")))  { 
					Utility_Functions.xSendKeys(driver, txt_userName, properties.getProperty("UATABAPACBroker"));
				} else if((dataTable.getData("General_Data", "TC_ID").contains("CM")) && (dataTable.getData("General_Data", "TC_ID").contains("AMER")) && 
						(dataTable.getData("General_Data", "TC_ID").contains("CSS")))  {					
					Utility_Functions.xSendKeys(driver, txt_userName, properties.getProperty("UATCMAMERCSS"));
				} else if((dataTable.getData("General_Data", "TC_ID").contains("CM")) && (dataTable.getData("General_Data", "TC_ID").contains("AMER")) && 
						(dataTable.getData("General_Data", "TC_ID").contains("Manager")))  { 
					Utility_Functions.xSendKeys(driver, txt_userName, properties.getProperty("UATCMAMERManager"));
				} else if((dataTable.getData("General_Data", "TC_ID").contains("CM")) && (dataTable.getData("General_Data", "TC_ID").contains("AMER")) && 
						(dataTable.getData("General_Data", "TC_ID").contains("Broker")))  { 
					Utility_Functions.xSendKeys(driver, txt_userName, properties.getProperty("UATCMAMERBroker"));
				} else if((dataTable.getData("General_Data", "TC_ID").contains("CM")) && (dataTable.getData("General_Data", "TC_ID").contains("EMEA")) && 
						(dataTable.getData("General_Data", "TC_ID").contains("CSS")))  {					
					Utility_Functions.xSendKeys(driver, txt_userName, properties.getProperty("UATCMEMEACSS"));
				} else if((dataTable.getData("General_Data", "TC_ID").contains("CM")) && (dataTable.getData("General_Data", "TC_ID").contains("EMEA")) && 
						(dataTable.getData("General_Data", "TC_ID").contains("Manager")))  { 
					Utility_Functions.xSendKeys(driver, txt_userName, properties.getProperty("UATCMEMEAManager"));
				} else if((dataTable.getData("General_Data", "TC_ID").contains("CM")) && (dataTable.getData("General_Data", "TC_ID").contains("EMEA")) && 
						(dataTable.getData("General_Data", "TC_ID").contains("Broker")))  { 
					Utility_Functions.xSendKeys(driver, txt_userName, properties.getProperty("UATCMEMEABroker"));
				} else if((dataTable.getData("General_Data", "TC_ID").contains("CM")) && (dataTable.getData("General_Data", "TC_ID").contains("APAC")) && 
						(dataTable.getData("General_Data", "TC_ID").contains("CSS")))  {					
					Utility_Functions.xSendKeys(driver, txt_userName, properties.getProperty("UATCMAPACCS"));
				} else if((dataTable.getData("General_Data", "TC_ID").contains("CM")) && (dataTable.getData("General_Data", "TC_ID").contains("APAC")) && 
						(dataTable.getData("General_Data", "TC_ID").contains("Manager")))  { 
					Utility_Functions.xSendKeys(driver, txt_userName, properties.getProperty("UATCMAPACManager"));
				} else if((dataTable.getData("General_Data", "TC_ID").contains("CM")) && (dataTable.getData("General_Data", "TC_ID").contains("APAC")) && 
						(dataTable.getData("General_Data", "TC_ID").contains("Broker")))  { 
					Utility_Functions.xSendKeys(driver, txt_userName, properties.getProperty("UATCMAPACBroker"));
				} 	
			} if(properties.getProperty("RunEnvironment").equals("FTE")) { 
				if(dataTable.getData("General_Data", "TC_ID").contains("Admin")) {
					Utility_Functions.xSendKeys(driver, txt_userName, properties.getProperty("FTESystemAdminUsername"));
				} else if((dataTable.getData("General_Data", "TC_ID").contains("OB")) && (dataTable.getData("General_Data", "TC_ID").contains("AMER")) && 
						(dataTable.getData("General_Data", "TC_ID").contains("CSS")))  {					
					Utility_Functions.xSendKeys(driver, txt_userName, properties.getProperty("FTEOBAMERCSS"));
				} else if((dataTable.getData("General_Data", "TC_ID").contains("OB")) && (dataTable.getData("General_Data", "TC_ID").contains("AMER")) && 
						(dataTable.getData("General_Data", "TC_ID").contains("Manager")))  { 
					Utility_Functions.xSendKeys(driver, txt_userName, properties.getProperty("FTEOBAMERManager"));
				} else if((dataTable.getData("General_Data", "TC_ID").contains("OB")) && (dataTable.getData("General_Data", "TC_ID").contains("AMER")) && 
						(dataTable.getData("General_Data", "TC_ID").contains("Broker")))  { 
					Utility_Functions.xSendKeys(driver, txt_userName, properties.getProperty("FTEOBAMERBroker"));
				} else if((dataTable.getData("General_Data", "TC_ID").contains("OB")) && (dataTable.getData("General_Data", "TC_ID").contains("EMEA")) && 
						(dataTable.getData("General_Data", "TC_ID").contains("CSS")))  {					
					Utility_Functions.xSendKeys(driver, txt_userName, properties.getProperty("FTEOBEMEACSS"));
				} else if((dataTable.getData("General_Data", "TC_ID").contains("OB")) && (dataTable.getData("General_Data", "TC_ID").contains("EMEA")) && 
						(dataTable.getData("General_Data", "TC_ID").contains("Manager")))  { 
					Utility_Functions.xSendKeys(driver, txt_userName, properties.getProperty("FTEOBEMEAManager"));
				} else if((dataTable.getData("General_Data", "TC_ID").contains("OB")) && (dataTable.getData("General_Data", "TC_ID").contains("EMEA")) && 
						(dataTable.getData("General_Data", "TC_ID").contains("Broker")))  { 
					Utility_Functions.xSendKeys(driver, txt_userName, properties.getProperty("FTEOBEMEABroker"));
				} else if((dataTable.getData("General_Data", "TC_ID").contains("OB")) && (dataTable.getData("General_Data", "TC_ID").contains("APAC")) && 
						(dataTable.getData("General_Data", "TC_ID").contains("CSS")))  {					
					Utility_Functions.xSendKeys(driver, txt_userName, properties.getProperty("FTEOBAPACCSS"));
				} else if((dataTable.getData("General_Data", "TC_ID").contains("OB")) && (dataTable.getData("General_Data", "TC_ID").contains("APAC")) && 
						(dataTable.getData("General_Data", "TC_ID").contains("Manager")))  { 
					Utility_Functions.xSendKeys(driver, txt_userName, properties.getProperty("FTEOBAPACManager"));
				} else if((dataTable.getData("General_Data", "TC_ID").contains("OB")) && (dataTable.getData("General_Data", "TC_ID").contains("APAC")) && 
						(dataTable.getData("General_Data", "TC_ID").contains("Broker")))  { 
					Utility_Functions.xSendKeys(driver, txt_userName, properties.getProperty("FTEOBAPACBroker"));
				} else if((dataTable.getData("General_Data", "TC_ID").contains("AB")) && (dataTable.getData("General_Data", "TC_ID").contains("AMER")) && 
						(dataTable.getData("General_Data", "TC_ID").contains("CSS")))  {					
					Utility_Functions.xSendKeys(driver, txt_userName, properties.getProperty("FTEABAMERCSS"));
				} else if((dataTable.getData("General_Data", "TC_ID").contains("AB")) && (dataTable.getData("General_Data", "TC_ID").contains("AMER")) && 
						(dataTable.getData("General_Data", "TC_ID").contains("Manager")))  { 
					Utility_Functions.xSendKeys(driver, txt_userName, properties.getProperty("FTEABAMEManager"));
				} else if((dataTable.getData("General_Data", "TC_ID").contains("AB")) && (dataTable.getData("General_Data", "TC_ID").contains("AMER")) && 
						(dataTable.getData("General_Data", "TC_ID").contains("Broker")))  { 
					Utility_Functions.xSendKeys(driver, txt_userName, properties.getProperty("FTEABAMERBroker"));
				} else if((dataTable.getData("General_Data", "TC_ID").contains("AB")) && (dataTable.getData("General_Data", "TC_ID").contains("EMEA")) && 
						(dataTable.getData("General_Data", "TC_ID").contains("CSS")))  {					
					Utility_Functions.xSendKeys(driver, txt_userName, properties.getProperty("FTEABEMEACSS"));
				} else if((dataTable.getData("General_Data", "TC_ID").contains("AB")) && (dataTable.getData("General_Data", "TC_ID").contains("EMEA")) && 
						(dataTable.getData("General_Data", "TC_ID").contains("Manager")))  { 
					Utility_Functions.xSendKeys(driver, txt_userName, properties.getProperty("FTEABEMEAManager"));
					Utility_Functions.xSendKeys(driver, txt_password, properties.getProperty("FTEPassword"));
				} else if((dataTable.getData("General_Data", "TC_ID").contains("AB")) && (dataTable.getData("General_Data", "TC_ID").contains("EMEA")) && 
						(dataTable.getData("General_Data", "TC_ID").contains("Broker")))  { 
					Utility_Functions.xSendKeys(driver, txt_userName, properties.getProperty("FTEABEMEBroker"));
				} else if((dataTable.getData("General_Data", "TC_ID").contains("AB")) && (dataTable.getData("General_Data", "TC_ID").contains("APAC")) && 
						(dataTable.getData("General_Data", "TC_ID").contains("CSS")))  {					
					Utility_Functions.xSendKeys(driver, txt_userName, properties.getProperty("FTEABAPACCSS"));
					Utility_Functions.xSendKeys(driver, txt_password, properties.getProperty("FTEPassword"));
				} else if((dataTable.getData("General_Data", "TC_ID").contains("AB")) && (dataTable.getData("General_Data", "TC_ID").contains("APAC")) && 
						(dataTable.getData("General_Data", "TC_ID").contains("Manager")))  { 
					Utility_Functions.xSendKeys(driver, txt_userName, properties.getProperty("FTEABAPACManager"));
				} else if((dataTable.getData("General_Data", "TC_ID").contains("AB")) && (dataTable.getData("General_Data", "TC_ID").contains("APAC")) && 
						(dataTable.getData("General_Data", "TC_ID").contains("Broker")))  { 
					Utility_Functions.xSendKeys(driver, txt_userName, properties.getProperty("FTEABAPACBroker"));
				} else if((dataTable.getData("General_Data", "TC_ID").contains("CM")) && (dataTable.getData("General_Data", "TC_ID").contains("AMER")) && 
						(dataTable.getData("General_Data", "TC_ID").contains("CSS")))  {					
					Utility_Functions.xSendKeys(driver, txt_userName, properties.getProperty("FTECMAMERCSS"));
				} else if((dataTable.getData("General_Data", "TC_ID").contains("CM")) && (dataTable.getData("General_Data", "TC_ID").contains("AMER")) && 
						(dataTable.getData("General_Data", "TC_ID").contains("Manager")))  { 
					Utility_Functions.xSendKeys(driver, txt_userName, properties.getProperty("FTECMAMERManager"));
				} else if((dataTable.getData("General_Data", "TC_ID").contains("CM")) && (dataTable.getData("General_Data", "TC_ID").contains("AMER")) && 
						(dataTable.getData("General_Data", "TC_ID").contains("Broker")))  { 
					Utility_Functions.xSendKeys(driver, txt_userName, properties.getProperty("FTECMAMERBroker"));
				} else if((dataTable.getData("General_Data", "TC_ID").contains("CM")) && (dataTable.getData("General_Data", "TC_ID").contains("EMEA")) && 
						(dataTable.getData("General_Data", "TC_ID").contains("CSS")))  {					
					Utility_Functions.xSendKeys(driver, txt_userName, properties.getProperty("FTECMEMEACSS"));
				} else if((dataTable.getData("General_Data", "TC_ID").contains("CM")) && (dataTable.getData("General_Data", "TC_ID").contains("EMEA")) && 
						(dataTable.getData("General_Data", "TC_ID").contains("Manager")))  { 
					Utility_Functions.xSendKeys(driver, txt_userName, properties.getProperty("FTECMEMEAManager"));
				} else if((dataTable.getData("General_Data", "TC_ID").contains("CM")) && (dataTable.getData("General_Data", "TC_ID").contains("EMEA")) && 
						(dataTable.getData("General_Data", "TC_ID").contains("Broker")))  { 
					Utility_Functions.xSendKeys(driver, txt_userName, properties.getProperty("FTECMEMEABroker"));
				} else if((dataTable.getData("General_Data", "TC_ID").contains("CM")) && (dataTable.getData("General_Data", "TC_ID").contains("APAC")) && 
						(dataTable.getData("General_Data", "TC_ID").contains("CSS")))  {					
					Utility_Functions.xSendKeys(driver, txt_userName, properties.getProperty("FTECMAPACCS"));
				} else if((dataTable.getData("General_Data", "TC_ID").contains("CM")) && (dataTable.getData("General_Data", "TC_ID").contains("APAC")) && 
						(dataTable.getData("General_Data", "TC_ID").contains("Manager")))  { 
					Utility_Functions.xSendKeys(driver, txt_userName, properties.getProperty("FTECMAPACManager"));
				} else if((dataTable.getData("General_Data", "TC_ID").contains("CM")) && (dataTable.getData("General_Data", "TC_ID").contains("APAC")) && 
						(dataTable.getData("General_Data", "TC_ID").contains("Broker")))  { 
					Utility_Functions.xSendKeys(driver, txt_userName, properties.getProperty("FTECMAPACBroker"));
				} else if((dataTable.getData("General_Data", "TC_ID").contains("VAS")) && (dataTable.getData("General_Data", "TC_ID").contains("AMER")) && 
						(dataTable.getData("General_Data", "TC_ID").contains("Manager")))  { 
					Utility_Functions.xSendKeys(driver, txt_userName, properties.getProperty("VASAMERManager"));
				} else if((dataTable.getData("General_Data", "TC_ID").contains("VAS")) && (dataTable.getData("General_Data", "TC_ID").contains("EMEA")) && 
						(dataTable.getData("General_Data", "TC_ID").contains("Broker")))  { 
					Utility_Functions.xSendKeys(driver, txt_userName, properties.getProperty("VASEMEABroker"));
				} else if((dataTable.getData("General_Data", "TC_ID").contains("AS")) && (dataTable.getData("General_Data", "TC_ID").contains("AMER")) && 
						(dataTable.getData("General_Data", "TC_ID").contains("Manager")))  { 
					Utility_Functions.xSendKeys(driver, txt_userName, properties.getProperty("ASAMERManager"));
				} else if((dataTable.getData("General_Data", "TC_ID").contains("AS")) && (dataTable.getData("General_Data", "TC_ID").contains("APAC")) && 
						(dataTable.getData("General_Data", "TC_ID").contains("Broker")))  { 
					Utility_Functions.xSendKeys(driver, txt_userName, properties.getProperty("ASAPACBroker"));
				} 	else if((dataTable.getData("General_Data", "TC_ID").contains("AS")) && (dataTable.getData("General_Data", "TC_ID").contains("EMEA")) && 
						(dataTable.getData("General_Data", "TC_ID").contains("Manager")))  { 
					Utility_Functions.xSendKeys(driver, txt_userName, properties.getProperty("ASEMEAManager"));
				} 		
			}
			Utility_Functions.timeWait(1);	
			if(properties.getProperty("RunEnvironment").equals("UAT")) { 
				if(dataTable.getData("General_Data", "TC_ID").contains("Admin")) {
					Utility_Functions.xSendKeys(driver, txt_password, properties.getProperty("UATAdminPassword"));		
				} else {
					Utility_Functions.xSendKeys(driver, txt_password, properties.getProperty("Password"));
				}
			} 
			if(properties.getProperty("RunEnvironment").equals("FTE")) { 
				if(dataTable.getData("General_Data", "TC_ID").contains("Admin")) {
					Utility_Functions.xSendKeys(driver, txt_password, properties.getProperty("FTEAdminPassword"));	
				} else if((dataTable.getData("General_Data", "TC_ID").contains("GWS")) && (dataTable.getData("General_Data", "TC_ID").contains("AMER")) && 
						(dataTable.getData("General_Data", "TC_ID").contains("Broker"))) {
					Utility_Functions.xSendKeys(driver, txt_password, properties.getProperty("FTEGWSAMERBrokerPasword"));
				} else if((dataTable.getData("General_Data", "TC_ID").contains("GWS")) && (dataTable.getData("General_Data", "TC_ID").contains("APAC")) && 
						(dataTable.getData("General_Data", "TC_ID").contains("Manager"))) {
					Utility_Functions.xSendKeys(driver, txt_password, properties.getProperty("FTEGWSAPACManagerPassword"));
				} else if((dataTable.getData("General_Data", "TC_ID").contains("GWS")) && (dataTable.getData("General_Data", "TC_ID").contains("EMEA")) && 
						(dataTable.getData("General_Data", "TC_ID").contains("Broker"))) {
					Utility_Functions.xSendKeys(driver, txt_password, properties.getProperty("FTEGWSEMEABrokerPassword"));
				} else if((dataTable.getData("General_Data", "TC_ID").contains("VAS")) && (dataTable.getData("General_Data", "TC_ID").contains("AMER")) && 
						(dataTable.getData("General_Data", "TC_ID").contains("Manager"))) {
					Utility_Functions.xSendKeys(driver, txt_password, properties.getProperty("VASAMERManagerPassword"));
				} else if((dataTable.getData("General_Data", "TC_ID").contains("VAS")) && (dataTable.getData("General_Data", "TC_ID").contains("APAC")) && 
						(dataTable.getData("General_Data", "TC_ID").contains("Broker"))) {
					Utility_Functions.xSendKeys(driver, txt_password, properties.getProperty("VASAPACBrokerPassword"));
				} else if((dataTable.getData("General_Data", "TC_ID").contains("VAS")) && (dataTable.getData("General_Data", "TC_ID").contains("EMEA")) && 
						(dataTable.getData("General_Data", "TC_ID").contains("Broker"))) {
					Utility_Functions.xSendKeys(driver, txt_password, properties.getProperty("VASEMEABrokerPassword"));
				} else if((dataTable.getData("General_Data", "TC_ID").contains("AS")) && (dataTable.getData("General_Data", "TC_ID").contains("AMER")) && 
						(dataTable.getData("General_Data", "TC_ID").contains("Manager"))) {
					Utility_Functions.xSendKeys(driver, txt_password, properties.getProperty("ASAMERManagerPassowrd"));
				} else if((dataTable.getData("General_Data", "TC_ID").contains("AS")) && (dataTable.getData("General_Data", "TC_ID").contains("APAC")) && 
						(dataTable.getData("General_Data", "TC_ID").contains("Broker"))) {
					Utility_Functions.xSendKeys(driver, txt_password, properties.getProperty("ASAPACBrokerPassword"));
				} else if((dataTable.getData("General_Data", "TC_ID").contains("AS")) && (dataTable.getData("General_Data", "TC_ID").contains("EMEA")) && 
						(dataTable.getData("General_Data", "TC_ID").contains("Manager"))) {
					Utility_Functions.xSendKeys(driver, txt_password, properties.getProperty("ASEMEAManagerPassword"));
				} else {
					Utility_Functions.xSendKeys(driver, txt_password, properties.getProperty("Password"));
				}
			} 
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
