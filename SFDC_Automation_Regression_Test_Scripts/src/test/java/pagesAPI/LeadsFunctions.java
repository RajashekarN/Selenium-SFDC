package pagesAPI;

import java.util.ArrayList;

import org.openqa.selenium.support.PageFactory;
import com.cognizant.Craft.ReusableLibrary;
import com.cognizant.Craft.ScriptHelper;
import com.cognizant.framework.Status;
import com.sforce.soap.partner.DeleteResult;
import com.sforce.soap.partner.DescribeLayout;
import com.sforce.soap.partner.DescribeLayoutResult;
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
		PageFactory.initElements(driver.getWebDriver(), this);
		// new WebDriverUtil(driver);
		// Utility_Functions utility = new Utility_Functions(scriptHelper);
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

	public String createNewLead() {
		String resultId = null;
		establishConnection.establishConnection();
		SObject lead = new SObject();
		lead.setType("Lead");
		lead.setField("FirstName", Utility_Functions.xGenerateAlphaNumericString() + "_" + "First Name");
		lead.setField("LastName", Utility_Functions.xGenerateAlphaNumericString() + "_" + "Second Name");
		lead.setField("Phone", dataTable.getData("General_Data", "Direct Line"));
		SearchTextSOQL companyName = new SearchTextSOQL(scriptHelper);
		String company_Name = companyName.fetchRecord("Lead", "Name");
		lead.setField("Company", company_Name);
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

	public void leadPageFieldsValidation() {
		establishConnection.establishConnection();
		CMAPACHeadings();
		DescribeLayoutResult dlr = null;
		try {
			dlr = EstablishConnection.connection.describeLayout("Lead", null, null);
		} catch (ConnectionException e) {
			e.printStackTrace();
		}
		int count = 0;
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
		}
		if (dataTable.getData("General_Data", "TC_ID").contains("CMAPAC")) {
			if (count == 5) {
				CMAPACHeader.clear();
				System.out.println("Capital Markets APAC have all the header sections present::");
				report.updateTestLog("Validating Header Sections", "Capital Markets APAC - All the headers are present",
						Status.PASS);
			}
		}
	}

	/**
	 * Function for Lead Conversion
	 * 
	 * @author Vishnuvardhan
	 *
	 */

	public void leadConversion() {
		SObject leadConvert = new SObject();
		leadConvert.setType("Lead");
		String sLeadID = createNewLeadConversion();
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

}