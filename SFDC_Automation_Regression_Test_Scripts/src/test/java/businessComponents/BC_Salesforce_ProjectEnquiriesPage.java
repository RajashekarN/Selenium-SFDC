package businessComponents;

import com.cognizant.Craft.ReusableLibrary;
import com.cognizant.Craft.ScriptHelper;
import pageObjects.ProjectEnquiriesPage;


public class BC_Salesforce_ProjectEnquiriesPage extends ReusableLibrary {
	/**
	 * Constructor to initialize the component library
	 * 
	 * @param scriptHelper
	 *            The {@link ScriptHelper} object passed from the
	 *            {@link DriverScript}
	 */
	public BC_Salesforce_ProjectEnquiriesPage(ScriptHelper scriptHelper) {
		super(scriptHelper);
	}

	BC_Salesforce_Login sfBC_Login = new BC_Salesforce_Login(scriptHelper);
	ProjectEnquiriesPage projectEnquiriesPage= new ProjectEnquiriesPage(scriptHelper);
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

	public void bc_verifyAccountOnContactRequired() {
		projectEnquiriesPage.verifyAccountOnContactRequired();
	}

}