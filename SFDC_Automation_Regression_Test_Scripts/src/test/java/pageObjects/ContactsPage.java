package pageObjects;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
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

import pagesAPI.ContactsFunctions;
import pagesAPI.SearchTextSOQL;
import supportLibraries.Utility_Functions;

public class ContactsPage extends ReusableLibrary {
	/*
	 * Constructor to initialize the business component library
	 * 
	 * @param scriptHelper The {@link ScriptHelper} object passed from the
	 * {@link DriverScript}
	 */

	public ContactsPage(ScriptHelper scriptHelper) {
		super(scriptHelper);
		PageFactory.initElements(driver.getWebDriver(), this);
		// new WebDriverUtil(driver);
		// Utility_Functions utility = new Utility_Functions(scriptHelper);
	}

	@FindBy(xpath = "//div[@class='bBottom']//span[text()='Contacts']")
	WebElement menu_Contacts;

	@FindBy(xpath = "//a[@class='tabHeader']//span[text()='Related']")
	WebElement related;

	@FindBy(xpath = "//*[text()='No Next Steps. Open And Upcoming Activities Show Up Here.']")
	WebElement activityTimeline;

	@FindBy(xpath = "//p[@class='slds-tile__title slds-truncate']/a")
	WebElement activity;

	@FindBy(xpath = "//p[@class='slds-tile__title slds-truncate']/a/parent::p/parent::div/parent::div//div[2]")
	WebElement activityType;

	@FindBy(xpath = "//p[@class='slds-tile__title slds-truncate']/a/parent::p/parent::div/parent::div//div[3]")
	WebElement status;

	@FindBy(xpath = "//p[@class='slds-tile__title slds-truncate']/a/parent::p/parent::div/parent::div//div[4]")
	WebElement comments;

	@FindBy(xpath = "//div[@class='slds-media']//p[@class='slds-timeline__date']")
	WebElement dueDate;

	@FindBy(xpath = "//span[@class='slds-checkbox--faux']")
	WebElement statusCheckbox;

	@FindBy(xpath = "//ul[@class='slds-button-group slds-m-left--xx-small oneActionsRibbon forceActionsContainer']//li/a/div[text()='New']")
	WebElement newContact;

	@FindBy(xpath = "//p[@title='Create a Contact']")
	WebElement createContact;

	@FindBy(xpath = "//div[@class='slds-page-header slds-grid slds-grid--align-spread slds-grid--vertical-align-center']//button[text()='Continue']")
	WebElement continueButton;

	@FindBy(xpath = "//*[@id='acctSearchBox']")
	WebElement accountSearch;

	@FindBy(xpath = "//div[@class='tt-dataset-acctSearchBoxTypeahead']//div[1]/p")
	WebElement accountNames;

	@FindBy(xpath = "//div[@class='bBottom']//span[text()='Accounts']")
	WebElement menu_Accounts;

	@FindBy(xpath = "//input[@placeholder='Search Salesforce']")
	WebElement inputAccountName;


	/**
	 * 
	 * 
	 * @author Ramya
	 *
	 */
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

	@FindBy(xpath = "//h1//span[text()='Recently Viewed']")
	WebElement recentlyViewed;

	@FindBy(xpath = "//span[contains(@class,'virtualAutocompleteOptionText')][text()='All Contacts']")
	WebElement allContacts;

	@FindBy(xpath = "//span[contains(@class,'virtualAutocompleteOptionText')][text()='All Accounts']")
	WebElement allAccounts;

	@FindBy(xpath = "//span[contains(@class,'virtualAutocompleteOptionText')][text()='Employee Contacts']")
	WebElement clientContacts;

	@FindBy(xpath = "//span[contains(text(),'Activities')]/ancestor::article//div[text()='New Activity']")
	WebElement newActivity;
	
	@FindBy(xpath = "//div[contains(@class,'slds-page-header')]//div[@title='New Activity'][text()='New Activity']")
	WebElement newActivityHeader;
	
	@FindBy(xpath = "//input[@class='slds-input'][@type='text']")
	WebElement subject;

	@FindBy(xpath = "//select[@class='slds-select']/option[@value='Private - Client Intelligence']")
	WebElement activityType1;

	@FindBy(xpath = "//input [@value='Save & New']")
	WebElement saveAndNewActivity;

	@FindBy(xpath = "//select[@class='slds-select']/option[@value='Private - Initial Meeting']")
	WebElement activityType2;

	@FindBy(xpath = "//input[@value='Save']")
	WebElement saveActivity;

	@FindBy(xpath = "//span[contains(@class, 'slds-text-heading--small slds-truncate') and text() = 'Activities']")
	WebElement relatedActivities;

	@FindBy(xpath = "//a[@title='Show more actions for this record']")
	WebElement selectCreateFollowUpCustomActivity;

	@FindBy(xpath = "//div[contains(@title, 'Create Follow-up Custom Activity')]")
	WebElement createCustomActivity;

	@FindBy(xpath = "//select[@class='slds-select']/option[@value='Private - Follow-Up Meeting']")
	WebElement activityType3;

	@FindBy(xpath="//*[@id='assignedToBox']")
	WebElement assignedTo;

	@FindBy(xpath="//*[@id='relatedAccountBox']")
	WebElement accountSelected;

	@FindBy(xpath="//select[@class='slds-select']/option[@value='Normal']")
	WebElement priority;

	@FindBy(xpath="//div[@class='slds-form-element__control slds-has-divider--bottom']")
	WebElement owner;

	@FindBy(xpath="//select[@class='slds-select']/option[@value='Open']")
	WebElement statusContacts;

	@FindBy(xpath="//input[@class='slds-input'][@type='checkbox']/following-sibling::span[text()='Notification Email']")
	WebElement notificationEmail;

	@FindBy(xpath = "// input [@value= 'Save']")
	WebElement saveNewActivityLayoutPage;

	@FindBy(xpath = "// input [@value= 'Save & New']")
	WebElement saveAndNewActivityLayoutPage;

	@FindBy(xpath = "// input [@value= 'Cancel']")
	WebElement cancelNewActivityLayoutPage;

	@FindBy(xpath="//input[contains(@id, 'contForm:Lastname')]']")
	WebElement lastNameQuickCreateContact;

	@FindBy(xpath="//input[contains(@id,'Firstname')]")
	WebElement firstNameQuickCreate;

	@FindBy(xpath="//input[@id='acctSearchBox']")
	WebElement accountNameQuickCreateContact;


	@FindBy(xpath="//input[contains(@id,'contForm:Phone')]")
	WebElement directLine;

	@FindBy(xpath = "// input [@value= 'Save']")
	WebElement saveContact;

	@FindBy(xpath="//h2[text()='Contact Information']/parent::div/parent::div//div[@class='slds-form-element']/label")
	WebElement contactInformationFields;

	@FindBy(xpath = "//button/span[text()='View All Fields']")
	WebElement viewAllFieldsButton;

	@FindBy(xpath="//input[contains(@id,'contForm:MiddleName')]")
	WebElement middleNameQuickCreate;

	@FindBy(xpath="//input[contains(@id,'contForm:NickName')]")
	WebElement nickNameContact;

	@FindBy(xpath="//input[@class='slds-input'][@type='checkbox']/following-sibling::span[text()='Set Reminder']")
	WebElement setReminder;

	@FindBy(xpath="//input[contains(@id,'dueDate')]")
	WebElement dueDateNewActrivity;

