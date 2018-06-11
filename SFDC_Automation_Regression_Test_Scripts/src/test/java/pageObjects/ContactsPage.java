package pageObjects;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
import com.sforce.ws.ConnectionException;

import pagesAPI.AccountsFunctions;
import pagesAPI.EstablishConnection;
import pagesAPI.SearchTextSOQL;
import supportLibraries.SF_UtilityFunctions;
import supportLibraries.Utility_Functions;

public class ContactsPage extends ReusableLibrary {
	/*
	 * Constructor to initialize the business component library
	 * 
	 * @param scriptHelper The {@link ScriptHelper} object passed from the
	 * {@link DriverScript}
	 */

	public ContactsPage(ScriptHelper scriptHelper) {
		super(scriptHelper);
		PageFactory.initElements(driver.getWebDriver(), this);
		// new WebDriverUtil(driver);
		// Utility_Functions utility = new Utility_Functions(scriptHelper);
	}

	// Initialization
	LoginPage loginPage = new LoginPage(scriptHelper);
	Actions actions = new Actions(driver.getWebDriver());
	ActivityPage activityPage = new ActivityPage(scriptHelper);
	EstablishConnection establishConnection = new EstablishConnection(scriptHelper);
	SearchTextSOQL searchSOQL = new SearchTextSOQL(scriptHelper);
	AccountsFunctions accountFunctions = new AccountsFunctions(scriptHelper);
	SF_UtilityFunctions sf_UtilityFunctions = new SF_UtilityFunctions(scriptHelper);
	SaveResult[] results;

	/**
	 * This function navigates to Contact Tab
	 * 
	 * @author Swapna
	 *
	 */
	public void navigateContacts() {
		sf_UtilityFunctions.oneAppNavigationTab("Contacts");
	}

	/**
	 * This function navigates to New Contact page
	 * 
	 * @author Swapna
	 */
	public void navigateNewContactPage(String selectNewRecordType) {
		navigateContacts();
		sf_UtilityFunctions.selectAction("New");
		try {
			sf_UtilityFunctions.selectRecordTypeRadioButton(selectNewRecordType);
			Utility_Functions.xSwitchtoFrame(driver, sf_UtilityFunctions.getStdPopupTitle("Contact"));
		} catch (Exception e) {
			System.out.println("Record Type selection is not needed ....");
			Utility_Functions.xSwitchtoFrame(driver, sf_UtilityFunctions.getStdPopupTitle("Contact"));
		}
		System.out.println("Record Type selected :::" + sf_UtilityFunctions.getStdPopupTitle("Contact").getText());
	}

	/**
	 * This function navigates to Contact Tab and selects an existing Contact
	 * 
	 * @author Swapna
	 *
	 */

	public void selectExistingContact() {
		sf_UtilityFunctions.oneAppNavigationTab("Contacts");
		sf_UtilityFunctions.selectExistingObjectRecord("Name");

	}

	/**
	 * This function navigates to Contact Tab and selects an existing Contact
	 * based on the Contact Record Type parameter
	 * 
	 * @author Swapna
	 *
	 */
	public void selectExistingContact(String contactRecordType) {
		sf_UtilityFunctions.oneAppNavigationTab("Contacts");
		By visibleRecords = By
				.xpath("//thead/following-sibling::tbody//td/span/span[contains(text(),'" + contactRecordType + "')]");
		try {
			Utility_Functions.xWaitForElementPresent(driver, driver.findElements(visibleRecords), 7);
			if (driver.findElements(visibleRecords).size() > 0) {
				driver.findElement(By.xpath("(//thead/following-sibling::tbody//td/span/span[contains(text(),'"
						+ contactRecordType + "')]/ancestor::tr/th//a)[1]")).click();
			}
		} catch (Exception e) {
			By recentlyViewed = By.xpath("//h1//span[text()='Recently Viewed']");
			By all = By.xpath("//span[contains(@class,'virtualAutocompleteOptionText')][contains(text(),'All')]");
			Utility_Functions.xWaitForElementPresent(driver, recentlyViewed, 3);
			driver.findElement(recentlyViewed).click();
			report.updateTestLog("Verify Recently Viewed", "Recently viewed dropdown is clicked::: ", Status.PASS);
			Utility_Functions.xWaitForElementPresent(driver, all, 5);
			driver.findElement(all).click();
			Utility_Functions.xWaitForElementPresent(driver, driver.findElements(visibleRecords), 7);
			if (driver.findElements(visibleRecords).size() > 0) {
				driver.findElement(By.xpath("(//thead/following-sibling::tbody//td/span/span[contains(text(),'"
						+ contactRecordType + "')]/ancestor::tr/th//a)[1]")).click();
			}
		}
		Utility_Functions.timeWait(2);
	}

