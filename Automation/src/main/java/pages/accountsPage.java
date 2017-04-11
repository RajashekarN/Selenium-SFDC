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

public class accountsPage extends ReusableLibrary {
	/*
	 * Constructor to initialize the business component library
	 * 
	 * @param scriptHelper The {@link ScriptHelper} object passed from the
	 * {@link DriverScript}
	 */

	public accountsPage(ScriptHelper scriptHelper) {
		super(scriptHelper);
		PageFactory.initElements(driver, this);
		// new WebDriverUtil(driver);
		utility = new Utility_Functions(scriptHelper);
	}

	@FindBy(xpath = "//*[text()='Accounts']")
	WebElement menu_Accounts;

	@FindBy(xpath = ".//ul[@class='slds-button-group slds-m-left--xx-small oneActionsRibbon forceActionsContainer']//li/a/div[text()='New']")
	WebElement newAccount;

	@FindBy(xpath = ".//button[text()='Continue']")
	WebElement continueButton;


	@FindBy(xpath = ".//*[@id='showHideButton']")
	WebElement viewAllFieldsButton;	

	@FindBy(xpath = "//*[text()='Related']")
	WebElement related_Accounts;

	@FindBy(xpath = ".//article[14]//a/div[@title ='New']")
	WebElement new_PrivateNotes;

	@FindBy(xpath = ".//article[7]/div[1]/div/div/ul/li/a/div[@title ='New']")
	WebElement new_cm_PrivateNotes;

	@FindBy(xpath = ".//div[@class='forceChangeRecordTypeFooter']//span[text()='Next']")
	WebElement next_PrivateNotes;

	@FindBy(xpath = ".//label[@class='label inputLabel uiLabel-left form-element__label uiLabel']/span[contains(text(), 'Title')]/parent::label/parent::div/input")
	WebElement title_PrivateNotes;

	@FindBy(xpath = ".//div[@class='autocompleteWrapper']/input[@placeholder='Search Leads']")
	WebElement searchLeads_PrivateNotes;

	@FindBy(xpath = ".//div[@class='contentWrapper slds-box--border']//ul[@class='orderedList']//span[@class='pillText']")
	WebElement account_PrivateNotes;

	@FindBy(xpath = ".//div[@class='autocompleteWrapper']/input[@placeholder='Search Contacts']")
	WebElement searchContacts_PrivateNotes;

	@FindBy(xpath = ".//label[@class='label inputLabel uiLabel-left form-element__label uiLabel']/span[contains(text(), 'Title')]")
	WebElement title;

	@FindBy(xpath = ".//div[@class='autocompleteWrapper']/input[@placeholder='Search Leads']")
	WebElement searchLeads;

	@FindBy(xpath = ".//div[@class='autocompleteWrapper']/input[@placeholder='Search Contacts']")
	WebElement searchContacts;

	@FindBy(xpath = ".//label[@class='label inputLabel uiLabel-left form-element__label uiLabel']/span[contains(text(), 'Body')]/parent::label/parent::div/textarea")
	WebElement body;

	@FindBy(xpath = ".//button[@class='slds-button slds-button--neutral uiButton--default uiButton--brand uiButton forceActionButton']/span[contains(text(), 'Save')]")
	WebElement saveButton;

	@FindBy(xpath = ".//span[@class='toastMessage slds-text-heading--small forceActionsText'][contains(text(), 'was created.')]")
	WebElement wasCreated;

	homePage hp = new homePage(scriptHelper);
	static ArrayList<String> accountsPageDetailsList = new ArrayList<String>();

	public void accountDetailsPage() {
		accountsPageDetailsList.add("Tagging");
		accountsPageDetailsList.add("Account Information");
		accountsPageDetailsList.add("Account Segmentation");
		accountsPageDetailsList.add("Account Hierarchy");
		accountsPageDetailsList.add("Address Information");
		accountsPageDetailsList.add("Local Address Information");
		accountsPageDetailsList.add("Additional Information");
		accountsPageDetailsList.add("SIC/NAICS Codes");
		accountsPageDetailsList.add("Description Information");
		accountsPageDetailsList.add("APAC Fields");
		accountsPageDetailsList.add("EMEA Fields");
		accountsPageDetailsList.add("Rollup Summary Fields");
		accountsPageDetailsList.add("System Information");
		accountsPageDetailsList.add("Custom Links");
		System.out.println("Account Details Page information are:: " + accountsPageDetailsList);
	}

