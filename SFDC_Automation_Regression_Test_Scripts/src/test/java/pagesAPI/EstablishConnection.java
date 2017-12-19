package pagesAPI;

import org.openqa.selenium.support.PageFactory;
import com.cognizant.Craft.ReusableLibrary;
import com.cognizant.Craft.ScriptHelper;
import com.cognizant.framework.Status;
import com.sforce.soap.partner.DeleteResult;
import com.sforce.soap.partner.GetUserInfoResult;
import com.sforce.soap.partner.PartnerConnection;
import com.sforce.soap.partner.SaveResult;
import com.sforce.ws.ConnectionException;
import com.sforce.ws.ConnectorConfig;

import pageObjects.LoginPage;

public class EstablishConnection extends ReusableLibrary {
	/*
	 * Constructor to initialize the business component library
	 * 
	 * @param scriptHelper The {@link ScriptHelper} object passed from the
	 * {@link DriverScript}
	 */

	public EstablishConnection(ScriptHelper scriptHelper) {
		super(scriptHelper);
		PageFactory.initElements(driver.getWebDriver(), this);
		// new WebDriverUtil(driver);
		// Utility_Functions utility = new Utility_Functions(scriptHelper);
	}

	public static PartnerConnection connection = null;
	static ConnectorConfig config;
	static com.sforce.soap.partner.Error[] errors;
	static boolean status = false;
	static String result;
	//public String environment = properties.getProperty("RunEnvironment");
	//public String environment = System.getProperty("RunEnvironment");
	
	/**
	 * Function for establishing the connection
	 * 
	 * @author Vishnuvardhan
	 *
	 */
	LoginPage loginPage = new LoginPage(scriptHelper);
	/*public void establishConnection() {
		try {
			String environment = loginPage.initializeEnvironment();
			System.out.println(environment);
			if (environment.equals("UAT")) {
				String UAT_Username = properties.getProperty("UATSystemAdminUsername");
				String UAT_Password = properties.getProperty("UATAdminPassword");
				String UAT_AuthEndpoint = properties.getProperty("UATAuthEndpoint");
				config = new ConnectorConfig();
				config.setUsername(UAT_Username);
				config.setPassword(UAT_Password);
				System.out.println("AuthEndPoint: " + UAT_AuthEndpoint);
				config.setAuthEndpoint(UAT_AuthEndpoint);
				connection = new PartnerConnection(config);
			} else if (environment.equals("UAT2")) {
				String UAT2_Username = properties.getProperty("UAT2SystemAdminUsername");
				String UAT2_Password = properties.getProperty("UAT2AdminPassword");
				String UAT2_AuthEndpoint = properties.getProperty("UAT2AuthEndpoint");
				config = new ConnectorConfig();
				config.setUsername(UAT2_Username);
				config.setPassword(UAT2_Password);
				System.out.println("AuthEndPoint: " + UAT2_AuthEndpoint);
				config.setAuthEndpoint(UAT2_AuthEndpoint);
				connection = new PartnerConnection(config);
			} else if (environment.equals("FTE")) {
				String FTE_Username = properties.getProperty("FTESystemAdminUsername");
				String FTE_Password = properties.getProperty("FTEAdminPassword");
				String FTE_AuthEndpoint = properties.getProperty("FTEAuthEndpoint");
				config = new ConnectorConfig();
				config.setUsername(FTE_Username);
				config.setPassword(FTE_Password);
				System.out.println("AuthEndPoint: " + FTE_AuthEndpoint);
				config.setAuthEndpoint(FTE_AuthEndpoint);
				connection = new PartnerConnection(config);
			} else if (environment.equals("FTE2")) {
				String FTE2_Username = properties.getProperty("FTE2SystemAdminUsername");
				String FTE2_Password = properties.getProperty("FTE2AdminPassword");
				String FTE2_AuthEndpoint = properties.getProperty("FTE2AuthEndpoint");
				config = new ConnectorConfig();
				config.setUsername(FTE2_Username);
				config.setPassword(FTE2_Password);
				System.out.println("AuthEndPoint: " + FTE2_AuthEndpoint);
				config.setAuthEndpoint(FTE2_AuthEndpoint);
				connection = new PartnerConnection(config);
			}
		} catch (ConnectionException e) {
			e.printStackTrace();
		}
	}*/
	
