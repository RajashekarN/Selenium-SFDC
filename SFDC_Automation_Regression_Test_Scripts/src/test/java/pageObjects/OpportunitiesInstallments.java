package pageObjects;

import java.math.BigDecimal;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Random;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.cognizant.Craft.ReusableLibrary;
import com.cognizant.Craft.ScriptHelper;
import com.cognizant.framework.Status;
import com.sforce.soap.partner.SaveResult;
import com.sforce.soap.partner.sobject.SObject;
import pagesAPI.EstablishConnection;
import pagesAPI.OpportunitiesFunctions;
import pagesAPI.SearchTextSOQL;
import supportLibraries.SF_UtilityFunctions;
import supportLibraries.Utility_Functions;

/**
 * Page Object Class for Opportunities Page
 * 
 * @author Vishnuvardhan
 *
 */

public class OpportunitiesInstallments extends ReusableLibrary {
	/*
	 * Constructor to initialize the business component library
	 * 
	 * @param scriptHelper The {@link ScriptHelper} object passed from the
	 * {@link DriverScript}
	 */

	public OpportunitiesInstallments(ScriptHelper scriptHelper) {
		super(scriptHelper);
		PageFactory.initElements(driver.getWebDriver(), this);
	}
	
	/**
	 * Page Objects for Opportunity Installment test cases 
	 * 
	 * @author Vishnuvardhan
	 *
	 */
	
	@FindBy(xpath = "//li[contains(@class,'oneActionsDropDown')]//a")
	WebElement showMoreActions;

	@FindBy(xpath = "//a[contains(@title,'Recalculate')]")
	WebElement recalculate;

	@FindBy(xpath = "//input[contains(@id,'opportunityRefractorPageLightningForm') and contains(@id,'Quantity')]")
	WebElement installmentQuantity;

	@FindBy(xpath = "//*[@id='Page:opportunityRefractorPageLightningForm:slds-Amount']")
	WebElement InstallmentAmountEdit;
	
	@FindBy(xpath = "//*[@id='Page:opportunityRefractorPageLightningForm:saveButton']")
	WebElement proceed;

	@FindBy(xpath = "//*[@id='Page:opportunityRefractorPageLightningForm:ContinueButton']")
	WebElement continueButtonInstallment;
	
	@FindBy(xpath = "//table[contains(@class,'forceRecordLayout')]//span[contains(@class,'forceOutputCurrency')]")
	WebElement installmentAmount;
	
	@FindBy(xpath = "//span[text()='Estimated Gross Fee/Commission']/parent::label/following-sibling::input")
	WebElement estimatedGrossFeeEdit;
	
	@FindBy(css = ".modal-footer [title='Save']")
	WebElement save;
	
	@FindBy(xpath = "//h2[text()='Quick Create: Agency Brokerage']")
	WebElement agencyBrokerageFrame;
	
	@FindBy(xpath = "//span[contains(text(),'Commission')]/parent::span//input")
	WebElement estimatedGrossFee;
	
	@FindBy(xpath = "//div[@class='slds-media']//input[@value='Save']")
	WebElement saveButton_AB;

	@FindBy(xpath = "//span[contains(text(),'Preferred')][contains(text(),'Property')]/parent::div//select")
	WebElement preferredPropertyTypeOpp;
	
	@FindBy(xpath = "//span[text()='Opportunity Installments']/parent::span[text()='View All']")
	WebElement installmentsViewAll;

	@FindBy(xpath = "//nav[@role='navigation']/ol[contains(@class,'slds-breadcrumb')]/li[2]")
	WebElement opportunityNameLink;

	@FindBy(xpath = "//table[contains(@class,'forceRecordLayout')]//tr[1]//span[contains(@class,'forceOutputCurrency')]")
	WebElement installmentAmountOne;

	@FindBy(xpath = "//table[contains(@class,'forceRecordLayout')]//tr[2]//span[contains(@class,'forceOutputCurrency')]")
	WebElement installmentAmountTwo;
	
	@FindBy(xpath = "//table[contains(@class,'forceRecordLayout')]//tr[3]//span[contains(@class,'forceOutputCurrency')]")
	WebElement installmentAmountThree;
	
	@FindBy(xpath = "//div[contains(@class,'actionsContainer')]//div[text()='Edit']")
	WebElement editButtonInstallment;
	
	@FindBy(xpath = "//a[contains(@title,'New') and contains(@title,'Installment')]")
	WebElement newOpportunityInstallment;
	
	@FindBy(xpath = "//div[@class='slds-form-element__control']//span[text()='Installment Number']/parent::label/parent::div/input")
	WebElement installmentNumber;

	@FindBy(xpath = "//div[@class='slds-form-element__control']//span[text()='Installment Amount']/parent::label/parent::div/input")
	WebElement editInstallmentAmount;
	
	@FindBy(xpath = "//div[@class='slds-form-element__control']//span[text()='Installment Date']/parent::label/parent::div/div/input")
	WebElement installmentDate;

	@FindBy(xpath = "//div[contains(@class,'modal-footer')]//span[text()='Save']")
	WebElement saveNewOpportunityInstallment;
	
