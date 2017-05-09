package pageObjects;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.cognizant.Craft.ReusableLibrary;
import com.cognizant.Craft.ScriptHelper;
import com.cognizant.framework.Status;
import com.sforce.soap.partner.PartnerConnection;
import com.sforce.soap.partner.QueryResult;
import com.sforce.soap.partner.SaveResult;
import com.sforce.soap.partner.sobject.SObject;
import com.sforce.ws.ConnectionException;
import com.sforce.ws.ConnectorConfig;

import pagesAPI.EstablishConnection;
import pagesAPI.OpportunitiesFunctions;
import pagesAPI.SearchTextSOQL;
import supportLibraries.Utility_Functions;

/**
 * Page Object Class for Opportunities Page
 * 
 * @author Vishnuvardhan
 *
 */

public class OpportunitiesPage extends ReusableLibrary {
	/*
	 * Constructor to initialize the business component library
	 * 
	 * @param scriptHelper The {@link ScriptHelper} object passed from the
	 * {@link DriverScript}
	 */

	public OpportunitiesPage(ScriptHelper scriptHelper) {
		super(scriptHelper);
		PageFactory.initElements(driver.getWebDriver(), this);
		// new WebDriverUtil(driver);
		// Utility_Functions utility = new Utility_Functions(scriptHelper);
	}

	@FindBy(xpath = "//div[@class='bBottom']//span[text()='Home']")
	WebElement menu_home;

	@FindBy(xpath = "//div[@class='bBottom']//span[text()='Opportunities']")
	WebElement menu_Opportunities;

	@FindBy(xpath = "//div[@class='slds-truncate'][@title='Sharing'][text()='Sharing']")
	WebElement sharingButton;

	@FindBy(xpath = "//p[text()='Opportunity Sharing']")
	WebElement opportunitySharing;
	
	@FindBy(xpath = "//div[contains(@title, 'Add')]")
	WebElement addButton;

	@FindBy(xpath = "//input[@name='new'][contains(@value,'Add')]")
	WebElement addButtonSharing;
	
	@FindBy(xpath = "//a[contains(text(),'Create')]")
	WebElement createNewLink;

	@FindBy(xpath = "//*[contains(@id,'sharing_search')]")
	WebElement searchUsers;

	@FindBy(xpath = "//*[contains(@id,'searchValue_sharing_search')]")
	WebElement searchUserName;

	@FindBy(xpath = "//*[contains(@title,'Find')]")
	WebElement findValue;

	@FindBy(xpath = "//label[text()='Available']/parent::div/parent::td/select[@id='duel_select_0']")
	WebElement selectUser;

	@FindBy(xpath = "//img[@class='rightArrowIcon']")
	WebElement rightArrow;

	@FindBy(xpath = "//*[@id='p2']")
	WebElement access;

	@FindBy(xpath = "//*[@id='bottomButtonRow']/input[@name='save']")
	WebElement saveButton;

	@FindBy(xpath = "//div[@class='mainBody']//span[contains(text(), 'Total Size')]/parent::div/parent::div/div[2]/div/span")
	WebElement totalSize;

	@FindBy(xpath = "//div[@class='mainBody']//span[contains(text(), 'Preferred Property Type')]/parent::div/parent::div/div[2]/div/span")
	WebElement preferredPropertyType;

	@FindBy(xpath = "//div[@class='mainBody']//span[contains(text(), 'Lease From')]/parent::div/parent::div/div[2]/div/span")
	WebElement leaseFrom;

	@FindBy(xpath = "//div[@class='mainBody']//span[contains(text(), 'Lease To')]/parent::div/parent::div/div[2]/div/span")
	WebElement leaseTo;

	@FindBy(xpath = "//div[@class='mainBody']//span[contains(text(), 'Lease Term (Months)')]/parent::div/parent::div/div[2]/div/span")
	WebElement leaseTerm;

	@FindBy(xpath = "//div[@class='mainBody']//span[contains(text(), 'Lease Rate/Rent')]/parent::div/parent::div/div[2]/div/span")
	WebElement leaseRate;

	@FindBy(xpath = "//div[@class='mainBody']//span[contains(text(), 'Lease Rate/Rent Basis')]/parent::div/parent::div/div[2]/div/span")
	WebElement leaseRateRentBasis;

	@FindBy(xpath = "//a[@class='forceActionLink']/div[@class='slds-truncate'][text()='Edit']")
	WebElement edit;

	@FindBy(xpath = "//div[@class='select-options']/ul/li")
	WebElement occupierLease;

	@FindBy(xpath = "//span[@class='label inputLabel uiPicklistLabel-left form-element__label uiPicklistLabel']/span[text()='Assignment Type']i")
	WebElement assignmentType;

	@FindBy(xpath = "//div[@class='select-options']/ul[@role='presentation']/li")
	WebElement selectStage;

	@FindBy(xpath = "//div[@class='modal-footer slds-modal__footer']//button[@title='Save']")
	WebElement save;

	@FindBy(xpath = "//div[@class='toastContent']//span[@class='slds-icon_container slds-icon-utility-success toastIcon slds-button__icon forceIcon']")
	WebElement opportunitySaved;

	@FindBy(xpath = "//div[@class='slds-truncate'][text()='New']")
	WebElement newOpportunity;

	@FindBy(xpath = "//button[text()='Continue']")
	WebElement continueButton;

	@FindBy(xpath = "//button/span[text()='View All Fields']")
	WebElement viewAllFieldsButton;

	@FindBy(xpath = "//*[contains(@id,'oppForm:oppName')]")
	WebElement opportunityName;

	@FindBy(xpath = "//*[contains(@id,'oppForm:salesStage')]")
	WebElement salesStage;

	@FindBy(xpath = "//*[contains(@id,'oppForm:phaseField')]")
	WebElement phaseField;

	@FindBy(xpath = "//*[contains(@id,'oppForm:probabilityField')]")
	WebElement probabilityField;

	@FindBy(xpath = ".//span[text()='Sales Stage']")
	WebElement salesStageLabel;

	@FindBy(xpath = "//span[text()='Total Size']/parent::div/parent::div/div[2]/div/span")
	WebElement totalSizeValue;

	@FindBy(xpath = "//span[text()='Preferred Property Type']/parent::div/parent::div/div[2]/div/span")
	WebElement preferredPropertyTypeValue;

	/*	@FindBy(xpath = "//*[text()='Clone']/parent::a/parent::li/parent::ul/li/a/div[text()='Edit']")
	WebElement editButton;*/

	@FindBy(xpath="//li[contains(@class,'slds-button slds-button--neutral slds-truncate')]//a[@class='forceActionLink']/div[@class='slds-truncate'][text()='Edit']")
	WebElement editButton; 

	@FindBy(xpath = "//label[@class='label inputLabel uiLabel-left form-element__label uiLabel']/span[text()='Opportunity Name']/parent::label/parent::div/input")
	WebElement opportunityNameUpdate;

	@FindBy(xpath = ".//button[@class='slds-button slds-button--neutral uiButton--default uiButton--brand uiButton forceActionButton']/span[text()='Save']")
	WebElement saveOpportunityUpdate;

	/*
	 * @FindBy(xpath = "//*[text()='Sales Stage']/parent::li/p[2]/span")
	 * WebElement currentSalesStage;
	 * 
	 * @FindBy(xpath = "//li[@class='uiMenuItem uiRadioMenuItem'][17]")
	 * WebElement selectSalesStage;
	 */

	@FindBy(xpath = "//*[text()='Save & New']/parent::button/parent::div/button[3]/span[text()='Save']")
	WebElement saveButtonSalesStage;

	@FindBy(xpath = "//a[@class='tabHeader']//span[text()='Related']")
	WebElement related;

