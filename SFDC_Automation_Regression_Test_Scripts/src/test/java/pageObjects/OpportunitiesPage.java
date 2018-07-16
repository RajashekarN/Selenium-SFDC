package pageObjects;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Random;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.cognizant.Craft.ReusableLibrary;
import com.cognizant.Craft.ScriptHelper;
import com.cognizant.framework.Status;
import com.sforce.soap.partner.PartnerConnection;
import com.sforce.soap.partner.QueryResult;
import com.sforce.soap.partner.SaveResult;
import com.sforce.soap.partner.sobject.SObject;
import com.sforce.ws.ConnectionException;
import com.sforce.ws.ConnectorConfig;

import pagesAPI.CreateObjects;
import pagesAPI.EstablishConnection;
import pagesAPI.OpportunitiesFunctions;
import pagesAPI.SearchTextSOQL;
import supportLibraries.SF_UtilityFunctions;
import supportLibraries.Utility_Functions;

/**
 * Page Object Class for Opportunities Page
 * 
 * @author Vishnuvardhan
 *
 */

public class OpportunitiesPage extends ReusableLibrary {
	/*
	 * Constructor to initialize the business component library
	 * 
	 * @param scriptHelper The {@link ScriptHelper} object passed from the
	 * {@link DriverScript}
	 */

	public OpportunitiesPage(ScriptHelper scriptHelper) {
		super(scriptHelper);
		PageFactory.initElements(driver.getWebDriver(), this);
	}

	/**
	 * Function for replacing the Opportunity with new Opportunity Id
	 * 
	 * @author Vishnuvardhan
	 */
	@FindBy(xpath = "//h1[contains(@class,'slds-page-header__title')]/span")
	List<WebElement> accountNameSaved;

	/**
	 * Validating the Opportunity sharing functionality
	 * 
	 * @author Vishnuvardhan
	 */
	
	@FindBy(xpath = "//p[text()='Opportunity Sharing']")
	WebElement opportunitySharing;

	@FindBy(xpath = "//input[@name='new'][contains(@value,'Add')]")
	WebElement addButtonSharing;

	@FindBy(xpath = "//*[contains(@id,'sharing_search')]")
	WebElement searchUsers;

	@FindBy(xpath = "//*[contains(@id,'searchValue_sharing_search')]")
	WebElement searchUserName;

	@FindBy(xpath = "//*[contains(@title,'Find')]")
	WebElement findValue;

	@FindBy(xpath = "//label[text()='Available']/parent::div/parent::td/select[@id='duel_select_0']")
	WebElement selectUser;

	@FindBy(xpath = "//img[@class='rightArrowIcon']")
	WebElement rightArrow;

	@FindBy(xpath = "//*[@id='p2']")
	WebElement access;

	@FindBy(xpath = "//*[@id='bottomButtonRow']/input[@name='save']")
	WebElement saveButton;
	
	/**
	*Validating the functionality for association of property to an Opportunity
	*
	*@author Vishnuvardhan
	*/

	@FindBy(xpath = "//div[@class='slds-form-element']/label[text()='Opportunity']")
	WebElement opportunityLabel;

	@FindBy(xpath = "//div[@class='slds-form-element']/label[text()='Opportunity']/parent::div/parent::div/div[1]/div/span")
	WebElement opportunitySelected;

	@FindBy(xpath = "//*[text()='* Property']/parent::div/div/input")
	WebElement findPropertyInput;

	@FindBy(xpath = "//div[@class='slds-col slds-size--1-of-4']/button[text()='Search']")
	WebElement searchButtonProperty;

	@FindBy(xpath = "//label[text()='Final Property']/parent::div/div/input")
	WebElement finalPropertyCheckbox;

	@FindBy(xpath = "//div[@class='slds-text-heading--medium slds-m-bottom--x-large']/parent::div//button/span[text()='Save']")
	WebElement saveButtonProperty;

	@FindBy(xpath = "//span[text()='Property']/ancestor::article//div[text()='New']")
	WebElement associatePropertyCapitalMarkets;

	@FindBy(xpath = "//input[contains(@placeholder,'Search Properties')]")
	WebElement searchProperties;

	@FindBy(css = ".modal-footer [title='Save']")
	WebElement save;

	@FindBy(xpath = "//span[contains(@class,'toastMessage') and contains(@class,'slds-text-heading--small')]")
	WebElement opportunityPropertyCreated;

	/**
	*Validating the manage Opportunity split functionality
	*
	*@author Vishnuvardhan
	*/

	@FindBy(xpath = "//span[text()='Estimated Gross Fee/Commission']/parent::span//input")
	WebElement estimatedGrossFeeField;
	
	@FindBy(xpath = "//div[contains(@class,'slds-page-header')]//input[@value='Save']")
	WebElement saveOpportunity;	

	@FindBy(xpath = "//button[text()='Add']")
	WebElement addButtonshareOpportunity;

	@FindBy(xpath = "//tr[contains(@class,'parent')][1]//input[contains(@id,'acctSearchBox')]")
	WebElement user1;

	@FindBy(xpath = "//select[@class='slds-select']/option[@value='Team Member']")
	WebElement selectTeamRole;

	@FindBy(xpath = "//select[@class='slds-select']/option[@value='Originating Broker']")
	WebElement selectSecondaryMemberRole;

	@FindBy(xpath = "//select[@class='slds-select']/option[@value='Edit']")
	WebElement selectOpportunityAccess;

	@FindBy(xpath = "//tr[contains(@class,'parent')][2]//input[contains(@id,'acctSearchBox')]")
	WebElement user2;

	@FindBy(xpath = "//table[@class='slds-table slds-no-row-hover']//tr[2]/td[3]//option[@value='Revenue Partner']")
	WebElement selectTeamRole2;

	@FindBy(xpath = "//table[@class='slds-table slds-no-row-hover']//tr[2]/td[4]//option[@value='Receiving Broker']")
	WebElement selectSecondaryMemberRole2;

	@FindBy(xpath = "//input[@value= 'Save']")
	WebElement saveButtonSplit;

	@FindBy(xpath = "//div[contains(@class, 'slds-truncate') and text()='Manage Opportunity Splits']")
	WebElement manageOpportunitySplits;

	@FindBy(xpath = "//button[text()='Save']")
	WebElement saveOpportunitySplit;

	@FindBy(xpath = "//input[@value='Save']")
	WebElement saveOpportunitySplitUAT;
	
	@FindBy(xpath = "//td[contains(@data-label,'Split Percent')]//input")
	WebElement splitPercent;

	/**
	* Validate Opportunity Name is not auto generated when manually added by the user
	* 
	* @author Vishnuvardhan
	*/
	@FindBy(xpath = "//button[text()='Continue']")
	WebElement continueButton;

	@FindBy(xpath = "//*[@id='record-type-select']")
	WebElement opportunityRecordType;

	@FindBy(xpath = "//*[@id='record-type-select']/option[text()='Capital Markets – Debt & Structured Finance']")
	WebElement opportunityRecordTypeDebtStructuredFinance;

	@FindBy(xpath = "//*[@id='record-type-select']/option[text()='Capital Markets – Property Sales']")
	WebElement opportunityRecordTypeValuePropertySales;

	@FindBy(xpath = "//*[@id='record-type-select']/option[text()='APAC Landlord and Sale Pursuits']")
	WebElement opportunityRecordTypeValueAPACLandlord;

	@FindBy(xpath = "//a[@class='tabHeader']//span[text()='Related']")
	WebElement related;

	/**
	* Function for creating the Opportunity
	* 
	* @author Vishnuvardhan
	*/

    @FindBy(xpath = "//input[@id='acctSearchBox']")
	WebElement accountName;
    
    @FindBy(xpath = "//label[text()='Account Name']/following-sibling::div")
    WebElement accName;

	@FindBy(xpath = "//select[contains(@id,'assignmentType')]")
	WebElement assignmentTypeOpp;

	@FindBy(xpath = "//label[contains(text(),'Lead Source')]/parent::div//select")
	WebElement leadSource;

	@FindBy(xpath = "//input[contains(@id,'closeDate')]")
	WebElement closeDateOpp;

	@FindBy(xpath = "//span[text()='Total Size']/parent::div//input")
	WebElement totalSizeOpp;

	@FindBy(xpath = "//span[text()='Unit of Measure']/parent::div//select")
	WebElement unitofMeasure;

	@FindBy(xpath = "//span[contains(text(),'Commission')]/parent::span//input")
	WebElement estimatedGrossFee;

    @FindBy(xpath = "//span[contains(text(),'Preferred')][contains(text(),'Property')]/parent::div//select[@class='slds-select']")
	WebElement preferredPropertyTypeOpp;

	@FindBy(xpath = "//div[contains(@class,'slds-media__body')]//input[@value='Save']")
	WebElement saveNewOpportunity;

	/**
	* Validating the manage Opportunity verify Custom Event Page
	* 
	* @author Vishnuvardhan
	*/

	@FindBy(xpath = "//ul[@class='tabs__nav']//a[@title='New Event']")
	WebElement newEventOpp;

	@FindBy(xpath="//span[text()='Add']")
    WebElement newEventAddButton; 
	
	/**
	* Validating the Quick create Opportunity page from the Opportunity tab with existing Account
	* 
	* @author Vishnuvardhan
	*/

	@FindBy(xpath = "//*[@class='slds-form-element__label']")
	List<WebElement> labelListOpportunitiesPage;
	
	/**
	* Validating the Quick create Opportunity page from the Opportunity tab
	* with existing Account for Asset Services
	* 
	* @author Vishnuvardhan
	*/
	@FindBy(xpath = "//span[text()='Reason for Loss']/parent::span/following-sibling::div//a")
	WebElement reasonForLoss;

	@FindBy(xpath = "//div[@class='select-options']//a[@title='Client Action Postponed']/parent::li/parent::ul/li")
	List<WebElement> reasonForLossValuesPickList;

	/**
	*  Verify the required fields based on Sales Stage selected between 08-Closed - Paid * Partial to 09-Closed - Paid Full
	*  
	*  @author Vishnuvardhan
	**/

	@FindBy(xpath = "//div[contains(@class,'error strength') and contains(@class,'forceMessage')]//p[contains(text(),'Looks like')]")
	WebElement accessOpportunity;

	@FindBy(xpath = "//div[@class='slds-truncate'][@title='Edit']")
	WebElement opportunityEdit;

	@FindBy(xpath = "//label[contains(@class,'label inputLabel')]/parent::div//a[@class='select']")
	WebElement salesStageOppClosed;

	@FindBy(xpath = "//div[@class='select-options']//a[contains(@title,'08-Closed')]")
	WebElement salesStageOppClosedOption;

	@FindBy(xpath = "//a[@aria-label='Assignment Type']")
	WebElement assignmentTypeOpportunity;

	@FindBy(xpath = "//a[@role='menuitemradio'][text()='Sale']")
	WebElement assignmentTypeSaleOpportunity;

	@FindBy(xpath = "//div[contains(@class,'modal-footer')]//button[@title='Save']")
	WebElement saveStageOpp;

	@FindBy(xpath = "//span[contains(@class,'genericError')]")
	WebElement reviewErrors;

	@FindBy(xpath = "//span[text()='Estimated Transaction Value']/parent::label/parent::div/input")
	WebElement estimatedTransactionValue;

	@FindBy(xpath = "//span[text()='Estimated Gross Fee/Commission']/parent::label/parent::div/input")
	WebElement estimatedGrossFeeCommissionValue;

	@FindBy(xpath = "//span[text()='Final Transaction Value']/parent::label/parent::div/input")
	WebElement finalTransactionValue;

	@FindBy(xpath = "//span[text()='Actual CBRE Gross Fee']/parent::label/parent::div/input")
	WebElement ActualCBREGrossFeeValue;
	
	/**
	*Validating the Opportunities Quick create page mandatory fields 
	*
	* @author Vishnuvardhan
	*/
	
	@FindBy(xpath = "//button/span[text()='View All Fields']")
	WebElement viewAllFieldsButton;

	@FindBy(xpath = "//*[contains(@id,'oppForm:oppName')]")
	WebElement opportunityName;

	@FindBy(xpath = "//p/strong[contains(text(),'-963425397_Test Automation_0131')]")
	WebElement accountNameValueAdmin;

	@FindBy(xpath = "//select[contains(@id,'oppForm:assignmentType')]/option[@value='Consulting']")
	WebElement assignmentTypeValue;

	@FindBy(xpath = "//span[contains(text(),'Preferred Property Type')]/following-sibling::div/select")
	WebElement preferedPropertyTypeAdmin;

	@FindBy(xpath = "//span[contains(text(),'Preferred Property Type')]/following-sibling::div/select/option[@value='Hotel']")
	WebElement preferedPropertyTypeValueAdmin;

	@FindBy(xpath = "//select[contains(@id,'oppForm:salesStage')]")
	WebElement salesStageEMEANewOpportunity;

	@FindBy(xpath =   "//select[contains(@id,'oppForm:salesStage')]/option[@value='Target']")
	WebElement salesStageEMEANewOpportunityValue;

	@FindBy(xpath = "//div[@class='slds-form-element']//span[text()='Estimated Gross Fee/Commission']/parent::div/input")
	WebElement salesStageEMEAEstimatedGrossCommission;

	@FindBy(xpath = "//input[contains(@id,'oppForm:closeDate')]")
	WebElement closeDateNewOpportunity;

	@FindBy(xpath = "//span[contains(text(),'Engagement Commencement')]/following-sibling::div//input")
	WebElement engagementCommencement;

	/**
	* Validating the Opportunities Quick create page mandatory fields
	* 
	* @author Vishnuvardhan
	*/

	@FindBy(xpath = "//span[text()='Estimated Gross Fee/Commission']/following-sibling::div[@class='requiredInput']/input")
	WebElement estimatedGrossFeeNewOpportunity;

	/**
	* Validating the Opportunities Quick create page for the default
	* opportunity name
	* 
	* @author Vishnuvardhan
	*/

	@FindBy(xpath = "//span[text()='Opportunity Name']/parent::label/parent::div//input")
	WebElement opportunityName_AS;

	@FindBy(xpath = "//input[contains(@id,'oppForm:oppName')][@value='TBD']")
	WebElement OppName;

	@FindBy(xpath = "//a[@class='tabHeader']//span[text()='Details']")
	WebElement details;

	/**
	* Validating the Opportunities Installment status functionality
	* 
	* @author Vishnuvardhan
	*/

	@FindBy(xpath = "//h2[@id='header']/a/span[text()='Opportunity Installments']")
	WebElement opportunityInstallments;

	@FindBy(xpath = "//button[@title='Edit Installment Status']")
	WebElement editInstallmentStatus;

	@FindBy(xpath = "//span[text()='Date Paid']/parent::label/parent::div//input")
	WebElement datePaid;

	@FindBy(xpath = "//textarea[@role='textbox']")
	WebElement commentsField;

	@FindBy(xpath = "//section[@class='tabs__content active uiTab']//button/span[text()='Save']")
	WebElement saveEditOpportunity;
	
	/**
	* Validating the Opportunities Close Date field
	* 
	* @author 
	*/
	@FindBy(xpath = "//div[contains(@class,'active')]//a/div[@title='Edit']")
	WebElement editOpportunity;

	/**
	* Validating the Opportunities My Active Listings
	* 
	* @author Vishnuvardhan
	*/

	@FindBy(xpath = "//h1//span[text()='Recently Viewed']")
	WebElement recentlyViewed;

	@FindBy(xpath = "//span[contains(@class,'virtualAutocompleteOptionText')][text()='My Active Listings']")
	WebElement myActiveListings;

	/**
	* Validating the Opportunities My Active Listings filters
	* 
	* @author Vishnuvardhan
	*/

	@FindBy(xpath = "//button[@title='Display as Table']")
	WebElement squareTable;

	@FindBy(xpath = "//span[text()='Kanban']")
	WebElement kanban;

	/**
	* Validating the Opportunities My Active Listings filters
	* 
	* @author Vishnuvardhan
	*/

	@FindBy(xpath = "//button[@title='Show filters']")
	WebElement toggleFilters;

	@FindBy(xpath = "//span[@class='fieldLabel'][text()='Opportunity Record Type']")
	WebElement opportunityRecordTypeFilters;

	@FindBy(xpath = "//span[@class='fieldLabel'][text()='Phase']")
	WebElement phaseFilters;

	/**
	* Validating the Discretionary Fee check box in the New Opportunity creation page
	* 
	* @author Vishnuvardhan
	*/

	@FindBy(xpath = "//label[contains(text(),' Discretionary Fee')]/following-sibling::div/label/span[contains(@class,'checkbox')]")
	WebElement discretionaryFeeCheckBox;

	@FindBy(xpath = "//label[contains(text(),'Discretionary Amount')]/following-sibling::div/input")
	WebElement discretionaryAmount;
	
	
	/**
	* Validating the Opportunity Quick create page for the Total size to be mandatory for * the sales stage Prospecting
	* 
	* @author Vishnuvardhan
	*/
	@FindBy(xpath = "//div[@class='bBottom']//span[text()='Opportunities']")
	WebElement menu_Opportunities;

	@FindBy(xpath = "//div[@class='slds-truncate'][text()='New']")
	WebElement newOpportunity;

	@FindBy(xpath = "//select[contains(@id,'oppForm:salesStage')]/option[@value='Prospecting']")
	WebElement salesStageNewOppValue;

	@FindBy(xpath = "//select[contains(@id,'cbreMarketGroup')]")
	WebElement cbreMarketGroup;

	@FindBy(xpath = "//select[contains(@id,'cbreMarketGroup')]/option[@value='City']")
	WebElement cbreMarketGroupValue;

	@FindBy(xpath = "//span[contains(@id,'pgMsg')]//li[contains(text(),'Please fill out Total Size')]")
	WebElement errorMessage;

	@FindBy(xpath = "//label[contains(text(),' Total Size')]/following-sibling::input")
	WebElement totalSizeNewOpp;

	@FindBy(xpath = "//span[contains(text(),'Sales Stage')]/parent::label/following-sibling::div//a[contains(@class,'select')]")
	WebElement salesStageEditOpp;

	@FindBy(xpath = "//div[contains(@class,'select-options')]/ul/li[5]/a[contains(text(),'Executing')]")
	WebElement salesStageEditOppValue;

	@FindBy(xpath = "//div[contains(@class,'slds-modal__footer')]//button[@title='Save']")
	WebElement saveEditOpp;

	/**
	* Validating the Net Fee Field Mandatory in the New Opportunity creation page
	* 
	* @author Vishnuvardhan
	*/

	@FindBy(xpath = "//select[contains(@id,'assignmentType')]//option[@value='Consulting']")
	WebElement assignmentTypeValueNewOpp;

	@FindBy(xpath = "//select[contains(@id,'oppForm:salesStage')]/option[text()='02-Meeting']")
	WebElement salesStageNewOpportunityValue;
	
	@FindBy(xpath = "//a[contains(text(),'Closed')]")
	WebElement salesStageEditOpportunityValue;

	@FindBy(xpath = "//span[text()='Total Size']/following-sibling::div//input")
	WebElement totalSizeOpportunityQuickCreate;

	@FindBy(xpath = "//span[text()='Preferred Property Type']/following-sibling::div/div/select")
	WebElement preferedPropertyType;

	@FindBy(xpath = "//span[text()='Preferred Property Type']/following-sibling::div/div/select/option[@value='Hotel']")
	WebElement preferedPropertyTypeValue;

	@FindBy(xpath = "//label[contains(text(),'Lead Source')]/parent::div//select/option[@value='Business Relationship']")
	WebElement leadSourceValueNewOpportunity;

	@FindBy(xpath = "//span[contains(text(),'Lease From')]/parent::label/parent::div//input")
	WebElement leaseFromEditOpportunity;

	@FindBy(xpath = "//span[contains(text(),'LeaseTo')]/parent::label/parent::div//input")
	WebElement leaseToEditOpportunity;

	@FindBy(xpath = "//span[contains(text(),'Lease Term(Months)')]/parent::label/following-sibling::input")
	WebElement leaseTermEditOpportunity;

	@FindBy(xpath = "//span[contains(text(),'Lease Rate/Rent')]/parent::label/following-sibling::input")
	WebElement leaseRent;

	@FindBy(xpath = "//span[contains(text(),'Lease Rate/Rent Basis')]/parent::span/following-sibling::div//a[contains(@class,'select')]")
	WebElement leaseRentBasis;

	@FindBy(xpath = "//a[contains(@title,'Per Month')]")
	WebElement leaseRentBasisValue;

	@FindBy(xpath = "//span[contains(text(),'CBRE Role')]/parent::span/following-sibling::div//a[contains(@class,'select')]")
	WebElement cbreRole;

	@FindBy(xpath = "//a[contains(@title,'Buyer Rep')]")
	WebElement cbreRoleValue;

	@FindBy(xpath = "//span[contains(text(),'Lease Rate/Rent Type')]/parent::span/following-sibling::div//a[contains(@class,'select')]")
	WebElement leaseRentType;

	@FindBy(xpath = "//a[contains(@title,'Full Service Gross')]")
	WebElement leaseRentTypeValue;
	
	@FindBy(xpath = "//span[contains(text(),'Remarks')]/parent::label/following-sibling::textarea")
	WebElement remarks;

	@FindBy(xpath = "//span[contains(text(),'CBRE Market Group')]/parent::span/following-sibling::div//a[contains(@class,'select')]")
	WebElement cbreMarketGroupEMEA;

	@FindBy(xpath = "//a[contains(@title,'City')]")
	WebElement cbreMarketGroupEMEAValue;

	@FindBy(xpath = "//span[contains(text(),'Net Fee')]/parent::label/following-sibling::input")
	WebElement netFeeOpportunityEdit;

	@FindBy(xpath = "//span[contains(text(),'Address Line 1')]/parent::label/following-sibling::input")
	WebElement addressLine1;

	@FindBy(xpath = "//span[contains(text(),'Address Line 2')]/parent::label/following-sibling::input")
	WebElement addressLine2;

	@FindBy(xpath = "//span[contains(text(),'City')]/parent::label/following-sibling::input")
	WebElement city;

	@FindBy(xpath = "//span[contains(text(),'Postcode')]/parent::label/following-sibling::input")
	WebElement postCode;

	@FindBy(xpath = "//span[contains(text(),'Conversion Type')]/parent::span/following-sibling::div//a[contains(@class,'select')]")
	WebElement emeaConversionType;

	@FindBy(xpath = "//a[contains(@title,'Pitch')]")
	WebElement emeaConversionTypeValue;

	@FindBy(xpath = "//span[contains(text(),'Pitch Date')]/parent::label/parent::div//input")
	WebElement pitchDate;

	@FindBy(xpath = "//span[contains(text(),'Other Incentives')]/parent::label/following-sibling::textarea")
		WebElement otherIncentives;

	@FindBy(xpath = "//span[contains(text(),'Rent Per Annum')]/parent::label/following-sibling::input")
	WebElement rentPerAnnum;

	@FindBy(xpath = "//span[contains(text(),'Months Rent Free')]/parent::label/following-sibling::input")
	WebElement monthsRentFree;

	@FindBy(xpath = "//span[contains(text(),'Rent Review Date')]/parent::label/parent::div//input")
	WebElement rentReviewDate;

	@FindBy(xpath = "//span[contains(text(),'Break Date')]/parent::label/parent::div//input")
	WebElement breakDate;






	
	/**
	* Validating the Opportunities create new installment
	* 
	* @author Vishnuvardhan
	*/

	@FindBy(xpath = "//li[contains(@class,'oneActionsDropDown')]//a")
	WebElement showMoreActions;

	@FindBy(xpath = "//a[contains(@title,'New Installment')]")
	WebElement newInstallment;

	@FindBy(xpath = "//div[@class='slds-form-element__control']//span[text()='Installment Number']/parent::label/parent::div/input")
	WebElement installmentNumber;

	@FindBy(xpath = "//span[contains(text(),'Installment Amount')]/parent::label/parent::div//input")
	WebElement installmentAmountNewOpportunityInstallment;

	@FindBy(xpath = "//div[@class='slds-form-element__control']//span[text()='Installment Date']/parent::label/parent::div/div/input")
	WebElement installmentDate;

	@FindBy(xpath = "//div[contains(@class,'slds-modal__footer')]/button/span[text()='Save']")
	WebElement newInstallmentSave;
	
	@FindBy(xpath = "//span[text()='Close Date']/parent::label/parent::div//input")
	WebElement closeDate_AS;

	@FindBy(xpath = "//span[contains(text(),'Lead Source')]/parent::span/following-sibling::div//a")
	WebElement leadSourceNewOpp;

	@FindBy(xpath = "//a[contains(@title,'Business Relationship')]")
	WebElement leadSourceNewOppValue;

	@FindBy(xpath = "//button[contains(@class,'forceActionButton')]/span[text()='Save']")
	WebElement saveNewOpp;

	@FindBy(xpath = "//span[contains(@class,'title')][contains(text(),'Activity')]")
	WebElement activity;

	@FindBy(xpath = "//span[text()='Installment Date']/parent::div/following-sibling::div")
	WebElement installmentDateEditOpp;
	
	@FindBy(xpath = "//div[@class='bBottom']//span[text()='Home']")
	WebElement menu_home;
	
	@FindBy(xpath = "//a[contains(@title,'Chatter')]//span[contains(text(),'Chatter')]")
	WebElement chatter;


	/**
	* Validating the Clone and Edit buttons in Opportunity VF Page
	* 
	* @author Vishnuvardhan
	*/
	
	
	@FindBy(xpath = "//a[@class='forceActionLink']/div[@class='slds-truncate'][text()='Edit']")
	WebElement edit;
	
	@FindBy(xpath = "//span[text()='Close Date']/parent::label/following-sibling::div//input")
	WebElement closeDate;
	
	@FindBy(xpath = "//div[@class='modal-container slds-modal__container']//span[text()='Total Size']/parent::div/following-sibling::div/span ")
	WebElement totalSize;
	
	@FindBy(xpath ="//span[text()='Preferred Property Type']/parent::span/following-sibling::div//a")
	WebElement preferredPropType;
	
	@FindBy(css = ".modal-footer [title='Save']")
	WebElement saveOpp;
	
	@FindBy(xpath = "//span[text()='Assignment Type']/parent::span/following-sibling::div//a")
	WebElement assignmentTypeOppValue;
	
	@FindBy(xpath = "//a[@class='forceActionLink']/div[@class='slds-truncate'][text()='Clone']")
	WebElement clone;
	
	@FindBy(xpath = "//*[@class='required ']/..//*[text()='Asset Type']//parent::span/following-sibling::div//a")
	WebElement assetTypeVASAPAC;
	
	@FindBy(xpath = "//span[text()='Area']/parent::label/parent::div//input")
	WebElement areaVASAPAC;

	@FindBy(xpath = "//span[text()='Unit of Measure']/parent::span/parent::div//a")
	WebElement unitOfMeasureVASAPAC;

	@FindBy(xpath = "//span[text()='Consultancy Fee']/parent::label/parent::div//input")
	WebElement consultancyFeeVASAPAC;

	@FindBy(xpath = "//span[contains(text(),'Project Value')]/parent::label/parent::div//input")
	WebElement projectValueVASAPAC;

	@FindBy(xpath = "//span[contains(text(),'Identification Date')]/parent::label/parent::div//input")
	WebElement identificationDateVASAPAC;

	@FindBy(xpath = "//span[contains(text(),'Submission Date')]/parent::label/parent::div//input")
	WebElement submissionDateVASAPAC;

	@FindBy(xpath = "//span[text()='Assignment Type']/parent::span/following-sibling::div//a")
	WebElement assignmentTypeVASAPAC;

	@FindBy(xpath = "//span[contains(text(),'Outcome Date')]/parent::label/parent::div//input")
	WebElement outcomeDateVASAPAC;

	@FindBy(xpath ="//span[text()='Construction Type']/parent::span/following-sibling::div//a")
	WebElement constructionTypeVASAPAC;

	@FindBy(xpath = "//span[contains(text(),'Site Area')]/parent::label/parent::div//input")
	WebElement siteAreaVASAPAC;

	@FindBy(xpath = "//span[text()='Area UOM']/parent::span/following-sibling::div//a")
	WebElement areaUOMVASAPAC;

	@FindBy(xpath = "//span[text()='Next']")
	WebElement offersNextButton;
	
	@FindBy(xpath = "//span[text()='Management Annual Revenue']/parent::label/parent::div//input")
	WebElement managementAnnualRevenue;
	
	/**
	* Validating the Phase and Probability field when Sales stage is selected
	* 
	* @author Vishnuvardhan
	*/
	
	@FindBy(xpath = "//*[@id='record-type-select']/option[text()='APAC Advisory/Consulting Services and GWS']")
	WebElement opportunityRecordTypeGlobalWorkplaceSolutions;
	
	@FindBy(xpath = "//input[@title='Search Accounts']")
	WebElement accountNameSearchBox;
	
	@FindBy(xpath = "//span[text()='Sales Stage']/parent::label/parent::div//a")
	WebElement salesStageGWS;
	
	@FindBy(xpath = "//span[text()='Reason for Loss']/parent::span/parent::div//a")
	WebElement reasonForLossOppGWS;
	
	@FindBy(xpath = "//span[text()='Reason Lost Comments']/parent::label/parent::div//textarea")
	WebElement reasonLostCommentsGWS;
	
	@FindBy(xpath = "//span[text()='Assignment Type']/parent::span/parent::div//a")
    WebElement assignmentTypeOppGWS;
    
    @FindBy(xpath = "//span[text()='Lead Source']/parent::span/parent::div//a")
    WebElement leadSourceGWS;

    @FindBy(xpath = "//span[text()='Close Date']/parent::label/parent::div//div/input")
    WebElement closeDateOppGWS;

    @FindBy(xpath = "//span[text()='Total Size']/parent::label/parent::div//input")
    WebElement totalSizeOppGWS;

    @FindBy(xpath = "//span[text()='Unit of Measure']/parent::span/parent::div//a")
    WebElement unitofMeasureGWS;

    @FindBy(xpath = "//span[text()='Estimated Gross Fee/Commission']/parent::label/parent::div//input")
    WebElement estimatedGrossFeeGWS;    

    @FindBy(xpath = "//ul[@class='scrollable']/li")
    List<WebElement> dropDownList;
    
    @FindBy(xpath = "//div[@class='modal-footer slds-modal__footer']//span[text()='Save']")
    WebElement saveOpportunityGWS;    
     
	/**
	* Validating the Project Enquiries Page Fiels List from the APAC Campaign Record
	* 
	* @author Vishnuvardhan
	*/
	
	@FindBy(xpath = "//span[contains(text(),'Project Enquiries')]/ancestor::article//div[text()='New']")
	WebElement projectEnquiries;
	
	/**
	* Validating the Offers Related List from the APAC Property Record
	* 
	* @author Vishnuvardhan
	*
	*/
	
	@FindBy(xpath = "//span[contains(@class,'slds-truncate')][text()='Properties']")
	WebElement menu_Properties;
	
	@FindBy(xpath = "//*[text()='More']")
	WebElement menu_More;
	
	@FindBy(xpath = "//a[@role='menuitem']/span[contains(@class,'slds-truncate')][text()='Properties']")
	WebElement propertiesRecord;
	
	@FindBy(xpath = "//div[@class='overflowList']//a[@title='Properties'][text()='Properties']")
	WebElement propertiesEnv;
	
	@FindBy(xpath = "//span[contains(@class,'virtualAutocompleteOptionText')][text()='All Active Campaigns']")
	WebElement allActiveCampaigns;
	
	/**
	* Validating Multi Business Line- Do not add Account Name to Opportunity Name when Opportunity is Marked as Confidential
	* 
	* @author Vishnuvardhan
	*/
	
	@FindBy(xpath = "//label[contains(text(),'Confidential Opportunity')]/parent::div//label[@class='slds-checkbox']/span[@class='slds-checkbox--faux']")
	WebElement confidentialCheckboxOpp;
	
	@FindBy(xpath = "//span[text()='Estimated Gross Fee/Commission']/parent::div/div[@class='requiredInput']/input")
	WebElement estimatedGrossFeeCommissionEMEA;

	@FindBy(xpath = "//span[contains(text(),'Sales')][contains(text(),'Stage')]/parent::div//select")
	WebElement salesStageEMEAOpp;

	@FindBy(xpath = "//h1[contains(@class,'slds-page-header__title') and contains(@class,'slds-truncate')]/span")
	WebElement opportunityConfidentialName;
	
	/**
	* Validating the Opportunity Calculated Annual Leasing Commission
	* 
	* 
	* @author Vishnuvardhan
	*/
	
	@FindBy(xpath = "//span[contains(text(),'Opportunity Name')]/parent::label/following-sibling::input")
	WebElement opportunityNameAS;
	
	@FindBy(xpath = "//label[contains(text(),'Lease Period (in months)')]")
	WebElement leasePeriodNewOpportunity;

	@FindBy(xpath = "//label[contains(text(),'Other Incentives')]")
	WebElement otherIncentivesNewOpportunity;

	@FindBy(xpath = "//label[contains(text(),'Landlord & Tenant Act 1954')]")
	WebElement landlordTenantAct;

    /* @FindBy(xpath="//input[@placeholder='Search Accounts']") 
    *WebElement searchAccountsNewOpportunity;
    */

	@FindBy(xpath = "//input[contains(@placeholder,'Search Accounts')]")
	WebElement searchAccountsNewOpportunity;

	@FindBy(xpath = "//span[text()='Total Size']/parent::label/following-sibling::input")
	WebElement totalSizeAS;

	@FindBy(xpath = "//div[contains(@class,'primaryLabel')][contains(@title,'Test Account APAC')]")
	WebElement accountValue;

	@FindBy(xpath = "//span[contains(text(),'Region')]/parent::span/following-sibling::div//a")
	WebElement regionAS;

	@FindBy(xpath = "//option[contains(@value,'Dallas/Ft. Worth')]")
	WebElement marketValue;

	@FindBy(xpath = "//a[contains(@title,'US National')]")
	WebElement regionValueAS;

	@FindBy(xpath = "//span[contains(text(),'Leasing')]/parent::span/following-sibling::div//a[@aria-label='Leasing']")
	WebElement leasingAS;

	@FindBy(xpath = "//span[contains(text(),'Consultancy')]/parent::span/following-sibling::div//a[@aria-label='Consultancy']")
	WebElement consultancyAS;

	@FindBy(xpath = "//a[@title='Yes']")
	WebElement valueAS;

	@FindBy(xpath = "//span[contains(text(),'City')]/parent::label/parent::div/input")
	WebElement opportunityCity;
	
	/**
	* Validating the Opportunities page for Recalculate and new installment button
	* 
	* @author Vishnuvardhan
	*/
	
	@FindBy(xpath = "//select[@id='record-type-select']")
	WebElement selectOpportunityRecordType;
	
	/**
	* Validating the Opportunities creation for the japan users
	* 
	* @author Vishnuvardhan
	*/
	
	@FindBy(xpath = "//div[contains(@class,'pbBottomButtons')]//input[contains(@id,'next')]")
	WebElement nextForJapan;
	
	@FindBy(xpath = "//span[contains(text(),'Account Name')]/parent::label/following-sibling::div//input[contains(@title,'Search Accounts')]")
	WebElement accountNameNewOpportunity;
	
	
     /**
	 * Validating the Opportunities APAC DSF for Financial Details for pacific users
	 * 
	 * @author Vishnuvardhan
	 */
	
	@FindBy(xpath = "//select[@id='record-type-select']/option[contains(text(),'APAC Debt & Structured Finance')]")
	WebElement opportunityDSFValue;
	
	@FindBy(xpath = "//span[text()='Opportunity Currency']")
	WebElement opportunityCurrency;


	/**
	* Validating the Opportunities creation for the project manager
	* 
	* @author Ramya
	*/

	@FindBy(xpath = "//div[contains(@class,'primaryLabel')][contains(@title,'Test Automation_0101')]")
	WebElement accountNameNewOpp;
	
	@FindBy(xpath = "//span[text()='Assignment Start Date']/parent::label/parent::div//input")
	WebElement assignmentStartDate;

