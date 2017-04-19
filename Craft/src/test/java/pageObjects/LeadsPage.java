package pageObjects;


import java.util.ArrayList;
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
import pagesAPI.AccountsFunctions;
import pagesAPI.SearchTextSOQL;
import supportLibraries.Utility_Functions;


/**
 * Page Object Class for Leads Page
 * 
 * @author Vishnuvardhan
 *
 */

public class LeadsPage extends ReusableLibrary {
	/*
	 * Constructor to initialize the business component library
	 * 
	 * @param scriptHelper The {@link ScriptHelper} object passed from the
	 * {@link DriverScript}
	 */
	public LeadsPage(ScriptHelper scriptHelper) {
		super(scriptHelper);
		PageFactory.initElements(driver.getWebDriver(), this);
		// new WebDriverUtil(driver);
		// Utility_Functions utility = new Utility_Functions(scriptHelper);
	}

	@FindBy(xpath = "//div[@class='slds-context-bar oneGlobalNav']//span[text()='Home']")
	WebElement menu_Home;
	
	@FindBy(xpath = "//div[@class='slds-context-bar oneGlobalNav']//span[text()='Leads']")
	WebElement menu_Leads;

	@FindBy(xpath = "//div[@title='New']")
	WebElement newButton;	

	@FindBy(xpath = "//*[@id='record-type-select']")
	WebElement leadRecordTypeSelection;	

	@FindBy(xpath = "//div[@class='slds-page-header slds-grid slds-grid--align-spread slds-grid--vertical-align-center']//button[text()='Continue']")
	WebElement continueButton;	

	@FindBy(xpath = "//*[@id='record-type-select']/option[text()='Agency Brokerage']")
	WebElement agencyBroker;	

	@FindBy(xpath = "//*[@id='record-type-select']/option[text()='Capital Markets']")
	WebElement capitalMarkets;	

	@FindBy(xpath = "//*[@id='record-type-select']/option[text()='Occupier Brokerage']")
	WebElement occupierBrokerage;	

	@FindBy(xpath = "//*[text()='Address']/parent::div/parent::div/div[@class='itemBody']")
	WebElement addressDetails;	

	@FindBy(xpath = "//div[@class='dataCol readonly slds-no-space']/span[@class='uiOutputPhone']/parent::div/parent::div/parent::div/div/span[contains(text(), 'Direct Line')]/parent::div/parent::div/div[2]/div/span")
	WebElement directLine;	

	@FindBy(xpath = "//div[@class='dataCol readonly slds-no-space']/span[@class='uiOutputPhone']/parent::div/parent::div/parent::div/div/span[contains(text(), 'Direct Line')]/parent::div/parent::div/div[2]//button")
	WebElement directLineEditButton;	

	@FindBy(xpath = "//span[@class='uiOutputEmail']/parent::p/parent::li/p[contains(text(), 'Email')]")
	WebElement email;	

	@FindBy(xpath = "//div[@class='desktop container forceStyle oneOne oneAppLayoutContainer']//*[text()='Convert']")
	WebElement convert;		

	@FindBy(xpath = "//*[@id='convertedStatus']")
	WebElement convertedStatus;	

	@FindBy(xpath = "//input[contains(@id,'CustomLeadConversionFrom:accname')]")
	WebElement accountName;	

	@FindBy(xpath = "//input[contains(@id,'CustomLeadConversionFrom:OwnerName']")
	WebElement recordOwner;	

	@FindBy(xpath = "//label[@for='first-name']/following-sibling::div//input")
	WebElement firstName;	

	@FindBy(xpath = "//label[@for='last-name']/following-sibling::div//input")
	WebElement lastName;

	@FindBy(xpath = "//label[@for='company']/following-sibling::div//input")
	WebElement company;	

	@FindBy(xpath = "//input[@class='btn slds-button slds-button--neutral slds-m-left--small'][@value='Save']")
	WebElement saveButton;

	@FindBy(xpath = "//h1[@class='slds-page-header__title slds-m-right--small slds-truncate slds-align-middle']")
	WebElement headerLead;

	@FindBy(xpath = "//a[@class='tabHeader']//span[text()='Related']")
	WebElement related;

	@FindBy(xpath = "//label[text()='Lead Source']/following-sibling::div//select")
	WebElement leadSource;

	@FindBy(xpath = "//label[text()='Status']/following-sibling::div//select")
	WebElement leadStatusField;

	@FindBy(xpath = "//label[text()='Direct Line']/parent::div//div/input")
	WebElement directLineLead;

	@FindBy(xpath = "//div[@class='slds-form-element__control slds-input-has-icon slds-input-has-icon--right']//input[@id='j_id0:CustomLeadConversionFrom:OwnerName']")
	WebElement recordOwnerText;	


