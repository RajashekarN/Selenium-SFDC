package pagesAPI;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.support.PageFactory;

import com.cognizant.Craft.ReusableLibrary;
import com.cognizant.Craft.ScriptHelper;
import com.cognizant.framework.Status;
import com.sforce.soap.partner.DeleteResult;
import com.sforce.soap.partner.DescribeLayout;
import com.sforce.soap.partner.DescribeLayoutItem;
import com.sforce.soap.partner.DescribeLayoutResult;
import com.sforce.soap.partner.DescribeLayoutRow;
import com.sforce.soap.partner.DescribeLayoutSection;
import com.sforce.soap.partner.QueryResult;
import com.sforce.soap.partner.SaveResult;
import com.sforce.soap.partner.SearchRecord;
import com.sforce.soap.partner.SearchResult;
import com.sforce.soap.partner.sobject.SObject;
import com.sforce.ws.ConnectionException;

import supportLibraries.Utility_Functions;

public class AccountsFunctions extends ReusableLibrary {
	/*
	 * Constructor to initialize the business component library
	 * 
	 * @param scriptHelper The {@link ScriptHelper} object passed from the
	 * {@link DriverScript}
	 */

	public AccountsFunctions(ScriptHelper scriptHelper) {
		super(scriptHelper);
		PageFactory.initElements(driver.getWebDriver(), this);
		// new WebDriverUtil(driver);
		// Utility_Functions utility = new Utility_Functions(scriptHelper);
	}

	static SaveResult[] results;
	static DeleteResult[] deleteResults;
	static com.sforce.soap.partner.Error[] errors;
	static boolean status = false;
	
	EstablishConnection establishConnection = new EstablishConnection(scriptHelper);
	
