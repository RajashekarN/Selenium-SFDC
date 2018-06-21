package pageObjects;

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
 * Page Object Class for Opportunities Page
 * 
 * @author Vishnuvardhan
 *
 */

public class OpportunitiesDefaultRecordType extends ReusableLibrary {
	/*
	 * Constructor to initialize the business component library
	 * 
	 * @param scriptHelper The {@link ScriptHelper} object passed from the
	 * {@link DriverScript}
	 */

	public OpportunitiesDefaultRecordType(ScriptHelper scriptHelper) {
		super(scriptHelper);
		PageFactory.initElements(driver.getWebDriver(), this);
	}
	

	@FindBy(xpath = "//button[text()='Continue']")
	WebElement continueButton;
	
	@FindBy(xpath = "//*[@id='record-type-select']")
	WebElement opportunityRecordType;
	
	@FindBy(xpath = "//h2[contains(@class,'slds-text-heading--medium') and contains(@class,'slds-m-bottom--small')]")
	WebElement opportunityRecordTypeQuickCreate;
	
	@FindBy(xpath = "//input[contains(@id,'close') and contains(@id,'Date')]")
	WebElement closeDateOppSpell;
	
	@FindBy(xpath = "//button/span[text()='View All Fields']")
	WebElement viewAllFieldsButton;
	
	@FindBy(xpath = "//h2[contains(text(),'EMEA') and contains(text(),'Occupier')]")
	WebElement opportunityRecordTypeByDefault;
	
	@FindBy(xpath = "//a[@class='tabHeader']//span[text()='Related']")
	WebElement related;
	
	@FindBy(xpath = "//select[@id='record-type-select']/option[@selected='selected']")
	WebElement defaultOpportutnityRecordType;	

	@FindBy(xpath = "//*[@id='record-type-select']/option[text()='Capital Markets – Debt & Structured Finance']")
	WebElement opportunityRecordTypeDebtStructuredFinance;

	@FindBy(xpath = "//span[text()='Sales Stage']/parent::label/parent::div//a[@class='select']")
	WebElement salesStageSelected;

	@FindBy(xpath = "//span[text()='Phase']/parent::div/parent::div/div[contains(@class,'slds-grid itemBody')]/span/span")
	WebElement phaseField;
	
	@FindBy(xpath = "//span[text()='Phase']/parent::div/parent::div/div[contains(@class,'slds-grid itemBody')]/span/span")
	WebElement phasePresent;
	
	@FindBy(xpath = "//span[text()='Sales Stage']/parent::label/parent::div//a[@class='select']")
	WebElement salesStageSelectedEMEA;
	
	@FindBy(xpath = "//input[contains(@id,'closeDate')]")
	WebElement closeDateOpp;
	
	@FindBy(xpath = "//span[text()='Opportunity Name']/parent::label/parent::div//input")
	WebElement opportunityName_AS;
	
	@FindBy(xpath = "//span[contains(text(),'Preferred')][contains(text(),'Property')]/parent::div//select")
	WebElement preferredPropertyTypeOpp;
	
	OpportunitiesPage opportunitiesPage = new OpportunitiesPage(scriptHelper);
	SearchTextSOQL searchTextSOQL = new SearchTextSOQL(scriptHelper);

	/**
	 * Validating the Opportunity record type for Occupancy Brokerage
	 * 
	 * @author Ramya
	 *
	 */
	public void verifyOpportunityRecordTypeForOccupancyBrokerage() {
		opportunitiesPage.selectNewOpportunity();
		report.updateTestLog("Verify Opportunity Record Type  ", "Verifying the new opportunity page is displayed",
				Status.PASS);
		Utility_Functions.timeWait(2);
		Utility_Functions.xSwitchtoFrame(driver, continueButton);
		Utility_Functions.timeWait(2);
		if (opportunityRecordType.getText().contains("Occupier Brokerage")) {
			System.out.println(
					"Occupier Brokerage is present as the default value in the select record type opportunity page");
			report.updateTestLog("Verify Opportunity Record Type ",
					"Verifying the Occupier Brokerage is present as the default value", Status.PASS);
		} else {
			System.out.println(
					"Occupier Brokerage is not present as the default value in the select record type opportunity page");
			report.updateTestLog("Verify Opportunity Record Type  ",
					"Verifying the Occupier Brokerage is present as the default value", Status.FAIL);
		}

	}

