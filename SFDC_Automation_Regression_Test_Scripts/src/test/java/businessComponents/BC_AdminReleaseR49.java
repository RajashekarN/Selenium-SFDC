package businessComponents;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import com.cognizant.Craft.ReusableLibrary;
import com.cognizant.Craft.ScriptHelper;
import com.cognizant.framework.Status;
import com.sforce.soap.partner.SaveResult;
import pageObjects.OpportunitiesPage;
import pagesAPI.CreateObjects;
import pagesAPI.EstablishConnection;
import pagesAPI.PermissionSetsUsers;
import pagesAPI.SearchTextSOQL;
import supportLibraries.SF_UtilityFunctions;
import supportLibraries.Utility_Functions;

/**
 * Business Components Class for validating the API calls 
 * 
 * @author Vishnuvardhan
 *
 */

public class BC_AdminReleaseR49 extends ReusableLibrary {
	/**
	 * Constructor to initialize the component library
	 * 
	 * @param scriptHelper
	 *            The {@link ScriptHelper} object passed from the
	 *            {@link DriverScript}
	 */
	
	
	public BC_AdminReleaseR49(ScriptHelper scriptHelper) {
		super(scriptHelper);
	}
	

	/**
	 * Validating the picklist value in CBRE Office field
	 * 
	 * @author Haritha
	 *
	 */
	
	
	public void bc_cbreOfficeField() {
		new SF_UtilityFunctions(scriptHelper).verifyPickListValues("NL - Zwolle", "Opportunity", "EMEA_A_T_Investor", "CBRE_Office__c");
		new SF_UtilityFunctions(scriptHelper).verifyPickListValues("NL - Zwolle", "Opportunity", "EMEA_A_T_Occupier", "CBRE_Office__c");
		new SF_UtilityFunctions(scriptHelper).verifyPickListValues("NL - Zwolle", "Opportunity", "EMEA_Capital_Markets_Investment_Properties", "CBRE_Office__c");
		new SF_UtilityFunctions(scriptHelper).verifyPickListValues("NL - Zwolle", "Opportunity", "EMEA_Capital_Markets_Capital_Advisors", "CBRE_Office__c");
		new SF_UtilityFunctions(scriptHelper).verifyPickListValues("NL - Zwolle", "Opportunity", "EMEA_Valuations", "CBRE_Office__c");
	}
	
	/**
	 * Validating the picklist value in CBRE Office field
	 * 
	 * @author Haritha
	 *
	 */
	
	public void bc_CBRE360CloseDate() {
		String sFieldName = "CBRE 360 Close Date"; String sUsername = "testuser6@cbre.com.crm";
		new PermissionSetsUsers(scriptHelper).updateRoleProfile(sUsername, "Asset Services AMER", null, "Role-Only");
		List<String> pageFields = new EstablishConnection(scriptHelper).establishMetaDataConnectionPageLayouts("Opportunity_Reporting__c", "Asset Services - CBRE 360");
		int count=0;
		for(int i=0; i < pageFields.size(); i++) {
			if(pageFields.get(i).equals(sFieldName)) {
				count++;
				break;
			}
				
		}
		if (count==1) {
			report.updateTestLog("Verify Field", "Field ::  " + sFieldName + " is present in the page layout::: ", Status.PASS);
		} else {
			report.updateTestLog("Verify Field", "Field ::  " + sFieldName + " is not present in the page layout:::", Status.FAIL);
		}	
		new PermissionSetsUsers(scriptHelper).changeRoleProfileOriginalValues(sUsername, "Role-Only");
	}
	

	/**
	 * Validating the Contacts PAC CM Metro special categories field picklist values
	 *
	 * @author Haritha
	 *
	 */
	public void bc_pacCmMetroSpecialCategories() {
		pacCmMetroSpecialCategories();
	}
	
		static ArrayList<String> pacCmMetroSpecialCategories = new ArrayList<String>();

