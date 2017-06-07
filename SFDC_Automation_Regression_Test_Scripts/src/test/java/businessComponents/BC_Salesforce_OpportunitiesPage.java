package businessComponents;

import com.cognizant.Craft.ReusableLibrary;
import com.cognizant.Craft.ScriptHelper;

import pageObjects.OpportunitiesPage;

/**
 * Business Components Class for validating functionalities related to Opportunities Page
 * 
 * @author Vishnuvardhan
 *
 */

public class BC_Salesforce_OpportunitiesPage extends ReusableLibrary {
	/**
	 * Constructor to initialize the component library
	 * 
	 * @param scriptHelper
	 *            The {@link ScriptHelper} object passed from the
	 *            {@link DriverScript}
	 */
	public BC_Salesforce_OpportunitiesPage(ScriptHelper scriptHelper) {
		super(scriptHelper);
	}

	BC_Salesforce_Login sfBC_Login = new BC_Salesforce_Login(scriptHelper);
	OpportunitiesPage sfOpportunitiesPage = new OpportunitiesPage(scriptHelper);

	/**
	 * Validating the Login functionality 
	 * 
	 * @author Vishnuvardhan
	 *
	 */	

	public void bc_login() throws InterruptedException {
		sfBC_Login.bc_invokeApplication();
		sfBC_Login.bc_login();
	}


	/**
	 * Validating the New Opportunity Page Layout fields
	 * 
	 * @author Vishnuvardhan
	 *
	 */	

	public void bc_newOpportunityPageLayout() throws InterruptedException {
		sfOpportunitiesPage.newOpportunityPageLayout();
	}

	/**
	 * Validating the required fields based on Sales Stage selected between 03-RFP/Proposal to 15-Signed Lease on Opportunity from a broker profile
	 * 
	 * @author Vishnuvardhan
	 *
	 */	

	public void bc_requiredFields03_05Stages() throws InterruptedException {
		sfOpportunitiesPage.requiredFieldsbetweenw03_05Stages();
	}       

	/**
	 * Validating the required fields based on Sales Stage selected between 16 - 19 on Opportunity from a broker profile
	 * 
	 * @author Vishnuvardhan
	 *
	 */	

	public void bc_requiredFields16_19Stages() throws InterruptedException {
		sfOpportunitiesPage.requiredFieldsbetweenw16_19Stages();
	} 

	/**
	 * Validating the functionality for association of property to an Opportunity
	 * 
	 * @author Vishnuvardhan                                               
	 *
	 */	

	public void bc_associateProperty() throws InterruptedException {
		sfOpportunitiesPage.associateProperty();
	}

	/**
	 * Validating the add Opportunity sharing from the Broker profile 
	 * 
	 * @author Vishnuvardhan
	 *
	 */	

	public void bc_opportunitySharing() {
		sfOpportunitiesPage.opportunitySharing();
	}

	/*	*//**
	 * Validating the required fields at SalesStage in Opportunities 
	 * 
	 * @author Vishnuvardhan
	 *
	 *//*	
	public void bc_opportunityBrokerProfile() throws InterruptedException {
		sfOpportunitiesPage.requiredFields_SalesStage_Opportunities();
	}*/

	/**
	 * Validating the manage Opportunity split functionality
	 * 
	 * @author Ramya
	 *
	 */	

	public void bc_opportunitySplitFunctionality() throws InterruptedException {
		sfOpportunitiesPage.opportunitySplitFunctionality();
	}

	/**
	 * Validating the Opportunity Account Name modification
	 * 
	 * @author Vishnuvardhan
	 *
	 */	

	public void bc_modifyAutoGeneratedOpportunityName() {
		sfOpportunitiesPage.modifyAutoGeneratedOpportunityName();
	}

	/**
	 * Validating whether the Opportunity Name is auto generated or not when creating the New Opportunity
	 * 
	 * @author Vishnuvardhan
	 *
	 */	

	public void bc_notAutoGeneratedOpportunityName() {
		sfOpportunitiesPage.manualOpportunityCreation();
	}

