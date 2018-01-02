package pageObjects;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.cognizant.Craft.ReusableLibrary;
import com.cognizant.Craft.ScriptHelper;
import com.cognizant.framework.Status;
import com.itextpdf.text.log.SysoCounter;

import pagesAPI.SearchTextSOQL;
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

	@FindBy(xpath = "//*[text()='More']")
	WebElement menu_More;

	@FindBy(xpath = "//a[@role='menuitem']/span[contains(@class,'slds-truncate')][text()='Properties']")
	WebElement properties;	

	@FindBy(xpath = "//div[@class='overflowList']//a[@title='Properties'][text()='Properties']")
	WebElement propertiesEnv;	

	@FindBy(xpath = "//div[@class='slds-truncate'][@title='New']")
	WebElement newProperty;	

	@FindBy(xpath = "//*[@id='bottomButtonRow']/input[1]")
	WebElement continueButton;	

	@FindBy(xpath = /*"//div[@class='slds-media']*/ "//*[@value='Save Property']")
	WebElement saveProperty;	

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

	@FindBy(xpath="//*[@id='assignedToBox']")
	WebElement assignedTo;

	@FindBy(xpath="//*[@id='relatedAccountBox']")
	WebElement accountSelected;

	@FindBy(xpath="//select[@class='slds-select']/option[@value='Normal']")
	WebElement priority;

	@FindBy(xpath="//div[@class='slds-form-element__control slds-has-divider--bottom']")
	WebElement owner;

	@FindBy(xpath="//select[@class='slds-select']/option[@value='Open']")
	WebElement status;

	@FindBy(xpath = "//a[@role='menuitem']/span[contains(@class,'slds-truncate')][text()='Campaigns']")
	WebElement campaigns;	

	@FindBy(xpath = "//div[@class='overflowList']//a[@title='Campaigns'][text()='Campaigns']")
	WebElement campaignsEnv;	

	/**
	 * 
	 * 
	 * @author Ramya
	 *
	 */	

	@FindBy(xpath = "//h1//span[text()='Recently Viewed']")
	WebElement recentlyViewed;

	@FindBy(xpath="//span[contains(@class,'virtualAutocompleteOptionText')][text()='All Properties']")
	WebElement allProperties;

	@FindBy(xpath = "//a[@class='tabHeader']//span[text()='Related']")
	WebElement related;

	@FindBy(xpath="//span[contains(@class,'slds-truncate')][text()='Properties']")
	WebElement menu_Properties;

	@FindBy(xpath="//span[contains(text(),'Activities')]/ancestor::article//div[text()='New Activity']")
	WebElement newActivity;

	@FindBy(xpath="//input[@class='slds-input'][@type='text']")
	WebElement subject;

	@FindBy(xpath="//select[@class='slds-select']/option[@value='Private - Client Intelligence']")
	WebElement activityType;

	@FindBy(xpath="// input [@value= 'Save & New']")
	WebElement saveAndNewActivity;

	@FindBy(xpath="//select[@class='slds-select']/option[@value='Private - Initial Meeting']")
	WebElement activityType2;

	@FindBy(xpath="// input [@value= 'Save']")
	WebElement saveActivity;

	@FindBy(xpath="//span[contains(@class, 'slds-text-heading--small slds-truncate') and text() = 'Activities']")
	WebElement relatedActivities;


	@FindBy(xpath="//a[contains(@title,'Show') and contains(@title,'more action')]")
	WebElement selectCreateFollowUpCustomActivity;

	@FindBy(xpath="//div[contains(@title, 'Create Follow-up Custom Activity')]")
	WebElement createCustomActivity;

	@FindBy(xpath="//select[@class='slds-select']/option[@value='Private - Follow-Up Meeting']")
	WebElement activityType3;

	@FindBy(xpath="//span[text()='Send Notification Email']/parent::label/parent::div//input")
	WebElement notificationEmail;

	@FindBy(xpath = "// input [@value= 'Save']")
	WebElement saveNewActivityLayoutPage;

	@FindBy(xpath = "// input [@value= 'Save & New']")
	WebElement saveAndNewActivityLayoutPage;

	@FindBy(xpath = "// input [@value= 'Cancel']")
	WebElement cancelNewActivityLayoutPage;

	@FindBy(xpath = "//ul[@class='slds-button-group slds-m-left--xx-small oneActionsRibbon forceActionsContainer']//li/a/div[text()='New']")
	WebElement newProperties;

	@FindBy(xpath="//label[text()='Building/Property Name']/parent::div/parent::div//div[contains(@class,'requiredInput')]//input[contains(@id,'propertyEditForm')]")
	WebElement propertyName;

	@FindBy(xpath="//select[contains(@id,'countryPicklist')]")
	WebElement propertyCountry;

	@FindBy(xpath="//select[contains(@id,'countryPicklist')]/option[text()='United States']")
	WebElement selectPropertyCountry;

	@FindBy(xpath="//textarea[contains(@id,'propertyEditForm:Street')]")
	WebElement propertyStreet;

	@FindBy(xpath="//input[contains(@id,'propertyEditForm:City')]")
	WebElement propertyCity;

	@FindBy(xpath="//select[contains(@id,'propertyEditForm:statePicklist')]")
	WebElement statePickList;

	@FindBy(xpath="//select[contains(@id,'statePicklist')]/option[text()='Texas']")
	WebElement selectPropertyState;

	@FindBy(xpath="//h1[contains(@class,'slds-page-header__title')]/span")
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

	@FindBy(xpath="//button[@title='Past Activity']")
	WebElement pastActivityButton;

	@FindBy(xpath="//select[@class='slds-select']/option[@value='Private - Follow-Up Task']")
	WebElement activityTypeFollowUpTaskValue;

	@FindBy(xpath="//input[contains(@id,'dueDate')]")
	WebElement newActivityDueDate;

	@FindBy(xpath="//button[@title='Past Activity']")
	WebElement pastActivity;

	@FindBy(xpath="//button[@title='More Activities']")
	WebElement moreActivities;

	@FindBy(xpath="//a[@class='tabHeader']/span[text()='Activity']")
	WebElement activityTab;  

	@FindBy(xpath="//div[@id='activityPanelContainer']//a[text()='Expand All']")
	WebElement expandAll;

	@FindBy(xpath="//div[@id='activityPanelContainer']//span[text()='Filter Timeline']")
	WebElement filterTimeline;

	@FindBy(xpath="//div[contains(@id,'recordLayoutPlaceholder')]//div[@title='Status']")
	WebElement statusActivityTimeline;

	@FindBy(xpath="//div[contains(@id,'recordLayoutPlaceholder')]//div/span")
	WebElement openActivityTimeline;

	@FindBy(xpath="//div[contains(@id,'recordLayoutPlaceholder')]//div[@title='Description']")
	WebElement descriptionActivityTimeline;

	@FindBy(xpath="//a[contains(@id,'tag_edit_link')]")
	WebElement addTag;

	@FindBy(xpath="//textarea[@id='ptag_edit_area']")
	WebElement privatetag;

	@FindBy(xpath="//input[@id='tag_save_btn']")
	WebElement savePrivateTag;

	@FindBy(xpath="//a[@role='menuitem']/span[contains(@class,'slds-truncate')][text()='Bulk Tagging']")
	WebElement bulkTagging;

	@FindBy(xpath="//input[@value='Search']")
	WebElement searchProperty;

	@FindBy(xpath="//input[contains(@id,'SearchBlock:propertyEditForm:SearchBox')][contains(@placeholder,'Search Account/Contact')]")
	WebElement accountSearch;

	@FindBy(xpath="//div[@class='slds-form-element ']//input[@value='Search']")
	WebElement search;

	@FindBy(xpath="//a[@role='menuitem']/span[contains(@class,'slds-truncate')][text()='Private Tags']")
	WebElement more_PrivateTags;

	@FindBy(xpath = "//div[@class='slds-truncate'][text()='New']")
	WebElement newPrivateTag;

	@FindBy(xpath="//label[@class='label inputLabel uiLabel-left form-element__label uiLabel']/span[contains(text(),'Private Tag Name')]/parent::label/parent::div/input")
	WebElement privateTagName;

	@FindBy(xpath="//button[@title='Save']")
	WebElement saveNewPrivateTag;

	@FindBy(xpath="//span[contains(text(),'Properties')]/ancestor::article//div[text()='New']")
	WebElement newPropertiesDetailsPage;

	@FindBy(xpath="//input[contains(@placeholder,'Search Properties')]")
	WebElement searchPropertyWithPrivateTag;

	@FindBy(xpath="//div[contains(@class,'modal-footer') and contains(@class,'slds-modal__footer')]//button/span[text()='Save']")
	WebElement savePropertyPrivateTag;

	/*@FindBy(xpath="//select[contains(@id,'propertyEditForm:APACPropertyType_unselected')]/option[@value='Industrial']")
	WebElement propertyTypeValue;*/

	@FindBy(xpath="//select[contains(@id,'propertyEditForm:APACPropertyType_unselected')]/option[text()='Industrial']")
	WebElement propertyTypeValue;

	@FindBy(xpath="//td[@class='multiSelectPicklistCell']/a[@title='Add']")
	WebElement addValuetoCheckList;

	@FindBy(xpath="//select[contains(@id,'propertyEditForm:APACPropertyType')]/parent::div")
	WebElement elementHidden;

	@FindBy(xpath="//select[contains(@id,'propertyEditForm:APACPropertyType')]/parent::div/select")
	WebElement elementSelectHidden ;

	@FindBy(xpath="//select[contains(@id,'propertyEditForm:Class')]")
	WebElement buildingClass;

	@FindBy(xpath="//select[contains(@id,'propertyEditForm:Class')]/option[@value='A']")
	WebElement buildingClassValue;

	@FindBy(xpath="//a[@class='tabHeader']//span[text()='Details']")
	WebElement details;

	@FindBy(xpath="//a[@role='menuitem']/span[contains(@class,'slds-truncate')][text()='Property Preferences']")
	WebElement more_propertyPreferences;

	@FindBy(xpath="//div[@class='slds-truncate'][text()='New']")
	WebElement newPropertiesPreferences;

	@FindBy(xpath="//a[@aria-label='Area UOM']")
	WebElement unitOfMeasure;

	@FindBy(xpath="//a[@role='menuitem']/span[contains(@class,'slds-truncate')][text()='Project Enquiries']")
	WebElement more_projectEnquiries;

	@FindBy(xpath="//a[@aria-label='Total Area UOM']")
	WebElement unitOfMeasureProjectEnquiries;

	@FindBy(xpath="//select[contains(@id,'UnitsofMeasureAPAC')]")
	WebElement unitOfMeasureProperties;

	@FindBy(xpath="//a[contains(@aria-label,'Preference Type')]")
	WebElement preferenceType;

	@FindBy(xpath="//span[text()='Project Enquiry Name']/parent::label/parent::div/input")
	WebElement projectEnquiryName;

	@FindBy(xpath="//input[contains(@placeholder,'Search Accounts')]")
	WebElement enquiryAccount;

	@FindBy(xpath="//div[contains(@class,'primaryLabel')][@title='AUCAPACBroker123']")
	WebElement enquiryAccountValue;

	@FindBy(xpath="//input[contains(@placeholder,'Search Contacts')]")
	WebElement enquiryContact;

	@FindBy(xpath="//div[contains(@class,'secondaryLabel')][@title='AUCAPACBroker123']")
	WebElement enquiryContactValue;

	@FindBy(xpath="//div[contains(@class,'slds-modal__footer')]//span[text()='Save']")
	WebElement projectEnquirySave;

	@FindBy(xpath="//div[@class='forceChangeRecordTypeFooter']/button[contains(@class,'slds-button')]/span[text()='Next']")
	WebElement nextNewProjectEnquiry;

	@FindBy(xpath="//span[contains(text(),'Country')]/parent::div/following-sibling::div//a[contains(text(),'New Zealand')]")
	WebElement countryFieldNewZealand;

	@FindBy(xpath = "//one-app-launcher-header/button")
	WebElement applauncher;

	@FindBy(xpath="//a[contains(@title,'Preferences')]/span/span[contains(text(),'Preferences')]")
	WebElement preferences;

	@FindBy(xpath="//span[contains(@class,'virtualAutocompleteOptionText')][contains(text(),'All property preferences')]")
	WebElement allInvestorPreferences;

	@FindBy(xpath="//span[contains(text(),'Preference Type')]/parent::div/following-sibling::div//span[contains(text(),'Sale')]")
	WebElement preferenceTypeSale;

	@FindBy(xpath="//span[contains(text(),'Property Type')]/parent::div/following-sibling::div//span[contains(text(),'Industrial')]")
	WebElement industrialPropertyType;

	@FindBy(xpath="//span[contains(text(),'APAC Region')]/parent::div/following-sibling::div//a[contains(text(),'SA')]")
	WebElement regionSA;

	@FindBy(xpath="//span[contains(text(),'Preference Type')]/parent::div/following-sibling::div//span[contains(text(),'Lease')]")
	WebElement preferenceTypeLease;

	@FindBy(xpath="//span[contains(text(),'Property Type')]/parent::div/following-sibling::div//span[contains(text(),'Retail')]")
	WebElement retailPropertyType;

	@FindBy(xpath="//span[contains(text(),'APAC Region')]/parent::div/following-sibling::div//a[contains(text(),'NSW')]")
	WebElement regionNSW;

	@FindBy(xpath="//span[contains(text(),'APAC Region')]/parent::div/following-sibling::div//a[contains(text(),'Christchurch')]")
	WebElement regionChristchurch;

	@FindBy(xpath="//select[contains(@id,'countryPicklist')]/option[text()='Japan']")
	WebElement selectCountryJapan;

	@FindBy(xpath="//select[contains(@id,'UnitsofMeasureAPAC')]/option[contains(@value,'Tsubo')]")
	WebElement japanUnitOfMeasure;

	@FindBy(xpath="//select[contains(@id,'statePicklist')]/option[text()='Tokyo']")
	WebElement selectStateTokyo;

	@FindBy(xpath="//input[contains(@id,'TotalSize')]")
	WebElement totalSize;

	@FindBy(xpath="//select[contains(@id,'APACPropertyType_unselected')]")
	WebElement propertyTypeHotel;

	@FindBy(xpath="//span[contains(@id,'propertyEditForm:prpType')]//a[contains(@title,'Add')]/img")
	WebElement addButton;

	@FindBy(xpath="//li[contains(@id,'Serviced-Apartment')]//span[contains(text(),'Serviced Apartment')]")
	WebElement servicedApartment;

	@FindBy(xpath = "//a[@role='menuitem']/div[@class='forceActionLink'][text()='Edit']")
	WebElement edit;

	@FindBy(xpath = "//li[contains(@class,'oneActionsDropDown')]//a")
	WebElement showMoreActions;

	@FindBy(xpath="//li[contains(@id,'Commercial-Building')]//span[contains(text(),'Commercial Building')]")
	WebElement commercialBuilding;

	@FindBy(xpath="//span[contains(text(),'APAC Property Preferences')]/parent::div/preceding-sibling::div/span[contains(@class,'slds-radio--faux')]")
	WebElement apacPropertyPreferences;

	@FindBy(xpath="//span[contains(text(),'Next')]/parent::button")
	WebElement nextPropertyPreferences;

	@FindBy(xpath="//input[contains(@placeholder,'Search Contacts')]")
	WebElement searchContacts;

	@FindBy(xpath="//div[contains(@class,'primaryLabel')][contains(@title,'TestAMER CMBroker')]")
	WebElement contactsValue;

	@FindBy(xpath="//a[contains(@title,'Sale')]")
	WebElement preferenceTypeValue;

	@FindBy(xpath="//a[contains(@aria-label,'Property Type')]")
	WebElement propertyType;

	@FindBy(xpath="//a[contains(@title,'Hotel')]")
	WebElement propertyTypeHotelValue;

	@FindBy(css="ul>li.forceSearchInputLookupDesktopOption:nth-child(1)")
	WebElement firstLookUpElement;

	@FindBy(xpath="//ul[@class='tabs__nav']//a[@title='New Event']")
	WebElement newEventOpp;

	@FindBy(xpath = "//span[text()='Add']")
	WebElement addActivity;

	@FindBy(xpath = "//a[contains(@title,'Automation')]")
	WebElement ExistingProperty;

	@FindBy (xpath = "//*[contains(@title,'View records tagged')]")
	WebElement PrivateTagged;

	@FindBy (xpath = " //*[contains(@class,'entityNameTitle slds-breadcrumb__item slds-line-height--reset')]")
	WebElement PrivateTagPage;

	@FindBy(xpath = "//a[@class='slds-truncate outputLookupLink slds-truncate forceOutputLookup']")
	WebElement PropertyList;
	
	@FindBy (xpath = "//li/a[@title='Marketing Lists']")
	WebElement marketingLists;
	
	@FindBy (xpath = "//*[@class=' input' and @maxlength]")
	WebElement marketListName;
	
	@FindBy (xpath = "//*[@placeholder='Search Contacts...']")
	WebElement authorContact;
	
	@FindBy (xpath = "//div[@class='form-element']")
	WebElement publicationDate;
	
	@FindBy (xpath = "//input[@title='Search Marketing Lists']")
	WebElement marketListSubscription;
	
	@FindBy (xpath = "//*[@class=' textarea']")
	WebElement notesTxtBx;
	
	@FindBy (xpath = "//*[@title='Save']")
	WebElement saveMarketList;
	
	@FindBy (xpath = "//*[@title='Subscriptions']")
	WebElement subscriptions;
	
	@FindBy (xpath = "//button[@title='Save']")
	WebElement saveSubscription;
	
	@FindBy (xpath = "//li/a[@title='Property Preferences']")
	WebElement propertyPreferences;
	
	@FindBy (xpath = "//*[contains(@class,'slds-dropdown__item has-icon--left   f')]")
	WebElement allPropertyPreferences;
	
	@FindBy (xpath ="//*[@class='slds-cell-edit cellContainer'][@tabindex='-1'][@scope='row']")
	WebElement allPropertyPreferenceslist;
	
	@FindBy (xpath="//li/a[@title='Edit']")
	WebElement editProperty;
	
	@FindBy (xpath="//span[text()='Minimum Price']/parent::label/parent::div/input")
	WebElement minimumPriceProperty;

	@FindBy (xpath="//*[@title='Save']")
	WebElement savePropertypreference;
	
	@FindBy (xpath="//li/a[@title='Clone']")
	WebElement cloneProperty;
	
	@FindBy (xpath ="//*[@class=' select'][@data-interactive-lib-uid='115']")
	WebElement hotelStar;

	LoginPage loginPage = new LoginPage(scriptHelper);
	Actions actions = new Actions(driver.getWebDriver());
	ActivityPage activityPage = new ActivityPage(scriptHelper);

	/**
	 * Validating the Customer Property Page fields 
	 * 
	 * @author Vishnuvardhan
	 *
	 */	

	public void validateCustomPropertyPage() {
		try {
			/*Utility_Functions.xClick(driver, menu_More, true);
			Utility_Functions.timeWait(2);
			Utility_Functions.xClick(driver, properties, true);
			Utility_Functions.timeWait(4);*/
			try{
				Utility_Functions.xWaitForElementPresent(driver,menu_Properties, 3);
				Utility_Functions.xClick(driver, menu_Properties, true);
			}catch(Exception e){
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
			Utility_Functions.xClick(driver, newProperty, true);
			Utility_Functions.timeWait(2);
			driver.switchTo().frame(driver.findElement(By.xpath("//iframe[contains(@title,'New Property: Select Property Record Type ~ Salesforce - Enterprise Edition')]")));
			Utility_Functions.timeWait(1);
			Utility_Functions.xClick(driver, continueButton, true);
			Utility_Functions.timeWait(2);
			driver.switchTo().defaultContent();
			Utility_Functions.xSwitchtoFrame(driver, propertyInformationFrame);

			//driver.switchTo().frame(driver.findElement(By.xpath("//iframe[contains(@src,'recordtypeselect')]")));
			List<WebElement> propertyEditPage = driver.findElements(By.xpath("//div[@class='slds-grid slds-wrap slds-grid slds-wrap slds-grid--pull-padded slds-form--stacked']/div/h2"));
			int count=0; 
			for(WebElement element: propertyEditPage) {
				if((count==0) && (element.getText().contains("Property Information"))) {
					System.out.println("Propety page contains the section - Property Information");
					report.updateTestLog("Property Information page", "Propety page contains the section - " + element.getText(),Status.PASS);	
					count++;						
				} else if((count==1) && (element.getText().contains("Address Information"))) {
					System.out.println("Propety page contains the section - Address Information");
					report.updateTestLog("Property Information page", "Propety page contains the section - " + element.getText(),Status.PASS);	
					count++;						
				} else if((count==2) && (element.getText().contains("Property Financials"))) {
					System.out.println("Propety page contains the section - Property Financials");
					report.updateTestLog("Property Information page", "Propety page contains the section - " + element.getText(),Status.PASS);	
					count++;											
				} else if((count==3) && (element.getText().contains("Property Summary"))) {
					System.out.println("Propety page contains the section - Property Summary");
					report.updateTestLog("Property Information page", "Propety page contains the section - " + element.getText(),Status.PASS);	
					count++;	
				} else if((count==4) && (element.getText().contains("Property Management"))) {
					System.out.println("Propety page contains the section - Property Management");
					report.updateTestLog("Property Information page", "Propety page contains the section - " + element.getText(),Status.PASS);	
					count++;	
				} else if((count==5) && (element.getText().contains("Asset Management"))) {
					System.out.println("Propety page contains the section - Asset Management");
					report.updateTestLog("Property Information page", "Propety page contains the section - " + element.getText(),Status.PASS);	
					count++;	
				} else if((count==6) && (element.getText().contains("Listing Management"))) {
					System.out.println("Propety page contains the section - Listing Management");
					report.updateTestLog("Property Information page", "Propety page contains the section - " + element.getText(),Status.PASS);	
					count++;		
				}
			}	
			if(count!=7) 
				report.updateTestLog("Property Information page", "Property Information page is not having all the fields::",Status.FAIL);			
			validateFieldsSection();
			validateFieldsSubSections();
			createProperty();
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
		}

	}


	/**
	 * Validating the Customer Property Page fields 
	 * 
	 * @author Vishnuvardhan
	 *
	 */	

	public void validateFieldsSection() {
		List<WebElement> propertyPageLabels = driver.findElements(By.xpath("//div[@class='slds-col--padded slds-size--1-of-1 slds-medium-size--1-of-1 slds-large-size--1-of-2']/div/label"));
		int count =0;
		for(WebElement element: propertyPageLabels) {
			//System.out.println("Property Information Section field lables::");
			if(element.getText().contains("Building/Property Name")) {
				report.updateTestLog("Property Information page", "Property Information page has the field" + element.getText()+ ":::" , Status.PASS);
				count++;		
			} else if(element.getText().contains("Property Website")) {
				report.updateTestLog("Property Information page", "Property Information page has the field" + element.getText()+ ":::" , Status.PASS);
				count++;		
			} else if(element.getText().contains("Country")) {
				report.updateTestLog("Property Information page", "Property Information page has the field" + element.getText()+ ":::" , Status.PASS);
				count++;		
			} else if(element.getText().contains("Street")) {
				report.updateTestLog("Property Information page", "Property Information page has the field" + element.getText()+ ":::" , Status.PASS);
				count++;		
			} else if(element.getText().contains("City")) {
				report.updateTestLog("Property Information page", "Property Information page has the field" + element.getText()+ ":::" , Status.PASS);
				count++;		
			} else if(element.getText().contains("State/ Province")) {
				report.updateTestLog("Property Information page", "Property Information page has the field" + element.getText()+ ":::" , Status.PASS);
				count++;		
			} else if(element.getText().contains("Zip/ Postal Code")) {
				report.updateTestLog("Property Information page", "Property Information page has the field" + element.getText()+ ":::" , Status.PASS);
				count++;		
			} else if(element.getText().contains("Region")) {
				report.updateTestLog("Property Information page", "Property Information page has the field" + element.getText()+ ":::" , Status.PASS);
				count++;		
			} else if(element.getText().contains("Market")) {
				report.updateTestLog("Property Information page", "Property Information page has the field" + element.getText()+ ":::" , Status.PASS);
				count++;		
			} else if(element.getText().contains("Sub Market")) {
				report.updateTestLog("Property Information page", "Property Information page has the field" + element.getText()+ ":::" , Status.PASS);
				count++;		
			} else if(element.getText().contains("District")) {
				report.updateTestLog("Property Information page", "Property Information page has the field" + element.getText()+ ":::" , Status.PASS);
				count++;		
			} else if(element.getText().contains("Country")) {
				report.updateTestLog("Property Information page", "Property Information page has the field" + element.getText()+ ":::" , Status.PASS);
				count++;		
			} else if(element.getText().contains("Last Purchase/Sale Price")) {
				report.updateTestLog("Property Information page", "Property Information page has the field" + element.getText()+ ":::" , Status.PASS);
				count++;		
			} else if(element.getText().contains("*Currency ISO Code")) {
				report.updateTestLog("Property Information page", "Property Information page has the field" + element.getText()+ ":::" , Status.PASS);
				count++;		
			} else if(element.getText().contains("Last Purchase/Sale Date")) {
				report.updateTestLog("Property Information page", "Property Information page has the field" + element.getText()+ ":::" , Status.PASS);
				count++;		
			} else if(element.getText().contains("Property Type")) {
				report.updateTestLog("Property Information page", "Property Information page has the field" + element.getText()+ ":::" , Status.PASS);
				count++;		
			} else if(element.getText().contains("Property Sub-Type")) {
				report.updateTestLog("Property Information page", "Property Information page has the field" + element.getText()+ ":::" , Status.PASS);
				count++;		
			} else if(element.getText().contains("Construction Type")) {
				report.updateTestLog("Property Information page", "Property Information page has the field" + element.getText()+ ":::" , Status.PASS);
				count++;		
			} else if(element.getText().contains("Location")) {
				report.updateTestLog("Property Information page", "Property Information page has the field" + element.getText()+ ":::" , Status.PASS);	
				count++;		
			} else if(element.getText().contains("Class")) {
				report.updateTestLog("Property Information page", "Property Information page has the field" + element.getText()+ ":::" , Status.PASS);
				count++;		
			} else if(element.getText().contains("Net Rentable Area")) {
				report.updateTestLog("Property Information page", "Property Information page has the field" + element.getText()+ ":::" , Status.PASS);
				count++;		
			} else if(element.getText().contains("Total Size")) {
				report.updateTestLog("Property Information page", "Property Information page has the field" + element.getText()+ ":::" , Status.PASS);
				count++;		
			} else if(element.getText().contains("Unit of Measure")) {
				report.updateTestLog("Property Information page", "Property Information page has the field" + element.getText()+ ":::" , Status.PASS);
				count++;		
			} else if(element.getText().contains("Total # of Units")) {
				report.updateTestLog("Property Information page", "Property Information page has the field" + element.getText()+ ":::" , Status.PASS);
				count++;		
			} else if(element.getText().contains("Unit of Comparison")) {
				report.updateTestLog("Property Information page", "Property Information page has the field" + element.getText()+ ":::" , Status.PASS);
				count++;		
			} else if(element.getText().contains("Land Size(Acres)")) {
				report.updateTestLog("Property Information page", "Property Information page has the field" + element.getText()+ ":::" , Status.PASS);
				count++;		
			} else if(element.getText().contains("Tenancy")) {
				report.updateTestLog("Property Information page", "Property Information page has the field" + element.getText()+ ":::" , Status.PASS);
				count++;		
			} else if(element.getText().contains("# of Buildings")) {
				report.updateTestLog("Property Information page", "Property Information page has the field" + element.getText()+ ":::" , Status.PASS);
				count++;		
			} else if(element.getText().contains("# of Floors")) {
				report.updateTestLog("Property Information page", "Property Information page has the field" + element.getText()+ ":::" , Status.PASS);
				count++;		
			} else if(element.getText().contains("Building Status")) {
				report.updateTestLog("Property Information page", "Property Information page has the field" + element.getText()+ ":::" , Status.PASS);
				count++;		
			} else if(element.getText().contains("Month Built")) {
				report.updateTestLog("Property Information page", "Property Information page has the field" + element.getText()+ ":::" , Status.PASS);
				count++;		
			} else if(element.getText().contains("Year Built")) {
				report.updateTestLog("Property Information page", "Property Information page has the field" + element.getText()+ ":::" , Status.PASS);
				count++;		
			} else if(element.getText().contains("Year Renovated")) {
				report.updateTestLog("Property Information page", "Property Information page has the field" + element.getText()+ ":::" , Status.PASS);
				count++;		
			} else if(element.getText().contains("Occupancy Percent")) {
				report.updateTestLog("Property Information page", "Property Information page has the field" + element.getText()+ ":::" , Status.PASS);
				count++;		
			} else if(element.getText().contains("Owner Occupied")) {
				report.updateTestLog("Property Information page", "Property Information page has the field" + element.getText()+ ":::" , Status.PASS);
				count++;
			} else if(element.getText().contains("Vacant")) {
				report.updateTestLog("Property Information page", "Property Information page has the field" + element.getText()+ ":::" , Status.PASS);
			} /*else if(element.getText().contains("Company")) {
				report.updateTestLog("Property Information page", "Property Information page has the field" + element.getText()+ ":::" , Status.PASS);	
			} else if(element.getText().contains("Address")) {
				report.updateTestLog("Property Information page", "Property Information page has the field" + element.getText()+ ":::" , Status.PASS);	
			} else if(element.getText().contains("Contact Name")) {
				report.updateTestLog("Property Information page", "Property Information page has the field" + element.getText()+ ":::" , Status.PASS);	
			} else if(element.getText().contains("Phon")) {
				report.updateTestLog("Property Information page", "Property Information page has the field" + element.getText()+ ":::" , Status.PASS);	
			} else if(element.getText().contains("Email")) {
				report.updateTestLog("Property Information page", "Property Information page has the field" + element.getText()+ ":::" , Status.PASS);	
			} */			
		}
		System.out.println(count);
		if(count!=28) 
			report.updateTestLog("Property Information page", "Property Information page is not having all the fields:::" , Status.FAIL);	
	}


	/**
	 * Validating the Customer Property Page fields sub sections 
	 * 
	 * @author Vishnuvardhan
	 *
	 */	

	public void validateFieldsSubSections() {
		List<WebElement> propertyPageSections = driver.findElements(By.xpath("//div[@class='slds-col--padded slds-size--1-of-1 slds-medium-size--1-of-1 slds-large-size--1-of-2']/div/label/parent::div/parent::div/parent::div/div/h2"));
		int count =0;
		for(WebElement element: propertyPageSections) {
			if((element.getText().equals("Property Management")) || (element.getText().equals("Listing Management")) || (element.getText().equals("Asset Management"))) {
				List<WebElement> propertyPageLabels = driver.findElements(By.xpath("//div[@class='slds-col--padded slds-size--1-of-1 slds-medium-size--1-of-1 slds-large-size--1-of-2']/div/label"));
				for(WebElement element1: propertyPageLabels) {
					if(element.getText().contains("Company")) {
						report.updateTestLog(element.getText() + " Section", "Property Management Section has the field" + element1.getText()+ ":::" , Status.PASS);
						count++;		
					} else if(element1.getText().contains("Address")) {
						report.updateTestLog(element.getText() + " Section", "Property Management Section has the field" + element1.getText()+ ":::" , Status.PASS);
						count++;		
					} else if(element1.getText().contains("ContactName")) {
						report.updateTestLog(element.getText() + " Section", "Property Management Section has the field" + element1.getText()+ ":::" , Status.PASS);
						count++;		
					} else if(element1.getText().contains("Phone")) {
						report.updateTestLog(element.getText() + " Section", "Property Management Section has the field" + element1.getText()+ ":::" , Status.PASS);
						count++;		
					} else if(element1.getText().contains("Email")) {
						report.updateTestLog(element.getText() + " Section", "Property Management Section has the field" + element1.getText()+ ":::" , Status.PASS);
					} 
				}
			}
		} 
		if(count!=18) 
			report.updateTestLog("Property, Asset and Listing Management Sections", "Sections doesn't have all the fields", Status.FAIL);

	}


	/**
	 * Function for Creating a property
	 * 
	 * @author Vishnuvardhan
	 *
	 */	

	public void createProperty() {
		Utility_Functions.timeWait(1);
		try {
			Utility_Functions.timeWait(1);
			buildingPropertyName.clear();
			Utility_Functions.timeWait(1);
			Utility_Functions.xSendKeys(driver, buildingPropertyName, dataTable.getData("General_Data", "Building/ Property Name"));
			Utility_Functions.timeWait(1);
			Utility_Functions.xScrollWindowOnce(driver);
			Utility_Functions.timeWait(1);
			//Utility_Functions.xClick(driver, countryDropdown, true);
			Utility_Functions.xSelectDropdownByIndex(countryDropdown, 229);
			Utility_Functions.timeWait(1);
			Utility_Functions.xSendKeys(driver, street, dataTable.getData("General_Data", "Street"));
			Utility_Functions.timeWait(1);
			Utility_Functions.xSendKeys(driver, city, dataTable.getData("General_Data", "City"));
			Utility_Functions.timeWait(1);
			//Utility_Functions.xClick(driver, stateDropdown, true);
			Utility_Functions.xSelectDropdownByIndex(stateDropdown, 54);
			Utility_Functions.timeWait(1);
			Utility_Functions.xClick(driver, saveProperty, true);
			Utility_Functions.timeWait(4);
			driver.switchTo().defaultContent();
			if(createdProperty.getText().contains(dataTable.getData("General_Data", "Street"))) {
				report.updateTestLog("Save Property", "Property has been created successfully :::" , Status.PASS);
			} else {
				report.updateTestLog("Save Property", "Unable to save the property:::" , Status.FAIL);
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
		}
	}
	/**
	 * Validating the Creation of Activity in the Properties
	 * 
	 * @author Ramya
	 *
	 */	
	public void verifyCreationOfActivity() {
		try{
			Utility_Functions.xWaitForElementPresent(driver,menu_Properties, 3);
			Utility_Functions.xClick(driver, menu_Properties, true);
		}catch(Exception e){
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
		report.updateTestLog("Verify Create Activity Properties ","Properties is Displayed ",  Status.PASS);
		Utility_Functions.xWaitForElementPresent(driver, recentlyViewed, 3);
		Utility_Functions.xClick(driver, recentlyViewed, true);
		report.updateTestLog("Verify Create Activity Properties ","Recently viewed Properties are Displayed ",  Status.PASS);
		Utility_Functions.xWaitForElementPresent(driver, allProperties, 3);
		Utility_Functions.xClick(driver, allProperties, true);
		Utility_Functions.timeWait(3);
		report.updateTestLog("Verify Create Activity Properties ","All Properties are Displayed ",  Status.PASS);

		List<WebElement> propertiesList = driver.findElements(By.xpath(".//a[@class='slds-truncate outputLookupLink slds-truncate forceOutputLookup']"));

		Utility_Functions.xclickOnFirstElementfromList(propertiesList);	
		Utility_Functions.timeWait(3);
		report.updateTestLog("Verify Create Activity Properties ","The property is Displayed ",  Status.PASS);
		activityPage.createNewActivity();
		/*	Utility_Functions.xWaitForElementPresent(driver, related, 3);
		Utility_Functions.xClick(driver, related, true);
		report.updateTestLog("Verify Create Activity Properties ","The related page is Displayed ",  Status.PASS);
		Utility_Functions.xScrollWindow(driver);
		Utility_Functions.timeWait(1);
		Utility_Functions.xScrollWindowTop(driver);
		Utility_Functions.timeWait(2);
		Utility_Functions.xWaitForElementPresent(driver, newActivity, 3);
		Utility_Functions.xClick(driver, newActivity, true);
		report.updateTestLog("Verify Create Activity Properties ","The New Activity in the related page is Displayed ",  Status.PASS);
		Utility_Functions.xSwitchtoFrame(driver, subject);
		Utility_Functions.xWaitForElementPresent(driver, subject, 5);
		Utility_Functions.xClick(driver, subject, true);
		Utility_Functions.xWaitForElementPresent(driver, subject, 5);
		Utility_Functions.xSendKeys(driver, subject, "Test Activity Created by Automation");
		Utility_Functions.xWaitForElementPresent(driver, activityType, 5);
		Utility_Functions.xClick(driver, activityType, true);
		Utility_Functions.xWaitForElementPresent(driver, saveAndNewActivity, 5);
		Utility_Functions.xClick(driver, saveAndNewActivity, true);
		Utility_Functions.timeWait(3);
		report.updateTestLog("Verify Create Activity Properties ","The Activity is saved and New Activity is displayed ",  Status.PASS);
		Utility_Functions.xClick(driver, subject, true);
		Random random = new Random();
		int value = random.nextInt();

		Utility_Functions.xSendKeys(driver, subject, "Test Activity Created by Automation" + value);
		Utility_Functions.xWaitForElementPresent(driver, activityType2, 5);
		Utility_Functions.xClick(driver, activityType2, true);
		Utility_Functions.xWaitForElementPresent(driver, saveActivity, 5);
		Utility_Functions.xClick(driver, saveActivity, true);

		SearchTextSOQL searchTextSOQL = new SearchTextSOQL(scriptHelper);
		String query = "select Name from Activity__C where Subject__C = " + "'" + "Test Activity Created by Automation" + value + "'";
		String nameActivity = searchTextSOQL.fetchRecordFieldValue("Name", query);
		if(nameActivity==null) {
			System.out.println("Activity has not been retrieved");
			report.updateTestLog("Verify Create Activity Properties ","The newly created Activity has not been retrieved ",  Status.FAIL);
		} else {
			System.out.println("Activity has been retrieved");
			report.updateTestLog("Verify Create Activity Properties ","The newly created Activity has been retrieved",  Status.PASS);
		}
		String queryId = "select Id from Activity__C where Name = " + "'" + nameActivity + "'";
		String activityId = searchTextSOQL.fetchRecordFieldValue("Id", queryId);

		String url = driver.getCurrentUrl().split("#")[0];
		String newUrl = url + "#/sObject/" + activityId;
		newUrl = newUrl + "/view";
		report.updateTestLog("Verify Add Opportunity Page Fields",
				"URL has been replaced with the new URL having the retrieved Opportunity:::" + newUrl, Status.PASS);
		driver.get(newUrl);
		Utility_Functions.timeWait(1);
		driver.navigate().refresh();
		Utility_Functions.timeWait(4);
		driver.navigate().refresh();
		Utility_Functions.timeWait(1);
		driver.switchTo().defaultContent();
		driver.navigate().refresh();
		Utility_Functions.timeWait(4);
		Utility_Functions.xWaitForElementPresent(driver, selectCreateFollowUpCustomActivity, 3);
		Utility_Functions.xClick(driver,  selectCreateFollowUpCustomActivity, true);
		Utility_Functions.timeWait(3);
		report.updateTestLog("Verify Create Activity Properties","The Follow up Activity Page is Displayed",  Status.PASS);
		Utility_Functions.xWaitForElementPresent(driver, createCustomActivity, 5);

		Actions action  = new Actions(driver.getWebDriver());
		action.moveToElement(createCustomActivity);
		action.click();
		action.build().perform();
		Utility_Functions.timeWait(3);

		Utility_Functions.xSwitchtoFrame(driver, subject );
		Utility_Functions.timeWait(3);
		Utility_Functions.xClick(driver, subject, true);
		Utility_Functions.xWaitForElementPresent(driver, subject , 3);
		Utility_Functions.xSendKeys(driver, subject, "test3");
		Utility_Functions.xWaitForElementPresent(driver,activityType3, 3);
		Utility_Functions.xClick(driver, activityType3, true);
		Utility_Functions.xWaitForElementPresent(driver,saveActivity, 3);
		Utility_Functions.xClick(driver, saveActivity, true);
		Utility_Functions.timeWait(3);
		report.updateTestLog("Verify Create Activity Properties ","The Custom Activity is created ",  Status.PASS);
				driver.navigate().refresh();
		Utility_Functions.timeWait(1);
		driver.switchTo().defaultContent();
		driver.navigate().refresh();
		Utility_Functions.timeWait(3);
		try{
			Utility_Functions.xWaitForElementPresent(driver,menu_Properties, 3);
			Utility_Functions.xClick(driver, menu_Properties, true);
		}catch(Exception e){
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
		//Utility_Functions.xClick(driver, recentlyViewed, true);
		//Utility_Functions.timeWait(3);
		List<WebElement> recentlyViewedpropertiesList = driver.findElements(By.xpath(".//a[@class='slds-truncate outputLookupLink slds-truncate forceOutputLookup']"));

		Utility_Functions.xclickOnFirstElementfromList(recentlyViewedpropertiesList);
		Utility_Functions.timeWait(3);
		Utility_Functions.xWaitForElementVisible(driver, related, 5);
		Utility_Functions.xClick(driver, related, true);
		Utility_Functions.xScrollWindow(driver);
		Utility_Functions.timeWait(1);
		Utility_Functions.xScrollWindowTop(driver);
		Utility_Functions.timeWait(2);

		Utility_Functions.xWaitForElementPresent(driver, relatedActivities, 5);
		Utility_Functions.xClick(driver, relatedActivities, true);

		List<WebElement> relatedActivitiesList = driver.findElements(By.xpath(".//a[@class='slds-truncate outputLookupLink slds-truncate forceOutputLookup'] "));
		for (WebElement element : relatedActivitiesList ) {
			if ((!element.getText().equals(" "))){
				report.updateTestLog("Verify Create Activity Properties","The New Activity for Properties are created ",Status.PASS);
			}else
			{
				report.updateTestLog("Verify Create Activity Properties","The New Activity for Properties are not created ",Status.FAIL);
			}
		}*/
	}
	/**
	 * Validating the New Activity Page Layout in the Properties
	 * 
	 * @author Ramya
	 *
	 */
	public void verifyPropertiesNewActivityPageLayout() {
		try{
			Utility_Functions.xWaitForElementPresent(driver,menu_Properties, 3);
			Utility_Functions.xClick(driver, menu_Properties, true);
		}catch(Exception e){
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
		report.updateTestLog("Verify New Activity Page Layout ","Properties is Displayed ",  Status.PASS);
		Utility_Functions.xWaitForElementPresent(driver, recentlyViewed, 3);
		Utility_Functions.xClick(driver, recentlyViewed, true);
		report.updateTestLog("Verify New Activity Page Layout ","Recently viewed Accounts are Displayed ",  Status.PASS);
		Utility_Functions.xWaitForElementPresent(driver, allProperties, 3);
		Utility_Functions.xClick(driver, allProperties, true);
		Utility_Functions.timeWait(3);
		report.updateTestLog("Verify New Activity Page Layout ","All Properties are Displayed ",  Status.PASS);
		List<WebElement> accountNamesList = driver.findElements(
				By.xpath(".//a[@class='slds-truncate outputLookupLink slds-truncate forceOutputLookup']"));

		Utility_Functions.xclickOnFirstElementfromList(accountNamesList);
		Utility_Functions.timeWait(3);
		report.updateTestLog("Verify New Activity Page Layout ","The Contact is Displayed ",  Status.PASS);
		activityPage.createNewActivity();
		/*	Utility_Functions.xClick(driver, related, true);
		Utility_Functions.timeWait(3);
		report.updateTestLog("Verify New Activity Page Layout ","The related page is Displayed ",  Status.PASS);
		Utility_Functions.xScrollWindow(driver);
		Utility_Functions.timeWait(1);
		Utility_Functions.xScrollWindowTop(driver);
		Utility_Functions.timeWait(2);
		Utility_Functions.xWaitForElementPresent(driver, newActivity, 3);
		Utility_Functions.xClick(driver, newActivity, true);
		report.updateTestLog("Verify New Activity Page Layout ","The New Activity in the related page is Displayed ",  Status.PASS);
		int size = driver.findElements(By.tagName("iframe")).size();
		System.out.println(size);
		Utility_Functions.timeWait(2);
		List<WebElement> iframeList = driver.findElements(By.tagName("iframe"));
		System.out.println(iframeList.size());
		for (WebElement element : iframeList) {
			System.out.println(element.getAttribute("id"));
		}
		Utility_Functions.xSwitchtoFrame(driver, subject);
		Utility_Functions.timeWait(5);
		System.out.println("Frame Identified");
		Utility_Functions.timeWait(5);
		List<WebElement> newActivityPageLayoutSections = driver
				.findElements(By.xpath("//div[@class='slds-grid']"));
		int countHeader =0;
		try {
			for (WebElement element : newActivityPageLayoutSections  ) {
				if ((element.getText().contains("Quick Create"))) {
					System.out.println("Quick Create section is present in the New Activity Layout Page");
					report.updateTestLog("Verify New Activity Page Layout",
							"New Activity Layout Page is having the " + element.getText()
							+ " Status field::",
							Status.PASS);
					countHeader++;


				} else if ((element.getText().contains("System Information"))) {
					System.out.println("System Information section is present in the New Activity Layout Page");
					report.updateTestLog("Verify New Activity Page Layout",
							"New Activity Layout Page is having the " + element.getText()
							+ " Status field::",
							Status.PASS);
					countHeader++;


				} else if ((element.getText().contains("Related To"))) {
					System.out.println(" Related To section is present in the New Activity Layout Page");
					report.updateTestLog("Verify New Activity Page Layout",
							"New Activity Layout Page is having the " + element.getText()
							+ " Status field::",
							Status.PASS);
					countHeader++;

				}				
			} 
			System.out.println(countHeader);
			if(countHeader!=3) {
				System.out.println("New Activity Page Layout does not contain the Quick Create, System Information and Related To sections");
				report.updateTestLog("Verify New Activity Page Layout",
						"New Activity Layout Page is having all the fields", Status.FAIL);				
			}
		}catch (Exception e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
		}


		List<WebElement> newActivityPageLayoutRequiredFields = driver.findElements(By.xpath("//label[@class='slds-form-element__label']"));
		int countRequiredFiles =0;
		try {
			for (WebElement element : newActivityPageLayoutRequiredFields  ) {
				if ((element.getText().equals("*Subject"))) {
					System.out.println("Subject required field is present in the New Activity Layout Page");
					report.updateTestLog("Verify New Activity Page Layout",
							"New Activity Layout Page is having the " + element.getText()
							+ " Status field::",
							Status.PASS);
					countRequiredFiles++;

				} else if ((element.getText().equals("*Activity Type"))) {
					System.out.println("Activity Type required field is present in the New Activity Layout Page");
					report.updateTestLog("Verify New Activity Page Layout",
							"New Activity Layout Page is having the " + element.getText()
							+ " Status field::",
							Status.PASS);
					countRequiredFiles++;

				} else if ((element.getText().equals("*Assigned To"))) {
					System.out.println(" Assigned To required field is present in the New Activity Layout Page");
					report.updateTestLog("Verify New Activity Page Layout",
							"New Activity Layout Page is having the " + element.getText()
							+ " Status field::",
							Status.PASS);
					countRequiredFiles++;


				} else if ((element.getText().equals("*Status"))) {
					System.out.println(" Status required field is present in the New Activity Layout Page");
					report.updateTestLog("Verify New Activity Page Layout",
							"New Activity Layout Page is having the " + element.getText()
							+ " Status field::",
							Status.PASS);
					countRequiredFiles++;

				}
				else if ((element.getText().equals("*Priority"))) {
					System.out.println(" Priority required field is present in the New Activity Layout Page");
					report.updateTestLog("Verify New Activity Page Layout",
							"New Activity Layout Page is having the " + element.getText()
							+ " Status field::",
							Status.PASS);
					//countRequiredFiles++;

				}

			} 
			System.out.println(countRequiredFiles);
			if(countRequiredFiles!=4) {
				System.out.println("New Activity Page Layout does not contain the required fields ");
				report.updateTestLog("Verify New Activity Page Layout",
						"New Activity Layout Page is having all the required fields",
						Status.FAIL);
			}


		}catch (Exception e) {
			e.printStackTrace();
			System.out.println(e.getMessage());

		}
		if ((!saveNewActivityLayoutPage.getText().equals(" "))
				|| (!saveAndNewActivityLayoutPage.getText().equals(" "))
				|| (!cancelNewActivityLayoutPage.getText().equals(" ")))
		{
			System.out.println(
					"Save, Save and New and Cancel buttons are prsent in the New Activity Layout Page ");
			report.updateTestLog("Verify New Activity Page Layout ",
					"Verifying New Activity Page is having the Save, Save and New and Cancel buttons ",
					Status.PASS);
		} else {
			System.out.println("Save, Save and New and Cancel buttons are not prsent in the New Activity Layout Page  ");
			report.updateTestLog("Verify New Activity Page Layout",
					"Verifying New Activity Page is having the Save, Save and New and Cancel buttons",
					Status.FAIL);
		}


		List<WebElement> newActivityPageFields = driver
				.findElements(By.xpath("//label[@class='slds-form-element__label']"));
		int count = 0;
		try {
			for (WebElement element : newActivityPageFields ) {
				if ((count == 0) && (element.getText().contains("Subject"))) {
					System.out.println("Subject field is present in the New Activity Layout Page");
					report.updateTestLog("Verify New Activity Page Layout",
							"New Activity Layout Page is having the " + element.getText()
							+ " Status field::",
							Status.PASS);
					count++;
				} else if ((count == 1) && (element.getText().contains("Activity Type"))) {
					System.out.println("Activity Type field is present in the New Activity Layout Page");
					report.updateTestLog("Verify New Activity Page Layout",
							"New Activity Layout Page is having the " + element.getText()
							+ " Status field::",
							Status.PASS);
					count++;
				}else if ((count == 2) && (element.getText().contains("DueDate"))) {
					System.out.println("Due Date field is present in the New Activity Layout Page");
					report.updateTestLog("Verify New Activity Page Layout",
							"New Activity Layout Page is having the " + element.getText()
							+ " Status field::",
							Status.PASS);
					count++;
				} else if ((count == 3) && (element.getText().contains("Call Result"))) {
					System.out
					.println("Call Result field is present in the New Activity Layout Page");
					report.updateTestLog("Verify New Activity Page Layout",
							"New Activity Layout Page is having the " + element.getText()
							+ " Status field::",
							Status.PASS);
					count++;

				} else if ((count == 4) && (element.getText().contains("Comments"))) {
					System.out
					.println("Comments field is present in the New Activity Layout Page");
					report.updateTestLog("Verify New Activity Page Layout",
							"New Activity Layout Page is having the " + element.getText()
							+ " Status field::",
							Status.PASS);
					count++;
				} else if ((count == 5) && (element.getText().contains("Owner"))) {
					System.out
					.println("Owner field is present in the New Activity Layout Page");
					report.updateTestLog("Verify New Activity Page Layout",
							"New Activity Layout Page is having the " + element.getText()
							+ " Status field::",
							Status.PASS);
					count++;
				} else if ((count == 6) && (element.getText().contains("Assigned To"))) {
					System.out
					.println("Assigned To field is present in the New Activity Layout Page");
					report.updateTestLog("Verify New Activity Page Layout",
							"New Activity Layout Page is having the " + element.getText()
							+ " Status field::",
							Status.PASS);
					count++;
				} else if ((count == 7) && (element.getText().contains("Status"))) {
					System.out
					.println("Status field is present in the New Activity Layout Page");
					report.updateTestLog("Verify New Activity Page Layout",
							"New Activity Layout Page is having the " + element.getText()
							+ " Status field::",
							Status.PASS);
					count++;
				} else if ((count == 8) && (element.getText().contains("Priority"))) {
					System.out.println(
							"Priority field is present in the New Activity Layout Page");
					report.updateTestLog("Verify New Activity Page Layout",
							"New Activity Layout Page is having the " + element.getText()
							+ " Status field::",
							Status.PASS);
					count++;
				} else if ((count == 9) && (element.getText().contains("Account"))) {
					System.out.println(
							"Account field is present in the New Activity Layout Page");
					report.updateTestLog("Verify New Activity Page Layout",
							"New Activity Layout Page is having the " + element.getText()
							+ " Status field::",
							Status.PASS);
					count++;
				} else if ((count == 10) && (element.getText().contains("Contact"))) {
					System.out.println("Contact field is present in the New Activity Layout Page");
					report.updateTestLog("Verify New Activity Page Layout",
							"New Activity Layout Page is having the " + element.getText()
							+ " Status field::",
							Status.PASS);
					count++;

				}else if ((count == 11) && (element.getText().contains("Opportunity"))) {
					System.out.println("Opportunity field is present in the New Activity Layout Page");
					report.updateTestLog("Verify New Activity Page Layout",
							"New Activity Layout Page is having the " + element.getText()
							+ " Status field::",
							Status.PASS);
					count++;
				}else if ((count == 12) && (element.getText().contains("Property"))) {
					System.out.println("Property field is present in the New Activity Layout Page");
					report.updateTestLog("Verify New Activity Page Layout",
							"New Activity Layout Page is having the " + element.getText()
							+ " Status field::",
							Status.PASS);
					count++;
				} else if ((count == 13) && (element.getText().contains("Space"))) {
					System.out.println("Space  field is present in the New Activity Layout Page");
					report.updateTestLog("Verify New Activity Page Layout",
							"New Activity Layout Page is having the " + element.getText()
							+ " Status field::",
							Status.PASS);
					count++;
				}else if ((count == 14) && (element.getText().contains("Comp"))) {
					System.out.println(
							"Comp field is present in the New Activity Layout Page");
					report.updateTestLog("Verify New Activity Page Layout",
							"New Activity Layout Page is having the " + element.getText()
							+ " Status field::",
							Status.PASS);

				}

			} 
			System.out.println(count);
			if(count!=14) {
				System.out.println("New Activity Page Layout does not contain all the fields ");
				report.updateTestLog("Verify New Activity Page Layout",
						"New Activity Layout Page is not having all the fields",
						Status.FAIL);

			}
		}catch (Exception e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
		}


		List<WebElement> newActivityPageCheckFields = driver
				.findElements(By.xpath("//span[@class='slds-form-element__label']"));

		try {
			for (WebElement element : newActivityPageCheckFields ) {
				if ((element.getText().contains("Set Reminder"))) {
					System.out.println("Set Reminder field is present in the Create Private Notes Personal Information Page");
					report.updateTestLog("Verify New Activity Page Layout",
							"New Activity Layout Page is having the " + element.getText()
							+ " Status field::",
							Status.PASS);

				} else if ((element.getText().contains("Notification Email"))) {
					System.out.println("Notification Email field is present in the New Activity Layout Page");
					report.updateTestLog("Verify New Activity Page Layout",
							"New Activity Layout Page is having the " + element.getText()
							+ " Status field::",
							Status.PASS);

				}else if ((element.getText().contains("Has Attachment"))) {
					System.out.println("Has Attachment  field is present in the New Activity Layout Page");
					report.updateTestLog("Verify New Activity Page Layout",
							"New Activity Layout Page is having the " + element.getText()
							+ " Status field::",
							Status.PASS);

				}else {
					System.out.println("New Activity Page Layout does not contain the the Set Reminder and Notification Email and Has Attachment Fields");
					report.updateTestLog("Verify New Activity Page Layout",
							"New Activity Layout Page is having the " + element.getText()
							+ " Status field::",
							Status.FAIL);

				}
			}
		}catch (Exception e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
		}
		try {
			if ((!assignedTo.getText().equals("")) || (!accountSelected.getText().equals(""))||(!priority.getText().equals(""))||(!owner.getText().equals(""))||(!status.getText().equals(""))) {
				System.out.println("Assigned To, Account Selected, Priority, Owner and Status fields are having the values:::");
				report.updateTestLog("Verify New Activity Page Layout",
						"New Activity Layout Page is having the values::", Status.PASS);
			} else {
				System.out.println("New Activity Layout Page is not having the deafault values:::");
				report.updateTestLog("Verify New Activity Page Layout",
						"New Activity layout Page is not having the values::", Status.FAIL);
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
		}*/

	}
	/**
	 * Validating the New Activity Page send Notification Email to the Assigned Person
	 * 
	 * @author Ramya
	 *
	 */

	public void verifyNewActivityPropertiesPageSendNotificationEmail(){
		try{
			Utility_Functions.xWaitForElementPresent(driver,menu_Properties, 3);
			Utility_Functions.xClick(driver, menu_Properties, true);
		}catch(Exception e){
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
		report.updateTestLog("Verify New Activity Page send Notification Email ","Verifying the Accounts is Displayed ",  Status.PASS);

		List<WebElement> propertiesList = driver.findElements(
				By.xpath(".//a[@class='slds-truncate outputLookupLink slds-truncate forceOutputLookup']"));

		Utility_Functions.xclickOnFirstElementfromList(propertiesList);
		report.updateTestLog("Verify New Activity Page send Notification Email ","Verifying the selected Account is Displayed ",  Status.PASS);
		Utility_Functions.xWaitForElementPresent(driver, newEventOpp, 3);
		Utility_Functions.xClick(driver, newEventOpp, true);

		/*Utility_Functions.xWaitForElementPresent(driver, related, 3);
		Utility_Functions.xClick(driver, related, true);
		report.updateTestLog("Verify New Activity Page Layout ","Verifying the related page is Displayed ",  Status.PASS);
		Utility_Functions.xScrollWindow(driver);
		Utility_Functions.timeWait(1);
		Utility_Functions.xScrollWindowTop(driver);
		Utility_Functions.timeWait(2);
		Utility_Functions.xWaitForElementPresent(driver, newActivity, 3);
		Utility_Functions.xClick(driver, newActivity, true);
		Utility_Functions.timeWait(3);
		report.updateTestLog("Verify New Activity Page send Notification Email  ","Verifying the New Activity in the related page is Displayed ",  Status.PASS);
		//Utility_Functions.xSwitchtoFrame(driver, subject);
		int size = driver.findElements(By.tagName("iframe")).size();
		System.out.println(size);
		Utility_Functions.timeWait(2);
		List<WebElement> iframeList = driver.findElements(By.tagName("iframe"));
		System.out.println(iframeList.size());
		for (WebElement element : iframeList) {
			System.out.println(element.getAttribute("id"));
		}
		driver.switchTo().frame(2);
		Utility_Functions.timeWait(3);

		Utility_Functions.xWaitForElementPresent(driver, subject, 3);
		Utility_Functions.xClick(driver, subject, true);
		Utility_Functions.xWaitForElementPresent(driver, subject, 3);
		Utility_Functions.xSendKeys(driver, subject, "test1");
		report.updateTestLog("Verify New Activity Page send Notification Email  ","Verifying the subject field is populated with the user defined value ",  Status.PASS);
		Utility_Functions.xWaitForElementPresent(driver, activityType, 3);
		Utility_Functions.xClick(driver, activityType, true);
		report.updateTestLog("Verify New Activity Page send Notification Email  ","Verifying the Activity Type field is populated with one of the pick list values ",  Status.PASS);*/

		if(!notificationEmail.isSelected()){
			//notificationEmail.click();
			Utility_Functions.xClick(driver, notificationEmail, true);
			System.out.println("Notification email is checked");
			report.updateTestLog("Verify New Activity Page send Notification Email  ","Verifying the notification email check box is checked or else checking it",  Status.PASS);

		}else{
			System.out.println("Notification email is not checked");
			report.updateTestLog("Verify New Activity Page send Notification Email  ","Verifying the notification email check box is checked or not ",  Status.FAIL);
		}
		/*Utility_Functions.xWaitForElementPresent(driver,assignedTo, 3);
		Utility_Functions.xSendKeys(driver, assignedTo, "vishnuvardhan bommisetty");
		report.updateTestLog("Verify New Activity Page send Notification Email  ","Verifying the Assigned To field is populated with the appropriate value ",  Status.PASS);
		Utility_Functions.xWaitForElementPresent(driver, saveActivity, 3);
		Utility_Functions.xClick(driver, saveActivity, true);
		report.updateTestLog("Verify New Activity Page send Notification Email  ","Verifying the notification email issent to the Assigned To person in the New Activity page ",  Status.PASS);*/
	}

	/**
	 * Validating the Campaigns tab present in the dropdown after loggin in
	 * 
	 * @author Vishnuvardhan
	 *
	 */	
	/**
	 * Validating the Campaigns tab present in the dropdown after loggin in
	 * 
	 * @author Vishnuvardhan
	 *
	 */	
	public void validateCampaignsTab() {
		Utility_Functions.xWaitForElementPresent(driver, menu_More, 3);
		Utility_Functions.xClick(driver, menu_More, true);
		if(dataTable.getData("General_Data", "TC_ID").contains("OBAPACBrokerCampaignsTab")) {
			try {
				Utility_Functions.xWaitForElementPresent(driver, campaigns, 2);
			} catch (Exception e) {
				Utility_Functions.xWaitForElementPresent(driver, campaignsEnv, 2);
			}
			try {
				if(campaigns.isDisplayed()) {
					report.updateTestLog("Verify Campaigns Tab","Campaigns tab is present in the dropdown:::", Status.PASS);
				} else if(campaignsEnv.isDisplayed()) {
					report.updateTestLog("Verify Campaigns Tab","Campaigns tab is present in the dropdown:::", Status.PASS);
				} else {
					report.updateTestLog("Verify Campaigns Tab","Campaigns tab doesn't present in the dropdown:::", Status.FAIL);
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else if (dataTable.getData("General_Data", "TC_ID").contains("OBAMERBrokerCampaignsTab")) {
			int count=0;
			if(dataTable.getData("General_Data", "TC_ID").contains("OBAMERBrokerCampaignsTab")) {
				List<WebElement> overFlowList = driver.findElements(By.xpath("//div[@class='overflowList']//a"));
				for(WebElement element: overFlowList) {
					if(element.getText().equals("Campaigns")) {
						count++;
						System.out.println(element.getText());
					}
				}
				if(count==0) {
					report.updateTestLog("Verify Campaigns Tab","Campaigns tab is not present in the dropdown:::", Status.PASS);
				} else {
					report.updateTestLog("Verify Campaigns Tab","Campaigns tab is present in the dropdown:::", Status.FAIL);
				}
			} 
		}

	}

	/**
	 * Validating the properties custom event page
	 * 
	 * @author Ramya
	 *
	 */

	static ArrayList<String> newPropertiesPageSectionsList = new ArrayList<String>();

	public void newPropertiesPageSections() {
		newPropertiesPageSectionsList.add("Property Information");
		newPropertiesPageSectionsList.add("Address Information");
		newPropertiesPageSectionsList.add("Property Financials");
		newPropertiesPageSectionsList.add("Property Summary");
		newPropertiesPageSectionsList.add("Property Management");
		newPropertiesPageSectionsList.add("Asset Management");
		newPropertiesPageSectionsList.add("Listing Management");
		System.out.println("New Property Page Sections are " + newPropertiesPageSectionsList);
	}
	static ArrayList<String> newpropertyInformationFieldsList = new ArrayList<String>();
	public void propertyInformationFields() {
		newpropertyInformationFieldsList.add("*Building/Property Name");
		newpropertyInformationFieldsList.add("Property Website");
		newpropertyInformationFieldsList.add("Record Type");
		newpropertyInformationFieldsList.add("Stacking URL");
		newpropertyInformationFieldsList.add("GRID Property Record Link");
		System.out.println("Property Information Fields are " + newpropertyInformationFieldsList);
	}
	static ArrayList<String> newPropertyAddressInformationSectionsList = new ArrayList<String>();
	public void newPropertiesPageAddressInformation() {
		newPropertyAddressInformationSectionsList.add("*Country");
		newPropertyAddressInformationSectionsList.add("*Street");
		newPropertyAddressInformationSectionsList.add("*City");
		newPropertyAddressInformationSectionsList.add("State/Province");
		newPropertyAddressInformationSectionsList.add("Zip/Postal Code");
		newPropertyAddressInformationSectionsList.add("Region");
		newPropertyAddressInformationSectionsList.add("Market");
		newPropertyAddressInformationSectionsList.add("Sub Market");
		newPropertyAddressInformationSectionsList.add("District");
		newPropertyAddressInformationSectionsList.add("County");
		System.out.println("New Property Page Sections are " + newPropertyAddressInformationSectionsList);
	}
	static ArrayList<String> newpropertyFinancialFieldsList = new ArrayList<String>();
	public void propertyFinancialFields() {
		newpropertyFinancialFieldsList.add("Last Purchase/Sale Price");
		newpropertyFinancialFieldsList.add("*Currency ISO Code");
		newpropertyFinancialFieldsList.add("Last Purchase/Sale Date");
		System.out.println("Property Information Fields are " + newpropertyFinancialFieldsList);
	}
	static ArrayList<String> newPropertySummaryFieldsList = new ArrayList<String>();
	public void propertySummaryFields() {
		newPropertySummaryFieldsList.add("Property Type");
		newPropertySummaryFieldsList.add("Property Sub-Type");
		newPropertySummaryFieldsList.add("Construction Type");
		newPropertySummaryFieldsList.add("Location");
		newPropertySummaryFieldsList.add("Class");
		newPropertySummaryFieldsList.add("Net Rentable Area");
		newPropertySummaryFieldsList.add("Total Size");
		newPropertySummaryFieldsList.add("Units of Measure");
		newPropertySummaryFieldsList.add("Total # of Units");
		newPropertySummaryFieldsList.add("Unit of Comparison");
		newPropertySummaryFieldsList.add("Land Size (Acres)");
		newPropertySummaryFieldsList.add("Tenancy");
		newPropertySummaryFieldsList.add("# of Buildings");
		newPropertySummaryFieldsList.add("# of Floors");
		newPropertySummaryFieldsList.add("Building Status");
		newPropertySummaryFieldsList.add("Local Property Name");
		newPropertySummaryFieldsList.add("Month Built");	
		newPropertySummaryFieldsList.add("Year Built");
		newPropertySummaryFieldsList.add("Year Renovated");
		newPropertySummaryFieldsList.add("Occupancy Percent");
		newPropertySummaryFieldsList.add("Owner Occupied");
		newPropertySummaryFieldsList.add("Vacant");
		System.out.println("New Property Page Summary section fields are " + newPropertySummaryFieldsList);
	}

	static ArrayList<String> newpropertyManagementFieldsList = new ArrayList<String>();
	public void propertyManagementFields() {
		newpropertyManagementFieldsList.add("Company");
		newpropertyManagementFieldsList.add("Address");
		newpropertyManagementFieldsList.add("Contact Name");
		newpropertyManagementFieldsList.add("Phone");
		newpropertyManagementFieldsList.add("Email");
		System.out.println("Property Management Fields are " + newpropertyManagementFieldsList);
	}

	static ArrayList<String> newpropertyAssetManagementFieldsList = new ArrayList<String>();
	public void propertyAssetManagementFields() {
		newpropertyAssetManagementFieldsList.add("Company");
		newpropertyAssetManagementFieldsList.add("Address");
		newpropertyAssetManagementFieldsList.add("Contact Name");
		newpropertyAssetManagementFieldsList.add("Phone");
		newpropertyAssetManagementFieldsList.add("Email");
		System.out.println(" Asset Management Fields are " + newpropertyAssetManagementFieldsList);
	}

	static ArrayList<String> newpropertyListingManagementFieldsList = new ArrayList<String>();
	public void propertyListingManagementFields() {
		newpropertyListingManagementFieldsList.add("Company");
		newpropertyListingManagementFieldsList.add("Address");
		newpropertyListingManagementFieldsList.add("Contact Name");
		newpropertyListingManagementFieldsList.add("Phone");
		newpropertyListingManagementFieldsList.add("Email");
		System.out.println("Listing Management Fields are " + newpropertyListingManagementFieldsList);
	}

	static ArrayList<String> unitOfMeasureValuesList = new ArrayList<String>();
	public void unitOfMeasureFields() {
		unitOfMeasureValuesList.add("--None--");
		unitOfMeasureValuesList.add("Acres");
		unitOfMeasureValuesList.add("Hectares");
		unitOfMeasureValuesList.add("None");
		unitOfMeasureValuesList.add("Ping");
		unitOfMeasureValuesList.add("Pyeong");
		unitOfMeasureValuesList.add("Square Feet");
		unitOfMeasureValuesList.add("Square Meters");
		unitOfMeasureValuesList.add("Square Yards");
		unitOfMeasureValuesList.add("Tsubo");
		System.out.println("Unit of Measure values are " + unitOfMeasureValuesList);
	}

	public void verifyNewPropertiesPage(){

		try{
			Utility_Functions.xWaitForElementPresent(driver,menu_Properties, 3);
			Utility_Functions.xClick(driver, menu_Properties, true);
		}catch(Exception e){
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

		Utility_Functions.timeWait(2);
		Utility_Functions.xWaitForElementPresent(driver, newProperties, 2);
		Utility_Functions.xClick(driver, newProperties, true);	
		Utility_Functions.timeWait(2);

		Utility_Functions.xSwitchtoFrame(driver, saveProperty);
		Utility_Functions.timeWait(5);
		String environment = loginPage.initializeEnvironment();
		if (environment.equals("FTE")) {
			if (!dataTable.getData("General_Data", "TC_ID").contains("OBAMERAdminPropertiesCreation")) {

				List<WebElement> propertiesPageSectionsList = driver.findElements(
						By.xpath("//div[contains(@class,'slds-col--padded')]/h2"));
				int count1 = 0, i1 = 0;
				String sectionArray[] = new String[propertiesPageSectionsList.size()];
				System.out.println(propertiesPageSectionsList.size());

				try {
					newPropertiesPageSections();
					for (WebElement element1 : propertiesPageSectionsList) {
						System.out.println(element1.getText());
						sectionArray[i1] = element1.getText();
						if (sectionArray[i1].equalsIgnoreCase(newPropertiesPageSectionsList.get(i1))) {
							report.updateTestLog("Verify Custom Property Page",
									"Properties Custom  page is having the " + sectionArray[i1] + " section ",
									Status.PASS);
							count1++;
						}
						i1++;
					}
					System.out.println(count1);
					if (count1 != 7) {
						report.updateTestLog("Verify Custom Property Page",
								"All sections are not present in the Properties page custom Layout", Status.FAIL);
					} else {

						report.updateTestLog("Verify Custom Property Page",
								"All sections are present in the Properties page custom Layout", Status.PASS);
					}

				} catch (Exception e) {
					System.out.println(e.getMessage());
				}

				List<WebElement> propertyInformationFieldsList = driver.findElements(
						By.xpath("//h2[text()='Property Information']/parent::div/parent::div//div[@class='slds-form-element']/label"));
				int count2 = 0, i2 = 0;
				String fieldsArray[] = new String[propertyInformationFieldsList.size()];
				System.out.println(propertyInformationFieldsList.size());

				try {
					propertyInformationFields();
					for (WebElement element2 : propertyInformationFieldsList) {
						System.out.println(element2.getText());
						fieldsArray[i2] = element2.getText();
						if (fieldsArray[i2].equalsIgnoreCase(newpropertyInformationFieldsList.get(i2))) {
							report.updateTestLog("Verify Custom Property Page",
									"Property Information section is having the " + fieldsArray[i2] + " section ",
									Status.PASS);
							count2++;
						}
						i2++;
					}
					System.out.println(count2);
					if (count2 != 5) {
						report.updateTestLog("Verify Custom Property Page",
								"All fields are not present in the Property Information section ", Status.FAIL);
					} else {

						report.updateTestLog("Verify Custom Property Page",
								"All fields are present in the Property Information section ", Status.PASS);
					}

				} catch (Exception e) {
					System.out.println(e.getMessage());
				}

				List<WebElement> propertyAddressFieldsList = driver.findElements(
						By.xpath("//h2[text()='Address Information']/parent::div/parent::div//div[@class='slds-form-element']/label"));
				int count3 = 0, i3 = 0;
				String fieldsArray1[] = new String[propertyAddressFieldsList .size()];
				System.out.println(propertyAddressFieldsList .size());

				try {
					newPropertiesPageAddressInformation();
					for (WebElement element3 : propertyAddressFieldsList) {
						System.out.println(element3.getText());
						fieldsArray1[i3] = element3.getText();
						if (fieldsArray1[i3].equalsIgnoreCase(newPropertyAddressInformationSectionsList.get(i3))) {
							report.updateTestLog("Verify Custom Property Page",
									"Address Information section is having the " + fieldsArray1[i3] + " fields ",
									Status.PASS);
							count3++;
						}
						i3++;
					}
					System.out.println(count3);
					if (count3 != 10) {
						report.updateTestLog("Verify Custom Property Page",
								"All fields are not present in the Address Information section", Status.FAIL);
					} else {

						report.updateTestLog("Verify Custom Property Page",
								"All fields are present in the Address Information section", Status.PASS);
					}

				} catch (Exception e) {
					System.out.println(e.getMessage());
				}

				List<WebElement> propertiesFinancialFieldsList = driver.findElements(
						By.xpath("//h2[text()='Property Financials']/parent::div/parent::div//div[@class='slds-form-element']/label"));
				int count4 = 0, i4 = 0;
				String fieldsArray3[] = new String[propertiesFinancialFieldsList.size()];
				System.out.println(propertiesFinancialFieldsList.size());

				try {
					propertyFinancialFields();
					for (WebElement element4 : propertiesFinancialFieldsList) {
						System.out.println(element4.getText());
						fieldsArray3[i4] = element4.getText();
						if (fieldsArray3[i4].equalsIgnoreCase(newpropertyFinancialFieldsList.get(i4))) {
							report.updateTestLog("Verify Custom Property Page",
									"Property Financial section is having the " + fieldsArray3[i4] + " fields ",
									Status.PASS);
							count4++;
						}
						i4++;
					}
					System.out.println(count4);
					if (count4 != 3) {
						report.updateTestLog("Verify Custom Property Page",
								"All fields are not present in the Property financial section", Status.FAIL);
					} else {

						report.updateTestLog("Verify Custom Property Page",
								"All fields are present in the Property financial section", Status.PASS);
					}

				} catch (Exception e) {
					System.out.println(e.getMessage());
				}

				List<WebElement> propertiesSummaryFieldsList = driver.findElements(
						By.xpath("//h2[text()='Property Summary']/parent::div/parent::div//div[@class='slds-form-element']/label"));
				int count5 = 0, i5 = 0;
				String fieldsArray4[] = new String[propertiesSummaryFieldsList.size()];
				System.out.println(propertiesSummaryFieldsList.size());

				try {
					propertySummaryFields();
					for (WebElement element5 : propertiesSummaryFieldsList) {
						System.out.println(element5.getText());

						fieldsArray4[i5] = element5.getText();
						if (fieldsArray4[i5].equalsIgnoreCase(newPropertySummaryFieldsList.get(i5))){
							/*String propertySummaryFieldListValue = newPropertySummaryFieldsList.get(i5);
				System.out.println(propertySummaryFieldListValue);
				if (fieldsArray4[i5].contains(propertySummaryFieldListValue))*/ 
							report.updateTestLog("Verify Custom Property Page",
									"Property summary section is having the " + fieldsArray4[i5] + " section ",
									Status.PASS);
							count5++;
						}
						i5++;
					}
					System.out.println(count5);
					if (count5 != 22) {
						report.updateTestLog("Verify Custom Property Page",
								"All fields are not present in the Property Summary section", Status.FAIL);
					} else {

						report.updateTestLog("Verify Custom Property Page",
								"All fields are present in the Property Summary section", Status.PASS);
					}

				} catch (Exception e) {
					System.out.println(e.getMessage());
				}

				List<WebElement> propertiesManagementFieldsList = driver.findElements(
						By.xpath("//h2[text()='Property Management']/parent::div/parent::div//div[@class='slds-form-element']/label"));
				int count6 = 0, i6 = 0;
				String fieldsArray5[] = new String[propertiesManagementFieldsList.size()];
				System.out.println(propertiesManagementFieldsList.size());

				try {
					propertyManagementFields();
					for (WebElement element6 : propertiesManagementFieldsList) {
						System.out.println(element6.getText());
						fieldsArray5[i6] = element6.getText();
						if (fieldsArray5[i6].equalsIgnoreCase(newpropertyManagementFieldsList.get(i6))) {
							report.updateTestLog("Verify Custom Property Page",
									"Property Management section is having " + fieldsArray5[i6] + " fields ",
									Status.PASS);
							count6++;
						}
						i6++;
					}
					System.out.println(count6);
					if (count6 != 5) {
						report.updateTestLog("Verify Custom Property Page",
								"All fields are not present in the Property Management section", Status.FAIL);
					} else {

						report.updateTestLog("Verify Custom Property Page",
								"All fields are present in the Property Management section", Status.PASS);
					}

				} catch (Exception e) {
					System.out.println(e.getMessage());
				}

				List<WebElement> propertiesAssetManagementFieldsList = driver.findElements(
						By.xpath("//h2[text()='Asset Management']/parent::div/parent::div//div[@class='slds-form-element']/label"));
				int count7 = 0, i7 = 0;
				String fieldsArray6[] = new String[propertiesAssetManagementFieldsList.size()];
				System.out.println(propertiesAssetManagementFieldsList.size());

				try {
					propertyAssetManagementFields();
					for (WebElement element7 : propertiesAssetManagementFieldsList) {
						System.out.println(element7.getText());
						fieldsArray6[i7] = element7.getText();
						if (fieldsArray6[i7].equalsIgnoreCase(newpropertyAssetManagementFieldsList.get(i7))) {
							report.updateTestLog("Verify Custom Property Page",
									"Asset Management section is having the " + fieldsArray6[i7] + " Fields ",
									Status.PASS);
							count7++;
						}
						i7++;
					}
					System.out.println(count7);
					if (count7 != 5) {
						report.updateTestLog("Verify Custom Property Page",
								"All Fields are not present in the Asset Management Section", Status.FAIL);
					} else {

						report.updateTestLog("Verify Custom Property Page",
								"All Fields are present in the Asset Management Section", Status.PASS);
					}

				} catch (Exception e) {
					System.out.println(e.getMessage());
				}

				List<WebElement> propertiesListingManagementFieldsList = driver.findElements(
						By.xpath("//h2[text()='Listing Management']/parent::div/parent::div//div[@class='slds-form-element']/label"));
				int count8 = 0, i8 = 0;
				String fieldsArray7[] = new String[propertiesListingManagementFieldsList.size()];
				System.out.println(propertiesListingManagementFieldsList.size());

				try {
					propertyListingManagementFields();
					for (WebElement element8 : propertiesListingManagementFieldsList) {
						System.out.println(element8.getText());
						fieldsArray7[i8] = element8.getText();
						if (fieldsArray7[i8].equalsIgnoreCase(newpropertyListingManagementFieldsList.get(i8))) {
							report.updateTestLog("Verify Custom Property Page",
									"Listing Management section is having the  " + fieldsArray7[i8] + " Fields ",
									Status.PASS);
							count8++;
						}
						i8++;
					}
					System.out.println(count8);
					if (count8 != 5) {
						report.updateTestLog("Verify Custom Property Page",
								"All Fields are not present in the Listing Management Section", Status.FAIL);
					} else {

						report.updateTestLog("Verify Custom Property Page",
								"All Fields are present in the Listing Management Section", Status.PASS);
					}

				} catch (Exception e) {
					System.out.println(e.getMessage());
				}
			}
		}
		Utility_Functions.timeWait(5);
		Utility_Functions.xWaitForElementPresent(driver, propertyName, 3);
		Utility_Functions.xClick(driver, propertyName, true);	
		Utility_Functions.xWaitForElementPresent(driver, propertyName, 5);
		int value = Utility_Functions.xRandomFunction();
		Utility_Functions.xSendKeys(driver, propertyName, "Test Automation User_" + value);
		Utility_Functions.timeWait(2);
		Utility_Functions.xScrollWindow(driver);
		Utility_Functions.timeWait(1);
		Utility_Functions.xScrollWindowTop(driver);
		Utility_Functions.timeWait(2);
		String environment1 = loginPage.initializeEnvironment();
		if (environment1.equals("FTE")) {
			if (dataTable.getData("General_Data", "TC_ID").contains("OBAMERAdminPropertiesCreation")) {
				Utility_Functions.xWaitForElementPresent(driver, propertyCountry, 3);
				Utility_Functions.xClick(driver, propertyCountry, true);
				Utility_Functions.xWaitForElementPresent(driver,selectCountryJapan, 3);
				Utility_Functions.xClick(driver,selectCountryJapan, true);
				Utility_Functions.xWaitForElementPresent(driver,selectStateTokyo, 3);
				Utility_Functions.xClick(driver,selectStateTokyo, true);		
				if(japanUnitOfMeasure.isDisplayed()){
					report.updateTestLog("Verify Custom Property Page",
							"The unit of measure for japan is selected as Tsubo by default", Status.PASS);	

				}else{
					report.updateTestLog("Verify Custom Property Page",
							"The unit of measure for japan is not selected as Tsubo by default", Status.FAIL);			
				}
				newPropertyTypeFields();
				int count = 0;
				for (int i=1; i <= newPropertyTypeList.size(); i++) {
					String option = driver.findElement(By.xpath("//select[contains(@id,'propertyEditForm:APACPropertyType')]/option["+i+"]")).getAttribute("value");
					System.out.println(option);
					report.updateTestLog("Verify New Property Page", "Property Type field is having the  " + option + " fields ", Status.PASS);
					count++;
				}		
				System.out.println(count);
				if (count!= 9) {
					report.updateTestLog("Verify Custom Property Page", "All values are not present in the Property Type pick list", Status.FAIL);
				} else {
					report.updateTestLog("Verify Custom Property Page", "All values are not present in the Property Type pick list", Status.PASS);
				}

				Select hotel =  new Select(propertyTypeHotel);
				hotel.selectByVisibleText("Hotel");
				Utility_Functions.xWaitForElementPresent(driver,addButton, 3);
				Utility_Functions.xClick(driver,addButton, true);
				Utility_Functions.xWaitForElementPresent(driver,servicedApartment, 3);
				Utility_Functions.xClick(driver,servicedApartment, true);


				List<WebElement> unitOfMeasureFieldsList = driver.findElements(
						By.xpath("//select[contains(@id,'UnitsofMeasureAPAC')]/option"));
				int count0 = 0, i0 = 0;
				String fieldsArray0[] = new String[unitOfMeasureFieldsList.size()];
				System.out.println(unitOfMeasureFieldsList.size());

				try {
					unitOfMeasureFields();
					for (WebElement element0 :unitOfMeasureFieldsList) {
						System.out.println(element0.getText());
						fieldsArray0[i0] = element0.getText();
						if (fieldsArray0[i0].equalsIgnoreCase(unitOfMeasureValuesList.get(i0))) {
							report.updateTestLog("Verify Custom Property Page",
									"Unit of maesure is having the  " + fieldsArray0[i0] + " Fields ",
									Status.PASS);
							count0++;
						}
						i0++;
					}
					System.out.println(count0);
					if (count0 != 10) {
						report.updateTestLog("Verify Custom Property Page",
								"All Fields are not present in the Unit of Measure pick list", Status.FAIL);
					} else {

						report.updateTestLog("Verify Custom Property Page",
								"All Fields are present in the Unit of Measure pick list", Status.PASS);
					}

				} catch (Exception e) {
					System.out.println(e.getMessage());
				}		
				Utility_Functions.xSendKeys(driver,totalSize, dataTable.getData("General_Data", "Total Size"));
				Utility_Functions.xWaitForElementPresent(driver,totalSize, 4);

			}

		}else{
			Utility_Functions.xWaitForElementPresent(driver, propertyCountry, 3);
			Utility_Functions.xClick(driver, propertyCountry, true);
			Utility_Functions.xWaitForElementPresent(driver, selectPropertyCountry, 3);
			Utility_Functions.xClick(driver, selectPropertyCountry, true);
			Utility_Functions.xWaitForElementPresent(driver, selectPropertyState, 3);
			Utility_Functions.xClick(driver, selectPropertyState, true);
		}
		Utility_Functions.xWaitForElementPresent(driver, propertyStreet, 5);
		Utility_Functions.xSendKeys(driver, propertyStreet, dataTable.getData("General_Data", "Street"));
		Utility_Functions.xWaitForElementPresent(driver, propertyCity, 5);
		Utility_Functions.xSendKeys(driver, propertyCity, dataTable.getData("General_Data", "City"));
		Utility_Functions.xWaitForElementPresent(driver, saveProperty, 4);
		Utility_Functions.xClick(driver, saveProperty, true);
		Utility_Functions.timeWait(2);
		report.updateTestLog("Verify Custom Property Page",
				"The new property is saved with all the required fields", Status.PASS);	
		if(details.isDisplayed()) {

			report.updateTestLog("Verify Custom Property Page", "The Property is saved successfully", Status.PASS);
		} else {
			report.updateTestLog("Verify Custom Property Page", "The Property is not saved successfully", Status.FAIL);
		}
	}

	public void staleElementHandle(WebElement element) {
		int count = 0;
		boolean clicked = false;
		try {
			while(count < 4 || ! clicked) {
				saveProperty.click();
				clicked = true;
			}
		} catch (StaleElementReferenceException e) {
			e.toString();
			System.out.println("Trying to recover from a stale element :" + e.getMessage());
			count = count+1;
		}
	}
	/**
	 * Validating the activity Lightning Time line fields
	 * 
	 * @author Ramya
	 *
	 */

	public void selectProperty() {
		try{
			Utility_Functions.xWaitForElementPresent(driver,menu_Properties, 3);
			Utility_Functions.xClick(driver, menu_Properties, true);
		}catch(Exception e){
			Utility_Functions.xWaitForElementPresent(driver, menu_More, 3);
			Utility_Functions.xClick(driver, menu_More, true);
			Utility_Functions.xWaitForElementPresent(driver, properties, 2);
			Utility_Functions.xClick(driver, properties, true);	

		}
		Utility_Functions.timeWait(2);
		List<WebElement> accountList = driver.findElements(By.xpath("//a[@class='slds-truncate outputLookupLink slds-truncate forceOutputLookup']"));
		Utility_Functions.xclickgetTextofFirstElementfromList(accountList);
		Utility_Functions.timeWait(2);
	}

	/**
	 * Validating the activity Lightning Time line fields
	 * 
	 * @author Ramya
	 *
	 */

	public void propertiesActivityLightningTimeline() {

		selectProperty();
		Utility_Functions.xClick(driver, related, true);
		Utility_Functions.timeWait(4);
		Utility_Functions.xScrollWindow(driver);
		Utility_Functions.timeWait(1);
		Utility_Functions.xScrollWindowTop(driver);
		Utility_Functions.timeWait(2);
		Utility_Functions.xWaitForElementPresent(driver, newActivity, 3);
		Utility_Functions.xClick(driver, newActivity, true);
		report.updateTestLog("Verify Properties Activity Timeline","The New Activity in the related page is Displayed ",  Status.PASS);
		Utility_Functions.xSwitchtoFrame(driver, saveAndNewActivity);
		Utility_Functions.timeWait(3);
		Utility_Functions.xWaitForElementPresent(driver, subject, 5);
		Utility_Functions.xSendKeys(driver, subject, "Test Automation Subject_" + Utility_Functions.xGenerateAlphaNumericString());
		Utility_Functions.xWaitForElementPresent(driver, activityTypeFollowUpTaskValue, 3);
		Utility_Functions.xClick(driver, activityTypeFollowUpTaskValue, true);	
		Calendar calendar = Calendar.getInstance();
		calendar.add(Calendar.DAY_OF_MONTH, -20);
		SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy hh:mm a");
		System.out.println("Date : " + dateFormat.format(calendar.getTime())); 
		Utility_Functions.xWaitForElementPresent(driver,newActivityDueDate, 3);
		Utility_Functions.xSendKeys(driver,newActivityDueDate, dateFormat.format(calendar.getTime()));		
		Utility_Functions.xWaitForElementPresent(driver,saveActivity, 5);
		Utility_Functions.xClick(driver, saveActivity, true);
		Utility_Functions.timeWait(4);
		driver.navigate().refresh();
		Utility_Functions.timeWait(4);
		Utility_Functions.xWaitForElementPresent(driver, related, 5);
		report.updateTestLog("Verify Properties Activity Timeline","The Account is Displayed ",  Status.PASS);
		Utility_Functions.xClick(driver, related, true);
		Utility_Functions.timeWait(2);
		report.updateTestLog("Verify Properties Activity Timeline ","The related page is Displayed ",  Status.PASS);
		Utility_Functions.xScrollWindow(driver);
		Utility_Functions.timeWait(1);
		Utility_Functions.xScrollWindowTop(driver);
		Utility_Functions.timeWait(2);
		Utility_Functions.xWaitForElementPresent(driver, newActivity, 3);
		Utility_Functions.xClick(driver, newActivity, true);
		report.updateTestLog("Verify Properties Activity Timeline ","The New Activity in the related page is Displayed ",  Status.PASS);
		Utility_Functions.xSwitchtoFrame(driver, saveAndNewActivity);
		Utility_Functions.timeWait(3);
		Utility_Functions.xWaitForElementPresent(driver, subject, 5);
		Utility_Functions.xSendKeys(driver, subject, "Test Automation Subject_" + Utility_Functions.xGenerateAlphaNumericString());
		Utility_Functions.xWaitForElementPresent(driver, activityTypeFollowUpTaskValue, 3);
		Utility_Functions.xClick(driver, activityTypeFollowUpTaskValue, true);
		Calendar calendar1 = Calendar.getInstance();
		calendar1.add(Calendar.DAY_OF_MONTH, 10);
		SimpleDateFormat dateFormat1 = new SimpleDateFormat("MM/dd/yyyy hh:mm a");
		System.out.println("Date : " + dateFormat1.format(calendar1.getTime())); 
		Utility_Functions.xWaitForElementPresent(driver,newActivityDueDate, 3);
		Utility_Functions.xSendKeys(driver,newActivityDueDate, dateFormat1.format(calendar1.getTime()));
		Utility_Functions.xWaitForElementPresent(driver,saveActivity, 5);
		Utility_Functions.xClick(driver, saveActivity, true);
		Utility_Functions.timeWait(4);
		driver.navigate().refresh();
		Utility_Functions.timeWait(4);
		Utility_Functions.xWaitForElementPresent(driver,activityTab, 5);
		Utility_Functions.xClick(driver, activityTab, true);
		try {
			Utility_Functions.xWaitForElementPresent(driver,expandAll, 5);
			Utility_Functions.xClick(driver, expandAll, true);
			report.updateTestLog("Verify Properties Activity Timeline", "The expand All button is clicked", Status.PASS);
		} catch (Exception e) {
			report.updateTestLog("Verify Properties Activity Timeline", "Expand All button is not present", Status.WARNING);
		}
		Utility_Functions.timeWait(4);		
		if (filterTimeline.isDisplayed()) {
			System.out.println(
					"Filter Timeline is present in acitivity related list");
			report.updateTestLog("Verify Properties Activity Timeline","Filter Timeline is present in acitivity related list",Status.PASS);
		}

		if (statusActivityTimeline.isDisplayed()) {
			System.out.println("Status is present in acitivity related list");
			report.updateTestLog("Verify Properties Activity Timeline","Status is present in acitivity related list",Status.PASS);
		}

		if (openActivityTimeline.getText().contains("Open")) {
			System.out.println("Open is present acitivity related list");
			report.updateTestLog("Verify Properties Activity Timeline","Open is present in acitivity related list:::", Status.PASS);

		}
		if (descriptionActivityTimeline.isDisplayed()) {
			System.out.println("Description is present acitivity related list");
			report.updateTestLog("Verify Properties Activity Timeline","Description is present in acitivity related list:::", Status.PASS);

		}
	}
	/**
	 * Validating the Properties Private Tag functionality
	 * 
	 * @author Ramya
	 *
	 */

	public void propertiesPrivateTagFunctionality() {
		try{
			Utility_Functions.xWaitForElementPresent(driver,menu_Properties, 3);
			Utility_Functions.xClick(driver, menu_Properties, true);
		}catch(Exception e){
			Utility_Functions.xWaitForElementPresent(driver, menu_More, 3);
			Utility_Functions.xClick(driver, menu_More, true);
			Utility_Functions.xWaitForElementPresent(driver, properties, 2);
			Utility_Functions.xClick(driver, properties, true);	
		}
		Utility_Functions.timeWait(2);
		Utility_Functions.xWaitForElementPresent(driver,newProperty, 3);
		Utility_Functions.xClick(driver,newProperty, true);
		Utility_Functions.timeWait(2);
		Utility_Functions.xSwitchtoFrame(driver,propertyName);
		Utility_Functions.timeWait(2);
		Utility_Functions.xWaitForElementPresent(driver,propertyName, 2);
		Utility_Functions.xSendKeys(driver,propertyName, "Test Automation Subject_" + Utility_Functions.xGenerateAlphaNumericString());	
		Utility_Functions.timeWait(3);
		Utility_Functions.xScrollWindow(driver);
		Utility_Functions.timeWait(1);
		Utility_Functions.xScrollWindowTop(driver);
		Utility_Functions.timeWait(2);
		Utility_Functions.xWaitForElementPresent(driver,propertyCountry, 3);
		Utility_Functions.xClick(driver,propertyCountry, true);
		Utility_Functions.xWaitForElementPresent(driver,selectPropertyCountry, 3);
		Utility_Functions.xClick(driver,selectPropertyCountry, true);
		Utility_Functions.xWaitForElementPresent(driver,propertyStreet, 3);
		Utility_Functions.xSendKeys(driver,propertyStreet, dataTable.getData("General_Data", "Street"));
		Utility_Functions.xWaitForElementPresent(driver,propertyCity, 3);
		Utility_Functions.xSendKeys(driver,propertyCity, dataTable.getData("General_Data", "City"));
		Utility_Functions.xWaitForElementPresent(driver,statePickList, 3);
		Utility_Functions.xClick(driver,statePickList, true);
		Utility_Functions.xWaitForElementPresent(driver,selectPropertyState, 3);
		Utility_Functions.xClick(driver,selectPropertyState, true);
		Utility_Functions.xWaitForElementPresent(driver,saveProperty, 3);
		Utility_Functions.xClick(driver,saveProperty, true);
		Utility_Functions.timeWait(2);
		/*driver.switchTo().defaultContent();
		Utility_Functions.timeWait(2);*/
		driver.navigate().refresh();
		Utility_Functions.timeWait(4);
		Utility_Functions.xSwitchtoFrame(driver,addTag);
		Utility_Functions.xWaitForElementPresent(driver,addTag, 3);
		Utility_Functions.xClick(driver,addTag, true);
		Utility_Functions.xWaitForElementPresent(driver,privatetag, 3);
		Utility_Functions.xSendKeys(driver,privatetag, "Test Automation");	
		Utility_Functions.xWaitForElementPresent(driver,savePrivateTag, 3);
		Utility_Functions.xClick(driver,savePrivateTag, true);

	}
	/**
	 * Validating the Bulk Tagging
	 * 
	 * @author Ramya
	 *
	 */
	public void verifyBulkTaggingFunctionality(){

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
		Utility_Functions.xWaitForElementPresent(driver,searchProperty, 3);
		Utility_Functions.xClick(driver,searchProperty, true);
		Utility_Functions.timeWait(2);		

	}
	/**
	 * Validating the New Property Page Property Type field
	 * 
	 * @author Ramya
	 *
	 */

	static ArrayList<String> newPropertyTypeList = new ArrayList<String>();
	public void newPropertyTypeFields() {

		newPropertyTypeList.add("Agribusiness");
		newPropertyTypeList.add("Health Care");
		newPropertyTypeList.add("Hotel");
		newPropertyTypeList.add("Industrial");
		newPropertyTypeList.add("Land");
		newPropertyTypeList.add("Office");
		newPropertyTypeList.add("Residential");
		newPropertyTypeList.add("Retail");
		newPropertyTypeList.add("Specialty");

		System.out.println("New Property Page Property Type fields are " + newPropertyTypeList);
	}

	public void newPropertiesPropertyType() {
		try{
			Utility_Functions.xWaitForElementPresent(driver,menu_Properties, 3);
			Utility_Functions.xClick(driver, menu_Properties, true);
		}catch(Exception e){
			Utility_Functions.xWaitForElementPresent(driver, menu_More, 3);
			Utility_Functions.xClick(driver, menu_More, true);
			Utility_Functions.xWaitForElementPresent(driver, properties, 2);
			Utility_Functions.xClick(driver, properties, true);	
		}
		Utility_Functions.timeWait(2);
		Utility_Functions.xWaitForElementPresent(driver,newProperty, 3);
		Utility_Functions.xClick(driver,newProperty, true);
		Utility_Functions.timeWait(2);
		Utility_Functions.xSwitchtoFrame(driver,propertyName);
		Utility_Functions.timeWait(2);
		newPropertyTypeList.clear();
		newPropertyTypeFields();
		int count = 0;
		for (int i=1; i <= newPropertyTypeList.size(); i++) {
			String option = driver.findElement(By.xpath("//select[contains(@id,'propertyEditForm:APACPropertyType')]/option["+i+"]")).getAttribute("value");
			System.out.println(option);
			report.updateTestLog("Verify New Property Page", "Property Type field is having the  " + option + " fields ", Status.PASS);
			count++;
		}		
		System.out.println(count);
		if (count!= 9) {
			report.updateTestLog("Verify New Property Page", "All values are not present in the Property Type pick list", Status.FAIL);
		} else {
			report.updateTestLog("Verify New Property Page", "All values are not present in the Property Type pick list", Status.PASS);
		}
	}

	/**
	 * Validating the Property Type field value
	 * 
	 * @author Ramya
	 *
	 */

	public void verifyPropertyTypeFieldValue() {		
		newPropertiesPropertyType();
		Utility_Functions.xWaitForElementPresent(driver,propertyName, 2);
		Utility_Functions.xSendKeys(driver,propertyName, "Test Automation Subject_" + Utility_Functions.xGenerateAlphaNumericString());	
		Utility_Functions.timeWait(3);
		Utility_Functions.xScrollWindow(driver);
		Utility_Functions.timeWait(1);
		Utility_Functions.xScrollWindowTop(driver);
		Utility_Functions.timeWait(2);
		Utility_Functions.xWaitForElementPresent(driver,propertyCountry, 3);
		Utility_Functions.xClick(driver,propertyCountry, true);
		Utility_Functions.xWaitForElementPresent(driver,selectPropertyCountry, 3);
		Utility_Functions.xClick(driver,selectPropertyCountry, true);
		Utility_Functions.xWaitForElementPresent(driver,propertyStreet, 3);
		Utility_Functions.xSendKeys(driver,propertyStreet, dataTable.getData("General_Data", "Street"));
		Utility_Functions.xWaitForElementPresent(driver,propertyCity, 3);
		Utility_Functions.xSendKeys(driver,propertyCity, dataTable.getData("General_Data", "City"));
		Utility_Functions.xWaitForElementPresent(driver,statePickList, 3);
		Utility_Functions.xClick(driver,statePickList, true);
		Utility_Functions.xWaitForElementPresent(driver,selectPropertyState, 3);
		Utility_Functions.xClick(driver,selectPropertyState, true);
		Utility_Functions.timeWait(2);
		//Utility_Functions.xScrollWindowOnce(driver);
		//Utility_Functions.timeWait(2);
		//Utility_Functions.xWaitForElementPresent(driver,elementHidden, 3);
		WebElement elementHidden = driver.findElement(By.xpath("//select[contains(@id,'propertyEditForm:APACPropertyType')]/parent::div"));
		Utility_Functions.xClick(driver, elementHidden, true);
		//Utility_Functions.xWaitForElementPresent(driver,elementSelectHidden, 3);
		WebElement elementSelectHidden = driver.findElement(By.xpath("//select[contains(@id,'propertyEditForm:APACPropertyType')]/parent::div/select"));
		Utility_Functions.xClick(driver, elementSelectHidden, true);
		for (int i=1; i <= newPropertyTypeList.size(); i++) {			
			String optionValue = driver.findElement(By.xpath("//select[contains(@id,'propertyEditForm:APACPropertyType')]/option["+i+"]")).getAttribute("value");
			if(optionValue.equals("Industrial")) {
				driver.findElement(By.xpath("//select[contains(@id,'propertyEditForm:APACPropertyType')]/option["+"'"+optionValue+"'"+"]")).click();
				break;
			}
		}
		Utility_Functions.xWaitForElementPresent(driver,addValuetoCheckList, 2);
		Utility_Functions.xClick(driver,addValuetoCheckList, true);	
		Utility_Functions.xWaitForElementPresent(driver,buildingClass, 3);
		Utility_Functions.xClick(driver,buildingClass, true);
		Utility_Functions.xWaitForElementPresent(driver,buildingClassValue, 3);
		Utility_Functions.xClick(driver,buildingClassValue, true);
		Utility_Functions.xWaitForElementPresent(driver,saveProperty, 3);
		Utility_Functions.xClick(driver,saveProperty, true);
		Utility_Functions.timeWait(2);
		if(details.isDisplayed()) {

			report.updateTestLog("Verify Editing the Existing Account", "The existing account can be edited and saved successfully", Status.PASS);
		} else {
			report.updateTestLog("Verify Editing the Existing Account", "The existing account cannot be edited and saved successfully", Status.FAIL);
		}
	}

	/**
	 * Validating the Properties Private Tags
	 * 
	 * @author Ramya
	 *
	 */
	public void verifyPropertiesPrivateTags(){

		Utility_Functions.xWaitForElementPresent(driver,menu_More, 3);
		Utility_Functions.xClick(driver, menu_More, true);
		report.updateTestLog("Verify Properties Private Tag","Verifying More options is displayed",Status.PASS);
		Utility_Functions.timeWait(2);
		Utility_Functions.xWaitForElementPresent(driver,more_PrivateTags, 3);
		Utility_Functions.xClick(driver,more_PrivateTags, true);
		report.updateTestLog("Verify Properties Private Tag","Verifying Private Tags is displayed",Status.PASS);
		Utility_Functions.timeWait(2);
		Utility_Functions.xWaitForElementPresent(driver,newPrivateTag, 3);
		Utility_Functions.xClick(driver,newPrivateTag, true);
		report.updateTestLog("Verify Properties Private Tag","Verifying the New Private Tags is displayed",Status.PASS);
		Utility_Functions.timeWait(5);
		Utility_Functions.xWaitForElementPresent(driver,privateTagName, 3);
		Utility_Functions.xClick(driver,privateTagName, true);
		report.updateTestLog("Verify Properties Private Tag","Verifying the New Private Tag name is displayed",Status.PASS);
		Utility_Functions.xWaitForElementPresent(driver,privateTagName, 3);
		Utility_Functions.xSendKeys(driver,privateTagName, "Test_" + Utility_Functions.xGenerateAlphaNumericString());
		report.updateTestLog("Verify Properties Private Tag","Verifying the Private Tag name is entered",Status.PASS);
		Utility_Functions.xWaitForElementPresent(driver,saveNewPrivateTag, 3);
		Utility_Functions.xClick(driver,saveNewPrivateTag, true);
		report.updateTestLog("Verify Properties Private Tag","Verifying the Private Tag name is entered and saved",Status.PASS);
		Utility_Functions.timeWait(5);
		Utility_Functions.xScrollWindow(driver);
		Utility_Functions.timeWait(1);
		Utility_Functions.xScrollWindowTop(driver);
		Utility_Functions.timeWait(2);
		Utility_Functions.xWaitForElementPresent(driver,newPropertiesDetailsPage, 3);
		Utility_Functions.xClick(driver,newPropertiesDetailsPage, true);
		report.updateTestLog("Verify Properties Private Tag","Verifying the New Property is displayed",Status.PASS);
		Utility_Functions.timeWait(2);
		Utility_Functions.xWaitForElementPresent(driver,newPropertiesDetailsPage, 3);
		SearchTextSOQL property = new SearchTextSOQL(scriptHelper);
		String propertyName = property.fetchRecord("Property__c", "Name");
		searchPropertyWithPrivateTag.sendKeys(propertyName);
		//Utility_Functions.xSendKeys(driver,newPropertiesDetailsPage, "T");
		searchPropertyWithPrivateTag.sendKeys(Keys.ARROW_DOWN);
		searchPropertyWithPrivateTag.sendKeys(Keys.ENTER);
		report.updateTestLog("Verify Properties Private Tag","Verifying the Property name is entered in the new property page",Status.PASS);
		Utility_Functions.xWaitForElementPresent(driver,savePropertyPrivateTag, 3);
		Utility_Functions.xClick(driver,savePropertyPrivateTag, true);
		report.updateTestLog("Verify Properties Private Tag","Verifying the Property name is entered and new property is saved",Status.PASS);

	}
	/**
	 * Validating the Properties Preferences Pyeong Value
	 * 
	 * @author Ramya
	 *
	 */
	public void verifyPropertiesPreferencesPyeongValue(){

		Utility_Functions.xWaitForElementPresent(driver,menu_More, 3);
		Utility_Functions.xClick(driver, menu_More, true);
		report.updateTestLog("Verify Properties Preferences Pyeong Value","Verifying More options is displayed",Status.PASS);
		Utility_Functions.timeWait(2);
		Utility_Functions.xWaitForElementPresent(driver,more_propertyPreferences, 3);
		Utility_Functions.xClick(driver,more_propertyPreferences, true);
		report.updateTestLog("Verify Properties Preferences Pyeong Value","Verifying Property Preferences is displayed",Status.PASS);
		Utility_Functions.timeWait(2);
		Utility_Functions.xWaitForElementPresent(driver,newPropertiesPreferences, 3);
		Utility_Functions.xClick(driver,newPropertiesPreferences, true);
		report.updateTestLog("Verify Properties Preferences Pyeong Value","Verifying the new Properties Preferences is displayed",Status.PASS);
		Utility_Functions.timeWait(5);
		Utility_Functions.xScrollWindow(driver);
		Utility_Functions.timeWait(1);
		Utility_Functions.xScrollWindowTop(driver);
		Utility_Functions.timeWait(2);
		Utility_Functions.xWaitForElementPresent(driver,unitOfMeasure, 3);
		Utility_Functions.xClick(driver,unitOfMeasure, true);
		report.updateTestLog("Verify Properties Preferences Pyeong Value ",
				"Verifying the unit of measure is displayed and clicked", Status.PASS);
		Utility_Functions.timeWait(1);
		String sPyeong = "Pyeong";
		List<WebElement> unitOfMeasurePickList = driver.findElements(By.xpath("//div[@class='select-options']/ul/li/a"));

		for(WebElement element: unitOfMeasurePickList ) {
			element.getText();
			System.out.println(element.getText());
			if(element.getText().equals(sPyeong)) {
				System.out.println("Pyeong pick list value is present in the Unit of Measure pick list values");
				report.updateTestLog("Verify Properties Preferences Pyeong Value",
						"Verifying the new Properties Preferences page Pyeong Value is displayed ", Status.PASS);

				break;
			}
		}

	}
	/**
	 * Validating the Project Enquiries for the Pyeong Value
	 * 
	 * @author Ramya
	 *
	 */
	public void verifyProjectEnquiriesPyeongValue(){

		Utility_Functions.xWaitForElementPresent(driver,menu_More, 3);
		Utility_Functions.xClick(driver, menu_More, true);
		report.updateTestLog("Verify Project Enquiries Pyeong Value","Verifying More options is displayed",Status.PASS);
		Utility_Functions.timeWait(2);
		Utility_Functions.xWaitForElementPresent(driver,more_projectEnquiries, 3);
		Utility_Functions.xClick(driver,more_projectEnquiries, true);
		report.updateTestLog("Verify Project Enquiries Pyeong Value","Verifying Project Enquiries is displayed",Status.PASS);
		Utility_Functions.timeWait(2);
		Utility_Functions.xWaitForElementPresent(driver,newPropertiesPreferences, 3);
		Utility_Functions.xClick(driver,newPropertiesPreferences, true);
		report.updateTestLog("Verify Project Enquiries Pyeong Value","Verifying the new Project Enquiries is displayed",Status.PASS);
		Utility_Functions.timeWait(5);
		Utility_Functions.xScrollWindow(driver);
		Utility_Functions.timeWait(1);
		Utility_Functions.xScrollWindowTop(driver);
		Utility_Functions.timeWait(2);
		Utility_Functions.xWaitForElementPresent(driver,unitOfMeasureProjectEnquiries, 3);
		Utility_Functions.xClick(driver,unitOfMeasureProjectEnquiries, true);
		report.updateTestLog("Verify Project Enquiries Pyeong Value",
				"Verifying the unit of measure is displayed and clicked", Status.PASS);
		Utility_Functions.timeWait(1);
		String sPyeong = "Pyeong";
		List<WebElement> unitOfMeasurePickList = driver.findElements(By.xpath("//div[@class='select-options']/ul/li/a"));

		for(WebElement element: unitOfMeasurePickList ) {
			element.getText();
			System.out.println(element.getText());
			if(element.getText().equals(sPyeong)) {
				System.out.println("Pyeong pick list value is present in the Unit of Measure pick list values");
				report.updateTestLog("Verify Project Enquiries Pyeong Value",
						"The new Project Enquiries page Pyeong Value is displayed ", Status.PASS);

				break;
			}
		}

	}
	/**
	 * Validating the Properties Pyeong Value
	 * 
	 * @author Ramya
	 *
	 */
	public void verifyPropertiesPyeongValue(){

		try{
			Utility_Functions.xWaitForElementPresent(driver,menu_Properties, 3);
			Utility_Functions.xClick(driver, menu_Properties, true);
		}catch(Exception e){
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
		/*	report.updateTestLog("Verify Properties Preferences Pyeong Value","Verifying More options is displayed",Status.PASS);
		Utility_Functions.timeWait(2);
		Utility_Functions.xWaitForElementPresent(driver,menu_Properties, 3);
		Utility_Functions.xClick(driver,menu_Properties, true);
		report.updateTestLog("Verify Properties Preferences Pyeong Value","Verifying Property Preferences is displayed",Status.PASS);*/
		Utility_Functions.timeWait(2);
		Utility_Functions.xWaitForElementPresent(driver, newProperties, 2);
		Utility_Functions.xClick(driver, newProperties, true);	
		Utility_Functions.timeWait(2);
		Utility_Functions.xSwitchtoFrame(driver, saveProperty);
		Utility_Functions.timeWait(5);
		Utility_Functions.xScrollWindow(driver);
		Utility_Functions.timeWait(1);
		Utility_Functions.xScrollWindowTop(driver);
		Utility_Functions.timeWait(2);
		Utility_Functions.xWaitForElementPresent(driver,unitOfMeasureProperties, 3);
		Utility_Functions.xClick(driver,unitOfMeasureProperties, true);
		report.updateTestLog("Verify Properties Preferences Pyeong Value ",
				"Verifying the unit of measure is displayed and clicked", Status.PASS);
		Utility_Functions.timeWait(1);
		String sPyeong = "Pyeong";
		List<WebElement> unitOfMeasurePickList = driver.findElements(By.xpath("//select[contains(@id,'UnitsofMeasureAPAC')]/option"));

		for(WebElement element: unitOfMeasurePickList ) {
			element.getText();
			System.out.println(element.getText());
			if(element.getText().equals(sPyeong)) {
				System.out.println("Pyeong pick list value is present in the Unit of Measure pick list values");
				report.updateTestLog("Verify Properties Preferences Ping Value",
						"Verifying the new Properties Preferences page Pyeong Value is displayed ", Status.PASS);

				break;
			}
		}

	}
	/**
	 * Validating the Properties Ping Value
	 * 
	 * @author Ramya
	 *
	 */
	public void verifyPropertiesPingValue(){
		try {
			Utility_Functions.xWaitForElementPresent(driver,menu_Properties, 3);
			Utility_Functions.xClick(driver, menu_Properties, true);
		} catch(Exception e){
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
		/*	Utility_Functions.xWaitForElementPresent(driver,menu_More, 3);
		Utility_Functions.xClick(driver, menu_More, true);
		report.updateTestLog("Verify Properties Preferences Ping Value","Verifying More options is displayed",Status.PASS);
		Utility_Functions.timeWait(2);
		Utility_Functions.xWaitForElementPresent(driver,menu_Properties, 3);
		Utility_Functions.xClick(driver,menu_Properties, true);
		report.updateTestLog("Verify Properties Preferences Ping Value","Verifying Property Preferences is displayed",Status.PASS);*/
		Utility_Functions.timeWait(2);
		Utility_Functions.xWaitForElementPresent(driver, newProperties, 2);
		Utility_Functions.xClick(driver, newProperties, true);	
		Utility_Functions.timeWait(2);
		Utility_Functions.xSwitchtoFrame(driver, saveProperty);
		Utility_Functions.timeWait(5);
		Utility_Functions.xScrollWindow(driver);
		Utility_Functions.timeWait(1);
		Utility_Functions.xScrollWindowTop(driver);
		Utility_Functions.timeWait(2);
		Utility_Functions.xWaitForElementPresent(driver,unitOfMeasureProperties, 3);
		Utility_Functions.xClick(driver,unitOfMeasureProperties, true);
		report.updateTestLog("Verify Properties Preferences Ping Value ",
				"Verifying the unit of measure is displayed and clicked", Status.PASS);
		Utility_Functions.timeWait(1);
		String sPing = "Ping";
		List<WebElement> unitOfMeasurePickList = driver.findElements(By.xpath("//select[contains(@id,'UnitsofMeasureAPAC')]/option"));

		for(WebElement element: unitOfMeasurePickList ) {
			element.getText();
			System.out.println(element.getText());
			if(element.getText().equals(sPing)) {
				System.out.println("Ping pick list value is present in the Unit of Measure pick list values");
				report.updateTestLog("Verify Properties Preferences Ping Value",
						"Verifying the new Properties Preferences page Ping Value is displayed ", Status.PASS);

				break;
			}
		}

	}
	/**
	 * Validating the Properties Preferences Ping Value
	 * 
	 * @author Ramya
	 *
	 */
	public void verifyPropertiesPreferencesPingValue(){

		Utility_Functions.xWaitForElementPresent(driver,menu_More, 3);
		Utility_Functions.xClick(driver, menu_More, true);
		report.updateTestLog("Verify Properties Preferences Ping Value","Verifying More options is displayed",Status.PASS);
		Utility_Functions.timeWait(2);
		Utility_Functions.xWaitForElementPresent(driver,more_propertyPreferences, 3);
		Utility_Functions.xClick(driver,more_propertyPreferences, true);
		report.updateTestLog("Verify Properties Preferences Ping Value","Verifying Property Preferences is displayed",Status.PASS);
		Utility_Functions.timeWait(2);
		Utility_Functions.xWaitForElementPresent(driver,newPropertiesPreferences, 3);
		Utility_Functions.xClick(driver,newPropertiesPreferences, true);
		report.updateTestLog("Verify Properties Preferences Ping Value","Verifying the new Properties Preferences is displayed",Status.PASS);
		Utility_Functions.timeWait(5);
		Utility_Functions.xScrollWindow(driver);
		Utility_Functions.timeWait(1);
		Utility_Functions.xScrollWindowTop(driver);
		Utility_Functions.timeWait(2);
		Utility_Functions.xWaitForElementPresent(driver,unitOfMeasure, 3);
		Utility_Functions.xClick(driver,unitOfMeasure, true);
		report.updateTestLog("Verify Properties Preferences Pyeong Value ",
				"Verifying the unit of measure is displayed and clicked", Status.PASS);
		Utility_Functions.timeWait(1);
		String sPing = "Ping";
		List<WebElement> unitOfMeasurePickList = driver.findElements(By.xpath("//div[@class='select-options']/ul/li/a"));

		for(WebElement element: unitOfMeasurePickList ) {
			element.getText();
			System.out.println(element.getText());
			if(element.getText().equals(sPing)) {
				System.out.println("Ping pick list value is present in the Unit of Measure pick list values");
				report.updateTestLog("Verify Properties Preferences Ping Value",
						"Verifying the new Properties Preferences page Ping Value is displayed ", Status.PASS);

				break;
			}
		}

	}
	/**
	 * Validating the Project Enquiries for the Ping Value
	 * 
	 * @author Ramya
	 *
	 */
	public void verifyProjectEnquiriesPingValue(){

		Utility_Functions.xWaitForElementPresent(driver,menu_More, 3);
		Utility_Functions.xClick(driver, menu_More, true);
		report.updateTestLog("Verify Project Enquiries Ping Value","Verifying More options is displayed",Status.PASS);
		Utility_Functions.timeWait(2);
		Utility_Functions.xWaitForElementPresent(driver,more_projectEnquiries, 3);
		Utility_Functions.xClick(driver,more_projectEnquiries, true);
		report.updateTestLog("Verify Project Enquiries Ping Value","Verifying Project Enquiries is displayed",Status.PASS);
		Utility_Functions.timeWait(2);
		Utility_Functions.xWaitForElementPresent(driver,newPropertiesPreferences, 3);
		Utility_Functions.xClick(driver,newPropertiesPreferences, true);
		report.updateTestLog("Verify Project Enquiries Ping Value","Verifying the new Project Enquiries is displayed",Status.PASS);
		Utility_Functions.timeWait(5);
		Utility_Functions.xScrollWindow(driver);
		Utility_Functions.timeWait(1);
		Utility_Functions.xScrollWindowTop(driver);
		Utility_Functions.timeWait(2);
		Utility_Functions.xWaitForElementPresent(driver,unitOfMeasureProjectEnquiries, 3);
		Utility_Functions.xClick(driver,unitOfMeasureProjectEnquiries, true);
		report.updateTestLog("Verify Project Enquiries Ping Value",
				"Verifying the unit of measure is displayed and clicked", Status.PASS);
		Utility_Functions.timeWait(1);
		String sPing = "Ping";
		List<WebElement> unitOfMeasurePickList = driver.findElements(By.xpath("//div[@class='select-options']/ul/li/a"));

		for(WebElement element: unitOfMeasurePickList ) {
			element.getText();
			System.out.println(element.getText());
			if(element.getText().equals(sPing)) {
				System.out.println("Ping pick list value is present in the Unit of Measure pick list values");
				report.updateTestLog("Verify Project Enquiries Ping Value",
						"The new Project Enquiries page Ping Value is displayed ", Status.PASS);

				break;
			}
		}

	}
	/**
	 * Validating the Properties Preferences for the Preference Type values
	 * 
	 * @author Ramya
	 *
	 */
	static ArrayList<String> preferenceTypePickList = new ArrayList<String>();
	public void preferenceType() {

		preferenceTypePickList.add("--None--");
		preferenceTypePickList.add("Sale");
		preferenceTypePickList.add("Lease");

		System.out.println("Preference Type Pick List values are " +preferenceTypePickList);
	}
	public void verifyPreferenceTypevalues(){

		Utility_Functions.xWaitForElementPresent(driver,menu_More, 3);
		Utility_Functions.xClick(driver, menu_More, true);
		report.updateTestLog("Verify Preferences Type Values","Verifying More options is displayed",Status.PASS);
		Utility_Functions.timeWait(2);
		Utility_Functions.xWaitForElementPresent(driver,more_propertyPreferences, 3);
		Utility_Functions.xClick(driver,more_propertyPreferences, true);
		report.updateTestLog("Verify Preferences Type Values","Verifying Property Preferences is displayed",Status.PASS);
		Utility_Functions.timeWait(2);
		Utility_Functions.xWaitForElementPresent(driver,newPropertiesPreferences, 3);
		Utility_Functions.xClick(driver,newPropertiesPreferences, true);
		report.updateTestLog("Verify Preferences Type Values","Verifying the new Properties Preferences is displayed",Status.PASS);
		Utility_Functions.timeWait(5);
		Utility_Functions.xScrollWindow(driver);
		Utility_Functions.timeWait(1);
		Utility_Functions.xScrollWindowTop(driver);
		Utility_Functions.timeWait(2);
		Utility_Functions.xWaitForElementPresent(driver,preferenceType, 3);
		Utility_Functions.xClick(driver,preferenceType, true);
		report.updateTestLog("Verify Preferences Type Values ",
				"Verifying the unit of measure is displayed and clicked", Status.PASS);
		List<WebElement> preferenceTypePickListValues = driver.findElements(By.xpath("//div[@class='select-options']/ul/li/a"));
		int count4 = 0, i4 = 0;
		String fieldsArray4[] = new String[preferenceTypePickListValues.size()];
		System.out.println(preferenceTypePickListValues.size());
		try {
			preferenceType();
			for (WebElement element4 :preferenceTypePickListValues) {
				System.out.println(element4.getText());
				fieldsArray4[i4] = element4.getText();
				if (fieldsArray4[i4].contains(preferenceTypePickList.get(i4))) {
					report.updateTestLog("Verify Preferences Type Values",
							"Preferences Type pick list is having the " + fieldsArray4[i4] + " fields ",
							Status.PASS);
					count4++;
				}
				i4++;
			}
			System.out.println(count4);
			if (count4!= 2) {
				report.updateTestLog("Verify Preferences Type Values ", "All fields are not present in the Preferences Type pick list ", Status.FAIL);
			} else {

				report.updateTestLog("Verify Preferences Type Values", "All fields are present in the Preferences Type pick list", Status.PASS);
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

	}
	/**
	 * Validating the offer enquiry auto populated from the project enquiries
	 * 
	 * @author Ramya
	 *
	 */
	public void verifyOfferAutoPopulatedByProjectEnquiries(){

		Utility_Functions.xWaitForElementPresent(driver,menu_More, 3);
		Utility_Functions.xClick(driver, menu_More, true);
		report.updateTestLog("Verify Offer Auto Populated By Project Enquiries","Verifying More options is displayed",Status.PASS);
		Utility_Functions.timeWait(2);
		Utility_Functions.xWaitForElementPresent(driver,more_projectEnquiries, 3);
		Utility_Functions.xClick(driver,more_projectEnquiries, true);
		report.updateTestLog("Verify Offer Auto Populated By Project Enquiries","Verifying Project Enquiries is displayed",Status.PASS);
		Utility_Functions.timeWait(2);
		Utility_Functions.xWaitForElementPresent(driver,newPropertiesPreferences, 3);
		Utility_Functions.xClick(driver,newPropertiesPreferences, true);
		report.updateTestLog("Verify Offer Auto Populated By Project Enquiries","Verifying the new Project Enquiries is displayed",Status.PASS);
		String environment = loginPage.initializeEnvironment();
		if (environment.equals("FTE")) {
			Utility_Functions.xWaitForElementPresent(driver,nextNewProjectEnquiry, 3);
			Utility_Functions.xClick(driver,nextNewProjectEnquiry,true);
		}
		Utility_Functions.timeWait(5);
		Utility_Functions.xScrollWindow(driver);
		Utility_Functions.timeWait(1);
		Utility_Functions.xScrollWindowTop(driver);
		Utility_Functions.timeWait(2);
		Utility_Functions.xWaitForElementPresent(driver,projectEnquiryName, 3);
		Utility_Functions.xSendKeys(driver,projectEnquiryName, "Test Automation_" + Utility_Functions.xGenerateAlphaNumericString());
		Utility_Functions.xWaitForElementPresent(driver,enquiryAccount, 3);
		Utility_Functions.xClick(driver,enquiryAccount, true);
		Utility_Functions.xWaitForElementPresent(driver,enquiryAccount, 3);
		Utility_Functions.xSendKeys(driver,enquiryAccount, "AUCAPACBroker123");
		Utility_Functions.xWaitForElementPresent(driver,enquiryAccountValue, 3);
		Utility_Functions.xClick(driver,enquiryAccountValue, true);
		Utility_Functions.xWaitForElementPresent(driver,enquiryContact, 3);
		Utility_Functions.xClick(driver,enquiryContact, true);
		Utility_Functions.xWaitForElementPresent(driver,enquiryContact, 3);
		Utility_Functions.xSendKeys(driver,enquiryContact, "AUCAPACBroker123");
		Utility_Functions.xWaitForElementPresent(driver,enquiryContactValue, 3);
		Utility_Functions.xClick(driver,enquiryContactValue, true);
		Utility_Functions.xWaitForElementPresent(driver,projectEnquirySave, 3);
		Utility_Functions.xClick(driver,projectEnquirySave, true);


	}
	/**
	 * Validating the Country field in the Properties
	 * 
	 * @author Ramya
	 *
	 */	
	public void verifyPropertiesCountryField() {
		try{
			Utility_Functions.xWaitForElementPresent(driver,menu_Properties, 3);
			Utility_Functions.xClick(driver, menu_Properties, true);
		}catch(Exception e){
			Utility_Functions.xWaitForElementPresent(driver, menu_More, 3);
			Utility_Functions.xClick(driver, menu_More, true);
			Utility_Functions.xWaitForElementPresent(driver, properties, 2);
			Utility_Functions.xClick(driver, properties, true);	
		}
		report.updateTestLog("Verify Properties Country Field ","Properties is Displayed ",  Status.PASS);
		Utility_Functions.xWaitForElementPresent(driver, recentlyViewed, 3);
		Utility_Functions.xClick(driver, recentlyViewed, true);
		report.updateTestLog("Verify Properties Country Field  ","Recently viewed Properties are Displayed ",  Status.PASS);
		Utility_Functions.xWaitForElementPresent(driver, allProperties, 3);
		Utility_Functions.xClick(driver, allProperties, true);
		Utility_Functions.timeWait(3);
		report.updateTestLog("Verify Properties Country Field  ","All Properties are Displayed ",  Status.PASS);
		try{
			List<WebElement> propertiesList = driver.findElements(By.xpath(".//a[@class='slds-truncate outputLookupLink slds-truncate forceOutputLookup']"));

			Utility_Functions.xclickOnFirstElementfromList(propertiesList);	
			Utility_Functions.timeWait(3);
			SearchTextSOQL searchTextSOQL = new SearchTextSOQL(scriptHelper);
			String queryId = "SELECT 	Sharing_Country__c, Id FROM Property__c where 	Sharing_Country__c = 'New Zealand'";
			String propertyId = searchTextSOQL.fetchRecordFieldValue("Id", queryId);
			String url = driver.getCurrentUrl().split("#")[0];
			String newUrl = url + "#/sObject/" + propertyId;
			newUrl = newUrl + "/view";
			driver.get(newUrl);
			driver.navigate().refresh();
			Utility_Functions.timeWait(3);
			if(countryFieldNewZealand.isDisplayed()) {

				report.updateTestLog("Verify Properties Country Field ", "The Properties country field is New Zealand ", Status.PASS);
			} else {
				report.updateTestLog("Verify Properties Country Field ", "The Properties country field is not New Zealand", Status.FAIL);
			}

		}catch(Exception e){
			System.out.println("there are no properties displayed");
			report.updateTestLog("Verify Properties Country Field",
					"The properties are not displayed", Status.PASS);

		}

	}
	/**
	 * Validating the Properties Preferences property type and region
	 * 
	 * @author Ramya
	 *
	 */	
	public void verifyPreferencesPropertyType() {
		Utility_Functions.xWaitForElementPresent(driver, applauncher, 3);
		Utility_Functions.xClick(driver, applauncher, true);
		Utility_Functions.timeWait(2);
		Utility_Functions.xWaitForElementPresent(driver,preferences, 3);
		Utility_Functions.xClick(driver, preferences, true);
		report.updateTestLog("Verify Preferences Property Type ","Preferences is Displayed ",  Status.PASS);
		Utility_Functions.xWaitForElementPresent(driver, recentlyViewed, 3);
		Utility_Functions.xClick(driver, recentlyViewed, true);
		report.updateTestLog("Verify Preferences Property Type ","Recently viewed Properties are Displayed ",  Status.PASS);
		Utility_Functions.xWaitForElementPresent(driver,allInvestorPreferences, 3);
		Utility_Functions.xClick(driver,allInvestorPreferences, true);
		Utility_Functions.timeWait(3);
		report.updateTestLog("Verify Preferences Property Type","All Properties are Displayed ",  Status.PASS);
		List<WebElement> propertiesList = driver.findElements(By.xpath("//a[@class='slds-truncate outputLookupLink slds-truncate forceOutputLookup']"));
		if(propertiesList.isEmpty()) {
			report.updateTestLog("Verify Preferences Property Type", "List is Empty:::", Status.PASS);
		} else {
			Utility_Functions.xclickOnFirstElementfromList(propertiesList);	
			Utility_Functions.timeWait(2);
			if(dataTable.getData("General_Data", "TC_ID").contains("CMAPACBrokerAUS")) {
				if((preferenceTypeSale.isDisplayed())&& (industrialPropertyType.isDisplayed()) && (regionSA.isDisplayed())) {
					report.updateTestLog("Verify Preferences Property Type", "The Preference property type is sale, Property type is Industrial and the region is SA", Status.PASS);
				} else {
					report.updateTestLog("Verify Preferences Property Type", "The Preference property type is not sale and property type is not Industrial and the region is not SA", Status.FAIL);
				}
			} else if(dataTable.getData("General_Data", "TC_ID").contains("CMAPACBrokerNSW")) {
				if((preferenceTypeLease.isDisplayed())&& (retailPropertyType.isDisplayed()) && (regionNSW.isDisplayed())) {
					report.updateTestLog("Verify Preferences Property Type", "The Preference property type is lease, Property type is Retail and the region is NSW", Status.PASS);
				} else {
					report.updateTestLog("Verify Preferences Property Type", "The Preference property type is not lease, Property type is not Retail and the region is not NSW", Status.FAIL);
				}
			} else if(dataTable.getData("General_Data", "TC_ID").contains("CMAPACBrokerChristChurch")) {
				if((preferenceTypeLease.isDisplayed())&& (retailPropertyType.isDisplayed()) && (regionChristchurch.isDisplayed())) {
					report.updateTestLog("Verify Preferences Property Type", "The Preference property type is lease, Property type is Retail and the region is Christchurch", Status.PASS);
				} else {
					report.updateTestLog("Verify Preferences Property Type", "The Preference property type is not lease, Property type is not Retail and the region is not Christchurch", Status.FAIL);
				}
			}
		}

	}
	/**
	 * Validating the Project Enquiry page fields
	 * 
	 * @author Ramya
	 *
	 */
	static ArrayList<String> projectEnquiriesFieldsList = new ArrayList<String>();
	public void projectEnquiriesFields() {

		projectEnquiriesFieldsList.add("Project Enquiry Name");
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
		projectEnquiriesFieldsList.add("Broker Feedback");

		System.out.println("Project Enquiries fields are " + projectEnquiriesFieldsList);
	}
	public void verifyProjectEnquiriesPageFields(){
		Utility_Functions.xWaitForElementPresent(driver,menu_More, 3);
		Utility_Functions.xClick(driver, menu_More, true);
		report.updateTestLog("Verify Project Enquiries Page Fields","Verifying More options is displayed",Status.PASS);
		Utility_Functions.timeWait(2);
		Utility_Functions.xWaitForElementPresent(driver,more_projectEnquiries, 3);
		Utility_Functions.xClick(driver,more_projectEnquiries, true);
		report.updateTestLog("Verify Project Enquiries Page Fields","Verifying Project Enquiries is displayed",Status.PASS);
		Utility_Functions.timeWait(2);
		Utility_Functions.xWaitForElementPresent(driver,newPropertiesPreferences, 3);
		Utility_Functions.xClick(driver,newPropertiesPreferences, true);
		report.updateTestLog("Verify Project Enquiries Page Fields","Verifying the new Project Enquiries is displayed",Status.PASS);
		Utility_Functions.xWaitForElementPresent(driver,nextNewProjectEnquiry, 3);
		Utility_Functions.xClick(driver,nextNewProjectEnquiry,true);
		List<WebElement> projectEnquiryPageValues = driver.findElements(By.xpath("//label[contains(@class,'inputLabel')]/span[1]"));
		int count4 = 0, i4 = 0;
		String fieldsArray4[] = new String[projectEnquiryPageValues.size()];
		System.out.println(projectEnquiryPageValues.size());
		try {
			projectEnquiriesFields();
			for (WebElement element4 :projectEnquiryPageValues) {
				System.out.println(element4.getText());
				fieldsArray4[i4] = element4.getText();
				if (fieldsArray4[i4].contains(projectEnquiriesFieldsList.get(i4))) {
					report.updateTestLog("Verify Project Enquiries Page Fields",
							"Project Enquiries page is having the " + fieldsArray4[i4] + " fields ",
							Status.PASS);
					count4++;
				}
				i4++;
			}
			System.out.println(count4);
			if (count4!= 13) {
				report.updateTestLog("Verify Project Enquiries Page Fields", "All fields are not present in the Project Enquiry page ", Status.FAIL);
			} else {

				report.updateTestLog("Verify Project Enquiries Page Fields", "All fields are present in the Project Enquiry page", Status.PASS);
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		Utility_Functions.timeWait(5);
		Utility_Functions.xScrollWindow(driver);
		Utility_Functions.timeWait(1);
		Utility_Functions.xScrollWindowTop(driver);
		Utility_Functions.timeWait(2);
		Utility_Functions.xWaitForElementPresent(driver,projectEnquiryName, 3);
		Utility_Functions.xSendKeys(driver,projectEnquiryName, "Test Automation_" + Utility_Functions.xGenerateAlphaNumericString());
		Utility_Functions.xWaitForElementPresent(driver,enquiryContact, 3);
		Utility_Functions.xClick(driver, enquiryContact, true);
		//Utility_Functions.xSendKeys(driver,enquiryContact, "AUCAPACBroker");
		Utility_Functions.xWaitForElementPresent(driver, firstLookUpElement, 3);
		Utility_Functions.xClick(driver, firstLookUpElement, true);
		/*Utility_Functions.xWaitForElementPresent(driver,enquiryContactValue, 3);
	Utility_Functions.xClick(driver,enquiryContactValue, true);
		 */Utility_Functions.xWaitForElementPresent(driver,enquiryAccount, 3);
		 Utility_Functions.xClick(driver, enquiryAccount, true);
		 //Utility_Functions.xSendKeys(driver,enquiryAccount, "AUCAPACBroker");
		 Utility_Functions.xWaitForElementPresent(driver, firstLookUpElement, 3);
		 Utility_Functions.xClick(driver, firstLookUpElement, true);
		 /*Utility_Functions.xWaitForElementPresent(driver,enquiryAccountValue, 3);
	Utility_Functions.xClick(driver,enquiryAccountValue, true);*/
		 Utility_Functions.xWaitForElementPresent(driver,projectEnquirySave, 3);
		 Utility_Functions.xClick(driver,projectEnquirySave, true);
	}
	/**
	 * Validating the Project Enquiries Enhancements
	 * 
	 * @author Ramya
	 *
	 */


	public void verifyProjectEnquiriesEnhancements(){	

		verifyProjectEnquiriesPageFields();


	}
	/**
	 * Validating the Properties edit page
	 * 
	 * @author Ramya
	 *
	 */


	public void verifyPropertiesEditPage(){	

		try{
			Utility_Functions.xWaitForElementPresent(driver,menu_Properties, 3);
			Utility_Functions.xClick(driver, menu_Properties, true);
		}catch(Exception e){
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

		List<WebElement> recentlyViewedpropertiesList = driver.findElements(By.xpath("//a[@class='slds-truncate outputLookupLink slds-truncate forceOutputLookup']"));
		Utility_Functions.xclickOnFirstElementfromList(recentlyViewedpropertiesList);
		Utility_Functions.xWaitForElementPresent(driver,showMoreActions, 2);
		Utility_Functions.xClick(driver,showMoreActions, true);
		Utility_Functions.xWaitForElementPresent(driver,edit, 2);
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
		Select office =  new Select(propertyTypeHotel);
		office.selectByVisibleText("Office");
		Utility_Functions.xWaitForElementPresent(driver,addButton, 3);
		Utility_Functions.xClick(driver,addButton, true);
		Utility_Functions.xWaitForElementPresent(driver,commercialBuilding, 3);
		Utility_Functions.xClick(driver,commercialBuilding, true);

	}
	/**
	 * Validating the Properties Preferences creation
	 * 
	 * @author Ramya
	 *
	 */
	public void verifyPropertiesPreferencesCreation(){

		Utility_Functions.xWaitForElementPresent(driver,menu_More, 3);
		Utility_Functions.xClick(driver, menu_More, true);
		report.updateTestLog("Verify Properties Preferences Pyeong Value","Verifying More options is displayed",Status.PASS);
		Utility_Functions.timeWait(2);
		Utility_Functions.xWaitForElementPresent(driver,more_propertyPreferences, 3);
		Utility_Functions.xClick(driver,more_propertyPreferences, true);
		report.updateTestLog("Verify Properties Preferences Pyeong Value","Verifying Property Preferences is displayed",Status.PASS);
		Utility_Functions.timeWait(2);
		Utility_Functions.xWaitForElementPresent(driver,newPropertiesPreferences, 3);
		Utility_Functions.xClick(driver,newPropertiesPreferences, true);
		report.updateTestLog("Verify Properties Preferences Pyeong Value","Verifying the new Properties Preferences is displayed",Status.PASS);
		Utility_Functions.timeWait(5);
		Utility_Functions.xScrollWindow(driver);
		Utility_Functions.timeWait(1);
		Utility_Functions.xScrollWindowTop(driver);
		Utility_Functions.timeWait(2);


	}
	/**
	 * Validating the Properties Preferences creation
	 * 
	 * @author Ramya
	 *
	 */	
	public void verifyPreferencesPropertiesCreation() {
		Utility_Functions.xWaitForElementPresent(driver, applauncher, 3);
		Utility_Functions.xClick(driver, applauncher, true);
		Utility_Functions.timeWait(2);
		Utility_Functions.xWaitForElementPresent(driver,preferences, 3);
		Utility_Functions.xClick(driver, preferences, true);
		report.updateTestLog("Verify Preferences Property Type ","Preferences is Displayed ",  Status.PASS);
		Utility_Functions.xWaitForElementPresent(driver,newPropertiesPreferences, 3);
		Utility_Functions.xClick(driver,newPropertiesPreferences, true);
		report.updateTestLog("Verify Preferences Property Type ","Recently viewed Properties are Displayed ",  Status.PASS);
		Utility_Functions.xWaitForElementPresent(driver,apacPropertyPreferences, 3);
		Utility_Functions.xClick(driver,apacPropertyPreferences, true);
		Utility_Functions.xWaitForElementPresent(driver,nextPropertyPreferences, 3);
		Utility_Functions.xClick(driver,nextPropertyPreferences, true);
		Utility_Functions.timeWait(2);
		Utility_Functions.xWaitForElementPresent(driver,searchContacts, 3);
		Utility_Functions.xSendKeys(driver,searchContacts, "TestAMER CMBroker");
		Utility_Functions.xWaitForElementPresent(driver,contactsValue, 3);
		Utility_Functions.xClick(driver,contactsValue, true);
		Utility_Functions.xWaitForElementPresent(driver,preferenceType, 3);
		Utility_Functions.xClick(driver,preferenceType, true);
		Utility_Functions.xWaitForElementPresent(driver,preferenceTypeValue, 3);
		Utility_Functions.xClick(driver,preferenceTypeValue, true);
		Utility_Functions.xWaitForElementPresent(driver,propertyType, 3);
		Utility_Functions.xClick(driver,propertyType, true);
		Utility_Functions.xWaitForElementPresent(driver,propertyTypeHotelValue, 3);
		Utility_Functions.xClick(driver,propertyTypeHotelValue, true);



	}

	public void propertyTagging () {

		Utility_Functions.xClick(driver, menu_More, true);
		Utility_Functions.xWaitForElementPresent(driver,properties, 3);
		Utility_Functions.xClick(driver, properties, true);
		Utility_Functions.xWaitForElementPresent(driver,recentlyViewed, 3);
		Utility_Functions.xClick(driver, recentlyViewed, true);
		Utility_Functions.xWaitForElementPresent(driver,allProperties, 3);
		Utility_Functions.xClick(driver, allProperties, true);
		Utility_Functions.timeWait(2);
		Utility_Functions.xClick(driver, PropertyList, true);
		Utility_Functions.timeWait(2);
		Utility_Functions.xSwitchtoFrame(driver, addTag);
		Utility_Functions.xClick(driver, addTag, true);
		Utility_Functions.xSendKeys(driver, privatetag, dataTable.getData("General_Data", "Private Tag"));
		Utility_Functions.xClickHiddenElement(driver, savePrivateTag);
		Utility_Functions.xWaitForElementPresent(driver,addTag, 3);

		if(addTag.isDisplayed()){
			report.updateTestLog("Verify Opportunity Private Tags", "The Private Tag is saved",
					Status.PASS);		
		}else{
			report.updateTestLog("Verify Opportunity Private Tags", "The Private tag is not saved",
					Status.FAIL);
		}

		Utility_Functions.xClick(driver, PrivateTagged, true);
		Utility_Functions.xSwitchtoFrame(driver, PrivateTagPage);
		Utility_Functions.xWaitForElementPresent(driver,PrivateTagPage, 3);

		if(PrivateTagPage.isDisplayed()){
			report.updateTestLog("Verify Property Private Tags", "The Tag is saved in Private Tag Page",
					Status.PASS);		
		}else{
			report.updateTestLog("Verify Property Private Tags", "The Tag is not saved in Private Tag Page",
					Status.FAIL);
		}
	}
	
	public void marketCreation () {
		Utility_Functions.xWaitForElementPresent(driver, applauncher, 3);
		Utility_Functions.xClick(driver, applauncher, true);
		Utility_Functions.timeWait(2);
		Utility_Functions.xClickHiddenElement(driver, marketingLists);
		Utility_Functions.xWaitForElementPresent(driver,newProperty, 3);
		Utility_Functions.xClick(driver, newProperty, true);
		Utility_Functions.xWaitForElementPresent(driver,marketListName, 3);
		Utility_Functions.xSendKeys(driver, marketListName, "Test");
		Utility_Functions.xSendKeys(driver, authorContact, "Test Broker6");
		Utility_Functions.timeWait(1);
		authorContact.sendKeys(Keys.ARROW_DOWN);
		authorContact.sendKeys(Keys.ENTER);
		Utility_Functions.xWaitForElementPresent(driver,notesTxtBx, 3);
		Utility_Functions.xSendKeys(driver, notesTxtBx, "Testing");
		Utility_Functions.xClick(driver, saveMarketList, true);
		Utility_Functions.xWaitForElementPresent(driver,newProperty, 3);
	}
	
	public void subscriptionCreation() {
		Utility_Functions.xWaitForElementPresent(driver, applauncher, 3);
		Utility_Functions.xClick(driver, applauncher, true);
		Utility_Functions.timeWait(2);
		Utility_Functions.xClickHiddenElement(driver, subscriptions);
		Utility_Functions.xWaitForElementPresent(driver,newProperty, 3);
		Utility_Functions.xClick(driver, newProperty, true);
		Utility_Functions.xWaitForElementPresent(driver, saveMarketList, 3);
		Utility_Functions.xSendKeys(driver, marketListSubscription, "Test");
		marketListSubscription.sendKeys(Keys.ARROW_DOWN);
		marketListSubscription.sendKeys(Keys.ENTER);
		Utility_Functions.xClick(driver, saveMarketList, true);
		
		if(newProperty.isDisplayed()){
			
			System.out.println("Subscription is created");
		}
		else {
			System.out.println("Subscription is not created");		
		}
		
	}
	
	public void propertyPreferenceUpdateClone(){
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
		//Utility_Functions.xSelectDropdownByValue(hotelStar, "5 star");
		Utility_Functions.xClick(driver, savePropertypreference, true);
		Utility_Functions.xWaitForElementPresent(driver, editProperty, 3);
		if(editProperty.isDisplayed()) {
			System.out.println("Property Preference is updated");
		}
		else {
			System.out.println("Proeprty Preference is not updated");
		}
		
	}
}



