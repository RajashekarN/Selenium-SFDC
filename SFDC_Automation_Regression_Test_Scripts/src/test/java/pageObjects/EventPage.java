package pageObjects;

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



 	
 	

	
	public void verifyNewEventPageLayout() {
		List<WebElement> newEventPageLayoutFields = driver.findElements(By.xpath("//div[@class='riseTransitionEnabled']//label/span"));
		int countRequiredFiles = 0;
		try {
			for (WebElement element : newEventPageLayoutFields) {
				if ((element.getText().equals("Subject"))) {
					System.out.println("Subject required field is present in the New Event Layout Page");
					report.updateTestLog("Verify New Event Page Layout", "New Event Layout Page is having the " + element.getText() + " Status field::",
							Status.PASS);
					countRequiredFiles++;
				} else if ((element.getText().equals("Location"))) {
					System.out.println("Location required field is present in the New Event Layout Page");
					report.updateTestLog("Verify New Event Page Layout", "New Event Layout Page is having the " + element.getText() + " Status field::",
							Status.PASS);
					countRequiredFiles++;
				} else if ((element.getText().equals("All-Day Event"))) {
					System.out.println("All-Day Event required field is present in the New Event Layout Page");
					report.updateTestLog("Verify New Event Page Layout", "New Event Layout Page is having the " + element.getText() + " Status field::",
							Status.PASS);
					countRequiredFiles++;
				} else if ((element.getText().equals("Name"))) {
					System.out.println("Name To required field is present in the New Event Layout Page");
					report.updateTestLog("Verify New Event Page Layout", "New Event Layout Page is having the " + element.getText() + " Status field::",
							Status.PASS);
					countRequiredFiles++;
				} else if ((element.getText().equals("Related To"))) {
					System.out.println("Related To required field is present in the New Event Layout Page");
					report.updateTestLog("Verify New Event Page Layout", "New Event Layout Page is having the " + element.getText() + " Status field::",
							Status.PASS);
					countRequiredFiles++;
				} else if ((element.getText().equals("Description"))) {
					System.out.println("Description required field is present in the New Event Layout Page");
					report.updateTestLog("Verify New Event Page Layout", "New Event Layout Page is having the " + element.getText() + " Status field::",
							Status.PASS);
					countRequiredFiles++;
				} else if ((element.getText().equals("Assigned To"))) {
					System.out.println("Assigned To required field is present in the New Event Layout Page");
					report.updateTestLog("Verify New Event Page Layout", "New Event Layout Page is having the " + element.getText() + " Status field::",
							Status.PASS);
					countRequiredFiles++;
				}
			}
			List<WebElement> newEventPageLayoutRequiredFields = driver.findElements(By.xpath("//div[contains(@class,'forceInputPicklist')]/span[contains(@class,'uiPicklistLabel')]/span"));
			for (WebElement element : newEventPageLayoutRequiredFields) {
				if ((element.getText().equals("Activity Type"))) {
					System.out.println("Activity Type required field is present in the New Event Layout Page");
					report.updateTestLog("Verify New Event Page Layout", "New Event Layout Page is having the " + element.getText() + " Status field::",
							Status.PASS);
					countRequiredFiles++;
				} else if ((element.getText().equals("Priority"))) {
					System.out.println("Priority required field is present in the New Event Layout Page");
					report.updateTestLog("Verify New Event Page Layout", "New Event Layout Page is having the " + element.getText() + " Status field::",
							Status.PASS);
					countRequiredFiles++;
				}
			}		
			
			List<WebElement> newEventStartEndFields = driver.findElements(By.xpath("//div[@class='uiInput uiInput--default']//span"));
			for (WebElement element : newEventStartEndFields) {
				if ((element.getText().equals("Start"))) {
					System.out.println("Start Type required field is present in the New Event Layout Page");
					report.updateTestLog("Verify New Event Page Layout", "New Event Layout Page is having the " + element.getText() + " Status field::",
							Status.PASS);
					countRequiredFiles++;
				} else if ((element.getText().equals("End"))) {
					System.out.println("End required field is present in the New Event Layout Page");
					report.updateTestLog("Verify New Event Page Layout", "New Event Layout Page is having the " + element.getText() + " Status field::",
							Status.PASS);
					countRequiredFiles++;
				}
			}
			
			List<WebElement> newEventDateTimeFields = driver.findElements(By.xpath("//div[@class='uiInput uiInput--default']//label"));
			for (WebElement element : newEventDateTimeFields) {
				if ((element.getText().equals("Date"))) {
					System.out.println("Date required field is present in the New Event Layout Page");
					report.updateTestLog("Verify New Event Page Layout", "New Event Layout Page is having the " + element.getText() + " Status field::",
							Status.PASS);
					countRequiredFiles++;
				} else if ((element.getText().equals("Time"))) {
					System.out.println("Time required field is present in the New Event Layout Page");
					report.updateTestLog("Verify New Event Page Layout", "New Event Layout Page is having the " + element.getText() + " Status field::",
							Status.PASS);
					countRequiredFiles++;
				}
			}
			System.out.println("Total no of fields on Event Page::" + countRequiredFiles);
			if (countRequiredFiles >= 16) {
				System.out.println("New Event Page Layout contains the required fields ");
				report.updateTestLog("Verify New Event Page Layout", "New Event Layout Page is having all the required fields", Status.PASS);
			} else {
				report.updateTestLog("Verify New Event Page Layout", "New Event Layout Page is not having all the required fields", Status.WARNING);
			}			
			
		} catch (Exception e) {
			System.out.println("Encountered an error in validating the New Event Page Layout Fields::"+e.getMessage());
		}
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
		
