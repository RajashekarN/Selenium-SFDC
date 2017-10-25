package businessComponents;

import com.cognizant.Craft.ReusableLibrary;
import com.cognizant.Craft.ScriptHelper;
import com.cognizant.framework.Status;
import com.sforce.soap.partner.SaveResult;

import pageObjects.LoginPage;
import pagesAPI.AccountsFunctions;
import pagesAPI.ActivityFunctions;
import pagesAPI.ContactsFunctions;
import pagesAPI.CreateUsers;
import pagesAPI.EstablishConnection;
import pagesAPI.LeadFunctions;
import pagesAPI.OpportunitiesFunctions;
import pagesAPI.SearchTextSOQL;

/**
 * Business Components Class for validating the API calls 
 * 
 * @author Vishnuvardhan
 *
 */

public class BC_API_Test extends ReusableLibrary {
	/**
	 * Constructor to initialize the component library
	 * 
	 * @param scriptHelper
	 *            The {@link ScriptHelper} object passed from the
	 *            {@link DriverScript}
	 */
	public BC_API_Test(ScriptHelper scriptHelper) {
		super(scriptHelper);
	}
	
	EstablishConnection sfEstablishConnection = new EstablishConnection(scriptHelper);
	AccountsFunctions sfAccountsFunctions = new AccountsFunctions(scriptHelper);
	ContactsFunctions sfContactsFunctions = new ContactsFunctions(scriptHelper);
	OpportunitiesFunctions sfOpportunitiesFunctions = new OpportunitiesFunctions(scriptHelper);
	LeadFunctions sfLeadsFunctions = new LeadFunctions(scriptHelper);
	SearchTextSOQL sfSearchText = new SearchTextSOQL(scriptHelper);	
	CreateUsers createUsers = new CreateUsers(scriptHelper);
	LoginPage loginPage = new LoginPage(scriptHelper);
	ActivityFunctions activityFunctions = new ActivityFunctions(scriptHelper);
	
	/**
	 * Validating the Login functionality
	 * 
	 * @author Vishnuvardhan
	 *
	 */

	public void bc_valdiateLogin() {
		boolean status = sfEstablishConnection.retrieveUserConfiguration();
		if(status==true) {
			report.updateTestLog("Verify Login", "Login to the application is successful", Status.PASS);
		} else {
			report.updateTestLog("Verify Login", "Login to the application is failed", Status.FAIL);
		}
	}	

	/**
	 * Validating the Create Account functionality
	 * 
	 * @author Vishnuvardhan
	 *
	 */

	public void bc_createAccount() {
		SaveResult[] results = sfAccountsFunctions.createAccount();
		String result = sfEstablishConnection.saveResultsId(results);
		if(result.contains("001")) {
			report.updateTestLog("Verify Create Account", "Account has been created successfully", Status.PASS);
		} else {
			report.updateTestLog("Verify Create Account", "Account creation failed", Status.FAIL);
		}
	}

	/**
	 * Validating the Update Accounts functionality
	 * 
	 * @author Vishnuvardhan
	 *
	 */

	public void bc_updateAccounts() {
		boolean status = sfAccountsFunctions.updateAccounts();
		if(status==true) {
			report.updateTestLog("Verify Update Accounts", "Account has been updated successfully", Status.PASS);
		} else {
			report.updateTestLog("Verify Update Accounts", "Account updation failed", Status.FAIL);
		}
	}

	/**
	 * Validating the Delete Accounts functionality
	 * 
	 * @author Vishnuvardhan
	 *
	 */

	public void bc_deleteAccounts() {
		boolean status = sfAccountsFunctions.deleteAccounts();
		if(status==true) {
			report.updateTestLog("Verify Delete Account", "Account has been deleted successfully", Status.PASS);
		} else {
			report.updateTestLog("Verify Delete Account", "Account deletion failed", Status.FAIL);
		}
	}

	/**
	 * Class for validating the Create Contact functionality
	 * 
	 * @author Vishnuvardhan
	 *
	 */