	@FindBy(xpath = "//span[@class='uiOutputNumber'][text()='1']/ancestor::tr//div[contains(@class,'forceVirtualActionMarker')]//a")
	WebElement arrowDown;
	
	@FindBy(xpath = "//a[@role='menuitem'][@title='Edit']")
	WebElement editBtn;
	
	@FindBy(xpath = "//span[text()='Installment Status']/parent::span/parent::div//a")
	WebElement installmentOption;

	@FindBy(xpath = "//div[@class='select-options']/ul/li[contains(@class,'uiMenuItem') and contains(@class,'uiRadioMenuItem')]/a[@title='Paid']")
	WebElement installmentStatus;

	@FindBy(xpath = "//span[text()='Date Paid']/parent::label/parent::div//input")
	WebElement datePaid;

	@FindBy(xpath = "//span[text()='Account Role']/parent::span/parent::div//a")
	WebElement accountRoleOption;

	@FindBy(xpath = "//div[@class='select-options']/ul/li[contains(@class,'uiMenuItem') and contains(@class,'uiRadioMenuItem')]/a[@title='Developer']")
	WebElement accountRole;
	
	@FindBy(css = ".modal-footer [title='Cancel']")
	WebElement cancel;

	@FindBy(xpath = "//a[@class='tabHeader']//span[text()='Related']")
	WebElement related;
	
	@FindBy(xpath = "//span[text()='Installment Amount']/parent::label/parent::div//input")
	WebElement installmentAmountEdit;

	@FindBy(xpath = "//li[contains(@class,'slds-button slds-button--neutral slds-truncate')]//a[@class='forceActionLink']/div[@class='slds-truncate'][text()='Edit']")
	WebElement editButton;
	
	OpportunitiesPage opportunitiesPage = new OpportunitiesPage(scriptHelper);
	SearchTextSOQL searchTextSOQL = new SearchTextSOQL(scriptHelper);
	SF_UtilityFunctions sf_UtilityFunctions = new SF_UtilityFunctions(scriptHelper);
	OpportunitiesFunctions opportunitiesFunctions = new OpportunitiesFunctions(scriptHelper);
	int offsetValue = new Random().nextInt(9);
	Actions actions = new Actions(driver.getWebDriver());
	
	/**
	 * Function for retrieve Opportunity for Installments scenarios
	 * 
	 * @author Vishnuvardhan
	 *
	 */
	
	public String retriveOpportunityforInstallments() {
		String query = "SELECT Id, Installment_Quantity__c, CBRE_Preferred_Property_Type_c__c, Total_Size__c, Service__c  FROM"
				+ " Opportunity where Installment_Quantity__c = 1 and  CBRE_Preferred_Property_Type_c__c !=null and"
				+ " Total_Size__c != null and Service__c  != null ORDER BY CreatedDate DESC"  + " limit 1 offset " + offsetValue;
		
		if(dataTable.getData("General_Data","TC_ID").contains("Split")) {
			query = "SELECT Id, CBRE_Preferred_Property_Type_c__c, Total_Size__c, Service__c  FROM"
				+ " Opportunity where CBRE_Preferred_Property_Type_c__c !=null and"
				+ " Total_Size__c != null and Service__c  != null ORDER BY CreatedDate DESC"  + " limit 1 offset " + offsetValue;
		}
		String sOpportunityId = searchTextSOQL.fetchRecordFieldValue("Id", query);
		opportunitiesFunctions.updateOpportunityField("CBRE_Preferred_Property_Type_c__c", sOpportunityId);
		if(sOpportunityId==null) {
			report.updateTestLog("Verify Active Opportunities", "No Opportunities are present:::", Status.PASS);
		} else {
			report.updateTestLog("Verify Active Opportunities", "Opportunity ID retrived from database is:::" + sOpportunityId, Status.PASS);
			String url = driver.getCurrentUrl().split("Opportunity/")[0];
			String newUrl = url + "Opportunity/" +sOpportunityId;
			newUrl = newUrl + "/view";
			driver.get(newUrl);
			Utility_Functions.timeWait(1);
	}
	return sOpportunityId;
	}
	
	/**
	 * Function for adding the Installments 
	 * 
	 * @author Vishnuvardhan
	 *
	 */
	
	
	public void addingInstallmentsAmount() {
		opportunitiesPage.selectOpportunity();
		Utility_Functions.xWaitForElementPresent(driver, showMoreActions, 4);
		Utility_Functions.xClick(driver, showMoreActions, true);
		Utility_Functions.xWaitForElementPresent(driver, recalculate, 2);
		Utility_Functions.xClick(driver, recalculate, true);		
		Utility_Functions.timeWait(4);
		Utility_Functions.xSwitchtoFrame(driver, installmentQuantity);
		Utility_Functions.xWaitForElementPresent(driver, installmentQuantity, 3);
		InstallmentAmountEdit.clear();
		Utility_Functions.xSendKeys(driver, InstallmentAmountEdit, "50000");
		Utility_Functions.xWaitForElementPresent(driver, proceed, 3);
		Utility_Functions.xClick(driver, proceed, true);
		Utility_Functions.xWaitForElementPresent(driver, continueButtonInstallment, 3);
		Utility_Functions.xClick(driver, continueButtonInstallment, true);
		driver.switchTo().defaultContent();
		Utility_Functions.timeWait(2);
	}

