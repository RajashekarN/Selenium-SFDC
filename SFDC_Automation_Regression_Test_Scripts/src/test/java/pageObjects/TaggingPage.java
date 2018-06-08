package pageObjects;

import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.cognizant.Craft.ReusableLibrary;
import com.cognizant.Craft.ScriptHelper;
import com.cognizant.framework.Status;

import pagesAPI.SearchTextSOQL;
import supportLibraries.SF_UtilityFunctions;
import supportLibraries.Utility_Functions;

/*
* Page Object Class for Tagging Page
* 
* @author Haritha
*
*/

public class TaggingPage extends ReusableLibrary {
	/*
	 * Constructor to initialize the business component library
	 * 
	 * @param scriptHelper The {@link ScriptHelper} object passed from the {@link
	 * DriverScript}
	 */

	public TaggingPage(ScriptHelper scriptHelper) {
		super(scriptHelper);
		PageFactory.initElements(driver.getWebDriver(), this);
	}

	/**
	 * 
	 * Object Initiation
	 */

	TasksPage tasksPage = new TasksPage(scriptHelper);
	EventPage eventPage = new EventPage(scriptHelper);

	/**
	 * Validating the Properties Preferences creation
	 *
	 */
	@FindBy(xpath = "//a[contains(@id,'tag_edit_link')]")
	WebElement addTag;

	@FindBy(xpath = "//textarea[@id='ptag_edit_area']")
	WebElement privatetag;

	@FindBy(xpath = "//input[@id='tag_save_btn']")
	WebElement savePrivateTag;

	@FindBy(xpath = "//*[contains(@title,'View records tagged')]")
	WebElement PrivateTagged;

	/**
	 * Validating the creation of the Marketing list
	 * 
	 */
	@FindBy(xpath = "//one-app-launcher-header/button")
	WebElement applauncher;

	@FindBy(xpath = "//li/a[@title='Marketing Lists']")
	WebElement marketingLists;

	@FindBy(xpath = "//div[@class='slds-truncate'][@title='New']")
	WebElement newProperty;

	@FindBy(xpath = "//*[@class=' input' and @maxlength]")
	WebElement marketingListName;

	@FindBy(xpath = "//*[@placeholder='Search Contacts...']")
	WebElement authorContact;

	@FindBy(xpath = "//*[@class=' textarea']")
	WebElement notesTxtBx;

	@FindBy(xpath = "//*[@title='Save']")
	WebElement saveMarketList;

	/**
	 * Validating the Subscription page fields
	 */
	@FindBy(xpath = "//*[@title='Subscriptions']")
	WebElement subscriptions;

	@FindBy(xpath = "//input[@title='Search Marketing Lists']")
	WebElement marketListSubscription;

	/**
	 * Validating the creation of Campaigns
	 */

	@FindBy(xpath = "//*[contains(@class ,'label') and text()='Campaigns']")
	WebElement campaign;

	@FindBy(xpath = "//div[@class='slds-truncate'][@title='New']")
	WebElement newCampaigns;

	@FindBy(xpath = "//input[@class=' input' and @maxlength = '80']")
	List<WebElement> campaignsName;

	@FindBy(xpath = "//button[contains(@class, 'Button-') and @title='Save']")
	WebElement saveCampaigns;

	/**
	 * Validating the creation of Comps
	 */

	@FindBy(xpath = "//*[contains(@class ,'label') and text()='Comps']")
	WebElement comps;

	@FindBy(xpath = "//div[@class='slds-truncate'][@title='New']")
	WebElement newComps;

	@FindBy(xpath = "//button[contains(@class,'neutral uiButton--default uiButton--br')]")
	WebElement nextBtnComps;

	@FindBy(xpath = "//input[@class=' input' and @maxlength = '80']")
	List<WebElement> compsName;

	@FindBy(xpath = "//button[contains(@class, 'Button-') and @title='Save']")
	WebElement saveComps;

	
	/*
	 * Validating the file attachment on Comp's Task page
	 */

	@FindBy(xpath = "//a[@title='Add Attachment']")
	WebElement addAttachment;

	@FindBy(xpath = "//input[@class= 'slds-input']")
	WebElement attachFile;

	/*
	 * Validating the Space creation
	 */

	@FindBy(xpath = "//a[@class='tabHeader']//span[text()='Related']")
	List<WebElement> relatedlnk;

	@FindBy(xpath = "//span[@title='Spaces']")
	WebElement space;

	@FindBy(xpath = "//div[@class='slds-truncate'][@title='New']")
	List<WebElement> newSpace;