	@FindBy(xpath="//select[@class='slds-select']/option[@value='Private - Follow-Up Task']")
	WebElement activityTypeFollowUpTaskValue;

	@FindBy(xpath="//input[contains(@id,'dueDate')]")
	WebElement newActivityDueDate;

	@FindBy(xpath = "//p[@class='slds-tile__title slds-truncate']/a/parent::p/parent::div/parent::div//div[3]")
	WebElement statusActivityTimeLine;

	@FindBy(xpath="//button[@title='Past Activity']")
	WebElement pastActivity;

	@FindBy(xpath="//button[@title='More Activities']")
	WebElement moreActivities;

	@FindBy(xpath="//a[@class='tabHeader']/span[text()='Activity']")
	WebElement activityTab;
	
	 @FindBy(xpath="//a[@class='tabHeader']//span[text()='Details']")
	 WebElement details;


	SearchTextSOQL searchAccountName = new SearchTextSOQL(scriptHelper);

	/**
	 * Selecting the Contact from a list of contacts
	 * 
	 * @author Vishnuvardhan
	 *
	 */

	public void selectContact() {
		Utility_Functions.timeWait(1);
		Utility_Functions.xClick(driver, menu_Contacts, true);
		Utility_Functions.timeWait(1);
		List<WebElement> accountList = driver
				.findElements(By.xpath("//a[@class='slds-truncate outputLookupLink slds-truncate forceOutputLookup']"));
		Utility_Functions.xclickgetTextofFirstElementfromList(accountList);
		Utility_Functions.timeWait(2);
	}

	/**
	 * Validating the activity Lightning Time line fields
	 * 
	 * @author Vishnuvardhan
	 *
	 */

	public void activityLightningTimeline() {
		/*
		 * tility_Functions.timeWait(1); Utility_Functions.xClick(driver,
		 * menu_Contacts, true); Utility_Functions.timeWait(1); List<WebElement>
		 * accountList = driver.findElements(By.
		 * xpath("//a[@class='slds-truncate outputLookupLink slds-truncate forceOutputLookup']"
		 * ));
		 * Utility_Functions.xclickgetTextofFirstElementfromList(accountList);
		 * Utility_Functions.timeWait(2);
		 */
		selectContact();
		Utility_Functions.xClick(driver, related, true);
		Utility_Functions.timeWait(4);
		int count = 0;
		try {
			if (activityTimeline.isDisplayed()) {
				System.out.println(
						"There are no activities for present, past and future dates in acitivity related list");
				report.updateTestLog("Verify Activity Related List",
						"There are no activities for present, past and future dates in acitivity related list:::",
						Status.PASS);
				count++;
			}
		} catch (Exception e) {
			if (activity.isDisplayed()) {
				System.out.println("Activity is present acitivity related list");
				report.updateTestLog("Verify Activity Related List",
						"Acitivity is present in acitivity related list:::", Status.PASS);
				if (activityType.getText().contains("Activity Type")) {
					System.out.println("Activity Type is present acitivity related list");
					report.updateTestLog("Verify Activity Related List",
							"Acitivity Type is present in acitivity related list:::", Status.PASS);
					count++;
				}
				if (status.getText().contains("Status")) {
					System.out.println("Status is present acitivity related list");
					report.updateTestLog("Verify Activity Related List",
							"Status is present in acitivity related list:::", Status.PASS);
					count++;
				}
				if (comments.getText().contains("Comments")) {
					System.out.println("Comments sections is present acitivity related list");
					report.updateTestLog("Verify Activity Related List",
							"Comments section is present in acitivity related list:::", Status.PASS);
					count++;
				}
				if (dueDate.isDisplayed()) {
					System.out.println("Duedate is present acitivity related list");
					report.updateTestLog("Verify Activity Related List",
							"Duedate is present in acitivity related list:::", Status.PASS);
					count++;
				}
				if (statusCheckbox.isDisplayed()) {
					System.out.println("Status Checkbox is present acitivity related list");
					report.updateTestLog("Verify Activity Related List",
							"Status Checkbox is present in acitivity related list:::", Status.PASS);
				}
			}
			if (count == 4) {
				System.out.println(
						"Activity Type, Due Date, Comments and Status Checkbox are present under acitivity related list");
				report.updateTestLog("Verify Activity Related List",
						"Activity Type, Due Date, Comments and Status Checkbox are present under activity related list:::",
						Status.PASS);
			} else if (count == 1) {
				System.out.println(
						"There are no activities for present, past and future dates in acitivity related list");
			} else {
				System.out.println(
						"Activity Type, Due Date, Comments and Status Checkbox are not present under acitivity related list");
				report.updateTestLog("Verify Activity Related List",
						"Activity Type, Due Date, Comments and Status Checkbox are not present under activity related list:::",
						Status.FAIL);
			}
			e.printStackTrace();
			System.out.println(e.getMessage());
		}

	}

	/**
	 * Validating the Account Lookup detail in New Contact
	 * 
	 * @author Vishnuvardhan
	 *
	 */

