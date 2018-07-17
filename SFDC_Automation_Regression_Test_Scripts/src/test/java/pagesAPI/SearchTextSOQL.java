package pagesAPI;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import com.cognizant.Craft.ReusableLibrary;
import com.cognizant.Craft.ScriptHelper;
import com.cognizant.framework.Status;
import com.sforce.soap.partner.DeleteResult;
import com.sforce.soap.partner.QueryResult;
import com.sforce.soap.partner.SaveResult;
import com.sforce.soap.partner.sobject.SObject;
import com.sforce.ws.ConnectionException;

/**
 * API Class for searching the text using SOQL calls
 * 
 * @author Vishnuvardhan
 *
 */
public class SearchTextSOQL extends ReusableLibrary {
	/*
	 * Constructor to initialize the business component library
	 * 
	 * @param scriptHelper The {@link ScriptHelper} object passed from the
	 * {@link DriverScript}
	 */

	public SearchTextSOQL(ScriptHelper scriptHelper) {
		super(scriptHelper);
	}

	static SaveResult[] results;
	static DeleteResult[] deleteResults;
	static com.sforce.soap.partner.Error[] errors;
	static boolean status = false;

	Random random = new Random();
	int offsetValue = random.nextInt(9);

	EstablishConnection establishConnection = new EstablishConnection(scriptHelper);

	/**
	 * Function for validating the search for Lead functionality
	 * 
	 * @author Vishnuvardhan
	 *
	 */

	public void searchLead() {
		try {
			establishConnection.establishConnection();
			// List<String> lstLeadName = new ArrayList<String>();
			// Suppose you have filled lstIds with your ids.
			/*
			 * String query = "select Id, Name from lead "; String strLeadName =
			 * dataTable.getData("General_Data", "Lead Name"); for(String
			 * ids:lstLeadName){ if(strLeadName.equals("")){ strLeadName = "'" +
			 * ids + "'"; } else{ strLeadName += ",'" + ids + "'"; } } query +=
			 * "where id in (" + strLeadName + ")";
			 */
			String query = "SELECT Id FROM Lead where Country !=null limit 1 offset " + offsetValue;
			QueryResult result = EstablishConnection.connection.query(query);
			if (result.getSize() > 0) {
				boolean done = false;
				while (!done) {
					for (SObject record : result.getRecords()) {
						System.out.println("###### record.Id: " + (String) record.getField("Id"));
						System.out.println("###### record.Name: " + (String) record.getField("Name"));
					}
					if (result.isDone()) {
						done = true;
					} else {
						result = EstablishConnection.connection.queryMore(result.getQueryLocator());
					}
				}
			}
		} catch (Exception ex) {
			System.out.println("Exception in main : " + ex);
		}
	}

	/**
	 * Function to fetch an existing Account record.
	 * 
	 * @author SChandran
	 * @return 
	 *
	 */

	public Map<String, String> searchAccount() {
		Map<String, String> recordID = new HashMap<String, String>();
		try {
			establishConnection.establishConnection();
			String query = "SELECT Id, Name FROM Account WHERE BillingCountry != 'NULL' limit 1 offset " + offsetValue;
			QueryResult result = EstablishConnection.connection.query(query);
			if (result.getSize() > 0) {
				boolean done = false;
				while (!done) {
					for (SObject record : result.getRecords()) {
						System.out.println("###### record.Id: " + (String) record.getField("Id"));
						System.out.println("###### record.Name: " + (String) record.getField("Name"));
						recordID.put("ID", (String) record.getField("Id"));
						recordID.put("Name", (String) record.getField("Name"));
					}
					if (result.isDone()) {
						done = true;
					} else {
						result = EstablishConnection.connection.queryMore(result.getQueryLocator());
					}
				}
			}
		} catch (Exception ex) {
			System.out.println("Exception in main : " + ex);
		}
		return recordID;
	}

	/**
	 * Function for validating the search for Opportunity functionality
	 * 
	 * @author Vishnuvardhan
	 *
	 */