	public void establishConnection() {
		try {
			String environment = loginPage.initializeEnvironment();
			System.out.println(environment);
			String Username = null, Password;
			if ((environment.equals("UAT")) || (environment.equals("UAT2")) || (environment.equals("FTE")) || (environment.equals("FTE2"))) {
				if ((dataTable.getData("General_Data", "TC_ID").contains("OBEMEA")) && (dataTable.getData("General_Data", "TC_ID").contains("Broker"))) 
					Username = properties.getProperty(environment+"OBEMEABroker");
				else if ((dataTable.getData("General_Data", "TC_ID").contains("OBEMEA")) && (dataTable.getData("General_Data", "TC_ID").contains("Manager"))) 
					Username = properties.getProperty(environment+"OBEMEAManager");
				else if ((dataTable.getData("General_Data", "TC_ID").contains("OBEMEA")) && (dataTable.getData("General_Data", "TC_ID").contains("CSS"))) 
					Username = properties.getProperty(environment+"OBEMEACSS");		
				else if ((dataTable.getData("General_Data", "TC_ID").contains("CMAPAC")) && (dataTable.getData("General_Data", "TC_ID").contains("Broker"))) 
					Username = properties.getProperty(environment+"CMAPACBroker");		
				else if ((dataTable.getData("General_Data", "TC_ID").contains("CMAPAC")) && (dataTable.getData("General_Data", "TC_ID").contains("Manager"))) 
					Username = properties.getProperty(environment+"CMAPACManager");		
				else if ((dataTable.getData("General_Data", "TC_ID").contains("CMAPAC")) && (dataTable.getData("General_Data", "TC_ID").contains("CSS"))) 
					Username = properties.getProperty(environment+"CMAPACSS");	
				else if ((dataTable.getData("General_Data", "TC_ID").contains("ABEMEA")) && (dataTable.getData("General_Data", "TC_ID").contains("Broker"))) 
					Username = properties.getProperty(environment+"ABEMEABroker");	
				else if ((dataTable.getData("General_Data", "TC_ID").contains("ABEMEA")) && (dataTable.getData("General_Data", "TC_ID").contains("Manager"))) 
					Username = properties.getProperty(environment+"ABEMEAManager");	
				else if ((dataTable.getData("General_Data", "TC_ID").contains("ABEMEA")) && (dataTable.getData("General_Data", "TC_ID").contains("CSS"))) 
					Username = properties.getProperty(environment+"ABEMEACSS");	
				else if ((dataTable.getData("General_Data", "TC_ID").contains("ABAMER")) && (dataTable.getData("General_Data", "TC_ID").contains("Admin"))) 
					Username = properties.getProperty(environment+"SystemAdminUsername");	
				else if ((dataTable.getData("General_Data", "TC_ID").contains("ABAMER")) && (dataTable.getData("General_Data", "TC_ID").contains("Broker"))) 
					Username = properties.getProperty(environment+"ABAMERBroker");	
				else if ((dataTable.getData("General_Data", "TC_ID").contains("ABAMER")) && (dataTable.getData("General_Data", "TC_ID").contains("Manager"))) 
					Username = properties.getProperty(environment+"ABAMERManager");	
				else if ((dataTable.getData("General_Data", "TC_ID").contains("ABAMER")) && (dataTable.getData("General_Data", "TC_ID").contains("CSS"))) 
					Username = properties.getProperty(environment+"ABAMERCSS");	
				else if ((dataTable.getData("General_Data", "TC_ID").contains("OBAMER")) && (dataTable.getData("General_Data", "TC_ID").contains("Broker"))) 
					Username = properties.getProperty(environment+"OBAMERBroker");	
				else if ((dataTable.getData("General_Data", "TC_ID").contains("OBAMER")) && (dataTable.getData("General_Data", "TC_ID").contains("Manager"))) 
					Username = properties.getProperty(environment+"OBAMERManager");	
				else if ((dataTable.getData("General_Data", "TC_ID").contains("OBAMER")) && (dataTable.getData("General_Data", "TC_ID").contains("CSS"))) 
					Username = properties.getProperty(environment+"OBAMERCSS");	
				else if ((dataTable.getData("General_Data", "TC_ID").contains("OBAMER")) && (dataTable.getData("General_Data", "TC_ID").contains("Admin"))) 
					Username = properties.getProperty(environment+"SystemAdminUsername");	
				else if ((dataTable.getData("General_Data", "TC_ID").contains("OBAPAC")) && (dataTable.getData("General_Data", "TC_ID").contains("Broker"))) 
					Username = properties.getProperty(environment+"OBAPACBroker");
				else if ((dataTable.getData("General_Data", "TC_ID").contains("OBAPAC")) && (dataTable.getData("General_Data", "TC_ID").contains("Manager"))) 
					Username = properties.getProperty(environment+"OBAPACManager");
				else if ((dataTable.getData("General_Data", "TC_ID").contains("OBAPAC")) && (dataTable.getData("General_Data", "TC_ID").contains("CSS"))) 
					Username = properties.getProperty(environment+"OBAPACCSS");
				else if ((dataTable.getData("General_Data", "TC_ID").contains("CMAMER")) && (dataTable.getData("General_Data", "TC_ID").contains("Broker"))) 
					Username = properties.getProperty(environment+"CMAMERBroker");	
				else if ((dataTable.getData("General_Data", "TC_ID").contains("CMAMER")) && (dataTable.getData("General_Data", "TC_ID").contains("Manager"))) 
					Username = properties.getProperty(environment+"CMAMERManager");	
				else if ((dataTable.getData("General_Data", "TC_ID").contains("CMAMER")) && (dataTable.getData("General_Data", "TC_ID").contains("CSS"))) 
					Username = properties.getProperty(environment+"CMAMERCSS");		
				else if ((dataTable.getData("General_Data", "TC_ID").contains("ASAPAC")) && (dataTable.getData("General_Data", "TC_ID").contains("Broker"))) 
					Username = properties.getProperty(environment+"ASAPACBroker");	
				else if ((dataTable.getData("General_Data", "TC_ID").contains("ASAPAC")) && (dataTable.getData("General_Data", "TC_ID").contains("Manager"))) 
					Username = properties.getProperty(environment+"ASAPACManager");		
				else if ((dataTable.getData("General_Data", "TC_ID").contains("ASAPAC")) && (dataTable.getData("General_Data", "TC_ID").contains("CSS"))) 
					Username = properties.getProperty(environment+"ASAPACCSS");		
				else if ((dataTable.getData("General_Data", "TC_ID").contains("FRANEMEA")) && (dataTable.getData("General_Data", "TC_ID").contains("Manager"))) 
					Username = properties.getProperty(environment+"FRANEMEAManager");	
				else if ((dataTable.getData("General_Data", "TC_ID").contains("FDIGEMEA")) && (dataTable.getData("General_Data", "TC_ID").contains("Manager"))) 
					Username = properties.getProperty(environment+"FDIGEMEAManager");	
				else if ((dataTable.getData("General_Data", "TC_ID").contains("FDIREMEA")) && (dataTable.getData("General_Data", "TC_ID").contains("Manager"))) 
					Username = properties.getProperty(environment+"FDIREMEAManager");	
				else if ((dataTable.getData("General_Data", "TC_ID").contains("FDIGEMEA")) && (dataTable.getData("General_Data", "TC_ID").contains("Data"))) 
					Username = properties.getProperty(environment+"FDIGEMEAData");	
			}	
			
			if (environment.equals("UAT")) { 			
				Password = properties.getProperty("UATAdminPassword");
				String UAT_AuthEndpoint = properties.getProperty("UATAuthEndpoint");
				config = new ConnectorConfig();
				config.setUsername(Username);
				config.setPassword(Password);
				System.out.println("AuthEndPoint: " + UAT_AuthEndpoint);
				config.setAuthEndpoint(UAT_AuthEndpoint);
				connection = new PartnerConnection(config);
				System.out.println(connection);
			} else if (environment.equals("UAT2")) {				
				Password = properties.getProperty("UAT2AdminPassword");
				String UAT2_AuthEndpoint = properties.getProperty("UAT2AuthEndpoint");
				config = new ConnectorConfig();
				config.setUsername(Username);
				config.setPassword(Password);
				System.out.println("AuthEndPoint: " + UAT2_AuthEndpoint);
				config.setAuthEndpoint(UAT2_AuthEndpoint);
				connection = new PartnerConnection(config);
			} else if (environment.equals("FTE")) {				
				Password = properties.getProperty("FTEAdminPassword");
				String FTE_AuthEndpoint = properties.getProperty("FTEAuthEndpoint");
				config = new ConnectorConfig();
				config.setUsername(Username);
				config.setPassword(Password);
				System.out.println("AuthEndPoint: " + FTE_AuthEndpoint);
				config.setAuthEndpoint(FTE_AuthEndpoint);
				connection = new PartnerConnection(config);
			} else if (environment.equals("FTE2")) {				
				Password = properties.getProperty("FTE2AdminPassword");
				String FTE2_AuthEndpoint = properties.getProperty("FTE2AuthEndpoint");
				config = new ConnectorConfig();
				config.setUsername(Username);
				config.setPassword(Password);
				System.out.println("AuthEndPoint: " + FTE2_AuthEndpoint);
				config.setAuthEndpoint(FTE2_AuthEndpoint);
				connection = new PartnerConnection(config);
			}
		} catch (ConnectionException e) {
			e.printStackTrace();
		}
	}


