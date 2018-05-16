package businessComponents;

import com.cognizant.Craft.DriverScript;
import com.cognizant.Craft.ReusableLibrary;
import com.cognizant.Craft.ScriptHelper;

import pageObjects.MarketingListsPage;

public class BC_Salesforce_MarketingLists extends ReusableLibrary {
	
	
	BC_Salesforce_Login sfBC_Login = new BC_Salesforce_Login(scriptHelper);
	MarketingListsPage marketingListPage = new MarketingListsPage(scriptHelper);
	
	
	/**
	 * Constructor to initialize the component library
	 * 
	 * @param scriptHelper
	 *            The {@link ScriptHelper} object passed from the
	 *            {@link DriverScript}
	 */
	public BC_Salesforce_MarketingLists(ScriptHelper scriptHelper) {
		super(scriptHelper);
		
	}
	
	
	/**
	 * Validating the Login functionality 
	 * 
	 * @author Rajashekar
	 *
	 */	
	public void bc_login() throws InterruptedException {
		sfBC_Login.bc_invokeApplication();
		sfBC_Login.bc_login();
	}
	
	
	public void bc_shareMarketingList()  throws InterruptedException {
		marketingListPage.shareMarketingList();
	}
	
	
	
	
	
	
	

}
