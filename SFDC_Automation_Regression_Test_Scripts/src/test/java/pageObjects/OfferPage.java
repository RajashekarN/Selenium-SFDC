package pageObjects;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import org.openqa.selenium.By;
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

public class OfferPage extends ReusableLibrary {
	/*
	 * Constructor to initialize the business component library
	 * 
	 * @param scriptHelper The {@link ScriptHelper} object passed from the
	 * {@link DriverScript}
	 */

	public OfferPage(ScriptHelper scriptHelper) {
		super(scriptHelper);
		PageFactory.initElements(driver.getWebDriver(), this);
	}
		

	@FindBy(xpath = "//button[text()='Continue']")
	WebElement continueButton;
	
	@FindBy(xpath = "//input[contains(@placeholder,'Search Properties')]")
	WebElement searchProperties;
	
	@FindBy(xpath = "//div[@title='APAC Property Test - Test CM']")
	WebElement propertyValue;

	@FindBy(xpath = "//div[@title='01BQ2Q8NMECBRE Test SFDC Automation_0401']")
	WebElement searchAccountValue;

	@FindBy(xpath = "//a[@title='01-Prospect']")
	WebElement selectStageValue;

	@FindBy(xpath = "//a[@title='Business Relationship']")
	WebElement leadSourceValue;

	@FindBy(xpath = "//a[contains(@title,'Create Offer')]")
	WebElement createOffer;

	@FindBy(xpath = "//input[contains(@placeholder,'Search Contacts')] ")
	WebElement offerorContact;

	@FindBy(xpath = "//div[contains(@class,'secondaryLabel')][@title='AUCAPACBroker123']")
	WebElement offerorContactValue;

	@FindBy(xpath = "//input[contains(@placeholder,'Search Accounts')]")
	WebElement offerorAccount;

	@FindBy(xpath = "//div[@title='AUCAPACBroker123']/following-sibling::div[@title='2100 Ross Avenue, Dallas, United States']")
	WebElement offerorAccountValue;

	@FindBy(xpath = "//span[contains(text(),'Offer Price')]/parent::label/parent::div/input")
	WebElement offerPrice;

	@FindBy(xpath = "//div[contains(@class,'slds-modal__footer')]//span[text()='Save']")
	WebElement createOfferSave;

	@FindBy(xpath = "//div[@title='Test UOM Auckland Broker']")
	WebElement propertyValue2;

	@FindBy(xpath = "//div[@title='Test Account APAC']")
	WebElement accountValue2;

	@FindBy(xpath = "//article[contains(@class,'forceRelatedListCardDesktop')]//span[text()='Offers']")
	WebElement offers;

	@FindBy(xpath = "//p[@title='Offer Opportunity']")
	WebElement offerOpportunity;

	@FindBy(xpath = "//p[@title='Offer Property']")
	WebElement offerProperty;

	@FindBy(xpath = "//p[@title='Offer Enquiry']")
	WebElement offerEnquiry;

	@FindBy(xpath = "//p[@title='Offeror Account']")
	WebElement offerorAccountHeader;

	@FindBy(xpath = "//p[@title='Offeror Contact']")
	WebElement offerorContactHeader;

	@FindBy(xpath = "//p[@title='Offer Date']")
	WebElement offerDate;

	@FindBy(xpath = "//span[text()='Opportunity Name']/parent::label/parent::div//input")
	WebElement opportunityName_AS;

	@FindBy(xpath = "//input[contains(@placeholder,'Search Accounts')]")
	WebElement searchAccountsNewOpportunity;

	@FindBy(xpath = "//span[text() = 'Lead Source']/parent::span/following-sibling::div//a")
	WebElement leadSourceNewOpportunity;

	@FindBy(xpath = ".//label[@class='label inputLabel uiLabel-left form-element__label uiLabel']/span[contains(text(),'Estimated Gross Fee/Commission')]/parent::label/parent::div/input")
	WebElement estimatedGrossFeeField;
	
	@FindBy(xpath = "//span[text()='Estimated Transaction Value']/parent::label/parent::div/input")
	WebElement estimatedTransactionValue;
	
	@FindBy(xpath = "//span[text()='Close Date']/parent::label/parent::div//input")
	WebElement closeDate_AS;
	