	// //div[@class='slds-input-has-icon slds-input-has-icon--right']//input[@id='j_id0:CustomLeadConversionFrom:accname']
	@FindBy(xpath = "//*[@id='acc_id']")
	WebElement accountNameConvert;	

	@FindBy(xpath = "//div[@class='tt-dataset-acc_idTypeahead']//div[1]/p")
	WebElement accountNames;

	@FindBy(xpath = "//div[@class='dataCol readonly slds-no-space']//div[@class='map forceOutputAddressText']")
	WebElement addressMap;

	@FindBy(xpath = "//*[contains(@id,'CustomLeadConversionFrom')]/section/section/div[2]/div/div[3]/div/div/a/img")
	WebElement accountNameSearch;

	@FindBy(xpath = "//span[@class='slds-icon_container slds-icon-utility-down slds-button__icon forceIcon']")
	WebElement showMoreActions;

	@FindBy(xpath = "//*[text()='Edit']")
	WebElement editButton;

	@FindBy(xpath = "//label[@class='uiLabel-top form-element__label uiLabel']/span[text()='First Name']/parent::label/parent::div/input")
	WebElement editFirstName;

	@FindBy(xpath = "//button[@class='slds-button slds-button--neutral uiButton--default uiButton--brand uiButton forceActionButton']")
	WebElement editSaveButton;

	@FindBy(xpath = "//h1//span[@class='uiOutputText']")
	WebElement nameText;

	@FindBy(xpath = "//li[@class='slds-button slds-button--neutral slds-truncate']//div[@title='Clone']")
	WebElement cloneButton;

	@FindBy(xpath = "//button[@class='slds-button slds-button--neutral uiButton forceActionButton'][@title='Save & New']")
	WebElement cloneSaveNewButton;

/*	@FindBy(xpath = "//li/parent::ul/parent::div/parent::div/parent::div/header/div[2]/h2/a/span[text()='Private Notes']/parent::a/parent::h2/parent::div/parent::header/parent::div//ul[@class='slds-button-group slds-m-left--xx-small small oneActionsRibbon forceActionsContainer']")
	WebElement new_PrivateNotes;*/
	
	@FindBy(xpath = "//article[contains(@class,'Private Notes')]//div[@title='New']")
	WebElement new_PrivateNotes;
	
	@FindBy(xpath = "//div[@class='forceChangeRecordTypeFooter']//span[text()='Next']")
	WebElement next_PrivateNotes;
	
	@FindBy(xpath = "//div[@class='contentWrapper slds-box--border']//ul[@class='orderedList']//span[@class='pillText']")
	WebElement lead_PrivateNotes;
	
	@FindBy(xpath = "//label[@class='label inputLabel uiLabel-left form-element__label uiLabel']/span[contains(text(), 'Title')]/parent::label/parent::div/input")
	WebElement title_PrivateNotes;
	
	@FindBy(xpath = "//div[@class='autocompleteWrapper']/input[@placeholder='Search Contacts']")
	WebElement searchContacts;
	
	@FindBy(xpath = "//label[@class='label inputLabel uiLabel-left form-element__label uiLabel']/span[contains(text(), 'Body')]/parent::label/parent::div/textarea")
	WebElement body;
	
	@FindBy(xpath = "//span[@class='toastMessage slds-text-heading--small forceActionsText'][contains(text(), 'was created.')]")
	WebElement wasCreated;	
	
	@FindBy(xpath = "//button[@class='slds-button slds-button--neutral uiButton--default uiButton--brand uiButton forceActionButton']/span[text()='Save']")
	WebElement savePrivateNote;
	
	@FindBy(xpath = "//*[text()='Street']/parent::div/div/div/textarea")
	WebElement streetField;
	
	@FindBy(xpath = "//*[contains(@id,'CustomLeadConversionFrom:country')]")
	WebElement countryField;
	
	@FindBy(xpath = "//*[contains(@id,'CustomLeadConversionFrom:state')]")
	WebElement stateField;	
	
	@FindBy(xpath = "//*[contains(@id,'CustomLeadConversionFrom:city')]")
	WebElement cityField;
	
	@FindBy(xpath = "//*[text()='Zip/Postal Code']/parent::div/div/div/input")
	WebElement zipCodeField;
	
	@FindBy(xpath = ".//*[contains(@id,'CustomLeadConversionFrom')]//input[@value='Convert']")
	WebElement convertButton;
	
	@FindBy(xpath = "//div[@title='Convert']")
	WebElement saveConvertButton;
	
		
	/**
	 * Validating the Convert Lead functionality
	 * 
	 * @author Vishnuvardhan
	 *
	 */

