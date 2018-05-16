package pageObjects;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.cognizant.Craft.ReusableLibrary;
import com.cognizant.Craft.ScriptHelper;
import com.cognizant.framework.Status;

import supportLibraries.Utility_Functions;

/**
 * Page Object Class for Marketing Lists Page
 * 
 * @author Rajashekar
 *
 */

public class MarketingListsPage extends ReusableLibrary {

	/*
	 * Constructor to initialize the business component library
	 * 
	 * @param scriptHelper The {@link ScriptHelper} object passed from the {@link
	 * DriverScript}
	 */

	public MarketingListsPage(ScriptHelper scriptHelper) {
		super(scriptHelper);
		PageFactory.initElements(driver.getWebDriver(), this);
	}

	@FindBy(xpath = "//header[@id='oneHeader']//span[text()='Marketing Lists']")
	WebElement menu_marketingLists;

	@FindBy(xpath = "//div[@title, 'New']")
	WebElement newButton;

	@FindBy(xpath = "//span[text()='Marketing List Name']/../..//input")
	WebElement marketingListName;

	@FindBy(xpath = "//input[@title='Search Contacts']/../")
	WebElement selectAuthor;
	
	@FindBy(xpath = "//span[text()='Save']")
	WebElement newMarketingListSave;

	@FindBy(xpath = "//a[@title='Select List View']/div/span[2]")
	WebElement selectListView;

	@FindBy(xpath = ".//span[text()='All Marketing Lists']")
	WebElement allMarketingLists;

	@FindBy(xpath = ".//span[text()='Marketing List Name']/../../../../../../tbody/tr[1]//a")
	WebElement selectMarketingList;

	@FindBy(xpath = "//a[@title='Show 3 more actions']")
	WebElement downArrow;

	@FindBy(xpath = ".//div[@class='branding-actions actionMenu']/ul//a[@title='Share Publications']")
	WebElement clickSharePublications;

	@FindBy(xpath = "//input[@title='Add']")
	WebElement buttonAdd;

	@FindBy(xpath = ".//*[@id='sharing_search']")
	WebElement selectUsers;

	@FindBy(xpath = ".//*[@id='searchValue_sharing_search']")
	WebElement searchValue;

	@FindBy(xpath = "//input[@title='Find']")
	WebElement buttonFind;

	@FindBy(xpath = ".//label[text()='Available']/parent::div/parent::td/parent::tr/td[1]/select/option")
	WebElement availableUsers;

	@FindBy(xpath = ".//div[text()='Add']/parent::td/div[2]/a/img")
	WebElement rightArrowIcon;

	@FindBy(xpath = ".//label[text()='Access Level']/parent::td/parent::tr/td[2]/div/select")
	WebElement accessLevel;

	@FindBy(xpath = "//input[@name='save']")
	WebElement buttonSave;

	//

	public void shareMarketingList() {

/*		Utility_Functions.xWaitForElementPresent(driver, menu_marketingLists, 4);
		Utility_Functions.xClick(driver, menu_marketingLists, true);

		Utility_Functions.timeWait(2);
		Utility_Functions.xWaitForElementClickable(driver, selectListView, 4);
		Utility_Functions.xClick(driver, selectListView, true);

		// select All Marketing list option from the dropdown
		Utility_Functions.timeWait(2);
		Utility_Functions.xWaitForElementClickable(driver, allMarketingLists, 4);
		Utility_Functions.xClick(driver, allMarketingLists, true);

		// Click/Select first record marketing list name from the table
		Utility_Functions.timeWait(2);
		Utility_Functions.xWaitForElementClickable(driver, selectMarketingList, 4);
		Utility_Functions.xClick(driver, selectMarketingList, true);*/
		
		
		createMarketingList();

		// Click down arrow to select share publications
		Utility_Functions.timeWait(2);
		Utility_Functions.xWaitForElementClickable(driver, downArrow, 4);
		Utility_Functions.xClick(driver, downArrow, true);

		// Click share publications
		Utility_Functions.timeWait(2);
		Utility_Functions.xWaitForElementPresent(driver, clickSharePublications, 3);
		Utility_Functions.xClick(driver, clickSharePublications, true);

		// Click Add button
		Utility_Functions.timeWait(2);
		List<WebElement> extFrame = driver.findElements(By.tagName("iframe"));
		driver.switchTo().frame(extFrame.get(extFrame.size() - 1));
		List<WebElement> intFrame = driver.findElements(By.tagName("iframe"));
		driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@title='Content']")));
		Utility_Functions.xWaitForElementPresent(driver, buttonAdd, 5);
		Utility_Functions.xClick(driver, buttonAdd, true);
		driver.switchTo().defaultContent();