	/**
	 * Function for multiple installments
	 * 
	 * @author Vishnuvardhan
	 *
	 */

	public void multipleInstallmentsFunction() {
		opportunitiesPage.selectOpportunity();
		String oppportunityID = retriveOpportunityforInstallments();
		if (oppportunityID == null) {
			report.updateTestLog("Opportunity Installments", "There are no Opportunities present with the provided criteria:::", Status.PASS);
		} else {
			Utility_Functions.timeWait(4);
			Utility_Functions.xWaitForElementPresent(driver, editButton, 3);
			sf_UtilityFunctions.selectTabUIHeaders("Related");
			Utility_Functions.timeWait(4);
			Utility_Functions.xWaitForElementPresent(driver, installmentAmount, 4);
			String sInstallmentAmount = installmentAmount.getText();
			sInstallmentAmount = sInstallmentAmount.split(" ")[1];
			if (sInstallmentAmount.equals((dataTable.getData("General_Data", "InstallmentAmount") + ".00"))) {
					report.updateTestLog("Opportunities Installments",
						"Opportunity installment amount record is present in the opportunity installment related list:::",
						Status.PASS);
			} else {
				report.updateTestLog("Opportunities Installments",
						"Opportunity installment amount record is present in the opportunity installment related list:::",
						Status.WARNING);
			}
			Utility_Functions.timeWait(2);
			}
	}

	/**
	 * Verify editing of multiple Installments functions for Opportunity based on Even Percent Occupier Brokerage
	 * 
	 * @author Vishnuvardhan
	 *
	 */

	public void occupierBrokerage() {
		Utility_Functions.xScrollWindow(driver);
		Utility_Functions.timeWait(1);
		Utility_Functions.xScrollWindowTop(driver);
		Utility_Functions.timeWait(2);
		Utility_Functions.xWaitForElementPresent(driver, estimatedGrossFeeEdit, 3);
		estimatedGrossFeeEdit.clear();
		if ((dataTable.getData("General_Data", "TC_ID").contains("MultipleInstallmentsEven"))
				|| (dataTable.getData("General_Data", "TC_ID").contains("EstimatedGrossFeeCommission"))
				|| (dataTable.getData("General_Data", "TC_ID").contains("InLineEditEvenPercent"))) {
			Utility_Functions.xSendKeys(driver, estimatedGrossFeeEdit, "20,000");
			report.updateTestLog("Opportunities Installments",
					"Opportunity installment entered as 20,000 successfully:::", Status.PASS);
		} else if ((dataTable.getData("General_Data", "TC_ID").contains("MultipleInstallmentsUnEven"))
				|| (dataTable.getData("General_Data", "TC_ID").contains("InLineEditUnEvenPercent"))) {
			Utility_Functions.xSendKeys(driver, estimatedGrossFeeEdit, "6,000");
			report.updateTestLog("Opportunities Installments",
					"Opportunity installment entered as 6,000 successfully:::", Status.PASS);
		}
		Utility_Functions.timeWait(3);
		Utility_Functions.xWaitForElementPresent(driver, save, 4);
		Utility_Functions.xHighlight(driver, save, "yellow");
		actions.moveToElement(save).click().perform();
		Utility_Functions.timeWait(4);
	}

	/**
	 * Verify editing of multiple Installments functions for Opportunity based on Even Percent Agency Brokerage
	 * 
	 * @author Vishnuvardhan
	 *
	 */

	public void agencyBrokerage() {
		//driver.navigate().refresh();
		Utility_Functions.xSwitchtoFrame(driver, agencyBrokerageFrame);
		Utility_Functions.timeWait(2);
		Utility_Functions.xScrollWindow(driver);
		Utility_Functions.timeWait(1);
		Utility_Functions.xScrollWindowTop(driver);
		Utility_Functions.timeWait(2);
		Utility_Functions.xWaitForElementPresent(driver, estimatedGrossFee, 3);
		estimatedGrossFee.clear();
		if ((dataTable.getData("General_Data", "TC_ID").contains("MultipleInstallmentsEven"))
				|| (dataTable.getData("General_Data", "TC_ID").contains("EstimatedGrossFeeCommission"))
				|| (dataTable.getData("General_Data", "TC_ID").contains("InLineEditEvenPercent"))) {
			Utility_Functions.xSendKeys(driver, estimatedGrossFee, "20,000");
			report.updateTestLog("Opportunities Installments",
					"Opportunity installment entered as 20,000 successfully:::", Status.PASS);
		} else if ((dataTable.getData("General_Data", "TC_ID").contains("MultipleInstallmentsUnEven"))
				|| (dataTable.getData("General_Data", "TC_ID").contains("InLineEditUnEvenPercent"))) {
			Utility_Functions.xSendKeys(driver, estimatedGrossFee, "6,000");
			report.updateTestLog("Opportunities Installments",
					"Opportunity installment entered as 6,000 successfully:::", Status.PASS);
		}
		Utility_Functions.timeWait(3);
		Utility_Functions.xWaitForElementPresent(driver, saveButton_AB, 3);
		Utility_Functions.xClick(driver, saveButton_AB, true);
		Utility_Functions.timeWait(1);
		driver.switchTo().defaultContent();
		Utility_Functions.timeWait(2);
	}

