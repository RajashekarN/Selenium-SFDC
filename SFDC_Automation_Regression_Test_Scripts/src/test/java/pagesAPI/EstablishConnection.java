package pagesAPI;

import com.cognizant.Craft.ReusableLibrary;
import com.cognizant.Craft.ScriptHelper;
import com.cognizant.framework.Status;
import com.sforce.soap.partner.DeleteResult;
import com.sforce.soap.partner.GetUserInfoResult;
import com.sforce.soap.partner.LeadConvertResult;
import com.sforce.soap.partner.PartnerConnection;
import com.sforce.soap.partner.SaveResult;
import com.sforce.soap.partner.SetPasswordResult;
import com.sforce.ws.ConnectionException;
import com.sforce.ws.ConnectorConfig;

public class EstablishConnection extends ReusableLibrary {
	/*
	 * Constructor to initialize the business component library
	 * 
	 * @param scriptHelper The {@link ScriptHelper} object passed from the
	 * {@link DriverScript}
	 */

	public EstablishConnection(ScriptHelper scriptHelper) {
		super(scriptHelper);
	}

	public static PartnerConnection connection = null;
	static SetPasswordResult setPasswordResults =null;
	static ConnectorConfig config;
	static com.sforce.soap.partner.Error[] errors;
	static boolean status = false;
	static String result;

	/**
	 * Function for retrieving the environment
	 * 
	 * @author Vishnuvardhan
	 *
	 */
	public static String environment = System.getProperty("RunEnvironment");

	public String initializeEnvironment() {
		try {
			if (environment.equals(null)) {

			}
		} catch (Exception e) {
			environment = properties.getProperty("RunEnvironment");
			System.out.println(
					"Environment is set as per the RunEnvironment value in Global Settings file:::" + environment);
		}
		return environment;
	}


	/**
	 * Function for establishing the connection
	 * 
	 * @author Vishnuvardhan
	 *
	 */