	public void bc_createContact() {
		boolean status = sfContactsFunctions.createContacts();
		if(status==true) {
			report.updateTestLog("Verify Create Contact", "Contact has been created successfully", Status.PASS);
		} else {
			report.updateTestLog("Verify Create Contact", "Contact creation failed", Status.FAIL);
		}
	}

	/**
	 * Validating the Update Contacts functionality
	 * 
	 * @author Vishnuvardhan
	 *
	 */

	public void bc_updateContacts() {
		boolean status = sfContactsFunctions.updateContacts();
		if(status==true) {
			report.updateTestLog("Verify Update Contact", "Contact has been created successfully", Status.PASS);
		} else {
			report.updateTestLog("Verify Update Contact", "Contact creation failed", Status.FAIL);
		}
	}

	/**
	 * Validating the Delete Contacts functionality
	 * 
	 * @author Vishnuvardhan
	 *
	 */

	public void bc_deleteContacts() {
		boolean status = sfContactsFunctions.deleteContacts();
		if(status==true) {
			report.updateTestLog("Verify Delete Contact", "Contact has been deleted successfully", Status.PASS);
		} else {
			report.updateTestLog("Verify Delete Contact", "Contact deletion failed", Status.FAIL);
		}
	}

	/**
	 * Validating the Search Phone Number functionality
	 * 
	 * @author Vishnuvardhan
	 *
	 */

	public void bc_searchPhoneNumber() {
		boolean status = sfAccountsFunctions.searchPhonenumber(dataTable.getData("General_Data", "SearchPhoneNumber"));
		if(status==true) {
			report.updateTestLog("Verify Search Phone Number", "Phone Number has been searched successfully", Status.PASS);
		} else {
			report.updateTestLog("Verify Search Phone Number", "Search Phone Number failed", Status.FAIL);
		}
	}

	/**
	 * Validating the Create Opportunity functionality
	 * 
	 * @author Vishnuvardhan
	 *
	 */

	public void bc_createOpportunity() {
		boolean status = sfOpportunitiesFunctions.createOpportunity();
		if(status==true) {
			report.updateTestLog("Verify Create Opportunity", "Opportunity has been deleted successfully", Status.PASS);
		} else {
			report.updateTestLog("Verify Create Opportunity", "Opportunity creation failed", Status.FAIL);
		}
	}

	/**
	 * Validating the Update Opportunity functionality
	 * 
	 * @author Vishnuvardhan
	 *
	 */

	public void bc_updateOpportunity() {
		boolean status = sfOpportunitiesFunctions.updateOpportunities();
		if(status==true) {
			report.updateTestLog("Verify Update Opportunity", "Opportunity has been updated successfully", Status.PASS);
		} else {
			report.updateTestLog("Verify Update Opportunity", "Opportunity updation failed", Status.FAIL);
		}
	}

	/**
	 * Validating the Delete Opportunity
	 * 
	 * @author Vishnuvardhan
	 *
	 */

	public void bc_deleteOpportunity() {
		boolean status = sfOpportunitiesFunctions.deleteOpportunities();
		if(status==true) {
			report.updateTestLog("Verify Delete Opportunity", "Opportunity has been deleted successfully", Status.PASS);
		} else {
			report.updateTestLog("Verify Delete Opportunity", "Opportunity deletion failed", Status.FAIL);
		}
	}

	
	/**
	 * Validating the Create Lead functionality
	 * 
	 * @author Vishnuvardhan
	 *
	 */

	public void bc_createLead() {
		boolean status = sfLeadsFunctions.createLead();
		if(status==true) {
			report.updateTestLog("Verify Create Lead", "Lead has been deleted successfully", Status.PASS);
		} else {
			report.updateTestLog("Verify Create Lead", "Lead creation failed", Status.FAIL);
		}
	}
	/**
	 * Validating the Update Lead functionality
	 * 
	 * @author Vishnuvardhan
	 *
	 */

	public void bc_updateLead() {
		boolean status = sfLeadsFunctions.updateLead();
		if(status==true) {
			report.updateTestLog("Verify Update Lead", "Lead has been updated successfully", Status.PASS);
		} else {
			report.updateTestLog("Verify Update Lead", "Lead updation failed", Status.FAIL);
		}
	}
	/**
	 * Validating the Delete Lead
	 * 
	 * @author Vishnuvardhan
	 *
	 */

