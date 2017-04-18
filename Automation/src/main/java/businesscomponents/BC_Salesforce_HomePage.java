package businesscomponents;


import pages.HomePage;
import pages.LoginPage;
import supportlibraries.*;

/**
 * Business Components Class for validating functionalities related to Home Page
 * 
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
	HomePage sfHomePage = new HomePage(scriptHelper);
	LoginPage sfLogin = new LoginPage(scriptHelper);
	
	/**
	 * Validating the Login functionality 
	 * 
	 * @author Vishnuvardhan
	 *
	 */	
	public void bc_login() throws InterruptedException {
		sfBC_Login.bc_invokeApplication();
		sfBC_Login.bc_login();
		sfBC_Login.bc_verifyLoginSuccessful();
	}

	/**
	 * Validating the Home Page and Welcome Links
	 * 
	 * @author Vishnuvardhan
	 *
	 */	
		
	public void bc_verifyHomePageLinks() throws InterruptedException {
		sfHomePage.verify_Home_Page();
		sfHomePage.verify_Welcome_Links();
	}
	
	/**
	 * Validating the Home Page Menu
	 * 
	 * @author Vishnuvardhan
	 *
	 */	
	
	public void bc_verifyHomePageMenus() throws InterruptedException {
		sfHomePage.validate_Menu_Accounts();
		sfHomePage.validate_Menu_Opportunities();
		if((dataTable.getData("General_Data", "Username").contains("cmbroker")) || (dataTable.getData("General_Data", "Username").contains("cmmanager"))) {
			System.out.println("Leads Menu doesn't present for Occupier Brokerage or Manager");
		} else {
			sfHomePage.validate_Menu_Leads();
		}
	}
	
	/**
	 * Validating the Logout functionality 
	 * 
	 * @author Vishnuvardhan
	 *
	 */	
	
	public void bc_logout() throws InterruptedException {
		sfLogin.logout();
	}
 	
}