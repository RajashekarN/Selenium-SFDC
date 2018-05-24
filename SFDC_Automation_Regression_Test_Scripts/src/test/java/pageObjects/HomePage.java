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
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.cognizant.Craft.ReusableLibrary;
import com.cognizant.Craft.ScriptHelper;
import com.cognizant.framework.Status;

import supportLibraries.SF_UtilityFunctions;
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

	/**
	 * Page Object Class for verify_Home_Page
	 * 
	 * @author Vishnuvardhan
	 *
	 */

	@FindBy(xpath = "//span[@title='Welcome to Salesforce!']")
	WebElement welcomeToSalesforce;

	@FindBy(xpath = "//*[text()='Salesforce Training Videos/Tools']/parent::div/parent::div/div[1]/span/img[@alt='logo']")
	WebElement cbreImage;


	/**
	 * Page Object Class for validate_Menu_Accounts
	 * 
	 * @author Vishnuvardhan
	 *
	 */

	@FindBy(xpath = "//span[@class='uiOutputText'][text()='Accounts']")
	WebElement accounts_HomePage;

	@FindBy(css = "one-app-nav-bar a[title='Accounts']")
	WebElement menu_Accounts;


	/**
	 * Page Object Class for validate_Menu_Opportunities
	 * 
	 * @author Vishnuvardhan
	 *
	 */


	@FindBy(xpath = "//div[@class='bBottom']//span[text()='Opportunities']")
	WebElement menu_Opportunities;

	@FindBy(xpath = "//span[@class='uiOutputText'][text()='Opportunities']")
	WebElement opportunities_HomePage;


	/**
	 * Page Object Class for validate_Menu_Leads
	 * 
	 * @author Vishnuvardhan
	 *
	 */

	@FindBy(css = "one-app-nav-bar a[title='Leads']")
	WebElement menu_Leads;

	@FindBy(xpath = "//span[@class='uiOutputText'][text()='Leads']")
	WebElement leads_HomePage;


	/**
	 * Page Object Class for validateHomePageSFDCTrainingLink
	 * 
	 * @author Vishnuvardhan
	 *
	 */

	@FindBy(xpath = "//div[@class='slds-p-around--medium']/a[text()='SFDC Training']")
	WebElement SFDCTrainingLink;


	/**
	 * Page Object Class for validateHomePageAccountUpdate
	 * 
	 * @author Vishnuvardhan
	 *
	 */

	@FindBy(xpath = "//ul[@class='slds-list--vertical slds-has-inline-block-links']/li/a[text()='Submit Acct Update Request']")
	WebElement submitAccountUpdateRequest;

	@FindBy(xpath = "//input[@title='Search People']")
	WebElement requestedFor;

	@FindBy(xpath = "//input[@title='Search Accounts']")
	WebElement searchAccounts;

	@FindBy(xpath = "//span[text()='Region']/parent::span/parent::div//a")
	WebElement regionField;

	@FindBy(xpath = "//a[@title='AMER']")
	WebElement region;

	@FindBy(xpath = "//span[text()='Description']/parent::label/parent::div/textarea")
	WebElement description;

	@FindBy(xpath = "//button[@title='Save']")
	WebElement saveCase;


	/**
	 * Page Object Class for validateHomePageRecentRecords
	 * 
	 * @author Vishnuvardhan
	 *
	 */


	@FindBy(xpath = "//span[contains(@title,'Recent Records')]")
	WebElement recentRecords;


	/**
	 * Page Object Class for validateHomePageRecentRecords
	 * 
	 * @author Vishnuvardhan
	 *
	 */

	@FindBy(xpath = "//ul/li[@class='slds-list__item slds-p-bottom--xxx-small']")
	WebElement homePage_Links;


	/**
	 * Page Object Class for validateHomePageMarketingLists
	 * 
	 * @author Vishnuvardhan
	 *
	 */

	@FindBy(xpath = "//*[text()='More']")
	WebElement menu_More;

	@FindBy(xpath = "//a[@role='menuitem']/span[contains(@class,'slds-truncate')][text()='Marketing Lists']")
	WebElement more_marketingListings;

	@FindBy(xpath = "//div[@class='slds-truncate'][text()='New']")
	WebElement newMarketingListings;

	@FindBy(xpath = "//label[contains(@class,'form-element__label')]/span[text()='Marketing List Name']")
	WebElement marketingListName;


	/**
	 * Page Object Class for validateHomePageTabs
	 * 
	 * @author Vishnuvardhan
	 *
	 */

	@FindBy(xpath = "//button[text()='More']")
	WebElement showMore;

	@FindBy(xpath = "//div[@class='slds-truncate'][text()='New']")
	WebElement newOpportunity;

	@FindBy(xpath = "//span[contains(text(),'Account Name')]/parent::label/following-sibling::div//input[contains(@title,'Search Accounts')]")
	WebElement accountNameNewOpportunity;

	@FindBy(xpath = "//div[contains(@class,'primaryLabel')][contains(@title,'Test Automation_0101')]")
	WebElement accountNameNewOpp;

	@FindBy(xpath = "//span[text()='Close Date']/parent::label/parent::div//input")
	WebElement closeDate_AS;

	@FindBy(xpath = "//span[contains(text(),'Lead Source')]/parent::span/following-sibling::div//a[contains(@aria-label,'Lead Source')]")
	WebElement leadSourceNewOpp;

	@FindBy(xpath = "//a[contains(@title,'Business Relationship')]")
	WebElement leadSourceNewOppValue;

	@FindBy(xpath = "//span[text()='Estimated Gross Fee/Commission']/parent::label/parent::div/input")
	WebElement estiamtedGrossFeeCommissionValue;

	@FindBy(xpath = "//span[text()='Estimated Transaction Value']/parent::label/parent::div/input")
	WebElement estimatedTransactionValue;

	@FindBy(xpath = "//button[contains(@class,'forceActionButton')]/span[text()='Save']")
	WebElement saveNewOpp;

	@FindBy(xpath = "//span[contains(text(),'CBRE Office')]/parent::span/following-sibling::div//a[contains(@aria-label,'CBRE Office')]")
	WebElement opportunityCBREOffice;

	@FindBy(xpath = "//a[contains(@title,'India – Ahmedabad')]")
	WebElement opportunityCBREOfficeValue;

	@FindBy(xpath = "//span[contains(text(),'Country')]/parent::span/following-sibling::div//a[contains(@aria-label,'Country')]")
	WebElement opportunityCountry;

	@FindBy(xpath = "//a[(@title='India')]")
	WebElement opportunityCountryValue;

	@FindBy(xpath = "//span[contains(text(),'Asset Type')]/parent::span/following-sibling::div//a[contains(@aria-label,'Asset Type')]")
	WebElement assetType;

	@FindBy(xpath = "//a[@title='Office']")
	WebElement assetTypeValue;

	@FindBy(xpath = "//span[contains(text(),'City Tier')]/parent::span/following-sibling::div//a[contains(@aria-label,'City Tier')]")
	WebElement cityTier;

	@FindBy(xpath = "//a[contains(@title,'Tier 1')]")
	WebElement cityTierValue;

	@FindBy(xpath = "//span[contains(text(),'City')]/parent::label/parent::div/input")
	WebElement opportunityCity;

	@FindBy(xpath = "//span[text()='Assignment Start Date']/parent::label/parent::div//input")
	WebElement assignmentStartDate;

	@FindBy(xpath = "//a[contains(@aria-label,'Opportunity Currency')]")
	WebElement selectOpportunityCurrency;

	@FindBy(xpath = "//a[contains(@title,'Indian Rupee')]")
	WebElement opportunityCurrencyValue;

	@FindBy(xpath = "//div[contains(@class,'pbBottomButtons')]//input[contains(@id,'next')]")
	WebElement nextForJapan;

	@FindBy(xpath = "//button[text()='Continue']")
	WebElement continueButton;

	@FindBy(xpath = "//select[@id='record-type-select']")
	WebElement selectOpportunityRecordType;

	@FindBy(xpath = "//select[@id='record-type-select']/option[contains(text(),'APAC Debt & Structured Finance')]")
	WebElement opportunityDSFValue;

	@FindBy(xpath = "//a[@class='tabHeader']//span[text()='Details']")
	WebElement details;

	SF_UtilityFunctions sf_UtilityFunctions = new SF_UtilityFunctions(scriptHelper);

	/**
	 * Validating the Home Page login functionality
	 * 
	 * @author Vishnuvardhan
	 *
	 */

	public void verify_Home_Page() {
		if (welcomeToSalesforce.isDisplayed()) {
			report.updateTestLog("Verify Home Page Links", "Welcome to Salesforce link is present in Home Page", Status.PASS);
		} else {
			report.updateTestLog("Verify Home Page Links", "Welcome to Salesforce link is not present in Home Page", Status.FAIL);
		}
		Utility_Functions.timeWait(4);
		if (cbreImage.isDisplayed()) {
			report.updateTestLog("Verify Home Page Links", "CBRE image is present in Home Page", Status.PASS);
		} else {
			report.updateTestLog("Verify Home Page Links", "CBRE image is not present in Home Page", Status.FAIL);
		}
		validate_Support_Custom_Links();
	}

	/**
	 * Validating the Welcome Links on the Home Page
	 * 
	 * @author Vishnuvardhan
	 *
	 */

	public void verify_Welcome_Links() {
		List<WebElement> welcomeLinks = driver.findElements(By.xpath("//div[@class='slds-p-around--medium']/a"));
		boolean salesforceTrainingLink = Utility_Functions.validateLinks(welcomeLinks,
				"Salesforce Training Videos/Tools");
		boolean myActivitylink = Utility_Functions.validateLinks(welcomeLinks, "My Activity List");
		if ((salesforceTrainingLink == true) && (myActivitylink == true)) {
			report.updateTestLog("Verify Home Page Welcome Links", "Welcome Links Salesforce Training Videos/ Tools and My Activity Links are present in the Home Page", Status.PASS);
		} else {
			report.updateTestLog("Verify Home Page Welcome Links", "Welcome Links are not present in the Home Page", Status.FAIL);
		}
	}

	/**
	 * Validating the Home Page Menu for Accounts tab
	 * 
	 * @author Vishnuvardhan
	 *
	 */

	public void validate_Menu_Accounts() {
		sf_UtilityFunctions.oneAppNavigationTab("Accounts");
		if (menu_Accounts.isDisplayed()) {
			report.updateTestLog("Verify Menu - Accounts", "Accounts menu is present in Home Page", Status.PASS);
		} else {
			report.updateTestLog("Verify Menu - Accounts", "Accounts menu is not present in Home Page",	Status.FAIL);
		}
		menu_Accounts.click();
		Utility_Functions.xWaitForElementPresent(driver, accounts_HomePage, 3);
		if (accounts_HomePage.isDisplayed()) {
			report.updateTestLog("Verify Accounts Home Page", "Accounts Home Page is displayed", Status.PASS);
		} else {
			report.updateTestLog("Verify Accounts Home Page", "Accounts Home Page didn't get displayed", Status.FAIL);
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
		if (menu_Opportunities.isDisplayed()) {
			report.updateTestLog("Verify Menu - Opportunities", "Opportunities menu is present in Home Page", Status.PASS);
		} else {
			report.updateTestLog("Verify Menu - Opportunities", "Opportunities menu is not present in Home Page", Status.FAIL);
		}
		sf_UtilityFunctions.oneAppNavigationTab("Opportunities");
		Utility_Functions.timeWait(3);
		if (opportunities_HomePage.isDisplayed()) {
			report.updateTestLog("Verify Opportunities Home Page", "Opportunities Home Page is displayed", Status.PASS);
		} else {
			report.updateTestLog("Verify Opportunities Home Page", "Opportunities Home Page didn't get displayed", Status.FAIL);
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
		if (menu_Leads.isDisplayed()) {
			report.updateTestLog("Verify Menu - Leads", "Leads menu is present in Home Page", Status.PASS);
		} else {
			report.updateTestLog("Verify Menu - Leads", "Leads menu is not present in Home Page", Status.FAIL);
		}
		sf_UtilityFunctions.oneAppNavigationTab("Leads");
		Utility_Functions.timeWait(1);
		if (leads_HomePage.isDisplayed()) {
			report.updateTestLog("Verify Leads Home Page", "Leads Home Page is displayed", Status.PASS);
		} else {
			report.updateTestLog("Verify Leads Home Page", "Leads Home Page didn't get displayed", Status.FAIL);
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
		list.add("Report a System Error");
		list.add("Submit Data Migration Request");
		list.add("Submit Acct Update Request");
		list.add("Submit Enhancement Request");
		list.add("My Open Salesforce Requests");
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
		Utility_Functions.timeWait(6);
		Utility_Functions.xWaitForElementPresent(driver, (driver.findElements(By.xpath("//b[text()='Support Links']/ancestor::h2/following-sibling::ul//a"))), 7);
		List<WebElement> homePageLinks = driver  
				.findElements(By.xpath("//b[text()='Support Links']/ancestor::h2/following-sibling::ul//a"));
		String[] linkTexts = new String[homePageLinks.size()];
		System.out.println(" Support links in page are :: "+linkTexts.length +" ::: "+ homePageLinks);

		Utility_Functions.timeWait(1);
		int i = 0, count = 0;
		for (WebElement element : homePageLinks) {
			linkTexts[i] = element.getText();
			System.out.println("Verify Link '" + linkTexts[i] + "' with the list :: " + list.get(i));

			if (linkTexts[i].equals(list.get(i))) {
				count++;
				System.out.println("Link " + linkTexts[i] + " matches " + "with the list ::" + list.get(i));
				report.updateTestLog("Verify Home Page Links", "Link " + linkTexts[i] + " present in Home Page:::", Status.PASS);
			}
			i++;
		}
		System.out.println(count);
		if (count == 7) {
			System.out.println("All the links are present in Home Page:::");
			report.updateTestLog("Verify Home Page Links", "All the links are present in Home Page:::", Status.PASS);
		} else {
			report.updateTestLog("Verify Home Page Links", "All the links are not present in Home Page:::", Status.FAIL);
		}
	}

	/**
	 * Validating the tabs on the Home Page for the SFDC Training link
	 * 
	 * @author Ramya
	 *
	 */

	public void validateHomePageSFDCTrainingLink() {
		Utility_Functions.timeWait(4);
		if (SFDCTrainingLink.isDisplayed()) {
			report.updateTestLog("Verify Home Page SFDC Training Link", "The SFDC Training Link is present", Status.PASS);
		} else {
			report.updateTestLog("Verify Home Page SFDC Training Link", "The SFDC Training Link is not present", Status.FAIL);
		}
	}
	
	/**
	 * Validating the tabs on Home Page for the APAC Capital Markets
	 * 
	 * @author Ramya
	 *
	 */

	static ArrayList<String> tabsList = new ArrayList<String>();

	public void homePageTabsList() {
		tabsList.add("CBRE Sales");
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
		System.out.println("The Home Page Tabs for the APAC Capital Markets are:::" + tabsList);
	}

	static ArrayList<String> moreTabsList = new ArrayList<String>();

	public void homePageMoreTabsList() {
		moreTabsList.add("Private Notes");
		moreTabsList.add("Properties");
		moreTabsList.add("Private Tags");
		moreTabsList.add("Bulk Tagging");
		moreTabsList.add("Campaigns");
		moreTabsList.add("Cases");
		moreTabsList.add("Offers");
		System.out.println("The Home Page more Tabs for the APAC Capital Markets are:::" + moreTabsList);
	}


	/**
	 * Validating the tabs on the Home Page for the APAC broker Capital Markets
	 * 
	 * @author Ramya
	 *
	 */

	public void validateHomePageTabsForAPACCapitalMarkets() {
		tabsList.clear();
		homePageTabsList();
		Utility_Functions.timeWait(2);
		if ((dataTable.getData("General_Data", "TC_ID").contains("CMAPACManagerHomeVerifyingTabsOnHomePage"))
				|| (dataTable.getData("General_Data", "TC_ID").contains("CMAPACBrokerHomeVerifyingTabsOnHomePage"))) {
			List<WebElement> homePageTabsList = driver
					.findElements(By.xpath("//div[contains(@class,'slds-context-bar')]//span[@class='slds-truncate']"));
			int i1 = 0, j = 0, countLabelList = 0;
			String[] labelTexts = new String[tabsList.size()];
			System.out.println("Number of Tabs found :"+homePageTabsList.size()+" , "+"  Number of TabNames in List :"+tabsList.size() );
			for (WebElement element : homePageTabsList) {
				labelTexts[i1] = element.getText();
				if (labelTexts[i1].contains(tabsList.get(j))) {
					System.out.println("Verify Home Page TabNames For APACCapitalMarkets" + element.getText());
					report.updateTestLog("Verify Home Page TabNames For APACCapitalMarkets",
							element.getText() + "::::label list is present in Home Page TabNames For APACCapitalMarkets", Status.PASS);
					countLabelList++;
				}
				if (countLabelList == 11)
					break;
				i1++;
				j++;
			}
			System.out.println("Home Page Tabs List Count:::" + countLabelList);
			if (countLabelList >= 11) {
				System.out.println("All the Tabs are present in Home Page ");
				report.updateTestLog("Verify Home Page Tabs", "All the Tabs are present in Home Page", Status.PASS);
			} else if (countLabelList < 11) {
				report.updateTestLog("Verify Home Page Tabs", "All the Tabs are not present in Home Page", Status.FAIL);
			}
			/*Utility_Functions.xWaitForElementPresent(driver, menu_More, 3);
			Utility_Functions.xClick(driver, menu_More, true);*/
			sf_UtilityFunctions.oneAppNavigationTab("More");
			List<WebElement> homePageMoreTabsList = driver.findElements(By.xpath("//one-tmp-menu-item[@class='slds-dropdown__item']//span/span"));
			moreTabsList.clear();
			homePageMoreTabsList();
			System.out.println("Number of More Tabs found ::::" + homePageMoreTabsList.size()+" , "+ "  Number of More TabNames in List :"+moreTabsList.size());
			int i2 = 0, j1 = 0, countLabelListMore = 0;
			String[] labelTextsMore = new String[moreTabsList.size()];
			for (WebElement element : homePageMoreTabsList) {
				labelTextsMore[i2] = element.getText();
				if (labelTextsMore[i2].contains(moreTabsList.get(j1))) {
					System.out.println("Verify Home Page TabNames For APACCapitalMarkets" + element.getText());
					report.updateTestLog("Verify Home Page TabNames For APACCapitalMarkets",
							element.getText() + "::::label list is present in Home Page TabNames For APACCapitalMarkets", Status.PASS);
					countLabelListMore++;
				}
				if (countLabelListMore == 7)
					break;
				i2++;
				j1++;
			}
			System.out.println("Home Page Tabs List Count:::" + countLabelListMore);
			if (countLabelListMore >= 7) {
				System.out.println("All the Tabs are present in Home Page ");
				report.updateTestLog("Verify Home Page Tabs", "All the Tabs are present in Home Page", Status.PASS);
			} else if (countLabelListMore < 7) {
				report.updateTestLog("Verify Home Page Tabs", "All the Tabs are not present in Home Page", Status.FAIL);
			}

		} 
		tabsList.clear();
		moreTabsList.clear();
	}

	/**
	 * Validating the tabs on the Home Page for the Account update
	 * 
	 * @author Ramya
	 *
	 */

	public void validateHomePageAccountUpdate() {
		Utility_Functions.timeWait(2);
		Utility_Functions.xWaitForElementPresent(driver, submitAccountUpdateRequest, 3);
		Utility_Functions.xClick(driver, submitAccountUpdateRequest, true);
		Utility_Functions.timeWait(2);
		Utility_Functions.xWaitForElementPresent(driver, requestedFor, 3);
		Utility_Functions.xClick(driver, requestedFor, true);
		sf_UtilityFunctions.selectObjectFromLookUpList("FirstElement");
		Utility_Functions.xScrollWindow(driver);
		Utility_Functions.timeWait(1);
		Utility_Functions.xScrollWindowTop(driver);
		Utility_Functions.timeWait(2);
		Utility_Functions.xWaitForElementPresent(driver, searchAccounts, 3);
		Utility_Functions.xClick(driver, searchAccounts, true);
		Utility_Functions.xScrollWindowToElement(driver, searchAccounts);
		try {
			sf_UtilityFunctions.selectObjectFromLookUpList("SecondElement");
			Utility_Functions.xWaitForElementPresent(driver, description, 3);
			Utility_Functions.xSendKeys(driver, description, "This is a sample description_" + Utility_Functions.xGenerateAlphaNumericString());
			Utility_Functions.xWaitForElementPresent(driver, regionField, 3);
			Utility_Functions.xClick(driver, regionField, true);
			Utility_Functions.xWaitForElementPresent(driver, region, 3);
			Utility_Functions.xClick(driver, region, true);
			Utility_Functions.xWaitForElementPresent(driver, saveCase, 3);
			Utility_Functions.xClick(driver, saveCase, true);
			report.updateTestLog("Verify Home Page Account Update", "Home Page AccountUpdate is done successfully", Status.PASS);
		} catch (Exception e) {
			e.printStackTrace();
			report.updateTestLog("Verify Home Page Account Update", "There are no accounts associated::", Status.PASS);
		}	
	}


	/**
	 * Validating the tabs on the Home Page for the Recent records
	 * 
	 * @author Ramya
	 *
	 */

	public void validateHomePageRecentRecords() {
		Utility_Functions.xWaitForElementPresent(driver, recentRecords, 3);
		if (recentRecords.isDisplayed()) {
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
		/*Utility_Functions.xWaitForElementPresent(driver, menu_More, 3);
		Utility_Functions.xClick(driver, menu_More, true);*/
		sf_UtilityFunctions.oneAppNavigationTab("More");
		report.updateTestLog("Verify Home Page Marketing Lists", "Verifying Menu_more is displayed on the home page",
				Status.PASS);
		Utility_Functions.timeWait(2);
		Utility_Functions.xWaitForElementPresent(driver, more_marketingListings, 3);
		Utility_Functions.xClick(driver, more_marketingListings, true);
		report.updateTestLog("Verify Offer Auto Populated By Project Enquiries",
				"Verifying Project Enquiries is displayed", Status.PASS);
		Utility_Functions.timeWait(2);
		Utility_Functions.xWaitForElementPresent(driver, newMarketingListings, 3);
		Utility_Functions.xClick(driver, newMarketingListings, true);
		report.updateTestLog("Verify Offer Auto Populated By Project Enquiries",
				"Verifying the new Project Enquiries is displayed", Status.PASS);
		Utility_Functions.timeWait(5);

	}

	/**
	 * Validating the Marketing Lists tab on the Home Page
	 * 
	 * @author Ramya
	 *
	 */

	public void validateHomePageTabs() {
		if ((dataTable.getData("General_Data", "TC_ID").contains("CMAPACBrokerJapanOpportunityCreation"))) {
			Utility_Functions.timeWait(2);
			Utility_Functions.xScrollWindow(driver);
			Utility_Functions.timeWait(1);
			Utility_Functions.xWaitForElementPresent(driver, nextForJapan, 4);
			Utility_Functions.xClick(driver, nextForJapan, true);
		}
		Utility_Functions.timeWait(5);
		List<WebElement> homePageTabs = driver
				.findElements(By.xpath("//div[contains(@class,'slds-context-bar')]//span[@class='slds-truncate']"));
		int count5 = 0, i5 = 0, j5 = 0;
		String fieldsArray5[] = new String[homePageTabs.size()];
		System.out.println(homePageTabs.size());
		tabsList.clear();
		try {
			homePageTabsList();
			while (j5 < homePageTabs.size()) {
				for (WebElement element5 : homePageTabs) {
					fieldsArray5[i5] = element5.getText();
					if (fieldsArray5[i5].equalsIgnoreCase(tabsList.get(j5))) {
						System.out.println("Verify Home Page Tabs " + element5.getText());
						report.updateTestLog("Verify Home Page Tabs",
								element5.getText() + "labels  present in the Home Page ", Status.PASS);
						count5++;
					}
					i5++;
				}
				i5 = 0;
				j5++;
			}
			System.out.println(count5);
			if (count5 >= 12) {
				report.updateTestLog("Verify Home Page Tabs", "All fields are not present in the Home Page",
						Status.FAIL);
			} else {
				report.updateTestLog("Verify Home Page Tabs", "All fields are present in the Home Page", Status.PASS);
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		tabsList.clear();
		Utility_Functions.xWaitForElementPresent(driver, menu_Opportunities, 4);
		Utility_Functions.xClick(driver, menu_Opportunities, true);
		Utility_Functions.xWaitForElementPresent(driver, newOpportunity, 3);
		Utility_Functions.xClick(driver, newOpportunity, true);
		Utility_Functions.timeWait(2);
		if ((dataTable.getData("General_Data", "TC_ID").contains("CMAPACBrokerJapanOpportunityCreation"))) {
			Utility_Functions.xSwitchtoFrame(driver, continueButton);
			Utility_Functions.timeWait(2);
			Utility_Functions.xWaitForElementPresent(driver, selectOpportunityRecordType, 3);
			Utility_Functions.xClick(driver, selectOpportunityRecordType, true);
			Utility_Functions.xWaitForElementPresent(driver, opportunityDSFValue, 3);
			Utility_Functions.xClick(driver, opportunityDSFValue, true);
			Utility_Functions.xWaitForElementPresent(driver, continueButton, 3);
			Utility_Functions.xClick(driver, continueButton, true);
			Utility_Functions.timeWait(2);
			driver.switchTo().defaultContent();
			Utility_Functions.timeWait(2);
		}
		Utility_Functions.xWaitForElementPresent(driver, accountNameNewOpportunity, 4);
		Utility_Functions.xSendKeys(driver, accountNameNewOpportunity, "Test Automation_0101");
		Utility_Functions.xWaitForElementPresent(driver, accountNameNewOpp, 3);
		Utility_Functions.xClick(driver, accountNameNewOpp, true);
		Utility_Functions.xWaitForElementPresent(driver, leadSourceNewOpp, 3);
		Utility_Functions.xClick(driver, leadSourceNewOpp, true);
		Utility_Functions.xWaitForElementPresent(driver, leadSourceNewOppValue, 3);
		Utility_Functions.xClick(driver, leadSourceNewOppValue, true);
		System.out.println(Calendar.getInstance());
		DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
		Date date = new Date();
		Utility_Functions.xWaitForElementPresent(driver, closeDate_AS, 3);
		Utility_Functions.xSendKeys(driver, closeDate_AS, dateFormat.format(date).toString());
		if ((dataTable.getData("General_Data", "TC_ID").contains("CMAPACBrokerJapanOpportunityCreation"))) {
			Utility_Functions.xWaitForElementPresent(driver, estiamtedGrossFeeCommissionValue, 3);
			Utility_Functions.xSendKeys(driver, estiamtedGrossFeeCommissionValue,
					dataTable.getData("General_Data", "InstallmentAmount"));
			Utility_Functions.xWaitForElementPresent(driver, estimatedTransactionValue, 3);
			Utility_Functions.xSendKeys(driver, estimatedTransactionValue,
					dataTable.getData("General_Data", "InstallmentAmount"));
		} else if ((dataTable.getData("General_Data", "TC_ID").contains("APACProjectManagerHomePageButtons"))) {
			Calendar calendar1 = Calendar.getInstance();
			calendar1.add(Calendar.DAY_OF_MONTH, -20);
			SimpleDateFormat dateFormat1 = new SimpleDateFormat("MM/dd/yyyy");
			System.out.println("Date : " + dateFormat1.format(calendar1.getTime()));
			Utility_Functions.xWaitForElementPresent(driver, assignmentStartDate, 3);
			Utility_Functions.xSendKeys(driver, assignmentStartDate, dateFormat1.format(calendar1.getTime()));
			Utility_Functions.xWaitForElementPresent(driver, opportunityCBREOffice, 3);
			Utility_Functions.xClick(driver, opportunityCBREOffice, true);
			Utility_Functions.xWaitForElementPresent(driver, opportunityCBREOfficeValue, 3);
			Utility_Functions.xClick(driver, opportunityCBREOfficeValue, true);
			Utility_Functions.xWaitForElementPresent(driver, opportunityCountry, 3);
			Utility_Functions.xClick(driver, opportunityCountry, true);
			Utility_Functions.xWaitForElementPresent(driver, opportunityCountryValue, 3);
			Utility_Functions.xClick(driver, opportunityCountryValue, true);
			Utility_Functions.xWaitForElementPresent(driver, opportunityCity, 3);
			Utility_Functions.xSendKeys(driver, opportunityCity, dataTable.getData("General_Data", "City"));
			Utility_Functions.xWaitForElementPresent(driver, assetType, 3);
			Utility_Functions.xClick(driver, assetType, true);
			Utility_Functions.xWaitForElementPresent(driver, assetTypeValue, 3);
			Utility_Functions.xClick(driver, assetTypeValue, true);
			Utility_Functions.xWaitForElementPresent(driver, cityTier, 3);
			Utility_Functions.xClick(driver, cityTier, true);
			Utility_Functions.xWaitForElementPresent(driver, cityTierValue, 3);
			Utility_Functions.xClick(driver, cityTierValue, true);
		}
		Utility_Functions.xWaitForElementPresent(driver, saveNewOpp, 3);
		Utility_Functions.xClick(driver, saveNewOpp, true);
		Utility_Functions.timeWait(3);
		if (details.isDisplayed()) {
			report.updateTestLog("Verify Home Page Tabs", "The opportunity is saved with the all the required fields",
					Status.PASS);
		} else {
			report.updateTestLog("Verify Home Page Tabs",
					"The opportunity is not saved with the all the required fields", Status.FAIL);
		}
	}
}