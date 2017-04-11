package pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.cognizant.framework.Status;

import supportlibraries.ReusableLibrary;
import supportlibraries.ScriptHelper;
import supportlibraries.Utility_Functions;

public class homePage extends ReusableLibrary {
	/*
	 * Constructor to initialize the business component library
	 * 
	 * @param scriptHelper The {@link ScriptHelper} object passed from the
	 * {@link DriverScript}
	 */

	public homePage(ScriptHelper scriptHelper) {
		super(scriptHelper);
		PageFactory.initElements(driver, this);
		// new WebDriverUtil(driver);
		utility = new Utility_Functions(scriptHelper);
	}

	@FindBy(xpath = "//*[text()='Accounts']")
	WebElement menu_Accounts;

	@FindBy(xpath = "//*[text()='Leads']")
	WebElement menu_Leads;

	@FindBy(xpath = "//*[text()='Opportunities']")
	WebElement menu_Opportunities;

	@FindBy(xpath = ".//span[@class='uiOutputText'][text()='Accounts']")
	WebElement accounts_HomePage;

	@FindBy(xpath = ".//span[@class='uiOutputText'][text()='Opportunities']")
	WebElement opportunities_HomePage;

	@FindBy(xpath = ".//span[@class='uiOutputText'][text()='Leads']")
	WebElement leads_HomePage;

	@FindBy(xpath = ".//ul/li[@class='slds-list__item slds-p-bottom--xxx-small']")
	WebElement homePage_Links;

	@FindBy(xpath = ".//*[@id='header']/a/span")
	WebElement welcomeToSalesforce;

	@FindBy(xpath = ".//img[@src='http://i.imgur.com/6tmnCX3.png?1']")
	WebElement cbreImage;


	public void verify_Home_Page() {
		try {
			if(welcomeToSalesforce.isDisplayed()) {
				report.updateTestLog("Verify Home Page Links", "Welcome to Salesforce link is present in Home Page", Status.PASS);
			} else {
				report.updateTestLog("Verify Home Page Links", "Welcome to Salesforce link is not present in Home Page", Status.FAIL);
			}
			if(cbreImage.isDisplayed()) {
				report.updateTestLog("Verify Home Page Links", "CBRE image is present in Home Page", Status.PASS);
			} else {
				report.updateTestLog("Verify Home Page Links", "CBRE image is not present in Home Page", Status.FAIL);
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		validate_Support_Custom_Links();
		verify_Welcome_Links();
	
	}
	
	public void verify_Welcome_Links() {
		try {
			List <WebElement> welcomeLinks= driver.findElements(By.xpath(".//div[@class='slds-p-around--medium']/a"));
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
	
	public void validate_Menu_Accounts() {
		Utility_Functions.timeWait(4);
		try {
			if (menu_Accounts.isDisplayed()) {
				report.updateTestLog("Verify Menu - Accounts", "Accounts menu is present in Home Page", Status.PASS);
			} else {
				report.updateTestLog("Verify Menu - Accounts", "Accounts menu is not present in Home Page", Status.FAIL);
			}
			menu_Accounts.click();
			Utility_Functions.timeWait(1);
			if (accounts_HomePage.isDisplayed()) {
				report.updateTestLog("Verify Accounts Home Page", "Accounts Home Page is displayed", Status.PASS);
			} else {
				report.updateTestLog("Verify Accounts Home Page", "Accounts Home Page didn't get displayed", Status.FAIL);
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
		}
	}

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

	public void validate_Support_Custom_Links() {
		add_LinkstoList();
		List<WebElement> homePageLinks = driver
				.findElements(By.xpath(".//ul[@class='slds-list--vertical slds-has-inline-block-links']/li/a"));
		String[] linkTexts = new String[homePageLinks.size()];
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
			if (count == 11) {
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
}
