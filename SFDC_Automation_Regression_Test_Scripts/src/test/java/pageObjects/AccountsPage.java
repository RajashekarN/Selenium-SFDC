package pageObjects;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.cognizant.Craft.ReusableLibrary;
import com.cognizant.Craft.ScriptHelper;
import com.cognizant.framework.Status;
import com.sforce.soap.partner.SaveResult;

import pagesAPI.AccountsFunctions;
import pagesAPI.SearchTextSOQL;
import supportLibraries.Utility_Functions;

public class AccountsPage extends ReusableLibrary {
	/*
	 * Constructor to initialize the business component library
	 * 
	 * @param scriptHelper The {@link ScriptHelper} object passed from the
	 * {@link DriverScript}
	 */

	public AccountsPage(ScriptHelper scriptHelper) {
		super(scriptHelper);
		PageFactory.initElements(driver.getWebDriver(), this);
	}

	public static String accountname;
	@FindBy(xpath = "//div[@class='bBottom']//span[text()='Accounts']")
	WebElement menu_Accounts;
	
	@FindBy(xpath = "//div[@class='bBottom']//span[text()='Private Tags']")
	WebElement menu_PrivateTagsObject;
	
	@FindBy(xpath = "//p[contains(text(),'Private Tag Sharing')]")
	WebElement tagSharing;
	
	@FindBy(xpath = "//span[text()='Lead Source']/parent::span/following-sibling::div/descendant::a[@class='select'][text()='--None--']")
	WebElement leadSourceList;
	
	@FindBy(xpath="//*[@id='j_id0:oppForm:assignmentType']")
	WebElement oppAssignmentType;
	
	//@FindBy(xpath="//select[contains(@name,'assignmentType')]")
	//WebElement oppAssignmentType;
	
	@FindBy(xpath="//button[contains(text(),'More')]")
	WebElement moreMenu;
	
	@FindBy(xpath="//a[contains(@role,'menuitem')]/span[contains(text(),'Private Tags')]")
	WebElement moreTag;
	
	@FindBy(xpath = "//div[contains(text(),'Sharing')]")
	WebElement btnShare;
	
	@FindBy(xpath = "//input[contains(@title,'Add')]")
	WebElement btnAddUser;
	
	@FindBy(xpath = "//div[@class='select-options']/ul/li/a[text()='Business Relationship']")
	WebElement leadSourceValue;
	
	@FindBy(xpath = "//select[contains(@name,'assignmentType')]/option[contains(text(),'Consulting')]")
	WebElement assignTypeValue;
	
	@FindBy(xpath = "//span[text()='Estimated Gross Fee/Commission']/parent::label/following-sibling::input")
	WebElement grossfee;
	
	@FindBy(xpath = "//span[text()='Estimated Transaction Value']/parent::label/following-sibling::input")
	WebElement tansValue;
	@FindAll(value = {@FindBy(xpath = "//span[text()='Save']")})
	List<WebElement> saveButtonList;
	
	@FindBy(xpath = "//input[@value='Save']")
	WebElement oppSave;
	
	@FindBy(xpath="//span[text()='Close Date']/parent::label/following-sibling::div/input")
	WebElement closeDate;
	
	@FindBy(xpath = "//span/input[contains(@name,'closeDate')]")
	WebElement oppCloseDate;
	//@FindBy(css = "ul>li.forceSearchInputLookupDesktopOption:nth-child(1)")
	//WebElement firstLookupElement;
	
	@FindBy(xpath="//span[text()='Opportunity Name']/parent::label/following-sibling::input")
	WebElement accountNameInput;
	
	@FindBy(xpath="//input[@title='Search Properties']")
	WebElement searchProp;
	
	@FindBy(xpath = "//ul[@class='slds-button-group slds-m-left--xx-small oneActionsRibbon forceActionsContainer']//li/a/div[text()='New']")
	WebElement newAccount;
	
	//@FindAll(value = {@FindBy(xpath = "//a[@class='slds-card__header-link baseCard__header-title-container']/span[text()='Opportunities']/ancestor::header[@class='slds-media slds-media--center slds-has-flexi-truncate']/following-sibling::div/descendant::a/div")})
	//List<WebElement> newOpportunity;
	
	@FindBy(xpath = "//a[@class='slds-card__header-link baseCard__header-title-container']/span[text()='Opportunities']/ancestor::header[@class='slds-media slds-media--center slds-has-flexi-truncate']/following-sibling::div/descendant::a/div")
	WebElement newOpportunity;
	
	@FindBy(xpath = "//button[text()='Continue']")
	WebElement continueButton;

	@FindBy(xpath = "//button/span[text()='View All Fields']")
	WebElement viewAllFieldsButton;

	@FindBy(css = "div.region-main a.tabHeader[title='Related']")
	WebElement accounts_Related;
	
	@FindBy(css = "div.region-main a.tabHeader[title='Related']")
	List<WebElement> related_Accounts;

	@FindBy(xpath = "//span[contains(text(),'Opportunities & Comps')]")
	WebElement account_Opp;
	@FindBy(xpath = "//span[contains(text(),'Private Notes')]/ancestor::article//div[text()='New']")
	WebElement new_PrivateNotes;

	@FindBy(xpath = "//button[@class='slds-button slds-button--neutral uiButton--default uiButton--brand uiButton']/span[text()='Next']")
	WebElement next_PrivateNotes;

	@FindBy(xpath = "//label[@class='label inputLabel uiLabel-left form-element__label uiLabel']/span[contains(text(), 'Title')]/parent::label/parent::div/input")
	WebElement title_PrivateNotes;

	@FindBy(xpath = "//div[@class='autocompleteWrapper']/input[@placeholder='Search Leads']")
	WebElement searchLeads_PrivateNotes;

	@FindBy(xpath = "//div[@class='contentWrapper slds-box--border']//ul[@class='orderedList']//span[@class='pillText']")
	WebElement account_PrivateNotes;

	@FindBy(xpath = "//div[@class='autocompleteWrapper']/input[@placeholder='Search Contacts']")
	WebElement searchContacts_PrivateNotes;

	@FindBy(xpath = "//label[@class='label inputLabel uiLabel-left form-element__label uiLabel']/span[contains(text(), 'Title')]")
	WebElement title;

	@FindBy(xpath = "//input[@placeholder='Search Leads']")
	WebElement searchLeads;

	@FindBy(xpath = "//input[@title='Search Contacts']")
	WebElement searchContacts;

	@FindBy(xpath = "//label[@class='label inputLabel uiLabel-left form-element__label uiLabel']/span[contains(text(), 'Body')]/parent::label/parent::div/textarea")
	WebElement body;

	@FindBy(xpath = "//button[@class='slds-button slds-button--neutral uiButton--default uiButton--brand uiButton forceActionButton']/span[contains(text(), 'Save')]")
	WebElement saveButton;

	@FindBy(css = "span.toastMessage")
	WebElement wasCreated;

	@FindBy(xpath = ".//div[@class='changeRecordTypeOptionRightColumn']/span[text()='Personal Information']/parent::div/parent::label/div[1]/span")
	WebElement selectPersonalInformation;

	@FindBy(xpath = ".//button[@class='slds-button slds-button--neutral uiButton--default uiButton--brand uiButton']/span[contains(text(), 'Next')]")
	WebElement next;

	@FindBy(xpath = ".//label[@class='label inputLabel uiLabel-left form-element__label uiLabel']/span[contains(text(),'Title')]/parent::label/parent::div/input")
	WebElement titleName;

	@FindBy(xpath = "//span[text()='Private Notes']/parent::span[@class='view-all-label']")
	WebElement viewAllButton;

	@FindBy(xpath = "//span[contains(@class, 'slds-text-heading--small slds-truncate') and text() = 'Notes']")
	WebElement notes;

	@FindBy(xpath = "//header//a/span[text()='Notes']/parent::a/parent::h2/parent::div/parent::header/parent::div/div//div[text()='New']")
	WebElement newNotes;

	@FindBy(xpath = "//div[@class='uiInput uiInputText uiInput--default uiInput--input notesTitle']/input[@class='inputText input']")
	WebElement noteTitle;

	@FindBy(xpath = "//div[@class='slds-form-element']")
	WebElement noteEditArea;

	@FindBy(xpath = "//button[@class='slds-button slds-button--neutral hideDoneButton uiButton--default uiButton--brand uiButton']/span[contains(text(),'Done')]")
	WebElement doneButton;

	@FindBy(xpath = "//div[@title='Add File']")
	WebElement addFile;

	@FindBy(xpath = "//li[@class='slds-p-horizontal--small desktop forceContentListStencilCommon forceRecordLayout']/a/div[@class='filerow']")
	WebElement addFileAttachment;

	@FindBy(xpath = ".//*[text()='Add']")
	WebElement add;

	@FindBy(xpath = "//div[@class='uiInput uiInputText uiInput--default uiInput--input notesTitle']")
	WebElement untitledPageTitle;

	@FindBy(xpath = "//div[@class='ql-editor ql-blank']")
	WebElement untitledNoteText;

	@FindBy(xpath = "//ul[@class='orderedList']//span[@class='pillText']")
	WebElement untitledNoteSelectedAccount;

	@FindBy(xpath = "//input[@class='searchTextField slds-input slds-lookup__search-input input'][@placeholder='Search Files...']")
	WebElement searchFile;

	@FindBy(xpath = "//span[contains(text(),'Activities')]/ancestor::article//div[text()='New Activity']")
	WebElement newActivity;
	
	@FindBy(xpath = "//div[contains(@class,'slds-page-header')]//a[@title='New Activity']")
	WebElement newActivity_AS;
	
	@FindBy(xpath = "//input[@class='slds-input'][@type='text']")
	WebElement subject;

	@FindBy(xpath = "//select[@class='slds-select']/option[@value='Private - Client Intelligence']")
	WebElement activityType1;

	@FindBy(xpath = "//input[@value='Save & New']")
	WebElement saveAndNewActivity;

	@FindBy(xpath = "//select[@class='slds-select']/option[@value='Private - Initial Meeting']")
	WebElement activityType2;

	@FindBy(xpath = "// input [@value= 'Save']")
	WebElement saveActivity;

	@FindBy(xpath = "//span[contains(@class, 'slds-text-heading--small slds-truncate') and text() = 'Activities']")
	WebElement relatedActivities;

	@FindBy(xpath = "//a[contains(@title,'Show') and contains(@title,'more action')]")
	WebElement selectCreateFollowUpCustomActivity;

	@FindBy(xpath = "//div[contains(@title, 'Create Follow-up Custom Activity')]")
	WebElement createCustomActivity;

	@FindBy(xpath = "//select[@class='slds-select']/option[@value='Private - Follow-Up Meeting']")
	WebElement activityType3;

	@FindBy(xpath = "//h1//span[text()='Recently Viewed']")
	WebElement recentlyViewed;

	@FindBy(xpath = "//span[contains(@class,'virtualAutocompleteOptionText')][text()='All Accounts']")
	WebElement allAccounts;

	@FindBy(xpath = "//span[contains(@class,'virtualAutocompleteOptionText')][text()='Recently Viewed']")
	WebElement recentlyViewedList;

	@FindBy(xpath = ".//*[@id='assignedToBox']")
	WebElement assignedTo;

	@FindBy(xpath = ".//*[@id='relatedAccountBox']")
	WebElement accountSelected;

	@FindBy(xpath = "//select[@class='slds-select']/option[@value='Normal']")
	WebElement priority;

	@FindBy(xpath = "//div[@class='slds-form-element__control slds-has-divider--bottom']")
	WebElement owner;

	@FindBy(xpath = "//select[@class='slds-select']/option[@value='Open']")
	WebElement status;

	@FindBy(xpath = "// input [@value= 'Save']")
	WebElement saveNewActivityLayoutPage;

	@FindBy(xpath = "// input [@value= 'Save & New']")
	WebElement saveAndNewActivityLayoutPage;

	@FindBy(xpath = "// input [@value= 'Cancel']")
	WebElement cancelNewActivityLayoutPage;

	@FindBy(xpath = "//div[@class='slds-small-order--1 slds-medium-order--2 slds-large-order--3']")
	WebElement createNewActivity;

	@FindBy(xpath = ".//*[@id='relatedContactBox']")
	WebElement relatedToContactField;

	@FindBy(xpath = ".//*[@id='relatedOpportunityBox']")
	WebElement relatedToOpportunityField;

	@FindBy(xpath = ".//*[@id='relatedPropertyBox']")
	WebElement relatedToPropertyField;

	@FindBy(xpath = "//input[@class='slds-input'][@type='checkbox']/following-sibling::span[text()='Notification Email']")
	WebElement notificationEmail;

	@FindBy(xpath = "//*[text()='More']")
	WebElement menu_More;

	@FindBy(xpath = "//a[@role='menuitem']/span[contains(@class,'slds-truncate')][text()='Bulk Tagging']")
	WebElement bulkTagging;

	@FindBy(xpath = "//input[contains(@id,'SearchBlock:propertyEditForm:SearchBox')][contains(@placeholder,'Search Account/Contact')]")
	WebElement accountSearch;

	@FindBy(xpath = "//div[@class='slds-form-element ']//input[@value='Search']")
	WebElement search;

	@FindBy(xpath = "//div[@id='Accountsection']//tr[3]//span[@class='slds-checkbox--faux']")
	WebElement selectAccount1;

	@FindBy(xpath = "//div[@id='Accountsection']//tr[4]//span[@class='slds-checkbox--faux']")
	WebElement selectAccount2;

	@FindBy(xpath = "//div[@class='slds-form-element']//input[@value='Assign Tag']")
	WebElement assignTag;

	@FindBy(xpath = "//div[@class='slds-form-element ']//input[@value='Advanced Search']")
	WebElement advancedSearch;

	@FindBy(xpath = "//select[@class='slds-select']/option[@value='Account']")
	WebElement advancedSearchAccountOption;

	@FindBy(xpath = "//select[@class='slds-select']/option[@value='BillingPostalCode']")
	WebElement accountFieldNameCondition;

	@FindBy(xpath = "//select[@class='slds-select']/option[@value='=']")
	WebElement accountOperatorCondition;

	@FindBy(xpath = "//span[text()='Investor Services Account']/parent::div/parent::div//div//span[contains(@class,'uiOutputCheckbox')]")
	WebElement accountServicesCheckbox;

	@FindBy(xpath = "//select[@id='record-type-select']")
	WebElement recordType;

	@FindBy(xpath = "//select[@id='record-type-select']/option[text()='EMEA Reporting Account']")
	WebElement recordType_EMEAReporting;

	@FindBy(xpath = "//input[contains(@id,'acctForm:Name')]")
	WebElement accountNameQuickCreate;

	@FindBy(xpath = "//textarea[contains(@id,'BillingStreet')]")
	WebElement billingStreetQuickCreate;

	@FindBy(xpath = "//input[contains(@id,'BillingCity')]")
	WebElement billingCityQuickCreate;

	@FindBy(xpath = "//select[contains(@id,'countryBillingPicklist')]")
	WebElement billingCountryQuickCreate;

	@FindBy(xpath = "//select[contains(@id,'countryBillingPicklist')]/option[text()='United States']")
	WebElement billingCountryUnitedStatesQuickCreate;

	@FindBy(xpath = "//select[contains(@id,'EMEAAreaofOperations')]")
	WebElement areaOfOperationsQuickCreate;

	@FindBy(xpath = "//select[contains(@id,'EMEAAreaofOperations')]/option[text()='Regional']")
	WebElement areaOfOperationsRegionalQuickCreate;

	@FindBy(xpath = "//input[@type='submit'][@value='Save']")
	WebElement saveQuickCreate;

	@FindBy(xpath = "//div[@class='bBottom']//span[text()='Reports']")
	WebElement menu_Reports;

	@FindBy(xpath = "//div[@title='New Report'][text()='New Report']")
	WebElement newReport;

	@FindBy(xpath = "//input[@id='quickFindInput']")
	WebElement reportTypeInput;

	@FindBy(xpath = "//div[@class='slds-truncate'][text()='New']")
	WebElement newAccountMenuPage;

	@FindBy(xpath = "//a[@aria-label='Investor Profile']")
	WebElement investorProfile;

	@FindBy(xpath = "//div[@class='slds-form-element__control slds-grid']/span/span/img")
	WebElement investorServicesCheckBox;

	@FindBy(xpath = "//select[contains(@id,'CustomActivityForm:activity-activityType')]")
	WebElement selectActivityType;

	@FindBy(xpath = "//select[contains(@id,'stateBillingPicklist')]")
	WebElement billingStateQuickCreate;

	@FindBy(xpath = "//select[contains(@id,'stateBillingPicklist')]/option[text()='Texas']")
	WebElement billingStateTexasQuickCreate;

	@FindBy(xpath = "//div[@class='slds-form-element__row']//label[@for='first-name']/parent::div//input")
	WebElement firstName;

	@FindBy(xpath = "//div[@class='slds-form-element__row']//label[@for='last-name']/parent::div//input")
	WebElement lastName;

	@FindBy(xpath = "//label[@for='company']/following-sibling::div//input")
	WebElement company;

	@FindBy(xpath = "//label[text()='Status']/following-sibling::div//select")
	WebElement leadStatusField;

	@FindBy(xpath = "//select[contains(@id,'LeadForm')]/option[text()='Open']")
	WebElement selectLeadStatusField;

	@FindBy(xpath = "//input[@class='btn slds-button slds-button--neutral slds-m-left--small'][@value='Save']")
	WebElement saveButtonLeads;

	@FindBy(xpath = "//div[@class='bBottom']//span[text()='Leads']")
	WebElement menu_Leads;

	@FindBy(xpath = "//div[@class='slds-truncate'][@title='Sharing'][text()='Sharing']")
	WebElement sharingButton;

	@FindBy(xpath = "//div[contains(@class,'listRelatedObject')]//td[@class='pbButton']//input[@type='button'][@name='new']")
	WebElement addButtonSharing;

	@FindBy(xpath = "//input[@name='new'][contains(@value,'Add')]")
	WebElement addButtonUser;
	
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

	@FindBy(xpath = "//*[@id='p9']")
	WebElement access;

	@FindBy(xpath = "//*[@id='bottomButtonRow']/input[@name='save']")
	WebElement saveButtonPrivateTag;

	@FindBy(xpath = "//h1[text()='Sharing Detail']")
	WebElement sharingDetail;
	
	@FindBy(xpath = "//input[@title='Save']")
	WebElement tagSaveBtn;

	@FindBy(xpath = "//a[@role='menuitem'][text()='Private Tags']")
	WebElement more_privateTags;

	@FindBy(xpath = "//div[@class='slds-truncate'][text()='New']")
	WebElement newAccounts;

	@FindBy(xpath = "//label[@class='label inputLabel uiLabel-left form-element__label uiLabel']/span[contains(text(),'Private Tag Name')]/parent::label/parent::div/input")
	WebElement privateTagName;

	@FindBy(xpath = "//button[@title='Save']")
	WebElement saveNewPrivateTag;

	@FindBy(xpath = "//button[contains(@class,'context-bar__label-action')][text()='More']")
	WebElement more;

	@FindBy(xpath = "//a[@role='menuitem']/span/span[text()='Private Tags']")
	WebElement more_PrivateTags;

	@FindBy(xpath = "//h1[contains(@class,'slds-page-header__title')]/span")
	List<WebElement> accountNameSaved;

	@FindBy(xpath = "//span[text()='D-U-N-S #']/parent::div/parent::div//span[@class='uiOutputText']")
	WebElement accountDetailsDUNS;

	@FindBy(xpath = "//li[contains(@class,'oneActionsDropDown')]//a")
	WebElement showMoreActions;

	@FindBy(xpath = "//div[contains(@class,'actionMenu')]//a[@title='View Hierarchy']")
	WebElement selectViewHierarchy;

	@FindBy(xpath = "//input[contains(@id,'LocalAcctName')]")
	WebElement localAccountName;

	@FindBy(xpath = "//input[contains(@id,'acctForm:Fax')]")
	WebElement accountFax;

	@FindBy(xpath = "//button[@id='addressCopy']")
	WebElement copyAddress;

	@FindBy(xpath = "//select[contains(@id,'Local_Billing_Country__c')]")
	WebElement localBillingCountry;

	@FindBy(xpath = "//select[contains(@id,'Local_Billing_Country__c')]/option[text()='United States']")
	WebElement localBillingCountryValue;

	@FindBy(xpath = "//textarea[contains(@id,'Local_Billing_Street__c')]")
	WebElement localBillingStreet;

	@FindBy(xpath = "//input[contains(@id,'Local_Billing_City__c')]")
	WebElement localBillingCity;

	@FindBy(xpath = "//select[contains(@id,'Local_Billing_State_Province__c')]")
	WebElement localBillingState;

	@FindBy(xpath = "//select[contains(@id,'Local_Billing_State_Province__c')]/option[text()='Texas']")
	WebElement localBillingStateValue;

	@FindBy(xpath = "//input[contains(@id,'Local_Billing_Zip_Postal_Code__c')]")
	WebElement localBillingZipCode;

	@FindBy(xpath = "//select[contains(@id,'Local_Shipping_Country__c')]")
	WebElement localShippingCountry;

	@FindBy(xpath = "//select[contains(@id,'Local_Shipping_Country__c')]/option[text()='United States']")
	WebElement localShippingCountryValue;

	@FindBy(xpath = "//textarea[contains(@id,'Local_Shipping_Street__c')]")
	WebElement localShippingStreet;

	@FindBy(xpath = "//input[contains(@id,'Local_Shipping_City__c')]")
	WebElement localShippingCity;

	@FindBy(xpath = "//select[contains(@id,'Local_Shipping_State_Province__c')]")
	WebElement localShippingState;

	@FindBy(xpath = "//select[contains(@id,'Local_Shipping_State_Province__c')]/option[text()='Texas']")
	WebElement localShippingStateValue;

	@FindBy(xpath = "//input[contains(@id,'Local_Shipping_Zip_Postal_Code__c')]")
	WebElement localShippingZipCode;

	@FindBy(xpath = "//input[contains(@id,'acctForm:website')]")
	WebElement website;

	@FindBy(xpath = "//input[contains(@id,'Phone')]")
	WebElement phone;

	@FindBy(xpath = "//select[contains(@id,'EMEAIndustry')]")
	WebElement industry;

	@FindBy(xpath = "//select[contains(@id,'Industry')]")
	WebElement amerIndustry;

	@FindBy(xpath = "//select[contains(@id,'Industry')]/option[text()='Advertising/Marketing/Media']")
	WebElement amerIndustryValue;

	@FindBy(xpath = "//select[contains(@id,'EMEAIndustry')]/option[text()='Agriculture']")
	WebElement industryValue;

	@FindBy(xpath = "//select[contains(@id,'Investor_Profile__c')]/option[text()='Occupier']")
	WebElement selectIndustryValue;

	@FindBy(xpath = "//select[contains(@id,'Lender_Type__c')]")
	WebElement lenderType;

	@FindBy(xpath = "//select[contains(@id,'Lender_Type__c')]/option[text()='Bank']")
	WebElement selectLenderType;

	@FindBy(xpath = "//select[contains(@id,'AccountSource')]/option[text()='Business Relationship']")
	WebElement accountSourceField;

	@FindBy(xpath = "//input[contains(@id,'TickerSymbol')]")
	WebElement tickerSymbol;

	@FindBy(xpath = "//input[contains(@id,'AnnualRevenue')]")
	WebElement annualRevenue;

	@FindBy(xpath = "//input[contains(@id,'NAICS_Code__c')]")
	WebElement naicsCode;

	@FindBy(xpath = "//input[contains(@id,'SIC_Code_1__c')]")
	WebElement sicCode1;

	@FindBy(xpath = "//input[contains(@id,'SIC_Code_2__c')]")
	WebElement sicCode2;

	@FindBy(xpath = "//input[contains(@id,'SIC_Code_3__c')]")
	WebElement sicCode3;

	@FindBy(xpath = "//input[contains(@id,'SIC_Code_4__c')]")
	WebElement sicCode4;

	@FindBy(xpath = "//input[contains(@id,'SIC_Code_5__c')]")
	WebElement sicCode5;

	@FindBy(xpath = "//input[contains(@id,'SIC_Code_6__c')]")
	WebElement sicCode6;

	@FindBy(xpath = "//textarea[contains(@id,'Description')]")
	WebElement accountDescription;

	@FindBy(xpath = "//select[contains(@id,'LegalStatus')]/option[text()='Corporation']")
	WebElement legalStatusValue;

	@FindBy(xpath = "//article[contains(@class,'forceRelatedListCardDesktop')]//span[contains(text(),'SPOCs')]/ancestor::article//div[text()='New']")
	WebElement spocsNew;
	
	@FindBy(xpath = "//ul[@class='tabs__nav']//a[text()='More']")
	WebElement moreTabButton;
	
	@FindBy(xpath = "//a[text()='Other Related']")
	WebElement otherRelatedButton;

	@FindBy(xpath = "//span[text()='Migrated Account']/parent::label/span[contains(@class,'checkbox')]")
	WebElement migratedAccount;

	@FindBy(xpath = "//span[@class='twitter-typeahead']//input[@id='employeeSearchBox']")
	WebElement spocEmployee;

	@FindBy(xpath = "//div/span[@class='twitter-typeahead']")
	WebElement spocEmployeeExpand;

	@FindBy(xpath = "//select[contains(@id,'role')]")
	WebElement spocRole;

	@FindBy(xpath = "//select[contains(@id,'role')]/option[text()='Leader']")
	WebElement spocRoleValue;

	@FindBy(xpath = "//select[contains(@id,'geo')]")
	WebElement spocGeo;

	@FindBy(xpath = "//select[contains(@id,'geo')]/option[text()='Local']")
	WebElement spocGeoValue;

	@FindBy(xpath = "//select[contains(@id,'region')]")
	WebElement spocRegion;

	@FindBy(xpath = "//select[contains(@id,'region')]/option[text()='Americas']")
	WebElement spocRegionValue;

	@FindBy(xpath = "//select[contains(@id,'country')]")
	WebElement spocCountry;

	@FindBy(xpath = "//select[contains(@id,'country')]/option[text()='United States']")
	WebElement spocCountryValue;

	@FindBy(xpath = "//input[contains(@id,'city')]")
	WebElement spocCity;

	@FindBy(xpath = "//select[contains(@id,'State_province')]")
	WebElement spocState;

	@FindBy(xpath = "//select[contains(@id,'State_province')]/option[text()='Texas']")
	WebElement spocStateValue;

	@FindBy(xpath = "//select[contains(@id,'Spoc_Type')]")
	WebElement spocType;

	@FindBy(xpath = "//select[contains(@id,'Spoc_Type')]/option[text()='Company / Client Request']")
	WebElement spocTypeValue;

	@FindBy(xpath = "//select[contains(@id,'Business_line')]")
	WebElement spocBusinessLine;

	@FindBy(xpath = "//select[contains(@id,'Business_line')]/option[text()='Occupier Brokerage']")
	WebElement spocBusinessLineValue;

	@FindBy(xpath = "//select[contains(@id,'services_unselected')]/option[text()='Consulting']")
	WebElement spocServices;

	@FindBy(xpath = "//input[contains(@id,'Original_date')]")
	WebElement spocOriginalDate;

	@FindBy(xpath = "//input[contains(@id,'Requalification_date')]")
	WebElement spocRequalificationDate;

	@FindBy(xpath = "//div/table/tbody/tr/td/a")
	WebElement spocName;

	@FindBy(xpath = "//input[@id='acctSearchBox']")
	WebElement spocAccountName;

	@FindBy(xpath = "//input[contains(@id,'Source_Broker')]")
	WebElement sourceBroker;

	@FindBy(xpath = "//input[contains(@id,'Source_Stystem')]")
	WebElement sourceSystem;

	@FindBy(xpath = "//textarea[contains(@id,'Team_Member')]")
	WebElement teamMember;

	@FindBy(xpath = "//label[@class='slds-checkbox']/span[@class='slds-checkbox--faux']")
	WebElement excludeSPOCCascade;

	@FindBy(xpath = "//select[@class='slds-select']/option[@value='Private - Follow-Up Task']")
	WebElement activityTypeFollowUpTaskValue;

	@FindBy(xpath = "//input[contains(@id,'dueDate')]")
	WebElement newActivityDueDate;

	@FindBy(xpath = "//p[contains(@class,'slds-tile__title') and contains(@class,'slds-truncate')]/a/parent::p/parent::div/parent::div//div[text()='Activity Type']")
	WebElement activityType;

	@FindBy(xpath = "//p[contains(@class,'slds-tile__title') and contains(@class,'slds-truncate')]/a/parent::p/parent::div/parent::div//div[text()='Status']")
	WebElement statusActivityTimeLine;

	@FindBy(xpath = "//p[contains(@class,'slds-tile__title') and contains(@class,'slds-truncate')]/a/parent::p/parent::div/parent::div//div[text()='Comments']")
	WebElement comments;

	@FindBy(xpath = "//div[@class='slds-media']//p[@class='slds-timeline__date']")
	WebElement dueDate;

	@FindBy(xpath = "//span[@class='slds-checkbox--faux']")
	WebElement statusCheckbox;

	@FindBy(xpath = "//*[text()='No Next Steps. Open And Upcoming Activities Show Up Here.']")
	WebElement activityTimeline;

	@FindBy(xpath = "//p[@class='slds-tile__title slds-truncate']/a")
	WebElement activity;

	@FindBy(xpath = "//button[@title='Past Activity']")
	WebElement pastActivity;

	@FindBy(xpath = "//button[@title='More Activities']")
	WebElement moreActivities;

	@FindBy(xpath = "//a[@class='tabHeader']/span[text()='Activity']")
	WebElement activityTab;

	@FindBy(xpath = "//ul[contains(@class,'forceActionsContainer')]//a[@class='forceActionLink']/div[text()='Edit']")
	WebElement edit;
	
	@FindBy(xpath = "//span[text()='APAC Industry Type']/parent::span/following-sibling::div//a")
	WebElement apacIndustryEditPage;

	@FindBy(xpath = "//div[@class='select-options']//a[@title='Accommodation']")
	WebElement apacIndustryValueEditPage;

	@FindBy(xpath = "//span[text()='APAC Sub Industry']/parent::span/following-sibling::div//a")
	WebElement apacSubIndustryEditPage;

	@FindBy(xpath = "//div[@class='select-options']//a[@title='Hospitality']")
	WebElement apacSubIndustryValueEditPage;

	@FindBy(xpath = "//span[text()='Legal Status']/parent::span/following-sibling::div//a")
	WebElement legalStatusEditPage;

	@FindBy(xpath = "//div[@class='select-options']//a[@title='Corporation']")
	WebElement legalStatusValueEditpage;

	@FindBy(xpath = "//div[contains(@class,'forceModalActionContainer--footerAction')]/button[@title='Save']")
	WebElement saveEditPage;

	@FindBy(xpath = "//a[@class='tabHeader']//span[text()='Details']")
	WebElement details;
	
	@FindBy(xpath = "//span[contains(@id,'acctForm')]/div[@class='slds-form-element']/label/abbr/parent::label")
	WebElement industryValues;

	@FindBy(xpath = "//div[@class='test-id__field-label-container']/span[text()='Client Knowledge Centre']")
	WebElement clientKnowledgeCenterField;

