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
import com.sforce.soap.partner.LeadConvert;
import com.sforce.soap.partner.LeadConvertResult;
import com.sforce.soap.partner.QueryResult;
import com.sforce.soap.partner.SaveResult;
import com.sforce.soap.partner.sobject.SObject;
import com.sforce.ws.ConnectionException;

import supportLibraries.Utility_Functions;

public class LeadsFunctions extends ReusableLibrary {
	/*
	 * Constructor to initialize the business component library
	 * 
	 * @param scriptHelper The {@link ScriptHelper} object passed from the
	 * {@link DriverScript}
	 */

	public LeadsFunctions(ScriptHelper scriptHelper) {
		super(scriptHelper);
	}

	static LeadConvertResult[] leadConvertResults;
	static SaveResult[] results;
	static DeleteResult[] deleteResults;
	static com.sforce.soap.partner.Error[] errors;
	static boolean status = false;

	EstablishConnection establishConnection = new EstablishConnection(scriptHelper);
	SearchTextSOQL searchTextSOQL = new SearchTextSOQL(scriptHelper);
	AccountsFunctions accountsFunctions = new AccountsFunctions(scriptHelper);

	/**
	 * Function for the creation of Lead
	 * 
	 * @author Vishnuvardhan
	 *
	 */

	public boolean createLead() {
		establishConnection.establishConnection();
		SObject lead = new SObject();

		lead.setType("Lead");
		lead.setField("FirstName", "FirstName_AutomationAPI");
		lead.setField("LastName", "SecondName_AutomationAPI");
		SearchTextSOQL companyName = new SearchTextSOQL(scriptHelper);
		String company_Name = companyName.fetchRecord("Lead", "Name");
		lead.setField("Company", company_Name);

		SObject[] leads = new SObject[1];
		leads[0] = lead;
		try {
			results = EstablishConnection.connection.create(leads);
		} catch (ConnectionException e) {
			e.printStackTrace();
		}
		System.out.println("Result:::" + results);
		status = establishConnection.saveResults(results);
		return status;
	}

	/**
	 * Function for the creation of Lead
	 * 
	 * @author Vishnuvardhan
	 *
	 */

	public String createNewLead() {
		String resultId = null, sAccountID, sCompany_Name;
		establishConnection.establishConnection();
		SObject lead = new SObject();
		lead.setType("Lead");
		lead.setField("FirstName", Utility_Functions.xGenerateAlphaNumericString() + "_" + "First Name");
		lead.setField("LastName", Utility_Functions.xGenerateAlphaNumericString() + "_" + "Second Name");
		lead.setField("Phone", dataTable.getData("General_Data", "Direct Line"));
		SearchTextSOQL searchTextSOQL = new SearchTextSOQL(scriptHelper);
		String company_Name = searchTextSOQL.fetchRecord("Lead", "Name");
		if(company_Name==null) {
			AccountsFunctions accountsFunctions = new AccountsFunctions(scriptHelper);
			sAccountID = accountsFunctions.createAccountRequiredFields();
			String query = "Select Name from Account where Id = " + "'" + sAccountID + "'";
			sCompany_Name = searchTextSOQL.fetchRecordFieldValue("Name", query);
			lead.setField("Company", sCompany_Name);
		} else {
			lead.setField("Company", company_Name);
		}
		SObject[] leads = new SObject[1];
		leads[0] = lead;
		System.out.println(EstablishConnection.connection);
		try {
			results = EstablishConnection.connection.create(leads);
		} catch (ConnectionException e) {
			e.printStackTrace();
		}
		System.out.println("Result:::" + results);
		resultId = establishConnection.saveResultsId(results);

		return resultId;
	}

	/**
	 * Function for the creation of Lead used for Lead Conversion
	 * 
	 * @author Vishnuvardhan
	 *
	 */

	public String createNewLeadConversion() {
		String resultId = null;
		establishConnection.establishConnection();
		SObject lead = new SObject();

		lead.setType("Lead");
		lead.setField("FirstName", Utility_Functions.xGenerateAlphaNumericString() + "_" + "First Name");
		lead.setField("LastName", Utility_Functions.xGenerateAlphaNumericString() + "_" + "Second Name");
		lead.setField("Phone", dataTable.getData("General_Data", "Direct Line"));
		lead.setField("Country", dataTable.getData("General_Data", "Country"));
		lead.setField("Street", dataTable.getData("General_Data", "Street"));
		lead.setField("City", dataTable.getData("General_Data", "City"));
		lead.setField("State", dataTable.getData("General_Data", "State"));
		lead.setField("PostalCode ", dataTable.getData("General_Data", "Zipcode"));

		String accountName = accountsFunctions.createAccountRequiredFields();

		/*
		 * SearchTextSOQL companyName = new SearchTextSOQL(scriptHelper); String
		 * company_Name = companyName.fetchRecord("Lead", "Name");
		 */
		lead.setField("Company", accountName);

		SObject[] leads = new SObject[1];
		leads[0] = lead;
		System.out.println(EstablishConnection.connection);
		try {
			results = EstablishConnection.connection.create(leads);
		} catch (ConnectionException e) {
			e.printStackTrace();
		}
		System.out.println("Result:::" + results);
		resultId = establishConnection.saveResultsId(results);

		return resultId;
	}

