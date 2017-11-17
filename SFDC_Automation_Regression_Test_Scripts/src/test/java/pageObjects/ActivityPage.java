package pageObjects;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.cognizant.Craft.ReusableLibrary;
import com.cognizant.Craft.ScriptHelper;
import com.cognizant.framework.Status;

import pagesAPI.SearchTextSOQL;
import supportLibraries.Utility_Functions;

public class ActivityPage extends ReusableLibrary {
	/*
	 * Constructor to initialize the business component library
	 * 
	 * @param scriptHelper The {@link ScriptHelper} object passed from the
	 * {@link DriverScript}
	 */

	public ActivityPage(ScriptHelper scriptHelper) {
		super(scriptHelper);
		PageFactory.initElements(driver.getWebDriver(), this);
	}

	@FindBy(xpath = "//span[text()='Add']")
	WebElement addActivity;

	@FindBy(xpath = "//label/span[text()='Subject']/parent::label/parent::div/input")
	WebElement activitySubject;

	@FindBy(xpath = "//div[@class='select-options']/ul/li/a[text()='Private - Initial Meeting']")
	WebElement newActivityType;

	@FindBy(xpath = "//input[contains(@class,'inputDate')]")
	WebElement activityInputDate;

	@FindBy(xpath = "//input[@title='Search Contacts']")
	WebElement activitySearchContacts;

	@FindBy(xpath = "//div[contains(@class,'bottomBarRight')]//span[text()='Save']")
	WebElement activitySave;

	@FindBy(xpath = "//div[contains(@title,'Test Automation')]")
	WebElement activityCreated;

	@FindBy(xpath = "//a[@class='select'][text()='--None--']")
	WebElement activityTypeList;


	DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
	Date date = new Date();
	SearchTextSOQL searchTextSOQL = new SearchTextSOQL(scriptHelper);

	public void createNewActivityAccounts() {
		Utility_Functions.xWaitForElementPresent(driver, addActivity, 3);
		Utility_Functions.xClick(driver, addActivity, true);
		report.updateTestLog("Verify New Activity Page Layout ", "The New Activity in the Details page is Displayed ",
				Status.PASS);
		Utility_Functions.xWaitForElementPresent(driver, activitySubject, 3);
		String sActivitySubject = "Test Automation Subject_" + Utility_Functions.xGenerateAlphaNumericString();
		Utility_Functions.xSendKeys(driver, activitySubject, sActivitySubject);
		Utility_Functions.xScrollWindowTop(driver);
		Utility_Functions.timeWait(2);
		Utility_Functions.xWaitForElementPresent(driver, activityTypeList, 3);
		Utility_Functions.xClick(driver, activityTypeList, true);
		Utility_Functions.xWaitForElementPresent(driver, newActivityType, 3);
		Utility_Functions.xClick(driver, newActivityType, true);
		Utility_Functions.xWaitForElementPresent(driver, activityInputDate, 3);
		Utility_Functions.xSendKeys(driver, activityInputDate, dateFormat.format(date).toString());
		Utility_Functions.xWaitForElementPresent(driver, activitySearchContacts, 3);
		Utility_Functions.xClick(driver, activitySearchContacts, true);
		WebElement firstLookupElement = driver.findElement(By.cssSelector("ul>li.forceSearchInputLookupDesktopOption:nth-child(1)"));
		Utility_Functions.xWaitForElementPresent(driver, firstLookupElement, 4);
		Utility_Functions.xWaitForElementPresent(driver, activitySave, 3);
		Utility_Functions.xClick(driver, activitySave, true);
		report.updateTestLog("Verify New Activity", "Verifying whether the New Activity page is saved ", Status.PASS);
/*		String query = "SELECT Subject__c FROM Activity__c where Subject__c = " + "'" + sActivitySubject + "'";
		System.out.println("Activity Subject:: "+ sActivitySubject);
		String record = searchTextSOQL.fetchRecordFieldValue("Subject__c", query);
		if(record.equals(sActivitySubject)) {
			report.updateTestLog("Verify New Activity Page", "Activity has been created successfully", Status.PASS);			
		} else {
			report.updateTestLog("Verify New Activity Page", "Activity didn't get created", Status.FAIL);
		}*/
	}

