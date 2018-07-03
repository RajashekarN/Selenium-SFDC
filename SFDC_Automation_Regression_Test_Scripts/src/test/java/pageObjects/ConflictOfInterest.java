package pageObjects;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.cognizant.Craft.ReusableLibrary;
import com.cognizant.Craft.ScriptHelper;
import com.cognizant.framework.Status;
import com.sforce.soap.partner.SaveResult;
import pagesAPI.*;
import java.util.ArrayList;
import supportLibraries.SF_UtilityFunctions;
import supportLibraries.Utility_Functions;
/**
 * Page Object Class for Conflict Of Interest Page
 * 
 * @author Vishnuvardhan
 *
 */

public class ConflictOfInterest extends ReusableLibrary {
	/*
	 * Constructor to initialize the business component library
	 * 
	 * @param scriptHelper The {@link ScriptHelper} object passed from the
	 * {@link DriverScript}
	 */

	public ConflictOfInterest(ScriptHelper scriptHelper) {
		super(scriptHelper);
		PageFactory.initElements(driver.getWebDriver(), this);
	}

	/**
	 * Page Object Class for verify_Home_Page
	 * 
	 * @author Vishnuvardhan
	 *
	 */

	@FindBy(xpath = "//input[@title='Search Opportunities']")
	WebElement opportunitySearch;
	
	@FindBy(xpath = "//input[@title='Search Properties']")
	WebElement propertySearch;
	
	@FindBy(xpath = "//h2[text()='New CoI Check']/parent::div/parent::div/div[contains(@class,'modal-footer')]//span[text()='Save']")
	WebElement saveButtonNewCoICheck;
	
	@FindBy(xpath = "//div[contains(@class,'toastContent slds-notify__content')]//span[conains(@class,'toastMessage')]/a")
	WebElement saveToastMessage;
	
	@FindBy(xpath = "//span[contains(@class,'slds-form-element__label')]")
	List<WebElement> detailsLabels;
	
	@FindBy(xpath = "//h2[text()='Run Check']/parent::div/parent::div/div[contains(@class,'modal-footer')]//span[text()='Save']")
	WebElement saveButtonRunCheck;
	
	@FindBy(xpath = "//img[@title='COI Check Results']/parent::span/parent::div/parent::div/parent::header/parent::div/parent::article/div[@class='slds-card__body']//td[2]/span")
	WebElement status;
	

	OpportunitiesPage opportunitiesPage = new OpportunitiesPage(scriptHelper);
	SF_UtilityFunctions sf_UtilityFunctions = new SF_UtilityFunctions(scriptHelper);
	
	/**
	 * Function for validating the COI Outcome Flag 
	 * 
	 * @author Vishnuvardhan
	 *
	 */
	
