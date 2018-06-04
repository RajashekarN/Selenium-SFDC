package pageObjects;

import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.cognizant.Craft.ReusableLibrary;
import com.cognizant.Craft.ScriptHelper;
import com.cognizant.framework.Status;

import pagesAPI.SearchTextSOQL;
import supportLibraries.SF_UtilityFunctions;
import supportLibraries.Utility_Functions;


public class TaggingPage extends ReusableLibrary {
	/*
	 * Constructor to initialize the business component library
	 * 
	 * @param scriptHelper The {@link ScriptHelper} object passed from the
	 * {@link DriverScript}
	 */

	public TaggingPage(ScriptHelper scriptHelper) {
		super(scriptHelper);
		PageFactory.initElements(driver.getWebDriver(), this);
	}
	
	
	@FindBy(xpath = "//span[contains(@class,'slds-truncate')][text()='Properties']")
	WebElement menu_Properties;

	@FindBy(xpath = "//*[text()='More']")
	WebElement menu_More;

	@FindBy(xpath = "//one-app-nav-bar-menu-item[@class='overflowNavItem slds-dropdown__item']//span[text()='Properties'] ")
	WebElement properties;

	@FindBy(xpath = "//div[@class='overflowList']//a[@title='Properties'][text()='Properties']")
	WebElement propertiesEnv;

	@FindBy(xpath = "//div[@class='slds-truncate'][@title='New']")
	WebElement newProperty;

	@FindBy(xpath = "//button[contains(@class,'neutral uiButton--default uiButton--br')]")
	WebElement nextBtnProperty;

	@FindBy(xpath = "//*[@id='bottomButtonRow']/input[1]")
	WebElement continueButton;

	@FindBy(xpath = "//*[@value='Save Property']")
	WebElement saveProperty;

	@FindBy(xpath = "//label[text()='Building/Property Name']/following-sibling::div//input")
	WebElement buildingPropertyNameEnv;

	@FindBy(xpath = "//div[@class='slds-col--padded slds-size--1-of-1 slds-medium-size--1-of-1 slds-large-size--1-of-2']/div/label[@for='property-name']/parent::div//div/input")
	List<WebElement> buildingPropertyName1;

	@FindBy(xpath = "//div[@class='slds-col--padded slds-size--1-of-1 slds-medium-size--1-of-1 slds-large-size--1-of-2']/div/label[@for='property-name']/parent::div//div/input")
	WebElement buildingPropertyName;

	@FindBy(xpath = "//*[contains(@id,'propertyEditForm:countryPicklist']/option")
	WebElement countrySelect;

	@FindBy(xpath = "//*[contains(@id,'propertyEditForm:countryPicklist')]")
	WebElement countryDropdown;

	@FindBy(xpath = "//*[contains(@id,'propertyEditForm:statePicklist')]")
	WebElement stateDropdown;

	@FindBy(xpath = "//*[contains(@id,'propertyEditForm:statePicklist)']/option")
	WebElement stateSelect;

	@FindBy(xpath = "//*[contains(@id,'propertyEditForm:City')]")
	WebElement city;

	@FindBy(xpath = "//*[contains(@id,'propertyEditForm:Street')]")
	WebElement street;

	@FindBy(xpath = "//h1[@class='slds-page-header__title slds-m-right--small slds-truncate slds-align-middle']/span")
	WebElement createdProperty;

	@FindBy(xpath = "//h2[contains(@class,'slds-m-bottom--large')][text()='Property Information']")
	WebElement propertyInformationFrame;

	@FindBy(xpath = "//*[@id='assignedToBox']")
	WebElement assignedTo;

	@FindBy(xpath = "//*[@id='relatedAccountBox']")
	WebElement accountSelected;

	@FindBy(xpath = "//select[@class='slds-select']/option[@value='Normal']")
	WebElement priority;

	@FindBy(xpath = "//div[@class='slds-form-element__control slds-has-divider--bottom']")
	WebElement owner;

	@FindBy(xpath = "//select[@class='slds-select']/option[@value='Open']")
	WebElement status;

	@FindBy(xpath = "//a[@role='menuitem']/span[contains(@class,'slds-truncate')][text()='Campaigns']")
	WebElement campaigns;

	@FindBy(xpath = "//div[@role='menu']//a/span/span[text()='Campaigns']")
	WebElement campaignsEnv;

	@FindBy(xpath = "//h1//span[text()='Recently Viewed']")
	WebElement recentlyViewed;

	@FindBy(xpath = "//span[contains(@class,'virtualAutocompleteOptionText')][text()='All Properties']")
	WebElement allProperties;

	@FindBy(xpath = "//a[@class='tabHeader']//span[text()='Related']")
	WebElement related;

	@FindBy(xpath = "//span[contains(text(),'Activities')]/ancestor::article//div[text()='New Activity']")
	WebElement newActivity;

	@FindBy(xpath = "//input[@class='slds-input'][@type='text']")
	WebElement subject;

	@FindBy(xpath = "//select[@class='slds-select']/option[@value='Private - Client Intelligence']")
	WebElement activityType;

	@FindBy(xpath = "// input [@value= 'Save & New']")
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

	@FindBy(xpath = "//span[text()='Send Notification Email']/parent::label/parent::div//input")
	WebElement notificationEmail;

	@FindBy(xpath = "// input [@value= 'Save']")
	WebElement saveNewActivityLayoutPage;

	@FindBy(xpath = "// input [@value= 'Save & New']")
	WebElement saveAndNewActivityLayoutPage;

	@FindBy(xpath = "// input [@value= 'Cancel']")
	WebElement cancelNewActivityLayoutPage;

	@FindBy(xpath = "//a[@title='New']/div[text()='New']")
	WebElement newProperties;

	@FindBy(xpath = "//label[text()='Building/Property Name']/parent::div/parent::div//div[contains(@class,'requiredInput')]//input[contains(@id,'propertyEditForm')]")
	WebElement propertyName;

	@FindBy(xpath = "//select[contains(@id,'countryPicklist')]")
	WebElement propertyCountry;

	@FindBy(xpath = "//select[contains(@id,'countryPicklist')]/option[text()='United States']")
	WebElement selectPropertyCountry;

	@FindBy(xpath = "//textarea[contains(@id,'propertyEditForm:Street')]")
	WebElement propertyStreet;

	@FindBy(xpath = "//input[contains(@id,'propertyEditForm:City')]")
	WebElement propertyCity;

	@FindBy(xpath = "//select[contains(@id,'propertyEditForm:statePicklist')]")
	WebElement statePickList;

	@FindBy(xpath = "//select[contains(@id,'statePicklist')]/option[text()='Texas']")
	WebElement selectPropertyState;

	@FindBy(xpath = "//h1[contains(@class,'slds-page-header__title')]/span")
	WebElement propertySaved;

	@FindBy(xpath = "//*[text()='No Next Steps. Open And Upcoming Activities Show Up Here.']")
	WebElement activityTimeline;

	@FindBy(xpath = "//p[@class='slds-tile__title slds-truncate']/a")
	WebElement activity;

