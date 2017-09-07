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
	/**
	 * Validating the creation of new Activity in Contact 
	 * 
	 * @author Ramya
	 *
	 */	
	public void bc_verifyContactNewActivityPageLayout()throws InterruptedException{
		sfContactsPage.verifyContactNewActivityPageLayout();
	}
	/**
	 * Validating the creation of new Activity in Contact 
	 * 
	 * @author Ramya
	 *
	 */	
	public void bc_verifyContactNewActivityPageSendNotificationEmail()throws InterruptedException{
		sfContactsPage.verifyContactNewActivityPageSendNotificationEmail();
	}

	/**
	 * Validating the hyperlink for number of Contacts related to Account
	 * 
	 * @author Vishnuvardhan
	 *
	 */	

	public void bc_hyperlinkContacts() {
		sfContactsPage.validateHyperlinkContacts();		
	}

	/**
	 * Validating the Population of all the required Fields in the New Contact Quick create Page
	 * 
	 * @author Ramya
	 *
	 */	
	public void bc_contactsPopulatingTheRequiredFields()throws InterruptedException{
		sfContactsPage.contactsPopulatingTheRequiredFields();
	}

	/**
	 * Validating the all the fields in the new contact page
	 * 
	 * @author Ramya
	 *
	 */	
	public void bc_newContactPageLayoutFields()throws InterruptedException{
		sfContactsPage.newContactPageLayoutFields();
	}
	/**
	 * Validating the Activity Sent Reminder functionality for the Contacts
	 * 
	 * @author Ramya
	 *
	 */	
	
	public void bc_verifyContactActivityReminderSentFunctionality()throws InterruptedException{
		sfContactsPage.verifyContactActivityReminderSentFunctionality();
	}
	/**
	 * Validating the Contacts Landing page
	 * 
	 * @author Ramyabc_contactsNewContactPageLayout
	 *
	 */	
	public void bc_contactsVerifyLandingPage()throws InterruptedException{
		sfContactsPage.contactsVerifyLandingPage();
	}
	/**
	 * Validating the Contacts Activity Timeline
	 * 
	 * @author Ramya
	 *
	 */	
	public void bc_verifyContactsActivityTimeline()throws InterruptedException{
		sfContactsPage.verifyContactsActivityTimeline();
	} 
	
	/**
	 * Validating the Contacts Updation of contact records
	 * 
	 * @author Ramya
	 *
	 */	
	public void bc_verifyUpdationOfContactRecord()throws InterruptedException{
		sfContactsPage.verifyUpdationOfContactRecord();
	}
	/**
	 * Validating the new Contact Page layout
	 * 
	 * @author Ramya
	 *
	 */	
	public void bc_contactsNewContactPageLayout()throws InterruptedException{
		sfContactsPage.contactsNewContactPageLayout();
	}
	/**
	 * Validating the Population of all the Fields in the New Contact Quick create Page
	 * 
	 * @author Ramya
	 *
	 */	
	public void bc_contactsPopulatingAllFields()throws InterruptedException{
		sfContactsPage.contactsPopulatingAllFields();
	}
	/**
	 * Validating the status and Reason for Inactivation fields in the Contacts edit page
	 * @author Ramya
	 *
	 */
	public void bc_verifyContactEditPageFields()throws InterruptedException{
		sfContactsPage.verifyContactEditPageFields();
	}
	/**
	 * Validating the status and Reason for Inactivation fields in the Contacts edit page
	 * @author Ramya
	 *
	 */
	public void bc_verifyContactEditPageNotEditableFields()throws InterruptedException{
		sfContactsPage.verifyContactEditPageNotEditableFields();
	}
}