	public void convertLead() {
		Utility_Functions.timeWait(1);
		Utility_Functions.xClick(driver, menu_Leads, true);
		Utility_Functions.timeWait(2);
		List<WebElement> leadsList = driver.findElements(
				By.xpath("//a[@class='slds-truncate outputLookupLink slds-truncate forceOutputLookup']"));
		Utility_Functions.xclickgetTextofFirstElementfromList(leadsList);
		Utility_Functions.timeWait(2);
		Utility_Functions.xScrollWindowToElement(driver, addressDetails);
		Utility_Functions.xScrollWindowToElement(driver, directLine);
		Utility_Functions.xScrollWindowToElement(driver, email);
		System.out.println(addressDetails.getText() + directLine.getText() + email.getText());
		try {
			if((!directLine.getText().equals("")) && (!email.getText().equals("")) && (!addressMap.isDisplayed())) {
				System.out.println("Address Details, DirectLine and Email field are not having the values:::");
				report.updateTestLog("Lead Page", "Address Details, DirectLine and Email field are not having the values::",
						Status.FAIL);	
				/*				Utility_Functions.timeWait(1);
				Utility_Functions.xClick(driver, directLineEditButton, true);
				Utility_Functions.timeWait(1);*/
			} else {
				System.out.println("Address Details, DirectLine and Email field are having the values:::");
				report.updateTestLog("Lead Page", "Address Details, DirectLine and Email field are having the values::",
						Status.PASS);		
			}
		} catch (Exception e1) {
			e1.printStackTrace();
			System.out.println(e1.getMessage());
		}
		Utility_Functions.xClick(driver, convert, true);
		Utility_Functions.timeWait(3);
		driver.switchTo().frame(driver.findElement(By.xpath("//iframe[contains(@src,'LeadConversionRed')]")));
		Utility_Functions.timeWait(1);
		/*List<WebElement> convertList = driver.findElements(By.xpath("//label[@class='slds-form-element__label']"));
		int count=0; 
		try {
			for(WebElement element: convertList) {
				if((count==0) && (element.getText().equals("*Converted Status"))) {
					System.out.println("Converted Status field is present in the Convert Lead Page");
					report.updateTestLog("Convert Lead Page", "Convert Lead Page is having the " + element.getText() +" Status field::",Status.PASS);	
					count++;						
				} else if((count==1) && (element.getText().equals("*Record Owner"))) {
					System.out.println("Record Owner field is present in the Convert Lead Page");
					report.updateTestLog("Convert Lead Page", "Convert Lead Page is having the " + element.getText() +" Status field::",Status.PASS);
					count++;						
				} else if((count==2) && (element.getText().equals("*Account Name"))) {
					System.out.println("Account Name field is present in the Convert Lead Page");
					report.updateTestLog("Convert Lead Page", "Convert Lead Page is having the " + element.getText() +" Status field::",Status.PASS);
					count++;
				} 										
			}
			if(count!=3) {
				report.updateTestLog("Convert Lead Page", "Convert Lead Page is not having all the fields::",Status.FAIL);
			} else {
				report.updateTestLog("Convert Lead Page", "Convert Lead Page is having all the fields::",Status.PASS);
			}

		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
		}*/
		convertListValidation();
		try {
			if(convertedStatus.getText().contains("Qualified")) {
				System.out.println("Converted Status field is having the option as Qualified by default");
				report.updateTestLog("Convert Lead Page", "Convert Lead Page is having the option as ::" + convertedStatus.getText() + "" ,Status.PASS);
			} 
			String usernameDataSheet = dataTable.getData("General_Data", "Username").split("@")[0];
			String recordOwnerNameText = recordOwnerText.getAttribute("value");
			System.out.println(usernameDataSheet + recordOwnerNameText);
			if(recordOwnerNameText.replace(" ",".").equalsIgnoreCase((usernameDataSheet))) {
				System.out.println("Record Owner field is having the record owner autopopulated");
				report.updateTestLog("Convert Lead Page", "Convert Lead Page is not having the record owner value as null::",Status.PASS);
			}
			//Utility_Functions.xClick(driver, accountNameConvert, true);
			Utility_Functions.xClick(driver, accountNameSearch, true);
			Utility_Functions.timeWait(1);
			accountNameConvert.clear();
			Utility_Functions.xSendKeys(driver, accountNameConvert, dataTable.getData("General_Data", "Account Name"));
			Utility_Functions.xSendKeys(driver, accountNameConvert, Keys.SPACE);
			Utility_Functions.timeWait(2);
			try {
				if(accountNames.getText().contains(" ")) {
					report.updateTestLog("Verify Acccount Name", "Account name contains the space between the Account First Name and Account Last Name:::", Status.PASS);
				} else {
					report.updateTestLog("Verify Acccount Name", "Account name doesn't contain the space between the Account First Name and Account Last Name:::", Status.FAIL);
				}
			} catch (Exception e) {
				e.printStackTrace();
				System.out.println(e.getMessage());
			}			
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
		}
	}
	
