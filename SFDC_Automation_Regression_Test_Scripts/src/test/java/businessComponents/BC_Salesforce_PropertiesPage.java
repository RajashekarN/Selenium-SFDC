package businessComponents;

import com.cognizant.Craft.ReusableLibrary;
import com.cognizant.Craft.ScriptHelper;

import pageObjects.PropertiesPage;

/**
 * Business Components Class for validating functionalities related to Properties Page
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
	PropertiesPage sfPropertiesPage = new PropertiesPage(scriptHelper);

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
	 * Validating the Customer Property Page fields 
	 * 
	 * @author Vishnuvardhan
	 *
	 */	

	public void bc_validateCustomerPropertyPage() {
		sfPropertiesPage.validateCustomPropertyPage();
	}
	/**
	 * Validating the Creation of Activity for properties
	 * 
	 * @author Ramya
	 *
	 */	

	public void bc_verifyCreationOfActivity(){
		sfPropertiesPage.verifyCreationOfActivity();
	}
	
	/**
	 * Validating the Creation of New Activity Page Layout
	 * 
	 * @author Ramya
	 *
	 */	
	
	public void bc_verifyPropertiesNewActivityPageLayout(){
		sfPropertiesPage.verifyPropertiesNewActivityPageLayout();
	}


}