	@FindBy(xpath = "//input[@class=' input' and @maxlength='80']")
	WebElement spaceName;

	@FindBy(xpath = "//button[contains(@class, 'Button-') and @title='Save']")
	WebElement saveSpace;

	@FindBy(xpath = "//a[@title='test']")
	WebElement spaceNameSelect;

	/*
	 * Validating the creation of the private tag
	 */

	@FindBy(xpath = "//*[text()='More']")
	WebElement menu_More;

	@FindBy(xpath = "//a[@role='menuitem']/span[contains(@class,'slds-truncate')][text()='Private Tags']")
	WebElement more_PrivateTags;

	@FindBy(xpath = "//div[@class='slds-truncate'][text()='New']")
	WebElement newPrivateTag;

	@FindBy(xpath = "//label[@class='label inputLabel uiLabel-left form-element__label uiLabel']/span[contains(text(),'Private Tag Name')]/parent::label/parent::div/input")
	WebElement privateTagName;

	@FindBy(xpath = "//button[@title='Save']")
	WebElement saveNewPrivateTag;

	@FindBy(xpath = "//span[contains(text(),'Properties')]/ancestor::article//div[text()='New']")
	WebElement newPropertiesDetailsPage;

	@FindBy(xpath = "//input[contains(@placeholder,'Search Properties')]")
	WebElement searchPropertyWithPrivateTag;

	@FindBy(xpath = "//div[contains(@class,'modal-footer') and contains(@class,'slds-modal__footer')]//button/span[text()='Save']")
	WebElement savePropertyPrivateTag;

	/*
	 * Validating the Account search functionality in Bulk Tagging
	 */

	@FindBy(xpath = "//a[@role='menuitem']/span[contains(@class,'slds-truncate')][text()='Bulk Tagging']")
	WebElement bulkTagging;

	@FindBy(xpath = "//input[contains(@id,'SearchBlock:propertyEditForm:SearchBox')][contains(@placeholder,'Search Account/Contact')]")
	WebElement accountSearch;

	@FindBy(xpath = "//input[@value='Search']")
	WebElement searchProperty;

	
	SF_UtilityFunctions sf_UtilityFunctions = new SF_UtilityFunctions(scriptHelper);

	/**
	 * Validating the Properties Preferences creation
	 *
	 * @author Vishnuvardhan
	 *
	 */

	public void propertyTagging() {
		sf_UtilityFunctions.oneAppNavigationTab("Properties");
		sf_UtilityFunctions.selectAction("New");
		sf_UtilityFunctions.selectExistingObjectRecord("Property Name");
		/*
		 * Utility_Functions.xClick(driver, menu_More, true);
		 * Utility_Functions.xWaitForElementPresent(driver, properties, 3);
		 * Utility_Functions.xClick(driver, properties, true);
		 * Utility_Functions.xWaitForElementPresent(driver, recentlyViewed, 3);
		 * Utility_Functions.xClick(driver, recentlyViewed, true);
		 * Utility_Functions.xWaitForElementPresent(driver, allProperties, 3);
		 * Utility_Functions.xClick(driver, allProperties, true);
		 * Utility_Functions.timeWait(8); Utility_Functions.xClick(driver, PropertyList,
		 * true); Utility_Functions.timeWait(4);
		 */
		Utility_Functions.xSwitchtoFrame(driver, addTag);
		Utility_Functions.xClick(driver, addTag, true);
		Utility_Functions.xSendKeys(driver, privatetag, dataTable.getData("General_Data", "Private Tag"));
		Utility_Functions.xClickHiddenElement(driver, savePrivateTag);
		Utility_Functions.xWaitForElementPresent(driver, addTag, 3);

		if (addTag.isDisplayed()) {
			report.updateTestLog("Verify Property Private Tags", "The Private Tag is saved", Status.PASS);
		} else {
			report.updateTestLog("Verify Property Private Tags", "The Private tag is not saved", Status.FAIL);
		}

		Utility_Functions.xClick(driver, PrivateTagged, true);
		report.updateTestLog("Verify Property Private Tags", "The Private tag is saved in Private Tag Page",
				Status.FAIL);
	}