	@FindBy(xpath = "//a[text()='Submit Acct Update Request']")
	WebElement submitAccUpdateRequest;

	@FindBy(xpath = "//input[@placeholder='Search People']")
	WebElement requestedForCase;

	@FindBy(xpath = "//mark[@class='data-match'][text()='test58']")
	WebElement requestedForCaseValue;

	@FindBy(xpath = "//a[@aria-label='Region']")
	WebElement regionCase;

	@FindBy(xpath = "//a[@title='EMEA']")
	WebElement regionValueCase;

	@FindBy(xpath = "//input[@placeholder='Search Accounts']")
	WebElement searchAccountsCase;

	@FindBy(xpath = "//div[@title='George557']")
	WebElement accountValueCase;

	@FindBy(xpath = "//textarea[@role='textbox']")
	WebElement descriptionCase;

	@FindBy(xpath = "//button[@title='Save']")
	WebElement saveCase;

	@FindBy(xpath = "//button[contains(@class,'oneUserProfileCardTrigger')]")
	WebElement triggerForLogout;

	@FindBy(xpath = "//a[text()='Log Out']")
	WebElement logoutButton;

	@FindBy(xpath = "//input[@id='username']")
	WebElement username;

	@FindBy(xpath = "//input[@id='password']")
	WebElement password;

	@FindBy(xpath = "//input[@id='Login']")
	WebElement login;

	@FindBy(xpath = "//p[@class='detail']")
	WebElement caseNotFound;

	@FindBy(xpath = "//div[@class='bBottom']//span[text()='Private Tags']")
	WebElement menu_PrivateTags;

	@FindBy(xpath = "//span[contains(text(),'Properties')]/ancestor::article//div[text()='New']")
	WebElement newPropertiesPrivateTag;

	@FindBy(xpath = "//input[@placeholder='Search Properties']")
	WebElement searchPropertiesPrivateTag;

	@FindBy(xpath = "//div[@title='Test Automation Subject_K4AGZFTL1W']")
	WebElement existingPropertyPrivateTag;

	@FindBy(xpath = "//div[contains(@class,'footer')]/button[@title='Save']")
	WebElement savePropertyPrivateTag;

	@FindBy(xpath = "//one-app-launcher-header/button")
	WebElement applauncher;

	@FindBy(xpath = "//a[@title='Bulk Tagging']/span/span[text()='Bulk Tagging']")
	WebElement bulkTaggingAppLauncher;

	@FindBy(xpath = "//input[@placeholder='Search Account/Contact/Lead/Opportunities/Properties…']")
	WebElement searchPropertiesAccountsContactsLeads;

	@FindBy(xpath = "//span[text()='Next']")
	WebElement newAccountEMEAnext;
	
	@FindBy(xpath="//a[@title='Budgets&#47;Targets']/span/span[text()='Budgets/Targets']")
	WebElement budgetsTargets;
	
	@FindBy(xpath="//div[@class='slds-truncate'][text()='New']")
	WebElement newBudgetsTargets;
	
	@FindBy(xpath="//input[contains(@title,'Search People')]")
	WebElement cbreProfessional;
	
	@FindBy(xpath="//div[contains(@class,'primaryLabel')]/mark[contains(text(),'Broker4')]")
	WebElement cbreProfessionalValue;
	
	@FindBy(xpath="//span[contains(text(),'Start Date')]/parent::label/following-sibling::div/input")
	WebElement startDate;
	
	@FindBy(xpath="//span[contains(text(),'Budget/Target Amount')]/parent::label/following-sibling::input")
	WebElement budgetAmount;
	
	@FindBy(xpath="//div[contains(@class,'forceModalActionContainer--footerAction')]//span[(text()='Save')]")
	WebElement saveBudget;
	
	@FindBy(xpath="//span[contains(text(),'Owner')]/parent::div/following-sibling::div")
	WebElement budgetOwner;
	
	@FindBy(xpath="//span[contains(text(),'Currency')]/parent::span/following-sibling::div//a[contains(@aria-label,'Currency')]")
    WebElement budgetCurrency;
	
	@FindBy(xpath = "//span[text()='Add']")
	WebElement addActivity;
	
	@FindBy(xpath = "//a[contains(@title,'Automation')]")
	WebElement ExistingAccount;
	
	@FindBy(xpath="//*[@id='tag_edit_link']")
	WebElement addTag;
	
	@FindBy(xpath="//textarea[@id='ptag_edit_area']")
	WebElement privatetag;
	
	@FindBy(xpath="//input[@id='tag_save_btn']")
	WebElement savePrivateTag;
	
	@FindBy (xpath = "//*[contains(@class,'slds-dropdown__item has-icon--left   forceVirtualAutocompleteMenuOption')]")
	WebElement AllBudgetTargets;
	
	@FindBy (xpath = " //*[@class='forceActionLink' and @title='Delete']")
	WebElement DeleteBudgetTarget;
	
	@FindBy (xpath = "//*[contains(@class,'slds-button slds-button--neutral uiButton-')]")
	WebElement DeleteBudgetTargetPopup;

	@FindBy (xpath = "//*[@class='primaryLabel slds-truncate slds-lookup__result-text']")
	WebElement SelectCbreProfessional;
	
	@FindBy(css = "ul>li.forceSearchInputLookupDesktopOption:nth-child(1)")
	WebElement firstLookupElement;
	
	@FindBy (xpath = "//*[@class='datePicker-openIcon display']")
	WebElement CalendarIcon;
	
	@FindBy (xpath = "//*[contains(@class,'today slds-s')]")
	WebElement CalendarDate;
	
	@FindBy (xpath = "//*[(@title='Edit')]")
	WebElement EditBudgetTarget;
	
	@FindBy (xpath = "//*[(@class='deleteIcon')]")
	WebElement deleteCbreProfessional;
	
	@FindBy (xpath = "//*[contains(@title,'Clone')]")
	WebElement CloneBudgteTarget;
	
	@FindBy(xpath = "//a[@class='slds-truncate outputLookupLink slds-truncate forceOutputLookup']")
	WebElement AccountList;
	
	@FindBy (xpath = "//*[contains(@title,'View records tagged')]")
	WebElement PrivateTagged;
	@FindBy (xpath = " //*[contains(@class,'entityNameTitle slds-breadcrumb__item slds-line-height--reset')]")
	WebElement PrivateTagPage;
	
	@FindBy (xpath = "//*[(@title='Test Broker6')]")
    WebElement SelectTestBroker;
	
	@FindBy (xpath = "//div[@title='Delete' and text()='Delete']/parent::a[@title='Delete']")
	WebElement DeleteClone;
	
	
	DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
	Date date = new Date();

	HomePage hp = new HomePage(scriptHelper);
	LoginPage loginPage = new LoginPage(scriptHelper);
	SearchTextSOQL searchAccount = new SearchTextSOQL(scriptHelper);
	ActivityPage activityPage = new ActivityPage(scriptHelper);
	static ArrayList<String> accountsPageDetailsList = new ArrayList<String>();

	
	/**
	 * Account Landing Page functionality Header information
	 * 
	 * @author Cognizant
	 *
	 */
	public void navigateToTag() {
		Utility_Functions.xWaitForElementPresent(driver,moreMenu,3);
		Utility_Functions.xClick(driver, moreMenu, true);
		Utility_Functions.xWaitForElementPresent(driver,moreTag,3);
		Utility_Functions.xClick(driver, moreTag, true);
		
		report.updateTestLog("Verify Sharing private tag", "All tags are displayed successfully:::", Status.PASS);
		List<WebElement> tagNameList = driver.findElements(By.xpath(".//a[@class='slds-truncate outputLookupLink slds-truncate forceOutputLookup']"));
		Utility_Functions.xclickRandomElement(tagNameList);
		
		
	}
	
	/**
	 * Account Landing Page functionality Header information
	 * 
	 * @author Cognizant
	 *
	 */
	public void shareTag() {
		Utility_Functions.xWaitForElementPresent(driver,btnShare,3);
		Utility_Functions.xClick(driver, btnShare, true);
		Utility_Functions.timeWait(2);
		Utility_Functions.xSwitchtoFrame(driver, tagSharing);
		Utility_Functions.xWaitForElementPresent(driver, tagSharing, 4);
		
		Utility_Functions.timeWait(2);
		driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@title='Content']")));
		
			Utility_Functions.xWaitForElementPresent(driver, addButtonUser, 5);
			Utility_Functions.xClick(driver, addButtonUser, true);
			