	public String searchOpportunity(String query) {
		String recordID = null;
		try {
			establishConnection.establishConnection();
			String Query = query;
			// Query = "SELECT Id FROM Lead where Country !=null limit 10";
			QueryResult result = EstablishConnection.connection.query(Query);
			if (result.getSize() > 0) {
				boolean done = false;
				while (!done) {
					for (SObject record : result.getRecords()) {

						recordID = (String) record.getField("Id");
						report.updateTestLog("Verify Fetch Record",
								"Record has been fetched successfully:::" + recordID, Status.PASS);
						System.out.println("###### record.Id: " + (String) record.getField("Id"));
						System.out.println("###### record.Name: " + (String) record.getField("Name"));
						if (recordID != null) {
							done = true;
							break;
						}
					}
					if (result.isDone()) {
						done = true;
					} else {
						result = EstablishConnection.connection.queryMore(result.getQueryLocator());
					}
				}
			}
		} catch (Exception ex) {
			System.out.println("Exception in main : " + ex);
		}
		return recordID;
	}

	/**
	 * Function to fetch the Account, Contact, Lead, Opportunities from SOQL using the query
	 * 
	 * @author Vishnuvardhan
	 *
	 */

	public String fetchRecord(String table, String Name) {
		String recordID = null;
		String name = Name;
		try {
			establishConnection.establishConnection();
			String tableName = table;
			//String query = "select Id, Name from " + tableName + " limit 1 offset " + offsetValue;
			String query = "select Id, Name from " + tableName + " limit 1 offset 1" + offsetValue;
			QueryResult result = EstablishConnection.connection.query(query);
			if (result.getSize() > 0) {
				boolean done = false;
				while (!done) {
					for (SObject record : result.getRecords()) {
						if (name.equals("Name")) {
							recordID = (String) record.getField("Name");
							report.updateTestLog("Verify Fetch Record",
									"Record has been fetched successfully:::" + recordID, Status.PASS);
						} else if (name.equals("StageName")) {
							recordID = (String) record.getField("StageName");
							report.updateTestLog("Verify Fetch Record",
									"Record has been fetched successfully:::" + recordID, Status.PASS);
						} else if (name.equals("Opportunity_ID__c ")) {
							recordID = (String) record.getField("Opportunity_ID__c ");
							report.updateTestLog("Verify Fetch Record",
									"Record has been fetched successfully:::" + recordID, Status.PASS);
						} else if (name.equals("CBRE_SPOC_Employee__c")) {
							recordID = (String) record.getField("CBRE_SPOC_Employee__c");
							report.updateTestLog("Verify Fetch Record",
									"Record has been fetched successfully:::" + recordID, Status.PASS);
						} else {
							recordID = (String) record.getField("Id");
							report.updateTestLog("Verify Fetch Record",
									"Record has been fetched successfully:::" + recordID, Status.PASS);
						}
						System.out.println("###### record.Id: " + (String) record.getField("Id"));
						System.out.println("###### record.Name: " + (String) record.getField("Name"));
						if (recordID != null) {
							done = true;
							break;
						}
					}
					if (result.isDone()) {
						done = true;
					} else {
						result = EstablishConnection.connection.queryMore(result.getQueryLocator());
					}
				}
			}
		} catch (Exception ex) {
			report.updateTestLog("Verify Fetch Record", "Record fetch failed:::" + recordID, Status.WARNING);
			System.out.println(ex.getMessage()); 
			ex.printStackTrace();
		}
		return recordID;
	}

	/**
	 * Function to fetch the Account, Contact, Lead, Opportunities from SOQL using the query
	 * 
	 * @author Vishnuvardhan
	 *
	 */

