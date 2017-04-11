package businesscomponents;

import pages.propertiesPage;
import supportlibraries.*;

/**
 * Class for storing login and home page links validation business components
 * 
 * @author Vishnuvardhan
 *
 */

public class BC_Salesforce_PropertiesPage extends ReusableLibrary {
	/**
	 * Constructor to initialize the component library
	 * 
	 * @param scriptHelper
	 *            The {@link ScriptHelper} object passed from the
	 *            {@link DriverScript}
	 */
	public BC_Salesforce_PropertiesPage(ScriptHelper scriptHelper) {
		super(scriptHelper);
	}

	BC_Salesforce_Login sfBC_Login = new BC_Salesforce_Login(scriptHelper);
	propertiesPage sfPropertiesPage = new propertiesPage(scriptHelper);

	/**
	 * 
	 * Smoke Test business components related to Login
	 */

	public void bc_login() throws InterruptedException {
		sfBC_Login.bc_invokeApplication();
		sfBC_Login.bc_login();
		sfBC_Login.bc_verifyLoginSuccessful();
	}

	/**
	 * 
	 * Smoke Test business components related to Accounts Page
	 */
	
	public void bc_validateCustomerPropertyPage() {
		sfPropertiesPage.validateCustomPropertyPage();
	}

	
}