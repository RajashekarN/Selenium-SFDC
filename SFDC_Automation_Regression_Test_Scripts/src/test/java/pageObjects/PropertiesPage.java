package pageObjects;

import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.cognizant.Craft.ReusableLibrary;
import com.cognizant.Craft.ScriptHelper;
import com.cognizant.framework.Status;
import pagesAPI.EstablishConnection;
import supportLibraries.SF_UtilityFunctions;
import supportLibraries.Utility_Functions;

public class PropertiesPage extends ReusableLibrary {
	/*
	 * Constructor to initialize the business component library
	 *
	 * @param scriptHelper The {@link ScriptHelper} object passed from the
	 * {@link DriverScript}
	 */

	public PropertiesPage(ScriptHelper scriptHelper) {
		super(scriptHelper);
		PageFactory.initElements(driver.getWebDriver(), this);
	}

	/**
	 * Page Objects for navigateProperties function
	 *
	 * @author Vishnuvardhan
	 *
	 */	
	
	@FindBy(xpath = "//one-app-nav-bar-menu-item[@class='overflowNavItem slds-dropdown__item']//span[text()='Properties'] ")
	WebElement properties;

	@FindBy(xpath = "//div[@class='overflowList']//a[@title='Properties'][text()='Properties']")
	WebElement propertiesEnv;
	
	@FindBy(xpath = "//one-app-nav-bar[contains(@class,'slds-has-flexi-truncate')]//span[text()='More']")
	WebElement more;
		
	/**
	 * Page Objects for navigateNewPropertyPage function
	 *
	 * @author Vishnuvardhan
	 *
	 */
	
	@FindBy(xpath = "//h2[contains(@class,'slds-m-bottom--large')][text()='Property Information']")
	WebElement propertyInformationFrame;
	
	/**
	 * Page Objects for validateCustomPropertyPage function
	 *
	 * @author Vishnuvardhan
	 *
	 */	

	//@FindBy(xpath = "//label[text()='Building/Property Name']/parent::div/div/div/input")
	@FindBy(xpath="//label[@for='property-name']/parent::div//input")
	WebElement buildingPropertyName;
	
	/**
	 * Page Objects for createProperty function
	 *
	 * @author Vishnuvardhan
	 *
	 */
	
	@FindBy(xpath = "//*[contains(@id,'propertyEditForm:countryPicklist')]")
	WebElement countryDropdown;

	@FindBy(xpath = "//*[contains(@id,'propertyEditForm:Street')]")
	WebElement street;

	@FindBy(xpath = "//*[contains(@id,'propertyEditForm:City')]")
	WebElement city;
	
	@FindBy(xpath = "//*[contains(@id,'propertyEditForm:statePicklist')]")
	WebElement stateDropdown;
	
	@FindBy(xpath = "//*[@value='Save Property']")
	WebElement saveProperty;
	
	@FindBy(xpath = "//h1[@class='slds-page-header__title slds-m-right--small slds-truncate slds-align-middle']/span")
	WebElement createdProperty;
	
	/**
	 * Page Objects for validateCampaignsTab function
	 *
	 * @author Vishnuvardhan
	 *
	 */
	
	@FindBy(xpath = "//a[@role='menuitem']/span[contains(@class,'slds-truncate')][text()='Campaigns']")
	WebElement campaigns;

	@FindBy(xpath = "//div[@role='menu']//a/span/span[text()='Campaigns']")
	WebElement campaignsEnv;
	
	@FindBy(xpath = "//a[contains(@id,'tag_edit_link')]")
	WebElement addTag;

	@FindBy(xpath = "//textarea[@id='ptag_edit_area']")
	WebElement privatetag;

	@FindBy(xpath = "//input[@id='tag_save_btn']")
	WebElement savePrivateTag;
	
	/**
	 * Page Objects for Property Type field value function
	 *
	 * @author Vishnuvardhan
	 *
	 */
	
	@FindBy(xpath = "//label[text()='Building/Property Name']/parent::div/parent::div//div[contains(@class,'requiredInput')]//input[contains(@id,'propertyEditForm')]")
	WebElement propertyName;

	@FindBy(xpath = "//select[contains(@id,'countryPicklist')]")
	WebElement propertyCountry;

	@FindBy(xpath = "//select[contains(@id,'countryPicklist')]/option[text()='United States']")
	WebElement selectPropertyCountry;

	@FindBy(xpath = "//textarea[contains(@id,'propertyEditForm:Street')]")
	WebElement propertyStreet;

	@FindBy(xpath = "//input[contains(@id,'propertyEditForm:City')]")
	WebElement propertyCity;

	@FindBy(xpath = "//select[contains(@id,'propertyEditForm:statePicklist')]")
	WebElement statePickList;