	@FindBy(xpath = "//p[@class='slds-tile__title slds-truncate']/a/parent::p/parent::div/parent::div//div[2]")
	WebElement activityTypeProperty;

	@FindBy(xpath = "//p[@class='slds-tile__title slds-truncate']/a/parent::p/parent::div/parent::div//div[3]")
	WebElement statusProperty;

	@FindBy(xpath = "//p[@class='slds-tile__title slds-truncate']/a/parent::p/parent::div/parent::div//div[4]")
	WebElement comments;

	@FindBy(xpath = "//div[@class='slds-media']//p[@class='slds-timeline__date']")
	WebElement dueDate;

	@FindBy(xpath = "//span[@class='slds-checkbox--faux']")
	WebElement statusCheckbox;

	@FindBy(xpath = "//button[@title='Past Activity']")
	WebElement pastActivityButton;

	@FindBy(xpath = "//select[@class='slds-select']/option[@value='Private - Follow-Up Task']")
	WebElement activityTypeFollowUpTaskValue;

	@FindBy(xpath = "//input[contains(@id,'dueDate')]")
	WebElement newActivityDueDate;

	@FindBy(xpath = "//button[@title='Past Activity']")
	WebElement pastActivity;

	@FindBy(xpath = "//button[@title='More Activities']")
	WebElement moreActivities;

	@FindBy(xpath = "//a[@class='tabHeader']/span[text()='Activity']")
	WebElement activityTab;

	@FindBy(xpath = "//div[@id='activityPanelContainer']//a[text()='Expand All']")
	WebElement expandAll;

	@FindBy(xpath = "//div[@id='activityPanelContainer']//span[text()='Filter Timeline']")
	WebElement filterTimeline;

	@FindBy(xpath = "//div[contains(@id,'recordLayoutPlaceholder')]//div[@title='Status']")
	WebElement statusActivityTimeline;

	@FindBy(xpath = "//div[contains(@id,'recordLayoutPlaceholder')]//div/span")
	WebElement openActivityTimeline;

	@FindBy(xpath = "//div[contains(@id,'recordLayoutPlaceholder')]//div[@title='Description']")
	WebElement descriptionActivityTimeline;

	@FindBy(xpath = "//a[contains(@id,'tag_edit_link')]")
	WebElement addTag;

	@FindBy(xpath = "//textarea[@id='ptag_edit_area']")
	WebElement privatetag;

	@FindBy(xpath = "//input[@id='tag_save_btn']")
	WebElement savePrivateTag;

	@FindBy(xpath = "//a[@role='menuitem']/span[contains(@class,'slds-truncate')][text()='Bulk Tagging']")
	WebElement bulkTagging;

	@FindBy(xpath = "//input[@value='Search']")
	WebElement searchProperty;

	@FindBy(xpath = "//input[contains(@id,'SearchBlock:propertyEditForm:SearchBox')][contains(@placeholder,'Search Account/Contact')]")
	WebElement accountSearch;

	@FindBy(xpath = "//div[@class='slds-form-element ']//input[@value='Search']")
	WebElement search;

	@FindBy(xpath = "//a[@role='menuitem']/span[contains(@class,'slds-truncate')][text()='Private Tags']")
	WebElement more_PrivateTags;

	@FindBy(xpath = "//div[@class='slds-truncate'][text()='New']")
	WebElement newPrivateTag;

	@FindBy(xpath = "//label[@class='label inputLabel uiLabel-left form-element__label uiLabel']/span[contains(text(),'Private Tag Name')]/parent::label/parent::div/input")
	WebElement privateTagName;

	@FindBy(xpath = "//button[@title='Save']")
	WebElement saveNewPrivateTag;

	@FindBy(xpath = "//span[contains(text(),'Properties')]/ancestor::article//div[text()='New']")
	WebElement newPropertiesDetailsPage;

	@FindBy(xpath = "//input[contains(@placeholder,'Search Properties')]")
	WebElement searchPropertyWithPrivateTag;

	@FindBy(xpath = "//div[contains(@class,'modal-footer') and contains(@class,'slds-modal__footer')]//button/span[text()='Save']")
	WebElement savePropertyPrivateTag;

	/*
	 * @FindBy(xpath=
	 * "//select[contains(@id,'propertyEditForm:APACPropertyType_unselected')]/option[@value='Industrial']")
	 * WebElement propertyTypeValue;
	 */

	@FindBy(xpath = "//select[contains(@id,'propertyEditForm:APACPropertyType_unselected')]/option[text()='Industrial']")
	WebElement propertyTypeValue;

	@FindBy(xpath = "//td[@class='multiSelectPicklistCell']/a[@title='Add']")
	WebElement addValuetoCheckList;

	@FindBy(xpath = "//select[contains(@id,'propertyEditForm:APACPropertyType')]/parent::div")
	WebElement elementHidden;

	@FindBy(xpath = "//select[contains(@id,'propertyEditForm:APACPropertyType')]/parent::div/select")
	WebElement elementSelectHidden;

	@FindBy(xpath = "//select[contains(@id,'propertyEditForm:Class')]")
	WebElement buildingClass;

	@FindBy(xpath = "//select[contains(@id,'propertyEditForm:Class')]/option[@value='A']")
	WebElement buildingClassValue;

	@FindBy(xpath = "//a[@class='tabHeader']//span[text()='Details']")
	WebElement details;

	@FindBy(xpath = "//a[@role='menuitem']/span[contains(@class,'slds-truncate')][text()='Property Preferences']")
	WebElement more_propertyPreferences;

	@FindBy(xpath = "//div[@class='slds-truncate'][text()='New']")
	WebElement newPropertiesPreferences;

	@FindBy(xpath = "//a[@aria-label='Area UOM']")
	WebElement unitOfMeasure;

	@FindBy(xpath = "//a[@role='menuitem']/span[contains(@class,'slds-truncate')][text()='Project Enquiries']")
	WebElement more_projectEnquiries;

	@FindBy(xpath = "//a[@aria-label='Total Area UOM']")
	WebElement unitOfMeasureProjectEnquiries;

	@FindBy(xpath = "//select[contains(@id,'UnitsofMeasureAPAC')]")
	WebElement unitOfMeasureProperties;

	@FindBy(xpath = "//a[contains(@aria-label,'Preference Type')]")
	WebElement preferenceType;

	@FindBy(xpath = "//span[text()='Project Enquiry Name']/parent::label/parent::div/input")
	WebElement projectEnquiryName;

	@FindBy(xpath = "//input[contains(@placeholder,'Search Accounts')]")
	WebElement enquiryAccount;

	@FindBy(xpath = "//div[contains(@class,'primaryLabel')][@title='AUCAPACBroker123']")
	WebElement enquiryAccountValue;

	@FindBy(xpath = "//input[contains(@placeholder,'Search Contacts')]")
	WebElement enquiryContact;

	@FindBy(xpath = "//div[contains(@class,'secondaryLabel')][@title='AUCAPACBroker123']")
	WebElement enquiryContactValue;

	@FindBy(xpath = "//div[contains(@class,'slds-modal__footer')]//span[text()='Save']")
	WebElement projectEnquirySave;

