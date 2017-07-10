package pagesAPI;


import java.util.ArrayList;
import org.openqa.selenium.support.PageFactory;
import com.cognizant.Craft.ReusableLibrary;
import com.cognizant.Craft.ScriptHelper;
import com.cognizant.framework.Status;
import com.sforce.soap.partner.DeleteResult;
import com.sforce.soap.partner.PartnerConnection;
import com.sforce.soap.partner.ResetPasswordResult;
import com.sforce.soap.partner.SaveResult;
import com.sforce.soap.partner.sobject.SObject;
import com.sforce.ws.ConnectionException;

import pageObjects.LoginPage;


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
	
	public static PartnerConnection connection = null;
	static SaveResult[] results;
	static DeleteResult[] deleteResults;
	static com.sforce.soap.partner.Error[] errors;
	static boolean status = false;
	
	EstablishConnection establishConnection = new EstablishConnection(scriptHelper);
	LoginPage loginPage = new LoginPage(scriptHelper);
	
	/**
	 * Function for the creation of users
	 * 
	 * @author Vishnuvardhan
	 *
	 */
	
	public void setPasswordUsersList() {
		setPassword("Release38FTE2");
	}

	public boolean createUsers() {
		try {
			SObject user = new SObject();
			user.setType("user");
			user.setField("Name", "OBAMER");
			user.setField("Alias", "OBAMER");
			user.setField("Email", "vishnuvardhan.bommisetty@cbre.com");
			//user.setField("Nickname", "OBAMERBrokerUAT239@cbre.com");
			user.setField("Username", "OBAMERBrokerUAT239@cbre.com");
			user.setField("UserRole", "AMER");
			//user.setField("UserLicense", "Salesforce");
			user.setField("Profile", "CBRE Broker - AMER - Occupier Brokerage");
            user.setField("TimeZoneSidKey", "America/Los_Angeles");
            user.setField("LocaleSidKey", "En");			
            user.setField("LanguageLocaleKey", "English");
            user.setField("DefaultCurrencyIsoCode", "USD - U.S. Dollar");
            user.setField("DefaultGroupNotificationFrequency", "P");
            user.setField("DigestFrequency", "D");
            user.setField("EmailEncodingKey", "ISO-8859-1");
/*            user.setField("UserPermissionsCallCenterAutoLogin", "true");
            user.setField("UserPermissionsMarketingUser", "true");
            user.setField("UserPermissionsOfflineUser", "true"); */
			establishConnection.establishConnection();

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
	
	/**
	 * Function for the creation of temporary password
	 * 
	 * @author Vishnuvardhan
	 *
	 */
	
	public String resetPassword(String userId) {
		String result ="";
		try {
			establishConnection.establishConnection();
			ResetPasswordResult resetPasswordResult = EstablishConnection.connection.resetPassword(userId);
			result = resetPasswordResult.getPassword();
			System.out.println("Temporary Password for User ID:::"+ result);
			report.updateTestLog("Temporary Password for the User ID:::", userId + ":::::" +result, Status.PASS);
		} catch (ConnectionException e) {
			System.out.println(e.getMessage());
		}
		return result;
	}
	/**
	 * Function for the set password
	 * 
	 * @author Vishnuvardhan
	 *
	 */
	public void setPassword(String newPassword) {
		establishConnection.establishConnection();
		userNames();
		try {
			for(int i=0; i < userNamesList.size(); i++) {
				String userId = userNamesList.get(i);
				EstablishConnection.connection.setPassword(userId, newPassword);
				System.out.println("The password for user ID" + userId + "changed to:::" + newPassword);
				report.updateTestLog("New Password for the User ID:::", "The password for user ID" + userId + "changed to" + newPassword, Status.PASS);
			}
			/*SetPasswordResult setPasswordResult = */
		} catch (ConnectionException e) {		
			System.out.println(e.getMessage());
		}
	}
	
	/**
	 * User Names for different environments 
	 * 
	 * @author Vishnuvardhan
	 *
	 */
	static ArrayList<String> userNamesList = new ArrayList<String>();

	public void userNames() {
		String environment = loginPage.initializeEnvironment();
		userNamesList.add("testuser2@cbre.com.crm."+ environment);
		userNamesList.add("testuser3@cbre.com.crm."+ environment);
		userNamesList.add("testuser4@cbre.com.crm."+ environment);
		userNamesList.add("testuser5@cbre.com.crm."+ environment);
		userNamesList.add("testuser6@cbre.com.crm."+ environment);
		userNamesList.add("testuser7@cbre.com.crm."+ environment);
		userNamesList.add("testuser8@cbre.com.crm."+ environment);
		userNamesList.add("testuser9@cbre.com.crm."+ environment);
		userNamesList.add("testuser10@cbre.com.crm."+ environment);
		userNamesList.add("testuser11@cbre.com.crm."+ environment);
		userNamesList.add("testuser12@cbre.com.crm."+ environment);
		userNamesList.add("testuser13@cbre.com.crm."+ environment);
		userNamesList.add("testuser14@cbre.com.crm."+ environment);
		userNamesList.add("testuser15@cbre.com.crm."+ environment);
		userNamesList.add("testuser16@cbre.com.crm."+ environment);
		userNamesList.add("testuser17@cbre.com.crm."+ environment);
		userNamesList.add("testuser18@cbre.com.crm."+ environment);
		userNamesList.add("testuser19@cbre.com.crm."+ environment);
		userNamesList.add("testuser20@cbre.com.crm."+ environment);
		userNamesList.add("testuser21@cbre.com.crm."+ environment);
		userNamesList.add("testuser22@cbre.com.crm."+ environment);
		userNamesList.add("testuser23@cbre.com.crm."+ environment);
		userNamesList.add("testuser24@cbre.com.crm."+ environment);
		userNamesList.add("testuser25@cbre.com.crm."+ environment);
		userNamesList.add("testuser26@cbre.com.crm."+ environment);
		userNamesList.add("testuser27@cbre.com.crm."+ environment);
		userNamesList.add("testuser28@cbre.com.crm."+ environment);
		userNamesList.add("testuser29@cbre.com.crm."+ environment);
		userNamesList.add("testuser30@cbre.com.crm."+ environment);
		userNamesList.add("testuser31@cbre.com.crm."+ environment);
		userNamesList.add("testuser32@cbre.com.crm."+ environment);
		userNamesList.add("testuser33@cbre.com.crm."+ environment);
		userNamesList.add("testuser34@cbre.com.crm."+ environment);
		userNamesList.add("testuser35@cbre.com.crm."+ environment);
		userNamesList.add("testuser36@cbre.com.crm."+ environment);
		userNamesList.add("testuser37@cbre.com.crm."+ environment);
		userNamesList.add("testuser38@cbre.com.crm."+ environment);
		userNamesList.add("testuser39@cbre.com.crm."+ environment);
		userNamesList.add("testuser40@cbre.com.crm."+ environment);
		userNamesList.add("testuser41@cbre.com.crm."+ environment);
		userNamesList.add("testuser42@cbre.com.crm."+ environment);
		userNamesList.add("testuser43@cbre.com.crm."+ environment);
		userNamesList.add("testuser44@cbre.com.crm."+ environment);
		userNamesList.add("testuser45@cbre.com.crm."+ environment);
		userNamesList.add("testuser46@cbre.com.crm."+ environment);
		userNamesList.add("testuser47@cbre.com.crm."+ environment);
		userNamesList.add("testuser48@cbre.com.crm."+ environment);
		userNamesList.add("testuser49@cbre.com.crm."+ environment);
		userNamesList.add("testuser50@cbre.com.crm."+ environment);
		userNamesList.add("testuser51@cbre.com.crm."+ environment);
		userNamesList.add("testuser52@cbre.com.crm."+ environment);
		userNamesList.add("testuser53@cbre.com.crm."+ environment);
		userNamesList.add("testuser53@cbre.com.crm."+ environment);
		userNamesList.add("testuser54@cbre.com.crm."+ environment);
		userNamesList.add("testuser55@cbre.com.crm."+ environment);
		userNamesList.add("testuser56@cbre.com.crm."+ environment);
		userNamesList.add("testuser57@cbre.com.crm."+ environment);
		userNamesList.add("testuser58@cbre.com.crm."+ environment);
		userNamesList.add("testuser59@cbre.com.crm."+ environment);
		userNamesList.add("testuser60@cbre.com.crm."+ environment);
		userNamesList.add("testuser61@cbre.com.crm."+ environment);
		System.out.println("User Names List are::::" + userNamesList);
	}
	
}