	/**
	 * Function for retrieving the User Configuration
	 * 
	 * @author Vishnuvardhan
	 *
	 */

	public boolean retrieveUserConfiguration() {
		boolean success = false;
		try {
			establishConnection();
			GetUserInfoResult userInfo = EstablishConnection.connection.getUserInfo();
			System.out.println("UserID: " + userInfo.getUserId());
			System.out.println("User Full Name: " + userInfo.getUserFullName());
			System.out.println("User Email: " + userInfo.getUserEmail());
			System.out.println("SessionID: " + EstablishConnection.config.getSessionId());
			System.out.println("Auth End Point: " + EstablishConnection.config.getAuthEndpoint());
			System.out.println("Service End Point: " + EstablishConnection.config.getServiceEndpoint());
			report.updateTestLog("Verify Login", "User ID used for login using API: " + userInfo.getUserId(),
					Status.PASS);
			report.updateTestLog("Verify Login", "User Full Name: " + userInfo.getUserFullName(), Status.PASS);
			report.updateTestLog("Verify Login", "User Email: " + userInfo.getUserEmail(), Status.PASS);
			report.updateTestLog("Verify Login", "SessionID: " + EstablishConnection.config.getSessionId(),
					Status.PASS);
			report.updateTestLog("Verify Login", "Auth End Point: " + EstablishConnection.config.getAuthEndpoint(),
					Status.PASS);
			report.updateTestLog("Verify Login",
					"Service End Point: " + EstablishConnection.config.getServiceEndpoint(), Status.PASS);
			success = true;
		} catch (ConnectionException ce) {
			ce.printStackTrace();
			System.out.println(ce.getMessage());
		}
		return success;
	}

