package pageObjects;


import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Random;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.cognizant.Craft.ReusableLibrary;
import com.cognizant.Craft.ScriptHelper;
import com.cognizant.framework.Status;
import com.sforce.soap.partner.SaveResult;
import pagesAPI.AccountsFunctions;
import pagesAPI.EstablishConnection;
import pagesAPI.LeadsFunctions;
import pagesAPI.SearchTextSOQL;
import supportLibraries.SF_UtilityFunctions;
import supportLibraries.Utility_Functions;
import pagesAPI.TaskEventsFunctions;


/**
 * Page Object Class for Leads Page
 * 
 * @author Vishnuvardhan
 *
 */

public class LeadsPage extends ReusableLibrary {
	/*
	 * Constructor to initialize the business component library
	 * 
	 * @param scriptHelper The {@link ScriptHelper} object passed from the
	 * {@link DriverScript}
	 */
	public LeadsPage(ScriptHelper scriptHelper) {
		super(scriptHelper);
		PageFactory.initElements(driver.getWebDriver(), this);
		// new WebDriverUtil(driver);
		// Utility_Functions utility = new Utility_Functions(scriptHelper);
	}

	@FindBy(xpath = "//div[@class='bBottom']//span[text()='Home']")
	WebElement menu_Home;

	@FindBy(xpath = "//div[@class='bBottom']//span[text()='Leads']")
	WebElement leads;
	
	@FindBy(xpath = "//div[@class='overflowList']//a[@title='Properties'][text()='Properties']")
	WebElement leadsEnv;
	
	@FindBy(xpath = "//div[contains(@class,'header__title') and @title='Lead' and text()='Select Lead Record Type']")
	WebElement leadInformationFrame;
	
	@FindBy(xpath = "//span[text()='Name']/ancestor::thead/following-sibling::tbody//th//a")
	WebElement allLeadNames;

	@FindBy(xpath = "//div[@title='New']")
	WebElement newButton;	

	@FindBy(xpath = "//button[@title='Dismiss notification']")
	WebElement dismissNotification;	

	@FindBy(xpath = "//*[@id='record-type-select']")
	WebElement leadRecordTypeSelection;	

	@FindBy(xpath = "//button[text()='Continue']")
	WebElement continueButton;	

	@FindBy(xpath = "//select[contains(@id,'record-type-select')]/option[text()='Agency Brokerage']")
	WebElement agencyBroker;	

	@FindBy(xpath = "//select[contains(@id,'record-type-select')]/option[text()='Capital Markets']")
	WebElement capitalMarkets;	

	@FindBy(xpath = "//select[contains(@id,'record-type-select')]/option[text()='Occupier Brokerage']")
	WebElement occupierBrokerage;	
	
	@FindBy(xpath = "//select[contains(@id,'record-type-select')]")
	WebElement selectRecordType;

	@FindBy(xpath = "//span[text()='Address']/parent::div/parent::div//span[contains(@class,'test-id__field-value')]")
	WebElement addressDetails;	

	@FindBy(xpath = "//span[contains(text(), 'Direct Line')]/parent::div/parent::div//span[contains(@class,'test-id__field-value')]")
	WebElement directLine;	

	@FindBy(xpath = "//button[contains(@title,'Edit') and contains(@title,'Direct') and contains(@title,'Line')]")
	WebElement directLineEditButton;	


	@FindBy(xpath = "//span[text()='Direct Line']/parent::label/parent::div/input[@type='tel']")
	WebElement enterDirectLIne;	

	@FindBy(xpath = "//span[@class='uiOutputEmail']/parent::p/parent::li/p[contains(text(), 'Email')]")
	WebElement email;	

	@FindBy(xpath = "//div[@title='Convert']")
	WebElement convert;		

	@FindBy(xpath = "//p[@title='Convert Lead Title']")
	WebElement convertLeadTitle;		

	@FindBy(xpath = "//span[contains(@class,'form-element__label')]/span[text()='Converted Status']/ancestor::div[contains(@class,'uiInput')]//a[@role='button']")
	WebElement convertedStatus;	

	@FindBy(xpath = "//input[contains(@id,'CustomLeadConversionFrom:accname')]")
	WebElement accountName;	

	@FindBy(xpath = "//input[contains(@id,'CustomLeadConversionFrom:OwnerName']")
	WebElement recordOwner;	

	@FindBy(xpath = "//label/span[text()='First Name']/following::input[1]")
	WebElement firstName;
	
	@FindBy(xpath = "//label/span[text()='Last Name']/following::input[1]")
	WebElement lastName;
	
	@FindBy(xpath = "//label/span[text()='Company']/following::input[1]")
	WebElement company;	

	@FindBy(xpath = "(//button/span[text()='Save'])[2]")
	WebElement saveButton;
	
	@FindBy(xpath = "//p[text()='Lead']/parent::div/h1/span")
	WebElement leadNameTitle;

	@FindBy(xpath = "//h1[@class='slds-page-header__title slds-m-right--small slds-truncate slds-align-middle']")
	WebElement headerLead;

	@FindBy(xpath = "//a[@class='tabHeader']//span[text()='Related']")
	WebElement related;
	
	@FindBy(xpath = "//a[@title='Other Related'][text()='Other Related']")
	WebElement otherRelated;
	
	@FindBy(xpath = "//a[@role='button']/span[text()='More']")
	WebElement more;

	@FindBy(xpath = "//span[contains(@class,'form-element__label')]/span[text()='Lead Source']/ancestor::div[contains(@class,'uiInput')]//a[@role='button']")
	WebElement leadSource;

	@FindBy(xpath = "//span[contains(@class,'form-element__label')]/span[text()='Lead Status']/ancestor::div[contains(@class,'uiInput')]//a[@role='button']")
	WebElement leadStatusField;

	@FindBy(xpath = "//label/span[text()='Direct Line']/following::input[1]")
	WebElement directLineLead;

	@FindBy(xpath = "//label/span[text()='Record Owner']/parent::label/following-sibling::div")
	WebElement recordOwnerText;	

	@FindBy(xpath = "//input[contains(@id,'acc_id')]")
	WebElement accountNameConvert;	

	@FindBy(xpath = "//div[@class='tt-dataset-acc_idTypeahead']//div[1]/p")
	WebElement accountNames;

	@FindBy(xpath = "//div[@class='dataCol readonly slds-no-space']//div[@class='map forceOutputAddressText']")
	WebElement addressMap;

	@FindBy(xpath = "//*[contains(@id,'CustomLeadConversionFrom')]/section/section/div[2]/div/div[3]/div/div/a/img")
	WebElement accountNameSearch;

	@FindBy(xpath = "//span[@class='slds-icon_container slds-icon-utility-down slds-button__icon forceIcon']")
	WebElement showMoreActions;

	@FindBy(xpath = "//div[contains(@class,'actionsContainer') and contains(@class,'slds-grid slds-align-middle')]//a[@title='Edit']")
	WebElement editButton;

	@FindBy(xpath = "//label[@class='uiLabel-top form-element__label uiLabel']/span[text()='First Name']/parent::label/parent::div/input")
	WebElement editFirstName;

	@FindBy(xpath = "//button[@class='slds-button slds-button--neutral uiButton--default uiButton--brand uiButton forceActionButton']")
	WebElement editSaveButton;

	@FindBy(xpath = "//h1//span[@class='uiOutputText']")
	WebElement nameText;
	/*
	@FindBy(xpath = "//li[contains(@class,'slds-button') and contains(@class,'slds-button--neutral') and contains(@class,'slds-truncate')]//a[@title='Clone']")
	WebElement cloneButton;*/

	@FindBy(xpath = "//div[@class='slds-truncate'][@title='Clone']")
	WebElement cloneButton;

	@FindBy(xpath = "//button[@class='slds-button slds-button--neutral uiButton forceActionButton'][@title='Save & New']")
	WebElement cloneSaveNewButton;

	/*	@FindBy(xpath = "//li/parent::ul/parent::div/parent::div/parent::div/header/div[2]/h2/a/span[text()='Private Notes']/parent::a/parent::h2/parent::div/parent::header/parent::div//ul[@class='slds-button-group slds-m-left--xx-small small oneActionsRibbon forceActionsContainer']")
	WebElement new_PrivateNotes;*/

	/*	@FindBy(xpath = "//article[contains(@class,'Private Notes')]//div[@title='New']")
	WebElement new_PrivateNotes;*/

	@FindBy(xpath = "//span[contains(text(),'Private Notes')]/ancestor::article//div[text()='New']")
	WebElement new_PrivateNotes;

	@FindBy(xpath = "//div[@class='forceChangeRecordTypeFooter']//span[text()='Next']")
	WebElement next_PrivateNotes;

	@FindBy(xpath = "//div[@class='contentWrapper slds-box--border']//ul[@class='orderedList']//span[@class='pillText']")
	WebElement lead_PrivateNotes;

	@FindBy(xpath = "//label[@class='label inputLabel uiLabel-left form-element__label uiLabel']/span[contains(text(), 'Title')]/parent::label/parent::div/input")
	WebElement title_PrivateNotes;

	@FindBy(xpath = "//input[@title='Search Contacts']")
	WebElement searchContacts;

	@FindBy(xpath = "//label[@class='label inputLabel uiLabel-left form-element__label uiLabel']/span[contains(text(), 'Body')]/parent::label/parent::div/textarea")
	WebElement body;

	@FindBy(xpath = "//span[@class='toastMessage slds-text-heading--small forceActionsText'][contains(text(), 'was created.')]")
	WebElement wasCreated;	

	@FindBy(xpath = "//button[@class='slds-button slds-button--neutral uiButton--default uiButton--brand uiButton forceActionButton']/span[text()='Save']")
	WebElement savePrivateNote;

	@FindBy(xpath = "//*[text()='Street']/parent::div/div/div/textarea")
	WebElement streetField;

	@FindBy(xpath = "//*[contains(@id,'CustomLeadConversionFrom:country')]")
	WebElement countryField;

	@FindBy(xpath = "//*[contains(@id,'CustomLeadConversionFrom:state')]")
	WebElement stateField;	

	@FindBy(xpath = "//*[contains(@id,'CustomLeadConversionFrom:city')]")
	WebElement cityField;

	@FindBy(xpath = "//*[text()='Zip/Postal Code']/parent::div/div/div/input")
	WebElement zipCodeField;

	@FindBy(xpath = ".//*[contains(@id,'CustomLeadConversionFrom')]//input[@value='Convert']")
	WebElement convertButton;

	@FindBy(xpath = "//div[@title='Convert']")
	WebElement saveConvertButton;

	@FindBy(xpath = "//h1//span[text()='Recently Viewed']")
	WebElement recentlyViewed;

	@FindBy(xpath = "//span[contains(@class,'virtualAutocompleteOptionText')][text()='All Leads']")
	WebElement allLeadsMenu;

	@FindBy(xpath="//span[contains(@class, 'slds-text-heading--small slds-truncate') and text() = 'Files']")
	WebElement files;

	@FindBy(xpath="//div[@title='Add File']")
	WebElement addFile;

	@FindBy(xpath="//a[@title='Recent']")
	WebElement recentFile;

	@FindBy(xpath="//div[@class='filerow']")
	WebElement addFileAttachment;

	@FindBy(xpath=".//*[text()='Add']")
	WebElement add;

	@FindBy(xpath="//span[contains(text(),'Related Contacts')]")
	WebElement accountsRelatedContacts;

	@FindBy(xpath="//span[contains(@class, 'slds-text-heading--small slds-truncate') and text() = 'Contacts']")
	WebElement accountsContacts;

	@FindBy(xpath="//span[contains(@class, 'slds-text-heading--small slds-truncate') and text() = 'Opportunities']")
	WebElement accountsRelatedOpportunities;

	@FindBy(xpath="//[contains(@id='CustomLeadConversionFrom')]//a/img")
	WebElement accName;

	@FindBy(xpath="//a[contains(@title,'Show') and contains(@title,'more action')]")
	WebElement selectNewEvent;

	@FindBy(xpath="//div[@id='activityPanelContainer']//span[text()='New Event']")
	WebElement newEvent;

	@FindBy(xpath="//div[@class='slds-media__body']")
	WebElement addAnEventPage;

	@FindBy(xpath="//input[@class='slds-input'][@type='text'][@required='required']")
	WebElement subject;

	@FindBy(xpath="//*[@id='assignedToBox']")
	WebElement assignedTo;

	@FindBy(xpath="//input[@value='Cancel']")
	WebElement cancelCustomEventPageButton;

	@FindBy(xpath="//input[@value='Save & New Event']")
	WebElement saveAndNewEventCustomEventPageButton;

	@FindBy(xpath="//input[@value='Save Event']")
	WebElement saveEventCustomEventPageButton;

	@FindBy(xpath="//span[text()='Quick Create an Event']")
	WebElement quickCreateanEvent;

	@FindBy(xpath=" //div[@class='slds-col--padded slds-size--1-of-1 slds-medium-size--1-of-1 slds-large-size--1-of-2']/h2")
	WebElement relatedTo;

	@FindBy(xpath="//input[@class='slds-input'][@type='checkbox']")
	WebElement setReminderCheckBox;

	@FindBy(xpath=".//*[@id='assignedToBox']")
	WebElement assignedToNewCustomEventPage;

	@FindBy(xpath="//input[contains(@id,'StartDate')]")
	WebElement startDateNewCustomEventPage;

	@FindBy(xpath="//input[contains(@id,'StartTime')]")
	WebElement startTimeNewCustomEventPage;

	@FindBy(xpath="//input[contains(@id,'EndDate')]")
	WebElement endDateNewCustomEventPage;

	@FindBy(xpath="//input[contains(@id,'EndTime')]")
	WebElement endTimeNewCustomEventPage;

	@FindBy(xpath = "//div[@class='changeRecordTypeOptionRightColumn']/span[text()='Personal Information']/parent::div/parent::label/div[1]/span")
	WebElement selectPersonalInformation;

	@FindBy(xpath = "//button[@class='slds-button slds-button--neutral uiButton--default uiButton--brand uiButton']/span[contains(text(), 'Next')]")
	WebElement next;

	@FindBy(xpath = "//label[@class='label inputLabel uiLabel-left form-element__label uiLabel']/span[contains(text(),'Title')]/parent::label/parent::div/input")
	WebElement titleName;

	@FindBy(xpath = "//span[text()='Private Notes']/parent::span[@class='view-all-label']")
	WebElement viewAllButton;

	@FindBy(xpath = "//div[@class='contentWrapper slds-box--border']//ul[@class='orderedList']//span[@class='pillText']")
	WebElement account_PrivateNotes;

	@FindBy(xpath=" //button[@class='slds-button slds-button--neutral uiButton--default uiButton--brand uiButton forceActionButton']/span[contains(text(), 'Save')]")
	WebElement savePersonalInformation;

	@FindBy(xpath="//a[@title='New']/div[text()='New']")
	WebElement newLeads;

	@FindBy(xpath="//input[@value='Save']")
	WebElement saveLead;

	@FindBy(xpath = "//button/span[text()='View All Fields']")
	WebElement viewAllFieldsButton;

	@FindBy(xpath="//a[@class='tabHeader']//span[text()='Details']")
	WebElement leadCreated;

	@FindBy(xpath="//label[text()='Requirement Details']/parent::div/parent::div//div[2]/label")
	WebElement leadStatus;

	@FindBy(xpath="//label[text()='Requirement Details']/parent::div/parent::div//div[3]/label")
	WebElement leadSourceField;

	@FindBy(xpath="//textarea[contains(@id,'CustomLeadConversionFrom')]")
	WebElement convertLeadStreet;

	@FindBy(xpath="//select[contains(@id,'CustomLeadConversionFrom:country')]")
	WebElement convertLeadCountry;

	@FindBy(xpath="//select[contains(@id,'CustomLeadConversionFrom:country')]/option[text()='United States']")
	WebElement selectConvertLeadCountry;

	@FindBy(xpath="//input[contains(@id,'CustomLeadConversionFrom:city')]")
	WebElement convertLeadCity;

	@FindBy(xpath="//select[contains(@id,'CustomLeadConversionFrom:state')]")
	WebElement convertLeadState;

	@FindBy(xpath="//select[contains(@id,'CustomLeadConversionFrom:state')]/option[text()='Texas']")
	WebElement selectConvertLeadState;

	@FindBy(xpath="//input[@type='checkbox']")
	WebElement convertLeadNewOpportunityCheckBox;

	@FindBy(xpath="//label[text()='Preferred Property Type']/parent::div/div//select")
	WebElement selectPreferedPropertyType;

	@FindBy(xpath="//label[text()='Preferred Property Type']/parent::div/div//select[contains(@id,'LeadForm')]/option[@value='Hotel']")
	WebElement selectPreferedPropertyTypeValue;

	@FindBy(xpath="//select[contains(@id,'LeadForm:propertySubTypeInput_unselected')]//option[1]")
	WebElement selectPreferedPropertySubTypeValue;

	@FindBy(xpath="//td[@class='multiSelectPicklistCell']/a[@title='Add']")
	WebElement addValuetoCheckList;

	@FindBy(xpath="//h2[@id='header']/a/span[text()='Private Notes'] ")
	WebElement privateNotes;

	@FindBy(xpath="//label/span[text()='Email']/following::input[1]")
	WebElement emailLead;

	@FindBy(xpath="//li[contains(@class,'oneActionsDropDown')]//a")
	WebElement showMoreActionsDetailsPage;

	@FindBy(xpath="//div[contains(@class,'actionMenu')]//a[@title='Sharing']")
	WebElement sharing;
	
	@FindBy(xpath="//a[@class='forceActionLink'][@title='Sharing']/div[text()='Sharing']")
	WebElement privateNoteSharing;	

	@FindBy(xpath = "//p[text()='Lead Sharing']")
	WebElement leadSharing;

	@FindBy(xpath="//div[@class='bFilterView']/span[@class='bFilter']/label")
	WebElement viewElement;

	@FindBy(xpath="//div[@class='pbHeader']//td[@class='pbTitle']/h3")
	WebElement userAndGroupSharing;

	@FindBy(xpath="//input[@value='Done']")
	WebElement done;

	@FindBy(xpath="//input[contains(@value,'Add')]")
	WebElement addSharingPage;

	@FindBy(xpath="//div[contains(@class,'actionMenu')]//a[@title='Log A Call']")
	WebElement logACall;

	@FindBy(xpath="//input[contains(@id,'subject_top')]")
	WebElement subjectTop;

	@FindBy(xpath="//select[contains(@id,'activityType_top')]/option[@value='Private - Task']")
	WebElement activityTop;

	@FindBy(xpath="//input[contains(@id,'subject_btm')]")
	WebElement subjectBottom;

	@FindBy(xpath="//select[contains(@id,'activityType_btm')]/option[@value='Private - Follow-Up Task']")
	WebElement activityBottom;

	@FindBy(xpath="//input[contains(@id,'saveButton')]")
	WebElement saveLogCall;

	@FindBy(xpath="//input[contains(@id,'dueDate')]")
	WebElement newActivityDueDate;

	@FindBy(xpath = "//p[@class='slds-tile__title slds-truncate']/a/parent::p/parent::div/parent::div//div[2]")
	WebElement activityType;

	@FindBy(xpath = "//p[@class='slds-tile__title slds-truncate']/a/parent::p/parent::div/parent::div//div[3]")
	WebElement statusActivityTimeLine;

	@FindBy(xpath = "//p[@class='slds-tile__title slds-truncate']/a/parent::p/parent::div/parent::div//div[4]")
	WebElement comments;

	@FindBy(xpath = "//div[@class='slds-media']//p[@class='slds-timeline__date']")
	WebElement dueDate;

	@FindBy(xpath = "//span[@class='slds-checkbox--faux']")
	WebElement statusCheckbox;

	@FindBy(xpath = "//*[text()='No Next Steps. Open And Upcoming Activities Show Up Here.']")
	WebElement activityTimeline;

	@FindBy(xpath = "//p[@class='slds-tile__title slds-truncate']/a")
	WebElement activity;

	@FindBy(xpath="//button[@title='Past Activity']")
	WebElement pastActivity;

	@FindBy(xpath="//button[@title='More Activities']")
	WebElement moreActivities;

	@FindBy(xpath="//a[@class='tabHeader']/span[text()='Activity']")
	WebElement activityTab; 

	@FindBy(xpath = "//span[contains(text(),'Activities')]/ancestor::article//div[text()='New Activity']")
	WebElement newActivity;

	@FindBy(xpath = "//input[@value='Save & New']")
	WebElement saveAndNewActivity;

	@FindBy(xpath="//select[@class='slds-select']/option[@value='Private - Follow-Up Task']")
	WebElement activityTypeFollowUpTaskValue;

	@FindBy(xpath = "// input [@value= 'Save']")
	WebElement saveActivity;

	@FindBy(xpath="//h2[@id='header']/a/span[text()='Opportunities']")
	WebElement relatedOpportunities;

	@FindBy(xpath="//span[text()='Account Name']/parent::div/parent::div//span[contains(@class,'test-id__field-value')]")
	WebElement opportunityAccountName;

	@FindBy(xpath="//h2[@id='header']/a/span[text()='Related Contacts']")
	WebElement contactRoles;

	@FindBy(xpath="//a[@class='tabHeader']//span[text()='Details']")
	WebElement details;

	@FindBy(xpath="//a[@class='select'][@aria-label='Preferred Property Type']")
	WebElement leadEditPreferedPropertyType;

	@FindBy(xpath="//div[@class='select-options']//a[@title='Hotel']")
	WebElement leadEditPreferedPropertyTypeValue;

	@FindBy(xpath="//ul[contains(@class,'forceActionsContainer')]//a[@class='forceActionLink']/div[text()='Edit']")
	WebElement edit;

	@FindBy(xpath="//div[contains(@class,'forceModalActionContainer--footerAction')]/button[@title='Save']")
	WebElement save;

	@FindBy(xpath="//div[contains(@class,'actionMenu')]//a[@title='New Private Note']")
	WebElement newNote;

	@FindBy(xpath="//span[text()='Title']/parent::label/parent::div//input[@type='text']")
	WebElement newNoteTitle;

	@FindBy(xpath="//button[contains(@class,'slds-button--brand cuf-publisherShareButton')]/span[text()='Save']")
	WebElement newNoteSave;

	@FindBy(xpath="//span[text()='Street']/parent::label/parent::div//textarea[@placeholder='Street']")
	WebElement leadEditStreet;

	@FindBy(xpath="//span[text()='City']/parent::label/parent::div//input[@placeholder='City']")
	WebElement leadEditCity;

	@FindBy(xpath="//span[text()='Zip/Postal Code']/parent::label/parent::div//input[@placeholder='Zip/Postal Code']")
	WebElement leadEditPostalCode;

	@FindBy(xpath="//a[@class='select'][@aria-label='State/Province Code']")
	WebElement leadEditState;

	@FindBy(xpath="//a[@class='select'][@aria-label='Country Code']")
	WebElement leadEditCountry;

	@FindBy(xpath="//div[@class='select-options']/ul/li/a[@title='United States']")
	WebElement leadEditCountryValue;

	@FindBy(xpath="//div[@class='select-options']/ul/li/a[@title='Texas']")
	WebElement leadEditStateValue;

	@FindBy(xpath="//span[text()='First Name']/parent::label/parent::div//input[@placeholder='First Name']")
	WebElement leadEditFirstName;

	@FindBy(xpath="//span[text()='Last Name']/parent::label/parent::div//input[@placeholder='Last Name']")
	WebElement leadEditLastName;