	public void accountLookUpNewContactPage() {
		Utility_Functions.timeWait(1);
		Utility_Functions.xClick(driver, menu_Contacts, true);
		Utility_Functions.timeWait(1);
		Utility_Functions.xClick(driver, newContact, true);
		Utility_Functions.timeWait(2);

		//driver.switchTo().frame(driver.findElement(By.xpath("//iframe[contains(@src,'ContactRedirectPage')]")));
		Utility_Functions.xSwitchtoFrame(driver, createContact );

		Utility_Functions.timeWait(1);
		if(!dataTable.getData("General_Data", "TC_ID").contains("Broker")) {
			Utility_Functions.xClick(driver, continueButton, true);
		}
		Utility_Functions.timeWait(2);
		Utility_Functions.xSendKeys(driver, accountSearch, "Test");
		Utility_Functions.xSendKeys(driver, accountSearch, Keys.SPACE);
		Utility_Functions.timeWait(3);
		String accountName = accountNames.getText();
		/*
		 * String accountFirstName = accountName.split(" ")[0]; String
		 * accountSecondName = accountName.split(" ")[1];
		 */
		try {
			if (accountName.contains(" ")) {
				report.updateTestLog("Verify Acccount Name",
						"Account name contains the space between the Account First Name and Account Last Name:::",
						Status.PASS);
			} else {
				report.updateTestLog("Verify Acccount Name",
						"Account name doesn't contain the space between the Account First Name and Account Last Name:::",
						Status.WARNING);
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
		}
	}

	/**
	 * Validating the New Contact Page Layout fields
	 * 
	 * @author Vishnuvardhan
	 *
	 */

	public void newContactPageLayout() {
		ContactsFunctions contactFunctions = new ContactsFunctions(scriptHelper);
		contactFunctions.contactsPageFieldsValidation();
	}
	/**
	 * Validating the Account Lookup detail in New Contact
	 * 
	 * @author Ramya
	 *
	 */

	public void verifyNewNotesAndFileAttachment() {

		Utility_Functions.xWaitForElementPresent(driver, menu_Contacts, 3);
		Utility_Functions.xClick(driver, menu_Contacts, true);
		Utility_Functions.xWaitForElementPresent(driver, recentlyViewed, 3);
		Utility_Functions.xClick(driver, recentlyViewed, true);
		Utility_Functions.xWaitForElementPresent(driver, allContacts, 3);
		Utility_Functions.xClick(driver, allContacts, true);
		Utility_Functions.timeWait(3);

		List<WebElement> contactNamesList = driver.findElements(
				By.xpath(".//a[@class='slds-truncate outputLookupLink slds-truncate forceOutputLookup']"));

		Utility_Functions.xclickOnFirstElementfromList(contactNamesList);
		Utility_Functions.timeWait(3);
		Utility_Functions.xWaitForElementPresent(driver, related, 3);
		Utility_Functions.xClick(driver, related, true);

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
	}
	/**
	 * Validating the Account Lookup detail in New Contact
	 * 
	 * @author Ramya
	 *
	 */
	public void verifyClientContactsNewNotesAndFileAttachment() {

		Utility_Functions.xWaitForElementPresent(driver, menu_Contacts, 3);
		Utility_Functions.xClick(driver, menu_Contacts, true);
		Utility_Functions.xWaitForElementPresent(driver, recentlyViewed, 3);
		Utility_Functions.xClick(driver, recentlyViewed, true);
		Utility_Functions.xWaitForElementPresent(driver, clientContacts, 3);
		Utility_Functions.xClick(driver, clientContacts, true);
		Utility_Functions.timeWait(3);

		List<WebElement> contactNamesList = driver.findElements(
				By.xpath(".//a[@class='slds-truncate outputLookupLink slds-truncate forceOutputLookup']"));

		Utility_Functions.xclickOnFirstElementfromList(contactNamesList);
		Utility_Functions.timeWait(3);
		Utility_Functions.xWaitForElementPresent(driver, related, 3);
		Utility_Functions.xClick(driver, related, true);

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
	}

	/**
	 * Validating the creation of new activity for contacts
	 * 
	 * @author Ramya
	 *
	 */
	public void verifyCreateActivityContact() {

		Utility_Functions.xWaitForElementPresent(driver, menu_Contacts, 3);
		Utility_Functions.xClick(driver, menu_Contacts, true);
		report.updateTestLog("Verify Create Activity Contact ","Contacts is Displayed ",  Status.PASS);
		Utility_Functions.xWaitForElementPresent(driver, recentlyViewed, 3);
		Utility_Functions.xClick(driver, recentlyViewed, true);
		report.updateTestLog("Verify Create Activity Contact ","Recently viewed Contacts are Displayed ",  Status.PASS);
		Utility_Functions.xWaitForElementPresent(driver, allContacts, 3);
		Utility_Functions.xClick(driver, allContacts, true);
		Utility_Functions.timeWait(3);
		report.updateTestLog("Verify Create Activity Contact ","All Contacts are Displayed ",  Status.PASS);
		List<WebElement> contactNamesList = driver.findElements(
				By.xpath(".//a[@class='slds-truncate outputLookupLink slds-truncate forceOutputLookup']"));

		Utility_Functions.xclickOnFirstElementfromList(contactNamesList);
		Utility_Functions.timeWait(3);
		report.updateTestLog("Verify Create Activity Contact ","The Contact is Displayed ",  Status.PASS);
		Utility_Functions.xWaitForElementPresent(driver, related, 3);
		Utility_Functions.xClick(driver, related, true);
		report.updateTestLog("Verify Create Activity Contact ","The related page is Displayed ",  Status.PASS);
		Utility_Functions.xScrollWindow(driver);
		Utility_Functions.timeWait(1);
		Utility_Functions.xScrollWindowTop(driver);
		Utility_Functions.timeWait(2);
		Utility_Functions.xWaitForElementPresent(driver, newActivity, 3);
		Utility_Functions.xClick(driver, newActivity, true);
		report.updateTestLog("Verify Create Activity Contact ","The New Activity in the related page is Displayed ",  Status.PASS);
		/*int size = driver.findElements(By.tagName("iframe")).size();
		System.out.println(size);
		Utility_Functions.timeWait(2);
		List<WebElement> iframeList = driver.findElements(By.tagName("iframe"));
		System.out.println(iframeList.size());
		for (WebElement element : iframeList) {
			System.out.println(element.getAttribute("id"));
		}

		driver.switchTo().frame(4);
		Utility_Functions.timeWait(5);
		System.out.println("Frame Identified");*/
		/*Utility_Functions.timeWait(3);
		List<WebElement> iframeList = driver.findElements(By.tagName("iframe"));

		for (WebElement element : iframeList) {
			driver.switchTo().frame(element);
			try{
				boolean isTextValuePresent  = Utility_Functions.xWaitForElementPresent(driver, subject, 3);
				if(isTextValuePresent){
					break;
				}else{
					driver.switchTo().defaultContent();
				}
			}catch(Exception ex){
				driver.switchTo().defaultContent();
			}

		}*/
		Utility_Functions.xSwitchtoFrame(driver, subject);
		Utility_Functions.xWaitForElementPresent(driver, subject, 5);
		Utility_Functions.xClick(driver, subject, true);
		Utility_Functions.xWaitForElementPresent(driver, subject, 5);
		Utility_Functions.xSendKeys(driver, subject, "test1");
		Utility_Functions.xWaitForElementPresent(driver, activityType1, 5);
		Utility_Functions.xClick(driver, activityType1, true);
		Utility_Functions.xWaitForElementPresent(driver, saveAndNewActivity, 5);
		Utility_Functions.xClick(driver, saveAndNewActivity, true);
		Utility_Functions.timeWait(3);
		report.updateTestLog("Verify Create Activity Contact ","The Activity is saved and New Activity is displayed ",  Status.PASS);
		Utility_Functions.xClick(driver, subject, true);
		Utility_Functions.timeWait(3);
		String value = Utility_Functions.xGenerateAlphaNumericString();

		Utility_Functions.xSendKeys(driver, subject, "Test Activity Created by Automation_" + value);
		Utility_Functions.xWaitForElementPresent(driver, activityType2, 5);
		Utility_Functions.xClick(driver, activityType2, true);
		Utility_Functions.xWaitForElementPresent(driver, saveActivity, 5);
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
		driver.navigate().refresh();


		Utility_Functions.timeWait(3);

		driver.navigate().refresh();
		Utility_Functions.timeWait(1);
		driver.switchTo().defaultContent();
		driver.navigate().refresh();
		Utility_Functions.timeWait(3);
		Utility_Functions.xWaitForElementPresent(driver, selectCreateFollowUpCustomActivity, 5);
		Utility_Functions.xClick(driver,  selectCreateFollowUpCustomActivity, true);

		report.updateTestLog("Verify Create Activity Contact","The Follow up Activity Page is Displayed",  Status.PASS);
		Utility_Functions.xWaitForElementPresent(driver, createCustomActivity, 5);
		//Utility_Functions.xClick(driver, createCustomActivity, true);
		Actions action  = new Actions(driver.getWebDriver());
		action.moveToElement(createCustomActivity);
		action.click();
		action.build().perform();
		Utility_Functions.timeWait(3);

		Utility_Functions.xSwitchtoFrame(driver, subject);
		Utility_Functions.timeWait(3);
		Utility_Functions.xClick(driver, subject, true);
		Utility_Functions.xWaitForElementPresent(driver, subject, 5);
		Utility_Functions.xSendKeys(driver, subject, "test3");
		Utility_Functions.xWaitForElementPresent(driver, activityType3, 5);
		Utility_Functions.xClick(driver, activityType3, true);
		Utility_Functions.xWaitForElementPresent(driver, saveActivity, 5);
		Utility_Functions.xClick(driver, saveActivity, true);
		Utility_Functions.timeWait(3);
		report.updateTestLog("Verify Create Activity Contact ","The Custom Activity is created ",  Status.PASS);
		driver.navigate().refresh();
		Utility_Functions.timeWait(1);
		driver.switchTo().defaultContent();
		driver.navigate().refresh();
		Utility_Functions.timeWait(3);
		Utility_Functions.xWaitForElementPresent(driver,menu_Contacts, 3);
		Utility_Functions.xClick(driver, menu_Contacts, true);
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
				report.updateTestLog("Verify Create Activity Contact","The New Activity for Contacts are created ",Status.PASS);
			}else
			{
				report.updateTestLog("Verify Create Activity Contact","The New Activity for Contacts are not created ",Status.FAIL);
			}
		}

	}
	/**
	 * Validating the New Activity Page Layout in the Contacts
	 * 
	 * @author Ramya
	 *
	 */
	public void verifyContactNewActivityPageLayout() {

		Utility_Functions.xWaitForElementPresent(driver, menu_Contacts, 3);
		Utility_Functions.xClick(driver, menu_Contacts, true);
		report.updateTestLog("Verify New Activity Page Layout ","Contacts is Displayed ",  Status.PASS);
		Utility_Functions.xWaitForElementPresent(driver, recentlyViewed, 3);
		Utility_Functions.xClick(driver, recentlyViewed, true);
		report.updateTestLog("Verify New Activity Page Layout ","Recently viewed Accounts are Displayed ",  Status.PASS);
		Utility_Functions.xWaitForElementPresent(driver, allContacts, 3);
		Utility_Functions.xClick(driver, allContacts, true);
		Utility_Functions.timeWait(3);
		report.updateTestLog("Verify New Activity Page Layout ","All Contacts are Displayed ",  Status.PASS);
		List<WebElement> accountNamesList = driver.findElements(
				By.xpath(".//a[@class='slds-truncate outputLookupLink slds-truncate forceOutputLookup']"));

		Utility_Functions.xclickOnFirstElementfromList(accountNamesList);
		Utility_Functions.timeWait(3);
		report.updateTestLog("Verify New Activity Page Layout ","The Contact is Displayed ",  Status.PASS);
		Utility_Functions.xClick(driver, related, true);
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
			if ((!assignedTo.getText().equals("")) || (!accountSelected.getText().equals(""))||(!priority.getText().equals(""))||(!owner.getText().equals(""))||(!statusContacts.getText().equals(""))) {
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
	 * Validating the New Activity Page send Notification Email to the Assigned Person
	 * 
	 * @author Ramya
	 *
	 */

	public void verifyContactNewActivityPageSendNotificationEmail(){


		Utility_Functions.xWaitForElementPresent(driver, menu_Contacts, 3);
		Utility_Functions.xClick(driver, menu_Contacts, true);

		report.updateTestLog("Verify New Activity Page send Notification Email ","Verifying the Contacts is Displayed ",  Status.PASS);

		List<WebElement> contactNamesList = driver.findElements(
				By.xpath(".//a[@class='slds-truncate outputLookupLink slds-truncate forceOutputLookup']"));

		Utility_Functions.xclickOnFirstElementfromList(contactNamesList);
		report.updateTestLog("Verify New Activity Page send Notification Email ","Verifying the selected Contact is Displayed ",  Status.PASS);
		Utility_Functions.xWaitForElementPresent(driver, related, 3);
		Utility_Functions.xClick(driver, related, true);
		report.updateTestLog("Verify New Activity Page Layout ","Verifying the Contact related page is Displayed ",  Status.PASS);
		Utility_Functions.xScrollWindow(driver);
		Utility_Functions.timeWait(1);
		Utility_Functions.xScrollWindowTop(driver);
		Utility_Functions.timeWait(2);
		Utility_Functions.xWaitForElementPresent(driver, newActivity, 3);
		Utility_Functions.xClick(driver, newActivity, true);
		Utility_Functions.timeWait(3);
		report.updateTestLog("Verify New Activity Page send Notification Email  ","Verifying the New Activity in the Contact related page is Displayed ",  Status.PASS);
		//Utility_Functions.xSwitchtoFrame(driver, subject);
		/*int size = driver.findElements(By.tagName("iframe")).size();
		System.out.println(size);
		Utility_Functions.timeWait(2);
		List<WebElement> iframeList = driver.findElements(By.tagName("iframe"));
		System.out.println(iframeList.size());
		for (WebElement element : iframeList) {
			System.out.println(element.getAttribute("id"));
		}*/
		driver.switchTo().frame(3);
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
	 * Validating the hyperlink for number of Contacts related to Account
	 * 
	 * @author Vishnuvardhan
	 *
	 */	

	public String retriveAccount() {
		String query = "SELECT Id, Total_Number_Of_Contact_Parent_Formula__c FROM Account where Total_Number_Of_Contact_Parent_Formula__c  > 1 limit 1 offset 9";
		//String query = "SELECT Id, Total_Number_Of_Contact_Parent_Formula__c, createddate from Account order by createddate desc";
		String sAccountID = searchAccountName.fetchRecordFieldValue("Id", query);
		report.updateTestLog("Verify Contact hyperlink", "Account ID retrived from database is:::" + sAccountID, Status.PASS);
		String url = driver.getCurrentUrl().split("#")[0];
		String newUrl = url + "#/sObject/" + sAccountID;
		newUrl = newUrl + "/view";
		driver.get(newUrl);
		Utility_Functions.timeWait(1);
		return sAccountID;
	}

	public void validateHyperlinkContacts() {
		Utility_Functions.xWaitForElementPresent(driver, menu_Accounts, 3);
		Utility_Functions.xClick(driver, menu_Accounts, true);		
		Utility_Functions.xWaitForElementPresent(driver, recentlyViewed, 3);
		Utility_Functions.xClick(driver, recentlyViewed, true);
		report.updateTestLog("Verify Create Activity Contact ","Recently viewed Contacts are Displayed ",  Status.PASS);
		Utility_Functions.xWaitForElementPresent(driver, allAccounts, 3);
		Utility_Functions.xClick(driver, allAccounts, true);
		Utility_Functions.timeWait(3);
		report.updateTestLog("Verify Accounts","All Accounts are Displayed ",  Status.PASS);
		List<WebElement> accountList = driver.findElements(By.xpath("//a[@class='slds-truncate outputLookupLink slds-truncate forceOutputLookup']"));
		Utility_Functions.xclickRandomElement(accountList);		
		String accountID = retriveAccount();
		if(accountID==null) {
			report.updateTestLog("Verify Contact hyperlink", "There are no accounts having Contacts:::", Status.PASS);		
		} else {
			driver.navigate().refresh();
			try {
				Utility_Functions.xWaitForElementPresent(driver, related, 3);
				Utility_Functions.xClick(driver, related, true);
				int count=0;
				List<WebElement> contactsList = driver.findElements(By.xpath("//article[contains(@class,'forceRelatedListCardDesktop')]//a[contains(@href,'003')]"));
				for(WebElement element: contactsList) {
					report.updateTestLog("Verify Contact hyperlink", "Contacts associated to this Account are :::" + element.getText(), Status.PASS);
					count++;
				}
				if(count!=0) {
					report.updateTestLog("Verify Contact hyperlink", "Contacts hyperlinks are present in Related section for Account", Status.PASS);		
				} else {
					report.updateTestLog("Verify Contact hyperlink", "Contacts hyperlinks are not present in Related section for Account", Status.FAIL);		
				}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}	
	}
	/**
	 * Validating the New Contact Page by populating the required fields
	 * 
	 * @author Ramya
	 *
	 */
	public void contactsPopulatingTheRequiredFields() {

		Utility_Functions.xWaitForElementPresent(driver, menu_Contacts, 3);
		Utility_Functions.xClick(driver, menu_Contacts, true);
		Utility_Functions.timeWait(1);
		report.updateTestLog("Verify Contact Creation With Required Fields ","Verifying Contacts is Displayed ",  Status.PASS);
		Utility_Functions.xWaitForElementPresent(driver, newContact, 3);
		Utility_Functions.xClick(driver, newContact, true);
		Utility_Functions.timeWait(2);
		report.updateTestLog("Verify Contact Creation With Required Fields ","Verifying New Contacts Page is Displayed  ",  Status.PASS);
		//Utility_Functions.xSwitchtoFrame(driver, driver.findElement(By.xpath("//p[@title='Create a Contact']")));
		Utility_Functions.xSwitchtoFrame(driver, lastNameQuickCreateContact);
		Utility_Functions.timeWait(2);
		Utility_Functions.xWaitForElementPresent(driver, accountNameQuickCreateContact, 5);
		/*Utility_Functions.xSendKeys(driver, accountNameQuickCreateContact, "Barclay's Test");
		accountNameQuickCreateContact.sendKeys(Keys.ARROW_DOWN);
		Utility_Functions.timeWait(2);
		accountNameQuickCreateContact.sendKeys(Keys.ENTER);
		 */
		int value = Utility_Functions.xRandomFunction();		
		String contactName = "Test Automation" + value;

		/*String query = "select Name from Account limit 1 offset 9";
		String accountName = searchAccountName.fetchRecordFieldValue("Name", query);*/		
		Utility_Functions.xSendKeys(driver, accountNameQuickCreateContact, contactName);
		/*accountNameQuickCreateContact.sendKeys(Keys.ARROW_DOWN);
		accountNameQuickCreateContact.sendKeys(Keys.ENTER);
/*		Utility_Functions.xSendKeys(driver, accountNameQuickCreateContact, "Test");
		accountNameQuickCreateContact.sendKeys(Keys.TAB);
		accountNameQuickCreateContact.sendKeys(Keys.ARROW_DOWN);
		//accountNameQuickCreateContact.sendKeys(Keys.ENTER);
		 */		report.updateTestLog("Verify Contact Creation With Required Fields ","Verifying Account name required field is populated ",  Status.PASS);
		 Utility_Functions.xWaitForElementPresent(driver, lastNameQuickCreateContact, 5);
		 Utility_Functions.xSendKeys(driver, lastNameQuickCreateContact, "user");
		 Utility_Functions.xWaitForElementPresent(driver, directLine, 5);
		 Utility_Functions.xSendKeys(driver, directLine, dataTable.getData("General_Data", "Direct Line"));
		 Utility_Functions.xWaitForElementPresent(driver, saveContact, 3);
		 Utility_Functions.xClick(driver, saveContact, true);
		 Utility_Functions.xWaitForElementPresent(driver, related, 3);
		 Utility_Functions.xClick(driver, related, true);
		 Utility_Functions.timeWait(3);

	}
	/**
	 * Validating the New Contact Page layout
	 * 
	 * @author Ramya
	 *
	 */

	static ArrayList<String> contactInformationSectionList = new ArrayList<String>();
	public void contactInformationSectionFields() {
		contactInformationSectionList.add("Middle Name");
		contactInformationSectionList.add("Nickname");
		contactInformationSectionList.add("Department");
		contactInformationSectionList.add("Influence Level");
		contactInformationSectionList.add("Reports To");
		contactInformationSectionList.add("Mobile");
		contactInformationSectionList.add("Main Phone");
		contactInformationSectionList.add("Inactive Contact");
		contactInformationSectionList.add("Contact Record Type");
		System.out.println("Contact Information Section Fields are " + contactInformationSectionList);
	}

	static ArrayList<String> newContactPageSectionsList = new ArrayList<String>();
	public void newContactPageSections() {
		newContactPageSectionsList.add("Contact Information");
		newContactPageSectionsList.add("Communication Preferences");
		newContactPageSectionsList.add("Additional Information");
		newContactPageSectionsList.add("System Information");
		System.out.println("Contact Page Sections are " + newContactPageSectionsList);
	}
	public void newContactPageLayoutFields() {		
		Utility_Functions.xWaitForElementPresent(driver, menu_Contacts, 3);
		Utility_Functions.xClick(driver, menu_Contacts, true);
		Utility_Functions.timeWait(1);
		report.updateTestLog("Verify New Contact Page Fields ","Verifying Contacts is Displayed ",  Status.PASS);
		Utility_Functions.xWaitForElementPresent(driver, newContact, 3);
		Utility_Functions.xClick(driver, newContact, true);
		Utility_Functions.timeWait(2);
		report.updateTestLog("Verify New Contact Page Fields ","Verifying New Contacts Page is Displayed  ",  Status.PASS);
		driver.navigate().refresh();
		Utility_Functions.xSwitchtoFrame(driver, lastNameQuickCreateContact);
		Utility_Functions.timeWait(3);
		System.out.println("Frame Identified");
		Utility_Functions.xScrollWindow(driver);
		Utility_Functions.timeWait(2);
		Utility_Functions.xScrollWindowTop(driver);
		Utility_Functions.timeWait(3);
		Utility_Functions.xWaitForElementPresent(driver, viewAllFieldsButton, 3);
		Utility_Functions.xClick(driver,viewAllFieldsButton, true);
		Utility_Functions.timeWait(2);
		List<WebElement> contactInformationFieldsList = driver.findElements(
				By.xpath("//h2[text()='Contact Information']/parent::div/parent::div//div[@class='slds-form-element']/label"));
		int count = 0, i1 = 0;
		String labelArray[] = new String[contactInformationFieldsList.size()];
		System.out.println(contactInformationFieldsList.size());

		try {
			contactInformationSectionFields();
			for (WebElement element : contactInformationFieldsList) {
				System.out.println(element.getText());
				labelArray[i1] = element.getText();
				if (labelArray[i1].equalsIgnoreCase(contactInformationSectionList.get(i1))) {
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
		List<WebElement> contactPageSectionsList = driver.findElements(
				By.xpath("//div[contains(@class,'slds-col--padded')]/h2"));
		int count1 = 0, i2 = 0;
		String labelArray1[] = new String[contactPageSectionsList.size()];
		System.out.println(contactPageSectionsList.size());

		try {
			newContactPageSections();
			for (WebElement element1 : contactPageSectionsList) {
				System.out.println(element1.getText());
				labelArray1[i2] = element1.getText();
				if (labelArray[i2].equalsIgnoreCase(newContactPageSectionsList.get(i2))) {
					report.updateTestLog("Verify Private Tags Page",
							"Bulk Tagging Page Account Details is having the " + labelArray[i2] + " section ",
							Status.PASS);
					count1++;
				}
				i2++;
			}
			System.out.println(count1);
			if (count1 != 4) {
				report.updateTestLog("Verify Private Tags Page",
						"All Labels are not present in the Bulk Tagging Page Account Details", Status.FAIL);
			} else {

				report.updateTestLog("Verify Private Tags Page",
						"All Labels are present in the Bulk Tagging Page Account Details", Status.PASS);
			}

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		Utility_Functions.xWaitForElementPresent(driver, firstNameQuickCreate, 5);
		Utility_Functions.xSendKeys(driver, firstNameQuickCreate, "Ema");
		Utility_Functions.xWaitForElementPresent(driver, lastNameQuickCreateContact, 5);
		Utility_Functions.xSendKeys(driver, lastNameQuickCreateContact, "Watson");
		/*Utility_Functions.xWaitForElementPresent(driver, middleNameQuickCreate, 5);
		Utility_Functions.xSendKeys(driver,middleNameQuickCreate , "S");
		Utility_Functions.xWaitForElementPresent(driver, nickNameContact, 5);
		Utility_Functions.xSendKeys(driver,nickNameContact , "Emi");*/
	}

	/**
	 * Validating the contacts Activity reminder functionality
	 * 
	 * @author Ramya
	 *
	 */
	public void verifyContactActivityReminderSentFunctionality() {
		Utility_Functions.xWaitForElementPresent(driver, menu_Contacts, 3);
		Utility_Functions.xClick(driver, menu_Contacts, true);
		report.updateTestLog("Verify Contact Activity Reminder Functionality ","Contacts is Displayed ",  Status.PASS);
		Utility_Functions.xWaitForElementPresent(driver, recentlyViewed, 3);
		Utility_Functions.xClick(driver, recentlyViewed, true);
		report.updateTestLog("Verify Contact Activity Reminder Functionality  ","Recently viewed Contacts are Displayed ",  Status.PASS);
		Utility_Functions.xWaitForElementPresent(driver, allContacts, 3);
		Utility_Functions.xClick(driver, allContacts, true);
		Utility_Functions.timeWait(3);
		report.updateTestLog("Verify Contact Activity Reminder Functionality  ","All Contacts are Displayed ",  Status.PASS);
		List<WebElement> contactNamesList = driver.findElements(By.xpath(".//a[@class='slds-truncate outputLookupLink slds-truncate forceOutputLookup']"));
		Utility_Functions.xclickRandomElement(contactNamesList);
		Utility_Functions.timeWait(3);
		report.updateTestLog("Verify Contact Activity Reminder Functionality ","The Contact is Displayed ",  Status.PASS);
		Utility_Functions.xWaitForElementPresent(driver, related, 3);
		Utility_Functions.xClick(driver, related, true);
		report.updateTestLog("Verify Contact Activity Reminder Functionality ","The related page is Displayed ",  Status.PASS);
		Utility_Functions.xScrollWindow(driver);
		Utility_Functions.timeWait(1);
		Utility_Functions.xScrollWindowTop(driver);
		Utility_Functions.timeWait(2);
		Utility_Functions.xWaitForElementPresent(driver, newActivity, 3);
		Utility_Functions.xClick(driver, newActivity, true);
		report.updateTestLog("Verify Contact Activity Reminder Functionality ","The New Activity in the related page is Displayed ",  Status.PASS);
		Utility_Functions.timeWait(2);
		Utility_Functions.xSwitchtoFrame(driver, subject);
		Utility_Functions.timeWait(3);
		List<WebElement> newActivityPageLayoutRequiredFields = driver.findElements(By.xpath("//label[@class='slds-form-element__label']"));
		int countRequiredFiles =0;
		try {
			for (WebElement element : newActivityPageLayoutRequiredFields  ) {
				if ((element.getText().equals("*Subject"))) {
					System.out.println("Subject required field is present in the New Activity Layout Page");
					report.updateTestLog("Verify Contact Activity Reminder Functionality",
							"New Activity Layout Page is having the " + element.getText()
							+ " Status field::",
							Status.PASS);
					countRequiredFiles++;

				} else if ((element.getText().equals("*Activity Type"))) {
					System.out.println("Activity Type required field is present in the New Activity Layout Page");
					report.updateTestLog("Verify Contact Activity Reminder Functionality",
							"New Activity Layout Page is having the " + element.getText()
							+ " Status field::",
							Status.PASS);
					countRequiredFiles++;

				} else if ((element.getText().equals("*Assigned To"))) {
					System.out.println(" Assigned To required field is present in the New Activity Layout Page");
					report.updateTestLog("Verify Contact Activity Reminder Functionality",
							"New Activity Layout Page is having the " + element.getText()
							+ " Status field::",
							Status.PASS);
					countRequiredFiles++;


				} else if ((element.getText().equals("*Status"))) {
					System.out.println(" Status required field is present in the New Activity Layout Page");
					report.updateTestLog("Verify Contact Activity Reminder Functionality",
							"New Activity Layout Page is having the " + element.getText()
							+ " Status field::",
							Status.PASS);
					countRequiredFiles++;

				}
				else if ((element.getText().equals("*Priority"))) {
					System.out.println(" Priority required field is present in the New Activity Layout Page");
					report.updateTestLog("Verify Contact Activity Reminder Functionality",
							"New Activity Layout Page is having the " + element.getText()
							+ " Status field::",
							Status.PASS);
				}
			} 
			System.out.println(countRequiredFiles);
			if(countRequiredFiles!=4) {
				System.out.println("New Activity Page Layout does not contain the required fields ");
				report.updateTestLog("Verify Contact Activity Reminder Functionality",
						"New Activity Layout Page is having all the required fields",
						Status.FAIL);
			}

		}catch (Exception e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
		}
		Utility_Functions.xWaitForElementPresent(driver, subject, 5);
		Utility_Functions.xClick(driver, subject, true);
		Utility_Functions.xWaitForElementPresent(driver, subject, 5);
		Utility_Functions.xSendKeys(driver, subject, "test1");
		Utility_Functions.xWaitForElementPresent(driver, activityType1, 5);
		Utility_Functions.xClick(driver, activityType1, true);
		if(!setReminder.isSelected()){
			Utility_Functions.xClick(driver,setReminder, true);
			System.out.println("Set Reminder is checked");
			report.updateTestLog("Verify Contact Activity Reminder Functionality ","Verifying the Reminder sent check box is checked or else checking it",  Status.PASS);
		} else {
			System.out.println("Set Reminder is not checked");
			report.updateTestLog("Verify Contact Activity Reminder Functionality ","Verifying the Reminder sent  check box is checked or not ",  Status.FAIL);
		}
		Utility_Functions.timeWait(2);
		Calendar calendar1 = Calendar.getInstance();
		calendar1.add(Calendar.DAY_OF_MONTH, 10);
		SimpleDateFormat dateFormat1 = new SimpleDateFormat("MM/dd/yyyy hh:mm a");
		System.out.println("Date : " + dateFormat1.format(calendar1.getTime())); 
		Utility_Functions.xWaitForElementPresent(driver,dueDateNewActrivity, 3);
		Utility_Functions.xSendKeys(driver,dueDateNewActrivity, dateFormat1.format(calendar1.getTime()));
		Utility_Functions.xWaitForElementPresent(driver, saveActivity, 5);
		Utility_Functions.xClick(driver, saveActivity, true);
		Utility_Functions.timeWait(3);
		if(details.isDisplayed()) {
			
			report.updateTestLog("Verify Contact Activity Reminder Functionality", "Contacts Details page is displayed", Status.PASS);
		} else {
			report.updateTestLog("Verify Contact Activity Reminder Functionality", "Contacts Details page is not displayed", Status.FAIL);
		}
		
	}
	/**
	 * Validating the Contacts Landing Page 
	 * 
	 * @author Ramya
	 *
	 */	

	static ArrayList<String> contactInformationSectionFieldsList = new ArrayList<String>();
	public void contactInformationDetailsPageFields() {
		contactInformationSectionFieldsList.add("Name ");
		contactInformationSectionFieldsList.add("Account Name");
		contactInformationSectionFieldsList.add("Middle Name");
		contactInformationSectionFieldsList.add("Direct Line");
		contactInformationSectionFieldsList.add("Title");
		contactInformationSectionFieldsList.add("Main Phone");
		contactInformationSectionFieldsList.add("Created By Country");
		contactInformationSectionFieldsList.add("Email");
		contactInformationSectionFieldsList.add("Last updated by Country");
		contactInformationSectionFieldsList.add("Status");
		contactInformationSectionFieldsList.add("Contact Record Type");
		System.out.println("Contact Information fields are " + contactInformationSectionFieldsList);
	}

	static ArrayList<String> addressInformationSectionFieldsList = new ArrayList<String>();
	public void addressInformationFields() {
		addressInformationSectionFieldsList.add("Address");
		System.out.println("Address Information section fields are " +addressInformationSectionFieldsList );
	}

	static ArrayList<String> customLinksSectionFieldsList = new ArrayList<String>();
	public void customLinksFields() {
		customLinksSectionFieldsList.add("LinkedIn");
		customLinksSectionFieldsList.add("Google Maps");
		customLinksSectionFieldsList.add("Google Search");
		System.out.println("Custom Links fields are " +customLinksSectionFieldsList);
	}
	static ArrayList<String> additionalInformationFieldsList = new ArrayList<String>();
	public void additionalInformationFields() {
		additionalInformationFieldsList.add("Integration Id");
		additionalInformationFieldsList.add("Inactive Date");
		additionalInformationFieldsList.add("Preferred Comm Method");
		additionalInformationFieldsList.add("Employee?");
		additionalInformationFieldsList.add("Comm Email Sent");
		additionalInformationFieldsList.add("Source Created Date Time");
		additionalInformationFieldsList.add("Reason for Inactivating");
		additionalInformationFieldsList.add("Source Last Updated Date Time");
		additionalInformationFieldsList.add("Inactivation Date");
		System.out.println("Additional Information fields are " +additionalInformationFieldsList);
	}

	static ArrayList<String> systemInformationFieldsList = new ArrayList<String>();
	public void systemInformationFields() {
		systemInformationFieldsList.add("Contact Owner");
		systemInformationFieldsList.add("Last Manually Modified Date");
		systemInformationFieldsList.add("Created By");
		systemInformationFieldsList.add("Last Manually Modified By");
		System.out.println("System Information fields are " +systemInformationFieldsList);
	}

	static ArrayList<String> contactsDeatilsPageHeadersList = new ArrayList<String>();
	public void contactsDetailsPageHeaders() {
		contactsDeatilsPageHeadersList.add("Tagging");
		contactsDeatilsPageHeadersList.add("Contact Information");
		contactsDeatilsPageHeadersList.add("Address Information");
		contactsDeatilsPageHeadersList.add("Additional Information");
		contactsDeatilsPageHeadersList.add("Custom Links");
		contactsDeatilsPageHeadersList.add("System Information");
		System.out.println("Contact Details Page headers are:: " +contactsDeatilsPageHeadersList);
	}

	public void contactsVerifyLandingPage() {
		Utility_Functions.xWaitForElementPresent(driver, menu_Contacts, 3);
		Utility_Functions.xClick(driver, menu_Contacts, true);
		Utility_Functions.xWaitForElementPresent(driver, recentlyViewed, 3);
		Utility_Functions.xClick(driver, recentlyViewed, true);
		Utility_Functions.xWaitForElementPresent(driver, allContacts, 3);
		Utility_Functions.xClick(driver, allContacts, true);
		Utility_Functions.timeWait(3);
		List<WebElement> contactNamesList = driver.findElements(By.xpath(".//a[@class='slds-truncate outputLookupLink slds-truncate forceOutputLookup']"));
		Utility_Functions.xclickOnFirstElementfromList(contactNamesList);
		Utility_Functions.timeWait(3);
		Utility_Functions.xScrollWindow(driver);
		Utility_Functions.timeWait(1);
		Utility_Functions.xScrollWindowTop(driver);
		Utility_Functions.timeWait(2);
		List<WebElement> contactDetailsPageHeadersList = driver.findElements(By.xpath("//span[contains(@class,'header-title')]"));
		int count0 = 0, i0 = 0, j0=0;;
		String fieldsArray0[] = new String[contactDetailsPageHeadersList.size()];
		System.out.println(contactDetailsPageHeadersList.size());
		try {
			contactsDetailsPageHeaders();
			while(j0<contactDetailsPageHeadersList.size()) {
				for (WebElement element0 :contactDetailsPageHeadersList) {
					fieldsArray0[i0] = element0.getText();
					if (fieldsArray0[i0].contains(contactsDeatilsPageHeadersList.get(j0))){
						System.out.println("Contacts Details page headers are " + element0.getText());
						report.updateTestLog("Verify Contacts Landing Page",
								" Contact Details Page are having the " + fieldsArray0[i0] + " Headers ",
								Status.PASS);
						count0++;
					}
					i0++;
				}
				i0=0;
				j0++;
			}
			System.out.println(count0);
			if (count0 != 6) {
				report.updateTestLog("Verify Contacts Landing Page", "All sections are not present in the Contacts Details Page", Status.FAIL);
			} else {

				report.updateTestLog("Verify Leads Landing Page", "All sections are present in the Contacts Details Page", Status.PASS);
			}

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		contactDetailsPageHeadersList.clear();
		List<WebElement> contactInformationFieldsList = driver.findElements(By.xpath("//h3//span[text()='Contact Information']/ancestor::h3/parent::div/div[1]//span[contains(@class,'test-id__field-label')and text()!='']"));
		int count = 0, i = 0, j4=0;
		String fieldsArray[] = new String[contactInformationFieldsList.size()];
		System.out.println(contactInformationFieldsList.size());
		try {
			contactInformationDetailsPageFields();
			while(j4<contactInformationFieldsList.size()) {
				for (WebElement element :contactInformationFieldsList) {
					fieldsArray[i] = element.getText();
					if (fieldsArray[i].contains(contactInformationSectionFieldsList.get(j4))){
						System.out.println("Contact Information fields are " + element.getText());
						report.updateTestLog("Verify Contacts Landing Page",
								" Contact Information section is having the " + fieldsArray[i] + " fields ",
								Status.PASS);
						count++;
					}
					i++;
				}
				i=0;
				j4++;
			}
			System.out.println(count);
			if (count!= 10) {
				report.updateTestLog("Verify Contacts Landing Page", "All fields are not present in the Contact Information Section", Status.FAIL);
			} else {

				report.updateTestLog("Verify Contacts Landing Page", "All fields are present in the Contact Information Section", Status.PASS);
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		contactInformationFieldsList.clear();
		List<WebElement> addressInformationFieldsList = driver.findElements(By.xpath("//h3//span[text()='Address Information']/ancestor::h3/parent::div/div[1]//span[contains(@class,'test-id__field-label')and text()!='']"));
		int count1 = 0, i1 = 0, j3=0;
		String fieldsArray1[] = new String[addressInformationFieldsList.size()];
		System.out.println(addressInformationFieldsList.size());
		try {
			addressInformationFields();
			while(j3<addressInformationFieldsList.size()) {
				for (WebElement element1 :addressInformationFieldsList) {
					fieldsArray1[i1] = element1.getText();
					if (fieldsArray1[i1].contains(addressInformationSectionFieldsList.get(j3))){
						System.out.println("Address Information fields are " + element1.getText());
						report.updateTestLog("Verify Contacts Landing Page",
								" Address Information Section is having the " + fieldsArray1[i1] + " fields ",
								Status.PASS);
						count1++;
					}
					i1++;
				}
				i1=0;
				j3++;
			}
			System.out.println(count1);
			if (count1!= 1) {
				report.updateTestLog("Verify Contacts Landing Page", "All fields are not present in the Address Information Section", Status.FAIL);
			} else {

				report.updateTestLog("Verify Contacts Landing Page", "All fields are present in the Address Information Section", Status.PASS);
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		addressInformationFieldsList.clear();
		List<WebElement> additionalInformationList = driver.findElements(By.xpath("//h3//span[text()='Additional Information']/ancestor::h3/parent::div/div[1]//span[contains(@class,'test-id__field-label')and text()!='']"));
		int count5 = 0, i5 = 0,j=0;
		String fieldsArray5[] = new String[additionalInformationList.size()];
		System.out.println(additionalInformationList.size());
		try {
			additionalInformationFields();
			while(j<additionalInformationList.size()) {
				for (WebElement element5 : additionalInformationList) {
					fieldsArray5[i5] = element5.getText();
					if (fieldsArray5[i5].contains(additionalInformationFieldsList.get(j))) {
						System.out.println("Additional Information fields are " + element5.getText());
						report.updateTestLog("Verify Contacts Landing Page", element5.getText() + "labels  present in the Additional Information section ", Status.PASS);
						count5++;
					}
					i5++;
				}
				i5=0;
				j++;
			}
			System.out.println(count5);
			if (count5!= 9) {
				report.updateTestLog("Verify Contacts Landing Page", "All fields are not present in the Additional Information section", Status.FAIL);
			} else {
				report.updateTestLog("Verify Contacts Landing Page", "All fields are present in the Additional Information section", Status.PASS);
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		additionalInformationList.clear();
		List<WebElement> systemInformationList = driver.findElements(By.xpath("//h3//span[text()='System Information']/ancestor::h3/parent::div/div[1]//span[contains(@class,'test-id__field-label')and text()!='']"));
		int count6 = 0, i6 = 0,j2=0;
		String fieldsArray6[] = new String[systemInformationList.size()];
		System.out.println(systemInformationList.size());
		try {
			systemInformationFields();
			while(j2<systemInformationList.size()) {
				for (WebElement element6 :systemInformationList) {
					fieldsArray6[i6] = element6.getText();
					if (fieldsArray6[i6].contains( systemInformationFieldsList .get(j2))) {
						System.out.println("System Information fields are " + element6.getText());
						report.updateTestLog("Verify Contacts Landing Page", element6.getText() + "labels  present in the System Information section ", Status.PASS);
						count6++;
					}
					i6++;
				}
				i6=0;
				j2++;
			}
			System.out.println(count6);
			if (count6!= 4) {
				report.updateTestLog("Verify Contacts Landing Page", "All fields are not present in the Contact Information section", Status.FAIL);
			} else {
				report.updateTestLog("Verify Contacts Landing Page", "All fields are present in the Contact Information section", Status.PASS);
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		systemInformationList.clear();
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
						report.updateTestLog("Verify Contacts Landing Page ", element7.getText() + "labels  present in the Custom Links ", Status.PASS);
						count7++;
					}
					i7++;
				}
				i7=0;
				j1++;
			}
			System.out.println(count7);
			if (count7 != 3) {
				report.updateTestLog("Verify Contacts Landing Page", "All fields are not present in the Custom Links section", Status.FAIL);
			} else {
				report.updateTestLog("Verify Contacts Landing Page", "All fields are present in the Custom Links section", Status.PASS);
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		customLinksList.clear();
	}

	/**
	 * Validating the creation of SPOCs in the Accounts
	 * @author Ramya
	 *
	 */
	public void verifyContactsActivityTimeline() {

		Utility_Functions.xWaitForElementPresent(driver, menu_Contacts, 3);
		Utility_Functions.xClick(driver, menu_Contacts, true);
		report.updateTestLog("Verify Contact Activity Timeline ","Contacts is Displayed ",  Status.PASS);
		Utility_Functions.xWaitForElementPresent(driver, recentlyViewed, 3);
		Utility_Functions.xClick(driver, recentlyViewed, true);
		report.updateTestLog("Verify Contact Activity Timeline ","Recently viewed Contacts are Displayed ",  Status.PASS);
		Utility_Functions.xWaitForElementPresent(driver, allContacts, 3);
		Utility_Functions.xClick(driver, allContacts, true);
		Utility_Functions.timeWait(3);
		report.updateTestLog("Verify Contact Activity Timeline","All Contacts are Displayed ",  Status.PASS);
		List<WebElement> contactNamesList = driver.findElements(
				By.xpath(".//a[@class='slds-truncate outputLookupLink slds-truncate forceOutputLookup']"));

		Utility_Functions.xclickOnFirstElementfromList(contactNamesList);
		Utility_Functions.timeWait(3);
		report.updateTestLog("Verify Contact Activity Timeline ","The Contact is Displayed ",  Status.PASS);
		Utility_Functions.xWaitForElementPresent(driver, related, 3);
		Utility_Functions.xClick(driver, related, true);
		report.updateTestLog("Verify Contact Activity Timeline ","The related page is Displayed ",  Status.PASS);
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
		report.updateTestLog("Verify Contact Activity Timeline","The New Activity in the related page is Displayed ",  Status.PASS);
		Utility_Functions.timeWait(1);
		Utility_Functions.xSwitchtoFrame(driver, saveAndNewActivity);
		Utility_Functions.timeWait(4);
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
		report.updateTestLog("Verify Contact Activity Timeline ","The Account is Displayed ",  Status.PASS);
		Utility_Functions.xClick(driver, related, true);
		Utility_Functions.timeWait(2);
		report.updateTestLog("Verify Contact Activity Timeline","The related page is Displayed ",  Status.PASS);
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
		report.updateTestLog("Verify Contact Activity Timeline","The New Activity in the related page is Displayed ",  Status.PASS);
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
			//System.out.println(e.getMessage());
		}			
		try {
			Utility_Functions.xWaitForElementPresent(driver,pastActivity, 5);
			Utility_Functions.xClick(driver, pastActivity, true);
			report.updateTestLog("Verify Contact Activity Timeline","The Past Activities is Clicked successfully",Status.PASS);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		Utility_Functions.xWaitForElementPresent(driver,moreActivities, 5);
		Utility_Functions.xClick(driver, moreActivities, true);
		report.updateTestLog("Verify Contact Activity Timeline","The More Activities is Clicked successfully",Status.PASS);
	}
}
