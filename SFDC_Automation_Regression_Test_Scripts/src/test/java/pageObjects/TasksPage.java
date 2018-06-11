package pageObjects;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.cognizant.Craft.ReusableLibrary;
import com.cognizant.Craft.ScriptHelper;
import com.cognizant.framework.Status;
import supportLibraries.SF_UtilityFunctions;
import supportLibraries.Utility_Functions;

/*
* Page Object Class for Task Page
* 
* @author Haritha
*
*/

public class TasksPage extends ReusableLibrary {
	/*
	 * Constructor to initialize the business component library
	 * 
	 * @param scriptHelper The {@link ScriptHelper} object passed from the {@link
	 * DriverScript}
	 */

	public TasksPage(ScriptHelper scriptHelper) {
		super(scriptHelper);
		PageFactory.initElements(driver.getWebDriver(), this);
	}

	// public static String activityPast;
	// public static String activityPresent;
	// public static String activityFuture;

	/**
	 * Validating the New Activity creation
	 */

	@FindBy(xpath = "//span[text()='Add']")
	WebElement addActivity;

	// @FindBy(xpath =
	// "//label/span[text()='Subject']/parent::label/parent::div/input")

	@FindBy(xpath = "//label/span[text()='Subject']/parent::label/parent::div/descendant::input")
	WebElement activitySubject;

	@FindAll(value = { @FindBy(xpath = "//div[@class='select-options']/ul/li/a[text()='Private - Initial Meeting']") })
	List<WebElement> newActivityType;

	@FindBy(xpath = "//input[contains(@class,'inputDate')]")
	WebElement activityInputDate;

	@FindAll(value = { @FindBy(xpath = "//input[@title='Search Accounts']") })
	List<WebElement> activitySearchAccounts;

	@FindAll(value = { @FindBy(xpath = "//input[@title='Search Contacts']") })
	List<WebElement> activitySearchContacts;

	@FindBy(css = "ul>li.forceSearchInputLookupDesktopOption:nth-child(1)")
	WebElement firstLookupElement;

	/**
	 * Validating the creation of new Event on Tasks page
	 */

	@FindBy(xpath = "//span[text()='New Event']")
	WebElement newEvent;

	@FindAll(value = { @FindBy(xpath = "//div[@class='select-options']/ul/li/a[text()='Call']") })
	List<WebElement> newEventType;

	@FindAll(value = {
			@FindBy(xpath = "//span[contains(text(),'Activity Type')]/parent::span/following-sibling::div/descendant::a[@class='select'][text()='--None--']") })
	List<WebElement> eventActivityTypeList;

	@FindAll(value = { @FindBy(xpath = "//div[@class='select-options']/ul/li[3]/a[text()='Private - Cold Call']") })
	List<WebElement> newActivityEventType;

	@FindBy(xpath = "//span[contains(text(),'Start')]/parent::legend/following-sibling::div/div/input")
	WebElement eventStartDate;

	@FindBy(xpath = "//span[contains(text(),'End')]/parent::legend/following-sibling::div/div/input")
	WebElement eventEndDate;

	/**
	 * Validating the created Activity page
	 */

	@FindBy(xpath = "//button[contains(@class,'slds-button slds-button--neutral showMore slds-button slds-button--neutral uiButton')]")
	List<WebElement> btnPastActivity;

	@FindBy(xpath = "//button[@class='slds-button slds-button--neutral howMore slds-button slds-button--neutral uiButton']")
	List<WebElement> btnMoreActivity;

	/**
	 * Validating Activity created displaying Account name
	 */

	@FindBy(xpath = "//span[text()='Related To']/parent::div/following-sibling::div/span/div/a")
	WebElement lblRelatedTo;

	@FindBy(xpath = "//button[@title='Edit Send Notification Email']")
	WebElement emailNotification;

	@FindBy(xpath = "//span[text()='Send Notification Email']/parent::label/following-sibling::input")
	WebElement notificationCheckBox;

	/**
	 * Validating Activity Timeline
	 */
	@FindBy(xpath = "//*[text()='No Next Steps. Open And Upcoming Activities Show Up Here.']")
	WebElement openAndUpcomingActivites;

	/**
	 * Validating the creation of New Task
	 */

	@FindBy(xpath = "//button[@title='Add']")
	List<WebElement> addBtnTask1;

	@FindBy(xpath = "//label/span[text()='Subject']/parent::label/parent::div/input")
	WebElement taskSubject;

	@FindAll(value = { @FindBy(xpath = "//a[@class='select'][text()='--None--']") })
	List<WebElement> activityTypeList;

	@FindBy(xpath = "//a[text()='Private - Initial Meeting']")
	WebElement activityType1;

	@FindAll(value = { @FindBy(xpath = "//div[contains(@class,'bottomBarRight')]//span[text()='Save']") })
	List<WebElement> activitySave;

	@FindBy(xpath = "//one-app-launcher-header/button")
	WebElement applauncher;
	
	/**
	 * Validating the edit page of newly created Comp
	 */

	@FindBy(xpath = "//*[contains(@id,'g') and text()='Task']")
	WebElement taskName;

	@FindBy(xpath = "//*[@title='Edit']")
	List<WebElement> editTask;

	@FindBy(xpath = "//*[@class=' input']")
	List<WebElement> editTaskName;

	@FindBy(xpath = "//button[contains(@class, 'Button-') and @title='Save']")
	WebElement saveBtnTask;
	
	/*
	 * Validating the Task deletion on Comp's Task page
	 */

	@FindBy(xpath = "//*[contains(@class,'slds-truncate') and @title ='Delete']")
	List<WebElement> deleteTask;

