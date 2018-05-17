package pagesAPI;


import java.util.ArrayList;
import java.util.List;

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
		String environment = properties.getProperty("RunEnvironment");
		List<String> UserNameList = new ArrayList<String>();
		if(environment.equals("FTE2")) {
			userNamesFTE2();
			UserNameList = FTE2userNamesList;
		}
		try {			
			for(int i=0; i < UserNameList.size(); i++) {
				String userId = UserNameList.get(i);
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
	static ArrayList<String> FTE2userNamesList = new ArrayList<String>();

	public void userNamesFTE2() {
		
		FTE2userNamesList.add("005m00000034p7JAAQ");
		FTE2userNamesList.add("005m00000034o36AAA");
		FTE2userNamesList.add("005m00000034o4xAAA");
		FTE2userNamesList.add("005m00000034o65AAA");
		FTE2userNamesList.add("005m00000034o6AAAQ");
		FTE2userNamesList.add("0051Y000009gz6LQAQ");
		FTE2userNamesList.add("0051Y000009gz6fQAA");
		FTE2userNamesList.add("0051Y000009gz6uQAA");
		FTE2userNamesList.add("0051Y000009gz6zQAA");
		FTE2userNamesList.add("0051Y000009gz79QAA");
		FTE2userNamesList.add("005m00000034ni8AAA");
		FTE2userNamesList.add("0051Y000009gz7OQAQ");
		FTE2userNamesList.add("0051Y000009gz7dQAA");
		FTE2userNamesList.add("0051Y000009gz82QAA");
		FTE2userNamesList.add("0051Y000009gz8CQAQ");
		FTE2userNamesList.add("0051Y000009gz8MQAQ");
		FTE2userNamesList.add("0051Y000009gz8bQAA");
		FTE2userNamesList.add("0051Y000009gz8qQAA");
		FTE2userNamesList.add("0051Y000009gz8RQAQ");
		FTE2userNamesList.add("005m00000034o6tAAA");
		FTE2userNamesList.add("005m00000034o73AAA");
		FTE2userNamesList.add("005m00000034o6UAAQ");
		FTE2userNamesList.add("005m00000034o7IAAQ");
		FTE2userNamesList.add("005m00000034o7NAAQ");
		FTE2userNamesList.add("005m00000034o7cAAA");
		FTE2userNamesList.add("005m00000034o7mAAA");
		FTE2userNamesList.add("005m00000034o81AAA");
		FTE2userNamesList.add("005m00000034o8BAAQ");
		FTE2userNamesList.add("005m00000034o8LAAQ");
		FTE2userNamesList.add("005m00000034o78AAA");
		FTE2userNamesList.add("005m00000034o8aAAA");
		FTE2userNamesList.add("005m00000034o8pAAA");
		FTE2userNamesList.add("005m00000034o8zAAA");
		FTE2userNamesList.add("005m00000034o99AAA");
		FTE2userNamesList.add("005m00000034o9EAAQ");
		FTE2userNamesList.add("005m00000034o9TAAQ");
		FTE2userNamesList.add("005m00000034o9dAAA");
		FTE2userNamesList.add("005m00000034o8QAAQ");
		FTE2userNamesList.add("005m00000034o82AAA");
		FTE2userNamesList.add("005m00000034oA2AAI");
		FTE2userNamesList.add("0051Y000009gz8vQAA");
		FTE2userNamesList.add("005m00000034o9sAAA");
		FTE2userNamesList.add("005m00000034oAMAAY");
		FTE2userNamesList.add("005m00000034oAWAAY");
		FTE2userNamesList.add("005m00000034oAbAAI");
		FTE2userNamesList.add("005m00000034oAlAAI");
		FTE2userNamesList.add("005m00000034oAqAAI");
		FTE2userNamesList.add("005m00000034oB0AAI");
		FTE2userNamesList.add("005m00000034oACAAY");
		FTE2userNamesList.add("005m00000034oBPAAY");
		FTE2userNamesList.add("005m00000034oBeAAI");
		FTE2userNamesList.add("005m00000034oBoAAI");
		FTE2userNamesList.add("005m00000034oBtAAI");
		FTE2userNamesList.add("005m00000034oC3AAI");
		FTE2userNamesList.add("005m00000034oCNAAY");
		FTE2userNamesList.add("005m00000034oCXAAY");
		FTE2userNamesList.add("005m00000034oCcAAI");
		FTE2userNamesList.add("005m00000034oCmAAI");
		FTE2userNamesList.add("005m00000034oBFAAY");
		FTE2userNamesList.add("005m00000034oD6AAI");
		FTE2userNamesList.add("005m00000034oDBAAY");
		FTE2userNamesList.add("005m00000034oDLAAY");
		FTE2userNamesList.add("005m00000034oDQAAY");
		FTE2userNamesList.add("005m00000034oDVAAY");
		FTE2userNamesList.add("005m00000034oDfAAI");
		FTE2userNamesList.add("005m00000034oDkAAI");
		FTE2userNamesList.add("005m00000034oDuAAI");
		FTE2userNamesList.add("005m00000034oE4AAI");
		FTE2userNamesList.add("005m00000034oCrAAI");
		FTE2userNamesList.add("005m00000034oddAAA");
		FTE2userNamesList.add("005m00000034odiAAA");
		FTE2userNamesList.add("005m00000034odsAAA");
		FTE2userNamesList.add("005m00000034p5cAAA");
		FTE2userNamesList.add("005m00000034p5hAAA");
		FTE2userNamesList.add("005m00000034p5rAAA");
		FTE2userNamesList.add("005m00000034p5wAAA");
		FTE2userNamesList.add("005m00000034p66AAA");
		FTE2userNamesList.add("005m00000034p6kAAA");
		FTE2userNamesList.add("005m00000034p6zAAA");
		FTE2userNamesList.add("005m00000034oZgAAI");

		System.out.println("User Names List are::::" + FTE2userNamesList);
	}
	
	
	
	/**
	 * 
	 *  List contains ids of all test users, UATSystemAdmin user : '0050x0000018OXeAAM' / inlcuded in below list
	 */
	
	static ArrayList<String> UATuserNamesList = new ArrayList<String>();

	public void userNamesUAT() {
		
		/*UATuserNamesList.add("0050x0000018PG6AAM");
		UATuserNamesList.add("0050x0000018OnXAAU");
		UATuserNamesList.add("0050x0000018OnhAAE");
		UATuserNamesList.add("0050x0000018Oo1AAE");
		UATuserNamesList.add("0050x0000018OoGAAU");
		UATuserNamesList.add("0051Y000009gz6LQAQ");
		UATuserNamesList.add("0051Y000009gz6fQAA");
		UATuserNamesList.add("0051Y000009gz6uQAA");
		UATuserNamesList.add("0051Y000009gz6zQAA");
		UATuserNamesList.add("0051Y000009gz79QAA");
		UATuserNamesList.add("0050x0000018OXeAAM");
		UATuserNamesList.add("0051Y000009gz7OQAQ");
		UATuserNamesList.add("0051Y000009gz7dQAA");
		UATuserNamesList.add("0051Y000009gz82QAA");
		UATuserNamesList.add("0051Y000009gz8CQAQ");
		UATuserNamesList.add("0051Y000009gz8MQAQ");
		UATuserNamesList.add("0051Y000009gz8bQAA");
		UATuserNamesList.add("0051Y000009gz8qQAA");
		UATuserNamesList.add("0051Y000009gz8RQAQ");
		UATuserNamesList.add("0050x0000018OpEAAU");
		UATuserNamesList.add("0050x0000018Oo7AAE");
		UATuserNamesList.add("0050x0000018OokAAE");
		UATuserNamesList.add("0050x0000018Oq2AAE");
		UATuserNamesList.add("0050x0000018OqMAAU");
		UATuserNamesList.add("0050x0000018OqgAAE");
		UATuserNamesList.add("0050x0000018OqvAAE");
		UATuserNamesList.add("0050x0000018OrFAAU");
		UATuserNamesList.add("0050x0000018OrUAAU");
		UATuserNamesList.add("0050x0000018OreAAE");
		UATuserNamesList.add("0050x0000018OpnAAE");
		UATuserNamesList.add("0050x0000018OsIAAU");
		UATuserNamesList.add("0050x0000018OsXAAU");
		UATuserNamesList.add("0050x0000018OsrAAE");
		UATuserNamesList.add("0050x0000018Ot6AAE");
		UATuserNamesList.add("0050x0000018OpaAAE");
		UATuserNamesList.add("0050x0000018OtkAAE");
		UATuserNamesList.add("0050x0000018Ou9AAE");
		UATuserNamesList.add("0050x0000018OryAAE");
		UATuserNamesList.add("0050x0000018OuiAAE");
		UATuserNamesList.add("0050x0000018OuxAAE");
		UATuserNamesList.add("0051Y000009gz8vQAA");
		UATuserNamesList.add("0050x0000018OuTAAU");
		UATuserNamesList.add("0050x0000018OvDAAU");
		UATuserNamesList.add("0050x0000018OvWAAU");
		UATuserNamesList.add("0050x0000018OvlAAE");
		UATuserNamesList.add("0050x0000018OvvAAE");
		UATuserNamesList.add("0050x0000018Ow0AAE");
		UATuserNamesList.add("0050x0000018OwPAAU");
		UATuserNamesList.add("0050x0000018OvCAAU");
		UATuserNamesList.add("0050x0000018OwoAAE");
		UATuserNamesList.add("0050x0000018OwyAAE");
		UATuserNamesList.add("0050x0000018OxIAAU");
		UATuserNamesList.add("0050x0000018OxXAAU");
		UATuserNamesList.add("0050x0000018Ox4AAE");
		UATuserNamesList.add("0050x0000018OxrAAE");
		UATuserNamesList.add("0050x0000018Oy1AAE");
		UATuserNamesList.add("0050x0000018OyVAAU");
		UATuserNamesList.add("0050x0000018OyaAAE");
		UATuserNamesList.add("0050x0000018OwZAAU");
		UATuserNamesList.add("0050x0000018Oz4AAE");
		UATuserNamesList.add("0050x0000018OzJAAU");
		UATuserNamesList.add("0050x0000018OzYAAU");
		UATuserNamesList.add("0050x0000018OzdAAE");
		UATuserNamesList.add("0050x0000018OznAAE");
		UATuserNamesList.add("0050x0000018P02AAE");
		UATuserNamesList.add("0050x0000018P0CAAU");
		UATuserNamesList.add("0050x0000018P0RAAU");
		UATuserNamesList.add("0050x0000018OylAAE");
		UATuserNamesList.add("0050x0000018OyuAAE");
		UATuserNamesList.add("0050x0000018P4JAAU");
		UATuserNamesList.add("0050x0000018P4TAAU");
		UATuserNamesList.add("0050x0000018P4nAAE");
		UATuserNamesList.add("0050x0000018P9TAAU");
		UATuserNamesList.add("0050x0000018PETAA2");
		UATuserNamesList.add("0050x0000018PEdAAM");
		UATuserNamesList.add("0050x0000018PF2AAM");
		UATuserNamesList.add("0050x0000018PFHAA2");
		UATuserNamesList.add("0050x0000018PGPAA2");
		UATuserNamesList.add("0050x0000018PGyAAM");
		UATuserNamesList.add("0050x0000018P44AAE");*/
		
		


		System.out.println("User Names List are::::" + UATuserNamesList);
	}
	
}

