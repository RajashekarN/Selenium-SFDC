package pagesAPI;

import org.openqa.selenium.support.PageFactory;
import com.cognizant.Craft.ReusableLibrary;
import com.cognizant.Craft.ScriptHelper;
import com.cognizant.framework.Status;
import com.sforce.soap.partner.DeleteResult;
import com.sforce.soap.partner.QueryResult;
import com.sforce.soap.partner.SaveResult;
import com.sforce.soap.partner.sobject.SObject;
import com.sforce.ws.ConnectionException;

public class PropertiesFunctions extends ReusableLibrary {
	/*
	 * Constructor to initialize the business component library
	 * 
	 * @param scriptHelper The {@link ScriptHelper} object passed from the
	 * {@link DriverScript}
	 */

	public PropertiesFunctions(ScriptHelper scriptHelper) {
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
	SearchTextSOQL searchTextSOQL = new SearchTextSOQL(scriptHelper);

	/**
	 * Function for the creation of Property
	 * 
	 * @author Vishnuvardhan
	 *
	 */

	public void createPropertySpecificUser() {
		establishConnection.establishConnection();
		SObject property = new SObject();

		property.setType("Property__c");
		String propertyName = searchTextSOQL.fetchRecord("Property__c", "Name");
		String query_Country = "SELECT Id, Name FROM Country__c where Name = 'Japan'";
		String query_State = "SELECT Id, Name FROM State__c where Name = 'Tokyo' ";
		String query_RecordType = "SELECT Id FROM RecordType where Name = 'APAC Property'";
		String query_PropertyType = "SELECT Property_Type__c FROM Property__c where Property_Type__c = 'Hotel'";
		String countryId = searchTextSOQL.fetchRecordFieldValue("Id", query_Country);
		String stateId = searchTextSOQL.fetchRecordFieldValue("Id", query_State);
		String recordTypeId = searchTextSOQL.fetchRecordFieldValue("Id", query_RecordType);
		String propertyType = searchTextSOQL.fetchRecordFieldValue("Property_Type__c", query_PropertyType);
		property.setField("Building_Property_Name__c", propertyName);
		property.setField("Property_Type__c", propertyType);
		property.setField("RecordTypeId", recordTypeId);
		property.setField("Country__c", countryId);
		property.setField("Street__c", dataTable.getData("General_Data", "Street"));
		property.setField("City__c", dataTable.getData("General_Data", "City"));
		property.setField("State__c", stateId);
		property.setField("Zip_Postal_Code__c ", "100-001");

		SObject[] properties = new SObject[1];
		properties[0] = property;
		try {
			results = EstablishConnection.connection.create(properties);
		} catch (ConnectionException e) {
			e.printStackTrace();
		}
		System.out.println("Result:::" + results);
		status = establishConnection.saveResults(results);
		if (status == true) {
			report.updateTestLog("Verify Create Property", "Property has been created successfully", Status.PASS);
		} else {
			report.updateTestLog("Verify Create Property", "Property creation failed", Status.FAIL);
		}
	}

	/**
	 * Function for updating the Lead
	 * 
	 * @author Vishnuvardhan
	 *
	 */

	public void updatePropertySpecificUser() {
		establishConnection.establishConnection();
		String query_PropertyTypeHotel = "SELECT Property_Type__c FROM Property__c where Property_Type__c = 'Hotel'";
		String query_PropertySubType = "SELECT Sub_Type__c FROM Property__c where Sub_Type__c = 'IT/ITES'";
		String propertyTypeHotel = searchTextSOQL.fetchRecordFieldValue("Property_Type__c", query_PropertyTypeHotel);
		String propertyTypeSubType = searchTextSOQL.fetchRecordFieldValue("Sub_Type__c", query_PropertySubType);
		SObject[] records = new SObject[1];
		QueryResult queryResults = null;
		try {
			queryResults = EstablishConnection.connection.query("SELECT Id, Name, Property_Type__c, Sub_Type__c "
					+ "FROM Property__c where Property_Type__c = null and Sub_Type__c= null ORDER BY CreatedDate DESC LIMIT 1");
		} catch (ConnectionException e) {
			e.printStackTrace();
		}
		if (queryResults.getSize() > 0) {
			for (int i = 0; i < queryResults.getRecords().length; i++) {
				SObject so = (SObject) queryResults.getRecords()[i];
				SObject soUpdate = new SObject();
				soUpdate.setType("Property__c");
				soUpdate.setId(so.getId());
				soUpdate.setField("Property_Type__c", propertyTypeHotel);
				soUpdate.setField("Sub_Type__c", propertyTypeSubType);
				records[i] = soUpdate;
			}
		} else {
			report.updateTestLog("Verify Update Property",
					"There are no properties without Property Type and Property Sub Type", Status.WARNING);
		}
		try {
			results = EstablishConnection.connection.update(records);
		} catch (ConnectionException e) {
			e.printStackTrace();
		}
		System.out.println("Result:::" + results);
		status = establishConnection.saveResults(results);
		if (status == true) {
			report.updateTestLog("Verify Create Property", "Property has been updated successfully", Status.PASS);
		} else {
			report.updateTestLog("Verify Create Property", "Property updation failed", Status.FAIL);
		}
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

	/*
	 * static ArrayList<String> CMAPACHeader = new ArrayList<String>();
	 * 
	 * public void CMAPACHeadings() { CMAPACHeader.add("Lead Information");
	 * CMAPACHeader.add("Address Information");
	 * CMAPACHeader.add("Additional Information");
	 * CMAPACHeader.add("Communication Preferences");
	 * CMAPACHeader.add("System Information");
	 * System.out.println("CMAPAC Headers List are::" + CMAPACHeader); }
	 * 
	 * 
	 * public void createLeadSpecificUser() {
	 * establishConnection.establishConnectionSpecificUser(); SObject lead = new
	 * SObject();
	 * 
	 * lead.setType("Lead"); lead.setField("FirstName",
	 * Utility_Functions.xGenerateAlphaNumericString() +
	 * dataTable.getData("General_Data", "First Name"));
	 * lead.setField("LastName", Utility_Functions.xGenerateAlphaNumericString()
	 * + dataTable.getData("General_Data", "Last Name")); SearchTextSOQL
	 * companyName = new SearchTextSOQL(scriptHelper); String company_Name =
	 * companyName.fetchRecord("Lead", "Name"); lead.setField("Company",
	 * company_Name);
	 * 
	 * SObject[] leads = new SObject[1]; leads[0] = lead; try { results =
	 * EstablishConnection.connection.create(leads); } catch
	 * (ConnectionException e) { e.printStackTrace(); }
	 * System.out.println("Result:::" + results); status =
	 * establishConnection.saveResults(results); if(status==true) {
	 * report.updateTestLog("Verify Create Lead",
	 * "Lead has been created successfully", Status.PASS); } else {
	 * report.updateTestLog("Verify Create Lead", "Lead creation failed",
	 * Status.FAIL); } }
	 */

	/*
	 * public void leadPageFieldsValidation() {
	 * establishConnection.establishConnectionSpecificUser(); CMAPACHeadings();
	 * DescribeLayoutResult dlr = null; try { dlr =
	 * EstablishConnection.connection.describeLayout("Lead", null, null); }
	 * catch (ConnectionException e) { e.printStackTrace(); } int count=0; for
	 * (int i = 0; i < dlr.getLayouts().length; i++) { DescribeLayout layout =
	 * dlr.getLayouts()[i]; DescribeLayoutSection[] editLayoutSectionList =
	 * layout.getEditLayoutSections(); // Write the headings of the edit layout
	 * sections for (int x = 0; x < editLayoutSectionList.length; x++) {
	 * if(dataTable.getData("General_Data", "TC_ID").contains("CMAPAC")) {
	 * if(editLayoutSectionList.length==5) {
	 * if(editLayoutSectionList[x].getHeading().equals(CMAPACHeader.get(x))) {
	 * System.out.println(x +
	 * ":::Occupier Brokerage/Capital Markets APAC has the heading layout section:::"
	 * + editLayoutSectionList[x].getHeading()); report.updateTestLog(x +
	 * ":::Occupier Brokerage/Capital Markets APAC",
	 * " has the heading layout section:::" +
	 * editLayoutSectionList[x].getHeading(), Status.PASS); count++; } } } }
	 * System.out.println(count); } if(dataTable.getData("General_Data",
	 * "TC_ID").contains("CMAPAC")) { if(count==5) { CMAPACHeader.clear();
	 * System.out.
	 * println("Capital Markets APAC have all the header sections present::");
	 * report.updateTestLog("Validating Header Sections",
	 * "Capital Markets APAC - All the headers are present", Status.PASS); } } }
	 */

	/**
	 * Function for the validating the field on the Leads Page
	 * 
	 * @author Vishnuvardhan
	 *
	 */

	/*
	 * public void leadPageFieldsValidation() { try{
	 * establishConnection.establishConnectionSpecificUser();
	 * DescribeLayoutResult dlr =
	 * EstablishConnection.connection.describeLayout("Lead", null, null);
	 * for(int i = 0; i < dlr.getLayouts().length; i++) { DescribeLayout layout
	 * = dlr.getLayouts()[i]; DescribeLayoutSection[] detailLayoutSectionList =
	 * layout.getDetailLayoutSections(); System.out.println(" There are " +
	 * detailLayoutSectionList.length + " detail layout sections");
	 * report.updateTestLog("Verify Accounts Page Field Validation",
	 * "There are " + detailLayoutSectionList.length +
	 * " detail layout sections", Status.PASS); DescribeLayoutSection[]
	 * editLayoutSectionList = layout.getEditLayoutSections();
	 * System.out.println(" There are " + editLayoutSectionList.length +
	 * " edit layout sections");
	 * report.updateTestLog("Verify Accounts Page Field Validation",
	 * " There are " + editLayoutSectionList.length + " edit layout sections",
	 * Status.PASS); for(int j = 0; j < detailLayoutSectionList.length; j++) {
	 * System.out.println(j + " This detail layout section has a heading of "
	 * +detailLayoutSectionList[j].getHeading());
	 * report.updateTestLog("Verify Accounts Page Field Validation", j +
	 * " This detail layout section has a heading of "
	 * +detailLayoutSectionList[j].getHeading(), Status.PASS); } // Write the
	 * headings of the edit layout sections for(int x = 0; x <
	 * editLayoutSectionList.length; x++) { System.out.println(x +
	 * " This edit layout section has a heading of " +
	 * editLayoutSectionList[x].getHeading());
	 * report.updateTestLog("Verify Accounts Page Field Validation", x +
	 * " This edit layout section has a heading of " +
	 * editLayoutSectionList[x].getHeading(), Status.PASS); } // For each edit
	 * layout section, get its details. for(int k = 0; k <
	 * editLayoutSectionList.length; k++) { DescribeLayoutSection els =
	 * editLayoutSectionList[k];
	 * System.out.println("Edit layout section heading: " + els.getHeading());
	 * report.updateTestLog("Verify Accounts Page Field Validation",
	 * "Edit layout section heading: " + els.getHeading(), Status.PASS);
	 * DescribeLayoutRow[] dlrList = els.getLayoutRows();
	 * System.out.println("This edit layout section has " + dlrList.length +
	 * " layout rows");
	 * report.updateTestLog("Verify Accounts Page Field Validation",
	 * "This edit layout section has " + dlrList.length + " layout rows",
	 * Status.PASS); for(int m = 0; m < dlrList.length; m++) { DescribeLayoutRow
	 * lr = dlrList[m]; System.out.println(" This row has " + lr.getNumItems() +
	 * " layout items");
	 * report.updateTestLog("Verify Accounts Page Field Validation",
	 * " This row has " + lr.getNumItems() + " layout items", Status.PASS);
	 * DescribeLayoutItem[] dliList = lr.getLayoutItems(); for(int n = 0; n <
	 * dliList.length; n++) { DescribeLayoutItem li = dliList[n]; if
	 * ((li.getLayoutComponents() != null) && (li.getLayoutComponents().length >
	 * 0)) { System.out.println("\tLayout item " + n +", layout component: "
	 * +li.getLayoutComponents()[0].getValue());
	 * report.updateTestLog("Verify Accounts Page Field Validation",
	 * "\tLayout item " + n +", layout component: "
	 * +li.getLayoutComponents()[0].getValue(), Status.PASS); } else {
	 * System.out.println("\tLayout item " + n +", no layout component");
	 * report.updateTestLog("Verify Accounts Page Field Validation",
	 * "\tLayout item " + n +", no layout component", Status.PASS); } } } } }
	 * }catch (Exception e){ System.out.println(e.getMessage()); } }
	 */

}