	/**
	 * Validating the Opportunity record type for Agency Brokerage
	 * 
	 * @author Ramya
	 *
	 */
	public void verifyOpportunityRecordTypeForAgencyBroker() {
		opportunitiesPage.selectNewOpportunity();
		Utility_Functions.timeWait(2);
		Utility_Functions.xSwitchtoFrame(driver, continueButton);
		Utility_Functions.timeWait(2);
		if (opportunityRecordType.getText().contains("Agency Brokerage")) {
			System.out.println(
					"Agency Broker is present as the default value in the select record type opportunity page");
			report.updateTestLog("Verify Opportunity Record Type ",
					"Verifying the Agency Broker is present as the default value", Status.PASS);
		} else {
			System.out.println(
					"Agency Broker is not present as the default value in the select record type opportunity page");
			report.updateTestLog("Verify Opportunity Record Type  ",
					"Verifying the Agency Broker is present as the default value", Status.FAIL);
		}
	}

	/**
	 * Validating the Opportunity record type for the Capital Markets
	 * 
	 * @author Ramya
	 *
	 */
	public void verifyOpportunityRecordTypeForCapitalMarkets() {
		opportunitiesPage.selectNewOpportunity();
		report.updateTestLog("Verify Opportunity Record Type  ", "Verifying the new opportunity page is displayed",
				Status.PASS);
		Utility_Functions.timeWait(2);
		Utility_Functions.xSwitchtoFrame(driver, continueButton);
		Utility_Functions.timeWait(2);
		if (opportunityRecordType.getText().contains("Capital Markets – Property Sales")) {
			System.out.println(
					"Capital Markets – Property Sales is present as the default value in the select record type opportunity page");
			report.updateTestLog("Verify Opportunity Record Type ",
					"Verifying the Capital Markets – Property Sales is present as the default value", Status.PASS);
		} else {
			System.out.println(
					"Capital Markets – Property Sales is not present as the default value in the select record type opportunity page");
			report.updateTestLog("Verify Opportunity Record Type  ",
					"Verifying the Capital Markets – Property Sales is present as the default value", Status.FAIL);
		}
	}
	
	/**
	 * Verify the Occupier Record Type should default to 'Occupier' opportunity type field
	 * 
	 * @author Vishnuvardhan
	 *
	 */

	public void verifyOpportunityRecordTypeforEMEAATT() {
		opportunitiesPage.selectOpportunity();
		Utility_Functions.timeWait(2);
		Utility_Functions.xSwitchtoFrame(driver, opportunityRecordTypeQuickCreate);
		Utility_Functions.timeWait(2);
		if (opportunityRecordTypeQuickCreate.getText().contains("EMEA A&T Occupier")) {
			report.updateTestLog("Verify Opportunity Occupier Record Type",
					"Occupier record type is defaulted to Occupier Opportunity type field when selected:::",
					Status.PASS);
		} else {
			report.updateTestLog("Verify Opportunity Occupier Record Type",
					"Occupier record type is not defaulted to 'Occupier' Opportunity type field when selected:::",
					Status.FAIL);
		}
	}
	
	/**
	 * Validating the Occupier Record Type should default to 'Occupier Brokerage'
	 * 
	 * @author Vishnuvardhan
	 *
	 */