	public void establishConnection() {
		try {
			String environment = initializeEnvironment();
			System.out.println(environment);
			String Username = null, Password;
			if ((environment.equals("UAT")) || (environment.equals("UAT2")) || (environment.equals("FTE")) || (environment.equals("FTE2"))) {
				if ((dataTable.getData("General_Data", "TC_ID").contains("OBEMEA")) && (dataTable.getData("General_Data", "TC_ID").contains("Broker"))) 
					Username = properties.getProperty("OBEMEABroker")+ "." + environment;
				else if ((dataTable.getData("General_Data", "TC_ID").contains("OBEMEA")) && (dataTable.getData("General_Data", "TC_ID").contains("Manager"))) 
					Username = properties.getProperty("OBEMEAManager")+ "." + environment;
				else if ((dataTable.getData("General_Data", "TC_ID").contains("OBEMEA")) && (dataTable.getData("General_Data", "TC_ID").contains("CSS"))) 
					Username = properties.getProperty("OBEMEACSS")+ "." + environment;	
				else if ((dataTable.getData("General_Data", "TC_ID").contains("CMAPAC")) && (dataTable.getData("General_Data", "TC_ID").contains("Broker"))) 
					Username = properties.getProperty("CMAPACBroker")+ "." + environment;		
				else if ((dataTable.getData("General_Data", "TC_ID").contains("CMAPAC")) && (dataTable.getData("General_Data", "TC_ID").contains("Manager"))) 
					Username = properties.getProperty("CMAPACManager")+ "." + environment;		
				else if ((dataTable.getData("General_Data", "TC_ID").contains("CMAPAC")) && (dataTable.getData("General_Data", "TC_ID").contains("CSS"))) 
					Username = properties.getProperty("CMAPACCSS")+ "." + environment;	
				else if ((dataTable.getData("General_Data", "TC_ID").contains("CMEMEA")) && (dataTable.getData("General_Data", "TC_ID").contains("Broker"))) 
					Username = properties.getProperty("CMEMEABroker")+ "." + environment;		
				else if ((dataTable.getData("General_Data", "TC_ID").contains("CMEMEA")) && (dataTable.getData("General_Data", "TC_ID").contains("Manager"))) 
					Username = properties.getProperty("CMEMEAManager")+ "." + environment;		
				else if ((dataTable.getData("General_Data", "TC_ID").contains("CMEMEA")) && (dataTable.getData("General_Data", "TC_ID").contains("CSS"))) 
					Username = properties.getProperty("CMEMEACSS")+ "." + environment;	
				else if ((dataTable.getData("General_Data", "TC_ID").contains("ABEMEA")) && (dataTable.getData("General_Data", "TC_ID").contains("Broker"))) 
					Username = properties.getProperty("ABEMEABroker")+ "." + environment;	
				else if ((dataTable.getData("General_Data", "TC_ID").contains("ABEMEA")) && (dataTable.getData("General_Data", "TC_ID").contains("Manager"))) 
					Username = properties.getProperty("ABEMEAManager")+ "." + environment;	
				else if ((dataTable.getData("General_Data", "TC_ID").contains("ABEMEA")) && (dataTable.getData("General_Data", "TC_ID").contains("CSS"))) 
					Username = properties.getProperty("ABEMEACSS")+ "." + environment;	
				else if ((dataTable.getData("General_Data", "TC_ID").contains("ABAMER")) && (dataTable.getData("General_Data", "TC_ID").contains("Admin"))) 
					Username = properties.getProperty("SystemAdminUsername")+ "." + environment;	
				else if ((dataTable.getData("General_Data", "TC_ID").contains("ABAMER")) && (dataTable.getData("General_Data", "TC_ID").contains("Broker"))) 
					Username = properties.getProperty("ABAMERBroker")+ "." + environment;	
				else if ((dataTable.getData("General_Data", "TC_ID").contains("ABAMER")) && (dataTable.getData("General_Data", "TC_ID").contains("Manager"))) 
					Username = properties.getProperty("ABAMERManager")+ "." + environment;	
				else if ((dataTable.getData("General_Data", "TC_ID").contains("ABAMER")) && (dataTable.getData("General_Data", "TC_ID").contains("CSS"))) 
					Username = properties.getProperty("ABAMERCSS")+ "." + environment;	
				else if ((dataTable.getData("General_Data", "TC_ID").contains("OBAMER")) && (dataTable.getData("General_Data", "TC_ID").contains("Broker"))) 
					Username = properties.getProperty("OBAMERBroker")+ "." + environment;	
				else if ((dataTable.getData("General_Data", "TC_ID").contains("OBAMER")) && (dataTable.getData("General_Data", "TC_ID").contains("Manager"))) 
					Username = properties.getProperty("OBAMERManager")+ "." + environment;	
				else if ((dataTable.getData("General_Data", "TC_ID").contains("OBAMER")) && (dataTable.getData("General_Data", "TC_ID").contains("CSS"))) 
					Username = properties.getProperty("OBAMERCSS")+ "." + environment;	
				else if ((dataTable.getData("General_Data", "TC_ID").contains("OBAMER")) && (dataTable.getData("General_Data", "TC_ID").contains("Admin"))) 
					Username = properties.getProperty("SystemAdminUsername")+ "." + environment;	
				else if ((dataTable.getData("General_Data", "TC_ID").contains("OBAPAC")) && (dataTable.getData("General_Data", "TC_ID").contains("Broker"))) 
					Username = properties.getProperty("OBAPACBroker")+ "." + environment;
				else if ((dataTable.getData("General_Data", "TC_ID").contains("OBAPAC")) && (dataTable.getData("General_Data", "TC_ID").contains("Manager"))) 
					Username = properties.getProperty("OBAPACManager")+ "." + environment;
				else if ((dataTable.getData("General_Data", "TC_ID").contains("OBAPAC")) && (dataTable.getData("General_Data", "TC_ID").contains("CSS"))) 
					Username = properties.getProperty("OBAPACCSS")+ "." + environment;
				else if ((dataTable.getData("General_Data", "TC_ID").contains("CMAMER")) && (dataTable.getData("General_Data", "TC_ID").contains("Broker"))) 
					Username = properties.getProperty("CMAMERBroker")+ "." + environment;	
				else if ((dataTable.getData("General_Data", "TC_ID").contains("CMAMER")) && (dataTable.getData("General_Data", "TC_ID").contains("Manager"))) 
					Username = properties.getProperty("CMAMERManager")+ "." + environment;	
				else if ((dataTable.getData("General_Data", "TC_ID").contains("CMAMER")) && (dataTable.getData("General_Data", "TC_ID").contains("CSS"))) 
					Username = properties.getProperty("CMAMERCSS")+ "." + environment;		
				else if ((dataTable.getData("General_Data", "TC_ID").contains("CMEMEA")) && (dataTable.getData("General_Data", "TC_ID").contains("Broker"))) 
					Username = properties.getProperty("CMEMEABroker")+ "." + environment;	
				else if ((dataTable.getData("General_Data", "TC_ID").contains("CMEMEA")) && (dataTable.getData("General_Data", "TC_ID").contains("Manager"))) 
					Username = properties.getProperty("CMEMEAManager")+ "." + environment;	
				else if ((dataTable.getData("General_Data", "TC_ID").contains("CMEMEA")) && (dataTable.getData("General_Data", "TC_ID").contains("CSS"))) 
					Username = properties.getProperty("CMEMEACSS")+ "." + environment;		
				else if ((dataTable.getData("General_Data", "TC_ID").contains("ASAPAC")) && (dataTable.getData("General_Data", "TC_ID").contains("Broker"))) 
					Username = properties.getProperty("ASAPACBroker")+ "." + environment;	
				else if ((dataTable.getData("General_Data", "TC_ID").contains("ASAPAC")) && (dataTable.getData("General_Data", "TC_ID").contains("Manager"))) 
					Username = properties.getProperty("ASAPACManager")+ "." + environment;		
				else if ((dataTable.getData("General_Data", "TC_ID").contains("ASAPAC")) && (dataTable.getData("General_Data", "TC_ID").contains("CSS"))) 
					Username = properties.getProperty("ASAPACCSS")+ "." + environment;		
				else if ((dataTable.getData("General_Data", "TC_ID").contains("GWSAPAC")) && (dataTable.getData("General_Data", "TC_ID").contains("Broker"))) 
					Username = properties.getProperty("GWSAPACBroker")+ "." + environment;	
				else if ((dataTable.getData("General_Data", "TC_ID").contains("GWSAPAC")) && (dataTable.getData("General_Data", "TC_ID").contains("Manager"))) 
					Username = properties.getProperty("GWSAPACManager")+ "." + environment;		
				else if ((dataTable.getData("General_Data", "TC_ID").contains("GWSAPAC")) && (dataTable.getData("General_Data", "TC_ID").contains("CSS"))) 
					Username = properties.getProperty("GWSAPACCSS")+ "." + environment;	
				else if ((dataTable.getData("General_Data", "TC_ID").contains("GWSEMEA")) && (dataTable.getData("General_Data", "TC_ID").contains("Broker"))) 
					Username = properties.getProperty("GWSEMEABroker")+ "." + environment;	
				else if ((dataTable.getData("General_Data", "TC_ID").contains("GWSEMEA")) && (dataTable.getData("General_Data", "TC_ID").contains("Manager"))) 
					Username = properties.getProperty("GWSEMEAManager")+ "." + environment;		
				else if ((dataTable.getData("General_Data", "TC_ID").contains("GWSEMEA")) && (dataTable.getData("General_Data", "TC_ID").contains("CSS"))) 
					Username = properties.getProperty("GWSEMEACSS")+ "." + environment;
				else if ((dataTable.getData("General_Data", "TC_ID").contains("VASAMER")) && (dataTable.getData("General_Data", "TC_ID").contains("Broker"))) 
					Username = properties.getProperty("VASAMERBroker")+ "." + environment;	
				else if ((dataTable.getData("General_Data", "TC_ID").contains("VASAMER")) && (dataTable.getData("General_Data", "TC_ID").contains("Manager"))) 
					Username = properties.getProperty("VASAMERManager")+ "." + environment;		
				else if ((dataTable.getData("General_Data", "TC_ID").contains("VASAMER")) && (dataTable.getData("General_Data", "TC_ID").contains("CSS"))) 
					Username = properties.getProperty("VASAMERCSS")+ "." + environment;
				else if ((dataTable.getData("General_Data", "TC_ID").contains("VASEMEA")) && (dataTable.getData("General_Data", "TC_ID").contains("Broker"))) 
					Username = properties.getProperty("VASEMEABroker")+ "." + environment;	
				else if ((dataTable.getData("General_Data", "TC_ID").contains("VASEMEA")) && (dataTable.getData("General_Data", "TC_ID").contains("Manager"))) 
					Username = properties.getProperty("VASEMEAManager")+ "." + environment;		
				else if ((dataTable.getData("General_Data", "TC_ID").contains("VASEMEA")) && (dataTable.getData("General_Data", "TC_ID").contains("CSS"))) 
					Username = properties.getProperty("VASEMEACSS")+ "." + environment;
				else if ((dataTable.getData("General_Data", "TC_ID").contains("FRANEMEA")) && (dataTable.getData("General_Data", "TC_ID").contains("Manager"))) 
					Username = properties.getProperty("FRANEMEAManager")+ "." + environment;	
				else if ((dataTable.getData("General_Data", "TC_ID").contains("FDIGEMEA")) && (dataTable.getData("General_Data", "TC_ID").contains("Manager"))) 
					Username = properties.getProperty("FDIGEMEAManager")+ "." + environment;	
				else if ((dataTable.getData("General_Data", "TC_ID").contains("FDIREMEA")) && (dataTable.getData("General_Data", "TC_ID").contains("Manager"))) 
					Username = properties.getProperty("FDIREMEAManager")+ "." + environment;	
				else if ((dataTable.getData("General_Data", "TC_ID").contains("FDIGEMEA")) && (dataTable.getData("General_Data", "TC_ID").contains("Data"))) 
					Username = properties.getProperty("FDIGEMEAData")+ "." + environment;
				else if ((dataTable.getData("General_Data", "TC_ID").contains("DAASIA")) && (dataTable.getData("General_Data", "TC_ID").contains("Data"))) 
					Username = properties.getProperty("DAASIAData")+ "." + environment;	
				else if ((dataTable.getData("General_Data", "TC_ID").contains("DAPACI")) && (dataTable.getData("General_Data", "TC_ID").contains("Data"))) 
					Username = properties.getProperty("DAPACIData")+ "." + environment;	
				else if (dataTable.getData("General_Data", "TC_ID").contains("Admin")) 
					Username = properties.getProperty("SystemAdminUsername")+ "." + environment;
			}	

			if (environment.equals("UAT")) { 			
				Password = properties.getProperty("UATPassword");
				String UAT_AuthEndpoint = properties.getProperty("UATAuthEndpoint");
				config = new ConnectorConfig();
				config.setUsername(Username);
				config.setPassword(Password);
				System.out.println("AuthEndPoint: " + UAT_AuthEndpoint);
				config.setAuthEndpoint(UAT_AuthEndpoint);
				connection = new PartnerConnection(config);
				System.out.println(connection);
			} else if (environment.equals("UAT2")) {				
				Password = properties.getProperty("UAT2Password");
				String UAT2_AuthEndpoint = properties.getProperty("UAT2AuthEndpoint");
				config = new ConnectorConfig();
				config.setUsername(Username);
				config.setPassword(Password);
				System.out.println("AuthEndPoint: " + UAT2_AuthEndpoint);
				config.setAuthEndpoint(UAT2_AuthEndpoint);
				connection = new PartnerConnection(config);
			} else if (environment.equals("FTE")) {				
				Password = properties.getProperty("FTEPassword");
				String FTE_AuthEndpoint = properties.getProperty("FTEAuthEndpoint");
				config = new ConnectorConfig();
				config.setUsername(Username);
				config.setPassword(Password);
				System.out.println("AuthEndPoint: " + FTE_AuthEndpoint);
				config.setAuthEndpoint(FTE_AuthEndpoint);
				connection = new PartnerConnection(config);
			} else if (environment.equals("FTE2")) {				
				Password = properties.getProperty("FTE2Password");
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

	public void establishConnectionAdminLogin() {
		try {
			String environment = initializeEnvironment();
			System.out.println(environment);
			String Username = null, Password;
			if ((environment.equals("UAT")) || (environment.equals("UAT2")) || (environment.equals("FTE")) || (environment.equals("FTE2"))) {
				Username = properties.getProperty("SystemAdminUsername")+ "." + environment;
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
				} else if(result.startsWith("002")) {
					query = "Select Title from Note where Id = " + "'" + result + "'";
				} else if(result.startsWith("00P")) {
					query = "Select Title from Attachment where Id = " + "'" + result + "'";
				} else if(result.startsWith("00Q")) {
					query = "Select Id from Lead where Id = " + "'" + result + "'";
				} else if(result.startsWith("005")) {
					query = "Select Id from User where Id = " + "'" + result + "'";
				} else if(result.startsWith("00U")) {
					query = "Select Id from Event where Id = " + "'" + result + "'";
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
	 * Function for saving the lead conversion results
	 * 
	 * @author Vishnuvardhan
	 *
	 */

	public String leadConvertResults(LeadConvertResult[] Results) {
		LeadConvertResult[] results = Results;
		String sAccountID =null, sContactID =null, sOpportunityID =null, sLeadID =null;
		String sIDs = null;
		System.out.println("Results:::" + results);
		for (int j = 0; j < results.length; j++) {
			if (results[j].isSuccess()) {
				sAccountID = results[j].getAccountId();
				sContactID = results[j].getContactId();
				sOpportunityID = results[j].getOpportunityId();
				sLeadID = results[j].getLeadId();
				sIDs = sAccountID + "_" + sContactID + "_" + sOpportunityID + "_" + sLeadID;
				System.out.println("Account ID :::" + sAccountID);
				System.out.println("Contact ID:::" + sContactID);
				System.out.println("Opportunity ID:::" + sOpportunityID);
				System.out.println("Lead ID:::" + sLeadID);
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
		return sIDs;
	}
	/**
	 * Function for the getting the Id from results array
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
	 * Function for deleting the results
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