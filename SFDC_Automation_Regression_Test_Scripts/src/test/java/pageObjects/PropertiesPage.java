package pageObjects;

import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import com.cognizant.Craft.ReusableLibrary;
import com.cognizant.Craft.ScriptHelper;
import com.cognizant.framework.Status;
import pagesAPI.EstablishConnection;
import pagesAPI.SearchTextSOQL;
import supportLibraries.SF_UtilityFunctions;
import supportLibraries.Utility_Functions;

public class PropertiesPage extends ReusableLibrary {
	/*
	 * Constructor to initialize the business component library
	 *
	 * @param scriptHelper The {@link ScriptHelper} object passed from the
	 * {@link DriverScript}
	 */

	public PropertiesPage(ScriptHelper scriptHelper) {
		super(scriptHelper);
		PageFactory.initElements(driver.getWebDriver(), this);
		// new WebDriverUtil(driver);
		// Utility_Functions utility = new Utility_Functions(scriptHelper);
	}

	/**
	 * Page Objects for navigateProperties function
	 *
	 * @author Vishnuvardhan
	 *
	 */

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

	DateFormat dateFormat;
	// DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
	Date date = new Date();

	LoginPage loginPage = new LoginPage(scriptHelper);
	Actions actions = new Actions(driver.getWebDriver());
	ActivityPage activityPage = new ActivityPage(scriptHelper);
	EstablishConnection establishConnection = new EstablishConnection(scriptHelper);
	SF_UtilityFunctions sf_UtilityFunctions = new SF_UtilityFunctions(scriptHelper);

	/**
	 * Function for navigating to Properties section
	 *
	 * @author Vishnuvardhan
	 *
	 */

	public void navigateProperties() {
		try {
			sf_UtilityFunctions.oneAppNavigationTab("Properties");
		} catch (Exception e) {
			sf_UtilityFunctions.oneAppNavigationTab("More");
			try {
				Utility_Functions.xWaitForElementPresent(driver, properties, 2);
				Utility_Functions.xClick(driver, properties, true);
			} catch (Exception e1) {
				Utility_Functions.xWaitForElementPresent(driver, propertiesEnv, 2);
				Utility_Functions.xClick(driver, propertiesEnv, true);
			}
		}
	}
	
	/**
	 * Function for selecting the property from the list of properties
	 *
	 * @author Vishnuvardhan
	 *
	 */

	public void selectProperty() {
		navigateProperties();
		sf_UtilityFunctions.selectExisitingObjectRecord("Property Name");
	}


	/**
	 * Function for navigating to New Property
	 *
	 * @author Vishnuvardhan
	 *
	 */
	public void navigateNewPropertyPage() {
		navigateProperties();
		sf_UtilityFunctions.selectAction("New");
		Utility_Functions.xSwitchtoFrame(driver, propertyInformationFrame);
	}

	/**
	 * Validating the Customer Property Page headers
	 *
	 * @author Vishnuvardhan
	 *
	 */

	static List<String> adminPropertyHeaderList = new ArrayList<String>();

	public void adminHeaderList() {
		adminPropertyHeaderList.add("Property Information");
		adminPropertyHeaderList.add("Address Information");
		adminPropertyHeaderList.add("Property Financials");
		adminPropertyHeaderList.add("Property Summary");
		adminPropertyHeaderList.add("Property Management");
		adminPropertyHeaderList.add("Asset Management");
		adminPropertyHeaderList.add("Listing Management");
		System.out.println("Propety page contains the header section:::" + adminPropertyHeaderList);
	}

	public void validateCustomPropertyPage() {
		verifyUnitsOfMeasurePickListValues();
		navigateProperties();
		sf_UtilityFunctions.selectAction("New");
		Utility_Functions.xSwitchtoFrame(driver, propertyInformationFrame);
		Utility_Functions.timeWait(2);
		Utility_Functions.xWaitForElementPresent(driver, buildingPropertyName, 3);
		Utility_Functions.xClick(driver, buildingPropertyName, true);
		adminHeaderList();
		Utility_Functions.timeWait(4);
		List<WebElement> propertyHeaderList = driver.findElements(By.xpath("//h2[contains(@class,'heading') and contains(@class,'large')]"));
		List<String> headerCount = Utility_Functions.xValidateFieldsPresentonPage(adminPropertyHeaderList, propertyHeaderList, "Property Header section is present");
		if (headerCount.size() == 0) {
			report.updateTestLog("Property Information page",
					"Property Information page is having all header sections::", Status.PASS);
		} else {
			report.updateTestLog("Property Information page",
					"Property Information page is not having all the header sections::", Status.FAIL);
		}
		Utility_Functions.xScrollWindow(driver);
		Utility_Functions.timeWait(1);
		Utility_Functions.xScrollWindowTop(driver);
		Utility_Functions.timeWait(1);
		validatePropertyFieldsSection();
		createProperty();
	}

	/**
	 * Validating the Customer Property Page fields
	 *
	 * @author Vishnuvardhan
	 *
	 */

	static List<String> adminPropertyInformationLabelList = new ArrayList<String>();
	static List<String> adminAddressInformationLabelList = new ArrayList<String>();
	static List<String> adminPropertyFinancialsLabelList = new ArrayList<String>();
	static List<String> adminPropertySummaryLabelList = new ArrayList<String>();
	static List<String> adminPropertyManagementLabelList = new ArrayList<String>();
	static List<String> adminAssetManagementLabelList = new ArrayList<String>();
	static List<String> adminListingMangementLabelList = new ArrayList<String>();

