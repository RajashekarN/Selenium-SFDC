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
		PageFactory.initElements(driver, this);
		// new WebDriverUtil(driver);
		utility = new Utility_Functions(scriptHelper);
	}

	@FindBy(xpath = "//div[@class='slds-context-bar oneGlobalNav']//span[text()='Accounts']")
	WebElement menu_Accounts;

	@FindBy(xpath = "//div[@class='slds-context-bar oneGlobalNav']//span[text()='Leads']")
	WebElement menu_Leads;

	@FindBy(xpath = "//div[@class='slds-context-bar oneGlobalNav']//span[text()='Opportunities']")
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
}
