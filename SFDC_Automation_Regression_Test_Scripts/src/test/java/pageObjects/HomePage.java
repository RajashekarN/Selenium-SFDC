package pageObjects;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.cognizant.Craft.ReusableLibrary;
import com.cognizant.Craft.ScriptHelper;
import com.cognizant.framework.Status;

import supportLibraries.Utility_Functions;

/**
 * Page Object Class for Home Page
 * 
 * @author Vishnuvardhan
 *
 */

public class HomePage extends ReusableLibrary {
	/*
	 * Constructor to initialize the business component library
	 * 
	 * @param scriptHelper The {@link ScriptHelper} object passed from the
	 * {@link DriverScript}
	 */

	public HomePage(ScriptHelper scriptHelper) {
		super(scriptHelper);
		PageFactory.initElements(driver.getWebDriver(), this);
		// new WebDriverUtil(driver);
		// Utility_Functions utility = new Utility_Functions(scriptHelper);
	}

	@FindBy(css = "one-app-nav-bar a[title='Accounts']")
	WebElement menu_Accounts;

	@FindBy(css = "one-app-nav-bar a[title='Leads']")
	WebElement menu_Leads;

	@FindBy(xpath = "//div[@class='bBottom']//span[text()='Opportunities']")
	WebElement menu_Opportunities;

	@FindBy(xpath = "//span[@class='uiOutputText'][text()='Accounts']")
	WebElement accounts_HomePage;

	@FindBy(xpath = "//span[@class='uiOutputText'][text()='Opportunities']")
	WebElement opportunities_HomePage;

	@FindBy(xpath = "//span[@class='uiOutputText'][text()='Leads']")
	WebElement leads_HomePage;

	@FindBy(xpath = "//ul/li[@class='slds-list__item slds-p-bottom--xxx-small']")
	WebElement homePage_Links;

	@FindBy(xpath = "//*[@id='header']/a/span")
	WebElement welcomeToSalesforce;

	@FindBy(xpath = "//*[text()='Salesforce Training Videos/Tools']/parent::div/parent::div/div[1]/span/img[@alt='logo']")
	WebElement cbreImage;

	@FindBy(xpath="//ul[@class='slds-list--vertical slds-has-inline-block-links']/li/a[text()='Submit Acct Update Request']")
	WebElement submitAccountUpdateRequest;

	@FindBy(xpath="//input[@placeholder='Search People']")
	WebElement requestedFor;

	@FindBy(xpath="//input[@placeholder='Search Accounts']")
	WebElement searchAccounts;

	@FindBy(xpath="//a[@title='AMER']")
	WebElement region;

	@FindBy(xpath="//span[text()='Description']/parent::label/parent::div/textarea[@class='textarea']")
	WebElement description;

	@FindBy(xpath="//button[@title='Save']")
	WebElement saveCase;

	@FindBy(xpath="//div[@class='slds-p-around--medium']/a[text()='SFDC Training']")
	WebElement SFDCTrainingLink;

	@FindBy(xpath="//span[contains(@title,'Recent Records')]")
	WebElement recentRecords;

	@FindBy(xpath = "//*[text()='More']")
	WebElement menu_More;

	@FindBy(xpath="//a[@role='menuitem']/span[contains(@class,'slds-truncate')][text()='Marketing Lists']")
	WebElement more_marketingListings;

	@FindBy(xpath="//div[@class='slds-truncate'][text()='New']")
	WebElement newMarketingListings;

	@FindBy(xpath="//label[contains(@class,'form-element__label')]/span[text()='Marketing List Name']")
	WebElement marketingListName;

	/*	@FindBy(xpath = "//button[@class='bare slds-button uiButton forceHeaderButton oneUserProfileCardTrigger']")
	WebElement logOutButton;

	@FindBy(xpath = "//div[@class='profile-card-indent']//a[text()='Log Out']")
	WebElement logOut;*/


	/**
	 * Validating the Home Page login functionality
	 * 
	 * @author Vishnuvardhan
	 *
	 */

