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

import pagesAPI.EstablishConnection;
import pagesAPI.SearchTextSOQL;
import supportLibraries.SF_UtilityFunctions;
import supportLibraries.Utility_Functions;

/**
 * Page Object Class for Opportunities Page
 * 
 * @author Vishnuvardhan
 *
 */

public class OpportunityPageLayout extends ReusableLibrary {
	/*
	 * Constructor to initialize the business component library
	 * 
	 * @param scriptHelper The {@link ScriptHelper} object passed from the
	 * {@link DriverScript}
	 */

	public OpportunityPageLayout(ScriptHelper scriptHelper) {
		super(scriptHelper);
		PageFactory.initElements(driver.getWebDriver(), this);
	}
	
	@FindBy(xpath = "//button[text()='Continue']")
	WebElement continueButton;

	@FindBy(xpath = "//button/span[text()='View All Fields']")
	WebElement viewAllFieldsButton;

	@FindBy(xpath = "//*[@class='slds-form-element__label']")
	List<WebElement> labelListOpportunitiesPage;
	
	@FindBy(xpath = "//*[contains(@id,'oppForm:oppName')]")
	WebElement opportunityName;

	@FindBy(xpath = "//input[@id='acctSearchBox']")
	WebElement accountName;
	
	@FindBy(xpath = "//span[text()='Estimated Gross Fee/Commission']/following-sibling::div[@class='requiredInput']/input")
	WebElement estimatedGrossFeeNewOpportunity;
	
	@FindBy(xpath = "//select[contains(@id,'oppForm:salesStage')]")
	WebElement salesStageEMEANewOpportunity;

	@FindBy(xpath = "//select[contains(@id,'oppForm:salesStage')]/option[@value='Target']")
	WebElement salesStageEMEANewOpportunityValue;

	@FindBy(xpath = "//span[text()='Opportunity Name']/parent::label/parent::div//input")
	WebElement opportunityName_AS;

	@FindBy(xpath = "//span[text()='Area']/parent::label/parent::div//input")
	WebElement totalSize_AS;

	@FindBy(xpath = "//a[@aria-label='Unit of Measure']")
	WebElement unitofMeasure_AS;

	@FindBy(xpath = "//a[@title='Square Feet']")
	WebElement unitofMeasureValue_AS;

	@FindBy(xpath = "//a[@aria-label='Type']")
	WebElement type_AS;

	@FindBy(xpath = "//a[@title='New Business']")
	WebElement typeNewBusiness_AS;

	@FindBy(xpath = "//a[@aria-label='Region']")
	WebElement region_AS;

	@FindBy(xpath = "//a[@title='APAC']")
	WebElement regionValue_AS;

	@FindBy(xpath = "//div[contains(@class,'primaryLabel')][contains(@title,'Test Automation_0101')]")
	WebElement accountNameNewOpp;
	
	@FindBy(xpath = "//span[text()='Assignment Start Date']/parent::label/parent::div//input")
	WebElement assignmentStartDate;

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

	@FindBy(xpath = "//div[@id='rlql-showAllShowLess']/a")
	WebElement showAll;

	@FindBy(xpath = "//span[contains(@title,'Opportunity Field History')]")
	WebElement opportunityFieldHistory;

	@FindBy(xpath = "//span[contains(@title,'Phase History ')]")
	WebElement phaseHistory;

	@FindBy(xpath = "//span[contains(text(),'City Tier')]/parent::span/following-sibling::div//a[contains(@aria-label,'City Tier')]")
	WebElement cityTier;

	@FindBy(xpath = "//a[contains(@title,'Tier 1')]")
	WebElement cityTierValue;
	
	@FindBy(xpath = "//a[contains(@aria-label,'Opportunity Currency')]")
	WebElement selectOpportunityCurrency;

	@FindBy(xpath = "//a[contains(@title,'Indian Rupee')]")
	WebElement opportunityCurrencyValue;

	@FindBy(xpath = "//span[contains(text(),'City')]/parent::label/parent::div/input")
	WebElement opportunityCity;


	@FindBy(xpath = "//button[contains(@class,'forceActionButton')]/span[text()='Save']")
	WebElement saveNewOpp;

	@FindBy(xpath = "//input[contains(@title,'Search Properties')]")
	WebElement targetProperty;

	@FindBy(xpath = "//span[contains(text(),'Account Name')]/parent::label/following-sibling::div//input[contains(@title,'Search Accounts')]")
	WebElement accountNameNewOpportunity;

	@FindBy(xpath = "//div[contains(@class,'primaryLabel')][@title='01R4597B21CBRE Test SFDC Automation_0401']")
	WebElement accountNameValueNewOpp;
	
	@FindBy(xpath = "//span[contains(text(),'Opportunity Name')]/parent::label/following-sibling::input")
	WebElement opportunityNameAS;
	
	@FindBy(xpath = "//span[contains(text(),'Lead Source')]/parent::span/following-sibling::div//a")
	WebElement leadSourceNewOpp;

	@FindBy(xpath = "//a[contains(@title,'Business Relationship')]")
	WebElement leadSourceNewOppValue;

	@FindBy(xpath = "//span[text()='Close Date']/parent::label/parent::div//input")  
	WebElement closeDate_AS;

	@FindBy(xpath = "//button[@class='slds-button slds-button--neutral uiButton--default uiButton--brand uiButton forceActionButton']/span[text()='Save']")
	WebElement saveNewOpportunity_AS;
	
	@FindBy(xpath = "//span[text()='Estimated Gross Fee/Commission']/parent::label/parent::div/input")
	WebElement estiamtedGrossFeeCommissionValue;

	@FindBy(xpath = "//span[text()='Estimated Transaction Value']/parent::label/parent::div/input")
	WebElement estimatedTransactionValue;

	@FindBy(xpath = "//input[contains(@id,'oppForm:closeDate')]")
	WebElement closeDateNewOpportunity;

	@FindBy(xpath = "//input[@value='Save']")
	WebElement saveOpportunitySplitUAT;
	
	@FindBy(xpath = "//a[@class='tabHeader']//span[text()='Details']")
	WebElement details;
	
	@FindBy(xpath = "//select[@id='record-type-select']")
	WebElement selectOpportunityRecordType;

	@FindBy(xpath = "//select[@id='record-type-select']/option[@value='012i0000000tvTeAAI']")
	WebElement selectOpportunityRecordTypeValue;
	
	@FindBy(xpath = "//select[@id='record-type-select']/option[contains(text(),'APAC Debt & Structured Finance')]")
	WebElement opportunityDSFValue;
	
	@FindBy(xpath = "//a[@class='forceActionLink']/div[@class='slds-truncate'][text()='Edit']")
	WebElement edit;
	
	@FindBy(xpath = "//select[@id='record-type-select']/option[contains(text(),'France Transaction Demand Agency')]")
	WebElement opportunityFSTAValue;
	
	/**
	 * Function for validating the Mandate Information section on Opp page layout
	 */
	@FindBy(xpath = "//select[@id='record-type-select']")
	WebElement selectFrOpportunityRecordType;
	
	@FindBy(xpath="//span[text()='Lead Source']/parent::span/parent::div//a")
	WebElement leadSource_FR;
	
	@FindBy(xpath = "//span[text()='Appointment Type']/parent::span/following-sibling::div//a")
	WebElement appointmentType;
	
	@FindBy(xpath="//span[text()='Opportunity Name']/parent::label/parent::div//input")
	WebElement opportunityName_FR;
	
	@FindBy(xpath="//span[text()='Estimated Gross Fee/Commission']/parent::label/parent::div/input")
	WebElement estimatedGrossFeeCommissionFr;
	
	@FindBy(xpath="//span[text()='Close Date']/parent::label/parent::div//input")
	WebElement closeDate_FR;
	
	@FindBy(xpath="//span[text()='Sales Stage']/parent::label/parent::div//a")
	WebElement salesStage_FR;
	
	@FindBy(xpath ="//span[contains(text(),'Account Name')]/parent::label/following-sibling::div//input[contains(@title,'Search Accounts')]")
	WebElement accountNameFrOpportunity;
	
	@FindBy(xpath = "//span[text()='Pitch Competitors']/parent::label/following-sibling::select")
	WebElement pitchCompetitors;

	@FindBy(xpath= "//span[text()='Pitch Competitor Other']/parent::label/following-sibling::input")
	WebElement pitchCompetitorOther;
	
	@FindBy(xpath="//button[contains(@class,'forceActionButton')]/span[text()='Save']")
	WebElement saveNewOpp_FR;
	

	SF_UtilityFunctions sf_UtilityFunctions = new SF_UtilityFunctions(scriptHelper);
	OpportunitiesPage opportunitiesPage = new OpportunitiesPage(scriptHelper);
	SearchTextSOQL searchTextSOQL = new SearchTextSOQL(scriptHelper);
	EstablishConnection establishConnection = new EstablishConnection(scriptHelper);
	
	/**
	 * Function validating the page layout headers for ABAMER, OBAMER, ABAPAC and CMAMER
	 * 
	 * @author Vishnuvardhan
	 *
	 */
	
	static ArrayList<String> OpportunityPageHeadersCapitalMarkets = new ArrayList<String>();

	
	public void OpportunityPageHeadersCapitalMarkets() {
		OpportunityPageHeadersCapitalMarkets.add("Opportunity Information");
		OpportunityPageHeadersCapitalMarkets.add("Line of Business Information");
		OpportunityPageHeadersCapitalMarkets.add("Deal Metrics");
		OpportunityPageHeadersCapitalMarkets.add("Financial Information");
		OpportunityPageHeadersCapitalMarkets.add("Close Information");
		OpportunityPageHeadersCapitalMarkets.add("Loss Information");
		OpportunityPageHeadersCapitalMarkets.add("System Information");
		report.updateTestLog("Verify Opportunity Page Headers", "Opportunity page headers are:::" + OpportunityPageHeadersCapitalMarkets, Status.PASS);
	}
	

	static ArrayList<String> OpportunityPageLabelsCMAMERList = new ArrayList<String>();

	
	public void OpportunityPageFieldLabelsCMAMER() {
		OpportunityPageLabelsCMAMERList.add("Account ID");
		OpportunityPageLabelsCMAMERList.add("Assignment Type");
		OpportunityPageLabelsCMAMERList.add("Assignment Sub-Type");
		OpportunityPageLabelsCMAMERList.add("Lead Source");
		OpportunityPageLabelsCMAMERList.add("Close Date");
		OpportunityPageLabelsCMAMERList.add("Total Size");
		OpportunityPageLabelsCMAMERList.add("Unit of Measure");
		OpportunityPageLabelsCMAMERList.add("Name");
		OpportunityPageLabelsCMAMERList.add("Sales Stage");
		OpportunityPageLabelsCMAMERList.add("Phase");
		OpportunityPageLabelsCMAMERList.add("Probability (%)");
		OpportunityPageLabelsCMAMERList.add("Estimated Gross Fee/Commission");
		
		OpportunityPageLabelsCMAMERList.add("Specialty Group");
		OpportunityPageLabelsCMAMERList.add("Parent Opportunity");
		OpportunityPageLabelsCMAMERList.add("Cross Sell");
		OpportunityPageLabelsCMAMERList.add("Confidential Opportunity");
		OpportunityPageLabelsCMAMERList.add("Priority");
		OpportunityPageLabelsCMAMERList.add("Hire Date");
		

		OpportunityPageLabelsCMAMERList.add("Record Type ID");
		OpportunityPageLabelsCMAMERList.add("On Hold");
		OpportunityPageLabelsCMAMERList.add("On Hold Comments");
		OpportunityPageLabelsCMAMERList.add("On Hold Comments");
		OpportunityPageLabelsCMAMERList.add("Sales Stage");
		OpportunityPageLabelsCMAMERList.add("Phase");
		OpportunityPageLabelsCMAMERList.add("Probability (%)");
		OpportunityPageLabelsCMAMERList.add("On Hold");
		OpportunityPageLabelsCMAMERList.add("On Hold Date");
		OpportunityPageLabelsCMAMERList.add("On Hold Comments");

	
		OpportunityPageLabelsCMAMERList.add("Investment Profile");
		OpportunityPageLabelsCMAMERList.add("Total # of Units");
		OpportunityPageLabelsCMAMERList.add("Unit of Comparison");
		OpportunityPageLabelsCMAMERList.add("Opportunity Details");
		OpportunityPageLabelsCMAMERList.add("Listing Price");
		OpportunityPageLabelsCMAMERList.add("Listing Expiration");
		OpportunityPageLabelsCMAMERList.add("Portfolio");
		OpportunityPageLabelsCMAMERList.add("Preferred Property Type");
		OpportunityPageLabelsCMAMERList.add("Preferred Property Sub-Type");
		
		
		OpportunityPageLabelsCMAMERList.add("Estimated Transaction Value");
		OpportunityPageLabelsCMAMERList.add("Status Comments");
		OpportunityPageLabelsCMAMERList.add("Next Steps");
		
		OpportunityPageLabelsCMAMERList.add("Final Transaction Value");
		
			
		OpportunityPageLabelsCMAMERList.add("Reason for Loss");
		OpportunityPageLabelsCMAMERList.add("Reason Lost Comments");
		OpportunityPageLabelsCMAMERList.add("Competitor");
		
		OpportunityPageLabelsCMAMERList.add("Owner ID");
		//OpportunityPageLabelsCMAMERList.add("External Deal ID");
		report.updateTestLog("Verify Opportunity Field Labels", "Opportunity field labels are:::" + OpportunityPageLabelsCMAMERList, Status.PASS);

	}
	

	/**
	 * Function validating the page layout headers for ABAMER, OBAMER, ABAPAC and CMAMER
	 * 
	 * @author Vishnuvardhan
	 *
	 */

	/**
	 * Function validating the page layout headers for FRANEMEA
	 * 
	 * @author Haritha
	 *
	 */
	
	static ArrayList<String> OpportunityPageHeadersListFR = new ArrayList<String>();

	public void OpportunityPageHeadersFR() {
		OpportunityPageHeadersListFR.add("Fields");
		OpportunityPageHeadersListFR.add("Related Information");
		OpportunityPageHeadersListFR.add("Demand Details");
		OpportunityPageHeadersListFR.add("Mandate Information");
		OpportunityPageHeadersListFR.add("Other Information");
		OpportunityPageHeadersListFR.add("Confidentiality");
		OpportunityPageHeadersListFR.add("Immagine Information");
		OpportunityPageHeadersListFR.add("System Information");
		report.updateTestLog("Verify Opportunity Page Headers for France users", "Opportunity page headers are:::" + OpportunityPageHeadersListFR, Status.PASS);
	}
	
	/**
	 * Function validating the page layout labels for ASEMEA
	 * 
	 * @author Haritha
	 */
	
	static ArrayList<String> AssetServicesEMEAOppNewLabels = new ArrayList<String>();

	public void ASEMEAOppNewLabelsList() {	
		AssetServicesEMEAOppNewLabels.add("Sub Market");
		report.updateTestLog("Verify Opportunity Field Labels", "Opportunity field labels are:::" + AssetServicesEMEAOppNewLabels, Status.PASS);
	}
	
	
	
	/**
	 * Function validating the page layout labels for FRANEMEA
	 * 
	 * @author Haritha
	 *
	 */
	
	static ArrayList<String> franEMEAOppNewLabels = new ArrayList<String>();

	public void franEMEAOppNewLabelsList() {	
		franEMEAOppNewLabels.add("Appointment Type");
		franEMEAOppNewLabels.add("Pitch Competitors");
		franEMEAOppNewLabels.add("Pitch Competitor Other");
		franEMEAOppNewLabels.add("Parent Opportunity");
	}
	
	/**
	 * Function validating the page layout labels for ABAMER, OBAMER, ABAPAC and CMAMER
	 * 
	 * @author Vishnuvardhan
	 *
	 */

	static ArrayList<String> OpportunityPageHeadersOBAMERList = new ArrayList<String>();

	
	public void OpportunityPageHeadersOBAMERList() {
		OpportunityPageHeadersOBAMERList.add("Opportunity Information");
		OpportunityPageHeadersOBAMERList.add("Assignment Details");
		OpportunityPageHeadersOBAMERList.add("Financial Inforamtion");
		OpportunityPageHeadersOBAMERList.add("Additional Information");
		OpportunityPageHeadersOBAMERList.add("Pursuit Information");
		OpportunityPageHeadersOBAMERList.add("Win / Loss Information");
		OpportunityPageHeadersOBAMERList.add("Close Information");
		OpportunityPageHeadersOBAMERList.add("System Information");
		report.updateTestLog("Verify Opportunity Page Headers", "Opportunity page headers are:::" + OpportunityPageHeadersOBAMERList, Status.PASS);
	}
	
	static ArrayList<String> OpportunityPageHeadersAPAC = new ArrayList<String>();
	
	public void OpportunityPageHeadersAPAC() {
		OpportunityPageHeadersAPAC.add("Opportunity Information");
		OpportunityPageHeadersAPAC.add("Financial Details/Sales Stages");
		OpportunityPageHeadersAPAC.add("Pursuit/Appointment Information");
		OpportunityPageHeadersAPAC.add("Requirements");
		OpportunityPageHeadersAPAC.add("Close Information");
		OpportunityPageHeadersAPAC.add("Loss/Cancel Information");
		OpportunityPageHeadersAPAC.add("Related Opportunities");
		OpportunityPageHeadersAPAC.add("Tagging");
		OpportunityPageHeadersAPAC.add("System Information");
		report.updateTestLog("Verify Opportunity Page Headers", "Opportunity page headers are:::" + OpportunityPageHeadersAPAC, Status.PASS);
	}
	
	
	