	/**
	 * Function for the saving the results
	 * 
	 * @author Vishnuvardhan
	 *
	 */

	public boolean saveResults(SaveResult[] Results) {
		SaveResult[] results = Results;
		System.out.println("Results:::" + results);
		for (int j = 0; j < results.length; j++) {
			if (results[j].isSuccess()) {
				result = results[j].getId();
				System.out.println("Save Results:::" + result);
				report.updateTestLog("Verify Create/ Update Account", "Result :: " + result, Status.PASS);
				String query = null;
				if(result.contains("001")) {
					query = "Select Name from Account where Id = " + "'" + result + "'";
				} else if(result.contains("003")) {
					query = "Select Name from Contact where Id = " + "'" + result + "'";
				} else if(result.contains("006")) {
					query = "Select Name from Opportunity where Id = " + "'" + result + "'";
				} else if(result.startsWith("a0")) {
					query = "Select Name from Property__c where Id = " + "'" + result + "'";
				}
				SearchTextSOQL searchTextSOQL = new SearchTextSOQL(scriptHelper);
				String name = searchTextSOQL.fetchRecordFieldValue("Name", query);
				report.updateTestLog("Verify Create/ Update Account/ Contact/ Opportuntiy", "Name of the Account/ Contact/ Opportunity :: " + name, Status.PASS);
				status = true;
			} else {
				for (int i = 0; i < results[j].getErrors().length; i++) {
					com.sforce.soap.partner.Error err = results[j].getErrors()[i];
					report.updateTestLog("Verify Create/ Update Account, Contact, Lead, Opportunities", "Errors were found on item:::" + j,
							Status.FAIL);
					report.updateTestLog("Verify Create/ Update Account",
							"Errors code:::" + err.getStatusCode().toString(), Status.FAIL);
					report.updateTestLog("Verify Create/ Update Account, Contact, Lead, Opportunities", "Errors message:::" + err.getMessage(),
							Status.FAIL);
					System.out.println("Errors were found on item " + j);
					System.out.println("Error code::" + err.getStatusCode().toString());
					System.out.println("Error message::" + err.getMessage());
					status = false;
				}
			}
		}
		return status;
	}