	@FindBy(xpath = "//div[@class='forceChangeRecordTypeFooter']/button[contains(@class,'slds-button')]/span[text()='Next']")
	WebElement nextNewProjectEnquiry;

	@FindBy(xpath = "//span[contains(text(),'Country')]/parent::div/following-sibling::div//a[contains(text(),'New Zealand')]")
	WebElement countryFieldNewZealand;

	@FindBy(xpath = "//one-app-launcher-header/button")
	WebElement applauncher;

	@FindBy(xpath = "//a[contains(@title,'Preferences')]/span/span[contains(text(),'Preferences')]")
	WebElement preferences;

	@FindBy(xpath = "//span[contains(@class,'virtualAutocompleteOptionText')][contains(text(),'All property preferences')]")
	WebElement allInvestorPreferences;

	@FindBy(xpath = "//span[contains(text(),'Preference Type')]/parent::div/following-sibling::div//span[contains(text(),'Sale')]")
	WebElement preferenceTypeSale;

	@FindBy(xpath = "//span[contains(text(),'Property Type')]/parent::div/following-sibling::div//span[contains(text(),'Industrial')]")
	WebElement industrialPropertyType;

	@FindBy(xpath = "//span[contains(text(),'APAC Region')]/parent::div/following-sibling::div//a[contains(text(),'SA')]")
	WebElement regionSA;

	@FindBy(xpath = "//span[contains(text(),'Preference Type')]/parent::div/following-sibling::div//span[contains(text(),'Lease')]")
	WebElement preferenceTypeLease;

	@FindBy(xpath = "//span[contains(text(),'Property Type')]/parent::div/following-sibling::div//span[contains(text(),'Retail')]")
	WebElement retailPropertyType;

	@FindBy(xpath = "//span[contains(text(),'APAC Region')]/parent::div/following-sibling::div//a[contains(text(),'NSW')]")
	WebElement regionNSW;

	@FindBy(xpath = "//span[contains(text(),'APAC Region')]/parent::div/following-sibling::div//a[contains(text(),'Christchurch')]")
	WebElement regionChristchurch;

	@FindBy(xpath = "//select[contains(@id,'countryPicklist')]/option[text()='Japan']")
	WebElement selectCountryJapan;

	@FindBy(xpath = "//select[contains(@id,'UnitsofMeasureAPAC')]/option[contains(@value,'Tsubo')]")
	WebElement japanUnitOfMeasure;

	@FindBy(xpath = "//select[contains(@id,'statePicklist')]/option[text()='Tokyo']")
	WebElement selectStateTokyo;

	@FindBy(xpath = "//input[contains(@id,'TotalSize')]")
	WebElement totalSize;

	@FindBy(xpath = "//select[contains(@id,'APACPropertyType_unselected')]")
	WebElement propertyTypeHotel;

	@FindBy(xpath = "//span[contains(@id,'propertyEditForm:prpType')]//a[contains(@title,'Add')]/img")
	WebElement addButton;

	@FindBy(xpath = "//li[contains(@id,'Serviced-Apartment')]//span[contains(text(),'Serviced Apartment')]")
	WebElement servicedApartment;

	@FindBy(xpath = "//a[@role='menuitem']/div[@class='forceActionLink'][text()='Edit']")
	WebElement edit;

	@FindBy(xpath = "//li[contains(@class,'oneActionsDropDown')]//a")
	WebElement showMoreActions;

	@FindBy(xpath = "//li[contains(@id,'Commercial-Building')]//span[contains(text(),'Commercial Building')]")
	WebElement commercialBuilding;

	@FindBy(xpath = "//span[contains(text(),'APAC Property Preferences')]/parent::div/preceding-sibling::div/span[contains(@class,'slds-radio--faux')]")
	WebElement apacPropertyPreferences;

	@FindBy(xpath = "//span[contains(text(),'Next')]/parent::button")
	WebElement nextPropertyPreferences;

	@FindBy(xpath = "//input[contains(@placeholder,'Search Contacts')]")
	WebElement searchContacts;

	@FindBy(xpath = "//div[contains(@class,'primaryLabel')][contains(@title,'TestAMER CMBroker')]")
	WebElement contactsValue;

	@FindBy(xpath = "//a[contains(@title,'Sale')]")
	WebElement preferenceTypeValue;

	@FindBy(xpath = "//a[contains(@aria-label,'Property Type')]")
	WebElement propertyType;

	@FindBy(xpath = "//a[contains(@title,'Hotel')]")
	WebElement propertyTypeHotelValue;

	@FindBy(css = "ul>li.forceSearchInputLookupDesktopOption:nth-child(1)")
	WebElement firstLookUpElement;

	@FindBy(xpath = "//ul[@class='tabs__nav']//a[@title='New Event']")
	WebElement newEventOpp;

	@FindBy(xpath = "//span[text()='Add']")
	WebElement addActivity;

	@FindBy(xpath = "//button[@title='Add']")
	List<WebElement> addEventActivity;

	@FindBy(xpath = "//a[contains(@title,'Automation')]")
	WebElement ExistingProperty;

	@FindBy(xpath = "//*[contains(@title,'View records tagged')]")
	WebElement PrivateTagged;

	@FindBy(xpath = " //*[contains(@class,'entityNameTitle slds-breadcrumb__item slds-line-height--reset')]")
	WebElement PrivateTagPage;

	@FindBy(xpath = "//a[@class='slds-truncate outputLookupLink slds-truncate forceOutputLookup']")
	WebElement PropertyList;

	@FindBy(xpath = "//li/a[@title='Marketing Lists']")
	WebElement marketingLists;

	@FindBy(xpath = "//*[@class=' input' and @maxlength]")
	WebElement marketListName;

	@FindBy(xpath = "//*[@placeholder='Search Contacts...']")
	WebElement authorContact;

	@FindBy(xpath = "//div[@class='form-element']")
	WebElement publicationDate;

	@FindBy(xpath = "//input[@title='Search Marketing Lists']")
	WebElement marketListSubscription;

	@FindBy(xpath = "//*[@class=' textarea']")
	WebElement notesTxtBx;

	@FindBy(xpath = "//*[@title='Save']")
	WebElement saveMarketList;

	@FindBy(xpath = "//*[@title='Subscriptions']")
	WebElement subscriptions;

	@FindBy(xpath = "//button[@title='Save']")
	WebElement saveSubscription;

	@FindBy(xpath = "//li/a[@title='Property Preferences']")
	WebElement propertyPreferences;

	@FindBy(xpath = "//*[contains(@class,'slds-dropdown__item has-icon--left   f')]")
	WebElement allPropertyPreferences;

	@FindBy(xpath = "//*[@class='slds-cell-edit cellContainer'][@tabindex='-1'][@scope='row']")
	WebElement allPropertyPreferenceslist;

	@FindBy(xpath = "//li/a[@title='Edit']")
	WebElement editProperty;

	@FindBy(xpath = "//span[text()='Minimum Price']/parent::label/parent::div/input")
	WebElement minimumPriceProperty;

