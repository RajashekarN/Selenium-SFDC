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
	public static String environment = System.getProperty("RunEnvironment");

	public void invokeApplication() {
		report.updateTestLog("Invoke Application",
				"Invoke the application under test @ " + properties.getProperty("ApplicationUrl"), Status.PASS);
		if(environment.equals("UAT")) {
			driver.get(properties.getProperty("ApplicationUATUrl"));
		} else if(environment.equals("FTE")) {
			driver.get(properties.getProperty("ApplicationFTEUrl"));
		} else if(environment.equals("FTE2")) {
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
			if (environment.equals("UAT")) {
				if (dataTable.getData("General_Data", "TC_ID").contains("Admin")) {
					Utility_Functions.xSendKeys(driver, txt_userName, properties.getProperty("UATSystemAdminUsername"));
				} else if ((dataTable.getData("General_Data", "TC_ID").contains("OBAMER"))
						&& (dataTable.getData("General_Data", "TC_ID").contains("CSS"))) {
					Utility_Functions.xSendKeys(driver, txt_userName, properties.getProperty("UATOBAMERCSS"));
				} else if ((dataTable.getData("General_Data", "TC_ID").contains("OBAMER"))
						&& (dataTable.getData("General_Data", "TC_ID").contains("Manager"))) {
					Utility_Functions.xSendKeys(driver, txt_userName, properties.getProperty("UATOBAMERManager"));
				} else if ((dataTable.getData("General_Data", "TC_ID").contains("OBAMER"))
						&& (dataTable.getData("General_Data", "TC_ID").contains("Broker"))) {
					Utility_Functions.xSendKeys(driver, txt_userName, properties.getProperty("UATOBAMERBroker"));
				} else if ((dataTable.getData("General_Data", "TC_ID").contains("OBEMEA"))
						&& (dataTable.getData("General_Data", "TC_ID").contains("CSS"))) {
					Utility_Functions.xSendKeys(driver, txt_userName, properties.getProperty("UATOBEMEACSS"));
				} else if ((dataTable.getData("General_Data", "TC_ID").contains("OBEMEA"))
						&& (dataTable.getData("General_Data", "TC_ID").contains("Manager"))) {
					Utility_Functions.xSendKeys(driver, txt_userName, properties.getProperty("UATOBEMEAManager"));
				} else if ((dataTable.getData("General_Data", "TC_ID").contains("OBEMEA"))
						&& (dataTable.getData("General_Data", "TC_ID").contains("Broker"))) {
					Utility_Functions.xSendKeys(driver, txt_userName, properties.getProperty("UATOBEMEABroker"));
				} else if ((dataTable.getData("General_Data", "TC_ID").contains("OBAPAC"))
						&& (dataTable.getData("General_Data", "TC_ID").contains("CSS"))) {
					Utility_Functions.xSendKeys(driver, txt_userName, properties.getProperty("UATOBAPACCSS"));
				} else if ((dataTable.getData("General_Data", "TC_ID").contains("OBAPAC"))
						&& (dataTable.getData("General_Data", "TC_ID").contains("Manager"))) {
					Utility_Functions.xSendKeys(driver, txt_userName, properties.getProperty("UATOBAPACManager"));
				} else if ((dataTable.getData("General_Data", "TC_ID").contains("OBAPAC"))
						&& (dataTable.getData("General_Data", "TC_ID").contains("Broker"))) {
					Utility_Functions.xSendKeys(driver, txt_userName, properties.getProperty("UATOBAPACBroker"));

				} else if ((dataTable.getData("General_Data", "TC_ID").contains("ABAMER"))
						&& (dataTable.getData("General_Data", "TC_ID").contains("CSS"))) {
					Utility_Functions.xSendKeys(driver, txt_userName, properties.getProperty("UATABAMERCSS"));
				} else if ((dataTable.getData("General_Data", "TC_ID").contains("ABAMER"))
						&& (dataTable.getData("General_Data", "TC_ID").contains("Manager"))) {
					Utility_Functions.xSendKeys(driver, txt_userName, properties.getProperty("UATABAMERManager"));
				} else if ((dataTable.getData("General_Data", "TC_ID").contains("ABAMER"))
						&& (dataTable.getData("General_Data", "TC_ID").contains("Broker"))) {
					Utility_Functions.xSendKeys(driver, txt_userName, properties.getProperty("UATABAMERBroker"));
				} else if ((dataTable.getData("General_Data", "TC_ID").contains("ABEMEA"))
						&& (dataTable.getData("General_Data", "TC_ID").contains("CSS"))) {
					Utility_Functions.xSendKeys(driver, txt_userName, properties.getProperty("UATABEMEACSS"));
				} else if ((dataTable.getData("General_Data", "TC_ID").contains("ABEMEA"))
						&& (dataTable.getData("General_Data", "TC_ID").contains("Manager"))) {
					Utility_Functions.xSendKeys(driver, txt_userName, properties.getProperty("UATABEMEAManager"));
				} else if ((dataTable.getData("General_Data", "TC_ID").contains("ABEMEA"))
						&& (dataTable.getData("General_Data", "TC_ID").contains("Broker"))) {
					Utility_Functions.xSendKeys(driver, txt_userName, properties.getProperty("UATABEMEBroker"));
				} else if ((dataTable.getData("General_Data", "TC_ID").contains("ABAPAC"))
						&& (dataTable.getData("General_Data", "TC_ID").contains("CSS"))) {
					Utility_Functions.xSendKeys(driver, txt_userName, properties.getProperty("UATABAPACCSS"));
				} else if ((dataTable.getData("General_Data", "TC_ID").contains("ABAPAC"))
						&& (dataTable.getData("General_Data", "TC_ID").contains("Manager"))) {
					Utility_Functions.xSendKeys(driver, txt_userName, properties.getProperty("UATABAPACManager"));
				} else if ((dataTable.getData("General_Data", "TC_ID").contains("ABAPAC"))
						&& (dataTable.getData("General_Data", "TC_ID").contains("Broker"))) {
					Utility_Functions.xSendKeys(driver, txt_userName, properties.getProperty("UATABAPACBroker"));

				} else if ((dataTable.getData("General_Data", "TC_ID").contains("CMAMER"))
						&& (dataTable.getData("General_Data", "TC_ID").contains("CSS"))) {
					Utility_Functions.xSendKeys(driver, txt_userName, properties.getProperty("UATCMAMERCSS"));
				} else if ((dataTable.getData("General_Data", "TC_ID").contains("CMAMER"))
						&& (dataTable.getData("General_Data", "TC_ID").contains("Manager"))) {
					Utility_Functions.xSendKeys(driver, txt_userName, properties.getProperty("UATCMAMERManager"));
				} else if ((dataTable.getData("General_Data", "TC_ID").contains("CMAMER"))
						&& (dataTable.getData("General_Data", "TC_ID").contains("Broker"))) {
					Utility_Functions.xSendKeys(driver, txt_userName, properties.getProperty("UATCMAMERBroker"));
				} else if ((dataTable.getData("General_Data", "TC_ID").contains("CMEMEA"))
						&& (dataTable.getData("General_Data", "TC_ID").contains("CSS"))) {
					Utility_Functions.xSendKeys(driver, txt_userName, properties.getProperty("UATCMEMEACSS"));
				} else if ((dataTable.getData("General_Data", "TC_ID").contains("CMEMEA"))
						&& (dataTable.getData("General_Data", "TC_ID").contains("Manager"))) {
					Utility_Functions.xSendKeys(driver, txt_userName, properties.getProperty("UATCMEMEAManager"));
				} else if ((dataTable.getData("General_Data", "TC_ID").contains("CMEMEA"))
						&& (dataTable.getData("General_Data", "TC_ID").contains("Broker"))) {
					Utility_Functions.xSendKeys(driver, txt_userName, properties.getProperty("UATCMEMEABroker"));
				} else if ((dataTable.getData("General_Data", "TC_ID").contains("CMAPAC"))
						&& (dataTable.getData("General_Data", "TC_ID").contains("CSS"))) {
					Utility_Functions.xSendKeys(driver, txt_userName, properties.getProperty("UATCMAPACCS"));
				} else if ((dataTable.getData("General_Data", "TC_ID").contains("CMAPAC"))
						&& (dataTable.getData("General_Data", "TC_ID").contains("Manager"))) {
					Utility_Functions.xSendKeys(driver, txt_userName, properties.getProperty("UATCMAPACManager"));
				} else if ((dataTable.getData("General_Data", "TC_ID").contains("CMAPAC"))
						&& (dataTable.getData("General_Data", "TC_ID").contains("Broker"))) {
					Utility_Functions.xSendKeys(driver, txt_userName, properties.getProperty("UATCMAPACBroker"));

				} else if ((dataTable.getData("General_Data", "TC_ID").contains("VASAMER"))
						&& (dataTable.getData("General_Data", "TC_ID").contains("Manager"))) {
					Utility_Functions.xSendKeys(driver, txt_userName, properties.getProperty("UATVASAMERManager"));
				} else if ((dataTable.getData("General_Data", "TC_ID").contains("VASAMER"))
						&& (dataTable.getData("General_Data", "TC_ID").contains("Broker"))) {
					Utility_Functions.xSendKeys(driver, txt_userName, properties.getProperty("UATVASAMERBroker"));
				} else if ((dataTable.getData("General_Data", "TC_ID").contains("VASAMER"))
						&& (dataTable.getData("General_Data", "TC_ID").contains("CSS"))) {
					Utility_Functions.xSendKeys(driver, txt_userName, properties.getProperty("UATVASAMERCSS"));
				} else if ((dataTable.getData("General_Data", "TC_ID").contains("VASEMEA"))
						&& (dataTable.getData("General_Data", "TC_ID").contains("Manager"))) {
					Utility_Functions.xSendKeys(driver, txt_userName, properties.getProperty("UATVASEMEAManager"));
				} else if ((dataTable.getData("General_Data", "TC_ID").contains("VASEMEA"))
						&& (dataTable.getData("General_Data", "TC_ID").contains("Broker"))) {
					Utility_Functions.xSendKeys(driver, txt_userName, properties.getProperty("UATVASEMEABroker"));
				} else if ((dataTable.getData("General_Data", "TC_ID").contains("VASEMEA"))
						&& (dataTable.getData("General_Data", "TC_ID").contains("CSS"))) {
					Utility_Functions.xSendKeys(driver, txt_userName, properties.getProperty("VASEMEACSS"));
				} else if ((dataTable.getData("General_Data", "TC_ID").contains("VASAPAC"))
						&& (dataTable.getData("General_Data", "TC_ID").contains("Manager"))) {
					Utility_Functions.xSendKeys(driver, txt_userName, properties.getProperty("UATVASAPACManager"));
				} else if ((dataTable.getData("General_Data", "TC_ID").contains("VASAPAC"))
						&& (dataTable.getData("General_Data", "TC_ID").contains("Broker"))) {
					Utility_Functions.xSendKeys(driver, txt_userName, properties.getProperty("UATVASAPACBroker"));
				} else if ((dataTable.getData("General_Data", "TC_ID").contains("VASAPAC"))
						&& (dataTable.getData("General_Data", "TC_ID").contains("CSS"))) {
					Utility_Functions.xSendKeys(driver, txt_userName, properties.getProperty("UATVASAPACCSS"));

				} else if ((dataTable.getData("General_Data", "TC_ID").contains("ASAMER"))
						&& (dataTable.getData("General_Data", "TC_ID").contains("Manager"))) {
					Utility_Functions.xSendKeys(driver, txt_userName, properties.getProperty("UATASAMERManager"));
				} else if ((dataTable.getData("General_Data", "TC_ID").contains("ASAMER"))
						&& (dataTable.getData("General_Data", "TC_ID").contains("Broker"))) {
					Utility_Functions.xSendKeys(driver, txt_userName, properties.getProperty("UATASAMERBroker"));
				} else if ((dataTable.getData("General_Data", "TC_ID").contains("ASAMER"))
						&& (dataTable.getData("General_Data", "TC_ID").contains("CSS"))) {
					Utility_Functions.xSendKeys(driver, txt_userName, properties.getProperty("UATASAMERCSS"));
				} else if ((dataTable.getData("General_Data", "TC_ID").contains("ASEMEA"))
						&& (dataTable.getData("General_Data", "TC_ID").contains("Manager"))) {
					Utility_Functions.xSendKeys(driver, txt_userName, properties.getProperty("UATASEMEAManager"));
				} else if ((dataTable.getData("General_Data", "TC_ID").contains("ASEMEA"))
						&& (dataTable.getData("General_Data", "TC_ID").contains("Broker"))) {
					Utility_Functions.xSendKeys(driver, txt_userName, properties.getProperty("UATASEMEABroker"));
				} else if ((dataTable.getData("General_Data", "TC_ID").contains("ASEMEA"))
						&& (dataTable.getData("General_Data", "TC_ID").contains("CSS"))) {
					Utility_Functions.xSendKeys(driver, txt_userName, properties.getProperty("UATASEMEACSS"));
				} else if ((dataTable.getData("General_Data", "TC_ID").contains("ASAPAC"))
						&& (dataTable.getData("General_Data", "TC_ID").contains("Manager"))) {
					Utility_Functions.xSendKeys(driver, txt_userName, properties.getProperty("UATASAPACManager"));
				} else if ((dataTable.getData("General_Data", "TC_ID").contains("ASAPAC"))
						&& (dataTable.getData("General_Data", "TC_ID").contains("Broker"))) {
					Utility_Functions.xSendKeys(driver, txt_userName, properties.getProperty("UATASAPACBroker"));
				} else if ((dataTable.getData("General_Data", "TC_ID").contains("ASAPAC"))
						&& (dataTable.getData("General_Data", "TC_ID").contains("CSS"))) {
					Utility_Functions.xSendKeys(driver, txt_userName, properties.getProperty("UATASAPACCSS"));

				} else if ((dataTable.getData("General_Data", "TC_ID").contains("GWSAMER"))
						&& (dataTable.getData("General_Data", "TC_ID").contains("Manager"))) {
					Utility_Functions.xSendKeys(driver, txt_userName, properties.getProperty("UATGWSAMERManager"));
				} else if ((dataTable.getData("General_Data", "TC_ID").contains("GWSAMER"))
						&& (dataTable.getData("General_Data", "TC_ID").contains("Broker"))) {
					Utility_Functions.xSendKeys(driver, txt_userName, properties.getProperty("UATGWSAMERBroker"));
				} else if ((dataTable.getData("General_Data", "TC_ID").contains("GWSAMER"))
						&& (dataTable.getData("General_Data", "TC_ID").contains("CSS"))) {
					Utility_Functions.xSendKeys(driver, txt_userName, properties.getProperty("UATGWSAMERCSS"));
				} else if ((dataTable.getData("General_Data", "TC_ID").contains("GWSEMEA"))
						&& (dataTable.getData("General_Data", "TC_ID").contains("Manager"))) {
					Utility_Functions.xSendKeys(driver, txt_userName, properties.getProperty("UATGWSEMEAManager"));
				} else if ((dataTable.getData("General_Data", "TC_ID").contains("GWSEMEA"))
						&& (dataTable.getData("General_Data", "TC_ID").contains("Broker"))) {
					Utility_Functions.xSendKeys(driver, txt_userName, properties.getProperty("UATGWSEMEABroker"));
				} else if ((dataTable.getData("General_Data", "TC_ID").contains("GWSEMEA"))
						&& (dataTable.getData("General_Data", "TC_ID").contains("CSS"))) {
					Utility_Functions.xSendKeys(driver, txt_userName, properties.getProperty("UATGWSEMEACSS"));
				} else if ((dataTable.getData("General_Data", "TC_ID").contains("GWSAPAC"))
						&& (dataTable.getData("General_Data", "TC_ID").contains("Manager"))) {
					Utility_Functions.xSendKeys(driver, txt_userName, properties.getProperty("UATGWSAPACManager"));
				} else if ((dataTable.getData("General_Data", "TC_ID").contains("GWSAPAC"))
						&& (dataTable.getData("General_Data", "TC_ID").contains("Broker"))) {
					Utility_Functions.xSendKeys(driver, txt_userName, properties.getProperty("UATGWSAPACBroker"));
				} else if ((dataTable.getData("General_Data", "TC_ID").contains("GWSAPAC"))
						&& (dataTable.getData("General_Data", "TC_ID").contains("CSS"))) {
					Utility_Functions.xSendKeys(driver, txt_userName, properties.getProperty("UATGWSAPACCSS"));

				} else if ((dataTable.getData("General_Data", "TC_ID").contains("DAAMER"))
						&& (dataTable.getData("General_Data", "TC_ID").contains("Manager"))) {
					Utility_Functions.xSendKeys(driver, txt_userName, properties.getProperty("UATDAAMERManager"));
				} else if ((dataTable.getData("General_Data", "TC_ID").contains("DAAMER"))
						&& (dataTable.getData("General_Data", "TC_ID").contains("Broker"))) {
					Utility_Functions.xSendKeys(driver, txt_userName, properties.getProperty("UATDAAMERBroker"));
				} else if ((dataTable.getData("General_Data", "TC_ID").contains("DAAMER"))
						&& (dataTable.getData("General_Data", "TC_ID").contains("CSS"))) {
					Utility_Functions.xSendKeys(driver, txt_userName, properties.getProperty("UATDAAMERCSS"));
				} else if ((dataTable.getData("General_Data", "TC_ID").contains("DAEMEA"))
						&& (dataTable.getData("General_Data", "TC_ID").contains("Manager"))) {
					Utility_Functions.xSendKeys(driver, txt_userName, properties.getProperty("UATDAEMEAManager"));
				} else if ((dataTable.getData("General_Data", "TC_ID").contains("DAEMEA"))
						&& (dataTable.getData("General_Data", "TC_ID").contains("Broker"))) {
					Utility_Functions.xSendKeys(driver, txt_userName, properties.getProperty("UATDAEMEABroker"));
				} else if ((dataTable.getData("General_Data", "TC_ID").contains("DAEMEA"))
						&& (dataTable.getData("General_Data", "TC_ID").contains("CSS"))) {
					Utility_Functions.xSendKeys(driver, txt_userName, properties.getProperty("UATDAEMEACSS"));
				} else if ((dataTable.getData("General_Data", "TC_ID").contains("DAAPAC"))
						&& (dataTable.getData("General_Data", "TC_ID").contains("Manager"))) {
					Utility_Functions.xSendKeys(driver, txt_userName, properties.getProperty("UATDAAPACManager"));
				} else if ((dataTable.getData("General_Data", "TC_ID").contains("DAAPAC"))
						&& (dataTable.getData("General_Data", "TC_ID").contains("Broker"))) {
					Utility_Functions.xSendKeys(driver, txt_userName, properties.getProperty("UATDAAPACBroker"));
				} else if ((dataTable.getData("General_Data", "TC_ID").contains("DAAPAC"))
						&& (dataTable.getData("General_Data", "TC_ID").contains("CSS"))) {
					Utility_Functions.xSendKeys(driver, txt_userName, properties.getProperty("UATDAAPACCSS"));
				}
			} else if (environment.equals("FTE")) {
				if (dataTable.getData("General_Data", "TC_ID").contains("Admin")) {
					Utility_Functions.xSendKeys(driver, txt_userName, properties.getProperty("FTESystemAdminUsername"));
				} else if ((dataTable.getData("General_Data", "TC_ID").contains("OBAMER"))
						&& (dataTable.getData("General_Data", "TC_ID").contains("CSS"))) {
					Utility_Functions.xSendKeys(driver, txt_userName, properties.getProperty("FTEOBAMERCSS"));
				} else if ((dataTable.getData("General_Data", "TC_ID").contains("OBAMER"))
						&& (dataTable.getData("General_Data", "TC_ID").contains("Manager"))) {
					Utility_Functions.xSendKeys(driver, txt_userName, properties.getProperty("FTEOBAMERManager"));
				} else if ((dataTable.getData("General_Data", "TC_ID").contains("OBAMER"))
						&& (dataTable.getData("General_Data", "TC_ID").contains("Broker"))) {
					Utility_Functions.xSendKeys(driver, txt_userName, properties.getProperty("FTEOBAMERBroker"));
				} else if ((dataTable.getData("General_Data", "TC_ID").contains("OBEMEA"))
						&& (dataTable.getData("General_Data", "TC_ID").contains("CSS"))) {
					Utility_Functions.xSendKeys(driver, txt_userName, properties.getProperty("FTEOBEMEACSS"));
				} else if ((dataTable.getData("General_Data", "TC_ID").contains("OBEMEA"))
						&& (dataTable.getData("General_Data", "TC_ID").contains("Manager"))) {
					Utility_Functions.xSendKeys(driver, txt_userName, properties.getProperty("FTEOBEMEAManager"));
				} else if ((dataTable.getData("General_Data", "TC_ID").contains("OBEMEA"))
						&& (dataTable.getData("General_Data", "TC_ID").contains("Broker"))) {
					Utility_Functions.xSendKeys(driver, txt_userName, properties.getProperty("FTEOBEMEABroker"));
				} else if ((dataTable.getData("General_Data", "TC_ID").contains("OBAPAC"))
						&& (dataTable.getData("General_Data", "TC_ID").contains("CSS"))) {
					Utility_Functions.xSendKeys(driver, txt_userName, properties.getProperty("FTEOBAPACCSS"));
				} else if ((dataTable.getData("General_Data", "TC_ID").contains("OBAPAC"))
						&& (dataTable.getData("General_Data", "TC_ID").contains("Manager"))) {
					Utility_Functions.xSendKeys(driver, txt_userName, properties.getProperty("FTEOBAPACManager"));
				} else if ((dataTable.getData("General_Data", "TC_ID").contains("OBAPAC"))
						&& (dataTable.getData("General_Data", "TC_ID").contains("Broker"))) {
					Utility_Functions.xSendKeys(driver, txt_userName, properties.getProperty("FTEOBAPACBroker"));

				} else if ((dataTable.getData("General_Data", "TC_ID").contains("ABAMER"))
						&& (dataTable.getData("General_Data", "TC_ID").contains("CSS"))) {
					Utility_Functions.xSendKeys(driver, txt_userName, properties.getProperty("FTEABAMERCSS"));
				} else if ((dataTable.getData("General_Data", "TC_ID").contains("ABAMER"))
						&& (dataTable.getData("General_Data", "TC_ID").contains("Manager"))) {
					Utility_Functions.xSendKeys(driver, txt_userName, properties.getProperty("FTEABAMERManager"));
				} else if ((dataTable.getData("General_Data", "TC_ID").contains("ABAMER"))
						&& (dataTable.getData("General_Data", "TC_ID").contains("Broker"))) {
					Utility_Functions.xSendKeys(driver, txt_userName, properties.getProperty("FTEABAMERBroker"));
				} else if ((dataTable.getData("General_Data", "TC_ID").contains("ABEMEA"))
						&& (dataTable.getData("General_Data", "TC_ID").contains("CSS"))) {
					Utility_Functions.xSendKeys(driver, txt_userName, properties.getProperty("FTEABEMEACSS"));
				} else if ((dataTable.getData("General_Data", "TC_ID").contains("ABEMEA"))
						&& (dataTable.getData("General_Data", "TC_ID").contains("Manager"))) {
					Utility_Functions.xSendKeys(driver, txt_userName, properties.getProperty("FTEABEMEAManager"));
				} else if ((dataTable.getData("General_Data", "TC_ID").contains("ABEMEA"))
						&& (dataTable.getData("General_Data", "TC_ID").contains("Broker"))) {
					Utility_Functions.xSendKeys(driver, txt_userName, properties.getProperty("FTEABEMEBroker"));
				} else if ((dataTable.getData("General_Data", "TC_ID").contains("ABAPAC"))
						&& (dataTable.getData("General_Data", "TC_ID").contains("CSS"))) {
					Utility_Functions.xSendKeys(driver, txt_userName, properties.getProperty("FTEABAPACCSS"));
				} else if ((dataTable.getData("General_Data", "TC_ID").contains("ABAPAC"))
						&& (dataTable.getData("General_Data", "TC_ID").contains("Manager"))) {
					Utility_Functions.xSendKeys(driver, txt_userName, properties.getProperty("FTEABAPACManager"));
				} else if ((dataTable.getData("General_Data", "TC_ID").contains("ABAPAC"))
						&& (dataTable.getData("General_Data", "TC_ID").contains("Broker"))) {
					Utility_Functions.xSendKeys(driver, txt_userName, properties.getProperty("FTEABAPACBroker"));

				} else if ((dataTable.getData("General_Data", "TC_ID").contains("CMAMER"))
						&& (dataTable.getData("General_Data", "TC_ID").contains("CSS"))) {
					Utility_Functions.xSendKeys(driver, txt_userName, properties.getProperty("FTECMAMERCSS"));
				} else if ((dataTable.getData("General_Data", "TC_ID").contains("CMAMER"))
						&& (dataTable.getData("General_Data", "TC_ID").contains("Manager"))) {
					Utility_Functions.xSendKeys(driver, txt_userName, properties.getProperty("FTECMAMERManager"));
				} else if ((dataTable.getData("General_Data", "TC_ID").contains("CMAMER"))
						&& (dataTable.getData("General_Data", "TC_ID").contains("Broker"))) {
					Utility_Functions.xSendKeys(driver, txt_userName, properties.getProperty("FTECMAMERBroker"));
				} else if ((dataTable.getData("General_Data", "TC_ID").contains("CMEMEA"))
						&& (dataTable.getData("General_Data", "TC_ID").contains("CSS"))) {
					Utility_Functions.xSendKeys(driver, txt_userName, properties.getProperty("FTECMEMEACSS"));
				} else if ((dataTable.getData("General_Data", "TC_ID").contains("CMEMEA"))
						&& (dataTable.getData("General_Data", "TC_ID").contains("Manager"))) {
					Utility_Functions.xSendKeys(driver, txt_userName, properties.getProperty("FTECMEMEAManager"));
				} else if ((dataTable.getData("General_Data", "TC_ID").contains("CMEMEA"))
						&& (dataTable.getData("General_Data", "TC_ID").contains("Broker"))) {
					Utility_Functions.xSendKeys(driver, txt_userName, properties.getProperty("FTECMEMEABroker"));
				} else if ((dataTable.getData("General_Data", "TC_ID").contains("CMAPAC"))
						&& (dataTable.getData("General_Data", "TC_ID").contains("CSS"))) {
					Utility_Functions.xSendKeys(driver, txt_userName, properties.getProperty("FTECMAPACCS"));
				} else if ((dataTable.getData("General_Data", "TC_ID").contains("CMAPAC"))
						&& (dataTable.getData("General_Data", "TC_ID").contains("Manager"))) {
					Utility_Functions.xSendKeys(driver, txt_userName, properties.getProperty("FTECMAPACManager"));
				} else if ((dataTable.getData("General_Data", "TC_ID").contains("CMAPAC"))
						&& (dataTable.getData("General_Data", "TC_ID").contains("Broker"))) {
					Utility_Functions.xSendKeys(driver, txt_userName, properties.getProperty("FTECMAPACBroker"));

				} else if ((dataTable.getData("General_Data", "TC_ID").contains("VASAMER"))
						&& (dataTable.getData("General_Data", "TC_ID").contains("Manager"))) {
					Utility_Functions.xSendKeys(driver, txt_userName, properties.getProperty("FTEVASAMERManager"));
				} else if ((dataTable.getData("General_Data", "TC_ID").contains("VASAMER"))
						&& (dataTable.getData("General_Data", "TC_ID").contains("Broker"))) {
					Utility_Functions.xSendKeys(driver, txt_userName, properties.getProperty("FTEVASAMERBroker"));
				} else if ((dataTable.getData("General_Data", "TC_ID").contains("VASAMER"))
						&& (dataTable.getData("General_Data", "TC_ID").contains("CSS"))) {
					Utility_Functions.xSendKeys(driver, txt_userName, properties.getProperty("FTEVASAMERCSS"));
				} else if ((dataTable.getData("General_Data", "TC_ID").contains("VASEMEA"))
						&& (dataTable.getData("General_Data", "TC_ID").contains("Manager"))) {
					Utility_Functions.xSendKeys(driver, txt_userName, properties.getProperty("FTEVASEMEAManager"));
				} else if ((dataTable.getData("General_Data", "TC_ID").contains("VASEMEA"))
						&& (dataTable.getData("General_Data", "TC_ID").contains("Broker"))) {
					Utility_Functions.xSendKeys(driver, txt_userName, properties.getProperty("FTEVASEMEABroker"));
				} else if ((dataTable.getData("General_Data", "TC_ID").contains("VASEMEA"))
						&& (dataTable.getData("General_Data", "TC_ID").contains("CSS"))) {
					Utility_Functions.xSendKeys(driver, txt_userName, properties.getProperty("VASEMEACSS"));
				} else if ((dataTable.getData("General_Data", "TC_ID").contains("VASAPAC"))
						&& (dataTable.getData("General_Data", "TC_ID").contains("Manager"))) {
					Utility_Functions.xSendKeys(driver, txt_userName, properties.getProperty("FTEVASAPACManager"));
				} else if ((dataTable.getData("General_Data", "TC_ID").contains("VASAPAC"))
						&& (dataTable.getData("General_Data", "TC_ID").contains("Broker"))) {
					Utility_Functions.xSendKeys(driver, txt_userName, properties.getProperty("FTEVASAPACBroker"));
				} else if ((dataTable.getData("General_Data", "TC_ID").contains("VASAPAC"))
						&& (dataTable.getData("General_Data", "TC_ID").contains("CSS"))) {
					Utility_Functions.xSendKeys(driver, txt_userName, properties.getProperty("FTEVASAPACCSS"));

				} else if ((dataTable.getData("General_Data", "TC_ID").contains("ASAMER"))
						&& (dataTable.getData("General_Data", "TC_ID").contains("Manager"))) {
					Utility_Functions.xSendKeys(driver, txt_userName, properties.getProperty("FTEASAMERManager"));
				} else if ((dataTable.getData("General_Data", "TC_ID").contains("ASAMER"))
						&& (dataTable.getData("General_Data", "TC_ID").contains("Broker"))) {
					Utility_Functions.xSendKeys(driver, txt_userName, properties.getProperty("FTEASAMERBroker"));
				} else if ((dataTable.getData("General_Data", "TC_ID").contains("ASAMER"))
						&& (dataTable.getData("General_Data", "TC_ID").contains("CSS"))) {
					Utility_Functions.xSendKeys(driver, txt_userName, properties.getProperty("FTEASAMERCSS"));
				} else if ((dataTable.getData("General_Data", "TC_ID").contains("ASEMEA"))
						&& (dataTable.getData("General_Data", "TC_ID").contains("Manager"))) {
					Utility_Functions.xSendKeys(driver, txt_userName, properties.getProperty("FTEASEMEAManager"));
				} else if ((dataTable.getData("General_Data", "TC_ID").contains("ASEMEA"))
						&& (dataTable.getData("General_Data", "TC_ID").contains("Broker"))) {
					Utility_Functions.xSendKeys(driver, txt_userName, properties.getProperty("FTEASEMEABroker"));
				} else if ((dataTable.getData("General_Data", "TC_ID").contains("ASEMEA"))
						&& (dataTable.getData("General_Data", "TC_ID").contains("CSS"))) {
					Utility_Functions.xSendKeys(driver, txt_userName, properties.getProperty("FTEASEMEACSS"));
				} else if ((dataTable.getData("General_Data", "TC_ID").contains("ASAPAC"))
						&& (dataTable.getData("General_Data", "TC_ID").contains("Manager"))) {
					Utility_Functions.xSendKeys(driver, txt_userName, properties.getProperty("FTEASAPACManager"));
				} else if ((dataTable.getData("General_Data", "TC_ID").contains("ASAPAC"))
						&& (dataTable.getData("General_Data", "TC_ID").contains("Broker"))) {
					Utility_Functions.xSendKeys(driver, txt_userName, properties.getProperty("FTEASAPACBroker"));
				} else if ((dataTable.getData("General_Data", "TC_ID").contains("ASAPAC"))
						&& (dataTable.getData("General_Data", "TC_ID").contains("CSS"))) {
					Utility_Functions.xSendKeys(driver, txt_userName, properties.getProperty("FTEASAPACCSS"));

				} else if ((dataTable.getData("General_Data", "TC_ID").contains("GWSAMER"))
						&& (dataTable.getData("General_Data", "TC_ID").contains("Manager"))) {
					Utility_Functions.xSendKeys(driver, txt_userName, properties.getProperty("FTEGWSAMERManager"));
				} else if ((dataTable.getData("General_Data", "TC_ID").contains("GWSAMER"))
						&& (dataTable.getData("General_Data", "TC_ID").contains("Broker"))) {
					Utility_Functions.xSendKeys(driver, txt_userName, properties.getProperty("FTEGWSAMERBroker"));
				} else if ((dataTable.getData("General_Data", "TC_ID").contains("GWSAMER"))
						&& (dataTable.getData("General_Data", "TC_ID").contains("CSS"))) {
					Utility_Functions.xSendKeys(driver, txt_userName, properties.getProperty("FTEGWSAMERCSS"));
				} else if ((dataTable.getData("General_Data", "TC_ID").contains("GWSEMEA"))
						&& (dataTable.getData("General_Data", "TC_ID").contains("Manager"))) {
					Utility_Functions.xSendKeys(driver, txt_userName, properties.getProperty("FTEGWSEMEAManager"));
				} else if ((dataTable.getData("General_Data", "TC_ID").contains("GWSEMEA"))
						&& (dataTable.getData("General_Data", "TC_ID").contains("Broker"))) {
					Utility_Functions.xSendKeys(driver, txt_userName, properties.getProperty("FTEGWSEMEABroker"));
				} else if ((dataTable.getData("General_Data", "TC_ID").contains("GWSEMEA"))
						&& (dataTable.getData("General_Data", "TC_ID").contains("CSS"))) {
					Utility_Functions.xSendKeys(driver, txt_userName, properties.getProperty("FTEGWSEMEACSS"));
				} else if ((dataTable.getData("General_Data", "TC_ID").contains("GWSAPAC"))
						&& (dataTable.getData("General_Data", "TC_ID").contains("Manager"))) {
					Utility_Functions.xSendKeys(driver, txt_userName, properties.getProperty("FTEGWSAPACManager"));
				} else if ((dataTable.getData("General_Data", "TC_ID").contains("GWSAPAC"))
						&& (dataTable.getData("General_Data", "TC_ID").contains("Broker"))) {
					Utility_Functions.xSendKeys(driver, txt_userName, properties.getProperty("FTEGWSAPACBroker"));
				} else if ((dataTable.getData("General_Data", "TC_ID").contains("GWSAPAC"))
						&& (dataTable.getData("General_Data", "TC_ID").contains("CSS"))) {
					Utility_Functions.xSendKeys(driver, txt_userName, properties.getProperty("FTEGWSAPACCSS"));

				} else if ((dataTable.getData("General_Data", "TC_ID").contains("DAAMER"))
						&& (dataTable.getData("General_Data", "TC_ID").contains("Data"))) {
					Utility_Functions.xSendKeys(driver, txt_userName, properties.getProperty("FTEDAAMERData"));
				} else if ((dataTable.getData("General_Data", "TC_ID").contains("DAEMEA"))
						&& (dataTable.getData("General_Data", "TC_ID").contains("Data"))) {
					Utility_Functions.xSendKeys(driver, txt_userName, properties.getProperty("FTEDAEMEAData"));
				} else if ((dataTable.getData("General_Data", "TC_ID").contains("DAAPAC"))
						&& (dataTable.getData("General_Data", "TC_ID").contains("Data"))) {
					Utility_Functions.xSendKeys(driver, txt_userName, properties.getProperty("FTEDAAPACData"));
				}
			} else if (environment.equals("FTE2")) {
				if (dataTable.getData("General_Data", "TC_ID").contains("Admin")) {
					Utility_Functions.xSendKeys(driver, txt_userName,
							properties.getProperty("FTE2SystemAdminUsername"));
				} else if ((dataTable.getData("General_Data", "TC_ID").contains("OBAMER"))
						&& (dataTable.getData("General_Data", "TC_ID").contains("CSS"))) {
					Utility_Functions.xSendKeys(driver, txt_userName, properties.getProperty("FTE2OBAMERCSS"));
				} else if ((dataTable.getData("General_Data", "TC_ID").contains("OBAMER"))
						&& (dataTable.getData("General_Data", "TC_ID").contains("Manager"))) {
					Utility_Functions.xSendKeys(driver, txt_userName, properties.getProperty("FTE2OBAMERManager"));
				} else if ((dataTable.getData("General_Data", "TC_ID").contains("OBAMER"))
						&& (dataTable.getData("General_Data", "TC_ID").contains("Broker"))) {
					Utility_Functions.xSendKeys(driver, txt_userName, properties.getProperty("FTE2OBAMERBroker"));
				} else if ((dataTable.getData("General_Data", "TC_ID").contains("OBEMEA"))
						&& (dataTable.getData("General_Data", "TC_ID").contains("CSS"))) {
					Utility_Functions.xSendKeys(driver, txt_userName, properties.getProperty("FTE2OBEMEACSS"));
				} else if ((dataTable.getData("General_Data", "TC_ID").contains("OBEMEA"))
						&& (dataTable.getData("General_Data", "TC_ID").contains("Manager"))) {
					Utility_Functions.xSendKeys(driver, txt_userName, properties.getProperty("FTE2OBEMEAManager"));
				} else if ((dataTable.getData("General_Data", "TC_ID").contains("OBEMEA"))
						&& (dataTable.getData("General_Data", "TC_ID").contains("Broker"))) {
					Utility_Functions.xSendKeys(driver, txt_userName, properties.getProperty("FTE2OBEMEABroker"));
				} else if ((dataTable.getData("General_Data", "TC_ID").contains("OBAPAC"))
						&& (dataTable.getData("General_Data", "TC_ID").contains("CSS"))) {
					Utility_Functions.xSendKeys(driver, txt_userName, properties.getProperty("FTE2OBAPACCSS"));
				} else if ((dataTable.getData("General_Data", "TC_ID").contains("OBAPAC"))
						&& (dataTable.getData("General_Data", "TC_ID").contains("Manager"))) {
					Utility_Functions.xSendKeys(driver, txt_userName, properties.getProperty("FTE2OBAPACManager"));
				} else if ((dataTable.getData("General_Data", "TC_ID").contains("OBAPAC"))
						&& (dataTable.getData("General_Data", "TC_ID").contains("Broker"))) {
					Utility_Functions.xSendKeys(driver, txt_userName, properties.getProperty("FTE2OBAPACBroker"));

				} else if ((dataTable.getData("General_Data", "TC_ID").contains("ABAMER"))
						&& (dataTable.getData("General_Data", "TC_ID").contains("CSS"))) {
					Utility_Functions.xSendKeys(driver, txt_userName, properties.getProperty("FTE2ABAMERCSS"));
				} else if ((dataTable.getData("General_Data", "TC_ID").contains("ABAMER"))
						&& (dataTable.getData("General_Data", "TC_ID").contains("Manager"))) {
					Utility_Functions.xSendKeys(driver, txt_userName, properties.getProperty("FTE2ABAMERManager"));
				} else if ((dataTable.getData("General_Data", "TC_ID").contains("ABAMER"))
						&& (dataTable.getData("General_Data", "TC_ID").contains("Broker"))) {
					Utility_Functions.xSendKeys(driver, txt_userName, properties.getProperty("FTE2ABAMERBroker"));
				} else if ((dataTable.getData("General_Data", "TC_ID").contains("ABEMEA"))
						&& (dataTable.getData("General_Data", "TC_ID").contains("CSS"))) {
					Utility_Functions.xSendKeys(driver, txt_userName, properties.getProperty("FTE2ABEMEACSS"));
				} else if ((dataTable.getData("General_Data", "TC_ID").contains("ABEMEA"))
						&& (dataTable.getData("General_Data", "TC_ID").contains("Manager"))) {
					Utility_Functions.xSendKeys(driver, txt_userName, properties.getProperty("FTE2ABEMEAManager"));
				} else if ((dataTable.getData("General_Data", "TC_ID").contains("ABEMEA"))
						&& (dataTable.getData("General_Data", "TC_ID").contains("Broker"))) {
					Utility_Functions.xSendKeys(driver, txt_userName, properties.getProperty("FTE2ABEMEBroker"));
				} else if ((dataTable.getData("General_Data", "TC_ID").contains("ABAPAC"))
						&& (dataTable.getData("General_Data", "TC_ID").contains("CSS"))) {
					Utility_Functions.xSendKeys(driver, txt_userName, properties.getProperty("FTE2ABAPACCSS"));
				} else if ((dataTable.getData("General_Data", "TC_ID").contains("ABAPAC"))
						&& (dataTable.getData("General_Data", "TC_ID").contains("Manager"))) {
					Utility_Functions.xSendKeys(driver, txt_userName, properties.getProperty("FTE2ABAPACManager"));
				} else if ((dataTable.getData("General_Data", "TC_ID").contains("ABAPAC"))
						&& (dataTable.getData("General_Data", "TC_ID").contains("Broker"))) {
					Utility_Functions.xSendKeys(driver, txt_userName, properties.getProperty("FTE2ABAPACBroker"));

				} else if ((dataTable.getData("General_Data", "TC_ID").contains("CMAMER"))
						&& (dataTable.getData("General_Data", "TC_ID").contains("CSS"))) {
					Utility_Functions.xSendKeys(driver, txt_userName, properties.getProperty("FTE2CMAMERCSS"));
				} else if ((dataTable.getData("General_Data", "TC_ID").contains("CMAMER"))
						&& (dataTable.getData("General_Data", "TC_ID").contains("Manager"))) {
					Utility_Functions.xSendKeys(driver, txt_userName, properties.getProperty("FTE2CMAMERManager"));
				} else if ((dataTable.getData("General_Data", "TC_ID").contains("CMAMER"))
						&& (dataTable.getData("General_Data", "TC_ID").contains("Broker"))) {
					Utility_Functions.xSendKeys(driver, txt_userName, properties.getProperty("FTE2CMAMERBroker"));
				} else if ((dataTable.getData("General_Data", "TC_ID").contains("CMEMEA"))
						&& (dataTable.getData("General_Data", "TC_ID").contains("CSS"))) {
					Utility_Functions.xSendKeys(driver, txt_userName, properties.getProperty("FTE2CMEMEACSS"));
				} else if ((dataTable.getData("General_Data", "TC_ID").contains("CMEMEA"))
						&& (dataTable.getData("General_Data", "TC_ID").contains("Manager"))) {
					Utility_Functions.xSendKeys(driver, txt_userName, properties.getProperty("FTE2CMEMEAManager"));
				} else if ((dataTable.getData("General_Data", "TC_ID").contains("CMEMEA"))
						&& (dataTable.getData("General_Data", "TC_ID").contains("Broker"))) {
					Utility_Functions.xSendKeys(driver, txt_userName, properties.getProperty("FTE2CMEMEABroker"));
				} else if ((dataTable.getData("General_Data", "TC_ID").contains("CMAPAC"))
						&& (dataTable.getData("General_Data", "TC_ID").contains("CSS"))) {
					Utility_Functions.xSendKeys(driver, txt_userName, properties.getProperty("FTE2CMAPACCS"));
				} else if ((dataTable.getData("General_Data", "TC_ID").contains("CMAPAC"))
						&& (dataTable.getData("General_Data", "TC_ID").contains("Manager"))) {
					Utility_Functions.xSendKeys(driver, txt_userName, properties.getProperty("FTE2CMAPACManager"));
				} else if ((dataTable.getData("General_Data", "TC_ID").contains("CMAPAC"))
						&& (dataTable.getData("General_Data", "TC_ID").contains("Broker"))) {
					Utility_Functions.xSendKeys(driver, txt_userName, properties.getProperty("FTE2CMAPACBroker"));

				} else if ((dataTable.getData("General_Data", "TC_ID").contains("VASAMER"))
						&& (dataTable.getData("General_Data", "TC_ID").contains("Manager"))) {
					Utility_Functions.xSendKeys(driver, txt_userName, properties.getProperty("FTE2VASAMERManager"));
				} else if ((dataTable.getData("General_Data", "TC_ID").contains("VASAMER"))
						&& (dataTable.getData("General_Data", "TC_ID").contains("Broker"))) {
					Utility_Functions.xSendKeys(driver, txt_userName, properties.getProperty("FTE2VASAMERBroker"));
				} else if ((dataTable.getData("General_Data", "TC_ID").contains("VASAMER"))
						&& (dataTable.getData("General_Data", "TC_ID").contains("CSS"))) {
					Utility_Functions.xSendKeys(driver, txt_userName, properties.getProperty("FTE2VASAMERCSS"));
				} else if ((dataTable.getData("General_Data", "TC_ID").contains("VASEMEA"))
						&& (dataTable.getData("General_Data", "TC_ID").contains("Manager"))) {
					Utility_Functions.xSendKeys(driver, txt_userName, properties.getProperty("FTE2VASEMEAManager"));
				} else if ((dataTable.getData("General_Data", "TC_ID").contains("VASEMEA"))
						&& (dataTable.getData("General_Data", "TC_ID").contains("Broker"))) {
					Utility_Functions.xSendKeys(driver, txt_userName, properties.getProperty("FTE2VASEMEABroker"));
				} else if ((dataTable.getData("General_Data", "TC_ID").contains("VASEMEA"))
						&& (dataTable.getData("General_Data", "TC_ID").contains("CSS"))) {
					Utility_Functions.xSendKeys(driver, txt_userName, properties.getProperty("VASEMEACSS"));
				} else if ((dataTable.getData("General_Data", "TC_ID").contains("VASAPAC"))
						&& (dataTable.getData("General_Data", "TC_ID").contains("Manager"))) {
					Utility_Functions.xSendKeys(driver, txt_userName, properties.getProperty("FTE2VASAPACManager"));
				} else if ((dataTable.getData("General_Data", "TC_ID").contains("VASAPAC"))
						&& (dataTable.getData("General_Data", "TC_ID").contains("Broker"))) {
					Utility_Functions.xSendKeys(driver, txt_userName, properties.getProperty("FTE2VASAPACBroker"));
				} else if ((dataTable.getData("General_Data", "TC_ID").contains("VASAPAC"))
						&& (dataTable.getData("General_Data", "TC_ID").contains("CSS"))) {
					Utility_Functions.xSendKeys(driver, txt_userName, properties.getProperty("FTE2VASAPACCSS"));

				} else if ((dataTable.getData("General_Data", "TC_ID").contains("ASAMER"))
						&& (dataTable.getData("General_Data", "TC_ID").contains("Manager"))) {
					Utility_Functions.xSendKeys(driver, txt_userName, properties.getProperty("FTE2ASAMERManager"));
				} else if ((dataTable.getData("General_Data", "TC_ID").contains("ASAMER"))
						&& (dataTable.getData("General_Data", "TC_ID").contains("Broker"))) {
					Utility_Functions.xSendKeys(driver, txt_userName, properties.getProperty("FTE2ASAMERBroker"));
				} else if ((dataTable.getData("General_Data", "TC_ID").contains("ASAMER"))
						&& (dataTable.getData("General_Data", "TC_ID").contains("CSS"))) {
					Utility_Functions.xSendKeys(driver, txt_userName, properties.getProperty("FTE2ASAMERCSS"));
				} else if ((dataTable.getData("General_Data", "TC_ID").contains("ASEMEA"))
						&& (dataTable.getData("General_Data", "TC_ID").contains("Manager"))) {
					Utility_Functions.xSendKeys(driver, txt_userName, properties.getProperty("FTE2ASEMEAManager"));
				} else if ((dataTable.getData("General_Data", "TC_ID").contains("ASEMEA"))
						&& (dataTable.getData("General_Data", "TC_ID").contains("Broker"))) {
					Utility_Functions.xSendKeys(driver, txt_userName, properties.getProperty("FTE2ASEMEABroker"));
				} else if ((dataTable.getData("General_Data", "TC_ID").contains("ASEMEA"))
						&& (dataTable.getData("General_Data", "TC_ID").contains("CSS"))) {
					Utility_Functions.xSendKeys(driver, txt_userName, properties.getProperty("FTE2ASEMEACSS"));
				} else if ((dataTable.getData("General_Data", "TC_ID").contains("ASAPAC"))
						&& (dataTable.getData("General_Data", "TC_ID").contains("Manager"))) {
					Utility_Functions.xSendKeys(driver, txt_userName, properties.getProperty("FTE2ASAPACManager"));
				} else if ((dataTable.getData("General_Data", "TC_ID").contains("ASAPAC"))
						&& (dataTable.getData("General_Data", "TC_ID").contains("Broker"))) {
					Utility_Functions.xSendKeys(driver, txt_userName, properties.getProperty("FTE2ASAPACBroker"));
				} else if ((dataTable.getData("General_Data", "TC_ID").contains("ASAPAC"))
						&& (dataTable.getData("General_Data", "TC_ID").contains("CSS"))) {
					Utility_Functions.xSendKeys(driver, txt_userName, properties.getProperty("FTE2ASAPACCSS"));

				} else if ((dataTable.getData("General_Data", "TC_ID").contains("GWSAMER"))
						&& (dataTable.getData("General_Data", "TC_ID").contains("Manager"))) {
					Utility_Functions.xSendKeys(driver, txt_userName, properties.getProperty("FTE2GWSAMERManager"));
				} else if ((dataTable.getData("General_Data", "TC_ID").contains("GWSAMER"))
						&& (dataTable.getData("General_Data", "TC_ID").contains("Broker"))) {
					Utility_Functions.xSendKeys(driver, txt_userName, properties.getProperty("FTE2GWSAMERBroker"));
				} else if ((dataTable.getData("General_Data", "TC_ID").contains("GWSAMER"))
						&& (dataTable.getData("General_Data", "TC_ID").contains("CSS"))) {
					Utility_Functions.xSendKeys(driver, txt_userName, properties.getProperty("FTE2GWSAMERCSS"));
				} else if ((dataTable.getData("General_Data", "TC_ID").contains("GWSEMEA"))
						&& (dataTable.getData("General_Data", "TC_ID").contains("Manager"))) {
					Utility_Functions.xSendKeys(driver, txt_userName, properties.getProperty("FTE2GWSEMEAManager"));
				} else if ((dataTable.getData("General_Data", "TC_ID").contains("GWSEMEA"))
						&& (dataTable.getData("General_Data", "TC_ID").contains("Broker"))) {
					Utility_Functions.xSendKeys(driver, txt_userName, properties.getProperty("FTE2GWSEMEABroker"));
				} else if ((dataTable.getData("General_Data", "TC_ID").contains("GWSEMEA"))
						&& (dataTable.getData("General_Data", "TC_ID").contains("CSS"))) {
					Utility_Functions.xSendKeys(driver, txt_userName, properties.getProperty("FTE2GWSEMEACSS"));
				} else if ((dataTable.getData("General_Data", "TC_ID").contains("GWSAPAC"))
						&& (dataTable.getData("General_Data", "TC_ID").contains("Manager"))) {
					Utility_Functions.xSendKeys(driver, txt_userName, properties.getProperty("FTE2GWSAPACManager"));
				} else if ((dataTable.getData("General_Data", "TC_ID").contains("GWSAPAC"))
						&& (dataTable.getData("General_Data", "TC_ID").contains("Broker"))) {
					Utility_Functions.xSendKeys(driver, txt_userName, properties.getProperty("FTE2GWSAPACBroker"));
				} else if ((dataTable.getData("General_Data", "TC_ID").contains("GWSAPAC"))
						&& (dataTable.getData("General_Data", "TC_ID").contains("CSS"))) {
					Utility_Functions.xSendKeys(driver, txt_userName, properties.getProperty("FTE2GWSAPACCSS"));

				} else if ((dataTable.getData("General_Data", "TC_ID").contains("DAAMER"))
						&& (dataTable.getData("General_Data", "TC_ID").contains("Data"))) {
					Utility_Functions.xSendKeys(driver, txt_userName, properties.getProperty("FTE2DAAMERData"));
				} else if ((dataTable.getData("General_Data", "TC_ID").contains("DAEMEA"))
						&& (dataTable.getData("General_Data", "TC_ID").contains("Data"))) {
					Utility_Functions.xSendKeys(driver, txt_userName, properties.getProperty("FTE2DAEMEAData"));
				} else if ((dataTable.getData("General_Data", "TC_ID").contains("DAAPAC"))
						&& (dataTable.getData("General_Data", "TC_ID").contains("Data"))) {
					Utility_Functions.xSendKeys(driver, txt_userName, properties.getProperty("FTE2DAAPACData"));
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
				} else if ((dataTable.getData("General_Data", "TC_ID").contains("GWSAMER"))
						&& (dataTable.getData("General_Data", "TC_ID").contains("Broker"))) {
					Utility_Functions.xSendKeys(driver, txt_password,
							properties.getProperty("FTEGWSAMERBrokerPassword"));
				} else if ((dataTable.getData("General_Data", "TC_ID").contains("GWSAPAC"))
						&& (dataTable.getData("General_Data", "TC_ID").contains("Manager"))) {
					Utility_Functions.xSendKeys(driver, txt_password,
							properties.getProperty("FTEGWSAPACManagerPassword"));
				} else if ((dataTable.getData("General_Data", "TC_ID").contains("GWSEMEA"))
						&& (dataTable.getData("General_Data", "TC_ID").contains("Broker"))) {
					Utility_Functions.xSendKeys(driver, txt_password,
							properties.getProperty("FTEGWSEMEABrokerPassword"));

				} else if ((dataTable.getData("General_Data", "TC_ID").contains("VASAMER"))
						&& (dataTable.getData("General_Data", "TC_ID").contains("Manager"))) {
					Utility_Functions.xSendKeys(driver, txt_password,
							properties.getProperty("FTEVASAMERManagerPassword"));
				} else if ((dataTable.getData("General_Data", "TC_ID").contains("VASAPAC"))
						&& (dataTable.getData("General_Data", "TC_ID").contains("Broker"))) {
					Utility_Functions.xSendKeys(driver, txt_password,
							properties.getProperty("FFTEVASAPACBrokerPassword"));
				} else if ((dataTable.getData("General_Data", "TC_ID").contains("VASEMEA"))
						&& (dataTable.getData("General_Data", "TC_ID").contains("Broker"))) {
					Utility_Functions.xSendKeys(driver, txt_password,
							properties.getProperty("FTEVASEMEABrokerPassword"));

				} else if ((dataTable.getData("General_Data", "TC_ID").contains("ASAMER"))
						&& (dataTable.getData("General_Data", "TC_ID").contains("Manager"))) {
					Utility_Functions.xSendKeys(driver, txt_password,
							properties.getProperty("FTEASAMERManagerPassword"));
				} else if ((dataTable.getData("General_Data", "TC_ID").contains("ASAPAC"))
						&& (dataTable.getData("General_Data", "TC_ID").contains("Broker"))) {
					Utility_Functions.xSendKeys(driver, txt_password,
							properties.getProperty("FTEASAPACBrokerPassword"));
				} else if ((dataTable.getData("General_Data", "TC_ID").contains("ASEMEA"))
						&& (dataTable.getData("General_Data", "TC_ID").contains("Manager"))) {
					Utility_Functions.xSendKeys(driver, txt_password,
							properties.getProperty("FTEASEMEAManagerPassword"));
				} else if ((dataTable.getData("General_Data", "TC_ID").contains("ASEMEA"))
						&& (dataTable.getData("General_Data", "TC_ID").contains("Broker"))) {
					Utility_Functions.xSendKeys(driver, txt_password,
							properties.getProperty("FTEASEMEABrokerPassword"));
				} else if ((dataTable.getData("General_Data", "TC_ID").contains("ASAMER"))
						&& (dataTable.getData("General_Data", "TC_ID").contains("Broker"))) {
					Utility_Functions.xSendKeys(driver, txt_password,
							properties.getProperty("FTEASAMERBrokerPassword"));
				} else {
					Utility_Functions.xSendKeys(driver, txt_password, properties.getProperty("FTEPassword"));
				}
			} else if (environment.equals("FTE2")) {
				if (dataTable.getData("General_Data", "TC_ID").contains("Admin")) {
					Utility_Functions.xSendKeys(driver, txt_password, properties.getProperty("FTE2AdminPassword"));

				} else if ((dataTable.getData("General_Data", "TC_ID").contains("ABAMER"))
						&& (dataTable.getData("General_Data", "TC_ID").contains("Broker"))) {
					Utility_Functions.xSendKeys(driver, txt_password,
							properties.getProperty("FTE2ABAMERBrokerPassword"));

				} else if ((dataTable.getData("General_Data", "TC_ID").contains("CMAPAC"))
						&& (dataTable.getData("General_Data", "TC_ID").contains("CSS"))) {
					Utility_Functions.xSendKeys(driver, txt_password, properties.getProperty("FTE2CMAPACCSSPassword"));

				} else if ((dataTable.getData("General_Data", "TC_ID").contains("GWSAMER"))
						&& (dataTable.getData("General_Data", "TC_ID").contains("Broker"))) {
					Utility_Functions.xSendKeys(driver, txt_password,
							properties.getProperty("FTE2GWSAMERBrokerPasword"));
				} else if ((dataTable.getData("General_Data", "TC_ID").contains("GWSAPAC"))
						&& (dataTable.getData("General_Data", "TC_ID").contains("Manager"))) {
					Utility_Functions.xSendKeys(driver, txt_password,
							properties.getProperty("FTE2GWSAPACManagerPassword"));
				} else if ((dataTable.getData("General_Data", "TC_ID").contains("GWSEMEA"))
						&& (dataTable.getData("General_Data", "TC_ID").contains("Broker"))) {
					Utility_Functions.xSendKeys(driver, txt_password,
							properties.getProperty("FTE2GWSEMEABrokerPassword"));

				} else if ((dataTable.getData("General_Data", "TC_ID").contains("VASAMER"))
						&& (dataTable.getData("General_Data", "TC_ID").contains("Manager"))) {
					Utility_Functions.xSendKeys(driver, txt_password,
							properties.getProperty("FTE2VASAMERManagerPassword"));
				} else if ((dataTable.getData("General_Data", "TC_ID").contains("VASAPAC"))
						&& (dataTable.getData("General_Data", "TC_ID").contains("Broker"))) {
					Utility_Functions.xSendKeys(driver, txt_password,
							properties.getProperty("FTE2VASAPACBrokerPassword"));
				} else if ((dataTable.getData("General_Data", "TC_ID").contains("VASEMEA"))
						&& (dataTable.getData("General_Data", "TC_ID").contains("Broker"))) {
					Utility_Functions.xSendKeys(driver, txt_password,
							properties.getProperty("FTE2VASEMEABrokerPassword"));

				} else if ((dataTable.getData("General_Data", "TC_ID").contains("ASAMER"))
						&& (dataTable.getData("General_Data", "TC_ID").contains("Manager"))) {
					Utility_Functions.xSendKeys(driver, txt_password,
							properties.getProperty("FTE2ASAMERManagerPassword"));
				} else if ((dataTable.getData("General_Data", "TC_ID").contains("ASAPAC"))
						&& (dataTable.getData("General_Data", "TC_ID").contains("Broker"))) {
					Utility_Functions.xSendKeys(driver, txt_password,
							properties.getProperty("FTE2ASAPACBrokerPassword"));
				} else if ((dataTable.getData("General_Data", "TC_ID").contains("ASEMEA"))
						&& (dataTable.getData("General_Data", "TC_ID").contains("Manager"))) {
					Utility_Functions.xSendKeys(driver, txt_password,
							properties.getProperty("FTE2ASEMEAManagerPassword"));
				} else if ((dataTable.getData("General_Data", "TC_ID").contains("ASEMEA"))
						&& (dataTable.getData("General_Data", "TC_ID").contains("Broker"))) {
					Utility_Functions.xSendKeys(driver, txt_password,
							properties.getProperty("FTE2ASEMEABrokerPassword"));
				} else if ((dataTable.getData("General_Data", "TC_ID").contains("ASAMER"))
						&& (dataTable.getData("General_Data", "TC_ID").contains("Broker"))) {
					Utility_Functions.xSendKeys(driver, txt_password,
							properties.getProperty("FTE2ASAMERBrokerPassword"));
				} else if ((dataTable.getData("General_Data", "TC_ID").contains("ASAPAC"))
						&& (dataTable.getData("General_Data", "TC_ID").contains("Manager"))) {
					Utility_Functions.xSendKeys(driver, txt_password,
							properties.getProperty("FTE2ASAPACManagerPassword"));

				} else if ((dataTable.getData("General_Data", "TC_ID").contains("DAEMEA"))
						&& (dataTable.getData("General_Data", "TC_ID").contains("Data"))) {
					Utility_Functions.xSendKeys(driver, txt_password, properties.getProperty("FTE2DAEMEADataPassword"));

				} else {
					Utility_Functions.xSendKeys(driver, txt_password, properties.getProperty("FTE2Password"));
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