	@FindBy(xpath = "//*[contains(@class,'slds-button') and @title ='Delete']")
	WebElement deleteTaskPopup;
	
	/*
	 * Validating the status change on Comp's Task page
	 */

	@FindBy(xpath = "//*[@class='slds-checkbox--faux']")
	List<WebElement> checkBoxTask;
	
	/*
	 * Validating the status of task on Comp's page
	 */

	@FindBy(xpath = "//div[text()='Activity Type']")
	WebElement activityTypeTask;

	@FindBy(xpath = "//div[text()='Status']")
	WebElement statusTask;

	@FindBy(xpath = "//div[text()='Comments']")
	WebElement commentTask;
	
	


	// AccountsPage sfaccountsPage= new AccountsPage(scriptHelper);

	DateFormat dateFormat;
	// DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
	Date date = new Date();
	SF_UtilityFunctions sf_UtilityFunctions = new SF_UtilityFunctions(scriptHelper);

	/**
	 * Validating the New Activity creation on Tasks Page
	 * 
	 * @author Haritha
	 */

	public void createNewActivity() {
		if (properties.getProperty("RunEnvironment").equalsIgnoreCase("UAT")) {
			dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		} else {
			dateFormat = new SimpleDateFormat("MM/dd/yyyy");
		}
		String sActivitySubject = null;
		String activityPresent = null;
		String activityPast = null;
		String activityFuture = null;
		String accountName = null;

		/*
		 * try{ accountName=accountNameSaved.getText(); }catch(Exception e){
		 * accountName=accountNameSavedEnv.getText(); }
		 */
		int activityTimes = 1;
		if (dataTable.getData("General_Data", "TC_ID").contains("Activity")
				&& dataTable.getData("General_Data", "TC_ID").contains("FRANEMEA")
				&& !dataTable.getData("General_Data", "TC_ID").contains("Expand")) {
			activityTimes = 3;
		}
		if (dataTable.getData("General_Data", "TC_ID").contains("Activity")
				&& dataTable.getData("General_Data", "TC_ID").contains("FRANEMEA")) {
			for (int i = 1; i <= activityTimes; i++) {
				Utility_Functions.xScrollWindowTop(driver);
				Utility_Functions.xWaitForElementPresent(driver, addActivity, 3);
				Utility_Functions.xClickHiddenElement(driver, addActivity);
				report.updateTestLog("Verify New Activity Page Layout ",
						"The New Activity in the Details page is Displayed ", Status.PASS);
				if ((dataTable.getData("General_Data", "TC_ID").contains("AccountsCreationOfNewActivityPage"))
						|| (dataTable.getData("General_Data", "TC_ID").contains("ContactsReminderSentFunctionality"))
						|| (dataTable.getData("General_Data", "TC_ID").contains("ContactNewActivityPageLayout"))
						|| (dataTable.getData("General_Data", "TC_ID").contains("PropertiesNewActivityLayoutPage"))) {
					verifyNewActivityPageLayout();
				}

				Utility_Functions.xWaitForElementPresent(driver, activitySubject, 3);
				if (i == 1) {
					sActivitySubject = "Test Automation Subject_Present"
							+ Utility_Functions.xGenerateAlphaNumericString();
					activityPresent = sActivitySubject;
					System.out.println(activityPresent);
				} else if (i == 2) {
					sActivitySubject = "Test Automation Subject_Past" + Utility_Functions.xGenerateAlphaNumericString();
					activityPast = sActivitySubject;
					System.out.println(activityPast);
				} else {
					sActivitySubject = "Test Automation Subject_Future"
							+ Utility_Functions.xGenerateAlphaNumericString();
					activityFuture = sActivitySubject;
					System.out.println(activityFuture);
				}
				Utility_Functions.xSendKeys(driver, activitySubject, sActivitySubject);
				Utility_Functions.xScrollWindowTop(driver);
				Utility_Functions.timeWait(2);

				if (!dataTable.getData("General_Data", "TC_ID").contains("Lead")
						&& !dataTable.getData("General_Data", "TC_ID").contains("Contact")) {
					// Utility_Functions.xWaitForElementPresent(driver, activityTypeList, 3);
					// Utility_Functions.xClick(driver, activityTypeList, true);
					Utility_Functions.xClickVisibleListElement(driver, activityTypeList);
					// Utility_Functions.xWaitForElementPresent(driver, newActivityType, 3);
					// Utility_Functions.xClick(driver, newActivityType, true);
					Utility_Functions.timeWait(2);
					Utility_Functions.xClickVisibleListElement(driver, newActivityType);
				} else if (dataTable.getData("General_Data", "TC_ID").contains("Contact")
						&& properties.getProperty("RunEnvironment").equalsIgnoreCase("UAT")) {
					Utility_Functions.xClickVisibleListElement(driver, activityTypeList);
					// Utility_Functions.xWaitForElementPresent(driver, newActivityType, 3);
					// Utility_Functions.xClick(driver, newActivityType, true);
					Utility_Functions.timeWait(2);
					Utility_Functions.xClickVisibleListElement(driver, newActivityType);
				}
				if (i == 1) {
					Utility_Functions.xWaitForElementPresent(driver, activityInputDate, 3);
					Utility_Functions.xSendKeys(driver, activityInputDate, dateFormat.format(date).toString());
					// Utility_Functions.xSendKeys(driver, el, keyName);
				} else if (i == 2) {
					Calendar calendar = Calendar.getInstance();

					// Move calendar to yesterday
					calendar.add(Calendar.DATE, -1);

					// Get current date of calendar which point to the yesterday now
					Date newDate = calendar.getTime();
					Utility_Functions.xWaitForElementPresent(driver, activityInputDate, 3);
					Utility_Functions.xSendKeys(driver, activityInputDate, dateFormat.format(newDate).toString());

				} else {
					Calendar calendar = Calendar.getInstance();

					// Move calendar to future
					calendar.add(Calendar.DATE, 1);

					// Get current date of calendar which point to the yesterday now
					Date newDate = calendar.getTime();
					Utility_Functions.xWaitForElementPresent(driver, activityInputDate, 3);
					Utility_Functions.xSendKeys(driver, activityInputDate, dateFormat.format(newDate).toString());

				}
				Utility_Functions.xScrollWindowOnce(driver);
				if (!dataTable.getData("General_Data", "TC_ID").contains("Lead")) {
					if ((dataTable.getData("General_Data", "TC_ID").contains("ContactsReminderSentFunctionality"))
							|| (dataTable.getData("General_Data", "TC_ID")
									.contains("ContactsCreationOfNewActivityPage"))
							|| (dataTable.getData("General_Data", "TC_ID").contains("ContactsNewActivityLayoutPage"))
							|| (dataTable.getData("General_Data", "TC_ID").contains("Contact"))) {
						// Utility_Functions.xWaitForElementPresent(driver, activitySearchAccounts, 3);
						Utility_Functions.timeWait(2);
						Utility_Functions.xClickVisibleListElement(driver, activitySearchAccounts);
					} else {
						// Utility_Functions.xWaitForElementPresent(driver, activitySearchContacts, 3);
						Utility_Functions.timeWait(2);
						Utility_Functions.xClickVisibleListElement(driver, activitySearchContacts);
						// Utility_Functions.xSendKeys(driver, activitySearchContacts, "Vishnu");
					}
					Utility_Functions.timeWait(2);
					Utility_Functions.xWaitForElementPresent(driver, firstLookupElement, 4);
					Utility_Functions.xClick(driver, firstLookupElement, true);
				}
				Utility_Functions.timeWait(3);
				// Utility_Functions.xWaitForElementPresent(driver, activitySave, 3);
				Utility_Functions.xClickVisibleListElement(driver, activitySave);
				report.updateTestLog("Verify New Activity", "Verifying whether the New Activity page is saved ",
						Status.PASS);
				Utility_Functions.timeWait(3);
			}
		}

		/*
		 * String query = "SELECT Subject__c FROM Activity__c where Subject__c = " + "'"
		 * + sActivitySubject + "'"; System.out.println("Activity Subject:: "+
		 * sActivitySubject); String record =
		 * searchTextSOQL.fetchRecordFieldValue("Subject__c", query);
		 * if(record.equals(sActivitySubject)) {
		 * report.updateTestLog("Verify New Activity Page",
		 * "Activity has been created successfully", Status.PASS); } else {
		 * report.updateTestLog("Verify New Activity Page",
		 * "Activity didn't get created", Status.FAIL); }
		 */
		/*
		 * Utility_Functions.timeWait(3);
		 * Utility_Functions.xWaitForElementPresent(driver, related, 5);
		 * Utility_Functions.xClick(driver, related, true);
		 * Utility_Functions.xScrollWindow(driver); Utility_Functions.timeWait(1);
		 * Utility_Functions.xScrollWindowTop(driver); Utility_Functions.timeWait(2);
		 * Utility_Functions.xWaitForElementPresent(driver, relatedActivities, 5);
		 * Utility_Functions.xClick(driver, relatedActivities, true); List<WebElement>
		 * relatedActivitiesList = null; if((dataTable.getData("General_Data",
		 * "TC_ID").contains("ContactsReminderSentFunctionality")) ||
		 * (dataTable.getData("General_Data",
		 * "TC_ID").contains("ContactsCreationOfNewActivityPage")) ||
		 * (dataTable.getData("General_Data",
		 * "TC_ID").contains("ContactsNewActivityLayoutPage")) ||
		 * (dataTable.getData("General_Data", "TC_ID").contains("Contacts"))) {
		 * relatedActivitiesList = driver.findElements( By.
		 * xpath("//a[@class='slds-truncate outputLookupLink slds-truncate forceOutputLookup'][contains(@data-recordid,'00T')]"
		 * )); } else if ((dataTable.getData("General_Data",
		 * "TC_ID").contains("AccountsCreationOfNewActivityPage")) ||
		 * (dataTable.getData("General_Data", "TC_ID").contains("Accounts"))) {
		 * relatedActivitiesList = driver.findElements( By.
		 * xpath("//a[@class='slds-truncate outputLookupLink slds-truncate forceOutputLookup'][contains(@data-recordid,'00U')]"
		 * )); } for (WebElement element : relatedActivitiesList) { if
		 * (element.getText().contains(sActivitySubject)) {
		 * report.updateTestLog("Verify Create Activity Contact",
		 * "The New Activity for Accounts/ Contacts are created ", Status.PASS); break;
		 * } else { report.updateTestLog("Verify Create Activity Contact",
		 * "The New Activity for Accounts/ Contacts are not created ", Status.WARNING);
		 * } }
		 */
		if (dataTable.getData("General_Data", "TC_ID").contains("Activity")
				&& dataTable.getData("General_Data", "TC_ID").contains("FRANEMEA")
				&& dataTable.getData("General_Data", "TC_ID").contains("Expand")) {
			validateActivityExpandAll(activityPast, activityPresent, activityFuture);
		} else if (dataTable.getData("General_Data", "TC_ID").contains("Activity")
				&& dataTable.getData("General_Data", "TC_ID").contains("FRANEMEA")
				&& dataTable.getData("General_Data", "TC_ID").contains("CreationDates")) {
			validateActivityDetails(activityPast, activityPresent, activityFuture, accountName);
		} else if (dataTable.getData("General_Data", "TC_ID").contains("Activity")
				&& dataTable.getData("General_Data", "TC_ID").contains("FRANEMEA")) {
			validateAccountActivity(activityPast, activityPresent, activityFuture);
		}

		report.updateTestLog("Verify Activity page", "The Activity tag is created and saved successfully", Status.PASS);
	}