	@FindBy(xpath = "//*[@title='Save']")
	WebElement savePropertypreference;

	@FindBy(xpath = "//li/a[@title='Clone']")
	WebElement cloneProperty;

	@FindBy(xpath = "//*[@class=' select'][@data-interactive-lib-uid='115']")
	WebElement hotelStar;

	@FindBy(xpath = "//button[@title='Add']")
	WebElement addBtnTask;

	@FindBy(xpath = "//button[@title='Add']")
	List<WebElement> addBtnTask1;

	@FindBy(xpath = "//label/span[text()='Subject']/parent::label/parent::div/input")
	WebElement taskSubject;

	@FindAll(value = { @FindBy(xpath = "//a[@class='select'][text()='--None--']") })
	List<WebElement> activityTypeList;

	@FindAll(value = { @FindBy(xpath = "//div[@class='select-options']/ul/li/a[text()='Private - Initial Meeting']") })
	List<WebElement> newActivityType;

	@FindAll(value = { @FindBy(xpath = "//div[contains(@class,'bottomBarRight')]//span[text()='Save']") })
	List<WebElement> activitySave;

	@FindBy(xpath = "//a[text()='Private - Initial Meeting']")
	WebElement activityType1;

	@FindBy(xpath = "//*[contains(@class ,'label') and text()='Campaigns']")
	WebElement campaign;

	@FindBy(xpath = "//*[contains(@class ,'label') and text()='Comps']")
	WebElement comps;

	@FindBy(xpath = "//div[@class='slds-truncate'][@title='New']")
	WebElement newComps;

	@FindBy(xpath = "//button[contains(@class,'neutral uiButton--default uiButton--br')]")
	WebElement nextBtnComps;

	@FindBy(xpath = "//input[@class=' input' and @maxlength = '80']")
	List<WebElement> compsName;

	@FindBy(xpath = "//button[contains(@class, 'Button-') and @title='Save']")
	WebElement saveComps;

	@FindBy(xpath = "//*[contains(@class ,'label') and text()='Space Assessments']")
	WebElement spaces;

	@FindBy(xpath = "//div[@class='slds-truncate'][@title='New']")
	WebElement newSpaces;

	@FindBy(xpath = "//div[@class='slds-truncate'][@title='New']")
	WebElement newCampaigns;

	@FindBy(xpath = "//input[@class=' input' and @maxlength = '80']")
	List<WebElement> campaignsName;

	@FindBy(xpath = "//button[contains(@class, 'Button-') and @title='Save']")
	WebElement saveCampaigns;

	@FindBy(xpath = "//span[text()='New Event']")
	List<WebElement> newEvent;

	@FindBy(xpath = "//label/span[text()='Subject']/parent::label/parent::div/input")
	List<WebElement> eventSubject;

	@FindAll(value = {
			@FindBy(xpath = "//span[contains(text(),'Activity Type')]/parent::span/following-sibling::div/descendant::a[@class='select'][text()='--None--']") })
	List<WebElement> eventActivityTypeList;

	@FindBy(xpath = "//*[contains(@id,'g') and text()='Task']")
	WebElement taskName;

	@FindBy(xpath = "//*[@title='Edit']")
	List<WebElement> editTask;

	@FindBy(xpath = "//*[@class='slds-truncate' and @title='Edit']")
	List<WebElement> editEvent;

	@FindBy(xpath = "//*[@class=' input']")
	List<WebElement> editTaskName;

	@FindBy(xpath = "//label[@class='label inputLabel uiLabel-left form-element__label uiLabel']/span[text()='Subject']//parent::label/following-sibling::input")
	List<WebElement> editEventName;

	@FindBy(xpath = "//input[contains(@class,'inputDate')]")
	List<WebElement> activityInputDate;

	@FindBy(xpath = "//button[contains(@class, 'Button-') and @title='Save']")
	WebElement saveBtnTask;

	@FindBy(xpath = "//button[contains(@class, 'Button-') and @title='Save']")
	WebElement saveBtnEvent;

	@FindBy(xpath = "//a[@title='Add Attachment']")
	WebElement addAttachment;

	@FindBy(xpath = "//input[@class= 'slds-input']")
	WebElement attachFile;

	@FindBy(xpath = "//*[contains(@class,'slds-truncate') and @title ='Delete']")
	List<WebElement> deleteTask;

	@FindBy(xpath = "//*[contains(@class,'slds-button') and @title ='Delete']")
	WebElement deleteTaskPopup;

	@FindBy(xpath = "//*[@class='slds-checkbox--faux']")
	List<WebElement> checkBoxTask;

	@FindBy(xpath = "//*[contains(@id,'g') and text()='Event']")
	WebElement eventName;

	@FindBy(xpath = "//div[text()='Activity Type']")
	WebElement activityTypeTask;

	@FindBy(xpath = "//div[text()='Status']")
	WebElement statusTask;

	@FindBy(xpath = "//div[text()='Comments']")
	WebElement commentTask;

	@FindBy(xpath = "//div[contains(text(),'Start Time')]")
	WebElement startTimeEvent;

	@FindBy(xpath = "//div[contains(text(),'End Time')]")
	WebElement endTimeEvent;

	@FindBy(xpath = "//div[contains(text(),'Comments')]")
	WebElement commmentsEvent;

	@FindBy(xpath = "//a[@class='tabHeader']//span[text()='Related']")
	List<WebElement> relatedlnk;

	@FindBy(xpath = "//span[@title='Spaces']")
	WebElement space;

	@FindBy(xpath = "//div[@class='slds-truncate'][@title='New']")
	List<WebElement> newSpace;

	@FindBy(xpath = "//input[@class=' input' and @maxlength='80']")
	WebElement spaceName;

	@FindBy(xpath = "//button[contains(@class, 'Button-') and @title='Save']")
	WebElement saveSpace;

	@FindBy(xpath = "//a[@title='test']")
	WebElement spaceNameSelect;

	@FindBy(xpath = "//span[contains(text(),'Start')]/parent::legend/following-sibling::div/div/input")
	WebElement eventStartDate;

	@FindBy(xpath = "//span[contains(text(),'End')]/parent::legend/following-sibling::div/div/input")
	WebElement eventEndDate;

	
	SF_UtilityFunctions sf_UtilityFunctions = new SF_UtilityFunctions(scriptHelper);
	
	/**
	 * Validating the Properties Preferences creation
	 *
	 * @author Vishnuvardhan
	 *
	 */