		public void pacCmMetroSpecialCategories() { 
			pacCmMetroSpecialCategories.add("Investor ($5m+)");
			pacCmMetroSpecialCategories.add("Investor Medium (Under $5m)");
			pacCmMetroSpecialCategories.add("North Shore Investor");
			pacCmMetroSpecialCategories.add("West Auckland Investor");
			pacCmMetroSpecialCategories.add("Industrial Investor – Medium (Under $5m)");
			pacCmMetroSpecialCategories.add("Childcare Investor");
			pacCmMetroSpecialCategories.add("Childcare Operator");
			pacCmMetroSpecialCategories.add("North Shore Office Tenant");
			pacCmMetroSpecialCategories.add("North Shore Office Investor");
			pacCmMetroSpecialCategories.add("West Auckland Office Tenant");
			pacCmMetroSpecialCategories.add("West Auckland Office Investor");
			pacCmMetroSpecialCategories.add("Lifestyle");
			System.out.println("PAC CM Metro special categories Pick List values are " + pacCmMetroSpecialCategories);
		}

		
		public void validatePacCmMetroSpecialCategories() {
			pacCmMetroSpecialCategories();
			List<String> newContactPacCmPicklistValues = new SF_UtilityFunctions(scriptHelper).getPickListValues("Opportunity", "France_Consulting_Service", "Referral_Recipient_Business_Line__c");
			List<String> pacCmMetroSpecialCategoriesList = new ArrayList<String>();
			pacCmMetroSpecialCategoriesList = Utility_Functions.xValidatePickListValuesPage(pacCmMetroSpecialCategories, newContactPacCmPicklistValues, "New Contact PAC CM field pick list values");
			if (pacCmMetroSpecialCategoriesList.size()!=0) {
				report.updateTestLog("Verify Referral Recipient Business Line picklist values", "All the values are not present in the Referral Recipient Business Line :::" + pacCmMetroSpecialCategoriesList, Status.FAIL);
			} else {
				report.updateTestLog("Verify Referral Recipient Business Line picklist values", "All the values are present in the Referral Recipient Business Line Pick List ", Status.PASS);
			}	
		}
		
		
		/**
		 * Test Script for validating the mandatory Net Fee field when Sales stage is closed won on Opp page
		 * 
		 * @author Haritha
		 */
		public void bc_validateOpportunitiesNetFee() {
			OpportunitiesPage opportunitiesPage = new OpportunitiesPage(scriptHelper);
			opportunitiesPage.selectNewOpportunity();
			String sAccountName = new SearchTextSOQL(scriptHelper).fetchRecord("Account", "Name");
			opportunitiesPage.opportunityCreationPopUp(sAccountName);
		}
		
		/**
		 * Test Script for validating the UOM pick list value for APAC DataAdmin profile
		 * 
		 * @author Haritha
		 *
		 */
		
		public void bc_uomPicklistValues() {
			new SF_UtilityFunctions(scriptHelper).verifyPickListValues("Square Wah", "Property__c", "APAC_Property", "Units_of_Measure__c");
			new SF_UtilityFunctions(scriptHelper).verifyPickListValues("Square Wah", "Property_Preferences__c", "APAC_Property_Preferences", "APAC_Area_UOM__c");
			new SF_UtilityFunctions(scriptHelper).verifyPickListValues("Square Wah", "Opportunity", "APAC_Landlord_Deal", "Unit_of_Measure__c");
		}
		
		/**
		 * Validating the Property Preferences related list on Contact page
		 * 
		 * @author Haritha
		 */
		
		public void bc_propertyPreferencesRelatedList() {
			SaveResult[] results = new CreateObjects(scriptHelper).createObject("Contact", "CBRE Client Contact", null, null, null, null, null, null, null);
			String sContactID = new EstablishConnection(scriptHelper).saveResultsId(results);
			SaveResult[] propertyPreferencesResults = new CreateObjects(scriptHelper).createObject("Property_Preference", "EMEA Property Preferences", sContactID, null, null, null, null, null, null);
			new EstablishConnection(scriptHelper).saveResultsId(propertyPreferencesResults);
		}
		
		/**
		 * Test Script for validating the Lead source field on Opportunity object
		 * 
		 * @author Haritha
		 *
		 */
		
