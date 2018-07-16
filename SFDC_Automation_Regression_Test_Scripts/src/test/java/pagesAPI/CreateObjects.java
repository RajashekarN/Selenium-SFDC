package pagesAPI;

import java.util.Calendar;

import com.cognizant.Craft.ReusableLibrary;
import com.cognizant.Craft.ScriptHelper;
import com.sforce.soap.partner.SaveResult;
import com.sforce.soap.partner.sobject.SObject;
import com.sforce.ws.ConnectionException;
import supportLibraries.Utility_Functions;

public class CreateObjects extends ReusableLibrary {
	/*
	 * Constructor to initialize the business component library
	 * 
	 * @param scriptHelper The {@link ScriptHelper} object passed from the
	 * {@link DriverScript}
	 */

	public CreateObjects(ScriptHelper scriptHelper) {
		super(scriptHelper);
	}

	static SaveResult[] results;
	static com.sforce.soap.partner.Error[] errors;
	static boolean status = false;

	EstablishConnection establishConnection = new EstablishConnection(scriptHelper);

	/**
	 * Function for the creation of an Object dynamically based on Record Type
	 * 
	 * @author Vishnuvardhan
	 *
	 */

	public SaveResult[] createObject(String Object, String RecordType, String Field1, String Field2, String Field3, String Field4, String Field5, String Field6, String Field7) {
		establishConnection.establishConnection();
		SearchTextSOQL searchTextSOQL = new SearchTextSOQL(scriptHelper);
		try {
			SObject sObject = new SObject();
			String sName = Utility_Functions.xRandomFunction() + "-" + dataTable.getData("General_Data", "Name");

			switch (Object) {
			case "Account":
				sObject.setType("Account");
				sObject.setField("RecordTypeId", RecordType);
				sObject.setField("Name", sName);
				sObject.setField("BillingCountry", dataTable.getData("General_Data", "Country"));
				sObject.setField("BillingStreet", dataTable.getData("General_Data", "Street"));
				sObject.setField("BillingCity", dataTable.getData("General_Data", "City"));
				sObject.setField("BillingPostalCode ", dataTable.getData("General_Data", "Zipcode"));
				break;
			case "Contact":
				sObject.setType("Contact");
				sObject.setField("LastName", sName);
				sObject.setField("Title", "Sir");
				sObject.setField("Email", Utility_Functions.xRandomFunction() + "_" + "@gmail.com");
				sObject.setField("Main_Phone__c", dataTable.getData("General_data", "Direct Line"));
				sObject.setField("Department__c", dataTable.getData("General_data", "Company"));
				sObject.setField("Influence_Level__c", "Medium");
				sObject.setField("Email_Options__c", "Email Opt In");
				sObject.setField("Mail_Options__c", "Mail Opt Out");
				if(dataTable.getData("General_Data", "TC_ID").contains("APAC")) {
					sObject.setField("APAC_Exclude_Reason__c", "Archieved");
				} 			
				sObject.setField("Salutation", "Mr.");
				SearchTextSOQL accountID = new SearchTextSOQL(scriptHelper);
				String accountId = accountID.fetchRecord("Account", "Id");
				sObject.setField("AccountId", accountId);
				sObject.setField("Salutation", "Mr.");
				break;
			case "Lead":
				sObject.setType("Lead");
				sObject.setField("FirstName", Utility_Functions.xGenerateAlphaNumericString() + "_" + "First Name");
				sObject.setField("LastName", Utility_Functions.xGenerateAlphaNumericString() + "_" + "Second Name");
				sObject.setField("Phone", dataTable.getData("General_Data", "Direct Line"));
				String company_Name = searchTextSOQL.fetchRecord("Lead", "Name");
				if(company_Name==null) {
					AccountsFunctions accountsFunctions = new AccountsFunctions(scriptHelper);
					String sAccountID = accountsFunctions.createAccountRequiredFields();
					String query = "Select Name from Account where Id = " + "'" + sAccountID + "'";
					String sCompany_Name = searchTextSOQL.fetchRecordFieldValue("Name", query);
					sObject.setField("Company", sCompany_Name);
				} else {
					sObject.setField("Company", company_Name);
				}
				break;
			case "Opportunity":
				sObject.setType("Opportunity");
				sObject.setField("Name", sName);
				AccountsFunctions accountsFunctions = new AccountsFunctions(scriptHelper);
				String sAccountId = accountsFunctions.createAccountRequiredFields();		
				sObject.setField("AccountId", sAccountId);
				sObject.setField("RecordTypeId", RecordType);
				sObject.setField("CloseDate",Calendar.getInstance());
				sObject.setField("Service__c", "Consulting");
				/*if(dataTable.getData("General_Data", "TC_ID").startsWith("AS")) {
					sObject.setField("AS_Lead_Source__c", "Business Relationship");
				} else {
					sObject.setField("LeadSource", "Business Relationship");	
				}	*/	
				sObject.setField("Amount", "20000");
				sObject.setField("StageName","02-Meeting");
				if(dataTable.getData("General_Data", "TC_ID").contains("OpportunitiesCbre360Field")) {
					int iSize = Integer.parseInt(Field1);
					sObject.setField("Total_Size__c", iSize);
					sObject.setField("Unit_of_Measure__c ", "Square Feet");
					sObject.setField("Region__c", "APAC");
					sObject.setField("Market__c", "Australia");
					sObject.setField("CBRE_360__c", "Yes");
				}
				break;
			case "Property":
				sObject.setType("Property__c");
				String propertyName = searchTextSOQL.fetchRecord("Property__c", "Name");
				String query_Country = "SELECT Id, Name FROM Country__c where Name = 'Japan'";
				String query_State = "SELECT Id, Name FROM State__c where Name = 'Tokyo' ";
				String query_PropertyType = "SELECT Property_Type__c FROM Property__c where Property_Type__c = 'Hotel'";
				String countryId = searchTextSOQL.fetchRecordFieldValue("Id", query_Country);
				String stateId = searchTextSOQL.fetchRecordFieldValue("Id", query_State);
				String propertyType = searchTextSOQL.fetchRecordFieldValue("Property_Type__c", query_PropertyType);
				if(propertyName==null) {
					sObject.setField("Building_Property_Name__c", Utility_Functions.xRandomFunction() + "_" + "Test Automation Project");
				} else {
					sObject.setField("Building_Property_Name__c", propertyName);	
				}		
				sObject.setField("Property_Type__c", propertyType);
				sObject.setField("RecordTypeId", RecordType);
				sObject.setField("Country__c", countryId);
				sObject.setField("Street__c", dataTable.getData("General_Data", "Street"));
				sObject.setField("City__c", dataTable.getData("General_Data", "City"));
				sObject.setField("State__c", stateId);
				sObject.setField("Zip_Postal_Code__c ", "100-001");
				break;
			}
			SObject[] sObjects = new SObject[1];
			sObjects[0] = sObject;
			results = EstablishConnection.connection.create(sObjects);
			System.out.println("Result:::" + results);
			status = establishConnection.saveResults(results);
		} catch (ConnectionException e) {
			e.printStackTrace();
		}
		return results;
	}			
}