	@FindBy(xpath = "//select[contains(@id,'statePicklist')]/option[text()='Texas']")
	WebElement selectPropertyState;
	
	@FindBy(xpath = "//td[@class='multiSelectPicklistCell']/a[@title='Add']")
	WebElement addValuetoCheckList;
	
	@FindBy(xpath = "//select[contains(@id,'propertyEditForm:Class')]")
	WebElement buildingClass;

	@FindBy(xpath = "//select[contains(@id,'propertyEditForm:Class')]/option[@value='A']")
	WebElement buildingClassValue;

	@FindBy(xpath = "//a[@class='tabHeader']//span[text()='Details']")
	WebElement details;

	DateFormat dateFormat;
	Date date = new Date();

	EstablishConnection establishConnection = new EstablishConnection(scriptHelper);
	SF_UtilityFunctions sf_UtilityFunctions = new SF_UtilityFunctions(scriptHelper);

	/**
	 * Function for navigating to Properties section
	 *
	 * @author Vishnuvardhan
	 *
	 */

	public void navigateProperties() {
		try {
			Utility_Functions.xWaitForElementPresent(driver, properties, 2);
			Utility_Functions.xClick(driver, properties, true);
		} catch (Exception e) {
			Utility_Functions.xWaitForElementPresent(driver, more, 2);
			Utility_Functions.xClick(driver, more, true);
			try {
				Utility_Functions.xWaitForElementPresent(driver, properties, 2);
				Utility_Functions.xClick(driver, properties, true);
			} catch (Exception e1) {
				Utility_Functions.xWaitForElementPresent(driver, propertiesEnv, 2);
				Utility_Functions.xClick(driver, propertiesEnv, true);
			}
		}
	}
	
	/**
	 * Function for selecting the property from the list of properties
	 *
	 * @author Vishnuvardhan
	 *
	 */

	public void selectProperty() {
		navigateProperties();
		sf_UtilityFunctions.selectExistingObjectRecord("Property Name");
	}


	/**
	 * Function for navigating to New Property
	 *
	 * @author Vishnuvardhan
	 *
	 */
	public void navigateNewPropertyPage() {
		navigateProperties();
		sf_UtilityFunctions.selectAction("New");
		Utility_Functions.xSwitchtoFrame(driver, propertyInformationFrame);
	}
	
	/**
	 * Function for Property Creation
	 *
	 * @author Vishnuvardhan
	 *
	 */
	
	public void addProperty() {
		navigateNewPropertyPage();
		createProperty();
	}	

	/**
	 * Validating the Customer Property Page headers
	 *
	 * @author Vishnuvardhan
	 *
	 */

	static List<String> adminPropertyHeaderList = new ArrayList<String>();

	public void adminHeaderList() {
		adminPropertyHeaderList.add("Property Information");
		adminPropertyHeaderList.add("Address Information");
		adminPropertyHeaderList.add("Property Financials");
		adminPropertyHeaderList.add("Property Summary");
		adminPropertyHeaderList.add("Property Management");
		adminPropertyHeaderList.add("Asset Management");
		adminPropertyHeaderList.add("Listing Management");
		System.out.println("Propety page contains the header section:::" + adminPropertyHeaderList);
	}

	public void validateCustomPropertyPage() {
		verifyUnitsOfMeasurePickListValues();
		navigateProperties();
		sf_UtilityFunctions.selectAction("New");
		
		driver.switchTo().defaultContent();
		List<WebElement> iframeList = driver.findElements(By.tagName("iframe"));
		driver.switchTo().frame(iframeList.size()-1);
				
		//Utility_Functions.xSwitchtoFrame(driver, buildingPropertyName);
		Utility_Functions.timeWait(4);
		Utility_Functions.xWaitForElementPresent(driver, buildingPropertyName, 3);
		Utility_Functions.xClick(driver, buildingPropertyName, true);
		adminHeaderList();
		Utility_Functions.timeWait(4);
		List<WebElement> propertyHeaderList = driver.findElements(By.xpath("//h2[contains(@class,'heading') and contains(@class,'large')]"));
		List<String> headerCount = Utility_Functions.xValidateFieldsPresentonPage(adminPropertyHeaderList, propertyHeaderList, "Property Header section is present");
		if (headerCount.size() == 0) {
			report.updateTestLog("Property Information page",
					"Property Information page is having all header sections::", Status.PASS);
		} else {
			report.updateTestLog("Property Information page",
					"Property Information page is not having all the header sections::", Status.FAIL);
		}
		Utility_Functions.xScrollWindow(driver);
		Utility_Functions.timeWait(1);
		Utility_Functions.xScrollWindowTop(driver);
		Utility_Functions.timeWait(1);
		validatePropertyFieldsSection();
		createProperty();
	}