	/**
	 * Validating whether the Opportunity Name is auto generated or not when creating the New Opportunity
	 * 
	 * @author Vishnuvardhan
	 *
	 */	

	public void bc_opportunityNameAutoGenerate() {
		sfOpportunitiesPage.opportunityNameAutoGenerate();
	}

	/**
	 * Validating whether the Opportunity Name is auto generated or not when creating the New Opportunity
	 * 
	 * @author Vishnuvardhan
	 *
	 */	

	public void bc_opportunityNameAutoGenerate_API() {
		sfOpportunitiesPage.opportunityNameAutoGenerate_API();
	}

	/**
	 * Verify editing of multiple Installments from Opportunity based on Even Percent
	 * 
	 * @author Vishnuvardhan
	 *
	 */	

	public void bc_opportunityMultipleInstallmentsEven() {
		sfOpportunitiesPage.multipleInstallmentsOpportunityEvenPercent();		
		//sfOpportunitiesPage.multipleInstallmentsOpportunityEvenPercent_API();
	}

	/**
	 * Verify editing of multiple Installments from Opportunity based on UnEven Percent
	 * 
	 * @author Vishnuvardhan
	 *
	 */	

	public void bc_opportunityMultipleInstallmentsUnEven() {
		sfOpportunitiesPage.multipleInstallmentsUnEvenPercent();		
		//sfOpportunitiesPage.multipleInstallmentsOpportunityEvenPercent_API();
	}

	/**
	 * Verify editing of multiple Installments from Opportunity based on Uneven Percent
	 * 
	 * @author Vishnuvardhan
	 *
	 */	

	public void bc_opportunityMultipleInstallments_API() {
		//sfOpportunitiesPage.multipleInstallmentsUnevenPercent_API();
	}

	/**
	 * Verify editing of multiple Installments from Opportunity based Pending and Paid Status
	 * 
	 * @author Vishnuvardhan
	 *
	 */	

	public void bc_opportunityInstallmentsPendingPaid() {
		sfOpportunitiesPage.multipleInstallmentsPendingPaid();
	}

	/**
	 * Verify editing of multiple Installments from Opportunity based Pending and Paid Status
	 * 
	 * @author Vishnuvardhan
	 *
	 */	

	public void bc_estimatedGrossFeeCommissionRollingUp() {
		sfOpportunitiesPage.multipleInstallmentsOpportunityEvenPercent();
	}

	/**
	 * Verify editing of multiple Installments from Opportunity based in-line Edit for Even Percent
	 * 
	 * @author Vishnuvardhan
	 *
	 */	

	public void bc_inLineEditEvenPercent() {
		sfOpportunitiesPage.multipleInstallmentsOpportunityEvenPercent();
	}

	/**
	 * Verify editing of multiple Installments from Opportunity based in-line Edit for UnEven Percent
	 * 
	 * @author Vishnuvardhan
	 *
	 */	

	public void bc_inLineEditUnEvenPercent() {
		sfOpportunitiesPage.multipleInstallmentsUnEvenPercent();
	}


	/**
	 * Verify the round off functionality for Opportunity Installments
	 * 
	 * @author Vishnuvardhan
	 *
	 */	

	public void bc_recalculateRoundOffRule() {
		sfOpportunitiesPage.recalculateRoundOffRule();
	}

	/**
	 * Verify editing of ability to delete the installment
	 * 
	 * @author Vishnuvardhan
	 *
	 */	

	public void bc_deleteInstallment() {
		sfOpportunitiesPage.deleteInstallment();
	}

	/**
	 * Verify whether the user able to edit the paid installment
	 * 
	 * @author Vishnuvardhan
	 *
	 */	

	public void bc_editingPaidInstallmentAmount() {
		sfOpportunitiesPage.editPaidInstallmentAmount();
	}

	/**
	 * Validating the custom event page from the opportunity
	 * 
	 * @author Ramya
	 *
	 */	


	public void bc_opportunityVerifyCustomEventPage() {
		sfOpportunitiesPage.opportunityVerifyCustomEventPage();
	}