	public void propertyTagging() {
		sf_UtilityFunctions.oneAppNavigationTab("Properties");
		sf_UtilityFunctions.selectAction("New");
		sf_UtilityFunctions.selectExistingObjectRecord("Propery Name");
	
		/*Utility_Functions.xClick(driver, menu_More, true);
		Utility_Functions.xWaitForElementPresent(driver, properties, 3);
		Utility_Functions.xClick(driver, properties, true);
		Utility_Functions.xWaitForElementPresent(driver, recentlyViewed, 3);
		Utility_Functions.xClick(driver, recentlyViewed, true);
		Utility_Functions.xWaitForElementPresent(driver, allProperties, 3);
		Utility_Functions.xClick(driver, allProperties, true);
		Utility_Functions.timeWait(8);
		Utility_Functions.xClick(driver, PropertyList, true);
		Utility_Functions.timeWait(4);*/
		Utility_Functions.xSwitchtoFrame(driver, addTag);
		Utility_Functions.xClick(driver, addTag, true);
		Utility_Functions.xSendKeys(driver, privatetag, dataTable.getData("General_Data", "Private Tag"));
		Utility_Functions.xClickHiddenElement(driver, savePrivateTag);
		Utility_Functions.xWaitForElementPresent(driver, addTag, 3);

		if (addTag.isDisplayed()) {
			report.updateTestLog("Verify Property Private Tags", "The Private Tag is saved", Status.PASS);
		} else {
			report.updateTestLog("Verify Property Private Tags", "The Private tag is not saved", Status.FAIL);
		}

		Utility_Functions.xClick(driver, PrivateTagged, true);
		report.updateTestLog("Verify Property Private Tags", "The Private tag is saved in Private Tag Page",
				Status.FAIL);
	}

	public void marketCreation() {
		Utility_Functions.xWaitForElementPresent(driver, applauncher, 3);
		Utility_Functions.xClick(driver, applauncher, true);
		Utility_Functions.timeWait(2);
		Utility_Functions.xClickHiddenElement(driver, marketingLists);
		Utility_Functions.xWaitForElementPresent(driver, newProperty, 3);
		Utility_Functions.xClick(driver, newProperty, true);
		Utility_Functions.xWaitForElementPresent(driver, marketListName, 3);
		Utility_Functions.xSendKeys(driver, marketListName, "Test");
		Utility_Functions.xSendKeys(driver, authorContact, "Test Broker6");
		Utility_Functions.timeWait(1);
		authorContact.sendKeys(Keys.ARROW_DOWN);
		authorContact.sendKeys(Keys.ENTER);
		Utility_Functions.xWaitForElementPresent(driver, notesTxtBx, 3);
		Utility_Functions.xSendKeys(driver, notesTxtBx, "Testing");
		Utility_Functions.xClick(driver, saveMarketList, true);
		Utility_Functions.xWaitForElementPresent(driver, newProperty, 3);
	}

	public void subscriptionCreation() {
		Utility_Functions.xWaitForElementPresent(driver, applauncher, 3);
		Utility_Functions.xClick(driver, applauncher, true);
		Utility_Functions.timeWait(2);
		Utility_Functions.xClickHiddenElement(driver, subscriptions);
		Utility_Functions.xWaitForElementPresent(driver, newProperty, 3);
		Utility_Functions.xClick(driver, newProperty, true);
		Utility_Functions.xWaitForElementPresent(driver, saveMarketList, 3);
		Utility_Functions.xSendKeys(driver, marketListSubscription, "Test");
		marketListSubscription.sendKeys(Keys.ARROW_DOWN);
		marketListSubscription.sendKeys(Keys.ENTER);
		Utility_Functions.xClick(driver, saveMarketList, true);

		if (newProperty.isDisplayed()) {

			System.out.println("Subscription is created");
		} else {
			System.out.println("Subscription is not created");
		}

	}
	
	public void addTask() {

		// Utility_Functions.xWaitForElementPresent(driver, addBtnTask1, 6);
		Utility_Functions.timeWait(5);
		Utility_Functions.xClickVisibleListElement(driver, addBtnTask1);
		Utility_Functions.xWaitForElementPresent(driver, taskSubject, 2);
		Utility_Functions.xSendKeys(driver, taskSubject, "Task");

		List<WebElement> newActivityPageLayoutFields = driver
				.findElements(By.xpath("//div[@class='riseTransitionEnabled']//label/span"));
		int countRequiredFiles = 0;
		try {
			for (WebElement element : newActivityPageLayoutFields) {
				if ((element.getText().equals("Subject"))) {
					System.out.println("Subject required field is present in the New Activity Layout Page");
					report.updateTestLog("Verify New Activity Page Layout",
							"New Activity Layout Page is having the " + element.getText() + " Status field::",
							Status.PASS);
					countRequiredFiles++;
				} else if ((element.getText().equals("Due Date"))) {
					System.out.println("Due Date required field is present in the New Activity Layout Page");
					report.updateTestLog("Verify New Activity Page Layout",
							"New Activity Layout Page is having the " + element.getText() + " Status field::",
							Status.PASS);
					countRequiredFiles++;
				} else if ((element.getText().equals("Name"))) {
					System.out.println("Name required field is present in the New Activity Layout Page");
					report.updateTestLog("Verify New Activity Page Layout",
							"New Activity Layout Page is having the " + element.getText() + " Status field::",
							Status.PASS);
					countRequiredFiles++;
				} else if ((element.getText().equals("Related To"))) {
					System.out.println("Related To required field is present in the New Activity Layout Page");
					report.updateTestLog("Verify New Activity Page Layout",
							"New Activity Layout Page is having the " + element.getText() + " Status field::",
							Status.PASS);
					countRequiredFiles++;
				} else if ((element.getText().equals("Comments"))) {
					System.out.println("Comments required field is present in the New Activity Layout Page");
					report.updateTestLog("Verify New Activity Page Layout",
							"New Activity Layout Page is having the " + element.getText() + " Status field::",
							Status.PASS);
					countRequiredFiles++;
				} else if ((element.getText().equals("Assigned To"))) {
					System.out.println("Assigned To required field is present in the New Activity Layout Page");
					report.updateTestLog("Verify New Activity Page Layout",
							"New Activity Layout Page is having the " + element.getText() + " Status field::",
							Status.PASS);
					countRequiredFiles++;
				}
			}
			List<WebElement> newActivityPageLayoutRequiredFields = driver.findElements(By.xpath(
					"//div[contains(@class,'forceInputPicklist')]/span[contains(@class,'uiPicklistLabel')]/span"));
			for (WebElement element : newActivityPageLayoutRequiredFields) {
				if ((element.getText().equals("Activity Type"))) {
					System.out.println("Activity Type required field is present in the New Activity Layout Page");
					report.updateTestLog("Verify New Activity Page Layout",
							"New Activity Layout Page is having the " + element.getText() + " Status field::",
							Status.PASS);
					countRequiredFiles++;
				} else if ((element.getText().equals("Status"))) {
					System.out.println("Status required field is present in the New Activity Layout Page");
					report.updateTestLog("Verify New Activity Page Layout",
							"New Activity Layout Page is having the " + element.getText() + " Status field::",
							Status.PASS);
					countRequiredFiles++;
				} else if ((element.getText().equals("Priority"))) {
					System.out.println("Priority required field is present in the New Activity Layout Page");
					report.updateTestLog("Verify New Activity Page Layout",
							"New Activity Layout Page is having the " + element.getText() + " Status field::",
							Status.PASS);
					countRequiredFiles++;
				}
			}
			if (countRequiredFiles >= 9) {
				System.out.println("New Activity Page Layout contains the required fields ");
				report.updateTestLog("Verify New Activity Page Layout",
						"New Activity Layout Page is having all the required fields", Status.PASS);
			} else {
				report.updateTestLog("Verify New Activity Page Layout",
						"New Activity Layout Page is not having all the required fields", Status.WARNING);
			}

		} catch (Exception e) {
			System.out.println("Encountered an error in validating the Account New Activity Page Layout Fields::"
					+ e.getMessage());
		}

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

		Utility_Functions.xClickVisibleListElement(driver, activityTypeList);
		Utility_Functions.xClick(driver, activityType1, true);
		Utility_Functions.xWaitForElementPresent(driver, activitySave, 2);
		Utility_Functions.xClickVisibleListElement(driver, activitySave);
		report.updateTestLog("Verify Task", "The Task is created successfully", Status.PASS);

	}

