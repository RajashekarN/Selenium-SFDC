package businesscomponents;

import pages.contactsPage;
import pages.leadsPage;
import supportlibraries.*;

/**
 * Class for storing login and home page links validation business components
 * 
 * @author Vishnuvardhan
 *
 */

public class BC_Salesforce_ContactsPage extends ReusableLibrary {
	/**
	 * Constructor to initialize the component library
	 * 
	 * @param scriptHelper
	 *            The {@link ScriptHelper} object passed from the
	 *            {@link DriverScript}
	 */
	public BC_Salesforce_ContactsPage(ScriptHelper scriptHelper) {
		super(scriptHelper);
	}

	BC_Salesforce_Login sfBC_Login = new BC_Salesforce_Login(scriptHelper);
	contactsPage sfContactsPage = new contactsPage(scriptHelper);
	
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
	 * Smoke Test business components related to Opportunities Page
	 */

	public void bc_activityLightningTimeline() throws InterruptedException {
		sfContactsPage.activityLightningTimeline();
	}
	
	public void bc_newContactPageLayout() {
		sfContactsPage.newContactPageLayout();
	}
}