	public void verify_Home_Page() {
		try {
			if(welcomeToSalesforce.isDisplayed()) {
				report.updateTestLog("Verify Home Page Links", "Welcome to Salesforce link is present in Home Page", Status.PASS);
			} else {
				report.updateTestLog("Verify Home Page Links", "Welcome to Salesforce link is not present in Home Page", Status.FAIL);
			}
			Utility_Functions.timeWait(4);
			if(cbreImage.isDisplayed()) {
				report.updateTestLog("Verify Home Page Links", "CBRE image is present in Home Page", Status.PASS);
			} else {
				report.updateTestLog("Verify Home Page Links", "CBRE image is not present in Home Page", Status.FAIL);
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		validate_Support_Custom_Links();
		//verify_Welcome_Links();

	}

	/**
	 * Validating the Welcome Links on the Home Page 
	 * 
	 * @author Vishnuvardhan
	 *
	 */


	public void verify_Welcome_Links() {
		try {
			List <WebElement> welcomeLinks= driver.findElements(By.xpath("//div[@class='slds-p-around--medium']/a"));
			boolean salesforceTrainingLink = Utility_Functions.validateLinks(welcomeLinks, "Salesforce Training Videos/Tools");
			boolean myActivitylink = Utility_Functions.validateLinks(welcomeLinks, "My Activity List");
			if((salesforceTrainingLink == true) && (myActivitylink == true)) {
				report.updateTestLog("Verify Home Page Welcome Links", "Welcome Links Salesforce Training Videos/ Tools and My Activity Links are present in the Home Page", Status.PASS);		
			} else {
				report.updateTestLog("Verify Home Page Welcome Links", "Welcome Links are not present in the Home Page", Status.FAIL);
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
		}

	}

	/**
	 * Validating the Home Page Menu for Accounts tab
	 * 
	 * @author Vishnuvardhan
	 *
	 */


	public void validate_Menu_Accounts() {
		Utility_Functions.xWaitForElementPresent(driver, menu_Accounts, 4);
		try {
			if (menu_Accounts.isDisplayed()) {
				report.updateTestLog("Verify Menu - Accounts", "Accounts menu is present in Home Page", Status.PASS);
			} else {
				report.updateTestLog("Verify Menu - Accounts", "Accounts menu is not present in Home Page", Status.FAIL);
			}
			menu_Accounts.click();
			Utility_Functions.xWaitForElementPresent(driver, accounts_HomePage, 3);
			if (accounts_HomePage.isDisplayed()) {
				report.updateTestLog("Verify Accounts Home Page", "Accounts Home Page is displayed", Status.PASS);
			} else {
				report.updateTestLog("Verify Accounts Home Page", "Accounts Home Page didn't get displayed", Status.FAIL);
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
			report.updateTestLog("Exception in validate Menu Accounts", e.getMessage(), Status.FAIL);
		}
	}

	/**
	 * Validating the Home Page Menu for Opportunities tab
	 * 
	 * @author Vishnuvardhan
	 *
	 */

	public void validate_Menu_Opportunities() {
		Utility_Functions.timeWait(4);
		try {
			if (menu_Opportunities.isDisplayed()) {
				report.updateTestLog("Verify Menu - Opportunities", "Opportunities menu is present in Home Page",
						Status.PASS);
			} else {
				report.updateTestLog("Verify Menu - Opportunities", "Opportunities menu is not present in Home Page",
						Status.FAIL);
			}
			menu_Opportunities.click();
			Utility_Functions.timeWait(3);
			if (opportunities_HomePage.isDisplayed()) {
				report.updateTestLog("Verify Opportunities Home Page", "Opportunities Home Page is displayed", Status.PASS);
			} else {
				report.updateTestLog("Verify Opportunities Home Page", "Opportunities Home Page didn't get displayed",
						Status.FAIL);
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
		}
	}

	/**
	 * Validating the Home Page Menu for Leads tab
	 * 
	 * @author Vishnuvardhan
	 *
	 */


	public void validate_Menu_Leads() {
		Utility_Functions.timeWait(4);
		try {
			if (menu_Leads.isDisplayed()) {
				report.updateTestLog("Verify Menu - Leads", "Leads menu is present in Home Page", Status.PASS);
			} else {
				report.updateTestLog("Verify Menu - Leads", "Leads menu is not present in Home Page", Status.FAIL);
			}
			menu_Leads.click();
			Utility_Functions.timeWait(1);
			if (leads_HomePage.isDisplayed()) {
				report.updateTestLog("Verify Leads Home Page", "Leads Home Page is displayed", Status.PASS);
			} else {
				report.updateTestLog("Verify Leads Home Page", "Leads Home Page didn't get displayed", Status.FAIL);
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
		}
	}

	/**
	 * Adding the links to the List 
	 * 
	 * @author Vishnuvardhan
	 *
	 */

	static ArrayList<String> list = new ArrayList<String>();
	public void add_LinkstoList() {
		list.add("Submit Support Case");
		list.add("Submit New User Request");
		list.add("Submit Acc Update Request");
		list.add("Submit Enhancement Request");
		list.add("My Open Salesforce Requests");
		list.add("Global SPOC Report");
		list.add("Finishing First");
		list.add("Lexis Nexis");
		list.add("Real Capital Analytics");
		list.add("TRAC");
		list.add("Vouchers Online");
		System.out.println("Home Page Links added to the list are:::" + list);
	}

	/**
	 * Validating the Support Custom Links on Home Page 
	 * 
	 * @author Vishnuvardhan
	 *
	 */

	public void validate_Support_Custom_Links() {
		add_LinkstoList();
		Utility_Functions.timeWait(2);
		List<WebElement> homePageLinks = driver
				.findElements(By.xpath("//ul[@class='slds-list--vertical slds-has-inline-block-links']/li/a"));
		String[] linkTexts = new String[homePageLinks.size()];
		System.out.println(linkTexts);
		Utility_Functions.timeWait(1);
		int i = 0, count = 0;
		try {
			for (WebElement element : homePageLinks) {
				linkTexts[i] = element.getText();
				if (linkTexts[i].equals(list.get(i))) {
					count++;
					System.out.println("Link " + linkTexts[i] + "matches " + "with the list" + list.get(i));
					report.updateTestLog("Verify Home Page Links", "Link " + linkTexts[i] + " present in Home Page:::",
							Status.PASS);
				}
				i++;
			}
			System.out.println(count);
			if (count == 10) {
				System.out.println("All the links are present in Home Page:::");
				report.updateTestLog("Verify Home Page Links", "All the links are present in Home Page:::",
						Status.PASS);
			} else {
				report.updateTestLog("Verify Home Page Links", "All the links are not present in Home Page:::",
						Status.FAIL);
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
		}
	}

	/**
	 * Validating the Logout functionality
	 * 
	 * @author Vishnuvardhan
	 *
	 *//*

	public void logout() {
		try {
			Utility_Functions.timeWait(2);
			Utility_Functions.xClick(driver, logOutButton, true);
			Utility_Functions.timeWait(1);
			Utility_Functions.xClick(driver, logOut, true);		
			report.updateTestLog("Verify Logout", "User has been logged out successfully:::",Status.PASS);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}*/

	/**
	 * Validating the tabs on Home Page for the APAC Capital Markets 
	 * 
	 * @author Ramya
	 *
	 */

	static ArrayList<String> tabsList = new ArrayList<String>();
	public void homePageTabsList() {
		tabsList.add("Home");
		tabsList.add("Calendar");
		tabsList.add("Chatter");
		tabsList.add("Groups");
		tabsList.add("Leads");
		tabsList.add("Accounts");
		tabsList.add("Contacts");
		tabsList.add("Opportunities");
		tabsList.add("Reports");
		tabsList.add("Dashboards");
		tabsList.add("Private Notes");
		tabsList.add("Properties");
		tabsList.add("Private Tags");
		tabsList.add("Bulk Tagging");
		tabsList.add("Cases");
		System.out.println("The Home Page Tabs for the APAC Capital Markets are:::" + tabsList);
	}


	/**
	 * Validating the tabs on the Home Page for the APAC broker Capital Markets
	 * 
	 * @author Ramya
	 *
	 */	


	public void validateHomePageTabsForAPACCapitalMarkets() {
		homePageTabsList();
		Utility_Functions.timeWait(2);		
		List<WebElement> homePageTabsList = driver.findElements(By.xpath("//div[contains(@class,'slds-context-bar')]//span[@class='slds-truncate']"));
		int i1 = 0, j=0, countLabelList = 0;
		String[] labelTexts = new String[tabsList.size()];
		while(j<tabsList.size()) {
			for (WebElement element : homePageTabsList) {
				labelTexts[i1] = element.getText();
				if (labelTexts[i1].contains(tabsList.get(j))) {
					System.out.println("Verify Add Opportunity Page Label List" + element.getText());
					report.updateTestLog("Verify Add Opportunity Page Label List", element.getText() + "::::label list is present in Add Opportunity Page", Status.PASS);
					countLabelList++;
				}
				i1++;
			}
			i1=0;
			j++;
		}
		System.out.println("OpportunityInformationList:::"+ countLabelList);
		if (countLabelList >= 9) {
			System.out.println("All the Tabs are present in Home Page ");
			report.updateTestLog("Verify Home Page Tabs", "All the Tabs are present in Home Page", Status.PASS);
		} else if (countLabelList < 10) {
			report.updateTestLog("Verify Home Page Tabs", "All the Tabs are not present in Home Page", Status.FAIL);
		}

		/*	List<WebElement> homePageTabsList = driver
				.findElements(By.xpath("//div[contains(@class,'slds-context-bar')]//span[@class='slds-truncate']"));
		String[] homePageTabs = new String[homePageTabsList.size()];
		System.out.println(homePageTabs);
		Utility_Functions.timeWait(1);
		int i = 0, count = 0;
		try {
			for (WebElement element : homePageTabsList) {
				homePageTabs[i] = element.getText();
				if (homePageTabs[i].contains(tabsList.get(i))) {
					count++;
					System.out.println( homePageTabs[i] + tabsList.get(i));
					report.updateTestLog("Verify Home Page Tabs", "Tabs " + homePageTabs[i] + " present in APAC Capital Markets Home Page Menu",
							Status.PASS);
				}
				i++;
			}
			System.out.println(count);
			if (count >= 10) {
				System.out.println("All the Tabs are present in Home Page ");
				report.updateTestLog("Verify Home Page Tabs", "All the Tabs are present in Home Page",
						Status.PASS);
			} else if (count < 10) {
				report.updateTestLog("Verify Home Page Tabs", "All the Tabs are not present in Home Page",
						Status.FAIL);
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
		}*/
	}
	/**
	 * Validating the tabs on the Home Page for the Account update
	 * 
	 * @author Ramya
	 *
	 */	

	public void validateHomePageAccountUpdate() {
		Utility_Functions.timeWait(4);
		Utility_Functions.xWaitForElementPresent(driver,submitAccountUpdateRequest, 3);
		Utility_Functions.xClick(driver,submitAccountUpdateRequest, true);
		Utility_Functions.timeWait(4);
		Utility_Functions.xWaitForElementPresent(driver,requestedFor, 3);
		Utility_Functions.xSendKeys(driver,requestedFor, "test");
		requestedFor.sendKeys(Keys.ARROW_DOWN);
		Utility_Functions.timeWait(2);
		requestedFor.sendKeys(Keys.ENTER);
		List<WebElement> accountNamesList = driver.findElements(
				By.xpath("//a[@class='slds-truncate outputLookupLink slds-truncate forceOutputLookup'][contains(@data-recordid,'005')]"));

		Utility_Functions.xclickOnFirstElementfromList(accountNamesList);
		Utility_Functions.xScrollWindow(driver);
		Utility_Functions.timeWait(1);
		Utility_Functions.xScrollWindowTop(driver);
		Utility_Functions.timeWait(2);
		Utility_Functions.xWaitForElementPresent(driver,searchAccounts, 3);
		Utility_Functions.xSendKeys(driver,searchAccounts, "test");
		searchAccounts.sendKeys(Keys.ARROW_DOWN);
		Utility_Functions.timeWait(2);
		searchAccounts.sendKeys(Keys.ENTER);
		Utility_Functions.xWaitForElementPresent(driver,region, 3);
		Utility_Functions.xClick(driver,region, true);
		Utility_Functions.xWaitForElementPresent(driver,description, 3);
		Utility_Functions.xSendKeys(driver,description, "This is a case");
		Utility_Functions.xWaitForElementPresent(driver,saveCase, 3);
		Utility_Functions.xClick(driver, saveCase, true);
		report.updateTestLog("Verify Home Page Account Update", "Home Page AccountUpdate is done successfully", Status.PASS);
	}
	/**
	 * Validating the tabs on the Home Page for the SFDC Training link
	 * 
	 * @author Ramya
	 *
	 */	

	public void validateHomePageSFDCTrainingLink() {
		Utility_Functions.timeWait(4);
		if(SFDCTrainingLink.isDisplayed()) {

			report.updateTestLog("Verify Home Page SFDC Training Link", "The SFDC Training Link is present", Status.PASS);
		} else {
			report.updateTestLog("Verify Home Page SFDC Training Link", "The SFDC Training Link is not present", Status.FAIL);
		}

	}
	/**
	 * Validating the tabs on the Home Page for the Recent records
	 * 
	 * @author Ramya
	 *
	 */	

	public void validateHomePageRecentRecords() {
		Utility_Functions.timeWait(4);
		if(recentRecords.isDisplayed()) {
			report.updateTestLog("Verify Home Page Recent Records", "The Recent Records is present", Status.PASS);
		} else {
			report.updateTestLog("Verify Home Page Recent Records", "The Recent Records is not present", Status.FAIL);
		}

	}
	/**
	 * Validating the Marketing Lists tab on the Home Page
	 * 
	 * @author Ramya
	 *
	 */	

	public void validateHomePageMarketingLists() {
		Utility_Functions.xWaitForElementPresent(driver,menu_More, 3);
		Utility_Functions.xClick(driver, menu_More, true);
		report.updateTestLog("Verify Home Page Marketing Lists","Verifying Menu_more is displayed on the home page",Status.PASS);
		Utility_Functions.timeWait(2);
		Utility_Functions.xWaitForElementPresent(driver,more_marketingListings, 3);
		Utility_Functions.xClick(driver,more_marketingListings, true);
		report.updateTestLog("Verify Offer Auto Populated By Project Enquiries","Verifying Project Enquiries is displayed",Status.PASS);
		Utility_Functions.timeWait(2);
		Utility_Functions.xWaitForElementPresent(driver,newMarketingListings, 3);
		Utility_Functions.xClick(driver,newMarketingListings, true);
		report.updateTestLog("Verify Offer Auto Populated By Project Enquiries","Verifying the new Project Enquiries is displayed",Status.PASS);
		Utility_Functions.timeWait(5);


	}
}
