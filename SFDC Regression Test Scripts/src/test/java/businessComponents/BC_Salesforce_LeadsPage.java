package businessComponents;

import com.cognizant.Craft.ReusableLibrary;
import com.cognizant.Craft.ScriptHelper;

import pageObjects.LeadsPage;

/**
 * Business Components Class for validating functionalities related to Leads Page
 * 
 * @author Vishnuvardhan
 *
 */

public class BC_Salesforce_LeadsPage extends ReusableLibrary {
	/**
	 * Constructor to initialize the component library
	 * 
	 * @param scriptHelper
	 *            The {@link ScriptHelper} object passed from the
	 *            {@link DriverScript}
	 */
	public BC_Salesforce_LeadsPage(ScriptHelper scriptHelper) {
		super(scriptHelper);
	}

	BC_Salesforce_Login sfBC_Login = new BC_Salesforce_Login(scriptHelper);
	LeadsPage sfLeadsPage = new LeadsPage(scriptHelper);

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
	 * Validating the Convert Lead functionality 
	 * 
	 * @author Vishnuvardhan
	 *
	 */	

	public void bc_convertLead() throws InterruptedException {
		sfLeadsPage.convertLead();
	}
	
	/**
	 * Validating the Create Lead functionality 
	 * 
	 * @author Vishnuvardhan
	 *
	 */	
	
	public void bc_createLead_UI() throws InterruptedException {
		sfLeadsPage.createLead();
	}
	
	/**
	 * Validating the Create Greenspace Lead functionality 
	 * 
	 * @author Vishnuvardhan
	 *
	 */	
	
	public void bc_createGreenspaceLead() throws InterruptedException {
		sfLeadsPage.createGreenspaceLead();
	}
	
	/**
	 * Validating the Clone and Edit buttons in Lead Detail page
	 * 
	 * @author Vishnuvardhan
	 *
	 */	
	
	public void bc_cloneAndEditButtons() throws InterruptedException {
		sfLeadsPage.cloneAndEditButtons();
	}
	
	/**
	 * Validating the Related lists of a Lead in the Lead Landing page
	 * 
	 * @author Vishnuvardhan
	 *
	 */	
	
	public void bc_relatedListsLeadLandingPage() {
		sfLeadsPage.relatedListsLeadLandingPage();
	}
	
	/**
	 * Validating the Private Note functionality for Lead
	 * 
	 * @author Vishnuvardhan
	 *
	 */	
	
	public void bc_privateNoteLead() {
		sfLeadsPage.privateNoteLead();
	}
	
	/**
	 * Validating the Convert Lead by adding the new account in the Convert Lead page
	 * 
	 * @author Vishnuvardhan
	 *
	 */	

	public void bc_convertLeadNewAccount() {
		sfLeadsPage.convertLeadNewAccount();
	}
	
	/**
	 * Validating the Convert Lead by selecting the existing account in the Convert Lead page
	 * 
	 * @author Vishnuvardhan
	 *
	 */	

	public void bc_convertLeadExistingAccount() {
		sfLeadsPage.convertLeadExistingAccount();
	}
	
	
	/**
	 * Validating the Convert Lead Note by adding an attachment and verifying it 
	 * 
	 * @author Ramya
	 *
	 */	

	public void bc_convertLeadNote() {
		sfLeadsPage.convertLeadNote();
	}
}