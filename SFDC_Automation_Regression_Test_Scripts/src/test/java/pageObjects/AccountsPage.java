package pageObjects;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.cognizant.Craft.ReusableLibrary;
import com.cognizant.Craft.ScriptHelper;
import com.cognizant.framework.Status;

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

	@FindBy(xpath = "//article[contains(@class,'Private Notes')]//div[text()='New']")
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

	@FindBy(xpath = "//article[contains(@class,'Activities')]//div[text()='New Activity']")
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

	HomePage hp = new HomePage(scriptHelper);
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
		Utility_Functions.xWaitForElementValuePresent(driver, menu_Accounts, 3);
		Utility_Functions.xClick(driver, menu_Accounts, true);
		Utility_Functions.timeWait(3);
		List<WebElement> accountNamesList = driver.findElements(
				By.xpath(".//a[@class='slds-truncate outputLookupLink slds-truncate forceOutputLookup']"));

		Utility_Functions.xclickOnFirstElementfromList(accountNamesList);
		Utility_Functions.timeWait(3);
		Utility_Functions.xWaitForElementValuePresent(driver, related_Accounts, 3);
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
		Utility_Functions.xWaitForElementValuePresent(driver, newNotes, 3);
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
		Utility_Functions.xWaitForElementValuePresent(driver, doneButton, 3);
		Utility_Functions.xClick(driver, doneButton, true);
		Utility_Functions.xWaitForElementValuePresent(driver, addFile, 3);
		Utility_Functions.xClick(driver, addFile, true);
		Utility_Functions.xWaitForElementValuePresent(driver, addFileAttachment, 3);
		Utility_Functions.xClick(driver, addFileAttachment, true);
		Utility_Functions.xWaitForElementValuePresent(driver, add, 3);
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

		Utility_Functions.xClick(driver, menu_Accounts, true);
		Utility_Functions.timeWait(3);
		report.updateTestLog("Verify Create Activity Account", "Accounts is Displayed ", Status.PASS);
		Utility_Functions.xWaitForElementValuePresent(driver, recentlyViewed, 3);
		Utility_Functions.xClick(driver, recentlyViewed, true);
		report.updateTestLog("Verify Create Activity Account", "Recently viewed Accounts are Displayed ", Status.PASS);
		Utility_Functions.xWaitForElementValuePresent(driver, allAccounts, 3);
		Utility_Functions.xClick(driver, allAccounts, true);
		Utility_Functions.timeWait(3);
		report.updateTestLog("Verify Create Activity Account", "All accounts are displayed successfully:::",
				Status.PASS);
		List<WebElement> accountNamesList = driver.findElements(
				By.xpath(".//a[@class='slds-truncate outputLookupLink slds-truncate forceOutputLookup']"));

		Utility_Functions.xclickOnFirstElementfromList(accountNamesList);
		Utility_Functions.timeWait(3);
		report.updateTestLog("Verify Create Activity Account ", "The Account is Displayed ", Status.PASS);
		Utility_Functions.xClick(driver, related_Accounts, true);
		Utility_Functions.timeWait(3);
		report.updateTestLog("Verify Create Activity Account ", "The related page is Displayed ", Status.PASS);
		Utility_Functions.xScrollWindow(driver);
		Utility_Functions.timeWait(1);
		Utility_Functions.xScrollWindowTop(driver);
		Utility_Functions.timeWait(2);
		Utility_Functions.xWaitForElementValuePresent(driver, newActivity, 3);
		Utility_Functions.xClick(driver, newActivity, true);
		report.updateTestLog("Verify Create Activity Account ", "The New Activity in the related page is Displayed ",
				Status.PASS);
		int size = driver.findElements(By.tagName("iframe")).size();
		System.out.println(size);
		Utility_Functions.timeWait(2);
		List<WebElement> iframeList = driver.findElements(By.tagName("iframe"));
		System.out.println(iframeList.size());
		for (WebElement element : iframeList) {
			System.out.println(element.getAttribute("id"));
		}

		driver.switchTo().frame(5);
		Utility_Functions.timeWait(5);
		System.out.println("Frame Identified");
		Utility_Functions.timeWait(3);

		Utility_Functions.xClick(driver, subject, true);
		Utility_Functions.timeWait(3);
		Utility_Functions.xSendKeys(driver, subject, "test1");
		Utility_Functions.timeWait(3);
		Utility_Functions.xClick(driver, activityType1, true);
		Utility_Functions.timeWait(3);
		Utility_Functions.xClick(driver, saveAndNewActivity, true);
		Utility_Functions.timeWait(3);
		report.updateTestLog("Verify Create Activity Account ", "The Activity is saved and New Activity is displayed ",
				Status.PASS);
		Utility_Functions.xClick(driver, subject, true);
		Utility_Functions.timeWait(3);
		Utility_Functions.xSendKeys(driver, subject, "test2");
		Utility_Functions.timeWait(3);
		Utility_Functions.xClick(driver, activityType2, true);
		Utility_Functions.timeWait(3);
		Utility_Functions.xClick(driver, saveActivity, true);
		Utility_Functions.timeWait(3);
		report.updateTestLog("Verify Create Activity Account ", "The second Activity is saved ", Status.PASS);
		driver.navigate().refresh();
		Utility_Functions.timeWait(1);
		driver.switchTo().defaultContent();
		driver.navigate().refresh();
		Utility_Functions.xWaitForElementVisible(driver, related_Accounts, 3);
		Utility_Functions.xClick(driver, related_Accounts, true);
		Utility_Functions.timeWait(4);
		report.updateTestLog("Verify Create Activity Account ", "The related Accounts is Displayed ", Status.PASS);
		Utility_Functions.xScrollWindow(driver);
		Utility_Functions.timeWait(1);
		Utility_Functions.xScrollWindowTop(driver);
		Utility_Functions.timeWait(2);
		Utility_Functions.xClick(driver, relatedActivities, true);
		Utility_Functions.timeWait(4);
		report.updateTestLog("Verify Create Activity Account ", "The related activities is Displayed ", Status.PASS);
		List<WebElement> activitiesList = driver.findElements(
				By.xpath(".//a[@class='slds-truncate outputLookupLink slds-truncate forceOutputLookup'] "));
		for (int i = 0; i < activitiesList.size(); i++) {
			System.out.println("The activities are :" + i + activitiesList.get(i).getText());

		}
		Utility_Functions.xclickOnFirstElementfromList(activitiesList);
		Utility_Functions.timeWait(4);
		driver.navigate().refresh();
		Utility_Functions.timeWait(1);
		driver.switchTo().defaultContent();
		driver.navigate().refresh();
		Utility_Functions.timeWait(3);
		Utility_Functions.xClick(driver, selectCreateFollowUpCustomActivity, true);
		Utility_Functions.timeWait(4);
		report.updateTestLog("Verify Create Activity Account ", "The Follow up Activity Page is Displayed",
				Status.PASS);
		Utility_Functions.xWaitForElementValuePresent(driver, createCustomActivity, 5);
		// Utility_Functions.xClick(driver, createCustomActivity, true);
		Actions action = new Actions(driver.getWebDriver());
		action.moveToElement(createCustomActivity);
		action.click();
		action.build().perform();
		Utility_Functions.timeWait(3);
		int size1 = driver.findElements(By.tagName("iframe")).size();
		System.out.println(size1);
		Utility_Functions.timeWait(2);
		List<WebElement> iframeList1 = driver.findElements(By.tagName("iframe"));
		System.out.println(iframeList1.size());
		for (WebElement element : iframeList1) {
			System.out.println(element.getAttribute("id"));
		}

		driver.switchTo().frame(2);
		Utility_Functions.timeWait(5);
		System.out.println("Frame Identified");

		Utility_Functions.timeWait(3);
		Utility_Functions.xClick(driver, subject, true);
		Utility_Functions.timeWait(3);
		Utility_Functions.xSendKeys(driver, subject, "test3");
		Utility_Functions.timeWait(3);
		Utility_Functions.xClick(driver, activityType3, true);
		Utility_Functions.timeWait(3);
		Utility_Functions.xClick(driver, saveActivity, true);
		Utility_Functions.timeWait(3);
		report.updateTestLog("Verify Create Activity Account ", "The Custom Activity is created ", Status.PASS);
		driver.navigate().refresh();
		Utility_Functions.timeWait(1);
		driver.switchTo().defaultContent();
		driver.navigate().refresh();
		Utility_Functions.timeWait(3);
		Utility_Functions.xWaitForElementValuePresent(driver, menu_Accounts, 3);
		Utility_Functions.xClick(driver, menu_Accounts, true);
		// Utility_Functions.xClick(driver, recentlyViewed, true);
		// Utility_Functions.timeWait(3);
		List<WebElement> recentlyViewedpropertiesList = driver.findElements(
				By.xpath(".//a[@class='slds-truncate outputLookupLink slds-truncate forceOutputLookup']"));

		Utility_Functions.xclickOnFirstElementfromList(recentlyViewedpropertiesList);
		Utility_Functions.timeWait(3);
		Utility_Functions.xWaitForElementVisible(driver, related_Accounts, 5);
		Utility_Functions.xClick(driver, related_Accounts, true);
		Utility_Functions.xScrollWindow(driver);
		Utility_Functions.timeWait(1);
		Utility_Functions.xScrollWindowTop(driver);
		Utility_Functions.timeWait(2);

		Utility_Functions.xWaitForElementValuePresent(driver, relatedActivities, 5);
		Utility_Functions.xClick(driver, relatedActivities, true);

		List<WebElement> relatedActivitiesList = driver.findElements(
				By.xpath(".//a[@class='slds-truncate outputLookupLink slds-truncate forceOutputLookup'] "));
		for (int i = 0; i < relatedActivitiesList.size(); i++) {
			System.out.println("The new activities are :" + i + relatedActivitiesList.get(i).getText());
		}
		report.updateTestLog("Verify Create Activity Account", "The New Activity for the Accounts is created",
				Status.PASS);

	}

	/**
	 * Validating the New Activity Page Layout in the Accounts
	 * 
	 * @author Ramya
	 *
	 */
	public void verifyNewActivityPageLayout() {

		Utility_Functions.xClick(driver, menu_Accounts, true);
		Utility_Functions.timeWait(3);
		report.updateTestLog("Verify New Activity Page Layout ", "Accounts is Displayed ", Status.PASS);
		Utility_Functions.xWaitForElementValuePresent(driver, recentlyViewed, 3);
		Utility_Functions.xClick(driver, recentlyViewed, true);
		report.updateTestLog("Verify New Activity Page Layout ", "Recently viewed Accounts are Displayed ",
				Status.PASS);
		Utility_Functions.xWaitForElementValuePresent(driver, allAccounts, 3);
		Utility_Functions.xClick(driver, allAccounts, true);
		Utility_Functions.timeWait(3);
		report.updateTestLog("Verify New Activity Page Layout ", "All Accounts are Displayed ", Status.PASS);
		List<WebElement> accountNamesList = driver.findElements(
				By.xpath(".//a[@class='slds-truncate outputLookupLink slds-truncate forceOutputLookup']"));

		Utility_Functions.xclickOnFirstElementfromList(accountNamesList);
		Utility_Functions.timeWait(3);
		report.updateTestLog("Verify New Activity Page Layout ", "The Account is Displayed ", Status.PASS);
		Utility_Functions.xClick(driver, related_Accounts, true);
		Utility_Functions.timeWait(3);
		report.updateTestLog("Verify New Activity Page Layout ", "The related page is Displayed ", Status.PASS);
		Utility_Functions.xScrollWindow(driver);
		Utility_Functions.timeWait(1);
		Utility_Functions.xScrollWindowTop(driver);
		Utility_Functions.timeWait(2);
		Utility_Functions.xWaitForElementValuePresent(driver, newActivity, 3);
		Utility_Functions.xClick(driver, newActivity, true);
		report.updateTestLog("Verify New Activity Page Layout ", "The New Activity in the related page is Displayed ",
				Status.PASS);
		int size = driver.findElements(By.tagName("iframe")).size();
		System.out.println(size);
		Utility_Functions.timeWait(2);
		List<WebElement> iframeList = driver.findElements(By.tagName("iframe"));
		System.out.println(iframeList.size());
		for (WebElement element : iframeList) {
			System.out.println(element.getAttribute("id"));
		}
		driver.switchTo().frame(5);
		Utility_Functions.timeWait(5);
		System.out.println("Frame Identified");
		Utility_Functions.timeWait(5);
		List<WebElement> newActivityPageLayoutSections = driver.findElements(By.xpath("//div[@class='slds-grid']"));
		int countHeader = 0;
		try {
			for (WebElement element : newActivityPageLayoutSections) {
				if ((element.getText().contains("Quick Create"))) {
					System.out.println("Quick Create section is present in the New Activity Layout Page");
					report.updateTestLog("Verify New Activity Page Layout",
							"New Activity Layout Page is having the " + element.getText() + " Status field::",
							Status.PASS);
					countHeader++;

				} else if ((element.getText().contains("System Information"))) {
					System.out.println("System Information section is present in the New Activity Layout Page");
					report.updateTestLog("Verify New Activity Page Layout",
							"New Activity Layout Page is having the " + element.getText() + " Status field::",
							Status.PASS);
					countHeader++;

				} else if ((element.getText().contains("Related To"))) {
					System.out.println(" Related To section is present in the New Activity Layout Page");
					report.updateTestLog("Verify New Activity Page Layout",
							"New Activity Layout Page is having the " + element.getText() + " Status field::",
							Status.PASS);
					countHeader++;

				}
			}
			System.out.println(countHeader);
			if (countHeader != 3) {
				System.out.println(
						"New Activity Page Layout does not contain the Quick Create, System Information and Related To sections");
				report.updateTestLog("Verify New Activity Page Layout",
						"New Activity Layout Page is having all the fields", Status.FAIL);
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
		}

		List<WebElement> newActivityPageLayoutRequiredFields = driver
				.findElements(By.xpath("//label[@class='slds-form-element__label']"));
		int countRequiredFiles = 0;
		try {
			for (WebElement element : newActivityPageLayoutRequiredFields) {
				if ((element.getText().equals("*Subject"))) {
					System.out.println("Subject required field is present in the New Activity Layout Page");
					report.updateTestLog("Verify New Activity Page Layout",
							"New Activity Layout Page is having the " + element.getText() + " Status field::",
							Status.PASS);
					countRequiredFiles++;

				} else if ((element.getText().equals("*Activity Type"))) {
					System.out.println("Activity Type required field is present in the New Activity Layout Page");
					report.updateTestLog("Verify New Activity Page Layout",
							"New Activity Layout Page is having the " + element.getText() + " Status field::",
							Status.PASS);
					countRequiredFiles++;

				} else if ((element.getText().equals("*Assigned To"))) {
					System.out.println(" Assigned To required field is present in the New Activity Layout Page");
					report.updateTestLog("Verify New Activity Page Layout",
							"New Activity Layout Page is having the " + element.getText() + " Status field::",
							Status.PASS);
					countRequiredFiles++;

				} else if ((element.getText().equals("*Status"))) {
					System.out.println(" Status required field is present in the New Activity Layout Page");
					report.updateTestLog("Verify New Activity Page Layout",
							"New Activity Layout Page is having the " + element.getText() + " Status field::",
							Status.PASS);
					countRequiredFiles++;

				} else if ((element.getText().equals("*Priority"))) {
					System.out.println(" Priority required field is present in the New Activity Layout Page");
					report.updateTestLog("Verify New Activity Page Layout",
							"New Activity Layout Page is having the " + element.getText() + " Status field::",
							Status.PASS);
					countRequiredFiles++;

				}

			}
			System.out.println(countRequiredFiles);
			if (countRequiredFiles != 5) {
				System.out.println("New Activity Page Layout does not contain the required fields ");
				report.updateTestLog("Verify New Activity Page Layout",
						"New Activity Layout Page is having all the required fields", Status.FAIL);
			}

		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(e.getMessage());

		}

		if (!driver.findElements(By.xpath("// input [@value= 'Save']")).isEmpty()) {
			System.out.println("Save button is present in the New Activity Layout Page");
			report.updateTestLog("Verify New Activity Page Layout ",
					"The Save Button is present in the New Activity Page", Status.PASS);
		} else {
			System.out.println("Save button is not present in the New Activity Layout Page");
			report.updateTestLog("Verify New Activity Page Layout ",
					"The Save Button is not present in the New Activity Page", Status.FAIL);
		}
		if (!driver.findElements(By.xpath("// input [@value= 'Save & New']")).isEmpty()) {
			System.out.println("Save&New button is present in the New Activity Layout Page");
			report.updateTestLog("Verify New Activity Page Layout ",
					"The Save&New Button is present in the New Activity Page", Status.PASS);
		} else {
			System.out.println("Save&New button is not present in the New Activity Layout Page");
			report.updateTestLog("Verify New Activity Page Layout ",
					"The Save&New Button is not present in the New Activity Page", Status.FAIL);
		}
		if (!driver.findElements(By.xpath("// input [@value= 'Cancel']")).isEmpty()) {
			System.out.println("Cancel button is present in the New Activity Layout Page");
			report.updateTestLog("Verify New Activity Page Layout",
					"The Cancel Button is present in the New Activity Page", Status.PASS);
		} else {
			System.out.println("Cancel button is not present in the New Activity Layout Page");
			report.updateTestLog("Verify New Activity Page Layout",
					"The Cancel Button is not present in the New Activity Page", Status.FAIL);
		}
		List<WebElement> newActivityPageFields = driver
				.findElements(By.xpath("//label[@class='slds-form-element__label']"));
		int count = 0;
		try {
			for (WebElement element : newActivityPageFields) {
				if ((count == 0) && (element.getText().contains("Subject"))) {
					System.out.println("Subject field is present in the New Activity Layout Page");
					report.updateTestLog("Verify New Activity Page Layout",
							"New Activity Layout Page is having the " + element.getText() + " Status field::",
							Status.PASS);
					count++;
				} else if ((count == 1) && (element.getText().contains("Activity Type"))) {
					System.out.println("Activity Type field is present in the New Activity Layout Page");
					report.updateTestLog("Verify New Activity Page Layout",
							"New Activity Layout Page is having the " + element.getText() + " Status field::",
							Status.PASS);
					count++;
				} else if ((count == 2) && (element.getText().contains("DueDate"))) {
					System.out.println("Due Date field is present in the New Activity Layout Page");
					report.updateTestLog("Verify New Activity Page Layout",
							"New Activity Layout Page is having the " + element.getText() + " Status field::",
							Status.PASS);
					count++;
				} else if ((count == 3) && (element.getText().contains("Call Result"))) {
					System.out.println("Call Result field is present in the New Activity Layout Page");
					report.updateTestLog("Verify New Activity Page Layout",
							"New Activity Layout Page is having the " + element.getText() + " Status field::",
							Status.PASS);
					count++;

				} else if ((count == 4) && (element.getText().contains("Comments"))) {
					System.out.println("Comments field is present in the New Activity Layout Page");
					report.updateTestLog("Verify New Activity Page Layout",
							"New Activity Layout Page is having the " + element.getText() + " Status field::",
							Status.PASS);
					count++;
				} else if ((count == 5) && (element.getText().contains("Owner"))) {
					System.out.println("Owner field is present in the New Activity Layout Page");
					report.updateTestLog("Verify New Activity Page Layout",
							"New Activity Layout Page is having the " + element.getText() + " Status field::",
							Status.PASS);
					count++;
				} else if ((count == 6) && (element.getText().contains("Assigned To"))) {
					System.out.println("Assigned To field is present in the New Activity Layout Page");
					report.updateTestLog("Verify New Activity Page Layout",
							"New Activity Layout Page is having the " + element.getText() + " Status field::",
							Status.PASS);
					count++;
				} else if ((count == 7) && (element.getText().contains("Status"))) {
					System.out.println("Status field is present in the New Activity Layout Page");
					report.updateTestLog("Verify New Activity Page Layout",
							"New Activity Layout Page is having the " + element.getText() + " Status field::",
							Status.PASS);
					count++;
				} else if ((count == 8) && (element.getText().contains("Priority"))) {
					System.out.println("Priority field is present in the New Activity Layout Page");
					report.updateTestLog("Verify New Activity Page Layout",
							"New Activity Layout Page is having the " + element.getText() + " Status field::",
							Status.PASS);
					count++;
				} else if ((count == 9) && (element.getText().contains("Account"))) {
					System.out.println("Account field is present in the New Activity Layout Page");
					report.updateTestLog("Verify New Activity Page Layout",
							"New Activity Layout Page is having the " + element.getText() + " Status field::",
							Status.PASS);
					count++;
				} else if ((count == 10) && (element.getText().contains("Contact"))) {
					System.out.println("Contact field is present in the New Activity Layout Page");
					report.updateTestLog("Verify New Activity Page Layout",
							"New Activity Layout Page is having the " + element.getText() + " Status field::",
							Status.PASS);
					count++;

				} else if ((count == 11) && (element.getText().contains("Opportunity"))) {
					System.out.println("Opportunity field is present in the New Activity Layout Page");
					report.updateTestLog("Verify New Activity Page Layout",
							"New Activity Layout Page is having the " + element.getText() + " Status field::",
							Status.PASS);
					count++;
				} else if ((count == 12) && (element.getText().contains("Property"))) {
					System.out.println("Property field is present in the New Activity Layout Page");
					report.updateTestLog("Verify New Activity Page Layout",
							"New Activity Layout Page is having the " + element.getText() + " Status field::",
							Status.PASS);
					count++;
				} else if ((count == 13) && (element.getText().contains("Space"))) {
					System.out.println("Space  field is present in the New Activity Layout Page");
					report.updateTestLog("Verify New Activity Page Layout",
							"New Activity Layout Page is having the " + element.getText() + " Status field::",
							Status.PASS);
					count++;
				} else if ((count == 14) && (element.getText().contains("Comp"))) {
					System.out.println("Comp field is present in the New Activity Layout Page");
					report.updateTestLog("Verify New Activity Page Layout",
							"New Activity Layout Page is having the " + element.getText() + " Status field::",
							Status.PASS);

				}

			}
			System.out.println(count);
			if (count != 14) {
				System.out.println("New Activity Page Layout does not contain all the fields ");
				report.updateTestLog("Verify New Activity Page Layout",
						"New Activity Layout Page is not having all the fields", Status.FAIL);

			}
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
		}

		List<WebElement> newActivityPageCheckFields = driver
				.findElements(By.xpath("//span[@class='slds-form-element__label']"));

		try {
			for (WebElement element : newActivityPageCheckFields) {
				if ((element.getText().contains("Set Reminder"))) {
					System.out.println(
							"Set Reminder field is present in the Create Private Notes Personal Information Page");
					report.updateTestLog("Verify New Activity Page Layout",
							"New Activity Layout Page is having the " + element.getText() + " Status field::",
							Status.PASS);

				} else if ((element.getText().contains("Notification Email"))) {
					System.out.println("Notification Email field is present in the New Activity Layout Page");
					report.updateTestLog("Verify New Activity Page Layout",
							"New Activity Layout Page is having the " + element.getText() + " Status field::",
							Status.PASS);

				} else if ((element.getText().contains("Has Attachment"))) {
					System.out.println("Has Attachment  field is present in the New Activity Layout Page");
					report.updateTestLog("Verify New Activity Page Layout",
							"New Activity Layout Page is having the " + element.getText() + " Status field::",
							Status.PASS);

				} else {
					System.out.println(
							"New Activity Page Layout does not contain the the Set Reminder and Notification Email and Has Attachment Fields");
					report.updateTestLog("Verify New Activity Page Layout",
							"New Activity Layout Page is having the " + element.getText() + " Status field::",
							Status.FAIL);

				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
		}
		try {
			if ((!assignedTo.getText().equals("")) || (!accountSelected.getText().equals(""))
					|| (!priority.getText().equals("")) || (!owner.getText().equals(""))
					|| (!status.getText().equals(""))) {
				System.out.println(
						"Assigned To, Account Selected, Priority, Owner and Status fields are having the values:::");
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
}