	@FindBy(xpath="//span[text()='Direct Line']/parent::label/parent::div//input[@type='tel']")
	WebElement leadEditDirectLine;

	@FindBy(xpath = "//input[@name='new'][contains(@value,'Add')]")
	WebElement addButtonSharing;

	@FindBy(xpath = "//select[contains(@id,'sharing_search')]")
	WebElement searchUsers;

	@FindBy(xpath = "//input[contains(@id,'searchValue_sharing_search')]")
	WebElement searchUserName;

	@FindBy(xpath = "//*[contains(@title,'Find')]")
	WebElement findValue;

	@FindBy(xpath = "//label[text()='Available']/parent::div/parent::td/select[@id='duel_select_0']")
	WebElement selectUser;

	@FindBy(xpath = "//img[@class='rightArrowIcon']")
	WebElement rightArrow;

	@FindBy(xpath = "//*[@id='p7']")
	WebElement access;

	@FindBy(xpath = "//*[@id='bottomButtonRow']/input[@name='save']")
	WebElement saveButtonSharing;

	@FindBy(xpath="//label[text()='Unit of Measure']/parent::div/parent::div//select[contains(@id,'LeadForm')]")
	WebElement unitOfMeasure;
	
	@FindBy(xpath = "//div[contains(@class,'slds-page-header')]//div[@title='New Activity'][text()='New Activity']")
	WebElement newActivityHeader;

	@FindBy(xpath="//a[@class='slds-truncate outputLookupLink slds-truncate forceOutputLookup']")
	List<WebElement> leadsList;

	@FindBy(xpath="//a[@class='slds-truncate outputLookupLink slds-truncate forceOutputLookup'][contains(@title,'N-')]")
	List<WebElement> privateNotesList;
	
	@FindBy(xpath="//a[@class='slds-truncate outputLookupLink slds-truncate forceOutputLookup'][contains(@data-recordid,'003')]")
	List<WebElement> contactsList;

	@FindBy(xpath="//a[@class='slds-truncate outputLookupLink slds-truncate forceOutputLookup'][contains(@data-recordid,'006')]")
	List<WebElement> opportunitiesList;
	
	@FindBy(xpath="//a[contains(@id,'tag_edit_link')]")
	WebElement addTag;
	
	@FindBy(xpath="//textarea[@id='ptag_edit_area']")
	WebElement privatetag;

	@FindBy(xpath="//input[@id='tag_save_btn']")
	WebElement savePrivateTag;
	
	@FindBy(xpath="//a[contains(@title,'Test Automation')]")
	WebElement privateTagCreated;
	
	@FindBy (xpath = "//a[contains(@title,'Automation')]")
	WebElement ExistingLead;
	
	@FindBy (xpath = "//*[contains(@title,'View records tagged')]")
	WebElement PrivateTagged;
	@FindBy (xpath = " //*[contains(@class,'entityNameTitle slds-breadcrumb__item slds-line-height--reset')]")
	WebElement PrivateTagPage;
	
	@FindBy (xpath = "//li/a[@title='Reports']")
	WebElement ReportsTab;
	
	@FindBy (xpath = "//li/a[@title='All Folders']")
	WebElement AllFolder;
	
	@FindBy (xpath = "//*[@title='AIL Campaign Mass Add Members(Template)']")
	WebElement AllCampaignMemberbtn;
	
	@FindBy (xpath = "//th/a[@title='Contacts with Private Tags']")
	WebElement ContactsPrivateTag;
	
	@FindBy(xpath = "//div/a[@title = 'Show 5 more actions']")
	WebElement showMoreActionsReport;
	
	@FindBy(xpath = "//a[contains(@title,'Clone')]")
	WebElement clone;
	
	@FindBy(xpath = "//*[@title = 'Create']")
	WebElement create;
	
	@FindBy(xpath = "//h1[contains(@class,'slds-page-header__title')]/span")
	List<WebElement> accountNameSaved;
	
	@FindBy(xpath ="//span[text()='All Leads']")
	WebElement allLeads;
	
	@FindBy(xpath = "//button/span[text()='View All Fields']")
	WebElement ViewAllFieldsButton;
	
	

	private String leadConvertWaitSpinnerXPath = "//div[@class='slds-spinner_container']"; 

	/**
	 * Validating the Convert Lead functionality
	 * 
	 * @author Vishnuvardhan
	 *
	 */

	AccountsFunctions createAccount = new AccountsFunctions(scriptHelper);
	SearchTextSOQL searchRecord = new SearchTextSOQL(scriptHelper);
	EstablishConnection establishConnection = new EstablishConnection(scriptHelper);
	EventPage eventPage = new EventPage(scriptHelper);
	SF_UtilityFunctions sf_UtilityFunctions = new SF_UtilityFunctions(scriptHelper);
	
	/**
	 * Function for navigating to Leads section
	 *
	 * @author SnehaChandran
	 *
	 */

	public void navigateLeads() {
		try {
			Utility_Functions.xWaitForElementPresent(driver, leads, 2);
			Utility_Functions.xClick(driver, leads, true);
		} catch (Exception e) {
			Utility_Functions.xWaitForElementPresent(driver, more, 2);
			Utility_Functions.xClick(driver, more, true);
			try {
				Utility_Functions.xWaitForElementPresent(driver, leads, 2);
				Utility_Functions.xClick(driver, leads, true);
			} catch (Exception e1) {
				Utility_Functions.xWaitForElementPresent(driver, leadsEnv, 2);
				Utility_Functions.xClick(driver, leadsEnv, true);
			}
		}
	}
	
	/**
	 * Function for selecting a Lead in random from the list of Leads
	 *
	 * @author SnehaChandran
	 *
	 */

	public void selectALeadInRandom() {
		navigateLeads();
		Utility_Functions.xWaitForElementPresent(driver, leadsList, 5);
		try {
			if(leadsList.isEmpty()) {
				System.out.println("Recently Viewed List is empty");
				Utility_Functions.xClick(driver, recentlyViewed, true);
				Utility_Functions.xWaitForElementPresent(driver, allLeadsMenu, 3);
				Utility_Functions.xClick(driver, allLeadsMenu, true);	
				Utility_Functions.xWaitForElementPresent(driver, allLeadNames, 8);	
				sf_UtilityFunctions.selectExistingObjectRecord("Name");
			} else {
				sf_UtilityFunctions.selectExistingObjectRecord("Name");
			}
		} catch (Exception e) {
			System.out.println("Unable to click on a Lead from the Leads list:::");
		}		
		Utility_Functions.xWaitForElementPresent(driver, accountNameSaved, 5);
	}
	
	/**
	 * Function for navigating to New Leads
	 *
	 * @author SnehaChandran
	 *
	 */
	public void navigateNewLeadPage() {
		navigateLeads();
		sf_UtilityFunctions.selectAction("New");
		Utility_Functions.timeWait(1);
		Utility_Functions.xSwitchtoFrame(driver, leadInformationFrame);
	}
	
	/**
	 * Selecting the Contact from a list of contacts
	 * 
	 * @author Cognizant
	 *
	 */

	public void selectLead() {
		navigateLeads();
		report.updateTestLog("Verify Create Activity Lead", "Lead are Displayed ", Status.PASS);
		Utility_Functions.xWaitForElementPresent(driver, recentlyViewed, 3);
		Utility_Functions.xClick(driver, recentlyViewed, true);
		report.updateTestLog("Verify Create Activity Lead", "Recently viewed Lead are Displayed ", Status.PASS);
		Utility_Functions.xWaitForElementPresent(driver, allLeadsMenu, 3);
		Utility_Functions.xClick(driver, allLeadsMenu, true);
		Utility_Functions.xWaitForElementPresent(driver, allLeadNames, 8);
		report.updateTestLog("Verify Create Activity Lead", "All Lead are displayed successfully:::", Status.PASS);
		List<WebElement> contactList = driver.findElements(By.xpath("//a[@class='slds-truncate outputLookupLink slds-truncate forceOutputLookup']"));
		Utility_Functions.xclickgetTextofFirstElementfromList(contactList);
		Utility_Functions.timeWait(2);
	}
	
	public String selectLeadById(String Id) {
		selectALeadInRandom();
		Utility_Functions.xWaitForElementPresent(driver, accountNameSaved, 5);
		report.updateTestLog("Verify Create Activity Account ", "The Account is Displayed ", Status.PASS);
		String newUrl = driver.getCurrentUrl().split("Lead")[0] + "Lead" + Id + "/view";
		report.updateTestLog("Verify Create Accounts View Hierarchy", "Verifying the URL has been replaced with the new URL having the retrieved Account" + newUrl,	Status.PASS);
		driver.get(newUrl);
		Utility_Functions.xWaitForElementPresent(driver, accountNameSaved, 5);
		String accountName=Utility_Functions.xGetTextVisibleListElement(driver, accountNameSaved);
		return accountName;
	}
	
	public void convertLead() {
		selectALeadInRandom();
		System.out.println(addressDetails.getText() + directLine.getText() + email.getText());
		try {
			if((directLine.getText().equals("")) && (email.getText().equals("")) && (!addressMap.isDisplayed())) {
				System.out.println("Address Details, DirectLine and Email field are not having the values:::");
				report.updateTestLog("Lead Page", "Address Details, DirectLine and Email field are not having the values::", Status.FAIL);	
				Utility_Functions.xClick(driver, directLineEditButton, true);
				Utility_Functions.timeWait(1);
				Utility_Functions.xSendKeys(driver, enterDirectLIne, dataTable.getData("General_Data", "Direct Line"));

			} else {
				System.out.println("Address Details, DirectLine and Email field are having the values:::");
				report.updateTestLog("Lead Page", "Address Details, DirectLine and Email field are having the values::", Status.PASS);		
			}
		} catch (Exception e1) {
			System.out.println("Address Details, DirectLine and Email field are having the values:::" + e1.getMessage());
		}
		Utility_Functions.xClick(driver, convert, true);
		Utility_Functions.timeWait(3);	
		convertListValidation();
		try {
			if(convertedStatus.getText().equals("Qualified")) {
				System.out.println("Converted Status field is having the option as Qualified by default");
				report.updateTestLog("Convert Lead Page", "Convert Lead Page is having the option as ::" + convertedStatus.getText() + "" ,Status.PASS);
			} 
			//String usernameDataSheet = dataTable.getData("General_Data", "TC_ID").split("a")[0];
			String recordOwnerNameText = recordOwnerText.getText();
			System.out.println("test1" + "::::" + recordOwnerNameText);
			if(recordOwnerNameText.contains(("test1"))) {
				System.out.println("Record Owner field is having the record owner autopopulated");
				report.updateTestLog("Convert Lead Page", "Convert Lead Page is not having the record owner value as null::",Status.PASS);
			}
			accountNameConvert.clear();
			Utility_Functions.timeWait(2);
			Utility_Functions.xSendKeys(driver, accountNameConvert, "Test");
			Utility_Functions.xSendKeys(driver, accountNameConvert, Keys.SPACE);
			Utility_Functions.timeWait(2);
			try {
				if(accountNames.getText().contains(" ")) {
					report.updateTestLog("Verify Acccount Name", "Account name contains the space between the Account First Name and Account Last Name:::", Status.PASS);
				} else {
					report.updateTestLog("Verify Acccount Name", "Account name doesn't contain the space between the Account First Name and Account Last Name:::", Status.WARNING);
				}
			} catch (Exception e) {
				System.out.println("Account name doesn't contain the space between the Account First Name and Account Last Name:::" + e.getMessage());
			}			
		} catch (Exception e) {
			System.out.println("Convert Status field is not having the option as Qualified by default:::" + e.getMessage());
		}
	}
	
	/**
	 * Function to validate the Convert List elements
	 * 
	 * @author Cognizant
	 *
	 */
	public void validateLeadActivity() {	
		selectALeadInRandom();
		String newUrl = driver.getCurrentUrl().split("Lead")[0] + "Lead" + TaskEventsFunctions.leadId + "/view";
		driver.get(newUrl);
		Utility_Functions.timeWait(1);		
	}
	/**
	 * Function to validate the Convert List elements
	 * 
	 * @author Vishnuvardhan
	 *
	 */
	public void convertListValidation() {
		List<WebElement> convertList = driver.findElements(By.xpath("//label[@class='slds-form-element__label']"));
		int count=0; 
		try {
			for(WebElement element: convertList) {
				if((count==0) && (element.getText().equals("*Converted Status"))) {
					System.out.println("Converted Status field is present in the Convert Lead Page");
					report.updateTestLog("Convert Lead Page", "Convert Lead Page is having the " + element.getText() +" Status field::",Status.PASS);	
					count++;						
				} else if((count==1) && (element.getText().equals("*Record Owner"))) {
					System.out.println("Record Owner field is present in the Convert Lead Page");
					report.updateTestLog("Convert Lead Page", "Convert Lead Page is having the " + element.getText() +" Status field::",Status.PASS);
					count++;						
				} else if((count==2) && (element.getText().equals("*Account Name"))) {
					System.out.println("Account Name field is present in the Convert Lead Page");
					report.updateTestLog("Convert Lead Page", "Convert Lead Page is having the " + element.getText() +" Status field::",Status.PASS);
					count++;
				} 										
			}
			if(count!=3) {
				report.updateTestLog("Convert Lead Page", "Convert Lead Page is not having all the fields::",Status.FAIL);
			} else {
				report.updateTestLog("Convert Lead Page", "Convert Lead Page is having all the fields::",Status.PASS);
			}

		} catch (Exception e) {
			System.out.println("Convert Lead Page is having all the fields::" + e.getMessage());
		}
	}

	/**
	 * Adding the Web Elements to the Related Page Element List
	 * 
	 * @author Vishnuvardhan
	 *
	 */

	static ArrayList<String> relatedPageElementsList = new ArrayList<String>();
	public void relatedPageListElements() {
		relatedPageElementsList.add("Private Notes");
		relatedPageElementsList.add("Notes");
		relatedPageElementsList.add("Files");
		relatedPageElementsList.add("Lead Property");
		relatedPageElementsList.add("Lead History");
		System.out.println("Elements present in the Related tab on Lead Creation Page::" + relatedPageElementsList);
	}

	/**
	 * Function for Create Lead functionality
	 * 
	 * @author Vishnuvardhan
	 *
	 */

	public void createLeadFunction() {
		navigateNewLeadPage();
		try {
			if(dataTable.getData("General_Data", "TC_ID").contains("OB")) {
				Utility_Functions.xWaitForElementPresent(driver, selectRecordType, 5);
				Utility_Functions.xClick(driver, selectRecordType, true);
				Utility_Functions.xWaitForElementPresent(driver, occupierBrokerage, 5);
				Utility_Functions.xClick(driver, occupierBrokerage, true);
			} else if(dataTable.getData("General_Data", "TC_ID").contains("AB")) {
				Utility_Functions.xWaitForElementPresent(driver, selectRecordType, 5);
				Utility_Functions.xClick(driver, selectRecordType, true);
				Utility_Functions.xWaitForElementPresent(driver, agencyBroker, 5);
				Utility_Functions.xClick(driver, agencyBroker, true);
			} else if(dataTable.getData("General_Data", "TC_ID").contains("CM")) {
				Utility_Functions.xWaitForElementPresent(driver, selectRecordType, 5);
				Utility_Functions.xClick(driver, selectRecordType, true);
				Utility_Functions.xWaitForElementPresent(driver, capitalMarkets, 5);
				Utility_Functions.xClick(driver, capitalMarkets, true);
			}			
		} catch (Exception e) {
			System.out.println("Unable to select the lead record type encountered an error:::" + e.getMessage());
		}
		Utility_Functions.xWaitForElementPresent(driver, continueButton, 5);
		Utility_Functions.xClick(driver, continueButton, true);
		Utility_Functions.timeWait(2);
		
		SearchTextSOQL searchTextSOQL = new SearchTextSOQL(scriptHelper);
		String queryAccount = "Select Name from Account where BillingStreet != null";
		String sCompanyName = searchTextSOQL.fetchRecordFieldValueAdminLogin("Name", queryAccount);
		
		driver.switchTo().defaultContent();
		Utility_Functions.xWaitForElementPresent(driver, firstName, 5);
		String sFirstName = Utility_Functions.xRandomFunction() + "_" + dataTable.getData("General_Data", "First Name");
		String sLastName =  Utility_Functions.xRandomFunction() + "_" +  dataTable.getData("General_Data", "Last Name");
		Utility_Functions.xSendKeys(driver, firstName, sFirstName);
		Utility_Functions.xWaitForElementPresent(driver, lastName, 3);
		Utility_Functions.xSendKeys(driver, lastName, sLastName);
		Utility_Functions.xWaitForElementPresent(driver, company, 3);
		Utility_Functions.xSendKeys(driver, company, sCompanyName);
		if(dataTable.getData("General_Data", "TC_ID").contains("LeadsConvertPageWithEmail")) {
			Utility_Functions.xWaitForElementPresent(driver, selectPreferedPropertyType, 2);
			Utility_Functions.xClick(driver, selectPreferedPropertyType, true);
			Utility_Functions.xWaitForElementPresent(driver, selectPreferedPropertyTypeValue, 2);
			Utility_Functions.xClick(driver, selectPreferedPropertyTypeValue, true);
			Utility_Functions.xWaitForElementPresent(driver, selectPreferedPropertySubTypeValue, 2);
			Utility_Functions.xClick(driver, selectPreferedPropertySubTypeValue, true);
			Utility_Functions.xWaitForElementPresent(driver, addValuetoCheckList, 2);
			Utility_Functions.xClick(driver, addValuetoCheckList, true);
			report.updateTestLog("Verify Convert Lead with Direct Line and Private Note","The Prefered Property type is selected", Status.PASS);
			Utility_Functions.timeWait(2);
			Utility_Functions.xWaitForElementPresent(driver, emailLead, 5);
			Utility_Functions.xSendKeys(driver,emailLead, dataTable.getData("General_Data", "Email"));
			report.updateTestLog("Verify Convert Lead with Email","The Email value is entered", Status.PASS);
			Utility_Functions.timeWait(2);			
		}
	}

	/**
	 * Validating the Create Lead functionality
	 * 
	 * @author Vishnuvardhan
	 *
	 */

	public void createLead() {
		createLeadFunction();
		Utility_Functions.xWaitForElementPresent(driver, saveButton, 3);
		Utility_Functions.xClick(driver, saveButton, true);
		Utility_Functions.timeWait(3);
		try {
			//String companyText = dataTable.getData("General_Data", "Company");
			if(headerLead.isDisplayed()) {
				System.out.println("Lead has been created successfully");
				report.updateTestLog("Create Lead", "Lead has been created successfully"+ headerLead.getText(),Status.PASS);			
			} else {
				System.out.println("Lead creation failed");
				report.updateTestLog("Create Lead", "Lead creation failed:::"+ headerLead.getText(),Status.FAIL);			
			}
		} catch (Exception e) {
			System.out.println("Lead creation failed:::" + e.getMessage());
		}
		Utility_Functions.xClick(driver, related, true);
		relatedPageListElements();
		Utility_Functions.xWaitForElementPresent(driver, driver.findElements(By.xpath("//h2[contains(@id,'header')]/a/span[1]")), 5);
		List<WebElement> relatedPageListOnPage = driver.findElements(By.xpath("//h2[contains(@id,'header')]/a/span[1]"));
		List<String> relatedPageListFound = new ArrayList<String>();
		for (WebElement element : relatedPageListOnPage) {
			relatedPageListFound.add(element.getText());
		}
		relatedPageListElements();
		List<String> relatedPageElementsCount = Utility_Functions.xValidatePickListValuesPage(relatedPageElementsList, relatedPageListFound, "Related Page Elements");
		if (relatedPageElementsCount.size() == 0) {
			report.updateTestLog("Verify Related Page Elements",
					"Related Page has all the elements present", Status.PASS);
		} else {
			report.updateTestLog("Verify Related Page Elements",
					"Related Page does not have all the elements present", Status.FAIL);
		}
	}

	/**
	 * Validating the Create Greenspace Lead functionality
	 * 
	 * @author Vishnuvardhan
	 *
	 */

	public void createGreenspaceLead() {
		createLeadFunction();
		Utility_Functions.timeWait(1);
		Utility_Functions.xSelectDropdownByIndex(leadSource, 6);
		Utility_Functions.timeWait(1);
		if(leadStatusField.getText().equals("Open")) {
			report.updateTestLog("Verify Lead Status Field","By default the Lead Status Field is having the option as 'Open'" ,Status.PASS);
		} else {
			report.updateTestLog("Verify Lead Status Field","By default the Lead Status Field is not having the option as 'Open'" ,Status.FAIL);
		}
		Utility_Functions.xSendKeys(driver, directLineLead, dataTable.getData("General_Data", "Direct Line"));
		Utility_Functions.timeWait(1);
		Utility_Functions.xClick(driver, saveButton, true);
		Utility_Functions.xWaitForElementPresent(driver, headerLead, 5);
		try {
			//String companyText = dataTable.getData("General_Data", "Company");
			if(headerLead.isDisplayed()) {
				System.out.println("Greenspace Lead has been created successfully");
				report.updateTestLog("Create Greenspace Lead", "Greenspace Lead has been created successfully"+ headerLead.getText(),Status.PASS);			
			} else {
				System.out.println("Greenspace Lead creation failed");
				report.updateTestLog("Create Greenspace Lead", "Greenspace Lead creation failed:::"+ headerLead.getText(),Status.FAIL);			
			}
		} catch (Exception e) {
			System.out.println("Greenspace Lead creation failed:::" + e.getMessage());
		}
	}

	/**
	 * Adding buttons on the Lead Detail page to the buttonsList
	 * 
	 * @author Vishnuvardhan
	 *
	 */
	static ArrayList<String> buttonList = new ArrayList<String>();
	public void buttonsListLeadDetailPage() {
		buttonList.add("Edit");
		buttonList.add("Convert");
		buttonList.add("Clone");
		//buttonList.add("Sharing");
		System.out.println("Buttons list on Lead Details page::"+ buttonList);		
	}

	/**
	 * Adding buttons on the Lead Detail page to the buttonsList
	 * 
	 * @author Vishnuvardhan
	 *
	 */
	static ArrayList<String> moreActionsList = new ArrayList<String>();
	public void moreActionsListLeadDetailPage() {
/*		moreActionsList.add("Sharing");
		moreActionsList.add("New Task");
		moreActionsList.add("New Event");
		moreActionsList.add("Log A Call");*/
		moreActionsList.add("Sharing");
		moreActionsList.add("New Private Note");
		moreActionsList.add("New Personal Information");
		moreActionsList.add("Delete");
		System.out.println("Show more actions list on Lead Details page::"+ moreActionsList);		
	}

	/**
	 * Validating the Clone and Edit buttons on the Lead Details Page
	 * 
	 * @author Vishnuvardhan
	 *
	 */