	@FindBy(xpath = "//span[text()='Sales Stage']/parent::label/parent::div//a")
	WebElement salesStage_AS;

	@FindBy(xpath = "//button[@class='slds-button slds-button--neutral uiButton--default uiButton--brand uiButton forceActionButton']/span[text()='Save']")
	WebElement saveNewOpportunity_AS;
	

	@FindBy(xpath = "//li[contains(@class,'oneActionsDropDown')]//a")
	WebElement showMoreActions;

	@FindBy(xpath = "//a[contains(@title,'New Task')]")
	WebElement newTask;

	@FindBy(xpath = "//a[@class='forceActionLink']/div[@class='slds-truncate'][text()='Clone']")
	WebElement clone;


	@FindBy(xpath = "//a[@class='forceActionLink']/div[@class='slds-truncate'][text()='Edit']")
	WebElement edit;
	
	@FindBy(xpath = "//a[contains(@title,'Show') and contains(@title,'more actions')]")
	WebElement selectNewEvent;
	
	@FindBy(xpath = "//a[@role='menuitem']/span[contains(@class,'slds-truncate')][text()='Campaigns']")
	WebElement campaigns;

	@FindBy(xpath = "//span[contains(@class,'virtualAutocompleteOptionText')][text()='All Active Campaigns']")
	WebElement allActiveCampaigns;
	
	@FindBy(xpath = "//h1//span[text()='Recently Viewed']")
	WebElement recentlyViewed;
	
	@FindBy(xpath = "//span[contains(text(),'Offers')]/ancestor::article//div[text()='New']")
	WebElement offersNew;
	
	@FindBy(xpath = "//span[text()='Next']")
	WebElement offersNextButton;
	

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

	@FindBy(xpath = "//span[text()='Estimated Gross Fee/Commission']/parent::label/parent::div/input")
	WebElement estiamtedGrossFeeCommissionValue;
	
	@FindBy(xpath = "//div[contains(@class,'primaryLabel')]/mark[contains(text(),'Test')]")
	WebElement offerorContactName;

	@FindBy(xpath = "//div[contains(@class,'primaryLabel') and @title='Test Automation 0100']/following-sibling::div[contains(@title,'2100 Ross Avenue, Dallas, United States')]")
	WebElement offerorAccountName;
	
	@FindBy(xpath = "//a[@class='tabHeader']//span[text()='Details']")
	WebElement details;

	SF_UtilityFunctions sf_UtilityFunctions = new SF_UtilityFunctions(scriptHelper);
	OpportunitiesPage opportunitiesPage = new OpportunitiesPage(scriptHelper);
	LoginPage loginPage = new LoginPage(scriptHelper);
	
	/**
	 * Validating the Opportunities and the create offer page fields for the Auckland Broker
	 * 
	 * @author Ramya
	 *
	 */