	/**
	 * This function opens an existing Contact by Id
	 * @author Swapna
	 * @throws Exception
	 *
	 */
	public void selectExistingContactById(String contactId) throws Exception {
		sf_UtilityFunctions.openDetailPage(contactId);
		Utility_Functions.timeWait(3);
	}
	
	
	/**
	 * This function returns Account Name on a Contact
	 * @author Swapna
	 * @throws Exception
	 */
	@FindBy(xpath = "//span[text()='Account Name']/parent::div/following-sibling::div//a") List<WebElement> accountNameSaved;
	public String getAccountNameOnContact(String contactId) throws Exception{
		sf_UtilityFunctions.openDetailPage(contactId);
		Utility_Functions.timeWait(3);
		//String accountName=accountNameSaved.getText();
		String accountName=Utility_Functions.xGetTextVisibleListElement(driver, accountNameSaved);
		System.out.println(accountName);
		return accountName;
				
	
	}

	/**
	 * This function initiates list values for ABAMER,OBAMER,OBAPAC,CMAPAC,ADMIN
	 * profiles
	 * 
	 * @author SBitra
	 */
	static ArrayList<String> ContactLabelList = new ArrayList<String>();

	public void ABAMERBrokerContactAllLabelList() {
		ContactLabelList.clear();
		if ((dataTable.getData("General_Data", "TC_ID").contains("ABAMER"))
				|| (dataTable.getData("General_Data", "TC_ID").contains("OBAMER"))) {
			String[] values = { "Account ID", "Full Name", "Record Type ID", "Address", "Direct Line", "Business Fax",
					"Mobile Phone", "Reports To ID", "Email", "Title", "Owner ID", "Do Not Call", "Email Options",
					"Middle Name", "Nickname", "Assistant Email", "Assistant Name", "Assistant Phone", "Call Options",
					"Mail Options", "Department", "Influence Level", "Reason for Inactivating", "Status",
					"Inactive Contact", "Main Phone", "Exclude Reason", "Excluded By", "Excluded On", "Comm Email Sent",
					"Inactivation Date", "Preferred Comm Method", "Fee Share Partner" };
			ContactLabelList = (ArrayList<String>) Utility_Functions.InitiateListValues(values);
		} else if ((dataTable.getData("General_Data", "TC_ID").contains("OBAPAC"))
				|| (dataTable.getData("General_Data", "TC_ID").contains("CMAPAC"))) {
			String[] values2 = { "Account ID", "Full Name", "Address", "Direct Line", "Mobile Phone", "Reports To ID",
					"Email", "Title", "Email Options", "Nickname", "Assistant Email", "Assistant Name",
					"Assistant Phone", "Call Options", "Mail Options", "Department", "Influence Level",
					"Reason for Inactivating", "Status", "Inactive Contact", "Exclude Reason", "Excluded By",
					"Excluded On", "Inactivation Date", "Preferred Comm Method", "PAC CM special categories",
					"PAC CM Metro special categories", "PAC Hotels special categories",
					"PAC Industrial special categories", "PAC Office special categories",
					"PAC Retail special categories", "Contact Type" };
			ContactLabelList = (ArrayList<String>) Utility_Functions.InitiateListValues(values2);
		} else if (dataTable.getData("General_Data", "TC_ID").contains("Admin")) {
			String[] values3 = { "Account ID", "Full Name", "Record Type ID", "Address", "Direct Line", "Business Fax",
					"Mobile Phone", "Reports To ID", "Email", "Title", "Owner ID", "Email Options", "Middle Name",
					"Nickname", "Assistant Email", "Assistant Name", "Assistant Phone", "Call Options", "Mail Options",
					"Department", "Influence Level", "Reason for Inactivating", "Source System", "Status",
					"Inactive Contact", "Main Phone", "Best Connected Colleague", "HugRank", "Last Meeting",
					"Last Email Received", "Next Meeting", "Number of Colleagues", "Key Contact Segmentation",
					"Developers", "Gender", "Hobbies/Pastimes", "IRL Campaign", "Known to Asset Services",
					"Mailing Lists", "Previous Campaigns/Events", "Segmentation", "Dietary Requirements",
					"Exclude Reason", "Excluded By", "Excluded On", "CIF Source System ID", "Comm Email Sent",
					"Employee?", "Inactivation Date", "Inactive Date", "Integration Id", "Preferred Comm Method",
					"Source Created Date Time", "Source Last Updated Date Time", "Fee Share Partner",
					"Email Sent AU & NZ", "PAC CM special categories", "PAC CM Metro special categories",
					"PAC Hotels special categories", "PAC Industrial special categories",
					"PAC Office special categories", "PAC Retail special categories", "Contact Type" };
			ContactLabelList = (ArrayList<String>) Utility_Functions.InitiateListValues(values3);
		}
	}

