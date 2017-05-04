package businessComponents;

import com.cognizant.Craft.ReusableLibrary;
import com.cognizant.Craft.ScriptHelper;

import pageObjects.ContactsPage;

/**
 * Business Components Class for validating functionalities related to Contacts Page
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
	ContactsPage sfContactsPage = new ContactsPage(scriptHelper);

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
	 * Validating the activity Lightning Time line fields 
	 * 
	 * @author Vishnuvardhan
	 *
	 */	

	public void bc_activityLightningTimeline() throws InterruptedException {
		sfContactsPage.activityLightningTimeline();
	}

	/**
	 * Validating the New Contact Page Layout fields
	 * 
	 * @author Vishnuvardhan
	 *
	 */	

	public void bc_newContactPageLayout() {
		sfContactsPage.newContactPageLayout();
	}

	/**
	 * Validating the Account Lookup detail in New Contact 
	 * 
	 * @author Vishnuvardhan
	 *
	 */	

	public void bc_accountLookUpNewContactPage() {
		sfContactsPage.accountLookUpNewContactPage();
	}

	/**
	 * Validating the New notes and files attachment in Contact 
	 * 
	 * @author Ramya
	 *
	 */	
	public void bc_verifyNewNotesAndFileAttachment()throws InterruptedException{
		sfContactsPage.verifyNewNotesAndFileAttachment();
	}
	/**
	 * Validating the Attachment of new notes and files in Contact 
	 * 
	 * @author Ramya
	 *
	 */	

	public void bc_verifyClientContactsNewNotesAndFileAttachment()throws InterruptedException{
		sfContactsPage.verifyClientContactsNewNotesAndFileAttachment();
	}
	/**
	 * Validating the creation of new Activity in Contact 
	 * 
	 * @author Ramya
	 *
	 */	
	public void bc_verifyCreateActivityContact()throws InterruptedException{
		sfContactsPage.verifyCreateActivityContact();
	}
}