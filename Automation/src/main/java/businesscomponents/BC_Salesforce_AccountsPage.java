package businesscomponents;

import pages.accountsPage;
import supportlibraries.*;

/**
 * Class for storing login and home page links validation business components
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
	accountsPage sfAccountsPage = new accountsPage(scriptHelper);

	/**
	 * 
	 * Smoke Test business components related to Login
	 */

	public void bc_login() throws InterruptedException {
		sfBC_Login.bc_invokeApplication();
		sfBC_Login.bc_login();
		sfBC_Login.bc_verifyLoginSuccessful();
	}

	/**
	 * 
	 * Smoke Test business components related to Accounts Page
	 */

	public void bc_accountDetailsLandingPage() throws InterruptedException {
		sfAccountsPage.accountDetailsPagebyDefault();
	}

	public void bc_addPrivateNote() throws InterruptedException {
		sfAccountsPage.addPrivateNote();
	}
	
/*	public void bc_createAccount() throws InterruptedException {
		sfAccountsPage.createAccount();
	}*/
	
	public void bc_newAccountPageLayout() throws InterruptedException {
		sfAccountsPage.newAccountPageLayout();
	}
}