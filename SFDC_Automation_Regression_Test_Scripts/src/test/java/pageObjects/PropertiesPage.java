package pageObjects;

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

import pagesAPI.SearchTextSOQL;
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
		// new WebDriverUtil(driver);
		// Utility_Functions utility = new Utility_Functions(scriptHelper);
	}

	@FindBy(xpath = "//button[contains(@class,'context-bar__label-action')][text()='More']")
	WebElement menu_More;

	@FindBy(xpath = "//a[@role='menuitem']/span[contains(@class,'slds-truncate')][text()='Properties']")
	WebElement properties;	

	@FindBy(xpath = "//div[@class='slds-truncate'][@title='New']")
	WebElement newProperty;	

	@FindBy(xpath = "//*[@id='bottomButtonRow']/input[1]")
	WebElement continueButton;	

	@FindBy(xpath = "//div[@class='slds-media']//input[@value='Save Property']")
	WebElement saveProperty;	

	@FindBy(xpath = "//div[@class='slds-col--padded slds-size--1-of-1 slds-medium-size--1-of-1 slds-large-size--1-of-2']/div/label[@for='property-name']/parent::div//div/input")
	WebElement buildingPropertyName;	

	@FindBy(xpath = "//*[contains(@id,'propertyEditForm:countryPicklist']/option")
	WebElement countrySelect;	

	@FindBy(xpath = "//*[contains(@id,'propertyEditForm:countryPicklist')]")
	WebElement countryDropdown;	

	@FindBy(xpath = "//*[contains(@id,'propertyEditForm:statePicklist')]")
	WebElement stateDropdown;	

	@FindBy(xpath = "//*[contains(@id,'propertyEditForm:statePicklist)']/option")
	WebElement stateSelect;	

	@FindBy(xpath = "//*[contains(@id,'propertyEditForm:City')]")
	WebElement city;	

	@FindBy(xpath = "//*[contains(@id,'propertyEditForm:Street')]")
	WebElement street;	

	@FindBy(xpath = "//h1[@class='slds-page-header__title slds-m-right--small slds-truncate slds-align-middle']/span")
	WebElement createdProperty;

	@FindBy(xpath = "//h2[contains(@class,'slds-m-bottom--large')][text()='Property Information']")
	WebElement propertyInformationFrame;

	@FindBy(xpath="//*[@id='assignedToBox']")
	WebElement assignedTo;

	@FindBy(xpath="//*[@id='relatedAccountBox']")
	WebElement accountSelected;

	@FindBy(xpath="//select[@class='slds-select']/option[@value='Normal']")
	WebElement priority;

	@FindBy(xpath="//div[@class='slds-form-element__control slds-has-divider--bottom']")
	WebElement owner;

	@FindBy(xpath="//select[@class='slds-select']/option[@value='Open']")
	WebElement status;


	/**
	 * 
	 * 
	 * @author Ramya
	 *
	 */	

	@FindBy(xpath = "//h1//span[text()='Recently Viewed']")
	WebElement recentlyViewed;

	@FindBy(xpath="//span[contains(@class,'virtualAutocompleteOptionText')][text()='All Properties']")
	WebElement allProperties;

	@FindBy(xpath = "//a[@class='tabHeader']//span[text()='Related']")
	WebElement related;

	@FindBy(xpath="//span[contains(@class,'slds-truncate')][text()='Properties']")
	WebElement menu_Properties;

	@FindBy(xpath="//article[contains(@class,'Activities')]//div[text()='New Activity']")
	WebElement newActivity;

	@FindBy(xpath="//input[@class='slds-input'][@type='text']")
	WebElement subject;

	@FindBy(xpath="//select[@class='slds-select']/option[@value='Private - Client Intelligence']")
	WebElement activityType;

	@FindBy(xpath="// input [@value= 'Save & New']")
	WebElement saveAndNewActivity;

	@FindBy(xpath="//select[@class='slds-select']/option[@value='Private - Initial Meeting']")
	WebElement activityType2;

	@FindBy(xpath="// input [@value= 'Save']")
	WebElement saveActivity;

	@FindBy(xpath="//span[contains(@class, 'slds-text-heading--small slds-truncate') and text() = 'Activities']")
	WebElement relatedActivities;


	@FindBy(xpath="//a[@title='Show more actions for this record']")
	WebElement selectCreateFollowUpCustomActivity;

	@FindBy(xpath="//div[contains(@title, 'Create Follow-up Custom Activity')]")
	WebElement createCustomActivity;

	@FindBy(xpath="//select[@class='slds-select']/option[@value='Private - Follow-Up Meeting']")
	WebElement activityType3;


	/**
	 * Validating the Customer Property Page fields 
	 * 
	 * @author Vishnuvardhan
	 *
	 */	

	public void validateCustomPropertyPage() {
		try {
			Utility_Functions.xClick(driver, menu_More, true);
			Utility_Functions.timeWait(2);
			Utility_Functions.xClick(driver, properties, true);
			Utility_Functions.timeWait(4);
			Utility_Functions.xClick(driver, newProperty, true);
			Utility_Functions.timeWait(2);
			driver.switchTo().frame(driver.findElement(By.xpath("//iframe[contains(@title,'New Property: Select Property Record Type ~ Salesforce - Enterprise Edition')]")));
			Utility_Functions.timeWait(1);
			Utility_Functions.xClick(driver, continueButton, true);
			Utility_Functions.timeWait(2);
			driver.switchTo().defaultContent();
			Utility_Functions.xSwitchtoFrame(driver, propertyInformationFrame);

			//driver.switchTo().frame(driver.findElement(By.xpath("//iframe[contains(@src,'recordtypeselect')]")));
			List<WebElement> propertyEditPage = driver.findElements(By.xpath("//div[@class='slds-grid slds-wrap slds-grid slds-wrap slds-grid--pull-padded slds-form--stacked']/div/h2"));
			int count=0; 
			for(WebElement element: propertyEditPage) {
				if((count==0) && (element.getText().contains("Property Information"))) {
					System.out.println("Propety page contains the section - Property Information");
					report.updateTestLog("Property Information page", "Propety page contains the section - " + element.getText(),Status.PASS);	
					count++;						
				} else if((count==1) && (element.getText().contains("Address Information"))) {
					System.out.println("Propety page contains the section - Address Information");
					report.updateTestLog("Property Information page", "Propety page contains the section - " + element.getText(),Status.PASS);	
					count++;						
				} else if((count==2) && (element.getText().contains("Property Financials"))) {
					System.out.println("Propety page contains the section - Property Financials");
					report.updateTestLog("Property Information page", "Propety page contains the section - " + element.getText(),Status.PASS);	
					count++;											
				} else if((count==3) && (element.getText().contains("Property Summary"))) {
					System.out.println("Propety page contains the section - Property Summary");
					report.updateTestLog("Property Information page", "Propety page contains the section - " + element.getText(),Status.PASS);	
					count++;	
				} else if((count==4) && (element.getText().contains("Property Management"))) {
					System.out.println("Propety page contains the section - Property Management");
					report.updateTestLog("Property Information page", "Propety page contains the section - " + element.getText(),Status.PASS);	
					count++;	
				} else if((count==5) && (element.getText().contains("Asset Management"))) {
					System.out.println("Propety page contains the section - Asset Management");
					report.updateTestLog("Property Information page", "Propety page contains the section - " + element.getText(),Status.PASS);	
					count++;	
				} else if((count==6) && (element.getText().contains("Listing Management"))) {
					System.out.println("Propety page contains the section - Listing Management");
					report.updateTestLog("Property Information page", "Propety page contains the section - " + element.getText(),Status.PASS);	
					count++;		
				}
			}	
			if(count!=7) 
				report.updateTestLog("Property Information page", "Property Information page is not having all the fields::",Status.FAIL);			
			validateFieldsSection();
			validateFieldsSubSections();
			createProperty();
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
		}

	}


	/**
	 * Validating the Customer Property Page fields 
	 * 
	 * @author Vishnuvardhan
	 *
	 */	

	public void validateFieldsSection() {
		List<WebElement> propertyPageLabels = driver.findElements(By.xpath("//div[@class='slds-col--padded slds-size--1-of-1 slds-medium-size--1-of-1 slds-large-size--1-of-2']/div/label"));
		int count =0;
		for(WebElement element: propertyPageLabels) {
			//System.out.println("Property Information Section field lables::");
			if(element.getText().contains("Building/Property Name")) {
				report.updateTestLog("Property Information page", "Property Information page has the field" + element.getText()+ ":::" , Status.PASS);
				count++;		
			} else if(element.getText().contains("Property Website")) {
				report.updateTestLog("Property Information page", "Property Information page has the field" + element.getText()+ ":::" , Status.PASS);
				count++;		
			} else if(element.getText().contains("Country")) {
				report.updateTestLog("Property Information page", "Property Information page has the field" + element.getText()+ ":::" , Status.PASS);
				count++;		
			} else if(element.getText().contains("Street")) {
				report.updateTestLog("Property Information page", "Property Information page has the field" + element.getText()+ ":::" , Status.PASS);
				count++;		
			} else if(element.getText().contains("City")) {
				report.updateTestLog("Property Information page", "Property Information page has the field" + element.getText()+ ":::" , Status.PASS);
				count++;		
			} else if(element.getText().contains("State/ Province")) {
				report.updateTestLog("Property Information page", "Property Information page has the field" + element.getText()+ ":::" , Status.PASS);
				count++;		
			} else if(element.getText().contains("Zip/ Postal Code")) {
				report.updateTestLog("Property Information page", "Property Information page has the field" + element.getText()+ ":::" , Status.PASS);
				count++;		
			} else if(element.getText().contains("Region")) {
				report.updateTestLog("Property Information page", "Property Information page has the field" + element.getText()+ ":::" , Status.PASS);
				count++;		
			} else if(element.getText().contains("Market")) {
				report.updateTestLog("Property Information page", "Property Information page has the field" + element.getText()+ ":::" , Status.PASS);
				count++;		
			} else if(element.getText().contains("Sub Market")) {
				report.updateTestLog("Property Information page", "Property Information page has the field" + element.getText()+ ":::" , Status.PASS);
				count++;		
			} else if(element.getText().contains("District")) {
				report.updateTestLog("Property Information page", "Property Information page has the field" + element.getText()+ ":::" , Status.PASS);
				count++;		
			} else if(element.getText().contains("Country")) {
				report.updateTestLog("Property Information page", "Property Information page has the field" + element.getText()+ ":::" , Status.PASS);
				count++;		
			} else if(element.getText().contains("Last Purchase/Sale Price")) {
				report.updateTestLog("Property Information page", "Property Information page has the field" + element.getText()+ ":::" , Status.PASS);
				count++;		
			} else if(element.getText().contains("*Currency ISO Code")) {
				report.updateTestLog("Property Information page", "Property Information page has the field" + element.getText()+ ":::" , Status.PASS);
				count++;		
			} else if(element.getText().contains("Last Purchase/Sale Date")) {
				report.updateTestLog("Property Information page", "Property Information page has the field" + element.getText()+ ":::" , Status.PASS);
				count++;		
			} else if(element.getText().contains("Property Type")) {
				report.updateTestLog("Property Information page", "Property Information page has the field" + element.getText()+ ":::" , Status.PASS);
				count++;		
			} else if(element.getText().contains("Property Sub-Type")) {
				report.updateTestLog("Property Information page", "Property Information page has the field" + element.getText()+ ":::" , Status.PASS);
				count++;		
			} else if(element.getText().contains("Construction Type")) {
				report.updateTestLog("Property Information page", "Property Information page has the field" + element.getText()+ ":::" , Status.PASS);
				count++;		
			} else if(element.getText().contains("Location")) {
				report.updateTestLog("Property Information page", "Property Information page has the field" + element.getText()+ ":::" , Status.PASS);	
				count++;		
			} else if(element.getText().contains("Class")) {
				report.updateTestLog("Property Information page", "Property Information page has the field" + element.getText()+ ":::" , Status.PASS);
				count++;		
			} else if(element.getText().contains("Net Rentable Area")) {
				report.updateTestLog("Property Information page", "Property Information page has the field" + element.getText()+ ":::" , Status.PASS);
				count++;		
			} else if(element.getText().contains("Total Size")) {
				report.updateTestLog("Property Information page", "Property Information page has the field" + element.getText()+ ":::" , Status.PASS);
				count++;		
			} else if(element.getText().contains("Unit of Measure")) {
				report.updateTestLog("Property Information page", "Property Information page has the field" + element.getText()+ ":::" , Status.PASS);
				count++;		
			} else if(element.getText().contains("Total # of Units")) {
				report.updateTestLog("Property Information page", "Property Information page has the field" + element.getText()+ ":::" , Status.PASS);
				count++;		
			} else if(element.getText().contains("Unit of Comparison")) {
				report.updateTestLog("Property Information page", "Property Information page has the field" + element.getText()+ ":::" , Status.PASS);
				count++;		
			} else if(element.getText().contains("Land Size(Acres)")) {
				report.updateTestLog("Property Information page", "Property Information page has the field" + element.getText()+ ":::" , Status.PASS);
				count++;		
			} else if(element.getText().contains("Tenancy")) {
				report.updateTestLog("Property Information page", "Property Information page has the field" + element.getText()+ ":::" , Status.PASS);
				count++;		
			} else if(element.getText().contains("# of Buildings")) {
				report.updateTestLog("Property Information page", "Property Information page has the field" + element.getText()+ ":::" , Status.PASS);
				count++;		
			} else if(element.getText().contains("# of Floors")) {
				report.updateTestLog("Property Information page", "Property Information page has the field" + element.getText()+ ":::" , Status.PASS);
				count++;		
			} else if(element.getText().contains("Building Status")) {
				report.updateTestLog("Property Information page", "Property Information page has the field" + element.getText()+ ":::" , Status.PASS);
				count++;		
			} else if(element.getText().contains("Month Built")) {
				report.updateTestLog("Property Information page", "Property Information page has the field" + element.getText()+ ":::" , Status.PASS);
				count++;		
			} else if(element.getText().contains("Year Built")) {
				report.updateTestLog("Property Information page", "Property Information page has the field" + element.getText()+ ":::" , Status.PASS);
				count++;		
			} else if(element.getText().contains("Year Renovated")) {
				report.updateTestLog("Property Information page", "Property Information page has the field" + element.getText()+ ":::" , Status.PASS);
				count++;		
			} else if(element.getText().contains("Occupancy Percent")) {
				report.updateTestLog("Property Information page", "Property Information page has the field" + element.getText()+ ":::" , Status.PASS);
				count++;		
			} else if(element.getText().contains("Owner Occupied")) {
				report.updateTestLog("Property Information page", "Property Information page has the field" + element.getText()+ ":::" , Status.PASS);
				count++;
			} else if(element.getText().contains("Vacant")) {
				report.updateTestLog("Property Information page", "Property Information page has the field" + element.getText()+ ":::" , Status.PASS);
			} /*else if(element.getText().contains("Company")) {
				report.updateTestLog("Property Information page", "Property Information page has the field" + element.getText()+ ":::" , Status.PASS);	
			} else if(element.getText().contains("Address")) {
				report.updateTestLog("Property Information page", "Property Information page has the field" + element.getText()+ ":::" , Status.PASS);	
			} else if(element.getText().contains("Contact Name")) {
				report.updateTestLog("Property Information page", "Property Information page has the field" + element.getText()+ ":::" , Status.PASS);	
			} else if(element.getText().contains("Phon")) {
				report.updateTestLog("Property Information page", "Property Information page has the field" + element.getText()+ ":::" , Status.PASS);	
			} else if(element.getText().contains("Email")) {
				report.updateTestLog("Property Information page", "Property Information page has the field" + element.getText()+ ":::" , Status.PASS);	
			} */			
		}
		System.out.println(count);
		if(count!=28) 
			report.updateTestLog("Property Information page", "Property Information page is not having all the fields:::" , Status.FAIL);	
	}


	/**
	 * Validating the Customer Property Page fields sub sections 
	 * 
	 * @author Vishnuvardhan
	 *
	 */	

	public void validateFieldsSubSections() {
		List<WebElement> propertyPageSections = driver.findElements(By.xpath("//div[@class='slds-col--padded slds-size--1-of-1 slds-medium-size--1-of-1 slds-large-size--1-of-2']/div/label/parent::div/parent::div/parent::div/div/h2"));
		int count =0;
		for(WebElement element: propertyPageSections) {
			if((element.getText().equals("Property Management")) || (element.getText().equals("Listing Management")) || (element.getText().equals("Asset Management"))) {
				List<WebElement> propertyPageLabels = driver.findElements(By.xpath("//div[@class='slds-col--padded slds-size--1-of-1 slds-medium-size--1-of-1 slds-large-size--1-of-2']/div/label"));
				for(WebElement element1: propertyPageLabels) {
					if(element.getText().contains("Company")) {
						report.updateTestLog(element.getText() + " Section", "Property Management Section has the field" + element1.getText()+ ":::" , Status.PASS);
						count++;		
					} else if(element1.getText().contains("Address")) {
						report.updateTestLog(element.getText() + " Section", "Property Management Section has the field" + element1.getText()+ ":::" , Status.PASS);
						count++;		
					} else if(element1.getText().contains("ContactName")) {
						report.updateTestLog(element.getText() + " Section", "Property Management Section has the field" + element1.getText()+ ":::" , Status.PASS);
						count++;		
					} else if(element1.getText().contains("Phone")) {
						report.updateTestLog(element.getText() + " Section", "Property Management Section has the field" + element1.getText()+ ":::" , Status.PASS);
						count++;		
					} else if(element1.getText().contains("Email")) {
						report.updateTestLog(element.getText() + " Section", "Property Management Section has the field" + element1.getText()+ ":::" , Status.PASS);
					} 
				}
			}
		} 
		if(count!=18) 
			report.updateTestLog("Property, Asset and Listing Management Sections", "Sections doesn't have all the fields", Status.FAIL);

	}


	/**
	 * Function for Creating a property
	 * 
	 * @author Vishnuvardhan
	 *
	 */	

	public void createProperty() {
		Utility_Functions.timeWait(1);
		try {
			Utility_Functions.timeWait(1);
			buildingPropertyName.clear();
			Utility_Functions.timeWait(1);
			Utility_Functions.xSendKeys(driver, buildingPropertyName, dataTable.getData("General_Data", "Building/ Property Name"));
			Utility_Functions.timeWait(1);
			Utility_Functions.xScrollWindowOnce(driver);
			Utility_Functions.timeWait(1);
			//Utility_Functions.xClick(driver, countryDropdown, true);
			Utility_Functions.xSelectDropdownByIndex(countryDropdown, 229);
			Utility_Functions.timeWait(1);
			Utility_Functions.xSendKeys(driver, street, dataTable.getData("General_Data", "Street"));
			Utility_Functions.timeWait(1);
			Utility_Functions.xSendKeys(driver, city, dataTable.getData("General_Data", "City"));
			Utility_Functions.timeWait(1);
			//Utility_Functions.xClick(driver, stateDropdown, true);
			Utility_Functions.xSelectDropdownByIndex(stateDropdown, 54);
			Utility_Functions.timeWait(1);
			Utility_Functions.xClick(driver, saveProperty, true);
			Utility_Functions.timeWait(4);
			driver.switchTo().defaultContent();
			if(createdProperty.getText().contains(dataTable.getData("General_Data", "Street"))) {
				report.updateTestLog("Save Property", "Property has been created successfully :::" , Status.PASS);
			} else {
				report.updateTestLog("Save Property", "Unable to save the property:::" , Status.FAIL);
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
		}
	}
	/**
	 * Validating the Creation of Activity in the Properties
	 * 
	 * @author Ramya
	 *
	 */	
	public void verifyCreationOfActivity() {
		try{
			Utility_Functions.xWaitForElementPresent(driver,menu_Properties, 3);
			Utility_Functions.xClick(driver, menu_Properties, true);
		}catch(Exception e){
			Utility_Functions.xWaitForElementPresent(driver, menu_More, 3);
			Utility_Functions.xClick(driver, menu_More, true);
			Utility_Functions.xWaitForElementPresent(driver, properties, 2);
			Utility_Functions.xClick(driver, properties, true);	
		}
		report.updateTestLog("Verify Create Activity Properties ","Properties is Displayed ",  Status.PASS);
		Utility_Functions.xWaitForElementPresent(driver, recentlyViewed, 3);
		Utility_Functions.xClick(driver, recentlyViewed, true);
		report.updateTestLog("Verify Create Activity Properties ","Recently viewed Properties are Displayed ",  Status.PASS);
		Utility_Functions.xWaitForElementPresent(driver, allProperties, 3);
		Utility_Functions.xClick(driver, allProperties, true);
		Utility_Functions.timeWait(3);
		report.updateTestLog("Verify Create Activity Properties ","All Properties are Displayed ",  Status.PASS);

		List<WebElement> propertiesList = driver.findElements(By.xpath(".//a[@class='slds-truncate outputLookupLink slds-truncate forceOutputLookup']"));

		Utility_Functions.xclickOnFirstElementfromList(propertiesList);	
		Utility_Functions.timeWait(3);
		report.updateTestLog("Verify Create Activity Properties ","The property is Displayed ",  Status.PASS);
		Utility_Functions.xWaitForElementPresent(driver, related, 3);
		Utility_Functions.xClick(driver, related, true);
		report.updateTestLog("Verify Create Activity Properties ","The related page is Displayed ",  Status.PASS);
		Utility_Functions.xScrollWindow(driver);
		Utility_Functions.timeWait(1);
		Utility_Functions.xScrollWindowTop(driver);
		Utility_Functions.timeWait(2);
		Utility_Functions.xWaitForElementPresent(driver, newActivity, 3);
		Utility_Functions.xClick(driver, newActivity, true);
		report.updateTestLog("Verify Create Activity Properties ","The New Activity in the related page is Displayed ",  Status.PASS);
		/*int size = driver.findElements(By.tagName("iframe")).size();
		System.out.println(size);
		Utility_Functions.timeWait(2);
		List<WebElement> iframeList = driver.findElements(By.tagName("iframe"));
		System.out.println(iframeList.size());
		for (WebElement element : iframeList) {
			System.out.println(element.getAttribute("id"));
		}
		driver.switchTo().frame(2);
		Utility_Functions.timeWait(5);
		System.out.println("Frame Identified");*/
		Utility_Functions.xSwitchtoFrame(driver, subject);
		Utility_Functions.xWaitForElementPresent(driver, subject, 5);

		Utility_Functions.xClick(driver, subject, true);
		Utility_Functions.timeWait(3);
		Utility_Functions.xSendKeys(driver, subject, "test1");
		Utility_Functions.timeWait(3);
		Utility_Functions.xClick(driver, activityType, true);
		Utility_Functions.timeWait(3);
		Utility_Functions.xClick(driver, saveAndNewActivity, true);
		Utility_Functions.timeWait(3);
		report.updateTestLog("Verify Create Activity Properties ","The Activity is saved and New Activity is displayed ",  Status.PASS);
		Utility_Functions.xClick(driver, subject, true);
		Random random = new Random();
		int value = random.nextInt();

		Utility_Functions.xSendKeys(driver, subject, "Test Activity Created by Automation" + value);
		Utility_Functions.timeWait(3);
		Utility_Functions.xClick(driver, activityType2, true);
		Utility_Functions.timeWait(3);
		Utility_Functions.xClick(driver, saveActivity, true);

		SearchTextSOQL searchTextSOQL = new SearchTextSOQL(scriptHelper);
		String query = "select Name from Activity__C where Subject__C = " + "'" + "Test Activity Created by Automation" + value + "'";
		String nameActivity = searchTextSOQL.fetchRecordFieldValue("Name", query);
		if(nameActivity.isEmpty()) {
			System.out.println("Activity has not been retrieved");
			report.updateTestLog("Verify Create Activity Properties ","The newly created Activity has not been retrieved ",  Status.FAIL);
		} else {
			System.out.println("Activity has been retrieved");
			report.updateTestLog("Verify Create Activity Properties ","The newly created Activity has been retrieved",  Status.PASS);
		}
		String queryId = "select Id from Activity__C where Name = " + "'" + nameActivity + "'";
		String activityId = searchTextSOQL.fetchRecordFieldValue("Id", queryId);

		String url = driver.getCurrentUrl().split("#")[0];
		String newUrl = url + "#/sObject/" + activityId;
		newUrl = newUrl + "/view";
		report.updateTestLog("Verify Add Opportunity Page Fields",
				"URL has been replaced with the new URL having the retrieved Opportunity:::" + newUrl, Status.PASS);
		driver.get(newUrl);
		driver.navigate().refresh();



		Utility_Functions.timeWait(4);
		driver.navigate().refresh();
		Utility_Functions.timeWait(1);
		driver.switchTo().defaultContent();
		driver.navigate().refresh();
		Utility_Functions.timeWait(3);
		Utility_Functions.xClick(driver,  selectCreateFollowUpCustomActivity, true);
		Utility_Functions.timeWait(3);
		report.updateTestLog("Verify Create Activity Properties","The Follow up Activity Page is Displayed",  Status.PASS);
		Utility_Functions.xWaitForElementPresent(driver, createCustomActivity, 5);

		Actions action  = new Actions(driver.getWebDriver());
		action.moveToElement(createCustomActivity);
		action.click();
		action.build().perform();
		Utility_Functions.timeWait(3);

		Utility_Functions.xSwitchtoFrame(driver, subject );
		Utility_Functions.timeWait(3);
		Utility_Functions.xClick(driver, subject, true);
		Utility_Functions.timeWait(3);
		Utility_Functions.xSendKeys(driver, subject, "test3");
		Utility_Functions.timeWait(3);
		Utility_Functions.xClick(driver, activityType3, true);
		Utility_Functions.timeWait(3);
		Utility_Functions.xClick(driver, saveActivity, true);
		Utility_Functions.timeWait(3);
		report.updateTestLog("Verify Create Activity Properties ","The Custom Activity is created ",  Status.PASS);
		driver.navigate().refresh();
		Utility_Functions.timeWait(1);
		driver.switchTo().defaultContent();
		driver.navigate().refresh();
		Utility_Functions.timeWait(3);
		try{
			Utility_Functions.xWaitForElementPresent(driver,menu_Properties, 3);
			Utility_Functions.xClick(driver, menu_Properties, true);
		}catch(Exception e){
			Utility_Functions.xWaitForElementPresent(driver, menu_More, 3);
			Utility_Functions.xClick(driver, menu_More, true);
			Utility_Functions.xWaitForElementPresent(driver, properties, 2);
			Utility_Functions.xClick(driver, properties, true);	
		}
		//Utility_Functions.xClick(driver, recentlyViewed, true);
		//Utility_Functions.timeWait(3);
		List<WebElement> recentlyViewedpropertiesList = driver.findElements(By.xpath(".//a[@class='slds-truncate outputLookupLink slds-truncate forceOutputLookup']"));

		Utility_Functions.xclickOnFirstElementfromList(recentlyViewedpropertiesList);
		Utility_Functions.timeWait(3);
		Utility_Functions.xWaitForElementVisible(driver, related, 5);
		Utility_Functions.xClick(driver, related, true);
		Utility_Functions.xScrollWindow(driver);
		Utility_Functions.timeWait(1);
		Utility_Functions.xScrollWindowTop(driver);
		Utility_Functions.timeWait(2);

		Utility_Functions.xWaitForElementPresent(driver, relatedActivities, 5);
		Utility_Functions.xClick(driver, relatedActivities, true);

		List<WebElement> relatedActivitiesList = driver.findElements(By.xpath(".//a[@class='slds-truncate outputLookupLink slds-truncate forceOutputLookup'] "));
		for (WebElement element : relatedActivitiesList ) {
			if ((!element.getText().equals(" "))){
		report.updateTestLog("Verify Create Activity Properties","The New Activity for Properties are created ",Status.PASS);
	}else
	{
		report.updateTestLog("Verify Create Activity Properties","The New Activity for Properties are not created ",Status.FAIL);
	}
		}
		}
	/**
	 * Validating the New Activity Page Layout in the Properties
	 * 
	 * @author Ramya
	 *
	 */
	public void verifyPropertiesNewActivityPageLayout() {
		try{
			Utility_Functions.xWaitForElementPresent(driver,menu_Properties, 3);
			Utility_Functions.xClick(driver, menu_Properties, true);
		}catch(Exception e){
			Utility_Functions.xWaitForElementPresent(driver, menu_More, 3);
			Utility_Functions.xClick(driver, menu_More, true);
			Utility_Functions.xWaitForElementPresent(driver, properties, 2);
			Utility_Functions.xClick(driver, properties, true);	
		}
		report.updateTestLog("Verify New Activity Page Layout ","Properties is Displayed ",  Status.PASS);
		Utility_Functions.xWaitForElementPresent(driver, recentlyViewed, 3);
		Utility_Functions.xClick(driver, recentlyViewed, true);
		report.updateTestLog("Verify New Activity Page Layout ","Recently viewed Accounts are Displayed ",  Status.PASS);
		Utility_Functions.xWaitForElementPresent(driver, allProperties, 3);
		Utility_Functions.xClick(driver, allProperties, true);
		Utility_Functions.timeWait(3);
		report.updateTestLog("Verify New Activity Page Layout ","All Properties are Displayed ",  Status.PASS);
		List<WebElement> accountNamesList = driver.findElements(
				By.xpath(".//a[@class='slds-truncate outputLookupLink slds-truncate forceOutputLookup']"));

		Utility_Functions.xclickOnFirstElementfromList(accountNamesList);
		Utility_Functions.timeWait(3);
		report.updateTestLog("Verify New Activity Page Layout ","The Contact is Displayed ",  Status.PASS);
		Utility_Functions.xClick(driver, related, true);
		Utility_Functions.timeWait(3);
		report.updateTestLog("Verify New Activity Page Layout ","The related page is Displayed ",  Status.PASS);
		Utility_Functions.xScrollWindow(driver);
		Utility_Functions.timeWait(1);
		Utility_Functions.xScrollWindowTop(driver);
		Utility_Functions.timeWait(2);
		Utility_Functions.xWaitForElementPresent(driver, newActivity, 3);
		Utility_Functions.xClick(driver, newActivity, true);
		report.updateTestLog("Verify New Activity Page Layout ","The New Activity in the related page is Displayed ",  Status.PASS);
		/*int size = driver.findElements(By.tagName("iframe")).size();
		System.out.println(size);
		Utility_Functions.timeWait(2);
		List<WebElement> iframeList = driver.findElements(By.tagName("iframe"));
		System.out.println(iframeList.size());
		for (WebElement element : iframeList) {
			System.out.println(element.getAttribute("id"));
		}*/
		driver.switchTo().frame(2);
		Utility_Functions.timeWait(5);
		/*System.out.println("Frame Identified");
		Utility_Functions.timeWait(5);*/
		List<WebElement> newActivityPageLayoutSections = driver
				.findElements(By.xpath("//div[@class='slds-grid']"));
		int countHeader =0;
		try {
			for (WebElement element : newActivityPageLayoutSections  ) {
				if ((element.getText().contains("Quick Create"))) {
					System.out.println("Quick Create section is present in the New Activity Layout Page");
					report.updateTestLog("Verify New Activity Page Layout",
							"New Activity Layout Page is having the " + element.getText()
							+ " Status field::",
							Status.PASS);
					countHeader++;


				} else if ((element.getText().contains("System Information"))) {
					System.out.println("System Information section is present in the New Activity Layout Page");
					report.updateTestLog("Verify New Activity Page Layout",
							"New Activity Layout Page is having the " + element.getText()
							+ " Status field::",
							Status.PASS);
					countHeader++;


				} else if ((element.getText().contains("Related To"))) {
					System.out.println(" Related To section is present in the New Activity Layout Page");
					report.updateTestLog("Verify New Activity Page Layout",
							"New Activity Layout Page is having the " + element.getText()
							+ " Status field::",
							Status.PASS);
					countHeader++;

				}				
			} 
			System.out.println(countHeader);
			if(countHeader!=3) {
				System.out.println("New Activity Page Layout does not contain the Quick Create, System Information and Related To sections");
				report.updateTestLog("Verify New Activity Page Layout",
						"New Activity Layout Page is having all the fields", Status.FAIL);				
			}
		}catch (Exception e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
		}


		List<WebElement> newActivityPageLayoutRequiredFields = driver.findElements(By.xpath("//label[@class='slds-form-element__label']"));
		int countRequiredFiles =0;
		try {
			for (WebElement element : newActivityPageLayoutRequiredFields  ) {
				if ((element.getText().equals("*Subject"))) {
					System.out.println("Subject required field is present in the New Activity Layout Page");
					report.updateTestLog("Verify New Activity Page Layout",
							"New Activity Layout Page is having the " + element.getText()
							+ " Status field::",
							Status.PASS);
					countRequiredFiles++;

				} else if ((element.getText().equals("*Activity Type"))) {
					System.out.println("Activity Type required field is present in the New Activity Layout Page");
					report.updateTestLog("Verify New Activity Page Layout",
							"New Activity Layout Page is having the " + element.getText()
							+ " Status field::",
							Status.PASS);
					countRequiredFiles++;

				} else if ((element.getText().equals("*Assigned To"))) {
					System.out.println(" Assigned To required field is present in the New Activity Layout Page");
					report.updateTestLog("Verify New Activity Page Layout",
							"New Activity Layout Page is having the " + element.getText()
							+ " Status field::",
							Status.PASS);
					countRequiredFiles++;


				} else if ((element.getText().equals("*Status"))) {
					System.out.println(" Status required field is present in the New Activity Layout Page");
					report.updateTestLog("Verify New Activity Page Layout",
							"New Activity Layout Page is having the " + element.getText()
							+ " Status field::",
							Status.PASS);
					countRequiredFiles++;

				}
				else if ((element.getText().equals("*Priority"))) {
					System.out.println(" Priority required field is present in the New Activity Layout Page");
					report.updateTestLog("Verify New Activity Page Layout",
							"New Activity Layout Page is having the " + element.getText()
							+ " Status field::",
							Status.PASS);
					//countRequiredFiles++;

				}

			} 
			System.out.println(countRequiredFiles);
			if(countRequiredFiles!=4) {
				System.out.println("New Activity Page Layout does not contain the required fields ");
				report.updateTestLog("Verify New Activity Page Layout",
						"New Activity Layout Page is having all the required fields",
						Status.FAIL);
			}


		}catch (Exception e) {
			e.printStackTrace();
			System.out.println(e.getMessage());

		}


		if(!driver.findElements(By.xpath("// input [@value= 'Save']")).isEmpty()){
			System.out.println("Save button is present in the New Activity Layout Page");
			report.updateTestLog("Verify New Activity Page Layout ","The Save Button is present in the New Activity Page",  Status.PASS);
		}else{
			System.out.println("Save button is not present in the New Activity Layout Page");
			report.updateTestLog("Verify New Activity Page Layout ","The Save Button is not present in the New Activity Page",  Status.FAIL);
		}
		if(!driver.findElements(By.xpath("// input [@value= 'Save & New']")).isEmpty()){
			System.out.println("Save&New button is present in the New Activity Layout Page");
			report.updateTestLog("Verify New Activity Page Layout ","The Save&New Button is present in the New Activity Page",  Status.PASS);
		}else{
			System.out.println("Save&New button is not present in the New Activity Layout Page");
			report.updateTestLog("Verify New Activity Page Layout ","The Save&New Button is not present in the New Activity Page",  Status.FAIL);
		}
		if(!driver.findElements(By.xpath("// input [@value= 'Cancel']")).isEmpty()){
			System.out.println("Cancel button is present in the New Activity Layout Page");
			report.updateTestLog("Verify New Activity Page Layout","The Cancel Button is present in the New Activity Page",  Status.PASS);
		}else{
			System.out.println("Cancel button is not present in the New Activity Layout Page");
			report.updateTestLog("Verify New Activity Page Layout","The Cancel Button is not present in the New Activity Page",  Status.FAIL);
		}

		List<WebElement> newActivityPageFields = driver
				.findElements(By.xpath("//label[@class='slds-form-element__label']"));
		int count = 0;
		try {
			for (WebElement element : newActivityPageFields ) {
				if ((count == 0) && (element.getText().contains("Subject"))) {
					System.out.println("Subject field is present in the New Activity Layout Page");
					report.updateTestLog("Verify New Activity Page Layout",
							"New Activity Layout Page is having the " + element.getText()
							+ " Status field::",
							Status.PASS);
					count++;
				} else if ((count == 1) && (element.getText().contains("Activity Type"))) {
					System.out.println("Activity Type field is present in the New Activity Layout Page");
					report.updateTestLog("Verify New Activity Page Layout",
							"New Activity Layout Page is having the " + element.getText()
							+ " Status field::",
							Status.PASS);
					count++;
				}else if ((count == 2) && (element.getText().contains("DueDate"))) {
					System.out.println("Due Date field is present in the New Activity Layout Page");
					report.updateTestLog("Verify New Activity Page Layout",
							"New Activity Layout Page is having the " + element.getText()
							+ " Status field::",
							Status.PASS);
					count++;
				} else if ((count == 3) && (element.getText().contains("Call Result"))) {
					System.out
					.println("Call Result field is present in the New Activity Layout Page");
					report.updateTestLog("Verify New Activity Page Layout",
							"New Activity Layout Page is having the " + element.getText()
							+ " Status field::",
							Status.PASS);
					count++;

				} else if ((count == 4) && (element.getText().contains("Comments"))) {
					System.out
					.println("Comments field is present in the New Activity Layout Page");
					report.updateTestLog("Verify New Activity Page Layout",
							"New Activity Layout Page is having the " + element.getText()
							+ " Status field::",
							Status.PASS);
					count++;
				} else if ((count == 5) && (element.getText().contains("Owner"))) {
					System.out
					.println("Owner field is present in the New Activity Layout Page");
					report.updateTestLog("Verify New Activity Page Layout",
							"New Activity Layout Page is having the " + element.getText()
							+ " Status field::",
							Status.PASS);
					count++;
				} else if ((count == 6) && (element.getText().contains("Assigned To"))) {
					System.out
					.println("Assigned To field is present in the New Activity Layout Page");
					report.updateTestLog("Verify New Activity Page Layout",
							"New Activity Layout Page is having the " + element.getText()
							+ " Status field::",
							Status.PASS);
					count++;
				} else if ((count == 7) && (element.getText().contains("Status"))) {
					System.out
					.println("Status field is present in the New Activity Layout Page");
					report.updateTestLog("Verify New Activity Page Layout",
							"New Activity Layout Page is having the " + element.getText()
							+ " Status field::",
							Status.PASS);
					count++;
				} else if ((count == 8) && (element.getText().contains("Priority"))) {
					System.out.println(
							"Priority field is present in the New Activity Layout Page");
					report.updateTestLog("Verify New Activity Page Layout",
							"New Activity Layout Page is having the " + element.getText()
							+ " Status field::",
							Status.PASS);
					count++;
				} else if ((count == 9) && (element.getText().contains("Account"))) {
					System.out.println(
							"Account field is present in the New Activity Layout Page");
					report.updateTestLog("Verify New Activity Page Layout",
							"New Activity Layout Page is having the " + element.getText()
							+ " Status field::",
							Status.PASS);
					count++;
				} else if ((count == 10) && (element.getText().contains("Contact"))) {
					System.out.println("Contact field is present in the New Activity Layout Page");
					report.updateTestLog("Verify New Activity Page Layout",
							"New Activity Layout Page is having the " + element.getText()
							+ " Status field::",
							Status.PASS);
					count++;

				}else if ((count == 11) && (element.getText().contains("Opportunity"))) {
					System.out.println("Opportunity field is present in the New Activity Layout Page");
					report.updateTestLog("Verify New Activity Page Layout",
							"New Activity Layout Page is having the " + element.getText()
							+ " Status field::",
							Status.PASS);
					count++;
				}else if ((count == 12) && (element.getText().contains("Property"))) {
					System.out.println("Property field is present in the New Activity Layout Page");
					report.updateTestLog("Verify New Activity Page Layout",
							"New Activity Layout Page is having the " + element.getText()
							+ " Status field::",
							Status.PASS);
					count++;
				} else if ((count == 13) && (element.getText().contains("Space"))) {
					System.out.println("Space  field is present in the New Activity Layout Page");
					report.updateTestLog("Verify New Activity Page Layout",
							"New Activity Layout Page is having the " + element.getText()
							+ " Status field::",
							Status.PASS);
					count++;
				}else if ((count == 14) && (element.getText().contains("Comp"))) {
					System.out.println(
							"Comp field is present in the New Activity Layout Page");
					report.updateTestLog("Verify New Activity Page Layout",
							"New Activity Layout Page is having the " + element.getText()
							+ " Status field::",
							Status.PASS);

				}

			} 
			System.out.println(count);
			if(count!=14) {
				System.out.println("New Activity Page Layout does not contain all the fields ");
				report.updateTestLog("Verify New Activity Page Layout",
						"New Activity Layout Page is not having all the fields",
						Status.FAIL);

			}
		}catch (Exception e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
		}


		List<WebElement> newActivityPageCheckFields = driver
				.findElements(By.xpath("//span[@class='slds-form-element__label']"));

		try {
			for (WebElement element : newActivityPageCheckFields ) {
				if ((element.getText().contains("Set Reminder"))) {
					System.out.println("Set Reminder field is present in the Create Private Notes Personal Information Page");
					report.updateTestLog("Verify New Activity Page Layout",
							"New Activity Layout Page is having the " + element.getText()
							+ " Status field::",
							Status.PASS);

				} else if ((element.getText().contains("Notification Email"))) {
					System.out.println("Notification Email field is present in the New Activity Layout Page");
					report.updateTestLog("Verify New Activity Page Layout",
							"New Activity Layout Page is having the " + element.getText()
							+ " Status field::",
							Status.PASS);

				}else if ((element.getText().contains("Has Attachment"))) {
					System.out.println("Has Attachment  field is present in the New Activity Layout Page");
					report.updateTestLog("Verify New Activity Page Layout",
							"New Activity Layout Page is having the " + element.getText()
							+ " Status field::",
							Status.PASS);

				}else {
					System.out.println("New Activity Page Layout does not contain the the Set Reminder and Notification Email and Has Attachment Fields");
					report.updateTestLog("Verify New Activity Page Layout",
							"New Activity Layout Page is having the " + element.getText()
							+ " Status field::",
							Status.FAIL);

				}
			}
		}catch (Exception e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
		}
		try {
			if ((!assignedTo.getText().equals("")) || (!accountSelected.getText().equals(""))||(!priority.getText().equals(""))||(!owner.getText().equals(""))||(!status.getText().equals(""))) {
				System.out.println("Assigned To, Account Selected, Priority, Owner and Status fields are having the values:::");
				report.updateTestLog("Verify New Activity Page Layout",
						"New Activity Layout Page is having the values::", Status.PASS);
			} else {
				System.out.println("New Activity Layout Page is not having the deafault values:::");
				report.updateTestLog("Verify New Activity Page Layout",
						"New Activity layout Page is not having the values::", Status.FAIL);
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
		}

	}
}
