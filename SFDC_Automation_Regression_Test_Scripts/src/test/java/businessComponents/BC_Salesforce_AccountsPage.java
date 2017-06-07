package businessComponents;

import com.cognizant.Craft.ReusableLibrary;
import com.cognizant.Craft.ScriptHelper;

import pageObjects.AccountsPage;

/**
 * Business Components Class for validating functionalities related to Accounts Page
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

	public void bc_verifyNewNotesAndFilesAttachment() throws InterruptedException{

		sfAccountsPage.verifyNewNotesAndFilesAttachment();

	}
	/**
	 * Validating the creation of new Activity for Accounts 
	 * 
	 * @author Ramya
	 *
	 */
	public void bc_verifyCreateActivityAccount() throws InterruptedException{

		sfAccountsPage.verifyCreateActivityAccount();

	}
	/**
	 * Validating the New Activity Page Layout
	 * 
	 * @author Ramya
	 *
	 */
	public void bc_verifyNewActivityPageLayout() throws InterruptedException{

		sfAccountsPage.verifyNewActivityPageLayout();

	}
	/**
	 * Validating the New Activity Page Layout
	 * 
	 * @author Ramya
	 *
	 */
	public void bc_verifyFollowUpCustomActivity() throws InterruptedException{

		sfAccountsPage.verifyFollowUpCustomActivity();

	} 
	/**
	 * Validating the New Activity Page Notification email
	 * 
	 * @author Ramya
	 *
	 */
	public void bc_verifyAccountsNewActivityPageSendNotificationEmail() throws InterruptedException{

		sfAccountsPage.verifyAccountsNewActivityPageSendNotificationEmail();

	} 
	/**
	 * Validating the Private Tags Bulk Tagging page layout and the Search functionalities
	 * 
	 * @author Ramya
	 *
	 */
	public void bc_verifyPrivateTags() throws InterruptedException{

		sfAccountsPage.verifyPrivateTags();

	} 

	/**
	 * Validating the additional Activity Types in the new Activity on an Account
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
	 * Account Creation - Area of Operations field in Reporting Account Creation Page 
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
	 * Validating the Quick create Accounts page from the Accounts tab  for Investor Profile
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
}