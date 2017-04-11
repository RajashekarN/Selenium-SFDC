package businesscomponents;


import pages.homePage;
import supportlibraries.*;

 /**
  * Class for storing login and home page links validation business components
  * @author Vishnuvardhan
  *
  */

public class BC_Salesforce_HomePage extends ReusableLibrary {
	/**
	 * Constructor to initialize the component library
	 * 
	 * @param scriptHelper
	 *            The {@link ScriptHelper} object passed from the
	 *            {@link DriverScript}
	 */
	public BC_Salesforce_HomePage(ScriptHelper scriptHelper) {
		super(scriptHelper);
	}
	
	BC_Salesforce_Login sfBC_Login = new BC_Salesforce_Login(scriptHelper);
	homePage sfHomePage = new homePage(scriptHelper);
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
	 * Smoke Test business components related to validating Home Page Links and Menu's 
	 */
		
	public void bc_verifyHomePageLinks() throws InterruptedException {
		sfHomePage.verify_Home_Page();
		sfHomePage.verify_Welcome_Links();
	}
	
	
	public void bc_verifyHomePageMenus() throws InterruptedException {
		sfHomePage.validate_Menu_Accounts();
		sfHomePage.validate_Menu_Opportunities();
		if((dataTable.getData("General_Data", "Username").contains("cmbroker")) || (dataTable.getData("General_Data", "Username").contains("cmmanager"))) {
			System.out.println("Leads Menu doesn't present for Occupier Brokerage or Manager");
		} else {
			sfHomePage.validate_Menu_Leads();
		}
	}
	
}