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
		
		/*//userNamesList.add("0050m000000G0xkAAC");
		userNamesList.add("0050m000000G0xpAAC");
		userNamesList.add("0050m000000G0xuAAC");
		userNamesList.add("0050m000000G0xzAAC");
		userNamesList.add("0050m000000G0y9AAC");
		userNamesList.add("0050m000000G0yEAAS");
		userNamesList.add("0050m000000G0yJAAS");
		userNamesList.add("0050m000000G0yOAAS");
		userNamesList.add("0050m000000G0yTAAS");
		userNamesList.add("0050m000000G0yYAAS");
		userNamesList.add("0050m000000G0ydAAC");
		userNamesList.add("0050m000000G0yiAAC");
		userNamesList.add("0050m000000G0ynAAC");*/
		/*userNamesList.add("0050m000000G0ysAAC");
		userNamesList.add("0050m000000G0yxAAC");
		userNamesList.add("0050m000000G0z2AAC");
		userNamesList.add("0050m000000G0z7AAC");
		userNamesList.add("0050m000000G0yUAAS");
		userNamesList.add("0050m000000G0zCAAS");
		userNamesList.add("0050m000000G0zHAAS");
		userNamesList.add("0050m000000G0zMAAS");
		userNamesList.add("0050m000000G0zRAAS");
		userNamesList.add("0050m000000G0zWAAS");
		userNamesList.add("0050m000000G0zbAAC");
		userNamesList.add("0050m000000G0zlAAC");
		userNamesList.add("0050m000000G0zqAAC");
		userNamesList.add("0050m000000G0zvAAC");
		userNamesList.add("0050m000000G100AAC");
		userNamesList.add("0050m000000G105AAC");
		userNamesList.add("0050m000000G10AAAS");
		userNamesList.add("0050m000000G0zrAAC");
		userNamesList.add("0050m000000G0ytAAC");
		userNamesList.add("0050m000000G10FAAS");
		userNamesList.add("0050m000000G10KAAS");
		userNamesList.add("0050m000000G10PAAS");
		userNamesList.add("0050m000000G10UAAS");
		userNamesList.add("0050m000000G10ZAAS");
		userNamesList.add("0050m000000G0zdAAC");
		userNamesList.add("0050m000000G10eAAC");
		userNamesList.add("0050m000000G10fAAC");
		userNamesList.add("0050m000000G10jAAC");
		userNamesList.add("0050m000000G10oAAC");
		userNamesList.add("0050m000000G10tAAC");
		userNamesList.add("0050m000000G10yAAC");
		userNamesList.add("0050m000000G113AAC");
		userNamesList.add("0050m000000G118AAC");
		userNamesList.add("0050m000000G119AAC");
		userNamesList.add("0050m000000G11DAAS");
		userNamesList.add("0050m000000G11NAAS");
		userNamesList.add("0050m000000G0xvAAC");*/
		//userNamesList.add("0050m000000G11SAAS");
/*		userNamesList.add("0050m000000G11XAAS");
		userNamesList.add("0050m000000G11cAAC");*/
		userNamesList.add("0050m000000G11mAAC");
		userNamesList.add("0050m000000G0yjAAC");
		userNamesList.add("0050m000000G11rAAC");
		userNamesList.add("0050m000000G11wAAC");
		userNamesList.add("0050m000000G126AAC");
		userNamesList.add("0050m000000G0yuAAC");
		userNamesList.add("0050m000000G12BAAS");
		userNamesList.add("0050m000000G9kB");

		System.out.println("User Names List are::::" + userNamesList);
	}
	
}