	/**
	 * Validating the creation of the Marketing list
	 * 
	 * @author Haritha
	 */
	public void marketCreation() {
		Utility_Functions.xWaitForElementPresent(driver, applauncher, 3);
		Utility_Functions.xClick(driver, applauncher, true);
		Utility_Functions.timeWait(2);
		Utility_Functions.xClickHiddenElement(driver, marketingLists);
		Utility_Functions.xWaitForElementPresent(driver, newProperty, 3);
		Utility_Functions.xClick(driver, newProperty, true);
		Utility_Functions.xWaitForElementPresent(driver, marketingListName, 3);
		Utility_Functions.xSendKeys(driver, marketingListName, "Test");
		Utility_Functions.xSendKeys(driver, authorContact, "Test Broker6");
		Utility_Functions.timeWait(1);
		authorContact.sendKeys(Keys.ARROW_DOWN);
		authorContact.sendKeys(Keys.ENTER);
		Utility_Functions.xWaitForElementPresent(driver, notesTxtBx, 3);
		Utility_Functions.xSendKeys(driver, notesTxtBx, "Testing");
		Utility_Functions.xClick(driver, saveMarketList, true);
		Utility_Functions.xWaitForElementPresent(driver, newProperty, 3);
		report.updateTestLog("Verify Marketing List Tags", "The Marketing tag is saved in Marketing Tag Page",
				Status.PASS);
	}

	/**
	 * Validating the creation of Subscription page fields
	 * 
	 * @author Haritha
	 */
	public void subscriptionCreation() {
		Utility_Functions.xWaitForElementPresent(driver, applauncher, 3);
		Utility_Functions.xClick(driver, applauncher, true);
		Utility_Functions.timeWait(2);
		Utility_Functions.xClickHiddenElement(driver, subscriptions);
		Utility_Functions.xWaitForElementPresent(driver, newProperty, 3);
		Utility_Functions.xClick(driver, newProperty, true);
		Utility_Functions.xWaitForElementPresent(driver, saveMarketList, 3);
		Utility_Functions.xSendKeys(driver, marketListSubscription, "Test");
		marketListSubscription.sendKeys(Keys.ARROW_DOWN);
		marketListSubscription.sendKeys(Keys.ENTER);
		Utility_Functions.xClick(driver, saveMarketList, true);

		if (newProperty.isDisplayed()) {
			System.out.println("Subscription is created");
			report.updateTestLog("Verify Subscription Tags", "The Subscription tag is saved in Subscription Tag Page",
					Status.PASS);
		} else {
			System.out.println("Subscription is not created");
			report.updateTestLog("Verify Subscription Tags",
					"The Subscription tag is not saved in Subscription Tag Page", Status.FAIL);
		}
	}

	/**
	 * Validating the creation of Campaigns
	 * 
	 * @author Haritha
	 */

	public void addCampaign() {

		Utility_Functions.xWaitForElementPresent(driver, applauncher, 3);
		Utility_Functions.xClick(driver, applauncher, true);
		Utility_Functions.xWaitForElementPresent(driver, campaign, 3);
		Utility_Functions.xClick(driver, campaign, true);
		Utility_Functions.xWaitForElementPresent(driver, newCampaigns, 2);
		Utility_Functions.xClick(driver, newCampaigns, true);
		Utility_Functions.xWaitForElementPresent(driver, campaignsName, 2);
		Utility_Functions.xSendKeysVisibleListElement(driver, campaignsName, "TestCampaigns");
		Utility_Functions.xWaitForElementPresent(driver, saveCampaigns, 3);
		Utility_Functions.xClick(driver, saveCampaigns, true);
		report.updateTestLog("Verify Campaigns", "The Campaigns is created successfully", Status.PASS);
		tasksPage.activityTask();

	}

	/**
	 * Validating the creation of the Comps page
	 * 
	 * @author Haritha
	 */

	public void addComp() {

		Utility_Functions.xWaitForElementPresent(driver, applauncher, 3);
		Utility_Functions.xClick(driver, applauncher, true);
		Utility_Functions.xWaitForElementPresent(driver, comps, 3);
		Utility_Functions.xClick(driver, comps, true);
		Utility_Functions.xWaitForElementPresent(driver, newComps, 2);
		Utility_Functions.xClick(driver, newComps, true);
		Utility_Functions.xWaitForElementPresent(driver, nextBtnComps, 2);
		Utility_Functions.xClick(driver, nextBtnComps, true);
		Utility_Functions.xWaitForElementPresent(driver, compsName, 2);
		Utility_Functions.xSendKeysVisibleListElement(driver, compsName, "Test");
		Utility_Functions.xWaitForElementPresent(driver, saveComps, 3);
		Utility_Functions.xClick(driver, saveComps, true);
		report.updateTestLog("Verify Comps", "The Comps is created successfully", Status.PASS);
		eventPage.activityEvent();
	}


	

	