	@FindBy(xpath = "//article[contains(@class,'Property')]//div[text()='Associate Property']")
	WebElement associateProperty;

	@FindBy(xpath = "//div[@class='slds-form-element']/label[text()='Opportunity']")
	WebElement opportunityLabel;

	@FindBy(xpath = "//div[@class='slds-form-element']/label[text()='Opportunity']/parent::div/parent::div/div[1]/div/span")
	WebElement opportunitySelected;

	@FindBy(xpath = "//*[text()='* Property']/parent::div/div/input")
	WebElement findPropertyInput;

	@FindBy(xpath = "//div[@class='slds-col slds-size--1-of-4']/button[text()='Search']")
	WebElement searchButtonProperty;

	@FindBy(xpath = "//label[text()='Final Property']/parent::div/div/input")
	WebElement finalPropertyCheckbox;

	@FindBy(xpath = "//div[@class='slds-text-heading--medium slds-m-bottom--x-large']/parent::div//button/span[text()='Save']")
	WebElement saveButtonProperty;

	@FindBy(xpath = ".//label[@class='label inputLabel uiLabel-left form-element__label uiLabel']/span[contains(text(),'Estimated Gross Fee/Commission')]/parent::label/parent::div/input")
	WebElement estimatedGrossFeeField;

	@FindBy(xpath = "//tr[contains(@class,'parent')][1]//input[contains(@id,'acctSearchBox')]")
	WebElement user1;

	@FindBy(xpath = "//tr[contains(@class,'parent')][2]//input[contains(@id,'acctSearchBox')]")
	WebElement user2;

	@FindBy(xpath = "//input[@id='acctSearchBox2'][@class='tt-search-box slds-input tt-input']")
	WebElement userField1;

	@FindBy(xpath = "//input[@id='acctSearchBox3'][@class='tt-search-box slds-input tt-input']")
	WebElement userField2;

	@FindBy(xpath="//select[@class='slds-select']/option[@value='Team Member']")
	WebElement selectTeamRole; 

	@FindBy(xpath = "//select[@class='slds-select']/option[@value='Originating Broker']")
	WebElement selectSecondaryMemberRole;

	@FindBy(xpath = "//select[@class='slds-select']/option[@value='Edit']")
	WebElement selectOpportunityAccess;

	@FindBy(xpath = "//table[@class='slds-table slds-no-row-hover']//tr[2]/td[3]//option[@value='Revenue Partner']")
	WebElement selectTeamRole2;

	@FindBy(xpath = "//table[@class='slds-table slds-no-row-hover']//tr[2]/td[4]//option[@value='Receiving Broker']")
	WebElement selectSecondaryMemberRole2;

	@FindBy(xpath = "//div[contains(@class, 'slds-truncate') and text()='Manage Opportunity Splits']")
	WebElement manageOpportunitySplits;

	@FindBy(xpath = "// input [@value= 'Save']")
	WebElement saveOpportunitySplit;

	@FindBy(xpath = "//td[contains(@data-label,'Split Percent')]//input")
	WebElement splitPercent;

	@FindBy(xpath = "//input[@value= 'Save']")
	WebElement saveButtonSplit;

	@FindBy(xpath = "//span[text()='Press Delete to Remove']/parent::a/span[@class='deleteIcon']")
	WebElement deleteAccountName;

	@FindBy(xpath = "//input[@placeholder='Search Accounts']")
	WebElement enterNewAccountName;

	@FindBy(xpath = "//div[@class='dotSpinner']")
	WebElement dotSpinner;

	@FindBy(xpath = "//h1//span[text()='Recently Viewed']")
	WebElement recentlyViewed;

	@FindBy(xpath = "//span[contains(@class,'virtualAutocompleteOptionText')][text()='All Active Opportunities']")
	WebElement allActiveOpportunities;

	@FindBy(xpath = "//h2[contains(@id,'title')]")
	WebElement title;	

	@FindBy(xpath = "//input[@id='acctSearchBox'][@placeholder='Search']")
	WebElement accountName;
	
	@FindBy(xpath = "//p[contains(@class,'slds-page-header__title')][@title='Add an Opportunity'][text()='Add an Opportunity']")
	WebElement addAnOpportunityTitle;
	
	

	//input[@placeholder='Search Accounts']

	HomePage hp = new HomePage(scriptHelper);
	SearchTextSOQL searchOpportunity = new SearchTextSOQL(scriptHelper);
	OpportunitiesFunctions opportunitiesFunctions = new OpportunitiesFunctions(scriptHelper);

	/**
	 * Adding the Web Elements to the Label List
	 * 
	 * @author Vishnuvardhan
	 *
	 */

	static ArrayList<String> labelList = new ArrayList<String>();

	public void labelsOpportunityPage() {
		labelList.add("Record Type");
		labelList.add("Account Name");
		labelList.add("Billing City");
		labelList.add("Billing Street");
		labelList.add("Billing State/Province");
		labelList.add("Billing Country");
		labelList.add("Billing Zip/Postal Code");
		labelList.add("Website");
		labelList.add("Phone");
		labelList.add("Industry");
		labelList.add("Account Name");
		labelList.add("Assignment Type");
		labelList.add("Assignment Sub-Type");
		labelList.add("Lead Source");
		labelList.add("Parent Opportunity");
		labelList.add("Opportunity Location");
		labelList.add("Priority");
		labelList.add("Hire Date");
		labelList.add("On Hold Date");
		labelList.add("On Hold Comments");
		labelList.add("Status Comments");
		labelList.add("Preferred Property Sub-Type");
		labelList.add("Existing Termination/Break Option");
		labelList.add("New Termination/Break Option");
		labelList.add("Next Steps");
		labelList.add("Lease From");
		labelList.add("Lease To");
		labelList.add("Lease Term (Months)");
		labelList.add("Lease Rate/Rent");
		labelList.add("Lease Rate/Rent Basis");
		labelList.add("Outside Broker Company");
		labelList.add("CBRE Role");
		labelList.add("Reason for Loss");
		labelList.add("Reason Lost Comments");

		labelList.add("Competitor");
		labelList.add("Opportunity Owner");
		labelList.add("External Deal ID");
	}

	/**
	 * Adding the Web Elements to the Header Section List
	 * 
	 * @author Vishnuvardhan
	 *
	 */
	static ArrayList<String> headerSectionList = new ArrayList<String>();

	public void headerSectionOpportunityPage() {
		// headerSectionList.add("Quick Create");
		headerSectionList.add("Opportunity Information");
		headerSectionList.add("Services");
		headerSectionList.add("Close Information");
		headerSectionList.add("Loss Information");
		headerSectionList.add("System Information");
		System.out.println("Header Section Details present in the new account page are:: " + headerSectionList);
	}

	/**
	 * Validating the New Opportunities Page Layout fields
	 * 
	 * @author Vishnuvardhan
	 *
	 */

