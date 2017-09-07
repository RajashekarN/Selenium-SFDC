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
	/**
	 * Validating the Creation of New Activity Page Layout
	 * 
	 * @author Ramya
	 *
	 */	

	public void bc_verifyNewActivityPropertiesPageSendNotificationEmail() throws InterruptedException {
		sfPropertiesPage.verifyNewActivityPropertiesPageSendNotificationEmail();
	}

	/**
	 * Validating the Campaigns tab present in the dropdown after loggin in
	 * 
	 * @author Vishnuvardhan
	 *
	 */	
	public void bc_campaignsTab() {
		sfPropertiesPage.validateCampaignsTab();
	}
	/**
	 * Validating the Campaigns tab present in the dropdown after loggin in
	 * 
	 * @author Ramya
	 *
	 */	
	public void bc_verifyNewPropertiesPage() {
		sfPropertiesPage.verifyNewPropertiesPage();
	}
	/**
	 * Validating the activity Lightning Time line fields 
	 * 
	 * @author Ramya
	 *
	 */	

	public void bc_propertiesActivityLightningTimeline() throws InterruptedException {
		sfPropertiesPage.propertiesActivityLightningTimeline();
	}
	/**
	 * Validating the properties Private tag functionality 
	 * 
	 * @author Ramya
	 *
	 */	

	public void bc_propertiesPrivateTagFunctionality() throws InterruptedException {
		sfPropertiesPage.propertiesPrivateTagFunctionality();
	}
	/**
	 *  Validating the Bulk Tagging
	 * 
	 * @author Ramya
	 *
	 */
	public void bc_verifyBulkTaggingFunctionality() throws InterruptedException {
		sfPropertiesPage.verifyBulkTaggingFunctionality();
	}
	/**
	 *  Validating the New properties page Property Type pick list field
	 * 
	 * @author Ramya
	 *
	 */
	public void bc_newPropertiesPropertyType() throws InterruptedException {
		sfPropertiesPage.newPropertiesPropertyType();
	}
	/**
	 *  Validating the New private Tags
	 * 
	 * @author Ramya
	 *
	 */
	public void bc_verifyPropertiesPrivateTags() throws InterruptedException {
		sfPropertiesPage.verifyPropertiesPrivateTags();
	}

	/**
	 * Validating the Property Type field value
	 * 	
	 * @author Ramya
	 *
	 */
	public void bc_verifyPropertyTypeFieldValue() throws InterruptedException {
		sfPropertiesPage.verifyPropertyTypeFieldValue();
	}
	/**
	 * Validating the Property Type field value
	 * 	
	 * @author Ramya
	 *
	 */
	public void bc_verifyPropertiesPreferencesPyeongValue() throws InterruptedException {
		sfPropertiesPage.verifyPropertiesPreferencesPyeongValue();
	}
	/**
	 * Validating the Project Enquiries For the Pyeong value
	 * 	
	 * @author Ramya
	 *
	 */
	public void bc_verifyProjectEnquiriesPyeongValue() throws InterruptedException {
		sfPropertiesPage.verifyProjectEnquiriesPyeongValue();
	}
	/**
	 * Validating the Properties For the Pyeong value
	 * 	
	 * @author Ramya
	 *
	 */
	public void bc_verifyPropertiesPyeongValue() throws InterruptedException {
		sfPropertiesPage.verifyPropertiesPyeongValue();
	}
	/**
	 * Validating the Properties For the Ping value
	 * 	
	 * @author Ramya
	 *
	 */
	public void bc_verifyPropertiesPingValue() throws InterruptedException {
		sfPropertiesPage.verifyPropertiesPingValue();
	}
	/**
	 * Validating the Properties For the Ping value
	 * 	
	 * @author Ramya
	 *
	 */
	public void bc_verifyPropertiesPreferencesPingValue() throws InterruptedException {
		sfPropertiesPage.verifyPropertiesPreferencesPingValue();
	}
	/**
	 * Validating the Project Enquiries For the Ping value
	 * 	
	 * @author Ramya
	 *
	 */
	public void bc_verifyProjectEnquiriesPingValue() throws InterruptedException {
		sfPropertiesPage.verifyProjectEnquiriesPingValue();
	}
	/**
	 * Validating the Preference Type field value
	 * 	
	 * @author Ramya
	 *
	 */
	public void bc_verifyPreferenceTypevalues() throws InterruptedException {
		sfPropertiesPage.verifyPreferenceTypevalues();
	}
	/**
	 * Validating the Offer Enquiry for the Autopopulated fields from the Project Enquiries
	 * 	
	 * @author Ramya
	 *
	 */
	public void bc_verifyOfferAutoPopulatedByProjectEnquiries() throws InterruptedException {
		sfPropertiesPage.verifyOfferAutoPopulatedByProjectEnquiries();
	}
	
}