	/**
	 * Validating adding an attachment on Comp's page
	 * 
	 * @author Haritha
	 */

	public void addAttachment() {

		Utility_Functions.timeWait(5);
		Utility_Functions.xClick(driver, addAttachment, true);
		Utility_Functions.timeWait(5);
		Utility_Functions.xSwitchtoFrame(driver, attachFile);
		// attachFile.sendKeys(Keys.ENTER);
		Utility_Functions.xClickHiddenElement(driver, attachFile);
		Utility_Functions.timeWait(3);
		// Utility_Functions.xClick(driver, attachFile, true);
		// Specify the file location with extension
		StringSelection sel = new StringSelection(
				"\\us.cbre.net\\dardata\\Team-Cognizant\\CBRE_QA\\Mukesh Garg\\Demo.docx");

		// Copy to clipboard
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(sel, null);
		System.out.println("selection" + sel);
		try {
			Robot robot = new Robot();

			robot.keyPress(KeyEvent.VK_CONTROL);
			robot.keyPress(KeyEvent.VK_V);
			robot.keyRelease(KeyEvent.VK_CONTROL);
			robot.keyRelease(KeyEvent.VK_V);
			robot.keyPress(KeyEvent.VK_ENTER);
			robot.keyRelease(KeyEvent.VK_ENTER);

		} catch (Exception e) {
			System.out.println("The file is not uploaded" + e.getMessage());

		}
		report.updateTestLog("Verify Adding Attachment", "The file is attached successfully ", Status.PASS);
	}

	
	/**
	 * Validating the Space creation
	 * 
	 * @author Haritha
	 */
	public void createSpace() {

		Utility_Functions.timeWait(5);
		Utility_Functions.xClickVisibleListElement(driver, relatedlnk);
		Utility_Functions.xWaitForElementPresent(driver, space, 5);
		Utility_Functions.xClick(driver, space, true);
		Utility_Functions.timeWait(3);
		Utility_Functions.xClickVisibleListElement(driver, newSpace);
		Utility_Functions.xWaitForElementPresent(driver, spaceName, 3);
		Utility_Functions.xSendKeys(driver, spaceName, "test");
		Utility_Functions.xClick(driver, saveSpace, true);
		Utility_Functions.timeWait(5);
		Utility_Functions.xClick(driver, spaceNameSelect, true);
		report.updateTestLog("verify Create Space", "Verifying New Space is created and new space is saved",
				Status.PASS);

	}

	/**
	 * Validating the Properties Private tags
	 * 
	 * @author Haritha
	 */

	public void verifyPropertiesPrivateTags() {
		sf_UtilityFunctions.oneAppNavigationTab("Private Tags");

		/*
		 * Utility_Functions.xWaitForElementPresent(driver, menu_More, 3);
		 * Utility_Functions.xClick(driver, menu_More, true);
		 * report.updateTestLog("Verify Properties Private Tag",
		 * "Verifying More options is displayed", Status.PASS);
		 * Utility_Functions.timeWait(2);
		 * Utility_Functions.xWaitForElementPresent(driver, more_PrivateTags, 3);
		 * Utility_Functions.xClick(driver, more_PrivateTags, true);
		 * report.updateTestLog("Verify Properties Private Tag",
		 * "Verifying Private Tags is displayed", Status.PASS);
		 * Utility_Functions.timeWait(2);
		 * Utility_Functions.xWaitForElementPresent(driver, newPrivateTag, 3);
		 * Utility_Functions.xClick(driver, newPrivateTag, true);
		 */
		sf_UtilityFunctions.selectAction("New");
		report.updateTestLog("Verify Properties Private Tag", "Verifying the New Private Tags is displayed",
				Status.PASS);
		/*
		 * Utility_Functions.timeWait(5);
		 * Utility_Functions.xWaitForElementPresent(driver, privateTagName, 3);
		 * Utility_Functions.xClick(driver, privateTagName, true);
		 * report.updateTestLog("Verify Properties Private Tag",
		 * "Verifying the New Private Tag name is displayed", Status.PASS);
		 * Utility_Functions.xWaitForElementPresent(driver, privateTagName, 3);
		 * Utility_Functions.xSendKeys(driver, privateTagName, "Test_" +
		 * Utility_Functions.xGenerateAlphaNumericString());
		 */

		sf_UtilityFunctions.selectExistingObjectRecord("Private tag");
		report.updateTestLog("Verify Properties Private Tag", "Verifying the Private Tag name is entered", Status.PASS);
		Utility_Functions.xWaitForElementPresent(driver, saveNewPrivateTag, 3);
		Utility_Functions.xClick(driver, saveNewPrivateTag, true);
		report.updateTestLog("Verify Properties Private Tag", "Verifying the Private Tag name is entered and saved",
				Status.PASS);
		Utility_Functions.timeWait(5);
		Utility_Functions.xScrollWindow(driver);
		Utility_Functions.timeWait(1);
		Utility_Functions.xScrollWindowTop(driver);
		Utility_Functions.timeWait(2);
		Utility_Functions.xWaitForElementPresent(driver, newPropertiesDetailsPage, 3);
		Utility_Functions.xClick(driver, newPropertiesDetailsPage, true);
		report.updateTestLog("Verify Properties Private Tag", "Verifying the New Property is displayed", Status.PASS);
		Utility_Functions.timeWait(2);
		Utility_Functions.xWaitForElementPresent(driver, newPropertiesDetailsPage, 3);
		SearchTextSOQL property = new SearchTextSOQL(scriptHelper);
		String propertyName = property.fetchRecord("Property__c", "Name");
		searchPropertyWithPrivateTag.sendKeys(propertyName);
		// Utility_Functions.xSendKeys(driver,newPropertiesDetailsPage, "T");
		searchPropertyWithPrivateTag.sendKeys(Keys.ARROW_DOWN);
		searchPropertyWithPrivateTag.sendKeys(Keys.ENTER);
		report.updateTestLog("Verify Properties Private Tag",
				"Verifying the Property name is entered in the new property page", Status.PASS);
		Utility_Functions.xWaitForElementPresent(driver, savePropertyPrivateTag, 3);
		Utility_Functions.xClick(driver, savePropertyPrivateTag, true);
		report.updateTestLog("Verify Properties Private Tag",
				"Verifying the Property name is entered and new property is saved", Status.PASS);

	}