	/**
	 * Function for adding the installments for Opportunities
	 * 
	 * @author Vishnuvardhan
	 *
	 */

	public void addingInstallmentsOpportunities() {
		Utility_Functions.timeWait(1);
		Utility_Functions.xWaitForElementPresent(driver, showMoreActions, 4);
		Utility_Functions.xClick(driver, showMoreActions, true);
		Utility_Functions.timeWait(1);
		Utility_Functions.xWaitForElementPresent(driver, recalculate, 2);
		Utility_Functions.xClick(driver, recalculate, true);
		Utility_Functions.timeWait(4);
		Utility_Functions.xSwitchtoFrame(driver, installmentQuantity);
		Utility_Functions.xWaitForElementPresent(driver, installmentQuantity, 3);
		installmentQuantity.clear();
		Utility_Functions.xSendKeys(driver, installmentQuantity, "4");
		InstallmentAmountEdit.clear();
		Utility_Functions.xSendKeys(driver, InstallmentAmountEdit, "50000");
		Utility_Functions.xWaitForElementPresent(driver, proceed, 3);
		Utility_Functions.xClick(driver, proceed, true);
		try {
			Utility_Functions.xSelectDropdownByIndex(preferredPropertyTypeOpp, 1);
			Utility_Functions.xWaitForElementPresent(driver, continueButtonInstallment, 3);
			Utility_Functions.xClick(driver, continueButtonInstallment, true);
		} catch (Exception e) {
			Utility_Functions.xWaitForElementPresent(driver, continueButtonInstallment, 3);
			Utility_Functions.xClick(driver, continueButtonInstallment, true);
		}		
		driver.switchTo().defaultContent();
		Utility_Functions.timeWait(2);
	}

	/**
	 * Verify editing of multiple Installments from Opportunity based on Even
	 * Percent
	 * 
	 * @author Vishnuvardhan
	 *
	 */

	public void multipleInstallmentsOpportunityEvenPercent() {
		multipleInstallmentsFunction();
		addingInstallmentsOpportunities();
		sf_UtilityFunctions.selectTabUIHeaders("Related");
		Utility_Functions.xWaitForElementPresent(driver, installmentsViewAll, 3);
		Utility_Functions.xClick(driver, installmentsViewAll, true);
		Utility_Functions.xWaitForElementPresent(driver, opportunityNameLink, 3);
		Utility_Functions.xClick(driver, opportunityNameLink, true);
		sf_UtilityFunctions.selectTabUIHeaders("Related");
		Utility_Functions.xWaitForElementPresent(driver, installmentAmountOne, 3);
		Utility_Functions.xWaitForElementPresent(driver, installmentAmountTwo, 3);
		String sInstallmentAmountOne = installmentAmountOne.getText();
		String sInstallmentAmountTwo = installmentAmountTwo.getText();
		report.updateTestLog("Opportunities Installments",
				"Opportunity installment amount one and two after changing the quantity to two from one:::"
						+ sInstallmentAmountOne + ":::" + sInstallmentAmountTwo,
				Status.PASS);

		Utility_Functions.xWaitForElementPresent(driver, editButtonInstallment, 5);
		Utility_Functions.xClick(driver, editButtonInstallment, true);
		if (dataTable.getData("General_Data", "TC_ID").contains("OB")) {
			occupierBrokerage();
		} else if (dataTable.getData("General_Data", "TC_ID").contains("AB")) {
			agencyBrokerage();
		}
		Utility_Functions.timeWait(2);
		driver.navigate().refresh();
		Utility_Functions.timeWait(1);
		sf_UtilityFunctions.selectTabUIHeaders("Related");
		sInstallmentAmountOne = installmentAmountOne.getText();
		sInstallmentAmountTwo = installmentAmountTwo.getText();
		System.out.println(sInstallmentAmountOne);
		System.out.println(sInstallmentAmountTwo);
		if (sInstallmentAmountOne.equals("USD 5,000.00") && sInstallmentAmountTwo.equals("USD 5,000.00")) {
			report.updateTestLog("Opportunities Installments",
					"Opportunity installment amounts recalculated successfully after editing the Estimated Gross Fee:::"
							+ sInstallmentAmountOne + ":::" + sInstallmentAmountTwo,
					Status.PASS);
		} else {
			report.updateTestLog("Opportunities Installments", "Opportunity installment amounts recalculation failed:::"
					+ sInstallmentAmountOne + ":::" + sInstallmentAmountTwo, Status.FAIL);
		}

	}