	/**
	 * This is a API function validating new Contact Page Layout for
	 * ABAMER,OBAMER,OBAPAC,CMAPAC,ADMIN profiles
	 * 
	 * @author Swapna
	 */
	public void newContactPageLayout() {
		ABAMERBrokerContactAllLabelList();
		String contactRecordType = null;
		if ((dataTable.getData("General_Data", "TC_ID").contains("ABAMER"))
				|| (dataTable.getData("General_Data", "TC_ID").contains("OBAMER"))) {
			contactRecordType = "CBRE Broker - Contact Layout";
		} else if ((dataTable.getData("General_Data", "TC_ID").contains("OBAPAC"))
				|| (dataTable.getData("General_Data", "TC_ID").contains("CMAPAC"))) {
			contactRecordType = "CBRE APAC & JP - Contact Layout";
		} else if (dataTable.getData("General_Data", "TC_ID").contains("Admin")) {
			contactRecordType = "CBRE Admin - Contact Layout";
		}
		// projectEnquiriesFields();
		List<String> propertySalesProjectEnquiries = establishConnection
				.establishMetaDataConnectionPageLayouts("Contact", contactRecordType);
		System.out.println("List values :::" + propertySalesProjectEnquiries);
		List<String> propertySalesProjectEnquiriesList = new ArrayList<String>();
		propertySalesProjectEnquiriesList = Utility_Functions.xValidatePickListValuesPage(propertySalesProjectEnquiries,
				ContactLabelList, "Project Enquiries field values");
		if (propertySalesProjectEnquiriesList.size() != 0) {
			report.updateTestLog("Verify Project Enquiries Page Field Labels",
					"All the labels are not present in the Enquiries Page Field Labels:::"
							+ propertySalesProjectEnquiriesList,
					Status.FAIL);
		} else {
			report.updateTestLog("Verify Project Enquiries Page Field Labels",
					"All the labels are present in the Enquiries Page Field Labels", Status.PASS);
		}

		System.out.println("Test completed successfully!!");
	}

