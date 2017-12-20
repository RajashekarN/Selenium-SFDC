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

	@FindBy(xpath = "//input[@title='Search Accounts']")
	WebElement accountSearch;

	@FindBy(xpath = "//span[@class='pillText']")
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

	@FindBy(xpath = "//a[contains(@title,'Show') and contains(@title,'more action')]")
	WebElement selectCreateFollowUpCustomActivity;

	@FindBy(xpath = "//div[contains(@title, 'Create Follow-up Custom Activity')]")
	WebElement createCustomActivity;

	@FindBy(xpath = "//select[@class='slds-select']/option[@value='Private - Follow-Up Meeting']")
	WebElement activityType3;

	@FindBy(xpath = "//*[@id='assignedToBox']")
	WebElement assignedTo;

	@FindBy(xpath = "//*[@id='relatedAccountBox']")
	WebElement accountSelected;

	@FindBy(xpath = "//select[@class='slds-select']/option[@value='Normal']")
	WebElement priority;

	@FindBy(xpath = "//div[@class='slds-form-element__control slds-has-divider--bottom']")
	WebElement owner;

	@FindBy(xpath = "//select[@class='slds-select']/option[@value='Open']")
	WebElement statusContacts;

	@FindBy(xpath = "//input[@class='slds-input'][@type='checkbox']/following-sibling::span[text()='Notification Email']")
	WebElement notificationEmail;

	@FindBy(xpath = "// input [@value= 'Save']")
	WebElement saveNewActivityLayoutPage;

	@FindBy(xpath = "// input [@value= 'Save & New']")
	WebElement saveAndNewActivityLayoutPage;

	@FindBy(xpath = "// input [@value= 'Cancel']")
	WebElement cancelNewActivityLayoutPage;

	@FindBy(xpath = "//input[@placeholder='Last Name']")
	WebElement lastNameQuickCreateContact;

	@FindBy(xpath = "//input[contains(@id,'Firstname')]")
	WebElement firstNameQuickCreate;

	@FindBy(xpath = "//input[@id='acctSearchBox']")
	WebElement accountNameQuickCreateContact;

	@FindBy(xpath = "//input[contains(@id,'contForm:Phone')]")
	WebElement directLine;

	@FindBy(xpath = "// input [@value= 'Save']")
	WebElement saveContact;

	@FindBy(xpath = "//h2[text()='Contact Information']/parent::div/parent::div//div[@class='slds-form-element']/label")
	WebElement contactInformationFields;

	@FindBy(xpath = "//button/span[text()='View All Fields']")
	WebElement viewAllFieldsButton;

	@FindBy(xpath = "//input[contains(@id,'contForm:MiddleName')]")
	WebElement middleNameQuickCreate;

	@FindBy(xpath = "//input[contains(@id,'contForm:NickName')]")
	WebElement nickNameContact;

	@FindBy(xpath = "//input[@class='slds-input'][@type='checkbox']/following-sibling::span[text()='Set Reminder']")
	WebElement setReminder;

	@FindBy(xpath = "//input[contains(@id,'dueDate')]")
	WebElement dueDateNewActrivity;

	@FindBy(xpath = "//select[@class='slds-select']/option[@value='Private - Follow-Up Task']")
	WebElement activityTypeFollowUpTaskValue;

	@FindBy(xpath = "//input[contains(@id,'dueDate')]")
	WebElement newActivityDueDate;

	@FindBy(xpath = "//p[@class='slds-tile__title slds-truncate']/a/parent::p/parent::div/parent::div//div[3]")
	WebElement statusActivityTimeLine;

	@FindBy(xpath = "//button[@title='Past Activity']")
	WebElement pastActivity;

	@FindBy(xpath = "//button[@title='More Activities']")
	WebElement moreActivities;

	@FindBy(xpath = "//a[@class='tabHeader']/span[text()='Activity']")
	WebElement activityTab;

	@FindBy(xpath = "//a[@class='tabHeader']//span[text()='Details']")
	WebElement details;

	@FindBy(xpath = "//ul[contains(@class,'oneActionsRibbon') and contains(@class,'forceActionsContainer')]//a[@class='forceActionLink']/div[text()='Edit']")
	WebElement edit;

	@FindBy(xpath = "//ul[contains(@class,'scrollable')]//li/a[@title='Edit']")
	WebElement showMoreActionsEdit;

	@FindBy(xpath = "//input[@placeholder='First Name']")
	WebElement firstNameEditPage;

	@FindBy(xpath = "//input[@placeholder='Last Name']")
	WebElement lastNameEditPage;

	@FindBy(xpath = "//input[@type='tel']")
	WebElement directLineEditPage;

	@FindBy(xpath = "//div[contains(@class,'forceModalActionContainer--footerAction')]/button[@title='Save']")
	WebElement saveEditPage;

	@FindBy(xpath = "//li[contains(@class,'oneActionsDropDown')]//a")
	WebElement showMoreActionsDetailsPage;

	@FindBy(xpath = "//div[@class='forceActionLink'][text()='Edit']")
	WebElement showMoreActionsEditPage;

	@FindBy(xpath = "//input[@type='email']")
	WebElement emailEditPage;

	@FindBy(xpath = "//input[@placeholder='First Name']")
	WebElement firstNameNewContactPage;	

	@FindBy(xpath = "//input[@placeholder='Last Name']")
	WebElement LastNameNewContactPage;

	@FindBy(xpath = "//input[contains(@id,'MiddleName')]")
	WebElement middleNameNewContactPage;

	@FindBy(xpath = "//input[contains(@id,'NickName')]")
	WebElement nickNameNewContactpage;

	@FindBy(xpath = "//input[contains(@id,'Tile')]")
	WebElement titleNewContactPage;

	@FindBy(xpath = "//input[contains(@id,'Department')]")
	WebElement departmentNewContactPage;

	@FindBy(xpath = "//select[contains(@id,'Influence_Level__c')]")
	WebElement influenceLevelPickList;

	@FindBy(xpath = "//select[contains(@id,'Influence_Level__c')]/option[@value='Low']")
	WebElement influenceLevelPickListValue;

	@FindBy(xpath = "//input[@id='reportsToBox']")
	WebElement reportsToNewContactPage;

	@FindBy(xpath = "//input[contains(@id,'Phone')]")
	WebElement directLineNewContactPage;

	@FindBy(xpath = "//input[contains(@id,'contForm:Email')]")
	WebElement emailNewContactPage;

	@FindBy(xpath = "//select[contains(@id,'statusPicklist')]")
	WebElement statusPickListNewContactPage;

	@FindBy(xpath = "//select[contains(@id,'statusPicklist')]/option[@value='Active']")
	WebElement statusPickListValueNewContactPage;

	@FindBy(xpath = "//textarea[contains(@id,'MailingStreet')]")
	WebElement streetNewContactPage;

	@FindBy(xpath = "//input[contains(@id,'MailingCity')]")
	WebElement cityNewContactPage;

	@FindBy(xpath = "//select[contains(@id,'countryMailingPicklist')]")
	WebElement countryNewContactpage;

	@FindBy(xpath = "//select[contains(@id,'countryMailingPicklist')]/option[@value='US']")
	WebElement countryValueNewContactPage;

	@FindBy(xpath = "//select[contains(@id,'stateMailingPicklist')]")
	WebElement stateNewContactPage;

	@FindBy(xpath = "//select[contains(@id,'stateMailingPicklist')]/option[@value='TX']")
	WebElement stateValueNewContactPage;

	@FindBy(xpath = "//input[contains(@id,'MailingPostalCode')]")
	WebElement zipcodeNewContactPage;

	@FindBy(xpath = "//input[contains(@id,'MobilePhone')]")
	WebElement mobilePhoneNewContactpage;

	@FindBy(xpath = "//input[contains(@id,'Main_Phone__c')]")
	WebElement mainPhoneNewContactPage;

	@FindBy(xpath = "//input[@id='inactivecontactBox']")
	WebElement inactiveContactBox;

	@FindBy(xpath = "//select[contains(@id,'Email_Options__c')]")
	WebElement emailOptionsNewContactPage;

	@FindBy(xpath = "//select[contains(@id,'Email_Options__c')]/option[@value='Email Opt In']")
	WebElement emailOptionsValueNewContactPage;

	@FindBy(xpath = "//select[contains(@id,'Mail_Options__c')]")
	WebElement mailOptionsNewContactPage;

	@FindBy(xpath = "//select[contains(@id,'Mail_Options__c')]/option[@value='Mail Opt In']")
	WebElement mailOptionsValueNewContactPage;

	@FindBy(xpath = "//select[contains(@id,'Call_Options__c')]")
	WebElement callOptionsNewContactPage;

	@FindBy(xpath = "//select[contains(@id,'Call_Options__c')]/option[@value='Call Opt In']")
	WebElement callOptionsValueNewContactPage;

	@FindBy(xpath = "//input[contains(@id,'Fax')]")
	WebElement faxNewContactpage;

	@FindBy(xpath = "//input[contains(@id,'Assistant_Name')]")
	WebElement assistantNameNewContactpage;

	@FindBy(xpath = "//input[contains(@id,'Assistant_Phone')]")
	WebElement assistantPhoneNewContactPage;

	@FindBy(xpath = "//label[text()='Comm Email Sent']/parent::div/div//span/input[contains(@class,'js-datepicker')]")
	WebElement commEmailSentNewContactpage;

	@FindBy(xpath = "//label[text()='Inactivation Date']/parent::div/div//span/input[contains(@class,'js-datepicker')]")
	WebElement inactivationDateNewContactPage;

	@FindBy(xpath = "//input[contains(@id,'Assistant_Email__c')]")
	WebElement assistantEmailNewContactPage;

	@FindBy(xpath = "//select[contains(@id,'Preferred_Comm_Method')]")
	WebElement preferredCommMethod;

	@FindBy(xpath = "//select[contains(@id,'Preferred_Comm_Method')]/option[@value='Call']")
	WebElement preferredCommMethodValue;

	@FindBy(xpath = "//select[contains(@id,'Reason_for_Inactivating__c')]")
	WebElement reasonForInactivating;

	@FindBy(xpath = "//select[contains(@id,'Reason_for_Inactivating__c')]/option[@value='Deceased']")
	WebElement reasonForInactivatingValue;

	@FindBy(xpath = "//select[contains(@id,'APAC_Exclude_Reason__c')]")
	WebElement excludedReasonNewContactPage;

	@FindBy(xpath = "//select[contains(@id,'APAC_Exclude_Reason__c')]/option[@value='Archived']")
	WebElement excludedReasonValueNewContactPage;

	@FindBy(xpath = "//label[text()='Excluded On']/parent::div/div//span/input[contains(@class,'js-datepicker')]")
	WebElement excludedOnNewContactpage;

	@FindBy(xpath = "//input[@id='apacexcludedBox']")
	WebElement excludedByNewContactpage;

	@FindBy(xpath = "//button[text()='Continue']")
	WebElement continueButtonNewContact;

	@FindBy(xpath = "//select[contains(@id,'contForm:statusPicklist')]")
	WebElement statusNewContactPage;

	@FindBy(xpath = "//select[contains(@id,'contForm:statusPicklist')]/option[@value='Inactive']")
	WebElement statusValueNewContactPage;

	@FindBy(xpath = "//input[@type='email']")
	WebElement emailContactEditPage;

	@FindBy(xpath = "//a[@title='Show more actions for this record']")
	WebElement moreOptions;

	@FindBy(xpath = "//div[@class='forceActionLink'][text()='Edit']")
	WebElement editMoreOptions;

	@FindBy(xpath = "//a[@aria-label='Status']")
	WebElement statusEditPage;

	@FindBy(xpath = "//a[@title='Inactive']")
	WebElement statusValue;

	@FindBy(xpath = "//a[@aria-label='Reason for Inactivating']")
	WebElement reasonForInactivatingEditPage;

	@FindBy(xpath = "//a[@title='Deceased']")
	WebElement reasonForInactivatingValueEditPage;

	@FindBy(xpath = "//div[@class='form-element']/input")
	WebElement inactivationDateEditPage;

	@FindBy(xpath = "//div[contains(@class,'forceModalActionContainer--footerAction')]/button[@title='Save']")
	WebElement saveContactEditpage;

	@FindBy(xpath = "//span[text()='Add']")
	WebElement addActivity;

	SearchTextSOQL searchAccountName = new SearchTextSOQL(scriptHelper);
	LoginPage loginPage = new LoginPage(scriptHelper);
	ActivityPage activityPage = new ActivityPage(scriptHelper);

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
		report.updateTestLog("Verify Create Activity Contact", "Contacts are Displayed ", Status.PASS);
		Utility_Functions.xWaitForElementPresent(driver, recentlyViewed, 3);
		Utility_Functions.xClick(driver, recentlyViewed, true);
		report.updateTestLog("Verify Create Activity Contact", "Recently viewed contacts are Displayed ", Status.PASS);
		Utility_Functions.xWaitForElementPresent(driver, allContacts, 3);
		Utility_Functions.xClick(driver, allContacts, true);
		Utility_Functions.timeWait(7);
		report.updateTestLog("Verify Create Activity Contact", "All contacts are displayed successfully:::", Status.PASS);
		List<WebElement> contactList = driver
				.findElements(By.xpath("//a[@class='slds-truncate outputLookupLink slds-truncate forceOutputLookup']"));
		Utility_Functions.xclickgetTextofFirstElementfromList(contactList);
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

		// driver.switchTo().frame(driver.findElement(By.xpath("//iframe[contains(@src,'ContactRedirectPage')]")));
		Utility_Functions.xSwitchtoFrame(driver, createContact);

		Utility_Functions.timeWait(1);
		if (!dataTable.getData("General_Data", "TC_ID").contains("Broker")) {
			Utility_Functions.xClick(driver, continueButton, true);
		}
/*		Utility_Functions.timeWait(2);
		Utility_Functions.xSendKeys(driver, accountSearch, "Test");
		Utility_Functions.xSendKeys(driver, accountSearch, Keys.SPACE);
		Utility_Functions.timeWait(3);*/
		Utility_Functions.xWaitForElementPresent(driver, accountSearch, 4);
		Utility_Functions.xClick(driver, accountSearch, true);
		WebElement firstLookupElement = driver.findElement(By.cssSelector("ul>li.forceSearchInputLookupDesktopOption:nth-child(1)"));
		Utility_Functions.xWaitForElementPresent(driver, firstLookupElement, 4);
		Utility_Functions.xClick(driver, firstLookupElement, true);
		String accountName = accountNames.getText();
