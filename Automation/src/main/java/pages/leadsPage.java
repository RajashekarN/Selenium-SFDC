package pages;


import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.cognizant.framework.Status;

import supportlibraries.ReusableLibrary;
import supportlibraries.ScriptHelper;
import supportlibraries.Utility_Functions;

public class leadsPage extends ReusableLibrary {
	/*
	 * Constructor to initialize the business component library
	 * 
	 * @param scriptHelper The {@link ScriptHelper} object passed from the
	 * {@link DriverScript}
	 */
	public leadsPage(ScriptHelper scriptHelper) {
		super(scriptHelper);
		PageFactory.initElements(driver, this);
		// new WebDriverUtil(driver);
		utility = new Utility_Functions(scriptHelper);
	}

	@FindBy(xpath = "//*[text()='Leads']")
	WebElement menu_Leads;

	@FindBy(xpath = ".//div[@title='New']")
	WebElement newButton;	

	@FindBy(xpath = ".//*[@id='record-type-select']")
	WebElement leadRecordTypeSelection;	

	@FindBy(xpath = "//*[text()='Continue']")
	WebElement continueButton;	

	@FindBy(xpath = ".//*[@id='record-type-select']/option[1]")
	WebElement agencyBroker;	

	@FindBy(xpath = ".//*[@id='record-type-select']/option[4]")
	WebElement capitalMarkets;	

	@FindBy(xpath = ".//*[@id='record-type-select']/option[6]")
	WebElement occupierBrokerage;	

	@FindBy(xpath = ".//*[@id='j_id0:LeadForm:j_id62']")
	WebElement firstName;	

	@FindBy(xpath = ".//*[@id='j_id0:LeadForm:j_id64']")
	WebElement lastName;	

	@FindBy(xpath = ".//*[@id='j_id0:LeadForm:j_id66']")
	WebElement company;	

	@FindBy(xpath = ".//div[@class='desktop municipality slds-truncate forceOutputAddressText']//span[4]")
	WebElement addressDetails;	

	@FindBy(xpath = ".//div[@class='dataCol readonly slds-no-space']/span[@class='uiOutputPhone']/parent::div/parent::div/parent::div/div/span[contains(text(), 'Direct Line')]")
	WebElement directLine;	

	@FindBy(xpath = ".//span[@class='uiOutputEmail']/parent::p/parent::li/p[contains(text(), 'Email')]")
	WebElement email;	

	@FindBy(xpath = ".//div[@class='desktop container forceStyle oneOne oneAppLayoutContainer']//*[text()='Convert']")
	WebElement convert;		

	@FindBy(xpath = ".//*[@id='convertedStatus']")
	WebElement convertedStatus;	

	@FindBy(xpath = ".//input[@id='j_id0:CustomLeadConversionFrom:accname']")
	WebElement accountName;	

	@FindBy(xpath = ".//input[@id='j_id0:CustomLeadConversionFrom:OwnerName']")
	WebElement recordOwner;	


