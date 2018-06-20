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

import supportLibraries.SF_UtilityFunctions;
import supportLibraries.Utility_Functions;

/**
 * Page Object Class for Opportunities Page
 * 
 * @author Vishnuvardhan
 *
 */

public class OpportunitySplit extends ReusableLibrary {
	/*
	 * Constructor to initialize the business component library
	 * 
	 * @param scriptHelper The {@link ScriptHelper} object passed from the
	 * {@link DriverScript}
	 */

	public OpportunitySplit(ScriptHelper scriptHelper) {
		super(scriptHelper);
		PageFactory.initElements(driver.getWebDriver(), this);
	}
	
	
	/**
	*Validating the manage Opportunity split functionality
	*
	*@author Vishnuvardhan
	*/

	@FindBy(xpath = "//span[text()='Estimated Gross Fee/Commission']/parent::span//input")
	WebElement estimatedGrossFeeField;
	
	@FindBy(xpath = "//div[contains(@class,'slds-page-header')]//input[@value='Save']")
	WebElement saveOpportunity;	

	@FindBy(xpath = "//button[text()='Add']")
	WebElement addButtonshareOpportunity;

	@FindBy(xpath = "//tr[contains(@class,'parent')][1]//input[contains(@id,'acctSearchBox')]")
	WebElement user1;

	@FindBy(xpath = "//select[@class='slds-select']/option[@value='Team Member']")
	WebElement selectTeamRole;

	@FindBy(xpath = "//select[@class='slds-select']/option[@value='Originating Broker']")
	WebElement selectSecondaryMemberRole;

	@FindBy(xpath = "//select[@class='slds-select']/option[@value='Edit']")
	WebElement selectOpportunityAccess;

	@FindBy(xpath = "//tr[contains(@class,'parent')][2]//input[contains(@id,'acctSearchBox')]")
	WebElement user2;

	@FindBy(xpath = "//table[@class='slds-table slds-no-row-hover']//tr[2]/td[3]//option[@value='Revenue Partner']")
	WebElement selectTeamRole2;

	@FindBy(xpath = "//table[@class='slds-table slds-no-row-hover']//tr[2]/td[4]//option[@value='Receiving Broker']")
	WebElement selectSecondaryMemberRole2;

	@FindBy(xpath = "//input[@value= 'Save']")
	WebElement saveButtonSplit;

	@FindBy(xpath = "//div[contains(@class, 'slds-truncate') and text()='Manage Opportunity Splits']")
	WebElement manageOpportunitySplits;

	@FindBy(xpath = "//button[text()='Save']")
	WebElement saveOpportunitySplit;

	@FindBy(xpath = "//input[@value='Save']")
	WebElement saveOpportunitySplitUAT;
	
	@FindBy(xpath = "//td[contains(@data-label,'Split Percent')]//input")
	WebElement splitPercent;

	
	OpportunitiesPage opportunitiesPage =new OpportunitiesPage(scriptHelper);
	SF_UtilityFunctions sf_UtilityFunctions = new SF_UtilityFunctions(scriptHelper);
	
	/**
	 * Validating the Opportunity record type for the Capital Markets
	 * 
	 * @author Ramya
	 *
	 */
	
