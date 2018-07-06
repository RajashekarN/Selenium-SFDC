package businessComponents;

import com.cognizant.Craft.ReusableLibrary;
import com.cognizant.Craft.ScriptHelper;
import pageObjects.AccountsPage;


/**
 * Business Components Class for validating functionalities related to Accounts
 * Page
 * 
 * @author Vishnuvardhan
 *
 */

public class BC_Salesforce_AccountsPage extends ReusableLibrary {
	/**
	 * Constructor to initialize the component library
	 * 
	 * @param scriptHelper
	 *            The {@link ScriptHelper} object passed from the
	 *            {@link DriverScript}
	 */
	public BC_Salesforce_AccountsPage(ScriptHelper scriptHelper) {
		super(scriptHelper);
	}

	AccountsPage sfAccountsPage = new AccountsPage(scriptHelper);

/*	*//**
	 * Validating the Login functionality
	 * 
	 * @author Vishnuvardhan
	 *
	 *//*

	public void bc_login() throws InterruptedException {
		sfBC_Login.bc_invokeApplication();
		sfBC_Login.bc_login();
	}*/
	
	
	
	public void bc_accountPageDetailFieldsValidation() {
		sfAccountsPage.accountPageFieldsValidation();
	}
	
	public void bc_accountActivity(){
		sfAccountsPage.verifyCreateActivityAccount();
	}
	
	public void bc_navigateToTag(){
		sfAccountsPage.navigateToTag();
	}
	
	public void bc_shareTag(){
		sfAccountsPage.shareTag();
	}
	
	
	public void bc_selectAccount(){
		sfAccountsPage.selectAccount();
	}
	
	public void bc_createOpportunityOnAccount(){
		sfAccountsPage.accountToOpportunity();
	}
	
	public void bc_createOpportunity(){
		sfAccountsPage.createnewOpportunity();
	}
	
	/*public void bc_validateActivityDetails(){
		sfActivityPage.validateActivityDetails();
	}
	 public void bc_validateCreatedActivities(){
		 sfActivityPage.validateAccountActivity();
	 }
	 public void bc_validateCreatedActivitiyExpandAll(){
		 sfActivityPage.validateActivityExpandAll();
	 }
	 
	 public void bc_eventActivity(){
		 sfActivityPage.validateEventActivity();
	 }*/

	/**
	 * Validating the Account Landing Page functionality
	 * 
	 * @author Vishnuvardhan
	 *
	 */

	public void bc_accountDetailsLandingPage() throws InterruptedException {
		sfAccountsPage.accountPageFieldsValidation();
	}

	/**
	 * Validating the addition of Private Notes functionality
	 * 
	 * @author Vishnuvardhan
	 *
	 */

	public void bc_addPrivateNote() throws InterruptedException {
		sfAccountsPage.addPrivateNote();
	}

	/**
	 * Validating the addition of New Personal information
	 * 
	 * @author Ramya
	 *
	 */

	public void bc_addNewPersonalInformation() throws InterruptedException {
		sfAccountsPage.addNewPersonalInformation();
	}

	/**
	 * Validating the attachment of New Notes and Files
	 * 
	 * @author Ramya
	 *
	 */

	public void bc_verifyNewNotesAndFilesAttachment() throws InterruptedException {

		sfAccountsPage.verifyNewNotesAndFilesAttachment();

	}

	/**
	 * Validating the creation of new Activity for Accounts
	 * 
	 * @author Ramya
	 *
	 */
	public void bc_verifyCreateActivityAccount() throws InterruptedException {

		sfAccountsPage.verifyCreateActivityAccount();

	}

	/**
	 * Validating the New Activity Page Layout
	 * 
	 * @author Ramya
	 *
	 */
	public void bc_verifyNewActivityPageLayout() throws InterruptedException {

		sfAccountsPage.verifyNewActivityPageLayout();

	}

	/**
	 * Validating the New Activity Page Layout
	 * 
	 * @author Ramya
	 *
	 */
	public void bc_verifyFollowUpCustomActivity() throws InterruptedException {

		sfAccountsPage.verifyFollowUpCustomActivity();

	}

	/**
	 * Validating the New Activity Page Notification email
	 * 
	 * @author Ramya
	 *
	 */
	public void bc_verifyAccountsNewActivityPageSendNotificationEmail() throws InterruptedException {

		sfAccountsPage.verifyAccountsNewActivityPageSendNotificationEmail();

	}