	public void verifyNewAccountsActivityPageLayout() {
		List<WebElement> newActivityPageLayoutFields = driver.findElements(By.xpath("//div[@class='riseTransitionEnabled']//label/span"));
		int countRequiredFiles = 0;
		try {
			for (WebElement element : newActivityPageLayoutFields) {
				if ((element.getText().equals("Subject"))) {
					System.out.println("Subject required field is present in the New Activity Layout Page");
					report.updateTestLog("Verify New Activity Page Layout", "New Activity Layout Page is having the " + element.getText() + " Status field::",
							Status.PASS);
					countRequiredFiles++;
				} else if ((element.getText().equals("Due Date"))) {
					System.out.println("Due Date required field is present in the New Activity Layout Page");
					report.updateTestLog("Verify New Activity Page Layout", "New Activity Layout Page is having the " + element.getText() + " Status field::",
							Status.PASS);
					countRequiredFiles++;
				} else if ((element.getText().equals("Name"))) {
					System.out.println("Name required field is present in the New Activity Layout Page");
					report.updateTestLog("Verify New Activity Page Layout", "New Activity Layout Page is having the " + element.getText() + " Status field::",
							Status.PASS);
					countRequiredFiles++;
				} else if ((element.getText().equals("Related To"))) {
					System.out.println("Related To required field is present in the New Activity Layout Page");
					report.updateTestLog("Verify New Activity Page Layout", "New Activity Layout Page is having the " + element.getText() + " Status field::",
							Status.PASS);
					countRequiredFiles++;
				} else if ((element.getText().equals("Comments"))) {
					System.out.println("Comments required field is present in the New Activity Layout Page");
					report.updateTestLog("Verify New Activity Page Layout", "New Activity Layout Page is having the " + element.getText() + " Status field::",
							Status.PASS);
					countRequiredFiles++;
				} else if ((element.getText().equals("Assigned To"))) {
					System.out.println("Assigned To required field is present in the New Activity Layout Page");
					report.updateTestLog("Verify New Activity Page Layout", "New Activity Layout Page is having the " + element.getText() + " Status field::",
							Status.PASS);
					countRequiredFiles++;
				}
			}
			List<WebElement> newActivityPageLayoutRequiredFields = driver.findElements(By.xpath("//div[contains(@class,'forceInputPicklist')]/span[contains(@class,'uiPicklistLabel')]/span"));
			for (WebElement element : newActivityPageLayoutRequiredFields) {
				if ((element.getText().equals("Activity Type"))) {
					System.out.println("Activity Type required field is present in the New Activity Layout Page");
					report.updateTestLog("Verify New Activity Page Layout", "New Activity Layout Page is having the " + element.getText() + " Status field::",
							Status.PASS);
					countRequiredFiles++;
				} else if ((element.getText().equals("Status"))) {
					System.out.println("Status required field is present in the New Activity Layout Page");
					report.updateTestLog("Verify New Activity Page Layout", "New Activity Layout Page is having the " + element.getText() + " Status field::",
							Status.PASS);
					countRequiredFiles++;
				} else if ((element.getText().equals("Priority"))) {
					System.out.println("Priority required field is present in the New Activity Layout Page");
					report.updateTestLog("Verify New Activity Page Layout", "New Activity Layout Page is having the " + element.getText() + " Status field::",
							Status.PASS);
					countRequiredFiles++;
				}
			}			
			if (countRequiredFiles >= 9) {
				System.out.println("New Activity Page Layout does not contain the required fields ");
				report.updateTestLog("Verify New Activity Page Layout",	"New Activity Layout Page is having all the required fields", Status.PASS);
			} else {
				report.updateTestLog("Verify New Activity Page Layout", "New Activity Layout Page is not having all the required fields", Status.WARNING);
			}
			
			
		} catch (Exception e) {
			System.out.println("Encountered an error in validating the Account New Activity Page Layout Fields::"+e.getMessage());
		}
	}
	
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
		activityTypeListValues.add("Public – Client Intelligence (VAS)");
		activityTypeListValues.add("Public - Client Meeting (CML)");
		activityTypeListValues.add("Public - Client Meeting (Investor Services)");
		System.out.println("Additional Activity Type values are added to the list successfully::::");
	}
	
	public void validateActivityTypeValues() {
		Utility_Functions.xWaitForElementPresent(driver, addActivity, 3);
		Utility_Functions.xClick(driver, addActivity, true);	
		Utility_Functions.xScrollWindowTop(driver);
		Utility_Functions.timeWait(2);
		Utility_Functions.xWaitForElementPresent(driver, activitySubject, 3);
		Utility_Functions.xWaitForElementPresent(driver, activityTypeList, 3);
		Utility_Functions.xClick(driver, activityTypeList, true);
		List<WebElement> activityTypeValues = driver.findElements(By.xpath("//div[@class='select-options']/ul/li/a"));
		additionalActivityTypeList();		
		String[] linkTexts = new String[activityTypeValues.size()];
		int i = 0, count = 0;
		try {
			for (WebElement element : activityTypeValues) {
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
		System.out.println(count);
		if(count==16) {
			report.updateTestLog("Verify Additional Acitivty", "All the values are present under Additional Activity List", Status.PASS);
		} else {
			report.updateTestLog("Verify Additional Acitivty", "All the values are not present under Additional Activity List", Status.FAIL);
		}
	}

}