	public void adminPropertyInformationLabelList() {
		adminPropertyInformationLabelList.add("Building/Property Name");
		adminPropertyInformationLabelList.add("Property Website");
		adminPropertyInformationLabelList.add("Record Type");
		adminPropertyInformationLabelList.add("Stacking URL");
		adminPropertyInformationLabelList.add("GRID Property Record Link");
		System.out.println("Property Information header section contains the fields:::" + adminPropertyInformationLabelList);
	}

	public void adminAddressInformationLabelList() {
		adminAddressInformationLabelList.add("Country");
		adminAddressInformationLabelList.add("Street");
		adminAddressInformationLabelList.add("City");
		adminAddressInformationLabelList.add("State/Province");
		adminAddressInformationLabelList.add("Zip/Postal Code");
		adminAddressInformationLabelList.add("Region");
		adminAddressInformationLabelList.add("Market");
		adminAddressInformationLabelList.add("Sub Market");
		adminAddressInformationLabelList.add("District");
		adminAddressInformationLabelList.add("County");
		System.out.println("Address Information section contains the fields:::" + adminPropertyInformationLabelList);
	}

	public void adminPropertyFinancialsLabelList() {
		adminPropertyFinancialsLabelList.add("Last Purchase/Sale Price");
		adminPropertyFinancialsLabelList.add("Currency ISO Code");
		adminPropertyFinancialsLabelList.add("Last Purchase/Sale Date");
		System.out.println("Property Financials section contains the fields:::" + adminPropertyFinancialsLabelList);
	}

	public void adminPropertySummaryLabelList() {
		adminPropertySummaryLabelList.add("# of Buildings");
		adminPropertySummaryLabelList.add("# of Floors");
		adminPropertySummaryLabelList.add("Building Status");
		adminPropertySummaryLabelList.add("Local Property Name");
		adminPropertySummaryLabelList.add("Month Built");
		adminPropertySummaryLabelList.add("Year Built");
		adminPropertySummaryLabelList.add("Year Renovated");
		adminPropertySummaryLabelList.add("Occupancy Percent");
		adminPropertySummaryLabelList.add("Construction Type");
		adminPropertySummaryLabelList.add("Location");
		adminPropertySummaryLabelList.add("Owner Occupied");
		adminPropertySummaryLabelList.add("Vacant");
		adminPropertySummaryLabelList.add("Class");
		adminPropertySummaryLabelList.add("Net Rentable Area");
		adminPropertySummaryLabelList.add("Total Size");
		adminPropertySummaryLabelList.add("Units of Measure");
		adminPropertySummaryLabelList.add("Total # of Units");
		adminPropertySummaryLabelList.add("Unit of Comparison");
		adminPropertySummaryLabelList.add("Land Size (Acres)");
		adminPropertySummaryLabelList.add("Tenancy");
		System.out.println("Property Summary section contains the fields:::" + adminPropertySummaryLabelList);
	}

	public void adminPropertyManagementLabelList() {
		adminPropertyManagementLabelList.add("Company");
		adminPropertyManagementLabelList.add("Address");
		adminPropertyManagementLabelList.add("Contact Name");
		adminPropertyManagementLabelList.add("Phone");
		adminPropertyManagementLabelList.add("Email");
		System.out.println("Property Management section contains the fields:::" + adminPropertyManagementLabelList);
	}

	public void adminAssetManagementLabelList() {
		adminAssetManagementLabelList.add("Company");
		adminAssetManagementLabelList.add("Address");
		adminAssetManagementLabelList.add("Contact Name");
		adminAssetManagementLabelList.add("Phone");
		adminAssetManagementLabelList.add("Email");
		System.out.println("Asset Management section contains the fields:::" + adminAssetManagementLabelList);
	}

	public void adminListingMangementLabelList() {
		adminListingMangementLabelList.add("Company");
		adminListingMangementLabelList.add("Address");
		adminListingMangementLabelList.add("Contact Name");
		adminListingMangementLabelList.add("Phone");
		adminListingMangementLabelList.add("Email");
		System.out.println("Asset Management section contains the fields:::" + adminAssetManagementLabelList);
	}

	/**
	 * Validating the Property Header Fields Section
	 *
	 * @author Vishnuvardhan
	 *
	 */

	public void validatePropertyFieldsSection() {
		adminPropertyInformationLabelList();
		List<WebElement> propertyInformationFields = driver.findElements(By.xpath(
				"//h2[text()='Property Information']/parent::div/parent::div/div[contains(@class,'slds-medium-size--1-of-1')]/div/label"));
		sf_UtilityFunctions.validateHeaderSectionFields(adminPropertyInformationLabelList, propertyInformationFields,
				"Property Information Section");

		adminAddressInformationLabelList();
		List<WebElement> AddressInformationFields = driver.findElements(By.xpath(
				"//h2[text()='Address Information']/parent::div/parent::div/div[contains(@class,'slds-medium-size--1-of-1')]/div/label"));
		sf_UtilityFunctions.validateHeaderSectionFields(adminAddressInformationLabelList, AddressInformationFields,
				"Address Information Section");

		adminPropertyFinancialsLabelList();
		List<WebElement> propetyFinancialsFields = driver.findElements(By.xpath(
				"//h2[text()='Property Financials']/parent::div/parent::div/div[contains(@class,'slds-medium-size--1-of-1')]/div/label"));
		sf_UtilityFunctions.validateHeaderSectionFields(adminPropertyFinancialsLabelList, propetyFinancialsFields,
				"Property Financials Section");

		adminPropertySummaryLabelList();
		List<WebElement> propertySummaryFields = driver.findElements(By.xpath(
				"//h2[text()='Property Summary']/parent::div/parent::div/div[contains(@class,'slds-medium-size--1-of-1')]/div/label"));
		sf_UtilityFunctions.validateHeaderSectionFields(adminPropertySummaryLabelList, propertySummaryFields,
				"Property Summary Section");

		adminPropertyManagementLabelList();
		List<WebElement> propertyManagementFields = driver.findElements(By.xpath(
				"//h2[text()='Property Management']/parent::div/parent::div/div[contains(@class,'slds-medium-size--1-of-1')]/div/label"));
		sf_UtilityFunctions.validateHeaderSectionFields(adminPropertyManagementLabelList, propertyManagementFields,
				"Property Mangement Section");

		adminAssetManagementLabelList();
		List<WebElement> assetManagementFields = driver.findElements(By.xpath(
				"//h2[text()='Listing Management']/parent::div/parent::div/div[contains(@class,'slds-medium-size--1-of-1')]/div/label"));
		sf_UtilityFunctions.validateHeaderSectionFields(adminAssetManagementLabelList, assetManagementFields,
				"Asset Management Section");

		adminListingMangementLabelList();
		List<WebElement> listingManagementFields = driver.findElements(By.xpath(
				"//h2[text()='Asset Management']/parent::div/parent::div/div[contains(@class,'slds-medium-size--1-of-1')]/div/label"));
		sf_UtilityFunctions.validateHeaderSectionFields(adminListingMangementLabelList, listingManagementFields,
				"Listing Mangement Section");
	}