	/**
	 * Validating the Customer Property Page fields
	 *
	 * @author Vishnuvardhan
	 *
	 */

	static List<String> adminPropertyInformationLabelList = new ArrayList<String>();
	static List<String> adminAddressInformationLabelList = new ArrayList<String>();
	static List<String> adminPropertyFinancialsLabelList = new ArrayList<String>();
	static List<String> adminPropertySummaryLabelList = new ArrayList<String>();
	static List<String> adminPropertyManagementLabelList = new ArrayList<String>();
	static List<String> adminAssetManagementLabelList = new ArrayList<String>();
	static List<String> adminListingMangementLabelList = new ArrayList<String>();

	public void adminPropertyInformationLabelList() {
		adminPropertyInformationLabelList.add("Building/Property Name");
		adminPropertyInformationLabelList.add("Property Website");
		adminPropertyInformationLabelList.add("Record Type");
		adminPropertyInformationLabelList.add("Stacking URL");
		adminPropertyInformationLabelList.add("GRID Property Record Link");
		System.out.println("Property Information header section contains the fields:::" + adminPropertyInformationLabelList);
	}

	public void adminAddressInformationLabelList() {
		adminAddressInformationLabelList.add("Country");
		adminAddressInformationLabelList.add("Street");
		adminAddressInformationLabelList.add("City");
		adminAddressInformationLabelList.add("State/Province");
		adminAddressInformationLabelList.add("Zip/Postal Code");
		adminAddressInformationLabelList.add("Region");
		adminAddressInformationLabelList.add("Market");
		adminAddressInformationLabelList.add("Sub Market");
		adminAddressInformationLabelList.add("District");
		adminAddressInformationLabelList.add("County");
		System.out.println("Address Information section contains the fields:::" + adminPropertyInformationLabelList);
	}

	public void adminPropertyFinancialsLabelList() {
		adminPropertyFinancialsLabelList.add("Last Purchase/Sale Price");
		adminPropertyFinancialsLabelList.add("Currency ISO Code");
		adminPropertyFinancialsLabelList.add("Last Purchase/Sale Date");
		System.out.println("Property Financials section contains the fields:::" + adminPropertyFinancialsLabelList);
	}

	public void adminPropertySummaryLabelList() {
		adminPropertySummaryLabelList.add("# of Buildings");
		adminPropertySummaryLabelList.add("# of Floors");
		adminPropertySummaryLabelList.add("Building Status");
		adminPropertySummaryLabelList.add("Local Property Name");
		adminPropertySummaryLabelList.add("Month Built");
		adminPropertySummaryLabelList.add("Year Built");
		adminPropertySummaryLabelList.add("Year Renovated");
		adminPropertySummaryLabelList.add("Occupancy Percent");
		adminPropertySummaryLabelList.add("Construction Type");
		adminPropertySummaryLabelList.add("Location");
		adminPropertySummaryLabelList.add("Owner Occupied");
		adminPropertySummaryLabelList.add("Vacant");
		adminPropertySummaryLabelList.add("Class");
		adminPropertySummaryLabelList.add("Net Rentable Area");
		adminPropertySummaryLabelList.add("Total Size");
		adminPropertySummaryLabelList.add("Units of Measure");
		adminPropertySummaryLabelList.add("Total # of Units");
		adminPropertySummaryLabelList.add("Unit of Comparison");
		adminPropertySummaryLabelList.add("Land Size (Acres)");
		adminPropertySummaryLabelList.add("Tenancy");
		System.out.println("Property Summary section contains the fields:::" + adminPropertySummaryLabelList);
	}

	public void adminPropertyManagementLabelList() {
		adminPropertyManagementLabelList.add("Company");
		adminPropertyManagementLabelList.add("Address");
		adminPropertyManagementLabelList.add("Contact Name");
		adminPropertyManagementLabelList.add("Phone");
		adminPropertyManagementLabelList.add("Email");
		System.out.println("Property Management section contains the fields:::" + adminPropertyManagementLabelList);
	}

	public void adminAssetManagementLabelList() {
		adminAssetManagementLabelList.add("Company");
		adminAssetManagementLabelList.add("Address");
		adminAssetManagementLabelList.add("Contact Name");
		adminAssetManagementLabelList.add("Phone");
		adminAssetManagementLabelList.add("Email");
		System.out.println("Asset Management section contains the fields:::" + adminAssetManagementLabelList);
	}

	public void adminListingMangementLabelList() {
		adminListingMangementLabelList.add("Company");
		adminListingMangementLabelList.add("Address");
		adminListingMangementLabelList.add("Contact Name");
		adminListingMangementLabelList.add("Phone");
		adminListingMangementLabelList.add("Email");
		System.out.println("Asset Management section contains the fields:::" + adminAssetManagementLabelList);
	}