	public String fetchRecordFieldValue(String FieldName, String Query) {
		String recordID = null;
		String fieldname = FieldName;
		try {
			establishConnection.establishConnection();
			String query = Query;
			QueryResult result = EstablishConnection.connection.query(query);
			if (result.getSize() > 0) {
				boolean done = false;
				while (!done) {
					for (SObject record : result.getRecords()) {
						if (fieldname.equals("Name")) {
							recordID = (String) record.getField("Name");
							report.updateTestLog("Verify Fetch Record",
									"Record has been fetched successfully:::" + recordID, Status.PASS);
						} else if (fieldname.equals("StageName")) {
							recordID = (String) record.getField("StageName");
							report.updateTestLog("Verify Fetch Record",
									"Record has been fetched successfully:::" + recordID, Status.PASS);
						} else if (fieldname.equals("RecordTypeId")) {
							recordID = (String) record.getField("RecordTypeId");
							report.updateTestLog("Verify Fetch Record",
									"Record has been fetched successfully:::" + recordID, Status.PASS);
						} else if (fieldname.equals("Total_Size__c")) {
							recordID = (String) record.getField("Total_Size__c");
							report.updateTestLog("Verify Fetch Record",
									"Record has been fetched successfully:::" + recordID, Status.PASS);
						} else if (fieldname.equals("CBRE_Preferred_Property_Type_c__c")) {
							recordID = (String) record.getField("CBRE_Preferred_Property_Type_c__c");
							report.updateTestLog("Verify Fetch Record",
									"Record has been fetched successfully:::" + recordID, Status.PASS);
						} else if (fieldname.equals("Lease_From__c")) {
							recordID = (String) record.getField("Lease_From__c");
							report.updateTestLog("Verify Fetch Record",
									"Record has been fetched successfully:::" + recordID, Status.PASS);
						} else if (fieldname.equals("Lease_To__c")) {
							recordID = (String) record.getField("Lease_To__c");
							report.updateTestLog("Verify Fetch Record",
									"Record has been fetched successfully:::" + recordID, Status.PASS);
						} else if (fieldname.equals("Lease_Term__c")) {
							recordID = (String) record.getField("Lease_Term__c");
							report.updateTestLog("Verify Fetch Record",
									"Record has been fetched successfully:::" + recordID, Status.PASS);
						} else if (fieldname.equals("Lease_Rate_Rent__c")) {
							recordID = (String) record.getField("Lease_Rate_Rent__c");
							report.updateTestLog("Verify Fetch Record",
									"Record has been fetched successfully:::" + recordID, Status.PASS);
						} else if (fieldname.equals("Lease_Rate_Rent_Basis__c")) {
							recordID = (String) record.getField("Lease_Rate_Rent_Basis__c");
							report.updateTestLog("Verify Fetch Record",
									"Record has been fetched successfully:::" + recordID, Status.PASS);
						} else if (fieldname.equals("Service__c")) {
							recordID = (String) record.getField("Service__c");
							report.updateTestLog("Verify Fetch Record",
									"Record has been fetched successfully:::" + recordID, Status.PASS);
						} else if (fieldname.equals("CloseDate")) {
							recordID = (String) record.getField("CloseDate");
							report.updateTestLog("Verify Fetch Record",
									"Record has been fetched successfully:::" + recordID, Status.PASS);
						} else if (fieldname.equals("Unit_of_Measure__c")) {
							recordID = (String) record.getField("Unit_of_Measure__c");
							report.updateTestLog("Verify Fetch Record",
									"Record has been fetched successfully:::" + recordID, Status.PASS);
						} else if (fieldname.equals("Installment_Amount__c")) {
							recordID = (String) record.getField("Installment_Amount__c");
							report.updateTestLog("Verify Fetch Record",
									"Record has been fetched successfully:::" + recordID, Status.PASS);
						} else if (fieldname.equals("Installment_Quantity__c")) {
							recordID = (String) record.getField("Installment_Quantity__c");
							report.updateTestLog("Verify Fetch Record",
									"Record has been fetched successfully:::" + recordID, Status.PASS);
						} else if (fieldname.equals("Installments_Total__c")) {
							recordID = (String) record.getField("Installments_Total__c");
							report.updateTestLog("Verify Fetch Record",
									"Record has been fetched successfully:::" + recordID, Status.PASS);
						}  else if (fieldname.equals("Installment_Count__c")) {
							recordID = (String) record.getField("Installment_Count__c");
							report.updateTestLog("Verify Fetch Record",
									"Record has been fetched successfully:::" + recordID, Status.PASS);
						} else if (fieldname.equals("Estimated_Gross_Fee_Commission__c")) {
							recordID = (String) record.getField("Estimated_Gross_Fee_Commission__c");
							report.updateTestLog("Verify Fetch Record",
									"Record has been fetched successfully:::" + recordID, Status.PASS);
						} else if (fieldname.equals("Opportunity_ID__c")) {
							recordID = (String) record.getField("Opportunity_ID__c");
							report.updateTestLog("Verify Fetch Record",
									"Record has been fetched successfully:::" + recordID, Status.PASS);
						} else if (fieldname.equals("Phase__c")) {
							recordID = (String) record.getField("Phase__c");
							report.updateTestLog("Verify Fetch Record",
									"Record has been fetched successfully:::" + recordID, Status.PASS);
						} else if (fieldname.equals("Probability")) {
							recordID = (String) record.getField("Probability");
							report.updateTestLog("Verify Fetch Record",
									"Record has been fetched successfully:::" + recordID, Status.PASS);
						} else if (fieldname.equals("Username")) {
							recordID = (String) record.getField("Username");
							report.updateTestLog("Verify Fetch Record",
									"Record has been fetched successfully:::" + recordID, Status.PASS);
						} else if (fieldname.equals("Email")) {
							recordID = (String) record.getField("Email");
							report.updateTestLog("Verify Fetch Record",
									"Record has been fetched successfully:::" + recordID, Status.PASS);
						} else if (fieldname.equals("ProfileId")) {
							recordID = (String) record.getField("ProfileId");
							//report.updateTestLog("Verify Fetch Record", "Record has been fetched successfully:::" + recordID, Status.PASS);
						} else if (fieldname.equals("UserRoleId")) {
							recordID = (String) record.getField("UserRoleId");
							//report.updateTestLog("Verify Fetch Record", "Record has been fetched successfully:::" + recordID, Status.PASS);
						}  else if (fieldname.equals("Subject__c")) {
							recordID = (String) record.getField("Subject__c");
							report.updateTestLog("Verify Fetch Record",
									"Record has been fetched successfully:::" + recordID, Status.PASS);
						} else if (fieldname.equals("Property_Type__c")) {
							recordID = (String) record.getField("Property_Type__c");
							report.updateTestLog("Verify Fetch Record",
									"Record has been fetched successfully:::" + recordID, Status.PASS);
						}  else if (fieldname.equals("Sub_Type__c")) {
							recordID = (String) record.getField("Sub_Type__c");
							report.updateTestLog("Verify Fetch Record",
									"Record has been fetched successfully:::" + recordID, Status.PASS);
						}  else if (fieldname.equals("WhatId")) {
							recordID = (String) record.getField("WhatId");
							report.updateTestLog("Verify Fetch Record",
									"Record has been fetched successfully:::" + recordID, Status.PASS);
						} else if (fieldname.equals("WhoId")) {
							recordID = (String) record.getField("WhoId");
							report.updateTestLog("Verify Fetch Record",
									"Record has been fetched successfully:::" + recordID, Status.PASS);
						} else if (fieldname.equals("Account__c")) {
							recordID = (String) record.getField("Account__c");
							report.updateTestLog("Verify Fetch Record",
									"Record has been fetched successfully:::" + recordID, Status.PASS);
						} else if (fieldname.equals("Status")) {
							recordID = (String) record.getField("Status");
							report.updateTestLog("Verify Fetch Record",
									"Record has been fetched successfully:::" + recordID, Status.PASS);
						} else if (fieldname.equals("AccountRelatedTo__c")) {
							recordID = (String) record.getField("AccountRelatedTo__c");
							report.updateTestLog("Verify Fetch Record",
									"Record has been fetched successfully:::" + recordID, Status.PASS);
						} else if (fieldname.equals("ContactRelatedTo__c")) {
							recordID = (String) record.getField("ContactRelatedTo__c");
							report.updateTestLog("Verify Fetch Record",
									"Record has been fetched successfully:::" + recordID, Status.PASS);
						} else if (fieldname.equals("LeadRelatedTo__c")) {
							recordID = (String) record.getField("LeadRelatedTo__c");
							report.updateTestLog("Verify Fetch Record",
									"Record has been fetched successfully:::" + recordID, Status.PASS);
						} else if (fieldname.equals("OpportunityRelatedTo__c")) {
							recordID = (String) record.getField("OpportunityRelatedTo__c");
							report.updateTestLog("Verify Fetch Record",
									"Record has been fetched successfully:::" + recordID, Status.PASS);
						} else if (fieldname.equals("PropertyRelatedTo__c")) {
							recordID = (String) record.getField("PropertyRelatedTo__c");
							report.updateTestLog("Verify Fetch Record",
									"Record has been fetched successfully:::" + recordID, Status.PASS);
						} else if (fieldname.equals("CBRE_Professional__c")) {
							recordID = (String) record.getField("CBRE_Professional__c");
							report.updateTestLog("Verify Fetch Record",
									"Record has been fetched successfully:::" + recordID, Status.PASS);
						} else if (fieldname.equals("FirstName")) {
							recordID = (String) record.getField("FirstName");
							report.updateTestLog("Verify Fetch Record",
									"Record has been fetched successfully:::" + recordID, Status.PASS);
						} else if (fieldname.equals("NumberOfContacts")) {
							recordID = (String) record.getField("NumberOfContacts");
							report.updateTestLog("Verify Fetch Record",
									"Record has been fetched successfully:::" + recordID, Status.PASS);
						} else if (fieldname.equals("NumberOfLeads")) {
							recordID = (String) record.getField("NumberOfLeads");
							report.updateTestLog("Verify Fetch Record",
									"Record has been fetched successfully:::" + recordID, Status.PASS);
						} else if (fieldname.equals("Number_of_Contacts__c")) {
							recordID = (String) record.getField("Number_of_Contacts__c");
							report.updateTestLog("Verify Fetch Record",
									"Record has been fetched successfully:::" + recordID, Status.PASS);
						} else if (fieldname.equals("Outcome_Color__c")) {
							recordID = (String) record.getField("Outcome_Color__c");
							report.updateTestLog("Verify Fetch Record",
									"Record has been fetched successfully:::" + recordID, Status.PASS);
						}  else if (fieldname.equals("LeadSource")) {
							recordID = (String) record.getField("LeadSource");
							report.updateTestLog("Verify Fetch Record",
									"Record has been fetched successfully:::" + recordID, Status.PASS);
						} else if (fieldname.equals("Total_Property_SF__c")) {
							recordID = (String) record.getField("Total_Property_SF__c");
							report.updateTestLog("Verify Fetch Record",
									"Record has been fetched successfully:::" + recordID, Status.PASS);
						} else if (fieldname.equals("Property_Type__c")) {
							recordID = (String) record.getField("Property_Type__c");
							report.updateTestLog("Verify Fetch Record",
									"Record has been fetched successfully:::" + recordID, Status.PASS);
						} else if (fieldname.equals("Assignment_Start_Date__c")) {
							recordID = (String) record.getField("Assignment_Start_Date__c");
							report.updateTestLog("Verify Fetch Record",
									"Record has been fetched successfully:::" + recordID, Status.PASS);
						} else if (fieldname.equals("Assignment_End_Date__c")) {
							recordID = (String) record.getField("Assignment_End_Date__c");
							report.updateTestLog("Verify Fetch Record",
									"Record has been fetched successfully:::" + recordID, Status.PASS);
						} else if (fieldname.equals("Service_Sub_Type__c")) {
							recordID = (String) record.getField("Service_Sub_Type__c");
							report.updateTestLog("Verify Fetch Record",
									"Record has been fetched successfully:::" + recordID, Status.PASS);
						} else {
							recordID = (String) record.getField("Id");
							report.updateTestLog("Verify Fetch Record",
									"Record has been fetched successfully:::" + recordID, Status.PASS);
						} 
						System.out.println("###### record.Id: " + (String) record.getField("Id"));
						System.out.println("###### record.Name: " + (String) record.getField("Name"));
						if (recordID != null) {
							done = true;
							break;
						}
					}
					if (result.isDone()) {
						done = true;
					} else {
						result = EstablishConnection.connection.queryMore(result.getQueryLocator());
					}
				}
			}			
		} catch (Exception ex) {
			report.updateTestLog("Verify Fetch Record", "Record fetchfailed:::" + recordID, Status.WARNING);
		}
		return recordID;
	}
	