	public void addCampaign() {

		Utility_Functions.xWaitForElementPresent(driver, applauncher, 3);
		Utility_Functions.xClick(driver, applauncher, true);
		Utility_Functions.xWaitForElementPresent(driver, campaign, 3);
		Utility_Functions.xClick(driver, campaign, true);
		Utility_Functions.xWaitForElementPresent(driver, newCampaigns, 2);
		Utility_Functions.xClick(driver, newCampaigns, true);
		Utility_Functions.xWaitForElementPresent(driver, campaignsName, 2);
		Utility_Functions.xSendKeysVisibleListElement(driver, campaignsName, "TestCampaigns");
		Utility_Functions.xWaitForElementPresent(driver, saveCampaigns, 3);
		Utility_Functions.xClick(driver, saveCampaigns, true);
		report.updateTestLog("Verify Campaigns", "The Campaigns is created successfully", Status.PASS);

	}

	public void activityTask() {

		for (int i = 1; i <= 3; i++) {

			if (i == 1) {
				// Utility_Functions.xWaitForElementPresent(driver, addBtnTask1,
				// 3);
				Utility_Functions.timeWait(5);
				Utility_Functions.xClickVisibleListElement(driver, addBtnTask1);
				Utility_Functions.xWaitForElementPresent(driver, taskSubject, 2);
				Utility_Functions.xSendKeys(driver, taskSubject, "Present Automation Task");

				// Utility_Functions.xSendKeysVisibleListElement(driver,
				// activityInputDate, dateFormat.format(date).toString());
				// Utility_Functions.xSendKeys(driver, activityInputDate,
				// dateFormat.format(date).toString());

			} else if (i == 2) {
				// Utility_Functions.xWaitForElementPresent(driver, addBtnTask1,
				// 6);
				Utility_Functions.timeWait(3);
				Utility_Functions.xClickVisibleListElement(driver, addBtnTask1);
				Utility_Functions.xWaitForElementPresent(driver, taskSubject, 2);
				Utility_Functions.xSendKeys(driver, taskSubject, "Past Automation Task");
				/*
				 * Calendar calendar = Calendar.getInstance();
				 * 
				 * // Move calendar to yesterday calendar.add(Calendar.DATE,
				 * -1);
				 * 
				 * // Get current date of calendar which point to the yesterday
				 * now Date newDate = calendar.getTime();
				 * Utility_Functions.xWaitForElementPresent(driver,
				 * activityInputDate, 3); Utility_Functions.xSendKeys(driver,
				 * activityInputDate, dateFormat.format(newDate).toString());
				 * Utility_Functions.xWaitForElementPresent(driver,
				 * activitySave, 2);
				 * Utility_Functions.xClickVisibleListElement(driver,
				 * activitySave); report.updateTestLog("Verify Past Task",
				 * "The Past Task is created successfully", Status.PASS);
				 */
			} else {
				// Utility_Functions.xWaitForElementPresent(driver, addBtnTask1,
				// 6);
				Utility_Functions.timeWait(3);
				Utility_Functions.xClickVisibleListElement(driver, addBtnTask1);
				Utility_Functions.xWaitForElementPresent(driver, taskSubject, 2);
				Utility_Functions.xSendKeys(driver, taskSubject, "Future Automation Task");
				/*
				 * Calendar calendar = Calendar.getInstance();
				 * 
				 * // Move calendar to future calendar.add(Calendar.DATE, 1);
				 * 
				 * // Get current date of calendar which point to the yesterday
				 * now Date newDate = calendar.getTime();
				 * Utility_Functions.xWaitForElementPresent(driver,
				 * activityInputDate, 3); //Utility_Functions.xSendKeys(driver,
				 * activityInputDate, dateFormat.format(newDate).toString());
				 * Utility_Functions.xWaitForElementPresent(driver,
				 * activitySave, 2);
				 * Utility_Functions.xClickVisibleListElement(driver,
				 * activitySave); report.updateTestLog("Verify Future Task",
				 * "The Future Task is created successfully", Status.PASS);
				 */
			}
			Utility_Functions.xClickVisibleListElement(driver, activityTypeList);
			Utility_Functions.xClick(driver, activityType1, true);
			Utility_Functions.timeWait(3);

			Utility_Functions.xWaitForElementPresent(driver, activitySave, 2);
			Utility_Functions.xClickVisibleListElement(driver, activitySave);
			report.updateTestLog("Verify Task", "The Task is created successfully", Status.PASS);
		}
	}


	public void addComp() {

		Utility_Functions.xWaitForElementPresent(driver, applauncher, 3);
		Utility_Functions.xClick(driver, applauncher, true);
		Utility_Functions.xWaitForElementPresent(driver, comps, 3);
		Utility_Functions.xClick(driver, comps, true);
		Utility_Functions.xWaitForElementPresent(driver, newComps, 2);
		Utility_Functions.xClick(driver, newComps, true);
		Utility_Functions.xWaitForElementPresent(driver, nextBtnComps, 2);
		Utility_Functions.xClick(driver, nextBtnComps, true);
		Utility_Functions.xWaitForElementPresent(driver, compsName, 2);
		Utility_Functions.xSendKeysVisibleListElement(driver, compsName, "Test");
		Utility_Functions.xWaitForElementPresent(driver, saveComps, 3);
		Utility_Functions.xClick(driver, saveComps, true);
		report.updateTestLog("Verify Comps", "The Comps is created successfully", Status.PASS);

	}