	/**
	 * Validating the creation of new Event on Tasks page
	 * 
	 * @author Haritha
	 */

	public void createNewEvent() {
		System.out.println(properties.getProperty("RunEnvironment"));
		if (properties.getProperty("RunEnvironment").equalsIgnoreCase("UAT")) {
			dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		} else {
			dateFormat = new SimpleDateFormat("MM/dd/yyyy");
		}
		String sActivitySubject = null;
		String eventPast = null;
		String eventPresent = null;
		String eventFuture = null;
		int activityTimes = 1;
		if (dataTable.getData("General_Data", "TC_ID").contains("Event")
				&& dataTable.getData("General_Data", "TC_ID").contains("FRANEMEA")) {
			activityTimes = 3;
		}
		if (dataTable.getData("General_Data", "TC_ID").contains("Event")
				&& dataTable.getData("General_Data", "TC_ID").contains("FRANEMEA")) {
			for (int i = 1; i <= activityTimes; i++) {
				if (i == 1) {
					Utility_Functions.xScrollWindowTop(driver);
					Utility_Functions.xClickHiddenElement(driver, newEvent);
					Utility_Functions.xClick(driver, newEvent, true);
				} else {
					List<WebElement> eleList = driver.findElements(By.xpath("//span[text()='Add']"));
					Utility_Functions.xWaitForElementPresent(driver, eleList.get(1), 3);
					Utility_Functions.xClick(driver, eleList.get(1), true);
				}
				report.updateTestLog("Verify New Activity Page Layout ",
						"The New Activity in the Details page is Displayed ", Status.PASS);
				if ((dataTable.getData("General_Data", "TC_ID").contains("AccountsCreationOfNewActivityPage"))
						|| (dataTable.getData("General_Data", "TC_ID").contains("ContactsReminderSentFunctionality"))
						|| (dataTable.getData("General_Data", "TC_ID").contains("ContactNewActivityPageLayout"))
						|| (dataTable.getData("General_Data", "TC_ID").contains("PropertiesNewActivityLayoutPage"))) {
					verifyNewActivityPageLayout();
				}

				Utility_Functions.timeWait(3);
				if (i == 1) {
					sActivitySubject = "Event Automation Subject_Present"
							+ Utility_Functions.xGenerateAlphaNumericString();
					eventPresent = sActivitySubject;
					System.out.println(eventPresent);
				} else if (i == 2) {
					sActivitySubject = "Event Automation Subject_Past"
							+ Utility_Functions.xGenerateAlphaNumericString();
					eventPast = sActivitySubject;
					System.out.println(eventPast);
				} else {
					sActivitySubject = "Event Automation Subject_Future"
							+ Utility_Functions.xGenerateAlphaNumericString();
					eventFuture = sActivitySubject;
					System.out.println(eventFuture);
				}
				List<WebElement> subjectList = driver
						.findElements(By.xpath("//label/span[text()='Subject']/parent::label/parent::div/input"));
				Utility_Functions.xSendKeysVisibleListElement(driver, subjectList, sActivitySubject);
				/*
				 * for(WebElement element : subjectList){
				 * System.out.println(element.isDisplayed()); if(element.isDisplayed()){
				 * Utility_Functions.xSendKeys(driver, element, sActivitySubject); break; }
				 * 
				 * }
				 */
				// Utility_Functions.xSendKeys(driver, activitySubject, sActivitySubject);
				Utility_Functions.xScrollWindowTop(driver);
				Utility_Functions.timeWait(2);
				if ((dataTable.getData("General_Data", "TC_ID").contains("Lead"))
						|| (dataTable.getData("General_Data", "TC_ID").contains("Contact")
								&& !properties.getProperty("RunEnvironment").equalsIgnoreCase("UAT"))) {
					// Utility_Functions.xClickVisibleListElement(driver, eleList);
					// Utility_Functions.xWaitForElementPresent(driver, activityTypeList, 3);
					Utility_Functions.xClickVisibleListElement(driver, activityTypeList);
					Utility_Functions.timeWait(2);
					// Utility_Functions.xWaitForElementPresent(driver, newEventType, 3);
					Utility_Functions.xClickVisibleListElement(driver, newEventType);
				} else {
					// Utility_Functions.xWaitForElementPresent(driver, eventActivityTypeList, 3);
					Utility_Functions.xClickVisibleListElement(driver, eventActivityTypeList);
					// Utility_Functions.xWaitForElementPresent(driver, newActivityEventType, 3);
					Utility_Functions.timeWait(2);
					Utility_Functions.xClickVisibleListElement(driver, newActivityEventType);
				}

				if (i == 1) {
					Utility_Functions.xWaitForElementPresent(driver, eventStartDate, 3);
					Utility_Functions.xSendKeys(driver, eventStartDate, dateFormat.format(date).toString());

					Utility_Functions.xWaitForElementPresent(driver, eventEndDate, 3);
					Utility_Functions.xSendKeys(driver, eventEndDate, dateFormat.format(date).toString());
					// Utility_Functions.xSendKeys(driver, el, keyName);
				} else if (i == 2) {
					Calendar calendar = Calendar.getInstance();

					// Move calendar to yesterday
					calendar.add(Calendar.DATE, -1);

					// Get current date of calendar which point to the yesterday now
					Date newDate = calendar.getTime();
					Utility_Functions.xWaitForElementPresent(driver, eventStartDate, 3);
					Utility_Functions.xSendKeys(driver, eventStartDate, dateFormat.format(newDate).toString());

					Utility_Functions.xWaitForElementPresent(driver, eventEndDate, 3);
					Utility_Functions.xSendKeys(driver, eventEndDate, dateFormat.format(newDate).toString());

				} else {
					Calendar calendar = Calendar.getInstance();

					// Move calendar to future
					calendar.add(Calendar.DATE, 1);

					// Get current date of calendar which point to the yesterday now
					Date newDate = calendar.getTime();
					Utility_Functions.xWaitForElementPresent(driver, eventStartDate, 3);
					Utility_Functions.xSendKeys(driver, eventStartDate, dateFormat.format(newDate).toString());

					Utility_Functions.xWaitForElementPresent(driver, eventEndDate, 3);
					Utility_Functions.xSendKeys(driver, eventEndDate, dateFormat.format(newDate).toString());
				}
				if (!dataTable.getData("General_Data", "TC_ID").contains("Lead")) {
					if ((dataTable.getData("General_Data", "TC_ID").contains("ContactsReminderSentFunctionality"))
							|| (dataTable.getData("General_Data", "TC_ID")
									.contains("ContactsCreationOfNewActivityPage"))
							|| (dataTable.getData("General_Data", "TC_ID").contains("ContactsNewActivityLayoutPage"))
							|| (dataTable.getData("General_Data", "TC_ID").contains("Contact"))) {
						// Utility_Functions.xWaitForElementPresent(driver, activitySearchAccounts, 3);
						Utility_Functions.timeWait(2);
						Utility_Functions.xClickVisibleListElement(driver, activitySearchAccounts);
					} else {
						Utility_Functions.timeWait(2);
						Utility_Functions.xClickVisibleListElement(driver, activitySearchContacts);
						// Utility_Functions.xSendKeys(driver, activitySearchContacts, "Vishnu");
					}
					Utility_Functions.xWaitForElementPresent(driver, firstLookupElement, 4);
					Utility_Functions.xClick(driver, firstLookupElement, true);
				}
				Utility_Functions.timeWait(3);
				// Utility_Functions.xWaitForElementPresent(driver, activitySave, 3);
				Utility_Functions.xClickVisibleListElement(driver, activitySave);
				report.updateTestLog("Verify New Activity", "Verifying whether the New Activity page is saved ",
						Status.PASS);
				Utility_Functions.timeWait(3);
			}
		}
		if (dataTable.getData("General_Data", "TC_ID").contains("Event")
				&& dataTable.getData("General_Data", "TC_ID").contains("FRANEMEA")
				&& !dataTable.getData("General_Data", "TC_ID").contains("Expand")) {
			validateEventActivity(eventPast, eventPresent, eventFuture);
		}
		report.updateTestLog("Verify New Event", "The New Event is created and saved successfully", Status.PASS);

	}