	public String fetchRecordFieldValueAdminLogin(String FieldName, String Query) {
		String recordID = null;
		String fieldname = FieldName;
		try {
			establishConnection.establishConnectionAdminLogin();
			String query = Query;
			QueryResult result = EstablishConnection.connection.query(query);
			if (result.getSize() > 0) {
				boolean done = false;
				while (!done) {
					for (SObject record : result.getRecords()) {
						if (fieldname.equalsIgnoreCase("Name")) {
							recordID = (String) record.getField("Name");
							report.updateTestLog("Verify Fetch Record",
									"Record has been fetched successfully:::" + recordID, Status.PASS);
						} else if (fieldname.equalsIgnoreCase("Id")) {
							recordID = (String) record.getField("Id");
							report.updateTestLog("Verify Fetch Record",
									"Record has been fetched successfully:::" + recordID, Status.PASS);
						} 
						System.out.println("###### record.Id: " + (String) record.getField("Id"));
						System.out.println("###### record.Name: " + (String) record.getField("Name"));
						if (recordID != null) {
							done = true;
							break;
						}
					}
					if (result.isDone()) {
						done = true;
					} else {
						result = EstablishConnection.connection.queryMore(result.getQueryLocator());
					}
				}
			}			
		} catch (Exception ex) {
			report.updateTestLog("Verify Fetch Record", "Record fetchfailed:::" + recordID, Status.WARNING);
		}
		return recordID;
	}