	/**
	 * Verify editing of multiple Installments from Opportunity based on UnEven
	 * Percent
	 * 
	 * @author Vishnuvardhan
	 *
	 */
	public void multipleInstallmentsUnEvenPercent() {
		multipleInstallmentsFunction();
		Utility_Functions.xWaitForElementPresent(driver, editButtonInstallment, 5);
		Utility_Functions.xClick(driver, editButtonInstallment, true);
		if (dataTable.getData("General_Data", "TC_ID").contains("OB")) {
			occupierBrokerage();
		} else if (dataTable.getData("General_Data", "TC_ID").contains("AB")) {
			agencyBrokerage();
		}
		Utility_Functions.xWaitForElementPresent(driver, showMoreActions, 2);
		Utility_Functions.xClick(driver, showMoreActions, true);
		Utility_Functions.timeWait(1);
		Utility_Functions.xWaitForElementPresent(driver, newOpportunityInstallment, 2);
		Utility_Functions.xClick(driver, newOpportunityInstallment, true);
		Utility_Functions.xWaitForElementPresent(driver, installmentNumber, 4);
		Utility_Functions.xSendKeys(driver, installmentNumber, "2");
		Utility_Functions.xSendKeys(driver, editInstallmentAmount, "4,000");
		DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
		Date date = new Date();
		Utility_Functions.xSendKeys(driver, installmentDate, dateFormat.format(date).toString());
		actions.moveToElement(saveNewOpportunityInstallment).click().perform();
		Utility_Functions.timeWait(5);
		sf_UtilityFunctions.selectTabUIHeaders("Related");
		Utility_Functions.xWaitForElementPresent(driver, installmentsViewAll, 3);
		Utility_Functions.xClick(driver, installmentsViewAll, true);
		Utility_Functions.xWaitForElementPresent(driver, opportunityNameLink, 3);
		Utility_Functions.xClick(driver, opportunityNameLink, true);
		sf_UtilityFunctions.selectTabUIHeaders("Related");
		String sInstallmentAmountOne = installmentAmountOne.getText();
		String sInstallmentAmountTwo = installmentAmountTwo.getText();
		System.out.println("installmentAmountOne"+sInstallmentAmountOne);
		System.out.println("installmentAmountTwo"+sInstallmentAmountTwo);
		if (sInstallmentAmountOne.equals("USD 6,000.00") && sInstallmentAmountTwo.equals("USD 4,000.00")) {
			report.updateTestLog("Opportunities Installments",
					"Opportunity installment amounts recalculated successfully after editing the Estimated Gross Fee:::"
							+ sInstallmentAmountOne + ":::" + sInstallmentAmountTwo,
					Status.PASS);
		} else {
			report.updateTestLog("Opportunities Installments", "Opportunity installment amounts recalculation failed:::"
					+ sInstallmentAmountOne + ":::" + sInstallmentAmountTwo, Status.WARNING);
		}
		Utility_Functions.timeWait(2);
		Utility_Functions.xWaitForElementPresent(driver, editButtonInstallment, 5);
		Utility_Functions.xClick(driver, editButtonInstallment, true);
		if (dataTable.getData("General_Data", "TC_ID").contains("OB")) {
			Utility_Functions.xScrollWindow(driver);
			Utility_Functions.timeWait(1);
			Utility_Functions.xScrollWindowTop(driver);
			Utility_Functions.timeWait(3);
			Utility_Functions.xWaitForElementPresent(driver, estimatedGrossFeeEdit, 3);
			estimatedGrossFeeEdit.clear();
			Utility_Functions.xSendKeys(driver, estimatedGrossFeeEdit, "20,000");
			Utility_Functions.timeWait(5);
			Utility_Functions.xWaitForElementPresent(driver, save, 4);
			Utility_Functions.xHighlight(driver, save, "yellow");
			actions.moveToElement(save).click().perform();
			Utility_Functions.timeWait(4);
		} else if (dataTable.getData("General_Data", "TC_ID").contains("AB")) {
			driver.navigate().refresh();
			Utility_Functions.xSwitchtoFrame(driver, agencyBrokerageFrame);
			Utility_Functions.timeWait(2);
			Utility_Functions.xScrollWindow(driver);
			Utility_Functions.timeWait(1);
			Utility_Functions.xScrollWindowTop(driver);
			Utility_Functions.timeWait(2);
			Utility_Functions.xWaitForElementPresent(driver, estimatedGrossFee, 3);
			estimatedGrossFee.clear();
			Utility_Functions.xSendKeys(driver, estimatedGrossFee, "20,000");
			Utility_Functions.xWaitForElementPresent(driver, saveButton_AB, 3);
			Utility_Functions.xClick(driver, saveButton_AB, true);
			Utility_Functions.timeWait(1);
			driver.switchTo().defaultContent();
			// Utility_Functions.xSwitchtoFrame(driver, related);
			Utility_Functions.timeWait(2);
		}
		sf_UtilityFunctions.selectTabUIHeaders("Related");
		sInstallmentAmountOne = installmentAmountOne.getText();
		sInstallmentAmountTwo = installmentAmountTwo.getText();
		System.out.println(sInstallmentAmountOne);
		System.out.println(sInstallmentAmountTwo);
		if (sInstallmentAmountOne.equals("USD 12,000.00") && sInstallmentAmountTwo.equals("USD 8,000.00")) {
			report.updateTestLog("Opportunities Installments",
					"Opportunity installment amounts recalculated successfully after editing the Estimated Gross Fee:::"
							+ sInstallmentAmountOne + ":::" + sInstallmentAmountTwo,
					Status.PASS);
		} else {
			report.updateTestLog("Opportunities Installments", "Opportunity installment amounts recalculation failed:::"
					+ sInstallmentAmountOne + ":::" + sInstallmentAmountTwo, Status.WARNING);
		}

	}

