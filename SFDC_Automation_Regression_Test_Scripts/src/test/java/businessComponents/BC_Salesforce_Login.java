package businessComponents;

import com.cognizant.Craft.ReusableLibrary;
import com.cognizant.Craft.ScriptHelper;
import pageObjects.LoginPage;


/**
 * Business Components Class for validating functionalities related to Login Page
 * 
 * @author Vishnuvardhan
 *
 */

public class BC_Salesforce_Login extends ReusableLibrary {
	/**
	 * Constructor to initialize the component library
	 * 
	 * @param scriptHelper
	 *            The {@link ScriptHelper} object passed from the
	 *            {@link DriverScript}
	 */
	public BC_Salesforce_Login(ScriptHelper scriptHelper) {
		super(scriptHelper);
	}

	LoginPage sfLogin = new LoginPage(scriptHelper);
	
	/**
	 * Validating the launching the browser functionality 
	 * 
	 * @author Vishnuvardhan
	 *
	 */	
	
	public void bc_invokeApplication() throws InterruptedException {
		sfLogin.invokeApplication();
	}
	
	/**
	 * Validating the Login functionality 
	 * 
	 * @author Vishnuvardhan
	 *
	 */	

	public void bc_login() throws InterruptedException {
		sfLogin.login();
		sfLogin.verifyLoginSuccessful();
	}
	
	/**
	 * Validating the Login functionality 
	 * 
	 * @author Vishnuvardhan
	 *
	 */	

	public void bc_verifyLoginSuccessful() throws InterruptedException {
		sfLogin.verifyLoginSuccessful();
	}
	
	/**
	 * Validating the Logout functionality 
	 * 
	 * @author Vishnuvardhan
	 *
	 */	
	
	public void bc_logout() throws InterruptedException {
		sfLogin.logout();
	}
	
}