	/**
	 * Function for uploading an Attachment
	 * 
	 * @author Vishnuvardhan
	 *
	 */

	public void uploadAttachment() {
		establishConnection.establishConnection();
		String accountID = fetchRecord("Account", "Id");
		System.out.println(accountID);
		byte[] inbuff = null;
		String fileName = new File("src/test/resources/SampleDocument.doc").getAbsolutePath();

		/*
		 * File fileName = new File("..\\SampleDocument.doc"); String path =
		 * fileName.getPath();
		 */
		InputStream inputStream;
		try {
			inputStream = new FileInputStream(fileName);
			inbuff = new byte[(int) fileName.length()];
			try {
				inputStream.read(inbuff);
			} catch (IOException e) {
				e.printStackTrace();
			}
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		}

		SObject attachment = new SObject();
		attachment.setType("Attachment");

		attachment.setField("Body", inbuff);
		attachment.setField("ParentID", accountID);

		attachment.setField("Name", "SampleDocument.doc");

		SObject[] attachments = new SObject[1];
		attachments[0] = attachment;
		try {
			results = EstablishConnection.connection.create(attachments);
		} catch (ConnectionException e) {
			e.printStackTrace();
		}
		System.out.println("Result:::" + results);
		status = establishConnection.saveResults(results);
	}

