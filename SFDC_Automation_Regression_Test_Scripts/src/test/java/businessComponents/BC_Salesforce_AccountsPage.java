package businessComponents;

import com.cognizant.Craft.ReusableLibrary;
import com.cognizant.Craft.ScriptHelper;

import pageObjects.AccountsPage;
import pageObjects.ActivityPage;
import pagesAPI.AccountsFunctions;
import pagesAPI.Tagging;
import pagesAPI.TaskEventsFunctions;

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

	BC_Salesforce_Login sfBC_Login = new BC_Salesforce_Login(scriptHelper);
	AccountsPage sfAccountsPage = new AccountsPage(scriptHelper);
	AccountsFunctions accountsFunctions = new AccountsFunctions(scriptHelper);
	TaskEventsFunctions taskEventsFunctions = new TaskEventsFunctions(scriptHelper);
	Tagging tagging = new Tagging(scriptHelper);
	ActivityPage sfActivityPage=new ActivityPage(scriptHelper);
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
	
	public void bc_accountActivity(){
		sfAccountsPage.verifyCreateActivityAccount();
	}
	
	public void bc_selectAccount(){
		sfAccountsPage.selectAccount();
	}
	
	public void bc_createOpportunityOnAccount(){
		sfAccountsPage.accountToOpportunity();
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
		sfAccountsPage.accountDetailsPagebyDefault();
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
	 * Validating the New Account Page Layout fields
	 * 
	 * @author Vishnuvardhan
	 *
	 */

	public void bc_newAccountPageLayout() throws InterruptedException {
		sfAccountsPage.newAccountPageLayout();
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
	 * Validating the New Accounts, Leads and Private Tags
	 * 
	 * @author Ramya
	 *
	 */
	public void bc_verifyAccountsLeadsAndPrivateTags() throws InterruptedException {
		sfAccountsPage.verifyAccountsLeadsAndPrivateTags();
	}

	/**
	 * Validating the New Account populating the required fields
	 * 
	 * @author Ramya
	 *
	 */
	public void bc_verifyAccountsPopulatingRequiredFields() throws InterruptedException {
		sfAccountsPage.verifyAccountsPopulatingRequiredFields();
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
	 * Validating the New Accounts Page Layout
	 * 
	 * @author Ramya
	 *
	 */
	public void bc_verifyAccountsPageLayout() throws InterruptedException {
		sfAccountsPage.verifyAccountsPageLayout();
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
	 * Account Creation and Validation of fields
	 * 
	 * @author Vishnuvardhan
	 *
	 */
	public void bc_accountCreationValidationFields() throws InterruptedException {
		accountsFunctions.createAccountSpecificUser();
		accountsFunctions.accountPageFieldsValidation();
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
	 *  Validating the existing account tagging 
	 * 
	 * @author cognizant
	 *
	 */
	public void bc_verifyAccountTagging() throws InterruptedException {
		sfAccountsPage.verifyAccountTagging();
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
}