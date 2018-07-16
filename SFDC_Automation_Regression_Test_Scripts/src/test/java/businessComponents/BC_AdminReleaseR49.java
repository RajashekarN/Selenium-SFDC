package businessComponents;

import java.util.ArrayList;
import java.util.List;
import com.cognizant.Craft.ReusableLibrary;
import com.cognizant.Craft.ScriptHelper;
import com.cognizant.framework.Status;

import pageObjects.OpportunitiesPage;
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
		new EstablishConnection(scriptHelper).establishConnectionAdminLogin();
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
		validatePacCmMetroSpecialCategories();
	}
	
		static ArrayList<String> pacCmMetroSpecialCategories = new ArrayList<String>();

		public void pacCmMetroSpecialCategories() { 
			pacCmMetroSpecialCategories.add("Investor %28%245m%2B%29");
			pacCmMetroSpecialCategories.add("Investor Medium %28Under %245m%29");
			pacCmMetroSpecialCategories.add("North Shore Investor");
			pacCmMetroSpecialCategories.add("West Auckland Investor");
			pacCmMetroSpecialCategories.add("Industrial Investor %E2%80%93 Medium %28Under %245m%29");
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
			List<String> newContactPacCmPicklistValues = new SF_UtilityFunctions(scriptHelper).getPickListValues("Contact", "CBRE_Client_Contact", "PAC_Capital_Markets_Metro_special_catego__c");
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
	
}