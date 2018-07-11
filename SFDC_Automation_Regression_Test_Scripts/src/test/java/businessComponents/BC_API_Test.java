package businessComponents;

import java.util.Map;

import com.cognizant.Craft.ReusableLibrary;
import com.cognizant.Craft.ScriptHelper;
import com.cognizant.framework.Status;

import pagesAPI.AccountsFunctions;
import pagesAPI.AttachmentsFunctions;
import pagesAPI.BudgetsTargetsFunctions;
import pagesAPI.CampaignsFunctions;
import pagesAPI.ContactsFunctions;
import pagesAPI.LeadsFunctions;
import pagesAPI.OpportunitiesFunctions;
import pagesAPI.PropertiesFunctions;
import pagesAPI.SubscriptionsFunctions;
import pagesAPI.TaggingFunctions;
import pagesAPI.TaskEventsFunctions;
import pagesAPI.UnitOfMeasurementFunctions;

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
	
	AccountsFunctions accountsFunctions = new AccountsFunctions(scriptHelper);
	ContactsFunctions contactsFunctions = new ContactsFunctions(scriptHelper);
	OpportunitiesFunctions opportunitiesFunctions = new OpportunitiesFunctions(scriptHelper);
	LeadsFunctions leadsFunctions = new LeadsFunctions(scriptHelper);
	TaggingFunctions taggingFunctions = new TaggingFunctions(scriptHelper);
	PropertiesFunctions propertiesFunctions = new PropertiesFunctions(scriptHelper);
	TaskEventsFunctions taskEventsFunctions = new TaskEventsFunctions(scriptHelper);
	AttachmentsFunctions attachmentsFunctions = new AttachmentsFunctions(scriptHelper);
	BudgetsTargetsFunctions budgetsTargetsFunctions = new BudgetsTargetsFunctions(scriptHelper);
	CampaignsFunctions campaignsFunctions = new CampaignsFunctions(scriptHelper);
	SubscriptionsFunctions subscriptionsFunctions = new SubscriptionsFunctions(scriptHelper);
	UnitOfMeasurementFunctions unitOfMeasurementFunctions = new UnitOfMeasurementFunctions(scriptHelper);
	
	/**
	 * Account Creation and Validation of fields
	 * 
	 * @author Vishnuvardhan
	 *
	 */
	public void bc_accountCreationValidationFields() throws InterruptedException {
		accountsFunctions.createAccountSpecificUser();
		accountsFunctions.accountPageFieldsValidation();
	}
	
	/**
	 * Accounts Page fields validation
	 * 
	 * @author Vishnuvardhan
	 *
	 */
	public void bc_accountValidationFields() throws InterruptedException {
		accountsFunctions.accountPageFieldsValidation();
	}
	
	/**
	 * Account Tagging with Private Tag
	 * 
	 * @author Vishnuvardhan
	 *
	 */
	public void bc_privateTagging() throws InterruptedException {
		taggingFunctions.CustomPrivateTag();
	}
	
	/**
	 * Lead Creation and Validation of fields
	 * 
	 * @author Vishnuvardhan
	 *
	 */
	public void bc_leadCreationValidationFields() throws InterruptedException {
		leadsFunctions.createLeadSpecificUser();
		leadsFunctions.leadPageFieldsValidation();
	}
	
	/**
	 * Validating the Property Creation
	 * 
	 * @author Vishnuvardhan
	 *
	 */
	public void bc_validatePropertyCreation() throws InterruptedException {
		propertiesFunctions.createPropertySpecificUser();
	}
	
	/**
	 * Validating the Property Edit
	 * 
	 * @author Vishnuvardhan
	 *
	 */
	public void bc_validatePropertyEdit() throws InterruptedException {
		propertiesFunctions.updatePropertySpecificUser();
	}
	
	/**
	 * Validating the Opportunities creation
	 * 
	 * @author Vishnuvardhan
	 *
	 */
	public void bc_validateOpportunity() {
		opportunitiesFunctions.createOpportunity(null);
	}
	
	/**
	 *Creating task on Account/ Contact/ Lead and Opportunity
	 * 
	 * @author Vishnuvardhan
	 *
	 */	
	public void bc_createTask() {
		taskEventsFunctions.createTask();
	}
		
	/**
	 *Creating Event on Account/ Contact/ Lead and Opportunity
	 * 
	 * @author Vishnuvardhan
	 *
	 */	
	public void bc_createEvent() {
		taskEventsFunctions.createEvent();
	}
	
	/**
	 *Creating Attachment on Task for Account/ Contact/ Lead and Opportunity
	 * 
	 * @author Vishnuvardhan
	 *
	 */	
	public void bc_createAttachmentTask() {
		attachmentsFunctions.createAttachment();
	}
	
	/**
	 *closing the tasks for Account/ Contact/ Lead and Opportunity
	 * 
	 * @author Vishnuvardhan
	 *
	 */	
	public void bc_closeTask() {
		taskEventsFunctions.closeTask();
	}
	
	/**
	 * Budget Creation
	 * 
	 * @author Vishnuvardhan
	 *
	 */
	public void bc_createBudget() throws InterruptedException {
		budgetsTargetsFunctions.createBudget();
	}
	

	/**
	 * Budget Editing
	 * 
	 * @author Vishnuvardhan
	 *
	 */
	public void bc_budgetEdit() throws InterruptedException {
		budgetsTargetsFunctions.budgetEdit();
	}
	
	/**
	 * Lead Creation via API
	 * 
	 * @author Vishnuvardhan
	 *
	 */
	public void bc_createLeadAPI() throws InterruptedException {
		leadsFunctions.createNewLeadConversion();
	}
	
	/**
	 * Lead Conversion via API
	 * 
	 * @author Vishnuvardhan
	 *
	 */
	public void bc_leadConversionAPI() throws InterruptedException {
		leadsFunctions.leadConversion();
	}
	
	/**
	 * Account Tagging with Private Tag
	 * 
	 * @author Vishnuvardhan
	 *
	 */
	public void bc_bulkTaggingValidation() throws InterruptedException {
		taggingFunctions.bulkTaggingFieldsValidation();
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
	 * Validating the New Contact Page Layout fields
	 * 
	 * @author Vishnuvardhan
	 *
	 */	

	public void bc_newContactPageLayout() {	
		contactsFunctions.contactsPageFieldsValidation();
	}
	
	/**
	 * Validating the Opportunities page layout
	 * 
	 * @author Vishnuvardhan
	 *
	 */
	public void bc_opportunityPageLayout() {
		opportunitiesFunctions.OpportunitiesPageFieldsValidation();
	}	

	/**
	 * Validating the Opportunity Note Attachements
	 * 
	 * @author Vishnuvardhan
	 *
	 */
	
	public void bc_createOpportunityNoteAttachment(){
		String opportunityId = opportunitiesFunctions.createOpportunity(null);
		boolean oppStatus = opportunitiesFunctions.createNote(opportunityId);
		if(oppStatus) {
			report.updateTestLog("Verify opportunity Note","Note has been created", Status.PASS);
		} else {
			report.updateTestLog("Verify opportunity Note", "Note creation failed", Status.FAIL);
		}
		boolean attachmentStatus = attachmentsFunctions.createAttachmentInOpportunity(opportunityId);
		if(attachmentStatus){
			report.updateTestLog("Verify opportunity Attachment","Attachment has been created", Status.PASS);
		} else {
			report.updateTestLog("Verify opportunity Attachment", "Attachment creation failed", Status.FAIL);
		}
	}

	/**
	 * Validating the Create Activity functionality
	 * 
	 * @author Vishnuvardhan
	 *
	 */
	public void bc_createActivity() {
		taskEventsFunctions.createTask();
	}
	
	/**
	 * Validating the creation of Multiple tasks
	 * 
	 * @author Vishnuvardhan
	 *
	 */
	public void bc_createMultipleTasks(){
		Map<String,String> taskMap = taskEventsFunctions.createMultipleTasks();
		taskEventsFunctions.closeTaskonOpportunity(taskMap.get("Task"));
		taskEventsFunctions.createMultipleEvents(taskMap.get("Opportunity"));
	}
	
	/**
	 * Campaign Creation function
	 * 
	 * @author Vishnuvardhan
	 *
	 */
	public void bc_createCampaign() throws InterruptedException {
		campaignsFunctions.createCampaign();
	}
	
	
	/**
	 * Contact Addition to Campaign 
	 * 
	 * @author Vishnuvardhan
	 *
	 */
	public void bc_associateCampaign() throws InterruptedException {
		campaignsFunctions.associateCampagin();
	}
	
	/**
	 * Creating subscriptions
	 * 
	 * @author Vishnuvardhan
	 *
	 */
	public void bc_createSubscriptions() throws InterruptedException {
		subscriptionsFunctions.createSubscriptions();
	}
	
	/**
	 * Creating subscriptions
	 * 
	 * @author Vishnuvardhan
	 *
	 */
	public void bc_createMarketingLists() throws InterruptedException {
		subscriptionsFunctions.createMarketing();
	}
	

	/**
	 *Creating Attachment on Task for Account/ Contact/ Lead and Opportunity
	 * 
	 * @author Vishnuvardhan
	 *
	 */	
	public void bc_createAttachmentEvent() {
		attachmentsFunctions.createAttachment();
	}
	

	/**
	 * Validating the New Account populating the required fields
	 * 
	 * @author Ramya
	 *
	 */
	public void bc_verifyAccountsPopulatingRequiredFields() throws InterruptedException {
		accountsFunctions.createAccountRequiredFields();
	}

	/**
	 * Validating the New Accounts Page Layout
	 * 
	 * @author Ramya
	 *
	 */
	public void bc_verifyAccountsPageLayout() throws InterruptedException {
		accountsFunctions.accountPageFieldsValidation();
	}
	
	/**
	 * Validating the new Contact Page layout
	 * 
	 * @author Ramya
	 *
	 */	
	public void bc_contactsNewContactPageLayout()throws InterruptedException{
		contactsFunctions.contactsPageFieldsValidation();
	}
	
	/**
	 * Validating the Population of all the required Fields in the New Contact Quick create Page
	 * 
	 * @author Ramya
	 *
	 */	
	public void bc_contactsPopulatingTheRequiredFields()throws InterruptedException{
		contactsFunctions.createContactRequiredFields();
	}
	
	/**
	 * Validating the Population of all the Fields in the New Contact Quick create Page
	 * 
	 * @author Ramya
	 *
	 */	
	public void bc_contactsPopulatingAllFields()throws InterruptedException{
		contactsFunctions.createContactsPopulatingAllFields();
	}
	
	/**
	 * Validating whether the Opportunity Name is auto generated or not when
	 * creating the New Opportunity
	 * 
	 * @author Vishnuvardhan
	 *
	 */

	public void bc_notAutoGeneratedOpportunityName() {
		opportunitiesFunctions.manualOpportunityCreation();
	}
	
	/**
	 * Validating whether the Opportunity Name is auto generated or not when
	 * creating the New Opportunity
	 * 
	 * @author Vishnuvardhan
	 *
	 */

	public void bc_opportunityNameAutoGenerate_API() {
		opportunitiesFunctions.opportunityNameAutoGenerate_API();
	}
	
	/**
	 * Validating the Opportunity Account Name modification
	 * 
	 * @author Vishnuvardhan
	 *
	 */

	public void bc_modifyAutoGeneratedOpportunityName() {
		opportunitiesFunctions.modifyAutoGeneratedOpportunityName();
	}
	
	/**
	 * Verify the required fields based on Sales Stage selected between
	 * 03-RFP/Proposal to 07-Under Contract on Opportunity from a broker profile
	 * 
	 * @author Vishnuvardhan
	 *
	 */
	public void bc_salesStage03_RFPProposal_07UnderContract() {
		opportunitiesFunctions.salesStage03_RFPProposal_07UnderContract();
	}
	
	/**
	 * Validating the required fields based on Sales Stage selected between
	 * 03-RFP/Proposal to 15-Signed Lease on Opportunity from a broker profile
	 * 
	 * @author Vishnuvardhan
	 *
	 */

	public void bc_requiredFields03_15Stages() throws InterruptedException {
		opportunitiesFunctions.requiredFieldsbetweenw03_15Stages();
	}
	
	/**
	 * Validate that all the countries have the right Unit of Measure assigned to it
	 * Validate that the UOM gets updated for the user, when wither the Country's UOM is updated or the User's country is updated
	 * @author SChandran
	 */
	public void bc_validateUnitOfMeasurementForUserAndCountry() {
		unitOfMeasurementFunctions.validateUOMForUserAndCountry();
	}
	
}