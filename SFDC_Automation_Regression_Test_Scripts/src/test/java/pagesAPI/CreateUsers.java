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
import com.sforce.soap.partner.SetPasswordResult;
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
	static SetPasswordResult setPasswordResults;
	public static String password = "Release_38_UATPassword";
	
	EstablishConnection establishConnection = new EstablishConnection(scriptHelper);
	LoginPage loginPage = new LoginPage(scriptHelper);
	
	/**
	 * Function for the creation of users
	 * 
	 * @author Vishnuvardhan
	 *
	 */
	
/*	public void setPasswordUsersList() {
		setPassword(password);
	}*/

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
			System.out.println("Temporary Password for User ID:::" + userId + ":::::" +result);
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
				try {
					setPasswordResults = EstablishConnection.connection.setPassword(userId, newPassword);
					System.out.println("The password for user ID::::" + userId + ":::changed to:::" + newPassword);
					report.updateTestLog("New Password for the User ID:::", "The password for user ID" + userId + "changed to" + newPassword, Status.PASS);
				} catch (Exception e) {
					//resetPassword(userId);
				}							
			}
			/*SetPasswordResult setPasswordResult = */
		} catch (Exception e) {		
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
		
		userNamesList.add("005e0000003luE7AAI");
		userNamesList.add("005e0000003luEPAAY");
		userNamesList.add("005e0000003luEjAAI");
		userNamesList.add("005e0000003luEEAAY");
		userNamesList.add("005e0000003luEVAAY");
		userNamesList.add("005e0000003luE3AAI");
		userNamesList.add("005e0000003luEFAAY");
		userNamesList.add("005e0000003luEWAAY");
		userNamesList.add("005e0000003luEGAAY");
		userNamesList.add("005e0000003luEZAAY");
		userNamesList.add("005e0000003luEHAAY");
		userNamesList.add("005e0000003luEMAAY");
		userNamesList.add("005e0000003luEaAAI");
		userNamesList.add("005e0000003luEJAAY");
		userNamesList.add("005e0000003luEcAAI");
		userNamesList.add("005e0000003luEoAAI");
		userNamesList.add("005e0000003luEKAAY");
		userNamesList.add("005e0000003luEdAAI");
		userNamesList.add("005e0000003luEeAAI");
		userNamesList.add("005e0000003uktRAAQ");
		userNamesList.add("005e0000003ukuyAAA");
		userNamesList.add("005e0000003vvxgAAA");
		userNamesList.add("005e00000040PQfAAM");
		userNamesList.add("005e00000040PSRAA2");
		userNamesList.add("005e00000040Rq1AAE");
		userNamesList.add("005e00000040RqGAAU");
		userNamesList.add("005e00000040RrnAAE");
		userNamesList.add("005e00000040RrsAAE");
		userNamesList.add("005e00000040RzwAAE");
		userNamesList.add("005e00000040S1OAAU");
		userNamesList.add("005e00000040ammAAA");
		userNamesList.add("005e00000040amwAAA");
		userNamesList.add("005e00000040ankAAA");
		userNamesList.add("005e00000040atdAAA");
		userNamesList.add("005e00000040bE2AAI");
		userNamesList.add("005e00000040bKtAAI");
		userNamesList.add("005e00000040baDAAQ");
		userNamesList.add("005e00000040cCgAAI");
		userNamesList.add("005e00000040cIKAAY");
		userNamesList.add("005e00000040hB4AAI");
		userNamesList.add("005e000000411ofAAA");
		userNamesList.add("005e00000041K92AAE");
		userNamesList.add("005e00000040PEZAA2");
		userNamesList.add("005e0000003mEtYAAU");

		System.out.println("User Names List are::::" + userNamesList);
	}
	
}