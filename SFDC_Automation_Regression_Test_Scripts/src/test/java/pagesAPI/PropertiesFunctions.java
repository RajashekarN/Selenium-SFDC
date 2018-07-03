package pagesAPI;

import java.util.ArrayList;
import java.util.List;
import com.cognizant.Craft.ReusableLibrary;
import com.cognizant.Craft.ScriptHelper;
import com.cognizant.framework.Status;
import com.sforce.soap.partner.DeleteResult;
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
	 * Function for the creation of Property
	 * 
	 * @author Vishnuvardhan
	 *
	 */

	
	public String createProperty(String Street, String City, String State, String Country, String Zipcode) {
		establishConnection.establishConnection();
		SObject property = new SObject();
		String query_Country = "SELECT Id, Name FROM Country__c where Name = " + "'" + dataTable.getData("General_Data", "Country") + "'";
		String countryId = searchTextSOQL.fetchRecordFieldValue("Id", query_Country);	
		property.setType("Property__c");
		property.setField("Building_Property_Name__c", Utility_Functions.xRandomFunction() + "_" + "Test Automation Project");
		property.setField("Street__c", Street);
		property.setField("City__c", City);
		property.setField("Country__c", countryId);
		property.setField("Zip_Postal_Code__c ", Zipcode);
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
	 * Function for updating the Property
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
	 * Function for validating the Property Preferences header section
	 * 
	 * @author Vishnuvardhan
	 *
	 */
	

	static ArrayList<String> propertyPreferecenceHeaderList = new ArrayList<String>();

	public void propertyPreferenceHeaderList() {
		propertyPreferecenceHeaderList.add("Information");
		propertyPreferecenceHeaderList.add("Preferences");
		propertyPreferecenceHeaderList.add("Sale Requirement Criteria");
		propertyPreferecenceHeaderList.add("Lease Requirement Criteria");
		propertyPreferecenceHeaderList.add("Additional Information");
		System.out.println("Property Preference Header List ::" + propertyPreferecenceHeaderList);
	}
	
	/**
	 * Validating the Property Preferences fields
	 *
	 * @author Vishnuvardhan
	 *
	 */
	static ArrayList<String> propertyPreferencesFieldsList = new ArrayList<String>();

	public void propertyPreferencesFields() {
		propertyPreferencesFieldsList.add("Owner ID");
		propertyPreferencesFieldsList.add("Preferences Name");
		propertyPreferencesFieldsList.add("Additional Comments");
		propertyPreferencesFieldsList.add("Area UOM");
		propertyPreferencesFieldsList.add("Building Grade");
		propertyPreferencesFieldsList.add("Car Parking Requirement");
		propertyPreferencesFieldsList.add("APAC Country");
		propertyPreferencesFieldsList.add("Deal Type");
		propertyPreferencesFieldsList.add("Fitout Required");
		propertyPreferencesFieldsList.add("Gaming Machines");
		propertyPreferencesFieldsList.add("Hotel Market Scale");
		propertyPreferencesFieldsList.add("Hotel Star Rating");
		propertyPreferencesFieldsList.add("Hotel Transaction Type");
		propertyPreferencesFieldsList.add("Investment Strategy");
		propertyPreferencesFieldsList.add("Lease Term Required");
		propertyPreferencesFieldsList.add("Maximum Price");
		propertyPreferencesFieldsList.add("Maximum Total Area");
		propertyPreferencesFieldsList.add("Maximum Units");
		propertyPreferencesFieldsList.add("Minimum Price");
		propertyPreferencesFieldsList.add("Minimum Total Area");
		propertyPreferencesFieldsList.add("Minimum Units");
		propertyPreferencesFieldsList.add("NABERS Rating Preference");
		propertyPreferencesFieldsList.add("Opt Out Date");
		propertyPreferencesFieldsList.add("Opt Out Reason");
		propertyPreferencesFieldsList.add("Ownership Structure");
		propertyPreferencesFieldsList.add("Preference Type");
		propertyPreferencesFieldsList.add("Reason for Requirement");
		propertyPreferencesFieldsList.add("APAC Region");
		propertyPreferencesFieldsList.add("Retail Usage");
		propertyPreferencesFieldsList.add("Status");
		propertyPreferencesFieldsList.add("Unit Type");
		propertyPreferencesFieldsList.add("Yield Minimum");
		propertyPreferencesFieldsList.add("Contact");
		propertyPreferencesFieldsList.add("Market Preference");
		propertyPreferencesFieldsList.add("Sharing Country");
		propertyPreferencesFieldsList.add("Sharing Property Type");
		propertyPreferencesFieldsList.add("Sharing Region");
		propertyPreferencesFieldsList.add("Property Type");
		propertyPreferencesFieldsList.add("Name1");
		propertyPreferencesFieldsList.add("Preference Comms Type");
		System.out.println("Property Preferences fields are " + propertyPreferencesFieldsList);
	}
	
	/**
	 * Function for Validating the Property Preferences Headers and Fields
	 *
	 * @author Vishnuvardhan
	 *
	 */
	
	public void propertyPreferenceValidation() {
		propertyPreferenceHeaderList();
		List<String> propertyPreferencesHeader = establishConnection.establishMetaDataConnectionPageHeaders("Property_Preferences__c", 5);
		List<String> propertyPreferncesHeadersList = new ArrayList<String>();
		propertyPreferncesHeadersList = Utility_Functions.xValidatePickListValuesPage(propertyPreferencesHeader, propertyPreferecenceHeaderList, "Property Prefernces Header values");
		if (propertyPreferncesHeadersList.size()!=0) {
			report.updateTestLog("Verify Property Prefernces Page Header Fields ", "All the labels are not present in the Property Prefernces Page Header Fields:::" + propertyPreferncesHeadersList, Status.FAIL);
		} else {
			report.updateTestLog("Verify Property Prefernces Page Header Fields", "All the labels are present in the Property Prefernces Page Header Fields", Status.PASS);
		}		
		
		propertyPreferencesFields();
		List<String> propertyPreferences = establishConnection.establishMetaDataConnectionPageLayouts("Property_Preferences__c", "APAC Property Preferences Layout");
		List<String> propertyPreferncesList = new ArrayList<String>();
		propertyPreferncesList = Utility_Functions.xValidatePickListValuesPage(propertyPreferences, propertyPreferencesFieldsList, "Property Prefernces field values");
		if (propertyPreferncesList.size()!=0) {
			report.updateTestLog("Verify Property Prefernces Page Field Labels", "All the labels are not present in the Property Prefernces Page Field Labels:::" + propertyPreferncesList, Status.FAIL);
		} else {
			report.updateTestLog("Verify Property Prefernces Page Field Labels", "All the labels are present in the Property Prefernces Page Field Labels", Status.PASS);
		}	
		createPropertyPreference();
	}	
}