	public void activityEvent() {
		for (int i = 1; i <= 3; i++) {
			if (i == 1) {

				// Utility_Functions.xWaitForElementPresent(driver, newEvent,
				// 3);
				Utility_Functions.timeWait(3);
				Utility_Functions.xClickVisibleListElement(driver, newEvent);
				Utility_Functions.xSendKeysVisibleListElement(driver, eventSubject, "Past Event");

				/*
				 * Utility_Functions.xWaitForElementPresent(driver,
				 * eventStartDate, 3); Utility_Functions.xSendKeys(driver,
				 * eventStartDate, dateFormat.format(date).toString());
				 * 
				 * Utility_Functions.xWaitForElementPresent(driver,
				 * eventEndDate, 3); Utility_Functions.xSendKeys(driver,
				 * eventEndDate, dateFormat.format(date).toString());
				 */

			} else if (i == 2) {
				Utility_Functions.xClickVisibleListElement(driver, addEventActivity);
				Utility_Functions.xSendKeysVisibleListElement(driver, eventSubject, "Present Event");

				/*
				 * Calendar calendar = Calendar.getInstance();
				 * 
				 * // Move calendar to yesterday calendar.add(Calendar.DATE,
				 * -1);
				 * 
				 * // Get current date of calendar which point to the yesterday
				 * now Date newDate = calendar.getTime();
				 * Utility_Functions.xWaitForElementPresent(driver,
				 * eventStartDate, 3); Utility_Functions.xSendKeys(driver,
				 * eventStartDate, dateFormat.format(newDate).toString());
				 * 
				 * Utility_Functions.xWaitForElementPresent(driver,
				 * eventEndDate, 3); Utility_Functions.xSendKeys(driver,
				 * eventEndDate, dateFormat.format(newDate).toString());
				 */

			} else {
				Utility_Functions.xClickVisibleListElement(driver, addEventActivity);
				Utility_Functions.xSendKeysVisibleListElement(driver, eventSubject, "Future Event");

				/*
				 * Calendar calendar = Calendar.getInstance();
				 * 
				 * // Move calendar to future calendar.add(Calendar.DATE, 1);
				 * 
				 * // Get current date of calendar which point to the yesterday
				 * now Date newDate = calendar.getTime();
				 * Utility_Functions.xWaitForElementPresent(driver,
				 * eventStartDate, 3); Utility_Functions.xSendKeys(driver,
				 * eventStartDate, dateFormat.format(newDate).toString());
				 * 
				 * Utility_Functions.xWaitForElementPresent(driver,
				 * eventEndDate, 3); Utility_Functions.xSendKeys(driver,
				 * eventEndDate, dateFormat.format(newDate).toString());
				 */

			}
			Utility_Functions.xClickVisibleListElement(driver, eventActivityTypeList);
			Utility_Functions.xWaitForElementPresent(driver, newActivityType, 3);
			Utility_Functions.xClickVisibleListElement(driver, newActivityType);
			Utility_Functions.xWaitForElementPresent(driver, activitySave, 3);
			Utility_Functions.xClickVisibleListElement(driver, activitySave);
			report.updateTestLog("Verify Event", "The Event is created successfully", Status.PASS);
			Utility_Functions.timeWait(3);
		}
	}
	
	public void addEvent() {
		Utility_Functions.timeWait(5);
		Utility_Functions.xClickVisibleListElement(driver, newEvent);
		Utility_Functions.xSendKeysVisibleListElement(driver, eventSubject, "Event");
		Utility_Functions.xClickVisibleListElement(driver, eventActivityTypeList);
		Utility_Functions.xWaitForElementPresent(driver, newActivityType, 3);
		Utility_Functions.xClickVisibleListElement(driver, newActivityType);
		Utility_Functions.xWaitForElementPresent(driver, activitySave, 3);
		Utility_Functions.xClickVisibleListElement(driver, activitySave);
		report.updateTestLog("Verify Event", "The Event is created successfully", Status.PASS);

	}

	public void editTask() {
		Utility_Functions.xWaitForElementPresent(driver, taskName, 5);
		Utility_Functions.xClick(driver, taskName, true);
		Utility_Functions.timeWait(3);
		// Utility_Functions.xWaitForElementPresent(driver, editTask, 3);
		Utility_Functions.xClickVisibleListElement(driver, editTask);
		Utility_Functions.timeWait(3);
		Utility_Functions.xSendKeysVisibleListElement(driver, editTaskName, "Automation");
		Utility_Functions.xWaitForElementPresent(driver, saveBtnTask, 3);
		Utility_Functions.xClick(driver, saveBtnTask, true);
		report.updateTestLog("Verify Edit Task", "The Task is edited successfully", Status.PASS);

	}

	public void addAttachment() {

		Utility_Functions.timeWait(5);
		Utility_Functions.xClick(driver, addAttachment, true);
		Utility_Functions.timeWait(5);
		Utility_Functions.xSwitchtoFrame(driver, attachFile);
		// attachFile.sendKeys(Keys.ENTER);
		Utility_Functions.xClickHiddenElement(driver, attachFile);
		Utility_Functions.timeWait(3);
		// Utility_Functions.xClick(driver, attachFile, true);
		// Specify the file location with extension
		StringSelection sel = new StringSelection(
				"\\us.cbre.net\\dardata\\Team-Cognizant\\CBRE_QA\\Mukesh Garg\\Demo.docx");

		// Copy to clipboard
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(sel, null);
		System.out.println("selection" + sel);
		try {
			Robot robot = new Robot();

			robot.keyPress(KeyEvent.VK_CONTROL);
			robot.keyPress(KeyEvent.VK_V);
			robot.keyRelease(KeyEvent.VK_CONTROL);
			robot.keyRelease(KeyEvent.VK_V);
			robot.keyPress(KeyEvent.VK_ENTER);
			robot.keyRelease(KeyEvent.VK_ENTER);

		} catch (Exception e) {
			System.out.println("The file is not uploaded" + e.getMessage());

		}

	}

	public void deleteTask() {
		Utility_Functions.timeWait(3);
		Utility_Functions.xClickVisibleListElement(driver, deleteTask);
		Utility_Functions.xClick(driver, deleteTaskPopup, true);

	}

	public void editStatusTask() {
		Utility_Functions.timeWait(3);
		Utility_Functions.xClickVisibleListElement(driver, checkBoxTask);
		Utility_Functions.xWaitForElementPresent(driver, taskName, 5);
		Utility_Functions.xClick(driver, taskName, true);
		Utility_Functions.timeWait(3);
		report.updateTestLog("Verify Edit Task status", "The Task status is changed successfully", Status.PASS);
	}

	public void validationEvent() {

		if (startTimeEvent.isDisplayed()) {
			report.updateTestLog("Event", "Start Time", Status.PASS);
		} else {
			report.updateTestLog("Event", "Start Time", Status.FAIL);
		}

		if (endTimeEvent.isDisplayed()) {
			report.updateTestLog("Event", "End Time", Status.PASS);
		} else {
			report.updateTestLog("Event", "End Time", Status.FAIL);
		}

		if (commmentsEvent.isDisplayed()) {
			report.updateTestLog("Event", "Comments", Status.PASS);
		} else {
			report.updateTestLog("Event", "Comments", Status.FAIL);
		}
	}

	public void editEvent() {
		Utility_Functions.xWaitForElementPresent(driver, eventName, 5);
		Utility_Functions.xClick(driver, eventName, true);
		Utility_Functions.timeWait(3);
		// Utility_Functions.xWaitForElementPresent(driver, editTask, 3);
		Utility_Functions.xClickVisibleListElement(driver, editEvent);
		Utility_Functions.timeWait(3);
		Utility_Functions.xSendKeysVisibleListElement(driver, editEventName, "Automation");
		Utility_Functions.xWaitForElementPresent(driver, saveBtnEvent, 3);
		Utility_Functions.xClick(driver, saveBtnEvent, true);
		report.updateTestLog("Verify Edit Event", "The Event is edited successfully", Status.PASS);

	}