	/**
	 * Validating the Private Tags Bulk Tagging page layout and the Search
	 * functionalities
	 * 
	 * @author Ramya
	 *
	 */
	public void bc_verifyPrivateTags() throws InterruptedException {

		sfAccountsPage.verifyPrivateTags();

	}

	/**
	 * Validating the additional Activity Types in the new Activity on an
	 * Account
	 * 
	 * @author Vishnuvardhan
	 *
	 */

	public void bc_additionalActivityTypes() throws InterruptedException {
		sfAccountsPage.additionalActivityTypes();
	}

	/**
	 * Validating the Investor Services Checkbox
	 * 
	 * @author Vishnuvardhan
	 *
	 */

	public void bc_validateInvestorServices() throws InterruptedException {
		sfAccountsPage.validateInvestorServicesCheckbox();
	}

	/**
	 * Validating the Account Record Type Field in Record Type of Accounts
	 * 
	 * @author Vishnuvardhan
	 *
	 */
	public void bc_accountRecordType() {
		sfAccountsPage.accountRecordTypeField();
	}

	/**
	 * Account Creation - Area of Operations field in Reporting Account Creation
	 * Page
	 * 
	 * @author Vishnuvardhan
	 *
	 */

	public void bc_areaOfOperationsAccountCreation() {
		sfAccountsPage.areaOfOperationsAccountCreation();
	}

	/**
	 * CBRE Data Admin Access to CIM reports (CLASSIC)
	 * 
	 * @author Vishnuvardhan
	 *
	 */

	public void bc_reportsCIM() {
		sfAccountsPage.reportsCIMDataAdmin();
	}

	/**
	 * Validating the Quick create Accounts page from the Accounts tab for
	 * Investor Profile
	 * 
	 * @author Ramya
	 *
	 */
	public void bc_verifyQuickCreateAccountsPageInvestorProfile() throws InterruptedException {
		sfAccountsPage.verifyQuickCreateAccountsPageInvestorProfile();
	}

	/**
	 * Validating the Accounts related Page for Investor Service Check Box
	 * 
	 * @author Ramya
	 *
	 */
	public void bc_verifyAccountsInvestorServiceCheckBox() throws InterruptedException {
		sfAccountsPage.verifyAccountsInvestorServiceCheckBox();
	}

	/**
	 * Validating the additional Activity Type in the New Activity
	 * 
	 * @author Ramya
	 *
	 */
	public void bc_verifyAccountsNewActivityType() throws InterruptedException {
		sfAccountsPage.verifyAccountsNewActivityType();
	}



	/**
	 * Validating the view Hierarchy for the existing Accounts
	 * 
	 * @author Ramya
	 *
	 */
	public void bc_verifyAccountsViewHierarchy() throws InterruptedException {
		sfAccountsPage.verifyAccountsViewHierarchy();
	}
	
	/**
	 * Validating the Accounts Details Page 
	 * 
	 * @author Ramya
	 *
	 */
	public void bc_verifyAccountsLandingPageDetailsLayout() throws InterruptedException {
		sfAccountsPage.verifyAccountsLandingPageDetailsLayout();
	}
	
	/**
	 * Validating the Accounts Details Page Manager
	 * 
	 * @author Ramya
	 *
	 */
	public void bc_verifyAccountsLandingPageDetailsLayoutManager() throws InterruptedException {
		sfAccountsPage.verifyAccountsLandingPageDetailsLayoutManager();
	}
	
	/**
	 * Validating the Accounts Details Page Broker
	 * 
	 * @author Ramya
	 *
	 */
	public void bc_verifyAccountsLandingPageDetailsLayoutBroker() throws InterruptedException {
		sfAccountsPage.verifyAccountsLandingPageDetailsLayoutBroker();
	}
	