	public void defaultOppRecordType() {
		opportunitiesPage.selectNewOpportunity();
		try {
			Utility_Functions.xSwitchtoFrame(driver, continueButton);
			Utility_Functions.timeWait(2);
			Utility_Functions.xClick(driver, continueButton, true);
		} catch (Exception e) {
			e.getMessage();
		}
		Utility_Functions.xSwitchtoFrame(driver, closeDateOppSpell);
		Utility_Functions.timeWait(2);
		Utility_Functions.xScrollWindow(driver);
		Utility_Functions.timeWait(2);
		Utility_Functions.xWaitForElementPresent(driver, viewAllFieldsButton, 3);
		Utility_Functions.xClick(driver, viewAllFieldsButton, true);
		Utility_Functions.xScrollWindowOnce(driver);
		Utility_Functions.timeWait(2);
		Utility_Functions.xWaitForElementPresent(driver, opportunityRecordTypeByDefault, 3);
		if (opportunityRecordTypeByDefault.getText().contains("Occupier")) {
			report.updateTestLog("Verify Default Opportunity Record Type", "Opportunity Record Type is having the value as:::" + opportunityRecordTypeByDefault.getText(), Status.PASS);
		} else {
			report.updateTestLog("Verify Default Opportunity Record Type", "Opportunity Record Type is not having the value as:::" + opportunityRecordTypeByDefault.getText(),
					Status.FAIL);
		}
	}
	

	/**
	 * Verify the landing page should default to Details page by default from a Manager
	 * 
	 * @author Vishnuvardhan
	 *
	 */
	public void defaultLandingPageDetailsPage() {
		opportunitiesPage.opportunityEligibility();
		report.updateTestLog("Verify Opportunity Landing Page", "Random Opportunity is clicked from the Opportunity List", Status.PASS);
		Utility_Functions.timeWait(3);
		Utility_Functions.xWaitForElementPresent(driver, related, 3);
		List<WebElement> headerList = driver.findElements(By.xpath("//div[contains(@class,'test-id__section')]//h3"));
		for (WebElement element : headerList) {
			if (element.getText().equals("Tagging")) {
				report.updateTestLog("Verify Opportunity Landing Page",
						"Details Page is displayed by default after clicking on Opportunity", Status.PASS);
				break;
			} else {
				report.updateTestLog("Verify Opportunity Landing Page", "Details Page is not displayed by default after clicking on Opportunity", Status.WARNING);
			}
		}
	}
	
	/**
	 * Verify the default values Sales Stage and Phase field on the Opportunity Detail page from a broker profile
	 * 
	 * @author Vishnuvardhan
	 *
	 */
	