	static ArrayList<String> OpportunityPageLabelsOBAMERList = new ArrayList<String>();

	
	public void OpportunityPageFieldLabelsOBAMER() {
		OpportunityPageLabelsOBAMERList.add("Opportunity No.");
		OpportunityPageLabelsOBAMERList.add("Name");
		OpportunityPageLabelsOBAMERList.add("Parent Opportunity");
		OpportunityPageLabelsOBAMERList.add("Lead Source");
		OpportunityPageLabelsOBAMERList.add("Cross Sell");
		OpportunityPageLabelsOBAMERList.add("Confidential Opportunity");
		OpportunityPageLabelsOBAMERList.add("Auto Approve Forecast");
		OpportunityPageLabelsOBAMERList.add("Account ID");
		OpportunityPageLabelsOBAMERList.add("Location");
		OpportunityPageLabelsOBAMERList.add("Priority");
		OpportunityPageLabelsOBAMERList.add("Hire Date");
		OpportunityPageLabelsOBAMERList.add("Close Date");
		OpportunityPageLabelsOBAMERList.add("Migrated Opportunity"); 
		
		OpportunityPageLabelsOBAMERList.add("Record Type ID");
		OpportunityPageLabelsOBAMERList.add("Assignment Type");
		OpportunityPageLabelsOBAMERList.add("Assignment Sub-Type");
		OpportunityPageLabelsOBAMERList.add("Specialty Group");
		OpportunityPageLabelsOBAMERList.add("Sales Stage");
		OpportunityPageLabelsOBAMERList.add("Phase");
		OpportunityPageLabelsOBAMERList.add("Probability (%)");
		OpportunityPageLabelsOBAMERList.add("On Hold");
		OpportunityPageLabelsOBAMERList.add("On Hold Date");
		OpportunityPageLabelsOBAMERList.add("On Hold Comments");

		OpportunityPageLabelsOBAMERList.add("Estimated Gross Fee/Commission");
		OpportunityPageLabelsOBAMERList.add("Opportunity Currency");
		
		OpportunityPageLabelsOBAMERList.add("Requirement/Building Details");
		OpportunityPageLabelsOBAMERList.add("Minimum Total Size");
		OpportunityPageLabelsOBAMERList.add("Maximum Total Size");
		OpportunityPageLabelsOBAMERList.add("Total Size");
		OpportunityPageLabelsOBAMERList.add("Unit of Measure");
		OpportunityPageLabelsOBAMERList.add("Total # of Units");
		OpportunityPageLabelsOBAMERList.add("Floor Number");
		OpportunityPageLabelsOBAMERList.add("Deal IQ URL");
		OpportunityPageLabelsOBAMERList.add("Status Comments");
		OpportunityPageLabelsOBAMERList.add("Special Economic Zone");
		OpportunityPageLabelsOBAMERList.add("Preferred Property Type");
		OpportunityPageLabelsOBAMERList.add("Preferred Property Sub-Type");
		OpportunityPageLabelsOBAMERList.add("Desired Commencement");
		OpportunityPageLabelsOBAMERList.add("Existing Lease Expiration");
		OpportunityPageLabelsOBAMERList.add("Existing Termination/Break Option");
		OpportunityPageLabelsOBAMERList.add("New Termination/Break Option");
		OpportunityPageLabelsOBAMERList.add("Next Steps");
		
		OpportunityPageLabelsOBAMERList.add("Pitch Date");
		OpportunityPageLabelsOBAMERList.add("Client Type");
		OpportunityPageLabelsOBAMERList.add("Opportunity Type");
		OpportunityPageLabelsOBAMERList.add("Pursuit Source");
		OpportunityPageLabelsOBAMERList.add("Pursuit LOBs");
		OpportunityPageLabelsOBAMERList.add("Pitch Technology");
		OpportunityPageLabelsOBAMERList.add("Pitch Competitors");
		OpportunityPageLabelsOBAMERList.add("Pitch Competitor Other");
		OpportunityPageLabelsOBAMERList.add("Incumbent");
		
		OpportunityPageLabelsOBAMERList.add("Win / Loss");
		OpportunityPageLabelsOBAMERList.add("Win / Loss Date");
		OpportunityPageLabelsOBAMERList.add("Business Awarded To");
		OpportunityPageLabelsOBAMERList.add("Business Awarded To Other");
		OpportunityPageLabelsOBAMERList.add("Attached LOBs");
		OpportunityPageLabelsOBAMERList.add("Reason for Loss");
		OpportunityPageLabelsOBAMERList.add("Reason Lost Comments");
		OpportunityPageLabelsOBAMERList.add("Big Wins");

		OpportunityPageLabelsOBAMERList.add("Lease From");
		OpportunityPageLabelsOBAMERList.add("Lease To");
		OpportunityPageLabelsOBAMERList.add("Lease Term (Months)");
		OpportunityPageLabelsOBAMERList.add("Lease Rate/Rent");
		OpportunityPageLabelsOBAMERList.add("Lease Rate/Rent Basis");
		OpportunityPageLabelsOBAMERList.add("Outside Broker Company");
		OpportunityPageLabelsOBAMERList.add("Outside Broker Name");
		OpportunityPageLabelsOBAMERList.add("CBRE Role");
		OpportunityPageLabelsOBAMERList.add("Sub Lease");
		OpportunityPageLabelsOBAMERList.add("Lease Rate/Rent Type");
		
		OpportunityPageLabelsOBAMERList.add("Owner ID");
		OpportunityPageLabelsOBAMERList.add("Change Opportunity Owner");
		/*OpportunityPageLabelsOBAMERList.add("Last Manually Modified By");
		OpportunityPageLabelsOBAMERList.add("Last Manually Modified Date");
		OpportunityPageLabelsOBAMERList.add("Date");
		OpportunityPageLabelsOBAMERList.add("Time");*/
		OpportunityPageLabelsOBAMERList.add("External Deal ID");
		OpportunityPageLabelsOBAMERList.add("Source System");
		OpportunityPageLabelsOBAMERList.add("Integration Id");
		OpportunityPageLabelsOBAMERList.add("CIF Source System ID");
		OpportunityPageLabelsOBAMERList.add("CBRE Role");
		OpportunityPageLabelsOBAMERList.add("CBRE Role");
		report.updateTestLog("Verify Opportunity Field Labels", "Opportunity field labels are:::" + OpportunityPageLabelsOBAMERList, Status.PASS);

	}
	
	static ArrayList<String> OpportunityPageHeadersABAMERList = new ArrayList<String>();

	
	public void OpportunityPageHeadersABAMER() {
		OpportunityPageHeadersABAMERList.add("Opportunity Information");
		OpportunityPageHeadersABAMERList.add("Services");
		OpportunityPageHeadersABAMERList.add("Financial Information");
		OpportunityPageHeadersABAMERList.add("Additional Information");
		OpportunityPageHeadersABAMERList.add("Close Information");
		OpportunityPageHeadersABAMERList.add("Loss Information");
		OpportunityPageHeadersABAMERList.add("System Information");
		report.updateTestLog("Verify Opportunity Page Headers", "Opportunity page headers are:::" + OpportunityPageHeadersABAMERList, Status.PASS);
	}
	
	static ArrayList<String> OpportunityPageLabelsABAMERList = new ArrayList<String>();

	
	public void OpportunityPageFieldLabelsABAMER() {
		OpportunityPageLabelsABAMERList.add("Opportunity No.");
		OpportunityPageLabelsABAMERList.add("Name");
		OpportunityPageLabelsABAMERList.add("Parent Opportunity");
		OpportunityPageLabelsABAMERList.add("Lead Source");
		OpportunityPageLabelsABAMERList.add("Cross Sell");
		OpportunityPageLabelsABAMERList.add("Confidential Opportunity");
		OpportunityPageLabelsABAMERList.add("Account ID");
		OpportunityPageLabelsABAMERList.add("Location");
		OpportunityPageLabelsABAMERList.add("Priority");
		OpportunityPageLabelsABAMERList.add("Hire Date");
		OpportunityPageLabelsABAMERList.add("Close Date");
		OpportunityPageLabelsABAMERList.add("Migrated Opportunity"); 
		
		OpportunityPageLabelsABAMERList.add("Record Type ID");
		OpportunityPageLabelsABAMERList.add("Assignment Type");
		OpportunityPageLabelsABAMERList.add("Assignment Sub-Type");
		OpportunityPageLabelsABAMERList.add("Specialty Group");
		OpportunityPageLabelsABAMERList.add("Sales Stage");
		OpportunityPageLabelsABAMERList.add("Phase");
		OpportunityPageLabelsABAMERList.add("Probability (%)");
		OpportunityPageLabelsABAMERList.add("On Hold");
		OpportunityPageLabelsABAMERList.add("On Hold Date");
		OpportunityPageLabelsABAMERList.add("On Hold Comments");

		OpportunityPageLabelsABAMERList.add("Estimated Gross Fee/Commission");
		OpportunityPageLabelsABAMERList.add("Opportunity Currency");
		
		OpportunityPageLabelsABAMERList.add("Requirement/Building Details");
		OpportunityPageLabelsABAMERList.add("Minimum Total Size");
		OpportunityPageLabelsABAMERList.add("Maximum Total Size");
		OpportunityPageLabelsABAMERList.add("Total Size");
		OpportunityPageLabelsABAMERList.add("Unit of Measure");
		OpportunityPageLabelsABAMERList.add("Total # of Units");
		OpportunityPageLabelsABAMERList.add("Floor Number");
		OpportunityPageLabelsABAMERList.add("Deal IQ URL");
		OpportunityPageLabelsABAMERList.add("Status Comments");
		OpportunityPageLabelsABAMERList.add("Special Economic Zone");
		OpportunityPageLabelsABAMERList.add("Preferred Property Type");
		OpportunityPageLabelsABAMERList.add("Preferred Property Sub-Type");
		OpportunityPageLabelsABAMERList.add("Listing Type");
		OpportunityPageLabelsABAMERList.add("Availability Date");
		OpportunityPageLabelsABAMERList.add("Next Steps");
		
		OpportunityPageLabelsABAMERList.add("Engagement Commencement");
		OpportunityPageLabelsABAMERList.add("Engagement Expiration");
		OpportunityPageLabelsABAMERList.add("% Commission");
		OpportunityPageLabelsABAMERList.add("% Occupied");
		OpportunityPageLabelsABAMERList.add("Outside Broker Company");
		OpportunityPageLabelsABAMERList.add("Outside Broker Name");
		OpportunityPageLabelsABAMERList.add("CBRE Role");
		
		
		OpportunityPageLabelsABAMERList.add("Reason for Loss");
		OpportunityPageLabelsABAMERList.add("Reason Lost Comments");
		OpportunityPageLabelsABAMERList.add("Competitor");
		
		OpportunityPageLabelsABAMERList.add("Owner ID");
		OpportunityPageLabelsABAMERList.add("Change Opportunity Owner");
		/*OpportunityPageLabelsABAMERList.add("Last Manually Modified By");
		OpportunityPageLabelsABAMERList.add("Last Manually Modified Date");
		OpportunityPageLabelsABAMERList.add("Date");
		OpportunityPageLabelsABAMERList.add("Time");*/
		OpportunityPageLabelsABAMERList.add("External Deal ID");
		OpportunityPageLabelsABAMERList.add("Source System");
		report.updateTestLog("Verify Opportunity Field Labels", "Opportunity field labels are:::" + OpportunityPageLabelsABAMERList, Status.PASS);

	}
	
	static ArrayList<String> OpportunityPageFieldLabelsAPACList = new ArrayList<String>();
	
	public void OpportunityPageFieldLabelsAPAC() {
		//Opportunity Information
		
		OpportunityPageFieldLabelsAPACList.add("Account Name");
		OpportunityPageFieldLabelsAPACList.add("Opportunity Name");
		OpportunityPageFieldLabelsAPACList.add("Primary Contact");
		OpportunityPageFieldLabelsAPACList.add("Location");
		OpportunityPageFieldLabelsAPACList.add("Lead Source");
		OpportunityPageFieldLabelsAPACList.add("Parent Opportunity");
		OpportunityPageFieldLabelsAPACList.add("Assignment Type");
		OpportunityPageFieldLabelsAPACList.add("Priority");
		OpportunityPageFieldLabelsAPACList.add("Assignment Sub-Type");
		OpportunityPageFieldLabelsAPACList.add("Confidential Opportunity");
		OpportunityPageFieldLabelsAPACList.add("Assignment Sub-Type Reason");
		OpportunityPageFieldLabelsAPACList.add("Property Use"); 
		OpportunityPageFieldLabelsAPACList.add("Opportunity Details");
		OpportunityPageFieldLabelsAPACList.add("Status Comments");
		
	    //Financial Details / Sales Stages
		
		
		OpportunityPageFieldLabelsAPACList.add("Estimated Gross Fee/Commission");
		OpportunityPageFieldLabelsAPACList.add("Close Date");
		OpportunityPageFieldLabelsAPACList.add("Sales Stage");
		OpportunityPageFieldLabelsAPACList.add("On Hold");
		OpportunityPageFieldLabelsAPACList.add("Probability (%)");
		OpportunityPageFieldLabelsAPACList.add("On Hold Comments");
		OpportunityPageFieldLabelsAPACList.add("Opportunity Currency");
		
		
		//Pursuit/Appointment Information
		
		OpportunityPageFieldLabelsAPACList.add("Submission Date");
		OpportunityPageFieldLabelsAPACList.add("Pursuit LOBs");
		OpportunityPageFieldLabelsAPACList.add("Outcome Date");
		OpportunityPageFieldLabelsAPACList.add("RFP");		
		OpportunityPageFieldLabelsAPACList.add("Win / Loss");
		OpportunityPageFieldLabelsAPACList.add("Appointment Type");
		OpportunityPageFieldLabelsAPACList.add("Likelihood of Winning");
		
		
		//Requirements
		OpportunityPageFieldLabelsAPACList.add("Preferred Property Type");
		OpportunityPageFieldLabelsAPACList.add("Desired Commencement");
		OpportunityPageFieldLabelsAPACList.add("Preferred Property Sub-Type");
		OpportunityPageFieldLabelsAPACList.add("Existing Lease Expiration");
		OpportunityPageFieldLabelsAPACList.add("Total Size");
		OpportunityPageFieldLabelsAPACList.add("Existing Termination/Break Option");
		OpportunityPageFieldLabelsAPACList.add("Unit of Measure");
		OpportunityPageFieldLabelsAPACList.add("Japan Existing Lease Type");
		OpportunityPageFieldLabelsAPACList.add("Total # of Units");	
		OpportunityPageFieldLabelsAPACList.add("Japan Area Code");	
		OpportunityPageFieldLabelsAPACList.add("Unit of Comparison");	
		OpportunityPageFieldLabelsAPACList.add("Japan Sub-Area Code 1");	
		OpportunityPageFieldLabelsAPACList.add("Special Economic Zone");	
		OpportunityPageFieldLabelsAPACList.add("Japan Sub-Area Code 2");	
		OpportunityPageFieldLabelsAPACList.add("Japan Sub-Area Code 3");
		
		//Close Information
		OpportunityPageFieldLabelsAPACList.add("Lease From");	
		OpportunityPageFieldLabelsAPACList.add("Lease Term (Months)");	
		OpportunityPageFieldLabelsAPACList.add("Lease To");	
		OpportunityPageFieldLabelsAPACList.add("CBRE Role");	
		OpportunityPageFieldLabelsAPACList.add("Lease Rate/Rent");	
		OpportunityPageFieldLabelsAPACList.add("Japan Lease Type");	
		OpportunityPageFieldLabelsAPACList.add("Lease Rate/Rent BasisThis");	
		OpportunityPageFieldLabelsAPACList.add("Remarks");	
		OpportunityPageFieldLabelsAPACList.add("Target Property");	
		
		
		//Loss/Cancel Information
		OpportunityPageFieldLabelsAPACList.add("Reason for Loss");	
		OpportunityPageFieldLabelsAPACList.add("Competitor");	
		OpportunityPageFieldLabelsAPACList.add("Reason Lost Comments");	
		
		
	}
	
	
	public void validateNewOpportunityPage() {
		List<String> opportunityHeaders = null;
		List<String> opportunityHeadersList = new ArrayList<String>();
		if(dataTable.getData("General_Data", "TC_ID").contains("ABAMER")) {
			OpportunityPageHeadersABAMER();
			String[] recordID = {"012i0000001622CAAQ"};
			opportunityHeaders = establishConnection.establishMetaDataConnectionPageHeaders("Opportunity", recordID);
			opportunityHeadersList = Utility_Functions.xValidatePickListValuesPage(OpportunityPageHeadersABAMERList, opportunityHeaders, "Opportunity page Header values");
		} else if(dataTable.getData("General_Data", "TC_ID").contains("OBAMER")) {
			OpportunityPageHeadersOBAMERList();
			String[] recordID = {"012i0000000405nAAA"};
			opportunityHeaders = establishConnection.establishMetaDataConnectionPageHeaders("Opportunity", recordID);
			opportunityHeadersList = Utility_Functions.xValidatePickListValuesPage(opportunityHeaders, opportunityHeaders, "Opportunity page Header values");
		} else if(dataTable.getData("General_Data", "TC_ID").contains("CMAMERPS")) {
			String[] recordID = {"012i0000000405kAAA"};
			OpportunityPageHeadersCapitalMarkets();
			opportunityHeaders = establishConnection.establishMetaDataConnectionPageHeaders("Opportunity", recordID);
			opportunityHeadersList = Utility_Functions.xValidatePickListValuesPage(OpportunityPageHeadersCapitalMarkets, opportunityHeaders, "Opportunity page Header values");
		} else if(dataTable.getData("General_Data", "TC_ID").contains("CMAMER")) {
			String[] recordID = {"012i0000000405lAAA"};
			OpportunityPageHeadersCapitalMarkets();
			opportunityHeaders = establishConnection.establishMetaDataConnectionPageHeaders("Opportunity", recordID);
			opportunityHeadersList = Utility_Functions.xValidatePickListValuesPage(OpportunityPageHeadersCapitalMarkets, opportunityHeaders, "Opportunity page Header values");
		} else if(dataTable.getData("General_Data", "TC_ID").contains("FRANEMEA")){
			OpportunityPageHeadersFR();
			String[] recordID = {"0121Y000001EVzDQAW"};
			opportunityHeaders = establishConnection.establishMetaDataConnectionPageHeaders("Opportunity", recordID);
			opportunityHeadersList = Utility_Functions.xValidatePickListValuesPage(OpportunityPageHeadersListFR, opportunityHeaders, "Opportunity - FRANEMEA page Header values");
		} else if(dataTable.getData("General_Data", "TC_ID").contains("APACAdmin")) {
			String[] recordID = {"012m000000016cRAAQ"};
			OpportunityPageHeadersAPAC();
			opportunityHeaders = establishConnection.establishMetaDataConnectionPageHeaders("Opportunity", recordID);
			opportunityHeadersList = Utility_Functions.xValidatePickListValuesPage(OpportunityPageHeadersCapitalMarkets, opportunityHeaders, "Opportunity page Header values");
		}
	
		if (opportunityHeadersList.size()!=0) {
			report.updateTestLog("Verify Opportunity Headers", "All the Headers are not present in the Opportunity Page:::" + opportunityHeadersList, Status.FAIL);
		} else {
			report.updateTestLog("Verify Opportunity Headers", "All the Headers are present in the Opportunity Page", Status.PASS);
		}			
		
		List<String> opportunityLabels = null;
		if(dataTable.getData("General_Data", "TC_ID").contains("ABAMER")) {
			opportunityLabels = establishConnection.establishMetaDataConnectionPageLayouts("Opportunity", "Opportunity Layout - Agency Brokerage");
		} else if(dataTable.getData("General_Data", "TC_ID").contains("OBAMER")) {
			opportunityLabels = establishConnection.establishMetaDataConnectionPageLayouts("Opportunity", "Opportunity Layout - Occupier Brokerage");
		} else if(dataTable.getData("General_Data", "TC_ID").contains("CMAMERPS")) {
			opportunityLabels = establishConnection.establishMetaDataConnectionPageLayouts("Opportunity", "Opportunity Layout - Capital Markets Property Sales");
		} else if(dataTable.getData("General_Data", "TC_ID").contains("CMAMER")) {
			opportunityLabels = establishConnection.establishMetaDataConnectionPageLayouts("Opportunity", "Opportunity Layout - Capital Markets Debt & Structured Finance");
		} else if(dataTable.getData("General_Data", "TC_ID").contains("ABAPAC")) {
			opportunityLabels = establishConnection.establishMetaDataConnectionPageLayouts("Opportunity", "Opportunity Layout - Agency Brokerage");
		} else if(dataTable.getData("General_Data", "TC_ID").contains("FRANEMEA")){
			opportunityLabels = establishConnection.establishMetaDataConnectionPageLayouts("Opportunity", "France Transaction Demand Agency Opportunity Layout");
		} else if(dataTable.getData("General_Data", "TC_ID").contains("ASEMEA")){
			opportunityLabels = establishConnection.establishMetaDataConnectionPageLayouts("Opportunity", "EMEA Asset Services Page Layout");
		} else if(dataTable.getData("General_Data", "TC_ID").contains("APACAdmin")){
			opportunityLabels = establishConnection.establishMetaDataConnectionPageLayouts("Opportunity", "APAC Consulting");
		}	
		List<String> opportunityLabelsList = new ArrayList<String>();
		
		if(dataTable.getData("General_Data", "TC_ID").contains("FRANEMEA")) {
			franEMEAOppNewLabelsList();
			opportunityLabelsList = Utility_Functions.xValidatePickListValuesPage(franEMEAOppNewLabels, opportunityLabels, "Opportunity page field values");
			if (opportunityLabelsList.size()!=0) {
				report.updateTestLog("Verify Opportunity Field Labels", "All the labels are not present in the Opportunity Page:::" + opportunityLabelsList, Status.FAIL);
			} else {
				report.updateTestLog("Verify Opportunity Field Labels", "All the labels are present in the Opportunity Page", Status.PASS);
			}
		} else if(dataTable.getData("General_Data", "TC_ID").contains("ASEMEA")){
			ASEMEAOppNewLabelsList();
			opportunityLabelsList = Utility_Functions.xValidatePickListValuesPage(AssetServicesEMEAOppNewLabels, opportunityLabels, "Opportunity page field values");
			if (opportunityLabelsList.size()!=0) {
				report.updateTestLog("Verify Opportunity Field Labels", "All the labels are not present in the Opportunity Page:::" + opportunityLabelsList, Status.FAIL);
			} else {
				report.updateTestLog("Verify Opportunity Field Labels", "All the labels are present in the Opportunity Page", Status.PASS);
			}	
		} else if(dataTable.getData("General_Data", "TC_ID").contains("OBAMER")) {
			OpportunityPageFieldLabelsOBAMER();
			opportunityLabelsList = Utility_Functions.xValidatePickListValuesPage(OpportunityPageLabelsOBAMERList, opportunityLabels, "Opportunity page field values");
			if (opportunityLabelsList.size()!=0) {
				report.updateTestLog("Verify Opportunity Field Labels", "All the labels are not present in the Opportunity Page:::" + opportunityLabelsList, Status.FAIL);
			} else {
				report.updateTestLog("Verify Opportunity Field Labels", "All the labels are present in the Opportunity Page", Status.PASS);
			}			
		} else if(dataTable.getData("General_Data", "TC_ID").contains("ABAMER")) {
			OpportunityPageFieldLabelsABAMER();
			opportunityLabelsList = Utility_Functions.xValidatePickListValuesPage(OpportunityPageLabelsABAMERList, opportunityLabels, "Opportunity page field values");
			if (opportunityLabelsList.size()!=0) {
				report.updateTestLog("Verify Opportunity Field Labels", "All the labels are not present in the Opportunity Page:::" + opportunityLabelsList, Status.FAIL);
			} else {
				report.updateTestLog("Verify Opportunity Field Labels", "All the labels are present in the Opportunity Page", Status.PASS);
			}
		} else if(dataTable.getData("General_Data", "TC_ID").contains("CMAMER")) {
			OpportunityPageFieldLabelsCMAMER();
			opportunityLabelsList = Utility_Functions.xValidatePickListValuesPage(OpportunityPageLabelsCMAMERList, opportunityLabels, "Opportunity page field values");
			if (opportunityLabelsList.size()!=0) {
				report.updateTestLog("Verify Opportunity Field Labels", "All the labels are not present in the Opportunity Page:::" + opportunityLabelsList, Status.FAIL);
			} else {
				report.updateTestLog("Verify Opportunity Field Labels", "All the labels are present in the Opportunity Page", Status.PASS);
			}
		} else if(dataTable.getData("General_Data", "TC_ID").contains("APACAdmin")) {
			System.out.println(opportunityLabels);
			OpportunityPageFieldLabelsAPAC();
			
			opportunityLabelsList = Utility_Functions.xValidatePickListValuesPage(OpportunityPageFieldLabelsAPACList, opportunityLabels, "Opportunity page field values");
			if (opportunityLabelsList.size()!=0) {
				report.updateTestLog("Verify Opportunity Field Labels", "All the labels are not present in the Opportunity Page:::" + opportunityLabelsList, Status.FAIL);
			} else {
				report.updateTestLog("Verify Opportunity Field Labels", "All the labels are present in the Opportunity Page", Status.PASS);
			}
		}
	}
	
	
	/**
	 * Verify the custom Opportunity page layout from a Manager profile
	 * 
	 * @author Vishnuvardhan
	 *
	 */