	/**
	 * Validating the manage Opportunity split functionality
	 * 
	 * @author Ramya
	 *
	 */
	public void opportunitySplitFunctionality() {
		opportunitiesPage.selectOpportunity();
		OpportunitiesInstallments opportunitiesInstallments = new OpportunitiesInstallments(scriptHelper);
		opportunitiesInstallments.retriveOpportunityforInstallments();
		sf_UtilityFunctions.clickOnDetailAction("Edit");
		Utility_Functions.timeWait(2);
		Utility_Functions.xSwitchtoFrame(driver, estimatedGrossFeeField);
		Utility_Functions.timeWait(2);
		Utility_Functions.xClick(driver, estimatedGrossFeeField, true);
		Utility_Functions.timeWait(2);
		Utility_Functions.xSendKeys(driver, estimatedGrossFeeField, "10,000.00");	
		Utility_Functions.timeWait(2);
		Utility_Functions.xClick(driver, saveOpportunity, true);		
		Utility_Functions.timeWait(4);
		sf_UtilityFunctions.selectTabUIHeaders("Related");
		Utility_Functions.xClick(driver, addButtonshareOpportunity, true);
		Utility_Functions.xSwitchtoFrame(driver, saveButtonSplit);
		Utility_Functions.timeWait(2);
		List<WebElement> opportunityList = driver.findElements(By.xpath("//tr[@class='slds-text-heading--label']//div"));
		int count = 0;
		System.out.println(opportunityList.size());
		try {
			for (WebElement element : opportunityList) {

				if ((count == 0) && (element.getText().equals("USER"))) {
					System.out.println("USER  field is present in the Add New Team Member Page");
					report.updateTestLog("Add New Team Member Page",
							"Add New Team Member Page is having the " + element.getText() + " Status field::",
							Status.PASS);
					count++;
				} else if ((count == 1) && (element.getText().equals("TEAM MEMBER DESCRIPTION"))) {
					System.out.println("Team Member Description field is present in the Add New Team Member Page");
					report.updateTestLog("Add New Team Member Page",
							"Add New Team Member Page is having the " + element.getText() + " Status field::",
							Status.PASS);
					count++;
				} else if ((count == 2) && (element.getText().equals("TEAM ROLE"))) {
					System.out.println("TEAM ROLE field is present in the Add New Team Member Page");
					report.updateTestLog("Add New Team Member Page",
							"Add New Team Member Page is having the " + element.getText() + " Status field::",
							Status.PASS);
					count++;
				} else if ((count == 3) && (element.getText().equals("SECONDARY MEMBER ROLE"))) {
					System.out.println("SECONDARY MEMBER ROLE field is present in the Add New Team Member Page");
					report.updateTestLog("Add New Team Member Page",
							"Add New Team Member Page is having the " + element.getText() + " Status field::",
							Status.PASS);
					count++;
				} else if ((count == 4) && (element.getText().equals("OPPORTUNITY ACCESS"))) {
					System.out.println("OPPORTUNITY ACCESS field is present in the Add New Team Member Page");
					report.updateTestLog("Add New Team Member Page",
							"Add New Team Member Page is having the " + element.getText() + " Status field::",
							Status.PASS);

				}
			}
			if (count != 4)
				report.updateTestLog("Add New Team Member Page",
						"Add New Team Member Page is not having all the fields::", Status.FAIL);
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
		}
		Utility_Functions.timeWait(2);
		Utility_Functions.xSendKeys(driver, user1, "Inactive User");
		Utility_Functions.timeWait(1);
		user1.sendKeys(Keys.ARROW_DOWN);
		user1.sendKeys(Keys.ENTER);
		Utility_Functions.xClick(driver, selectTeamRole, true);
		Utility_Functions.timeWait(3);
		Utility_Functions.xClick(driver, selectSecondaryMemberRole, true);
		Utility_Functions.timeWait(3);
		Utility_Functions.xClick(driver, selectOpportunityAccess, true);
		Utility_Functions.timeWait(3);
		Utility_Functions.xSendKeys(driver, user2, "Test Broker1");
		Utility_Functions.timeWait(2);
		user2.sendKeys(Keys.ARROW_DOWN);
		user2.sendKeys(Keys.ENTER);
		Utility_Functions.xClick(driver, selectTeamRole2, true);
		Utility_Functions.timeWait(3);
		Utility_Functions.xClick(driver, selectSecondaryMemberRole2, true);
		Utility_Functions.timeWait(3);
		Utility_Functions.xClick(driver, saveButtonSplit, true);
		Utility_Functions.timeWait(3);
		driver.navigate().refresh();
		Utility_Functions.timeWait(1);
		driver.switchTo().defaultContent();
		driver.navigate().refresh();
		Utility_Functions.xWaitForElementVisible(driver, manageOpportunitySplits, 3);
		Utility_Functions.xClick(driver, manageOpportunitySplits, true);
		Utility_Functions.timeWait(4);
		driver.switchTo().frame(driver.findElement(By.xpath("//iframe")));
		splitPercent.clear();
		Utility_Functions.timeWait(3);
		splitPercent.sendKeys("100");
		try {
			Utility_Functions.xClick(driver, saveOpportunitySplit, true);
		} catch (Exception e) {
			Utility_Functions.xClick(driver, saveOpportunitySplitUAT, true);
		}
		report.updateTestLog("Opportunity Saved", "Opportunity Saved successfully::", Status.PASS);
	}
}