	public void accountDetailsPagebyDefault() {
		accountDetailsPage();
		hp.validate_Menu_Accounts();
		Utility_Functions.timeWait(3);
		List<WebElement> accountList = driver.findElements(
				By.xpath(".//a[@class='slds-truncate outputLookupLink slds-truncate forceOutputLookup']"));
		Utility_Functions.xclickgetTextofFirstElementfromList(accountList);
		Utility_Functions.timeWait(3);
		List<WebElement> accountsPageInfoList = driver.findElements(
				By.xpath(".//button[@class='slds-button slds-button--neutral sectionHeaderButton uiButton']"));
		Utility_Functions.xScrollWindow(driver);
		Utility_Functions.timeWait(1);
		String[] linkTexts = new String[accountsPageInfoList.size()];
		int i = 0, count = 0;
		try {
			for (WebElement element : accountsPageInfoList) {
				linkTexts[i] = element.getText();
				if (linkTexts[i].equals(accountsPageDetailsList.get(i))) {
					count++;
					System.out.println("Account Page Details is having all the fields::: " + linkTexts[i] + ":::"
							+ accountsPageDetailsList.get(i));
					report.updateTestLog("Verify Account Landing Page Information",
							"Landing page of Account Details is having all the fields:::" + linkTexts[i] + ":::",
							Status.PASS);
				}
				i++;
			}
			if (dataTable.getData("General_Data", "Username").contains("cmbroker")) {
				if (count == 9) {
					System.out.println("All the links are present in Home Page:::");
					report.updateTestLog("Verify Account Landing Page Information",
							"Account Details Page is having all the details in account landing page:::", Status.PASS);
				}
			} else if (!dataTable.getData("General_Data", "Username").contains("cmbroker")) {
				if (count == 14) {
					System.out.println("All the links are present in Home Page:::");
					report.updateTestLog("Verify Account Landing Page Information",
							"Account Details Page is having all the details in account landing page:::", Status.PASS);
				}
			} else {
				report.updateTestLog("Verify Account Landing Page Information",
						"Account Details Page is not having all the details in account landing page:::", Status.FAIL);
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
		}

	}

	public void addPrivateNote() {
		hp.validate_Menu_Accounts();
		Utility_Functions.timeWait(4);
		List<WebElement> accountList = driver.findElements(
				By.xpath(".//a[@class='slds-truncate outputLookupLink slds-truncate forceOutputLookup']"));
		String accountSelected = Utility_Functions.xclickgetTextofFirstElementfromList(accountList);
		Utility_Functions.timeWait(3);
		Utility_Functions.xClick(driver, related_Accounts, true);
		Utility_Functions.timeWait(2);
		try {
			if (dataTable.getData("General_Data", "Username").contains("cmbroker")) {
				Utility_Functions.xScrollWindow(driver);
				//Utility_Functions.xScrollWindowToElement(driver, new_cm_PrivateNotes);
				Utility_Functions.timeWait(3);
				Utility_Functions.xClick(driver, new_cm_PrivateNotes, true);
			} else {
				Utility_Functions.xScrollWindow(driver);
				//Utility_Functions.xScrollWindowToElement(driver, new_PrivateNotes);
				Utility_Functions.timeWait(3);
				Utility_Functions.xClick(driver, new_PrivateNotes, true);
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
		}
		Utility_Functions.timeWait(1);
		Utility_Functions.xClick(driver, next_PrivateNotes, true);
		Utility_Functions.timeWait(2);
		String accountPopulated = account_PrivateNotes.getText();
		Utility_Functions.xSendKeys(driver, title_PrivateNotes, dataTable.getData("General_Data", "Title"));
		Utility_Functions.timeWait(1);
		if (accountSelected.equals(accountPopulated)) {
			report.updateTestLog("Verify Private Note", "Account populated on Private Note is same as the one "
					+ "selected while creating the Private Note", Status.PASS);
		} else {
			report.updateTestLog("Verify Private Note", "Account populated on Private Note is not the one "
					+ "selected while creating the Private Note", Status.FAIL);
		}
		Utility_Functions.timeWait(1);
		Utility_Functions.xClick(driver, searchContacts, true);
		List<WebElement> contactsList = driver.findElements(By.xpath(
				".//div[@class='lookup__menu uiAbstractList uiAutocompleteList uiInput uiAutocomplete uiInput--default uiInput--lookup']//div[@class='listContent']/ul/li"));
		Utility_Functions.timeWait(2);
		Utility_Functions.xclickOnFirstElementfromList(contactsList);
		Utility_Functions.timeWait(2);
		Utility_Functions.xSendKeys(driver, body, dataTable.getData("General_Data", "Body"));
		Utility_Functions.timeWait(2);
		Utility_Functions.xClick(driver, saveButton, true);
		Utility_Functions.timeWait(4);
		if (wasCreated.isDisplayed()) {
			report.updateTestLog("Verify Private Note", "Private Note is created successfully", Status.PASS);
		} else {
			report.updateTestLog("Verify Private Note", "Private Note is created successfully", Status.FAIL);
		}

	}


	static ArrayList<String> labelList = new ArrayList<String>();
	public void labelsAccountPage() {
		labelList.add("Account Name");
		labelList.add("Billing Street");
		labelList.add("Billing City");
		labelList.add("Billing Country");
		labelList.add("Billing State/Province");
		labelList.add("Billing Zip/Postal Code");
		labelList.add("Website");
		labelList.add("Phone");
		labelList.add("Industry");

		labelList.add("Account Site");
		labelList.add("Tradestyle Name");
		labelList.add("Legal Status");
		labelList.add("Account Opportunity History");
		labelList.add("Tax Label 1");
		labelList.add("Tax Label2");
		labelList.add("Tax Code 1");
		labelList.add("Tax Code 2");
		labelList.add("Staging Record Id");
		labelList.add("Created By Country");
		labelList.add("Last updated by Country");
		labelList.add("Original Account Name");
		labelList.add("Local Account Name");
		labelList.add("Account Fax");
		labelList.add("Immediate Parent Account");
		labelList.add("Brand Parent");
		labelList.add("Global Brand");
		
		labelList.add("Client Type");
		labelList.add("Key Client Account for");
		labelList.add("Key Pursuit Account for");
		
		labelList.add("Shipping Street");
		labelList.add("Shipping City");
		labelList.add("Shipping Country]");
		labelList.add("Shipping State/Province");
		labelList.add("Shipping Zip/Postal Code");

		labelList.add("Local Billing Country");
		labelList.add("Local Billing Street");
		labelList.add("Local Billing City");
		labelList.add("Local Billing Zip/Postal Code");
		labelList.add("Local Shipping Zip/Postal Code");
		labelList.add("Local Shipping Country");
		labelList.add("Local Shipping Street");
		labelList.add("Local Shipping City");
		labelList.add("Local Billing State/Province");
		labelList.add("Local Shipping State/Province");
	
		labelList.add("Number of Family Members");
		labelList.add("Investor Profile");
		labelList.add("Lender Type");
		labelList.add("D-U-N-S #");
		labelList.add("Previous D-U-N-S #");
		labelList.add("Integration Id");
		labelList.add("Tax Code Label Type");
		labelList.add("Status");
		labelList.add("Reason for Inactivating");
		labelList.add("Inactivation Date");
		labelList.add("Marketability");
		labelList.add("Account Source");
		labelList.add("Ticker Symbol");
		labelList.add("Annual Revenue");
		labelList.add("Australian Business Number(ABN)");
		labelList.add("Teikoku Databank Code (TBD)");
		labelList.add("Verified System Id");
		labelList.add("Verified Date");
		labelList.add("Source Created Date Time");
		labelList.add("Source Last Updated Date Time");
		
		labelList.add("NAICS Code");
		labelList.add("SIC Code 1");
		labelList.add("SIC Code 2");
		labelList.add("SIC Code 3");
		labelList.add("SIC Code 4");
		labelList.add("SIC Code 5");
		labelList.add("SIC Code 6");
		labelList.add("TBD Industry Code");
		labelList.add("NAICS Code Description");
		labelList.add("SIC Code 1 Description");
		labelList.add("SIC Code 2 Description");
		labelList.add("SIC Code 3 Description");
		labelList.add("SIC Code 4 Description");
		labelList.add("SIC Code 5 Description");
		labelList.add("SIC Code 6 Description");
		labelList.add("TBD Industry Code Description");
		
		labelList.add("Account Description");
		
		labelList.add("Created By");
		labelList.add("Record Type");
		labelList.add("Translation Status");
		labelList.add("Account Creator Country");
		labelList.add("DIG Review Comments");
		labelList.add("Hiearchy Code");
		labelList.add("Account Owner");
		labelList.add("Unique Account ID");
		labelList.add("Family Id Formula");
		labelList.add("Source System");
		System.out.println("Labels present in the new account page are:: " + labelList);

	}

	static ArrayList<String> headerSectionList = new ArrayList<String>();
	public void headerSectionAccountPage() {
		//headerSectionList.add("Quick Create");
		headerSectionList.add("Account Information");
		headerSectionList.add("Account Segmentation");
		headerSectionList.add("Address Information");
		headerSectionList.add("Local Address Information");
		headerSectionList.add("Additional Information");
		headerSectionList.add("SIC/NAICS Codes");
		headerSectionList.add("Description Information");
		headerSectionList.add("System Information");
		System.out.println("Header Section Details present in the new account page are:: " + headerSectionList);
	}

	public void newAccountPageLayout() {	
		headerSectionAccountPage();
		labelsAccountPage();
		Utility_Functions.timeWait(1);
		Utility_Functions.xClick(driver, menu_Accounts, true);
		Utility_Functions.timeWait(1);
		Utility_Functions.xClick(driver, newAccount, true);
		Utility_Functions.timeWait(2);
		driver.switchTo().frame(driver.findElement(By.xpath(".//iframe[contains(@src,'AccountRedirectPage')]")));
		Utility_Functions.timeWait(1);
		Utility_Functions.xScrollWindow(driver);
		Utility_Functions.timeWait(1);
		Utility_Functions.xClick(driver, viewAllFieldsButton, true);
		Utility_Functions.timeWait(1);		
		Utility_Functions.xScrollWindowTop(driver);
		List<WebElement> headerList = driver.findElements(By.xpath(".//h2[@class='slds-text-heading--medium slds-m-top--x-large slds-m-bottom--large']"));
		try {
			int i2 =0, count =0;
			String[] headerTexts = new String[headerList.size()];
			for(WebElement element: headerList) {
				headerTexts[i2] = element.getText();
				if(headerTexts[i2].contains(headerSectionList.get(i2))) {
					count++;
					System.out.println("Verify Add Account Header List" + element.getText());
					report.updateTestLog("Verify Add Account Header List", element.getText() + " header is present in Add Account Page", Status.PASS);
				}
				i2++;
			} 
			System.out.println(count);
			if(count==8) {
				report.updateTestLog("Verify Add Account Header List", "header is present in Add Account Page", Status.PASS);
			} else {
				report.updateTestLog("Verify Add Account Header List", "header is not present in Add Account Page", Status.FAIL);
			}
		} catch(Exception e) {
			System.out.println(e.getMessage());
		}	

		try {
			List<WebElement> labelListAccountPage = driver.findElements(By.xpath(".//label[@class='slds-form-element__label']"));
			int i1 =0, countLabelList = 0;
			String[] labelTexts = new String[labelListAccountPage.size()];
			for(WebElement element: labelListAccountPage) {
				labelTexts[i1] = element.getText();
				if(labelTexts[i1].contains(labelList.get(i1))) {
					System.out.println("Verify Add Account Page Label List" + element.getText());
					report.updateTestLog("Verify Add Account Page Label List", element.getText() + " label list is present in Add Account Page", Status.PASS);
					countLabelList++;
				} 
				i1++;
			} 

			System.out.println(countLabelList);		
			if(countLabelList==79) {
				report.updateTestLog("Verify Add Account Page Label List", "labels are present in Add Account Page", Status.PASS);
			} else {
				report.updateTestLog("Verify Add Account Page Label List", "labels are not present in Add Account Page", Status.FAIL);
			}

		} catch(Exception e) {
			System.out.println(e.getMessage());
		}		
	}	

}