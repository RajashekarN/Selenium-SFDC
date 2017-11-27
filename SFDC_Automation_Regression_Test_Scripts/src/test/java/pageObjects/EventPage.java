package pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import com.cognizant.Craft.ReusableLibrary;
import com.cognizant.Craft.ScriptHelper;
import com.cognizant.framework.Status;

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
}