	/**
	 * Validating the Opportunity record type from the opportunity for Occupancy Brokerage 
	 * 
	 * @author Ramya
	 *
	 */	


	public void bc_verifyOpportunityRecordTypeForOccupancyBrokerage() {
		sfOpportunitiesPage.verifyOpportunityRecordTypeForOccupancyBrokerage();
	}
	/**
	 * Validating the Opportunity record type from the opportunity for Agency Broker 
	 * 
	 * @author Ramya
	 *
	 */	


	public void bc_verifyOpportunityRecordTypeForAgencyBroker() {
		sfOpportunitiesPage.verifyOpportunityRecordTypeForAgencyBroker();
	}
	/**
	 * Validating the Opportunity record type from the opportunity for Capital Markets
	 * 
	 * @author Ramya
	 *
	 */	


	public void bc_verifyOpportunityRecordTypeForCapitalMarkets() {
		sfOpportunitiesPage.verifyOpportunityRecordTypeForCapitalMarkets();
	}
	/**
	 * Validating the Opportunity record type from the opportunity for Capital Markets
	 * 
	 * @author Ramya
	 *
	 */	


	public void bc_opportunitySplitRegression() {
		sfOpportunitiesPage.opportunitySplitRegression();
	}

	/**
	 * Verify the Occupier Record Type should default to 'Occupier' opportunity type field 
	 * 
	 * @author Vishnuvardhan
	 *
	 */	

	public void bc_OpportunityOccupierRecordType() {
		sfOpportunitiesPage.occupierRecordType();
	}

	/**
	 * Verify the Annual Revenue field is renamed to Management Annual Revenue for Broker Profile
	 * 
	 * @author Vishnuvardhan
	 *
	 */	

	public void bc_ManagementAnnualRevenue() {
		sfOpportunitiesPage.managementAnnualRevenue();
	}

	/**
	 *  Validating the Quick create Opportunity page from the Opportunity tab 
	 * 
	 * @author Ramya
	 *
	 */	

	public void bc_verifyQuickCreateOpportunityPage() {
		sfOpportunitiesPage.verifyQuickCreateOpportunityPage();
	}
	/**
	 *  Validating the Quick create Opportunity page from the Opportunity tab from Asset Services for Reason for Loss Pick List values
	 * 
	 * @author Ramya
	 *
	 */	

	public void bc_verifyQuickCreateOpportunityPageAssetServices() {
		sfOpportunitiesPage.verifyQuickCreateOpportunityPageAssetServices();
	}
	/**
	 *  Validating the Quick create Opportunity page from the Opportunity tab from Asset Services for Manager for Reason for Loss pick List values
	 * 
	 * @author Ramya
	 *
	 */	

	public void bc_verifyQuickCreateOpportunityPageAssetServicesManager() {
		sfOpportunitiesPage.verifyQuickCreateOpportunityPageAssetServicesManager();
	}
	/**
	 *  Validating the Quick create Opportunity page from the Opportunity tab from Asset Services for Awarded Pick List values
	 * 
	 * @author Ramya
	 *
	 */	

	public void bc_verifyQuickCreateOpportunityPageAwardedPickList() {
		sfOpportunitiesPage.verifyQuickCreateOpportunityPageAwardedPickList();
	}
	/**
	 *  Validating the Quick create Opportunity page from the Opportunity tab from Asset Services for State Street pick list value
	 * 
	 * @author Ramya
	 *
	 */	

	public void bc_verifyQuickCreateOpportunityPageStateStreetPickList() {
		sfOpportunitiesPage.verifyQuickCreateOpportunityPageStateStreetPickList();
	}
	/**
	 *  Validating the Quick create Opportunity page from the Opportunity tab from Asset Services for Term of Contract field
	 * 
	 * @author Ramya
	 *
	 */	

	public void bc_verifyNewOpportunityPageTermOfContract() {
		sfOpportunitiesPage.verifyNewOpportunityPageTermOfContract();
	}
	/**
	 *  Validating the Quick create Opportunity page from the Opportunity tab from Asset Services for Lead Source
	 * 
	 * @author Ramya
	 *
	 */	

