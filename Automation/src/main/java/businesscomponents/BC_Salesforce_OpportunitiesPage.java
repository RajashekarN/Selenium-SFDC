package businesscomponents;

import pages.OpportunitiesPage;
import supportlibraries.*;

/**
 * Business Components Class for validating functionalities related to Opportunities Page
 * 
 * @author Vishnuvardhan
 *
 */

public class BC_Salesforce_OpportunitiesPage extends ReusableLibrary {
	/**
	 * Constructor to initialize the component library
	 * 
	 * @param scriptHelper
	 *            The {@link ScriptHelper} object passed from the
	 *            {@link DriverScript}
	 */
	public BC_Salesforce_OpportunitiesPage(ScriptHelper scriptHelper) {
		super(scriptHelper);
	}

	BC_Salesforce_Login sfBC_Login = new BC_Salesforce_Login(scriptHelper);
	OpportunitiesPage sfOpportunitiesPage = new OpportunitiesPage(scriptHelper);

	/**
	 * Validating the Login functionality 
	 * 
	 * @author Vishnuvardhan
	 *
	 */	

	public void bc_login() throws InterruptedException {
		sfBC_Login.bc_invokeApplication();
		sfBC_Login.bc_login();
		sfBC_Login.bc_verifyLoginSuccessful();
	}

	
	/**
	 * Validating the New Opportunity Page Layout fields
	 * 
	 * @author Vishnuvardhan
	 *
	 */	
	
	public void bc_newOpportunityPageLayout() throws InterruptedException {
		sfOpportunitiesPage.newOpportunityPageLayout();
	}
	
	/**
	 * Validating the required fields based on Sales Stage selected between 03-RFP/Proposal to 15-Signed Lease on Opportunity from a broker profile
	 * 
	 * @author Vishnuvardhan
	 *
	 */	
	
	public void bc_requiredFields03_05Stages() throws InterruptedException {
		sfOpportunitiesPage.requiredFieldsbetweenw03_05Stages();
	}       
	
	/**
	 * Validating the required fields based on Sales Stage selected between 16 - 19 on Opportunity from a broker profile
	 * 
	 * @author Vishnuvardhan
	 *
	 */	
	
	public void bc_requiredFields16_19Stages() throws InterruptedException {
		sfOpportunitiesPage.requiredFieldsbetweenw16_19Stages();
	} 
	             
	/**
	 * Validating the functionality for association of property to an Opportunity
	 * 
	 * @author Vishnuvardhan                                               
	 *
	 */	
	
	public void bc_associateProperty() throws InterruptedException {
		sfOpportunitiesPage.associateProperty();
	}
	
	/**
	 * Validating the add Opportunity sharing from the Broker profile 
	 * 
	 * @author Vishnuvardhan
	 *
	 */	
	
	public void bc_opportunitySharing() {
		sfOpportunitiesPage.opportunitySharing();
	}
	
/*	*//**
	 * Validating the required fields at SalesStage in Opportunities 
	 * 
	 * @author Vishnuvardhan
	 *
	 *//*	
	public void bc_opportunityBrokerProfile() throws InterruptedException {
		sfOpportunitiesPage.requiredFields_SalesStage_Opportunities();
	}*/

}