	@FindBy(xpath = "//span[contains(text(),'CBRE Office')]/parent::span/following-sibling::div//a[contains(@aria-label,'CBRE Office')]")
	WebElement opportunityCBREOffice;

	@FindBy(xpath = "//a[contains(@title,'India – Ahmedabad')]")
	WebElement opportunityCBREOfficeValue;

	@FindBy(xpath = "//span[contains(text(),'Country')]/parent::span/following-sibling::div//a[contains(@aria-label,'Country')]")
	WebElement opportunityCountry;

	@FindBy(xpath = "//a[(@title='India')]")
	WebElement opportunityCountryValue;

    @FindBy(xpath = "//*[@class='required ']/..//*[text()='Asset Type']//parent::span/following-sibling::div//a")
	WebElement assetType;

	@FindBy(xpath = "//a[@title='Office']")
	WebElement assetTypeValue;

	@FindBy(xpath = "//a[contains(@aria-label,'Opportunity Currency')]")
	WebElement selectOpportunityCurrency;

	@FindBy(xpath = "//a[contains(@title,'Indian Rupee')]")
	WebElement opportunityCurrencyValue;

	@FindBy(xpath = "//span[contains(text(),'City Tier')]/parent::span/following-sibling::div//a[contains(@aria-label,'City Tier')]")
	WebElement cityTier;

	@FindBy(xpath = "//a[contains(@title,'Tier 1')]")
	WebElement cityTierValue;



	/**
	* Validating the Opportunities required fields at sales stage 03
	* 
	* @author Ramya
	*/

	@FindBy(xpath = "//span[contains(text(),'Opportunity Details')]/parent::label/parent::div//textarea")
	WebElement opportunityDetails;
	
	@FindBy(xpath = "//span[text()='Sales Stage']/parent::label/parent::div//a")
	WebElement salesStage_AS;

	@FindBy(xpath = "//a[contains(@title,'03-Proposal Submitted')][contains(text(),'03-Proposal Submitted')]")
	WebElement salesStageValue03;

	@FindBy(xpath = "//a[contains(@title,'04-Shortlisted')][contains(text(),'04-Shortlisted')]")
	WebElement salesStageValue04;

	@FindBy(xpath = "//a[contains(@title,'06-Contract Signed')][contains(text(),'06-Contract Signed')]")
	WebElement salesStageValue06;

	@FindBy(xpath = "//a[contains(@title,'07-Project Completed')][contains(text(),'07-Project Completed')]")
	WebElement salesStageValue07;

	@FindBy(xpath = "//span[contains(text(),'Identification Date')]/parent::label/parent::div//input")
	WebElement identificationDate;

	@FindBy(xpath = "//span[contains(text(),'Submission Date')]/parent::label/parent::div//input")
	WebElement submissionDate;

	@FindBy(xpath = "//span[contains(text(),'Completion Date')]/parent::label/parent::div//input")
	WebElement completionDate;

	@FindBy(xpath = "//span[contains(text(),'Outcome Date')]/parent::label/parent::div//input")
	WebElement outcomeDate;

	@FindBy(xpath = "//span[text()='Area']/parent::label/parent::div//input")
	WebElement totalSize_AS;

	@FindBy(xpath = "//a[@title='Construction Management']")
	WebElement assignmentTypeValueOpportunity;

	@FindBy(xpath = "//a[contains(@aria-label,'Assignment Sub-Type')]")
	WebElement assignmentSubType;

	@FindBy(xpath = "//a[contains(@title,'PJM')]")
	WebElement assignmentSubTypeValue;

	@FindBy(xpath = "//a[contains(@aria-label,'Construction Type')]")
	WebElement constructionType;

	@FindBy(xpath = "//a[@title='New Build']")
	WebElement constructionTypeValue;

	@FindBy(xpath = "//span[contains(text(),'Location')]/parent::label/parent::div//input")
	WebElement opportunityLocation;
		
	@FindBy(xpath = "//span[contains(text(),'Site Area')]/parent::label/parent::div//input")
	WebElement siteArea;

	@FindBy(xpath = "//span[contains(text(),'Project Value')]/parent::label/parent::div//input")
	WebElement projectValue;

	@FindBy(xpath = "//span[contains(text(),'Consultancy Fee')]/parent::label/parent::div//input")
	WebElement consultancyFee;


	/**
	* Validating the Creation of opportunities with the record type DSF
	* 
	* @author Ramya
	*/

	@FindBy(xpath = "//span[contains(@class,'virtualAutocompleteOptionText')][text()='All Active Opportunities']")
	WebElement allActiveOpportunities;
	
	@FindBy(xpath = "//a[@class='slds-truncate outputLookupLink slds-truncate forceOutputLookup']")
	WebElement OpportunityList;

	@FindBy(xpath = "//*[@id='tag_edit_link']")
	WebElement addTag;

	@FindBy(xpath = "//textarea[@id='ptag_edit_area']")
	WebElement privatetag;

	@FindBy(xpath = "//input[@id='tag_save_btn']")
	WebElement savePrivateTag;



	/**
	 * Validating the Opportunities pitch Advisor field
	 * 
	 * @author Vishnuvardhan
	 */
	
	@FindBy(xpath = "//select[@id='record-type-select']/option[@value='012i0000000tvTeAAI']")
	WebElement selectOpportunityRecordTypeValue;
	
	@FindBy(xpath = "//span[text()='Pitch Advisor']")
	WebElement pitchAdvisor;
	
	/**
	 * Validating the Opportunity Quick create page for the Total size to be mandatory for the sales stage Prospecting
	 * 
	 * @author Vishnuvardhan
	 */
	 
	@FindBy(xpath = "//span[contains(text(),'Total Size')]/parent::label/following-sibling::input")
	WebElement totalSizeEditOpp;
	
	/** 
	 * Validating the Opportunities page for Recalculate and new installment button
	 * 
	 * @author Vishnuvardhan
	 */
	@FindBy(xpath = "//a[contains(@title,'Recalculate')]")
	WebElement recalculate;
	
	/** 
	 * Validating the Opportunities required fields at sales stage 02
	 * 
	 * @author Vishnuvardhan
	 */
 
	@FindBy(xpath = "//a[contains(text(),'01-Intro Meeting / Relationship Building')]")
	WebElement salesStageDefaultValue;
	
	/**
	 * Validating the CBRE 360 Field on Opportunities page
	 * 
	 * @author Haritha
	 */

	@FindBy(xpath="//span[text()='Opportunity Name']/parent::label/parent::div//input")
	WebElement oppName_AS;

	@FindBy(xpath ="//span[contains(text(),'Account Name')]/parent::label/following-sibling::div//input[contains(@title,'Search Accounts')]")
	WebElement accountNameAssetOpp;
		
	@FindBy(xpath = "//span[text()='Total Size']/parent::label/parent::div//input")
	WebElement totalSizeAssetServices;

	@FindBy(xpath = "//span[text()='Unit of Measure']/parent::span/parent::div//a")
	WebElement unitOfMeasureAssetServices;

	@FindBy(xpath = "//span[contains(text(),'Region')]/parent::span/following-sibling::div//a")
	WebElement regionAssetServices;
	
	@FindBy(xpath = "//span[text()='Market']/parent::label/following-sibling::select")
	WebElement marketAssetServices;

	@FindBy(xpath="//span[text()='CBRE 360']/parent::span/following-sibling::div//a")
	WebElement cbre360;
	
	@FindBy(xpath="//span[text()='Close Date']/parent::label/parent::div//input")
	WebElement closeDateAssetServices;
	
	@FindBy(xpath="//span[text()='Sales Stage']/parent::label/parent::div//a")
	WebElement salesStageAssetServices;
	
	@FindBy(xpath="//button[contains(@class,'forceActionButton')]/span[text()='Save']")
	WebElement saveOppAssetServices;
	
	/**
	 * Function for validating the Picklist Field on Opportunity page layout
	 * 
	 * @author Haritha
	 */
	
	@FindBy(xpath="//select[@id='record-type-select']/option[contains(text(),'France Consulting & Service')]")
	WebElement franceConsultingAndService;
	
	@FindBy(xpath="//span[contains(text(),'Sales Stage')]/parent::label/following-sibling::div//a")
	WebElement salesStagePitch;
	
	@FindBy(xpath="//a[contains(@title,'Pitch Alert')]/parent::li/parent::ul")
	WebElement pitchAlert;
	
	@FindBy(xpath="//span[contains(text(),'Pitch Alert Date')]/parent::div/following-sibling::div//span")
	WebElement pitchAlertDate;
	
	@FindBy(xpath="//span[text()='Save'][contains(@class,' label bBody')]/parent::button[@class='slds-button slds-button--brand cuf-publisherShareButton undefined uiButton']")
	WebElement savePitchAlert;
	
	/**
	 * 
	 * 
	 */
	@FindBy(xpath="//input[@id='acctSearchBox']")
	WebElement accountNameEmea;
	
	@FindBy(xpath="//span[text()='Close Date']/parent::label/parent::div//input")
    WebElement closeDateEmea;
	
	@FindBy(xpath="//span[text()='Lead Source']/parent::span/parent::div/parent::div//a")
	WebElement leadSourceEmea;
	
	@FindBy(xpath = "//span[contains(text(),'Sales Stage')]/parent::label/following-sibling::div//a[contains(@class,'select')]")
	WebElement salesStageEmea;
			
	@FindBy(xpath = "(//lightning-icon/span[text()='Show More'])[1]")
	WebElement firstShowActions;
	
	@FindBy(xpath = "//a[@title='Delete']/parent::li")
	WebElement deleteAction;
	
	@FindBy(xpath = "//span[text()='Delete']/parent::button")
	WebElement deleteOpportunity;


	
	/*
	 * 
	 */
	
	SearchTextSOQL searchTextSOQL = new SearchTextSOQL(scriptHelper);
	Actions actions = new Actions(driver.getWebDriver());
	EventPage eventPage = new EventPage(scriptHelper);
	TasksPage tasksPage = new TasksPage(scriptHelper);
	SF_UtilityFunctions sf_UtilityFunctions = new SF_UtilityFunctions(scriptHelper);
	int offsetValue = new Random().nextInt(9);

	/**
	 * Function for establishing the connection in order to create the
	 * Opportunity
	 * 
	 * @author Vishnuvardhan
	 *
	 */