		public void bc_updateApacGwsOppFields() {
			String sLeadSource = "CBRE Cross Sell";
			SaveResult[] results = new CreateObjects(scriptHelper).createObject("Opportunity", "APAC Advisory/Consulting Services and GWS", sLeadSource, null, null, null, null, null, null);
			String sOpportunityID = new EstablishConnection(scriptHelper).saveResultsId(results);
			String sQuery = "Select LeadSource from Opportunity where Id = " + "'" + sOpportunityID + "'";
			String sRetrievedLeadSource = new SearchTextSOQL(scriptHelper).fetchRecordFieldValue("LeadSource", sQuery);
			if(sRetrievedLeadSource.equals(sLeadSource)) {
				report.updateTestLog("Validating Lead Source field", "Lead Source field has the following value:::", Status.PASS);				
			} else {
				report.updateTestLog("Validating Lead Source field", "Lead Source field doesn't have the following value:::", Status.FAIL);
				
			}
		}		
		/**
		 * Test Script for validating the mandatory Property Type and Total size on Property page
		 * 
		 * @author Haritha
		 *
		 */
		public void bc_verifyPropertyTypeTotalSizeFields() {
			SaveResult[] results = new CreateObjects(scriptHelper).createObject("Property", "APAC Property", "3500", null, null, null, null, null, null);
			String sPropertyID = new EstablishConnection(scriptHelper).saveResultsId(results);
			String sQuery = "Select Total_Property_SF__c from Property__c where Id = " + "'" + sPropertyID + "'";
			String sPropertyType = "Select Property_Type__c from Property__c where Id = " + "'" + sPropertyID + "'";
			String sTotalSize = new SearchTextSOQL(scriptHelper).fetchRecordFieldValue("Total_Property_SF__c", sQuery);
			System.out.println(sTotalSize);
			String sPropertyTypeValue = new SearchTextSOQL(scriptHelper).fetchRecordFieldValue("Property_Type__c", sPropertyType);
			if((sTotalSize.equals("3500.0")) && (sPropertyTypeValue.equals("Hotel"))) {
				report.updateTestLog("Validating Total Size/Property Type field", "Total Size/Property Type values has the following value:::", Status.PASS);				
			} else {
				report.updateTestLog("Validating Total Size/Property Type field", "Total Size//Property Type values doesn't have the following value:::", Status.FAIL);				
			}		
		}
		
		/**
		 * Test Script for validating the Assignment Start date and End Date fields on Opportunity object
		 * 
		 * @author Haritha
		 *
		 */
		public void bc_verifyAssignmentFields() {			
			SaveResult[] results = new CreateObjects(scriptHelper).updateObject("Opportunity","APAC Advisory/Consulting Services and GWS", "Assignment_Start_Date__c", "Assignment_End_Date__c");	
			String sOpportunityId = new EstablishConnection(scriptHelper).saveResultsId(results);
			String sStartDate = "Select Assignment_Start_Date__c from Opportunity where Id = " + "'" + sOpportunityId + "'";
			String sEndDate = "Select Assignment_End_Date__c from Opportunity where Id = " + "'" + sOpportunityId + "'";
			String sStartDateAssignment = new SearchTextSOQL(scriptHelper).fetchRecordFieldValue("Assignment_Start_Date__c", sStartDate);
			String sEndDateAssignment = new SearchTextSOQL(scriptHelper).fetchRecordFieldValue("Assignment_End_Date__c", sEndDate);
			DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
	        Date date = new Date(); 
			System.out.println(dateFormat.format(date).toString());
			if((sStartDateAssignment.equals(dateFormat.format(date).toString())) && (sEndDateAssignment.equals(dateFormat.format(date).toString() ))) {
				report.updateTestLog("Validating Assignment Start/ End Date field", "Assignment Start/ End Date field values has the following value:::", Status.PASS);				
			} else {
				report.updateTestLog("Validating Assignment Start/ End Date field", "Assignment Start/ End Date field values doesn't have the following value:::", Status.FAIL);				
			}	
		}
		
		/**
		 * Test Script for validating the mandatory Assignment Type and Sub-type on Opportunity page
		 * 
		 * @author Haritha
		 *
		 */
		public void bc_verifyOppAssignmentTypeFields() {
			String sUsername = "testuser40@cbre.com.crm";
			new PermissionSetsUsers(scriptHelper).updateRoleProfile(sUsername, "IT A&T Office Milano", null, "Role-Only");
			SaveResult[] results = new CreateObjects(scriptHelper).createObject("Opportunity", "EMEA A&T Occupier", null, null, null, null, null, null, null);
			String sOpportunityId = new EstablishConnection(scriptHelper).saveResultsId(results);
			String sAssType = "Select Service__c from Opportunity where Id = " + "'" + sOpportunityId + "'";
			String sAssSubType = "Select Service_Sub_Type__c from Opportunity where Id = " + "'" + sOpportunityId + "'";
			String sAssignmentType = new SearchTextSOQL(scriptHelper).fetchRecordFieldValue("Service__c", sAssType);
			String sAssignmentSubType = new SearchTextSOQL(scriptHelper).fetchRecordFieldValue("Service_Sub_Type__c", sAssSubType);
			System.out.println(sAssignmentType);
			System.out.println(sAssignmentSubType);
			
			if((sAssignmentType.equals("Consulting")) && (sAssignmentSubType.equals("Commute"))) {
				report.updateTestLog("Validating Assignment type/Sub type field", "Assignment type/Sub type values has the following value:::", Status.PASS);				
			} else {
				report.updateTestLog("Validating Assignment type/Sub type field", "Assignment type/Sub type values doesn't have the following value:::", Status.FAIL);				
			}		
			new PermissionSetsUsers(scriptHelper).changeRoleProfileOriginalValues(sUsername, "Role-Only");
		}
	
}