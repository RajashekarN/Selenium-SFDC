package pageObjects;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.cognizant.Craft.ReusableLibrary;
import com.cognizant.Craft.ScriptHelper;
import com.cognizant.framework.Status;

import supportLibraries.Utility_Functions;



public class EventPage  extends ReusableLibrary {
	/*
	 * Constructor to initialize the business component library
	 * 
	 * @param scriptHelper The {@link ScriptHelper} object passed from the
	 * {@link DriverScript}
	 */
	
 	
	public EventPage(ScriptHelper scriptHelper) {
		super(scriptHelper);
		PageFactory.initElements(driver.getWebDriver(), this);
	}
	
	/**
	 * Validating the creation of an Activityevent on Comp's page
	 */
	@FindBy(xpath = "//span[text()='New Event']")
	WebElement newEvent;

 	@FindBy(xpath = "//label/span[text()='Subject']/parent::label/parent::div/input")
 	List<WebElement> eventSubject;
 
 	@FindBy(xpath = "//button[@title='Add']")
 	List<WebElement> addEventActivity;
 
 	@FindAll(value = {@FindBy(xpath = "//span[contains(text(),'Activity Type')]/parent::span/following-sibling::div/descendant::a[@class='select'][text()='--None--']") })
 	List<WebElement> eventActivityTypeList;
 
 	@FindAll(value = { @FindBy(xpath = "//div[@class='select-options']/ul/li/a[text()='Private - Initial Meeting']") })
 	List<WebElement> newActivityType;
 	
 	@FindAll(value = { @FindBy(xpath = "//div[contains(@class,'bottomBarRight')]//span[text()='Save']") })
	List<WebElement> activitySave;
 	
 	/*
	 * Validating the status of event on Comp's page
	 */

	@FindBy(xpath = "//div[contains(text(),'Start Time')]")
	WebElement startTimeEvent;

	@FindBy(xpath = "//div[contains(text(),'End Time')]")
	WebElement endTimeEvent;

	@FindBy(xpath = "//div[contains(text(),'Comments')]")
	WebElement commmentsEvent;
	
	/*
	 * Validating the Event Edit on Comp's page
	 */

	@FindBy(xpath = "//*[contains(@id,'g') and text()='Event']")
	WebElement eventName;

	@FindBy(xpath = "//*[@class='slds-truncate' and @title='Edit']")
	List<WebElement> editEvent;

	@FindBy(xpath = "//label[@class='label inputLabel uiLabel-left form-element__label uiLabel']/span[text()='Subject']//parent::label/following-sibling::input")
	List<WebElement> editEventName;

	@FindBy(xpath = "//button[contains(@class, 'Button-') and @title='Save']")
	WebElement saveBtnEvent;


	/**
	 * Validating the Create New Event Custom Page Layout.
	 * @author SChandran
	 */
	
	static List<String> customCreateNewEventPageLayoutFieldsList = new ArrayList<String>();
	static List<String> startEndDateTimeFieldsList = new ArrayList<String>();

	public void customCreateNewEventPageLayoutFieldsList() {
		customCreateNewEventPageLayoutFieldsList.add("Subject\n*");
		customCreateNewEventPageLayoutFieldsList.add("Activity Type\n*");
		customCreateNewEventPageLayoutFieldsList.add("Type");
		customCreateNewEventPageLayoutFieldsList.add("Location");
		customCreateNewEventPageLayoutFieldsList.add("Start\n*");
		customCreateNewEventPageLayoutFieldsList.add("End\n*");
		customCreateNewEventPageLayoutFieldsList.add("All-Day Event");
		customCreateNewEventPageLayoutFieldsList.add("Name");
		customCreateNewEventPageLayoutFieldsList.add("Assigned To\n*");
		customCreateNewEventPageLayoutFieldsList.add("Description");
		customCreateNewEventPageLayoutFieldsList.add("Related To");
		customCreateNewEventPageLayoutFieldsList.add("Send Notification Email");
		System.out.println("Create New Event Custom Page contains the fields :::" + customCreateNewEventPageLayoutFieldsList);
	}	
	
	public void startEndDateTimeFieldsList() {
		startEndDateTimeFieldsList.add("Date");
		startEndDateTimeFieldsList.add("Time");
		startEndDateTimeFieldsList.add("Date");
		startEndDateTimeFieldsList.add("Time");
		System.out.println("Create New Event Custom Page contains Date and Time fields for Start and End");
	}
	