	static ArrayList<String> quickCreateLabelListSection = new ArrayList<String>();

	public void quickCreateLabelListSection() {
		quickCreateLabelListSection.add("*Account Name");
		quickCreateLabelListSection.add("*Assignment Type");
		quickCreateLabelListSection.add("Assignment Sub-Type");
		quickCreateLabelListSection.add("Lead Source");
		quickCreateLabelListSection.add("*Close Date");
		quickCreateLabelListSection.add("Total Size");
		quickCreateLabelListSection.add("Unit of Measure");
		quickCreateLabelListSection.add("*Opportunity Name");
		quickCreateLabelListSection.add("*Sales Stage");
		quickCreateLabelListSection.add("*Phase");
		quickCreateLabelListSection.add("*Probability (%)");
		quickCreateLabelListSection.add("Estimated Gross Fee/Commission");
		quickCreateLabelListSection.add("*Currency");
		System.out.println("Quick Create Label List:::" + quickCreateLabelListSection);
	}

	static ArrayList<String> opportunityInformationLabelList = new ArrayList<String>();

	public void opportunityInformationLabelList() {
		opportunityInformationLabelList.add("Specialty Group");
		opportunityInformationLabelList.add("Parent Opportunity");
		opportunityInformationLabelList.add("Cross Sell");
		opportunityInformationLabelList.add("Confidential Opportunity");
		opportunityInformationLabelList.add("Priority");
		opportunityInformationLabelList.add("Hire Date");
		System.out.println("Opportunity Information Label List:::" + opportunityInformationLabelList);
	}

	static ArrayList<String> opportunityInformationLabelListOBAMER = new ArrayList<String>();

	public void opportunityInformationLabelListOBAMER() {
		opportunityInformationLabelListOBAMER.add("Specialty Group");
		opportunityInformationLabelListOBAMER.add("Parent Opportunity");
		opportunityInformationLabelListOBAMER.add("Cross Sell");
		opportunityInformationLabelListOBAMER.add("Confidential Opportunity");
		opportunityInformationLabelListOBAMER.add("Opportunity Location");
		opportunityInformationLabelListOBAMER.add("Priority");
		opportunityInformationLabelListOBAMER.add("Hire Date");
		opportunityInformationLabelListOBAMER.add("Migrated Opportunity");
		System.out.println("Opportunity Information Label List:::" + opportunityInformationLabelListOBAMER);
	}

	static ArrayList<String> dealMetricsLabelList = new ArrayList<String>();

	public void dealMetricsLabelList() {
		dealMetricsLabelList.add("Investment Profile");
		dealMetricsLabelList.add("Total # of Units");
		dealMetricsLabelList.add("Unit of Comparison");
		dealMetricsLabelList.add("Opportunity Details");
		dealMetricsLabelList.add("Listing Price");
		dealMetricsLabelList.add("Listing Expiration");
		dealMetricsLabelList.add("Portfolio");
		dealMetricsLabelList.add("Development");
		dealMetricsLabelList.add("Preferred Property Type");
		dealMetricsLabelList.add("Preferred Property Sub-Type");
		System.out.println("Opportunity dealMetricsLabelList are:::" + dealMetricsLabelList);
		// h2[text()='Deal Metrics']/parent::div/parent::div//label
	}

	static ArrayList<String> financialInformationLabelList = new ArrayList<String>();

	public void financialInformationLabelList() {
		financialInformationLabelList.add("Estimated Transaction Value");
		financialInformationLabelList.add("Status Comments");
		financialInformationLabelList.add("Yield (%)");
		financialInformationLabelList.add("Yield Type");
		financialInformationLabelList.add("Next Steps");
		System.out.println("Opportunity financialInformationLabelList are:::" + financialInformationLabelList);
		// h2[text()='Financial Information']/parent::div/parent::div//label
	}

	static ArrayList<String> closeInformationLabelList = new ArrayList<String>();

	public void closeInformationLabelList() {
		closeInformationLabelList.add("Final Transaction Value");
		closeInformationLabelList.add("Actual CBRE Gross Fee");
		closeInformationLabelList.add("Yield (%)");
		closeInformationLabelList.add("Actual Yield Type");
		closeInformationLabelList.add("Total Property Value");
		closeInformationLabelList.add("Pitch Approved");
		closeInformationLabelList.add("Pitch Caveat");
		closeInformationLabelList.add("Press Approved");
		closeInformationLabelList.add("Press Caveat");
		closeInformationLabelList.add("Close comments");
		System.out.println("Opportunity closeInformationLabelList are:::" + closeInformationLabelList);
		// h2[text()='Close Information']/parent::div/parent::div//label
	}

	static ArrayList<String> closeInformationLabelListOBAMER = new ArrayList<String>();

	public void closeInformationLabelListOBAMER() {
		closeInformationLabelListOBAMER.add("Lease From");
		closeInformationLabelListOBAMER.add("Lease To");
		closeInformationLabelListOBAMER.add("Lease Term (Months)");
		closeInformationLabelListOBAMER.add("Lease Rate/Rent");
		closeInformationLabelListOBAMER.add("Lease Rate/Rent Basis");
		closeInformationLabelListOBAMER.add("Outside Broker Company");
		closeInformationLabelListOBAMER.add("Outside Broker Name");
		closeInformationLabelListOBAMER.add("CBRE Role");
		closeInformationLabelListOBAMER.add("Sub Lease");
		System.out.println("Opportunity closeInformationLabelList are:::" + closeInformationLabelListOBAMER);
		// h2[text()='Close Information']/parent::div/parent::div//label
	}

	static ArrayList<String> lossInformationLabelList = new ArrayList<String>();

	public void lossInformationLabelList() {
		lossInformationLabelList.add("Reason for Loss");
		lossInformationLabelList.add("Reason Lost Comments");
		lossInformationLabelList.add("Competitor");
		lossInformationLabelList.add("Opportunity Owner");
		lossInformationLabelList.add("External Deal ID");
		System.out.println("Opportunity lossInformationLabelList are:::" + lossInformationLabelList);
		// h2[text()='Loss Information']/parent::div/parent::div//label
	}

	static ArrayList<String> additionalInformationLabelList = new ArrayList<String>();

	public void additionalInformationLabelList() {
		additionalInformationLabelList.add("Total # of Units");
		additionalInformationLabelList.add("Unit of Comparison");
		additionalInformationLabelList.add("Status Comments");
		additionalInformationLabelList.add("Desired Commencement");
		additionalInformationLabelList.add("Existing Lease Expiration");
		additionalInformationLabelList.add("Existing Termination/Break Option");
		additionalInformationLabelList.add("New Termination/Break Option");
		additionalInformationLabelList.add("Next Steps");
		System.out.println("Opportunity additionalInformationLabelList are:::" + additionalInformationLabelList);
		// h2[text()='Loss Information']/parent::div/parent::div//label
	}

	static ArrayList<String> servicesLabelList = new ArrayList<String>();

	public void servicesLabelList() {
		servicesLabelList.add("Opportunity Record Type");
		servicesLabelList.add("Opportunity Team Members");
		servicesLabelList.add("On Hold");
		servicesLabelList.add("On Hold Date");
		servicesLabelList.add("On Hold Comments");
		System.out.println("Opportunity additionalInformationLabelList are:::" + servicesLabelList);
		// h2[text()='Loss Information']/parent::div/parent::div//label
	}