	/**
	 * Validating the created Activity page
	 * 
	 * @author Haritha
	 */

	public void validateAccountActivity(String activityPast, String activityPresent, String activityFuture) {
		Utility_Functions.xClickVisibleListElement(driver, btnPastActivity);
		Utility_Functions.timeWait(3);

		if (btnMoreActivity.size() > 0) {
			Utility_Functions.xClickVisibleListElement(driver, btnMoreActivity);
			Utility_Functions.timeWait(3);
		}

		System.out.println(driver.findElement(
				By.xpath("//div[@class='timeline-container slds-m-top--medium']/ul/li/descendant::span[text()='"
						+ activityPresent + "']/following::span[1]/p[text()='Today']"))
				.isDisplayed());
		System.out
				.println(driver
						.findElement(By.xpath(
								"//div[@class='timeline-container slds-m-top--medium']/ul/li/descendant::span[text()='"
										+ activityFuture + "']/following::span[1]/p[text()='Tomorrow']"))
						.isDisplayed());
		System.out.println(driver.findElement(
				By.xpath("//div[@class='timeline-container slds-m-top--medium']/ul/li/descendant::span[text()='"
						+ activityPast + "']/following::span[1]/p[text()='Yesterday']"))
				.isDisplayed());
		if (driver
				.findElement(
						By.xpath("//div[@class='timeline-container slds-m-top--medium']/ul/li/descendant::span[text()='"
								+ activityPast + "']/following::span[1]/p[text()='Yesterday']"))
				.isDisplayed()
				&& driver.findElement(
						By.xpath("//div[@class='timeline-container slds-m-top--medium']/ul/li/descendant::span[text()='"
								+ activityPresent + "']/following::span[1]/p[text()='Today']"))
						.isDisplayed()
				&& driver
						.findElement(By.xpath(
								"//div[@class='timeline-container slds-m-top--medium']/ul/li/descendant::span[text()='"
										+ activityFuture + "']/following::span[1]/p[text()='Tomorrow']"))
						.isDisplayed()) {
			report.updateTestLog("Verify created Activity",
					"Verifying whether the created Activity page is displaying ", Status.PASS);
		} else {
			report.updateTestLog("Verify created Activity",
					"Verifying whether the created Activity page is displaying ", Status.FAIL);
		}

	}

