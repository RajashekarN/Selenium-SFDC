package businessComponents;

import com.cognizant.Craft.ReusableLibrary;
import com.cognizant.Craft.ScriptHelper;

import pageObjects.OpportunitiesPage;
import pagesAPI.OpportunitiesFunctions;

/**
 * Business Components Class for validating functionalities related to
 * Opportunities Page
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
	OpportunitiesFunctions opportunitiesFunctions = new OpportunitiesFunctions(scriptHelper);
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
	
	
	public void bc_selectOpportunity(){
		sfOpportunitiesPage.selectOpportunity();
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
	 * Validating the required fields based on Sales Stage selected between 16 -
	 * 19 on Opportunity from a broker profile
	 * 
	 * @author Vishnuvardhan
	 *
	 */

	public void bc_requiredFields16_19Stages() throws InterruptedException {
		sfOpportunitiesPage.requiredFieldsbetweenw16_19Stages();
	}

	/**
	 * Validating the functionality for association of property to an
	 * Opportunity
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
			 * public void bc_opportunityBrokerProfile() throws
			 * InterruptedException {
			 * sfOpportunitiesPage.requiredFields_SalesStage_Opportunities(); }
			 */

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
	 * Validating whether the Opportunity Name is auto generated or not when
	 * creating the New Opportunity
	 * 
	 * @author Vishnuvardhan
	 *
	 */

	public void bc_opportunityNameAutoGenerate() {
		sfOpportunitiesPage.opportunityNameAutoGenerate();
	}

	/**
	 * Verify editing of multiple Installments from Opportunity based on Even
	 * Percent
	 * 
	 * @author Vishnuvardhan
	 *
	 */

	public void bc_opportunityMultipleInstallmentsEven() {
		sfOpportunitiesPage.multipleInstallmentsOpportunityEvenPercent();
		// sfOpportunitiesPage.multipleInstallmentsOpportunityEvenPercent_API();
	}

	/**
	 * Verify editing of multiple Installments from Opportunity based on UnEven
	 * Percent
	 * 
	 * @author Vishnuvardhan
	 *
	 */

	public void bc_opportunityMultipleInstallmentsUnEven() {
		sfOpportunitiesPage.multipleInstallmentsUnEvenPercent();
		// sfOpportunitiesPage.multipleInstallmentsOpportunityEvenPercent_API();
	}

	/**
	 * Verify editing of multiple Installments from Opportunity based on Uneven
	 * Percent
	 * 
	 * @author Vishnuvardhan
	 *
	 */

	public void bc_opportunityMultipleInstallments_API() {
		// sfOpportunitiesPage.multipleInstallmentsUnevenPercent_API();
	}

	/**
	 * Verify editing of multiple Installments from Opportunity based Pending
	 * and Paid Status
	 * 
	 * @author Vishnuvardhan
	 *
	 */

	public void bc_opportunityInstallmentsPendingPaid() {
		sfOpportunitiesPage.multipleInstallmentsPendingPaid();
	}

	/**
	 * Verify editing of multiple Installments from Opportunity based Pending
	 * and Paid Status
	 * 
	 * @author Vishnuvardhan
	 *
	 */

	public void bc_estimatedGrossFeeCommissionRollingUp() {
		sfOpportunitiesPage.multipleInstallmentsOpportunityEvenPercent();
	}

	/**
	 * Verify editing of multiple Installments from Opportunity based in-line
	 * Edit for Even Percent
	 * 
	 * @author Vishnuvardhan
	 *
	 */

	public void bc_inLineEditEvenPercent() {
		sfOpportunitiesPage.multipleInstallmentsOpportunityEvenPercent();
	}

	/**
	 * Verify editing of multiple Installments from Opportunity based in-line
	 * Edit for UnEven Percent
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
	 * Validating the Opportunity record type from the opportunity for Occupancy
	 * Brokerage
	 * 
	 * @author Ramya
	 *
	 */

	public void bc_verifyOpportunityRecordTypeForOccupancyBrokerage() {
		sfOpportunitiesPage.verifyOpportunityRecordTypeForOccupancyBrokerage();
	}

	/**
	 * Validating the Opportunity record type from the opportunity for Agency
	 * Broker
	 * 
	 * @author Ramya
	 *
	 */

	public void bc_verifyOpportunityRecordTypeForAgencyBroker() {
		sfOpportunitiesPage.verifyOpportunityRecordTypeForAgencyBroker();
	}

	/**
	 * Validating the Opportunity record type from the opportunity for Capital
	 * Markets
	 * 
	 * @author Ramya
	 *
	 */

	public void bc_verifyOpportunityRecordTypeForCapitalMarkets() {
		sfOpportunitiesPage.verifyOpportunityRecordTypeForCapitalMarkets();
	}

	/**
	 * Validating the Opportunity record type from the opportunity for Capital
	 * Markets
	 * 
	 * @author Ramya
	 *
	 */

	public void bc_opportunitySplitRegression() {
		sfOpportunitiesPage.opportunitySplitRegression();
	}

	/**
	 * Verify the Occupier Record Type should default to 'Occupier' opportunity
	 * type field
	 * 
	 * @author Vishnuvardhan
	 *
	 */

	public void bc_OpportunityOccupierRecordType() {
		sfOpportunitiesPage.occupierRecordType();
	}

	/**
	 * Verify the Annual Revenue field is renamed to Management Annual Revenue
	 * for Broker Profile
	 * 
	 * @author Vishnuvardhan
	 *
	 */

	public void bc_ManagementAnnualRevenue() {
		sfOpportunitiesPage.managementAnnualRevenue();
	}

	/**
	 * Validating the Quick create Opportunity page from the Opportunity tab
	 * 
	 * @author Ramya
	 *
	 */

	public void bc_verifyQuickCreateOpportunityPage() {
		sfOpportunitiesPage.verifyQuickCreateOpportunityPage();
	}

	/**
	 * Validating the Quick create Opportunity page from the Opportunity tab
	 * from Asset Services for Reason for Loss Pick List values
	 * 
	 * @author Ramya
	 *
	 */

	public void bc_verifyQuickCreateOpportunityPageAssetServices() {
		sfOpportunitiesPage.verifyQuickCreateOpportunityPageAssetServices();
	}

	/**
	 * Validating the Quick create Opportunity page from the Opportunity tab
	 * from Asset Services for Manager for Reason for Loss pick List values
	 * 
	 * @author Ramya
	 *
	 */

	public void bc_verifyQuickCreateOpportunityPageAssetServicesManager() {
		sfOpportunitiesPage.verifyQuickCreateOpportunityPageAssetServicesManager();
	}

	/**
	 * Validating the Quick create Opportunity page from the Opportunity tab
	 * from Asset Services for Awarded Pick List values
	 * 
	 * @author Ramya
	 *
	 */

	public void bc_verifyQuickCreateOpportunityPageAwardedPickList() {
		sfOpportunitiesPage.verifyQuickCreateOpportunityPageAwardedPickList();
	}

	/**
	 * Validating the Quick create Opportunity page from the Opportunity tab
	 * from Asset Services for State Street pick list value
	 * 
	 * @author Ramya
	 *
	 */

	public void bc_verifyQuickCreateOpportunityPageStateStreetPickList() {
		sfOpportunitiesPage.verifyQuickCreateOpportunityPageStateStreetPickList();
	}

	/**
	 * Validating the Quick create Opportunity page from the Opportunity tab
	 * from Asset Services for Term of Contract field
	 * 
	 * @author Ramya
	 *
	 */

	public void bc_verifyNewOpportunityPageTermOfContract() {
		sfOpportunitiesPage.verifyNewOpportunityPageTermOfContract();
	}

	/**
	 * Validating the Quick create Opportunity page from the Opportunity tab
	 * from Asset Services for Lead Source
	 * 
	 * @author Ramya
	 *
	 */

	public void bc_verifyNewOpportunityPageLeadSource() {
		sfOpportunitiesPage.verifyNewOpportunityPageLeadSource();
	}

	/**
	 * Validating the Quick create Opportunity page from the Opportunity tab
	 * from Asset Services for Annual Revenue Fields
	 * 
	 * @author Ramya
	 *
	 */

	public void bc_verifyOpportunityLeasingAnnualRevenueField() {
		sfOpportunitiesPage.verifyOpportunityLeasingAnnualRevenueField();
	}

	/**
	 * Validating the Quick create Opportunity page from the Opportunity tab
	 * from Asset Services for EBIDTA Fields
	 * 
	 * @author Ramya
	 *
	 */

	public void bc_verifyNewOpportunityEBIDTAFields() {
		sfOpportunitiesPage.verifyNewOpportunityEBIDTAFields();
	}

	/**
	 * Validating the Capital Markets Revenue Field in New Opportunity Page
	 * 
	 * @author Ramya
	 *
	 */

	public void bc_verifyCapitalMarketsRevenueField() {
		sfOpportunitiesPage.verifyCapitalMarketsRevenueField();
	}

	/**
	 * Validating the Speciality Group Field in New Opportunity Page
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
	 * Validating the Average Annual Leasing Commission in New Opportunity Page
	 * for the AMER Broker/Manager
	 * 
	 * @author Ramya
	 *
	 */

	public void bc_verifyOpportunityAverageAnnualLeasingCommissionFieldForAMERManager() {
		sfOpportunitiesPage.verifyOpportunityAverageAnnualLeasingCommissionFieldForAMERManager();
	}

	/**
	 * Validating the Prefered Property Type Mandatory Field in New Opportunity
	 * Page
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
	 * Validating the Quick create Opportunity page from the Opportunity tab
	 * from Asset Services for Term of Contract field for the APAC Manager
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
	 * Validating the Occupier Record Type should default to 'Occupier
	 * Brokerage'
	 * 
	 * @author Vishnuvardhan
	 *
	 */

	public void bc_occupierRecordType() {
		sfOpportunitiesPage.defaultOppRecordType();
	}

	/**
	 * Validating the Occupier Record Type should default to 'Occupier
	 * Brokerage'
	 * 
	 * @author Vishnuvardhan
	 *
	 */

	public void bc_defaultLandingPageDetailsPage() {
		sfOpportunitiesPage.defaultLandingPageDetailsPage();
	}

	/**
	 * Verify the default values Sales Stage and Phase field on the Opportunity
	 * Detail page from a broker profile
	 * 
	 * @author Vishnuvardhan
	 *
	 */

	public void bc_defaultSalesStageandPhaseField() {
		sfOpportunitiesPage.defaultSalesStageandPhaseField();
	}

	/**
	 * Verify the custom Opportunity page layout from a Manager profile
	 * 
	 * @author Vishnuvardhan
	 *
	 */
	public void bc_customOpportunityPageLayout() {
		sfOpportunitiesPage.customOpportunityPageLayout();
	}

	/**
	 * Verify the required fields based on Sales Stage selected between
	 * 08-Closed - Paid Partial to 09-Closed - Paid Full
	 * 
	 * @author Vishnuvardhan
	 *
	 */
	public void bc_salesStage08_ClosedPartial_09_ClosedPaidFull() {
		sfOpportunitiesPage.salesStage08_ClosedPartial_09_ClosedPaidFull();
	}

	/**
	 * Verify Verify the required fields based on Sales Stage selected between
	 * 03-RFP/Proposal to 15-Signed Lease on Opportunity from a broker profile
	 * 
	 * @author Vishnuvardhan
	 *
	 */
	public void bc_salesStage16_In_Escrow_19_Closed() {
		sfOpportunitiesPage.salesStage16_In_Escrow_19_Closed();
	}

	/**
	 * Validating the Technology Tools Field in New Opportunity Page
	 * 
	 * @author Ramya
	 *
	 */

	public void bc_validateOpportunityTechnologyToolsField() {
		sfOpportunitiesPage.validateOpportunityTechnologyToolsField();
	}

	/**
	 * Validating the Targeting Initiative value in New Opportunity Page
	 * 
	 * @author Ramya
	 *
	 */

	public void bc_validateTargetingInitiativePickListValue() {
		sfOpportunitiesPage.validateTargetingInitiativePickListValue();
	}

	/**
	 * Validating the Opportunities Quick create page
	 * 
	 * @author Ramya
	 *
	 */

	public void bc_opportunityQuickCreatePage() {
		sfOpportunitiesPage.opportunityQuickCreatePage();
	}

	/**
	 * Validating the Opportunities Quick create page mandatory fields
	 * 
	 * @author Ramya
	 *
	 */

	public void bc_opportunityQuickCreatePageMandatoryFields() {
		sfOpportunitiesPage.opportunityQuickCreatePageMandatoryFields();
	}

	/**
	 * Validating the Opportunities Quick create page Assignment Type field
	 * 
	 * @author Ramya
	 *
	 */

	public void bc_opportunityQuickCreateAssignmentType() {
		sfOpportunitiesPage.opportunityQuickCreateAssignmentType();
	}

	/**
	 * Validating the Opportunities Team related list columns
	 * 
	 * @author Ramya
	 *
	 */

	public void bc_opportunityTeamRelatedList() {
		sfOpportunitiesPage.opportunityTeamRelatedList();
	}

	/**
	 * Validating the Opportunities Lead Source field
	 * 
	 * @author Ramya
	 *
	 */

	public void bc_opportunityQuickCreateLeadSource() {
		sfOpportunitiesPage.opportunityQuickCreateLeadSource();
	}

	/**
	 * Validating the Opportunities Quick create Comments field
	 * 
	 * @author Ramya
	 *
	 */

	public void bc_opportunityQuickCreateCommentsField() {
		sfOpportunitiesPage.opportunityQuickCreateCommentsField();
	}

	/**
	 * Validating the Opportunities Quick create Comments field
	 * 
	 * @author Ramya
	 *
	 */

	public void bc_validateOpportunityPitchAdvisor() {
		sfOpportunitiesPage.validateOpportunityPitchAdvisor();
	}

	/**
	 * Validating the Opportunities Opportunity Name field
	 * 
	 * @author Ramya
	 *
	 */

	public void bc_validateOpportunityNameQuickCreate() {
		sfOpportunitiesPage.validateOpportunityNameQuickCreate();
	}

	/**
	 * Validating the Opportunities Average Annual Leasing Commission
	 * 
	 * @author Ramya
	 *
	 */

	public void bc_validateOpportunityAverageAnnualLeasingCommission() {
		sfOpportunitiesPage.validateOpportunityAverageAnnualLeasingCommission();
	}

	/**
	 * Validating the Opportunities Quick create page Unit of measure pick list
	 * values
	 * 
	 * @author Ramya
	 *
	 */

	public void bc_verifyPyeongValueInUOMPickList() {
		sfOpportunitiesPage.verifyPyeongValueInUOMPickList();
	}

	/**
	 * Validating the Opportunities Quick create page mandatory fields for the
	 * Auckland Broker
	 * 
	 * @author Ramya
	 *
	 */

	public void bc_validateOpportunityMandatoryFieldsForAucklandBroker() {
		sfOpportunitiesPage.validateOpportunityMandatoryFieldsForAucklandBroker();
	}

	/**
	 * Validating the Opportunities Quick create page Opportunity name default
	 * value
	 * 
	 * @author Ramya
	 *
	 */

	public void bc_validateDefaultOpportunityName() {
		sfOpportunitiesPage.validateDefaultOpportunityName();
	}

	/**
	 * Validating the Opportunities for the Installment Status
	 * 
	 * @author Ramya
	 *
	 */

	public void bc_validateOpportunityInstallmentStatus() {
		sfOpportunitiesPage.validateOpportunityInstallmentStatus();
	}

	/**
	 * Validating the Opportunities for My Active Listings
	 * 
	 * @author Ramya
	 *
	 */

	public void bc_validateOpportunitiesMyActiveListings() {
		sfOpportunitiesPage.validateOpportunitiesMyActiveListings();
	}

	/**
	 * Validating the Opportunities for My Active Listings kanban
	 * 
	 * @author Ramya
	 *
	 */

	public void bc_validateOpportunitiesActiveListingsKanban() {
		sfOpportunitiesPage.validateOpportunitiesActiveListingsKanban();
	}

	/**
	 * Validating the Opportunities for My Active Listings filters
	 * 
	 * @author Ramya
	 *
	 */

	public void bc_validateOpportunitiesActiveListingsFilters() {
		sfOpportunitiesPage.validateOpportunitiesActiveListingsFilters();
	}

	/**
	 * Validating the Opportunities for My Active Listings filters
	 * 
	 * @author Ramya
	 *
	 */

	public void bc_validateOpportunitiesPropertyMarketValue() {
		sfOpportunitiesPage.validateOpportunitiesPropertyMarketValue();
	}

	/**
	 * Validating the Opportunities for Ping value in Unit of Measure Pick list
	 * 
	 * @author Ramya
	 *
	 */

	public void bc_verifyPingValueInUOMPickList() {
		sfOpportunitiesPage.verifyPingValueInUOMPickList();
	}

	/**
	 * Validating the Opportunities for Ping value in Unit of Measure Pick list
	 * for the Opportunity Record Type
	 * 
	 * @author Ramya
	 *
	 */

	public void bc_verifyPingValueInOpportunityRecordTypes() {
		sfOpportunitiesPage.verifyPingValueInOpportunityRecordTypes();
	}

	/**
	 * Validating the Opportunities for Ping value in Unit of Measure Pick list
	 * for the Opportunity Record Type Property Sales
	 * 
	 * @author Ramya
	 *
	 */

	public void bc_verifyPingValueInOpportunityPropertySales() {
		sfOpportunitiesPage.verifyPingValueInOpportunityPropertySales();
	}

	/**
	 * Validating the Opportunities for Market Group and sub Market Group
	 * 
	 * @author Ramya
	 *
	 */

	public void bc_verifyCBREMarketGroup() {
		sfOpportunitiesPage.verifyCBREMarketGroup();
	}

	/**
	 * Validating the Opportunities for the Create Offers
	 * 
	 * @author Ramya
	 *
	 */

	public void bc_verifyNewOfferCreationPage() {
		sfOpportunitiesPage.verifyNewOfferCreationPage();
	}

	/**
	 * Validating the Opportunities for the Create Offers Page fields
	 * 
	 * @author Ramya
	 *
	 */
	public void bc_verifyOfferCreationPageFields() {
		sfOpportunitiesPage.verifyOfferCreationPageFields();

	}

	/**
	 * Validating the Opportunities for the Create Offers Page for the mandatory
	 * fields
	 * 
	 * @author Ramya
	 *
	 */
	public void bc_namingConventionOfOfferObject() {
		sfOpportunitiesPage.namingConventionOfOfferObject();

	}

	/**
	 * Validating the related list of offer object
	 * 
	 * @author Ramya
	 *
	 */
	public void bc_relatedListOfOfferObject() {
		sfOpportunitiesPage.relatedListOfOfferObject();

	}

	/**
	 * Validating the buttons on offer object
	 * 
	 * @author Ramya
	 *
	 */
	public void bc_buttonsOnOfferObject() {
		sfOpportunitiesPage.buttonsOnOfferObject();

	}

	/**
	 * Validating the Headers of offer object
	 * 
	 * @author Ramya
	 *
	 */
	public void bc_headersOfOfferObject() {
		sfOpportunitiesPage.headersOfOfferObject();

	}

	/**
	 * Validating the Discretionary Fee check box in the New Opportunity quick
	 * create page
	 * 
	 * @author Ramya
	 *
	 */
	public void bc_opportunityDiscretionayFee() {
		sfOpportunitiesPage.opportunityDiscretionayFee();

	}

	/**
	 * Validating the Conversion Type field in the New Opportunity quick create
	 * page
	 * 
	 * @author Ramya
	 *
	 */
	public void bc_opportunityConversionTypeField() {
		sfOpportunitiesPage.opportunityConversionTypeField();

	}

	/**
	 * Validating the New Opportunity page Total size field when the sales stage
	 * is Prospecting
	 * 
	 * @author Ramya
	 *
	 */
	public void bc_opportunityTotalSize() {
		sfOpportunitiesPage.opportunityTotalSize();

	}

	/**
	 * Validating the New Opportunity page for the Discretionary Fee check box
	 * unchecked by default
	 * 
	 * @author Ramya
	 *
	 */
	public void bc_opportunityDiscretionayFeeUnChecked() {
		sfOpportunitiesPage.opportunityDiscretionayFeeUnChecked();

	}

	/**
	 * Validating the New Opportunity page for the Net Fee field Mandatory for
	 * the Sales Stage Closed
	 * 
	 * @author Ramya
	 *
	 */
	public void bc_opportunityNetFeeFieldMandatory() {
		sfOpportunitiesPage.opportunityNetFeeFieldMandatory();

	}

	/**
	 * Validating the Opportunity New Installment Creation
	 * 
	 * @author Ramya
	 *
	 */
	public void bc_validateCreationOfNewInstallment() {
		sfOpportunitiesPage.validateCreationOfNewInstallment();

	}

	/**
	 * / * Validating the Clone and Edit buttons in Opportunity VF Page
	 * 
	 * @author Vishnuvardhan
	 *
	 */
	public void bc_cloneAndEditButtonsOpportunity() {
		sfOpportunitiesPage.cloneAndEditButtonsOpportunity();
	}

	/**
	 * Validating the Phase and Probability field when Sales stage is selected
	 * 
	 * @author Vishnuvardhan
	 *
	 */
	public void bc_phaseAndProbabilityValidation() {
		sfOpportunitiesPage.phaseAndProbabilityValidation();
	}

	/**
	 * Validating the APAC Offers Creation Page fields
	 * 
	 * @author Vishnuvardhan
	 *
	 */
	public void bc_APACOfferCreationPageFields() {
		sfOpportunitiesPage.offerCreationPageFieldsAPAC();
	}
	
	/**
	 * Validating the Offers Related List from the APAC Campaign Record
	 * 
	 * @author Vishnuvardhan
	 *
	 */
	public void bc_APACCampaignRecordOffersRelatedLists() {
		sfOpportunitiesPage.offersReleatedListsCampaignAPAC();
	}
	
	/**
	 * Validating the Project Enquiries Page Fields List from the APAC Campaign Record
	 * 
	 * @author Vishnuvardhan
	 *
	 */
	public void bc_APACProjectEnquiryRelatedLists() {
		sfOpportunitiesPage.projectEnquiriesReleatedListsAPAC();
	}
	
	/**
	 * Validating the Project Enquiries Page Fields List from the APAC Property Record
	 * 
	 * @author Vishnuvardhan
	 *
	 */
	public void bc_APACProjectEnquiryPropertyRecord() {
		sfOpportunitiesPage.projectEnquiriesPropertiesListsAPAC();
	}
	/**
	 * Validating Multi Business Line- Do not add Account Name to Opportunity Name when Opportunity is Marked as Confidential
	 * 
	 * @author Vishnuvardhan
	 *
	 */
	public void bc_opportunityNameConfidential() {
		sfOpportunitiesPage.opportunityConfidential();
	}
	
	/**
	 * Validating Opportunity Type field and pick list values in Quick create Page layout for BC&P Opportunity Record Type page layout
	 * 
	 * @author Vishnuvardhan
	 *
	 */
	public void bc_opportunityTypePickList() {
		sfOpportunitiesPage.opportunityTypePickList();
	}
	
	/**
	 * Validating the update on existing fields in VAS Opportunity Record layout
	 * 
	 * @author Vishnuvardhan
	 *
	 */
	public void bc_opportunityRecordLayoutVAS() {
		sfOpportunitiesPage.opportunityRecordLayoutVAS();
	}
	/**
	 * Validating the  Opportunities calculated Annual Leasing Commission
	 * 
	 * @author  Ramya
	 *
	 */
	public void bc_opportunityCalculateAnnualLeasingCommission() {
		sfOpportunitiesPage.opportunityCalculateAnnualLeasingCommission();
	}
	/**
	 * Validating the  Opportunities close information section
	 * 
	 * @author  Ramya
	 *
	 */
	public void bc_opportunityCloseInformationSection() {
		sfOpportunitiesPage.opportunityCloseInformationSection();
	}
	/**
	 * Validating the  Opportunities close information section
	 * 
	 * @author  Ramya
	 *
	 */
	public void bc_opportunitiesClosedDateAndInstallmentDate() {
		sfOpportunitiesPage.opportunitiesClosedDateAndInstallmentDate();
	}
	/**
	 * Validating the  Opportunities create offer page
	 * 
	 * @author  Ramya
	 *
	 */
	public void bc_createOfferOpportunityPage() {
		sfOpportunitiesPage.createOfferOpportunityPage();
	}
	
	/**
	 * Validating the  Opportunities quick create page for the property sales sell side
	 * 
	 * @author  Ramya
	 *
	 */
	public void bc_validateOpportunityQuickCreatePage() {
		sfOpportunitiesPage.validateOpportunityQuickCreatePage();
	}
	/**
	 * Validating the  Opportunities edit page layout
	 * 
	 * @author  Ramya
	 *
	 */
	public void bc_validateOpportunitiesEditPageLayout() {
		sfOpportunitiesPage.validateOpportunitiesEditPageLayout();
	}
	/**
	 * Validating the  Opportunities edit page layout
	 * 
	 * @author  Ramya
	 *
	 */
	public void bc_validateOpportunitiesValuationsEditPage() {
		sfOpportunitiesPage.validateOpportunitiesValuationsEditPage();
	}
	/**
	 * Validating the  Opportunities page layout
	 * 
	 * @author  Ramya
	 *
	 */
	public void bc_validateNewOpportunitiesPage() {
		sfOpportunitiesPage.validateNewOpportunitiesPage();
	}
	/**
	 * Validating the  Opportunities Related objects
	 * 
	 * @author  Ramya
	 *
	 */
	public void bc_validateNewOpportunitiesRelatedObjects() {
		sfOpportunitiesPage.validateNewOpportunitiesRelatedObjects();
	}

	/**
	 * Validating the Opportunities creation for the opportunity record type debt and structured finance
	 * 
	 * @author  Ramya
	 *
	 */
	public void bc_validateOpportunityCreation() {
		sfOpportunitiesPage.validateOpportunityCreation();
	}
	/**
	 * Validating the Opportunities APAC DSF for Financial Details for pacific users
	 * 
	 * @author Ramya
	 *
	 */
	public void bc_validateOpportunitiesFinancialDetails() {
		sfOpportunitiesPage.validateOpportunitiesFinancialDetails();
	}
	/**
	 * Validating the Opportunities creation for APAC Project Manager
	 * 
	 * @author Ramya
	 *
	 */
	public void bc_validateOpportunityCreationForProjectManager() {
		sfOpportunitiesPage.validateOpportunityCreationForProjectManager();
	}
	/**
	 * Validating the Opportunities system Information fields
	 * 
	 * @author Ramya
	 *
	 */
	public void bc_validateOpportunitySystemInformationFields() {
		sfOpportunitiesPage.validateOpportunitySystemInformationFields();
	}
	/**
	 * Validating the Opportunities required fields at sales stage 02
	 * 
	 * @author Ramya
	 *
	 */
	public void bc_validateRequiredFieldsAtSalesStage02() {
		sfOpportunitiesPage.validateRequiredFieldsAtSalesStage02();
	}
	/**
	 * Validating the Opportunities required fields at sales stage 03
	 * 
	 * @author Ramya
	 *
	 */
	public void bc_validateRequiredFieldsAtSalesStage03() {
		sfOpportunitiesPage.validateRequiredFieldsAtSalesStage03();
	}
	/**
	 * Validating the Opportunities recalculate and new installment
	 * 
	 * @author  Ramya
	 *
	 */
	public void bc_validateRecalculateAndNewInstallment() {
		sfOpportunitiesPage.validateRecalculateAndNewInstallment();
	}

	

	
	/**
	 * Validating the Opportunities Tagging
	 * 
	 * @author  Cognizant
	 *
	 */
	public void bc_opportunityTagging() {
		sfOpportunitiesPage.opportunityTagging();
	}
	
	/**
	 * Validating the Opportunities Auto Generate
	 * 
	 * @author  Cognizant
	 *
	 */
	public void bc_opportunityNameAutoGenerateFuntion() {
		sfOpportunitiesPage.opportunityNameAutoGenerateFuntion();
	}
	
	/**
	 * Validating the Opportunities multiple installments
	 * 
	 * @author  Cognizant
	 *
	 */
	public void bc_multipleInstallmentsFunction() {
		sfOpportunitiesPage.multipleInstallmentsFunction();
	}
	
	
	
	/**
	 * Validating the adding installment
	 * 
	 * @author  Cognizant
	 *
	 */
	public void bc_addingInstallmentsOpportunities() {
		sfOpportunitiesPage.addingInstallmentsOpportunities();
	}
	

	/**
	 * Validating the Opportunities installment update
	 * 
	 * @author  Cognizant
	 *
	 */
	public void bc_installmentsOpportunityUpdate() {
		sfOpportunitiesPage.installmentsOpportunityUpdate();
	}
	
	/**
	 * Validating the Opportunities close date
	 * 
	 * @author  Cognizant
	 *
	 */
	public void bc_editCloseDate() {
		sfOpportunitiesPage.editCloseDate();
	}
	
	/**
	 * Validating the Opportunities installment add
	 * 
	 * @author  Cognizant
	 *
	 */
	public void bc_addingInstallmentsAmount() {
		sfOpportunitiesPage.addingInstallmentsAmount();
	}
	
	/**
	 * Validating the Opportunities TeamMember
	 * 
	 * @author  Cognizant
	 *
	 */
	public void bc_opportunityTeamMember() {
		sfOpportunitiesPage.opportunityTeamMember();
	}
	
	
	/**
	 * Validating the Opportunities TeamMember
	 * 
	 * @author  Cognizant
	 *
	 */
	public void bc_opportunitySplit() {
		sfOpportunitiesPage.opportunitySplit();
	}
	
	/**
	 * Validating the Opportunities split percentage
	 * 
	 * @author  Cognizant
	 *
	 */
	public void bc_opportunitySplitPercentage() {
		sfOpportunitiesPage.opportunitySplitPercentage();
	}
	
}
