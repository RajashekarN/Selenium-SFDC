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

	@FindBy(xpath = "//a[@class='continue][text()='Continue']")
	WebElement continueLink;

	/**
	 * Validating the browser launch functionality
	 * 
	 * @author Vishnuvardhan
	 *
	 */
	public String environment = properties.getProperty("RunEnvironment");
	//public String environment = System.getProperty("RunEnvironment");

	public void invokeApplication() {
		report.updateTestLog("Invoke Application",
				"Invoke the application under test @ " + properties.getProperty("ApplicationUrl"), Status.PASS);
		if (environment.equals("UAT")) {
			driver.get(properties.getProperty("ApplicationUATUrl"));
		} else if (environment.equals("UAT2")) {
			driver.get(properties.getProperty("ApplicationUAT2Url"));
		} else if (environment.equals("FTE")) {
			driver.get(properties.getProperty("ApplicationFTEUrl"));
		} else if (environment.equals("FTE2")) {
			driver.get(properties.getProperty("ApplicationFTE2Url"));
		}
		Utility_Functions.xWaitForElementPresent(driver, txt_userName, 10);
	}

	/**
	 * Validating the Login functionality
	 * 
	 * @author Vishnuvardhan
	 *
	 */
	public void login() {
		try {
			if ((environment.equals("UAT")) || (environment.equals("UAT2")) || (environment.equals("FTE")) || (environment.equals("FTE2"))) {
				if (dataTable.getData("General_Data", "TC_ID").contains("Admin")) {
					Utility_Functions.xSendKeys(driver, txt_userName, properties.getProperty(environment+"SystemAdminUsername"));
				} else if ((dataTable.getData("General_Data", "TC_ID").contains("OBAMER")) && (dataTable.getData("General_Data", "TC_ID").contains("CSS"))) {
					Utility_Functions.xSendKeys(driver, txt_userName, properties.getProperty(environment+"OBAMERCSS"));
				} else if ((dataTable.getData("General_Data", "TC_ID").contains("OBAMER")) && (dataTable.getData("General_Data", "TC_ID").contains("Manager"))) {
					Utility_Functions.xSendKeys(driver, txt_userName, properties.getProperty(environment+"OBAMERManager"));
				} else if ((dataTable.getData("General_Data", "TC_ID").contains("OBAMER")) && (dataTable.getData("General_Data", "TC_ID").contains("Broker"))) {
					Utility_Functions.xSendKeys(driver, txt_userName, properties.getProperty(environment+"OBAMERBroker"));
				} else if ((dataTable.getData("General_Data", "TC_ID").contains("OBEMEA")) && (dataTable.getData("General_Data", "TC_ID").contains("CSS"))) {
					Utility_Functions.xSendKeys(driver, txt_userName, properties.getProperty(environment+"OBEMEACSS"));
				} else if ((dataTable.getData("General_Data", "TC_ID").contains("OBEMEA")) && (dataTable.getData("General_Data", "TC_ID").contains("Manager"))) {
					Utility_Functions.xSendKeys(driver, txt_userName, properties.getProperty(environment+"OBEMEAManager"));
				} else if ((dataTable.getData("General_Data", "TC_ID").contains("OBEMEA")) && (dataTable.getData("General_Data", "TC_ID").contains("Broker"))) {
					Utility_Functions.xSendKeys(driver, txt_userName, properties.getProperty(environment+"OBEMEABroker"));
				} else if ((dataTable.getData("General_Data", "TC_ID").contains("OBAPAC")) && (dataTable.getData("General_Data", "TC_ID").contains("CSS"))) {
					Utility_Functions.xSendKeys(driver, txt_userName, properties.getProperty(environment+"OBAPACCSS"));
				} else if ((dataTable.getData("General_Data", "TC_ID").contains("OBAPAC")) && (dataTable.getData("General_Data", "TC_ID").contains("Manager"))) {
					Utility_Functions.xSendKeys(driver, txt_userName, properties.getProperty(environment+"OBAPACManager"));
				} else if ((dataTable.getData("General_Data", "TC_ID").contains("OBAPAC")) && (dataTable.getData("General_Data", "TC_ID").contains("Broker"))) {
					Utility_Functions.xSendKeys(driver, txt_userName, properties.getProperty(environment+"OBAPACBroker"));

				} else if ((dataTable.getData("General_Data", "TC_ID").contains("ABAMER")) && (dataTable.getData("General_Data", "TC_ID").contains("CSS"))) {
					Utility_Functions.xSendKeys(driver, txt_userName, properties.getProperty(environment+"ABAMERCSS"));
				} else if ((dataTable.getData("General_Data", "TC_ID").contains("ABAMER")) && (dataTable.getData("General_Data", "TC_ID").contains("Manager"))) {
					Utility_Functions.xSendKeys(driver, txt_userName, properties.getProperty(environment+"ABAMERManager"));
				} else if ((dataTable.getData("General_Data", "TC_ID").contains("ABAMER")) && (dataTable.getData("General_Data", "TC_ID").contains("Broker"))) {
					Utility_Functions.xSendKeys(driver, txt_userName, properties.getProperty(environment+"ABAMERBroker"));
				} else if ((dataTable.getData("General_Data", "TC_ID").contains("ABEMEA")) && (dataTable.getData("General_Data", "TC_ID").contains("CSS"))) {
					Utility_Functions.xSendKeys(driver, txt_userName, properties.getProperty(environment+"ABEMEACSS"));
				} else if ((dataTable.getData("General_Data", "TC_ID").contains("ABEMEA")) && (dataTable.getData("General_Data", "TC_ID").contains("Manager"))) {
					Utility_Functions.xSendKeys(driver, txt_userName, properties.getProperty(environment+"ABEMEAManager"));
				} else if ((dataTable.getData("General_Data", "TC_ID").contains("ABEMEA")) && (dataTable.getData("General_Data", "TC_ID").contains("Broker"))) {
					Utility_Functions.xSendKeys(driver, txt_userName, properties.getProperty(environment+"ABEMEBroker"));
				} else if ((dataTable.getData("General_Data", "TC_ID").contains("ABAPAC")) && (dataTable.getData("General_Data", "TC_ID").contains("CSS"))) {
					Utility_Functions.xSendKeys(driver, txt_userName, properties.getProperty(environment+"ABAPACCSS"));
				} else if ((dataTable.getData("General_Data", "TC_ID").contains("ABAPAC")) && (dataTable.getData("General_Data", "TC_ID").contains("Manager"))) {
					Utility_Functions.xSendKeys(driver, txt_userName, properties.getProperty(environment+"ABAPACManager"));
				} else if ((dataTable.getData("General_Data", "TC_ID").contains("ABAPAC")) && (dataTable.getData("General_Data", "TC_ID").contains("Broker"))) {
					Utility_Functions.xSendKeys(driver, txt_userName, properties.getProperty(environment+"ABAPACBroker"));

				} else if ((dataTable.getData("General_Data", "TC_ID").contains("CMAMER")) && (dataTable.getData("General_Data", "TC_ID").contains("CSS"))) {
					Utility_Functions.xSendKeys(driver, txt_userName, properties.getProperty(environment+"CMAMERCSS"));
				} else if ((dataTable.getData("General_Data", "TC_ID").contains("CMAMER")) && (dataTable.getData("General_Data", "TC_ID").contains("Manager"))) {
					Utility_Functions.xSendKeys(driver, txt_userName, properties.getProperty(environment+"CMAMERManager"));
				} else if ((dataTable.getData("General_Data", "TC_ID").contains("CMAMER")) && (dataTable.getData("General_Data", "TC_ID").contains("Broker"))) {
					Utility_Functions.xSendKeys(driver, txt_userName, properties.getProperty(environment+"CMAMERBroker"));
				} else if ((dataTable.getData("General_Data", "TC_ID").contains("CMEMEA")) && (dataTable.getData("General_Data", "TC_ID").contains("CSS"))) {
					Utility_Functions.xSendKeys(driver, txt_userName, properties.getProperty(environment+"CMEMEACSS"));
				} else if ((dataTable.getData("General_Data", "TC_ID").contains("CMEMEA")) && (dataTable.getData("General_Data", "TC_ID").contains("Manager"))) {
					Utility_Functions.xSendKeys(driver, txt_userName, properties.getProperty(environment+"CMEMEAManager"));
				} else if ((dataTable.getData("General_Data", "TC_ID").contains("CMEMEA")) && (dataTable.getData("General_Data", "TC_ID").contains("Broker"))) {
					Utility_Functions.xSendKeys(driver, txt_userName, properties.getProperty(environment+"CMEMEABroker"));
				} else if ((dataTable.getData("General_Data", "TC_ID").contains("CMAPAC")) && (dataTable.getData("General_Data", "TC_ID").contains("CSS"))) {
					Utility_Functions.xSendKeys(driver, txt_userName, properties.getProperty(environment+"CMAPACCS"));
				} else if ((dataTable.getData("General_Data", "TC_ID").contains("CMAPAC")) && (dataTable.getData("General_Data", "TC_ID").contains("Manager"))) {
					Utility_Functions.xSendKeys(driver, txt_userName, properties.getProperty(environment+"CMAPACManager"));
				} else if ((dataTable.getData("General_Data", "TC_ID").contains("CMAPAC")) && (dataTable.getData("General_Data", "TC_ID").contains("Broker"))) {
					Utility_Functions.xSendKeys(driver, txt_userName, properties.getProperty(environment+"CMAPACBroker"));

				} else if ((dataTable.getData("General_Data", "TC_ID").contains("CMEMEA")) && (dataTable.getData("General_Data", "TC_ID").contains("CSSIP"))) {
					Utility_Functions.xSendKeys(driver, txt_userName, properties.getProperty(environment+"CMEMEACSS"));
				} else if ((dataTable.getData("General_Data", "TC_ID").contains("CMEMEA")) && (dataTable.getData("General_Data", "TC_ID").contains("ManagerIP"))) {
					Utility_Functions.xSendKeys(driver, txt_userName, properties.getProperty(environment+"CMEMEAManager"));
				} else if ((dataTable.getData("General_Data", "TC_ID").contains("CMEMEA")) && (dataTable.getData("General_Data", "TC_ID").contains("BrokerIP"))) {
					Utility_Functions.xSendKeys(driver, txt_userName, properties.getProperty(environment+"CMEMEABroker"));
					
				} else if ((dataTable.getData("General_Data", "TC_ID").contains("VASAMER")) && (dataTable.getData("General_Data", "TC_ID").contains("Manager"))) {
					Utility_Functions.xSendKeys(driver, txt_userName, properties.getProperty(environment+"VASAMERManager"));
				} else if ((dataTable.getData("General_Data", "TC_ID").contains("VASAMER")) && (dataTable.getData("General_Data", "TC_ID").contains("Broker"))) {
					Utility_Functions.xSendKeys(driver, txt_userName, properties.getProperty(environment+"VASAMERBroker"));
				} else if ((dataTable.getData("General_Data", "TC_ID").contains("VASAMER")) && (dataTable.getData("General_Data", "TC_ID").contains("CSS"))) {
					Utility_Functions.xSendKeys(driver, txt_userName, properties.getProperty(environment+"VASAMERCSS"));
				} else if ((dataTable.getData("General_Data", "TC_ID").contains("VASEMEA")) && (dataTable.getData("General_Data", "TC_ID").contains("Manager"))) {
					Utility_Functions.xSendKeys(driver, txt_userName, properties.getProperty(environment+"VASEMEAManager"));
				} else if ((dataTable.getData("General_Data", "TC_ID").contains("VASEMEA")) && (dataTable.getData("General_Data", "TC_ID").contains("Broker"))) {
					Utility_Functions.xSendKeys(driver, txt_userName, properties.getProperty(environment+"VASEMEABroker"));
				} else if ((dataTable.getData("General_Data", "TC_ID").contains("VASEMEA")) && (dataTable.getData("General_Data", "TC_ID").contains("CSS"))) {
					Utility_Functions.xSendKeys(driver, txt_userName, properties.getProperty(environment+"VASEMEACSS"));
				} else if ((dataTable.getData("General_Data", "TC_ID").contains("VASAPAC")) && (dataTable.getData("General_Data", "TC_ID").contains("Manager"))) {
					Utility_Functions.xSendKeys(driver, txt_userName, properties.getProperty(environment+"VASAPACManager"));
				} else if ((dataTable.getData("General_Data", "TC_ID").contains("VASAPAC")) && (dataTable.getData("General_Data", "TC_ID").contains("Broker"))) {
					Utility_Functions.xSendKeys(driver, txt_userName, properties.getProperty(environment+"VASAPACBroker"));
				} else if ((dataTable.getData("General_Data", "TC_ID").contains("VASAPAC")) && (dataTable.getData("General_Data", "TC_ID").contains("CSS"))) {
					Utility_Functions.xSendKeys(driver, txt_userName, properties.getProperty(environment+"VASAPACCSS"));

				} else if ((dataTable.getData("General_Data", "TC_ID").contains("ASAMER")) && (dataTable.getData("General_Data", "TC_ID").contains("Manager"))) {
					Utility_Functions.xSendKeys(driver, txt_userName, properties.getProperty(environment+"ASAMERManager"));
				} else if ((dataTable.getData("General_Data", "TC_ID").contains("ASAMER")) && (dataTable.getData("General_Data", "TC_ID").contains("Broker"))) {
					Utility_Functions.xSendKeys(driver, txt_userName, properties.getProperty(environment+"ASAMERBroker"));
				} else if ((dataTable.getData("General_Data", "TC_ID").contains("ASAMER")) && (dataTable.getData("General_Data", "TC_ID").contains("CSS"))) {
					Utility_Functions.xSendKeys(driver, txt_userName, properties.getProperty(environment+"ASAMERCSS"));
				} else if ((dataTable.getData("General_Data", "TC_ID").contains("ASEMEA")) && (dataTable.getData("General_Data", "TC_ID").contains("Manager"))) {
					Utility_Functions.xSendKeys(driver, txt_userName, properties.getProperty(environment+"ASEMEAManager"));
				} else if ((dataTable.getData("General_Data", "TC_ID").contains("ASEMEA")) && (dataTable.getData("General_Data", "TC_ID").contains("Broker"))) {
					Utility_Functions.xSendKeys(driver, txt_userName, properties.getProperty(environment+"ASEMEABroker"));
				} else if ((dataTable.getData("General_Data", "TC_ID").contains("ASEMEA")) && (dataTable.getData("General_Data", "TC_ID").contains("CSS"))) {
					Utility_Functions.xSendKeys(driver, txt_userName, properties.getProperty(environment+"ASEMEACSS"));
				} else if ((dataTable.getData("General_Data", "TC_ID").contains("ASAPAC")) && (dataTable.getData("General_Data", "TC_ID").contains("Manager"))) {
					Utility_Functions.xSendKeys(driver, txt_userName, properties.getProperty(environment+"ASAPACManager"));
				} else if ((dataTable.getData("General_Data", "TC_ID").contains("ASAPAC")) && (dataTable.getData("General_Data", "TC_ID").contains("Broker"))) {
					Utility_Functions.xSendKeys(driver, txt_userName, properties.getProperty(environment+"ASAPACBroker"));
				} else if ((dataTable.getData("General_Data", "TC_ID").contains("ASAPAC")) && (dataTable.getData("General_Data", "TC_ID").contains("CSS"))) {
					Utility_Functions.xSendKeys(driver, txt_userName, properties.getProperty(environment+"ASAPACCSS"));

				} else if ((dataTable.getData("General_Data", "TC_ID").contains("GWSAMER"))	&& (dataTable.getData("General_Data", "TC_ID").contains("Manager"))) {
					Utility_Functions.xSendKeys(driver, txt_userName, properties.getProperty(environment+"GWSAMERManager"));
				} else if ((dataTable.getData("General_Data", "TC_ID").contains("GWSAMER"))	&& (dataTable.getData("General_Data", "TC_ID").contains("Broker"))) {
					Utility_Functions.xSendKeys(driver, txt_userName, properties.getProperty(environment+"GWSAMERBroker"));
				} else if ((dataTable.getData("General_Data", "TC_ID").contains("GWSAMER"))	&& (dataTable.getData("General_Data", "TC_ID").contains("CSS"))) {
					Utility_Functions.xSendKeys(driver, txt_userName, properties.getProperty(environment+"GWSAMERCSS"));
				} else if ((dataTable.getData("General_Data", "TC_ID").contains("GWSEMEA"))	&& (dataTable.getData("General_Data", "TC_ID").contains("Manager"))) {
					Utility_Functions.xSendKeys(driver, txt_userName, properties.getProperty(environment+"GWSEMEAManager"));
				} else if ((dataTable.getData("General_Data", "TC_ID").contains("GWSEMEA"))	&& (dataTable.getData("General_Data", "TC_ID").contains("Broker"))) {
					Utility_Functions.xSendKeys(driver, txt_userName, properties.getProperty(environment+"GWSEMEABroker"));
				} else if ((dataTable.getData("General_Data", "TC_ID").contains("GWSEMEA"))	&& (dataTable.getData("General_Data", "TC_ID").contains("CSS"))) {
					Utility_Functions.xSendKeys(driver, txt_userName, properties.getProperty(environment+"GWSEMEACSS"));
				} else if ((dataTable.getData("General_Data", "TC_ID").contains("GWSAPAC")) && (dataTable.getData("General_Data", "TC_ID").contains("Manager"))) {
					Utility_Functions.xSendKeys(driver, txt_userName, properties.getProperty(environment+"GWSAPACManager"));
				} else if ((dataTable.getData("General_Data", "TC_ID").contains("GWSAPAC")) && (dataTable.getData("General_Data", "TC_ID").contains("Broker"))) {
					Utility_Functions.xSendKeys(driver, txt_userName, properties.getProperty(environment+"GWSAPACBroker"));
				} else if ((dataTable.getData("General_Data", "TC_ID").contains("GWSAPAC"))	&& (dataTable.getData("General_Data", "TC_ID").contains("CSS"))) {
					Utility_Functions.xSendKeys(driver, txt_userName, properties.getProperty(environment+"GWSAPACCSS"));

				} else if ((dataTable.getData("General_Data", "TC_ID").contains("DAAMER")) && (dataTable.getData("General_Data", "TC_ID").contains("Data"))) {
					Utility_Functions.xSendKeys(driver, txt_userName, properties.getProperty(environment+"DAAMERData"));
				} else if ((dataTable.getData("General_Data", "TC_ID").contains("DAEMEA")) && (dataTable.getData("General_Data", "TC_ID").contains("Data"))) {
					Utility_Functions.xSendKeys(driver, txt_userName, properties.getProperty(environment+"DAEMEAData"));
				} else if ((dataTable.getData("General_Data", "TC_ID").contains("DAAPAC")) && (dataTable.getData("General_Data", "TC_ID").contains("Data"))) {
					Utility_Functions.xSendKeys(driver, txt_userName, properties.getProperty(environment+"DAAPACData"));
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
				} else if ((dataTable.getData("General_Data", "TC_ID").contains("GWSAMER")) && (dataTable.getData("General_Data", "TC_ID").contains("Broker"))) {
					Utility_Functions.xSendKeys(driver, txt_password, properties.getProperty("FTEGWSAMERBrokerPassword"));
				} else if ((dataTable.getData("General_Data", "TC_ID").contains("GWSAPAC"))	&& (dataTable.getData("General_Data", "TC_ID").contains("Manager"))) {
					Utility_Functions.xSendKeys(driver, txt_password, properties.getProperty("FTEGWSAPACManagerPassword"));
				} else if ((dataTable.getData("General_Data", "TC_ID").contains("GWSEMEA"))	&& (dataTable.getData("General_Data", "TC_ID").contains("Broker"))) {
					Utility_Functions.xSendKeys(driver, txt_password, properties.getProperty("FTEGWSEMEABrokerPassword"));

				} else if ((dataTable.getData("General_Data", "TC_ID").contains("VASAMER"))	&& (dataTable.getData("General_Data", "TC_ID").contains("Manager"))) {
					Utility_Functions.xSendKeys(driver, txt_password, properties.getProperty("FTEVASAMERManagerPassword"));
				} else if ((dataTable.getData("General_Data", "TC_ID").contains("VASAPAC")) && (dataTable.getData("General_Data", "TC_ID").contains("Broker"))) {
					Utility_Functions.xSendKeys(driver, txt_password, properties.getProperty("FFTEVASAPACBrokerPassword"));
				} else if ((dataTable.getData("General_Data", "TC_ID").contains("VASEMEA"))
						&& (dataTable.getData("General_Data", "TC_ID").contains("Broker"))) {
					Utility_Functions.xSendKeys(driver, txt_password, properties.getProperty("FTEVASEMEABrokerPassword"));

				} else if ((dataTable.getData("General_Data", "TC_ID").contains("ASAMER")) && (dataTable.getData("General_Data", "TC_ID").contains("Manager"))) {
					Utility_Functions.xSendKeys(driver, txt_password, properties.getProperty("FTEASAMERManagerPassword"));
				} else if ((dataTable.getData("General_Data", "TC_ID").contains("ASAPAC")) && (dataTable.getData("General_Data", "TC_ID").contains("Broker"))) {
					Utility_Functions.xSendKeys(driver, txt_password, properties.getProperty("FTEASAPACBrokerPassword"));
				} else if ((dataTable.getData("General_Data", "TC_ID").contains("ASEMEA")) && (dataTable.getData("General_Data", "TC_ID").contains("Manager"))) {
					Utility_Functions.xSendKeys(driver, txt_password, properties.getProperty("FTEASEMEAManagerPassword"));
				} else if ((dataTable.getData("General_Data", "TC_ID").contains("ASEMEA")) && (dataTable.getData("General_Data", "TC_ID").contains("Broker"))) {
					Utility_Functions.xSendKeys(driver, txt_password, properties.getProperty("FTEASEMEABrokerPassword"));
				} else if ((dataTable.getData("General_Data", "TC_ID").contains("ASAMER")) && (dataTable.getData("General_Data", "TC_ID").contains("Broker"))) {
					Utility_Functions.xSendKeys(driver, txt_password, properties.getProperty("FTEASAMERBrokerPassword"));
				} else {
					Utility_Functions.xSendKeys(driver, txt_password, properties.getProperty("FTEPassword"));
				}
			} else if (environment.equals("FTE2")) {
				if (dataTable.getData("General_Data", "TC_ID").contains("Admin")) {
					Utility_Functions.xSendKeys(driver, txt_password, properties.getProperty("FTE2AdminPassword"));

				} else if ((dataTable.getData("General_Data", "TC_ID").contains("ABAMER")) && (dataTable.getData("General_Data", "TC_ID").contains("Broker"))) {
					Utility_Functions.xSendKeys(driver, txt_password, properties.getProperty("FTE2ABAMERBrokerPassword"));

				} else if ((dataTable.getData("General_Data", "TC_ID").contains("CMAPAC")) && (dataTable.getData("General_Data", "TC_ID").contains("CSS"))) {
					Utility_Functions.xSendKeys(driver, txt_password, properties.getProperty("FTE2CMAPACCSSPassword"));

				} else if ((dataTable.getData("General_Data", "TC_ID").contains("GWSAMER")) && (dataTable.getData("General_Data", "TC_ID").contains("Broker"))) {
					Utility_Functions.xSendKeys(driver, txt_password, properties.getProperty("FTE2GWSAMERBrokerPasword"));
				} else if ((dataTable.getData("General_Data", "TC_ID").contains("GWSAPAC")) && (dataTable.getData("General_Data", "TC_ID").contains("Manager"))) {
					Utility_Functions.xSendKeys(driver, txt_password, properties.getProperty("FTE2GWSAPACManagerPassword"));
				} else if ((dataTable.getData("General_Data", "TC_ID").contains("GWSEMEA"))	&& (dataTable.getData("General_Data", "TC_ID").contains("Broker"))) {
					Utility_Functions.xSendKeys(driver, txt_password, properties.getProperty("FTE2GWSEMEABrokerPassword"));

				} else if ((dataTable.getData("General_Data", "TC_ID").contains("VASAMER")) && (dataTable.getData("General_Data", "TC_ID").contains("Manager"))) {
					Utility_Functions.xSendKeys(driver, txt_password, properties.getProperty("FTE2VASAMERManagerPassword"));
				} else if ((dataTable.getData("General_Data", "TC_ID").contains("VASAPAC"))	&& (dataTable.getData("General_Data", "TC_ID").contains("Broker"))) {
					Utility_Functions.xSendKeys(driver, txt_password, properties.getProperty("FTE2VASAPACBrokerPassword"));
				} else if ((dataTable.getData("General_Data", "TC_ID").contains("VASEMEA"))	&& (dataTable.getData("General_Data", "TC_ID").contains("Broker"))) {
					Utility_Functions.xSendKeys(driver, txt_password, properties.getProperty("FTE2VASEMEABrokerPassword"));

				} else if ((dataTable.getData("General_Data", "TC_ID").contains("ASAMER")) && (dataTable.getData("General_Data", "TC_ID").contains("Manager"))) {
					Utility_Functions.xSendKeys(driver, txt_password, properties.getProperty("FTE2ASAMERManagerPassword"));
				} else if ((dataTable.getData("General_Data", "TC_ID").contains("ASAPAC")) && (dataTable.getData("General_Data", "TC_ID").contains("Broker"))) {
					Utility_Functions.xSendKeys(driver, txt_password, properties.getProperty("FTE2ASAPACBrokerPassword"));
				} else if ((dataTable.getData("General_Data", "TC_ID").contains("ASEMEA")) && (dataTable.getData("General_Data", "TC_ID").contains("Manager"))) {
					Utility_Functions.xSendKeys(driver, txt_password, properties.getProperty("FTE2ASEMEAManagerPassword"));
				} else if ((dataTable.getData("General_Data", "TC_ID").contains("ASEMEA")) && (dataTable.getData("General_Data", "TC_ID").contains("Broker"))) {
					Utility_Functions.xSendKeys(driver, txt_password, properties.getProperty("FTE2ASEMEABrokerPassword"));
				} else if ((dataTable.getData("General_Data", "TC_ID").contains("ASAMER")) && (dataTable.getData("General_Data", "TC_ID").contains("Broker"))) {
					Utility_Functions.xSendKeys(driver, txt_password, properties.getProperty("FTE2ASAMERBrokerPassword"));
				} else if ((dataTable.getData("General_Data", "TC_ID").contains("ASAPAC")) && (dataTable.getData("General_Data", "TC_ID").contains("Manager"))) {
					Utility_Functions.xSendKeys(driver, txt_password, properties.getProperty("FTE2ASAPACManagerPassword"));

				} else if ((dataTable.getData("General_Data", "TC_ID").contains("DAEMEA")) && (dataTable.getData("General_Data", "TC_ID").contains("Data"))) {
					Utility_Functions.xSendKeys(driver, txt_password, properties.getProperty("FTE2DAEMEADataPassword"));

				} else if ((dataTable.getData("General_Data", "TC_ID").contains("OBEMEA"))&& (dataTable.getData("General_Data", "TC_ID").contains("Broker"))) {
					Utility_Functions.xSendKeys(driver, txt_password, properties.getProperty("FTE2OBEMEABrokerPassword"));
				} else if ((dataTable.getData("General_Data", "TC_ID").contains("OBEMEA"))&& (dataTable.getData("General_Data", "TC_ID").contains("Manager"))) {
					Utility_Functions.xSendKeys(driver, txt_password, properties.getProperty("FTE2OBEMEAManagerPassword"));
				} else if ((dataTable.getData("General_Data", "TC_ID").contains("OBEMEA"))&& (dataTable.getData("General_Data", "TC_ID").contains("CSS"))) {
					Utility_Functions.xSendKeys(driver, txt_password, properties.getProperty("FTE2OBEMEACSSPassword"));
					
				} else if ((dataTable.getData("General_Data", "TC_ID").contains("ABEMEA"))&& (dataTable.getData("General_Data", "TC_ID").contains("Broker"))) {
					Utility_Functions.xSendKeys(driver, txt_password, properties.getProperty("FTE2ABEMEABrokerPassword"));
				} else if ((dataTable.getData("General_Data", "TC_ID").contains("ABEMEA"))&& (dataTable.getData("General_Data", "TC_ID").contains("Manager"))) {
					Utility_Functions.xSendKeys(driver, txt_password, properties.getProperty("FTE2ABEMEAManagerPassword"));
				} else if ((dataTable.getData("General_Data", "TC_ID").contains("ABEMEA"))&& (dataTable.getData("General_Data", "TC_ID").contains("CSS"))) {
					Utility_Functions.xSendKeys(driver, txt_password, properties.getProperty("FTE2ABEMEACSSPassword"));
				
				} else if ((dataTable.getData("General_Data", "TC_ID").contains("CMEMEA"))&& (dataTable.getData("General_Data", "TC_ID").contains("Broker"))) {
					Utility_Functions.xSendKeys(driver, txt_password, properties.getProperty("FTE2CMEMEABrokerPassword"));
				} else if ((dataTable.getData("General_Data", "TC_ID").contains("CMEMEA"))&& (dataTable.getData("General_Data", "TC_ID").contains("Manager"))) {
					Utility_Functions.xSendKeys(driver, txt_password, properties.getProperty("FTE2CMEMEAManagerPassword"));
				} else if ((dataTable.getData("General_Data", "TC_ID").contains("CMEMEA"))&& (dataTable.getData("General_Data", "TC_ID").contains("CSS"))) {
					Utility_Functions.xSendKeys(driver, txt_password, properties.getProperty("FTE2CMEMEACSSPassword"));
					
				} else {
					Utility_Functions.xSendKeys(driver, txt_password, properties.getProperty("FTE2Password"));
				}
			} else if (environment.equals("UAT2")) {
				if (dataTable.getData("General_Data", "TC_ID").contains("Admin")) { 
					Utility_Functions.xSendKeys(driver, txt_password, properties.getProperty("UAT2AdminPassword"));
					
				} else if ((dataTable.getData("General_Data", "TC_ID").contains("OBAMER")) && (dataTable.getData("General_Data", "TC_ID").contains("Broker"))) {
					Utility_Functions.xSendKeys(driver, txt_password, properties.getProperty("UAT2OBAMERBrokerPassword"));
				} else if ((dataTable.getData("General_Data", "TC_ID").contains("OBAMER")) && (dataTable.getData("General_Data", "TC_ID").contains("Manager"))) {
					Utility_Functions.xSendKeys(driver, txt_password, properties.getProperty("UAT2OBAMERManagerPassword"));
				} else if ((dataTable.getData("General_Data", "TC_ID").contains("OBAMER")) && (dataTable.getData("General_Data", "TC_ID").contains("CSS"))) {
					Utility_Functions.xSendKeys(driver, txt_password, properties.getProperty("UAT2OBAMERCSSPassword"));

				} else if ((dataTable.getData("General_Data", "TC_ID").contains("ABAMER")) && (dataTable.getData("General_Data", "TC_ID").contains("Broker"))) {
					Utility_Functions.xSendKeys(driver, txt_password, properties.getProperty("UAT2ABAMERBrokerPassword"));
				} else if ((dataTable.getData("General_Data", "TC_ID").contains("ABAMER")) && (dataTable.getData("General_Data", "TC_ID").contains("Manger"))) {
					Utility_Functions.xSendKeys(driver, txt_password, properties.getProperty("UAT2ABAMERManagerPassword"));
				} else if ((dataTable.getData("General_Data", "TC_ID").contains("ABAMER")) && (dataTable.getData("General_Data", "TC_ID").contains("CSS"))) {
					Utility_Functions.xSendKeys(driver, txt_password, properties.getProperty("UAT2ABAMERCSSPassword"));

				} else if ((dataTable.getData("General_Data", "TC_ID").contains("ABAPAC")) && (dataTable.getData("General_Data", "TC_ID").contains("Manager"))) {
					Utility_Functions.xSendKeys(driver, txt_password, properties.getProperty("UAT2ABAPACManagerPassword"));
					
				} else if ((dataTable.getData("General_Data", "TC_ID").contains("CMAMER")) && (dataTable.getData("General_Data", "TC_ID").contains("Broker"))) {
					Utility_Functions.xSendKeys(driver, txt_password, properties.getProperty("UAT2CMAMERBrokerPassword"));
				} else if ((dataTable.getData("General_Data", "TC_ID").contains("CMAMER")) && (dataTable.getData("General_Data", "TC_ID").contains("Manger"))) {
					Utility_Functions.xSendKeys(driver, txt_password, properties.getProperty("UAT2CMAMERManagerPassword"));
				} else if ((dataTable.getData("General_Data", "TC_ID").contains("CMAMER")) && (dataTable.getData("General_Data", "TC_ID").contains("CSS"))) {
					Utility_Functions.xSendKeys(driver, txt_password, properties.getProperty("UAT2CMAMERCSSPassword"));
					
				} else {
					Utility_Functions.xSendKeys(driver, txt_password, properties.getProperty("UAT2Password"));
				}
			}
			// Utility_Functions.timeWait(1);
			report.updateTestLog("Login", "Click the sign-in button", Status.PASS);
			Utility_Functions.xClick(driver, btn_LogIn, true);
			// Utility_Functions.timeWait(1);
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
		Utility_Functions.xWaitForElementPresent(driver, menu_Home, 5);
		try {
			if (menu_Home.isDisplayed()) {
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
			Utility_Functions.xClick(driver, logOutButton, true);
			Utility_Functions.xClick(driver, logOut, true);
			report.updateTestLog("Verify Logout", "User has been logged out successfully:::", Status.PASS);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