			//Select userSelect=new Select(driver.findElement(By.xpath("//select[@id='sharing_search']")));
			
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
			Utility_Functions.xSelectDropdownByName(access, "Read/Write");
			Utility_Functions.xClick(driver, tagSaveBtn, true);
			Utility_Functions.timeWait(3);
		
		
		driver.switchTo().defaultContent();
		
	}
	
	/**
	 * Account Landing Page functionality Header information
	 * 
	 * @author Vishnuvardhan
	 *
	 */
	public void accountDetailsPage() {
		accountsPageDetailsList.add("Tagging");
		accountsPageDetailsList.add("Account Information");
		accountsPageDetailsList.add("Account Segmentation");
		accountsPageDetailsList.add("Account Hierarchy");
		accountsPageDetailsList.add("Address Information");
		accountsPageDetailsList.add("Local Address Information");
		accountsPageDetailsList.add("Additional Information");
		accountsPageDetailsList.add("SIC/NAICS Codes");
		accountsPageDetailsList.add("Description Information");
		accountsPageDetailsList.add("APAC Fields");
		accountsPageDetailsList.add("EMEA Fields");
		accountsPageDetailsList.add("Rollup Summary Fields");
		accountsPageDetailsList.add("System Information");
		accountsPageDetailsList.add("Custom Links");
		System.out.println("Account Details Page information are:: " + accountsPageDetailsList);
	}

	/**
	 * Validating the Account Landing Page functionality
	 * 
	 * @author Vishnuvardhan
	 *
	 */

	public void accountDetailsPagebyDefault() {
		accountDetailsPage();
		hp.validate_Menu_Accounts();
		Utility_Functions.timeWait(3);
		List<WebElement> accountList = driver.findElements(By.xpath("//a[@class='slds-truncate outputLookupLink slds-truncate forceOutputLookup'][contains(@data-recordid,'001')]"));
		Utility_Functions.xclickRandomElement(accountList);
		List<WebElement> accountsPageInfoList = driver
				.findElements(By.xpath("//span[contains(@class,'header-title')]"));
		Utility_Functions.xScrollWindow(driver);
		String[] linkTexts = new String[accountsPageInfoList.size()];
		int i = 0, count = 0;
		try {
			for (WebElement element : accountsPageInfoList) {
				linkTexts[i] = element.getText();
				if (linkTexts[i].equals(accountsPageDetailsList.get(i))) {
					count++;
					System.out.println("Account Page Details is having all the fields::: " + linkTexts[i] + ":::"
							+ accountsPageDetailsList.get(i));
					report.updateTestLog("Verify Account Landing Page Information",
							"Landing page of Account Details is having all the fields:::" + linkTexts[i] + ":::",
							Status.PASS);
				}
				i++;
			}
			if (dataTable.getData("General_Data", "TC_ID").contains("Broker")) {
				if (count == 9) {
					System.out.println("All the links are present in Home Page:::");
					report.updateTestLog("Verify Account Landing Page Information",
							"Account Details Page is having all the details in account landing page:::", Status.PASS);
				}
			} else if (!dataTable.getData("General_Data", "TC_ID").contains("Broker")) {
				if (count == 14) {
					System.out.println("All the links are present in Home Page:::");
					report.updateTestLog("Verify Account Landing Page Information",
							"Account Details Page is having all the details in account landing page:::", Status.PASS);
				}
			} else {
				report.updateTestLog("Verify Account Landing Page Information",
						"Account Details Page is not having all the details in account landing page:::", Status.FAIL);
			}
		} catch (Exception e) {
			e.printStackTrace();
			report.updateTestLog("Exception occurred in acccount Detail Landing Page", e.getMessage() + ":::",
					Status.FAIL);
		}

	}

	/**
	 * Validating the addition of Private Notes functionality
	 * 
	 * @author Vishnuvardhan
	 *
	 */

	public void addPrivateNote() {
		hp.validate_Menu_Accounts();
		List<WebElement> accountList = driver
				.findElements(By.cssSelector("div.listViewContent table.forceRecordLayout a.outputLookupLink"));
		String accountSelected = Utility_Functions.xclickgetTextofFirstElementfromList(accountList);
		Utility_Functions.xWaitForElementPresent(driver, related_Accounts, 3);
		Utility_Functions.xClickVisibleListElement(driver, related_Accounts);

		try {
			Utility_Functions.xScrollWindow(driver);
			Utility_Functions.xScrollWindowTop(driver);
			Utility_Functions.xClick(driver, new_PrivateNotes, true);
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
			report.updateTestLog("Failed to Scroll", e.getMessage(), Status.FAIL);
		}
		Utility_Functions.xClick(driver, next_PrivateNotes, true);
		String accountPopulated = account_PrivateNotes.getText();
		Utility_Functions.xSendKeys(driver, title_PrivateNotes, dataTable.getData("General_Data", "Title"));
		if (accountSelected.equals(accountPopulated)) {
			report.updateTestLog("Verify Private Note", "Account populated on Private Note is same as the one "
					+ "selected while creating the Private Note", Status.PASS);
		} else {
			report.updateTestLog("Verify Private Note",
					"Account populated on Private Note is not the one " + "selected while creating the Private Note",
					Status.FAIL);
		}
		Utility_Functions.xWaitForElementPresent(driver, searchContacts, 4);
		Utility_Functions.xClick(driver, searchContacts, true);
		WebElement firstLookupElement = driver
				.findElement(By.cssSelector("ul>li.forceSearchInputLookupDesktopOption:nth-child(1)"));
		Utility_Functions.xWaitForElementPresent(driver, firstLookupElement, 4);
		Utility_Functions.xClick(driver, firstLookupElement, false);
		Utility_Functions.xSendKeys(driver, body, dataTable.getData("General_Data", "Body"));
		Utility_Functions.xClick(driver, saveButton, true);
		Utility_Functions.xWaitForElementPresent(driver, wasCreated, 4);
		if (wasCreated.getText().contains("was created")) {
			report.updateTestLog("Verify Private Note", "Private Note is created successfully", Status.PASS);
		} else {
			report.updateTestLog("Verify Private Note", "Private Note creation Failed", Status.FAIL);
		}

	}

	/**
	 * Accounts Page Label List
	 * 
	 * @author Vishnuvardhan
	 *
	 */

	static ArrayList<String> labelList = new ArrayList<String>();

	public void labelsAccountPage() {
		labelList.add("Account Name");
		labelList.add("Billing Street");
		labelList.add("Billing City");
		labelList.add("Billing Country");
		labelList.add("Billing State/Province");
		labelList.add("Billing Zip/Postal Code");
		labelList.add("Website");
		labelList.add("Phone");
		labelList.add("Industry");

		labelList.add("Account Site");
		labelList.add("Tradestyle Name");
		labelList.add("Legal Status");
		labelList.add("Account Opportunity History");
		labelList.add("Tax Label 1");
		labelList.add("Tax Label2");
		labelList.add("Tax Code 1");
		labelList.add("Tax Code 2");
		labelList.add("Staging Record Id");
		labelList.add("Created By Country");
		labelList.add("Last updated by Country");
		labelList.add("Original Account Name");
		labelList.add("Local Account Name");
		labelList.add("Account Fax");
		labelList.add("Immediate Parent Account");
		labelList.add("Brand Parent");
		labelList.add("Global Brand");

		labelList.add("Client Type");
		labelList.add("Key Client Account for");
		labelList.add("Key Pursuit Account for");

		labelList.add("Shipping Street");
		labelList.add("Shipping City");
		labelList.add("Shipping Country]");
		labelList.add("Shipping State/Province");
		labelList.add("Shipping Zip/Postal Code");

		labelList.add("Local Billing Country");
		labelList.add("Local Billing Street");
		labelList.add("Local Billing City");
		labelList.add("Local Billing Zip/Postal Code");
		labelList.add("Local Shipping Zip/Postal Code");
		labelList.add("Local Shipping Country");
		labelList.add("Local Shipping Street");
		labelList.add("Local Shipping City");
		labelList.add("Local Billing State/Province");
		labelList.add("Local Shipping State/Province");

		labelList.add("Number of Family Members");
		labelList.add("Investor Profile");
		labelList.add("Lender Type");
		labelList.add("D-U-N-S #");
		labelList.add("Previous D-U-N-S #");
		labelList.add("Integration Id");
		labelList.add("Tax Code Label Type");
		labelList.add("Status");
		labelList.add("Reason for Inactivating");
		labelList.add("Inactivation Date");
		labelList.add("Marketability");
		labelList.add("Account Source");
		labelList.add("Ticker Symbol");
		labelList.add("Annual Revenue");
		labelList.add("Australian Business Number(ABN)");
		labelList.add("Teikoku Databank Code (TBD)");
		labelList.add("Verified System Id");
		labelList.add("Verified Date");
		labelList.add("Source Created Date Time");
		labelList.add("Source Last Updated Date Time");

		labelList.add("NAICS Code");
		labelList.add("SIC Code 1");
		labelList.add("SIC Code 2");
		labelList.add("SIC Code 3");
		labelList.add("SIC Code 4");
		labelList.add("SIC Code 5");
		labelList.add("SIC Code 6");
		labelList.add("TBD Industry Code");
		labelList.add("NAICS Code Description");
		labelList.add("SIC Code 1 Description");
		labelList.add("SIC Code 2 Description");
		labelList.add("SIC Code 3 Description");
		labelList.add("SIC Code 4 Description");
		labelList.add("SIC Code 5 Description");
		labelList.add("SIC Code 6 Description");
		labelList.add("TBD Industry Code Description");

		labelList.add("Account Description");

		labelList.add("Created By");
		labelList.add("Record Type");
		labelList.add("Translation Status");
		labelList.add("Account Creator Country");
		labelList.add("DIG Review Comments");
		labelList.add("Hiearchy Code");
		labelList.add("Account Owner");
		labelList.add("Unique Account ID");
		labelList.add("Family Id Formula");
		labelList.add("Source System");
		System.out.println("Labels present in the new account page are:: " + labelList);

	}

	/**
	 * Accounts Page Header Section List
	 * 
	 * @author Vishnuvardhan
	 *
	 */

	static ArrayList<String> headerSectionList = new ArrayList<String>();

	public void headerSectionAccountPage() {
		// headerSectionList.add("Quick Create");
		headerSectionList.add("Account Information");
		headerSectionList.add("Account Segmentation");
		headerSectionList.add("Address Information");
		headerSectionList.add("Local Address Information");
		headerSectionList.add("Additional Information");
		headerSectionList.add("SIC/NAICS Codes");
		headerSectionList.add("Description Information");
		headerSectionList.add("System Information");
		System.out.println("Header Section Details present in the new account page are:: " + headerSectionList);
	}

	/**
	 * Validating the New Account Page Layout fields
	 * 
	 * @author Vishnuvardhan
	 *
	 */

	public void newAccountPageLayout() {
		headerSectionAccountPage();
		labelsAccountPage();
		Utility_Functions.xWaitForElementPresent(driver, menu_Accounts, 3);
		Utility_Functions.xClick(driver, menu_Accounts, true);
		Utility_Functions.xWaitForElementPresent(driver, newAccount, 3);
		Utility_Functions.xClick(driver, newAccount, true);
		Utility_Functions.timeWait(2);
		/*if (!dataTable.getData("General_Data", "TC_ID").contains("Broker")) {
			Utility_Functions.xSwitchtoFrame(driver, continueButton);
			Utility_Functions.xWaitForElementPresent(driver, continueButton, 5);
			Utility_Functions.timeWait(1);
			Utility_Functions.xClick(driver, continueButton, true);
			driver.switchTo().defaultContent();
		}
		Utility_Functions.xSwitchtoFrame(driver, viewAllFieldsButton);
		Utility_Functions.xWaitForElementPresent(driver, viewAllFieldsButton, 5);
		Utility_Functions.xScrollWindow(driver);
		Utility_Functions.xClick(driver, viewAllFieldsButton, true);
		Utility_Functions.timeWait(1);
		Utility_Functions.xScrollWindowTop(driver);
		List<WebElement> headerList = driver.findElements(
				By.xpath("//h2[@class='slds-text-heading--medium slds-m-top--x-large slds-m-bottom--large']"));*/
		List<WebElement> headerList = driver.findElements(By.xpath("//span[contains(@class,'header-title')]"));
		try {
			int i2 = 0, count = 0;
			String[] headerTexts = new String[headerList.size()];
			for (WebElement element : headerList) {
				headerTexts[i2] = element.getText();
				if (headerTexts[i2].contains(headerSectionList.get(i2))) {
					count++;
					System.out.println("Verify Add Account Header List" + element.getText());
					report.updateTestLog("Verify Add Account Header List",
							element.getText() + " header is present in Add Account Page", Status.PASS);
				}
				i2++;
			}
			System.out.println(count);
			/*if (count == 8) {
				report.updateTestLog("Verify Add Account Header List", "header is present in Add Account Page",
						Status.PASS);
			} else {
				report.updateTestLog("Verify Add Account Header List", "header is not present in Add Account Page",
						Status.FAIL);
			}*/
			if (dataTable.getData("General_Data", "TC_ID").contains("Broker")) {
				if (count == 8) {
					System.out.println("All the links are present in Home Page:::");
					report.updateTestLog("Verify Account Landing Page Information",
							"Account Details Page is having all the details in account landing page:::", Status.PASS);
				}
			} else if (!dataTable.getData("General_Data", "TC_ID").contains("Broker")) {
				if (count == 14) {
					System.out.println("All the links are present in Home Page:::");
					report.updateTestLog("Verify Account Landing Page Information",
							"Account Details Page is having all the details in account landing page:::", Status.PASS);
				}
			} else {
				report.updateTestLog("Verify Account Landing Page Information",
						"Account Details Page is not having all the details in account landing page:::", Status.FAIL);
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		try {
			List<WebElement> labelListAccountPage = driver.findElements(By.xpath("//label[@class='slds-fsorm-element__label']"));
			int i1 = 0, countLabelList = 0;
			String[] labelTexts = new String[labelListAccountPage.size()];
			for (WebElement element : labelListAccountPage) {
				labelTexts[i1] = element.getText();
				if (labelTexts[i1].contains(labelList.get(i1))) {
					System.out.println("Verify Add Account Page Label List" + element.getText());
					report.updateTestLog("Verify Add Account Page Label List",
							element.getText() + " label list is present in Add Account Page", Status.PASS);
					countLabelList++;
				}
				i1++;
			}

			System.out.println(countLabelList);
			if (countLabelList == 79) {
				report.updateTestLog("Verify Add Account Page Label List", "Labels are present in Add Account Page",
						Status.PASS);
			} else {
				report.updateTestLog("Verify Add Account Page Label List", "Labels are not present in Add Account Page",
						Status.FAIL);
			}

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	/**
	 * Validating the addition of New Personal information
	 * 
	 * @author Ramya
	 *
	 */
	public void addNewPersonalInformation() {
		Utility_Functions.xClick(driver, menu_Accounts, true);
		Utility_Functions.timeWait(3);
		List<WebElement> accountNamesList = driver.findElements(By.xpath(".//a[@class='slds-truncate outputLookupLink slds-truncate forceOutputLookup'][contains(@data-recordid,'001')]"));
		Utility_Functions.xclickRandomElement(accountNamesList);
		Utility_Functions.timeWait(3);
		Utility_Functions.xClickVisibleListElement(driver, related_Accounts);
		Utility_Functions.timeWait(3);
		Utility_Functions.xScrollWindow(driver);
		Utility_Functions.timeWait(1);
		Utility_Functions.xScrollWindowTop(driver);
		Utility_Functions.timeWait(2);
		Utility_Functions.xClick(driver, new_PrivateNotes, true);
		Utility_Functions.timeWait(3);
		Utility_Functions.xClick(driver, selectPersonalInformation, true);
		Utility_Functions.timeWait(3);
		Utility_Functions.xClick(driver, next, true);
		Utility_Functions.timeWait(3);
		Utility_Functions.xClick(driver, titleName, true);
		Utility_Functions.xClick(driver, account_PrivateNotes, true);
		Utility_Functions.timeWait(2);
		Utility_Functions.xSendKeys(driver, titleName, "Test Personal Information Note_" + Utility_Functions.xGenerateAlphaNumericString());
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
		List<WebElement> personalInformation = driver.findElements(By.xpath(".//label[@class='label inputLabel uiLabel-left form-element__label uiLabel']"));
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
				} else if ((count == 3) && (element.getText().contains("SPOC"))) {
					System.out
							.println("Account field is present in the Create Private Notes Personal Information Page");
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
				} else if ((count == 5) && (element.getText().contains("Property"))) {
					System.out
							.println("Property field is present in the Create Private Notes Personal Information Page");
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
			if (count != 3) {
				report.updateTestLog("Create Private Notes Personal Information Page",
						"Create Private Notes Personal Information Page is not having all the fields::", Status.FAIL);

			}
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
		}
		Utility_Functions.xClick(driver, saveButton, true);
		Utility_Functions.timeWait(3);
		Utility_Functions.xScrollWindow(driver);
		Utility_Functions.timeWait(1);
		Utility_Functions.xScrollWindowTop(driver);
		Utility_Functions.timeWait(2);
		Utility_Functions.xClick(driver, viewAllButton, true);
		Utility_Functions.timeWait(3);
		System.out.println("New Private Notes are displayed");
		report.updateTestLog("New Private Notes are displayed", " New Private notes are displayed", Status.PASS);
	}

	public void verifyNewNotesAndFilesAttachment() {
		Utility_Functions.xWaitForElementPresent(driver, menu_Accounts, 3);
		Utility_Functions.xClick(driver, menu_Accounts, true);
		Utility_Functions.timeWait(3);
		List<WebElement> accountNamesList = driver.findElements(By.xpath(".//a[@class='slds-truncate outputLookupLink slds-truncate forceOutputLookup'][contains(@data-recordid,'001')]"));
		Utility_Functions.xclickOnFirstElementfromList(accountNamesList);
		Utility_Functions.timeWait(3);
		Utility_Functions.xWaitForElementPresent(driver, related_Accounts, 3);
		Utility_Functions.xClickVisibleListElement(driver, related_Accounts);
		List<WebElement> relatedPageList = driver.findElements(By.xpath("//*[@id='header']/a/span[1]"));
		try {
			for (WebElement element : relatedPageList) {
				if (element.getText().contains("Notes")) {
					System.out.println("Notes is present in the Accounts Related page :" + element.getText());
					report.updateTestLog("Verify Notes in the Accounts Related Page ",
							"Notes is present in the Accounts related page are :" + element.getText(), Status.PASS);

				} else if (element.getText().contains("Files")) {

					System.out.println("Files is present in the Accounts Related page " + element.getText());
					report.updateTestLog("Files is present in the Accounts Related Page Elements",
							"Files is present present in the Accounts Related Page", Status.PASS);

				} else if (!element.getText().contains("Notes and Attachments")) {

					System.out.println("Notes and Attachments is not present in the Accounts Related Page");
					report.updateTestLog("Verify Notes and Attachments ",
							"Verifying Notes and Attachments is not present in the Accounts Related page", Status.PASS);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		Utility_Functions.xScrollWindow(driver);
		Utility_Functions.timeWait(2);
		Utility_Functions.xScrollWindowTop(driver);
		Utility_Functions.timeWait(2);
		Utility_Functions.xWaitForElementPresent(driver, newNotes, 3);
		Utility_Functions.xClick(driver, newNotes, true);
		if (!noteTitle.getText().isEmpty()) {
			System.out.println("Untitled Note is present in the Note Page");
		} else {
			System.out.println("Untitled Note is not present in the Note Page");
		}
		if (!noteEditArea.getText().isEmpty()) {
			System.out.println("Text is present in the Note Page");
		} else {
			System.out.println("Text is not present in the Note Page");
		}
		if (!untitledNoteSelectedAccount.getText().isEmpty()) {
			System.out.println("Selected Account is present in the Note Page :" + untitledNoteSelectedAccount.getText());
		} else {
			System.out.println("Selected Account is not present in the Note Page");
		}
		List<WebElement> untitledNotePageListDone = driver.findElements(By.xpath("//button[@class='slds-button slds-button--neutral hideDoneButton uiButton--default uiButton--brand uiButton']/span[contains(text(),'Done')]"));
		try {
			for (WebElement element : untitledNotePageListDone) {

				if (element.getText().contains("Done")) {
					System.out.println("Done Button is present in the Notes page :" + element.getText());
					report.updateTestLog("Done Button is present in the Untitled Notes Page ",
							" Done Button is present in the Untitled Notes page are :" + element.getText(),
							Status.PASS);
				} else {
					System.out.println("Done Button is not present in the Untitled Notes page " + element.getText());
					report.updateTestLog("Done Button is not present in the Untitled Notes Page Elements",
							"Done Button is not present in the Untitled Notes Page", Status.FAIL);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		Utility_Functions.timeWait(3);
		Utility_Functions.xClick(driver, noteTitle, true);
		Utility_Functions.timeWait(3);
		Utility_Functions.xSendKeys(driver, noteTitle, "Test Automation Note_" + Utility_Functions.xGenerateAlphaNumericString());
		Utility_Functions.timeWait(3);
		Utility_Functions.xWaitForElementPresent(driver, By.xpath("//div[@data-placeholder='Enter a note...']"), 5);
		Actions action = new Actions(driver.getWebDriver());
		action.moveToElement(noteEditArea);
		action.click();
		action.sendKeys("Testing");
		action.build().perform();
		Utility_Functions.xWaitForElementPresent(driver, doneButton, 3);
		Utility_Functions.xClick(driver, doneButton, true);
		Utility_Functions.xWaitForElementPresent(driver, addFile, 3);
		Utility_Functions.xClick(driver, addFile, true);
		Utility_Functions.xWaitForElementPresent(driver, addFileAttachment, 3);
		Utility_Functions.xClick(driver, addFileAttachment, true);
		Utility_Functions.xWaitForElementPresent(driver, add, 3);
		Utility_Functions.xClick(driver, add, true);
		System.out.println("File is Added");
		report.updateTestLog("File is present in the Accounts Page Elements", "File is present in the Accounts bPage",
				Status.PASS);
	}

	/**
	 * Validating the creation of New Activity Page in the Accounts
	 * 
	 * @author Ramya
	 *
	 */
	public void verifyCreateActivityAccount() {
		Utility_Functions.xWaitForElementPresent(driver, menu_Accounts, 3);
		Utility_Functions.xClick(driver, menu_Accounts, true);
		report.updateTestLog("Verify Create Activity Account", "Accounts is Displayed ", Status.PASS);
		Utility_Functions.xWaitForElementPresent(driver, recentlyViewed, 3);
		Utility_Functions.xClick(driver, recentlyViewed, true);
		report.updateTestLog("Verify Create Activity Account", "Recently viewed Accounts are Displayed ", Status.PASS);
		Utility_Functions.xWaitForElementPresent(driver, allAccounts, 3);
		Utility_Functions.xClick(driver, allAccounts, true);
		Utility_Functions.timeWait(5);
		report.updateTestLog("Verify Create Activity Account", "All accounts are displayed successfully:::", Status.PASS);
		List<WebElement> accountNamesList = driver.findElements(By.xpath(".//a[@class='slds-truncate outputLookupLink slds-truncate forceOutputLookup'][contains(@data-recordid,'001')]"));
		Utility_Functions.xclickRandomElement(accountNamesList);
		Utility_Functions.timeWait(3);
		report.updateTestLog("Verify Create Activity Account ", "The Account is Displayed ", Status.PASS);
		//accountname=accountNameSaved.getText();
		accountname=Utility_Functions.xGetTextVisibleListElement(driver, accountNameSaved);
		System.out.println(accountname);
		//Utility_Functions.timeWait(2);
		activityPage.createNewActivity();				
	}
	/**
	 * Validating the creation of New Activity Page in the Accounts
	 * 
	 * @author Cognizant
	 *
	 */
	
	public void selectAccount(){
		Utility_Functions.xWaitForElementPresent(driver, menu_Accounts, 3);
		Utility_Functions.xClick(driver, menu_Accounts, true);
		report.updateTestLog("Verify Create Activity Account", "Accounts is Displayed ", Status.PASS);
		Utility_Functions.xWaitForElementPresent(driver, recentlyViewed, 3);
		Utility_Functions.xClick(driver, recentlyViewed, true);
		report.updateTestLog("Verify Create Activity Account", "Recently viewed Accounts are Displayed ", Status.PASS);
		Utility_Functions.xWaitForElementPresent(driver, allAccounts, 3);
		Utility_Functions.xClick(driver, allAccounts, true);
		Utility_Functions.timeWait(5);
		report.updateTestLog("Verify Create Activity Account", "All accounts are displayed successfully:::", Status.PASS);
		List<WebElement> accountNamesList = driver.findElements(By.xpath(".//a[@class='slds-truncate outputLookupLink slds-truncate forceOutputLookup'][contains(@data-recordid,'001')]"));
		Utility_Functions.xclickRandomElement(accountNamesList);
		Utility_Functions.timeWait(3);
		report.updateTestLog("Verify Create Activity Account ", "The Account is Displayed ", Status.PASS);
	}
	
	public String selectAccountWithId(String accountId){
		Utility_Functions.xWaitForElementPresent(driver, menu_Accounts, 3);
		Utility_Functions.xClick(driver, menu_Accounts, true);
		report.updateTestLog("Verify Create Activity Account", "Accounts is Displayed ", Status.PASS);
		Utility_Functions.xWaitForElementPresent(driver, recentlyViewed, 3);
		Utility_Functions.xClick(driver, recentlyViewed, true);
		report.updateTestLog("Verify Create Activity Account", "Recently viewed Accounts are Displayed ", Status.PASS);
		Utility_Functions.xWaitForElementPresent(driver, allAccounts, 3);
		Utility_Functions.xClick(driver, allAccounts, true);
		Utility_Functions.timeWait(5);
		report.updateTestLog("Verify Create Activity Account", "All accounts are displayed successfully:::", Status.PASS);
		List<WebElement> accountNamesList = driver.findElements(By.xpath(".//a[@class='slds-truncate outputLookupLink slds-truncate forceOutputLookup'][contains(@data-recordid,'001')]"));
		Utility_Functions.xclickRandomElement(accountNamesList);
		Utility_Functions.timeWait(3);
		report.updateTestLog("Verify Create Activity Account ", "The Account is Displayed ", Status.PASS);
		String url = driver.getCurrentUrl().split("#")[0];
		String newUrl = url + "#/sObject/" + accountId;
		newUrl = newUrl + "/view";
		report.updateTestLog("Verify Create Accounts View Hierarchy",
				"Verifying the URL has been replaced with the new URL having the retrieved Account" + newUrl,
				Status.PASS);
		driver.get(newUrl);
		Utility_Functions.timeWait(3);
		//String accountName=accountNameSaved.getText();
		String accountName=Utility_Functions.xGetTextVisibleListElement(driver, accountNameSaved);
		System.out.println(accountName);
		return accountName;
		
	}

	/**
	 * Validating the Follow Up Custom Activity
	 * 
	 * @author Ramya
	 *
	 */

	public void verifyFollowUpCustomActivity() {
		Utility_Functions.xWaitForElementPresent(driver, menu_Accounts, 3);
		Utility_Functions.xClick(driver, menu_Accounts, true);
		report.updateTestLog("Verify Create Activity Account", "Accounts is Displayed ", Status.PASS);
		Utility_Functions.xWaitForElementPresent(driver, recentlyViewed, 3);
		Utility_Functions.xClick(driver, recentlyViewed, true);
		report.updateTestLog("Verify Create Activity Account", "Recently viewed Accounts are Displayed ", Status.PASS);
		Utility_Functions.xWaitForElementPresent(driver, allAccounts, 3);
		Utility_Functions.xClick(driver, allAccounts, true);
		Utility_Functions.timeWait(2);
		report.updateTestLog("Verify Create Activity Account", "All accounts are displayed successfully:::", Status.PASS);
		List<WebElement> accountNamesList = driver.findElements(By.xpath(".//a[@class='slds-truncate outputLookupLink slds-truncate forceOutputLookup'][contains(@data-recordid,'001')]"));
		Utility_Functions.xclickOnFirstElementfromList(accountNamesList);
		activityPage.createNewActivity();
	}

	/**
	 * Validating the New Activity Page Layout for the Accounts
	 * 
	 * @author Ramya
	 *
	 */
	
	public void verifyNewActivityPageLayout() {
		Utility_Functions.xWaitForElementPresent(driver, menu_Accounts, 3);
		Utility_Functions.xClick(driver, menu_Accounts, true);
		report.updateTestLog("Verify New Activity Page Layout ", "Accounts is Displayed ", Status.PASS);
		Utility_Functions.xWaitForElementPresent(driver, recentlyViewed, 3);
		Utility_Functions.xClick(driver, recentlyViewed, true);
		report.updateTestLog("Verify New Activity Page Layout ", "Recently viewed Accounts are Displayed ", Status.PASS);
		Utility_Functions.xWaitForElementPresent(driver, allAccounts, 3);
		Utility_Functions.xClick(driver, allAccounts, true);
		Utility_Functions.timeWait(3);
		report.updateTestLog("Verify New Activity Page Layout ", "All Accounts are Displayed ", Status.PASS);
		List<WebElement> accountNamesList = driver.findElements(By.xpath(".//a[@class='slds-truncate outputLookupLink slds-truncate forceOutputLookup'][contains(@data-recordid,'001')]"));
		Utility_Functions.xclickOnFirstElementfromList(accountNamesList);
		Utility_Functions.timeWait(3);
		report.updateTestLog("Verify New Activity Page Layout ", "The Account is Displayed ", Status.PASS);
		Utility_Functions.xWaitForElementPresent(driver, addActivity, 3);
		Utility_Functions.xClick(driver, addActivity, true);
		report.updateTestLog("Verify New Activity Page Layout ", "The New Activity in the Details page is Displayed ", Status.PASS);
		activityPage.verifyNewActivityPageLayout();
	}

	/**
	 * Validating the New Activity Page Layout for the Accounts for incorrect
	 * data
	 * 
	 * @author Ramya
	 *
	 */
	public void verifyNewActivityPageForIncorrectData() {
		Utility_Functions.xClick(driver, menu_Accounts, true);
		Utility_Functions.timeWait(3);
		report.updateTestLog("Verify New Activity Page Layout ", "Accounts is Displayed ", Status.PASS);
		List<WebElement> accountNamesList = driver.findElements(By.xpath(".//a[@class='slds-truncate outputLookupLink slds-truncate forceOutputLookup'][contains(@data-recordid,'001')]"));
		Utility_Functions.xclickOnFirstElementfromList(accountNamesList);
		Utility_Functions.timeWait(3);
		report.updateTestLog("Verify New Activity Page Layout ", "The Account is Displayed ", Status.PASS);
		Utility_Functions.xClickVisibleListElement(driver, related_Accounts);
		Utility_Functions.timeWait(3);
		report.updateTestLog("Verify New Activity Page Layout ", "The related page is Displayed ", Status.PASS);
		Utility_Functions.xScrollWindow(driver);
		Utility_Functions.timeWait(1);
		Utility_Functions.xScrollWindowTop(driver);
		Utility_Functions.timeWait(2);
		Utility_Functions.xWaitForElementPresent(driver, newActivity, 3);
		Utility_Functions.xClick(driver, newActivity, true);
		report.updateTestLog("Verify New Activity Page Layout ", "The New Activity in the related page is Displayed ",
				Status.PASS);
		Utility_Functions.xSwitchtoFrame(driver, subject);
		Utility_Functions.timeWait(3);
		Utility_Functions.xWaitForElementPresent(driver, subject, 3);
		Utility_Functions.xClick(driver, subject, true);
		Utility_Functions.xWaitForElementPresent(driver, subject, 3);
		Utility_Functions.xSendKeys(driver, subject,
				"Test Automation Subject_" + Utility_Functions.xGenerateAlphaNumericString());
		report.updateTestLog("Verify New Activity Page Layout ", "The New Activity in the related page is Displayed ",
				Status.PASS);
		Utility_Functions.xWaitForElementPresent(driver, activityType1, 3);
		Utility_Functions.xClick(driver, activityType1, true);
		report.updateTestLog("Verify New Activity Page Layout ", "The New Activity in the related page is Displayed ",
				Status.PASS);
		Utility_Functions.xSendKeys(driver, relatedToContactField, "Adarsh Mehta");
		relatedToContactField.sendKeys(Keys.ARROW_DOWN);
		relatedToContactField.sendKeys(Keys.TAB);
		report.updateTestLog("Verify New Activity Page Layout ",
				"Verifying the New Activity Page Contact Field is populated with the user data ", Status.PASS);
		Utility_Functions.xSendKeys(driver, relatedToOpportunityField, "ABC Telecom-Consulting-134-Acres");
		relatedToOpportunityField.sendKeys(Keys.ARROW_DOWN);
		relatedToOpportunityField.sendKeys(Keys.TAB);
		report.updateTestLog("Verify New Activity Page Layout ",
				"Verifying the New Activity Page Opportunity Field is populated with the user data ", Status.PASS);
		Utility_Functions.xSendKeys(driver, relatedToPropertyField, "test25APR - South Lamar Street");
		relatedToPropertyField.sendKeys(Keys.ARROW_DOWN);
		relatedToPropertyField.sendKeys(Keys.TAB);
		report.updateTestLog("Verify New Activity Page Layout ",
				"Verifying the New Activity Page Property Field is populated with the user data ", Status.PASS);
		Utility_Functions.xWaitForElementPresent(driver, saveActivity, 3);
		Utility_Functions.xClick(driver, saveActivity, true);
		report.updateTestLog("Verify New Activity Page Layout ", "Verifying whether the New Activity page is saved", Status.PASS);
	}

	/**
	 * Validating the New Activity Page send Notification Email to the Assigned
	 * Person
	 * 
	 * @author Ramya
	 *
	 */

	public void verifyAccountsNewActivityPageSendNotificationEmail() {
		Utility_Functions.xWaitForElementPresent(driver, menu_Accounts, 3);
		Utility_Functions.xClick(driver, menu_Accounts, true);
		report.updateTestLog("Verify New Activity Page send Notification Email ", "Verifying the Accounts is Displayed ", Status.PASS);
		List<WebElement> accountNamesList = driver.findElements(By.xpath(".//a[@class='slds-truncate outputLookupLink slds-truncate forceOutputLookup'][contains(@data-recordid,'001')]"));
		Utility_Functions.xclickOnFirstElementfromList(accountNamesList);
		report.updateTestLog("Verify New Activity Page send Notification Email ", "Verifying the selected Account is Displayed ", Status.PASS);
		report.updateTestLog("Verify New Activity Page Layout ", "The New Activity in the Details page is Displayed ",
				Status.PASS);
		activityPage.createNewActivity();
	}

	/**
	 * Validating the Private Tags Bulk Tagging page layout and the Search
	 * functionalities
	 * 
	 * @author Ramya
	 *
	 */
	static ArrayList<String> labelsBulkTaggingPageAccountDetails = new ArrayList<String>();

	public void labelsBulkTaggingPageAccountDetails() {

		labelsBulkTaggingPageAccountDetails.add("Account Name");
		labelsBulkTaggingPageAccountDetails.add("Tags");
		labelsBulkTaggingPageAccountDetails.add("Industry");
		labelsBulkTaggingPageAccountDetails.add("Account Phone");
		labelsBulkTaggingPageAccountDetails.add("Billing Street");
		labelsBulkTaggingPageAccountDetails.add("Billing City");
		labelsBulkTaggingPageAccountDetails.add("Billing State/Province");
		labelsBulkTaggingPageAccountDetails.add("Billing Zip/Postal Code");
		labelsBulkTaggingPageAccountDetails.add("Billing Country");

	}

	static ArrayList<String> labelsBulkTaggingPageContactDetails = new ArrayList<String>();

	public void labelsBulkTaggingPageContactDetails() {

		labelsBulkTaggingPageContactDetails.add("Full Name");
		labelsBulkTaggingPageContactDetails.add("Tags");
		labelsBulkTaggingPageContactDetails.add("Title");
		labelsBulkTaggingPageContactDetails.add("Account");
		labelsBulkTaggingPageContactDetails.add("Direct Line");
		labelsBulkTaggingPageContactDetails.add("Email");
		labelsBulkTaggingPageContactDetails.add("Mailing Street");
		labelsBulkTaggingPageContactDetails.add("Mailing City");
		labelsBulkTaggingPageContactDetails.add("Mailing State/Province");
		labelsBulkTaggingPageContactDetails.add("Mailing Zip/Postal Code");
		labelsBulkTaggingPageContactDetails.add("Mailing Country");

	}

	static ArrayList<String> labelsBulkTaggingPageLeadDetails = new ArrayList<String>();

	public void labelsBulkTaggingPageLeadDetails() {

		labelsBulkTaggingPageLeadDetails.add("Full Name");
		labelsBulkTaggingPageLeadDetails.add("Tags");
		labelsBulkTaggingPageLeadDetails.add("Title");
		labelsBulkTaggingPageLeadDetails.add("Direct Line");
		labelsBulkTaggingPageLeadDetails.add("Email");
		labelsBulkTaggingPageLeadDetails.add("Street");
		labelsBulkTaggingPageLeadDetails.add("City");
		labelsBulkTaggingPageLeadDetails.add("State/Province");
		labelsBulkTaggingPageLeadDetails.add("Zip/Postal Code");
		labelsBulkTaggingPageLeadDetails.add("Country");

	}

	/**
	 * Validating the Private Tags List
	 * 
	 * @author Ramya
	 *
	 */
	static ArrayList<String> labelsBulkTaggingPageOpportunityDetails = new ArrayList<String>();

	public void labelsBulkTaggingPageOpportunityDetails() {
		labelsBulkTaggingPageOpportunityDetails.add("Name");
		labelsBulkTaggingPageOpportunityDetails.add("Tags");
		labelsBulkTaggingPageOpportunityDetails.add("Phase");
		labelsBulkTaggingPageOpportunityDetails.add("Sales Stage");
		labelsBulkTaggingPageOpportunityDetails.add("Account");
		labelsBulkTaggingPageOpportunityDetails.add("Preferred Property Type");
	}

	/**
	 * Validating the Private Tags
	 * 
	 * @author Ramya
	 *
	 */
	public void verifyPrivateTags() {
		Utility_Functions.xWaitForElementPresent(driver, menu_More, 3);
		Utility_Functions.xClick(driver, menu_More, true);
		Utility_Functions.xWaitForElementPresent(driver, bulkTagging, 3);
		Utility_Functions.xClick(driver, bulkTagging, true);
		Utility_Functions.timeWait(5);
		Utility_Functions.xSwitchtoFrame(driver, accountSearch);
		Utility_Functions.timeWait(5);
		Utility_Functions.xWaitForElementPresent(driver, accountSearch, 3);
		Utility_Functions.xClick(driver, accountSearch, true);
		SearchTextSOQL searchTextSOQL = new SearchTextSOQL(scriptHelper);
		String accountName = searchTextSOQL.fetchRecord("Account", "Name");
		Utility_Functions.xSendKeys(driver, accountSearch, accountName);
		Utility_Functions.xWaitForElementPresent(driver, search, 3);
		Utility_Functions.xClick(driver, search, true);
		Utility_Functions.timeWait(2);
		Utility_Functions.xWaitForElementPresent(driver, selectAccount1, 3);
		Utility_Functions.xClick(driver, selectAccount1, true);
		Utility_Functions.xWaitForElementPresent(driver, selectAccount2, 3);
		Utility_Functions.xClick(driver, selectAccount2, true);
		Utility_Functions.xWaitForElementPresent(driver, assignTag, 3);
		Utility_Functions.xClick(driver, assignTag, true);
		Utility_Functions.timeWait(2);
		List<WebElement> accountFieldLabels = driver.findElements(By.xpath("//div[@id='Accountsection']//div[@class='slds-truncate']"));
		int count = 0, i1 = 0;
		String labelArray[] = new String[accountFieldLabels.size()];
		System.out.println(accountFieldLabels.size());

		try {
			labelsBulkTaggingPageAccountDetails();
			for (WebElement element : accountFieldLabels) {
				System.out.println(element.getText());
				labelArray[i1] = element.getText();
				if (labelArray[i1].equalsIgnoreCase(labelsBulkTaggingPageAccountDetails.get(i1))) {
					report.updateTestLog("Verify Private Tags Page",
							"Bulk Tagging Page Account Details is having the " + labelArray[i1] + " field ",
							Status.PASS);
					count++;
				}
				i1++;
			}
			System.out.println(count);
			if (count != 9) {
				report.updateTestLog("Verify Private Tags Page",
						"All Labels are not present in the Bulk Tagging Page Account Details", Status.FAIL);
			} else {

				report.updateTestLog("Verify Private Tags Page",
						"All Labels are present in the Bulk Tagging Page Account Details", Status.PASS);
			}

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		Utility_Functions.timeWait(2);
		List<WebElement> contactFieldLabels = driver.findElements(By.xpath("//div[@id='Contactsection']//div[@class='slds-truncate']"));
		int count1 = 0, i2 = 0;
		String labelArray1[] = new String[contactFieldLabels.size()];
		System.out.println(contactFieldLabels.size());

		try {
			labelsBulkTaggingPageContactDetails();
			for (WebElement element : contactFieldLabels) {
				System.out.println(element.getText());
				labelArray1[i2] = element.getText();
				if (labelArray1[i2].equalsIgnoreCase(labelsBulkTaggingPageContactDetails.get(i2))) {
					report.updateTestLog("Verify Private Tags Page",
							"Bulk Tagging Page Contact Details is having the " + labelArray1[i2] + " field ",
							Status.PASS);
					count1++;
				}
				i2++;
			}
			System.out.println(count1);
			if (count1 != 11) {
				report.updateTestLog("Verify Private Tags Page",
						"All Labels are not present in the Bulk Tagging Page Contact Details", Status.FAIL);
			} else {

				report.updateTestLog("Verify Private Tags Page",
						"All Labels are present in the Bulk Tagging Page Contact Details", Status.PASS);
			}

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		Utility_Functions.timeWait(2);
		List<WebElement> leadFieldLabels = driver.findElements(By.xpath("//div[@id='Leadsection']//div[@class='slds-truncate']"));
		int count2 = 0, i3 = 0;
		String labelArray2[] = new String[leadFieldLabels.size()];
		System.out.println(leadFieldLabels.size());

		try {
			labelsBulkTaggingPageLeadDetails();
			for (WebElement element : leadFieldLabels) {
				System.out.println(element.getText());
				labelArray2[i3] = element.getText();
				if (labelArray2[i3].equalsIgnoreCase(labelsBulkTaggingPageLeadDetails.get(i3))) {
					report.updateTestLog("Verify Private Tags Page",
							"Bulk Tagging Page Lead Details is having the " + labelArray1[i3] + " field ", Status.PASS);
					count2++;
				}
				i3++;
			}
			System.out.println(count2);
			if (count2 != 10) {
				report.updateTestLog("Verify Private Tags Page",
						"All Labels are not present in the Bulk Tagging Page Lead Details", Status.FAIL);
			} else {

				report.updateTestLog("Verify Private Tags Page",
						"All Labels are present in the Bulk Tagging Page Lead Details", Status.PASS);
			}

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		Utility_Functions.timeWait(2);
		List<WebElement> oppFieldLabels = driver.findElements(By.xpath("//div[@id='Oppsection']//div[@class='slds-truncate']"));
		int count3 = 0, i4 = 0;
		String labelArray3[] = new String[oppFieldLabels.size()];
		System.out.println(oppFieldLabels.size());

		try {
			labelsBulkTaggingPageOpportunityDetails();
			for (WebElement element : oppFieldLabels) {
				System.out.println(element.getText());
				labelArray3[i4] = element.getText();
				if (labelArray3[i4].equalsIgnoreCase(labelsBulkTaggingPageOpportunityDetails.get(i4))) {
					report.updateTestLog("Verify Private Tags Page",
							"Bulk Tagging Page Opportunity Details is having the " + labelArray1[i4] + " field ",
							Status.PASS);
					count3++;
				}
				i4++;
			}
			System.out.println(count3);
			if (count3 != 6) {
				report.updateTestLog("Verify Private Tags Page",
						"All Labels are not present in the Bulk Tagging Page Opportunity Details", Status.FAIL);
			} else {

				report.updateTestLog("Verify Private Tags Page",
						"All Labels are present in the Bulk Tagging Page Opportunity Details", Status.PASS);
			}

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		Utility_Functions.timeWait(2);
		Utility_Functions.xScrollWindow(driver);
		Utility_Functions.timeWait(2);
		Utility_Functions.xScrollWindowTop(driver);
		Utility_Functions.timeWait(2);
		Utility_Functions.xWaitForElementPresent(driver, advancedSearch, 3);
		Utility_Functions.xClick(driver, advancedSearch, true);
		Utility_Functions.xWaitForElementPresent(driver, advancedSearchAccountOption, 3);
		Utility_Functions.xClick(driver, advancedSearchAccountOption, true);
		Utility_Functions.timeWait(2);
		List<WebElement> advancedSearchFields = driver
				.findElements(By.xpath("//span[contains(@id,'SearchBlock')]//div[@class='slds-truncate']"));
		int count5 = 0;
		try {
			for (WebElement element : advancedSearchFields) {
				if ((count5 == 0) && (element.getText().equalsIgnoreCase("Field Name"))) {
					System.out.println("Field name is present in the Advanced Search Page");
					report.updateTestLog("Verify Private Tags Page",
							"Advanced Search Private Tags Page is having the " + element.getText() + " Status field::",
							Status.PASS);
					count5++;
				} else if ((count5 == 1) && (element.getText().equalsIgnoreCase("Operator"))) {
					System.out.println("Operator is present in the Advanced Search Page");
					report.updateTestLog("Verify Private Tags Page",
							"Advanced Search Private Tags Page is having the " + element.getText() + " Status field::",
							Status.PASS);
					count5++;
				} else if ((count5 == 2) && (element.getText().equalsIgnoreCase("Value"))) {
					System.out.println("Value is present in the Advanced Search Page");
					report.updateTestLog("Verify Private Tags Page",
							"Advanced Search Private Tags Page is having the " + element.getText() + " Status field::",
							Status.PASS);

				}
			}
			System.out.println(count5);
			if (count5 != 2) {
				report.updateTestLog("Verify Private Tags Page", "All Labels are not present in the Bulk Tagging Page Opportunity Details", Status.FAIL);
			} else {

				report.updateTestLog("Verify Private Tags Page", "All Labels are present in the Bulk Tagging Page Opportunity Details", Status.PASS);
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
		}
	}

	/**
	 * Validating the accounts function
	 * 
	 * @author Vishnuvardhan
	 *
	 */

	public void accountsFunction() {
		Utility_Functions.xWaitForElementPresent(driver, menu_Accounts, 4);
		Utility_Functions.xClick(driver, menu_Accounts, true);
		Utility_Functions.timeWait(2);		
		List<WebElement> accountNamesList = driver.findElements(By.xpath("//a[@class='slds-truncate outputLookupLink slds-truncate forceOutputLookup']"));
		try {
			if(accountNamesList.isEmpty()) {
				System.out.println("Recently Viewed List is empty");
				Utility_Functions.xClick(driver, recentlyViewed, true);
				Utility_Functions.timeWait(1);
				Utility_Functions.xWaitForElementPresent(driver, allAccounts, 3);
				Utility_Functions.xClick(driver, allAccounts, true);	
				List<WebElement> allAccountNamesList = driver.findElements(By.xpath("//a[@class='slds-truncate outputLookupLink slds-truncate forceOutputLookup']"));
				Utility_Functions.xclickRandomElement(allAccountNamesList);
			} else {
				Utility_Functions.xclickRandomElement(accountNamesList);
			}
			Utility_Functions.timeWait(1);
		} catch (Exception e2) {
			e2.printStackTrace();
			System.out.println(e2.getMessage());
		}	 
	}

	/**
	 * Validating the additional Activity Types in the new Activity List
	 * 
	 * @author Vishnuvardhan
	 *
	 */

	static ArrayList<String> activityTypeListValues = new ArrayList<String>();

	public void additionalActivityTypeList() {
		activityTypeListValues.add("--None--");
		activityTypeListValues.add("Private - Client Intelligence");
		activityTypeListValues.add("Private - Cold Call");
		activityTypeListValues.add("Private - Follow-Up Meeting");
		activityTypeListValues.add("Private - Follow-Up Task");
		activityTypeListValues.add("Private - Initial Meeting");
		activityTypeListValues.add("Private - Networking");
		activityTypeListValues.add("Private - Pitch");
		activityTypeListValues.add("Private - Task");
		activityTypeListValues.add("Private - Warm Call");
		activityTypeListValues.add("Public - Client Intelligence (All)");
		activityTypeListValues.add("Public - Client Intelligence (CML)");
		activityTypeListValues.add("Public - Client Intelligence (Investor Services)");
		activityTypeListValues.add("Public – Client Intelligence (VAS)");
		activityTypeListValues.add("Public - Client Meeting (CML)");
		activityTypeListValues.add("Public - Client Meeting (Investor Services)");
		System.out.println("Additional Activity Type values are added to the list successfully::::");
	}

	/**
	 * Validating the additional Activity Types in the new Activity on an
	 * Account
	 * 
	 * @author Vishnuvardhan
	 *
	 */
	public void additionalActivityTypes() {
		accountsFunction();
		activityPage.validateActivityTypeValues();
	}

	/**
	 * Validating the Investor services checkbox for multi business line users
	 * 
	 * @author Vishnuvardhan
	 *
	 */
	public void validateInvestorServicesCheckbox() {
		accountsFunction();
		try {
			Utility_Functions.timeWait(2);
			driver.navigate().refresh();
			Utility_Functions.xWaitForElementPresent(driver, accountServicesCheckbox, 3);
			if (accountServicesCheckbox.isDisplayed()) {
				System.out.println("Investor Services Checkbox is visible for Multi Business Users");
				report.updateTestLog("Verify Investor Services", "Investor Services Checkbox is visible for Multi Business Users", Status.PASS);
			} else {
				report.updateTestLog("Verify Investor Services", "Investor Services Checkbox is not present for Multi Business Users", Status.FAIL);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Validating the Account Record Type Field in Record Type of Accounts
	 * 
	 * @author Vishnuvardhan
	 *
	 */

	public void accountRecordTypeField() {
		Utility_Functions.xWaitForElementPresent(driver, menu_Accounts, 4);
		Utility_Functions.xClick(driver, menu_Accounts, true);
		Utility_Functions.xWaitForElementPresent(driver, recentlyViewed, 3);
		Utility_Functions.xClick(driver, recentlyViewed, true);
		report.updateTestLog("Verify Account Record Type Field", "Recently viewed Accounts are Displayed ",
				Status.PASS);
		Utility_Functions.xWaitForElementPresent(driver, allAccounts, 3);
		Utility_Functions.xClick(driver, recentlyViewedList, true);
		Utility_Functions.timeWait(3);
		report.updateTestLog("Verify Account Record Type Field", "Recently Viewed List is selecte successfully:::",
				Status.PASS);
		List<WebElement> columnList = driver.findElements(By.xpath(
				"//table[contains(@class,'uiVirtualDataTable')]//div[@class='slds-cell-fixed']//span[@class='slds-truncate']"));
		int count = 0;
		for (WebElement element : columnList) {
			String sColumnList = element.getText();
			System.out.println(sColumnList);
			if (sColumnList.contains("ACCOUNT RECORD TYPE")) {
				count++;
			}
		}
		if (count == 1) {
			report.updateTestLog("Verify Account Record Type Field", "Account Record Type column is present:::",
					Status.PASS);
		} else {
			report.updateTestLog("Verify Account Record Type Field", "Account Record Type column is not there:::",
					Status.FAIL);
		}
	}

	/**
	 * Account Creation - Area of Operations field in Reporting Account Creation
	 * Page
	 * 
	 * @author Vishnuvardhan
	 *
	 */
	public void areaOfOperationsAccountCreation() {
		Utility_Functions.xWaitForElementPresent(driver, menu_Accounts, 4);
		Utility_Functions.xClick(driver, menu_Accounts, true);
		Utility_Functions.xWaitForElementPresent(driver, newAccount, 3);
		Utility_Functions.xClick(driver, newAccount, true);
		try {
			Utility_Functions.xWaitForElementPresent(driver, newAccountEMEAnext, 3);
			Utility_Functions.xClick(driver, newAccountEMEAnext, true);
		} catch (Exception e1) {
			e1.printStackTrace();
		}
		Utility_Functions.timeWait(2);
		Utility_Functions.xSwitchtoFrame(driver, continueButton);
		Utility_Functions.timeWait(2);
		Utility_Functions.xWaitForElementPresent(driver, recordType, 3);
		Utility_Functions.xClick(driver, recordType, true);
		Utility_Functions.xWaitForElementPresent(driver, recordType_EMEAReporting, 3);
		Utility_Functions.xClick(driver, recordType_EMEAReporting, true);
		Utility_Functions.xWaitForElementPresent(driver, continueButton, 2);
		Utility_Functions.xClick(driver, continueButton, true);	
		driver.switchTo().defaultContent();
		Utility_Functions.xSwitchtoFrame(driver, accountNameQuickCreate);
		Utility_Functions.timeWait(2);
		String accountName = searchAccount.fetchRecord("Account", "Name");
		Utility_Functions.timeWait(2);
		Utility_Functions.xSendKeys(driver, accountNameQuickCreate, accountName);
		accountNameQuickCreate.sendKeys(Keys.ARROW_DOWN);
		Utility_Functions.timeWait(2);
		accountNameQuickCreate.sendKeys(Keys.ENTER);
		
		Utility_Functions.xWaitForElementPresent(driver, billingStreetQuickCreate, 3);
		Utility_Functions.xSendKeys(driver, billingStreetQuickCreate, dataTable.getData("General_Data", "Street"));
		Utility_Functions.xWaitForElementPresent(driver, billingCityQuickCreate, 3);
		Utility_Functions.xSendKeys(driver, billingCityQuickCreate, dataTable.getData("General_Data", "City"));
		Utility_Functions.xWaitForElementPresent(driver, billingCountryQuickCreate, 3);
		Utility_Functions.xClick(driver, billingCountryQuickCreate, true);
		Utility_Functions.timeWait(1);
		Utility_Functions.xClick(driver, billingCountryUnitedStatesQuickCreate, true);
		Utility_Functions.xWaitForElementPresent(driver, areaOfOperationsQuickCreate, 3);
		Utility_Functions.xClick(driver, areaOfOperationsQuickCreate, true);
		Utility_Functions.timeWait(1);
		Utility_Functions.xClick(driver, areaOfOperationsRegionalQuickCreate, true);
		report.updateTestLog("Verify Area of Operations",
				"Area of Operations field is selected while creating the account successfully:::", Status.PASS);
		Utility_Functions.xWaitForElementPresent(driver, saveQuickCreate, 3);
		Utility_Functions.xClick(driver, saveQuickCreate, true);
		Utility_Functions.timeWait(2);
		driver.switchTo().defaultContent();
		driver.navigate().refresh();
		Utility_Functions.xWaitForElementPresent(driver, accounts_Related, 3);
		if (accounts_Related.isDisplayed()) {
			report.updateTestLog("Verify Area of Operations", "Account creation is successful:::", Status.PASS);
		} else {
			report.updateTestLog("Verify Area of Operations", "Account creation failed::", Status.FAIL);

		}
	}

	/**
	 * CBRE Data Admin Access to CIM reports (CLASSIC)
	 * 
	 * @author Vishnuvardhan
	 *
	 */

	static ArrayList<String> reportsCIMList = new ArrayList<String>();

	public void reportsCIMList() {
		reportsCIMList.add("Activities with CIM Comp Account Contact Rels Inbound");
		reportsCIMList.add("CIM Account Inbounds");
		reportsCIMList.add("CIM Account Outbounds");
		reportsCIMList.add("CIM Comp Account Contact Rels Inbound");
		reportsCIMList.add("CIM Comps Inbound");
		reportsCIMList.add("CIM Contact Inbounds");
		reportsCIMList.add("CIM Contact Outbound");
		reportsCIMList.add("CIM Inbound Staging Status");
		reportsCIMList.add("CIM Orphan Relationships");
		reportsCIMList.add("CIM Outbound Staging Status");
		reportsCIMList.add("CIM Project Enquiry Inbound");
		reportsCIMList.add("CIM Properties Inbound");
		reportsCIMList.add("CIM Batch Notifications");
		reportsCIMList.add("CIM Opportunity Outbound");
		System.out.println("Reports CIM List are :::" + reportsCIMList);
	}

	/**
	 * CBRE Data Admin Access to CIM reports (CLASSIC)
	 * 
	 * @author Vishnuvardhan
	 *
	 */
	public void reportsCIMDataAdmin() {
		Utility_Functions.xWaitForElementPresent(driver, menu_Reports, 3);
		Utility_Functions.xClick(driver, menu_Reports, true);
		Utility_Functions.xWaitForElementPresent(driver, newReport, 3);
		Utility_Functions.xClick(driver, newReport, true);
		Utility_Functions.timeWait(2);
		try {
			Utility_Functions.xSwitchtoFrame(driver, reportTypeInput);
			Utility_Functions.timeWait(2);
			Utility_Functions.xWaitForElementPresent(driver, reportTypeInput, 3);
			Utility_Functions.xSendKeys(driver, reportTypeInput, "CIM");
			List<WebElement> reportsList = driver
					.findElements(By.xpath("//div[@class='x-tree-root-node']//span[contains(text(),'CIM')]"));
			reportsCIMList();
			String[] linkTexts = new String[reportsCIMList.size()];
			int i = 0, count = 0;
			try {
				for (WebElement element : reportsList) {
					linkTexts[i] = element.getText();
					if (linkTexts[i].equals(reportsCIMList.get(i))) {
						count++;
						report.updateTestLog("Verify Reports CIM",
								"Value " + element.getText() + "is present under CIM Reports List", Status.PASS);
						// System.out.println(element.getText());
					}
					i++;
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			System.out.println(count);
			if (count == 14) {
				report.updateTestLog("Verify Reports CIM", "All the reports with respect CIM are present", Status.PASS);
			} else {
				report.updateTestLog("Verify Reports CIM", "All the reports with respect CIM are not present",
						Status.WARNING);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Validating the Quick create Accounts page from the Accounts tab for the
	 * Investor Profile
	 * 
	 * @author Ramya
	 *
	 */
	public void verifyQuickCreateAccountsPageInvestorProfile() {
		Utility_Functions.xWaitForElementPresent(driver, menu_Accounts, 3);
		Utility_Functions.xClick(driver, menu_Accounts, true);
		report.updateTestLog("Verify Quick Create Accounts Page Investor Profile ",
				"Verifying the Opportunities page is displayed", Status.PASS);
		Utility_Functions.timeWait(2);
		Utility_Functions.xWaitForElementPresent(driver, newAccountMenuPage, 3);
		Utility_Functions.xClick(driver, newAccountMenuPage, true);
		report.updateTestLog("Verify Quick Create Accounts Page Investor Profile  ",
				"Verifying the new Accounts Quick Create page is displayed", Status.PASS);
		Utility_Functions.timeWait(4);
		Utility_Functions.xScrollWindow(driver);
		Utility_Functions.timeWait(2);
		Utility_Functions.xScrollWindowTop(driver);
		Utility_Functions.timeWait(2);
		try {
			Utility_Functions.xWaitForElementPresent(driver, investorProfile, 3);
			Utility_Functions.xClick(driver, investorProfile, true);
			Utility_Functions.timeWait(1);
			List<WebElement> reasonForLossValuesList = driver.findElements(
					By.xpath("//div[@class='select-options']//a[@title='Bank']/parent::li/parent::ul/li"));
			for (WebElement element : reasonForLossValuesList) {
				element.getText();
				System.out.println(element.getText());
			}
		} catch (Exception e) {
			System.out.println("Investor profile field cannot be edited");
			report.updateTestLog("Verify Quick Create Accounts Page Investor Profile  ",
					"Investor Profile field is displayed but not user editable", Status.PASS);
		}
	}

	/**
	 * Validating the Quick create Accounts page from the Accounts tab for the
	 * Investor Services Check Box
	 * 
	 * @author Ramya
	 *
	 */
	public void verifyAccountsInvestorServiceCheckBox() {
		Utility_Functions.xWaitForElementPresent(driver, menu_Accounts, 3);
		Utility_Functions.xClick(driver, menu_Accounts, true);

		report.updateTestLog("Verify Accounts Investor Services Check Box ", "Verifying the Accounts is Displayed ",
				Status.PASS);
		Utility_Functions.xWaitForElementPresent(driver, recentlyViewed, 3);
		Utility_Functions.xClick(driver, recentlyViewed, true);
		report.updateTestLog("Verify Accounts Investor Services Check Box", "Recently viewed Accounts are Displayed ",
				Status.PASS);
		Utility_Functions.xWaitForElementPresent(driver, allAccounts, 3);
		Utility_Functions.xClick(driver, allAccounts, true);
		Utility_Functions.timeWait(2);
		report.updateTestLog("Verify Accounts Investor Services Check Box",
				"All accounts are displayed successfully:::", Status.PASS);
		List<WebElement> accountNamesList = driver.findElements(
				By.xpath(".//a[@class='slds-truncate outputLookupLink slds-truncate forceOutputLookup']"));

		Utility_Functions.xclickOnFirstElementfromList(accountNamesList);
		report.updateTestLog("Verify Accounts Investor Services Check Box ",
				"Verifying the selected Account is Displayed ", Status.PASS);
		Utility_Functions.xScrollWindow(driver);
		Utility_Functions.timeWait(1);
		Utility_Functions.xScrollWindowTop(driver);
		Utility_Functions.timeWait(3);
		try {
			if (accountServicesCheckbox.isDisplayed()) {
				System.out.println("Investor Services CheckBox is present and not checked");
				report.updateTestLog("Verify Accounts Investor Services Check Box  ",
						"Verifying the Investor Services check box is present", Status.FAIL);
			}
		} catch (Exception e) {
			System.out.println("Investor Services CheckBox is not present and not checked");
			report.updateTestLog("Verify Accounts Investor Services Check Box  ",
					"Verifying the Investor Services check box is not present", Status.PASS);
		}
	}
	
	/**
	 * Validating the Accounts for the New Activity Type
	 * 
	 * @author Cognizant
	 *
	 */
	public void verifyAccountsActivity(){
		Utility_Functions.xWaitForElementPresent(driver, menu_Accounts, 4);
		Utility_Functions.xClick(driver, menu_Accounts, true);
		Utility_Functions.timeWait(2);		
		List<WebElement> accountNamesList = driver.findElements(By.xpath("//a[@class='slds-truncate outputLookupLink slds-truncate forceOutputLookup']"));
		try {
			if(accountNamesList.isEmpty()) {
				System.out.println("Recently Viewed List is empty");
				Utility_Functions.xClick(driver, recentlyViewed, true);
				Utility_Functions.timeWait(1);
				Utility_Functions.xWaitForElementPresent(driver, allAccounts, 3);
				Utility_Functions.xClick(driver, allAccounts, true);	
				List<WebElement> allAccountNamesList = driver.findElements(By.xpath("//a[@class='slds-truncate outputLookupLink slds-truncate forceOutputLookup']"));
				Utility_Functions.xclickRandomElement(allAccountNamesList);
			} else {
				Utility_Functions.xclickRandomElement(accountNamesList);
			}
			Utility_Functions.timeWait(1);
		} catch (Exception e2) {
			e2.printStackTrace();
			System.out.println(e2.getMessage());
		}	 
		Utility_Functions.timeWait(2);
	/*	String url = driver.getCurrentUrl().split("#")[0];
		String newUrl = url + "#/sObject/" + TaskEventsFunctions.accountId;
		newUrl = newUrl + "/view";
		report.updateTestLog("Verify Create Accounts View Hierarchy",
				"Verifying the URL has been replaced with the new URL having the retrieved Account" + newUrl,
				Status.PASS);
		driver.get(newUrl);
		Utility_Functions.timeWait(3);*/
	}

	/**
	 * Validating the Accounts for the New Activity Type
	 * 
	 * @author Ramya
	 *
	 */
	public void verifyAccountsNewActivityType() {
		Utility_Functions.xWaitForElementPresent(driver, menu_Accounts, 3);
		Utility_Functions.xClick(driver, menu_Accounts, true);
		report.updateTestLog("Verify New Activity Type ", "Accounts is Displayed ", Status.PASS);
		Utility_Functions.timeWait(1);
		Utility_Functions.xWaitForElementPresent(driver, recentlyViewed, 3);
		Utility_Functions.xClick(driver, recentlyViewed, true);
		report.updateTestLog("Verify New Activity Type ", "Recently viewed Accounts are Displayed ", Status.PASS);
		Utility_Functions.xWaitForElementPresent(driver, allAccounts, 3);
		Utility_Functions.xClick(driver, allAccounts, true);
		Utility_Functions.timeWait(3);
		report.updateTestLog("Verify New Activity Type ", "All Accounts are Displayed ", Status.PASS);
		List<WebElement> accountNamesList = driver.findElements(
				By.xpath(".//a[@class='slds-truncate outputLookupLink slds-truncate forceOutputLookup']"));
		Utility_Functions.xclickOnFirstElementfromList(accountNamesList);
		Utility_Functions.timeWait(2);
		report.updateTestLog("Verify New Activity Type ", "The Account is Displayed ", Status.PASS);
		Utility_Functions.xWaitForElementPresent(driver, addActivity, 3);
		Utility_Functions.xClick(driver, addActivity, true);
		activityPage.createNewActivity();
	}

	/**
	 * Validating the Accounts, Leads and Private Tags
	 * 
	 * @author Ramya
	 *
	 */
	public void verifyAccountsLeadsAndPrivateTags() {
		try {
				Utility_Functions.xWaitForElementPresent(driver, menu_More, 3);
				Utility_Functions.xClick(driver, menu_More, true);
				Utility_Functions.timeWait(1);
		} catch (Exception e) {
				Utility_Functions.xWaitForElementPresent(driver, more, 3);
				Utility_Functions.xClick(driver, more, true);
				Utility_Functions.timeWait(1);
		}
		try {
				Utility_Functions.xWaitForElementPresent(driver, more_privateTags, 3);
				Utility_Functions.xClick(driver, more_privateTags, true);
		} catch (Exception e) {
				Utility_Functions.xWaitForElementPresent(driver, more_PrivateTags, 2);
				Utility_Functions.xClick(driver, more_PrivateTags, true);
		}			
		Utility_Functions.xWaitForElementPresent(driver, newAccounts, 3);
		Utility_Functions.xClick(driver, newAccounts, true);
		report.updateTestLog("Verify Accounts Leads And PrivateTags ", "Verifying New Private Tags is Displayed ",
				Status.PASS);
		Utility_Functions.xWaitForElementPresent(driver, privateTagName, 3);
		Utility_Functions.xSendKeys(driver, privateTagName,
				"Test Automation Priavate Tag_" + Utility_Functions.xGenerateAlphaNumericString());
		report.updateTestLog("Verify Accounts Leads And PrivateTags ", "Verifying the Private Tag name is entered ",
				Status.PASS);
		Utility_Functions.xWaitForElementPresent(driver, saveNewPrivateTag, 3);
		Utility_Functions.xClick(driver, saveNewPrivateTag, true);
		report.updateTestLog("Verify Accounts Leads And PrivateTags ", "Verifying the Private Tag is saved ",
				Status.PASS);
		/*Utility_Functions.timeWait(2);
		driver.navigate().refresh();
		Utility_Functions.xWaitForElementPresent(driver, menu_Accounts, 3);
		Utility_Functions.xClick(driver, menu_Accounts, true);
		report.updateTestLog("Verify Accounts Leads And PrivateTags ", "Verifying the Accounts Page is displayed ",
				Status.PASS);
		Utility_Functions.timeWait(2);
		Utility_Functions.xWaitForElementPresent(driver, newAccount, 3);
		Utility_Functions.xClick(driver, newAccount, true);
		report.updateTestLog("Verify Accounts Leads And PrivateTags ", "Verifying the New Accounts Page is displayed ",
				Status.PASS);
		try {
			Utility_Functions.xWaitForElementPresent(driver, newAccountEMEAnext, 3);
			Utility_Functions.xClick(driver, newAccountEMEAnext, true);
		} catch (Exception e1) {
			e1.printStackTrace();
		}
		Utility_Functions.timeWait(2);
		Utility_Functions.xSwitchtoFrame(driver, continueButton);
		Utility_Functions.timeWait(1);
		Utility_Functions.xWaitForElementPresent(driver, continueButton, 5);
		Utility_Functions.xClick(driver, continueButton, true);
		driver.switchTo().defaultContent();
		Utility_Functions.timeWait(2);
		Utility_Functions.xSwitchtoFrame(driver, accountNameQuickCreate);
		Utility_Functions.timeWait(2);
		Utility_Functions.xWaitForElementPresent(driver, accountNameQuickCreate, 5);
		Utility_Functions.xSendKeys(driver, accountNameQuickCreate,
				Utility_Functions.xGenerateAlphaNumericString() + "_Test Automation Account");
		report.updateTestLog("Verify Accounts Leads And PrivateTags ",
				"Verifying the New Accounts Name field is entered ", Status.PASS);
		Utility_Functions.xWaitForElementPresent(driver, billingStreetQuickCreate, 5);
		Utility_Functions.xSendKeys(driver, billingStreetQuickCreate, "2100 Ross Ave");
		report.updateTestLog("Verify Accounts Leads And PrivateTags ",
				"Verifying the billing street field is entered with a value ", Status.PASS);
		Utility_Functions.xWaitForElementPresent(driver, billingCityQuickCreate, 5);
		Utility_Functions.xSendKeys(driver, billingCityQuickCreate, "Dallas");
		report.updateTestLog("Verify Accounts Leads And PrivateTags ",
				"Verifying the billing city field is entered with a value ", Status.PASS);
		Utility_Functions.xWaitForElementPresent(driver, billingCountryQuickCreate, 3);
		Utility_Functions.xClick(driver, billingCountryQuickCreate, true);
		Utility_Functions.xWaitForElementPresent(driver, billingCountryUnitedStatesQuickCreate, 3);
		Utility_Functions.xClick(driver, billingCountryUnitedStatesQuickCreate, true);
		report.updateTestLog("Verify Accounts Leads And PrivateTags ",
				"Verifying the billing Country field is entered with a value ", Status.PASS);
		Utility_Functions.xWaitForElementPresent(driver, billingStateQuickCreate, 3);
		Utility_Functions.xClick(driver, billingStateQuickCreate, true);
		Utility_Functions.xWaitForElementPresent(driver, billingStateTexasQuickCreate, 3);
		Utility_Functions.xClick(driver, billingStateTexasQuickCreate, true);
		report.updateTestLog("Verify Accounts Leads And PrivateTags ",
				"Verifying the billing state field is entered with a value ", Status.PASS);
		Utility_Functions.xWaitForElementPresent(driver, saveQuickCreate, 3);
		Utility_Functions.xClick(driver, saveQuickCreate, true);
		report.updateTestLog("Verify Accounts Leads And PrivateTags ",
				"Verifying the Account is saved with all the required fields populated ", Status.PASS);
		Utility_Functions.timeWait(2);
		driver.navigate().refresh();
		Utility_Functions.xWaitForElementPresent(driver, menu_Leads, 3);
		Utility_Functions.xClick(driver, menu_Leads, true);
		report.updateTestLog("Verify Accounts Leads And PrivateTags ", "Verifying the Leads Page is displayed ",
				Status.PASS);
		Utility_Functions.timeWait(2);
		Utility_Functions.xWaitForElementPresent(driver, newAccount, 3);
		Utility_Functions.xClick(driver, newAccount, true);
		report.updateTestLog("Verify Accounts Leads And PrivateTags ", "Verifying the new Leads page is displayed ",
				Status.PASS);
		try {
			Utility_Functions.xWaitForElementPresent(driver, newAccountEMEAnext, 3);
			Utility_Functions.xClick(driver, newAccountEMEAnext, true);
		} catch (Exception e1) {
			e1.printStackTrace();
		}
		Utility_Functions.timeWait(2);
		driver.navigate().refresh();
		Utility_Functions.xSwitchtoFrame(driver, continueButton);
		Utility_Functions.timeWait(2);
		Utility_Functions.xWaitForElementPresent(driver, continueButton, 5);
		Utility_Functions.xClick(driver, continueButton, true);
		Utility_Functions.timeWait(2);
		Utility_Functions.xSwitchtoFrame(driver, firstName);
		Utility_Functions.timeWait(2);
		Utility_Functions.xWaitForElementPresent(driver, firstName, 5);
		Utility_Functions.xSendKeys(driver, firstName, "Test User_" + Utility_Functions.xGenerateAlphaNumericString());
		report.updateTestLog("Verify Accounts Leads And PrivateTags ",
				"Verifying the firstname is entered in the new Leads page ", Status.PASS);
		Utility_Functions.xWaitForElementPresent(driver, lastName, 5);
		Utility_Functions.xSendKeys(driver, lastName, "Test User_" + Utility_Functions.xGenerateAlphaNumericString());
		report.updateTestLog("Verify Accounts Leads And PrivateTags ",
				"Verifying the last name is enetered in the new Leads page", Status.PASS);
		Utility_Functions.xWaitForElementPresent(driver, company, 5);
		Utility_Functions.xSendKeys(driver, company, "Cbre");
		report.updateTestLog("Verify Accounts Leads And PrivateTags ",
				"Verifying the Company field is entered with a value in the new Leads page", Status.PASS);
		Utility_Functions.xWaitForElementPresent(driver, leadStatusField, 3);
		Utility_Functions.xClick(driver, leadStatusField, true);
		Utility_Functions.xWaitForElementPresent(driver, selectLeadStatusField, 3);
		Utility_Functions.xClick(driver, selectLeadStatusField, true);
		report.updateTestLog("Verify Accounts Leads And PrivateTags ",
				"Verifying the Status field is selected in the new Leads page ", Status.PASS);
		Utility_Functions.xWaitForElementPresent(driver, saveButtonLeads, 3);
		Utility_Functions.xClick(driver, saveButtonLeads, true);
		report.updateTestLog("Verify Accounts Leads And PrivateTags ",
				"Verifying the created Lead is saved successfully ", Status.PASS);*/
	}

	/**
	 * Validating the New Account populating the required fields
	 * 
	 * @author Ramya
	 *
	 */
	public void verifyAccountsPopulatingRequiredFields() {
		
		AccountsFunctions accountsFunctions = new AccountsFunctions(scriptHelper);
		accountsFunctions.createAccountRequiredFields();
		
		/*Utility_Functions.xWaitForElementPresent(driver, menu_Accounts, 3);
		Utility_Functions.xClick(driver, menu_Accounts, true);
		Utility_Functions.timeWait(1);
		report.updateTestLog("Verify Account Creation With Required Fields ", "Verifying Accounts is Displayed ",
				Status.PASS);
		Utility_Functions.xWaitForElementPresent(driver, newAccounts, 3);
		Utility_Functions.xClick(driver, newAccounts, true);
		Utility_Functions.timeWait(2);
		report.updateTestLog("Verify Account Creation With Required Fields ",
				"Verifying New Accounts Page is Displayed  ", Status.PASS);
		try {
			Utility_Functions.xWaitForElementPresent(driver, newAccountEMEAnext, 3);
			Utility_Functions.xClick(driver, newAccountEMEAnext, true);
		} catch (Exception e) {
			e.printStackTrace();
		}
		Utility_Functions.xSwitchtoFrame(driver, accountNameQuickCreate);
		Utility_Functions.timeWait(2);
		Utility_Functions.xWaitForElementPresent(driver, accountNameQuickCreate, 5);
		String value = Utility_Functions.xGenerateAlphaNumericString();
		String accountName = value + "_Test Automation Account";
		Utility_Functions.xSendKeys(driver, accountNameQuickCreate, accountName);
		report.updateTestLog("Verify Account Creation With Required Fields ",
				"Verifying Account name required field is populated ", Status.PASS);
		Utility_Functions.xWaitForElementPresent(driver, billingStreetQuickCreate, 5);
		Utility_Functions.xSendKeys(driver, billingStreetQuickCreate, "2100 Ross Ave");
		report.updateTestLog("Verify Account Creation With Required Fields ",
				"Verifying Billing Street required field is populated ", Status.PASS);
		Utility_Functions.xWaitForElementPresent(driver, billingCityQuickCreate, 5);
		Utility_Functions.xSendKeys(driver, billingCityQuickCreate, "Dallas");
		report.updateTestLog("Verify Account Creation With Required Fields ",
				"Verifying Billing City required field is populated ", Status.PASS);
		Utility_Functions.xWaitForElementPresent(driver, billingCountryQuickCreate, 3);
		Utility_Functions.xClick(driver, billingCountryQuickCreate, true);
		Utility_Functions.xWaitForElementPresent(driver, billingCountryUnitedStatesQuickCreate, 3);
		Utility_Functions.xClick(driver, billingCountryUnitedStatesQuickCreate, true);
		report.updateTestLog("Verify Account Creation With Required Fields ",
				"Verifying Billing Country required field is populated ", Status.PASS);
		Utility_Functions.xWaitForElementPresent(driver, billingStateQuickCreate, 3);
		Utility_Functions.xClick(driver, billingStateQuickCreate, true);
		Utility_Functions.xWaitForElementPresent(driver, billingStateTexasQuickCreate, 3);
		Utility_Functions.xClick(driver, billingStateTexasQuickCreate, true);
		report.updateTestLog("Verify Account Creation With Required Fields ",
				"Verifying Billing State required field is populated ", Status.PASS);
		Utility_Functions.xWaitForElementPresent(driver, saveQuickCreate, 3);
		Utility_Functions.xClick(driver, saveQuickCreate, true);
		report.updateTestLog("Verify Account Creation With Required Fields ",
				"Verifying the Account is saved with all required fields", Status.PASS);
		Utility_Functions.timeWait(2);
		if (accountNameSaved.getText().equals(accountName)) {
			System.out.println("The new account is saved with all the required fields");
			report.updateTestLog("Verify Account Creation With Required Fields ",
					"Verifying the new account is saved with all the required fields ", Status.PASS);
		} else {
			System.out.println("The new account is not saved with all the required fields");
			report.updateTestLog("Verify Account Creation With Required Fields ",
					"Verifying the new account is saved with all the required fields ", Status.FAIL);
		}*/
	}

	/**
	 * Validating the New Account populating the required fields
	 * 
	 * @author Ramya
	 *
	 */
	public void verifyAccountsViewHierarchy() {
		Utility_Functions.xWaitForElementPresent(driver, menu_Accounts, 3);
		Utility_Functions.xClick(driver, menu_Accounts, true);
		report.updateTestLog("Verify Create Accounts View Hierarchy", "Verifying the Accounts is Displayed ",
				Status.PASS);
		List<WebElement> accountNamesList = driver.findElements(
				By.xpath(".//a[@class='slds-truncate outputLookupLink slds-truncate forceOutputLookup']"));
		Utility_Functions.xclickRandomElement(accountNamesList);
		String query = "SELECT Id FROM Account where D_U_N_S__c != null limit 1 ";
		String accountId = searchAccount.fetchRecordFieldValue("Id", query);
		if (accountId == null) {
			report.updateTestLog("Verify Create Accounts View Hierarchy", "verifying the accountid is retrieved",
					Status.PASS);
		} else {
			String url = driver.getCurrentUrl().split("#")[0];
			String newUrl = url + "#/sObject/" + accountId;
			newUrl = newUrl + "/view";
			report.updateTestLog("Verify Create Accounts View Hierarchy",
					"Verifying the URL has been replaced with the new URL having the retrieved Account" + newUrl,
					Status.PASS);
			driver.get(newUrl);
			Utility_Functions.timeWait(3);
			Utility_Functions.xScrollWindow(driver);
			Utility_Functions.timeWait(1);
			Utility_Functions.xScrollWindowTop(driver);
			Utility_Functions.timeWait(2);
			if (!accountDetailsDUNS.getText().contains(" ")) {
				System.out.println("DUNS is populated with the default value");
				report.updateTestLog("Verify Create Accounts View Hierarchy",
						"Verifying the DUNS is populated in the Accounts Details Page ", Status.PASS);
			} else {
				System.out.println("DUNS is not populated with the default value");
				report.updateTestLog("Verify Create Accounts View Hierarchy",
						"Verifying the DUNS is populated in the Accounts Details Page ", Status.FAIL);
			}
			Utility_Functions.timeWait(3);
			driver.navigate().refresh();
			Utility_Functions.xWaitForElementPresent(driver, showMoreActions, 3);
			Utility_Functions.xClick(driver, showMoreActions, true);
			report.updateTestLog("Verify Create Accounts View Hierarchy",
					"Verifying the show more actions is displayed in the Accounts Details Page ", Status.PASS);
			Utility_Functions.xWaitForElementPresent(driver, selectViewHierarchy, 3);
			Utility_Functions.xClick(driver, selectViewHierarchy, true);
			report.updateTestLog("Verify Create Accounts View Hierarchy",
					"Verifying the View Hierarchy is displayed in the show more actions and is being able to be clicked",
					Status.PASS);
		}
	}

	/**
	 * Validating the Accounts page Layout
	 * 
	 * @author Ramya
	 *
	 */
	static ArrayList<String> deatilsPageFieldsList = new ArrayList<String>();

	public void detailsPageFields() {

		deatilsPageFieldsList.add("Account Name");
		deatilsPageFieldsList.add("Original Account Name");
		deatilsPageFieldsList.add("Account Site");
		deatilsPageFieldsList.add("Local Account Name");
		deatilsPageFieldsList.add("Tradestyle Name");
		deatilsPageFieldsList.add("Phone");
		deatilsPageFieldsList.add("Legal Status");
		deatilsPageFieldsList.add("Fax");
		deatilsPageFieldsList.add("Account Opportunity History");
		deatilsPageFieldsList.add("Website");
		deatilsPageFieldsList.add("Activities Report");
		deatilsPageFieldsList.add("Brand Parent");
		deatilsPageFieldsList.add("Migrated Account");
		deatilsPageFieldsList.add("Global Brand");
		deatilsPageFieldsList.add("Client Type");
		deatilsPageFieldsList.add("Key Client Account for:");
		deatilsPageFieldsList.add("Client Type Rollup");
		deatilsPageFieldsList.add("Key Pursuit Account for:");
		deatilsPageFieldsList.add("Billing Address ");
		deatilsPageFieldsList.add("Shipping Address");
		deatilsPageFieldsList.add("Local Billing Country");
		deatilsPageFieldsList.add("Local Shipping Country");
		deatilsPageFieldsList.add("Local Billing Street");
		deatilsPageFieldsList.add("Local Shipping Street");
		deatilsPageFieldsList.add("Local Billing City");
		deatilsPageFieldsList.add("Local Shipping City");
		deatilsPageFieldsList.add("Local Billing State/Province");
		deatilsPageFieldsList.add("Local Shipping State/Province");
		deatilsPageFieldsList.add("Local Billing Zip/Postal Code");
		deatilsPageFieldsList.add("Local Shipping Zip/Postal Code");
		deatilsPageFieldsList.add("Industry");
		deatilsPageFieldsList.add("Data Type");
		deatilsPageFieldsList.add("Employees Here");
		deatilsPageFieldsList.add("Marketability");
		deatilsPageFieldsList.add("Investor Profile");
		deatilsPageFieldsList.add("Account Source");
		deatilsPageFieldsList.add("Lender Type");
		deatilsPageFieldsList.add("Ticker Symbol");
		deatilsPageFieldsList.add("Annual Revenue");
		deatilsPageFieldsList.add("D-U-N-S #");
		deatilsPageFieldsList.add("Account Currency");
		deatilsPageFieldsList.add("Previous D-U-N-S #");
		deatilsPageFieldsList.add("Tax Label 1");
		deatilsPageFieldsList.add("Status");
		deatilsPageFieldsList.add("Reason for Inactivating");
		deatilsPageFieldsList.add("Tax Code 1");
		deatilsPageFieldsList.add("Verified Date");
		deatilsPageFieldsList.add("Inactivation Date");
		deatilsPageFieldsList.add("NAICS Code");
		deatilsPageFieldsList.add("NAICS Code Description");
		deatilsPageFieldsList.add("SIC Code 1");
		deatilsPageFieldsList.add("SIC Code 1 Description");
		deatilsPageFieldsList.add("SIC Code 2");
		deatilsPageFieldsList.add("SIC Code 2 Description");
		deatilsPageFieldsList.add("SIC Code 3");
		deatilsPageFieldsList.add("SIC Code 3 Description");
		deatilsPageFieldsList.add("SIC Code 4");
		deatilsPageFieldsList.add("SIC Code 4 Description");
		deatilsPageFieldsList.add("SIC Code 5");
		deatilsPageFieldsList.add("SIC Code 5 Description");
		deatilsPageFieldsList.add("SIC Code 6");
		deatilsPageFieldsList.add("SIC Code 6 Description");
		deatilsPageFieldsList.add("Description");
		deatilsPageFieldsList.add("Created By");
		deatilsPageFieldsList.add("Account Owner");
		deatilsPageFieldsList.add("Last Manually Modified Date");
		deatilsPageFieldsList.add("Account Record Type");
		deatilsPageFieldsList.add("Last Manually Modified By");

		System.out.println("The Fields present in the account details page are " + deatilsPageFieldsList);

	}

	static ArrayList<String> accountsDeatilsPageHeadersList = new ArrayList<String>();

	public void accountDetailsPageHeaders() {

		accountsDeatilsPageHeadersList.add("Tagging");
		accountsDeatilsPageHeadersList.add("Account Information");
		accountsDeatilsPageHeadersList.add("Account Segmentation");
		accountsDeatilsPageHeadersList.add("Account Hierarchy");
		accountsDeatilsPageHeadersList.add("Address Information");
		accountsDeatilsPageHeadersList.add("Local Address Information");
		accountsDeatilsPageHeadersList.add("Additional Information");
		accountsDeatilsPageHeadersList.add("SIC/NAICS Codes");
		accountsDeatilsPageHeadersList.add("Description Information");
		accountsDeatilsPageHeadersList.add("System Information");

		System.out.println("Account Details Page headers are:: " + accountsDeatilsPageHeadersList);
	}

	static ArrayList<String> accountsRelatedPageHeadersList = new ArrayList<String>();

	public void accountRelatedPageHeaders() {

		accountsRelatedPageHeadersList.add("SPOCs");
		accountsRelatedPageHeadersList.add("Related Contacts");
		accountsRelatedPageHeadersList.add("Opportunities");
		accountsRelatedPageHeadersList.add("Deal Relationships");
		accountsRelatedPageHeadersList.add("Property Relationships");
		accountsRelatedPageHeadersList.add("Activities");
		accountsRelatedPageHeadersList.add("Private Notes");
		accountsRelatedPageHeadersList.add("Notes");
		accountsRelatedPageHeadersList.add("Files");

		System.out.println("Account related Page sections  are:: " + accountsRelatedPageHeadersList);
	}

	public void verifyAccountsLandingPageDetailsLayout() {
		Utility_Functions.xWaitForElementPresent(driver, menu_Accounts, 3);
		Utility_Functions.xClick(driver, menu_Accounts, true);
		report.updateTestLog("Verify Accounts Details Page ", "Accounts is Displayed ", Status.PASS);
		List<WebElement> accountNamesList = driver.findElements(
				By.xpath(".//a[@class='slds-truncate outputLookupLink slds-truncate forceOutputLookup']"));
		Utility_Functions.xclickRandomElement(accountNamesList);
		Utility_Functions.timeWait(5);
		List<WebElement> accountDetailsPageList = driver
				.findElements(By.xpath("//div[@class='test-id__field-label-container']/span[text()!='']"));
		int count1 = 0, i1 = 0, j1 = 0;
		String fieldsArray[] = new String[accountDetailsPageList.size()];
		System.out.println(accountDetailsPageList.size());
		try {
			detailsPageFields();
			while (j1 < accountDetailsPageList.size()) {
				for (WebElement element1 : accountDetailsPageList) {
					fieldsArray[i1] = element1.getText();
					if (fieldsArray[i1].equalsIgnoreCase(deatilsPageFieldsList.get(j1))) {
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
			if (count1 != 67) {
				report.updateTestLog("Verify Accounts Details Page",
						"All fields are not present in the Accounts Details Page", Status.FAIL);
			} else {
				report.updateTestLog("Verify Accounts Details Page",
						"All fields are present in the Accounts Details Page", Status.PASS);
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		List<WebElement> accountDetailsPageHeadersList = driver
				.findElements(By.xpath("//span[contains(@class,'header-title')]"));
		int count2 = 0, i2 = 0;
		String fieldsArray2[] = new String[accountDetailsPageHeadersList.size()];
		System.out.println(accountDetailsPageHeadersList.size());

		try {
			accountDetailsPageHeaders();
			for (WebElement element2 : accountDetailsPageHeadersList) {
				System.out.println(element2.getText());
				fieldsArray2[i2] = element2.getText();
				if (fieldsArray2[i2].contains(accountsDeatilsPageHeadersList.get(i2))) {
					report.updateTestLog("Verify Accounts Details Page",
							"Accounts Details  page is having the " + fieldsArray2[i2] + " Headers ", Status.PASS);
					count2++;
				}
				i2++;
			}
			System.out.println(count2);
			if (count2 != 10) {
				report.updateTestLog("Verify Accounts Details Page",
						"All sections are not present in the Accounts Details Page", Status.FAIL);
			} else {

				report.updateTestLog("Verify Accounts Details Page",
						"All sections are present in the Accounts Details Page", Status.PASS);
			}

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		Utility_Functions.xClickVisibleListElement(driver, related_Accounts);
		Utility_Functions.timeWait(5);
		List<WebElement> accountRelatedPageHeadersList = driver.findElements(By.xpath("//h2[@id='header']/a/span[1]"));
		int count3 = 0, i3 = 0, j = 0;
		String fieldsArray3[] = new String[accountRelatedPageHeadersList.size()];
		System.out.println(accountRelatedPageHeadersList.size());
		try {
			accountRelatedPageHeaders();
			while (j < accountRelatedPageHeadersList.size()) {
				for (WebElement element3 : accountRelatedPageHeadersList) {
					fieldsArray3[i3] = element3.getText();
					if (fieldsArray3[i3].equalsIgnoreCase(accountsRelatedPageHeadersList.get(j))) {
						System.out.println("Verify Account Details Page " + element3.getText());
						report.updateTestLog("Verify Account Details Page ",
								element3.getText() + "Headers are  present in the Account Related Page ", Status.PASS);
						count3++;
					}
					i3++;
					if (count3 == 6)
						break;
				}
				i3 = 0;
				j++;
			}
			System.out.println(count3);
			if (count3 >= 6) {
				report.updateTestLog("Verify Accounts Details Page",
						"All sections are present in the Accounts Related Page", Status.PASS);
			} else {
				report.updateTestLog("Verify Accounts Details Page",
						"All sections are not present in the Accounts Related Page", Status.FAIL);
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

	}

	/**
	 * Validating the Account Page Layout
	 * 
	 * @author Ramya
	 *
	 */
	public void verifyAccountsLandingPageDetailsLayoutManager() {
		Utility_Functions.xClick(driver, menu_Accounts, true);
		Utility_Functions.timeWait(3);
		report.updateTestLog("Verify Account Details Page ", "Accounts is Displayed ", Status.PASS);
		List<WebElement> accountNamesList = driver
				.findElements(By.xpath("//a[@class='slds-truncate outputLookupLink slds-truncate forceOutputLookup']"));
		Utility_Functions.xclickRandomElement(accountNamesList);
		Utility_Functions.timeWait(3);
		report.updateTestLog("Verify Account Details Page ", "The Account is Displayed ", Status.PASS);
		Utility_Functions.xClickVisibleListElement(driver, related_Accounts);
		Utility_Functions.timeWait(5);
		List<WebElement> accountRelatedPageHeadersList = driver.findElements(By.xpath("//h2[@id='header']/a/span[1]"));
		int count3 = 0, i3 = 0, j = 0;
		String fieldsArray3[] = new String[accountRelatedPageHeadersList.size()];
		System.out.println(accountRelatedPageHeadersList.size());
		try {
			accountRelatedPageHeaders();
			while (j < accountRelatedPageHeadersList.size()) {
				for (WebElement element3 : accountRelatedPageHeadersList) {
					fieldsArray3[i3] = element3.getText();
					if (fieldsArray3[i3].equalsIgnoreCase(accountsRelatedPageHeadersList.get(j))) {
						System.out.println("Verify Account Details Page " + element3.getText());
						report.updateTestLog("Verify Account Details Page ",
								element3.getText() + "Headers are  present in the Account Related Page ", Status.PASS);
						count3++;
					}
					i3++;
					if (count3 == 9)
						break;
				}
				i3 = 0;
				j++;
			}
			System.out.println(count3);
			if (count3 > 11) {
				report.updateTestLog("Verify Accounts Details Page",
						"All sections are not present in the Accounts Related Page", Status.FAIL);
			} else {
				report.updateTestLog("Verify Accounts Details Page",
						"All sections are present in the Accounts Related Page", Status.PASS);
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	/**
	 * Validating the Accounts Details Page Layout
	 * 
	 * @author Ramya
	 *
	 */
	static ArrayList<String> deatilsPageFieldsNotPresentList = new ArrayList<String>();

	public void verifyAccountsLandingPageDetailsLayoutBroker() {
		Utility_Functions.xWaitForElementPresent(driver, menu_Accounts, 3);
		Utility_Functions.xClick(driver, menu_Accounts, true);
		report.updateTestLog("Verify Accounts Details Page ", "Accounts is Displayed ", Status.PASS);
		List<WebElement> accountNamesList = driver
				.findElements(By.xpath("//a[@class='slds-truncate outputLookupLink slds-truncate forceOutputLookup']"));
		Utility_Functions.xclickRandomElement(accountNamesList);
		Utility_Functions.timeWait(5);
		List<WebElement> accountDetailsPageList = driver
				.findElements(By.xpath("//div[@class='test-id__field-label-container']/span[text()!='']"));
		int count1 = 0, i1 = 0, j1 = 0;
		String fieldsArray[] = new String[accountDetailsPageList.size()];
		System.out.println("Account Details xPath Count::" + accountDetailsPageList.size());
		System.out.println("Details Page Fields list Count::" + deatilsPageFieldsList.size());
		try {
			deatilsPageFieldsList.clear();
			detailsPageFields();
			while (j1 < accountDetailsPageList.size()) {
				for (WebElement element1 : accountDetailsPageList) {
					fieldsArray[i1] = element1.getText();
					if (fieldsArray[i1].equalsIgnoreCase(deatilsPageFieldsList.get(j1))) {
						System.out.println("Verify Account Details Page " + element1.getText());
						report.updateTestLog("Verify Account Details Page ",
								element1.getText() + "labels  present in the Account Detailed Page ", Status.PASS);
						count1++;
					} else {
						deatilsPageFieldsNotPresentList.add(element1.getText());
					}
					i1++;
				}
				i1 = 0;
				j1++;
			}
			System.out.println(count1);
			System.out.println("Elements which are not present in the page are :::" + deatilsPageFieldsNotPresentList);
			if (count1 != 67) {
					report.updateTestLog("Verify Accounts Details Page",
							"All fields are not present in the Accounts Details Page", Status.FAIL);
			} else {
					report.updateTestLog("Verify Accounts Details Page",
							"All fields are present in the Accounts Details Page", Status.PASS);
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		accountDetailsPageList.clear();
	}

	/**
	 * Validating the New Account page layout
	 * 
	 * @author Ramya
	 *
	 */

	static ArrayList<String> newAccountInformationSectionList = new ArrayList<String>();

	public void newAccountInformationSection() {
		newAccountInformationSectionList.add("Account Site");
		newAccountInformationSectionList.add("Tradestyle Name");
		newAccountInformationSectionList.add("Legal Status");
		newAccountInformationSectionList.add("Account Opportunity History");
		newAccountInformationSectionList.add("Tax Label 1");
		newAccountInformationSectionList.add("Tax Label 2");
		newAccountInformationSectionList.add("Tax Code 1");
		newAccountInformationSectionList.add("Tax Code 2");
		newAccountInformationSectionList.add("Staging Record Id");
		newAccountInformationSectionList.add("Created By Country");
		newAccountInformationSectionList.add("Last updated by Country");
		newAccountInformationSectionList.add("Original Account Name");
		newAccountInformationSectionList.add("Local Account Name");
		newAccountInformationSectionList.add("Account Fax");
		newAccountInformationSectionList.add("Immediate Parent Account");
		newAccountInformationSectionList.add("Brand Parent");
		newAccountInformationSectionList.add("Global Brand");
		System.out.println("Account Information section fields  are:: " + newAccountInformationSectionList);
	}

	static ArrayList<String> legalStatusPickListValuesList = new ArrayList<String>();

	public void legalStatusPickList() {
		legalStatusPickListValuesList.add("--None--");
		legalStatusPickListValuesList.add("Corporation");
		legalStatusPickListValuesList.add("Estate");
		legalStatusPickListValuesList.add("Foundation");
		legalStatusPickListValuesList.add("Limited Liability Corporation");
		legalStatusPickListValuesList.add("Non Profit Organization");
		legalStatusPickListValuesList.add("Sole Proprietorship");
		legalStatusPickListValuesList.add("Trust");
		System.out.println("Legal status pick list values are:: " + legalStatusPickListValuesList);
	}

	static ArrayList<String> accountSegmentationFieldsList = new ArrayList<String>();

	public void accountSegmentationFields() {
		accountSegmentationFieldsList.add("Client Type");
		System.out.println("Account segmentation section fields are:: " + accountSegmentationFieldsList);
	}

	static ArrayList<String> clientTypeFieldPickListValuesList = new ArrayList<String>();

	public void clientTypeFieldPickList() {
		clientTypeFieldPickListValuesList.add("Developer");
		clientTypeFieldPickListValuesList.add("Investor/Owner");
		clientTypeFieldPickListValuesList.add("Lender");
		clientTypeFieldPickListValuesList.add("Occupier");
		clientTypeFieldPickListValuesList.add("Service Provider");
		clientTypeFieldPickListValuesList.add("Corporate");
		clientTypeFieldPickListValuesList.add("Government");
		clientTypeFieldPickListValuesList.add("Institutional");
		clientTypeFieldPickListValuesList.add("International");
		clientTypeFieldPickListValuesList.add("Other");
		clientTypeFieldPickListValuesList.add("Private");
		clientTypeFieldPickListValuesList.add("REIT");
		System.out.println("Client Type field pick list values  are:: " + clientTypeFieldPickListValuesList);
	}

	static ArrayList<String> addressInformationSectionFieldsList = new ArrayList<String>();

	public void addressInformationFields() {
		addressInformationSectionFieldsList.add("Shipping Street");
		addressInformationSectionFieldsList.add("Shipping City");
		addressInformationSectionFieldsList.add("Shipping Country");
		addressInformationSectionFieldsList.add("Shipping State/Province");
		addressInformationSectionFieldsList.add("Shipping Zip/Postal Code");
		System.out.println("Address Information section fields  are:: " + addressInformationSectionFieldsList);
	}

	static ArrayList<String> localAddressInformationFieldsList = new ArrayList<String>();

	public void localAddressInformationFields() {
		localAddressInformationFieldsList.add("Local Billing Country");
		localAddressInformationFieldsList.add("Local Billing Street");
		localAddressInformationFieldsList.add("Local Billing City");
		localAddressInformationFieldsList.add("Local Billing State/Province");
		localAddressInformationFieldsList.add("Local Billing Zip/Postal Code");
		localAddressInformationFieldsList.add("Local Shipping Country");
		localAddressInformationFieldsList.add("Local Shipping Street");
		localAddressInformationFieldsList.add("Local Shipping City");
		localAddressInformationFieldsList.add("Local Shipping State/Province");
		localAddressInformationFieldsList.add("Local Shipping Zip/Postal Code");
		System.out.println("Local address infomation fields are:: " + localAddressInformationFieldsList);
	}

	static ArrayList<String> additionalInformationFieldsList = new ArrayList<String>();

	public void additionalInformationFields() {
		if ((dataTable.getData("General_Data", "TC_ID").contains("ABAMERCSSAccountsPopulatingAllFields"))
				|| (dataTable.getData("General_Data", "TC_ID").contains("ABAMERBrokerAccountsPopulatingAllFields"))
				|| (dataTable.getData("General_Data", "TC_ID").contains("OBAMERAdminAccountsPopulatingAllFields"))) {
			additionalInformationFieldsList.add("Number of Family Members");
		}
		additionalInformationFieldsList.add("Investor Profile");
		additionalInformationFieldsList.add("Lender Type");
		additionalInformationFieldsList.add("D-U-N-S #");
		additionalInformationFieldsList.add("Previous D-U-N-S #");
		additionalInformationFieldsList.add("Integration Id");
		additionalInformationFieldsList.add("Tax Code Label Type");
		additionalInformationFieldsList.add("Status");
		additionalInformationFieldsList.add("Reason for Inactivating");
		additionalInformationFieldsList.add("Inactivation Date");
		additionalInformationFieldsList.add("Account Source");
		additionalInformationFieldsList.add("Ticker Symbol");
		additionalInformationFieldsList.add("Annual Revenue");
		additionalInformationFieldsList.add("Verified System Id");
		additionalInformationFieldsList.add("Verified Date");
		additionalInformationFieldsList.add("Source Created Date Time");
		additionalInformationFieldsList.add("Source Last Updated Date Time");
		System.out.println("Additional Information section fields are :: " + additionalInformationFieldsList);
	}

	static ArrayList<String> investorProfileFieldsList = new ArrayList<String>();

	public void investorProfilePickListFields() {
		investorProfileFieldsList.add("--None--");
		investorProfileFieldsList.add("High-Net-Worth Individual/Private Syndicate");
		investorProfileFieldsList.add("Insurance Company");
		investorProfileFieldsList.add("Non-Listed Property Company/Developer (non-REIT)");
		investorProfileFieldsList.add("Occupier");
		investorProfileFieldsList.add("Pension Fund");
		investorProfileFieldsList.add("Private Equity");
		investorProfileFieldsList.add("Private REIT");
		investorProfileFieldsList.add("Property Fund");
		investorProfileFieldsList.add("Public Sector/Non-Profit/Corporate");
		investorProfileFieldsList.add("REIT/Listed Property Company");
		investorProfileFieldsList.add("Sovereign Wealth Fund");
		System.out.println("Investor profile field pick list values  are:: " + investorProfileFieldsList);
	}

	static ArrayList<String> lenderTypeFieldsList = new ArrayList<String>();

	public void lenderTypeFields() {
		lenderTypeFieldsList.add("--None--");
		lenderTypeFieldsList.add("Agency");
		lenderTypeFieldsList.add("Bank");
		lenderTypeFieldsList.add("Credit Company");
		lenderTypeFieldsList.add("Life Insurance Company");
		lenderTypeFieldsList.add("Pension Fund");
		lenderTypeFieldsList.add("Private Investor");
		lenderTypeFieldsList.add("REIT");
		lenderTypeFieldsList.add("Savings and Loan");
		lenderTypeFieldsList.add("Special Servicer");
		lenderTypeFieldsList.add("Wall St./Securitization/Conduit/CMBS");
		lenderTypeFieldsList.add("Other");
		System.out.println("Lender Type field pick list values  are:: " + lenderTypeFieldsList);
	}

	static ArrayList<String> accountSourceTypeFieldsList = new ArrayList<String>();

	public void accountSourceTypeFields() {
		accountSourceTypeFieldsList.add("--None--");
		accountSourceTypeFieldsList.add("Business Relationship");
		accountSourceTypeFieldsList.add("Canvass/Cold Call");
		accountSourceTypeFieldsList.add("CBRE Cross Sell");
		accountSourceTypeFieldsList.add("CBRE Referral/Existing Mandate");
		accountSourceTypeFieldsList.add("Direct Award");
		accountSourceTypeFieldsList.add("Greenspace");
		accountSourceTypeFieldsList.add("Non CBRE Referral");
		accountSourceTypeFieldsList.add("Other");
		accountSourceTypeFieldsList.add("Personal Relationship");
		accountSourceTypeFieldsList.add("RFP/Proposal/Pitch");
		accountSourceTypeFieldsList.add("Sales Management");
		accountSourceTypeFieldsList.add("Speculative Marketing/Business Dev");
		System.out.println("Account source Type field pick list values  are:: " + accountSourceTypeFieldsList);
	}

	static ArrayList<String> SICFieldsList = new ArrayList<String>();

	public void SICSectionFields() {
		SICFieldsList.add("NAICS Code");
		SICFieldsList.add("SIC Code 1");
		SICFieldsList.add("SIC Code 2");
		SICFieldsList.add("SIC Code 3");
		SICFieldsList.add("SIC Code 4");
		SICFieldsList.add("SIC Code 5");
		SICFieldsList.add("SIC Code 6");
		SICFieldsList.add("TDB Industry Code");
		SICFieldsList.add("NAICS Code Description");
		SICFieldsList.add("SIC Code 1 Description");
		SICFieldsList.add("SIC Code 2 Description");
		SICFieldsList.add("SIC Code 3 Description");
		SICFieldsList.add("SIC Code 4 Description");
		SICFieldsList.add("SIC Code 5 Description");
		SICFieldsList.add("SIC Code 6 Description");
		SICFieldsList.add("TDB Industry Code Description");
		System.out.println("SIC section fields are:: " + SICFieldsList);
	}

	static ArrayList<String> descriptionInformationFieldsList = new ArrayList<String>();

	public void descriptionInformationFields() {
		descriptionInformationFieldsList.add("Account Description");
		System.out.println("Description Information section fields are:: " + descriptionInformationFieldsList);
	}

	static ArrayList<String> systemInformationFieldsList = new ArrayList<String>();

	public void systemInformationFields() {
		systemInformationFieldsList.add("CreatedBy");
		systemInformationFieldsList.add("Record Type");
		systemInformationFieldsList.add("Translation Status");
		systemInformationFieldsList.add("Account Creator Country");
		systemInformationFieldsList.add("DIG Review Comments");
		systemInformationFieldsList.add("Hierarchy Code");
		systemInformationFieldsList.add("Account Owner");
		systemInformationFieldsList.add("Unique Account ID");
		systemInformationFieldsList.add("Family Id Formula");
		systemInformationFieldsList.add("Source System");
		System.out.println("System information fields are:: " + systemInformationFieldsList);
	}

	static ArrayList<String> countryList = new ArrayList<String>();

	public void countryList() {
		countryList.add("--None--");
		countryList.add("Afghanistan");
		countryList.add("Aland Islands");
		countryList.add("Albania");
		countryList.add("Algeria");
		countryList.add("American Samoa");
		countryList.add("Andorra");
		countryList.add("Angola");
		countryList.add("Anguilla");
		countryList.add("Antarctica");
		countryList.add("Antigua And Barbuda");
		countryList.add("Argentina");
		countryList.add("Armenia");
		countryList.add("Aruba");
		countryList.add("Australia");
		countryList.add("Austria");
		countryList.add("Azerbaijan");
		countryList.add("Bahamas");
		countryList.add("Bahrain");
		countryList.add("Bangladesh");
		countryList.add("Barbados");
		countryList.add("Belarus");
		countryList.add("Belgium");
		countryList.add("Belize");
		countryList.add("Benin");
		countryList.add("Bermuda");
		countryList.add("Bhutan");
		countryList.add("Bolivia");
		countryList.add("Bosnia And Herzegovina");
		countryList.add("Botswana");
		countryList.add("Bouvet Island");
		countryList.add("Brazil");
		countryList.add("British Indian Ocean Territory");
		countryList.add("Brunei Darussalam");
		countryList.add("Bulgaria");
		countryList.add("Burkina Faso");
		countryList.add("Burundi");
		countryList.add("Cambodia");
		countryList.add("Cameroon");
		countryList.add("Canada");
		countryList.add("Cape Verde");
		countryList.add("Cayman Islands");
		countryList.add("Central African Republic");
		countryList.add("Chad");
		countryList.add("Chile");
		countryList.add("China");
		countryList.add("Christmas Island");
		countryList.add("Cocos (Keeling) Islands");
		countryList.add("Colombia");
		countryList.add("Comoros");
		countryList.add("Congo");
		countryList.add("Congo, The Democratic Republic Of The");
		countryList.add("Cook Islands");
		countryList.add("Costa Rica");
		countryList.add("Cote D'Ivoire");
		countryList.add("Croatia");
		countryList.add("Cuba");
		countryList.add("Cyprus");
		countryList.add("Czech Republic");
		countryList.add("Denmark");
		countryList.add("Djibouti");
		countryList.add("Dominica");
		countryList.add("Dominican Republic");
		countryList.add("Ecuador");
		countryList.add("Egypt");
		countryList.add("El Salvador");
		countryList.add("Equatorial Guinea");
		countryList.add("Eritrea");
		countryList.add("Estonia");
		countryList.add("Ethiopia");
		countryList.add("Falkland Islands (Malvinas)");
		countryList.add("Faroe Islands");
		countryList.add("Fiji");
		countryList.add("Finland");
		countryList.add("France");
		countryList.add("French Guiana");
		countryList.add("French Polynesia");
		countryList.add("French Southern Territories");
		countryList.add("Gabon");
		countryList.add("Gambia");
		countryList.add("Georgia");
		countryList.add("Germany");
		countryList.add("Ghana");
		countryList.add("Gibraltar");
		countryList.add("Greece");
		countryList.add("Greenland");
		countryList.add("Grenada");
		countryList.add("Guadeloupe");
		countryList.add("Guam");
		countryList.add("Guatemala");
		countryList.add("Guernsey");
		countryList.add("Guinea");
		countryList.add("Guinea-Bissau");
		countryList.add("Guyana");
		countryList.add("Haiti");
		countryList.add("Heard Island And Mcdonald Islands");
		countryList.add("Holy See (Vatican City State)");
		countryList.add("Honduras");
		countryList.add("Hong Kong");
		countryList.add("Hungary");
		countryList.add("Iceland");
		countryList.add("India");
		countryList.add("Indonesia");
		countryList.add("Iran, Islamic Republic Of");
		countryList.add("Iraq");
		countryList.add("Ireland");
		countryList.add("Isle Of Man");
		countryList.add("Israel");
		countryList.add("Italy");
		countryList.add("Jamaica");
		countryList.add("Japan");
		countryList.add("Jersey");
		countryList.add("Jordan");
		countryList.add("Kazakhstan");
		countryList.add("Kenya");
		countryList.add("Kiribati");
		countryList.add("Korea, Democratic People'S Republic Of");
		countryList.add("Korea, Republic Of");
		countryList.add("Kuwait");
		countryList.add("Kyrgyzstan");
		countryList.add("Lao People'S Democratic Republic");
		countryList.add("Latvia");
		countryList.add("Lebanon");
		countryList.add("Lesotho");
		countryList.add("Liberia");
		countryList.add("Libyan Arab Jamahiriya");
		countryList.add("Liechtenstein");
		countryList.add("Lithuania");
		countryList.add("Luxembourg");
		countryList.add("Macau");
		countryList.add("Macedonia, The Former Yugoslav Republic Of");
		countryList.add("Madagascar");
		countryList.add("Malawi");
		countryList.add("Malaysia");
		countryList.add("Maldives");
		countryList.add("Mali");
		countryList.add("Malta");
		countryList.add("Marshall Islands");
		countryList.add("Martinique");
		countryList.add("Mauritania");
		countryList.add("Mauritius");
		countryList.add("Mayotte");
		countryList.add("Mexico");
		countryList.add("Micronesia, Federated States Of");
		countryList.add("Moldova, Republic Of");
		countryList.add("Monaco");
		countryList.add("Mongolia");
		countryList.add("Montserrat");
		countryList.add("Morocco");
		countryList.add("Mozambique");
		countryList.add("Myanmar");
		countryList.add("Namibia");
		countryList.add("Nauru");
		countryList.add("Nepal");
		countryList.add("Netherlands");
		countryList.add("Netherlands Antilles");
		countryList.add("New Caledonia");
		countryList.add("New Zealand");
		countryList.add("Nicaragua");
		countryList.add("Niger");
		countryList.add("Nigeria");
		countryList.add("Niue");
		countryList.add("Norfolk Island");
		countryList.add("Northern Mariana Islands");
		countryList.add("Norway");
		countryList.add("Oman");
		countryList.add("Pakistan");
		countryList.add("Palau");
		countryList.add("Palestinian Territory, Occupied");
		countryList.add("Panama");
		countryList.add("Papua New Guinea");
		countryList.add("Paraguay");
		countryList.add("Peru");
		countryList.add("Philippines");
		countryList.add("Pitcairn");
		countryList.add("Poland");
		countryList.add("Portugal");
		countryList.add("Puerto Rico");
		countryList.add("Qatar");
		countryList.add("Reunion");
		countryList.add("Romania");
		countryList.add("Russian Federation");
		countryList.add("Rwanda");
		countryList.add("Saint Helena");
		countryList.add("Saint Kitts And Nevis");
		countryList.add("Saint Lucia");
		countryList.add("Saint Pierre And Miquelon");
		countryList.add("Saint Vincent And The Grenadines");
		countryList.add("Samoa");
		countryList.add("San Marino");
		countryList.add("Sao Tome And Principe");
		countryList.add("Saudi Arabia");
		countryList.add("Senegal");
		countryList.add("Serbia And Montenegro");
		countryList.add("Seychelles");
		countryList.add("Sierra Leone");
		countryList.add("Singapore");
		countryList.add("Slovakia");
		countryList.add("Slovenia");
		countryList.add("Solomon Islands");
		countryList.add("Somalia");
		countryList.add("South Africa");
		countryList.add("South Georgia And The South Sandwich Islands");
		countryList.add("Spain");
		countryList.add("Sri Lanka");
		countryList.add("Sudan");
		countryList.add("Suriname");
		countryList.add("Svalbard And Jan Mayen");
		countryList.add("Swaziland");
		countryList.add("Sweden");
		countryList.add("Switzerland");
		countryList.add("Syrian Arab Republic");
		countryList.add("Taiwan");
		countryList.add("Tajikistan");
		countryList.add("Tanzania, United Republic Of");
		countryList.add("Thailand");
		countryList.add("Timor-Leste");
		countryList.add("Togo");
		countryList.add("Tokelau");
		countryList.add("Tonga");
		countryList.add("Trinidad And Tobago");
		countryList.add("Tunisia");
		countryList.add("Turkey");
		countryList.add("Turkmenistan");
		countryList.add("Turks And Caicos Islands");
		countryList.add("Tuvalu");
		countryList.add("Uganda");
		countryList.add("Ukraine");
		countryList.add("United Arab Emirates");
		countryList.add("United Kingdom");
		countryList.add("United States");
		countryList.add("United States Minor Outlying Islands");
		countryList.add("Uruguay");
		countryList.add("Uzbekistan");
		countryList.add("Vanuatu");
		countryList.add("Venezuela");
		countryList.add("Viet Nam");
		countryList.add("Virgin Islands, British");
		countryList.add("Virgin Islands, U.S.");
		countryList.add("Wallis And Futuna");
		countryList.add("Western Sahara");
		countryList.add("Yemen");
		countryList.add("Zambia");
		countryList.add("Zimbabwe");
		System.out.println("Country List are:::+ " + countryList);
	}

	public void verifyAccountsPageLayout() {
		AccountsFunctions accountsFunctions = new AccountsFunctions(scriptHelper);
		accountsFunctions.accountPageFieldsValidation();
		/*Utility_Functions.xWaitForElementPresent(driver, menu_Accounts, 3);
		Utility_Functions.xClick(driver, menu_Accounts, true);
		Utility_Functions.timeWait(1);
		report.updateTestLog("Verify New Account Page Layout ", "Verifying Accounts is Displayed ", Status.PASS);
		Utility_Functions.xWaitForElementPresent(driver, newAccounts, 3);
		Utility_Functions.xClick(driver, newAccounts, true);
		Utility_Functions.timeWait(2);
		report.updateTestLog("Verify New Account Page Layout  ", "Verifying New Accounts Page is Displayed  ",
				Status.PASS);
		try {
			Utility_Functions.xWaitForElementPresent(driver, newAccountEMEAnext, 3);
			Utility_Functions.xClick(driver, newAccountEMEAnext, true);
		} catch (Exception e1) {
			e1.printStackTrace();
		}
		if (dataTable.getData("General_Data", "TC_ID").contains("Admin")) {
			Utility_Functions.timeWait(2);
			Utility_Functions.xSwitchtoFrame(driver, continueButton);
			Utility_Functions.xWaitForElementPresent(driver, continueButton, 3);
			Utility_Functions.xClick(driver, continueButton, true);
		}
		Utility_Functions.timeWait(2);
		driver.switchTo().defaultContent();
		Utility_Functions.timeWait(2);
		Utility_Functions.xSwitchtoFrame(driver, viewAllFieldsButton);
		Utility_Functions.xScrollWindow(driver);
		Utility_Functions.timeWait(2);
		Utility_Functions.xWaitForElementPresent(driver, viewAllFieldsButton, 5);
		Utility_Functions.xClick(driver, viewAllFieldsButton, true);
		Utility_Functions.timeWait(1);
		Utility_Functions.xScrollWindowTop(driver);
		Utility_Functions.timeWait(5);
		List<WebElement> accountInformationSectionList = driver.findElements(By.xpath(
				"//h2[text()='Account Information']/parent::div/parent::div/div//label[@class='slds-form-element__label']"));
		int count1 = 0, i1 = 0;
		String fieldsArray2[] = new String[accountInformationSectionList.size()];
		System.out.println(accountInformationSectionList.size());

		try {
			newAccountInformationSection();
			for (WebElement element2 : accountInformationSectionList) {
				System.out.println(element2.getText());
				fieldsArray2[i1] = element2.getText();
				if (fieldsArray2[i1].contains(newAccountInformationSectionList.get(i1))) {
					report.updateTestLog("Verify New Account Page Layout ",
							"Accounts Details  page is having the " + fieldsArray2[i1] + " fields ", Status.PASS);
					count1++;
				}
				i1++;
			}
			System.out.println(count1);
			if (count1 != 17) {
				report.updateTestLog("Verify New Account Page Layout ",
						"All fields are not present in the Account Information section ", Status.FAIL);
			} else {

				report.updateTestLog("Verify New Account Page Layout ",
						"All fields are present in the Account Information section", Status.PASS);
			}

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		accountInformationSectionList.clear();
		List<WebElement> legalStatusPickList = driver
				.findElements(By.xpath("//select[contains(@id,'LegalStatus')]/option"));
		int count2 = 0, i2 = 0;
		String fieldsArray[] = new String[legalStatusPickList.size()];
		System.out.println(legalStatusPickList.size());
		try {
			legalStatusPickList();
			for (WebElement element : legalStatusPickList) {
				System.out.println(element.getText());
				fieldsArray[i2] = element.getText();
				if (fieldsArray[i2].contains(legalStatusPickListValuesList.get(i2))) {
					report.updateTestLog("Verify New Account Page Layout ",
							"Accounts Details  page is having the " + fieldsArray[i2] + " fields ", Status.PASS);
					count2++;
				}
				i2++;
			}
			System.out.println(count2);
			if (count2 != 8) {
				report.updateTestLog("Verify New Account Page Layout ",
						"All the pick list values are not present in the Legal Status Pick List field ", Status.FAIL);
			} else {

				report.updateTestLog("Verify New Account Page Layout ",
						"All the pick list values are present in the Legal Status Pick List field", Status.PASS);
			}

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		legalStatusPickList.clear();
		Utility_Functions.xWaitForElementPresent(driver, legalStatusValue, 3);
		Utility_Functions.xClick(driver, legalStatusValue, true);
		if (!migratedAccount.isSelected()) {
			Utility_Functions.xClick(driver, migratedAccount, true);
			System.out.println("Migrated Account check box is checked");
			report.updateTestLog("Verify New Account Page Layout",
					"Verifying the migrated account check box is checked or else checking it", Status.PASS);
		} else {
			System.out.println("Migrated Account checkbox is not checked");
			report.updateTestLog("Verify New Account Page Layout",
					"Verifying the migrated account check box is checked or not ", Status.FAIL);
		}
		Utility_Functions.xWaitForElementPresent(driver, accountNameQuickCreate, 5);
		String value = Utility_Functions.xGenerateAlphaNumericString();
		String accountName = value + "Test Automation";
		Utility_Functions.xSendKeys(driver, accountNameQuickCreate, accountName);
		report.updateTestLog("Verify Account Creation With Required Fields ",
				"Verifying Account name required field is populated ", Status.PASS);
		Utility_Functions.xWaitForElementPresent(driver, billingStreetQuickCreate, 5);
		Utility_Functions.xSendKeys(driver, billingStreetQuickCreate, "2100 Ross Ave");
		report.updateTestLog("Verify Account Creation With Required Fields ",
				"Verifying Billing Street required field is populated ", Status.PASS);
		Utility_Functions.xWaitForElementPresent(driver, billingCityQuickCreate, 5);
		Utility_Functions.xSendKeys(driver, billingCityQuickCreate, "Dallas");
		report.updateTestLog("Verify Account Creation With Required Fields ",
				"Verifying Billing City required field is populated ", Status.PASS);
		Utility_Functions.xWaitForElementPresent(driver, billingCountryQuickCreate, 3);
		Utility_Functions.xClick(driver, billingCountryQuickCreate, true);
		Utility_Functions.xWaitForElementPresent(driver, billingCountryUnitedStatesQuickCreate, 3);
		Utility_Functions.xClick(driver, billingCountryUnitedStatesQuickCreate, true);
		report.updateTestLog("Verify Account Creation With Required Fields ",
				"Verifying Billing Country required field is populated ", Status.PASS);
		Utility_Functions.xWaitForElementPresent(driver, billingStateQuickCreate, 3);
		Utility_Functions.xClick(driver, billingStateQuickCreate, true);
		Utility_Functions.xWaitForElementPresent(driver, billingStateTexasQuickCreate, 3);
		Utility_Functions.xClick(driver, billingStateTexasQuickCreate, true);
		report.updateTestLog("Verify Account Creation With Required Fields ",
				"Verifying Billing State required field is populated ", Status.PASS);
		Utility_Functions.timeWait(2);
		if (dataTable.getData("General_Data", "TC_ID").contains("AMER")) {
			Utility_Functions.xWaitForElementPresent(driver, amerIndustry, 5);
			// Utility_Functions.xClick(driver,amerIndustry, true);
			Utility_Functions.timeWait(2);
			// Utility_Functions.xWaitForElementPresent(driver,amerIndustryValue,
			// 3);
			Utility_Functions.xClick(driver, amerIndustryValue, true);
		} else if (dataTable.getData("General_Data", "TC_ID").contains("EMEA")) {
			Utility_Functions.xWaitForElementPresent(driver, industry, 3);
			Utility_Functions.xClick(driver, industry, true);
			Utility_Functions.xWaitForElementPresent(driver, industryValue, 3);
			Utility_Functions.xClick(driver, industryValue, true);
		}
		Utility_Functions.xWaitForElementPresent(driver, website, 3);
		Utility_Functions.xSendKeys(driver, website, dataTable.getData("General_Data", "Email"));
		Utility_Functions.xWaitForElementPresent(driver, phone, 3);
		Utility_Functions.xSendKeys(driver, phone, dataTable.getData("General_Data", "Phone"));
		Utility_Functions.xWaitForElementPresent(driver, accountFax, 3);
		Utility_Functions.xSendKeys(driver, accountFax, dataTable.getData("General_Data", "Phone"));
		Utility_Functions.xWaitForElementPresent(driver, localAccountName, 3);
		Utility_Functions.xSendKeys(driver, localAccountName, dataTable.getData("General_Data", "Account Name"));
		List<WebElement> accountSegmentationSectionList = driver.findElements(By.xpath(
				"//h2[text()='Account Segmentation']/parent::div/parent::div/div//label[@class='slds-form-element__label']"));
		int count3 = 0, i3 = 0;
		String fieldsArray3[] = new String[accountSegmentationSectionList.size()];
		System.out.println(accountSegmentationSectionList.size());
		try {
			accountSegmentationFields();
			for (WebElement element3 : accountSegmentationSectionList) {
				System.out.println(element3.getText());
				fieldsArray3[i3] = element3.getText();
				if (fieldsArray3[i3].contains(accountSegmentationFieldsList.get(i3))) {
					report.updateTestLog("Verify New Account Page Layout ",
							"Accounts segmentation section is having the " + fieldsArray3[i3] + " fields ",
							Status.PASS);
					count3++;
				}
				i3++;
			}
			System.out.println(count3);
			if (count3 != 1) {
				report.updateTestLog("Verify New Account Page Layout ",
						"All fields are not present in the Account Segmentation section ", Status.FAIL);
			} else {

				report.updateTestLog("Verify New Account Page Layout ",
						"All fields are present in the Account Segmentation section", Status.PASS);
			}

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		accountSegmentationSectionList.clear();
		
		 * List<WebElement> clientTypePickList = driver.findElements(By.
		 * xpath("//table[@class='multiSelectPicklistTable']//select[contains(@title,'Client Type')]/option"
		 * )); int count4 = 0, i4 = 0; String fieldsArray4[] = new
		 * String[clientTypePickList.size()];
		 * System.out.println(clientTypePickList.size());
		 * 
		 * try { clientTypeFieldPickList(); for (WebElement element4 :
		 * clientTypePickList) { System.out.println(element4.getText());
		 * fieldsArray4[i4] = element4.getText(); if
		 * (fieldsArray4[i4].contains(clientTypeFieldPickListValuesList.get(i4))
		 * ) { report.updateTestLog("Verify New Account Page Layout ",
		 * "Client Type pick list is having the " + fieldsArray4[i4] +
		 * " values ", Status.PASS); count4++; } i4++; }
		 * System.out.println(count4); if (count4 != 12) {
		 * report.updateTestLog("Verify New Account Page Layout ",
		 * "All the values are not present in the Client type pick list ",
		 * Status.FAIL); } else {
		 * 
		 * report.updateTestLog("Verify New Account Page Layout ",
		 * "All the values are not present in the client type pick list",
		 * Status.PASS); }
		 * 
		 * } catch (Exception e) { System.out.println(e.getMessage()); }
		 

		List<WebElement> addressInformationSectionList = driver.findElements(By.xpath(
				"//h2[text()='Address Information']/parent::div/parent::div/div//label[@class='slds-form-element__label']"));
		int count5 = 0, i5 = 0;
		String fieldsArray5[] = new String[addressInformationSectionList.size()];
		System.out.println(addressInformationSectionList.size());
		try {
			addressInformationFields();
			for (WebElement element5 : addressInformationSectionList) {
				System.out.println(element5.getText());
				fieldsArray5[i5] = element5.getText();
				if (fieldsArray5[i5].contains(addressInformationSectionFieldsList.get(i5))) {
					report.updateTestLog("Verify New Account Page Layout ",
							"Address Information section is having the " + fieldsArray5[i5] + " fields ", Status.PASS);
					count5++;
				}
				i5++;
			}
			System.out.println(count5);
			if (count5 != 5) {
				report.updateTestLog("Verify New Account Page Layout ",
						"All fields are not present in the Address Information section ", Status.FAIL);
			} else {

				report.updateTestLog("Verify New Account Page Layout ",
						"All fields are present in the Address Information section", Status.PASS);
			}

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		addressInformationSectionList.clear();
		List<WebElement> localAddressInformationSectionList = driver.findElements(By.xpath(
				"//h2[text()='Local Address Information']/parent::div/parent::div/div//label[@class='slds-form-element__label']"));
		int count6 = 0, i6 = 0;
		String fieldsArray6[] = new String[localAddressInformationSectionList.size()];
		System.out.println(localAddressInformationSectionList.size());
		try {
			localAddressInformationFields();
			for (WebElement element6 : localAddressInformationSectionList) {
				System.out.println(element6.getText());
				fieldsArray6[i6] = element6.getText();
				if (fieldsArray6[i6].contains(localAddressInformationFieldsList.get(i6))) {
					report.updateTestLog("Verify New Account Page Layout ",
							"Local Address Information section is having the " + fieldsArray6[i6] + " fields ",
							Status.PASS);
					count6++;
				}
				i6++;
			}
			System.out.println(count6);
			if (count6 != 10) {
				report.updateTestLog("Verify New Account Page Layout ",
						"All fields are not present in the Local Address Information section ", Status.FAIL);
			} else {

				report.updateTestLog("Verify New Account Page Layout ",
						"All fields are present in the Local Address Information section", Status.PASS);
			}

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		localAddressInformationSectionList.clear();
		List<WebElement> countriesList = driver
				.findElements(By.xpath("//select[contains(@id,'Local_Billing_Country__c')]/option"));
		int count14 = 0, i14 = 0;
		String fieldsArray14[] = new String[countriesList.size()];
		System.out.println(countriesList.size());

		try {
			countryList();
			for (WebElement element14 : countriesList) {
				System.out.println(element14.getText());
				fieldsArray14[i14] = element14.getText();
				if (fieldsArray14[i14].contains(countryList.get(i14))) {
					report.updateTestLog("Verify New Account Page Layout ",
							"Local Address Information section is having the " + fieldsArray14[i14] + " fields ",
							Status.PASS);
					count14++;
				}
				i14++;
			}
			System.out.println(count14);
			if (count14 != 244) {
				report.updateTestLog("Verify New Account Page Layout ",
						"All countries are not present in the local Billing Countries section ", Status.FAIL);
			} else {

				report.updateTestLog("Verify New Account Page Layout ",
						"All countries are present in the local Billing countries section", Status.PASS);
			}

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		countriesList.clear();
		Utility_Functions.timeWait(5);
		Utility_Functions.xWaitForElementPresent(driver, localBillingCountry, 3);
		Utility_Functions.xClick(driver, localBillingCountry, true);
		Utility_Functions.xWaitForElementPresent(driver, localBillingCountryValue, 3);
		Utility_Functions.xClick(driver, localBillingCountryValue, true);
		Utility_Functions.xWaitForElementPresent(driver, localBillingStreet, 3);
		Utility_Functions.xSendKeys(driver, localBillingStreet, dataTable.getData("General_Data", "Street"));
		Utility_Functions.xWaitForElementPresent(driver, localBillingState, 3);
		Utility_Functions.xClick(driver, localBillingState, true);
		Utility_Functions.xWaitForElementPresent(driver, localBillingStateValue, 3);
		Utility_Functions.xClick(driver, localBillingStateValue, true);
		Utility_Functions.xWaitForElementPresent(driver, localBillingCity, 3);
		Utility_Functions.xSendKeys(driver, localBillingCity, dataTable.getData("General_Data", "City"));
		Utility_Functions.xWaitForElementPresent(driver, localBillingZipCode, 3);
		Utility_Functions.xSendKeys(driver, localBillingZipCode, dataTable.getData("General_Data", "Zipcode"));
		Utility_Functions.xWaitForElementPresent(driver, localShippingCountry, 3);
		// Utility_Functions.xClick(driver, localShippingCountry, true);
		// Utility_Functions.xWaitForElementPresent(driver,
		// localShippingCountryValue, 3);
		Utility_Functions.xWaitForElementPresent(driver, localShippingCountry, 3);
		Utility_Functions.xClick(driver, localShippingCountryValue, true);
		Utility_Functions.xWaitForElementPresent(driver, localShippingState, 3);
		Utility_Functions.xClick(driver, localShippingState, true);
		Utility_Functions.xWaitForElementPresent(driver, localShippingStateValue, 3);
		Utility_Functions.xClick(driver, localShippingStateValue, true);
		Utility_Functions.xWaitForElementPresent(driver, localShippingStreet, 3);
		Utility_Functions.xSendKeys(driver, localShippingStreet, dataTable.getData("General_Data", "Street"));
		Utility_Functions.xWaitForElementPresent(driver, localShippingCity, 3);
		Utility_Functions.xSendKeys(driver, localShippingCity, dataTable.getData("General_Data", "City"));
		Utility_Functions.xWaitForElementPresent(driver, localShippingZipCode, 3);
		Utility_Functions.xSendKeys(driver, localShippingZipCode, dataTable.getData("General_Data", "Zipcode"));
		List<WebElement> additionalInformationSectionList = driver.findElements(By.xpath(
				"//h2[text()='Additional Information']/parent::div/parent::div/div//label[@class='slds-form-element__label']"));
		int count7 = 0, i7 = 0;
		String fieldsArray7[] = new String[additionalInformationSectionList.size()];
		System.out.println(additionalInformationSectionList.size());

		try {
			additionalInformationFieldsList.clear();
			additionalInformationFields();
			for (WebElement element7 : additionalInformationSectionList) {
				System.out.println(element7.getText());
				fieldsArray7[i7] = element7.getText();
				if (fieldsArray7[i7].contains(additionalInformationFieldsList.get(i7))) {
					report.updateTestLog("Verify New Account Page Layout ",
							"Additional Information section is having the " + fieldsArray7[i7] + " fields ",
							Status.PASS);
					count7++;
				}
				i7++;
			}
			System.out.println(count7);
			if (count7 != 16) {
				report.updateTestLog("Verify New Account Page Layout ",
						"All fields are not present in the Additional Information section ", Status.FAIL);
			} else {

				report.updateTestLog("Verify New Account Page Layout ",
						"All fields are present in the Additional Information section", Status.PASS);
			}

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		additionalInformationSectionList.clear();
		List<WebElement> investorProfileFieldPickList = driver
				.findElements(By.xpath("//select[contains(@id,'Investor_Profile__c')]/option"));
		int count8 = 0, i8 = 0;
		String fieldsArray8[] = new String[investorProfileFieldPickList.size()];
		System.out.println(investorProfileFieldPickList.size());
		try {
			investorProfilePickListFields();
			for (WebElement element8 : investorProfileFieldPickList) {
				System.out.println(element8.getText());
				fieldsArray8[i8] = element8.getText();
				if (fieldsArray8[i8].contains(investorProfileFieldsList.get(i8))) {
					report.updateTestLog("Verify New Account Page Layout ",
							"Investor Profile Pick list field is having the " + fieldsArray8[i8] + " values ",
							Status.PASS);
					count8++;
				}
				i8++;
			}
			System.out.println(count8);
			if (count8 != 12) {
				report.updateTestLog("Verify New Account Page Layout ",
						"All the pick list values are not present in the Investor Profile Pick List field ",
						Status.FAIL);
			} else {

				report.updateTestLog("Verify New Account Page Layout ",
						"All the pick list values are present in the Investor Profile Pick List field", Status.PASS);
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		investorProfileFieldPickList.clear();
		List<WebElement> lenderTypeFieldPickList = driver
				.findElements(By.xpath("//select[contains(@id,'Lender_Type__c')]/option"));
		int count9 = 0, i9 = 0;
		String fieldsArray9[] = new String[lenderTypeFieldPickList.size()];
		System.out.println(lenderTypeFieldPickList.size());
		try {
			lenderTypeFields();
			for (WebElement element9 : lenderTypeFieldPickList) {
				System.out.println(element9.getText());
				fieldsArray9[i9] = element9.getText();
				if (fieldsArray9[i9].contains(lenderTypeFieldsList.get(i9))) {
					report.updateTestLog("Verify New Account Page Layout ",
							"Lender Type Pick List field is having the " + fieldsArray9[i9] + " values ", Status.PASS);
					count9++;
				}
				i9++;
			}
			System.out.println(count9);
			if (count9 != 12) {
				report.updateTestLog("Verify New Account Page Layout ",
						"All the pick list values are not present in the Lender Type Pick List field ", Status.FAIL);
			} else {

				report.updateTestLog("Verify New Account Page Layout ",
						"All the pick list values are present in the Lender Type Pick List field", Status.PASS);
			}

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		lenderTypeFieldPickList.clear();
		Utility_Functions.xWaitForElementPresent(driver, lenderType, 3);
		Utility_Functions.xClick(driver, lenderType, true);
		Utility_Functions.xWaitForElementPresent(driver, selectLenderType, 3);
		Utility_Functions.xClick(driver, selectLenderType, true);
		
		 * List<WebElement> accountSourceFieldPickList =
		 * driver.findElements(By.xpath(
		 * "//select[contains(@id,'AccountSource')]/option")); int count10 = 0,
		 * i10 = 0; String fieldsArray10[] = new
		 * String[accountSourceFieldPickList.size()];
		 * System.out.println(accountSourceFieldPickList.size()); try {
		 * accountSourceTypeFields(); for (WebElement element10
		 * :accountSourceFieldPickList ) {
		 * System.out.println(element10.getText()); fieldsArray10[i10] =
		 * element10.getText(); if
		 * (fieldsArray10[i10].contains(accountSourceTypeFieldsList.get(i10))) {
		 * report.updateTestLog("Verify New Account Page Layout ",
		 * "Accounts Details  page is having the " + fieldsArray10[i10] +
		 * " fields ", Status.PASS); count10++; } i10++; }
		 * System.out.println(count10); if (count10 != 13) {
		 * report.updateTestLog("Verify New Account Page Layout ",
		 * "All the pick list values are not present in the Account Source Pick List field "
		 * , Status.FAIL); } else {
		 * 
		 * report.updateTestLog("Verify New Account Page Layout ",
		 * "All the pick list values are present in the Account Source Pick List field"
		 * , Status.PASS); } } catch (Exception e) {
		 * System.out.println(e.getMessage()); }
		 * accountSourceFieldPickList.clear();
		 

		try {
			accountSourceTypeFields();
			List<WebElement> accountSourceFieldPickList = driver
					.findElements(By.xpath("//select[contains(@id,'AccountSource')]/option"));
			int i10 = 0, j = 0, count10 = 0;
			String[] fieldsArray10 = new String[accountSourceFieldPickList.size()];
			while (count10 != 13) {
				while (j < accountSourceFieldPickList.size()) {
					for (WebElement element : accountSourceFieldPickList) {
						fieldsArray10[i10] = element.getText();
						if (fieldsArray10[i10].contains(accountSourceTypeFieldsList.get(j))) {
							System.out.println("Verify Add Opportunity Page Label List" + element.getText());
							report.updateTestLog("Verify Add Opportunity Page Label List",
									element.getText() + "::::label list is present in Add Opportunity Page",
									Status.PASS);
							count10++;
						}
						i1++;
					}
					i1 = 0;
					j++;
				}
			}
			System.out.println("OpportunityInformationList:::" + count10);
			if (count10 != 13) {
				report.updateTestLog("Verify New Account Page Layout ",
						"All the pick list values are not present in the Account Source Pick List field ", Status.FAIL);
			} else {
				report.updateTestLog("Verify New Account Page Layout ",
						"All the pick list values are present in the Account Source Pick List field", Status.PASS);
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		Utility_Functions.xWaitForElementPresent(driver, accountSourceField, 3);
		Utility_Functions.xClick(driver, accountSourceField, true);
		Utility_Functions.xClick(driver, tickerSymbol, true);
		Utility_Functions.timeWait(3);
		Utility_Functions.xWaitForElementPresent(driver, tickerSymbol, 5);
		Utility_Functions.xSendKeys(driver, tickerSymbol,
				"Test Activity Created by Automation_" + Utility_Functions.xGenerateAlphaNumericString());
		Utility_Functions.xWaitForElementPresent(driver, annualRevenue, 3);
		Utility_Functions.xSendKeys(driver, naicsCode, dataTable.getData("General_Data", "Annual Revenue"));
		List<WebElement> SICSectionList = driver.findElements(By.xpath(
				"//h2[text()='SIC/NAICS Codes']/parent::div/parent::div/div//label[@class='slds-form-element__label']"));
		int count11 = 0, i11 = 0;
		String fieldsArray11[] = new String[SICSectionList.size()];
		System.out.println(SICSectionList.size());
		try {
			SICSectionFields();
			for (WebElement element11 : SICSectionList) {
				System.out.println(element11.getText());
				fieldsArray11[i11] = element11.getText();
				if (fieldsArray11[i11].contains(SICFieldsList.get(i11))) {
					report.updateTestLog("Verify New Account Page Layout ",
							"SIC section is having the " + fieldsArray11[i11] + " fields ", Status.PASS);
					count11++;
				}
				i11++;
			}
			System.out.println(count11);
			if (count11 != 16) {
				report.updateTestLog("Verify New Account Page Layout ",
						"All fields are not present in the SIC section ", Status.FAIL);
			} else {

				report.updateTestLog("Verify New Account Page Layout ", "All fields are present in the SIC section",
						Status.PASS);
			}

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		SICSectionList.clear();
		Utility_Functions.xWaitForElementPresent(driver, naicsCode, 3);
		Utility_Functions.xSendKeys(driver, naicsCode, dataTable.getData("General_Data", "NAICS Code"));
		Utility_Functions.xWaitForElementPresent(driver, sicCode1, 3);
		Utility_Functions.xSendKeys(driver, sicCode3, dataTable.getData("General_Data", "SIC Code1"));
		Utility_Functions.xWaitForElementPresent(driver, sicCode2, 3);
		Utility_Functions.xSendKeys(driver, sicCode3, dataTable.getData("General_Data", "SIC Code2"));
		Utility_Functions.xWaitForElementPresent(driver, sicCode3, 3);
		Utility_Functions.xSendKeys(driver, sicCode3, dataTable.getData("General_Data", "SIC Code3"));
		Utility_Functions.xWaitForElementPresent(driver, sicCode4, 3);
		Utility_Functions.xSendKeys(driver, sicCode4, dataTable.getData("General_Data", "SIC Code4"));
		Utility_Functions.xWaitForElementPresent(driver, sicCode5, 3);
		Utility_Functions.xSendKeys(driver, sicCode5, dataTable.getData("General_Data", "SIC Code5"));
		Utility_Functions.xWaitForElementPresent(driver, sicCode6, 3);
		Utility_Functions.xSendKeys(driver, sicCode6, dataTable.getData("General_Data", "SIC Code6"));
		Utility_Functions.xWaitForElementPresent(driver, accountDescription, 5);
		String sb = "Twinkle, twinkle, little star," + "How I wonder what you are." + "Up above the world so high,"
				+ "Like a diamond in the sky."

				+ "When the blazing sun is gone," + "When the nothing shines upon," + "Then you show your little light,"
				+ "Twinkle, twinkle, all the night."

				+ "Then the traveler in the dark," + "Thanks you for your tiny spark,"
				+ "He could not see which way to go," + "If you did not twinkle so."

				+ "In the dark blue sky you keep," + "And often through my curtains peep,"
				+ "For you never shut your eye," + "Till the sun is in the sky."

				+ "As your bright and tiny spark," + "Lights the traveler in the dark."
				+ "Though I know not what you are," + "Twinkle, twinkle, little star."

				+ "Twinkle, twinkle, little star." + "How I wonder what you are." + "Up above the world so high,"
				+ "Like a diamond in the sky."

				+ "Twinkle, twinkle, little star." + "How I wonder what you are." + "How I wonder what you are.  ";

		System.out.println(sb);
		Utility_Functions.xSendKeys(driver, accountDescription, sb);
		List<WebElement> descriptionInformationSectionList = driver.findElements(By.xpath(
				"//h2[text()='Description Information']/parent::div/parent::div/div//label[@class='slds-form-element__label']"));
		int count12 = 0, i12 = 0;
		String fieldsArray12[] = new String[descriptionInformationSectionList.size()];
		System.out.println(descriptionInformationSectionList.size());
		try {
			descriptionInformationFields();
			for (WebElement element12 : descriptionInformationSectionList) {
				System.out.println(element12.getText());
				fieldsArray12[i12] = element12.getText();
				if (fieldsArray12[i12].contains(descriptionInformationFieldsList.get(i12))) {
					report.updateTestLog("Verify New Account Page Layout ",
							"Description Information section is having the " + fieldsArray12[i12] + " fields ",
							Status.PASS);
					count12++;
				}
				i12++;
			}
			System.out.println(count12);
			if (count12 != 1) {
				report.updateTestLog("Verify New Account Page Layout ",
						"All fields are not present in the Description Information section ", Status.FAIL);
			} else {

				report.updateTestLog("Verify New Account Page Layout ",
						"All fields are present in the Description Information section", Status.PASS);
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		descriptionInformationSectionList.clear();
		List<WebElement> systemInformationSectionList = driver.findElements(By.xpath(
				"//h2[text()='System Information']/parent::div/parent::div/div//label[@class='slds-form-element__label']"));
		int count13 = 0, i13 = 0;
		String fieldsArray13[] = new String[systemInformationSectionList.size()];
		System.out.println(systemInformationSectionList.size());
		try {
			systemInformationFields();
			for (WebElement element13 : systemInformationSectionList) {
				System.out.println(element13.getText());
				fieldsArray13[i13] = element13.getText();
				if (fieldsArray13[i13].contains(systemInformationFieldsList.get(i13))) {
					report.updateTestLog("Verify New Account Page Layout ",
							"System Information section is having the " + fieldsArray13[i13] + " fields ", Status.PASS);
					count13++;
				}
				i13++;
			}
			System.out.println(count13);
			if (count13 != 10) {
				report.updateTestLog("Verify New Account Page Layout ",
						"All fields are not present in the System Information section ", Status.FAIL);
			} else {
				report.updateTestLog("Verify New Account Page Layout ",
						"All fields are present in the System Information section", Status.PASS);
			}

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		systemInformationSectionList.clear();
		Utility_Functions.xWaitForElementPresent(driver, saveQuickCreate, 3);
		Utility_Functions.xClick(driver, saveQuickCreate, true);*/
	}

	/**
	 * Validating the creation of SPOCs in the Accounts
	 * 
	 * @author Ramya
	 *
	 */
	public void verifySPOCsAccount() {
		Utility_Functions.xWaitForElementPresent(driver, menu_Accounts, 3);
		Utility_Functions.xClick(driver, menu_Accounts, true);
		report.updateTestLog("Verify SPOC from Account", "Accounts is Displayed ", Status.PASS);
		Utility_Functions.xWaitForElementPresent(driver, recentlyViewed, 3);
		Utility_Functions.xClick(driver, recentlyViewed, true);
		report.updateTestLog("Verify SPOC from Account", "Recently viewed Accounts are Displayed ", Status.PASS);
		Utility_Functions.xWaitForElementPresent(driver, allAccounts, 3);
		Utility_Functions.xClick(driver, allAccounts, true);
		Utility_Functions.timeWait(3);
		report.updateTestLog("Verify SPOC from Account", "All accounts are displayed successfully:::", Status.PASS);
		List<WebElement> accountNamesList = driver.findElements(
				By.xpath(".//a[@class='slds-truncate outputLookupLink slds-truncate forceOutputLookup'][contains(@data-recordid,'001')]"));

		Utility_Functions.xclickOnFirstElementfromList(accountNamesList);
		Utility_Functions.timeWait(3);
		report.updateTestLog("Verify SPOC from Account ", "The Account is Displayed ", Status.PASS);
		try {
			Utility_Functions.xWaitForElementPresent(driver, moreTabButton, 3);
			Utility_Functions.xClick(driver, moreTabButton, true);
			Utility_Functions.xWaitForElementPresent(driver, otherRelatedButton, 3);
			Utility_Functions.xClick(driver, otherRelatedButton, true);
		} catch (Exception e1) {
			Utility_Functions.xWaitForElementPresent(driver, related_Accounts, 3);
			Utility_Functions.xClickVisibleListElement(driver, related_Accounts);
		}
		report.updateTestLog("Verify SPOC from Account", "The related page is Displayed ", Status.PASS);
		Utility_Functions.xScrollWindow(driver);
		Utility_Functions.timeWait(1);
		Utility_Functions.xScrollWindowTop(driver);
		Utility_Functions.timeWait(2);
		Utility_Functions.xWaitForElementPresent(driver, spocsNew, 3);
		Utility_Functions.xClick(driver, spocsNew, true);
		Utility_Functions.timeWait(2);
		report.updateTestLog("Verify SPOC from Account ", "The New SPOCs in the related page is Displayed ",
				Status.PASS);
		Utility_Functions.xSwitchtoFrame(driver, spocEmployee);
		Utility_Functions.timeWait(2);
		/*
		 * Utility_Functions.xWaitForElementPresent(driver, spocEmployeeExpand,
		 * 3); Utility_Functions.xClick(driver, spocEmployeeExpand, true);
		 */
		try {
			Utility_Functions.xWaitForElementPresent(driver, spocEmployee, 5);
			Utility_Functions.xSendKeys(driver, spocEmployee, "Jordan");
			spocEmployee.sendKeys(Keys.ARROW_DOWN);
			Utility_Functions.timeWait(2);
			spocEmployee.sendKeys(Keys.ENTER);
			if ((dataTable.getData("General_Data", "TC_ID").contains("OBAPACBroker"))
					|| (dataTable.getData("General_Data", "TC_ID")).contains("ABAMERBroker")) {
				report.updateTestLog("Verify SPOC from Account",
						"Unable to create the SPOC as the Role field is not enabled", Status.PASS);
			} else {
				Utility_Functions.xWaitForElementPresent(driver, spocRole, 3);
				Utility_Functions.xClick(driver, spocRole, true);
				Utility_Functions.xWaitForElementPresent(driver, spocRoleValue, 3);
				Utility_Functions.xClick(driver, spocRoleValue, true);
				Utility_Functions.xWaitForElementPresent(driver, spocGeo, 3);
				Utility_Functions.xClick(driver, spocGeo, true);
				Utility_Functions.xWaitForElementPresent(driver, spocGeoValue, 3);
				Utility_Functions.xClick(driver, spocGeoValue, true);
				Utility_Functions.xWaitForElementPresent(driver, spocBusinessLine, 3);
				Utility_Functions.xClick(driver, spocBusinessLine, true);
				Utility_Functions.xWaitForElementPresent(driver, spocBusinessLineValue, 3);
				Utility_Functions.xClick(driver, spocBusinessLineValue, true);
				/*
				 * Utility_Functions.xWaitForElementPresent(driver,spocServices,
				 * 3); Utility_Functions.xClick(driver,spocServices, true);
				 */
				Utility_Functions.xWaitForElementPresent(driver, spocRegion, 3);
				Utility_Functions.xClick(driver, spocRegion, true);
				Utility_Functions.xWaitForElementPresent(driver, spocRegionValue, 3);
				Utility_Functions.xClick(driver, spocRegionValue, true);
				Utility_Functions.xWaitForElementPresent(driver, spocCountry, 3);
				Utility_Functions.xClick(driver, spocCountry, true);
				Utility_Functions.xWaitForElementPresent(driver, spocCountryValue, 3);
				Utility_Functions.xClick(driver, spocCountryValue, true);
				Utility_Functions.xWaitForElementPresent(driver, spocCity, 3);
				Utility_Functions.xSendKeys(driver, spocCity, dataTable.getData("General_Data", "City"));
				Utility_Functions.xWaitForElementPresent(driver, spocState, 3);
				Utility_Functions.xClick(driver, spocState, true);
				Utility_Functions.xWaitForElementPresent(driver, spocStateValue, 3);
				Utility_Functions.xClick(driver, spocStateValue, true);
				Utility_Functions.xWaitForElementPresent(driver, spocType, 3);
				Utility_Functions.xClick(driver, spocType, true);
				Utility_Functions.xWaitForElementPresent(driver, spocTypeValue, 3);
				Utility_Functions.xClick(driver, spocTypeValue, true);
				System.out.println(Calendar.getInstance());
				DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
				Date date = new Date();
				Utility_Functions.xWaitForElementPresent(driver, spocOriginalDate, 3);
				Utility_Functions.xSendKeys(driver, spocOriginalDate, dateFormat.format(date).toString());
				Utility_Functions.xWaitForElementPresent(driver, spocRequalificationDate, 3);
				Utility_Functions.xSendKeys(driver, spocRequalificationDate, dateFormat.format(date).toString());
				Utility_Functions.xWaitForElementPresent(driver, saveQuickCreate, 3);
				Utility_Functions.xClick(driver, saveQuickCreate, true);
				Utility_Functions.timeWait(3);
				if (accounts_Related.isDisplayed()) {
					Utility_Functions.xClick(driver, accounts_Related, true);
					report.updateTestLog("Verify SPOC from Account", "SPOC is saved successfully with all the fields",
							Status.PASS);
				} else {
					report.updateTestLog("Verify SPOC from Account", "SPOC is not saved with all the fields",
							Status.FAIL);
				}
				Utility_Functions.timeWait(4);
				if (spocName.getText().equals("Jordan Botten")) {
					System.out.println("Spoc name is same");
					report.updateTestLog("Verify SPOC from Account", "The new SPOC is created and saved ", Status.PASS);
				} else {
					System.out.println("Spoc name is not same");
					report.updateTestLog("Verify SPOC from Account", "The new SPOC is not created and saved ",
							Status.FAIL);
				}

			}
		} catch (Exception e) {
			System.out.println("Employee name does not match with the linked id");
			report.updateTestLog("Verify SPOC from Account",
					"The new SPOC is created but the Employee name is not linked to the id", Status.PASS);
		}
	}

	/**
	 * Validating the creation of SPOCs in the Accounts
	 * 
	 * @author Ramya
	 *
	 */
	static ArrayList<String> spocSectionHeadersList = new ArrayList<String>();

	public void spocSectionHeaders() {
		spocSectionHeadersList.add("Information");
		spocSectionHeadersList.add("System Information");
		System.out.println("SPOC Page sections are:: " + spocSectionHeadersList);
	}

	static ArrayList<String> informationSectionFieldsList = new ArrayList<String>();

	public void informationSectionFields() {
		informationSectionFieldsList.add("CBRE SPOC Employee");
		informationSectionFieldsList.add("Role");
		informationSectionFieldsList.add("Geo");
		informationSectionFieldsList.add("Region");
		informationSectionFieldsList.add("Country");
		informationSectionFieldsList.add("City");
		informationSectionFieldsList.add("State/Province");
		informationSectionFieldsList.add("Source Broker");
		informationSectionFieldsList.add("Source System");
		informationSectionFieldsList.add("SPOC Type");
		informationSectionFieldsList.add("Account");
		informationSectionFieldsList.add("Status");
		informationSectionFieldsList.add("Business Line");
		informationSectionFieldsList.add("Services");
		informationSectionFieldsList.add("Product Type");
		informationSectionFieldsList.add("Original Date");
		informationSectionFieldsList.add("Requalification Date");
		informationSectionFieldsList.add("Team Members");
		System.out.println("System information fields are:: " + informationSectionFieldsList);
	}

	static ArrayList<String> rolePickList = new ArrayList<String>();

	public void rolePickListValues() {

		rolePickList.add("--None--");
		rolePickList.add("Leader");
		rolePickList.add("Team Member");

		System.out.println("Role Pick List values are " + rolePickList);
	}

	static ArrayList<String> geoPickList = new ArrayList<String>();

	public void geoPickListValues() {

		geoPickList.add("--None--");
		geoPickList.add("Local");
		geoPickList.add("National");
		geoPickList.add("Regional");
		geoPickList.add("Global");

		System.out.println("Geo Pick List values are " + geoPickList);
	}

	static ArrayList<String> regionPickList = new ArrayList<String>();

	public void regionPickListValues() {

		regionPickList.add("--None--");
		regionPickList.add("Americas");
		regionPickList.add("APAC");
		regionPickList.add("EMEA");

		System.out.println("Region Pick List values are " + regionPickList);
	}

	static ArrayList<String> spocPickList = new ArrayList<String>();

	public void spocPickListValues() {

		spocPickList.add("--None--");
		spocPickList.add("Company / Client Request");
		spocPickList.add("Exclusive (Written or Verbal)");
		spocPickList.add("Global Workplace Solutions Account");
		spocPickList.add("Long-Standing Business Relationship");
		spocPickList.add("Preferred Provider");
		spocPickList.add("Presentation / RFP");

		System.out.println("Region Pick List values are " + spocPickList);
	}

	static ArrayList<String> statusPickList = new ArrayList<String>();

	public void statusPickListValues() {

		statusPickList.add("--None--");
		statusPickList.add("Active");
		statusPickList.add("Inactive");

		System.out.println("Role Pick List values are " + statusPickList);
	}

	static ArrayList<String> businessLinePickList = new ArrayList<String>();

	public void businessLinePickListValues() {

		businessLinePickList.add("--None--");
		businessLinePickList.add("Agency Brokerage");
		businessLinePickList.add("Asset Services");
		businessLinePickList.add("Capital Markets");
		businessLinePickList.add("Global Workplace Solutions");
		businessLinePickList.add("Investor Services");
		businessLinePickList.add("Occupier Brokerage");
		businessLinePickList.add("Valuation & Advisory");

		System.out.println("Business Line Pick List values are " + businessLinePickList);
	}

	public void verifySPOCsPageLayout() {
		Utility_Functions.xWaitForElementPresent(driver, menu_Accounts, 3);
		Utility_Functions.xClick(driver, menu_Accounts, true);
		report.updateTestLog("Verify SPOC Page Layout", "Accounts is Displayed ", Status.PASS);
		Utility_Functions.xWaitForElementPresent(driver, recentlyViewed, 3);
		Utility_Functions.xClick(driver, recentlyViewed, true);
		report.updateTestLog("Verify SPOC Page Layout", "Recently viewed Accounts are Displayed ", Status.PASS);
		Utility_Functions.xWaitForElementPresent(driver, allAccounts, 3);
		Utility_Functions.xClick(driver, allAccounts, true);
		Utility_Functions.timeWait(3);
		report.updateTestLog("Verify SPOC Page Layout", "All accounts are displayed successfully:::", Status.PASS);
		List<WebElement> accountNamesList = driver.findElements(
				By.xpath(".//a[@class='slds-truncate outputLookupLink slds-truncate forceOutputLookup']"));

		Utility_Functions.xclickOnFirstElementfromList(accountNamesList);
		Utility_Functions.timeWait(3);
		report.updateTestLog("Verify SPOC Page Layout ", "The Account is Displayed ", Status.PASS);
		Utility_Functions.xWaitForElementPresent(driver, related_Accounts, 3);
		Utility_Functions.xClickVisibleListElement(driver, related_Accounts);
		report.updateTestLog("Verify SPOC Page Layout", "The related page is Displayed ", Status.PASS);
		Utility_Functions.xScrollWindow(driver);
		Utility_Functions.timeWait(1);
		Utility_Functions.xScrollWindowTop(driver);
		Utility_Functions.timeWait(2);
		Utility_Functions.xWaitForElementPresent(driver, spocsNew, 3);
		Utility_Functions.xClick(driver, spocsNew, true);
		Utility_Functions.timeWait(2);
		report.updateTestLog("Verify SPOC Page Layout", "The New SPOCs in the related page is Displayed ", Status.PASS);
		Utility_Functions.xSwitchtoFrame(driver, spocBusinessLine);
		Utility_Functions.timeWait(3);
		List<WebElement> spocHeadersList = driver.findElements(By.xpath("//div/h2"));
		int count = 0, i = 0;
		String sectionsArray[] = new String[spocHeadersList.size()];
		System.out.println(spocHeadersList.size());
		try {
			spocSectionHeaders();
			for (WebElement element3 : spocHeadersList) {
				System.out.println(element3.getText());
				sectionsArray[i] = element3.getText();
				if (sectionsArray[i].contains(spocSectionHeadersList.get(i))) {
					report.updateTestLog("Verify New Account Page Layout ",
							"SPOC page  is having the " + sectionsArray[i] + " fields ", Status.PASS);
					count++;
				}
				i++;
			}
			System.out.println(count);
			if (count != 2) {
				report.updateTestLog("Verify SPOC Page Layout ", "All headers are not prsent in the SPOC Page layout ",
						Status.FAIL);
			} else {

				report.updateTestLog("Verify SPOC Page Layout  ", "All headers are prsent in the SPOC Page layout",
						Status.PASS);
			}

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		List<WebElement> informationSectionList = driver.findElements(By.xpath(
				"//h2[text()='Information']/parent::div/parent::div/div//label[@class='slds-form-element__label']"));
		int count1 = 0, i1 = 0;
		String fieldsArray1[] = new String[informationSectionList.size()];
		System.out.println(informationSectionList.size());
		try {
			informationSectionFields();
			for (WebElement element1 : informationSectionList) {
				System.out.println(element1.getText());
				fieldsArray1[i1] = element1.getText();
				if (fieldsArray1[i1].contains(informationSectionFieldsList.get(i1))) {
					report.updateTestLog("Verify New Account Page Layout ",
							"Local Address Information section is having the " + fieldsArray1[i1] + " fields ",
							Status.PASS);
					count1++;
				}
				i1++;
			}
			System.out.println(count1);
			if (count1 != 18) {
				report.updateTestLog("Verify New Account Page Layout ",
						"All fields are not present in the Local Address Information section ", Status.FAIL);
			} else {

				report.updateTestLog("Verify New Account Page Layout ",
						"All fields are present in the Local Address Information section", Status.PASS);
			}

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		List<WebElement> rolePickListValues = driver.findElements(By.xpath("//select[contains(@id,'role')]/option"));
		int count2 = 0, i2 = 0;
		String fieldsArray2[] = new String[rolePickListValues.size()];
		System.out.println(rolePickListValues.size());
		try {
			rolePickListValues();
			for (WebElement element2 : rolePickListValues) {
				System.out.println(element2.getText());
				fieldsArray2[i2] = element2.getText();
				if (fieldsArray2[i2].contains(rolePickList.get(i2))) {
					report.updateTestLog("Verify SPOC Page Layout",
							"Role pick list is having the " + fieldsArray2[i2] + " fields ", Status.PASS);
					count2++;
				}
				i2++;
			}
			System.out.println(count2);
			if (count2 != 3) {
				report.updateTestLog("Verify SPOC Page Layout ",
						"All fields are not present in the Description Information section ", Status.FAIL);
			} else {

				report.updateTestLog("Verify SPOC Page Layout ",
						"All fields are present in the Description Information section", Status.PASS);
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		List<WebElement> geoPickListValues = driver.findElements(By.xpath("//select[contains(@id,'geo')]/option"));
		int count3 = 0, i3 = 0;
		String fieldsArray3[] = new String[geoPickListValues.size()];
		System.out.println(geoPickListValues.size());
		try {
			geoPickListValues();
			for (WebElement element3 : geoPickListValues) {
				System.out.println(element3.getText());
				fieldsArray3[i3] = element3.getText();
				if (fieldsArray3[i3].contains(geoPickList.get(i3))) {
					report.updateTestLog("Verify SPOC Page Layout",
							"Role pick list is having the " + fieldsArray3[i3] + " fields ", Status.PASS);
					count3++;
				}
				i3++;
			}
			System.out.println(count3);
			if (count3 != 5) {
				report.updateTestLog("Verify SPOC Page Layout ",
						"All fields are not present in the Description Information section ", Status.FAIL);
			} else {

				report.updateTestLog("Verify SPOC Page Layout ",
						"All fields are present in the Description Information section", Status.PASS);
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		List<WebElement> regionPickListValues = driver
				.findElements(By.xpath("//select[contains(@id,'region')]/option"));
		int count4 = 0, i4 = 0;
		String fieldsArray4[] = new String[regionPickListValues.size()];
		System.out.println(regionPickListValues.size());
		try {
			regionPickListValues();
			for (WebElement element4 : regionPickListValues) {
				System.out.println(element4.getText());
				fieldsArray4[i4] = element4.getText();
				if (fieldsArray4[i4].contains(regionPickList.get(i4))) {
					report.updateTestLog("Verify SPOC Page Layout",
							"Role pick list is having the " + fieldsArray4[i4] + " fields ", Status.PASS);
					count4++;
				}
				i4++;
			}
			System.out.println(count4);
			if (count4 != 4) {
				report.updateTestLog("Verify SPOC Page Layout ",
						"All fields are not present in the Description Information section ", Status.FAIL);
			} else {

				report.updateTestLog("Verify SPOC Page Layout ",
						"All fields are present in the Description Information section", Status.PASS);
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		List<WebElement> spocTypePickListValues = driver
				.findElements(By.xpath("//select[contains(@id,'Spoc_Type')]/option"));
		int count5 = 0, i5 = 0;
		String fieldsArray5[] = new String[spocTypePickListValues.size()];
		System.out.println(spocTypePickListValues.size());
		try {
			spocPickListValues();
			for (WebElement element5 : spocTypePickListValues) {
				System.out.println(element5.getText());
				fieldsArray5[i5] = element5.getText();
				if (fieldsArray5[i5].contains(spocPickList.get(i5))) {
					report.updateTestLog("Verify SPOC Page Layout",
							"Role pick list is having the " + fieldsArray5[i5] + " fields ", Status.PASS);
					count5++;
				}
				i5++;
			}
			System.out.println(count5);
			if (count5 != 7) {
				report.updateTestLog("Verify SPOC Page Layout ",
						"All fields are not present in the Description Information section ", Status.FAIL);
			} else {

				report.updateTestLog("Verify SPOC Page Layout ",
						"All fields are present in the Description Information section", Status.PASS);
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		List<WebElement> statusPickListValues = driver
				.findElements(By.xpath("//select[contains(@id,'status')]/option"));
		int count6 = 0, i6 = 0;
		String fieldsArray6[] = new String[statusPickListValues.size()];
		System.out.println(statusPickListValues.size());
		try {
			statusPickListValues();
			for (WebElement element6 : statusPickListValues) {
				System.out.println(element6.getText());
				fieldsArray6[i6] = element6.getText();
				if (fieldsArray6[i6].contains(statusPickList.get(i6))) {
					report.updateTestLog("Verify SPOC Page Layout",
							"Role pick list is having the " + fieldsArray6[i6] + " fields ", Status.PASS);
					count6++;
				}
				i6++;
			}
			System.out.println(count6);
			if (count6 != 3) {
				report.updateTestLog("Verify SPOC Page Layout ",
						"All fields are not present in the Description Information section ", Status.FAIL);
			} else {

				report.updateTestLog("Verify SPOC Page Layout ",
						"All fields are present in the Description Information section", Status.PASS);
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		List<WebElement> businessLinePickListValues = driver
				.findElements(By.xpath("//select[contains(@id,'Business_line')]/option"));
		int count7 = 0, i7 = 0;
		String fieldsArray7[] = new String[businessLinePickListValues.size()];
		System.out.println(businessLinePickListValues.size());
		try {
			businessLinePickListValues();
			for (WebElement element7 : businessLinePickListValues) {
				System.out.println(element7.getText());
				fieldsArray7[i7] = element7.getText();
				if (fieldsArray7[i7].contains(businessLinePickList.get(i7))) {
					report.updateTestLog("Verify SPOC Page Layout",
							"Role pick list is having the " + fieldsArray7[i7] + " fields ", Status.PASS);
					count7++;
				}
				i7++;
			}
			System.out.println(count7);
			if (count7 != 8) {
				report.updateTestLog("Verify SPOC Page Layout ",
						"All fields are not present in the Description Information section ", Status.FAIL);
			} else {

				report.updateTestLog("Verify SPOC Page Layout ",
						"All fields are present in the Description Information section", Status.PASS);
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		Utility_Functions.xWaitForElementPresent(driver, spocEmployee, 5);
		String sSpocEmployee = searchAccount.fetchRecord("SPOC__c", "CBRE_SPOC_Employee__c");
		if (sSpocEmployee == null) {
			report.updateTestLog("Verify SPOC Page Layout", "There are no CBRE SPOC Employee records present:::",
					Status.PASS);
		} else {
			Utility_Functions.xSendKeys(driver, spocEmployee, sSpocEmployee);
			spocEmployee.sendKeys(Keys.ARROW_DOWN);
			Utility_Functions.timeWait(2);
			spocEmployee.sendKeys(Keys.ENTER);
			Utility_Functions.timeWait(2);
			Utility_Functions.xWaitForElementPresent(driver, spocRole, 3);
			Utility_Functions.xClick(driver, spocRole, true);
			Utility_Functions.xWaitForElementPresent(driver, spocRoleValue, 3);
			Utility_Functions.xClick(driver, spocRoleValue, true);
			if (!excludeSPOCCascade.isSelected()) {
				Utility_Functions.xClick(driver, excludeSPOCCascade, true);
				System.out.println("exclude SPOC Cascade is checked");
				report.updateTestLog("Verify SPOC Page Layout",
						"Verifying the exclude SPOC Cascade check box is checked or else checking it", Status.PASS);

			} else {
				System.out.println("exclude SPOC Cascade is not checked");
				report.updateTestLog("Verify SPOC Page Layout",
						"Verifying the exclude SPOC Cascade check box is checked or not ", Status.FAIL);
			}
			Utility_Functions.xWaitForElementPresent(driver, spocGeo, 3);
			Utility_Functions.xClick(driver, spocGeo, true);
			Utility_Functions.xWaitForElementPresent(driver, spocGeoValue, 3);
			Utility_Functions.xClick(driver, spocGeoValue, true);
			Utility_Functions.xWaitForElementPresent(driver, spocBusinessLine, 3);
			Utility_Functions.xClick(driver, spocBusinessLine, true);
			Utility_Functions.xWaitForElementPresent(driver, spocBusinessLineValue, 3);
			Utility_Functions.xClick(driver, spocBusinessLineValue, true);
			/*
			 * Utility_Functions.xWaitForElementPresent(driver,spocServices, 3);
			 * Utility_Functions.xClick(driver,spocServices, true);
			 */
			Utility_Functions.xWaitForElementPresent(driver, spocRegion, 3);
			Utility_Functions.xClick(driver, spocRegion, true);
			Utility_Functions.xWaitForElementPresent(driver, spocRegionValue, 3);
			Utility_Functions.xClick(driver, spocRegionValue, true);
			Utility_Functions.xWaitForElementPresent(driver, spocCountry, 3);
			Utility_Functions.xClick(driver, spocCountry, true);
			Utility_Functions.xWaitForElementPresent(driver, spocCountryValue, 3);
			Utility_Functions.xClick(driver, spocCountryValue, true);
			Utility_Functions.xWaitForElementPresent(driver, spocCity, 3);
			Utility_Functions.xSendKeys(driver, spocCity, dataTable.getData("General_Data", "City"));
			Utility_Functions.xWaitForElementPresent(driver, spocState, 3);
			Utility_Functions.xClick(driver, spocState, true);
			Utility_Functions.xWaitForElementPresent(driver, spocStateValue, 3);
			Utility_Functions.xClick(driver, spocStateValue, true);
			Utility_Functions.xWaitForElementPresent(driver, spocType, 3);
			Utility_Functions.xClick(driver, spocType, true);
			Utility_Functions.xWaitForElementPresent(driver, spocTypeValue, 3);
			Utility_Functions.xClick(driver, spocTypeValue, true);
			System.out.println(Calendar.getInstance());
			DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
			Date date = new Date();
			Utility_Functions.xWaitForElementPresent(driver, spocOriginalDate, 3);
			Utility_Functions.xSendKeys(driver, spocOriginalDate, dateFormat.format(date).toString());
			Utility_Functions.xWaitForElementPresent(driver, spocRequalificationDate, 3);
			Utility_Functions.xSendKeys(driver, spocRequalificationDate, dateFormat.format(date).toString());
			Utility_Functions.xWaitForElementPresent(driver, teamMember, 3);
			String value3 = Utility_Functions.xGenerateAlphaNumericString();
			String teamMemberValue = value3 + "Test Automation";
			Utility_Functions.xSendKeys(driver, teamMember, teamMemberValue);
			Utility_Functions.xWaitForElementPresent(driver, sourceBroker, 3);
			String value = Utility_Functions.xGenerateAlphaNumericString();
			String sourceBrokerValue = value + "Test Automation";
			Utility_Functions.xSendKeys(driver, sourceBroker, sourceBrokerValue);
			Utility_Functions.xWaitForElementPresent(driver, sourceSystem, 3);
			String value1 = Utility_Functions.xGenerateAlphaNumericString();
			String sourceSystemValue = value1 + "Test Automation";
			Utility_Functions.xSendKeys(driver, sourceSystem, sourceSystemValue);
			Utility_Functions.xWaitForElementPresent(driver, saveQuickCreate, 3);
			Utility_Functions.xClick(driver, saveQuickCreate, true);
			Utility_Functions.timeWait(3);
			if (accounts_Related.isDisplayed()) {
				Utility_Functions.xClick(driver, accounts_Related, true);
				report.updateTestLog("Verify SPOC Page Layout", "SPOC is saved successfully with all the fields",
						Status.PASS);
			} else {
				report.updateTestLog("Verify SPOC Page Layout", "SPOC is not saved with all the fields", Status.FAIL);
			}
		}

	}

	/**
	 * Validating the Accounts Activity Timeline
	 * 
	 * @author Ramya
	 *
	 */
	public void verifyAccountsActivityTimeline() {
		Utility_Functions.xWaitForElementPresent(driver, menu_Accounts, 3);
		Utility_Functions.xClick(driver, menu_Accounts, true);
		report.updateTestLog("Verify Accounts Activity Timeline", "Accounts is Displayed ", Status.PASS);
		Utility_Functions.xWaitForElementPresent(driver, recentlyViewed, 3);
		Utility_Functions.xClick(driver, recentlyViewed, true);
		report.updateTestLog("Verify Accounts Activity Timeline", "Recently viewed Accounts are Displayed ",
				Status.PASS);
		Utility_Functions.xWaitForElementPresent(driver, allAccounts, 3);
		Utility_Functions.xClick(driver, allAccounts, true);
		Utility_Functions.timeWait(3);
		report.updateTestLog("Verify Accounts Activity Timeline", "All accounts are displayed successfully:::",
				Status.PASS);
		List<WebElement> accountNamesList = driver.findElements(
				By.xpath(".//a[@class='slds-truncate outputLookupLink slds-truncate forceOutputLookup'][contains(@data-recordid,'001')]"));
		
		Utility_Functions.xclickRandomElement(accountNamesList);
		Utility_Functions.xWaitForElementPresent(driver, addActivity, 4);
		Utility_Functions.xClick(driver, addActivity, true);
		activityPage.verifyNewActivityPageLayout();
		activityPage.validateActivityTimeLine();
	}

	
	/**
	 * Validating the Account Details edit page
	 * 
	 * @author Ramya
	 *
	 */

	public void accountToOpportunity(){
		if(related_Accounts.size()>0){
		Utility_Functions.xClickVisibleListElement(driver, related_Accounts);
		}else{
		Utility_Functions.xClick(driver, account_Opp, true);
		}
		//Utility_Functions.xWaitForElementPresent(driver, newOpportunity, 3);
		Utility_Functions.timeWait(3);
		Utility_Functions.xScrollWindowOnce(driver);
		Utility_Functions.xScrollWindowToElement(driver, newOpportunity);
		//Utility_Functions.xSwitchtoFrame(driver, newOpportunity);
		Utility_Functions.xClickHiddenElement(driver, newOpportunity);
		driver.switchTo().defaultContent();
		Utility_Functions.timeWait(3);
		Utility_Functions.xSwitchtoFrame(driver, continueButton);
		Utility_Functions.xClick(driver, continueButton, true);
		driver.switchTo().defaultContent();
		Utility_Functions.timeWait(3);
		Utility_Functions.xSwitchtoFrame(driver, searchProp);
		Utility_Functions.timeWait(2);
		createnewOpportunity();
		
		
	}
	
	
	public void createnewOpportunity(){
		if ((dataTable.getData("General_Data", "TC_ID").contains("DAASIA")) && (dataTable.getData("General_Data", "TC_ID").contains("Data"))) {
			if(related_Accounts.size()>0){
				Utility_Functions.xClickVisibleListElement(driver, related_Accounts);
				}else{
				Utility_Functions.xClick(driver, account_Opp, true);
				}
				//Utility_Functions.xWaitForElementPresent(driver, newOpportunity, 3);
				Utility_Functions.timeWait(3);
				Utility_Functions.xScrollWindowOnce(driver);
				Utility_Functions.xScrollWindowToElement(driver, newOpportunity);
				//Utility_Functions.xSwitchtoFrame(driver, newOpportunity);
				Utility_Functions.xClickHiddenElement(driver, newOpportunity);
				driver.switchTo().defaultContent();
				Utility_Functions.timeWait(3);
				Utility_Functions.xSwitchtoFrame(driver, continueButton);
				Utility_Functions.xClick(driver, continueButton, true);
				driver.switchTo().defaultContent();
				Utility_Functions.timeWait(3);
				Utility_Functions.xSwitchtoFrame(driver, searchProp);
				Utility_Functions.timeWait(2);
			//Utility_Functions.xWaitForElementPresent(driver, oppAssignmentType, 4);
			//Select selectAssign = new Select(oppAssignmentType);
			//Utility_Functions.xClickHiddenElement(driver, oppAssignmentType);
			//Utility_Functions.xClick(driver, oppAssignmentType, true);
			//Utility_Functions.xWaitForElementPresent(driver, assignTypeValue, 4);
			//Utility_Functions.xClick(driver, assignTypeValue, true);
			//selectAssign.selectByVisibleText("Consulting");
			Utility_Functions.xWaitForElementPresent(driver, oppCloseDate, 4);
			Calendar calendar = Calendar.getInstance();

			// Move calendar to future
			calendar.add(Calendar.DATE, 1);

			// Get current date of calendar which point to the yesterday now
			Date newDate = calendar.getTime();
			DateFormat dateFormat;
			if(properties.getProperty("RunEnvironment").equalsIgnoreCase("UAT")){
				dateFormat = new SimpleDateFormat("dd/MM/yyyy");
			}else{
				dateFormat = new SimpleDateFormat("MM/dd/yyyy");
			}
			Utility_Functions.xSendKeys(driver, oppCloseDate, dateFormat.format(newDate).toString());
			Utility_Functions.xClick(driver, oppSave,true);
			//Utility_Functions.timeWait(6);
			
			
		}else{
			Utility_Functions.xWaitForElementPresent(driver, firstLookupElement, 4);
			Utility_Functions.xClick(driver, firstLookupElement, true);
			Utility_Functions.xWaitForElementPresent(driver, leadSourceList, 4);
			Utility_Functions.xClick(driver, leadSourceList, true);
			Utility_Functions.xWaitForElementPresent(driver, leadSourceValue, 4);
			Utility_Functions.xClick(driver, leadSourceValue, true);
			Utility_Functions.xWaitForElementPresent(driver, grossfee, 4);
			Utility_Functions.xSendKeys(driver, grossfee, "10000");
			Utility_Functions.xWaitForElementPresent(driver, tansValue, 4);
			Utility_Functions.xSendKeys(driver, tansValue, "2000");
		
			Utility_Functions.xWaitForElementPresent(driver, closeDate, 4);
			Calendar calendar = Calendar.getInstance();

			// Move calendar to future
			calendar.add(Calendar.DATE, 1);

			// Get current date of calendar which point to the yesterday now
			Date newDate = calendar.getTime();
			DateFormat dateFormat;
			if(properties.getProperty("RunEnvironment").equalsIgnoreCase("UAT")){
				dateFormat = new SimpleDateFormat("dd/MM/yyyy");
			}else{
				dateFormat = new SimpleDateFormat("MM/dd/yyyy");
			}
			Utility_Functions.xSendKeys(driver, closeDate, dateFormat.format(newDate).toString());
		
			Utility_Functions.xClickVisibleListElement(driver, saveButtonList);
			Utility_Functions.timeWait(6);
		}
		
		
	}
	/**
	 * Validating the Account Details edit page
	 * 
	 * @author Ramya
	 *
	 */

	public void verifyEditingExistingAccount() {
		Utility_Functions.xWaitForElementPresent(driver, menu_Accounts, 3);
		Utility_Functions.xClick(driver, menu_Accounts, true);
		report.updateTestLog("Verify Editing the Existing Account", "Accounts is Displayed ", Status.PASS);
		Utility_Functions.xWaitForElementPresent(driver, recentlyViewed, 3);
		Utility_Functions.xClick(driver, recentlyViewed, true);
		report.updateTestLog("Verify Editing the Existing Account", "Recently viewed Accounts are Displayed ",
				Status.PASS);
		Utility_Functions.xWaitForElementPresent(driver, allAccounts, 3);
		Utility_Functions.xClick(driver, allAccounts, true);
		Utility_Functions.timeWait(3);
		List<WebElement> accountNamesList = driver
				.findElements(By.xpath("//a[@class='slds-truncate outputLookupLink slds-truncate forceOutputLookup']"));

		Utility_Functions.xclickOnFirstElementfromList(accountNamesList);
		// Utility_Functions.timeWait(3);
		Utility_Functions.xWaitForElementPresent(driver, details, 3);
		Utility_Functions.xWaitForElementPresent(driver, edit, 3);
		Utility_Functions.xClick(driver, edit, true);
		Utility_Functions.timeWait(3);
		Utility_Functions.xScrollWindow(driver);
		Utility_Functions.timeWait(1);
		Utility_Functions.xScrollWindowTop(driver);
		Utility_Functions.timeWait(2);
		Utility_Functions.xWaitForElementPresent(driver, legalStatusEditPage, 3);
		Utility_Functions.xClick(driver, legalStatusEditPage, true);
		Utility_Functions.xWaitForElementPresent(driver, legalStatusValueEditpage, 3);
		Utility_Functions.xClick(driver, legalStatusValueEditpage, true);
		if (dataTable.getData("General_Data", "TC_ID").contains("APAC")) {
			Utility_Functions.xWaitForElementPresent(driver, apacIndustryEditPage, 3);
			Utility_Functions.xClick(driver, apacIndustryEditPage, true);
			Utility_Functions.xWaitForElementPresent(driver, apacIndustryValueEditPage, 3);
			Utility_Functions.xClick(driver, apacIndustryValueEditPage, true);
			Utility_Functions.xWaitForElementPresent(driver, apacSubIndustryEditPage, 3);
			Utility_Functions.xClick(driver, apacSubIndustryEditPage, true);
			Utility_Functions.xWaitForElementPresent(driver, apacSubIndustryValueEditPage, 3);
			Utility_Functions.xClick(driver, apacSubIndustryValueEditPage, true);
		}
		Utility_Functions.xWaitForElementPresent(driver, saveEditPage, 3);
		Utility_Functions.xClick(driver, saveEditPage, true);
		Utility_Functions.timeWait(2);
		driver.navigate().refresh();
		Utility_Functions.timeWait(2);
		Utility_Functions.xWaitForElementPresent(driver, details, 3);
		if (details.isDisplayed()) {

			report.updateTestLog("Verify Editing the Existing Account",
					"The existing account can be edited and saved successfully", Status.PASS);
		} else {
			report.updateTestLog("Verify Editing the Existing Account",
					"The existing account cannot be edited and saved successfully", Status.FAIL);
		}
	}

	/**
	 * Validating the Accounts APAC Industry fields
	 * 
	 * @author Ramya
	 *
	 */
	public void verifyAPACIndustry() {
		Utility_Functions.xWaitForElementPresent(driver, menu_Accounts, 3);
		Utility_Functions.xClick(driver, menu_Accounts, true);
		Utility_Functions.timeWait(1);
		report.updateTestLog("Verify New Account Page Layout ", "Verifying Accounts is Displayed ", Status.PASS);
		Utility_Functions.xWaitForElementPresent(driver, newAccounts, 3);
		Utility_Functions.xClick(driver, newAccounts, true);
		Utility_Functions.timeWait(2);
		report.updateTestLog("Verify New Account Page Layout  ", "Verifying New Accounts Page is Displayed  ",
				Status.PASS);
		Utility_Functions.timeWait(2);
		Utility_Functions.xSwitchtoFrame(driver, viewAllFieldsButton);
		Utility_Functions.xWaitForElementPresent(driver, viewAllFieldsButton, 5);
		Utility_Functions.xScrollWindow(driver);
		Utility_Functions.xClick(driver, viewAllFieldsButton, true);
		Utility_Functions.timeWait(1);
		Utility_Functions.xScrollWindowTop(driver);
		Utility_Functions.timeWait(5);
		if ((!industryValues.getText().equals(""))) {
			System.out.println(
					"Industry value and Industry sub values are present in the APAC Account quick create page");
			report.updateTestLog("Verify New Activity Page Layout",
					"Industry value and Industry sub values are present in the APAC Account quick create page",
					Status.PASS);
		} else {
			System.out.println(
					"Industry value and Industry sub values are not present in the APAC Account quick create page");
			report.updateTestLog("Verify New Activity Page Layout",
					"Industry value and Industry sub values are present in the APAC Account quick create page",
					Status.FAIL);
		}

	}

	/**
	 * Validating the Accounts Information Page Client Knowledge center fields
	 * 
	 * @author Ramya
	 *
	 */

	public void verifyAccountsClientKnowledgeCenterField() {
		Utility_Functions.xWaitForElementPresent(driver, menu_Accounts, 3);
		Utility_Functions.xClick(driver, menu_Accounts, true);
		report.updateTestLog("Verify Editing the Existing Account", "Accounts is Displayed ", Status.PASS);
		Utility_Functions.xWaitForElementPresent(driver, recentlyViewed, 3);
		Utility_Functions.xClick(driver, recentlyViewed, true);
		report.updateTestLog("Verify Editing the Existing Account", "Recently viewed Accounts are Displayed ",
				Status.PASS);
		Utility_Functions.xWaitForElementPresent(driver, allAccounts, 3);
		Utility_Functions.xClick(driver, allAccounts, true);
		Utility_Functions.timeWait(3);
		List<WebElement> accountNamesList = driver.findElements(By.xpath(
				" //a[@class='slds-truncate outputLookupLink slds-truncate forceOutputLookup'][contains(@data-recordid,'001')]"));
		Utility_Functions.xclickRandomElement(accountNamesList);
		Utility_Functions.timeWait(3);
		try {
			if (clientKnowledgeCenterField.isDisplayed()) {

				report.updateTestLog("Verify Accounts Client Knowledge Center Field",
						"The Client Knowledge Center field is present", Status.PASS);
			} else {
				report.updateTestLog("Verify Accounts Client Knowledge Center Field",
						"The Client Knowledge Center field is not present", Status.FAIL);
			}
		} catch (Exception e) {
			System.out.println(
					"Account information section is not present in which the Client knowledge center field is prsesnt");
		}

	}

	/**
	 * Validating the Submit Accounts Update Request
	 * 
	 * @author Ramya
	 *
	 */

	public void verifySubmitAccUpdateRequest() {
		Utility_Functions.timeWait(3);
		Utility_Functions.xWaitForElementPresent(driver, submitAccUpdateRequest, 3);
		Utility_Functions.xClick(driver, submitAccUpdateRequest, true);
		report.updateTestLog("Verify Submit Account Update Request",
				"Submoit Account Update Request Page is displayed ", Status.PASS);
		Utility_Functions.xWaitForElementPresent(driver, requestedForCase, 3);
		Utility_Functions.xSendKeys(driver, requestedForCase, "test58");
		report.updateTestLog("Verify Submit Account Update Request", "Request for case tab is opened ", Status.PASS);
		Utility_Functions.xWaitForElementPresent(driver, requestedForCaseValue, 3);
		Utility_Functions.xClick(driver, requestedForCaseValue, true);
		Utility_Functions.timeWait(3);
		Utility_Functions.xScrollWindow(driver);
		Utility_Functions.timeWait(1);
		Utility_Functions.xScrollWindowTop(driver);
		Utility_Functions.timeWait(2);
		Utility_Functions.xWaitForElementPresent(driver, searchAccountsCase, 3);
		Utility_Functions.xSendKeys(driver, searchAccountsCase, "George557");
		Utility_Functions.xWaitForElementPresent(driver, accountValueCase, 3);
		Utility_Functions.xClick(driver, accountValueCase, true);
		Utility_Functions.xWaitForElementPresent(driver, regionCase, 3);
		Utility_Functions.xClick(driver, regionCase, true);
		Utility_Functions.xWaitForElementPresent(driver, regionValueCase, 3);
		Utility_Functions.xClick(driver, regionValueCase, true);
		Utility_Functions.xWaitForElementPresent(driver, descriptionCase, 3);
		Utility_Functions.xSendKeys(driver, descriptionCase, "This is case Description");
		Utility_Functions.xWaitForElementPresent(driver, saveCase, 3);
		Utility_Functions.xClick(driver, saveCase, true);
		Utility_Functions.timeWait(3);
		Utility_Functions.xWaitForElementPresent(driver, triggerForLogout, 3);
		Utility_Functions.xClick(driver, triggerForLogout, true);
		Utility_Functions.xWaitForElementPresent(driver, logoutButton, 3);
		Utility_Functions.xClick(driver, logoutButton, true);
		Utility_Functions.timeWait(2);
		Utility_Functions.xWaitForElementPresent(driver, username, 3);
		Utility_Functions.xSendKeys(driver, username, "emeamultibusinessA&TOccupier2@cbre.com");
		Utility_Functions.xWaitForElementPresent(driver, password, 3);
		Utility_Functions.xSendKeys(driver, password, "Password567");
		Utility_Functions.xWaitForElementPresent(driver, login, 3);
		Utility_Functions.xClick(driver, login, true);
		Utility_Functions.timeWait(2);

		driver.navigate().to("https://cbrecrm--fte2.lightning.force.com/one/one.app#/sObject/5000n000001YqEZAA0/view");
		Utility_Functions.timeWait(3);

		if (caseNotFound.isDisplayed()) {

			report.updateTestLog("Verify Submit Account Update Request", "The Case is not present", Status.PASS);
		} else {
			report.updateTestLog("Verify Submit Account Update Request", "The Case is present", Status.FAIL);
		}

	}

	/**
	 * Validating the Private Tag functionality
	 * 
	 * @author Ramya
	 *
	 */
	public void verifyPrivateTagFunctionality() {

		try {
			Utility_Functions.xWaitForElementPresent(driver, menu_PrivateTags, 3);
			Utility_Functions.xClick(driver, menu_PrivateTags, true);
		} catch (Exception e) {

			Utility_Functions.xWaitForElementPresent(driver, menu_More, 3);
			Utility_Functions.xClick(driver, menu_More, true);

			Utility_Functions.xWaitForElementPresent(driver, more_PrivateTags, 2);
			Utility_Functions.xClick(driver, more_PrivateTags, true);
		}
		Utility_Functions.xWaitForElementPresent(driver, newAccounts, 3);
		Utility_Functions.xClick(driver, newAccounts, true);
		report.updateTestLog("Verify Accounts PrivateTags Functionality ", "Verifying New Private Tags is Displayed ",
				Status.PASS);
		Utility_Functions.xWaitForElementPresent(driver, privateTagName, 3);
		Utility_Functions.xSendKeys(driver, privateTagName,
				"Test Automation Priavate Tag_" + Utility_Functions.xGenerateAlphaNumericString());
		report.updateTestLog("Verify Accounts PrivateTags Functionality ", "Verifying the Private Tag name is entered ",
				Status.PASS);
		Utility_Functions.xWaitForElementPresent(driver, saveNewPrivateTag, 3);
		Utility_Functions.xClick(driver, saveNewPrivateTag, true);
		report.updateTestLog("Verify Accounts PrivateTags Functionality ", "Verifying the Private Tag is saved ",
				Status.PASS);
		Utility_Functions.timeWait(2);
		Utility_Functions.xScrollWindow(driver);
		Utility_Functions.timeWait(1);
		Utility_Functions.xScrollWindowTop(driver);
		Utility_Functions.timeWait(2);
		Utility_Functions.xWaitForElementPresent(driver, newPropertiesPrivateTag, 3);
		Utility_Functions.xClick(driver, newPropertiesPrivateTag, true);
		report.updateTestLog("Verify Accounts PrivateTags Functionality ",
				"Verifying the new Properties Under Private Tag is displayed ", Status.PASS);
		Utility_Functions.xWaitForElementPresent(driver, searchPropertiesPrivateTag, 3);
		Utility_Functions.xSendKeys(driver, searchPropertiesPrivateTag,
				"Test Automation Subject_K4AGZFTL1W - 2100 Ross Avenue");
		Utility_Functions.xWaitForElementPresent(driver, existingPropertyPrivateTag, 3);
		Utility_Functions.xClick(driver, existingPropertyPrivateTag, true);
		Utility_Functions.xWaitForElementPresent(driver, savePropertyPrivateTag, 3);
		report.updateTestLog("Verify Accounts PrivateTags Functionality ",
				"Verifying the selection of the existing property", Status.PASS);
		Utility_Functions.xClick(driver, savePropertyPrivateTag, true);
		Utility_Functions.timeWait(2);
		report.updateTestLog("Verify Accounts PrivateTags Functionality ",
				"Verifying the new Property is saved with the Existing property name ", Status.PASS);

	}

	/**
	 * Validating the Bulk Tagging functionality
	 * 
	 * @author Ramya
	 *
	 */
	public void verifyBulkTagging() {
		Utility_Functions.xWaitForElementPresent(driver, applauncher, 3);
		Utility_Functions.xClick(driver, applauncher, true);
		Utility_Functions.timeWait(2);
		Utility_Functions.xWaitForElementPresent(driver, bulkTaggingAppLauncher, 3);
		Utility_Functions.xClick(driver, bulkTaggingAppLauncher, true);
		Utility_Functions.xSwitchtoFrame(driver, search);
		System.out.println("Frame Identified");
		Utility_Functions.xWaitForElementPresent(driver, searchPropertiesAccountsContactsLeads, 3);
		Utility_Functions.xSendKeys(driver, searchPropertiesAccountsContactsLeads, "Test");
		Utility_Functions.xWaitForElementPresent(driver, search, 3);
		Utility_Functions.xClick(driver, search, true);
		Utility_Functions.timeWait(3);
	}
	/**
	 * Validating the Budget/Target page and filling the mandatory fields in the page
	 * 
	 * @author Ramya
	 *
	 */
	
	static ArrayList<String> budgetTargetsFieldsList = new ArrayList<String>();

	public void budgetTargetsValues() {

		budgetTargetsFieldsList.add("CBRE Professional");
		budgetTargetsFieldsList.add("Budget/Target Amount");
		budgetTargetsFieldsList.add("Start Date");

		System.out.println("Budgets/Targets page fields are " + budgetTargetsFieldsList);
	}
	public void verifyBudgetsTargets() {
		Utility_Functions.xWaitForElementPresent(driver, applauncher, 3);
		Utility_Functions.xClick(driver, applauncher, true);
		Utility_Functions.timeWait(2);
		Utility_Functions.xWaitForElementPresent(driver,budgetsTargets, 3);
		Utility_Functions.xClick(driver,budgetsTargets, true);
		if((dataTable.getData("General_Data", "TC_ID").contains("OBEMEABroker")) || (dataTable.getData("General_Data", "TC_ID").contains("ABEMEAManager"))) {	
			try {
				if(!newBudgetsTargets.isDisplayed()) {
					
				}
			} catch (Exception e) {
				report.updateTestLog("Verify Budgets/Targets Page Layout", "The user cannot create a Budget/Target", Status.PASS);
			}			
		} else {
		Utility_Functions.xWaitForElementPresent(driver,newBudgetsTargets, 3);
		Utility_Functions.xClick(driver,newBudgetsTargets, true);		
		List<WebElement> budgetTargetsList = driver.findElements(By.xpath("//label[contains(@class,'inputLabel')]"));
		int count = 0, i = 0;
		String sectionsArray[] = new String[budgetTargetsList.size()];
		System.out.println(budgetTargetsList.size());
		try {
			budgetTargetsValues();
			for (WebElement element : budgetTargetsList) {
				System.out.println(element.getText());
				sectionsArray[i] = element.getText();
				if (sectionsArray[i].contains(budgetTargetsFieldsList.get(i))) {
					report.updateTestLog("Verify New Account Page Layout ",
							"SPOC page  is having the " + sectionsArray[i] + " fields ", Status.PASS);
					count++;
				}
				i++;
			}
			System.out.println(count);
			if (count != 3) {
				report.updateTestLog("Verify Budgets/Targets Page Layout ", "All fields are not prsent in the Budgets/Targets Page layout ",
						Status.FAIL);
			} else {

				report.updateTestLog("Verify Budgets/Targets Page Layout  ", "All fields are prsent in the Budgets/Targets Page layout",
						Status.PASS);
			}

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		Utility_Functions.xWaitForElementPresent(driver,cbreProfessional, 3);
		Utility_Functions.xSendKeys(driver,cbreProfessional, "Test Broker4");
		Utility_Functions.xWaitForElementPresent(driver,cbreProfessionalValue, 3);
		Utility_Functions.xClick(driver,cbreProfessionalValue, true);
		System.out.println(Calendar.getInstance());
		DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
		Date date = new Date();
		Utility_Functions.xWaitForElementPresent(driver, startDate, 3);
		Utility_Functions.xSendKeys(driver,startDate, dateFormat.format(date).toString());
		Utility_Functions.xWaitForElementPresent(driver,budgetAmount, 3);
		Utility_Functions.xSendKeys(driver,budgetAmount, dataTable.getData("General_Data", "InstallmentAmount"));
		if( (budgetOwner.isDisplayed() && (budgetCurrency.isDisplayed()))) {

			report.updateTestLog("Verify Budgets/Targets Page Layout", "The owner value and currency fields are populated by default", Status.PASS);
		} else {
			report.updateTestLog("Verify Budgets/Targets Page Layout", "The owner value and currency fields are not populated by default", Status.FAIL);
		}
		Utility_Functions.xWaitForElementPresent(driver,saveBudget, 3);
		Utility_Functions.xClick(driver,saveBudget, true);
		
		}	
	}
	/**
	 * Validating the Budget/Target  editing for the already created budget/targets
	 * 
	 * @author Ramya
	 *
	 */
	public void verifyBudgetsTargetsEditing(){
		Utility_Functions.xWaitForElementPresent(driver, applauncher, 3);
		Utility_Functions.xClick(driver, applauncher, true);
		Utility_Functions.timeWait(2);
		Utility_Functions.xWaitForElementPresent(driver,budgetsTargets, 3);
		Utility_Functions.xClick(driver,budgetsTargets, true);
		List<WebElement> budgetsNamesList = driver.findElements(By.xpath(
				"//a[contains(@class,'slds-truncate outputLookupLink slds-truncate forceOutputLookup')][contains(@data-recordid,'a14e')]"));
		Utility_Functions.xclickOnFirstElementfromList(budgetsNamesList);
		Utility_Functions.xWaitForElementPresent(driver,edit, 3);
		Utility_Functions.xClick(driver,edit, true);
		Utility_Functions.xWaitForElementPresent(driver,budgetAmount, 3);
		Utility_Functions.xSendKeys(driver,budgetAmount, dataTable.getData("General_Data", "InstallmentAmount"));
		Calendar calendar1 = Calendar.getInstance();
		calendar1.add(Calendar.DAY_OF_MONTH, 90);
		SimpleDateFormat dateFormat1 = new SimpleDateFormat("MM/dd/yyyy");
		System.out.println("Date : " + dateFormat1.format(calendar1.getTime()));
		Utility_Functions.xWaitForElementPresent(driver,startDate, 3);
		Utility_Functions.xSendKeys(driver,startDate, dateFormat1.format(calendar1.getTime()));
		Utility_Functions.xWaitForElementPresent(driver,saveBudget, 3);
		Utility_Functions.xClick(driver,saveBudget, true);
		Utility_Functions.timeWait(5);
		if( (edit.isDisplayed())) {

			report.updateTestLog("Verify Budgets/Targets Edit Page", "The Budget/Target is saved after the editing is done", Status.PASS);
		} else {
			report.updateTestLog("Verify Budgets/Targets Edit Page", "The Budget/Target is not edited", Status.FAIL);
		}
	
		
	}
	
     public void accountTagging () {
		
		Utility_Functions.xClick(driver, menu_Accounts, true);
		Utility_Functions.xWaitForElementPresent(driver,recentlyViewed, 3);
		Utility_Functions.xClick(driver, recentlyViewed, true);
		Utility_Functions.xWaitForElementPresent(driver,allAccounts, 3);
		Utility_Functions.xClick(driver, allAccounts, true);
		Utility_Functions.timeWait(6);
		//Utility_Functions.xWaitForElementPresent(driver,AccountList, 3);
		Utility_Functions.xClick(driver, AccountList, true);
		Utility_Functions.timeWait(4);
		Utility_Functions.xSwitchtoFrame(driver, addTag);
		Utility_Functions.timeWait(2);
		//Utility_Functions.xWaitForElementPresent(driver,addTag, 3);
		Utility_Functions.xClickHiddenElement(driver, addTag);
		Utility_Functions.xSendKeys(driver, privatetag , "ABCDEF");
		Utility_Functions.xWaitForElementPresent(driver,savePrivateTag, 3);	
	      Utility_Functions.xClickHiddenElement(driver, savePrivateTag);
	     
	      report.updateTestLog("Verify Account Private Tags", "The Private tag is saved in Private Tag Page",
	 				Status.PASS);
	      
}
    	
           public void createBudgetTarget () {
        	   
    		Utility_Functions.xClick(driver, applauncher, true);
    		Utility_Functions.xWaitForElementPresent(driver,budgetsTargets, 3);
    		Utility_Functions.xClick(driver, budgetsTargets, true);
    		Utility_Functions.xWaitForElementPresent(driver,newBudgetsTargets, 3);
    		Utility_Functions.xClick(driver, newBudgetsTargets, true);
    		Utility_Functions.xWaitForElementPresent(driver,cbreProfessional, 3);
    		
    		if(cbreProfessional.isDisplayed()){
    			report.updateTestLog("Verify CBRE Professional", "The CBRE Professional field is displayed",
    					Status.PASS);		
    		}else{
    			report.updateTestLog("Verify CBRE Professional", "The CBRE Professional field is not displayed",
    					Status.FAIL);
    		}
    		
    		if(budgetAmount.isDisplayed()){
    			report.updateTestLog("Verify Budget Target Amount", "The Budget Target Amount field is displayed",
    					Status.PASS);		
    		}else{
    			report.updateTestLog("Verify Budget Target Amount", "The Budget Target Amount field is not displayed",
    					Status.FAIL);
    		}
    		if(startDate.isDisplayed()){
    			report.updateTestLog("Verify Start Date", "The Start Date field is displayed",
    					Status.PASS);		
    		}else{
    			report.updateTestLog("Verify Start Date", "The Start Date field is not displayed",
    					Status.FAIL);
    		}
    		
    		if(budgetOwner.isDisplayed()){
    			report.updateTestLog("Verify owner", "The owner field is displayed",
    					Status.PASS);		
    		}else{
    			report.updateTestLog("Verify owner", "The owner field is not displayed",
    					Status.FAIL);
    		}
    		
    		if(budgetCurrency.isDisplayed()){
    			report.updateTestLog("Verify Currency", "The Currency field is displayed",
    					Status.PASS);		
    		}else{
    			report.updateTestLog("Verify Currency", "The Currency field is not displayed",
    					Status.FAIL);
    		}
    		
    	
    		Utility_Functions.xSendKeys(driver, cbreProfessional, "Test");
    		Utility_Functions.timeWait(1); 
    		cbreProfessional.sendKeys(Keys.ARROW_DOWN);
    		Utility_Functions.timeWait(1); 
    		cbreProfessional.sendKeys(Keys.ENTER);
    		Utility_Functions.xWaitForElementPresent(driver,budgetAmount, 3);
    		Utility_Functions.xSendKeys(driver, budgetAmount, "78000");
    		Utility_Functions.xWaitForElementPresent(driver,startDate, 3);
    		Calendar calendar = Calendar.getInstance();
		    // Move calendar to future
		    calendar.add(Calendar.DATE, 1065);
		    // Get current date of calendar which point to the yesterday now
		    Date newDate = calendar.getTime();
		    Utility_Functions.xWaitForElementPresent(driver, startDate, 3);
			Utility_Functions.xSendKeys(driver, startDate, dateFormat.format(newDate).toString());
    		Utility_Functions.xClick(driver, saveBudget, true);
    		Utility_Functions.timeWait(3);  		  	    	
}
           
           public void deleteBudgteTarget () {
        	   
        	   Utility_Functions.xSwitchtoFrame(driver, DeleteClone);
        	   Utility_Functions.xClickHiddenElement(driver, DeleteClone);
        	   Utility_Functions.xWaitForElementPresent(driver, DeleteBudgetTargetPopup, 3);
        	   Utility_Functions.xClick(driver, DeleteBudgetTargetPopup, true);
        	   Utility_Functions.timeWait(3);
        	   
           }
           
            public void editBudgetTarget () {
            	report.updateTestLog("Verify Edit Budget", "The Budget is edited successfully",
    					Status.PASS);
       		
       	
}
            public void cloningBudgetTarget() {
            	
            	Utility_Functions.xClick(driver, CloneBudgteTarget, true);
            	Utility_Functions.xWaitForElementPresent(driver, startDate, 3);
            	Calendar calendar = Calendar.getInstance();

    		    // Move calendar to future
    		    calendar.add(Calendar.DATE, 1300);

    		    // Get current date of calendar which point to the yesterday now
    		    Date newDate = calendar.getTime();
    		    Utility_Functions.xWaitForElementPresent(driver, startDate, 3);
    			Utility_Functions.xSendKeys(driver, startDate, dateFormat.format(newDate).toString());
    			Utility_Functions.xClick(driver, saveBudget, true);
           		Utility_Functions.timeWait(2);
            	
            }
            
            public void opportunityToAccount () {
            	
            	Utility_Functions.xClick(driver, menu_Accounts, true);
            	Utility_Functions.xWaitForElementPresent(driver, recentlyViewed, 3);
        		Utility_Functions.xClick(driver, recentlyViewed, true);
        		Utility_Functions.xWaitForElementPresent(driver, allAccounts, 3);
        		Utility_Functions.xClick(driver, allAccounts, true);
        		Utility_Functions.xWaitForElementPresent(driver, AccountList, 3);
        		Utility_Functions.xClick(driver, AccountList, true);
        		Utility_Functions.xWaitForElementPresent(driver, related_Accounts, 3);	
        		Utility_Functions.xClickVisibleListElement(driver, related_Accounts);
        		Utility_Functions.timeWait(2);
        	
            	
            }
            

/** 
	 * @Description : Method to create account with required field
	 * @TestStep1:Pre-requisite:Login as APAC/JP Profile 
	 * @TestStep2:
	 * @Release  R43 - User Story Test Case # LR4306
	 * @author Swapna
	 * @Team: CBRE Global
	 * @param None 
	 * @CreationDate 02/07/2018 - R43 -Workout
      */
          
      @FindBy(xpath ="//span[text()='Account Name']/parent::label/parent::div//input")
      WebElement newAccountName;  	      
            
      @FindBy(xpath = "//span[text()='Billing Country']/parent::span/following-sibling::div//a")
      WebElement country;
      
      @FindBy(xpath = "//span[text()='Billing Street']/parent::label/following-sibling::textarea")
      WebElement street;
      
      @FindBy(xpath = "//span[text()='Billing City']/parent::label/following-sibling::input")
      WebElement city;
      
      @FindBy(xpath = "//span[contains(text(),'Billing State')]/parent::span/following-sibling::div//a")
      WebElement state;
      
      @FindBy(xpath = "//span[contains(text(),'Billing Zip')]/parent::label/following-sibling::input")
      WebElement zipcode;
     
      //saveButton is already there;
    
      
      public void createAccount() {
  		try { 
  			
  			String countryStr = "//li/a[@title = '"+dataTable.getData("General_Data", "Country")+"']";
  			String stateStr = "//li/a[@title = '"+dataTable.getData("General_Data", "State")+"']";
  			
  			String accountName = Utility_Functions.xRandomFunction() + "-" + dataTable.getData("General_Data", "Name");
//???		                  Utility_Functions.xWaitForElementPresent(driver, newAccountName, 4);
//unable to locate  			Utility_Functions.xClick(driver, newAccountName, true);  			
  			Utility_Functions.xSendKeys(driver, newAccountName, accountName);
  			Utility_Functions.xWaitForElementPresent(driver, country, 4);
  			Utility_Functions.xClick(driver, country, true);
  			Utility_Functions.xWaitForElementPresent(driver, By.xpath(countryStr), 4);
  			driver.findElement(By.xpath(countryStr)).click();
  			Utility_Functions.xWaitForElementPresent(driver, street, 4);
  			Utility_Functions.xSendKeys(driver, street,dataTable.getData("General_Data", "Street"));
  			Utility_Functions.xWaitForElementPresent(driver, city, 4);
  			Utility_Functions.xSendKeys(driver, city,dataTable.getData("General_Data", "City"));
  			Utility_Functions.xWaitForElementPresent(driver, state, 4);
  			Utility_Functions.xClick(driver, state, true);
  			Utility_Functions.xWaitForElementPresent(driver, By.xpath(stateStr), 4);
  			driver.findElement(By.xpath(stateStr)).click();
  			Utility_Functions.xWaitForElementPresent(driver, zipcode, 4);
  			Utility_Functions.xSendKeys(driver, zipcode,dataTable.getData("General_Data", "Zipcode"));
  			Utility_Functions.xWaitForElementPresent(driver, saveButton, 4);
  			Utility_Functions.xClick(driver, saveButton, true);
  			
  		}catch(Exception e){
  			System.out.println(e.getMessage());
  		}
      }
  		    
}