	/**
	 * Function for updating the Lead
	 * 
	 * @author Vishnuvardhan
	 *
	 */

	public boolean updateLead() {
		try {
			establishConnection.establishConnection();
			SObject[] records = new SObject[1];
			QueryResult queryResults = EstablishConnection.connection
					.query("SELECT Id, Name FROM Lead ORDER BY CreatedDate DESC LIMIT 1");
			if (queryResults.getSize() > 0) {
				for (int i = 0; i < queryResults.getRecords().length; i++) {
					SObject so = (SObject) queryResults.getRecords()[i];
					SObject soUpdate = new SObject();
					soUpdate.setType("Lead");
					soUpdate.setId(so.getId());
					soUpdate.setField("FirstName", dataTable.getData("General_Data", "Name") + "-- Updated");
					// soUpdate.setField("FirstName", so.getField("FirstName")+"
					// -- UPDATED");
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
	 * Function for deleting the Lead
	 * 
	 * @author Vishnuvardhan
	 *
	 */

	public boolean deleteLead() {
		try {
			establishConnection.establishConnection();
			String[] records = new String[1];
			QueryResult queryResults = EstablishConnection.connection
					.query("SELECT Id, Name FROM Lead ORDER BY CreatedDate DESC LIMIT 1");
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
	 * Function for creating the lead and validating the header sections
	 * 
	 * @author Vishnuvardhan
	 *
	 */

	static ArrayList<String> CMAPACHeader = new ArrayList<String>();

	public void CMAPACHeadings() {
		CMAPACHeader.add("Lead Information");
		CMAPACHeader.add("Address Information");
		CMAPACHeader.add("Additional Information");
		CMAPACHeader.add("Communication Preferences");
		CMAPACHeader.add("System Information");
		System.out.println("CMAPAC Headers List are::" + CMAPACHeader);
	}

	static ArrayList<String> CMAPACField = new ArrayList<String>();

	public void CMAPACFields() {
		CMAPACField.add("Name");
		CMAPACField.add("LeadSource");
		CMAPACField.add("Company");
		CMAPACField.add("Status");
		CMAPACField.add("Email");
		CMAPACField.add("Rating");
		CMAPACField.add("Phone");
		CMAPACField.add("Influence_Level__c");
		CMAPACField.add("MobilePhone");
		CMAPACField.add("Requirement_Details__c");
		CMAPACField.add("Title");
		CMAPACField.add("Status_Comments__c");
		CMAPACField.add("Address");
		CMAPACField.add("Department__c");
		CMAPACField.add("Reports_To__c");
		CMAPACField.add("Nickname__c");
		CMAPACField.add("Assistant__c");
		CMAPACField.add("Website");
		CMAPACField.add("Assistant_Phone__c");
		CMAPACField.add("Assistant_Email__c");
		CMAPACField.add("APAC_Preferred_Comm_Method__c");
		CMAPACField.add("APAC_Exclude_Reason__c");
		CMAPACField.add("Email_Options__c");
		CMAPACField.add("APAC_Excluded_On__c");
		CMAPACField.add("Mail_Options__c");
		CMAPACField.add("APAC_Excluded_By__c");
		CMAPACField.add("Call_Options__c");
		CMAPACField.add("RecordTypeId");
		CMAPACField.add("OwnerId");
		CMAPACField.add("Lead_Owner_User_Market__c");

	}

	/**
	 * Function for the creation of Lead
	 * 
	 * @author Vishnuvardhan
	 *
	 */

	public void createLeadSpecificUser() {
		establishConnection.establishConnection();
		SObject lead = new SObject();

		lead.setType("Lead");
		lead.setField("FirstName",
				Utility_Functions.xGenerateAlphaNumericString() + dataTable.getData("General_Data", "First Name"));
		lead.setField("LastName",
				Utility_Functions.xGenerateAlphaNumericString() + dataTable.getData("General_Data", "Last Name"));
		SearchTextSOQL companyName = new SearchTextSOQL(scriptHelper);
		String company_Name = companyName.fetchRecord("Lead", "Name");
		lead.setField("Company", company_Name);

		SObject[] leads = new SObject[1];
		leads[0] = lead;
		try {
			results = EstablishConnection.connection.create(leads);
		} catch (ConnectionException e) {
			e.printStackTrace();
		}
		System.out.println("Result:::" + results);
		status = establishConnection.saveResults(results);
		if (status == true) {
			report.updateTestLog("Verify Create Lead", "Lead has been created successfully", Status.PASS);
		} else {
			report.updateTestLog("Verify Create Lead", "Lead creation failed", Status.FAIL);
		}
	}

	/**
	 * Function for validating the fields in Lead Layout
	 * 
	 * @author Vishnuvardhan
	 *
	 */

	static ArrayList<String> CMAPACFieldLabelsAPI = new ArrayList<String>();

	public void leadPageFieldsValidation() {
		establishConnection.establishConnection();
		CMAPACHeadings();
		CMAPACFields();
		DescribeLayoutResult dlr = null;
		try {
			dlr = EstablishConnection.connection.describeLayout("Lead", null, null);
		} catch (ConnectionException e) {
			e.printStackTrace();
		}
		int count=0, countLabelList = 0;
		for (int i = 0; i < dlr.getLayouts().length; i++) {
			DescribeLayout layout = dlr.getLayouts()[i];
			DescribeLayoutSection[] editLayoutSectionList = layout.getEditLayoutSections();
			// Write the headings of the edit layout sections
			for (int x = 0; x < editLayoutSectionList.length; x++) {
				if (dataTable.getData("General_Data", "TC_ID").contains("CMAPAC")) {
					if (editLayoutSectionList.length == 5) {
						if (editLayoutSectionList[x].getHeading().equals(CMAPACHeader.get(x))) {
							System.out.println(
									x + ":::Occupier Brokerage/Capital Markets APAC has the heading layout section:::"
											+ editLayoutSectionList[x].getHeading());
							report.updateTestLog(x + ":::Occupier Brokerage/Capital Markets APAC",
									" has the heading layout section:::" + editLayoutSectionList[x].getHeading(),
									Status.PASS);
							count++;
						}
					}
				}
			}
			System.out.println(count);
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
		}
		if (dataTable.getData("General_Data", "TC_ID").contains("CMAPAC")) {
			if (count == 5) {
				CMAPACHeader.clear();
				System.out.println("Capital Markets APAC have all the header sections present::");
				report.updateTestLog("Validating Header Sections", "Capital Markets APAC - All the headers are present",
						Status.PASS);
			}
		} 
		CMAPACField.clear();
		CMAPACFieldLabelsAPI.clear();
		if (countLabelList == 30) {
			report.updateTestLog("Count of fields present in Capital Markets APAC Manager", "All the fields are present in Capital Markets APAC Manager", Status.PASS);
		} 

	}

	/**
	 * Function for Lead Conversion
	 * 
	 * @author Vishnuvardhan
	 *
	 */

	public void leadConversion() {
		String sLeadID = null;
		SObject leadConvert = new SObject();
		leadConvert.setType("Lead");
		if(dataTable.getData("General_Data", "TC_ID").contains("ConvertLeadExisitingAccount")) {
			String leadSearch = "SELECT Id, ConvertedAccountId FROM Lead where ConvertedAccountId = null ORDER BY CreatedDate DESC LIMIT 1";
			sLeadID = searchTextSOQL.fetchRecordFieldValue("Id", leadSearch);
		} else {
			sLeadID = createNewLeadConversion();
		}
		LeadConvert leadToConvert = new LeadConvert();
		leadToConvert.setConvertedStatus("Qualified");
		leadToConvert.setLeadId(sLeadID);
		LeadConvert[] leadConverts = new LeadConvert[1];
		leadConverts[0] = leadToConvert;
		try {
			leadConvertResults = EstablishConnection.connection.convertLead(leadConverts);
		} catch (ConnectionException e) {
			e.printStackTrace();
		}
		System.out.println("Result:::" + leadConvertResults);
		String sResultID = establishConnection.leadConvertResults(leadConvertResults);
		System.out.println(sResultID);
		String sAccountID = sResultID.split("_")[0];
		String sContactID = sResultID.split("_")[1];
		String sOpportunityID = sResultID.split("_")[2];
		if ((sAccountID.startsWith("001")) && (sContactID.startsWith("003")) && (sOpportunityID.startsWith("006"))
				&& (sResultID.split("_")[3].equals(sLeadID))) {
			report.updateTestLog("Verify Create Lead", "Lead Converion is successfull", Status.PASS);
		} else {
			report.updateTestLog("Verify Create Lead", "Lead Conversion failed", Status.FAIL);
		}
	}

	/**
	 * Function for validating the fields in Leads page layout
	 * 
	 * @author Vishnuvardhan
	 *
	 */

	public void leadsFieldsValidations() {
		try {
			establishConnection.establishConnection();
			DescribeLayoutResult dlr = EstablishConnection.connection.describeLayout("Lead", null, null);
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
	}

}