	public void bc_verifyNewOpportunityPageLeadSource() {
		sfOpportunitiesPage.verifyNewOpportunityPageLeadSource();
	}
	/**
	 *  Validating the Quick create Opportunity page from the Opportunity tab from Asset Services for Annual Revenue Fields
	 * 
	 * @author Ramya
	 *
	 */	

	public void bc_verifyOpportunityLeasingAnnualRevenueField() {
		sfOpportunitiesPage.verifyOpportunityLeasingAnnualRevenueField();
	}
	/**
	 *  Validating the Quick create Opportunity page from the Opportunity tab from Asset Services for EBIDTA Fields
	 * 
	 * @author Ramya
	 *
	 */	

	public void bc_verifyNewOpportunityEBIDTAFields() {
		sfOpportunitiesPage.verifyNewOpportunityEBIDTAFields();
	}
	/**
	 * Validating the  Capital Markets Revenue Field in New Opportunity Page
	 * 
	 * @author Ramya
	 *
	 */	


	public void bc_verifyCapitalMarketsRevenueField() {
		sfOpportunitiesPage.verifyCapitalMarketsRevenueField();
	}
	/**
	 * Validating the  Speciality Group Field in New Opportunity Page
	 * 
	 * @author Ramya
	 *
	 */	


	public void bc_verifySpecialityGroupAttribute() {
		sfOpportunitiesPage.verifySpecialityGroupAttribute();
	}
	/**
	 * Validating the RFP and Pitch Due Date Fields in New Opportunity Page
	 * 
	 * @author Ramya
	 *
	 */	


	public void bc_verifyRFPAndPitchDueDateNewopportunityPage() {
		sfOpportunitiesPage.verifyRFPAndPitchDueDateNewopportunityPage();
	}

	/**
	 * Validating the Average Annual Leasing Commission in New Opportunity Page
	 * 
	 * @author Ramya
	 *
	 */	


	public void bc_verifyOpportunityAverageAnnualLeasingCommissionField() {
		sfOpportunitiesPage.verifyOpportunityAverageAnnualLeasingCommissionField();
	}
	/**
	 * Validating the Average Annual Leasing Commission in New Opportunity Page for the AMER Broker/Manager
	 * 
	 * @author Ramya
	 *
	 */	


	public void bc_verifyOpportunityAverageAnnualLeasingCommissionFieldForAMERManager() {
		sfOpportunitiesPage.verifyOpportunityAverageAnnualLeasingCommissionFieldForAMERManager();
	}
	/**
	 * Validating the Prefered Property Type Mandatory Field in New Opportunity Page 
	 * 
	 * @author Ramya
	 *
	 */	


	public void bc_verifyPreferedPropertyTypeMandatoryField() {
		sfOpportunitiesPage.verifyPreferedPropertyTypeMandatoryField();
	}
	/**
	 * Validating the Management Annual Revenue Field in New Opportunity Page 
	 * 
	 * @author Ramya
	 *
	 */	


	public void bc_verifyManagementAnnualRevenueField() {
		sfOpportunitiesPage.verifyManagementAnnualRevenueField();
	}
	/**
	 *  Validating the Quick create Opportunity page from the Opportunity tab from Asset Services for Term of Contract field for the APAC Manager
	 * 
	 * @author Ramya
	 *
	 */	

	public void bc_verifyNewOpportunityPageTermOfContractForAPACManager() {
		sfOpportunitiesPage.verifyNewOpportunityPageTermOfContractForAPACManager();
	}
	
	/**
	 * Validating the Active Opportunities related to Account
	 * 
	 * @author Vishnuvardhan
	 *
	 */	
	public void bc_activeOpportunities() {
		sfOpportunitiesPage.validateActiveOpportunities();
	}
	
	/**
	 * Validating the Occupier Record Type should default to 'Occupier Brokerage'
	 * 
	 * @author Vishnuvardhan
	 *
	 */	
	
	public void bc_occupierRecordType() {
		sfOpportunitiesPage.defaultOppRecordType();
	}
}