	/**
	 * Validating Activity created displaying Account name
	 * 
	 * @author Haritha
	 */

	public void validateActivityDetails(String activityPast, String activityPresent, String activityFuture,
			String accountName) {
		Utility_Functions.xClickVisibleListElement(driver, btnPastActivity);
		Utility_Functions.timeWait(3);

		if (btnMoreActivity.size() > 0) {
			Utility_Functions.xClickVisibleListElement(driver, btnMoreActivity);
			Utility_Functions.timeWait(3);
		}

		Utility_Functions.xWaitForElementPresent(driver,
				driver.findElement(
						By.xpath("//div[@class='timeline-container slds-m-top--medium']/ul/li/descendant::span[text()='"
								+ activityPresent + "']")),
				3);
		Utility_Functions.xClickHiddenElement(driver,
				driver.findElement(
						By.xpath("//div[@class='timeline-container slds-m-top--medium']/ul/li/descendant::span[text()='"
								+ activityPresent + "']")));
		Utility_Functions.timeWait(3);

		Utility_Functions.xWaitForElementPresent(driver, lblRelatedTo, 3);
		String accountNamelbl = lblRelatedTo.getText();
		System.out.println(accountNamelbl);
		System.out.println(accountName);
		if (accountNamelbl.equals(accountName)) {
			report.updateTestLog("Verify account name ",
					"Verifying whether the created Activity page is displaying the account name", Status.PASS);
		} else {
			report.updateTestLog("Verify account name",
					"Verifying whether the created Activity page is displaying the account name", Status.FAIL);
		}
		Utility_Functions.timeWait(3);
		// Utility_Functions.xWaitForElementPresent(driver,emailNotification, 3);
		// Utility_Functions.xMouseOver(driver,editButton);
		// Utility_Functions.xHoverElementclicks(editButton,driver);

		// Utility_Functions.xSwitchtoFrame(driver, emailNotification);
		Utility_Functions.xScrollWindowOnce(driver);
		Utility_Functions.xClickHiddenElement(driver, emailNotification);

		Utility_Functions.timeWait(3);
		// Utility_Functions.xWaitForElementPresent(driver,notificationCheckBox, 6);
		Utility_Functions.xClickHiddenElement(driver, notificationCheckBox);
		// Utility_Functions.xWaitForElementPresent(driver,activityEditSave, 3);
		Utility_Functions.timeWait(3);
		// Utility_Functions.xClickHiddenElement(driver,activityEditSave);
		List<WebElement> saveButton = driver.findElements(By.xpath("//span[text()='Save']"));
		Utility_Functions.xClickHiddenElement(driver, saveButton.get(1));
		Utility_Functions.timeWait(10);
		report.updateTestLog("Verify account name ",
				"Verifying whether the created Activity page is displaying the account name", Status.SCREENSHOT);
	}

