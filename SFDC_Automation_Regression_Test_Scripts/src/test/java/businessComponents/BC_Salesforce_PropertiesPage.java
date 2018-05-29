package businessComponents;

import com.cognizant.Craft.ReusableLibrary;
import com.cognizant.Craft.ScriptHelper;

import pageObjects.PropertiesPage;
import pagesAPI.PropertiesFunctions;

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
	PropertiesFunctions propertiesFunctions = new PropertiesFunctions(scriptHelper);

/*	*//**
	 * Validating the Login functionality 
	 * 
	 * @author Vishnuvardhan
	 *
	 *//*	

	public void bc_login() throws InterruptedException {
		sfBC_Login.bc_invokeApplication();
		sfBC_Login.bc_login();
	}*/


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

	public void bc_bulkTagging(){
		sfPropertiesPage.bulkTaggingFunctionality();
		
	}
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
	 * Validating the New Properties page
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
	/**
	 * Validating the Properties Country field for the New Zealand Broker
	 * 	
	 * @author Ramya
	 *
	 */
	public void bc_verifyPropertiesCountryField() throws InterruptedException {
		sfPropertiesPage.verifyPropertiesCountryField();
	}
	/**
	 * Validating the Preferences Property type and region
	 * 	
	 * @author Ramya
	 *
	 */
	public void bc_verifyPreferencesPropertyType() throws InterruptedException {
		sfPropertiesPage.verifyPreferencesPropertyType();
	}
	/**
	 * Validating the Project Enquiries page fields
	 * 	
	 * @author Ramya
	 *
	 */
	public void bc_verifyProjectEnquiriesPageFields() throws InterruptedException {
		sfPropertiesPage.verifyProjectEnquiriesPageFields();
	}
	/**
	 * Validating the Properties edit page
	 * 
	 * @author Ramya
	 *
	 */
	public void bc_verifyPropertiesEditPage() throws InterruptedException {
		sfPropertiesPage.verifyPropertiesEditPage();
	}
	/**
	 * Validating the creation of properties preferences
	 * 
	 * @author Ramya
	 *
	 */
	public void bc_verifyPreferencesPropertiesCreation() throws InterruptedException {
		sfPropertiesPage.verifyPreferencesPropertiesCreation();
	}
	
	

	/**
	 * Validating the Property Preference validation
	 * 
	 * @author Vishnu
	 *
	 */
	public void bc_validatingPropertyPreference() throws InterruptedException {
		propertiesFunctions.propertyPreferenceValidation();
	}
	
	/**
	 * Validating the Property tagging
	 * 
	 * @author Cognizant
	 *
	 */
	public void bc_propertyTagging() throws InterruptedException {
		sfPropertiesPage.propertyTagging();
	}
	
	/**
	 * Validating the market creation
	 * 
	 * @author Cognizant
	 *
	 */
	public void bc_marketCreation() throws InterruptedException {
		sfPropertiesPage.marketCreation();
	}
	/**
	 * Validating the subscription creation
	 * 
	 * @author Cognizant
	 *
	 */
	public void bc_subscriptionCreation() throws InterruptedException {
		sfPropertiesPage.subscriptionCreation();
	}
	
	/**
	 * Validating the property preference update and clone
	 * 
	 * @author Cognizant
	 *
	 */
	public void bc_propertyPreferenceUpdateClone() throws InterruptedException {
		sfPropertiesPage.propertyPreferenceUpdateClone();
	}
	
	/**
	 * Validating the add property Functionality
	 * 
	 * @author Cognizant
	 *
	 */
	public void bc_addProperty() throws InterruptedException {
		sfPropertiesPage.addProperty();
	}
	
	/**
	 * Validating the add Task Functionality
	 * 
	 * @author Cognizant
	 *
	 */
	public void bc_addTask() throws InterruptedException {
		sfPropertiesPage.addTask();
	}
	
	/**
	 * Validating the add Campaigns Functionality
	 * 
	 * @author Cognizant
	 *
	 */
	public void bc_addCampaign() throws InterruptedException {
		sfPropertiesPage.addCampaign();
	}
	
	/**
	 * Validating the add Comps Functionality
	 * 
	 * @author Cognizant
	 *
	 */
	public void bc_addComp() throws InterruptedException {
		sfPropertiesPage.addComp();
	}
	
	/**
	 * Validating the Activity Timeline Task Functionality
	 * 
	 * @author Cognizant
	 *
	 */
	public void bc_activityTask() throws InterruptedException {
		sfPropertiesPage.activityTask();
	}
	
	/**
	 * Validating the Activity Timeline Event Functionality
	 * 
	 * @author Cognizant
	 *
	 */
	public void bc_activityEvent() throws InterruptedException {
		sfPropertiesPage.activityEvent();
	}
	
	/**
	 * Validating the add Event Functionality
	 * 
	 * @author Cognizant
	 *
	 */
	public void bc_addEvent() throws InterruptedException {
		sfPropertiesPage.	addEvent();
	}

	/**
	 * Validating the edit task Functionality
	 * 
	 * @author Cognizant
	 *
	 */
	public void bc_editTask() throws InterruptedException {
		sfPropertiesPage.editTask();
	}

	/**
	 * Validating the attachment Functionality
	 * 
	 * @author Cognizant
	 *
	 */
	public void bc_addAttachment() throws InterruptedException {
		sfPropertiesPage.addAttachment();
	}
	
	/**
	 * Validating the delete task Functionality
	 * 
	 * @author Cognizant
	 *
	 */
	public void bc_deleteTask() throws InterruptedException {
		sfPropertiesPage.deleteTask();
	}
	
	/**
	 * Validating the edit close task Functionality
	 * 
	 * @author Cognizant
	 *
	 */
	public void bc_editCloseTask() throws InterruptedException {
		sfPropertiesPage.editStatusTask();
	}
	
	/**
	 * Validating the edit Event Functionality
	 * 
	 * @author Cognizant
	 *
	 */
	public void bc_editEvent() throws InterruptedException {
		sfPropertiesPage.editEvent();
	}
	
	/**
	 * Task Validating Functionality
	 * 
	 * @author Cognizant
	 *
	 */
	public void bc_validationTask() throws InterruptedException {
		sfPropertiesPage.validationTask();
	}
	
	/**
	 * Event Validating Functionality
	 * 
	 * @author Cognizant
	 *
	 */
	public void bc_validationEvent() throws InterruptedException {
		sfPropertiesPage.validationEvent();
	}
	
	/**
	 * Create space Validating Functionality
	 * 
	 * @author Cognizant
	 *
	 */
	public void bc_createSpace() throws InterruptedException {
		sfPropertiesPage.createSpace();
	}
	
}