	/**
	 * Function for uploading File
	 * 
	 * @author Vishnuvardhan
	 *
	 */
	public void uploadFile() {
		establishConnection.establishConnection();
		String accountID = fetchRecord("Account", "Id");
		System.out.println(accountID);
		byte[] inbuff = null;
		String fileName = new File("src/test/resources/SampleDocument.doc").getAbsolutePath();
		InputStream inputStream;
		try {
			inputStream = new FileInputStream(fileName);
			inbuff = new byte[(int) fileName.length()];
			try {
				inputStream.read(inbuff);
			} catch (IOException e) {
				e.printStackTrace();
			}
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		}

		SObject file = new SObject();
		file.setType("Attachment");

		file.setField("Body", inbuff);
		file.setField("ParentID", accountID);

		file.setField("Name", "SampleDocument.doc");

		SObject[] files = new SObject[1];
		files[0] = file;
		try {
			results = EstablishConnection.connection.create(files);
		} catch (ConnectionException e) {
			e.printStackTrace();
		}
		System.out.println("Result:::" + results);
		status = establishConnection.saveResults(results);
	}

	/**
	 * Function for uploading File
	 * 
	 * @author Vishnuvardhan
	 *
	 */
	public void uploadFileToOpportunity() {
		establishConnection.establishConnection();
		String accountID = fetchRecord("Opportunity", "Id");
		System.out.println(accountID);
		byte[] inbuff = null;
		String fileName = new File("src/test/resources/Sample Test Automation.txt").getAbsolutePath();
		InputStream inputStream;
		try {
			inputStream = new FileInputStream(fileName);
			inbuff = new byte[(int) fileName.length()];
			try {
				inputStream.read(inbuff);
			} catch (IOException e) {
				e.printStackTrace();
			}
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		}

		SObject file = new SObject();
		file.setType("Attachment");

		file.setField("Body", inbuff);
		file.setField("ParentID", accountID);

		file.setField("Name", "SampleDocument.doc");

		SObject[] files = new SObject[1];
		files[0] = file;
		try {
			results = EstablishConnection.connection.create(files);
		} catch (ConnectionException e) {
			e.printStackTrace();
		}
		System.out.println("Result:::" + results);
		status = establishConnection.saveResults(results);
	}