	public void validateActivityExpandAll(String activityPast, String activityPresent, String activityFuture) {
		if (btnPastActivity.size() > 0) {
			Utility_Functions.xClickVisibleListElement(driver, btnPastActivity);
			Utility_Functions.timeWait(3);
		}

		if (btnMoreActivity.size() > 0) {
			Utility_Functions.xClickVisibleListElement(driver, btnMoreActivity);
			Utility_Functions.timeWait(3);
		}

		if (!dataTable.getData("General_Data", "TC_ID").contains("Lead")
				&& !(dataTable.getData("General_Data", "TC_ID").contains("Contact")
						&& properties.getProperty("RunEnvironment").equalsIgnoreCase("FTE2"))
				&& !(dataTable.getData("General_Data", "TC_ID").contains("Contact")
						&& properties.getProperty("RunEnvironment").equalsIgnoreCase("UAT2"))) {
			System.out.println(driver.findElement(By.xpath(
					"//div[@class='slds-media slds-tile slds-media--small']/descendant::span[text()='" + activityPresent
							+ "']/ancestor::div[1]/following-sibling::div[1][text()='Private - Initial Meeting']"))
					.isDisplayed());
			System.out.println(driver
					.findElement(
							By.xpath("//div[@class='slds-media slds-tile slds-media--small']/descendant::span[text()='"
									+ activityPresent + "']/ancestor::div[1]/following-sibling::div[2][text()='Open']"))
					.isDisplayed());

			if (driver.findElement(By.xpath(
					"//div[@class='slds-media slds-tile slds-media--small']/descendant::span[text()='" + activityPresent
							+ "']/ancestor::div[1]/following-sibling::div[1][text()='Private - Initial Meeting']"))
					.isDisplayed()
					&& driver.findElement(
							By.xpath("//div[@class='slds-media slds-tile slds-media--small']/descendant::span[text()='"
									+ activityPresent + "']/ancestor::div[1]/following-sibling::div[2][text()='Open']"))
							.isDisplayed()) {
				report.updateTestLog("Verify created Activity",
						"Verifying whether the created Activity page is displaying ", Status.PASS);
			} else {
				report.updateTestLog("Verify created Activity",
						"Verifying whether the created Activity page is displaying ", Status.FAIL);
			}
		} else {
			System.out.println(driver
					.findElement(
							By.xpath("//div[@class='slds-media slds-tile slds-media--small']/descendant::span[text()='"
									+ activityPresent
									+ "']/ancestor::div[1]/following-sibling::div[1][text()='Private - Task']"))
					.isDisplayed());
			System.out.println(driver
					.findElement(
							By.xpath("//div[@class='slds-media slds-tile slds-media--small']/descendant::span[text()='"
									+ activityPresent + "']/ancestor::div[1]/following-sibling::div[2][text()='Open']"))
					.isDisplayed());

			if (driver
					.findElement(
							By.xpath("//div[@class='slds-media slds-tile slds-media--small']/descendant::span[text()='"
									+ activityPresent
									+ "']/ancestor::div[1]/following-sibling::div[1][text()='Private - Task']"))
					.isDisplayed()
					&& driver.findElement(
							By.xpath("//div[@class='slds-media slds-tile slds-media--small']/descendant::span[text()='"
									+ activityPresent + "']/ancestor::div[1]/following-sibling::div[2][text()='Open']"))
							.isDisplayed()) {
				report.updateTestLog("Verify created Activity",
						"Verifying whether the created Activity page is displaying ", Status.PASS);
			} else {
				report.updateTestLog("Verify created Activity",
						"Verifying whether the created Activity page is displaying ", Status.FAIL);
			}
		}
	}

