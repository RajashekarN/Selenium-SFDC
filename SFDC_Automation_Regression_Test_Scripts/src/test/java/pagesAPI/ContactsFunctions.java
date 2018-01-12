package pagesAPI;


import java.util.ArrayList;
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
import com.sforce.soap.partner.sobject.SObject;
import com.sforce.ws.ConnectionException;

import supportLibraries.Utility_Functions;


public class ContactsFunctions extends ReusableLibrary {
	/*
	 * Constructor to initialize the business component library
	 * 
	 * @param scriptHelper The {@link ScriptHelper} object passed from the
	 * {@link DriverScript}
	 */

	public ContactsFunctions(ScriptHelper scriptHelper) {
		super(scriptHelper);
	}

	static SaveResult[] results;
	static DeleteResult[] deleteResults;
	static com.sforce.soap.partner.Error[] errors;
	static boolean status = false;

	EstablishConnection establishConnection = new EstablishConnection(scriptHelper);

	/**
	 * Function for the creation of the Contact
	 * 
	 * @author Vishnuvardhan
	 *
	 */	

	public boolean createContacts() {
		try {
			establishConnection.establishConnection();
			SObject contact = new SObject();

			contact.setType("Contact");
			contact.setField("FirstName", dataTable.getData("General_data", "FirstName"));
			contact.setField("LastName", dataTable.getData("General_data", "LastName"));
			contact.setField("Salutation", dataTable.getData("General_data", "Salutation"));
			contact.setField("Phone", dataTable.getData("General_data", "Phone"));
			contact.setField("Title", dataTable.getData("General_data", "Title"));

			SObject[] contacts = new SObject[1];
			contacts[0] = contact;
			results = EstablishConnection.connection.create(contacts);
			System.out.println("Result:::" + results);
			status = establishConnection.saveResults(results);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return status;
	}


	/**
	 * Function for updating the Contact
	 * 
	 * @author Vishnuvardhan
	 *
	 */	
	public boolean updateContacts() {
		try {
			establishConnection.establishConnection();
			SObject[] records = new SObject[1];
			QueryResult queryResults = EstablishConnection.connection.query("SELECT Id, Name FROM Contact ORDER BY CreatedDate DESC LIMIT 1");
			if (queryResults.getSize() > 0) {
				for (int i = 0; i < queryResults.getRecords().length; i++) {
					SObject so = (SObject) queryResults.getRecords()[i];
					SObject soUpdate = new SObject();
					soUpdate.setType("Contact");
					soUpdate.setId(so.getId());
					//soUpdate.setField("Name", dataTable.getData("General_Data", "Name") + "-- Updated");
					soUpdate.setField("LastName", so.getField("LastName")+"--UPDATED");
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
	 * Function for deleting the Contact
	 * 
	 * @author Vishnuvardhan
	 *
	 */	

	public boolean deleteContacts() {
		try {
			establishConnection.establishConnection();
			String[] records = new String[1];
			QueryResult queryResults = EstablishConnection.connection.query("SELECT Id, Name FROM Contact ORDER BY CreatedDate DESC LIMIT 1");
			if (queryResults.getSize() > 0) {
				for (int i = 0; i < queryResults.getRecords().length; i++) {
					SObject so = (SObject) queryResults.getRecords()[i];
					records[i] = so.getId();		            
					System.out.println("Deleting Id: " + so.getId() + " - Name: "+so.getField("Name"));
					report.updateTestLog("Verify Delete Contact", "Contact has been deleted successfully:::" + "Deleting Id: " + so.getId() + " - Name: "+so.getField("Name"), Status.PASS);
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
	 * Function for the validating the fields on the Contacts Page
	 * 
	 * @author Vishnuvardhan
	 *
	 */	

	static ArrayList<String> ABAMERHeader = new ArrayList<String>();

	public void ABAMERHeadings() {
		ABAMERHeader.add("Contact Information");
		ABAMERHeader.add("Communication Preferences");
		ABAMERHeader.add("Address Information");
		ABAMERHeader.add("Additional Information");
		ABAMERHeader.add("System Information");
		System.out.println("ABAMER Headers List are::" + ABAMERHeader);
	}

	static ArrayList<String> OBAPACHeader = new ArrayList<String>();

	public void OBAPACHeaders() {
		OBAPACHeader.add("Contact Information");
		OBAPACHeader.add("Address Information");
		OBAPACHeader.add("Additional Information");
		OBAPACHeader.add("System Information");
		System.out.println("OBAPAC Headers List are::" + OBAPACHeader);
	}

	static ArrayList<String> AdminHeader = new ArrayList<String>();

	public void AdminHeaders() {
		AdminHeader.add("Contact Information");
		//AdminHeader.add("Communication Preferences");
		AdminHeader.add("Address Information");
		AdminHeader.add("Additional Information");
		AdminHeader.add("Employee User Record");
		AdminHeader.add("System Information");
		System.out.println("AdminHeaders List are::" + AdminHeader);
	}

	static ArrayList<String> ABAMERField = new ArrayList<String>();

	public void ABAMERFields() {
		ABAMERField.add("Name");
		ABAMERField.add("AccountId");
		ABAMERField.add("Middle_Name__c");
		ABAMERField.add("Phone");
		ABAMERField.add("Nickname__c");
		ABAMERField.add("MobilePhone");
		ABAMERField.add("Title");
		ABAMERField.add("Main_Phone__c");
		ABAMERField.add("Department__c");
		ABAMERField.add("Email");
		ABAMERField.add("Influence_Level__c");
		ABAMERField.add("Status__c");
		ABAMERField.add("ReportsToId");
		ABAMERField.add("Inactive_Contact__c");
		ABAMERField.add("DoNotCall");
		ABAMERField.add("RecordTypeId");
		ABAMERField.add("Fee_Share_Partner__c");
		ABAMERField.add("Email_Options__c");
		ABAMERField.add("Mail_Options__c");
		ABAMERField.add("Call_Options__c");
		ABAMERField.add("MailingAddress");
		ABAMERField.add("Fax");
		ABAMERField.add("Assistant_Name__c");
		ABAMERField.add("Preferred_Comm_Method__c");
		ABAMERField.add("Assistant_Phone__c");
		ABAMERField.add("Comm_Email_Sent__c");
		ABAMERField.add("Assistant_Email__c");
		ABAMERField.add("Reason_for_Inactivating__c");
		ABAMERField.add("Inactivation_Date__c");
		ABAMERField.add("OwnerId");
		ABAMERField.add("Last_Manually_Modified_Date__c");
		ABAMERField.add("Last_Manually_Modified_By__c");
		System.out.println("Agency Brokerage AMER Fields List are::" + ABAMERField);		
	}

	static ArrayList<String> OBAPACField = new ArrayList<String>();

	public void OBAPACFields() {
		OBAPACField.add("Name");
		OBAPACField.add("AccountId");
		OBAPACField.add("Middle_Name__c");
		OBAPACField.add("Phone");
		OBAPACField.add("Title");
		OBAPACField.add("Main_Phone__c");
		OBAPACField.add("SF_INTG_DATASRC_CREATEDBY_COUNTRY__c");
		OBAPACField.add("Email");
		OBAPACField.add("SF_INTG_DATASRC_LASTUPDATEDBY_COUNTRY__c");
		OBAPACField.add("Status__c");
		OBAPACField.add("RecordTypeId");
		OBAPACField.add("MailingAddress");
		OBAPACField.add("Integration_Id__c");
		OBAPACField.add("Inactive_Date__c");
		OBAPACField.add("Preferred_Comm_Method__c");
		OBAPACField.add("Employee_Flag__c");
		OBAPACField.add("Comm_Email_Sent__c");
		OBAPACField.add("Source_Created_Date_Time__c");
		OBAPACField.add("Reason_for_Inactivating__c");
		OBAPACField.add("Source_Last_Updated_Date_Time__c");
		OBAPACField.add("Inactivation_Date__c");
		OBAPACField.add("OwnerId");
		OBAPACField.add("Last_Manually_Modified_Date__c");
		OBAPACField.add("Last_Manually_Modified_By__c");

		System.out.println("OB APAC Fields List are::" + OBAPACField);		

	}

	static ArrayList<String> AdminField = new ArrayList<String>();

	public void AdminFields() {
		AdminField.add("Name");
		AdminField.add("AccountId");
		AdminField.add("Middle_Name__c");
		AdminField.add("Phone");
		AdminField.add("Title");
		AdminField.add("Main_Phone__c");
		AdminField.add("APAC_Exclude_Reason__c");
		AdminField.add("Email");
		AdminField.add("APAC_Excluded_On__c");
		AdminField.add("Status__c");
		AdminField.add("APAC_Excluded_By__c");
		AdminField.add("RecordTypeId");
		AdminField.add("DoNotCall");
		AdminField.add("HasOptedOutOfEmail");
		AdminField.add("MailingAddress");
		AdminField.add("Integration_Id__c");
		AdminField.add("Inactive_Date__c");
		AdminField.add("Preferred_Comm_Method__c");
		AdminField.add("Employee_Flag__c");
		AdminField.add("Comm_Email_Sent__c");
		AdminField.add("Source_Created_Date_Time__c");
		AdminField.add("Reason_for_Inactivating__c");
		AdminField.add("Source_Last_Updated_Date_Time__c");
		AdminField.add("Inactivation_Date__c");
		AdminField.add("APAC_Dietary_Requirements__c");
		AdminField.add("Employee_User__c");
		AdminField.add("Employee_Id__c");
		AdminField.add("Bypass_Validation__c");
		AdminField.add("Last_Manually_Modified_Date__c");
		AdminField.add("OwnerId");
		AdminField.add("Last_Manually_Modified_By__c");
		AdminField.add("Source_System__c");
		System.out.println("Admin Fields List are::" + AdminField);		

	}

	static ArrayList<String> CMAPACField = new ArrayList<String>();

	public void CMAPACFields() {
		OBAPACField.add("Name");
		OBAPACField.add("AccountId");
		OBAPACField.add("Middle_Name__c");
		OBAPACField.add("Phone");
		OBAPACField.add("Title");
		OBAPACField.add("Main_Phone__c");
		OBAPACField.add("SF_INTG_DATASRC_CREATEDBY_COUNTRY__c");
		OBAPACField.add("Email");
		OBAPACField.add("SF_INTG_DATASRC_LASTUPDATEDBY_COUNTRY__c");
		OBAPACField.add("Status__c");
		OBAPACField.add("RecordTypeId");
		OBAPACField.add("MailingAddress");
		OBAPACField.add("Integration_Id__c");
		OBAPACField.add("Inactive_Date__c");
		OBAPACField.add("Preferred_Comm_Method__c");
		OBAPACField.add("Employee_Flag__c");
		OBAPACField.add("Comm_Email_Sent__c");
		OBAPACField.add("Source_Created_Date_Time__c");
		OBAPACField.add("Reason_for_Inactivating__c");
		OBAPACField.add("Source_Last_Updated_Date_Time__c");
		OBAPACField.add("Inactivation_Date__c");
		OBAPACField.add("OwnerId");
		OBAPACField.add("Last_Manually_Modified_Date__c");
		OBAPACField.add("Last_Manually_Modified_By__c");

		System.out.println("OB APAC Fields List are::" + OBAPACField);		

	}


	static ArrayList<String> ABAMERFieldLabelsAPI = new ArrayList<String>();
	static ArrayList<String> OBAPACFieldLabelsAPI = new ArrayList<String>();
	static ArrayList<String> AdminFieldLabelsAPI = new ArrayList<String>();

	public void contactsPageFieldsValidation() {
		try {
			establishConnection.establishConnection();
			ABAMERHeadings();
			ABAMERFields();
			OBAPACHeaders();
			OBAPACFields();
			AdminHeaders();
			AdminFields();
			DescribeLayoutResult dlr = EstablishConnection.connection.describeLayout("Contact", null, null);
			int count=0, countLabelList = 0;
			for (int i = 0; i < dlr.getLayouts().length; i++) {
				DescribeLayout layout = dlr.getLayouts()[i];
				DescribeLayoutSection[] editLayoutSectionList = layout.getEditLayoutSections();
				// Write the headings of the edit layout sections
				for (int x = 0; x < editLayoutSectionList.length; x++) {
					if((dataTable.getData("General_Data", "TC_ID").contains("ABAMER")) || (dataTable.getData("General_Data", "TC_ID").contains("OBAMER")) && (!dataTable.getData("General_Data", "TC_ID").contains("Admin"))) {
						if(editLayoutSectionList.length==5) {
							if(editLayoutSectionList[x].getHeading().equals(ABAMERHeader.get(x))) {
								System.out.println(x + ":::Agency Brokerage/Occupier Brokerage AMER has the heading layout section:::" + editLayoutSectionList[x].getHeading());
								report.updateTestLog(x + ":::Agency Brokerage/Occupier Brokerage AMER", " has the heading layout section:::" + editLayoutSectionList[x].getHeading(), Status.PASS);
								count++;
							}
						}				
					}			
					if((dataTable.getData("General_Data", "TC_ID").contains("OBAPAC")) || (dataTable.getData("General_Data", "TC_ID").contains("CMAPAC"))) {
						if(editLayoutSectionList.length==4) {
							if(editLayoutSectionList[x].getHeading().equals(OBAPACHeader.get(x))) {
								System.out.println(x + ":::Occupier Brokerage/Capital Markets APAC has the heading layout section:::" + editLayoutSectionList[x].getHeading());
								report.updateTestLog(x + ":::Occupier Brokerage/Capital Markets APAC", " has the heading layout section:::" + editLayoutSectionList[x].getHeading(), Status.PASS);
								count++;
							}
						}				
					}	
					if(dataTable.getData("General_Data", "TC_ID").contains("Admin")) {
						if(editLayoutSectionList.length==5) {
							if(editLayoutSectionList[x].getHeading().equals(AdminHeader.get(x))) {
								System.out.println(x + ":::Admin has the heading layout section:::" + editLayoutSectionList[x].getHeading());
								report.updateTestLog(x + ":::Admin", " has the heading layout section:::" + editLayoutSectionList[x].getHeading(), Status.PASS);
								count++;
							}
						}				
					}	
				}	
				System.out.println(count);			
				if((dataTable.getData("General_Data", "TC_ID").contains("ABAMER")) || (dataTable.getData("General_Data", "TC_ID").contains("OBAMER")) && (!dataTable.getData("General_Data", "TC_ID").contains("Admin"))) {
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
										ABAMERFieldLabelsAPI.add(li.getLayoutComponents()[0].getValue());
									}
								}
							}
						}	
						System.out.println("ABAMER Field Label::: " + ABAMERFieldLabelsAPI);
						for(int i1=0; i1 < ABAMERField.size(); i1++) {
							if(ABAMERFieldLabelsAPI.get(i1).equals(ABAMERField.get(i1))) {						
								System.out.println("Field Label:::" + ABAMERFieldLabelsAPI.get(i1) + " -- is present in CM APAC:::");
								report.updateTestLog("Verify Field Labels", " has the field label:::" + ABAMERFieldLabelsAPI.get(i1), Status.PASS);
								countLabelList++;
							}			 
						}
						System.out.println("Count of fields present in Agency/Occupier Brokerage AMER::" + countLabelList);
					}
				}				
				if((dataTable.getData("General_Data", "TC_ID").contains("OBAPAC")) || (dataTable.getData("General_Data", "TC_ID").contains("CMAPAC"))) {
					if(editLayoutSectionList.length==4) {
						for (int k = 0; k < editLayoutSectionList.length; k++) {
							DescribeLayoutSection els = editLayoutSectionList[k];
							DescribeLayoutRow[] dlrList = els.getLayoutRows();
							for (int m = 0; m < dlrList.length; m++) {
								DescribeLayoutRow lr = dlrList[m];
								DescribeLayoutItem[] dliList = lr.getLayoutItems();
								for (int n = 0; n < dliList.length; n++) {
									DescribeLayoutItem li = dliList[n];
									if ((li.getLayoutComponents() != null) && (li.getLayoutComponents().length > 0)) {
										OBAPACFieldLabelsAPI.add(li.getLayoutComponents()[0].getValue());
									}
								}
							}
						}	
						System.out.println("OBAPAC Field Label::: " + OBAPACFieldLabelsAPI);
						for(int i1=0; i1 < OBAPACField.size(); i1++) {
							if(OBAPACFieldLabelsAPI.get(i1).equals(OBAPACField.get(i1))) {						
								System.out.println("Field Label:::" + OBAPACFieldLabelsAPI.get(i1) + " -- is present in CM APAC:::");
								report.updateTestLog("Verify Field Labels", " has the field label:::" + OBAPACFieldLabelsAPI.get(i1), Status.PASS);
								countLabelList++;
							}			 
						}
						System.out.println("Count of fields present in Occupier Brokerage/Capital Markets APAC::" + countLabelList);
					}
				}	
				if(dataTable.getData("General_Data", "TC_ID").contains("Admin")) {
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
										AdminFieldLabelsAPI.add(li.getLayoutComponents()[0].getValue());
									}
								}
							}
						}	
						System.out.println("Admin Field Label::: " + AdminFieldLabelsAPI);
						for(int i1=0; i1 < AdminField.size(); i1++) {
							if(AdminFieldLabelsAPI.get(i1).equals(AdminField.get(i1))) {						
								System.out.println("Field Label:::" + AdminFieldLabelsAPI.get(i1) + " -- is present in Admin:::");
								report.updateTestLog("Verify Field Labels", " has the field label:::" + AdminFieldLabelsAPI.get(i1), Status.PASS);
								countLabelList++;
							}			 
						}
						System.out.println("Count of fields present in Admin::" + countLabelList);
					}
				}	
			}				
			if((dataTable.getData("General_Data", "TC_ID").contains("ABAMER")) || (dataTable.getData("General_Data", "TC_ID").contains("OBAMER"))) {
				if(count==5) {
					ABAMERHeader.clear();
					System.out.println("Agency Brokerage AMER have all the header sections present::");
					report.updateTestLog("Validating Header Sections", "Admin/Agency Brokerage/Occupier Brokerage AMER - All the headers are present", Status.PASS);
					ABAMERHeader.clear();				
				}								
			} else if((dataTable.getData("General_Data", "TC_ID").contains("OBAPAC")) || (dataTable.getData("General_Data", "TC_ID").contains("CMAPAC"))) {
				if(count==4) {
					OBAPACHeader.clear();
					System.out.println("Capital Markets APAC have all the header sections present::");
					report.updateTestLog("Validating Header Sections", "Occupier Brokerage/Capital Markets APAC - All the headers are present", Status.PASS);
					OBAPACHeader.clear();				
				}								
			}
			ABAMERField.clear();
			OBAPACField.clear();
			AdminField.clear();
			if (countLabelList == 32) {
				System.out.println("All the fields are present::");
				report.updateTestLog("Count of fields present", "All the fields are present in Agency Brokerage/ Occupier Brokerage/ Admin AMER", Status.PASS);
			} else if (countLabelList == 24) {
				System.out.println("All the fields are present::");
				report.updateTestLog("Count of fields present", "All the fields are present in Occupier Brokerage/ Capital Markets APAC", Status.PASS);
			} 		
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	/**
	 * Function for the creation of Contacts providing required fields
	 * 
	 * @author Vishnuvardhan
	 *
	 */
	
	public String createContactRequiredFields() {
		establishConnection.establishConnection();
		SObject contact = new SObject();
		contact.setType("Contact");
		contact.setField("LastName", Utility_Functions.xRandomFunction() + "_" + dataTable.getData("General_data", "Last Name") );
		contact.setField("Salutation", "Mr.");
		SearchTextSOQL accountID = new SearchTextSOQL(scriptHelper);
		String accountId = accountID.fetchRecord("Account", "Id");
		contact.setField("AccountId", accountId);
		SObject[] contacts = new SObject[1];
		contacts[0] = contact;
		try {
			results = EstablishConnection.connection.create(contacts);
		} catch (ConnectionException e) {
			e.printStackTrace();
		}
		System.out.println("Result:::" + results);
		String contactId = establishConnection.saveResultsId(results);
		if(contactId.startsWith("003")) {
				report.updateTestLog("Verify Create Contact", "Contact has been created successfully", Status.PASS);
			} else {
				report.updateTestLog("Verify Create Contact", "Contact creation failed", Status.FAIL);
			}
		return contactId;
	}
	
	/**
	 * Function for the creation of Contacts populating all fields
	 * 
	 * @author Vishnuvardhan
	 *
	 */
	
	public void createContactsPopulatingAllFields() {		
		try {
			establishConnection.establishConnection();
			SObject contact = new SObject();
			contact.setType("Contact");
			contact.setField("LastName", Utility_Functions.xRandomFunction() + "_" + dataTable.getData("General_data", "Last Name"));
			contact.setField("Middle_Name__c", dataTable.getData("General_data", "Middle Name"));
			contact.setField("Nickname__c", dataTable.getData("General_data", "Nick Name"));
			contact.setField("Title", "Sir");
			contact.setField("Direct_Line__c", dataTable.getData("General_data", "Direct Line"));
			contact.setField("Email", Utility_Functions.xRandomFunction() + "_" + "@gmail.com");
			//contact.setField("Contact_Mailing_Address__c", "2100 Ross Avenue, Dallas, TX, 75201, United States");
			contact.setField("Main_Phone__c", dataTable.getData("General_data", "Direct Line"));
			contact.setField("Department__c", dataTable.getData("General_data", "Company"));
			contact.setField("Influence_Level__c", "Medium");
			contact.setField("Email_Options__c", "Email Opt In");
			contact.setField("Mail_Options__c", "Mail Opt Out");
			contact.setField("APAC_Exclude_Reason__c", "Archieved");
			contact.setField("Salutation", "Mr.");
			SearchTextSOQL accountID = new SearchTextSOQL(scriptHelper);
			String accountId = accountID.fetchRecord("Account", "Id");
			contact.setField("AccountId", accountId);
			contact.setField("Salutation", "Mr.");
			SObject[] contacts = new SObject[1];
			contacts[0] = contact;
			results = EstablishConnection.connection.create(contacts);
			System.out.println("Result:::" + results);
			status = establishConnection.saveResults(results);
			if(status==true) {
				report.updateTestLog("Verify Create Contact", "Contact has been created successfully", Status.PASS);
			} else {
				report.updateTestLog("Verify Create Contact", "Contact creation failed", Status.FAIL);
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	
	/**
	 * Function for validating the fields in Contacts page
	 * 
	 * @author Vishnuvardhan
	 *
	 */

	/*public void contactsPageFieldsValidation() {	
		try{
			establishConnection.establishConnectionSpecificUser();
			DescribeLayoutResult dlr = EstablishConnection.connection.describeLayout("Contact", null, null);
			for(int i = 0; i < dlr.getLayouts().length; i++) {
				DescribeLayout layout = dlr.getLayouts()[i];
				DescribeLayoutSection[] detailLayoutSectionList = layout.getDetailLayoutSections();
				System.out.println(" There are " + detailLayoutSectionList.length + " detail layout sections");
				report.updateTestLog("Verify Contacts Page Field Validation", "There are " + detailLayoutSectionList.length + " detail layout sections", Status.PASS);
				DescribeLayoutSection[] editLayoutSectionList = layout.getEditLayoutSections();
				System.out.println(" There are " + editLayoutSectionList.length + " edit layout sections");
				report.updateTestLog("Verify Contacts Page Field Validation", " There are " + editLayoutSectionList.length + " edit layout sections", Status.PASS);
				for(int j = 0; j < detailLayoutSectionList.length; j++) {
					System.out.println(j +  " This detail layout section has a heading of " +detailLayoutSectionList[j].getHeading());  
					report.updateTestLog("Verify Contacts Page Field Validation", j +  " This detail layout section has a heading of " +detailLayoutSectionList[j].getHeading(), Status.PASS);
				}
				// Write the headings of the edit layout sections
				for(int x = 0; x < editLayoutSectionList.length; x++) { 
					System.out.println(x + " This edit layout section has a heading of " + editLayoutSectionList[x].getHeading());
					report.updateTestLog("Verify Contacts Page Field Validation", x + " This edit layout section has a heading of " + editLayoutSectionList[x].getHeading(), Status.PASS);
				}
				// For each edit layout section, get its details.
				for(int k = 0; k < editLayoutSectionList.length; k++) {
					DescribeLayoutSection els = editLayoutSectionList[k];   
					System.out.println("Edit layout section heading: " + els.getHeading());
					report.updateTestLog("Verify Contacts Page Field Validation", "Edit layout section heading: " + els.getHeading(), Status.PASS);
					DescribeLayoutRow[] dlrList = els.getLayoutRows();
					System.out.println("This edit layout section has " + dlrList.length + " layout rows");
					report.updateTestLog("Verify Contacts Page Field Validation", "This edit layout section has " + dlrList.length + " layout rows", Status.PASS);
					for(int m = 0; m < dlrList.length; m++) {
						DescribeLayoutRow lr = dlrList[m];
						System.out.println(" This row has " + lr.getNumItems() + " layout items");
						report.updateTestLog("Verify Contacts Page Field Validation", " This row has " + lr.getNumItems() + " layout items", Status.PASS);
						DescribeLayoutItem[] dliList = lr.getLayoutItems();
						for(int n = 0; n < dliList.length; n++) {
							DescribeLayoutItem li = dliList[n];
							if ((li.getLayoutComponents() != null) && (li.getLayoutComponents().length > 0)) {
								System.out.println("\tLayout item " + n +", layout component: " +li.getLayoutComponents()[0].getValue());
								report.updateTestLog("Verify Contacts Page Field Validation", "\tLayout item " + n +", layout component: " +li.getLayoutComponents()[0].getValue(), Status.PASS);
							}
							else {
								System.out.println("\tLayout item " + n +", no layout component");                 
								report.updateTestLog("Verify Contacts Page Field Validation", "\tLayout item " + n +", no layout component", Status.PASS);
							}     
						}
					}
				}
			} 
		}catch (Exception e){
			System.out.println(e.getMessage());
		}
	}*/
}