	/**
	 * Validating the SPOCs in the Accounts related Page
	 * 
	 * @author Ramya
	 *
	 */
	public void bc_verifySPOCsAccount() throws InterruptedException {
		sfAccountsPage.verifySPOCsAccount();
	}
	/**
	 * Validating the SPOCs Page Layout
	 * 
	 * @author Ramya
	 *
	 */
	public void bc_verifySPOCsPageLayout() throws InterruptedException {
		sfAccountsPage.verifySPOCsPageLayout();
	}
	/**
	 * Validating the Accounts Custom Activity time line
	 * 
	 * @author Ramya
	 *
	 */
	public void bc_verifyAccountsActivityTimeline() throws InterruptedException {
		sfAccountsPage.verifyAccountsActivityTimeline();
	}
	
	/**
	 *  Validating the Account Details edit page
	 * 
	 * @author Ramya
	 *
	 */
	public void bc_verifyEditingExistingAccount() throws InterruptedException {
		sfAccountsPage.verifyEditingExistingAccount();
	}
	
	/**
	 *  Validating the APAC Quick create Page Industry fields
	 * 
	 * @author Ramya
	 *
	 */
	public void bc_verifyAPACIndustry() throws InterruptedException {
		sfAccountsPage.verifyAPACIndustry();
	}
	/**
	 *  Validating the Accounts Client Knowledge center field
	 * 
	 * @author Ramya
	 *
	 */
	public void bc_verifyAccountsClientKnowledgeCenterField() throws InterruptedException {
		sfAccountsPage.verifyAccountsClientKnowledgeCenterField();
	}
	/**
	 *  Validating the submit Account Update Request
	 * 
	 * @author Ramya
	 *
	 */
	public void bc_verifySubmitAccUpdateRequest() throws InterruptedException {
		sfAccountsPage.verifySubmitAccUpdateRequest();
	}
	/**
	 *  Validating the Private Tag functionality
	 * 
	 * @author Ramya
	 *
	 */
	public void bc_verifyPrivateTagFunctionality() throws InterruptedException {
		sfAccountsPage.verifyPrivateTagFunctionality();
	}
	/**
	 *  Validating the Bulk Tagging functionality
	 * 
	 * @author Ramya
	 *
	 */
	public void bc_verifyBulkTagging() throws InterruptedException {
		sfAccountsPage.verifyBulkTagging();
	}
	/**
	 *  Validating the Budgets/Targets page 
	 * 
	 * @author Ramya
	 *
	 */
	public void bc_verifyBudgetsTargets() throws InterruptedException {
		sfAccountsPage.verifyBudgetsTargets();
	}
	/**
	 *  Validating the Budgets/Targets page 
	 * 
	 * @author Ramya
	 *
	 */
	public void bc_verifyBudgetsTargetsEditing() throws InterruptedException {
		sfAccountsPage.verifyBudgetsTargetsEditing();
	}
	
	
	/**
	 *  Validating the account tagging
	 * 
	 * @author cognizant
	 *
	 */
	public void bc_accountTagging() throws InterruptedException {
		sfAccountsPage.accountTagging();
		}
	

	
	/**
	 *  Validating the create Budgte Target
	 * 
	 * @author cognizant
	 *
	 */
	public void bc_createBudgetTarget() throws InterruptedException {
		sfAccountsPage.createBudgetTarget();
		}
	
	/**
	 *  Validating the Delete Budget Target
	 * 
	 * @author cognizant
	 *
	 */
	public void bc_deleteBudgteTarget() throws InterruptedException {
		sfAccountsPage.deleteBudgteTarget();
		}
	
	/**
	 *  Validating the Edit Budgets/Targets
	 * 
	 * @author cognizant
	 *
	 */
	public void bc_editBudgetTarget() throws InterruptedException {
		sfAccountsPage.editBudgetTarget();
		}
	
	/**
	 *  Validating the Cloning Budgets/Targets
	 * 
	 * @author cognizant
	 *
	 */
	public void bc_cloningBudgetTarget() throws InterruptedException {
		sfAccountsPage.cloningBudgetTarget();
		}
	
	
	/**
	 * Function for creating an EMEA reporting account
	 * 
	 * @author Haritha
	 */
	public void bc_emeaReportingAccount() throws InterruptedException {
		sfAccountsPage.emeaReportingAccount();
	}
	
	/**
	 * Validating the Account's Opportunities Field in Record Type of Accounts for France users
	 * 
	 * @author Haritha
	 *
	 */
	public void bc_accountsOpportunitiesTypeField() throws InterruptedException {
		sfAccountsPage.accountsOpportunitiesTypeField();
	}
	
	
}