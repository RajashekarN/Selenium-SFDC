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

	public String createUser(String firstName, String lastName, String alias, String email, String userName, String userRoleId, String profileId, /*String geoGraphicalId,*/ String timeZoneSidKey) {
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
			//user.setField("Geographical_Role__c", geoGraphicalId);
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
					SearchTextSOQL searchTextSOQL = new SearchTextSOQL(scriptHelper);
					String query = "Select Username from User where Id = " + "'" + userId + "'";
					String sUserName = searchTextSOQL.fetchRecordFieldValue("Username", query);
					System.out.println("The password for user ID::::" + userId + ":::" + sUserName + ":::changed to:::" + newPassword);
					report.updateTestLog("New Password for the User ID:::", "The password for user ID:::" + sUserName + ":::" + userId + "changed to:::" + newPassword, Status.PASS);
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
		
		/*userNamesList.add("005W0000002rC40IAE");
		userNamesList.add("005W0000002rBsdIAE");
		userNamesList.add("005W0000002rBsnIAE");
		userNamesList.add("005W0000002rBsxIAE");
		userNamesList.add("005W0000002rBt2IAE");
		userNamesList.add("005W0000002rBt7IAE");
		userNamesList.add("005W0000002rBsyIAE");
		userNamesList.add("005W0000002rBtCIAU");
		userNamesList.add("005W0000002rBtMIAU");
		userNamesList.add("005W0000002rBtRIAU");
		userNamesList.add("005W0000002rBpeIAE");
		userNamesList.add("005W0000002rBtbIAE");
		userNamesList.add("005W0000002rBtgIAE");
		userNamesList.add("005W0000002rBtlIAE");
		userNamesList.add("005W0000002rBtqIAE");
		userNamesList.add("005W0000002rBtvIAE");
		userNamesList.add("005W0000002rBu0IAE");
		userNamesList.add("005W0000002rBuAIAU");
		userNamesList.add("005W0000002rBuFIAU");
		userNamesList.add("005W0000002rBuKIAU");
		userNamesList.add("005W0000002rBuPIAU");
		userNamesList.add("005W0000002rBtWIAU");
		userNamesList.add("005W0000002rBuZIAU");
		userNamesList.add("005W0000002rBueIAE");
		userNamesList.add("005W0000002rBujIAE");
		userNamesList.add("005W0000002rBuoIAE");
		userNamesList.add("005W0000002rButIAE");
		userNamesList.add("005W0000002rBuyIAE");
		userNamesList.add("005W0000002rBv3IAE");
		userNamesList.add("005W0000002rBuUIAU");
		userNamesList.add("005W0000002rBvIIAU");
		userNamesList.add("005W0000002rBvSIAU");
		userNamesList.add("005W0000002rBvXIAU");
		userNamesList.add("005W0000002rBvcIAE");
		userNamesList.add("005W0000002rBvhIAE");
		userNamesList.add("005W0000002rBvrIAE");
		userNamesList.add("005W0000002rBw1IAE");
		userNamesList.add("005W0000002rBv8IAE");
		userNamesList.add("005W0000002rBwBIAU");
		userNamesList.add("005W0000002rBwGIAU");
		userNamesList.add("005W0000002rBw6IAE");
		userNamesList.add("005W0000002rBwVIAU");
		userNamesList.add("005W0000002rBwaIAE");
		userNamesList.add("005W0000002rBwfIAE");
		userNamesList.add("005W0000002rBwkIAE");
		userNamesList.add("005W0000002rBwpIAE");
		userNamesList.add("005W0000002rBwuIAE");
		userNamesList.add("005W0000002rBwLIAU");
		userNamesList.add("005W0000002rBx4IAE");
		userNamesList.add("005W0000002rBx9IAE");
		userNamesList.add("005W0000002rBxEIAU");
		userNamesList.add("005W0000002rBxJIAU");
		userNamesList.add("005W0000002rBxYIAU");
		userNamesList.add("005W0000002rBxdIAE");
		userNamesList.add("005W0000002rBxiIAE");
		userNamesList.add("005W0000002rBxnIAE");
		userNamesList.add("005W0000002rBxsIAE");
		userNamesList.add("005W0000002rBwzIAE");
		userNamesList.add("005W0000002rBy2IAE");
		userNamesList.add("005W0000002rBy7IAE");
		userNamesList.add("005W0000002rByMIAU");
		userNamesList.add("005W0000002rByRIAU");
		userNamesList.add("005W0000002rBylIAE");
		userNamesList.add("005W0000002rByvIAE");
		userNamesList.add("005W0000002rBz0IAE");
		userNamesList.add("005W0000002rBzAIAU");
		userNamesList.add("005W0000002rBzFIAU");
		userNamesList.add("005W0000002rBxxIAE");
		userNamesList.add("005W0000002rBzyIAE");
		userNamesList.add("005W0000002rC03IAE");
		userNamesList.add("005W0000002rC08IAE");
		userNamesList.add("005W0000002rC0DIAU");
		userNamesList.add("005W0000002rC0IIAU");
		userNamesList.add("005W0000002rC0NIAU");
		userNamesList.add("005W0000002rC0SIAU");
		userNamesList.add("005W0000002rC0XIAU");
		userNamesList.add("005W0000002rC3bIAE");
		userNamesList.add("005W0000002rC3lIAE");
		userNamesList.add("005W0000002rBztIAE");*/

		//userNamesList.add("0050U000000cqQDQAY");
		userNamesList.add("0050U000000cq5AQAQ");
		userNamesList.add("0050U000000cq5KQAQ");
		userNamesList.add("0050U000000cq5ZQAQ");
		userNamesList.add("0050U000000cq5oQAA");
		userNamesList.add("0050U000000cq68QAA");
		userNamesList.add("0050U000000cq6SQAQ");
		userNamesList.add("0050U000000cq6cQAA");
		userNamesList.add("0050U000000cq6rQAA");
		userNamesList.add("0050U000000cq71QAA");
		userNamesList.add("0050U000000cq4vQAA");
		userNamesList.add("0050U000000cq7QQAQ");
		userNamesList.add("0050U000000cq7aQAA");
		userNamesList.add("0050U000000cq4hQAA");
		userNamesList.add("0050U000000cq7uQAA");
		userNamesList.add("0050U000000cq84QAA");
		userNamesList.add("0050U000000cq8OQAQ");
		userNamesList.add("0050U000000cq8YQAQ");
		userNamesList.add("0050U000000cq8nQAA");
		userNamesList.add("0050U000000cq8xQAA");
		userNamesList.add("0050U000000cq9CQAQ");
		userNamesList.add("0050U000000cq7GQAQ");
		userNamesList.add("0050U000000cq9bQAA");
		userNamesList.add("0050U000000cq9lQAA");
		userNamesList.add("0050U000000cqA0QAI");
		userNamesList.add("0050U000000cqAFQAY");
		userNamesList.add("0050U000000cqAZQAY");
		userNamesList.add("0050U000000cqAjQAI");
		userNamesList.add("0050U000000cqAyQAI");
		userNamesList.add("0050U000000cq9RQAQ");
		userNamesList.add("0050U000000cqBNQAY");
		userNamesList.add("0050U000000cqBXQAY");
		userNamesList.add("0050U000000cqBmQAI");
		userNamesList.add("0050U000000cqBwQAI");
		userNamesList.add("0050U000000cqCBQAY");
		userNamesList.add("0050U000000cqCQQAY");
		userNamesList.add("0050U000000cqCfQAI");
		userNamesList.add("0050U000000cqB8QAI");
		userNamesList.add("0050U000000cqD9QAI");
		userNamesList.add("0050U000000cqDJQAY");
		userNamesList.add("0050U000000cqCuQAI");
		userNamesList.add("0050U000000cqDiQAI");
		userNamesList.add("0050U000000cqDsQAI");
		userNamesList.add("0050U000000cqE2QAI");
		userNamesList.add("0050U000000cqECQAY");
		userNamesList.add("0050U000000cqERQAY");
		userNamesList.add("0050U000000cqEbQAI");
		userNamesList.add("0050U000000cqDYQAY");
		userNamesList.add("0050U000000cqEvQAI");
		userNamesList.add("0050U000000cqFAQAY");
		userNamesList.add("0050U000000cqFPQAY");
		userNamesList.add("0050U000000cqFZQAY");
		userNamesList.add("0050U000000cqFoQAI");
		userNamesList.add("0050U000000cqFyQAI");
		userNamesList.add("0050U000000cqGDQAY");
		userNamesList.add("0050U000000cqGNQAY");
		userNamesList.add("0050U000000cqGhQAI");
		userNamesList.add("0050U000000cqElQAI");
		userNamesList.add("0050U000000cqGwQAI");
		userNamesList.add("0050U000000cqHBQAY");
		userNamesList.add("0050U000000cqHLQAY");
		userNamesList.add("0050U000000cqHaQAI");
		userNamesList.add("0050U000000cqFpQAI");
		userNamesList.add("0050U000000cqHpQAI");
		userNamesList.add("0050U000000cqHzQAI");
		userNamesList.add("0050U000000cqHMQAY");
		userNamesList.add("0050U000000cqIOQAY");
		userNamesList.add("0050U000000cqGYQAY");
		userNamesList.add("0050U000000cqKFQAY");
		userNamesList.add("0050U000000cqKjQAI");
		userNamesList.add("0050U000000cqM6QAI");
		userNamesList.add("0050U000000cqMaQAI");
		userNamesList.add("0050U000000cqMfQAI");
		userNamesList.add("0050U000000cqMpQAI");
		userNamesList.add("0050U000000cqNEQAY");
		userNamesList.add("0050U000000cqNYQAY");
		userNamesList.add("0050U000000cqOvQAI");
		userNamesList.add("0050U000000cqPeQAI");
		userNamesList.add("0050U000000cqK0QAI");

		System.out.println("User Names List are::::" + userNamesList);
	}
	
}