	public void validationTask() {

		if (activityTypeTask.isDisplayed()) {
			report.updateTestLog("Task", "Activity Type", Status.PASS);
		} else {
			report.updateTestLog("Task", "Activity Type", Status.FAIL);
		}

		if (statusTask.isDisplayed()) {
			report.updateTestLog("Task", "Status", Status.PASS);
		} else {
			report.updateTestLog("Task", "Status", Status.FAIL);
		}

		if (commentTask.isDisplayed()) {
			report.updateTestLog("Task", "Comment", Status.PASS);
		} else {
			report.updateTestLog("Task", "Comment", Status.FAIL);
		}
	}

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

	public void createSpace() {

		Utility_Functions.timeWait(5);
		Utility_Functions.xClickVisibleListElement(driver, relatedlnk);
		Utility_Functions.xWaitForElementPresent(driver, space, 5);
		Utility_Functions.xClick(driver, space, true);
		Utility_Functions.timeWait(3);
		Utility_Functions.xClickVisibleListElement(driver, newSpace);
		Utility_Functions.xWaitForElementPresent(driver, spaceName, 3);
		Utility_Functions.xSendKeys(driver, spaceName, "test");
		Utility_Functions.xClick(driver, saveSpace, true);
		Utility_Functions.timeWait(5);
		Utility_Functions.xClick(driver, spaceNameSelect, true);

	}
	

	public void verifyPropertiesPrivateTags() {

		Utility_Functions.xWaitForElementPresent(driver, menu_More, 3);
		Utility_Functions.xClick(driver, menu_More, true);
		report.updateTestLog("Verify Properties Private Tag", "Verifying More options is displayed", Status.PASS);
		Utility_Functions.timeWait(2);
		Utility_Functions.xWaitForElementPresent(driver, more_PrivateTags, 3);
		Utility_Functions.xClick(driver, more_PrivateTags, true);
		report.updateTestLog("Verify Properties Private Tag", "Verifying Private Tags is displayed", Status.PASS);
		Utility_Functions.timeWait(2);
		Utility_Functions.xWaitForElementPresent(driver, newPrivateTag, 3);
		Utility_Functions.xClick(driver, newPrivateTag, true);
		report.updateTestLog("Verify Properties Private Tag", "Verifying the New Private Tags is displayed",
				Status.PASS);
		Utility_Functions.timeWait(5);
		Utility_Functions.xWaitForElementPresent(driver, privateTagName, 3);
		Utility_Functions.xClick(driver, privateTagName, true);
		report.updateTestLog("Verify Properties Private Tag", "Verifying the New Private Tag name is displayed",
				Status.PASS);
		Utility_Functions.xWaitForElementPresent(driver, privateTagName, 3);
		Utility_Functions.xSendKeys(driver, privateTagName, "Test_" + Utility_Functions.xGenerateAlphaNumericString());
		report.updateTestLog("Verify Properties Private Tag", "Verifying the Private Tag name is entered", Status.PASS);
		Utility_Functions.xWaitForElementPresent(driver, saveNewPrivateTag, 3);
		Utility_Functions.xClick(driver, saveNewPrivateTag, true);
		report.updateTestLog("Verify Properties Private Tag", "Verifying the Private Tag name is entered and saved",
				Status.PASS);
		Utility_Functions.timeWait(5);
		Utility_Functions.xScrollWindow(driver);
		Utility_Functions.timeWait(1);
		Utility_Functions.xScrollWindowTop(driver);
		Utility_Functions.timeWait(2);
		Utility_Functions.xWaitForElementPresent(driver, newPropertiesDetailsPage, 3);
		Utility_Functions.xClick(driver, newPropertiesDetailsPage, true);
		report.updateTestLog("Verify Properties Private Tag", "Verifying the New Property is displayed", Status.PASS);
		Utility_Functions.timeWait(2);
		Utility_Functions.xWaitForElementPresent(driver, newPropertiesDetailsPage, 3);
		SearchTextSOQL property = new SearchTextSOQL(scriptHelper);
		String propertyName = property.fetchRecord("Property__c", "Name");
		searchPropertyWithPrivateTag.sendKeys(propertyName);
		// Utility_Functions.xSendKeys(driver,newPropertiesDetailsPage, "T");
		searchPropertyWithPrivateTag.sendKeys(Keys.ARROW_DOWN);
		searchPropertyWithPrivateTag.sendKeys(Keys.ENTER);
		report.updateTestLog("Verify Properties Private Tag",
				"Verifying the Property name is entered in the new property page", Status.PASS);
		Utility_Functions.xWaitForElementPresent(driver, savePropertyPrivateTag, 3);
		Utility_Functions.xClick(driver, savePropertyPrivateTag, true);
		report.updateTestLog("Verify Properties Private Tag",
				"Verifying the Property name is entered and new property is saved", Status.PASS);

	}
	

	public void verifyBulkTaggingFunctionality() {

		Utility_Functions.xWaitForElementPresent(driver, menu_More, 3);
		Utility_Functions.xClick(driver, menu_More, true);
		Utility_Functions.xWaitForElementPresent(driver, bulkTagging, 3);
		Utility_Functions.xClick(driver, bulkTagging, true);
		Utility_Functions.timeWait(5);
		Utility_Functions.xSwitchtoFrame(driver, accountSearch);
		Utility_Functions.timeWait(5);
		Utility_Functions.xWaitForElementPresent(driver, accountSearch, 3);
		Utility_Functions.xClick(driver, accountSearch, true);
		Utility_Functions.xSendKeys(driver, accountSearch, "Test");
		Utility_Functions.xWaitForElementPresent(driver, searchProperty, 3);
		Utility_Functions.xClick(driver, searchProperty, true);
		Utility_Functions.timeWait(2);

	}

	public void bulkTaggingFunctionality() {

		Utility_Functions.xWaitForElementPresent(driver, menu_More, 3);
		Utility_Functions.xClick(driver, menu_More, true);
		Utility_Functions.xWaitForElementPresent(driver, bulkTagging, 3);
		Utility_Functions.xClick(driver, bulkTagging, true);
		Utility_Functions.timeWait(5);
		Utility_Functions.xSwitchtoFrame(driver, accountSearch);
		Utility_Functions.timeWait(5);
		Utility_Functions.xWaitForElementPresent(driver, accountSearch, 3);
		Utility_Functions.xClick(driver, accountSearch, true);
		Utility_Functions.xSendKeys(driver, accountSearch, "Test");
		Utility_Functions.xWaitForElementPresent(driver, searchProperty, 3);
		Utility_Functions.xClick(driver, searchProperty, true);
		Utility_Functions.timeWait(3);
		for (int i = 1; i <= 3; i++) {
			WebElement element = driver.findElement(By
					.xpath("//h2[contains(text(),'Property Detail')]/parent::div/following-sibling::div/span/table/tbody/tr["
							+ i + "]/td/label/input[@type='checkbox']"));
			Utility_Functions.xClick(driver, element, true);
		}

	}
}