	public void verifyNewEventPageLayout() {
		String[] eventPageLabels = {"Subject","Activity Type", "Type", "Location","Start","End","All-Day Event","Name","Assigned To","Description","Related To","Send Notification Email" };
		List<WebElement> eventPageLabelsLocator = driver.findElements(By.xpath("//div[@data-aura-class='forcePageBlockItem forcePageBlockItemEdit']//*[contains(@class,'form-element')]/span[1]"));
		int eventPageLabelsCount = Utility_Functions.xValidateFieldsPresentPage(Arrays.asList(eventPageLabels),
				eventPageLabelsLocator, "Opportunity - New Custom event page labels");
		if (eventPageLabelsCount <= eventPageLabels.length) {
			report.updateTestLog("Opportunity - new custom events page labels", "Opportunity - new custom events page labels are not displaying::",
					Status.FAIL);
		}  
		/*List<WebElement> createNewEventPageLayoutFieldsOnPage = driver.findElements(By.xpath("//label/span[text()='Subject']/following::input[1]//ancestor::section[1]//legend[contains(@class,'form-element__label uiLegend')]"
																						+ "|//label/span[text()='Subject']/following::input[1]//ancestor::section[1]//span[contains(@class,'label inputLabel')]/span"
																						+ "|//label/span[text()='Subject']/following::input[1]//ancestor::section[1]//label[contains(@class,'label inputLabel uiLabel-left')]"));
		List<String> createNewEventPageLayoutFieldsFound = new ArrayList<String>();
		for(int i=0; i<createNewEventPageLayoutFieldsOnPage.size(); i++)
		{
			createNewEventPageLayoutFieldsFound.add(createNewEventPageLayoutFieldsOnPage.get(i).getText());
			if(createNewEventPageLayoutFieldsFound.get(i).equals("*"))
				createNewEventPageLayoutFieldsFound.set(i-1, createNewEventPageLayoutFieldsFound.get(i-1)+"\n*");
		}
		customCreateNewEventPageLayoutFieldsList();
		List<String> fieldsCount = Utility_Functions.xValidatePickListValuesPage(customCreateNewEventPageLayoutFieldsList, createNewEventPageLayoutFieldsFound, "Create New Event Page Fields");
		
		List<WebElement> startEndDateTimeFieldsOnPage = driver.findElements(By.xpath("//label/span[text()='Subject']/following::input[1]//ancestor::section[1]//legend[contains(@class,'form-element__label uiLegend')]/following-sibling::div//label"));
		List<String> startEndDateTimeFieldsFound = new ArrayList<String>();
		for(WebElement element : startEndDateTimeFieldsOnPage)
		{
			startEndDateTimeFieldsFound.add(element.getText());
		}
		startEndDateTimeFieldsList();
		List<String> dateTimeFieldsCount = Utility_Functions.xValidatePickListValuesPage(startEndDateTimeFieldsList, startEndDateTimeFieldsFound, "Create New Event Page Fields");
		
		if (fieldsCount.size() == 0 && dateTimeFieldsCount.size() == 0) {
			report.updateTestLog("Create New Event Page Fields", "Create New Event Page has all the expected fields", Status.PASS);
		}
		else {
			report.updateTestLog("Create New Event Page Fields", "Create New Event Page does not have all the expected fields", Status.FAIL);
		}*/
	}
	
	/**
	 * Validating the comp's ActivityEvent on Details page
	 * 
	 * @author Haritha
	 */
	
	public void activityEvent() {
		for (int i = 1; i <= 3; i++) {
			if (i == 1) {

				// Utility_Functions.xWaitForElementPresent(driver, newEvent,
				// 3);
				Utility_Functions.timeWait(3);
				Utility_Functions.xClick(driver, newEvent, true);
				//Utility_Functions.xClickVisibleListElement(driver, newEvent);
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
			Utility_Functions.xClickVisibleListElement(driver,eventActivityTypeList);
			Utility_Functions.xWaitForElementPresent(driver,newActivityType,3);
			Utility_Functions.xClickVisibleListElement(driver,newActivityType);
			Utility_Functions.xWaitForElementPresent(driver,activitySave,3);
			Utility_Functions.xClickVisibleListElement(driver,activitySave);
			report.updateTestLog("Verify Event","The Event is created successfully",Status.PASS);
		

		}
}
		/**
		 * Validating the creation of Event on Comp's page
		 * 
		 * @author Haritha
		 */
		
		public void addEvent() {
			Utility_Functions.timeWait(5);
			Utility_Functions.xClick(driver, newEvent, true);
	
			Utility_Functions.xSendKeysVisibleListElement(driver, eventSubject, "Event");
			Utility_Functions.xClickVisibleListElement(driver, eventActivityTypeList);
			Utility_Functions.xWaitForElementPresent(driver, newActivityType, 3);
			Utility_Functions.xClickVisibleListElement(driver, newActivityType);
			Utility_Functions.xWaitForElementPresent(driver, activitySave, 3);
			Utility_Functions.xClickVisibleListElement(driver, activitySave);
			report.updateTestLog("Verify Event", "The Event is created successfully", Status.PASS);

		}
		
		/**
		 * Validating the Event status on Comp's page
		 * 
		 * @author Haritha
		 */

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

		/**
		 * Validating Editing an Event on Comp's page
		 * 
		 * @author Haritha
		 */

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
}
		