	/**
	 * Function for Creating a property
	 *
	 * @author Vishnuvardhan
	 *
	 */

	public void createProperty() {
		Utility_Functions.timeWait(1);
		buildingPropertyName.clear();
		Utility_Functions.xWaitForElementPresent(driver, buildingPropertyName, 3);
		Utility_Functions.xSendKeys(driver, buildingPropertyName, dataTable.getData("General_Data", "Building/ Property Name"));
		Utility_Functions.xScrollWindowOnce(driver);
		Utility_Functions.timeWait(1);
		Utility_Functions.xSelectDropdownByIndex(countryDropdown, 229);
		Utility_Functions.xWaitForElementPresent(driver, street, 3);
		Utility_Functions.xSendKeys(driver, street, dataTable.getData("General_Data", "Street"));
		Utility_Functions.xWaitForElementPresent(driver, city, 3);
		Utility_Functions.xSendKeys(driver, city, dataTable.getData("General_Data", "City"));
		Utility_Functions.xWaitForElementPresent(driver, stateDropdown, 3);
		Utility_Functions.xSelectDropdownByIndex(stateDropdown, 54);
		Utility_Functions.xWaitForElementPresent(driver, saveProperty, 3);
		Utility_Functions.xClick(driver, saveProperty, true);
		Utility_Functions.timeWait(4);
		driver.switchTo().defaultContent();
		if (createdProperty.getText().contains(dataTable.getData("General_Data", "Street"))) {
			report.updateTestLog("Save Property", "Property has been created successfully :::", Status.PASS);
		} else {
			report.updateTestLog("Save Property", "Unable to save the property:::", Status.FAIL);
		}
	}