	public void verifyNewOfferCreationPage() {
		opportunitiesPage.selectNewOpportunity();
		report.updateTestLog("Verify Quick Create Opportunity Page State Street Pick List ",
				"Verifying the Opportunities page is displayed", Status.PASS);

		report.updateTestLog("Verify Quick Create Opportunity Page State Street Pick List  ",
				"Verifying the new opportunity page is displayed", Status.PASS);
		Utility_Functions.xSwitchtoFrame(driver, continueButton);
		Utility_Functions.xWaitForElementPresent(driver, continueButton, 3);
		Utility_Functions.xClick(driver, continueButton, true);
		Utility_Functions.timeWait(2);
		driver.switchTo().defaultContent();
		Utility_Functions.timeWait(2);
		Utility_Functions.xWaitForElementPresent(driver, searchProperties, 3);
		Utility_Functions.xClick(driver, searchProperties, true);
		String environment = loginPage.initializeEnvironment();
		if (environment.equals("FTE")) {
			Utility_Functions.xWaitForElementPresent(driver, searchProperties, 3);
			Utility_Functions.xSendKeys(driver, searchProperties, "UOM Auckland Broker");
			Utility_Functions.xWaitForElementPresent(driver, propertyValue2, 3);
			Utility_Functions.xClick(driver, propertyValue2, true);
		} else {
			Utility_Functions.xWaitForElementPresent(driver, searchProperties, 3);
			Utility_Functions.xSendKeys(driver, searchProperties, "APAC Property Test - Test CM");
			Utility_Functions.xWaitForElementPresent(driver, propertyValue, 3);
			Utility_Functions.xClick(driver, propertyValue, true);
		}
		Utility_Functions.xWaitForElementPresent(driver, opportunityName_AS, 3);
		Utility_Functions.xSendKeys(driver, opportunityName_AS,
				"Test Automation Opportunity_" + Utility_Functions.xGenerateAlphaNumericString());

		String environment1 = loginPage.initializeEnvironment();
		if (environment1.equals("FTE")) {
			Utility_Functions.xWaitForElementPresent(driver, searchAccountsNewOpportunity, 3);
			Utility_Functions.xClick(driver, searchAccountsNewOpportunity, true);
			Utility_Functions.xWaitForElementPresent(driver, searchAccountsNewOpportunity, 3);
			Utility_Functions.xSendKeys(driver, searchAccountsNewOpportunity, "Account APAC");
			Utility_Functions.xWaitForElementPresent(driver, accountValue2, 3);
			Utility_Functions.xClick(driver, accountValue2, true);
		} else {
			Utility_Functions.xWaitForElementPresent(driver, searchAccountsNewOpportunity, 3);
			Utility_Functions.xClick(driver, searchAccountsNewOpportunity, true);
			Utility_Functions.xWaitForElementPresent(driver, searchAccountsNewOpportunity, 3);
			Utility_Functions.xSendKeys(driver, searchAccountsNewOpportunity,
					"01BQ2Q8NMECBRE Test SFDC Automation_0401");
			Utility_Functions.xWaitForElementPresent(driver, searchAccountValue, 3);
			Utility_Functions.xClick(driver, searchAccountValue, true);
		}
		Utility_Functions.xWaitForElementPresent(driver, leadSourceNewOpportunity, 4);
		Utility_Functions.xClick(driver, leadSourceNewOpportunity, true);
		Utility_Functions.xWaitForElementPresent(driver, leadSourceValue, 4);
		Utility_Functions.xClick(driver, leadSourceValue, true);
		Utility_Functions.xWaitForElementPresent(driver, estimatedGrossFeeField, 3);
		Utility_Functions.xSendKeys(driver, estimatedGrossFeeField,
				dataTable.getData("General_Data", "InstallmentAmount"));
		Utility_Functions.xWaitForElementPresent(driver, estimatedTransactionValue, 4);
		Utility_Functions.xSendKeys(driver, estimatedTransactionValue,
				dataTable.getData("General_Data", "InstallmentAmount"));
		System.out.println(Calendar.getInstance());
		DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
		Date date = new Date();
		Utility_Functions.xWaitForElementPresent(driver, closeDate_AS, 3);
		Utility_Functions.xSendKeys(driver, closeDate_AS, dateFormat.format(date).toString());
		Utility_Functions.xWaitForElementPresent(driver, salesStage_AS, 4);
		Utility_Functions.xClick(driver, salesStage_AS, true);
		Utility_Functions.xWaitForElementPresent(driver, selectStageValue, 4);
		Utility_Functions.xClick(driver, selectStageValue, true);
		Utility_Functions.xWaitForElementPresent(driver, saveNewOpportunity_AS, 4);
		Utility_Functions.xClick(driver, saveNewOpportunity_AS, true);
	}
	
	/**
	 * Validating the Opportunities and the create offer page fields for the
	 * Auckland Broker
	 * 
	 * @author Ramya
	 *
	 */
	static ArrayList<String> createOfferFieldsList = new ArrayList<String>();

	public void createOfferPageFields() {

		createOfferFieldsList.add("Offeror Contact");
		createOfferFieldsList.add("Deposit");
		createOfferFieldsList.add("Offer Date");
		createOfferFieldsList.add("Offer Due Diligence Days");
		createOfferFieldsList.add("Offer Price");
		createOfferFieldsList.add("Offer Estimated Settlement Date");
		createOfferFieldsList.add("Source of Financing");
		createOfferFieldsList.add("Winner Offer");
		createOfferFieldsList.add("Approvals/Condition of Sale");
		createOfferFieldsList.add("Comments");
		createOfferFieldsList.add("Offer Name");

		System.out.println("The Fields present in the account details page are " + createOfferFieldsList);

	}

