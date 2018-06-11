package businessComponents;

import com.cognizant.Craft.ReusableLibrary;
import com.cognizant.Craft.ScriptHelper;
import pageObjects.HomePage;

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
	
	HomePage sfHomePage = new HomePage(scriptHelper);
	
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
		if((dataTable.getData("General_Data", "TC_ID").contains("Broker")) || (dataTable.getData("General_Data", "TC_ID").contains("Manager"))) {
			System.out.println("Leads Menu doesn't present for Occupier Brokerage or Manager");
		} else {
			sfHomePage.validate_Menu_Leads();
		}
	}
	
/*	*//**
	 * Validating the Logout functionality 
	 * 
	 * @author Vishnuvardhan
	 *
	 *//*	
	
	public void bc_logout() throws InterruptedException {
		sfLogin.logout();
	}*/
	
	/**
	 * Validating the tabs on the Home Page for the APAC broker Capital Markets
	 * 
	 * @author Ramya
	 *
	 */	
	
	public void bc_validateHomePageTabsForAPACCapitalMarkets() throws InterruptedException {
		sfHomePage.validateHomePageTabsForAPACCapitalMarkets();
	}
	
	/**
	 * Validating the Support Links for Home Page
	 * 
	 * @author Vishnuvardhan
	 *
	 */	
		
	public void bc_verifySupportLinks() throws InterruptedException {
		sfHomePage.validate_Support_Custom_Links();
	}
	/**
	 * Validating the Home Page for the Account update
	 * 
	 * @author Ramya
	 *
	 */	
		
	public void bc_validateHomePageAccountUpdate() throws InterruptedException {
		sfHomePage.validateHomePageAccountUpdate();
	}
	/**
	 * Validating the Home Page for the SFDC Training Link
	 * 
	 * @author Ramya
	 *
	 */	
		
	public void bc_validateHomePageSFDCTrainingLink() throws InterruptedException {
		sfHomePage.validateHomePageSFDCTrainingLink();
	}
	/**
	 * Validating the Home Page for the recent records
	 * 
	 * @author Ramya
	 *
	 */	
		
	public void bc_validateHomePageRecentRecords() throws InterruptedException {
		sfHomePage.validateHomePageRecentRecords();
	}
	/**
	 * Validating the Home Page for the Marketing Lists
	 * 
	 * @author Ramya
	 *
	 */	
		
	public void bc_validateHomePageMarketingLists() throws InterruptedException {
		sfHomePage.validateHomePageMarketingLists();
	}
	/**
	 * Validating the Home Page Tabs
	 * 
	 * @author Ramya
	 *
	 */	
		
	public void bc_validateHomePageTabs() throws InterruptedException {
		sfHomePage.validateHomePageTabs();
	}
		
}