	/**
	 * Function for the creation of an Account
	 * 
	 * @author Vishnuvardhan
	 *
	 */
	public SaveResult[] createAccount() {
		try {
			
/*			ActivityFunctions activityFunctions = new ActivityFunctions(scriptHelper);
			activityFunctions.createActivity();
			CreateUsers createuser = new CreateUsers(scriptHelper);
			createuser.setPasswordUsersList();
			String randomString = Utility_Functions.xGenerateString(20);
			System.out.println(randomString);
			CreateUsers createuser = new CreateUsers(scriptHelper);
			createuser.createUsers();
			//createuser.resetPassword("0050m000000N8r5AAC");
			//createuser.setPassword("0050m000000N8r5AAC", "Password8910");
*/			
		/*	readMultipleRowsContacts("Luis Cole%");*/
			
			establishConnection.establishConnection();
			SObject account = new SObject();

			account.setType("Account");
			String accountName = Utility_Functions.xRandomFunction() + "-" + dataTable.getData("General_Data", "Name");
			account.setField("Name", accountName);
			account.setField("BillingCountry", dataTable.getData("General_Data", "BillingCountry"));
			account.setField("BillingStreet", dataTable.getData("General_Data", "BillingStreet"));
			account.setField("BillingCity", dataTable.getData("General_Data", "BillingCity"));
			account.setField("BillingState", dataTable.getData("General_Data", "BillingState"));
			account.setField("BillingPostalCode ", dataTable.getData("General_Data", "BillingZipcode"));

			SObject[] accounts = new SObject[1];
			accounts[0] = account;
			results = EstablishConnection.connection.create(accounts);
			System.out.println("Result:::" + results);
			status = establishConnection.saveResults(results);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return results;
	}

	/**
	 * Function for updating the Account
	 * 
	 * @author Vishnuvardhan
	 *
	 */

	public boolean updateAccounts() {
		try {
			establishConnection.establishConnection();
			SObject[] records = new SObject[1];
			QueryResult queryResults = EstablishConnection.connection.query("SELECT Id, Name FROM Account ORDER BY CreatedDate DESC LIMIT 1");
			if (queryResults.getSize() > 0) {
				for (int i = 0; i < queryResults.getRecords().length; i++) {
					SObject so = (SObject) queryResults.getRecords()[i];
					SObject soUpdate = new SObject();
					soUpdate.setType("Account");
					soUpdate.setId(so.getId());
					// soUpdate.setField("Name",
					// dataTable.getData("General_Data", "Name") + "--
					// Updated");
					soUpdate.setField("Name", so.getField("Name") + " -- UPDATED");
					records[i] = soUpdate;
				}
			}
			results = EstablishConnection.connection.update(records);
			System.out.println("Result:::" + results);
			status = establishConnection.saveResults(results);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return status;
	}

	/**
	 * Function for deleting the Account
	 * 
	 * @author Vishnuvardhan
	 *
	 */

	public boolean deleteAccounts() {
		try {
			establishConnection.establishConnection();
			String[] records = new String[1];
			QueryResult queryResults = EstablishConnection.connection
					.query("SELECT Id, Name FROM Account ORDER BY CreatedDate DESC LIMIT 1");
			if (queryResults.getSize() > 0) {
				for (int i = 0; i < queryResults.getRecords().length; i++) {
					SObject so = (SObject) queryResults.getRecords()[i];
					records[i] = so.getId();
					System.out.println("Deleting Id: " + so.getId() + " - Name: " + so.getField("Name"));
					report.updateTestLog("Verify Delete Account", "Account has been deleted successfully:::"
							+ "Deleting Id: " + so.getId() + " - Name: " + so.getField("Name"), Status.PASS);
				}
			}
			deleteResults = EstablishConnection.connection.delete(records);
			System.out.println("Result:::" + deleteResults);
			status = establishConnection.deleteResults(deleteResults);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return status;
	}

	/**
	 * Function for reading multiple rows from SOQL search
	 * 
	 * @author Vishnuvardhan
	 *
	 */
	
	public void readMultipleRowsAccounts(String name) {
	
		try {
			establishConnection.establishConnection();
			String soslQuery = "FIND {" + name + "} IN Name FIELDS RETURNING Account(Id, Name)";	
			SearchResult sResult;
			sResult = EstablishConnection.connection.search(soslQuery);
			SearchRecord[] records = sResult.getSearchRecords();
			List<SObject> accounts = new ArrayList<SObject>();

			if (records != null && records.length > 0) {
				for (int i = 0; i < records.length; i++) {
					SObject record = records[i].getRecord();
					if (record.getType().toLowerCase().equals("account")) {
						accounts.add(record);
					}
				}
				if (accounts.size() > 0) {
					System.out.println("Found " + accounts.size() + " account(s):");
					for (SObject account : accounts) {
						System.out.println(
								account.getId() + " - " + account.getField("Name"));
					}
				}
			}
			updateMultipleAccounts(accounts);
		} catch (ConnectionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	/**
	 * Function for reading multiple rows from SOQL search
	 * 
	 * @author Vishnuvardhan
	 *
	 */
	
	public void readMultipleRowsContacts(String name) {
	
		try {
			establishConnection.establishConnection();
			String soslQuery = "FIND {" + name + "} IN Name FIELDS RETURNING Contact(Id, Name)";	
			SearchResult sResult;
			sResult = EstablishConnection.connection.search(soslQuery);
			SearchRecord[] records = sResult.getSearchRecords();
			List<SObject> contacts = new ArrayList<SObject>();

			if (records != null && records.length > 0) {
				for (int i = 0; i < records.length; i++) {
					SObject record = records[i].getRecord();
					if (record.getType().toLowerCase().equals("contact")) {
						contacts.add(record);
					}
				}
				if (contacts.size() > 0) {
					System.out.println("Found " + contacts.size() + " contact(s):");
					for (SObject account : contacts) {
						System.out.println(
								account.getId() + " - " + account.getField("Name"));
					}
				}
			}
			updateMultipleContacts(contacts);
		} catch (ConnectionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	public boolean updateMultipleAccounts(List<SObject> accounts) {
		try {
			establishConnection.establishConnection();
			SObject[] records = new SObject[1];
			//QueryResult queryResults = EstablishConnection.connection.query("SELECT Id, Name FROM Account ORDER BY CreatedDate DESC LIMIT 1");
			if (((List<SObject>) accounts).size() > 0) {
				for (int i = 0; i < ((List<SObject>) accounts).size(); i++) {
					for(SObject account: accounts) {
						SObject so = (SObject) account;
						SObject soUpdate = new SObject();
						soUpdate.setType("Account");
						soUpdate.setId(so.getId());
						String accountName = Utility_Functions.xGenerateAlphaNumericString();
						soUpdate.setField("Name", accountName + so.getField("Name") );
						records[i] = soUpdate;
						System.out.println("Test Account Name Updated to::" + records[i].getField("Name"));
						results = EstablishConnection.connection.update(records);
					}					
				}
			}
			System.out.println("Result:::" + results);
			status = establishConnection.saveResults(results);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return status;
	}
	
	public boolean updateMultipleContacts(List<SObject> contacts) {
		try {
			establishConnection.establishConnection();
			SObject[] records = new SObject[1];
			//QueryResult queryResults = EstablishConnection.connection.query("SELECT Id, Name FROM Account ORDER BY CreatedDate DESC LIMIT 1");
			if (((List<SObject>) contacts).size() > 0) {
				for (int i = 0; i < ((List<SObject>) contacts).size(); i++) {
					for(SObject contact: contacts) {
						SObject so = (SObject) contact;
						SObject soUpdate = new SObject();
						soUpdate.setType("Contact");
						soUpdate.setId(so.getId());
						String contactName = Utility_Functions.xGenerateAlphaNumericString();
						soUpdate.setField("Name", contactName + so.getField("Name") );
						records[i] = soUpdate;
						System.out.println("Test Contact Name Updated to::" + records[i].getField("Name"));
						results = EstablishConnection.connection.update(records);
					}					
				}
			}
			System.out.println("Result:::" + results);
			status = establishConnection.saveResults(results);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return status;
	}
	
	/**
	 * Function for the searching the Phone Number
	 * 
	 * @author Vishnuvardhan
	 *
	 */

	public boolean searchPhonenumber(String phoneNumber) {
		try {
			establishConnection.establishConnection();
			String soslQuery = "FIND {" + phoneNumber
					+ "} IN Phone FIELDS RETURNING Contact(Id, Phone, FirstName, LastName), Lead(Id, Phone, FirstName, LastName), Account(Id, Phone, Name)";
			SearchResult sResult = EstablishConnection.connection.search(soslQuery);
			SearchRecord[] records = sResult.getSearchRecords();
			List<SObject> contacts = new ArrayList<SObject>();
			List<SObject> leads = new ArrayList<SObject>();
			List<SObject> accounts = new ArrayList<SObject>();

			if (records != null && records.length > 0) {
				for (int i = 0; i < records.length; i++) {
					SObject record = records[i].getRecord();
					if (record.getType().toLowerCase().equals("contact")) {
						contacts.add(record);
					} else if (record.getType().toLowerCase().equals("lead")) {
						leads.add(record);
					} else if (record.getType().toLowerCase().equals("account")) {
						accounts.add(record);
					}
				}
				// Display the contacts that the search returned
				if (contacts.size() > 0) {
					System.out.println("Found " + contacts.size() + " contact(s):");
					for (SObject contact : contacts) {
						System.out.println(contact.getId() + " - " + contact.getField("FirstName") + " "
								+ contact.getField("LastName") + " - " + contact.getField("Phone"));
						report.updateTestLog("Verify Search Phone Number",
								contact.getId() + " - " + contact.getField("FirstName") + " "
										+ contact.getField("LastName") + " - " + contact.getField("Phone"),
								Status.PASS);
					}
				}
				// Display the leads that the search returned
				if (leads.size() > 0) {
					System.out.println("Found " + leads.size() + " lead(s):");
					for (SObject lead : leads) {
						System.out.println(lead.getId() + " - " + lead.getField("FirstName") + " "
								+ lead.getField("LastName") + " - " + lead.getField("Phone"));
						report.updateTestLog("Verify Search Phone Number",
								lead.getId() + " - " + lead.getField("FirstName") + " " + lead.getField("LastName")
										+ " - " + lead.getField("Phone"),
								Status.PASS);
					}
				}
				// Display the accounts that the search returned
				if (accounts.size() > 0) {
					System.out.println("Found " + accounts.size() + " account(s):");
					for (SObject account : accounts) {
						System.out.println(
								account.getId() + " - " + account.getField("Name") + " - " + account.getField("Phone"));
						report.updateTestLog("Verify Search Phone Number",
								account.getId() + " - " + account.getField("Name") + " - " + account.getField("Phone"),
								Status.PASS);
					}
				}
				status = true;
			} else {
				// The search returned no records
				System.out.println("No records were found for the search.");
				status = false;
			}
		} catch (ConnectionException ce) {
			ce.printStackTrace();
		}
		return status;
	}

	/*
	*//**
	 * Function for the saving the results
	 * 
	 * @author Vishnuvardhan
	 *
	 *//*

	public boolean saveResults() {
		System.out.println("Results:::" + results);
		for (int j = 0; j < results.length; j++) {
			if (results[j].isSuccess()) {
				result = results[j].getId();
				System.out.println("Save Results:::" + result);
				report.updateTestLog("Verify Create/ Update Account", "Result :: " + result, Status.PASS);
				status = true;
			} else {
				for (int i = 0; i < results[j].getErrors().length; i++) {
					com.sforce.soap.partner.Error err = results[j].getErrors()[i];
					report.updateTestLog("Verify Create/ Update Account", "Errors were found on item:::" + j,
							Status.FAIL);
					report.updateTestLog("Verify Create/ Update Account",
							"Errors code:::" + err.getStatusCode().toString(), Status.FAIL);
					report.updateTestLog("Verify Create/ Update Account", "Errors message:::" + err.getMessage(),
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

	*//**
	 * Function for saving the delete results
	 * 
	 * @author Vishnuvardhan
	 *
	 *//*

	public boolean deleteResults() {
		System.out.println("Results:::" + deleteResults);
		for (int j = 0; j < deleteResults.length; j++) {
			if (deleteResults[j].isSuccess()) {
				deleteResults[j].getId();
				System.out.println("Delete Results:::" + deleteResults[j].getId());
				report.updateTestLog("Verify Delete Account", "Result :: " + deleteResults[j].getId(), Status.PASS);
				status = true;
			} else {
				errors = deleteResults[j].getErrors();
				for (int i = 0; i < errors.length; i++) {
					report.updateTestLog("Verify Delete Account", "Errors message:::" + errors[i].getMessage(),
							Status.FAIL);
					System.out.println("Error message::" + errors[i].getMessage());
					status = false;
				}
			}
		}
		return status;
	}
	*/
	
	
	static ArrayList<String> OBEMEAHeader = new ArrayList<String>();
	
	public void OBEMEAHeadings() {
		OBEMEAHeader.add("Account Information");
		OBEMEAHeader.add("Address Information");
		OBEMEAHeader.add("Datahug Details");
		OBEMEAHeader.add("Additional Information");
		OBEMEAHeader.add("System Information");
		System.out.println("OBEMEA Headers List are::" + OBEMEAHeader);
	}
	
	static ArrayList<String> CMAPACHeader = new ArrayList<String>();
	
	public void CMAPACHeaders() {
		CMAPACHeader.add("Account Details");
		CMAPACHeader.add("Address Information");
		CMAPACHeader.add("Segmentation");
		CMAPACHeader.add("Additional Information");
		CMAPACHeader.add("System Information");
		System.out.println("CMAPAC Headers List are::" + CMAPACHeader);
	}
	
	static ArrayList<String> CMAMERHeader = new ArrayList<String>();
	
	public void CMAMERHeaders() {
		CMAMERHeader.add("Account Information");
		CMAMERHeader.add("Account Segmentation");
		CMAMERHeader.add("Address Information");
		CMAMERHeader.add("Local Address Information");
		CMAMERHeader.add("Additional Information");
		CMAMERHeader.add("SIC/NAICS Codes");
		CMAMERHeader.add("Description Information");
		CMAMERHeader.add("System Information");
		System.out.println("CMAMER Headers List are::" + CMAMERHeader);
	}
	
	static ArrayList<String> ABEMEAHeader = new ArrayList<String>();
	
	public void ABEMEAHeaders() {
		ABEMEAHeader.add("Account Information");
		ABEMEAHeader.add("Address Information");
		ABEMEAHeader.add("Datahug Details");
		ABEMEAHeader.add("Additional Information");
		ABEMEAHeader.add("System Information");
		System.out.println("ABEMEA Headers List are::" + ABEMEAHeader);
	}
	
	static ArrayList<String> ABAMERHeader = new ArrayList<String>();
	
	public void ABAMERHeaders() {
		ABAMERHeader.add("Account Information");
		ABAMERHeader.add("Account Segmentation");
		ABAMERHeader.add("Address Information");
		ABAMERHeader.add("Local Address Information");
		ABAMERHeader.add("Additional Information");
		ABAMERHeader.add("SIC/NAICS Codes");
		ABAMERHeader.add("Description Information");
		ABAMERHeader.add("System Information");
		System.out.println("ABEMEA Headers List are::" + ABAMERHeader);
	}

	static ArrayList<String> AdminHeader = new ArrayList<String>();
	
	public void AdminHeaders() {
		AdminHeader.add("Tagging");
		AdminHeader.add("Account Information");
		AdminHeader.add("Account Segmentation");
		AdminHeader.add("Address Information");
		AdminHeader.add("Local Address Information");
		AdminHeader.add("Additional Information");
		AdminHeader.add("SIC/NAICS Codes");
		AdminHeader.add("Description Information");
		AdminHeader.add("APAC Fields");
		AdminHeader.add("EMEA Fields");
		AdminHeader.add("France Fields");
		AdminHeader.add("Rollup Summary Fields");
		AdminHeader.add("System Information");
		System.out.println("ABEMEA Headers List are::" + ABAMERHeader);
	}
	
	static ArrayList<String> OBEMEAField = new ArrayList<String>();
	
	public void OBEMEAFields() {
		OBEMEAField.add("Name");
		OBEMEAField.add("Phone");
		OBEMEAField.add("Tradestyle_Name__c");
		OBEMEAField.add("Fax");
		OBEMEAField.add("EMEA_Reporting_Account__c");
		OBEMEAField.add("EMEA_Key_Account__c");
		OBEMEAField.add("EMEA_Client_Knowledge_Centre__c");
		OBEMEAField.add("BillingAddress");
		OBEMEAField.add("ShippingAddress");
		OBEMEAField.add("datahugapps__HugRank__c");
		OBEMEAField.add("datahugapps__NextMeeting__c");
		OBEMEAField.add("datahugapps__NOM__c");
		OBEMEAField.add("datahugapps__LM__c");
		OBEMEAField.add("Website");
		OBEMEAField.add("EMEA_Industry__c");
		OBEMEAField.add("EMEA_Flagged_for_Deletion__c");
		OBEMEAField.add("OwnerId");
		OBEMEAField.add("EMEA_Verified__c");
		OBEMEAField.add("Last_Manually_Modified_Date__c");
		OBEMEAField.add("RecordTypeId");
		OBEMEAField.add("Last_Manually_Modified_By__c");
		System.out.println("Occupier Brokerage EMEA Fields List are::" + OBEMEAField);		
	}
	
	static ArrayList<String> CMAPACField = new ArrayList<String>();
	
	public void CMAPACFields() {
		CMAPACField.add("Name");
		CMAPACField.add("Local_Account_Name__c");
		CMAPACField.add("Client_Type__c");
		CMAPACField.add("Phone");
		CMAPACField.add("Website ");
		CMAPACField.add("BillingAddress");
		CMAPACField.add("Local_Billing_Street__c");
		CMAPACField.add("Local_Billing_City__c");
		CMAPACField.add("Local_Billing_State_Province__c");
		CMAPACField.add("Local_Billing_Zip_Postal_Code__c");
		CMAPACField.add("Local_Billing_Country__c");
		CMAPACField.add("APAC_Industry_Type__c");
		CMAPACField.add("APAC_Strategic_Client__c");
		CMAPACField.add("APAC_Sub_Industry__c");
		CMAPACField.add("Legal_Status__c");
		CMAPACField.add("AccountSource");
		CMAPACField.add("Tradestyle_Name__c");
		CMAPACField.add("Description");
		CMAPACField.add("Last_Manually_Modified_Date__c");
		CMAPACField.add("Site");
		CMAPACField.add("Last_Manually_Modified_By__c");
		CMAPACField.add("Type");
		CMAPACField.add("Status__c");
		CMAPACField.add("Parent_Account__c");
		CMAPACField.add("InSituCah__Ultimate_Parent__c");
		CMAPACField.add("Domestic_Ultimate__c");
		CMAPACField.add("Global_Ultimate__c");
		System.out.println("Capital Markets APAC Fields List are::" + CMAPACField);
	}
	
	static ArrayList<String> ABEMEAField = new ArrayList<String>();
	
	public void ABEMEAFields() {
		ABEMEAField.add("Name");
		ABEMEAField.add("Phone");
		ABEMEAField.add("Tradestyle_Name__c");
		ABEMEAField.add("Fax");
		ABEMEAField.add("EMEA_Reporting_Account__c");
		ABEMEAField.add("EMEA_Key_Account__c");
		ABEMEAField.add("EMEA_Client_Knowledge_Centre__c");
		ABEMEAField.add("BillingAddress");
		ABEMEAField.add("ShippingAddress");
		ABEMEAField.add("datahugapps__HugRank__c");
		ABEMEAField.add("datahugapps__NextMeeting__c");
		ABEMEAField.add("datahugapps__NOM__c");
		ABEMEAField.add("datahugapps__LM__c");
		ABEMEAField.add("Website");
		ABEMEAField.add("EMEA_Industry__c");
		ABEMEAField.add("EMEA_Flagged_for_Deletion__c");
		ABEMEAField.add("OwnerId");
		ABEMEAField.add("EMEA_Verified__c");
		ABEMEAField.add("Last_Manually_Modified_Date__c");
		ABEMEAField.add("RecordTypeId");
		ABEMEAField.add("Last_Manually_Modified_By__c");
		System.out.println("Occupier Brokerage EMEA Fields List are::" + ABEMEAField);		
	}
	
static ArrayList<String> ABAMERField = new ArrayList<String>();
	
	public void ABAMERFields() {
		ABAMERField.add("Name");
		ABAMERField.add("Original_Account_Name__c");
		ABAMERField.add("Site");
		ABAMERField.add("Local_Account_Name__c");
		ABAMERField.add("Tradestyle_Name__c");
		ABAMERField.add("Phone");
		ABAMERField.add("Legal_Status__c");
		ABAMERField.add("Fax");
		ABAMERField.add("Migrated_Account__c");
		ABAMERField.add("Website ");
		ABAMERField.add("Domestic_Ultimate__c");
		ABAMERField.add("Global_Ultimate__c");
		ABAMERField.add("Client_Type__c");
		ABAMERField.add("Key_Client_Account_for__c");
		ABAMERField.add("Client_Type_Rollup__c");
		ABAMERField.add("Key_Pursuit_Account_for__c");
		ABAMERField.add("BillingAddress");
		ABAMERField.add("ShippingAddress");
		ABAMERField.add("Local_Billing_Country__c");
		ABAMERField.add("Local_Shipping_Country__c");
		ABAMERField.add("Local_Billing_Street__c");
		ABAMERField.add("Local_Shipping_Street__c");
		ABAMERField.add("Local_Billing_City__c");
		ABAMERField.add("Local_Shipping_City__c ");
		ABAMERField.add("Local_Billing_State_Province__c");
		ABAMERField.add("Local_Shipping_State_Province__c");
		ABAMERField.add("Local_Billing_Zip_Postal_Code__c");
		ABAMERField.add("Local_Shipping_Zip_Postal_Code__c");
		ABAMERField.add("Industry");
		ABAMERField.add("Type");
		ABAMERField.add("NumberOfEmployees");
		ABAMERField.add("Marketability__c");
		ABAMERField.add("Investor_Profile__c");
		ABAMERField.add("AccountSource");
		ABAMERField.add("Lender_Type__c");
		ABAMERField.add("TickerSymbol");		
		ABAMERField.add("AnnualRevenue");
		ABAMERField.add("D_U_N_S__c");
		ABAMERField.add("CurrencyIsoCode");
		ABAMERField.add("Previous_D_U_N_S__c");		
		ABAMERField.add("Tax_Label_1__c");		
		ABAMERField.add("Status__c");		
		ABAMERField.add("Reason_for_Inactivating__c");
		ABAMERField.add("Tax_Code_1__c");
		ABAMERField.add("Verified_Date__c");
		ABAMERField.add("Inactivation_Date__c");
		ABAMERField.add("NAICS_Code__c");
		ABAMERField.add("NAICS_Code_Description__c");
		ABAMERField.add("SIC_Code_1__c");
		ABAMERField.add("SIC_Code_1_Description__c");
		ABAMERField.add("SIC_Code_2__c");
		ABAMERField.add("SIC_Code_2_Description__c");
		ABAMERField.add("SIC_Code_3__c");
		ABAMERField.add("SIC_Code_3_Description__c");
		ABAMERField.add("SIC_Code_4__c");
		ABAMERField.add("SIC_Code_4_Description__c");
		ABAMERField.add("SIC_Code_5__c");
		ABAMERField.add("SIC_Code_5_Description__c");
		ABAMERField.add("SIC_Code_6__c");
		ABAMERField.add("SIC_Code_6_Description__c");
		ABAMERField.add("Description");		
		ABAMERField.add("OwnerId");
		ABAMERField.add("RecordTypeId");
		ABAMERField.add("Last_Manually_Modified_Date__c");		
		ABAMERField.add("Last_Manually_Modified_By__c");
		
		System.out.println("Agency Brokerage EMEA Fields List are::" + ABAMERField);		
	}
	
	static ArrayList<String> AdminField = new ArrayList<String>();

	public void AdminFields() {
		AdminField.add("France_Client_Type__c");
		AdminField.add("Name");
		AdminField.add("Original_Account_Name__c");
		AdminField.add("Site");
		AdminField.add("Local_Account_Name__c");
		AdminField.add("Tradestyle_Name__c");
		AdminField.add("Phone");
		AdminField.add("Legal_Status__c");
		AdminField.add("Fax");
		AdminField.add("D_B_Shell_Account__c");
		AdminField.add("Website");
		AdminField.add("Migrated_Account__c");
		AdminField.add("Domestic_Ultimate__c");
		AdminField.add("Client_Type_Rollup__c");
		AdminField.add("Global_Ultimate__c");
		AdminField.add("Parent_Account__c");
		AdminField.add("EMEA_Last_Contact_Update__c");
		AdminField.add("Competitor__c");
		AdminField.add("Client_Type__c");
		AdminField.add("Key_Client_Account_for__c");
		AdminField.add("Investor_Services_Account__c");
		AdminField.add("Key_Pursuit_Account_for__c");
		AdminField.add("Investor_Services_Reports_To__c");
		AdminField.add("APAC_Strategic_Client__c");
		AdminField.add("BillingAddress");
		AdminField.add("ShippingAddress");
		AdminField.add("Local_Billing_Country__c");
		AdminField.add("Local_Shipping_Country__c");
		AdminField.add("Local_Billing_Street__c");
		AdminField.add("Local_Shipping_Street__c");
		AdminField.add("Local_Billing_City__c");
		AdminField.add("Local_Shipping_City__c");
		AdminField.add("Local_Billing_State_Province__c");
		AdminField.add("Local_Shipping_State_Province__c");
		AdminField.add("Local_Billing_Zip_Postal_Code__c");
		AdminField.add("Local_Shipping_Zip_Postal_Code__c");
		AdminField.add("Industry");
		AdminField.add("Type");
		AdminField.add("Number_of_Family_Members__c");
		AdminField.add("Marketability__c");
		AdminField.add("NumberOfEmployees");
		AdminField.add("AccountSource");
		AdminField.add("Investor_Profile__c");
		AdminField.add("TickerSymbol");
		AdminField.add("Lender_Type__c");
		AdminField.add("AnnualRevenue");		
		AdminField.add("CurrencyIsoCode");
		AdminField.add("D_U_N_S__c");		
		AdminField.add("Previous_D_U_N_S__c");		
		AdminField.add("ParentId");
		AdminField.add("Verified_Date__c");
		AdminField.add("Status__c");
		AdminField.add("Inactivation_Date__c");
		AdminField.add("Reason_for_Inactivating__c");
		AdminField.add("NAICS_Code__c");
		AdminField.add("NAICS_Code_Description__c");
		AdminField.add("SIC_Code_1__c");
		AdminField.add("SIC_Code_1_Description__c");
		AdminField.add("SIC_Code_2__c");
		AdminField.add("SIC_Code_2_Description__c");
		AdminField.add("SIC_Code_3__c");
		AdminField.add("SIC_Code_3_Description__c");
		AdminField.add("SIC_Code_4__c");
		AdminField.add("SIC_Code_4_Description__c");
		AdminField.add("SIC_Code_5__c");
		AdminField.add("SIC_Code_5_Description__c");
		AdminField.add("SIC_Code_6__c");
		AdminField.add("SIC_Code_6_Description__c");
		AdminField.add("TDB_Industry_Code__c ");
		AdminField.add("Description");
		AdminField.add("APAC_Industry_Type__c");
		AdminField.add("Australian_Business_Number_ABN__c");
		AdminField.add("APAC_Sub_Industry__c");
		AdminField.add("Teikoku_Databank_Code_TDB__c");
		AdminField.add("Tax_Label_1__c");
		AdminField.add("Tax_Code_1__c");
		AdminField.add("EMEA_Reporting_Account__c");
		AdminField.add("EMEA_Client_Knowledge_Centre__c");
		AdminField.add("EMEA_Site_Parent_Account__c");
		AdminField.add("EMEA_Industry__c");
		AdminField.add("EMEA_Key_Account__c");		
		AdminField.add("EMEA_Account_Manager__c");		
		AdminField.add("EMEA_Area_of_Operations__c");
		AdminField.add("EMEA_Verified__c");		
		AdminField.add("EMEA_Flagged_for_Deletion__c");
		AdminField.add("datahugapps__HugRank__c");
		AdminField.add("Verification_Date__c");
		AdminField.add("datahugapps__NOM__c");
		AdminField.add("EMEA_SPV_Account__c");
		AdminField.add("datahugapps__NextMeeting__c");
		AdminField.add("EMEA_Searchable__c");
		AdminField.add("datahugapps__LM__c");
		AdminField.add("NAF_Code__c");
		AdminField.add("Legal_Structure__c");
		AdminField.add("SIREN__c");
		AdminField.add("INSCOM_Code__c");
		AdminField.add("SIRET__c");
		AdminField.add("Geographical_Address__c");
		AdminField.add("Number_of_Employees_per_Site__c");
		AdminField.add("Acronym_Name__c");
		AdminField.add("Number_of_Employees_per_Country__c");
		AdminField.add("Shipping_Building_Name__c");
		AdminField.add("Address_Registration_Date__c");
		AdminField.add("Shipping_Additional_Address__c");
		AdminField.add("Billing_Building_Name__c");
		AdminField.add("Billing_Area_Name__c");
		AdminField.add("Billing_Additional_Address__c");
		AdminField.add("of_Active_SPOCs__c");
		AdminField.add("of_Project_Enquiries_Agency_Ten_Rep__c");
		AdminField.add("of_Activities__c");
		AdminField.add("of_Project_Enquiries_Enquiry__c");
		AdminField.add("of_Comp_Relationships__c");
		AdminField.add("of_Property_Relationships__c");
		AdminField.add("of_Active_Contacts__c");
		AdminField.add("of_Active_Opportunities__c");
		AdminField.add("of_Deal_Relationships__c");
		AdminField.add("of_Closed_Won_Opportunities__c");
		AdminField.add("of_Private_Notes__c");
		AdminField.add("of_Closed_Lost_Opportunities__c");
		AdminField.add("of_Space_Relationships__c");		
		AdminField.add("OwnerId");
		AdminField.add("RecordTypeId");		
		AdminField.add("Translation_Status__c");
		AdminField.add("Last_Manually_Modified_Date__c");
		AdminField.add("Account_Creator_Country__c");
		AdminField.add("Last_Manually_Modified_By__c");
		AdminField.add("Non_UTF_8_Compliant__c");		
		AdminField.add("Legacy_Account_ID__c");
		AdminField.add("Exclude_from_DNB__c");
		AdminField.add("Source_System__c");
		AdminField.add("DIG_Review_Comments__c");
		AdminField.add("Integration_Id__c");
		AdminField.add("Hierarchy_Code__c");
		System.out.println("Admin Fields are::" + AdminField);		
	}
	
	static ArrayList<String> CMAMERField = new ArrayList<String>();
	
	public void CMAMERFields() {
		CMAMERField.add("Name");
		CMAMERField.add("Original_Account_Name__c");
		CMAMERField.add("Site");
		CMAMERField.add("Local_Account_Name__c");
		CMAMERField.add("Tradestyle_Name__c");
		CMAMERField.add("Phone");
		CMAMERField.add("Legal_Status__c");
		CMAMERField.add("Fax");
		CMAMERField.add("Migrated_Account__c");
		CMAMERField.add("Website");
		CMAMERField.add("Domestic_Ultimate__c");
		CMAMERField.add("Global_Ultimate__c");
		CMAMERField.add("Client_Type__c");
		CMAMERField.add("Key_Client_Account_for__c");
		CMAMERField.add("Client_Type_Rollup__c");
		CMAMERField.add("Key_Pursuit_Account_for__c");
		CMAMERField.add("BillingAddress");
		CMAMERField.add("ShippingAddress");
		CMAMERField.add("Local_Billing_Country__c");
		CMAMERField.add("Local_Shipping_Country__c");
		CMAMERField.add("Local_Billing_Street__c");
		CMAMERField.add("Local_Shipping_Street__c");
		CMAMERField.add("Local_Billing_City__c");
		CMAMERField.add("Local_Shipping_City__c");
		CMAMERField.add("Local_Billing_State_Province__c");
		CMAMERField.add("Local_Shipping_State_Province__c");
		CMAMERField.add("Local_Billing_Zip_Postal_Code__c");
		CMAMERField.add("Local_Shipping_Zip_Postal_Code__c");
		CMAMERField.add("Industry");
		CMAMERField.add("Type");
		CMAMERField.add("NumberOfEmployees");
		CMAMERField.add("Marketability__c");
		CMAMERField.add("Investor_Profile__c");
		CMAMERField.add("AccountSource");
		CMAMERField.add("Lender_Type__c");
		CMAMERField.add("TickerSymbol");
		CMAMERField.add("AnnualRevenue");
		CMAMERField.add("D_U_N_S__c");
		CMAMERField.add("CurrencyIsoCode");
		CMAMERField.add("Previous_D_U_N_S__c");
		CMAMERField.add("Tax_Label_1__c");
		CMAMERField.add("Status__c");
		CMAMERField.add("Reason_for_Inactivating__c");
		CMAMERField.add("Tax_Code_1__c");
		CMAMERField.add("Verified_Date__c");
		CMAMERField.add("Inactivation_Date__c");
		CMAMERField.add("NAICS_Code__c");
		CMAMERField.add("NAICS_Code_Description__c");
		CMAMERField.add("SIC_Code_1__c");
		CMAMERField.add("SIC_Code_1_Description__c");
		CMAMERField.add("SIC_Code_2__c");
		CMAMERField.add("SIC_Code_2_Description__c");
		CMAMERField.add("SIC_Code_3__c");
		CMAMERField.add("SIC_Code_3_Description__c");
		CMAMERField.add("SIC_Code_4__c");
		CMAMERField.add("SIC_Code_4_Description__c");
		CMAMERField.add("SIC_Code_5__c");
		CMAMERField.add("SIC_Code_5_Description__c");
		CMAMERField.add("SIC_Code_6__c");
		CMAMERField.add("SIC_Code_6_Description__c");
		CMAMERField.add("Description");
		CMAMERField.add("OwnerId");
		CMAMERField.add("RecordTypeId");
		CMAMERField.add("Last_Manually_Modified_Date__c");
		CMAMERField.add("Last_Manually_Modified_By__c");

		System.out.println("Capital Markets AMER Fields are::" + CMAMERField);	
	}
	
	/**
	 * Function for the validating the field on the Accounts Page
	 * 
	 * @author Vishnuvardhan
	 *
	 */
	static ArrayList<String> OBEMEAFieldLabelsAPI = new ArrayList<String>();
	static ArrayList<String> CMAPACFieldLabelsAPI = new ArrayList<String>();
	static ArrayList<String> ABEMEAFieldLabelsAPI = new ArrayList<String>();
	static ArrayList<String> ABAMERFieldLabelsAPI = new ArrayList<String>();
	static ArrayList<String> AdminFieldLabelsAPI = new ArrayList<String>();
	static ArrayList<String> CMAMERFieldLabelsAPI = new ArrayList<String>();

	public void accountPageFieldsValidation() {
		try {
			establishConnection.establishConnectionSpecificUser();
			OBEMEAHeadings();
			CMAPACHeaders();
			ABEMEAHeaders();
			ABAMERHeaders();
			AdminHeaders();
			CMAMERHeaders();
			OBEMEAFields();
			CMAPACFields();
			ABEMEAFields();
			ABAMERFields();
			AdminFields();
			CMAMERFields();
			DescribeLayoutResult dlr = EstablishConnection.connection.describeLayout("Account", null, null);
			int count=0, countLabelList = 0;
			for (int i = 0; i < dlr.getLayouts().length; i++) {
				DescribeLayout layout = dlr.getLayouts()[i];
				DescribeLayoutSection[] editLayoutSectionList = layout.getEditLayoutSections();
				// Write the headings of the edit layout sections
				for (int x = 0; x < editLayoutSectionList.length; x++) {
					if(dataTable.getData("General_Data", "TC_ID").contains("OBEMEA")) {
						if(editLayoutSectionList.length==5) {
							if(editLayoutSectionList[x].getHeading().equals(OBEMEAHeader.get(x))) {
									System.out.println(x + ":::Occupier Brokerage EMEA has the heading layout section:::" + editLayoutSectionList[x].getHeading());
									report.updateTestLog(x + ":::Occupier Brokerage EMEA", " has the heading layout section:::" + editLayoutSectionList[x].getHeading(), Status.PASS);
									count++;
								}
						}				
					}
					if(dataTable.getData("General_Data", "TC_ID").contains("CMAPAC")) {
						if(editLayoutSectionList.length==5) {
							if(editLayoutSectionList[x].getHeading().equals(CMAPACHeader.get(x))) {
									System.out.println(x + ":::Captial Markets APAC has the heading layout section:::" + editLayoutSectionList[x].getHeading());
									report.updateTestLog(x + ":::Captial Markets APAC", " has the heading layout section:::" + editLayoutSectionList[x].getHeading(), Status.PASS);
									count++;
								}
						}
					}
					if(dataTable.getData("General_Data", "TC_ID").contains("ABEMEA")) {
						if(editLayoutSectionList.length==5) {
							if(editLayoutSectionList[x].getHeading().equals(ABEMEAHeader.get(x))) {
									System.out.println(x + ":::Agency Brokerage EMEA has the heading layout section:::" + editLayoutSectionList[x].getHeading());
									report.updateTestLog(x + ":::Agency Brokerage EMEA", " has the heading layout section:::" + editLayoutSectionList[x].getHeading(), Status.PASS);
									count++;
								}
						}				
					}
					if(dataTable.getData("General_Data", "TC_ID").contains("ABAMER")) {
						if(editLayoutSectionList.length==8) {
							if(editLayoutSectionList[x].getHeading().equals(ABAMERHeader.get(x))) {
									System.out.println(x + ":::Agency Brokerage AMER has the heading layout section:::" + editLayoutSectionList[x].getHeading());
									report.updateTestLog(x + ":::Agency Brokerage AMER", " has the heading layout section:::" + editLayoutSectionList[x].getHeading(), Status.PASS);
									count++;
								}
						}				
					}
					if(dataTable.getData("General_Data", "TC_ID").contains("Admin")) {
						if(editLayoutSectionList.length==13) {
							if(editLayoutSectionList[x].getHeading().equals(AdminHeader.get(x))) {
									System.out.println(x + ":::Admin has the heading layout section:::" + editLayoutSectionList[x].getHeading());
									report.updateTestLog(x + ":::Admin", " has the heading layout section:::" + editLayoutSectionList[x].getHeading(), Status.PASS);
									count++;
								}
						}				
					}
					if(dataTable.getData("General_Data", "TC_ID").contains("CMAMER")) {
						if(editLayoutSectionList.length==8) {
							if(editLayoutSectionList[x].getHeading().equals(CMAMERHeader.get(x))) {
									System.out.println(x + ":::Capital Markets AMER has the heading layout section:::" + editLayoutSectionList[x].getHeading());
									report.updateTestLog(x + ":::Capital Markets AMER", " has the heading layout section:::" + editLayoutSectionList[x].getHeading(), Status.PASS);
									count++;
								}
						}				
					}
				}		
				System.out.println(count);
				if(dataTable.getData("General_Data", "TC_ID").contains("OBEMEA")) {
					if(editLayoutSectionList.length==5) {
						for (int k = 0; k < editLayoutSectionList.length; k++) {
							DescribeLayoutSection els = editLayoutSectionList[k];
							DescribeLayoutRow[] dlrList = els.getLayoutRows();
							for (int m = 0; m < dlrList.length; m++) {
								DescribeLayoutRow lr = dlrList[m];
								DescribeLayoutItem[] dliList = lr.getLayoutItems();
								for (int n = 0; n < dliList.length; n++) {
									DescribeLayoutItem li = dliList[n];
									if ((li.getLayoutComponents() != null) && (li.getLayoutComponents().length > 0)) {
										try {
											String value = li.getLayoutComponents()[0].getValue();
											if(value!=null) {
												OBEMEAFieldLabelsAPI.add(value);
											}
										} catch (Exception e) {
											e.printStackTrace();
										}
									}
								}
							}
						}	
						System.out.println("OBEMEA Field Label::: " + OBEMEAFieldLabelsAPI);
						for(int i1=0; i1 < OBEMEAField.size(); i1++) {
							if(OBEMEAFieldLabelsAPI.get(i1).equals(OBEMEAField.get(i1))) {						
								System.out.println("Field Label:::" + OBEMEAFieldLabelsAPI.get(i1) + " -- is present in OB EMEA:::");
								report.updateTestLog("Verify Field Labels", " has the field label:::" + OBEMEAFieldLabelsAPI.get(i1), Status.PASS);
								countLabelList++;
							}			 
						}
						System.out.println("Count of fields present in Occupier Brokerage EMEA::" + countLabelList);						
					}
				}	
				if(dataTable.getData("General_Data", "TC_ID").contains("CMAPAC")) {
					if(editLayoutSectionList.length==5) {
						for (int k = 0; k < editLayoutSectionList.length; k++) {
							DescribeLayoutSection els = editLayoutSectionList[k];
							DescribeLayoutRow[] dlrList = els.getLayoutRows();
							for (int m = 0; m < dlrList.length; m++) {
								DescribeLayoutRow lr = dlrList[m];
								DescribeLayoutItem[] dliList = lr.getLayoutItems();
								for (int n = 0; n < dliList.length; n++) {
									DescribeLayoutItem li = dliList[n];
									if ((li.getLayoutComponents() != null) && (li.getLayoutComponents().length > 0)) {
										try {
											String value = li.getLayoutComponents()[0].getValue();
											if(value!=null) {
												CMAPACFieldLabelsAPI.add(value);
											}
										} catch (Exception e) {
											e.printStackTrace();
										}
									}
								}
							}
						}	
						System.out.println("CMAPAC Field Label::: " + CMAPACFieldLabelsAPI);
						for(int i1=0; i1 < CMAPACField.size(); i1++) {
							if(CMAPACFieldLabelsAPI.get(i1).equals(CMAPACField.get(i1))) {						
								System.out.println("Field Label:::" + CMAPACFieldLabelsAPI.get(i1) + " -- is present in CM APAC:::");
								report.updateTestLog("Verify Field Labels", " has the field label:::" + CMAPACFieldLabelsAPI.get(i1), Status.PASS);
								countLabelList++;
							}			 
						}
						System.out.println("Count of fields present in Capital Brokerage EMEA::" + countLabelList);
					}
				}	
				if(dataTable.getData("General_Data", "TC_ID").contains("ABEMEA")) {
					if(editLayoutSectionList.length==5) {
						for (int k = 0; k < editLayoutSectionList.length; k++) {
							DescribeLayoutSection els = editLayoutSectionList[k];
							DescribeLayoutRow[] dlrList = els.getLayoutRows();
							for (int m = 0; m < dlrList.length; m++) {
								DescribeLayoutRow lr = dlrList[m];
								DescribeLayoutItem[] dliList = lr.getLayoutItems();
								for (int n = 0; n < dliList.length; n++) {
									DescribeLayoutItem li = dliList[n];
									if ((li.getLayoutComponents() != null) && (li.getLayoutComponents().length > 0)) {
										ABEMEAFieldLabelsAPI.add(li.getLayoutComponents()[0].getValue());
									}
								}
							}
						}	
						System.out.println("ABEMEA Field Label::: " + ABEMEAFieldLabelsAPI);
						for(int i1=0; i1 < ABEMEAField.size(); i1++) {
							if(ABEMEAFieldLabelsAPI.get(i1).equals(ABEMEAField.get(i1))) {						
								System.out.println("Field Label:::" + ABEMEAFieldLabelsAPI.get(i1) + " -- is present in CM APAC:::");
								report.updateTestLog("Verify Field Labels", " has the field label:::" + ABEMEAFieldLabelsAPI.get(i1), Status.PASS);
								countLabelList++;
							}			 
						}
						System.out.println("Count of fields present in Agency Brokerage EMEA::" + countLabelList);
					}
				}	
				if(dataTable.getData("General_Data", "TC_ID").contains("ABAMER")) {
					if(editLayoutSectionList.length==8) {
						for (int k = 0; k < editLayoutSectionList.length; k++) {
							DescribeLayoutSection els = editLayoutSectionList[k];
							DescribeLayoutRow[] dlrList = els.getLayoutRows();
							for (int m = 0; m < dlrList.length; m++) {
								DescribeLayoutRow lr = dlrList[m];
								DescribeLayoutItem[] dliList = lr.getLayoutItems();
								for (int n = 0; n < dliList.length; n++) {
									DescribeLayoutItem li = dliList[n];
									if ((li.getLayoutComponents() != null) && (li.getLayoutComponents().length > 0)) {
										try {
											String value = li.getLayoutComponents()[0].getValue();
											if(value!=null) {
												ABAMERFieldLabelsAPI.add(value);
											}
										} catch (Exception e) {
											e.printStackTrace();
										}
									}
								}
							}
						}	
						System.out.println("ABAMER Field Label::: " + ABAMERFieldLabelsAPI);
						for(int i1=0; i1 < ABAMERField.size(); i1++) {
							if(ABAMERFieldLabelsAPI.get(i1).equals(ABAMERField.get(i1))) {						
								System.out.println("Field Label:::" + ABAMERFieldLabelsAPI.get(i1) + " -- is present in AB AMER:::");
								report.updateTestLog("Verify Field Labels", " has the field label:::" + ABAMERFieldLabelsAPI.get(i1), Status.PASS);
								countLabelList++;
							}			 
						}
						System.out.println("Count of fields present in Agency Brokerage AMER::" + countLabelList);
					}
				}	
				if(dataTable.getData("General_Data", "TC_ID").contains("Admin")) {
					if(editLayoutSectionList.length==13) {
						for (int k = 0; k < editLayoutSectionList.length; k++) {
							DescribeLayoutSection els = editLayoutSectionList[k];
							DescribeLayoutRow[] dlrList = els.getLayoutRows();
							for (int m = 0; m < dlrList.length; m++) {
								DescribeLayoutRow lr = dlrList[m];
								DescribeLayoutItem[] dliList = lr.getLayoutItems();
								for (int n = 0; n < dliList.length; n++) {
									DescribeLayoutItem li = dliList[n];
									if ((li.getLayoutComponents() != null) && (li.getLayoutComponents().length > 0)) {
										try {
											String value = li.getLayoutComponents()[0].getValue();
											if(value!=null) {
												AdminFieldLabelsAPI.add(value);
											}
										} catch (Exception e) {
											e.printStackTrace();
										}
									}
								}
							}
						}	
						System.out.println("Admin Field Label::: " + AdminFieldLabelsAPI);
						for(int i1=0; i1 < AdminField.size(); i1++) {
							if(AdminFieldLabelsAPI.get(i1).equals(AdminField.get(i1))) {						
								System.out.println("Field Label:::" + AdminFieldLabelsAPI.get(i1) + " -- is present in AB AMER:::");
								report.updateTestLog("Verify Field Labels", " has the field label:::" + AdminFieldLabelsAPI.get(i1), Status.PASS);
								countLabelList++;
							}			 
						}
						System.out.println("Count of fields present in Admin::" + countLabelList);
					}
				}
				if(dataTable.getData("General_Data", "TC_ID").contains("CMAMER")) {
					if(editLayoutSectionList.length==8) {
						for (int k = 0; k < editLayoutSectionList.length; k++) {
							DescribeLayoutSection els = editLayoutSectionList[k];
							DescribeLayoutRow[] dlrList = els.getLayoutRows();
							for (int m = 0; m < dlrList.length; m++) {
								DescribeLayoutRow lr = dlrList[m];
								DescribeLayoutItem[] dliList = lr.getLayoutItems();
								for (int n = 0; n < dliList.length; n++) {
									DescribeLayoutItem li = dliList[n];
									if ((li.getLayoutComponents() != null) && (li.getLayoutComponents().length > 0)) {
										try {
											String value = li.getLayoutComponents()[0].getValue();
											if(value!=null) {
												CMAMERFieldLabelsAPI.add(value);
											}
										} catch (Exception e) {
											e.printStackTrace();
										}
									}
								}
							}
						}	
						System.out.println("CMAMAER Field Label::: " + CMAMERFieldLabelsAPI);
						for(int i1=0; i1 < CMAMERField.size(); i1++) {
							if(CMAMERFieldLabelsAPI.get(i1).equals(CMAMERField.get(i1))) {						
								System.out.println("Field Label:::" + CMAMERFieldLabelsAPI.get(i1) + " -- is present in CM AMER:::");
								report.updateTestLog("Verify Field Labels", " has the field label:::" + CMAMERFieldLabelsAPI.get(i1), Status.PASS);
								countLabelList++;
							}			 
						}
						System.out.println("Count of fields present in CMAMER::" + countLabelList);
					}
				}
			}	
			if((dataTable.getData("General_Data", "TC_ID").contains("OBEMEA")) || (dataTable.getData("General_Data", "TC_ID").contains("CMAPAC"))
					|| (dataTable.getData("General_Data", "TC_ID").contains("ABEMEA")) || (dataTable.getData("General_Data", "TC_ID").contains("CMAMER")) 
					|| (dataTable.getData("General_Data", "TC_ID").contains("ABAMER"))) {
				if(count==5) {
					System.out.println("Occupier Brokerage EMEA/ Captial Markets APAC/ Agency Brokerage have all the header sections present::");
					report.updateTestLog("Validating Header Sections", "Occupier Brokerage EMEA/ Captial Markets APAC/ Agency Brokerage - All the headers are present", Status.PASS);
					OBEMEAHeader.clear();
					CMAPACHeader.clear();
					ABEMEAHeader.clear();
				}						
				else if(count==8) {
					System.out.println("Capital Markets/ Agency Brokerage AMER have all the header sections present::");
					report.updateTestLog("Validating Header Sections", "Capital Markets/ Agency Brokerage AMER - All the headers are present", Status.PASS);
					CMAMERHeader.clear();
					ABAMERHeader.clear();
				}
				else if(count==13) {
					System.out.println("Admin have all the header sections present::");
					report.updateTestLog("Validating Header Sections", "Admin have all the header sections present", Status.PASS);
					AdminHeader.clear();
				}
				else {
					System.out.println("Occupier Brokerage EMEA/ Captial Markets APAC/ Agency Brokerage doesn't have all the header sections present::");
					report.updateTestLog("Validating Header Sections", "Not all header sections are present", Status.FAIL);
				}
			}
			OBEMEAField.clear();
			CMAPACField.clear();
			ABEMEAField.clear();
			ABAMERField.clear();
			AdminField.clear();
			CMAMERField.clear();
			if (countLabelList == 21) {
				report.updateTestLog("Count of fields present in Occupier Brokerage/ Agency Brokerage EMEA", "All the fields are present in Occupier Brokerage/ Agency Brokerage EMEA", Status.PASS);
			} else if (countLabelList == 26) {
				report.updateTestLog("Count of fields present in Capital Markets APAC", "All the fields are presentin Capital Markets", Status.PASS);
			} else if (countLabelList == 63) {
				report.updateTestLog("Count of fields present in Agency Brokerage AMER", "All the fields are present in Agency Brokerage", Status.PASS);
			} else if (countLabelList == 132) {
				report.updateTestLog("Count of fields present in Admin", "All the fields are present are present in Admin ", Status.PASS);
			} else if (countLabelList == 65) {
				report.updateTestLog("Count of fields present in Capital Markets AMER", "All the fields are present are present in Capital Markets", Status.PASS);
			}  else {
				report.updateTestLog("Count of fields present", "Not all the fields are present", Status.FAIL);
			}		
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	public void createAccountRequiredFields() {
		try {
			
			establishConnection.establishConnectionSpecificUser();
			SObject account = new SObject();

			account.setType("Account");
			String accountName = Utility_Functions.xRandomFunction() + "_" + dataTable.getData("General_Data", "Name");
			account.setField("Name", accountName);
			account.setField("BillingCountry", dataTable.getData("General_Data", "Country"));
			account.setField("BillingStreet", dataTable.getData("General_Data", "Street"));
			account.setField("BillingCity", dataTable.getData("General_Data", "City"));
			account.setField("BillingState", dataTable.getData("General_Data", "State"));
			account.setField("BillingPostalCode ", dataTable.getData("General_Data", "Zipcode"));

			SObject[] accounts = new SObject[1];
			accounts[0] = account;
			results = EstablishConnection.connection.create(accounts);
			System.out.println("Result:::" + results);
			status = establishConnection.saveResults(results);
			if(status==true) {
				report.updateTestLog("Verify Create Account", "Account has been created successfully", Status.PASS);
			} else {
				report.updateTestLog("Verify Create Account", "Account creation failed", Status.FAIL);
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	
	/**
	 * Function for the Account Creation
	 * 
	 * @author Vishnuvardhan
	 *
	 */
	
	public void createAccountSpecificUser() {
			establishConnection.establishConnectionSpecificUser();
			SObject account = new SObject();

			account.setType("Account");
			String accountName = Utility_Functions.xRandomFunction() + "-" + dataTable.getData("General_Data", "Name");
			account.setField("Name", accountName);
			account.setField("BillingCountry", dataTable.getData("General_Data", "Country"));
			account.setField("BillingStreet", dataTable.getData("General_Data", "Street"));
			account.setField("BillingCity", dataTable.getData("General_Data", "City"));
			account.setField("BillingState", dataTable.getData("General_Data", "State"));
			account.setField("BillingPostalCode ", dataTable.getData("General_Data", "Zipcode"));
			account.setField("APAC_Industry_Type__c", "Advertising, Marketing & PR");
			account.setField("APAC_Sub_Industry__c", "Advertising and Marketing");
			SObject[] accounts = new SObject[1];
			accounts[0] = account;
			try {
				results = EstablishConnection.connection.create(accounts);
			} catch (ConnectionException e) {
				e.printStackTrace();
			}
			System.out.println("Result:::" + results);
			status = establishConnection.saveResults(results);
			if(status==true) {
				report.updateTestLog("Verify Create Account", "Account has been created successfully", Status.PASS);
			} else {
				report.updateTestLog("Verify Create Account", "Account creation failed", Status.FAIL);
			}
	}
	/*public void accountPageFieldsValidation() {
		try {
			establishConnection.establishConnectionSpecificUser();
			DescribeLayoutResult dlr = EstablishConnection.connection.describeLayout("Account", null, null);
			for (int i = 0; i < dlr.getLayouts().length; i++) {
				DescribeLayout layout = dlr.getLayouts()[i];
				DescribeLayoutSection[] detailLayoutSectionList = layout.getDetailLayoutSections();
				System.out.println(" There are " + detailLayoutSectionList.length + " detail layout sections");
				report.updateTestLog("Verify Accounts Page Field Validation",
						"There are " + detailLayoutSectionList.length + " detail layout sections", Status.PASS);
				DescribeLayoutSection[] editLayoutSectionList = layout.getEditLayoutSections();
				System.out.println(" There are " + editLayoutSectionList.length + " edit layout sections");
				report.updateTestLog("Verify Accounts Page Field Validation",
						" There are " + editLayoutSectionList.length + " edit layout sections", Status.PASS);
				for (int j = 0; j < detailLayoutSectionList.length; j++) {
					System.out.println(j + " This detail layout section has a heading of "
							+ detailLayoutSectionList[j].getHeading());
					report.updateTestLog("Verify Accounts Page Field Validation", j
							+ " This detail layout section has a heading of " + detailLayoutSectionList[j].getHeading(),
							Status.PASS);
				}
				// Write the headings of the edit layout sections
				for (int x = 0; x < editLayoutSectionList.length; x++) {
					System.out.println(
							x + " This edit layout section has a heading of " + editLayoutSectionList[x].getHeading());
					report.updateTestLog("Verify Accounts Page Field Validation",
							x + " This edit layout section has a heading of " + editLayoutSectionList[x].getHeading(),
							Status.PASS);
				}
				// For each edit layout section, get its details.
				for (int k = 0; k < editLayoutSectionList.length; k++) {
					DescribeLayoutSection els = editLayoutSectionList[k];
					System.out.println("Edit layout section heading: " + els.getHeading());
					report.updateTestLog("Verify Accounts Page Field Validation",
							"Edit layout section heading: " + els.getHeading(), Status.PASS);
					DescribeLayoutRow[] dlrList = els.getLayoutRows();
					System.out.println("This edit layout section has " + dlrList.length + " layout rows");
					report.updateTestLog("Verify Accounts Page Field Validation",
							"This edit layout section has " + dlrList.length + " layout rows", Status.PASS);
					for (int m = 0; m < dlrList.length; m++) {
						DescribeLayoutRow lr = dlrList[m];
						System.out.println(" This row has " + lr.getNumItems() + " layout items");
						report.updateTestLog("Verify Accounts Page Field Validation",
								" This row has " + lr.getNumItems() + " layout items", Status.PASS);
						DescribeLayoutItem[] dliList = lr.getLayoutItems();
						for (int n = 0; n < dliList.length; n++) {
							DescribeLayoutItem li = dliList[n];
							if ((li.getLayoutComponents() != null) && (li.getLayoutComponents().length > 0)) {
								System.out.println("\tLayout item " + n + ", layout component: "
										+ li.getLayoutComponents()[0].getValue());
								report.updateTestLog(
										"Verify Accounts Page Field Validation", "\tLayout item " + n
												+ ", layout component: " + li.getLayoutComponents()[0].getValue(),
										Status.PASS);
							} else {
								System.out.println("\tLayout item " + n + ", no layout component");
								report.updateTestLog("Verify Accounts Page Field Validation",
										"\tLayout item " + n + ", no layout component", Status.PASS);
							}
						}
					}
				}
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}*/

}