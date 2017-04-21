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

	@FindBy(xpath = "//div[@class='slds-context-bar oneGlobalNav']//span[text()='Home']")
	WebElement menu_home;

	@FindBy(xpath = "//div[@class='slds-context-bar oneGlobalNav']//span[text()='Opportunities']")
	WebElement menu_Opportunities;

	@FindBy(xpath = "//div[@title='Sharing'][text()='Sharing']")
	WebElement sharingButton;

	@FindBy(xpath = "//input[@name='new'][@value=' Add ']")
	WebElement addButton;

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

	@FindBy(xpath = "//span[text()='View All Fields']")
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

	@FindBy(xpath = "//*[text()='Clone']/parent::a/parent::li/parent::ul/li/a/div[text()='Edit']")
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

	HomePage hp = new HomePage(scriptHelper);

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
		Utility_Functions.timeWait(1);
		Utility_Functions.xClick(driver, menu_Opportunities, true);
		Utility_Functions.timeWait(1);
		Utility_Functions.xClick(driver, newOpportunity, true);
		Utility_Functions.timeWait(2);
		driver.switchTo().frame(driver.findElement(By.xpath("//iframe[contains(@src,'OpportunityDefault')]")));
		Utility_Functions.timeWait(1);
		Utility_Functions.xClick(driver, continueButton, true);
		Utility_Functions.timeWait(2);
		Utility_Functions.xScrollWindow(driver);
		Utility_Functions.timeWait(1);
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
		String query = "SELECT Id, Name FROM Opportunity where StageName > '03-RFP/Proposal' and StageName < '15-Signed Lease' and Total_Size__c !=null limit 10";
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
		Utility_Functions.xScrollWindowOnce(driver);
		Utility_Functions.xScrollWindowTop(driver);
		Utility_Functions.xWaitForElementVisible(driver, totalSizeValue, 5);
		Utility_Functions.xWaitForElementVisible(driver, preferredPropertyTypeValue, 3);
		try {
			if (!(totalSizeValue.getText().equals("")) && !(preferredPropertyType.getText().equals(" "))) {
				report.updateTestLog("Verify Add Opportunity Page Fields",
						"Total Size Value and Preferred Property Type fields has values present", Status.PASS);
			} else {
				report.updateTestLog("Verify Add Opportunity Page Fields",
						"Total Size Value and Preferred Property Type fields has values present", Status.WARNING);
			}
		} catch (Exception e) {
			e.getMessage();
		}
		/*
		 * Utility_Functions.xClick(driver, editButton, true);
		 * Utility_Functions.timeWait(2);
		 */

		/*
		 * //WebElement webElement_View = driver.findElement(By);
		 * ((JavascriptExecutor)
		 * driver).executeScript("arguments[0].scrollIntoView();",
		 * salesStageLabel); Utility_Functions.timeWait(3); JavascriptExecutor
		 * executor = (JavascriptExecutor)driver;
		 * executor.executeScript("arguments[0].click();", salesStageLabel);
		 * 
		 * Utility_Functions.xContainsSwitch(driver, "Edit HBK Data Center");
		 * Utility_Functions.xScrollWindowOnce(driver); JavascriptExecutor js =
		 * (JavascriptExecutor) driver;
		 * js.executeScript("arguments[0].scrollIntoView(true);",salesStageLabel
		 * ); Utility_Functions.timeWait(1);
		 * Utility_Functions.xWaitForElementVisible(driver, selectSalesStage,
		 * 3); Utility_Functions.xSelectDropdownByIndex(selectSalesStage, 17);
		 * Utility_Functions.timeWait(2); Utility_Functions.xClick(driver,
		 * saveButtonSalesStage, true);
		 * Utility_Functions.xWaitForElementVisible(driver, menu_home, 3);
		 * if(menu_home.isDisplayed()) {
		 * report.updateTestLog("Verify Add Opportunity Page Fields",
		 * "Opportunity has been saved successfully ", Status.PASS); } else {
		 * report.updateTestLog("Verify Add Opportunity Page Fields",
		 * "Failed to save the Opportunity ", Status.FAIL); }
		 */

		OpportunitiesFunctions update = new OpportunitiesFunctions(scriptHelper);
		String newopportunityID = "'" + OpportunityID + "' ";
		update.updateOpportunityField("StageName", newopportunityID);
		String updateQuery = "SELECT Id, Name, StageName FROM Opportunity where Id = " + newopportunityID;
		searchOpportunity.searchOpportunity(updateQuery);
		String resultQuery = "SELECT Id, Name, StageName FROM Opportunity where Id = " + newopportunityID;
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
		/*
		 * Utility_Functions.xScrollWindowOnce(driver);
		 * Utility_Functions.xScrollWindowTop(driver);
		 */
		validateOpportunityFields(OpportunityID);
		driver.navigate().refresh();
		Utility_Functions.timeWait(4);
		try {
			int count = 0;
			if (!totalSizeValue.getText().equals("")) {
				report.updateTestLog("Verify Opportunity Fields",
						"Total Size field is not blank:::" + totalSize.getText() + " opportunity saved successfully",
						Status.PASS);
				count++;
			}
			if (!preferredPropertyType.getText().equals("")) {
				report.updateTestLog("Verify Opportunity Fields", "PreferredPropertyType field is blank:::"
						+ preferredPropertyType.getText() + " opportunity saved successfully", Status.PASS);
				count++;
			}
			if (!leaseFrom.getText().equals("")) {
				report.updateTestLog("Verify Opportunity Fields",
						"LeaseFrom field is blank:::" + leaseFrom.getText() + " opportunity saved successfully",
						Status.PASS);
				count++;
			}
			if (!leaseTo.getText().equals("")) {
				report.updateTestLog("Verify Opportunity Fields",
						"LeaseTo field is blank:::" + leaseTo.getText() + " opportunity saved successfully",
						Status.PASS);
				count++;
			}
			if (!leaseTerm.getText().equals("")) {
				report.updateTestLog("Verify Opportunity Fields",
						"LeaseTerm field is blank:::" + leaseTerm.getText() + " opportunity saved successfully",
						Status.PASS);
				count++;
			}
			if (!leaseRate.getText().equals("")) {
				report.updateTestLog("Verify Opportunity Fields",
						"LeaseRate field is blank:::" + leaseRate.getText() + " opportunity saved successfully",
						Status.PASS);
				count++;
			}
			if (!leaseRateRentBasis.getText().equals("")) {
				report.updateTestLog("Verify Opportunity Fields", "LeaseRateRentBasis field is blank:::"
						+ leaseRateRentBasis.getText() + " opportunity saved successfully", Status.PASS);
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
	 * Validating the add Opportunity sharing from the Broker profile
	 * 
	 * @author Vishnuvardhan
	 *
	 */

	public void opportunitySharing() {

		SearchTextSOQL searchOpportunity = new SearchTextSOQL(scriptHelper);
		String queryOpp = "SELECT Id, Name FROM Opportunity where StageName > '16-In Escrow' and StageName < '19-Closed' and Total_Size__c !=null limit 10";
		String Opportunity = searchOpportunity.searchOpportunity(queryOpp);
		String url = driver.getCurrentUrl().split("#")[0];
		String newUrl = url + "#/sObject/" + Opportunity;
		newUrl = newUrl + "/view";
		driver.get(newUrl);
/*		Utility_Functions.xClick(driver, menu_Opportunities, true);
		Utility_Functions.timeWait(2);
		List<WebElement> OpportunitiesList = driver
				.findElements(By.xpath("//a[@class='slds-truncate outputLookupLink slds-truncate forceOutputLookup']"));
		String opportunity = Utility_Functions.xclickgetTextofFirstElementfromList(OpportunitiesList);*/
		Utility_Functions.timeWait(3);
		Utility_Functions.xClick(driver, sharingButton, true);
		Utility_Functions.timeWait(2);
		driver.switchTo().frame(driver.findElement(By.xpath("//iframe[contains(@src,'OpportunitySharingRedirect?')]")));
		Utility_Functions.timeWait(2);
		driver.switchTo().frame(driver.findElement(By.xpath("//iframe[contains(@src,'share/OppSharingDetail?')]")));
		Utility_Functions.timeWait(2);
		Utility_Functions.xClick(driver, addButton, true);
		Utility_Functions.timeWait(2);
		Utility_Functions.xSelectDropdownByName(searchUsers, "Users");
		Utility_Functions.timeWait(1);
		Utility_Functions.xSendKeys(driver, searchUserName, "Vishnu");
		Utility_Functions.timeWait(1);
		Utility_Functions.xClick(driver, findValue, true);
		Utility_Functions.timeWait(1);
		Utility_Functions.xSelectDropdownByName(selectUser, "User: Vishnuvardhan Bommisetty");
		Utility_Functions.timeWait(1);
		Utility_Functions.xClick(driver, rightArrow, true);
		Utility_Functions.timeWait(1);
		Utility_Functions.xSelectDropdownByName(access, "Read/Write");
		Utility_Functions.xClick(driver, saveButton, true);
		Utility_Functions.timeWait(1);
		driver.switchTo().defaultContent();
		LoginPage login = new LoginPage(scriptHelper);
		login.logout();

		OpportunitiesFunctions update = new OpportunitiesFunctions(scriptHelper);
		String newopportunityID = "'" + Opportunity + "' ";
		update.updateOpportunityField("StageName", newopportunityID);
		String updateQuery = "SELECT Id, Name, StageName FROM Opportunity where Id = " + newopportunityID;
		searchOpportunity.searchOpportunity(updateQuery);
		String resultQuery = "SELECT Id, Name, StageName FROM Opportunity where Id = " + newopportunityID;
		String opportunityStage = searchOpportunity.fetchRecordFieldValue("StageName", resultQuery);
		System.out.println(opportunityStage);
		if (opportunityStage.contains("Closed")) {
			report.updateTestLog("Verify Opportunity Update", "Opportunity has been updated successfully", Status.PASS);
		} else {
			report.updateTestLog("Verify Opportunity Update",
					"Sales Stage updation has been failed which is working as expected", Status.FAIL);
		}

		/*
		 * Utility_Functions.timeWait(4); LoginPage login = new
		 * LoginPage(scriptHelper); login.login();
		 * Utility_Functions.timeWait(2); SearchTextSOQL searchOpportunity = new
		 * SearchTextSOQL(scriptHelper); String opportunityName = "'" +
		 * opportunity + "' "; String query =
		 * "SELECT Id FROM Opportunity where Name = " + opportunityName; String
		 * OpportunityID = searchOpportunity.searchOpportunity(query);
		 * report.updateTestLog("Verify Opportunity Required Fields",
		 * "Opportunity retrived from database is:::" + OpportunityID,
		 * Status.PASS); String url = driver.getCurrentUrl().split("#")[0];
		 * String newUrl = url + "#/sObject/" + OpportunityID; newUrl = newUrl +
		 * "/view"; report.updateTestLog("Verify Add Opportunity Page Fields",
		 * "URL has been replaced with the new URL having the retrieved Opportunity:::"
		 * + newUrl, Status.PASS); driver.get(newUrl);
		 * Utility_Functions.timeWait(3); Utility_Functions.xClick(driver,
		 * editButton, true); Utility_Functions.timeWait(2);
		 * opportunityNameUpdate.clear(); String updatedOpportunityName =
		 * opportunity + "Updated"; Utility_Functions.xSendKeys(driver,
		 * opportunityNameUpdate, updatedOpportunityName);
		 * Utility_Functions.timeWait(2);
		 * Utility_Functions.xScrollWindow(driver);
		 * Utility_Functions.xScrollWindowTop(driver);
		 * 
		 * // Utility_Functions.xClick(driver, saveOpportunityUpdate, true); //
		 * WebElement webElement_View = driver.findElement(By);
		 * ((JavascriptExecutor)
		 * driver).executeScript("arguments[0].scrollIntoView();",
		 * salesStageLabel); Utility_Functions.timeWait(3); JavascriptExecutor
		 * executor = (JavascriptExecutor) driver;
		 * executor.executeScript("arguments[0].click();", salesStageLabel);
		 */

	}

	/**
	 * Validating the required fields at Sales Stage for Opportunities
	 * 
	 * @author Vishnuvardhan
	 *
	 */

	/*
	 * public void requiredFields_SalesStage_Opportunities() {
	 * hp.validate_Menu_Opportunities(); try { Utility_Functions.timeWait(1);
	 * List<WebElement> opportunityList = driver.findElements( By.
	 * xpath("//a[@class='slds-truncate outputLookupLink slds-truncate forceOutputLookup']"
	 * ));
	 * Utility_Functions.xclickgetTextofFirstElementfromList(opportunityList);
	 * Utility_Functions.timeWait(3); validateOpportunityFields();
	 * Utility_Functions.xClick(driver, edit, true);
	 * Utility_Functions.timeWait(4); Utility_Functions.xScrollWindow(driver);
	 * Utility_Functions.xSelectDropdownByIndex(occupierLease, 5);
	 * Utility_Functions.timeWait(1);
	 * Utility_Functions.xSelectDropdownByIndex(selectStage, 16);
	 * Utility_Functions.timeWait(1); Utility_Functions.xClick(driver, save,
	 * true); Utility_Functions.timeWait(5); if (opportunitySaved.isDisplayed())
	 * { report.updateTestLog("Verify Opportunity",
	 * "Opportunity saved successfully:::", Status.PASS); } else {
	 * report.updateTestLog("Verify Opportunity",
	 * "Opportunity didn't get saved:::", Status.FAIL); } } catch (Exception e)
	 * { e.printStackTrace(); System.out.println(e.getMessage()); } }
	 */

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
		System.out.println(totalSizeValue.getText());

		try {
			if (!totalSizeValue.getText().equals("")) {
				report.updateTestLog("Verify Opportunity Fields",
						"Total Size field is not blank:::" + totalSize.getText(), Status.PASS);
			} else {
				report.updateTestLog("Verify Opportunity Fields", "Total Size field is blank:::" + totalSize.getText(),
						Status.WARNING);
				update.updateOpportunityField("Total_Size__c", newopportunityID);

			}
			if (!preferredPropertyType.getText().equals("")) {
				report.updateTestLog("Verify Opportunity Fields",
						"PreferredPropertyType field is not blank:::" + preferredPropertyType.getText(), Status.PASS);
			} else {
				report.updateTestLog("Verify Opportunity Fields",
						"PreferredPropertyType field is blank:::" + preferredPropertyType.getText(), Status.WARNING);
				update.updateOpportunityField("CBRE_Preferred_Property_Type_c__c", newopportunityID);
				update.updateOpportunityField("	Preferred_Property_Sub_Type__c", newopportunityID);
			}
			if (!leaseFrom.getText().equals("")) {
				report.updateTestLog("Verify Opportunity Fields",
						"LeaseFrom field is not blank:::" + leaseFrom.getText(), Status.PASS);
			} else {
				report.updateTestLog("Verify Opportunity Fields", "LeaseFrom field is blank:::" + leaseFrom.getText(),
						Status.WARNING);
				update.updateOpportunityField("Lease_From__c", newopportunityID);

			}
			if (!leaseTo.getText().equals("")) {
				report.updateTestLog("Verify Opportunity Fields", "LeaseTo field is not blank:::" + leaseTo.getText(),
						Status.PASS);
			} else {
				report.updateTestLog("Verify Opportunity Fields", "LeaseTo field is blank:::" + leaseTo.getText(),
						Status.WARNING);
				update.updateOpportunityField("Lease_To__c", newopportunityID);
			}
			if (!leaseTerm.getText().equals("")) {
				report.updateTestLog("Verify Opportunity Fields",
						"LeaseTerm field is not blank:::" + leaseTerm.getText(), Status.PASS);
			} else {
				report.updateTestLog("Verify Opportunity Fields", "LeaseTerm field is blank:::" + leaseTo.getText(),
						Status.WARNING);
				update.updateOpportunityField("Lease_Term__c", newopportunityID);
			}
			if (!leaseRate.getText().equals("")) {
				report.updateTestLog("Verify Opportunity Fields",
						"LeaseRate field is not blank:::" + leaseRate.getText(), Status.PASS);
			} else {
				report.updateTestLog("Verify Opportunity Fields", "LeaseRate field is blank:::" + leaseRate.getText(),
						Status.WARNING);
				update.updateOpportunityField("Lease_Rate_Rent__c", newopportunityID);
			}
			if (!leaseRateRentBasis.getText().equals("")) {
				report.updateTestLog("Verify Opportunity Fields",
						"LeaseRateRentBasis field is not blank:::" + leaseRateRentBasis.getText(), Status.PASS);
			} else {
				report.updateTestLog("Verify Opportunity Fields",
						"LeaseRateRentBasis field is blank:::" + leaseRateRentBasis.getText(), Status.WARNING);
				update.updateOpportunityField("Lease_Rate_Rent_Basis__c", newopportunityID);
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
}