	/**
	 * Validating the Property Header Fields Section
	 *
	 * @author Vishnuvardhan
	 *
	 */

	public void validatePropertyFieldsSection() {
		adminPropertyInformationLabelList();
		List<WebElement> propertyInformationFields = driver.findElements(By.xpath(
				"//h2[text()='Property Information']/parent::div/parent::div/div[contains(@class,'slds-medium-size--1-of-1')]/div/label"));
		sf_UtilityFunctions.validateHeaderSectionFields(adminPropertyInformationLabelList, propertyInformationFields,
				"Property Information Section");

		adminAddressInformationLabelList();
		List<WebElement> AddressInformationFields = driver.findElements(By.xpath(
				"//h2[text()='Address Information']/parent::div/parent::div/div[contains(@class,'slds-medium-size--1-of-1')]/div/label"));
		sf_UtilityFunctions.validateHeaderSectionFields(adminAddressInformationLabelList, AddressInformationFields,
				"Address Information Section");

		adminPropertyFinancialsLabelList();
		List<WebElement> propetyFinancialsFields = driver.findElements(By.xpath(
				"//h2[text()='Property Financials']/parent::div/parent::div/div[contains(@class,'slds-medium-size--1-of-1')]/div/label"));
		sf_UtilityFunctions.validateHeaderSectionFields(adminPropertyFinancialsLabelList, propetyFinancialsFields,
				"Property Financials Section");

		adminPropertySummaryLabelList();
		List<WebElement> propertySummaryFields = driver.findElements(By.xpath(
				"//h2[text()='Property Summary']/parent::div/parent::div/div[contains(@class,'slds-medium-size--1-of-1')]/div/label"));
		sf_UtilityFunctions.validateHeaderSectionFields(adminPropertySummaryLabelList, propertySummaryFields,
				"Property Summary Section");

		adminPropertyManagementLabelList();
		List<WebElement> propertyManagementFields = driver.findElements(By.xpath(
				"//h2[text()='Property Management']/parent::div/parent::div/div[contains(@class,'slds-medium-size--1-of-1')]/div/label"));
		sf_UtilityFunctions.validateHeaderSectionFields(adminPropertyManagementLabelList, propertyManagementFields,
				"Property Mangement Section");

		adminAssetManagementLabelList();
		List<WebElement> assetManagementFields = driver.findElements(By.xpath(
				"//h2[text()='Listing Management']/parent::div/parent::div/div[contains(@class,'slds-medium-size--1-of-1')]/div/label"));
		sf_UtilityFunctions.validateHeaderSectionFields(adminAssetManagementLabelList, assetManagementFields,
				"Asset Management Section");

		adminListingMangementLabelList();
		List<WebElement> listingManagementFields = driver.findElements(By.xpath(
				"//h2[text()='Asset Management']/parent::div/parent::div/div[contains(@class,'slds-medium-size--1-of-1')]/div/label"));
		sf_UtilityFunctions.validateHeaderSectionFields(adminListingMangementLabelList, listingManagementFields,
				"Listing Mangement Section");
	}

	/**
	 * Function for Creating a property
	 *
	 * @author Vishnuvardhan
	 *
	 */

	public void createProperty() {
		Utility_Functions.timeWait(1);
		buildingPropertyName.clear();
		Utility_Functions.xWaitForElementPresent(driver, buildingPropertyName, 3);
		Utility_Functions.xSendKeys(driver, buildingPropertyName, dataTable.getData("General_Data", "Building/ Property Name"));
		Utility_Functions.xScrollWindowOnce(driver);
		Utility_Functions.timeWait(1);
		Utility_Functions.xSelectDropdownByName(countryDropdown, "United States");
		Utility_Functions.timeWait(2);
		Utility_Functions.xWaitForElementPresent(driver, street, 3);
		Utility_Functions.xSendKeys(driver, street, dataTable.getData("General_Data", "Street"));
		Utility_Functions.xWaitForElementPresent(driver, city, 3);
		Utility_Functions.xSendKeys(driver, city, dataTable.getData("General_Data", "City"));
		Utility_Functions.xWaitForElementPresent(driver, stateDropdown, 3);
		Utility_Functions.xSelectDropdownByIndex(stateDropdown, 54);
		Utility_Functions.xWaitForElementPresent(driver, saveProperty, 3);
		Utility_Functions.xClick(driver, saveProperty, true);
		Utility_Functions.timeWait(4);
		driver.switchTo().defaultContent();
		if (createdProperty.getText().contains(dataTable.getData("General_Data", "Street"))) {
			report.updateTestLog("Save Property", "Property has been created successfully :::", Status.PASS);
		} else {
			report.updateTestLog("Save Property", "Unable to save the property:::", Status.FAIL);
		}
	}