	public void cloneAndEditButtons() {
		Utility_Functions.timeWait(1);
		Utility_Functions.xClick(driver, leads, true);
		Utility_Functions.xWaitForElementPresent(driver, leadsList, 3);
		Utility_Functions.xclickgetTextofFirstElementfromList(leadsList);
		Utility_Functions.timeWait(2);
		buttonsListLeadDetailPage();
		List<WebElement> buttonsList = driver.findElements(By.xpath("//div[contains(@class,'flexipagePage')]//a[contains(@class,'forceActionLink')]/div"));
		int i =0, count =0;
		System.out.println("Number of buttons found  ::  "+buttonsList.size());
		try {
			for(WebElement element: buttonsList) {
				System.out.println(element.getText() + buttonList.get(i));
				if(element.getText().equals(buttonList.get(i))) {
					System.out.println("Button List present on the Lead Details Page::::" + element.getText());
					report.updateTestLog("Lead Details Page", "Buttons present on the Leads Details Page:::"+ element.getText(),Status.PASS);
					count++;
				} 
				i++;
			}
			System.out.println(count);
			if(count==3) {
				report.updateTestLog("Lead Details Page", "Edit, Convert and Clone buttons present on the Leads Details Page:::",Status.PASS);
			} else {
				report.updateTestLog("Lead Details Page", "Not all the buttons are present on the Leads Details Page:::",Status.FAIL);
			}
		} catch (Exception e) {
			System.out.println("Not all the buttons are present on the Leads Details Page:::" + e.getMessage());
		}
		Utility_Functions.xClick(driver, showMoreActions, true);
		Utility_Functions.timeWait(2);
		moreActionsListLeadDetailPage();
		List<WebElement> showMoreActionsList = driver.findElements(By.xpath(" //div[contains(@class,'actionMenu')]//li/a/div"));
		System.out.println("Number of More Action buttons found :: "+ showMoreActionsList.size());
		int i1 =0, count1=0;
		try {
			for(WebElement element: showMoreActionsList) {
				System.out.println(element.getText() + moreActionsList.get(i1));
				if(element.getText().equals(moreActionsList.get(i1))) {
					System.out.println("Show more actions List present on the Lead Details Page::::" + element.getText());
					report.updateTestLog("Lead Details Page", "Show more actions list present on the Leads Details Page:::"+ element.getText(),Status.PASS);
					count1++;
				} 
				i1++;
			}
			System.out.println(count1);
			if(count1==4) {
				report.updateTestLog("Lead Details Page", "All the menu buttons are present on the Leads Details Page:::",Status.PASS);
			} else {
				report.updateTestLog("Lead Details Page", "Not all the menu buttons are present on the Leads Details Page:::",Status.FAIL);
			}
		} catch (Exception e) {
			System.out.println("Not all the menu buttons are present on the Leads Details Page:::" + e.getMessage());
		}
		Utility_Functions.xClick(driver, editButton, true);
		Utility_Functions.timeWait(2);
		//Utility_Functions.xScrollWindowOnce(driver);
		Utility_Functions.timeWait(1);
		/*String firstName = editFirstName.getText();
		firstName.concat("__Updated");*/
		editFirstName.clear();
		Utility_Functions.timeWait(1);
		Random random = new Random();
		int value = random.nextInt(1000);
		Utility_Functions.xSendKeys(driver, editFirstName, "__Updated Name" + value);
		Utility_Functions.xClick(driver, editSaveButton, true);
		//Utility_Functions.xSendKeys(driver, editFirstName, "__Updated");
		Utility_Functions.timeWait(2);
		String updatedName = nameText.getText();
		String updatedFirstName = updatedName.split(" ")[0];
		if(updatedFirstName.contains("__Updated")) {
			report.updateTestLog("Lead Details Page", "Lead First Name is updated successfully:::",Status.PASS);
		} else {
			report.updateTestLog("Lead Details Page", "Lead First Name is not updated:::",Status.FAIL);
		}
		Utility_Functions.xWaitForElementPresent(driver, cloneButton, 3);
		Utility_Functions.xClick(driver, cloneButton, true);
		Utility_Functions.xWaitForElementPresent(driver, cloneSaveNewButton, 3);
		Utility_Functions.xClick(driver, cloneSaveNewButton, true);
		report.updateTestLog("Lead Details Page", "Lead clone happened successfully:::",Status.PASS);
	}

	/**
	 * Validating the Related lists of a Lead in the Lead Landing page
	 * 
	 * @author Vishnuvardhan
	 *
	 */	
	public void relatedListsLeadLandingPage() {
		Utility_Functions.timeWait(1);
		createLead();
		Utility_Functions.timeWait(1);
		Utility_Functions.xScrollWindowTop(driver);
		Utility_Functions.xWaitForElementPresent(driver, related, 3);
		Utility_Functions.xClick(driver, related, true);
		Utility_Functions.timeWait(4);
		Utility_Functions.xScrollWindow(driver);
		List<WebElement> relatedLists = driver.findElements(By.xpath("//h2[contains(@id,'header')]/a/span[1]"));
		int count=0;
		for(WebElement element: relatedLists) {
			if(element.getText().contains("Private Notes")) {
				count++;
				report.updateTestLog("Lead Related Section", "Lead Related Section contains the related list:::" + element.getText(),Status.PASS);
			} else if(element.getText().contains("Notes")) {
				count++;
				report.updateTestLog("Lead Related Section", "Lead Related Section contains the related list:::" + element.getText(),Status.PASS);
			} else if(element.getText().contains("Files")) {
				count++;
				report.updateTestLog("Lead Related Section", "Lead Related Section contains the related list:::" + element.getText(),Status.PASS);
			} else if(element.getText().contains("Lead Property")) {
				count++;
				report.updateTestLog("Lead Related Section", "Lead Related Section contains the related list:::" + element.getText(),Status.PASS);
			} else if(element.getText().contains("Lead History")) {
				count++;
				report.updateTestLog("Lead Related Section", "Lead Related Section contains the related list:::" + element.getText(),Status.PASS);
			}
		} 
		if(count==5) {
			report.updateTestLog("Lead Related Section", "Lead Related Section contains all the related lists for the lead:::",Status.PASS);
		} else {
			report.updateTestLog("Lead Related Section", "Lead Related Section doesn't contains all the related lists for the lead:::",Status.FAIL);
		}
	}

