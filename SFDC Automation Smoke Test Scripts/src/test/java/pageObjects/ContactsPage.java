package pageObjects;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.cognizant.Craft.ReusableLibrary;
import com.cognizant.Craft.ScriptHelper;
import com.cognizant.framework.Status;

import pagesAPI.ContactsFunctions;
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

	@FindBy(xpath = "//div[@class='slds-context-bar oneGlobalNav']//span[text()='Contacts']")
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

	@FindBy(xpath = "//div[@class='slds-page-header slds-grid slds-grid--align-spread slds-grid--vertical-align-center']//button[text()='Continue']")
	WebElement continueButton;

	@FindBy(xpath = "//*[@id='acctSearchBox']")
	WebElement accountSearch;

	@FindBy(xpath = "//div[@class='tt-dataset-acctSearchBoxTypeahead']//div[1]/p")
	WebElement accountNames;

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
		driver.switchTo().frame(driver.findElement(By.xpath("//iframe[contains(@src,'ContactRedirectPage')]")));
		Utility_Functions.timeWait(1);
		if(!dataTable.getData("General_Data", "Username").contains("ob")) {
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
						Status.FAIL);
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

}