/*		String accountFirstName = accountName.split(" ")[0]; 
		String accountSecondName = accountName.split(" ")[1];	*/	 
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
		report.updateTestLog("Verify Create Activity Contact ", "Contacts is Displayed ", Status.PASS);
		Utility_Functions.xWaitForElementPresent(driver, recentlyViewed, 3);
		Utility_Functions.xClick(driver, recentlyViewed, true);
		report.updateTestLog("Verify Create Activity Contact ", "Recently viewed Contacts are Displayed ", Status.PASS);
		Utility_Functions.xWaitForElementPresent(driver, allContacts, 3);
		Utility_Functions.xClick(driver, allContacts, true);
		Utility_Functions.timeWait(3);
		report.updateTestLog("Verify Create Activity Contact ", "All Contacts are Displayed ", Status.PASS);
		List<WebElement> contactNamesList = driver.findElements(By.xpath(
				"//a[@class='slds-truncate outputLookupLink slds-truncate forceOutputLookup'][contains(@data-recordid,'003')]"));

		Utility_Functions.xclickOnFirstElementfromList(contactNamesList);
		Utility_Functions.timeWait(3);
		report.updateTestLog("Verify Create Activity Contact ", "The Contact is Displayed ", Status.PASS);
		activityPage.createNewActivity();

		/*
		 * Utility_Functions.xWaitForElementPresent(driver, related, 3);
		 * Utility_Functions.xClick(driver, related, true);
		 * report.updateTestLog("Verify Create Activity Contact ",
		 * "The related page is Displayed ", Status.PASS);
		 * Utility_Functions.xScrollWindow(driver);
		 * Utility_Functions.timeWait(1);
		 * Utility_Functions.xScrollWindowTop(driver);
		 * Utility_Functions.timeWait(2);
		 * Utility_Functions.xWaitForElementPresent(driver, newActivity, 3);
		 * Utility_Functions.xClick(driver, newActivity, true);
		 * report.updateTestLog("Verify Create Activity Contact ",
		 * "The New Activity in the related page is Displayed ", Status.PASS);
		 * 
		 * int size = driver.findElements(By.tagName("iframe")).size();
		 * System.out.println(size); Utility_Functions.timeWait(2);
		 * List<WebElement> iframeList =
		 * driver.findElements(By.tagName("iframe"));
		 * System.out.println(iframeList.size()); for (WebElement element :
		 * iframeList) { System.out.println(element.getAttribute("id")); }
		 * 
		 * driver.switchTo().frame(4); Utility_Functions.timeWait(5);
		 * System.out.println("Frame Identified");
		 * 
		 * 
		 * Utility_Functions.timeWait(3); List<WebElement> iframeList =
		 * driver.findElements(By.tagName("iframe"));
		 * 
		 * for (WebElement element : iframeList) {
		 * driver.switchTo().frame(element); try{ boolean isTextValuePresent =
		 * Utility_Functions.xWaitForElementPresent(driver, subject, 3);
		 * if(isTextValuePresent){ break; }else{
		 * driver.switchTo().defaultContent(); } }catch(Exception ex){
		 * driver.switchTo().defaultContent(); }
		 * 
		 * }
		 * 
		 * Utility_Functions.xSwitchtoFrame(driver, subject);
		 * Utility_Functions.xWaitForElementPresent(driver, subject, 5);
		 * Utility_Functions.xClick(driver, subject, true);
		 * Utility_Functions.xWaitForElementPresent(driver, subject, 5);
		 * Utility_Functions.xSendKeys(driver, subject, "test1");
		 * Utility_Functions.xWaitForElementPresent(driver, activityType1, 5);
		 * Utility_Functions.xClick(driver, activityType1, true);
		 * Utility_Functions.xWaitForElementPresent(driver, saveAndNewActivity,
		 * 5); Utility_Functions.xClick(driver, saveAndNewActivity, true);
		 * Utility_Functions.timeWait(3);
		 * report.updateTestLog("Verify Create Activity Contact ",
		 * "The Activity is saved and New Activity is displayed ", Status.PASS);
		 * Utility_Functions.xClick(driver, subject, true);
		 * Utility_Functions.timeWait(3); String value =
		 * Utility_Functions.xGenerateAlphaNumericString();
		 * 
		 * Utility_Functions.xSendKeys(driver, subject,
		 * "Test Activity Created by Automation_" + value);
		 * Utility_Functions.xWaitForElementPresent(driver, activityType2, 5);
		 * Utility_Functions.xClick(driver, activityType2, true);
		 * Utility_Functions.xWaitForElementPresent(driver, saveActivity, 5);
		 * Utility_Functions.xClick(driver, saveActivity, true);
		 * 
		 * SearchTextSOQL searchTextSOQL = new SearchTextSOQL(scriptHelper);
		 * String query = "select Name from Activity__C where Subject__C = " +
		 * "'" + "Test Activity Created by Automation_" + value + "'"; String
		 * nameActivity = searchTextSOQL.fetchRecordFieldValue("Name", query);
		 * if (nameActivity.isEmpty()) {
		 * System.out.println("Activity has not been retrieved");
		 * report.updateTestLog("Verify Create Activity Account ",
		 * "The newly created Activity has not been retrieved ", Status.FAIL); }
		 * else { System.out.println("Activity has been retrieved");
		 * report.updateTestLog("Verify Create Activity Account ",
		 * "The newly created Activity has been retrieved", Status.PASS); }
		 * String queryId = "select Id from Activity__C where Name = " + "'" +
		 * nameActivity + "'"; String activityId =
		 * searchTextSOQL.fetchRecordFieldValue("Id", queryId);
		 * 
		 * String url = driver.getCurrentUrl().split("#")[0]; String newUrl =
		 * url + "#/sObject/" + activityId; newUrl = newUrl + "/view";
		 * report.updateTestLog("Verify Add Opportunity Page Fields",
		 * "URL has been replaced with the new URL having the retrieved Opportunity:::"
		 * + newUrl, Status.PASS); driver.get(newUrl);
		 * Utility_Functions.timeWait(1); driver.navigate().refresh();
		 * Utility_Functions.timeWait(3); driver.navigate().refresh();
		 * Utility_Functions.timeWait(1); driver.switchTo().defaultContent();
		 * driver.navigate().refresh(); Utility_Functions.timeWait(3);
		 * Utility_Functions.xWaitForElementPresent(driver,
		 * selectCreateFollowUpCustomActivity, 5);
		 * Utility_Functions.xClick(driver, selectCreateFollowUpCustomActivity,
		 * true);
		 * 
		 * report.updateTestLog("Verify Create Activity Contact",
		 * "The Follow up Activity Page is Displayed", Status.PASS);
		 * Utility_Functions.xWaitForElementPresent(driver,
		 * createCustomActivity, 5); // Utility_Functions.xClick(driver,
		 * createCustomActivity, true); Actions action = new
		 * Actions(driver.getWebDriver());
		 * action.moveToElement(createCustomActivity); action.click();
		 * action.build().perform(); Utility_Functions.timeWait(3);
		 * 
		 * Utility_Functions.xSwitchtoFrame(driver, subject);
		 * Utility_Functions.timeWait(3); Utility_Functions.xClick(driver,
		 * subject, true); Utility_Functions.xWaitForElementPresent(driver,
		 * subject, 5); Utility_Functions.xSendKeys(driver, subject, "test3");
		 * Utility_Functions.xWaitForElementPresent(driver, activityType3, 5);
		 * Utility_Functions.xClick(driver, activityType3, true);
		 * Utility_Functions.xWaitForElementPresent(driver, saveActivity, 5);
		 * Utility_Functions.xClick(driver, saveActivity, true);
		 * Utility_Functions.timeWait(3);
		 * report.updateTestLog("Verify Create Activity Contact ",
		 * "The Custom Activity is created ", Status.PASS);
		 * driver.navigate().refresh(); Utility_Functions.timeWait(1);
		 * driver.switchTo().defaultContent(); driver.navigate().refresh();
		 * Utility_Functions.timeWait(3);
		 * Utility_Functions.xWaitForElementPresent(driver, menu_Contacts, 3);
		 * Utility_Functions.xClick(driver, menu_Contacts, true); //
		 * Utility_Functions.xClick(driver, recentlyViewed, true); //
		 * Utility_Functions.timeWait(3); List<WebElement>
		 * recentlyViewedpropertiesList = driver.findElements( By.
		 * xpath(".//a[@class='slds-truncate outputLookupLink slds-truncate forceOutputLookup']"
		 * ));
		 * 
		 * Utility_Functions.xclickOnFirstElementfromList(
		 * recentlyViewedpropertiesList); Utility_Functions.timeWait(3);
		 * Utility_Functions.xWaitForElementVisible(driver, related, 5);
		 * Utility_Functions.xClick(driver, related, true);
		 * Utility_Functions.xScrollWindow(driver);
		 * Utility_Functions.timeWait(1);
		 * Utility_Functions.xScrollWindowTop(driver);
		 * Utility_Functions.timeWait(2);
		 * 
		 * Utility_Functions.xWaitForElementPresent(driver, relatedActivities,
		 * 5); Utility_Functions.xClick(driver, relatedActivities, true);
		 * 
		 * List<WebElement> relatedActivitiesList = driver.findElements( By.
		 * xpath(".//a[@class='slds-truncate outputLookupLink slds-truncate forceOutputLookup'] "
		 * )); for (WebElement element : relatedActivitiesList) { if
		 * ((!element.getText().equals(" "))) {
		 * report.updateTestLog("Verify Create Activity Contact",
		 * "The New Activity for Contacts are created ", Status.PASS); } else {
		 * report.updateTestLog("Verify Create Activity Contact",
		 * "The New Activity for Contacts are not created ", Status.FAIL); } }
		 */
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
		report.updateTestLog("Verify New Activity Page Layout ", "Contacts is Displayed ", Status.PASS);
		Utility_Functions.xWaitForElementPresent(driver, recentlyViewed, 3);
		Utility_Functions.xClick(driver, recentlyViewed, true);
		report.updateTestLog("Verify New Activity Page Layout ", "Recently viewed Accounts are Displayed ",
				Status.PASS);
		Utility_Functions.xWaitForElementPresent(driver, allContacts, 3);
		Utility_Functions.xClick(driver, allContacts, true);
		Utility_Functions.timeWait(3);
		report.updateTestLog("Verify New Activity Page Layout ", "All Contacts are Displayed ", Status.PASS);
		List<WebElement> accountNamesList = driver.findElements(By.xpath(
				".//a[@class='slds-truncate outputLookupLink slds-truncate forceOutputLookup'][contains(@data-recordid,'003')]"));

		Utility_Functions.xclickOnFirstElementfromList(accountNamesList);
		Utility_Functions.timeWait(3);
		activityPage.createNewActivity();

		/*
		 * report.updateTestLog("Verify New Activity Page Layout ",
		 * "The Contact is Displayed ", Status.PASS);
		 * Utility_Functions.xClick(driver, related, true);
		 * Utility_Functions.timeWait(3);
		 * report.updateTestLog("Verify New Activity Page Layout ",
		 * "The related page is Displayed ", Status.PASS);
		 * Utility_Functions.xScrollWindow(driver);
		 * Utility_Functions.timeWait(1);
		 * Utility_Functions.xScrollWindowTop(driver);
		 * Utility_Functions.timeWait(2);
		 * Utility_Functions.xWaitForElementPresent(driver, newActivity, 3);
		 * Utility_Functions.xClick(driver, newActivity, true);
		 * report.updateTestLog("Verify New Activity Page Layout ",
		 * "The New Activity in the related page is Displayed ", Status.PASS);
		 * 
		 * Utility_Functions.xSwitchtoFrame(driver, subject);
		 * Utility_Functions.timeWait(5);
		 * 
		 * List<WebElement> newActivityPageLayoutSections =
		 * driver.findElements(By.xpath("//div[@class='slds-grid']")); int
		 * countHeader = 0; try { for (WebElement element :
		 * newActivityPageLayoutSections) { if
		 * ((element.getText().contains("Quick Create"))) { System.out.
		 * println("Quick Create section is present in the New Activity Layout Page"
		 * ); report.updateTestLog("Verify New Activity Page Layout",
		 * "New Activity Layout Page is having the " + element.getText() +
		 * " Status field::", Status.PASS); countHeader++;
		 * 
		 * } else if ((element.getText().contains("System Information"))) {
		 * System.out.
		 * println("System Information section is present in the New Activity Layout Page"
		 * ); report.updateTestLog("Verify New Activity Page Layout",
		 * "New Activity Layout Page is having the " + element.getText() +
		 * " Status field::", Status.PASS); countHeader++;
		 * 
		 * } else if ((element.getText().contains("Related To"))) { System.out.
		 * println(" Related To section is present in the New Activity Layout Page"
		 * ); report.updateTestLog("Verify New Activity Page Layout",
		 * "New Activity Layout Page is having the " + element.getText() +
		 * " Status field::", Status.PASS); countHeader++;
		 * 
		 * } } System.out.println(countHeader); if (countHeader != 3) {
		 * System.out.println(
		 * "New Activity Page Layout does not contain the Quick Create, System Information and Related To sections"
		 * ); report.updateTestLog("Verify New Activity Page Layout",
		 * "New Activity Layout Page is having all the fields", Status.FAIL); }
		 * } catch (Exception e) { e.printStackTrace();
		 * System.out.println(e.getMessage()); }
		 * 
		 * List<WebElement> newActivityPageLayoutRequiredFields = driver
		 * .findElements(By.xpath("//label[@class='slds-form-element__label']"))
		 * ; int countRequiredFiles = 0; try { for (WebElement element :
		 * newActivityPageLayoutRequiredFields) { if
		 * ((element.getText().equals("*Subject"))) { System.out.
		 * println("Subject required field is present in the New Activity Layout Page"
		 * ); report.updateTestLog("Verify New Activity Page Layout",
		 * "New Activity Layout Page is having the " + element.getText() +
		 * " Status field::", Status.PASS); countRequiredFiles++;
		 * 
		 * } else if ((element.getText().equals("*Activity Type"))) {
		 * System.out.
		 * println("Activity Type required field is present in the New Activity Layout Page"
		 * ); report.updateTestLog("Verify New Activity Page Layout",
		 * "New Activity Layout Page is having the " + element.getText() +
		 * " Status field::", Status.PASS); countRequiredFiles++;
		 * 
		 * } else if ((element.getText().equals("*Assigned To"))) { System.out.
		 * println(" Assigned To required field is present in the New Activity Layout Page"
		 * ); report.updateTestLog("Verify New Activity Page Layout",
		 * "New Activity Layout Page is having the " + element.getText() +
		 * " Status field::", Status.PASS); countRequiredFiles++;
		 * 
		 * } else if ((element.getText().equals("*Status"))) { System.out.
		 * println(" Status required field is present in the New Activity Layout Page"
		 * ); report.updateTestLog("Verify New Activity Page Layout",
		 * "New Activity Layout Page is having the " + element.getText() +
		 * " Status field::", Status.PASS); countRequiredFiles++;
		 * 
		 * } else if ((element.getText().equals("*Priority"))) { System.out.
		 * println(" Priority required field is present in the New Activity Layout Page"
		 * ); report.updateTestLog("Verify New Activity Page Layout",
		 * "New Activity Layout Page is having the " + element.getText() +
		 * " Status field::", Status.PASS); // countRequiredFiles++;
		 * 
		 * }
		 * 
		 * } System.out.println(countRequiredFiles); if (countRequiredFiles !=
		 * 4) { System.out.
		 * println("New Activity Page Layout does not contain the required fields "
		 * ); report.updateTestLog("Verify New Activity Page Layout",
		 * "New Activity Layout Page is having all the required fields",
		 * Status.FAIL); }
		 * 
		 * } catch (Exception e) { e.printStackTrace();
		 * System.out.println(e.getMessage());
		 * 
		 * }
		 * 
		 * if ((!saveNewActivityLayoutPage.getText().equals(" ")) ||
		 * (!saveAndNewActivityLayoutPage.getText().equals(" ")) ||
		 * (!cancelNewActivityLayoutPage.getText().equals(" "))) { System.out.
		 * println("Save, Save and New and Cancel buttons are prsent in the New Activity Layout Page "
		 * ); report.updateTestLog("Verify New Activity Page Layout ",
		 * "Verifying New Activity Page is having the Save, Save and New and Cancel buttons "
		 * , Status.PASS); } else { System.out
		 * .println("Save, Save and New and Cancel buttons are not prsent in the New Activity Layout Page  "
		 * ); report.updateTestLog("Verify New Activity Page Layout",
		 * "Verifying New Activity Page is having the Save, Save and New and Cancel buttons"
		 * , Status.FAIL); }
		 * 
		 * List<WebElement> newActivityPageFields = driver
		 * .findElements(By.xpath("//label[@class='slds-form-element__label']"))
		 * ; int count = 0; try { for (WebElement element :
		 * newActivityPageFields) { if ((count == 0) &&
		 * (element.getText().contains("Subject"))) { System.out.
		 * println("Subject field is present in the New Activity Layout Page");
		 * report.updateTestLog("Verify New Activity Page Layout",
		 * "New Activity Layout Page is having the " + element.getText() +
		 * " Status field::", Status.PASS); count++; } else if ((count == 1) &&
		 * (element.getText().contains("Activity Type"))) { System.out.
		 * println("Activity Type field is present in the New Activity Layout Page"
		 * ); report.updateTestLog("Verify New Activity Page Layout",
		 * "New Activity Layout Page is having the " + element.getText() +
		 * " Status field::", Status.PASS); count++; } else if ((count == 2) &&
		 * (element.getText().contains("DueDate"))) { System.out.
		 * println("Due Date field is present in the New Activity Layout Page");
		 * report.updateTestLog("Verify New Activity Page Layout",
		 * "New Activity Layout Page is having the " + element.getText() +
		 * " Status field::", Status.PASS); count++; } else if ((count == 3) &&
		 * (element.getText().contains("Call Result"))) { System.out.
		 * println("Call Result field is present in the New Activity Layout Page"
		 * ); report.updateTestLog("Verify New Activity Page Layout",
		 * "New Activity Layout Page is having the " + element.getText() +
		 * " Status field::", Status.PASS); count++;
		 * 
		 * } else if ((count == 4) && (element.getText().contains("Comments")))
		 * { System.out.
		 * println("Comments field is present in the New Activity Layout Page");
		 * report.updateTestLog("Verify New Activity Page Layout",
		 * "New Activity Layout Page is having the " + element.getText() +
		 * " Status field::", Status.PASS); count++; } else if ((count == 5) &&
		 * (element.getText().contains("Owner"))) { System.out.
		 * println("Owner field is present in the New Activity Layout Page");
		 * report.updateTestLog("Verify New Activity Page Layout",
		 * "New Activity Layout Page is having the " + element.getText() +
		 * " Status field::", Status.PASS); count++; } else if ((count == 6) &&
		 * (element.getText().contains("Assigned To"))) { System.out.
		 * println("Assigned To field is present in the New Activity Layout Page"
		 * ); report.updateTestLog("Verify New Activity Page Layout",
		 * "New Activity Layout Page is having the " + element.getText() +
		 * " Status field::", Status.PASS); count++; } else if ((count == 7) &&
		 * (element.getText().contains("Status"))) { System.out.
		 * println("Status field is present in the New Activity Layout Page");
		 * report.updateTestLog("Verify New Activity Page Layout",
		 * "New Activity Layout Page is having the " + element.getText() +
		 * " Status field::", Status.PASS); count++; } else if ((count == 8) &&
		 * (element.getText().contains("Priority"))) { System.out.
		 * println("Priority field is present in the New Activity Layout Page");
		 * report.updateTestLog("Verify New Activity Page Layout",
		 * "New Activity Layout Page is having the " + element.getText() +
		 * " Status field::", Status.PASS); count++; } else if ((count == 9) &&
		 * (element.getText().contains("Account"))) { System.out.
		 * println("Account field is present in the New Activity Layout Page");
		 * report.updateTestLog("Verify New Activity Page Layout",
		 * "New Activity Layout Page is having the " + element.getText() +
		 * " Status field::", Status.PASS); count++; } else if ((count == 10) &&
		 * (element.getText().contains("Contact"))) { System.out.
		 * println("Contact field is present in the New Activity Layout Page");
		 * report.updateTestLog("Verify New Activity Page Layout",
		 * "New Activity Layout Page is having the " + element.getText() +
		 * " Status field::", Status.PASS); count++;
		 * 
		 * } else if ((count == 11) &&
		 * (element.getText().contains("Opportunity"))) { System.out.
		 * println("Opportunity field is present in the New Activity Layout Page"
		 * ); report.updateTestLog("Verify New Activity Page Layout",
		 * "New Activity Layout Page is having the " + element.getText() +
		 * " Status field::", Status.PASS); count++; } else if ((count == 12) &&
		 * (element.getText().contains("Property"))) { System.out.
		 * println("Property field is present in the New Activity Layout Page");
		 * report.updateTestLog("Verify New Activity Page Layout",
		 * "New Activity Layout Page is having the " + element.getText() +
		 * " Status field::", Status.PASS); count++; } else if ((count == 13) &&
		 * (element.getText().contains("Space"))) { System.out.
		 * println("Space  field is present in the New Activity Layout Page");
		 * report.updateTestLog("Verify New Activity Page Layout",
		 * "New Activity Layout Page is having the " + element.getText() +
		 * " Status field::", Status.PASS); count++; } else if ((count == 14) &&
		 * (element.getText().contains("Comp"))) { System.out.
		 * println("Comp field is present in the New Activity Layout Page");
		 * report.updateTestLog("Verify New Activity Page Layout",
		 * "New Activity Layout Page is having the " + element.getText() +
		 * " Status field::", Status.PASS);
		 * 
		 * }
		 * 
		 * } System.out.println(count); if (count != 14) { System.out.
		 * println("New Activity Page Layout does not contain all the fields ");
		 * report.updateTestLog("Verify New Activity Page Layout",
		 * "New Activity Layout Page is not having all the fields",
		 * Status.FAIL);
		 * 
		 * } } catch (Exception e) { e.printStackTrace();
		 * System.out.println(e.getMessage()); }
		 * 
		 * List<WebElement> newActivityPageCheckFields = driver
		 * .findElements(By.xpath("//span[@class='slds-form-element__label']"));
		 * 
		 * try { for (WebElement element : newActivityPageCheckFields) { if
		 * ((element.getText().contains("Set Reminder"))) { System.out.println(
		 * "Set Reminder field is present in the Create Private Notes Personal Information Page"
		 * ); report.updateTestLog("Verify New Activity Page Layout",
		 * "New Activity Layout Page is having the " + element.getText() +
		 * " Status field::", Status.PASS);
		 * 
		 * } else if ((element.getText().contains("Notification Email"))) {
		 * System.out.
		 * println("Notification Email field is present in the New Activity Layout Page"
		 * ); report.updateTestLog("Verify New Activity Page Layout",
		 * "New Activity Layout Page is having the " + element.getText() +
		 * " Status field::", Status.PASS);
		 * 
		 * } else if ((element.getText().contains("Has Attachment"))) {
		 * System.out.
		 * println("Has Attachment  field is present in the New Activity Layout Page"
		 * ); report.updateTestLog("Verify New Activity Page Layout",
		 * "New Activity Layout Page is having the " + element.getText() +
		 * " Status field::", Status.PASS);
		 * 
		 * } else { System.out.println(
		 * "New Activity Page Layout does not contain the the Set Reminder and Notification Email and Has Attachment Fields"
		 * ); report.updateTestLog("Verify New Activity Page Layout",
		 * "New Activity Layout Page is having the " + element.getText() +
		 * " Status field::", Status.FAIL);
		 * 
		 * } } } catch (Exception e) { e.printStackTrace();
		 * System.out.println(e.getMessage()); } try { if
		 * ((!assignedTo.getText().equals("")) ||
		 * (!accountSelected.getText().equals("")) ||
		 * (!priority.getText().equals("")) || (!owner.getText().equals("")) ||
		 * (!statusContacts.getText().equals(""))) { System.out.println(
		 * "Assigned To, Account Selected, Priority, Owner and Status fields are having the values:::"
		 * ); report.updateTestLog("Verify New Activity Page Layout",
		 * "New Activity Layout Page is having the values::", Status.PASS); }
		 * else { System.out.
		 * println("New Activity Layout Page is not having the deafault values:::"
		 * ); report.updateTestLog("Verify New Activity Page Layout",
		 * "New Activity layout Page is not having the values::", Status.FAIL);
		 * } } catch (Exception e) { e.printStackTrace();
		 * System.out.println(e.getMessage()); }
		 */

	}

	/**
	 * Validating the New Activity Page send Notification Email to the Assigned
	 * Person
	 * 
	 * @author Ramya
	 *
	 */

	public void verifyContactNewActivityPageSendNotificationEmail() {

		Utility_Functions.xWaitForElementPresent(driver, menu_Contacts, 3);
		Utility_Functions.xClick(driver, menu_Contacts, true);

		report.updateTestLog("Verify New Activity Page send Notification Email ",
				"Verifying the Contacts is Displayed ", Status.PASS);

		List<WebElement> contactNamesList = driver.findElements(By.xpath(
				"//a[@class='slds-truncate outputLookupLink slds-truncate forceOutputLookup'][contains(@data-recordid,'003')]"));

		Utility_Functions.xclickOnFirstElementfromList(contactNamesList);
		report.updateTestLog("Verify New Activity Page send Notification Email ",
				"Verifying the selected Contact is Displayed ", Status.PASS);
		activityPage.verifyNewActivityPageLayout();
		/*
		 * Utility_Functions.xWaitForElementPresent(driver, related, 3);
		 * Utility_Functions.xClick(driver, related, true);
		 * report.updateTestLog("Verify New Activity Page Layout ",
		 * "Verifying the Contact related page is Displayed ", Status.PASS);
		 * Utility_Functions.xScrollWindow(driver);
		 * Utility_Functions.timeWait(1);
		 * Utility_Functions.xScrollWindowTop(driver);
		 * Utility_Functions.timeWait(2);
		 * Utility_Functions.xWaitForElementPresent(driver, newActivity, 3);
		 * Utility_Functions.xClick(driver, newActivity, true);
		 * Utility_Functions.timeWait(3); report.
		 * updateTestLog("Verify New Activity Page send Notification Email  ",
		 * "Verifying the New Activity in the Contact related page is Displayed "
		 * , Status.PASS); // Utility_Functions.xSwitchtoFrame(driver, subject);
		 * 
		 * int size = driver.findElements(By.tagName("iframe")).size();
		 * System.out.println(size); Utility_Functions.timeWait(2);
		 * List<WebElement> iframeList =
		 * driver.findElements(By.tagName("iframe"));
		 * System.out.println(iframeList.size()); for (WebElement element :
		 * iframeList) { System.out.println(element.getAttribute("id")); }
		 * 
		 * driver.switchTo().frame(3); Utility_Functions.xSwitchtoFrame(driver,
		 * subject); Utility_Functions.timeWait(3);
		 * 
		 * Utility_Functions.xWaitForElementPresent(driver, subject, 3);
		 * Utility_Functions.xClick(driver, subject, true);
		 * Utility_Functions.xWaitForElementPresent(driver, subject, 3);
		 * Utility_Functions.xSendKeys(driver, subject, "test1"); report.
		 * updateTestLog("Verify New Activity Page send Notification Email  ",
		 * "Verifying the subject field is populated with the user defined value "
		 * , Status.PASS); Utility_Functions.xWaitForElementPresent(driver,
		 * activityType1, 3); Utility_Functions.xClick(driver, activityType1,
		 * true); report.
		 * updateTestLog("Verify New Activity Page send Notification Email  ",
		 * "Verifying the Activity Type field is populated with one of the pick list values "
		 * , Status.PASS);
		 * 
		 * if (!notificationEmail.isSelected()) { // notificationEmail.click();
		 * 
		 * Utility_Functions.xClick(driver, notificationEmail, true);
		 * System.out.println("Notification email is checked"); report.
		 * updateTestLog("Verify New Activity Page send Notification Email  ",
		 * "Verifying the notification email check box is checked or else checking it"
		 * , Status.PASS);
		 * 
		 * } else { System.out.println("Notification email is not checked");
		 * report.
		 * updateTestLog("Verify New Activity Page send Notification Email  ",
		 * "Verifying the notification email check box is checked or not ",
		 * Status.FAIL); } Utility_Functions.xWaitForElementPresent(driver,
		 * assignedTo, 3); Utility_Functions.xSendKeys(driver, assignedTo,
		 * "vishnuvardhan bommisetty"); report.
		 * updateTestLog("Verify New Activity Page send Notification Email  ",
		 * "Verifying the Assigned To field is populated with the appropriate value "
		 * , Status.PASS); Utility_Functions.xWaitForElementPresent(driver,
		 * saveActivity, 3); Utility_Functions.xClick(driver, saveActivity,
		 * true); report.
		 * updateTestLog("Verify New Activity Page send Notification Email  ",
		 * "Verifying the notification email issent to the Assigned To person in the New Activity page "
		 * , Status.PASS);
		 */
	}

	/**
	 * Validating the hyperlink for number of Contacts related to Account
	 * 
	 * @author Vishnuvardhan
	 *
	 */

	public String retriveAccount() {
		String query = "SELECT Id, Total_Number_Of_Contact_Parent_Formula__c FROM Account where Total_Number_Of_Contact_Parent_Formula__c  > 1 limit 1 offset 9";
		// String query = "SELECT Id, Total_Number_Of_Contact_Parent_Formula__c,
		// createddate from Account order by createddate desc";
		String sAccountID = searchAccountName.fetchRecordFieldValue("Id", query);
		report.updateTestLog("Verify Contact hyperlink", "Account ID retrived from database is:::" + sAccountID,
				Status.PASS);
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
		report.updateTestLog("Verify Create Activity Contact ", "Recently viewed Contacts are Displayed ", Status.PASS);
		Utility_Functions.xWaitForElementPresent(driver, allAccounts, 3);
		Utility_Functions.xClick(driver, allAccounts, true);
		Utility_Functions.timeWait(3);
		report.updateTestLog("Verify Accounts", "All Accounts are Displayed ", Status.PASS);
		List<WebElement> accountList = driver
				.findElements(By.xpath("//a[@class='slds-truncate outputLookupLink slds-truncate forceOutputLookup']"));
		Utility_Functions.xclickRandomElement(accountList);
		String accountID = retriveAccount();
		if (accountID == null) {
			report.updateTestLog("Verify Contact hyperlink", "There are no accounts having Contacts:::", Status.PASS);
		} else {
			driver.navigate().refresh();
			try {
				Utility_Functions.xWaitForElementPresent(driver, related, 3);
				Utility_Functions.xClick(driver, related, true);
				int count = 0;
				List<WebElement> contactsList = driver.findElements(By
						.xpath("//article[contains(@class,'forceRelatedListCardDesktop')]//a[contains(@href,'003')]"));
				for (WebElement element : contactsList) {
					report.updateTestLog("Verify Contact hyperlink",
							"Contacts associated to this Account are :::" + element.getText(), Status.PASS);
					count++;
				}
				if (count != 0) {
					report.updateTestLog("Verify Contact hyperlink",
							"Contacts hyperlinks are present in Related section for Account", Status.PASS);
				} else {
					report.updateTestLog("Verify Contact hyperlink",
							"Contacts hyperlinks are not present in Related section for Account", Status.FAIL);
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
		
		ContactsFunctions contactsFunctions = new ContactsFunctions(scriptHelper);
		contactsFunctions.createContactRequiredFields();

		/*Utility_Functions.xWaitForElementPresent(driver, menu_Contacts, 3);
		Utility_Functions.xClick(driver, menu_Contacts, true);
		Utility_Functions.timeWait(1);
		report.updateTestLog("Verify Contact Creation With Required Fields ", "Verifying Contacts is Displayed ",
				Status.PASS);
		Utility_Functions.xWaitForElementPresent(driver, newContact, 3);
		Utility_Functions.xClick(driver, newContact, true);
		Utility_Functions.timeWait(2);
		report.updateTestLog("Verify Contact Creation With Required Fields ",
				"Verifying New Contacts Page is Displayed  ", Status.PASS);
		Utility_Functions.xSwitchtoFrame(driver, lastNameQuickCreateContact);
		Utility_Functions.timeWait(2);
		Utility_Functions.xWaitForElementPresent(driver, accountNameQuickCreateContact, 5);
		report.updateTestLog("Verify Contact Creation With Required Fields ",
				"Verifying Account name required field is populated ", Status.PASS);
		Utility_Functions.xWaitForElementPresent(driver, lastNameQuickCreateContact, 5);
		Utility_Functions.xSendKeys(driver, lastNameQuickCreateContact, "Test_Contact_Last_Name");
		Utility_Functions.xWaitForElementPresent(driver, directLine, 5);
		Utility_Functions.xSendKeys(driver, directLine, dataTable.getData("General_Data", "Direct Line"));
		String query = "SELECT Id, Name, EMEA_Searchable__c FROM Account where EMEA_Searchable__c = false limit 1 offset 9";
		String sAccountName = searchAccountName.fetchRecordFieldValue("Name", query);
		Utility_Functions.xSendKeys(driver, accountNameQuickCreateContact, sAccountName);
		accountNameQuickCreateContact.sendKeys(Keys.ARROW_DOWN);
		Utility_Functions.timeWait(2);
		accountNameQuickCreateContact.sendKeys(Keys.ENTER);
		Utility_Functions.timeWait(2);
		Utility_Functions.xWaitForElementPresent(driver, saveContact, 3);
		Utility_Functions.xClick(driver, saveContact, true);
		report.updateTestLog("Verify Contact Creation With Required Fields ",
				"Contact has been created successfully and have clicked on Save Button", Status.PASS);
		Utility_Functions.timeWait(3);
		driver.navigate().refresh();
		Utility_Functions.timeWait(2);
		Utility_Functions.xWaitForElementPresent(driver, details, 3);
		if (details.isDisplayed()) {

			report.updateTestLog("Verify Contact Record Updation",
					"The existing record can be updated and saved successfully", Status.PASS);
		} else {
			report.updateTestLog("Verify Contact Record Updation",
					"The existing record cannot be updated and saved successfully", Status.FAIL);
		}*/

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
		report.updateTestLog("Verify New Contact Page Fields ", "Verifying Contacts is Displayed ", Status.PASS);
		Utility_Functions.xWaitForElementPresent(driver, newContact, 3);
		Utility_Functions.xClick(driver, newContact, true);
		Utility_Functions.timeWait(2);
		report.updateTestLog("Verify New Contact Page Fields ", "Verifying New Contacts Page is Displayed  ",
				Status.PASS);
		String environment = loginPage.initializeEnvironment();
		if (environment.equals("FTE")) {
			if (dataTable.getData("General_Data", "TC_ID").contains("OBAMERAdminContactsNewContactPageLayout")) {
				Utility_Functions.xSwitchtoFrame(driver, continueButton);
				Utility_Functions.xWaitForElementPresent(driver, continueButton, 5);
				Utility_Functions.timeWait(1);
				Utility_Functions.xClick(driver, continueButton, true);
				driver.switchTo().defaultContent();
			}
		}
		driver.navigate().refresh();
		Utility_Functions.xSwitchtoFrame(driver, lastNameQuickCreateContact);
		Utility_Functions.timeWait(3);
		System.out.println("Frame Identified");
		Utility_Functions.xScrollWindow(driver);
		Utility_Functions.timeWait(2);
		Utility_Functions.xScrollWindowTop(driver);
		Utility_Functions.timeWait(3);
		Utility_Functions.xWaitForElementPresent(driver, viewAllFieldsButton, 3);
		Utility_Functions.xClick(driver, viewAllFieldsButton, true);
		Utility_Functions.timeWait(2);
		List<WebElement> contactInformationFieldsList = driver.findElements(By.xpath(
				"//h2[text()='Contact Information']/parent::div/parent::div//div[@class='slds-form-element']/label"));
		int count = 0, i1 = 0;
		String labelArray[] = new String[contactInformationFieldsList.size()];
		System.out.println(contactInformationFieldsList.size());

		try {
			contactInformationSectionFields();
			for (WebElement element : contactInformationFieldsList) {
				System.out.println(element.getText());
				labelArray[i1] = element.getText();
				if (labelArray[i1].equalsIgnoreCase(contactInformationSectionList.get(i1))) {
					report.updateTestLog("Verify New Contact Page Layout",
							"Contact Information section is having the " + labelArray[i1] + " field ", Status.PASS);
					count++;
				}
				i1++;
			}
			System.out.println(count);
			if (count != 9) {
				report.updateTestLog("Verify New Contact Page Layout",
						"All Labels are not present in the Contact Information section", Status.FAIL);
			} else {

				report.updateTestLog("Verify New Contact Page Layout",
						"All Labels are present in the Contact Information section", Status.PASS);
			}

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		List<WebElement> contactPageSectionsList = driver
				.findElements(By.xpath("//div[contains(@class,'slds-col--padded')]/h2"));
		int count1 = 0, i2 = 0;
		String labelArray1[] = new String[contactPageSectionsList.size()];
		System.out.println(contactPageSectionsList.size());

		try {
			newContactPageSections();
			for (WebElement element1 : contactPageSectionsList) {
				System.out.println(element1.getText());
				labelArray1[i2] = element1.getText();
				if (labelArray[i2].equalsIgnoreCase(newContactPageSectionsList.get(i2))) {
					report.updateTestLog("Verify New Contact Page Layout",
							"Contacts page sections is having the " + labelArray[i2] + " section ", Status.PASS);
					count1++;
				}
				i2++;
			}
			System.out.println(count1);
			if (count1 != 4) {
				report.updateTestLog("Verify New Contact Page Layout",
						"All Labels are not present in the Contacts Page Sections", Status.FAIL);
			} else {

				report.updateTestLog("Verify New Contact Page Layout",
						"All Labels are present in the Contacts Page Sections", Status.PASS);
			}

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		String environment1 = loginPage.initializeEnvironment();
		if (environment1.equals("FTE")) {
			if (dataTable.getData("General_Data", "TC_ID").contains("OBAMERAdminContactsNewContactPageLayout")) {
				Utility_Functions.xWaitForElementPresent(driver, accountNameQuickCreateContact, 5);
				report.updateTestLog("Verify New Contact Page Layout",
						"Verifying Account name required field is populated ", Status.PASS);
				Utility_Functions.xWaitForElementPresent(driver, lastNameQuickCreateContact, 5);
				Utility_Functions.xSendKeys(driver, lastNameQuickCreateContact, "Test_Contact_Last_Name");
				Utility_Functions.xWaitForElementPresent(driver, directLine, 5);
				Utility_Functions.xSendKeys(driver, directLine, dataTable.getData("General_Data", "Direct Line"));
				String query = "SELECT Id, Name, EMEA_Searchable__c FROM Account where EMEA_Searchable__c = false limit 1 offset 9";
				String sAccountName = searchAccountName.fetchRecordFieldValue("Name", query);
				Utility_Functions.xSendKeys(driver, accountNameQuickCreateContact, sAccountName);
				accountNameQuickCreateContact.sendKeys(Keys.ARROW_DOWN);
				Utility_Functions.timeWait(2);
				accountNameQuickCreateContact.sendKeys(Keys.ENTER);
				Utility_Functions.timeWait(2);
				Utility_Functions.xWaitForElementPresent(driver, saveContact, 3);
				Utility_Functions.xClick(driver, saveContact, true);
				report.updateTestLog("Verify New Contact Page Layout",
						"Contact has been created successfully and have clicked on Save Button", Status.PASS);
				Utility_Functions.timeWait(3);
				if (details.isDisplayed()) {

					report.updateTestLog("Verify New Contact Page Layout", "Contact is saved with mandatory fields",
							Status.PASS);
				} else {
					report.updateTestLog("Verify New Contact Page Layout",
							"Contact is not saved with the mandatory fields", Status.FAIL);
				}
				Utility_Functions.xScrollWindow(driver);
				Utility_Functions.timeWait(1);
				Utility_Functions.xScrollWindowTop(driver);
				Utility_Functions.timeWait(2);
				List<WebElement> contactDetailsPageHeadersList = driver
						.findElements(By.xpath("//span[contains(@class,'header-title')]"));
				int count0 = 0, i0 = 0, j0 = 0;
				;
				String fieldsArray0[] = new String[contactDetailsPageHeadersList.size()];
				System.out.println(contactDetailsPageHeadersList.size());
				try {
					contactsDeatilsPageHeadersList.clear();
					contactsDetailsPageHeaders();
					while (j0 < contactDetailsPageHeadersList.size()) {
						for (WebElement element0 : contactDetailsPageHeadersList) {
							fieldsArray0[i0] = element0.getText();
							if (fieldsArray0[i0].contains(contactsDeatilsPageHeadersList.get(j0))) {
								System.out.println("Contacts Details page headers are " + element0.getText());
								report.updateTestLog("Verify New Contact Page Layout",
										" Contact Details Page are having the " + fieldsArray0[i0] + " Headers ",
										Status.PASS);
								count0++;
							}
							i0++;
						}
						i0 = 0;
						j0++;
					}
					System.out.println(count0);
					if (count0 != 6) {
						report.updateTestLog("Verify New Contact Page Layout",
								"All sections are not present in the Contacts Details Page", Status.FAIL);
					} else {

						report.updateTestLog("Verify New Contact Page Layout",
								"All sections are present in the Contacts Details Page", Status.PASS);
					}

				} catch (Exception e) {
					System.out.println(e.getMessage());
				}
				contactDetailsPageHeadersList.clear();
				List<WebElement> contactInformationFieldsLabels = driver.findElements(By.xpath(
						"//h3//span[text()='Contact Information']/ancestor::h3/parent::div/div[1]//span[contains(@class,'test-id__field-label')and text()!='']"));
				int count11 = 0, i11 = 0, j11 = 0;
				String fieldsArray11[] = new String[contactInformationFieldsLabels.size()];
				System.out.println(contactInformationFieldsLabels.size());
				try {
					contactInformationSectionFieldsList.clear();
					contactInformationDetailsPageFields();
					while (j11 < contactInformationFieldsLabels.size()) {
						for (WebElement element : contactInformationFieldsLabels) {
							fieldsArray11[i11] = element.getText();
							if (fieldsArray11[i11].contains(contactInformationSectionFieldsList.get(j11))) {
								System.out.println("Contact Information fields are " + element.getText());
								report.updateTestLog("Verify Contacts Landing Page",
										" Contact Information section is having the " + fieldsArray11[i11] + " fields ",
										Status.PASS);
								count11++;
							}
							i11++;
						}
						i11 = 0;
						j11++;
					}
					System.out.println(count11);
					if (count11 != 10) {
						report.updateTestLog("Verify New Contact Page Layout",
								"All fields are not present in the Contact Information Section", Status.FAIL);
					} else {

						report.updateTestLog("Verify New Contact Page Layout",
								"All fields are present in the Contact Information Section", Status.PASS);
					}
				} catch (Exception e) {
					System.out.println(e.getMessage());
				}
				contactInformationFieldsList.clear();
				List<WebElement> addressInformationFieldsList = driver.findElements(By.xpath(
						"//h3//span[text()='Address Information']/ancestor::h3/parent::div/div[1]//span[contains(@class,'test-id__field-label')and text()!='']"));
				int count10 = 0, i10 = 0, j10 = 0;
				String fieldsArray10[] = new String[addressInformationFieldsList.size()];
				System.out.println(addressInformationFieldsList.size());
				try {
					addressInformationSectionFieldsList.clear();
					addressInformationFields();
					while (j10 < addressInformationFieldsList.size()) {
						for (WebElement element1 : addressInformationFieldsList) {
							fieldsArray10[i10] = element1.getText();
							if (fieldsArray10[i10].contains(addressInformationSectionFieldsList.get(j10))) {
								System.out.println("Address Information fields are " + element1.getText());
								report.updateTestLog("Verify New Contact Page Layout",
										" Address Information Section is having the " + fieldsArray10[i10] + " fields ",
										Status.PASS);
								count10++;
							}
							i10++;
						}
						i10 = 0;
						j10++;
					}
					System.out.println(count10);
					if (count10 != 1) {
						report.updateTestLog("Verify New Contact Page Layout",
								"All fields are not present in the Address Information Section", Status.FAIL);
					} else {

						report.updateTestLog("Verify New Contact Page Layout",
								"All fields are present in the Address Information Section", Status.PASS);
					}
				} catch (Exception e) {
					System.out.println(e.getMessage());
				}
				addressInformationFieldsList.clear();
				List<WebElement> additionalInformationList = driver.findElements(By.xpath(
						"//h3//span[text()='Additional Information']/ancestor::h3/parent::div/div[1]//span[contains(@class,'test-id__field-label')and text()!='']"));
				int count5 = 0, i5 = 0, j = 0;
				String fieldsArray5[] = new String[additionalInformationList.size()];
				System.out.println(additionalInformationList.size());
				try {
					additionalInformationFieldsList.clear();
					additionalInformationFields();
					while (j < additionalInformationList.size()) {
						for (WebElement element5 : additionalInformationList) {
							fieldsArray5[i5] = element5.getText();
							if (fieldsArray5[i5].contains(additionalInformationFieldsList.get(j))) {
								System.out.println("Additional Information fields are " + element5.getText());
								report.updateTestLog("Verify New Contact Page Layout",
										element5.getText() + "labels  present in the Additional Information section ",
										Status.PASS);
								count5++;
							}
							i5++;
						}
						i5 = 0;
						j++;
					}
					System.out.println(count5);
					if (count5 < 3) {
						report.updateTestLog("Verify New Contact Page Layout",
								"All fields are not present in the Additional Information section", Status.FAIL);
					} else {
						report.updateTestLog("Verify New Contact Page Layout",
								"All fields are present in the Additional Information section", Status.PASS);
					}
				} catch (Exception e) {
					System.out.println(e.getMessage());
				}
				additionalInformationList.clear();
				List<WebElement> systemInformationList = driver.findElements(By.xpath(
						"//h3//span[text()='System Information']/ancestor::h3/parent::div/div[1]//span[contains(@class,'test-id__field-label')and text()!='']"));
				int count6 = 0, i6 = 0, j2 = 0;
				String fieldsArray6[] = new String[systemInformationList.size()];
				System.out.println(systemInformationList.size());
				try {
					systemInformationFieldsList.clear();
					systemInformationFields();
					while (j2 < systemInformationList.size()) {
						for (WebElement element6 : systemInformationList) {
							fieldsArray6[i6] = element6.getText();
							if (fieldsArray6[i6].contains(systemInformationFieldsList.get(j2))) {
								System.out.println("System Information fields are " + element6.getText());
								report.updateTestLog("Verify New Contact Page Layout",
										element6.getText() + "labels  present in the System Information section ",
										Status.PASS);
								count6++;
							}
							i6++;
						}
						i6 = 0;
						j2++;
					}
					System.out.println(count6);
					if (count6 != 4) {
						report.updateTestLog("Verify New Contact Page Layout",
								"All fields are not present in the Contact Information section", Status.FAIL);
					} else {
						report.updateTestLog("Verify New Contact Page Layout",
								"All fields are present in the Contact Information section", Status.PASS);
					}
				} catch (Exception e) {
					System.out.println(e.getMessage());
				}
				systemInformationList.clear();
				List<WebElement> customLinksList = driver
						.findElements(By.xpath("//h3//span[text()='Custom Links']/ancestor::h3/parent::div/div[1]//a"));
				int count7 = 0, i7 = 0, j1 = 0;
				String fieldsArray7[] = new String[customLinksList.size()];
				System.out.println(customLinksList.size());
				try {
					customLinksSectionFieldsList.clear();
					customLinksFields();
					while (j1 < customLinksList.size()) {
						for (WebElement element7 : customLinksList) {
							fieldsArray7[i7] = element7.getText();
							if (fieldsArray7[i7].contains(customLinksSectionFieldsList.get(j1))) {
								System.out.println("Custom Link fields are " + element7.getText());
								report.updateTestLog("Verify New Contact Page Layout",
										element7.getText() + "labels  present in the Custom Links ", Status.PASS);
								count7++;
							}
							i7++;
						}
						i7 = 0;
						j1++;
					}
					System.out.println(count7);
					if (count7 != 3) {
						report.updateTestLog("Verify New Contact Page Layout",
								"All fields are not present in the Custom Links section", Status.FAIL);
					} else {
						report.updateTestLog("Verify New Contact Page Layout",
								"All fields are present in the Custom Links section", Status.PASS);
					}
				} catch (Exception e) {
					System.out.println(e.getMessage());
				}
				customLinksList.clear();

			}

		}

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
		report.updateTestLog("Verify Contact Activity Reminder Functionality ", "Contacts is Displayed ", Status.PASS);
		Utility_Functions.xWaitForElementPresent(driver, recentlyViewed, 3);
		Utility_Functions.xClick(driver, recentlyViewed, true);
		report.updateTestLog("Verify Contact Activity Reminder Functionality  ",
				"Recently viewed Contacts are Displayed ", Status.PASS);
		Utility_Functions.xWaitForElementPresent(driver, allContacts, 3);
		Utility_Functions.xClick(driver, allContacts, true);
		Utility_Functions.timeWait(3);
		report.updateTestLog("Verify Contact Activity Reminder Functionality  ", "All Contacts are Displayed ",
				Status.PASS);
		List<WebElement> contactNamesList = driver.findElements(By.xpath(
				"//a[@class='slds-truncate outputLookupLink slds-truncate forceOutputLookup'][contains(@data-recordid,'003')]"));
		Utility_Functions.xclickRandomElement(contactNamesList);
		Utility_Functions.timeWait(3);
		report.updateTestLog("Verify Contact Activity Reminder Functionality ", "The Contact is Displayed ",
				Status.PASS);
		activityPage.createNewActivity();
		/*
		 * Utility_Functions.xWaitForElementPresent(driver, related, 3);
		 * Utility_Functions.xClick(driver, related, true); report.
		 * updateTestLog("Verify Contact Activity Reminder Functionality ",
		 * "The related page is Displayed ", Status.PASS);
		 * Utility_Functions.xScrollWindow(driver);
		 * Utility_Functions.timeWait(1);
		 * Utility_Functions.xScrollWindowTop(driver);
		 * Utility_Functions.timeWait(2);
		 * Utility_Functions.xWaitForElementPresent(driver, newActivity, 3);
		 * Utility_Functions.xClick(driver, newActivity, true); report.
		 * updateTestLog("Verify Contact Activity Reminder Functionality ",
		 * "The New Activity in the related page is Displayed ", Status.PASS);
		 * Utility_Functions.timeWait(2);
		 * Utility_Functions.xSwitchtoFrame(driver, subject);
		 * Utility_Functions.timeWait(3); List<WebElement>
		 * newActivityPageLayoutRequiredFields = driver
		 * .findElements(By.xpath("//label[@class='slds-form-element__label']"))
		 * ; int countRequiredFiles = 0; try { for (WebElement element :
		 * newActivityPageLayoutRequiredFields) { if
		 * ((element.getText().equals("*Subject"))) { System.out.
		 * println("Subject required field is present in the New Activity Layout Page"
		 * );
		 * report.updateTestLog("Verify Contact Activity Reminder Functionality"
		 * , "New Activity Layout Page is having the " + element.getText() +
		 * " Status field::", Status.PASS); countRequiredFiles++;
		 * 
		 * } else if ((element.getText().equals("*Activity Type"))) {
		 * System.out.
		 * println("Activity Type required field is present in the New Activity Layout Page"
		 * );
		 * report.updateTestLog("Verify Contact Activity Reminder Functionality"
		 * , "New Activity Layout Page is having the " + element.getText() +
		 * " Status field::", Status.PASS); countRequiredFiles++;
		 * 
		 * } else if ((element.getText().equals("*Assigned To"))) { System.out.
		 * println(" Assigned To required field is present in the New Activity Layout Page"
		 * );
		 * report.updateTestLog("Verify Contact Activity Reminder Functionality"
		 * , "New Activity Layout Page is having the " + element.getText() +
		 * " Status field::", Status.PASS); countRequiredFiles++;
		 * 
		 * } else if ((element.getText().equals("*Status"))) { System.out.
		 * println(" Status required field is present in the New Activity Layout Page"
		 * );
		 * report.updateTestLog("Verify Contact Activity Reminder Functionality"
		 * , "New Activity Layout Page is having the " + element.getText() +
		 * " Status field::", Status.PASS); countRequiredFiles++;
		 * 
		 * } else if ((element.getText().equals("*Priority"))) { System.out.
		 * println(" Priority required field is present in the New Activity Layout Page"
		 * );
		 * report.updateTestLog("Verify Contact Activity Reminder Functionality"
		 * , "New Activity Layout Page is having the " + element.getText() +
		 * " Status field::", Status.PASS); } }
		 * System.out.println(countRequiredFiles); if (countRequiredFiles != 4)
		 * { System.out.
		 * println("New Activity Page Layout does not contain the required fields "
		 * );
		 * report.updateTestLog("Verify Contact Activity Reminder Functionality"
		 * , "New Activity Layout Page is having all the required fields",
		 * Status.FAIL); }
		 * 
		 * } catch (Exception e) { e.printStackTrace();
		 * System.out.println(e.getMessage()); }
		 * Utility_Functions.xWaitForElementPresent(driver, subject, 5);
		 * Utility_Functions.xClick(driver, subject, true);
		 * Utility_Functions.xWaitForElementPresent(driver, subject, 5);
		 * Utility_Functions.xSendKeys(driver, subject, "test1");
		 * Utility_Functions.xWaitForElementPresent(driver, activityType1, 5);
		 * Utility_Functions.xClick(driver, activityType1, true); if
		 * (!setReminder.isSelected()) { Utility_Functions.xClick(driver,
		 * setReminder, true); System.out.println("Set Reminder is checked");
		 * report.
		 * updateTestLog("Verify Contact Activity Reminder Functionality ",
		 * "Verifying the Reminder sent check box is checked or else checking it"
		 * , Status.PASS); } else {
		 * System.out.println("Set Reminder is not checked"); report.
		 * updateTestLog("Verify Contact Activity Reminder Functionality ",
		 * "Verifying the Reminder sent  check box is checked or not ",
		 * Status.FAIL); } Utility_Functions.timeWait(2); Calendar calendar1 =
		 * Calendar.getInstance(); calendar1.add(Calendar.DAY_OF_MONTH, 10);
		 * SimpleDateFormat dateFormat1 = new
		 * SimpleDateFormat("MM/dd/yyyy hh:mm a"); System.out.println("Date : "
		 * + dateFormat1.format(calendar1.getTime()));
		 * Utility_Functions.xWaitForElementPresent(driver, dueDateNewActrivity,
		 * 3); Utility_Functions.xSendKeys(driver, dueDateNewActrivity,
		 * dateFormat1.format(calendar1.getTime()));
		 * Utility_Functions.xWaitForElementPresent(driver, saveActivity, 5);
		 * Utility_Functions.xClick(driver, saveActivity, true);
		 * Utility_Functions.timeWait(3); if (details.isDisplayed()) {
		 * 
		 * report.updateTestLog("Verify Contact Activity Reminder Functionality"
		 * , "Contacts Details page is displayed", Status.PASS); } else {
		 * report.updateTestLog("Verify Contact Activity Reminder Functionality"
		 * , "Contacts Details page is not displayed", Status.FAIL); }
		 */

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
		System.out.println("Address Information section fields are " + addressInformationSectionFieldsList);
	}

	static ArrayList<String> customLinksSectionFieldsList = new ArrayList<String>();

	public void customLinksFields() {
		customLinksSectionFieldsList.add("LinkedIn");
		customLinksSectionFieldsList.add("Google Maps");
		customLinksSectionFieldsList.add("Google Search");
		System.out.println("Custom Links fields are " + customLinksSectionFieldsList);
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
		System.out.println("Additional Information fields are " + additionalInformationFieldsList);
	}

	static ArrayList<String> systemInformationFieldsList = new ArrayList<String>();

	public void systemInformationFields() {
		systemInformationFieldsList.add("Contact Owner");
		systemInformationFieldsList.add("Last Manually Modified Date");
		systemInformationFieldsList.add("Created By");
		systemInformationFieldsList.add("Last Manually Modified By");
		System.out.println("System Information fields are " + systemInformationFieldsList);
	}

	static ArrayList<String> contactsDeatilsPageHeadersList = new ArrayList<String>();

	public void contactsDetailsPageHeaders() {
		contactsDeatilsPageHeadersList.add("Tagging");
		contactsDeatilsPageHeadersList.add("Contact Information");
		contactsDeatilsPageHeadersList.add("Address Information");
		contactsDeatilsPageHeadersList.add("Additional Information");
		contactsDeatilsPageHeadersList.add("Custom Links");
		contactsDeatilsPageHeadersList.add("System Information");
		if ((dataTable.getData("General_Data", "TC_ID").equals("AMERManagerContactsLandingPage"))
				|| (dataTable.getData("General_Data", "TC_ID").equals("AMERBrokerContactsLandingPage"))) {
			contactsDeatilsPageHeadersList.add("System Information");
		}
		System.out.println("Contact Details Page headers are:: " + contactsDeatilsPageHeadersList);
	}

	public void contactsVerifyLandingPage() {
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
		Utility_Functions.xScrollWindow(driver);
		Utility_Functions.timeWait(1);
		Utility_Functions.xScrollWindowTop(driver);
		Utility_Functions.timeWait(2);
		List<WebElement> contactDetailsPageHeadersList = driver
				.findElements(By.xpath("//span[contains(@class,'header-title')]"));
		int count0 = 0, i0 = 0, j0 = 0;
		;
		String fieldsArray0[] = new String[contactDetailsPageHeadersList.size()];
		System.out.println(contactDetailsPageHeadersList.size());
		try {
			contactsDeatilsPageHeadersList.clear();
			contactsDetailsPageHeaders();
			while (j0 < contactDetailsPageHeadersList.size()) {
				for (WebElement element0 : contactDetailsPageHeadersList) {
					fieldsArray0[i0] = element0.getText();
					if (fieldsArray0[i0].contains(contactsDeatilsPageHeadersList.get(j0))) {
						System.out.println("Contacts Details page headers are " + element0.getText());
						report.updateTestLog("Verify Contacts Landing Page",
								" Contact Details Page are having the " + fieldsArray0[i0] + " Headers ", Status.PASS);
						count0++;
					}
					i0++;
				}
				i0 = 0;
				j0++;
			}
			System.out.println(count0);
			if (count0 != 6) {
				report.updateTestLog("Verify Contacts Landing Page",
						"All sections are not present in the Contacts Details Page", Status.FAIL);
			} else {

				report.updateTestLog("Verify Leads Landing Page",
						"All sections are present in the Contacts Details Page", Status.PASS);
			}

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		contactDetailsPageHeadersList.clear();
		List<WebElement> contactInformationFieldsList = driver.findElements(By.xpath(
				"//h3//span[text()='Contact Information']/ancestor::h3/parent::div/div[1]//span[contains(@class,'test-id__field-label')and text()!='']"));
		int count = 0, i = 0, j4 = 0;
		String fieldsArray[] = new String[contactInformationFieldsList.size()];
		System.out.println(contactInformationFieldsList.size());
		try {
			contactInformationSectionFieldsList.clear();
			contactInformationDetailsPageFields();
			while (j4 < contactInformationFieldsList.size()) {
				for (WebElement element : contactInformationFieldsList) {
					fieldsArray[i] = element.getText();
					if (fieldsArray[i].contains(contactInformationSectionFieldsList.get(j4))) {
						System.out.println("Contact Information fields are " + element.getText());
						report.updateTestLog("Verify Contacts Landing Page",
								" Contact Information section is having the " + fieldsArray[i] + " fields ",
								Status.PASS);
						count++;
					}
					i++;
				}
				i = 0;
				j4++;
			}
			System.out.println(count);
			if (count != 10) {
				report.updateTestLog("Verify Contacts Landing Page",
						"All fields are not present in the Contact Information Section", Status.FAIL);
			} else {

				report.updateTestLog("Verify Contacts Landing Page",
						"All fields are present in the Contact Information Section", Status.PASS);
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		contactInformationFieldsList.clear();
		List<WebElement> addressInformationFieldsList = driver.findElements(By.xpath(
				"//h3//span[text()='Address Information']/ancestor::h3/parent::div/div[1]//span[contains(@class,'test-id__field-label')and text()!='']"));
		int count1 = 0, i1 = 0, j3 = 0;
		String fieldsArray1[] = new String[addressInformationFieldsList.size()];
		System.out.println(addressInformationFieldsList.size());
		try {
			addressInformationSectionFieldsList.clear();
			addressInformationFields();
			while (j3 < addressInformationFieldsList.size()) {
				for (WebElement element1 : addressInformationFieldsList) {
					fieldsArray1[i1] = element1.getText();
					if (fieldsArray1[i1].contains(addressInformationSectionFieldsList.get(j3))) {
						System.out.println("Address Information fields are " + element1.getText());
						report.updateTestLog("Verify Contacts Landing Page",
								" Address Information Section is having the " + fieldsArray1[i1] + " fields ",
								Status.PASS);
						count1++;
					}
					i1++;
				}
				i1 = 0;
				j3++;
			}
			System.out.println(count1);
			if (count1 != 1) {
				report.updateTestLog("Verify Contacts Landing Page",
						"All fields are not present in the Address Information Section", Status.FAIL);
			} else {

				report.updateTestLog("Verify Contacts Landing Page",
						"All fields are present in the Address Information Section", Status.PASS);
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		addressInformationFieldsList.clear();
		List<WebElement> additionalInformationList = driver.findElements(By.xpath(
				"//h3//span[text()='Additional Information']/ancestor::h3/parent::div/div[1]//span[contains(@class,'test-id__field-label')and text()!='']"));
		int count5 = 0, i5 = 0, j = 0;
		String fieldsArray5[] = new String[additionalInformationList.size()];
		System.out.println(additionalInformationList.size());
		try {
			additionalInformationFieldsList.clear();
			additionalInformationFields();
			while (j < additionalInformationList.size()) {
				for (WebElement element5 : additionalInformationList) {
					fieldsArray5[i5] = element5.getText();
					if (fieldsArray5[i5].contains(additionalInformationFieldsList.get(j))) {
						System.out.println("Additional Information fields are " + element5.getText());
						report.updateTestLog("Verify Contacts Landing Page",
								element5.getText() + "labels  present in the Additional Information section ",
								Status.PASS);
						count5++;
					}
					i5++;
				}
				i5 = 0;
				j++;
			}
			System.out.println(count5);
			if (count5 < 3) {
				report.updateTestLog("Verify Contacts Landing Page",
						"All fields are not present in the Additional Information section", Status.FAIL);
			} else {
				report.updateTestLog("Verify Contacts Landing Page",
						"All fields are present in the Additional Information section", Status.PASS);
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		additionalInformationList.clear();
		List<WebElement> systemInformationList = driver.findElements(By.xpath(
				"//h3//span[text()='System Information']/ancestor::h3/parent::div/div[1]//span[contains(@class,'test-id__field-label')and text()!='']"));
		int count6 = 0, i6 = 0, j2 = 0;
		String fieldsArray6[] = new String[systemInformationList.size()];
		System.out.println(systemInformationList.size());
		try {
			systemInformationFieldsList.clear();
			systemInformationFields();
			while (j2 < systemInformationList.size()) {
				for (WebElement element6 : systemInformationList) {
					fieldsArray6[i6] = element6.getText();
					if (fieldsArray6[i6].contains(systemInformationFieldsList.get(j2))) {
						System.out.println("System Information fields are " + element6.getText());
						report.updateTestLog("Verify Contacts Landing Page",
								element6.getText() + "labels  present in the System Information section ", Status.PASS);
						count6++;
					}
					i6++;
				}
				i6 = 0;
				j2++;
			}
			System.out.println(count6);
			if (count6 != 4) {
				report.updateTestLog("Verify Contacts Landing Page",
						"All fields are not present in the Contact Information section", Status.FAIL);
			} else {
				report.updateTestLog("Verify Contacts Landing Page",
						"All fields are present in the Contact Information section", Status.PASS);
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		systemInformationList.clear();
		List<WebElement> customLinksList = driver
				.findElements(By.xpath("//h3//span[text()='Custom Links']/ancestor::h3/parent::div/div[1]//a"));
		int count7 = 0, i7 = 0, j1 = 0;
		String fieldsArray7[] = new String[customLinksList.size()];
		System.out.println(customLinksList.size());
		try {
			customLinksSectionFieldsList.clear();
			customLinksFields();
			while (j1 < customLinksList.size()) {
				for (WebElement element7 : customLinksList) {
					fieldsArray7[i7] = element7.getText();
					if (fieldsArray7[i7].contains(customLinksSectionFieldsList.get(j1))) {
						System.out.println("Custom Link fields are " + element7.getText());
						report.updateTestLog("Verify Contacts Landing Page ",
								element7.getText() + "labels  present in the Custom Links ", Status.PASS);
						count7++;
					}
					i7++;
				}
				i7 = 0;
				j1++;
			}
			System.out.println(count7);
			if (count7 != 3) {
				report.updateTestLog("Verify Contacts Landing Page",
						"All fields are not present in the Custom Links section", Status.FAIL);
			} else {
				report.updateTestLog("Verify Contacts Landing Page",
						"All fields are present in the Custom Links section", Status.PASS);
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		customLinksList.clear();
	}

	/**
	 * Validating the creation of SPOCs in the Accounts
	 * 
	 * @author Ramya
	 *
	 */
	public void verifyContactsActivityTimeline() {

		Utility_Functions.xWaitForElementPresent(driver, menu_Contacts, 3);
		Utility_Functions.xClick(driver, menu_Contacts, true);
		report.updateTestLog("Verify Contact Activity Timeline ", "Contacts is Displayed ", Status.PASS);
		Utility_Functions.xWaitForElementPresent(driver, recentlyViewed, 3);
		Utility_Functions.xClick(driver, recentlyViewed, true);
		report.updateTestLog("Verify Contact Activity Timeline ", "Recently viewed Contacts are Displayed ",
				Status.PASS);
		Utility_Functions.xWaitForElementPresent(driver, allContacts, 3);
		Utility_Functions.xClick(driver, allContacts, true);
		Utility_Functions.timeWait(3);
		report.updateTestLog("Verify Contact Activity Timeline", "All Contacts are Displayed ", Status.PASS);
		List<WebElement> contactNamesList = driver.findElements(By.xpath(
				"//a[@class='slds-truncate outputLookupLink slds-truncate forceOutputLookup'][contains(@data-recordid,'003')]"));

		Utility_Functions.xclickRandomElement(contactNamesList);
		Utility_Functions.timeWait(3);
		report.updateTestLog("Verify Contact Activity Timeline ", "The Contact is Displayed ", Status.PASS);
		Utility_Functions.xWaitForElementPresent(driver, addActivity, 3);
		Utility_Functions.xClick(driver, addActivity, true);
		activityPage.verifyNewActivityPageLayout();
		activityPage.validateActivityTimeLine();

		/*
		 * Utility_Functions.xWaitForElementPresent(driver, related, 3);
		 * Utility_Functions.xClick(driver, related, true);
		 * report.updateTestLog("Verify Contact Activity Timeline ",
		 * "The related page is Displayed ", Status.PASS);
		 * Utility_Functions.xScrollWindow(driver);
		 * Utility_Functions.timeWait(1);
		 * Utility_Functions.xScrollWindowTop(driver);
		 * Utility_Functions.timeWait(2); try {
		 * Utility_Functions.xWaitForElementPresent(driver, newActivity, 3);
		 * Utility_Functions.xClick(driver, newActivity, true); } catch
		 * (Exception e1) { Utility_Functions.xWaitForElementPresent(driver,
		 * newActivityHeader, 3); Utility_Functions.xClick(driver,
		 * newActivityHeader, true); }
		 * report.updateTestLog("Verify Contact Activity Timeline",
		 * "The New Activity in the related page is Displayed ", Status.PASS);
		 * Utility_Functions.timeWait(1);
		 * Utility_Functions.xSwitchtoFrame(driver, saveAndNewActivity);
		 * Utility_Functions.timeWait(4);
		 * Utility_Functions.xWaitForElementPresent(driver, subject, 5);
		 * Utility_Functions.xSendKeys(driver, subject,
		 * "Test Automation Subject_" +
		 * Utility_Functions.xGenerateAlphaNumericString());
		 * Utility_Functions.xWaitForElementPresent(driver,
		 * activityTypeFollowUpTaskValue, 3); Utility_Functions.xClick(driver,
		 * activityTypeFollowUpTaskValue, true); Calendar calendar =
		 * Calendar.getInstance(); calendar.add(Calendar.DAY_OF_MONTH, -20);
		 * SimpleDateFormat dateFormat = new
		 * SimpleDateFormat("MM/dd/yyyy hh:mm a"); System.out.println("Date : "
		 * + dateFormat.format(calendar.getTime()));
		 * Utility_Functions.xWaitForElementPresent(driver, newActivityDueDate,
		 * 3); Utility_Functions.xSendKeys(driver, newActivityDueDate,
		 * dateFormat.format(calendar.getTime()));
		 * Utility_Functions.xWaitForElementPresent(driver, saveActivity, 5);
		 * Utility_Functions.xClick(driver, saveActivity, true);
		 * Utility_Functions.timeWait(4); driver.navigate().refresh();
		 * Utility_Functions.timeWait(4);
		 * Utility_Functions.xWaitForElementPresent(driver, related, 5);
		 * report.updateTestLog("Verify Contact Activity Timeline ",
		 * "The Account is Displayed ", Status.PASS);
		 * Utility_Functions.xClick(driver, related, true);
		 * Utility_Functions.timeWait(2);
		 * report.updateTestLog("Verify Contact Activity Timeline",
		 * "The related page is Displayed ", Status.PASS);
		 * Utility_Functions.xScrollWindow(driver);
		 * Utility_Functions.timeWait(1);
		 * Utility_Functions.xScrollWindowTop(driver);
		 * Utility_Functions.timeWait(2); try {
		 * Utility_Functions.xWaitForElementPresent(driver, newActivity, 3);
		 * Utility_Functions.xClick(driver, newActivity, true); } catch
		 * (Exception e1) { Utility_Functions.xWaitForElementPresent(driver,
		 * newActivityHeader, 3); Utility_Functions.xClick(driver,
		 * newActivityHeader, true); }
		 * report.updateTestLog("Verify Contact Activity Timeline",
		 * "The New Activity in the related page is Displayed ", Status.PASS);
		 * Utility_Functions.xSwitchtoFrame(driver, saveAndNewActivity);
		 * Utility_Functions.timeWait(3);
		 * Utility_Functions.xWaitForElementPresent(driver, subject, 5);
		 * Utility_Functions.xSendKeys(driver, subject,
		 * "Test Automation Subject_" +
		 * Utility_Functions.xGenerateAlphaNumericString());
		 * Utility_Functions.xWaitForElementPresent(driver,
		 * activityTypeFollowUpTaskValue, 3); Utility_Functions.xClick(driver,
		 * activityTypeFollowUpTaskValue, true); Calendar calendar1 =
		 * Calendar.getInstance(); calendar1.add(Calendar.DAY_OF_MONTH, 10);
		 * SimpleDateFormat dateFormat1 = new
		 * SimpleDateFormat("MM/dd/yyyy hh:mm a"); System.out.println("Date : "
		 * + dateFormat1.format(calendar1.getTime()));
		 * Utility_Functions.xWaitForElementPresent(driver, newActivityDueDate,
		 * 3); Utility_Functions.xSendKeys(driver, newActivityDueDate,
		 * dateFormat1.format(calendar1.getTime()));
		 * Utility_Functions.xWaitForElementPresent(driver, saveActivity, 5);
		 * Utility_Functions.xClick(driver, saveActivity, true);
		 * Utility_Functions.timeWait(4); driver.navigate().refresh();
		 * Utility_Functions.timeWait(4);
		 * Utility_Functions.xWaitForElementPresent(driver, activityTab, 5);
		 * Utility_Functions.xClick(driver, activityTab, true); int count = 0;
		 * try { if (activityTimeline.isDisplayed()) { System.out.println(
		 * "There are no activities for present, past and future dates in acitivity related list"
		 * ); report.updateTestLog("Verify Accounts Activity Timeline",
		 * "There are no activities for present, past and future dates in acitivity related list:::"
		 * , Status.PASS); count++; } } catch (Exception e) { if
		 * (activity.isDisplayed()) {
		 * System.out.println("Activity is present acitivity related list");
		 * report.updateTestLog("Verify Contact Activity Timeline",
		 * "Acitivity is present in acitivity related list:::", Status.PASS); if
		 * (activityType.getText().contains("Activity Type")) {
		 * System.out.println("Activity Type is present acitivity related list"
		 * ); report.updateTestLog("Verify Activity Related List",
		 * "Acitivity Type is present in acitivity related list:::",
		 * Status.PASS); count++; } if
		 * (statusActivityTimeLine.getText().contains("Status")) {
		 * System.out.println("Status is present acitivity related list");
		 * report.updateTestLog("Verify Contact Activity Timeline",
		 * "Status is present in acitivity related list:::", Status.PASS);
		 * count++; } if (comments.getText().contains("Comments")) { System.out.
		 * println("Comments sections is present acitivity related list");
		 * report.updateTestLog("Verify Contact Activity Timeline",
		 * "Comments section is present in acitivity related list:::",
		 * Status.PASS); count++; } if (dueDate.isDisplayed()) {
		 * System.out.println("Duedate is present acitivity related list");
		 * report.updateTestLog("Verify Contact Activity Timeline",
		 * "Duedate is present in acitivity related list:::", Status.PASS);
		 * count++; } if (statusCheckbox.isDisplayed()) { System.out.
		 * println("Status Checkbox is present acitivity related list");
		 * report.updateTestLog("Verify Contact Activity Timeline",
		 * "Status Checkbox is present in acitivity related list:::",
		 * Status.PASS); } } if (count == 4) { System.out.println(
		 * "Activity Type, Due Date, Comments and Status Checkbox are present under acitivity related list"
		 * ); report.updateTestLog("Verify Contact Activity Timeline",
		 * "Activity Type, Due Date, Comments and Status Checkbox are present under activity related list:::"
		 * , Status.PASS); } else if (count == 1) { System.out.println(
		 * "There are no activities for present, past and future dates in acitivity related list"
		 * ); } else { System.out.println(
		 * "Activity Type, Due Date, Comments and Status Checkbox are not present under acitivity related list"
		 * ); report.updateTestLog("Verify Contact Activity Timeline",
		 * "Activity Type, Due Date, Comments and Status Checkbox are not present under activity related list:::"
		 * , Status.FAIL); } // System.out.println(e.getMessage()); } try {
		 * Utility_Functions.xWaitForElementPresent(driver, pastActivity, 5);
		 * Utility_Functions.xClick(driver, pastActivity, true);
		 * report.updateTestLog("Verify Contact Activity Timeline",
		 * "The Past Activities is Clicked successfully", Status.PASS); } catch
		 * (Exception e) { System.out.println(e.getMessage()); }
		 * Utility_Functions.xWaitForElementPresent(driver, moreActivities, 5);
		 * Utility_Functions.xClick(driver, moreActivities, true);
		 * report.updateTestLog("Verify Contact Activity Timeline",
		 * "The More Activities is Clicked successfully", Status.PASS);
		 */
	}

	/**
	 * Validating the updation of contact records
	 * 
	 * @author Ramya
	 *
	 */
	public void verifyUpdationOfContactRecord() {

		Utility_Functions.xWaitForElementPresent(driver, menu_Contacts, 3);
		Utility_Functions.xClick(driver, menu_Contacts, true);
		report.updateTestLog("Verify Contact Record Updation ", "Contacts is Displayed ", Status.PASS);
		Utility_Functions.xWaitForElementPresent(driver, recentlyViewed, 3);
		Utility_Functions.xClick(driver, recentlyViewed, true);
		report.updateTestLog("Verify Contact Record Updation", "Recently viewed Contacts are Displayed ", Status.PASS);
		Utility_Functions.xWaitForElementPresent(driver, allContacts, 3);
		Utility_Functions.xClick(driver, allContacts, true);
		Utility_Functions.timeWait(3);
		report.updateTestLog("Verify Contact Record Updation", "All Contacts are Displayed ", Status.PASS);
		List<WebElement> contactNamesList = driver.findElements(By.xpath(
				"//a[@class='slds-truncate outputLookupLink slds-truncate forceOutputLookup'][contains(@data-recordid,'003')]"));

		Utility_Functions.xclickRandomElement(contactNamesList);
		Utility_Functions.timeWait(3);
		try {
			Utility_Functions.xWaitForElementPresent(driver, edit, 3);
			Utility_Functions.xClick(driver, edit, true);
		} catch (Exception e) {

			Utility_Functions.xWaitForElementPresent(driver, showMoreActionsDetailsPage, 3);
			Utility_Functions.xClick(driver, showMoreActionsDetailsPage, true);
			Utility_Functions.xWaitForElementPresent(driver, showMoreActionsEdit, 3);
			Utility_Functions.xClick(driver, showMoreActionsEdit, true);

		}
		Utility_Functions.timeWait(2);
		Utility_Functions.xScrollWindow(driver);
		Utility_Functions.timeWait(1);
		Utility_Functions.xScrollWindowTop(driver);
		Utility_Functions.timeWait(4);
		try {
			Utility_Functions.xWaitForElementPresent(driver, firstNameEditPage, 5);
			String value = Utility_Functions.xGenerateAlphaNumericString();
			String accountName = value + "Test Automation";
			Utility_Functions.xSendKeys(driver, firstNameEditPage, accountName);
			Utility_Functions.xWaitForElementPresent(driver, lastNameEditPage, 5);
			String value2 = Utility_Functions.xGenerateAlphaNumericString();
			String accountName2 = value2 + "Automation";
			Utility_Functions.xSendKeys(driver, lastNameEditPage, accountName2);
			Utility_Functions.xWaitForElementPresent(driver, directLineEditPage, 2);
			Utility_Functions.xSendKeys(driver, directLineEditPage, dataTable.getData("General_Data", "Direct Line"));
			if (dataTable.getData("General_Data", "TC_ID").contains("OBEMEA")) {
				Utility_Functions.xWaitForElementPresent(driver, emailEditPage, 5);
				Utility_Functions.xClick(driver, emailEditPage, true);
				Utility_Functions.xWaitForElementPresent(driver, emailEditPage, 2);
				Utility_Functions.xSendKeys(driver, emailEditPage, dataTable.getData("General_Data", "Email"));
			}
			Utility_Functions.xWaitForElementPresent(driver, saveEditPage, 3);
			Utility_Functions.xClick(driver, saveEditPage, true);
			Utility_Functions.timeWait(2);
			driver.navigate().refresh();
			Utility_Functions.timeWait(2);
			Utility_Functions.xWaitForElementPresent(driver, details, 3);
			if (details.isDisplayed()) {

				report.updateTestLog("Verify Contact Record Updation",
						"The existing record can be updated and saved successfully", Status.PASS);
			} else {
				report.updateTestLog("Verify Contact Record Updation",
						"The existing record cannot be updated and saved successfully", Status.FAIL);
			}
		} catch (Exception e) {
			report.updateTestLog("Verify Contact Record Updation",
					"The record cannot be updated as the First name, Last name and Direct Line cannot be edited",
					Status.PASS);

		}

	}

	/**
	 * Validating the New Contact Page layout
	 * 
	 * @author Ramya
	 *
	 */

	static ArrayList<String> headerSectionList = new ArrayList<String>();

	public void headerSectionNewContactPage() {

		headerSectionList.add("Contact Information");
		headerSectionList.add("Communication Preferences");
		headerSectionList.add("Additional Information");
		headerSectionList.add("System Information");

		System.out.println("Header Sections present in the new contact page are:: " + headerSectionList);
	}

	static ArrayList<String> newContactInformationSectionList = new ArrayList<String>();

	public void newContactInformationSection() {

		newContactInformationSectionList.add("Middle Name");
		newContactInformationSectionList.add("Nickname");
		newContactInformationSectionList.add("Department");
		newContactInformationSectionList.add("Influence Level");
		newContactInformationSectionList.add("Reports To");
		newContactInformationSectionList.add("Mobile");
		newContactInformationSectionList.add("Main Phone");
		newContactInformationSectionList.add("Inactive Contact");
		newContactInformationSectionList.add("Contact Record Type");

		System.out.println("Contact Information section fields  are:: " + newContactInformationSectionList);
	}

	static ArrayList<String> newContactInformationSectionListAdmin = new ArrayList<String>();

	public void newContactInformationSectionAdmin() {

		newContactInformationSectionListAdmin.add("Middle Name");
		newContactInformationSectionListAdmin.add("Nickname");
		newContactInformationSectionListAdmin.add("Department");
		newContactInformationSectionListAdmin.add("Influence Level");
		newContactInformationSectionListAdmin.add("Reports To");
		newContactInformationSectionListAdmin.add("Mobile");
		newContactInformationSectionListAdmin.add("Main Phone");
		newContactInformationSectionListAdmin.add("Reason for Inactivating");
		newContactInformationSectionListAdmin.add("Inactive Contact");
		newContactInformationSectionListAdmin.add("Contact Record Type");

		System.out.println("Contact Information section fields  are:: " + newContactInformationSectionListAdmin);
	}

	static ArrayList<String> InfluenceLevelFieldPickListValuesList = new ArrayList<String>();

	public void InfluenceLevelFieldPickList() {
		InfluenceLevelFieldPickListValuesList.add("--None--");
		InfluenceLevelFieldPickListValuesList.add("Low");
		InfluenceLevelFieldPickListValuesList.add("Medium");
		InfluenceLevelFieldPickListValuesList.add("High");
		System.out.println("Influence Level field pick list values  are:: " + InfluenceLevelFieldPickListValuesList);
	}

	static ArrayList<String> statusFieldPickListValuesList = new ArrayList<String>();

	public void statusFieldPickList() {

		statusFieldPickListValuesList.add("Active");
		statusFieldPickListValuesList.add("Inactive");

		System.out.println("Status field pick list values  are:: " + statusFieldPickListValuesList);
	}

	static ArrayList<String> communicationPreferencesSectionList = new ArrayList<String>();

	public void communicationPreferencesList() {

		communicationPreferencesSectionList.add("Email Options");
		communicationPreferencesSectionList.add("Mail Options");
		communicationPreferencesSectionList.add("Call Options");

		System.out.println("Communication Preferences section fields are:: " + communicationPreferencesSectionList);
	}

	static ArrayList<String> communicationPreferencesSectionListAPAC = new ArrayList<String>();

	public void communicationPreferencesListAPAC() {

		communicationPreferencesSectionListAPAC.add("Email Options");
		communicationPreferencesSectionListAPAC.add("Mail Options");
		communicationPreferencesSectionListAPAC.add("Call Options");
		communicationPreferencesSectionListAPAC.add("Exclude Reason");
		communicationPreferencesSectionListAPAC.add("Excluded On");
		communicationPreferencesSectionListAPAC.add("Excluded By");

		System.out.println("Communication Preferences section fields are:: " + communicationPreferencesSectionListAPAC);
	}

	static ArrayList<String> communicationPreferencesSectionListAdmin = new ArrayList<String>();

	public void communicationPreferencesListAdmin() {

		communicationPreferencesSectionListAdmin.add("Preferred Comm Method");
		communicationPreferencesSectionListAdmin.add("Email Options");
		communicationPreferencesSectionListAdmin.add("Mail Options");
		communicationPreferencesSectionListAdmin.add("Call Options");
		communicationPreferencesSectionListAdmin.add("Exclude Reason");
		communicationPreferencesSectionListAdmin.add("Excluded On");
		communicationPreferencesSectionListAdmin.add("Excluded By");
		communicationPreferencesSectionListAdmin.add("Dietary Requirements");

		System.out
				.println("Communication Preferences section fields are:: " + communicationPreferencesSectionListAdmin);
	}

	static ArrayList<String> excludeReasonPickListValuesList = new ArrayList<String>();

	public void excludeReasonsPickList() {

		excludeReasonPickListValuesList.add("--None--");
		excludeReasonPickListValuesList.add("Archived");
		excludeReasonPickListValuesList.add("CL Suppression");
		excludeReasonPickListValuesList.add("Email Bounce Back");
		excludeReasonPickListValuesList.add("Insufficient address");
		excludeReasonPickListValuesList.add("Left Address");
		excludeReasonPickListValuesList.add("Return to Sender");
		excludeReasonPickListValuesList.add("Undelivered");
		excludeReasonPickListValuesList.add("Unsubscribe");

		System.out.println("Email Option pick list values  are:: " + emailOptionsPickListValuesList);
	}

	static ArrayList<String> emailOptionsPickListValuesList = new ArrayList<String>();

	public void emailOptionsPickList() {

		emailOptionsPickListValuesList.add("--None--");
		emailOptionsPickListValuesList.add("Email Opt In");
		emailOptionsPickListValuesList.add("Email Opt Out");

		System.out.println("Email Option pick list values  are:: " + emailOptionsPickListValuesList);
	}

	static ArrayList<String> mailOptionsPickListValuesList = new ArrayList<String>();

	public void mailOptionsPickList() {

		mailOptionsPickListValuesList.add("--None--");
		mailOptionsPickListValuesList.add("Mail Opt In");
		mailOptionsPickListValuesList.add("Mail Opt Out");

		System.out.println("Mail Option pick list values  are:: " + mailOptionsPickListValuesList);
	}

	static ArrayList<String> callOptionsPickListValuesList = new ArrayList<String>();

	public void callOptionsPickList() {

		callOptionsPickListValuesList.add("--None--");
		callOptionsPickListValuesList.add("Call Opt In");
		callOptionsPickListValuesList.add("Call Opt Out");

		System.out.println("Call Option pick list values  are:: " + callOptionsPickListValuesList);
	}

	static ArrayList<String> additionalInformationSectionList = new ArrayList<String>();

	public void additionalInformationSectionList() {

		additionalInformationSectionList.add("Fax");
		additionalInformationSectionList.add("Preferred Comm Method");
		additionalInformationSectionList.add("Comm Email Sent");
		additionalInformationSectionList.add("Reason for Inactivating");
		additionalInformationSectionList.add("Inactivation Date");
		additionalInformationSectionList.add("Assistant Name");
		additionalInformationSectionList.add("Assistant Phone");
		additionalInformationSectionList.add("Assistant Email");

		System.out.println("Additional Information section fields  are:: " + additionalInformationSectionList);
	}

	static ArrayList<String> additionalInformationSectionListAdmin = new ArrayList<String>();

	public void additionalInformationSectionAdmin() {

		additionalInformationSectionListAdmin.add("Fax");
		additionalInformationSectionListAdmin.add("Integration Id");
		additionalInformationSectionListAdmin.add("Comm Email Sent");
		additionalInformationSectionListAdmin.add("Inactivation Date");
		additionalInformationSectionListAdmin.add("Source System");
		additionalInformationSectionListAdmin.add("Assistant Phone");
		additionalInformationSectionListAdmin.add("Assistant Name");
		additionalInformationSectionListAdmin.add("Assistant Email");
		additionalInformationSectionListAdmin.add("Inactive Date");
		additionalInformationSectionListAdmin.add("Source Created Date Time");
		additionalInformationSectionListAdmin.add("Source Last Updated Date Time");
		additionalInformationSectionListAdmin.add("CIF Source System ID");

		System.out.println("Additional Information section fields  are:: " + additionalInformationSectionListAdmin);
	}

	static ArrayList<String> preferredCommMethodPickListValuesList = new ArrayList<String>();

	public void preferredCommMethodPickList() {

		preferredCommMethodPickListValuesList.add("--None--");
		preferredCommMethodPickListValuesList.add("Call");
		preferredCommMethodPickListValuesList.add("Email");
		preferredCommMethodPickListValuesList.add("Mail");

		System.out.println("Preferred Comm method pick list values  are:: " + preferredCommMethodPickListValuesList);
	}

	static ArrayList<String> reasonForInactivatingPickListValuesList = new ArrayList<String>();

	public void reasonForInactivatingPickList() {

		reasonForInactivatingPickListValuesList.add("--None--");
		reasonForInactivatingPickListValuesList.add("Deceased");
		reasonForInactivatingPickListValuesList.add("No Longer with the Company");
		reasonForInactivatingPickListValuesList.add("Retired");
		reasonForInactivatingPickListValuesList.add("Duplication");

		System.out
				.println("Reason for Inactivating pick list values  are:: " + reasonForInactivatingPickListValuesList);
	}

	static ArrayList<String> systemInformationSectionList = new ArrayList<String>();

	public void systemInformationSectionList() {

		systemInformationSectionList.add("Contact Owner");

		System.out.println("System Information section fields  are:: " + systemInformationSectionList);
	}

	public void contactsNewContactPageLayout() {
		
		ContactsFunctions contactsFunctions = new ContactsFunctions(scriptHelper);
		contactsFunctions.contactsPageFieldsValidation();

		/*Utility_Functions.xWaitForElementPresent(driver, menu_Contacts, 3);
		Utility_Functions.xClick(driver, menu_Contacts, true);
		Utility_Functions.timeWait(1);
		report.updateTestLog("Verify New Contact Page Layout ", "Verifying Contacts is Displayed ", Status.PASS);
		Utility_Functions.xWaitForElementPresent(driver, newContact, 3);
		Utility_Functions.xClick(driver, newContact, true);
		Utility_Functions.timeWait(2);
		report.updateTestLog("Verify New Contact Page Layout ", "Verifying New Contacts Page is Displayed  ",
				Status.PASS);
		if (dataTable.getData("General_Data", "TC_ID").contains("Admin")) {

			Utility_Functions.xSwitchtoFrame(driver, continueButtonNewContact);
			Utility_Functions.xWaitForElementPresent(driver, continueButtonNewContact, 3);
			Utility_Functions.xClick(driver, continueButtonNewContact, true);
			Utility_Functions.timeWait(2);
		}
		Utility_Functions.xSwitchtoFrame(driver, viewAllFieldsButton);
		Utility_Functions.xScrollWindow(driver);
		Utility_Functions.timeWait(1);
		Utility_Functions.xWaitForElementPresent(driver, viewAllFieldsButton, 5);
		Utility_Functions.xClick(driver, viewAllFieldsButton, true);
		Utility_Functions.timeWait(1);
		Utility_Functions.xScrollWindowTop(driver);
		Utility_Functions.timeWait(5);

		List<WebElement> newContactPageSectionsList = driver.findElements(
				By.xpath("//h2[@class='slds-text-heading--medium slds-m-top--x-large slds-m-bottom--large']"));
		int count2 = 0, i2 = 0;
		String fieldsArray2[] = new String[newContactPageSectionsList.size()];
		System.out.println(newContactPageSectionsList.size());

		try {
			headerSectionNewContactPage();
			for (WebElement element2 : newContactPageSectionsList) {
				System.out.println(element2.getText());
				fieldsArray2[i2] = element2.getText();
				if (fieldsArray2[i2].contains(headerSectionList.get(i2))) {
					report.updateTestLog("Verify New Contact Page Layout ",
							"Contact Information section is having the " + fieldsArray2[i2] + " sections ",
							Status.PASS);
					count2++;
				}
				i2++;
			}
			System.out.println(count2);
			if (count2 != 4) {
				report.updateTestLog("Verify New Contact Page Layout",
						"All sections are not present in the New Contact Page ", Status.FAIL);
			} else {

				report.updateTestLog("Verify New Contact Page Layout",
						"All sections are present in the New Contact Page", Status.PASS);
			}

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		newContactPageSectionsList.clear();

		if (!(dataTable.getData("General_Data", "TC_ID").contains("Admin"))) {
			List<WebElement> contactInformationSectionList = driver.findElements(By.xpath(
					"//h2[text()='Contact Information']/parent::div/parent::div/div//label[@class='slds-form-element__label']"));
			int count1 = 0, i1 = 0;
			String fieldsArray1[] = new String[contactInformationSectionList.size()];
			System.out.println(contactInformationSectionList.size());

			try {
				newContactInformationSection();
				for (WebElement element1 : contactInformationSectionList) {
					System.out.println(element1.getText());
					fieldsArray1[i1] = element1.getText();
					if (fieldsArray1[i1].contains(newContactInformationSectionList.get(i1))) {
						report.updateTestLog("Verify New Contact Page Layout ",
								"Contact Information section is having the " + fieldsArray1[i1] + " fields ",
								Status.PASS);
						count1++;
					}
					i1++;
				}
				System.out.println(count1);
				if (count1 != 9) {
					report.updateTestLog("Verify New Contact Page Layout",
							"All fields are not present in the Contact Information section ", Status.FAIL);
				} else {

					report.updateTestLog("Verify New Contact Page Layout",
							"All fields are present in the Contact Information section", Status.PASS);
				}

			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
			contactInformationSectionList.clear();
		} else if (dataTable.getData("General_Data", "TC_ID").contains("OBAMERAdmin")) {
			List<WebElement> contactInformationSectionListAdmin = driver.findElements(By.xpath(
					"//h2[text()='Contact Information']/parent::div/parent::div/div//label[@class='slds-form-element__label']"));
			int count20 = 0, i20 = 0;
			String fieldsArray20[] = new String[contactInformationSectionListAdmin.size()];
			System.out.println(contactInformationSectionListAdmin.size());

			try {
				newContactInformationSectionAdmin();
				for (WebElement element20 : contactInformationSectionListAdmin) {
					System.out.println(element20.getText());
					fieldsArray20[i20] = element20.getText();
					if (fieldsArray20[i20].contains(newContactInformationSectionListAdmin.get(i20))) {
						report.updateTestLog("Verify New Contact Page Layout ",
								"Contact Information section is having the " + fieldsArray20[i20] + " fields ",
								Status.PASS);
						count20++;
					}
					i20++;
				}
				System.out.println(count20);
				if (count20 != 10) {
					report.updateTestLog("Verify New Contact Page Layout",
							"All fields are not present in the Contact Information section ", Status.FAIL);
				} else {

					report.updateTestLog("Verify New Contact Page Layout",
							"All fields are present in the Contact Information section", Status.PASS);
				}

			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
			contactInformationSectionListAdmin.clear();
		}
		Utility_Functions.xWaitForElementPresent(driver, firstNameNewContactPage, 5);
		Utility_Functions.xSendKeys(driver, firstNameNewContactPage, "Ema");
		Utility_Functions.xWaitForElementPresent(driver, accountNameQuickCreateContact, 5);
		String sAccountName = searchAccountName.fetchRecord("Account", "Name");
		Utility_Functions.xSendKeys(driver, accountNameQuickCreateContact, sAccountName);
		// Utility_Functions.xSendKeys(driver, accountNameQuickCreateContact,
		// "Barclay's Test");
		accountNameQuickCreateContact.sendKeys(Keys.ARROW_DOWN);
		Utility_Functions.timeWait(2);
		accountNameQuickCreateContact.sendKeys(Keys.ENTER);
		Utility_Functions.xWaitForElementPresent(driver, lastNameQuickCreateContact, 5);
		Utility_Functions.xSendKeys(driver, lastNameQuickCreateContact, "Watson");
		Utility_Functions.xWaitForElementPresent(driver, directLineNewContactPage, 2);
		Utility_Functions.xSendKeys(driver, directLineNewContactPage, dataTable.getData("General_Data", "Direct Line"));
		Utility_Functions.xWaitForElementPresent(driver, titleNewContactPage, 5);
		Utility_Functions.xSendKeys(driver, titleNewContactPage, "Manager");
		Utility_Functions.xWaitForElementPresent(driver, emailNewContactPage, 5);
		Utility_Functions.xSendKeys(driver, emailNewContactPage, dataTable.getData("General_Data", "Email"));
		List<WebElement> statusTypePickListValues = driver
				.findElements(By.xpath("//select[contains(@id,'statusPicklist')]/option"));
		int count5 = 0, i5 = 0;
		String fieldsArray5[] = new String[statusTypePickListValues.size()];
		System.out.println(statusTypePickListValues.size());
		try {
			statusFieldPickList();
			for (WebElement element5 : statusTypePickListValues) {
				System.out.println(element5.getText());
				fieldsArray5[i5] = element5.getText();
				if (fieldsArray5[i5].contains(statusFieldPickListValuesList.get(i5))) {
					report.updateTestLog("Verify SPOC Page Layout",
							"Role pick list is having the " + fieldsArray5[i5] + " fields ", Status.PASS);
					count5++;
				}
				i5++;
			}
			System.out.println(count5);
			if (count5 != 2) {
				report.updateTestLog("Verify New Contact Page Layout",
						"All fields are not present in the Status Type value pick list", Status.FAIL);
			} else {

				report.updateTestLog("Verify New Contact Page Layout",
						"All fields are present in the Status Type value pick list", Status.PASS);
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		statusTypePickListValues.clear();
		Utility_Functions.xWaitForElementPresent(driver, statusPickListNewContactPage, 3);
		Utility_Functions.xClick(driver, statusPickListNewContactPage, true);
		Utility_Functions.xWaitForElementPresent(driver, statusPickListValueNewContactPage, 3);
		Utility_Functions.xClick(driver, statusPickListValueNewContactPage, true);

		Utility_Functions.xWaitForElementPresent(driver, streetNewContactPage, 2);
		Utility_Functions.xSendKeys(driver, streetNewContactPage, dataTable.getData("General_Data", "Street"));
		Utility_Functions.xWaitForElementPresent(driver, cityNewContactPage, 2);
		Utility_Functions.xSendKeys(driver, cityNewContactPage, dataTable.getData("General_Data", "City"));

		Utility_Functions.xWaitForElementPresent(driver, countryNewContactpage, 3);
		Utility_Functions.xClick(driver, countryNewContactpage, true);
		Utility_Functions.xWaitForElementPresent(driver, countryValueNewContactPage, 3);
		Utility_Functions.xClick(driver, countryValueNewContactPage, true);

		Utility_Functions.xWaitForElementPresent(driver, stateNewContactPage, 3);
		Utility_Functions.xClick(driver, stateNewContactPage, true);
		Utility_Functions.xWaitForElementPresent(driver, stateValueNewContactPage, 3);
		Utility_Functions.xClick(driver, stateValueNewContactPage, true);
		Utility_Functions.xWaitForElementPresent(driver, zipcodeNewContactPage, 3);
		Utility_Functions.xClick(driver, zipcodeNewContactPage, true);
		Utility_Functions.xWaitForElementPresent(driver, zipcodeNewContactPage, 3);
		Utility_Functions.xSendKeys(driver, zipcodeNewContactPage, dataTable.getData("General_Data", "Zipcode"));
		Utility_Functions.xScrollWindow(driver);
		Utility_Functions.timeWait(2);
		Utility_Functions.xWaitForElementPresent(driver, middleNameNewContactPage, 5);
		Utility_Functions.xSendKeys(driver, middleNameNewContactPage, "S");
		Utility_Functions.xWaitForElementPresent(driver, mobilePhoneNewContactpage, 3);
		Utility_Functions.xSendKeys(driver, mobilePhoneNewContactpage, dataTable.getData("General_Data", "Phone"));
		Utility_Functions.xWaitForElementPresent(driver, nickNameNewContactpage, 5);
		Utility_Functions.xSendKeys(driver, nickNameNewContactpage, "Emi");
		Utility_Functions.xWaitForElementPresent(driver, mainPhoneNewContactPage, 3);
		Utility_Functions.xSendKeys(driver, mainPhoneNewContactPage, dataTable.getData("General_Data", "Phone"));
		Utility_Functions.xWaitForElementPresent(driver, departmentNewContactPage, 5);
		Utility_Functions.xSendKeys(driver, departmentNewContactPage, "Emi");
		Utility_Functions.xWaitForElementPresent(driver, inactiveContactBox, 5);
		Utility_Functions.xSendKeys(driver, inactiveContactBox, "Test");
		inactiveContactBox.sendKeys(Keys.ARROW_DOWN);
		Utility_Functions.timeWait(2);
		inactiveContactBox.sendKeys(Keys.ENTER);

		List<WebElement> InfluenceLevelTypePickList = driver
				.findElements(By.xpath("//select[contains(@id,'Influence_Level__c')]/option"));
		int count4 = 0, i4 = 0;
		String fieldsArray4[] = new String[InfluenceLevelTypePickList.size()];
		System.out.println(InfluenceLevelTypePickList.size());

		try {
			InfluenceLevelFieldPickList();
			for (WebElement element4 : InfluenceLevelTypePickList) {
				System.out.println(element4.getText());
				fieldsArray4[i4] = element4.getText();
				if (fieldsArray4[i4].contains(InfluenceLevelFieldPickListValuesList.get(i4))) {
					report.updateTestLog("Verify New Contact Page Layout",
							"Influence Level pick list is having the " + fieldsArray4[i4] + " values ", Status.PASS);
					count4++;
				}
				i4++;
			}
			System.out.println(count4);
			if (count4 != 4) {
				report.updateTestLog("Verify New Contact Page Layout",
						"All the values are not present in the Influence Level pick list ", Status.FAIL);
			} else {

				report.updateTestLog("Verify New Contact Page Layout",
						"All the values are present in the Influence Level pick list", Status.PASS);
			}

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		InfluenceLevelTypePickList.clear();
		Utility_Functions.xWaitForElementPresent(driver, influenceLevelPickList, 3);
		Utility_Functions.xClick(driver, influenceLevelPickList, true);
		Utility_Functions.xWaitForElementPresent(driver, influenceLevelPickListValue, 3);
		Utility_Functions.xClick(driver, influenceLevelPickListValue, true);
		Utility_Functions.xWaitForElementPresent(driver, reportsToNewContactPage, 5);
		Utility_Functions.xSendKeys(driver, reportsToNewContactPage, "Automation Test");
		reportsToNewContactPage.sendKeys(Keys.ARROW_DOWN);
		Utility_Functions.timeWait(2);
		reportsToNewContactPage.sendKeys(Keys.ENTER);

		if (dataTable.getData("General_Data", "TC_ID").contains("AMER")) {
			List<WebElement> communicationPreferencesSectionListValues = driver.findElements(By.xpath(
					"//h2[text()='Communication Preferences']/parent::div/parent::div/div//label[@class='slds-form-element__label']"));
			int count3 = 0, i3 = 0;
			String fieldsArray3[] = new String[communicationPreferencesSectionListValues.size()];
			System.out.println(communicationPreferencesSectionListValues.size());

			try {
				communicationPreferencesList();
				for (WebElement element3 : communicationPreferencesSectionListValues) {
					System.out.println(element3.getText());
					fieldsArray3[i3] = element3.getText();
					if (fieldsArray3[i3].contains(communicationPreferencesSectionList.get(i3))) {
						report.updateTestLog("Verify New Contact Page Layout ",
								"Communication Preferences is having the " + fieldsArray3[i3] + " fields ",
								Status.PASS);
						count3++;
					}
					i3++;
				}
				System.out.println(count3);
				if (count3 != 3) {
					report.updateTestLog("Verify New Contact Page Layout",
							"All fields are not present in the Communication Preferences section ", Status.FAIL);
				} else {

					report.updateTestLog("Verify New Contact Page Layout",
							"All fields are present in the Communication Preferences section", Status.PASS);
				}

			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
			communicationPreferencesSectionListValues.clear();
			List<WebElement> emailOptionsPickListvalues = driver
					.findElements(By.xpath("//select[contains(@id,'Email_Options__c')]/option"));
			int count6 = 0, i6 = 0;
			String fieldsArray6[] = new String[emailOptionsPickListvalues.size()];
			System.out.println(emailOptionsPickListvalues.size());

			try {
				emailOptionsPickList();
				for (WebElement element6 : emailOptionsPickListvalues) {
					System.out.println(element6.getText());
					fieldsArray6[i6] = element6.getText();
					if (fieldsArray6[i6].contains(emailOptionsPickListValuesList.get(i6))) {
						report.updateTestLog("Verify New Contact Page Layout ",
								"Email Options pick list is having the " + fieldsArray6[i6] + " values ", Status.PASS);
						count6++;
					}
					i6++;
				}
				System.out.println(count6);
				if (count6 != 3) {
					report.updateTestLog("Verify New Contact Page Layout",
							"All the values are not present in the Email Options pick list ", Status.FAIL);
				} else {

					report.updateTestLog("Verify New Contact Page Layout",
							"All the values are present in the Email Options pick list", Status.PASS);
				}

			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
			emailOptionsPickListvalues.clear();
			List<WebElement> mailOptionsPickListvalues = driver
					.findElements(By.xpath("//select[contains(@id,'Mail_Options__c')]/option"));
			int count7 = 0, i7 = 0;
			String fieldsArray7[] = new String[mailOptionsPickListvalues.size()];
			System.out.println(mailOptionsPickListvalues.size());

			try {
				mailOptionsPickList();
				for (WebElement element7 : mailOptionsPickListvalues) {
					System.out.println(element7.getText());
					fieldsArray7[i7] = element7.getText();
					if (fieldsArray6[i6].contains(mailOptionsPickListValuesList.get(i7))) {
						report.updateTestLog("Verify New Account Page Layout ",
								"Mail Options pick list is having the " + fieldsArray7[i7] + " values ", Status.PASS);
						count7++;
					}
					i7++;
				}
				System.out.println(count7);
				if (count7 != 3) {
					report.updateTestLog("Verify New Contact Page Layout",
							"All the values are not present in the mail Options pick list ", Status.FAIL);
				} else {

					report.updateTestLog("Verify New Contact Page Layout",
							"All the values are present in the mail Options pick list", Status.PASS);
				}

			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
			mailOptionsPickListvalues.clear();
			List<WebElement> callOptionsPickListvalues = driver
					.findElements(By.xpath("//select[contains(@id,'Call_Options__c')]/option"));
			int count8 = 0, i8 = 0;
			String fieldsArray8[] = new String[callOptionsPickListvalues.size()];
			System.out.println(callOptionsPickListvalues.size());

			try {
				callOptionsPickList();
				for (WebElement element8 : callOptionsPickListvalues) {
					System.out.println(element8.getText());
					fieldsArray8[i8] = element8.getText();
					if (fieldsArray8[i8].contains(callOptionsPickListValuesList.get(i8))) {
						report.updateTestLog("Verify New Account Page Layout ",
								"Call Options pick list is having the " + fieldsArray8[i8] + " values ", Status.PASS);
						count8++;
					}
					i8++;
				}
				System.out.println(count8);
				if (count8 != 3) {
					report.updateTestLog("Verify New Contact Page Layout",
							"All the values are not present in the call Options pick list ", Status.FAIL);
				} else {

					report.updateTestLog("Verify New Contact Page Layout ",
							"All the values are present in the call Options pick list", Status.PASS);
				}

			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
			callOptionsPickListvalues.clear();
			Utility_Functions.xWaitForElementPresent(driver, emailOptionsNewContactPage, 3);
			Utility_Functions.xClick(driver, emailOptionsNewContactPage, true);
			Utility_Functions.xWaitForElementPresent(driver, emailOptionsValueNewContactPage, 3);
			Utility_Functions.xClick(driver, emailOptionsValueNewContactPage, true);
			Utility_Functions.xWaitForElementPresent(driver, mailOptionsNewContactPage, 3);
			Utility_Functions.xClick(driver, mailOptionsNewContactPage, true);
			Utility_Functions.xWaitForElementPresent(driver, mailOptionsValueNewContactPage, 3);
			Utility_Functions.xClick(driver, mailOptionsValueNewContactPage, true);
			Utility_Functions.xWaitForElementPresent(driver, callOptionsNewContactPage, 3);
			Utility_Functions.xClick(driver, callOptionsNewContactPage, true);
			Utility_Functions.xWaitForElementPresent(driver, callOptionsValueNewContactPage, 3);
			Utility_Functions.xClick(driver, callOptionsValueNewContactPage, true);

		} else if (dataTable.getData("General_Data", "TC_ID").contains("APAC")) {
			List<WebElement> communicationPreferencesSectionListValues = driver.findElements(By.xpath(
					"//h2[text()='Communication Preferences']/parent::div/parent::div/div//label[@class='slds-form-element__label']"));
			int count3 = 0, i3 = 0;
			String fieldsArray3[] = new String[communicationPreferencesSectionListValues.size()];
			System.out.println(communicationPreferencesSectionListValues.size());

			try {
				communicationPreferencesListAPAC();
				for (WebElement element3 : communicationPreferencesSectionListValues) {
					System.out.println(element3.getText());
					fieldsArray3[i3] = element3.getText();
					if (fieldsArray3[i3].contains(communicationPreferencesSectionListAPAC.get(i3))) {
						report.updateTestLog("Verify New Contact Page Layout ",
								"Communication Preferences is having the " + fieldsArray3[i3] + " fields ",
								Status.PASS);
						count3++;
					}
					i3++;
				}
				System.out.println(count3);
				if (count3 != 6) {
					report.updateTestLog("Verify New Contact Page Layout",
							"All fields are not present in the Communication Preferences section ", Status.FAIL);
				} else {

					report.updateTestLog("Verify New Contact Page Layout",
							"All fields are present in the Communication Preferences section", Status.PASS);
				}

			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
			communicationPreferencesSectionListValues.clear();
			List<WebElement> emailOptionsPickListvalues = driver
					.findElements(By.xpath("//select[contains(@id,'Email_Options__c')]/option"));
			int count6 = 0, i6 = 0;
			String fieldsArray6[] = new String[emailOptionsPickListvalues.size()];
			System.out.println(emailOptionsPickListvalues.size());

			try {
				emailOptionsPickList();
				for (WebElement element6 : emailOptionsPickListvalues) {
					System.out.println(element6.getText());
					fieldsArray6[i6] = element6.getText();
					if (fieldsArray6[i6].contains(emailOptionsPickListValuesList.get(i6))) {
						report.updateTestLog("Verify New Contact Page Layout ",
								"Email Options pick list is having the " + fieldsArray6[i6] + " values ", Status.PASS);
						count6++;
					}
					i6++;
				}
				System.out.println(count6);
				if (count6 != 3) {
					report.updateTestLog("Verify New Contact Page Layout",
							"All the values are not present in the Email Options pick list ", Status.FAIL);
				} else {

					report.updateTestLog("Verify New Contact Page Layout",
							"All the values are present in the Email Options pick list", Status.PASS);
				}

			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
			emailOptionsPickListvalues.clear();
			List<WebElement> mailOptionsPickListvalues = driver
					.findElements(By.xpath("//select[contains(@id,'Mail_Options__c')]/option"));
			int count7 = 0, i7 = 0;
			String fieldsArray7[] = new String[mailOptionsPickListvalues.size()];
			System.out.println(mailOptionsPickListvalues.size());

			try {
				mailOptionsPickList();
				for (WebElement element7 : mailOptionsPickListvalues) {
					System.out.println(element7.getText());
					fieldsArray7[i7] = element7.getText();
					if (fieldsArray6[i6].contains(mailOptionsPickListValuesList.get(i7))) {
						report.updateTestLog("Verify New Account Page Layout ",
								"Mail Options pick list is having the " + fieldsArray7[i7] + " values ", Status.PASS);
						count7++;
					}
					i7++;
				}
				System.out.println(count7);
				if (count7 != 3) {
					report.updateTestLog("Verify New Contact Page Layout",
							"All the values are not present in the mail Options pick list ", Status.FAIL);
				} else {

					report.updateTestLog("Verify New Contact Page Layout",
							"All the values are present in the mail Options pick list", Status.PASS);
				}

			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
			mailOptionsPickListvalues.clear();
			List<WebElement> callOptionsPickListvalues = driver
					.findElements(By.xpath("//select[contains(@id,'Call_Options__c')]/option"));
			int count8 = 0, i8 = 0;
			String fieldsArray8[] = new String[callOptionsPickListvalues.size()];
			System.out.println(callOptionsPickListvalues.size());

			try {
				callOptionsPickList();
				for (WebElement element8 : callOptionsPickListvalues) {
					System.out.println(element8.getText());
					fieldsArray8[i8] = element8.getText();
					if (fieldsArray8[i8].contains(callOptionsPickListValuesList.get(i8))) {
						report.updateTestLog("Verify New Account Page Layout ",
								"Call Options pick list is having the " + fieldsArray8[i8] + " values ", Status.PASS);
						count8++;
					}
					i8++;
				}
				System.out.println(count8);
				if (count8 != 3) {
					report.updateTestLog("Verify New Contact Page Layout",
							"All the values are not present in the call Options pick list ", Status.FAIL);
				} else {

					report.updateTestLog("Verify New Contact Page Layout ",
							"All the values are present in the call Options pick list", Status.PASS);
				}

			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
			callOptionsPickListvalues.clear();
			List<WebElement> excludeReasonPickListvalues = driver
					.findElements(By.xpath("//select[contains(@id,'APAC_Exclude_Reason__c')]/option"));
			int count13 = 0, i13 = 0;
			String fieldsArray13[] = new String[excludeReasonPickListvalues.size()];
			System.out.println(excludeReasonPickListvalues.size());

			try {
				excludeReasonsPickList();
				for (WebElement element13 : excludeReasonPickListvalues) {
					System.out.println(element13.getText());
					fieldsArray13[i13] = element13.getText();
					if (fieldsArray13[i13].contains(excludeReasonPickListValuesList.get(i13))) {
						report.updateTestLog("Verify New Account Page Layout ",
								"Call Options pick list is having the " + fieldsArray13[i13] + " values ", Status.PASS);
						count13++;
					}
					i13++;
				}
				System.out.println(count13);
				if (count13 != 9) {
					report.updateTestLog("Verify New Contact Page Layout",
							"All the values are not present in the Exclude reason pick list ", Status.FAIL);
				} else {

					report.updateTestLog("Verify New Contact Page Layout ",
							"All the values are present in the Exclude reason pick list", Status.PASS);
				}

			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
			excludeReasonPickListvalues.clear();
			Utility_Functions.xWaitForElementPresent(driver, emailOptionsNewContactPage, 3);
			Utility_Functions.xClick(driver, emailOptionsNewContactPage, true);
			Utility_Functions.xWaitForElementPresent(driver, emailOptionsValueNewContactPage, 3);
			Utility_Functions.xClick(driver, emailOptionsValueNewContactPage, true);
			Utility_Functions.xWaitForElementPresent(driver, excludedReasonNewContactPage, 3);
			Utility_Functions.xClick(driver, excludedReasonNewContactPage, true);
			Utility_Functions.xWaitForElementPresent(driver, excludedReasonValueNewContactPage, 3);
			Utility_Functions.xClick(driver, excludedReasonValueNewContactPage, true);
			Utility_Functions.xWaitForElementPresent(driver, mailOptionsNewContactPage, 3);
			Utility_Functions.xClick(driver, mailOptionsNewContactPage, true);
			Utility_Functions.xWaitForElementPresent(driver, mailOptionsValueNewContactPage, 3);
			Utility_Functions.xClick(driver, mailOptionsValueNewContactPage, true);
			Calendar calendar = Calendar.getInstance();
			calendar.add(Calendar.DAY_OF_MONTH, -20);
			SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
			System.out.println("Date : " + dateFormat.format(calendar.getTime()));
			Utility_Functions.xWaitForElementPresent(driver, excludedOnNewContactpage, 3);
			Utility_Functions.xSendKeys(driver, excludedOnNewContactpage, dateFormat.format(calendar.getTime()));
			Utility_Functions.xWaitForElementPresent(driver, callOptionsNewContactPage, 3);
			Utility_Functions.xClick(driver, callOptionsNewContactPage, true);
			Utility_Functions.xWaitForElementPresent(driver, callOptionsValueNewContactPage, 3);
			Utility_Functions.xClick(driver, callOptionsValueNewContactPage, true);
			Utility_Functions.xWaitForElementPresent(driver, excludedByNewContactpage, 5);
			Utility_Functions.xSendKeys(driver, excludedByNewContactpage, "Test");
			excludedByNewContactpage.sendKeys(Keys.ARROW_DOWN);
			Utility_Functions.timeWait(2);
			excludedByNewContactpage.sendKeys(Keys.ENTER);

		} else if (dataTable.getData("General_Data", "TC_ID").contains("OBAMERAdmin")) {
			List<WebElement> communicationPreferencesSectionListValuesAdmin = driver.findElements(By.xpath(
					"//h2[text()='Communication Preferences']/parent::div/parent::div/div//label[@class='slds-form-element__label']"));
			int count15 = 0, i15 = 0;
			String fieldsArray15[] = new String[communicationPreferencesSectionListValuesAdmin.size()];
			System.out.println(communicationPreferencesSectionListValuesAdmin.size());

			try {
				communicationPreferencesListAdmin();
				for (WebElement element15 : communicationPreferencesSectionListValuesAdmin) {
					System.out.println(element15.getText());
					fieldsArray15[i15] = element15.getText();
					if (fieldsArray15[i15].contains(communicationPreferencesSectionListAdmin.get(i15))) {
						report.updateTestLog("Verify New Contact Page Layout ",
								"Communication Preferences is having the " + fieldsArray15[i15] + " fields ",
								Status.PASS);
						count15++;
					}
					i15++;
				}
				System.out.println(count15);
				if (count15 != 8) {
					report.updateTestLog("Verify New Contact Page Layout",
							"All fields are not present in the Communication Preferences section ", Status.FAIL);
				} else {

					report.updateTestLog("Verify New Contact Page Layout",
							"All fields are present in the Communication Preferences section", Status.PASS);
				}

			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
			communicationPreferencesSectionListValuesAdmin.clear();
			List<WebElement> emailOptionsPickListvalues = driver
					.findElements(By.xpath("//select[contains(@id,'Email_Options__c')]/option"));
			int count6 = 0, i6 = 0;
			String fieldsArray6[] = new String[emailOptionsPickListvalues.size()];
			System.out.println(emailOptionsPickListvalues.size());

			try {
				emailOptionsPickList();
				for (WebElement element6 : emailOptionsPickListvalues) {
					System.out.println(element6.getText());
					fieldsArray6[i6] = element6.getText();
					if (fieldsArray6[i6].contains(emailOptionsPickListValuesList.get(i6))) {
						report.updateTestLog("Verify New Contact Page Layout ",
								"Email Options pick list is having the " + fieldsArray6[i6] + " values ", Status.PASS);
						count6++;
					}
					i6++;
				}
				System.out.println(count6);
				if (count6 != 3) {
					report.updateTestLog("Verify New Contact Page Layout",
							"All the values are not present in the Email Options pick list ", Status.FAIL);
				} else {

					report.updateTestLog("Verify New Contact Page Layout",
							"All the values are present in the Email Options pick list", Status.PASS);
				}

			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
			emailOptionsPickListvalues.clear();
			List<WebElement> mailOptionsPickListvalues = driver
					.findElements(By.xpath("//select[contains(@id,'Mail_Options__c')]/option"));
			int count7 = 0, i7 = 0;
			String fieldsArray7[] = new String[mailOptionsPickListvalues.size()];
			System.out.println(mailOptionsPickListvalues.size());

			try {
				mailOptionsPickList();
				for (WebElement element7 : mailOptionsPickListvalues) {
					System.out.println(element7.getText());
					fieldsArray7[i7] = element7.getText();
					if (fieldsArray6[i6].contains(mailOptionsPickListValuesList.get(i7))) {
						report.updateTestLog("Verify New Account Page Layout ",
								"Mail Options pick list is having the " + fieldsArray7[i7] + " values ", Status.PASS);
						count7++;
					}
					i7++;
				}
				System.out.println(count7);
				if (count7 != 3) {
					report.updateTestLog("Verify New Contact Page Layout",
							"All the values are not present in the mail Options pick list ", Status.FAIL);
				} else {

					report.updateTestLog("Verify New Contact Page Layout",
							"All the values are present in the mail Options pick list", Status.PASS);
				}

			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
			mailOptionsPickListvalues.clear();
			List<WebElement> callOptionsPickListvalues = driver
					.findElements(By.xpath("//select[contains(@id,'Call_Options__c')]/option"));
			int count8 = 0, i8 = 0;
			String fieldsArray8[] = new String[callOptionsPickListvalues.size()];
			System.out.println(callOptionsPickListvalues.size());

			try {
				callOptionsPickList();
				for (WebElement element8 : callOptionsPickListvalues) {
					System.out.println(element8.getText());
					fieldsArray8[i8] = element8.getText();
					if (fieldsArray8[i8].contains(callOptionsPickListValuesList.get(i8))) {
						report.updateTestLog("Verify New Account Page Layout ",
								"Call Options pick list is having the " + fieldsArray8[i8] + " values ", Status.PASS);
						count8++;
					}
					i8++;
				}
				System.out.println(count8);
				if (count8 != 3) {
					report.updateTestLog("Verify New Contact Page Layout",
							"All the values are not present in the call Options pick list ", Status.FAIL);
				} else {

					report.updateTestLog("Verify New Contact Page Layout ",
							"All the values are present in the call Options pick list", Status.PASS);
				}

			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
			callOptionsPickListvalues.clear();
			List<WebElement> excludeReasonPickListvalues = driver
					.findElements(By.xpath("//select[contains(@id,'APAC_Exclude_Reason__c')]/option"));
			int count13 = 0, i13 = 0;
			String fieldsArray13[] = new String[excludeReasonPickListvalues.size()];
			System.out.println(excludeReasonPickListvalues.size());

			try {
				excludeReasonsPickList();
				for (WebElement element13 : excludeReasonPickListvalues) {
					System.out.println(element13.getText());
					fieldsArray13[i13] = element13.getText();
					if (fieldsArray13[i13].contains(excludeReasonPickListValuesList.get(i13))) {
						report.updateTestLog("Verify New Account Page Layout ",
								"Call Options pick list is having the " + fieldsArray13[i13] + " values ", Status.PASS);
						count13++;
					}
					i13++;
				}
				System.out.println(count13);
				if (count13 != 9) {
					report.updateTestLog("Verify New Contact Page Layout",
							"All the values are not present in the Exclude reason pick list ", Status.FAIL);
				} else {

					report.updateTestLog("Verify New Contact Page Layout ",
							"All the values are present in the Exclude reason pick list", Status.PASS);
				}

			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
			excludeReasonPickListvalues.clear();
			List<WebElement> PreferredCommMethodPickListvalues = driver
					.findElements(By.xpath("//select[contains(@id,'Preferred_Comm_Method')]/option"));
			int count10 = 0, i10 = 0;
			String fieldsArray10[] = new String[PreferredCommMethodPickListvalues.size()];
			System.out.println(PreferredCommMethodPickListvalues.size());

			try {
				preferredCommMethodPickList();
				for (WebElement element10 : PreferredCommMethodPickListvalues) {
					System.out.println(element10.getText());
					fieldsArray10[i10] = element10.getText();
					if (fieldsArray10[i10].contains(preferredCommMethodPickListValuesList.get(i10))) {
						report.updateTestLog("Verify New Account Page Layout ",
								"Preferred Comm method pick list is having the " + fieldsArray10[i10] + " values ",
								Status.PASS);
						count10++;
					}
					i10++;
				}
				System.out.println(count10);
				if (count10 != 4) {
					report.updateTestLog("Verify New Contact Page Layout",
							"All the values are not present in the preffered Comm method pick list ", Status.FAIL);
				} else {

					report.updateTestLog("Verify New Contact Page Layout",
							"All the values are present in the preffered Comm method pick list", Status.PASS);
				}

			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
			PreferredCommMethodPickListvalues.clear();
			Utility_Functions.xWaitForElementPresent(driver, preferredCommMethod, 3);
			Utility_Functions.xClick(driver, preferredCommMethod, true);
			Utility_Functions.xWaitForElementPresent(driver, preferredCommMethodValue, 3);
			Utility_Functions.xClick(driver, preferredCommMethodValue, true);
			Utility_Functions.xWaitForElementPresent(driver, emailOptionsNewContactPage, 3);
			Utility_Functions.xClick(driver, emailOptionsNewContactPage, true);
			Utility_Functions.xWaitForElementPresent(driver, emailOptionsValueNewContactPage, 3);
			Utility_Functions.xClick(driver, emailOptionsValueNewContactPage, true);
			Utility_Functions.xWaitForElementPresent(driver, excludedReasonNewContactPage, 3);
			Utility_Functions.xClick(driver, excludedReasonNewContactPage, true);
			Utility_Functions.xWaitForElementPresent(driver, excludedReasonValueNewContactPage, 3);
			Utility_Functions.xClick(driver, excludedReasonValueNewContactPage, true);
			Utility_Functions.xWaitForElementPresent(driver, mailOptionsNewContactPage, 3);
			Utility_Functions.xClick(driver, mailOptionsNewContactPage, true);
			Utility_Functions.xWaitForElementPresent(driver, mailOptionsValueNewContactPage, 3);
			Utility_Functions.xClick(driver, mailOptionsValueNewContactPage, true);
			Calendar calendar = Calendar.getInstance();
			calendar.add(Calendar.DAY_OF_MONTH, -20);
			SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy hh:mm a");
			System.out.println("Date : " + dateFormat.format(calendar.getTime()));
			Utility_Functions.xWaitForElementPresent(driver, excludedOnNewContactpage, 3);
			Utility_Functions.xSendKeys(driver, excludedOnNewContactpage, dateFormat.format(calendar.getTime()));
			Utility_Functions.xWaitForElementPresent(driver, callOptionsNewContactPage, 3);
			Utility_Functions.xClick(driver, callOptionsNewContactPage, true);
			Utility_Functions.xWaitForElementPresent(driver, callOptionsValueNewContactPage, 3);
			Utility_Functions.xClick(driver, callOptionsValueNewContactPage, true);
			Utility_Functions.xWaitForElementPresent(driver, excludedByNewContactpage, 5);
			Utility_Functions.xSendKeys(driver, excludedByNewContactpage, "Test");
			excludedByNewContactpage.sendKeys(Keys.ARROW_DOWN);
			Utility_Functions.timeWait(2);
			excludedByNewContactpage.sendKeys(Keys.ENTER);

		}

		if (!(dataTable.getData("General_Data", "TC_ID").contains("Admin"))) {
			List<WebElement> additionalInformationSectionListValues = driver.findElements(By.xpath(
					"//h2[text()='Additional Information']/parent::div/parent::div/div//label[@class='slds-form-element__label']"));
			int count9 = 0, i9 = 0;
			String fieldsArray9[] = new String[additionalInformationSectionListValues.size()];
			System.out.println(additionalInformationSectionListValues.size());

			try {
				additionalInformationSectionList();
				for (WebElement element9 : additionalInformationSectionListValues) {
					System.out.println(element9.getText());
					fieldsArray9[i9] = element9.getText();
					if (fieldsArray9[i9].contains(additionalInformationSectionList.get(i9))) {
						report.updateTestLog("Verify New Contact Page Layout",
								"Additional Information section is having the " + fieldsArray9[i9] + " fields ",
								Status.PASS);
						count9++;
					}
					i9++;
				}
				System.out.println(count9);
				if (count9 != 8) {
					report.updateTestLog("Verify New Contact Page Layout",
							"All fields are not present in the Additional Information section ", Status.FAIL);
				} else {

					report.updateTestLog("Verify New Contact Page Layout",
							"All fields are present in the Additional Information section", Status.PASS);
				}

			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
			additionalInformationSectionListValues.clear();
			Utility_Functions.xWaitForElementPresent(driver, faxNewContactpage, 3);
			Utility_Functions.xSendKeys(driver, faxNewContactpage, dataTable.getData("General_Data", "Phone"));
			Utility_Functions.xWaitForElementPresent(driver, assistantNameNewContactpage, 5);
			Utility_Functions.xSendKeys(driver, assistantNameNewContactpage, "Emi");
			List<WebElement> PreferredCommMethodPickListvalues = driver
					.findElements(By.xpath("//select[contains(@id,'Preferred_Comm_Method')]/option"));
			int count10 = 0, i10 = 0;
			String fieldsArray10[] = new String[PreferredCommMethodPickListvalues.size()];
			System.out.println(PreferredCommMethodPickListvalues.size());

			try {
				preferredCommMethodPickList();
				for (WebElement element10 : PreferredCommMethodPickListvalues) {
					System.out.println(element10.getText());
					fieldsArray10[i10] = element10.getText();
					if (fieldsArray10[i10].contains(preferredCommMethodPickListValuesList.get(i10))) {
						report.updateTestLog("Verify New Account Page Layout ",
								"Preferred Comm method pick list is having the " + fieldsArray10[i10] + " values ",
								Status.PASS);
						count10++;
					}
					i10++;
				}
				System.out.println(count10);
				if (count10 != 4) {
					report.updateTestLog("Verify New Contact Page Layout",
							"All the values are not present in the preffered Comm method pick list ", Status.FAIL);
				} else {

					report.updateTestLog("Verify New Contact Page Layout",
							"All the values are present in the preffered Comm method pick list", Status.PASS);
				}

			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
			PreferredCommMethodPickListvalues.clear();
			Utility_Functions.xWaitForElementPresent(driver, preferredCommMethod, 3);
			Utility_Functions.xClick(driver, preferredCommMethod, true);
			Utility_Functions.xWaitForElementPresent(driver, preferredCommMethodValue, 3);
			Utility_Functions.xClick(driver, preferredCommMethodValue, true);
			Utility_Functions.xWaitForElementPresent(driver, assistantPhoneNewContactPage, 3);
			Utility_Functions.xSendKeys(driver, assistantPhoneNewContactPage,
					dataTable.getData("General_Data", "Phone"));
			Calendar calendar = Calendar.getInstance();
			calendar.add(Calendar.DAY_OF_MONTH, -20);
			SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy hh:mm a");
			System.out.println("Date : " + dateFormat.format(calendar.getTime()));
			Utility_Functions.xWaitForElementPresent(driver, commEmailSentNewContactpage, 3);
			Utility_Functions.xSendKeys(driver, commEmailSentNewContactpage, dateFormat.format(calendar.getTime()));
			Utility_Functions.xWaitForElementPresent(driver, assistantEmailNewContactPage, 3);
			Utility_Functions.xSendKeys(driver, assistantEmailNewContactPage,
					dataTable.getData("General_Data", "Email"));
			List<WebElement> reasonForInactivatingPickListvalues = driver
					.findElements(By.xpath("//select[contains(@id,'Reason_for_Inactivating__c')]/option"));
			int count11 = 0, i11 = 0;
			String fieldsArray11[] = new String[reasonForInactivatingPickListvalues.size()];
			System.out.println(reasonForInactivatingPickListvalues.size());

			try {
				reasonForInactivatingPickList();
				for (WebElement element11 : reasonForInactivatingPickListvalues) {
					System.out.println(element11.getText());
					fieldsArray11[i11] = element11.getText();
					if (fieldsArray11[i11].contains(reasonForInactivatingPickListValuesList.get(i11))) {
						report.updateTestLog("Verify New Contact Page Layout",
								"Reason for Inactivating pick list is having the " + fieldsArray11[i11] + " values ",
								Status.PASS);
						count11++;
					}
					i11++;
				}
				System.out.println(count11);
				if (count11 != 5) {
					report.updateTestLog("Verify New Contact Page Layout",
							"All the values are not present in the reason for Inactivating pick list ", Status.FAIL);
				} else {

					report.updateTestLog("Verify New Contact Page Layout",
							"All the values are present in the reason for Inactivating pick list", Status.PASS);
				}

			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
			reasonForInactivatingPickListvalues.clear();
			Utility_Functions.xWaitForElementPresent(driver, reasonForInactivating, 3);
			Utility_Functions.xClick(driver, reasonForInactivating, true);
			Utility_Functions.xWaitForElementPresent(driver, reasonForInactivatingValue, 3);
			Utility_Functions.xClick(driver, reasonForInactivatingValue, true);
			Calendar calendar1 = Calendar.getInstance();
			calendar1.add(Calendar.DAY_OF_MONTH, 10);
			SimpleDateFormat dateFormat1 = new SimpleDateFormat("MM/dd/yyyy hh:mm a");
			System.out.println("Date : " + dateFormat1.format(calendar1.getTime()));
			Utility_Functions.xWaitForElementPresent(driver, inactivationDateNewContactPage, 3);
			Utility_Functions.xSendKeys(driver, inactivationDateNewContactPage,
					dateFormat1.format(calendar1.getTime()));

		} else if (dataTable.getData("General_Data", "TC_ID").contains("Admin")) {

			List<WebElement> additionalInformationSectionListValuesAdmin = driver.findElements(By.xpath(
					"//h2[text()='Additional Information']/parent::div/parent::div/div//label[@class='slds-form-element__label']"));
			int count19 = 0, i19 = 0;
			String fieldsArray19[] = new String[additionalInformationSectionListValuesAdmin.size()];
			System.out.println(additionalInformationSectionListValuesAdmin.size());

			try {
				additionalInformationSectionAdmin();
				for (WebElement element19 : additionalInformationSectionListValuesAdmin) {
					System.out.println(element19.getText());
					fieldsArray19[i19] = element19.getText();
					if (fieldsArray19[i19].contains(additionalInformationSectionListAdmin.get(i19))) {
						report.updateTestLog("Verify New Contact Page Layout",
								"Additional Information section is having the " + fieldsArray19[i19] + " fields ",
								Status.PASS);
						count19++;
					}
					i19++;
				}
				System.out.println(count19);
				if (count19 != 12) {
					report.updateTestLog("Verify New Contact Page Layout",
							"All fields are not present in the Additional Information section ", Status.FAIL);
				} else {

					report.updateTestLog("Verify New Contact Page Layout",
							"All fields are present in the Additional Information section", Status.PASS);
				}

			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
			additionalInformationSectionListValuesAdmin.clear();
			Utility_Functions.xWaitForElementPresent(driver, faxNewContactpage, 3);
			Utility_Functions.xSendKeys(driver, faxNewContactpage, dataTable.getData("General_Data", "Phone"));
			Utility_Functions.xWaitForElementPresent(driver, assistantNameNewContactpage, 5);
			Utility_Functions.xSendKeys(driver, assistantNameNewContactpage, "Emi");
			Utility_Functions.xWaitForElementPresent(driver, assistantPhoneNewContactPage, 3);
			Utility_Functions.xSendKeys(driver, assistantPhoneNewContactPage,
					dataTable.getData("General_Data", "Phone"));
			Calendar calendar = Calendar.getInstance();
			calendar.add(Calendar.DAY_OF_MONTH, -20);
			SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy hh:mm a");
			System.out.println("Date : " + dateFormat.format(calendar.getTime()));
			Utility_Functions.xWaitForElementPresent(driver, commEmailSentNewContactpage, 3);
			Utility_Functions.xSendKeys(driver, commEmailSentNewContactpage, dateFormat.format(calendar.getTime()));
			Utility_Functions.xWaitForElementPresent(driver, assistantEmailNewContactPage, 3);
			Utility_Functions.xSendKeys(driver, assistantEmailNewContactPage,
					dataTable.getData("General_Data", "Email"));
			Calendar calendar1 = Calendar.getInstance();
			calendar1.add(Calendar.DAY_OF_MONTH, 10);
			SimpleDateFormat dateFormat1 = new SimpleDateFormat("MM/dd/yyyy hh:mm a");
			System.out.println("Date : " + dateFormat1.format(calendar1.getTime()));
			Utility_Functions.xWaitForElementPresent(driver, inactivationDateNewContactPage, 3);
			Utility_Functions.xSendKeys(driver, inactivationDateNewContactPage,
					dateFormat1.format(calendar1.getTime()));

		}
		List<WebElement> systemInformationSectionListValues = driver.findElements(By.xpath(
				"//h2[text()='Additional Information']/parent::div/parent::div/div//label[@class='slds-form-element__label']"));
		int count12 = 0, i12 = 0;
		String fieldsArray12[] = new String[systemInformationSectionListValues.size()];
		System.out.println(systemInformationSectionListValues.size());

		try {
			systemInformationSectionList();
			for (WebElement element12 : systemInformationSectionListValues) {
				System.out.println(element12.getText());
				fieldsArray12[i12] = element12.getText();
				if (fieldsArray12[i12].contains(systemInformationSectionList.get(i12))) {
					report.updateTestLog("Verify New Contact Page Layout",
							"Additional Information section is having the " + fieldsArray12[i12] + " fields ",
							Status.PASS);
					count12++;
				}
				i12++;
			}
			System.out.println(count12);
			if (count12 != 1) {
				report.updateTestLog("Verify New Contact Page Layout",
						"All fields are not present in the System Information section ", Status.FAIL);
			} else {

				report.updateTestLog("Verify New Contact Page Layout",
						"All fields are present in the System Information section", Status.PASS);
			}

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		systemInformationSectionListValues.clear();*/
	}

	/**
	 * Validating the New Contact Page by populating all the fields
	 * 
	 * @author Ramya
	 *
	 */
	public void contactsPopulatingAllFields() {
		
		ContactsFunctions contactsFunctions = new ContactsFunctions(scriptHelper);
		contactsFunctions.createContactsPopulatingAllFields();
	
		/*Utility_Functions.xWaitForElementPresent(driver, menu_Contacts, 3);
		Utility_Functions.xClick(driver, menu_Contacts, true);
		Utility_Functions.timeWait(1);
		report.updateTestLog("Verify Contacts Populating all fields", "Verifying Contacts is Displayed ", Status.PASS);
		Utility_Functions.xWaitForElementPresent(driver, newContact, 3);
		Utility_Functions.xClick(driver, newContact, true);
		Utility_Functions.timeWait(2);
		report.updateTestLog("Verify Contacts Populating all fields", "Verifying New Contacts Page is Displayed  ",
				Status.PASS);
		if (dataTable.getData("General_Data", "TC_ID").contains("Admin")) {

			Utility_Functions.xSwitchtoFrame(driver, continueButtonNewContact);
			Utility_Functions.xWaitForElementPresent(driver, continueButtonNewContact, 3);
			Utility_Functions.xClick(driver, continueButtonNewContact, true);
			Utility_Functions.timeWait(2);
		}
		Utility_Functions.xSwitchtoFrame(driver, viewAllFieldsButton);
		Utility_Functions.xScrollWindow(driver);
		Utility_Functions.timeWait(1);
		Utility_Functions.xWaitForElementPresent(driver, viewAllFieldsButton, 5);
		Utility_Functions.xClick(driver, viewAllFieldsButton, true);
		Utility_Functions.timeWait(1);
		Utility_Functions.xScrollWindowTop(driver);
		Utility_Functions.timeWait(5);

		Utility_Functions.xWaitForElementPresent(driver, firstNameNewContactPage, 5);
		Utility_Functions.xSendKeys(driver, firstNameNewContactPage, Utility_Functions.xGenerateAlphaNumericString() + "_Test_Automation_First");
		Utility_Functions.xWaitForElementPresent(driver, accountSearch, 5);
		String query = "SELECT Id, Name FROM Account limit 1 offset 9";
		String sAccountName = searchAccountName.fetchRecordFieldValue("Name", query);
		Utility_Functions.xSendKeys(driver, accountSearch, sAccountName);
		accountSearch.sendKeys(Keys.ARROW_DOWN);
		Utility_Functions.timeWait(2);
		accountSearch.sendKeys(Keys.ENTER);
		Utility_Functions.timeWait(2);
		Utility_Functions.xWaitForElementPresent(driver, lastNameQuickCreateContact, 5);
		Utility_Functions.xSendKeys(driver, lastNameQuickCreateContact, Utility_Functions.xGenerateAlphaNumericString() + "_Test_Automation_Last");
		Utility_Functions.xWaitForElementPresent(driver, directLineNewContactPage, 2);
		Utility_Functions.xSendKeys(driver, directLineNewContactPage, dataTable.getData("General_Data", "Direct Line"));
		Utility_Functions.xWaitForElementPresent(driver, titleNewContactPage, 5);
		Utility_Functions.xSendKeys(driver, titleNewContactPage, "Manager");
		Utility_Functions.xWaitForElementPresent(driver, emailNewContactPage, 5);
		Utility_Functions.xSendKeys(driver, emailNewContactPage,
				Utility_Functions.xGenerateAlphaNumericString() + dataTable.getData("General_Data", "Email"));

		Utility_Functions.xWaitForElementPresent(driver, statusValueNewContactPage, 3);
		Utility_Functions.xClick(driver, statusValueNewContactPage, true);
		Utility_Functions.xWaitForElementPresent(driver, statusValueNewContactPage, 3);
		Utility_Functions.xClick(driver, statusValueNewContactPage, true);

		Utility_Functions.xWaitForElementPresent(driver, streetNewContactPage, 2);
		Utility_Functions.xSendKeys(driver, streetNewContactPage, dataTable.getData("General_Data", "Street"));
		Utility_Functions.xWaitForElementPresent(driver, cityNewContactPage, 2);
		Utility_Functions.xSendKeys(driver, cityNewContactPage, dataTable.getData("General_Data", "City"));

		Utility_Functions.xWaitForElementPresent(driver, countryNewContactpage, 3);
		Utility_Functions.xClick(driver, countryNewContactpage, true);
		Utility_Functions.xWaitForElementPresent(driver, countryValueNewContactPage, 3);
		Utility_Functions.xClick(driver, countryValueNewContactPage, true);

		Utility_Functions.xWaitForElementPresent(driver, stateNewContactPage, 3);
		Utility_Functions.xClick(driver, stateNewContactPage, true);
		Utility_Functions.xWaitForElementPresent(driver, stateValueNewContactPage, 3);
		Utility_Functions.xClick(driver, stateValueNewContactPage, true);
		Utility_Functions.xWaitForElementPresent(driver, zipcodeNewContactPage, 3);
		Utility_Functions.xClick(driver, zipcodeNewContactPage, true);
		Utility_Functions.xWaitForElementPresent(driver, zipcodeNewContactPage, 3);
		Utility_Functions.xSendKeys(driver, zipcodeNewContactPage, dataTable.getData("General_Data", "Zipcode"));
		Utility_Functions.xScrollWindow(driver);
		Utility_Functions.timeWait(2);
		if (!dataTable.getData("General_Data", "TC_ID").contains("CMAMERCSSContactsPopulatingAllFields")) {
			Utility_Functions.xWaitForElementPresent(driver, middleNameNewContactPage, 5);
			Utility_Functions.xSendKeys(driver, middleNameNewContactPage,
					Utility_Functions.xGenerateAlphaNumericString() + "Test_Automation_Middle_");
		}
		Utility_Functions.xWaitForElementPresent(driver, mobilePhoneNewContactpage, 3);
		Utility_Functions.xSendKeys(driver, mobilePhoneNewContactpage, dataTable.getData("General_Data", "Phone"));
		if (!dataTable.getData("General_Data", "TC_ID").contains("CMAMERCSSContactsPopulatingAllFields")) {
			Utility_Functions.xWaitForElementPresent(driver, nickNameNewContactpage, 5);
			Utility_Functions.xSendKeys(driver, nickNameNewContactpage,
					Utility_Functions.xGenerateAlphaNumericString() + "Test_Automation_Nick_");
		}
		Utility_Functions.xWaitForElementPresent(driver, mainPhoneNewContactPage, 3);
		Utility_Functions.xSendKeys(driver, mainPhoneNewContactPage, dataTable.getData("General_Data", "Phone"));
		Utility_Functions.xWaitForElementPresent(driver, departmentNewContactPage, 5);
		Utility_Functions.xSendKeys(driver, departmentNewContactPage,
				Utility_Functions.xGenerateAlphaNumericString() + "Test_Automation_Department_");
		Utility_Functions.xWaitForElementPresent(driver, inactiveContactBox, 5);
		Utility_Functions.xSendKeys(driver, inactiveContactBox, "Test");
		inactiveContactBox.sendKeys(Keys.ARROW_DOWN);
		Utility_Functions.timeWait(2);
		inactiveContactBox.sendKeys(Keys.ENTER);

		Utility_Functions.xWaitForElementPresent(driver, influenceLevelPickList, 3);
		Utility_Functions.xClick(driver, influenceLevelPickList, true);
		Utility_Functions.xWaitForElementPresent(driver, influenceLevelPickListValue, 3);
		Utility_Functions.xClick(driver, influenceLevelPickListValue, true);
		
		 * Utility_Functions.xWaitForElementPresent(driver,
		 * reportsToNewContactPage, 5); Utility_Functions.xSendKeys(driver,
		 * reportsToNewContactPage, "Automation Test");
		 * reportsToNewContactPage.sendKeys(Keys.ARROW_DOWN);
		 * Utility_Functions.timeWait(2);
		 * reportsToNewContactPage.sendKeys(Keys.ENTER);
		 

		Utility_Functions.xWaitForElementPresent(driver, emailOptionsNewContactPage, 3);
		Utility_Functions.xClick(driver, emailOptionsNewContactPage, true);
		Utility_Functions.xWaitForElementPresent(driver, emailOptionsValueNewContactPage, 3);
		Utility_Functions.xClick(driver, emailOptionsValueNewContactPage, true);
		Utility_Functions.xWaitForElementPresent(driver, mailOptionsNewContactPage, 3);
		Utility_Functions.xClick(driver, mailOptionsNewContactPage, true);
		Utility_Functions.xWaitForElementPresent(driver, mailOptionsValueNewContactPage, 3);
		Utility_Functions.xClick(driver, mailOptionsValueNewContactPage, true);

		if (dataTable.getData("General_Data", "TC_ID").contains("AMER")) {

			Utility_Functions.xWaitForElementPresent(driver, callOptionsNewContactPage, 3);
			Utility_Functions.xClick(driver, callOptionsNewContactPage, true);
			Utility_Functions.xWaitForElementPresent(driver, callOptionsValueNewContactPage, 3);
			Utility_Functions.xClick(driver, callOptionsValueNewContactPage, true);

		} else if (dataTable.getData("General_Data", "TC_ID").contains("APAC")) {

			Utility_Functions.xWaitForElementPresent(driver, emailOptionsNewContactPage, 3);
			Utility_Functions.xClick(driver, emailOptionsNewContactPage, true);
			Utility_Functions.xWaitForElementPresent(driver, emailOptionsValueNewContactPage, 3);
			Utility_Functions.xClick(driver, emailOptionsValueNewContactPage, true);
			Utility_Functions.xWaitForElementPresent(driver, excludedReasonNewContactPage, 3);
			Utility_Functions.xClick(driver, excludedReasonNewContactPage, true);
			Utility_Functions.xWaitForElementPresent(driver, excludedReasonValueNewContactPage, 3);
			Utility_Functions.xClick(driver, excludedReasonValueNewContactPage, true);
			Utility_Functions.xWaitForElementPresent(driver, mailOptionsNewContactPage, 3);
			Utility_Functions.xClick(driver, mailOptionsNewContactPage, true);
			Utility_Functions.xWaitForElementPresent(driver, mailOptionsValueNewContactPage, 3);
			Utility_Functions.xClick(driver, mailOptionsValueNewContactPage, true);
			Calendar calendar = Calendar.getInstance();
			calendar.add(Calendar.DAY_OF_MONTH, -20);
			SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
			System.out.println("Date : " + dateFormat.format(calendar.getTime()));
			Utility_Functions.xWaitForElementPresent(driver, excludedOnNewContactpage, 3);
			Utility_Functions.xSendKeys(driver, excludedOnNewContactpage, dateFormat.format(calendar.getTime()));
			Utility_Functions.xWaitForElementPresent(driver, callOptionsNewContactPage, 3);
			Utility_Functions.xClick(driver, callOptionsNewContactPage, true);
			Utility_Functions.xWaitForElementPresent(driver, callOptionsValueNewContactPage, 3);
			Utility_Functions.xClick(driver, callOptionsValueNewContactPage, true);
			Utility_Functions.xWaitForElementPresent(driver, excludedByNewContactpage, 5);
			Utility_Functions.xSendKeys(driver, excludedByNewContactpage, "Test");
			excludedByNewContactpage.sendKeys(Keys.ARROW_DOWN);
			Utility_Functions.timeWait(2);
			excludedByNewContactpage.sendKeys(Keys.ENTER);

		} else if (dataTable.getData("General_Data", "TC_ID").contains("OBAMERAdmin")) {

			Utility_Functions.xWaitForElementPresent(driver, preferredCommMethod, 3);
			Utility_Functions.xClick(driver, preferredCommMethod, true);
			Utility_Functions.xWaitForElementPresent(driver, preferredCommMethodValue, 3);
			Utility_Functions.xClick(driver, preferredCommMethodValue, true);
			Utility_Functions.xWaitForElementPresent(driver, emailOptionsNewContactPage, 3);
			Utility_Functions.xClick(driver, emailOptionsNewContactPage, true);
			Utility_Functions.xWaitForElementPresent(driver, emailOptionsValueNewContactPage, 3);
			Utility_Functions.xClick(driver, emailOptionsValueNewContactPage, true);
			Utility_Functions.xWaitForElementPresent(driver, excludedReasonNewContactPage, 3);
			Utility_Functions.xClick(driver, excludedReasonNewContactPage, true);
			Utility_Functions.xWaitForElementPresent(driver, excludedReasonValueNewContactPage, 3);
			Utility_Functions.xClick(driver, excludedReasonValueNewContactPage, true);
			Utility_Functions.xWaitForElementPresent(driver, mailOptionsNewContactPage, 3);
			Utility_Functions.xClick(driver, mailOptionsNewContactPage, true);
			Utility_Functions.xWaitForElementPresent(driver, mailOptionsValueNewContactPage, 3);
			Utility_Functions.xClick(driver, mailOptionsValueNewContactPage, true);
			Calendar calendar = Calendar.getInstance();
			calendar.add(Calendar.DAY_OF_MONTH, -20);
			SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
			System.out.println("Date : " + dateFormat.format(calendar.getTime()));
			Utility_Functions.xWaitForElementPresent(driver, excludedOnNewContactpage, 3);
			Utility_Functions.xSendKeys(driver, excludedOnNewContactpage, dateFormat.format(calendar.getTime()));
			Utility_Functions.xWaitForElementPresent(driver, callOptionsNewContactPage, 3);
			Utility_Functions.xClick(driver, callOptionsNewContactPage, true);
			Utility_Functions.xWaitForElementPresent(driver, callOptionsValueNewContactPage, 3);
			Utility_Functions.xClick(driver, callOptionsValueNewContactPage, true);
			Utility_Functions.xWaitForElementPresent(driver, excludedByNewContactpage, 5);
			Utility_Functions.xSendKeys(driver, excludedByNewContactpage, "Test");
			excludedByNewContactpage.sendKeys(Keys.ARROW_DOWN);
			Utility_Functions.timeWait(2);
			excludedByNewContactpage.sendKeys(Keys.ENTER);

		}

		if (!(dataTable.getData("General_Data", "TC_ID").contains("Admin"))) {
			Utility_Functions.xWaitForElementPresent(driver, faxNewContactpage, 3);
			Utility_Functions.xSendKeys(driver, faxNewContactpage, dataTable.getData("General_Data", "Phone"));
			if (!dataTable.getData("General_Data", "TC_ID").contains("CMAMERCSSContactsPopulatingAllFields")) {
				Utility_Functions.xWaitForElementPresent(driver, assistantNameNewContactpage, 5);
				Utility_Functions.xSendKeys(driver, assistantNameNewContactpage, "Emi");
			}
			Utility_Functions.xWaitForElementPresent(driver, preferredCommMethod, 3);
			Utility_Functions.xClick(driver, preferredCommMethod, true);
			Utility_Functions.xWaitForElementPresent(driver, preferredCommMethodValue, 3);
			Utility_Functions.xClick(driver, preferredCommMethodValue, true);
			if (!dataTable.getData("General_Data", "TC_ID").contains("CMAMERCSSContactsPopulatingAllFields")) {
				Utility_Functions.xWaitForElementPresent(driver, assistantPhoneNewContactPage, 3);
				Utility_Functions.xSendKeys(driver, assistantPhoneNewContactPage,
						dataTable.getData("General_Data", "Phone"));
			}
			Calendar calendar = Calendar.getInstance();
			calendar.add(Calendar.DAY_OF_MONTH, -20);
			SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
			System.out.println("Date : " + dateFormat.format(calendar.getTime()));
			Utility_Functions.xWaitForElementPresent(driver, commEmailSentNewContactpage, 3);
			Utility_Functions.xSendKeys(driver, commEmailSentNewContactpage, dateFormat.format(calendar.getTime()));
			if (!dataTable.getData("General_Data", "TC_ID").contains("CMAMERCSSContactsPopulatingAllFields")) {
				Utility_Functions.xWaitForElementPresent(driver, assistantEmailNewContactPage, 3);
				Utility_Functions.xSendKeys(driver, assistantEmailNewContactPage,
						Utility_Functions.xGenerateAlphaNumericString() + dataTable.getData("General_Data", "Email"));
			}
			Utility_Functions.xWaitForElementPresent(driver, reasonForInactivating, 3);
			Utility_Functions.xClick(driver, reasonForInactivating, true);
			Utility_Functions.xWaitForElementPresent(driver, reasonForInactivatingValue, 3);
			Utility_Functions.xClick(driver, reasonForInactivatingValue, true);
			Calendar calendar1 = Calendar.getInstance();
			calendar1.add(Calendar.DAY_OF_MONTH, 10);
			SimpleDateFormat dateFormat1 = new SimpleDateFormat("MM/dd/yyyy");
			System.out.println("Date : " + dateFormat1.format(calendar1.getTime()));
			Utility_Functions.xWaitForElementPresent(driver, inactivationDateNewContactPage, 3);
			Utility_Functions.xSendKeys(driver, inactivationDateNewContactPage,
					dateFormat1.format(calendar1.getTime()));

		} else if (dataTable.getData("General_Data", "TC_ID").contains("Admin")) {
			Utility_Functions.xWaitForElementPresent(driver, faxNewContactpage, 3);
			Utility_Functions.xSendKeys(driver, faxNewContactpage, dataTable.getData("General_Data", "Phone"));
			Utility_Functions.xWaitForElementPresent(driver, assistantNameNewContactpage, 5);
			Utility_Functions.xSendKeys(driver, assistantNameNewContactpage, "Emi");
			Utility_Functions.xWaitForElementPresent(driver, assistantPhoneNewContactPage, 3);
			Utility_Functions.xSendKeys(driver, assistantPhoneNewContactPage,
					dataTable.getData("General_Data", "Phone"));
			Calendar calendar = Calendar.getInstance();
			calendar.add(Calendar.DAY_OF_MONTH, -20);
			SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
			System.out.println("Date : " + dateFormat.format(calendar.getTime()));
			Utility_Functions.xWaitForElementPresent(driver, commEmailSentNewContactpage, 3);
			Utility_Functions.xSendKeys(driver, commEmailSentNewContactpage, dateFormat.format(calendar.getTime()));
			Utility_Functions.xWaitForElementPresent(driver, assistantEmailNewContactPage, 3);
			Utility_Functions.xSendKeys(driver, assistantEmailNewContactPage,
					dataTable.getData("General_Data", "Email"));
			Calendar calendar1 = Calendar.getInstance();
			calendar1.add(Calendar.DAY_OF_MONTH, -10);
			SimpleDateFormat dateFormat1 = new SimpleDateFormat("MM/dd/yyyy");
			System.out.println("Date : " + dateFormat1.format(calendar1.getTime()));
			Utility_Functions.xWaitForElementPresent(driver, inactivationDateNewContactPage, 3);
			Utility_Functions.xSendKeys(driver, inactivationDateNewContactPage,
					dateFormat1.format(calendar1.getTime()));
			Utility_Functions.timeWait(2);
		}
		Utility_Functions.xWaitForElementPresent(driver, saveContact, 3);
		Utility_Functions.xClick(driver, saveContact, true);
		report.updateTestLog("Verify Contacts Populating all fields",
				"Contact has been created successfully and have clicked on Save Button", Status.PASS);
		Utility_Functions.timeWait(3);
		driver.switchTo().defaultContent();
		Utility_Functions.timeWait(2);
		driver.navigate().refresh();
		Utility_Functions.timeWait(2);
		Utility_Functions.xWaitForElementPresent(driver, details, 3);
		if (details.isDisplayed()) {

			report.updateTestLog("Verify Contacts Populating all fields",
					"The existing record can be updated and saved successfully", Status.PASS);
		} else {
			report.updateTestLog("Verify Contacts Populating all fields",
					"The existing record cannot be updated and saved successfully", Status.FAIL);
		}*/
	}

	/**
	 * Validating the Contacts Page Fields
	 * 
	 * @author Ramya
	 *
	 */
	public void verifyContactEditPageFields() {

		SearchTextSOQL searchTextSOQL = new SearchTextSOQL(scriptHelper);
		String queryId = "SELECT Id, Status__c FROM Contact where Status__c != 'Inactive' limit 1 offset 9";

		String contactId = searchTextSOQL.fetchRecordFieldValue("Id", queryId);

		String url = driver.getCurrentUrl().split("#")[0];
		String newUrl = url + "#/sObject/" + contactId;
		newUrl = newUrl + "/view";
		driver.get(newUrl);
		driver.navigate().refresh();
		Utility_Functions.timeWait(3);

		/*
		 * Utility_Functions.xWaitForElementPresent(driver, menu_Contacts, 3);
		 * Utility_Functions.xClick(driver, menu_Contacts, true);
		 * report.updateTestLog("Verify Contact Record Updation "
		 * ,"Contacts is Displayed ", Status.PASS);
		 * Utility_Functions.xWaitForElementPresent(driver, recentlyViewed, 3);
		 * Utility_Functions.xClick(driver, recentlyViewed, true);
		 * report.updateTestLog("Verify Contact Record Updation"
		 * ,"Recently viewed Contacts are Displayed ", Status.PASS);
		 * Utility_Functions.xWaitForElementPresent(driver, allContacts, 3);
		 * Utility_Functions.xClick(driver, allContacts, true);
		 * Utility_Functions.timeWait(3);
		 * report.updateTestLog("Verify Contact Record Updation"
		 * ,"All Contacts are Displayed ", Status.PASS); List<WebElement>
		 * contactNamesList = driver.findElements( By.
		 * xpath(".//a[@class='slds-truncate outputLookupLink slds-truncate forceOutputLookup'][contains(@data-recordid,'0030')]"
		 * ));
		 * 
		 * Utility_Functions.xclickRandomElement(contactNamesList);
		 * Utility_Functions.timeWait(3);
		 */
		try {
			Utility_Functions.xWaitForElementPresent(driver, edit, 3);
			Utility_Functions.xClick(driver, edit, true);
		} catch (Exception e) {

			Utility_Functions.xWaitForElementPresent(driver, showMoreActionsDetailsPage, 3);
			Utility_Functions.xClick(driver, showMoreActionsDetailsPage, true);
			Utility_Functions.xWaitForElementPresent(driver, showMoreActionsEdit, 3);
			Utility_Functions.xClick(driver, showMoreActionsEdit, true);

		}
		Utility_Functions.timeWait(2);
		Utility_Functions.xScrollWindow(driver);
		Utility_Functions.timeWait(1);
		Utility_Functions.xScrollWindowTop(driver);
		Utility_Functions.timeWait(4);
		try {
			Utility_Functions.xWaitForElementPresent(driver, emailContactEditPage, 3);
			Utility_Functions.xClick(driver, emailContactEditPage, true);
			Utility_Functions.xWaitForElementPresent(driver, statusEditPage, 3);
			Utility_Functions.xClick(driver, statusEditPage, true);
			Utility_Functions.xWaitForElementPresent(driver, statusValue, 3);
			Utility_Functions.xClick(driver, statusValue, true);
			Utility_Functions.xWaitForElementPresent(driver, reasonForInactivatingEditPage, 3);
			Utility_Functions.xClick(driver, reasonForInactivatingEditPage, true);
			Utility_Functions.xWaitForElementPresent(driver, reasonForInactivatingValueEditPage, 3);
			Utility_Functions.xClick(driver, reasonForInactivatingValueEditPage, true);
			System.out.println(Calendar.getInstance());
			DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
			Date date = new Date();
			Utility_Functions.xWaitForElementPresent(driver, inactivationDateEditPage, 3);
			Utility_Functions.xSendKeys(driver, inactivationDateEditPage, dateFormat.format(date).toString());
			Utility_Functions.xWaitForElementPresent(driver, saveContactEditpage, 3);
			Utility_Functions.xClick(driver, saveContactEditpage, true);
			Utility_Functions.timeWait(2);
			driver.navigate().refresh();
			Utility_Functions.timeWait(2);
			Utility_Functions.xWaitForElementPresent(driver, details, 3);
			if (details.isDisplayed()) {

				report.updateTestLog("Verify Contact Edit Page", "The existing record is edited and saved successfully",
						Status.PASS);
			} else {
				report.updateTestLog("Verify Contact Edit Page", "The existing record cannot be edited and saved ",
						Status.FAIL);
			}
		} catch (Exception e) {
			System.out.println(
					"The Status, Reason for Inactivating and Inactivation date fields are not present in the selected contact");

		}

	}

	/**
	 * Validating the status and Reason for Inactivation fields in the Contacts
	 * edit page
	 * 
	 * @author Ramya
	 *
	 */
	public void verifyContactEditPageNotEditableFields() {

		SearchTextSOQL searchTextSOQL = new SearchTextSOQL(scriptHelper);
		String queryId = "SELECT Id, Status__c FROM Contact where Status__c = 'Inactive' limit 1";

		String contactId = searchTextSOQL.fetchRecordFieldValue("Id", queryId);

		String url = driver.getCurrentUrl().split("#")[0];
		String newUrl = url + "#/sObject/" + contactId;
		newUrl = newUrl + "/view";
		driver.get(newUrl);
		driver.navigate().refresh();
		Utility_Functions.timeWait(3);

		try {
			Utility_Functions.xWaitForElementPresent(driver, edit, 3);
			Utility_Functions.xClick(driver, edit, true);
		} catch (Exception e) {

			Utility_Functions.xWaitForElementPresent(driver, showMoreActionsDetailsPage, 3);
			Utility_Functions.xClick(driver, showMoreActionsDetailsPage, true);
			Utility_Functions.xWaitForElementPresent(driver, showMoreActionsEdit, 3);
			Utility_Functions.xClick(driver, showMoreActionsEdit, true);

		}
		Utility_Functions.timeWait(2);
		Utility_Functions.xScrollWindow(driver);
		Utility_Functions.timeWait(1);
		Utility_Functions.xScrollWindowTop(driver);
		Utility_Functions.timeWait(4);
		Utility_Functions.xWaitForElementPresent(driver, emailContactEditPage, 3);
		Utility_Functions.xClick(driver, emailContactEditPage, true);
		try {
			Utility_Functions.xWaitForElementPresent(driver, statusEditPage, 3);
			Utility_Functions.xClick(driver, statusEditPage, true);
			Utility_Functions.xWaitForElementPresent(driver, statusValue, 3);
			Utility_Functions.xClick(driver, statusValue, true);
			Utility_Functions.xWaitForElementPresent(driver, reasonForInactivatingEditPage, 3);
			Utility_Functions.xClick(driver, reasonForInactivatingEditPage, true);
			Utility_Functions.xWaitForElementPresent(driver, reasonForInactivatingValueEditPage, 3);
			Utility_Functions.xClick(driver, reasonForInactivatingValueEditPage, true);
			System.out.println(Calendar.getInstance());
			DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
			Date date = new Date();
			Utility_Functions.xWaitForElementPresent(driver, inactivationDateEditPage, 3);
			Utility_Functions.xSendKeys(driver, inactivationDateEditPage, dateFormat.format(date).toString());
			Utility_Functions.xWaitForElementPresent(driver, saveContactEditpage, 3);
			Utility_Functions.xClick(driver, saveContactEditpage, true);
			Utility_Functions.timeWait(2);
			driver.navigate().refresh();
			Utility_Functions.timeWait(2);
			Utility_Functions.xWaitForElementPresent(driver, details, 3);
			if (details.isDisplayed()) {
				report.updateTestLog("Verify Contact Edit Page", "The existing record is edited and saved successfully",
						Status.PASS);
			} else {
				report.updateTestLog("Verify Contact Edit Page", "The existing record cannot be edited and saved ",
						Status.FAIL);
			}
		} catch (Exception e) {
			System.out.println(
					"The Status, Reason for Inactivating and Inactivation date fields are not present in the selected contact");

		}
	}

	static ArrayList<String> marketingSegmentationFieldsList = new ArrayList<String>();

	public void marketingSegmentationFields() {
		marketingSegmentationFieldsList.add("Client Interest - Asset Class");
		marketingSegmentationFieldsList.add("Client Interest - Type");
		marketingSegmentationFieldsList.add("Client Interest - Topics");
		marketingSegmentationFieldsList.add("Events");
		marketingSegmentationFieldsList.add("Client Interest - Industry");
		marketingSegmentationFieldsList.add("Occupier Client Type");
		marketingSegmentationFieldsList.add("Client Level of Influence");
		marketingSegmentationFieldsList.add("CBRE Level of Engagement");
		marketingSegmentationFieldsList.add("Satisfaction Survey Participation");
		marketingSegmentationFieldsList.add("Meeting Engagement");

		System.out.println("Marketing segmentation fields are:: " + marketingSegmentationFieldsList);
	}

	public void contactsMarketingSegmentationFields() {
		Utility_Functions.xWaitForElementPresent(driver, menu_Contacts, 3);
		Utility_Functions.xClick(driver, menu_Contacts, true);
		Utility_Functions.xWaitForElementPresent(driver, recentlyViewed, 3);
		Utility_Functions.xClick(driver, recentlyViewed, true);
		Utility_Functions.xWaitForElementPresent(driver, allContacts, 3);
		Utility_Functions.xClick(driver, allContacts, true);
		Utility_Functions.timeWait(3);
		List<WebElement> contactNamesList = driver
				.findElements(By.xpath("//a[@class='slds-truncate outputLookupLink slds-truncate forceOutputLookup']"));
		Utility_Functions.xclickOnFirstElementfromList(contactNamesList);
		Utility_Functions.timeWait(3);
		Utility_Functions.xScrollWindow(driver);
		Utility_Functions.timeWait(1);
		Utility_Functions.xScrollWindowTop(driver);
		Utility_Functions.timeWait(2);
		List<WebElement> contactDetailsMarketingSegmentationList = driver.findElements(By.xpath(
				"//span[contains(text(),'Marketing Segmentation')]/parent::button/parent::h3/following-sibling::div//div[@class='test-id__field-label-container']/span[text()!='']"));
		int count0 = 0, i0 = 0, j0 = 0;
		;
		String fieldsArray0[] = new String[contactDetailsMarketingSegmentationList.size()];
		System.out.println(contactDetailsMarketingSegmentationList.size());
		try {

			marketingSegmentationFields();
			while (j0 < contactDetailsMarketingSegmentationList.size()) {
				for (WebElement element0 : contactDetailsMarketingSegmentationList) {
					fieldsArray0[i0] = element0.getText();
					if (fieldsArray0[i0].contains(marketingSegmentationFieldsList.get(j0))) {
						System.out.println("Contacts Details page headers are " + element0.getText());
						report.updateTestLog("Verify Contacts Landing Page",
								" Contact Details Page are having the " + fieldsArray0[i0] + " Headers ", Status.PASS);
						count0++;
					}
					i0++;
				}
				i0 = 0;
				j0++;
			}
			System.out.println(count0);
			if (count0 != 10) {
				report.updateTestLog("Verify Contacts Landing Page",
						"All sections are not present in the Contacts Details Page", Status.FAIL);
			} else {

				report.updateTestLog("Verify Leads Landing Page",
						"All sections are present in the Contacts Details Page", Status.PASS);
			}

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

}
