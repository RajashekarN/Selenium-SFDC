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
		
	/*	userNamesList.add("0050m000000NnNbAAK");
		userNamesList.add("0050m000000NnNgAAK");
		userNamesList.add("0050m000000NnNlAAK");*/
		userNamesList.add("0050m000000NnNqAAK");
		userNamesList.add("0050m000000NnNvAAK");
		userNamesList.add("0050m000000NnO0AAK");
		userNamesList.add("0050m000000NnO5AAK");
		userNamesList.add("0050m000000NnNrAAK");
		userNamesList.add("0050m000000NnOAAA0");
		userNamesList.add("0050m000000NnOFAA0");
		userNamesList.add("0050m000000NnOKAA0");
		userNamesList.add("0050m000000NnOPAA0");
		userNamesList.add("0050m000000NnOUAA0");
		userNamesList.add("0050m000000NnOZAA0");
		userNamesList.add("0050m000000NnOeAAK");
		userNamesList.add("0050m000000NnOjAAK");
		userNamesList.add("0050m000000NnOoAAK");
		userNamesList.add("0050m000000NnOtAAK");
		userNamesList.add("0050m000000NnOyAAK");
		userNamesList.add("0050m000000NnP3AAK");
		userNamesList.add("0050m000000NnP8AAK");
		userNamesList.add("0050m000000NnPDAA0");
		userNamesList.add("0050m000000NnPIAA0");
		userNamesList.add("0050m000000NnPNAA0");
		userNamesList.add("0050m000000NnPSAA0");
		userNamesList.add("0050m000000NnPTAA0");
		userNamesList.add("0050m000000NnPXAA0");
		userNamesList.add("0050m000000NnPcAAK");
		userNamesList.add("0050m000000NnPhAAK");
		userNamesList.add("0050m000000NnPmAAK");
		userNamesList.add("0050m000000NnPYAA0");
		userNamesList.add("0050m000000NnO1AAK");
		userNamesList.add("0050m000000NnOuAAK");
		userNamesList.add("0050m000000NnPrAAK");
		userNamesList.add("0050m000000NnPiAAK");
		userNamesList.add("0050m000000NnPwAAK");
		userNamesList.add("0050m000000NnPnAAK");
		userNamesList.add("0050m000000NnQ1AAK");
		userNamesList.add("0050m000000NnPjAAK");
		userNamesList.add("0050m000000NnQ6AAK");
		userNamesList.add("0050m000000NnQBAA0");
		userNamesList.add("0050m000000NnQGAA0");
		userNamesList.add("0050m000000NnQLAA0");
		userNamesList.add("0050m000000NnQCAA0");
		userNamesList.add("0050m000000NnQQAA0");
		userNamesList.add("0050m000000NnQVAA0");
		userNamesList.add("0050m000000NnQaAAK");
		userNamesList.add("0050m000000NnQfAAK");
		userNamesList.add("0050m000000NnQkAAK");
		userNamesList.add("0050m000000NnQpAAK");
		userNamesList.add("0050m000000NnQuAAK");
		userNamesList.add("0050m000000NnQzAAK");
		userNamesList.add("0050m000000NnQlAAK");
		userNamesList.add("0050m000000NnR4AAK");
		userNamesList.add("0050m000000NnR9AAK");
		userNamesList.add("0050m000000NnRAAA0");
		userNamesList.add("0050m000000NnREAA0");
		userNamesList.add("0050m000000NnRJAA0");
		userNamesList.add("0050m000000NnROAA0");
		userNamesList.add("0050m000000NnRTAA0");
		userNamesList.add("0050m000000NnRYAA0");
		System.out.println("User Names List are::::" + userNamesList);
	}
	
}