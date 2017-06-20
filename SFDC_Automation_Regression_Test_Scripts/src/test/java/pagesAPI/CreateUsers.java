package pagesAPI;

import org.openqa.selenium.support.PageFactory;
import com.cognizant.Craft.ReusableLibrary;
import com.cognizant.Craft.ScriptHelper;
import com.sforce.soap.partner.DeleteResult;
import com.sforce.soap.partner.SaveResult;
import com.sforce.soap.partner.sobject.SObject;


public class CreateUsers extends ReusableLibrary {
	/*
	 * Constructor to initialize the business component library
	 * 
	 * @param scriptHelper The {@link ScriptHelper} object passed from the
	 * {@link DriverScript}
	 */

	public CreateUsers(ScriptHelper scriptHelper) {
		super(scriptHelper);
		PageFactory.initElements(driver.getWebDriver(), this);
		// new WebDriverUtil(driver);
		// Utility_Functions utility = new Utility_Functions(scriptHelper);
	}

	static SaveResult[] results;
	static DeleteResult[] deleteResults;
	static com.sforce.soap.partner.Error[] errors;
	static boolean status = false;
	
	EstablishConnection establishConnection = new EstablishConnection(scriptHelper);
	
	/**
	 * Function for the creation of users
	 * 
	 * @author Vishnuvardhan
	 *
	 */
	public boolean createUsers() {
		try {
			establishConnection.establishConnection();
			SObject user = new SObject();
			
			user.setType("User");
            user.setField("LastName", "OBAMER");
			user.setField("Alias", "OBAMER");
			user.setField("Email", "vishnuvardhan.bommisetty@cbre.com");
			//user.setField("Nickname", "OBAMERBrokerUAT239@cbre.com");
			user.setField("Username", "OBAMERBrokerUAT239@cbre.com");
			user.setField("Role", "AMER");
			user.setField("UserLicense", "Salesforce");
			user.setField("Profile", "CBRE Broker - AMER - Occupier Brokerage");
            user.setField("TimeZoneSidKey", "America/Los_Angeles");
            user.setField("LocaleSidKey", "En");			
            user.setField("LanguageLocaleKey", "English");
            user.setField("Currency", "USD - U.S. Dollar");
            user.setField("DefaultGroupNotificationFrequency", "P");
            user.setField("DigestFrequency", "D");
            user.setField("EmailEncodingKey", "ISO-8859-1");
            user.setField("UserPermissionsCallCenterAutoLogin", "true");
            user.setField("UserPermissionsMarketingUser", "true");
            user.setField("UserPermissionsOfflineUser", "true"); 

			SObject[] users = new SObject[1];
			users[0] = user;
			results = EstablishConnection.connection.create(users);
			System.out.println("Result:::" + results);
			status = establishConnection.saveResults(results);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return status;
	}

}