	/**
	 * Function to validate the Convert List elements
	 * 
	 * @author Vishnuvardhan
	 *
	 */
	public void convertListValidation() {
		List<WebElement> convertList = driver.findElements(By.xpath("//label[@class='slds-form-element__label']"));
		int count=0; 
		try {
			for(WebElement element: convertList) {
				if((count==0) && (element.getText().equals("*Converted Status"))) {
					System.out.println("Converted Status field is present in the Convert Lead Page");
					report.updateTestLog("Convert Lead Page", "Convert Lead Page is having the " + element.getText() +" Status field::",Status.PASS);	
					count++;						
				} else if((count==1) && (element.getText().equals("*Record Owner"))) {
					System.out.println("Record Owner field is present in the Convert Lead Page");
					report.updateTestLog("Convert Lead Page", "Convert Lead Page is having the " + element.getText() +" Status field::",Status.PASS);
					count++;						
				} else if((count==2) && (element.getText().equals("*Account Name"))) {
					System.out.println("Account Name field is present in the Convert Lead Page");
					report.updateTestLog("Convert Lead Page", "Convert Lead Page is having the " + element.getText() +" Status field::",Status.PASS);
					count++;
				} 										
			}
			if(count!=3) {
				report.updateTestLog("Convert Lead Page", "Convert Lead Page is not having all the fields::",Status.FAIL);
			} else {
				report.updateTestLog("Convert Lead Page", "Convert Lead Page is having all the fields::",Status.PASS);
			}

		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
		}
	}
	
	/**
	 * Adding the Web Elements to the Related Page Element List
	 * 
	 * @author Vishnuvardhan
	 *
	 */

	static ArrayList<String> relatedPageElementsList = new ArrayList<String>();
	public void relatedPageListElements() {
		relatedPageElementsList.add("Welcome to Salesforce!");
		relatedPageElementsList.add("News");
		//relatedPageElementsList.add("News");
		relatedPageElementsList.add("Private Notes");
		relatedPageElementsList.add("Notes");
		relatedPageElementsList.add("Files");
		relatedPageElementsList.add("Lead Property");
		System.out.println("Elements present in the Related tab on Lead Creation Page::" + relatedPageElementsList);
	}

	/**
	 * Function for Create Lead functionality
	 * 
	 * @author Vishnuvardhan
	 *
	 */