	/**
	 * This function returns Contact page layout name based on the testcase name
	 * and the recordType
	 * 
	 * @returns pageLayout
	 * @param recordType
	 * @author Swapna
	 */
	public String getContactPageLayout(String recordType) {
		String pageLayout = null;

		// CBREEMEADataAdmin
		if ((dataTable.getData("General_Data", "TC_ID").contains("EMEA"))
				&& (dataTable.getData("General_Data", "TC_ID").contains("Data"))
				&& (dataTable.getData("General_Data", "TC_ID").contains("Admin"))) {
			if (recordType == "CBRE Client Contact") {
				pageLayout = "CBRE EMEA - Contact Layout";
			} else if (recordType == "CBRE Employee Contact") {
				pageLayout = "CBRE Admin - Employee Contact Layout";
			}
			// CBREDataAdmin || SysAdmin
		} else if ((dataTable.getData("General_Data", "TC_ID").contains("Data"))
				&& (dataTable.getData("General_Data", "TC_ID").contains("Admin"))
				|| (dataTable.getData("General_Data", "TC_ID").contains("Sys"))
						&& (dataTable.getData("General_Data", "TC_ID").contains("Admin"))) {
			if (recordType == "CBRE Client Contact") {
				pageLayout = "CBRE Admin - Contact Layout";
			} else if (recordType == "CBRE Employee Contact") {
				pageLayout = "CBRE Admin - Employee Contact Layout";
			}
			// France
		} else if (dataTable.getData("General_Data", "TC_ID").contains("France")) {
			if (recordType == "CBRE Client Contact") {
				pageLayout = "CBRE France - Contact Layout";
			} else if (recordType == "CBRE Employee Contact") {
				pageLayout = "CBRE Broker - Employee Contact Layout";
			}
		} else if ((dataTable.getData("General_Data", "TC_ID").contains("AS"))
				&& (dataTable.getData("General_Data", "TC_ID").contains("EMEA"))
				|| (dataTable.getData("General_Data", "TC_ID").contains("AS"))
						&& (dataTable.getData("General_Data", "TC_ID").contains("AMER"))
				|| (dataTable.getData("General_Data", "TC_ID").contains("VAS"))
						&& (dataTable.getData("General_Data", "TC_ID").contains("AMER"))
				|| (dataTable.getData("General_Data", "TC_ID").contains("AS"))
						&& (dataTable.getData("General_Data", "TC_ID").contains("GIA"))) {
			if ((recordType == "CBRE Client Contact") || (recordType == "CBRE Employee Contact")) {
				pageLayout = "CBRE Asset Services & VAS - Contact Layout";
			}
		} else if ((!dataTable.getData("General_Data", "TC_ID").contains("AS"))
				&& (dataTable.getData("General_Data", "TC_ID").contains("EMEA"))
				|| (!dataTable.getData("General_Data", "TC_ID").contains("AS"))
						&& (dataTable.getData("General_Data", "TC_ID").contains("AMER"))) {
			if (recordType == "CBRE Client Contact") {
				pageLayout = "CBRE Broker - Contact Layout";
			} else if (recordType == "CBRE Employee Contact") {
				pageLayout = "CBRE Broker - Employee Contact Layout";
			}
		} else if ((dataTable.getData("General_Data", "TC_ID").contains("AS"))
				&& (dataTable.getData("General_Data", "TC_ID").contains("APAC"))
				|| (dataTable.getData("General_Data", "TC_ID").contains("AS"))
						&& (dataTable.getData("General_Data", "TC_ID").contains("JP"))) {
			if (recordType == "CBRE Client Contact") {
				pageLayout = "CBRE APAC & JP - Contact Layout";
			} else if (recordType == "CBRE Employee Contact") {
				pageLayout = "CBRE Broker - Employee Contact Layout";
			}
		} else if ((!dataTable.getData("General_Data", "TC_ID").contains("AS"))
				&& (dataTable.getData("General_Data", "TC_ID").contains("APAC"))
				|| (!dataTable.getData("General_Data", "TC_ID").contains("AS"))
						&& (dataTable.getData("General_Data", "TC_ID").contains("JP"))) {
			if (recordType == "CBRE Client Contact") {
				pageLayout = "CBRE APAC & JP - Contact Layout";
			} else if (recordType == "CBRE Employee Contact") {
				pageLayout = "CBRE Asset Services & VAS - Contact Layout";
			}
		}
		return pageLayout;
	}