	/**
	 * Validating the Bulk tagging functionality
	 * 
	 * @author Haritha
	 */

	public void verifyBulkTaggingFunctionality() {

		/*
		 * Utility_Functions.xWaitForElementPresent(driver, menu_More, 3);
		 * Utility_Functions.xClick(driver, menu_More, true);
		 * Utility_Functions.xWaitForElementPresent(driver, bulkTagging, 3);
		 * Utility_Functions.xClick(driver, bulkTagging, true);
		 */
		sf_UtilityFunctions.oneAppNavigationTab("Bulk Tagging");
		Utility_Functions.timeWait(5);
		Utility_Functions.xSwitchtoFrame(driver, accountSearch);
		Utility_Functions.timeWait(5);
		Utility_Functions.xWaitForElementPresent(driver, accountSearch, 3);
		Utility_Functions.xClick(driver, accountSearch, true);
		Utility_Functions.xSendKeys(driver, accountSearch, "Test");
		Utility_Functions.xWaitForElementPresent(driver, searchProperty, 3);
		Utility_Functions.xClick(driver, searchProperty, true);
		Utility_Functions.timeWait(2);
		report.updateTestLog("Account Search", "Verify the Account name is entered and searched account is displayed",
				Status.PASS);
	}

	public void bulkTaggingFunctionality() {

		/*
		 * Utility_Functions.xWaitForElementPresent(driver, menu_More, 3);
		 * Utility_Functions.xClick(driver, menu_More, true);
		 */
		sf_UtilityFunctions.oneAppNavigationTab("Bulk tagging");
		Utility_Functions.timeWait(5);
		Utility_Functions.xSwitchtoFrame(driver, accountSearch);
		Utility_Functions.timeWait(5);
		Utility_Functions.xWaitForElementPresent(driver, accountSearch, 3);
		Utility_Functions.xClick(driver, accountSearch, true);
		Utility_Functions.xSendKeys(driver, accountSearch, "Test");
		Utility_Functions.xWaitForElementPresent(driver, searchProperty, 3);
		Utility_Functions.xClick(driver, searchProperty, true);
		Utility_Functions.timeWait(3);
		for (int i = 1; i <= 3; i++) {
			WebElement element = driver.findElement(By.xpath(
					"//h2[contains(text(),'Property Detail')]/parent::div/following-sibling::div/span/table/tbody/tr["
							+ i + "]/td/label/input[@type='checkbox']"));
			Utility_Functions.xClick(driver, element, true);
			report.updateTestLog("Selecting the Account", "Verifying the account search and Selecting the account",
					Status.PASS);
		}

	}
}