	public void verifyOfferCreationPageFields() {
		verifyNewOfferCreationPage();
		Utility_Functions.xWaitForElementPresent(driver, showMoreActions, 4);
		Utility_Functions.xClick(driver, showMoreActions, true);
		Utility_Functions.xWaitForElementPresent(driver, createOffer, 4);
		Utility_Functions.xClick(driver, createOffer, true);
		Utility_Functions.timeWait(3);
		List<WebElement> createOfferPageList = driver
				.findElements(By.xpath("//label[contains(@class,'form-element__label')]/span[1]"));
		int count1 = 0, i1 = 0, j1 = 0;
		String fieldsArray[] = new String[createOfferPageList.size()];
		System.out.println(createOfferPageList.size());
		try {
			createOfferPageFields();
			while (j1 < createOfferPageList.size()) {
				for (WebElement element1 : createOfferPageList) {
					fieldsArray[i1] = element1.getText();
					if (fieldsArray[i1].equalsIgnoreCase(createOfferFieldsList.get(j1))) {
						System.out.println("Verify Account Details Page " + element1.getText());
						report.updateTestLog("Verify Account Details Page ",
								element1.getText() + "labels  present in the Account Detailed Page ", Status.PASS);
						count1++;
					}
					i1++;
				}
				i1 = 0;
				j1++;
			}
			System.out.println(count1);
			if (count1 != 10) {
				report.updateTestLog("Verify Accounts Details Page",
						"All fields are not present in the Accounts Details Page", Status.FAIL);
			} else {
				report.updateTestLog("Verify Accounts Details Page",
						"All fields are present in the Accounts Details Page", Status.PASS);
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

	}

	/**
	 * Validating the Opportunities create offer page by filling all the
	 * mandatory fields for the Auckland Broker
	 * 
	 * @author Ramya
	 *
	 */

	public void namingConventionOfOfferObject() {

		verifyOfferCreationPageFields();
		Utility_Functions.timeWait(3);
		Utility_Functions.xWaitForElementPresent(driver, offerorAccount, 3);
		Utility_Functions.xClick(driver, offerorAccount, true);
		Utility_Functions.xWaitForElementPresent(driver, offerorAccount, 3);
		Utility_Functions.xSendKeys(driver, offerorAccount, "AUCAPACBroker123");
		Utility_Functions.xWaitForElementPresent(driver, offerorAccountValue, 3);
		Utility_Functions.xClick(driver, offerorAccountValue, true);
		Utility_Functions.xWaitForElementPresent(driver, offerorContact, 3);
		Utility_Functions.xClick(driver, offerorContact, true);
		Utility_Functions.xWaitForElementPresent(driver, offerorContact, 3);
		Utility_Functions.xSendKeys(driver, offerorContact, "AUCAPACBroker123");
		Utility_Functions.xWaitForElementPresent(driver, offerorContactValue, 3);
		Utility_Functions.xClick(driver, offerorContactValue, true);
		Utility_Functions.xWaitForElementPresent(driver, offerPrice, 3);
		Utility_Functions.xSendKeys(driver, offerPrice, dataTable.getData("General_Data", "InstallmentAmount"));
		Utility_Functions.xWaitForElementPresent(driver, createOfferSave, 3);
		Utility_Functions.xClick(driver, createOfferSave, true);
		Utility_Functions.timeWait(3);

	}

	/**
	 * Validating the related list of offer objects
	 * 
	 * @author Ramya
	 *
	 */

	public void relatedListOfOfferObject() {
		namingConventionOfOfferObject();
		Utility_Functions.timeWait(3);
		Utility_Functions.xWaitForElementPresent(driver, showMoreActions, 4);
		Utility_Functions.xClick(driver, showMoreActions, true);
		if (/* (newEvent.isDisplayed())&& */(newTask.isDisplayed())) {
			System.out.println("New Event and New task are displayed");
			report.updateTestLog("Verify Related List of Offer Objects ",
					"Verifying the New Event and New Task are displayed ", Status.PASS);
		} else {
			System.out.println("New Event and New task are not displayed");
			report.updateTestLog("Verify Related List of Offer Objects ",
					"Verifying the New Event and New Task are not displayed", Status.FAIL);
		}

	}

	/**
	 * Validating the buttons on the offer object
	 * 
	 * @author Ramya
	 *
	 */

	public void buttonsOnOfferObject() {
		namingConventionOfOfferObject();
		if ((edit.isDisplayed()) && (clone.isDisplayed())) {
			System.out.println("Edit and Clone buttons are displayed");
			report.updateTestLog("Verify Buttons on Offer Object ", "The Edit and Clone buttons are displayed ",
					Status.PASS);
		} else {
			System.out.println("New Event and New task are not displayed");
			report.updateTestLog("Verify Buttons on Offer Object ", "The Edit and Clone buttons are not displayed",
					Status.FAIL);
		}

	}

	/**
	 * Validating the headers of the offer object
	 * 
	 * @author Ramya
	 * 
	 *
	 */
	public void headersOfOfferObject() {
		namingConventionOfOfferObject();
		sf_UtilityFunctions.selectTabUIHeaders("Related");
		Utility_Functions.xWaitForElementPresent(driver, offers, 3);
		Utility_Functions.xClick(driver, offers, true);
		Utility_Functions.timeWait(3);
		List<WebElement> accountNamesList = driver.findElements(By.xpath(
				"//a[@class='slds-truncate outputLookupLink slds-truncate forceOutputLookup'][contains(@data-recordid,'a2V')]"));
		Utility_Functions.xclickOnFirstElementfromList(accountNamesList);
		Utility_Functions.timeWait(3);
		if ((offerOpportunity.isDisplayed()) && (offerProperty.isDisplayed()) && (offerEnquiry.isDisplayed())
				&& (offerorAccountHeader.isDisplayed()) && (offerorContactHeader.isDisplayed())
				&& (offerDate.isDisplayed())) {
			System.out.println(
					"Offer Opportunity, Offer Property, Offer Enquiry, Offeror Account, Offeror Contact and Offer Date are displayed on the Offer Header page");
			report.updateTestLog("Verify Offer Header Page",
					"Offer Opportunity, Offer Property, Offer Enquiry, Offeror Account, Offeror Contact and Offer Date are displayed on the Offer Header page",
					Status.PASS);
		} else {
			System.out.println("New Event and New task are not displayed");
			report.updateTestLog("Verify Offer Header Page",
					"Offer Opportunity, Offer Property, Offer Enquiry, Offeror Account, Offeror Contact and Offer Date are not displayed on the Offer Header page",
					Status.FAIL);
		}

	}
	/**
	 * Validating the APAC Offers Creation Page fields
	 * 
	 * @author Vishnuvardhan
	 *
	 */

	static ArrayList<String> OfferCreationPageAPAC = new ArrayList<String>();

	public void OfferCreationPageAPACList() {
		OfferCreationPageAPAC.add("Offer Enquiry");
		OfferCreationPageAPAC.add("Offeror Contact");
		OfferCreationPageAPAC.add("Deposit");
		OfferCreationPageAPAC.add("Offeror Account");
		OfferCreationPageAPAC.add("Offer Due Diligence Days");
		OfferCreationPageAPAC.add("Offer Campaign");
		OfferCreationPageAPAC.add("Offer Estimated Settlement Date");
		OfferCreationPageAPAC.add("Offer Date");
		OfferCreationPageAPAC.add("Source of Financing");
		OfferCreationPageAPAC.add("Offer Price");
		OfferCreationPageAPAC.add("Approvals/Condition of Sale");
		OfferCreationPageAPAC.add("Winner Offer");
		OfferCreationPageAPAC.add("Comments");
		OfferCreationPageAPAC.add("Offer Name");
		System.out.println("Offer Creation Page fields in APAC are:::" + OfferCreationPageAPAC);
	}

	public void offerCreationPageFieldsAPAC() {
		opportunitiesPage.opportunityEligibility();
		Utility_Functions.xWaitForElementPresent(driver, selectNewEvent, 3);
		Utility_Functions.xClick(driver, selectNewEvent, true);
		Utility_Functions.xWaitForElementPresent(driver, createOffer, 3);
		Utility_Functions.xClick(driver, createOffer, true);
		Utility_Functions.timeWait(2);
		OfferCreationPageAPACList();
		List<WebElement> createOfferPageFieldsList = driver
				.findElements(By.xpath("//label[contains(@class,'form-element__label')]/span[1]"));
		int i1 = 0, j = 0, countLabelList = 0;
		String[] labelTexts = new String[createOfferPageFieldsList.size()];
		while (j < OfferCreationPageAPAC.size()) {
			for (WebElement element : createOfferPageFieldsList) {
				labelTexts[i1] = element.getText();
				if (labelTexts[i1].contains(OfferCreationPageAPAC.get(j))) {
					System.out.println("Verify Offer Creatiom Page Fields List" + element.getText());
					report.updateTestLog("Verify Offer Creatiom Page Fields List",
							element.getText() + "::::label is present in Offer Creation Page for APAC", Status.PASS);
					countLabelList++;
				}
				i1++;
			}
			i1 = 0;
			j++;
		}
		System.out.println("Count of labels present in Offer Creation Page are::" + countLabelList);
		if (countLabelList >= 11) {
			report.updateTestLog("Verify Offer Creatiom Page Fields List",
					"All the fields are present in Offer Creation Page for APAC", Status.PASS);
		} else {
			report.updateTestLog("Verify Offer Creatiom Page Fields List",
					"Not all the fields are present in Offer Creation Page for APAC", Status.FAIL);
		}
	}
	


	public void campaignsList() {
		sf_UtilityFunctions.oneAppNavigationTab("More");
		Utility_Functions.xWaitForElementPresent(driver, campaigns, 3);
		Utility_Functions.xClick(driver, campaigns, true);
		List<WebElement> campaignsList = driver
				.findElements(By.xpath("//a[@class='slds-truncate outputLookupLink slds-truncate forceOutputLookup']"));
		if (campaignsList.isEmpty()) {
			Utility_Functions.xWaitForElementPresent(driver, recentlyViewed, 3);
			Utility_Functions.xClick(driver, recentlyViewed, true);
			Utility_Functions.xWaitForElementPresent(driver, allActiveCampaigns, 3);
			Utility_Functions.xClick(driver, allActiveCampaigns, true);
			Utility_Functions.timeWait(2);
			List<WebElement> campaignsListActive = driver.findElements(
					By.xpath("//a[@class='slds-truncate outputLookupLink slds-truncate forceOutputLookup']"));
			if (campaignsListActive.isEmpty()) {
				report.updateTestLog("Active Campaigns List", "There are no Active Campaigns present", Status.PASS);
			} else {
				Utility_Functions.xclickRandomElement(campaignsListActive);
			}
		}
		Utility_Functions.xclickRandomElement(campaignsList);
	}

	/**
	 * Validating the Offers Related List from the APAC Campaign Record
	 * 
	 * @author Vishnuvardhan
	 *
	 */
	
	public void offersReleatedListsCampaignAPAC() {
		campaignsList();
		Utility_Functions.timeWait(2);
		sf_UtilityFunctions.selectTabUIHeaders("Related");
		Utility_Functions.xScrollWindow(driver);
		Utility_Functions.timeWait(1);
		Utility_Functions.xScrollWindowTop(driver);
		Utility_Functions.timeWait(1);
		Utility_Functions.xWaitForElementPresent(driver, offersNew, 3);
		Utility_Functions.xClick(driver, offersNew, true);
		Utility_Functions.xWaitForElementPresent(driver, offersNextButton, 3);
		Utility_Functions.xClick(driver, offersNextButton, true);
		OfferCreationPageAPACList();
		Utility_Functions.timeWait(2);
		List<WebElement> createOfferPageFieldsList = driver
				.findElements(By.xpath("//label[contains(@class,'form-element__label')]/span[1]"));
		int i1 = 0, j = 0, countLabelList = 0;
		String[] labelTexts = new String[createOfferPageFieldsList.size()];
		while (j < OfferCreationPageAPAC.size()) {
			for (WebElement element : createOfferPageFieldsList) {
				labelTexts[i1] = element.getText();
				if (labelTexts[i1].contains(OfferCreationPageAPAC.get(j))) {
					System.out.println("Verify Offer Creatiom Page Fields List" + element.getText());
					report.updateTestLog("Verify Offer Creatiom Page Fields List",
							element.getText() + "::::label is present in Offer Creation Page for APAC", Status.PASS);
					countLabelList++;
				}
				i1++;
			}
			i1 = 0;
			j++;
		}
		System.out.println("Count of labels present in Offer Creation Page are::" + countLabelList);
		if (countLabelList >= 4) {
			report.updateTestLog("Verify Offer Creation Page Fields List",
					"All the fields are present in Offer Creation Page for APAC", Status.PASS);
		} else {
			report.updateTestLog("Verify Offer Creation Page Fields List",
					"Not all the fields are present in Offer Creation Page for APAC", Status.FAIL);
		}
	}
	
	/**
	 * Validating the Opportunity create offer quick action drop down
	 * 
	 * @author Ramya
	 * 
	 *
	 */
	
	
	public void createOfferOpportunityPage() {
		opportunitiesPage.selectNewOpportunity();
		Utility_Functions.timeWait(2);
		Utility_Functions.xSwitchtoFrame(driver, continueButton);
		Utility_Functions.xWaitForElementPresent(driver, continueButton, 3);
		Utility_Functions.xClick(driver, continueButton, true);
		Utility_Functions.timeWait(2);
		driver.switchTo().defaultContent();
		Utility_Functions.timeWait(2);
		Utility_Functions.xWaitForElementPresent(driver, targetProperty, 3);
		WebElement firstLookupElement = driver
				.findElement(By.cssSelector("ul>li.forceSearchInputLookupDesktopOption:nth-child(1)"));
		Utility_Functions.xWaitForElementPresent(driver, firstLookupElement, 3);
		Utility_Functions.xClick(driver, firstLookupElement, true);
		Utility_Functions.xSendKeys(driver, opportunityNameAS,
				"Test Automation Opportunity_" + Utility_Functions.xGenerateAlphaNumericString());
		Utility_Functions.xWaitForElementPresent(driver, accountNameNewOpportunity, 3);
		Utility_Functions.xClick(driver, accountNameNewOpportunity, true);
		WebElement firstLookupAccount = driver
				.findElement(By.cssSelector("ul>li.forceSearchInputLookupDesktopOption:nth-child(1)"));
		Utility_Functions.xWaitForElementPresent(driver, firstLookupAccount, 3);
		Utility_Functions.xClick(driver, firstLookupAccount, true);
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
		Utility_Functions.xWaitForElementPresent(driver, showMoreActions, 3);
		Utility_Functions.xClick(driver, showMoreActions, true);
		Utility_Functions.xWaitForElementPresent(driver, createOffer, 3);
		Utility_Functions.xClick(driver, createOffer, true);
		Utility_Functions.xWaitForElementPresent(driver, offerorAccount, 3);
		Utility_Functions.xSendKeys(driver, offerorAccount, "Test Automation 0100");
		Utility_Functions.xWaitForElementPresent(driver, offerorAccountName, 3);
		Utility_Functions.xClick(driver, offerorAccountName, true);
		Utility_Functions.xWaitForElementPresent(driver, offerorContact, 3);
		Utility_Functions.xSendKeys(driver, offerorContact, "Test Automation 0100");
		Utility_Functions.xWaitForElementPresent(driver, offerorContactName, 3);
		Utility_Functions.xClick(driver, offerorContactName, true);
		Utility_Functions.xWaitForElementPresent(driver, offerPrice, 5);
		Utility_Functions.xSendKeys(driver, offerPrice, dataTable.getData("General_Data", "InstallmentAmount"));
		Utility_Functions.xWaitForElementPresent(driver, createOfferSave, 5);
		Utility_Functions.xClick(driver, createOfferSave, true);
		Utility_Functions.timeWait(2);
		if (details.isDisplayed()) {

			report.updateTestLog("Verify Create Offer from Opportunity",
					"The offer is saved with the mandatory fields ", Status.PASS);
		} else {
			report.updateTestLog("Verify Create Offer from Opportunity",
					"The offer is not saved with the mandatory fields", Status.FAIL);
		}

	}

}