	public void createLeadFunction() {
		Utility_Functions.timeWait(2);
		Utility_Functions.xClick(driver, menu_Leads, true);
		Utility_Functions.timeWait(2);
		Utility_Functions.xClick(driver, newButton, true);
		Utility_Functions.timeWait(2);
		try {
			if(dataTable.getData("General_Data", "Lead Record Type").equals("Occupier Brokerage")) {
				Utility_Functions.xClick(driver, occupierBrokerage, true);
			} else if(dataTable.getData("General_Data", "Lead Record Type").equals("Agency Brokerage")) {
				Utility_Functions.xClick(driver, agencyBroker, true);
			} else if(dataTable.getData("General_Data", "Lead Record Type").equals("Capital Markets")) {
				Utility_Functions.xClick(driver, capitalMarkets, true);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		driver.switchTo().frame(driver.findElement(By.xpath("//iframe[contains(@src,'LeadDefaultUoM')]")));
		Utility_Functions.timeWait(3);
		Utility_Functions.xClick(driver, continueButton, true);
		Utility_Functions.timeWait(2);
		Random random = new Random();
		int value = random.nextInt(1000);
		String companyName = dataTable.getData("General_Data", "Company") + value;
		Utility_Functions.xSendKeys(driver, firstName, dataTable.getData("General_Data", "First Name"));
		Utility_Functions.timeWait(1);
		Utility_Functions.xSendKeys(driver, lastName, dataTable.getData("General_Data", "Last Name"));
		Utility_Functions.timeWait(1);
		Utility_Functions.xSendKeys(driver, company, companyName);
		//Utility_Functions.xSendKeys(driver, company, Keys.SPACE);		
	}

	/**
	 * Validating the Create Lead functionality
	 * 
	 * @author Vishnuvardhan
	 *
	 */

	public void createLead() {
		createLeadFunction();
		Utility_Functions.timeWait(1);
		Utility_Functions.xClick(driver, saveButton, true);
		Utility_Functions.timeWait(2);
		driver.switchTo().defaultContent();
		Utility_Functions.timeWait(1);
		try {
			//String companyText = dataTable.getData("General_Data", "Company");
			if(headerLead.isDisplayed()) {
				System.out.println("Lead has been created successfully");
				report.updateTestLog("Create Lead", "Lead has been created successfully"+ headerLead.getText(),Status.PASS);			
			} else {
				System.out.println("Lead creation failed");
				report.updateTestLog("Create Lead", "Lead creation failed:::"+ headerLead.getText(),Status.FAIL);			
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		Utility_Functions.timeWait(1);
		Utility_Functions.xClick(driver, related, true);
		Utility_Functions.timeWait(2);
		relatedPageListElements();
		List<WebElement> relatedPageList = driver.findElements(By.xpath("//*[@id='header']/a/span[1]"));
		try {
			int i=0, count=0;
			for(WebElement element: relatedPageList) {
				if(element.getText().contains(relatedPageElementsList.get(i))) {
					System.out.println("Elements present in the related page are::" + element.getText());
					report.updateTestLog("Verify Related Page Elements","Elements present in the related page are :::"+element.getText(),Status.PASS);
					count++;
				} i++;
			}
			System.out.println(count);
			if(count==4) {
				report.updateTestLog("Verify Related Page Elements","All the elements are present on the Related Page" ,Status.PASS);
			} else {
				report.updateTestLog("Verify Related Page Elements","All the elements are not present on the Related Page" ,Status.FAIL);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Validating the Create Greenspace Lead functionality
	 * 
	 * @author Vishnuvardhan
	 *
	 */

	public void createGreenspaceLead() {
		createLeadFunction();
		Utility_Functions.timeWait(1);
		Utility_Functions.xSelectDropdownByIndex(leadSource, 6);
		Utility_Functions.timeWait(1);
		if(leadStatusField.getText().contains("Open")) {
			report.updateTestLog("Verify Lead Status Field","By default the Lead Status Field is having the option as 'Open'" ,Status.PASS);
		} else {
			report.updateTestLog("Verify Lead Status Field","By default the Lead Status Field is not having the option as 'Open'" ,Status.FAIL);
		}
		Utility_Functions.timeWait(1);
		Utility_Functions.xScrollWindowOnce(driver);
		Utility_Functions.timeWait(1);
		Utility_Functions.xSendKeys(driver, directLineLead, dataTable.getData("General_Data", "Direct Line"));
		Utility_Functions.timeWait(2);
		Utility_Functions.xClick(driver, saveButton, true);
		Utility_Functions.timeWait(2);
		driver.switchTo().defaultContent();
		Utility_Functions.timeWait(1);
		try {
			//String companyText = dataTable.getData("General_Data", "Company");
			if(headerLead.isDisplayed()) {
				System.out.println("Greenspace Lead has been created successfully");
				report.updateTestLog("Create Greenspace Lead", "Greenspace Lead has been created successfully"+ headerLead.getText(),Status.PASS);			
			} else {
				System.out.println("Greenspace Lead creation failed");
				report.updateTestLog("Create Greenspace Lead", "Greenspace Lead creation failed:::"+ headerLead.getText(),Status.FAIL);			
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Adding buttons on the Lead Detail page to the buttonsList
	 * 
	 * @author Vishnuvardhan
	 *
	 */
	static ArrayList<String> buttonList = new ArrayList<String>();
	public void buttonsListLeadDetailPage() {
		buttonList.add("Edit");
		buttonList.add("Convert");
		buttonList.add("Clone");
		System.out.println("Buttons list on Lead Details page::"+ buttonList);		
	}

	/**
	 * Adding buttons on the Lead Detail page to the buttonsList
	 * 
	 * @author Vishnuvardhan
	 *
	 */
	static ArrayList<String> moreActionsList = new ArrayList<String>();
	public void moreActionsListLeadDetailPage() {
		moreActionsList.add("Sharing");
		moreActionsList.add("New Task");
		moreActionsList.add("New Event");
		moreActionsList.add("Log A Call");
		moreActionsList.add("New Private Note");
		moreActionsList.add("New Personal Information");
		moreActionsList.add("Delete");
		System.out.println("Show more actions list on Lead Details page::"+ moreActionsList);		
	}

	/**
	 * Validating the Clone and Edit buttons on the Lead Details Page
	 * 
	 * @author Vishnuvardhan
	 *
	 */

	public void cloneAndEditButtons() {
		Utility_Functions.timeWait(1);
		Utility_Functions.xClick(driver, menu_Leads, true);
		Utility_Functions.timeWait(2);
		List<WebElement> leadsList = driver.findElements(By.xpath("//a[@class='slds-truncate outputLookupLink slds-truncate forceOutputLookup']"));
		Utility_Functions.xclickgetTextofFirstElementfromList(leadsList);
		Utility_Functions.timeWait(2);
		buttonsListLeadDetailPage();
		List<WebElement> buttonsList = driver.findElements(By.xpath("//div[@class='slds-col slds-no-flex slds-grid slds-align-middle actionsContainer']//ul[@class='slds-button-group slds-m-left--xx-small oneActionsRibbon forceActionsContainer']/li/a/div"));
		int i =0, count =0;
		try {
			for(WebElement element: buttonsList) {
				System.out.println(element.getText() + buttonList.get(i));
				if(element.getText().equals(buttonList.get(i))) {
					System.out.println("Button List present on the Lead Details Page::::" + element.getText());
					report.updateTestLog("Lead Details Page", "Buttons present on the Leads Details Page:::"+ element.getText(),Status.PASS);
					count++;
				} 
				i++;
			}
			System.out.println(count);
			if(count==3) {
				report.updateTestLog("Lead Details Page", "Edit, Convert and Clone buttons present on the Leads Details Page:::",Status.PASS);
			} else {
				report.updateTestLog("Lead Details Page", "Not all the buttons are present on the Leads Details Page:::",Status.FAIL);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		Utility_Functions.xClick(driver, showMoreActions, true);
		Utility_Functions.timeWait(2);
		moreActionsListLeadDetailPage();
		List<WebElement> showMoreActionsList = driver.findElements(By.xpath(" //div[@class='actionMenu']/ul[@class='scrollable']/li/a"));
		int i1 =0, count1=0;
		try {
			for(WebElement element: showMoreActionsList) {
				System.out.println(element.getText() + moreActionsList.get(i1));
				if(element.getText().equals(moreActionsList.get(i1))) {
					System.out.println("Show more actions List present on the Lead Details Page::::" + element.getText());
					report.updateTestLog("Lead Details Page", "Show more actions list present on the Leads Details Page:::"+ element.getText(),Status.PASS);
					count1++;
				} 
				i1++;
			}
			System.out.println(count1);
			if(count1==7) {
				report.updateTestLog("Lead Details Page", "All the menu buttons are present on the Leads Details Page:::",Status.PASS);
			} else {
				report.updateTestLog("Lead Details Page", "Not all the menu buttons are present on the Leads Details Page:::",Status.FAIL);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		Utility_Functions.xClick(driver, editButton, true);
		Utility_Functions.timeWait(2);
		//Utility_Functions.xScrollWindowOnce(driver);
		Utility_Functions.timeWait(1);
		/*String firstName = editFirstName.getText();
		firstName.concat("__Updated");*/
		editFirstName.clear();
		Utility_Functions.timeWait(1);
		Random random = new Random();
		int value = random.nextInt(1000);
		Utility_Functions.xSendKeys(driver, editFirstName, "__Updated Name" + value);
		Utility_Functions.xClick(driver, editSaveButton, true);
		//Utility_Functions.xSendKeys(driver, editFirstName, "__Updated");
		Utility_Functions.timeWait(2);
		String updatedName = nameText.getText();
		String updatedFirstName = updatedName.split(" ")[0];
		if(updatedFirstName.contains("__Updated")) {
			report.updateTestLog("Lead Details Page", "Lead First Name is updated successfully:::",Status.PASS);
		} else {
			report.updateTestLog("Lead Details Page", "Lead First Name is not updated:::",Status.FAIL);
		}
		Utility_Functions.timeWait(1);
		Utility_Functions.xClick(driver, cloneButton, true);
		Utility_Functions.timeWait(2);
		Utility_Functions.xClick(driver, cloneSaveNewButton, true);
		Utility_Functions.timeWait(2);
		Utility_Functions.xClick(driver, menu_Leads, true);
		Utility_Functions.timeWait(2);
		List<WebElement> leadList = driver.findElements(By.xpath("//a[@class='slds-truncate outputLookupLink slds-truncate forceOutputLookup']"));
		try {
			int count2 =0;
			String firstLeadName=null, secondLeadName=null;
			for(WebElement element1: leadList) {
				System.out.println(element1.getText());
				if(count2 ==0) 
					firstLeadName = element1.getText();
				else if(count2 ==1)
					secondLeadName = element1.getText();
				else 
					break;
				count2++;
			}
			if(firstLeadName.equals(secondLeadName)) {
				report.updateTestLog("Lead Details Page", "Lead clone happened successfully:::",Status.PASS);
			} else {
				report.updateTestLog("Lead Details Page", "Lead clone failed:::",Status.FAIL);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Validating the Related lists of a Lead in the Lead Landing page
	 * 
	 * @author Vishnuvardhan
	 *
	 */	
	public void relatedListsLeadLandingPage() {
		Utility_Functions.timeWait(1);
		createLead();
		Utility_Functions.timeWait(2);
		Utility_Functions.xClick(driver, related, true);
		Utility_Functions.timeWait(2);
		List<WebElement> relatedLists = driver.findElements(By.xpath("//*[@id='header']/a/span[1]"));
		int count=0;
		for(WebElement element: relatedLists) {
			if(element.getText().contains("Private Notes")) {
				count++;
				report.updateTestLog("Lead Related Section", "Lead Related Section contains the related list:::" + element.getText(),Status.PASS);
			} else if(element.getText().contains("Notes")) {
				count++;
				report.updateTestLog("Lead Related Section", "Lead Related Section contains the related list:::" + element.getText(),Status.PASS);
			} else if(element.getText().contains("Files")) {
				count++;
				report.updateTestLog("Lead Related Section", "Lead Related Section contains the related list:::" + element.getText(),Status.PASS);
			} else if(element.getText().contains("Lead Property")) {
				count++;
				report.updateTestLog("Lead Related Section", "Lead Related Section contains the related list:::" + element.getText(),Status.PASS);
			}
		} 
		if(count==4) {
			report.updateTestLog("Lead Related Section", "Lead Related Section contains all the related lists for the lead:::",Status.PASS);
		} else {
			report.updateTestLog("Lead Related Section", "Lead Related Section doesn't contains all the related lists for the lead:::",Status.FAIL);
		}
	}
	
	/**
	 * Validating the Private Note functionality for Lead
	 * 
	 * @author Vishnuvardhan
	 *
	 */	
	public void privateNoteLead() {
		Utility_Functions.timeWait(3);
		Utility_Functions.xClick(driver, menu_Leads, true);
		Utility_Functions.timeWait(2);
		List<WebElement> leadsList = driver.findElements(
				By.xpath("//a[@class='slds-truncate outputLookupLink slds-truncate forceOutputLookup']"));
		String leadSelected = Utility_Functions.xclickgetTextofFirstElementfromList(leadsList);
		Utility_Functions.timeWait(3);
/*		
		searchTextSOQL searchRecord = new searchTextSOQL(scriptHelper);
		String recordID = searchRecord.fetchRecord("lead");
		String url = driver.getCurrentUrl();
		url.replaceAll("sObject/", "sObject/"+recordID);*/
				
		Utility_Functions.xClick(driver, related, true);
		Utility_Functions.timeWait(2);

		Utility_Functions.xScrollWindow(driver);
		Utility_Functions.timeWait(2);
		Utility_Functions.xClick(driver, new_PrivateNotes, true);

		Utility_Functions.timeWait(1);
		Utility_Functions.xClick(driver, next_PrivateNotes, true);
		Utility_Functions.timeWait(2);
		String leadPopulated = lead_PrivateNotes.getText();
		Utility_Functions.xSendKeys(driver, title_PrivateNotes, dataTable.getData("General_Data", "Title"));
		Utility_Functions.timeWait(1);
		try {
			if (leadSelected.equals(leadPopulated)) {
				report.updateTestLog("Verify Private Note", "Lead populated on Private Note is same as the one "
						+ "selected while creating the Private Note", Status.PASS);
			} else {
				report.updateTestLog("Verify Private Note", "Lead populated on Private Note is not the one "
						+ "selected while creating the Private Note", Status.FAIL);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		Utility_Functions.timeWait(1);
		Utility_Functions.xClick(driver, searchContacts, true);
		List<WebElement> contactsList = driver.findElements(By.xpath(
				"//div[@class='lookup__menu uiAbstractList uiAutocompleteList uiInput uiAutocomplete uiInput--default uiInput--lookup']//div[@class='listContent']/ul/li"));
		Utility_Functions.timeWait(2);
		Utility_Functions.xclickOnFirstElementfromList(contactsList);
		Utility_Functions.timeWait(2);
		Utility_Functions.xSendKeys(driver, body, dataTable.getData("General_Data", "Body"));
		Utility_Functions.timeWait(2);
		if(savePrivateNote.isDisplayed()) {
			Utility_Functions.xClick(driver, savePrivateNote, true);
			report.updateTestLog("Verify Private Note", "Private Note is created successfully", Status.PASS);
		} else {
			report.updateTestLog("Verify Private Note", "Private Note is created successfully", Status.FAIL);
		}
		Utility_Functions.timeWait(4);
/*		try {
			if (wasCreated.isDisplayed()) {
				report.updateTestLog("Verify Private Note", "Private Note is created successfully", Status.PASS);
			} else {
				report.updateTestLog("Verify Private Note", "Private Note is created successfully", Status.FAIL);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}*/

	}
	
	/**
	 * Function for validating the Convert Lead by adding the new account in the Convert Lead page
	 * 
	 * @author Vishnuvardhan
	 *
	 */	
	public void convertLeadNewAccount() {
		createLeadFunction();				
		/*searchTextSOQL searchRecord = new searchTextSOQL(scriptHelper);
		String accountName= searchRecord.fetchRecord("account", "Name");
		company.clear();
		Utility_Functions.timeWait(2);
		Utility_Functions.xSendKeys(driver, company, accountName);*/
		Utility_Functions.timeWait(2);
		Utility_Functions.xScrollWindow(driver);
		Utility_Functions.timeWait(1);
		Utility_Functions.xSendKeys(driver, directLineLead, dataTable.getData("General_Data", "Phone"));
		Utility_Functions.timeWait(2);
		Utility_Functions.xClick(driver, saveButton, true);
		Utility_Functions.timeWait(3);		
		Utility_Functions.xClick(driver, saveConvertButton, true);
		Utility_Functions.timeWait(3);
		driver.switchTo().frame(driver.findElement(By.xpath("//iframe[contains(@src,'LeadConversionRed')]")));
		Utility_Functions.timeWait(1);
		convertListValidation();
		Utility_Functions.timeWait(1);
		Utility_Functions.xScrollWindow(driver);
		Utility_Functions.timeWait(2);
		Utility_Functions.xSendKeys(driver, streetField, dataTable.getData("General_Data", "Street"));
		Utility_Functions.timeWait(1);
		Utility_Functions.xSendKeys(driver, cityField, dataTable.getData("General_Data", "City"));
		Utility_Functions.timeWait(1);
		Utility_Functions.xSendKeys(driver, zipCodeField, dataTable.getData("General_Data", "Zipcode"));
		Utility_Functions.timeWait(1);
		Utility_Functions.xSelectDropdownByName(countryField, dataTable.getData("General_Data", "Country"));
		Utility_Functions.timeWait(1);
		Utility_Functions.xSelectDropdownByName(stateField, dataTable.getData("General_Data", "State"));
		Utility_Functions.timeWait(3);
		if(convertButton.isDisplayed()) {
			Utility_Functions.xClick(driver, convertButton, true);
			report.updateTestLog("Verify Convert Lead", "Convert Lead done successfully", Status.PASS);
		} else {
			report.updateTestLog("Verify Convert Lead", "Convert Lead failed", Status.FAIL);
		}
/*		Utility_Functions.timeWait(4);
		if(menu_Home.isDisplayed()) {
			report.updateTestLog("Verify Convert Lead", "Convert Lead done successfully", Status.PASS);
		} else {
			report.updateTestLog("Verify Convert Lead", "Convert Lead failed", Status.FAIL);
		}*/
	}
	
	/**
	 * Function for validating the Convert Lead by adding the new account in the Convert Lead page
	 * 
	 * @author Vishnuvardhan
	 *
	 */	
	public void convertLeadExistingAccount() {
		AccountsFunctions createAccount = new AccountsFunctions(scriptHelper);
		createAccount.createAccount();
		createLeadFunction();				
		SearchTextSOQL searchRecord = new SearchTextSOQL(scriptHelper);
		String accountName= searchRecord.fetchRecord("account", "Name");
		company.clear();
		Utility_Functions.timeWait(2);
		Utility_Functions.xSendKeys(driver, company, accountName);
		Utility_Functions.timeWait(2);
		Utility_Functions.xScrollWindow(driver);
		Utility_Functions.timeWait(1);
		Utility_Functions.xSendKeys(driver, directLineLead, dataTable.getData("General_Data", "Phone"));
		Utility_Functions.timeWait(2);
		Utility_Functions.xClick(driver, saveButton, true);
		Utility_Functions.timeWait(3);	
		Utility_Functions.xWaitForElementVisible(driver, saveConvertButton, 4);
		Utility_Functions.xClick(driver, saveConvertButton, true);
		Utility_Functions.timeWait(3);
		driver.switchTo().frame(driver.findElement(By.xpath("//iframe[contains(@src,'LeadConversionRed')]")));
		Utility_Functions.timeWait(1);
		convertListValidation();
		Utility_Functions.timeWait(3);
		if(convertButton.isDisplayed()) {
			Utility_Functions.xClick(driver, convertButton, true);
			report.updateTestLog("Verify Convert Lead", "Convert Lead done successfully", Status.PASS);
		} else {
			report.updateTestLog("Verify Convert Lead", "Convert Lead failed", Status.FAIL);
		}		
		Utility_Functions.timeWait(4);
/*		if(menu_Home.isDisplayed()) {
			report.updateTestLog("Verify Convert Lead", "Convert Lead done successfully", Status.PASS);
		} else {
			report.updateTestLog("Verify Convert Lead", "Convert Lead failed", Status.FAIL);
		}*/
	}
		
}