	public void defaultSalesStageandPhaseField() {
		opportunitiesPage.selectNewOpportunity();
		if ((dataTable.getData("General_Data", "TC_ID").contains("ABAMER")) || (dataTable.getData("General_Data", "TC_ID").contains("CMAMER")) || (dataTable.getData("General_Data", "TC_ID").contains("OBAMER"))) {
			Utility_Functions.timeWait(3);
			Utility_Functions.xSwitchtoFrame(driver, continueButton);
			Utility_Functions.xWaitForElementPresent(driver, continueButton, 3);
			if ((dataTable.getData("General_Data", "TC_ID").contains("CMAMER"))	&& (dataTable.getData("General_Data", "TC_ID").contains("DSF"))) {
				Utility_Functions.xWaitForElementPresent(driver, opportunityRecordType, 2);
				if (defaultOpportutnityRecordType.getText().equals("Capital Markets – Property Sales")) {
					Utility_Functions.xClick(driver, opportunityRecordType, true);
					Utility_Functions.timeWait(1);
					Utility_Functions.xClick(driver, opportunityRecordTypeDebtStructuredFinance, true);
				}
			}
			Utility_Functions.xClick(driver, continueButton, true);
			Utility_Functions.timeWait(2);
			driver.switchTo().defaultContent();
			try {
				Utility_Functions.xSelectDropdownByIndex(preferredPropertyTypeOpp, 1);
			} catch (Exception e) {
				e.printStackTrace();
			}
			Utility_Functions.xSwitchtoFrame(driver, salesStageSelected);
			Utility_Functions.xWaitForElementPresent(driver, salesStageSelected, 3);
			if ((dataTable.getData("General_Data", "TC_ID").contains("ABAMER")) || (dataTable.getData("General_Data", "TC_ID").contains("OBAMER"))) {
				if ((salesStageSelected.getText().equals("02-Meeting"))
						&& (phasePresent.getText().equals("Prospecting"))) {
					report.updateTestLog("Verify New Opportunity Page",
							"Sales Stage and Phase field are having the values as:::" + salesStageSelected.getText()
									+ ":::" + phaseField.getText(),
							Status.PASS);
				} else {
					report.updateTestLog("Verify New Opportunity Page",
							"Sales Stage and Phase field doesn't have the values as expected:::"
									+ salesStageSelected.getText() + ":::" + phaseField.getText(),
							Status.FAIL);
				}
			} else if ((dataTable.getData("General_Data", "TC_ID").contains("CMAMER")) && (dataTable.getData("General_Data", "TC_ID").contains("PS"))) {
				if ((salesStageSelected.getText().equals("01-Preliminary"))
						&& (phasePresent.getText().equals("Prospecting"))) {
					report.updateTestLog("Verify New Opportunity Page",
							"Sales Stage and Phase field are having the values as:::" + salesStageSelected.getText()
									+ ":::" + phaseField.getText(),
							Status.PASS);
				} else {
					report.updateTestLog("Verify New Opportunity Page",
							"Sales Stage and Phase field doesn't have the values as expected:::"
									+ salesStageSelected.getText() + ":::" + phaseField.getText(),
							Status.FAIL);
				}
			} else if ((dataTable.getData("General_Data", "TC_ID").contains("CMAMER")) && (dataTable.getData("General_Data", "TC_ID").contains("DSF"))) {
				if ((salesStageSelected.getText().equals("01-Screening"))
						&& (phasePresent.getText().equals("Prospecting"))) {
					report.updateTestLog("Verify New Opportunity Page",
							"Sales Stage and Phase field are having the values as:::" + salesStageSelected.getText()
									+ ":::" + phaseField.getText(),
							Status.PASS);
				} else {
					report.updateTestLog("Verify New Opportunity Page",
							"Sales Stage and Phase field doesn't have the values as expected:::"
									+ salesStageSelected.getText() + ":::" + phaseField.getText(),
							Status.FAIL);
				}
			}
			Utility_Functions.timeWait(2);
			/*String sAccountName = searchTextSOQL.fetchRecord("Account", "Name");	
			opportunitiesPage.opportunityCreation(sAccountName);*/
		} else if (dataTable.getData("General_Data", "TC_ID").contains("ABEMEA")) {
			try {
				Utility_Functions.xSwitchtoFrame(driver, salesStageSelectedEMEA);
				Utility_Functions.xWaitForElementPresent(driver, salesStageSelectedEMEA, 3);
			} catch (Exception e) {
				Utility_Functions.xSwitchtoFrame(driver, continueButton);
				Utility_Functions.xWaitForElementPresent(driver, continueButton, 5);
				Utility_Functions.xClick(driver, continueButton, true);
				Utility_Functions.xSwitchtoFrame(driver, closeDateOpp);
				Utility_Functions.timeWait(1);
				Utility_Functions.xWaitForElementPresent(driver, salesStageSelectedEMEA, 3);
			}
			if ((salesStageSelectedEMEA.getText().equals("--None--"))) {
				report.updateTestLog("Verify New Opportunity Page",
						"Sales Stage is having the value as:::" + salesStageSelectedEMEA.getText(), Status.PASS);
			} else {
				report.updateTestLog("Verify New Opportunity Page",
						"Sales Stage doesn't have the value as expected:::" + salesStageSelectedEMEA.getText(),
						Status.FAIL);
			}
		}
	}
	
	/**
	 * Validating the Opportunities Quick create page Comments field
	 * 
	 * @author Ramya
	 *
	 */

	public void validateOpportunityNameQuickCreate() {
		opportunitiesPage.selectNewOpportunity();
		Utility_Functions.xScrollWindow(driver);
		Utility_Functions.timeWait(1);
		Utility_Functions.xScrollWindowTop(driver);
		Utility_Functions.timeWait(2);
		if (opportunityName_AS.getText().equals("")) {
			System.out.println("The opportunity name is not populated with the default value");
			report.updateTestLog("Verify Opportunities Quick Create Opportunity Name ",
					"Verifying the opportunity name is not populated with the default value ", Status.PASS);
		} else {
			System.out.println("The opportunity name is populated with the default value");
			report.updateTestLog("Verify Opportunities Quick Create Opportunity Name",
					"Verifying the opportunity name is populated with the default value", Status.FAIL);
		}
	}


}