	/**
	 * Function for the getting the result from results array
	 * 
	 * @author Vishnuvardhan
	 *
	 */
	public String saveResultsId(SaveResult[] Results) {
		SaveResult[] results = Results;
		for (int j = 0; j < results.length; j++) {
			if (results[j].isSuccess()) {
				result = results[j].getId();
				System.out.println("Save Results:::" + result);
				report.updateTestLog("Verify Create/ Update Account", "Result :: " + result, Status.PASS);
			} else {
				for (int i = 0; i < results[j].getErrors().length; i++) {
					com.sforce.soap.partner.Error err = results[j].getErrors()[i];
					report.updateTestLog("Verify Create/ Update Account, Contact, Lead, Opportunities", "Errors were found on item:::" + j,
							Status.FAIL);
					report.updateTestLog("Verify Create/ Update Account",
							"Errors code:::" + err.getStatusCode().toString(), Status.FAIL);
					report.updateTestLog("Verify Create/ Update Account, Contact, Lead, Opportunities", "Errors message:::" + err.getMessage(),
							Status.FAIL);
					System.out.println("Errors were found on item " + j);
					System.out.println("Error code::" + err.getStatusCode().toString());
					System.out.println("Error message::" + err.getMessage());
					result = err.getMessage();
				}
			}
		}
		return result;
	}
	
	
	/**
	 * Function for saving the delete results
	 * 
	 * @author Vishnuvardhan
	 *
	 */

	public boolean deleteResults(DeleteResult[] DeleteResults) {
		DeleteResult[] deleteResults = DeleteResults;
		System.out.println("Results:::" + deleteResults);
		for (int j = 0; j < deleteResults.length; j++) {
			if (deleteResults[j].isSuccess()) {
				deleteResults[j].getId();
				System.out.println("Delete Results:::" + deleteResults[j].getId());
				report.updateTestLog("Verify Delete Account, Contact, Lead, Opportunities", "Result :: " + deleteResults[j].getId(), Status.PASS);
				status = true;
			} else {
				errors = deleteResults[j].getErrors();
				for (int i = 0; i < errors.length; i++) {
					report.updateTestLog("Verify Delete Account, Contact, Lead, Opportunities", "Errors message:::" + errors[i].getMessage(),
							Status.FAIL);
					System.out.println("Error message::" + errors[i].getMessage());
					status = false;
				}
			}
		}
		return status;
	}
}