		// Select 'Users' option from search dropdown
		List<WebElement> extFrame1 = driver.findElements(By.tagName("iframe"));
		driver.switchTo().frame(extFrame.get(extFrame.size() - 1));
		List<WebElement> intFrame1 = driver.findElements(By.tagName("iframe"));
		driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@title='Content']")));

		Utility_Functions.timeWait(4);
		Utility_Functions.xWaitForElementPresent(driver, selectUsers, 3);
		Utility_Functions.xSelectDropdownByName(selectUsers, "Users");

		// Select available user option from Available
		Utility_Functions.timeWait(2);
		Utility_Functions.xWaitForElementPresent(driver, searchValue, 3);
		Utility_Functions.xSendKeys(driver, searchValue, dataTable.getData("General_Data", "User"));

		// Click Find button
		Utility_Functions.xWaitForElementPresent(driver, buttonFind, 3);
		Utility_Functions.xClick(driver, buttonFind, true);
		Utility_Functions.timeWait(2);
		Utility_Functions.xClick(driver, availableUsers, true);
		Utility_Functions.xClick(driver, rightArrowIcon, false);

		// Select access level as "Read only"
		Utility_Functions.timeWait(2);
		Utility_Functions.xWaitForElementPresent(driver, accessLevel, 3);
		if (dataTable.getData("General_Data", "TC_ID").contains("ReadOnly")) {
			Utility_Functions.xSelectDropdownByName(accessLevel, "Read Only");
		} else if ((dataTable.getData("General_Data", "TC_ID").contains("ReadWrite")))
			Utility_Functions.xSelectDropdownByName(accessLevel, "Read/Write");

		// Click Find button
		Utility_Functions.xWaitForElementPresent(driver, buttonSave, 3);
		Utility_Functions.xClick(driver, buttonSave, true);
		Utility_Functions.timeWait(2);

		String userText = driver.findElement(By.xpath("//a[contains(text(),\"Lavanya\")]/parent::td/parent::tr"))
				.getText();

		if (dataTable.getData("General_Data", "TC_ID").contains("ReadOnly")) {
			if (userText.contains(dataTable.getData("General_Data", "User")) && userText.contains("Read Only")
					&& userText.contains("Manual Sharing")) {
				report.updateTestLog("Marketing list is shared using shared publicaton",
						"Marketing list is shared using shared publicaton::", Status.PASS);
			} else {
				report.updateTestLog("Marketing list is not shared using shared publicaton",
						"Marketing list is not shared using shared publicaton::", Status.FAIL);
			}
		}else {
			if (userText.contains(dataTable.getData("General_Data", "User")) && userText.contains("Read/Write")
					&& userText.contains("Manual Sharing")) {
				report.updateTestLog("Marketing list is shared using shared publicaton",
						"Marketing list is shared using shared publicaton::", Status.PASS);
			} else {
				report.updateTestLog("Marketing list is not shared using shared publicaton",
						"Marketing list is not shared using shared publicaton::", Status.FAIL);
			}
		}

	}
	
	
	
	public void createMarketingList() {
				
		Utility_Functions.xWaitForElementPresent(driver, menu_marketingLists, 4);
		Utility_Functions.xClick(driver, menu_marketingLists, true);
		Utility_Functions.timeWait(3);
		
		Utility_Functions.xWaitForElementClickable(driver, newButton, 3);
		Utility_Functions.xClickButton(driver, newButton, true);
		Utility_Functions.timeWait(3);
		
		String marketingListNamae = "Automation-Market"+Utility_Functions.xRandomFunction();
		Utility_Functions.xWaitForElementPresent(driver, marketingListName, 3);
		Utility_Functions.xSendKeys(driver, marketingListName, marketingListNamae);
		
		Utility_Functions.xWaitForElementPresent(driver, selectAuthor, 3);
		Utility_Functions.xClick(driver, selectAuthor, true);
		
		
		String xpathForAuthor = "//div[@title='"+dataTable.getData("General_Data", "User")+"']/parent::div";
		driver.findElement(By.xpath(xpathForAuthor)).click();
		
		Utility_Functions.xWaitForElementPresent(driver, newMarketingListSave, 3);
		Utility_Functions.xClick(driver, newMarketingListSave, true);
		
		
		
		
		
		//div[@title='Lavanya Atthe']/parent::div
	}

}