	/**
	 * Validating the Campaigns tab present in the drop down after logging in
	 *
	 * @author Vishnuvardhan
	 *
	 */
	public void validateCampaignsTab() {
		sf_UtilityFunctions.oneAppNavigationTab("More");
		if (dataTable.getData("General_Data", "TC_ID").contains("OBAPACBrokerCampaignsTab")) {
			try {
				Utility_Functions.xWaitForElementPresent(driver, campaigns, 2);
			} catch (Exception e) {
				Utility_Functions.xWaitForElementPresent(driver, campaignsEnv, 2);
			}
			try {
				if (campaigns.isDisplayed()) {
					report.updateTestLog("Verify Campaigns Tab", "Campaigns tab is present in the dropdown:::", Status.PASS);
				} else if (campaignsEnv.isDisplayed()) {
					report.updateTestLog("Verify Campaigns Tab", "Campaigns tab is present in the dropdown:::", Status.PASS);
				} else {
					report.updateTestLog("Verify Campaigns Tab", "Campaigns tab doesn't present in the dropdown:::", Status.FAIL);
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else if (dataTable.getData("General_Data", "TC_ID").contains("OBAMERBrokerCampaignsTab")) {
			int count = 0;
			if (dataTable.getData("General_Data", "TC_ID").contains("OBAMERBrokerCampaignsTab")) {
				List<WebElement> overFlowList = driver.findElements(By.xpath("//div[@class='overflowList']//a"));
				for (WebElement element : overFlowList) {
					if (element.getText().equals("Campaigns")) {
						count++;
						System.out.println(element.getText());
					}
				}
				if (count == 0) {
					report.updateTestLog("Verify Campaigns Tab", "Campaigns tab is not present in the dropdown:::", Status.PASS);
				} else {
					report.updateTestLog("Verify Campaigns Tab", "Campaigns tab is present in the dropdown:::", Status.FAIL);
				}
			}
		}

	}

	/**
	 * Validating the Unit of Measure values list
	 *
	 * @author Vishnuvardhan
	 *
	 */

	static List<String> unitOfMeasureValuesList = new ArrayList<String>();

	public void unitOfMeasureFields() {
		if(!dataTable.getData("General_Data", "TC_ID").contains("Admin")) {
			unitOfMeasureValuesList.add("--None--");
			unitOfMeasureValuesList.add("Acres");
			unitOfMeasureValuesList.add("Hectares");
			unitOfMeasureValuesList.add("Square Feet");
			unitOfMeasureValuesList.add("Square Meters");
			unitOfMeasureValuesList.add("Square Yards");
			unitOfMeasureValuesList.add("Tsubo");			
		} 		
		if(dataTable.getData("General_Data", "TC_ID").contains("Admin")) {
			unitOfMeasureValuesList.add("--None--");
			unitOfMeasureValuesList.add("Acres");
			unitOfMeasureValuesList.add("Hectares");
			unitOfMeasureValuesList.add("Square Feet");
			unitOfMeasureValuesList.add("Square Meters");
			unitOfMeasureValuesList.add("Square Yards");
			unitOfMeasureValuesList.add("Tsubo");	
			unitOfMeasureValuesList.add("None");
			unitOfMeasureValuesList.add("Parking Lots");
			unitOfMeasureValuesList.add("People");
			unitOfMeasureValuesList.add("Ping");
			unitOfMeasureValuesList.add("Pyeong");	
		}		
		System.out.println("Unit of Measure values are " + unitOfMeasureValuesList);
	}

	public void verifyUnitsOfMeasurePickListValues() {
		unitOfMeasureFields();
		List<String> unitsOfMeasurePickListValues = establishConnection.establishMetaDataConnection("Property__c", "AMER_Property", "Units_of_Measure__c");
		List<String> unitsOfMeasureList = new ArrayList<String>();
		unitsOfMeasureList = Utility_Functions.xValidatePickListValuesPage(unitsOfMeasurePickListValues, unitOfMeasureValuesList, "Units of Measure pick list values");
		if (unitsOfMeasureList.size()!=0) {
			report.updateTestLog("Verify Units of Measure Picklist values", "All the values are not present in the Use Type Pick List:::" + unitsOfMeasureList, Status.FAIL);
		} else {
			report.updateTestLog("Verify Units of Measure Picklist values", "All the values are present in the Use Type Pick List ", Status.PASS);
		}
	}
	
	/**
	 * Validating the activity Lightning Time line fields
	 *
	 * @author Vishnuvardhan
	 *
	 */

	public void propertiesActivityLightningTimeline() {
		selectProperty();
		TasksPage activityPage = new TasksPage(scriptHelper);
		activityPage.validateActivityTimeLine();
	}

	/**
	 * Validating the Properties Private Tag functionality
	 *
	 * @author Vishnuvardhan
	 *
	 */

	public void propertiesPrivateTagFunctionality() {
		navigateProperties();
		sf_UtilityFunctions.selectAction("New");
		Utility_Functions.xSwitchtoFrame(driver, propertyInformationFrame);
		Utility_Functions.timeWait(2);
		Utility_Functions.xWaitForElementPresent(driver, buildingPropertyName, 3);
		Utility_Functions.xClick(driver, buildingPropertyName, true);
		createProperty();		
		driver.navigate().refresh();
		Utility_Functions.timeWait(4);
		Utility_Functions.xSwitchtoFrame(driver, addTag);
		Utility_Functions.xWaitForElementPresent(driver, addTag, 3);
		Utility_Functions.xClick(driver, addTag, true);
		Utility_Functions.xWaitForElementPresent(driver, privatetag, 3);
		Utility_Functions.xSendKeys(driver, privatetag, "Test Automation");
		Utility_Functions.xWaitForElementPresent(driver, savePrivateTag, 3);
		Utility_Functions.xClick(driver, savePrivateTag, true);
		if (savePrivateTag.isDisplayed()) {
			report.updateTestLog("Verify Private Tag", "Private Tag is saved successfully:::", Status.PASS);
		} else {
			report.updateTestLog("Verify Private Tag", "Private Tag save functionality failed:::", Status.FAIL);
		}
	}

	

	/**
	 * Validating the New Property Page Property Type field
	 *
	 * @author Vishnuvardhan
	 *
	 */

	static ArrayList<String> newPropertyTypeList = new ArrayList<String>();

	public void newPropertyTypeFields() {
		if(dataTable.getData("General_Data", "TC_ID").contains("AMER")) {
			newPropertyTypeList.add("Agribusiness");
			newPropertyTypeList.add("Health Care");
			newPropertyTypeList.add("Hotel");
			newPropertyTypeList.add("Industrial");
			newPropertyTypeList.add("Land");
			newPropertyTypeList.add("Office");
			newPropertyTypeList.add("Residential");
			newPropertyTypeList.add("Retail");
			newPropertyTypeList.add("Specialty");
		} else if(dataTable.getData("General_Data", "TC_ID").contains("APAC")) {
			newPropertyTypeList.add("Hotel");
			newPropertyTypeList.add("Land");
			newPropertyTypeList.add("Mixed-use");
			newPropertyTypeList.add("Multi-use Portfolio");
			newPropertyTypeList.add("Multifamily");
			newPropertyTypeList.add("Office");
			newPropertyTypeList.add("Residential");
			newPropertyTypeList.add("Retail"); 
			newPropertyTypeList.add("Industrial/Logistics");
		}
		
		System.out.println("New Property Page Property Type fields are " + newPropertyTypeList);
	}

	public void newPropertiesPropertyType() {
		newPropertyTypeFields();
		List<String> propertyTypePickListValues = null;
		if(dataTable.getData("General_Data", "TC_ID").contains("AMER")) {
			propertyTypePickListValues = sf_UtilityFunctions.getPickListValues("Property__c", "AMER_Property", "Property_Type__c");
		} else if(dataTable.getData("General_Data", "TC_ID").contains("APAC")) {
			propertyTypePickListValues = sf_UtilityFunctions.getPickListValues("Property__c", "APAC_Property", "Property_Type__c");
		}
		List<String> propertyTypeList = new ArrayList<String>();
		propertyTypeList = Utility_Functions.xValidatePickListValuesPage(propertyTypePickListValues, newPropertyTypeList, "Property Type pick list values");
		if (propertyTypeList.size()!=0) {
			report.updateTestLog("Verify Property Type picklist values", "All the values are not present in the Property Type Pick List:::" + propertyTypeList, Status.FAIL);
		} else {
			report.updateTestLog("Verify Property Type picklist values", "All the values are present in the Property Type Pick List ", Status.PASS);
		}		
	}

	/**
	 * Validating the Property Type field value
	 *
	 * @author Vishnuvardhan
	 *
	 */

	public void verifyPropertyTypeFieldValue() {
		navigateNewPropertyPage();
		Utility_Functions.xWaitForElementPresent(driver, propertyName, 2);
		Utility_Functions.xSendKeys(driver, propertyName, "Test Automation Subject_" + Utility_Functions.xGenerateAlphaNumericString());
		Utility_Functions.timeWait(3);
		Utility_Functions.xScrollWindow(driver);
		Utility_Functions.timeWait(1);
		Utility_Functions.xScrollWindowTop(driver);
		Utility_Functions.timeWait(2);
		Utility_Functions.xWaitForElementPresent(driver, propertyCountry, 3);
		Utility_Functions.xClick(driver, propertyCountry, true);
		Utility_Functions.xWaitForElementPresent(driver, selectPropertyCountry, 3);
		Utility_Functions.xClick(driver, selectPropertyCountry, true);
		Utility_Functions.xWaitForElementPresent(driver, propertyStreet, 3);
		Utility_Functions.xSendKeys(driver, propertyStreet, dataTable.getData("General_Data", "Street"));
		Utility_Functions.xWaitForElementPresent(driver, propertyCity, 3);
		Utility_Functions.xSendKeys(driver, propertyCity, dataTable.getData("General_Data", "City"));
		Utility_Functions.xWaitForElementPresent(driver, statePickList, 3);
		Utility_Functions.xClick(driver, statePickList, true);
		Utility_Functions.xWaitForElementPresent(driver, selectPropertyState, 3);
		Utility_Functions.xClick(driver, selectPropertyState, true);
		Utility_Functions.timeWait(2);
		WebElement elementHidden = driver.findElement(By.xpath("//select[contains(@id,'propertyEditForm:APACPropertyType')]/parent::div"));
		Utility_Functions.xClick(driver, elementHidden, true);
		WebElement elementSelectHidden = driver.findElement(By.xpath("//select[contains(@id,'propertyEditForm:APACPropertyType')]/parent::div/select"));
		Utility_Functions.xClick(driver, elementSelectHidden, true);
		for (int i = 1; i <= newPropertyTypeList.size(); i++) {
			String optionValue = driver.findElement(By.xpath("//select[contains(@id,'propertyEditForm:APACPropertyType')]/option[" + i + "]")).getAttribute("value");
			if (optionValue.equals("Industrial")) {
				driver.findElement(By.xpath("//select[contains(@id,'propertyEditForm:APACPropertyType')]/option[" + "'"	+ optionValue + "'" + "]")).click();
				break;
			}
		}
		Utility_Functions.xWaitForElementPresent(driver, addValuetoCheckList, 2);
		Utility_Functions.xClick(driver, addValuetoCheckList, true);
		Utility_Functions.xWaitForElementPresent(driver, buildingClass, 3);
		Utility_Functions.xClick(driver, buildingClass, true);
		Utility_Functions.xWaitForElementPresent(driver, buildingClassValue, 3);
		Utility_Functions.xClick(driver, buildingClassValue, true);
		Utility_Functions.xWaitForElementPresent(driver, saveProperty, 3);
		Utility_Functions.xClick(driver, saveProperty, true);
		Utility_Functions.timeWait(2);
		if (details.isDisplayed()) {
			report.updateTestLog("Verify Editing the Existing Account", "The existing account can be edited and saved successfully", Status.PASS);
		} else {
			report.updateTestLog("Verify Editing the Existing Account", "The existing account cannot be edited and saved successfully", Status.FAIL);
		}
	}

	

	/**
	 * Validating the Properties Preferences Pyeong Value
	 *
	 * @author Vishnuvardhan
	 *
	 */
	
	public void verifyPropertiesPreferencesPyeongValue() {
		sf_UtilityFunctions.verifyPickListValues("Pyeong", "Property_Preferences__c", "France_Property_Preferences", "APAC_Area_UOM__c");
	}

	/**
	 * Validating the Properties Preferences Ping Value
	 *
	 * @author Vishnuvardhan
	 *
	 */
	public void verifyPropertiesPreferencesPingValue() {
		sf_UtilityFunctions.verifyPickListValues("Ping", "Property_Preferences__c", "France_Property_Preferences", "APAC_Area_UOM__c");
	}
	
	/**
	 * Validating the Project Enquiries for the Pyeong Value
	 *
	 * @author Vishnuvardhan
	 *
	 */
	public void verifyProjectEnquiriesPyeongValue() {
		sf_UtilityFunctions.verifyPickListValues("Pyeong", "APAC_Project_Enquiries__c", "APAC_Project_Enquiry", "APAC_Total_Area_UOM__c");
	}

	
	/**
	 * Validating the Project Enquiries for the Ping Value
	 *
	 * @author Vishnuvardhan
	 *
	 */
	public void verifyProjectEnquiriesPingValue() {
		sf_UtilityFunctions.verifyPickListValues("Ping", "APAC_Project_Enquiries__c", "APAC_Project_Enquiry", "APAC_Total_Area_UOM__c");
	}	
	
	/**
	 * Validating the Properties Pyeong Value
	 *
	 * @author Vishnuvardhan
	 *
	 */
	public void verifyPropertiesPyeongValue() {
		sf_UtilityFunctions.verifyPickListValues("Pyeong", "Property__c", "APAC_Property", "Units_of_Measure__c");
	}

	/**
	 * Validating the Properties Ping Value
	 *
	 * @author Vishnuvardhan
	 *
	 */
	public void verifyPropertiesPingValue() {
		sf_UtilityFunctions.verifyPickListValues("Ping", "Property__c", "APAC_Property", "Units_of_Measure__c");			
	}

	/**
	 * Validating the Properties Preferences for the Preference Type values
	 *
	 * @author Vishnuvardhan
	 *
	 */
	static ArrayList<String> preferenceTypePickList = new ArrayList<String>();

	public void preferenceType() {
		preferenceTypePickList.add("--None--");
		preferenceTypePickList.add("Sale");
		preferenceTypePickList.add("Lease");
		System.out.println("Preference Type Pick List values are " + preferenceTypePickList);
	}

	public void verifyPreferenceTypevalues() {
		preferenceType();
		List<String> preferenceTypePickListValues = sf_UtilityFunctions.getPickListValues("Property_Preferences__c", "France_Property_Preferences", "APAC_Preference_Type__c");
		List<String> preferenceTypeList = new ArrayList<String>();
		preferenceTypeList = Utility_Functions.xValidatePickListValuesPage(preferenceTypePickListValues, preferenceTypePickList, "Preferecne Type pick list values");
		if (preferenceTypeList.size()!=0) {
			report.updateTestLog("Verify Prference Type picklist values", "All the values are not present in the Prference Type Pick List:::" + preferenceTypeList, Status.FAIL);
		} else {
			report.updateTestLog("Verify Prference Type picklist values", "All the values are present in the Prference Type Pick List ", Status.PASS);
		}	
	}

	/**
	 * Validating the Project Enquiry page fields
	 *
	 * @author Vishnuvardhan
	 *
	 */
	static ArrayList<String> projectEnquiriesFieldsList = new ArrayList<String>();

	public void projectEnquiriesFields() {
		projectEnquiriesFieldsList.add("Project Enquiry Name");
		projectEnquiriesFieldsList.add("Enquiry Account");
		projectEnquiriesFieldsList.add("Enquiry Contact");
		projectEnquiriesFieldsList.add("Enquiry Primary Campaign");
		projectEnquiriesFieldsList.add("Confidential");
		projectEnquiriesFieldsList.add("Rating");
		projectEnquiriesFieldsList.add("Status");
		projectEnquiriesFieldsList.add("Client Feedback");
		projectEnquiriesFieldsList.add("Owner ID");
		projectEnquiriesFieldsList.add("Source");
		projectEnquiriesFieldsList.add("Information Memorandum Sent Date");
		projectEnquiriesFieldsList.add("Inspection Date");
		projectEnquiriesFieldsList.add("Confidentiality Agreement Executed Date");
		projectEnquiriesFieldsList.add("Due Diligence Start Date");
		projectEnquiriesFieldsList.add("Data Room Access Date");
		projectEnquiriesFieldsList.add("Broker Feedback");
		projectEnquiriesFieldsList.add("Enquiry Opportunity");
		projectEnquiriesFieldsList.add("Record Type ID");
		System.out.println("Project Enquiries fields are " + projectEnquiriesFieldsList);
	}

		
	public void verifyProjectEnquiriesPageFields() {
		projectEnquiriesFields();
		List<String> propertySalesProjectEnquiries = establishConnection.establishMetaDataConnectionPageLayouts("Property_Preferences__c", "APAC Property Preferences Layout");
		//List<String> propertySalesProjectEnquiries = establishConnection.establishMetaDataConnectionPageLayouts("APAC_Project_Enquiries__c", "APAC Property Sales Project Enquiry Layout");
		List<String> propertySalesProjectEnquiriesList = new ArrayList<String>();
		propertySalesProjectEnquiriesList = Utility_Functions.xValidatePickListValuesPage(propertySalesProjectEnquiries, projectEnquiriesFieldsList, "Project Enquiries field values");
		if (propertySalesProjectEnquiriesList.size()!=0) {
			report.updateTestLog("Verify Project Enquiries Page Field Labels", "All the labels are not present in the Enquiries Page Field Labels:::" + propertySalesProjectEnquiriesList, Status.FAIL);
		} else {
			report.updateTestLog("Verify Project Enquiries Page Field Labels", "All the labels are present in the Enquiries Page Field Labels", Status.PASS);
		}	
	}

	
	
			
	/**
	 * Validating the Project Enquiries Enhancements
	 *
	 * @author Vishnuvardhan
	 *
	 */

	public void verifyProjectEnquiriesEnhancements() {
		verifyProjectEnquiriesPageFields();
	}	
}
