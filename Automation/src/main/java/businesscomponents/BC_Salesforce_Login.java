package businesscomponents;

import pages.accountsPage;
import pages.homePage;
import pages.loginPage;
import pages.opportunitiesPage;
import supportlibraries.*;

 /**
  * Class for storing login and home page links validation business components
  * @author Vishnuvardhan
  *
  */

public class BC_Salesforce_Login extends ReusableLibrary {
	/**
	 * Constructor to initialize the component library
	 * 
	 * @param scriptHelper
	 *            The {@link ScriptHelper} object passed from the
	 *            {@link DriverScript}
	 */
	public BC_Salesforce_Login(ScriptHelper scriptHelper) {
		super(scriptHelper);
	}

	loginPage sfLogin = new loginPage(scriptHelper);
	homePage sfHomePage = new homePage(scriptHelper);
	accountsPage sfAccountPage = new accountsPage(scriptHelper);
	opportunitiesPage sfOpportunityPage = new opportunitiesPage(scriptHelper);
	
	/**
	 * 
	 * Smoke Test business components related to Login
	 */
	
	public void bc_invokeApplication() throws InterruptedException {
		sfLogin.invokeApplication();
	}

	public void bc_login() throws InterruptedException {
		sfLogin.login();
	}

	public void bc_verifyLoginSuccessful() throws InterruptedException {
		sfLogin.verifyLoginSuccessful();
	}
	
}