	public void establishConnection() {
		try {
			String environment = loginPage.initializeEnvironment();
			config = new ConnectorConfig();
			if ((environment.equals("UAT")) || (environment.equals("UAT2")) || (environment.equals("FTE"))
					|| (environment.equals("FTE2"))) {
				if ((dataTable.getData("General_Data", "TC_ID").contains("GWSAPAC"))
						&& (dataTable.getData("General_Data", "TC_ID").contains("Manager"))) {
					config.setUsername(properties.getProperty("GWSAPACManager") + "." + environment);
				} else if ((dataTable.getData("General_Data", "TC_ID").contains("GWSEMEA"))
						&& (dataTable.getData("General_Data", "TC_ID").contains("Broker"))) {
					config.setUsername(properties.getProperty("GWSEMEABroker") + "." + environment);
				} else if ((dataTable.getData("General_Data", "TC_ID").contains("VASAMER"))
						&& (dataTable.getData("General_Data", "TC_ID").contains("Manager"))) {
					config.setUsername(properties.getProperty("VASAMERManager") + "." + environment);
				} else if ((dataTable.getData("General_Data", "TC_ID").contains("VASEMEA"))
						&& (dataTable.getData("General_Data", "TC_ID").contains("Broker"))) {
					config.setUsername(properties.getProperty("VASEMEABroker") + "." + environment);
				} else if ((dataTable.getData("General_Data", "TC_ID").contains("ASAMER"))
						&& (dataTable.getData("General_Data", "TC_ID").contains("Manager"))) {
					config.setUsername(properties.getProperty("ASAMERManager") + "." + environment);
				} else if ((dataTable.getData("General_Data", "TC_ID").contains("ASAPAC"))
						&& (dataTable.getData("General_Data", "TC_ID").contains("Broker"))) {
					config.setUsername(properties.getProperty("ASAPACBroker") + "." + environment);
				} else if ((dataTable.getData("General_Data", "TC_ID").contains("ABAMER"))
						&& (dataTable.getData("General_Data", "TC_ID").contains("CSS"))) {
					config.setUsername(properties.getProperty("ABAMERCSS") + "." + environment);
				} else if ((dataTable.getData("General_Data", "TC_ID").contains("ABAPAC"))
						&& (dataTable.getData("General_Data", "TC_ID").contains("Manager"))) {
					config.setUsername(properties.getProperty("ABAPACManager") + "." + environment);
				} else if ((dataTable.getData("General_Data", "TC_ID").contains("OBAMER"))
						&& (dataTable.getData("General_Data", "TC_ID").contains("CSS"))) {
					config.setUsername(properties.getProperty("OBAMERCSS") + "." + environment);
				} else if ((dataTable.getData("General_Data", "TC_ID").contains("OBAMER"))
						&& (dataTable.getData("General_Data", "TC_ID").contains("Manager"))) {
					config.setUsername(properties.getProperty("OBAMERManager") + "." + environment);
				} else if ((dataTable.getData("General_Data", "TC_ID").contains("CMAMER"))
						&& (dataTable.getData("General_Data", "TC_ID").contains("Broker"))) {
					config.setUsername(properties.getProperty("CMAMERBroker") + "." + environment);
				} else if ((dataTable.getData("General_Data", "TC_ID").contains("CMAMER"))
						&& (dataTable.getData("General_Data", "TC_ID").contains("Manager"))) {
					config.setUsername(properties.getProperty("CMAMERManager") + "." + environment);
				} else if ((dataTable.getData("General_Data", "TC_ID").contains("CMAMER"))
						&& (dataTable.getData("General_Data", "TC_ID").contains("CSS"))) {
					config.setUsername(properties.getProperty("CMAMERCSS") + "." + environment);
				}
			}
			if (environment.equals("FTE")) {
				config.setPassword(properties.getProperty("FTEPassword"));
				config.setAuthEndpoint(properties.getProperty("FTEAuthEndpoint"));
			} else if (environment.equals("FTE2")) {
				config.setPassword(properties.getProperty("FTE2Password"));
				config.setAuthEndpoint(properties.getProperty("FTE2AuthEndpoint"));
			} else if (environment.equals("UAT2")) {
				config.setPassword(properties.getProperty("UAT2Password"));
				config.setAuthEndpoint(properties.getProperty("UAT2AuthEndpoint"));
			} else if (environment.equals("UAT")) {
				config.setPassword(properties.getProperty("UATPassword"));
				config.setAuthEndpoint(properties.getProperty("UATAuthEndpoint"));
			}
			connection = new PartnerConnection(config);
		} catch (ConnectionException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Verify for validating the Opportunity eligibility
	 * 
	 * @author Vishnuvardhan
	 *
	 */

	public void opportunityEligibility() {
		selectOpportunity();
	}

	/**
	 * Function for selecting the Opportunity from the list of Opportunities
	 * 
	 * @author Vishnuvardhan
	 *
	 */

	public void selectOpportunity() {
		Utility_Functions.timeWait(1);
		sf_UtilityFunctions.oneAppNavigationTab("Opportunities");
		report.updateTestLog("Verify Opportunity", "Opportunities are Displayed ", Status.PASS);
		sf_UtilityFunctions.selectExistingObjectRecord("Opportunity Name");
		Utility_Functions.timeWait(2);
		report.updateTestLog("Verify Opportunity",
				"Clicked on Opportunity and Opportunity page displayed successfully:::", Status.PASS);
	}

	/**
	 * Function for clicking on New creating a new Opport the Opportunity from
	 * the list of Opportunities
	 * 
	 * @author Vishnuvardhan
	 *
	 */

	public void selectNewOpportunity() {
		Utility_Functions.timeWait(1);
		sf_UtilityFunctions.oneAppNavigationTab("Opportunities");
		report.updateTestLog("Verify Opportunity", "Opportunities are Displayed ", Status.PASS);
		sf_UtilityFunctions.selectAction("New");
		report.updateTestLog("Verify Opportunity", "New Opportunity button clicked successfully:::", Status.PASS);
	}

	/**
	 * Function for replacing the Opportunity with new Opportunity Id
	 * 
	 * @author Vishnuvardhan
	 *
	 */

	public String selectOpportunityById(String OpportunityId) {
		selectOpportunity();
		report.updateTestLog("Verify Opportunity", "Clicked on Opportunity and Opportunity page displayed successfully",
				Status.PASS);
		replaceOpportunityId(OpportunityId);
		String accountName = Utility_Functions.xGetTextVisibleListElement(driver, accountNameSaved);
		System.out.println(accountName);
		return accountName;
		
	}

	/**
	 * Function that reads the Opportunity ID and replaces the Opportunity with
	 * new Opportunity Id
	 * 
	 * @author Vishnuvardhan
	 *
	 */

	public void replaceOpportunityId(String OpportunityId) {
/*		String url = driver.getCurrentUrl().split("#")[0];
		String newUrl = url + "#/sObject/" + OpportunityId;
		newUrl = newUrl + "/view";
		report.updateTestLog("Verify Opportunity", "Opportunity has been replaced with new Opportunity" + newUrl,
				Status.PASS);
		driver.get(newUrl);*/		
		String newUrl =null;
		if(OpportunityId.startsWith("001")) {
			String url = driver.getCurrentUrl().split("Account/")[0];
			newUrl = url + "Account/" +OpportunityId;
			newUrl = newUrl + "/view";
		} else {
			String url = driver.getCurrentUrl().split("Opportunity/")[0];
			newUrl = url + "Opportunity/" +OpportunityId;
			newUrl = newUrl + "/view";
		}	
		report.updateTestLog("Verify Opportunity", "Opportunity has been replaced with new Opportunity" + newUrl, Status.PASS);
		driver.get(newUrl);
		Utility_Functions.timeWait(2);
	}

	/**
	 * Validating the New Opportunities Page Layout fields
	 * 
	 * @author Vishnuvardhan
	 *
	 */

	public void newOpportunityPageLayout() {
		OpportunityPageLayout opportunityPageLaout = new OpportunityPageLayout(scriptHelper);
		opportunityPageLaout.validateNewOpportunityPage();
		report.updateTestLog("Verify the Oppoertunity page layout", "New Opportunity page layout fields are verified", Status.PASS);
	}

	/**
	 * Validating the required fields based on Sales Stage selected between 16-In Escrow to 19-Closed Lease on Opportunity from a broker profile
	 * 
	 * @author Vishnuvardhan
	 *
	 */

	public void requiredFieldsbetweenw16_19Stages() {
		String query = "SELECT Id, Name FROM Opportunity where StageName > '16-In Escrow' and StageName < '19-Closed' and Total_Size__c !=null limit 10";
		String OpportunityID = searchTextSOQL.searchOpportunity(query);
		System.out.println(OpportunityID);
		if (OpportunityID == null) {
			report.updateTestLog("Verify Opportunity", "There are no Opportunities that falls under this category:::",
					Status.PASS);
		} else {
			report.updateTestLog("Verify Opportunity Required Fields",
					"Opportunity retrived from database is:::" + OpportunityID, Status.PASS);
			replaceOpportunityId(OpportunityID);
			validateOpportunityFields(OpportunityID);
		}
		report.updateTestLog("Verify the Fields between Sales stage 16 and 19", "Verified the fields between the Sales stage 16 and 19 on Opportunity for broker profile", Status.PASS);
	}

	/**
	 * Function for validating the Opportunity fields
	 * 
	 * @author Vishnuvardhan
	 *
	 */
	public void validateOpportunityFields(String OpportunityId) {

		Utility_Functions.xScrollWindowOnce(driver);
		Utility_Functions.timeWait(1);
		Utility_Functions.xScrollWindowTop(driver);
		Utility_Functions.timeWait(1);
		String OpportunityID = OpportunityId;

		OpportunitiesFunctions update = new OpportunitiesFunctions(scriptHelper);
		String newopportunityID = "'" + OpportunityID + "' ";
		String totalSize, preferredPropertyType, leaseFrom, leaseTo, leaseTerm, leaseRate, leaseRateRentBasis;

		SearchTextSOQL searchTextSOQL = new SearchTextSOQL(scriptHelper);

		String query_TotalSize = "Select Total_Size__c from Opportunity where Id = " + "'" + OpportunityID + "'";
		totalSize = searchTextSOQL.fetchRecordFieldValue("Total_Size__c", query_TotalSize);

		String query_PreferredPropertyType = "Select CBRE_Preferred_Property_Type_c__c from Opportunity where Id = "
				+ "'" + OpportunityID + "'";
		preferredPropertyType = searchTextSOQL.fetchRecordFieldValue("CBRE_Preferred_Property_Type_c__c",
				query_PreferredPropertyType);

		String query_LeaseFrom = "Select Lease_From__c from Opportunity where Id = " + "'" + OpportunityID + "'";
		leaseFrom = searchTextSOQL.fetchRecordFieldValue("Lease_From__c", query_LeaseFrom);

		String query_LeaseTo = "Select Lease_To__c from Opportunity where Id = " + "'" + OpportunityID + "'";
		leaseTo = searchTextSOQL.fetchRecordFieldValue("Lease_To__c", query_LeaseTo);

		String query_LeaseTerm = "Select Lease_Term__c	from Opportunity where Id = " + "'" + OpportunityID + "'";
		leaseTerm = searchTextSOQL.fetchRecordFieldValue("Lease_Term__c", query_LeaseTerm);

		String query_LeaseRate = "Select Lease_Rate_Rent__c	 from Opportunity where Id = " + "'" + OpportunityID + "'";
		leaseRate = searchTextSOQL.fetchRecordFieldValue("Lease_Rate_Rent__c", query_LeaseRate);

		String query_LeaseRateRentBasis = "Select Lease_Rate_Rent_Basis__c from Opportunity where Id = " + "'"
				+ OpportunityID + "'";
		leaseRateRentBasis = searchTextSOQL.fetchRecordFieldValue("Lease_Rate_Rent_Basis__c", query_LeaseRateRentBasis);

		try {
			if (!totalSize.equals("")) {
				report.updateTestLog("Verify Opportunity Fields", "Total Size field is not blank:::" + totalSize,
						Status.PASS);
			} else {
				report.updateTestLog("Verify Opportunity Fields", "Total Size field is blank:::" + totalSize,
						Status.WARNING);
				update.updateOpportunityField("Total_Size__c", newopportunityID);

			}
			if (!preferredPropertyType.equals("")) {
				report.updateTestLog("Verify Opportunity Fields",
						"PreferredPropertyType field is not blank:::" + preferredPropertyType, Status.PASS);
			} else {
				report.updateTestLog("Verify Opportunity Fields",
						"PreferredPropertyType field is blank:::" + preferredPropertyType, Status.WARNING);
				update.updateOpportunityField("CBRE_Preferred_Property_Type_c__c", newopportunityID);
				update.updateOpportunityField("Preferred_Property_Sub_Type__c", newopportunityID);
			}
			if (!leaseFrom.equals("")) {
				report.updateTestLog("Verify Opportunity Fields", "LeaseFrom field is not blank:::" + leaseFrom,
						Status.PASS);
			} else {
				report.updateTestLog("Verify Opportunity Fields", "LeaseFrom field is blank:::" + leaseFrom,
						Status.WARNING);
				update.updateOpportunityField("Lease_From__c", newopportunityID);

			}
			if (!leaseTo.equals("")) {
				report.updateTestLog("Verify Opportunity Fields", "LeaseTo field is not blank:::" + leaseTo,
						Status.PASS);
			} else {
				report.updateTestLog("Verify Opportunity Fields", "LeaseTo field is blank:::" + leaseTo,
						Status.WARNING);
				update.updateOpportunityField("Lease_To__c", newopportunityID);
			}
			if (!leaseTerm.equals("")) {
				report.updateTestLog("Verify Opportunity Fields", "LeaseTerm field is not blank:::" + leaseTerm,
						Status.PASS);
			} else {
				report.updateTestLog("Verify Opportunity Fields", "LeaseTerm field is blank:::" + leaseTo,
						Status.WARNING);
				update.updateOpportunityField("Lease_Term__c", newopportunityID);
			}
			if (!leaseRate.equals("")) {
				report.updateTestLog("Verify Opportunity Fields", "LeaseRate field is not blank:::" + leaseRate,
						Status.PASS);
			} else {
				report.updateTestLog("Verify Opportunity Fields", "LeaseRate field is blank:::" + leaseRate,
						Status.WARNING);
				update.updateOpportunityField("Lease_Rate_Rent__c", newopportunityID);
			}
			if (!leaseRateRentBasis.equals("")) {
				report.updateTestLog("Verify Opportunity Fields",
						"LeaseRateRentBasis field is not blank:::" + leaseRateRentBasis, Status.PASS);
			} else {
				report.updateTestLog("Verify Opportunity Fields",
						"LeaseRateRentBasis field is blank:::" + leaseRateRentBasis, Status.WARNING);
				update.updateOpportunityField("Lease_Rate_Rent_Basis__c", newopportunityID);
			}

		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
		}

		driver.navigate().refresh();
		Utility_Functions.timeWait(4);
		try {
			int count = 0;
			if (!totalSize.equals("")) {
				report.updateTestLog("Verify Opportunity Fields",
						"Total Size field is not blank:::" + totalSize + " opportunity saved successfully",
						Status.PASS);
				count++;
			}
			if (!preferredPropertyType.equals("")) {
				report.updateTestLog("Verify Opportunity Fields", "PreferredPropertyType field is blank:::"
						+ preferredPropertyType + " opportunity saved successfully", Status.PASS);
				count++;
			}
			if (!leaseFrom.equals("")) {
				report.updateTestLog("Verify Opportunity Fields",
						"LeaseFrom field is blank:::" + leaseFrom + " opportunity saved successfully", Status.PASS);
				count++;
			}
			if (!leaseTo.equals("")) {
				report.updateTestLog("Verify Opportunity Fields",
						"LeaseTo field is blank:::" + leaseTo + " opportunity saved successfully", Status.PASS);
				count++;
			}
			if (!leaseTerm.equals("")) {
				report.updateTestLog("Verify Opportunity Fields",
						"LeaseTerm field is blank:::" + leaseTerm + " opportunity saved successfully", Status.PASS);
				count++;
			}
			if (!leaseRate.equals("")) {
				report.updateTestLog("Verify Opportunity Fields",
						"LeaseRate field is blank:::" + leaseRate + " opportunity saved successfully", Status.PASS);
				count++;
			}
			if (!leaseRateRentBasis.equals("")) {
				report.updateTestLog("Verify Opportunity Fields",
						"LeaseRateRentBasis field is blank:::" + leaseRateRentBasis + " opportunity saved successfully",
						Status.PASS);
				count++;
			}
			System.out.println(count);
			if (count == 7) {
				report.updateTestLog("Verify Opportunity Fields", "Opportunity saved successfully", Status.PASS);
			} else {
				report.updateTestLog("Verify Opportunity Fields", "There is an error in saving the opportunity fields",
						Status.FAIL);
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
		}

	}

	/**
	 * Validating the Opportunity sharing functionality
	 * 
	 * @author Vishnuvardhan
	 *
	 */

	public void opportunitySharing() {
		String queryOpp = "SELECT Id, Name FROM Opportunity where StageName > '16-In Escrow' and StageName < '19-Closed' and Total_Size__c !=null limit 10";
		String Opportunity = searchTextSOQL.searchOpportunity(queryOpp);
		if(Opportunity==null) {
			report.updateTestLog("Verify Opportunity", "There are no opportunities present for the above category", Status.PASS);
		} else {
			selectOpportunity();
			Utility_Functions.timeWait(1);
			replaceOpportunityId(Opportunity);
			driver.navigate().refresh();
			sf_UtilityFunctions.clickOnDetailAction("Sharing");
			Utility_Functions.timeWait(2);
			Utility_Functions.xSwitchtoFrame(driver, opportunitySharing);
			Utility_Functions.xWaitForElementPresent(driver, opportunitySharing, 4);
			Utility_Functions.timeWait(2);
			driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@title='Content']")));
			Utility_Functions.xWaitForElementPresent(driver, addButtonSharing, 5);
			Utility_Functions.xClick(driver, addButtonSharing, true);
			Utility_Functions.xWaitForElementPresent(driver, searchUsers, 3);
			Utility_Functions.xSelectDropdownByName(searchUsers, "Users");
			Utility_Functions.timeWait(1);
			Utility_Functions.xSendKeys(driver, searchUserName, "bommisetty");
			Utility_Functions.timeWait(1);
			Utility_Functions.xClick(driver, findValue, true);
			Utility_Functions.timeWait(1);
			String environment = loginPage.initializeEnvironment();
			if (environment.equals("UAT")) {
				Utility_Functions.xSelectDropdownByName(selectUser, "User: vishnuvardhan bommisetty");
			} else {
				Utility_Functions.xSelectDropdownByName(selectUser, "User: vishnuvardhan bommisetty");
			}
			Utility_Functions.timeWait(1);
			Utility_Functions.xClick(driver, rightArrow, true);
			Utility_Functions.timeWait(1);
			Utility_Functions.xSelectDropdownByName(access, "Read Only");
			Utility_Functions.xClick(driver, saveButton, true);
			Utility_Functions.timeWait(1);
			driver.switchTo().defaultContent();
			LoginPage login = new LoginPage(scriptHelper);
			login.logout();
			try {
				String newopportunityID = "'" + Opportunity + "' ";
				updateOpportunityStatus("StageName", newopportunityID);
				String updateQuery = "SELECT Id, Name, StageName FROM Opportunity where Id = " + newopportunityID;
				searchTextSOQL.searchOpportunity(updateQuery);
				String resultQuery = "SELECT Id, Name, StageName FROM Opportunity where Id = " + newopportunityID;
				String opportunityStage = searchTextSOQL.fetchRecordFieldValue("StageName", resultQuery);
				System.out.println(opportunityStage);
				if (opportunityStage.contains("Closed")) {
					report.updateTestLog("Verify Opportunity Update", "Opportunity has been updated successfully",
							Status.FAIL);
				} else {
					report.updateTestLog("Verify Opportunity Update",
							"Sales Stage updation has been failed which is working as expected", Status.PASS);
				}
			} catch (Exception e) {
				report.updateTestLog("Verify Opportunity Update",
						"You do not have the level of access necessary to perform the operation you requested. "
								+ "Please contact the owner of the record or your administrator if access is necessary.",
						Status.PASS);
			}
		}		
	}

	/**
	 * Validating the Opportunity Status field update
	 * 
	 * @author Vishnuvardhan
	 *
	 */
	static PartnerConnection connection = null;
	static ConnectorConfig config;

	LoginPage loginPage = new LoginPage(scriptHelper);

	public void updateOpportunityStatus(String FieldName, String OpportunityID) {
		try {
			String environment = loginPage.initializeEnvironment();
			if (environment.equals("UAT")) {
				String UAT_AuthEndpoint = properties.getProperty("UATAuthEndpoint");
				config = new ConnectorConfig();
				config.setUsername(properties.getProperty("SystemAdminUsername") + "." + environment);
				config.setPassword(properties.getProperty("UATAdminPassword"));
				config.setAuthEndpoint(UAT_AuthEndpoint);
			} else if (environment.equals("UAT2")) {
				String UAT2_AuthEndpoint = properties.getProperty("UAT2AuthEndpoint");
				config = new ConnectorConfig();
				config.setUsername(properties.getProperty("SystemAdminUsername") + "." + environment);
				config.setPassword(properties.getProperty("UAT2AdminPassword"));
				config.setAuthEndpoint(UAT2_AuthEndpoint);
			} else if (environment.equals("FTE")) {
				String FTE_AuthEndpoint = properties.getProperty("FTEAuthEndpoint");
				config = new ConnectorConfig();
				config.setUsername(properties.getProperty("SystemAdminUsername") + "." + environment);
				config.setPassword(properties.getProperty("FTEAdminPassword"));
				config.setAuthEndpoint(FTE_AuthEndpoint);
			} else if (environment.equals("FTE2")) {
				String FTE2_AuthEndpoint = properties.getProperty("FTE2AuthEndpoint");
				config = new ConnectorConfig();
				config.setUsername(properties.getProperty("SystemAdminUsername") + "." + environment);
				config.setPassword(properties.getProperty("FTE2AdminPassword"));
				config.setAuthEndpoint(FTE2_AuthEndpoint);
			}
			connection = new PartnerConnection(config);

			String fieldName = FieldName;
			String opportunityID = OpportunityID;
			SObject[] records = new SObject[1];
			QueryResult queryResults = connection.query("SELECT Id FROM Opportunity Where ID = " + opportunityID);
			System.out.println(queryResults);
			if (queryResults.getSize() > 0) {
				for (int i = 0; i < queryResults.getRecords().length; i++) {
					SObject so = (SObject) queryResults.getRecords()[i];
					SObject soUpdate = new SObject();
					soUpdate.setType("Opportunity");
					soUpdate.setId(so.getId());
					if (fieldName.equals("StageName")) {
						soUpdate.setField(fieldName, "17-Closed");
					}
					records[i] = soUpdate;
					System.out.println(records[i]);
				}
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
			System.out.println(e.getStackTrace());
		}
	}

	/**
	 * Validating the functionality for association of property to an
	 * Opportunity
	 * 
	 * @author Vishnuvardhan
	 *
	 */
	public void associateProperty() {
		selectOpportunity();
		sf_UtilityFunctions.selectTabUIHeaders("Related");
		/*Utility_Functions.timeWait(2);
		Utility_Functions.xScrollWindow(driver);
		Utility_Functions.timeWait(1);
		Utility_Functions.xScrollWindowTop(driver);
		Utility_Functions.timeWait(3);*/
		try {
			sf_UtilityFunctions.selectRelatedListsButton("Property", "Associate Property");
			Utility_Functions.xWaitForElementVisible(driver, opportunityLabel, 5);
			Utility_Functions.timeWait(1);
			if (!opportunitySelected.getText().equals(" ")) {
				report.updateTestLog("Verify Opportunity Field",
						"Opportunity field is prepopulated with the Opporturnity " + opportunitySelected.getText(),
						Status.PASS);
			} else {
				report.updateTestLog("Verify Opportunity Field",
						"Opportunity field not is prepopulated with the Opporturnity " + opportunitySelected.getText(),
						Status.FAIL);
			}
			Utility_Functions.xWaitForElementPresent(driver, findPropertyInput, 3);
			Utility_Functions.xClick(driver, findPropertyInput, true);
			Utility_Functions.xWaitForElementPresent(driver, searchButtonProperty, 3);
			Utility_Functions.xClick(driver, searchButtonProperty, true);
			Utility_Functions.timeWait(2);
			List<WebElement> propertyList = driver.findElements(By.xpath(
					"//table[@class='slds-table slds-table--bordered slds-table--cell-buffer slds-table--fixed-layout cPropertySearch']//th[@class='slds-truncate']/a"));
			Utility_Functions.timeWait(1);
			Utility_Functions.xclickRandomElement(propertyList);
			Utility_Functions.timeWait(2);
			Utility_Functions.xClick(driver, finalPropertyCheckbox, true);
			Utility_Functions.timeWait(2);
			if (saveButtonProperty.isDisplayed()) {
				Utility_Functions.xClick(driver, saveButtonProperty, true);
				report.updateTestLog("Verify Opportunity", "Associate property to an opportunity successfully ",
						Status.PASS);
			} else {
				report.updateTestLog("Verify Opportunity", "Associate property to an opportunity failed ", Status.FAIL);
			}
		} catch (Exception e) {
			Utility_Functions.xWaitForElementPresent(driver, associatePropertyCapitalMarkets, 3);
			Utility_Functions.xClick(driver, associatePropertyCapitalMarkets, true);
			Utility_Functions.xWaitForElementPresent(driver, searchProperties, 3);
			Utility_Functions.xClick(driver, searchProperties, true);
			Utility_Functions.timeWait(2);
			List<WebElement> propertiesList = driver.findElements(By.xpath(
					"//div[@class='undefined lookup__menu uiAbstractList uiAutocompleteList uiInput uiAutocomplete uiInput--default uiInput--lookup']//div[@class='listContent']/ul/li"));
			Utility_Functions.timeWait(2);
			Utility_Functions.xclickOnFirstElementfromList(propertiesList);
			Utility_Functions.xWaitForElementPresent(driver, save, 3);
			Utility_Functions.xClick(driver, save, true);
			Utility_Functions.xWaitForElementPresent(driver, opportunityPropertyCreated, 3);
			if (opportunityPropertyCreated.getText().contains("was created.")) {
				report.updateTestLog("Verify Opportunity", "Associate property to an opportunity successfully ",
						Status.PASS);
			} else {
				report.updateTestLog("Verify Opportunity", "Associate property to an opportunity failed ", Status.FAIL);
			}
		}
	}

	/**
	 * Function for retrieving the Opportunity
	 * 
	 * @author Vishnuvardhan
	 *
	 */

	public String retriveOpportunity() {
		String query = "SELECT Id, Name FROM Opportunity where StageName < '16-In Escrow'";
		String OpportunityID = searchTextSOQL.searchOpportunity(query);
		report.updateTestLog("Verify Opportunity Required Fields",
				"Opportunity retrived from database is:::" + OpportunityID, Status.PASS);
		replaceOpportunityId(OpportunityID);
		Utility_Functions.timeWait(1);
		return OpportunityID;
	}

	/**
	 * Validate Opportunity Name is not auto generated when manually added by
	 * the user
	 * 
	 * @author Vishnuvardhan
	 *
	 */

	public void navigateOpportunityNewLayoutPage() {
		selectNewOpportunity();
		if(dataTable.getData("General_Data", "TC_ID").startsWith("TC_SF_VAS")) {
			opportunityCreationNewPageLayoutPage();
		} else {
			Utility_Functions.xSwitchtoFrame(driver, continueButton);
			Utility_Functions.xWaitForElementPresent(driver, continueButton, 3);
			if (dataTable.getData("General_Data", "TC_ID").contains("DSFOpportunity")) {
				Utility_Functions.xClick(driver, opportunityRecordType, true);
				Utility_Functions.xWaitForElementPresent(driver, opportunityRecordTypeDebtStructuredFinance, 2);
				Utility_Functions.xClick(driver, opportunityRecordTypeDebtStructuredFinance, true);
			} else if ((dataTable.getData("General_Data", "TC_ID").contains("PSOpportunity"))) {
				Utility_Functions.xClick(driver, opportunityRecordType, true);
				Utility_Functions.xWaitForElementPresent(driver, opportunityRecordTypeValuePropertySales, 2);
				Utility_Functions.xClick(driver, opportunityRecordTypeValuePropertySales, true);
			} else if ((dataTable.getData("General_Data", "TC_ID").contains("ABAPAC"))) {
				Utility_Functions.xClick(driver, opportunityRecordType, true);
				Utility_Functions.xWaitForElementPresent(driver, opportunityRecordTypeValueAPACLandlord, 2);
				Utility_Functions.xClick(driver, opportunityRecordTypeValueAPACLandlord, true);
			}
			Utility_Functions.xClick(driver, continueButton, true);
			driver.switchTo().defaultContent();
			Utility_Functions.xSwitchtoFrame(driver, accountName);
			Utility_Functions.timeWait(3);
			opportunityCreationNewPageLayoutPage();
		}
	}

	public void opportunityCreationNewPageLayoutPage() {
		String sAccountName = searchTextSOQL.fetchRecord("Account", "Name");
		int value = 0; String sSelectedAccount = null;
		if (sAccountName == null) {
			report.updateTestLog("Opportunity Created",
					"There are no Opportunity records present for this record type:::", Status.PASS);
		} else {
			if((dataTable.getData("General_Data", "TC_ID").startsWith("TC_SF_OB")) || (dataTable.getData("General_Data", "TC_ID").startsWith("TC_SF_AB")) || (dataTable.getData("General_Data", "TC_ID").startsWith("TC_SF_VAS")))
			{
				sSelectedAccount = opportunityCreationPopUp(sAccountName);
			} else {
				value = opportunityCreation(sAccountName);
			}
			Utility_Functions.timeWait(5);
			driver.switchTo().defaultContent();
			driver.navigate().refresh();
			Utility_Functions.timeWait(5);
			try {
				Utility_Functions.xWaitForElementPresent(driver, related, 4);
				if (related.isDisplayed()) {
					report.updateTestLog("Opportunity Created", "Opportunity created successfully:::", Status.PASS);
				} else {
					report.updateTestLog("Opportunity Created", "Opportunity creation failed:::", Status.FAIL);
				}
			} catch (Exception e) {
				report.updateTestLog("Opportunity Related Tab", "System was unable to find the Related tab:::",
						Status.WARNING);
			}
			Utility_Functions.timeWait(2);
			String sOpportunityName;
			sOpportunityName = opportunityHeader.getText();
					
		/*	String query = "Select Name from opportunity where Name like  " + "'" + sAccountName + "-" + '%' + "-"
					+ value + "-" + "Acres" + "'";
			Utility_Functions.timeWait(1);
			String opportunityName = searchTextSOQL.fetchRecordFieldValue("Name", query);*/
			report.updateTestLog("Opportunity Created", "Opportunity Name:::" + sOpportunityName, Status.PASS);
			Utility_Functions.timeWait(1);
			if((dataTable.getData("General_Data", "TC_ID").startsWith("TC_SF_OB")) || (dataTable.getData("General_Data", "TC_ID").startsWith("TC_SF_AB"))) {
				if ((sOpportunityName.contains(sSelectedAccount)) && (sOpportunityName.contains("Consulting"))
						/*opportunityName.contains(Integer.toString(value)) && opportunityName.contains("Acres")*/) {
					report.updateTestLog("Opportunity Created",
							"Opportunity Name created as per the format expected -- Account Name - Assignment Type - Total Size - Unit of Measure:::",
							Status.PASS);
					System.out.println(
							" Opportunity Name created as per the format expected -- Account Name - Assignment Type - Total Size - Unit of Measure successfully !!!!!");
				} else {
					report.updateTestLog("Opportunity Created",
							"Opportunity Name is not created as per the expected format:::", Status.FAIL);
				}
			} else if(dataTable.getData("General_Data", "TC_ID").startsWith("TC_SF_VAS")) {
				if ((sOpportunityName.contains(sSelectedAccount)) && (sOpportunityName.contains("Beijing")) && (sOpportunityName.contains("Industrial"))) {
						report.updateTestLog("Opportunity Created",
								"Opportunity Name created as per the format expected -- Account Name - Assignment Type - Total Size - Unit of Measure:::",
								Status.PASS);
						System.out.println(
								" Opportunity Name created as per the format expected -- Account Name - Assignment Type - Total Size - Unit of Measure successfully !!!!!");
					} else {
						report.updateTestLog("Opportunity Created",
								"Opportunity Name is not created as per the expected format:::", Status.FAIL);
					}
			} else {
				if ((sOpportunityName.contains(sAccountName)) && (sOpportunityName.contains(Integer.toString(value)))
						&& (sOpportunityName.contains("Acres"))) {
						report.updateTestLog("Opportunity Created",
								"Opportunity Name created as per the format expected -- Account Name - Assignment Type - Total Size - Unit of Measure:::",
								Status.PASS);
						System.out.println(
								" Opportunity Name created as per the format expected -- Account Name - Assignment Type - Total Size - Unit of Measure successfully !!!!!");
					} else {
						report.updateTestLog("Opportunity Created",
								"Opportunity Name is not created as per the expected format:::", Status.FAIL);
					}
			}			
		}
	}

	/**
	 * Function for creating the Opportunity
	 * 
	 * @author Vishnuvardhan
	 *
	 */


	public int opportunityCreation(String sAccountName) {
		Utility_Functions.xSendKeys(driver, accountName, sAccountName);
        Utility_Functions.timeWait(1);
        accountName.sendKeys(Keys.ENTER);
        Utility_Functions.timeWait(2);
        Utility_Functions.xScrollWindow(driver);
        Utility_Functions.xSelectDropdownByIndex(assignmentTypeOpp, 1);
        System.out.println(Calendar.getInstance());
        DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
        Date date = new Date();
        Utility_Functions.xWaitForElementPresent(driver, leadSource, 5);
        Utility_Functions.xSelectDropdownByIndex(leadSource, 1);
        Utility_Functions.xWaitForElementPresent(driver, closeDateOpp, 2);
        Utility_Functions.xSendKeys(driver, closeDateOpp, dateFormat.format(date).toString());
        Utility_Functions.xSendKeys(driver, closeDateOpp, Keys.TAB);
        Random random = new Random();
        int value = random.nextInt(999);
        Utility_Functions.xWaitForElementPresent(driver, totalSizeOpp, 2);
        Utility_Functions.xSendKeys(driver, totalSizeOpp, Integer.toString(value));
        Utility_Functions.xWaitForElementPresent(driver, unitofMeasure, 2);
        Utility_Functions.xSelectDropdownByName(unitofMeasure, "Acres");
        Utility_Functions.xWaitForElementPresent(driver, estimatedGrossFee, 3);
        Utility_Functions.xClick(driver, estimatedGrossFee, true);
        Utility_Functions.xSendKeys(driver, estimatedGrossFee, "10000");
        try {
               Utility_Functions.xSelectDropdownByIndex(preferredPropertyTypeOpp, 1);
        } catch (Exception e) {
               e.printStackTrace();
        }
        Utility_Functions.xClick(driver, saveNewOpportunity, true);
        report.updateTestLog("Opportunity Created", "Clicked on Opportunity save button successfully:::", Status.PASS);
 
        try {        
               List<WebElement> accountErrorMessageList = driver.findElements(By.xpath("//div[@class='message errorM3']//li[text()='Account Name: You must select a value']"));
               int count=0;
               for(WebElement element: accountErrorMessageList) {
                     if(count==0) {
                            System.out.println("Skipping the first element");
                     } else if((count==1) && (element.getText().contains("Account Name"))) {
                                   accountName.clear();
                                   Utility_Functions.xSendKeys(driver, accountName, sAccountName);
                                   Utility_Functions.timeWait(1);
                                   accountName.sendKeys(Keys.TAB);
                                   Utility_Functions.timeWait(1);
                                   accountName.sendKeys(Keys.ENTER);
                                   Utility_Functions.xClick(driver, saveNewOpportunity, true);
                                   report.updateTestLog("Opportunity Created", "Clicked on Opportunity save button successfully:::", Status.PASS);
                                   break;
                     }                    
                     count++;
               }
        } catch (Exception e) {
               e.printStackTrace();
        }             
        return value;
 }

	
	
	@FindBy(xpath = "//span[text()='Preferred Property Type']/parent::span/parent::div//a")
    WebElement preferredPropertyTypeOppGWS;
	
	@FindBy(xpath = "//span[text()='Maximum Total Size']/parent::label/parent::div/input")
    WebElement totalSizeOppPop;
	
	@FindBy(xpath = "//h1[contains(@class,'slds-page-header__title')]/span")
    WebElement opportunityHeader;
	
	@FindBy(xpath = "//span[@class='pillText']")
    WebElement selectedAccount;	
	
	@FindBy(xpath = "//span[text()='Lead Source']/parent::span/parent::div/parent::div//a")
	WebElement leadSourceVAS;
	
	@FindBy(xpath = "//span[text()='CBRE Office']/parent::span/parent::div/parent::div//a")
	WebElement CBREOfficeVAS;	
	
	@FindBy(xpath = "//span[text()='Country']/parent::span/parent::div/parent::div//a")
	WebElement countryVAS;	
	
	@FindBy(xpath = "//span[text()='City Tier']/parent::span/parent::div/parent::div//a")
	WebElement cityTierVAS;	
	
	@FindBy(xpath = "//span[text()='City']/parent::label/parent::div/parent::div/parent::div//input")
	WebElement cityVAS;	
	
	@FindBy(xpath = "//span[text()='Asset Type']/parent::span/parent::div/parent::div//a")
	WebElement AssetTypeVAS;	

	@FindBy(xpath = "//a[@title='Targeting']")
	WebElement salesStageTarget;
	
	@FindBy(xpath = "//a[@title='Closed Won']")
	WebElement closedWon;
	
	@FindBy(xpath = "//li[text()='Please fill out Net Fee']")
	WebElement netFeeValidation;
	
	
	public String opportunityCreationPopUp(String sAccountName) {
		String sAccountNameSelected = null;
		if(dataTable.getData("General_Data", "TC_ID").startsWith("TC_SF_VAS")) {
			Utility_Functions.xSendKeys(driver, accountNameSearchBox, sAccountName);
			sf_UtilityFunctions.selectObjectFromLookUpList();
			DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		    Date date = new Date();
		    Utility_Functions.xScrollWindow(driver);
		    Utility_Functions.timeWait(2);
		    Utility_Functions.xScrollWindowTop(driver);
		    Utility_Functions.timeWait(2);
			sAccountNameSelected = selectedAccount.getText();
		    Utility_Functions.xSendKeys(driver, closeDateOppGWS, dateFormat.format(date).toString());
	        Utility_Functions.xSendKeys(driver, closeDateOppGWS, Keys.TAB);
	        Utility_Functions.xClick(driver, leadSourceVAS, true);
		    sf_UtilityFunctions.selectValueFromDropdownList(dropDownList, "Business Relationship");
		    Utility_Functions.xClick(driver, CBREOfficeVAS, true);
		    sf_UtilityFunctions.selectValueFromDropdownList(dropDownList, "China – Beijing");
		    Utility_Functions.xClick(driver, countryVAS, true);
		    sf_UtilityFunctions.selectValueFromDropdownList(dropDownList, "China");
		    Utility_Functions.xClick(driver, cityTierVAS, true);
		    sf_UtilityFunctions.selectValueFromDropdownList(dropDownList, "Tier 1");
		    Utility_Functions.xSendKeys(driver, cityVAS, "Beijing");
		    Utility_Functions.xClick(driver, AssetTypeVAS, true);
		    sf_UtilityFunctions.selectValueFromDropdownList(dropDownList, "Industrial");		    
		    Utility_Functions.xClick(driver, saveOpportunityGWS, true);
			Utility_Functions.timeWait(5);
			Utility_Functions.xWaitForElementPresent(driver, related, 6);
			if(related.isDisplayed()) {
				report.updateTestLog("Verify Opportunity Creation", "New Opportunity created successfully:::", Status.PASS);
			} else {
				report.updateTestLog("Verify Opportunity Creation", "New Opportunity creation failed:::", Status.FAIL);
			}
		} else if (dataTable.getData("General_Data", "TC_ID").contains("PropertySalesSellSide")) {
			String opptName = "PropSaleSellSide" + Utility_Functions.xRandomFunction();
			//
			Utility_Functions.xSendKeys(driver, opportunityName_AS, opptName);
			Utility_Functions.xSendKeys(driver, accountNameSearchBox, "Test");
			Utility_Functions.timeWait(2);
			accountNameSearchBox.sendKeys(Keys.ARROW_DOWN);
			accountNameSearchBox.sendKeys(Keys.ENTER);
			Utility_Functions.timeWait(2);
			Utility_Functions.xWaitForElementPresent(driver, leadSourceNewOpp, 3);
			Utility_Functions.xClick(driver, leadSourceNewOpp, true);
			Utility_Functions.xWaitForElementPresent(driver, leadSourceNewOppValue, 3);
			Utility_Functions.xClick(driver, leadSourceNewOppValue, true);
			
			Utility_Functions.xWaitForElementPresent(driver, estimatedTransactionValue, 3);
			Utility_Functions.xSendKeys(driver, estimatedTransactionValue,String.valueOf(1000));
			
			Utility_Functions.xWaitForElementPresent(driver, salesStageGWS, 4);
			Utility_Functions.xClick(driver, salesStageGWS, true);
			Utility_Functions.xWaitForElementPresent(driver, salesStageTarget, 4);
			Utility_Functions.xClick(driver, salesStageTarget, true);
			DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
			Date date = new Date();
			Utility_Functions.xSendKeys(driver, closeDateOppGWS, dateFormat.format(date).toString());
			Utility_Functions.xSendKeys(driver, closeDateOppGWS, Keys.TAB);
			Utility_Functions.xClick(driver, saveOpportunityGWS, true);
			Utility_Functions.timeWait(3);
			
		}	else if(dataTable.getData("General_Data", "TC_ID").contains("OpportunitiesNetFee"))  {
			
			String opptName = "OppNetFee" + Utility_Functions.xRandomFunction();
			Utility_Functions.xSendKeys(driver, opportunityName_AS, opptName);
			Utility_Functions.xSendKeys(driver, accountNameSearchBox, "Test");
			Utility_Functions.timeWait(2);
			accountNameSearchBox.sendKeys(Keys.ARROW_DOWN);
			accountNameSearchBox.sendKeys(Keys.ENTER);
			Utility_Functions.timeWait(2);
			DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
			Date date = new Date();
			Utility_Functions.xSendKeys(driver, closeDateOppGWS, dateFormat.format(date).toString());
			Utility_Functions.xSendKeys(driver, closeDateOppGWS, Keys.TAB);
			Utility_Functions.xWaitForElementPresent(driver, salesStageGWS, 4);
			Utility_Functions.xClick(driver, salesStageGWS, true);
			Utility_Functions.xWaitForElementPresent(driver, closedWon, 4);
			Utility_Functions.xClick(driver, closedWon, true);
			Utility_Functions.xClick(driver, saveOpportunityGWS, true);
			Utility_Functions.timeWait(3);
			Utility_Functions.xWaitForElementPresent(driver, netFeeValidation, 5);
			if(netFeeValidation.isDisplayed()) {
				report.updateTestLog("Net Fee Validation", "Net Fee field is filled", Status.PASS);
			} else {
				report.updateTestLog("Net Fee Validation", "Net Fee field isn't filled", Status.FAIL);
			}
		}
		
		else {
			Utility_Functions.xSendKeys(driver, accountNameSearchBox, sAccountName);
			sf_UtilityFunctions.selectObjectFromLookUpList();
			DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
		    Date date = new Date();
		    Utility_Functions.xScrollWindow(driver);
		    Utility_Functions.timeWait(2);
		    Utility_Functions.xScrollWindowTop(driver);
		    Utility_Functions.timeWait(2);
			sAccountNameSelected = selectedAccount.getText();
		    Utility_Functions.xSendKeys(driver, closeDateOppGWS, dateFormat.format(date).toString());
	        Utility_Functions.xSendKeys(driver, closeDateOppGWS, Keys.TAB);
	        Utility_Functions.xClick(driver,assignmentTypeOppGWS , true);
	        sf_UtilityFunctions.selectValueFromDropdownList(dropDownList, "Consulting");
	        Random random = new Random();
	        int value = random.nextInt(999);
			Utility_Functions.xWaitForElementPresent(driver, totalSizeOppPop, 2);
			Utility_Functions.xSendKeys(driver, totalSizeOppPop, Integer.toString(value));
	    	try {
	    		 Utility_Functions.xClick(driver,preferredPropertyTypeOppGWS , true);
	    	     sf_UtilityFunctions.selectValueFromDropdownList(dropDownList, "Hotel");		
	    	     } catch (Exception e) {
				e.printStackTrace();
			}
	    	Utility_Functions.xClick(driver, saveOpportunityGWS, true);
			Utility_Functions.timeWait(5);
			Utility_Functions.xWaitForElementPresent(driver, related, 6);
			if(related.isDisplayed()) {
				report.updateTestLog("Verify Opportunity Creation", "New Opportunity created successfully:::", Status.PASS);
			} else {
				report.updateTestLog("Verify Opportunity Creation", "New Opportunity creation failed:::", Status.FAIL);
			}
		}		
		return sAccountNameSelected;
	}

	/**
	 * Validating the manage Opportunity verify Custom Event Page
	 * 
	 * @author Ramya
	 *
	 */

	static ArrayList<String> labelsOpportunitiesNewCustomEvent = new ArrayList<String>();

	public void labelsOpportunitiesNewCustomEvent() {
		labelsOpportunitiesNewCustomEvent.add("Subject");
		labelsOpportunitiesNewCustomEvent.add("Activity Type");
		labelsOpportunitiesNewCustomEvent.add("Type");
		labelsOpportunitiesNewCustomEvent.add("Location");
		labelsOpportunitiesNewCustomEvent.add("*Start ");
		labelsOpportunitiesNewCustomEvent.add("Start Date");
		labelsOpportunitiesNewCustomEvent.add("Time");
		labelsOpportunitiesNewCustomEvent.add("EndDate");
		labelsOpportunitiesNewCustomEvent.add("Due Date");
		labelsOpportunitiesNewCustomEvent.add("Time");
		labelsOpportunitiesNewCustomEvent.add("Attachment");
		labelsOpportunitiesNewCustomEvent.add("Description");
		labelsOpportunitiesNewCustomEvent.add("Assigned To");
		labelsOpportunitiesNewCustomEvent.add("Opportunity");
		labelsOpportunitiesNewCustomEvent.add("Contact");
		labelsOpportunitiesNewCustomEvent.add("Set Reminder");

	}

	/**
	 * Validating the manage Opportunity verify Custom Event Page
	 * 
	 * @author Ramya
	 *
	 */
	public void opportunityVerifyCustomEventPage() {
		selectOpportunity();
		Utility_Functions.xWaitForElementPresent(driver, newEventOpp, 3);
		Utility_Functions.xClick(driver, newEventOpp, true);
		Utility_Functions.timeWait(3);
		if (newEventAddButton.isDisplayed()) {
			Utility_Functions.xWaitForElementPresent(driver, newEventAddButton, 3);
			Utility_Functions.xClick(driver, newEventAddButton, true);
		}		
		eventPage.verifyNewEventPageLayout();
	} 

	/**
	 * Validating the Quick create Opportunity page from the Opportunity tab
	 * with existing Account
	 * 
	 * @author Ramya
	 *
	 */

	static ArrayList<String> quickCreateLabelsOpportunityPage = new ArrayList<String>();

	public void quickCreateLabelsOpportunityPage() {
		quickCreateLabelsOpportunityPage.add("Opportunity Name");
		quickCreateLabelsOpportunityPage.add("Account Name");
		quickCreateLabelsOpportunityPage.add("Close Date");
		quickCreateLabelsOpportunityPage.add("Sales Stage");
		System.out.println("Quick Create Opportunity Label List are:::" + quickCreateLabelsOpportunityPage);
	}

	public void verifyQuickCreateOpportunityPage() {
		selectNewOpportunity();
		report.updateTestLog("Verify Quick Create Opportunity Page  ", "Verifying the Opportunities page is displayed",
				Status.PASS);
		report.updateTestLog("Verify Quick Create Opportunity Page   ",
				"Verifying the new opportunity page is displayed", Status.PASS);
		Utility_Functions.timeWait(3);
		Utility_Functions.xSwitchtoFrame(driver, closeDateOpp);
		Utility_Functions.xWaitForElementPresent(driver, labelListOpportunitiesPage, 3);
		int i1 = 0, j = 0, countLabelList = 0;
		quickCreateLabelsOpportunityPage();
		String[] labelTexts = new String[labelListOpportunitiesPage.size()];
		while (j < quickCreateLabelsOpportunityPage.size()) {
			for (WebElement element : labelListOpportunitiesPage) {
				labelTexts[i1] = element.getText();
				if (labelTexts[i1].contains(quickCreateLabelsOpportunityPage.get(j))) {
					System.out.println("Verify Add Opportunity Page Label List" + element.getText());
					report.updateTestLog("Verify Add Opportunity Page Label List",
							element.getText() + "::::label list is present in Add Opportunity Page", Status.PASS);
					countLabelList++;
					if (countLabelList == 4) {
						break;
					}
				}
				i1++;
			}
			i1 = 0;
			j++;
		}
		System.out.println("OpportunityInformationList:::" + countLabelList);
		if (countLabelList == 4) {
			report.updateTestLog("Verify Quick Create Section", "Labels are present in Add Opportunity Page:::",
					Status.PASS);
		} else {
			report.updateTestLog("Verify Quick Create Section", "Labels are not present in Add Opportunity Page:::",
					Status.FAIL);
		}
	}

	/**
	 * Validating the Quick create Opportunity page from the Opportunity tab
	 * with existing Account for Asset Services
	 * 
	 * @author Ramya
	 *
	 */

	List<String> reasonForLossPickList = new ArrayList<String>();
	
	public void ReasonForLossPickListAssetServices() {
		reasonForLossPickList.add("");
		reasonForLossPickList.add("--None--");
		reasonForLossPickList.add("Client Action Postponed");
		reasonForLossPickList.add("Fee Too High");
		reasonForLossPickList.add("Not Right Service /Product Fit");
		reasonForLossPickList.add("Prior Relationship");
		reasonForLossPickList.add("Property Not Sold");
		reasonForLossPickList.add("Self Perform");
		reasonForLossPickList.add("Stayed with Incumbent");
		System.out.println("Reason for Loss Picklist values for Asser Services AMER are:::" + reasonForLossPickList);
	}
	
	
	public void verifyQuickCreateOpportunityPageAssetServices() {
	/*	selectOpportunity();
		report.updateTestLog("Verify Quick Create Opportunity Page Asset Services ",
				"Verifying the Opportunities page is displayed", Status.PASS);
		report.updateTestLog("Verify Quick Create Opportunity Page Asset Services   ",
				"Verifying the new opportunity page is displayed", Status.PASS);
		Utility_Functions.xScrollWindow(driver);
		Utility_Functions.timeWait(2);
		Utility_Functions.xScrollWindowTop(driver);
		Utility_Functions.timeWait(2);
		Utility_Functions.xWaitForElementPresent(driver, reasonForLoss, 3);
		Utility_Functions.xClick(driver, reasonForLoss, true);
		Utility_Functions.xWaitForElementPresent(driver, reasonForLossValuesPickList, 3);
		Utility_Functions.xValidateFieldsPresentonPage(reasonForLossPickList, reasonForLossValuesPickList, "Reason for loss pick list values for Asset Services AMER are:::");*/
		EstablishConnection establishConnection = new EstablishConnection(scriptHelper);
		ReasonForLossPickListAssetServices();
		List<String> reasonForLossPickList = establishConnection.establishMetaDataConnection("Opportunity", "APAC_Asset_Services", "Reason_for_Loss__c");
		List<String> reasonForLossListValues = new ArrayList<String>();
		reasonForLossListValues = Utility_Functions.xValidatePickListValuesPage(reasonForLossPickList, reasonForLossPickList, "Reason for loss pick list values");
		if (reasonForLossListValues.size() != 0) {
			report.updateTestLog("Verify Opportunity",
					"All the values are not present in the reason for loss Pick List:::"+ reasonForLossListValues, Status.FAIL);
		} else {
			report.updateTestLog("Verify Opportunity", "All the values are present in the Management Award To Pick List ", Status.PASS);
		}
	}

	/**
	 * Validating the Quick create Opportunity page from the Opportunity tab
	 * with existing Account for Asset Services
	 * 
	 * @author Ramya
	 *
	 */
	public void verifyQuickCreateOpportunityPageAssetServicesManager() {
		verifyQuickCreateOpportunityPageAssetServices();
	}

	/**
	 * Validating the Quick create Opportunity page from the Opportunity tab
	 * with existing Account for AwardedTo
	 * 
	 * @author Ramya
	 *
	 */

	static ArrayList<String> managementAwardToList = new ArrayList<String>();

	public void managementAwardToList() {
		managementAwardToList.add("--None--");
		managementAwardToList.add("BNP");
		managementAwardToList.add("CBRE");
		managementAwardToList.add("Colliers");
		managementAwardToList.add("Cushman");
		managementAwardToList.add("DTZ");
		managementAwardToList.add("JLL");
		managementAwardToList.add("Knight Frank");
		managementAwardToList.add("Savills");
		managementAwardToList.add("Self Perform");
		managementAwardToList.add("State Street");
		managementAwardToList.add("Transwestern");
		managementAwardToList.add("Other");
		System.out.println("Management Awareded To pick list values are:::" + managementAwardToList);
	}

	static ArrayList<String> awardToArrayList = new ArrayList<String>();

	public List<String> verifyQuickCreateOpportunityPageAwardedPickList() {
		EstablishConnection establishConnection = new EstablishConnection(scriptHelper);
		managementAwardToList();
		List<String> managementAwardToPickList = establishConnection.establishMetaDataConnection("Opportunity",
				"APAC_Asset_Services", "Mgmt_Awarded_To__c");
		List<String> maanagementAwardToListValues = new ArrayList<String>();
		maanagementAwardToListValues = Utility_Functions.xValidatePickListValuesPage(managementAwardToPickList,
				managementAwardToList, "Management Award To pick list values");
		if (maanagementAwardToListValues.size() != 0) {
			report.updateTestLog("Verify Opportunity",
					"All the values are not present in the Management Award To Pick List:::"
							+ maanagementAwardToListValues,
					Status.FAIL);
		} else {
			report.updateTestLog("Verify Opportunity",
					"All the values are present in the Management Award To Pick List ", Status.PASS);
		}
		return managementAwardToPickList;
	}

	/**
	 * Validating the Quick create Opportunity page from the Opportunity for
	 * state street pick list value
	 * 
	 * @author Ramya
	 *
	 */

	public void verifyQuickCreateOpportunityPageStateStreetPickList() {
		List<String> managementAwardToPickListValues = verifyQuickCreateOpportunityPageAwardedPickList();
		int count = 0;
		for (int i = 0; i < managementAwardToPickListValues.size(); i++) {
			if (managementAwardToPickListValues.get(i).equals("State Street")) {
				count++;
			}
		}
		if (count == 1) {
			report.updateTestLog("Verify Opportunity",
					"Value State Street is not present in the Management Award To Pick List:::", Status.FAIL);
		} else {
			report.updateTestLog("Verify Opportunity",
					"Value State Street is present in the Management Award To Pick List ", Status.PASS);
		}
	}

	/**
	 * Validating the Quick create Opportunity page from the Opportunity for
	 * Lead Source
	 * 
	 * @author Ramya
	 *
	 */

	static List<String> CapitalMarketsLeadSourceList = new ArrayList<String>();

	public void leadSourceCapitalMarkets() {
		CapitalMarketsLeadSourceList.add("Business Relationship");
		CapitalMarketsLeadSourceList.add("Canvass/Cold Call");
		CapitalMarketsLeadSourceList.add("CBRE Cross Sell");
		CapitalMarketsLeadSourceList.add("CBRE Referral/Existing Mandate");
		CapitalMarketsLeadSourceList.add("Direct Award");
		CapitalMarketsLeadSourceList.add("Non CBRE Referral");
		CapitalMarketsLeadSourceList.add("Other");
		CapitalMarketsLeadSourceList.add("Personal Relationship");
		CapitalMarketsLeadSourceList.add("RFP/Proposal/Pitch");
		CapitalMarketsLeadSourceList.add("Sales Management");
		CapitalMarketsLeadSourceList.add("Speculative Marketing/Business Dev");
		System.out.println("Capital Markets lead source pick list values are:::" + CapitalMarketsLeadSourceList);

	}

	public void verifyNewOpportunityPageLeadSource() {
		leadSourceCapitalMarkets();
		EstablishConnection establishConnection = new EstablishConnection(scriptHelper);
		List<String> leadSourceCapitalMarketsPickList = establishConnection.establishMetaDataConnection("Opportunity",
				"Capital_Markets_Property_Sales", "LeadSource");
		List<String> leadSourceCapitalMarketList = new ArrayList<String>();
		leadSourceCapitalMarketList = Utility_Functions.xValidatePickListValuesPage(leadSourceCapitalMarketsPickList,
				CapitalMarketsLeadSourceList, "Lead Source pick list values");
		if (leadSourceCapitalMarketList.size() != 0) {
			report.updateTestLog("Verify Opportunity",
					"All the values are not present in the Lead Source Pick List:::" + leadSourceCapitalMarketList,
					Status.FAIL);
		} else {
			report.updateTestLog("Verify Opportunity", "All the values are present in the Lead Source Pick List ",
					Status.PASS);
		}
	}

	/**
	 * Validating the Quick create Opportunity page from the Opportunity for the
	 * Capital Markets Revenue Field
	 * 
	 * @author Ramya
	 *
	 */

	public void verifyCapitalMarketsRevenueField() {
		String sFieldName = "Capital Markets Revenue";
		int count = 0;
		EstablishConnection establishConnection = new EstablishConnection(scriptHelper);
		List<String> capitalMarketsRevenueFieldList = new ArrayList<String>();
		if(dataTable.getData("General_Data", "TC_ID").contains("ASAMER")) {
			capitalMarketsRevenueFieldList = establishConnection.establishMetaDataConnectionPageLayouts("Opportunity", "Asset Services - AMER");
		} else if(dataTable.getData("General_Data", "TC_ID").contains("ASAPAC")) {
			capitalMarketsRevenueFieldList = establishConnection.establishMetaDataConnectionPageLayouts("Opportunity", "Asset Services - APAC");
		}
		for (int i = 0; i < capitalMarketsRevenueFieldList.size(); i++) {
			if (capitalMarketsRevenueFieldList.get(i).equals(sFieldName)) {
				count++;
				break;
			}
		}
		if (count == 1) {
			report.updateTestLog("Verify Capital Markets Revenue Field Opportunity Page ",
					"Verifying the Capital Markets Revenue Field is present ", Status.PASS);
		} else {
			report.updateTestLog("Verify Capital Markets Revenue Field Opportunity Page ",
					"Verifying the Capital Markets Revenue Field is not present ", Status.FAIL);
		}
	}

	/**
	 * Validating the EBIDTAFields for the new opportunity page
	 * 
	 * @author Ramya
	 *
	 */

	public void verifyNewOpportunityEBIDTAFields() {
		EstablishConnection establishConnection = new EstablishConnection(scriptHelper);
		String sFieldName = "Est. EBITDA ($)";
		int count = 0;
		List<String> EBITDAFieldList = establishConnection.establishMetaDataConnectionPageLayouts("Opportunity",
				"Asset Services - APAC");
		for (int i = 0; i < EBITDAFieldList.size(); i++) {
			if (EBITDAFieldList.get(i).equals(sFieldName)) {
				count++;
				break;
			}
		}
		if (count == 1) {
			report.updateTestLog("Verify New Opportunity EBIDTA Fields", "The Est. EBITDA ($) Field is present",
					Status.PASS);
		} else {
			report.updateTestLog("Verify New Opportunity EBIDTA Fields", "The Est. EBITDA ($) Field is not present",
					Status.FAIL);
		}
	}

	/**
	 * Validating RFP Due Date and Pitch Due Date Fields in the new opportunity
	 * page
	 * 
	 * @author Ramya
	 *
	 */

	public void verifyRFPAndPitchDueDateNewopportunityPage() {
		String sRFPDueDate = "RFP Due Date";
		String sPitchDate = "Pitch Date";
		int count = 0;
		EstablishConnection establishConnection = new EstablishConnection(scriptHelper);
		List<String> RFPPitchDate = establishConnection.establishMetaDataConnectionPageLayouts("Opportunity",
				"Asset Services - APAC");
		for (int i = 0; i < RFPPitchDate.size(); i++) {
			if ((RFPPitchDate.get(i).equals(sRFPDueDate)) || (RFPPitchDate.get(i).equals(sPitchDate))) {
				count++;
				break;
			}
		}
		if (count == 2) {
			report.updateTestLog("Verify New Opportunity", "The RFP Due Date and Pitch Date are present", Status.PASS);
		} else {
			report.updateTestLog("Verify New Opportunity", "The RFP Due Date and Pitch Date are not present",
					Status.FAIL);
		}
	}

	/**
	 * Validating the Active Opportunities related to Account
	 * 
	 * @author Vishnuvardhan
	 *
	 */

	public String retriveAccountOpp() {
		String query = "SELECT Id, Total_Number_Of_Opps__c FROM Account where Total_Number_Of_Opps__c > 1 limit 1 offset 9";
		String sAccountID = searchTextSOQL.fetchRecordFieldValueAdminLogin("Id", query);
		report.updateTestLog("Verify Active Opportunities", "Account ID retrived from database is:::" + sAccountID,
				Status.PASS);
		replaceOpportunityId(sAccountID);
		Utility_Functions.timeWait(1);
		return sAccountID;
	}

	public void validateActiveOpportunities() {
		sf_UtilityFunctions.oneAppNavigationTab("Accounts");
		sf_UtilityFunctions.selectExistingObjectRecord("Account Name");
		report.updateTestLog("Verify Accounts", "All Accounts are Displayed", Status.PASS);
		String opportunities = retriveAccountOpp();
		if (opportunities == null) {
			report.updateTestLog("Verify Active Opportunities",
					"There are no accounts having associated with Opportunities:::", Status.PASS);
		} else {
			driver.navigate().refresh();
			sf_UtilityFunctions.selectTabUIHeaders("Related");
			Utility_Functions.timeWait(3);
			Utility_Functions.xScrollWindow(driver);
			Utility_Functions.timeWait(2);
			Utility_Functions.xScrollWindowTop(driver);
			Utility_Functions.timeWait(2);
			int count = 0;
			List<WebElement> opportunitiesListRelated = driver.findElements(
					By.xpath("//article[contains(@class,'forceRelatedListCardDesktop')]//a[contains(@href,'006')]"));
			for (WebElement element : opportunitiesListRelated) {
				report.updateTestLog("Verify Active Opportunities",
						"Opportunities associated to this Account are :::" + element.getText(), Status.PASS);
				count++;
			}
			if (count != 0) {
				report.updateTestLog("Verify Active Opportunities",
						"Opportunities hyperlinks are present in Related section for Account", Status.PASS);
			} else {
				report.updateTestLog("Verify Active Opportunities",
						"Opportunities hyperlinks are not present in Related section for Account", Status.WARNING);
			}
		}
	}


	/**
	 * Verify the required fields based on Sales stage selected between 08-Closed - Paid Partial to 09-Closed - Paid Full
	 * 
	 * @author Vishnuvardhan
	 *
	 */

	public void salesStageFunction(String query) {
		String OpportunityID = searchTextSOQL.searchOpportunity(query);
		System.out.println(OpportunityID);
		try {
			if (OpportunityID == null) {
				report.updateTestLog("Verify Opportunity","There are no Opportunities that falls under this category:::", Status.PASS);
				salesStage08_09ClosedFunction();
				salesStage08_08ClosedSubFunction();
			} else {
				replaceOpportunityId(OpportunityID);
				report.updateTestLog("Verify Add Opportunity Page Fields",
						"URL has been replaced with the new URL having the retrieved Opportunity:::", Status.PASS);
				try {
					if (accessOpportunity.isDisplayed()) {
						report.updateTestLog("Verify Opportunity Page",
								"Doesn't have access to edit the Opportunity:::", Status.PASS);
						salesStage08_09ClosedFunction();
						salesStage08_08ClosedSubFunction();
					}
				} catch (Exception e) {
					salesStage08_08ClosedSubFunction();
				}
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

	}

	public void salesStage08_ClosedPartial_09_ClosedPaidFull() {
		String query = "SELECT Estimated_Gross_Fee_Commission__c , Id, Name FROM Opportunity where StageName > '08-Closed - Paid Partial' and StageName < '09-Closed - Paid Full' and Estimated_Gross_Fee_Commission__c = 0.0 "
				+ " and Created_By_User_Role__c != null limit 1 offset 9";
		salesStageFunction(query);
	}

	public String salesStage08_09ClosedFunction() {
		navigateOpportunityNewLayoutPage();
		String oppUrl = driver.getCurrentUrl().split("#/sObject/")[1];
		System.out.println("Opp URL" + oppUrl);
		String OpportunityId = oppUrl.split("/view")[0];
		return OpportunityId;
	}

	public void salesStage08_08ClosedSubFunction() {
		String OpportunityId = salesStage08_09ClosedFunction();
		validateOpportunityFields(OpportunityId);
		Utility_Functions.xWaitForElementPresent(driver, opportunityEdit, 3);
		Utility_Functions.xClick(driver, opportunityEdit, true);
		Utility_Functions.xWaitForElementPresent(driver, salesStageOppClosed, 3);
		Utility_Functions.xClick(driver, salesStageOppClosed, true);
		Utility_Functions.xWaitForElementPresent(driver, salesStageOppClosedOption, 3);
		Utility_Functions.xClick(driver, salesStageOppClosedOption, true);
		Utility_Functions.xWaitForElementPresent(driver, assignmentTypeOpportunity, 3);
		Utility_Functions.xClick(driver, assignmentTypeOpportunity, true);
		Utility_Functions.xWaitForElementPresent(driver, assignmentTypeSaleOpportunity, 3);
		Utility_Functions.xClick(driver, assignmentTypeSaleOpportunity, true);
		Utility_Functions.xWaitForElementPresent(driver, saveStageOpp, 3);
		Utility_Functions.xClick(driver, saveStageOpp, true);
		Utility_Functions.xWaitForElementPresent(driver, reviewErrors, 3);
		if (reviewErrors.getText().equals("Review the errors on this page.")) {
			report.updateTestLog("Verify Opportunity",
					"Unable to save the Opportunity as we don't have entered the required fields:::", Status.PASS);
			Utility_Functions.xWaitForElementPresent(driver, estimatedTransactionValue, 3);
			Utility_Functions.xSendKeys(driver, estimatedTransactionValue,
					dataTable.getData("General_Data", "InstallmentAmount"));
			Utility_Functions.xWaitForElementPresent(driver, estimatedGrossFeeCommissionValue, 3);
			Utility_Functions.xSendKeys(driver, estimatedGrossFeeCommissionValue,
					dataTable.getData("General_Data", "InstallmentAmount"));
			Utility_Functions.xWaitForElementPresent(driver, finalTransactionValue, 3);
			Utility_Functions.xSendKeys(driver, finalTransactionValue,
					dataTable.getData("General_Data", "InstallmentAmount"));
			Utility_Functions.xWaitForElementPresent(driver, ActualCBREGrossFeeValue, 3);
			Utility_Functions.xSendKeys(driver, ActualCBREGrossFeeValue,
					dataTable.getData("General_Data", "InstallmentAmount"));
			report.updateTestLog("Verify Opportunity", "Opportunity has been saved successfully:::", Status.PASS);
		} else {
			report.updateTestLog("Verify Opportunity",
					"Opportunity has been saved successfully without even entering all the required fields:::",
					Status.FAIL);
		}
	}

	/**
	 * Verify Verify the required fields based on Sales Stage selected between
	 * 03-RFP/Proposal to 15-Signed Lease on Opportunity from a broker profile
	 * 
	 * @author Vishnuvardhan
	 *
	 */

	public void salesStage16_In_Escrow_19_Closed() {
		String query = "SELECT Estimated_Gross_Fee_Commission__c , Id, Name FROM Opportunity where StageName > '16-In Escrow' and StageName < '19-Closed' and Estimated_Gross_Fee_Commission__c = 0.0 "
				+ " and Created_By_User_Role__c != null limit 1 offset 9";
		salesStageFunction(query);
	}

	/**
	 * Validating the Technology tools field in the new Opportunity page
	 * 
	 * @author Ramya
	 *
	 */

	public List<String> validateOpportunityTargetingInitiativeField() {
		String sTargetingInitiative = "Targeting Initiative";
		int count = 0;
		EstablishConnection establishConnection = new EstablishConnection(scriptHelper);
		List<String> TargetInitiativeField = establishConnection.establishMetaDataConnectionPageLayouts("Opportunity",
				"Asset Services - APAC");
		for (int i = 0; i < TargetInitiativeField.size(); i++) {
			if ((TargetInitiativeField.get(i).equals(sTargetingInitiative))) {
				count++;
				break;
			}
		}
		if (count == 1) {
			report.updateTestLog("Verify Opportunities Technology Tools Field", "The Technology tools field is present",
					Status.PASS);
		} else {
			report.updateTestLog("Verify Opportunities Technology Tools Field","The Technology tools field is not present", Status.FAIL);
			}
		return TargetInitiativeField;
	}

	/**
	 * Validating the Technology tools field in the new Opportunity page
	 * 
	 * @author Ramya
	 *
	 */

	static ArrayList<String> targetingInitiativeFieldsList = new ArrayList<String>();

	public void targetingInitiativeFieldsList() {
		targetingInitiativeFieldsList.add("Premier Properties");
		targetingInitiativeFieldsList.add("US Retail Strike");
		targetingInitiativeFieldsList.add("US - Seal Team 5");
		System.out.println("Targeting Iniatiative fields  are:: " + targetingInitiativeFieldsList);
	}

	public void validateTargetingInitiativePickListValue() {
		targetingInitiativeFieldsList();
		List<String> targetingInitiativeFieldsListValues = null;
		targetingInitiativeFieldsListValues = sf_UtilityFunctions.getPickListValues("Opportunity",
				"APAC Asset Services", "Targeting_Initiative__c");
		List<String> targetingInitiativeFieldsList = new ArrayList<String>();
		targetingInitiativeFieldsList = Utility_Functions.xValidatePickListValuesPage(targetingInitiativeFieldsListValues, targetingInitiativeFieldsList, "Project Enquiries field values");
		if (targetingInitiativeFieldsList.size() != 0) {
			report.updateTestLog("Verify Opportunities Targeting Initiative PickList Value","The Targeting Initiative PickList Values are not present", Status.FAIL);
		} else {
			report.updateTestLog("Verify Opportunities Targeting Initiative PickList Value", "The Targeting Initiative PickList Value is present", Status.PASS);
		}
	}

	/**
	 * Validating the Opportunities Quick create page mandatory fields
	 * 
	 * @author Ramya
	 *
	 */
	public void opportunityQuickCreatePageMandatoryFields() {
		selectNewOpportunity();
		if (dataTable.getData("General_Data", "TC_ID").contains("Admin")) {
			Utility_Functions.xSwitchtoFrame(driver, continueButton);
			Utility_Functions.xWaitForElementPresent(driver, continueButton, 5);
			Utility_Functions.xClick(driver, continueButton, true);
		}
		Utility_Functions.xSwitchtoFrame(driver, viewAllFieldsButton);
		Utility_Functions.xWaitForElementPresent(driver, viewAllFieldsButton, 5);
		Utility_Functions.xClick(driver, viewAllFieldsButton, true);
		Utility_Functions.timeWait(5);
		Utility_Functions.xWaitForElementPresent(driver, opportunityName, 3);
		Utility_Functions.xSendKeys(driver, opportunityName,
				"Test Automation Opportunity_" + Utility_Functions.xGenerateAlphaNumericString());
		if (dataTable.getData("General_Data", "TC_ID").contains("Admin")) {
			Utility_Functions.xWaitForElementPresent(driver, accountName, 4);
			Utility_Functions.xSendKeys(driver, accountName,
					"-963425397_Test Automation_0131 (2100 Ross Avenue, Dallas, United States)");
			Utility_Functions.xWaitForElementPresent(driver, accountNameValueAdmin, 4);
			Utility_Functions.xClick(driver, accountNameValueAdmin, true);
			Utility_Functions.xWaitForElementPresent(driver, assignmentTypeOpp, 4);
			Utility_Functions.xClick(driver, assignmentTypeOpp, true);
			Utility_Functions.xWaitForElementPresent(driver, assignmentTypeValue, 4);
			Utility_Functions.xClick(driver, assignmentTypeValue, true);
			Utility_Functions.timeWait(2);
			Utility_Functions.xScrollWindow(driver);
			Utility_Functions.timeWait(1);
			Utility_Functions.xScrollWindowTop(driver);
			Utility_Functions.timeWait(2);
			Utility_Functions.xWaitForElementPresent(driver, preferedPropertyTypeAdmin, 4);
			Utility_Functions.xClick(driver, preferedPropertyTypeAdmin, true);
			Utility_Functions.xWaitForElementPresent(driver, preferedPropertyTypeValueAdmin, 4);
			Utility_Functions.xClick(driver, preferedPropertyTypeValueAdmin, true);
		} else {
			String query = "SELECT Id, Name, EMEA_Searchable__c FROM Account where EMEA_Searchable__c = true limit 1 offset 9";
			String sAccountName = searchTextSOQL.fetchRecordFieldValue("Name", query);
			Utility_Functions.xSendKeys(driver, accountName, sAccountName);
			accountName.sendKeys(Keys.ARROW_DOWN);
			Utility_Functions.timeWait(2);
			accountName.sendKeys(Keys.ENTER);
			Utility_Functions.timeWait(2);
			Utility_Functions.xWaitForElementPresent(driver, salesStageEMEANewOpportunity, 4);
			Utility_Functions.xClick(driver, salesStageEMEANewOpportunity, true);
			Utility_Functions.xWaitForElementPresent(driver, salesStageEMEANewOpportunityValue, 4);
			Utility_Functions.xClick(driver, salesStageEMEANewOpportunityValue, true);
		}
		if (!dataTable.getData("General_Data", "TC_ID").contains("Admin")) {
			Utility_Functions.xWaitForElementPresent(driver, estimatedGrossFeeNewOpportunity, 5);
			Utility_Functions.xSendKeys(driver, estimatedGrossFeeNewOpportunity,
					dataTable.getData("General_Data", "InstallmentAmount"));
		} else {
			Utility_Functions.xWaitForElementPresent(driver, salesStageEMEAEstimatedGrossCommission, 3);
			Utility_Functions.xSendKeys(driver, salesStageEMEAEstimatedGrossCommission,
					dataTable.getData("General_Data", "InstallmentAmount"));
		}
		System.out.println(Calendar.getInstance());
		DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
		Date date = new Date();
		Utility_Functions.xWaitForElementPresent(driver, closeDateNewOpportunity, 3);
		Utility_Functions.xSendKeys(driver, closeDateNewOpportunity, dateFormat.format(date).toString());
		Utility_Functions.timeWait(2);
		if ((dataTable.getData("General_Data", "TC_ID").contains("CMEMEABrokerBCP"))) {
			System.out.println(Calendar.getInstance());
			DateFormat dateFormat1 = new SimpleDateFormat("MM/dd/yyyy");
			Date date1 = new Date();
			Utility_Functions.xWaitForElementPresent(driver, engagementCommencement, 3);
			Utility_Functions.xSendKeys(driver, engagementCommencement, dateFormat1.format(date1).toString());
			Utility_Functions.timeWait(2);
		}
		Utility_Functions.xWaitForElementPresent(driver, saveOpportunitySplitUAT, 4);
		Utility_Functions.xClick(driver, saveOpportunitySplitUAT, true);
		Utility_Functions.timeWait(2);
		if (details.isDisplayed()) {

			report.updateTestLog("Verify Opportunity Quick Create Mandatory Fields","The opportunity is saved with all the mandatory fields",Status.PASS);
		} else {
			report.updateTestLog("Verify Opportunity Quick Create Mandatory Fields","The opportunity is not saved with all the mandatory fields", Status.FAIL);
		}
	}

	/**
	 * Validating the Opportunities Quick create page Assignment Type field
	 * 
	 * @author Ramya
	 *
	 */
	static ArrayList<String> assignmentTypeList = new ArrayList<String>();

	public void assignmentTypeValues() {

		assignmentTypeList.add("--None--");
		assignmentTypeList.add("Advisory");
		assignmentTypeList.add("Agency");
		assignmentTypeList.add("Brokerage");
		assignmentTypeList.add("Cap Mkts");
		assignmentTypeList.add("Captial Advisors JV");
		assignmentTypeList.add("Valuation");

		System.out.println("Assignment Type pick list values are: " + assignmentTypeList);
	}

	public void opportunityQuickCreateAssignmentType() {
		assignmentTypeValues();
		List<String> assignmentTypeValues = sf_UtilityFunctions.getPickListValues("Opportunity", "EMEA_Valuations",
				"Service__c");
		List<String> assignmentTypeListValues = new ArrayList<String>();
		assignmentTypeListValues = Utility_Functions.xValidatePickListValuesPage(assignmentTypeValues,
				assignmentTypeListValues, "Assignment Type Values");
		if (assignmentTypeListValues.size() != 0) {
			report.updateTestLog("Verify Opportunity",
					"All the values are not present in the Opportunity Pick List:::" + assignmentTypeListValues,
					Status.FAIL);
		} else {
			report.updateTestLog("Verify Opportunity", "All the values are present in the Opportunity Pick List ",
					Status.PASS);
		}
	}

	/**
	 * Validating the Opportunities pitch Advisor field
	 * 
	 * @author Ramya
	 *
	 */

	public void validateOpportunityPitchAdvisor() {
		selectNewOpportunity();
		if (dataTable.getData("General_Data", "TC_ID").contains("Admin")) {
			Utility_Functions.xSwitchtoFrame(driver, continueButton);
			Utility_Functions.xWaitForElementPresent(driver, selectOpportunityRecordType, 5);
			Utility_Functions.xClick(driver, selectOpportunityRecordType, true);
			Utility_Functions.xWaitForElementPresent(driver, selectOpportunityRecordTypeValue, 5);
         	Utility_Functions.xClick(driver, selectOpportunityRecordTypeValue, true);
			Utility_Functions.xWaitForElementPresent(driver, continueButton, 5);
			Utility_Functions.xClick(driver, continueButton, true);
			Utility_Functions.timeWait(2);
			driver.switchTo().defaultContent();
			Utility_Functions.timeWait(2);
		}
		Utility_Functions.xSwitchtoFrame(driver, viewAllFieldsButton);
		Utility_Functions.xWaitForElementPresent(driver, viewAllFieldsButton, 5);
		Utility_Functions.xScrollWindow(driver);
		Utility_Functions.xClick(driver, viewAllFieldsButton, true);
		Utility_Functions.timeWait(5);
		Utility_Functions.xScrollWindowTop(driver);
		Utility_Functions.xWaitForElementPresent(driver, opportunityName, 3);
		Utility_Functions.xSendKeys(driver, opportunityName,
				"Test Automation Opportunity_" + Utility_Functions.xGenerateAlphaNumericString());
		String query = "SELECT Id, Name, EMEA_Searchable__c FROM Account where EMEA_Searchable__c = true limit 1 offset 9";
		String sAccountName = searchTextSOQL.fetchRecordFieldValue("Name", query);
		Utility_Functions.xSendKeys(driver, accountName, sAccountName);
		accountName.sendKeys(Keys.ARROW_DOWN);
		Utility_Functions.timeWait(2);
		accountName.sendKeys(Keys.ENTER);
		Utility_Functions.timeWait(2);
		Utility_Functions.xWaitForElementPresent(driver, salesStageEMEAEstimatedGrossCommission, 3);
		Utility_Functions.xSendKeys(driver, salesStageEMEAEstimatedGrossCommission,
				dataTable.getData("General_Data", "InstallmentAmount"));
		Utility_Functions.xWaitForElementPresent(driver, salesStageEMEANewOpportunity, 4);
		Utility_Functions.xClick(driver, salesStageEMEANewOpportunity, true);
		Utility_Functions.xWaitForElementPresent(driver, salesStageEMEANewOpportunityValue, 4);
		Utility_Functions.xClick(driver, salesStageEMEANewOpportunityValue, true);
		System.out.println(Calendar.getInstance());
		DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
		Date date = new Date();
		Utility_Functions.xWaitForElementPresent(driver, closeDateNewOpportunity, 3);
		Utility_Functions.xSendKeys(driver, closeDateNewOpportunity, dateFormat.format(date).toString());
		Utility_Functions.xWaitForElementPresent(driver, saveOpportunitySplitUAT, 4 );
		Utility_Functions.xClick(driver, saveOpportunitySplitUAT, true);
		Utility_Functions.timeWait(4);
		Utility_Functions.xScrollWindow(driver);
		Utility_Functions.timeWait(1);
		Utility_Functions.xScrollWindowTop(driver);
		Utility_Functions.timeWait(2);
		if (pitchAdvisor.isDisplayed()) {
			report.updateTestLog("Verify Opportunity Pitch Advisor Field", "Pitch Advisor field is present",
					Status.PASS);
		} else {
			report.updateTestLog("Verify Opportunity Pitch Advisor Field", "Pitch Advisor field is not present",
					Status.FAIL);
		}
	}

	/**
	 * Validating the Opportunities Quick create page Average Annual Leasing
	 * Commission
	 * 
	 * @author Ramya
	 *
	 */

	public void validateOpportunityAverageAnnualLeasingCommission() {
		String sAverageAnnualLeasing = "Average Annual Leasing Commission";
		int count = 0;
		List<String> averageAnnualLeasing = validateOpportunityTargetingInitiativeField();
		for (int i = 0; i < averageAnnualLeasing.size(); i++) {
			if ((averageAnnualLeasing.get(i).equals(sAverageAnnualLeasing))) {
				count++;
				break;
			}
		}
		if (count == 1) {
			report.updateTestLog("Verify Opportunity",
					"Average Annual Leasing Commission is present on the Opportunity Page", Status.PASS);
		} else {
			report.updateTestLog("Verify Opportunity",
					"Average Annual Leasing Commission is not present on the Opportunity Page", Status.FAIL);
		}
	}

	/**
	 * Validating the Quick create Opportunity page for the Pyeong Value in UOM
	 * Pick List
	 * 
	 * @author Ramya
	 *
	 */

	public void verifyPyeongValueInUOMPickList() {
		sf_UtilityFunctions.verifyPickListValues("Pyeong", "Opportunity", "	APAC_Occupier", "APAC_Area_UOM__c");
	}

	/**
	 * Validating the Opportunities Quick create page for the default
	 * opportunity name
	 * 
	 * @author Ramya
	 *
	 */

	public void validateDefaultOpportunityName() {
		selectNewOpportunity();
		if ((dataTable.getData("General_Data", "TC_ID").contains("ASEMEA"))
				&& (!dataTable.getData("General_Data", "TC_ID").contains("VASEMEA"))) {

			if (opportunityName_AS.getText().equals("")) {
				System.out.println("The new opportunity name field is not populated with TBD value as default");
				report.updateTestLog("Verify Opportunity Name Default Value ",
						"Verifying the new opportunity name is populated with the default value ", Status.PASS);

			} else {
				System.out.println("The new opportunity name field is populated with TBD value as default");
				report.updateTestLog("Verify Opportunity Name Default Value ",
						"Verifying the new opportunity name is populated with the default value ", Status.FAIL);
			}

		} else if ((dataTable.getData("General_Data", "TC_ID").contains("ABEMEACSS"))
				|| (dataTable.getData("General_Data", "TC_ID").contains("ABEMEABroker"))) {
			Utility_Functions.xSwitchtoFrame(driver, continueButton);
			Utility_Functions.timeWait(3);
			Utility_Functions.xClick(driver, continueButton, true);
			driver.switchTo().defaultContent();
			Utility_Functions.timeWait(2);
			Utility_Functions.xSwitchtoFrame(driver, viewAllFieldsButton);
			Utility_Functions.timeWait(3);
			Utility_Functions.xScrollWindow(driver);
			Utility_Functions.timeWait(2);
			Utility_Functions.xScrollWindowTop(driver);
			Utility_Functions.timeWait(2);
			if (OppName.isDisplayed()) {
				System.out.println("The new opportunity name field is populated with TBD value as default");
				report.updateTestLog("Verify Opportunity Name Default Value ",
						"Verifying the new opportunity name is populated with the default value ", Status.PASS);
			} else {
				System.out.println("The new opportunity name field is not populated with TBD value as default");
				report.updateTestLog("Verify Opportunity Name Default Value ",
						"Verifying the new opportunity name is populated with the default value ", Status.FAIL);
			}

		} else if ((dataTable.getData("General_Data", "TC_ID").contains("CMEMEABrokerBCP"))
				|| (dataTable.getData("General_Data", "TC_ID").contains("CMEMEAManagerBCP"))) {

			Utility_Functions.xSwitchtoFrame(driver, viewAllFieldsButton);
			Utility_Functions.timeWait(3);
			Utility_Functions.xScrollWindow(driver);
			Utility_Functions.timeWait(2);
			Utility_Functions.xScrollWindowTop(driver);
			Utility_Functions.timeWait(2);
			if (OppName.isDisplayed()) {
				System.out.println("The new opportunity name field is populated with TBD value as default");
				report.updateTestLog("Verify Opportunity Name Default Value ",
						"Verifying the new opportunity name is populated with the default value ", Status.PASS);
			} else {
				System.out.println("The new opportunity name field is not populated with TBD value as default");
				report.updateTestLog("Verify Opportunity Name Default Value ",
						"Verifying the new opportunity name is populated with the default value ", Status.FAIL);
			}

		} else {
			Utility_Functions.xSwitchtoFrame(driver, viewAllFieldsButton);
			Utility_Functions.timeWait(3);
			Utility_Functions.xScrollWindow(driver);
			Utility_Functions.timeWait(2);
			Utility_Functions.xScrollWindowTop(driver);
			Utility_Functions.timeWait(2);
			if (OppName.isDisplayed()) {
				System.out.println("The new opportunity name field is populated with TBD value as default");
				report.updateTestLog("Verify Opportunity Name Default Value ",
						"Verifying the new opportunity name is populated with the default value ", Status.PASS);
			} else {
				System.out.println("The new opportunity name field is not populated with TBD value as default");
				report.updateTestLog("Verify Opportunity Name Default Value ",
						"Verifying the new opportunity name is populated with the default value ", Status.FAIL);
			}
			Utility_Functions.xWaitForElementPresent(driver, opportunityName, 3);
			Utility_Functions.xSendKeys(driver, opportunityName,
					"Test Automation Opportunity_" + Utility_Functions.xGenerateAlphaNumericString());
			String query = "SELECT Id, Name, EMEA_Searchable__c FROM Account where EMEA_Searchable__c = true limit 1 offset 9";
			String sAccountName = searchTextSOQL.fetchRecordFieldValue("Name", query);
			Utility_Functions.xSendKeys(driver, accountName, sAccountName);
			accountName.sendKeys(Keys.ARROW_DOWN);
			Utility_Functions.timeWait(2);
			accountName.sendKeys(Keys.ENTER);
			Utility_Functions.timeWait(2);
			Utility_Functions.xWaitForElementPresent(driver, estimatedGrossFeeNewOpportunity, 3);
			Utility_Functions.xSendKeys(driver, estimatedGrossFeeNewOpportunity,
					dataTable.getData("General_Data", "InstallmentAmount"));
			Utility_Functions.xWaitForElementPresent(driver, salesStageEMEANewOpportunity, 4);
			Utility_Functions.xClick(driver, salesStageEMEANewOpportunity, true);
			Utility_Functions.xWaitForElementPresent(driver, salesStageEMEANewOpportunityValue, 4);
			Utility_Functions.xClick(driver, salesStageEMEANewOpportunityValue, true);
			System.out.println(Calendar.getInstance());
			DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
			Date date = new Date();
			Utility_Functions.xWaitForElementPresent(driver, closeDateNewOpportunity, 3);
			Utility_Functions.xSendKeys(driver, closeDateNewOpportunity, dateFormat.format(date).toString());
			Utility_Functions.timeWait(2);
			Utility_Functions.xWaitForElementPresent(driver, saveOpportunitySplitUAT, 4);
			Utility_Functions.xClick(driver, saveOpportunitySplitUAT, true);
			Utility_Functions.timeWait(2);
			if (details.isDisplayed()) {

				report.updateTestLog("Verify Quick Create Opportunity Page Discretionary Fee",
						"The opportunity is saved with the Discretionary Fee check box checked and the Discretionary amount ",
						Status.PASS);
			} else {
				report.updateTestLog("Verify Quick Create Opportunity Page Discretionary Fee",
						"The opportunity is not saved with the Discretionary Fee check box checked and the Discretionary amount ",
						Status.FAIL);
			}

		}

	}

	/**
	 * Validating the Opportunities Installment status functionality
	 * 
	 * @author Ramya
	 *
	 */

	public void validateOpportunityInstallmentStatus() {
		sf_UtilityFunctions.oneAppNavigationTab("Opportunity");
		sf_UtilityFunctions.selectExistingObjectRecord("Opportunity Name");
		Utility_Functions.timeWait(1);
		sf_UtilityFunctions.selectTabUIHeaders("Related");
		Utility_Functions.xWaitForElementPresent(driver, opportunityInstallments, 3);
		Utility_Functions.xClick(driver, opportunityInstallments, true);
		Utility_Functions.timeWait(2);
		List<WebElement> opportunitiesInstallmentsList = driver.findElementsByXPath("//a[@class='slds-truncate outputLookupLink slds-truncate forceOutputLookup'][contains(@data-recordid,'a16')]");
		Utility_Functions.xclickOnFirstElementfromList(opportunitiesInstallmentsList);
		Utility_Functions.timeWait(1);
		Utility_Functions.xWaitForElementPresent(driver, editInstallmentStatus, 3);
		Utility_Functions.xClick(driver, editInstallmentStatus, true);
		DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
		Date date = new Date();
		Utility_Functions.xWaitForElementPresent(driver, datePaid, 3);
		Utility_Functions.xSendKeys(driver, datePaid, dateFormat.format(date).toString());
		Utility_Functions.xWaitForElementPresent(driver, commentsField, 3);
		Utility_Functions.xSendKeys(driver, commentsField, "This is Opportunity Edit");
		Utility_Functions.xWaitForElementPresent(driver, saveEditOpportunity, 3);
		Utility_Functions.xClick(driver, saveEditOpportunity, true);
		Utility_Functions.timeWait(3);

	}

	/**
	 * Validating the Opportunities Close Date field
	 * 
	 * @author Ramya
	 *
	 */
	public void validateOpportunityCloseDate() {
		opportunityQuickCreatePageMandatoryFields();
		sf_UtilityFunctions.selectTabUIHeaders("Related");
		Utility_Functions.xWaitForElementPresent(driver, opportunityInstallments, 3);
		Utility_Functions.xClick(driver, opportunityInstallments, true);
		Utility_Functions.timeWait(2);
		List<WebElement> opportunitiesInstallmentsList = driver.findElements(By.xpath(
				"//a[@class='slds-truncate outputLookupLink slds-truncate forceOutputLookup'][contains(@data-recordid,'a160')]"));
		Utility_Functions.xclickOnFirstElementfromList(opportunitiesInstallmentsList);
		Utility_Functions.timeWait(1);
		Utility_Functions.xWaitForElementPresent(driver, editOpportunity, 3);
		Utility_Functions.xClick(driver, editOpportunity, true);

	}

	/**
	 * Validating the Opportunities My Active Listings
	 * 
	 * @author Ramya
	 *
	 */
	public void validateOpportunitiesMyActiveListings() {
		sf_UtilityFunctions.oneAppNavigationTab("Opportunity");
		Utility_Functions.xWaitForElementPresent(driver, recentlyViewed, 3);
		Utility_Functions.xClick(driver, recentlyViewed, true);
		Utility_Functions.timeWait(3);
		Utility_Functions.xScrollWindow(driver);
		Utility_Functions.timeWait(2);
		Utility_Functions.xScrollWindowTop(driver);
		Utility_Functions.timeWait(2);
		if (myActiveListings.isDisplayed()) {
			System.out.println("My Active listings is displayed");
			report.updateTestLog("Verify Opportunity My Active Listings ",
					"Verifying the My Active Listings is displayed ", Status.PASS);
		} else {
			System.out.println("My Active listings is not displayed");
			report.updateTestLog("Verify Opportunity My Active Listings ",
					"Verifying the My Active Listings is displayed", Status.FAIL);
		}

	}

	/**
	 * Validating the Opportunities My Active Listings filters
	 * 
	 * @author Ramya
	 *
	 */
	public void validateOpportunitiesActiveListingsKanban() {
		validateOpportunitiesMyActiveListings();
		Utility_Functions.xWaitForElementPresent(driver, myActiveListings, 3);
		Utility_Functions.xClick(driver, myActiveListings, true);
		Utility_Functions.xWaitForElementPresent(driver, squareTable, 3);
		Utility_Functions.xClick(driver, squareTable, true);
		System.out.println("Square Table is displayed");
		report.updateTestLog("Verify Opportunity My Active Listings Filters",
				"Verifying the My Active Listings is displayed ", Status.PASS);
		Utility_Functions.timeWait(2);
		try {
			Utility_Functions.xWaitForElementPresent(driver, kanban, 3);
			Utility_Functions.xClick(driver, kanban, true);
			System.out.println("Kanban Grid is visible and clicked");
			report.updateTestLog("Verify Opportunity My Active Listings Filters", "Verifying the kanban is displayed ",
					Status.PASS);

		} catch (Exception e) {
			System.out.println("Kanban Grid is invisible");
			report.updateTestLog("Verify Opportunity My Active Listings Filters", "Verifying the kanban is displayed ",
					Status.PASS);
		}

	}

	/**
	 * Validating the Opportunities My Active Listings filters
	 * 
	 * @author Ramya
	 *
	 */
	public void validateOpportunitiesActiveListingsFilters() {
		validateOpportunitiesMyActiveListings();
		Utility_Functions.xWaitForElementPresent(driver, myActiveListings, 3);
		Utility_Functions.xClick(driver, myActiveListings, true);
		Utility_Functions.xWaitForElementPresent(driver, toggleFilters, 3);
		Utility_Functions.xClick(driver, toggleFilters, true);
		System.out.println("Filters is displayed");
		report.updateTestLog("Verify Opportunity My Active Listings Filters",
				"Verifying the My Active Listings is displayed ", Status.PASS);

		if ((opportunityRecordTypeFilters.isDisplayed()) && (phaseFilters.isDisplayed())) {
			System.out.println("Opportunity Record Type and Phase is displayed");
			report.updateTestLog("Verify Opportunity My Active Listings ",
					"Verifying the opportunity Record Type and Phase Filters are displayed ", Status.PASS);
		} else {
			System.out.println("Opportunity Record Type and Phase is not displayed");
			report.updateTestLog("Verify Opportunity My Active Listings ",
					"Verifying the opportunity Record Type and Phase Filters are displayed", Status.FAIL);
		}

	}

	/**
	 * Validating the Opportunities Property Market Value
	 * 
	 * @author Ramya
	 *
	 */
	static ArrayList<String> propertyMarketValueCurrencyList = new ArrayList<String>();

	public void propertyMarketValues() {

		propertyMarketValueCurrencyList.add("--None--");
		propertyMarketValueCurrencyList.add("EUR");
		propertyMarketValueCurrencyList.add("GBP");
		propertyMarketValueCurrencyList.add("USD");

		System.out.println("Property Market Value Currency pick list values are: " + propertyMarketValueCurrencyList);
	}

	public void validateOpportunitiesPropertyMarketValue() {
		propertyMarketValues();
		List<String> propertyMarketValues = sf_UtilityFunctions.getPickListValues("Opportunity",
				"Valuations_Advisory_Services	", "EMEA_Property_Market_Value_Currency__c");
		List<String> propertyMarketPickListValues = new ArrayList<String>();
		propertyMarketPickListValues = Utility_Functions.xValidatePickListValuesPage(propertyMarketValues,
				propertyMarketValueCurrencyList, "Property Market Type  pick list values");
		if (propertyMarketPickListValues.size() != 0) {
			report.updateTestLog("Verify Proeprty Type picklist values",
					"All the values are not present in the Property Market Type Pick List:::"
							+ propertyMarketPickListValues, Status.FAIL);
			}else {
			report.updateTestLog("Verify Proeprty Type picklist values",
					"All the values are present in the Property Market Pick List ", Status.PASS);
		}
	}

	/**
	 * Validating the Quick create Opportunity page for the Ping Value in UOM
	 * Pick List
	 * 
	 * @author Ramya
	 *
	 */

	public void verifyPingValueInUOMPickList() {
		sf_UtilityFunctions.verifyPickListValues("Ping", "Opportunity", "	APAC_Occupier", "APAC_Area_UOM__c");
	}

	/**
	 * Validating the Quick create Opportunity page for the Ping Value in UOM
	 * Pick List
	 * 
	 * @author Ramya
	 *
	 */

	public void verifyPingValueInOpportunityRecordTypes() {
		verifyPingValueInUOMPickList();
	}

	/**
	 * Validating the Quick create Opportunity page for the Ping Value in UOM
	 * Pick List for the Property Sales Value for the Opportunity record type
	 * 
	 * @author Ramya
	 *
	 */

	public void verifyPingValueInOpportunityPropertySales() {
		verifyPingValueInUOMPickList();
	}

	/**
	 * Validating the Quick create Opportunity page for the CBRE Market Group
	 * 
	 * @author Ramya
	 *
	 */

	public void verifyCBREMarketGroup() {
		String sCBREMarketGroup = "CBRE Market Group";
		int count = 0;
		EstablishConnection establishConnection = new EstablishConnection(scriptHelper);
		List<String> CBREMarketGropupList = establishConnection.establishMetaDataConnectionPageLayouts("Opportunity",
				"EMEA A&T Occupier Layout");
		for (int i = 0; i < CBREMarketGropupList.size(); i++) {
			if ((CBREMarketGropupList.get(i).equals(sCBREMarketGroup))) {
				count++;
				break;
			}
		}
		if (count == 1) {
			report.updateTestLog("Verify Opportunity", "CBRE Market Group is present on the Opportunity Page",
					Status.PASS);
		} else {
			report.updateTestLog("Verify Opportunity", "CBRE Market Group  is not present on the Opportunity Page",
					Status.FAIL);
		}

	}

	
	/**
	 * Validating the Discretionary Fee check box in the New Opportunity
	 * creation page
	 * 
	 * @author Ramya
	 * 
	 *
	 */
	public void opportunityDiscretionayFee() {
		selectNewOpportunity();
		Utility_Functions.timeWait(2);
		Utility_Functions.xSwitchtoFrame(driver, viewAllFieldsButton);
		Utility_Functions.xWaitForElementPresent(driver, viewAllFieldsButton, 5);
		Utility_Functions.xClick(driver, viewAllFieldsButton, true);
		Utility_Functions.timeWait(5);
		Utility_Functions.xWaitForElementPresent(driver, opportunityName, 3);
		Utility_Functions.xSendKeys(driver, opportunityName,
				"Test Automation Opportunity_" + Utility_Functions.xGenerateAlphaNumericString());
		String query = "SELECT Id, Name, EMEA_Searchable__c FROM Account where EMEA_Searchable__c = true limit 1 offset 9";
		String sAccountName = searchTextSOQL.fetchRecordFieldValue("Name", query);
		Utility_Functions.xSendKeys(driver, accountName, sAccountName);
		accountName.sendKeys(Keys.ARROW_DOWN);
		Utility_Functions.timeWait(2);
		accountName.sendKeys(Keys.ENTER);
		Utility_Functions.timeWait(2);
		Utility_Functions.xWaitForElementPresent(driver, salesStageEMEANewOpportunity, 4);
		Utility_Functions.xClick(driver, salesStageEMEANewOpportunity, true);
		Utility_Functions.xWaitForElementPresent(driver, salesStageEMEANewOpportunityValue, 4);
		Utility_Functions.xClick(driver, salesStageEMEANewOpportunityValue, true);
		Utility_Functions.xWaitForElementPresent(driver, estimatedGrossFeeNewOpportunity, 5);
		Utility_Functions.xSendKeys(driver, estimatedGrossFeeNewOpportunity,
				dataTable.getData("General_Data", "InstallmentAmount"));
		System.out.println(Calendar.getInstance());
		DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
		Date date = new Date();
		Utility_Functions.xWaitForElementPresent(driver, closeDateNewOpportunity, 3);
		Utility_Functions.xSendKeys(driver, closeDateNewOpportunity, dateFormat.format(date).toString());
		Utility_Functions.timeWait(2);
		Utility_Functions.xScrollWindow(driver);
		Utility_Functions.timeWait(2);
		Utility_Functions.xScrollWindowTop(driver);
		Utility_Functions.timeWait(2);
		Utility_Functions.xWaitForElementPresent(driver, discretionaryFeeCheckBox, 3);
		Utility_Functions.xClick(driver, discretionaryFeeCheckBox, true);
		Utility_Functions.xWaitForElementPresent(driver, discretionaryAmount, 3);
		Utility_Functions.xSendKeys(driver, discretionaryAmount,
				dataTable.getData("General_Data", "InstallmentAmount"));
		Utility_Functions.xWaitForElementPresent(driver, saveOpportunitySplitUAT, 4);
		Utility_Functions.xClick(driver, saveOpportunitySplitUAT, true);
		Utility_Functions.timeWait(3);
		if (details.isDisplayed()) {

			report.updateTestLog("Verify Quick Create Opportunity Page Discretionary Fee",
					"The opportunity is saved with the Discretionary Fee check box checked and the Discretionary amount", Status.PASS);
		} else {
			report.updateTestLog("Verify Quick Create Opportunity Page Discretionary Fee",
					"The opportunity is not saved with the Discretionary Fee check box checked and the Discretionary amount",
					Status.FAIL);
		}

	}

	/**
	 * Validating the Conversion Type field in the New Opportunity creation page
	 * 
	 * @author Ramya
	 * 
	 *
	 */
	static ArrayList<String> conversionTypeFieldsList = new ArrayList<String>();

	public void conversionTypePickListFields() {

		conversionTypeFieldsList.add("--None--");
		conversionTypeFieldsList.add("Pitch");
		conversionTypeFieldsList.add("Written proposal - RFP/ITT etc");
		conversionTypeFieldsList.add("Fee Proposal");
		conversionTypeFieldsList.add("Informal pitch (presentation/chat)");
		conversionTypeFieldsList.add("Information request RFI/PQQ etc");
		conversionTypeFieldsList.add("Other");
		System.out.println("The pick list values for the Conversion Type are " + conversionTypeFieldsList);

	}

	public void opportunityConversionTypeField() {
		conversionTypePickListFields();
		List<String> conversionTypePickList = sf_UtilityFunctions.getPickListValues("Opportunity",
				"e	EMEA_A_T_Occupier", "EMEA_Conversion_Type__c");
		List<String> conversionTypePickListValues = new ArrayList<String>();
		conversionTypePickListValues = Utility_Functions.xValidatePickListValuesPage(conversionTypePickList,
				conversionTypeFieldsList, "Preferecne Type pick list values");
		if (conversionTypePickListValues.size() != 0) {
			report.updateTestLog("Verify Opportunity",
					"All the values are not present in the Conversion Type Pick List:::" + conversionTypeFieldsList,
					Status.FAIL);
		} else {
			report.updateTestLog("Verify Opportunity", "All the values are present in the Conversion Type Pick List:::",
					Status.PASS);
		}
	}

	/**
	 * Validating the Opportunity Quick create page for the Total size to be
	 * mandatory for the sales stage Prospecting
	 * 
	 * @author Ramya
	 * 
	 *
	 */
	public void opportunityTotalSize() {
		Utility_Functions.xWaitForElementPresent(driver, menu_Opportunities, 3);
		Utility_Functions.xClick(driver, menu_Opportunities, true);
		Utility_Functions.xWaitForElementPresent(driver, newOpportunity, 3);
		Utility_Functions.xClick(driver, newOpportunity, true);

		Utility_Functions.xSwitchtoFrame(driver, viewAllFieldsButton);
		Utility_Functions.xWaitForElementPresent(driver, viewAllFieldsButton, 5);
		Utility_Functions.xClick(driver, viewAllFieldsButton, true);
		Utility_Functions.timeWait(5);
		Utility_Functions.xWaitForElementPresent(driver, opportunityName, 3);
		Utility_Functions.xSendKeys(driver, opportunityName,
				"Test Automation Opportunity_" + Utility_Functions.xGenerateAlphaNumericString());
		String query = "SELECT Id, Name, EMEA_Searchable__c FROM Account where EMEA_Searchable__c = true limit 1 offset 9";
		String sAccountName = searchTextSOQL.fetchRecordFieldValue("Name", query);
		Utility_Functions.xSendKeys(driver, accountName, sAccountName);
		accountName.sendKeys(Keys.ARROW_DOWN);
		Utility_Functions.timeWait(2);
		accountName.sendKeys(Keys.ENTER);
		Utility_Functions.timeWait(2);
		Utility_Functions.xWaitForElementPresent(driver, salesStageEMEANewOpportunity, 4);
		Utility_Functions.xClick(driver, salesStageEMEANewOpportunity, true);
		Utility_Functions.xWaitForElementPresent(driver, salesStageNewOppValue, 4);
		Utility_Functions.xClick(driver, salesStageNewOppValue, true);
		Utility_Functions.xWaitForElementPresent(driver, estimatedGrossFeeNewOpportunity, 5);
		Utility_Functions.xSendKeys(driver, estimatedGrossFeeNewOpportunity,
				dataTable.getData("General_Data", "InstallmentAmount"));
		System.out.println(Calendar.getInstance());
		DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
		Date date = new Date();
		Utility_Functions.xWaitForElementPresent(driver, closeDateNewOpportunity, 3);
		Utility_Functions.xSendKeys(driver, closeDateNewOpportunity, dateFormat.format(date).toString());
		Utility_Functions.timeWait(2);
		Utility_Functions.xScrollWindow(driver);
		Utility_Functions.timeWait(2);
		Utility_Functions.xScrollWindowTop(driver);
		Utility_Functions.timeWait(2);
		Utility_Functions.xWaitForElementPresent(driver, cbreMarketGroup, 4);
		Utility_Functions.xClick(driver, cbreMarketGroup, true);
		Utility_Functions.xWaitForElementPresent(driver, cbreMarketGroupValue, 4);
		Utility_Functions.xClick(driver, cbreMarketGroupValue, true);
		Utility_Functions.xWaitForElementPresent(driver, saveOpportunitySplitUAT, 4);
		Utility_Functions.xClick(driver, saveOpportunitySplitUAT, true);
		if (errorMessage.isDisplayed()) {
			report.updateTestLog("Verify Quick Create Opportunity Page Total Size",
					"The opportunity Page when the Sales Stage is Prospecting the Total Size is mandatory",
					Status.PASS);
		} else {
			report.updateTestLog("Verify Quick Create Opportunity Page Total Size",
					"The opportunity Page when the Sales Stage is Prospecting the Total Size is not throwing an error message that total size is mandatory",
					Status.FAIL);
		}
		Utility_Functions.xWaitForElementPresent(driver, totalSizeNewOpp, 5);
		Utility_Functions.xSendKeys(driver, totalSizeNewOpp, dataTable.getData("General_Data", "InstallmentAmount"));
		Utility_Functions.xWaitForElementPresent(driver, saveOpportunitySplitUAT, 4);
		Utility_Functions.xClick(driver, saveOpportunitySplitUAT, true);
		Utility_Functions.timeWait(2);
		Utility_Functions.xWaitForElementPresent(driver, editOpportunity, 4);
		Utility_Functions.xClick(driver, editOpportunity, true);
		totalSizeEditOpp.clear();
		Utility_Functions.xWaitForElementPresent(driver, salesStageEditOpp, 4);
		Utility_Functions.xClick(driver, salesStageEditOpp, true);
		Utility_Functions.xWaitForElementPresent(driver, salesStageEditOppValue, 4);
		Utility_Functions.xClick(driver, salesStageEditOppValue, true);
		Utility_Functions.xWaitForElementPresent(driver, saveEditOpp, 4);
		Utility_Functions.xClick(driver, saveEditOpp, true);
		Utility_Functions.timeWait(2);
	}

	/**
	 * Validating the Discretionary Fee check box is unchecked by default in the
	 * New Opportunity creation page
	 * 
	 * @author Ramya
	 * 
	 *
	 */
	public void opportunityDiscretionayFeeUnChecked() {
		selectNewOpportunity();
		Utility_Functions.xSwitchtoFrame(driver, viewAllFieldsButton);
		Utility_Functions.xWaitForElementPresent(driver, viewAllFieldsButton, 5);
		Utility_Functions.xClick(driver, viewAllFieldsButton, true);
		Utility_Functions.timeWait(2);
		Utility_Functions.xScrollWindow(driver);
		Utility_Functions.timeWait(2);
		Utility_Functions.xScrollWindowTop(driver);
		Utility_Functions.timeWait(2);
		Utility_Functions.xWaitForElementPresent(driver, discretionaryFeeCheckBox, 3);
		if (!discretionaryFeeCheckBox.isSelected()) {
			System.out.println("The Discretionary check box is unchecked by default");
			report.updateTestLog("Verify Discretionary Fee Unchecked",
					"The opportunity Quick Create Page has the Discretionary Fee check box unchecked by default",
					Status.PASS);
		}

	}

	/**
	 * Validating the Net Fee Field Mandatory in the New Opportunity creation page
	 * 
	 * @author Ramya
	 * 
	 *
	 */
	public void opportunityNetFeeFieldMandatory() {
		selectNewOpportunity();
		if ((dataTable.getData("General_Data", "TC_ID").contains("AMER"))
				|| (dataTable.getData("General_Data", "TC_ID").contains("APAC"))) {
			Utility_Functions.xSwitchtoFrame(driver, continueButton);
			Utility_Functions.xWaitForElementPresent(driver, continueButton, 5);
			Utility_Functions.xClick(driver, continueButton, true);
			driver.switchTo().defaultContent();
			Utility_Functions.timeWait(2);
		}
		Utility_Functions.xSwitchtoFrame(driver, viewAllFieldsButton);
		Utility_Functions.xWaitForElementPresent(driver, viewAllFieldsButton, 5);
		Utility_Functions.xClick(driver, viewAllFieldsButton, true);
		Utility_Functions.xWaitForElementPresent(driver, opportunityName, 3);
		Utility_Functions.xSendKeys(driver, opportunityName,
				"Test Automation Opportunity_" + Utility_Functions.xGenerateAlphaNumericString());
		String query = "SELECT Id, Name, EMEA_Searchable__c FROM Account where EMEA_Searchable__c = true limit 1 offset 9";
		String sAccountName = searchTextSOQL.fetchRecordFieldValue("Name", query);
		Utility_Functions.xSendKeys(driver, accountName, sAccountName);
		accountName.sendKeys(Keys.ARROW_DOWN);
		Utility_Functions.timeWait(2);
		accountName.sendKeys(Keys.ENTER);
		Utility_Functions.timeWait(2);
		if ((dataTable.getData("General_Data", "TC_ID").contains("OBAMER"))
				|| (dataTable.getData("General_Data", "TC_ID").contains("APAC"))) {
			Utility_Functions.xWaitForElementPresent(driver, assignmentTypeOpp, 4);
			Utility_Functions.xClick(driver, assignmentTypeOpp, true);
			Utility_Functions.xWaitForElementPresent(driver, assignmentTypeValueNewOpp, 4);
			Utility_Functions.xClick(driver, assignmentTypeValueNewOpp, true);
			Utility_Functions.timeWait(2);
		}
		Utility_Functions.xWaitForElementPresent(driver, salesStageEMEANewOpportunity, 4);
		Utility_Functions.xClick(driver, salesStageEMEANewOpportunity, true);
		if (dataTable.getData("General_Data", "TC_ID").contains("EMEA")) {
			Utility_Functions.xWaitForElementPresent(driver, salesStageEMEANewOpportunityValue, 4);
			Utility_Functions.xClick(driver, salesStageEMEANewOpportunityValue, true);
		} else {
			Utility_Functions.xWaitForElementPresent(driver, salesStageNewOpportunityValue, 4);
			Utility_Functions.xClick(driver, salesStageNewOpportunityValue, true);
		}
		if ((dataTable.getData("General_Data", "TC_ID").contains("OBAMER"))
				|| (dataTable.getData("General_Data", "TC_ID").contains("APAC"))) {
			Utility_Functions.xWaitForElementPresent(driver, estimatedGrossFee, 5);
			Utility_Functions.xSendKeys(driver, estimatedGrossFee,
					dataTable.getData("General_Data", "InstallmentAmount"));
		}
		if (dataTable.getData("General_Data", "TC_ID").contains("EMEA")) {
			Utility_Functions.xWaitForElementPresent(driver, estimatedGrossFeeNewOpportunity, 3);
			Utility_Functions.xSendKeys(driver, estimatedGrossFeeNewOpportunity,
					dataTable.getData("General_Data", "InstallmentAmount"));
		} 
		System.out.println(Calendar.getInstance());
		DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
		Date date = new Date();
		Utility_Functions.xWaitForElementPresent(driver, closeDateNewOpportunity, 3);
		Utility_Functions.xSendKeys(driver, closeDateNewOpportunity, dateFormat.format(date).toString());
		Utility_Functions.timeWait(2);
		if (dataTable.getData("General_Data", "TC_ID").contains("AMER")) {
			Utility_Functions.xWaitForElementPresent(driver, totalSizeOpportunityQuickCreate, 4);
			Utility_Functions.xSendKeys(driver, totalSizeOpportunityQuickCreate,
					dataTable.getData("General_Data", "InstallmentAmount"));
			Utility_Functions.xWaitForElementPresent(driver, preferedPropertyType, 4);
			Utility_Functions.xClick(driver, preferedPropertyType, true);
			Utility_Functions.xWaitForElementPresent(driver, preferedPropertyTypeValue, 4);
			Utility_Functions.xClick(driver, preferedPropertyTypeValue, true);
		}
		if (dataTable.getData("General_Data", "TC_ID").contains("APAC")) {
			closeDateNewOpportunity.sendKeys(Keys.TAB);
			Utility_Functions.xWaitForElementPresent(driver, leadSource, 4);
			Utility_Functions.xClick(driver, leadSource, true);
			Utility_Functions.xWaitForElementPresent(driver, leadSourceValueNewOpportunity, 4);
			Utility_Functions.xClick(driver, leadSourceValueNewOpportunity, true);
		}

		Utility_Functions.xWaitForElementPresent(driver, saveOpportunitySplitUAT, 4);
		Utility_Functions.xClick(driver, saveOpportunitySplitUAT, true);
		Utility_Functions.timeWait(2);
		if (details.isDisplayed()) {

			report.updateTestLog("Verify Opportunity Quick Create Mandatory Fields",
					"The opportunity is saved with all the mandatory fields", Status.PASS);
		} else {
			report.updateTestLog("Verify Opportunity Quick Create Mandatory Fields",
					"The opportunity is not saved with all the mandatory fields", Status.FAIL);
		}
		Utility_Functions.xWaitForElementPresent(driver, opportunityEdit, 4);
		Utility_Functions.xClick(driver, opportunityEdit, true);
		driver.switchTo().defaultContent();
		Utility_Functions.timeWait(2);
		Utility_Functions.xScrollWindow(driver);
		Utility_Functions.timeWait(2);
		Utility_Functions.xScrollWindowTop(driver);
		Utility_Functions.timeWait(2);

		if (dataTable.getData("General_Data", "TC_ID").contains("OBAMER")) {

			Utility_Functions.xWaitForElementPresent(driver, salesStageEditOpp, 4);
			Utility_Functions.xClick(driver, salesStageEditOpp, true);
			Utility_Functions.xWaitForElementPresent(driver, salesStageEditOpportunityValue, 4);
			Utility_Functions.xClick(driver, salesStageEditOpportunityValue, true);
			System.out.println(Calendar.getInstance());
			DateFormat dateFormat1 = new SimpleDateFormat("MM/dd/yyyy");
			Date date1 = new Date();
			Utility_Functions.xWaitForElementPresent(driver, leaseFromEditOpportunity, 4);
			Utility_Functions.xSendKeys(driver, leaseFromEditOpportunity, dateFormat1.format(date1).toString());
			System.out.println(Calendar.getInstance());
			DateFormat dateFormat2 = new SimpleDateFormat("MM/dd/yyyy");
			Date date2 = new Date();
			Utility_Functions.xWaitForElementPresent(driver, leaseToEditOpportunity, 4);
			Utility_Functions.xSendKeys(driver, leaseToEditOpportunity, dateFormat2.format(date2).toString());
			Utility_Functions.xWaitForElementPresent(driver, leaseTermEditOpportunity, 4);
			Utility_Functions.xSendKeys(driver, leaseTermEditOpportunity, "1");
			Utility_Functions.xWaitForElementPresent(driver, leaseRent, 4);
			Utility_Functions.xSendKeys(driver, leaseRent, dataTable.getData("General_Data", "InstallmentAmount"));
			Utility_Functions.xWaitForElementPresent(driver, leaseRentBasis, 4);
			Utility_Functions.xClick(driver, leaseRentBasis, true);
			Utility_Functions.xWaitForElementPresent(driver, leaseRentBasisValue, 4);
			Utility_Functions.xClick(driver, leaseRentBasisValue, true);
			Utility_Functions.xWaitForElementPresent(driver, cbreRole, 4);
			Utility_Functions.xClick(driver, cbreRole, true);
			Utility_Functions.xWaitForElementPresent(driver, cbreRoleValue, 4);
			Utility_Functions.xClick(driver, cbreRoleValue, true);
			Utility_Functions.xWaitForElementPresent(driver, leaseRentType, 4);
			Utility_Functions.xClick(driver, leaseRentType, true);
			Utility_Functions.xWaitForElementPresent(driver, leaseRentTypeValue, 4);
			Utility_Functions.xClick(driver, leaseRentTypeValue, true);
		} else if (dataTable.getData("General_Data", "TC_ID").contains("OBAPAC")) {

			Utility_Functions.xWaitForElementPresent(driver, salesStageEditOpp, 4);
			Utility_Functions.xClick(driver, salesStageEditOpp, true);
			Utility_Functions.xWaitForElementPresent(driver, salesStageEditOpportunityValue, 4);
			Utility_Functions.xClick(driver, salesStageEditOpportunityValue, true);
			System.out.println(Calendar.getInstance());
			DateFormat dateFormat1 = new SimpleDateFormat("MM/dd/yyyy");
			Date date1 = new Date();
			Utility_Functions.xWaitForElementPresent(driver, leaseFromEditOpportunity, 4);
			Utility_Functions.xSendKeys(driver, leaseFromEditOpportunity, dateFormat1.format(date1).toString());
			System.out.println(Calendar.getInstance());
			DateFormat dateFormat2 = new SimpleDateFormat("MM/dd/yyyy");
			Date date2 = new Date();
			Utility_Functions.xWaitForElementPresent(driver, leaseToEditOpportunity, 4);
			Utility_Functions.xSendKeys(driver, leaseToEditOpportunity, dateFormat2.format(date2).toString());
			Utility_Functions.xWaitForElementPresent(driver, leaseTermEditOpportunity, 4);
			Utility_Functions.xSendKeys(driver, leaseTermEditOpportunity, "1");
			Utility_Functions.xWaitForElementPresent(driver, leaseRent, 4);
			Utility_Functions.xSendKeys(driver, leaseRent, dataTable.getData("General_Data", "InstallmentAmount"));
			Utility_Functions.xWaitForElementPresent(driver, leaseRentBasis, 4);
			Utility_Functions.xClick(driver, leaseRentBasis, true);
			Utility_Functions.xWaitForElementPresent(driver, leaseRentBasisValue, 4);
			Utility_Functions.xClick(driver, leaseRentBasisValue, true);
			Utility_Functions.xWaitForElementPresent(driver, cbreRole, 4);
			Utility_Functions.xClick(driver, cbreRole, true);
			Utility_Functions.xWaitForElementPresent(driver, cbreRoleValue, 4);
			Utility_Functions.xClick(driver, cbreRoleValue, true);
			Utility_Functions.xWaitForElementPresent(driver, remarks, 4);
			Utility_Functions.xSendKeys(driver, remarks, "This is Test");

		} else if (dataTable.getData("General_Data", "TC_ID").contains("OBEMEA")) {
			Utility_Functions.xWaitForElementPresent(driver, cbreMarketGroupEMEA, 4);
			Utility_Functions.xClick(driver, cbreMarketGroupEMEA, true);
			Utility_Functions.xWaitForElementPresent(driver, cbreMarketGroupEMEAValue, 4);
			Utility_Functions.xClick(driver, cbreMarketGroupEMEAValue, true);
			Utility_Functions.xWaitForElementPresent(driver, netFeeOpportunityEdit, 4);
			Utility_Functions.xSendKeys(driver, netFeeOpportunityEdit,
					dataTable.getData("General_Data", "InstallmentAmount"));
			Utility_Functions.xWaitForElementPresent(driver, addressLine1, 2);
			Utility_Functions.xSendKeys(driver, addressLine1, dataTable.getData("General_Data", "Street"));
			Utility_Functions.xWaitForElementPresent(driver, city, 2);
			Utility_Functions.xSendKeys(driver, addressLine2, dataTable.getData("General_Data", "City"));
			Utility_Functions.xWaitForElementPresent(driver, postCode, 2);
			Utility_Functions.xSendKeys(driver, postCode, dataTable.getData("General_Data", "Zipcode"));
			Utility_Functions.xWaitForElementPresent(driver, emeaConversionType, 4);
			Utility_Functions.xClick(driver, emeaConversionType, true);
			Utility_Functions.xWaitForElementPresent(driver, emeaConversionTypeValue, 4);
			System.out.println(Calendar.getInstance());
			DateFormat dateFormat5 = new SimpleDateFormat("MM/dd/yyyy");
			Date date5 = new Date();
			Utility_Functions.xWaitForElementPresent(driver, pitchDate, 4);
			Utility_Functions.xSendKeys(driver, pitchDate, dateFormat5.format(date5).toString());
			Utility_Functions.xClick(driver, emeaConversionTypeValue, true);
			Utility_Functions.xWaitForElementPresent(driver, salesStageEditOpp, 4);
			Utility_Functions.xClick(driver, salesStageEditOpp, true);
			Utility_Functions.xWaitForElementPresent(driver, salesStageEditOpportunityValue, 4);
			Utility_Functions.xClick(driver, salesStageEditOpportunityValue, true);
			System.out.println(Calendar.getInstance());
			DateFormat dateFormat1 = new SimpleDateFormat("MM/dd/yyyy");
			Date date1 = new Date();
			Utility_Functions.xWaitForElementPresent(driver, leaseFromEditOpportunity, 4);
			Utility_Functions.xSendKeys(driver, leaseFromEditOpportunity, dateFormat1.format(date1).toString());
			System.out.println(Calendar.getInstance());
			DateFormat dateFormat2 = new SimpleDateFormat("MM/dd/yyyy");
			Date date2 = new Date();
			Utility_Functions.xWaitForElementPresent(driver, leaseToEditOpportunity, 4);
			Utility_Functions.xSendKeys(driver, leaseToEditOpportunity, dateFormat2.format(date2).toString());
			Utility_Functions.xWaitForElementPresent(driver, otherIncentives, 4);
			Utility_Functions.xSendKeys(driver, otherIncentives, "N/A");
			Utility_Functions.xWaitForElementPresent(driver, rentPerAnnum, 4);
			Utility_Functions.xSendKeys(driver, rentPerAnnum, dataTable.getData("General_Data", "InstallmentAmount"));
			Utility_Functions.xWaitForElementPresent(driver, monthsRentFree, 4);
			Utility_Functions.xSendKeys(driver, monthsRentFree, "0");
			System.out.println(Calendar.getInstance());
			DateFormat dateFormat3 = new SimpleDateFormat("MM/dd/yyyy");
			Date date3 = new Date();
			Utility_Functions.xWaitForElementPresent(driver, rentReviewDate, 4);
			Utility_Functions.xSendKeys(driver, rentReviewDate, dateFormat3.format(date3).toString());
			System.out.println(Calendar.getInstance());
			DateFormat dateFormat4 = new SimpleDateFormat("MM/dd/yyyy");
			Date date4 = new Date();
			Utility_Functions.xWaitForElementPresent(driver, breakDate, 4);
			Utility_Functions.xSendKeys(driver, breakDate, dateFormat4.format(date4).toString());

		}
		Utility_Functions.xWaitForElementPresent(driver, saveEditOpp, 4);
		Utility_Functions.xClick(driver, saveEditOpp, true);
		Utility_Functions.timeWait(2);
		if (details.isDisplayed()) {

			report.updateTestLog("Verify Opportunity Quick Create Mandatory Fields",
					"The opportunity is saved with all the mandatory fields", Status.PASS);
		} else {
			report.updateTestLog("Verify Opportunity Quick Create Mandatory Fields",
					"The opportunity is not saved with all the mandatory fields", Status.FAIL);
		}

	}

	/**
	 * Validating the Opportunities create new installment
	 * 
	 * @author Ramya
	 *
	 */
	static ArrayList<String> NewInstallmentPageFieldsList = new ArrayList<String>();

	public void newInstallmentPageFields() {

		NewInstallmentPageFieldsList.add("Installment Number");
		NewInstallmentPageFieldsList.add("Installment Probability (%)");
		NewInstallmentPageFieldsList.add("Installment Amount");
		NewInstallmentPageFieldsList.add("Installment Date");
		NewInstallmentPageFieldsList.add("Comments");
		NewInstallmentPageFieldsList.add("Date Paid");
		NewInstallmentPageFieldsList.add("Paying Account");

		System.out.println("The labels for the New Installment Page are " + NewInstallmentPageFieldsList);

	}

	public void validateCreationOfNewInstallment() {
		sf_UtilityFunctions.oneAppNavigationTab("Opportunity");
		sf_UtilityFunctions.selectExistingObjectRecord("Opportunity Name");
		Utility_Functions.xWaitForElementPresent(driver, showMoreActions, 3);
		Utility_Functions.xClick(driver, showMoreActions, true);
		Utility_Functions.xWaitForElementPresent(driver, newInstallment, 3);
		Utility_Functions.xClick(driver, newInstallment, true);
		List<WebElement> newInstallmentPageLabels = driver
				.findElements(By.xpath("//label[contains(@class,'inputLabel')]/span"));
		int count = 0, i = 0;
		String fieldsArray[] = new String[newInstallmentPageLabels.size()];
		System.out.println(newInstallmentPageLabels.size());
		try {
			newInstallmentPageFields();
			for (WebElement element : newInstallmentPageLabels) {
				System.out.println(element.getText());
				fieldsArray[i] = element.getText();
				if (fieldsArray[i].contains(NewInstallmentPageFieldsList.get(i))) {
					report.updateTestLog("Verify Opportunity Create Installment",
							"New Installment Page is having the " + fieldsArray[i] + " labels ", Status.PASS);
					count++;
				}
				i++;
			}
			System.out.println(count);
			if (count != 7) {
				report.updateTestLog("Verify Opportunity Create Installment",
						"All labels are not present in the New Installment Page", Status.FAIL);
			} else {

				report.updateTestLog("Verify Opportunity Create Installment",
						"All labels are present in the New Installment Page", Status.PASS);
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		Utility_Functions.xWaitForElementPresent(driver, installmentNumber, 3);
		Utility_Functions.xSendKeys(driver, installmentNumber, dataTable.getData("General_Data", "InstallmentAmount"));
		Utility_Functions.xWaitForElementPresent(driver, installmentAmountNewOpportunityInstallment, 3);
		Utility_Functions.xSendKeys(driver, installmentAmountNewOpportunityInstallment,
				dataTable.getData("General_Data", "InstallmentAmount"));
		System.out.println(Calendar.getInstance());
		DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
		Date date = new Date();
		Utility_Functions.xWaitForElementPresent(driver, installmentDate, 3);
		Utility_Functions.xSendKeys(driver, installmentDate, dateFormat.format(date).toString());
		Utility_Functions.xWaitForElementPresent(driver, commentsField, 3);
		Utility_Functions.xSendKeys(driver, commentsField, "This is Opportunity Installment");
		Utility_Functions.xWaitForElementPresent(driver, newInstallmentSave, 3);
		Utility_Functions.xClick(driver, newInstallmentSave, true);
		Utility_Functions.timeWait(2);
		if (details.isDisplayed()) {

			report.updateTestLog("Verify Opportunity Create Installment", "The new installment is saved", Status.PASS);
		} else {
			report.updateTestLog("Verify Opportunity Create Installment", "The new installment is not saved",
					Status.FAIL);
		}

	}
	/**
	 * Validating the Clone and Edit buttons in Opportunity VF Page
	 * 
	 * @author Vishnuvardhan
	 *
	 */

	public void cloneAndEditButtonsOpportunity() {
		//Utility_Functions.xWaitForElementPresent(driver, menu_Opportunities, 3);
		sf_UtilityFunctions.oneAppNavigationTab("Opportunities");
		opportunityEligibility();
		Utility_Functions.timeWait(2);
		Utility_Functions.xWaitForElementPresent(driver, edit, 3);
		Utility_Functions.xClick(driver, edit, true);
		report.updateTestLog("Verify Opportunity Edit/Clone", "Edit button is present on Opportunity", Status.PASS);
		if (dataTable.getData("General_Data", "TC_ID").contains("ABAMER")) {
			Utility_Functions.timeWait(2);
			Utility_Functions.xScrollWindow(driver);
			Utility_Functions.timeWait(2);
			Utility_Functions.xScrollWindowTop(driver);
			Utility_Functions.xClick(driver,assignmentTypeOppGWS , true);
		    sf_UtilityFunctions.selectValueFromDropdownList(dropDownList, "Consulting");
			report.updateTestLog("Verify Opportunity Edit/Clone", "Oportunity Assignment Type is changed to Consulting",
					Status.PASS);
			/*Utility_Functions.timeWait(1);
			Random random = new Random();
			int value = random.nextInt(999);
			Utility_Functions.xWaitForElementPresent(driver, totalSize, 3);
			if (totalSize.getText().equals("")) {
				Utility_Functions.xSendKeys(driver, totalSize, Integer.toString(value));
			}*/
			Utility_Functions.xWaitForElementPresent(driver, preferredPropType, 3);
			Utility_Functions.xClick(driver, preferredPropType, true);
			sf_UtilityFunctions.selectValueFromDropdownList(dropDownList, "Office");
			Utility_Functions.xWaitForElementPresent(driver, saveOpp, 4);
			Utility_Functions.xClick(driver, saveOpp, true);
			Utility_Functions.timeWait(2);
			report.updateTestLog("Verify Opportunity Edit/Clone", "Opportunity edited and saved successfully",
					Status.PASS);
			Utility_Functions.timeWait(4);
			Utility_Functions.xWaitForElementPresent(driver, clone, 5);
			Utility_Functions.xSwitchtoFrame(driver, clone);
			Utility_Functions.timeWait(2);
			Utility_Functions.xWaitForElementPresent(driver, clone, 3);
			Utility_Functions.xClick(driver, clone, true);
			report.updateTestLog("Verify Opportunity Edit/Clone", "Clone button is present on Opportunity",
					Status.PASS);
			Utility_Functions.timeWait(2);
			Utility_Functions.xWaitForElementPresent(driver, save, 3);
			Utility_Functions.xClick(driver, save, true);
			report.updateTestLog("Verify Opportunity Edit/Clone", "Opportunity is cloned successfully", Status.PASS);
		} else if ((dataTable.getData("General_Data", "TC_ID").contains("CMAMER"))
				|| (dataTable.getData("General_Data", "TC_ID").contains("CMEMEA"))
				|| (dataTable.getData("General_Data", "TC_ID").contains("GWSAMERManager"))
				|| (dataTable.getData("General_Data", "TC_ID").startsWith("TC_SF_ASAMERManager"))
				|| (dataTable.getData("General_Data", "TC_ID").startsWith("TC_SF_VASAMERManager"))
				|| (dataTable.getData("General_Data", "TC_ID").contains("GWSAMERBroker"))) {
			Utility_Functions.timeWait(2);
			if(!dataTable.getData("General_Data", "TC_ID").startsWith("TC_SF_ASAMERManager")) {
				Utility_Functions.xScrollWindowToElement(driver, estimatedGrossFeeCommissionValue);
				Utility_Functions.xWaitForElementPresent(driver, estimatedGrossFeeCommissionValue, 3);
				Utility_Functions.xClick(driver, estimatedGrossFeeCommissionValue, true);
				if (estimatedGrossFeeCommissionValue.getText().equals("10,000.00")) {
					Utility_Functions.xSendKeys(driver, estimatedGrossFeeCommissionValue, "15,000.00");
				} else {
					Utility_Functions.xSendKeys(driver, estimatedGrossFeeCommissionValue, "10,000.00");
				}
			}						
			Utility_Functions.xWaitForElementPresent(driver, save, 3);
			Utility_Functions.xClick(driver, save, true);
			Utility_Functions.timeWait(1);
			Utility_Functions.xWaitForElementPresent(driver, related, 3);
			report.updateTestLog("Verify Opportunity Edit/Clone", "Opportunity edited and saved successfully",
					Status.PASS);
			if (dataTable.getData("General_Data", "TC_ID").contains("GWSAMERBroker")) {
				Utility_Functions.timeWait(2);
				Utility_Functions.xWaitForElementClickable(driver, clone, 3);
				Utility_Functions.xClick(driver, clone, true);
				report.updateTestLog("Verify Opportunity Edit/Clone", "Clone button is present on Opportunity",
						Status.PASS);
				Utility_Functions.xWaitForElementPresent(driver, offersNextButton, 3);
				Utility_Functions.xClick(driver, offersNextButton, true);
				Utility_Functions.xWaitForElementPresent(driver, offersNextButton, 3);
				Utility_Functions.xClick(driver, save, true);
				report.updateTestLog("Verify Opportunity Edit/Clone", "Opportunity is cloned successfully",
						Status.PASS);
			}
		} else if (dataTable.getData("General_Data", "TC_ID").contains("VASAMERManager")) {
			Utility_Functions.timeWait(2);
			Utility_Functions.xScrollWindowToElement(driver, managementAnnualRevenue);
			Utility_Functions.xWaitForElementPresent(driver, managementAnnualRevenue, 3);
			Utility_Functions.xClick(driver, managementAnnualRevenue, true);
			Utility_Functions.xSendKeys(driver, managementAnnualRevenue, "2,00,000.00");
			Utility_Functions.xWaitForElementPresent(driver, save, 3);
			Utility_Functions.xClick(driver, save, true);
			Utility_Functions.timeWait(1);
			Utility_Functions.xWaitForElementPresent(driver, related, 3);
			report.updateTestLog("Verify Opportunity Edit/Clone", "Opportunity edited and saved successfully",
					Status.PASS);
		} else if (dataTable.getData("General_Data", "TC_ID").startsWith("TC_SF_VASAPACBroker")) {
			Utility_Functions.timeWait(2);
			
			Utility_Functions.xScrollWindow(driver);
	        Utility_Functions.xClick(driver,assetTypeVASAPAC , true);
			sf_UtilityFunctions.selectValueFromDropdownList(dropDownList, "Education");
			Utility_Functions.xWaitForElementPresent(driver, areaVASAPAC,3);
			Utility_Functions.xSendKeys(driver, areaVASAPAC, "25000");
			Utility_Functions.xClick(driver,unitOfMeasureVASAPAC, true);
	        sf_UtilityFunctions.selectValueFromDropdownList(dropDownList, "Acres");
	        Utility_Functions.xClick(driver,assignmentTypeVASAPAC , true);
			sf_UtilityFunctions.selectValueFromDropdownList(dropDownList, "Design Services");
			Utility_Functions.xClick(driver,constructionTypeVASAPAC , true);
			sf_UtilityFunctions.selectValueFromDropdownList(dropDownList, "Fitout");
			Utility_Functions.xWaitForElementPresent(driver, siteAreaVASAPAC,3);
			Utility_Functions.xSendKeys(driver, siteAreaVASAPAC, "25000");
			 Utility_Functions.xClick(driver,areaUOMVASAPAC , true);
			sf_UtilityFunctions.selectValueFromDropdownList(dropDownList, "Acres");
	        Utility_Functions.xWaitForElementPresent(driver, consultancyFeeVASAPAC, 3);
			Utility_Functions.xSendKeys(driver, consultancyFeeVASAPAC,"4567");
			Utility_Functions.xWaitForElementPresent(driver, projectValueVASAPAC, 3);
			Utility_Functions.xSendKeys(driver, projectValueVASAPAC,"53,60,000");
			
			System.out.println(Calendar.getInstance());
			DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
			Date date = new Date();
			Utility_Functions.xSendKeys(driver, identificationDateVASAPAC, dateFormat.format(date).toString());
			Utility_Functions.xSendKeys(driver, identificationDateVASAPAC, Keys.TAB);
			
			Utility_Functions.xSendKeys(driver, submissionDateVASAPAC, dateFormat.format(date).toString());
			Utility_Functions.xSendKeys(driver, submissionDateVASAPAC, Keys.TAB);
			
			Utility_Functions.xWaitForElementPresent(driver, save, 3);
			Utility_Functions.xClick(driver, save, true);

			Utility_Functions.xWaitForElementPresent(driver, related, 3);
			report.updateTestLog("Verify Opportunity Edit/Clone", "Opportunity edited and saved successfully",
					Status.PASS);
		}
	}

	/**
	 * Validating the Related lists of an opportunity in the Opportunity Landing
	 * page
	 * 
	 * @author Vishnuvardhan
	 *
	 */
	static ArrayList<String> opportunityRelatedHeaderSection = new ArrayList<String>();

	public void opportunityRelatedHeaderSection() {

		opportunityRelatedHeaderSection.add("Property");
		opportunityRelatedHeaderSection.add("Contact Roles");
		opportunityRelatedHeaderSection.add("Notes");
		opportunityRelatedHeaderSection.add("Files");

		System.out.println("Opportunity Related Header Section are: " + opportunityRelatedHeaderSection);
	}

	/**
	 * Validating the Phase and Probability field when Sales stage is selected
	 * 
	 * @author Vishnuvardhan
	 *
	 */
	public void phaseAndProbabilityValidation() {
		selectNewOpportunity();
		Utility_Functions.timeWait(3);
		Utility_Functions.xSwitchtoFrame(driver, continueButton);
		Utility_Functions.xWaitForElementPresent(driver, continueButton, 3);
		Utility_Functions.xClick(driver, opportunityRecordType, true);
		Utility_Functions.xSelectDropdownByName(opportunityRecordType, "APAC Advisory/Consulting Services and GWS");
		/*Utility_Functions.xWaitForElementPresent(driver, opportunityRecordTypeGlobalWorkplaceSolutions, 2);
		Utility_Functions.xClick(driver, opportunityRecordTypeGlobalWorkplaceSolutions, true);*/
		Utility_Functions.xClick(driver, continueButton, true);
		driver.switchTo().defaultContent();
		Utility_Functions.timeWait(2);
		String sAccountName = searchTextSOQL.fetchRecord("Account", "Name");
		Utility_Functions.xSendKeys(driver, accountNameSearchBox, sAccountName);
		sf_UtilityFunctions.selectObjectFromLookUpList();
		/*accountNameSearchBox.sendKeys(Keys.ARROW_DOWN);
		Utility_Functions.timeWait(2);
		accountNameSearchBox.sendKeys(Keys.ENTER);	*/	
        Utility_Functions.xScrollWindow(driver);
        Utility_Functions.timeWait(2);
        Utility_Functions.xClick(driver,assignmentTypeOppGWS , true);
        sf_UtilityFunctions.selectValueFromDropdownList(dropDownList, "Consulting");
        System.out.println(Calendar.getInstance());
        DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
        Date date = new Date();
        Utility_Functions.xScrollWindowTop(driver);
        Utility_Functions.timeWait(2);
        Utility_Functions.xClick(driver,leadSourceGWS, true);
        sf_UtilityFunctions.selectValueFromDropdownList(dropDownList, "CBRE Cross Sell");      
        Utility_Functions.xSendKeys(driver, closeDateOppGWS, dateFormat.format(date).toString());
        Utility_Functions.xSendKeys(driver, closeDateOppGWS, Keys.TAB);
        Random random = new Random();
        int value = random.nextInt(999);
        Utility_Functions.xSendKeys(driver, totalSizeOppGWS, Integer.toString(value));
        Utility_Functions.xClick(driver,unitofMeasureGWS, true);
        sf_UtilityFunctions.selectValueFromDropdownList(dropDownList, "Acres");

    /*    Utility_Functions.xWaitForElementPresent(driver, estimatedGrossFeeGWS, 3);
        Utility_Functions.xSendKeys(driver, estimatedGrossFeeGWS, dataTable.getData("General_Data", "InstallmentAmount")); */

		try {
			Utility_Functions.xSelectDropdownByIndex(preferredPropertyTypeOpp, 1);
		} catch (Exception e) {
			e.printStackTrace();
		}
        Utility_Functions.xClick(driver,salesStageGWS, true);
		if (dataTable.getData("General_Data", "TC_ID").contains("GWSAPACBrokerStage01")) {
            sf_UtilityFunctions.selectValueFromDropdownList(dropDownList, "01-Intro Meeting/Discovery");
		} else if (dataTable.getData("General_Data", "TC_ID").contains("GWSAPACBrokerStage02")) {
            sf_UtilityFunctions.selectValueFromDropdownList(dropDownList, "02-Relationship Building");
		} else if (dataTable.getData("General_Data", "TC_ID").contains("GWSAPACBrokerStage03")) {
            sf_UtilityFunctions.selectValueFromDropdownList(dropDownList, "03-Opportunity Identification");
		} else if (dataTable.getData("General_Data", "TC_ID").contains("GWSAPACBrokerStage04")) {
            sf_UtilityFunctions.selectValueFromDropdownList(dropDownList, "04-Solution/Submit RFI");
		} else if (dataTable.getData("General_Data", "TC_ID").contains("GWSAPACBrokerStage05")) {
            sf_UtilityFunctions.selectValueFromDropdownList(dropDownList, "05-Solution/Submit RFP");
		} else if (dataTable.getData("General_Data", "TC_ID").contains("GWSAPACBrokerStage06")) {
            sf_UtilityFunctions.selectValueFromDropdownList(dropDownList, "06-Solution/Submit Pre-emptive Bid");
		} else if (dataTable.getData("General_Data", "TC_ID").contains("GWSAPACBrokerStage07")) {
            sf_UtilityFunctions.selectValueFromDropdownList(dropDownList, "07-Presentation/Pitching");
		} else if (dataTable.getData("General_Data", "TC_ID").contains("GWSAPACBrokerStage08")) {
            sf_UtilityFunctions.selectValueFromDropdownList(dropDownList, "08-Red Zone/Awarded");
		} else if (dataTable.getData("General_Data", "TC_ID").contains("GWSAPACBrokerStage09")) {
            sf_UtilityFunctions.selectValueFromDropdownList(dropDownList, "09-Closed - Paid Full");
		} else if (dataTable.getData("General_Data", "TC_ID").contains("GWSAPACBrokerStage10")) {
            sf_UtilityFunctions.selectValueFromDropdownList(dropDownList, "10-Loss");
		} else if (dataTable.getData("General_Data", "TC_ID").contains("GWSAPACBrokerStage11")) {
            sf_UtilityFunctions.selectValueFromDropdownList(dropDownList, "11-Declined");
		} else if (dataTable.getData("General_Data", "TC_ID").contains("GWSAPACBrokerStage12")) {
            sf_UtilityFunctions.selectValueFromDropdownList(dropDownList, "12-Dead");
		}
        Utility_Functions.xSendKeys(driver, salesStageGWS, Keys.TAB);
       /* if ((dataTable.getData("General_Data", "TC_ID").contains("GWSAPACBrokerStage09"))
				|| (dataTable.getData("General_Data", "TC_ID").contains("GWSAPACBrokerStage10"))) {
			Utility_Functions.xWaitForElementPresent(driver, viewAllFieldsButton, 5);
			Utility_Functions.xScrollWindow(driver);
			Utility_Functions.xClick(driver, viewAllFieldsButton, true);
			Utility_Functions.timeWait(1);
			Utility_Functions.xScrollWindowTop(driver);
		}*/
		if (dataTable.getData("General_Data", "TC_ID").contains("GWSAPACBrokerStage10")) {
			Utility_Functions.xWaitForElementPresent(driver, reasonForLossOppGWS, 3);
			Utility_Functions.xClick(driver, reasonForLossOppGWS, true);
            sf_UtilityFunctions.selectValueFromDropdownList(dropDownList, "Dead, Business Conducted In-House");
            Utility_Functions.xWaitForElementPresent(driver, reasonLostCommentsGWS, 3);
			Utility_Functions.xSendKeys(driver, reasonLostCommentsGWS, "Validating the Phase and Probaility by Selecting the Sales Stage");
			Utility_Functions.timeWait(1);
		}
		Utility_Functions.xClick(driver, saveOpportunityGWS, true);
		Utility_Functions.timeWait(6);
		String sOpportunityName = null;
		try {
			Utility_Functions.xWaitForElementPresent(driver, related, 8);
			if (related.isDisplayed()) {
				/*String OpportunityQuery = "Select Name from opportunity where Name like  "+ '%' + "-" + value + "-" + "Acres" + "'";
				String OpportunityName = searchTextSOQL.fetchRecordFieldValue("Name", OpportunityQuery);*/
				sOpportunityName = opportunityHeader.getText();
				report.updateTestLog("Opportunity Created",
						"Opportunity created successfully:::" + sOpportunityName + ":::", Status.PASS);
			} else {
				report.updateTestLog("Opportunity Created", "Opportunity creation failed:::", Status.FAIL);
			}
		} catch (Exception e) {
			report.updateTestLog("Opportunity Related Tab", "System was unable to find the Related tab:::",
					Status.WARNING);
		}

		Utility_Functions.timeWait(2);

/*		String phaseQuery = "Select Phase__c from opportunity where Name like  " + "'" + sAccountName + "-" + '%' + "-"
				+ value + "-" + "Acres" + "'";
		String probabilityQuery = "Select Probability from opportunity where Name like  " + "'" + sAccountName + "-"
				+ '%' + "-" + value + "-" + "Acres" + "'";*/
		String phaseQuery = "Select Phase__c from opportunity where Name = " + "'" + sOpportunityName + "'";
		String probabilityQuery = "Select Probability from opportunity where Name =  " + "'" + sOpportunityName + "'";
		Utility_Functions.timeWait(1);
		String phasePopulated = searchTextSOQL.fetchRecordFieldValue("Phase__c", phaseQuery);
		String probabilityPopulated = searchTextSOQL.fetchRecordFieldValue("Probability", probabilityQuery);

		if (dataTable.getData("General_Data", "TC_ID").contains("GWSAPACBrokerStage01")) {
			if (phasePopulated.equals("Prospecting") && (probabilityPopulated).equals("10.0")) {
				report.updateTestLog("Opportunity Phase and Probability",
						"Phase and Probability populated are as expected:::", Status.PASS);
				report.updateTestLog("Opportunity Phase and Probability",
						"Phase:::" + phasePopulated + ":::Probability:::" + probabilityPopulated, Status.PASS);
			} else {
				report.updateTestLog("Opportunity Phase and Probability",
						"Phase and Probability populated are not as expected:::", Status.FAIL);
			}
		} else if (dataTable.getData("General_Data", "TC_ID").contains("GWSAPACBrokerStage02")) {
			if (phasePopulated.equals("Prospecting") && (probabilityPopulated).equals("15.0")) {
				report.updateTestLog("Opportunity Phase and Probability",
						"Phase and Probability populated are as expected:::", Status.PASS);
				report.updateTestLog("Opportunity Phase and Probability",
						"Phase:::" + phasePopulated + ":::Probability:::" + probabilityPopulated, Status.PASS);
			} else {
				report.updateTestLog("Opportunity Phase and Probability",
						"Phase and Probability populated are not as expected:::", Status.FAIL);
			}
		} else if (dataTable.getData("General_Data", "TC_ID").contains("GWSAPACBrokerStage03")) {
			if (phasePopulated.equals("Prospecting") && (probabilityPopulated).equals("20.0")) {
				report.updateTestLog("Opportunity Phase and Probability",
						"Phase and Probability populated are as expected:::", Status.PASS);
				report.updateTestLog("Opportunity Phase and Probability",
						"Phase:::" + phasePopulated + ":::Probability:::" + probabilityPopulated, Status.PASS);
			} else {
				report.updateTestLog("Opportunity Phase and Probability",
						"Phase and Probability populated are not as expected:::", Status.FAIL);
			}
		} else if (dataTable.getData("General_Data", "TC_ID").contains("GWSAPACBrokerStage04")) {
			if (phasePopulated.equals("Converting") && (probabilityPopulated).equals("30.0")) {
				report.updateTestLog("Opportunity Phase and Probability",
						"Phase and Probability populated are as expected:::", Status.PASS);
				report.updateTestLog("Opportunity Phase and Probability",
						"Phase:::" + phasePopulated + ":::Probability:::" + probabilityPopulated, Status.PASS);
			} else {
				report.updateTestLog("Opportunity Phase and Probability",
						"Phase and Probability populated are not as expected:::", Status.FAIL);
			}
		} else if (dataTable.getData("General_Data", "TC_ID").contains("GWSAPACBrokerStage05")) {
			if (phasePopulated.equals("Converting") && (probabilityPopulated).equals("50.0")) {
				report.updateTestLog("Opportunity Phase and Probability",
						"Phase and Probability populated are as expected:::", Status.PASS);
				report.updateTestLog("Opportunity Phase and Probability",
						"Phase:::" + phasePopulated + ":::Probability:::" + probabilityPopulated, Status.PASS);
			} else {
				report.updateTestLog("Opportunity Phase and Probability",
						"Phase and Probability populated are not as expected:::", Status.FAIL);
			}
		} else if (dataTable.getData("General_Data", "TC_ID").contains("GWSAPACBrokerStage06")) {
			if (phasePopulated.equals("Converting") && (probabilityPopulated).equals("50.0")) {
				report.updateTestLog("Opportunity Phase and Probability",
						"Phase and Probability populated are as expected:::", Status.PASS);
				report.updateTestLog("Opportunity Phase and Probability",
						"Phase:::" + phasePopulated + ":::Probability:::" + probabilityPopulated, Status.PASS);
			} else {
				report.updateTestLog("Opportunity Phase and Probability",
						"Phase and Probability populated are not as expected:::", Status.FAIL);
			}
		} else if (dataTable.getData("General_Data", "TC_ID").contains("GWSAPACBrokerStage07")) {
			if (phasePopulated.equals("Converting") && (probabilityPopulated).equals("60.0")) {
				report.updateTestLog("Opportunity Phase and Probability",
						"Phase and Probability populated are as expected:::", Status.PASS);
				report.updateTestLog("Opportunity Phase and Probability",
						"Phase:::" + phasePopulated + ":::Probability:::" + probabilityPopulated, Status.PASS);
			} else {
				report.updateTestLog("Opportunity Phase and Probability",
						"Phase and Probability populated are not as expected:::", Status.FAIL);
			}
		} else if (dataTable.getData("General_Data", "TC_ID").contains("GWSAPACBrokerStage08")) {
			if (phasePopulated.equals("Executing") && (probabilityPopulated).equals("90.0")) {
				report.updateTestLog("Opportunity Phase and Probability",
						"Phase and Probability populated are as expected:::", Status.PASS);
				report.updateTestLog("Opportunity Phase and Probability",
						"Phase:::" + phasePopulated + ":::Probability:::" + probabilityPopulated, Status.PASS);
			} else {
				report.updateTestLog("Opportunity Phase and Probability",
						"Phase and Probability populated are not as expected:::", Status.FAIL);
			}
		} else if (dataTable.getData("General_Data", "TC_ID").contains("GWSAPACBrokerStage09")) {
			if (phasePopulated.equals("Executing") && (probabilityPopulated).equals("90.0")) {
				report.updateTestLog("Opportunity Phase and Probability",
						"Phase and Probability populated are as expected:::", Status.PASS);
				report.updateTestLog("Opportunity Phase and Probability",
						"Phase:::" + phasePopulated + ":::Probability:::"+ probabilityPopulated, Status.PASS);
			} else {
				report.updateTestLog("Opportunity Phase and Probability",
						"Phase and Probability populated are not as expected:::", Status.FAIL);
			}
		} else if ((dataTable.getData("General_Data", "TC_ID").contains("GWSAPACBrokerStage10"))
				|| (dataTable.getData("General_Data", "TC_ID").contains("GWSAPACBrokerStage11"))
				|| (dataTable.getData("General_Data", "TC_ID").contains("GWSAPACBrokerStage12"))) {
			if (phasePopulated.equals("Lost") && (probabilityPopulated).equals("0.0")) {
				report.updateTestLog("Opportunity Phase and Probability",
						"Phase and Probability populated are as expected:::", Status.PASS);
				report.updateTestLog("Opportunity Phase and Probability",
						"Phase:::" + phasePopulated + ":::Probability:::" + probabilityPopulated, Status.PASS);
			} else {
				report.updateTestLog("Opportunity Phase and Probability",
						"Phase and Probability populated are not as expected:::", Status.FAIL);
			}
		}
	}

	

	/**
	 * Validating the Project Enquiries Page Fiels List from the APAC Campaign
	 * Record
	 * 
	 * @author Vishnuvardhan
	 *
	 */

	static ArrayList<String> ProjectEnquiriesPageFields = new ArrayList<String>();

	public void ProjectEnquiriesPageFieldsList() {
		ProjectEnquiriesPageFields.add("Project Enquiry Name");
		ProjectEnquiriesPageFields.add("Enquiry Account");
		ProjectEnquiriesPageFields.add("Enquiry Contact");
		// ProjectEnquiriesPageFields.add("Status");

		System.out.println("ProjectEnquiries Page Fields in APAC are:::" + ProjectEnquiriesPageFields);
	}

	
	public void projectEnquiriesReleatedListsAPAC() {
		OfferPage offerPage = new OfferPage(scriptHelper);
		offerPage.campaignsList();
		Utility_Functions.timeWait(2);
		Utility_Functions.xWaitForElementPresent(driver, related, 3);
		Utility_Functions.xClick(driver, related, true);
		Utility_Functions.xScrollWindow(driver);
		Utility_Functions.timeWait(1);
		Utility_Functions.xScrollWindowTop(driver);
		Utility_Functions.timeWait(1);
		Utility_Functions.xWaitForElementPresent(driver, projectEnquiries, 3);
		Utility_Functions.xClick(driver, projectEnquiries, true);
		Utility_Functions.xWaitForElementPresent(driver, offersNextButton, 3);
		Utility_Functions.xClick(driver, offersNextButton, true);
		ProjectEnquiriesPageFieldsList();
		Utility_Functions.timeWait(2);
		List<WebElement> projectEnquiryPageFieldsList = driver
				.findElements(By.xpath("//label[contains(@class,'form-element__label')]/span[1]"));
		int i1 = 0, j = 0, countLabelList = 0;
		String[] labelTexts = new String[projectEnquiryPageFieldsList.size()];
		while (j < ProjectEnquiriesPageFields.size()) {
			for (WebElement element : projectEnquiryPageFieldsList) {
				labelTexts[i1] = element.getText();
				if (labelTexts[i1].contains(ProjectEnquiriesPageFields.get(j))) {
					System.out.println("Verify Project Creation Page Fields List" + element.getText());
					report.updateTestLog("Verify Project Creation Page Fields List",
							element.getText() + "::::label is present in Project Enquiry Page for APAC", Status.PASS);
					countLabelList++;
				}
				i1++;
			}
			i1 = 0;
			j++;
		}
		System.out.println("Count of labels present in Offer Creation Page are::" + countLabelList);
		if (countLabelList == 3) {
			report.updateTestLog("Verify Project Creation Page Fields List",
					"All the fields are present in Project Creation Page for APAC", Status.PASS);
		} else {
			report.updateTestLog("Verify Project Creation Page Fields List",
					"Not all the fields are present in Project Creation Page for APAC", Status.FAIL);
		}
	}

	/**
	 * Validating the Offers Related List from the APAC Property Record
	 * 
	 * @author Vishnuvardhan
	 *
	 */

	public void selectProperties() {
		try {
			Utility_Functions.xWaitForElementPresent(driver, menu_Properties, 3);
			Utility_Functions.xClick(driver, menu_Properties, true);
		} catch (Exception e) {
			Utility_Functions.xWaitForElementPresent(driver, menu_More, 3);
			Utility_Functions.xClick(driver, menu_More, true);
			try {
				Utility_Functions.xWaitForElementPresent(driver, propertiesRecord, 3);
				Utility_Functions.xClick(driver, propertiesRecord, true);
			} catch (Exception e1) {
				Utility_Functions.xWaitForElementPresent(driver, propertiesEnv, 2);
				Utility_Functions.xClick(driver, propertiesEnv, true);
			}
		}
		List<WebElement> propertyRecordList = driver
				.findElements(By.xpath("//a[@class='slds-truncate outputLookupLink slds-truncate forceOutputLookup']"));
		if (propertyRecordList.isEmpty()) {
			Utility_Functions.xWaitForElementPresent(driver, recentlyViewed, 3);
			Utility_Functions.xClick(driver, recentlyViewed, true);
			Utility_Functions.xWaitForElementPresent(driver, allActiveCampaigns, 3);
			Utility_Functions.xClick(driver, allActiveCampaigns, true);
			Utility_Functions.timeWait(2);
			List<WebElement> propertyRecordListActive = driver.findElements(
					By.xpath("//a[@class='slds-truncate outputLookupLink slds-truncate forceOutputLookup']"));
			if (propertyRecordListActive.isEmpty()) {
				report.updateTestLog("Active Campaigns List", "There are no Active Campaigns present", Status.PASS);
			} else {
				Utility_Functions.xclickRandomElement(propertyRecordListActive);
			}
		}
		Utility_Functions.xclickOnFirstElementfromList(propertyRecordList);

	}

	public void projectEnquiriesPropertiesListsAPAC() {
		selectProperties();
		Utility_Functions.timeWait(2);
		sf_UtilityFunctions.selectTabUIHeaders("Related");
		Utility_Functions.xScrollWindow(driver);
		Utility_Functions.timeWait(1);
		Utility_Functions.xScrollWindowTop(driver);
		Utility_Functions.timeWait(1);
		Utility_Functions.xWaitForElementPresent(driver, projectEnquiries, 3);
		Utility_Functions.xClick(driver, projectEnquiries, true);
		Utility_Functions.xWaitForElementPresent(driver, offersNextButton, 3);
		Utility_Functions.xClick(driver, offersNextButton, true);
		ProjectEnquiriesPageFieldsList();
		Utility_Functions.timeWait(2);
		List<WebElement> projectEnquiryPageFieldsList = driver.findElementsByXPath("//label[contains(@class,'form-element__label')]/span[1]");
		int i1 = 0, j = 0, countLabelList = 0;
		String[] labelTexts = new String[projectEnquiryPageFieldsList.size()];
		while (j < ProjectEnquiriesPageFields.size()) {
			for (WebElement element : projectEnquiryPageFieldsList) {
				labelTexts[i1] = element.getText();
				if (labelTexts[i1].contains(ProjectEnquiriesPageFields.get(j))) {
					System.out.println("Verify Project Creation Page Fields List" + element.getText());
					report.updateTestLog("Verify Project Creation Page Fields List",
							element.getText() + "::::label is present in Project Enquiry Page for APAC", Status.PASS);
					countLabelList++;
				}
				i1++;
			}
			i1 = 0;
			j++;
		}
		System.out.println("Count of labels present in Offer Creation Page are::" + countLabelList);
		if (countLabelList >= 3) {
			report.updateTestLog("Verify Project Creation Page Fields List",
					"All the fields are present in Project Creation Page for APAC", Status.PASS);
		} else {
			report.updateTestLog("Verify Project Creation Page Fields List",
					"Not all the fields are present in Project Creation Page for APAC", Status.FAIL);
		}
	}

	/**
	 * Validating Multi Business Line- Do not add Account Name to Opportunity
	 * Name when Opportunity is Marked as Confidential
	 * 
	 * @author Vishnuvardhan
	 *
	 */

	public void opportunityConfidential() {
		selectNewOpportunity();
		Utility_Functions.timeWait(2);
		Utility_Functions.xSwitchtoFrame(driver, accountName);
		Utility_Functions.timeWait(2);
		/*
		 * String query =
		 * "SELECT EMEA_Account_Status__c, Name FROM Account where EMEA_Account_Status__c ='Active'"
		 * ; //String sAccountName = searchOpportunity.fetchRecord("Account",
		 * "Name"); String sAccountName =
		 * searchOpportunity.fetchRecordFieldValue("Name", query);
		 */
		Utility_Functions.xSendKeys(driver, accountName, "Test");
		accountName.sendKeys(Keys.ARROW_DOWN);
		Utility_Functions.timeWait(2);
		accountName.sendKeys(Keys.ENTER);
		Utility_Functions.xWaitForElementPresent(driver, confidentialCheckboxOpp, 3);
		Utility_Functions.xClick(driver, confidentialCheckboxOpp, true);
		Utility_Functions.xWaitForElementPresent(driver, estimatedGrossFeeCommissionEMEA, 3);
		Utility_Functions.xSendKeys(driver, estimatedGrossFeeCommissionEMEA,
				dataTable.getData("General_Data", "InstallmentAmount"));
		Utility_Functions.xSelectDropdownByIndex(salesStageEMEAOpp, 1);
		DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
		Date date = new Date();
		Utility_Functions.xSendKeys(driver, closeDateOpp, dateFormat.format(date).toString());
		Utility_Functions.xSendKeys(driver, closeDateOpp, Keys.TAB);
		Utility_Functions.xWaitForElementPresent(driver, saveNewOpportunity, 3);
		Utility_Functions.xClick(driver, saveNewOpportunity, true);
		driver.switchTo().defaultContent();
		Utility_Functions.timeWait(2);
		Utility_Functions.xWaitForElementPresent(driver, opportunityConfidentialName, 3);
		String opportunityName = opportunityConfidentialName.getText();
		if ((opportunityName.contains("Confidential")) && (opportunityName.contains("Client"))) {
			report.updateTestLog("Opportunity Created",
					"Opportunity Name created as per the expected format -- Conidential Client:::", Status.PASS);
		} else {
			report.updateTestLog("Opportunity Created",
					"Opportunity Name created as per the expected format -- Conidential Client:::", Status.FAIL);
		}
	}

	/**
	 * Validating Opportunity Type field and pick list values in Quick create
	 * Page layout for BC&P Opportunity Record Type page layout
	 * 
	 * @author Vishnuvardhan
	 *
	 */

	static ArrayList<String> OpportunityTypePickListValues = new ArrayList<String>();

	public void OpportunityTypePickListValues() {

		OpportunityTypePickListValues.add("-None--");
		OpportunityTypePickListValues.add("GWS Occupier");
		OpportunityTypePickListValues.add("Landlord");
		OpportunityTypePickListValues.add("Local Occupier");
		// ProjectEnquiriesPageFields.add("Status");

		System.out.println("Opportunity Type Pick List Values are:::" + OpportunityTypePickListValues);
	}

	public void opportunityTypePickList() {
		selectNewOpportunity();
		/*
		 * Utility_Functions.timeWait(2);
		 * Utility_Functions.xSwitchtoFrame(driver, continueButton);
		 * Utility_Functions.xWaitForElementPresent(driver, continueButton, 3);
		 * Utility_Functions.xWaitForElementPresent(driver,
		 * opportunityRecordTypeBCP, 3); Utility_Functions.xClick(driver,
		 * opportunityRecordTypeBCP, true); Utility_Functions.xClick(driver,
		 * continueButton, true);
		 */
		Utility_Functions.xSwitchtoFrame(driver, accountName);
		Utility_Functions.timeWait(2);
		OpportunityTypePickListValues();
		Utility_Functions.timeWait(2);
		List<WebElement> OpportunityTypePickList = driver.findElements(By.xpath(
				"//label[text()='Opportunity Type']/parent::div/div[@class='slds-form-element__control']/select/option"));
		int i1 = 0, j = 0, countLabelList = 0;
		String[] labelTexts = new String[OpportunityTypePickList.size()];
		while (j < OpportunityTypePickList.size()) {
			for (WebElement element : OpportunityTypePickList) {
				labelTexts[i1] = element.getText();
				if (labelTexts[i1].contains(OpportunityTypePickListValues.get(j))) {
					System.out.println("Verify Opportunity Type Pick List:::" + element.getText());
					report.updateTestLog("Verify Opportunity Type Pick List",
							element.getText() + "::::Opportunity Type Pick List value is present", Status.PASS);
					countLabelList++;
				}
				i1++;
			}
			i1 = 0;
			j++;
		}
		System.out.println("Count of labels present in Opportunity Type Pick List are ::" + countLabelList);
		if (countLabelList >= 3) {
			report.updateTestLog("Verify Opportunity Type Pick List", "Opportunity Type Pick List values are present",
					Status.PASS);
		} else {
			report.updateTestLog("Verify Opportunity Type Pick List",
					"Opportunity Type Pick List values are not present", Status.FAIL);
		}
	}

	/**
	 * Validating the Opportunity Calculated Annual Leasing Commission
	 * 
	 * @author Ramya
	 * 
	 *
	 */
	public void opportunityCalculateAnnualLeasingCommission() {
		Utility_Functions.xWaitForElementPresent(driver, menu_Opportunities, 3);
		Utility_Functions.xClick(driver, menu_Opportunities, true);
		Utility_Functions.xWaitForElementPresent(driver, newOpportunity, 3);
		Utility_Functions.xClick(driver, newOpportunity, true);
		Utility_Functions.timeWait(2);
		Utility_Functions.xWaitForElementPresent(driver, opportunityNameAS, 3);
		Utility_Functions.xSendKeys(driver, opportunityNameAS,
				"Test Automation Opportunity_" + Utility_Functions.xGenerateAlphaNumericString());
		Utility_Functions.xWaitForElementPresent(driver, searchAccountsNewOpportunity, 3);
		Utility_Functions.xSendKeys(driver, searchAccountsNewOpportunity, "Test Account APAC");
		Utility_Functions.xWaitForElementPresent(driver, accountValue, 3);
		Utility_Functions.xClick(driver, accountValue, true);
		Utility_Functions.xWaitForElementPresent(driver, totalSizeAS, 3);
		Utility_Functions.xSendKeys(driver, totalSizeAS, "2,000.00");
		Utility_Functions.xWaitForElementPresent(driver, regionAS, 3);
		Utility_Functions.xClick(driver, regionAS, true);
		Utility_Functions.xWaitForElementPresent(driver, regionValueAS, 3);
		Utility_Functions.xClick(driver, regionValueAS, true);
		Utility_Functions.xWaitForElementPresent(driver, marketValue, 3);
		Utility_Functions.xClick(driver, marketValue, true);
		Utility_Functions.xWaitForElementPresent(driver, leasingAS, 3);
		Utility_Functions.xClick(driver, leasingAS, true);
		Utility_Functions.xWaitForElementPresent(driver, valueAS, 3);
		Utility_Functions.xClick(driver, valueAS, true);
		Utility_Functions.xWaitForElementPresent(driver, consultancyAS, 3);
		Utility_Functions.xClick(driver, consultancyAS, true);
		Utility_Functions.xWaitForElementPresent(driver, valueAS, 3);
		Utility_Functions.xClick(driver, valueAS, true);
		Utility_Functions.timeWait(2);

	}

	/**
	 * Validating the Opportunity Calculated Annual Leasing Commission
	 * 
	 * @author Ramya
	 * 
	 *
	 */
	public void opportunityCloseInformationSection() {
		Utility_Functions.xWaitForElementPresent(driver, menu_Opportunities, 3);
		Utility_Functions.xClick(driver, menu_Opportunities, true);
		Utility_Functions.xWaitForElementPresent(driver, newOpportunity, 3);
		Utility_Functions.xClick(driver, newOpportunity, true);
		Utility_Functions.timeWait(2);
		Utility_Functions.xSwitchtoFrame(driver, viewAllFieldsButton);
		Utility_Functions.xWaitForElementPresent(driver, viewAllFieldsButton, 5);
		Utility_Functions.xClick(driver, viewAllFieldsButton, true);
		Utility_Functions.timeWait(5);
		if ((leasePeriodNewOpportunity.isDisplayed()) && (otherIncentivesNewOpportunity.isDisplayed())
				&& (landlordTenantAct.isDisplayed())) {

			report.updateTestLog("Verify Opportunity Close Information Section",
					"The lease period, other Incentives and Landlord Tenant act are present in the new Opportunity Page",
					Status.PASS);
		} else {
			report.updateTestLog("Verify Opportunity Close Information Section",
					"The lease period, other Incentives and Landlord Tenant act arenot present in the new Opportunity Page",
					Status.FAIL);
		}
		Utility_Functions.xWaitForElementPresent(driver, opportunityName, 3);
		Utility_Functions.xSendKeys(driver, opportunityName,
				"Test Automation Opportunity_" + Utility_Functions.xGenerateAlphaNumericString());
		String query = "SELECT Id, Name, EMEA_Searchable__c FROM Account where EMEA_Searchable__c = true limit 1 offset 9";
		String sAccountName = searchTextSOQL.fetchRecordFieldValue("Name", query);
		Utility_Functions.xSendKeys(driver, accountName, sAccountName);
		accountName.sendKeys(Keys.ARROW_DOWN);
		Utility_Functions.timeWait(2);
		accountName.sendKeys(Keys.ENTER);
		Utility_Functions.timeWait(2);
		Utility_Functions.xWaitForElementPresent(driver, salesStageEMEANewOpportunity, 4);
		Utility_Functions.xClick(driver, salesStageEMEANewOpportunity, true);
		Utility_Functions.xWaitForElementPresent(driver, salesStageEMEANewOpportunityValue, 4);
		Utility_Functions.xClick(driver, salesStageEMEANewOpportunityValue, true);
		Utility_Functions.xWaitForElementPresent(driver, estimatedGrossFeeNewOpportunity, 5);
		Utility_Functions.xSendKeys(driver, estimatedGrossFeeNewOpportunity,
				dataTable.getData("General_Data", "InstallmentAmount"));
		System.out.println(Calendar.getInstance());
		DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
		Date date = new Date();
		Utility_Functions.xWaitForElementPresent(driver, closeDateNewOpportunity, 3);
		Utility_Functions.xSendKeys(driver, closeDateNewOpportunity, dateFormat.format(date).toString());
		Utility_Functions.xWaitForElementPresent(driver, saveOpportunitySplitUAT, 4);
		Utility_Functions.xClick(driver, saveOpportunitySplitUAT, true);
		Utility_Functions.timeWait(2);
		driver.switchTo().defaultContent();
		Utility_Functions.timeWait(2);
		Utility_Functions.xWaitForElementPresent(driver, editOpportunity, 4);
		Utility_Functions.xClick(driver, editOpportunity, true);
		Utility_Functions.timeWait(2);
		Utility_Functions.xWaitForElementPresent(driver, cbreMarketGroupEMEA, 4);
		Utility_Functions.xClick(driver, cbreMarketGroupEMEA, true);
		Utility_Functions.xWaitForElementPresent(driver, cbreMarketGroupEMEAValue, 4);
		Utility_Functions.xClick(driver, cbreMarketGroupEMEAValue, true);
		Utility_Functions.xWaitForElementPresent(driver, netFeeOpportunityEdit, 5);
		Utility_Functions.xSendKeys(driver, netFeeOpportunityEdit,
				dataTable.getData("General_Data", "InstallmentAmount"));
		Utility_Functions.timeWait(2);
		Utility_Functions.xScrollWindow(driver);
		Utility_Functions.timeWait(2);
		Utility_Functions.xScrollWindowTop(driver);
		Utility_Functions.timeWait(2);
		Utility_Functions.xWaitForElementPresent(driver, salesStageEditOpp, 4);
		Utility_Functions.xClick(driver, salesStageEditOpp, true);
		Utility_Functions.xWaitForElementPresent(driver, salesStageEditOpportunityValue, 4);
		Utility_Functions.xClick(driver, salesStageEditOpportunityValue, true);
		Utility_Functions.xWaitForElementPresent(driver, totalSizeEditOpp, 5);
		Utility_Functions.xSendKeys(driver, totalSizeEditOpp, dataTable.getData("General_Data", "InstallmentAmount"));
		Utility_Functions.xWaitForElementPresent(driver, emeaConversionType, 4);
		Utility_Functions.xClick(driver, emeaConversionType, true);
		Utility_Functions.xWaitForElementPresent(driver, emeaConversionTypeValue, 4);
		Utility_Functions.timeWait(1);
		Utility_Functions.xClick(driver, emeaConversionTypeValue, true);
		System.out.println(Calendar.getInstance());
		DateFormat dateFormat1 = new SimpleDateFormat("MM/dd/yyyy");
		Date date1 = new Date();
		Utility_Functions.xWaitForElementPresent(driver, pitchDate, 3);
		Utility_Functions.xSendKeys(driver, pitchDate, dateFormat1.format(date1).toString());
		Utility_Functions.xWaitForElementPresent(driver, saveEditOpp, 4);
		Utility_Functions.xClick(driver, saveEditOpp, true);
		Utility_Functions.timeWait(3);
		if (details.isDisplayed()) {

			report.updateTestLog("Verify Quick Create Opportunity Page Discretionary Fee",
					"The opportunity is saved with the Discretionary Fee check box checked and the Discretionary amount ",
					Status.PASS);
		} else {
			report.updateTestLog("Verify Quick Create Opportunity Page Discretionary Fee",
					"The opportunity is not saved with the Discretionary Fee check box checked and the Discretionary amount",
					Status.FAIL);
		}

	}



	/**
	 * Validating the Opportunities create new installment
	 * 
	 * @author Ramya
	 *
	 */

	public void opportunitiesClosedDateAndInstallmentDate() {
		Utility_Functions.xWaitForElementPresent(driver, menu_Opportunities, 4);
		Utility_Functions.xClick(driver, menu_Opportunities, true);
		Utility_Functions.xWaitForElementPresent(driver, newOpportunity, 3);
		Utility_Functions.xClick(driver, newOpportunity, true);
		try {
			Utility_Functions.timeWait(2);
			Utility_Functions.xSwitchtoFrame(driver, continueButton);
			Utility_Functions.xWaitForElementPresent(driver, continueButton, 3);
			Utility_Functions.xClick(driver, continueButton, true);
			Utility_Functions.timeWait(2);
		} catch (Exception e1) {
			e1.printStackTrace();
		}
		Utility_Functions.xSwitchtoFrame(driver, viewAllFieldsButton);
		Utility_Functions.xWaitForElementPresent(driver, viewAllFieldsButton, 5);
		Utility_Functions.xClick(driver, viewAllFieldsButton, true);
		Utility_Functions.timeWait(5);
		Utility_Functions.xWaitForElementPresent(driver, opportunityName, 3);
		Utility_Functions.xSendKeys(driver, opportunityName,
				"Test Automation Opportunity_" + Utility_Functions.xGenerateAlphaNumericString());
		String query = "SELECT Id, Name, EMEA_Searchable__c FROM Account where EMEA_Searchable__c = true limit 1 offset 9";
		String sAccountName = searchTextSOQL.fetchRecordFieldValue("Name", query);
		Utility_Functions.xSendKeys(driver, accountName, sAccountName);
		accountName.sendKeys(Keys.ARROW_DOWN);
		Utility_Functions.timeWait(2);
		accountName.sendKeys(Keys.ENTER);
		Utility_Functions.timeWait(2);
		Utility_Functions.xWaitForElementPresent(driver, salesStageEMEANewOpportunity, 4);
		Utility_Functions.xClick(driver, salesStageEMEANewOpportunity, true);
		Utility_Functions.xWaitForElementPresent(driver, salesStageEMEANewOpportunityValue, 4);
		Utility_Functions.xClick(driver, salesStageEMEANewOpportunityValue, true);
		Utility_Functions.xWaitForElementPresent(driver, estimatedGrossFeeNewOpportunity, 5);
		Utility_Functions.xSendKeys(driver, estimatedGrossFeeNewOpportunity,
				dataTable.getData("General_Data", "InstallmentAmount"));
		System.out.println(Calendar.getInstance());
		DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
		Date date = new Date();
		Utility_Functions.xWaitForElementPresent(driver, closeDateNewOpportunity, 3);
		Utility_Functions.xSendKeys(driver, closeDateNewOpportunity, dateFormat.format(date).toString());
		Utility_Functions.xWaitForElementPresent(driver, saveOpportunitySplitUAT, 4);
		Utility_Functions.xClick(driver, saveOpportunitySplitUAT, true);
		Utility_Functions.timeWait(2);
		driver.switchTo().defaultContent();
		Utility_Functions.timeWait(2);
		Utility_Functions.xWaitForElementPresent(driver, editOpportunity, 4);
		Utility_Functions.xClick(driver, editOpportunity, true);
		Utility_Functions.timeWait(2);
		Utility_Functions.xScrollWindow(driver);
		Utility_Functions.timeWait(2);
		Utility_Functions.xScrollWindowTop(driver);
		Utility_Functions.timeWait(2);
		try {
			System.out.println(Calendar.getInstance());
			DateFormat dateFormat1 = new SimpleDateFormat("MM/dd/yyyy");
			Date date1 = new Date();
			Utility_Functions.xWaitForElementPresent(driver, installmentDateEditOpp, 3);
			Utility_Functions.xSendKeys(driver, installmentDateEditOpp, dateFormat1.format(date1).toString());
		} catch (Exception e) {
			System.out.println("Installment Date is not user editable");
		}

	}

	static ArrayList<String> relatedListValues = new ArrayList<String>();

	public void opportunityRelatedList() {

		relatedListValues.add("Opportunity Installments");
		relatedListValues.add("Space");
		relatedListValues.add("Activities");
		relatedListValues.add("Contact Roles");
		relatedListValues.add("Notes");
		relatedListValues.add("Files");

		System.out.println("The labels for the related list objects are " + relatedListValues);

	}

	public void validateNewOpportunitiesRelatedObjects() {
		Utility_Functions.xWaitForElementPresent(driver, menu_home, 3);
		Utility_Functions.xWaitForElementPresent(driver, menu_Opportunities, 4);
		Utility_Functions.xClick(driver, menu_Opportunities, true);
		Utility_Functions.xWaitForElementPresent(driver, newOpportunity, 3);
		Utility_Functions.xClick(driver, newOpportunity, true);
		Utility_Functions.timeWait(2);
		Utility_Functions.xSwitchtoFrame(driver, continueButton);
		Utility_Functions.xWaitForElementPresent(driver, selectOpportunityRecordType, 3);
		Utility_Functions.xClick(driver, selectOpportunityRecordType, true);
		Utility_Functions.xWaitForElementPresent(driver, opportunityDSFValue, 3);
		Utility_Functions.xClick(driver, opportunityDSFValue, true);
		Utility_Functions.xWaitForElementPresent(driver, continueButton, 3);
		Utility_Functions.xClick(driver, continueButton, true);
		Utility_Functions.timeWait(2);
		driver.switchTo().defaultContent();
		Utility_Functions.timeWait(2);
		Utility_Functions.xWaitForElementPresent(driver, accountNameNewOpportunity, 4);
		/*
		 * Utility_Functions.xSendKeys(driver,accountNameNewOpportunity,
		 * "Test Automation_0101"); Utility_Functions.timeWait(1);
		 * Utility_Functions.xWaitForElementPresent(driver,accountNameNewOpp,
		 * 3); Utility_Functions.xClick(driver,accountNameNewOpp, true);
		 */
		Utility_Functions.xClick(driver, accountNameNewOpportunity, true);
		WebElement firstLookupElement = driver
				.findElement(By.cssSelector("ul>li.forceSearchInputLookupDesktopOption:nth-child(1)"));
		Utility_Functions.xWaitForElementPresent(driver, firstLookupElement, 4);
		Utility_Functions.xClick(driver, firstLookupElement, false);
		System.out.println(Calendar.getInstance());
		DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
		Date date = new Date();
		Utility_Functions.xWaitForElementPresent(driver, closeDate_AS, 3);
		Utility_Functions.xSendKeys(driver, closeDate_AS, dateFormat.format(date).toString());
		Utility_Functions.xWaitForElementPresent(driver, leadSourceNewOpp, 3);
		Utility_Functions.xClick(driver, leadSourceNewOpp, true);
		Utility_Functions.xWaitForElementPresent(driver, leadSourceNewOppValue, 3);
		Utility_Functions.xClick(driver, leadSourceNewOppValue, true);
		Utility_Functions.xWaitForElementPresent(driver, estimatedGrossFeeCommissionValue, 3);
		Utility_Functions.xSendKeys(driver, estimatedGrossFeeCommissionValue,
				dataTable.getData("General_Data", "InstallmentAmount"));
		Utility_Functions.xWaitForElementPresent(driver, estimatedTransactionValue, 3);
		Utility_Functions.xSendKeys(driver, estimatedTransactionValue,
				dataTable.getData("General_Data", "InstallmentAmount"));
		Utility_Functions.xWaitForElementPresent(driver, saveNewOpp, 3);
		Utility_Functions.xClick(driver, saveNewOpp, true);
		Utility_Functions.timeWait(5);
		Utility_Functions.xWaitForElementPresent(driver, related, 3);
		Utility_Functions.xClick(driver, related, true);
		Utility_Functions.timeWait(2);
		List<WebElement> relatedListObjects = driver.findElements(By.xpath("//h2[@id='header']//span[1]"));
		int count5 = 0, i5 = 0, j5 = 0;
		String fieldsArray5[] = new String[relatedListObjects.size()];
		System.out.println(relatedListObjects.size());
		try {
			opportunityRelatedList();
			while (j5 < relatedListObjects.size()) {
				for (WebElement element5 : relatedListObjects) {
					fieldsArray5[i5] = element5.getText();
					if (fieldsArray5[i5].equalsIgnoreCase(relatedListValues.get(j5))) {
						System.out.println("Verify related list object " + element5.getText());
						report.updateTestLog("Verify Opportunity Related List Object",
								element5.getText() + "labels  present in the Related List Section ", Status.PASS);
						count5++;
					}
					i5++;
				}
				i5 = 0;
				j5++;
			}
			System.out.println(count5);
			if (count5 >= 4) {
				report.updateTestLog("Verify Opportunity Related List Object",
						"All fields are present in the Realted List Section", Status.PASS);
			} else {
				report.updateTestLog("Verify Opportunity Related List Object",
						"All fields are not present in the Related List Section", Status.FAIL);
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		if ((activity.isDisplayed()) && (chatter.isDisplayed())) {

			report.updateTestLog("Verify Opportunity Related List Object", "Activity and chatter are displayed",
					Status.PASS);
		} else {
			report.updateTestLog("Verify Opportunity Related List Object", "Activity and chatter are not displayed",
					Status.FAIL);
		}
		tasksPage.createNewActivity();
	}

	/**
	 * Validating the Opportunities page for Recalculate and new installment
	 * button
	 * @FindBy(xpath = "//a[contains(@title,'Recalculate')]")
	WebElement recalculate;


	 * 
	 * @author Ramya
	 *
	 */
	public void validateRecalculateAndNewInstallment() {

		Utility_Functions.xWaitForElementPresent(driver, menu_Opportunities, 4);
		Utility_Functions.xClick(driver, menu_Opportunities, true);
		Utility_Functions.xWaitForElementPresent(driver, newOpportunity, 3);
		Utility_Functions.xClick(driver, newOpportunity, true);
		Utility_Functions.timeWait(7);
		Utility_Functions.xSwitchtoFrame(driver, continueButton);
		Utility_Functions.xWaitForElementPresent(driver, selectOpportunityRecordType, 3);
		Utility_Functions.xClick(driver, selectOpportunityRecordType, true);
		Utility_Functions.xWaitForElementPresent(driver, opportunityDSFValue, 5);
		Utility_Functions.xClick(driver, opportunityDSFValue, true);
		Utility_Functions.xWaitForElementPresent(driver, continueButton, 3);
		Utility_Functions.xClick(driver, continueButton, true);
		Utility_Functions.timeWait(4);
		driver.switchTo().defaultContent();
		Utility_Functions.timeWait(6);
		Utility_Functions.xWaitForElementPresent(driver, accountNameNewOpportunity, 4);
		Utility_Functions.xClick(driver, accountNameNewOpportunity, true);
		Utility_Functions.xSendKeys(driver, accountNameNewOpportunity, "test");
		WebElement firstLookupElement = driver
				.findElement(By.cssSelector("ul>li.forceSearchInputLookupDesktopOption:nth-child(1)"));
		Utility_Functions.xWaitForElementPresent(driver, firstLookupElement, 4);
		Utility_Functions.xClick(driver, firstLookupElement, false);
		/*
		 * Utility_Functions.xSendKeys(driver,accountNameNewOpportunity,
		 * "Test Automation_0101");
		 * Utility_Functions.xWaitForElementPresent(driver,accountNameNewOpp,
		 * 3); Utility_Functions.xClick(driver,accountNameNewOpp, true);
		 */
		System.out.println(Calendar.getInstance());
		DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
		Date date = new Date();
		Utility_Functions.xWaitForElementPresent(driver, closeDate_AS, 3);
		Utility_Functions.xSendKeys(driver, closeDate_AS, dateFormat.format(date).toString());
		Utility_Functions.xWaitForElementPresent(driver, leadSourceNewOpp, 3);
		Utility_Functions.xClick(driver, leadSourceNewOpp, true);
		Utility_Functions.xWaitForElementPresent(driver, leadSourceNewOppValue, 3);
		Utility_Functions.xClick(driver, leadSourceNewOppValue, true);
		Utility_Functions.xWaitForElementPresent(driver, estimatedGrossFeeCommissionValue, 3);
		Utility_Functions.xSendKeys(driver, estimatedGrossFeeCommissionValue,
				dataTable.getData("General_Data", "InstallmentAmount"));
		Utility_Functions.xWaitForElementPresent(driver, estimatedTransactionValue, 3);
		Utility_Functions.xSendKeys(driver, estimatedTransactionValue,
				dataTable.getData("General_Data", "InstallmentAmount"));
		Utility_Functions.xWaitForElementPresent(driver, saveNewOpp, 3);
		Utility_Functions.xClick(driver, saveNewOpp, true);
		Utility_Functions.timeWait(10);
		Utility_Functions.xWaitForElementPresent(driver, showMoreActions, 6);
		Utility_Functions.xClick(driver, showMoreActions, true);
		Utility_Functions.xWaitForElementPresent(driver, recalculate, 5);
		if ((recalculate.isDisplayed()) && (newInstallment.isDisplayed())) {

			report.updateTestLog("Verify Recalculate and New Installment",
					"The Recalculate and new Installment buttons are present", Status.PASS);
		} else {
			report.updateTestLog("Verify Recalculate and New Installment",
					"The Recalculate and new Installment buttons are not present", Status.FAIL);
		}
	}

	/**
	 * Validating the Opportunities creation for the Japan users 
	 * 
	 * @author Ramya
	 *
	 */
	public void validateOpportunityCreation() {

		Utility_Functions.timeWait(2);
		Utility_Functions.xScrollWindow(driver);
		Utility_Functions.timeWait(1);
		Utility_Functions.xWaitForElementPresent(driver, nextForJapan, 4);
		Utility_Functions.xClick(driver, nextForJapan, true);
		Utility_Functions.timeWait(2);
		Utility_Functions.xWaitForElementPresent(driver, menu_Opportunities, 4);
		Utility_Functions.xClick(driver, menu_Opportunities, true);
		Utility_Functions.xWaitForElementPresent(driver, newOpportunity, 3);
		Utility_Functions.xClick(driver, newOpportunity, true);
		Utility_Functions.xSwitchtoFrame(driver, continueButton);
		Utility_Functions.xWaitForElementPresent(driver, selectOpportunityRecordType, 3);
		Utility_Functions.xClick(driver, selectOpportunityRecordType, true);
		Utility_Functions.xWaitForElementPresent(driver, opportunityDSFValue, 3);
		Utility_Functions.xClick(driver, opportunityDSFValue, true);
		Utility_Functions.xWaitForElementPresent(driver, continueButton, 3);
		Utility_Functions.xClick(driver, continueButton, true);
		Utility_Functions.timeWait(2);
		driver.switchTo().defaultContent();
		Utility_Functions.timeWait(2);
		Utility_Functions.xWaitForElementPresent(driver, accountNameNewOpportunity, 4);
		Utility_Functions.xSendKeys(driver, accountNameNewOpportunity, "Test Automation_0101");
		Utility_Functions.xWaitForElementPresent(driver, accountNameNewOpp, 3);
		Utility_Functions.xClick(driver, accountNameNewOpp, true);
		System.out.println(Calendar.getInstance());
		DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
		Date date = new Date();
		Utility_Functions.xWaitForElementPresent(driver, closeDate_AS, 3);
		Utility_Functions.xSendKeys(driver, closeDate_AS, dateFormat.format(date).toString());
		Utility_Functions.xWaitForElementPresent(driver, leadSourceNewOpp, 3);
		Utility_Functions.xClick(driver, leadSourceNewOpp, true);
		Utility_Functions.xWaitForElementPresent(driver, leadSourceNewOppValue, 3);
		Utility_Functions.xClick(driver, leadSourceNewOppValue, true);
		Utility_Functions.xWaitForElementPresent(driver, estimatedGrossFeeCommissionValue, 3);
		Utility_Functions.xSendKeys(driver, estimatedGrossFeeCommissionValue,
				dataTable.getData("General_Data", "InstallmentAmount"));
		Utility_Functions.xWaitForElementPresent(driver, estimatedTransactionValue, 3);
		Utility_Functions.xSendKeys(driver, estimatedTransactionValue,
				dataTable.getData("General_Data", "InstallmentAmount"));
		Utility_Functions.xWaitForElementPresent(driver, saveNewOpp, 3);
		Utility_Functions.xClick(driver, saveNewOpp, true);
		Utility_Functions.timeWait(3);
		Utility_Functions.xWaitForElementPresent(driver, showMoreActions, 3);
		Utility_Functions.xClick(driver, showMoreActions, true);
		if ((recalculate.isDisplayed()) && (newInstallment.isDisplayed())) {

			report.updateTestLog("Verify Recalculate and New Installment",
					"The Recalculate and new Installment buttons are present", Status.PASS);
		} else {
			report.updateTestLog("Verify Recalculate and New Installment",
					"The Recalculate and new Installment buttons are not present", Status.FAIL);
		}
		}

	/**
	 * Validating the Opportunities APAC DSF for Financial Details for pacific
	 * users
	 * 
	 * @author Ramya
	 *
	 */
	public void validateOpportunitiesFinancialDetails() {
		Utility_Functions.xWaitForElementPresent(driver, menu_Opportunities, 4);
		Utility_Functions.xClick(driver, menu_Opportunities, true);
		Utility_Functions.xWaitForElementPresent(driver, newOpportunity, 3);
		Utility_Functions.xClick(driver, newOpportunity, true);
		Utility_Functions.timeWait(2);
		Utility_Functions.xSwitchtoFrame(driver, continueButton);
		Utility_Functions.xWaitForElementPresent(driver, selectOpportunityRecordType, 3);
		Utility_Functions.xClick(driver, selectOpportunityRecordType, true);
		Utility_Functions.xWaitForElementPresent(driver, opportunityDSFValue, 3);
		Utility_Functions.xClick(driver, opportunityDSFValue, true);
		Utility_Functions.xWaitForElementPresent(driver, continueButton, 3);
		Utility_Functions.xClick(driver, continueButton, true);
		Utility_Functions.timeWait(2);
		driver.switchTo().defaultContent();
		Utility_Functions.timeWait(2);
		Utility_Functions.xWaitForElementPresent(driver, accountNameNewOpportunity, 4);
		Utility_Functions.xSendKeys(driver, accountNameNewOpportunity, "Test Automation_0101");
		Utility_Functions.xWaitForElementPresent(driver, accountNameNewOpp, 3);
		Utility_Functions.xClick(driver, accountNameNewOpp, true);
		System.out.println(Calendar.getInstance());
		DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
		Date date = new Date();
		Utility_Functions.xWaitForElementPresent(driver, closeDate_AS, 3);
		Utility_Functions.xSendKeys(driver, closeDate_AS, dateFormat.format(date).toString());
		Utility_Functions.xWaitForElementPresent(driver, leadSourceNewOpp, 3);
		Utility_Functions.xClick(driver, leadSourceNewOpp, true);
		Utility_Functions.xWaitForElementPresent(driver, leadSourceNewOppValue, 3);
		Utility_Functions.xClick(driver, leadSourceNewOppValue, true);
		if ((estimatedGrossFeeCommissionValue.isDisplayed())
				&& (estimatedTransactionValue.isDisplayed() && (opportunityCurrency.isDisplayed()))) {

			report.updateTestLog("Verify Opportunities Financial Details",
					"The Estimated Gross Fee Commission, Estimated Transaction value and the Opportunity Currency are displayed in the financial details section",
					Status.PASS);
		} else {
			report.updateTestLog("Verify Opportunities Financial Details",
					"The Estimated Gross Fee Commission, Estimated Transaction value and the Opportunity Currency are not displayed in the financial details section",
					Status.FAIL);
		}
		Utility_Functions.xWaitForElementPresent(driver, estimatedGrossFeeCommissionValue, 3);
		Utility_Functions.xSendKeys(driver, estimatedGrossFeeCommissionValue,
				dataTable.getData("General_Data", "InstallmentAmount"));
		Utility_Functions.xWaitForElementPresent(driver, estimatedTransactionValue, 3);
		Utility_Functions.xSendKeys(driver, estimatedTransactionValue,
				dataTable.getData("General_Data", "InstallmentAmount"));
		Utility_Functions.xWaitForElementPresent(driver, saveNewOpp, 3);
		Utility_Functions.xClick(driver, saveNewOpp, true);
		Utility_Functions.timeWait(5);
		if (details.isDisplayed()) {

			report.updateTestLog("Verify Opportunities Financial Details",
					"The opportunity is saved with all the mandatory fields ", Status.PASS);
		} else {
			report.updateTestLog("Verify Opportunities Financial Details",
					"The opportunity is not saved with all the mandatory fields", Status.FAIL);
		}
	}

	/**
	 * Validating the Opportunities creation for the project manager
	 * 
	 * @author Ramya
	 *
	 */
	static ArrayList<String> opportunityDetailsPageHeaders = new ArrayList<String>();

	public void opportunityDetailsPageSections() {

		opportunityDetailsPageHeaders.add("Opportunity Information");
		opportunityDetailsPageHeaders.add("Opportunity Status & Milestones");
		opportunityDetailsPageHeaders.add("Project Location");
		opportunityDetailsPageHeaders.add("Project Specifications");
		opportunityDetailsPageHeaders.add("Financial Information");
		opportunityDetailsPageHeaders.add("Loss/Cancel Information");
		// opportunityDetailsPageHeaders.add("Tagging");
		// opportunityDetailsPageHeaders.add("Related Opportunities");
		opportunityDetailsPageHeaders.add("System Information");

		System.out.println("The sections in the Opportunity Details page are " + opportunityDetailsPageHeaders);

	}

	public void validateOpportunityCreationForProjectManager() {
		Utility_Functions.xWaitForElementPresent(driver, menu_Opportunities, 4);
		Utility_Functions.xClick(driver, menu_Opportunities, true);
		Utility_Functions.xWaitForElementPresent(driver, newOpportunity, 3);
		Utility_Functions.xClick(driver, newOpportunity, true);
		Utility_Functions.timeWait(2);
		Utility_Functions.xWaitForElementPresent(driver, opportunityName_AS, 3);
		Utility_Functions.xClick(driver, opportunityName_AS, true);
		Utility_Functions.xWaitForElementPresent(driver, opportunityName_AS, 3);
		Utility_Functions.xSendKeys(driver, opportunityName_AS,
				"Test Automation Opportunity_" + Utility_Functions.xGenerateAlphaNumericString());
		Utility_Functions.xWaitForElementPresent(driver, accountNameNewOpportunity, 4);
		Utility_Functions.xSendKeys(driver, accountNameNewOpportunity, "Test Automation_0101");
		Utility_Functions.xWaitForElementPresent(driver, accountNameNewOpp, 3);
		Utility_Functions.xClick(driver, accountNameNewOpp, true);
		System.out.println(Calendar.getInstance());
		DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
		Date date = new Date();
		Utility_Functions.xWaitForElementPresent(driver, closeDate_AS, 3);
		Utility_Functions.xSendKeys(driver, closeDate_AS, dateFormat.format(date).toString());
		Calendar calendar1 = Calendar.getInstance();
		calendar1.add(Calendar.DAY_OF_MONTH, -20);
		SimpleDateFormat dateFormat1 = new SimpleDateFormat("MM/dd/yyyy");
		System.out.println("Date : " + dateFormat1.format(calendar1.getTime()));
		Utility_Functions.xWaitForElementPresent(driver, assignmentStartDate, 3);
		Utility_Functions.xSendKeys(driver, assignmentStartDate, dateFormat1.format(calendar1.getTime()));
		Utility_Functions.xWaitForElementPresent(driver, leadSourceNewOpp, 3);
		Utility_Functions.xClick(driver, leadSourceNewOpp, true);
		Utility_Functions.xWaitForElementPresent(driver, leadSourceNewOppValue, 3);
		Utility_Functions.xClick(driver, leadSourceNewOppValue, true);
		Utility_Functions.xWaitForElementPresent(driver, opportunityCBREOffice, 3);
		Utility_Functions.xClick(driver, opportunityCBREOffice, true);
		Utility_Functions.xWaitForElementPresent(driver, opportunityCBREOfficeValue, 3);
		Utility_Functions.xClick(driver, opportunityCBREOfficeValue, true);
		Utility_Functions.xWaitForElementPresent(driver, opportunityCountry, 3);
		Utility_Functions.xClick(driver, opportunityCountry, true);
		Utility_Functions.xWaitForElementPresent(driver, opportunityCountryValue, 3);
		Utility_Functions.xClick(driver, opportunityCountryValue, true);
		Utility_Functions.xWaitForElementPresent(driver, opportunityCity, 3);
		Utility_Functions.xSendKeys(driver, opportunityCity, dataTable.getData("General_Data", "City"));
		Utility_Functions.xWaitForElementPresent(driver, assetType, 3);
		Utility_Functions.xClick(driver, assetType, true);
		Utility_Functions.xWaitForElementPresent(driver, assetTypeValue, 3);
		Utility_Functions.xClick(driver, assetTypeValue, true);
		Utility_Functions.xWaitForElementPresent(driver, selectOpportunityCurrency, 3);
		Utility_Functions.xClick(driver, selectOpportunityCurrency, true);
		Utility_Functions.xWaitForElementPresent(driver, opportunityCurrencyValue, 3);
		Utility_Functions.xClick(driver, opportunityCurrencyValue, true);
		Utility_Functions.xWaitForElementPresent(driver, cityTier, 3);
		Utility_Functions.xClick(driver, cityTier, true);
		Utility_Functions.xWaitForElementPresent(driver, cityTierValue, 3);
		Utility_Functions.xClick(driver, cityTierValue, true);
		Utility_Functions.xWaitForElementPresent(driver, saveNewOpp, 3);
		Utility_Functions.xClick(driver, saveNewOpp, true);
		Utility_Functions.timeWait(5);
		if (details.isDisplayed()) {
			report.updateTestLog("Verify Home Page Tabs", "The opportunity is saved with the all the required fields",
					Status.PASS);
		} else {
			report.updateTestLog("Verify Home Page Tabs",
					"The opportunity is not saved with the all the required fields", Status.FAIL);
		}
		List<WebElement> systemInformationSectionFields = driver
				.findElements(By.xpath("//span[contains(@class,'header-title')]"));
		int count = 0, i = 0, j = 0;
		String fieldsArray[] = new String[systemInformationSectionFields.size()];
		System.out.println(systemInformationSectionFields.size());
		try {
			opportunityDetailsPageSections();
			while (j < systemInformationSectionFields.size()) {
				for (WebElement element : systemInformationSectionFields) {
					fieldsArray[i] = element.getText();
					if (fieldsArray[i].equalsIgnoreCase(opportunityDetailsPageHeaders.get(j))) {
						System.out.println("Verify System Information Section " + element.getText());
						report.updateTestLog("Verify System Information Section ",
								element.getText() + "labels  present in the System Information Section ", Status.PASS);
						count++;
					}
					i++;
				}
				i = 0;
				j++;
			}
			System.out.println(count);
			if (count != 7) {
				report.updateTestLog("Verify Opportunity Page Headers",
						"All sections are not present in the Opportunity Details page", Status.FAIL);
			} else {
				report.updateTestLog("Verify Opportunity Page Headers",
						"All sections are present in the Opportunity Details page", Status.PASS);
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		opportunityDetailsPageHeaders.clear();
	}

	/**
	 * Validating the Opportunities required fields at sales stage 02
	 * 
	 * @author Ramya
	 *
	 */
	public void validateRequiredFieldsAtSalesStage02() {
		Utility_Functions.xWaitForElementPresent(driver, menu_Opportunities, 4);
		Utility_Functions.xClick(driver, menu_Opportunities, true);
		Utility_Functions.xWaitForElementPresent(driver, newOpportunity, 3);
		Utility_Functions.xClick(driver, newOpportunity, true);
		Utility_Functions.timeWait(2);
		Utility_Functions.xWaitForElementPresent(driver, accountNameNewOpportunity, 4);
		Utility_Functions.xSendKeys(driver, accountNameNewOpportunity, "Test Automation_0101");
		Utility_Functions.xWaitForElementPresent(driver, accountNameNewOpp, 3);
		Utility_Functions.xClick(driver, accountNameNewOpp, true);
		if ((salesStageDefaultValue.isDisplayed())) {
			report.updateTestLog("Verify Opportunity Required Fields at Sales Stage 02",
					"Sales stage is populated with default value 02", Status.PASS);

		} else {
			report.updateTestLog("Verify Opportunity Required Fields at Sales Stage 02",
					"Sales stage is not populated with default value 02", Status.FAIL);

		}
		System.out.println(Calendar.getInstance());
		DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
		Date date = new Date();
		Utility_Functions.xWaitForElementPresent(driver, closeDate_AS, 3);
		Utility_Functions.xSendKeys(driver, closeDate_AS, dateFormat.format(date).toString());
		Utility_Functions.xWaitForElementPresent(driver, leadSourceNewOpp, 3);
		Utility_Functions.xClick(driver, leadSourceNewOpp, true);
		Utility_Functions.xWaitForElementPresent(driver, leadSourceNewOppValue, 3);
		Utility_Functions.xClick(driver, leadSourceNewOppValue, true);
		Utility_Functions.xWaitForElementPresent(driver, opportunityCBREOffice, 3);
		Utility_Functions.xClick(driver, opportunityCBREOffice, true);
		Utility_Functions.xWaitForElementPresent(driver, opportunityCBREOfficeValue, 3);
		Utility_Functions.xClick(driver, opportunityCBREOfficeValue, true);
		Utility_Functions.xWaitForElementPresent(driver, opportunityCountry, 3);
		Utility_Functions.xClick(driver, opportunityCountry, true);
		Utility_Functions.xWaitForElementPresent(driver, opportunityCountryValue, 3);
		Utility_Functions.xClick(driver, opportunityCountryValue, true);
		Utility_Functions.xWaitForElementPresent(driver, opportunityCity, 3);
		Utility_Functions.xSendKeys(driver, opportunityCity, dataTable.getData("General_Data", "City"));
		Utility_Functions.xWaitForElementPresent(driver, assetType, 3);
		Utility_Functions.xClick(driver, assetType, true);
		Utility_Functions.xWaitForElementPresent(driver, assetTypeValue, 3);
		Utility_Functions.xClick(driver, assetTypeValue, true);
		Utility_Functions.xWaitForElementPresent(driver, selectOpportunityCurrency, 3);
		Utility_Functions.xClick(driver, selectOpportunityCurrency, true);
		Utility_Functions.xWaitForElementPresent(driver, opportunityCurrencyValue, 3);
		Utility_Functions.xClick(driver, opportunityCurrencyValue, true);
		Utility_Functions.xWaitForElementPresent(driver, cityTier, 3);
		Utility_Functions.xClick(driver, cityTier, true);
		Utility_Functions.xWaitForElementPresent(driver, cityTierValue, 3);
		Utility_Functions.xClick(driver, cityTierValue, true);
		Utility_Functions.xWaitForElementPresent(driver, saveNewOpp, 3);
		Utility_Functions.xClick(driver, saveNewOpp, true);
		if (details.isDisplayed()) {
			report.updateTestLog("Verify Required Fields at Sales Stage",
					"The opportunity is saved with the all the required fields for the sales stage", Status.PASS);
		} else {
			report.updateTestLog("Verify Required Fields at Sales Stage",
					"The opportunity is not saved with the all the required fields for the sales stage", Status.FAIL);
		}
	}

	/**
	 * Validating the Opportunities required fields at sales stage 03
	 * 
	 * @author Ramya
	 *
	 */
	public void validateRequiredFieldsAtSalesStage03() {
		Utility_Functions.xWaitForElementPresent(driver, menu_Opportunities, 4);
		Utility_Functions.xClick(driver, menu_Opportunities, true);
		Utility_Functions.xWaitForElementPresent(driver, newOpportunity, 3);
		Utility_Functions.xClick(driver, newOpportunity, true);
		Utility_Functions.timeWait(2);
		Utility_Functions.xWaitForElementPresent(driver, accountNameNewOpportunity, 4);
		Utility_Functions.xClick(driver, accountNameNewOpportunity, true);
		WebElement firstLookupElement = driver
				.findElement(By.cssSelector("ul>li.forceSearchInputLookupDesktopOption:nth-child(1)"));
		Utility_Functions.xWaitForElementPresent(driver, firstLookupElement, 4);
		Utility_Functions.xClick(driver, firstLookupElement, false);
		/*
		 * Utility_Functions.xSendKeys(driver,accountNameNewOpportunity,
		 * "Test Automation_0101");
		 * Utility_Functions.xWaitForElementPresent(driver,accountNameNewOpp,
		 * 3); Utility_Functions.xClick(driver,accountNameNewOpp, true);
		 */
		if ((dataTable.getData("General_Data", "TC_ID").contains("APACProjectManagerRequiredFieldsSalesStage07"))) {
			Utility_Functions.xWaitForElementPresent(driver, opportunityDetails, 3);
			Utility_Functions.xSendKeys(driver, opportunityDetails, "This is an opportunity");
		}
		Utility_Functions.xWaitForElementPresent(driver, salesStage_AS, 3);
		Utility_Functions.xClick(driver, salesStage_AS, true);
		if ((dataTable.getData("General_Data", "TC_ID").contains("APACProjectManagerRequiredFieldsSalesStage03"))) {
			Utility_Functions.xWaitForElementPresent(driver, salesStageValue03, 3);
			Utility_Functions.xClick(driver, salesStageValue03, true);
		} else if ((dataTable.getData("General_Data", "TC_ID")
				.contains("APACProjectManagerRequiredFieldsSalesStage04"))) {
			Utility_Functions.xWaitForElementPresent(driver, salesStageValue04, 3);
			Utility_Functions.xClick(driver, salesStageValue04, true);
		} else if ((dataTable.getData("General_Data", "TC_ID")
				.contains("APACProjectManagerRequiredFieldsSalesStage06"))) {
			Utility_Functions.xWaitForElementPresent(driver, salesStageValue06, 3);
			Utility_Functions.xClick(driver, salesStageValue06, true);
		} else if ((dataTable.getData("General_Data", "TC_ID")
				.contains("APACProjectManagerRequiredFieldsSalesStage07"))) {
			Utility_Functions.xWaitForElementPresent(driver, salesStageValue07, 3);
			Utility_Functions.xClick(driver, salesStageValue07, true);
		}
		System.out.println(Calendar.getInstance());
		DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
		Date date = new Date();
		Utility_Functions.xWaitForElementPresent(driver, closeDate_AS, 3);
		Utility_Functions.xSendKeys(driver, closeDate_AS, dateFormat.format(date).toString());
		Calendar calendar1 = Calendar.getInstance();
		calendar1.add(Calendar.DAY_OF_MONTH, -20);
		SimpleDateFormat dateFormat1 = new SimpleDateFormat("MM/dd/yyyy");
		System.out.println("Date : " + dateFormat1.format(calendar1.getTime()));
		Utility_Functions.xWaitForElementPresent(driver, assignmentStartDate, 3);
		Utility_Functions.xSendKeys(driver, assignmentStartDate, dateFormat1.format(calendar1.getTime()));
		Utility_Functions.xWaitForElementPresent(driver, identificationDate, 3);
		Utility_Functions.xSendKeys(driver, identificationDate, dateFormat.format(date).toString());
		Utility_Functions.xWaitForElementPresent(driver, submissionDate, 3);
		Utility_Functions.xSendKeys(driver, submissionDate, dateFormat.format(date).toString());
		Utility_Functions.xWaitForElementPresent(driver, outcomeDate, 3);
		Utility_Functions.xSendKeys(driver, outcomeDate, dateFormat.format(date).toString());
		Utility_Functions.xWaitForElementPresent(driver, completionDate, 3);
		Utility_Functions.xSendKeys(driver, completionDate, dateFormat.format(date).toString());
		Utility_Functions.xWaitForElementPresent(driver, leadSourceNewOpp, 3);
		Utility_Functions.xClick(driver, leadSourceNewOpp, true);
		Utility_Functions.xWaitForElementPresent(driver, leadSourceNewOppValue, 3);
		Utility_Functions.xClick(driver, leadSourceNewOppValue, true);
		Utility_Functions.xWaitForElementPresent(driver, opportunityCBREOffice, 3);
		Utility_Functions.xClick(driver, opportunityCBREOffice, true);
		Utility_Functions.xWaitForElementPresent(driver, opportunityCBREOfficeValue, 3);
		Utility_Functions.xClick(driver, opportunityCBREOfficeValue, true);
		Utility_Functions.xWaitForElementPresent(driver, opportunityCountry, 3);
		Utility_Functions.xClick(driver, opportunityCountry, true);
		Utility_Functions.xWaitForElementPresent(driver, opportunityCountryValue, 3);
		Utility_Functions.xClick(driver, opportunityCountryValue, true);
		Utility_Functions.xWaitForElementPresent(driver, opportunityCity, 3);
		Utility_Functions.xSendKeys(driver, opportunityCity, dataTable.getData("General_Data", "City"));
		Utility_Functions.xWaitForElementPresent(driver, cityTier, 3);
		Utility_Functions.xClick(driver, cityTier, true);
		Utility_Functions.xWaitForElementPresent(driver, cityTierValue, 3);
		Utility_Functions.xClick(driver, cityTierValue, true);
		Utility_Functions.xWaitForElementPresent(driver, assetType, 3);
		Utility_Functions.xClick(driver, assetType, true);
		Utility_Functions.xWaitForElementPresent(driver, assetTypeValue, 3);
		Utility_Functions.xClick(driver, assetTypeValue, true);
		Utility_Functions.xWaitForElementPresent(driver, totalSize_AS, 3);
		Utility_Functions.xSendKeys(driver, totalSize_AS, dataTable.getData("General_Data", "Total Size"));
		Utility_Functions.xWaitForElementPresent(driver, assignmentTypeOpportunity, 3);
		Utility_Functions.xClick(driver, assignmentTypeOpportunity, true);
		Utility_Functions.xWaitForElementPresent(driver, assignmentTypeValueOpportunity, 3);
		Utility_Functions.xClick(driver, assignmentTypeValueOpportunity, true);
		/*
		 * Utility_Functions.xWaitForElementPresent(driver,assignmentSubType,
		 * 3); Utility_Functions.xClick(driver,assignmentSubType, true);
		 * Utility_Functions.xWaitForElementPresent(driver,
		 * assignmentSubTypeValue, 3);
		 * Utility_Functions.xClick(driver,assignmentSubTypeValue, true);
		 */
		Utility_Functions.xWaitForElementPresent(driver, constructionType, 3);
		Utility_Functions.xClick(driver, constructionType, true);
		Utility_Functions.xWaitForElementPresent(driver, constructionTypeValue, 3);
		Utility_Functions.xClick(driver, constructionTypeValue, true);
		if ((dataTable.getData("General_Data", "TC_ID").contains("APACProjectManagerRequiredFieldsSalesStage04")
				|| (dataTable.getData("General_Data", "TC_ID").contains("APACProjectManagerRequiredFieldsSalesStage06")
						|| (dataTable.getData("General_Data", "TC_ID")
								.contains("APACProjectManagerRequiredFieldsSalesStage07"))))) {
			Utility_Functions.xWaitForElementPresent(driver, opportunityLocation, 3);
			Utility_Functions.xSendKeys(driver, opportunityLocation, dataTable.getData("General_Data", "City"));
		}
		Utility_Functions.xWaitForElementPresent(driver, siteArea, 3);
		Utility_Functions.xSendKeys(driver, siteArea, dataTable.getData("General_Data", "InstallmentAmount"));
		Utility_Functions.xWaitForElementPresent(driver, assignmentTypeOpportunity, 3);
		Utility_Functions.xWaitForElementPresent(driver, selectOpportunityCurrency, 3);
		Utility_Functions.xClick(driver, selectOpportunityCurrency, true);
		Utility_Functions.xWaitForElementPresent(driver, opportunityCurrencyValue, 3);
		Utility_Functions.xClick(driver, opportunityCurrencyValue, true);
		Utility_Functions.xWaitForElementPresent(driver, projectValue, 3);
		Utility_Functions.xSendKeys(driver, projectValue, dataTable.getData("General_Data", "Project Value"));
		Utility_Functions.xWaitForElementPresent(driver, consultancyFee, 3);
		Utility_Functions.xSendKeys(driver, consultancyFee, dataTable.getData("General_Data", "Consultancy Fee"));
		Utility_Functions.xWaitForElementPresent(driver, saveNewOpp, 3);
		Utility_Functions.xClick(driver, saveNewOpp, true);
		Utility_Functions.timeWait(5);
		if (details.isDisplayed()) {

			report.updateTestLog("Verify Required Fields at Sales Stage",
					"The opportunity is saved with the all the required fields for the sales stage", Status.PASS);
		} else {
			report.updateTestLog("Verify Required Fields at Sales Stage",
					"The opportunity is not saved with the all the required fields for the sales stage", Status.FAIL);
		}

	}

	/**
	 * Validating the Creation of opportunities with the record type DSF
	 * 
	 * @author Ramya
	 *
	 */
	public void validateOpportunitiesWithRecordTypeDSF() {
		Utility_Functions.xWaitForElementPresent(driver, menu_Opportunities, 4);
		Utility_Functions.xClick(driver, menu_Opportunities, true);
		Utility_Functions.xWaitForElementPresent(driver, newOpportunity, 3);
		Utility_Functions.xClick(driver, newOpportunity, true);
		Utility_Functions.timeWait(2);
		Utility_Functions.xSwitchtoFrame(driver, continueButton);
		Utility_Functions.xWaitForElementPresent(driver, selectOpportunityRecordType, 3);
		Utility_Functions.xClick(driver, selectOpportunityRecordType, true);
		Utility_Functions.xWaitForElementPresent(driver, opportunityDSFValue, 3);
		Utility_Functions.xClick(driver, opportunityDSFValue, true);
		Utility_Functions.xWaitForElementPresent(driver, continueButton, 3);
		Utility_Functions.xClick(driver, continueButton, true);
		Utility_Functions.timeWait(2);
		driver.switchTo().defaultContent();
		Utility_Functions.xWaitForElementPresent(driver, accountNameNewOpportunity, 4);
		Utility_Functions.xSendKeys(driver, accountNameNewOpportunity, "Test Automation_0101");
		Utility_Functions.xWaitForElementPresent(driver, accountNameNewOpp, 3);
		Utility_Functions.xClick(driver, accountNameNewOpp, true);
		Utility_Functions.xWaitForElementPresent(driver, leadSourceNewOpp, 3);
		Utility_Functions.xClick(driver, leadSourceNewOpp, true);
		Utility_Functions.xWaitForElementPresent(driver, leadSourceNewOppValue, 3);
		Utility_Functions.xClick(driver, leadSourceNewOppValue, true);
		System.out.println(Calendar.getInstance());
		DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
		Date date = new Date();
		Utility_Functions.xWaitForElementPresent(driver, closeDate_AS, 3);
		Utility_Functions.xSendKeys(driver, closeDate_AS, dateFormat.format(date).toString());
		Utility_Functions.xWaitForElementPresent(driver, estimatedGrossFeeCommissionValue, 3);
		Utility_Functions.xSendKeys(driver, estimatedGrossFeeCommissionValue,
				dataTable.getData("General_Data", "InstallmentAmount"));
		Utility_Functions.xWaitForElementPresent(driver, estimatedTransactionValue, 3);
		Utility_Functions.xSendKeys(driver, estimatedTransactionValue,
				dataTable.getData("General_Data", "InstallmentAmount"));
		Utility_Functions.xWaitForElementPresent(driver, saveNewOpp, 3);
		Utility_Functions.xClick(driver, saveNewOpp, true);
		Utility_Functions.timeWait(3);
	}

	public void opportunityTagging() {

		Utility_Functions.xClick(driver, menu_Opportunities, true);
		Utility_Functions.xWaitForElementPresent(driver, recentlyViewed, 3);
		Utility_Functions.xClick(driver, recentlyViewed, true);
		Utility_Functions.xWaitForElementPresent(driver, allActiveOpportunities, 3);
		Utility_Functions.xClick(driver, allActiveOpportunities, true);
		Utility_Functions.timeWait(6);
		Utility_Functions.xClick(driver, OpportunityList, true);
		Utility_Functions.timeWait(4);
		Utility_Functions.xSwitchtoFrame(driver, addTag);
		Utility_Functions.xClick(driver, addTag, true);
		Utility_Functions.xSendKeys(driver, privatetag, "ABCZVTR");
		Utility_Functions.xClickHiddenElement(driver, savePrivateTag);
		report.updateTestLog("Verify Opportunity Private Tags", "The Private tag is saved in Private Tag Page",
				Status.PASS);

	}
	
	/**
	 * Function for validating the CBRE 360 Field on Opportunity page layout
	 * 
	 * @author Haritha
	 */
	
	public void validateOpportunityCbre360Field() {
		SaveResult[] sResults = new CreateObjects(scriptHelper).createObject("Opportunity", "012i0000000405jAAA", "2000", "Square Feet", "APAC", "Australia", "Yes", null, null);
		boolean isStatus = new EstablishConnection(scriptHelper).saveResults(sResults);
		if (isStatus==true) {
			report.updateTestLog("Verify Home Page Tabs", "The opportunity is saved with the all the required fields",
					Status.PASS);
		} else {
			report.updateTestLog("Verify Home Page Tabs", "The opportunity is not saved with the all the required fields", Status.FAIL);
		}			
/*		selectNewOpportunity();
		Utility_Functions.xWaitForElementPresent(driver, oppName_AS, 3);
		Utility_Functions.xClick(driver, oppName_AS, true);
		Utility_Functions.xWaitForElementPresent(driver, oppName_AS, 3);
		Utility_Functions.xSendKeys(driver, oppName_AS,
				"Test Automation Opportunity_" + Utility_Functions.xGenerateAlphaNumericString());
		Utility_Functions.xWaitForElementPresent(driver, accountNameAssetOpp, 4);
		//sf_UtilityFunctions.selectObjectFromLookUpList();
		Utility_Functions.xSendKeys(driver, accountNameAssetOpp, "Test Automation_0105");
		Utility_Functions.timeWait(2);	
		accountNameAssetOpp.sendKeys(Keys.ARROW_DOWN);	
		accountNameAssetOpp.sendKeys(Keys.ENTER);
		Utility_Functions.timeWait(3);
		Utility_Functions.xWaitForElementPresent(driver, totalSizeAssetServices, 5);
		Utility_Functions.xSendKeys(driver, totalSizeAssetServices, dataTable.getData("General_Data", "InstallmentAmount"));
        Utility_Functions.xWaitForElementPresent(driver, unitOfMeasureAssetServices, 2);
        //sf_UtilityFunctions.selectStandardDropdownOption("Unit of Measure", "Square Feet");
        Utility_Functions.xClick(driver, unitOfMeasureAssetServices, true);
	    sf_UtilityFunctions.selectValueFromDropdownList(dropDownList, "Square Feet");
	    Utility_Functions.xWaitForElementPresent(driver, regionAssetServices, 3);
        sf_UtilityFunctions.selectStandardDropdownOption("Region", "APAC");
        Utility_Functions.xScrollWindow(driver);
        Utility_Functions.xWaitForElementPresent(driver, marketAssetServices, 3);
        Utility_Functions.xSelectDropdownByName(marketAssetServices, "Australia");
        Utility_Functions.xWaitForElementPresent(driver, cbre360, 3);
        sf_UtilityFunctions.selectStandardDropdownOption("CBRE 360", "Yes");
		System.out.println(Calendar.getInstance());
		DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
		Date date = new Date();
		Utility_Functions.xWaitForElementPresent(driver, closeDateAssetServices, 3);
		Utility_Functions.xSendKeys(driver, closeDateAssetServices, dateFormat.format(date).toString());
		Calendar calendar1 = Calendar.getInstance();
		calendar1.add(Calendar.DAY_OF_MONTH, -20);
		SimpleDateFormat dateFormat1 = new SimpleDateFormat("MM/dd/yyyy");
		System.out.println("Date : " + dateFormat1.format(calendar1.getTime()));
		Utility_Functions.xWaitForElementPresent(driver, salesStageAssetServices, 3);
		sf_UtilityFunctions.selectStandardDropdownOption("Sales Stage", "1-Target");
		Utility_Functions.xWaitForElementPresent(driver, saveOppAssetServices, 3);
		Utility_Functions.xClick(driver, saveOppAssetServices, true);
		Utility_Functions.timeWait(5);
		sf_UtilityFunctions.selectTabUIHeaders("Details");
		if (details.isDisplayed()) {
			report.updateTestLog("Verify Home Page Tabs", "The opportunity is saved with the all the required fields",
					Status.PASS);
		} else {
			report.updateTestLog("Verify Home Page Tabs",
					"The opportunity is not saved with the all the required fields", Status.FAIL);
		}	*/
	}
	
	/**
	 * Function for Validating the picklist values in Referral Recipient Business Line on Opportunities page
	 * 
	 * @author Haritha
	 */
	
	static ArrayList<String> referralRecipientBusinessLine = new ArrayList<String>();

	public void referralRecipientBusinessLine() {
		referralRecipientBusinessLine.add("Investment");
		referralRecipientBusinessLine.add("Property");
		referralRecipientBusinessLine.add("Advisory %26 Transaction");
		referralRecipientBusinessLine.add("Asset Services");		
		System.out.println("Referral Recipient Business Line Pick List values are " + referralRecipientBusinessLine);
	}

	
	public void validateReferralRecipientBusinessLine() {
		referralRecipientBusinessLine();
		List<String> referralRecipientBusinessLineValues = sf_UtilityFunctions.getPickListValues("Opportunity", "France_Consulting_Service", "Referral_Recipient_Business_Line__c");
		List<String> referralRecipientBusinessLineList = new ArrayList<String>();
		referralRecipientBusinessLineList = Utility_Functions.xValidatePickListValuesPage(referralRecipientBusinessLine, referralRecipientBusinessLineValues, "Reference Recipient Business Line pick list values");
		if (referralRecipientBusinessLineList.size()!=0) {
			report.updateTestLog("Verify Referral Recipient Business Line picklist values", "All the values are not present in the Referral Recipient Business Line :::" + referralRecipientBusinessLineList, Status.FAIL);
		} else {
			report.updateTestLog("Verify Referral Recipient Business Line picklist values", "All the values are present in the Referral Recipient Business Line Pick List ", Status.PASS);
		}	
	}
	
	/**
	 * Function for Validating the picklist values for Lead source & Reason field on Opportunities page
	 * 
	 * @author Haritha
	 */
	public void verifyPickListValuesFranceUser() {		
		sf_UtilityFunctions.verifyPickListValues("Fusion %2F Acquisition", "Opportunity", "France_Transaction_Demand_Agency", "Reason__c");	
		sf_UtilityFunctions.verifyPickListValues("Other", "Opportunity", "France_Transaction_Demand_Agency", "LeadSource");
	}
	
	/**
	 * Function for validating the Picklist Field on Opportunity page layout
	 * 
	 * @author Haritha
	 */
	
	public void validatePitchAlertDate() {
		selectNewOpportunity();
		Utility_Functions.timeWait(2);
		Utility_Functions.xSwitchtoFrame(driver, continueButton);
		Utility_Functions.xWaitForElementPresent(driver, selectOpportunityRecordType, 3);
		Utility_Functions.xClick(driver, selectOpportunityRecordType, true);
		Utility_Functions.xWaitForElementPresent(driver, franceConsultingAndService, 3);
		Utility_Functions.xClick(driver, franceConsultingAndService, true);
		Utility_Functions.xClick(driver, continueButton, true);
		Utility_Functions.timeWait(2);
		driver.switchTo().defaultContent();
		Utility_Functions.timeWait(2);
		Utility_Functions.xWaitForElementPresent(driver, opportunityName_AS, 3);
		Utility_Functions.xSendKeys(driver, opportunityName_AS,
				"Test Automation Opportunity_" + Utility_Functions.xGenerateAlphaNumericString());
		Utility_Functions.xWaitForElementPresent(driver, accountNameNewOpportunity, 4);
		Utility_Functions.xSendKeys(driver, accountNameNewOpportunity, "Test");
		Utility_Functions.timeWait(2);
		accountNameNewOpportunity.sendKeys(Keys.ARROW_DOWN);
		Utility_Functions.timeWait(2);
		accountNameNewOpportunity.sendKeys(Keys.ENTER);
		System.out.println(Calendar.getInstance());
		DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
		Date date = new Date();
		Utility_Functions.xWaitForElementPresent(driver, closeDate_AS, 3);
		Utility_Functions.xSendKeys(driver, closeDate_AS, dateFormat.format(date).toString());
		Utility_Functions.xWaitForElementPresent(driver, leadSourceNewOpp, 3);
		Utility_Functions.xClick(driver, leadSourceNewOpp, true);
		Utility_Functions.timeWait(2);
		sf_UtilityFunctions.selectValueFromDropdownList(dropDownList,"Advertising board");
		Utility_Functions.xWaitForElementPresent(driver, salesStagePitch, 3);
		Utility_Functions.xClick(driver, salesStagePitch, true);
		Utility_Functions.timeWait(2);
		sf_UtilityFunctions.selectValueFromDropdownList(dropDownList,"Qualification");
		Utility_Functions.xWaitForElementPresent(driver, estimatedGrossFeeCommissionValue, 3);
		Utility_Functions.xSendKeys(driver, estimatedGrossFeeCommissionValue,
				dataTable.getData("General_Data", "InstallmentAmount"));
		Utility_Functions.xWaitForElementPresent(driver, saveNewOpp, 3);
		Utility_Functions.xClick(driver, saveNewOpp, true);
		Utility_Functions.timeWait(5);
		sf_UtilityFunctions.clickOnDetailAction("Pitch Alert");
		Utility_Functions.xWaitForElementPresent(driver, savePitchAlert, 3);
		Utility_Functions.xClick(driver, savePitchAlert, true);
		Utility_Functions.xScrollWindowToElement(driver, pitchAlertDate);
		String accountName = pitchAlertDate.getText();
		if(accountName.contains("")) {
			report.updateTestLog("Verify Pitch Alert Date", "Pitch Alert Date was auto-populated:::", Status.PASS);
		}
		else
		{
			report.updateTestLog("Verify Pitch Alert Date", "Pitch Alert Date wasn't auto-populated:::", Status.FAIL);
		}
	}
	
	/**
	 * Function for validating the Sales Stage Closed Value on Opportunity page layout
	 * 
	 * @author Haritha
	 */
	public void salesStageClosedValue() {	
		boolean isStatus = new EstablishConnection(scriptHelper).getStageValues("Opportunity", "05-Closed", "StageName");	
		if(isStatus==true) {
			report.updateTestLog("Opportunity Sales Stage", "Opportunity Sales Stage has the value:::", Status.PASS);
		}
		else {
			report.updateTestLog("Opportunity Sales Stage", "Opportunity Sales Stage doesn't has the value:::", Status.FAIL);
		}
	}
	
	/**
	 * Function for validating the Delete option on all opportunities page
	 *
	 *@author Haritha
	 */
	public void deleteCreatedOpportunity() {
		selectNewOpportunity();
		Utility_Functions.timeWait(5);
		Utility_Functions.xSwitchtoFrame(driver, selectOpportunityRecordType);
		Utility_Functions.xClick(driver, selectOpportunityRecordType, true);
		Utility_Functions.xSelectDropdownByName(selectOpportunityRecordType, "EMEA A&T Investor");
		Utility_Functions.xClick(driver, continueButton, true);
		Utility_Functions.timeWait(2);
		driver.switchTo().defaultContent();
		Utility_Functions.xWaitForElementPresent(driver, opportunityName_AS, 5);
		Utility_Functions.xClick(driver, opportunityName_AS, true);
		Utility_Functions.xSendKeys(driver, opportunityName_AS,
				"Test Automation Opportunity_" + Utility_Functions.xGenerateAlphaNumericString());
		
		Utility_Functions.xWaitForElementPresent(driver, accountNameNewOpportunity,3);
		Utility_Functions.xClick(driver, accountNameNewOpportunity, true);			
		Utility_Functions.timeWait(3);
		accountNameNewOpportunity.sendKeys(Keys.ARROW_DOWN);	
		Utility_Functions.timeWait(2);
		accountNameNewOpportunity.sendKeys(Keys.ENTER);
		Utility_Functions.timeWait(2);
		Utility_Functions.xWaitForElementPresent(driver, estimatedGrossFeeCommissionValue, 5);
		Utility_Functions.xSendKeys(driver, estimatedGrossFeeCommissionValue,
				dataTable.getData("General_Data", "InstallmentAmount"));
		System.out.println(Calendar.getInstance());
		DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
		Date date = new Date();
		Utility_Functions.xWaitForElementPresent(driver, closeDateEmea, 3);
		Utility_Functions.xSendKeys(driver, closeDateEmea, dateFormat.format(date).toString());
		Utility_Functions.xWaitForElementPresent(driver, salesStageEmea, 3);
		//Utility_Functions.xClick(driver, salesStageEmea, true);
		sf_UtilityFunctions.selectStandardDropdownOption("Sales Stage", "Target");
		Utility_Functions.xWaitForElementPresent(driver, saveStageOpp, 3);
		Utility_Functions.xClick(driver, saveStageOpp, true);
		
		Utility_Functions.timeWait(10);
		sf_UtilityFunctions.oneAppNavigationTab("Opportunities");
		Utility_Functions.xSwitchtoFrame(driver, firstShowActions);
		//Utility_Functions.xWaitForElementPresent(driver, showActions, 3);
		Utility_Functions.xClickHiddenElement(driver, firstShowActions);
		if ((dataTable.getData("General_Data", "TC_ID").contains("EMEA"))){
		Utility_Functions.xWaitForElementPresent(driver, deleteAction, 3);
		Utility_Functions.xClick(driver, deleteAction, true);
		Utility_Functions.xWaitForElementPresent(driver, deleteOpportunity, 3);
		Utility_Functions.xClick(driver, deleteOpportunity, true);
		report.updateTestLog("Deletion of an Opportunity", "Opportunity was successfuly deleted", Status.PASS);
		}else {
			report.updateTestLog("Deletion of an Opportunity", "Opportunity wasn't deleted", Status.FAIL);
		}
		
		
	}
	
	
	/**
	 * Select Opportunity Record Type
	 * 
	 * @author Rajashekar Nallapati
	 * @Date : 07/03/2018
	 * 
	 */

	@FindBy(xpath = "//select[@id='record-type-select']")
	WebElement opptyRecordType;

	public void selectOpptRecordType(String OpptRecordType) {
		Utility_Functions.timeWait(3);
		Utility_Functions.xSwitchtoFrame(driver, opptyRecordType);
		Utility_Functions.xSelectDropdownByName(opptyRecordType, OpptRecordType);
		report.updateTestLog("Verify display of record type: " + OpptRecordType, OpptRecordType + "is displaying",
				Status.PASS);
		Utility_Functions.xClick(driver, continueButton, true);
		driver.switchTo().defaultContent();
		Utility_Functions.timeWait(3);
	}

	/**
	 * Validating association of multiple properties to an opportunity of record
	 * type "APAC Broker"
	 * 
	 * @author Rajashekar Nallapati
	 * @Date : 07/03/2018
	 * @Release : R49
	 * @UserStory : 275050 - APAC: [Production Bug] Associate Property error
	 * 
	 * 
	 */
	
	@FindBy(xpath = "//span[text()='Property']/parent::a/parent::h2/parent::div/parent::header/following-sibling::div//*[text()='New']")
	WebElement propertyNew;
	
	@FindBy(xpath = "//input[@title='Search Properties']")
	WebElement propertyInput;
	
	@FindBy(xpath = "//span[text()='Existing Property']/parent::label/parent::div/input")
	WebElement existingProperty;

	public void associatePropertyFromOpportunity() {
		selectNewOpportunity();
		selectOpptRecordType("APAC Occupier");
		createOpportunity("test");
		Utility_Functions.timeWait(3);
		Utility_Functions.xClick(driver, related, true);
		Utility_Functions.timeWait(3);
		Utility_Functions.xScrollWindowToElement(driver, propertyNew);
		if (Utility_Functions.getText(driver, propertyNew).equals("New")) {
			report.updateTestLog("Verify New button in Property related tab section", "New button is displaying",
					Status.PASS);
		} else {
			report.updateTestLog("Verify New button in Property related tab section", "New button is not displaying",
					Status.FAIL);
		}
		Utility_Functions.xClick(driver, propertyNew, true);
		Utility_Functions.timeWait(3);
		Utility_Functions.xSendKeys(driver, propertyInput, "test");
		propertyInput.sendKeys(Keys.ARROW_DOWN);
		propertyInput.sendKeys(Keys.ENTER);
		Utility_Functions.timeWait(2);
		Utility_Functions.xClick(driver, existingProperty, true);
		Utility_Functions.xClick(driver, finalPropertyCheckbox, true);

		if (saveButtonProperty.isDisplayed()) {
			Utility_Functions.xClick(driver, saveButtonProperty, true);
			report.updateTestLog("Verify Opportunity", "Associate property to an opportunity successfully ",
					Status.PASS);
		} else {
			report.updateTestLog("Verify Opportunity", "Associate property to an opportunity failed ", Status.FAIL);
		}

	}

	/**
	 * Create opportunity type "APAC Broker"
	 * 
	 * @author Rajashekar Nallapati
	 * @Date : 07/05/2018
	 * @Release : R49
	 * @UserStory : 275050 - APAC: [Production Bug] Associate Property error
	 * 
	 */

	@FindBy(xpath = "//a[@title='Occupier Buyer']")
	WebElement OccupierBuyerAssignmentType;
	
	
	private void createOpportunity(String sAccountName) {
		// TODO Auto-generated method stub
		Utility_Functions.xSendKeys(driver, accountName, sAccountName);
		accountName.sendKeys(Keys.ARROW_DOWN);
		accountName.sendKeys(Keys.ENTER);
		Utility_Functions.timeWait(2);
		Utility_Functions.xScrollWindow(driver);
		Utility_Functions.xWaitForElementPresent(driver, leadSourceNewOpp, 3);
		Utility_Functions.xClick(driver, leadSourceNewOpp, true);
		Utility_Functions.xWaitForElementPresent(driver, leadSourceNewOppValue, 3);
		Utility_Functions.xClick(driver, leadSourceNewOppValue, true);

		Utility_Functions.xWaitForElementPresent(driver, assignmentTypeOppValue, 3);
		Utility_Functions.xClick(driver, assignmentTypeOppValue, true);
		Utility_Functions.xWaitForElementPresent(driver, OccupierBuyerAssignmentType, 3);
		Utility_Functions.xClick(driver, OccupierBuyerAssignmentType, true);

		DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
		Date date = new Date();
		Utility_Functions.xScrollWindow(driver);
		Utility_Functions.xScrollWindowToElement(driver, closeDate_AS);
		Utility_Functions.xWaitForElementPresent(driver, closeDate_AS, 2);
		Utility_Functions.xSendKeys(driver, closeDate_AS, dateFormat.format(date).toString());
		Utility_Functions.xSendKeys(driver, closeDate_AS, Keys.TAB);

		Utility_Functions.xClick(driver, save, true);
		report.updateTestLog("Opportunity Created", "Clicked on Opportunity save button successfully:::", Status.PASS);
		Utility_Functions.timeWait(3);
	}

	/**
	 * EMEA Property sales - Sell Side - Opportunity
	 * 
	 * 
	 * @author Rajashekar Nallapati
	 * @Date : 07/12/2018
	 * @Release : R50
	 * @UserStory : 282546:EMEA: Property Sales - Sell Side - Creating new
	 *            Opportunity
	 * 
	 */

	public void EMEAPropertySalesSellSidePageLayout() {

		// **************************************************************************************************

		// EMEA Property Sales Sell Side - Opportunity page Labels
		String[] opptLabels = { "Opportunity Name", "Account Name", "Lead Source", "Primary Contact", "Assignment Type",
				"Investment Profile", "Assignment Sub-Type", "Parent Opportunity", "Conversion Type", "Comments",
				"Conversion Type Other", "Pitch Date", "Description", "Estimated Transaction Value",
				"Confidential Opportunity", "Yield (%)", "Confidential Information", "Yield/Return Type",
				"Opportunity Currency", "Probability (%)", "Mandate Agreement Status", "Sales Stage",
				"Engagement Commencement", "Close Date", "Engagement Expiration", "Settlement/Completion Date",
				"Appointment Type", "Condition of Sale", "Total Size", "% Occupied", "Reason for Loss", "Competitor",
				"Reason Lost Comments" };

		// Clicks on New button
		selectNewOpportunity();
		// Selects Opportunity record type based on parameter text
		selectOpptRecordType("EMEA Property Sales - Sell Side");
		Utility_Functions.timeWait(5);

		List<WebElement> opptLabelElements = driver.findElements(By.xpath(
				"//div[@class='modal-container slds-modal__container']/div[2]//*[contains(@class,'form-element__label')]/span[1]"));
		int opptLabelsCount = Utility_Functions.xValidateFieldsPresentPage(Arrays.asList(opptLabels), opptLabelElements,
				"Oppt account labels");
		System.out.println(opptLabelsCount);
		if (opptLabelsCount > 33) {
			report.updateTestLog("EMEA Property sales Sell Side Opportunity page layout",
					"all fields are not displaying", Status.FAIL);
		}

		// **************************************************************************************************

		// Lead source pick list values

		String[] leadSourcePickListValues = { "(Ext) Business Relationship (Non CBRE)",
				"(Ext) Marketing Activity (Broker Led)", "(Ext) Marketing/Research (Central)", "(Ext) MSA Referral",
				"(Ext) Personal Relationship", "(Ext) Client Networking Event", "(Ext) Repeat Business (Non Referred)",
				"A&T - Investor Leasing (Industrial)", "A&T - Investor Leasing (Office)",
				"A&T - Investor Leasing (Retail)", "A&T - Occupier Transactions (Industrial)",
				"A&T - Occupier Transactions (Office)", "A&T - Occupier Transactions (Retail)",
				"A&T - Portfolio & Location", "A&T - Portfolio Services", "A&T - Retail Analytics",
				"A&T - Supply Chain", "A&T - Workplace", "APAC Referral", "Building Consultancy", "Capital Advisors",
				"Capital Markets", "Client Solutions", "Hotels", "Land & Development", "Lease Consultancy", "PJM",
				"Planning", "Rating", "Residential", "US Referral", "Valuations", "Asset Services", "Capital Advisors",
				"GWS", "Other", "Residential", "Retail", "RFP/Proposal/Pitch" };

		// Lead source pick list values validation
		sf_UtilityFunctions.verifyPickListValues(Arrays.asList(leadSourcePickListValues), "Opportunity",
				"EMEA_Property_Sales_Sell_Side", "LeadSource");

		// **************************************************************************************************

		// Assignment type pick list value validation
		String[] assignmentTypePickListValues = { "Purchase", "Sale", "Sale & Purchase" };
		sf_UtilityFunctions.verifyPickListValues(Arrays.asList(assignmentTypePickListValues), "Opportunity",
				"EMEA_Property_Sales_Sell_Side", "Service__c");

	}

	public void EMEAPropertySalesSellSideOpptCreation() {
		// Clicks on New button
		selectNewOpportunity();
		// Selects Opportunity record type based on parameter text
		selectOpptRecordType("EMEA Property Sales - Sell Side");
		Utility_Functions.timeWait(5);

		String sAccountName = searchTextSOQL.fetchRecord("Account", "Name");
		opportunityCreationPopUp(sAccountName);

	}
	
	

}
