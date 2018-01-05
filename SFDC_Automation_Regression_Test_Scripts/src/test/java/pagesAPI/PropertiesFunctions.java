package pagesAPI;

import java.util.ArrayList;

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
import com.sforce.soap.partner.sobject.SObject;
import com.sforce.ws.ConnectionException;

import supportLibraries.Utility_Functions;

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

	public String createPropertySpecificUser() {
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
		if(propertyName==null) {
			property.setField("Building_Property_Name__c", Utility_Functions.xRandomFunction() + "_" + "Test Automation Project");
		} else {
			property.setField("Building_Property_Name__c", propertyName);	
		}		
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
		String result = establishConnection.saveResultsId(results);
		status = establishConnection.saveResults(results);
		if (status == true) {
			report.updateTestLog("Verify Create Property", "Property has been created successfully", Status.PASS);
		} else {
			report.updateTestLog("Verify Create Property", "Property creation failed", Status.FAIL);
		}
		return result; 
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
	 * Function for creation the Property Preferences
	 * 
	 * @author Vishnuvardhan
	 *
	 */
	
	public void createPropertyPreference() {
		establishConnection.establishConnection();
		SObject propertyPreference = new SObject();

		propertyPreference.setType("Property_Preferences__c");
		String sContactName = searchTextSOQL.fetchRecord("Contact", "Id");
		propertyPreference.setField("Contact__c", sContactName);
		propertyPreference.setField("APAC_Status__c", "Opt In");
		propertyPreference.setField("APAC_Preference_Type__c", "Sale");
		//propertyPreference.setField("APAC_Country__c", "a0Gi00000035bnhEAA");		
		propertyPreference.setField("APAC_Region__c", "a0Ni000002WNYtYEAX");

		SObject[] propertyPreferences = new SObject[1];
		propertyPreferences[0] = propertyPreference;
		try {
			results = EstablishConnection.connection.create(propertyPreferences);
		} catch (ConnectionException e) {
			e.printStackTrace();
		}
		System.out.println("Result:::" + results);		
		String sPropertyPreferenceId = establishConnection.saveResultsId(results);
		if(sPropertyPreferenceId.startsWith("a2I")) {
			report.updateTestLog("Verify Create Property Preference", "Preference Property has been created successfully", Status.PASS);
		} else {
			report.updateTestLog("Verify Create Property Preference", "PreferenceProperty creation failed", Status.FAIL);
		}
	}
	

	/**
	 * Function for validating the Property Preferences
	 * 
	 * @author Vishnuvardhan
	 *
	 */
	

	static ArrayList<String> AdminHeader = new ArrayList<String>();

	public void AdminHeadings() {
		AdminHeader.add("Information");
		AdminHeader.add("Preferences");
		AdminHeader.add("Sale Requirement Criteria");
		AdminHeader.add("Lease Requirement Criteria");
		AdminHeader.add("Additional Information");
		System.out.println("Admin Headers List are::" + AdminHeader);
	}
	
	static ArrayList<String> AdminFields = new ArrayList<String>();

	public void AdminFields() {
		AdminFields.add("Contact__c");
		AdminFields.add("APAC_Status__c");
		AdminFields.add("Name1__c");
		AdminFields.add("APAC_Opt_Out_Date__c");
		AdminFields.add("Name");
		AdminFields.add("APAC_Opt_Out_Reason__c");
		AdminFields.add("OwnerId");
		AdminFields.add("APAC_Preference_Type__c");
		AdminFields.add("APAC_Country__c");
		AdminFields.add("Preference_Type__c");
		AdminFields.add("APAC_Region__c");
		AdminFields.add("APAC_Retail_Usage__c");
		AdminFields.add("Market_Preference__c");
		AdminFields.add("APAC_Building_Grade__c");
		AdminFields.add("APAC_Minimum_Price__c");
		AdminFields.add("APAC_Hotel_Market_Scale__c");
		AdminFields.add("APAC_Maximum_Price__c");
		AdminFields.add("APAC_Hotel_Star_Rating__c");
		AdminFields.add("APAC_Minimum_Total_Area__c");
		AdminFields.add("APAC_Hotel_Transaction_Type__c");
		AdminFields.add("APAC_Maximum_Total_Area__c");
		AdminFields.add("APAC_Gaming_Machines__c");
		AdminFields.add("APAC_Area_UOM__c");
		AdminFields.add("APAC_Additional_Comments__c");
		AdminFields.add("APAC_Minimum_Units__c");
		AdminFields.add("APAC_Maximum_Units__c");
		AdminFields.add("APAC_Unit_Type__c");
		AdminFields.add("APAC_Investment_Strategy__c");
		AdminFields.add("APAC_Yield_Minimum__c");
		AdminFields.add("APAC_Ownership_Structure__c");
		AdminFields.add("APAC_Deal_Type__c");
		AdminFields.add("APAC_Reason_for_Requirement__c");
		AdminFields.add("APAC_Lease_Term_Required__c");
		AdminFields.add("APAC_Fitout_Required__c");
		AdminFields.add("APAC_Car_Parking_Requirement__c");
		AdminFields.add("APAC_NABERS_Rating_Preference__c");
		AdminFields.add("Sharing_Property_Type__c");
		AdminFields.add("Sharing_Country__c");
		AdminFields.add("Sharing_Region__c");

		System.out.println("Capital Markets APAC Fields List are::" + AdminFields);
	}
	
	
	static ArrayList<String> AdminFieldLabelsAPI = new ArrayList<String>();

	public void propertyPreferenceValidation() {
		establishConnection.establishConnection();
		AdminHeadings();
		AdminFields();
		DescribeLayoutResult dlr = null;
		try {
			dlr = EstablishConnection.connection.describeLayout("Property_Preferences__c", null, null);
		} catch (ConnectionException e1) {
			e1.printStackTrace();
		}
		int count=0, countLabelList = 0;
		for (int i = 0; i < dlr.getLayouts().length; i++) {
			DescribeLayout layout = dlr.getLayouts()[i];
			DescribeLayoutSection[] editLayoutSectionList = layout.getEditLayoutSections();
			// Write the headings of the edit layout sections
			for (int x = 0; x < editLayoutSectionList.length; x++) {
				if(dataTable.getData("General_Data", "TC_ID").contains("CMAPAC")) {
					if(editLayoutSectionList.length==5) {
						if(editLayoutSectionList[x].getHeading().equals(AdminHeader.get(x))) {
							System.out.println(x + ":::Capital Markets APAC has the heading layout section:::" + editLayoutSectionList[x].getHeading());
							report.updateTestLog(x + ":::Capital Markets APAC", " has the heading layout section:::" + editLayoutSectionList[x].getHeading(), Status.PASS);
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
											AdminFieldLabelsAPI.add(value);
										}
									} catch (Exception e) {
										e.printStackTrace();
									}
								}
							}
						}
					}	
					System.out.println("CM APAC Admin Field Label::: " + AdminFieldLabelsAPI);
					for(int i1=0; i1 < AdminFields.size(); i1++) {
						if(AdminFieldLabelsAPI.get(i1).equals(AdminFields.get(i1))) {						
							System.out.println("Field Label:::" + AdminFieldLabelsAPI.get(i1) + " -- is present in OB EMEA:::");
							report.updateTestLog("Verify Field Labels", " has the field label:::" + AdminFieldLabelsAPI.get(i1), Status.PASS);
							countLabelList++;
						}			 
					}
					System.out.println("Count of fields present in Capital Markets APAC::" + countLabelList);						
				}
			}	
		}	
		if(dataTable.getData("General_Data", "TC_ID").contains("CMAPAC")) {
			if(count==5) {
				System.out.println("Captial Markets APAC have all the header sections present::");
				report.updateTestLog("Validating Header Sections", "Captial Markets APAC - All the headers are present", Status.PASS);
				AdminHeader.clear();
			}						
		if (countLabelList == 39) {
			AdminFields.clear();
			report.updateTestLog("Count of fields present in Occupier Brokerage/ Agency Brokerage EMEA", "All the fields are present in Occupier Brokerage/ Agency Brokerage EMEA", Status.PASS);
		} else
			report.updateTestLog("Count of fields present in Capital Markets APAC", "All the fields are presentin Capital Markets", Status.FAIL);
		} 	
		createPropertyPreference();
	}
	
}