	/**
	 * This function returns all field labels for a Contact Page Layout
	 * 
	 * @param pageLayout
	 * @returns MapObj (SectionName and FieldNames)
	 * @author Swapna
	 */
	public Map<String, List<String>> getContactPageElements(String pageLayout) {
		Map<String, List<String>> mapObj = new HashMap<String, List<String>>();
		List<String> ContactLabelList = null;
		if (pageLayout == "CBRE Broker - Contact Layout") {
			String[] values1 = { "Name", "Middle Name", "Nickname", "Title", "Department", "Influence Level",
					"Reports To", "Do Not Call", "CreatedByCountry", "Fee Share Partner", "Account Name", "Direct Line",
					"Mobile", "Main Phone", "Email", "Status", "Inactive Contact", "Contact Record Type" };
			ContactLabelList = Utility_Functions.InitiateListValues(values1);
			mapObj.put("Contact Information", ContactLabelList);

			String[] values2 = { "Email Options", "Mail Options", "Call Options" };
			ContactLabelList = Utility_Functions.InitiateListValues(values2);
			mapObj.put("Communication Preferences", ContactLabelList);

			String[] values3 = { "Address" };
			ContactLabelList = Utility_Functions.InitiateListValues(values3);
			mapObj.put("Address Information", ContactLabelList);

			String[] values4 = { "Fax", "Preferred Comm Method", "Comm Email Sent", "Reason for Inactivating",
					"Inactivation Date", "Assistant Name", "Assistant Phone", "Assistant Email" };
			ContactLabelList = Utility_Functions.InitiateListValues(values4);
			mapObj.put("Additional Information", ContactLabelList);

			String[] values5 = { "LinkedIn", "Google Maps", "Google Search" };
			ContactLabelList = Utility_Functions.InitiateListValues(values5);
			mapObj.put("Custom Links", ContactLabelList);

			String[] values6 = { "Contact Owner", "Last Manually Modified Date", "Created By",
					"Last Manually Modified By" };
			ContactLabelList = Utility_Functions.InitiateListValues(values6);
			mapObj.put("System Information", ContactLabelList);

		} else if (pageLayout == "CBRE APAC & JP - Contact Layout") {
			String[] values1 = { "Name", "Title", "Department", "Contact Profile", "Contact Type", "Account Name",
					"Email", "Direct Line", "Mobile", "Influence Level" };
			ContactLabelList = Utility_Functions.InitiateListValues(values1);
			mapObj.put("Contact Information", ContactLabelList);

			String[] values2 = { "Address" };
			ContactLabelList = Utility_Functions.InitiateListValues(values2);
			mapObj.put("Address Information", ContactLabelList);

			String[] values3 = { "Preferred Comm Method", "Email Options", "Mail Options", "Call Options",
					"Exclude Reason", "Excluded On", "Excluded By" };
			ContactLabelList = Utility_Functions.InitiateListValues(values3);
			mapObj.put("Communication Preferences", ContactLabelList);

			String[] values4 = { "Nickname", "Reports To", "Assistant Name", "Assistant Phone", "Assistant Email" };
			ContactLabelList = Utility_Functions.InitiateListValues(values4);
			mapObj.put("Additional Information", ContactLabelList);

			String[] values5 = { "Created By", "Last Manually Modified Date", "Last Manually Modified By", "Status",
					"Reason for Inactivating", "Inactivation Date", "Inactive Contact" };
			ContactLabelList = Utility_Functions.InitiateListValues(values5);
			mapObj.put("System Information", ContactLabelList);
		}
		return mapObj;
	}

	/**
	 * This function validates Field Labels under each section in Contact Page
	 * Layout
	 * 
	 * @param MapObj
	 *            (SectionName and FieldNames)
	 * @author Swapna
	 */
	public void verifySectionElementsInPage(Map<String, List<String>> mapObj) {
		WebElement Field = null;
		String sectionName = null;
		Map<String, List<String>> mapObject = mapObj;
		for (Map.Entry<String, List<String>> entry : mapObject.entrySet()) {
			Utility_Functions.xScrollWindowTop(driver);
			sectionName = entry.getKey();
			System.out.println("Key " + entry.getKey());
			System.out.println("Value " + entry.getValue() + " __");
			if (entry.getValue() != null || entry.getValue().size() > 0) {
				System.out.println("Key " + entry.getValue().size());
				for (String fieldName : entry.getValue()) {
					By Field_Under_SectionInPopup = By.xpath("//span[text()='" + sectionName
							+ "']/parent::h3/following-sibling::div//span[string-length(text()) > 0 and text()='"
							+ fieldName + "']");
					By Field_Under_SectionInDetail = By.xpath("//span[text()='" + sectionName
							+ "']/ancestor::h3/following-sibling::div//span[string-length(text()) > 0 and text()='"
							+ fieldName + "']");
					try {
						Utility_Functions.xScrollWindowToElement(driver,
								driver.findElement(Field_Under_SectionInPopup));
					} catch (Exception e) {
						Utility_Functions.xScrollWindowToElement(driver,
								driver.findElement(Field_Under_SectionInDetail));
					}
				}
				System.out.println("Verified Field Names : " + entry.getValue() + " are present under the section : "
						+ sectionName + " ::::passed");
			} else {
				By sectionName_InPopup = By.xpath("//span[text()='" + sectionName + "']/parent::h3/span");
				By sectionName_InDetail = By.xpath("//span[text()='" + sectionName + "']/ancestor::h3//span");
				try {
					Utility_Functions.xScrollWindowToElement(driver, driver.findElement(sectionName_InPopup));
					Field = driver.findElement(sectionName_InPopup);
				} catch (Exception e) {
					Utility_Functions.xScrollWindowToElement(driver, driver.findElement(sectionName_InDetail));
					Field = driver.findElement(sectionName_InDetail);
				}
			  System.out.println("label is present on the Contact Page ..."+ Field.getText());
			}
		}
		System.out.println("Test completed successfully!!");
	}

