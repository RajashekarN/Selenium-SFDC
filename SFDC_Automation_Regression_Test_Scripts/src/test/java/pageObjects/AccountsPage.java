package pageObjects;

import java.util.ArrayList;
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

	@FindBy(xpath = "//article[contains(@class,'forceRelatedListSingleContainer')]//span[contains(text(),'Private Notes')]/ancestor::article//div[text()='New']")
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

	@FindBy(xpath = "//article[contains(@class,'forceRelatedListSingleContainer')]//span[contains(text(),'Activities')]/ancestor::article//div[text()='New Activity']")
	WebElement newActivity;

	@FindBy(xpath = "//input[@class='slds-input'][@type='text']")
	WebElement subject;

	@FindBy(xpath = "//select[@class='slds-select']/option[@value='Private - Client Intelligence']")
	WebElement activityType1;

	@FindBy(xpath = "// input [@value= 'Save & New']")
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

	@FindBy(xpath = "//button[contains(@class,'context-bar__label-action')][text()='More']")
	WebElement menu_More;

	@FindBy(xpath="//a[@role='menuitem']/span[contains(@class,'slds-truncate')][text()='Bulk Tagging']")
	WebElement bulkTagging;

	@FindBy(xpath="//input[@class='slds-input'][@placeholder='Search Account/Contact/Lead/Opportunities…'][@type='text']")
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
		Random random = new Random();
		int value = random.nextInt();
		Utility_Functions.xSendKeys(driver, titleName, "Test Personal Information Note" + value);
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
		Utility_Functions.xSendKeys(driver, noteTitle, "test");
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
		Utility_Functions.xSendKeys(driver, subject, "test1");
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
		Utility_Functions.xSendKeys(driver, subject, "test1");
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
		Random random = new Random();
		int value = random.nextInt();
		Utility_Functions.xWaitForElementPresent(driver, subject, 5);
		Utility_Functions.xSendKeys(driver, subject, "Test Activity Created by Automation" + value);
		Utility_Functions.xClick(driver, activityType2, true);
		Utility_Functions.xWaitForElementPresent(driver,saveActivity, 5);
		Utility_Functions.xClick(driver, saveActivity, true);

		SearchTextSOQL searchTextSOQL = new SearchTextSOQL(scriptHelper);
		String query = "select Name from Activity__C where Subject__C = " + "'" + "Test Activity Created by Automation" + value + "'";
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
		Utility_Functions.xSendKeys(driver, subject, "test3");
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
		Utility_Functions.xSendKeys(driver, subject, "test1");
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
		Utility_Functions.xSendKeys(driver, subject, "test1");
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
		Utility_Functions.xWaitForElementPresent(driver, accountSearch, 3);
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
				report.updateTestLog("Verify Reports CIM", "All the reports with respect CIM are not present", Status.FAIL);
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
		Utility_Functions.xWaitForElementPresent(driver, related_Accounts, 3);
		Utility_Functions.xClick(driver, related_Accounts, true);
		report.updateTestLog("Verify New Activity Page Layout ","Verifying the related page is Displayed ",  Status.PASS);
		Utility_Functions.xScrollWindow(driver);
		Utility_Functions.timeWait(1);
		Utility_Functions.xScrollWindowTop(driver);
		Utility_Functions.timeWait(3);



		if(!investorServicesCheckBox.isSelected()){


			//Utility_Functions.xClick(driver, notificationEmail, true);
			System.out.println("Investor Services CheckBox is present and not checked");
			report.updateTestLog("Verify Accounts Investor Services Check Box  ","Verifying the Investor Services check box is checked or else checking it",  Status.PASS);

		}else{
			System.out.println("Investor Services CheckBox is not present and not checked");
			report.updateTestLog("Verify Accounts Investor Services Check Box  ","Verifying the Investor Services check box is checked or not ",  Status.FAIL);
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
}