	public void bc_deleteLead() {
		boolean status = sfOpportunitiesFunctions.deleteOpportunities();
		if(status==true) {
			report.updateTestLog("Verify Delete Lead", "Lead has been deleted successfully", Status.PASS);
		} else {
			report.updateTestLog("Verify Delete Lead", "Lead deletion failed", Status.FAIL);
		}
	}

	
	/**
	 * Validating the Account Page Fields 
	 * 
	 * @author Vishnuvardhan
	 *
	 */

	public void bc_accountsPageFieldValidation() {
		sfAccountsFunctions.accountPageFieldsValidation();
	}

	/**
	 * Validating the Contacts Page Fields 
	 * 
	 * @author Vishnuvardhan
	 *
	 */	

	public void bc_contactsPageFieldValidation() {
		sfContactsFunctions.contactsPageFieldsValidation();
	}
	
	/**
	 * Validating the Lead Page Fields 
	 * 
	 * @author Vishnuvardhan
	 *
	 */	

	public void bc_leadPageFieldValidation() {
		sfLeadsFunctions.leadPageFieldsValidation();
	}

	/**
	 * Validating the Opportunities Page Fields 
	 * 
	 * @author Vishnuvardhan
	 *
	 */

	public void bc_opportunitiesPageFieldValidation() {
		sfOpportunitiesFunctions.opportunitiesPageFieldsValidation();
	}

	/**
	 * Validating the Search Lead Name functionality
	 * 
	 * @author Vishnuvardhan
	 *
	 */	

	public void bc_searchLeadName() {
		sfSearchText.searchLead();
	}
	
	/**
	 * Validating the Search Opportunity Name functionality
	 * 
	 * @author Vishnuvardhan
	 *
	 */	

	public void bc_searchLeadName(String query) {
		sfSearchText.searchOpportunity(query);
	}
	
	/**
	 * Function for fetching the record from SOQL by passing the table 
	 * 
	 * @author Vishnuvardhan
	 *
	 */	

	public void bc_fetchRecordID() {
		String accountID, contactID, leadID, opportunityID;
		if(dataTable.getData("General_Data", "Record").equals("Account")) {
			accountID = sfSearchText.fetchRecord("account", "Name");
			System.out.println("Account ID retrieved" + accountID);
		} else if(dataTable.getData("General_Data", "Record").equals("Contact")) {
			contactID = sfSearchText.fetchRecord("contact", "Name");
			System.out.println("Contact ID retrieved" + contactID);
		} else if(dataTable.getData("General_Data", "Record").equals("Leads")) {
			leadID = sfSearchText.fetchRecord("lead", "Name");
			System.out.println("Lead ID retrieved" + leadID);
		} else if(dataTable.getData("General_Data", "Record").equals("Opportunities")) {
			opportunityID = sfSearchText.fetchRecord("opportunity", "Name");
			System.out.println("Opportunity ID retrieved" + opportunityID);
		
		}
	} 
	/**
	 * Function for uploading an attachment
	 * 
	 * @author Vishnuvardhan
	 *
	 */	
	public void bc_uploadAttachment() {
		sfSearchText.uploadAttachment();
	}
	/**
	 * Function for uploading an attachment
	 * 
	 * @author Vishnuvardhan
	 *
	 */	
	public void bc_uploadFile() {
		sfSearchText.contentDocumentLink();
		//sfSearchText.uploadFile();		
	}
	
	public void bc_changePassword() {
		/*createUsers.setPassword(dataTable.getData("General_Data", "Password"));
		loginPage.changePassword();*/
		loginPage.changeExpiredPassword();
		//createUsers.setPassword("FTEPasswordRelease41");
	}
	
	
	public void bc_createActivity() {
		activityFunctions.createActivity();
	}
	/**
	 * Verifying whether the User ID's are working or not
	 * 
	 * @author Vishnuvardhan
	 *
	 */	
	public void bc_validatingUserIDs() {
		loginPage.verifyUserIDs();
	}
}