	/**
	 * Validating the Event Activity page
	 * 
	 * @author Haritha
	 */

	public void validateEventActivity(String eventPast, String eventPresent, String eventFuture) {
		if (btnPastActivity.size() > 0) {
			Utility_Functions.xClickVisibleListElement(driver, btnPastActivity);
			Utility_Functions.timeWait(3);
		}
		if (btnMoreActivity.size() > 0) {
			Utility_Functions.xClickVisibleListElement(driver, btnMoreActivity);
			Utility_Functions.timeWait(3);
		}

		System.out
				.println(driver
						.findElements(By.xpath(
								"//div[@class='slds-media slds-tile slds-media--small']/descendant::span[text()='"
										+ eventPresent + "']/ancestor::div[1]/following-sibling::div[text()='Today']"))
						.size());
		System.out.println(driver
				.findElements(
						By.xpath("//div[@class='slds-media slds-tile slds-media--small']/descendant::span[text()='"
								+ eventFuture + "']/ancestor::div[1]/following-sibling::div[text()='Tomorrow']"))
				.size());
		System.out.println(driver
				.findElements(
						By.xpath("//div[@class='slds-media slds-tile slds-media--small']/descendant::span[text()='"
								+ eventPast + "']/ancestor::div[1]/following-sibling::div[text()='Yesterday']"))
				.size());
		if (driver
				.findElement(By.xpath("//div[@class='slds-media slds-tile slds-media--small']/descendant::span[text()='"
						+ eventPast + "']/ancestor::div[1]/following-sibling::div[text()='Yesterday']"))
				.isDisplayed()
				&& driver
						.findElement(By.xpath(
								"//div[@class='slds-media slds-tile slds-media--small']/descendant::span[text()='"
										+ eventPresent + "']/ancestor::div[1]/following-sibling::div[text()='Today']"))
						.isDisplayed()
				&& driver.findElement(
						By.xpath("//div[@class='slds-media slds-tile slds-media--small']/descendant::span[text()='"
								+ eventFuture + "']/ancestor::div[1]/following-sibling::div[text()='Tomorrow']"))
						.isDisplayed()) {
			report.updateTestLog("Verify created Activity",
					"Verifying whether the created Activity page is displaying ", Status.PASS);
		} else {
			report.updateTestLog("Verify created Activity",
					"Verifying whether the created Activity page is displaying ", Status.FAIL);
		}

		/*
		 * if(driver.findElements(By.
		 * xpath("//div[@class='slds-media slds-tile slds-media--small']/descendant::span[text()='"
		 * +eventPresent+"']")).size()!=0){ report.updateTestLog("Verify Present Event",
		 * "Present event is created successfully", Status.PASS); }else{
		 * report.updateTestLog("Verify Present Event",
		 * "Present event is not created successfully", Status.FAIL); }
		 * if(driver.findElements(By.
		 * xpath("//div[@class='slds-media slds-tile slds-media--small']/descendant::span[text()='"
		 * +eventFuture+"']")).size()!=0){ report.updateTestLog("Verify Future Event",
		 * "Future event is created successfully", Status.PASS); }else{
		 * report.updateTestLog("Verify Future Event",
		 * "Future event is not created successfully", Status.FAIL); }
		 * if(driver.findElements(By.
		 * xpath("//div[@class='slds-media slds-tile slds-media--small']/descendant::span[text()='"
		 * +eventPast+"']")).size()!=0){ report.updateTestLog("Verify Past Event",
		 * "Past event is created successfully", Status.PASS); }else{
		 * report.updateTestLog("Verify Past Event",
		 * "Past event is not created successfully", Status.FAIL); }
		 */
	}

	/**
	 * Verifying the New Activity page layout
	 * 
	 * @author Haritha
	 */

	public void verifyNewActivityPageLayout() {
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
	}

	static ArrayList<String> activityTypeListValues = new ArrayList<String>();