	public void customOpportunityPageLayout() {
		opportunitiesPage.selectNewOpportunity();
		Utility_Functions.timeWait(2);
		try {
			Utility_Functions.xSwitchtoFrame(driver, continueButton);
			Utility_Functions.xWaitForElementPresent(driver, continueButton, 5);
			Utility_Functions.xClick(driver, continueButton, true);
		} catch (Exception e1) {
			e1.printStackTrace();
		}
		driver.switchTo().defaultContent();
		Utility_Functions.xSwitchtoFrame(driver, viewAllFieldsButton);
		Utility_Functions.xWaitForElementPresent(driver, viewAllFieldsButton, 5);
		Utility_Functions.xScrollWindow(driver);
		Utility_Functions.xClick(driver, viewAllFieldsButton, true);
		Utility_Functions.timeWait(1);
		Utility_Functions.xScrollWindowTop(driver);
		quickCreateLabelListSection();
		opportunityInformationLabelList();
		opportunityInformationLabelListOBAMER();
		dealMetricsLabelList();
		financialInformationLabelList();
		closeInformationLabelList();
		closeInformationLabelListOBAMER();
		lossInformationLabelList();
		additionalInformationLabelList();
		servicesLabelList();

		try {
			Utility_Functions.xWaitForElementPresent(driver, labelListOpportunitiesPage, 3);
			int i1 = 0, j = 0, countLabelList = 0;
			String[] labelTexts = new String[labelListOpportunitiesPage.size()];
			while (countLabelList != 13) {
				while (j < quickCreateLabelListSection.size()) {
					for (WebElement element : labelListOpportunitiesPage) {
						labelTexts[i1] = element.getText();
						if (labelTexts[i1].contains(quickCreateLabelListSection.get(j))) {
							System.out.println("Verify Add Opportunity Page Label List" + element.getText());
							report.updateTestLog("Verify Add Opportunity Page Label List",
									element.getText() + "::::label list is present in Add Opportunity Page",
									Status.PASS);
							countLabelList++;
						}
						i1++;
					}
					i1 = 0;
					j++;
				}
			}
			System.out.println("OpportunityInformationList:::" + countLabelList);
			if (countLabelList == 13) {
				report.updateTestLog("Verify Quick Create Section", "Labels are present in Add Opportunity Page:::",
						Status.PASS);
			} else {
				report.updateTestLog("Verify Quick Create Section", "Labels are not present in Add Opportunity Page:::",
						Status.FAIL);
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		if (dataTable.getData("General_Data", "TC_ID").contains("CMAMER")) {
			List<WebElement> opportunityInformationList = driver.findElements(By.xpath(
					"//h2[text()='Opportunity Information']/parent::div/parent::div//*[@class='slds-form-element__label']"));
			try {
				int i2 = 0, count = 0;
				String[] opportunityInfoTexts = new String[opportunityInformationList.size()];
				for (WebElement element : opportunityInformationList) {
					opportunityInfoTexts[i2] = element.getText();
					if (opportunityInfoTexts[i2].equalsIgnoreCase(opportunityInformationLabelList.get(i2))) {
						count++;
						System.out.println("Verify Opportunity Information Section" + element.getText());
						report.updateTestLog("Verify Opportunity Information Section",
								element.getText() + " label is present on the page", Status.PASS);
					}
					i2++;
				}
				System.out.println("OpportunityInformationList:::" + count);
				if (count == 6) {
					report.updateTestLog("Verify Opportunity Information Section",
							"Labels are present in Add Opportunity Page:::", Status.PASS);
				} else {
					report.updateTestLog("Verify Opportunity Information Section",
							"Labels are not present in Add Opportunity Page:::", Status.FAIL);
				}
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		} else if (dataTable.getData("General_Data", "TC_ID").contains("OBAMER")) {
			List<WebElement> opportunityInformationList = driver.findElements(By.xpath(
					"//h2[text()='Opportunity Information']/parent::div/parent::div//*[@class='slds-form-element__label']"));
			try {
				int i2 = 0, count = 0;
				String[] opportunityInfoTexts = new String[opportunityInformationLabelListOBAMER.size()];
				for (WebElement element : opportunityInformationList) {
					opportunityInfoTexts[i2] = element.getText();
					if (opportunityInfoTexts[i2].equalsIgnoreCase(opportunityInformationLabelListOBAMER.get(i2))) {
						count++;
						System.out.println("Verify Opportunity Information Section" + element.getText());
						report.updateTestLog("Verify Opportunity Information Section",
								element.getText() + " label is present on the page", Status.PASS);
					}
					i2++;
				}
				System.out.println("opportunityInformationLabelListOBAMER:::" + count);
				if (count == 8) {
					report.updateTestLog("Verify Opportunity Information Section",
							"Labels are present in Add Opportunity Page:::", Status.PASS);
				} else {
					report.updateTestLog("Verify Opportunity Information Section",
							"Labels are not present in Add Opportunity Page:::", Status.FAIL);
				}
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}

		if (dataTable.getData("General_Data", "TC_ID").contains("OBAMER")) {
			List<WebElement> servicesListPath = driver.findElements(
					By.xpath("//h2[text()='Services']/parent::div/parent::div//*[@class='slds-form-element__label']"));
			try {
				int i2 = 0, count = 0;
				String[] opportunityInfoTexts = new String[servicesLabelList.size()];
				for (WebElement element : servicesListPath) {
					opportunityInfoTexts[i2] = element.getText();
					if (opportunityInfoTexts[i2].equalsIgnoreCase(servicesLabelList.get(i2))) {
						count++;
						System.out.println("Verify Opportunity Information Section" + element.getText());
						report.updateTestLog("Verify Opportunity Information Section",
								element.getText() + " label is present on the page", Status.PASS);
					}
					i2++;
				}
				System.out.println("ServicesLabelList:::" + count);
				if (count == 5) {
					report.updateTestLog("Verify Opportunity Information Section",
							"Labels are present in Add Opportunity Page:::", Status.PASS);
				} else {
					report.updateTestLog("Verify Opportunity Information Section",
							"Labels are not present in Add Opportunity Page:::", Status.FAIL);
				}
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}

			List<WebElement> additionalInformationPath = driver.findElements(By.xpath(
					"//h2[text()='Additional Information']/parent::div/parent::div//*[@class='slds-form-element__label']"));
			try {
				int i2 = 0, count = 0;
				String[] opportunityInfoTexts = new String[additionalInformationLabelList.size()];
				for (WebElement element : additionalInformationPath) {
					opportunityInfoTexts[i2] = element.getText();
					if (opportunityInfoTexts[i2].equalsIgnoreCase(additionalInformationLabelList.get(i2))) {
						count++;
						System.out.println("Verify Opportunity Information Section" + element.getText());
						report.updateTestLog("Verify Opportunity Information Section",
								element.getText() + " label is present on the page", Status.PASS);
					}
					i2++;
				}
				System.out.println("AdditionalInformationLabelList:::" + count);
				if (count == 8) {
					report.updateTestLog("Verify Opportunity Information Section",
							"Labels are present in Add Opportunity Page:::", Status.PASS);
				} else {
					report.updateTestLog("Verify Opportunity Information Section",
							"Labels are not present in Add Opportunity Page:::", Status.FAIL);
				}
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}

		if (dataTable.getData("General_Data", "TC_ID").contains("CMAMER")) {
			List<WebElement> dealMetricsPath = driver.findElements(By.xpath(
					"//h2[text()='Deal Metrics']/parent::div/parent::div//*[@class='slds-form-element__label']"));
			try {
				int i2 = 0, count = 0;
				String[] dealMetricsTexts = new String[dealMetricsLabelList.size()];
				for (WebElement element : dealMetricsPath) {
					dealMetricsTexts[i2] = element.getText();
					if (dealMetricsTexts[i2].equalsIgnoreCase(dealMetricsLabelList.get(i2))) {
						count++;
						System.out.println("Verify Deal Metrics Section" + element.getText());
						report.updateTestLog("Verify Deal Metrics Section",
								element.getText() + " label is present on the page", Status.PASS);
					}
					i2++;
				}
				System.out.println("DealMetricsPath:::" + count);
				if (count == 10) {
					report.updateTestLog("Verify Deal Metrics Section", "Labels are present in Add Opportunity Page:::",
							Status.PASS);
				} else {
					report.updateTestLog("Verify Deal Metrics Section",
							"Labels are not present in Add Opportunity Page:::", Status.FAIL);
				}
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}

		}

		if (dataTable.getData("General_Data", "TC_ID").contains("CMAMER")) {
			List<WebElement> financialInformationPath = driver.findElements(By.xpath(
					"//h2[text()='Financial Information']/parent::div/parent::div//*[@class='slds-form-element__label']"));
			try {
				int i2 = 0, count = 0;
				String[] financialInformationTexts = new String[financialInformationLabelList.size()];
				for (WebElement element : financialInformationPath) {
					financialInformationTexts[i2] = element.getText();
					if (financialInformationTexts[i2].equalsIgnoreCase(financialInformationLabelList.get(i2))) {
						count++;
						System.out.println("Verify Financial Information Section" + element.getText());
						report.updateTestLog("Verify Financial Information Section",
								element.getText() + " label is present on the page", Status.PASS);
					}
					i2++;
				}
				System.out.println("FinancialInformationPath:::" + count);
				if (count == 5) {
					report.updateTestLog("Verify Financial Information Section",
							"Labels are present in Add Opportunity Page:::", Status.PASS);
				} else {
					report.updateTestLog("Verify Financial Information Section",
							"Labels are not present in Add Opportunity Page:::", Status.FAIL);
				}
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}

		}
		if (dataTable.getData("General_Data", "TC_ID").contains("CMAMER")) {
			List<WebElement> closeInformationPath = driver.findElements(By.xpath(
					"//h2[text()='Close Information']/parent::div/parent::div//*[@class='slds-form-element__label']"));
			try {
				int i2 = 0, count = 0;
				String[] closeInformationTexts = new String[closeInformationLabelList.size()];
				for (WebElement element : closeInformationPath) {
					closeInformationTexts[i2] = element.getText();
					if (closeInformationTexts[i2].equalsIgnoreCase(closeInformationLabelList.get(i2))) {
						count++;
						System.out.println("Verify Close Information Section" + element.getText());
						report.updateTestLog("Verify Close Information Section",
								element.getText() + " label is present on the page", Status.PASS);
					}
					i2++;
				}
				System.out.println("CloseInformationPath:::" + count);
				if (count == 10) {
					report.updateTestLog("Verify Close Information Section",
							"Labels are present in Add Opportunity Page:::", Status.PASS);
				} else {
					report.updateTestLog("Verify Close Information Section",
							"Labels are not present in Add Opportunity Page:::", Status.FAIL);
				}
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		} else if (dataTable.getData("General_Data", "TC_ID").contains("OBAMER")) {
			List<WebElement> closeInformationPath = driver.findElements(By.xpath(
					"//h2[text()='Close Information']/parent::div/parent::div//*[@class='slds-form-element__label']"));
			try {
				int i2 = 0, count = 0;
				String[] closeInformationTexts = new String[closeInformationLabelListOBAMER.size()];
				for (WebElement element : closeInformationPath) {
					closeInformationTexts[i2] = element.getText();
					if (closeInformationTexts[i2].equalsIgnoreCase(closeInformationLabelListOBAMER.get(i2))) {
						count++;
						System.out.println("Verify Close Information Section" + element.getText());
						report.updateTestLog("Verify Close Information Section",
								element.getText() + " label is present on the page", Status.PASS);
					}
					i2++;
				}
				System.out.println("CloseInformationPath:::" + count);
				if (count == 9) {
					report.updateTestLog("Verify Close Information Section",
							"Labels are present in Add Opportunity Page:::", Status.PASS);
				} else {
					report.updateTestLog("Verify Close Information Section",
							"Labels are not present in Add Opportunity Page:::", Status.FAIL);
				}
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}

		List<WebElement> lossInformationPath = driver.findElements(By.xpath(
				"//h2[text()='Loss Information']/parent::div/parent::div//*[@class='slds-form-element__label']"));
		try {
			int i2 = 0, count = 0;
			String[] lossInformationTexts = new String[lossInformationLabelList.size()];
			for (WebElement element : lossInformationPath) {
				lossInformationTexts[i2] = element.getText();
				if (lossInformationTexts[i2].equalsIgnoreCase(lossInformationLabelList.get(i2))) {
					count++;
					System.out.println("Verify Loss Information Section" + element.getText());
					report.updateTestLog("Verify Loss Information Section",
							element.getText() + " label is present on the page", Status.PASS);
				}
				i2++;
			}
			System.out.println("LossInformationPath:::" + count);
			if (count == 5) {
				report.updateTestLog("Verify Loss Information Section", "Labels are present in Add Opportunity Page:::",
						Status.PASS);
			} else {
				report.updateTestLog("Verify Loss Information Section",
						"Labels are not present in Add Opportunity Page:::", Status.FAIL);
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	/**
	 * Validating the Opportunities Quick create page
	 * 
	 * @author Ramya
	 *
	 */
	static ArrayList<String> opportunityInformationFieldsList = new ArrayList<String>();

	public void opportunityInformationFields() {

		opportunityInformationFieldsList.add("*Opportunity Name");
		opportunityInformationFieldsList.add("*Account Name");
		opportunityInformationFieldsList.add("EMEA Accounts Only");
		opportunityInformationFieldsList.add("*Estimated Gross Fee/Commission");
		opportunityInformationFieldsList.add("*Close Date");
		opportunityInformationFieldsList.add("Confidential Opportunity");
		opportunityInformationFieldsList.add("*Sales Stage");
		opportunityInformationFieldsList.add("Comments");

		System.out.println("opportunity infomation fields are: " + opportunityInformationFieldsList);
	}

	static ArrayList<String> opportunityInformationFieldsListABEMEABroker = new ArrayList<String>();

	public void opportunityInformationFieldsABEMEABroker() {

		opportunityInformationFieldsListABEMEABroker.add("*Opportunity Name");
		opportunityInformationFieldsListABEMEABroker.add("*Account Name");
		opportunityInformationFieldsListABEMEABroker.add("EMEA Accounts Only");
		opportunityInformationFieldsListABEMEABroker.add("EMEA Accounts Only");
		opportunityInformationFieldsListABEMEABroker.add("*Estimated Gross Fee/Commission");
		opportunityInformationFieldsListABEMEABroker.add("*Close Date");
		opportunityInformationFieldsListABEMEABroker.add("Confidential Opportunity");
		opportunityInformationFieldsListABEMEABroker.add("*Sales Stage");

		System.out.println("opportunity infomation fields are: " + opportunityInformationFieldsListABEMEABroker);
	}

	static ArrayList<String> opportunityInformationFieldsListVASEMEABroker = new ArrayList<String>();

	public void opportunityInformationFieldsListVASEMEABroker() {

		opportunityInformationFieldsListVASEMEABroker.add("*Opportunity Name");
		opportunityInformationFieldsListVASEMEABroker.add("*Account Name");
		opportunityInformationFieldsListVASEMEABroker.add("EMEA Accounts Only");
		opportunityInformationFieldsListVASEMEABroker.add("EMEA Accounts Only");
		opportunityInformationFieldsListVASEMEABroker.add("*Estimated Gross Fee/Commission");
		opportunityInformationFieldsListVASEMEABroker.add("*Close Date");
		opportunityInformationFieldsListVASEMEABroker.add("Confidential Opportunity");
		opportunityInformationFieldsListVASEMEABroker.add("*Sales Stage");
		opportunityInformationFieldsListVASEMEABroker.add("Conversion Type");
		opportunityInformationFieldsListVASEMEABroker.add("Comments");
		opportunityInformationFieldsListVASEMEABroker.add("Risk");

		System.out.println("Opportunity infomation fields are: " + opportunityInformationFieldsListVASEMEABroker);
	}

	static ArrayList<String> additionalInformationFieldsList = new ArrayList<String>();

	public void additionalInformationFields() {

		additionalInformationFieldsList.add("Opportunity Owner");
		additionalInformationFieldsList.add("*Opportunity Currency");
		additionalInformationFieldsList.add("Net Fee");
		additionalInformationFieldsList.add("*Probability (%)");
		additionalInformationFieldsList.add("Conversion Type");
		additionalInformationFieldsList.add("Conversion Type Other");
		additionalInformationFieldsList.add("Weighted Net Fee");
		additionalInformationFieldsList.add("Assignment Type");
		additionalInformationFieldsList.add("Assignment Sub-Type");
		additionalInformationFieldsList.add("Address Line 1");
		additionalInformationFieldsList.add("Address Line 2");
		additionalInformationFieldsList.add("Postcode");
		additionalInformationFieldsList.add("Change Opportunity Owner");
		additionalInformationFieldsList.add("Unit of Measure");
		additionalInformationFieldsList.add("Total Size");
		additionalInformationFieldsList.add("Service Line");
		additionalInformationFieldsList.add("Asset Class");
		additionalInformationFieldsList.add("Comments History");
		additionalInformationFieldsList.add("City");
		additionalInformationFieldsList.add("Country");
		additionalInformationFieldsList.add("RFP Submission Date");
		additionalInformationFieldsList.add("Critical Date");

		System.out.println("Additional infomation fields are: " + additionalInformationFieldsList);
	}

	static ArrayList<String> additionalInformationFieldsListCMEMEABroker = new ArrayList<String>();

	public void additionalInformationFieldsCMEMEABroker() {

		additionalInformationFieldsListCMEMEABroker.add("Opportunity Owner");
		additionalInformationFieldsListCMEMEABroker.add("*Opportunity Currency");
		additionalInformationFieldsListCMEMEABroker.add("Net Fee");
		additionalInformationFieldsListCMEMEABroker.add("*Probability (%)");
		additionalInformationFieldsListCMEMEABroker.add("Portfolio Type");
		additionalInformationFieldsListCMEMEABroker.add("Address Line 1");
		additionalInformationFieldsListCMEMEABroker.add("Address Line 2");
		additionalInformationFieldsListCMEMEABroker.add("Postcode");
		additionalInformationFieldsListCMEMEABroker.add("Change Opportunity Owner");
		additionalInformationFieldsListCMEMEABroker.add("Unit of Measure");
		additionalInformationFieldsListCMEMEABroker.add("Total Size");
		additionalInformationFieldsListCMEMEABroker.add("Service Line");
		additionalInformationFieldsListCMEMEABroker.add("Asset Class");
		additionalInformationFieldsListCMEMEABroker.add("Comments");
		additionalInformationFieldsListCMEMEABroker.add("Comments History");
		additionalInformationFieldsListCMEMEABroker.add("City");
		additionalInformationFieldsListCMEMEABroker.add("Country");
		additionalInformationFieldsListCMEMEABroker.add("RFP Submission Date");

		System.out.println("Additional infomation fields are: " + additionalInformationFieldsListCMEMEABroker);
	}

	static ArrayList<String> additionalInformationFieldsListABEMEABroker = new ArrayList<String>();

	public void additionalInformationFieldsABEMEABroker() {

		additionalInformationFieldsListABEMEABroker.add("Opportunity Owner");
		additionalInformationFieldsListABEMEABroker.add("*Opportunity Currency");
		additionalInformationFieldsListABEMEABroker.add("Net Fee");
		additionalInformationFieldsListABEMEABroker.add("*Probability (%)");
		additionalInformationFieldsListABEMEABroker.add("Address Line 1");
		additionalInformationFieldsListABEMEABroker.add("Address Line 2");
		additionalInformationFieldsListABEMEABroker.add("Postcode");
		additionalInformationFieldsListABEMEABroker.add("Change Opportunity Owner");
		additionalInformationFieldsListABEMEABroker.add("Unit of Measure");
		additionalInformationFieldsListABEMEABroker.add("Total Size");
		additionalInformationFieldsListABEMEABroker.add("Service Line");
		additionalInformationFieldsListABEMEABroker.add("Asset Class");
		additionalInformationFieldsListABEMEABroker.add("Comments History");
		additionalInformationFieldsListABEMEABroker.add("City");
		additionalInformationFieldsListABEMEABroker.add("Country");
		additionalInformationFieldsListABEMEABroker.add("RFP Submission Date");
		additionalInformationFieldsListABEMEABroker.add("Critical Date");

		System.out.println("Additional infomation fields are: " + additionalInformationFieldsListABEMEABroker);
	}

	static ArrayList<String> additionalInformationFieldsListVASEMEABroker = new ArrayList<String>();

	public void additionalInformationFieldsVASEMEABroker() {

		additionalInformationFieldsListVASEMEABroker.add("Opportunity Owner");
		additionalInformationFieldsListVASEMEABroker.add("*Opportunity Currency");
		additionalInformationFieldsListVASEMEABroker.add("Net Fee");
		additionalInformationFieldsListVASEMEABroker.add("*Probability (%)");
		additionalInformationFieldsListVASEMEABroker.add("Assignment Type");
		additionalInformationFieldsListVASEMEABroker.add("Assignment Sub-Type");
		additionalInformationFieldsListVASEMEABroker.add("Address Line 1");
		additionalInformationFieldsListVASEMEABroker.add("Address Line 2");
		additionalInformationFieldsListVASEMEABroker.add("Postcode");
		additionalInformationFieldsListVASEMEABroker.add("Change Opportunity Owner");
		additionalInformationFieldsListVASEMEABroker.add("Unit of Measure");
		additionalInformationFieldsListVASEMEABroker.add("Total Size");
		additionalInformationFieldsListVASEMEABroker.add("Service Line");
		additionalInformationFieldsListVASEMEABroker.add("Asset Class");
		additionalInformationFieldsListVASEMEABroker.add("Sub-Asset Type");
		additionalInformationFieldsListVASEMEABroker.add("Comments History");
		additionalInformationFieldsListVASEMEABroker.add("Project Type Description");
		additionalInformationFieldsListVASEMEABroker.add("City");
		additionalInformationFieldsListVASEMEABroker.add("Country");
		additionalInformationFieldsListVASEMEABroker.add("RFP Submission Date");
		additionalInformationFieldsListVASEMEABroker.add("Critical Date");

		System.out.println("Additional infomation fields are: " + additionalInformationFieldsListVASEMEABroker);
	}

	static ArrayList<String> lossInformationFieldsList = new ArrayList<String>();

	public void lossInformationFields() {

		lossInformationFieldsList.add("Reason for Loss");
		lossInformationFieldsList.add("Reason Lost Comments");
		lossInformationFieldsList.add("Competitor");
		lossInformationFieldsList.add("Next Step");

		System.out.println("Loss infomation fields are: " + lossInformationFieldsList);
	}

	static ArrayList<String> dataHugFieldsList = new ArrayList<String>();

	public void dataHugFields() {

		dataHugFieldsList.add("Deal Score");
		dataHugFieldsList.add("Deal Score Reason");
		dataHugFieldsList.add("Best Connected Colleague");
		dataHugFieldsList.add("Last Email Received");
		dataHugFieldsList.add("Last Email Received from");
		dataHugFieldsList.add("Last Email Sent");
		dataHugFieldsList.add("Last Email Sent by");
		dataHugFieldsList.add("Last Meeting");
		dataHugFieldsList.add("Next Meeting");

		System.out.println("Data Hug section fields are: " + dataHugFieldsList);
	}

	static ArrayList<String> systemInformationFieldsList = new ArrayList<String>();

	public void systemInformationFields() {

		systemInformationFieldsList.add("External Deal ID");
		systemInformationFieldsList.add("Opportunity Record Type");

		System.out.println("System infomation fields are: " + systemInformationFieldsList);
	}

	public void opportunityQuickCreatePage() {
		opportunitiesPage.selectNewOpportunity();
		Utility_Functions.timeWait(2);
		if ((dataTable.getData("General_Data", "TC_ID").contains("ABEMEABroker"))) {
			Utility_Functions.xSwitchtoFrame(driver, continueButton);
			Utility_Functions.xWaitForElementPresent(driver, continueButton, 5);
			Utility_Functions.xClick(driver, continueButton, true);
			Utility_Functions.timeWait(2);
		}
		Utility_Functions.xSwitchtoFrame(driver, viewAllFieldsButton);
		Utility_Functions.xWaitForElementPresent(driver, viewAllFieldsButton, 5);
		Utility_Functions.xScrollWindow(driver);
		Utility_Functions.xClick(driver, viewAllFieldsButton, true);
		Utility_Functions.timeWait(5);
		Utility_Functions.xScrollWindowTop(driver);
		if ((dataTable.getData("General_Data", "TC_ID").contains("ABEMEABroker"))) {
			List<WebElement> opportunityInformationSectionList1 = driver.findElements(By.xpath(
					"//h2[text()='Opportunity Information']/parent::div/parent::div//*[@class='slds-form-element__label']"));
			int count19 = 0, i19 = 0;
			String fieldsArray19[] = new String[opportunityInformationSectionList1.size()];
			System.out.println(opportunityInformationSectionList1.size());
			try {
				opportunityInformationFieldsABEMEABroker();
				for (WebElement element19 : opportunityInformationSectionList1) {
					System.out.println(element19.getText());
					fieldsArray19[i19] = element19.getText();
					if (fieldsArray19[i19].equals(opportunityInformationFieldsListABEMEABroker.get(i19))) {
						report.updateTestLog("Verify New Account Page Layout ",
								"Opportunity Information section is having the " + fieldsArray19[i19] + " fields ",
								Status.PASS);
						count19++;
					}
					i19++;
				}
				System.out.println(count19);
				if (count19 != 8) {
					report.updateTestLog("Verify Opportunity Quick Create Page",
							"All fields are not present in the Opportunity Information section ", Status.FAIL);
				} else {

					report.updateTestLog("Verify Opportunity Quick Create Page",
							"All fields are present in the Opportunity Information section", Status.PASS);
				}
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
			opportunityInformationSectionList1.clear();

		} else if ((dataTable.getData("General_Data", "TC_ID").contains("VASEMEABroker"))) {
			List<WebElement> opportunityInformationSectionList3 = driver.findElements(By.xpath(
					"//h2[text()='Opportunity Information']/parent::div/parent::div//*[@class='slds-form-element__label']"));
			int count20 = 0, i20 = 0;
			String fieldsArray20[] = new String[opportunityInformationSectionList3.size()];
			System.out.println(opportunityInformationSectionList3.size());
			try {
				opportunityInformationFieldsListVASEMEABroker();
				for (WebElement element20 : opportunityInformationSectionList3) {
					System.out.println(element20.getText());
					fieldsArray20[i20] = element20.getText();
					if (fieldsArray20[i20].equals(opportunityInformationFieldsListVASEMEABroker.get(i20))) {
						report.updateTestLog("Verify New Account Page Layout ",
								"Opportunity Information section is having the " + fieldsArray20[i20] + " fields ",
								Status.PASS);
						count20++;
					}
					i20++;
				}
				System.out.println(count20);
				if (count20 != 11) {
					report.updateTestLog("Verify Opportunity Quick Create Page",
							"All fields are not present in the Opportunity Information section ", Status.FAIL);
				} else {

					report.updateTestLog("Verify Opportunity Quick Create Page",
							"All fields are present in the Opportunity Information section", Status.PASS);
				}
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}

		} else {
			List<WebElement> opportunityInformationSectionList = driver.findElements(By.xpath(
					"//h2[text()='Opportunity Information']/parent::div/parent::div//*[@class='slds-form-element__label']"));
			int count12 = 0, i12 = 0;
			String fieldsArray12[] = new String[opportunityInformationSectionList.size()];
			System.out.println(opportunityInformationSectionList.size());
			try {
				opportunityInformationFields();
				for (WebElement element12 : opportunityInformationSectionList) {
					System.out.println(element12.getText());
					fieldsArray12[i12] = element12.getText();
					if (fieldsArray12[i12].equals(opportunityInformationFieldsList.get(i12))) {
						report.updateTestLog("Verify New Account Page Layout ",
								"Opportunity Information section is having the " + fieldsArray12[i12] + " fields ",
								Status.PASS);
						count12++;
					}
					i12++;
				}
				System.out.println(count12);
				if (count12 >= 7) {
					report.updateTestLog("Verify Opportunity Quick Create Page",
							"All fields are not present in the Opportunity Information section ", Status.FAIL);
				} else {

					report.updateTestLog("Verify Opportunity Quick Create Page",
							"All fields are present in the Opportunity Information section", Status.PASS);
				}
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
			opportunityInformationSectionList.clear();
		}
		if ((dataTable.getData("General_Data", "TC_ID").contains("CMEMEABroker"))) {
			List<WebElement> additionalInformationSectionList1 = driver.findElements(By.xpath(
					"//h2[text()='Additional Information']/parent::div/parent::div//*[@class='slds-form-element__label']"));
			int count14 = 0, i14 = 0;
			String fieldsArray14[] = new String[additionalInformationSectionList1.size()];
			System.out.println(additionalInformationSectionList1.size());
			try {
				additionalInformationFieldsCMEMEABroker();
				for (WebElement element14 : additionalInformationSectionList1) {
					System.out.println(element14.getText());
					fieldsArray14[i14] = element14.getText();
					if (fieldsArray14[i14].contains(additionalInformationFieldsListCMEMEABroker.get(i14))) {
						report.updateTestLog("Verify New Account Page Layout ",
								"Additional Information section is having the " + fieldsArray14[i14] + " fields ",
								Status.PASS);
						count14++;
					}
					i14++;
				}
				System.out.println(count14);
				if (count14 != 18) {
					report.updateTestLog("Verify Opportunity Quick Create Page",
							"All fields are not present in the Additional Information section ", Status.FAIL);
				} else {

					report.updateTestLog("Verify Opportunity Quick Create Page",
							"All fields are present in the Additional Information section", Status.PASS);
				}
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
			additionalInformationSectionList1.clear();

		} else if ((dataTable.getData("General_Data", "TC_ID").contains("ABEMEABroker"))) {
			List<WebElement> additionalInformationSectionList2 = driver.findElements(By.xpath(
					"//h2[text()='Additional Information']/parent::div/parent::div//*[@class='slds-form-element__label']"));
			int count17 = 0, i17 = 0;
			String fieldsArray17[] = new String[additionalInformationSectionList2.size()];
			System.out.println(additionalInformationSectionList2.size());
			try {
				additionalInformationFieldsABEMEABroker();
				for (WebElement element17 : additionalInformationSectionList2) {
					System.out.println(element17.getText());
					fieldsArray17[i17] = element17.getText();
					if (fieldsArray17[i17].contains(additionalInformationFieldsListABEMEABroker.get(i17))) {
						report.updateTestLog("Verify New Account Page Layout ",
								"Additional Information section is having the " + fieldsArray17[i17] + " fields ",
								Status.PASS);
						count17++;
					}
					i17++;
				}
				System.out.println(count17);
				if (count17 != 17) {
					report.updateTestLog("Verify Opportunity Quick Create Page",
							"All fields are not present in the Additional Information section ", Status.FAIL);
				} else {

					report.updateTestLog("Verify Opportunity Quick Create Page",
							"All fields are present in the Additional Information section", Status.PASS);
				}
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
			additionalInformationSectionList2.clear();

		} else if ((dataTable.getData("General_Data", "TC_ID").contains("VASEMEABroker"))) {
			List<WebElement> additionalInformationSectionList3 = driver.findElements(By.xpath(
					"//h2[text()='Additional Information']/parent::div/parent::div//*[@class='slds-form-element__label']"));
			int count21 = 0, i21 = 0;
			String fieldsArray21[] = new String[additionalInformationSectionList3.size()];
			System.out.println(additionalInformationSectionList3.size());
			try {
				additionalInformationFieldsVASEMEABroker();
				for (WebElement element21 : additionalInformationSectionList3) {
					System.out.println(element21.getText());
					fieldsArray21[i21] = element21.getText();
					if (fieldsArray21[i21].contains(additionalInformationFieldsListVASEMEABroker.get(i21))) {
						report.updateTestLog("Verify New Account Page Layout ",
								"Additional Information section is having the " + fieldsArray21[i21] + " fields ",
								Status.PASS);
						count21++;
					}
					i21++;
				}
				System.out.println(count21);
				if (count21 != 21) {
					report.updateTestLog("Verify Opportunity Quick Create Page",
							"All fields are not present in the Additional Information section ", Status.FAIL);
				} else {

					report.updateTestLog("Verify Opportunity Quick Create Page",
							"All fields are present in the Additional Information section", Status.PASS);
				}
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}

		} else {

			List<WebElement> additionalInformationSectionList = driver.findElements(By.xpath(
					"//h2[text()='Additional Information']/parent::div/parent::div//*[@class='slds-form-element__label']"));
			int count13 = 0, i13 = 0;
			String fieldsArray13[] = new String[additionalInformationSectionList.size()];
			System.out.println(additionalInformationSectionList.size());
			try {
				additionalInformationFields();
				for (WebElement element13 : additionalInformationSectionList) {
					System.out.println(element13.getText());
					fieldsArray13[i13] = element13.getText();
					if (fieldsArray13[i13].contains(additionalInformationFieldsList.get(i13))) {
						report.updateTestLog("Verify New Account Page Layout ",
								"Additional Information section is having the " + fieldsArray13[i13] + " fields ",
								Status.PASS);
						count13++;
					}
					i13++;
				}
				System.out.println(count13);
				if (count13 != 22) {
					report.updateTestLog("Verify Opportunity Quick Create Page",
							"All fields are not present in the Additional Information section ", Status.FAIL);
				} else {

					report.updateTestLog("Verify Opportunity Quick Create Page",
							"All fields are present in the Additional Information section", Status.PASS);
				}
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
			additionalInformationSectionList.clear();
		}
		List<WebElement> lossInformationSectionList = driver.findElements(By.xpath(
				"//h2[text()='Loss Information']/parent::div/parent::div//*[@class='slds-form-element__label']"));
		int count14 = 0, i14 = 0;
		String fieldsArray14[] = new String[lossInformationSectionList.size()];
		System.out.println(lossInformationSectionList.size());
		try {
			lossInformationFields();
			for (WebElement element14 : lossInformationSectionList) {
				System.out.println(element14.getText());
				fieldsArray14[i14] = element14.getText();
				if (fieldsArray14[i14].contains(lossInformationFieldsList.get(i14))) {
					report.updateTestLog("Verify New Account Page Layout ",
							"Loss Information section is having the " + fieldsArray14[i14] + " fields ", Status.PASS);
					count14++;
				}
				i14++;
			}
			System.out.println(count14);
			if (count14 >= 2) {
				report.updateTestLog("Verify Opportunity Quick Create Page",
						"All fields are  present in the Loss Information section ", Status.PASS);
			} else {

				report.updateTestLog("Verify Opportunity Quick Create Page",
						"All fields are not present in the Loss Information section", Status.FAIL);
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		lossInformationSectionList.clear();
		List<WebElement> dataHugSectionList = driver.findElements(By
				.xpath("//h2[text()='DataHug Details']/parent::div/parent::div//*[@class='slds-form-element__label']"));
		int count15 = 0, i15 = 0;
		String fieldsArray15[] = new String[dataHugSectionList.size()];
		System.out.println(dataHugSectionList.size());
		try {
			dataHugFields();
			for (WebElement element15 : dataHugSectionList) {
				System.out.println(element15.getText());
				fieldsArray15[i15] = element15.getText();
				if (fieldsArray15[i15].contains(dataHugFieldsList.get(i15))) {
					report.updateTestLog("Verify New Account Page Layout ",
							"Data Hug section is having the " + fieldsArray15[i15] + " fields ", Status.PASS);
					count15++;
				}
				i15++;
			}
			System.out.println(count15);
			if (count15 != 9) {
				report.updateTestLog("Verify Opportunity Quick Create Page",
						"All fields are not present in the Data Hug section ", Status.FAIL);
			} else {

				report.updateTestLog("Verify Opportunity Quick Create Page",
						"All fields are present in the Data Hug section", Status.PASS);
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		dataHugSectionList.clear();
		if ((dataTable.getData("General_Data", "TC_ID").contains("CMEMEABrokerIP") || (dataTable
				.getData("General_Data", "TC_ID").contains("CMEMEABrokerCA")
				|| (dataTable.getData("General_Data", "TC_ID").contains("CMEMEABrokerBCP")
						|| (dataTable.getData("General_Data", "TC_ID").contains("CMEMEABrokerCA")
								|| (dataTable.getData("General_Data", "TC_ID").contains("CMEMEABrokerDev"))))))) {
			List<WebElement> systemInformationSectionList = driver.findElements(By.xpath(
					"//h2[text()='System Information']/parent::div/parent::div//*[@class='slds-form-element__label']"));
			int count16 = 0, i16 = 0;
			String fieldsArray16[] = new String[systemInformationSectionList.size()];
			System.out.println(systemInformationSectionList.size());
			try {
				systemInformationFields();
				for (WebElement element16 : systemInformationSectionList) {
					System.out.println(element16.getText());
					fieldsArray16[i16] = element16.getText();
					if (fieldsArray16[i16].contains(systemInformationFieldsList.get(i16))) {
						report.updateTestLog("Verify New Account Page Layout ",
								"System Information section is having the " + fieldsArray16[i16] + " fields ",
								Status.PASS);
						count16++;
					}
					i16++;
				}
				System.out.println(count16);
				if (count16 != 2) {
					report.updateTestLog("Verify Opportunity Quick Create Page",
							"All fields are not present in the System Information section ", Status.FAIL);
				} else {

					report.updateTestLog("Verify Opportunity Quick Create Page",
							"All fields are present in the System Information section", Status.PASS);
				}
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}
		Utility_Functions.xWaitForElementPresent(driver, opportunityName, 3);
		Utility_Functions.xSendKeys(driver, opportunityName,
				"Test Automation Opportunity_" + Utility_Functions.xGenerateAlphaNumericString());
		String query = "SELECT Id, Name, EMEA_Searchable__c FROM Account where EMEA_Searchable__c = true limit 1 offset 9";
		String sAccountName = searchTextSOQL.fetchRecordFieldValue("Name", query);
		Utility_Functions.xSendKeys(driver, accountName, sAccountName);
		accountName.sendKeys(Keys.ARROW_DOWN);
		Utility_Functions.timeWait(2);
		accountName.sendKeys(Keys.ENTER);
		Utility_Functions.timeWait(2);
		Utility_Functions.xWaitForElementPresent(driver, estimatedGrossFeeNewOpportunity, 3);
		Utility_Functions.xSendKeys(driver, estimatedGrossFeeNewOpportunity,
				dataTable.getData("General_Data", "InstallmentAmount"));
		Utility_Functions.xWaitForElementPresent(driver, salesStageEMEANewOpportunity, 4);
		Utility_Functions.xClick(driver, salesStageEMEANewOpportunity, true);
		Utility_Functions.xWaitForElementPresent(driver, salesStageEMEANewOpportunityValue, 4);
		Utility_Functions.xClick(driver, salesStageEMEANewOpportunityValue, true);
		System.out.println(Calendar.getInstance());
		DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
		Date date = new Date();
		Utility_Functions.xWaitForElementPresent(driver, closeDateNewOpportunity, 3);
		Utility_Functions.xSendKeys(driver, closeDateNewOpportunity, dateFormat.format(date).toString());
		Utility_Functions.timeWait(2);

		Utility_Functions.xWaitForElementPresent(driver, saveOpportunitySplitUAT, 4);
		Utility_Functions.xClick(driver, saveOpportunitySplitUAT, true);
		Utility_Functions.timeWait(2);
		if (details.isDisplayed()) {

			report.updateTestLog("Verify Quick Create Opportunity Page Discretionary Fee",
					"The opportunity is saved with the Discretionary Fee check box checked and the Discretionary amount ",
					Status.PASS);
		} else {
			report.updateTestLog("Verify Quick Create Opportunity Page Discretionary Fee",
					"The opportunity is not saved with the Discretionary Fee check box checked and the Discretionary amount",
					Status.FAIL);
		}
	}	
	
	/**
	 * Validating the Opportunities page for the Japan users
	 * 
	 * @author Ramya
	 *
	 */
	static ArrayList<String> opportunityInformationValues = new ArrayList<String>();

	public void opportunityInformation() {

		opportunityInformationValues.add("Opportunity Name");
		opportunityInformationValues.add("Account Name");
		opportunityInformationValues.add("Lead Source");
		opportunityInformationValues.add("Primary Contact");
		opportunityInformationValues.add("Assignment Type");
		opportunityInformationValues.add("Close Date");
		opportunityInformationValues.add("Assignment Sub-Type");
		opportunityInformationValues.add("Opportunity Location");
		opportunityInformationValues.add("Status Comments");
		opportunityInformationValues.add("Confidential Opportunity");
		opportunityInformationValues.add("HNI Transaction");
		opportunityInformationValues.add("Parent Opportunity");

		System.out.println("The values for the Opportunity Information section are " + opportunityInformationValues);

	}

	static ArrayList<String> financialDetailsStagesValues = new ArrayList<String>();

	public void financialDetails() {

		financialDetailsStagesValues.add("Estimated Gross Fee/Commission");
		financialDetailsStagesValues.add("Sales Stage");
		financialDetailsStagesValues.add("Estimated Transaction Value");
		financialDetailsStagesValues.add("Opportunity Currency");
		financialDetailsStagesValues.add("On Hold");
		financialDetailsStagesValues.add("On Hold Comments");

		System.out.println("The labels for the financial detials section are " + financialDetailsStagesValues);

	}

	static ArrayList<String> opportunityDetailsValues = new ArrayList<String>();

	public void opportunityDetails() {

		opportunityDetailsValues.add("Target Property");
		opportunityDetailsValues.add("Total Size");
		opportunityDetailsValues.add("Opportunity Details");
		opportunityDetailsValues.add("Unit of Measure");
		opportunityDetailsValues.add("Deal Tenure (in Months)");
		opportunityDetailsValues.add("Total # of Units");
		opportunityDetailsValues.add("Principal Moratorium (in Months)");
		opportunityDetailsValues.add("Unit of Comparison");
		opportunityDetailsValues.add("Interest Moratorium (in Months)");
		opportunityDetailsValues.add("Property Approval Status (India)");
		opportunityDetailsValues.add("Total Built-up Area");
		opportunityDetailsValues.add("Proposed Land Use");

		System.out.println("The labels for the Opportunity Details section are " + opportunityDetailsValues);

	}

	static ArrayList<String> appointmentInformationValues = new ArrayList<String>();

	public void appointmentInformation() {

		appointmentInformationValues.add("Appointment Type");
		appointmentInformationValues.add("Agency Start Date");
		appointmentInformationValues.add("Agency Expiry Date");

		System.out.println("The labels for the appointment Information section are " + appointmentInformationValues);

	}

	static ArrayList<String> closeInformationValues = new ArrayList<String>();

	public void closeInformation() {

		closeInformationValues.add("Counterpart Account");
		closeInformationValues.add("Yield (%)");
		closeInformationValues.add("Counterpart Role");
		closeInformationValues.add("Yield/Return Type");
		closeInformationValues.add("Settlement/Completion Date");
		closeInformationValues.add("CBRE Role");
		closeInformationValues.add("Buyer Confidentiality Agreement Signed");
		closeInformationValues.add("Stake Diluted (%)");
		closeInformationValues.add("Close Comments");

		System.out.println("The labels for the close information section are " + closeInformationValues);

	}

	static ArrayList<String> lossInformationValues = new ArrayList<String>();

	public void lossInformation() {

		lossInformationValues.add("Reason for Loss");
		lossInformationValues.add("Competitor");
		lossInformationValues.add("Reason Lost Comments");

		System.out.println("The labels for the Loss Information section are " + lossInformationValues);

	}

	static ArrayList<String> systemInformationSectionValues = new ArrayList<String>();

	public void systemInformationSectionOpportunityPage() {

		// systemInformationSectionValues.add("Opportunity Owner");
		systemInformationSectionValues.add("Last Manually Modified By");
		systemInformationSectionValues.add("Last Manually Modified Date");

		System.out.println("The system information fields are " + systemInformationSectionValues);

	}

	
	public void validateNewOpportunitiesPage() {
		opportunitiesPage.selectNewOpportunity();
		Utility_Functions.xSwitchtoFrame(driver, continueButton);
		Utility_Functions.xWaitForElementPresent(driver, selectOpportunityRecordType, 3);
		Utility_Functions.xClick(driver, selectOpportunityRecordType, true);
		Utility_Functions.xWaitForElementPresent(driver, opportunityDSFValue, 3);
		Utility_Functions.xClick(driver, opportunityDSFValue, true);
		Utility_Functions.xWaitForElementPresent(driver, continueButton, 3);
		Utility_Functions.xClick(driver, continueButton, true);
		Utility_Functions.timeWait(2);
		driver.switchTo().defaultContent();
		List<WebElement> opportunityInformationFields = driver.findElements(By.xpath(
				"//span[text()='Opportunity Information']/parent::h3/following-sibling::div//*[contains(@class,'form-element__label')]/span[1]"));
		int count1 = 0, i1 = 0, j1 = 0;
		String fieldsArray[] = new String[opportunityInformationFields.size()];
		System.out.println(opportunityInformationFields.size());
		try {
			opportunityInformation();
			while (j1 < opportunityInformationFields.size()) {
				for (WebElement element1 : opportunityInformationFields) {
					fieldsArray[i1] = element1.getText();
					if (fieldsArray[i1].equalsIgnoreCase(opportunityInformationValues.get(j1))) {
						System.out.println("Verify Opportunity Information Section " + element1.getText());
						report.updateTestLog("Verify Opportunity Information Section ",
								element1.getText() + "labels  present in the Opportunity Information Section ",
								Status.PASS);
						count1++;
					}
					i1++;
				}
				i1 = 0;
				j1++;
			}
			System.out.println(count1);
			if (count1 >= 10) {
				report.updateTestLog("Verify Opportunity Information Section",
						"All fields are present in the Opportunity Information Section", Status.PASS);
			} else {
				report.updateTestLog("Verify Opportunity Information Section",
						"All fields are not present in the Opportunity Information Section", Status.FAIL);
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		List<WebElement> financialDetailsFields = driver.findElements(By.xpath(
				"//span[text()='Financial Details/Sales Stages']/parent::h3/following-sibling::div//*[contains(@class,'form-element__label')]/span[1]"));
		int count2 = 0, i2 = 0, j2 = 0;
		String fieldsArray2[] = new String[financialDetailsFields.size()];
		System.out.println(financialDetailsFields.size());
		try {
			financialDetails();
			while (j2 < financialDetailsFields.size()) {
				for (WebElement element2 : financialDetailsFields) {
					fieldsArray2[i2] = element2.getText();
					if (fieldsArray2[i2].equalsIgnoreCase(financialDetailsStagesValues.get(j2))) {
						System.out.println("Verify Additional Information Section " + element2.getText());
						report.updateTestLog("Verify Additional Information Section ",
								element2.getText() + "labels  present in the Additional Information Section ",
								Status.PASS);
						count2++;
					}
					i2++;
				}
				i2 = 0;
				j2++;
			}
			System.out.println(count2);
			if (count2 != 6) {
				report.updateTestLog("Verify Financial Details Section",
						"All fields are present in the Financial Details Section", Status.PASS);
			} else {
				report.updateTestLog("Verify Financial Details Section",
						"All fields are not present in the Financial Details Section", Status.FAIL);
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		List<WebElement> opportunityDetailsFields = driver.findElements(By.xpath(
				"//span[text()='Opportunity Details']/parent::h3/following-sibling::div//*[contains(@class,'form-element__label')]/span[1]"));
		int count6 = 0, i6 = 0, j6 = 0;
		String fieldsArray6[] = new String[opportunityDetailsFields.size()];
		System.out.println(opportunityDetailsFields.size());
		try {
			opportunityDetails();
			while (j6 < opportunityDetailsFields.size()) {
				for (WebElement element6 : opportunityDetailsFields) {
					fieldsArray6[i6] = element6.getText();
					if (fieldsArray6[i6].equalsIgnoreCase(opportunityDetailsValues.get(j6))) {
						System.out.println("Verify Opportunity Information Section " + element6.getText());
						report.updateTestLog("Verify Opportunity Information Section ",
								element6.getText() + "labels  present in the Opportunity Information Section ",
								Status.PASS);
						count6++;
					}
					i6++;
				}
				i6 = 0;
				j6++;
			}
			System.out.println(count6);
			if (count6 >= 10) {
				report.updateTestLog("Verify Opportunity Details Section",
						"All fields are present in the Opportunity Details Section", Status.PASS);
			} else {
				report.updateTestLog("Verify Opportunity Details Section",
						"All fields are not present in the Opportunity Details Section", Status.FAIL);
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		List<WebElement> appointmentInformationFields = driver.findElements(By.xpath(
				"//span[text()='Appointment Information']/parent::h3/following-sibling::div//*[contains(@class,'form-element__label')]/span[1]"));
		int count7 = 0, i7 = 0, j7 = 0;
		String fieldsArray7[] = new String[appointmentInformationFields.size()];
		System.out.println(appointmentInformationFields.size());
		try {
			appointmentInformation();
			while (j7 < appointmentInformationFields.size()) {
				for (WebElement element7 : appointmentInformationFields) {
					fieldsArray7[i7] = element7.getText();
					if (fieldsArray7[i7].equalsIgnoreCase(appointmentInformationValues.get(j7))) {
						System.out.println("Verify Appointment Information Section " + element7.getText());
						report.updateTestLog("Verify Appointment Information Section ",
								element7.getText() + "labels  present in the Appointment Information Section ",
								Status.PASS);
						count7++;
					}
					i7++;
				}
				i7 = 0;
				j7++;
			}
			System.out.println(count7);
			if (count7 != 3) {
				report.updateTestLog("Verify Appoointment Information Section",
						"All fields are not present in the Appointment Information Section", Status.FAIL);
			} else {
				report.updateTestLog("Verify Appointment Information Section",
						"All fields are present in the Appointment Information Section", Status.PASS);
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		List<WebElement> closeInformationFields = driver.findElements(By.xpath(
				"//span[text()='Close Information']/parent::h3/following-sibling::div//*[contains(@class,'form-element__label')]/span[1]"));
		int count3 = 0, i3 = 0, j3 = 0;
		String fieldsArray3[] = new String[closeInformationFields.size()];
		System.out.println(closeInformationFields.size());
		try {
			closeInformation();
			while (j3 < closeInformationFields.size()) {
				for (WebElement element3 : closeInformationFields) {
					fieldsArray3[i3] = element3.getText();
					if (fieldsArray3[i3].equalsIgnoreCase(closeInformationValues.get(j3))) {
						System.out.println("Verify Close Information Section " + element3.getText());
						report.updateTestLog("Verify Close Information Section ",
								element3.getText() + "labels  present in the Close Information Section ", Status.PASS);
						count3++;
					}
					i3++;
				}
				i3 = 0;
				j3++;
			}
			System.out.println(count3);
			if (count3 >= 7) {
				report.updateTestLog("Verify Close Information Section",
						"All fields are present in the Close Information Section", Status.PASS);
			} else {
				report.updateTestLog("Verify Close Information Section",
						"All fields are not present in the Close Information Section", Status.FAIL);
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		List<WebElement> lossInformationFields = driver.findElements(By.xpath(
				"//span[text()='Loss Information']/parent::h3/following-sibling::div//*[contains(@class,'form-element__label')]/span[1]"));
		int count4 = 0, i4 = 0, j4 = 0;
		String fieldsArray4[] = new String[lossInformationFields.size()];
		System.out.println(lossInformationFields.size());
		try {
			lossInformation();
			while (j4 < lossInformationFields.size()) {
				for (WebElement element4 : lossInformationFields) {
					fieldsArray4[i4] = element4.getText();
					if (fieldsArray4[i4].equalsIgnoreCase(lossInformationValues.get(j4))) {
						System.out.println("Verify Loss Information Section " + element4.getText());
						report.updateTestLog("Verify Loss Information Section ",
								element4.getText() + "labels  present in the Loss Information Section ", Status.PASS);
						count4++;
					}
					i4++;
				}
				i4 = 0;
				j4++;
			}
			System.out.println(count4);
			if (count4 != 3) {
				report.updateTestLog("Verify Loss Information Section",
						"All fields are not present in the Loss Information Section", Status.FAIL);
			} else {
				report.updateTestLog("Verify Loss Information Section",
						"All fields are present in the Loss Information Section", Status.PASS);
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		List<WebElement> systemInformationSectionFields = driver.findElements(By.xpath(
				"//span[text()='System Information']/parent::h3/following-sibling::div//*[contains(@class,'form-element__label')]/span[1]"));
		int count5 = 0, i5 = 0, j5 = 0;
		String fieldsArray5[] = new String[systemInformationSectionFields.size()];
		System.out.println(systemInformationSectionFields.size());
		try {
			systemInformationSectionOpportunityPage();
			while (j5 < systemInformationSectionFields.size()) {
				for (WebElement element5 : systemInformationSectionFields) {
					fieldsArray5[i5] = element5.getText();
					if (fieldsArray5[i5].equalsIgnoreCase(systemInformationSectionValues.get(j5))) {
						System.out.println("Verify System Information Section " + element5.getText());
						report.updateTestLog("Verify System Information Section ",
								element5.getText() + "labels  present in the System Information Section ", Status.PASS);
						count5++;
					}
					i5++;
				}
				i5 = 0;
				j5++;
			}
			System.out.println(count5);
			if (count5 != 2) {
				report.updateTestLog("Verify System Information Section",
						"All fields are not present in the System Information Section", Status.FAIL);
			} else {
				report.updateTestLog("Verify System Information Section",
						"All fields are present in the System Information Section", Status.PASS);
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		systemInformationSectionValues.clear();

	}
	
	/**
	 * Validating the Opportunities edit page for the EMEA Valuation users
	 * 
	 * @author Ramya
	 *
	 */
	static ArrayList<String> opportunityInformationEditPageValues = new ArrayList<String>();

	public void opportunityInformationEditPage() {

		opportunityInformationEditPageValues.add("Opportunity Name");
		opportunityInformationEditPageValues.add("Confidential Opportunity");
		opportunityInformationEditPageValues.add("Account Name");
		opportunityInformationEditPageValues.add("Close Date");
		opportunityInformationEditPageValues.add("Project Type Description");
		opportunityInformationEditPageValues.add("Sales Stage");
		opportunityInformationEditPageValues.add("Comments");
		opportunityInformationEditPageValues.add("Assignment Start Date");
		opportunityInformationEditPageValues.add("Estimated Gross Fee/Commission");
		opportunityInformationEditPageValues.add("Net Fee");
		opportunityInformationEditPageValues.add("Probability (%)");
		opportunityInformationEditPageValues.add("Risk");

		System.out.println("The values for the Opportunity Information section edit page are "
				+ opportunityInformationEditPageValues);

	}

	static ArrayList<String> additionalInformationEditPageValues = new ArrayList<String>();

	public void additionalInformationEditPage() {

		additionalInformationEditPageValues.add("Address Line 1");
		additionalInformationEditPageValues.add("Sub Market");
		additionalInformationEditPageValues.add("Address Line 2");
		additionalInformationEditPageValues.add("City");
		additionalInformationEditPageValues.add("Postcode");
		additionalInformationEditPageValues.add("Property Market Value");
		additionalInformationEditPageValues.add("Total Size");
		additionalInformationEditPageValues.add("Referral");
		additionalInformationEditPageValues.add("Parent Opportunity");
		additionalInformationEditPageValues.add("Referral Recipient");

		System.out.println("The labels for the Additional Information section edit page are "
				+ additionalInformationEditPageValues);

	}

	static ArrayList<String> lossInformationEditPageValues = new ArrayList<String>();

	public void lossInformationEditPage() {

		lossInformationEditPageValues.add("Competitor");
		lossInformationEditPageValues.add("Reason Lost Comments");
		lossInformationEditPageValues.add("Next Step");

		System.out
				.println("The labels for the loss Information section edit page are " + lossInformationEditPageValues);

	}

	static ArrayList<String> dataHugDetailsEditPageValues = new ArrayList<String>();

	public void dataHugDetailsEditPage() {

		dataHugDetailsEditPageValues.add("Deal Score");
		dataHugDetailsEditPageValues.add("Last Email Sent");
		dataHugDetailsEditPageValues.add("Deal Score Reason");
		dataHugDetailsEditPageValues.add("Last Email Sent by");
		dataHugDetailsEditPageValues.add("Best Connected Colleague");
		dataHugDetailsEditPageValues.add("Last Meeting");
		dataHugDetailsEditPageValues.add("Last Email Received");
		dataHugDetailsEditPageValues.add("Next Meeting");
		dataHugDetailsEditPageValues.add("Last Email Received from");

		System.out.println("The labels for the Data Hug details section edit page are " + dataHugDetailsEditPageValues);

	}

	static ArrayList<String> systemInformationEditPageValues = new ArrayList<String>();

	public void systemInformationEditPage() {

		systemInformationEditPageFields.add("Created By");
		systemInformationEditPageFields.add("Last Modified By");
		systemInformationEditPageFields.add("External Deal ID");
		systemInformationEditPageFields.add("Opportunity Record Type");
		systemInformationEditPageFields.add("Opportunity Age (Days)");

		System.out.println("The labels for the System Information edit page are " + systemInformationEditPageFields);

	}

	static ArrayList<String> bankValuationsInstructionsFields = new ArrayList<String>();

	public void bankValuationsInstructionsEditPage() {

		bankValuationsInstructionsFields.add("Reason for Loss");
		bankValuationsInstructionsFields.add("Competitor");
		bankValuationsInstructionsFields.add("Reason Lost Comments");

		System.out.println(
				"The labels for the Bank Valuations Instructions edit page are " + bankValuationsInstructionsFields);

	}

	static ArrayList<String> valuationSpecificEditPageValues = new ArrayList<String>();

	public void valuationSpecificEditPage() {

		valuationSpecificEditPageValues.add("Number of Properties");
		System.out.println(
				"The labels for the Valuation Specific section edit page are " + valuationSpecificEditPageValues);

	}

	public void validateOpportunitiesValuationsEditPage() {
		opportunitiesPage.opportunityEligibility();
		Utility_Functions.timeWait(2);
		Utility_Functions.xWaitForElementPresent(driver, edit, 3);
		Utility_Functions.xClick(driver, edit, true);
		List<WebElement> opportunityInformationFields = driver.findElements(By.xpath(
				"//span[text()='Opportunity Information']/parent::h3/following-sibling::div//div[contains(@class,'slds-form-element__control')]//label/span[1]"));
		int count1 = 0, i1 = 0, j1 = 0;
		String fieldsArray[] = new String[opportunityInformationFields.size()];
		System.out.println(opportunityInformationFields.size());
		try {
			opportunityInformationEditPage();
			while (j1 < opportunityInformationFields.size()) {
				for (WebElement element1 : opportunityInformationFields) {
					fieldsArray[i1] = element1.getText();
					if (fieldsArray[i1].equalsIgnoreCase(opportunityInformationEditPageValues.get(j1))) {
						System.out.println("Verify Opportunity Information Section " + element1.getText());
						report.updateTestLog("Verify Opportunity Information Section ",
								element1.getText() + "labels  present in the Opportunity Information Section ",
								Status.PASS);
						count1++;
					}
					i1++;
				}
				i1 = 0;
				j1++;
			}
			System.out.println(count1);
			if (count1 >= 8) {
				report.updateTestLog("Verify Opportunity Information Section",
						"All fields are present in the Opportunity Information Section", Status.PASS);
			} else {
				report.updateTestLog("Verify Opportunity Information Section",
						"All fields are not present in the Opportunity Information Section", Status.FAIL);
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		List<WebElement> additionalInformationFields = driver.findElements(By.xpath(
				"//span[text()='Additional Information']/parent::h3/following-sibling::div//div[contains(@class,'slds-form-element__control')]//label/span[1]"));
		int count2 = 0, i2 = 0, j2 = 0;
		String fieldsArray2[] = new String[additionalInformationFields.size()];
		System.out.println(additionalInformationFields.size());
		try {
			additionalInformationEditPage();
			while (j2 < additionalInformationFields.size()) {
				for (WebElement element2 : additionalInformationFields) {
					fieldsArray2[i2] = element2.getText();
					if (fieldsArray2[i2].equalsIgnoreCase(additionalInformationEditPageValues.get(j2))) {
						System.out.println("Verify Additional Information Section " + element2.getText());
						report.updateTestLog("Verify Additional Information Section ",
								element2.getText() + "labels  present in the Additional Information Section ",
								Status.PASS);
						count2++;
					}
					i2++;
				}
				i2 = 0;
				j2++;
			}
			System.out.println(count2);
			if (count2 >= 6) {
				report.updateTestLog("Verify Additional Information Section",
						"All fields are present in the Additional Information Section", Status.PASS);
			} else {
				report.updateTestLog("Verify Additional Information Section",
						"All fields are not present in the Additional Information Section", Status.FAIL);
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		int count6 = 0, i6 = 0;
		try {
			List<WebElement> valuationSpecificFields = null;
			String fieldsArray6[] = null;
			boolean isPresent = false;
			try {
				valuationSpecificFields = driver.findElements(By.xpath(
						"//span[text()='Valuations Specific Information']/parent::h3/following-sibling::div//div[contains(@class,'slds-form-element__control')]//label/span[1]"));
				fieldsArray6 = new String[valuationSpecificFields.size()];
				System.out.println(valuationSpecificFields.size());
				if (valuationSpecificFields.size() > 1) {
					isPresent = true;
					valuationSpecificEditPage();
					for (WebElement element6 : valuationSpecificFields) {
						System.out.println(element6.getText());
						fieldsArray6[i6] = element6.getText();
						if (fieldsArray6[i6].contains(valuationSpecificEditPageValues.get(i1))) {
							report.updateTestLog("Verify Valuation Specific fields",
									"Valuation specific fields is having the " + fieldsArray6[i6] + " fields ",
									Status.PASS);
							count6++;
						}
						i6++;
					}
				} else {
					isPresent = false;
				}
			} catch (Exception e) {
				report.updateTestLog("Verify Valuation Specific fields",
						"Valuation specific section is not present for the selected Opportunity", Status.WARNING);
				isPresent = false;
			}
			System.out.println(count6);
			if (isPresent == true) {
				if (count6 != 1) {
					report.updateTestLog("Verify Valuation Specific fields",
							"All fields are not present in the Valuation specific section ", Status.FAIL);
				} else {

					report.updateTestLog("Verify Valuation Specific fields",
							"All fields are present in the Valuation specific section", Status.PASS);
				}
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		int count7 = 0, i7 = 0, j7 = 0;
		try {
			List<WebElement> bankValuationServiceFields = null;
			String fieldsArray7[] = null;
			boolean isPresent = false;
			try {
				bankValuationServiceFields = driver.findElements(By.xpath(
						"//span[text()='Bank Valuations Instructions']/parent::h3/following-sibling::div//div[contains(@class,'slds-form-element__control')]//label/span[1]"));
				fieldsArray7 = new String[bankValuationServiceFields.size()];
				System.out.println(bankValuationServiceFields.size());
				if (bankValuationServiceFields.size() > 1) {
					isPresent = true;
					bankValuationsInstructionsEditPage();
					while (j7 < bankValuationServiceFields.size()) {
						for (WebElement element7 : bankValuationServiceFields) {
							fieldsArray7[i7] = element7.getText();
							if (fieldsArray7[i7].equalsIgnoreCase(bankValuationsInstructionsFields.get(j7))) {
								System.out.println("Verify Bank Valuations Services Section " + element7.getText());
								report.updateTestLog("Verify Bank Valuations Services Section ",
										element7.getText() + "labels  present in the Bank Valuations services Section ",
										Status.PASS);
								count7++;
							}
							i7++;
						}
						i7 = 0;
						j7++;
					}
				} else {
					isPresent = false;
				}
			} catch (Exception e1) {
				report.updateTestLog("Verify Business Service fields",
						"Business Service section is not present for the selected Opportunity", Status.WARNING);
				isPresent = false;
			}

			System.out.println(count7);
			if (isPresent == true) {
				if (count7 != 5) {
					report.updateTestLog("Verify Bank Valuation Services Section",
							"All fields are not present in the Bank Valuation Services Section", Status.FAIL);
				} else {
					report.updateTestLog("Verify Bank Valuation Services Section",
							"All fields are present in the Bank Valuation Services Section", Status.PASS);
				}
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		List<WebElement> lossInformationFields = driver.findElements(By.xpath(
				"//span[text()='Loss Information']/parent::h3/following-sibling::div//div[contains(@class,'slds-form-element__control')]//label/span[1]"));
		int count3 = 0, i3 = 0, j3 = 0;
		String fieldsArray3[] = new String[lossInformationFields.size()];
		System.out.println(lossInformationFields.size());
		try {
			lossInformationEditPage();
			while (j3 < additionalInformationFields.size()) {
				for (WebElement element3 : additionalInformationFields) {
					fieldsArray3[i3] = element3.getText();
					if (fieldsArray3[i3].equalsIgnoreCase(lossInformationEditPageValues.get(j3))) {
						System.out.println("Verify Loss Information Section " + element3.getText());
						report.updateTestLog("Verify Loss Information Section ",
								element3.getText() + "labels  present in the Loss Information Section ", Status.PASS);
						count3++;
					}
					i3++;
				}
				i3 = 0;
				j3++;
			}
			System.out.println(count3);
			if (count3 != 3) {
				report.updateTestLog("Verify Loss Information Section",
						"All fields are not present in the Loss Information Section", Status.FAIL);
			} else {
				report.updateTestLog("Verify Loss Information Section",
						"All fields are present in the Loss Information Section", Status.PASS);
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		List<WebElement> dataHugDetailsFields = driver.findElements(By.xpath(
				"//span[text()='Datahug Details']/parent::h3/following-sibling::div//div[contains(@class,'test-id__field-label-container')]/span[1]"));
		int count4 = 0, i4 = 0, j4 = 0;
		String fieldsArray4[] = new String[dataHugDetailsFields.size()];
		System.out.println(dataHugDetailsFields.size());
		try {
			dataHugDetailsEditPage();
			while (j4 < dataHugDetailsFields.size()) {
				for (WebElement element4 : dataHugDetailsFields) {
					fieldsArray4[i4] = element4.getText();
					if (fieldsArray4[i4].equalsIgnoreCase(dataHugDetailsEditPageValues.get(j4))) {
						System.out.println("Verify Data Hug Details Section " + element4.getText());
						report.updateTestLog("Verify Data Hug Details Section ",
								element4.getText() + "labels  present in the Data Hug Details Section ", Status.PASS);
						count4++;
					}
					i4++;
				}
				i4 = 0;
				j4++;
			}
			System.out.println(count4);
			if (count4 != 9) {
				report.updateTestLog("Verify Data Hug Details Section",
						"All fields are not present in the Data Hug Details Section", Status.FAIL);
			} else {
				report.updateTestLog("Verify Data Hug Details Section",
						"All fields are present in the Data HUg Details Section", Status.PASS);
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		List<WebElement> systemInformationFields = driver.findElements(By.xpath(
				"//span[text()='System Information']/parent::h3/following-sibling::div//div[contains(@class,'test-id__field-label-container')]/span[1]"));
		int count5 = 0, i5 = 0, j5 = 0;
		String fieldsArray5[] = new String[systemInformationFields.size()];
		System.out.println(systemInformationFields.size());
		try {
			systemInformationEditPage();
			while (j5 < systemInformationFields.size()) {
				for (WebElement element5 : systemInformationFields) {
					fieldsArray5[i5] = element5.getText();
					if (fieldsArray5[i5].equalsIgnoreCase(systemInformationEditPageValues.get(j5))) {
						System.out.println("Verify System Information Section " + element5.getText());
						report.updateTestLog("Verify System Information Section ",
								element5.getText() + "labels  present in the System Information Section ", Status.PASS);
						count5++;
					}
					i5++;
				}
				i5 = 0;
				j5++;
			}
			System.out.println(count5);
			if (count5 != 5) {
				report.updateTestLog("Verify System Information Section",
						"All fields are not present in the Property Details Section", Status.FAIL);
			} else {
				report.updateTestLog("Verify System Information Section",
						"All fields are present in the System Information Section", Status.PASS);
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	/**
	 * Validating the Opportunities edit page for the Capital Advisor users
	 * 
	 * @author Ramya
	 *
	 */
	static ArrayList<String> opportunityInformationEditPageFields = new ArrayList<String>();

	public void opportunityInformationSectionEditPage() {

		opportunityInformationEditPageFields.add("Opportunity Name");
		opportunityInformationEditPageFields.add("Confidential Opportunity");
		opportunityInformationEditPageFields.add("Account Name");
		opportunityInformationEditPageFields.add("Sales Stage");
		opportunityInformationEditPageFields.add("Estimated Gross Fee/Commission");
		opportunityInformationEditPageFields.add("Description");
		opportunityInformationEditPageFields.add("Net Fee");
		opportunityInformationEditPageFields.add("Comments");
		opportunityInformationEditPageFields.add("Close Date");
		opportunityInformationEditPageFields.add("Total Size");
		opportunityInformationEditPageFields.add("Parent Opportunity");
		opportunityInformationEditPageFields.add("Change Opportunity Owner");
		opportunityInformationEditPageFields.add("Conversion Type Other");

		System.out.println("The labels for the Opportunity Information section edit page are "
				+ opportunityInformationEditPageFields);

	}

	static ArrayList<String> additionalInformationEditPageFields = new ArrayList<String>();

	public void additionalInformationSectionEditPage() {

		additionalInformationEditPageFields.add("Address Line 1");
		additionalInformationEditPageFields.add("City");
		additionalInformationEditPageFields.add("Address Line 2");
		additionalInformationEditPageFields.add("Postcode");
		additionalInformationEditPageFields.add("RFP Submission Date");
		additionalInformationEditPageFields.add("Probability (%)");
		additionalInformationEditPageFields.add("Pitch Date");
		additionalInformationEditPageFields.add("Referral");
		additionalInformationEditPageFields.add("Referral Recipient");
		additionalInformationEditPageFields.add("Referral Email Sent");

		System.out.println("The labels for the Additional Information section edit page are "
				+ additionalInformationEditPageFields);

	}

	static ArrayList<String> lossInformationEditPageFields = new ArrayList<String>();

	public void lossInformationSectionEditPage() {

		lossInformationEditPageFields.add("Competitor");
		lossInformationEditPageFields.add("Reason Lost Comments");
		lossInformationEditPageFields.add("Next Step");
		lossInformationEditPageFields.add("Invoice No");
		lossInformationEditPageFields.add("Bill Date");

		System.out
				.println("The labels for the loss Information section edit page are " + lossInformationEditPageFields);

	}

	static ArrayList<String> dataHugDetailsEditPageFields = new ArrayList<String>();

	public void dataHugDEtailsSectionEditPage() {

		dataHugDetailsEditPageFields.add("Deal Score");
		dataHugDetailsEditPageFields.add("Last Email Sent");
		dataHugDetailsEditPageFields.add("Deal Score Reason");
		dataHugDetailsEditPageFields.add("Last Email Sent by");
		dataHugDetailsEditPageFields.add("Best Connected Colleague");
		dataHugDetailsEditPageFields.add("Last Meeting");
		dataHugDetailsEditPageFields.add("Last Email Received");
		dataHugDetailsEditPageFields.add("Next Meeting");
		dataHugDetailsEditPageFields.add("Last Email Received from");

		System.out.println(
				"The labels for the Additional Information section edit page are " + dataHugDetailsEditPageFields);

	}

	static ArrayList<String> systemInformationEditPageFields = new ArrayList<String>();

	public void systemInformationSectionEditPage() {

		systemInformationEditPageFields.add("Created By");
		systemInformationEditPageFields.add("External Deal ID");
		systemInformationEditPageFields.add("Last Modified By");
		systemInformationEditPageFields.add("Opportunity Record Type");
		systemInformationEditPageFields.add("Opportunity Age (Days)");

		System.out.println(
				"The labels for the Additional Information section edit page are " + systemInformationEditPageFields);

	}

	public void validateOpportunitiesEditPageLayout() {
		opportunitiesPage.opportunityEligibility();
		Utility_Functions.timeWait(2);
		Utility_Functions.xWaitForElementPresent(driver, edit, 3);
		Utility_Functions.xClick(driver, edit, true);
		List<WebElement> opportunityInformationFields = driver.findElements(By.xpath(
				"//span[text()='Opportunity Information']/parent::h3/following-sibling::div//div[contains(@class,'slds-form-element__control')]//label/span[1]"));
		int count1 = 0, i1 = 0, j1 = 0;
		String fieldsArray[] = new String[opportunityInformationFields.size()];
		System.out.println(opportunityInformationFields.size());
		try {
			opportunityInformationSectionEditPage();
			while (j1 < opportunityInformationFields.size()) {
				for (WebElement element1 : opportunityInformationFields) {
					fieldsArray[i1] = element1.getText();
					if (fieldsArray[i1].equalsIgnoreCase(opportunityInformationEditPageFields.get(j1))) {
						System.out.println("Verify Opportunity Information Section " + element1.getText());
						report.updateTestLog("Verify Opportunity Information Section ",
								element1.getText() + "labels  present in the Opportunity Information Section ",
								Status.PASS);
						count1++;
					}
					i1++;
				}
				i1 = 0;
				j1++;
			}
			System.out.println(count1);
			if (count1 >= 11) {
				report.updateTestLog("Verify Opportunity Information Section",
						"All fields are not present in the Opportunity Information Section", Status.PASS);
			} else {
				report.updateTestLog("Verify Opportunity Information Section",
						"All fields are present in the Opportunity Information Section", Status.FAIL);
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		List<WebElement> additionalInformationFields = driver.findElements(By.xpath(
				"//span[text()='Additional Information']/parent::h3/following-sibling::div//div[contains(@class,'slds-form-element__control')]//label/span[1]"));
		int count2 = 0, i2 = 0, j2 = 0;
		String fieldsArray2[] = new String[additionalInformationFields.size()];
		System.out.println(additionalInformationFields.size());
		try {
			additionalInformationSectionEditPage();
			while (j2 < additionalInformationFields.size()) {
				for (WebElement element2 : additionalInformationFields) {
					fieldsArray2[i2] = element2.getText();
					if (fieldsArray2[i2].equalsIgnoreCase(additionalInformationEditPageFields.get(j2))) {
						System.out.println("Verify Additional Information Section " + element2.getText());
						report.updateTestLog("Verify Additional Information Section ",
								element2.getText() + "labels  present in the Additional Information Section ",
								Status.PASS);
						count2++;
					}
					i2++;
				}
				i2 = 0;
				j2++;
			}
			System.out.println(count2);
			if (count2 >= 10) {
				report.updateTestLog("Verify Additional Information Section",
						"All fields are not present in the Additional Information Section", Status.PASS);
			} else {
				report.updateTestLog("Verify Additional Information Section",
						"All fields are present in the Additional Information Section", Status.FAIL);
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		List<WebElement> lossInformationFields = driver.findElements(By.xpath(
				"//span[text()='Loss Information']/parent::h3/following-sibling::div//div[contains(@class,'slds-form-element__control')]//label/span[1]"));
		int count3 = 0, i3 = 0, j3 = 0;
		String fieldsArray3[] = new String[lossInformationFields.size()];
		System.out.println(lossInformationFields.size());
		try {
			lossInformationSectionEditPage();
			while (j3 < additionalInformationFields.size()) {
				for (WebElement element3 : additionalInformationFields) {
					fieldsArray3[i3] = element3.getText();
					if (fieldsArray3[i3].equalsIgnoreCase(lossInformationEditPageFields.get(j3))) {
						System.out.println("Verify Loss Information Section " + element3.getText());
						report.updateTestLog("Verify Loss Information Section ",
								element3.getText() + "labels  present in the Loss Information Section ", Status.PASS);
						count3++;
					}
					i3++;
				}
				i3 = 0;
				j3++;
			}
			System.out.println(count3);
			if (count3 != 3) {
				report.updateTestLog("Verify Loss Information Section",
						"All fields are not present in the Loss Information Section", Status.FAIL);
			} else {
				report.updateTestLog("Verify Loss Information Section",
						"All fields are present in the Loss Information Section", Status.PASS);
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		List<WebElement> dataHugDetailsFields = driver.findElements(By.xpath(
				"//span[text()='Datahug Details']/parent::h3/following-sibling::div//div[contains(@class,'test-id__field-label-container')]/span[1]"));
		int count4 = 0, i4 = 0, j4 = 0;
		String fieldsArray4[] = new String[dataHugDetailsFields.size()];
		System.out.println(dataHugDetailsFields.size());
		try {
			dataHugDEtailsSectionEditPage();
			while (j4 < dataHugDetailsFields.size()) {
				for (WebElement element4 : dataHugDetailsFields) {
					fieldsArray4[i4] = element4.getText();
					if (fieldsArray4[i4].equalsIgnoreCase(dataHugDetailsEditPageFields.get(j4))) {
						System.out.println("Verify Data Hug Details Section " + element4.getText());
						report.updateTestLog("Verify Data Hug Details Section ",
								element4.getText() + "labels  present in the Data Hug Details Section ", Status.PASS);
						count4++;
					}
					i4++;
				}
				i4 = 0;
				j4++;
			}
			System.out.println(count4);
			if (count4 >= 9) {
				report.updateTestLog("Verify Data Hug Details Section",
						"All fields are not present in the Data Hug Details Section", Status.PASS);
			} else {
				report.updateTestLog("Verify Data Hug Details Section",
						"All fields are present in the Data HUg Details Section", Status.FAIL);
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		List<WebElement> systemInformationFields = driver.findElements(By.xpath(
				"//span[text()='System Information']/parent::h3/following-sibling::div//div[contains(@class,'test-id__field-label-container')]/span[1]"));
		int count5 = 0, i5 = 0, j5 = 0;
		String fieldsArray5[] = new String[systemInformationFields.size()];
		System.out.println(systemInformationFields.size());
		try {
			systemInformationSectionEditPage();
			while (j5 < systemInformationFields.size()) {
				for (WebElement element5 : systemInformationFields) {
					fieldsArray5[i5] = element5.getText();
					if (fieldsArray5[i5].equalsIgnoreCase(systemInformationEditPageFields.get(j5))) {
						System.out.println("Verify System Information Section " + element5.getText());
						report.updateTestLog("Verify System Information Section ",
								element5.getText() + "labels  present in the System Information Section ", Status.PASS);
						count5++;
					}
					i5++;
				}
				i5 = 0;
				j5++;
			}
			System.out.println(count5);
			if (count5 >= 5) {
				report.updateTestLog("Verify System Information Section",
						"All fields are not present in the Property Details Section", Status.PASS);
			} else {
				report.updateTestLog("Verify System Information Section",
						"All fields are present in the System Information Section", Status.FAIL);
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

	}
	
	/**
	 * Validating the Opportunities for the System information fields for the
	 * APAC Project Manager
	 * 
	 * @author Ramya
	 *
	 */
	public void validateOpportunitySystemInformationFields() {
		opportunitiesPage.selectNewOpportunity();
		List<WebElement> systemInformationSectionFields = driver.findElements(By.xpath(
				"//span[text()='System Information']/parent::h3/following-sibling::div//*[contains(@class,'form-element__label')]/span[1]"));
		int count5 = 0, i5 = 0, j5 = 0;
		String fieldsArray5[] = new String[systemInformationSectionFields.size()];
		System.out.println(systemInformationSectionFields.size());
		try {
			systemInformationSectionOpportunityPage();
			while (j5 < systemInformationSectionFields.size()) {
				for (WebElement element5 : systemInformationSectionFields) {
					fieldsArray5[i5] = element5.getText();
					if (fieldsArray5[i5].equalsIgnoreCase(systemInformationSectionValues.get(j5))) {
						System.out.println("Verify System Information Section " + element5.getText());
						report.updateTestLog("Verify System Information Section ",
								element5.getText() + "labels  present in the System Information Section ", Status.PASS);
						count5++;
					}
					i5++;
				}
				i5 = 0;
				j5++;
			}
			System.out.println(count5);
			if (count5 != 2) {
				report.updateTestLog("Verify System Information Section",
						"All fields are not present in the System Information Section", Status.FAIL);
			} else {
				report.updateTestLog("Verify System Information Section",
						"All fields are present in the System Information Section", Status.PASS);
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		systemInformationSectionValues.clear();
		Utility_Functions.timeWait(2);
		Utility_Functions.xWaitForElementPresent(driver, opportunityName_AS, 3);
		Utility_Functions.xClick(driver, opportunityName_AS, true);
		Utility_Functions.xWaitForElementPresent(driver, opportunityName_AS, 3);
		Utility_Functions.xSendKeys(driver, opportunityName_AS,
				"Test Automation Opportunity_" + Utility_Functions.xGenerateAlphaNumericString());
		Utility_Functions.xWaitForElementPresent(driver, accountNameNewOpportunity, 4);
		Utility_Functions.xSendKeys(driver, accountNameNewOpportunity, "Test Automation_0101");
		Utility_Functions.xWaitForElementPresent(driver, accountNameNewOpp, 3);
		Utility_Functions.xClick(driver, accountNameNewOpp, true);
		System.out.println(Calendar.getInstance());
		DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
		Date date = new Date();
		Utility_Functions.xWaitForElementPresent(driver, closeDate_AS, 3);
		Utility_Functions.xSendKeys(driver, closeDate_AS, dateFormat.format(date).toString());
		Calendar calendar1 = Calendar.getInstance();
		calendar1.add(Calendar.DAY_OF_MONTH, -20);
		SimpleDateFormat dateFormat1 = new SimpleDateFormat("MM/dd/yyyy");
		System.out.println("Date : " + dateFormat1.format(calendar1.getTime()));
		Utility_Functions.xWaitForElementPresent(driver, assignmentStartDate, 3);
		Utility_Functions.xSendKeys(driver, assignmentStartDate, dateFormat1.format(calendar1.getTime()));
		Utility_Functions.xWaitForElementPresent(driver, leadSourceNewOpp, 3);
		Utility_Functions.xClick(driver, leadSourceNewOpp, true);
		Utility_Functions.xWaitForElementPresent(driver, leadSourceNewOppValue, 3);
		Utility_Functions.xClick(driver, leadSourceNewOppValue, true);
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
		Utility_Functions.xWaitForElementPresent(driver, selectOpportunityCurrency, 3);
		Utility_Functions.xClick(driver, selectOpportunityCurrency, true);
		Utility_Functions.xWaitForElementPresent(driver, opportunityCurrencyValue, 3);
		Utility_Functions.xClick(driver, opportunityCurrencyValue, true);
		Utility_Functions.xWaitForElementPresent(driver, cityTier, 3);
		Utility_Functions.xClick(driver, cityTier, true);
		Utility_Functions.xWaitForElementPresent(driver, cityTierValue, 3);
		Utility_Functions.xClick(driver, cityTierValue, true);
		Utility_Functions.xWaitForElementPresent(driver, saveNewOpp, 3);
		Utility_Functions.xClick(driver, saveNewOpp, true);
		Utility_Functions.timeWait(5);
		if (showAll.isDisplayed()) {
			Utility_Functions.xWaitForElementPresent(driver, showAll, 3);
			Utility_Functions.xClick(driver, showAll, true);
			if ((opportunityFieldHistory.isDisplayed()) && (phaseHistory.isDisplayed())) {
				report.updateTestLog("Verify Opportunity Record Sections",
						"All fields are not present in the System Information Section", Status.PASS);

			} else {
				report.updateTestLog("Verify Opportunity Record Sections",
						"All fields are not present in the System Information Section", Status.FAIL);

			}
		} else {
			if ((opportunityFieldHistory.isDisplayed()) && (phaseHistory.isDisplayed())) {
				report.updateTestLog("Verify Opportunity Record Sections",
						"All fields are not present in the System Information Section", Status.PASS);

			} else {
				report.updateTestLog("Verify Opportunity Record Sections",
						"All fields are not present in the System Information Section", Status.FAIL);

			}

		}
	}

	/**
	 * Validating the Opportunity Quick create page for Property sales sell side
	 * opportunity record type
	 * 
	 * @author Ramya
	 * 
	 *
	 */
	static ArrayList<String> propertyDetailsSectionFields = new ArrayList<String>();

	public void propertyDetailsFields() {

		propertyDetailsSectionFields.add("Target Property");
		propertyDetailsSectionFields.add("Total Size");
		propertyDetailsSectionFields.add("Opportunity Details");

		System.out.println("Property Details fields are:::" + propertyDetailsSectionFields);
	}

	static ArrayList<String> opportunityInformationSectionFields = new ArrayList<String>();

	public void opportunityInformationSection() {

		opportunityInformationSectionFields.add("Opportunity Name");
		opportunityInformationSectionFields.add("Account Name");
		opportunityInformationSectionFields.add("Primary Contact");
		opportunityInformationSectionFields.add("Close Date");
		opportunityInformationSectionFields.add("Confidential Opportunity");
		opportunityInformationSectionFields.add("Status Comments");
		opportunityInformationSectionFields.add("HNI Transaction");
		opportunityInformationSectionFields.add("Parent Opportunity");
		opportunityInformationSectionFields.add("Core Asset Transaction");

		System.out.println("Opportunity Information section fields are:::" + opportunityInformationSectionFields);
	}

	static ArrayList<String> financialDetailsSectionFields = new ArrayList<String>();

	public void financialDetailsSection() {

		financialDetailsSectionFields.add("Estimated Gross Fee/Commission");
		financialDetailsSectionFields.add("Sales Stage");
		financialDetailsSectionFields.add("Estimated Transaction Value");
		financialDetailsSectionFields.add("Probability (%)");
		financialDetailsSectionFields.add("On Hold");
		financialDetailsSectionFields.add("On Hold Comments");

		System.out.println("Financial Details section fields are:::" + financialDetailsSectionFields);
	}

	static ArrayList<String> appointmentInformationSectionFields = new ArrayList<String>();

	public void appointmentInformationFields() {

		appointmentInformationSectionFields.add("Agency Start Date");
		appointmentInformationSectionFields.add("Agency Expiry Date");

		System.out.println("Appointment Information fields are:::" + appointmentInformationSectionFields);
	}

	static ArrayList<String> closeInformationSectionFields = new ArrayList<String>();

	public void closeInformationFields() {

		closeInformationSectionFields.add("Counterpart Account");
		closeInformationSectionFields.add("Yield (%)");
		closeInformationSectionFields.add("Counterpart Contact");
		closeInformationSectionFields.add("Exchanged/ Agreement Signed Date");
		closeInformationSectionFields.add("Close Comments");
		closeInformationSectionFields.add("Settlement/Completion Date");
		closeInformationSectionFields.add("Annual Net Operating Income");
		closeInformationSectionFields.add("Buyer Confidentiality Agreement Signed");
		closeInformationSectionFields.add("Stake Diluted (%)");

		System.out.println("Close Information section fields are:::" + closeInformationSectionFields);
	}

	static ArrayList<String> lossInformationSectionFields = new ArrayList<String>();

	public void lossInformationSectionFields() {

		lossInformationSectionFields.add("Competitor");
		lossInformationSectionFields.add("Reason Lost Comments");

		System.out.println("loss information fields are:::" + lossInformationSectionFields);
	}

	static ArrayList<String> systemInformationSectionFields = new ArrayList<String>();

	public void systemInformationSectionFields() {

		systemInformationSectionFields.add("Last Manually Modified By");
		systemInformationSectionFields.add("Change Opportunity Owner");

		System.out.println("System information fields are:::" + systemInformationSectionFields);
	}

	public void validateOpportunityQuickCreatePage() {
		opportunitiesPage.selectNewOpportunity();
		Utility_Functions.xSwitchtoFrame(driver, continueButton);
		Utility_Functions.xWaitForElementPresent(driver, continueButton, 3);
		Utility_Functions.xClick(driver, continueButton, true);
		Utility_Functions.timeWait(2);
		driver.switchTo().defaultContent();
		Utility_Functions.timeWait(2);
		List<WebElement> propertyDetailsFields = driver.findElements(By.xpath(
				"//span[text()='Property Details']/parent::h3/following-sibling::div//div[contains(@class,'slds-form-element__control')]//label/span[1]"));
		int count1 = 0, i1 = 0, j1 = 0;
		String fieldsArray[] = new String[propertyDetailsFields.size()];
		System.out.println(propertyDetailsFields.size());
		try {
			propertyDetailsFields();
			while (j1 < propertyDetailsFields.size()) {
				for (WebElement element1 : propertyDetailsFields) {
					fieldsArray[i1] = element1.getText();
					if (fieldsArray[i1].equalsIgnoreCase(propertyDetailsSectionFields.get(j1))) {
						System.out.println("Verify Property Details Section " + element1.getText());
						report.updateTestLog("Verify Property Details Section ",
								element1.getText() + "labels  present in the Property Details Section ", Status.PASS);
						count1++;
					}
					i1++;
				}
				i1 = 0;
				j1++;
			}
			System.out.println(count1);
			if (count1 != 3) {
				report.updateTestLog("Verify Property Details Section",
						"All fields are not present in the Property Details Section", Status.FAIL);
			} else {
				report.updateTestLog("Verify Property Details Section",
						"All fields are present in the Property Details Section", Status.PASS);
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		List<WebElement> opportunityInformationFields = driver.findElements(By.xpath(
				"//span[text()='Opportunity Information']/parent::h3/following-sibling::div//div[contains(@class,'slds-form-element__control')]//label/span[1]"));
		int count2 = 0, i2 = 0, j2 = 0;
		String fieldsArray2[] = new String[opportunityInformationFields.size()];
		System.out.println(opportunityInformationFields.size());
		try {
			opportunityInformationSection();
			while (j2 < opportunityInformationFields.size()) {
				for (WebElement element2 : opportunityInformationFields) {
					fieldsArray2[i2] = element2.getText();
					if (fieldsArray2[i2].equalsIgnoreCase(opportunityInformationSectionFields.get(j2))) {
						System.out.println("Verify Opportunity Information Section " + element2.getText());
						report.updateTestLog("Verify Opportunity Information Section",
								element2.getText() + "labels  present in the Opportunity Information Section ",
								Status.PASS);
						count2++;
					}
					i2++;
				}
				i2 = 0;
				j2++;
			}
			System.out.println(count2);
			if (count2 != 9) {
				report.updateTestLog("Verify Opportunity Information Section",
						"All fields are not present in the Opportunity Information Section", Status.FAIL);
			} else {
				report.updateTestLog("Verify Property Details Section",
						"All fields are present in the Opportunity Information Section", Status.PASS);
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		List<WebElement> financialDetailsStageFields = driver.findElements(By.xpath(
				"//span[text()='Financial Details/Sales Stages']/parent::h3/following-sibling::div//div[contains(@class,'slds-form-element__control')]//label/span[1]"));
		int count3 = 0, i3 = 0, j3 = 0;
		String fieldsArray3[] = new String[financialDetailsStageFields.size()];
		System.out.println(financialDetailsStageFields.size());
		try {
			financialDetailsSection();
			while (j3 < financialDetailsStageFields.size()) {
				for (WebElement element3 : financialDetailsStageFields) {
					fieldsArray3[i3] = element3.getText();
					if (fieldsArray3[i3].equalsIgnoreCase(financialDetailsSectionFields.get(j3))) {
						System.out.println("Verify Financial Details Section Fields " + element3.getText());
						report.updateTestLog("Verify Financial Details Section Fields",
								element3.getText() + "labels  present in the Financial Details Section ", Status.PASS);
						count3++;
					}
					i3++;
				}
				i3 = 0;
				j3++;
			}
			System.out.println(count3);
			if (count3 != 6) {
				report.updateTestLog("Verify Financial Details Section",
						"All fields are not present in the Opportunity Information Section", Status.FAIL);
			} else {
				report.updateTestLog("Verify Financial Details Section",
						"All fields are present in the Opportunity Information Section", Status.PASS);
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		List<WebElement> appointmentInformationFields = driver.findElements(By.xpath(
				"//span[contains(text(),'Appointment Information')]/parent::h3/following-sibling::div//div[contains(@class,'slds-form-element__control')]//label/span[1]"));
		int count4 = 0, i4 = 0, j4 = 0;
		String fieldsArray4[] = new String[appointmentInformationFields.size()];
		System.out.println(appointmentInformationFields.size());
		try {
			appointmentInformationFields();
			while (j4 < appointmentInformationFields.size()) {
				for (WebElement element4 : appointmentInformationFields) {
					fieldsArray4[i4] = element4.getText();
					if (fieldsArray4[i4].equalsIgnoreCase(appointmentInformationSectionFields.get(j4))) {
						System.out.println("Verify Appointment Information Section " + element4.getText());
						report.updateTestLog("Verify Appointment Information Section",
								element4.getText() + "labels  present in the Appointment Information Section ",
								Status.PASS);
						count4++;
					}
					i4++;
				}
				i4 = 0;
				j4++;
			}
			System.out.println(count4);
			if (count4 != 2) {
				report.updateTestLog("Verify Appointment Information Section",
						"All fields are not present in the Appointment Information Section", Status.FAIL);
			} else {
				report.updateTestLog("Verify Appointment Information Section",
						"All fields are present in the Appointment Information Section", Status.PASS);
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		List<WebElement> closeInformationFields = driver.findElements(By.xpath(
				"//span[contains(text(),'Close Information')]/parent::h3/following-sibling::div//div[contains(@class,'slds-form-element__control')]//label/span[1]"));
		int count5 = 0, i5 = 0, j5 = 0;
		String fieldsArray5[] = new String[closeInformationFields.size()];
		System.out.println(closeInformationFields.size());
		try {
			closeInformationFields();
			while (j5 < closeInformationFields.size()) {
				for (WebElement element5 : closeInformationFields) {
					fieldsArray5[i5] = element5.getText();
					if (fieldsArray5[i5].equalsIgnoreCase(closeInformationSectionFields.get(j5))) {
						System.out.println("Verify Close Information Section " + element5.getText());
						report.updateTestLog("Verify Close Information Section",
								element5.getText() + "labels  present in the Close Information Section ", Status.PASS);
						count5++;
					}
					i5++;
				}
				i5 = 0;
				j5++;
			}
			System.out.println(count5);
			if (count5 >= 8) {
				report.updateTestLog("Verify Close Information Section",
						"All fields are present in the Close Information Section", Status.PASS);
			} else {
				report.updateTestLog("Verify Close Information Section",
						"All fields are not present in the Close Information Section", Status.FAIL);
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		List<WebElement> lossInformationFields = driver.findElements(By.xpath(
				"//span[contains(text(),'Loss Information')]/parent::h3/following-sibling::div//div[contains(@class,'slds-form-element__control')]//label/span[1]"));
		int count6 = 0, i6 = 0, j6 = 0;
		String fieldsArray6[] = new String[lossInformationFields.size()];
		System.out.println(lossInformationFields.size());
		try {
			lossInformationSectionFields();
			while (j6 < lossInformationFields.size()) {
				for (WebElement element6 : lossInformationFields) {
					fieldsArray6[i6] = element6.getText();
					if (fieldsArray6[i6].equalsIgnoreCase(lossInformationSectionFields.get(j6))) {
						System.out.println("Verify Opportunity Information Section " + element6.getText());
						report.updateTestLog("Verify Opportunity Information Section",
								element6.getText() + "labels  present in the Opportunity Information Section ",
								Status.PASS);
						count6++;
					}
					i6++;
				}
				i6 = 0;
				j6++;
			}
			System.out.println(count6);
			if (count6 != 2) {
				report.updateTestLog("Verify Opportunity Information Section",
						"All fields are not present in the Opportunity Information Section", Status.FAIL);
			} else {
				report.updateTestLog("Verify Property Details Section",
						"All fields are present in the Opportunity Information Section", Status.PASS);
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		List<WebElement> systemInformationFields = driver.findElements(By.xpath(
				"//span[contains(text(),'System Information')]/parent::h3/following-sibling::div//div[contains(@class,'slds-form-element__control')]//label/span[1]"));
		int count7 = 0, i7 = 0, j7 = 0;
		String fieldsArray7[] = new String[systemInformationFields.size()];
		System.out.println(systemInformationFields.size());
		try {
			systemInformationSectionFields();
			while (j7 < systemInformationFields.size()) {
				for (WebElement element7 : systemInformationFields) {
					fieldsArray7[i7] = element7.getText();
					if (fieldsArray7[i7].equalsIgnoreCase(systemInformationSectionFields.get(j7))) {
						System.out.println("Verify Opportunity Information Section " + element7.getText());
						report.updateTestLog("Verify Opportunity Information Section",
								element7.getText() + "labels  present in the Opportunity Information Section ",
								Status.PASS);
						count7++;
					}
					i7++;
				}
				i7 = 0;
				j7++;
			}
			System.out.println(count7);
			if (count7 != 2) {
				report.updateTestLog("Verify Opportunity Information Section",
						"All fields are not present in the Opportunity Information Section", Status.FAIL);
			} else {
				report.updateTestLog("Verify Property Details Section",
						"All fields are present in the Opportunity Information Section", Status.PASS);
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		Utility_Functions.xWaitForElementPresent(driver, targetProperty, 3);
		String targetPropertyName = searchTextSOQL.fetchRecord("Property__c ", "Name");
		Utility_Functions.xSendKeys(driver, targetProperty, targetPropertyName);
		WebElement firstLookupElement = driver
				.findElement(By.cssSelector("ul>li.forceSearchInputLookupDesktopOption:nth-child(1)"));
		Utility_Functions.xWaitForElementPresent(driver, firstLookupElement, 3);
		Utility_Functions.xClick(driver, firstLookupElement, true);
		Utility_Functions.xWaitForElementPresent(driver, opportunityNameAS, 3);
		Utility_Functions.xSendKeys(driver, opportunityNameAS,
				"Test Automation Opportunity_" + Utility_Functions.xGenerateAlphaNumericString());
		Utility_Functions.xWaitForElementPresent(driver, accountNameNewOpportunity, 3);
		String accountName = searchTextSOQL.fetchRecord("Account", "Name");
		Utility_Functions.xSendKeys(driver, accountNameNewOpportunity, accountName);
		WebElement firstLookupElementAccount = driver
				.findElement(By.cssSelector("ul>li.forceSearchInputLookupDesktopOption:nth-child(1)"));
		Utility_Functions.xWaitForElementPresent(driver, firstLookupElementAccount, 3);
		Utility_Functions.xClick(driver, firstLookupElementAccount, true);
		Utility_Functions.xWaitForElementPresent(driver, leadSourceNewOpp, 3);
		Utility_Functions.xClick(driver, leadSourceNewOpp, true);
		Utility_Functions.xWaitForElementPresent(driver, leadSourceNewOppValue, 3);
		Utility_Functions.xClick(driver, leadSourceNewOppValue, true);
		System.out.println(Calendar.getInstance());
		DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
		Date date = new Date();
		Utility_Functions.xWaitForElementPresent(driver, closeDate_AS, 3);
		Utility_Functions.xSendKeys(driver, closeDate_AS, dateFormat.format(date).toString());
		Utility_Functions.xWaitForElementPresent(driver, estiamtedGrossFeeCommissionValue, 5);
		Utility_Functions.xSendKeys(driver, estiamtedGrossFeeCommissionValue,
				dataTable.getData("General_Data", "InstallmentAmount"));
		Utility_Functions.xWaitForElementPresent(driver, estimatedTransactionValue, 5);
		Utility_Functions.xSendKeys(driver, estimatedTransactionValue,
				dataTable.getData("General_Data", "InstallmentAmount"));
		Utility_Functions.xWaitForElementPresent(driver, saveNewOpportunity_AS, 3);
		Utility_Functions.xClick(driver, saveNewOpportunity_AS, true);
		Utility_Functions.timeWait(5);
		if (details.isDisplayed()) {

			report.updateTestLog("Verify Quick Create Opportunity Page ",
					"The opportunity is saved with the mandatory fields ", Status.PASS);
		} else {
			report.updateTestLog("Verify Quick Create Opportunity Page ",
					"The opportunity is not saved with the mandatory fields", Status.FAIL);
		}
	}
	
	/**
	 * Validating the update on existing fields in VAS Opportunity Record layout
	 * 
	 * @author Vishnuvardhan
	 *
	 */

	static ArrayList<String> competitorsListValues = new ArrayList<String>();

	public void competitorsListValues() {
		competitorsListValues.add("AEI");
		competitorsListValues.add("ATC");
		competitorsListValues.add("BBG");
		competitorsListValues.add("Colliers");
		competitorsListValues.add("Cushman & Wakefield");
		competitorsListValues.add("EBI");
		competitorsListValues.add("EMG");
		competitorsListValues.add("GRS");
		competitorsListValues.add("Integra");
		competitorsListValues.add("Marx Okubo");
		competitorsListValues.add("Newmark");
		competitorsListValues.add("NPV");
		competitorsListValues.add("Other");
		competitorsListValues.add("Partner Engineering");
		competitorsListValues.add("Pond Robinson");
		competitorsListValues.add("Terracon");
		competitorsListValues.add("Valbridge");
		System.out.println("Competitors List Values are:::" + competitorsListValues);
	}

	static ArrayList<String> regionListValues = new ArrayList<String>();

	public void regionList() {
		regionListValues.add("--None--");
		regionListValues.add("US National");
		regionListValues.add("US Southeast");
		regionListValues.add("US West");
		regionListValues.add("US Northeast");
		System.out.println("Region Values are:::" + regionListValues);
	}

	static ArrayList<String> scopeWonValues = new ArrayList<String>();

	public void scopeWon() {
		scopeWonValues.add("Appraisal");
		scopeWonValues.add("Environment");
		scopeWonValues.add("Facility Assessment");
		scopeWonValues.add("Property Condition");
		scopeWonValues.add("Telecom");
		System.out.println("Scope Won List Values are:::" + scopeWonValues);
	}

	static ArrayList<String> scopeLostValues = new ArrayList<String>();

	public void scopeLost() {
		scopeLostValues.add("Appraisal");
		scopeLostValues.add("Environment");
		scopeLostValues.add("Facility Assessment");
		scopeLostValues.add("Property Condition");
		scopeLostValues.add("Telecom");
		System.out.println("Scope Lost List Values are:::" + scopeLostValues);
	}
	
	@FindBy(xpath = "//span[text()='Unit of Measure']/parent::span/parent::div/parent::div//a[text()='Assets']")
	WebElement unitOfMeasureDefaultValue;

	@FindBy(xpath = "//span[contains(text(),'Region')]/parent::span/parent::div//a")
	WebElement regionMenu;

	public void opportunityRecordLayoutVAS() {
		opportunitiesPage.selectNewOpportunity();
		Utility_Functions.xWaitForElementPresent(driver, unitOfMeasureDefaultValue, 3);
		if (unitOfMeasureDefaultValue.getText().equals("Assets")) {
			report.updateTestLog("Verify Unit of Measure",
					"Unit of Mesaure default value is populated as:::" + unitOfMeasureDefaultValue.getText(),
					Status.PASS);
		} else {
			report.updateTestLog("Verify Unit of Measure", "Unit of Mesaure default value is not populated as Assets",
					Status.FAIL);
		}
		competitorsListValues();
		List<WebElement> competitors = driver.findElements(
				By.xpath("//span[contains(text(),'Pitch Competitors')]/parent::label/parent::div//select/option"));
		int i1 = 0, j = 0, countLabelList = 0;
		String[] labelTexts = new String[competitors.size()];
		while (j < competitors.size()) {
			for (WebElement element : competitors) {
				labelTexts[i1] = element.getText();
				if (labelTexts[i1].contains(competitorsListValues.get(j))) {
					System.out.println("Verify Competitors List Values:::" + element.getText());
					report.updateTestLog("Verify Competitors List Values",
							element.getText() + "::::Competitors List Value is present", Status.PASS);
					countLabelList++;
				}
				i1++;
			}
			i1 = 0;
			j++;
		}
		System.out.println("Count of labels present in Opportunity Type Pick List are ::" + countLabelList);
		if (countLabelList >= 17) {
			report.updateTestLog("Verify Competitors List Values", "Competitors List values are present", Status.PASS);
		} else {
			report.updateTestLog("Verify Competitors List Values", "Competitors List values are not present",
					Status.FAIL);
		}
		Utility_Functions.xWaitForElementPresent(driver, regionMenu, 3);
		Utility_Functions.xClick(driver, regionMenu, true);
		regionList();
		List<WebElement> regionListElement = driver.findElements(By.xpath("//li[contains(@class,'uiMenuItem')]//a"));
		int i2 = 0, j1 = 0, countLabelList1 = 0;
		String[] labelTexts1 = new String[regionListElement.size()];
		while (j1 < regionListElement.size()) {
			for (WebElement element : regionListElement) {
				labelTexts1[i2] = element.getText();
				if (labelTexts1[i2].contains(regionListValues.get(j1))) {
					System.out.println("Verify Region List Values:::" + element.getText());
					report.updateTestLog("Verify Region List Values",
							element.getText() + "::::Region List Value is present", Status.PASS);
					countLabelList1++;
				}
				i2++;
			}
			i2 = 0;
			j1++;
		}
		System.out.println("Count of labels present in Region List values are ::" + countLabelList1);
		if (countLabelList1 == 5) {
			report.updateTestLog("Verify Region List Values", "Region List values are present", Status.PASS);
		} else {
			report.updateTestLog("Verify REgion List Values", "Region List values are not present", Status.FAIL);
		}
		scopeWon();
		List<WebElement> scopeWonListValues = driver
				.findElements(By.xpath("//span[text()='Scope Won']/parent::label/parent::div//select/option"));
		int i3 = 0, j2 = 0, countLabelList2 = 0;
		String[] labelTexts2 = new String[scopeWonListValues.size()];
		while (j2 < scopeWonListValues.size()) {
			for (WebElement element : scopeWonListValues) {
				labelTexts2[i3] = element.getText();
				if (labelTexts2[i3].contains(scopeWonValues.get(j2))) {
					System.out.println("Verify Scope Won Values:::" + element.getText());
					report.updateTestLog("Verify Scope Won Values",
							element.getText() + "::::Scope Won List Value is present", Status.PASS);
					countLabelList2++;
				}
				i3++;
			}
			i3 = 0;
			j2++;
		}
		System.out.println("Count of labels present in Scope Won List values are ::" + countLabelList2);
		if (countLabelList2 == 5) {
			report.updateTestLog("Verify Scope Won List Values", "Scope Won List values are present", Status.PASS);
		} else {
			report.updateTestLog("Verify Scope Won List Values", "Scope Won List values are not present", Status.FAIL);
		}
		scopeLost();
		List<WebElement> scopeLostListValues = driver
				.findElements(By.xpath("//span[text()='Scope Lost']/parent::label/parent::div//select/option"));
		int i4 = 0, j3 = 0, countLabelList3 = 0;
		String[] labelTexts3 = new String[scopeLostListValues.size()];
		while (j3 < scopeLostListValues.size()) {
			for (WebElement element : scopeLostListValues) {
				labelTexts3[i4] = element.getText();
				if (labelTexts3[i4].contains(scopeLostValues.get(j3))) {
					System.out.println("Verify Scope Lost Values:::" + element.getText());
					report.updateTestLog("Verify Scope Lost Values",
							element.getText() + "::::Scope Lost List Value is present", Status.PASS);
					countLabelList3++;
				}
				i4++;
			}
			i4 = 0;
			j3++;
		}
		System.out.println("Count of labels present in Scope Lost List values are ::" + countLabelList3);
		if (countLabelList3 == 5) {
			report.updateTestLog("Verify Scope Lost List Values", "Scope Lost List values are present", Status.PASS);
		} else {
			report.updateTestLog("Verify Scope Lost List Values", "Scope Lost List values are not present",
					Status.FAIL);
		}
	}
	
	
		
}