	/**
	 * Verify editing of multiple Installments from Opportunity based on Uneven Percent using API
	 * 
	 * @author Vishnuvardhan
	 *
	 */
	static SaveResult[] results;
	static String result;

	public String opportunityWithInstallmentAmount() {
		EstablishConnection establishConnection = new EstablishConnection(scriptHelper);
		try {
			establishConnection.establishConnection();
			SObject opportunity = new SObject();
			opportunity.setType("Opportunity");
			String accountId = searchTextSOQL.fetchRecord("Account", "Id");
			int value = Utility_Functions.xRandomFunction();
			opportunity.setField("Name", "Test Automation_" + value);
			opportunity.setField("AccountId", accountId);
			opportunity.setField("CloseDate", Calendar.getInstance());
			opportunity.setField("RecordTypeId", "012i0000000405nAAA");
			opportunity.setField("StageName", "02-Meeting");
			opportunity.setField("Service__c", "Occupier Buyer");
			opportunity.setField("Total_Size__c", 5000);
			opportunity.setField("Unit_of_Measure__c", "Acres");
			opportunity.setField("Amount", "50000");

			SObject[] opportunities = new SObject[1];
			opportunities[0] = opportunity;
			results = EstablishConnection.connection.create(opportunities);
			report.updateTestLog("Opportunity Name",
					"Opportunity for the record type Asset Services is created successfully:::", Status.PASS);
			System.out.println("Result:::" + results);
			for (int j = 0; j < results.length; j++) {
				if (results[j].isSuccess()) {
					result = results[j].getId();
					System.out.println("Save Results:::" + result);
					report.updateTestLog("Opportunity Name", "Opportunity Id:::" + result + " successfully:::",
							Status.PASS);
				}
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
			System.out.println(e.getStackTrace());
		}
		String queryAmount = "Select Estimated_Gross_Fee_Commission__c from opportunity where Id = " + "'" + result
				+ "'";
		String queryCount = "Select Installment_Count__c from opportunity where Id = " + "'" + result + "'";
		String queryQuantity = "Select Installment_Quantity__c from opportunity where Id = " + "'" + result + "'";
		String queryTotal = "Select Installments_Total__c from opportunity where Id = " + "'" + result + "'";

		String sInstallmentAmount = searchTextSOQL.fetchRecordFieldValue("Estimated_Gross_Fee_Commission__c",
				queryAmount);
		String sInstallmentCount = searchTextSOQL.fetchRecordFieldValue("Installment_Count__c", queryCount);
		String sInstallmentQuantity = searchTextSOQL.fetchRecordFieldValue("Installment_Quantity__c", queryQuantity);
		String sInstallmentTotal = searchTextSOQL.fetchRecordFieldValue("Installments_Total__c", queryTotal);

		System.out.println("Installment Amount:: " + sInstallmentAmount);
		if (sInstallmentAmount.equals("50000.0")) {
			report.updateTestLog("Opportunity Name", "Installment Record has been created successfully:::" + result
					+ ":::InstallmentAmount:::" + sInstallmentAmount + ":::", Status.PASS);
			report.updateTestLog("Opportunity Name", "Installment Record has been created successfully:::" + result
					+ ":::InstallmentCount:::" + sInstallmentCount + ":::", Status.PASS);
			report.updateTestLog("Opportunity Name", "Installment Record has been created successfully:::" + result
					+ ":::InstallmentQuanity:::" + sInstallmentQuantity + ":::", Status.PASS);
			report.updateTestLog("Opportunity Name", "Installment Record has been created successfully:::" + result
					+ ":::InstallmentTotal:::" + sInstallmentTotal + ":::", Status.PASS);
		} else {
			report.updateTestLog("Opportunity Name",
					"Installment Record creation failed:::" + result + ":::" + sInstallmentAmount + ":::", Status.FAIL);
		}
		return result;

	}

	/**
	 * Verify editing of multiple Installments for Opportunity Even Percent using API
	 * 
	 * @author Vishnuvardhan
	 *
	 */

	public void multipleInstallmentsOpportunityEvenPercent_API() {
		String opportunityID = opportunityWithInstallmentAmount();

		String queryQuantity = "Select Installment_Quantity__c from opportunity where Id = " + "'" + result + "'";
		opportunitiesFunctions.updateOpportunityField("Installment_Quantity__c", opportunityID);
		String siInstallmentQuantity = searchTextSOQL.fetchRecordFieldValue("Installment_Quantity__c",
				queryQuantity);
		if (siInstallmentQuantity.equals("2.0")) {
			report.updateTestLog("Opportunity Name", "Installment Quantity has been created successfully:::" + result
					+ ":::InstallmentQuanity:::" + siInstallmentQuantity + ":::", Status.PASS);
		} else {
			report.updateTestLog("Opportunity Name", "Installment Quantity updation failed:::" + result
					+ ":::InstallmentQuanity:::" + siInstallmentQuantity + ":::", Status.FAIL);
		}
	}

	/**
	 * Verify the ability of deleting an installment
	 * 
	 * @author Vishnuvardhan
	 *
	 */

	public void deleteInstallment() {
		try {
			opportunitiesPage.selectOpportunity();
			sf_UtilityFunctions.selectTabUIHeaders("Related");
			Utility_Functions.xWaitForElementPresent(driver, arrowDown, 3);
			Utility_Functions.xClick(driver, arrowDown, true);
			Utility_Functions.timeWait(1);
			List<WebElement> actionList = driver.findElements(By.xpath("//div[@class='actionMenu']//a"));
			for (WebElement element : actionList) {
				if (!element.getText().contains("Delete")) {
					report.updateTestLog("Opportunities Installments",
							"Installment cannot be deleted as the Delete button is not getting displayed when we try to delete the installment via script:",
							Status.PASS);
				} else {
					report.updateTestLog("Opportunities Installments", "Installment Deletion Failed", Status.FAIL);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Verify the round off functionality for Opportunity Installments
	 * 
	 * @author Vishnuvardhan
	 *
	 */

	static ArrayList<String> installmentList = new ArrayList<String>();
	static ArrayList<String> installmentList1 = new ArrayList<String>();

	public void recalculateRoundOffRule() {
		multipleInstallmentsFunction();
		addingInstallmentsOpportunities();
		sf_UtilityFunctions.selectTabUIHeaders("Related");
		Utility_Functions.xWaitForElementPresent(driver, installmentsViewAll, 3);
		Utility_Functions.xClick(driver, installmentsViewAll, true);
		Utility_Functions.xWaitForElementPresent(driver, opportunityNameLink, 3);
		Utility_Functions.xClick(driver, opportunityNameLink, true);
		sf_UtilityFunctions.selectTabUIHeaders("Related");
		Utility_Functions.xWaitForElementPresent(driver, installmentAmountOne, 3);
		Utility_Functions.xWaitForElementPresent(driver, installmentAmountTwo, 3);
		Utility_Functions.xWaitForElementPresent(driver, installmentAmountThree, 3);
		String sInstallmentAmountOne = installmentAmountOne.getText();
		String sInstallmentAmountTwo = installmentAmountTwo.getText();
		String sInstallmentAmountThree = installmentAmountThree.getText();
		report.updateTestLog("Opportunities Installments",
				"Opportunity installment amount one and two after changing the quantity to two from one:::"
						+ sInstallmentAmountOne + ":::" + sInstallmentAmountTwo + ":::" + sInstallmentAmountThree,
				Status.PASS);
		String sEstimatedGrossAmount = dataTable.getData("General_Data", "InstallmentAmount").replace(",", "");
		String sInstallments = dataTable.getData("General_Data", "InstallmentQuantity");
		double dInstallment = ((double) Integer.parseInt(sEstimatedGrossAmount)) / Integer.parseInt(sInstallments);
		System.out.println(dInstallment);
		BigDecimal bFirstInstallmentAmount = truncateDecimal(dInstallment, 2);
		String sThirdInstallment = (new DecimalFormat(".##").format(dInstallment));
		System.out.println(sThirdInstallment);
		installmentList.add(sThirdInstallment);
		installmentList.add(sThirdInstallment);
		installmentList.add(bFirstInstallmentAmount.toString());
		int count = 0;
		for (int i = 0; i < installmentList.size(); i++) {
			if (sInstallmentAmountOne.replaceAll(",", "").contains(installmentList.get(i))) {
				count++;
			} else if (sInstallmentAmountTwo.replaceAll(",", "").contains(installmentList.get(i))) {
				count++;
			} else if (sInstallmentAmountThree.replaceAll(",", "").contains(installmentList.get(i))) {
				count++;
			}
		}
		if (count == 3) {
			report.updateTestLog("Opportunities Installments",
					"First, Second and Third Installment amounts calculated successfully:::" + bFirstInstallmentAmount
							+ "::::" + bFirstInstallmentAmount + "::::" + sThirdInstallment,
					Status.PASS);
		} else {
			installmentList1.add(bFirstInstallmentAmount.toString());
			installmentList1.add(bFirstInstallmentAmount.toString());
			installmentList1.add(sThirdInstallment);
			int count1 = 0;
			for (int i = 0; i < installmentList1.size(); i++) {
				if (sInstallmentAmountOne.replaceAll(",", "").contains(installmentList1.get(i))) {
					count++;
				} else if (sInstallmentAmountTwo.replaceAll(",", "").contains(installmentList1.get(i))) {
					count++;
				} else if (sInstallmentAmountThree.replaceAll(",", "").contains(installmentList1.get(i))) {
					count++;
				}
			}
			if (count1 == 3) {
				report.updateTestLog("Opportunities Installments",
						"First, Second and Third Installment amounts calculated successfully:::"
								+ bFirstInstallmentAmount + "::::" + bFirstInstallmentAmount + "::::"
								+ sThirdInstallment,
						Status.PASS);
			} else {
				report.updateTestLog("Opportunities Installments",
						"First, Second and Third Installment calculation failed:::" + bFirstInstallmentAmount + "::::"
								+ bFirstInstallmentAmount + "::::" + sThirdInstallment,
						Status.WARNING);
			}
		}
	}

	private static BigDecimal truncateDecimal(double installmentAmount, int numberofDecimals) {
		if (installmentAmount > 0) {
			return new BigDecimal(String.valueOf(installmentAmount)).setScale(numberofDecimals, BigDecimal.ROUND_FLOOR);
		} else {
			return new BigDecimal(String.valueOf(installmentAmount)).setScale(numberofDecimals,
					BigDecimal.ROUND_CEILING);
		}
	}

	/**
	 * Verify whether the user able to edit the paid installment
	 * 
	 * @author Vishnuvardhan
	 *
	 */

	public void editPaidInstallmentAmount() {
		boolean isStatus = false;
		int iInstallmentAmountOne = 0;
		while (!isStatus) {
			labelA: {
				opportunitiesPage.opportunityEligibility();
				Utility_Functions.timeWait(4);
				driver.navigate().refresh();
				sf_UtilityFunctions.selectTabUIHeaders("Related");
				Utility_Functions.xWaitForElementPresent(driver, installmentAmountOne, 3);
				String sInstallmentAmountOne = installmentAmountOne.getText();
				sInstallmentAmountOne = sInstallmentAmountOne.split(" ")[1];
				sInstallmentAmountOne = sInstallmentAmountOne.replaceAll(",", "");
				double dInstallmentAmountOne = Double.parseDouble(sInstallmentAmountOne);
				iInstallmentAmountOne = Double.valueOf(dInstallmentAmountOne).intValue();
				if (iInstallmentAmountOne > 0) {
					report.updateTestLog("Opportunities Installments",
							"Opportunity is eligible for editing the Installments::", Status.PASS);					
					selectEditInstallmentDropdown();						
					Utility_Functions.xWaitForElementPresent(driver, installmentOption, 3);
					Utility_Functions.xClick(driver, installmentOption, true);
					if (installmentOption.getText().contains("Paid")) {
						report.updateTestLog("Opportunities Installments",
								"Opportunity not is eligible as the installment amount is already paid::",
								Status.WARNING);
						isStatus = false;
						Utility_Functions.xWaitForElementPresent(driver, cancel, 3);
						Utility_Functions.xClick(driver, cancel, true);
						Utility_Functions.timeWait(2);
						break labelA;
					}
					DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
					Date date = new Date();
					Utility_Functions.timeWait(1);
					Utility_Functions.xClick(driver, installmentStatus, true);
					Utility_Functions.xSendKeys(driver, datePaid, dateFormat.format(date).toString());
					Utility_Functions.xWaitForElementPresent(driver, accountRoleOption, 3);
					Utility_Functions.xClick(driver, accountRoleOption, true);
					Utility_Functions.timeWait(1);
					Utility_Functions.xClick(driver, accountRole, true);
					Utility_Functions.timeWait(2);
					Utility_Functions.xWaitForElementPresent(driver, save, 4);
					Utility_Functions.xClick(driver, save, true);
					report.updateTestLog("Opportunities Installments",
							"Installment Amount has been paid successfully::", Status.PASS);
					Utility_Functions.timeWait(2);
					Utility_Functions.xWaitForElementPresent(driver, related, 3);
					driver.navigate().refresh();
					sf_UtilityFunctions.selectTabUIHeaders("Related");
					try {
						selectEditInstallmentDropdown();
						Utility_Functions.xWaitForElementPresent(driver, installmentAmountEdit, 3);
						int iInstallmentAmount = iInstallmentAmountOne + 100;
						Utility_Functions.xSendKeys(driver, installmentAmountEdit,
								Integer.toString(iInstallmentAmount));
						Utility_Functions.timeWait(2);
						Utility_Functions.xWaitForElementPresent(driver, save, 3);
						Utility_Functions.xClick(driver, save, true);
						Utility_Functions.timeWait(3);
						Utility_Functions.xWaitForElementPresent(driver, related, 3);
						if (related.isDisplayed()) {
							report.updateTestLog("Opportunities Installments",
									"Editing the Paid installment amount is successfull::", Status.PASS);
							isStatus = true;
							break;
						} else {
							report.updateTestLog("Opportunities Installments",
									"Editing the Paid installment amount is failed::", Status.FAIL);
							isStatus = true;
							break;
						}
					} catch (Exception e) {
						report.updateTestLog("Opportunities Installments", "Unable to edit the installments:::",
								Status.PASS);
						isStatus = true;
						break;
					}
				} else {
					report.updateTestLog("Opportunities Installments",
							"Opportunity not is eligible for editing the Installments::", Status.WARNING);
					isStatus = false;
					break labelA;
				}

			}
		}

	}	
	
	public void selectEditInstallmentDropdown() {
		Utility_Functions.xWaitForElementPresent(driver, arrowDown, 3); 
		Utility_Functions.xClick(driver, arrowDown, true);
		Utility_Functions.timeWait(2);
		Utility_Functions.xWaitForElementPresent(driver, editBtn, 3);
		Utility_Functions.xClick(driver, editBtn, true);
		Utility_Functions.timeWait(1);
	}
}
