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

	public String createUser(String firstName, String lastName, String alias, String email, String userName, String userRoleId, String profileId, String timeZoneSidKey) {
		try {
			SObject user = new SObject();
			user.setType("user");
			user.setField("FirstName", firstName);
			user.setField("LastName", lastName);
			user.setField("Alias", alias);
			user.setField("Email", email);
			user.setField("Username", userName);
			user.setField("UserRoleId", userRoleId);
			user.setField("profileId", profileId);
            user.setField("TimeZoneSidKey", timeZoneSidKey);
            user.setField("LocaleSidKey", "en_US");			
            user.setField("LanguageLocaleKey", "en_US");
            user.setField("DefaultCurrencyIsoCode", "USD");
            user.setField("DefaultGroupNotificationFrequency", "P");
            user.setField("DigestFrequency", "D");
            user.setField("EmailEncodingKey", "ISO-8859-1");
			System.out.println(EstablishConnection.connection.getUserInfo().getUserId());
			SObject[] users = new SObject[1];
			users[0] = user;
			results = EstablishConnection.connection.create(users);
			System.out.println("Result:::" + results);
			status = establishConnection.saveResults(results);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return results[0].getId();
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
	
	public void setPassword(String userId, String newPassword) {
		establishConnection.establishConnection();
		try {
				try {
					setPasswordResults = EstablishConnection.connection.setPassword(userId, newPassword);
					System.out.println("The password for user ID::::" + userId + ":::changed to:::" + newPassword);
					report.updateTestLog("New Password for the User ID:::", "The password for user ID" + userId + "changed to" + newPassword, Status.PASS);
				} catch (Exception e) {
					//resetPassword(userId);
				}							
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
		
		userNamesList.add("0052F000000d0UIQAY");
		userNamesList.add("0052F000000d0UJQAY");
		userNamesList.add("0052F000000d0UPQAY");
		userNamesList.add("0052F000000d0UQQAY");
		userNamesList.add("0052F000000d0UZQAY");
		userNamesList.add("0052F000000d0UaQAI");
		userNamesList.add("0052F000000d0UbQAI");
		userNamesList.add("0052F000000d0UcQAI");
		userNamesList.add("0052F000000d0UdQAI");
		userNamesList.add("0052F000000d0UeQAI");
		userNamesList.add("0052F000000d0UfQAI");
		userNamesList.add("0052F000000d0UgQAI");
		userNamesList.add("0052F000000d0UhQAI");
		userNamesList.add("0052F000000d0UiQAI");
		userNamesList.add("0052F000000d0UjQAI");
		userNamesList.add("0052F000000d0UkQAI");
		userNamesList.add("0052F000000d0UlQAI");
		userNamesList.add("0052F000000d0UmQAI");
		userNamesList.add("0052F000000d0UnQAI");
		userNamesList.add("0052F000000d0URQAY");
		userNamesList.add("0052F000000d0UoQAI");
		userNamesList.add("0052F000000d0UpQAI");
		userNamesList.add("0052F000000d0UqQAI");
		userNamesList.add("0052F000000d0UzQAI");
		userNamesList.add("0052F000000d0V0QAI");
		userNamesList.add("0052F000000d0V1QAI");
		userNamesList.add("0052F000000d0V2QAI");
		userNamesList.add("0052F000000d0USQAY");
		userNamesList.add("0052F000000d0V3QAI");
		userNamesList.add("0052F000000d0V4QAI");
		userNamesList.add("0052F000000d0V8QAI");
		userNamesList.add("0052F000000d0V9QAI");
		userNamesList.add("0052F000000d0VAQAY");
		userNamesList.add("0052F000000d0VBQAY");
		userNamesList.add("0052F000000d0VCQAY");
		userNamesList.add("0052F000000d0UTQAY");
		userNamesList.add("0052F000000d0VDQAY");
		userNamesList.add("0052F000000d0VEQAY");
		userNamesList.add("0052F000000d0UUQAY");
		userNamesList.add("0052F000000eR8wQAE");
		userNamesList.add("0052F000000eR91QAE");
		userNamesList.add("0052F000000eR96QAE");
		userNamesList.add("0052F000000eR9BQAU");
		userNamesList.add("0052F000000eR9GQAU");
		userNamesList.add("0052F000000eR9LQAU");
		userNamesList.add("0052F000000d0UVQAY");
		userNamesList.add("0052F000000eR9QQAU");
		userNamesList.add("0052F000000eR9VQAU");
		userNamesList.add("0052F000000eR9aQAE");
		userNamesList.add("0052F000000eR9fQAE");
		userNamesList.add("0052F000000eR9kQAE");
		userNamesList.add("0052F000000eR9pQAE");
		userNamesList.add("0052F000000eR9uQAE");
		userNamesList.add("0052F000000eR9zQAE");
		userNamesList.add("0052F000000eRA4QAM");
		userNamesList.add("0052F000000d0UWQAY");
		userNamesList.add("0052F000000eRA9QAM");
		userNamesList.add("0052F000000eRAEQA2");
		userNamesList.add("0052F000000eRATQA2");
		userNamesList.add("0052F000000eRAiQAM");
		userNamesList.add("0052F000000eRB2QAM");
		userNamesList.add("0052F000000eRBCQA2");
		userNamesList.add("0052F000000eRBWQA2");
		userNamesList.add("0052F000000eRBvQAM");
		userNamesList.add("0052F000000eRCFQA2");
		userNamesList.add("0052F000000d0UXQAY");
		userNamesList.add("0052F000000eRCZQA2");
		userNamesList.add("0052F000000eRCeQAM");
		userNamesList.add("0052F000000d0UYQAY");



		System.out.println("User Names List are::::" + userNamesList);
	}
	
}