	/**
	 * Function for uploading File
	 * 
	 * @author Vishnuvardhan
	 *
	 */
	public void AddNoteToOpportunity() {
		establishConnection.establishConnection();
		String accountID = fetchRecord("Opportunity", "Id");
		System.out.println(accountID);
	/*	byte[] inbuff = null;
		String fileName = new File("src/test/resources/Sample Test Automation.txt").getAbsolutePath();
		InputStream inputStream;
		try {
			inputStream = new FileInputStream(fileName);
			inbuff = new byte[(int) fileName.length()];
			try {
				inputStream.read(inbuff);
			} catch (IOException e) {
				e.printStackTrace();
			}
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		}*/
		
		String txtBody="Test notes body";

		SObject file = new SObject();
		file.setType("Note");

		file.setField("Body", txtBody);
		file.setField("ParentID", accountID);

		file.setField("Title", "SampleDocument.doc");

		SObject[] files = new SObject[1];
		files[0] = file;
		try {
			results = EstablishConnection.connection.create(files);
		} catch (ConnectionException e) {
			e.printStackTrace();
		}
		System.out.println("Result:::" + results);
		status = establishConnection.saveResults(results);
	}

	public void contentDocumentLink() {
		establishConnection.establishConnection();
		String accountID = fetchRecord("Account", "Id");
		/*
		 * String query = "Select Id from ContentDocument"; String
		 * contentDocumentID = fetchRecordFieldValue("Id", query);
		 */
		System.out.println(accountID);
		// System.out.println(contentDocumentID);

		SObject contentDocumentLink = new SObject();
		contentDocumentLink.setType("ContentDocumentLink");

		contentDocumentLink.setField("ContentDocumentId", "0690S0000004WkFQAU");
		contentDocumentLink.setField("LinkedEntityID", accountID);
		contentDocumentLink.setField("ShareType", "V");
		SObject[] contentDocumentLinks = new SObject[1];
		contentDocumentLinks[0] = contentDocumentLink;
		try {
			results = EstablishConnection.connection.create(contentDocumentLinks);
		} catch (ConnectionException e) {
			e.printStackTrace();
		}
		System.out.println("Result:::" + results);
		status = establishConnection.saveResults(results);
	}
	
	public SObject fetchCountryAndUOMForUser(String username) {
		QueryResult result = null;
		try {
			establishConnection.establishConnection();
			String query = "SELECT Id, Username, Country, UoM__c FROM user WHERE Username = '"+username+"'";
			result = EstablishConnection.connection.query(query);
			if (result.getSize() > 0) {
				boolean done = false;
				while (!done) {
					if (result.isDone()) {
						done = true;
					} else {
						result = EstablishConnection.connection.queryMore(result.getQueryLocator());
					}
				}
			}
		} catch (Exception ex) {
			System.out.println("Exception in main : " + ex);
		}
		return result.getRecords()[0];
		//(String) record.getField("UoM__c"));
	}
	
	public Map<String, String> fetchAllUsersFromCountry(String country) {
		Map<String, String> recordID = new HashMap<String, String>();
		QueryResult result = null;
		try {
			establishConnection.establishConnection();
			String query = "SELECT Id, Username, UoM__c FROM user WHERE Country = '"+country+"'";
			result = EstablishConnection.connection.query(query);
			if (result.getSize() > 0) {
				boolean done = false;
				while (!done) {
					for (SObject record : result.getRecords()) {
						recordID.put((String) record.getField("Id"), (String) record.getField("UoM__c"));
					}
					if (result.isDone()) {
						done = true;
					} else {
						result = EstablishConnection.connection.queryMore(result.getQueryLocator());
					}
				}
			}
		} catch (Exception ex) {
			System.out.println("Exception in main : " + ex);
		}
		return recordID;
	}
}