	public void newOpportunityPageLayout() {
		headerSectionOpportunityPage();
		labelsOpportunityPage();
		Utility_Functions.xWaitForElementPresent(driver, menu_Opportunities, 3);
		Utility_Functions.xClick(driver, menu_Opportunities, true);
		Utility_Functions.xClick(driver, newOpportunity, true);
		//driver.switchTo().frame(driver.findElement(By.xpath("//iframe[contains(@src,'OpportunityDefault')]")));
		Utility_Functions.timeWait(2);
		Utility_Functions.xSwitchtoFrame(driver, continueButton);
		Utility_Functions.xWaitForElementPresent(driver, continueButton, 5);		
		Utility_Functions.xClick(driver, continueButton, true);		
		driver.switchTo().defaultContent();
		Utility_Functions.xSwitchtoFrame(driver, viewAllFieldsButton);
		Utility_Functions.xWaitForElementPresent(driver, viewAllFieldsButton, 5);
		Utility_Functions.xScrollWindow(driver);
		Utility_Functions.xClick(driver, viewAllFieldsButton, true);
		Utility_Functions.timeWait(1);
		Utility_Functions.xScrollWindowTop(driver);
		List<WebElement> headerList = driver.findElements(
				By.xpath("//h2[@class='slds-text-heading--medium slds-m-top--x-large slds-m-bottom--large']"));
		try {
			int i2 = 0, count = 0;
			String[] headerTexts = new String[headerList.size()];
			for (WebElement element : headerList) {
				headerTexts[i2] = element.getText();
				if (headerTexts[i2].contains(headerSectionList.get(i2))) {
					count++;
					System.out.println("Verify Add Opportunity Header List" + element.getText());
					report.updateTestLog("Verify Add Opportunity Header List",
							element.getText() + " header is present in Add Opportunity Page", Status.PASS);
				}
				i2++;
			}
			System.out.println(count);
			if (count == 5) {
				report.updateTestLog("Verify Add Opportunity Header List", "header is present in Add Opportunity Page",
						Status.PASS);
			} else {
				report.updateTestLog("Verify Add Opportunity Header List",
						"header is not present in Add Opportunity Page", Status.FAIL);
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		try {
			List<WebElement> labelListOpportunitiesPage = driver
					.findElements(By.xpath("//label[@class='slds-form-element__label']"));
			int i1 = 0, countLabelList = 0;
			String[] labelTexts = new String[labelListOpportunitiesPage.size()];
			for (WebElement element : labelListOpportunitiesPage) {
				labelTexts[i1] = element.getText();
				if (labelTexts[i1].contains(labelList.get(i1))) {
					System.out.println("Verify Add Opportunity Page Label List" + element.getText());
					report.updateTestLog("Verify Add Opportunity Page Label List",
							element.getText() + " label list is present in Add Opportunity Page", Status.PASS);
					countLabelList++;
				}
				i1++;
			}

			System.out.println("Count of Label List::" + countLabelList);
			if (countLabelList == 37) {
				report.updateTestLog("Verify Add Opportunity Page Label List",
						"labels are present in Add Opportunity Page", Status.PASS);
			} else {
				report.updateTestLog("Verify Add Opportunity Page Label List",
						"labels are not present in Add Opportunity Page", Status.FAIL);
			}

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		validateFielsOpportunityPageLayout();
	}

	/**
	 * Validating the field values in New Opportunities Page Layout fields
	 * 
	 * @author Vishnuvardhan
	 *
	 */

	public void validateFielsOpportunityPageLayout() {
		if ((!opportunityName.getText().equals(" ")) && (!salesStage.getText().equals(" "))
				&& (!probabilityField.getText().equals(" ") && (!phaseField.getText().equals(" ")))) {
			report.updateTestLog("Verify Add Opportunity Page Fields",
					"Opportunity fields are having values present in the corresponding fields:::", Status.PASS);
		} else {
			report.updateTestLog("Verify Add Opportunity Page Fields",
					"Opportunity fields are not having values present in the corresponding fields:::", Status.FAIL);
		}
	}

	/**
	 * Validating the required fields based on Sales Stage selected between
	 * 03-RFP/Proposal to 15-Signed Lease on Opportunity from a broker profile
	 * 
	 * @author Vishnuvardhan
	 *
	 */

	public void requiredFieldsbetweenw03_05Stages() {

		SearchTextSOQL searchOpportunity = new SearchTextSOQL(scriptHelper);
		String query = "SELECT Id, Name FROM Opportunity where StageName > '03-RFP/Proposal' and StageName < '15-Signed Lease' and Total_Size__c !=null and CBRE_Preferred_Property_Type_c__c !=null limit 10";
		String OpportunityID = searchOpportunity.searchOpportunity(query);
		report.updateTestLog("Verify Opportunity Required Fields",
				"Opportunity retrived from database is:::" + OpportunityID, Status.PASS);
		String url = driver.getCurrentUrl().split("#")[0];
		String newUrl = url + "#/sObject/" + OpportunityID;
		newUrl = newUrl + "/view";
		report.updateTestLog("Verify Add Opportunity Page Fields",
				"URL has been replaced with the new URL having the retrieved Opportunity:::" + newUrl, Status.PASS);
		driver.get(newUrl);
		/*Utility_Functions.timeWait(1);
		Utility_Functions.xScrollWindowOnce(driver);
		Utility_Functions.xScrollWindowTop(driver);
		Utility_Functions.xWaitForElementVisible(driver, totalSizeValue, 5);
		Utility_Functions.xWaitForElementVisible(driver, preferredPropertyTypeValue, 3);*/
		SearchTextSOQL searchTextSOQL = new SearchTextSOQL(scriptHelper);
		String query_TotalSize = "Select Total_Size__c from Opportunity where Id = " + "'" + OpportunityID + "'";
		String totalSize = searchTextSOQL.fetchRecordFieldValue("Total_Size__c", query_TotalSize);
		String query_PreferredPropertyType = "Select CBRE_Preferred_Property_Type_c__c  from Opportunity where Id = " + "'" + OpportunityID + "'";
		String preferredPropertyType = searchTextSOQL.fetchRecordFieldValue("CBRE_Preferred_Property_Type_c__c", query_PreferredPropertyType);
		
		try {
			if (!(totalSize.equals("")) && !(preferredPropertyType.equals(" "))) {
				report.updateTestLog("Verify Add Opportunity Page Fields",
						"Total Size Value and Preferred Property Type fields has values present", Status.PASS);
			} else {
				report.updateTestLog("Verify Add Opportunity Page Fields",
						"Total Size Value and Preferred Property Type fields has values present", Status.FAIL);
			}
		} catch (Exception e) {
			e.getMessage();
		}
		OpportunitiesFunctions update = new OpportunitiesFunctions(scriptHelper);
		update.updateOpportunityField("StageName", OpportunityID);
		update.updateOpportunityField("EMEA_Success_Probability__c", OpportunityID);
		String updateQuery = "SELECT Id, Name, StageName FROM Opportunity where Id = " + "'" + OpportunityID + "'";
		searchOpportunity.searchOpportunity(updateQuery);
		String resultQuery = "SELECT Id, Name, StageName FROM Opportunity where Id = " + "'" + OpportunityID + "'";
		String opportunityStage = searchOpportunity.fetchRecordFieldValue("StageName", resultQuery);
		System.out.println(opportunityStage);
		if (opportunityStage.contains("Closed")) {
			report.updateTestLog("Verify Opportunity Update", "Sales Stage has been updated successfully", Status.PASS);
		} else {
			report.updateTestLog("Verify Opportunity Update", "Sales Stage updation has been failed", Status.FAIL);
		}
	}

	/**
	 * Validating the required fields based on Sales Stage selected between
	 * 16-In Escrow to 19-Closed Lease on Opportunity from a broker profile
	 * 
	 * @author Vishnuvardhan
	 *
	 */

	public void requiredFieldsbetweenw16_19Stages() {
		SearchTextSOQL searchOpportunity = new SearchTextSOQL(scriptHelper);
		String query = "SELECT Id, Name FROM Opportunity where StageName > '16-In Escrow' and StageName < '19-Closed' and Total_Size__c !=null limit 10";
		String OpportunityID = searchOpportunity.searchOpportunity(query);
		report.updateTestLog("Verify Opportunity Required Fields",
				"Opportunity retrived from database is:::" + OpportunityID, Status.PASS);
		String url = driver.getCurrentUrl().split("#")[0];
		String newUrl = url + "#/sObject/" + OpportunityID;
		newUrl = newUrl + "/view";
		report.updateTestLog("Verify Add Opportunity Page Fields",
				"URL has been replaced with the new URL having the retrieved Opportunity:::" + newUrl, Status.PASS);
		driver.get(newUrl);
		Utility_Functions.timeWait(1); 
		validateOpportunityFields(OpportunityID);		
	}

	/**
	 * Validating the add Opportunity sharing from the Broker profile
	 * 
	 * @author Vishnuvardhan
	 *
	 */

	public void opportunitySharing() {

		SearchTextSOQL searchOpportunity = new SearchTextSOQL(scriptHelper);
		String queryOpp = "SELECT Id, Name FROM Opportunity where StageName > '16-In Escrow' and StageName < '17-Closed' and Total_Size__c !=null limit 10";
		String Opportunity = searchOpportunity.searchOpportunity(queryOpp);
		Utility_Functions.xClick(driver, menu_Opportunities, true);
		Utility_Functions.timeWait(2);
		List<WebElement> opportunitiesList = driver.findElements(By.xpath("//a[@class='slds-truncate outputLookupLink slds-truncate forceOutputLookup'][contains(@data-recordid,'006')]"));
		Utility_Functions.xclickRandomElement(opportunitiesList);
		Utility_Functions.timeWait(1);
		String url = driver.getCurrentUrl().split("#")[0];
		String newUrl = url + "#/sObject/" + Opportunity;
		newUrl = newUrl + "/view";
		driver.get(newUrl);
		driver.navigate().refresh();
		Utility_Functions.xWaitForElementPresent(driver, sharingButton, 5);
		Utility_Functions.xClick(driver, sharingButton, true);
		Utility_Functions.timeWait(2);
		Utility_Functions.xSwitchtoFrame(driver, opportunitySharing);
		Utility_Functions.xWaitForElementPresent(driver, opportunitySharing, 4);
		driver.switchTo().defaultContent();		
		Utility_Functions.timeWait(2);
		/*Utility_Functions.xSwitchtoFrame(driver, createNewLink);
		Utility_Functions.xWaitForElementPresent(driver, createNewLink, 4);
		Utility_Functions.timeWait(2);
		driver.switchTo().defaultContent();
		Utility_Functions.timeWait(2);*/
		/*Utility_Functions.xSwitchtoFrame(driver, addButtonSharing);		
		Utility_Functions.xWaitForElementPresent(driver, addButtonSharing, 5);*/
	/*	driver.switchTo().frame(driver.findElement(By.xpath("//iframe[contains(@src,'OpportunitySharingRedirect?')]")));
		Utility_Functions.timeWait(2);*/
		driver.switchTo().frame(driver.findElement(By.xpath("//iframe[contains(@src,'share/OppSharingDetail?')]")));
		Utility_Functions.xWaitForElementPresent(driver, addButtonSharing, 5);
		Utility_Functions.xClick(driver, addButtonSharing, true);
		Utility_Functions.xWaitForElementPresent(driver, searchUsers, 3);
		Utility_Functions.xSelectDropdownByName(searchUsers, "Users");
		Utility_Functions.timeWait(1);
		Utility_Functions.xSendKeys(driver, searchUserName, "Vishnu");
		Utility_Functions.timeWait(1);
		Utility_Functions.xClick(driver, findValue, true);
		Utility_Functions.timeWait(1);
		if (properties.getProperty("RunEnvironment").equals("UAT")) {
			Utility_Functions.xSelectDropdownByName(selectUser, "User: Vishnuvardhan Bommisetty");
		} else {
			Utility_Functions.xSelectDropdownByName(selectUser, "User: vishnuvardhan bommisetty");
		}
		Utility_Functions.timeWait(1);
		Utility_Functions.xClick(driver, rightArrow, true);
		Utility_Functions.timeWait(1);
		Utility_Functions.xSelectDropdownByName(access, "Read Only");
		Utility_Functions.xClick(driver, saveButton, true);
		Utility_Functions.timeWait(1);
		driver.switchTo().defaultContent();
		LoginPage login = new LoginPage(scriptHelper);
		login.logout();

		String newopportunityID = "'" + Opportunity + "' ";
		updateOpportunityStatus("StageName", newopportunityID);
		String updateQuery = "SELECT Id, Name, StageName FROM Opportunity where Id = " + newopportunityID;
		searchOpportunity.searchOpportunity(updateQuery);
		String resultQuery = "SELECT Id, Name, StageName FROM Opportunity where Id = " + newopportunityID;
		String opportunityStage = searchOpportunity.fetchRecordFieldValue("StageName", resultQuery);
		System.out.println(opportunityStage);
		if (opportunityStage.contains("Closed")) {
			report.updateTestLog("Verify Opportunity Update", "Opportunity has been updated successfully", Status.FAIL);
		} else {
			report.updateTestLog("Verify Opportunity Update",
					"Sales Stage updation has been failed which is working as expected", Status.PASS);
		}

	}

	/**
	 * Validating the Opportunity Status field update
	 * 
	 * @author Vishnuvardhan
	 *
	 */
	static PartnerConnection connection = null;
	static ConnectorConfig config;

	public void updateOpportunityStatus(String FieldName, String OpportunityID) {
		try {
			if (properties.getProperty("RunEnvironment").equals("UAT")) {
				String UAT_AuthEndpoint = properties.getProperty("UATAuthEndpoint");
				config = new ConnectorConfig();
				config.setUsername("vishnuvardhan.bommisetty@cbre.com.crm.uat2");
				config.setPassword("Vishnu3704");
				config.setAuthEndpoint(UAT_AuthEndpoint);
			} else if (properties.getProperty("RunEnvironment").equals("FTE")) {
				String FTE_AuthEndpoint = properties.getProperty("FTEAuthEndpoint");
				config = new ConnectorConfig();
				config.setUsername("vishnuvardhan.bommisetty@cbre.com.crm.fte");
				config.setPassword("Vishnu3604");
				config.setAuthEndpoint(FTE_AuthEndpoint);
			}
			connection = new PartnerConnection(config);

			String fieldName = FieldName;
			String opportunityID = OpportunityID;
			SObject[] records = new SObject[1];
			QueryResult queryResults = connection.query("SELECT Id FROM Opportunity Where ID = " + opportunityID);
			System.out.println(queryResults);
			if (queryResults.getSize() > 0) {
				for (int i = 0; i < queryResults.getRecords().length; i++) {
					SObject so = (SObject) queryResults.getRecords()[i];
					SObject soUpdate = new SObject();
					soUpdate.setType("Opportunity");
					soUpdate.setId(so.getId());
					if (fieldName.equals("StageName")) {
						soUpdate.setField(fieldName, "17-Closed");
					}
					records[i] = soUpdate;
					System.out.println(records[i]);
				}
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
			System.out.println(e.getStackTrace());
		}
	}


	/**
	 * Function for validating the Opportunity fields
	 * 
	 * @author Vishnuvardhan
	 *
	 */
	public void validateOpportunityFields(String OpportunityId) {

		Utility_Functions.xScrollWindowOnce(driver);
		Utility_Functions.timeWait(1);
		Utility_Functions.xScrollWindowTop(driver);
		Utility_Functions.timeWait(1);
		String OpportunityID = OpportunityId;

		OpportunitiesFunctions update = new OpportunitiesFunctions(scriptHelper);
		String newopportunityID = "'" + OpportunityID + "' ";
		String totalSize, preferredPropertyType, leaseFrom, leaseTo, leaseTerm, leaseRate, leaseRateRentBasis;

		SearchTextSOQL searchTextSOQL = new SearchTextSOQL(scriptHelper);
		
		String query_TotalSize = "Select Total_Size__c from Opportunity where Id = " + "'" + OpportunityID + "'";
		totalSize = searchTextSOQL.fetchRecordFieldValue("Total_Size__c", query_TotalSize);
		
		String query_PreferredPropertyType = "Select CBRE_Preferred_Property_Type_c__c from Opportunity where Id = " + "'" + OpportunityID + "'";
		preferredPropertyType = searchTextSOQL.fetchRecordFieldValue("CBRE_Preferred_Property_Type_c__c", query_PreferredPropertyType);
		
		String query_LeaseFrom = "Select Lease_From__c from Opportunity where Id = " + "'" + OpportunityID + "'";
		leaseFrom = searchTextSOQL.fetchRecordFieldValue("Lease_From__c", query_LeaseFrom);
		
		String query_LeaseTo = "Select Lease_To__c from Opportunity where Id = " + "'" + OpportunityID + "'";
		leaseTo = searchTextSOQL.fetchRecordFieldValue("Lease_To__c", query_LeaseTo);		
		
		String query_LeaseTerm = "Select Lease_Term__c	from Opportunity where Id = " + "'" + OpportunityID + "'";
		leaseTerm = searchTextSOQL.fetchRecordFieldValue("Lease_Term__c", query_LeaseTerm);
		
		String query_LeaseRate = "Select Lease_Rate_Rent__c	 from Opportunity where Id = " + "'" + OpportunityID + "'";
		leaseRate = searchTextSOQL.fetchRecordFieldValue("Lease_Rate_Rent__c", query_LeaseRate);
		
		String query_LeaseRateRentBasis = "Select Lease_Rate_Rent_Basis__c from Opportunity where Id = " + "'" + OpportunityID + "'";
		leaseRateRentBasis = searchTextSOQL.fetchRecordFieldValue("Lease_Rate_Rent_Basis__c", query_LeaseRateRentBasis);
		
			
		try {
			if (!totalSize.equals("")) {
				report.updateTestLog("Verify Opportunity Fields",
						"Total Size field is not blank:::" + totalSize, Status.PASS);
			} else {
				report.updateTestLog("Verify Opportunity Fields", "Total Size field is blank:::" + totalSize,
						Status.WARNING);
				update.updateOpportunityField("Total_Size__c", newopportunityID);

			}
			if (!preferredPropertyType.equals("")) {
				report.updateTestLog("Verify Opportunity Fields",
						"PreferredPropertyType field is not blank:::" + preferredPropertyType, Status.PASS);
			} else {
				report.updateTestLog("Verify Opportunity Fields",
						"PreferredPropertyType field is blank:::" + preferredPropertyType, Status.WARNING);
				update.updateOpportunityField("CBRE_Preferred_Property_Type_c__c", newopportunityID);
				update.updateOpportunityField("Preferred_Property_Sub_Type__c", newopportunityID);
			}
			if (!leaseFrom.equals("")) {
				report.updateTestLog("Verify Opportunity Fields",
						"LeaseFrom field is not blank:::" + leaseFrom, Status.PASS);
			} else {
				report.updateTestLog("Verify Opportunity Fields", "LeaseFrom field is blank:::" + leaseFrom,
						Status.WARNING);
				update.updateOpportunityField("Lease_From__c", newopportunityID);

			}
			if (!leaseTo.equals("")) {
				report.updateTestLog("Verify Opportunity Fields", "LeaseTo field is not blank:::" + leaseTo,
						Status.PASS);
			} else {
				report.updateTestLog("Verify Opportunity Fields", "LeaseTo field is blank:::" + leaseTo,
						Status.WARNING);
				update.updateOpportunityField("Lease_To__c", newopportunityID);
			}
			if (!leaseTerm.equals("")) {
				report.updateTestLog("Verify Opportunity Fields",
						"LeaseTerm field is not blank:::" + leaseTerm, Status.PASS);
			} else {
				report.updateTestLog("Verify Opportunity Fields", "LeaseTerm field is blank:::" + leaseTo,
						Status.WARNING);
				update.updateOpportunityField("Lease_Term__c", newopportunityID);
			}
			if (!leaseRate.equals("")) {
				report.updateTestLog("Verify Opportunity Fields",
						"LeaseRate field is not blank:::" + leaseRate, Status.PASS);
			} else {
				report.updateTestLog("Verify Opportunity Fields", "LeaseRate field is blank:::" + leaseRate,
						Status.WARNING);
				update.updateOpportunityField("Lease_Rate_Rent__c", newopportunityID);
			}
			if (!leaseRateRentBasis.equals("")) {
				report.updateTestLog("Verify Opportunity Fields",
						"LeaseRateRentBasis field is not blank:::" + leaseRateRentBasis, Status.PASS);
			} else {
				report.updateTestLog("Verify Opportunity Fields",
						"LeaseRateRentBasis field is blank:::" + leaseRateRentBasis, Status.WARNING);
				update.updateOpportunityField("Lease_Rate_Rent_Basis__c", newopportunityID);
			}

		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
		}
		
		driver.navigate().refresh();
		Utility_Functions.timeWait(4);
		try {
			int count = 0;
			if (!totalSize.equals("")) {
				report.updateTestLog("Verify Opportunity Fields",
						"Total Size field is not blank:::" + totalSize + " opportunity saved successfully",
						Status.PASS);
				count++;
			}
			if (!preferredPropertyType.equals("")) {
				report.updateTestLog("Verify Opportunity Fields", "PreferredPropertyType field is blank:::"
						+ preferredPropertyType + " opportunity saved successfully", Status.PASS);
				count++;
			}
			if (!leaseFrom.equals("")) {
				report.updateTestLog("Verify Opportunity Fields",
						"LeaseFrom field is blank:::" + leaseFrom + " opportunity saved successfully",
						Status.PASS);
				count++;
			}
			if (!leaseTo.equals("")) {
				report.updateTestLog("Verify Opportunity Fields",
						"LeaseTo field is blank:::" + leaseTo + " opportunity saved successfully",
						Status.PASS);
				count++;
			}
			if (!leaseTerm.equals("")) {
				report.updateTestLog("Verify Opportunity Fields",
						"LeaseTerm field is blank:::" + leaseTerm + " opportunity saved successfully",
						Status.PASS);
				count++;
			}
			if (!leaseRate.equals("")) {
				report.updateTestLog("Verify Opportunity Fields",
						"LeaseRate field is blank:::" + leaseRate + " opportunity saved successfully",
						Status.PASS);
				count++;
			}
			if (!leaseRateRentBasis.equals("")) {
				report.updateTestLog("Verify Opportunity Fields", "LeaseRateRentBasis field is blank:::"
						+ leaseRateRentBasis + " opportunity saved successfully", Status.PASS);
				count++;
			}
			System.out.println(count);
			if (count == 7) {
				report.updateTestLog("Verify Opportunity Fields", "Opportunity saved successfully", Status.PASS);
			} else {
				report.updateTestLog("Verify Opportunity Fields", "There is an error in saving the opportunity fields",
						Status.FAIL);
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
		}

	}

	/**
	 * Validating the functionality for association of property to an
	 * Opportunity
	 * 
	 * @author Vishnuvardhan
	 *
	 */
	public void associateProperty() {
		Utility_Functions.timeWait(1);
		Utility_Functions.xClick(driver, menu_Opportunities, true);
		Utility_Functions.timeWait(2);
		List<WebElement> OpportunitiesList = driver
				.findElements(By.xpath("//a[@class='slds-truncate outputLookupLink slds-truncate forceOutputLookup']"));
		/*
		 * Random random = new Random(); int randomValue =
		 * random.nextInt(OpportunitiesList.size());
		 * OpportunitiesList.get(randomValue).click();
		 */
		Utility_Functions.xclickOnFirstElementfromList(OpportunitiesList);
		Utility_Functions.timeWait(2);
		Utility_Functions.xClick(driver, related, true);
		Utility_Functions.timeWait(2);
		Utility_Functions.xScrollWindow(driver);
		Utility_Functions.timeWait(1);
		Utility_Functions.xScrollWindowTop(driver);
		Utility_Functions.timeWait(3);
		Utility_Functions.xClick(driver, associateProperty, true);
		Utility_Functions.xWaitForElementVisible(driver, opportunityLabel, 5);
		Utility_Functions.timeWait(1);
		if (!opportunitySelected.getText().equals(" ")) {
			report.updateTestLog("Verify Opportunity Field",
					"Opportunity field is prepopulated with the Opporturnity " + opportunitySelected.getText(),
					Status.PASS);
		} else {
			report.updateTestLog("Verify Opportunity Field",
					"Opportunity field not is prepopulated with the Opporturnity " + opportunitySelected.getText(),
					Status.FAIL);
		}
		Utility_Functions.timeWait(1);
		Utility_Functions.xClick(driver, findPropertyInput, true);
		Utility_Functions.timeWait(2);
		Utility_Functions.xClick(driver, searchButtonProperty, true);
		Utility_Functions.timeWait(2);
		List<WebElement> propertyList = driver.findElements(By.xpath(
				"//table[@class='slds-table slds-table--bordered slds-table--cell-buffer slds-table--fixed-layout cPropertySearch']//th[@class='slds-truncate']/a"));
		Utility_Functions.timeWait(1);
		Utility_Functions.xclickRandomElement(propertyList);
		Utility_Functions.timeWait(2);
		Utility_Functions.xClick(driver, finalPropertyCheckbox, true);
		Utility_Functions.timeWait(2);
		if (saveButtonProperty.isDisplayed()) {
			Utility_Functions.xClick(driver, saveButtonProperty, true);
			report.updateTestLog("Verify Opportunity", "Associate property to an opportunity successfully ",
					Status.PASS);
		} else {
			report.updateTestLog("Verify Opportunity", "Associat property to an opportunity failed ", Status.FAIL);
		}
	}

	/**
	 * Validating the manage Opportunity split functionality
	 * 
	 * @author Ramya
	 *
	 */
	public void opportunitySplitFunctionality() {

		Utility_Functions.xClick(driver, menu_Opportunities, true);
		Utility_Functions.timeWait(4);
		List<WebElement> allActiveOpportunitiesList = driver.findElements(
				By.xpath(".//a[@class='slds-truncate outputLookupLink slds-truncate forceOutputLookup']"));
		Utility_Functions.xclickgetTextofFirstElementfromList(allActiveOpportunitiesList);
		Utility_Functions.timeWait(5);
		Utility_Functions.xClick(driver, editButton, true);
		Utility_Functions.timeWait(4);
		Utility_Functions.xScrollWindowToElement(driver, estimatedGrossFeeField);
		Utility_Functions.timeWait(3);
		Utility_Functions.xClick(driver, estimatedGrossFeeField, true);
		Utility_Functions.timeWait(4);
		Utility_Functions.xSendKeys(driver, estimatedGrossFeeField, "10,000.00");
		Utility_Functions.timeWait(3);
		Utility_Functions.xClick(driver, save, true);
		Utility_Functions.timeWait(3);
		Utility_Functions.xClick(driver, related, true);
		Utility_Functions.timeWait(5);
		Utility_Functions.xClick(driver, addButton, true);
		Utility_Functions.timeWait(3);
		int size = driver.findElements(By.tagName("iframe")).size();
		System.out.println(size);
		Utility_Functions.timeWait(2);
		List<WebElement> iframeList = driver.findElements(By.tagName("iframe"));
		System.out.println(iframeList.size());
		for (WebElement element : iframeList) {
			System.out.println(element.getAttribute("id"));
		}
		driver.switchTo().frame(4);
		// System.out.println("Frame Identified");
		Utility_Functions.timeWait(5);
		List<WebElement> opportunityList = driver.findElements(By.xpath("//div[contains(@class, 'slds-truncate')]"));
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
		Utility_Functions.xClick(driver, saveOpportunitySplit, true);
		report.updateTestLog("Opportunity Saved",
				"Opportunity Saved successfully::", Status.PASS);
		Utility_Functions.timeWait(3);
	}

	/**
	 * Function for retrieving the Opportunity 
	 * 
	 * @author Vishnuvardhan
	 *
	 */	

	public String retriveOpportunity() {
		String query = "SELECT Id, Name FROM Opportunity where StageName < '16-In Escrow'";
		String OpportunityID = searchOpportunity.searchOpportunity(query);
		report.updateTestLog("Verify Opportunity Required Fields",
				"Opportunity retrived from database is:::" + OpportunityID, Status.PASS);
		String url = driver.getCurrentUrl().split("#")[0];
		String newUrl = url + "#/sObject/" + OpportunityID;
		newUrl = newUrl + "/view";
		driver.get(newUrl);
		Utility_Functions.timeWait(1);
		return OpportunityID;
	}

	/**
	 * Function for creating  an Opportunity
	 * 
	 * @author Vishnuvardhan
	 *
	 */

	public String createOpportunity() {
		String accountName = null;
		try {
			establishConnection();
			SObject opportunity = new SObject();
			opportunity.setType("Opportunity");
			//Random random = new Random();
			//int value = random.nextInt(1000);
			//opportunity.setField("Name", "Test Automation_Opportunity" + value);
			//String accountId = createAccount();					
			SearchTextSOQL accountID = new SearchTextSOQL(scriptHelper);
			String accountId = accountID.fetchRecord("Account", "Id");
			String query = "Select Name from Account where Id = " + "'"+ accountId + "'";
			accountName = accountID.fetchRecordFieldValue("Name", query);
			opportunity.setField("AccountId", accountId);
			opportunity.setField("CloseDate", Calendar.getInstance());
			opportunity.setField("RecordTypeId", "012i0000000405n");
			opportunity.setField("StageName", "Qualification");
			opportunity.setField("Service__c", "Business Valuation");
			opportunity.setField("Total_Size__c", 5000);
			opportunity.setField("Unit_of_Measure__c", "Acres");			

			SObject[] opportunities = new SObject[1];
			opportunities[0] = opportunity;
			results = EstablishConnection.connection.create(opportunities);
			System.out.println("Result:::" + results);
			for (int j = 0; j < results.length; j++) {
				if (results[j].isSuccess()) {
					result = results[j].getId();
					System.out.println("Save Results:::" + result);
				}
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
			System.out.println(e.getStackTrace());
		}
		return result + ":" + accountName;

	}

	/**
	 * Validating the Opportunity Account Name modification
	 * 
	 * @author Vishnuvardhan
	 *
	 */	

	public void modifyAccountNameOpportunityAPI() {

	}

	/*public void modifyAccountNameOpportunity() {
		createOpportunity();
		String accountName;
		String OpportunityID = retriveOpportunity();
		Utility_Functions.xWaitForElementVisible(driver, edit, 5);
		Utility_Functions.timeWait(3);
		Utility_Functions.xClick(driver, menu_Opportunities, true);
		Utility_Functions.timeWait(2);		
		Utility_Functions.xClick(driver, recentlyViewed, true);
		Utility_Functions.timeWait(1);
		Utility_Functions.xClick(driver, allActiveOpportunities, true);	
		Utility_Functions.timeWait(2);
		List<WebElement> allOpportunitiesList = driver.findElements(
				By.xpath("//a[@class='slds-truncate outputLookupLink slds-truncate forceOutputLookup'][contains(@data-recordid,'006i')]"));
		Utility_Functions.xclickRandomElement(allOpportunitiesList);			
		//driver.navigate().refresh();
		Utility_Functions.timeWait(3);
		Utility_Functions.xClick(driver, edit, true);
		Utility_Functions.timeWait(2);
		try {

			if(title.isDisplayed()) {
				Utility_Functions.xWaitForElementVisible(driver, deleteAccountName, 5);
				Utility_Functions.xClick(driver, deleteAccountName, true);
				Utility_Functions.xSendKeys(driver, enterNewAccountName, "Test");
				Utility_Functions.timeWait(1);
				List<WebElement> accountList = driver.findElements(By.xpath("//li[@class='lookup__item force default uiAutocompleteOption forceSearchInputLookupDesktopOption']"));
				accountName = Utility_Functions.xclickRandomElement(accountList);
				Utility_Functions.timeWait(1);
				Utility_Functions.xScrollWindow(driver);
				Utility_Functions.timeWait(1);
				Utility_Functions.xScrollWindowTop(driver);
				Utility_Functions.timeWait(1);

			}


		} catch(Exception e) {
			System.out.println(e.getMessage());
		}


		try {
			if(accountList.isEmpty()) {
				AccountsFunctions accountsFunctions = new AccountsFunctions(scriptHelper);
				accountsFunctions.createAccount();
				accountName = searchOpportunity.fetchRecord("Account", "Name");
				Utility_Functions.xSendKeys(driver, enterNewAccountName, accountName);
			} else {
				accountName = Utility_Functions.xclickRandomElement(accountList);
			}
			Utility_Functions.timeWait(1);
			Utility_Functions.xClick(driver, save, true);	
			Utility_Functions.timeWait(5);
			String query = "SELECT Name FROM Opportunity where Id = " + "'" + OpportunityID + "'";
			String opportunityName = searchOpportunity.fetchRecordFieldValue("Name", query);
			opportunitiesFunctions.updateOpportunityField("StageName", OpportunityID);
			opportunitiesFunctions.updateOpportunityField("Service__c", OpportunityID);
			if(accountName.contains(opportunityName)) {
				report.updateTestLog("Opportunity Name","Opportunity name modified successfully::" , Status.PASS);
				report.updateTestLog("Opportunity Name","Opportunity Assignment Type modified successfully::", Status.PASS);
			} else {
				report.updateTestLog("Opportunity Name","Opportunity name modification failed::" , Status.FAIL);
			}
			if(opportunityName.split("-")[1].contains("Project Management")) {
				report.updateTestLog("Opportunity Name","Opportunity name saved with Opportunity Name followed by Assignment Type successfully", Status.PASS);
			} else {
				report.updateTestLog("Opportunity Name","Opportunity name saved with Opportunity Name followed by Assignment Type failed", Status.FAIL);
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}*/
	/**
	 * Validate Opportunity Name is not auto generated when manually added by
	 * the user
	 * 
	 * @author Vishnuvardhan
	 *
	 */

	static SaveResult[] results;
	static String result;

	public void manualOpportunityCreation() {
		try {
			establishConnection();
			SObject opportunity = new SObject();
			Random random = new Random();
			int value = random.nextInt();
			String opportunityName = "Test Automation_Opportunity" + value;
			opportunity.setType("Opportunity");
			opportunity.setField("Name", opportunityName);
			SearchTextSOQL accountID = new SearchTextSOQL(scriptHelper);
			String accountId = accountID.fetchRecord("Account", "Id");
			opportunity.setField("AccountId", accountId);
			opportunity.setField("CloseDate", Calendar.getInstance());
			opportunity.setField("StageName", "Qualification");
			
			if(dataTable.getData("General_Data", "TC_ID").contains("DSF")) {
				opportunity.setField("RecordTypeId", "012i0000000405lAAA");	
				report.updateTestLog("Opportunity Name", "Record type is set as Capital Markets - Debt & Structured Finance:::", Status.PASS);
			} else if(dataTable.getData("General_Data", "TC_ID").contains("PS")) {
				opportunity.setField("RecordTypeId", "012i0000000405kAAA");	
				report.updateTestLog("Opportunity Name", "Record type is set as Property Sales", Status.PASS);
			} else if(dataTable.getData("General_Data", "TC_ID").contains("GWS")) {
				opportunity.setField("RecordTypeId", "012i0000000405mAAA");	
				report.updateTestLog("Opportunity Name", "Record type is set as Global Workplace Solutions", Status.PASS);
			} else if(dataTable.getData("General_Data", "TC_ID").contains("VAS")) {
				opportunity.setField("RecordTypeId", "012i0000000405oAAA");	
				report.updateTestLog("Opportunity Name", "Record type is set as Valuation & Advisory Services", Status.PASS);
			} /*else if(dataTable.getData("General_Data", "TC_ID").contains("AS")) {
				opportunity.setField("RecordTypeId", "012i0000000405jAAA");	
				report.updateTestLog("Opportunity Name", "Record type is set as Asset Services", Status.PASS);
			} */else if(dataTable.getData("General_Data", "TC_ID").contains("AB")) {
				opportunity.setField("RecordTypeId", "012i0000001622CAAQ");	
				report.updateTestLog("Opportunity Name", "Record type is set as Agency Brokerage", Status.PASS);
			} else if(dataTable.getData("General_Data", "TC_ID").contains("OB")) {
				opportunity.setField("RecordTypeId", "012i0000000405nAAA");	
				report.updateTestLog("Opportunity Name", "Record type is set as Occupier Brokerage", Status.PASS);
			}  else {
				opportunity.setField("RecordTypeId", "012i0000000405n");
			}
			SObject[] opportunities = new SObject[1];
			opportunities[0] = opportunity;
			results = EstablishConnection.connection.create(opportunities);
			System.out.println("Result:::" + results);
			for (int j = 0; j < results.length; j++) {
				if (results[j].isSuccess()) {
					result = results[j].getId();
				}
			}
			System.out.println(result);
			SearchTextSOQL searchTextSOQL = new SearchTextSOQL(scriptHelper);
			String query = "Select Name from Opportunity where Id = '" + result + "'";
			String generatedOpportunityName = searchTextSOQL.fetchRecordFieldValue("Name", query);
			Utility_Functions.timeWait(1);
			if (opportunityName.equals(generatedOpportunityName)) {
				report.updateTestLog("Opportunity Name",
						"Opportunity Name is not auto generated when Opportunity is manually added by the User::",
						Status.PASS);
			} else {
				report.updateTestLog("Opportunity Name", "Failure in the Opportunity Name generation:::", Status.FAIL);
			}
			if(dataTable.getData("General_Data", "TC_ID").contains("DSF")) {
				String queryRecordType = "Select RecordTypeId from Opportunity where Id = '" + result + "'";
				String recordType = searchTextSOQL.fetchRecordFieldValue("RecordTypeId", queryRecordType);
				if(recordType.equals("012i0000000405lAAA")) {
					report.updateTestLog("Opportunity Name", "Opportunity is created by selecting the Record Type as Capital Markets - Debt & Structured Finance:::", Status.PASS);
				} else if(recordType.equals("012i0000000405kAAA")) {
					report.updateTestLog("Opportunity Name", "Opportunity is created by selecting the Record Type  as Property Sales:::", Status.PASS);
				} else if(recordType.equals("012i0000000405mAAA")) {
					report.updateTestLog("Opportunity Name", "Opportunity is created by selecting the Record Type  as Global Workplace Solutions:::", Status.PASS);
				} else if(recordType.equals("012i0000000405oAAA")) {
					report.updateTestLog("Opportunity Name", "Opportunity is created by selecting the Record Type  as Valuation & Advisory Services:::", Status.PASS);
				} /*else if(recordType.equals("012i0000000405jAAA")) {
					report.updateTestLog("Opportunity Name", "Opportunity is created by selecting the Record Type  as Asset Services:::", Status.PASS);
				}*/ else if(recordType.equals("012i0000001622CAAQ")) {
					report.updateTestLog("Opportunity Name", "Opportunity is created by selecting the Record Type  as Agency Brokerage:::", Status.PASS);
				} else if(recordType.equals("012i0000000405nAAA")) {
					report.updateTestLog("Opportunity Name", "Opportunity is created by selecting the Record Type  as Occupier Brokerage:::", Status.PASS);
				} else {
					report.updateTestLog("Opportunity Name", "Opportunity is not as created as per the selection:::", Status.FAIL);
				}
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
			System.out.println(e.getStackTrace());
		}
	}

	/**
	 * Function for establishing the connection
	 * 
	 * @author Vishnuvardhan
	 *
	 */

	public void establishConnection() {
		try {
			if (properties.getProperty("RunEnvironment").equals("FTE")) {
				config = new ConnectorConfig();
				if ((dataTable.getData("General_Data", "TC_ID").contains("GWS")) && (dataTable.getData("General_Data", "TC_ID").contains("APAC")) && (dataTable.getData("General_Data", "TC_ID").contains("Manager"))) {
					config.setUsername(properties.getProperty("FTEGWSAPACManager"));
					config.setPassword(properties.getProperty("Password"));
				} else if ((dataTable.getData("General_Data", "TC_ID").contains("GWS"))
						&& (dataTable.getData("General_Data", "TC_ID").contains("EMEA"))
						&& (dataTable.getData("General_Data", "TC_ID").contains("Broker"))) {
					config.setUsername(properties.getProperty("FTEGWSEMEABroker"));
					config.setPassword(properties.getProperty("FTEGWSEMEABrokerPassword"));
				} else if ((dataTable.getData("General_Data", "TC_ID").contains("VAS"))
						&& (dataTable.getData("General_Data", "TC_ID").contains("AMER"))
						&& (dataTable.getData("General_Data", "TC_ID").contains("Manager"))) {
					config.setUsername(properties.getProperty("VASAMERManager"));
					config.setPassword(properties.getProperty("VASAMERManagerPassword"));
				} else if ((dataTable.getData("General_Data", "TC_ID").contains("VAS"))
						&& (dataTable.getData("General_Data", "TC_ID").contains("EMEA"))
						&& (dataTable.getData("General_Data", "TC_ID").contains("Broker"))) {
					config.setUsername(properties.getProperty("VASEMEABroker"));
					config.setPassword(properties.getProperty("VASEMEABrokerPassword"));
				} else if ((dataTable.getData("General_Data", "TC_ID").contains("AS"))
						&& (dataTable.getData("General_Data", "TC_ID").contains("AMER"))
						&& (dataTable.getData("General_Data", "TC_ID").contains("Manager"))) {
					config.setUsername(properties.getProperty("ASAMERManager"));
					config.setPassword(properties.getProperty("ASAMERManagerPassword"));
				} else if ((dataTable.getData("General_Data", "TC_ID").contains("AS"))
						&& (dataTable.getData("General_Data", "TC_ID").contains("APAC"))
						&& (dataTable.getData("General_Data", "TC_ID").contains("Broker"))) {
					config.setUsername(properties.getProperty("ASAPACBroker"));
					config.setPassword(properties.getProperty("ASAPACBrokerPassword"));
				} else if ((dataTable.getData("General_Data", "TC_ID").contains("AB"))
						&& (dataTable.getData("General_Data", "TC_ID").contains("AMER"))
						&& (dataTable.getData("General_Data", "TC_ID").contains("CSS"))) {
					config.setUsername(properties.getProperty("FTEABAMERCSS"));
					config.setPassword(properties.getProperty("Password"));
				} else if ((dataTable.getData("General_Data", "TC_ID").contains("AB"))
						&& (dataTable.getData("General_Data", "TC_ID").contains("APAC"))
						&& (dataTable.getData("General_Data", "TC_ID").contains("Manager"))) {
					config.setUsername(properties.getProperty("FTEABAPACManager"));
					config.setPassword(properties.getProperty("Password"));
				} else if ((dataTable.getData("General_Data", "TC_ID").contains("OB"))
						&& (dataTable.getData("General_Data", "TC_ID").contains("AMER"))
						&& (dataTable.getData("General_Data", "TC_ID").contains("CSS"))) {
					config.setUsername(properties.getProperty("FTEOBAMERCSS"));
					config.setPassword(properties.getProperty("Password"));
				} else if ((dataTable.getData("General_Data", "TC_ID").contains("OB"))
						&& (dataTable.getData("General_Data", "TC_ID").contains("AMER"))
						&& (dataTable.getData("General_Data", "TC_ID").contains("Manager"))) {
					config.setUsername(properties.getProperty("FTEOBAMERManager"));
					config.setPassword(properties.getProperty("Password"));
				}
				config.setAuthEndpoint(properties.getProperty("FTEAuthEndpoint"));
				connection = new PartnerConnection(config);
			} else if (properties.getProperty("RunEnvironment").equals("UAT")) {
				EstablishConnection establishConnection = new EstablishConnection(scriptHelper);
				establishConnection.establishConnection();
			}
		} catch (ConnectionException e) {
			e.printStackTrace();
		}
	}
	/**
	 * Validate Opportunity Name is not auto generated when manually added by the user
	 * 
	 * @author Vishnuvardhan
	 *
	 */

	public void autoGeneratedOpportunityNameFormat() {
		/*String opportunityID_AccountName = createOpportunity();
		String opportunityId = opportunityID_AccountName.split(":")[0];
		String accountName = opportunityID_AccountName.split(":")[1];
		System.out.println(opportunityID_AccountName + "??????????????" + opportunityId + "????????????????" + accountName);*/
		
		Utility_Functions.xClick(driver, menu_Opportunities, true);
		Utility_Functions.timeWait(2);
		Utility_Functions.xWaitForElementPresent(driver, newOpportunity, 3);
		Utility_Functions.xClick(driver, newOpportunity, true);
		driver.switchTo().frame(driver.findElement(By.xpath("//iframe[contains(@src,'OpportunityDefault')]")));
		Utility_Functions.timeWait(1);
		Utility_Functions.xWaitForElementPresent(driver, continueButton, 3);
		Utility_Functions.xClick(driver, continueButton, true);				
		Utility_Functions.xSendKeys(driver, accountName, "Test");
		//accountName.sendKeys(Keys.ARROW_DOWN);
		accountName.sendKeys(Keys.SPACE);
		Utility_Functions.timeWait(2);
		Utility_Functions.xSelectDropdownByIndex(driver.findElement(By.xpath("//span[@class='tt-dropdown-menu']//div[@class='tt-suggestion']")), 10);
		
		/*List<WebElement> accountNameList = driver.findElements(By.xpath("//span[@class='tt-dropdown-menu']//div[@class='tt-suggestion']/p"));
		Utility_Functions.timeWait(2);
		for(WebElement element: accountNameList) {
			Random random = new Random();
			int value = random.nextInt(accountNameList.size());
			for(int i=0;i<=accountNameList.size();i++) {
				if(i==value) {
					Utility_Functions.xSelectDropdownByIndex(accountNameList, value);
				}
			}
		}
		Utility_Functions.xclickgetTextofFirstElementfromList(accountNameList);*/



	}
}