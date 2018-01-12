package pagesAPI;


import java.util.ArrayList;
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

public class CreateUsers extends ReusableLibrary {
	/*
	 * Constructor to initialize the business component library
	 * 
	 * @param scriptHelper The {@link ScriptHelper} object passed from the
	 * {@link DriverScript}
	 */

	public CreateUsers(ScriptHelper scriptHelper) {
		super(scriptHelper);
	}
	
	public static PartnerConnection connection = null;
	static SaveResult[] results;
	static DeleteResult[] deleteResults;
	static com.sforce.soap.partner.Error[] errors;
	static boolean status = false;
	static SetPasswordResult setPasswordResults;
	//public static String password = "Release_38_UATPassword";
	
	EstablishConnection establishConnection = new EstablishConnection(scriptHelper);
	
	/**
	 * Function for the creation of users
	 * 
	 * @author Vishnuvardhan
	 *
	 */

	public String createUser(String firstName, String lastName, String alias, String email, String userName, String userRoleId, String profileId, String geoGraphicalId, String timeZoneSidKey) {
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
			user.setField("Geographical_Role__c", geoGraphicalId);
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
	 * Function to set the password after creating the users list
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
	
	/**
	 * Function to set the password after creation of the user
	 * 
	 * @author Vishnuvardhan
	 *
	 */
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
		
		userNamesList.add("0050R000000GSvnQAG");
		userNamesList.add("0050R000000GSpzQAG");
		userNamesList.add("0050R000000GSq4QAG");
		userNamesList.add("0050R000000GSq9QAG");
		userNamesList.add("0050R000000GSqEQAW");
		userNamesList.add("0050R000000GSqJQAW");
		userNamesList.add("0050R000000GSqOQAW");
		userNamesList.add("0050R000000GSqTQAW");
		userNamesList.add("0050R000000GSqAQAW");
		userNamesList.add("0050R000000GSqFQAW");
		userNamesList.add("0050R000000GSpkQAG");
		userNamesList.add("0050R000000GSqdQAG");
		userNamesList.add("0050R000000GSqiQAG");
		userNamesList.add("0050R000000GSqnQAG");
		userNamesList.add("0050R000000GSqsQAG");
		userNamesList.add("0050R000000GSqxQAG");
		userNamesList.add("0050R000000GSr2QAG");
		userNamesList.add("0050R000000GSr7QAG");
		userNamesList.add("0050R000000GSrCQAW");
		userNamesList.add("0050R000000GSrHQAW");
		userNamesList.add("0050R000000GSrMQAW");
		userNamesList.add("0050R000000GSqYQAW");
		userNamesList.add("0050R000000GSrWQAW");
		userNamesList.add("0050R000000GSrbQAG");
		userNamesList.add("0050R000000GSrgQAG");
		userNamesList.add("0050R000000GSrlQAG");
		userNamesList.add("0050R000000GSrqQAG");
		userNamesList.add("0050R000000GSrvQAG");
		userNamesList.add("0050R000000GSs0QAG");
		userNamesList.add("0050R000000GSrRQAW");
		userNamesList.add("0050R000000GSsAQAW");
		userNamesList.add("0050R000000GSsBQAW");
		userNamesList.add("0050R000000GSsFQAW");
		userNamesList.add("0050R000000GSsKQAW");
		userNamesList.add("0050R000000GSsPQAW");
		userNamesList.add("0050R000000GSsUQAW");
		userNamesList.add("0050R000000GSsZQAW");
		userNamesList.add("0050R000000GSs5QAG");
		userNamesList.add("0050R000000GSsjQAG");
		userNamesList.add("0050R000000GSsoQAG");
		userNamesList.add("0050R000000GSseQAG");
		userNamesList.add("0050R000000GSsyQAG");
		userNamesList.add("0050R000000GSt3QAG");
		userNamesList.add("0050R000000GSt8QAG");
		userNamesList.add("0050R000000GStDQAW");
		userNamesList.add("0050R000000GStIQAW");
		userNamesList.add("0050R000000GStNQAW");
		userNamesList.add("0050R000000GSstQAG");
		userNamesList.add("0050R000000GStJQAW");
		userNamesList.add("0050R000000GStXQAW");
		userNamesList.add("0050R000000GStcQAG");
		userNamesList.add("0050R000000GSthQAG");
		userNamesList.add("0050R000000GStmQAG");
		userNamesList.add("0050R000000GStrQAG");
		userNamesList.add("0050R000000GStwQAG");
		userNamesList.add("0050R000000GSu1QAG");
		userNamesList.add("0050R000000GStSQAW");
		userNamesList.add("0050R000000GSuBQAW");
		userNamesList.add("0050R000000GSuGQAW");
		userNamesList.add("0050R000000GSuLQAW");
		userNamesList.add("0050R000000GSuQQAW");
		userNamesList.add("0050R000000GSuVQAW");
		userNamesList.add("0050R000000GSuaQAG");
		userNamesList.add("0050R000000GSufQAG");
		userNamesList.add("0050R000000GSukQAG");
		userNamesList.add("0050R000000GSupQAG");
		userNamesList.add("0050R000000GSu6QAG");
		userNamesList.add("0050R000000GSuzQAG");
		userNamesList.add("0050R000000GSv4QAG");
		userNamesList.add("0050R000000GSv9QAG");
		userNamesList.add("0050R000000GSvEQAW");
		userNamesList.add("0050R000000GSvJQAW");
		userNamesList.add("0050R000000GSvOQAW");
		userNamesList.add("0050R000000GSvTQAW");
		userNamesList.add("0050R000000GSvYQAW");
		userNamesList.add("0050R000000GSvdQAG");
		userNamesList.add("0050R000000GSviQAG");
		userNamesList.add("0050R000000GSuuQAG");
		System.out.println("User Names List are::::" + userNamesList);
	}
	
}