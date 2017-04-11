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

public class opportunitiesPage extends ReusableLibrary {
	/*
	 * Constructor to initialize the business component library
	 * 
	 * @param scriptHelper The {@link ScriptHelper} object passed from the
	 * {@link DriverScript}
	 */

	public opportunitiesPage(ScriptHelper scriptHelper) {
		super(scriptHelper);
		PageFactory.initElements(driver, this);
		// new WebDriverUtil(driver);
		utility = new Utility_Functions(scriptHelper);
	}

	@FindBy(xpath = ".//div[@class='mainBody']//span[contains(text(), 'Total Size')]/parent::div/parent::div/div[2]/div/span")
	WebElement totalSize;

	@FindBy(xpath = ".//div[@class='mainBody']//span[contains(text(), 'Preferred Property Type')]/parent::div/parent::div/div[2]/div/span")
	WebElement preferredPropertyType;

	@FindBy(xpath = ".//div[@class='mainBody']//span[contains(text(), 'Lease From')]/parent::div/parent::div/div[2]/div/span")
	WebElement leaseFrom;

	@FindBy(xpath = ".//div[@class='mainBody']//span[contains(text(), 'Lease To')]/parent::div/parent::div/div[2]/div/span")
	WebElement leaseTo;

	@FindBy(xpath = ".//div[@class='mainBody']//span[contains(text(), 'Lease Term (Months)')]/parent::div/parent::div/div[2]/div/span")
	WebElement leaseTerm;

	@FindBy(xpath = ".//div[@class='mainBody']//span[contains(text(), 'Lease Rate/Rent')]/parent::div/parent::div/div[2]/div/span")
	WebElement leaseRate;

	@FindBy(xpath = ".//div[@class='mainBody']//span[contains(text(), 'Lease Rate/Rent Basis')]/parent::div/parent::div/div[2]/div/span")
	WebElement leaseRateRentBasis;

	@FindBy(xpath = ".//a[@class='forceActionLink']/div[@class='slds-truncate'][text()='Edit']")
	WebElement edit;

	@FindBy(xpath = ".//div[@class='select-options']/ul/li")
	WebElement occupierLease;

	@FindBy(xpath = ".//span[@class='label inputLabel uiPicklistLabel-left form-element__label uiPicklistLabel']/span[text()='Assignment Type']i")
	WebElement assignmentType;

	@FindBy(xpath = "//div[@class='select-options']/ul[@role='presentation']/li")
	WebElement selectStage;
	
	@FindBy(xpath = "//div[@class='modal-footer slds-modal__footer']//button[@title='Save']")
	WebElement save;
	
	@FindBy(xpath = ".//div[@class='toastContent']//span[@class='slds-icon_container slds-icon-utility-success toastIcon slds-button__icon forceIcon']")
	WebElement opportunitySaved;	
	
	
	homePage hp = new homePage(scriptHelper);
	public void requiredFields_SalesStage_Opportunities() {
		hp.validate_Menu_Opportunities();
		try {
			Utility_Functions.timeWait(1);
			List<WebElement> opportunityList = driver.findElements(
					By.xpath(".//a[@class='slds-truncate outputLookupLink slds-truncate forceOutputLookup']"));
			Utility_Functions.xclickgetTextofFirstElementfromList(opportunityList);
			Utility_Functions.timeWait(3);
			validateOpportunityFields();
			Utility_Functions.xClick(driver, edit, true);
			Utility_Functions.timeWait(4);
			Utility_Functions.xScrollWindow(driver);
			Utility_Functions.xSelectDropdownByIndex(occupierLease, 5);
			Utility_Functions.timeWait(1);
			Utility_Functions.xSelectDropdownByIndex(selectStage, 16);
			Utility_Functions.timeWait(1);
			Utility_Functions.xClick(driver, save, true);
			Utility_Functions.timeWait(5);
			if(opportunitySaved.isDisplayed()) {
				report.updateTestLog("Verify Opportunity", "Opportunity saved successfully:::", Status.PASS);
			} else {
				report.updateTestLog("Verify Opportunity", "Opportunity didn't get saved:::", Status.FAIL);
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
		}
	}

	public void validateOpportunityFields() {

		Utility_Functions.xScrollWindowOnce(driver);
		Utility_Functions.timeWait(1);
		try {
			if (totalSize.getText().equals("")) {
				report.updateTestLog("Verify Opportunity Fields", "Total Size field is blank:::" + totalSize.getText(),
						Status.PASS);
				if (preferredPropertyType.getText().equals("")) {
					report.updateTestLog("Verify Opportunity Fields",
							"PreferredPropertyType field is blank:::" + preferredPropertyType.getText(), Status.PASS);
				}
				if (leaseFrom.getText().equals("")) {
					report.updateTestLog("Verify Opportunity Fields", "LeaseFrom field is blank:::" + leaseFrom.getText(),
							Status.PASS);
				}
				if (leaseTo.getText().equals("")) {
					report.updateTestLog("Verify Opportunity Fields", "LeaseTo field is blank:::" + leaseTo.getText(),
							Status.PASS);
				}
				if (leaseTerm.getText().equals("")) {
					report.updateTestLog("Verify Opportunity Fields", "LeaseTerm field is blank:::" + leaseTerm.getText(),
							Status.PASS);
				}
				if (leaseRate.getText().equals("")) {
					report.updateTestLog("Verify Opportunity Fields", "LeaseRate field is blank:::" + leaseRate.getText(),
							Status.PASS);
				}
				if (leaseRateRentBasis.getText().equals("")) {
					report.updateTestLog("Verify Opportunity Fields",
							"LeaseRateRentBasis field is blank:::" + leaseRateRentBasis.getText(), Status.PASS);
				}
			} else {
				report.updateTestLog("Verify Opportunity Fields",
						"Some of the fields are not blank in the Opporturnity Page:::", Status.FAIL);
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
		}
	}
}