	/**
	 * This function validates Contact Page Layout
	 * 
	 * @param recordType
	 * @author Swapna
	 */
	public void validateContactPageLayout(String recordType) {
		String pageLayout = getContactPageLayout(recordType);
		Map<String, List<String>> sectionfields = getContactPageElements(pageLayout);
		verifySectionElementsInPage(sectionfields);
		if (pageLayout == "CBRE APAC & JP - Contact Layout" || pageLayout == "CBRE Broker - Contact Layout") {
			// verify section name is present
			By sectionName = By.xpath("//span[text()='Tagging']/ancestor::h3");
			Utility_Functions.xScrollWindowToElement(driver, driver.findElement(sectionName));
			if (driver.findElement(sectionName).isDisplayed()) {
				System.out.println("Verified 'Tagging' Section Name is present ::::passed");
			}
		}

	}

	/**
	 * Validating New Notes and File attachment
	 * 
	 * @author Swapna
	 */
	public void verifyNewNotesAndFileAttachment(String contactRecordType) {
		try {
			String note = "Test Note" + Utility_Functions.xRandomFunction();
			selectExistingContact(contactRecordType);
			String contactName = sf_UtilityFunctions.getPageHeader("Contact");
			System.out.println("Selected Contact ::" + contactName);
			sf_UtilityFunctions.selectRelatedTab("Other Related");
			sf_UtilityFunctions.verifyRelatedListPresent("Notes");
			sf_UtilityFunctions.verifyRelatedListPresent("Files");
			sf_UtilityFunctions.verifyRelatedListPresent("Notes and Attachments");
			sf_UtilityFunctions.selectRelatedListsButton("Notes", "New");

			// specific locators
			By untitledNote = By.xpath("//input[@placeholder='Untitled Note']");
			By noteEditArea = By.xpath("//div[@data-placeholder='Enter a note...']");
			By noteContact = By.xpath("//a[contains(@class,'pill') and text()='" + contactName + "']");

			Utility_Functions.xWaitForElementPresent(driver, noteEditArea, 3);
			Utility_Functions.xHoverElementclicks(driver.findElement(noteEditArea), driver);
			driver.findElement(noteEditArea).sendKeys("Test Note Area");
			System.out.println("Text Area is present in the Note Page");
			Utility_Functions.xWaitForElementPresent(driver, untitledNote, 7);
			driver.findElement(untitledNote).sendKeys(note);
			System.out.println("Untitled Note is present in the Note Page");
			Utility_Functions.xWaitForElementPresent(driver, noteContact, 3);
			System.out.println("Selected Contact is present in the Note Page");
			sf_UtilityFunctions.clickOnButton("Done");
			Utility_Functions.timeWait(1);

			sf_UtilityFunctions.selectRelatedListsButton("Files", "Add Files");
			sf_UtilityFunctions.selectCheckBox(note);
			sf_UtilityFunctions.clickOnButton("Add (1)");
			System.out.println("Test Completed successfully!!");
		} catch (Exception e) {
			System.out.println("Error validating Notes and File Attachments" + e.getMessage());
			throw e;
		}

	}

	/**
	 * This function creates a contact with required fields
	 * 
	 * @author Swapna renamed the function public void
	 *         contactsPopulatingTheRequiredFields2() {}
	 */
	public String createContact(String contactRecordType) {
		establishConnection.establishConnection();
		String contactRecordTypeId = searchSOQL.fetchRecordFieldValueAdminLogin("Id",
				"SELECT id from recordtype where name like '" + contactRecordType + "'");
		SObject contact = new SObject();
		contact.setType("Contact");
		contact.setField("RecordTypeId", contactRecordTypeId);
		contact.setField("LastName", Utility_Functions.xRandomFunction() + "_" + "TestContact");
		contact.setField("Salutation", "Mr.");
		String accountId = searchSOQL.fetchRecord("Account", "Id");
		if (accountId == null) {
			accountId = accountFunctions.createAccountRequiredFields();
		}
		contact.setField("AccountId", accountId);
		SObject[] contacts = new SObject[1];
		contacts[0] = contact;
		try {
			results = EstablishConnection.connection.create(contacts);
		} catch (ConnectionException e) {
			e.printStackTrace();
		}
		System.out.println("Result:::" + results);
		String contactId = establishConnection.saveResultsId(results);
		if (contactId.startsWith("003")) {
			report.updateTestLog("Verify Create Contact", "Contact has been created successfully", Status.PASS);
		} else {
			report.updateTestLog("Verify Create Contact", "Contact creation failed", Status.FAIL);
		}
		return contactId;
	}