	/**
	 * Validating the Private Note functionality for Lead
	 * 
	 * @author Vishnuvardhan
	 *
	 */	
	public void privateNoteLead() {
		Utility_Functions.xWaitForElementPresent(driver, leads, 3);
		Utility_Functions.xClick(driver, leads, true);
		Utility_Functions.xWaitForElementPresent(driver, leadsList, 3);
		String leadSelected = Utility_Functions.xclickRandomElement(leadsList);
		Utility_Functions.xWaitForElementPresent(driver, related, 3);
		/*		
		searchTextSOQL searchRecord = new searchTextSOQL(scriptHelper);
		String recordID = searchRecord.fetchRecord("lead");
		String url = driver.getCurrentUrl();
		url.replaceAll("sObject/", "sObject/"+recordID);*/

		Utility_Functions.xClick(driver, related, true);
		Utility_Functions.timeWait(2);

		Utility_Functions.xScrollWindow(driver);
		Utility_Functions.timeWait(2);
		Utility_Functions.xScrollWindowTop(driver);
		Utility_Functions.timeWait(2);
		Utility_Functions.xWaitForElementPresent(driver, new_PrivateNotes, 3);
		Utility_Functions.xClick(driver, new_PrivateNotes, true);
		Utility_Functions.xWaitForElementPresent(driver, next_PrivateNotes, 3);
		Utility_Functions.xClick(driver, next_PrivateNotes, true);
		String leadPopulated = lead_PrivateNotes.getText();
		Utility_Functions.xSendKeys(driver, title_PrivateNotes, dataTable.getData("General_Data", "Title"));
		Utility_Functions.timeWait(1);
		try {
			if (leadSelected.equals(leadPopulated)) {
				report.updateTestLog("Verify Private Note", "Lead populated on Private Note is same as the one "
						+ "selected while creating the Private Note", Status.PASS);
			} else {
				report.updateTestLog("Verify Private Note", "Lead populated on Private Note is not the one "
						+ "selected while creating the Private Note", Status.WARNING);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		Utility_Functions.timeWait(1);
		Utility_Functions.xClick(driver, searchContacts, true);
	/*	List<WebElement> contactsList = driver.findElements(By.xpath(
				"//div[@class='lookup__menu uiAbstractList uiAutocompleteList uiInput uiAutocomplete uiInput--default uiInput--lookup']//div[@class='listContent']/ul/li"));
		Utility_Functions.timeWait(2);
		Utility_Functions.xclickOnFirstElementfromList(contactsList);*/
		WebElement firstLookupElement = driver.findElement(By.cssSelector("ul>li.forceSearchInputLookupDesktopOption:nth-child(1)"));
		Utility_Functions.xWaitForElementPresent(driver, firstLookupElement, 4);
		Utility_Functions.xClick(driver, firstLookupElement, false);		
		Utility_Functions.timeWait(2);
		Utility_Functions.xSendKeys(driver, body, dataTable.getData("General_Data", "Body"));
		Utility_Functions.timeWait(2);
		if(savePrivateNote.isDisplayed()) {
			Utility_Functions.xClick(driver, savePrivateNote, true);
			report.updateTestLog("Verify Private Note", "Private Note is created successfully", Status.PASS);
		} else {
			report.updateTestLog("Verify Private Note", "Private Note is created successfully", Status.FAIL);
		}
		Utility_Functions.timeWait(4);
	}

	/**
	 * Validating the Private Note Sharing functionality for Lead
	 * 
	 * @author Vishnuvardhan
	 *
	 */	

	public void privateNoteSharing() {
		Utility_Functions.timeWait(3);
		try {
			Utility_Functions.xWaitForElementPresent(driver,showMoreActionsDetailsPage, 3);
			Utility_Functions.xClick(driver,showMoreActionsDetailsPage, true);
			Utility_Functions.xWaitForElementPresent(driver, sharing, 3);
			Utility_Functions.xClick(driver, sharing, true);
		} catch (Exception e) {
			Utility_Functions.xWaitForElementPresent(driver, privateNoteSharing, 3);
			Utility_Functions.xClick(driver, privateNoteSharing, true);
		}
		Utility_Functions.timeWait(5);
		Utility_Functions.xSwitchtoFrame(driver, leadSharing);
		Utility_Functions.xWaitForElementPresent(driver, leadSharing, 4);
		Utility_Functions.timeWait(5);
		driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@title='Content']")));

		Utility_Functions.xWaitForElementPresent(driver, addButtonSharing, 5);
		Utility_Functions.xClick(driver, addButtonSharing, true);
		Utility_Functions.timeWait(2);
		Utility_Functions.xWaitForElementPresent(driver, searchUsers, 5);
		Utility_Functions.xSelectDropdownByName(searchUsers, "Users");
		Utility_Functions.timeWait(1);
		Utility_Functions.xSendKeys(driver, searchUserName, "bommisetty");
		Utility_Functions.timeWait(1);
		Utility_Functions.xClick(driver, findValue, true);
		Utility_Functions.timeWait(3);
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
		Utility_Functions.timeWait(1);
		Utility_Functions.xClick(driver, saveButtonSharing, true);
		report.updateTestLog("Verify Lead Sharing", "Lead Sharing functioanlity is working as expected", Status.PASS);			
		System.out.println("Lead Sharing functionality is working as expected");
	}

	/**
	 * Function for validating the Convert Lead by ing the new account in the Convert Lead page
	 * 
	 * @author Vishnuvardhan
	 *
	 */	
	public void convertLeadNewAccount() {
		createLeadFunction();				
		/*searchTextSOQL searchRecord = new searchTextSOQL(scriptHelper);
		String accountName= searchRecord.fetchRecord("account", "Name");
		company.clear();
		Utility_Functions.timeWait(2);
		Utility_Functions.xSendKeys(driver, company, accountName);*/
		Utility_Functions.timeWait(2);
		Utility_Functions.xScrollWindow(driver);
		Utility_Functions.timeWait(1);
		Utility_Functions.xSendKeys(driver, directLineLead, dataTable.getData("General_Data", "Phone"));
		Utility_Functions.timeWait(2);
		Utility_Functions.xClick(driver, saveButton, true);
		Utility_Functions.timeWait(3);		
		Utility_Functions.xClick(driver, saveConvertButton, true);
		Utility_Functions.timeWait(3);
		//driver.switchTo().frame(driver.findElement(By.xpath("//iframe[contains(@src,'LeadConversionRed')]")));
		driver.switchTo().defaultContent();
		Utility_Functions.xSwitchtoFrame(driver, streetField);
		Utility_Functions.xWaitForElementPresent(driver, streetField, 5);
		convertListValidation();
		Utility_Functions.timeWait(1);
		Utility_Functions.xScrollWindow(driver);
		Utility_Functions.timeWait(2);
		Utility_Functions.xSendKeys(driver, streetField, dataTable.getData("General_Data", "Street"));
		Utility_Functions.timeWait(1);
		Utility_Functions.xSendKeys(driver, cityField, dataTable.getData("General_Data", "City"));
		Utility_Functions.timeWait(1);
		Utility_Functions.xSendKeys(driver, zipCodeField, dataTable.getData("General_Data", "Zipcode"));
		Utility_Functions.timeWait(1);
		Utility_Functions.xSelectDropdownByName(countryField, dataTable.getData("General_Data", "Country"));
		Utility_Functions.timeWait(1);
		Utility_Functions.xSelectDropdownByName(stateField, dataTable.getData("General_Data", "State"));
		Utility_Functions.timeWait(3);
		if(convertButton.isDisplayed()) {
			Utility_Functions.xClick(driver, convertButton, true);
			report.updateTestLog("Verify Convert Lead", "Convert Lead done successfully", Status.PASS);
		} else {
			report.updateTestLog("Verify Convert Lead", "Convert Lead failed", Status.FAIL);
		}
	}

	/**
	 * Function for validating the Convert Lead by adding the new account in the Convert Lead page
	 * 
	 * @author Vishnuvardhan
	 *
	 */	
	public void convertLeadExistingAccount() {
		String accountName;
		SaveResult[] resultAccountName = createAccount.createAccount();
		String result = establishConnection.saveResultsId(resultAccountName);
		if(result.contains("001")) {
			System.out.println("Account got created successfully:::" + result);
			String accountNameQuery = "Select Name from Account where Id = " + "'" + result + "'";
			accountName = searchRecord.fetchRecordFieldValue("Name", accountNameQuery);
		} else {
			accountName = searchRecord.fetchRecord("Account", "Name");
		}
		createLeadFunction();					
		Utility_Functions.xWaitForElementPresent(driver, company, 3);
		company.clear();
		Utility_Functions.xSendKeys(driver, company, accountName);
		Utility_Functions.timeWait(2);
		Utility_Functions.xScrollWindow(driver);
		Utility_Functions.timeWait(1);
		Utility_Functions.xSendKeys(driver, directLineLead, dataTable.getData("General_Data", "Phone"));
		Utility_Functions.xWaitForElementPresent(driver, saveButton, 3);
		Utility_Functions.xClick(driver, saveButton, true);
		Utility_Functions.timeWait(2);
		Utility_Functions.xWaitForElementVisible(driver, saveConvertButton, 4);
		Utility_Functions.xClick(driver, saveConvertButton, true);
		Utility_Functions.timeWait(3);
		Utility_Functions.xSwitchtoFrame(driver, convertLeadTitle);
		convertListValidation();
		Utility_Functions.xWaitForElementPresent(driver, convertButton, 3);
		Utility_Functions.xClick(driver, convertButton, true);		
		driver.switchTo().defaultContent();
		Utility_Functions.timeWait(2);
		driver.navigate().refresh();
		Utility_Functions.timeWait(3);
		Utility_Functions.xWaitForElementPresent(driver, related, 3);
		if(related.isDisplayed()) {
			report.updateTestLog("Verify Convert Lead", "Convert Lead done successfully", Status.PASS);
		} else {
			report.updateTestLog("Verify Convert Lead", "Convert Lead failed", Status.FAIL);
		}		
		Utility_Functions.timeWait(4);
	}

	/**
	 * Validating the Convert Lead Note by adding an attachment and verifying it 
	 * 
	 * @author Ramya
	 *
	 */	

	public void convertLeadNote(){
		Utility_Functions.xWaitForElementPresent(driver, leads, 3);
		Utility_Functions.xClick(driver, leads, true);
		Utility_Functions.xWaitForElementPresent(driver, recentlyViewed, 3);
		Utility_Functions.xClick(driver,recentlyViewed, true);
		Utility_Functions.xWaitForElementPresent(driver, allLeadsMenu, 3);
		Utility_Functions.xClick(driver, allLeadsMenu, true);
		Utility_Functions.xWaitForElementPresent(driver, leadsList, 3);
		Utility_Functions.xclickgetTextofFirstElementfromList(leadsList);
		Utility_Functions.xWaitForElementPresent(driver, related, 3);
		Utility_Functions.xClick(driver, related, true);
		Utility_Functions.timeWait(5);
		Utility_Functions.xScrollWindowOnce(driver);
		Utility_Functions.timeWait(5);
		/*Utility_Functions.xClick(driver, recentFile, true);
		Utility_Functions.timeWait(2);*/		
		Utility_Functions.xClick(driver, addFile, true);
		Utility_Functions.xWaitForElementPresent(driver, addFileAttachment, 3);
		Utility_Functions.xClick(driver, addFileAttachment, true);
		Utility_Functions.xWaitForElementPresent(driver, add, 3);
		Utility_Functions.xClick(driver, add, true);
		Utility_Functions.xWaitForElementPresent(driver, convert, 3);
		Utility_Functions.xClick(driver, convert, true);
		Utility_Functions.timeWait(3);
		/*		int size = driver.findElements(By.tagName("iframe")).size();
		System.out.println(size);*/
		driver.switchTo().frame(driver.findElement(By.xpath(".//iframe[contains(@src,'LeadConversionRed')]")));
		Utility_Functions.timeWait(3);
		List<WebElement> convertList = driver.findElements(By.xpath(".//label[@class='slds-form-element__label']"));
		int count=0; 
		try {
			for(WebElement element: convertList) {
				if((count==0) && (element.getText().equals("*Converted Status"))) {
					System.out.println("Converted Status field is present in the Convert Lead Page");
					report.updateTestLog("Convert Lead Page", "Convert Lead Page is having the " + element.getText() +" Status field::",Status.PASS);	
					count++;						
				} else if((count==1) && (element.getText().equals("*Record Owner"))) {
					System.out.println("Record Owner field is present in the Convert Lead Page");
					report.updateTestLog("Convert Lead Page", "Convert Lead Page is having the " + element.getText() +" Status field::",Status.PASS);
					count++;						
				} else if((count==2) && (element.getText().equals("*Account Name"))) {
					System.out.println("Account Name field is present in the Convert Lead Page");
					report.updateTestLog("Convert Lead Page", "Convert Lead Page is having the " + element.getText() +" Status field::",Status.PASS);
				} 										
			}
			if(count!=2) 
				report.updateTestLog("Convert Lead Page", "Convert Lead Page is not having all the fields::",Status.FAIL);							
		} catch (Exception e) {
			System.out.println("Convert Lead Page is not having all the fields::"+e.getMessage());							

		}
		try {
			if(convertedStatus.getText().contains("Qualified")) {
				System.out.println("Converted Status field is having the option as Qualified by default");
				report.updateTestLog("Convert Lead Page", "Convert Lead Page is having the option as ::" + convertedStatus.getText() + "" ,Status.PASS);
			} else if(recordOwnerText != null) {
				System.out.println("Record Owner field is having the record owner autopopulated");
				report.updateTestLog("Convert Lead Page", "Convert Lead Page is not having the record owner value as null::",Status.PASS);
			} else {
				System.out.println("Fields are not having the values expected");
				report.updateTestLog("Convert Lead Page", "Convert Lead Page is not having the fields expected::",Status.FAIL);
			}
		} catch (Exception e) {
			System.out.println("Convert Lead Page is not having the fields expected::" + e.getMessage());		
		}
		Utility_Functions.xClick(driver, accName, true);
		Utility_Functions.timeWait(3);
		Utility_Functions.xSendKeys(driver, accountNameConvert, dataTable.getData("General_Data", "Account Name"));
		Utility_Functions.xSendKeys(driver, accountNameConvert, Keys.TAB);
		Utility_Functions.timeWait(2);
		Utility_Functions.xScrollWindowOnce(driver);
		Utility_Functions.timeWait(2);
		Utility_Functions.xSendKeys(driver, streetField, dataTable.getData("General_Data", "Street"));
		Utility_Functions.timeWait(3);
		Utility_Functions.xSelectDropdownByName(countryField, dataTable.getData("General_Data", "Country"));
		Utility_Functions.timeWait(3);
		Utility_Functions.xSelectDropdownByName(stateField, dataTable.getData("General_Data", "State"));
		Utility_Functions.timeWait(3);
		Utility_Functions.xSendKeys(driver, cityField, dataTable.getData("General_Data", "City"));
		Utility_Functions.timeWait(3);
		Utility_Functions.xSendKeys(driver, zipCodeField, dataTable.getData("General_Data", "Zipcode"));
		Utility_Functions.timeWait(3);
		Utility_Functions.xClick(driver, convertButton, true);
		Utility_Functions.timeWait(5);
		driver.navigate().refresh();
		driver.switchTo().defaultContent();
		Utility_Functions.timeWait(4);
		Utility_Functions.xClick(driver, related, true);
		Utility_Functions.timeWait(4);
		Utility_Functions.xScrollWindow(driver);
		Utility_Functions.timeWait(3);
		Utility_Functions.xScrollWindowTop(driver);
		Utility_Functions.timeWait(3);
		Utility_Functions.xClick(driver, accountsContacts, true);
		Utility_Functions.xWaitForElementPresent(driver, contactsList, 4);
		for(int i=0;i<contactsList.size();i++){
			System.out.println("The accounts are :" +i+contactsList.get(i).getText());
			report.updateTestLog("Convert Lead Note Attachment","The Accounts are:::"+ i + contactsList.get(i).getText() + "::",Status.PASS);
		}
		Utility_Functions.xclickOnFirstElementfromList(contactsList);
		Utility_Functions.timeWait(4);
		driver.navigate().refresh();
		driver.switchTo().defaultContent();
		Utility_Functions.timeWait(3);
		Utility_Functions.xClick(driver, related, true);
		Utility_Functions.timeWait(4);
		Utility_Functions.xScrollWindow(driver);
		Utility_Functions.timeWait(2);
		Utility_Functions.xScrollWindowTop(driver);
		Utility_Functions.timeWait(2);
		Utility_Functions.xClick(driver, files, true);
		Utility_Functions.xWaitForElementPresent(driver, leadsList, 3);
		if (leadsList.isEmpty() == true) {
			System.out.println("File is not associated with the contact");
			report.updateTestLog("Convert Lead Note Attachment","File is not associated with the Contact",Status.PASS);
		}else{
			System.out.println("File is associated with the contact ");
			report.updateTestLog("Convert Lead Note Attachment","File is associated with the Contact",Status.PASS);
		}

	}
	static ArrayList<String> labelsLeadsNewCustomEvent = new ArrayList<String>(); 
	public void labelsLeadsNewCustomEvent() {
		labelsLeadsNewCustomEvent.add("*Subject");
		labelsLeadsNewCustomEvent.add(" Activity Type");
		labelsLeadsNewCustomEvent.add(" Type");
		labelsLeadsNewCustomEvent.add("Location");
		labelsLeadsNewCustomEvent.add(" Start ");
		labelsLeadsNewCustomEvent.add("Start Date");
		labelsLeadsNewCustomEvent.add("Time");
		labelsLeadsNewCustomEvent.add("EndDate");
		labelsLeadsNewCustomEvent.add("Due Date");
		labelsLeadsNewCustomEvent.add("Time");
		labelsLeadsNewCustomEvent.add("Attachment");
		labelsLeadsNewCustomEvent.add("Description");
		labelsLeadsNewCustomEvent.add("*Assigned To");
		labelsLeadsNewCustomEvent.add("Lead");
	}

	/**
	 * Validating the manage Opportunity verify Custom Event Page
	 * 
	 * @author Ramya
	 *
	 */	
	public void leadsVerifyCustomEventPage() {
		Utility_Functions.xWaitForElementPresent(driver, leads, 3);
		Utility_Functions.xClick(driver, leads, true);
		/*Utility_Functions.xWaitForElementPresent(driver, leadsList, 3);
		Utility_Functions.timeWait(2);		
		if(leadsList.isEmpty()) {
		*/
		Utility_Functions.xWaitForElementPresent(driver, recentlyViewed, 5);
			Utility_Functions.xClick(driver, recentlyViewed, true);
			Utility_Functions.xWaitForElementPresent(driver, allLeadsMenu, 5);
			Utility_Functions.xClick(driver, allLeadsMenu, true);
			Utility_Functions.xWaitForElementPresent(driver, leadsList, 9);
			Utility_Functions.xclickOnFirstElementfromList(leadsList);
		/*} else {
			Utility_Functions.xclickOnFirstElementfromList(leadsList);
		}*/
/*		Utility_Functions.timeWait(5);
		Utility_Functions.xWaitForElementPresent(driver, selectNewEvent, 3);
		Utility_Functions.xClick(driver, selectNewEvent, true);*/
		Utility_Functions.xWaitForElementPresent(driver, newEvent, 6);
		Utility_Functions.xClick(driver, newEvent, true);
		Utility_Functions.timeWait(5);
		eventPage.verifyNewEventPageLayout();
		
/*		Actions action  = new Actions(driver.getWebDriver());
		action.moveToElement(newEvent);
		action.click();
		action.build().perform();
		Utility_Functions.timeWait(3);*/

		/*int size = driver.findElements(By.tagName("iframe")).size();
		System.out.println(size);
		Utility_Functions.timeWait(2);
		List<WebElement> iframeList = driver.findElements(By.tagName("iframe"));
		System.out.println(iframeList.size());
		for (WebElement element : iframeList) {
			System.out.println(element.getAttribute("id"));
		}*/

		/*driver.switchTo().frame(2);
		Utility_Functions.timeWait(5);

		if(addAnEventPage.getText().contains("Add an Event")){	

			System.out.println("The New Custom Event Page is displayed");
			report.updateTestLog("Verify Leads Custom Event Page", "The New Custom Event Page is Displayed", Status.PASS);
		}else{
			System.out.println("The New Custom Event Page is not displayed");
			report.updateTestLog("Verify Leads Custom Event Page", "The New Custom Event Page is not Displayed", Status.FAIL);
		}


		List<WebElement> drop = driver.findElements(By.xpath("//div[@class='slds-select_container']"));

		java.util.Iterator<WebElement> i = drop.iterator();
		while(i.hasNext()) {
			WebElement row = i.next();
			System.out.println(row.getText());
			if(!row.getText().equals("")) { 
				System.out.println("All the values for the Activity Type and Type pick list are present in  the Add an Event page");
				report.updateTestLog("Verify Leads Custom Event Page", "Verifying the Activity Type and Type pick list values", Status.PASS);
			}else{
				System.out.println("All the values for the Activity Type and Type pick list are not present in  the Add an Event page");
				report.updateTestLog("Verify Leads Custom Event Page", "Verifying the Activity Type and Type pick list values", Status.FAIL);  
			}


		}

		if(relatedTo.getText().contains("Related To")){
			System.out.println("Related To section is present in the New Activity Layout Page");
			report.updateTestLog("Verify Leads Custom Event Page ","Related To section is present in the New Custom Event Page",  Status.PASS);
		}else{
			System.out.println("Related To section is not present in the New Activity Layout Page");
			report.updateTestLog("Verify Leads Custom Event Page ","Related To section is not present in the New Custom Event Page",  Status.FAIL);

		}
		if(quickCreateanEvent.getText().contains("Quick Create an Event")){
			System.out.println("Quick Create an Event section is present in the New Activity Layout Page");
			report.updateTestLog("Verify Leads Custom Event Page ","Quick Create an Event section is present in the New Activity Page",  Status.PASS);
		}else{
			System.out.println("Quick Create an Event section is not present in the New Activity Layout Page");
			report.updateTestLog("Verify Leads Custom Event Page ","Quick Create an Event section is not present in the New Activity Page",  Status.FAIL);

		}

		if(!setReminderCheckBox.isSelected()){
			System.out.println("Set Reminder check box is present and not checked");
			report.updateTestLog("Verify Leads Custom Event Page ","Set Reminder checkbox is present in the New Custom Event Page",  Status.PASS);

		}else{
			System.out.println("Set Reminder check box is not present ");
			report.updateTestLog("Verify Leads Custom Event Page ","Set Reminder checkbox is not present in the New Custom Event Page",  Status.FAIL);
		}

		if ((!cancelCustomEventPageButton.getText().equals(" "))
				|| (!saveAndNewEventCustomEventPageButton.getText().equals(" "))
				|| (!saveEventCustomEventPageButton.getText().equals(" ")))
		{
			System.out.println(
					"Save, Save and New and Cancel buttons are prsent in the New Activity Layout Page ");
			report.updateTestLog("Verify Leads Custom Event Page  ",
					"Verifying New Custom Event Page is having the Save, Save and New and Cancel buttons ",
					Status.PASS);
		} else {
			System.out.println("Save, Save and New and Cancel buttons are not prsent in the New Activity Layout Page  ");
			report.updateTestLog("Verify Leads Custom Event Page ",
					"Verifying New Custom Event Page is having the Save, Save and New and Cancel buttons",
					Status.FAIL);
		}


		try {


			if ((!startDateNewCustomEventPage.getAttribute("value").equals(""))||(!startTimeNewCustomEventPage.getAttribute("value").equals(""))||(!endDateNewCustomEventPage.getAttribute("value").equals(""))||(!endTimeNewCustomEventPage.getAttribute("value").equals(""))) {
				System.out.println("Assigned To, Start Date, Start Time, End Date and End Time fields are having the values ");
				report.updateTestLog("Verify Leads Custom Event Page ",
						"Verify Leads Custom Event Page is having the default values in the required fields ", Status.PASS);
			} else {
				System.out.println("New Activity Layout Page is not having the deafault values ");
				report.updateTestLog("Verify New Opportunity Custom Event Page",
						"Verify Leads Custom Event Page is not having the default values in the required fields", Status.FAIL);
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
		}	

		List<WebElement> customEventpageFields = driver.findElements(By.xpath("//label[@class='slds-form-element__label'] "));
		int count = 0, i1 = 0;
		String labelArray[] = new String[customEventpageFields.size()];
		System.out.println(customEventpageFields.size());

		try {
			labelsLeadsNewCustomEvent();
			for (WebElement element:customEventpageFields) {
				labelArray[i1] = element.getText();
				if (labelArray[i1].contains(labelsLeadsNewCustomEvent.get(i1))) {
					report.updateTestLog("Verify New Opportunity Custom Event Page",
							"New Leads Custom Event Page is having the " + labelArray[i1]
									+ " field ",
									Status.PASS);
					count++;
				}
				i1++;
			}
			System.out.println(count);
			if (count != 11) {
				report.updateTestLog("Verify Leads Custom Event Page", "All Labels are not present in the Add New Event Page",
						Status.FAIL);
			} else {

				report.updateTestLog("Verify Leads Custom Event Page", "All Labels are present in the Add New Event Page",
						Status.PASS);
			}

		}catch (Exception e) {
			System.out.println(e.getMessage());
		}*/
	}

	/**
	 * Validating the Lead Private Note personal Information
	 * 
	 * @author Ramya
	 *
	 */	
	public void leadsVerifyPrivateNotePersonalInformation() {
		Utility_Functions.xWaitForElementPresent(driver, leads, 3);
		Utility_Functions.xClick(driver, leads, true);
		Utility_Functions.xWaitForElementPresent(driver, leadsList, 3);
		Utility_Functions.xclickgetTextofFirstElementfromList(leadsList);
		Utility_Functions.xWaitForElementPresent(driver, related, 3);
		Utility_Functions.xClick(driver, related, true);
		Utility_Functions.timeWait(3);
		Utility_Functions.xScrollWindow(driver);
		Utility_Functions.timeWait(1);
		Utility_Functions.xScrollWindowTop(driver);
		Utility_Functions.timeWait(2);
		Utility_Functions.xWaitForElementPresent(driver, new_PrivateNotes, 3);
		Utility_Functions.xClick(driver, new_PrivateNotes, true);
		Utility_Functions.xWaitForElementPresent(driver, selectPersonalInformation, 3);
		Utility_Functions.xClick(driver, selectPersonalInformation, true);
		Utility_Functions.timeWait(3);
		Utility_Functions.xClick(driver, next, true);
		Utility_Functions.timeWait(3);
		Utility_Functions.xClick(driver, titleName, true);
		Utility_Functions.xClick(driver, account_PrivateNotes, true);
		Utility_Functions.timeWait(2);
		Random random = new Random();
		int value = random.nextInt();
		Utility_Functions.xSendKeys(driver, titleName, "Test Personal Information Note" + value);
		Utility_Functions.timeWait(5);

		try {
			if ((!titleName.getText().equals("")) || (!account_PrivateNotes.getText().equals(""))) {
				System.out.println("Title Name and Accounts fields are having the values:::");
				report.updateTestLog("Accounts New Personal Information Page",
						"Title Name and  Accounts fields are having the values::", Status.PASS);
			} else {
				System.out.println("Title Name and Account fields are not having the values:::");
				report.updateTestLog("Accounts New Personal Information Page ",
						"Title Name and Accounts fields are not having the values::", Status.FAIL);
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
		}
		List<WebElement> personalInformation = driver
				.findElements(By.xpath(".//label[@class='label inputLabel uiLabel-left form-element__label uiLabel']"));
		int count = 0;
		try {
			for (WebElement element : personalInformation) {
				if ((count == 0) && (element.getText().contains("Title"))) {
					System.out.println("Title field is present in the Create Private Notes Personal Information Page");
					report.updateTestLog("Create Private Note Personal Information Page",
							"Create Private Note Personal Information Page is having the " + element.getText()
							+ " Status field::",
							Status.PASS);
					count++;
				} else if ((count == 1) && (element.getText().contains("Lead"))) {
					System.out.println("Lead field is present in the Create Private Notes Personal Information Page");
					report.updateTestLog("Create Private Notes Personal Information Page",
							"Create Private Notes Personal Information Page is having the " + element.getText()
							+ " Status field::",
							Status.PASS);
					count++;
				} else if ((count == 2) && (element.getText().contains("Account"))) {
					System.out
					.println("Account field is present in the Create Private Notes Personal Information Page");
					report.updateTestLog("Create Private Notes Personal Information Page",
							"Create Private Notes Personal Information Page is having the " + element.getText()
							+ " Status field::",
							Status.PASS);
					count++;
				} else if ((count == 3) && (element.getText().contains("Property"))) {
					System.out
					.println("Property field is present in the Create Private Notes Personal Information Page");
					report.updateTestLog("Create Private Notes Personal Information Page",
							"Create Private Notes Personal Information Page is having the " + element.getText()
							+ " Status field::",
							Status.PASS);
					count++;
				} else if ((count == 4) && (element.getText().contains("Contact"))) {
					System.out
					.println("Contact field is present in the Create Private Notes Personal Information Page");
					report.updateTestLog("Create Private Notes Personal Information Page",
							"Create Private Notes Personal Information Page is having the " + element.getText()
							+ " Status field::",
							Status.PASS);
					count++;
				} else if ((count == 5) && (element.getText().contains("Opportunity"))) {
					System.out
					.println("Opportunity field is present in the Create Private Notes Personal Information Page");
					report.updateTestLog("Create Private Notes Personal Information Page",
							"Create Private Notes Personal Information Page is having the " + element.getText()
							+ " Status field::",
							Status.PASS);
					count++;
				} else if ((count == 6) && (element.getText().contains("Direct Line"))) {
					System.out.println(
							"Direct Line field is present in the Create Private Notes Personal Information Page");
					report.updateTestLog("Create Private Notes Personal Information Page",
							"Create Private Notes Personal Information Page is having the " + element.getText()
							+ " Status field::",
							Status.PASS);
					count++;
				} else if ((count == 7) && (element.getText().contains("Personal Email"))) {
					System.out.println(
							"Personal Email field is present in the Create Private Notes Personal Information Page");
					report.updateTestLog("Create Private Notes Personal Information Page",
							"Create Private Notes Personal Information Page is having the " + element.getText()
							+ " Status field::",
							Status.PASS);
					count++;
				} else if ((count == 8) && (element.getText().contains("Mobile"))) {
					System.out.println("Mobile field is present in the Create Private Notes Personal Information Page");
					report.updateTestLog("Create Private Notes Personal Information Page",
							"Create Private Notes Personal Information Page is having the " + element.getText()
							+ " Status field::",
							Status.PASS);
					count++;

				} else if ((count == 9) && (element.getText().contains("Entertainment Preferences"))) {
					System.out.println(
							"Entertainment Preferences field is present in the Create Private Notes Personal Information Page");
					report.updateTestLog("Create Private Notes Personal Information Page",
							"Create Private Notes Personal Information Page is having the " + element.getText()
							+ " Status field::",
							Status.PASS);

				}
			}

			System.out.println(count);
			if (count < 5) {

				System.out.println(
						"All the fields are not present in the new personal information page");
				report.updateTestLog("Create Private Notes Personal Information Page",
						"Create Private Notes Personal Information Page is not having all the fields::", Status.FAIL);

			}else{

				System.out.println(
						"All the fields are present in the new personal information page");
				report.updateTestLog("Create Private Notes Personal Information Page",
						"Create Private Notes Personal Information Page is not having all the fields::", Status.PASS);


			}
		} catch (Exception e) {
			System.out.println("Create Private Notes Personal Information Page is not having all the fields:::" + e.getMessage());
		}

		Utility_Functions.xClick(driver, savePersonalInformation, true);
		Utility_Functions.timeWait(3);
		Utility_Functions.xScrollWindow(driver);
		Utility_Functions.timeWait(1);
		Utility_Functions.xScrollWindowTop(driver);
		Utility_Functions.timeWait(2);
		Utility_Functions.xClick(driver, viewAllButton, true);
		Utility_Functions.xWaitForElementPresent(driver, privateNotesList, 3);
		for (WebElement element : privateNotesList) {
			if ((!element.getText().equals(" "))){
				report.updateTestLog("Verify Create Activity Account","The New Activity for Accounts are created ",Status.PASS);
			} else {
				report.updateTestLog("Verify Create Activity Account","The New Activity for Accounts are not created ",Status.FAIL);
			}
		}

	}
	/**
	 * Validating the Leads custom Page
	 * 
	 * @author Ramya
	 * @author SChandran
	 *
	 */	

	static ArrayList<String> customPageQuickCreateFieldsList = new ArrayList<String>();

	public void customPageQuickCreateFields() {
		customPageQuickCreateFieldsList.add("Salutation");
		customPageQuickCreateFieldsList.add("* First Name");
		customPageQuickCreateFieldsList.add("* Last Name");
		customPageQuickCreateFieldsList.add("* Company");
		customPageQuickCreateFieldsList.add("Existing Engagement Expiration");
		customPageQuickCreateFieldsList.add("Total Size");
		customPageQuickCreateFieldsList.add("Unit of Measure");
		customPageQuickCreateFieldsList.add("Preferred Property Type");
		customPageQuickCreateFieldsList.add("Preferred Property Sub-Type");
		customPageQuickCreateFieldsList.add("Requirement Details");
		customPageQuickCreateFieldsList.add("* Status");
		customPageQuickCreateFieldsList.add("Lead Source");

		System.out.println("Custom Page Quick create fields are " + customPageQuickCreateFieldsList);
	}
	static ArrayList<String> customPageAddressInformationFieldsList = new ArrayList<String>();

	public void customPageAddressInformationFields() {
		customPageAddressInformationFieldsList.add("Address");
		customPageAddressInformationFieldsList.add("Country Code");
		customPageAddressInformationFieldsList.add("Street");
		customPageAddressInformationFieldsList.add("City");
		customPageAddressInformationFieldsList.add("State/Province Code");
		customPageAddressInformationFieldsList.add("Zip/Postal Code");


		System.out.println("Custom Page Contact Information fields are " + customPageAddressInformationFieldsList);
	}
	static ArrayList<String> customPageContactInformationFieldsList = new ArrayList<String>();

	public void customPageContactInformationFields() {
		customPageContactInformationFieldsList.add("Direct Line");
		customPageContactInformationFieldsList.add("Mobile");
		customPageContactInformationFieldsList.add("Main Phone");
		customPageContactInformationFieldsList.add("Email");
		customPageContactInformationFieldsList.add("Fax");


		System.out.println("Custom Page Contact Information fields are " + customPageContactInformationFieldsList);
	}
	static ArrayList<String> customPageLeadInformationFieldsList = new ArrayList<String>();

	public void customPageLeadInformationFields() {
		customPageLeadInformationFieldsList.add("Salutation");
		customPageLeadInformationFieldsList.add("First Name");
		customPageLeadInformationFieldsList.add("Last Name\n*");
		customPageLeadInformationFieldsList.add("Rating");
		customPageLeadInformationFieldsList.add("Middle Name");
		customPageLeadInformationFieldsList.add("Lead Source");
		customPageLeadInformationFieldsList.add("Nickname");
		customPageLeadInformationFieldsList.add("Lead Status\n*");
		customPageLeadInformationFieldsList.add("Title");
		customPageLeadInformationFieldsList.add("Lead Record Type");
		customPageLeadInformationFieldsList.add("Department");
		customPageLeadInformationFieldsList.add("Lead Owner");
		customPageLeadInformationFieldsList.add("Influence Level");
		customPageLeadInformationFieldsList.add("Lead Owner");
		customPageLeadInformationFieldsList.add("Company\n*");
		customPageLeadInformationFieldsList.add("Represented By (Firm)");
		customPageLeadInformationFieldsList.add("Industry");
		customPageLeadInformationFieldsList.add("Website");
		customPageLeadInformationFieldsList.add("Lead Record Counter");

		System.out.println("Custom Page Lead Information fields are " + customPageLeadInformationFieldsList);
	}

	static ArrayList<String> customPageCommunicationPreferencesFieldsList = new ArrayList<String>();

	public void customPageCommunicationPreferencesFields() {
		customPageCommunicationPreferencesFieldsList.add("Email Options");
		customPageCommunicationPreferencesFieldsList.add("Call Options");
		customPageCommunicationPreferencesFieldsList.add("Mail Options");

		System.out.println("Custom Page Communication Preferences fields are " + customPageCommunicationPreferencesFieldsList);
	}
	static ArrayList<String> customPageProspectRequirementsFieldsList = new ArrayList<String>();

	public void customPageProspectRequirementsFields() {
		customPageProspectRequirementsFieldsList.add("Preferred Property Type");
		customPageProspectRequirementsFieldsList.add("Total Size");
		customPageProspectRequirementsFieldsList.add("Preferred Property Sub-Type");
		customPageProspectRequirementsFieldsList.add("Unit of Measure");
		customPageProspectRequirementsFieldsList.add("Total # of Units");
		customPageProspectRequirementsFieldsList.add("Requirement Details");
		customPageProspectRequirementsFieldsList.add("Unit of Comparison");
		if(dataTable.getData("General_Data", "TC_ID").contains("OB")) {
			customPageProspectRequirementsFieldsList.add("Existing Lease Expiration");
			customPageProspectRequirementsFieldsList.add("Existing Termination/Break Option");
		}
		else
			customPageProspectRequirementsFieldsList.add("Existing Engagement Expiration");
		

		System.out.println("Custom Page Prospect requirements fields are " + customPageProspectRequirementsFieldsList);
	}
	static ArrayList<String> customPageAdditionalInformationFieldsList = new ArrayList<String>();

	public void customPageAdditionalInformationFields() {
		customPageAdditionalInformationFieldsList.add("Assistant Name");
//		customPageAdditionalInformationFieldsList.add("Invalid");
		customPageAdditionalInformationFieldsList.add("Assistant Phone");
//		customPageAdditionalInformationFieldsList.add("Date Verified");
		customPageAdditionalInformationFieldsList.add("Assistant Email");
		customPageAdditionalInformationFieldsList.add("Unmapped Fields");
		customPageAdditionalInformationFieldsList.add("Next Steps");

		System.out.println("Custom Page Additional Information fields are " + customPageAdditionalInformationFieldsList);
	}
	
	/**
	 * Validating the Create New Lead Custom Page.
	 * @author SChandran
	 */
	
	static List<String> createNewLeadSectionHeadersList = new ArrayList<String>();

	public void createNewLeadSectionHeadersList() {
		createNewLeadSectionHeadersList.add("Lead Information");
		createNewLeadSectionHeadersList.add("Address Information");
		createNewLeadSectionHeadersList.add("Contact Information");
		createNewLeadSectionHeadersList.add("Communication Preferences");
		createNewLeadSectionHeadersList.add("Prospect Requirements");
		createNewLeadSectionHeadersList.add("Additional Information");
		System.out.println("Propety page contains the header section:::" + createNewLeadSectionHeadersList);
	}	
	
	public void verifyLeadsNewCustomPage() {
		Utility_Functions.xWaitForElementPresent(driver, leads, 8);
		Utility_Functions.xClick(driver, leads, true);
		Utility_Functions.xWaitForElementPresent(driver, newLeads, 8);
		Utility_Functions.xClick(driver, newLeads, true);
		Utility_Functions.timeWait(4);
		Utility_Functions.xSwitchtoFrame(driver, continueButton);
		Utility_Functions.timeWait(2);
		Utility_Functions.xClick(driver, continueButton, true);
		Utility_Functions.timeWait(2);
		driver.switchTo().defaultContent();
		Utility_Functions.timeWait(2);
		Utility_Functions.xSwitchtoFrame(driver, saveLead);

		/***** Validating the Header Sections *****/

		List<WebElement> createNewLeadSectionHeadersPresentOnPage = driver.findElements(By.xpath("//h3[contains(@class,'section__title') and contains(@class,'section-header')]"));
		List<String> createNewLeadSectionHeadersFound = new ArrayList<String>();
		for (WebElement element : createNewLeadSectionHeadersPresentOnPage) {
			createNewLeadSectionHeadersFound.add(element.getText());
		}

		createNewLeadSectionHeadersList();
		List<String> sectionHeadersCount = Utility_Functions.xValidatePickListValuesPage(createNewLeadSectionHeadersList, createNewLeadSectionHeadersFound, "Create New Lead Section Headers");
		if (sectionHeadersCount.size() == 0) {
			report.updateTestLog("Create New Lead Custom Page",
					"Create New Lead Custom Page has all the expected header sections", Status.PASS);
		} else {
			report.updateTestLog("Create New Lead Custom Page",
					"Create New Lead Custom Page does not have all the expected header sections", Status.FAIL);
		}

		/***** Validating Lead Information Section *****/

		List<WebElement> createNewLeadLeadInformationSectionFieldsOnPage = driver.findElements(By.xpath("//h3[contains(@class,'section__title') and contains(@class,'section-header')]/span[text()='Lead Information']/following::div[1]//label/span"
																								+ "|//h3[contains(@class,'section__title') and contains(@class,'section-header')]/span[text()='Lead Information']/following::div[1]//span[contains(@class,'field-label') or contains(@id,'a-label')]/parent::span[contains(@class,'form-element__label')]/span"
																								+ "|//h3[contains(@class,'section__title') and contains(@class,'section-header')]/span[text()='Lead Information']/following::div[1]//div[contains(@class,'full forcePageBlockItem')]//span[contains(@class,'field-label')]"));
		List<String> createNewLeadLeadInformationSectionFieldsFound = new ArrayList<String>();	
		for(int i=0; i<createNewLeadLeadInformationSectionFieldsOnPage.size(); i++)
		{
			createNewLeadLeadInformationSectionFieldsFound.add(createNewLeadLeadInformationSectionFieldsOnPage.get(i).getText());
			if(createNewLeadLeadInformationSectionFieldsFound.get(i).equals("*"))
				createNewLeadLeadInformationSectionFieldsFound.set(i-1, createNewLeadLeadInformationSectionFieldsFound.get(i-1)+"\n*");
		}

		customPageLeadInformationFields();
		List<String> sectionFieldsCount = Utility_Functions.xValidatePickListValuesPage(customPageLeadInformationFieldsList, createNewLeadLeadInformationSectionFieldsFound, "Lead Information Section Fields");
		if (sectionFieldsCount.size() == 0) {
			report.updateTestLog("Create New Lead Custom Page - Lead Information Section",
					"Lead Information section has all the expected fields", Status.PASS);
		} else {
			report.updateTestLog("Create New Lead Custom Page - Lead Information Section",
					"Lead Information section does not have all the expected fields", Status.FAIL);
		}

		/***** Validating Address Information Section *****/

		List<WebElement> createNewLeadAddressInformationSectionFieldsOnPage = driver.findElements(By.xpath("//h3[contains(@class,'section__title') and contains(@class,'section-header')]/span[text()='Address Information']/following::div[1]//label/span"
																												+"|//h3[contains(@class,'section__title') and contains(@class,'section-header')]/span[text()='Address Information']/following::div[1]//span[contains(@id,'a-label')]"
																												+"|//h3[contains(@class,'section__title') and contains(@class,'section-header')]/span[text()='Address Information']/following::div[1]//legend[contains(@class,'label inputLabel')]"));
		List<String> createNewLeadAddressInformationSectionFieldsFound = new ArrayList<String>();
		for (WebElement element : createNewLeadAddressInformationSectionFieldsOnPage) {
			createNewLeadAddressInformationSectionFieldsFound.add(element.getText());
		}

		customPageAddressInformationFields();
		sectionFieldsCount = Utility_Functions.xValidatePickListValuesPage(customPageAddressInformationFieldsList, createNewLeadAddressInformationSectionFieldsFound, "Address Information Section Fields");
		if (sectionFieldsCount.size() == 0) {
			report.updateTestLog("Create New Lead Custom Page - Address Information Section",
					"Address Information section has all the expected fields", Status.PASS);
		} else {
			report.updateTestLog("Create New Lead Custom Page - Address Information Section",
					"Address Information section doe not have all the expected fields", Status.FAIL);
		}

		/***** Validating Contact Information Section *****/

		List<WebElement> createNewLeadContactInformationSectionFieldsOnPage = driver.findElements(By.xpath("//h3[contains(@class,'section__title') and contains(@class,'section-header')]/span[text()='Contact Information']/following::div[1]//label/span"
																											+"|//h3[contains(@class,'section__title') and contains(@class,'section-header')]/span[text()='Contact Information']/following::div[1]//span[contains(@id,'a-label')]"));
		List<String> createNewLeadContactInformationSectionFieldsFound = new ArrayList<String>();
		for (WebElement element : createNewLeadContactInformationSectionFieldsOnPage) {
			createNewLeadContactInformationSectionFieldsFound.add(element.getText());
		}

		customPageContactInformationFields();
		sectionFieldsCount = Utility_Functions.xValidatePickListValuesPage(customPageContactInformationFieldsList,	createNewLeadContactInformationSectionFieldsFound, "Contact Information Section Fields");
		if (sectionFieldsCount.size() == 0) {
			report.updateTestLog("Create New Lead Custom Page - Contact Information Section",
					"Contact Information section has all the expected fields", Status.PASS);
		} else {
			report.updateTestLog("Create New Lead Custom Page - Contact Information Section",
					"Contact Information section does not have all the expected fields", Status.FAIL);
		}

		/***** Validating Communication Preferences Section *******/

		List<WebElement> createNewLeadCommunicationPreferencesSectionFieldsOnPage = driver.findElements(By.xpath("//h3[contains(@class,'section__title') and contains(@class,'section-header')]/span[text()='Communication Preferences']/following::div[1]//label/span"
																											+"|//h3[contains(@class,'section__title') and contains(@class,'section-header')]/span[text()='Communication Preferences']/following::div[1]//span[contains(@id,'a-label')]"));
		List<String> createNewLeadCommunicationPreferencesSectionFieldsFound = new ArrayList<String>();
		for (WebElement element : createNewLeadCommunicationPreferencesSectionFieldsOnPage) {
			createNewLeadCommunicationPreferencesSectionFieldsFound.add(element.getText());
		}

		customPageCommunicationPreferencesFields();
		sectionFieldsCount = Utility_Functions.xValidatePickListValuesPage(customPageCommunicationPreferencesFieldsList, createNewLeadCommunicationPreferencesSectionFieldsFound, "Communication Preferences Section Fields");
		if (sectionFieldsCount.size() == 0) {
			report.updateTestLog("Create New Lead Custom Page - Communication Preferences Section",
					"Communication Preferences section has all the expected fields", Status.PASS);
		} else {
			report.updateTestLog("Create New Lead Custom Page - Communication Preferences Section",
					"Communication Preferences section does not have all the expected fields", Status.FAIL);
		}

		/***** Validating Prospect Requirements Section *****/

		List<WebElement> createNewLeadProspectRequirementsSectionFieldsOnPage = driver.findElements(By.xpath("//h3[contains(@class,'section__title') and contains(@class,'section-header')]/span[text()='Prospect Requirements']/following::div[1]//label/span"
																										+"|//h3[contains(@class,'section__title') and contains(@class,'section-header')]/span[text()='Prospect Requirements']/following::div[1]//span[contains(@id,'a-label')]"));
		List<String> createNewLeadProspectRequirementsSectionFieldsFound = new ArrayList<String>();
		for (WebElement element : createNewLeadProspectRequirementsSectionFieldsOnPage) {
			createNewLeadProspectRequirementsSectionFieldsFound.add(element.getText());
		}

		customPageProspectRequirementsFields();
		sectionFieldsCount = Utility_Functions.xValidatePickListValuesPage(customPageProspectRequirementsFieldsList, createNewLeadProspectRequirementsSectionFieldsFound, "Prospect Requirements Section Fields");
		if (sectionFieldsCount.size() == 0) {
			report.updateTestLog("Create New Lead Custom Page - Prospect Requirements Section",
					"Prospect Requirements section has all the expected fields", Status.PASS);
		} else {
			report.updateTestLog("Create New Lead Custom Page - Prospect Requirements Section",
					"Prospect Requirements section does not have all the expected fields", Status.FAIL);
		}

		/***** Validating Additional Information Section *****/

		List<WebElement> createNewLeadAdditionalInformationSectionFieldsOnPage = driver.findElements(By.xpath("//h3[contains(@class,'section__title') and contains(@class,'section-header')]/span[text()='Additional Information']/following::div[1]//label/span"
																										+"|//h3[contains(@class,'section__title') and contains(@class,'section-header')]/span[text()='Additional Information']/following::div[1]//span[contains(@id,'a-label')]"));
		List<String> createNewLeadAdditionalInformationSectionFieldsFound = new ArrayList<String>();
		for (WebElement element : createNewLeadAdditionalInformationSectionFieldsOnPage) {
			createNewLeadAdditionalInformationSectionFieldsFound.add(element.getText());
		}

		customPageAdditionalInformationFields();
		sectionFieldsCount = Utility_Functions.xValidatePickListValuesPage(customPageAdditionalInformationFieldsList, createNewLeadAdditionalInformationSectionFieldsFound, "Additional Information Section Fields");
		if (sectionFieldsCount.size() == 0) {
			report.updateTestLog("Create New Lead Custom Page - Additional Information Section",
					"Additional Information section has all the expected fields", Status.PASS);
		} else {
			report.updateTestLog("Create New Lead Custom Page - Additional Information Section",
					"Additional Information section does not have all the expected fields", Status.FAIL);
		}
	}
	

	/**
	 * Validating the Convert Lead with Direct Line and Private Note
	 * 
	 * @author Ramya
	 *
	 */

	static ArrayList<String> convertLeadRequiredFieldsList = new ArrayList<String>();
	public void convertLeadRequiredFields() {
		convertLeadRequiredFieldsList.add("*Converted Status");
		convertLeadRequiredFieldsList.add("*Record Owner");
		convertLeadRequiredFieldsList.add("*Account Name");
		convertLeadRequiredFieldsList.add("*Street");
		convertLeadRequiredFieldsList.add("*Country");
		convertLeadRequiredFieldsList.add("*State");
		convertLeadRequiredFieldsList.add("*City");
		convertLeadRequiredFieldsList.add("*Zip/Postal Code");
		convertLeadRequiredFieldsList.add("Opportunity Name");		
		System.out.println("Custom Page Lead Information fields are " + convertLeadRequiredFieldsList);
	}

	public void convertLeadWithDirectLineAndPrivateNote() {
		createLeadFunction();
		Utility_Functions.timeWait(2);
		Utility_Functions.xWaitForElementPresent(driver, selectPreferedPropertyType, 2);
		Utility_Functions.xClick(driver, selectPreferedPropertyType, true);
		Utility_Functions.xWaitForElementPresent(driver, selectPreferedPropertyTypeValue, 2);
		Utility_Functions.xClick(driver, selectPreferedPropertyTypeValue, true);
		report.updateTestLog("Verify Convert Lead with Direct Line and Private Note", "The Prefered Property type is selected", Status.PASS);
		Utility_Functions.timeWait(2);
		Utility_Functions.xScrollWindow(driver);
		Utility_Functions.timeWait(2);
		Utility_Functions.xScrollWindowTop(driver);
		Utility_Functions.timeWait(2);
		Utility_Functions.xWaitForElementPresent(driver, directLineLead, 2);
		Utility_Functions.xSendKeys(driver, directLineLead, dataTable.getData("General_Data", "Direct Line"));
		report.updateTestLog("Verify Convert Lead with Direct Line and Private Note","The Direct Line value is entered", Status.PASS);
		Utility_Functions.timeWait(2);
		Utility_Functions.xWaitForElementPresent(driver, saveButton, 2);
		Utility_Functions.xClick(driver, saveButton, true);
		report.updateTestLog("Verify Convert Lead with Direct Line and Private Note","The New Lead page is entered with direct Line and Prefered Property type value", Status.PASS);
		Utility_Functions.timeWait(2);
		Utility_Functions.xWaitForElementPresent(driver, convert, 2);
		Utility_Functions.xClick(driver,convert, true);
		Utility_Functions.timeWait(2);
		Utility_Functions.xSwitchtoFrame(driver, convertButton);
		Utility_Functions.timeWait(5);
		convertLeadRequiredFieldsList.clear();
		convertLeadRequiredFields();
		List<WebElement> convertList = driver.findElements(By.xpath("//label[@class='slds-form-element__label']"));
		int i1 = 0, j=0, countLabelList = 0;
		String[] labelTexts = new String[convertList.size()];
		while(j<convertLeadRequiredFieldsList.size()) {
			for (WebElement element : convertList) {
				labelTexts[i1] = element.getText();
				if (labelTexts[i1].contains(convertLeadRequiredFieldsList.get(j))) {
					System.out.println("Verify Convert Lead with Direct Line and Private Note" + element.getText());
					report.updateTestLog("Verify Convert Lead with Direct Line and Private Note", ":::: Lead Convert  page is having the:::" + element.getText(), Status.PASS);
					countLabelList++;
				}
				i1++;
				if(countLabelList ==8) 
					break;
			}
			i1=0;
			j++;
		}
		System.out.println("Custom Page Lead Information fields are:::"+ countLabelList);
		if (countLabelList != 8) {
			report.updateTestLog("Verify Convert Lead with Direct Line and Private Note","All fields are not present in the Lead Convert Page", Status.FAIL);
		} else {
			report.updateTestLog("Verify Convert Lead with Direct Line and Private Note","All fields are present in the Lead Convert Page", Status.PASS);
		}
		convertList.clear();
		Utility_Functions.timeWait(2);
		Utility_Functions.xScrollWindow(driver);
		Utility_Functions.timeWait(2);
		Utility_Functions.xScrollWindowTop(driver);
		Utility_Functions.timeWait(2);
		Utility_Functions.xWaitForElementPresent(driver,convertLeadStreet, 5);
		Utility_Functions.xSendKeys(driver,convertLeadStreet, dataTable.getData("General_Data", "Street"));
		report.updateTestLog("Verify Convert Lead with Direct Line and Private Note","The New Lead page is entered with the street value", Status.PASS);
		Utility_Functions.xWaitForElementPresent(driver,convertLeadCity, 5);
		Utility_Functions.xSendKeys(driver,convertLeadCity, dataTable.getData("General_Data", "City"));
		report.updateTestLog("Verify Convert Lead with Direct Line and Private Note","The New Lead page is entered with the city value", Status.PASS);
		Utility_Functions.xWaitForElementPresent(driver,convertLeadCountry, 3);
		Utility_Functions.xClick(driver,convertLeadCountry, true);
		Utility_Functions.xWaitForElementPresent(driver,selectConvertLeadCountry, 3);
		Utility_Functions.xClick(driver,selectConvertLeadCountry, true);
		report.updateTestLog("Verify Convert Lead with Direct Line and Private Note","The New Lead page is entered with the Country value", Status.PASS);
		Utility_Functions.xWaitForElementPresent(driver,convertLeadState, 3);
		Utility_Functions.xClick(driver,convertLeadState, true);
		Utility_Functions.xWaitForElementPresent(driver,selectConvertLeadState, 3);
		Utility_Functions.xClick(driver,selectConvertLeadState, true);
		report.updateTestLog("Verify Convert Lead with Direct Line and Private Note","The New Lead page is entered with the State value", Status.PASS);
		Utility_Functions.xWaitForElementPresent(driver, zipCodeField, 5);
		Utility_Functions.xSendKeys(driver, zipCodeField, dataTable.getData("General_Data", "Zipcode"));
		report.updateTestLog("Verify Convert Lead with Direct Line and Private Note","The New Lead page is entered with the Zipcode", Status.PASS);
		Utility_Functions.xWaitForElementPresent(driver,convertButton, 3);
		Utility_Functions.xClick(driver,convertButton, true);
		report.updateTestLog("Verify Convert Lead with Direct Line and Private Note","The Lead is converted with the required fields", Status.PASS);
		Utility_Functions.timeWait(2);
		driver.switchTo().defaultContent();
		driver.navigate().refresh();
		Utility_Functions.timeWait(2);
		Utility_Functions.xWaitForElementPresent(driver,related, 3);
		Utility_Functions.xClick(driver,related, true);
		Utility_Functions.timeWait(2);
		Utility_Functions.xWaitForElementPresent(driver,accountsRelatedContacts, 3);
		Utility_Functions.xClick(driver,accountsRelatedContacts, true);
		Utility_Functions.xWaitForElementPresent(driver, contactsList, 3);
		Utility_Functions.xclickOnFirstElementfromList(contactsList);
		Utility_Functions.timeWait(2);
		driver.switchTo().defaultContent();
		driver.navigate().refresh();
		Utility_Functions.timeWait(2);
		Utility_Functions.xWaitForElementPresent(driver, more, 3);
		Utility_Functions.xClick(driver, more, true);
		Utility_Functions.xWaitForElementPresent(driver, otherRelated, 3);
		Utility_Functions.xClick(driver, otherRelated, true);
		Utility_Functions.timeWait(3);
		Utility_Functions.xScrollWindow(driver);
		Utility_Functions.timeWait(1);
		Utility_Functions.xScrollWindowTop(driver);
		Utility_Functions.timeWait(2);
		Utility_Functions.xWaitForElementPresent(driver, privateNotes, 5);
		Utility_Functions.xClick(driver, privateNotes, true);
		Utility_Functions.xWaitForElementPresent(driver, leadsList, 3);
		for (WebElement element : leadsList ) {
			if ((!element.getText().equals(" "))){
				report.updateTestLog("Verify Convert Lead with Direct Line and Private Note","The Private Notes is created with the deafult contact values ",Status.PASS);
			} else {
				report.updateTestLog("Verify Convert Lead with Direct Line and Private Note","The Private Notes is created with the deafult contact values ",Status.FAIL);
			}
		}
	}
	/**
	 * Validating the Convert Lead with Private Note
	 * 
	 * @author Ramya
	 *
	 */



	public void convertLeadWithPrivateNote() {
		createLeadFunction();
		Utility_Functions.timeWait(2);
		Utility_Functions.xWaitForElementPresent(driver, selectPreferedPropertyType, 2);
		Utility_Functions.xClick(driver, selectPreferedPropertyType, true);
		Utility_Functions.xWaitForElementPresent(driver, selectPreferedPropertyTypeValue, 2);
		Utility_Functions.xClick(driver, selectPreferedPropertyTypeValue, true);
		report.updateTestLog("Verify Convert Lead with Direct Line and Private Note",
				"The Prefered Property type is selected", Status.PASS);
		Utility_Functions.timeWait(2);
		Utility_Functions.xScrollWindow(driver);
		Utility_Functions.timeWait(2);
		Utility_Functions.xScrollWindowTop(driver);
		Utility_Functions.timeWait(2);
		Utility_Functions.xWaitForElementPresent(driver, directLineLead, 2);
		Utility_Functions.xSendKeys(driver, directLineLead, dataTable.getData("General_Data", "Direct Line"));
		report.updateTestLog("Verify Convert Lead with Direct Line and Private Note","The Direct Line value is entered", Status.PASS);
		Utility_Functions.timeWait(2);
		Utility_Functions.xClick(driver, saveButton, true);
		Utility_Functions.timeWait(2);
		driver.switchTo().defaultContent();
		Utility_Functions.timeWait(1);
		Utility_Functions.xWaitForElementPresent(driver,related, 3);
		Utility_Functions.xClick(driver,related, true);
		Utility_Functions.xScrollWindow(driver);
		Utility_Functions.timeWait(1);
		Utility_Functions.xScrollWindowTop(driver);
		Utility_Functions.timeWait(2);
		Utility_Functions.xWaitForElementPresent(driver, new_PrivateNotes, 3);
		Utility_Functions.xClick(driver, new_PrivateNotes, true);
		Utility_Functions.timeWait(3);
		Utility_Functions.xClick(driver, next, true);
		Utility_Functions.timeWait(3);
		Utility_Functions.xClick(driver, titleName, true);
		Utility_Functions.xClick(driver, account_PrivateNotes, true);
		Utility_Functions.timeWait(2);
		Random random = new Random();
		int value = random.nextInt();
		Utility_Functions.xSendKeys(driver, titleName, "Test Note" + value);
		Utility_Functions.timeWait(2);
		Utility_Functions.xClick(driver, savePersonalInformation, true);
		Utility_Functions.timeWait(3);
		Utility_Functions.xWaitForElementPresent(driver, convert, 2);
		Utility_Functions.xClick(driver,convert, true);
		Utility_Functions.timeWait(2);
		Utility_Functions.xSwitchtoFrame(driver, convertButton);
		Utility_Functions.timeWait(5);
		try {
			if(convertedStatus.getText().contains("Qualified")&&(recordOwnerText!= null)&&(accountName!= null)) {
				System.out.println("All the required fields are populated with the default values");
				report.updateTestLog("Convert Lead Page", "The Converted Status, Record owner and the Account Name fields are populated with the default values" ,Status.PASS);
			} 
		} catch (Exception e) {
			System.out.println("The Converted Status, Record owner and the Account Name fields are not populated with the default values:::" + e.getMessage());		
		}
		Utility_Functions.timeWait(2);
		Utility_Functions.xScrollWindow(driver);
		Utility_Functions.timeWait(2);
		Utility_Functions.xScrollWindowTop(driver);
		Utility_Functions.timeWait(2);
		Utility_Functions.xWaitForElementPresent(driver,convertLeadStreet, 5);
		Utility_Functions.xSendKeys(driver,convertLeadStreet, dataTable.getData("General_Data", "Street"));
		report.updateTestLog("Verify Convert Lead with Direct Line and Private Note","The New Lead page is entered with the street value", Status.PASS);
		Utility_Functions.xWaitForElementPresent(driver,convertLeadCity, 5);
		Utility_Functions.xSendKeys(driver,convertLeadCity, dataTable.getData("General_Data", "City"));
		report.updateTestLog("Verify Convert Lead with Direct Line and Private Note","The New Lead page is entered with the city value", Status.PASS);
		Utility_Functions.xWaitForElementPresent(driver,convertLeadCountry, 3);
		Utility_Functions.xClick(driver,convertLeadCountry, true);
		Utility_Functions.xWaitForElementPresent(driver,selectConvertLeadCountry, 3);
		Utility_Functions.xClick(driver,selectConvertLeadCountry, true);
		report.updateTestLog("Verify Convert Lead with Direct Line and Private Note","The New Lead page is entered with the Country value", Status.PASS);
		Utility_Functions.xWaitForElementPresent(driver,convertLeadState, 3);
		Utility_Functions.xClick(driver,convertLeadState, true);
		Utility_Functions.xWaitForElementPresent(driver,selectConvertLeadState, 3);
		Utility_Functions.xClick(driver,selectConvertLeadState, true);
		report.updateTestLog("Verify Convert Lead with Direct Line and Private Note","The New Lead page is entered with the State value", Status.PASS);
		Utility_Functions.xWaitForElementPresent(driver, zipCodeField, 5);
		Utility_Functions.xSendKeys(driver, zipCodeField, dataTable.getData("General_Data", "Zipcode"));
		report.updateTestLog("Verify Convert Lead with Direct Line and Private Note",
				"The New Lead page is entered with the Zipcode", Status.PASS);
		Utility_Functions.xWaitForElementPresent(driver,convertButton, 3);
		Utility_Functions.xClick(driver,convertButton, true);
		report.updateTestLog("Verify Convert Lead with Direct Line and Private Note","The Lead is converted with the required fields", Status.PASS);
		Utility_Functions.timeWait(4);
		driver.switchTo().defaultContent();
		driver.navigate().refresh();
		Utility_Functions.timeWait(2);
		Utility_Functions.xWaitForElementPresent(driver,related, 3);
		Utility_Functions.xClick(driver,related, true);
		Utility_Functions.timeWait(3);
		Utility_Functions.xWaitForElementPresent(driver,accountsRelatedContacts, 3);
		Utility_Functions.xClick(driver,accountsRelatedContacts, true);
		Utility_Functions.xWaitForElementPresent(driver, contactsList, 3);
		Utility_Functions.xclickOnFirstElementfromList(contactsList);
		Utility_Functions.timeWait(2);
		driver.switchTo().defaultContent();
		driver.navigate().refresh();
		Utility_Functions.timeWait(2);
		Utility_Functions.xWaitForElementPresent(driver, more, 3);
		Utility_Functions.xClick(driver, more, true);
		Utility_Functions.xWaitForElementPresent(driver, otherRelated, 3);
		Utility_Functions.xClick(driver, otherRelated, true);
		Utility_Functions.timeWait(3);
		Utility_Functions.xScrollWindow(driver);
		Utility_Functions.timeWait(1);
		Utility_Functions.xScrollWindowTop(driver);
		Utility_Functions.timeWait(2);
		Utility_Functions.xWaitForElementPresent(driver, privateNotes, 5);
		Utility_Functions.xClick(driver, privateNotes, true);
		Utility_Functions.xWaitForElementPresent(driver, leadsList, 3);
		for (WebElement element : leadsList ) {
			if ((!element.getText().equals(" "))){
				report.updateTestLog("Verify Convert Lead with Direct Line and Private Note","The Private Notes is created with the deafult contact values ",Status.PASS);
			} else {
				report.updateTestLog("Verify Convert Lead with Direct Line and Private Note","The Private Notes is created with the deafult contact values ",Status.FAIL);
			}

		}
	}
	/**
	 * Validating the Convert Lead with Private Note
	 * 
	 * @author Ramya
	 *
	 */	

	public void convertLeadWithEmail() {
		convertLeadNewAccount();
		Utility_Functions.timeWait(5);
		driver.switchTo().defaultContent();
		driver.navigate().refresh();
		Utility_Functions.timeWait(3);
		Utility_Functions.xWaitForElementPresent(driver,related, 3);
		Utility_Functions.xClick(driver,related, true);
		Utility_Functions.timeWait(2);
		Utility_Functions.xWaitForElementPresent(driver,accountsRelatedContacts, 3);
		Utility_Functions.xClick(driver,accountsRelatedContacts, true);
		Utility_Functions.xWaitForElementPresent(driver, contactsList, 3);
		Utility_Functions.xclickOnFirstElementfromList(contactsList);
		Utility_Functions.timeWait(2);
		driver.switchTo().defaultContent();
		driver.navigate().refresh();
		Utility_Functions.timeWait(2); 
		Utility_Functions.xWaitForElementPresent(driver, more, 3);
		Utility_Functions.xClick(driver, more, true);
		Utility_Functions.xWaitForElementPresent(driver, otherRelated, 3);
		Utility_Functions.xClick(driver,otherRelated, true);
		Utility_Functions.timeWait(3);
		Utility_Functions.xScrollWindow(driver);
		Utility_Functions.timeWait(1);
		Utility_Functions.xScrollWindowTop(driver);
		Utility_Functions.timeWait(2);
		Utility_Functions.xWaitForElementPresent(driver, privateNotes, 5);
		Utility_Functions.xClick(driver, privateNotes, true);
		Utility_Functions.xWaitForElementPresent(driver, leadsList, 3);
		for (WebElement element : leadsList ) {
			if ((!element.getText().equals(" "))){
				report.updateTestLog("Verify Convert Lead with Email","The Private Notes is created with the deafult contact values ",Status.PASS);
			}else
			{
				report.updateTestLog("Verify Convert Lead with Email","The Private Notes is created with the deafult contact values ",Status.FAIL);
			}
		}
	}

	public void spinnerAlert() {
		Utility_Functions.timeWait(1);
		if(driver.findElement(By.xpath(leadConvertWaitSpinnerXPath)).isDisplayed()){
			Utility_Functions.xWaitForElementDisappear(driver, By.xpath(leadConvertWaitSpinnerXPath), 30);
		}
		if(driver.findElement(By.xpath(leadConvertWaitSpinnerXPath)).isDisplayed()){
			report.updateTestLog("Lead Convert Warning", "Excessive wait time to convert lead page encountered.", Status.WARNING);
			Utility_Functions.xWaitForElementDisappear(driver, By.xpath(leadConvertWaitSpinnerXPath), 90);
		}
	}
	/**
	 * Validating the Leads Landing Page 
	 * 
	 * @author Ramya
	 *
	 */	

	static ArrayList<String> leadsDetailsPageFieldsList = new ArrayList<String>();

	public void leadsDetailsPageFields() {
		leadsDetailsPageFieldsList.add("Name");
		leadsDetailsPageFieldsList.add("Rating");
		leadsDetailsPageFieldsList.add("Middle Name");
		leadsDetailsPageFieldsList.add("Lead Source");
		leadsDetailsPageFieldsList.add("Nickname");
		leadsDetailsPageFieldsList.add("Lead Status");
		leadsDetailsPageFieldsList.add("Title");
		leadsDetailsPageFieldsList.add("Lead Record Type");
		leadsDetailsPageFieldsList.add("Department");
		leadsDetailsPageFieldsList.add("Lead Owner");
		leadsDetailsPageFieldsList.add("Influence Level");
		//leadsDetailsPageFieldsList.add("Lead Owner User Market");
		leadsDetailsPageFieldsList.add("Company");
		leadsDetailsPageFieldsList.add("Represented By (Firm)");
		leadsDetailsPageFieldsList.add("Industry");
		leadsDetailsPageFieldsList.add("Website");
		leadsDetailsPageFieldsList.add("Lead Record Counter");


		System.out.println("Leads Details Page Lead Information fields are " + leadsDetailsPageFieldsList);
	}

	static ArrayList<String> addressInformationSectionFieldsList = new ArrayList<String>();

	public void addressInformationFields() {

		addressInformationSectionFieldsList.add("Address");

		System.out.println("Address Information section fields are " +addressInformationSectionFieldsList );
	}

	static ArrayList<String> communicationPreferencesSectionFieldsList = new ArrayList<String>();

	public void communicationPreferencesFields() {
		communicationPreferencesSectionFieldsList.add("Email Options");
		communicationPreferencesSectionFieldsList.add("Call Options");
		communicationPreferencesSectionFieldsList.add("Mail Options");

		System.out.println("Communication Preferences fields are " +communicationPreferencesSectionFieldsList);
	}
	static ArrayList<String> prospectRequirementsSectionFieldsList = new ArrayList<String>();

	public void prospectRequirementsFields() {
		prospectRequirementsSectionFieldsList.add("Preferred Property Type");
		prospectRequirementsSectionFieldsList.add("Total Size");
		prospectRequirementsSectionFieldsList.add("Preferred Property Sub-Type");
		prospectRequirementsSectionFieldsList.add("Unit of Measure");
		prospectRequirementsSectionFieldsList.add("Total # of Units");
		prospectRequirementsSectionFieldsList.add("Requirement Details");
		prospectRequirementsSectionFieldsList.add("Unit of Comparison");
		prospectRequirementsSectionFieldsList.add("Existing Lease Expiration");
		prospectRequirementsSectionFieldsList.add("Existing Termination/Break Option");

		System.out.println("Prospect Requirements fields are " + prospectRequirementsSectionFieldsList);
	}

	static ArrayList<String> customLinksSectionFieldsList = new ArrayList<String>();

	public void customLinksFields() {
		customLinksSectionFieldsList.add("LinkedIn");
		customLinksSectionFieldsList.add("Google Maps");
		customLinksSectionFieldsList.add("Google News");

		System.out.println("Custom Links fields are " +customLinksSectionFieldsList);
	}
	static ArrayList<String> additionalInformationFieldsList = new ArrayList<String>();

	public void additionalInformationFields() {
		additionalInformationFieldsList.add("Assistant Name");
		additionalInformationFieldsList.add("Unmapped Fields");
		additionalInformationFieldsList.add("Assistant Phone");
		additionalInformationFieldsList.add("Next Steps");
		additionalInformationFieldsList.add("Assistant Email");		
		System.out.println("Additional Information fields are " +additionalInformationFieldsList);
	}

	static ArrayList<String> contactInformationFieldsList = new ArrayList<String>();

	public void contactInformationFields() {
		contactInformationFieldsList.add("Direct Line");
		contactInformationFieldsList.add("Mobile");
		contactInformationFieldsList.add("Main Phone");
		contactInformationFieldsList.add("Email");
		contactInformationFieldsList.add("Fax");

		System.out.println("Contact Information fields are " +contactInformationFieldsList);
	}

	static ArrayList<String> leadsDeatilsPageHeadersList = new ArrayList<String>();

	public void leadsDetailsPageHeaders() {
		leadsDeatilsPageHeadersList.add("Tagging");
		leadsDeatilsPageHeadersList.add("Lead Information");
		leadsDeatilsPageHeadersList.add("Address Information");
		leadsDeatilsPageHeadersList.add("Contact Information");
		leadsDeatilsPageHeadersList.add("Communication Preferences");
		leadsDeatilsPageHeadersList.add("Prospect Requirements");
		leadsDeatilsPageHeadersList.add("Additional Information");
		leadsDeatilsPageHeadersList.add("System Information");
		leadsDeatilsPageHeadersList.add("Custom Links");

		System.out.println("Contact Details Page headers are:: " +leadsDeatilsPageHeadersList);
	}

	public void leadsVerifyLandingPage() {
		Utility_Functions.xWaitForElementPresent(driver, leads, 3);
		Utility_Functions.xClick(driver, leads, true);
		
		Utility_Functions.xWaitForElementPresent(driver, recentlyViewed, 3);
		Utility_Functions.xClick(driver, recentlyViewed, true);
		Utility_Functions.xWaitForElementPresent(driver, allLeads, 3);
		Utility_Functions.xClick(driver, allLeads, true);
		Utility_Functions.timeWait(3);
		List<WebElement> leadsList = driver.findElements(By.xpath(
				"//a[@class='slds-truncate outputLookupLink slds-truncate forceOutputLookup']"));
		Utility_Functions.xWaitForElementPresent(driver, leadsList, 3);
		Utility_Functions.xclickRandomElement(leadsList);
		Utility_Functions.timeWait(3);
		Utility_Functions.xScrollWindow(driver);
		Utility_Functions.timeWait(1);
		Utility_Functions.xScrollWindowTop(driver);
		Utility_Functions.timeWait(2);
		
		List<WebElement> contactDetailsPageHeadersList = driver.findElements(By.xpath("//span[contains(@class,'header-title')]"));
		int count0 = 0, i0 = 0;
		String fieldsArray0[] = new String[contactDetailsPageHeadersList.size()];
		System.out.println(contactDetailsPageHeadersList.size());

		try {
			leadsDetailsPageHeaders();
			for (WebElement element0 : contactDetailsPageHeadersList) {
				System.out.println(element0.getText());
				fieldsArray0[i0] = element0.getText();
				if (fieldsArray0[i0].contains(leadsDeatilsPageHeadersList.get(i0))) {
					report.updateTestLog("Verify Leads Landing Page",
							"Leads Details  page is having the " + fieldsArray0[i0] + " Headers ",
							Status.PASS);
					count0++;
				}
				i0++;
			}
			System.out.println(count0);
			if (count0 != 9) {
				report.updateTestLog("Verify Leads Landing Page",
						"All sections are not present in the Leads Details Page", Status.FAIL);
			} else {
				System.out.println("All sections are present::"+leadsDeatilsPageHeadersList);
				report.updateTestLog("Verify Leads Landing Page",
						"All sections are present in the Leads Details Page", Status.PASS);
			}
			leadsDeatilsPageHeadersList.clear();
		} catch (Exception e) {
			System.out.println("All sections are not present in the Leads Details Page:::" + e.getMessage());
		}

		List<WebElement> leadInformationFieldsList = driver.findElements(
				By.xpath("//h3//span[text()='Lead Information']/ancestor::h3/parent::div/div[1]//span[contains(@class,'test-id__field-label')and text()!='']"));
		int count = 0, i = 0;
		String fieldsArray[] = new String[leadInformationFieldsList.size()];
		System.out.println(leadInformationFieldsList.size());

		try {
			leadsDetailsPageFields();
			for (WebElement element :leadInformationFieldsList) {
				System.out.println(element.getText());
				fieldsArray[i] = element.getText();
				if (fieldsArray[i].equalsIgnoreCase(leadsDetailsPageFieldsList.get(i))) {
					report.updateTestLog("Verify Leads Landing Page",
							" Lead Information section is having the " + fieldsArray[i] + " fields ",
							Status.PASS);
					count++;
				}
				i++;
			}
			leadsDetailsPageFieldsList.clear();
			System.out.println(count);
			if (count != 17) {
				report.updateTestLog("Verify Leads Landing Page",
						"All fields are not present in the Lead Information Section", Status.FAIL);
			} else {

				report.updateTestLog("Verify Leads Landing Page",
						"All fields are present in the Lead Information Section", Status.PASS);
			}
			
		} catch (Exception e) {
			System.out.println("All fields are not present in the Lead Information Section:::" + e.getMessage());
		}
		List<WebElement> addressInformationFieldsList = driver.findElements(
				By.xpath("//h3//span[text()='Address Information']/ancestor::h3/parent::div/div[1]//span[contains(@class,'test-id__field-label')and text()!='']"));
		int count1 = 0, i1 = 0;
		String fieldsArray1[] = new String[addressInformationFieldsList.size()];
		System.out.println(addressInformationFieldsList.size());

		try {
			addressInformationFields();
			for (WebElement element1 :addressInformationFieldsList) {
				System.out.println(element1.getText());
				fieldsArray1[i1] = element1.getText();
				if (fieldsArray1[i1].equalsIgnoreCase(addressInformationSectionFieldsList.get(i1))) {
					report.updateTestLog("Verify Leads Landing Page",
							" Address Information Section is having the " + fieldsArray1[i1] + " fields ",
							Status.PASS);
					count1++;
				}
				i1++;
			}
			System.out.println(count1);
			if (count1!= 1) {
				report.updateTestLog("Verify Leads Landing Page",
						"All fields are not present in the Address Information Section", Status.FAIL);
			} else {

				report.updateTestLog("Verify Leads Landing Page",
						"All fields are present in the Address Information Section", Status.PASS);
			}
			addressInformationSectionFieldsList.clear();
		} catch (Exception e) {
			System.out.println("All fields are not present in the Address Information Section:::" + e.getMessage());
		}
		
		Utility_Functions.xScrollWindowOnce(driver);
		Utility_Functions.timeWait(2);
		
		List<WebElement> communicationPreferencesFieldsList = driver.findElements(
				By.xpath("//h3//span[text()='Communication Preferences']/ancestor::h3/parent::div/div[1]//span[contains(@class,'test-id__field-label')and text()!='']"));
		int count3 = 0, i3 = 0;
		String fieldsArray3[] = new String[communicationPreferencesFieldsList.size()];
		System.out.println(communicationPreferencesFieldsList.size());

		try {
			communicationPreferencesFields();
			for (WebElement element3 :communicationPreferencesFieldsList) {
				System.out.println(element3.getText());
				fieldsArray3[i3] = element3.getText();
				if (fieldsArray3[i3].equalsIgnoreCase(communicationPreferencesSectionFieldsList.get(i3))) {
					report.updateTestLog("Verify Leads Landing Page",
							" Communication Preferences is having the " + fieldsArray3[i3] + " fields ",
							Status.PASS);
					count3++;
				}
				i3++;
			}
			System.out.println(count3);
			if (count3!= 3) {
				report.updateTestLog("Verify Leads Landing Page",
						"All fields are not present in the Communication Preferences Section", Status.FAIL);
			} else {

				report.updateTestLog("Verify Leads Landing Page",
						"All fields are present in the Communication Preferences Section", Status.PASS);
			}
			communicationPreferencesSectionFieldsList.clear();
		} catch (Exception e) {
			System.out.println("All fields are not present in the Communication Preferences Section:::" + e.getMessage());
		}
		
		Utility_Functions.xScrollWindowOnce(driver);
		Utility_Functions.timeWait(2);
		
		List<WebElement> prospectRequirementsFieldsList = driver.findElements(
				By.xpath("//h3//span[text()='Prospect Requirements']/ancestor::h3/parent::div/div[1]//span[contains(@class,'test-id__field-label')and text()!='']"));
		int count4 = 0, i4 = 0;
		String fieldsArray4[] = new String[prospectRequirementsFieldsList.size()];
		System.out.println(prospectRequirementsFieldsList.size());

		try {
			prospectRequirementsFields();
			for (WebElement element4 :prospectRequirementsFieldsList) {
				System.out.println(element4.getText());
				fieldsArray4[i4] = element4.getText();
				if (fieldsArray4[i4].equalsIgnoreCase(prospectRequirementsSectionFieldsList.get(i4))) {
					report.updateTestLog("Verify Leads Landing Page",
							" Communication Preferences is having the " + fieldsArray4[i4] + " fields ",
							Status.PASS);
					count4++;
				}
				i4++;
			}
			System.out.println(count4);
			if (count4 >= 7) {
				report.updateTestLog("Verify Leads Landing Page",
						"All fields are present in the Communication Preferences Section", Status.PASS);
			} else {

				report.updateTestLog("Verify Leads Landing Page",
						"All fields are not present in the Communication Preferences Section", Status.FAIL);
			}
			prospectRequirementsSectionFieldsList.clear();
		} catch (Exception e) {
			System.out.println("All fields are not present in the Communication Preferences Section:::"+ e.getMessage());
		}
		List<WebElement> additionalInformationList = driver.findElements(By.xpath("//h3//span[text()='Additional Information']/ancestor::h3/parent::div/div[1]//span[contains(@class,'test-id__field-label')and text()!='']"));
		int count5 = 0, i5 = 0,j=0;
		String fieldsArray5[] = new String[additionalInformationList.size()];
		System.out.println(additionalInformationList.size());
		try {
			additionalInformationFieldsList.clear();
			additionalInformationFields();
			while(j<additionalInformationList.size()) {
				for (WebElement element5 : additionalInformationList) {
					fieldsArray5[i5] = element5.getText();
					if (fieldsArray5[i5].contains(additionalInformationFieldsList.get(j))) {
						System.out.println("Additional Information fields are " + element5.getText());
						report.updateTestLog("Verify Leads Landing Page ", element5.getText() + "labels  present in the Additional Information fields ", Status.PASS);
						count5++;
					}
					i5++;
				}
				i5=0;
				j++;
			}
			System.out.println(count5);
			if (count5!= 5) {
				report.updateTestLog("Verify Leads Landing Page",
						"All fields are not present in the Additional Information section", Status.FAIL);
			} else {
				report.updateTestLog("Verify Leads Landing Page",
						"All fields are present in the Additional Information section", Status.PASS);
			}
			
		} catch (Exception e) {
			System.out.println("All fields are not present in the Additional Information section:::" + e.getMessage());
		}
		additionalInformationFieldsList.clear();
		Utility_Functions.xScrollWindowOnce(driver);
		Utility_Functions.timeWait(2);
		
		List<WebElement> contactInformationList = driver.findElements(By.xpath("//h3//span[text()='Contact Information']/ancestor::h3/parent::div/div[1]//span[contains(@class,'test-id__field-label')and text()!='']"));
		int count6 = 0, i6 = 0,j2=0;
		String fieldsArray6[] = new String[contactInformationList.size()];
		System.out.println(contactInformationList.size());
		try {
			contactInformationFields();
			while(j2<contactInformationList.size()) {
				for (WebElement element6 :contactInformationList) {
					fieldsArray6[i6] = element6.getText();
					if (fieldsArray6[i6].contains(contactInformationFieldsList.get(j2))) {
						System.out.println("Contact Information fields are " + element6.getText());
						report.updateTestLog("Verify Leads Landing Page ", element6.getText() + "labels  present in the Account Detailed Page ", Status.PASS);
						count6++;
					}
					i6++;
				}
				i6=0;
				j2++;
			}
			System.out.println(count6);
			if (count6!= 5) {
				report.updateTestLog("Verify Leads Landing Page","All fields are not present in the Contact Information section", Status.FAIL);
			} else {
				report.updateTestLog("Verify Leads Landing Page","All fields are present in the Contact Information section", Status.PASS);
			}
		} catch (Exception e) {
			System.out.println("All fields are not present in the Contact Information section:::"+ e.getMessage());
		}
		contactInformationFieldsList.clear();
		List<WebElement> customLinksList = driver.findElements(By.xpath("//h3//span[text()='Custom Links']/ancestor::h3/parent::div/div[1]//a"));
		int count7 = 0, i7 = 0,j1=0;
		String fieldsArray7[] = new String[customLinksList.size()];
		System.out.println(customLinksList.size());
		try {
			customLinksFields();
			while(j1<customLinksList.size()) {
				for (WebElement element7 : customLinksList) {
					fieldsArray7[i7] = element7.getText();
					if (fieldsArray7[i7].contains(customLinksSectionFieldsList.get(j1))) {
						System.out.println("Custom Link fields are " + element7.getText());
						report.updateTestLog("Verify Leads Landing Page ", element7.getText() + "labels  present in the Account Detailed Page ", Status.PASS);
						count7++;
					}
					i7++;
				}
				i7=0;
				j1++;
			}
			System.out.println(count7);
			if (count7 != 3) {
				report.updateTestLog("Verify Leads Landing Page","All fields are not present in the Custom Links section", Status.FAIL);
			} else {
				report.updateTestLog("Verify Leads Landing Page","All fields are present in the Custom Links section", Status.PASS);
			}
			customLinksSectionFieldsList.clear();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	/**
	 * Validating the Lead Sharing functionality
	 * 
	 * @author Ramya
	 *
	 */

	LoginPage loginPage = new LoginPage(scriptHelper);

	public void leadsSharingFunctionality() {

		Utility_Functions.xWaitForElementPresent(driver, leads, 3);
		Utility_Functions.xClick(driver, leads, true);
		Utility_Functions.xWaitForElementPresent(driver, leadsList, 3);
		Utility_Functions.xclickRandomElement(leadsList);
		privateNoteSharing();
	}

	/**
	 * Validating the Lead Log A Call Page functionality
	 * 
	 * @author Ramya
	 *
	 */
	static ArrayList<String> logACallPageSectionsList = new ArrayList<String>();

	public void logACallPageHeaders() {

		logACallPageSectionsList.add("Task Information");
		logACallPageSectionsList.add("Related To");
		logACallPageSectionsList.add("Schedule follow-up task");
		logACallPageSectionsList.add("Task Information");
		logACallPageSectionsList.add("Related To");
		logACallPageSectionsList.add("Reminder");

		System.out.println("log A Call Page headers are " +logACallPageSectionsList);
	}
	public void leadCustomLogACallFunctionality() {
		Utility_Functions.xWaitForElementPresent(driver, leads, 3);
		Utility_Functions.xClick(driver, leads, true);
		Utility_Functions.xWaitForElementPresent(driver, leadsList, 3);
		Utility_Functions.xclickgetTextofFirstElementfromList(leadsList);
		Utility_Functions.timeWait(3);
		Utility_Functions.xWaitForElementPresent(driver,showMoreActions, 3);
		Utility_Functions.xClick(driver,showMoreActions, true);
		Utility_Functions.xWaitForElementPresent(driver,logACall, 3);
		Utility_Functions.xClick(driver,logACall, true);
		Utility_Functions.timeWait(3);
		Utility_Functions.xSwitchtoFrame(driver,subjectTop);
		Utility_Functions.timeWait(3);
		List<WebElement> logACallSectionsList = driver.findElements(
				By.xpath("//div/h2"));
		int count = 0, i = 0;
		String fieldsArray[] = new String[logACallSectionsList.size()];
		System.out.println(logACallSectionsList.size());

		try {
			logACallPageHeaders();
			for (WebElement element:logACallSectionsList) {
				System.out.println(element.getText());
				fieldsArray[i] = element.getText();
				if (fieldsArray[i].equalsIgnoreCase(logACallPageSectionsList.get(i))) {
					report.updateTestLog("Verify Leads Log A Call Page",
							" Log A Call Page is having the " + fieldsArray[i] + " Headers ",
							Status.PASS);
					count++;
				}
				i++;
			}
			System.out.println(count);
			if (count!= 6) {
				report.updateTestLog("Verify Leads Log A Call Page",
						"All Headers are not present in the Leads Log A Call Page", Status.FAIL);
			} else {

				report.updateTestLog("Verify Leads Log A Call Page",
						"All Headers are present in the Leads Log A Call Page", Status.PASS);
			}

		} catch (Exception e) {
			System.out.println("All Headers are not present in the Leads Log A Call Page:::"+e.getMessage());
		}
		Utility_Functions.xWaitForElementPresent(driver, subjectTop, 5);
		Utility_Functions.xSendKeys(driver, subject, "Test Automation Subject_" + Utility_Functions.xGenerateAlphaNumericString());
		Utility_Functions.xWaitForElementPresent(driver,activityTop, 3);
		Utility_Functions.xClick(driver, activityTop, true);
		Utility_Functions.timeWait(3);
		Utility_Functions.xScrollWindow(driver);
		Utility_Functions.timeWait(1);
		Utility_Functions.xScrollWindowTop(driver);
		Utility_Functions.timeWait(2);
		Utility_Functions.xWaitForElementPresent(driver,subjectBottom, 5);
		Utility_Functions.xSendKeys(driver,subjectBottom, "Test Automation Subject_" + Utility_Functions.xGenerateAlphaNumericString());
		Utility_Functions.xWaitForElementPresent(driver, activityBottom, 3);
		Utility_Functions.xClick(driver, activityBottom, true);
		Utility_Functions.xWaitForElementPresent(driver,saveLogCall, 3);
		Utility_Functions.xClick(driver, saveLogCall, true);
		Utility_Functions.timeWait(2);
		if(related.isDisplayed()) {
			Utility_Functions.xClick(driver, related, true);
			report.updateTestLog("Verify Leads Log A Call Page", "Log A Call is saved successfully with all the required fields", Status.PASS);
		} else {
			report.updateTestLog("Verify Leads Log A Call Page", "Log A Call is not saved with all the required fields", Status.FAIL);
		}		
	}
	/**
	 * Validating the Leads Activity Timeline
	 * @author Ramya
	 *
	 */
	public void verifyLeadsActivityTimeline() {
		Utility_Functions.xWaitForElementPresent(driver, leads, 3);
		Utility_Functions.xClick(driver, leads, true);
		report.updateTestLog("Verify Leads Activity Timeline","Leads is Displayed ",  Status.PASS);
		Utility_Functions.xWaitForElementPresent(driver, leadsList, 3);
		Utility_Functions.xclickgetTextofFirstElementfromList(leadsList);
		Utility_Functions.timeWait(3);
		report.updateTestLog("Verify Leads Activity Timeline ","The Account is Displayed ",  Status.PASS);
		Utility_Functions.xWaitForElementPresent(driver, related, 5);
		Utility_Functions.xClick(driver, related, true);
		report.updateTestLog("Verify Leads Activity Timeline","The related page is Displayed ",  Status.PASS);
		Utility_Functions.timeWait(4);
		Utility_Functions.xWaitForElementPresent(driver,activityTab, 5);
		Utility_Functions.xClick(driver, activityTab, true);
		int count = 0;
		try {
			if (activityTimeline.isDisplayed()) {
				System.out.println(
						"There are no activities for present, past and future dates in acitivity related list");
				report.updateTestLog("Verify Leads Activity Timeline",
						"There are no activities for present, past and future dates in acitivity related list:::",
						Status.PASS);
				count++;
			}
		} catch (Exception e) {
			if (activity.isDisplayed()) {
				System.out.println("Activity is present acitivity related list");
				report.updateTestLog("Verify Leads Activity Timeline",
						"Acitivity is present in acitivity related list:::", Status.PASS);
				if (activityType.getText().contains("Activity Type")) {
					System.out.println("Activity Type is present acitivity related list");
					report.updateTestLog("Verify Leads Activity Timeline",
							"Acitivity Type is present in acitivity related list:::", Status.PASS);
					count++;
				}
				if (statusActivityTimeLine.getText().contains("Status")) {
					System.out.println("Status is present acitivity related list");
					report.updateTestLog("Verify Leads Activity Timeline",
							"Status is present in acitivity related list:::", Status.PASS);
					count++;
				}
				if (comments.getText().contains("Comments")) {
					System.out.println("Comments sections is present acitivity related list");
					report.updateTestLog("Verify Leads Activity Timeline",
							"Comments section is present in acitivity related list:::", Status.PASS);
					count++;
				}
				if (dueDate.isDisplayed()) {
					System.out.println("Duedate is present acitivity related list");
					report.updateTestLog("Verify Leads Activity Timeline",
							"Duedate is present in acitivity related list:::", Status.PASS);
					count++;
				}
				if (statusCheckbox.isDisplayed()) {
					System.out.println("Status Checkbox is present acitivity related list");
					report.updateTestLog("Verify Leads Activity Timeline",
							"Status Checkbox is present in acitivity related list:::", Status.PASS);
				}
			}
			if (count == 4) {
				System.out.println(
						"Activity Type, Due Date, Comments and Status Checkbox are present under acitivity related list");
				report.updateTestLog("Verify Leads Activity Timeline",
						"Activity Type, Due Date, Comments and Status Checkbox are present under activity related list:::",
						Status.PASS);
			} else if (count == 1) {
				System.out.println(
						"There are no activities for present, past and future dates in acitivity related list");
			} else {
				System.out.println(
						"Activity Type, Due Date, Comments and Status Checkbox are not present under acitivity related list");
				report.updateTestLog("Verify Leads Activity Timeline",
						"Activity Type, Due Date, Comments and Status Checkbox are not present under activity related list:::",
						Status.FAIL);
			}
			e.printStackTrace();
			System.out.println(e.getMessage());
		}			
		Utility_Functions.xWaitForElementPresent(driver,pastActivity, 5);
		Utility_Functions.xClick(driver, pastActivity, true);
		report.updateTestLog("Verify Leads Activity Timeline",
				"The Past Activities is clicked",
				Status.PASS);

	}

	/**
	 * Validating the convert Lead with the existing Account
	 * @author Ramya
	 *
	 */
	public void leadConvertWithExistingAccount() {
		/*createLeadFunction();
		Utility_Functions.timeWait(2);
		Utility_Functions.xWaitForElementPresent(driver, selectPreferedPropertyType, 2);
		Utility_Functions.xClick(driver, selectPreferedPropertyType, true);
		Utility_Functions.xWaitForElementPresent(driver, selectPreferedPropertyTypeValue, 2);
		Utility_Functions.xClick(driver, selectPreferedPropertyTypeValue, true);
		report.updateTestLog("Verify Convert Lead with Existing Account", "The Prefered Property type is selected", Status.PASS);
		Utility_Functions.timeWait(2);
		Utility_Functions.xScrollWindow(driver);
		Utility_Functions.timeWait(2);
		Utility_Functions.xScrollWindowTop(driver);
		Utility_Functions.timeWait(2);
		Utility_Functions.xWaitForElementPresent(driver, directLineLead, 2);
		Utility_Functions.xSendKeys(driver, directLineLead, dataTable.getData("General_Data", "Direct Line"));
		report.updateTestLog("Verify Convert Lead with Existing Account","The Direct Line value is entered", Status.PASS);
		Utility_Functions.timeWait(2);
		Utility_Functions.xWaitForElementPresent(driver, saveButton, 2);
		Utility_Functions.xClick(driver, saveButton, true);
		report.updateTestLog("Verify Convert Lead with Existing Account","The New Lead page is entered with direct Line and Prefered Property type value", Status.PASS);
		Utility_Functions.timeWait(2);
		Utility_Functions.xWaitForElementPresent(driver, leadNameTitle, 3);
		String leadName = leadNameTitle.getText();
		SearchTextSOQL searchTextSOQL = new SearchTextSOQL(scriptHelper);
		String queryLead = "Select Id from Lead where Name = " +"'" + leadName + "'";
		String sLeadID = searchTextSOQL.fetchRecordFieldValue("Id", queryLead);*/
		LeadsFunctions leadsFunctions = new LeadsFunctions(scriptHelper);
		leadsFunctions.leadConversion();
		//leadsFunctions.leadConversion(sLeadID);
		/*Utility_Functions.xWaitForElementPresent(driver, convert, 2);
		Utility_Functions.xClick(driver,convert, true);
		Utility_Functions.timeWait(2);
		Utility_Functions.xSwitchtoFrame(driver, convertButton);
		Utility_Functions.timeWait(5);
		System.out.println("Frame identified");
		Utility_Functions.xScrollWindow(driver);
		Utility_Functions.timeWait(2);
		Utility_Functions.xScrollWindowTop(driver);
		Utility_Functions.timeWait(2);
		Utility_Functions.xWaitForElementPresent(driver,convertLeadStreet, 5);
		Utility_Functions.xSendKeys(driver,convertLeadStreet, dataTable.getData("General_Data", "Street"));
		report.updateTestLog("Verify Convert Lead with Existing Account","The New Lead page is entered with the street value", Status.PASS);
		Utility_Functions.xWaitForElementPresent(driver,convertLeadCity, 5);
		Utility_Functions.xSendKeys(driver,convertLeadCity, dataTable.getData("General_Data", "City"));
		report.updateTestLog("Verify Convert Lead with Existing Account","The New Lead page is entered with the city value", Status.PASS);
		Utility_Functions.xWaitForElementPresent(driver,convertLeadCountry, 3);
		Utility_Functions.xClick(driver,convertLeadCountry, true);
		Utility_Functions.xWaitForElementPresent(driver,selectConvertLeadCountry, 3);
		Utility_Functions.xClick(driver,selectConvertLeadCountry, true);
		report.updateTestLog("Verify Convert Lead with Existing Account","The New Lead page is entered with the Country value", Status.PASS);
		Utility_Functions.xWaitForElementPresent(driver,convertLeadState, 3);
		Utility_Functions.xClick(driver,convertLeadState, true);
		Utility_Functions.xWaitForElementPresent(driver,selectConvertLeadState, 3);
		Utility_Functions.xClick(driver,selectConvertLeadState, true);
		report.updateTestLog("Verify Convert Lead with Existing Account","The New Lead page is entered with the State value", Status.PASS);
		Utility_Functions.xWaitForElementPresent(driver, zipCodeField, 5);
		Utility_Functions.xSendKeys(driver, zipCodeField, dataTable.getData("General_Data", "Zipcode"));
		report.updateTestLog("Verify Convert Lead with Existing Account","The New Lead page is entered with the Zipcode", Status.PASS);
		Utility_Functions.xWaitForElementPresent(driver,convertButton, 3);
		Utility_Functions.xClick(driver,convertButton, true);
		report.updateTestLog("Verify Convert Lead with Existing Account","The Lead is converted with the required fields", Status.PASS);
		Utility_Functions.timeWait(2);
		driver.switchTo().defaultContent();
		driver.navigate().refresh();
		Utility_Functions.timeWait(2);
		Utility_Functions.xWaitForElementPresent(driver, related, 5);
		Utility_Functions.xClick(driver, related, true);
		report.updateTestLog("Verify Convert Lead with Existing Account","The related page is Displayed ",  Status.PASS);
		Utility_Functions.timeWait(4);
		Utility_Functions.xScrollWindow(driver);
		Utility_Functions.timeWait(1);
		Utility_Functions.xScrollWindowTop(driver);
		Utility_Functions.timeWait(2);
		Utility_Functions.xWaitForElementPresent(driver, relatedOpportunities, 5);
		Utility_Functions.xClick(driver, relatedOpportunities, true);
		Utility_Functions.xWaitForElementPresent(driver, opportunitiesList, 3);
		Utility_Functions.xclickgetTextofFirstElementfromList(opportunitiesList);
		Utility_Functions.timeWait(4);
		Utility_Functions.xScrollWindow(driver);
		Utility_Functions.timeWait(1);
		Utility_Functions.xScrollWindowTop(driver);
		Utility_Functions.timeWait(2);
		if (!opportunityAccountName.getText().contains(" ")) {
			System.out.println("Opportunity Account Name is populated with the default value");
			report.updateTestLog("Verify Convert Lead with Existing Account","Verifying the Account name is populated with the default value in the Opportunity Information Page ",  Status.PASS);
		} else {
			System.out.println("Opportunity Account Name is not populated with the default value");
			report.updateTestLog("Verify Convert Lead with Existing Account","Verifying the Account name is not populated with the default value in the Opportunity Information Page ",  Status.FAIL);
		}
		Utility_Functions.timeWait(2);
		driver.navigate().refresh();
		Utility_Functions.timeWait(2);
		Utility_Functions.xWaitForElementPresent(driver, related, 5);
		Utility_Functions.xClick(driver, related, true);
		Utility_Functions.xWaitForElementPresent(driver, contactRoles, 5);
		Utility_Functions.xClick(driver, contactRoles, true);
		Utility_Functions.xWaitForElementPresent(driver, contactsList, 3);
		Utility_Functions.xclickgetTextofFirstElementfromList(contactsList);
		Utility_Functions.timeWait(2);
		driver.navigate().refresh();
		Utility_Functions.timeWait(2);
		if(details.isDisplayed()) {

			report.updateTestLog("Verify Convert Lead with Existing Account", "Contacts Details page is displayed", Status.PASS);
		} else {
			report.updateTestLog("Verify Convert Lead with Existing Account", "Contacts Details page is not displayed", Status.FAIL);
		}*/

	}
	/**
	 * Validating the convert Lead with the new Account Name
	 * @author Ramya
	 *
	 */
	public void leadConvertWithNewAccount() {

		Utility_Functions.xWaitForElementPresent(driver, leads, 3);
		Utility_Functions.xClick(driver, leads, true);
		report.updateTestLog("Verify Lead Convert with New Account","Leads is Displayed ",  Status.PASS);
		Utility_Functions.xWaitForElementPresent(driver, leadsList, 3);
		Utility_Functions.xclickgetTextofFirstElementfromList(leadsList);
		Utility_Functions.timeWait(3);
		Utility_Functions.xWaitForElementPresent(driver, edit, 3);
		Utility_Functions.xClick(driver, edit, true);
		report.updateTestLog("Verify Lead Convert with New Account","The Lead is Displayed ",  Status.PASS);
		Utility_Functions.timeWait(2);
		Utility_Functions.xScrollWindow(driver);
		Utility_Functions.timeWait(2);
		Utility_Functions.xScrollWindowTop(driver);
		Utility_Functions.timeWait(2);
		Utility_Functions.xWaitForElementPresent(driver,leadEditFirstName, 5);
		Utility_Functions.xSendKeys(driver,leadEditFirstName, "Test Automation Subject_" + Utility_Functions.xGenerateAlphaNumericString());
		Utility_Functions.xWaitForElementPresent(driver,leadEditLastName, 5);
		Utility_Functions.xSendKeys(driver,leadEditLastName, "Test Automation Subject_" + Utility_Functions.xGenerateAlphaNumericString());
		Utility_Functions.xWaitForElementPresent(driver, leadEditStreet, 2);
		Utility_Functions.xSendKeys(driver, leadEditStreet, dataTable.getData("General_Data", "Street"));
		Utility_Functions.xWaitForElementPresent(driver,leadEditCity, 2);
		Utility_Functions.xSendKeys(driver,leadEditCity, dataTable.getData("General_Data", "City"));
		Utility_Functions.xWaitForElementPresent(driver,leadEditCountry, 2);
		Utility_Functions.xClick(driver,leadEditCountry, true);
		Utility_Functions.xWaitForElementPresent(driver, leadEditCountryValue, 2);
		Utility_Functions.xClick(driver, leadEditCountryValue, true);
		Utility_Functions.xWaitForElementPresent(driver,leadEditState, 2);
		Utility_Functions.xClick(driver,leadEditState, true);
		Utility_Functions.xWaitForElementPresent(driver, leadEditStateValue, 2);
		Utility_Functions.xClick(driver,leadEditStateValue, true);
		Utility_Functions.xWaitForElementPresent(driver,leadEditPostalCode, 2);
		Utility_Functions.xSendKeys(driver,leadEditPostalCode, dataTable.getData("General_Data", "Zipcode"));
		Utility_Functions.xWaitForElementPresent(driver,leadEditDirectLine, 2);
		Utility_Functions.xSendKeys(driver,leadEditDirectLine, dataTable.getData("General_Data", "Direct Line"));
		Utility_Functions.xWaitForElementPresent(driver, leadEditPreferedPropertyType, 3);
		Utility_Functions.xClick(driver, leadEditPreferedPropertyType, true);
		Utility_Functions.xWaitForElementPresent(driver, leadEditPreferedPropertyTypeValue, 2);
		Utility_Functions.xClick(driver, leadEditPreferedPropertyTypeValue, true);
		report.updateTestLog("Verify Lead Convert with New Account", "The Prefered Property type is selected", Status.PASS);
		Utility_Functions.xWaitForElementPresent(driver,save, 3);
		Utility_Functions.xClick(driver,save, true);
		report.updateTestLog("Verify Lead Convert with New Account","The New Lead page is entered with direct Line and Prefered Property type value", Status.PASS);
		Utility_Functions.timeWait(2);
		Utility_Functions.xWaitForElementPresent(driver, convert, 2);
		Utility_Functions.xClick(driver,convert, true);
		Utility_Functions.timeWait(2);
		Utility_Functions.xSwitchtoFrame(driver, convertButton);
		Utility_Functions.timeWait(5);
		convertListValidation();
		Utility_Functions.timeWait(2);
		Utility_Functions.xWaitForElementPresent(driver,convertButton, 3);
		Utility_Functions.xClick(driver,convertButton, true);
		report.updateTestLog("Verify Lead Convert with New Account","The Lead is converted with the required fields", Status.PASS);
		Utility_Functions.timeWait(2);
		driver.switchTo().defaultContent();
		driver.navigate().refresh();
		Utility_Functions.timeWait(2);
		Utility_Functions.xWaitForElementPresent(driver, related, 5);
		Utility_Functions.xClick(driver, related, true);
		report.updateTestLog("Verify Lead Convert with New Account","The related page is Displayed ",  Status.PASS);
		Utility_Functions.timeWait(4);
		Utility_Functions.xScrollWindow(driver);
		Utility_Functions.timeWait(1);
		Utility_Functions.xScrollWindowTop(driver);
		Utility_Functions.timeWait(2);
		Utility_Functions.xWaitForElementPresent(driver, relatedOpportunities, 5);
		Utility_Functions.xClick(driver, relatedOpportunities, true);
		Utility_Functions.xWaitForElementPresent(driver, opportunitiesList, 3);
		Utility_Functions.xclickgetTextofFirstElementfromList(opportunitiesList);
		Utility_Functions.timeWait(4);
		Utility_Functions.xScrollWindow(driver);
		Utility_Functions.timeWait(1);
		Utility_Functions.xScrollWindowTop(driver);
		Utility_Functions.timeWait(2);
		if (!opportunityAccountName.getText().contains(" ")) {
			System.out.println("Opportunity Account Name is populated with the default value");
			report.updateTestLog("Verify Lead Convert with New Account","Verifying the Account name is populated with the default value in the Opportunity Information Page ",  Status.PASS);
		} else {
			System.out.println("Opportunity Account Name is not populated with the default value");
			report.updateTestLog("Verify Lead Convert with New Account","Verifying the Account name is not populated with the default value in the Opportunity Information Page ",  Status.FAIL);
		}

	}

	/**
	 * Validating the convert Lead associated with convert contact
	 * @author Ramya
	 *
	 */
	public void convertLeadWithAssociatedContact() {

		createLeadFunction();
		Utility_Functions.timeWait(2);
		Utility_Functions.xWaitForElementPresent(driver, selectPreferedPropertyType, 2);
		Utility_Functions.xClick(driver, selectPreferedPropertyType, true);
		Utility_Functions.xWaitForElementPresent(driver, selectPreferedPropertyTypeValue, 2);
		Utility_Functions.xClick(driver, selectPreferedPropertyTypeValue, true);
		report.updateTestLog("Verify Lead with Associated Contact", "The Prefered Property type is selected", Status.PASS);
		Utility_Functions.timeWait(2);
		Utility_Functions.xScrollWindow(driver);
		Utility_Functions.timeWait(2);
		Utility_Functions.xScrollWindowTop(driver);
		Utility_Functions.timeWait(2);
		Utility_Functions.xWaitForElementPresent(driver, directLineLead, 2);
		Utility_Functions.xSendKeys(driver, directLineLead, dataTable.getData("General_Data", "Direct Line"));
		report.updateTestLog("Verify Lead with Associated Contact","The Direct Line value is entered", Status.PASS);
		Utility_Functions.timeWait(2);
		Utility_Functions.xWaitForElementPresent(driver, saveButton, 2);
		Utility_Functions.xClick(driver, saveButton, true);
		report.updateTestLog("Verify Lead with Associated Contact","The New Lead page is entered with direct Line and Prefered Property type value", Status.PASS);
		Utility_Functions.timeWait(3);
		Utility_Functions.xWaitForElementPresent(driver,showMoreActions, 3);
		Utility_Functions.xClick(driver,showMoreActions, true);
		Utility_Functions.xWaitForElementPresent(driver, newNote, 2);
		Utility_Functions.xClick(driver,newNote, true);
		report.updateTestLog("Verify Lead with Associated Contact", "The Prefered Property type is selected", Status.PASS);
		Utility_Functions.timeWait(3);
		Utility_Functions.xWaitForElementPresent(driver, newNoteTitle, 2);
		Utility_Functions.xSendKeys(driver,newNoteTitle, "Test Automation Subject_" + Utility_Functions.xGenerateAlphaNumericString());
		Utility_Functions.xWaitForElementPresent(driver,newNoteSave, 2);
		Utility_Functions.xClick(driver,newNoteSave, true);
		report.updateTestLog("Verify Lead with Associated Contact","The New Lead page is entered with direct Line and Prefered Property type value", Status.PASS);
		/*Utility_Functions.timeWait(2);
		Utility_Functions.xWaitForElementPresent(driver, convert, 2);
		Utility_Functions.xClick(driver,convert, true);
		Utility_Functions.timeWait(2);
		Utility_Functions.xSwitchtoFrame(driver, convertButton);
		Utility_Functions.timeWait(5);
		convertListValidation();
		Utility_Functions.timeWait(2);
		Utility_Functions.xScrollWindow(driver);
		Utility_Functions.timeWait(2);
		Utility_Functions.xScrollWindowTop(driver);
		Utility_Functions.timeWait(2);
		Utility_Functions.xWaitForElementPresent(driver,convertLeadStreet, 5);
		Utility_Functions.xSendKeys(driver,convertLeadStreet, dataTable.getData("General_Data", "Street"));
		report.updateTestLog("Verify Lead with Associated Contact","The New Lead page is entered with the street value", Status.PASS);
		Utility_Functions.xWaitForElementPresent(driver,convertLeadCity, 5);
		Utility_Functions.xSendKeys(driver,convertLeadCity, dataTable.getData("General_Data", "City"));
		report.updateTestLog("Verify Lead with Associated Contact","The New Lead page is entered with the city value", Status.PASS);
		Utility_Functions.xWaitForElementPresent(driver,convertLeadCountry, 3);
		Utility_Functions.xClick(driver,convertLeadCountry, true);
		Utility_Functions.xWaitForElementPresent(driver,selectConvertLeadCountry, 3);
		Utility_Functions.xClick(driver,selectConvertLeadCountry, true);
		report.updateTestLog("Verify Lead with Associated Contact","The New Lead page is entered with the Country value", Status.PASS);
		Utility_Functions.xWaitForElementPresent(driver,convertLeadState, 3);
		Utility_Functions.xClick(driver,convertLeadState, true);
		Utility_Functions.xWaitForElementPresent(driver,selectConvertLeadState, 3);
		Utility_Functions.xClick(driver,selectConvertLeadState, true);
		report.updateTestLog("Verify Lead with Associated Contact","The New Lead page is entered with the State value", Status.PASS);
		Utility_Functions.xWaitForElementPresent(driver, zipCodeField, 5);
		Utility_Functions.xSendKeys(driver, zipCodeField, dataTable.getData("General_Data", "Zipcode"));
		report.updateTestLog("Verify Lead with Associated Contact","The New Lead page is entered with the Zipcode", Status.PASS);
		Utility_Functions.xWaitForElementPresent(driver,convertButton, 3);
		Utility_Functions.xClick(driver,convertButton, true);
		report.updateTestLog("Verify Lead with Associated Contact","The Lead is converted with the required fields", Status.PASS);
		Utility_Functions.timeWait(2);
		driver.switchTo().defaultContent();
		driver.navigate().refresh();
		Utility_Functions.timeWait(2);
		Utility_Functions.xWaitForElementPresent(driver, related, 5);
		Utility_Functions.xClick(driver, related, true);
		report.updateTestLog("Verify Lead with Associated Contact","The related page is Displayed ",  Status.PASS);
		Utility_Functions.timeWait(4);
		Utility_Functions.xScrollWindow(driver);
		Utility_Functions.timeWait(1);
		Utility_Functions.xScrollWindowTop(driver);
		Utility_Functions.timeWait(2);
		Utility_Functions.xWaitForElementPresent(driver, relatedOpportunities, 5);
		Utility_Functions.xClick(driver, relatedOpportunities, true);
		Utility_Functions.xWaitForElementPresent(driver, opportunitiesList, 3);
		Utility_Functions.xclickgetTextofFirstElementfromList(opportunitiesList);
		Utility_Functions.timeWait(4);
		Utility_Functions.xScrollWindow(driver);
		Utility_Functions.timeWait(1);
		Utility_Functions.xScrollWindowTop(driver);
		Utility_Functions.timeWait(2);
		if (!opportunityAccountName.getText().contains(" ")) {
			System.out.println("Opportunity Account Name is populated with the default value");
			report.updateTestLog("Verify Lead with Associated Contact","Verifying the Account name is populated with the default value in the Opportunity Information Page ",  Status.PASS);
		} else {
			System.out.println("Opportunity Account Name is not populated with the default value");
			report.updateTestLog("Verify Lead with Associated Contact","Verifying the Account name is not populated with the default value in the Opportunity Information Page ",  Status.FAIL);
		}*/

	}
	/**
	 * Validating the convert Lead with the Prefered Property
	 * @author Ramya
	 *
	 */
	public void leadConvertWithPreferedProperty() {
		createLeadFunction();
		Utility_Functions.timeWait(2);
		Utility_Functions.xWaitForElementPresent(driver, selectPreferedPropertyType, 2);
		Utility_Functions.xClick(driver, selectPreferedPropertyType, true);
		Utility_Functions.xWaitForElementPresent(driver, selectPreferedPropertyTypeValue, 2);
		Utility_Functions.xClick(driver, selectPreferedPropertyTypeValue, true);
		report.updateTestLog("Verify Convert Lead with Prefered Property", "The Prefered Property type is selected", Status.PASS);
		Utility_Functions.timeWait(2);
		Utility_Functions.xWaitForElementPresent(driver, saveButton, 2);
		Utility_Functions.xClick(driver, saveButton, true);
		report.updateTestLog("Verify Convert Lead with Prefered Property","The New Lead page is entered with direct Line and Prefered Property type value", Status.PASS);
		Utility_Functions.timeWait(2);
		Utility_Functions.xWaitForElementPresent(driver, convert, 2);
		Utility_Functions.xClick(driver,convert, true);
		Utility_Functions.timeWait(2);
		Utility_Functions.xSwitchtoFrame(driver, convertButton);
		Utility_Functions.timeWait(5);
		System.out.println("Frame identified");
		Utility_Functions.xScrollWindow(driver);
		Utility_Functions.timeWait(2);
		Utility_Functions.xScrollWindowTop(driver);
		Utility_Functions.timeWait(2);
		Utility_Functions.xWaitForElementPresent(driver,convertLeadStreet, 5);
		Utility_Functions.xSendKeys(driver,convertLeadStreet, dataTable.getData("General_Data", "Street"));
		report.updateTestLog("Verify Convert Lead with Prefered Property","The New Lead page is entered with the street value", Status.PASS);
		Utility_Functions.xWaitForElementPresent(driver,convertLeadCity, 5);
		Utility_Functions.xSendKeys(driver,convertLeadCity, dataTable.getData("General_Data", "City"));
		report.updateTestLog("Verify Convert Lead with Prefered Property","The New Lead page is entered with the city value", Status.PASS);
		Utility_Functions.xWaitForElementPresent(driver,convertLeadCountry, 3);
		Utility_Functions.xClick(driver,convertLeadCountry, true);
		Utility_Functions.xWaitForElementPresent(driver,selectConvertLeadCountry, 3);
		Utility_Functions.xClick(driver,selectConvertLeadCountry, true);
		report.updateTestLog("Verify Convert Lead with Prefered Property","The New Lead page is entered with the Country value", Status.PASS);
		Utility_Functions.xWaitForElementPresent(driver,convertLeadState, 3);
		Utility_Functions.xClick(driver,convertLeadState, true);
		Utility_Functions.xWaitForElementPresent(driver,selectConvertLeadState, 3);
		Utility_Functions.xClick(driver,selectConvertLeadState, true);
		report.updateTestLog("Verify Convert Lead with Prefered Property","The New Lead page is entered with the State value", Status.PASS);
		Utility_Functions.xWaitForElementPresent(driver, zipCodeField, 5);
		Utility_Functions.xSendKeys(driver, zipCodeField, dataTable.getData("General_Data", "Zipcode"));
		report.updateTestLog("Verify Convert Lead with Prefered Property","The New Lead page is entered with the Zipcode", Status.PASS);
		Utility_Functions.xWaitForElementPresent(driver,convertButton, 3);
		Utility_Functions.xClick(driver,convertButton, true);
		report.updateTestLog("Verify Convert Lead with Prefered Property","The Lead is converted with the required fields", Status.PASS);
		Utility_Functions.timeWait(2);
	}
	/**
	 * Validating the Leads Pyeong value
	 * @author Ramya
	 *
	 */
	public void verifyLeadsPyeongValueInUOMPickList(){
		Utility_Functions.xWaitForElementPresent(driver,leads, 3);
		Utility_Functions.xClick(driver, leads, true);
		Utility_Functions.xWaitForElementPresent(driver, newLeads, 2);
		Utility_Functions.xClick(driver, newLeads, true);	
		Utility_Functions.timeWait(2);
		Utility_Functions.xSwitchtoFrame(driver, continueButton);
		Utility_Functions.timeWait(2);
		Utility_Functions.xClick(driver, continueButton, true);
		Utility_Functions.timeWait(2);
		Utility_Functions.xSwitchtoFrame(driver, saveLead);
		Utility_Functions.timeWait(2);
		Utility_Functions.xScrollWindow(driver);
		Utility_Functions.timeWait(2);
		Utility_Functions.xScrollWindowTop(driver);
		Utility_Functions.timeWait(2);
		Utility_Functions.xWaitForElementPresent(driver,unitOfMeasure, 3);
		Utility_Functions.xClick(driver,unitOfMeasure, true);
		report.updateTestLog("Verify Quick Create Lead Page Unit of Measure Pick List  ",
				"Verifying the new Lead page Unit of Measure Pick List is displayed", Status.PASS);
		Utility_Functions.timeWait(1);
		String sPyeong = "Pyeong";
		List<WebElement> unitOfMeasurePickList = driver.findElements(By.xpath("//label[text()='Unit of Measure']/parent::div/parent::div//select[contains(@id,'LeadForm')]/option"));

		for(WebElement element: unitOfMeasurePickList ) {
			element.getText();
			System.out.println(element.getText());
			if(element.getText().equals(sPyeong)) {
				System.out.println("Pyeong pick list value is present in the Unit of Measure pick list values");
				report.updateTestLog("Verify Quick Create Lead Page Unit of Measure Pick List  ",
						"Verifying the new Lead page Unit of Measure pick list values", Status.PASS);

				break;
			}
		}
	}
	/**
	 * Validating the Leads Ping value
	 * @author Ramya
	 *
	 */
	public void verifyLeadsPingValueInUOMPickList(){
		Utility_Functions.xWaitForElementPresent(driver,leads, 3);
		Utility_Functions.xClick(driver, leads, true);
		Utility_Functions.xWaitForElementPresent(driver, newLeads, 2);
		Utility_Functions.xClick(driver, newLeads, true);	
		Utility_Functions.timeWait(2);
		Utility_Functions.xSwitchtoFrame(driver, continueButton);
		Utility_Functions.timeWait(2);
		Utility_Functions.xClick(driver, continueButton, true);
		Utility_Functions.timeWait(2);
		Utility_Functions.xSwitchtoFrame(driver, saveLead);
		Utility_Functions.timeWait(2);
		Utility_Functions.xScrollWindow(driver);
		Utility_Functions.timeWait(2);
		Utility_Functions.xScrollWindowTop(driver);
		Utility_Functions.timeWait(2);
		Utility_Functions.xWaitForElementPresent(driver,unitOfMeasure, 3);
		Utility_Functions.xClick(driver,unitOfMeasure, true);
		report.updateTestLog("Verify Quick Create Lead Page Unit of Measure Pick List  ",
				"Verifying the new Lead page Unit of Measure Pick List is displayed", Status.PASS);
		Utility_Functions.timeWait(1);
		String sPing = "Ping";
		List<WebElement> unitOfMeasurePickList = driver.findElements(By.xpath("//label[text()='Unit of Measure']/parent::div/parent::div//select[contains(@id,'LeadForm')]/option"));

		for(WebElement element: unitOfMeasurePickList ) {
			element.getText();
			System.out.println(element.getText());
			if(element.getText().equals(sPing)) {
				System.out.println("Ping pick list value is present in the Unit of Measure pick list values");
				report.updateTestLog("Verify Quick Create Lead Page Unit of Measure Pick List ", "Verifying the new Lead page Unit of Measure pick list values", Status.PASS);
				break;
			}
		}
	}
	/**
	 * Validating the creation of Activity on Leads
	 * 
	 * @author Ramya
	 *
	 */
	public void verifyLeadActivityCreation() {

		Utility_Functions.xWaitForElementPresent(driver, leads, 3);
		Utility_Functions.xClick(driver,leads, true);
		report.updateTestLog("Verify Contact Activity Timeline ", "Contacts is Displayed ", Status.PASS);
		Utility_Functions.xWaitForElementPresent(driver, recentlyViewed, 3);
		Utility_Functions.xClick(driver, recentlyViewed, true);
		report.updateTestLog("Verify Contact Activity Timeline ", "Recently viewed Contacts are Displayed ",
				Status.PASS);
		Utility_Functions.xWaitForElementPresent(driver, allLeadsMenu, 3);
		Utility_Functions.xClick(driver, allLeadsMenu, true);
		Utility_Functions.timeWait(3);
		report.updateTestLog("Verify Contact Activity Timeline", "All Contacts are Displayed ", Status.PASS);
		List<WebElement> contactNamesList = driver.findElements(
				By.xpath(".//a[@class='slds-truncate outputLookupLink slds-truncate forceOutputLookup']"));

		Utility_Functions.xclickOnFirstElementfromList(contactNamesList);
		Utility_Functions.timeWait(3);
		report.updateTestLog("Verify Contact Activity Timeline ", "The Contact is Displayed ", Status.PASS);
		Utility_Functions.xWaitForElementPresent(driver, related, 3);
		Utility_Functions.xClick(driver, related, true);
		report.updateTestLog("Verify Contact Activity Timeline ", "The related page is Displayed ", Status.PASS);
		Utility_Functions.xScrollWindow(driver);
		Utility_Functions.timeWait(1);
		Utility_Functions.xScrollWindowTop(driver);
		Utility_Functions.timeWait(2);
		try {
			Utility_Functions.xWaitForElementPresent(driver, newActivity, 3);
			Utility_Functions.xClick(driver, newActivity, true);
		} catch (Exception e1) {
			Utility_Functions.xWaitForElementPresent(driver, newActivityHeader, 3);
			Utility_Functions.xClick(driver, newActivityHeader, true);
		}
		report.updateTestLog("Verify Contact Activity Timeline", "The New Activity in the related page is Displayed ",
				Status.PASS);
		Utility_Functions.timeWait(1);
		Utility_Functions.xSwitchtoFrame(driver, saveAndNewActivity);
		Utility_Functions.timeWait(4);
		Utility_Functions.xWaitForElementPresent(driver, subject, 5);
		Utility_Functions.xSendKeys(driver, subject,
				"Test Automation Subject_" + Utility_Functions.xGenerateAlphaNumericString());
		Utility_Functions.xWaitForElementPresent(driver, activityTypeFollowUpTaskValue, 3);
		Utility_Functions.xClick(driver, activityTypeFollowUpTaskValue, true);
		Calendar calendar = Calendar.getInstance();
		calendar.add(Calendar.DAY_OF_MONTH, -20);
		SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy hh:mm a");
		System.out.println("Date : " + dateFormat.format(calendar.getTime()));
		Utility_Functions.xWaitForElementPresent(driver, newActivityDueDate, 3);
		Utility_Functions.xSendKeys(driver, newActivityDueDate, dateFormat.format(calendar.getTime()));
		Utility_Functions.xWaitForElementPresent(driver, saveActivity, 5);
		Utility_Functions.xClick(driver, saveActivity, true);
		Utility_Functions.timeWait(4);
		driver.navigate().refresh();
		Utility_Functions.timeWait(4);
		Utility_Functions.xWaitForElementPresent(driver, related, 5);
		report.updateTestLog("Verify Contact Activity Timeline ", "The Account is Displayed ", Status.PASS);
		Utility_Functions.xClick(driver, related, true);
		Utility_Functions.timeWait(2);
		report.updateTestLog("Verify Contact Activity Timeline", "The related page is Displayed ", Status.PASS);
		Utility_Functions.xScrollWindow(driver);
		Utility_Functions.timeWait(1);
		Utility_Functions.xScrollWindowTop(driver);
		Utility_Functions.timeWait(2);
		try {
			Utility_Functions.xWaitForElementPresent(driver, newActivity, 3);
			Utility_Functions.xClick(driver, newActivity, true);
		} catch (Exception e1) {
			Utility_Functions.xWaitForElementPresent(driver, newActivityHeader, 3);
			Utility_Functions.xClick(driver, newActivityHeader, true);
		}
		report.updateTestLog("Verify Contact Activity Timeline", "The New Activity in the related page is Displayed ",
				Status.PASS);
		Utility_Functions.xSwitchtoFrame(driver, saveAndNewActivity);
		Utility_Functions.timeWait(3);
		Utility_Functions.xWaitForElementPresent(driver, subject, 5);
		Utility_Functions.xSendKeys(driver, subject,
				"Test Automation Subject_" + Utility_Functions.xGenerateAlphaNumericString());
		Utility_Functions.xWaitForElementPresent(driver, activityTypeFollowUpTaskValue, 3);
		Utility_Functions.xClick(driver, activityTypeFollowUpTaskValue, true);
		Calendar calendar1 = Calendar.getInstance();
		calendar1.add(Calendar.DAY_OF_MONTH, 10);
		SimpleDateFormat dateFormat1 = new SimpleDateFormat("MM/dd/yyyy hh:mm a");
		System.out.println("Date : " + dateFormat1.format(calendar1.getTime()));
		Utility_Functions.xWaitForElementPresent(driver, newActivityDueDate, 3);
		Utility_Functions.xSendKeys(driver, newActivityDueDate, dateFormat1.format(calendar1.getTime()));
		Utility_Functions.xWaitForElementPresent(driver, saveActivity, 5);
		Utility_Functions.xClick(driver, saveActivity, true);
		Utility_Functions.timeWait(4);
		driver.navigate().refresh();
		Utility_Functions.timeWait(4);
		Utility_Functions.xWaitForElementPresent(driver, activityTab, 5);
		Utility_Functions.xClick(driver, activityTab, true);
		int count = 0;
		try {
			if (activityTimeline.isDisplayed()) {
				System.out.println(
						"There are no activities for present, past and future dates in acitivity related list");
				report.updateTestLog("Verify Accounts Activity Timeline",
						"There are no activities for present, past and future dates in acitivity related list:::",
						Status.PASS);
				count++;
			}
		} catch (Exception e) {
			if (activity.isDisplayed()) {
				System.out.println("Activity is present acitivity related list");
				report.updateTestLog("Verify Contact Activity Timeline",
						"Acitivity is present in acitivity related list:::", Status.PASS);
				if (activityType.getText().contains("Activity Type")) {
					System.out.println("Activity Type is present acitivity related list");
					report.updateTestLog("Verify Activity Related List",
							"Acitivity Type is present in acitivity related list:::", Status.PASS);
					count++;
				}
				if (statusActivityTimeLine.getText().contains("Status")) {
					System.out.println("Status is present acitivity related list");
					report.updateTestLog("Verify Contact Activity Timeline",
							"Status is present in acitivity related list:::", Status.PASS);
					count++;
				}
				if (comments.getText().contains("Comments")) {
					System.out.println("Comments sections is present acitivity related list");
					report.updateTestLog("Verify Contact Activity Timeline",
							"Comments section is present in acitivity related list:::", Status.PASS);
					count++;
				}
				if (dueDate.isDisplayed()) {
					System.out.println("Duedate is present acitivity related list");
					report.updateTestLog("Verify Contact Activity Timeline",
							"Duedate is present in acitivity related list:::", Status.PASS);
					count++;
				}
				if (statusCheckbox.isDisplayed()) {
					System.out.println("Status Checkbox is present acitivity related list");
					report.updateTestLog("Verify Contact Activity Timeline",
							"Status Checkbox is present in acitivity related list:::", Status.PASS);
				}
			}
			if (count == 4) {
				System.out.println(
						"Activity Type, Due Date, Comments and Status Checkbox are present under acitivity related list");
				report.updateTestLog("Verify Contact Activity Timeline",
						"Activity Type, Due Date, Comments and Status Checkbox are present under activity related list:::",
						Status.PASS);
			} else if (count == 1) {
				System.out.println(
						"There are no activities for present, past and future dates in acitivity related list");
			} else {
				System.out.println(
						"Activity Type, Due Date, Comments and Status Checkbox are not present under acitivity related list");
				report.updateTestLog("Verify Contact Activity Timeline",
						"Activity Type, Due Date, Comments and Status Checkbox are not present under activity related list:::",
						Status.FAIL);
			}
		}
		try {
			Utility_Functions.xWaitForElementPresent(driver, pastActivity, 5);
			Utility_Functions.xClick(driver, pastActivity, true);
			report.updateTestLog("Verify Contact Activity Timeline", "The Past Activities is Clicked successfully",
					Status.PASS);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		Utility_Functions.xWaitForElementPresent(driver, moreActivities, 5);
		Utility_Functions.xClick(driver, moreActivities, true);
		report.updateTestLog("Verify Contact Activity Timeline", "The More Activities is Clicked successfully",
				Status.PASS);
	}
	/**
	 * Validating the Leads Private Tags
	 * 
	 * @author Ramya
	 *
	 */
	public void verifyLeadsPrivateTags(){
		Utility_Functions.xWaitForElementPresent(driver, leads, 3);
		Utility_Functions.xClick(driver, leads, true);
		Utility_Functions.xWaitForElementPresent(driver, leadsList, 3);
		Utility_Functions.xclickgetTextofFirstElementfromList(leadsList);
		Utility_Functions.timeWait(3);
		Utility_Functions.xScrollWindow(driver);
		Utility_Functions.timeWait(1);
		Utility_Functions.xScrollWindowTop(driver);
		Utility_Functions.timeWait(2);
		Utility_Functions.xSwitchtoFrame(driver,addTag);
		Utility_Functions.xWaitForElementPresent(driver,addTag, 3);
		Utility_Functions.xClick(driver,addTag, true);
		Utility_Functions.xWaitForElementPresent(driver,privatetag, 3);
		Utility_Functions.xSendKeys(driver,privatetag, "Test Automation");	
		Utility_Functions.xWaitForElementPresent(driver,savePrivateTag, 3);
		Utility_Functions.xClick(driver,savePrivateTag, true);
		Utility_Functions.timeWait(5);
		if(privateTagCreated.isDisplayed()){
			report.updateTestLog("Verify Lead Private Tags", "The Private Tag is saved",
					Status.PASS);		
		}else{
			report.updateTestLog("Verify Lead Private Tags", "The Private tag is not saved",
					Status.FAIL);
			
		}
		
	}
	
        public void leadTagging () {
		
		Utility_Functions.xClick(driver, leads, true);
		Utility_Functions.xWaitForElementVisible(driver, recentlyViewed, 3);
		Utility_Functions.xClick(driver, recentlyViewed, true);
		Utility_Functions.xWaitForElementVisible(driver, allLeadsMenu, 3);
		Utility_Functions.xClick(driver, allLeadsMenu, true);
		Utility_Functions.timeWait(6);
		Utility_Functions.xclickRandomElement(leadsList);	
		Utility_Functions.timeWait(4);
		Utility_Functions.xSwitchtoFrame(driver, addTag);
		Utility_Functions.xWaitForElementPresent(driver, addTag, 8);
		Utility_Functions.xClickHiddenElement(driver, addTag);
		Utility_Functions.xWaitForElementVisible(driver, privatetag, 3);
		Utility_Functions.xSendKeys(driver, privatetag, "ABCDZXED");
		Utility_Functions.xClickHiddenElement(driver, savePrivateTag);
		 Utility_Functions.xWaitForElementPresent(driver,addTag, 3);
		 if(addTag.isDisplayed()){
				report.updateTestLog("Verify Lead Private Tags", "The Private Tag is saved",
						Status.PASS);		
			}else{
				report.updateTestLog("Verify Lead Private Tags", "The Private tag is not saved",
						Status.FAIL);
			}
}
	
	    public void verifyLeadTagging () {
	         
	         report.updateTestLog("Verify Lead Private Tags", "The Private tag is saved in Private Tag Page",
	 				Status.PASS);
		      
	}
	    
	    public void addMassMember () {
	    	
	    	Utility_Functions.xClick(driver, leads, true);
	    	Utility_Functions.xWaitForElementVisible(driver, recentlyViewed, 5);
			Utility_Functions.xClick(driver, recentlyViewed, true);
			Utility_Functions.xWaitForElementVisible(driver, allLeadsMenu, 5);
			Utility_Functions.xClick(driver, allLeadsMenu, true);
			Utility_Functions.timeWait(4);
			Utility_Functions.xclickRandomElement(leadsList);
			Utility_Functions.xWaitForElementVisible(driver, ReportsTab, 5);
			Utility_Functions.xClick(driver, ReportsTab, true);
			Utility_Functions.xWaitForElementVisible(driver, AllFolder, 5);
			Utility_Functions.xClick(driver, AllFolder, true);
			Utility_Functions.xWaitForElementVisible(driver, AllCampaignMemberbtn, 5);
			Utility_Functions.xClick(driver, AllCampaignMemberbtn, true);
			Utility_Functions.xWaitForElementVisible(driver, ContactsPrivateTag, 5);
			Utility_Functions.xClick(driver, ContactsPrivateTag, true);
			Utility_Functions.xWaitForElementVisible(driver, showMoreActionsReport, 5);
			Utility_Functions.xClick(driver, showMoreActionsReport, true);
			Utility_Functions.xWaitForElementVisible(driver, clone, 5);
			Utility_Functions.xClick(driver, clone, true);
			
			
	    }
	    	
}

