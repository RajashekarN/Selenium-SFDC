package pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.cognizant.Craft.ReusableLibrary;
import com.cognizant.Craft.ScriptHelper;
import com.cognizant.framework.Status;

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

	@FindBy(xpath = "//span[@class='moreLabel'][text()='More']")
	WebElement menu_More;

	@FindBy(xpath = "//div[@class='overflowList']//li/a[@title='Properties']")
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
			driver.switchTo().frame(driver.findElement(By.xpath("//iframe[contains(@src,'recordtypeselect')]")));
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
	
}