	/**
	 * This function verifies MarketingSegmentationFields
	 * 
	 * @author Swapna
	 * @throws Exception
	 * 
	 */
	public void contactsMarketingSegmentationFields() throws Exception {
		try {
			selectExistingContact();
		} catch (Exception e) {
			sf_UtilityFunctions.openDetailPage(createContact("CBRE Client Contact"));
		}
		Utility_Functions.timeWait(3);
		Utility_Functions.xScrollWindow(driver);
		Utility_Functions.xScrollWindowTop(driver);
		String[] values = { "Client Interest - Asset Class", "Client Interest - Topics", "Client Interest - Industry",
				"Client Interest - Type", "Events", "Occupier Client Type", "Client Level of Influence",
				"CBRE Level of Engagement", "Satisfaction Survey Participation", "Meeting Engagement" };
		ArrayList<String> fieldNames = (ArrayList<String>) Utility_Functions.InitiateListValues(values);
		sf_UtilityFunctions.verifyElementsArePresentInSection("Marketing Segmentation", fieldNames);
		System.out.println("Test Completed Successfully");
	}

	/**
	 * This function verifies UpdationOfContactRecord
	 * 
	 * @author Swapna
	 * @throws Exception
	 */
	@FindBy(xpath = "//span[text()='Name']/parent::div/following-sibling::div/span/span")
	WebElement contactFName;
	@FindBy(xpath = "//span[text()='Name']/parent::div/following-sibling::div/span/span")
	WebElement contactName;

	public void verifyUpdationOfContactRecord() throws Exception {
		try {
			selectExistingContact();
		} catch (Exception e) {
			sf_UtilityFunctions.openDetailPage(createContact("CBRE Client Contact"));
		}
		sf_UtilityFunctions.clickOnDetailAction("Edit");
		if ((sf_UtilityFunctions.getStdPopupTitle("Edit").getText()).contains("Edit")) {
			System.out.println("Edit page is displayed.");
		}
		Utility_Functions.xWaitForElementPresent(driver, contactFName, 3);
		contactFName.clear();
		contactFName.sendKeys("EditedFName");
		sf_UtilityFunctions.clickOnButton("Save");

		Utility_Functions.xWaitForElementPresent(driver, contactName, 3);
		if (contactName.getText().contains("EditedFName")) {
			System.out.println("Contact First Name is updated successfully");
		}
		System.out.println("Test Completed successfully");
	}

	/**
	 * This function verifies contact Tagging
	 * 
	 * @author Swapna
	 */
	@FindBy(xpath = "//*[@id='tag_edit_link']")
	WebElement addTag;
	@FindBy(xpath = "//textarea[@id='ptag_edit_area']")
	WebElement privateTag;
	@FindBy(xpath = "//input[@id='tag_save_btn']")
	WebElement savePrivateTag;

	public void contactTagging() {
		selectExistingContact();
		Utility_Functions.xWaitForElementPresent(driver, addTag, 6);
		addTag.click();
		Utility_Functions.xWaitForElementPresent(driver, privateTag, 3);
		privateTag.sendKeys("Test Tagging");
		Utility_Functions.xWaitForElementPresent(driver, savePrivateTag, 2);
		savePrivateTag.click();
	}

	public void activityLightningTimeline() {
	} // related to activity

	public void verifyCreateActivityContact() {
	}

	public void verifyContactNewActivityPageLayout() {
	}

	public void verifyContactNewActivityPageSendNotificationEmail() {
	}

	public void verifyContactActivityReminderSentFunctionality() {
	}

	public void verifyContactsActivityTimeline() {
	}

	public void verifyContactEditPageNotEditableFields() {  //changed to verifyUpdationOfContactRecord
	}

	public void contactsPopulatingAllFields() {
	} // check if we need this same as create contact API

	public void accountLookUpNewContactPage() {
	} // Not needed

}
