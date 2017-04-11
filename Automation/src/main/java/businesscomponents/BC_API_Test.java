package businesscomponents;

import com.cognizant.framework.Status;

import pagesAPI.accountsFunctions;
import pagesAPI.contactsFunctions;
import pagesAPI.opportunitiesFunctions;
import supportlibraries.*;

/**
 * Class for storing login and home page links validation business components
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
	
	accountsFunctions sfAccountsFunctions = new accountsFunctions(scriptHelper);
	contactsFunctions sfContactsFunctions = new contactsFunctions(scriptHelper);
	opportunitiesFunctions sfOpportunitiesFunctions = new opportunitiesFunctions(scriptHelper);
	
	public void bc_valdiateLogin() {
		boolean status = sfAccountsFunctions.retrieveUserConfiguration();
		if(status==true) {
			report.updateTestLog("Verify Login", "Login to the application is successful", Status.PASS);
		} else {
			report.updateTestLog("Verify Login", "Login to the application is failed", Status.FAIL);
		}
	}	
	
	public void bc_createAccount() {
		boolean status = sfAccountsFunctions.createAccount();
		if(status==true) {
			report.updateTestLog("Verify Create Account", "Accont has been created successfully", Status.PASS);
		} else {
			report.updateTestLog("Verify Create Account", "Accont creation failed", Status.FAIL);
		}
	}
	
	public void bc_updateAccounts() {
		boolean status = sfAccountsFunctions.updateAccounts();
		if(status==true) {
			report.updateTestLog("Verify Update Accounts", "Accont has been updated successfully", Status.PASS);
		} else {
			report.updateTestLog("Verify Update Accounts", "Accont updation failed", Status.FAIL);
		}
	}
	
	public void bc_deleteAccounts() {
		boolean status = sfAccountsFunctions.deleteAccounts();
		if(status==true) {
			report.updateTestLog("Verify Delete Account", "Accont has been deleted successfully", Status.PASS);
		} else {
			report.updateTestLog("Verify Delete Account", "Accont deletion failed", Status.FAIL);
		}
	}
	
	public void bc_createContact() {
		boolean status = sfContactsFunctions.createContacts();
		if(status==true) {
			report.updateTestLog("Verify Create Contact", "Contact has been created successfully", Status.PASS);
		} else {
			report.updateTestLog("Verify Create Contact", "Contact creation failed", Status.FAIL);
		}
	}
	
	public void bc_updateContacts() {
		boolean status = sfContactsFunctions.updateContacts();
		if(status==true) {
			report.updateTestLog("Verify Update Contact", "Contact has been created successfully", Status.PASS);
		} else {
			report.updateTestLog("Verify Update Contact", "Contact creation failed", Status.FAIL);
		}
	}
	
	public void bc_deleteContacts() {
		boolean status = sfContactsFunctions.deleteContacts();
		if(status==true) {
			report.updateTestLog("Verify Delete Contact", "Contact has been deleted successfully", Status.PASS);
		} else {
			report.updateTestLog("Verify Delete Contact", "Contact deletion failed", Status.FAIL);
		}
	}
	
	public void bc_searchPhoneNumber() {
		boolean status = sfAccountsFunctions.searchPhonenumber(dataTable.getData("General_Data", "SearchPhoneNumber"));
		if(status==true) {
			report.updateTestLog("Verify Search Phone Number", "Contact has been deleted successfully", Status.PASS);
		} else {
			report.updateTestLog("Verify Search Phone Number", "Contact deletion failed", Status.FAIL);
		}
	}
	
	public void bc_createOpportunity() {
		boolean status = sfOpportunitiesFunctions.createOpportunity();
		if(status==true) {
			report.updateTestLog("Verify Create Opportunity", "Opportunity has been deleted successfully", Status.PASS);
		} else {
			report.updateTestLog("Verify Create Opportunity", "Opportunity creation failed", Status.FAIL);
		}
	}
	
	public void bc_updateOpportunities() {
		boolean status = sfOpportunitiesFunctions.updateOpportunities();
		if(status==true) {
			report.updateTestLog("Verify Update Opportunity", "Opportunity has been updated successfully", Status.PASS);
		} else {
			report.updateTestLog("Verify Update Opportunity", "Opportunity updation failed", Status.FAIL);
		}
	}
	
	public void bc_deleteOpportunities() {
		boolean status = sfOpportunitiesFunctions.deleteOpportunities();
		if(status==true) {
			report.updateTestLog("Verify Delete Opportunity", "Opportunity has been deleted successfully", Status.PASS);
		} else {
			report.updateTestLog("Verify Delete Opportunity", "Opportunity deletion failed", Status.FAIL);
		}
	}
	
	public void bc_accountsPageFieldValidation() {
		sfAccountsFunctions.accountPageFieldsValidation();
	}
	
	public void bc_contactsPageFieldValidation() {
		sfContactsFunctions.contactsPageFieldsValidation();
	}
	
	public void bc_opportunitiesPageFieldValidation() {
		sfOpportunitiesFunctions.opportunitiesPageFieldsValidation();
	}
}