package businessComponents;

import com.cognizant.Craft.ReusableLibrary;
import com.cognizant.Craft.ScriptHelper;

import pageObjects.LeadsPage;
import pagesAPI.LeadsFunctions;

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
	LeadsFunctions leadsFunctions = new LeadsFunctions(scriptHelper);

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
	/**
	 * Validating the Custom Event Page in Leads 
	 * 
	 * @author Ramya
	 *
	 */	

	public void bc_leadsVerifyCustomEventPage() {
		sfLeadsPage.leadsVerifyCustomEventPage();
	}
	/**
	 * Validating the personal Information Page from the  Leads
	 * 
	 * @author Ramya
	 *
	 */	

	public void bc_leadsVerifyPrivateNotePersonalInformation() {
		sfLeadsPage.leadsVerifyPrivateNotePersonalInformation();
	}

	/**
	 * Validating the Custom Event Page in Leads 
	 * 
	 * @author Ramya
	 *
	 */	

	public void bc_verifyLeadsNewCustomPage() {
		sfLeadsPage.verifyLeadsNewCustomPage();
	}
	/**
	 * Validating the Convert Leads page with Direct Line and Private Notes
	 * 
	 * @author Ramya
	 *
	 */	

	public void bc_convertLeadWithDirectLineAndPrivateNote() {
		sfLeadsPage.convertLeadWithDirectLineAndPrivateNote();
	}
	/**
	 * Validating the Convert Leads page with Private Note
	 * 
	 * @author Ramya
	 *
	 */	

	public void bc_convertLeadWithPrivateNote() {
		sfLeadsPage.convertLeadWithPrivateNote();
	}
	
	/**
	 * Validating the Convert Leads page with Email
	 * 
	 * @author Ramya
	 *
	 */	

	public void bc_convertLeadWithEmail() {
		sfLeadsPage.convertLeadWithEmail();
	}
	
	/**
	 * Validating the Leads landing page
	 * 
	 * @author Ramya
	 *
	 */	

	public void bc_leadsVerifyLandingPage() {
		sfLeadsPage.leadsVerifyLandingPage();
	}
	
	/**
	 * Validating the Leads sharing functionality Page
	 * 
	 * @author Ramya
	 *
	 */	

	public void bc_leadsSharingFunctionality() {
		sfLeadsPage.leadsSharingFunctionality();
	}
	/**
	 * Validating the Leads sharing functionality Page
	 * 
	 * @author Ramya
	 *
	 */	

	public void bc_leadCustomLogACallFunctionality() {
		sfLeadsPage.leadCustomLogACallFunctionality();
	}
	/**
	 * Validating the Leads Activity Timeline
	 * 
	 * @author Ramya
	 *
	 */	

	public void bc_verifyLeadsActivityTimeline() {
		sfLeadsPage.verifyLeadsActivityTimeline();
	}
	/**
	 * Validating the Lead convert with the existing Account
	 * 
	 * @author Ramya
	 *
	 */	

	public void bc_leadConvertWithExistingAccount() {
		sfLeadsPage.leadConvertWithExistingAccount();
	}
	/**
	 * Validating the Lead convert with the new Account
	 * 
	 * @author Ramya
	 *
	 */	

	public void bc_leadConvertWithNewAccount() {
		sfLeadsPage.leadConvertWithNewAccount();
	}
	
	/**
	 * Validating the Lead convert with the Associated Contact
	 * 
	 * @author Ramya
	 *
	 */	

	public void bc_convertLeadWithAssociatedContact() {
		sfLeadsPage.convertLeadWithAssociatedContact();
	}
	/**
	 * Validating the Lead convert with the Prefered Property
	 * 
	 * @author Ramya
	 *
	 */	

	public void bc_leadConvertWithPreferedProperty() {
		sfLeadsPage.leadConvertWithPreferedProperty();
	}
	/**
	 * Validating the Leads Pyeong value in Unit of Measure
	 * 
	 * @author Ramya
	 *
	 */	

	public void bc_verifyLeadsPyeongValueInUOMPickList() {
		sfLeadsPage.verifyLeadsPyeongValueInUOMPickList();
	}
	/**
	 * Validating the Leads Ping value in Unit of Measure
	 * 
	 * @author Ramya
	 *
	 */	

	public void bc_verifyLeadsPingValueInUOMPickList() {
		sfLeadsPage.verifyLeadsPingValueInUOMPickList();
	}
	
	/**
	 * Validating the Private Note Sharing functionality for Lead
	 * 
	 * @author Vishnuvardhan
	 *
	 */	

	public void bc_privateNoteSharing() {
		sfLeadsPage.privateNoteSharing();
	}
	/**
	 * Validating the Activity creation on Leads
	 * 
	 * @author Ramya
	 *
	 */	

	public void bc_verifyLeadActivityCreation() {
		sfLeadsPage.verifyLeadActivityCreation();
	}
	/**
	 * Validating the Activity creation on Leads
	 * 
	 * @author Ramya
	 *
	 */	

	public void bc_verifyLeadsPrivateTags() {
		sfLeadsPage.verifyLeadsPrivateTags();
	}
	
	/**
	 * Lead Creation and Validation of fields
	 * 
	 * @author Vishnuvardhan
	 *
	 */
	public void bc_leadCreationValidationFields() throws InterruptedException {
		leadsFunctions.createLeadSpecificUser();
		leadsFunctions.leadPageFieldsValidation();
	}
	
	/**
	 * Lead Conversion via API
	 * 
	 * @author Vishnuvardhan
	 *
	 */
	public void bc_leadConversionAPI() throws InterruptedException {
		leadsFunctions.leadConversion();
	}
}

