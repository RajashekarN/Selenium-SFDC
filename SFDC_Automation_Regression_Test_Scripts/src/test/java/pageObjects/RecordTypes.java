package pageObjects;

import java.util.ArrayList;
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

/**
 * Page Object Class for selection record types dynamically
 * 
 * @author Vishnuvardhan
 *
 */

public class RecordTypes extends ReusableLibrary {
	/*
	 * Constructor to initialize the business component library
	 * 
	 * @param scriptHelper The {@link ScriptHelper} object passed from the
	 * {@link DriverScript}
	 */
	public RecordTypes(ScriptHelper scriptHelper) {
		super(scriptHelper);
		PageFactory.initElements(driver.getWebDriver(), this);
	}
	
	@FindBy(xpath = "//button[text()='Continue']")
	WebElement continueButton;

    @FindBy(xpath = "//input[@id='acctSearchBox']")
	WebElement accountName;
    
	@FindBy(xpath = "//*[@id='record-type-select']")
	WebElement opportunityRecordType;
	
	/**
	 * Page Object Class for Opportunity Record Types
	 * 
	 * @author Vishnuvardhan
	 *
	 */
	
	static List<String> opportunityRecordTypes = new ArrayList<String>();
	
	public void opportunityRecordTypesList() {
		opportunityRecordTypes.add("Agency Brokerage");
		opportunityRecordTypes.add("APAC Advisory/Consulting Services and GWS");
		opportunityRecordTypes.add("APAC Capital Markets – Debt & Structured Finance");
		opportunityRecordTypes.add("APAC Debt & Structured Finance");
		opportunityRecordTypes.add("APAC Investors/Buyers");
		opportunityRecordTypes.add("APAC Landlord and Sale Pursuits");
		opportunityRecordTypes.add("APAC Landlord Deal");
		opportunityRecordTypes.add("APAC Landlord Listing");
		opportunityRecordTypes.add("APAC Occupier");
		opportunityRecordTypes.add("APAC Project Management");	
		opportunityRecordTypes.add("APAC Property Sales - Buy Side");
		opportunityRecordTypes.add("APAC Property Sales - Sell Side");
		opportunityRecordTypes.add("APAC Valuations");
		opportunityRecordTypes.add("APAC Valuations & Consulting Services");
		opportunityRecordTypes.add("Asset Services");	
		opportunityRecordTypes.add("Capital Markets – Debt & Structured Finance");
		opportunityRecordTypes.add("Capital Markets – Property Sales");
		opportunityRecordTypes.add("EMEA A&T Investor");
		opportunityRecordTypes.add("EMEA A&T Occupier");
		opportunityRecordTypes.add("EMEA BC&P");	
		opportunityRecordTypes.add("EMEA Capital Markets Capital Advisors");
		opportunityRecordTypes.add("EMEA Capital Markets Investment Properties");
		opportunityRecordTypes.add("EMEA Development");
		opportunityRecordTypes.add("EMEA Regional Business");
		opportunityRecordTypes.add("EMEA Valuations");	
		opportunityRecordTypes.add("France Consulting & Service");
		opportunityRecordTypes.add("France Investor Relations");
		opportunityRecordTypes.add("France Transaction Demand Agency");
		opportunityRecordTypes.add("France Transaction Offer Agency");
		opportunityRecordTypes.add("GIA");	
		opportunityRecordTypes.add("Global Workplace Solutions");
		opportunityRecordTypes.add("Occupier Brokerage");
		opportunityRecordTypes.add("Valuations & Advisory Services");
		System.out.println("Record Types for Opportunity available are::" + opportunityRecordTypes);
	}
	
	public void selectOpportunityRecordType(String recordType) {
		By recordTypeSelected = By.xpath("//*[@id='record-type-select']/option[text()='"+recordType+"']");
		opportunityRecordTypesList();
		Utility_Functions.timeWait(2);
		Utility_Functions.xSwitchtoFrame(driver, continueButton);
		Utility_Functions.xWaitForElementPresent(driver, continueButton, 3);		
		for(int i=0; i < opportunityRecordTypes.size(); i++) {
			if(opportunityRecordTypes.get(i).equals(recordType)) {
				Utility_Functions.xClick(driver, opportunityRecordType, true);
				Utility_Functions.xWaitForElementPresent(driver, recordTypeSelected, 2);
				Utility_Functions.xClick(driver, driver.findElement(recordTypeSelected), true);
				System.out.println("Record Type selected is:" + opportunityRecordTypes.get(i));
				report.updateTestLog("Record Type", "Selected record type is:::" + opportunityRecordTypes.get(i), Status.PASS);
				break;
			}			
		}
		Utility_Functions.xClick(driver, continueButton, true);
		driver.switchTo().defaultContent();
		Utility_Functions.xSwitchtoFrame(driver, accountName);		
		Utility_Functions.timeWait(2);
	}
	

	/**
	 * Retrive Opportunity Record Id 
	 * 
	 * @author Vishnuvardhan
	 *
	 */
	
	public String retriveOppRecordID(String RecordTypeName) {
		opportunityRecordTypesList();
		String sRecordID = null;
		for(int i=0; i < opportunityRecordTypes.size(); i++) {
			if(opportunityRecordTypes.get(i).equals(RecordTypeName)) {				
				String sQuery = "Select Id from RecordType where Name = " + "'" + RecordTypeName + "'";
				sRecordID = new SearchTextSOQL(scriptHelper).fetchRecordFieldValue("Id", sQuery);
				break;
			}		
		}
		return sRecordID;
	}	
	
	
	/**
	 * Page Object Class for Account Record Types
	 * 
	 * @author Vishnuvardhan
	 *
	 */
	
	static List<String> accountRecordTypes = new ArrayList<String>();
	
	public void AccountRecordTypes() {
		accountRecordTypes.add("CBRE Account");
		accountRecordTypes.add("EMEA Reporting Account");
		accountRecordTypes.add("EMEA Sites");
		System.out.println("Record Types for Accounts available are::" + opportunityRecordTypes);
	}
	
	public void selectAccountRecordType(String recordType) {
		
	}
	
}