	public void convertLead() {
		Utility_Functions.timeWait(1);
		Utility_Functions.xClick(driver, menu_Leads, true);
		Utility_Functions.timeWait(2);
		List<WebElement> leadsList = driver.findElements(
				By.xpath(".//a[@class='slds-truncate outputLookupLink slds-truncate forceOutputLookup']"));
		Utility_Functions.xclickgetTextofFirstElementfromList(leadsList);
		Utility_Functions.timeWait(2);
		Utility_Functions.xScrollWindowToElement(driver, addressDetails);
		Utility_Functions.xScrollWindowToElement(driver, directLine);
		Utility_Functions.xScrollWindowToElement(driver, email);
		try {
			if((!addressDetails.getText().equals("")) || (!directLine.getText().equals("")) || (!email.getText().equals(""))) {
				System.out.println("Address Details, DirectLine and Email field are having the values:::");
				report.updateTestLog("Lead Page", "Address Details, DirectLine and Email field are having the values::",
						Status.PASS);		
			} else {
				System.out.println("Address Details, DirectLine and Email field are not having the values:::");
				report.updateTestLog("Lead Page", "Address Details, DirectLine and Email field are not having the values::",
						Status.FAIL);		
			}
		} catch (Exception e1) {
			e1.printStackTrace();
			System.out.println(e1.getMessage());
		}
		Utility_Functions.xClick(driver, convert, true);
		Utility_Functions.timeWait(4);
		int size = driver.findElements(By.tagName("iframe")).size();
		System.out.println(size);
		driver.switchTo().frame(driver.findElement(By.xpath(".//iframe[contains(@src,'LeadConversionRed')]")));
		Utility_Functions.timeWait(1);
		List<WebElement> convertList = driver.findElements(By.xpath(".//label[@class='slds-form-element__label']"));
		int count=0; 
		try {
			for(WebElement element: convertList) {
				if((count==0) && (element.getText().equals("*Converted Status"))) {
					System.out.println("Converted Status field is present in the Convert Lead Page");
					report.updateTestLog("Convert Lead Page", "Convert Lead Page is having the " + element.getText() +" Status field::",Status.PASS);	
					count++;						
				} else if((count==1) && (element.getText().equals("*Record Owner"))) {
					System.out.println("Converted Status field is present in the Convert Lead Page");
					report.updateTestLog("Convert Lead Page", "Convert Lead Page is having the " + element.getText() +" Status field::",Status.PASS);
					count++;						
				} else if((count==2) && (element.getText().equals("*Account Name"))) {
					System.out.println("Converted Status field is present in the Convert Lead Page");
					report.updateTestLog("Convert Lead Page", "Convert Lead Page is having the " + element.getText() +" Status field::",Status.PASS);
				} 										
			}
			if(count!=2) 
				report.updateTestLog("Convert Lead Page", "Convert Lead Page is not having all the fields::",Status.FAIL);							
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
		}
		try {

			/*String script = "return document.getElementById('j_id0:CustomLeadConversionFrom:OwnerName').innerHTML";
			String recordOwnerText = (String) ((JavascriptExecutor) driver).executeScript(script);	*/	
			//String recordOwnerText = Utility_Functions.getText(driver, recordOwner);
			if(convertedStatus.getText().contains("Qualified")) {
				System.out.println("Converted Status field is having the option as Qualified by default");
				report.updateTestLog("Convert Lead Page", "Convert Lead Page is having the option as ::" + convertedStatus.getText() + "" ,Status.PASS);
			} /*else if(recordOwnerText != null) {
				System.out.println("Record Owner field is having the record owner autopopulated");
				report.updateTestLog("Convert Lead Page", "Convert Lead Page is not having the record owner value as null::",Status.PASS);
			} else {
				System.out.println("Fields are not having the values expected");
				report.updateTestLog("Convert Lead Page", "Convert Lead Page is not having the fields expected::",Status.FAIL);
			}*/
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
		}
	}

	public void createLead() {
		Utility_Functions.timeWait(2);
		Utility_Functions.xClick(driver, menu_Leads, true);
		Utility_Functions.timeWait(2);
		Utility_Functions.xClick(driver, newButton, true);
		Utility_Functions.timeWait(2);
		if(dataTable.getData("General_Data", "Lead Record Type").equals("Occupier Brokerage")) {
			Utility_Functions.xClick(driver, occupierBrokerage, true);
		} else if(dataTable.getData("General_Data", "Lead Record Type").equals("Agency Brokerage")) {
			Utility_Functions.xClick(driver, agencyBroker, true);
		} else if(dataTable.getData("General_Data", "Lead Record Type").equals("Capital Markets")) {
			Utility_Functions.xClick(driver, capitalMarkets, true);
		}
		Utility_Functions.xClick(driver, continueButton, true);


	}

}