	/**
	 * Validating the Campaigns tab present in the drop down after logging in
	 *
	 * @author Vishnuvardhan
	 *
	 */
	public void validateCampaignsTab() {
		Utility_Functions.xWaitForElementPresent(driver, menu_More, 3);
		Utility_Functions.xClick(driver, menu_More, true);
		if (dataTable.getData("General_Data", "TC_ID").contains("OBAPACBrokerCampaignsTab")) {
			try {
				Utility_Functions.xWaitForElementPresent(driver, campaigns, 2);
			} catch (Exception e) {
				Utility_Functions.xWaitForElementPresent(driver, campaignsEnv, 2);
			}
			try {
				if (campaigns.isDisplayed()) {
					report.updateTestLog("Verify Campaigns Tab", "Campaigns tab is present in the dropdown:::", Status.PASS);
				} else if (campaignsEnv.isDisplayed()) {
					report.updateTestLog("Verify Campaigns Tab", "Campaigns tab is present in the dropdown:::", Status.PASS);
				} else {
					report.updateTestLog("Verify Campaigns Tab", "Campaigns tab doesn't present in the dropdown:::", Status.FAIL);
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else if (dataTable.getData("General_Data", "TC_ID").contains("OBAMERBrokerCampaignsTab")) {
			int count = 0;
			if (dataTable.getData("General_Data", "TC_ID").contains("OBAMERBrokerCampaignsTab")) {
				List<WebElement> overFlowList = driver.findElements(By.xpath("//div[@class='overflowList']//a"));
				for (WebElement element : overFlowList) {
					if (element.getText().equals("Campaigns")) {
						count++;
						System.out.println(element.getText());
					}
				}
				if (count == 0) {
					report.updateTestLog("Verify Campaigns Tab", "Campaigns tab is not present in the dropdown:::", Status.PASS);
				} else {
					report.updateTestLog("Verify Campaigns Tab", "Campaigns tab is present in the dropdown:::", Status.FAIL);
				}
			}
		}

	}

	/**
	 * Validating the Unit of Measure values list
	 *
	 * @author Vishnuvardhan
	 *
	 */

	static List<String> unitOfMeasureValuesList = new ArrayList<String>();

	public void unitOfMeasureFields() {
		if(!dataTable.getData("General_Data", "TC_ID").contains("Admin")) {
			unitOfMeasureValuesList.add("--None--");
			unitOfMeasureValuesList.add("Acres");
			unitOfMeasureValuesList.add("Hectares");
			unitOfMeasureValuesList.add("Square Feet");
			unitOfMeasureValuesList.add("Square Meters");
			unitOfMeasureValuesList.add("Square Yards");
			unitOfMeasureValuesList.add("Tsubo");			
		} 		
		if(dataTable.getData("General_Data", "TC_ID").contains("Admin")) {
			unitOfMeasureValuesList.add("--None--");
			unitOfMeasureValuesList.add("Acres");
			unitOfMeasureValuesList.add("Hectares");
			unitOfMeasureValuesList.add("Square Feet");
			unitOfMeasureValuesList.add("Square Meters");
			unitOfMeasureValuesList.add("Square Yards");
			unitOfMeasureValuesList.add("Tsubo");	
			unitOfMeasureValuesList.add("None");
			unitOfMeasureValuesList.add("Parking Lots");
			unitOfMeasureValuesList.add("People");
			unitOfMeasureValuesList.add("Ping");
			unitOfMeasureValuesList.add("Pyeong");	
		}		
		System.out.println("Unit of Measure values are " + unitOfMeasureValuesList);
	}

	public void verifyUnitsOfMeasurePickListValues() {
		unitOfMeasureFields();
		List<String> unitsOfMeasurePickListValues = establishConnection.establishMetaDataConnection("Property__c", "AMER_Property", "Units_of_Measure__c");
		List<String> unitsOfMeasureList = new ArrayList<String>();
		unitsOfMeasureList = Utility_Functions.xValidatePickListValuesPage(unitsOfMeasurePickListValues, unitOfMeasureValuesList, "Units of Measure pick list values");
		if (unitsOfMeasureList.size()!=0) {
			report.updateTestLog("Verify Units of Measure Picklist values", "All the values are not present in the Use Type Pick List:::" + unitsOfMeasureList, Status.FAIL);
		} else {
			report.updateTestLog("Verify Units of Measure Picklist values", "All the values are present in the Use Type Pick List ", Status.PASS);
		}
	}
	
	/**
	 * Validating the activity Lightning Time line fields
	 *
	 * @author Vishnuvardhan
	 *
	 */

	public void propertiesActivityLightningTimeline() {
		selectProperty();
		ActivityPage activityPage = new ActivityPage(scriptHelper);
		activityPage.validateActivityTimeLine();
	}

	/**
	 * Validating the Properties Private Tag functionality
	 *
	 * @author Vishnuvardhan
	 *
	 */

	public void propertiesPrivateTagFunctionality() {
		navigateProperties();
		sf_UtilityFunctions.selectAction("New");
		Utility_Functions.xSwitchtoFrame(driver, propertyInformationFrame);
		Utility_Functions.timeWait(2);
		Utility_Functions.xWaitForElementPresent(driver, buildingPropertyName, 3);
		Utility_Functions.xClick(driver, buildingPropertyName, true);
		createProperty();		
		driver.navigate().refresh();
		Utility_Functions.timeWait(4);
		Utility_Functions.xSwitchtoFrame(driver, addTag);
		Utility_Functions.xWaitForElementPresent(driver, addTag, 3);
		Utility_Functions.xClick(driver, addTag, true);
		Utility_Functions.xWaitForElementPresent(driver, privatetag, 3);
		Utility_Functions.xSendKeys(driver, privatetag, "Test Automation");
		Utility_Functions.xWaitForElementPresent(driver, savePrivateTag, 3);
		Utility_Functions.xClick(driver, savePrivateTag, true);
		if (savePrivateTag.isDisplayed()) {
			report.updateTestLog("Verify Private Tag", "Private Tag is saved successfully:::", Status.PASS);
		} else {
			report.updateTestLog("Verify Private Tag", "Private Tag save functionality failed:::", Status.FAIL);
		}
	}

	

	/**
	 * Validating the New Property Page Property Type field
	 *
	 * @author Vishnuvardhan
	 *
	 */

	static ArrayList<String> newPropertyTypeList = new ArrayList<String>();

	public void newPropertyTypeFields() {
		if(dataTable.getData("General_Data", "TC_ID").contains("AMER")) {
			newPropertyTypeList.add("Agribusiness");
			newPropertyTypeList.add("Health Care");
			newPropertyTypeList.add("Hotel");
			newPropertyTypeList.add("Industrial");
			newPropertyTypeList.add("Land");
			newPropertyTypeList.add("Office");
			newPropertyTypeList.add("Residential");
			newPropertyTypeList.add("Retail");
			newPropertyTypeList.add("Specialty");
		} else if(dataTable.getData("General_Data", "TC_ID").contains("APAC")) {
			newPropertyTypeList.add("Hotel");
			newPropertyTypeList.add("Land");
			newPropertyTypeList.add("Mixed-use");
			newPropertyTypeList.add("Multi-use Portfolio");
			newPropertyTypeList.add("Multifamily");
			newPropertyTypeList.add("Office");
			newPropertyTypeList.add("Residential");
			newPropertyTypeList.add("Retail"); 
			newPropertyTypeList.add("Industrial/Logistics");
		}
		
		System.out.println("New Property Page Property Type fields are " + newPropertyTypeList);
	}

	public void newPropertiesPropertyType() {
		newPropertyTypeFields();
		List<String> propertyTypePickListValues = null;
		if(dataTable.getData("General_Data", "TC_ID").contains("AMER")) {
			propertyTypePickListValues = sf_UtilityFunctions.getPickListValues("Property__c", "AMER_Property", "Property_Type__c");
		} else if(dataTable.getData("General_Data", "TC_ID").contains("APAC")) {
			propertyTypePickListValues = sf_UtilityFunctions.getPickListValues("Property__c", "APAC_Property", "Property_Type__c");
		}
		List<String> propertyTypeList = new ArrayList<String>();
		propertyTypeList = Utility_Functions.xValidatePickListValuesPage(propertyTypePickListValues, newPropertyTypeList, "Property Type pick list values");
		if (propertyTypeList.size()!=0) {
			report.updateTestLog("Verify Property Type picklist values", "All the values are not present in the Property Type Pick List:::" + propertyTypeList, Status.FAIL);
		} else {
			report.updateTestLog("Verify Property Type picklist values", "All the values are present in the Property Type Pick List ", Status.PASS);
		}		
	}

	/**
	 * Validating the Property Type field value
	 *
	 * @author Vishnuvardhan
	 *
	 */

	public void verifyPropertyTypeFieldValue() {
		navigateNewPropertyPage();
		Utility_Functions.xWaitForElementPresent(driver, propertyName, 2);
		Utility_Functions.xSendKeys(driver, propertyName, "Test Automation Subject_" + Utility_Functions.xGenerateAlphaNumericString());
		Utility_Functions.timeWait(3);
		Utility_Functions.xScrollWindow(driver);
		Utility_Functions.timeWait(1);
		Utility_Functions.xScrollWindowTop(driver);
		Utility_Functions.timeWait(2);
		Utility_Functions.xWaitForElementPresent(driver, propertyCountry, 3);
		Utility_Functions.xClick(driver, propertyCountry, true);
		Utility_Functions.xWaitForElementPresent(driver, selectPropertyCountry, 3);
		Utility_Functions.xClick(driver, selectPropertyCountry, true);
		Utility_Functions.xWaitForElementPresent(driver, propertyStreet, 3);
		Utility_Functions.xSendKeys(driver, propertyStreet, dataTable.getData("General_Data", "Street"));
		Utility_Functions.xWaitForElementPresent(driver, propertyCity, 3);
		Utility_Functions.xSendKeys(driver, propertyCity, dataTable.getData("General_Data", "City"));
		Utility_Functions.xWaitForElementPresent(driver, statePickList, 3);
		Utility_Functions.xClick(driver, statePickList, true);
		Utility_Functions.xWaitForElementPresent(driver, selectPropertyState, 3);
		Utility_Functions.xClick(driver, selectPropertyState, true);
		Utility_Functions.timeWait(2);
		WebElement elementHidden = driver.findElement(By.xpath("//select[contains(@id,'propertyEditForm:APACPropertyType')]/parent::div"));
		Utility_Functions.xClick(driver, elementHidden, true);
		WebElement elementSelectHidden = driver.findElement(By.xpath("//select[contains(@id,'propertyEditForm:APACPropertyType')]/parent::div/select"));
		Utility_Functions.xClick(driver, elementSelectHidden, true);
		for (int i = 1; i <= newPropertyTypeList.size(); i++) {
			String optionValue = driver.findElement(By.xpath("//select[contains(@id,'propertyEditForm:APACPropertyType')]/option[" + i + "]")).getAttribute("value");
			if (optionValue.equals("Industrial")) {
				driver.findElement(By.xpath("//select[contains(@id,'propertyEditForm:APACPropertyType')]/option[" + "'"	+ optionValue + "'" + "]")).click();
				break;
			}
		}
		Utility_Functions.xWaitForElementPresent(driver, addValuetoCheckList, 2);
		Utility_Functions.xClick(driver, addValuetoCheckList, true);
		Utility_Functions.xWaitForElementPresent(driver, buildingClass, 3);
		Utility_Functions.xClick(driver, buildingClass, true);
		Utility_Functions.xWaitForElementPresent(driver, buildingClassValue, 3);
		Utility_Functions.xClick(driver, buildingClassValue, true);
		Utility_Functions.xWaitForElementPresent(driver, saveProperty, 3);
		Utility_Functions.xClick(driver, saveProperty, true);
		Utility_Functions.timeWait(2);
		if (details.isDisplayed()) {
			report.updateTestLog("Verify Editing the Existing Account", "The existing account can be edited and saved successfully", Status.PASS);
		} else {
			report.updateTestLog("Verify Editing the Existing Account", "The existing account cannot be edited and saved successfully", Status.FAIL);
		}
	}

	

	/**
	 * Validating the Properties Preferences Pyeong Value
	 *
	 * @author Vishnuvardhan
	 *
	 */
	
	public void verifyPropertiesPreferencesPyeongValue() {
		sf_UtilityFunctions.verifyPickListValues("Pyeong", "Property_Preferences__c", "France_Property_Preferences", "APAC_Area_UOM__c");
	}

	/**
	 * Validating the Properties Preferences Ping Value
	 *
	 * @author Vishnuvardhan
	 *
	 */
	public void verifyPropertiesPreferencesPingValue() {
		sf_UtilityFunctions.verifyPickListValues("Ping", "Property_Preferences__c", "France_Property_Preferences", "APAC_Area_UOM__c");
	}
	
	/**
	 * Validating the Project Enquiries for the Pyeong Value
	 *
	 * @author Vishnuvardhan
	 *
	 */
	public void verifyProjectEnquiriesPyeongValue() {
		sf_UtilityFunctions.verifyPickListValues("Pyeong", "APAC_Project_Enquiries__c", "APAC_Project_Enquiry", "APAC_Total_Area_UOM__c");
	}

	
	/**
	 * Validating the Project Enquiries for the Ping Value
	 *
	 * @author Vishnuvardhan
	 *
	 */
	public void verifyProjectEnquiriesPingValue() {
		sf_UtilityFunctions.verifyPickListValues("Ping", "APAC_Project_Enquiries__c", "APAC_Project_Enquiry", "APAC_Total_Area_UOM__c");
	}	
	
	/**
	 * Validating the Properties Pyeong Value
	 *
	 * @author Vishnuvardhan
	 *
	 */
	public void verifyPropertiesPyeongValue() {
		sf_UtilityFunctions.verifyPickListValues("Pyeong", "Property__c", "APAC_Property", "Units_of_Measure__c");
	}

	/**
	 * Validating the Properties Ping Value
	 *
	 * @author Vishnuvardhan
	 *
	 */
	public void verifyPropertiesPingValue() {
		sf_UtilityFunctions.verifyPickListValues("Ping", "Property__c", "APAC_Property", "Units_of_Measure__c");			
	}

	/**
	 * Validating the Properties Preferences for the Preference Type values
	 *
	 * @author Vishnuvardhan
	 *
	 */
	static ArrayList<String> preferenceTypePickList = new ArrayList<String>();

	public void preferenceType() {
		preferenceTypePickList.add("--None--");
		preferenceTypePickList.add("Sale");
		preferenceTypePickList.add("Lease");
		System.out.println("Preference Type Pick List values are " + preferenceTypePickList);
	}

	public void verifyPreferenceTypevalues() {
		preferenceType();
		List<String> preferenceTypePickListValues = sf_UtilityFunctions.getPickListValues("Property_Preferences__c", "France_Property_Preferences", "APAC_Preference_Type__c");
		List<String> preferenceTypeList = new ArrayList<String>();
		preferenceTypeList = Utility_Functions.xValidatePickListValuesPage(preferenceTypePickListValues, preferenceTypePickList, "Preferecne Type pick list values");
		if (preferenceTypeList.size()!=0) {
			report.updateTestLog("Verify Prference Type picklist values", "All the values are not present in the Prference Type Pick List:::" + preferenceTypeList, Status.FAIL);
		} else {
			report.updateTestLog("Verify Prference Type picklist values", "All the values are present in the Prference Type Pick List ", Status.PASS);
		}	
	}

	/**
	 * Validating the Project Enquiry page fields
	 *
	 * @author Vishnuvardhan
	 *
	 */
	static ArrayList<String> projectEnquiriesFieldsList = new ArrayList<String>();

	public void projectEnquiriesFields() {
		projectEnquiriesFieldsList.add("Name");
		projectEnquiriesFieldsList.add("APAC_Candidate__c");
		projectEnquiriesFieldsList.add("APAC_Enquiry_Contact__c");
		projectEnquiriesFieldsList.add("Enquiry_Primary_Campaign__c");
		projectEnquiriesFieldsList.add("APAC_Confidential__c");
		projectEnquiriesFieldsList.add("APAC_Rating__c");
		projectEnquiriesFieldsList.add("APAC_Status__c");
		projectEnquiriesFieldsList.add("APAC_Source__c");
		projectEnquiriesFieldsList.add("Information_Memorandum_Sent_Date__c");
		projectEnquiriesFieldsList.add("APAC_Inspection_Date__c");
		projectEnquiriesFieldsList.add("Confidentiality_Agreement_Executed_Date__c");
		projectEnquiriesFieldsList.add("Due_Diligence_Start_Date__c");
		projectEnquiriesFieldsList.add("Submitted_Offer_Date__c");
		projectEnquiriesFieldsList.add("APAC_Client_Feedback__c");
		projectEnquiriesFieldsList.add("APAC_Broker_Feedback__c");
		projectEnquiriesFieldsList.add("Enquiry_Contact_Phone__c");
		projectEnquiriesFieldsList.add("Enquiry_Contact_Email__c");
		projectEnquiriesFieldsList.add("CreatedById");
		projectEnquiriesFieldsList.add("LastModifiedById");
		projectEnquiriesFieldsList.add("OwnerId");
		projectEnquiriesFieldsList.add("Enquiry_Opportunity__c");
		projectEnquiriesFieldsList.add("Enquiry_Property__c");
		projectEnquiriesFieldsList.add("RecordTypeId");
		
		/*projectEnquiriesFieldsList.add("Project Enquiry Name");
		projectEnquiriesFieldsList.add("Enquiry Opportunity");
		projectEnquiriesFieldsList.add("Enquiry Account");
		projectEnquiriesFieldsList.add("Information Memorandum Sent Date");
		projectEnquiriesFieldsList.add("Enquiry Contact");
		projectEnquiriesFieldsList.add("Inspection Date");
		projectEnquiriesFieldsList.add("Enquiry Primary Campaign");
		projectEnquiriesFieldsList.add("Confidentiality Agreement Executed Date");
		projectEnquiriesFieldsList.add("Confidential");
		projectEnquiriesFieldsList.add("Due Diligence Start Date");
		projectEnquiriesFieldsList.add("Data Room Access");
		projectEnquiriesFieldsList.add("Client Feedback");
		projectEnquiriesFieldsList.add("Broker Feedback");*/
		System.out.println("Project Enquiries fields are " + projectEnquiriesFieldsList);
	}

			
	public void verifyProjectEnquiriesPageFields() {
		projectEnquiriesFields();
		List<String> propertySalesProjectEnquiries = establishConnection.establishMetaDataConnectionPageLayouts("APAC_Project_Enquiries__c", "APAC Property Sales Project Enquiry Layout");
		List<String> propertySalesProjectEnquiriesList = new ArrayList<String>();
		propertySalesProjectEnquiriesList = Utility_Functions.xValidatePickListValuesPage(propertySalesProjectEnquiries, projectEnquiriesFieldsList, "Preferecne Type pick list values");
		if (propertySalesProjectEnquiriesList.size()!=0) {
			report.updateTestLog("Verify Project Enquiries Page Field Labels", "All the labels are not present in the Enquiries Page Field Labels:::" + propertySalesProjectEnquiriesList, Status.FAIL);
		} else {
			report.updateTestLog("Verify Project Enquiries Page Field Labels", "All the labels are present in the Enquiries Page Field Labels", Status.PASS);
		}	
	}

	/**
	 * Validating the Project Enquiries Enhancements
	 *
	 * @author Vishnuvardhan
	 *
	 */

	public void verifyProjectEnquiriesEnhancements() {

		verifyProjectEnquiriesPageFields();

	}

	/**
	 * Validating the Properties edit page
	 *
	 * @author Vishnuvardhan
	 *
	 */

	public void verifyPropertiesEditPage() {

		try {
			Utility_Functions.xWaitForElementPresent(driver, menu_Properties, 3);
			Utility_Functions.xClick(driver, menu_Properties, true);
		} catch (Exception e) {
			Utility_Functions.xWaitForElementPresent(driver, menu_More, 3);
			Utility_Functions.xClick(driver, menu_More, true);
			try {
				Utility_Functions.xWaitForElementPresent(driver, properties, 2);
				Utility_Functions.xClick(driver, properties, true);
			} catch (Exception e1) {
				Utility_Functions.xWaitForElementPresent(driver, propertiesEnv, 2);
				Utility_Functions.xClick(driver, propertiesEnv, true);
			}
		}

		List<WebElement> recentlyViewedpropertiesList = driver
				.findElements(By.xpath("//a[@class='slds-truncate outputLookupLink slds-truncate forceOutputLookup']"));
		Utility_Functions.xclickOnFirstElementfromList(recentlyViewedpropertiesList);
		Utility_Functions.xWaitForElementPresent(driver, showMoreActions, 2);
		Utility_Functions.xClick(driver, showMoreActions, true);
		Utility_Functions.xWaitForElementPresent(driver, edit, 2);
		actions.moveToElement(edit);
		actions.click();
		actions.build().perform();
		Utility_Functions.timeWait(3);
		Utility_Functions.xSwitchtoFrame(driver, saveProperty);
		Utility_Functions.timeWait(5);
		Utility_Functions.xScrollWindow(driver);
		Utility_Functions.timeWait(1);
		Utility_Functions.xScrollWindowTop(driver);
		Utility_Functions.timeWait(2);
		Select office = new Select(propertyTypeHotel);
		office.selectByVisibleText("Office");
		Utility_Functions.xWaitForElementPresent(driver, addButton, 3);
		Utility_Functions.xClick(driver, addButton, true);
		Utility_Functions.xWaitForElementPresent(driver, commercialBuilding, 3);
		Utility_Functions.xClick(driver, commercialBuilding, true);

	}

	/**
	 * Validating the Properties Preferences creation
	 *
	 * @author Vishnuvardhan
	 *
	 */
	public void verifyPropertiesPreferencesCreation() {

		Utility_Functions.xWaitForElementPresent(driver, menu_More, 3);
		Utility_Functions.xClick(driver, menu_More, true);
		report.updateTestLog("Verify Properties Preferences Pyeong Value", "Verifying More options is displayed",
				Status.PASS);
		Utility_Functions.timeWait(2);
		Utility_Functions.xWaitForElementPresent(driver, more_propertyPreferences, 3);
		Utility_Functions.xClick(driver, more_propertyPreferences, true);
		report.updateTestLog("Verify Properties Preferences Pyeong Value",
				"Verifying Property Preferences is displayed", Status.PASS);
		Utility_Functions.timeWait(2);
		Utility_Functions.xWaitForElementPresent(driver, newPropertiesPreferences, 3);
		Utility_Functions.xClick(driver, newPropertiesPreferences, true);
		report.updateTestLog("Verify Properties Preferences Pyeong Value",
				"Verifying the new Properties Preferences is displayed", Status.PASS);
		Utility_Functions.timeWait(5);
		Utility_Functions.xScrollWindow(driver);
		Utility_Functions.timeWait(1);
		Utility_Functions.xScrollWindowTop(driver);
		Utility_Functions.timeWait(2);

	}

	/**
	 * Validating the Properties Preferences creation
	 *
	 * @author Vishnuvardhan
	 *
	 */
	public void verifyPreferencesPropertiesCreation() {
		Utility_Functions.xWaitForElementPresent(driver, applauncher, 3);
		Utility_Functions.xClick(driver, applauncher, true);
		Utility_Functions.timeWait(2);
		Utility_Functions.xWaitForElementPresent(driver, preferences, 3);
		Utility_Functions.xClick(driver, preferences, true);
		report.updateTestLog("Verify Preferences Property Type ", "Preferences is Displayed ", Status.PASS);
		Utility_Functions.xWaitForElementPresent(driver, newPropertiesPreferences, 3);
		Utility_Functions.xClick(driver, newPropertiesPreferences, true);
		report.updateTestLog("Verify Preferences Property Type ", "Recently viewed Properties are Displayed ",
				Status.PASS);
		Utility_Functions.xWaitForElementPresent(driver, apacPropertyPreferences, 3);
		Utility_Functions.xClick(driver, apacPropertyPreferences, true);
		Utility_Functions.xWaitForElementPresent(driver, nextPropertyPreferences, 3);
		Utility_Functions.xClick(driver, nextPropertyPreferences, true);
		Utility_Functions.timeWait(2);
		Utility_Functions.xWaitForElementPresent(driver, searchContacts, 3);
		Utility_Functions.xSendKeys(driver, searchContacts, "TestAMER CMBroker");
		Utility_Functions.xWaitForElementPresent(driver, contactsValue, 3);
		Utility_Functions.xClick(driver, contactsValue, true);
		Utility_Functions.xWaitForElementPresent(driver, preferenceType, 3);
		Utility_Functions.xClick(driver, preferenceType, true);
		Utility_Functions.xWaitForElementPresent(driver, preferenceTypeValue, 3);
		Utility_Functions.xClick(driver, preferenceTypeValue, true);
		Utility_Functions.xWaitForElementPresent(driver, propertyType, 3);
		Utility_Functions.xClick(driver, propertyType, true);
		Utility_Functions.xWaitForElementPresent(driver, propertyTypeHotelValue, 3);
		Utility_Functions.xClick(driver, propertyTypeHotelValue, true);

	}

	public void propertyTagging() {

		Utility_Functions.xClick(driver, menu_More, true);
		Utility_Functions.xWaitForElementPresent(driver, properties, 3);
		Utility_Functions.xClick(driver, properties, true);
		Utility_Functions.xWaitForElementPresent(driver, recentlyViewed, 3);
		Utility_Functions.xClick(driver, recentlyViewed, true);
		Utility_Functions.xWaitForElementPresent(driver, allProperties, 3);
		Utility_Functions.xClick(driver, allProperties, true);
		Utility_Functions.timeWait(8);
		Utility_Functions.xClick(driver, PropertyList, true);
		Utility_Functions.timeWait(4);
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

	public void propertyPreferenceUpdateClone() {
		Utility_Functions.xWaitForElementPresent(driver, applauncher, 3);
		Utility_Functions.xClick(driver, applauncher, true);
		Utility_Functions.timeWait(2);
		Utility_Functions.xClickHiddenElement(driver, propertyPreferences);
		Utility_Functions.xWaitForElementPresent(driver, recentlyViewed, 3);
		Utility_Functions.xClick(driver, recentlyViewed, true);
		Utility_Functions.xWaitForElementPresent(driver, allPropertyPreferences, 5);
		Utility_Functions.xClick(driver, allPropertyPreferences, true);
		Utility_Functions.timeWait(4);
		Utility_Functions.xClick(driver, allPropertyPreferenceslist, true);
		Utility_Functions.xWaitForElementPresent(driver, editProperty, 3);
		Utility_Functions.xClick(driver, editProperty, true);
		Utility_Functions.xWaitForElementPresent(driver, minimumPriceProperty, 3);
		Utility_Functions.xSendKeys(driver, minimumPriceProperty, "2000");
		Utility_Functions.xClick(driver, savePropertypreference, true);
		Utility_Functions.timeWait(4);
		Utility_Functions.xClick(driver, cloneProperty, true);
		Utility_Functions.xWaitForElementPresent(driver, minimumPriceProperty, 3);
		Utility_Functions.xSendKeys(driver, minimumPriceProperty, "5000");
		// Utility_Functions.xSelectDropdownByValue(hotelStar, "5 star");
		Utility_Functions.xClick(driver, savePropertypreference, true);
		Utility_Functions.xWaitForElementPresent(driver, editProperty, 3);
		if (editProperty.isDisplayed()) {
			System.out.println("Property Preference is updated");
		} else {
			System.out.println("Proeprty Preference is not updated");
		}

	}

	public void addProperty() {

		Utility_Functions.xWaitForElementPresent(driver, menu_More, 3);
		Utility_Functions.xClick(driver, menu_More, true);
		Utility_Functions.xWaitForElementPresent(driver, properties, 2);
		Utility_Functions.xClick(driver, properties, true);

		Utility_Functions.xClick(driver, newProperty, true);
		Utility_Functions.xWaitForElementPresent(driver, nextBtnProperty, 2);

		Utility_Functions.xClick(driver, nextBtnProperty, true);
		Utility_Functions.timeWait(3);
		Utility_Functions.xSwitchtoFrame(driver, buildingPropertyName);
		// Utility_Functions.xSendKeysVisibleListElement(driver,
		// buildingPropertyName1, "Test");
		Utility_Functions.xSendKeys(driver, buildingPropertyName,
				dataTable.getData("General_Data", "Building/ Property Name"));
		Utility_Functions.timeWait(1);
		Utility_Functions.xScrollWindowOnce(driver);
		Utility_Functions.timeWait(1);
		// Utility_Functions.xClick(driver, countryDropdown, true);
		Utility_Functions.xSelectDropdownByIndex(countryDropdown, 229);
		Utility_Functions.timeWait(1);
		Utility_Functions.xSendKeys(driver, street, dataTable.getData("General_Data", "Street"));
		Utility_Functions.timeWait(1);
		Utility_Functions.xSendKeys(driver, city, dataTable.getData("General_Data", "City"));
		Utility_Functions.timeWait(1);
		// Utility_Functions.xClick(driver, stateDropdown, true);
		Utility_Functions.xSelectDropdownByIndex(stateDropdown, 54);
		Utility_Functions.timeWait(1);
		Utility_Functions.xClick(driver, saveProperty, true);
		Utility_Functions.timeWait(5);
		Utility_Functions.xSwitchtoFrame(driver, addBtnTask);

		report.updateTestLog("Verify Property", "The Private is created successfully", Status.PASS);

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
	
	/**
	 * Validating the Properties Private Tags
	 *
	 * @author Vishnuvardhan
	 *
	 */
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
	
	/**
	 * Validating the Bulk Tagging
	 *
	 * @author Vishnuvardhan
	 *
	 */
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
