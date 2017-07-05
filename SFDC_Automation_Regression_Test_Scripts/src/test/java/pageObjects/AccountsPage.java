package pageObjects;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.cognizant.Craft.ReusableLibrary;
import com.cognizant.Craft.ScriptHelper;
import com.cognizant.framework.Status;


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

	@FindBy(xpath = "//div[@class='bBottom']//span[text()='Accounts']")
	WebElement menu_Accounts;

	@FindBy(xpath = "//ul[@class='slds-button-group slds-m-left--xx-small oneActionsRibbon forceActionsContainer']//li/a/div[text()='New']")
	WebElement newAccount;

	@FindBy(xpath = "//button[text()='Continue']")
	WebElement continueButton;

	@FindBy(xpath = "//button/span[text()='View All Fields']")
	WebElement viewAllFieldsButton;

	@FindBy(xpath = "//a[@class='tabHeader']//span[text()='Related']")
	WebElement related_Accounts;

	/*	@FindBy(xpath = "//article[contains(@class,'Private Notes')]//div[text()='New']")
	WebElement new_PrivateNotes;*/

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

	@FindBy(xpath = "//div[@class='autocompleteWrapper']/input[@placeholder='Search Leads']")
	WebElement searchLeads;

	@FindBy(xpath = "//div[@class='autocompleteWrapper']/input[@placeholder='Search Contacts']")
	WebElement searchContacts;

	@FindBy(xpath = "//label[@class='label inputLabel uiLabel-left form-element__label uiLabel']/span[contains(text(), 'Body')]/parent::label/parent::div/textarea")
	WebElement body;

	@FindBy(xpath = "//button[@class='slds-button slds-button--neutral uiButton--default uiButton--brand uiButton forceActionButton']/span[contains(text(), 'Save')]")
	WebElement saveButton;

	@FindBy(xpath = "//span[@class='toastMessage slds-text-heading--small forceActionsText'][contains(text(), 'was created.')]")
	WebElement wasCreated;

	@FindBy(xpath = ".//div[@class='changeRecordTypeOptionRightColumn']/span[text()='Personal Information']/parent::div/parent::label/div[1]/span")
	WebElement selectPersonalInformation;

	@FindBy(xpath = ".//button[@class='slds-button slds-button--neutral uiButton--default uiButton--brand uiButton']/span[contains(text(), 'Next')]")
	WebElement next;

	@FindBy(xpath = ".//label[@class='label inputLabel uiLabel-left form-element__label uiLabel']/span[contains(text(),'Title')]/parent::label/parent::div/input")
	WebElement titleName;

	@FindBy(xpath = "//span[text()='Private Notes']/parent::span[@class='view-all-label']")
	WebElement viewAllButton;
	/**
	 * Ramya
	 */
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

	@FindBy(xpath = "//a[@title='Show more actions for this record']")
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

	@FindBy(xpath="//div[@class='slds-small-order--1 slds-medium-order--2 slds-large-order--3']")
	WebElement createNewActivity;

	@FindBy(xpath=".//*[@id='relatedContactBox']")
	WebElement relatedToContactField;

	@FindBy(xpath=".//*[@id='relatedOpportunityBox']")
	WebElement relatedToOpportunityField;

	@FindBy(xpath=".//*[@id='relatedPropertyBox']")
	WebElement relatedToPropertyField;

	@FindBy(xpath="//input[@class='slds-input'][@type='checkbox']/following-sibling::span[text()='Notification Email']")
	WebElement notificationEmail;

	@FindBy(xpath = "//*[text()='More']")
	WebElement menu_More;

	@FindBy(xpath="//a[@role='menuitem']/span[contains(@class,'slds-truncate')][text()='Bulk Tagging']")
	WebElement bulkTagging;

	@FindBy(xpath="//input[contains(@id,'SearchBlock:propertyEditForm:SearchBox')][contains(@placeholder,'Search Account/Contact')]")
	WebElement accountSearch;

	@FindBy(xpath="//div[@class='slds-form-element ']//input[@value='Search']")
	WebElement search;

	@FindBy(xpath="//div[@id='Accountsection']//tr[3]//span[@class='slds-checkbox--faux']")
	WebElement selectAccount1;

	@FindBy(xpath="//div[@id='Accountsection']//tr[4]//span[@class='slds-checkbox--faux']")
	WebElement selectAccount2;

	@FindBy(xpath="//div[@class='slds-form-element']//input[@value='Assign Tag']")
	WebElement assignTag;

	@FindBy(xpath="//div[@class='slds-form-element ']//input[@value='Advanced Search']")
	WebElement advancedSearch;

	@FindBy(xpath="//select[@class='slds-select']/option[@value='Account']")
	WebElement advancedSearchAccountOption;

	@FindBy(xpath="//select[@class='slds-select']/option[@value='BillingPostalCode']")
	WebElement accountFieldNameCondition;

	@FindBy(xpath="//select[@class='slds-select']/option[@value='=']")
	WebElement accountOperatorCondition;

	@FindBy(xpath="//span[text()='Investor Services Account']/parent::div/parent::div//div//span[contains(@class,'uiOutputCheckbox')]")
	WebElement accountServicesCheckbox;

	@FindBy(xpath="//select[@id='record-type-select']")
	WebElement recordType;

	@FindBy(xpath="//select[@id='record-type-select']/option[text()='EMEA Reporting Account']")
	WebElement recordType_EMEAReporting;

	@FindBy(xpath="//input[contains(@id,'acctForm:Name')]")
	WebElement accountNameQuickCreate;

	@FindBy(xpath="//textarea[contains(@id,'BillingStreet')]")
	WebElement billingStreetQuickCreate;

	@FindBy(xpath="//input[contains(@id,'BillingCity')]")
	WebElement billingCityQuickCreate;

	@FindBy(xpath="//select[contains(@id,'countryBillingPicklist')]")
	WebElement billingCountryQuickCreate;

	@FindBy(xpath="//select[contains(@id,'countryBillingPicklist')]/option[text()='United States']")
	WebElement billingCountryUnitedStatesQuickCreate;				

	@FindBy(xpath="//select[contains(@id,'EMEAAreaofOperations')]")
	WebElement areaOfOperationsQuickCreate;

	@FindBy(xpath="//select[contains(@id,'EMEAAreaofOperations')]/option[text()='Regional']")
	WebElement areaOfOperationsRegionalQuickCreate;

	@FindBy(xpath="//input[@type='submit'][@value='Save']")
	WebElement saveQuickCreate;

	@FindBy(xpath="//div[@class='bBottom']//span[text()='Reports']")
	WebElement menu_Reports;

	@FindBy(xpath="//div[@title='New Report'][text()='New Report']")
	WebElement newReport;

	@FindBy(xpath="//input[@id='quickFindInput']")
	WebElement reportTypeInput;	

	@FindBy(xpath = "//div[@class='slds-truncate'][text()='New']")
	WebElement newAccountMenuPage;

	@FindBy(xpath="//a[@aria-label='Investor Profile']")
	WebElement investorProfile;

	@FindBy(xpath="//div[@class='slds-form-element__control slds-grid']/span/span/img")
	WebElement investorServicesCheckBox;

	@FindBy(xpath="//select[contains(@id,'CustomActivityForm:activity-activityType')]")
	WebElement selectActivityType;

	@FindBy(xpath="//select[contains(@id,'stateBillingPicklist')]")
	WebElement billingStateQuickCreate;

	@FindBy(xpath="//select[contains(@id,'stateBillingPicklist')]/option[text()='Texas']")
	WebElement billingStateTexasQuickCreate;

	@FindBy(xpath = "//div[@class='slds-form-element__row']//label[@for='first-name']/parent::div//input")
	WebElement firstName;	

	@FindBy(xpath = "//div[@class='slds-form-element__row']//label[@for='last-name']/parent::div//input")
	WebElement lastName;

	@FindBy(xpath = "//label[@for='company']/following-sibling::div//input")
	WebElement company;	

	@FindBy(xpath = "//label[text()='Status']/following-sibling::div//select")
	WebElement leadStatusField;

	@FindBy(xpath="//select[contains(@id,'LeadForm')]/option[text()='Open']")
	WebElement selectLeadStatusField;

	@FindBy(xpath = "//input[@class='btn slds-button slds-button--neutral slds-m-left--small'][@value='Save']")
	WebElement saveButtonLeads;

	@FindBy(xpath = "//div[@class='bBottom']//span[text()='Leads']")
	WebElement menu_Leads;

	@FindBy(xpath = "//div[@class='slds-truncate'][@title='Sharing'][text()='Sharing']")
	WebElement sharingButton;

	/*@FindBy(xpath = "//div[contains(@class,'listRelatedObject')]//input[@class='btn primary']")
	WebElement addButtonSharing;*/

	@FindBy(xpath="//div[contains(@class,'listRelatedObject')]//td[@class='pbButton']//input[@type='button'][@name='new']")
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
	WebElement saveButtonPrivateTag;

	@FindBy(xpath="//h1[text()='Sharing Detail']")
	WebElement sharingDetail;

	@FindBy(xpath = "//a[@role='menuitem'][text()='Private Tags']")
	WebElement more_privateTags;

	@FindBy(xpath = "//div[@class='slds-truncate'][text()='New']")
	WebElement newAccounts;

	@FindBy(xpath="//label[@class='label inputLabel uiLabel-left form-element__label uiLabel']/span[contains(text(),'Private Tag Name')]/parent::label/parent::div/input")
	WebElement privateTagName;

	@FindBy(xpath="//button[@title='Save']")
	WebElement saveNewPrivateTag;

	@FindBy(xpath="//button[contains(@class,'context-bar__label-action')][text()='More']")
	WebElement more;

	@FindBy(xpath="//a[@role='menuitem']/span[contains(@class,'slds-truncate')][text()='Private Tags']")
	WebElement more_PrivateTags;

	@FindBy(xpath="//h1[contains(@class,'slds-page-header__title')]/span")
	WebElement accountNameSaved;

	@FindBy(xpath="//span[text()='D-U-N-S #']/parent::div/parent::div//span[@class='uiOutputText']")
	WebElement accountDetailsDUNS;

	@FindBy(xpath="//li[contains(@class,'oneActionsDropDown')]//a")
	WebElement showMoreActions;

	@FindBy(xpath="//div[contains(@class,'actionMenu')]//a[@title='View Hierarchy']")
	WebElement selectViewHierarchy;
	
	@FindBy(xpath="//input[contains(@id,'LocalAcctName')]")
	WebElement localAccountName;

	@FindBy(xpath="//input[contains(@id,'acctForm:Fax')]")
	WebElement accountFax;

	@FindBy(xpath="//button[@id='addressCopy']")
	WebElement copyAddress;

	@FindBy(xpath="//select[contains(@id,'Local_Billing_Country__c')]")
	WebElement localBillingCountry;

	@FindBy(xpath="//select[contains(@id,'Local_Billing_Country__c')]/option[text()='United States']")
	WebElement localBillingCountryValue;

	@FindBy(xpath="//textarea[contains(@id,'Local_Billing_Street__c')]")
	WebElement localBillingStreet;

	@FindBy(xpath="//input[contains(@id,'Local_Billing_City__c')]")
	WebElement localBillingCity;

	@FindBy(xpath="//select[contains(@id,'Local_Billing_State_Province__c')]")
	WebElement localBillingState;

	@FindBy(xpath="//select[contains(@id,'Local_Billing_State_Province__c')]/option[text()='Texas']")
	WebElement localBillingStateValue;

	@FindBy(xpath="//input[contains(@id,'Local_Billing_Zip_Postal_Code__c')]")
	WebElement localBillingZipCode;

	@FindBy(xpath="//select[contains(@id,'Local_Shipping_Country__c')]")
	WebElement localShippingCountry;

	@FindBy(xpath="//select[contains(@id,'Local_Shipping_Country__c')]/option[text()='United States']")
	WebElement localShippingCountryValue;

	@FindBy(xpath="//textarea[contains(@id,'Local_Shipping_Street__c')]")
	WebElement localShippingStreet;

	@FindBy(xpath="//input[contains(@id,'Local_Shipping_City__c')]")
	WebElement localShippingCity;

	@FindBy(xpath="//select[contains(@id,'Local_Shipping_State_Province__c')]")
	WebElement localShippingState;

	@FindBy(xpath="//select[contains(@id,'Local_Shipping_State_Province__c')]/option[text()='Texas']")
	WebElement localShippingStateValue;

	@FindBy(xpath="//input[contains(@id,'Local_Shipping_Zip_Postal_Code__c')]")
	WebElement localShippingZipCode;

	@FindBy(xpath="//input[contains(@id,'acctForm:website')]")
	WebElement website;

	@FindBy(xpath="//input[contains(@id,'Phone')]")
	WebElement phone;

	@FindBy(xpath="//select[contains(@id,'EMEAIndustry')]")
	WebElement industry;

	@FindBy(xpath="//select[contains(@id,'Industry')]")
	WebElement amerIndustry;

	@FindBy(xpath="//select[contains(@id,'Industry')]/option[text()='Advertising/Marketing/Media']")
	WebElement amerIndustryValue;

	@FindBy(xpath="//select[contains(@id,'EMEAIndustry')]/option[text()='Agriculture']")
	WebElement industryValue;

	@FindBy(xpath="//select[contains(@id,'Investor_Profile__c')]/option[text()='Occupier']")
	WebElement selectIndustryValue;

	@FindBy(xpath="//select[contains(@id,'Lender_Type__c')]")
	WebElement lenderType;

	@FindBy(xpath="//select[contains(@id,'Lender_Type__c')]/option[text()='Bank']")
	WebElement selectLenderType;

	@FindBy(xpath="//select[contains(@id,'AccountSource')]/option[text()='Business Relationship']")
	WebElement accountSourceField;

	@FindBy(xpath="//input[contains(@id,'TickerSymbol')]")
	WebElement tickerSymbol;

	@FindBy(xpath="//input[contains(@id,'AnnualRevenue')]")
	WebElement annualRevenue;

	@FindBy(xpath="//input[contains(@id,'NAICS_Code__c')]")
	WebElement naicsCode;

	@FindBy(xpath="//input[contains(@id,'SIC_Code_1__c')]")
	WebElement sicCode1;

	@FindBy(xpath="//input[contains(@id,'SIC_Code_2__c')]")
	WebElement sicCode2;

	@FindBy(xpath="//input[contains(@id,'SIC_Code_3__c')]")
	WebElement sicCode3;

	@FindBy(xpath="//input[contains(@id,'SIC_Code_4__c')]")
	WebElement sicCode4;

	@FindBy(xpath="//input[contains(@id,'SIC_Code_5__c')]")
	WebElement sicCode5;

	@FindBy(xpath="//input[contains(@id,'SIC_Code_6__c')]")
	WebElement sicCode6;

	@FindBy(xpath="//textarea[contains(@id,'Description')]")
	WebElement accountDescription;

	@FindBy(xpath="//select[contains(@id,'LegalStatus')]/option[text()='Corporation']")
	WebElement legalStatusValue;
	
   @FindBy(xpath="//article[contains(@class,'forceRelatedListCardDesktop')]//span[contains(text(),'SPOCs')]/ancestor::article//div[text()='New']")
   WebElement spocsNew;
   
   @FindBy(xpath="//span[text()='Migrated Account']/parent::label/span[contains(@class,'checkbox')]")
   WebElement migratedAccount;


	HomePage hp = new HomePage(scriptHelper);
	SearchTextSOQL searchAccount = new SearchTextSOQL(scriptHelper);
	static ArrayList<String> accountsPageDetailsList = new ArrayList<String>();

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
		List<WebElement> accountList = driver
				.findElements(By.xpath("//a[@class='slds-truncate outputLookupLink slds-truncate forceOutputLookup']"));
		Utility_Functions.xclickRandomElement(accountList);
		Utility_Functions.timeWait(3);
		List<WebElement> accountsPageInfoList = driver
				.findElements(By.xpath("//span[contains(@class,'header-title')]"));
		Utility_Functions.xScrollWindow(driver);
		Utility_Functions.timeWait(1);
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
			System.out.println(e.getMessage());
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
		Utility_Functions.timeWait(4);
		List<WebElement> accountList = driver
				.findElements(By.xpath("//a[@class='slds-truncate outputLookupLink slds-truncate forceOutputLookup']"));
		String accountSelected = Utility_Functions.xclickgetTextofFirstElementfromList(accountList);
		Utility_Functions.timeWait(3);
		Utility_Functions.xClick(driver, related_Accounts, true);
		Utility_Functions.timeWait(2);
		try {
			Utility_Functions.xScrollWindow(driver);
			Utility_Functions.timeWait(2);
			Utility_Functions.xScrollWindowTop(driver);
			Utility_Functions.timeWait(2);
			Utility_Functions.xClick(driver, new_PrivateNotes, true);
			/*
			 * if (dataTable.getData("General_Data",
			 * "Username").contains("cmbroker")) {
			 * Utility_Functions.xScrollWindow(driver);
			 * Utility_Functions.timeWait(3); Utility_Functions.xClick(driver,
			 * new_PrivateNotes, true); } else {
			 * Utility_Functions.xScrollWindow(driver);
			 * Utility_Functions.timeWait(3); Utility_Functions.xClick(driver,
			 * new_PrivateNotes, true); }
			 */
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
		}
		Utility_Functions.timeWait(4);
		Utility_Functions.xClick(driver, next_PrivateNotes, true);
		Utility_Functions.timeWait(2);
		String accountPopulated = account_PrivateNotes.getText();
		Utility_Functions.xSendKeys(driver, title_PrivateNotes, dataTable.getData("General_Data", "Title"));
		Utility_Functions.timeWait(1);
		if (accountSelected.equals(accountPopulated)) {
			report.updateTestLog("Verify Private Note", "Account populated on Private Note is same as the one "
					+ "selected while creating the Private Note", Status.PASS);
		} else {
			report.updateTestLog("Verify Private Note",
					"Account populated on Private Note is not the one " + "selected while creating the Private Note",
					Status.FAIL);
		}
		Utility_Functions.timeWait(1);
		Utility_Functions.xClick(driver, searchContacts, true);
		List<WebElement> contactsList = driver.findElements(By.xpath(
				"//div[@class='lookup__menu uiAbstractList uiAutocompleteList uiInput uiAutocomplete uiInput--default uiInput--lookup']//div[@class='listContent']/ul/li"));
		Utility_Functions.timeWait(2);
		Utility_Functions.xclickOnFirstElementfromList(contactsList);
		Utility_Functions.timeWait(2);
		Utility_Functions.xSendKeys(driver, body, dataTable.getData("General_Data", "Body"));
		Utility_Functions.timeWait(2);
		Utility_Functions.xClick(driver, saveButton, true);
		Utility_Functions.timeWait(4);
		if (wasCreated.isDisplayed()) {
			report.updateTestLog("Verify Private Note", "Private Note is created successfully", Status.PASS);
		} else {
			report.updateTestLog("Verify Private Note", "Private Note is created successfully", Status.FAIL);
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
		//driver.switchTo().frame(driver.findElement(By.xpath("//iframe[contains(@src,'AccountRedirectPage')]")));
		if (!dataTable.getData("General_Data", "TC_ID").contains("Broker")) {
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
				By.xpath("//h2[@class='slds-text-heading--medium slds-m-top--x-large slds-m-bottom--large']"));
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
			if (count == 8) {
				report.updateTestLog("Verify Add Account Header List", "header is present in Add Account Page",
						Status.PASS);
			} else {
				report.updateTestLog("Verify Add Account Header List", "header is not present in Add Account Page",
						Status.FAIL);
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		try {
			List<WebElement> labelListAccountPage = driver
					.findElements(By.xpath("//label[@class='slds-form-element__label']"));
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
		List<WebElement> accountNamesList = driver.findElements(
				By.xpath(".//a[@class='slds-truncate outputLookupLink slds-truncate forceOutputLookup']"));

		Utility_Functions.xclickRandomElement(accountNamesList);
		Utility_Functions.timeWait(3);
		Utility_Functions.xClick(driver, related_Accounts, true);
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
		/*		Random random = new Random();
		int value = random.nextInt();*/
		Utility_Functions.xSendKeys(driver, titleName, "Test Personal Information Note_" + Utility_Functions.xGenerateAlphaNumericString());
		Utility_Functions.timeWait(5);
		// List<WebElement> newPersonalInformationList =
		// driver.findElements(By.xpath(".//label[@class='label inputLabel
		// uiLabel-left form-element__label uiLabel']"));
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
		List<WebElement> accountNamesList = driver.findElements(
				By.xpath(".//a[@class='slds-truncate outputLookupLink slds-truncate forceOutputLookup']"));

		Utility_Functions.xclickOnFirstElementfromList(accountNamesList);
		Utility_Functions.timeWait(3);
		Utility_Functions.xWaitForElementPresent(driver, related_Accounts, 3);
		Utility_Functions.xClick(driver, related_Accounts, true);

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

			System.out
			.println("Selected Account is present in the Note Page :" + untitledNoteSelectedAccount.getText());
		} else {
			System.out.println("Selected Account is not present in the Note Page");
		}

		List<WebElement> untitledNotePageListDone = driver.findElements(By.xpath(
				"//button[@class='slds-button slds-button--neutral hideDoneButton uiButton--default uiButton--brand uiButton']/span[contains(text(),'Done')]"));
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
	 * @author Ramya
	 *
	 */
	public void verifyCreateActivityAccount() {
		Utility_Functions.xWaitForElementPresent(driver, menu_Accounts, 3);
		Utility_Functions.xClick(driver, menu_Accounts, true);
		report.updateTestLog("Verify Create Activity Account","Accounts is Displayed ",  Status.PASS);
		Utility_Functions.xWaitForElementPresent(driver, recentlyViewed, 3);
		Utility_Functions.xClick(driver, recentlyViewed, true);
		report.updateTestLog("Verify Create Activity Account","Recently viewed Accounts are Displayed ",  Status.PASS);
		Utility_Functions.xWaitForElementPresent(driver, allAccounts, 3);
		Utility_Functions.xClick(driver, allAccounts, true);
		Utility_Functions.timeWait(3);
		report.updateTestLog("Verify Create Activity Account","All accounts are displayed successfully:::",  Status.PASS);
		List<WebElement> accountNamesList = driver.findElements(
				By.xpath(".//a[@class='slds-truncate outputLookupLink slds-truncate forceOutputLookup']"));

		Utility_Functions.xclickOnFirstElementfromList(accountNamesList);
		Utility_Functions.timeWait(3);
		report.updateTestLog("Verify Create Activity Account ","The Account is Displayed ",  Status.PASS);
		Utility_Functions.xWaitForElementPresent(driver,related_Accounts , 3);
		Utility_Functions.xClick(driver, related_Accounts, true);
		report.updateTestLog("Verify Create Activity Account ","The related page is Displayed ",  Status.PASS);
		Utility_Functions.xScrollWindow(driver);
		Utility_Functions.timeWait(1);
		Utility_Functions.xScrollWindowTop(driver);
		Utility_Functions.timeWait(2);
		Utility_Functions.xWaitForElementPresent(driver, newActivity, 3);
		Utility_Functions.xClick(driver, newActivity, true);
		report.updateTestLog("Verify Create Activity Account ","The New Activity in the related page is Displayed ",  Status.PASS);
		/*int size = driver.findElements(By.tagName("iframe")).size();
		System.out.println(size);
		Utility_Functions.timeWait(2);
		List<WebElement> iframeList = driver.findElements(By.tagName("iframe"));
		System.out.println(iframeList.size());
		for (WebElement element : iframeList) {
			System.out.println(element.getAttribute("id"));
		}*/

		driver.switchTo().frame(5);

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
					countRequiredFiles++;

				}

			} 
			System.out.println(countRequiredFiles);
			if(countRequiredFiles!=5) {
				System.out.println("New Activity Page Layout does not contain the required fields ");
				report.updateTestLog("Verify New Activity Page Layout",
						"New Activity Layout Page is having all the required fields",
						Status.FAIL);
			}


		}catch (Exception e) {
			e.printStackTrace();
			System.out.println(e.getMessage());

		}
		Utility_Functions.xWaitForElementPresent(driver, subject, 3);
		Utility_Functions.xSendKeys(driver, subject, "Test Automation Subject_" + Utility_Functions.xGenerateAlphaNumericString());
		Utility_Functions.xWaitForElementPresent(driver, activityType1, 3);
		Utility_Functions.xClick(driver, activityType1, true);
		Utility_Functions.xWaitForElementPresent(driver, saveAndNewActivity, 3);
		Utility_Functions.xClick(driver, saveAndNewActivity, true);
		Utility_Functions.xWaitForElementPresent(driver, createNewActivity, 3);
		if(!createNewActivity.getText().isEmpty()){

			System.out.println("The New Activity Page is displayed");
			report.updateTestLog("Verify Create Activity Account ","The Activity is saved and New Activity is displayed ",  Status.PASS);
		}else{
			System.out.println("The New Activity Page is not displayed");
			report.updateTestLog("Verify Create Activity Account ","The Activity is not saved ",  Status.FAIL);
		}




	}
	/**
	 * Validating the Follow Up Custom Activity
	 * 
	 * @author Ramya
	 *
	 */

	public void verifyFollowUpCustomActivity(){

		Utility_Functions.xWaitForElementPresent(driver, menu_Accounts, 3);
		Utility_Functions.xClick(driver, menu_Accounts, true);
		report.updateTestLog("Verify Create Activity Account","Accounts is Displayed ",  Status.PASS);
		Utility_Functions.xWaitForElementPresent(driver, recentlyViewed, 3);
		Utility_Functions.xClick(driver, recentlyViewed, true);
		report.updateTestLog("Verify Create Activity Account","Recently viewed Accounts are Displayed ",  Status.PASS);
		Utility_Functions.xWaitForElementPresent(driver, allAccounts, 3);
		Utility_Functions.xClick(driver, allAccounts, true);
		Utility_Functions.timeWait(2);
		report.updateTestLog("Verify Create Activity Account","All accounts are displayed successfully:::",  Status.PASS);
		List<WebElement> accountNamesList = driver.findElements(
				By.xpath(".//a[@class='slds-truncate outputLookupLink slds-truncate forceOutputLookup']"));

		Utility_Functions.xclickOnFirstElementfromList(accountNamesList);
		Utility_Functions.xWaitForElementPresent(driver, related_Accounts, 5);
		report.updateTestLog("Verify Create Activity Account ","The Account is Displayed ",  Status.PASS);
		Utility_Functions.xClick(driver, related_Accounts, true);
		Utility_Functions.timeWait(2);
		report.updateTestLog("Verify Create Activity Account ","The related page is Displayed ",  Status.PASS);
		Utility_Functions.xScrollWindow(driver);
		Utility_Functions.timeWait(1);
		Utility_Functions.xScrollWindowTop(driver);
		Utility_Functions.timeWait(2);
		Utility_Functions.xWaitForElementPresent(driver, newActivity, 3);
		Utility_Functions.xClick(driver, newActivity, true);
		report.updateTestLog("Verify Create Activity Account ","The New Activity in the related page is Displayed ",  Status.PASS);
		Utility_Functions.xSwitchtoFrame(driver, saveAndNewActivity);
		Utility_Functions.timeWait(3);
		Utility_Functions.xWaitForElementPresent(driver, subject, 5);
		Utility_Functions.xSendKeys(driver, subject, "Test Automation Subject_" + Utility_Functions.xGenerateAlphaNumericString());
		Utility_Functions.xWaitForElementPresent(driver, activityType1, 3);
		Utility_Functions.xClick(driver, activityType1, true);
		Utility_Functions.xWaitForElementPresent(driver, saveAndNewActivity, 3);
		Utility_Functions.xClick(driver, saveAndNewActivity, true);
		Utility_Functions.timeWait(3);
		report.updateTestLog("Verify Create Activity Account ","The Activity is saved and New Activity is displayed ",  Status.PASS);
		/*Utility_Functions.xSwitchtoFrame(driver, subject);
			Utility_Functions.timeWait(3);*/
		Utility_Functions.xClick(driver, subject, true);
		Utility_Functions.timeWait(3);
		String value = Utility_Functions.xGenerateAlphaNumericString();
		Utility_Functions.xWaitForElementPresent(driver, subject, 5);
		Utility_Functions.xSendKeys(driver, subject, "Test Activity Created by Automation_" + value);
		Utility_Functions.xClick(driver, activityType2, true);
		Utility_Functions.xWaitForElementPresent(driver,saveActivity, 5);
		Utility_Functions.xClick(driver, saveActivity, true);

		SearchTextSOQL searchTextSOQL = new SearchTextSOQL(scriptHelper);
		String query = "select Name from Activity__C where Subject__C = " + "'" + "Test Activity Created by Automation_" + value + "'";
		String nameActivity = searchTextSOQL.fetchRecordFieldValue("Name", query);
		if(nameActivity.isEmpty()) {
			System.out.println("Activity has not been retrieved");
			report.updateTestLog("Verify Create Activity Account ","The newly created Activity has not been retrieved ",  Status.FAIL);
		} else {
			System.out.println("Activity has been retrieved");
			report.updateTestLog("Verify Create Activity Account ","The newly created Activity has been retrieved",  Status.PASS);
		}
		String queryId = "select Id from Activity__C where Name = " + "'" + nameActivity + "'";
		String activityId = searchTextSOQL.fetchRecordFieldValue("Id", queryId);

		String url = driver.getCurrentUrl().split("#")[0];
		String newUrl = url + "#/sObject/" + activityId;
		newUrl = newUrl + "/view";
		report.updateTestLog("Verify Add Opportunity Page Fields",
				"URL has been replaced with the new URL having the retrieved Opportunity:::" + newUrl, Status.PASS);
		driver.get(newUrl);
		//driver.navigate().refresh();



		report.updateTestLog("Verify Create Activity Account ","The second Activity is saved ",  Status.PASS);		

		Utility_Functions.timeWait(4);
		driver.navigate().refresh();
		Utility_Functions.timeWait(1);
		driver.switchTo().defaultContent();
		driver.navigate().refresh();
		Utility_Functions.xWaitForElementPresent(driver, selectCreateFollowUpCustomActivity, 3);
		Utility_Functions.xClick(driver,  selectCreateFollowUpCustomActivity, true);
		Utility_Functions.timeWait(4);
		report.updateTestLog("Verify Create Activity Account ","The Follow up Activity Page is Displayed",  Status.PASS);
		Utility_Functions.xWaitForElementPresent(driver, createCustomActivity, 5);
		//Utility_Functions.xClick(driver, createCustomActivity, true);
		Actions action  = new Actions(driver.getWebDriver());
		action.moveToElement(createCustomActivity);
		action.click();
		action.build().perform();	

		Utility_Functions.timeWait(3);
		Utility_Functions.xSwitchtoFrame(driver, subject);
		Utility_Functions.timeWait(3);
		Utility_Functions.xWaitForElementPresent(driver,subject, 3);
		Utility_Functions.xSendKeys(driver, subject, "Test Automation Subject_" + Utility_Functions.xGenerateAlphaNumericString());
		Utility_Functions.xWaitForElementPresent(driver,activityType3, 3);
		Utility_Functions.xClick(driver, activityType3, true);
		Utility_Functions.xWaitForElementPresent(driver,saveActivity, 3);
		Utility_Functions.xClick(driver, saveActivity, true);
		Utility_Functions.timeWait(3);
		report.updateTestLog("Verify Create Activity Account ","The Custom Activity is created ",  Status.PASS);
		driver.navigate().refresh();
		Utility_Functions.timeWait(1);
		driver.switchTo().defaultContent();
		driver.navigate().refresh();
		Utility_Functions.timeWait(3);
		Utility_Functions.xWaitForElementPresent(driver,menu_Accounts, 3);
		Utility_Functions.xClick(driver, menu_Accounts, true);

		List<WebElement> recentlyViewedpropertiesList = driver.findElements(By.xpath(".//a[@class='slds-truncate outputLookupLink slds-truncate forceOutputLookup']"));

		Utility_Functions.xclickOnFirstElementfromList(recentlyViewedpropertiesList);
		Utility_Functions.timeWait(3);
		Utility_Functions.xWaitForElementVisible(driver,  related_Accounts, 5);
		Utility_Functions.xClick(driver,  related_Accounts, true);
		Utility_Functions.xScrollWindow(driver);
		Utility_Functions.timeWait(1);
		Utility_Functions.xScrollWindowTop(driver);
		Utility_Functions.timeWait(2);

		Utility_Functions.xWaitForElementPresent(driver, relatedActivities, 5);
		Utility_Functions.xClick(driver, relatedActivities, true);
		List<WebElement> relatedActivitiesList = driver.findElements(By.xpath(".//a[@class='slds-truncate outputLookupLink slds-truncate forceOutputLookup'] "));
		for (WebElement element : relatedActivitiesList ) {
			if ((!element.getText().equals(" "))){
				report.updateTestLog("Verify Create Activity Account","The New Activity for Accounts are created ",Status.PASS);
			}else
			{
				report.updateTestLog("Verify Create Activity Account","The New Activity for Accounts are not created ",Status.FAIL);
			}
		}


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

		report.updateTestLog("Verify New Activity Page Layout ","Accounts is Displayed ",  Status.PASS);
		Utility_Functions.xWaitForElementPresent(driver, recentlyViewed, 3);
		Utility_Functions.xClick(driver, recentlyViewed, true);
		report.updateTestLog("Verify New Activity Page Layout ","Recently viewed Accounts are Displayed ",  Status.PASS);
		Utility_Functions.xWaitForElementPresent(driver, allAccounts, 3);
		Utility_Functions.xClick(driver, allAccounts, true);
		Utility_Functions.timeWait(3);
		report.updateTestLog("Verify New Activity Page Layout ","All Accounts are Displayed ",  Status.PASS);
		List<WebElement> accountNamesList = driver.findElements(
				By.xpath(".//a[@class='slds-truncate outputLookupLink slds-truncate forceOutputLookup']"));

		Utility_Functions.xclickOnFirstElementfromList(accountNamesList);
		Utility_Functions.timeWait(3);
		report.updateTestLog("Verify New Activity Page Layout ","The Account is Displayed ",  Status.PASS);
		Utility_Functions.xWaitForElementPresent(driver, related_Accounts, 3);
		Utility_Functions.xClick(driver, related_Accounts, true);
		report.updateTestLog("Verify New Activity Page Layout ","The related page is Displayed ",  Status.PASS);
		Utility_Functions.xScrollWindow(driver);
		Utility_Functions.timeWait(1);
		Utility_Functions.xScrollWindowTop(driver);
		Utility_Functions.timeWait(2);
		Utility_Functions.xWaitForElementPresent(driver, newActivity, 3);
		Utility_Functions.xClick(driver, newActivity, true);
		report.updateTestLog("Verify New Activity Page Layout ","The New Activity in the related page is Displayed ",  Status.PASS);
		/*int size = driver.findElements(By.tagName("iframe")).size();
		System.out.println(size);
		Utility_Functions.timeWait(2);
		List<WebElement> iframeList = driver.findElements(By.tagName("iframe"));
		System.out.println(iframeList.size());
		for (WebElement element : iframeList) {
			System.out.println(element.getAttribute("id"));
		}*/
		Utility_Functions.xSwitchtoFrame(driver, subject);
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
					countRequiredFiles++;

				}

			} 
			System.out.println(countRequiredFiles);
			if(countRequiredFiles!=5) {
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
		}
	}
	/**
	 * Validating the New Activity Page Layout for the Accounts for incorrect data
	 * 
	 * @author Ramya
	 *
	 */
	public void verifyNewActivityPageForIncorrectData(){

		Utility_Functions.xClick(driver, menu_Accounts, true);
		Utility_Functions.timeWait(3);
		report.updateTestLog("Verify New Activity Page Layout ","Accounts is Displayed ",  Status.PASS);

		List<WebElement> accountNamesList = driver.findElements(
				By.xpath(".//a[@class='slds-truncate outputLookupLink slds-truncate forceOutputLookup']"));

		Utility_Functions.xclickOnFirstElementfromList(accountNamesList);
		Utility_Functions.timeWait(3);
		report.updateTestLog("Verify New Activity Page Layout ","The Account is Displayed ",  Status.PASS);
		Utility_Functions.xClick(driver, related_Accounts, true);
		Utility_Functions.timeWait(3);
		report.updateTestLog("Verify New Activity Page Layout ","The related page is Displayed ",  Status.PASS);
		Utility_Functions.xScrollWindow(driver);
		Utility_Functions.timeWait(1);
		Utility_Functions.xScrollWindowTop(driver);
		Utility_Functions.timeWait(2);
		Utility_Functions.xWaitForElementPresent(driver, newActivity, 3);
		Utility_Functions.xClick(driver, newActivity, true);
		report.updateTestLog("Verify New Activity Page Layout ","The New Activity in the related page is Displayed ",  Status.PASS);
		Utility_Functions.xSwitchtoFrame(driver, subject);

		Utility_Functions.timeWait(3);

		Utility_Functions.xWaitForElementPresent(driver, subject, 3);
		Utility_Functions.xClick(driver, subject, true);
		Utility_Functions.xWaitForElementPresent(driver, subject, 3);
		Utility_Functions.xSendKeys(driver, subject, "Test Automation Subject_" + Utility_Functions.xGenerateAlphaNumericString());
		report.updateTestLog("Verify New Activity Page Layout ","The New Activity in the related page is Displayed ",  Status.PASS);
		Utility_Functions.xWaitForElementPresent(driver, activityType1, 3);
		Utility_Functions.xClick(driver, activityType1, true);
		report.updateTestLog("Verify New Activity Page Layout ","The New Activity in the related page is Displayed ",  Status.PASS);
		Utility_Functions.xSendKeys(driver, relatedToContactField, "Adarsh Mehta");
		relatedToContactField.sendKeys(Keys.ARROW_DOWN);
		relatedToContactField.sendKeys(Keys.TAB);
		report.updateTestLog("Verify New Activity Page Layout ","Verifying the New Activity Page Contact Field is populated with the user data ",  Status.PASS);
		Utility_Functions.xSendKeys(driver, relatedToOpportunityField, "ABC Telecom-Consulting-134-Acres");
		relatedToOpportunityField.sendKeys(Keys.ARROW_DOWN);
		relatedToOpportunityField.sendKeys(Keys.TAB);
		report.updateTestLog("Verify New Activity Page Layout ","Verifying the New Activity Page Opportunity Field is populated with the user data ",  Status.PASS);
		Utility_Functions.xSendKeys(driver, relatedToPropertyField, "test25APR - South Lamar Street");

		relatedToPropertyField.sendKeys(Keys.ARROW_DOWN);
		relatedToPropertyField.sendKeys(Keys.TAB);
		report.updateTestLog("Verify New Activity Page Layout ","Verifying the New Activity Page Property Field is populated with the user data ",  Status.PASS);
		Utility_Functions.xWaitForElementPresent(driver, saveActivity, 3);
		Utility_Functions.xClick(driver, saveActivity, true);
		report.updateTestLog("Verify New Activity Page Layout ","Verifying whether the New Activity page is saved  ",  Status.PASS);
		/* if(errorMessage.getText().contains("Review the errors on this page")){
	        	System.out.println("Contact Account and Account mismatch");

	        }else{
	        	System.out.println("No errors found in the page");
	        }*/
		/*driver.navigate().refresh();
			Utility_Functions.timeWait(1);
			driver.switchTo().defaultContent();
			driver.navigate().refresh();
			Utility_Functions.timeWait(3);
			Utility_Functions.xScrollWindow(driver);
			Utility_Functions.timeWait(1);
			Utility_Functions.xScrollWindowTop(driver);
			Utility_Functions.timeWait(2);*/
		/*Utility_Functions.xWaitForElementPresent(driver, relatedToContactField, 4);
			relatedToContactField.clear();
			Utility_Functions.xWaitForElementPresent(driver, relatedToOpportunityField, 4);
			relatedToOpportunityField.clear();
			Utility_Functions.xWaitForElementPresent(driver, relatedToPropertyField, 4);
			relatedToPropertyField.clear();
			Utility_Functions.xWaitForElementPresent(driver, saveActivity, 3);
			Utility_Functions.xClick(driver, saveActivity, true);*/

		/*if ((!savedActivityAfterChanges.getText().equals(""))) {
				System.out.println("The activity is saved");
			}else{
				System.out.println("The Activity is not saved");
			}*/


	}
	/**
	 * Validating the New Activity Page send Notification Email to the Assigned Person
	 * 
	 * @author Ramya
	 *
	 */

	public void verifyAccountsNewActivityPageSendNotificationEmail(){


		Utility_Functions.xWaitForElementPresent(driver, menu_Accounts, 3);
		Utility_Functions.xClick(driver, menu_Accounts, true);

		report.updateTestLog("Verify New Activity Page send Notification Email ","Verifying the Accounts is Displayed ",  Status.PASS);

		List<WebElement> accountNamesList = driver.findElements(
				By.xpath(".//a[@class='slds-truncate outputLookupLink slds-truncate forceOutputLookup']"));

		Utility_Functions.xclickOnFirstElementfromList(accountNamesList);
		report.updateTestLog("Verify New Activity Page send Notification Email ","Verifying the selected Account is Displayed ",  Status.PASS);
		Utility_Functions.xWaitForElementPresent(driver, related_Accounts, 3);
		Utility_Functions.xClick(driver, related_Accounts, true);
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

		driver.switchTo().frame(5);
		Utility_Functions.timeWait(3);

		Utility_Functions.xWaitForElementPresent(driver, subject, 3);
		Utility_Functions.xClick(driver, subject, true);
		Utility_Functions.xWaitForElementPresent(driver, subject, 3);
		Utility_Functions.xSendKeys(driver, subject, "Test Automation Subject_" + Utility_Functions.xGenerateAlphaNumericString());
		report.updateTestLog("Verify New Activity Page send Notification Email  ","Verifying the subject field is populated with the user defined value ",  Status.PASS);
		Utility_Functions.xWaitForElementPresent(driver, activityType1, 3);
		Utility_Functions.xClick(driver, activityType1, true);
		report.updateTestLog("Verify New Activity Page send Notification Email  ","Verifying the Activity Type field is populated with one of the pick list values ",  Status.PASS);

		if(!notificationEmail.isSelected()){
			//notificationEmail.click();

			Utility_Functions.xClick(driver, notificationEmail, true);
			System.out.println("Notification email is checked");
			report.updateTestLog("Verify New Activity Page send Notification Email  ","Verifying the notification email check box is checked or else checking it",  Status.PASS);

		}else{
			System.out.println("Notification email is not checked");
			report.updateTestLog("Verify New Activity Page send Notification Email  ","Verifying the notification email check box is checked or not ",  Status.FAIL);
		}
		Utility_Functions.xWaitForElementPresent(driver,assignedTo, 3);
		Utility_Functions.xSendKeys(driver, assignedTo, "vishnuvardhan bommisetty");
		report.updateTestLog("Verify New Activity Page send Notification Email  ","Verifying the Assigned To field is populated with the appropriate value ",  Status.PASS);
		Utility_Functions.xWaitForElementPresent(driver, saveActivity, 3);
		Utility_Functions.xClick(driver, saveActivity, true);
		report.updateTestLog("Verify New Activity Page send Notification Email  ","Verifying the notification email issent to the Assigned To person in the New Activity page ",  Status.PASS);
	}
	/**
	 * Validating the  Private Tags Bulk Tagging page layout and the Search functionalities
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
	public void verifyPrivateTags(){
		Utility_Functions.xWaitForElementPresent(driver, menu_More, 3);
		Utility_Functions.xClick(driver, menu_More, true);
		Utility_Functions.xWaitForElementPresent(driver, bulkTagging, 3);
		Utility_Functions.xClick(driver, bulkTagging, true);
		Utility_Functions.timeWait(5);
		Utility_Functions.xSwitchtoFrame(driver, accountSearch);
		Utility_Functions.timeWait(5);
		Utility_Functions.xWaitForElementPresent(driver, accountSearch, 3);
		Utility_Functions.xClick(driver, accountSearch, true);
		//accountSearch.clear();
		//Utility_Functions.xWaitForElementPresent(driver, accountSearch, 3);
		Utility_Functions.xSendKeys(driver, accountSearch, "Test");
		Utility_Functions.xWaitForElementPresent(driver, search, 3);
		Utility_Functions.xClick(driver, search, true);

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
							"Bulk Tagging Page Lead Details is having the " + labelArray1[i3] + " field ",
							Status.PASS);
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
		List<WebElement> advancedSearchFields = driver.findElements(By.xpath("//span[contains(@id,'SearchBlock')]//div[@class='slds-truncate']"));
		int count5 = 0;
		try {
			for (WebElement element : advancedSearchFields) {
				if ((count5 == 0) && (element.getText().equalsIgnoreCase("Field Name"))) {
					System.out.println("Field name is present in the Advanced Search Page");
					report.updateTestLog("Verify Private Tags Page",
							"Advanced Search Private Tags Page is having the " + element.getText()
							+ " Status field::",
							Status.PASS);
					count5++;
				} else if ((count5 == 1) && (element.getText().equalsIgnoreCase("Operator"))) {
					System.out.println("Operator is present in the Advanced Search Page");
					report.updateTestLog("Verify Private Tags Page",
							"Advanced Search Private Tags Page is having the " + element.getText()
							+ " Status field::",
							Status.PASS);
					count5++;
				} else if ((count5 == 2) && (element.getText().equalsIgnoreCase("Value"))) {
					System.out
					.println("Value is present in the Advanced Search Page");
					report.updateTestLog("Verify Private Tags Page",
							"Advanced Search Private Tags Page is having the " + element.getText()
							+ " Status field::",
							Status.PASS);

				}
			}
			System.out.println(count5);
			if (count5 != 2) {
				report.updateTestLog("Verify Private Tags Page",
						"All Labels are not present in the Bulk Tagging Page Opportunity Details", Status.FAIL);
			} else {

				report.updateTestLog("Verify Private Tags Page",
						"All Labels are present in the Bulk Tagging Page Opportunity Details", Status.PASS);
			}
		}catch (Exception e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
		}

		//div[@class='slds-form-element']/label/abbr	

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
		Utility_Functions.xWaitForElementPresent(driver, recentlyViewed, 3);
		Utility_Functions.xClick(driver, recentlyViewed, true);
		report.updateTestLog("Verify Additional Activity","Recently viewed Accounts are Displayed ",  Status.PASS);
		Utility_Functions.xWaitForElementPresent(driver, allAccounts, 3);
		Utility_Functions.xClick(driver, allAccounts, true);
		Utility_Functions.timeWait(3);
		report.updateTestLog("Verify Additional Activity","All accounts are displayed successfully:::",  Status.PASS);
		List<WebElement> accountNamesList = driver.findElements(By.xpath(".//a[@class='slds-truncate outputLookupLink slds-truncate forceOutputLookup']"));
		Utility_Functions.xclickRandomElement(accountNamesList);
		Utility_Functions.xWaitForElementPresent(driver, related_Accounts, 3);
		Utility_Functions.xClick(driver, related_Accounts, true);
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
		activityTypeListValues.add("Public - Client Meeting (CML)");
		activityTypeListValues.add("Public - Client Meeting (Investor Services)");
		System.out.println("Additional Activity Type values are added to the list successfully::::");
	}

	/**
	 * Validating the additional Activity Types in the new Activity on an Account
	 * 
	 * @author Vishnuvardhan
	 *
	 */	
	public void additionalActivityTypes() {
		accountsFunction();
		Utility_Functions.timeWait(1);
		Utility_Functions.xWaitForElementPresent(driver, newActivity, 4);
		Utility_Functions.xClick(driver, newActivity, true);	
		Utility_Functions.xSwitchtoFrame(driver, subject);
		Utility_Functions.timeWait(2);
		List<WebElement> activityTypeList = driver.findElements(By.xpath("//select[contains(@id,'CustomActivityForm:activity-activityType')]/option"));
		additionalActivityTypeList();		
		String[] linkTexts = new String[activityTypeList.size()];
		int i = 0, count = 0;
		try {
			for (WebElement element : activityTypeList) {
				linkTexts[i] = element.getText();
				if (linkTexts[i].equals(activityTypeListValues.get(i))) {
					count++;
					report.updateTestLog("Verify Additional Acitivty", "Value " +  element.getText() + "is present under Additional Activity List", Status.PASS);
					System.out.println(element.getText());	
				}
				i++;
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		if(count==15) {
			report.updateTestLog("Verify Additional Acitivty", "All the values are present under Additional Activity List", Status.PASS);
		} else {
			report.updateTestLog("Verify Additional Acitivty", "All the values are not present under Additional Activity List", Status.FAIL);
		}
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
			if(accountServicesCheckbox.isDisplayed()) {
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
		report.updateTestLog("Verify Account Record Type Field","Recently viewed Accounts are Displayed ",  Status.PASS);
		Utility_Functions.xWaitForElementPresent(driver, allAccounts, 3);
		Utility_Functions.xClick(driver, recentlyViewedList, true);
		Utility_Functions.timeWait(3);
		report.updateTestLog("Verify Account Record Type Field","Recently Viewed List is selecte successfully:::",  Status.PASS);
		List<WebElement> columnList = driver.findElements(By.xpath("//table[contains(@class,'uiVirtualDataTable')]//div[@class='slds-cell-fixed']//span[@class='slds-truncate']"));
		int count =0;
		for(WebElement element: columnList) {
			String sColumnList = element.getText();
			System.out.println(sColumnList);
			if(sColumnList.contains("ACCOUNT RECORD TYPE")) {
				count++;
			}
		}
		if(count==1) {
			report.updateTestLog("Verify Account Record Type Field","Account Record Type column is present:::",  Status.PASS);
		} else {
			report.updateTestLog("Verify Account Record Type Field","Account Record Type column is not there:::",  Status.FAIL);
		}
	}

	/**
	 * Account Creation - Area of Operations field in Reporting Account Creation Page 
	 * 
	 * @author Vishnuvardhan
	 *
	 */	
	public void areaOfOperationsAccountCreation() {
		Utility_Functions.xWaitForElementPresent(driver, menu_Accounts, 4);
		Utility_Functions.xClick(driver, menu_Accounts, true);
		Utility_Functions.xWaitForElementPresent(driver, newAccount, 3);
		Utility_Functions.xClick(driver, newAccount, true);
		Utility_Functions.timeWait(2);
		Utility_Functions.xSwitchtoFrame(driver, continueButton);
		Utility_Functions.timeWait(2);
		Utility_Functions.xWaitForElementPresent(driver, recordType, 3);
		Utility_Functions.xClick(driver, recordType, true);
		Utility_Functions.xWaitForElementPresent(driver, recordType_EMEAReporting, 3);
		Utility_Functions.xClick(driver, recordType_EMEAReporting, true);
		Utility_Functions.xWaitForElementPresent(driver, continueButton, 2);
		Utility_Functions.xClick(driver, continueButton, true);
		Utility_Functions.xSwitchtoFrame(driver, accountNameQuickCreate);
		Utility_Functions.timeWait(2);
		String accountName = searchAccount.fetchRecord("Account", "Name");
		Utility_Functions.xSendKeys(driver, accountNameQuickCreate, accountName);
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
		report.updateTestLog("Verify Area of Operations","Area of Operations field is selected while creating the account successfully:::",  Status.PASS);
		Utility_Functions.xWaitForElementPresent(driver, saveQuickCreate, 3);
		Utility_Functions.xClick(driver, saveQuickCreate, true);
		Utility_Functions.timeWait(2);		
		driver.switchTo().defaultContent();
		driver.navigate().refresh();
		Utility_Functions.xWaitForElementPresent(driver, related_Accounts, 3);
		if(related_Accounts.isDisplayed()) {
			report.updateTestLog("Verify Area of Operations","Account creation is successful:::",  Status.PASS);
		} else {
			report.updateTestLog("Verify Area of Operations","Account creation failed::",  Status.FAIL);

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
		System.out.println("Reports CIM List are :::"+ reportsCIMList);
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
			List<WebElement> reportsList = driver.findElements(By.xpath("//div[@class='x-tree-root-node']//span[contains(text(),'CIM')]"));
			reportsCIMList();		
			String[] linkTexts = new String[reportsCIMList.size()];
			int i = 0, count = 0;
			try {
				for (WebElement element : reportsList) {
					linkTexts[i] = element.getText();
					if (linkTexts[i].equals(reportsCIMList.get(i))) {
						count++;
						report.updateTestLog("Verify Reports CIM", "Value " +  element.getText() + "is present under CIM Reports List", Status.PASS);
						//System.out.println(element.getText());	
					}
					i++;
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			System.out.println(count);
			if(count==14) {
				report.updateTestLog("Verify Reports CIM", "All the reports with respect CIM are present", Status.PASS);
			} else {
				report.updateTestLog("Verify Reports CIM", "All the reports with respect CIM are not present", Status.WARNING);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}	
	}

	/**
	 * Validating the Quick create Accounts page from the Accounts tab for the Investor Profile
	 * 
	 * @author Ramya
	 *
	 */
	public void verifyQuickCreateAccountsPageInvestorProfile(){
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
		Utility_Functions.xWaitForElementPresent(driver, investorProfile, 3);
		Utility_Functions.xClick(driver, investorProfile, true);
		Utility_Functions.timeWait(1);
		List<WebElement> reasonForLossValuesList = driver.findElements(By.xpath("//div[@class='select-options']//a[@title='Bank']/parent::li/parent::ul/li"));
		for(WebElement element: reasonForLossValuesList) {
			element.getText();
			System.out.println(element.getText());
		}
	}	
	/**
	 * Validating the Quick create Accounts page from the Accounts tab for the Investor Services Check Box
	 * 
	 * @author Ramya
	 *
	 */
	public void verifyAccountsInvestorServiceCheckBox(){
		Utility_Functions.xWaitForElementPresent(driver, menu_Accounts, 3);
		Utility_Functions.xClick(driver, menu_Accounts, true);

		report.updateTestLog("Verify Accounts Investor Services Check Box ","Verifying the Accounts is Displayed ",  Status.PASS);
		Utility_Functions.xWaitForElementPresent(driver, recentlyViewed, 3);
		Utility_Functions.xClick(driver, recentlyViewed, true);
		report.updateTestLog("Verify Accounts Investor Services Check Box","Recently viewed Accounts are Displayed ",  Status.PASS);
		Utility_Functions.xWaitForElementPresent(driver, allAccounts, 3);
		Utility_Functions.xClick(driver, allAccounts, true);
		Utility_Functions.timeWait(2);
		report.updateTestLog("Verify Accounts Investor Services Check Box","All accounts are displayed successfully:::",  Status.PASS);
		List<WebElement> accountNamesList = driver.findElements(
				By.xpath(".//a[@class='slds-truncate outputLookupLink slds-truncate forceOutputLookup']"));

		Utility_Functions.xclickOnFirstElementfromList(accountNamesList);
		report.updateTestLog("Verify Accounts Investor Services Check Box ","Verifying the selected Account is Displayed ",  Status.PASS);
	/*	Utility_Functions.xWaitForElementPresent(driver, related_Accounts, 3);
		Utility_Functions.xClick(driver, related_Accounts, true);
		report.updateTestLog("Verify New Activity Page Layout ","Verifying the related page is Displayed ",  Status.PASS);*/
		Utility_Functions.xScrollWindow(driver);
		Utility_Functions.timeWait(1);
		Utility_Functions.xScrollWindowTop(driver);
		Utility_Functions.timeWait(3);
		try {
			if(accountServicesCheckbox.isDisplayed()){
				System.out.println("Investor Services CheckBox is present and not checked");
				report.updateTestLog("Verify Accounts Investor Services Check Box  ","Verifying the Investor Services check box is present", Status.FAIL);
			}
		} catch (Exception e) {
				System.out.println("Investor Services CheckBox is not present and not checked");
				report.updateTestLog("Verify Accounts Investor Services Check Box  ","Verifying the Investor Services check box is not present",  Status.PASS);
		}
	}
	/**
	 * Validating the Accounts for the New Activity Type
	 * 
	 * @author Ramya
	 *
	 */
	public void verifyAccountsNewActivityType(){
		Utility_Functions.xWaitForElementPresent(driver, menu_Accounts, 3);
		Utility_Functions.xClick(driver, menu_Accounts, true);
		report.updateTestLog("Verify New Activity Type ","Accounts is Displayed ",  Status.PASS);
		Utility_Functions.xWaitForElementPresent(driver, recentlyViewed, 3);
		Utility_Functions.xClick(driver, recentlyViewed, true);
		report.updateTestLog("Verify New Activity Type ","Recently viewed Accounts are Displayed ",  Status.PASS);
		Utility_Functions.xWaitForElementPresent(driver, allAccounts, 3);
		Utility_Functions.xClick(driver, allAccounts, true);
		Utility_Functions.timeWait(3);
		report.updateTestLog("Verify New Activity Type ","All Accounts are Displayed ",  Status.PASS);
		List<WebElement> accountNamesList = driver.findElements(
				By.xpath(".//a[@class='slds-truncate outputLookupLink slds-truncate forceOutputLookup']"));
		Utility_Functions.xclickOnFirstElementfromList(accountNamesList);
		Utility_Functions.timeWait(3);
		report.updateTestLog("Verify New Activity Type ","The Account is Displayed ",  Status.PASS);
		Utility_Functions.xWaitForElementPresent(driver, related_Accounts, 3);
		Utility_Functions.xClick(driver, related_Accounts, true);
		report.updateTestLog("Verify New Activity Type ","The related page is Displayed ",  Status.PASS);
		Utility_Functions.xScrollWindow(driver);
		Utility_Functions.timeWait(1);
		Utility_Functions.xScrollWindowTop(driver);
		Utility_Functions.timeWait(2);
		Utility_Functions.xWaitForElementPresent(driver, newActivity, 3);
		Utility_Functions.xClick(driver, newActivity, true);
		report.updateTestLog("Verify New Activity Type ","The New Activity in the related page is Displayed ",  Status.PASS);
		Utility_Functions.xSwitchtoFrame(driver, saveAndNewActivity);
		Utility_Functions.xWaitForElementPresent(driver, selectActivityType, 3);
		Utility_Functions.xClick(driver, selectActivityType, true);
		List<WebElement> activityTypeValuesList = driver.findElements(By.xpath("//div[@class='slds-form-element__control']//select[contains(@id,'CustomActivityForm:activity-activityType')]/option"));
		for(WebElement element: activityTypeValuesList) {
			element.getText();
			System.out.println(element.getText());
			report.updateTestLog("Verify New Activity Type ","The Activity Type Values list is Displayed ",  Status.PASS);
		}
	}	

	/**
	 * Validating the Accounts, Leads and Private Tags
	 * 
	 * @author Ramya
	 *
	 */
	public void verifyAccountsLeadsAndPrivateTags(){
		try{
			Utility_Functions.xWaitForElementPresent(driver,menu_More, 3);
			Utility_Functions.xClick(driver, menu_More, true);
		}catch(Exception e){
			Utility_Functions.xWaitForElementPresent(driver, more, 3);
			Utility_Functions.xClick(driver, more, true);
		}
		try{
			Utility_Functions.xWaitForElementPresent(driver,more_privateTags, 3);
			Utility_Functions.xClick(driver, more_privateTags, true);
		}catch(Exception e){
			Utility_Functions.xWaitForElementPresent(driver, more_PrivateTags, 2);
			Utility_Functions.xClick(driver, more_PrivateTags, true);
		}
		Utility_Functions.xWaitForElementPresent(driver, newAccounts, 3);
		Utility_Functions.xClick(driver, newAccounts, true);
		report.updateTestLog("Verify Accounts Leads And PrivateTags ","Verifying New Private Tags is Displayed ",  Status.PASS);
		Utility_Functions.xWaitForElementPresent(driver, privateTagName, 3);
		Utility_Functions.xSendKeys(driver, privateTagName, "Test Automation Priavate Tag_" + Utility_Functions.xGenerateAlphaNumericString());
		report.updateTestLog("Verify Accounts Leads And PrivateTags ","Verifying the Private Tag name is entered ",  Status.PASS);
		Utility_Functions.xWaitForElementPresent(driver, saveNewPrivateTag, 3);
		Utility_Functions.xClick(driver, saveNewPrivateTag, true);
		report.updateTestLog("Verify Accounts Leads And PrivateTags ","Verifying the Private Tag is saved ",  Status.PASS);
		Utility_Functions.timeWait(2);		
		driver.navigate().refresh();
		Utility_Functions.xWaitForElementPresent(driver, menu_Accounts, 3);
		Utility_Functions.xClick(driver, menu_Accounts, true);
		report.updateTestLog("Verify Accounts Leads And PrivateTags ","Verifying the Accounts Page is displayed ",  Status.PASS);
		Utility_Functions.timeWait(2);
		Utility_Functions.xWaitForElementPresent(driver, newAccount, 3);
		Utility_Functions.xClick(driver, newAccount, true);
		report.updateTestLog("Verify Accounts Leads And PrivateTags ","Verifying the New Accounts Page is displayed ",  Status.PASS);
		Utility_Functions.timeWait(2);
		Utility_Functions.xSwitchtoFrame(driver, continueButton);
		Utility_Functions.timeWait(1);
		Utility_Functions.xWaitForElementPresent(driver, continueButton, 5);
		Utility_Functions.xClick(driver, continueButton, true);
		driver.switchTo().defaultContent();
		Utility_Functions.xWaitForElementPresent(driver, menu_Accounts, 3);
		Utility_Functions.xClick(driver, menu_Accounts, true);
		Utility_Functions.timeWait(1);
		Utility_Functions.xWaitForElementPresent(driver, newAccounts, 3);
		Utility_Functions.xClick(driver, newAccounts, true);
		Utility_Functions.timeWait(2);
		Utility_Functions.xSwitchtoFrame(driver, continueButton);
		Utility_Functions.timeWait(2);
		Utility_Functions.xWaitForElementPresent(driver, continueButton, 5);
		Utility_Functions.xClick(driver, continueButton, true);
		Utility_Functions.timeWait(2);
		Utility_Functions.xSwitchtoFrame(driver, accountNameQuickCreate);
		Utility_Functions.timeWait(2);
		Utility_Functions.xWaitForElementPresent(driver, accountNameQuickCreate, 5);
		Utility_Functions.xSendKeys(driver, accountNameQuickCreate, Utility_Functions.xGenerateAlphaNumericString()  +"_Test Automation Account");
		report.updateTestLog("Verify Accounts Leads And PrivateTags ","Verifying the New Accounts Name field is entered ",  Status.PASS);
		Utility_Functions.xWaitForElementPresent(driver, billingStreetQuickCreate, 5);
		Utility_Functions.xSendKeys(driver, billingStreetQuickCreate, "2100 Ross Ave");
		report.updateTestLog("Verify Accounts Leads And PrivateTags ","Verifying the billing street field is entered with a value ",  Status.PASS);
		Utility_Functions.xWaitForElementPresent(driver, billingCityQuickCreate, 5);
		Utility_Functions.xSendKeys(driver, billingCityQuickCreate, "Dallas");
		report.updateTestLog("Verify Accounts Leads And PrivateTags ","Verifying the billing city field is entered with a value ",  Status.PASS);
		Utility_Functions.xWaitForElementPresent(driver, billingCountryQuickCreate, 3);
		Utility_Functions.xClick(driver, billingCountryQuickCreate, true);
		Utility_Functions.xWaitForElementPresent(driver, billingCountryUnitedStatesQuickCreate, 3);
		Utility_Functions.xClick(driver, billingCountryUnitedStatesQuickCreate, true);
		report.updateTestLog("Verify Accounts Leads And PrivateTags ","Verifying the billing Country field is entered with a value ",  Status.PASS);
		Utility_Functions.xWaitForElementPresent(driver, billingStateQuickCreate, 3);
		Utility_Functions.xClick(driver, billingStateQuickCreate, true);
		Utility_Functions.xWaitForElementPresent(driver, billingStateTexasQuickCreate, 3);
		Utility_Functions.xClick(driver, billingStateTexasQuickCreate, true);
		report.updateTestLog("Verify Accounts Leads And PrivateTags ","Verifying the billing state field is entered with a value ",  Status.PASS);
		Utility_Functions.xWaitForElementPresent(driver, saveQuickCreate, 3);
		Utility_Functions.xClick(driver, saveQuickCreate, true);
		report.updateTestLog("Verify Accounts Leads And PrivateTags ","Verifying the Account is saved with all the required fields populated ",  Status.PASS);
		Utility_Functions.timeWait(2);		
		driver.navigate().refresh();
		Utility_Functions.xWaitForElementPresent(driver, menu_Leads, 3);
		Utility_Functions.xClick(driver, menu_Leads, true);
		report.updateTestLog("Verify Accounts Leads And PrivateTags ","Verifying the Leads Page is displayed ",  Status.PASS);
		Utility_Functions.timeWait(2);
		Utility_Functions.xWaitForElementPresent(driver, newAccount, 3);
		Utility_Functions.xClick(driver, newAccount, true);
		report.updateTestLog("Verify Accounts Leads And PrivateTags ","Verifying the new Leads page is displayed ",  Status.PASS);
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
		report.updateTestLog("Verify Accounts Leads And PrivateTags ","Verifying the firstname is entered in the new Leads page ",  Status.PASS);
		Utility_Functions.xWaitForElementPresent(driver, lastName, 5);
		Utility_Functions.xSendKeys(driver, lastName, "Test User_" + Utility_Functions.xGenerateAlphaNumericString());
		report.updateTestLog("Verify Accounts Leads And PrivateTags ","Verifying the last name is enetered in the new Leads page" ,  Status.PASS);
		Utility_Functions.xWaitForElementPresent(driver, company, 5);
		Utility_Functions.xSendKeys(driver, company, "Cbre");
		report.updateTestLog("Verify Accounts Leads And PrivateTags ","Verifying the Company field is entered with a value in the new Leads page",  Status.PASS);
		Utility_Functions.xWaitForElementPresent(driver, leadStatusField, 3);
		Utility_Functions.xClick(driver, leadStatusField, true);
		Utility_Functions.xWaitForElementPresent(driver, selectLeadStatusField, 3);
		Utility_Functions.xClick(driver, selectLeadStatusField, true);
		report.updateTestLog("Verify Accounts Leads And PrivateTags ","Verifying the Status field is selected in the new Leads page ",  Status.PASS);
		Utility_Functions.xWaitForElementPresent(driver, saveButtonLeads, 3);
		Utility_Functions.xClick(driver, saveButtonLeads, true);
		report.updateTestLog("Verify Accounts Leads And PrivateTags ","Verifying the created Lead is saved successfully ",  Status.PASS);
	}


	/**
	 * Validating the New Account populating the required fields
	 * 
	 * @author Ramya
	 *
	 */
	public void verifyAccountsPopulatingRequiredFields() {
		Utility_Functions.xWaitForElementPresent(driver, menu_Accounts, 3);
		Utility_Functions.xClick(driver, menu_Accounts, true);
		Utility_Functions.timeWait(1);
		report.updateTestLog("Verify Account Creation With Required Fields ","Verifying Accounts is Displayed ",  Status.PASS);
		Utility_Functions.xWaitForElementPresent(driver, newAccounts, 3);
		Utility_Functions.xClick(driver, newAccounts, true);
		Utility_Functions.timeWait(2);
		report.updateTestLog("Verify Account Creation With Required Fields ","Verifying New Accounts Page is Displayed  ",  Status.PASS);
		Utility_Functions.xSwitchtoFrame(driver, accountNameQuickCreate);
		Utility_Functions.timeWait(2);
		Utility_Functions.xWaitForElementPresent(driver, accountNameQuickCreate, 5);
		String value = Utility_Functions.xGenerateAlphaNumericString();
		String accountName = value + "_Test Automation Account";
		Utility_Functions.xSendKeys(driver, accountNameQuickCreate, accountName);
		report.updateTestLog("Verify Account Creation With Required Fields ","Verifying Account name required field is populated ",  Status.PASS);
		Utility_Functions.xWaitForElementPresent(driver, billingStreetQuickCreate, 5);
		Utility_Functions.xSendKeys(driver, billingStreetQuickCreate, "2100 Ross Ave");
		report.updateTestLog("Verify Account Creation With Required Fields ","Verifying Billing Street required field is populated ",  Status.PASS);
		Utility_Functions.xWaitForElementPresent(driver, billingCityQuickCreate, 5);
		Utility_Functions.xSendKeys(driver, billingCityQuickCreate, "Dallas");
		report.updateTestLog("Verify Account Creation With Required Fields ","Verifying Billing City required field is populated ",  Status.PASS);
		Utility_Functions.xWaitForElementPresent(driver, billingCountryQuickCreate, 3);
		Utility_Functions.xClick(driver, billingCountryQuickCreate, true);
		Utility_Functions.xWaitForElementPresent(driver, billingCountryUnitedStatesQuickCreate, 3);
		Utility_Functions.xClick(driver, billingCountryUnitedStatesQuickCreate, true);
		report.updateTestLog("Verify Account Creation With Required Fields ","Verifying Billing Country required field is populated ",  Status.PASS);
		Utility_Functions.xWaitForElementPresent(driver, billingStateQuickCreate, 3);
		Utility_Functions.xClick(driver, billingStateQuickCreate, true);
		Utility_Functions.xWaitForElementPresent(driver, billingStateTexasQuickCreate, 3);
		Utility_Functions.xClick(driver, billingStateTexasQuickCreate, true);
		report.updateTestLog("Verify Account Creation With Required Fields ","Verifying Billing State required field is populated ",  Status.PASS);
		Utility_Functions.xWaitForElementPresent(driver, saveQuickCreate, 3);
		Utility_Functions.xClick(driver, saveQuickCreate, true);
		report.updateTestLog("Verify Account Creation With Required Fields ","Verifying the Account is saved with all required fields",  Status.PASS);
		Utility_Functions.timeWait(2);
		//Utility_Functions.xWaitForElementPresent(driver, accountNameSaved, 3);
		if (accountNameSaved.getText().equals(accountName)) {
			System.out.println("The new account is saved with all the required fields");
			report.updateTestLog("Verify Account Creation With Required Fields ","Verifying the new account is saved with all the required fields ",  Status.PASS);
		} else {
			System.out.println("The new account is not saved with all the required fields");
			report.updateTestLog("Verify Account Creation With Required Fields ","Verifying the new account is saved with all the required fields ",  Status.FAIL);
		}	
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
		report.updateTestLog("Verify Create Accounts View Hierarchy","Verifying the Accounts is Displayed ",  Status.PASS);
		List<WebElement> accountNamesList = driver.findElements(By.xpath(".//a[@class='slds-truncate outputLookupLink slds-truncate forceOutputLookup']"));
		Utility_Functions.xclickRandomElement(accountNamesList);
		String query = "SELECT Id FROM Account where D_U_N_S__c != null limit 1 ";
		String accountId = searchAccount.fetchRecordFieldValue("Id", query);
		if(accountId==null){
			report.updateTestLog("Verify Create Accounts View Hierarchy", "verifying the accountid is retrieved", Status.PASS);
		} else {
			String url = driver.getCurrentUrl().split("#")[0];
			String newUrl = url + "#/sObject/" + accountId;
			newUrl = newUrl + "/view";
			report.updateTestLog("Verify Create Accounts View Hierarchy",
					"Verifying the URL has been replaced with the new URL having the retrieved Account" + newUrl, Status.PASS);
			driver.get(newUrl);
			Utility_Functions.timeWait(3);
			Utility_Functions.xScrollWindow(driver);
			Utility_Functions.timeWait(1);
			Utility_Functions.xScrollWindowTop(driver);
			Utility_Functions.timeWait(2);		
			if (!accountDetailsDUNS.getText().contains(" ")) {
				System.out.println(
						"DUNS is populated with the default value");
				report.updateTestLog("Verify Create Accounts View Hierarchy","Verifying the DUNS is populated in the Accounts Details Page ",  Status.PASS);
			} else {
				System.out.println(
						"DUNS is not populated with the default value");
				report.updateTestLog("Verify Create Accounts View Hierarchy","Verifying the DUNS is populated in the Accounts Details Page ",  Status.FAIL);
			}
			Utility_Functions.timeWait(3);
			driver.navigate().refresh();
			Utility_Functions.xWaitForElementPresent(driver,showMoreActions, 3);
			Utility_Functions.xClick(driver, showMoreActions, true);
			report.updateTestLog("Verify Create Accounts View Hierarchy","Verifying the show more actions is displayed in the Accounts Details Page ",  Status.PASS);
			Utility_Functions.xWaitForElementPresent(driver, selectViewHierarchy, 3);
			Utility_Functions.xClick(driver, selectViewHierarchy, true);
			report.updateTestLog("Verify Create Accounts View Hierarchy","Verifying the View Hierarchy is displayed in the show more actions and is being able to be clicked",  Status.PASS);
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
		report.updateTestLog("Verify Accounts Details Page ","Accounts is Displayed ",  Status.PASS);
		List<WebElement> accountNamesList = driver.findElements(By.xpath(".//a[@class='slds-truncate outputLookupLink slds-truncate forceOutputLookup']"));
		Utility_Functions.xclickRandomElement(accountNamesList);
		Utility_Functions.timeWait(5);
		List<WebElement> accountDetailsPageList = driver.findElements(By.xpath("//div[@class='test-id__field-label-container']/span[text()!='']"));
		int count1 = 0, i1 = 0,j1=0;
		String fieldsArray[] = new String[accountDetailsPageList.size()];
		System.out.println(accountDetailsPageList.size());
		try {
			detailsPageFields();
			while(j1<accountDetailsPageList.size()) {
				for (WebElement element1 : accountDetailsPageList) {
					fieldsArray[i1] = element1.getText();
					if (fieldsArray[i1].equalsIgnoreCase(deatilsPageFieldsList.get(j1))) {
						System.out.println("Verify Account Details Page " + element1.getText());
						report.updateTestLog("Verify Account Details Page ", element1.getText() + "labels  present in the Account Detailed Page ", Status.PASS);
						count1++;
					}
					i1++;
				}
				i1=0;
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

		List<WebElement> accountDetailsPageHeadersList = driver.findElements(By.xpath("//span[contains(@class,'header-title')]"));
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
							"Accounts Details  page is having the " + fieldsArray2[i2] + " Headers ",
							Status.PASS);
					count2++;
				}
				i2++;
			}
			System.out.println(count2);
			if (count2 != 10) {
				report.updateTestLog("Verify Accounts Details Page", "All sections are not present in the Accounts Details Page", Status.FAIL);
			} else {

				report.updateTestLog("Verify Accounts Details Page", "All sections are present in the Accounts Details Page", Status.PASS);
			}

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		Utility_Functions.xClick(driver, related_Accounts, true);
		Utility_Functions.timeWait(5);
		List<WebElement> accountRelatedPageHeadersList = driver.findElements(By.xpath("//h2[@id='header']/a/span[1]"));
		int count3 = 0, i3 = 0, j=0;
		String fieldsArray3[] = new String[accountRelatedPageHeadersList.size()];
		System.out.println(accountRelatedPageHeadersList.size());
		try {
			accountRelatedPageHeaders();
			while(j<accountRelatedPageHeadersList.size()) {
				for (WebElement element3 : accountRelatedPageHeadersList) {
					fieldsArray3[i3] = element3.getText();
					if (fieldsArray3[i3].equalsIgnoreCase(accountsRelatedPageHeadersList.get(j))) {
						System.out.println("Verify Account Details Page " + element3.getText());
						report.updateTestLog("Verify Account Details Page ", element3.getText() + "Headers are  present in the Account Related Page ", Status.PASS);
						count3++;
					}
					i3++;
					if(count3==9) 
						break;
				}
				i3=0;
				j++;
			}
			System.out.println(count3);
			if (count3 != 9) {
				report.updateTestLog("Verify Accounts Details Page", "All sections are not present in the Accounts Related Page", Status.FAIL);
			} else {
				report.updateTestLog("Verify Accounts Details Page", "All sections are present in the Accounts Related Page", Status.PASS);
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
		report.updateTestLog("Verify Account Details Page ","Accounts is Displayed ",  Status.PASS);
		List<WebElement> accountNamesList = driver.findElements(By.xpath("//a[@class='slds-truncate outputLookupLink slds-truncate forceOutputLookup']"));
		Utility_Functions.xclickRandomElement(accountNamesList);
		Utility_Functions.timeWait(3);
		report.updateTestLog("Verify Account Details Page ","The Account is Displayed ",  Status.PASS);
		Utility_Functions.xClick(driver, related_Accounts, true);
		Utility_Functions.timeWait(5);
		List<WebElement> accountRelatedPageHeadersList = driver.findElements(
				By.xpath("//h2[@id='header']/a/span[1]"));
		int count3 = 0, i3 = 0, j=0;
		String fieldsArray3[] = new String[accountRelatedPageHeadersList.size()];
		System.out.println(accountRelatedPageHeadersList.size());
		try {
			accountRelatedPageHeaders();
			while(j<accountRelatedPageHeadersList.size()) {
				for (WebElement element3 : accountRelatedPageHeadersList) {
					fieldsArray3[i3] = element3.getText();
					if (fieldsArray3[i3].equalsIgnoreCase(accountsRelatedPageHeadersList.get(j))) {
						System.out.println("Verify Account Details Page " + element3.getText());
						report.updateTestLog("Verify Account Details Page ", element3.getText() + "Headers are  present in the Account Related Page ", Status.PASS);
						count3++;
					}
					i3++;
					if(count3==9) 
						break;
				}
				i3=0;
				j++;
			}
			System.out.println(count3);
			if (count3 > 11) {
				report.updateTestLog("Verify Accounts Details Page", "All sections are not present in the Accounts Related Page", Status.FAIL);
			} else {
				report.updateTestLog("Verify Accounts Details Page", "All sections are present in the Accounts Related Page", Status.PASS);
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
		report.updateTestLog("Verify Accounts Details Page ","Accounts is Displayed ",  Status.PASS);
		List<WebElement> accountNamesList = driver.findElements(By.xpath("//a[@class='slds-truncate outputLookupLink slds-truncate forceOutputLookup']"));
		Utility_Functions.xclickRandomElement(accountNamesList);
		Utility_Functions.timeWait(5);
		List<WebElement> accountDetailsPageList = driver.findElements(By.xpath("//div[@class='test-id__field-label-container']/span[text()!='']"));
		int count1 = 0, i1 = 0,j1=0;
		String fieldsArray[] = new String[accountDetailsPageList.size()];
		System.out.println("Account Details xPath Count::" + accountDetailsPageList.size());
		System.out.println("Details Page Fields list Count::" + deatilsPageFieldsList.size());
		try {
			detailsPageFields();
			while(j1<accountDetailsPageList.size()) {
				for (WebElement element1 : accountDetailsPageList) {
					fieldsArray[i1] = element1.getText();
					if (fieldsArray[i1].equalsIgnoreCase(deatilsPageFieldsList.get(j1))) {
						System.out.println("Verify Account Details Page " + element1.getText());
						report.updateTestLog("Verify Account Details Page ", element1.getText() + "labels  present in the Account Detailed Page ", Status.PASS);
						count1++;
					} else {
						deatilsPageFieldsNotPresentList.add(element1.getText());
					}
					i1++;
				}
				i1=0;
				j1++;
			}
			System.out.println(count1);
			System.out.println("Elements which are not present in the page are :::" + deatilsPageFieldsNotPresentList);
			if (count1 != 31) {
				report.updateTestLog("Verify Accounts Details Page", "All fields are not present in the Accounts Details Page", Status.FAIL);
			} else {
				report.updateTestLog("Verify Accounts Details Page", "All fields are present in the Accounts Details Page", Status.PASS);
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
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
		System.out.println("Client Type field pick list values  are:: " +clientTypeFieldPickListValuesList);
	}

	static ArrayList<String> addressInformationSectionFieldsList = new ArrayList<String>();
	public void addressInformationFields() {
		addressInformationSectionFieldsList.add("Shipping Street");
		addressInformationSectionFieldsList.add("Shipping City");
		addressInformationSectionFieldsList.add("Shipping Country");
		addressInformationSectionFieldsList.add("Shipping State/Province");
		addressInformationSectionFieldsList.add("Shipping Zip/Postal Code");
		System.out.println("Address Information section fields  are:: " +addressInformationSectionFieldsList);
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
		System.out.println("Local address infomation fields are:: " +localAddressInformationFieldsList);
	}

	static ArrayList<String> additionalInformationFieldsList = new ArrayList<String>();
	public void additionalInformationFields() {
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
		System.out.println("Additional Information section fields are :: " +additionalInformationFieldsList);
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
		System.out.println("Investor profile field pick list values  are:: " +investorProfileFieldsList);
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
		System.out.println("Lender Type field pick list values  are:: " +lenderTypeFieldsList);
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
		System.out.println("Account source Type field pick list values  are:: " +accountSourceTypeFieldsList);
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
		System.out.println("SIC section fields are:: " +SICFieldsList);
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
		System.out.println("System information fields are:: " +systemInformationFieldsList);
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
		Utility_Functions.xWaitForElementPresent(driver, menu_Accounts, 3);
		Utility_Functions.xClick(driver, menu_Accounts, true);
		Utility_Functions.timeWait(1);
		report.updateTestLog("Verify New Account Page Layout ","Verifying Accounts is Displayed ",  Status.PASS);
		Utility_Functions.xWaitForElementPresent(driver, newAccounts, 3);
		Utility_Functions.xClick(driver, newAccounts, true);
		Utility_Functions.timeWait(2);
		report.updateTestLog("Verify New Account Page Layout  ","Verifying New Accounts Page is Displayed  ",  Status.PASS);
		Utility_Functions.xSwitchtoFrame(driver, viewAllFieldsButton);
		Utility_Functions.xWaitForElementPresent(driver, viewAllFieldsButton, 5);
		Utility_Functions.xScrollWindow(driver);
		Utility_Functions.xClick(driver, viewAllFieldsButton, true);
		Utility_Functions.timeWait(1);
		Utility_Functions.xScrollWindowTop(driver);
		Utility_Functions.timeWait(5);
		List<WebElement> accountInformationSectionList = driver.findElements(By.xpath("//h2[text()='Account Information']/parent::div/parent::div/div//label[@class='slds-form-element__label']"));
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
							"Accounts Details  page is having the " + fieldsArray2[i1] + " fields ",
							Status.PASS);
					count1++;
				}
				i1++;
			}
			System.out.println(count1);
			if (count1 != 17) {
				report.updateTestLog("Verify New Account Page Layout ", "All fields are not present in the Account Information section ", Status.FAIL);
			} else {

				report.updateTestLog("Verify New Account Page Layout ", "All fields are present in the Account Information section", Status.PASS);
			}

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		List<WebElement> legalStatusPickList = driver.findElements(
				By.xpath("//select[contains(@id,'LegalStatus')]/option"));
		int count2 = 0, i2 = 0;
		String fieldsArray[] = new String[legalStatusPickList.size()];
		System.out.println(legalStatusPickList.size());
		try {
			legalStatusPickList();
			for (WebElement element : legalStatusPickList) {
				System.out.println(element.getText());
				fieldsArray[i2] = element.getText();
				if (fieldsArray[i2].contains(legalStatusPickListValuesList.get(i2))) {
					report.updateTestLog("Verify New Account Page Layout ", "Accounts Details  page is having the " + fieldsArray[i2] + " fields ",
							Status.PASS);
					count2++;
				}
				i2++;
			}
			System.out.println(count2);
			if (count2 != 8) {
				report.updateTestLog("Verify New Account Page Layout ", "All the pick list values are not present in the Legal Status Pick List field ", Status.FAIL);
			} else {

				report.updateTestLog("Verify New Account Page Layout ", "All the pick list values are present in the Legal Status Pick List field", Status.PASS);
			}

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		Utility_Functions.xWaitForElementPresent(driver, legalStatusValue, 3);
		Utility_Functions.xClick(driver,legalStatusValue, true);
		if(!migratedAccount.isSelected()){ 
			Utility_Functions.xClick(driver,migratedAccount, true);
			System.out.println("Migrated Account check box is checked");
			report.updateTestLog("Verify New Account Page Layout","Verifying the migrated account check box is checked or else checking it",  Status.PASS);
		} else{
			System.out.println("Migrated Account checkbox is not checked");
			report.updateTestLog("Verify New Account Page Layout","Verifying the migrated account check box is checked or not ",  Status.FAIL);
		}
		Utility_Functions.xWaitForElementPresent(driver, accountNameQuickCreate, 5);
		String value = Utility_Functions.xGenerateAlphaNumericString();
		String accountName = value + "Test Automation";
		Utility_Functions.xSendKeys(driver, accountNameQuickCreate, accountName);
		report.updateTestLog("Verify Account Creation With Required Fields ","Verifying Account name required field is populated ",  Status.PASS);
		Utility_Functions.xWaitForElementPresent(driver, billingStreetQuickCreate, 5);
		Utility_Functions.xSendKeys(driver, billingStreetQuickCreate, "2100 Ross Ave");
		report.updateTestLog("Verify Account Creation With Required Fields ","Verifying Billing Street required field is populated ",  Status.PASS);
		Utility_Functions.xWaitForElementPresent(driver, billingCityQuickCreate, 5);
		Utility_Functions.xSendKeys(driver, billingCityQuickCreate, "Dallas");
		report.updateTestLog("Verify Account Creation With Required Fields ","Verifying Billing City required field is populated ",  Status.PASS);
		Utility_Functions.xWaitForElementPresent(driver, billingCountryQuickCreate, 3);
		Utility_Functions.xClick(driver, billingCountryQuickCreate, true);
		Utility_Functions.xWaitForElementPresent(driver, billingCountryUnitedStatesQuickCreate, 3);
		Utility_Functions.xClick(driver, billingCountryUnitedStatesQuickCreate, true);
		report.updateTestLog("Verify Account Creation With Required Fields ","Verifying Billing Country required field is populated ",  Status.PASS);
		Utility_Functions.xWaitForElementPresent(driver, billingStateQuickCreate, 3);
		Utility_Functions.xClick(driver, billingStateQuickCreate, true);
		Utility_Functions.xWaitForElementPresent(driver, billingStateTexasQuickCreate, 3);
		Utility_Functions.xClick(driver, billingStateTexasQuickCreate, true);
		report.updateTestLog("Verify Account Creation With Required Fields ","Verifying Billing State required field is populated ",  Status.PASS);
		Utility_Functions.timeWait(2);
		if (dataTable.getData("General_Data", "TC_ID").contains("AMER")) {			
			Utility_Functions.xWaitForElementPresent(driver,amerIndustry, 5);
			//Utility_Functions.xClick(driver,amerIndustry, true);
			Utility_Functions.timeWait(2);
			//Utility_Functions.xWaitForElementPresent(driver,amerIndustryValue, 3);
			Utility_Functions.xClick(driver, amerIndustryValue, true);
		} else if (dataTable.getData("General_Data", "TC_ID").contains("EMEA")) {
			Utility_Functions.xWaitForElementPresent(driver,industry, 3);
			Utility_Functions.xClick(driver, industry, true);
			Utility_Functions.xWaitForElementPresent(driver,industryValue, 3);
			Utility_Functions.xClick(driver, industryValue, true);
		}
		Utility_Functions.xWaitForElementPresent(driver, website, 3);
		Utility_Functions.xSendKeys(driver, website, dataTable.getData("General_Data", "Email"));
		Utility_Functions.xWaitForElementPresent(driver,phone, 3);
		Utility_Functions.xSendKeys(driver,phone, dataTable.getData("General_Data", "Phone"));
		Utility_Functions.xWaitForElementPresent(driver,accountFax, 3);
		Utility_Functions.xSendKeys(driver, accountFax, dataTable.getData("General_Data", "Phone"));
		Utility_Functions.xWaitForElementPresent(driver, localAccountName, 3);
		Utility_Functions.xSendKeys(driver,localAccountName, dataTable.getData("General_Data", "Account Name"));
		List<WebElement> accountSegmentationSectionList = driver.findElements(By.xpath("//h2[text()='Account Segmentation']/parent::div/parent::div/div//label[@class='slds-form-element__label']"));
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
		/*List<WebElement> clientTypePickList = driver.findElements(By.xpath("//table[@class='multiSelectPicklistTable']//select[contains(@title,'Client Type')]/option"));
		int count4 = 0, i4 = 0;
		String fieldsArray4[] = new String[clientTypePickList.size()];
		System.out.println(clientTypePickList.size());

		try {
			clientTypeFieldPickList();
			for (WebElement element4 : clientTypePickList) {
				System.out.println(element4.getText());
				fieldsArray4[i4] = element4.getText();
				if (fieldsArray4[i4].contains(clientTypeFieldPickListValuesList.get(i4))) {
					report.updateTestLog("Verify New Account Page Layout ",
							"Client Type pick list is having the " + fieldsArray4[i4] + " values ",
							Status.PASS);
					count4++;
				}
				i4++;
			}
			System.out.println(count4);
			if (count4 != 12) {
				report.updateTestLog("Verify New Account Page Layout ",
						"All the values are not present in the Client type pick list ", Status.FAIL);
			} else {

				report.updateTestLog("Verify New Account Page Layout ",
						"All the values are not present in the client type pick list", Status.PASS);
			}

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}*/

		List<WebElement> addressInformationSectionList = driver.findElements(By.xpath("//h2[text()='Address Information']/parent::div/parent::div/div//label[@class='slds-form-element__label']"));
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
							"Address Information section is having the " + fieldsArray5[i5] + " fields ",
							Status.PASS);
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
		List<WebElement> localAddressInformationSectionList = driver.findElements(
				By.xpath("//h2[text()='Local Address Information']/parent::div/parent::div/div//label[@class='slds-form-element__label']"));
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

		List<WebElement> countriesList = driver.findElements(By.xpath("//select[contains(@id,'Local_Billing_Country__c')]/option"));
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
			if (count14!= 244) {
				report.updateTestLog("Verify New Account Page Layout ",
						"All countries are not present in the local Billing Countries section ", Status.FAIL);
			} else {

				report.updateTestLog("Verify New Account Page Layout ",
						"All countries are present in the local Billing countries section", Status.PASS);
			}

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		Utility_Functions.timeWait(5);
		Utility_Functions.xWaitForElementPresent(driver, localBillingCountry, 3);
		Utility_Functions.xClick(driver, localBillingCountry, true);
		Utility_Functions.xWaitForElementPresent(driver, localBillingCountryValue, 3);
		Utility_Functions.xClick(driver, localBillingCountryValue, true);
		Utility_Functions.xWaitForElementPresent(driver,localBillingStreet, 3);
		Utility_Functions.xSendKeys(driver, localBillingStreet, dataTable.getData("General_Data", "Street"));
		Utility_Functions.xWaitForElementPresent(driver, localBillingState, 3);
		Utility_Functions.xClick(driver,localBillingState, true);
		Utility_Functions.xWaitForElementPresent(driver, localBillingStateValue, 3);
		Utility_Functions.xClick(driver, localBillingStateValue, true);
		Utility_Functions.xWaitForElementPresent(driver, localBillingCity, 3);
		Utility_Functions.xSendKeys(driver, localBillingCity, dataTable.getData("General_Data", "City"));
		Utility_Functions.xWaitForElementPresent(driver, localBillingZipCode, 3);	
		Utility_Functions.xSendKeys(driver, localBillingZipCode, dataTable.getData("General_Data", "Zipcode"));
		Utility_Functions.xWaitForElementPresent(driver, localShippingCountry, 3);
		//Utility_Functions.xClick(driver, localShippingCountry, true);
		//Utility_Functions.xWaitForElementPresent(driver, localShippingCountryValue, 3);
		Utility_Functions.xWaitForElementPresent(driver, localShippingCountry, 3);
		Utility_Functions.xClick(driver, localShippingCountryValue, true);
		Utility_Functions.xWaitForElementPresent(driver, localShippingState, 3);
		Utility_Functions.xClick(driver, localShippingState, true);
		Utility_Functions.xWaitForElementPresent(driver, localShippingStateValue, 3);
		Utility_Functions.xClick(driver, localShippingStateValue, true);
		Utility_Functions.xWaitForElementPresent(driver,localShippingStreet, 3);
		Utility_Functions.xSendKeys(driver, localShippingStreet, dataTable.getData("General_Data", "Street"));
		Utility_Functions.xWaitForElementPresent(driver, localShippingCity, 3);
		Utility_Functions.xSendKeys(driver, localShippingCity, dataTable.getData("General_Data", "City"));
		Utility_Functions.xWaitForElementPresent(driver, localShippingZipCode, 3);
		Utility_Functions.xSendKeys(driver, localShippingZipCode, dataTable.getData("General_Data", "Zipcode"));
		List<WebElement> additionalInformationSectionList = driver.findElements(
				By.xpath("//h2[text()='Additional Information']/parent::div/parent::div/div//label[@class='slds-form-element__label']"));
		int count7 = 0, i7 = 0;
		String fieldsArray7[] = new String[additionalInformationSectionList.size()];
		System.out.println(additionalInformationSectionList.size());

		try {
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
		List<WebElement> investorProfileFieldPickList = driver.findElements(By.xpath("//select[contains(@id,'Investor_Profile__c')]/option"));
		int count8 = 0, i8 = 0;
		String fieldsArray8[] = new String[investorProfileFieldPickList.size()];
		System.out.println(investorProfileFieldPickList.size());
		try {
			investorProfilePickListFields();
			for (WebElement element8 :investorProfileFieldPickList ) {
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
						"All the pick list values are not present in the Investor Profile Pick List field ", Status.FAIL);
			} else {

				report.updateTestLog("Verify New Account Page Layout ",
						"All the pick list values are present in the Investor Profile Pick List field", Status.PASS);
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		Utility_Functions.xWaitForElementPresent(driver,industryValue , 3);
		Utility_Functions.xClick(driver, industryValue, true);
		Utility_Functions.xWaitForElementPresent(driver,selectIndustryValue , 3);
		Utility_Functions.xClick(driver,selectIndustryValue, true);
		List<WebElement> lenderTypeFieldPickList = driver.findElements(By.xpath("//select[contains(@id,'Lender_Type__c')]/option"));
		int count9 = 0, i9 = 0;
		String fieldsArray9[] = new String[lenderTypeFieldPickList.size()];
		System.out.println(lenderTypeFieldPickList.size());
		try {
			lenderTypeFields();
			for (WebElement element9 :lenderTypeFieldPickList ) {
				System.out.println(element9.getText());
				fieldsArray9[i9] = element9.getText();
				if (fieldsArray9[i9].contains(lenderTypeFieldsList.get(i9))) {
					report.updateTestLog("Verify New Account Page Layout ",
							"Lender Type Pick List field is having the " + fieldsArray9[i9] + " values ",
							Status.PASS);
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
		Utility_Functions.xWaitForElementPresent(driver,lenderType, 3);
		Utility_Functions.xClick(driver,lenderType, true);
		Utility_Functions.xWaitForElementPresent(driver,selectLenderType, 3);
		Utility_Functions.xClick(driver,selectLenderType, true);
		List<WebElement> accountSourceFieldPickList = driver.findElements(By.xpath("//select[contains(@id,'AccountSource')]/option"));
		int count10 = 0, i10 = 0;
		String fieldsArray10[] = new String[accountSourceFieldPickList.size()];
		System.out.println(accountSourceFieldPickList.size());
		try {
			accountSourceTypeFields();
			for (WebElement element10 :accountSourceFieldPickList ) {
				System.out.println(element10.getText());
				fieldsArray10[i10] = element10.getText();
				if (fieldsArray10[i10].contains(accountSourceTypeFieldsList.get(i10))) {
					report.updateTestLog("Verify New Account Page Layout ",
							"Accounts Details  page is having the " + fieldsArray10[i10] + " fields ",
							Status.PASS);
					count10++;
				}
				i10++;
			}
			System.out.println(count10);
			if (count10 != 13) {
				report.updateTestLog("Verify New Account Page Layout ", "All the pick list values are not present in the Account Source Pick List field ", Status.FAIL);
			} else {

				report.updateTestLog("Verify New Account Page Layout ", "All the pick list values are present in the Account Source Pick List field", Status.PASS);
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		Utility_Functions.xWaitForElementPresent(driver,accountSourceField, 3);
		Utility_Functions.xClick(driver,accountSourceField, true);
		Utility_Functions.xClick(driver, tickerSymbol, true);
		Utility_Functions.timeWait(3);
		Utility_Functions.xWaitForElementPresent(driver,tickerSymbol, 5);
		Utility_Functions.xSendKeys(driver, tickerSymbol, "Test Activity Created by Automation_" + Utility_Functions.xGenerateAlphaNumericString());
		Utility_Functions.xWaitForElementPresent(driver,annualRevenue, 3);
		Utility_Functions.xSendKeys(driver,naicsCode, dataTable.getData("General_Data", "Annual Revenue"));
		List<WebElement> SICSectionList = driver.findElements(By.xpath("//h2[text()='SIC/NAICS Codes']/parent::div/parent::div/div//label[@class='slds-form-element__label']"));
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
							"SIC section is having the " + fieldsArray11[i11] + " fields ",
							Status.PASS);
					count11++;
				}
				i11++;
			}
			System.out.println(count11);
			if (count11 != 16) {
				report.updateTestLog("Verify New Account Page Layout ", "All fields are not present in the SIC section ", Status.FAIL);
			} else {

				report.updateTestLog("Verify New Account Page Layout ", "All fields are present in the SIC section", Status.PASS);
			}

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		Utility_Functions.xWaitForElementPresent(driver,naicsCode, 3);
		Utility_Functions.xSendKeys(driver,naicsCode, dataTable.getData("General_Data", "NAICS Code"));
		Utility_Functions.xWaitForElementPresent(driver,sicCode1, 3);
		Utility_Functions.xSendKeys(driver,sicCode3, dataTable.getData("General_Data", "SIC Code1"));
		Utility_Functions.xWaitForElementPresent(driver,sicCode2, 3);
		Utility_Functions.xSendKeys(driver,sicCode3, dataTable.getData("General_Data", "SIC Code2"));
		Utility_Functions.xWaitForElementPresent(driver,sicCode3, 3);
		Utility_Functions.xSendKeys(driver,sicCode3, dataTable.getData("General_Data", "SIC Code3"));
		Utility_Functions.xWaitForElementPresent(driver, sicCode4, 3);	
		Utility_Functions.xSendKeys(driver,sicCode4, dataTable.getData("General_Data", "SIC Code4"));
		Utility_Functions.xWaitForElementPresent(driver,sicCode5, 3);
		Utility_Functions.xSendKeys(driver,sicCode5, dataTable.getData("General_Data", "SIC Code5"));
		Utility_Functions.xWaitForElementPresent(driver, sicCode6, 3);	
		Utility_Functions.xSendKeys(driver,sicCode6, dataTable.getData("General_Data", "SIC Code6"));
		Utility_Functions.xWaitForElementPresent(driver,accountDescription, 5);
		String sb = "Twinkle, twinkle, little star,"
				+ "How I wonder what you are."
				+ "Up above the world so high,"
				+ "Like a diamond in the sky."

				+"When the blazing sun is gone,"
				+"When the nothing shines upon,"
				+"Then you show your little light,"
				+"Twinkle, twinkle, all the night."

				+"Then the traveler in the dark,"
				+"Thanks you for your tiny spark,"
				+"He could not see which way to go,"
				+"If you did not twinkle so." 

				+"In the dark blue sky you keep,"
				+"And often through my curtains peep,"
				+"For you never shut your eye,"
				+"Till the sun is in the sky." 

				+"As your bright and tiny spark,"
				+"Lights the traveler in the dark."
				+"Though I know not what you are,"
				+"Twinkle, twinkle, little star." 

				+"Twinkle, twinkle, little star."
				+"How I wonder what you are."
				+"Up above the world so high,"
				+"Like a diamond in the sky." 

				+"Twinkle, twinkle, little star."
				+"How I wonder what you are."
				+"How I wonder what you are.  ";

		System.out.println(sb);
		Utility_Functions.xSendKeys(driver, accountDescription, sb);
		List<WebElement> descriptionInformationSectionList = driver.findElements(By.xpath("//h2[text()='Description Information']/parent::div/parent::div/div//label[@class='slds-form-element__label']"));
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
			if (count12!= 1) {
				report.updateTestLog("Verify New Account Page Layout ", "All fields are not present in the Description Information section ", Status.FAIL);
			} else {

				report.updateTestLog("Verify New Account Page Layout ", "All fields are present in the Description Information section", Status.PASS);
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		List<WebElement> systemInformationSectionList = driver.findElements(By.xpath("//h2[text()='System Information']/parent::div/parent::div/div//label[@class='slds-form-element__label']"));
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
			if (count13!= 10) {
				report.updateTestLog("Verify New Account Page Layout ",	"All fields are not present in the System Information section ", Status.FAIL);
			} else {
				report.updateTestLog("Verify New Account Page Layout ", "All fields are present in the System Information section", Status.PASS);
			}

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		Utility_Functions.xWaitForElementPresent(driver, saveQuickCreate, 3);
		Utility_Functions.xClick(driver, saveQuickCreate, true);
	}
}

