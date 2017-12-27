package pageObjects;

import java.math.BigDecimal;
import java.awt.AWTException;
import java.awt.Robot;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
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
import org.openqa.selenium.support.ui.Select;

import com.cognizant.Craft.ReusableLibrary;
import com.cognizant.Craft.ScriptHelper;
import com.cognizant.framework.FrameworkException;
import com.cognizant.framework.Status;
import com.sforce.soap.partner.PartnerConnection;
import com.sforce.soap.partner.QueryResult;
import com.sforce.soap.partner.SaveResult;
import com.sforce.soap.partner.sobject.SObject;
import com.sforce.ws.ConnectionException;
import com.sforce.ws.ConnectorConfig;
import com.sun.glass.events.KeyEvent;

import pagesAPI.EstablishConnection;
import pagesAPI.OpportunitiesFunctions;
import pagesAPI.SearchTextSOQL;
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
		// new WebDriverUtil(driver);
		// Utility_Functions utility = new Utility_Functions(scriptHelper);
	}

	@FindBy(xpath = "//div[@class='bBottom']//span[text()='Home']")
	WebElement menu_home;

	@FindBy(xpath = "//div[@class='bBottom']//span[text()='Opportunities']")
	WebElement menu_Opportunities;

	@FindBy(xpath = "//div[@class='bBottom']//span[text()='Accounts']")
	WebElement menu_Accounts;

	@FindBy(xpath = "//div[@class='slds-truncate'][@title='Sharing'][text()='Sharing']")
	WebElement sharingButton;

	@FindBy(xpath = "//p[text()='Opportunity Sharing']")
	WebElement opportunitySharing;

	@FindBy(xpath = "//div[contains(@title, 'Add')]")
	WebElement addButton;

	@FindBy(xpath = "//input[@name='new'][contains(@value,'Add')]")
	WebElement addButtonSharing;

	@FindBy(xpath = "//a[contains(text(),'Create')]")
	WebElement createNewLink;

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

	@FindBy(xpath = "//div[@class='mainBody']//span[contains(text(), 'Total Size')]/parent::div/parent::div/div[2]/div/span")
	WebElement totalSize;

	@FindBy(xpath = "//div[@class='mainBody']//span[contains(text(), 'Preferred Property Type')]/parent::div/parent::div/div[2]/div/span")
	WebElement preferredPropertyType;

	@FindBy(xpath = "//div[@class='mainBody']//span[contains(text(), 'Lease From')]/parent::div/parent::div/div[2]/div/span")
	WebElement leaseFrom;

	@FindBy(xpath = "//div[@class='mainBody']//span[contains(text(), 'Lease To')]/parent::div/parent::div/div[2]/div/span")
	WebElement leaseTo;

	@FindBy(xpath = "//div[@class='mainBody']//span[contains(text(), 'Lease Term (Months)')]/parent::div/parent::div/div[2]/div/span")
	WebElement leaseTerm;

	@FindBy(xpath = "//div[@class='mainBody']//span[contains(text(), 'Lease Rate/Rent')]/parent::div/parent::div/div[2]/div/span")
	WebElement leaseRate;

	@FindBy(xpath = "//div[@class='mainBody']//span[contains(text(), 'Lease Rate/Rent Basis')]/parent::div/parent::div/div[2]/div/span")
	WebElement leaseRateRentBasis;

	@FindBy(xpath = "//a[@class='forceActionLink']/div[@class='slds-truncate'][text()='Edit']")
	WebElement edit;

	@FindBy(xpath = "//div[@class='select-options']/ul/li")
	WebElement occupierLease;

	@FindBy(xpath = "//span[@class='label inputLabel uiPicklistLabel-left form-element__label uiPicklistLabel']/span[text()='Assignment Type']i")
	WebElement assignmentType;

	@FindBy(xpath = "//div[@class='select-options']/ul[@role='presentation']/li")
	WebElement selectStage;

	@FindBy(css = ".modal-footer [title='Save']")
	WebElement save;

	@FindBy(css = ".modal-footer [title='Cancel']")
	WebElement cancel;

	@FindBy(xpath = "//div[@class='slds-media']//input[@value='Save']")
	WebElement saveButton_AB;
	
	@FindBy(xpath = "//span[contains(@class,'virtualAutocompleteOptionText')][text()='All Active Opportunities']")
	WebElement allOpportunities;

	@FindBy(xpath = ".modal-footer [title='Save & New']")
	WebElement saveAndNew;

	@FindBy(xpath = "//div[@class='toastContent']//span[@class='slds-icon_container slds-icon-utility-success toastIcon slds-button__icon forceIcon']")
	WebElement opportunitySaved;

	@FindBy(xpath = "//div[@class='slds-truncate'][text()='New']")
	WebElement newOpportunity;

	@FindBy(xpath = "//button[text()='Continue']")
	WebElement continueButton;

	@FindBy(xpath = "//button/span[text()='View All Fields']")
	WebElement viewAllFieldsButton;

	@FindBy(xpath = "//*[contains(@id,'oppForm:oppName')]")
	WebElement opportunityName;

	@FindBy(xpath = "//*[contains(@id,'oppForm:salesStage')]")
	WebElement salesStage;

	@FindBy(xpath = "//*[contains(@id,'oppForm:phaseField')]")
	WebElement phaseField;

	@FindBy(xpath = "//*[contains(@id,'oppForm:probabilityField')]")
	WebElement probabilityField;

	@FindBy(xpath = ".//span[text()='Sales Stage']")
	WebElement salesStageLabel;

	@FindBy(xpath = "//span[text()='Total Size']/parent::div/parent::div/div[2]/div/span")
	WebElement totalSizeValue;

	@FindBy(xpath = "//span[text()='Preferred Property Type']/parent::div/parent::div/div[2]/div/span")
	WebElement preferredPropertyTypeValue;

	/*
	 * @FindBy(xpath =
	 * "//*[text()='Clone']/parent::a/parent::li/parent::ul/li/a/div[text()='Edit']")
	 * WebElement editButton;
	 */

	@FindBy(xpath = "//li[contains(@class,'slds-button slds-button--neutral slds-truncate')]//a[@class='forceActionLink']/div[@class='slds-truncate'][text()='Edit']")
	WebElement editButton;

	@FindBy(xpath = "//label[@class='label inputLabel uiLabel-left form-element__label uiLabel']/span[text()='Opportunity Name']/parent::label/parent::div/input")
	WebElement opportunityNameUpdate;

	@FindBy(xpath = ".//button[@class='slds-button slds-button--neutral uiButton--default uiButton--brand uiButton forceActionButton']/span[text()='Save']")
	WebElement saveOpportunityUpdate;

	/*
	 * @FindBy(xpath = "//*[text()='Sales Stage']/parent::li/p[2]/span")
	 * WebElement currentSalesStage;
	 * 
	 * @FindBy(xpath = "//li[@class='uiMenuItem uiRadioMenuItem'][17]")
	 * WebElement selectSalesStage;
	 */

	@FindBy(xpath = "//*[text()='Save & New']/parent::button/parent::div/button[3]/span[text()='Save']")
	WebElement saveButtonSalesStage;

	@FindBy(xpath = "//a[@class='tabHeader']//span[text()='Related']")
	WebElement related;

	/*
	 * @FindBy(xpath =
	 * "//article[contains(@class,'Property')]//div[text()='Associate Property']"
	 * ) WebElement associateProperty;
	 */

	@FindBy(xpath = "//span[contains(text(),'Property')]//ancestor::article//div[text()='Associate Property']")
	WebElement associateProperty;

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

	@FindBy(xpath = ".//label[@class='label inputLabel uiLabel-left form-element__label uiLabel']/span[contains(text(),'Estimated Gross Fee/Commission')]/parent::label/parent::div/input")
	WebElement estimatedGrossFeeField;

	@FindBy(xpath = "//tr[contains(@class,'parent')][1]//input[contains(@id,'acctSearchBox')]")
	WebElement user1;

	@FindBy(xpath = "//tr[contains(@class,'parent')][2]//input[contains(@id,'acctSearchBox')]")
	WebElement user2;
	
	@FindBy(xpath = "//tr[contains(@class,'parent')][3]//input[contains(@id,'acctSearchBox')]")
	WebElement user3;

	@FindBy(xpath = "//input[@id='acctSearchBox2'][@class='tt-search-box slds-input tt-input']")
	WebElement userField1;

	@FindBy(xpath = "//input[@id='acctSearchBox3'][@class='tt-search-box slds-input tt-input']")
	WebElement userField2;

	@FindBy(xpath = "//select[@class='slds-select']/option[@value='Team Member']")
	WebElement selectTeamRole;

	@FindBy(xpath = "//select[@class='slds-select']/option[@value='Originating Broker']")
	WebElement selectSecondaryMemberRole;

	@FindBy(xpath = "//select[@class='slds-select']/option[@value='Edit']")
	WebElement selectOpportunityAccess;

	@FindBy(xpath = "//table[@class='slds-table slds-no-row-hover']//tr[2]/td[3]//option[@value='Revenue Partner']")
	WebElement selectTeamRole2;
	
	@FindBy(xpath = "//select[contains(@name,'TeamMemberForm:j_id51:2')]/option[@value='Team Support']")
	WebElement selectTeamRole3;

	@FindBy(xpath = "//table[@class='slds-table slds-no-row-hover']//tr[2]/td[4]//option[@value='Receiving Broker']")
	WebElement selectSecondaryMemberRole2;

	@FindBy(xpath = "//div[contains(@class, 'slds-truncate') and text()='Manage Opportunity Splits']")
	WebElement manageOpportunitySplits;

	@FindBy(xpath = "//button[text()='Save']")
	WebElement saveOpportunitySplit;

	@FindBy(xpath = "//input[@value='Save']")
	WebElement saveOpportunitySplitUAT;

	@FindBy(xpath = "//td[contains(@data-label,'Split Percent')]//input")
	WebElement splitPercent;

	@FindBy(xpath = "//input[@value= 'Save']")
	WebElement saveButtonSplit;

	@FindBy(xpath = "//span[text()='Press Delete to Remove']/parent::a/span[@class='deleteIcon']")
	WebElement deleteAccountName;

	@FindBy(xpath = "//input[@placeholder='Search Accounts']")
	WebElement enterNewAccountName;

	@FindBy(xpath = "//div[@class='dotSpinner']")
	WebElement dotSpinner;

	@FindBy(xpath = "//h1//span[text()='Recently Viewed']")
	WebElement recentlyViewed;

	@FindBy(xpath = "//span[contains(@class,'virtualAutocompleteOptionText')][text()='All Active Opportunities']")
	WebElement allActiveOpportunities;

	@FindBy(xpath = "//span[contains(@class,'virtualAutocompleteOptionText')][text()='All Accounts']")
	WebElement allAccounts;

	@FindBy(xpath = "//h2[contains(@id,'title')]")
	WebElement title;

	@FindBy(xpath = "//input[@id='acctSearchBox']")
	WebElement accountName;

	@FindBy(xpath = "//p[contains(@class,'slds-page-header__title')][@title='Add an Opportunity'][text()='Add an Opportunity']")
	WebElement addAnOpportunityTitle;

	@FindBy(xpath = "//select[contains(@id,'assignmentType')]")
	WebElement assignmentTypeOpp;

	@FindBy(xpath = "//select[contains(@id,'salesStage')]")
	WebElement salesStageOpp;

	@FindBy(xpath = "//label[text()='Reason for Loss']/parent::div//select")
	WebElement reasonForLossOpp;

	@FindBy(xpath = "//label[text()='Reason Lost Comments']/parent::div//div/textarea")
	WebElement reasonForLossOppText;

	@FindBy(xpath = "//select[contains(@id,'assignmentType')]//option[@selected='selected']")
	WebElement assignmentTypeOppValue;

	@FindBy(xpath = "//input[contains(@id,'closeDate')]")
	WebElement closeDateOpp;

	@FindBy(xpath = "//input[contains(@id,'close') and contains(@id,'Date')]")
	WebElement closeDateOppSpell;

	@FindBy(xpath = "//span[text()='Total Size']/parent::div//input")
	WebElement totalSizeOpp;

	@FindBy(xpath = "//span[text()='Unit of Measure']/parent::div//select")
	WebElement unitofMeasure;

	@FindBy(xpath = "//span[contains(text(),'Commission')]/parent::span//input")
	WebElement estimatedGrossFee;

	@FindBy(xpath = "//label[contains(text(),'Lead Source')]/parent::div//select")
	WebElement leadSource;

	@FindBy(xpath = "//span[contains(text(),'Preferred')][contains(text(),'Property')]/parent::div//select")
	WebElement preferredPropertyTypeOpp;

	@FindBy(xpath = "//div[contains(@class,'slds-media__body')]//input[@value='Save']")
	WebElement saveNewOpportunity;

	@FindBy(xpath = "h1[contains(@class,'slds-page-header__title')]//span[contains(text(),'-')]")
	WebElement newOpportunityName;

	@FindBy(xpath = "//table[contains(@class,'forceRecordLayout')]//span[contains(@class,'forceOutputCurrency')]")
	WebElement installmentAmount;

	@FindBy(xpath = "//table[contains(@class,'forceRecordLayout')]//tr[1]//span[contains(@class,'forceOutputCurrency')]")
	WebElement installmentAmountOne;

	@FindBy(xpath = "//table[contains(@class,'forceRecordLayout')]//tr[2]//span[contains(@class,'forceOutputCurrency')]")
	WebElement installmentAmountTwo;

	@FindBy(xpath = "//span[text()='Opportunity Installments']/parent::span[text()='View All']")
	WebElement installmentsViewAll;

	@FindBy(xpath = "//nav[@role='navigation']/ol[contains(@class,'slds-breadcrumb')]/li[2]")
	WebElement opportunityNameLink;

	@FindBy(xpath = "//table[contains(@class,'forceRecordLayout')]//tr[3]//span[contains(@class,'forceOutputCurrency')]")
	WebElement installmentAmountThree;

	@FindBy(xpath = "//li[contains(@class,'oneActionsDropDown')]//a")
	WebElement showMoreActions;

	@FindBy(xpath = "//a[contains(@title,'Recalculate')]")
	WebElement recalculate;

	@FindBy(xpath = "//a[contains(@title,'New') and contains(@title,'Installment')]")
	WebElement newOpportunityInstallment;

	@FindBy(xpath = "//input[contains(@id,'opportunityRefractorPageLightningForm') and contains(@id,'Quantity')]")
	WebElement installmentQuantity;

	@FindBy(xpath = "//*[@id='Page:opportunityRefractorPageLightningForm:saveButton']")
	WebElement proceed;

	@FindBy(xpath = "//*[@id='Page:opportunityRefractorPageLightningForm:ContinueButton']")
	WebElement continueButtonInstallment;

	@FindBy(xpath = "//div[contains(@class,'actionsContainer')]//div[text()='Edit']")
	WebElement editButtonInstallment;

	@FindBy(xpath = "//div[@class='slds-form-element__control']//span[text()='Estimated Gross Fee/Commission']/parent::label/parent::div/input")
	WebElement estimatedGrossFeeEdit;

	@FindBy(xpath = "//span[@class='slds-form-element__label'][text()='Estimated Gross Fee/Commission']/parent::span//input")
	WebElement estimatedGrossFeeEdit_AB;

	@FindBy(xpath = "//div[@class='slds-form-element__control']//span[text()='Installment Number']/parent::label/parent::div/input")
	WebElement installmentNumber;

	@FindBy(xpath = "//div[@class='slds-form-element__control']//span[text()='Installment Amount']/parent::label/parent::div/input")
	WebElement editInstallmentAmount;

	@FindBy(xpath = "//div[@class='slds-form-element__control']//span[text()='Installment Date']/parent::label/parent::div/div/input")
	WebElement installmentDate;

	@FindBy(xpath = "//div[contains(@class,'modal-footer')]//span[text()='Save']")
	WebElement saveNewOpportunityInstallment;

	@FindBy(xpath = "//span[@class='uiOutputNumber'][text()='1']/ancestor::tr//div[contains(@class,'forceVirtualActionMarker')]//a")
	WebElement arrowDown;

	@FindBy(xpath = "//div[@class='actionMenu']//a[@title='Delete']")
	WebElement deleteInstallment;

	@FindBy(xpath = "div[contains(@class,'slds-modal__footer')]//button[@title='Delete']")
	WebElement deleteButton;

	@FindBy(xpath = "//h2[text()='Quick Create: Agency Brokerage']")
	WebElement agencyBrokerageFrame;

	@FindBy(xpath = "//span[text()='Installment Status']/parent::span/parent::div//a")
	WebElement installmentOption;

	@FindBy(xpath = "//div[@class='select-options']/ul/li[contains(@class,'uiMenuItem') and contains(@class,'uiRadioMenuItem')]/a[@title='Paid']")
	WebElement installmentStatus;

	@FindBy(xpath = "//span[text()='Date Paid']/parent::label/parent::div//input")
	WebElement datePaid;

	@FindBy(xpath = "//span[text()='Account Role']/parent::span/parent::div//a")
	WebElement accountRoleOption;

	@FindBy(xpath = "//div[@class='select-options']/ul/li[contains(@class,'uiMenuItem') and contains(@class,'uiRadioMenuItem')]/a[@title='Developer']")
	WebElement accountRole;

	@FindBy(xpath = "//span[text()='Installment Amount']/parent::label/parent::div//input")
	WebElement installmentAmountEdit;

	@FindBy(xpath = "//span[text()='Opportunity Name']/parent::label/parent::div//input")
	WebElement opportunityName_AS;

	@FindBy(xpath = "//span[text()='Area']/parent::label/parent::div//input")
	WebElement totalSize_AS;

	@FindBy(xpath = "//a[@aria-label='Unit of Measure']")
	WebElement unitofMeasure_AS;

	@FindBy(xpath = "//a[@title='Square Feet']")
	WebElement unitofMeasureValue_AS;

	@FindBy(xpath = "//a[@aria-label='Type']")
	WebElement type_AS;

	@FindBy(xpath = "//a[@title='New Business']")
	WebElement typeNewBusiness_AS;

	@FindBy(xpath = "//a[@aria-label='Region']")
	WebElement region_AS;

	@FindBy(xpath = "//a[@title='APAC']")
	WebElement regionValue_AS;
	
	@FindBy (xpath ="//label/span[text()='Close Date']")
	WebElement CloseDateEditOpportunity;
	
	@FindBy (xpath ="//*[contains(@class,'today slds-s')]")
	WebElement DateTodayEdit;

	/*
	 * @FindBy(xpath =
	 * "//span[text()='Sales Stage']/parent::label/parent::div//a") WebElement
	 * salesStage_AS;
	 * 
	 * @FindBy(xpath = "//a[@title='2-Client Engaged']") WebElement
	 * salesStageValue_AS;
	 * 
	 * @FindBy(xpath =
	 * "//span[text()='Close Date']/parent::label/parent::div//input")
	 * WebElement closeDate_AS;
	 * 
	 * @FindBy(xpath = "//input[@placeholder='Search Accounts']") WebElement
	 * accountName_AS;
	 */

	@FindBy(xpath = "//span[text()='Market']/parent::label/parent::div//option[1]")
	WebElement market_AS;

	@FindBy(xpath = "//select[@id='record-type-select']/option[@selected='selected']")
	WebElement defaultOpportutnityRecordType;

	/*
	 * @FindBy(xpath =
	 * "//div[@class='slds-form-element']/span[text()='Opportunity Record Type']/parent::div/div/span"
	 * ) WebElement opportunityRecordTypeByDefault;
	 */

	@FindBy(xpath = "//h2[contains(text(),'EMEA') and contains(text(),'Occupier')]")
	WebElement opportunityRecordTypeByDefault;

	@FindBy(xpath = "//h2[contains(@class,'slds-text-heading--medium') and contains(@class,'slds-m-bottom--small')]")
	WebElement opportunityRecordTypeQuickCreate;

	@FindBy(xpath = "//span[text()='Property']/ancestor::article//div[text()='New']")
	WebElement associatePropertyCapitalMarkets;

	@FindBy(xpath = "//input[contains(@placeholder,'Search Properties')]")
	WebElement searchProperties;

	@FindBy(xpath = "//span[contains(@class,'toastMessage') and contains(@class,'slds-text-heading--small')]")
	WebElement opportunityPropertyCreated;

	@FindBy(xpath = "//h2[@id='header']//span[1]")
	WebElement headerSectionsOpp;

	/****
	 * Ramya
	 */
	@FindBy(xpath = "//a[contains(@title,'Show') and contains(@title,'more actions')]")
	WebElement selectNewEvent;

	@FindBy(xpath = "//div[@class='forceActionLink'][@title='New Event']")
	WebElement newEvent;

	@FindBy(xpath = "//div[@class='slds-media__body']")
	WebElement addAnEventPage;

	@FindBy(xpath = "//input[@class='slds-input'][@type='text'][@required='required']")
	WebElement subject;

	@FindBy(xpath = "//*[@id='assignedToBox']")
	WebElement assignedTo;

	@FindBy(xpath = "//input[@value='Cancel']")
	WebElement cancelCustomEventPageButton;

	@FindBy(xpath = "//input[@value='Save & New Event']")
	WebElement saveAndNewEventCustomEventPageButton;

	@FindBy(xpath = "//input[@value='Save Event']")
	WebElement saveEventCustomEventPageButton;

	@FindBy(xpath = "//span[text()='Quick Create an Event']")
	WebElement quickCreateanEvent;

	@FindBy(xpath = " //div[@class='slds-col--padded slds-size--1-of-1 slds-medium-size--1-of-1 slds-large-size--1-of-2']/h2")
	WebElement relatedTo;

	@FindBy(xpath = "//input[@class='slds-input'][@type='checkbox']")
	WebElement setReminderCheckBox;

	@FindBy(xpath = ".//*[@id='assignedToBox']")
	WebElement assignedToNewCustomEventPage;

	@FindBy(xpath = "//input[contains(@id,'StartDate')]")
	WebElement startDateNewCustomEventPage;

	@FindBy(xpath = "//input[contains(@id,'StartTime')]")
	WebElement startTimeNewCustomEventPage;

	@FindBy(xpath = "//input[contains(@id,'EndDate')]")
	WebElement endDateNewCustomEventPage;

	@FindBy(xpath = "//input[contains(@id,'EndTime')]")
	WebElement endTimeNewCustomEventPage;

	@FindBy(xpath = "//*[@id='record-type-select']")
	WebElement opportunityRecordType;

	@FindBy(xpath = "//*[@id='record-type-select']/option[text()='Capital Markets – Property Sales']")
	WebElement opportunityRecordTypeValuePropertySales;

	@FindBy(xpath = "//*[@id='record-type-select']/option[text()='APAC Landlord and Sale Pursuits']")
	WebElement opportunityRecordTypeValueAPACLandlord;

	@FindBy(xpath = "//*[@id='record-type-select']/option[text()='Capital Markets – Debt & Structured Finance']")
	WebElement opportunityRecordTypeDebtStructuredFinance;

	@FindBy(xpath = "//*[@id='record-type-select']/option[text()='APAC Global Workplace Solutions']")
	WebElement opportunityRecordTypeGlobalWorkplaceSolutions;

	@FindBy(xpath = "//*[@id='record-type-select']/option[text()='EMEA BC&P']")
	WebElement opportunityRecordTypeBCP;

	@FindBy(xpath = "//div/a[@class='select'][text()='Occupier Lease']")
	WebElement assignmentTypeEditPage;

	@FindBy(xpath = "//span[text()='Unit of Measure']/parent::span/parent::div/parent::div//a[text()='Assets']")
	WebElement unitOfMeasureDefaultValue;

	@FindBy(xpath = "//span[contains(text(),'Region')]/parent::span/parent::div//a")
	WebElement regionMenu;

	@FindBy(xpath = "//span[text()='Opportunity Currency']")
	WebElement opportunityCurrency;

	@FindBy(xpath = "//a[@aria-label='Reason for Loss']")
	WebElement reasonForLoss;

	@FindBy(xpath = "//div[@class='select-options']//a[@title='Client Action Postponed']/parent::li/parent::ul/li")
	WebElement reasonForLossValuesList;

	@FindBy(xpath = "//a[@aria-label='Accounting Awarded To:']")
	WebElement accountingAwardedTo;

	@FindBy(xpath = "//a[@aria-label='Mgmt Awarded To:']")
	WebElement mgmtAwardedTo;

	@FindBy(xpath = "//label[@class='label inputLabel uiLabel-left form-element__label uiLabel']/span[text()='Term of Contract']/parent::label/parent::div/input")
	WebElement termOfContract;

	@FindBy(xpath = "//a[@aria-label='Lead Source']")
	WebElement leadSourceNewOpportunity;

	@FindBy(xpath = "//label[@class='label inputLabel uiLabel-left form-element__label uiLabel']/span[text()='Opportunity Name']/parent::label/parent::div/input")
	WebElement opportunityNameNewOpportunity;

	@FindBy(xpath = "//label[@class='label inputLabel uiLabel-left form-element__label uiLabel']/span[text()='Total Size']/parent::label/parent::div/input")
	WebElement totalSizeNewOpportunity;

	@FindBy(xpath = "//a[@aria-label='Unit of Measure']")
	WebElement unitOfMeasureNewOpportunity;

	@FindBy(xpath = "//a[@title='Square Feet']")
	WebElement selectUnitOfMeasureNewOpportunity;

	@FindBy(xpath = "//a[@aria-label='Region']")
	WebElement regionNewOpportunity;

	@FindBy(xpath = "//a[@title='US National']")
	WebElement selectRegionNewOpportunity;

	@FindBy(xpath = "//select[@class=' select']/option[@value='Dallas/Ft. Worth']")
	WebElement selectMarket;

	/*
	 * @FindBy(xpath="//input[@placeholder='Search Accounts']") WebElement
	 * searchAccountsNewOpportunity;
	 */

	@FindBy(xpath = "//input[contains(@placeholder,'Search Accounts')]")
	WebElement searchAccountsNewOpportunity;

	@FindBy(xpath = "//label[@class='label inputLabel uiLabel-left form-element__label uiLabel']/span[text()='Sales Stage']")
	WebElement salesStageNewopportunity;

	@FindBy(xpath = "//a[@class='select'][text()='1-Target']")
	WebElement selectSalesStageNewOpportunity;

	@FindBy(xpath = "//div[@class='form-element']/a[@class='datePicker-openIcon display']/span[text()='Date Picker']")
	WebElement closeDateCreateopportunity;

	@FindBy(xpath = "//div[@class='uiDatePickerGrid--default uiDatePickerGrid']/table/thead/tr/th[4]")
	WebElement selectCloseDateCreateOpportunity;

	@FindBy(xpath = "//label[@class='label inputLabel uiLabel-left form-element__label uiLabel']/span[text()='Capital Markets Revenue']/parent::label/parent::div/input")
	WebElement capitalRevenueFieldNewOpportunity;

	@FindBy(xpath = "//span[text()='Sales Stage']/parent::label/parent::div//a")
	WebElement salesStage_AS;

	@FindBy(xpath = "//a[@title='2-Client Engaged']")
	WebElement salesStageValue_AS;

	@FindBy(xpath = "//span[text()='Close Date']/parent::label/parent::div//input")
	WebElement closeDate_AS;

	@FindBy(xpath = "//input[@placeholder='Search Accounts']")
	WebElement accountName_AS;

	@FindBy(xpath = "//button[@class='slds-button slds-button--neutral uiButton--default uiButton--brand uiButton forceActionButton']/span[text()='Save']")
	WebElement saveNewOpportunity_AS;

	@FindBy(xpath = "//label[@class='label inputLabel uiLabel-left form-element__label uiLabel']/span[text()='Est. EBITDA ($) - Won']/parent::label/parent::div/input")
	WebElement newOpportunityEBITDAWon;

	@FindBy(xpath = "//label[@class='label inputLabel uiLabel-left form-element__label uiLabel']/span[text()='Est. EBITDA ($) - Lost']/parent::label/parent::div/input")
	WebElement newOpportunityEBITDALost;

	@FindBy(xpath = "//label[@class='label inputLabel uiLabel-left form-element__label uiLabel']/span[text()='Est. EBITDA ($)']/parent::label/parent::div/input")
	WebElement newOpportunityEBITDA;

	@FindBy(xpath = "//div[@class='slds-form-element']/label[contains(text(),'Specialty Group')]")
	WebElement specialityGroup;

	@FindBy(xpath = "//select[@class='slds-select']/option[@value='Occupier Buyer']")
	WebElement selectAssignmentType;

	@FindBy(xpath = "//span[text()='RFP Due Date']/parent::label/parent::div//input")
	WebElement rfpDueDate;

	@FindBy(xpath = "//span[text()='Pitch Date']/parent::label/parent::div//input")
	WebElement pitchDueDate;

	@FindBy(xpath = "//span[text()='Average Annual Leasing Commission']/parent::label/parent::div//input")
	WebElement annualAverageLeasingCommission;

	@FindBy(xpath = "//span[contains(text(),'Preferred Property Type')]/span/abbr[text()='*']")
	WebElement preferedPropertyTypeRequiredField;

	@FindBy(xpath = "//li[contains(text(),'Preferred Property Type: You must enter a value')]")
	WebElement errorMessageForPreferedPropertyType;

	@FindBy(xpath = "//a[@aria-label='Leasing']")
	WebElement leasing;

	@FindBy(xpath = "//a[@aria-label='Leasing'][text()='No']")
	WebElement selectleasing;

	@FindBy(xpath = "//div[@class='select-options']/ul/li[3]/a[@title='No']")
	WebElement noOption;

	@FindBy(xpath = "//label[contains(@class,'label') and contains(@class,'inputLabel') and contains(@class,'uiLabel-left') and contains(@class,'form-element__label') and contains(@class,'uiLabel')]/span[contains(text(),'Probability (%)')]/parent::label/parent::div/input")
	WebElement successProbability;

	@FindBy(xpath = "//select[contains(@id,'oppForm:salesStage')]/option[@selected='selected']")
	WebElement salesStageSelected;

	@FindBy(xpath = "//select[contains(@id,'oppForm:salesStage') or contains(@id,'oppForm:stage')]/option[@value='']")
	WebElement salesStageSelectedEMEA;

	/*
	 * @FindBy(xpath=
	 * "//select[contains(@id,'oppForm:salesStage')]/option[@selected='selected']")
	 * WebElement salesStageSelectedCapitalMarkets;
	 */

	@FindBy(xpath = "//span[contains(@id,'oppForm:phaseField')]/span")
	WebElement phasePresent;

	@FindBy(xpath = "//div[contains(@class,'error strength') and contains(@class,'forceMessage')]//p[contains(text(),'Looks like')]")
	WebElement accessOpportunity;

	@FindBy(xpath = "//div[@class='slds-truncate'][@title='Edit']")
	WebElement opportunityEdit;

	@FindBy(xpath = "//a[@aria-label='Assignment Type']")
	WebElement assignmentTypeOpportunity;

	@FindBy(xpath = "//a[@role='menuitemradio'][text()='Sale']")
	WebElement assignmentTypeSaleOpportunity;

	@FindBy(xpath = "//label[contains(@class,'label inputLabel')]/parent::div//a[@class='select']")
	WebElement salesStageOppClosed;

	@FindBy(xpath = "//div[@class='select-options']//a[contains(@title,'08-Closed')]")
	WebElement salesStageOppClosedOption;

	@FindBy(xpath = "//div[contains(@class,'modal-footer')]//button[@title='Save']")
	WebElement saveStageOpp;

	@FindBy(xpath = "//span[contains(@class,'genericError')]")
	WebElement reviewErrors;

	@FindBy(xpath = "//span[text()='Estimated Transaction Value']/parent::label/parent::div/input")
	WebElement estimatedTransactionValue;

	@FindBy(xpath = "//span[text()='Estimated Gross Fee/Commission']/parent::label/parent::div/input")
	WebElement estiamtedGrossFeeCommissionValue;

	@FindBy(xpath = "//span[text()='Final Transaction Value']/parent::label/parent::div/input")
	WebElement finalTransactionValue;

	@FindBy(xpath = "//span[text()='Actual CBRE Gross Fee']/parent::label/parent::div/input")
	WebElement ActualCBREGrossFeeValue;

	@FindBy(xpath = "//button[text()='Add']")
	WebElement addButtonshareOpportunity;

	@FindBy(xpath = "//span[text()='Technology Tools']")
	WebElement technologyToolsField;

	@FindBy(xpath = "//label[@class='label inputLabel uiLabel-left form-element__label uiLabel']/span[text()='Targeting Initiative']/parent::label/parent::div/select/option[@value='US Retail Strike']")
	WebElement targetingInitiativeField;

	@FindBy(xpath = "//input[contains(@id,'oppForm:closeDate')]")
	WebElement closeDateNewOpportunity;

	@FindBy(xpath = "//select[contains(@id,'oppForm:salesStage')]")
	WebElement salesStageEMEANewOpportunity;

	@FindBy(xpath = "//select[contains(@id,'oppForm:salesStage')]/option[@value='Target']")
	WebElement salesStageEMEANewOpportunityValue;

	@FindBy(xpath = "//div[@class='slds-form-element']//span[text()='Estimated Gross Fee/Commission']/parent::div/input")
	WebElement salesStageEMEAEstimatedGrossCommission;

	@FindBy(xpath = "//label[text()='Assignment Type']")
	WebElement assignmentTypeField;

	@FindBy(xpath = "//label[contains(text(),'Lead Source')]")
	WebElement leadSourceField;

	@FindBy(xpath = "//label[text()='Comments']")
	WebElement opportunityComments;

	@FindBy(xpath = "//span[text()='Pitch Advisor']")
	WebElement pitchAdvisor;

	@FindBy(xpath = "//span[text()='Average Annual Leasing Commission']")
	WebElement averageAnnualLeasingCommission;

	@FindBy(xpath = "//span[text()='Unit of Measure']/parent::div/select[contains(@id,'oppForm')]")
	WebElement unitOfMeasure;

	@FindBy(xpath = "//input[contains(@id,'oppForm:oppName')][@value='TBD']")
	WebElement OppName;

	@FindBy(xpath = "//h2[@id='header']/a/span[text()='Opportunity Installments']")
	WebElement opportunityInstallments;

	@FindBy(xpath = "//button[@title='Edit Installment Status']")
	WebElement editInstallmentStatus;

	@FindBy(xpath = "//textarea[@role='textbox']")
	WebElement commentsField;

	@FindBy(xpath = "//button[@title='Edit Installment Status']/parent::div")
	WebElement installmentStatusEditOpportunity;

	@FindBy(xpath = "//a[@title='Pending']")
	WebElement installmentStatusValue;

	@FindBy(xpath = "//section[@class='tabs__content active uiTab']//button/span[text()='Save']")
	WebElement saveEditOpportunity;

	@FindBy(xpath = "//div[contains(@class,'active')]//a/div[@title='Edit']")
	WebElement editOpportunity;

	@FindBy(xpath = "//select[@id='record-type-select']")
	WebElement selectOpportunityRecordType;

	@FindBy(xpath = "//select[@id='record-type-select']/option[@value='012i0000000tvTeAAI']")
	WebElement selectOpportunityRecordTypeValue;

	@FindBy(xpath = "//input[@id='userAdvisorSearchBox']")
	WebElement pitchAdvisorField;

	@FindBy(xpath = "//span[contains(@class,'virtualAutocompleteOptionText')][text()='My Active Listings']")
	WebElement myActiveListings;

	@FindBy(xpath = "//button[@title='Show filters']")
	WebElement toggleFilters;

	@FindBy(xpath = "//button[@title='Display as Table']")
	WebElement squareTable;

	@FindBy(xpath = "//span[text()='Kanban']")
	WebElement kanban;

	@FindBy(xpath = "//span[@class='fieldLabel'][text()='Opportunity Record Type']")
	WebElement opportunityRecordTypeFilters;

	@FindBy(xpath = "//span[@class='fieldLabel'][text()='Phase']")
	WebElement phaseFilters;

	@FindBy(xpath = "//label[text()='Property Market Value']")
	WebElement propertyMarketValue;

	@FindBy(xpath = "//select[contains(@id,'record-type-select')]")
	WebElement selectRecordType;

	@FindBy(xpath = "//select[contains(@id,'record-type-select')]/option[text()='APAC Capital Markets – Debt & Structured Finance']")
	WebElement recordTypeValue;

	@FindBy(xpath = "//select[contains(@id,'record-type-select')]/option[text()='APAC Property Sales']")
	WebElement recordTypePropertySalesValue;

	@FindBy(xpath = "//span[text()='Unit of Measure']")
	WebElement unitOfMeasureLabel;

	@FindBy(xpath = "//label[text()='CBRE Market Group']")
	WebElement marketGroup;

	@FindBy(xpath = "//label[text()='CBRE Submarket Group']")
	WebElement subMarketGroup;

	@FindBy(xpath = "//select[contains(@id,'oppForm:salesStage')]/option[@value='Prospecting']")
	WebElement salesStageValue;

	@FindBy(xpath = "//span[contains(@id,'oppForm:pgMsg')]/ul/li[contains(text(),'Please fill out CBRE Market Group')]")
	WebElement marketGroupMandatory;

	@FindBy(xpath = "//div[@title='APAC Property Test - Test CM']")
	WebElement propertyValue;

	@FindBy(xpath = "//div[@title='01BQ2Q8NMECBRE Test SFDC Automation_0401']")
	WebElement searchAccountValue;

	@FindBy(xpath = "//a[@title='01-Prospect']")
	WebElement selectStageValue;

	@FindBy(xpath = "//a[@title='Business Relationship']")
	WebElement leadSourceValue;

	@FindBy(xpath = "//a[contains(@title,'Create Offer')]")
	WebElement createOffer;

	@FindBy(xpath = "//input[contains(@placeholder,'Search Contacts')] ")
	WebElement offerorContact;

	@FindBy(xpath = "//div[contains(@class,'secondaryLabel')][@title='AUCAPACBroker123']")
	WebElement offerorContactValue;

	@FindBy(xpath = "//input[contains(@placeholder,'Search Accounts')]")
	WebElement offerorAccount;

	@FindBy(xpath = "//div[@title='AUCAPACBroker123']/following-sibling::div[@title='2100 Ross Avenue, Dallas, United States']")
	WebElement offerorAccountValue;

	@FindBy(xpath = "//span[contains(text(),'Offer Price')]/parent::label/parent::div/input")
	WebElement offerPrice;

	@FindBy(xpath = "//div[contains(@class,'slds-modal__footer')]//span[text()='Save']")
	WebElement createOfferSave;

	@FindBy(xpath = "//a[contains(@title,'New Task')]")
	WebElement newTask;

	@FindBy(xpath = "//a[@class='forceActionLink']/div[@class='slds-truncate'][text()='Clone']")
	WebElement clone;

	@FindBy(xpath = "//div[@title='Test UOM Auckland Broker']")
	WebElement propertyValue2;

	@FindBy(xpath = "//div[@title='Test Account APAC']")
	WebElement accountValue2;

	@FindBy(xpath = "//article[contains(@class,'forceRelatedListCardDesktop')]//span[text()='Offers']")
	WebElement offers;

	@FindBy(xpath = "//p[@title='Offer Opportunity']")
	WebElement offerOpportunity;

	@FindBy(xpath = "//p[@title='Offer Property']")
	WebElement offerProperty;

	@FindBy(xpath = "//p[@title='Offer Enquiry']")
	WebElement offerEnquiry;

	@FindBy(xpath = "//p[@title='Offeror Account']")
	WebElement offerorAccountHeader;

	@FindBy(xpath = "//p[@title='Offeror Contact']")
	WebElement offerorContactHeader;

	@FindBy(xpath = "//p[@title='Offer Date']")
	WebElement offerDate;

	@FindBy(xpath = "//div/p[text()='031EHXL93ZQT9CKTQD786WCN0']")
	WebElement accountNameValue;

	@FindBy(xpath = "//span[text()='Estimated Gross Fee/Commission']/following-sibling::div[@class='requiredInput']/input")
	WebElement estimatedGrossFeeNewOpportunity;

	@FindBy(xpath = "//label[contains(text(),' Discretionary Fee')]/following-sibling::div/label/span[contains(@class,'checkbox')]")
	WebElement discretionaryFeeCheckBox;

	@FindBy(xpath = "//label[contains(text(),'Discretionary Amount')]/following-sibling::div/input")
	WebElement discretionaryAmount;

	@FindBy(xpath = "//label[contains(text(),'Conversion Type')]/following-sibling::div/div/select")
	WebElement conversionType;

	@FindBy(xpath = "//select[contains(@id,'oppForm:salesStage')]/option[@value='Prospecting']")
	WebElement salesStageNewOppValue;

	@FindBy(xpath = "//select[contains(@id,'cbreMarketGroup')]")
	WebElement cbreMarketGroup;

	@FindBy(xpath = "//select[contains(@id,'cbreMarketGroup')]/option[@value='City']")
	WebElement cbreMarketGroupValue;

	@FindBy(xpath = "//span[contains(@id,'pgMsg')]//li[contains(text(),'Please fill out Total Size')]")
	WebElement errorMessage;
	
	@FindBy (xpath = "//*[@id='Page:opportunityRefractorPageLightningForm:slds-Amount']")
	WebElement InstallmentAmountEdit;

	@FindBy(xpath = "//label[contains(text(),' Total Size')]/following-sibling::input")
	WebElement totalSizeNewOpp;

	@FindBy(xpath = "//span[contains(text(),'Sales Stage')]/parent::label/following-sibling::div//a[contains(@class,'select')]")
	WebElement salesStageEditOpp;

	@FindBy(xpath = "//div[contains(@class,'select-options')]/ul/li[5]/a[contains(text(),'Executing')]")
	WebElement salesStageEditOppValue;

	@FindBy(xpath = "//div[contains(@class,'slds-modal__footer')]//button[@title='Save']")
	WebElement saveEditOpp;

	@FindBy(xpath = "//span[contains(text(),'Total Size')]/parent::label/following-sibling::input")
	WebElement totalSizeEditOpp;

	@FindBy(xpath = "//select[contains(@id,'oppForm:salesStage')]/option[text()='19-Closed']")
	WebElement salesStageNewOpportunityValueClosed;

	@FindBy(xpath = "//span[text()='Preferred Property Type']/following-sibling::div/div/select")
	WebElement preferedPropertyType;

	@FindBy(xpath = "//span[text()='Preferred Property Type']/following-sibling::div/div/select/option[@value='Hotel']")
	WebElement preferedPropertyTypeValue;

	@FindBy(xpath = "//span[text()='Total Size']/following-sibling::div//input")
	WebElement totalSizeOpportunityQuickCreate;

	@FindBy(xpath = "//select[contains(@id,'assignmentType')]/option[@value='Consulting']")
	WebElement assignmentTypeOppValueClone;

	@FindBy(xpath = "//select[contains(@id,'oppForm:salesStage')]/option[text()='02-Meeting']")
	WebElement salesStageNewOpportunityValue;

	@FindBy(xpath = "//a[contains(text(),'Closed')]")
	WebElement salesStageEditOpportunityValue;

	@FindBy(xpath = "//label[contains(text(),'Lead Source')]/parent::div//select/option[@value='Business Relationship']")
	WebElement leadSourceValueNewOpportunity;

	@FindBy(xpath = "//span[contains(text(),'Net Fee')]/parent::label/following-sibling::input")
	WebElement netFeeOpportunityEdit;

	@FindBy(xpath = "//a[contains(@title,'New Installment')]")
	WebElement newInstallment;

	@FindBy(xpath = "//span[contains(text(),'Installment Amount')]/parent::label/parent::div//input")
	WebElement installmentAmountNewOpportunityInstallment;

	@FindBy(xpath = "//div[contains(@class,'slds-modal__footer')]/button/span[text()='Save']")
	WebElement newInstallmentSave;

	@FindBy(xpath = "//a[@class='tabHeader']//span[text()='Details']")
	WebElement details;

	@FindBy(xpath = "//button[contains(text(), 'Add')]")
	WebElement addButtonOpportunitySharing;

	@FindBy(xpath = "//span[contains(text(),'Lease From')]/parent::label/parent::div//input")
	WebElement leaseFromEditOpportunity;

	@FindBy(xpath = "//span[contains(text(),'Lease To')]/parent::label/parent::div//input")
	WebElement leaseToEditOpportunity;

	@FindBy(xpath = "//span[contains(text(),'Lease Term (Months)')]/parent::label/following-sibling::input")
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

	@FindBy(xpath = "//select[contains(@id,'assignmentType')]//option[@value='Consulting']")
	WebElement assignmentTypeValueNewOpp;

	@FindBy(xpath = "//span[contains(text(),'Remarks')]/parent::label/following-sibling::textarea")
	WebElement remarks;

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

	@FindBy(xpath = "//span[contains(text(),'Conversion Type')]/parent::span/following-sibling::div//a[contains(@class,'select')]")
	WebElement emeaConversionType;

	@FindBy(xpath = "//a[contains(@title,'Pitch')]")
	WebElement emeaConversionTypeValue;

	@FindBy(xpath = "//span[contains(text(),'Pitch Date')]/parent::label/parent::div//input")
	WebElement pitchDate;

	@FindBy(xpath = "//span[contains(text(),'Address Line 1')]/parent::label/following-sibling::input")
	WebElement addressLine1;
	
	@FindBy(xpath = "//span[contains(text(),'Address Line 2')]/parent::label/following-sibling::input")
	WebElement addressLine2;

	@FindBy(xpath = "//span[contains(text(),'City')]/parent::label/following-sibling::input")
	WebElement city;

	@FindBy(xpath = "//span[contains(text(),'Postcode')]/parent::label/following-sibling::input")
	WebElement postCode;

	@FindBy(xpath = "//span[contains(text(),'CBRE Market Group')]/parent::span/following-sibling::div//a[contains(@class,'select')]")
	WebElement cbreMarketGroupEMEA;

	@FindBy(xpath = "//a[contains(@title,'City')]")
	WebElement cbreMarketGroupEMEAValue;

	@FindBy(xpath = "//*[text()='More']")
	WebElement menu_More;

	@FindBy(xpath = "//a[@role='menuitem']/span[contains(@class,'slds-truncate')][text()='Campaigns']")
	WebElement campaigns;

	@FindBy(xpath = "//span[contains(@class,'virtualAutocompleteOptionText')][text()='All Active Campaigns']")
	WebElement allActiveCampaigns;

	@FindBy(xpath = "//span[contains(text(),'Offers')]/ancestor::article//div[text()='New']")
	WebElement offersNew;

	@FindBy(xpath = "//span[contains(text(),'Project Enquiries')]/ancestor::article//div[text()='New']")
	WebElement projectEnquiries;

	@FindBy(xpath = "//div[contains(text(),'APAC Property Sale Offers')]/parent::div/parent::label//span[@class='slds-radio--faux']")
	WebElement offersRadioButton;

	@FindBy(xpath = "//span[text()='Next']")
	WebElement offersNextButton;

	@FindBy(xpath = "//span[contains(@class,'slds-truncate')][text()='Properties']")
	WebElement menu_Properties;

	@FindBy(xpath = "//div[@class='overflowList']//a[@title='Properties'][text()='Properties']")
	WebElement propertiesEnv;

	@FindBy(xpath = "//a[@role='menuitem']/span[contains(@class,'slds-truncate')][text()='Properties']")
	WebElement propertiesRecord;

	@FindBy(xpath = "//label[contains(text(),'Confidential Opportunity')]/parent::div//label[@class='slds-checkbox']/span[@class='slds-checkbox--faux']")
	WebElement confidentialCheckboxOpp;

	@FindBy(xpath = "//span[contains(text(),'Sales')][contains(text(),'Stage')]/parent::div//select")
	WebElement salesStageEMEAOpp;

	@FindBy(xpath = "//h1[contains(@class,'slds-page-header__title') and contains(@class,'slds-truncate')]/span")
	WebElement opportunityConfidentialName;

	@FindBy(xpath = "//span[text()='Estimated Gross Fee/Commission']/parent::div/div[@class='requiredInput']/input")
	WebElement estimatedGrossFeeCommissionEMEA;

	@FindBy(xpath="//span[contains(text(),'Opportunity Name')]/parent::label/following-sibling::input")
	WebElement opportunityNameAS;

	@FindBy(xpath="//span[text()='Total Size']/parent::label/following-sibling::input")
	WebElement totalSizeAS;

	@FindBy(xpath="//div[contains(@class,'primaryLabel')][contains(@title,'Test Account APAC')]")
	WebElement accountValue;

	@FindBy(xpath="//span[contains(text(),'Region')]/parent::span/following-sibling::div//a")
	WebElement regionAS;

	@FindBy(xpath="//option[contains(@value,'Dallas/Ft. Worth')]")
	WebElement marketValue;

	@FindBy(xpath="//a[contains(@title,'US National')]")
	WebElement regionValueAS;

	@FindBy(xpath="//span[contains(text(),'Leasing')]/parent::span/following-sibling::div//a[@aria-label='Leasing']")
	WebElement leasingAS;

	@FindBy(xpath="//span[contains(text(),'Consultancy')]/parent::span/following-sibling::div//a[@aria-label='Consultancy']")
	WebElement consultancyAS;

	@FindBy(xpath="//a[@title='Yes']")
	WebElement valueAS;

	@FindBy(xpath="//input[contains(@title,'Search Properties')]")
	WebElement targetProperty;

	@FindBy(xpath="//span[contains(text(),'Account Name')]/parent::label/following-sibling::div//input[contains(@title,'Search Accounts')]")
	WebElement accountNameNewOpportunity;

	@FindBy(xpath="//div[contains(@class,'primaryLabel')][@title='01R4597B21CBRE Test SFDC Automation_0401']")
	WebElement accountNameValueNewOpp;

	@FindBy(xpath="//span[contains(text(),'Lead Source')]/parent::span/following-sibling::div//a[contains(@aria-label,'Lead Source')]")
	WebElement leadSourceNewOpp;

	@FindBy(xpath="//a[contains(@title,'Business Relationship')]")
	WebElement leadSourceNewOppValue;

	@FindBy(xpath="//div[contains(@class,'primaryLabel')][contains(@title,'Test Automation Subject_G7XRIZ51NS - 2100 Ross Avenue')]")
	WebElement targetPropertyValue;

	@FindBy(xpath="//label[contains(text(),'Lease Period (in months)')]")
	WebElement leasePeriodNewOpportunity;

	@FindBy(xpath="//label[contains(text(),'Other Incentives')]")
	WebElement otherIncentivesNewOpportunity;

	@FindBy(xpath="//label[contains(text(),'Landlord & Tenant Act 1954')]")
	WebElement landlordTenantAct;

	@FindBy(xpath="//span[text()='Installment Date']/parent::div/following-sibling::div")
	WebElement installmentDateEditOpp;

	@FindBy(xpath="//span[contains(text(),'Engagement Commencement')]/following-sibling::div//input")
	WebElement engagementCommencement;

	@FindBy(xpath="//h2[@class='slds-text-heading--medium slds-m-top--x-large slds-m-bottom--large']")
	List<WebElement> headerList;

	@FindBy(xpath="//*[@class='slds-form-element__label']")
	List<WebElement> labelListOpportunitiesPage;

	@FindBy(xpath="//a[@class='slds-truncate outputLookupLink slds-truncate forceOutputLookup'][contains(@data-recordid,'006')]")
	List<WebElement> opportunitiesList;

	@FindBy(xpath="//a[@class='slds-truncate outputLookupLink slds-truncate forceOutputLookup'][contains(@data-recordid,'001')]")
	List<WebElement> accountsList;

/*	@FindBy(xpath="//div[@class='undefined lookup__menu uiAbstractList uiAutocompleteList uiInput uiAutocomplete uiInput--default uiInput--lookup']//div[@class='listContent']/ul/li")
	List<WebElement> propertiesList;*/

	@FindBy(xpath="//div[@class='select-options']//a[@title='Client Action Postponed']/parent::li/parent::ul/li")
	List<WebElement> reasonForLossValuesPickList;

	@FindBy(xpath="//div[@class='select-options']//a[@title='BNP']/parent::li/parent::ul/li")
	List<WebElement> awardedToList;
	
	@FindBy(xpath="//div[contains(@class,'primaryLabel')]/mark[contains(text(),'Test')]")
	WebElement offerorContactName;
	
	@FindBy(xpath="//div[contains(@class,'primaryLabel') and @title='Test Automation 0100']/following-sibling::div[contains(@title,'2100 Ross Avenue, Dallas, United States')]")
	WebElement offerorAccountName;
	
	@FindBy(xpath="//p/strong[contains(text(),'-963425397_Test Automation_0131')]")
	WebElement accountNameValueAdmin;
	
	@FindBy(xpath="//select[contains(@id,'oppForm:assignmentType')]/option[@value='Consulting']")
	WebElement assignmentTypeValue;
	
	@FindBy(xpath="//span[contains(text(),'Preferred Property Type')]/following-sibling::div/select")
	WebElement preferedPropertyTypeAdmin;
	
	@FindBy(xpath="//span[contains(text(),'Preferred Property Type')]/following-sibling::div/select/option[@value='Hotel']")
	WebElement preferedPropertyTypeValueAdmin;
	
	@FindBy(xpath="//select[@id='record-type-select']/option[contains(text(),'APAC Debt & Structured Finance')]")
	WebElement opportunityDSFValue;
	
	@FindBy(xpath="//div[contains(@class,'primaryLabel')][contains(@title,'Test Automation_0101')]")
	WebElement accountNameNewOpp;
	
	@FindBy(xpath="//button[contains(@class,'forceActionButton')]/span[text()='Save']")
	WebElement saveNewOpp;
	
	@FindBy(xpath="//span[contains(@class,'title')][contains(text(),'Activity')]")
	WebElement activity;
	
	@FindBy(xpath="//a[contains(@title,'Chatter')]//span[contains(text(),'Chatter')]")
	WebElement chatter;
	
	@FindBy(xpath="//input[contains(@id,'subject')]")
	WebElement subjectNewTask;
	
	@FindBy(xpath = "//select[@class='slds-select']/option[@value='Private - Client Intelligence']")
	WebElement activityType;
	
	@FindBy(xpath = "//input[contains(@id,'dueDate')]")
	WebElement newActivityDueDate;
	
	@FindBy(xpath="//input[contains(@id,'saveButton')]")
	WebElement saveActivity;
	
	
	@FindBy(xpath="//a[contains(@aria-label,'Opportunity Currency')]")
	WebElement selectOpportunityCurrency;
	
	@FindBy(xpath="//a[contains(@title,'Indian Rupee')]")
	WebElement opportunityCurrencyValue;
	
	@FindBy(xpath="//span[contains(text(),'City')]/parent::label/parent::div/input")
	WebElement opportunityCity;
	
	@FindBy(xpath="//span[text()='Assignment Start Date']/parent::label/parent::div//input")
	WebElement assignmentStartDate;
	
	@FindBy(xpath="//span[contains(text(),'CBRE Office')]/parent::span/following-sibling::div//a[contains(@aria-label,'CBRE Office')]")
	WebElement opportunityCBREOffice;
	
	@FindBy(xpath="//a[contains(@title,'India – Ahmedabad')]")
	WebElement opportunityCBREOfficeValue;
	
	@FindBy(xpath="//span[contains(text(),'Country')]/parent::span/following-sibling::div//a[contains(@aria-label,'Country')]")
	WebElement opportunityCountry;
	
	@FindBy(xpath="//a[(@title='India')]")
	WebElement opportunityCountryValue;
	
	@FindBy(xpath="//span[contains(text(),'Asset Type')]/parent::span/following-sibling::div//a[contains(@aria-label,'Asset Type')]")
	WebElement assetType;
	
	@FindBy(xpath="//a[@title='Office']")
	WebElement assetTypeValue;
	
	@FindBy(xpath="//div[@id='rlql-showAllShowLess']/a")
	WebElement showAll;
	
	@FindBy(xpath="//span[contains(@title,'Opportunity Field History')]")
	WebElement opportunityFieldHistory;
	
	@FindBy(xpath="//span[contains(@title,'Phase History ')]")
	WebElement phaseHistory;
	
	@FindBy(xpath="//a[contains(text(),'01-Intro Meeting / Relationship Building')]")
	WebElement salesStageDefaultValue;
	
	@FindBy(xpath="//li[contains(text(),'Please enter Assignment Start Date for Sales Stages 02-09')]")
	WebElement assignmentStartDateMandatory;
	
	@FindBy(xpath="//span[contains(text(),'Identification Date')]/parent::label/parent::div//input")
	WebElement identificationDate;
	
	@FindBy(xpath="//span[contains(text(),'Submission Date')]/parent::label/parent::div//input")
	WebElement submissionDate;
	
	@FindBy(xpath="//span[contains(text(),'Completion Date')]/parent::label/parent::div//input")
	WebElement completionDate;
	
	@FindBy(xpath="//span[contains(text(),'City Tier')]/parent::span/following-sibling::div//a[contains(@aria-label,'City Tier')]")
	WebElement cityTier;
	
	@FindBy(xpath="//a[contains(@title,'Tier 1')]")
	WebElement cityTierValue;
	
	@FindBy(xpath="//a[@title='Construction Management']")
	WebElement assignmentTypeValueOpportunity;
	
	@FindBy(xpath="//a[contains(@aria-label,'Assignment Sub-Type')]")
	WebElement assignmentSubType;
	
	@FindBy(xpath="//a[contains(@title,'PJM')]")
	WebElement assignmentSubTypeValue;
	
	@FindBy(xpath="//a[contains(@aria-label,'Construction Type')]")
	WebElement constructionType;
	
	@FindBy(xpath="//a[@title='New Build']")
	WebElement constructionTypeValue;
	
	@FindBy(xpath="//span[contains(text(),'Site Area')]/parent::label/parent::div//input")
	WebElement siteArea;
	
	@FindBy(xpath="//span[contains(text(),'Project Value')]/parent::label/parent::div//input")
	WebElement projectValue;
	
	@FindBy(xpath="//span[contains(text(),'Consultancy Fee')]/parent::label/parent::div//input")
	WebElement consultancyFee;
	
	@FindBy(xpath="//span[contains(text(),'Location')]/parent::label/parent::div//input")
	WebElement opportunityLocation;
	
	@FindBy(xpath="//span[contains(text(),'Opportunity Details')]/parent::label/parent::div//textarea")
	WebElement opportunityDetails;
	
	@FindBy(xpath="//span[contains(text(),'Outcome Date')]/parent::label/parent::div//input")
	WebElement outcomeDate;
	
	@FindBy(xpath="//a[contains(@title,'03-Proposal Submitted')][contains(text(),'03-Proposal Submitted')]")
	WebElement salesStageValue03;
	
	@FindBy(xpath="//a[contains(@title,'04-Shortlisted')][contains(text(),'04-Shortlisted')]")
	WebElement salesStageValue04;
	
	@FindBy(xpath="//a[contains(@title,'06-Contract Signed')][contains(text(),'06-Contract Signed')]")
	WebElement salesStageValue06;
	
	@FindBy(xpath="//a[contains(@title,'07-Project Completed')][contains(text(),'07-Project Completed')]")
	WebElement salesStageValue07;
	
	@FindBy(xpath="//div[contains(@class,'pbBottomButtons')]//input[contains(@id,'next')]")
	WebElement nextForJapan;
	
	@FindBy(xpath="//ul[@class='tabs__nav']//a[@title='New Event']")
	WebElement newEventOpp;

	@FindBy(xpath = "//a[contains(@title,'Automation')]")
	WebElement ExistingOpportunity;
	
	@FindBy(xpath="//*[@id='tag_edit_link']")
	WebElement addTag;
	
	@FindBy(xpath="//textarea[@id='ptag_edit_area']")
	WebElement privatetag;
	
	@FindBy(xpath="//input[@id='tag_save_btn']")
	WebElement savePrivateTag;
	
	@FindBy (xpath = "//*[contains(@title,'View records tagged')]")
	WebElement PrivateTagged;
	
	@FindBy (xpath = " //*[contains(@class,'entityNameTitle slds-breadcrumb__item slds-line-height--reset')]")
	WebElement PrivateTagPage;
	
	@FindBy(xpath = "//a[@class='slds-truncate outputLookupLink slds-truncate forceOutputLookup']")
	WebElement OpportunityList;
	
	@FindBy (xpath = "//*[contains(@id,'58578:0')]")
	WebElement EditGrossFee;
	
	@FindBy (xpath="//*[(@class='slds-icon_container slds-icon-utility-down')]")
	WebElement InstallmentIcon;
	
	@FindBy (xpath="//label/span[text()='Estimated Gross Fee/Commission']/parent::label/following-sibling::input")
	WebElement EditEstimatedGrossFee;
	
	@FindBy (xpath = "//*[@title='Save' and @class ='slds-button slds-button--neutral uiButton--default uiButton--brand uiButton forceActionButton']")
	WebElement SaveEditOpportunity;
	
	@FindBy (xpath = "//div/button[text()='Add']")
	WebElement AddTeamMember;
	
	@FindBy (xpath="//*[@id='acctSearchBox2']")
	WebElement SearchUserTeamRole;
	
	@FindBy (xpath="//td/input[contains(@id,'addTeamMemberForm:j_id51:0')]")
	WebElement TeamMemberDescription;
	
	@FindBy (xpath ="//span/select[contains(@id,'addTeamMemberForm:j_id51:0')]")
	WebElement TeamRole;
	
	@FindBy (xpath = "//td/select[contains(@id,'addTeamMemberForm:j_id51:0')]")
	WebElement SecondaryMemberRole;
	
	@FindBy (xpath="//*[@id='j_id0:addTeamMemberForm']/div[1]/input[1]")
	WebElement SaveTeamMember;
	
	@FindBy (xpath = "//*[(@title='Test Broker6')]")
    WebElement SelectTestBroker;
	
	


	HomePage hp = new HomePage(scriptHelper);
	SearchTextSOQL searchOpportunity = new SearchTextSOQL(scriptHelper);
	OpportunitiesFunctions opportunitiesFunctions = new OpportunitiesFunctions(scriptHelper);
	Actions actions = new Actions(driver.getWebDriver());
	EventPage eventPage = new EventPage(scriptHelper);
	ActivityPage activityPage = new ActivityPage(scriptHelper);
	/**
	 * Adding the Web Elements to the Label List
	 * 
	 * @author Vishnuvardhan
	 *
	 */

	static ArrayList<String> labelList = new ArrayList<String>();
	
	/**
	 * Selecting the Contact from a list of contacts
	 * 
	 * @author Cognizant
	 *
	 */

	public void selectOpportunity() {
		Utility_Functions.timeWait(1);
		Utility_Functions.xClick(driver, menu_Opportunities, true);
		Utility_Functions.timeWait(1);
		report.updateTestLog("Verify Create Activity Opportunity", "Opportunity are Displayed ", Status.PASS);
		Utility_Functions.xWaitForElementPresent(driver, recentlyViewed, 3);
		Utility_Functions.xClick(driver, recentlyViewed, true);
		report.updateTestLog("Verify Create Activity Opportunity", "Recently viewed Opportunity are Displayed ", Status.PASS);
		Utility_Functions.xWaitForElementPresent(driver, allOpportunities, 3);
		Utility_Functions.xClick(driver, allOpportunities, true);
		Utility_Functions.timeWait(7);
		report.updateTestLog("Verify Create Activity Opportunity", "All Opportunity are displayed successfully:::", Status.PASS);
		List<WebElement> contactList = driver
				.findElements(By.xpath("//a[@class='slds-truncate outputLookupLink slds-truncate forceOutputLookup']"));
		Utility_Functions.xclickRandomElement(contactList);
		Utility_Functions.timeWait(2);
	}

	public void labelsOpportunityPage() {
		labelList.add("Record Type");
		labelList.add("Account Name");
		labelList.add("Billing City");
		labelList.add("Billing Street");
		labelList.add("Billing State/Province");
		labelList.add("Billing Country");
		labelList.add("Billing Zip/Postal Code");
		labelList.add("Website");
		labelList.add("Phone");
		labelList.add("Industry");
		labelList.add("Account Name");
		labelList.add("Assignment Type");
		labelList.add("Assignment Sub-Type");
		labelList.add("Lead Source");
		labelList.add("Close Date");
		labelList.add("Total Size");
		labelList.add("Unit of Measure");
		labelList.add("Preferred Property Type");
		labelList.add("Preferred Property Sub-Type");
		labelList.add("Opportunity Name");
		labelList.add("Sales Stage");
		labelList.add("Phase");
		labelList.add("Probability (%)");
		labelList.add("Estimated Gross Fee/Commission");
		labelList.add("Currency");
		labelList.add("Requirement/Building Details");
		labelList.add("Speciality Group");
		labelList.add("Parent Opportunity");
		labelList.add("Cross Sell");
		labelList.add("Confidential Opportunity");
		labelList.add("Opportunity Location");
		labelList.add("Priority");
		labelList.add("Hire Date");
		labelList.add("Migrated Opportunity");
		labelList.add("Opportunity Record Type");
		labelList.add("On Hold");
		labelList.add("On Hold Date");
		labelList.add("On Hold Comments");
		labelList.add("Total # of Units");
		labelList.add("Unit of Comparison");
		labelList.add("Status Comments");
		labelList.add("Listing Type");
		labelList.add("Availability Date");
		labelList.add("Next Steps");
		labelList.add("Engagement Commencement");
		labelList.add("Engagement Expiration");
		labelList.add("% Commission");
		labelList.add("% Occupied");
		labelList.add("Outside Broker Company");
		labelList.add("Outside Broker Name");
		labelList.add("CBRE Role");
		labelList.add("Next Steps");
		labelList.add("Reason for Loss");
		labelList.add("Reason Lost Comments");
		labelList.add("Competitor");
		labelList.add("Opportunity Owner");
		labelList.add("External Deal ID");
		labelList.add("Existing Termination/Break Option");
		labelList.add("New Termination/Break Option");
		labelList.add("Lease From");
		labelList.add("Lease To");
		labelList.add("Lease Term (Months)");
		labelList.add("Lease Rate/Rent");
		labelList.add("Lease Rate/Rent Basis");
		labelList.add("Outside Broker Company");
		labelList.add("CBRE Role");
		System.out.println("Label List of Opportunity Page:::" + labelList);
		System.out.println("Total Labels present in Opportunity Page are:::" + labelList.size());

	}

	/**
	 * Adding the Web Elements to the Header Section List
	 * 
	 * @author Vishnuvardhan
	 *
	 */
	static ArrayList<String> headerSectionList = new ArrayList<String>();

	public void headerSectionOpportunityPage() {
		// headerSectionList.add("Quick Create");
		headerSectionList.add("Opportunity Information");
		headerSectionList.add("Services");
		headerSectionList.add("Close Information");
		headerSectionList.add("Loss Information");
		headerSectionList.add("System Information");
		System.out.println("Header Section Details present in the new account page are:: " + headerSectionList);
	}

	/**
	 * Validating the New Opportunities Page Layout fields
	 * 
	 * @author Vishnuvardhan
	 *
	 */

	public void newOpportunityPageLayout() {
		Utility_Functions.xWaitForElementPresent(driver, menu_Opportunities, 3);
		Utility_Functions.xClick(driver, menu_Opportunities, true);
		Utility_Functions.xWaitForElementPresent(driver, newOpportunity, 3);
		Utility_Functions.xClick(driver, newOpportunity, true);
		Utility_Functions.timeWait(2);
		Utility_Functions.xSwitchtoFrame(driver, continueButton);
		Utility_Functions.xWaitForElementPresent(driver, continueButton, 5);
		Utility_Functions.xClick(driver, continueButton, true);
		driver.switchTo().defaultContent();
		Utility_Functions.xSwitchtoFrame(driver, viewAllFieldsButton);
		Utility_Functions.xWaitForElementPresent(driver, viewAllFieldsButton, 5);
		Utility_Functions.xScrollWindow(driver);
		Utility_Functions.xClick(driver, viewAllFieldsButton, true);
		Utility_Functions.timeWait(1);
		Utility_Functions.xScrollWindowTop(driver);
		headerSectionOpportunityPage();
		labelsOpportunityPage();
		Utility_Functions.xWaitForElementPresent(driver, headerList, 3);
		try {
			int i2 = 0, count = 0;
			String[] headerTexts = new String[headerList.size()];
			for (WebElement element : headerList) {
				headerTexts[i2] = element.getText();
				if (headerTexts[i2].contains(headerSectionList.get(i2))) {
					count++;
					System.out.println("Verify Add Opportunity Header List" + element.getText());
					report.updateTestLog("Verify Add Opportunity Header List",
							element.getText() + " header is present in Add Opportunity Page", Status.PASS);
				}
				i2++;
			}
			System.out.println(count);
			if (count == 5) {
				report.updateTestLog("Verify Add Opportunity Header List",
						"Headers are present in Add Opportunity Page:::", Status.PASS);
			} else {
				report.updateTestLog("Verify Add Opportunity Header List",
						"Header are not present in Add Opportunity Page:::", Status.FAIL);
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		try {
			Utility_Functions.xWaitForElementPresent(driver, labelListOpportunitiesPage, 3);
			int i1 = 0, j = 0, countLabelList = 0;
			String[] labelTexts = new String[labelListOpportunitiesPage.size()];
			while (j < labelList.size()) {
				for (WebElement element : labelListOpportunitiesPage) {
					labelTexts[i1] = element.getText();
					if (labelTexts[i1].contains(labelList.get(j))) {
						System.out.println("Verify Add Opportunity Page Label List" + element.getText());
						report.updateTestLog("Verify Add Opportunity Page Label List",
								element.getText() + "::::label list is present in Add Opportunity Page", Status.PASS);
						countLabelList++;
					}
					i1++;
				}
				i1 = 0;
				j++;
			}
			System.out.println("Count of Label List::" + countLabelList);
			if (dataTable.getData("General_Data", "TC_ID").contains("ABAMER")) {
				countLabelList = 104;
			} else if (dataTable.getData("General_Data", "TC_ID").contains("OBAMER")) {
				countLabelList = 108;
			} else if (dataTable.getData("General_Data", "TC_ID").contains("ABAPAC")) {
				countLabelList = 138;
			} else if (dataTable.getData("General_Data", "TC_ID").contains("CMAMER")) {
				countLabelList = 66;
			}
			if ((countLabelList == 104) || (countLabelList == 108) || (countLabelList == 138)
					|| (countLabelList == 66)) {
				report.updateTestLog("Verify Add Opportunity Page Label List",
						"Labels are present in Add Opportunity Page", Status.PASS);
			} else {
				report.updateTestLog("Verify Add Opportunity Page Label List",
						"Labels are not present in Add Opportunity Page", Status.FAIL);
			}

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		validateFielsOpportunityPageLayout();
	}

	/**
	 * Validating the field values in New Opportunities Page Layout fields
	 * 
	 * @author Vishnuvardhan
	 *
	 */

	public void validateFielsOpportunityPageLayout() {
		try {
			if ((dataTable.getData("General_Data", "TC_ID").contains("ABAMER"))
					|| (dataTable.getData("General_Data", "TC_ID").contains("OBAMER"))) {
				if ((!opportunityName.getText().equals(" ")) && (!salesStage.getText().equals(" "))
						&& (!probabilityField.getText().equals(" ") && (!phaseField.getText().equals(" ")))) {
					report.updateTestLog("Verify Add Opportunity Page Fields",
							"Opportunity fields are having values present in the corresponding fields:::", Status.PASS);
				} else {
					report.updateTestLog("Verify Add Opportunity Page Fields",
							"Opportunity fields are not having values present in the corresponding fields:::",
							Status.FAIL);
				}
			} else if (dataTable.getData("General_Data", "TC_ID").contains("ABAPAC")) {
				if ((!opportunityName.getText().equals(" ")) && (!salesStage.getText().equals(" "))
						&& (!probabilityField.getText().equals(" "))) {
					report.updateTestLog("Verify Add Opportunity Page Fields",
							"Opportunity fields are having values present in the corresponding fields:::", Status.PASS);
				} else {
					report.updateTestLog("Verify Add Opportunity Page Fields",
							"Opportunity fields are not having values present in the corresponding fields:::",
							Status.FAIL);
				}
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	/**
	 * Validating the required fields based on Sales Stage selected between
	 * 03-RFP/Proposal to 15-Signed Lease on Opportunity from a broker profile
	 * 
	 * @author Vishnuvardhan
	 *
	 */

	public void requiredFieldsbetweenw03_15Stages() {
		String query = "SELECT Id, Name FROM Opportunity where StageName > '03-RFP/Proposal' and StageName < '10-Short List' "
				+ " and StageName > '13-LOI/Heads of Terms' and StageName < '15-Signed Lease' and Total_Size__c !=null and CBRE_Preferred_Property_Type_c__c !=null limit 1 offset 9";
		String OpportunityID = searchOpportunity.searchOpportunity(query);
		if (OpportunityID == null) {
			report.updateTestLog("Verify Opportunity", "There are no Opportunities that falls under this category:::",
					Status.PASS);
		} else {
			report.updateTestLog("Verify Opportunity Required Fields",
					"Opportunity retrived from database is:::" + OpportunityID, Status.PASS);
			String url = driver.getCurrentUrl().split("#")[0];
			String newUrl = url + "#/sObject/" + OpportunityID;
			newUrl = newUrl + "/view";
			report.updateTestLog("Verify Add Opportunity Page Fields",
					"URL has been replaced with the new URL having the retrieved Opportunity:::" + newUrl, Status.PASS);
			driver.get(newUrl);

			SearchTextSOQL searchTextSOQL = new SearchTextSOQL(scriptHelper);
			String query_TotalSize = "Select Total_Size__c from Opportunity where Id = " + "'" + OpportunityID + "'";
			String totalSize = searchTextSOQL.fetchRecordFieldValue("Total_Size__c", query_TotalSize);
			String query_PreferredPropertyType = "Select CBRE_Preferred_Property_Type_c__c  from Opportunity where Id = "
					+ "'" + OpportunityID + "'";
			String preferredPropertyType = searchTextSOQL.fetchRecordFieldValue("CBRE_Preferred_Property_Type_c__c",
					query_PreferredPropertyType);

			try {
				if (!(totalSize.equals("")) && !(preferredPropertyType.equals(" "))) {
					report.updateTestLog("Verify Add Opportunity Page Fields",
							"Total Size Value and Preferred Property Type fields has values present", Status.PASS);
				} else {
					report.updateTestLog("Verify Add Opportunity Page Fields",
							"Total Size Value and Preferred Property Type fields has values present", Status.FAIL);
				}
			} catch (Exception e) {
				e.getMessage();
			}
			OpportunitiesFunctions update = new OpportunitiesFunctions(scriptHelper);
			update.updateOpportunityField("StageName", OpportunityID);
			update.updateOpportunityField("EMEA_Success_Probability__c", OpportunityID);
			String updateQuery = "SELECT Id, Name, StageName FROM Opportunity where Id = " + "'" + OpportunityID + "'";
			searchOpportunity.searchOpportunity(updateQuery);
			String resultQuery = "SELECT Id, Name, StageName FROM Opportunity where Id = " + "'" + OpportunityID + "'";
			String opportunityStage = searchOpportunity.fetchRecordFieldValue("StageName", resultQuery);
			System.out.println(opportunityStage);
			if (opportunityStage.contains("Closed")) {
				report.updateTestLog("Verify Opportunity Update", "Sales Stage has been updated successfully",
						Status.PASS);
			} else {
				report.updateTestLog("Verify Opportunity Update", "Sales Stage updation has been failed", Status.FAIL);
			}
		}
	}

	/**
	 * Validating the required fields based on Sales Stage selected between
	 * 16-In Escrow to 19-Closed Lease on Opportunity from a broker profile
	 * 
	 * @author Vishnuvardhan
	 *
	 */

	public void requiredFieldsbetweenw16_19Stages() {
		String query = "SELECT Id, Name FROM Opportunity where StageName > '16-In Escrow' and StageName < '19-Closed' and Total_Size__c !=null limit 10";
		String OpportunityID = searchOpportunity.searchOpportunity(query);
		System.out.println(OpportunityID);
		if (OpportunityID == null) {
			report.updateTestLog("Verify Opportunity", "There are no Opportunities that falls under this category:::",
					Status.PASS);
		} else {
			report.updateTestLog("Verify Opportunity Required Fields",
					"Opportunity retrived from database is:::" + OpportunityID, Status.PASS);
			String url = driver.getCurrentUrl().split("#")[0];
			String newUrl = url + "#/sObject/" + OpportunityID;
			newUrl = newUrl + "/view";
			report.updateTestLog("Verify Add Opportunity Page Fields",
					"URL has been replaced with the new URL having the retrieved Opportunity:::" + newUrl, Status.PASS);
			driver.get(newUrl);
			Utility_Functions.timeWait(1);
			validateOpportunityFields(OpportunityID);
		}
	}

	/**
	 * Validating the add Opportunity sharing from the Broker profile
	 * 
	 * @author Vishnuvardhan
	 *
	 */

	public void opportunitySharing() {

		String queryOpp = "SELECT Id, Name FROM Opportunity where StageName > '16-In Escrow' and StageName < '17-Closed' and Total_Size__c !=null limit 10";
		String Opportunity = searchOpportunity.searchOpportunity(queryOpp);
		Utility_Functions.xClick(driver, menu_Opportunities, true);
		Utility_Functions.xWaitForElementPresent(driver, opportunitiesList, 3);		
		Utility_Functions.xclickRandomElement(opportunitiesList);
		Utility_Functions.timeWait(1);
		String url = driver.getCurrentUrl().split("#")[0];
		String newUrl = url + "#/sObject/" + Opportunity;
		newUrl = newUrl + "/view";
		driver.get(newUrl);
		driver.navigate().refresh();
		try {
			Utility_Functions.xWaitForElementPresent(driver, sharingButton, 5);
			Utility_Functions.xClick(driver, sharingButton, true);
			Utility_Functions.timeWait(2);
			Utility_Functions.xSwitchtoFrame(driver, opportunitySharing);
			Utility_Functions.xWaitForElementPresent(driver, opportunitySharing, 4);
			// driver.switchTo().defaultContent();
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

			String newopportunityID = "'" + Opportunity + "' ";
			updateOpportunityStatus("StageName", newopportunityID);
			String updateQuery = "SELECT Id, Name, StageName FROM Opportunity where Id = " + newopportunityID;
			searchOpportunity.searchOpportunity(updateQuery);
			String resultQuery = "SELECT Id, Name, StageName FROM Opportunity where Id = " + newopportunityID;
			String opportunityStage = searchOpportunity.fetchRecordFieldValue("StageName", resultQuery);
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

	/**
	 * Validating the Opportunity Status field update
	 * 
	 * @author Vishnuvardhan
	 *
	 */
	static PartnerConnection connection = null;
	static ConnectorConfig config;

	// public String environment = properties.getProperty("RunEnvironment");
	// public String environment = System.getProperty("RunEnvironment");
	LoginPage loginPage = new LoginPage(scriptHelper);

	public void updateOpportunityStatus(String FieldName, String OpportunityID) {
		try {
			String environment = loginPage.initializeEnvironment();
			if (environment.equals("UAT")) {
				String UAT_AuthEndpoint = properties.getProperty("UATAuthEndpoint");
				config = new ConnectorConfig();
				config.setUsername(properties.getProperty("UATSystemAdminUsername"));
				config.setPassword(properties.getProperty("UATAdminPassword"));
				config.setAuthEndpoint(UAT_AuthEndpoint);
			} else if (environment.equals("UAT2")) {
				String UAT2_AuthEndpoint = properties.getProperty("UAT2AuthEndpoint");
				config = new ConnectorConfig();
				config.setUsername(properties.getProperty("UAT2SystemAdminUsername"));
				config.setPassword(properties.getProperty("UAT2AdminPassword"));
				config.setAuthEndpoint(UAT2_AuthEndpoint);
			} else if (environment.equals("FTE")) {
				String FTE_AuthEndpoint = properties.getProperty("FTEAuthEndpoint");
				config = new ConnectorConfig();
				config.setUsername(properties.getProperty("FTESystemAdminUsername"));
				config.setPassword(properties.getProperty("FTEAdminPassword"));
				config.setAuthEndpoint(FTE_AuthEndpoint);
			} else if (environment.equals("FTE2")) {
				String FTE2_AuthEndpoint = properties.getProperty("FTE2AuthEndpoint");
				config = new ConnectorConfig();
				config.setUsername(properties.getProperty("FTE2SystemAdminUsername"));
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
	 * Validating the functionality for association of property to an
	 * Opportunity
	 * 
	 * @author Vishnuvardhan
	 *
	 */
	public void associateProperty() {
		Utility_Functions.xWaitForElementPresent(driver, menu_Opportunities, 3);
		Utility_Functions.xClick(driver, menu_Opportunities, true);
		Utility_Functions.xWaitForElementPresent(driver, opportunitiesList, 3);
		Utility_Functions.xclickOnFirstElementfromList(opportunitiesList);
		Utility_Functions.timeWait(1);
		Utility_Functions.xWaitForElementPresent(driver, related, 3);
		Utility_Functions.xClick(driver, related, true);
		Utility_Functions.timeWait(2);
		Utility_Functions.xScrollWindow(driver);
		Utility_Functions.timeWait(1);
		Utility_Functions.xScrollWindowTop(driver);
		Utility_Functions.timeWait(3);
		try {
			Utility_Functions.xWaitForElementPresent(driver, associateProperty, 3);
			Utility_Functions.xClick(driver, associateProperty, true);
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
				report.updateTestLog("Verify Opportunity", "Associat property to an opportunity failed ", Status.FAIL);
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
				report.updateTestLog("Verify Opportunity", "Associat property to an opportunity failed ", Status.FAIL);
			}
		}
	}

	/**
	 * Validating the manage Opportunity split functionality
	 * 
	 * @author Ramya
	 *
	 */
	public void opportunitySplitFunctionality() {
		Utility_Functions.xWaitForElementPresent(driver, menu_Opportunities, 3);
		Utility_Functions.xClick(driver, menu_Opportunities, true);
		Utility_Functions.xWaitForElementPresent(driver, opportunitiesList, 3);
		Utility_Functions.xclickgetTextofFirstElementfromList(opportunitiesList);
		Utility_Functions.timeWait(5);
		Utility_Functions.xClick(driver, editButton, true);
		Utility_Functions.timeWait(4);
		Utility_Functions.xScrollWindowToElement(driver, estimatedGrossFeeField);
		Utility_Functions.timeWait(3);
		Utility_Functions.xClick(driver, estimatedGrossFeeField, true);
		Utility_Functions.timeWait(4);
		Utility_Functions.xSendKeys(driver, estimatedGrossFeeField, "10,000.00");
		Utility_Functions.timeWait(3);
		Utility_Functions.xClick(driver, save, true);
		Utility_Functions.timeWait(3);
		Utility_Functions.xClick(driver, related, true);
		Utility_Functions.timeWait(5);

		/*
		 * Utility_Functions.xClick(driver, addButton, true);
		 * Utility_Functions.timeWait(3);
		 */

		Utility_Functions.xClick(driver, addButtonshareOpportunity, true);
		Utility_Functions.timeWait(3);

		int size = driver.findElements(By.tagName("iframe")).size();
		System.out.println(size);
		Utility_Functions.timeWait(2);
		List<WebElement> iframeList = driver.findElements(By.tagName("iframe"));
		System.out.println(iframeList.size());
		for (WebElement element : iframeList) {
			System.out.println(element.getAttribute("id"));
		}
		driver.switchTo().frame(4);
		Utility_Functions.xSwitchtoFrame(driver, saveButtonSplit);
		// System.out.println("Frame Identified");
		Utility_Functions.timeWait(5);
		List<WebElement> opportunityList = driver.findElements(By.xpath("//div[contains(@class, 'slds-truncate')]"));
		int count = 0;
		System.out.println(opportunityList.size());
		try {
			for (WebElement element : opportunityList) {

				if ((count == 0) && (element.getText().equals("USER"))) {
					System.out.println("USER  field is present in the Add New Team Member Page");
					report.updateTestLog("Add New Team Member Page",
							"Add New Team Member Page is having the " + element.getText() + " Status field::",
							Status.PASS);
					count++;
				} else if ((count == 1) && (element.getText().equals("TEAM MEMBER DESCRIPTION"))) {
					System.out.println("Team Member Description field is present in the Add New Team Member Page");
					report.updateTestLog("Add New Team Member Page",
							"Add New Team Member Page is having the " + element.getText() + " Status field::",
							Status.PASS);
					count++;
				} else if ((count == 2) && (element.getText().equals("TEAM ROLE"))) {
					System.out.println("TEAM ROLE field is present in the Add New Team Member Page");
					report.updateTestLog("Add New Team Member Page",
							"Add New Team Member Page is having the " + element.getText() + " Status field::",
							Status.PASS);
					count++;
				} else if ((count == 3) && (element.getText().equals("SECONDARY MEMBER ROLE"))) {
					System.out.println("SECONDARY MEMBER ROLE field is present in the Add New Team Member Page");
					report.updateTestLog("Add New Team Member Page",
							"Add New Team Member Page is having the " + element.getText() + " Status field::",
							Status.PASS);
					count++;
				} else if ((count == 4) && (element.getText().equals("OPPORTUNITY ACCESS"))) {
					System.out.println("OPPORTUNITY ACCESS field is present in the Add New Team Member Page");
					report.updateTestLog("Add New Team Member Page",
							"Add New Team Member Page is having the " + element.getText() + " Status field::",
							Status.PASS);

				}
			}
			if (count != 4)
				report.updateTestLog("Add New Team Member Page",
						"Add New Team Member Page is not having all the fields::", Status.FAIL);
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
		}
		Utility_Functions.timeWait(2);
		Utility_Functions.xSendKeys(driver, user1, "Inactive User");
		Utility_Functions.timeWait(1);
		user1.sendKeys(Keys.ARROW_DOWN);
		user1.sendKeys(Keys.ENTER);
		Utility_Functions.xClick(driver, selectTeamRole, true);
		Utility_Functions.timeWait(3);
		Utility_Functions.xClick(driver, selectSecondaryMemberRole, true);
		Utility_Functions.timeWait(3);
		Utility_Functions.xClick(driver, selectOpportunityAccess, true);
		Utility_Functions.timeWait(3);
		Utility_Functions.xSendKeys(driver, user2, "Test Broker1");
		Utility_Functions.timeWait(2);
		user2.sendKeys(Keys.ARROW_DOWN);
		user2.sendKeys(Keys.ENTER);
		Utility_Functions.xClick(driver, selectTeamRole2, true);
		Utility_Functions.timeWait(3);
		Utility_Functions.xClick(driver, selectSecondaryMemberRole2, true);
		Utility_Functions.timeWait(3);
		Utility_Functions.xClick(driver, saveButtonSplit, true);
		Utility_Functions.timeWait(3);
		driver.navigate().refresh();
		Utility_Functions.timeWait(1);
		driver.switchTo().defaultContent();
		driver.navigate().refresh();
		Utility_Functions.xWaitForElementVisible(driver, manageOpportunitySplits, 3);
		Utility_Functions.xClick(driver, manageOpportunitySplits, true);
		Utility_Functions.timeWait(4);
		driver.switchTo().frame(driver.findElement(By.xpath("//iframe")));
		splitPercent.clear();
		Utility_Functions.timeWait(3);
		splitPercent.sendKeys("100");
		try {
			Utility_Functions.xClick(driver, saveOpportunitySplit, true);
		} catch (Exception e) {
			Utility_Functions.xClick(driver, saveOpportunitySplitUAT, true);
		}
		report.updateTestLog("Opportunity Saved", "Opportunity Saved successfully::", Status.PASS);
		Utility_Functions.timeWait(3);
	}

	/**
	 * Function for retrieving the Opportunity
	 * 
	 * @author Vishnuvardhan
	 *
	 */

	public String retriveOpportunity() {
		String query = "SELECT Id, Name FROM Opportunity where StageName < '16-In Escrow'";
		String OpportunityID = searchOpportunity.searchOpportunity(query);
		report.updateTestLog("Verify Opportunity Required Fields",
				"Opportunity retrived from database is:::" + OpportunityID, Status.PASS);
		String url = driver.getCurrentUrl().split("#")[0];
		String newUrl = url + "#/sObject/" + OpportunityID;
		newUrl = newUrl + "/view";
		driver.get(newUrl);
		Utility_Functions.timeWait(1);
		return OpportunityID;
	}

	/**
	 * Function for creating an Opportunity
	 * 
	 * @author Vishnuvardhan
	 *
	 */

	public String opportunityNameAutoGenerate_API() {
		String accountName = null;
		try {
			establishConnection();
			SObject opportunity = new SObject();
			opportunity.setType("Opportunity");
			/*
			 * SearchTextSOQL accountID = new SearchTextSOQL(scriptHelper);
			 * String accountId = accountID.fetchRecord("Account", "Id");
			 */
			int value = Utility_Functions.xRandomFunction();
			opportunity.setField("Name", "Test Automation_" + value);
			opportunity.setField("AccountId", "0010S000004SaIHQA0");
			opportunity.setField("CloseDate", Calendar.getInstance());
			if ((dataTable.getData("General_Data", "TC_ID").contains("ASAMER"))
					|| (dataTable.getData("General_Data", "TC_ID").contains("ASAPAC"))
					|| (dataTable.getData("General_Data", "TC_ID").contains("ASEMEA"))) {
				opportunity.setField("RecordTypeId", "012i0000000405jAAA");
			} else if ((dataTable.getData("General_Data", "TC_ID").contains("GWSAMER"))
					|| (dataTable.getData("General_Data", "TC_ID").contains("GWSAPAC"))
					|| (dataTable.getData("General_Data", "TC_ID").contains("GWSEMEA"))) {
				opportunity.setField("RecordTypeId", "012i0000000405mAAA");
			} else if (dataTable.getData("General_Data", "TC_ID").contains("CM")
					&& (dataTable.getData("General_Data", "TC_ID").contains("DSF"))) {
				opportunity.setField("RecordTypeId", "012i0000000405lAAA");
			} else if ((dataTable.getData("General_Data", "TC_ID").contains("OBAMER"))
					|| (dataTable.getData("General_Data", "TC_ID").contains("OBAPAC"))
					|| (dataTable.getData("General_Data", "TC_ID").contains("OBEMEA"))) {
				opportunity.setField("RecordTypeId", "012i0000000405nAAA");
			}

			opportunity.setField("StageName", "1-Target");
			// opportunity.setField("Service__c", "Business Valuation");
			opportunity.setField("Total_Size__c", 5000);
			opportunity.setField("Unit_of_Measure__c", "Acres");
			opportunity.setField("Type_of_Client__c", "New Business");

			opportunity.setField("Leasing__c", "Yes");
			opportunity.setField("Management__c", "Yes");
			opportunity.setField("Capital_Markets__c", "Yes");
			opportunity.setField("Accounting__c", "Yes");
			opportunity.setField("Tech_Services__c", "Yes");
			opportunity.setField("Project_Management__c	", "Yes");
			opportunity.setField("Sustainability__c", "Yes");
			opportunity.setField("Consultancy__c", "Yes");
			opportunity.setField("FM_Lite__c", "Yes");

			if (dataTable.getData("General_Data", "TC_ID").contains("AMER")) {
				opportunity.setField("Region__c	", "US National");
				opportunity.setField("Market__c	", "Boston");
			} else if (dataTable.getData("General_Data", "TC_ID").contains("EMEA")) {
				opportunity.setField("Region__c	", "EMEA");
				opportunity.setField("Market__c	", "Africa");
			} else if (dataTable.getData("General_Data", "TC_ID").contains("APAC")) {
				opportunity.setField("Region__c	", "APAC");
				opportunity.setField("Market__c	", "Australia");
			}
			SObject[] opportunities = new SObject[1];
			opportunities[0] = opportunity;
			results = EstablishConnection.connection.create(opportunities);
			report.updateTestLog("Opportunity Name",
					"Opportunity for the record type Asset Services is created successfully:::", Status.PASS);
			System.out.println("Result:::" + results);
			for (int j = 0; j < results.length; j++) {
				if (results[j].isSuccess()) {
					result = results[j].getId();
					System.out.println("Save Results:::" + result);
					report.updateTestLog("Opportunity Name", "Opportunity Id:::" + result + " successfully:::",
							Status.PASS);
				}
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
			System.out.println(e.getStackTrace());
		}
		return result + ":" + accountName;

	}

	/**
	 * Validating the Auto Generated Opportunity Account Name modification
	 * 
	 * @author Vishnuvardhan
	 *
	 */

	public void modifyAutoGeneratedOpportunityName() {
		try {
			String recordTypeId;
			if (dataTable.getData("General_Data", "TC_ID").contains("DSF")) {
				recordTypeId = "012i0000000405lAAA";
				report.updateTestLog("Opportunity Name",
						"Record type is set as Capital Markets - Debt & Structured Finance:::", Status.PASS);
			} else if (dataTable.getData("General_Data", "TC_ID").contains("PS")) {
				recordTypeId = "012i0000000405kAAA";
				report.updateTestLog("Opportunity Name", "Record type is set as Property Sales", Status.PASS);
			} else if (dataTable.getData("General_Data", "TC_ID").contains("GWS")) {
				recordTypeId = "012i0000000405mAAA";
				report.updateTestLog("Opportunity Name", "Record type is set as Global Workplace Solutions",
						Status.PASS);
			} else if (dataTable.getData("General_Data", "TC_ID").contains("VAS")) {
				recordTypeId = "012i0000000405oAAA";
				report.updateTestLog("Opportunity Name", "Record type is set as Valuation & Advisory Services",
						Status.PASS);
			} else if (dataTable.getData("General_Data", "TC_ID").contains("AS")) {
				recordTypeId = "012i0000000405jAAA";
				report.updateTestLog("Opportunity Name", "Record type is set as Asset Services", Status.PASS);
			} else if (dataTable.getData("General_Data", "TC_ID").contains("AB")) {
				recordTypeId = "012i0000001622CAAQ";
				report.updateTestLog("Opportunity Name", "Record type is set as Agency Brokerage", Status.PASS);
			} else if (dataTable.getData("General_Data", "TC_ID").contains("OB")) {
				recordTypeId = "012i0000000405nAAA";
				report.updateTestLog("Opportunity Name", "Record type is set as Occupier Brokerage", Status.PASS);
			} else {
				recordTypeId = "012i0000000405n";
			}
			boolean isStatus = false;
			String query = "SELECT Name, Id, Service__C, Total_Size__c, Unit_of_Measure__c FROM Opportunity where Name like "
					+ "'%-%-%-%' and StageName > '03-RFP/Proposal' and StageName < '15-Signed Lease' and RecordTypeId = "
					+ "'" + recordTypeId + "'" + "limit 1 offset 9";
			SearchTextSOQL searchTextSOQL = new SearchTextSOQL(scriptHelper);
			String opportunityID = searchTextSOQL.fetchRecordFieldValue("Id", query);
			while (!isStatus) {
				if (opportunityID == null) {
					report.updateTestLog("Opportunity", "No Opportunities present for the Record Type selected:::",
							Status.PASS);
					isStatus = false;
					break;
				} else {
					String opportunityName = searchTextSOQL.fetchRecordFieldValue("Name", query);
					String assignmentType = searchTextSOQL.fetchRecordFieldValue("Service__c", query);
					String totalSize = searchTextSOQL.fetchRecordFieldValue("Total_Size__c", query);
					String unitOfMeasure = searchTextSOQL.fetchRecordFieldValue("Unit_of_Measure__c", query);
					report.updateTestLog("Fetched Opportunity Name", "Opportunity Name:::" + opportunityName,
							Status.PASS);
					report.updateTestLog("Fetched Opportunity Name", "Opportunity Assignment Type:::" + assignmentType,
							Status.PASS);
					report.updateTestLog("Fetched Opportunity Name", "Opportunity Total Size:::" + totalSize,
							Status.PASS);
					report.updateTestLog("Fetched Opportunity Name", "Opportunity Unit of Measure:::" + unitOfMeasure,
							Status.PASS);
					opportunitiesFunctions.updateOpportunityField("Service__c", opportunityID);
					opportunitiesFunctions.updateOpportunityField("Total_Size__c", opportunityID);
					opportunitiesFunctions.updateOpportunityField("Unit_of_Measure__c", opportunityID);

					String updatedAssignmentType = searchTextSOQL.fetchRecordFieldValue("Service__c", query);
					String updatedTotalSize = searchTextSOQL.fetchRecordFieldValue("Total_Size__c", query);
					String updatedUnitOfMeasure = searchTextSOQL.fetchRecordFieldValue("Unit_of_Measure__c", query);
					if (updatedAssignmentType.equals("Project Management")) {
						report.updateTestLog("Modified Opportunity Name",
								"Opportunity Name modified according to the AssignmentType selected:::"
										+ updatedAssignmentType,
										Status.PASS);
					} else {
						report.updateTestLog("Modified Opportunity Name",
								"Opportunity Name didn't get modified according to the AssignmentType selected:::"
										+ updatedAssignmentType,
										Status.FAIL);
					}
					if (updatedTotalSize.equals("2900.0")) {
						report.updateTestLog("Modified Opportunity Name",
								"Opportunity Name modified according to the Total Size selected:::" + updatedTotalSize,
								Status.PASS);
					} else {
						report.updateTestLog("Modified Opportunity Name",
								"Opportunity Name didn't get modified according to the Total Size selected:::"
										+ updatedTotalSize,
										Status.FAIL);
					}
					if (updatedUnitOfMeasure.equals("Hectares")) {
						report.updateTestLog("Modified Opportunity Name",
								"Opportunity Name modified according to the Unit of Measure selected:::"
										+ updatedUnitOfMeasure,
										Status.PASS);
					} else {
						report.updateTestLog("Modified Opportunity Name",
								"Opportunity Name didn't get modified according to the Unit of Measure selected:::"
										+ updatedUnitOfMeasure,
										Status.FAIL);
					}
					isStatus = true;
				}
			}
		} catch (Exception e) {
			e.getMessage();
		}

	}

	/**
	 * Validate Opportunity Name is not auto generated when manually added by
	 * the user
	 * 
	 * @author Vishnuvardhan
	 *
	 */

	static SaveResult[] results;
	static String result;

	public String manualOpportunityCreation() {
		try {

			boolean isStatus = false;
			while (!isStatus) {
				establishConnection();
				SObject opportunity = new SObject();
				Random random = new Random();
				int value = random.nextInt();
				String opportunityName = "Test Automation_Opportunity" + value;
				opportunity.setType("Opportunity");
				opportunity.setField("Name", opportunityName);
				SearchTextSOQL accountID = new SearchTextSOQL(scriptHelper);
				String accountId = accountID.fetchRecord("Account", "Id");
				opportunity.setField("AccountId", accountId);
				opportunity.setField("CloseDate", Calendar.getInstance());
				opportunity.setField("StageName", "Qualification");

				if (dataTable.getData("General_Data", "TC_ID").contains("DSF")) {
					opportunity.setField("RecordTypeId", "012i0000000405lAAA");
					// opportunity.setField("Estimated_Gross_Fee_Commission__c",
					// 10000);
					report.updateTestLog("Opportunity Name",
							"Record type is set as Capital Markets - Debt & Structured Finance:::", Status.PASS);
				} else if (dataTable.getData("General_Data", "TC_ID").contains("PS")) {
					opportunity.setField("RecordTypeId", "012i0000000405kAAA");
					report.updateTestLog("Opportunity Name", "Record type is set as Property Sales", Status.PASS);
				} else if ((dataTable.getData("General_Data", "TC_ID").contains("GWSAMER"))
						|| (dataTable.getData("General_Data", "TC_ID").contains("GWSAPAC"))
						|| (dataTable.getData("General_Data", "TC_ID").contains("GWSEMEA"))) {
					opportunity.setField("RecordTypeId", "012i0000000405mAAA");
					opportunity.setField("Service__c", "Service Contract Exclusive");
					report.updateTestLog("Opportunity Name", "Record type is set as Global Workplace Solutions",
							Status.PASS);
				} else if ((dataTable.getData("General_Data", "TC_ID").contains("VASAMER"))
						|| (dataTable.getData("General_Data", "TC_ID").contains("VASAPAC"))
						|| (dataTable.getData("General_Data", "TC_ID").contains("VASEMEA"))) {
					opportunity.setField("RecordTypeId", "0121Y000001EVzFQAW");
					opportunity.setField("Region__c", "US National");
					opportunity.setField("Market__c	", "Austin");
					opportunity.setField("Environmental__c	", "Yes");
					opportunity.setField("Property_Condition__c", "Yes");
					opportunity.setField("Facility_Assessment__c", "Yes");
					opportunity.setField("Appraisal__c", "Yes");

					report.updateTestLog("Opportunity Name", "Record type is set as Valuation & Advisory Services",
							Status.PASS);
				} else if ((dataTable.getData("General_Data", "TC_ID").contains("ASAMER"))
						|| (dataTable.getData("General_Data", "TC_ID").contains("ASAPAC"))
						|| (dataTable.getData("General_Data", "TC_ID").contains("ASEMEA"))) {
					opportunityNameAutoGenerate_API();
					isStatus = false;
					break;
				} else if ((dataTable.getData("General_Data", "TC_ID").contains("ABAMER"))
						|| (dataTable.getData("General_Data", "TC_ID").contains("ABAPAC"))
						|| (dataTable.getData("General_Data", "TC_ID").contains("ABEMEA"))) {
					opportunity.setField("RecordTypeId", "012i0000001622CAAQ");
					opportunity.setField("Service__c", "Consulting");
					opportunity.setField("Total_Size__c", 999);
					opportunity.setField("CBRE_Preferred_Property_Type_c__c", "Hotel");
					report.updateTestLog("Opportunity Name", "Record type is set as Agency Brokerage", Status.PASS);
				} else if ((dataTable.getData("General_Data", "TC_ID").contains("OBAMER"))
						|| (dataTable.getData("General_Data", "TC_ID").contains("OBAPAC"))
						|| (dataTable.getData("General_Data", "TC_ID").contains("OBEMEA"))) {
					opportunity.setField("RecordTypeId", "012i0000000405nAAA");
					opportunity.setField("Service__c", "Consulting");
					opportunity.setField("Total_Size__c", 999);
					opportunity.setField("CBRE_Preferred_Property_Type_c__c", "Hotel");
					report.updateTestLog("Opportunity Name", "Record type is set as Occupier Brokerage", Status.PASS);
				} else {
					opportunity.setField("RecordTypeId", "012i0000000405n");
				}

				SObject[] opportunities = new SObject[1];
				opportunities[0] = opportunity;
				try {
					results = EstablishConnection.connection.create(opportunities);
				} catch (Exception e) {
					e.printStackTrace();
				}
				System.out.println("Result:::" + results);
				for (int j = 0; j < results.length; j++) {
					if (results[j].isSuccess()) {
						result = results[j].getId();
					}
				}
				System.out.println(result);
				SearchTextSOQL searchTextSOQL = new SearchTextSOQL(scriptHelper);
				String query = "Select Name from Opportunity where Id = '" + result + "'";
				Utility_Functions.timeWait(2);
				String generatedOpportunityName = searchTextSOQL.fetchRecordFieldValue("Name", query);
				Utility_Functions.timeWait(1);
				if (opportunityName.equals(generatedOpportunityName)) {
					report.updateTestLog("Opportunity Name",
							"Opportunity Name is not auto generated when Opportunity is manually added by the User::",
							Status.PASS);
				} else {
					report.updateTestLog("Opportunity Name", "Failure in the Opportunity Name generation:::",
							Status.FAIL);
				}
				if (dataTable.getData("General_Data", "TC_ID").contains("DSF")) {
					String queryRecordType = "Select RecordTypeId from Opportunity where Id = '" + result + "'";
					String recordType = searchTextSOQL.fetchRecordFieldValue("RecordTypeId", queryRecordType);
					if (recordType.equals("012i0000000405lAAA")) {
						report.updateTestLog("Opportunity Name",
								"Opportunity is created by selecting the Record Type as Capital Markets - Debt & Structured Finance:::",
								Status.PASS);
					} else if (recordType.equals("012i0000000405kAAA")) {
						report.updateTestLog("Opportunity Name",
								"Opportunity is created by selecting the Record Type  as Property Sales:::",
								Status.PASS);
					} else if (recordType.equals("012i0000000405mAAA")) {
						report.updateTestLog("Opportunity Name",
								"Opportunity is created by selecting the Record Type  as Global Workplace Solutions:::",
								Status.PASS);
					} else if (recordType.equals("012i0000000405oAAA")) {
						report.updateTestLog("Opportunity Name",
								"Opportunity is created by selecting the Record Type  as Valuation & Advisory Services:::",
								Status.PASS);
					} else if (recordType.equals("012i0000001622CAAQ")) {
						report.updateTestLog("Opportunity Name",
								"Opportunity is created by selecting the Record Type  as Agency Brokerage:::",
								Status.PASS);
					} else if (recordType.equals("012i0000000405nAAA")) {
						report.updateTestLog("Opportunity Name",
								"Opportunity is created by selecting the Record Type  as Occupier Brokerage:::",
								Status.PASS);
					} else {
						report.updateTestLog("Opportunity Name",
								"Opportunity is not as created as per the selection:::", Status.FAIL);
					}
				}
				isStatus = true;
			}

		} catch (Exception e) {
			System.out.println(e.getMessage());
			System.out.println(e.getStackTrace());
		}
		return result;
	}

	/**
	 * Function for establishing the connection
	 * 
	 * @author Vishnuvardhan
	 *
	 */

	public void establishConnection() {
		try {
			String environment = loginPage.initializeEnvironment();
			if (environment.equals("FTE")) {
				config = new ConnectorConfig();
				if ((dataTable.getData("General_Data", "TC_ID").contains("GWSAPAC"))
						&& (dataTable.getData("General_Data", "TC_ID").contains("Manager"))) {
					config.setUsername(properties.getProperty("FTEGWSAPACManager"));
					config.setPassword(properties.getProperty("FTEPassword"));
				} else if ((dataTable.getData("General_Data", "TC_ID").contains("GWSEMEA"))
						&& (dataTable.getData("General_Data", "TC_ID").contains("Broker"))) {
					config.setUsername(properties.getProperty("FTEGWSEMEABroker"));
					config.setPassword(properties.getProperty("FTEPassword"));
				} else if ((dataTable.getData("General_Data", "TC_ID").contains("VASAMER"))
						&& (dataTable.getData("General_Data", "TC_ID").contains("Manager"))) {
					config.setUsername(properties.getProperty("FTEVASAMERManager"));
					config.setPassword(properties.getProperty("FTEPassword"));
				} else if ((dataTable.getData("General_Data", "TC_ID").contains("VASEMEA"))
						&& (dataTable.getData("General_Data", "TC_ID").contains("Broker"))) {
					config.setUsername(properties.getProperty("FTEVASEMEABroker"));
					config.setPassword(properties.getProperty("FTEPassword"));
				} else if ((dataTable.getData("General_Data", "TC_ID").contains("ASAMER"))
						&& (dataTable.getData("General_Data", "TC_ID").contains("Manager"))) {
					config.setUsername(properties.getProperty("FTEASAMERManager"));
					config.setPassword(properties.getProperty("FTEPassword"));
				} else if ((dataTable.getData("General_Data", "TC_ID").contains("ASAPAC"))
						&& (dataTable.getData("General_Data", "TC_ID").contains("Broker"))) {
					config.setUsername(properties.getProperty("FTEASAPACBroker"));
					config.setPassword(properties.getProperty("FTEPassword"));
				} else if ((dataTable.getData("General_Data", "TC_ID").contains("ABAMER"))
						&& (dataTable.getData("General_Data", "TC_ID").contains("CSS"))) {
					config.setUsername(properties.getProperty("FTEABAMERCSS"));
					config.setPassword(properties.getProperty("FTEPassword"));
				} else if ((dataTable.getData("General_Data", "TC_ID").contains("ABAPAC"))
						&& (dataTable.getData("General_Data", "TC_ID").contains("Manager"))) {
					config.setUsername(properties.getProperty("FTEABAPACManager"));
					config.setPassword(properties.getProperty("FTEPassword"));
				} else if ((dataTable.getData("General_Data", "TC_ID").contains("OBAMER"))
						&& (dataTable.getData("General_Data", "TC_ID").contains("CSS"))) {
					config.setUsername(properties.getProperty("FTEOBAMERCSS"));
					config.setPassword(properties.getProperty("FTEPassword"));
				} else if ((dataTable.getData("General_Data", "TC_ID").contains("OBAMER"))
						&& (dataTable.getData("General_Data", "TC_ID").contains("Manager"))) {
					config.setUsername(properties.getProperty("FTEOBAMERManager"));
					config.setPassword(properties.getProperty("FTEPassword"));
				} else if ((dataTable.getData("General_Data", "TC_ID").contains("CMAMER"))
						&& (dataTable.getData("General_Data", "TC_ID").contains("Broker"))) {
					config.setUsername(properties.getProperty("FTECMAMERBroker"));
					config.setPassword(properties.getProperty("FTEPassword"));
				} else if ((dataTable.getData("General_Data", "TC_ID").contains("CMAMER"))
						&& (dataTable.getData("General_Data", "TC_ID").contains("Manager"))) {
					config.setUsername(properties.getProperty("FTECMAMERManager"));
					config.setPassword(properties.getProperty("FTEPassword"));
				} else if ((dataTable.getData("General_Data", "TC_ID").contains("CMAMER"))
						&& (dataTable.getData("General_Data", "TC_ID").contains("CSS"))) {
					config.setUsername(properties.getProperty("FTECMAMERCSS"));
					config.setPassword(properties.getProperty("FTEPassword"));
				}
				config.setAuthEndpoint(properties.getProperty("FTEAuthEndpoint"));
				connection = new PartnerConnection(config);
			} else if (environment.equals("FTE2")) {
				config = new ConnectorConfig();
				if ((dataTable.getData("General_Data", "TC_ID").contains("GWSAPAC"))
						&& (dataTable.getData("General_Data", "TC_ID").contains("Manager"))) {
					config.setUsername(properties.getProperty("FTE2GWSAPACManager"));
					config.setPassword(properties.getProperty("FTE2GWSAPACManagerPassword"));
				} else if ((dataTable.getData("General_Data", "TC_ID").contains("GWSEMEA"))
						&& (dataTable.getData("General_Data", "TC_ID").contains("Broker"))) {
					config.setUsername(properties.getProperty("FTE2GWSEMEABroker"));
					config.setPassword(properties.getProperty("FTE2GWSEMEABrokerPassword"));
				} else if ((dataTable.getData("General_Data", "TC_ID").contains("VASAMER"))
						&& (dataTable.getData("General_Data", "TC_ID").contains("Manager"))) {
					config.setUsername(properties.getProperty("FTE2VASAMERManager"));
					config.setPassword(properties.getProperty("FTE2VASAMERManagerPassword"));
				} else if ((dataTable.getData("General_Data", "TC_ID").contains("VASEMEA"))
						&& (dataTable.getData("General_Data", "TC_ID").contains("Broker"))) {
					config.setUsername(properties.getProperty("FTE2VASEMEABroker"));
					config.setPassword(properties.getProperty("FTE2VASEMEABrokerPassword"));
				} else if ((dataTable.getData("General_Data", "TC_ID").contains("ASAMER"))
						&& (dataTable.getData("General_Data", "TC_ID").contains("Manager"))) {
					config.setUsername(properties.getProperty("FTE2ASAMERManager"));
					config.setPassword(properties.getProperty("FTE2ASAMERManagerPassword"));
				} else if ((dataTable.getData("General_Data", "TC_ID").contains("ASAPAC"))
						&& (dataTable.getData("General_Data", "TC_ID").contains("Broker"))) {
					config.setUsername(properties.getProperty("FTE2ASAPACBroker"));
					config.setPassword(properties.getProperty("FTE2ASAPACBrokerPassword"));
				} else if ((dataTable.getData("General_Data", "TC_ID").contains("ABAMER"))
						&& (dataTable.getData("General_Data", "TC_ID").contains("CSS"))) {
					config.setUsername(properties.getProperty("FTE2ABAMERCSS"));
					config.setPassword(properties.getProperty("FTE2Password"));
				} else if ((dataTable.getData("General_Data", "TC_ID").contains("ABAPAC"))
						&& (dataTable.getData("General_Data", "TC_ID").contains("Manager"))) {
					config.setUsername(properties.getProperty("FTE2ABAPACManager"));
					config.setPassword(properties.getProperty("FTE2Password"));
				} else if ((dataTable.getData("General_Data", "TC_ID").contains("OBAMER"))
						&& (dataTable.getData("General_Data", "TC_ID").contains("CSS"))) {
					config.setUsername(properties.getProperty("FTE2OBAMERCSS"));
					config.setPassword(properties.getProperty("FTE2Password"));
				} else if ((dataTable.getData("General_Data", "TC_ID").contains("OBAMER"))
						&& (dataTable.getData("General_Data", "TC_ID").contains("Manager"))) {
					config.setUsername(properties.getProperty("FTE2OBAMERManager"));
					config.setPassword(properties.getProperty("FTE2Password"));
				} else if ((dataTable.getData("General_Data", "TC_ID").contains("CMAMER"))
						&& (dataTable.getData("General_Data", "TC_ID").contains("Broker"))) {
					config.setUsername(properties.getProperty("FTE2CMAMERBroker"));
					config.setPassword(properties.getProperty("FTE2Password"));
				} else if ((dataTable.getData("General_Data", "TC_ID").contains("CMAMER"))
						&& (dataTable.getData("General_Data", "TC_ID").contains("Manager"))) {
					config.setUsername(properties.getProperty("FTE2CMAMERManager"));
					config.setPassword(properties.getProperty("FTE2Password"));
				} else if ((dataTable.getData("General_Data", "TC_ID").contains("CMAMER"))
						&& (dataTable.getData("General_Data", "TC_ID").contains("CSS"))) {
					config.setUsername(properties.getProperty("FTE2CMAMERCSS"));
					config.setPassword(properties.getProperty("FTE2Password"));
				}
				config.setAuthEndpoint(properties.getProperty("FTE2AuthEndpoint"));
				connection = new PartnerConnection(config);
			} else if (environment.equals("UAT2")) {
				config = new ConnectorConfig();
				if ((dataTable.getData("General_Data", "TC_ID").contains("GWSAPAC"))
						&& (dataTable.getData("General_Data", "TC_ID").contains("Manager"))) {
					config.setUsername(properties.getProperty("UAT2GWSAPACManager"));
					config.setPassword(properties.getProperty("UAT2Password"));
				} else if ((dataTable.getData("General_Data", "TC_ID").contains("GWSEMEA"))
						&& (dataTable.getData("General_Data", "TC_ID").contains("Broker"))) {
					config.setUsername(properties.getProperty("UAT2GWSEMEABroker"));
					config.setPassword(properties.getProperty("UAT2Password"));
				} else if ((dataTable.getData("General_Data", "TC_ID").contains("VASAMER"))
						&& (dataTable.getData("General_Data", "TC_ID").contains("Manager"))) {
					config.setUsername(properties.getProperty("UAT2VASAMERManager"));
					config.setPassword(properties.getProperty("UAT2Password"));
				} else if ((dataTable.getData("General_Data", "TC_ID").contains("VASEMEA"))
						&& (dataTable.getData("General_Data", "TC_ID").contains("Broker"))) {
					config.setUsername(properties.getProperty("UAT2VASEMEABroker"));
					config.setPassword(properties.getProperty("UAT2Password"));
				} else if ((dataTable.getData("General_Data", "TC_ID").contains("ASAMER"))
						&& (dataTable.getData("General_Data", "TC_ID").contains("Manager"))) {
					config.setUsername(properties.getProperty("UAT2ASAMERManager"));
					config.setPassword(properties.getProperty("UAT2Password"));
				} else if ((dataTable.getData("General_Data", "TC_ID").contains("ASAPAC"))
						&& (dataTable.getData("General_Data", "TC_ID").contains("Broker"))) {
					config.setUsername(properties.getProperty("UAT2ASAPACBroker"));
					config.setPassword(properties.getProperty("UAT2Password"));
				} else if ((dataTable.getData("General_Data", "TC_ID").contains("ABAMER"))
						&& (dataTable.getData("General_Data", "TC_ID").contains("CSS"))) {
					config.setUsername(properties.getProperty("UAT2ABAMERCSS"));
					config.setPassword(properties.getProperty("UAT2Password"));
				} else if ((dataTable.getData("General_Data", "TC_ID").contains("ABAPAC"))
						&& (dataTable.getData("General_Data", "TC_ID").contains("Manager"))) {
					config.setUsername(properties.getProperty("UAT2ABAPACManager"));
					config.setPassword(properties.getProperty("UAT2Password"));
				} else if ((dataTable.getData("General_Data", "TC_ID").contains("OBAMER"))
						&& (dataTable.getData("General_Data", "TC_ID").contains("CSS"))) {
					config.setUsername(properties.getProperty("UAT2OBAMERCSS"));
					config.setPassword(properties.getProperty("UAT2Password"));
				} else if ((dataTable.getData("General_Data", "TC_ID").contains("OBAMER"))
						&& (dataTable.getData("General_Data", "TC_ID").contains("Manager"))) {
					config.setUsername(properties.getProperty("UAT2OBAMERManager"));
					config.setPassword(properties.getProperty("UAT2Password"));
				} else if ((dataTable.getData("General_Data", "TC_ID").contains("CMAMER"))
						&& (dataTable.getData("General_Data", "TC_ID").contains("Broker"))) {
					config.setUsername(properties.getProperty("UAT2CMAMERBroker"));
					config.setPassword(properties.getProperty("UAT2Password"));
				} else if ((dataTable.getData("General_Data", "TC_ID").contains("CMAMER"))
						&& (dataTable.getData("General_Data", "TC_ID").contains("Manager"))) {
					config.setUsername(properties.getProperty("UAT2CMAMERManager"));
					config.setPassword(properties.getProperty("UAT2Password"));
				} else if ((dataTable.getData("General_Data", "TC_ID").contains("CMAMER"))
						&& (dataTable.getData("General_Data", "TC_ID").contains("CSS"))) {
					config.setUsername(properties.getProperty("UAT2CMAMERCSS"));
					config.setPassword(properties.getProperty("UAT2Password"));
				}
				config.setAuthEndpoint(properties.getProperty("UAT2AuthEndpoint"));
				connection = new PartnerConnection(config);
			} else if (environment.equals("UAT")) {
				config = new ConnectorConfig();
				if ((dataTable.getData("General_Data", "TC_ID").contains("GWSAPAC"))
						&& (dataTable.getData("General_Data", "TC_ID").contains("Manager"))) {
					config.setUsername(properties.getProperty("UATGWSAPACManager"));
					config.setPassword(properties.getProperty("UATPassword"));
				} else if ((dataTable.getData("General_Data", "TC_ID").contains("GWSEMEA"))
						&& (dataTable.getData("General_Data", "TC_ID").contains("Broker"))) {
					config.setUsername(properties.getProperty("UATGWSEMEABroker"));
					config.setPassword(properties.getProperty("UATPassword"));
				} else if ((dataTable.getData("General_Data", "TC_ID").contains("VASAMER"))
						&& (dataTable.getData("General_Data", "TC_ID").contains("Manager"))) {
					config.setUsername(properties.getProperty("UATVASAMERManager"));
					config.setPassword(properties.getProperty("UATPassword"));
				} else if ((dataTable.getData("General_Data", "TC_ID").contains("VASEMEA"))
						&& (dataTable.getData("General_Data", "TC_ID").contains("Broker"))) {
					config.setUsername(properties.getProperty("UATVASEMEABroker"));
					config.setPassword(properties.getProperty("UATPassword"));
				} else if ((dataTable.getData("General_Data", "TC_ID").contains("ASAMER"))
						&& (dataTable.getData("General_Data", "TC_ID").contains("Manager"))) {
					config.setUsername(properties.getProperty("UATASAMERManager"));
					config.setPassword(properties.getProperty("UATPassword"));
				} else if ((dataTable.getData("General_Data", "TC_ID").contains("ASAPAC"))
						&& (dataTable.getData("General_Data", "TC_ID").contains("Broker"))) {
					config.setUsername(properties.getProperty("UATASAPACBroker"));
					config.setPassword(properties.getProperty("UATPassword"));
				} else if ((dataTable.getData("General_Data", "TC_ID").contains("ABAMER"))
						&& (dataTable.getData("General_Data", "TC_ID").contains("CSS"))) {
					config.setUsername(properties.getProperty("UATABAMERCSS"));
					config.setPassword(properties.getProperty("UATPassword"));
				} else if ((dataTable.getData("General_Data", "TC_ID").contains("ABAPAC"))
						&& (dataTable.getData("General_Data", "TC_ID").contains("Manager"))) {
					config.setUsername(properties.getProperty("UATABAPACManager"));
					config.setPassword(properties.getProperty("UATPassword"));
				} else if ((dataTable.getData("General_Data", "TC_ID").contains("OBAMER"))
						&& (dataTable.getData("General_Data", "TC_ID").contains("CSS"))) {
					config.setUsername(properties.getProperty("UATOBAMERCSS"));
					config.setPassword(properties.getProperty("UATPassword"));
				} else if ((dataTable.getData("General_Data", "TC_ID").contains("OBAMER"))
						&& (dataTable.getData("General_Data", "TC_ID").contains("Manager"))) {
					config.setUsername(properties.getProperty("UATOBAMERManager"));
					config.setPassword(properties.getProperty("UATPassword"));
				} else if ((dataTable.getData("General_Data", "TC_ID").contains("CMAMER"))
						&& (dataTable.getData("General_Data", "TC_ID").contains("Broker"))) {
					config.setUsername(properties.getProperty("UATCMAMERBroker"));
					config.setPassword(properties.getProperty("UATPassword"));
				} else if ((dataTable.getData("General_Data", "TC_ID").contains("CMAMER"))
						&& (dataTable.getData("General_Data", "TC_ID").contains("Manager"))) {
					config.setUsername(properties.getProperty("UATCMAMERManager"));
					config.setPassword(properties.getProperty("UATPassword"));
				} else if ((dataTable.getData("General_Data", "TC_ID").contains("CMAMER"))
						&& (dataTable.getData("General_Data", "TC_ID").contains("CSS"))) {
					config.setUsername(properties.getProperty("UATCMAMERCSS"));
					config.setPassword(properties.getProperty("UATPassword"));
				}
				config.setAuthEndpoint(properties.getProperty("UATAuthEndpoint"));
				connection = new PartnerConnection(config);
			}

		} catch (ConnectionException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Validate Opportunity Name is not auto generated when manually added by
	 * the user
	 * 
	 * @author Vishnuvardhan
	 *
	 */

	public void opportunityNameAutoGenerate() {
		Utility_Functions.xWaitForElementPresent(driver, menu_Opportunities, 3);
		Utility_Functions.xClick(driver, menu_Opportunities, true);
		Utility_Functions.xWaitForElementPresent(driver, newOpportunity, 3);
		Utility_Functions.xClick(driver, newOpportunity, true);
		Utility_Functions.timeWait(2);
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
		Utility_Functions.timeWait(2);
		Utility_Functions.xSwitchtoFrame(driver, closeDateOpp);
		Utility_Functions.timeWait(2);
		opportunityNameAutoGenerateFuntion();
	}

	public void opportunityNameAutoGenerateFuntion() {
		String sAccountName = searchOpportunity.fetchRecord("Account", "Name");
		Utility_Functions.xSendKeys(driver, accountName, sAccountName);
		Utility_Functions.timeWait(2);
		accountName.sendKeys(Keys.ARROW_DOWN);
		Utility_Functions.timeWait(2);
		accountName.sendKeys(Keys.ENTER);
		Utility_Functions.timeWait(2);
		Utility_Functions.xSelectDropdownByIndex(assignmentTypeOpp, 1);
		System.out.println(Calendar.getInstance());
		DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
		Date date = new Date();
		Utility_Functions.xSelectDropdownByIndex(leadSource, 1);
		Utility_Functions.xSendKeys(driver, closeDateOpp, dateFormat.format(date).toString());
		Utility_Functions.xSendKeys(driver, closeDateOpp, Keys.TAB);
		Random random = new Random();
		int value = random.nextInt(999);
		Utility_Functions.xSendKeys(driver, totalSizeOpp, Integer.toString(value));
		Utility_Functions.xSelectDropdownByName(unitofMeasure, "Acres");
		Utility_Functions.xWaitForElementPresent(driver, estimatedGrossFee, 3);
		Utility_Functions.xClick(driver, estimatedGrossFee, true);
		Utility_Functions.xSendKeys(driver, estimatedGrossFee, "10000");
		/*Utility_Functions.xClick(driver, estimatedGrossFee, true);
		Utility_Functions.timeWait(4);
		Utility_Functions.xSendKeys(driver, estimatedGrossFee, "10,000.00");
		Utility_Functions.timeWait(3);
		Utility_Functions.xWaitForElementPresent(driver, estimatedGrossFeeField, 3);
		Utility_Functions.xSendKeys(driver, estimatedGrossFeeField, dataTable.getData("General_Data", "InstallmentAmount"));
		*/
		try {
			Utility_Functions.xSelectDropdownByIndex(preferredPropertyTypeOpp, 1);
		} catch (Exception e) {
			e.printStackTrace();
		}
		Utility_Functions.xClick(driver, saveNewOpportunity, true);
		Utility_Functions.timeWait(4);
		driver.navigate().refresh();
		Utility_Functions.timeWait(2);
		 
		 Utility_Functions.xClick(driver, editOpportunity, true);
		 Utility_Functions.timeWait(3);
		 Utility_Functions.xSwitchtoFrame(driver, EditEstimatedGrossFee);
		 Utility_Functions.xClickHiddenElement(driver, EditEstimatedGrossFee);
		 Utility_Functions.timeWait(2);
		 Utility_Functions.xSendKeys(driver, EditEstimatedGrossFee, "75000");
		
		 Utility_Functions.timeWait(2);
		 Utility_Functions.xClick(driver, SaveEditOpportunity, true);
		 Utility_Functions.timeWait(2);
		
		
	}
	
	/**
	 * Function for edit opportunity
	 * 
	 * @author cognizant
	 *
	 */
	    public void editCloseDate() {
	     Utility_Functions.xClick(driver, editOpportunity, true);
		 Utility_Functions.timeWait(3);
		 Utility_Functions.xClick(driver, CloseDateEditOpportunity, true);
		 Utility_Functions.timeWait(2);
		 Utility_Functions.xClick(driver, DateTodayEdit, true);
		 Utility_Functions.timeWait(2);
		 
			 Utility_Functions.xClick(driver, SaveEditOpportunity, true);
			 Utility_Functions.timeWait(2);
		
	}
	    
	    public void addingInstallmentsAmount() {
			Utility_Functions.timeWait(1);
			Utility_Functions.xWaitForElementPresent(driver, showMoreActions, 4);
			Utility_Functions.xClick(driver, showMoreActions, true);
			Utility_Functions.timeWait(1);
			Utility_Functions.xWaitForElementPresent(driver, recalculate, 2);
			Utility_Functions.xClick(driver, recalculate, true);
			Utility_Functions.xSwitchtoFrame(driver, InstallmentAmountEdit);
			Utility_Functions.xWaitForElementPresent(driver, InstallmentAmountEdit, 3);
			InstallmentAmountEdit.clear();
			Utility_Functions.xSendKeys(driver, InstallmentAmountEdit,"50000");
			Utility_Functions.xWaitForElementPresent(driver, proceed, 3);
			Utility_Functions.xClick(driver, proceed, true);
			Utility_Functions.xWaitForElementPresent(driver, continueButtonInstallment, 3);
			Utility_Functions.xClick(driver, continueButtonInstallment, true);
			driver.switchTo().defaultContent();
			Utility_Functions.timeWait(2);
		}

	/**
	 * Function for multiple installments
	 * 
	 * @author Vishnuvardhan
	 *
	 */

	public void multipleInstallmentsFunction() {
		opportunityNameAutoGenerate();
		Utility_Functions.timeWait(2);
		// driver.navigate().refresh();
		Utility_Functions.xWaitForElementPresent(driver, related, 5);
		Utility_Functions.xClick(driver, related, true);
		Utility_Functions.xWaitForElementPresent(driver, installmentAmount, 3);
		String sInstallmentAmount = installmentAmount.getText();
		sInstallmentAmount = sInstallmentAmount.split(" ")[1];
		// String formatInstallmentAmount = sInstallmentAmount.replace(",", "");
		if (sInstallmentAmount.equals((dataTable.getData("General_Data", "InstallmentAmount") + ".00"))) {
			report.updateTestLog("Opportunities Installments",
					"Opportunity installment amount record is present in the opportunity installment related list:::",
					Status.PASS);
		} else {
			report.updateTestLog("Opportunities Installments",
					"Opportunity installment amount record is present in the opportunity installment related list:::",
					Status.PASS);
		}
		Utility_Functions.timeWait(2);
	}

	/**
	 * Verify editing of multiple Installments functions for Opportunity based
	 * on Even Percent Occupier Brokerage
	 * 
	 * @author Vishnuvardhan
	 *
	 */

	public void occupierBrokerage() {
		Utility_Functions.xScrollWindow(driver);
		Utility_Functions.timeWait(1);
		Utility_Functions.xScrollWindowTop(driver);
		Utility_Functions.timeWait(2);
		Utility_Functions.xWaitForElementPresent(driver, estimatedGrossFeeEdit, 3);
		estimatedGrossFeeEdit.clear();
		if ((dataTable.getData("General_Data", "TC_ID").contains("MultipleInstallmentsEven"))
				|| (dataTable.getData("General_Data", "TC_ID").contains("EstimatedGrossFeeCommission"))
				|| (dataTable.getData("General_Data", "TC_ID").contains("InLineEditEvenPercent"))) {
			Utility_Functions.xSendKeys(driver, estimatedGrossFeeEdit, "20,000");
			report.updateTestLog("Opportunities Installments",
					"Opportunity installment entered as 20,000 successfully:::", Status.PASS);
		} else if ((dataTable.getData("General_Data", "TC_ID").contains("MultipleInstallmentsUnEven"))
				|| (dataTable.getData("General_Data", "TC_ID").contains("InLineEditUnEvenPercent"))) {
			Utility_Functions.xSendKeys(driver, estimatedGrossFeeEdit, "6,000");
			report.updateTestLog("Opportunities Installments",
					"Opportunity installment entered as 6,000 successfully:::", Status.PASS);
		}
		Utility_Functions.timeWait(5);
		Utility_Functions.xWaitForElementPresent(driver, save, 4);
		Utility_Functions.xHighlight(driver, save, "yellow");
		actions.moveToElement(save).click().perform();
		Utility_Functions.timeWait(4);
	}

	/**
	 * Verify editing of multiple Installments functions for Opportunity based
	 * on Even Percent Agency Brokerage
	 * 
	 * @author Vishnuvardhan
	 *
	 */

	public void agencyBrokerage() {
		driver.navigate().refresh();
		Utility_Functions.xSwitchtoFrame(driver, agencyBrokerageFrame);
		Utility_Functions.timeWait(2);
		Utility_Functions.xScrollWindow(driver);
		Utility_Functions.timeWait(1);
		Utility_Functions.xScrollWindowTop(driver);
		Utility_Functions.timeWait(2);
		Utility_Functions.xWaitForElementPresent(driver, estimatedGrossFee, 3);
		estimatedGrossFee.clear();
		if ((dataTable.getData("General_Data", "TC_ID").contains("MultipleInstallmentsEven"))
				|| (dataTable.getData("General_Data", "TC_ID").contains("EstimatedGrossFeeCommission"))
				|| (dataTable.getData("General_Data", "TC_ID").contains("InLineEditEvenPercent"))) {
			Utility_Functions.xSendKeys(driver, estimatedGrossFee, "20,000");
			report.updateTestLog("Opportunities Installments",
					"Opportunity installment entered as 20,000 successfully:::", Status.PASS);
		} else if ((dataTable.getData("General_Data", "TC_ID").contains("MultipleInstallmentsUnEven"))
				|| (dataTable.getData("General_Data", "TC_ID").contains("InLineEditUnEvenPercent"))) {
			Utility_Functions.xSendKeys(driver, estimatedGrossFee, "6,000");
			report.updateTestLog("Opportunities Installments",
					"Opportunity installment entered as 6,000 successfully:::", Status.PASS);
		}
		Utility_Functions.timeWait(3);
		Utility_Functions.xWaitForElementPresent(driver, saveButton_AB, 3);
		Utility_Functions.xClick(driver, saveButton_AB, true);
		Utility_Functions.timeWait(1);
		driver.switchTo().defaultContent();
		// Utility_Functions.xSwitchtoFrame(driver, related);
		Utility_Functions.timeWait(2);
	}

	/**
	 * Function for adding the installments for Opportunities
	 * 
	 * @author Vishnuvardhan
	 *
	 */

	public void addingInstallmentsOpportunities() {
		Utility_Functions.timeWait(1);
		Utility_Functions.xWaitForElementPresent(driver, showMoreActions, 4);
		Utility_Functions.xClick(driver, showMoreActions, true);
		Utility_Functions.timeWait(1);
		Utility_Functions.xWaitForElementPresent(driver, recalculate, 2);
		Utility_Functions.xClick(driver, recalculate, true);
		Utility_Functions.xSwitchtoFrame(driver, installmentQuantity);
		Utility_Functions.xWaitForElementPresent(driver, installmentQuantity, 3);
		installmentQuantity.clear();
		Utility_Functions.xSendKeys(driver, installmentQuantity,"4");
		Utility_Functions.xWaitForElementPresent(driver, proceed, 3);
		Utility_Functions.xClick(driver, proceed, true);
		Utility_Functions.xWaitForElementPresent(driver, continueButtonInstallment, 3);
		Utility_Functions.xClick(driver, continueButtonInstallment, true);
		driver.switchTo().defaultContent();
		Utility_Functions.timeWait(2);
	}

	/**
	 * Verify editing of multiple Installments from Opportunity based on Even
	 * Percent
	 * 
	 * @author Vishnuvardhan
	 *
	 */

	public void multipleInstallmentsOpportunityEvenPercent() {
		multipleInstallmentsFunction();
		/*
		 * Utility_Functions.xWaitForElementPresent(driver, showMoreActions, 2);
		 * Utility_Functions.xClick(driver, showMoreActions, true);
		 * Utility_Functions.timeWait(1);
		 * Utility_Functions.xWaitForElementPresent(driver, recalculate, 2);
		 * Utility_Functions.xClick(driver, recalculate, true);
		 * Utility_Functions.xSwitchtoFrame(driver, installmentQuantity);
		 * Utility_Functions.xWaitForElementPresent(driver, installmentQuantity,
		 * 3); installmentQuantity.clear(); Utility_Functions.xSendKeys(driver,
		 * installmentQuantity, "2");
		 * Utility_Functions.xWaitForElementPresent(driver, proceed, 3);
		 * Utility_Functions.xClick(driver, proceed, true);
		 * Utility_Functions.xWaitForElementPresent(driver,
		 * continueButtonInstallment, 3); Utility_Functions.xClick(driver,
		 * continueButtonInstallment, true); driver.switchTo().defaultContent();
		 */
		addingInstallmentsOpportunities();
		Utility_Functions.xWaitForElementPresent(driver, related, 4);
		Utility_Functions.xClick(driver, related, true);
		Utility_Functions.xWaitForElementPresent(driver, installmentsViewAll, 3);
		Utility_Functions.xClick(driver, installmentsViewAll, true);
		Utility_Functions.xWaitForElementPresent(driver, opportunityNameLink, 3);
		Utility_Functions.xClick(driver, opportunityNameLink, true);
		Utility_Functions.xWaitForElementPresent(driver, related, 3);
		Utility_Functions.xClick(driver, related, true);
		Utility_Functions.xWaitForElementPresent(driver, installmentAmountOne, 3);
		Utility_Functions.xWaitForElementPresent(driver, installmentAmountTwo, 3);
		String sInstallmentAmountOne = installmentAmountOne.getText();
		String sInstallmentAmountTwo = installmentAmountTwo.getText();
		report.updateTestLog("Opportunities Installments",
				"Opportunity installment amount one and two after changing the quantity to two from one:::"
						+ sInstallmentAmountOne + ":::" + sInstallmentAmountTwo,
						Status.PASS);

		Utility_Functions.xWaitForElementPresent(driver, editButtonInstallment, 5);
		Utility_Functions.xClick(driver, editButtonInstallment, true);
		if (dataTable.getData("General_Data", "TC_ID").contains("OB")) {
			occupierBrokerage();
		} else if (dataTable.getData("General_Data", "TC_ID").contains("AB")) {
			agencyBrokerage();
		}
		Utility_Functions.timeWait(2);
		/*
		 * Utility_Functions.xWaitForElementPresent(driver, related, 3);
		 * Utility_Functions.xClick(driver, related, true);
		 */
		driver.navigate().refresh();
		Utility_Functions.xWaitForElementPresent(driver, related, 3);
		Utility_Functions.xClick(driver, related, true);
		sInstallmentAmountOne = installmentAmountOne.getText();
		sInstallmentAmountTwo = installmentAmountTwo.getText();
		System.out.println(sInstallmentAmountOne);
		System.out.println(sInstallmentAmountTwo);
		if (sInstallmentAmountOne.equals("USD 10,000.00") && sInstallmentAmountTwo.equals("USD 10,000.00")) {
			report.updateTestLog("Opportunities Installments",
					"Opportunity installment amounts recalculated successfully after editing the Estimated Gross Fee:::"
							+ sInstallmentAmountOne + ":::" + sInstallmentAmountTwo,
							Status.PASS);
		} else {
			report.updateTestLog("Opportunities Installments", "Opportunity installment amounts recalculation failed:::"
					+ sInstallmentAmountOne + ":::" + sInstallmentAmountTwo, Status.FAIL);
		}

	}

	/**
	 * Verify editing of multiple Installments from Opportunity based on UnEven
	 * Percent
	 * 
	 * @author Vishnuvardhan
	 *
	 */
	public void multipleInstallmentsUnEvenPercent() {
		multipleInstallmentsFunction();
		Utility_Functions.xWaitForElementPresent(driver, editButtonInstallment, 5);
		Utility_Functions.xClick(driver, editButtonInstallment, true);
		if (dataTable.getData("General_Data", "TC_ID").contains("OB")) {
			occupierBrokerage();
		} else if (dataTable.getData("General_Data", "TC_ID").contains("AB")) {
			agencyBrokerage();
		}
		Utility_Functions.xWaitForElementPresent(driver, showMoreActions, 2);
		Utility_Functions.xClick(driver, showMoreActions, true);
		Utility_Functions.timeWait(1);
		Utility_Functions.xWaitForElementPresent(driver, newOpportunityInstallment, 2);
		Utility_Functions.xClick(driver, newOpportunityInstallment, true);
		Utility_Functions.xWaitForElementPresent(driver, installmentNumber, 4);
		Utility_Functions.xSendKeys(driver, installmentNumber, "2");
		Utility_Functions.xSendKeys(driver, editInstallmentAmount, "4,000");
		DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
		Date date = new Date();
		Utility_Functions.xSendKeys(driver, installmentDate, dateFormat.format(date).toString());
		actions.moveToElement(saveNewOpportunityInstallment).click().perform();
		Utility_Functions.timeWait(3);
		Utility_Functions.xWaitForElementPresent(driver, related, 3);
		Utility_Functions.xClick(driver, related, true);
		Utility_Functions.xWaitForElementPresent(driver, installmentsViewAll, 3);
		Utility_Functions.xClick(driver, installmentsViewAll, true);
		Utility_Functions.xWaitForElementPresent(driver, opportunityNameLink, 3);
		Utility_Functions.xClick(driver, opportunityNameLink, true);
		Utility_Functions.xWaitForElementPresent(driver, related, 3);
		Utility_Functions.xClick(driver, related, true);
		String sInstallmentAmountOne = installmentAmountOne.getText();
		String sInstallmentAmountTwo = installmentAmountTwo.getText();
		System.out.println(sInstallmentAmountOne);
		System.out.println(sInstallmentAmountTwo);
		if (sInstallmentAmountOne.equals("USD 6,000.00") && sInstallmentAmountTwo.equals("USD 4,000.00")) {
			report.updateTestLog("Opportunities Installments",
					"Opportunity installment amounts recalculated successfully after editing the Estimated Gross Fee:::"
							+ sInstallmentAmountOne + ":::" + sInstallmentAmountTwo,
							Status.PASS);
		} else {
			report.updateTestLog("Opportunities Installments", "Opportunity installment amounts recalculation failed:::"
					+ sInstallmentAmountOne + ":::" + sInstallmentAmountTwo, Status.WARNING);
		}
		Utility_Functions.timeWait(2);
		Utility_Functions.xWaitForElementPresent(driver, editButtonInstallment, 5);
		Utility_Functions.xClick(driver, editButtonInstallment, true);
		if (dataTable.getData("General_Data", "TC_ID").contains("OB")) {
			Utility_Functions.xScrollWindow(driver);
			Utility_Functions.timeWait(1);
			Utility_Functions.xScrollWindowTop(driver);
			Utility_Functions.timeWait(2);
			Utility_Functions.xWaitForElementPresent(driver, estimatedGrossFeeEdit, 3);
			estimatedGrossFeeEdit.clear();
			Utility_Functions.xSendKeys(driver, estimatedGrossFeeEdit, "20,000");
			Utility_Functions.timeWait(5);
			Utility_Functions.xWaitForElementPresent(driver, save, 4);
			Utility_Functions.xHighlight(driver, save, "yellow");
			actions.moveToElement(save).click().perform();
			Utility_Functions.timeWait(4);
		} else if (dataTable.getData("General_Data", "TC_ID").contains("AB")) {
			driver.navigate().refresh();
			Utility_Functions.xSwitchtoFrame(driver, agencyBrokerageFrame);
			Utility_Functions.timeWait(2);
			Utility_Functions.xScrollWindow(driver);
			Utility_Functions.timeWait(1);
			Utility_Functions.xScrollWindowTop(driver);
			Utility_Functions.timeWait(2);
			Utility_Functions.xWaitForElementPresent(driver, estimatedGrossFee, 3);
			estimatedGrossFee.clear();
			Utility_Functions.xSendKeys(driver, estimatedGrossFee, "20,000");
			Utility_Functions.xWaitForElementPresent(driver, saveButton_AB, 3);
			Utility_Functions.xClick(driver, saveButton_AB, true);
			Utility_Functions.timeWait(1);
			driver.switchTo().defaultContent();
			// Utility_Functions.xSwitchtoFrame(driver, related);
			Utility_Functions.timeWait(2);
		}
		Utility_Functions.xWaitForElementPresent(driver, related, 3);
		Utility_Functions.xClick(driver, related, true);
		sInstallmentAmountOne = installmentAmountOne.getText();
		sInstallmentAmountTwo = installmentAmountTwo.getText();
		System.out.println(sInstallmentAmountOne);
		System.out.println(sInstallmentAmountTwo);
		if (sInstallmentAmountOne.equals("USD 12,000.00") && sInstallmentAmountTwo.equals("USD 8,000.00")) {
			report.updateTestLog("Opportunities Installments",
					"Opportunity installment amounts recalculated successfully after editing the Estimated Gross Fee:::"
							+ sInstallmentAmountOne + ":::" + sInstallmentAmountTwo,
							Status.PASS);
		} else {
			report.updateTestLog("Opportunities Installments", "Opportunity installment amounts recalculation failed:::"
					+ sInstallmentAmountOne + ":::" + sInstallmentAmountTwo, Status.WARNING);
		}

	}

	/**
	 * Verify editing of multiple Installments from Opportunity based on Uneven
	 * Percent using API
	 * 
	 * @author Vishnuvardhan
	 *
	 */

	public String opportunityWithInstallmentAmount() {
		EstablishConnection establishConnection = new EstablishConnection(scriptHelper);
		try {
			establishConnection.establishConnection();
			SObject opportunity = new SObject();
			opportunity.setType("Opportunity");
			String accountId = searchOpportunity.fetchRecord("Account", "Id");
			int value = Utility_Functions.xRandomFunction();
			opportunity.setField("Name", "Test Automation_" + value);
			opportunity.setField("AccountId", accountId);
			opportunity.setField("CloseDate", Calendar.getInstance());
			opportunity.setField("RecordTypeId", "012i0000000405nAAA");
			opportunity.setField("StageName", "02-Meeting");
			opportunity.setField("Service__c", "Occupier Buyer");
			opportunity.setField("Total_Size__c", 5000);
			opportunity.setField("Unit_of_Measure__c", "Acres");
			opportunity.setField("Amount", "50000");

			SObject[] opportunities = new SObject[1];
			opportunities[0] = opportunity;
			results = EstablishConnection.connection.create(opportunities);
			report.updateTestLog("Opportunity Name",
					"Opportunity for the record type Asset Services is created successfully:::", Status.PASS);
			System.out.println("Result:::" + results);
			for (int j = 0; j < results.length; j++) {
				if (results[j].isSuccess()) {
					result = results[j].getId();
					System.out.println("Save Results:::" + result);
					report.updateTestLog("Opportunity Name", "Opportunity Id:::" + result + " successfully:::",
							Status.PASS);
				}
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
			System.out.println(e.getStackTrace());
		}
		String queryAmount = "Select Estimated_Gross_Fee_Commission__c from opportunity where Id = " + "'" + result
				+ "'";
		String queryCount = "Select Installment_Count__c from opportunity where Id = " + "'" + result + "'";
		String queryQuantity = "Select Installment_Quantity__c from opportunity where Id = " + "'" + result + "'";
		String queryTotal = "Select Installments_Total__c from opportunity where Id = " + "'" + result + "'";

		String sInstallmentAmount = searchOpportunity.fetchRecordFieldValue("Estimated_Gross_Fee_Commission__c",
				queryAmount);
		String sInstallmentCount = searchOpportunity.fetchRecordFieldValue("Installment_Count__c", queryCount);
		String sInstallmentQuantity = searchOpportunity.fetchRecordFieldValue("Installment_Quantity__c", queryQuantity);
		String sInstallmentTotal = searchOpportunity.fetchRecordFieldValue("Installments_Total__c", queryTotal);

		System.out.println("Installment Amount:: " + sInstallmentAmount);
		if (sInstallmentAmount.equals("50000.0")) {
			report.updateTestLog("Opportunity Name", "Installment Record has been created successfully:::" + result
					+ ":::InstallmentAmount:::" + sInstallmentAmount + ":::", Status.PASS);
			report.updateTestLog("Opportunity Name", "Installment Record has been created successfully:::" + result
					+ ":::InstallmentCount:::" + sInstallmentCount + ":::", Status.PASS);
			report.updateTestLog("Opportunity Name", "Installment Record has been created successfully:::" + result
					+ ":::InstallmentQuanity:::" + sInstallmentQuantity + ":::", Status.PASS);
			report.updateTestLog("Opportunity Name", "Installment Record has been created successfully:::" + result
					+ ":::InstallmentTotal:::" + sInstallmentTotal + ":::", Status.PASS);
		} else {
			report.updateTestLog("Opportunity Name",
					"Installment Record creation failed:::" + result + ":::" + sInstallmentAmount + ":::", Status.FAIL);
		}
		return result;

	}

	/**
	 * Verify editing of multiple Installments for Opportunity Even Percent
	 * using API
	 * 
	 * @author Vishnuvardhan
	 *
	 */

	public void multipleInstallmentsOpportunityEvenPercent_API() {
		String opportunityID = opportunityWithInstallmentAmount();

		String queryQuantity = "Select Installment_Quantity__c from opportunity where Id = " + "'" + result + "'";
		opportunitiesFunctions.updateOpportunityField("Installment_Quantity__c", opportunityID);
		String siInstallmentQuantity = searchOpportunity.fetchRecordFieldValue("Installment_Quantity__c",
				queryQuantity);
		if (siInstallmentQuantity.equals("2.0")) {
			report.updateTestLog("Opportunity Name", "Installment Quantity has been created successfully:::" + result
					+ ":::InstallmentQuanity:::" + siInstallmentQuantity + ":::", Status.PASS);
		} else {
			report.updateTestLog("Opportunity Name", "Installment Quantity updation failed:::" + result
					+ ":::InstallmentQuanity:::" + siInstallmentQuantity + ":::", Status.FAIL);
		}
	}

	/**
	 * Verify mutiple installments based on Pending and Paid Status
	 * 
	 * @author Vishnuvardhan
	 *
	 */

	public void multipleInstallmentsPendingPaid() {

	}

	/**
	 * Verify the ability of deleting an installment
	 * 
	 * @author Vishnuvardhan
	 *
	 */

	public void deleteInstallment() {
		try {
			// multipleInstallmentsOpportunityEvenPercent();
			Utility_Functions.xWaitForElementPresent(driver, menu_Opportunities, 3);
			Utility_Functions.xClick(driver, menu_Opportunities, true);
			Utility_Functions.xWaitForElementPresent(driver, opportunitiesList, 3);
			Utility_Functions.xclickRandomElement(opportunitiesList);
			Utility_Functions.timeWait(1);
			Utility_Functions.xWaitForElementPresent(driver, related, 4);
			Utility_Functions.xClick(driver, related, true);
			Utility_Functions.xWaitForElementPresent(driver, arrowDown, 3);
			Utility_Functions.xClick(driver, arrowDown, true);
			Utility_Functions.timeWait(1);
			List<WebElement> actionList = driver.findElements(By.xpath("//div[@class='actionMenu']//a"));
			for (WebElement element : actionList) {
				if (!element.getText().contains("Delete")) {
					report.updateTestLog("Opportunities Installments",
							"Installment cannot be deleted as the Delete button is not getting displayed when we try to delete the installment via script:",
							Status.PASS);
				} else {
					report.updateTestLog("Opportunities Installments", "Installment Deletion Failed", Status.FAIL);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Verify the round off functionality for Opportunity Installments
	 * 
	 * @author Vishnuvardhan
	 *
	 */

	static ArrayList<String> installmentList = new ArrayList<String>();
	static ArrayList<String> installmentList1 = new ArrayList<String>();

	public void recalculateRoundOffRule() {
		multipleInstallmentsFunction();
		addingInstallmentsOpportunities();
		Utility_Functions.xWaitForElementPresent(driver, related, 3);
		Utility_Functions.xClick(driver, related, true);
		Utility_Functions.xWaitForElementPresent(driver, installmentsViewAll, 3);
		Utility_Functions.xClick(driver, installmentsViewAll, true);
		Utility_Functions.xWaitForElementPresent(driver, opportunityNameLink, 3);
		Utility_Functions.xClick(driver, opportunityNameLink, true);
		Utility_Functions.xWaitForElementPresent(driver, related, 3);
		Utility_Functions.xClick(driver, related, true);
		Utility_Functions.xWaitForElementPresent(driver, installmentAmountOne, 3);
		Utility_Functions.xWaitForElementPresent(driver, installmentAmountTwo, 3);
		Utility_Functions.xWaitForElementPresent(driver, installmentAmountThree, 3);
		String sInstallmentAmountOne = installmentAmountOne.getText();
		String sInstallmentAmountTwo = installmentAmountTwo.getText();
		String sInstallmentAmountThree = installmentAmountThree.getText();
		report.updateTestLog("Opportunities Installments",
				"Opportunity installment amount one and two after changing the quantity to two from one:::"
						+ sInstallmentAmountOne + ":::" + sInstallmentAmountTwo + ":::" + sInstallmentAmountThree,
						Status.PASS);
		String sEstimatedGrossAmount = dataTable.getData("General_Data", "InstallmentAmount").replace(",", "");
		String sInstallments = dataTable.getData("General_Data", "InstallmentQuantity");
		double dInstallment = ((double) Integer.parseInt(sEstimatedGrossAmount)) / Integer.parseInt(sInstallments);
		System.out.println(dInstallment);
		BigDecimal bFirstInstallmentAmount = truncateDecimal(dInstallment, 2);
		String sThirdInstallment = (new DecimalFormat(".##").format(dInstallment));
		System.out.println(sThirdInstallment);
		installmentList.add(sThirdInstallment);
		installmentList.add(sThirdInstallment);
		installmentList.add(bFirstInstallmentAmount.toString());
		int count = 0;
		for (int i = 0; i < installmentList.size(); i++) {
			if (sInstallmentAmountOne.replaceAll(",", "").contains(installmentList.get(i))) {
				count++;
			} else if (sInstallmentAmountTwo.replaceAll(",", "").contains(installmentList.get(i))) {
				count++;
			} else if (sInstallmentAmountThree.replaceAll(",", "").contains(installmentList.get(i))) {
				count++;
			}
		}
		if (count == 3) {
			report.updateTestLog("Opportunities Installments",
					"First, Second and Third Installment amounts calculated successfully:::" + bFirstInstallmentAmount
					+ "::::" + bFirstInstallmentAmount + "::::" + sThirdInstallment,
					Status.PASS);
		} else {
			installmentList1.add(bFirstInstallmentAmount.toString());
			installmentList1.add(bFirstInstallmentAmount.toString());
			installmentList1.add(sThirdInstallment);
			int count1 = 0;
			for (int i = 0; i < installmentList1.size(); i++) {
				if (sInstallmentAmountOne.replaceAll(",", "").contains(installmentList1.get(i))) {
					count++;
				} else if (sInstallmentAmountTwo.replaceAll(",", "").contains(installmentList1.get(i))) {
					count++;
				} else if (sInstallmentAmountThree.replaceAll(",", "").contains(installmentList1.get(i))) {
					count++;
				}
			}
			if (count1 == 3) {
				report.updateTestLog("Opportunities Installments",
						"First, Second and Third Installment amounts calculated successfully:::"
								+ bFirstInstallmentAmount + "::::" + bFirstInstallmentAmount + "::::"
								+ sThirdInstallment,
								Status.PASS);
			} else {
				report.updateTestLog("Opportunities Installments",
						"First, Second and Third Installment calculation failed:::" + bFirstInstallmentAmount + "::::"
								+ bFirstInstallmentAmount + "::::" + sThirdInstallment,
								Status.WARNING);
			}
		}
	}

	private static BigDecimal truncateDecimal(double installmentAmount, int numberofDecimals) {
		if (installmentAmount > 0) {
			return new BigDecimal(String.valueOf(installmentAmount)).setScale(numberofDecimals, BigDecimal.ROUND_FLOOR);
		} else {
			return new BigDecimal(String.valueOf(installmentAmount)).setScale(numberofDecimals,
					BigDecimal.ROUND_CEILING);
		}
	}

	/**
	 * Verify for validating the Opportunity eligibility
	 * 
	 * @author Vishnuvardhan
	 *
	 */

	public void opportunityEligibility() {
		Utility_Functions.xWaitForElementPresent(driver, menu_Opportunities, 3);
		Utility_Functions.xClick(driver, menu_Opportunities, true);
		//Utility_Functions.xWaitForElementPresent(driver, opportunitiesList, 3);
		Utility_Functions.timeWait(1);
		if (opportunitiesList.isEmpty()) {
			Utility_Functions.xWaitForElementPresent(driver, recentlyViewed, 3);
			Utility_Functions.xClick(driver, recentlyViewed, true);
			Utility_Functions.xWaitForElementPresent(driver, allActiveOpportunities, 3);
			Utility_Functions.xClick(driver, allActiveOpportunities, true);
			Utility_Functions.timeWait(2);
			Utility_Functions.xWaitForElementPresent(driver, opportunitiesList, 3);
			Utility_Functions.xclickRandomElement(opportunitiesList);
		}
		Utility_Functions.xclickRandomElement(opportunitiesList);
		Utility_Functions.timeWait(1);
	}

	/**
	 * Verify whether the user able to edit the paid installment
	 * 
	 * @author Vishnuvardhan
	 *
	 */

	public void editPaidInstallmentAmount() {
		/*
		 * String query =
		 * "SELECT Opportunity_ID__c FROM Opportunity_Installments__c WHERE Installment_Amount__c != 0 limit 1"
		 * ; String sOpportunityID =
		 * searchOpportunity.fetchRecordFieldValue("Opportunity_ID__c", query);
		 * report.updateTestLog("Verify Opportunity",
		 * "Opportunity retrived from database successfully:::" +
		 * sOpportunityID, Status.PASS); String url =
		 * driver.getCurrentUrl().split("#")[0]; String newUrl = url +
		 * "#/sObject/" + sOpportunityID; newUrl = newUrl + "/view";
		 * report.updateTestLog("Verify Opportunity"
		 * ,"URL has been replaced with the new URL having the retrieved Opportunity:::"
		 * + newUrl, Status.PASS); driver.get(newUrl);
		 */

		boolean isStatus = false;
		int iInstallmentAmountOne = 0;
		while (!isStatus) {
			labelA: {
			opportunityEligibility();
			Utility_Functions.timeWait(4);
			driver.navigate().refresh();
			Utility_Functions.xWaitForElementPresent(driver, related, 5);
			Utility_Functions.xClick(driver, related, true);
			Utility_Functions.xWaitForElementPresent(driver, installmentAmountOne, 3);
			String sInstallmentAmountOne = installmentAmountOne.getText();
			sInstallmentAmountOne = sInstallmentAmountOne.split(" ")[1];
			sInstallmentAmountOne = sInstallmentAmountOne.replaceAll(",", "");
			double dInstallmentAmountOne = Double.parseDouble(sInstallmentAmountOne);
			iInstallmentAmountOne = Double.valueOf(dInstallmentAmountOne).intValue();
			if (iInstallmentAmountOne > 0) {
				report.updateTestLog("Opportunities Installments",
						"Opportunity is eligible for editing the Installments::", Status.PASS);
				Utility_Functions.xWaitForElementPresent(driver, arrowDown, 3);
				Utility_Functions.xClick(driver, arrowDown, true);
				Utility_Functions.timeWait(1);
				List<WebElement> actionList = driver.findElements(By.xpath("//div[@class='actionMenu']//a"));
				for (WebElement element : actionList) {
					if (element.getText().contains("Edit")) {
						element.click();
						report.updateTestLog("Opportunities Installments",
								"Clicked on edit installments button successfully::", Status.PASS);
					} else {
						report.updateTestLog("Opportunities Installments",
								"Unable to click on edit installment button", Status.FAIL);
					}
				}
				Utility_Functions.xWaitForElementPresent(driver, installmentOption, 3);
				Utility_Functions.xClick(driver, installmentOption, true);
				if (installmentOption.getText().contains("Paid")) {
					report.updateTestLog("Opportunities Installments",
							"Opportunity not is eligible as the installment amount is already paid::",
							Status.WARNING);
					isStatus = false;
					Utility_Functions.xWaitForElementPresent(driver, cancel, 3);
					Utility_Functions.xClick(driver, cancel, true);
					Utility_Functions.timeWait(2);
					break labelA;
				}
				DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
				Date date = new Date();
				Utility_Functions.timeWait(1);
				Utility_Functions.xClick(driver, installmentStatus, true);
				Utility_Functions.xSendKeys(driver, datePaid, dateFormat.format(date).toString());
				Utility_Functions.xWaitForElementPresent(driver, accountRoleOption, 3);
				Utility_Functions.xClick(driver, accountRoleOption, true);
				Utility_Functions.timeWait(1);
				Utility_Functions.xClick(driver, accountRole, true);
				Utility_Functions.timeWait(2);
				Utility_Functions.xWaitForElementPresent(driver, save, 4);
				Utility_Functions.xClick(driver, save, true);
				report.updateTestLog("Opportunities Installments",
						"Installment Amount has been paid successfully::", Status.PASS);
				Utility_Functions.xWaitForElementPresent(driver, related, 3);
				driver.navigate().refresh();
				Utility_Functions.xWaitForElementPresent(driver, related, 3);
				Utility_Functions.xClick(driver, related, true);
				Utility_Functions.xWaitForElementPresent(driver, arrowDown, 3);
				Utility_Functions.xClick(driver, arrowDown, true);
				Utility_Functions.timeWait(1);
				List<WebElement> actionListEdit = driver.findElements(By.xpath("//div[@class='actionMenu']//a"));
				for (WebElement element : actionListEdit) {
					if (element.getText().contains("Edit")) {
						Utility_Functions.xWaitForElementPresent(driver, element, 3);
						element.click();
						report.updateTestLog("Opportunities Installments",
								"Clicked on edit installments button successfully::", Status.PASS);
					} else {
						report.updateTestLog("Opportunities Installments",
								"Unable to click on edit installment button", Status.FAIL);
					}
				}
				try {
					Utility_Functions.xWaitForElementPresent(driver, installmentAmountEdit, 3);
					int iInstallmentAmount = iInstallmentAmountOne + 100;
					Utility_Functions.xSendKeys(driver, installmentAmountEdit,
							Integer.toString(iInstallmentAmount));
					Utility_Functions.timeWait(2);
					Utility_Functions.xWaitForElementPresent(driver, save, 3);
					Utility_Functions.xClick(driver, save, true);
					Utility_Functions.timeWait(2);
					Utility_Functions.xWaitForElementPresent(driver, related, 3);
					if (related.isDisplayed()) {
						report.updateTestLog("Opportunities Installments",
								"Editing the Paid installment amount is successfull::", Status.PASS);
						isStatus = true;
						break;
					} else {
						report.updateTestLog("Opportunities Installments",
								"Editing the Paid installment amount is failed::", Status.FAIL);
						isStatus = true;
						break;
					}
				} catch (Exception e) {
					report.updateTestLog("Opportunities Installments", "Unable to edit the installments:::",
							Status.PASS);
					isStatus = true;
					break;
				}
			} else {
				report.updateTestLog("Opportunities Installments",
						"Opportunity not is eligible for editing the Installments::", Status.WARNING);
				isStatus = false;
				break labelA;
			}

		}
		}

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

		Utility_Functions.xWaitForElementPresent(driver, menu_Opportunities, 3);
		Utility_Functions.xClick(driver, menu_Opportunities, true);
		Utility_Functions.xWaitForElementPresent(driver, opportunitiesList, 3);
		Utility_Functions.xclickRandomElement(opportunitiesList);
		Utility_Functions.xWaitForElementPresent(driver, newEventOpp, 3);
		Utility_Functions.xClick(driver, newEventOpp, true);
		eventPage.verifyNewEventPageLayout();
		
		/*Utility_Functions.timeWait(5);
		Utility_Functions.xWaitForElementPresent(driver, selectNewEvent, 3);
		Utility_Functions.xClick(driver, selectNewEvent, true);
		Utility_Functions.xWaitForElementPresent(driver, newEvent, 3);
		actions.moveToElement(newEvent);
		actions.click();
		actions.build().perform();
		Utility_Functions.timeWait(3);
		// driver.switchTo().frame(4);
		Utility_Functions.xSwitchtoFrame(driver, saveEventCustomEventPageButton);
		Utility_Functions.timeWait(5);

		if (addAnEventPage.getText().contains("Add an Event")) {

			System.out.println("The New Custom Event Page is displayed");
			report.updateTestLog("Verify Opportunity Custom Event Page", "The New Custom Event Page is Displayed",
					Status.PASS);
		} else {
			System.out.println("The New Custom Event Page is not displayed");
			report.updateTestLog("Verify Opportunity Custom Event Page", "The New Custom Event Page is not Displayed",
					Status.FAIL);
		}

		List<WebElement> drop = driver.findElements(By.xpath("//div[@class='slds-select_container']"));

		java.util.Iterator<WebElement> i = drop.iterator();
		while (i.hasNext()) {
			WebElement row = i.next();
			System.out.println(row.getText());
			if (!row.getText().equals("")) {
				System.out.println(
						"All the values for the Activity Type and Type pick list are present in  the Add an Event page");
				report.updateTestLog("Verify New Opportunity Custom Event Page",
						"Verifying the Activity Type and Type pick list values", Status.PASS);
			} else {
				System.out.println(
						"All the values for the Activity Type and Type pick list are not present in  the Add an Event page");
				report.updateTestLog("Verify New Opportunity Custom Event Page",
						"Verifying the Activity Type and Type pick list values", Status.FAIL);
			}

		}

		if (relatedTo.getText().contains("Related To")) {
			System.out.println("Related To section is present in the New Activity Layout Page");
			report.updateTestLog("Verify New Opportunity Custom Event Page ",
					"Related To section is present in the New Custom Event Page", Status.PASS);
		} else {
			System.out.println("Related To section is not present in the New Activity Layout Page");
			report.updateTestLog("Verify New Opportunity Custom Event Page ",
					"Related To section is not present in the New Custom Event Page", Status.FAIL);

		}
		if (quickCreateanEvent.getText().contains("Quick Create an Event")) {
			System.out.println("Quick Create an Event section is present in the New Activity Layout Page");
			report.updateTestLog("Verify New Opportunity Custom Event Page ",
					"Quick Create an Event section is present in the New Activity Page", Status.PASS);
		} else {
			System.out.println("Quick Create an Event section is not present in the New Activity Layout Page");
			report.updateTestLog("Verify New Opportunity Custom Event Page ",
					"Quick Create an Event section is not present in the New Activity Page", Status.FAIL);

		}

		if (!setReminderCheckBox.isSelected()) {
			System.out.println("Set Reminder check box is present and not checked");
			report.updateTestLog("Verify New Opportunity Custom Event Page ",
					"Set Reminder checkbox is present in the New Custom Event Page", Status.PASS);

		} else {
			System.out.println("Set Reminder check box is not present ");
			report.updateTestLog("Verify New Opportunity Custom Event Page ",
					"Set Reminder checkbox is not present in the New Custom Event Page", Status.FAIL);
		}
		if ((!cancelCustomEventPageButton.getText().equals(" "))
				|| (!saveAndNewEventCustomEventPageButton.getText().equals(" "))
				|| (!saveEventCustomEventPageButton.getText().equals(" "))) {
			System.out.println("Save, Save and New and Cancel buttons are prsent in the New Activity Layout Page ");
			report.updateTestLog("Verify New Opportunity Custom Event Page  ",
					"Verifying New Custom Event Page is having the Save, Save and New and Cancel buttons ",
					Status.PASS);
		} else {
			System.out
			.println("Save, Save and New and Cancel buttons are not prsent in the New Activity Layout Page  ");
			report.updateTestLog("Verify New Opportunity Custom Event Page ",
					"Verifying New Custom Event Page is having the Save, Save and New and Cancel buttons", Status.FAIL);
		}

		try {

			if ((!assignedToNewCustomEventPage.getAttribute("value").equals(""))
					|| (!startDateNewCustomEventPage.getAttribute("value").equals(""))
					|| (!startTimeNewCustomEventPage.getAttribute("value").equals(""))
					|| (!endDateNewCustomEventPage.getAttribute("value").equals(""))
					|| (!endTimeNewCustomEventPage.getAttribute("value").equals(""))) {
				System.out.println(
						"Assigned To, Start Date, Start Time, End Date and End Time fields are having the values ");
				report.updateTestLog("Verify New Opportunity Custom Event Page ",
						"Verify New Opportunity Custom Event Page is having the default values in the required fields ",
						Status.PASS);
			} else {
				System.out.println("New Activity Layout Page is not having the deafault values ");
				report.updateTestLog("Verify New Opportunity Custom Event Page",
						"Verify New Opportunity Custom Event Page is not having the default values in the required fields",
						Status.FAIL);
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
		}

		List<WebElement> customEventpageFields = driver.findElements(By
				.xpath("//div[contains(@class,'slds-col--padded') and contains(@class,' slds-size--1-of-1')]//label"));
		int count = 0, i1 = 0;
		String labelArray[] = new String[customEventpageFields.size()];
		System.out.println(customEventpageFields.size());

		try {
			labelsOpportunitiesNewCustomEvent();
			for (WebElement element : customEventpageFields) {
				labelArray[i1] = element.getText();
				if (labelArray[i1].contains(labelsOpportunitiesNewCustomEvent.get(i1))) {
					report.updateTestLog("Verify New Opportunity Custom Event Page",
							"New Opportunity Custom Event Page is having the " + labelArray[i1] + " field ",
							Status.PASS);
					count++;
				}
				i1++;
			}
			labelsOpportunitiesNewCustomEvent.clear();
			customEventpageFields.clear();
			System.out.println(count);
			if (count != 15) {
				report.updateTestLog("Verify New Opportunity Custom Event Page",
						"All Labels are not present in the Add New Event Page", Status.FAIL);
			} else {

				report.updateTestLog("Verify New Opportunity Custom Event Page",
						"All Labels are present in the Add New Event Page", Status.PASS);
			}

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}*/

	}

	/**
	 * Validating the Opportunity record type for Occupancy Brokerage
	 * 
	 * @author Ramya
	 *
	 */
	public void verifyOpportunityRecordTypeForOccupancyBrokerage() {
		Utility_Functions.xWaitForElementPresent(driver, menu_Opportunities, 3);
		Utility_Functions.xClick(driver, menu_Opportunities, true);
		report.updateTestLog("Verify Opportunity Record Type  ", "Verifying the Opportunities page is displayed",
				Status.PASS);
		Utility_Functions.xWaitForElementPresent(driver, newOpportunity, 3);
		Utility_Functions.xClick(driver, newOpportunity, true);
		report.updateTestLog("Verify Opportunity Record Type  ", "Verifying the new opportunity page is displayed",
				Status.PASS);
		Utility_Functions.timeWait(3);
		Utility_Functions.xSwitchtoFrame(driver, continueButton);
		// driver.switchTo().frame(1);
		Utility_Functions.timeWait(3);

		if (opportunityRecordType.getText().contains("Occupier Brokerage")) {
			System.out.println(
					"Occupier Brokerage is present as the default value in the select record type opportunity page");
			report.updateTestLog("Verify Opportunity Record Type ",
					"Verifying the Occupier Brokerage is present as the default value", Status.PASS);
		} else {
			System.out.println(
					"Occupier Brokerage is not present as the default value in the select record type opportunity page");
			report.updateTestLog("Verify Opportunity Record Type  ",
					"Verifying the Occupier Brokerage is present as the default value", Status.FAIL);

		}

	}

	/**
	 * Validating the Opportunity record type for Agency Broker
	 * 
	 * @author Ramya
	 *
	 */
	public void verifyOpportunityRecordTypeForAgencyBroker() {
		Utility_Functions.xWaitForElementPresent(driver, menu_Opportunities, 3);
		Utility_Functions.xClick(driver, menu_Opportunities, true);
		report.updateTestLog("Verify Opportunity Record Type  ", "Verifying the Opportunities page is displayed",
				Status.PASS);
		Utility_Functions.xWaitForElementPresent(driver, newOpportunity, 3);
		Utility_Functions.xClick(driver, newOpportunity, true);
		report.updateTestLog("Verify Opportunity Record Type  ", "Verifying the new opportunity page is displayed",
				Status.PASS);
		Utility_Functions.timeWait(3);
		Utility_Functions.xSwitchtoFrame(driver, continueButton);
		// driver.switchTo().frame(1);
		Utility_Functions.timeWait(3);

		if (opportunityRecordType.getText().contains("Agency Brokerage")) {
			System.out.println(
					"Agency Broker is present as the default value in the select record type opportunity page");
			report.updateTestLog("Verify Opportunity Record Type ",
					"Verifying the Agency Broker is present as the default value", Status.PASS);
		} else {
			System.out.println(
					"Agency Broker is not present as the default value in the select record type opportunity page");
			report.updateTestLog("Verify Opportunity Record Type  ",
					"Verifying the Agency Broker is present as the default value", Status.FAIL);

		}

	}

	/**
	 * Validating the Opportunity record type for the Capital Markets
	 * 
	 * @author Ramya
	 *
	 */
	public void verifyOpportunityRecordTypeForCapitalMarkets() {
		Utility_Functions.xWaitForElementPresent(driver, menu_Opportunities, 3);
		Utility_Functions.xClick(driver, menu_Opportunities, true);
		report.updateTestLog("Verify Opportunity Record Type  ", "Verifying the Opportunities page is displayed",
				Status.PASS);
		Utility_Functions.xWaitForElementPresent(driver, newOpportunity, 3);
		Utility_Functions.xClick(driver, newOpportunity, true);
		report.updateTestLog("Verify Opportunity Record Type  ", "Verifying the new opportunity page is displayed",
				Status.PASS);
		Utility_Functions.timeWait(3);
		Utility_Functions.xSwitchtoFrame(driver, continueButton);
		// driver.switchTo().frame(1);
		Utility_Functions.timeWait(3);

		if (opportunityRecordType.getText().contains("Capital Markets – Property Sales")) {
			System.out.println(
					"Capital Markets – Property Sales is present as the default value in the select record type opportunity page");
			report.updateTestLog("Verify Opportunity Record Type ",
					"Verifying the Capital Markets – Property Sales is present as the default value", Status.PASS);
		} else {
			System.out.println(
					"Capital Markets – Property Sales is not present as the default value in the select record type opportunity page");
			report.updateTestLog("Verify Opportunity Record Type  ",
					"Verifying the Capital Markets – Property Sales is present as the default value", Status.FAIL);

		}

	}

	public void opportunitySplitRegression() {
		opportunityNameAutoGenerate();

		Utility_Functions.xClick(driver, related, true);
		Utility_Functions.timeWait(5);
		/*
		 * Utility_Functions.xClick(driver, addButton, true);
		 * Utility_Functions.timeWait(3);
		 */
		Utility_Functions.xClick(driver, addButtonshareOpportunity, true);
		Utility_Functions.timeWait(3);
		Utility_Functions.xSwitchtoFrame(driver, saveButtonSplit);
		// driver.switchTo().frame(3);

		Utility_Functions.timeWait(5);
		List<WebElement> opportunityList = driver.findElements(By.xpath("//div[contains(@class, 'slds-truncate')]"));
		int count = 0;
		System.out.println(opportunityList.size());
		try {
			for (WebElement element : opportunityList) {

				if ((count == 0) && (element.getText().equals("USER"))) {
					System.out.println("USER  field is present in the Add New Team Member Page");
					report.updateTestLog("Verify Opportunity Split in Opportunity Team Members Page",
							"Add New Team Member Page is having the " + element.getText() + " Status field::",
							Status.PASS);
					count++;
				} else if ((count == 1) && (element.getText().equals("TEAM MEMBER DESCRIPTION"))) {
					System.out.println("Team Member Description field is present in the Add New Team Member Page");
					report.updateTestLog("Verify Opportunity Split in Opportunity Team Members Page",
							"Add New Team Member Page is having the " + element.getText() + " Status field::",
							Status.PASS);
					count++;
				} else if ((count == 2) && (element.getText().equals("TEAM ROLE"))) {
					System.out.println("TEAM ROLE field is present in the Add New Team Member Page");
					report.updateTestLog("Verify Opportunity Split in Opportunity Team Members Page",
							"Add New Team Member Page is having the " + element.getText() + " Status field::",
							Status.PASS);
					count++;
				} else if ((count == 3) && (element.getText().equals("SECONDARY MEMBER ROLE"))) {
					System.out.println("SECONDARY MEMBER ROLE field is present in the Add New Team Member Page");
					report.updateTestLog("Verify Opportunity Split in Opportunity Team Members Page",
							"Add New Team Member Page is having the " + element.getText() + " Status field::",
							Status.PASS);
					count++;
				} else if ((count == 4) && (element.getText().equals("OPPORTUNITY ACCESS"))) {
					System.out.println("OPPORTUNITY ACCESS field is present in the Add New Team Member Page");
					report.updateTestLog("Verify Opportunity Split in Opportunity Team Members Page",
							"Add New Team Member Page is having the " + element.getText() + " Status field::",
							Status.PASS);

				}
			}
			if (dataTable.getData("General_Data", "TC_ID").contains("CMAMERBrokerOpportunitySplit")) {
				if (count != 3)
					report.updateTestLog("Verify Opportunity Split in Opportunity Team Members Page",
							"Add New Team Member Page is not having all the fields::", Status.FAIL);
			} else if (!dataTable.getData("General_Data", "TC_ID").contains("CMAMERBrokerOpportunitySplit")) {
				if (count != 4)
					report.updateTestLog("Verify Opportunity Split in Opportunity Team Members Page",
							"Add New Team Member Page is not having all the fields::", Status.FAIL);
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
		}
		Utility_Functions.timeWait(2);
		Utility_Functions.xSendKeys(driver, user1, "Inactive User");
		Utility_Functions.timeWait(1);
		user1.sendKeys(Keys.ARROW_DOWN);
		user1.sendKeys(Keys.ENTER);
		Utility_Functions.xClick(driver, selectTeamRole, true);
		Utility_Functions.timeWait(3);
		try {
			Utility_Functions.xClick(driver, selectSecondaryMemberRole, true);
			Utility_Functions.timeWait(3);
		} catch (Exception e1) {
			e1.printStackTrace();
		}
		Utility_Functions.xClick(driver, selectOpportunityAccess, true);
		Utility_Functions.timeWait(3);
		Utility_Functions.xSendKeys(driver, user2, "Test Broker1");
		Utility_Functions.timeWait(2);
		user2.sendKeys(Keys.ARROW_DOWN);
		user2.sendKeys(Keys.ENTER);
		Utility_Functions.xClick(driver, selectTeamRole2, true);
		Utility_Functions.timeWait(3);
		try {
			Utility_Functions.xClick(driver, selectSecondaryMemberRole2, true);
			Utility_Functions.timeWait(3);
		} catch (Exception e1) {
			e1.printStackTrace();
		}
		Utility_Functions.xClick(driver, saveButtonSplit, true);
		Utility_Functions.timeWait(3);
		driver.switchTo().defaultContent();
		driver.navigate().refresh();
		Utility_Functions.xWaitForElementVisible(driver, manageOpportunitySplits, 3);
		Utility_Functions.xClick(driver, manageOpportunitySplits, true);
		Utility_Functions.timeWait(4);
		driver.switchTo().frame(driver.findElement(By.xpath("//iframe")));
		splitPercent.clear();
		Utility_Functions.timeWait(3);
		splitPercent.sendKeys("100");
		try {
			Utility_Functions.xClick(driver, saveOpportunitySplit, true);
		} catch (Exception e) {
			Utility_Functions.xClick(driver, saveOpportunitySplitUAT, true);
		}
		report.updateTestLog("Verify Opportunity Split in Opportunity Team Members Page",
				"Opportunity Saved successfully::", Status.PASS);
		Utility_Functions.timeWait(3);
	}

	/**
	 * Verify the Occupier Record Type should default to 'Occupier' opportunity
	 * type field
	 * 
	 * @author Vishnuvardhan
	 *
	 */

	public void occupierRecordType() {
		Utility_Functions.xWaitForElementPresent(driver, menu_Opportunities, 4);
		Utility_Functions.xClick(driver, menu_Opportunities, true);
		Utility_Functions.timeWait(1);
		Utility_Functions.xWaitForElementPresent(driver, newOpportunity, 3);
		Utility_Functions.xClick(driver, newOpportunity, true);
		Utility_Functions.timeWait(3);
		// Utility_Functions.xSwitchtoFrame(driver, continueButton);
		Utility_Functions.xSwitchtoFrame(driver, opportunityRecordTypeQuickCreate);
		Utility_Functions.timeWait(2);
		// driver.navigate().refresh();
		if (opportunityRecordTypeQuickCreate.getText().contains("EMEA A&T Occupier")) {
			report.updateTestLog("Verify Opportunity Occupier Record Type",
					"Occupier record type is defaulted to Occupier Opportunity type field when selected:::",
					Status.PASS);
		} else {
			report.updateTestLog("Verify Opportunity Occupier Record Type",
					"Occupier record type is not defaulted to 'Occupier' Opportunity type field when selected:::",
					Status.FAIL);
		}
	}

	/**
	 * Verify the Annual Revenue field is renamed to Management Annual Revenue
	 * for Broker Profile
	 * 
	 * @author Vishnuvardhan
	 *
	 */

	public void managementAnnualRevenue() {
		Utility_Functions.xWaitForElementPresent(driver, menu_Opportunities, 4);
		Utility_Functions.xClick(driver, menu_Opportunities, true);
		Utility_Functions.timeWait(1);
		Utility_Functions.xWaitForElementPresent(driver, newOpportunity, 3);
		Utility_Functions.xClick(driver, newOpportunity, true);
		Utility_Functions.timeWait(3);
		Utility_Functions.xSwitchtoFrame(driver, continueButton);
		Utility_Functions.xClick(driver, continueButton, true);
		driver.switchTo().defaultContent();
		Utility_Functions.xWaitForElementPresent(driver, opportunityName_AS, 4);
		int value = Utility_Functions.xRandomFunction();
		Utility_Functions.xSendKeys(driver, opportunityName_AS,
				dataTable.getData("General_Data", "Account Name") + value);
		Utility_Functions.xWaitForElementPresent(driver, accountName_AS, 3);
		Utility_Functions.xSendKeys(driver, accountName_AS, "Test ");
		Utility_Functions.timeWait(1);
		Utility_Functions.xClick(driver, driver.findElement(By.xpath("//div[@title='BP Test Account']")), true);
		Utility_Functions.xWaitForElementPresent(driver, totalSize_AS, 4);
		Utility_Functions.xSendKeys(driver, totalSize_AS, "5000");
		Utility_Functions.xWaitForElementPresent(driver, unitofMeasure_AS, 4);
		Utility_Functions.xClick(driver, unitofMeasure_AS, true);
		Utility_Functions.xClick(driver, unitofMeasureValue_AS, true);
		Utility_Functions.xWaitForElementPresent(driver, type_AS, 3);
		Utility_Functions.xClick(driver, type_AS, true);
		Utility_Functions.xClick(driver, typeNewBusiness_AS, true);
		Utility_Functions.xWaitForElementPresent(driver, region_AS, 3);
		Utility_Functions.xClick(driver, region_AS, true);
		Utility_Functions.xClick(driver, regionValue_AS, true);
		Utility_Functions.xWaitForElementPresent(driver, salesStage_AS, 4);
		Utility_Functions.xClick(driver, salesStage_AS, true);
		Utility_Functions.xClick(driver, salesStageValue_AS, true);
		System.out.println(Calendar.getInstance());
		DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
		Date date = new Date();
		Utility_Functions.xWaitForElementPresent(driver, closeDate_AS, 3);
		Utility_Functions.xSendKeys(driver, closeDate_AS, dateFormat.format(date).toString());
		Utility_Functions.xWaitForElementPresent(driver, market_AS, 4);
		Utility_Functions.xClick(driver, market_AS, true);
		Utility_Functions.xWaitForElementPresent(driver, save, 3);
		Utility_Functions.xClick(driver, save, true);
		report.updateTestLog("Verify Management Annual Revenue", "Opportunity Saved successfully::", Status.PASS);
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
		Utility_Functions.xWaitForElementPresent(driver, menu_Opportunities, 3);
		Utility_Functions.xClick(driver, menu_Opportunities, true);
		report.updateTestLog("Verify Quick Create Opportunity Page  ", "Verifying the Opportunities page is displayed",
				Status.PASS);
		Utility_Functions.xWaitForElementPresent(driver, newOpportunity, 3);
		Utility_Functions.xClick(driver, newOpportunity, true);
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

	public void verifyQuickCreateOpportunityPageAssetServices() {
		Utility_Functions.xWaitForElementPresent(driver, menu_Opportunities, 3);
		Utility_Functions.xClick(driver, menu_Opportunities, true);
		report.updateTestLog("Verify Quick Create Opportunity Page Asset Services ",
				"Verifying the Opportunities page is displayed", Status.PASS);
		Utility_Functions.timeWait(2);
		Utility_Functions.xWaitForElementPresent(driver, newOpportunity, 3);
		Utility_Functions.xClick(driver, newOpportunity, true);
		report.updateTestLog("Verify Quick Create Opportunity Page Asset Services   ",
				"Verifying the new opportunity page is displayed", Status.PASS);
		Utility_Functions.timeWait(3);
		Utility_Functions.xSwitchtoFrame(driver, continueButton);
		Utility_Functions.timeWait(3);
		Utility_Functions.xClick(driver, continueButton, true);
		driver.switchTo().defaultContent();
		Utility_Functions.timeWait(2);
		Utility_Functions.xScrollWindow(driver);
		Utility_Functions.timeWait(2);
		Utility_Functions.xScrollWindowTop(driver);
		Utility_Functions.timeWait(2);
		Utility_Functions.xWaitForElementPresent(driver, reasonForLoss, 3);
		Utility_Functions.xClick(driver, reasonForLoss, true);
		Utility_Functions.xWaitForElementPresent(driver, reasonForLossValuesPickList, 3);		
		for (WebElement element : reasonForLossValuesPickList) {
			element.getText();
			System.out.println(element.getText());
			report.updateTestLog("Verify Quick Create Opportunity Page Asset Services   ",
					"Verifying the new opportunity page Reason For Loss Pick list values are present", Status.PASS);
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
		Utility_Functions.xWaitForElementPresent(driver, menu_Opportunities, 3);
		Utility_Functions.xClick(driver, menu_Opportunities, true);
		report.updateTestLog("Verify Quick Create Opportunity Page Asset Services ",
				"Verifying the Opportunities page is displayed", Status.PASS);
		Utility_Functions.timeWait(2);
		Utility_Functions.xWaitForElementPresent(driver, newOpportunity, 3);
		Utility_Functions.xClick(driver, newOpportunity, true);
		report.updateTestLog("Verify Quick Create Opportunity Page Asset Services  ",
				"Verifying the new opportunity page is displayed", Status.PASS);
		Utility_Functions.timeWait(3);

		Utility_Functions.timeWait(2);
		Utility_Functions.xScrollWindow(driver);
		Utility_Functions.timeWait(2);
		Utility_Functions.xScrollWindowTop(driver);
		Utility_Functions.timeWait(2);
		Utility_Functions.xWaitForElementPresent(driver, reasonForLoss, 3);
		Utility_Functions.xClick(driver, reasonForLoss, true);
		Utility_Functions.xWaitForElementPresent(driver, reasonForLossValuesPickList, 3);
		for (WebElement element : reasonForLossValuesPickList) {
			element.getText();
			System.out.println(element.getText());
			report.updateTestLog("Verify Quick Create Opportunity Page Asset Services   ",
					"Verifying the new opportunity page Reason For Loss Pick list values are present", Status.PASS);
		}

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

	}

	static ArrayList<String> awardToArrayList = new ArrayList<String>();

	public void verifyQuickCreateOpportunityPageAwardedPickList() {
		Utility_Functions.xWaitForElementPresent(driver, menu_Opportunities, 3);
		Utility_Functions.xClick(driver, menu_Opportunities, true);
		report.updateTestLog("Verify Quick Create Opportunity Page Awarded To Pick List ",
				"Verifying the Opportunities page is displayed", Status.PASS);
		Utility_Functions.timeWait(2);
		Utility_Functions.xWaitForElementPresent(driver, newOpportunity, 3);
		Utility_Functions.xClick(driver, newOpportunity, true);
		report.updateTestLog("Verify Quick Create Opportunity Page Awarded To Pick List   ",
				"Verifying the new opportunity page is displayed", Status.PASS);
		Utility_Functions.timeWait(3);
		Utility_Functions.xSwitchtoFrame(driver, continueButton);
		Utility_Functions.timeWait(3);
		Utility_Functions.xClick(driver, continueButton, true);
		driver.switchTo().defaultContent();
		Utility_Functions.timeWait(2);
		Utility_Functions.xScrollWindow(driver);
		Utility_Functions.timeWait(2);
		Utility_Functions.xScrollWindowTop(driver);
		Utility_Functions.timeWait(2);
		Utility_Functions.xWaitForElementPresent(driver, accountingAwardedTo, 3);
		Utility_Functions.xClick(driver, accountingAwardedTo, true);
		report.updateTestLog("Verify Quick Create Opportunity Page Awarded To Pick List   ",
				"Verifying the new opportunity page Accounting Awarded To Pick List is displayed", Status.PASS);
		int count = 0;
		Utility_Functions.xWaitForElementPresent(driver, awardedToList, 3);
		for (WebElement element : awardedToList) {
			element.getText();
			if (count < 14) {
				awardToArrayList.add(element.getText());
			}
			System.out.println(element.getText());
		}
		List<WebElement> managementAwardListFields = driver.findElements(By.xpath("//div[@class='select-options']//a[@title='BNP']/parent::li/parent::ul/li"));
		int count1 = 0, i1 = 0;
		String labelArray[] = new String[awardedToList.size()];
		try {
			managementAwardToList();
			for (WebElement element : managementAwardListFields) {
				labelArray[i1] = element.getText();
				if (labelArray[i1].contains(managementAwardToList.get(i1))) {
					report.updateTestLog("Verify Quick Create Opportunity Page Awarded To Pick List ",
							"Management Awarded to Pick list Field is having the " + labelArray[i1] + " field ",
							Status.PASS);
					count1++;
				}
				i1++;
			}
			System.out.println(count1);
			if (count1 != 13) {
				report.updateTestLog("Verify Quick Create Opportunity Page Awarded To Pick List ",
						"All the pick list values are not prsent in the Management Awarded to Pick list Field",
						Status.FAIL);
			} else {

				report.updateTestLog("Verify Quick Create Opportunity Page Awarded To Pick List ",
						"All the pick list values are prsent in the Management Awarded to Pick list Field",
						Status.PASS);
			}

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	/**
	 * Validating the Quick create Opportunity page from the Opportunity for
	 * state street pick list value
	 * 
	 * @author Ramya
	 *
	 */

	public void verifyQuickCreateOpportunityPageStateStreetPickList() {
		Utility_Functions.xWaitForElementPresent(driver, menu_Opportunities, 3);
		Utility_Functions.xClick(driver, menu_Opportunities, true);
		report.updateTestLog("Verify Quick Create Opportunity Page State Street Pick List ",
				"Verifying the Opportunities page is displayed", Status.PASS);
		Utility_Functions.timeWait(2);
		Utility_Functions.xWaitForElementPresent(driver, newOpportunity, 3);
		Utility_Functions.xClick(driver, newOpportunity, true);
		report.updateTestLog("Verify Quick Create Opportunity Page State Street Pick List  ",
				"Verifying the new opportunity page is displayed", Status.PASS);
		Utility_Functions.timeWait(3);
		Utility_Functions.xSwitchtoFrame(driver, continueButton);
		Utility_Functions.timeWait(3);
		Utility_Functions.xClick(driver, continueButton, true);
		driver.switchTo().defaultContent();
		Utility_Functions.timeWait(2);
		Utility_Functions.xScrollWindow(driver);
		Utility_Functions.timeWait(2);
		Utility_Functions.xScrollWindowTop(driver);
		Utility_Functions.timeWait(2);
		Utility_Functions.xWaitForElementPresent(driver, accountingAwardedTo, 3);
		Utility_Functions.xClick(driver, accountingAwardedTo, true);
		report.updateTestLog("Verify Quick Create Opportunity Page State Street Pick List  ",
				"Verifying the new opportunity page Accounting Awarded To Pick List is displayed", Status.PASS);
		String sStateStreet = "State Street";
		Utility_Functions.xWaitForElementPresent(driver, awardedToList, 3);
		int count = 0;
		for (WebElement element : awardedToList) {
			element.getText();
			System.out.println(element.getText());
			if (element.getText().equals(sStateStreet)) {
				System.out.println("State street pick list value is present in the AwardedTo pick list values");
				report.updateTestLog("Verify Quick Create Opportunity Page State Street Pick List  ",
						"Verifying the new opportunity page Accounting Awarded To State Street Pick List is displayed",
						Status.PASS);
				count++;
			}
		}
		if (count == 1) {
			System.out.println("State street pick list value is present in the AwardedTo pick list values");
			report.updateTestLog("Verify Quick Create Opportunity Page State Street Pick List  ",
					"Verifying the new opportunity page Awarded To State Street Pick List Pick List value is displayed",
					Status.PASS);
		} else {
			System.out.println("State street pick list value is not present");
			report.updateTestLog("Verify Quick Create Opportunity Page State Street Pick List  ",
					"Verifying the new opportunity page Awarded To State Street Pick List Pick List value is displayed",
					Status.FAIL);

		}
		Utility_Functions.xWaitForElementPresent(driver, mgmtAwardedTo, 3);
		Utility_Functions.xClick(driver, mgmtAwardedTo, true);
		report.updateTestLog("Verify Quick Create Opportunity Page State Street Pick List  ",
				"Verifying the new opportunity page Accounting Awarded To Pick List is displayed", Status.PASS);
		Utility_Functions.timeWait(1);
		String stateStreet = "State Street";
		List<WebElement> mgmtAwardedToList = driver
				.findElements(By.xpath("//div[@class='select-options']//a[@title='BNP']/parent::li/parent::ul/li"));
		int count1 = 0;

		for (WebElement element1 : mgmtAwardedToList) {
			element1.getText();
			System.out.println(element1.getText());
			if (element1.getText().equals(stateStreet)) {
				System.out.println("State street pick list value is present in the Management AwardedTo pick list");
				report.updateTestLog("Verify Quick Create Opportunity Page State Street Pick List  ",
						"Verifying the new opportunity page Management Awarded To State Street Pick List is displayed",
						Status.PASS);
				count1++;
			}
		}
		if (count1 == 1) {
			System.out.println("State street pick list value is present in the Management Awarded pick list");
			report.updateTestLog("Verify Quick Create Opportunity Page State Street Pick List  ",
					"Verifying the new opportunity page Management Awarded To State Street Pick List Pick List value is displayed",
					Status.PASS);
		} else {
			System.out.println("State street pick list value is not present in the Management pick list");
			report.updateTestLog("Verify Quick Create Opportunity Page State Street Pick List  ",
					"Verifying the new opportunity page Management Awarded To State Street Pick List Pick List value is displayed",
					Status.FAIL);

		}

	}

	/**
	 * Validating the Quick create Opportunity page from the Opportunity for
	 * state street pick list value
	 * 
	 * @author Ramya
	 *
	 */

	public void verifyNewOpportunityPageTermOfContract() {
		Utility_Functions.xWaitForElementPresent(driver, menu_Opportunities, 3);
		Utility_Functions.xClick(driver, menu_Opportunities, true);
		report.updateTestLog("Verify Quick Create Opportunity Page Term Of Contract ",
				"Verifying the Opportunities page is displayed", Status.PASS);
		Utility_Functions.timeWait(2);
		Utility_Functions.xWaitForElementPresent(driver, newOpportunity, 3);
		Utility_Functions.xClick(driver, newOpportunity, true);
		report.updateTestLog("Verify Quick Create Opportunity Page Term Of Contract   ",
				"Verifying the new opportunity page is displayed", Status.PASS);
		Utility_Functions.timeWait(3);
		Utility_Functions.xSwitchtoFrame(driver, continueButton);
		Utility_Functions.timeWait(3);
		Utility_Functions.xClick(driver, continueButton, true);
		Utility_Functions.timeWait(2);
		driver.switchTo().defaultContent();
		Utility_Functions.timeWait(2);
		Utility_Functions.xScrollWindow(driver);
		Utility_Functions.timeWait(2);
		Utility_Functions.xScrollWindowTop(driver);
		Utility_Functions.timeWait(2);
		Utility_Functions.xWaitForElementPresent(driver, termOfContract, 3);
		if ((!termOfContract.getText().equals(" "))) {
			System.out.println("The Term of Contract Field is present");
			report.updateTestLog("Verify Quick Create Opportunity Page Term Of Contract",
					"The Term of Contract Field is present ", Status.PASS);
		} else {
			System.out.println("The Term of Contract Field is not present");
			report.updateTestLog("Verify Quick Create Opportunity Page Term Of Contract",
					"The Term of Contract Field is not present ", Status.FAIL);
		}
	}

	/**
	 * Validating the Quick create Opportunity page from the Opportunity for
	 * Lead Source
	 * 
	 * @author Ramya
	 *
	 */

	public void verifyNewOpportunityPageLeadSource() {
		Utility_Functions.xWaitForElementPresent(driver, menu_Opportunities, 3);
		Utility_Functions.xClick(driver, menu_Opportunities, true);
		report.updateTestLog("Verify Quick Create Opportunity Page Asset Services ",
				"Verifying the Opportunities page is displayed", Status.PASS);
		Utility_Functions.timeWait(2);
		Utility_Functions.xWaitForElementPresent(driver, newOpportunity, 3);
		Utility_Functions.xClick(driver, newOpportunity, true);
		report.updateTestLog("Verify Quick Create Opportunity Page Asset Services   ",
				"Verifying the new opportunity page is displayed", Status.PASS);
		Utility_Functions.timeWait(3);
		Utility_Functions.xScrollWindow(driver);
		Utility_Functions.timeWait(2);
		Utility_Functions.xScrollWindowTop(driver);
		Utility_Functions.timeWait(2);
		Utility_Functions.xWaitForElementPresent(driver, leadSourceNewOpportunity, 3);
		Utility_Functions.xClick(driver, leadSourceNewOpportunity, true);
		Utility_Functions.timeWait(1);
		List<WebElement> leadSourceValuesList = driver.findElements(By.xpath("//div[@class='select-options']//a[@title='Capital Markets']/parent::li/parent::ul/li"));
		for (WebElement element : leadSourceValuesList) {
			element.getText();
			System.out.println(element.getText());
		}

	}

	/**
	 * Validating the Quick create Opportunity page from the Opportunity for the
	 * New Opportunity Fields
	 * 
	 * @author Ramya
	 *
	 */

	public void verifyOpportunityLeasingAnnualRevenueField() {
		Utility_Functions.xWaitForElementPresent(driver, menu_Opportunities, 3);
		Utility_Functions.xClick(driver, menu_Opportunities, true);
		report.updateTestLog("Verify Opportunity Leasing AnnualRevenue Field  ",
				"Verifying the Opportunities page is displayed", Status.PASS);
		Utility_Functions.timeWait(2);
		Utility_Functions.xWaitForElementPresent(driver, newOpportunity, 3);
		Utility_Functions.xClick(driver, newOpportunity, true);
		report.updateTestLog("Verify Opportunity Leasing AnnualRevenue Field   ",
				"Verifying the new opportunity page is displayed", Status.PASS);
		Utility_Functions.timeWait(3);
		Utility_Functions.xScrollWindow(driver);
		Utility_Functions.timeWait(2);
		Utility_Functions.xScrollWindowTop(driver);
		Utility_Functions.timeWait(2);
		try {
			Utility_Functions.xWaitForElementPresent(driver, opportunityNameNewOpportunity, 3);
			Utility_Functions.xClick(driver, opportunityNameNewOpportunity, true);
			Utility_Functions.xWaitForElementPresent(driver, opportunityNameNewOpportunity, 3);
			Utility_Functions.xSendKeys(driver, opportunityNameNewOpportunity,
					"Test Automation Opportunity_" + Utility_Functions.xGenerateAlphaNumericString());
			report.updateTestLog("Verify Opportunity Leasing AnnualRevenue Field  ",
					"Verifying the Opportunities Name is entered", Status.PASS);

			Utility_Functions.xWaitForElementPresent(driver, successProbability, 3);
			Utility_Functions.xClick(driver, successProbability, true);
			Utility_Functions.xWaitForElementPresent(driver, successProbability, 3);
			Utility_Functions.xSendKeys(driver, successProbability, "100");
			Utility_Functions.xWaitForElementPresent(driver, totalSizeNewOpportunity, 3);
			Utility_Functions.xClick(driver, totalSizeNewOpportunity, true);		
			Utility_Functions.xWaitForElementPresent(driver, searchAccountsNewOpportunity, 3);
			Utility_Functions.xSendKeys(driver, searchAccountsNewOpportunity, "Test");
			report.updateTestLog("Verify Opportunity Leasing AnnualRevenue Field  ",
					"Verifying the Account Name in New Opportunity Page is entered", Status.PASS);

			Utility_Functions.timeWait(2);
		} catch (Exception e) {
			System.out.println("The required fields are not found");
			report.updateTestLog("Verify Opportunity Leasing AnnualRevenue Field  ",
					"Verifying the Account Name in New Opportunity Page is entered", Status.PASS);

		}
		try {
			Utility_Functions.xClick(driver, driver.findElement(By.xpath("//div[contains(@title,'Test')]")), true);
			Utility_Functions.timeWait(3); 
			Utility_Functions.xWaitForElementPresent(driver, salesStage_AS, 4);
			Utility_Functions.xClick(driver, salesStage_AS, true);
			Utility_Functions.xClick(driver, salesStageValue_AS, true);
			report.updateTestLog("Verify Opportunity Leasing AnnualRevenue Field  ",
					"Verifying the Sales Stage in New Opportunity Page is entered", Status.PASS);
			System.out.println(Calendar.getInstance());
			DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
			Date date = new Date();
			Utility_Functions.xWaitForElementPresent(driver, closeDate_AS, 3);
			Utility_Functions.xSendKeys(driver, closeDate_AS, dateFormat.format(date).toString());
			report.updateTestLog("Verify Opportunity Leasing AnnualRevenue Field  ",
					"Verifying the close date in New Opportunity Page is entered", Status.PASS);
			Utility_Functions.xWaitForElementPresent(driver, saveNewOpportunity_AS, 3);
			Utility_Functions.xClick(driver, saveNewOpportunity_AS, true);
			report.updateTestLog("Verify Opportunity Leasing AnnualRevenue Field ", "Opportunity Saved successfully::",
					Status.PASS);
		} catch (Exception e) {
			e.printStackTrace();
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
		Utility_Functions.xWaitForElementPresent(driver, menu_Opportunities, 3);
		Utility_Functions.xClick(driver, menu_Opportunities, true);
		report.updateTestLog("Verify Capital Markets Revenue Field Opportunity Page  ",
				"Verifying the Opportunities page is displayed", Status.PASS);
		Utility_Functions.timeWait(2);
		Utility_Functions.xWaitForElementPresent(driver, newOpportunity, 3);
		Utility_Functions.xClick(driver, newOpportunity, true);
		report.updateTestLog("Verify Capital Markets Revenue Field Opportunity Page   ",
				"Verifying the new opportunity page is displayed", Status.PASS);
		Utility_Functions.timeWait(3);
		Utility_Functions.xScrollWindow(driver);
		Utility_Functions.timeWait(2);
		Utility_Functions.xScrollWindowTop(driver);
		Utility_Functions.timeWait(2);
		Utility_Functions.xWaitForElementPresent(driver, capitalRevenueFieldNewOpportunity, 3);
		Utility_Functions.xClick(driver, capitalRevenueFieldNewOpportunity, true);
		if ((!capitalRevenueFieldNewOpportunity.getText().equals(" "))) {
			System.out.println("The Capital Revenue Field is present");
			report.updateTestLog("Verify Capital Markets Revenue Field Opportunity Page ",
					"Verifying the Capital Markets Revenue Field is present ", Status.PASS);
		} else {
			System.out.println("The Capital Revenue Field is not present");
			report.updateTestLog("Verify Capital Markets Revenue Field Opportunity Page ",
					"Verifying the Capital Markets Revenue Field is present ", Status.FAIL);
		}

	}

	/**
	 * Validating the EBIDTAFields for the new opportunity page
	 * 
	 * @author Ramya
	 *
	 */

	public void verifyNewOpportunityEBIDTAFields() {
		Utility_Functions.xWaitForElementPresent(driver, menu_Opportunities, 3);
		Utility_Functions.xClick(driver, menu_Opportunities, true);
		report.updateTestLog("Verify New Opportunity EBIDTA Fields ", "Verifying the Opportunities page is displayed",
				Status.PASS);
		Utility_Functions.timeWait(2);
		Utility_Functions.xWaitForElementPresent(driver, newOpportunity, 3);
		Utility_Functions.xClick(driver, newOpportunity, true);
		report.updateTestLog("Verify New Opportunity EBIDTA Fields  ",
				"Verifying the new opportunity page is displayed", Status.PASS);
		Utility_Functions.timeWait(3);
		Utility_Functions.xSwitchtoFrame(driver, continueButton);
		Utility_Functions.timeWait(3);
		Utility_Functions.xClick(driver, continueButton, true);
		driver.switchTo().defaultContent();
		Utility_Functions.timeWait(2);
		Utility_Functions.xScrollWindow(driver);
		Utility_Functions.timeWait(2);
		Utility_Functions.xScrollWindowTop(driver);
		Utility_Functions.timeWait(2);

		Utility_Functions.xWaitForElementPresent(driver, newOpportunityEBITDAWon, 3);
		if ((!newOpportunityEBITDAWon.getText().equals(" "))) {
			System.out.println("The EBITD Won Field is present");
			report.updateTestLog("Verify New Opportunity EBIDTA Fields", "Verifying the EBITD Won Field is present ",
					Status.PASS);
		} else {
			System.out.println("The EBITD Won Field is not present");
			report.updateTestLog("Verify New Opportunity EBIDTA Fields", "Verifying the EBITD Won Field is present ",
					Status.FAIL);
		}

		Utility_Functions.xWaitForElementPresent(driver, newOpportunityEBITDALost, 3);
		if ((!newOpportunityEBITDALost.getText().equals(" "))) {
			System.out.println("The EBITD Lost Field is present");
			report.updateTestLog("Verify New Opportunity EBIDTA Fields", "Verifying the EBITD Lost Field is present ",
					Status.PASS);
		} else {
			System.out.println("The EBITD Lost Field is not present");
			report.updateTestLog("Verify New Opportunity EBIDTA Fields", "Verifying the EBITD Lost Field is present ",
					Status.FAIL);
		}
		Utility_Functions.timeWait(2);
		Utility_Functions.xScrollWindow(driver);
		Utility_Functions.timeWait(2);
		Utility_Functions.xScrollWindowTop(driver);
		Utility_Functions.timeWait(2);

		Utility_Functions.xWaitForElementPresent(driver, newOpportunityEBITDA, 3);
		Utility_Functions.xClick(driver, newOpportunityEBITDA, true);
		Utility_Functions.xWaitForElementPresent(driver, newOpportunityEBITDA, 3);
		Utility_Functions.xSendKeys(driver, newOpportunityEBITDA, "100");

		report.updateTestLog("Verify New Opportunity EBIDTA Fields", "The EBITD Field is present and value is entered ",
				Status.PASS);
	}

	/**
	 * Validating Speciality Group Attribute in the new opportunity page
	 * 
	 * @author Ramya
	 *
	 */

	public void verifySpecialityGroupAttribute() {
		Utility_Functions.xWaitForElementPresent(driver, menu_Opportunities, 3);
		Utility_Functions.xClick(driver, menu_Opportunities, true);
		report.updateTestLog("Verify New Opportunity Speciality Group Field ",
				"Verifying the Opportunities page is displayed", Status.PASS);
		Utility_Functions.timeWait(2);
		Utility_Functions.xWaitForElementPresent(driver, newOpportunity, 3);
		Utility_Functions.xClick(driver, newOpportunity, true);
		report.updateTestLog("Verify New Opportunity Speciality Group Field ",
				"Verifying the new opportunity page is displayed", Status.PASS);
		Utility_Functions.timeWait(3);
		Utility_Functions.xSwitchtoFrame(driver, continueButton);
		Utility_Functions.timeWait(3);
		Utility_Functions.xClick(driver, continueButton, true);
		driver.switchTo().defaultContent();
		Utility_Functions.timeWait(2);
		Utility_Functions.xScrollWindow(driver);
		Utility_Functions.timeWait(2);
		Utility_Functions.xScrollWindowTop(driver);
		Utility_Functions.timeWait(2);
		Utility_Functions.xSwitchtoFrame(driver, viewAllFieldsButton);
		Utility_Functions.timeWait(3);
		Utility_Functions.xClick(driver, viewAllFieldsButton, true);

		Utility_Functions.xWaitForElementPresent(driver, specialityGroup, 3);
		if ((!specialityGroup.getText().equals(" "))) {
			System.out.println("The Speciality Group Field is present");
			report.updateTestLog("Verify New Opportunity Speciality Group Field",
					"Verifying the Speciality Group Field is present ", Status.PASS);
		} else {
			System.out.println("The Speciality Group Field is not present");
			report.updateTestLog("Verify New Opportunity Speciality Group Field",
					"Verifying the Speciality Group Field is present ", Status.FAIL);
		}

		Utility_Functions.xWaitForElementPresent(driver, specialityGroup, 3);
		Utility_Functions.xClick(driver, specialityGroup, true);
		Utility_Functions.timeWait(1);
		List<WebElement> specialityGroupValuesList = driver.findElements(By.xpath(
				"//label[contains(text(),'Specialty Group')]/parent::div//div[@class='slds-form-element__control']//option"));
		for (WebElement element : specialityGroupValuesList) {
			element.getText();
			System.out.println(element.getText());
		}
		Utility_Functions.xSendKeys(driver, accountName, "Test");
		accountName.sendKeys(Keys.ARROW_DOWN);
		Utility_Functions.timeWait(2);
		accountName.sendKeys(Keys.ENTER);
		Utility_Functions.xSelectDropdownByIndex(assignmentTypeOpp, 1);
		System.out.println(Calendar.getInstance());
		DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
		Date date = new Date();
		Utility_Functions.xSelectDropdownByIndex(leadSource, 1);
		Utility_Functions.xSendKeys(driver, closeDateOpp, dateFormat.format(date).toString());
		Utility_Functions.xSendKeys(driver, closeDateOpp, Keys.TAB);
		Utility_Functions.xWaitForElementPresent(driver, totalSizeOpp, 3);
		Utility_Functions.xSendKeys(driver, totalSizeOpp, "100");
		Utility_Functions.xSelectDropdownByIndex(preferredPropertyTypeOpp, 1);
		Utility_Functions.xWaitForElementPresent(driver, saveNewOpportunity, 3);
		Utility_Functions.xClick(driver, saveNewOpportunity, true);
		report.updateTestLog("Verify New Opportunity Speciality Group Field",
				"Verifying all the required values are entered in the new Opportunity Page are entered ", Status.PASS);

	}

	/**
	 * Validating RFP Due Date and Pitch Due Date Fields in the new opportunity
	 * page
	 * 
	 * @author Ramya
	 *
	 */

	public void verifyRFPAndPitchDueDateNewopportunityPage() {
		Utility_Functions.xWaitForElementPresent(driver, menu_Opportunities, 3);
		Utility_Functions.xClick(driver, menu_Opportunities, true);
		report.updateTestLog("Verify New Opportunity RFP and Pitch Due Date Fields  ",
				"Verifying the Opportunities page is displayed", Status.PASS);
		Utility_Functions.timeWait(2);
		Utility_Functions.xWaitForElementPresent(driver, newOpportunity, 3);
		Utility_Functions.xClick(driver, newOpportunity, true);
		report.updateTestLog("Verify New Opportunity RFP and Pitch Due Date Fields    ",
				"Verifying the new opportunity page is displayed", Status.PASS);
		Utility_Functions.timeWait(3);
		Utility_Functions.xScrollWindow(driver);
		Utility_Functions.timeWait(2);
		Utility_Functions.xScrollWindowTop(driver);
		Utility_Functions.timeWait(2);
		Utility_Functions.xWaitForElementPresent(driver, opportunityNameNewOpportunity, 3);
		Utility_Functions.xClick(driver, opportunityNameNewOpportunity, true);
		Utility_Functions.xWaitForElementPresent(driver, opportunityNameNewOpportunity, 3);
		Utility_Functions.xSendKeys(driver, opportunityNameNewOpportunity, "test");
		report.updateTestLog("Verify New Opportunity RFP and Pitch Due Date Fields   ",
				"Verifying the Opportunities Name is entered", Status.PASS);
		Utility_Functions.xWaitForElementPresent(driver, totalSizeNewOpportunity, 3);
		Utility_Functions.xClick(driver, totalSizeNewOpportunity, true);
		Utility_Functions.xWaitForElementPresent(driver, totalSizeNewOpportunity, 3);
		Utility_Functions.xSendKeys(driver, totalSizeNewOpportunity, "10000");
		report.updateTestLog("Verify New Opportunity RFP and Pitch Due Date Fields   ",
				"Verifying the total size in new opportunity page is entered", Status.PASS);
		Utility_Functions.xWaitForElementPresent(driver, unitOfMeasureNewOpportunity, 3);
		Utility_Functions.xClick(driver, unitOfMeasureNewOpportunity, true);
		Utility_Functions.xWaitForElementPresent(driver, selectUnitOfMeasureNewOpportunity, 3);
		Utility_Functions.xClick(driver, selectUnitOfMeasureNewOpportunity, true);
		report.updateTestLog("Verify New Opportunity RFP and Pitch Due Date Fields   ",
				"Verifying the unit of measure is selected in the New Opportunity Page", Status.PASS);

		try {
			Utility_Functions.xWaitForElementPresent(driver, regionNewOpportunity, 3);
			Utility_Functions.xClick(driver, regionNewOpportunity, true);
			Utility_Functions.xWaitForElementPresent(driver, selectRegionNewOpportunity, 3);
			Utility_Functions.xClick(driver, selectRegionNewOpportunity, true);
			report.updateTestLog("Verify New Opportunity RFP and Pitch Due Date Fields   ",
					"Verifying the region is selected in the new opportunity Page", Status.PASS);
			Utility_Functions.xWaitForElementPresent(driver, selectMarket, 3);
			Utility_Functions.xClick(driver, selectMarket, true);
			report.updateTestLog("Verify New Opportunity RFP and Pitch Due Date Fields   ",
					"Verifying the market field is selected in the new opportunity page", Status.PASS);
			Utility_Functions.xWaitForElementPresent(driver, searchAccountsNewOpportunity, 3);
			Utility_Functions.xSendKeys(driver, searchAccountsNewOpportunity, "Test");
			report.updateTestLog("Verify New Opportunity RFP and Pitch Due Date Fields   ",
					"Verifying the Account field is selected with the appropriate user in the new opportunity page",
					Status.PASS);
			Utility_Functions.timeWait(2);
			Utility_Functions.xClick(driver, driver.findElement(By.xpath("//div[contains(@title,'Test')]")), true);
			Utility_Functions.timeWait(3);
			Utility_Functions.xScrollWindow(driver);
			Utility_Functions.timeWait(2);
			Utility_Functions.xScrollWindowTop(driver);
			Utility_Functions.timeWait(2);
			Utility_Functions.timeWait(1);
			Utility_Functions.xWaitForElementPresent(driver, salesStage_AS, 4);
			Utility_Functions.xClick(driver, salesStage_AS, true);
			Utility_Functions.xClick(driver, salesStageValue_AS, true);
			System.out.println(Calendar.getInstance());
			report.updateTestLog("Verify New Opportunity RFP and Pitch Due Date Fields   ",
					"Verifying the sales stage field is selected in the new opportunity page", Status.PASS);
			DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
			Date date = new Date();
			Utility_Functions.xWaitForElementPresent(driver, closeDate_AS, 3);
			Utility_Functions.xSendKeys(driver, closeDate_AS, dateFormat.format(date).toString());
			System.out.println(Calendar.getInstance());
			report.updateTestLog("Verify New Opportunity RFP and Pitch Due Date Fields   ",
					"Verifying the closed date field is selected in the new opportunity page", Status.PASS);
			Utility_Functions.xWaitForElementPresent(driver, rfpDueDate, 3);
			Utility_Functions.xSendKeys(driver, rfpDueDate, dateFormat.format(date).toString());
			report.updateTestLog("Verify New Opportunity RFP and Pitch Due Date Fields   ",
					"Verifying the rfp due date field is selected in the new opportunity page", Status.PASS);
			Utility_Functions.xWaitForElementPresent(driver, saveNewOpportunity_AS, 3);
			System.out.println(Calendar.getInstance());
			Utility_Functions.xWaitForElementPresent(driver, pitchDueDate, 3);
			Utility_Functions.xSendKeys(driver, pitchDueDate, dateFormat.format(date).toString());
			report.updateTestLog("Verify New Opportunity RFP and Pitch Due Date Fields   ",
					"Verifying the pitch due date field is selected in the new opportunity page", Status.PASS);
			Utility_Functions.xWaitForElementPresent(driver, saveNewOpportunity_AS, 3);
			Utility_Functions.xClick(driver, saveNewOpportunity_AS, true);
			report.updateTestLog("Verify New Opportunity RFP and Pitch Due Date Fields ",
					"Verifying all the required values are entered in the new Opportunity Page are entered along with the RFP Due Date and Pitch Due Date ",
					Status.PASS);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

	}

	/**
	 * Validating the new Opportunity page for the Annual Leasing Commission
	 * Field
	 * 
	 * @author Ramya
	 *
	 */

	public void verifyOpportunityAverageAnnualLeasingCommissionField() {
		Utility_Functions.xWaitForElementPresent(driver, menu_Opportunities, 3);
		Utility_Functions.xClick(driver, menu_Opportunities, true);
		report.updateTestLog("Verify Opportunity Annual Average Leasing Commission Field  ",
				"Verifying the Opportunities page is displayed", Status.PASS);
		Utility_Functions.timeWait(2);
		Utility_Functions.xWaitForElementPresent(driver, newOpportunity, 3);
		Utility_Functions.xClick(driver, newOpportunity, true);
		report.updateTestLog("Verify Opportunity Annual Average Leasing Commission Field   ",
				"Verifying the new opportunity page is displayed", Status.PASS);
		Utility_Functions.timeWait(3);
		Utility_Functions.xSwitchtoFrame(driver, continueButton);
		Utility_Functions.timeWait(3);
		Utility_Functions.xClick(driver, continueButton, true);
		driver.switchTo().defaultContent();
		Utility_Functions.timeWait(3);
		Utility_Functions.xScrollWindow(driver);
		Utility_Functions.timeWait(2);
		Utility_Functions.xScrollWindowTop(driver);
		Utility_Functions.timeWait(2);
		Utility_Functions.xWaitForElementPresent(driver, opportunityNameNewOpportunity, 3);
		Utility_Functions.xClick(driver, opportunityNameNewOpportunity, true);
		Utility_Functions.xWaitForElementPresent(driver, opportunityNameNewOpportunity, 3);
		Utility_Functions.xSendKeys(driver, opportunityNameNewOpportunity, "test");
		report.updateTestLog("Verify Opportunity Annual Average Leasing Commission Field   ",
				"Verifying the opportunity name is entered", Status.PASS);
		Utility_Functions.xWaitForElementPresent(driver, totalSizeNewOpportunity, 3);
		Utility_Functions.xClick(driver, totalSizeNewOpportunity, true);
		Utility_Functions.xWaitForElementPresent(driver, totalSizeNewOpportunity, 3);
		Utility_Functions.xSendKeys(driver, totalSizeNewOpportunity, "100");
		report.updateTestLog("Verify Opportunity Annual Average Leasing Commission Field   ",
				"Verifying the total size value is entered", Status.PASS);
		Utility_Functions.xWaitForElementPresent(driver, unitOfMeasureNewOpportunity, 3);
		Utility_Functions.xClick(driver, unitOfMeasureNewOpportunity, true);
		Utility_Functions.xWaitForElementPresent(driver, selectUnitOfMeasureNewOpportunity, 3);
		Utility_Functions.xClick(driver, selectUnitOfMeasureNewOpportunity, true);
		report.updateTestLog("Verify Opportunity Annual Average Leasing Commission Field   ",
				"Verifying the unit of measure value is selected", Status.PASS);
		Utility_Functions.xWaitForElementPresent(driver, regionNewOpportunity, 3);
		Utility_Functions.xClick(driver, regionNewOpportunity, true);
		Utility_Functions.xWaitForElementPresent(driver, selectRegionNewOpportunity, 3);
		Utility_Functions.xClick(driver, selectRegionNewOpportunity, true);
		report.updateTestLog("Verify Opportunity Annual Average Leasing Commission Field   ",
				"Verifying the region is selected", Status.PASS);
		Utility_Functions.xWaitForElementPresent(driver, selectMarket, 3);
		Utility_Functions.xClick(driver, selectMarket, true);
		report.updateTestLog("Verify Opportunity Annual Average Leasing Commission Field   ",
				"Verifying the market field is selected", Status.PASS);
		Utility_Functions.xWaitForElementPresent(driver, searchAccountsNewOpportunity, 3);
		Utility_Functions.xSendKeys(driver, searchAccountsNewOpportunity, "Test");
		report.updateTestLog("Verify Opportunity Annual Average Leasing Commission Field   ",
				"Verifying the Account  name is entered", Status.PASS);
		Utility_Functions.timeWait(2);
		String environment = loginPage.initializeEnvironment();
		if (environment.equalsIgnoreCase("FTE2")) {
			Utility_Functions.xClick(driver, driver.findElement(By.xpath("//div[contains(@title,'Test')]")), true);
			Utility_Functions.timeWait(3);
			Utility_Functions.xScrollWindow(driver);
			Utility_Functions.timeWait(2);
			Utility_Functions.xScrollWindowTop(driver);
			Utility_Functions.timeWait(2);
			Utility_Functions.timeWait(1);
			Utility_Functions.xWaitForElementPresent(driver, salesStage_AS, 4);
			Utility_Functions.xClick(driver, salesStage_AS, true);
			Utility_Functions.xClick(driver, salesStageValue_AS, true);
			report.updateTestLog("Verify Opportunity Annual Average Leasing Commission Field   ",
					"Verifying the Sales stage value is entered", Status.PASS);
			System.out.println(Calendar.getInstance());
			DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
			Date date = new Date();
			Utility_Functions.xWaitForElementPresent(driver, closeDate_AS, 3);
			Utility_Functions.xSendKeys(driver, closeDate_AS, dateFormat.format(date).toString());
			report.updateTestLog("Verify Opportunity Annual Average Leasing Commission Field   ",
					"Verifying the closed date value is entered", Status.PASS);
			Utility_Functions.xWaitForElementPresent(driver, annualAverageLeasingCommission, 3);
			Utility_Functions.xSendKeys(driver, annualAverageLeasingCommission, "10");
			report.updateTestLog("Verify Opportunity Annual Average Leasing Commission Field   ",
					"Verifying the Annual Average Leasing Commission value is entered", Status.PASS);
			Utility_Functions.xWaitForElementPresent(driver, saveNewOpportunity_AS, 3);
			Utility_Functions.xClick(driver, saveNewOpportunity_AS, true);
			report.updateTestLog("Verify Opportunity Annual Average Leasing Commission Field ",
					"Opportunity Saved successfully::", Status.PASS);
		} else {
			report.updateTestLog("Verify Opportunity Annual Average Leasing Commission Field ",
					"Opportunity Saved successfully::", Status.PASS);
		}

	}

	/**
	 * Validating the new Opportunity page for the Annual Leasing Commission
	 * Field for the AMER Manager or Broker
	 * 
	 * @author Ramya
	 *
	 */

	public void verifyOpportunityAverageAnnualLeasingCommissionFieldForAMERManager() {
		Utility_Functions.xWaitForElementPresent(driver, menu_Opportunities, 3);
		Utility_Functions.xClick(driver, menu_Opportunities, true);
		report.updateTestLog("Verify Opportunity Annual Average Leasing Commission Field  ",
				"Verifying the Opportunities page is displayed", Status.PASS);
		Utility_Functions.timeWait(2);
		Utility_Functions.xWaitForElementPresent(driver, newOpportunity, 3);
		Utility_Functions.xClick(driver, newOpportunity, true);
		report.updateTestLog("Verify Opportunity Annual Average Leasing Commission Field   ",
				"Verifying the new opportunity page is displayed", Status.PASS);
		Utility_Functions.timeWait(3);
		Utility_Functions.xScrollWindow(driver);
		Utility_Functions.timeWait(2);
		Utility_Functions.xScrollWindowTop(driver);
		Utility_Functions.timeWait(2);
		Utility_Functions.xWaitForElementPresent(driver, opportunityNameNewOpportunity, 3);
		Utility_Functions.xClick(driver, opportunityNameNewOpportunity, true);
		Utility_Functions.xWaitForElementPresent(driver, opportunityNameNewOpportunity, 3);
		Utility_Functions.xSendKeys(driver, opportunityNameNewOpportunity, "test");
		report.updateTestLog("Verify Opportunity Annual Average Leasing Commission Field   ",
				"Verifying the opportunity name is entered", Status.PASS);
		Utility_Functions.xWaitForElementPresent(driver, totalSizeNewOpportunity, 3);
		Utility_Functions.xClick(driver, totalSizeNewOpportunity, true);
		Utility_Functions.xWaitForElementPresent(driver, totalSizeNewOpportunity, 3);
		Utility_Functions.xSendKeys(driver, totalSizeNewOpportunity, "100");
		report.updateTestLog("Verify Opportunity Annual Average Leasing Commission Field   ",
				"Verifying the total size value is entered", Status.PASS);
		Utility_Functions.xWaitForElementPresent(driver, unitOfMeasureNewOpportunity, 3);
		Utility_Functions.xClick(driver, unitOfMeasureNewOpportunity, true);
		Utility_Functions.xWaitForElementPresent(driver, selectUnitOfMeasureNewOpportunity, 3);
		Utility_Functions.xClick(driver, selectUnitOfMeasureNewOpportunity, true);
		report.updateTestLog("Verify Opportunity Annual Average Leasing Commission Field   ",
				"Verifying the unit of measure value is selected", Status.PASS);
		Utility_Functions.xWaitForElementPresent(driver, regionNewOpportunity, 3);
		Utility_Functions.xClick(driver, regionNewOpportunity, true);
		Utility_Functions.xWaitForElementPresent(driver, selectRegionNewOpportunity, 3);
		Utility_Functions.xClick(driver, selectRegionNewOpportunity, true);
		report.updateTestLog("Verify Opportunity Annual Average Leasing Commission Field   ",
				"Verifying the region value is selected", Status.PASS);
		Utility_Functions.xWaitForElementPresent(driver, selectMarket, 3);
		Utility_Functions.xClick(driver, selectMarket, true);
		report.updateTestLog("Verify Opportunity Annual Average Leasing Commission Field   ",
				"Verifying the market value field is selected", Status.PASS);
		Utility_Functions.xWaitForElementPresent(driver, searchAccountsNewOpportunity, 3);
		Utility_Functions.xSendKeys(driver, searchAccountsNewOpportunity, "Test");
		Utility_Functions.timeWait(2);
		String environment = loginPage.initializeEnvironment();
		if (environment.equals("FTE")) {
			report.updateTestLog("Verify Opportunity Annual Average Leasing Commission Field ",
					"Opportunity Saved successfully::", Status.PASS);
		} else {
			Utility_Functions.xClick(driver, driver.findElement(By.xpath("//div[contains(@title,'Test')]")), true);
			Utility_Functions.timeWait(3);
			Utility_Functions.xScrollWindow(driver);
			Utility_Functions.timeWait(2);
			Utility_Functions.xScrollWindowTop(driver);
			Utility_Functions.timeWait(2);
			Utility_Functions.timeWait(1);
			Utility_Functions.xWaitForElementPresent(driver, salesStage_AS, 4);
			Utility_Functions.xClick(driver, salesStage_AS, true);
			Utility_Functions.xClick(driver, salesStageValue_AS, true);
			System.out.println(Calendar.getInstance());
			report.updateTestLog("Verify Opportunity Annual Average Leasing Commission Field   ",
					"Verifying the sales stage value is entered", Status.PASS);
			DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
			Date date = new Date();
			Utility_Functions.xWaitForElementPresent(driver, closeDate_AS, 3);
			Utility_Functions.xSendKeys(driver, closeDate_AS, dateFormat.format(date).toString());
			report.updateTestLog("Verify Opportunity Annual Average Leasing Commission Field   ",
					"Verifying the closed date value is entered", Status.PASS);
			try {
				Utility_Functions.xWaitForElementPresent(driver, annualAverageLeasingCommission, 3);
				Utility_Functions.xSendKeys(driver, annualAverageLeasingCommission, "10");
				report.updateTestLog("Verify Opportunity Annual Average Leasing Commission Field   ",
						"Verifying the Annual   Leasing Commission value is entered", Status.PASS);
			} catch (Exception e) {
				e.getMessage();
			}
			Utility_Functions.xWaitForElementPresent(driver, saveNewOpportunity_AS, 3);
			Utility_Functions.xClick(driver, saveNewOpportunity_AS, true);
			report.updateTestLog("Verify Opportunity Annual Average Leasing Commission Field ",
					"Opportunity Saved successfully::", Status.PASS);
		}

	}

	/**
	 * Validating Prefered Property Type Mandatory Field in the new opportunity
	 * page
	 * 
	 * @author Ramya
	 *
	 */

	public void verifyPreferedPropertyTypeMandatoryField() {
		Utility_Functions.xWaitForElementPresent(driver, menu_Opportunities, 3);
		Utility_Functions.xClick(driver, menu_Opportunities, true);
		report.updateTestLog("Verify New Opportunity Speciality Group Field ",
				"Verifying the Opportunities page is displayed", Status.PASS);
		Utility_Functions.timeWait(2);
		Utility_Functions.xWaitForElementPresent(driver, newOpportunity, 3);
		Utility_Functions.xClick(driver, newOpportunity, true);
		report.updateTestLog("Verify New Opportunity Speciality Group Field ",
				"Verifying the new opportunity page is displayed", Status.PASS);
		Utility_Functions.timeWait(3);
		Utility_Functions.xSwitchtoFrame(driver, continueButton);
		Utility_Functions.timeWait(3);
		Utility_Functions.xClick(driver, continueButton, true);
		driver.switchTo().defaultContent();
		Utility_Functions.timeWait(2);
		Utility_Functions.xScrollWindow(driver);
		Utility_Functions.timeWait(2);
		Utility_Functions.xScrollWindowTop(driver);
		Utility_Functions.timeWait(2);
		Utility_Functions.xSwitchtoFrame(driver, viewAllFieldsButton);
		Utility_Functions.timeWait(3);

		Utility_Functions.xWaitForElementPresent(driver, preferedPropertyTypeRequiredField, 3);
		if ((!preferedPropertyTypeRequiredField.getText().equals(" "))) {
			System.out.println("The prefered Property Type Required Field is present");
			report.updateTestLog("Verify New Opportunity Page prefered Property Type Required Field",
					"Verifying the prefered Property Type Required Field is present ", Status.PASS);
		} else {
			System.out.println("The prefered Property Type Required Field is not present");
			report.updateTestLog("Verify New Opportunity Page prefered Property Type Required Field",
					"Verifying the prefered Property Type Required Field is present ", Status.FAIL);
		}

		Utility_Functions.xSendKeys(driver, accountName, "Test");
		accountName.sendKeys(Keys.ARROW_DOWN);
		Utility_Functions.timeWait(2);
		accountName.sendKeys(Keys.ENTER);
		Utility_Functions.xSelectDropdownByIndex(assignmentTypeOpp, 1);
		System.out.println(Calendar.getInstance());
		DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
		Date date = new Date();
		Utility_Functions.xSelectDropdownByIndex(leadSource, 1);
		Utility_Functions.xSendKeys(driver, closeDateOpp, dateFormat.format(date).toString());
		Utility_Functions.xSendKeys(driver, closeDateOpp, Keys.TAB);
		Utility_Functions.xWaitForElementPresent(driver, totalSizeOpp, 3);
		Utility_Functions.xSendKeys(driver, totalSizeOpp, "100");
		Utility_Functions.xWaitForElementPresent(driver, saveNewOpportunity, 3);
		Utility_Functions.xClick(driver, saveNewOpportunity, true);
		if ((!errorMessageForPreferedPropertyType.getText().equals(" "))) {
			System.out.println("The error message is displayed for the prefered property type");
			report.updateTestLog("Verify New Opportunity Page prefered Property Type Required Field",
					"Verifying the prefered Property Type Required Field is present ", Status.PASS);
		} else {
			System.out.println("The The error message is not displayed for the prefered property type");
			report.updateTestLog("Verify New Opportunity Page prefered Property Type Required Field",
					"Verifying the prefered Property Type Required Field is  present ", Status.FAIL);
		}

		Utility_Functions.xSelectDropdownByIndex(preferredPropertyTypeOpp, 1);
		Utility_Functions.xWaitForElementPresent(driver, saveNewOpportunity, 3);
		Utility_Functions.xClick(driver, saveNewOpportunity, true);
		report.updateTestLog("Verify New Opportunity Page prefered Property Type Required Field",
				"Verifying the prefered property type required field is present and selected with a value ",
				Status.PASS);

	}

	/**
	 * Validating the Management Annual Revenue Field in the new opportunity
	 * page
	 * 
	 * @author Ramya
	 *
	 */

	public void verifyManagementAnnualRevenueField() {
		Utility_Functions.xWaitForElementPresent(driver, menu_Opportunities, 3);
		Utility_Functions.xClick(driver, menu_Opportunities, true);
		report.updateTestLog("Verify Opportunity Management Annual Average Leasing Commission Field  ",
				"Verifying the Opportunities page is displayed", Status.PASS);
		Utility_Functions.timeWait(2);
		Utility_Functions.xWaitForElementPresent(driver, newOpportunity, 3);
		Utility_Functions.xClick(driver, newOpportunity, true);
		report.updateTestLog("Verify Opportunity Management Annual Average Leasing Commission Field   ",
				"Verifying the new opportunity page is displayed", Status.PASS);
		Utility_Functions.timeWait(3);
		Utility_Functions.xScrollWindow(driver);
		Utility_Functions.timeWait(2);
		Utility_Functions.xScrollWindowTop(driver);
		Utility_Functions.timeWait(2);
		Utility_Functions.xWaitForElementPresent(driver, opportunityNameNewOpportunity, 3);
		Utility_Functions.xClick(driver, opportunityNameNewOpportunity, true);
		Utility_Functions.xWaitForElementPresent(driver, opportunityNameNewOpportunity, 3);
		Utility_Functions.xSendKeys(driver, opportunityNameNewOpportunity, "test");
		report.updateTestLog("Verify Opportunity Management Annual Average Leasing Commission Field   ",
				"Verifying the opportunity name is entered", Status.PASS);
		Utility_Functions.xWaitForElementPresent(driver, totalSizeNewOpportunity, 3);
		Utility_Functions.xClick(driver, totalSizeNewOpportunity, true);
		Utility_Functions.xWaitForElementPresent(driver, totalSizeNewOpportunity, 3);
		Utility_Functions.xSendKeys(driver, totalSizeNewOpportunity, "100");
		report.updateTestLog("Verify Opportunity Management Annual Average Leasing Commission Field   ",
				"Verifying the total size field value is displayed", Status.PASS);
		Utility_Functions.xWaitForElementPresent(driver, unitOfMeasureNewOpportunity, 3);
		Utility_Functions.xClick(driver, unitOfMeasureNewOpportunity, true);
		Utility_Functions.xWaitForElementPresent(driver, selectUnitOfMeasureNewOpportunity, 3);
		Utility_Functions.xClick(driver, selectUnitOfMeasureNewOpportunity, true);
		report.updateTestLog("Verify Opportunity Management Annual Average Leasing Commission Field   ",
				"Verifying the unit of measure field is selected", Status.PASS);
		Utility_Functions.xWaitForElementPresent(driver, regionNewOpportunity, 3);
		Utility_Functions.xClick(driver, regionNewOpportunity, true);
		Utility_Functions.xWaitForElementPresent(driver, selectRegionNewOpportunity, 3);
		Utility_Functions.xClick(driver, selectRegionNewOpportunity, true);
		report.updateTestLog("Verify Opportunity Management Annual Average Leasing Commission Field   ",
				"Verifying the region field is selected", Status.PASS);
		Utility_Functions.xWaitForElementPresent(driver, selectMarket, 3);
		Utility_Functions.xClick(driver, selectMarket, true);
		report.updateTestLog("Verify Opportunity Management Annual Average Leasing Commission Field   ",
				"Verifying the market field is selected", Status.PASS);
		Utility_Functions.xWaitForElementPresent(driver, searchAccountsNewOpportunity, 3);
		Utility_Functions.xSendKeys(driver, searchAccountsNewOpportunity, "Test");
		Utility_Functions.timeWait(2);
		Utility_Functions.xClick(driver, driver.findElement(By.xpath("//div[contains(@title,'Test')]")), true);
		report.updateTestLog("Verify Opportunity Management Annual Average Leasing Commission Field   ",
				"Verifying the Account name is selected", Status.PASS);
		Utility_Functions.timeWait(3);
		Utility_Functions.xScrollWindow(driver);
		Utility_Functions.timeWait(2);
		Utility_Functions.xScrollWindowTop(driver);
		Utility_Functions.timeWait(2);

		Utility_Functions.xWaitForElementPresent(driver, salesStage_AS, 4);
		Utility_Functions.xClick(driver, salesStage_AS, true);
		Utility_Functions.xClick(driver, salesStageValue_AS, true);
		System.out.println(Calendar.getInstance());
		report.updateTestLog("Verify Opportunity Management Annual Average Leasing Commission Field   ",
				"Verifying the Sales Stage value is selected", Status.PASS);
		DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
		Date date = new Date();
		Utility_Functions.xWaitForElementPresent(driver, closeDate_AS, 3);
		Utility_Functions.xSendKeys(driver, closeDate_AS, dateFormat.format(date).toString());
		report.updateTestLog("Verify Opportunity Management Annual Average Leasing Commission Field   ",
				"Verifying the closed date value is selected", Status.PASS);
		Utility_Functions.xWaitForElementPresent(driver, leasing, 4);
		Utility_Functions.xClick(driver, leasing, true);
		Utility_Functions.xWaitForElementPresent(driver, noOption, 3);
		Utility_Functions.xClick(driver, noOption, true);

	}

	/**
	 * Validating the Quick create Opportunity page from the Opportunity for
	 * state street pick list value
	 * 
	 * @author Ramya
	 *
	 */
	public void verifyNewOpportunityPageTermOfContractForAPACManager() {
		Utility_Functions.xWaitForElementPresent(driver, menu_Opportunities, 3);
		Utility_Functions.xClick(driver, menu_Opportunities, true);
		report.updateTestLog("Verify Quick Create Opportunity Page Term Of Contract ",
				"Verifying the Opportunities page is displayed", Status.PASS);
		Utility_Functions.timeWait(2);
		Utility_Functions.xWaitForElementPresent(driver, newOpportunity, 3);
		Utility_Functions.xClick(driver, newOpportunity, true);
		report.updateTestLog("Verify Quick Create Opportunity Page Term Of Contract   ",
				"Verifying the new opportunity page is displayed", Status.PASS);
		Utility_Functions.timeWait(3);
		Utility_Functions.xScrollWindow(driver);
		Utility_Functions.timeWait(2);
		Utility_Functions.xScrollWindowTop(driver);
		Utility_Functions.timeWait(2);
		Utility_Functions.xWaitForElementPresent(driver, termOfContract, 3);
		if ((!termOfContract.getText().equals(" "))) {
			System.out.println("The Term of Contract Field is present");
			report.updateTestLog("Verify Quick Create Opportunity Page Term Of Contract",
					"The Term of Contract Field is present ", Status.PASS);
		} else {
			System.out.println("The Term of Contract Field is not present");
			report.updateTestLog("Verify Quick Create Opportunity Page Term Of Contract",
					"The Term of Contract Field is not present ", Status.FAIL);
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
		String sAccountID = searchOpportunity.fetchRecordFieldValue("Id", query);
		report.updateTestLog("Verify Active Opportunities", "Account ID retrived from database is:::" + sAccountID,
				Status.PASS);
		String url = driver.getCurrentUrl().split("#")[0];
		String newUrl = url + "#/sObject/" + sAccountID;
		newUrl = newUrl + "/view";
		driver.get(newUrl);
		Utility_Functions.timeWait(1);
		return sAccountID;
	}

	public void validateActiveOpportunities() {
		Utility_Functions.xWaitForElementPresent(driver, menu_Accounts, 3);
		Utility_Functions.xClick(driver, menu_Accounts, true);
		Utility_Functions.xWaitForElementPresent(driver, recentlyViewed, 3);
		Utility_Functions.xClick(driver, recentlyViewed, true);
		report.updateTestLog("Verify Create Activity Contact ", "Recently viewed Contacts are Displayed ", Status.PASS);
		Utility_Functions.xWaitForElementPresent(driver, allAccounts, 3);
		Utility_Functions.xClick(driver, allAccounts, true);
		Utility_Functions.timeWait(3);
		report.updateTestLog("Verify Accounts", "All Accounts are Displayed", Status.PASS);
		Utility_Functions.xWaitForElementPresent(driver, accountsList, 3);
		Utility_Functions.xclickRandomElement(accountsList);
		String opportunities = retriveAccountOpp();
		if (opportunities == null) {
			report.updateTestLog("Verify Active Opportunities",
					"There are no accounts having associated with Opportunities:::", Status.PASS);
		} else {
			driver.navigate().refresh();
			Utility_Functions.xWaitForElementPresent(driver, related, 3);
			Utility_Functions.xClick(driver, related, true);
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
	 * Validating the Occupier Record Type should default to 'Occupier
	 * Brokerage'
	 * 
	 * @author Vishnuvardhan
	 *
	 */

	public void defaultOppRecordType() {
		Utility_Functions.xWaitForElementPresent(driver, menu_Opportunities, 3);
		Utility_Functions.xClick(driver, menu_Opportunities, true);
		Utility_Functions.xWaitForElementPresent(driver, newOpportunity, 3);
		Utility_Functions.xClick(driver, newOpportunity, true);
		try {
			Utility_Functions.xSwitchtoFrame(driver, continueButton);
			Utility_Functions.timeWait(2);
			Utility_Functions.xClick(driver, continueButton, true);
		} catch (Exception e) {
			e.getMessage();
		}
		Utility_Functions.xSwitchtoFrame(driver, closeDateOppSpell);
		Utility_Functions.timeWait(2);
		Utility_Functions.xScrollWindow(driver);
		Utility_Functions.timeWait(2);
		Utility_Functions.xWaitForElementPresent(driver, viewAllFieldsButton, 3);
		Utility_Functions.xClick(driver, viewAllFieldsButton, true);
		Utility_Functions.xScrollWindowOnce(driver);
		Utility_Functions.timeWait(2);
		Utility_Functions.xWaitForElementPresent(driver, opportunityRecordTypeByDefault, 3);
		if (opportunityRecordTypeByDefault.getText().contains("Occupier")) {
			report.updateTestLog("Verify Default Opportunity Record Type",
					"Opportunity Record Type is having the value as:::" + opportunityRecordTypeByDefault.getText(),
					Status.PASS);
		} else {
			report.updateTestLog("Verify Default Opportunity Record Type",
					"Opportunity Record Type is not having the value as:::" + opportunityRecordTypeByDefault.getText(),
					Status.FAIL);
		}
	}

	/**
	 * Verify the landing page should default to Details page by default from a
	 * Manager
	 * 
	 * @author Vishnuvardhan
	 *
	 */
	public void defaultLandingPageDetailsPage() {
		opportunityEligibility();
		report.updateTestLog("Verify Opportunity Landing Page",
				"Random Opportunity is clicked from the Opportunity List", Status.PASS);
		Utility_Functions.timeWait(3);
		Utility_Functions.xWaitForElementPresent(driver, related, 3);
		List<WebElement> headerList = driver.findElements(By.xpath("//div[contains(@class,'test-id__section')]//h3"));
		for (WebElement element : headerList) {
			if (element.getText().equals("Tagging")) {
				report.updateTestLog("Verify Opportunity Landing Page",
						"Details Page is displayed by default after clicking on Opportunity", Status.PASS);
				break;
			} else {
				report.updateTestLog("Verify Opportunity Landing Page",
						"Details Page is not displayed by default after clicking on Opportunity", Status.WARNING);
			}
		}
	}

	/**
	 * Verify the default values Sales Stage and Phase field on the Opportunity
	 * Detail page from a broker profile
	 * 
	 * @author Vishnuvardhan
	 *
	 */
	public void defaultSalesStageandPhaseField() {
		Utility_Functions.xWaitForElementPresent(driver, menu_Opportunities, 3);
		Utility_Functions.xClick(driver, menu_Opportunities, true);
		Utility_Functions.xWaitForElementPresent(driver, newOpportunity, 3);
		Utility_Functions.xClick(driver, newOpportunity, true);
		if ((dataTable.getData("General_Data", "TC_ID").contains("ABAMER"))
				|| (dataTable.getData("General_Data", "TC_ID").contains("CMAMER"))) {
			Utility_Functions.timeWait(3);
			Utility_Functions.xSwitchtoFrame(driver, continueButton);
			Utility_Functions.xWaitForElementPresent(driver, continueButton, 3);
			if ((dataTable.getData("General_Data", "TC_ID").contains("CMAMER"))
					&& (dataTable.getData("General_Data", "TC_ID").contains("DSF"))) {
				Utility_Functions.xWaitForElementPresent(driver, opportunityRecordType, 2);
				if (defaultOpportutnityRecordType.getText().equals("Capital Markets – Property Sales")) {
					Utility_Functions.xClick(driver, opportunityRecordType, true);
					Utility_Functions.timeWait(1);
					Utility_Functions.xClick(driver, opportunityRecordTypeDebtStructuredFinance, true);
				}
			}
			Utility_Functions.xClick(driver, continueButton, true);
			Utility_Functions.timeWait(2);
			Utility_Functions.xSwitchtoFrame(driver, salesStageSelected);
			Utility_Functions.xWaitForElementPresent(driver, salesStageSelected, 3);
			if (dataTable.getData("General_Data", "TC_ID").contains("ABAMER")) {
				if ((salesStageSelected.getText().equals("02-Meeting"))
						&& (phasePresent.getText().equals("Prospecting"))) {
					report.updateTestLog("Verify New Opportunity Page",
							"Sales Stage and Phase field are having the values as:::" + salesStageSelected.getText()
							+ ":::" + phaseField.getText(),
							Status.PASS);
				} else {
					report.updateTestLog("Verify New Opportunity Page",
							"Sales Stage and Phase field doesn't have the values as expected:::"
									+ salesStageSelected.getText() + ":::" + phaseField.getText(),
									Status.FAIL);
				}
			} else if ((dataTable.getData("General_Data", "TC_ID").contains("CMAMER"))
					&& (dataTable.getData("General_Data", "TC_ID").contains("PS"))) {
				if ((salesStageSelected.getText().equals("01-Preliminary"))
						&& (phasePresent.getText().equals("Prospecting"))) {
					report.updateTestLog("Verify New Opportunity Page",
							"Sales Stage and Phase field are having the values as:::" + salesStageSelected.getText()
							+ ":::" + phaseField.getText(),
							Status.PASS);
				} else {
					report.updateTestLog("Verify New Opportunity Page",
							"Sales Stage and Phase field doesn't have the values as expected:::"
									+ salesStageSelected.getText() + ":::" + phaseField.getText(),
									Status.FAIL);
				}
			} else if ((dataTable.getData("General_Data", "TC_ID").contains("CMAMER"))
					&& (dataTable.getData("General_Data", "TC_ID").contains("DSF"))) {
				if ((salesStageSelected.getText().equals("01-Screening"))
						&& (phasePresent.getText().equals("Prospecting"))) {
					report.updateTestLog("Verify New Opportunity Page",
							"Sales Stage and Phase field are having the values as:::" + salesStageSelected.getText()
							+ ":::" + phaseField.getText(),
							Status.PASS);
				} else {
					report.updateTestLog("Verify New Opportunity Page",
							"Sales Stage and Phase field doesn't have the values as expected:::"
									+ salesStageSelected.getText() + ":::" + phaseField.getText(),
									Status.FAIL);
				}
			}
			Utility_Functions.timeWait(2);
			opportunityNameAutoGenerateFuntion();
		} else if (dataTable.getData("General_Data", "TC_ID").contains("ABEMEA")) {
			try {
				Utility_Functions.xSwitchtoFrame(driver, salesStageSelectedEMEA);
				Utility_Functions.xWaitForElementPresent(driver, salesStageSelectedEMEA, 3);
			} catch (Exception e) {
				Utility_Functions.xSwitchtoFrame(driver, continueButton);
				Utility_Functions.xWaitForElementPresent(driver, continueButton, 5);
				Utility_Functions.xClick(driver, continueButton, true);
				Utility_Functions.xSwitchtoFrame(driver, closeDateOpp);
				Utility_Functions.timeWait(1);
				Utility_Functions.xWaitForElementPresent(driver, salesStageSelectedEMEA, 3);
			}
			if ((salesStageSelectedEMEA.getText().equals("--None--"))) {
				report.updateTestLog("Verify New Opportunity Page",
						"Sales Stage is having the value as:::" + salesStageSelectedEMEA.getText(), Status.PASS);
			} else {
				report.updateTestLog("Verify New Opportunity Page",
						"Sales Stage doesn't have the value as expected:::" + salesStageSelectedEMEA.getText(),
						Status.FAIL);
			}
		}
	}

	/**
	 * Verify the custom Opportunity page layout from a Manager profile
	 * 
	 * @author Vishnuvardhan
	 *
	 */

	static ArrayList<String> quickCreateLabelListSection = new ArrayList<String>();

	public void quickCreateLabelListSection() {
		quickCreateLabelListSection.add("*Account Name");
		quickCreateLabelListSection.add("*Assignment Type");
		quickCreateLabelListSection.add("Assignment Sub-Type");
		quickCreateLabelListSection.add("Lead Source");
		quickCreateLabelListSection.add("*Close Date");
		quickCreateLabelListSection.add("Total Size");
		quickCreateLabelListSection.add("Unit of Measure");
		quickCreateLabelListSection.add("*Opportunity Name");
		quickCreateLabelListSection.add("*Sales Stage");
		quickCreateLabelListSection.add("*Phase");
		quickCreateLabelListSection.add("*Probability (%)");
		quickCreateLabelListSection.add("Estimated Gross Fee/Commission");
		quickCreateLabelListSection.add("*Currency");
		System.out.println("Quick Create Label List:::" + quickCreateLabelListSection);
	}

	static ArrayList<String> opportunityInformationLabelList = new ArrayList<String>();

	public void opportunityInformationLabelList() {
		opportunityInformationLabelList.add("Specialty Group");
		opportunityInformationLabelList.add("Parent Opportunity");
		opportunityInformationLabelList.add("Cross Sell");
		opportunityInformationLabelList.add("Confidential Opportunity");
		opportunityInformationLabelList.add("Priority");
		opportunityInformationLabelList.add("Hire Date");
		System.out.println("Opportunity Information Label List:::" + opportunityInformationLabelList);
	}

	static ArrayList<String> opportunityInformationLabelListOBAMER = new ArrayList<String>();

	public void opportunityInformationLabelListOBAMER() {
		opportunityInformationLabelListOBAMER.add("Specialty Group");
		opportunityInformationLabelListOBAMER.add("Parent Opportunity");
		opportunityInformationLabelListOBAMER.add("Cross Sell");
		opportunityInformationLabelListOBAMER.add("Confidential Opportunity");
		opportunityInformationLabelListOBAMER.add("Opportunity Location");
		opportunityInformationLabelListOBAMER.add("Priority");
		opportunityInformationLabelListOBAMER.add("Hire Date");
		opportunityInformationLabelListOBAMER.add("Migrated Opportunity");
		System.out.println("Opportunity Information Label List:::" + opportunityInformationLabelListOBAMER);
	}

	static ArrayList<String> dealMetricsLabelList = new ArrayList<String>();

	public void dealMetricsLabelList() {
		dealMetricsLabelList.add("Investment Profile");
		dealMetricsLabelList.add("Total # of Units");
		dealMetricsLabelList.add("Unit of Comparison");
		dealMetricsLabelList.add("Opportunity Details");
		dealMetricsLabelList.add("Listing Price");
		dealMetricsLabelList.add("Listing Expiration");
		dealMetricsLabelList.add("Portfolio");
		dealMetricsLabelList.add("Development");
		dealMetricsLabelList.add("Preferred Property Type");
		dealMetricsLabelList.add("Preferred Property Sub-Type");
		System.out.println("Opportunity dealMetricsLabelList are:::" + dealMetricsLabelList);
		// h2[text()='Deal Metrics']/parent::div/parent::div//label
	}

	static ArrayList<String> financialInformationLabelList = new ArrayList<String>();

	public void financialInformationLabelList() {
		financialInformationLabelList.add("Estimated Transaction Value");
		financialInformationLabelList.add("Status Comments");
		financialInformationLabelList.add("Yield (%)");
		financialInformationLabelList.add("Yield Type");
		financialInformationLabelList.add("Next Steps");
		System.out.println("Opportunity financialInformationLabelList are:::" + financialInformationLabelList);
		// h2[text()='Financial Information']/parent::div/parent::div//label
	}

	static ArrayList<String> closeInformationLabelList = new ArrayList<String>();

	public void closeInformationLabelList() {
		closeInformationLabelList.add("Final Transaction Value");
		closeInformationLabelList.add("Actual CBRE Gross Fee");
		closeInformationLabelList.add("Yield (%)");
		closeInformationLabelList.add("Actual Yield Type");
		closeInformationLabelList.add("Total Property Value");
		closeInformationLabelList.add("Pitch Approved");
		closeInformationLabelList.add("Pitch Caveat");
		closeInformationLabelList.add("Press Approved");
		closeInformationLabelList.add("Press Caveat");
		closeInformationLabelList.add("Close comments");
		System.out.println("Opportunity closeInformationLabelList are:::" + closeInformationLabelList);
		// h2[text()='Close Information']/parent::div/parent::div//label
	}

	static ArrayList<String> closeInformationLabelListOBAMER = new ArrayList<String>();

	public void closeInformationLabelListOBAMER() {
		closeInformationLabelListOBAMER.add("Lease From");
		closeInformationLabelListOBAMER.add("Lease To");
		closeInformationLabelListOBAMER.add("Lease Term (Months)");
		closeInformationLabelListOBAMER.add("Lease Rate/Rent");
		closeInformationLabelListOBAMER.add("Lease Rate/Rent Basis");
		closeInformationLabelListOBAMER.add("Outside Broker Company");
		closeInformationLabelListOBAMER.add("Outside Broker Name");
		closeInformationLabelListOBAMER.add("CBRE Role");
		closeInformationLabelListOBAMER.add("Sub Lease");
		System.out.println("Opportunity closeInformationLabelList are:::" + closeInformationLabelListOBAMER);
		// h2[text()='Close Information']/parent::div/parent::div//label
	}

	static ArrayList<String> lossInformationLabelList = new ArrayList<String>();

	public void lossInformationLabelList() {
		lossInformationLabelList.add("Reason for Loss");
		lossInformationLabelList.add("Reason Lost Comments");
		lossInformationLabelList.add("Competitor");
		lossInformationLabelList.add("Opportunity Owner");
		lossInformationLabelList.add("External Deal ID");
		System.out.println("Opportunity lossInformationLabelList are:::" + lossInformationLabelList);
		// h2[text()='Loss Information']/parent::div/parent::div//label
	}

	static ArrayList<String> additionalInformationLabelList = new ArrayList<String>();

	public void additionalInformationLabelList() {
		additionalInformationLabelList.add("Total # of Units");
		additionalInformationLabelList.add("Unit of Comparison");
		additionalInformationLabelList.add("Status Comments");
		additionalInformationLabelList.add("Desired Commencement");
		additionalInformationLabelList.add("Existing Lease Expiration");
		additionalInformationLabelList.add("Existing Termination/Break Option");
		additionalInformationLabelList.add("New Termination/Break Option");
		additionalInformationLabelList.add("Next Steps");
		System.out.println("Opportunity additionalInformationLabelList are:::" + additionalInformationLabelList);
		// h2[text()='Loss Information']/parent::div/parent::div//label
	}

	static ArrayList<String> servicesLabelList = new ArrayList<String>();

	public void servicesLabelList() {
		servicesLabelList.add("Opportunity Record Type");
		servicesLabelList.add("Opportunity Team Members");
		servicesLabelList.add("On Hold");
		servicesLabelList.add("On Hold Date");
		servicesLabelList.add("On Hold Comments");
		System.out.println("Opportunity additionalInformationLabelList are:::" + servicesLabelList);
		// h2[text()='Loss Information']/parent::div/parent::div//label
	}

	public void customOpportunityPageLayout() {
		Utility_Functions.xWaitForElementPresent(driver, menu_Opportunities, 3);
		Utility_Functions.xClick(driver, menu_Opportunities, true);
		Utility_Functions.xWaitForElementPresent(driver, newOpportunity, 3);
		Utility_Functions.xClick(driver, newOpportunity, true);
		Utility_Functions.timeWait(2);
		try {
			Utility_Functions.xSwitchtoFrame(driver, continueButton);
			Utility_Functions.xWaitForElementPresent(driver, continueButton, 5);
			Utility_Functions.xClick(driver, continueButton, true);
		} catch (Exception e1) {
			e1.printStackTrace();
		}
		driver.switchTo().defaultContent();
		Utility_Functions.xSwitchtoFrame(driver, viewAllFieldsButton);
		Utility_Functions.xWaitForElementPresent(driver, viewAllFieldsButton, 5);
		Utility_Functions.xScrollWindow(driver);
		Utility_Functions.xClick(driver, viewAllFieldsButton, true);
		Utility_Functions.timeWait(1);
		Utility_Functions.xScrollWindowTop(driver);
		quickCreateLabelListSection();
		opportunityInformationLabelList();
		opportunityInformationLabelListOBAMER();
		dealMetricsLabelList();
		financialInformationLabelList();
		closeInformationLabelList();
		closeInformationLabelListOBAMER();
		lossInformationLabelList();
		additionalInformationLabelList();
		servicesLabelList();

		try {
			Utility_Functions.xWaitForElementPresent(driver, labelListOpportunitiesPage, 3);
			int i1 = 0, j = 0, countLabelList = 0;
			String[] labelTexts = new String[labelListOpportunitiesPage.size()];
			while (countLabelList != 13) {
				while (j < quickCreateLabelListSection.size()) {
					for (WebElement element : labelListOpportunitiesPage) {
						labelTexts[i1] = element.getText();
						if (labelTexts[i1].contains(quickCreateLabelListSection.get(j))) {
							System.out.println("Verify Add Opportunity Page Label List" + element.getText());
							report.updateTestLog("Verify Add Opportunity Page Label List",
									element.getText() + "::::label list is present in Add Opportunity Page",
									Status.PASS);
							countLabelList++;
						}
						i1++;
					}
					i1 = 0;
					j++;
				}
			}
			System.out.println("OpportunityInformationList:::" + countLabelList);
			if (countLabelList == 13) {
				report.updateTestLog("Verify Quick Create Section", "Labels are present in Add Opportunity Page:::",
						Status.PASS);
			} else {
				report.updateTestLog("Verify Quick Create Section", "Labels are not present in Add Opportunity Page:::",
						Status.FAIL);
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		if (dataTable.getData("General_Data", "TC_ID").contains("CMAMER")) {
			List<WebElement> opportunityInformationList = driver.findElements(By.xpath(
					"//h2[text()='Opportunity Information']/parent::div/parent::div//*[@class='slds-form-element__label']"));
			try {
				int i2 = 0, count = 0;
				String[] opportunityInfoTexts = new String[opportunityInformationList.size()];
				for (WebElement element : opportunityInformationList) {
					opportunityInfoTexts[i2] = element.getText();
					if (opportunityInfoTexts[i2].equalsIgnoreCase(opportunityInformationLabelList.get(i2))) {
						count++;
						System.out.println("Verify Opportunity Information Section" + element.getText());
						report.updateTestLog("Verify Opportunity Information Section",
								element.getText() + " label is present on the page", Status.PASS);
					}
					i2++;
				}
				System.out.println("OpportunityInformationList:::" + count);
				if (count == 6) {
					report.updateTestLog("Verify Opportunity Information Section",
							"Labels are present in Add Opportunity Page:::", Status.PASS);
				} else {
					report.updateTestLog("Verify Opportunity Information Section",
							"Labels are not present in Add Opportunity Page:::", Status.FAIL);
				}
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		} else if (dataTable.getData("General_Data", "TC_ID").contains("OBAMER")) {
			List<WebElement> opportunityInformationList = driver.findElements(By.xpath(
					"//h2[text()='Opportunity Information']/parent::div/parent::div//*[@class='slds-form-element__label']"));
			try {
				int i2 = 0, count = 0;
				String[] opportunityInfoTexts = new String[opportunityInformationLabelListOBAMER.size()];
				for (WebElement element : opportunityInformationList) {
					opportunityInfoTexts[i2] = element.getText();
					if (opportunityInfoTexts[i2].equalsIgnoreCase(opportunityInformationLabelListOBAMER.get(i2))) {
						count++;
						System.out.println("Verify Opportunity Information Section" + element.getText());
						report.updateTestLog("Verify Opportunity Information Section",
								element.getText() + " label is present on the page", Status.PASS);
					}
					i2++;
				}
				System.out.println("opportunityInformationLabelListOBAMER:::" + count);
				if (count == 8) {
					report.updateTestLog("Verify Opportunity Information Section",
							"Labels are present in Add Opportunity Page:::", Status.PASS);
				} else {
					report.updateTestLog("Verify Opportunity Information Section",
							"Labels are not present in Add Opportunity Page:::", Status.FAIL);
				}
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}

		if (dataTable.getData("General_Data", "TC_ID").contains("OBAMER")) {
			List<WebElement> servicesListPath = driver.findElements(
					By.xpath("//h2[text()='Services']/parent::div/parent::div//*[@class='slds-form-element__label']"));
			try {
				int i2 = 0, count = 0;
				String[] opportunityInfoTexts = new String[servicesLabelList.size()];
				for (WebElement element : servicesListPath) {
					opportunityInfoTexts[i2] = element.getText();
					if (opportunityInfoTexts[i2].equalsIgnoreCase(servicesLabelList.get(i2))) {
						count++;
						System.out.println("Verify Opportunity Information Section" + element.getText());
						report.updateTestLog("Verify Opportunity Information Section",
								element.getText() + " label is present on the page", Status.PASS);
					}
					i2++;
				}
				System.out.println("ServicesLabelList:::" + count);
				if (count == 5) {
					report.updateTestLog("Verify Opportunity Information Section",
							"Labels are present in Add Opportunity Page:::", Status.PASS);
				} else {
					report.updateTestLog("Verify Opportunity Information Section",
							"Labels are not present in Add Opportunity Page:::", Status.FAIL);
				}
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}

			List<WebElement> additionalInformationPath = driver.findElements(By.xpath(
					"//h2[text()='Additional Information']/parent::div/parent::div//*[@class='slds-form-element__label']"));
			try {
				int i2 = 0, count = 0;
				String[] opportunityInfoTexts = new String[additionalInformationLabelList.size()];
				for (WebElement element : additionalInformationPath) {
					opportunityInfoTexts[i2] = element.getText();
					if (opportunityInfoTexts[i2].equalsIgnoreCase(additionalInformationLabelList.get(i2))) {
						count++;
						System.out.println("Verify Opportunity Information Section" + element.getText());
						report.updateTestLog("Verify Opportunity Information Section",
								element.getText() + " label is present on the page", Status.PASS);
					}
					i2++;
				}
				System.out.println("AdditionalInformationLabelList:::" + count);
				if (count == 8) {
					report.updateTestLog("Verify Opportunity Information Section",
							"Labels are present in Add Opportunity Page:::", Status.PASS);
				} else {
					report.updateTestLog("Verify Opportunity Information Section",
							"Labels are not present in Add Opportunity Page:::", Status.FAIL);
				}
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}

		if (dataTable.getData("General_Data", "TC_ID").contains("CMAMER")) {
			List<WebElement> dealMetricsPath = driver.findElements(By.xpath(
					"//h2[text()='Deal Metrics']/parent::div/parent::div//*[@class='slds-form-element__label']"));
			try {
				int i2 = 0, count = 0;
				String[] dealMetricsTexts = new String[dealMetricsLabelList.size()];
				for (WebElement element : dealMetricsPath) {
					dealMetricsTexts[i2] = element.getText();
					if (dealMetricsTexts[i2].equalsIgnoreCase(dealMetricsLabelList.get(i2))) {
						count++;
						System.out.println("Verify Deal Metrics Section" + element.getText());
						report.updateTestLog("Verify Deal Metrics Section",
								element.getText() + " label is present on the page", Status.PASS);
					}
					i2++;
				}
				System.out.println("DealMetricsPath:::" + count);
				if (count == 10) {
					report.updateTestLog("Verify Deal Metrics Section", "Labels are present in Add Opportunity Page:::",
							Status.PASS);
				} else {
					report.updateTestLog("Verify Deal Metrics Section",
							"Labels are not present in Add Opportunity Page:::", Status.FAIL);
				}
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}

		}

		if (dataTable.getData("General_Data", "TC_ID").contains("CMAMER")) {
			List<WebElement> financialInformationPath = driver.findElements(By.xpath(
					"//h2[text()='Financial Information']/parent::div/parent::div//*[@class='slds-form-element__label']"));
			try {
				int i2 = 0, count = 0;
				String[] financialInformationTexts = new String[financialInformationLabelList.size()];
				for (WebElement element : financialInformationPath) {
					financialInformationTexts[i2] = element.getText();
					if (financialInformationTexts[i2].equalsIgnoreCase(financialInformationLabelList.get(i2))) {
						count++;
						System.out.println("Verify Financial Information Section" + element.getText());
						report.updateTestLog("Verify Financial Information Section",
								element.getText() + " label is present on the page", Status.PASS);
					}
					i2++;
				}
				System.out.println("FinancialInformationPath:::" + count);
				if (count == 5) {
					report.updateTestLog("Verify Financial Information Section",
							"Labels are present in Add Opportunity Page:::", Status.PASS);
				} else {
					report.updateTestLog("Verify Financial Information Section",
							"Labels are not present in Add Opportunity Page:::", Status.FAIL);
				}
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}

		}
		if (dataTable.getData("General_Data", "TC_ID").contains("CMAMER")) {
			List<WebElement> closeInformationPath = driver.findElements(By.xpath(
					"//h2[text()='Close Information']/parent::div/parent::div//*[@class='slds-form-element__label']"));
			try {
				int i2 = 0, count = 0;
				String[] closeInformationTexts = new String[closeInformationLabelList.size()];
				for (WebElement element : closeInformationPath) {
					closeInformationTexts[i2] = element.getText();
					if (closeInformationTexts[i2].equalsIgnoreCase(closeInformationLabelList.get(i2))) {
						count++;
						System.out.println("Verify Close Information Section" + element.getText());
						report.updateTestLog("Verify Close Information Section",
								element.getText() + " label is present on the page", Status.PASS);
					}
					i2++;
				}
				System.out.println("CloseInformationPath:::" + count);
				if (count == 10) {
					report.updateTestLog("Verify Close Information Section",
							"Labels are present in Add Opportunity Page:::", Status.PASS);
				} else {
					report.updateTestLog("Verify Close Information Section",
							"Labels are not present in Add Opportunity Page:::", Status.FAIL);
				}
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		} else if (dataTable.getData("General_Data", "TC_ID").contains("OBAMER")) {
			List<WebElement> closeInformationPath = driver.findElements(By.xpath(
					"//h2[text()='Close Information']/parent::div/parent::div//*[@class='slds-form-element__label']"));
			try {
				int i2 = 0, count = 0;
				String[] closeInformationTexts = new String[closeInformationLabelListOBAMER.size()];
				for (WebElement element : closeInformationPath) {
					closeInformationTexts[i2] = element.getText();
					if (closeInformationTexts[i2].equalsIgnoreCase(closeInformationLabelListOBAMER.get(i2))) {
						count++;
						System.out.println("Verify Close Information Section" + element.getText());
						report.updateTestLog("Verify Close Information Section",
								element.getText() + " label is present on the page", Status.PASS);
					}
					i2++;
				}
				System.out.println("CloseInformationPath:::" + count);
				if (count == 9) {
					report.updateTestLog("Verify Close Information Section",
							"Labels are present in Add Opportunity Page:::", Status.PASS);
				} else {
					report.updateTestLog("Verify Close Information Section",
							"Labels are not present in Add Opportunity Page:::", Status.FAIL);
				}
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}

		List<WebElement> lossInformationPath = driver.findElements(By.xpath(
				"//h2[text()='Loss Information']/parent::div/parent::div//*[@class='slds-form-element__label']"));
		try {
			int i2 = 0, count = 0;
			String[] lossInformationTexts = new String[lossInformationLabelList.size()];
			for (WebElement element : lossInformationPath) {
				lossInformationTexts[i2] = element.getText();
				if (lossInformationTexts[i2].equalsIgnoreCase(lossInformationLabelList.get(i2))) {
					count++;
					System.out.println("Verify Loss Information Section" + element.getText());
					report.updateTestLog("Verify Loss Information Section",
							element.getText() + " label is present on the page", Status.PASS);
				}
				i2++;
			}
			System.out.println("LossInformationPath:::" + count);
			if (count == 5) {
				report.updateTestLog("Verify Loss Information Section", "Labels are present in Add Opportunity Page:::",
						Status.PASS);
			} else {
				report.updateTestLog("Verify Loss Information Section",
						"Labels are not present in Add Opportunity Page:::", Status.FAIL);
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	/**
	 * Verify the required fields based on Sales Stage selected between
	 * 03-RFP/Proposal to 07-Under Contract on Opportunity from a broker profile
	 * 
	 * @author Vishnuvardhan
	 *
	 */

	public void salesStage03_RFPProposal_07UnderContract() {
		String query = "SELECT Estimated_Gross_Fee_Commission__c , Id, Name FROM Opportunity where StageName > '03-RFP/Proposal' and StageName < '07-Under Contract' and Estimated_Gross_Fee_Commission__c = 0.0 limit 10";
		String OpportunityID = searchOpportunity.searchOpportunity(query);
		System.out.println(OpportunityID);
		if (OpportunityID == null) {
			report.updateTestLog("Verify Opportunity", "There are no Opportunities that falls under this category:::",
					Status.PASS);
		} else {
			report.updateTestLog("Verify Opportunity Required Fields",
					"Opportunity retrived from database is:::" + OpportunityID, Status.PASS);
			String estimatedGrossFeeCommmission = "SELECT Estimated_Gross_Fee_Commission__c FROM Opportunity where Id = "
					+ "'" + OpportunityID + "'";
			String estimatedGrossFeeCommission_Value = searchOpportunity
					.fetchRecordFieldValue("Estimated_Gross_Fee_Commission__c", estimatedGrossFeeCommmission);
			report.updateTestLog("Verify Opportunity Required Fields",
					"Estimated Gross Fee Commission Value is :::" + estimatedGrossFeeCommission_Value, Status.PASS);

			String stagName = "SELECT stageName FROM Opportunity where Id = " + "'" + OpportunityID + "'";
			String stageName_Value = searchOpportunity.fetchRecordFieldValue("StageName", stagName);
			report.updateTestLog("Verify Opportunity Required Fields", "Stage Name is :::" + stageName_Value,
					Status.PASS);
			opportunitiesFunctions.updateOpportunityField("StageName", OpportunityID);
			String stageName_UpdatedValue = searchOpportunity.fetchRecordFieldValue("StageName", stagName);
			if (stageName_UpdatedValue.equals("07-Under Contract")) {
				report.updateTestLog("Verify Opportunity Required Fields",
						"Opportunity Sales Stage is updated successfully :::" + stageName_UpdatedValue, Status.PASS);
			} else {
				report.updateTestLog("Verify Opportunity Required Fields",
						"Opportunity Sales Stage updation failed:::" + stageName_UpdatedValue, Status.FAIL);
			}
		}
	}

	/**
	 * Verify the required fields based on Sales Stage selected between
	 * 08-Closed - Paid Partial to 09-Closed - Paid Full
	 * 
	 * @author Vishnuvardhan
	 *
	 */
	public void salesStage08_ClosedPartial_09_ClosedPaidFull() {
		String query = "SELECT Estimated_Gross_Fee_Commission__c , Id, Name FROM Opportunity where StageName > '08-Closed - Paid Partial' and StageName < '09-Closed - Paid Full' and Estimated_Gross_Fee_Commission__c = 0.0 "
				+ " and Created_By_User_Role__c != null limit 1 offset 9";
		String OpportunityID = searchOpportunity.searchOpportunity(query);
		System.out.println(OpportunityID);

		try {
			if (OpportunityID == null) {
				report.updateTestLog("Verify Opportunity",
						"There are no Opportunities that falls under this category:::", Status.PASS);
				salesStage08_09ClosedFunction();
				salesStage08_08ClosedSubFunction();
			} else {
				String url = driver.getCurrentUrl().split("#")[0];
				String newUrl = url + "#/sObject/" + OpportunityID;
				newUrl = newUrl + "/view";
				report.updateTestLog("Verify Add Opportunity Page Fields",
						"URL has been replaced with the new URL having the retrieved Opportunity:::" + newUrl,
						Status.PASS);
				driver.get(newUrl);
				Utility_Functions.timeWait(1);
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

	public String salesStage08_09ClosedFunction() {
		opportunityNameAutoGenerate();
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
			Utility_Functions.xWaitForElementPresent(driver, estiamtedGrossFeeCommissionValue, 3);
			Utility_Functions.xSendKeys(driver, estiamtedGrossFeeCommissionValue,
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
		String OpportunityID = searchOpportunity.searchOpportunity(query);
		System.out.println(OpportunityID);

		try {
			if (OpportunityID == null) {
				report.updateTestLog("Verify Opportunity",
						"There are no Opportunities that falls under this category:::", Status.PASS);
				salesStage08_09ClosedFunction();
				salesStage08_08ClosedSubFunction();
			} else {
				String url = driver.getCurrentUrl().split("#")[0];
				String newUrl = url + "#/sObject/" + OpportunityID;
				newUrl = newUrl + "/view";
				report.updateTestLog("Verify Add Opportunity Page Fields",
						"URL has been replaced with the new URL having the retrieved Opportunity:::" + newUrl,
						Status.PASS);
				driver.get(newUrl);
				Utility_Functions.timeWait(1);
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

	/**
	 * Validating the Technology tools field in the new Opportunity page
	 * 
	 * @author Ramya
	 *
	 */

	public void validateOpportunityTechnologyToolsField() {
		Utility_Functions.xWaitForElementPresent(driver, menu_Opportunities, 3);
		Utility_Functions.xClick(driver, menu_Opportunities, true);
		Utility_Functions.xWaitForElementPresent(driver, newOpportunity, 3);
		Utility_Functions.xClick(driver, newOpportunity, true);
		Utility_Functions.timeWait(2);

		if (dataTable.getData("General_Data", "TC_ID").contains("ASAPAC")) {
			Utility_Functions.xSwitchtoFrame(driver, continueButton);
			Utility_Functions.xWaitForElementPresent(driver, continueButton, 5);
			Utility_Functions.xClick(driver, continueButton, true);
			Utility_Functions.timeWait(2);
			driver.switchTo().defaultContent();
			Utility_Functions.timeWait(1);
		}
		Utility_Functions.timeWait(2);
		Utility_Functions.xScrollWindow(driver);
		Utility_Functions.timeWait(1);
		Utility_Functions.xScrollWindowTop(driver);
		Utility_Functions.timeWait(2);
		if (technologyToolsField.isDisplayed()) {

			report.updateTestLog("Verify Opportunities Technology Tools Field", "The Technology tools field is present",
					Status.PASS);
		} else {
			report.updateTestLog("Verify Opportunities Technology Tools Field",
					"The Technology tools field is not present", Status.FAIL);
		}

	}

	/**
	 * Validating the Technology tools field in the new Opportunity page
	 * 
	 * @author Ramya
	 *
	 */

	static ArrayList<String> targetingInitiativeFieldsList = new ArrayList<String>();

	public void targetingInitiatveFieldsList() {

		targetingInitiativeFieldsList.add("Premier Properties");
		targetingInitiativeFieldsList.add("US Retail Strike");
		targetingInitiativeFieldsList.add("US - Seal Team 5");

		System.out.println("Targeting Iniatiative fields  are:: " + targetingInitiativeFieldsList);
	}

	public void validateTargetingInitiativePickListValue() {
		Utility_Functions.xWaitForElementPresent(driver, menu_Opportunities, 3);
		Utility_Functions.xClick(driver, menu_Opportunities, true);
		Utility_Functions.xWaitForElementPresent(driver, newOpportunity, 3);
		Utility_Functions.xClick(driver, newOpportunity, true);
		Utility_Functions.timeWait(2);

		if (dataTable.getData("General_Data", "TC_ID").contains("ASAPAC")) {
			Utility_Functions.timeWait(2);
			Utility_Functions.xSwitchtoFrame(driver, continueButton);
			Utility_Functions.xWaitForElementPresent(driver, continueButton, 5);
			Utility_Functions.xClick(driver, continueButton, true);
			Utility_Functions.timeWait(2);
			driver.switchTo().defaultContent();
			Utility_Functions.timeWait(2);
		}
		Utility_Functions.timeWait(2);
		Utility_Functions.xScrollWindow(driver);
		Utility_Functions.timeWait(1);
		Utility_Functions.xScrollWindowTop(driver);
		Utility_Functions.timeWait(2);

		if (targetingInitiativeField.isDisplayed()) {

			report.updateTestLog("Verify Opportunities Targeting Initiative PickList Value",
					"The Targeting Initiative PickList Value is present", Status.PASS);
		} else {
			report.updateTestLog("Verify Opportunities Targeting Initiative PickList Value",
					"The Targeting Initiative PickList Value is not present", Status.FAIL);
		}

	}

	/**
	 * Validating the Opportunities Quick create page
	 * 
	 * @author Ramya
	 *
	 */
	static ArrayList<String> opportunityInformationFieldsList = new ArrayList<String>();

	public void opportunityInformationFields() {

		opportunityInformationFieldsList.add("*Opportunity Name");
		opportunityInformationFieldsList.add("*Account Name");
		opportunityInformationFieldsList.add("EMEA Accounts Only");
		opportunityInformationFieldsList.add("*Estimated Gross Fee/Commission");
		opportunityInformationFieldsList.add("*Close Date");
		opportunityInformationFieldsList.add("Confidential Opportunity");
		opportunityInformationFieldsList.add("*Sales Stage");
		opportunityInformationFieldsList.add("Comments");

		System.out.println("opportunity infomation fields are: " + opportunityInformationFieldsList);
	}

	static ArrayList<String> opportunityInformationFieldsListABEMEABroker = new ArrayList<String>();

	public void opportunityInformationFieldsABEMEABroker() {

		opportunityInformationFieldsListABEMEABroker.add("*Opportunity Name");
		opportunityInformationFieldsListABEMEABroker.add("*Account Name");
		opportunityInformationFieldsListABEMEABroker.add("EMEA Accounts Only");
		opportunityInformationFieldsListABEMEABroker.add("EMEA Accounts Only");
		opportunityInformationFieldsListABEMEABroker.add("*Estimated Gross Fee/Commission");
		opportunityInformationFieldsListABEMEABroker.add("*Close Date");
		opportunityInformationFieldsListABEMEABroker.add("Confidential Opportunity");
		opportunityInformationFieldsListABEMEABroker.add("*Sales Stage");

		System.out.println("opportunity infomation fields are: " +opportunityInformationFieldsListABEMEABroker);
	}
	static ArrayList<String> opportunityInformationFieldsListVASEMEABroker = new ArrayList<String>();

	public void opportunityInformationFieldsListVASEMEABroker() {

		opportunityInformationFieldsListVASEMEABroker.add("*Opportunity Name");
		opportunityInformationFieldsListVASEMEABroker.add("*Account Name");
		opportunityInformationFieldsListVASEMEABroker.add("EMEA Accounts Only");
		opportunityInformationFieldsListVASEMEABroker.add("EMEA Accounts Only");
		opportunityInformationFieldsListVASEMEABroker.add("*Estimated Gross Fee/Commission");
		opportunityInformationFieldsListVASEMEABroker.add("*Close Date");
		opportunityInformationFieldsListVASEMEABroker.add("Confidential Opportunity");
		opportunityInformationFieldsListVASEMEABroker.add("*Sales Stage");
		opportunityInformationFieldsListVASEMEABroker.add("Conversion Type");
		opportunityInformationFieldsListVASEMEABroker.add("Comments");
		opportunityInformationFieldsListVASEMEABroker.add("Risk");

		System.out.println("Opportunity infomation fields are: " +opportunityInformationFieldsListVASEMEABroker);
	}

	static ArrayList<String> additionalInformationFieldsList = new ArrayList<String>();

	public void additionalInformationFields() {

		additionalInformationFieldsList.add("Opportunity Owner");
		additionalInformationFieldsList.add("*Opportunity Currency");
		additionalInformationFieldsList.add("Net Fee");
		additionalInformationFieldsList.add("*Probability (%)");
		additionalInformationFieldsList.add("Conversion Type");
		additionalInformationFieldsList.add("Conversion Type Other");
		additionalInformationFieldsList.add("Weighted Net Fee");
		additionalInformationFieldsList.add("Assignment Type");
		additionalInformationFieldsList.add("Assignment Sub-Type");
		additionalInformationFieldsList.add("Address Line 1");
		additionalInformationFieldsList.add("Address Line 2");
		additionalInformationFieldsList.add("Postcode");
		additionalInformationFieldsList.add("Change Opportunity Owner");
		additionalInformationFieldsList.add("Unit of Measure");
		additionalInformationFieldsList.add("Total Size");
		additionalInformationFieldsList.add("Service Line");
		additionalInformationFieldsList.add("Asset Class");
		additionalInformationFieldsList.add("Comments History");
		additionalInformationFieldsList.add("City");
		additionalInformationFieldsList.add("Country");
		additionalInformationFieldsList.add("RFP Submission Date");
		additionalInformationFieldsList.add("Critical Date");

		System.out.println("Additional infomation fields are: " + additionalInformationFieldsList);
	}
	static ArrayList<String> additionalInformationFieldsListCMEMEABroker = new ArrayList<String>();

	public void additionalInformationFieldsCMEMEABroker() {

		additionalInformationFieldsListCMEMEABroker.add("Opportunity Owner");
		additionalInformationFieldsListCMEMEABroker.add("*Opportunity Currency");
		additionalInformationFieldsListCMEMEABroker.add("Net Fee");
		additionalInformationFieldsListCMEMEABroker.add("*Probability (%)");
		additionalInformationFieldsListCMEMEABroker.add("Portfolio Type");
		additionalInformationFieldsListCMEMEABroker.add("Address Line 1");
		additionalInformationFieldsListCMEMEABroker.add("Address Line 2");
		additionalInformationFieldsListCMEMEABroker.add("Postcode");
		additionalInformationFieldsListCMEMEABroker.add("Change Opportunity Owner");
		additionalInformationFieldsListCMEMEABroker.add("Unit of Measure");
		additionalInformationFieldsListCMEMEABroker.add("Total Size");
		additionalInformationFieldsListCMEMEABroker.add("Service Line");
		additionalInformationFieldsListCMEMEABroker.add("Asset Class");
		additionalInformationFieldsListCMEMEABroker.add("Comments");
		additionalInformationFieldsListCMEMEABroker.add("Comments History");
		additionalInformationFieldsListCMEMEABroker.add("City");
		additionalInformationFieldsListCMEMEABroker.add("Country");
		additionalInformationFieldsListCMEMEABroker.add("RFP Submission Date");

		System.out.println("Additional infomation fields are: " + additionalInformationFieldsListCMEMEABroker);
	}
	static ArrayList<String> additionalInformationFieldsListABEMEABroker = new ArrayList<String>();

	public void additionalInformationFieldsABEMEABroker() {

		additionalInformationFieldsListABEMEABroker.add("Opportunity Owner");
		additionalInformationFieldsListABEMEABroker.add("*Opportunity Currency");
		additionalInformationFieldsListABEMEABroker.add("Net Fee");
		additionalInformationFieldsListABEMEABroker.add("*Probability (%)");
		additionalInformationFieldsListABEMEABroker.add("Address Line 1");
		additionalInformationFieldsListABEMEABroker.add("Address Line 2");
		additionalInformationFieldsListABEMEABroker.add("Postcode");
		additionalInformationFieldsListABEMEABroker.add("Change Opportunity Owner");
		additionalInformationFieldsListABEMEABroker.add("Unit of Measure");
		additionalInformationFieldsListABEMEABroker.add("Total Size");
		additionalInformationFieldsListABEMEABroker.add("Service Line");
		additionalInformationFieldsListABEMEABroker.add("Asset Class");
		additionalInformationFieldsListABEMEABroker.add("Comments History");
		additionalInformationFieldsListABEMEABroker.add("City");
		additionalInformationFieldsListABEMEABroker.add("Country");
		additionalInformationFieldsListABEMEABroker.add("RFP Submission Date");
		additionalInformationFieldsListABEMEABroker.add("Critical Date");

		System.out.println("Additional infomation fields are: " + additionalInformationFieldsListABEMEABroker);
	}
	static ArrayList<String> additionalInformationFieldsListVASEMEABroker = new ArrayList<String>();

	public void additionalInformationFieldsVASEMEABroker() {

		additionalInformationFieldsListVASEMEABroker.add("Opportunity Owner");
		additionalInformationFieldsListVASEMEABroker.add("*Opportunity Currency");
		additionalInformationFieldsListVASEMEABroker.add("Net Fee");
		additionalInformationFieldsListVASEMEABroker.add("*Probability (%)");
		additionalInformationFieldsListVASEMEABroker.add("Assignment Type");
		additionalInformationFieldsListVASEMEABroker.add("Assignment Sub-Type");
		additionalInformationFieldsListVASEMEABroker.add("Address Line 1");
		additionalInformationFieldsListVASEMEABroker.add("Address Line 2");
		additionalInformationFieldsListVASEMEABroker.add("Postcode");
		additionalInformationFieldsListVASEMEABroker.add("Change Opportunity Owner");
		additionalInformationFieldsListVASEMEABroker.add("Unit of Measure");
		additionalInformationFieldsListVASEMEABroker.add("Total Size");
		additionalInformationFieldsListVASEMEABroker.add("Service Line");
		additionalInformationFieldsListVASEMEABroker.add("Asset Class");
		additionalInformationFieldsListVASEMEABroker.add("Sub-Asset Type");
		additionalInformationFieldsListVASEMEABroker.add("Comments History");
		additionalInformationFieldsListVASEMEABroker.add("Project Type Description");
		additionalInformationFieldsListVASEMEABroker.add("City");
		additionalInformationFieldsListVASEMEABroker.add("Country");
		additionalInformationFieldsListVASEMEABroker.add("RFP Submission Date");
		additionalInformationFieldsListVASEMEABroker.add("Critical Date");

		System.out.println("Additional infomation fields are: " + additionalInformationFieldsListVASEMEABroker);
	}

	static ArrayList<String> lossInformationFieldsList = new ArrayList<String>();

	public void lossInformationFields() {

		lossInformationFieldsList.add("Reason for Loss");
		lossInformationFieldsList.add("Reason Lost Comments");
		lossInformationFieldsList.add("Competitor");
		lossInformationFieldsList.add("Next Step");

		System.out.println("Loss infomation fields are: " + lossInformationFieldsList);
	}

	static ArrayList<String> dataHugFieldsList = new ArrayList<String>();

	public void dataHugFields() {

		dataHugFieldsList.add("Deal Score");
		dataHugFieldsList.add("Deal Score Reason");
		dataHugFieldsList.add("Best Connected Colleague");
		dataHugFieldsList.add("Last Email Received");
		dataHugFieldsList.add("Last Email Received from");
		dataHugFieldsList.add("Last Email Sent");
		dataHugFieldsList.add("Last Email Sent by");
		dataHugFieldsList.add("Last Meeting");
		dataHugFieldsList.add("Next Meeting");

		System.out.println("Data Hug section fields are: " + dataHugFieldsList);
	}

	static ArrayList<String> systemInformationFieldsList = new ArrayList<String>();

	public void systemInformationFields() {

		systemInformationFieldsList.add("External Deal ID");
		systemInformationFieldsList.add("Opportunity Record Type");

		System.out.println("System infomation fields are: " + systemInformationFieldsList);
	}

	public void opportunityQuickCreatePage() {
		Utility_Functions.xWaitForElementPresent(driver, menu_Opportunities, 3);
		Utility_Functions.xClick(driver, menu_Opportunities, true);
		Utility_Functions.xWaitForElementPresent(driver, newOpportunity, 3);
		Utility_Functions.xClick(driver, newOpportunity, true);
		Utility_Functions.timeWait(2);
		if((dataTable.getData("General_Data", "TC_ID").contains("ABEMEABroker"))){
			Utility_Functions.xSwitchtoFrame(driver, continueButton);
			Utility_Functions.xWaitForElementPresent(driver, continueButton, 5);
			Utility_Functions.xClick(driver, continueButton, true);
			Utility_Functions.timeWait(2);		
		}
		Utility_Functions.xSwitchtoFrame(driver, viewAllFieldsButton);
		Utility_Functions.xWaitForElementPresent(driver, viewAllFieldsButton, 5);
		Utility_Functions.xScrollWindow(driver);
		Utility_Functions.xClick(driver, viewAllFieldsButton, true);
		Utility_Functions.timeWait(5);
		Utility_Functions.xScrollWindowTop(driver);
		if((dataTable.getData("General_Data", "TC_ID").contains("ABEMEABroker"))){
			List<WebElement> opportunityInformationSectionList1 = driver.findElements(By.xpath(
					"//h2[text()='Opportunity Information']/parent::div/parent::div//*[@class='slds-form-element__label']"));
			int count19 = 0, i19 = 0;
			String fieldsArray19[] = new String[opportunityInformationSectionList1.size()];
			System.out.println(opportunityInformationSectionList1.size());
			try {
				opportunityInformationFieldsABEMEABroker();
				for (WebElement element19 : opportunityInformationSectionList1) {
					System.out.println(element19.getText());
					fieldsArray19[i19] = element19.getText();
					if (fieldsArray19[i19].equals(opportunityInformationFieldsListABEMEABroker.get(i19))) {
						report.updateTestLog("Verify New Account Page Layout ",
								"Opportunity Information section is having the " + fieldsArray19[i19] + " fields ",
								Status.PASS);
						count19++;
					}
					i19++;
				}
				System.out.println(count19);
				if (count19 != 8) {
					report.updateTestLog("Verify Opportunity Quick Create Page",
							"All fields are not present in the Opportunity Information section ", Status.FAIL);
				} else {

					report.updateTestLog("Verify Opportunity Quick Create Page",
							"All fields are present in the Opportunity Information section", Status.PASS);
				}
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
			opportunityInformationSectionList1.clear();

		}else if((dataTable.getData("General_Data", "TC_ID").contains("VASEMEABroker"))){
			List<WebElement> opportunityInformationSectionList3 = driver.findElements(By.xpath(
					"//h2[text()='Opportunity Information']/parent::div/parent::div//*[@class='slds-form-element__label']"));
			int count20 = 0, i20 = 0;
			String fieldsArray20[] = new String[opportunityInformationSectionList3.size()];
			System.out.println(opportunityInformationSectionList3.size());
			try {
				opportunityInformationFieldsListVASEMEABroker();
				for (WebElement element20 : opportunityInformationSectionList3) {
					System.out.println(element20.getText());
					fieldsArray20[i20] = element20.getText();
					if (fieldsArray20[i20].equals(opportunityInformationFieldsListVASEMEABroker.get(i20))) {
						report.updateTestLog("Verify New Account Page Layout ",
								"Opportunity Information section is having the " + fieldsArray20[i20] + " fields ",
								Status.PASS);
						count20++;
					}
					i20++;
				}
				System.out.println(count20);
				if (count20 != 11) {
					report.updateTestLog("Verify Opportunity Quick Create Page",
							"All fields are not present in the Opportunity Information section ", Status.FAIL);
				} else {

					report.updateTestLog("Verify Opportunity Quick Create Page",
							"All fields are present in the Opportunity Information section", Status.PASS);
				}
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}


		}else{
			List<WebElement> opportunityInformationSectionList = driver.findElements(By.xpath(
					"//h2[text()='Opportunity Information']/parent::div/parent::div//*[@class='slds-form-element__label']"));
			int count12 = 0, i12 = 0;
			String fieldsArray12[] = new String[opportunityInformationSectionList.size()];
			System.out.println(opportunityInformationSectionList.size());
			try {
				opportunityInformationFields();
				for (WebElement element12 : opportunityInformationSectionList) {
					System.out.println(element12.getText());
					fieldsArray12[i12] = element12.getText();
					if (fieldsArray12[i12].equals(opportunityInformationFieldsList.get(i12))) {
						report.updateTestLog("Verify New Account Page Layout ",
								"Opportunity Information section is having the " + fieldsArray12[i12] + " fields ",
								Status.PASS);
						count12++;
					}
					i12++;
				}
				System.out.println(count12);
				if (count12 >= 7) {
					report.updateTestLog("Verify Opportunity Quick Create Page",
							"All fields are not present in the Opportunity Information section ", Status.FAIL);
				} else {

					report.updateTestLog("Verify Opportunity Quick Create Page",
							"All fields are present in the Opportunity Information section", Status.PASS);
				}
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
			opportunityInformationSectionList.clear();
		}
		if ((dataTable.getData("General_Data", "TC_ID").contains("CMEMEABroker"))){
			List<WebElement> additionalInformationSectionList1 = driver.findElements(By.xpath(
					"//h2[text()='Additional Information']/parent::div/parent::div//*[@class='slds-form-element__label']"));
			int count14 = 0, i14 = 0;
			String fieldsArray14[] = new String[additionalInformationSectionList1.size()];
			System.out.println(additionalInformationSectionList1.size());
			try {
				additionalInformationFieldsCMEMEABroker();
				for (WebElement element14 : additionalInformationSectionList1) {
					System.out.println(element14.getText());
					fieldsArray14[i14] = element14.getText();
					if (fieldsArray14[i14].contains(additionalInformationFieldsListCMEMEABroker.get(i14))) {
						report.updateTestLog("Verify New Account Page Layout ",
								"Additional Information section is having the " + fieldsArray14[i14] + " fields ",
								Status.PASS);
						count14++;
					}
					i14++;
				}
				System.out.println(count14);
				if (count14 != 18) {
					report.updateTestLog("Verify Opportunity Quick Create Page",
							"All fields are not present in the Additional Information section ", Status.FAIL);
				} else {

					report.updateTestLog("Verify Opportunity Quick Create Page",
							"All fields are present in the Additional Information section", Status.PASS);
				}
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
			additionalInformationSectionList1.clear();

		}else if((dataTable.getData("General_Data", "TC_ID").contains("ABEMEABroker"))){
			List<WebElement> additionalInformationSectionList2 = driver.findElements(By.xpath(
					"//h2[text()='Additional Information']/parent::div/parent::div//*[@class='slds-form-element__label']"));
			int count17 = 0, i17 = 0;
			String fieldsArray17[] = new String[additionalInformationSectionList2.size()];
			System.out.println(additionalInformationSectionList2.size());
			try {
				additionalInformationFieldsABEMEABroker();
				for (WebElement element17 : additionalInformationSectionList2) {
					System.out.println(element17.getText());
					fieldsArray17[i17] = element17.getText();
					if (fieldsArray17[i17].contains(additionalInformationFieldsListABEMEABroker.get(i17))) {
						report.updateTestLog("Verify New Account Page Layout ",
								"Additional Information section is having the " + fieldsArray17[i17] + " fields ",
								Status.PASS);
						count17++;
					}
					i17++;
				}
				System.out.println(count17);
				if (count17 != 17) {
					report.updateTestLog("Verify Opportunity Quick Create Page",
							"All fields are not present in the Additional Information section ", Status.FAIL);
				} else {

					report.updateTestLog("Verify Opportunity Quick Create Page",
							"All fields are present in the Additional Information section", Status.PASS);
				}
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
			additionalInformationSectionList2.clear();


		}else if((dataTable.getData("General_Data", "TC_ID").contains("VASEMEABroker"))){
			List<WebElement> additionalInformationSectionList3 = driver.findElements(By.xpath(
					"//h2[text()='Additional Information']/parent::div/parent::div//*[@class='slds-form-element__label']"));
			int count21 = 0, i21 = 0;
			String fieldsArray21[] = new String[additionalInformationSectionList3.size()];
			System.out.println(additionalInformationSectionList3.size());
			try {
				additionalInformationFieldsVASEMEABroker();
				for (WebElement element21 : additionalInformationSectionList3) {
					System.out.println(element21.getText());
					fieldsArray21[i21] = element21.getText();
					if (fieldsArray21[i21].contains(additionalInformationFieldsListVASEMEABroker.get(i21))) {
						report.updateTestLog("Verify New Account Page Layout ",
								"Additional Information section is having the " + fieldsArray21[i21] + " fields ",
								Status.PASS);
						count21++;
					}
					i21++;
				}
				System.out.println(count21);
				if (count21 != 21) {
					report.updateTestLog("Verify Opportunity Quick Create Page",
							"All fields are not present in the Additional Information section ", Status.FAIL);
				} else {

					report.updateTestLog("Verify Opportunity Quick Create Page",
							"All fields are present in the Additional Information section", Status.PASS);
				}
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}

		}else{

			List<WebElement> additionalInformationSectionList = driver.findElements(By.xpath(
					"//h2[text()='Additional Information']/parent::div/parent::div//*[@class='slds-form-element__label']"));
			int count13 = 0, i13 = 0;
			String fieldsArray13[] = new String[additionalInformationSectionList.size()];
			System.out.println(additionalInformationSectionList.size());
			try {
				additionalInformationFields();
				for (WebElement element13 : additionalInformationSectionList) {
					System.out.println(element13.getText());
					fieldsArray13[i13] = element13.getText();
					if (fieldsArray13[i13].contains(additionalInformationFieldsList.get(i13))) {
						report.updateTestLog("Verify New Account Page Layout ",
								"Additional Information section is having the " + fieldsArray13[i13] + " fields ",
								Status.PASS);
						count13++;
					}
					i13++;
				}
				System.out.println(count13);
				if (count13 != 22) {
					report.updateTestLog("Verify Opportunity Quick Create Page",
							"All fields are not present in the Additional Information section ", Status.FAIL);
				} else {

					report.updateTestLog("Verify Opportunity Quick Create Page",
							"All fields are present in the Additional Information section", Status.PASS);
				}
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
			additionalInformationSectionList.clear();
		}
		List<WebElement> lossInformationSectionList = driver.findElements(By.xpath(
				"//h2[text()='Loss Information']/parent::div/parent::div//*[@class='slds-form-element__label']"));
		int count14 = 0, i14 = 0;
		String fieldsArray14[] = new String[lossInformationSectionList.size()];
		System.out.println(lossInformationSectionList.size());
		try {
			lossInformationFields();
			for (WebElement element14 : lossInformationSectionList) {
				System.out.println(element14.getText());
				fieldsArray14[i14] = element14.getText();
				if (fieldsArray14[i14].contains(lossInformationFieldsList.get(i14))) {
					report.updateTestLog("Verify New Account Page Layout ",
							"Loss Information section is having the " + fieldsArray14[i14] + " fields ", Status.PASS);
					count14++;
				}
				i14++;
			}
			System.out.println(count14);
			if (count14 >= 2) {
				report.updateTestLog("Verify Opportunity Quick Create Page",
						"All fields are  present in the Loss Information section ", Status.PASS);
			} else {

				report.updateTestLog("Verify Opportunity Quick Create Page",
						"All fields are not present in the Loss Information section", Status.FAIL);
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		lossInformationSectionList.clear();
		List<WebElement> dataHugSectionList = driver.findElements(By
				.xpath("//h2[text()='DataHug Details']/parent::div/parent::div//*[@class='slds-form-element__label']"));
		int count15 = 0, i15 = 0;
		String fieldsArray15[] = new String[dataHugSectionList.size()];
		System.out.println(dataHugSectionList.size());
		try {
			dataHugFields();
			for (WebElement element15 : dataHugSectionList) {
				System.out.println(element15.getText());
				fieldsArray15[i15] = element15.getText();
				if (fieldsArray15[i15].contains(dataHugFieldsList.get(i15))) {
					report.updateTestLog("Verify New Account Page Layout ",
							"Data Hug section is having the " + fieldsArray15[i15] + " fields ", Status.PASS);
					count15++;
				}
				i15++;
			}
			System.out.println(count15);
			if (count15 != 9) {
				report.updateTestLog("Verify Opportunity Quick Create Page",
						"All fields are not present in the Data Hug section ", Status.FAIL);
			} else {

				report.updateTestLog("Verify Opportunity Quick Create Page",
						"All fields are present in the Data Hug section", Status.PASS);
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		dataHugSectionList.clear();
		if ((dataTable.getData("General_Data", "TC_ID").contains("CMEMEABrokerIP")||(dataTable.getData("General_Data", "TC_ID").contains("CMEMEABrokerCA")||(dataTable.getData("General_Data", "TC_ID").contains("CMEMEABrokerBCP")||(dataTable.getData("General_Data", "TC_ID").contains("CMEMEABrokerCA")||(dataTable.getData("General_Data", "TC_ID").contains("CMEMEABrokerDev"))))))){
			List<WebElement> systemInformationSectionList = driver.findElements(By.xpath(
					"//h2[text()='System Information']/parent::div/parent::div//*[@class='slds-form-element__label']"));
			int count16 = 0, i16 = 0;
			String fieldsArray16[] = new String[systemInformationSectionList.size()];
			System.out.println(systemInformationSectionList.size());
			try {
				systemInformationFields();
				for (WebElement element16 : systemInformationSectionList) {
					System.out.println(element16.getText());
					fieldsArray16[i16] = element16.getText();
					if (fieldsArray16[i16].contains(systemInformationFieldsList.get(i16))) {
						report.updateTestLog("Verify New Account Page Layout ",
								"System Information section is having the " + fieldsArray16[i16] + " fields ", Status.PASS);
						count16++;
					}
					i16++;
				}
				System.out.println(count16);
				if (count16 != 2) {
					report.updateTestLog("Verify Opportunity Quick Create Page",
							"All fields are not present in the System Information section ", Status.FAIL);
				} else {

					report.updateTestLog("Verify Opportunity Quick Create Page",
							"All fields are present in the System Information section", Status.PASS);
				}
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}
		Utility_Functions.xWaitForElementPresent(driver, opportunityName, 3);
		Utility_Functions.xSendKeys(driver, opportunityName,
				"Test Automation Opportunity_" + Utility_Functions.xGenerateAlphaNumericString());
		String query = "SELECT Id, Name, EMEA_Searchable__c FROM Account where EMEA_Searchable__c = true limit 1 offset 9";
		String sAccountName = searchOpportunity.fetchRecordFieldValue("Name", query);
		Utility_Functions.xSendKeys(driver, accountName, sAccountName);
		accountName.sendKeys(Keys.ARROW_DOWN);
		Utility_Functions.timeWait(2);
		accountName.sendKeys(Keys.ENTER);
		Utility_Functions.timeWait(2);
		Utility_Functions.xWaitForElementPresent(driver,estimatedGrossFeeNewOpportunity, 3);
		Utility_Functions.xSendKeys(driver,estimatedGrossFeeNewOpportunity,
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
					"The opportunity is not saved with the Discretionary Fee check box checked and the Discretionary amount",
					Status.FAIL);
		}
	}

	/**
	 * Validating the Opportunities Quick create page mandatory fields
	 * 
	 * @author Ramya
	 *
	 */
	public void opportunityQuickCreatePageMandatoryFields() {
		Utility_Functions.xWaitForElementPresent(driver, menu_Opportunities, 3);
		Utility_Functions.xClick(driver, menu_Opportunities, true);
		Utility_Functions.xWaitForElementPresent(driver, newOpportunity, 3);
		Utility_Functions.xClick(driver, newOpportunity, true);
		Utility_Functions.timeWait(2);
		if (dataTable.getData("General_Data", "TC_ID").contains("Admin")) {				
				Utility_Functions.xSwitchtoFrame(driver, continueButton);
				Utility_Functions.xWaitForElementPresent(driver, continueButton, 5);
				Utility_Functions.xClick(driver, continueButton, true);
		}
		Utility_Functions.xSwitchtoFrame(driver, viewAllFieldsButton);
		Utility_Functions.xWaitForElementPresent(driver, viewAllFieldsButton, 5);
		Utility_Functions.xClick(driver,viewAllFieldsButton, true);
		Utility_Functions.timeWait(5);
		Utility_Functions.xWaitForElementPresent(driver, opportunityName, 3);
		Utility_Functions.xSendKeys(driver, opportunityName,
				"Test Automation Opportunity_" + Utility_Functions.xGenerateAlphaNumericString());
		if (dataTable.getData("General_Data", "TC_ID").contains("Admin")) {		
			Utility_Functions.xWaitForElementPresent(driver,accountName, 4);
			Utility_Functions.xSendKeys(driver, accountName, "-963425397_Test Automation_0131 (2100 Ross Avenue, Dallas, United States)");
			Utility_Functions.xWaitForElementPresent(driver,accountNameValueAdmin , 4);
			Utility_Functions.xClick(driver,accountNameValueAdmin , true);
			Utility_Functions.xWaitForElementPresent(driver,assignmentTypeOpp, 4);
			Utility_Functions.xClick(driver,assignmentTypeOpp, true);
			Utility_Functions.xWaitForElementPresent(driver,assignmentTypeValue, 4);
			Utility_Functions.xClick(driver,assignmentTypeValue, true);
			Utility_Functions.timeWait(2);
			Utility_Functions.xScrollWindow(driver);
			Utility_Functions.timeWait(1);
			Utility_Functions.xScrollWindowTop(driver);
			Utility_Functions.timeWait(2);
			Utility_Functions.xWaitForElementPresent(driver,preferedPropertyTypeAdmin, 4);
			Utility_Functions.xClick(driver,preferedPropertyTypeAdmin, true);
			Utility_Functions.xWaitForElementPresent(driver,preferedPropertyTypeValueAdmin, 4);
			Utility_Functions.xClick(driver,preferedPropertyTypeValueAdmin, true);
		} else {
				String query = "SELECT Id, Name, EMEA_Searchable__c FROM Account where EMEA_Searchable__c = true limit 1 offset 9";
				String sAccountName = searchOpportunity.fetchRecordFieldValue("Name", query);
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
		if ((dataTable.getData("General_Data", "TC_ID").contains("CMEMEABrokerBCP"))){
			System.out.println(Calendar.getInstance());
			DateFormat dateFormat1 = new SimpleDateFormat("MM/dd/yyyy");
			Date date1 = new Date();
			Utility_Functions.xWaitForElementPresent(driver,engagementCommencement, 3);
			Utility_Functions.xSendKeys(driver,engagementCommencement, dateFormat1.format(date1).toString());
			Utility_Functions.timeWait(2);
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
		Utility_Functions.xWaitForElementPresent(driver, menu_Opportunities, 3);
		Utility_Functions.xClick(driver, menu_Opportunities, true);
		Utility_Functions.xWaitForElementPresent(driver, newOpportunity, 3);
		Utility_Functions.xClick(driver, newOpportunity, true);
		Utility_Functions.timeWait(2);
		Utility_Functions.xSwitchtoFrame(driver, viewAllFieldsButton);
		Utility_Functions.xWaitForElementPresent(driver, viewAllFieldsButton, 5);
		Utility_Functions.xScrollWindow(driver);
		Utility_Functions.xClick(driver, viewAllFieldsButton, true);
		Utility_Functions.timeWait(2);
		Utility_Functions.xScrollWindow(driver);
		Utility_Functions.timeWait(1);
		Utility_Functions.xScrollWindowTop(driver);
		Utility_Functions.timeWait(2);
		if (assignmentTypeField.isDisplayed()) {
			report.updateTestLog("Verify Opportunity Quick Create AssignmentType", "Assignment type field is present",
					Status.PASS);
		} else {
			report.updateTestLog("Verify Opportunity Quick Create AssignmentType",
					"Assignment type field is not present", Status.FAIL);
		}
		List<WebElement> assignmentTypePickList = driver
				.findElements(By.xpath("//select[contains(@id,'assignmentType')]/option"));
		int count1 = 0, i1 = 0;
		String fieldsArray1[] = new String[assignmentTypePickList.size()];
		System.out.println(assignmentTypePickList.size());
		try {
			assignmentTypeValues();
			for (WebElement element1 : assignmentTypePickList) {
				System.out.println(element1.getText());
				fieldsArray1[i1] = element1.getText();
				if (fieldsArray1[i1].contains(assignmentTypeList.get(i1))) {
					report.updateTestLog("Verify Opportunity Quick Create AssignmentType",
							"Assignment Type is having the " + fieldsArray1[i1] + " fields ", Status.PASS);
					count1++;
				}
				i1++;
			}
			System.out.println(count1);
			if (count1 != 7) {
				report.updateTestLog("Verify Opportunity Quick Create AssignmentType",
						"All fields are not present in the Assignment type field ", Status.FAIL);
			} else {

				report.updateTestLog("Verify Opportunity Quick Create AssignmentType",
						"All fields are present in the Assignment type field", Status.PASS);
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	/**
	 * Validating the Opportunities Team related list columns
	 * 
	 * @author Ramya
	 *
	 */
	static ArrayList<String> opportunityTeamRelatedList = new ArrayList<String>();

	public void opportunityTeamRelatedListValues() {

		opportunityTeamRelatedList.add("User");
		opportunityTeamRelatedList.add("Team Member Description");
		opportunityTeamRelatedList.add("Team Role");
		opportunityTeamRelatedList.add("Secondary Member Role");
		opportunityTeamRelatedList.add("Opportunity Access");

		System.out.println("Opportunity Team column values are " + opportunityTeamRelatedList);
	}

	public void opportunityTeamRelatedList() {

		Utility_Functions.xClick(driver, menu_Opportunities, true);
		Utility_Functions.timeWait(4);
		List<WebElement> allActiveOpportunitiesList = driver.findElements(
				By.xpath(".//a[@class='slds-truncate outputLookupLink slds-truncate forceOutputLookup']"));
		Utility_Functions.xclickgetTextofFirstElementfromList(allActiveOpportunitiesList);
		Utility_Functions.timeWait(5);
		Utility_Functions.xClick(driver, related, true);
		Utility_Functions.timeWait(5);
		Utility_Functions.xClick(driver, addButtonOpportunitySharing, true);
		Utility_Functions.timeWait(3);
		Utility_Functions.xSwitchtoFrame(driver, saveButtonSplit);
		Utility_Functions.timeWait(5);
		List<WebElement> opportunityList = driver.findElements(By.xpath("//div[contains(@class, 'slds-truncate')]"));
		int count1 = 0, i1 = 0;
		String fieldsArray1[] = new String[opportunityList.size()];
		System.out.println(opportunityList.size());
		try {
			opportunityTeamRelatedListValues();
			for (WebElement element1 : opportunityList) {
				System.out.println(element1.getText());
				fieldsArray1[i1] = element1.getText();
				if (fieldsArray1[i1].equalsIgnoreCase(opportunityTeamRelatedList.get(i1))) {
					report.updateTestLog("Verify Opportunity Quick Create AssignmentType",
							"Opportunity relatedlist columns are having the " + fieldsArray1[i1] + " fields ",
							Status.PASS);
					count1++;
				}
				i1++;
			}
			System.out.println(count1);
			if (count1 >= 2) {
				report.updateTestLog("Verify Opportunity Quick Create AssignmentType",
						"All fields are present in the Lead Source field ", Status.PASS);
			} else {

				report.updateTestLog("Verify Opportunity Quick Create AssignmentType",
						"All fields are not present in the Lead Source field", Status.FAIL);
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

	}

	/**
	 * Validating the Opportunities Quick create page Assignment Type field
	 * 
	 * @author Ramya
	 *
	 */
	static ArrayList<String> leadSourceList = new ArrayList<String>();

	public void leadSourceValues() {

		leadSourceList.add("--None--");
		leadSourceList.add("Asset Services");
		leadSourceList.add("BC&P - Building Surveying");
		leadSourceList.add("BC&P - Cost Consultancy");
		leadSourceList.add("BC&P - CPO");
		leadSourceList.add("BC&P - Engineering Services");
		leadSourceList.add("BC&P - Planning");
		leadSourceList.add("BC&P - Projects");
		leadSourceList.add("Business Relationship");
		leadSourceList.add("Canvass/Cold Call");
		leadSourceList.add("Capital Advisors");
		leadSourceList.add("CBRE Cross Sell");
		leadSourceList.add("CBRE Referral/Existing Mandate");
		leadSourceList.add("Central London");
		leadSourceList.add("Direct Award");
		leadSourceList.add("GWS");
		leadSourceList.add("National Team");
		leadSourceList.add("Non CBRE Referral");
		leadSourceList.add("Other");
		leadSourceList.add("Personal Relationship");
		leadSourceList.add("Residential");
		leadSourceList.add("Retail");
		leadSourceList.add("RFP/Proposal/Pitch");
		leadSourceList.add("Sales Management");
		leadSourceList.add("Speculative Marketing/Business Dev");
		leadSourceList.add("Valuation");

		System.out.println("Lead source pick list values are: " + leadSourceList);
	}

	public void opportunityQuickCreateLeadSource() {
		Utility_Functions.xWaitForElementPresent(driver, menu_Opportunities, 3);
		Utility_Functions.xClick(driver, menu_Opportunities, true);
		Utility_Functions.xWaitForElementPresent(driver, newOpportunity, 3);
		Utility_Functions.xClick(driver, newOpportunity, true);
		Utility_Functions.timeWait(2);
		Utility_Functions.xSwitchtoFrame(driver, viewAllFieldsButton);
		Utility_Functions.xWaitForElementPresent(driver, viewAllFieldsButton, 5);
		Utility_Functions.xScrollWindow(driver);
		Utility_Functions.xClick(driver, viewAllFieldsButton, true);
		Utility_Functions.timeWait(2);
		Utility_Functions.xScrollWindow(driver);
		Utility_Functions.timeWait(1);
		Utility_Functions.xScrollWindowTop(driver);
		Utility_Functions.timeWait(2);
		if (leadSourceField.isDisplayed()) {
			report.updateTestLog("Verify Opportunity Quick Create Lead Source", "Lead Source field is present",
					Status.PASS);
		} else {
			report.updateTestLog("Verify Opportunity Quick Create Lead Source", "Lead Source field is not present",
					Status.FAIL);
		}
		List<WebElement> leadSourceTypePickList = driver
				.findElements(By.xpath("//select[contains(@id,'leadSource')]/option"));
		int count1 = 0, i1 = 0;
		String fieldsArray1[] = new String[leadSourceTypePickList.size()];
		System.out.println(leadSourceTypePickList.size());
		try {
			leadSourceValues();
			for (WebElement element1 : leadSourceTypePickList) {
				System.out.println(element1.getText());
				fieldsArray1[i1] = element1.getText();
				if (fieldsArray1[i1].contains(leadSourceList.get(i1))) {
					report.updateTestLog("Verify Opportunity Quick Create AssignmentType",
							"Assignment Type is having the " + fieldsArray1[i1] + " fields ", Status.PASS);
					count1++;
				}
				i1++;
			}
			System.out.println(count1);
			if (count1 != 26) {
				report.updateTestLog("Verify Opportunity Quick Create AssignmentType",
						"All fields are not present in the Lead Source field ", Status.FAIL);
			} else {

				report.updateTestLog("Verify Opportunity Quick Create AssignmentType",
						"All fields are present in the Lead Source field", Status.PASS);
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	/**
	 * Validating the Opportunities Quick create page Comments field
	 * 
	 * @author Ramya
	 *
	 */

	public void opportunityQuickCreateCommentsField() {
		Utility_Functions.xWaitForElementPresent(driver, menu_Opportunities, 3);
		Utility_Functions.xClick(driver, menu_Opportunities, true);
		Utility_Functions.xWaitForElementPresent(driver, newOpportunity, 3);
		Utility_Functions.xClick(driver, newOpportunity, true);
		Utility_Functions.timeWait(2);
		Utility_Functions.xSwitchtoFrame(driver, viewAllFieldsButton);
		Utility_Functions.xWaitForElementPresent(driver, viewAllFieldsButton, 5);
		Utility_Functions.xScrollWindow(driver);
		Utility_Functions.xClick(driver, viewAllFieldsButton, true);
		Utility_Functions.timeWait(2);
		Utility_Functions.xScrollWindow(driver);
		Utility_Functions.timeWait(1);
		Utility_Functions.xScrollWindowTop(driver);
		Utility_Functions.timeWait(2);
		if (opportunityComments.isDisplayed()) {
			report.updateTestLog("Verify Opportunity Quick Create Comments Field",
					"Opportunity Comments field is present", Status.PASS);
		} else {
			report.updateTestLog("Verify Opportunity Quick Create Comments Field",
					"Opportunity Comments field is not present", Status.FAIL);
		}
	}

	/**
	 * Validating the Opportunities pitch Advisor field
	 * 
	 * @author Ramya
	 *
	 */

	public void validateOpportunityPitchAdvisor() {
		Utility_Functions.xWaitForElementPresent(driver, menu_Opportunities, 3);
		Utility_Functions.xClick(driver, menu_Opportunities, true);
		Utility_Functions.xWaitForElementPresent(driver, newOpportunity, 3);
		Utility_Functions.xClick(driver, newOpportunity, true);
		Utility_Functions.timeWait(2);
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
		String sAccountName = searchOpportunity.fetchRecordFieldValue("Name", query);
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
		Utility_Functions.xWaitForElementPresent(driver, saveOpportunitySplitUAT, 4);
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
	 * Validating the Opportunities Quick create page Comments field
	 * 
	 * @author Ramya
	 *
	 */

	public void validateOpportunityNameQuickCreate() {
		Utility_Functions.xWaitForElementPresent(driver, menu_Opportunities, 3);
		Utility_Functions.xClick(driver, menu_Opportunities, true);
		Utility_Functions.xWaitForElementPresent(driver, newOpportunity, 3);
		Utility_Functions.xClick(driver, newOpportunity, true);
		Utility_Functions.timeWait(2);
		Utility_Functions.xScrollWindow(driver);
		Utility_Functions.timeWait(1);
		Utility_Functions.xScrollWindowTop(driver);
		Utility_Functions.timeWait(2);
		if (opportunityName_AS.getText().equals("")) {
			System.out.println("The opportunity name is not populated with the default value");
			report.updateTestLog("Verify Opportunities Quick Create Opportunity Name ",
					"Verifying the opportunity name is not populated with the default value ", Status.PASS);
		} else {
			System.out.println("The opportunity name is populated with the default value");
			report.updateTestLog("Verify Opportunities Quick Create Opportunity Name",
					"Verifying the opportunity name is populated with the default value", Status.FAIL);
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
		Utility_Functions.xWaitForElementPresent(driver, menu_Opportunities, 3);
		Utility_Functions.xClick(driver, menu_Opportunities, true);
		Utility_Functions.timeWait(2);
		Utility_Functions.xWaitForElementPresent(driver, newOpportunity, 3);
		Utility_Functions.xClick(driver, newOpportunity, true);
		Utility_Functions.timeWait(2);
		Utility_Functions.xSwitchtoFrame(driver, continueButton);
		Utility_Functions.xWaitForElementPresent(driver, continueButton, 5);
		Utility_Functions.xClick(driver, continueButton, true);
		Utility_Functions.timeWait(2);
		driver.switchTo().defaultContent();
		Utility_Functions.timeWait(2);
		Utility_Functions.xScrollWindow(driver);
		Utility_Functions.timeWait(1);
		Utility_Functions.xScrollWindowTop(driver);
		Utility_Functions.timeWait(2);
		if (averageAnnualLeasingCommission.isDisplayed()) {
			report.updateTestLog("Verify Opportunity Average Annual Leasing Commission",
					"Average Annual Leasing Commission is present", Status.PASS);
		} else {
			report.updateTestLog("Verify Opportunity Average Annual Leasing Commission",
					"Average Annual Leasing Commission is not present", Status.FAIL);
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
		Utility_Functions.xWaitForElementPresent(driver, menu_Opportunities, 3);
		Utility_Functions.xClick(driver, menu_Opportunities, true);
		report.updateTestLog("Verify Quick Create Opportunity Page State Street Pick List ",
				"Verifying the Opportunities page is displayed", Status.PASS);
		Utility_Functions.timeWait(2);
		Utility_Functions.xWaitForElementPresent(driver, newOpportunity, 3);
		Utility_Functions.xClick(driver, newOpportunity, true);
		report.updateTestLog("Verify Quick Create Opportunity Page State Street Pick List  ",
				"Verifying the new opportunity page is displayed", Status.PASS);
		Utility_Functions.timeWait(3);
		Utility_Functions.xSwitchtoFrame(driver, continueButton);
		Utility_Functions.timeWait(3);
		Utility_Functions.xClick(driver, continueButton, true);
		driver.switchTo().defaultContent();
		Utility_Functions.timeWait(2);
		Utility_Functions.xSwitchtoFrame(driver, viewAllFieldsButton);
		Utility_Functions.timeWait(2);
		Utility_Functions.xScrollWindow(driver);
		Utility_Functions.timeWait(2);
		Utility_Functions.xScrollWindowTop(driver);
		Utility_Functions.timeWait(2);
		Utility_Functions.xWaitForElementPresent(driver, unitOfMeasure, 3);
		Utility_Functions.xClick(driver, unitOfMeasure, true);
		report.updateTestLog("Verify Quick Create Opportunity Page Unit of Measure Pick List  ",
				"Verifying the new opportunity page Unit of Measure Pick List is displayed", Status.PASS);
		Utility_Functions.timeWait(1);
		String sPyeong = "Pyeong";
		List<WebElement> unitOfMeasurePickList = driver.findElements(
				By.xpath("//span[text()='Unit of Measure']/parent::div/select[contains(@id,'oppForm')]/option"));

		for (WebElement element : unitOfMeasurePickList) {
			element.getText();
			System.out.println(element.getText());
			if (element.getText().equals(sPyeong)) {
				System.out.println("Pyeong pick list value is present in the Unit of Measure pick list values");
				report.updateTestLog("Verify Quick Create Opportunity Page Unit of Measure Pick List  ",
						"Verifying the new opportunity page Unit of Measure pick list values", Status.PASS);

				break;
			}
		}

	}

	/**
	 * Validating the Opportunities Quick create page for the Mandatory fields
	 * for the Auckland broker
	 * 
	 * @author Ramya
	 *
	 */

	public void validateOpportunityMandatoryFieldsForAucklandBroker() {
		Utility_Functions.xWaitForElementPresent(driver, menu_Opportunities, 3);
		Utility_Functions.xClick(driver, menu_Opportunities, true);
		Utility_Functions.timeWait(2);
		Utility_Functions.xWaitForElementPresent(driver, newOpportunity, 3);
		Utility_Functions.xClick(driver, newOpportunity, true);
		Utility_Functions.timeWait(2);
		Utility_Functions.xScrollWindow(driver);
		Utility_Functions.timeWait(1);
		Utility_Functions.xScrollWindowTop(driver);
		Utility_Functions.timeWait(2);
		Utility_Functions.xWaitForElementPresent(driver, opportunityNameUpdate, 3);
		Utility_Functions.xSendKeys(driver, opportunityNameUpdate,
				"Test Personal Information Note_" + Utility_Functions.xGenerateAlphaNumericString());
		Utility_Functions.xWaitForElementPresent(driver, leadSourceNewOpportunity, 3);
		Utility_Functions.xClick(driver, leadSourceNewOpportunity, true);
		System.out.println(Calendar.getInstance());
		DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
		Date date = new Date();
		Utility_Functions.xWaitForElementPresent(driver, closeDate_AS, 3);
		Utility_Functions.xSendKeys(driver, closeDate_AS, dateFormat.format(date).toString());
		Utility_Functions.xWaitForElementPresent(driver, salesStage_AS, 4);
		Utility_Functions.xClick(driver, salesStage_AS, true);
		Utility_Functions.xClick(driver, salesStageValue_AS, true);
		Utility_Functions.xWaitForElementPresent(driver, estimatedGrossFeeField, 3);
		Utility_Functions.xSendKeys(driver, estimatedGrossFeeField, "10,000.00");
		List<WebElement> OpportunitiesList = driver.findElements(By.xpath(
				"//a[@class='outputLookupLink slds-truncate forceOutputLookup'][@title='Charles Test AU 0307 - King St']"));
		Utility_Functions.xclickRandomElement(OpportunitiesList);
		Utility_Functions.timeWait(2);

	}

	/**
	 * Validating the Opportunities Quick create page for the default
	 * opportunity name
	 * 
	 * @author Ramya
	 *
	 */

	public void validateDefaultOpportunityName() {
		Utility_Functions.xWaitForElementPresent(driver, menu_Opportunities, 3);
		Utility_Functions.xClick(driver, menu_Opportunities, true);
		Utility_Functions.timeWait(2);
		Utility_Functions.xWaitForElementPresent(driver, newOpportunity, 3);
		Utility_Functions.xClick(driver, newOpportunity, true);
		Utility_Functions.timeWait(3);

		if ((dataTable.getData("General_Data", "TC_ID").contains("ASEMEA"))&& (!dataTable.getData("General_Data", "TC_ID").contains("VASEMEA"))) {

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

		} 
		else {
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
			String sAccountName = searchOpportunity.fetchRecordFieldValue("Name", query);
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
						"The opportunity is not saved with the Discretionary Fee check box checked and the Discretionary amount",
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
		Utility_Functions.xWaitForElementPresent(driver, menu_Opportunities, 3);
		Utility_Functions.xClick(driver, menu_Opportunities, true);
		Utility_Functions.xWaitForElementPresent(driver, opportunitiesList, 3);
		Utility_Functions.xclickRandomElement(opportunitiesList);
		Utility_Functions.timeWait(1);
		Utility_Functions.xWaitForElementPresent(driver, related, 4);
		Utility_Functions.xClick(driver, related, true);
		Utility_Functions.xWaitForElementPresent(driver, opportunityInstallments, 3);
		Utility_Functions.xClick(driver, opportunityInstallments, true);
		Utility_Functions.timeWait(2);
		List<WebElement> opportunitiesInstallmentsList = driver.findElements(By.xpath(
				"//a[@class='slds-truncate outputLookupLink slds-truncate forceOutputLookup'][contains(@data-recordid,'a16')]"));
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
		Utility_Functions.xWaitForElementPresent(driver, related, 4);
		Utility_Functions.xClick(driver, related, true);
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
		Utility_Functions.xWaitForElementPresent(driver, menu_Opportunities, 3);
		Utility_Functions.xClick(driver, menu_Opportunities, true);
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
		Utility_Functions.xWaitForElementPresent(driver, menu_Opportunities, 3);
		Utility_Functions.xClick(driver, menu_Opportunities, true);
		report.updateTestLog("Verify Quick Create Opportunity Page State Street Pick List ",
				"Verifying the Opportunities page is displayed", Status.PASS);
		Utility_Functions.xWaitForElementPresent(driver, newOpportunity, 3);
		Utility_Functions.xClick(driver, newOpportunity, true);
		report.updateTestLog("Verify Quick Create Opportunity Page State Street Pick List  ",
				"Verifying the new opportunity page is displayed", Status.PASS);
		Utility_Functions.timeWait(2);
		Utility_Functions.xSwitchtoFrame(driver, viewAllFieldsButton);
		Utility_Functions.xClick(driver, viewAllFieldsButton, true);
		Utility_Functions.timeWait(2);
		Utility_Functions.xScrollWindow(driver);
		Utility_Functions.timeWait(2);
		Utility_Functions.xScrollWindowTop(driver);
		Utility_Functions.timeWait(2);
		if (propertyMarketValue.isDisplayed()) {
			System.out.println("Property Market Value is displayed");
			report.updateTestLog("Verify New Opportunity Property Market Value ",
					"Verifying the Property Market Value is displayed ", Status.PASS);
		} else {
			System.out.println("Property Market Value is not displayed");
			report.updateTestLog("Verify New Opportunity Property Market Value ",
					"Verifying the Property Market Value is displayed", Status.FAIL);
		}

		List<WebElement> propertyMarketValuePickList = driver
				.findElements(By.xpath("//select[contains(@id,'propertyMarketValueCurrency')]/option"));
		int count = 0, i = 0;
		String fieldsArray[] = new String[propertyMarketValuePickList.size()];
		System.out.println(propertyMarketValuePickList.size());
		try {
			propertyMarketValues();
			for (WebElement element : propertyMarketValuePickList) {
				System.out.println(element.getText());
				fieldsArray[i] = element.getText();
				if (fieldsArray[i].contains(propertyMarketValueCurrencyList.get(i))) {
					report.updateTestLog("Verify Opportunity Quick Create AssignmentType",
							"Property Market Value Currency is having the " + fieldsArray[i] + " fields ", Status.PASS);
					count++;
				}
				i++;
			}
			System.out.println(count);
			if (count != 4) {
				report.updateTestLog("Verify Opportunity Quick Create AssignmentType",
						"All fields are not present in the Assignment type field ", Status.FAIL);
			} else {

				report.updateTestLog("Verify Opportunity Quick Create AssignmentType",
						"All fields are present in the Assignment type field", Status.PASS);
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
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
		Utility_Functions.xWaitForElementPresent(driver, menu_Opportunities, 3);
		Utility_Functions.xClick(driver, menu_Opportunities, true);
		report.updateTestLog("Verify Quick Create Opportunity Page State Street Pick List ",
				"Verifying the Opportunities page is displayed", Status.PASS);
		Utility_Functions.timeWait(2);
		Utility_Functions.xWaitForElementPresent(driver, newOpportunity, 3);
		Utility_Functions.xClick(driver, newOpportunity, true);
		report.updateTestLog("Verify Quick Create Opportunity Page State Street Pick List  ",
				"Verifying the new opportunity page is displayed", Status.PASS);
		Utility_Functions.timeWait(3);
		Utility_Functions.xSwitchtoFrame(driver, continueButton);
		Utility_Functions.timeWait(3);

		Utility_Functions.xClick(driver, continueButton, true);
		driver.switchTo().defaultContent();
		Utility_Functions.timeWait(2);
		Utility_Functions.xSwitchtoFrame(driver, viewAllFieldsButton);
		Utility_Functions.timeWait(2);
		Utility_Functions.xScrollWindow(driver);
		Utility_Functions.timeWait(2);
		Utility_Functions.xScrollWindowTop(driver);
		Utility_Functions.timeWait(2);
		Utility_Functions.xWaitForElementPresent(driver, unitOfMeasure, 3);
		Utility_Functions.xClick(driver, unitOfMeasure, true);
		report.updateTestLog("Verify Quick Create Opportunity Page Unit of Measure Pick List  ",
				"Verifying the new opportunity page Unit of Measure Pick List is displayed", Status.PASS);
		Utility_Functions.timeWait(1);
		String sPing = "Ping";
		List<WebElement> unitOfMeasurePickList = driver.findElements(
				By.xpath("//span[text()='Unit of Measure']/parent::div/select[contains(@id,'oppForm')]/option"));

		for (WebElement element : unitOfMeasurePickList) {
			element.getText();
			System.out.println(element.getText());
			if (element.getText().equals(sPing)) {
				System.out.println("Ping pick list value is present in the Unit of Measure pick list values");
				report.updateTestLog("Verify Quick Create Opportunity Page Unit of Measure Pick List  ",
						"Verifying the new opportunity page Unit of Measure pick list values", Status.PASS);

				break;
			}
		}

	}

	/**
	 * Validating the Quick create Opportunity page for the Ping Value in UOM
	 * Pick List
	 * 
	 * @author Ramya
	 *
	 */

	public void verifyPingValueInOpportunityRecordTypes() {
		Utility_Functions.xWaitForElementPresent(driver, menu_Opportunities, 3);
		Utility_Functions.xClick(driver, menu_Opportunities, true);
		report.updateTestLog("Verify Quick Create Opportunity Page State Street Pick List ",
				"Verifying the Opportunities page is displayed", Status.PASS);
		Utility_Functions.timeWait(2);
		Utility_Functions.xWaitForElementPresent(driver, newOpportunity, 3);
		Utility_Functions.xClick(driver, newOpportunity, true);
		report.updateTestLog("Verify Quick Create Opportunity Page State Street Pick List  ",
				"Verifying the new opportunity page is displayed", Status.PASS);
		Utility_Functions.timeWait(3);
		Utility_Functions.xSwitchtoFrame(driver, continueButton);
		Utility_Functions.timeWait(3);
		Utility_Functions.xWaitForElementPresent(driver, selectRecordType, 3);
		Utility_Functions.xClick(driver, selectRecordType, true);
		Utility_Functions.xWaitForElementPresent(driver, recordTypeValue, 3);
		Utility_Functions.xClick(driver, recordTypeValue, true);
		Utility_Functions.xClick(driver, continueButton, true);
		driver.switchTo().defaultContent();
		Utility_Functions.timeWait(2);
		Utility_Functions.xSwitchtoFrame(driver, viewAllFieldsButton);
		Utility_Functions.timeWait(2);
		Utility_Functions.xScrollWindow(driver);
		Utility_Functions.timeWait(2);
		Utility_Functions.xScrollWindowTop(driver);
		Utility_Functions.timeWait(2);
		Utility_Functions.xWaitForElementPresent(driver, unitOfMeasure, 3);
		Utility_Functions.xClick(driver, unitOfMeasure, true);
		report.updateTestLog("Verify Quick Create Opportunity Page Unit of Measure Pick List  ",
				"Verifying the new opportunity page Unit of Measure Pick List is displayed", Status.PASS);
		Utility_Functions.timeWait(1);
		String sPing = "Ping";
		List<WebElement> unitOfMeasurePickList = driver.findElements(
				By.xpath("//span[text()='Unit of Measure']/parent::div/select[contains(@id,'oppForm')]/option"));

		for (WebElement element : unitOfMeasurePickList) {
			element.getText();
			System.out.println(element.getText());
			if (element.getText().equals(sPing)) {
				System.out.println("Ping pick list value is present in the Unit of Measure pick list values");
				report.updateTestLog("Verify Quick Create Opportunity Page Unit of Measure Pick List  ",
						"Verifying the new opportunity page Unit of Measure pick list values", Status.PASS);

				break;
			}
		}

	}

	/**
	 * Validating the Quick create Opportunity page for the Ping Value in UOM
	 * Pick List for the Property Sales Value for the Opportunity record type
	 * 
	 * @author Ramya
	 *
	 */

	public void verifyPingValueInOpportunityPropertySales() {
		Utility_Functions.xWaitForElementPresent(driver, menu_Opportunities, 3);
		Utility_Functions.xClick(driver, menu_Opportunities, true);
		report.updateTestLog("Verify Quick Create Opportunity Page State Street Pick List ",
				"Verifying the Opportunities page is displayed", Status.PASS);
		Utility_Functions.timeWait(2);
		Utility_Functions.xWaitForElementPresent(driver, newOpportunity, 3);
		Utility_Functions.xClick(driver, newOpportunity, true);
		report.updateTestLog("Verify Quick Create Opportunity Page State Street Pick List  ",
				"Verifying the new opportunity page is displayed", Status.PASS);
		Utility_Functions.timeWait(3);
		Utility_Functions.xSwitchtoFrame(driver, continueButton);
		Utility_Functions.timeWait(3);
		Utility_Functions.xWaitForElementPresent(driver, selectRecordType, 3);
		Utility_Functions.xClick(driver, selectRecordType, true);
		Utility_Functions.xWaitForElementPresent(driver, recordTypePropertySalesValue, 3);
		Utility_Functions.xClick(driver, recordTypePropertySalesValue, true);
		Utility_Functions.xClick(driver, continueButton, true);
		driver.switchTo().defaultContent();
		Utility_Functions.timeWait(2);
		Utility_Functions.xScrollWindow(driver);
		Utility_Functions.timeWait(2);
		Utility_Functions.xScrollWindowTop(driver);
		Utility_Functions.timeWait(2);
		try {
			if (unitOfMeasureLabel.isDisplayed()) {
				Utility_Functions.xWaitForElementPresent(driver, unitOfMeasureLabel, 3);
				Utility_Functions.xClick(driver, unitOfMeasureLabel, true);
				report.updateTestLog("Verify Quick Create Opportunity Page Unit of Measure Pick List  ",
						"Verifying the new opportunity page Unit of Measure Pick List is displayed", Status.PASS);
				Utility_Functions.timeWait(1);
				String sPing = "Ping";
				List<WebElement> unitOfMeasurePickList = driver.findElements(By
						.xpath("//span[text()='Unit of Measure']/parent::div/select[contains(@id,'oppForm')]/option"));

				for (WebElement element : unitOfMeasurePickList) {
					element.getText();
					System.out.println(element.getText());
					if (element.getText().equals(sPing)) {
						System.out.println("Ping pick list value is present in the Unit of Measure pick list values");
						report.updateTestLog("Verify Quick Create Opportunity Page Unit of Measure Pick List  ",
								"Verifying the new opportunity page Unit of Measure pick list values", Status.PASS);

						break;
					}
				}
			} else {
				report.updateTestLog("Verify Quick Create Opportunity Page Unit of Measure Pick List",
						"The unit of measure is present for the property Sales opportunity record type but not clickable",
						Status.FAIL);
			}

		} catch (Exception e) {
			System.out.println(
					"Unit of Measure is present and not clickable in the Opportunity Record Type Property Sales");
			report.updateTestLog("Verify Quick Create Opportunity Page Unit of Measure Pick List  ",
					"Verifying the new opportunity page Unit of Measure pick list values are present ", Status.PASS);
		}

	}

	/**
	 * Validating the Quick create Opportunity page for the CBRE Market Group
	 * 
	 * @author Ramya
	 *
	 */

	public void verifyCBREMarketGroup() {
		Utility_Functions.xWaitForElementPresent(driver, menu_Opportunities, 3);
		Utility_Functions.xClick(driver, menu_Opportunities, true);
		report.updateTestLog("Verify Quick Create Opportunity Page State Street Pick List ",
				"Verifying the Opportunities page is displayed", Status.PASS);
		Utility_Functions.timeWait(2);
		Utility_Functions.xWaitForElementPresent(driver, newOpportunity, 3);
		Utility_Functions.xClick(driver, newOpportunity, true);
		report.updateTestLog("Verify Quick Create Opportunity Page State Street Pick List  ",
				"Verifying the new opportunity page is displayed", Status.PASS);
		Utility_Functions.timeWait(3);
		Utility_Functions.xSwitchtoFrame(driver, continueButton);
		Utility_Functions.timeWait(3);
		Utility_Functions.xClick(driver, continueButton, true);
		driver.switchTo().defaultContent();
		Utility_Functions.timeWait(2);
		Utility_Functions.xSwitchtoFrame(driver, viewAllFieldsButton);
		Utility_Functions.xClick(driver, viewAllFieldsButton, true);
		Utility_Functions.timeWait(2);
		Utility_Functions.xScrollWindow(driver);
		Utility_Functions.timeWait(2);
		Utility_Functions.xScrollWindowTop(driver);
		Utility_Functions.timeWait(2);
		if ((marketGroup.isDisplayed()) && (subMarketGroup.isDisplayed())) {

			report.updateTestLog("Verify Quick Create Opportunity Page Market Group ",
					"The Market Group and sub Market Group Pick List are displayed", Status.PASS);

		} else {
			report.updateTestLog("Verify Quick Create Opportunity Page Market Group ",
					"The Market Group and sub Market Group Pick List are not displayed", Status.FAIL);
		}
		Utility_Functions.xWaitForElementPresent(driver, opportunityName, 3);
		Utility_Functions.xSendKeys(driver, opportunityName,
				"Test Automation Opportunity_" + Utility_Functions.xGenerateAlphaNumericString());
		String query = "SELECT Id, Name, EMEA_Searchable__c FROM Account where EMEA_Searchable__c = true limit 1 offset 9";
		String sAccountName = searchOpportunity.fetchRecordFieldValue("Name", query);
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
		Utility_Functions.xWaitForElementPresent(driver, salesStageValue, 4);
		Utility_Functions.xClick(driver, salesStageValue, true);
		System.out.println(Calendar.getInstance());
		DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
		Date date = new Date();
		Utility_Functions.xWaitForElementPresent(driver, closeDateNewOpportunity, 3);
		Utility_Functions.xSendKeys(driver, closeDateNewOpportunity, dateFormat.format(date).toString());
		Utility_Functions.timeWait(2);
		Utility_Functions.xWaitForElementPresent(driver, saveOpportunitySplitUAT, 4);
		Utility_Functions.xClick(driver, saveOpportunitySplitUAT, true);

		if (marketGroupMandatory.isDisplayed()) {

			report.updateTestLog("Verify Quick Create Opportunity Page Market Group ",
					"The Market Group is mandatory for the Prospecting and Advanced Sales Stage is displayed",
					Status.PASS);

		} else {
			report.updateTestLog("Verify Quick Create Opportunity Page Market Group ",
					"The Market Group is mandatory for the Prospecting and Advanced Sales Stage is not displayed",
					Status.FAIL);
		}

	}

	/**
	 * Validating the Opportunities and the create offer page fields for the
	 * Auckland Broker
	 * 
	 * @author Ramya
	 *
	 */

	public void verifyNewOfferCreationPage() {
		Utility_Functions.xWaitForElementPresent(driver, menu_Opportunities, 3);
		Utility_Functions.xClick(driver, menu_Opportunities, true);
		report.updateTestLog("Verify Quick Create Opportunity Page State Street Pick List ",
				"Verifying the Opportunities page is displayed", Status.PASS);
		Utility_Functions.timeWait(2);
		Utility_Functions.xWaitForElementPresent(driver, newOpportunity, 3);
		Utility_Functions.xClick(driver, newOpportunity, true);
		report.updateTestLog("Verify Quick Create Opportunity Page State Street Pick List  ",
				"Verifying the new opportunity page is displayed", Status.PASS);
		Utility_Functions.timeWait(2);
		Utility_Functions.xSwitchtoFrame(driver, continueButton);
		Utility_Functions.xWaitForElementPresent(driver, continueButton, 3);
		Utility_Functions.xClick(driver, continueButton, true);
		Utility_Functions.timeWait(2);
		driver.switchTo().defaultContent();
		Utility_Functions.timeWait(2);
		Utility_Functions.xWaitForElementPresent(driver, searchProperties, 3);
		Utility_Functions.xClick(driver, searchProperties, true);
		String environment = loginPage.initializeEnvironment();
		if (environment.equals("FTE")) {
			Utility_Functions.xWaitForElementPresent(driver, searchProperties, 3);
			Utility_Functions.xSendKeys(driver, searchProperties, "UOM Auckland Broker");
			Utility_Functions.xWaitForElementPresent(driver, propertyValue2, 3);
			Utility_Functions.xClick(driver, propertyValue2, true);
		} else {
			Utility_Functions.xWaitForElementPresent(driver, searchProperties, 3);
			Utility_Functions.xSendKeys(driver, searchProperties, "APAC Property Test - Test CM");
			Utility_Functions.xWaitForElementPresent(driver, propertyValue, 3);
			Utility_Functions.xClick(driver, propertyValue, true);
		}
		Utility_Functions.xWaitForElementPresent(driver, opportunityName_AS, 3);
		Utility_Functions.xSendKeys(driver, opportunityName_AS,
				"Test Automation Opportunity_" + Utility_Functions.xGenerateAlphaNumericString());

		String environment1 = loginPage.initializeEnvironment();
		if (environment1.equals("FTE")) {
			Utility_Functions.xWaitForElementPresent(driver, searchAccountsNewOpportunity, 3);
			Utility_Functions.xClick(driver, searchAccountsNewOpportunity, true);
			Utility_Functions.xWaitForElementPresent(driver, searchAccountsNewOpportunity, 3);
			Utility_Functions.xSendKeys(driver, searchAccountsNewOpportunity, "Account APAC");
			Utility_Functions.xWaitForElementPresent(driver, accountValue2, 3);
			Utility_Functions.xClick(driver, accountValue2, true);
		} else {
			Utility_Functions.xWaitForElementPresent(driver, searchAccountsNewOpportunity, 3);
			Utility_Functions.xClick(driver, searchAccountsNewOpportunity, true);
			Utility_Functions.xWaitForElementPresent(driver, searchAccountsNewOpportunity, 3);
			Utility_Functions.xSendKeys(driver, searchAccountsNewOpportunity,
					"01BQ2Q8NMECBRE Test SFDC Automation_0401");
			Utility_Functions.xWaitForElementPresent(driver, searchAccountValue, 3);
			Utility_Functions.xClick(driver, searchAccountValue, true);
		}
		Utility_Functions.xWaitForElementPresent(driver, leadSourceNewOpportunity, 4);
		Utility_Functions.xClick(driver, leadSourceNewOpportunity, true);
		Utility_Functions.xWaitForElementPresent(driver, leadSourceValue, 4);
		Utility_Functions.xClick(driver, leadSourceValue, true);
		Utility_Functions.xWaitForElementPresent(driver, estimatedGrossFeeField, 3);
		Utility_Functions.xSendKeys(driver, estimatedGrossFeeField,
				dataTable.getData("General_Data", "InstallmentAmount"));
		Utility_Functions.xWaitForElementPresent(driver, estimatedTransactionValue, 4);
		Utility_Functions.xSendKeys(driver, estimatedTransactionValue,
				dataTable.getData("General_Data", "InstallmentAmount"));
		System.out.println(Calendar.getInstance());
		DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
		Date date = new Date();
		Utility_Functions.xWaitForElementPresent(driver, closeDate_AS, 3);
		Utility_Functions.xSendKeys(driver, closeDate_AS, dateFormat.format(date).toString());
		Utility_Functions.xWaitForElementPresent(driver, salesStage_AS, 4);
		Utility_Functions.xClick(driver, salesStage_AS, true);
		Utility_Functions.xWaitForElementPresent(driver, selectStageValue, 4);
		Utility_Functions.xClick(driver, selectStageValue, true);
		Utility_Functions.xWaitForElementPresent(driver, saveNewOpportunity_AS, 4);
		Utility_Functions.xClick(driver, saveNewOpportunity_AS, true);
		Utility_Functions.timeWait(3);
	}

	/**
	 * Validating the Opportunities and the create offer page fields for the
	 * Auckland Broker
	 * 
	 * @author Ramya
	 *
	 */
	static ArrayList<String> createOfferFieldsList = new ArrayList<String>();

	public void createOfferPageFields() {

		createOfferFieldsList.add("Offeror Contact");
		createOfferFieldsList.add("Deposit");
		createOfferFieldsList.add("Offer Date");
		createOfferFieldsList.add("Offer Due Diligence Days");
		createOfferFieldsList.add("Offer Price");
		createOfferFieldsList.add("Offer Estimated Settlement Date");
		createOfferFieldsList.add("Source of Financing");
		createOfferFieldsList.add("Winner Offer");
		createOfferFieldsList.add("Approvals/Condition of Sale");
		createOfferFieldsList.add("Comments");
		createOfferFieldsList.add("Offer Name");

		System.out.println("The Fields present in the account details page are " + createOfferFieldsList);

	}

	public void verifyOfferCreationPageFields() {

		verifyNewOfferCreationPage();
		Utility_Functions.xWaitForElementPresent(driver, showMoreActions, 4);
		Utility_Functions.xClick(driver, showMoreActions, true);
		Utility_Functions.xWaitForElementPresent(driver, createOffer, 4);
		Utility_Functions.xClick(driver, createOffer, true);
		Utility_Functions.timeWait(3);
		List<WebElement> createOfferPageList = driver
				.findElements(By.xpath("//label[contains(@class,'form-element__label')]/span[1]"));
		int count1 = 0, i1 = 0, j1 = 0;
		String fieldsArray[] = new String[createOfferPageList.size()];
		System.out.println(createOfferPageList.size());
		try {
			createOfferPageFields();
			while (j1 < createOfferPageList.size()) {
				for (WebElement element1 : createOfferPageList) {
					fieldsArray[i1] = element1.getText();
					if (fieldsArray[i1].equalsIgnoreCase(createOfferFieldsList.get(j1))) {
						System.out.println("Verify Account Details Page " + element1.getText());
						report.updateTestLog("Verify Account Details Page ",
								element1.getText() + "labels  present in the Account Detailed Page ", Status.PASS);
						count1++;
					}
					i1++;
				}
				i1 = 0;
				j1++;
			}
			System.out.println(count1);
			if (count1 != 10) {
				report.updateTestLog("Verify Accounts Details Page",
						"All fields are not present in the Accounts Details Page", Status.FAIL);
			} else {
				report.updateTestLog("Verify Accounts Details Page",
						"All fields are present in the Accounts Details Page", Status.PASS);
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

	}

	/**
	 * Validating the Opportunities create offer page by filling all the
	 * mandatory fields for the Auckland Broker
	 * 
	 * @author Ramya
	 *
	 */

	public void namingConventionOfOfferObject() {

		verifyOfferCreationPageFields();
		Utility_Functions.timeWait(3);
		Utility_Functions.xWaitForElementPresent(driver, offerorAccount, 3);
		Utility_Functions.xClick(driver, offerorAccount, true);
		Utility_Functions.xWaitForElementPresent(driver, offerorAccount, 3);
		Utility_Functions.xSendKeys(driver, offerorAccount, "AUCAPACBroker123");
		Utility_Functions.xWaitForElementPresent(driver, offerorAccountValue, 3);
		Utility_Functions.xClick(driver, offerorAccountValue, true);
		Utility_Functions.xWaitForElementPresent(driver, offerorContact, 3);
		Utility_Functions.xClick(driver, offerorContact, true);
		Utility_Functions.xWaitForElementPresent(driver, offerorContact, 3);
		Utility_Functions.xSendKeys(driver, offerorContact, "AUCAPACBroker123");
		Utility_Functions.xWaitForElementPresent(driver, offerorContactValue, 3);
		Utility_Functions.xClick(driver, offerorContactValue, true);
		Utility_Functions.xWaitForElementPresent(driver, offerPrice, 3);
		Utility_Functions.xSendKeys(driver, offerPrice, dataTable.getData("General_Data", "InstallmentAmount"));
		Utility_Functions.xWaitForElementPresent(driver, createOfferSave, 3);
		Utility_Functions.xClick(driver, createOfferSave, true);
		Utility_Functions.timeWait(3);

	}

	/**
	 * Validating the related list of offer objects
	 * 
	 * @author Ramya
	 *
	 */

	public void relatedListOfOfferObject() {
		namingConventionOfOfferObject();
		Utility_Functions.timeWait(3);
		Utility_Functions.xWaitForElementPresent(driver, showMoreActions, 4);
		Utility_Functions.xClick(driver, showMoreActions, true);
		if (/* (newEvent.isDisplayed())&& */(newTask.isDisplayed())) {
			System.out.println("New Event and New task are displayed");
			report.updateTestLog("Verify Related List of Offer Objects ",
					"Verifying the New Event and New Task are displayed ", Status.PASS);
		} else {
			System.out.println("New Event and New task are not displayed");
			report.updateTestLog("Verify Related List of Offer Objects ",
					"Verifying the New Event and New Task are not displayed", Status.FAIL);
		}

	}

	/**
	 * Validating the buttons on the offer object
	 * 
	 * @author Ramya
	 *
	 */

	public void buttonsOnOfferObject() {
		namingConventionOfOfferObject();
		if ((edit.isDisplayed()) && (clone.isDisplayed())) {
			System.out.println("Edit and Clone buttons are displayed");
			report.updateTestLog("Verify Buttons on Offer Object ", "The Edit and Clone buttons are displayed ",
					Status.PASS);
		} else {
			System.out.println("New Event and New task are not displayed");
			report.updateTestLog("Verify Buttons on Offer Object ", "The Edit and Clone buttons are not displayed",
					Status.FAIL);
		}

	}

	/**
	 * Validating the headers of the offer object
	 * 
	 * @author Ramya
	 * 
	 *
	 */
	public void headersOfOfferObject() {
		namingConventionOfOfferObject();
		Utility_Functions.xWaitForElementPresent(driver, related, 3);
		Utility_Functions.xClick(driver, related, true);
		Utility_Functions.xWaitForElementPresent(driver, offers, 3);
		Utility_Functions.xClick(driver, offers, true);
		Utility_Functions.timeWait(3);
		List<WebElement> accountNamesList = driver.findElements(By.xpath(
				"//a[@class='slds-truncate outputLookupLink slds-truncate forceOutputLookup'][contains(@data-recordid,'a2V')]"));
		Utility_Functions.xclickOnFirstElementfromList(accountNamesList);
		Utility_Functions.timeWait(3);
		if ((offerOpportunity.isDisplayed()) && (offerProperty.isDisplayed()) && (offerEnquiry.isDisplayed())
				&& (offerorAccountHeader.isDisplayed()) && (offerorContactHeader.isDisplayed())
				&& (offerDate.isDisplayed())) {
			System.out.println(
					"Offer Opportunity, Offer Property, Offer Enquiry, Offeror Account, Offeror Contact and Offer Date are displayed on the Offer Header page");
			report.updateTestLog("Verify Offer Header Page",
					"Offer Opportunity, Offer Property, Offer Enquiry, Offeror Account, Offeror Contact and Offer Date are displayed on the Offer Header page",
					Status.PASS);
		} else {
			System.out.println("New Event and New task are not displayed");
			report.updateTestLog("Verify Offer Header Page",
					"Offer Opportunity, Offer Property, Offer Enquiry, Offeror Account, Offeror Contact and Offer Date are not displayed on the Offer Header page",
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
		Utility_Functions.xWaitForElementPresent(driver, menu_Opportunities, 3);
		Utility_Functions.xClick(driver, menu_Opportunities, true);
		Utility_Functions.xWaitForElementPresent(driver, newOpportunity, 3);
		Utility_Functions.xClick(driver, newOpportunity, true);
		Utility_Functions.timeWait(2);
		Utility_Functions.xSwitchtoFrame(driver, viewAllFieldsButton);
		Utility_Functions.xWaitForElementPresent(driver, viewAllFieldsButton, 5);
		Utility_Functions.xClick(driver, viewAllFieldsButton, true);
		Utility_Functions.timeWait(5);
		Utility_Functions.xWaitForElementPresent(driver, opportunityName, 3);
		Utility_Functions.xSendKeys(driver, opportunityName,
				"Test Automation Opportunity_" + Utility_Functions.xGenerateAlphaNumericString());
		String query = "SELECT Id, Name, EMEA_Searchable__c FROM Account where EMEA_Searchable__c = true limit 1 offset 9";
		String sAccountName = searchOpportunity.fetchRecordFieldValue("Name", query);
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
					"The opportunity is saved with the Discretionary Fee check box checked and the Discretionary amount ",
					Status.PASS);
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
		Utility_Functions.xWaitForElementPresent(driver, menu_Opportunities, 3);
		Utility_Functions.xClick(driver, menu_Opportunities, true);
		Utility_Functions.xWaitForElementPresent(driver, newOpportunity, 3);
		Utility_Functions.xClick(driver, newOpportunity, true);
		Utility_Functions.xSwitchtoFrame(driver, viewAllFieldsButton);
		Utility_Functions.xWaitForElementPresent(driver, viewAllFieldsButton, 5);
		Utility_Functions.xClick(driver, viewAllFieldsButton, true);
		Utility_Functions.timeWait(5);
		Utility_Functions.xWaitForElementPresent(driver, conversionType, 4);
		Utility_Functions.xClick(driver, conversionType, true);
		List<WebElement> conversionTypePickList = driver.findElements(
				By.xpath("//label[contains(text(),'Conversion Type')]/following-sibling::div/div/select/option"));
		int count = 0, i = 0;
		String fieldsArray[] = new String[conversionTypePickList.size()];
		System.out.println(conversionTypePickList.size());
		try {
			conversionTypePickListFields();
			for (WebElement element : conversionTypePickList) {
				System.out.println(element.getText());
				fieldsArray[i] = element.getText();
				if (fieldsArray[i].contains(conversionTypeFieldsList.get(i))) {
					report.updateTestLog("Verify Opportunity Quick Create Page Conversion Type",
							"Conversion Type Pick list is having the " + fieldsArray[i] + " values ", Status.PASS);
					count++;
				}
				i++;
			}
			System.out.println(count);
			if (count != 7) {
				report.updateTestLog("Verify Opportunity Quick Create Page Conversion Type",
						"All fields are not present in the Conversion Type field ", Status.FAIL);
			} else {

				report.updateTestLog("Verify Opportunity Quick Create Page Conversion Type",
						"All fields are present in the Conversion Type field", Status.PASS);
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
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
		String sAccountName = searchOpportunity.fetchRecordFieldValue("Name", query);
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
		Utility_Functions.xWaitForElementPresent(driver, menu_Opportunities, 3);
		Utility_Functions.xClick(driver, menu_Opportunities, true);
		Utility_Functions.xWaitForElementPresent(driver, newOpportunity, 3);
		Utility_Functions.xClick(driver, newOpportunity, true);
		Utility_Functions.timeWait(2);
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
	 * Validating the Net Fee Field Mandatory in the New Opportunity creation
	 * page
	 * 
	 * @author Ramya
	 * 
	 *
	 */
	public void opportunityNetFeeFieldMandatory() {
		Utility_Functions.xWaitForElementPresent(driver, menu_Opportunities, 3);
		Utility_Functions.xClick(driver, menu_Opportunities, true);
		Utility_Functions.xWaitForElementPresent(driver, newOpportunity, 3);
		Utility_Functions.xClick(driver, newOpportunity, true);
		Utility_Functions.timeWait(2);
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
		String sAccountName = searchOpportunity.fetchRecordFieldValue("Name", query);
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
		} /*else {
			Utility_Functions.xWaitForElementPresent(driver, salesStageEMEAEstimatedGrossCommission, 3);
			Utility_Functions.xSendKeys(driver, salesStageEMEAEstimatedGrossCommission,
					dataTable.getData("General_Data", "InstallmentAmount"));
		}*/
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
		/*Utility_Functions.xWaitForElementPresent(driver, menu_Opportunities, 4);
		Utility_Functions.xClick(driver, menu_Opportunities, true);
		Utility_Functions.xWaitForElementPresent(driver, recentlyViewed, 4);
		Utility_Functions.xClick(driver, recentlyViewed, true);
		Utility_Functions.xWaitForElementPresent(driver, allActiveOpportunities, 4);
		Utility_Functions.xClick(driver, allActiveOpportunities, true);
		Utility_Functions.xWaitForElementPresent(driver, opportunitiesList, 3);	
		Utility_Functions.xclickRandomElement(opportunitiesList);*/
		opportunityEligibility();
		Utility_Functions.timeWait(2);
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
	/*
	 * Validating the Clone and Edit buttons in Opportunity VF Page
	 * 
	 * @author Vishnuvardhan
	 *
	 */

	public void cloneAndEditButtonsOpportunity() {
		Utility_Functions.xWaitForElementPresent(driver, menu_Opportunities, 3);
		opportunityEligibility();
		Utility_Functions.xWaitForElementPresent(driver, edit, 3);
		Utility_Functions.xClick(driver, edit, true);
		report.updateTestLog("Verify Opportunity Edit/Clone", "Edit button is present on Opportunity", Status.PASS);
		if (dataTable.getData("General_Data", "TC_ID").contains("ABAMER")) {
			Utility_Functions.timeWait(2);
			Utility_Functions.xSwitchtoFrame(driver, closeDateOpp);
			Utility_Functions.timeWait(2);
			Utility_Functions.xWaitForElementPresent(driver, closeDateOpp, 3);
			try {
				if (assignmentTypeOppValueClone.getText().equals("Building Agency Lease")) {
					Utility_Functions.xSelectDropdownByIndex(assignmentTypeOpp, 2);
				} else if (assignmentTypeOppValueClone.getText().equals("Building Agency Sale")) {
					Utility_Functions.xSelectDropdownByIndex(assignmentTypeOpp, 3);
				} else if (assignmentTypeOppValueClone.getText().equals("Consulting")) {
					Utility_Functions.xSelectDropdownByIndex(assignmentTypeOpp, 2);
				}
			} catch (Exception e) {
				Utility_Functions.xSelectDropdownByIndex(assignmentTypeOpp, 1);
			}
			report.updateTestLog("Verify Opportunity Edit/Clone", "Oportunity Assignment Type is changed to Consulting",
					Status.PASS);
			Utility_Functions.timeWait(1);
			Random random = new Random();
			int value = random.nextInt(999);
			Utility_Functions.xWaitForElementPresent(driver, totalSizeOpp, 3);
			if (totalSizeOpp.getText().equals("")) {
				Utility_Functions.xSendKeys(driver, totalSizeOpp, Integer.toString(value));
			}
			Utility_Functions.xWaitForElementPresent(driver, saveNewOpportunity, 3);
			Utility_Functions.xClick(driver, saveNewOpportunity, true);
			Utility_Functions.timeWait(2);
			report.updateTestLog("Verify Opportunity Edit/Clone", "Opportunity edited and saved successfully",
					Status.PASS);
			driver.navigate().refresh();
			Utility_Functions.timeWait(2);
			Utility_Functions.xSwitchtoFrame(driver, clone);
			Utility_Functions.timeWait(2);
			Utility_Functions.xWaitForElementPresent(driver, clone, 3);
			Utility_Functions.xClick(driver, clone, true);
			report.updateTestLog("Verify Opportunity Edit/Clone", "Clone button is present on Opportunity",
					Status.PASS);
			Utility_Functions.xWaitForElementPresent(driver, save, 3);
			Utility_Functions.xClick(driver, save, true);
			report.updateTestLog("Verify Opportunity Edit/Clone", "Opportunity is cloned successfully", Status.PASS);
		} else if ((dataTable.getData("General_Data", "TC_ID").contains("CMAMER"))
				|| (dataTable.getData("General_Data", "TC_ID").contains("CMEMEA"))
				|| (dataTable.getData("General_Data", "TC_ID").contains("GWSAMERManager"))
				|| (dataTable.getData("General_Data", "TC_ID").contains("VASAMERManager"))
				|| (dataTable.getData("General_Data", "TC_ID").contains("ASAMERManager"))
				|| (dataTable.getData("General_Data", "TC_ID").contains("GWSAMERBroker"))) {
			Utility_Functions.timeWait(2);
			Utility_Functions.xScrollWindowToElement(driver, estimatedGrossFeeField);
			Utility_Functions.xWaitForElementPresent(driver, estimatedGrossFeeField, 3);
			Utility_Functions.xClick(driver, estimatedGrossFeeField, true);
			if (estimatedGrossFeeField.getText().equals("10,000.00")) {
				Utility_Functions.xSendKeys(driver, estimatedGrossFeeField, "15,000.00");
			} else {
				Utility_Functions.xSendKeys(driver, estimatedGrossFeeField, "10,000.00");
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
				Utility_Functions.xWaitForElementPresent(driver, save, 3);
				Utility_Functions.xClick(driver, save, true);
				report.updateTestLog("Verify Opportunity Edit/Clone", "Opportunity is cloned successfully",
						Status.PASS);
			}
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
		Utility_Functions.xWaitForElementPresent(driver, menu_Opportunities, 3);
		Utility_Functions.xClick(driver, menu_Opportunities, true);
		Utility_Functions.xWaitForElementPresent(driver, newOpportunity, 3);
		Utility_Functions.xClick(driver, newOpportunity, true);
		Utility_Functions.timeWait(2);
		Utility_Functions.xSwitchtoFrame(driver, continueButton);
		Utility_Functions.xWaitForElementPresent(driver, continueButton, 3);
		Utility_Functions.xClick(driver, opportunityRecordType, true);
		Utility_Functions.xWaitForElementPresent(driver, opportunityRecordTypeGlobalWorkplaceSolutions, 2);
		Utility_Functions.xClick(driver, opportunityRecordTypeGlobalWorkplaceSolutions, true);
		Utility_Functions.xClick(driver, continueButton, true);
		Utility_Functions.timeWait(2);
		Utility_Functions.xSwitchtoFrame(driver, closeDateOpp);
		Utility_Functions.timeWait(2);
		String sAccountName = searchOpportunity.fetchRecord("Account", "Name");
		Utility_Functions.xSendKeys(driver, accountName, sAccountName);
		accountName.sendKeys(Keys.ARROW_DOWN);
		Utility_Functions.timeWait(2);
		accountName.sendKeys(Keys.ENTER);
		Utility_Functions.xSelectDropdownByIndex(assignmentTypeOpp, 1);
		System.out.println(Calendar.getInstance());
		DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
		Date date = new Date();
		Utility_Functions.xSelectDropdownByIndex(leadSource, 1);
		Utility_Functions.xSendKeys(driver, closeDateOpp, dateFormat.format(date).toString());
		Utility_Functions.xSendKeys(driver, closeDateOpp, Keys.TAB);
		Random random = new Random();
		int value = random.nextInt(999);
		Utility_Functions.xSendKeys(driver, totalSizeOpp, Integer.toString(value));
		Utility_Functions.xSelectDropdownByName(unitofMeasure, "Acres");
		Utility_Functions.xWaitForElementPresent(driver, estimatedGrossFee, 3);
		Utility_Functions.xSendKeys(driver, estimatedGrossFee, dataTable.getData("General_Data", "InstallmentAmount"));
		try {
			Utility_Functions.xSelectDropdownByIndex(preferredPropertyTypeOpp, 1);
		} catch (Exception e) {
			e.printStackTrace();
		}
		if (dataTable.getData("General_Data", "TC_ID").contains("GWSAPACBrokerStage01")) {
			Utility_Functions.xSelectDropdownByIndex(salesStage, 0);
		} else if (dataTable.getData("General_Data", "TC_ID").contains("GWSAPACBrokerStage02")) {
			Utility_Functions.xSelectDropdownByIndex(salesStage, 1);
		} else if (dataTable.getData("General_Data", "TC_ID").contains("GWSAPACBrokerStage03")) {
			Utility_Functions.xSelectDropdownByIndex(salesStage, 2);
		} else if (dataTable.getData("General_Data", "TC_ID").contains("GWSAPACBrokerStage04")) {
			Utility_Functions.xSelectDropdownByIndex(salesStage, 3);
		} else if (dataTable.getData("General_Data", "TC_ID").contains("GWSAPACBrokerStage05")) {
			Utility_Functions.xSelectDropdownByIndex(salesStage, 4);
		} else if (dataTable.getData("General_Data", "TC_ID").contains("GWSAPACBrokerStage06")) {
			Utility_Functions.xSelectDropdownByIndex(salesStage, 5);
		} else if (dataTable.getData("General_Data", "TC_ID").contains("GWSAPACBrokerStage07")) {
			Utility_Functions.xSelectDropdownByIndex(salesStage, 6);
		} else if (dataTable.getData("General_Data", "TC_ID").contains("GWSAPACBrokerStage08")) {
			Utility_Functions.xSelectDropdownByIndex(salesStage, 7);
		} else if (dataTable.getData("General_Data", "TC_ID").contains("GWSAPACBrokerStage09")) {
			Utility_Functions.xSelectDropdownByIndex(salesStage, 8);
		} else if (dataTable.getData("General_Data", "TC_ID").contains("GWSAPACBrokerStage10")) {
			Utility_Functions.xSelectDropdownByIndex(salesStage, 9);
		} else if (dataTable.getData("General_Data", "TC_ID").contains("GWSAPACBrokerStage11")) {
			Utility_Functions.xSelectDropdownByIndex(salesStage, 10);
		} else if (dataTable.getData("General_Data", "TC_ID").contains("GWSAPACBrokerStage12")) {
			Utility_Functions.xSelectDropdownByIndex(salesStage, 11);
		}

		Utility_Functions.xSelectDropdownByIndex(assignmentTypeOpp, 1);
		Utility_Functions.timeWait(1);
		if ((dataTable.getData("General_Data", "TC_ID").contains("GWSAPACBrokerStage09"))
				|| (dataTable.getData("General_Data", "TC_ID").contains("GWSAPACBrokerStage10"))) {
			Utility_Functions.xWaitForElementPresent(driver, viewAllFieldsButton, 5);
			Utility_Functions.xScrollWindow(driver);
			Utility_Functions.xClick(driver, viewAllFieldsButton, true);
			Utility_Functions.timeWait(1);
			Utility_Functions.xScrollWindowTop(driver);
		}
		if (dataTable.getData("General_Data", "TC_ID").contains("GWSAPACBrokerStage10")) {
			Utility_Functions.xWaitForElementPresent(driver, reasonForLossOpp, 3);
			Utility_Functions.xSelectDropdownByIndex(reasonForLossOpp, 1);
			Utility_Functions.xWaitForElementPresent(driver, reasonForLossOppText, 3);
			Utility_Functions.xSendKeys(driver, reasonForLossOppText,
					"Validating the Phase and Probaility by Selecting the Sales Stage");
			Utility_Functions.timeWait(1);
		}
		Utility_Functions.xClick(driver, saveNewOpportunity, true);
		Utility_Functions.timeWait(4);
		driver.navigate().refresh();
		Utility_Functions.timeWait(2);
		try {
			Utility_Functions.xWaitForElementPresent(driver, related, 4);
			if (related.isDisplayed()) {
				String OpportunityQuery = "Select Name from opportunity where Name like  " + "'" + sAccountName + "-"
						+ '%' + "-" + value + "-" + "Acres" + "'";
				String OpportunityName = searchOpportunity.fetchRecordFieldValue("Name", OpportunityQuery);
				report.updateTestLog("Opportunity Created",
						"Opportunity created successfully:::" + OpportunityName + ":::", Status.PASS);
			} else {
				report.updateTestLog("Opportunity Created", "Opportunity creation failed:::", Status.FAIL);
			}
		} catch (Exception e) {
			report.updateTestLog("Opportunity Related Tab", "System was unable to find the Related tab:::",
					Status.WARNING);
		}

		Utility_Functions.timeWait(2);

		String phaseQuery = "Select Phase__c from opportunity where Name like  " + "'" + sAccountName + "-" + '%' + "-"
				+ value + "-" + "Acres" + "'";
		String probabilityQuery = "Select Probability from opportunity where Name like  " + "'" + sAccountName + "-"
				+ '%' + "-" + value + "-" + "Acres" + "'";
		Utility_Functions.timeWait(1);
		String phasePopulated = searchOpportunity.fetchRecordFieldValue("Phase__c", phaseQuery);
		String probabilityPopulated = searchOpportunity.fetchRecordFieldValue("Probability", probabilityQuery);

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
						"Phase:::" + phasePopulated + ":::Probability:::" + probabilityPopulated, Status.PASS);
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
	 * Validating the APAC Offers Creation Page fields
	 * 
	 * @author Vishnuvardhan
	 *
	 */

	static ArrayList<String> OfferCreationPageAPAC = new ArrayList<String>();

	public void OfferCreationPageAPACList() {
		OfferCreationPageAPAC.add("Offer Enquiry");
		OfferCreationPageAPAC.add("Offeror Contact");
		OfferCreationPageAPAC.add("Deposit");
		OfferCreationPageAPAC.add("Offeror Account");
		OfferCreationPageAPAC.add("Offer Due Diligence Days");
		OfferCreationPageAPAC.add("Offer Campaign");
		OfferCreationPageAPAC.add("Offer Estimated Settlement Date");
		OfferCreationPageAPAC.add("Offer Date");
		OfferCreationPageAPAC.add("Source of Financing");
		OfferCreationPageAPAC.add("Offer Price");
		OfferCreationPageAPAC.add("Approvals/Condition of Sale");
		OfferCreationPageAPAC.add("Winner Offer");
		OfferCreationPageAPAC.add("Comments");
		OfferCreationPageAPAC.add("Offer Name");
		System.out.println("Offer Creation Page fields in APAC are:::" + OfferCreationPageAPAC);
	}

	public void offerCreationPageFieldsAPAC() {
		opportunityEligibility();
		Utility_Functions.xWaitForElementPresent(driver, selectNewEvent, 3);
		Utility_Functions.xClick(driver, selectNewEvent, true);
		Utility_Functions.xWaitForElementPresent(driver, createOffer, 3);
		Utility_Functions.xClick(driver, createOffer, true);
		Utility_Functions.timeWait(2);
		OfferCreationPageAPACList();
		List<WebElement> createOfferPageFieldsList = driver
				.findElements(By.xpath("//label[contains(@class,'form-element__label')]/span[1]"));
		int i1 = 0, j = 0, countLabelList = 0;
		String[] labelTexts = new String[createOfferPageFieldsList.size()];
		while (j < OfferCreationPageAPAC.size()) {
			for (WebElement element : createOfferPageFieldsList) {
				labelTexts[i1] = element.getText();
				if (labelTexts[i1].contains(OfferCreationPageAPAC.get(j))) {
					System.out.println("Verify Offer Creatiom Page Fields List" + element.getText());
					report.updateTestLog("Verify Offer Creatiom Page Fields List",
							element.getText() + "::::label is present in Offer Creation Page for APAC", Status.PASS);
					countLabelList++;
				}
				i1++;
			}
			i1 = 0;
			j++;
		}
		System.out.println("Count of labels present in Offer Creation Page are::" + countLabelList);
		if (countLabelList >= 11) {
			report.updateTestLog("Verify Offer Creatiom Page Fields List",
					"All the fields are present in Offer Creation Page for APAC", Status.PASS);
		} else {
			report.updateTestLog("Verify Offer Creatiom Page Fields List",
					"Not all the fields are present in Offer Creation Page for APAC", Status.FAIL);
		}
	}

	public void campaignsList() {
		Utility_Functions.xWaitForElementPresent(driver, menu_More, 3);
		Utility_Functions.xClick(driver, menu_More, true);
		Utility_Functions.xWaitForElementPresent(driver, campaigns, 3);
		Utility_Functions.xClick(driver, campaigns, true);
		List<WebElement> campaignsList = driver
				.findElements(By.xpath("//a[@class='slds-truncate outputLookupLink slds-truncate forceOutputLookup']"));
		if (campaignsList.isEmpty()) {
			Utility_Functions.xWaitForElementPresent(driver, recentlyViewed, 3);
			Utility_Functions.xClick(driver, recentlyViewed, true);
			Utility_Functions.xWaitForElementPresent(driver, allActiveCampaigns, 3);
			Utility_Functions.xClick(driver, allActiveCampaigns, true);
			Utility_Functions.timeWait(2);
			List<WebElement> campaignsListActive = driver.findElements(
					By.xpath("//a[@class='slds-truncate outputLookupLink slds-truncate forceOutputLookup']"));
			if (campaignsListActive.isEmpty()) {
				report.updateTestLog("Active Campaigns List", "There are no Active Campaigns present", Status.PASS);
			} else {
				Utility_Functions.xclickRandomElement(campaignsListActive);
			}
		}
		Utility_Functions.xclickRandomElement(campaignsList);
	}

	/**
	 * Validating the Offers Related List from the APAC Campaign Record
	 * 
	 * @author Vishnuvardhan
	 *
	 */
	public void offersReleatedListsCampaignAPAC() {
		campaignsList();
		Utility_Functions.timeWait(2);
		Utility_Functions.xWaitForElementPresent(driver, related, 3);
		Utility_Functions.xClick(driver, related, true);
		Utility_Functions.xScrollWindow(driver);
		Utility_Functions.timeWait(1);
		Utility_Functions.xScrollWindowTop(driver);
		Utility_Functions.timeWait(1);
		Utility_Functions.xWaitForElementPresent(driver, offersNew, 3);
		Utility_Functions.xClick(driver, offersNew, true);
		Utility_Functions.xWaitForElementPresent(driver, offersNextButton, 3);
		Utility_Functions.xClick(driver, offersNextButton, true);
		OfferCreationPageAPACList();
		Utility_Functions.timeWait(2);
		List<WebElement> createOfferPageFieldsList = driver
				.findElements(By.xpath("//label[contains(@class,'form-element__label')]/span[1]"));
		int i1 = 0, j = 0, countLabelList = 0;
		String[] labelTexts = new String[createOfferPageFieldsList.size()];
		while (j < OfferCreationPageAPAC.size()) {
			for (WebElement element : createOfferPageFieldsList) {
				labelTexts[i1] = element.getText();
				if (labelTexts[i1].contains(OfferCreationPageAPAC.get(j))) {
					System.out.println("Verify Offer Creatiom Page Fields List" + element.getText());
					report.updateTestLog("Verify Offer Creatiom Page Fields List",
							element.getText() + "::::label is present in Offer Creation Page for APAC", Status.PASS);
					countLabelList++;
				}
				i1++;
			}
			i1 = 0;
			j++;
		}
		System.out.println("Count of labels present in Offer Creation Page are::" + countLabelList);
		if (countLabelList >= 4) {
			report.updateTestLog("Verify Offer Creation Page Fields List",
					"All the fields are present in Offer Creation Page for APAC", Status.PASS);
		} else {
			report.updateTestLog("Verify Offer Creation Page Fields List",
					"Not all the fields are present in Offer Creation Page for APAC", Status.FAIL);
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
		campaignsList();
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
		Utility_Functions.xWaitForElementPresent(driver, menu_Opportunities, 3);
		Utility_Functions.xClick(driver, menu_Opportunities, true);
		Utility_Functions.xWaitForElementPresent(driver, newOpportunity, 3);
		Utility_Functions.xClick(driver, newOpportunity, true);
		Utility_Functions.timeWait(2);
		Utility_Functions.xSwitchtoFrame(driver, accountName);
		Utility_Functions.timeWait(2);
		/*String query = "SELECT EMEA_Account_Status__c, Name FROM Account where EMEA_Account_Status__c ='Active'";
		//String sAccountName = searchOpportunity.fetchRecord("Account", "Name");
		String sAccountName = searchOpportunity.fetchRecordFieldValue("Name", query);*/
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
		Utility_Functions.xWaitForElementPresent(driver, menu_Opportunities, 3);
		Utility_Functions.xClick(driver, menu_Opportunities, true);
		Utility_Functions.xWaitForElementPresent(driver, newOpportunity, 3);
		Utility_Functions.xClick(driver, newOpportunity, true);
		/*Utility_Functions.timeWait(2);
		Utility_Functions.xSwitchtoFrame(driver, continueButton);
		Utility_Functions.xWaitForElementPresent(driver, continueButton, 3);
		Utility_Functions.xWaitForElementPresent(driver, opportunityRecordTypeBCP, 3);
		Utility_Functions.xClick(driver, opportunityRecordTypeBCP, true);
		Utility_Functions.xClick(driver, continueButton, true);*/
		Utility_Functions.xSwitchtoFrame(driver, accountName);
		Utility_Functions.timeWait(2);
		OpportunityTypePickListValues();
		Utility_Functions.timeWait(2);
		List<WebElement> OpportunityTypePickList = driver.findElements(By.xpath("//label[text()='Opportunity Type']/parent::div/div[@class='slds-form-element__control']/select/option"));
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
			report.updateTestLog("Verify Opportunity Type Pick List",
					"Opportunity Type Pick List values are present", Status.PASS);
		} else {
			report.updateTestLog("Verify Opportunity Type Pick List",
					"Opportunity Type Pick List values are not present", Status.FAIL);
		}
	}

	/**
	 * Validating the update on existing fields in VAS Opportunity Record layout
	 * 
	 * @author Vishnuvardhan
	 *
	 */

	static ArrayList<String> competitorsListValues = new ArrayList<String>();

	public void competitorsListValues() {		
		competitorsListValues.add("AEI");
		competitorsListValues.add("ATC");
		competitorsListValues.add("BBG");
		competitorsListValues.add("Colliers");
		competitorsListValues.add("Cushman & Wakefield");
		competitorsListValues.add("EBI");
		competitorsListValues.add("EMG");
		competitorsListValues.add("GRS");
		competitorsListValues.add("Integra");
		competitorsListValues.add("Marx Okubo");
		competitorsListValues.add("Newmark");
		competitorsListValues.add("NPV");
		competitorsListValues.add("Other");
		competitorsListValues.add("Partner Engineering");
		competitorsListValues.add("Pond Robinson");
		competitorsListValues.add("Terracon");
		competitorsListValues.add("Valbridge");
		System.out.println("Competitors List Values are:::" + competitorsListValues);
	}

	static ArrayList<String> regionListValues = new ArrayList<String>();

	public void regionList() {		
		regionListValues.add("--None--");
		regionListValues.add("US National");
		regionListValues.add("US Southeast");
		regionListValues.add("US West");
		regionListValues.add("US Northeast");
		System.out.println("Region Values are:::" + regionListValues);
	}

	static ArrayList<String> scopeWonValues = new ArrayList<String>();

	public void scopeWon() {		
		scopeWonValues.add("Appraisal");
		scopeWonValues.add("Environment");
		scopeWonValues.add("Facility Assessment");
		scopeWonValues.add("Property Condition");
		scopeWonValues.add("Telecom");
		System.out.println("Scope Won List Values are:::" + scopeWonValues);
	}

	static ArrayList<String> scopeLostValues = new ArrayList<String>();

	public void scopeLost() {		
		scopeLostValues.add("Appraisal");
		scopeLostValues.add("Environment");
		scopeLostValues.add("Facility Assessment");
		scopeLostValues.add("Property Condition");
		scopeLostValues.add("Telecom");
		System.out.println("Scope Lost List Values are:::" + scopeLostValues);
	}

	public void opportunityRecordLayoutVAS() {
		Utility_Functions.xWaitForElementPresent(driver, menu_Opportunities, 3);
		Utility_Functions.xClick(driver, menu_Opportunities, true);
		Utility_Functions.xWaitForElementPresent(driver, newOpportunity, 3);
		Utility_Functions.xClick(driver, newOpportunity, true);
		Utility_Functions.timeWait(2);
/*		Utility_Functions.xSwitchtoFrame(driver, continueButton);
		Utility_Functions.xWaitForElementPresent(driver, continueButton, 3);
		Utility_Functions.xClick(driver, continueButton, true);
		driver.switchTo().defaultContent();*/
		Utility_Functions.xWaitForElementPresent(driver, unitOfMeasureDefaultValue, 3);
		if(unitOfMeasureDefaultValue.getText().equals("Assets")) {
			report.updateTestLog("Verify Unit of Measure", "Unit of Mesaure default value is populated as:::" + unitOfMeasureDefaultValue.getText(), Status.PASS);
		} else {
			report.updateTestLog("Verify Unit of Measure", "Unit of Mesaure default value is not populated as Assets", Status.FAIL);
		}
		competitorsListValues();
		List<WebElement> competitors = driver.findElements(By.xpath("//span[contains(text(),'Pitch Competitors')]/parent::label/parent::div//select/option"));
		int i1 = 0, j = 0, countLabelList = 0;
		String[] labelTexts = new String[competitors.size()];
		while (j < competitors.size()) {
			for (WebElement element : competitors) {
				labelTexts[i1] = element.getText();
				if (labelTexts[i1].contains(competitorsListValues.get(j))) {
					System.out.println("Verify Competitors List Values:::" + element.getText());
					report.updateTestLog("Verify Competitors List Values", element.getText() + "::::Competitors List Value is present", Status.PASS);
					countLabelList++;
				}
				i1++;
			}
			i1 = 0;
			j++;
		}
		System.out.println("Count of labels present in Opportunity Type Pick List are ::" + countLabelList);
		if (countLabelList >= 17) {
			report.updateTestLog("Verify Competitors List Values", "Competitors List values are present", Status.PASS);
		} else {
			report.updateTestLog("Verify Competitors List Values", "Competitors List values are not present", Status.FAIL);
		}
		Utility_Functions.xWaitForElementPresent(driver, regionMenu, 3);
		Utility_Functions.xClick(driver, regionMenu, true);
		regionList();
		List<WebElement> regionListElement = driver.findElements(By.xpath("//li[contains(@class,'uiMenuItem')]//a"));
		int i2 = 0, j1 = 0, countLabelList1 = 0;
		String[] labelTexts1 = new String[regionListElement.size()];
		while (j1 < regionListElement.size()) {
			for (WebElement element : regionListElement) {
				labelTexts1[i2] = element.getText();
				if (labelTexts1[i2].contains(regionListValues.get(j1))) {
					System.out.println("Verify Region List Values:::" + element.getText());
					report.updateTestLog("Verify Region List Values", element.getText() + "::::Region List Value is present", Status.PASS);
					countLabelList1++;
				}
				i2++;
			}
			i2 = 0;
			j1++;
		}
		System.out.println("Count of labels present in Region List values are ::" + countLabelList1);
		if (countLabelList1 == 5) {
			report.updateTestLog("Verify Region List Values", "Region List values are present", Status.PASS);
		} else {
			report.updateTestLog("Verify REgion List Values", "Region List values are not present", Status.FAIL);
		}		
		scopeWon();
		List<WebElement> scopeWonListValues = driver.findElements(By.xpath("//span[text()='Scope Won']/parent::label/parent::div//select/option"));
		int i3 = 0, j2 = 0, countLabelList2 = 0;
		String[] labelTexts2 = new String[scopeWonListValues.size()];
		while (j2 < scopeWonListValues.size()) {
			for (WebElement element : scopeWonListValues) {
				labelTexts2[i3] = element.getText();
				if (labelTexts2[i3].contains(scopeWonValues.get(j2))) {
					System.out.println("Verify Scope Won Values:::" + element.getText());
					report.updateTestLog("Verify Scope Won Values", element.getText() + "::::Scope Won List Value is present", Status.PASS);
					countLabelList2++;
				}
				i3++;
			}
			i3 = 0;
			j2++;
		}
		System.out.println("Count of labels present in Scope Won List values are ::" + countLabelList2);
		if (countLabelList2 == 5) {
			report.updateTestLog("Verify Scope Won List Values", "Scope Won List values are present", Status.PASS);
		} else {
			report.updateTestLog("Verify Scope Won List Values", "Scope Won List values are not present", Status.FAIL);
		}		
		scopeLost();
		List<WebElement> scopeLostListValues = driver.findElements(By.xpath("//span[text()='Scope Lost']/parent::label/parent::div//select/option"));
		int i4 = 0, j3 = 0, countLabelList3 = 0;
		String[] labelTexts3 = new String[scopeLostListValues.size()];
		while (j3 < scopeLostListValues.size()) {
			for (WebElement element : scopeLostListValues) {
				labelTexts3[i4] = element.getText();
				if (labelTexts3[i4].contains(scopeLostValues.get(j3))) {
					System.out.println("Verify Scope Lost Values:::" + element.getText());
					report.updateTestLog("Verify Scope Lost Values", element.getText() + "::::Scope Lost List Value is present", Status.PASS);
					countLabelList3++;
				}
				i4++;
			}
			i4 = 0;
			j3++;
		}
		System.out.println("Count of labels present in Scope Lost List values are ::" + countLabelList3);
		if (countLabelList3 == 5) {
			report.updateTestLog("Verify Scope Lost List Values", "Scope Lost List values are present", Status.PASS);
		} else {
			report.updateTestLog("Verify Scope Lost List Values", "Scope Lost List values are not present", Status.FAIL);
		}
	}
	/**
	 * Validating the Opportunity Calculated Annual Leasing Commission
	 * 
	 * @author Ramya
	 * 
	 *
	 */
	public void opportunityCalculateAnnualLeasingCommission(){	
		Utility_Functions.xWaitForElementPresent(driver, menu_Opportunities, 3);
		Utility_Functions.xClick(driver, menu_Opportunities, true);
		Utility_Functions.xWaitForElementPresent(driver, newOpportunity, 3);
		Utility_Functions.xClick(driver, newOpportunity, true);
		Utility_Functions.timeWait(2);
		Utility_Functions.xWaitForElementPresent(driver,opportunityNameAS, 3);
		Utility_Functions.xSendKeys(driver,opportunityNameAS, "Test Automation Opportunity_" + Utility_Functions.xGenerateAlphaNumericString());
		Utility_Functions.xWaitForElementPresent(driver,searchAccountsNewOpportunity, 3);
		Utility_Functions.xSendKeys(driver,searchAccountsNewOpportunity, "Test Account APAC");
		Utility_Functions.xWaitForElementPresent(driver,accountValue, 3);
		Utility_Functions.xClick(driver,accountValue, true);
		Utility_Functions.xWaitForElementPresent(driver,totalSizeAS, 3);
		Utility_Functions.xSendKeys(driver,totalSizeAS, "2,000.00");
		Utility_Functions.xWaitForElementPresent(driver,regionAS, 3);
		Utility_Functions.xClick(driver,regionAS, true);
		Utility_Functions.xWaitForElementPresent(driver,regionValueAS, 3);
		Utility_Functions.xClick(driver,regionValueAS, true);
		Utility_Functions.xWaitForElementPresent(driver,marketValue, 3);
		Utility_Functions.xClick(driver,marketValue, true);
		Utility_Functions.xWaitForElementPresent(driver,leasingAS, 3);
		Utility_Functions.xClick(driver,leasingAS, true);
		Utility_Functions.xWaitForElementPresent(driver,valueAS, 3);
		Utility_Functions.xClick(driver,valueAS, true);
		Utility_Functions.xWaitForElementPresent(driver,consultancyAS, 3);
		Utility_Functions.xClick(driver,consultancyAS, true);
		Utility_Functions.xWaitForElementPresent(driver,valueAS, 3);
		Utility_Functions.xClick(driver,valueAS, true);
		Utility_Functions.timeWait(2);



	}
	/**
	 * Validating the Opportunity Calculated Annual Leasing Commission
	 * 
	 * @author Ramya
	 * 
	 *
	 */
	public void opportunityCloseInformationSection(){	
		Utility_Functions.xWaitForElementPresent(driver, menu_Opportunities, 3);
		Utility_Functions.xClick(driver, menu_Opportunities, true);
		Utility_Functions.xWaitForElementPresent(driver, newOpportunity, 3);
		Utility_Functions.xClick(driver, newOpportunity, true);
		Utility_Functions.timeWait(2);
		Utility_Functions.xSwitchtoFrame(driver, viewAllFieldsButton);
		Utility_Functions.xWaitForElementPresent(driver, viewAllFieldsButton, 5);
		Utility_Functions.xClick(driver,viewAllFieldsButton, true);
		Utility_Functions.timeWait(5);
		if((leasePeriodNewOpportunity.isDisplayed()) && (otherIncentivesNewOpportunity.isDisplayed())&& (landlordTenantAct.isDisplayed())) {

			report.updateTestLog("Verify Opportunity Close Information Section", "The lease period, other Incentives and Landlord Tenant act are present in the new Opportunity Page", Status.PASS);
		} else {
			report.updateTestLog("Verify Opportunity Close Information Section", "The lease period, other Incentives and Landlord Tenant act arenot present in the new Opportunity Page", Status.FAIL);
		}
		Utility_Functions.xWaitForElementPresent(driver,opportunityName, 3);
		Utility_Functions.xSendKeys(driver, opportunityName, "Test Automation Opportunity_" + Utility_Functions.xGenerateAlphaNumericString());
		String query = "SELECT Id, Name, EMEA_Searchable__c FROM Account where EMEA_Searchable__c = true limit 1 offset 9";
		String sAccountName = searchOpportunity.fetchRecordFieldValue("Name", query);
		Utility_Functions.xSendKeys(driver, accountName, sAccountName);
		accountName.sendKeys(Keys.ARROW_DOWN);
		Utility_Functions.timeWait(2);
		accountName.sendKeys(Keys.ENTER);
		Utility_Functions.timeWait(2);
		Utility_Functions.xWaitForElementPresent(driver,salesStageEMEANewOpportunity, 4);
		Utility_Functions.xClick(driver,salesStageEMEANewOpportunity, true);
		Utility_Functions.xWaitForElementPresent(driver,salesStageEMEANewOpportunityValue, 4);
		Utility_Functions.xClick(driver,salesStageEMEANewOpportunityValue, true);
		Utility_Functions.xWaitForElementPresent(driver,estimatedGrossFeeNewOpportunity, 5);
		Utility_Functions.xSendKeys(driver,estimatedGrossFeeNewOpportunity, dataTable.getData("General_Data", "InstallmentAmount"));
		System.out.println(Calendar.getInstance());
		DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
		Date date = new Date();
		Utility_Functions.xWaitForElementPresent(driver,closeDateNewOpportunity, 3);
		Utility_Functions.xSendKeys(driver,closeDateNewOpportunity, dateFormat.format(date).toString());
		Utility_Functions.xWaitForElementPresent(driver,saveOpportunitySplitUAT, 4);
		Utility_Functions.xClick(driver,saveOpportunitySplitUAT, true);
		Utility_Functions.timeWait(2);
		driver.switchTo().defaultContent();
		Utility_Functions.timeWait(2);
		Utility_Functions.xWaitForElementPresent(driver,editOpportunity, 4);
		Utility_Functions.xClick(driver,editOpportunity, true);
		Utility_Functions.timeWait(2);
		Utility_Functions.xWaitForElementPresent(driver,cbreMarketGroupEMEA, 4);
		Utility_Functions.xClick(driver,cbreMarketGroupEMEA, true);
		Utility_Functions.xWaitForElementPresent(driver,cbreMarketGroupEMEAValue, 4);
		Utility_Functions.xClick(driver,cbreMarketGroupEMEAValue, true);
		Utility_Functions.xWaitForElementPresent(driver,netFeeOpportunityEdit, 5);
		Utility_Functions.xSendKeys(driver,netFeeOpportunityEdit, dataTable.getData("General_Data", "InstallmentAmount"));
		Utility_Functions.timeWait(2);
		Utility_Functions.xScrollWindow(driver);
		Utility_Functions.timeWait(2);
		Utility_Functions.xScrollWindowTop(driver);
		Utility_Functions.timeWait(2);
		Utility_Functions.xWaitForElementPresent(driver,salesStageEditOpp, 4);
		Utility_Functions.xClick(driver,salesStageEditOpp, true);
		Utility_Functions.xWaitForElementPresent(driver,salesStageEditOpportunityValue, 4);
		Utility_Functions.xClick(driver,salesStageEditOpportunityValue, true);
		Utility_Functions.xWaitForElementPresent(driver,totalSizeEditOpp, 5);
		Utility_Functions.xSendKeys(driver,totalSizeEditOpp, dataTable.getData("General_Data", "InstallmentAmount"));
		Utility_Functions.xWaitForElementPresent(driver,emeaConversionType, 4);
		Utility_Functions.xClick(driver,emeaConversionType, true);
		Utility_Functions.xWaitForElementPresent(driver,emeaConversionTypeValue, 4);
		Utility_Functions.timeWait(1);
		Utility_Functions.xClick(driver,emeaConversionTypeValue, true);
		System.out.println(Calendar.getInstance());
		DateFormat dateFormat1 = new SimpleDateFormat("MM/dd/yyyy");
		Date date1 = new Date();
		Utility_Functions.xWaitForElementPresent(driver,pitchDate, 3);
		Utility_Functions.xSendKeys(driver,pitchDate, dateFormat1.format(date1).toString());
		Utility_Functions.xWaitForElementPresent(driver,saveEditOpp, 4);
		Utility_Functions.xClick(driver,saveEditOpp, true);
		Utility_Functions.timeWait(3);
		if(details.isDisplayed()) {

			report.updateTestLog("Verify Quick Create Opportunity Page Discretionary Fee", "The opportunity is saved with the Discretionary Fee check box checked and the Discretionary amount ", Status.PASS);
		} else {
			report.updateTestLog("Verify Quick Create Opportunity Page Discretionary Fee", "The opportunity is not saved with the Discretionary Fee check box checked and the Discretionary amount", Status.FAIL);
		}


	}
	/**
	 * Validating the Opportunity create offer quick action drop down
	 * 
	 * @author Ramya
	 * 
	 *
	 */
	public void createOfferOpportunityPage(){	
		Utility_Functions.xWaitForElementPresent(driver, menu_Opportunities, 3);
		Utility_Functions.xClick(driver, menu_Opportunities, true);
		Utility_Functions.xWaitForElementPresent(driver, newOpportunity, 3);
		Utility_Functions.xClick(driver, newOpportunity, true);
		Utility_Functions.timeWait(2);
		Utility_Functions.xSwitchtoFrame(driver, continueButton);
		Utility_Functions.xWaitForElementPresent(driver, continueButton, 3);
		Utility_Functions.xClick(driver,continueButton, true);
		Utility_Functions.timeWait(2);
		driver.switchTo().defaultContent();
		Utility_Functions.timeWait(2);
		Utility_Functions.xWaitForElementPresent(driver, targetProperty, 3);
		//String targetPropertyName = searchOpportunity.fetchRecord("Property__c ", "Name");
		//Utility_Functions.xSendKeys(driver,targetProperty, targetPropertyName);
		//Utility_Functions.timeWait(1);
		WebElement firstLookupElement = driver.findElement(By.cssSelector("ul>li.forceSearchInputLookupDesktopOption:nth-child(1)"));
		Utility_Functions.xWaitForElementPresent(driver, firstLookupElement, 3);
		Utility_Functions.xClick(driver,firstLookupElement, true);
		Utility_Functions.xSendKeys(driver,opportunityNameAS, "Test Automation Opportunity_" + Utility_Functions.xGenerateAlphaNumericString());
		Utility_Functions.xWaitForElementPresent(driver,accountNameNewOpportunity, 3);
		Utility_Functions.xClick(driver, accountNameNewOpportunity, true);
		/*String accountName = searchOpportunity.fetchRecord("Account", "Name");
		Utility_Functions.xSendKeys(driver,accountNameNewOpportunity, accountName);*/
		WebElement firstLookupAccount = driver.findElement(By.cssSelector("ul>li.forceSearchInputLookupDesktopOption:nth-child(1)"));
		Utility_Functions.xWaitForElementPresent(driver, firstLookupAccount, 3);
		Utility_Functions.xClick(driver,firstLookupAccount, true);
		Utility_Functions.xWaitForElementPresent(driver,leadSourceNewOpp, 3);
		Utility_Functions.xClick(driver,leadSourceNewOpp, true);
		Utility_Functions.xWaitForElementPresent(driver,leadSourceNewOppValue, 3);
		Utility_Functions.xClick(driver,leadSourceNewOppValue, true);
		System.out.println(Calendar.getInstance());
		DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
		Date date = new Date();
		Utility_Functions.xWaitForElementPresent(driver,closeDate_AS, 3);
		Utility_Functions.xSendKeys(driver,closeDate_AS, dateFormat.format(date).toString());
		Utility_Functions.xWaitForElementPresent(driver,estiamtedGrossFeeCommissionValue, 5);
		Utility_Functions.xSendKeys(driver,estiamtedGrossFeeCommissionValue, dataTable.getData("General_Data", "InstallmentAmount"));
		Utility_Functions.xWaitForElementPresent(driver,estimatedTransactionValue, 5);
		Utility_Functions.xSendKeys(driver,estimatedTransactionValue, dataTable.getData("General_Data", "InstallmentAmount"));
		Utility_Functions.xWaitForElementPresent(driver,saveNewOpportunity_AS, 3);
		Utility_Functions.xClick(driver,saveNewOpportunity_AS, true);
		Utility_Functions.timeWait(5);
		Utility_Functions.xWaitForElementPresent(driver,showMoreActions, 3);
		Utility_Functions.xClick(driver,showMoreActions, true);
		Utility_Functions.xWaitForElementPresent(driver,createOffer, 3);
		Utility_Functions.xClick(driver,createOffer, true);
		Utility_Functions.xWaitForElementPresent(driver,offerorAccount, 3);
		Utility_Functions.xSendKeys(driver,offerorAccount, "Test Automation 0100");
		Utility_Functions.xWaitForElementPresent(driver,offerorAccountName, 3);
		Utility_Functions.xClick(driver,offerorAccountName, true);
		Utility_Functions.xWaitForElementPresent(driver,offerorContact, 3);
		Utility_Functions.xSendKeys(driver,offerorContact, "Test Automation 0100");
		Utility_Functions.xWaitForElementPresent(driver,offerorContactName, 3);
		Utility_Functions.xClick(driver,offerorContactName, true);
		Utility_Functions.xWaitForElementPresent(driver,offerPrice, 5);
		Utility_Functions.xSendKeys(driver,offerPrice, dataTable.getData("General_Data", "InstallmentAmount"));
		Utility_Functions.xWaitForElementPresent(driver,createOfferSave, 5);
		Utility_Functions.xClick(driver,createOfferSave, true);
		Utility_Functions.timeWait(2);
		if(details.isDisplayed()) {

			report.updateTestLog("Verify Create Offer from Opportunity", "The offer is saved with the mandatory fields ", Status.PASS);
		} else {
			report.updateTestLog("Verify Create Offer from Opportunity", "The offer is not saved with the mandatory fields", Status.FAIL);
		}
			
	}
	/**
	 * Validating the Opportunities create new installment 
	 * 
	 * @author Ramya
	 *
	 */

	public void opportunitiesClosedDateAndInstallmentDate() {
		Utility_Functions.xWaitForElementPresent(driver,menu_Opportunities, 4);
		Utility_Functions.xClick(driver, menu_Opportunities, true);
		Utility_Functions.xWaitForElementPresent(driver, newOpportunity, 3);
		Utility_Functions.xClick(driver, newOpportunity, true);
		try {
			Utility_Functions.timeWait(2);
			Utility_Functions.xSwitchtoFrame(driver, continueButton);
			Utility_Functions.xWaitForElementPresent(driver, continueButton, 3);
			Utility_Functions.xClick(driver,continueButton, true);
			Utility_Functions.timeWait(2);
		} catch (Exception e1) {
			e1.printStackTrace();
		}
		Utility_Functions.xSwitchtoFrame(driver, viewAllFieldsButton);
		Utility_Functions.xWaitForElementPresent(driver, viewAllFieldsButton, 5);
		Utility_Functions.xClick(driver,viewAllFieldsButton, true);
		Utility_Functions.timeWait(5);
		Utility_Functions.xWaitForElementPresent(driver,opportunityName, 3);
		Utility_Functions.xSendKeys(driver, opportunityName, "Test Automation Opportunity_" + Utility_Functions.xGenerateAlphaNumericString());
		String query = "SELECT Id, Name, EMEA_Searchable__c FROM Account where EMEA_Searchable__c = true limit 1 offset 9";
		String sAccountName = searchOpportunity.fetchRecordFieldValue("Name", query);
		Utility_Functions.xSendKeys(driver, accountName, sAccountName);
		accountName.sendKeys(Keys.ARROW_DOWN);
		Utility_Functions.timeWait(2);
		accountName.sendKeys(Keys.ENTER);
		Utility_Functions.timeWait(2);
		Utility_Functions.xWaitForElementPresent(driver,salesStageEMEANewOpportunity, 4);
		Utility_Functions.xClick(driver,salesStageEMEANewOpportunity, true);
		Utility_Functions.xWaitForElementPresent(driver,salesStageEMEANewOpportunityValue, 4);
		Utility_Functions.xClick(driver,salesStageEMEANewOpportunityValue, true);
		Utility_Functions.xWaitForElementPresent(driver,estimatedGrossFeeNewOpportunity, 5);
		Utility_Functions.xSendKeys(driver,estimatedGrossFeeNewOpportunity, dataTable.getData("General_Data", "InstallmentAmount"));
		System.out.println(Calendar.getInstance());
		DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
		Date date = new Date();
		Utility_Functions.xWaitForElementPresent(driver,closeDateNewOpportunity, 3);
		Utility_Functions.xSendKeys(driver,closeDateNewOpportunity, dateFormat.format(date).toString());
		Utility_Functions.xWaitForElementPresent(driver,saveOpportunitySplitUAT, 4);
		Utility_Functions.xClick(driver,saveOpportunitySplitUAT, true);
		Utility_Functions.timeWait(2);
		driver.switchTo().defaultContent();
		Utility_Functions.timeWait(2);
		Utility_Functions.xWaitForElementPresent(driver,editOpportunity, 4);
		Utility_Functions.xClick(driver,editOpportunity, true);
		Utility_Functions.timeWait(2);
		Utility_Functions.xScrollWindow(driver);
		Utility_Functions.timeWait(2);
		Utility_Functions.xScrollWindowTop(driver);
		Utility_Functions.timeWait(2);
		try{
			System.out.println(Calendar.getInstance());
			DateFormat dateFormat1 = new SimpleDateFormat("MM/dd/yyyy");
			Date date1 = new Date();
			Utility_Functions.xWaitForElementPresent(driver,installmentDateEditOpp, 3);
			Utility_Functions.xSendKeys(driver,installmentDateEditOpp, dateFormat1.format(date1).toString());
		}catch(Exception e){
			System.out.println("Installment Date is not user editable");
		}

	}
	/**
	 * Validating the Opportunity Quick create page for Property sales sell side opportunity record type
	 * 
	 * @author Ramya
	 * 
	 *
	 */
	static ArrayList<String> propertyDetailsSectionFields = new ArrayList<String>();

	public void propertyDetailsFields() {	

		propertyDetailsSectionFields.add("Target Property");
		propertyDetailsSectionFields.add("Total Size");
		propertyDetailsSectionFields.add("Opportunity Details");

		System.out.println("Property Details fields are:::" + propertyDetailsSectionFields);
	}
	static ArrayList<String> opportunityInformationSectionFields = new ArrayList<String>();

	public void opportunityInformationSection() {	

		opportunityInformationSectionFields.add("Opportunity Name");
		opportunityInformationSectionFields.add("Account Name");
		opportunityInformationSectionFields.add("Primary Contact");
		opportunityInformationSectionFields.add("Close Date");
		opportunityInformationSectionFields.add("Confidential Opportunity");
		opportunityInformationSectionFields.add("Status Comments");
		opportunityInformationSectionFields.add("HNI Transaction");
		opportunityInformationSectionFields.add("Parent Opportunity");
		opportunityInformationSectionFields.add("Core Asset Transaction");

		System.out.println("Opportunity Information section fields are:::" + opportunityInformationSectionFields);
	}
	static ArrayList<String> financialDetailsSectionFields = new ArrayList<String>();

	public void financialDetailsSection() {	

		financialDetailsSectionFields.add("Estimated Gross Fee/Commission");
		financialDetailsSectionFields.add("Sales Stage");
		financialDetailsSectionFields.add("Estimated Transaction Value");
		financialDetailsSectionFields.add("Probability (%)");
		financialDetailsSectionFields.add("On Hold");
		financialDetailsSectionFields.add("On Hold Comments");

		System.out.println("Financial Details section fields are:::" + financialDetailsSectionFields);
	}
	static ArrayList<String> appointmentInformationSectionFields = new ArrayList<String>();

	public void appointmentInformationFields() {	

		appointmentInformationSectionFields.add("Agency Start Date");
		appointmentInformationSectionFields.add("Agency Expiry Date");

		System.out.println("Appointment Information fields are:::" + appointmentInformationSectionFields);
	}
	static ArrayList<String> closeInformationSectionFields = new ArrayList<String>();

	public void closeInformationFields() {	

		closeInformationSectionFields.add("Counterpart Account");
		closeInformationSectionFields.add("Yield (%)");
		closeInformationSectionFields.add("Counterpart Contact");
		closeInformationSectionFields.add("Exchanged/ Agreement Signed Date");
		closeInformationSectionFields.add("Close Comments");
		closeInformationSectionFields.add("Settlement/Completion Date");
		closeInformationSectionFields.add("Annual Net Operating Income");
		closeInformationSectionFields.add("Buyer Confidentiality Agreement Signed");
		closeInformationSectionFields.add("Stake Diluted (%)");

		System.out.println("Close Information section fields are:::" +closeInformationSectionFields);
	}

	static ArrayList<String> lossInformationSectionFields = new ArrayList<String>();

	public void lossInformationSectionFields() {	

		lossInformationSectionFields.add("Competitor");
		lossInformationSectionFields.add("Reason Lost Comments");

		System.out.println("loss information fields are:::" +lossInformationSectionFields);
	}
	static ArrayList<String> systemInformationSectionFields = new ArrayList<String>();

	public void systemInformationSectionFields() {	

		systemInformationSectionFields.add("Last Manually Modified By");
		systemInformationSectionFields.add("Change Opportunity Owner");

		System.out.println("System information fields are:::" +systemInformationSectionFields);
	}
	public void validateOpportunityQuickCreatePage(){	
		Utility_Functions.xWaitForElementPresent(driver, menu_Opportunities, 3);
		Utility_Functions.xClick(driver, menu_Opportunities, true);
		Utility_Functions.xWaitForElementPresent(driver, newOpportunity, 3);
		Utility_Functions.xClick(driver, newOpportunity, true);
		Utility_Functions.timeWait(2);
		Utility_Functions.xSwitchtoFrame(driver, continueButton);
		Utility_Functions.xWaitForElementPresent(driver, continueButton, 3);
		Utility_Functions.xClick(driver,continueButton, true);
		Utility_Functions.timeWait(2);
		driver.switchTo().defaultContent();
		Utility_Functions.timeWait(2);
		List<WebElement> propertyDetailsFields = driver.findElements(By.xpath("//span[text()='Property Details']/parent::h3/following-sibling::div//div[contains(@class,'slds-form-element__control')]//label/span[1]"));
		int count1 = 0, i1 = 0, j1 = 0;
		String fieldsArray[] = new String[propertyDetailsFields.size()];
		System.out.println(propertyDetailsFields.size());
		try {
			propertyDetailsFields();
			while (j1 < propertyDetailsFields.size()) {
				for (WebElement element1 : propertyDetailsFields) {
					fieldsArray[i1] = element1.getText();
					if (fieldsArray[i1].equalsIgnoreCase(propertyDetailsSectionFields.get(j1))) {
						System.out.println("Verify Property Details Section " + element1.getText());
						report.updateTestLog("Verify Property Details Section ",
								element1.getText() + "labels  present in the Property Details Section ", Status.PASS);
						count1++;
					}
					i1++;
				}
				i1 = 0;
				j1++;
			}
			System.out.println(count1);
			if (count1 != 3) {
				report.updateTestLog("Verify Property Details Section",
						"All fields are not present in the Property Details Section", Status.FAIL);
			} else {
				report.updateTestLog("Verify Property Details Section",
						"All fields are present in the Property Details Section", Status.PASS);
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		List<WebElement> opportunityInformationFields = driver.findElements(By.xpath("//span[text()='Opportunity Information']/parent::h3/following-sibling::div//div[contains(@class,'slds-form-element__control')]//label/span[1]"));
		int count2 = 0, i2 = 0, j2 = 0;
		String fieldsArray2[] = new String[opportunityInformationFields.size()];
		System.out.println(opportunityInformationFields.size());
		try {
			opportunityInformationSection();
			while (j2 < opportunityInformationFields.size()) {
				for (WebElement element2 :opportunityInformationFields) {
					fieldsArray2[i2] = element2.getText();
					if (fieldsArray2[i2].equalsIgnoreCase(opportunityInformationSectionFields.get(j2))) {
						System.out.println("Verify Opportunity Information Section " + element2.getText());
						report.updateTestLog("Verify Opportunity Information Section",
								element2.getText() + "labels  present in the Opportunity Information Section ", Status.PASS);
						count2++;
					}
					i2++;
				}
				i2 = 0;
				j2++;
			}
			System.out.println(count2);
			if (count2 != 9) {
				report.updateTestLog("Verify Opportunity Information Section",
						"All fields are not present in the Opportunity Information Section", Status.FAIL);
			} else {
				report.updateTestLog("Verify Property Details Section",
						"All fields are present in the Opportunity Information Section", Status.PASS);
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		List<WebElement> financialDetailsStageFields = driver.findElements(By.xpath("//span[text()='Financial Details/Sales Stages']/parent::h3/following-sibling::div//div[contains(@class,'slds-form-element__control')]//label/span[1]"));
		int count3 = 0, i3 = 0, j3 = 0;
		String fieldsArray3[] = new String[financialDetailsStageFields.size()];
		System.out.println(financialDetailsStageFields .size());
		try {
			financialDetailsSection();
			while (j3 < financialDetailsStageFields.size()) {
				for (WebElement element3 :financialDetailsStageFields ) {
					fieldsArray3[i3] = element3.getText();
					if (fieldsArray3[i3].equalsIgnoreCase(financialDetailsSectionFields.get(j3))) {
						System.out.println("Verify Financial Details Section Fields " + element3.getText());
						report.updateTestLog("Verify Financial Details Section Fields",
								element3.getText() + "labels  present in the Financial Details Section ", Status.PASS);
						count3++;
					}
					i3++;
				}
				i3 = 0;
				j3++;
			}
			System.out.println(count3);
			if (count3 != 6) {
				report.updateTestLog("Verify Financial Details Section",
						"All fields are not present in the Opportunity Information Section", Status.FAIL);
			} else {
				report.updateTestLog("Verify Financial Details Section",
						"All fields are present in the Opportunity Information Section", Status.PASS);
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}	

		List<WebElement> appointmentInformationFields = driver.findElements(By.xpath("//span[contains(text(),'Appointment Information')]/parent::h3/following-sibling::div//div[contains(@class,'slds-form-element__control')]//label/span[1]"));
		int count4 = 0, i4 = 0, j4 = 0;
		String fieldsArray4[] = new String[appointmentInformationFields.size()];
		System.out.println(appointmentInformationFields.size());
		try {
			appointmentInformationFields();
			while (j4 < appointmentInformationFields.size()) {
				for (WebElement element4 :appointmentInformationFields) {
					fieldsArray4[i4] = element4.getText();
					if (fieldsArray4[i4].equalsIgnoreCase(appointmentInformationSectionFields.get(j4))) {
						System.out.println("Verify Appointment Information Section " + element4.getText());
						report.updateTestLog("Verify Appointment Information Section",
								element4.getText() + "labels  present in the Appointment Information Section ", Status.PASS);
						count4++;
					}
					i4++;
				}
				i4 = 0;
				j4++;
			}
			System.out.println(count4);
			if (count4 != 2) {
				report.updateTestLog("Verify Appointment Information Section",
						"All fields are not present in the Appointment Information Section", Status.FAIL);
			} else {
				report.updateTestLog("Verify Appointment Information Section",
						"All fields are present in the Appointment Information Section", Status.PASS);
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}	

		List<WebElement> closeInformationFields = driver.findElements(By.xpath("//span[contains(text(),'Close Information')]/parent::h3/following-sibling::div//div[contains(@class,'slds-form-element__control')]//label/span[1]"));
		int count5 = 0, i5 = 0, j5 = 0;
		String fieldsArray5[] = new String[closeInformationFields.size()];
		System.out.println(closeInformationFields.size());
		try {
			closeInformationFields();
			while (j5 <closeInformationFields.size()) {
				for (WebElement element5 :closeInformationFields) {
					fieldsArray5[i5] = element5.getText();
					if (fieldsArray5[i5].equalsIgnoreCase(closeInformationSectionFields.get(j5))) {
						System.out.println("Verify Close Information Section " + element5.getText());
						report.updateTestLog("Verify Close Information Section",
								element5.getText() + "labels  present in the Close Information Section ", Status.PASS);
						count5++;
					}
					i5++;
				}
				i5 = 0;
				j5++;
			}
			System.out.println(count5);
			if (count5 >= 8) {
				report.updateTestLog("Verify Close Information Section",
						"All fields are present in the Close Information Section", Status.PASS);
			} else {
				report.updateTestLog("Verify Close Information Section",
						"All fields are not present in the Close Information Section", Status.FAIL);
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}	

		List<WebElement> lossInformationFields = driver.findElements(By.xpath("//span[contains(text(),'Loss Information')]/parent::h3/following-sibling::div//div[contains(@class,'slds-form-element__control')]//label/span[1]"));
		int count6 = 0, i6 = 0, j6 = 0;
		String fieldsArray6[] = new String[lossInformationFields.size()];
		System.out.println(lossInformationFields.size());
		try {
			lossInformationSectionFields();
			while (j6 <lossInformationFields.size()) {
				for (WebElement element6 :lossInformationFields) {
					fieldsArray6[i6] = element6.getText();
					if (fieldsArray6[i6].equalsIgnoreCase(lossInformationSectionFields.get(j6))) {
						System.out.println("Verify Opportunity Information Section " + element6.getText());
						report.updateTestLog("Verify Opportunity Information Section",
								element6.getText() + "labels  present in the Opportunity Information Section ", Status.PASS);
						count6++;
					}
					i6++;
				}
				i6 = 0;
				j6++;
			}
			System.out.println(count6);
			if (count6 != 2) {
				report.updateTestLog("Verify Opportunity Information Section",
						"All fields are not present in the Opportunity Information Section", Status.FAIL);
			} else {
				report.updateTestLog("Verify Property Details Section",
						"All fields are present in the Opportunity Information Section", Status.PASS);
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		List<WebElement> systemInformationFields = driver.findElements(By.xpath("//span[contains(text(),'System Information')]/parent::h3/following-sibling::div//div[contains(@class,'slds-form-element__control')]//label/span[1]"));
		int count7 = 0, i7 = 0, j7 = 0;
		String fieldsArray7[] = new String[systemInformationFields.size()];
		System.out.println(systemInformationFields.size());
		try {
			systemInformationSectionFields();
			while (j7 < systemInformationFields.size()) {
				for (WebElement element7 :systemInformationFields) {
					fieldsArray7[i7] = element7.getText();
					if (fieldsArray7[i7].equalsIgnoreCase(systemInformationSectionFields.get(j7))) {
						System.out.println("Verify Opportunity Information Section " + element7.getText());
						report.updateTestLog("Verify Opportunity Information Section",
								element7.getText() + "labels  present in the Opportunity Information Section ", Status.PASS);
						count7++;
					}
					i7++;
				}
				i7 = 0;
				j7++;
			}
			System.out.println(count7);
			if (count7 != 2) {
				report.updateTestLog("Verify Opportunity Information Section",
						"All fields are not present in the Opportunity Information Section", Status.FAIL);
			} else {
				report.updateTestLog("Verify Property Details Section",
						"All fields are present in the Opportunity Information Section", Status.PASS);
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		Utility_Functions.xWaitForElementPresent(driver, targetProperty, 3);
		String targetPropertyName = searchOpportunity.fetchRecord("Property__c ", "Name");
		Utility_Functions.xSendKeys(driver,targetProperty, targetPropertyName);
		WebElement firstLookupElement = driver.findElement(By.cssSelector("ul>li.forceSearchInputLookupDesktopOption:nth-child(1)"));
		Utility_Functions.xWaitForElementPresent(driver, firstLookupElement, 3);
		Utility_Functions.xClick(driver,firstLookupElement, true);
		Utility_Functions.xWaitForElementPresent(driver,opportunityNameAS, 3);
		Utility_Functions.xSendKeys(driver,opportunityNameAS, "Test Automation Opportunity_" + Utility_Functions.xGenerateAlphaNumericString());
		Utility_Functions.xWaitForElementPresent(driver,accountNameNewOpportunity, 3);
		String accountName = searchOpportunity.fetchRecord("Account", "Name");
		Utility_Functions.xSendKeys(driver,accountNameNewOpportunity, accountName);
		WebElement firstLookupElementAccount = driver.findElement(By.cssSelector("ul>li.forceSearchInputLookupDesktopOption:nth-child(1)"));
		Utility_Functions.xWaitForElementPresent(driver, firstLookupElementAccount, 3);
		Utility_Functions.xClick(driver,firstLookupElementAccount, true);
		Utility_Functions.xWaitForElementPresent(driver,leadSourceNewOpp, 3);
		Utility_Functions.xClick(driver,leadSourceNewOpp, true);
		Utility_Functions.xWaitForElementPresent(driver,leadSourceNewOppValue, 3);
		Utility_Functions.xClick(driver,leadSourceNewOppValue, true);
		System.out.println(Calendar.getInstance());
		DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
		Date date = new Date();
		Utility_Functions.xWaitForElementPresent(driver,closeDate_AS, 3);
		Utility_Functions.xSendKeys(driver,closeDate_AS, dateFormat.format(date).toString());
		Utility_Functions.xWaitForElementPresent(driver,estiamtedGrossFeeCommissionValue, 5);
		Utility_Functions.xSendKeys(driver,estiamtedGrossFeeCommissionValue, dataTable.getData("General_Data", "InstallmentAmount"));
		Utility_Functions.xWaitForElementPresent(driver,estimatedTransactionValue, 5);
		Utility_Functions.xSendKeys(driver,estimatedTransactionValue, dataTable.getData("General_Data", "InstallmentAmount"));
		Utility_Functions.xWaitForElementPresent(driver,saveNewOpportunity_AS, 3);
		Utility_Functions.xClick(driver,saveNewOpportunity_AS, true);
		Utility_Functions.timeWait(5);
		if(details.isDisplayed()) {

			report.updateTestLog("Verify Quick Create Opportunity Page ", "The opportunity is saved with the mandatory fields ", Status.PASS);
		} else {
			report.updateTestLog("Verify Quick Create Opportunity Page ", "The opportunity is not saved with the mandatory fields", Status.FAIL);
		}
	}
	/**
	 * Validating the Opportunities edit page for the Capital Advisor users
	 * 
	 * @author Ramya
	 *
	 */
	static ArrayList<String> opportunityInformationEditPageFields = new ArrayList<String>();

	public void opportunityInformationSectionEditPage() {

		opportunityInformationEditPageFields.add("Opportunity Name");
		opportunityInformationEditPageFields.add("Confidential Opportunity");
		opportunityInformationEditPageFields.add("Account Name");
		opportunityInformationEditPageFields.add("Sales Stage");
		opportunityInformationEditPageFields.add("Estimated Gross Fee/Commission");
		opportunityInformationEditPageFields.add("Description");
		opportunityInformationEditPageFields.add("Net Fee");
		opportunityInformationEditPageFields.add("Comments");
		opportunityInformationEditPageFields.add("Close Date");
		opportunityInformationEditPageFields.add("Total Size");
		opportunityInformationEditPageFields.add("Parent Opportunity");
		opportunityInformationEditPageFields.add("Change Opportunity Owner");
		opportunityInformationEditPageFields.add("Conversion Type Other");


		System.out.println("The labels for the Opportunity Information section edit page are " + opportunityInformationEditPageFields);

	}
	static ArrayList<String> additionalInformationEditPageFields = new ArrayList<String>();

	public void additionalInformationSectionEditPage() {

		additionalInformationEditPageFields.add("Address Line 1");
		additionalInformationEditPageFields.add("City");
		additionalInformationEditPageFields.add("Address Line 2");
		additionalInformationEditPageFields.add("Postcode");
		additionalInformationEditPageFields.add("RFP Submission Date");
		additionalInformationEditPageFields.add("Probability (%)");
		additionalInformationEditPageFields.add("Pitch Date");
		additionalInformationEditPageFields.add("Referral");
		additionalInformationEditPageFields.add("Referral Recipient");
		additionalInformationEditPageFields.add("Referral Email Sent");


		System.out.println("The labels for the Additional Information section edit page are " + additionalInformationEditPageFields);

	}
	static ArrayList<String> lossInformationEditPageFields = new ArrayList<String>();

	public void lossInformationSectionEditPage() {

		lossInformationEditPageFields.add("Competitor");
		lossInformationEditPageFields.add("Reason Lost Comments");
		lossInformationEditPageFields.add("Next Step");
		lossInformationEditPageFields.add("Invoice No");
		lossInformationEditPageFields.add("Bill Date");

		System.out.println("The labels for the loss Information section edit page are " + lossInformationEditPageFields);

	}
	static ArrayList<String> dataHugDetailsEditPageFields = new ArrayList<String>();

	public void dataHugDEtailsSectionEditPage() {

		dataHugDetailsEditPageFields.add("Deal Score");
		dataHugDetailsEditPageFields.add("Last Email Sent");
		dataHugDetailsEditPageFields.add("Deal Score Reason");
		dataHugDetailsEditPageFields.add("Last Email Sent by");
		dataHugDetailsEditPageFields.add("Best Connected Colleague");
		dataHugDetailsEditPageFields.add("Last Meeting");
		dataHugDetailsEditPageFields.add("Last Email Received");
		dataHugDetailsEditPageFields.add("Next Meeting");
		dataHugDetailsEditPageFields.add("Last Email Received from");

		System.out.println("The labels for the Additional Information section edit page are " +dataHugDetailsEditPageFields);

	}
	static ArrayList<String> systemInformationEditPageFields = new ArrayList<String>();

	public void systemInformationSectionEditPage() {

		systemInformationEditPageFields.add("Created By");
		systemInformationEditPageFields.add("External Deal ID");
		systemInformationEditPageFields.add("Last Modified By");
		systemInformationEditPageFields.add("Opportunity Record Type");
		systemInformationEditPageFields.add("Opportunity Age (Days)");

		System.out.println("The labels for the Additional Information section edit page are " +systemInformationEditPageFields);

	}


	public void validateOpportunitiesEditPageLayout() {
		opportunityEligibility();
		Utility_Functions.timeWait(2);
		Utility_Functions.xWaitForElementPresent(driver,edit, 3);
		Utility_Functions.xClick(driver, edit, true);
		List<WebElement> opportunityInformationFields = driver.findElements(By.xpath("//span[text()='Opportunity Information']/parent::h3/following-sibling::div//div[contains(@class,'slds-form-element__control')]//label/span[1]"));
		int count1 = 0, i1 = 0, j1 = 0;
		String fieldsArray[] = new String[opportunityInformationFields.size()];
		System.out.println(opportunityInformationFields.size());
		try {
			opportunityInformationSectionEditPage();
			while (j1 <opportunityInformationFields.size()) {
				for (WebElement element1 : opportunityInformationFields) {
					fieldsArray[i1] = element1.getText();
					if (fieldsArray[i1].equalsIgnoreCase(opportunityInformationEditPageFields.get(j1))) {
						System.out.println("Verify Opportunity Information Section " + element1.getText());
						report.updateTestLog("Verify Opportunity Information Section ",
								element1.getText() + "labels  present in the Opportunity Information Section ", Status.PASS);
						count1++;
					}
					i1++;
				}
				i1 = 0;
				j1++;
			}
			System.out.println(count1);
			if (count1 >= 11) {
				report.updateTestLog("Verify Opportunity Information Section",
						"All fields are not present in the Opportunity Information Section", Status.PASS);
			} else {
				report.updateTestLog("Verify Opportunity Information Section",
						"All fields are present in the Opportunity Information Section", Status.FAIL);
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		List<WebElement> additionalInformationFields = driver.findElements(By.xpath("//span[text()='Additional Information']/parent::h3/following-sibling::div//div[contains(@class,'slds-form-element__control')]//label/span[1]"));
		int count2 = 0, i2 = 0, j2 = 0;
		String fieldsArray2[] = new String[additionalInformationFields.size()];
		System.out.println(additionalInformationFields.size());
		try {
			additionalInformationSectionEditPage();
			while (j2 <additionalInformationFields.size()) {
				for (WebElement element2 :additionalInformationFields) {
					fieldsArray2[i2] = element2.getText();
					if (fieldsArray2[i2].equalsIgnoreCase(additionalInformationEditPageFields.get(j2))) {
						System.out.println("Verify Additional Information Section " + element2.getText());
						report.updateTestLog("Verify Additional Information Section ",
								element2.getText() + "labels  present in the Additional Information Section ", Status.PASS);
						count2++;
					}
					i2++;
				}
				i2 = 0;
				j2++;
			}
			System.out.println(count2);
			if (count2 >= 10) {
				report.updateTestLog("Verify Additional Information Section",
						"All fields are not present in the Additional Information Section", Status.PASS);
			} else {
				report.updateTestLog("Verify Additional Information Section",
						"All fields are present in the Additional Information Section", Status.FAIL);
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		List<WebElement> lossInformationFields = driver.findElements(By.xpath("//span[text()='Loss Information']/parent::h3/following-sibling::div//div[contains(@class,'slds-form-element__control')]//label/span[1]"));
		int count3 = 0, i3 = 0, j3 = 0;
		String fieldsArray3[] = new String[lossInformationFields.size()];
		System.out.println(lossInformationFields.size());
		try {
			lossInformationSectionEditPage();
			while (j3 <additionalInformationFields.size()) {
				for (WebElement element3 :additionalInformationFields) {
					fieldsArray3[i3] = element3.getText();
					if (fieldsArray3[i3].equalsIgnoreCase(lossInformationEditPageFields.get(j3))) {
						System.out.println("Verify Loss Information Section " + element3.getText());
						report.updateTestLog("Verify Loss Information Section ",
								element3.getText() + "labels  present in the Loss Information Section ", Status.PASS);
						count3++;
					}
					i3++;
				}
				i3 = 0;
				j3++;
			}
			System.out.println(count3);
			if (count3 !=3) {
				report.updateTestLog("Verify Loss Information Section",
						"All fields are not present in the Loss Information Section", Status.FAIL);
			} else {
				report.updateTestLog("Verify Loss Information Section",
						"All fields are present in the Loss Information Section", Status.PASS);
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		List<WebElement> dataHugDetailsFields = driver.findElements(By.xpath("//span[text()='Datahug Details']/parent::h3/following-sibling::div//div[contains(@class,'test-id__field-label-container')]/span[1]"));
		int count4 = 0, i4 = 0, j4 = 0;
		String fieldsArray4[] = new String[dataHugDetailsFields.size()];
		System.out.println(dataHugDetailsFields.size());
		try {
			dataHugDEtailsSectionEditPage();
			while (j4 <dataHugDetailsFields.size()) {
				for (WebElement element4 :dataHugDetailsFields) {
					fieldsArray4[i4] = element4.getText();
					if (fieldsArray4[i4].equalsIgnoreCase(dataHugDetailsEditPageFields.get(j4))) {
						System.out.println("Verify Data Hug Details Section " + element4.getText());
						report.updateTestLog("Verify Data Hug Details Section ",
								element4.getText() + "labels  present in the Data Hug Details Section ", Status.PASS);
						count4++;
					}
					i4++;
				}
				i4 = 0;
				j4++;
			}
			System.out.println(count4);
			if (count4 >=9) {
				report.updateTestLog("Verify Data Hug Details Section",
						"All fields are not present in the Data Hug Details Section", Status.PASS);
			} else {
				report.updateTestLog("Verify Data Hug Details Section",
						"All fields are present in the Data HUg Details Section", Status.FAIL);
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		List<WebElement> systemInformationFields = driver.findElements(By.xpath("//span[text()='System Information']/parent::h3/following-sibling::div//div[contains(@class,'test-id__field-label-container')]/span[1]"));
		int count5 = 0, i5 = 0, j5 = 0;
		String fieldsArray5[] = new String[systemInformationFields.size()];
		System.out.println(systemInformationFields.size());
		try {
			systemInformationSectionEditPage();
			while (j5 <systemInformationFields.size()) {
				for (WebElement element5 :systemInformationFields) {
					fieldsArray5[i5] = element5.getText();
					if (fieldsArray5[i5].equalsIgnoreCase(systemInformationEditPageFields.get(j5))) {
						System.out.println("Verify System Information Section " + element5.getText());
						report.updateTestLog("Verify System Information Section ",
								element5.getText() + "labels  present in the System Information Section ", Status.PASS);
						count5++;
					}
					i5++;
				}
				i5 = 0;
				j5++;
			}
			System.out.println(count5);
			if (count5 >=5) {
				report.updateTestLog("Verify System Information Section",
						"All fields are not present in the Property Details Section", Status.PASS);
			} else {
				report.updateTestLog("Verify System Information Section",
						"All fields are present in the System Information Section", Status.FAIL);
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

	}
	/**
	 * Validating the Opportunities edit page for the EMEA Valuation users
	 * 
	 * @author Ramya
	 *
	 */
	static ArrayList<String> opportunityInformationEditPageValues = new ArrayList<String>();

	public void opportunityInformationEditPage() {

		opportunityInformationEditPageValues.add("Opportunity Name");
		opportunityInformationEditPageValues.add("Confidential Opportunity");
		opportunityInformationEditPageValues.add("Account Name");
		opportunityInformationEditPageValues.add("Close Date");
		opportunityInformationEditPageValues.add("Project Type Description");
		opportunityInformationEditPageValues.add("Sales Stage");
		opportunityInformationEditPageValues.add("Comments");
		opportunityInformationEditPageValues.add("Assignment Start Date");
		opportunityInformationEditPageValues.add("Estimated Gross Fee/Commission");
		opportunityInformationEditPageValues.add("Net Fee");
		opportunityInformationEditPageValues.add("Probability (%)");
		opportunityInformationEditPageValues.add("Risk");

		System.out.println("The values for the Opportunity Information section edit page are " + opportunityInformationEditPageValues);

	}
	static ArrayList<String> additionalInformationEditPageValues = new ArrayList<String>();

	public void additionalInformationEditPage() {

		additionalInformationEditPageValues.add("Address Line 1");
		additionalInformationEditPageValues.add("Sub Market");
		additionalInformationEditPageValues.add("Address Line 2");
		additionalInformationEditPageValues.add("City");
		additionalInformationEditPageValues.add("Postcode");
		additionalInformationEditPageValues.add("Property Market Value");
		additionalInformationEditPageValues.add("Total Size");
		additionalInformationEditPageValues.add("Referral");
		additionalInformationEditPageValues.add("Parent Opportunity");
		additionalInformationEditPageValues.add("Referral Recipient");


		System.out.println("The labels for the Additional Information section edit page are " +additionalInformationEditPageValues);

	}
	static ArrayList<String> lossInformationEditPageValues = new ArrayList<String>();

	public void lossInformationEditPage() {

		lossInformationEditPageValues.add("Competitor");
		lossInformationEditPageValues.add("Reason Lost Comments");
		lossInformationEditPageValues.add("Next Step");

		System.out.println("The labels for the loss Information section edit page are " +lossInformationEditPageValues);

	}
	static ArrayList<String> dataHugDetailsEditPageValues = new ArrayList<String>();

	public void dataHugDetailsEditPage() {

		dataHugDetailsEditPageValues.add("Deal Score");
		dataHugDetailsEditPageValues.add("Last Email Sent");
		dataHugDetailsEditPageValues.add("Deal Score Reason");
		dataHugDetailsEditPageValues.add("Last Email Sent by");
		dataHugDetailsEditPageValues.add("Best Connected Colleague");
		dataHugDetailsEditPageValues.add("Last Meeting");
		dataHugDetailsEditPageValues.add("Last Email Received");
		dataHugDetailsEditPageValues.add("Next Meeting");
		dataHugDetailsEditPageValues.add("Last Email Received from");

		System.out.println("The labels for the Data Hug details section edit page are " +dataHugDetailsEditPageValues);

	}
	static ArrayList<String> systemInformationEditPageValues = new ArrayList<String>();

	public void systemInformationEditPage() {

		systemInformationEditPageFields.add("Created By");
		systemInformationEditPageFields.add("Last Modified By");
		systemInformationEditPageFields.add("External Deal ID");
		systemInformationEditPageFields.add("Opportunity Record Type");
		systemInformationEditPageFields.add("Opportunity Age (Days)");

		System.out.println("The labels for the System Information edit page are " +systemInformationEditPageFields);

	}
	static ArrayList<String> bankValuationsInstructionsFields = new ArrayList<String>();

	public void bankValuationsInstructionsEditPage() {

		bankValuationsInstructionsFields.add("Reason for Loss");
		bankValuationsInstructionsFields.add("Competitor");
		bankValuationsInstructionsFields.add("Reason Lost Comments");
		
		System.out.println("The labels for the Bank Valuations Instructions edit page are " +bankValuationsInstructionsFields);

	}
	static ArrayList<String> valuationSpecificEditPageValues = new ArrayList<String>();

	public void valuationSpecificEditPage() {

		valuationSpecificEditPageValues.add("Number of Properties");		
		System.out.println("The labels for the Valuation Specific section edit page are " +valuationSpecificEditPageValues);

	}


	public void validateOpportunitiesValuationsEditPage() {
		opportunityEligibility();
		Utility_Functions.timeWait(2);
		Utility_Functions.xWaitForElementPresent(driver,edit, 3);
		Utility_Functions.xClick(driver, edit, true);
		List<WebElement> opportunityInformationFields = driver.findElements(By.xpath("//span[text()='Opportunity Information']/parent::h3/following-sibling::div//div[contains(@class,'slds-form-element__control')]//label/span[1]"));
		int count1 = 0, i1 = 0, j1 = 0;
		String fieldsArray[] = new String[opportunityInformationFields.size()];
		System.out.println(opportunityInformationFields.size());
		try {
			opportunityInformationEditPage();
			while (j1 <opportunityInformationFields.size()) {
				for (WebElement element1 : opportunityInformationFields) {
					fieldsArray[i1] = element1.getText();
					if (fieldsArray[i1].equalsIgnoreCase(opportunityInformationEditPageValues.get(j1))) {
						System.out.println("Verify Opportunity Information Section " + element1.getText());
						report.updateTestLog("Verify Opportunity Information Section ",
								element1.getText() + "labels  present in the Opportunity Information Section ", Status.PASS);
						count1++;
					}
					i1++;
				}
				i1 = 0;
				j1++;
			}
			System.out.println(count1);
			if (count1 >= 8) {
				report.updateTestLog("Verify Opportunity Information Section",
						"All fields are present in the Opportunity Information Section", Status.PASS);
			} else {
				report.updateTestLog("Verify Opportunity Information Section",
						"All fields are not present in the Opportunity Information Section", Status.FAIL);
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		List<WebElement> additionalInformationFields = driver.findElements(By.xpath("//span[text()='Additional Information']/parent::h3/following-sibling::div//div[contains(@class,'slds-form-element__control')]//label/span[1]"));
		int count2 = 0, i2 = 0, j2 = 0;
		String fieldsArray2[] = new String[additionalInformationFields.size()];
		System.out.println(additionalInformationFields.size());
		try {
			additionalInformationEditPage();
			while (j2 <additionalInformationFields.size()) {
				for (WebElement element2 :additionalInformationFields) {
					fieldsArray2[i2] = element2.getText();
					if (fieldsArray2[i2].equalsIgnoreCase(additionalInformationEditPageValues.get(j2))) {
						System.out.println("Verify Additional Information Section " + element2.getText());
						report.updateTestLog("Verify Additional Information Section ",
								element2.getText() + "labels  present in the Additional Information Section ", Status.PASS);
						count2++;
					}
					i2++;
				}
				i2 = 0;
				j2++;
			}
			System.out.println(count2);
			if (count2 >= 6) {
				report.updateTestLog("Verify Additional Information Section",
						"All fields are present in the Additional Information Section", Status.PASS);
			} else {
				report.updateTestLog("Verify Additional Information Section",
						"All fields are not present in the Additional Information Section", Status.FAIL);
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		int count6 = 0, i6 = 0;
		try {
			List<WebElement> valuationSpecificFields = null;
			String fieldsArray6[] = null;
			boolean isPresent = false;
			try {
				valuationSpecificFields = driver.findElements(By.xpath("//span[text()='Valuations Specific Information']/parent::h3/following-sibling::div//div[contains(@class,'slds-form-element__control')]//label/span[1]"));
				fieldsArray6 = new String[valuationSpecificFields.size()];
				System.out.println(valuationSpecificFields.size());
				if(valuationSpecificFields.size()>1) {
					isPresent = true;
					valuationSpecificEditPage();
					for (WebElement element6 :valuationSpecificFields) {
						System.out.println(element6.getText());
						fieldsArray6[i6] = element6.getText();
						if (fieldsArray6[i6].contains(valuationSpecificEditPageValues.get(i1))) {
							report.updateTestLog("Verify Valuation Specific fields",
									"Valuation specific fields is having the " + fieldsArray6[i6] + " fields ", Status.PASS);
							count6++;
						}
						i6++;
					} 
				} else {
					isPresent=false;
				}
			} catch (Exception e) {
				report.updateTestLog("Verify Valuation Specific fields", "Valuation specific section is not present for the selected Opportunity", Status.WARNING);	
				isPresent = false;
			}				
			System.out.println(count6);
			if(isPresent==true) {
				if (count6 != 1) {
					report.updateTestLog("Verify Valuation Specific fields",
							"All fields are not present in the Valuation specific section ", Status.FAIL);
				} else {

					report.updateTestLog("Verify Valuation Specific fields",
							"All fields are present in the Valuation specific section", Status.PASS);
				}
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		int count7 = 0, i7 = 0, j7=0;
		try {
			List<WebElement> bankValuationServiceFields = null;
			String fieldsArray7[] = null;
			boolean isPresent = false;
			try {
				bankValuationServiceFields = driver.findElements(By.xpath("//span[text()='Bank Valuations Instructions']/parent::h3/following-sibling::div//div[contains(@class,'slds-form-element__control')]//label/span[1]"));
				fieldsArray7 = new String[bankValuationServiceFields.size()];
				System.out.println(bankValuationServiceFields.size());
				if(bankValuationServiceFields.size()>1) { 
					isPresent = true;				
					bankValuationsInstructionsEditPage();
					while (j7 <bankValuationServiceFields.size()) {
						for (WebElement element7 :bankValuationServiceFields) {
							fieldsArray7[i7] = element7.getText();
							if (fieldsArray7[i7].equalsIgnoreCase(bankValuationsInstructionsFields.get(j7))) {
								System.out.println("Verify Bank Valuations Services Section " + element7.getText());
								report.updateTestLog("Verify Bank Valuations Services Section ",
										element7.getText() + "labels  present in the Bank Valuations services Section ", Status.PASS);
								count7++;
							}
							i7++;
						}
						i7 = 0;
						j7++;
					}
				} else {
					isPresent = false;
				}
			} catch (Exception e1) {
				report.updateTestLog("Verify Business Service fields", "Business Service section is not present for the selected Opportunity", Status.WARNING);
				isPresent = false;
			}


			System.out.println(count7);
			if(isPresent==true) {
				if (count7 != 5) {
					report.updateTestLog("Verify Bank Valuation Services Section",
							"All fields are not present in the Bank Valuation Services Section", Status.FAIL);
				} else {
					report.updateTestLog("Verify Bank Valuation Services Section",
							"All fields are present in the Bank Valuation Services Section", Status.PASS);
				}
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		List<WebElement> lossInformationFields = driver.findElements(By.xpath("//span[text()='Loss Information']/parent::h3/following-sibling::div//div[contains(@class,'slds-form-element__control')]//label/span[1]"));
		int count3 = 0, i3 = 0, j3 = 0;
		String fieldsArray3[] = new String[lossInformationFields.size()];
		System.out.println(lossInformationFields.size());
		try {
			lossInformationEditPage();
			while (j3 <additionalInformationFields.size()) {
				for (WebElement element3 :additionalInformationFields) {
					fieldsArray3[i3] = element3.getText();
					if (fieldsArray3[i3].equalsIgnoreCase(lossInformationEditPageValues.get(j3))) {
						System.out.println("Verify Loss Information Section " + element3.getText());
						report.updateTestLog("Verify Loss Information Section ",
								element3.getText() + "labels  present in the Loss Information Section ", Status.PASS);
						count3++;
					}
					i3++;
				}
				i3 = 0;
				j3++;
			}
			System.out.println(count3);
			if (count3 !=3) {
				report.updateTestLog("Verify Loss Information Section",
						"All fields are not present in the Loss Information Section", Status.FAIL);
			} else {
				report.updateTestLog("Verify Loss Information Section",
						"All fields are present in the Loss Information Section", Status.PASS);
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		List<WebElement> dataHugDetailsFields = driver.findElements(By.xpath("//span[text()='Datahug Details']/parent::h3/following-sibling::div//div[contains(@class,'test-id__field-label-container')]/span[1]"));
		int count4 = 0, i4 = 0, j4 = 0;
		String fieldsArray4[] = new String[dataHugDetailsFields.size()];
		System.out.println(dataHugDetailsFields.size());
		try {
			dataHugDetailsEditPage();
			while (j4 <dataHugDetailsFields.size()) {
				for (WebElement element4 :dataHugDetailsFields) {
					fieldsArray4[i4] = element4.getText();
					if (fieldsArray4[i4].equalsIgnoreCase(dataHugDetailsEditPageValues.get(j4))) {
						System.out.println("Verify Data Hug Details Section " + element4.getText());
						report.updateTestLog("Verify Data Hug Details Section ",
								element4.getText() + "labels  present in the Data Hug Details Section ", Status.PASS);
						count4++;
					}
					i4++;
				}
				i4 = 0;
				j4++;
			}
			System.out.println(count4);
			if (count4 !=9) {
				report.updateTestLog("Verify Data Hug Details Section",
						"All fields are not present in the Data Hug Details Section", Status.FAIL);
			} else {
				report.updateTestLog("Verify Data Hug Details Section",
						"All fields are present in the Data HUg Details Section", Status.PASS);
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		List<WebElement> systemInformationFields = driver.findElements(By.xpath("//span[text()='System Information']/parent::h3/following-sibling::div//div[contains(@class,'test-id__field-label-container')]/span[1]"));
		int count5 = 0, i5 = 0, j5 = 0;
		String fieldsArray5[] = new String[systemInformationFields.size()];
		System.out.println(systemInformationFields.size());
		try {
			systemInformationEditPage();
			while (j5 <systemInformationFields.size()) {
				for (WebElement element5 :systemInformationFields) {
					fieldsArray5[i5] = element5.getText();
					if (fieldsArray5[i5].equalsIgnoreCase(systemInformationEditPageValues.get(j5))) {
						System.out.println("Verify System Information Section " + element5.getText());
						report.updateTestLog("Verify System Information Section ",
								element5.getText() + "labels  present in the System Information Section ", Status.PASS);
						count5++;
					}
					i5++;
				}
				i5 = 0;
				j5++;
			}
			System.out.println(count5);
			if (count5 !=5) {
				report.updateTestLog("Verify System Information Section",
						"All fields are not present in the Property Details Section", Status.FAIL);
			} else {
				report.updateTestLog("Verify System Information Section",
						"All fields are present in the System Information Section", Status.PASS);
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	/**
	 * Validating the Opportunities page for the Japan users
	 * 
	 * @author Ramya
	 *
	 */
	static ArrayList<String> opportunityInformationValues = new ArrayList<String>();

	public void opportunityInformation() {

		opportunityInformationValues.add("Opportunity Name");
		opportunityInformationValues.add("Account Name");
		opportunityInformationValues.add("Lead Source");
		opportunityInformationValues.add("Primary Contact");
		opportunityInformationValues.add("Assignment Type");
		opportunityInformationValues.add("Close Date");
		opportunityInformationValues.add("Assignment Sub-Type");
		opportunityInformationValues.add("Opportunity Location");
		opportunityInformationValues.add("Status Comments");
		opportunityInformationValues.add("Confidential Opportunity");
		opportunityInformationValues.add("HNI Transaction");
		opportunityInformationValues.add("Parent Opportunity");

		System.out.println("The values for the Opportunity Information section are " + opportunityInformationValues);

	}
	static ArrayList<String> financialDetailsStagesValues = new ArrayList<String>();

	public void financialDetails() {

		financialDetailsStagesValues.add("Estimated Gross Fee/Commission");
		financialDetailsStagesValues.add("Sales Stage");
		financialDetailsStagesValues.add("Estimated Transaction Value");
		financialDetailsStagesValues.add("Opportunity Currency");
		financialDetailsStagesValues.add("On Hold");
		financialDetailsStagesValues.add("On Hold Comments");
	
		System.out.println("The labels for the financial detials section are " +financialDetailsStagesValues);

	}
	static ArrayList<String> opportunityDetailsValues = new ArrayList<String>();

	public void opportunityDetails() {

		opportunityDetailsValues.add("Target Property");
		opportunityDetailsValues.add("Total Size");
		opportunityDetailsValues.add("Opportunity Details");
		opportunityDetailsValues.add("Unit of Measure");
		opportunityDetailsValues.add("Deal Tenure (in Months)");
		opportunityDetailsValues.add("Total # of Units");
		opportunityDetailsValues.add("Principal Moratorium (in Months)");
		opportunityDetailsValues.add("Unit of Comparison");
		opportunityDetailsValues.add("Interest Moratorium (in Months)");
		opportunityDetailsValues.add("Property Approval Status (India)");
		opportunityDetailsValues.add("Total Built-up Area");
		opportunityDetailsValues.add("Proposed Land Use");

		System.out.println("The labels for the Opportunity Details section are " +opportunityDetailsValues);

	}
	static ArrayList<String> appointmentInformationValues = new ArrayList<String>();

	public void appointmentInformation() {

		appointmentInformationValues.add("Appointment Type");
		appointmentInformationValues.add("Agency Start Date");
		appointmentInformationValues.add("Agency Expiry Date");
		
		System.out.println("The labels for the appointment Information section are " +appointmentInformationValues);

	}
	static ArrayList<String> closeInformationValues = new ArrayList<String>();

	public void closeInformation() {

		closeInformationValues.add("Counterpart Account");
		closeInformationValues.add("Yield (%)");
		closeInformationValues.add("Counterpart Role");
		closeInformationValues.add("Yield/Return Type");
		closeInformationValues.add("Settlement/Completion Date");
		closeInformationValues.add("CBRE Role");
		closeInformationValues.add("Buyer Confidentiality Agreement Signed");
		closeInformationValues.add("Stake Diluted (%)");
		closeInformationValues.add("Close Comments");

		System.out.println("The labels for the close information section are " +closeInformationValues);

	}
	static ArrayList<String> lossInformationValues = new ArrayList<String>();

	public void lossInformation() {

		lossInformationValues.add("Reason for Loss");
		lossInformationValues.add("Competitor");
		lossInformationValues.add("Reason Lost Comments");
	

		System.out.println("The labels for the Loss Information section are " +lossInformationValues );

	}
	static ArrayList<String> systemInformationSectionValues = new ArrayList<String>();

	public void systemInformationSectionOpportunityPage() {

		//systemInformationSectionValues.add("Opportunity Owner");	
		systemInformationSectionValues.add("Last Manually Modified By");
		systemInformationSectionValues.add("Last Manually Modified Date");
		
		System.out.println("The system information fields are " +systemInformationSectionValues);

	}


	public void validateNewOpportunitiesPage() {
		Utility_Functions.xWaitForElementPresent(driver, menu_Opportunities, 4);
		Utility_Functions.xClick(driver, menu_Opportunities, true);
		Utility_Functions.xWaitForElementPresent(driver, newOpportunity, 3);
		Utility_Functions.xClick(driver, newOpportunity, true);
		Utility_Functions.timeWait(2);
		Utility_Functions.xSwitchtoFrame(driver, continueButton);
		Utility_Functions.xWaitForElementPresent(driver,selectOpportunityRecordType, 3);
		Utility_Functions.xClick(driver,selectOpportunityRecordType, true);
		Utility_Functions.xWaitForElementPresent(driver,opportunityDSFValue, 3);
		Utility_Functions.xClick(driver,opportunityDSFValue, true);
		Utility_Functions.xWaitForElementPresent(driver,continueButton, 3);
		Utility_Functions.xClick(driver,continueButton, true);
		Utility_Functions.timeWait(2);
		driver.switchTo().defaultContent();
		List<WebElement> opportunityInformationFields = driver.findElements(By.xpath("//span[text()='Opportunity Information']/parent::h3/following-sibling::div//*[contains(@class,'form-element__label')]/span[1]"));
		int count1 = 0, i1 = 0, j1 = 0;
		String fieldsArray[] = new String[opportunityInformationFields.size()];
		System.out.println(opportunityInformationFields.size());
		try {
			opportunityInformation();
			while (j1 <opportunityInformationFields.size()) {
				for (WebElement element1 : opportunityInformationFields) {
					fieldsArray[i1] = element1.getText();
					if (fieldsArray[i1].equalsIgnoreCase(opportunityInformationValues.get(j1))) {
						System.out.println("Verify Opportunity Information Section " + element1.getText());
						report.updateTestLog("Verify Opportunity Information Section ",
								element1.getText() + "labels  present in the Opportunity Information Section ", Status.PASS);
						count1++;
					}
					i1++;
				}
				i1 = 0;
				j1++;
			}
			System.out.println(count1);
			if (count1 >= 10) {
				report.updateTestLog("Verify Opportunity Information Section",
						"All fields are present in the Opportunity Information Section", Status.PASS);
			} else {
				report.updateTestLog("Verify Opportunity Information Section",
						"All fields are not present in the Opportunity Information Section", Status.FAIL);
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		List<WebElement> financialDetailsFields = driver.findElements(By.xpath("//span[text()='Financial Details/Sales Stages']/parent::h3/following-sibling::div//*[contains(@class,'form-element__label')]/span[1]"));
		int count2 = 0, i2 = 0, j2 = 0;
		String fieldsArray2[] = new String[financialDetailsFields.size()];
		System.out.println(financialDetailsFields.size());
		try {
			financialDetails();
			while (j2 <financialDetailsFields.size()) {
				for (WebElement element2 :financialDetailsFields) {
					fieldsArray2[i2] = element2.getText();
					if (fieldsArray2[i2].equalsIgnoreCase(financialDetailsStagesValues.get(j2))) {
						System.out.println("Verify Additional Information Section " + element2.getText());
						report.updateTestLog("Verify Additional Information Section ",
								element2.getText() + "labels  present in the Additional Information Section ", Status.PASS);
						count2++;
					}
					i2++;
				}
				i2 = 0;
				j2++;
			}
			System.out.println(count2);
			if (count2 != 6) {
				report.updateTestLog("Verify Financial Details Section",
						"All fields are present in the Financial Details Section", Status.PASS);
			} else {
				report.updateTestLog("Verify Financial Details Section",
						"All fields are not present in the Financial Details Section", Status.FAIL);
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		List<WebElement> opportunityDetailsFields = driver.findElements(By.xpath("//span[text()='Opportunity Details']/parent::h3/following-sibling::div//*[contains(@class,'form-element__label')]/span[1]"));
		int count6 = 0, i6 = 0, j6 = 0;
		String fieldsArray6[] = new String[opportunityDetailsFields.size()];
		System.out.println(opportunityDetailsFields.size());
		try {
			opportunityDetails();
			while (j6 <opportunityDetailsFields.size()) {
				for (WebElement element6 :opportunityDetailsFields) {
					fieldsArray6[i6] = element6.getText();
					if (fieldsArray6[i6].equalsIgnoreCase(opportunityDetailsValues.get(j6))) {
						System.out.println("Verify Opportunity Information Section " + element6.getText());
						report.updateTestLog("Verify Opportunity Information Section ",
								element6.getText() + "labels  present in the Opportunity Information Section ", Status.PASS);
						count6++;
					}
					i6++;
				}
				i6 = 0;
				j6++;
			}
			System.out.println(count6);
			if (count6 >= 10) {
				report.updateTestLog("Verify Opportunity Details Section",
						"All fields are present in the Opportunity Details Section", Status.PASS);
			} else {
				report.updateTestLog("Verify Opportunity Details Section",
						"All fields are not present in the Opportunity Details Section", Status.FAIL);
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		List<WebElement> appointmentInformationFields =driver.findElements(By.xpath("//span[text()='Appointment Information']/parent::h3/following-sibling::div//*[contains(@class,'form-element__label')]/span[1]"));
		int count7 = 0, i7 = 0, j7 = 0;
		String fieldsArray7[] = new String[appointmentInformationFields.size()];
		System.out.println(appointmentInformationFields.size());
		try {
			appointmentInformation();
			while (j7 <appointmentInformationFields.size()) {
				for (WebElement element7 :appointmentInformationFields) {
					fieldsArray7[i7] = element7.getText();
					if (fieldsArray7[i7].equalsIgnoreCase(appointmentInformationValues.get(j7))) {
						System.out.println("Verify Appointment Information Section " + element7.getText());
						report.updateTestLog("Verify Appointment Information Section ",
								element7.getText() + "labels  present in the Appointment Information Section ", Status.PASS);
						count7++;
					}
					i7++;
				}
				i7 = 0;
				j7++;
			}
			System.out.println(count7);
			if (count7!=3) {
				report.updateTestLog("Verify Appoointment Information Section",
						"All fields are not present in the Appointment Information Section", Status.FAIL);
			} else {
				report.updateTestLog("Verify Appointment Information Section",
						"All fields are present in the Appointment Information Section", Status.PASS);
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}	
		

		List<WebElement> closeInformationFields = driver.findElements(By.xpath("//span[text()='Close Information']/parent::h3/following-sibling::div//*[contains(@class,'form-element__label')]/span[1]"));
		int count3 = 0, i3 = 0, j3 = 0;
		String fieldsArray3[] = new String[closeInformationFields.size()];
		System.out.println(closeInformationFields.size());
		try {
			closeInformation();
			while (j3 <closeInformationFields.size()) {
				for (WebElement element3 :closeInformationFields) {
					fieldsArray3[i3] = element3.getText();
					if (fieldsArray3[i3].equalsIgnoreCase(closeInformationValues.get(j3))) {
						System.out.println("Verify Close Information Section " + element3.getText());
						report.updateTestLog("Verify Close Information Section ",
								element3.getText() + "labels  present in the Close Information Section ", Status.PASS);
						count3++;
					}
					i3++;
				}
				i3 = 0;
				j3++;
			}
			System.out.println(count3);
			if (count3 >= 7) {
				report.updateTestLog("Verify Close Information Section",
						"All fields are present in the Close Information Section", Status.PASS);
			} else {
				report.updateTestLog("Verify Close Information Section",
						"All fields are not present in the Close Information Section", Status.FAIL);
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		List<WebElement> lossInformationFields = driver.findElements(By.xpath("//span[text()='Loss Information']/parent::h3/following-sibling::div//*[contains(@class,'form-element__label')]/span[1]"));
		int count4 = 0, i4 = 0, j4 = 0;
		String fieldsArray4[] = new String[lossInformationFields.size()];
		System.out.println(lossInformationFields.size());
		try {
			lossInformation();
			while (j4 <lossInformationFields.size()) {
				for (WebElement element4 :lossInformationFields) {
					fieldsArray4[i4] = element4.getText();
					if (fieldsArray4[i4].equalsIgnoreCase(lossInformationValues.get(j4))) {
						System.out.println("Verify Loss Information Section " + element4.getText());
						report.updateTestLog("Verify Loss Information Section ",
								element4.getText() + "labels  present in the Loss Information Section ", Status.PASS);
						count4++;
					}
					i4++;
				}
				i4 = 0;
				j4++;
			}
			System.out.println(count4);
			if (count4 !=3) {
				report.updateTestLog("Verify Loss Information Section",
						"All fields are not present in the Loss Information Section", Status.FAIL);
			} else {
				report.updateTestLog("Verify Loss Information Section",
						"All fields are present in the Loss Information Section", Status.PASS);
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		List<WebElement> systemInformationSectionFields = driver.findElements(By.xpath("//span[text()='System Information']/parent::h3/following-sibling::div//*[contains(@class,'form-element__label')]/span[1]"));
		int count5 = 0, i5 = 0, j5 = 0;
		String fieldsArray5[] = new String[systemInformationSectionFields.size()];
		System.out.println(systemInformationSectionFields.size());
		try {
			systemInformationSectionOpportunityPage();
			while (j5 <systemInformationSectionFields.size()) {
				for (WebElement element5 :systemInformationSectionFields) {
					fieldsArray5[i5] = element5.getText();
					if (fieldsArray5[i5].equalsIgnoreCase(systemInformationSectionValues.get(j5))) {
						System.out.println("Verify System Information Section " + element5.getText());
						report.updateTestLog("Verify System Information Section ",
								element5.getText() + "labels  present in the System Information Section ", Status.PASS);
						count5++;
					}
					i5++;
				}
				i5 = 0;
				j5++;
			}
			System.out.println(count5);
			if (count5 !=2) {
				report.updateTestLog("Verify System Information Section",
						"All fields are not present in the System Information Section", Status.FAIL);
			} else {
				report.updateTestLog("Verify System Information Section",
						"All fields are present in the System Information Section", Status.PASS);
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		systemInformationSectionValues.clear();
		
	}
	static ArrayList<String> relatedListValues = new ArrayList<String>();

	public void opportunityRelatedList() {

		relatedListValues.add("Opportunity Installments");
		relatedListValues.add("Space");
		relatedListValues.add("Activities");
		relatedListValues.add("Contact Roles");
		relatedListValues.add("Notes");
		relatedListValues.add("Files");
	
		System.out.println("The labels for the related list objects are " +relatedListValues);

	}
	public void validateNewOpportunitiesRelatedObjects() {
		Utility_Functions.xWaitForElementPresent(driver, menu_home, 3);
		Utility_Functions.xWaitForElementPresent(driver, menu_Opportunities, 4);
		Utility_Functions.xClick(driver, menu_Opportunities, true);
		Utility_Functions.xWaitForElementPresent(driver, newOpportunity, 3);
		Utility_Functions.xClick(driver, newOpportunity, true);
		Utility_Functions.timeWait(2);
		Utility_Functions.xSwitchtoFrame(driver, continueButton);
		Utility_Functions.xWaitForElementPresent(driver,selectOpportunityRecordType, 3);
		Utility_Functions.xClick(driver,selectOpportunityRecordType, true);
		Utility_Functions.xWaitForElementPresent(driver,opportunityDSFValue, 3);
		Utility_Functions.xClick(driver,opportunityDSFValue, true);
		Utility_Functions.xWaitForElementPresent(driver,continueButton, 3);
		Utility_Functions.xClick(driver,continueButton, true);
		Utility_Functions.timeWait(2);
		driver.switchTo().defaultContent();
		Utility_Functions.timeWait(2);
		Utility_Functions.xWaitForElementPresent(driver,accountNameNewOpportunity, 4);
		/*Utility_Functions.xSendKeys(driver,accountNameNewOpportunity, "Test Automation_0101");
		Utility_Functions.timeWait(1);
		Utility_Functions.xWaitForElementPresent(driver,accountNameNewOpp, 3);
		Utility_Functions.xClick(driver,accountNameNewOpp, true);
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
		Utility_Functions.xWaitForElementPresent(driver,leadSourceNewOpp, 3);
		Utility_Functions.xClick(driver,leadSourceNewOpp, true);
		Utility_Functions.xWaitForElementPresent(driver,leadSourceNewOppValue, 3);
		Utility_Functions.xClick(driver,leadSourceNewOppValue, true);
		Utility_Functions.xWaitForElementPresent(driver,estiamtedGrossFeeCommissionValue, 3);
		Utility_Functions.xSendKeys(driver,estiamtedGrossFeeCommissionValue, dataTable.getData("General_Data", "InstallmentAmount"));
		Utility_Functions.xWaitForElementPresent(driver,estimatedTransactionValue, 3);
		Utility_Functions.xSendKeys(driver,estimatedTransactionValue, dataTable.getData("General_Data", "InstallmentAmount"));
		Utility_Functions.xWaitForElementPresent(driver,saveNewOpp, 3);
		Utility_Functions.xClick(driver,saveNewOpp, true);
		Utility_Functions.timeWait(5);
		Utility_Functions.xWaitForElementPresent(driver,related, 3);
		Utility_Functions.xClick(driver,related, true);
		Utility_Functions.timeWait(2);
		List<WebElement> relatedListObjects = driver.findElements(By.xpath("//h2[@id='header']//span[1]"));
		int count5 = 0, i5 = 0, j5 = 0;
		String fieldsArray5[] = new String[relatedListObjects.size()];
		System.out.println(relatedListObjects.size());
		try {
			opportunityRelatedList();
			while (j5 <relatedListObjects.size()) {
				for (WebElement element5 :relatedListObjects) {
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
		if ((activity.isDisplayed()) && (chatter.isDisplayed()) ) {
			
			report.updateTestLog("Verify Opportunity Related List Object", "Activity and chatter are displayed",
					Status.PASS);
		} else {
			report.updateTestLog("Verify Opportunity Related List Object", "Activity and chatter are not displayed", Status.FAIL);
		}
		activityPage.createNewActivity();
		/*Utility_Functions.xWaitForElementPresent(driver,showMoreActions, 3);
		Utility_Functions.xClick(driver,showMoreActions, true);
		Utility_Functions.xWaitForElementPresent(driver,newTask, 3);
		Utility_Functions.xClick(driver,newTask, true);
		Utility_Functions.xSwitchtoFrame(driver,subjectNewTask);
		Utility_Functions.xWaitForElementPresent(driver,subjectNewTask, 3);
		Utility_Functions.xSendKeys(driver,subjectNewTask,"Test Automation Opportunity_" + Utility_Functions.xGenerateAlphaNumericString());
		Utility_Functions.xWaitForElementPresent(driver, activityType, 3);
		Utility_Functions.xClick(driver, activityType, true);
		Calendar calendar1 = Calendar.getInstance();
		calendar1.add(Calendar.DAY_OF_MONTH, 10);
		SimpleDateFormat dateFormat1 = new SimpleDateFormat("MM/dd/yyyy");
		System.out.println("Date : " + dateFormat1.format(calendar1.getTime()));
		Utility_Functions.xWaitForElementPresent(driver, newActivityDueDate, 3);
		Utility_Functions.xSendKeys(driver, newActivityDueDate, dateFormat1.format(calendar1.getTime()));
		Utility_Functions.xWaitForElementPresent(driver,saveActivity, 3);
		Utility_Functions.xClick(driver,saveActivity, true);*/
	}
	/**
	 * Validating the Opportunities page for Recalculate and new installment button
	 * 
	 * @author Ramya
	 *
	 */
	public void validateRecalculateAndNewInstallment() {
		
		Utility_Functions.xWaitForElementPresent(driver, menu_Opportunities, 4);
		Utility_Functions.xClick(driver, menu_Opportunities, true);
		Utility_Functions.xWaitForElementPresent(driver, newOpportunity, 3);
		Utility_Functions.xClick(driver, newOpportunity, true);
		Utility_Functions.timeWait(2);	
		Utility_Functions.xSwitchtoFrame(driver, continueButton);
		Utility_Functions.xWaitForElementPresent(driver,selectOpportunityRecordType, 3);
		Utility_Functions.xClick(driver,selectOpportunityRecordType, true);
		Utility_Functions.xWaitForElementPresent(driver,opportunityDSFValue, 3);
		Utility_Functions.xClick(driver,opportunityDSFValue, true);
		Utility_Functions.xWaitForElementPresent(driver,continueButton, 3);
		Utility_Functions.xClick(driver,continueButton, true);
		Utility_Functions.timeWait(2);
		driver.switchTo().defaultContent();	
		Utility_Functions.timeWait(2);
		Utility_Functions.xWaitForElementPresent(driver,accountNameNewOpportunity, 4);
		Utility_Functions.xClick(driver, accountNameNewOpportunity, true);
		WebElement firstLookupElement = driver
				.findElement(By.cssSelector("ul>li.forceSearchInputLookupDesktopOption:nth-child(1)"));
		Utility_Functions.xWaitForElementPresent(driver, firstLookupElement, 4);
		Utility_Functions.xClick(driver, firstLookupElement, false);
		/*Utility_Functions.xSendKeys(driver,accountNameNewOpportunity, "Test Automation_0101");
		Utility_Functions.xWaitForElementPresent(driver,accountNameNewOpp, 3);
		Utility_Functions.xClick(driver,accountNameNewOpp, true);*/
		System.out.println(Calendar.getInstance());
		DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
		Date date = new Date();
		Utility_Functions.xWaitForElementPresent(driver, closeDate_AS, 3);
		Utility_Functions.xSendKeys(driver, closeDate_AS, dateFormat.format(date).toString());
		Utility_Functions.xWaitForElementPresent(driver,leadSourceNewOpp, 3);
		Utility_Functions.xClick(driver,leadSourceNewOpp, true);
		Utility_Functions.xWaitForElementPresent(driver,leadSourceNewOppValue, 3);
		Utility_Functions.xClick(driver,leadSourceNewOppValue, true);
		Utility_Functions.xWaitForElementPresent(driver,estiamtedGrossFeeCommissionValue, 3);
		Utility_Functions.xSendKeys(driver,estiamtedGrossFeeCommissionValue, dataTable.getData("General_Data", "InstallmentAmount"));
		Utility_Functions.xWaitForElementPresent(driver,estimatedTransactionValue, 3);
		Utility_Functions.xSendKeys(driver,estimatedTransactionValue, dataTable.getData("General_Data", "InstallmentAmount"));
		Utility_Functions.xWaitForElementPresent(driver,saveNewOpp, 3);
		Utility_Functions.xClick(driver,saveNewOpp, true);
		Utility_Functions.timeWait(5);
		Utility_Functions.xWaitForElementPresent(driver,showMoreActions, 3);
		Utility_Functions.xClick(driver,showMoreActions, true);
		if((recalculate.isDisplayed())&&(newInstallment.isDisplayed())) {

			report.updateTestLog("Verify Recalculate and New Installment", "The Recalculate and new Installment buttons are present", Status.PASS);
		} else {
			report.updateTestLog("Verify Recalculate and New Installment", "The Recalculate and new Installment buttons are not present", Status.FAIL);
		}
}
	/**
	 * Validating the Opportunities creation for the japan users
	 * 
	 * @author Ramya
	 *
	 */
	public void validateOpportunityCreation() {
	
		Utility_Functions.timeWait(2);
		Utility_Functions.xScrollWindow(driver);
		Utility_Functions.timeWait(1);
		Utility_Functions.xWaitForElementPresent(driver, nextForJapan, 4);
		Utility_Functions.xClick(driver,nextForJapan, true);
		Utility_Functions.timeWait(2);
		Utility_Functions.xWaitForElementPresent(driver, menu_Opportunities, 4);
		Utility_Functions.xClick(driver, menu_Opportunities, true);
		Utility_Functions.xWaitForElementPresent(driver, newOpportunity, 3);
		Utility_Functions.xClick(driver, newOpportunity, true);
		Utility_Functions.xSwitchtoFrame(driver, continueButton);
		Utility_Functions.xWaitForElementPresent(driver,selectOpportunityRecordType, 3);
		Utility_Functions.xClick(driver,selectOpportunityRecordType, true);
		Utility_Functions.xWaitForElementPresent(driver,opportunityDSFValue, 3);
		Utility_Functions.xClick(driver,opportunityDSFValue, true);
		Utility_Functions.xWaitForElementPresent(driver,continueButton, 3);
		Utility_Functions.xClick(driver,continueButton, true);
		Utility_Functions.timeWait(2);
		driver.switchTo().defaultContent();
		Utility_Functions.timeWait(2);
		Utility_Functions.xWaitForElementPresent(driver,accountNameNewOpportunity, 4);
		Utility_Functions.xSendKeys(driver,accountNameNewOpportunity, "Test Automation_0101");
		Utility_Functions.xWaitForElementPresent(driver,accountNameNewOpp, 3);
		Utility_Functions.xClick(driver,accountNameNewOpp, true);
		System.out.println(Calendar.getInstance());
		DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
		Date date = new Date();
		Utility_Functions.xWaitForElementPresent(driver, closeDate_AS, 3);
		Utility_Functions.xSendKeys(driver, closeDate_AS, dateFormat.format(date).toString());
		Utility_Functions.xWaitForElementPresent(driver,leadSourceNewOpp, 3);
		Utility_Functions.xClick(driver,leadSourceNewOpp, true);
		Utility_Functions.xWaitForElementPresent(driver,leadSourceNewOppValue, 3);
		Utility_Functions.xClick(driver,leadSourceNewOppValue, true);
		Utility_Functions.xWaitForElementPresent(driver,estiamtedGrossFeeCommissionValue, 3);
		Utility_Functions.xSendKeys(driver,estiamtedGrossFeeCommissionValue, dataTable.getData("General_Data", "InstallmentAmount"));
		Utility_Functions.xWaitForElementPresent(driver,estimatedTransactionValue, 3);
		Utility_Functions.xSendKeys(driver,estimatedTransactionValue, dataTable.getData("General_Data", "InstallmentAmount"));
		Utility_Functions.xWaitForElementPresent(driver,saveNewOpp, 3);
		Utility_Functions.xClick(driver,saveNewOpp, true);
		Utility_Functions.timeWait(3);
		Utility_Functions.xWaitForElementPresent(driver,showMoreActions, 3);
		Utility_Functions.xClick(driver,showMoreActions, true);
		if((recalculate.isDisplayed())&&(newInstallment.isDisplayed())) {

			report.updateTestLog("Verify Recalculate and New Installment", "The Recalculate and new Installment buttons are present", Status.PASS);
		} else {
			report.updateTestLog("Verify Recalculate and New Installment", "The Recalculate and new Installment buttons are not present", Status.FAIL);
		}
}
	/**
	 * Validating the Opportunities APAC DSF for Financial Details for pacific users
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
		Utility_Functions.xWaitForElementPresent(driver,selectOpportunityRecordType, 3);
		Utility_Functions.xClick(driver,selectOpportunityRecordType, true);
		Utility_Functions.xWaitForElementPresent(driver,opportunityDSFValue, 3);
		Utility_Functions.xClick(driver,opportunityDSFValue, true);
		Utility_Functions.xWaitForElementPresent(driver,continueButton, 3);
		Utility_Functions.xClick(driver,continueButton, true);
		Utility_Functions.timeWait(2);
		driver.switchTo().defaultContent();
		Utility_Functions.timeWait(2);
		Utility_Functions.xWaitForElementPresent(driver,accountNameNewOpportunity, 4);
		Utility_Functions.xSendKeys(driver,accountNameNewOpportunity, "Test Automation_0101");
		Utility_Functions.xWaitForElementPresent(driver,accountNameNewOpp, 3);
		Utility_Functions.xClick(driver,accountNameNewOpp, true);
		System.out.println(Calendar.getInstance());
		DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
		Date date = new Date();
		Utility_Functions.xWaitForElementPresent(driver, closeDate_AS, 3);
		Utility_Functions.xSendKeys(driver, closeDate_AS, dateFormat.format(date).toString());
		Utility_Functions.xWaitForElementPresent(driver,leadSourceNewOpp, 3);
		Utility_Functions.xClick(driver,leadSourceNewOpp, true);
		Utility_Functions.xWaitForElementPresent(driver,leadSourceNewOppValue, 3);
		Utility_Functions.xClick(driver,leadSourceNewOppValue, true);
		if((estiamtedGrossFeeCommissionValue.isDisplayed())&& (estimatedTransactionValue.isDisplayed()&& (opportunityCurrency.isDisplayed()))) {

			report.updateTestLog("Verify Opportunities Financial Details", "The Estimated Gross Fee Commission, Estimated Transaction value and the Opportunity Currency are displayed in the financial details section", Status.PASS);
		} else {
			report.updateTestLog("Verify Opportunities Financial Details", "The Estimated Gross Fee Commission, Estimated Transaction value and the Opportunity Currency are not displayed in the financial details section", Status.FAIL);
		}
		Utility_Functions.xWaitForElementPresent(driver,estiamtedGrossFeeCommissionValue, 3);
		Utility_Functions.xSendKeys(driver,estiamtedGrossFeeCommissionValue, dataTable.getData("General_Data", "InstallmentAmount"));
		Utility_Functions.xWaitForElementPresent(driver,estimatedTransactionValue, 3);
		Utility_Functions.xSendKeys(driver,estimatedTransactionValue, dataTable.getData("General_Data", "InstallmentAmount"));
		Utility_Functions.xWaitForElementPresent(driver,saveNewOpp, 3);
		Utility_Functions.xClick(driver,saveNewOpp, true);
		Utility_Functions.timeWait(5);
		if(details.isDisplayed()) {

			report.updateTestLog("Verify Opportunities Financial Details", "The opportunity is saved with all the mandatory fields ", Status.PASS);
		} else {
			report.updateTestLog("Verify Opportunities Financial Details", "The opportunity is not saved with all the mandatory fields", Status.FAIL);
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
		//opportunityDetailsPageHeaders.add("Tagging");
		//opportunityDetailsPageHeaders.add("Related Opportunities");
		opportunityDetailsPageHeaders.add("System Information");

		System.out.println("The sections in the Opportunity Details page are " +opportunityDetailsPageHeaders);

	}
	public void validateOpportunityCreationForProjectManager() {
		Utility_Functions.xWaitForElementPresent(driver, menu_Opportunities, 4);
		Utility_Functions.xClick(driver, menu_Opportunities, true);
		Utility_Functions.xWaitForElementPresent(driver, newOpportunity, 3);
		Utility_Functions.xClick(driver, newOpportunity, true);
		Utility_Functions.timeWait(2);
		Utility_Functions.xWaitForElementPresent(driver,opportunityName_AS, 3);
		Utility_Functions.xClick(driver,opportunityName_AS, true);
		Utility_Functions.xWaitForElementPresent(driver,opportunityName_AS, 3);
		Utility_Functions.xSendKeys(driver,opportunityName_AS,
				"Test Automation Opportunity_" + Utility_Functions.xGenerateAlphaNumericString());
		Utility_Functions.xWaitForElementPresent(driver,accountNameNewOpportunity, 4);
		Utility_Functions.xSendKeys(driver,accountNameNewOpportunity, "Test Automation_0101");
		Utility_Functions.xWaitForElementPresent(driver,accountNameNewOpp, 3);
		Utility_Functions.xClick(driver,accountNameNewOpp, true);
		System.out.println(Calendar.getInstance());
		DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
		Date date = new Date();
		Utility_Functions.xWaitForElementPresent(driver, closeDate_AS, 3);
		Utility_Functions.xSendKeys(driver, closeDate_AS, dateFormat.format(date).toString());
		Calendar calendar1 = Calendar.getInstance();
		calendar1.add(Calendar.DAY_OF_MONTH, -20);
		SimpleDateFormat dateFormat1 = new SimpleDateFormat("MM/dd/yyyy");
		System.out.println("Date : " + dateFormat1.format(calendar1.getTime()));
		Utility_Functions.xWaitForElementPresent(driver,assignmentStartDate, 3);
		Utility_Functions.xSendKeys(driver,assignmentStartDate, dateFormat1.format(calendar1.getTime()));
		Utility_Functions.xWaitForElementPresent(driver,leadSourceNewOpp, 3);
		Utility_Functions.xClick(driver,leadSourceNewOpp, true);
		Utility_Functions.xWaitForElementPresent(driver,leadSourceNewOppValue, 3);
		Utility_Functions.xClick(driver,leadSourceNewOppValue, true);
		Utility_Functions.xWaitForElementPresent(driver,opportunityCBREOffice, 3);
		Utility_Functions.xClick(driver,opportunityCBREOffice, true);
		Utility_Functions.xWaitForElementPresent(driver,opportunityCBREOfficeValue, 3);
		Utility_Functions.xClick(driver,opportunityCBREOfficeValue, true);
		Utility_Functions.xWaitForElementPresent(driver,opportunityCountry, 3);
		Utility_Functions.xClick(driver,opportunityCountry, true);
		Utility_Functions.xWaitForElementPresent(driver,opportunityCountryValue, 3);
		Utility_Functions.xClick(driver,opportunityCountryValue, true);
		Utility_Functions.xWaitForElementPresent(driver,opportunityCity, 3);
		Utility_Functions.xSendKeys(driver,opportunityCity, dataTable.getData("General_Data", "City"));
		Utility_Functions.xWaitForElementPresent(driver,assetType, 3);
		Utility_Functions.xClick(driver,assetType, true);
		Utility_Functions.xWaitForElementPresent(driver,assetTypeValue, 3);
		Utility_Functions.xClick(driver,assetTypeValue, true);
		Utility_Functions.xWaitForElementPresent(driver,selectOpportunityCurrency, 3);
		Utility_Functions.xClick(driver,selectOpportunityCurrency, true);
		Utility_Functions.xWaitForElementPresent(driver,opportunityCurrencyValue, 3);
		Utility_Functions.xClick(driver,opportunityCurrencyValue, true);
		Utility_Functions.xWaitForElementPresent(driver, cityTier, 3);
		Utility_Functions.xClick(driver, cityTier, true);
		Utility_Functions.xWaitForElementPresent(driver, cityTierValue, 3);
		Utility_Functions.xClick(driver, cityTierValue, true);
		Utility_Functions.xWaitForElementPresent(driver,saveNewOpp, 3);
		Utility_Functions.xClick(driver,saveNewOpp, true);
		Utility_Functions.timeWait(5);
		if(details.isDisplayed()) {
			report.updateTestLog("Verify Home Page Tabs", "The opportunity is saved with the all the required fields", Status.PASS);
		} else {
			report.updateTestLog("Verify Home Page Tabs", "The opportunity is not saved with the all the required fields", Status.FAIL);
		}
		List<WebElement> systemInformationSectionFields = driver.findElements(By.xpath("//span[contains(@class,'header-title')]"));
		int count = 0, i = 0, j = 0;
		String fieldsArray[] = new String[systemInformationSectionFields.size()];
		System.out.println(systemInformationSectionFields.size());
		try {
			opportunityDetailsPageSections();
			while (j <systemInformationSectionFields.size()) {
				for (WebElement element :systemInformationSectionFields) {
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
			if (count!=7) {
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
	 * Validating the Opportunities for the System information fields for the APAC Project Manager
	 * 
	 * @author Ramya
	 *
	 */
	public void validateOpportunitySystemInformationFields() {
	Utility_Functions.xWaitForElementPresent(driver, menu_Opportunities, 4);
	Utility_Functions.xClick(driver, menu_Opportunities, true);
	Utility_Functions.xWaitForElementPresent(driver, newOpportunity, 3);
	Utility_Functions.xClick(driver, newOpportunity, true);
	Utility_Functions.timeWait(2);	
	List<WebElement> systemInformationSectionFields = driver.findElements(By.xpath("//span[text()='System Information']/parent::h3/following-sibling::div//*[contains(@class,'form-element__label')]/span[1]"));
	int count5 = 0, i5 = 0, j5 = 0;
	String fieldsArray5[] = new String[systemInformationSectionFields.size()];
	System.out.println(systemInformationSectionFields.size());
	try {
		systemInformationSectionOpportunityPage();
		while (j5 <systemInformationSectionFields.size()) {
			for (WebElement element5 :systemInformationSectionFields) {
				fieldsArray5[i5] = element5.getText();
				if (fieldsArray5[i5].equalsIgnoreCase(systemInformationSectionValues.get(j5))) {
					System.out.println("Verify System Information Section " + element5.getText());
					report.updateTestLog("Verify System Information Section ",
							element5.getText() + "labels  present in the System Information Section ", Status.PASS);
					count5++;
				}
				i5++;
			}
			i5 = 0;
			j5++;
		}
		System.out.println(count5);
		if (count5 !=2) {
			report.updateTestLog("Verify System Information Section",
					"All fields are not present in the System Information Section", Status.FAIL);
		} else {
			report.updateTestLog("Verify System Information Section",
					"All fields are present in the System Information Section", Status.PASS);
		}
	} catch (Exception e) {
		System.out.println(e.getMessage());
	}
	systemInformationSectionValues.clear();
	Utility_Functions.timeWait(2);
	Utility_Functions.xWaitForElementPresent(driver,opportunityName_AS, 3);
	Utility_Functions.xClick(driver,opportunityName_AS, true);
	Utility_Functions.xWaitForElementPresent(driver,opportunityName_AS, 3);
	Utility_Functions.xSendKeys(driver,opportunityName_AS,
			"Test Automation Opportunity_" + Utility_Functions.xGenerateAlphaNumericString());
	Utility_Functions.xWaitForElementPresent(driver,accountNameNewOpportunity, 4);
	Utility_Functions.xSendKeys(driver,accountNameNewOpportunity, "Test Automation_0101");
	Utility_Functions.xWaitForElementPresent(driver,accountNameNewOpp, 3);
	Utility_Functions.xClick(driver,accountNameNewOpp, true);
	System.out.println(Calendar.getInstance());
	DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
	Date date = new Date();
	Utility_Functions.xWaitForElementPresent(driver, closeDate_AS, 3);
	Utility_Functions.xSendKeys(driver, closeDate_AS, dateFormat.format(date).toString());
	Calendar calendar1 = Calendar.getInstance();
	calendar1.add(Calendar.DAY_OF_MONTH, -20);
	SimpleDateFormat dateFormat1 = new SimpleDateFormat("MM/dd/yyyy");
	System.out.println("Date : " + dateFormat1.format(calendar1.getTime()));
	Utility_Functions.xWaitForElementPresent(driver,assignmentStartDate, 3);
	Utility_Functions.xSendKeys(driver,assignmentStartDate, dateFormat1.format(calendar1.getTime()));
	Utility_Functions.xWaitForElementPresent(driver,leadSourceNewOpp, 3);
	Utility_Functions.xClick(driver,leadSourceNewOpp, true);
	Utility_Functions.xWaitForElementPresent(driver,leadSourceNewOppValue, 3);
	Utility_Functions.xClick(driver,leadSourceNewOppValue, true);
	Utility_Functions.xWaitForElementPresent(driver,opportunityCBREOffice, 3);
	Utility_Functions.xClick(driver,opportunityCBREOffice, true);
	Utility_Functions.xWaitForElementPresent(driver,opportunityCBREOfficeValue, 3);
	Utility_Functions.xClick(driver,opportunityCBREOfficeValue, true);
	Utility_Functions.xWaitForElementPresent(driver,opportunityCountry, 3);
	Utility_Functions.xClick(driver,opportunityCountry, true);
	Utility_Functions.xWaitForElementPresent(driver,opportunityCountryValue, 3);
	Utility_Functions.xClick(driver,opportunityCountryValue, true);
	Utility_Functions.xWaitForElementPresent(driver,opportunityCity, 3);
	Utility_Functions.xSendKeys(driver,opportunityCity, dataTable.getData("General_Data", "City"));
	Utility_Functions.xWaitForElementPresent(driver,assetType, 3);
	Utility_Functions.xClick(driver,assetType, true);
	Utility_Functions.xWaitForElementPresent(driver,assetTypeValue, 3);
	Utility_Functions.xClick(driver,assetTypeValue, true);
	Utility_Functions.xWaitForElementPresent(driver,selectOpportunityCurrency, 3);
	Utility_Functions.xClick(driver,selectOpportunityCurrency, true);
	Utility_Functions.xWaitForElementPresent(driver,opportunityCurrencyValue, 3);
	Utility_Functions.xClick(driver,opportunityCurrencyValue, true);
	Utility_Functions.xWaitForElementPresent(driver, cityTier, 3);
	Utility_Functions.xClick(driver, cityTier, true);
	Utility_Functions.xWaitForElementPresent(driver, cityTierValue, 3);
	Utility_Functions.xClick(driver, cityTierValue, true);
	Utility_Functions.xWaitForElementPresent(driver,saveNewOpp, 3);
	Utility_Functions.xClick(driver,saveNewOpp, true);
	Utility_Functions.timeWait(5);
	if(showAll.isDisplayed()){
	Utility_Functions.xWaitForElementPresent(driver,showAll, 3);
	Utility_Functions.xClick(driver,showAll, true);
	if((opportunityFieldHistory.isDisplayed()) && (phaseHistory.isDisplayed())){
		report.updateTestLog("Verify Opportunity Record Sections",
				"All fields are not present in the System Information Section", Status.PASS);
		
	}else{
		report.updateTestLog("Verify Opportunity Record Sections",
				"All fields are not present in the System Information Section", Status.FAIL);
		
	}
	}else{	
		if((opportunityFieldHistory.isDisplayed()) && (phaseHistory.isDisplayed())){
			report.updateTestLog("Verify Opportunity Record Sections",
					"All fields are not present in the System Information Section", Status.PASS);
			
		}else{
			report.updateTestLog("Verify Opportunity Record Sections",
					"All fields are not present in the System Information Section", Status.FAIL);
			
		}
		
	}
	
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
	Utility_Functions.xWaitForElementPresent(driver,accountNameNewOpportunity, 4);
	Utility_Functions.xSendKeys(driver,accountNameNewOpportunity, "Test Automation_0101");
	Utility_Functions.xWaitForElementPresent(driver,accountNameNewOpp, 3);
	Utility_Functions.xClick(driver,accountNameNewOpp, true);
	if((salesStageDefaultValue.isDisplayed())){
		report.updateTestLog("Verify Opportunity Required Fields at Sales Stage 02",
				"Sales stage is populated with default value 02", Status.PASS);
		
	}else{
		report.updateTestLog("Verify Opportunity Required Fields at Sales Stage 02",
				"Sales stage is not populated with default value 02", Status.FAIL);
		
	}	
	System.out.println(Calendar.getInstance());
	DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
	Date date = new Date();
	Utility_Functions.xWaitForElementPresent(driver, closeDate_AS, 3);
	Utility_Functions.xSendKeys(driver, closeDate_AS, dateFormat.format(date).toString());
	Utility_Functions.xWaitForElementPresent(driver,leadSourceNewOpp, 3);
	Utility_Functions.xClick(driver,leadSourceNewOpp, true);
	Utility_Functions.xWaitForElementPresent(driver,leadSourceNewOppValue, 3);
	Utility_Functions.xClick(driver,leadSourceNewOppValue, true);
	Utility_Functions.xWaitForElementPresent(driver,opportunityCBREOffice, 3);
	Utility_Functions.xClick(driver,opportunityCBREOffice, true);
	Utility_Functions.xWaitForElementPresent(driver,opportunityCBREOfficeValue, 3);
	Utility_Functions.xClick(driver,opportunityCBREOfficeValue, true);
	Utility_Functions.xWaitForElementPresent(driver,opportunityCountry, 3);
	Utility_Functions.xClick(driver,opportunityCountry, true);
	Utility_Functions.xWaitForElementPresent(driver,opportunityCountryValue, 3);
	Utility_Functions.xClick(driver,opportunityCountryValue, true);
	Utility_Functions.xWaitForElementPresent(driver,opportunityCity, 3);
	Utility_Functions.xSendKeys(driver,opportunityCity, dataTable.getData("General_Data", "City"));
	Utility_Functions.xWaitForElementPresent(driver,assetType, 3);
	Utility_Functions.xClick(driver,assetType, true);
	Utility_Functions.xWaitForElementPresent(driver,assetTypeValue, 3);
	Utility_Functions.xClick(driver,assetTypeValue, true);
	Utility_Functions.xWaitForElementPresent(driver,selectOpportunityCurrency, 3);
	Utility_Functions.xClick(driver,selectOpportunityCurrency, true);
	Utility_Functions.xWaitForElementPresent(driver,opportunityCurrencyValue, 3);
	Utility_Functions.xClick(driver,opportunityCurrencyValue, true);
	Utility_Functions.xWaitForElementPresent(driver, cityTier, 3);
	Utility_Functions.xClick(driver, cityTier, true);
	Utility_Functions.xWaitForElementPresent(driver, cityTierValue, 3);
	Utility_Functions.xClick(driver, cityTierValue, true);
	Utility_Functions.xWaitForElementPresent(driver,saveNewOpp, 3);
	Utility_Functions.xClick(driver,saveNewOpp, true);
	if(details.isDisplayed()) {
		report.updateTestLog("Verify Required Fields at Sales Stage", "The opportunity is saved with the all the required fields for the sales stage", Status.PASS);
	} else {
		report.updateTestLog("Verify Required Fields at Sales Stage", "The opportunity is not saved with the all the required fields for the sales stage", Status.FAIL);
	}
/*	Utility_Functions.timeWait(5);	
	if((assignmentStartDateMandatory.isDisplayed())){
		report.updateTestLog("Verify Opportunity Required Fields at Sales Stage 02",
				"Assignment start date is required field", Status.PASS);
		
	}else{
		report.updateTestLog("Verify Opportunity Required Fields at Sales Stage 02",
				"Assignment start date is not required field", Status.FAIL);
		
	}
	Calendar calendar1 = Calendar.getInstance();
	calendar1.add(Calendar.DAY_OF_MONTH, -20);
	SimpleDateFormat dateFormat1 = new SimpleDateFormat("MM/dd/yyyy");
	System.out.println("Date : " + dateFormat1.format(calendar1.getTime()));
	Utility_Functions.xWaitForElementPresent(driver,assignmentStartDate, 3);
	Utility_Functions.xSendKeys(driver,assignmentStartDate, dateFormat1.format(calendar1.getTime()));
	Utility_Functions.xWaitForElementPresent(driver,saveNewOpp, 3);
	Utility_Functions.xClick(driver,saveNewOpp, true);*/
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
	Utility_Functions.xWaitForElementPresent(driver,accountNameNewOpportunity, 4);
	Utility_Functions.xClick(driver, accountNameNewOpportunity, true);
	WebElement firstLookupElement = driver.findElement(By.cssSelector("ul>li.forceSearchInputLookupDesktopOption:nth-child(1)"));
	Utility_Functions.xWaitForElementPresent(driver, firstLookupElement, 4);
	Utility_Functions.xClick(driver, firstLookupElement, false);
	/*Utility_Functions.xSendKeys(driver,accountNameNewOpportunity, "Test Automation_0101");
	Utility_Functions.xWaitForElementPresent(driver,accountNameNewOpp, 3);
	Utility_Functions.xClick(driver,accountNameNewOpp, true);*/
	if ((dataTable.getData("General_Data", "TC_ID").contains("APACProjectManagerRequiredFieldsSalesStage07"))){
		Utility_Functions.xWaitForElementPresent(driver,opportunityDetails, 3);
		Utility_Functions.xSendKeys(driver,opportunityDetails, "This is an opportunity");	
	}
	Utility_Functions.xWaitForElementPresent(driver,salesStage_AS, 3);
	Utility_Functions.xClick(driver,salesStage_AS, true);
	if ((dataTable.getData("General_Data", "TC_ID").contains("APACProjectManagerRequiredFieldsSalesStage03"))){
	Utility_Functions.xWaitForElementPresent(driver,salesStageValue03, 3);
	Utility_Functions.xClick(driver,salesStageValue03, true);
	}else if ((dataTable.getData("General_Data", "TC_ID").contains("APACProjectManagerRequiredFieldsSalesStage04"))){
		Utility_Functions.xWaitForElementPresent(driver,salesStageValue04, 3);
		Utility_Functions.xClick(driver,salesStageValue04, true);	
	}else if ((dataTable.getData("General_Data", "TC_ID").contains("APACProjectManagerRequiredFieldsSalesStage06"))){
		Utility_Functions.xWaitForElementPresent(driver,salesStageValue06, 3);
		Utility_Functions.xClick(driver,salesStageValue06, true);	
	}else if ((dataTable.getData("General_Data", "TC_ID").contains("APACProjectManagerRequiredFieldsSalesStage07"))){
		Utility_Functions.xWaitForElementPresent(driver,salesStageValue07, 3);
		Utility_Functions.xClick(driver,salesStageValue07, true);	
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
	Utility_Functions.xWaitForElementPresent(driver,assignmentStartDate, 3);
	Utility_Functions.xSendKeys(driver,assignmentStartDate, dateFormat1.format(calendar1.getTime()));
	Utility_Functions.xWaitForElementPresent(driver,identificationDate, 3);
	Utility_Functions.xSendKeys(driver,identificationDate, dateFormat.format(date).toString());
	Utility_Functions.xWaitForElementPresent(driver,submissionDate, 3);
	Utility_Functions.xSendKeys(driver,submissionDate, dateFormat.format(date).toString());
	Utility_Functions.xWaitForElementPresent(driver,outcomeDate, 3);
	Utility_Functions.xSendKeys(driver,outcomeDate, dateFormat.format(date).toString());
	Utility_Functions.xWaitForElementPresent(driver,completionDate, 3);
	Utility_Functions.xSendKeys(driver,completionDate, dateFormat.format(date).toString());
	Utility_Functions.xWaitForElementPresent(driver,leadSourceNewOpp, 3);
	Utility_Functions.xClick(driver,leadSourceNewOpp, true);
	Utility_Functions.xWaitForElementPresent(driver,leadSourceNewOppValue, 3);
	Utility_Functions.xClick(driver,leadSourceNewOppValue, true);
	Utility_Functions.xWaitForElementPresent(driver,opportunityCBREOffice, 3);
	Utility_Functions.xClick(driver,opportunityCBREOffice, true);
	Utility_Functions.xWaitForElementPresent(driver,opportunityCBREOfficeValue, 3);
	Utility_Functions.xClick(driver,opportunityCBREOfficeValue, true);
	Utility_Functions.xWaitForElementPresent(driver,opportunityCountry, 3);
	Utility_Functions.xClick(driver,opportunityCountry, true);
	Utility_Functions.xWaitForElementPresent(driver,opportunityCountryValue, 3);
	Utility_Functions.xClick(driver,opportunityCountryValue, true);
	Utility_Functions.xWaitForElementPresent(driver,opportunityCity, 3);
	Utility_Functions.xSendKeys(driver,opportunityCity, dataTable.getData("General_Data", "City"));
	Utility_Functions.xWaitForElementPresent(driver,cityTier, 3);
	Utility_Functions.xClick(driver,cityTier, true);
	Utility_Functions.xWaitForElementPresent(driver,cityTierValue, 3);
	Utility_Functions.xClick(driver,cityTierValue, true);
	Utility_Functions.xWaitForElementPresent(driver,assetType, 3);
	Utility_Functions.xClick(driver,assetType, true);
	Utility_Functions.xWaitForElementPresent(driver,assetTypeValue, 3);
	Utility_Functions.xClick(driver,assetTypeValue, true);
	Utility_Functions.xWaitForElementPresent(driver,totalSize_AS, 3);
	Utility_Functions.xSendKeys(driver,totalSize_AS, dataTable.getData("General_Data", "Total Size"));
	Utility_Functions.xWaitForElementPresent(driver,assignmentTypeOpportunity, 3);
	Utility_Functions.xClick(driver,assignmentTypeOpportunity, true);
	Utility_Functions.xWaitForElementPresent(driver,assignmentTypeValueOpportunity, 3);
	Utility_Functions.xClick(driver,assignmentTypeValueOpportunity, true);
/*	Utility_Functions.xWaitForElementPresent(driver,assignmentSubType, 3);
	Utility_Functions.xClick(driver,assignmentSubType, true);
	Utility_Functions.xWaitForElementPresent(driver,assignmentSubTypeValue, 3);
	Utility_Functions.xClick(driver,assignmentSubTypeValue, true);*/
	Utility_Functions.xWaitForElementPresent(driver,constructionType, 3);
	Utility_Functions.xClick(driver,constructionType, true);
	Utility_Functions.xWaitForElementPresent(driver,constructionTypeValue, 3);
	Utility_Functions.xClick(driver,constructionTypeValue, true);
	if ((dataTable.getData("General_Data", "TC_ID").contains("APACProjectManagerRequiredFieldsSalesStage04")||(dataTable.getData("General_Data", "TC_ID").contains("APACProjectManagerRequiredFieldsSalesStage06") ||(dataTable.getData("General_Data", "TC_ID").contains("APACProjectManagerRequiredFieldsSalesStage07"))))) {
		Utility_Functions.xWaitForElementPresent(driver,opportunityLocation, 3);
		Utility_Functions.xSendKeys(driver,opportunityLocation, dataTable.getData("General_Data", "City"));
	}
	Utility_Functions.xWaitForElementPresent(driver,siteArea, 3);
	Utility_Functions.xSendKeys(driver,siteArea, dataTable.getData("General_Data", "InstallmentAmount"));
	Utility_Functions.xWaitForElementPresent(driver,assignmentTypeOpportunity, 3);
	Utility_Functions.xWaitForElementPresent(driver,selectOpportunityCurrency, 3);
	Utility_Functions.xClick(driver,selectOpportunityCurrency, true);
	Utility_Functions.xWaitForElementPresent(driver,opportunityCurrencyValue, 3);
	Utility_Functions.xClick(driver,opportunityCurrencyValue, true);
	Utility_Functions.xWaitForElementPresent(driver,projectValue, 3);
	Utility_Functions.xSendKeys(driver,projectValue, dataTable.getData("General_Data", "Project Value"));
	Utility_Functions.xWaitForElementPresent(driver,consultancyFee, 3);
	Utility_Functions.xSendKeys(driver,consultancyFee, dataTable.getData("General_Data", "Consultancy Fee"));
	Utility_Functions.xWaitForElementPresent(driver,saveNewOpp, 3);
	Utility_Functions.xClick(driver,saveNewOpp, true);
	Utility_Functions.timeWait(5);	
	if(details.isDisplayed()) {

		report.updateTestLog("Verify Required Fields at Sales Stage", "The opportunity is saved with the all the required fields for the sales stage", Status.PASS);
	} else {
		report.updateTestLog("Verify Required Fields at Sales Stage", "The opportunity is not saved with the all the required fields for the sales stage", Status.FAIL);
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
	Utility_Functions.xWaitForElementPresent(driver,selectOpportunityRecordType, 3);
	Utility_Functions.xClick(driver,selectOpportunityRecordType, true);
	Utility_Functions.xWaitForElementPresent(driver,opportunityDSFValue, 3);
	Utility_Functions.xClick(driver,opportunityDSFValue, true);
	Utility_Functions.xWaitForElementPresent(driver,continueButton, 3);
	Utility_Functions.xClick(driver,continueButton, true);
	Utility_Functions.timeWait(2);
	driver.switchTo().defaultContent();
	Utility_Functions.xWaitForElementPresent(driver,accountNameNewOpportunity, 4);
	Utility_Functions.xSendKeys(driver,accountNameNewOpportunity, "Test Automation_0101");
	Utility_Functions.xWaitForElementPresent(driver,accountNameNewOpp, 3);
	Utility_Functions.xClick(driver,accountNameNewOpp, true);
	Utility_Functions.xWaitForElementPresent(driver,leadSourceNewOpp, 3);
	Utility_Functions.xClick(driver,leadSourceNewOpp, true);
	Utility_Functions.xWaitForElementPresent(driver,leadSourceNewOppValue, 3);
	Utility_Functions.xClick(driver,leadSourceNewOppValue, true);
	System.out.println(Calendar.getInstance());
	DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
	Date date = new Date();
	Utility_Functions.xWaitForElementPresent(driver, closeDate_AS, 3);
	Utility_Functions.xSendKeys(driver, closeDate_AS, dateFormat.format(date).toString());
	Utility_Functions.xWaitForElementPresent(driver,estiamtedGrossFeeCommissionValue, 3);
	Utility_Functions.xSendKeys(driver,estiamtedGrossFeeCommissionValue, dataTable.getData("General_Data", "InstallmentAmount"));
	Utility_Functions.xWaitForElementPresent(driver,estimatedTransactionValue, 3);
	Utility_Functions.xSendKeys(driver,estimatedTransactionValue, dataTable.getData("General_Data", "InstallmentAmount"));
	Utility_Functions.xWaitForElementPresent(driver,saveNewOpp, 3);
	Utility_Functions.xClick(driver,saveNewOpp, true);
	Utility_Functions.timeWait(3);
}
	 public void opportunityTagging () {
			
			Utility_Functions.xClick(driver, menu_Opportunities, true);
			Utility_Functions.timeWait(2);
			Utility_Functions.xClick(driver, recentlyViewed, true);
			Utility_Functions.timeWait(2);
			Utility_Functions.xClick(driver, allActiveOpportunities, true);
			Utility_Functions.timeWait(2);
			Utility_Functions.xClick(driver, OpportunityList, true);
			Utility_Functions.timeWait(2);
			
		
			 Utility_Functions.xSwitchtoFrame(driver, addTag);
			 	Utility_Functions.xClick(driver, addTag, true);
			      Utility_Functions.timeWait(2);

			Utility_Functions.xSendKeys(driver, privatetag, dataTable.getData("General_Data", "Private Tag"));
			 Utility_Functions.xClickHiddenElement(driver, savePrivateTag);
			Utility_Functions.timeWait(5);
			
			if(addTag.isDisplayed()){
				report.updateTestLog("Verify Opportunity Private Tags", "The Private Tag is saved",
						Status.PASS);		
			}else{
				report.updateTestLog("Verify Opportunity Private Tags", "The Private tag is not saved",
						Status.FAIL);
		}
			
			Utility_Functions.xClick(driver, PrivateTagged, true);
		      Utility_Functions.timeWait(8);
		    Utility_Functions.xSwitchtoFrame(driver, PrivateTagPage);
			
		      if(PrivateTagPage.isDisplayed()){
					report.updateTestLog("Verify Opportunity Private Tags", "The Tag is saved in Private Tag Page",
							Status.PASS);		
				}else{
					report.updateTestLog("Verify Opportunity Private Tags", "The Tag is not saved in Private Tag Page",
							Status.FAIL);
			}
		      System.out.println("Current URL is--" +driver.getCurrentUrl());
	}
	 
	 public void installmentsOpportunityUpdate() {
			multipleInstallmentsFunction();
			/*
			 * Utility_Functions.xWaitForElementPresent(driver, showMoreActions, 2);
			 * Utility_Functions.xClick(driver, showMoreActions, true);
			 * Utility_Functions.timeWait(1);
			 * Utility_Functions.xWaitForElementPresent(driver, recalculate, 2);
			 * Utility_Functions.xClick(driver, recalculate, true);
			 * Utility_Functions.xSwitchtoFrame(driver, installmentQuantity);
			 * Utility_Functions.xWaitForElementPresent(driver, installmentQuantity,
			 * 3); installmentQuantity.clear(); Utility_Functions.xSendKeys(driver,
			 * installmentQuantity, "2");
			 * Utility_Functions.xWaitForElementPresent(driver, proceed, 3);
			 * Utility_Functions.xClick(driver, proceed, true);
			 * Utility_Functions.xWaitForElementPresent(driver,
			 * continueButtonInstallment, 3); Utility_Functions.xClick(driver,
			 * continueButtonInstallment, true); driver.switchTo().defaultContent();
			 */
			addingInstallmentsOpportunities();
			Utility_Functions.xWaitForElementPresent(driver, related, 4);
			Utility_Functions.xClick(driver, related, true);
			Utility_Functions.xWaitForElementPresent(driver, installmentsViewAll, 3);
			Utility_Functions.xClick(driver, installmentsViewAll, true);
			Utility_Functions.xWaitForElementPresent(driver, opportunityNameLink, 3);
			Utility_Functions.xClick(driver, opportunityNameLink, true);
			Utility_Functions.xWaitForElementPresent(driver, related, 3);
			Utility_Functions.xClick(driver, related, true);
	 }
	
		
		 public void opportunityTeamMember() {
			 Utility_Functions.xWaitForElementPresent(driver, menu_Opportunities, 3);
				Utility_Functions.xClick(driver, menu_Opportunities, true);
				Utility_Functions.xWaitForElementPresent(driver, opportunitiesList, 3);
				Utility_Functions.xclickgetTextofFirstElementfromList(opportunitiesList);
				Utility_Functions.timeWait(5);
				Utility_Functions.xClick(driver, editButton, true);
				Utility_Functions.timeWait(4);
				Utility_Functions.xScrollWindowToElement(driver, estimatedGrossFeeField);
				Utility_Functions.timeWait(3);
				Utility_Functions.xClick(driver, estimatedGrossFeeField, true);
				Utility_Functions.timeWait(4);
				Utility_Functions.xSendKeys(driver, estimatedGrossFeeField, "10,000.00");
				Utility_Functions.timeWait(3);
				Utility_Functions.xClick(driver, save, true);
				Utility_Functions.timeWait(3);
				Utility_Functions.xClick(driver, related, true);
				Utility_Functions.timeWait(5);
				Utility_Functions.xClick(driver, addButtonshareOpportunity, true);
				Utility_Functions.timeWait(3);
				Utility_Functions.xSwitchtoFrame(driver, SearchUserTeamRole);
				Utility_Functions.xClickHiddenElement(driver, SearchUserTeamRole);
				Utility_Functions.xSendKeys(driver, user1, "Inactive User");
				Utility_Functions.timeWait(1);
				user1.sendKeys(Keys.ARROW_DOWN);
				user1.sendKeys(Keys.ENTER);
				Utility_Functions.xClick(driver, selectTeamRole, true);
				Utility_Functions.timeWait(3);
				Utility_Functions.xClick(driver, selectSecondaryMemberRole, true);
				Utility_Functions.timeWait(3);
				Utility_Functions.xClick(driver, selectOpportunityAccess, true);
				Utility_Functions.timeWait(3);
				Utility_Functions.xClick(driver, saveButtonSplit, true);
				Utility_Functions.timeWait(3);
			
			}
		 
		 public void opportunitySplit() {
			 
			 Utility_Functions.xWaitForElementPresent(driver, menu_Opportunities, 3);
				Utility_Functions.xClick(driver, menu_Opportunities, true);
				Utility_Functions.xWaitForElementPresent(driver, opportunitiesList, 3);
				Utility_Functions.xclickgetTextofFirstElementfromList(opportunitiesList);
				Utility_Functions.timeWait(5);
				Utility_Functions.xClick(driver, editButton, true);
				Utility_Functions.timeWait(4);
				Utility_Functions.xScrollWindowToElement(driver, estimatedGrossFeeField);
				Utility_Functions.timeWait(3);
				Utility_Functions.xClick(driver, estimatedGrossFeeField, true);
				Utility_Functions.timeWait(4);
				Utility_Functions.xSendKeys(driver, estimatedGrossFeeField, "10,000.00");
				Utility_Functions.timeWait(3);
				Utility_Functions.xClick(driver, save, true);
				Utility_Functions.timeWait(3);
				Utility_Functions.xClick(driver, related, true);
				Utility_Functions.timeWait(5);
				Utility_Functions.xClick(driver, addButtonshareOpportunity, true);
				Utility_Functions.timeWait(3);
				Utility_Functions.xSwitchtoFrame(driver, SearchUserTeamRole);
				Utility_Functions.xClickHiddenElement(driver, SearchUserTeamRole);
				Utility_Functions.xSendKeys(driver, user1, "Inactive User");
				Utility_Functions.timeWait(1);
				user1.sendKeys(Keys.ARROW_DOWN);
				user1.sendKeys(Keys.ENTER);
				Utility_Functions.xClick(driver, selectTeamRole, true);
				Utility_Functions.timeWait(3);
				//Utility_Functions.xClick(driver, selectSecondaryMemberRole, true);
				Utility_Functions.timeWait(3);
				Utility_Functions.xClick(driver, selectOpportunityAccess, true);
				Utility_Functions.timeWait(3);
				Utility_Functions.xSendKeys(driver, user2, "Test Broker1");
				Utility_Functions.timeWait(2);
				user2.sendKeys(Keys.ARROW_DOWN);
				user2.sendKeys(Keys.ENTER);
				Utility_Functions.xClick(driver, selectTeamRole2, true);
				Utility_Functions.timeWait(3);
				//Utility_Functions.xClick(driver, selectSecondaryMemberRole2, true);
				Utility_Functions.timeWait(3);
				Utility_Functions.xClick(driver, saveButtonSplit, true);
				Utility_Functions.timeWait(3);
				driver.navigate().refresh();
				Utility_Functions.timeWait(1);
				driver.switchTo().defaultContent();
				driver.navigate().refresh();
				Utility_Functions.xWaitForElementVisible(driver, manageOpportunitySplits, 3);
				Utility_Functions.xClick(driver, manageOpportunitySplits, true);
				Utility_Functions.timeWait(4);
				driver.switchTo().frame(driver.findElement(By.xpath("//iframe")));
				splitPercent.clear();
				Utility_Functions.timeWait(3);
				splitPercent.sendKeys("100");
				try {
					Utility_Functions.xClick(driver, saveOpportunitySplit, true);
				} catch (Exception e) {
					Utility_Functions.xClick(driver, saveOpportunitySplitUAT, true);
				}
				report.updateTestLog("Opportunity Saved", "Opportunity Saved successfully::", Status.PASS);
				Utility_Functions.timeWait(3);
			 
			 
		 }

			
			
			 
	 
}