	public void validateCoIOutcomeFlag() {
		PropertiesFunctions propertiesFunctions = new PropertiesFunctions(scriptHelper);
		AccountsFunctions accountsFunctions = new AccountsFunctions(scriptHelper);
		SaveResult[] saveResults = accountsFunctions.createAccount("EMEA_Sites");	
		EstablishConnection establishConnection = new EstablishConnection(scriptHelper);
		String sAccountID = establishConnection.saveResultsId(saveResults);
		sf_UtilityFunctions.oneAppNavigationTab("Accounts");
		sf_UtilityFunctions.selectExistingObjectRecord("Account Name");
		sf_UtilityFunctions.replaceURL("Account", sAccountID);		
		sf_UtilityFunctions.clickOnDetailAction("New CoI Check");
		OpportunitiesFunctions opportunitiesFunctions = new OpportunitiesFunctions(scriptHelper);
		String sOpportunityID = opportunitiesFunctions.createOpportunity(sAccountID);
		SearchTextSOQL searchTextSOQL = new SearchTextSOQL(scriptHelper); 
		String sQuery = "Select Name from Opportunity where Id = " + "'" + sOpportunityID + "'";
		String sOpportunityName = searchTextSOQL.fetchRecordFieldValue("Name", sQuery);
		String sPropertyID = propertiesFunctions.createProperty("170 Plashet Grove", "Amsterdam", "North Holland", "Netherlands", "1011");
		String sQueryProperty = "Select Name from Property__c where Id = " + "'" + sPropertyID + "'";
		String sPropertyName = searchTextSOQL.fetchRecordFieldValue("Name", sQueryProperty);
		Utility_Functions.xSendKeys(driver, opportunitySearch, sOpportunityName);
		sf_UtilityFunctions.selectObjectFromLookUpList(sOpportunityName);		
		Utility_Functions.timeWait(1);
		Utility_Functions.xSendKeys(driver, propertySearch, sPropertyName);
		sf_UtilityFunctions.selectObjectFromLookUpList(sPropertyName);		
		Utility_Functions.timeWait(1);
		Utility_Functions.xClick(driver, saveButtonNewCoICheck, true);
		Utility_Functions.timeWait(2);
		Utility_Functions.xWaitForElementPresent(driver, saveToastMessage, 5);
		String sCoICheck = saveToastMessage.getText();
		if(saveToastMessage.isDisplayed()) {			
			report.updateTestLog("Verify COI Check", "New CoI Check is saved " + sCoICheck + "successfully", Status.PASS);
		} else {
			report.updateTestLog("Verify COI Check", "New CoI Check save failed", Status.FAIL);
		}
		sf_UtilityFunctions.selectTabUIHeaders("Related");
		Utility_Functions.xScrollWindow(driver);
		Utility_Functions.timeWait(2);
		Utility_Functions.xClick(driver, saveToastMessage, true);		
		validateCoIPage();
		Utility_Functions.xWaitForElementPresent(driver, status, 5);
		report.updateTestLog("Verify COI Check Status", "CoI Check Status value is:::" + status.getText(), Status.PASS);
		sf_UtilityFunctions.clickOnDetailAction("Run Check");
		Utility_Functions.xClick(driver, saveButtonRunCheck, true);
		Utility_Functions.timeWait(2);
		driver.navigate().refresh();
		if(status.getText().equals("Submitted")) {
			report.updateTestLog("Verify COI Check", "Status is changed to " + status.getText() + "successfully", Status.PASS);
		} else {
			report.updateTestLog("Verify COI Check", "Status didn't get changed " + status.getText(), Status.FAIL);
		}
		Utility_Functions.timeWait(2000);
		driver.navigate().refresh();
		if(status.getText().equals("Processed")) {
			report.updateTestLog("Verify COI Check", "Status is changed to " + status.getText() + "successfully", Status.PASS);
		} else {
			report.updateTestLog("Verify COI Check", "Status didn't get changed " + status.getText(), Status.FAIL);
		}
		String sQueryStatus = "Select Outcome_Color__c  from Conflict_of_Interest_Check__c where  Outcome_Color__c =" +"'" + sCoICheck + "'";
		String sColor = searchTextSOQL.fetchRecordFieldValue("Outcome_Color__c", sQueryStatus);
		if(sColor.equals("Green")) {
			report.updateTestLog("Verify COI Check", "Status flag changed to green successfully" + sColor, Status.PASS);
		} else {
			report.updateTestLog("Verify COI Check", "Status didn't turn to green" + sColor, Status.FAIL);
		}
	}
	
	List<String> CoIPageLabels = new ArrayList<String>();
	
	public void CoIPageLabels() {
		CoIPageLabels.add("Account");
		CoIPageLabels.add("Owner");
		CoIPageLabels.add("Status");
		CoIPageLabels.add("Opportunity");
		CoIPageLabels.add("Check Run Date");
		CoIPageLabels.add("Created BY");
		CoIPageLabels.add("Last Modified By");
		System.out.println("CoI Check Page Lables list are:::"  + CoIPageLabels);
		report.updateTestLog("Verify COI Check Page Labels", "CoI Check Page Labels are:::" + CoIPageLabels, Status.PASS);
	}
	
	
	public void validateCoIPage() {
		CoIPageLabels();
		int count = Utility_Functions.xValidateFieldsPresentPage(CoIPageLabels, detailsLabels, "CoI Page Label");
		if(count==0) {
			report.updateTestLog("Verify COI Check Page Labels", "All the CoI Check Page Labels are present:::" + CoIPageLabels, Status.PASS);
		} else {
			report.updateTestLog("Verify COI Check Page Labels", "All the CoI Check Page Labels are not present:::" + CoIPageLabels, Status.FAIL);
		}
	}
	
}