	public void additionalActivityTypeList() {
		activityTypeListValues.add("");
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

	public void validateActivityTypeValues() {
		Utility_Functions.xWaitForElementPresent(driver, addActivity, 3);
		Utility_Functions.xClick(driver, addActivity, true);
		Utility_Functions.xScrollWindowTop(driver);
		Utility_Functions.timeWait(3);
		Utility_Functions.xWaitForElementPresent(driver, activitySubject, 3);
		// Utility_Functions.xWaitForElementPresent(driver, activityTypeList, 3);
		Utility_Functions.xClickVisibleListElement(driver, activityTypeList);
		List<WebElement> activityTypeValues = driver.findElements(By.xpath("//div[@class='select-options']/ul/li/a"));
		additionalActivityTypeList();
		String[] linkTexts = new String[activityTypeValues.size()];
		int i = 0, count = 0;
		try {
			for (WebElement element : activityTypeValues) {
				linkTexts[i] = element.getText();
				System.out.println("activityTypeValue found : " + element.getText() + "   Text needs to be verified : "
						+ activityTypeListValues.get(i));
				if (linkTexts[i].equals(activityTypeListValues.get(i))) {
					count++;
					report.updateTestLog("Verify Additional Acitivty",
							"Value " + element.getText() + "is present under Additional Activity List", Status.PASS);

				}
				i++;
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		System.out.println(count);
		if (count == 16) {
			report.updateTestLog("Verify Additional Acitivty",
					"All the values are present under Additional Activity List", Status.PASS);
		} else {
			report.updateTestLog("Verify Additional Acitivty",
					"All the values are not present under Additional Activity List", Status.FAIL);
		}
	}

	static ArrayList<String> pastActivityListValues = new ArrayList<String>();

	public void pastActivityListValues() {
		pastActivityListValues.add("Activity Type");
		pastActivityListValues.add("Status");
		pastActivityListValues.add("Comments");
		System.out.println("Activity Timeline values are added to the list successfully::::");
	}

	/**
	 * Validating Activity Timeline
	 * 
	 * @author Haritha
	 */

	public void validateActivityTimeLine() {
		driver.navigate().refresh();
		Utility_Functions.timeWait(2);
		int i = 0, count = 0;
		try {
			Utility_Functions.xWaitForElementPresent(driver, openAndUpcomingActivites, 4);
			if (openAndUpcomingActivites.isDisplayed()) {
				System.out.println(
						"There are no activities for present, past and future dates in acitivity related list");
				report.updateTestLog("Verify Accounts Activity Timeline",
						"There are no activities for present, past and future dates in acitivity related list:::",
						Status.PASS);
			}
		} catch (Exception e1) {
			List<WebElement> pastActivityList = driver
					.findElements(By.xpath("//div[@class='slds-media__body']//div[@class='slds-text-body--small']"));
			pastActivityListValues();
			String[] linkTexts = new String[pastActivityList.size()];
			for (WebElement element : pastActivityList) {
				linkTexts[i] = element.getText();
				if (linkTexts[i].contains(pastActivityListValues.get(i))) {
					count++;
					report.updateTestLog("Verify Acitivty Timeline",
							"Value " + element.getText() + "is present under Activity Timeline", Status.PASS);
					System.out.println(element.getText());
					if (count == 3)
						break;
				}
				i++;
			}
			pastActivityListValues.clear();
			System.out.println(count);
			if (count == 3) {
				report.updateTestLog("Verify Acitivty Timeline", "All the values are present under Acitivty Timeline",
						Status.PASS);
			} else {
				report.updateTestLog("Verify Acitivty Timeline",
						"All the values are not present under Acitivty Timeline", Status.FAIL);
			}
		}
	}

	/**
	 * Validating the creation of New Task
	 * 
	 * @author Haritha
	 */
	public void addTask() {
		Utility_Functions.xWaitForElementPresent(driver, applauncher, 3);
		Utility_Functions.xClick(driver, applauncher, true);
		Utility_Functions.xWaitForElementPresent(driver, addBtnTask1, 6);
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

	/**
	 * validating the Campaign's Activity task on Details page
	 * 
	 */
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
				 * // Move calendar to yesterday calendar.add(Calendar.DATE, -1);
				 * 
				 * // Get current date of calendar which point to the yesterday now Date newDate
				 * = calendar.getTime(); Utility_Functions.xWaitForElementPresent(driver,
				 * activityInputDate, 3); Utility_Functions.xSendKeys(driver, activityInputDate,
				 * dateFormat.format(newDate).toString());
				 * Utility_Functions.xWaitForElementPresent(driver, activitySave, 2);
				 * Utility_Functions.xClickVisibleListElement(driver, activitySave);
				 * report.updateTestLog("Verify Past Task",
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
				 * // Get current date of calendar which point to the yesterday now Date newDate
				 * = calendar.getTime(); Utility_Functions.xWaitForElementPresent(driver,
				 * activityInputDate, 3); //Utility_Functions.xSendKeys(driver,
				 * activityInputDate, dateFormat.format(newDate).toString());
				 * Utility_Functions.xWaitForElementPresent(driver, activitySave, 2);
				 * Utility_Functions.xClickVisibleListElement(driver, activitySave);
				 * report.updateTestLog("Verify Future Task",
				 * "The Future Task is created successfully", Status.PASS);
				 */
			}

		}

		Utility_Functions.xClickVisibleListElement(driver, activityTypeList);
		Utility_Functions.xClick(driver, activityType1, true);
		Utility_Functions.timeWait(3);

		Utility_Functions.xWaitForElementPresent(driver, activitySave, 2);
		Utility_Functions.xClickVisibleListElement(driver, activitySave);
		report.updateTestLog("Verify Task", "The Task is created successfully", Status.PASS);
	}
	
	/**
	 * Validating editing an Task on Comp's page
	 * 
	 * @author Haritha
	 */

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
	
	/**
	 * Validating the deletion of a task on Comp's page
	 * 
	 * @author Haritha
	 */

	public void deleteTask() {
		Utility_Functions.timeWait(3);
		Utility_Functions.xClickVisibleListElement(driver, deleteTask);
		Utility_Functions.xClick(driver, deleteTaskPopup, true);
		report.updateTestLog("Verify Delete Task", "The Task was deleted successfully", Status.PASS);
	}
	
	/**
	 * Validating Edit status of Task on Comp's page
	 * 
	 * @author Haritha
	 */
	public void editStatusTask() {
		Utility_Functions.timeWait(3);
		Utility_Functions.xClickVisibleListElement(driver, checkBoxTask);
		Utility_Functions.xWaitForElementPresent(driver, taskName, 5);
		Utility_Functions.xClick(driver, taskName, true);
		Utility_Functions.timeWait(3);
		report.updateTestLog("Verify Edit Task status", "The Task status is changed successfully", Status.PASS);
	}
	
	/**
	 * Validating the Task status on Comp's page
	 * 
	 * @author Haritha
	 */

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

		report.updateTestLog("Verify the Task", "The Task has been validated successfully", Status.PASS);
	}
	

}