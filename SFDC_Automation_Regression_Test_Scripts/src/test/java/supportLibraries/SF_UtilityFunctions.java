package supportLibraries;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import com.cognizant.Craft.ReusableLibrary;
import com.cognizant.Craft.ScriptHelper;

public class SF_UtilityFunctions extends ReusableLibrary {

	public SF_UtilityFunctions(ScriptHelper scriptHelper) {
		super(scriptHelper);
	}


	@FindBy(xpath = "//div[@class='linkElements']/a[contains(text(),'Switch to Lightning Experience')]")
	WebElement switchToLightningExperience;



	/*@FindBy(xpath = "//one-app-nav-bar[contains(@class,'slds-has-flexi-truncate')]//span[contains(text(),'@TabName')]")
	WebElement oneAppNavigationBar;*/


	/**
	 * Switch to Lightning Experience
	 * 
	 * @author Vishnuvardhan
	 *
	 */

	public void switchToLightningExperience() {
		Utility_Functions.xWaitForElementPresent(driver, switchToLightningExperience, 3);
		Utility_Functions.xClick(driver, switchToLightningExperience, true);		
	}

	/**
	 * Select the Home Page menu items from One App Navigation Bar
	 * 
	 * @author Vishnuvardhan
	 *
	 */

	public void oneAppNavigationTab(String sText) {
		WebElement oneAppNavigatioBar = driver.findElement(By.xpath("//one-app-nav-bar[contains(@class,'slds-has-flexi-truncate')]//span[contains(text(),'"+sText+"')]"));
		Utility_Functions.xWaitForElementPresent(driver, oneAppNavigatioBar, 3);
		Utility_Functions.xClick(driver, oneAppNavigatioBar, true);
	}


	/**
	 * Select Accounts, Contacts, Opp's etc from the list of Accounts
	 * 
	 * @author Vishnuvardhan
	 *
	 */

	/*	
	public void selectExisitingObject(String sText) {
		List<WebElement> list = null;
		if(sText.equals("Accounts")) {
			list = driver.findElements(By.xpath("//a[@class='slds-truncate outputLookupLink slds-truncate forceOutputLookup'][contains(@data-recordid,'001')]"));
		} else if(sText.equals("Contacts")) {
			list = driver.findElements(By.xpath("//a[@class='slds-truncate outputLookupLink slds-truncate forceOutputLookup'][contains(@data-recordid,'003')]"));
		} else if(sText.equals("Opportunities")) {
			list = driver.findElements(By.xpath("//a[@class='slds-truncate outputLookupLink slds-truncate forceOutputLookup'][contains(@data-recordid,'006')]"));
		} else if(sText.equals("Leads")) {
			list = driver.findElements(By.xpath("//a[@class='slds-truncate outputLookupLink slds-truncate forceOutputLookup'][contains(@data-recordid,'00Q')]"));
		} else if(sText.equals("Properties")) {
			list = driver.findElements(By.xpath("//a[@class='slds-truncate outputLookupLink slds-truncate forceOutputLookup'][contains(@data-recordid,'a0M')]"));
		} 
		Utility_Functions.xWaitForElementPresent(driver, list, 7);
		Utility_Functions.xclickRandomElement(list);
	}
	 */


	public void selectExisitingObjectRecord(String tableColumn) {
		By allRecords = By.xpath("(//span[text()='"+tableColumn+"']/ancestor::thead/following-sibling::tbody//th//a)");
		Utility_Functions.xWaitForElementPresent(driver, driver.findElements(allRecords), 7);
		Utility_Functions.xclickRandomElement(driver.findElements(allRecords));
	}


	/**
	 * Select Details, Related tabs from either Accounts, Contacts, Opp's etc 
	 * 
	 * @author Vishnuvardhan
	 *
	 */

	public void selectTabs(String sText) {
		WebElement tab = driver.findElement(By.xpath("//div[@class='uiTabBar']//span[text()='"+sText+"']"));
		Utility_Functions.xWaitForElementPresent(driver, tab, 4);
		Utility_Functions.xClick(driver, tab, true);
	}

	/**
	 * Select New, Import from the list of Actions
	 * 
	 * @author Vishnuvardhan
	 *
	 */

	public void selectAction(String sText) {
		WebElement newAction = driver.findElement(By.xpath("//div[contains(@class,'ForceActionsContainer')]//div[text()='"+sText+"']"));
		Utility_Functions.xWaitForElementPresent(driver, newAction, 4);
		Utility_Functions.xClick(driver, newAction, true);
	}

	/**
	 * Select Record Type radio button out of multiple radio buttons
	 * 
	 * @author Vishnuvardhan
	 *
	 */

	public void selectRecordTypeRadioButton(String radioBtnName) {
		WebElement selectRecordType = driver.findElement(By.xpath("//div[contains(@class,'changeRecordTypeLeftRightContent')]//span[text()='"+radioBtnName+"']/parent::div/parent::label//span[@class='slds-radio--faux']"));
		Utility_Functions.xWaitForElementPresent(driver, selectRecordType, 4);
		Utility_Functions.xClick(driver, selectRecordType, true);
	}


	/**
	 * @Description : This method selects the object's recordType [Ex: select 'Occupier Brokerage', or 'A&T Investor' from the RecordType section]
	 * @author Swapna
	 */
	public void selectObjectRecordType(String recordTypeName) {
		By recordTypeField = By.xpath("//select[contains(@id,'record-type-select')]");
		By recordTypeValue = By.xpath("//select[@id='record-type-select']/option[text()='"+recordTypeName+"']");

		Utility_Functions.xWaitForElementPresent(driver, recordTypeField, 5);
		driver.findElement(recordTypeField).click();
		Utility_Functions.xWaitForElementPresent(driver, recordTypeValue, 5);
		driver.findElement(recordTypeValue).click();
	}


	/**
	 * Select a option from the list of dropdown values [Ex : Select Target, or Prospecting from Sales Stage]
	 * 
	 * @author Swapna
	 *
	 */

	public void selectStandardDropdownOption(String PickListName, String PickListValue) {
		WebElement fieldName = null;				
		By pickListTypeOne = By.xpath("//span[text()='"+PickListName+"']/parent::span/following-sibling::div//a");
		By pickListTypeTwo = By.xpath("//span[text()='"+PickListName+"']/parent::label/following-sibling::div/descendant::a");
		By pickListValue = By.xpath("(//a[@title='"+PickListValue+"'])[1]");

		Utility_Functions.xScrollWindowTop(driver);
		Utility_Functions.timeWait(1);
		try{
			//select the picklist field
			try{
				Utility_Functions.xScrollWindowToElement(driver, driver.findElement(pickListTypeOne));
				Utility_Functions.timeWait(2);
				fieldName = driver.findElement(pickListTypeOne);
			} catch(Exception e){
				Utility_Functions.xScrollWindowToElement(driver, driver.findElement(pickListTypeTwo));
				Utility_Functions.timeWait(2);
				fieldName = driver.findElement(pickListTypeTwo);						
			}
			//click on pick list name
			fieldName.click();
			Utility_Functions.xScrollWindowToElement(driver, driver.findElement(pickListValue));
			driver.findElement(pickListValue).click();
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Error on finding PickList for ["+PickListName+"] " +e.getMessage());
		}
	}



	/**
	 * Verify values are present in dropdown field [Ex : verify 'Consulting', 'Data Center', etc.. are present in 'Assignment Type' field]
	 * 
	 * @author Swapna
	 *
	 */

	public void verifyStandardDropdownOptions(String PickListName, ArrayList<String> ExpectedValues) {
		WebElement fieldName = null;				
		By pickListTypeOne = By.xpath("//span[text()='"+PickListName+"']/parent::span/following-sibling::div//a");
		By pickListTypeTwo = By.xpath("//span[text()='"+PickListName+"']/parent::label/following-sibling::div/descendant::a");
		ArrayList<String> ActualValues =  new ArrayList<String>();

		Utility_Functions.xScrollWindowTop(driver);
		Utility_Functions.timeWait(1);
		try{
			//select the picklist field
			try{
				Utility_Functions.xScrollWindowToElement(driver, driver.findElement(pickListTypeOne));
				Utility_Functions.timeWait(2);
				fieldName = driver.findElement(pickListTypeOne);
			} catch(Exception e){
				Utility_Functions.xScrollWindowToElement(driver, driver.findElement(pickListTypeTwo));
				Utility_Functions.timeWait(2);
				fieldName = driver.findElement(pickListTypeTwo);						
			}
			//click on pick list field and get the actual options 
			for(int i =0;i<ExpectedValues.size();i++){
				By expectedValue = By.xpath("(//a[@title='"+ExpectedValues.get(i)+"'])[1]");
				fieldName.click();
				Utility_Functions.xScrollWindowToElement(driver, driver.findElement(expectedValue));
				ActualValues.add(driver.findElement(expectedValue).getText());
				driver.findElement(expectedValue).click();
			}

			//compare the actual options with the expected options
			Object[] expectedValues = ExpectedValues.toArray();
			Object[] actualValues = ActualValues.toArray();
			Assert.assertEqualsNoOrder(actualValues, expectedValues);
			System.out.println("Verified actual value :"+ActualValues+ " with expected value : "+ExpectedValues+" ::::passed");

		}catch (Exception e) {
			e.printStackTrace();
			System.out.println("Verified actual value :"+ActualValues+ " with expected value : "+ExpectedValues+" ::::failed");
		}
	}

	/**
	 * Click on buttons like Save, Cancel etc
	 * 
	 * @author Swapna
	 * @return 
	 *
	 */
	public void clickOnButton(String buttonName) {
		By ButtonName = By.xpath("//span[text()='"+buttonName+"']/parent::button)");
		List<WebElement> elements = driver.findElements(ButtonName);
		int Size = elements.size();
		for(int i=1; i<=Size;i++){
			String elementNumber = Integer.toString(i);
			By iButtonName = By.xpath("(//span[text()='"+buttonName+"']/parent::button)["+elementNumber+"]");
			boolean isElementDisplayed = driver.findElement(iButtonName).isDisplayed();
			if(isElementDisplayed != false){
				driver.findElement(iButtonName).click();
			}
		}
	}


	/**
	 * Select actions like Edit, Clone and Sharing etc
	 * 
	 * @author Swapna
	 *
	 */


	public void clickOnDetailAction(String buttonName) {
		By ButtonName = By.xpath("//div[text()='"+buttonName+"']/parent::a");
		List<WebElement> elements = driver.findElements(ButtonName);
		int Size = elements.size();
		for(int i=1; i<=Size;i++){
			String elementNumber = Integer.toString(i);
			By iButtonName = By.xpath("(//div[text()='"+buttonName+"']/parent::a)["+elementNumber+"]");
			boolean isElementDisplayed = driver.findElement(iButtonName).isDisplayed();
			if(isElementDisplayed != false){
				driver.findElement(iButtonName).click();
			}
		}
	}

	/**
	 * Select a button from the related list 
	 * 
	 * @author Swapna
	 *
	 */
	public void selectRelatedListsButton(String RelatedListName, String ButtonName) {
		By buttonName = By.xpath("//span[contains(text(),'"+RelatedListName+"')]/ancestor::header/following-sibling::div//*[text()='"+ButtonName+"']");
		Utility_Functions.xScrollWindowTop(driver);
		Utility_Functions.xScrollWindowToElement(driver, driver.findElement(buttonName));
		Utility_Functions.timeWait(4);
		driver.findElement(buttonName).click();	   
	}

	/**
	 * returns the Page Header text from the details page
	 * 
	 * @author Swapna
	 * @return 
	 *
	 */
	public String getPageHeader(String ObjectName) { 
		By detailHeaderSec_TextTitle= By.xpath("//p[(text()='"+ObjectName+"')]//following-sibling::h1//span");
		By detailHeaderSec_LinkTextTitle = By.xpath("//p[text()='"+ObjectName+"']/following-sibling::h1//a");
		String headerString = null;
		Utility_Functions.xScrollWindowTop(driver);
		try{
			Utility_Functions.xWaitForElementPresent(driver, detailHeaderSec_TextTitle, 5);
			headerString = driver.findElement(detailHeaderSec_TextTitle).getText();
		}catch(Exception e){
			Utility_Functions.xWaitForElementPresent(driver, detailHeaderSec_LinkTextTitle, 5);
			headerString = driver.findElement(detailHeaderSec_LinkTextTitle).getText();			
		}
		return headerString;
	}
	
	
	/**
	 * Select the object from the lookup list
	 * 
	 * @author Vishnuvardhan
	 *
	 */
	
	public void selectObjectFromLookUpList() {
		WebElement firstLookupElement = driver.findElement(By.cssSelector("ul>li.forceSearchInputLookupDesktopOption:nth-child(1)"));
		Utility_Functions.xWaitForElementPresent(driver, firstLookupElement, 4);
		Utility_Functions.xClick(driver, firstLookupElement, false);
	}
	
	/**
	 * Select the 2nd object from the lookup list
	 * 
	 * @author Vishnuvardhan
	 *
	 */
	
	public void selectObjectFromLookUpList(String sText) {
		List<WebElement> firstLookupElements = driver.findElements(By.cssSelector("ul>li.forceSearchInputLookupDesktopOption:nth-child(1)"));
		int index=0;
		for(WebElement element: firstLookupElements) {
			if(sText.equals("FirstElement")) {
				if(index==0) {
					Utility_Functions.xWaitForElementPresent(driver, element, 4);
					Utility_Functions.xClick(driver, element, false);
				}
			} else if(sText.equals("SecondElement")) {
				if(index==1) {
					Utility_Functions.xWaitForElementPresent(driver, element, 4);
					Utility_Functions.xClick(driver, element, false);
				}
			}
			index++;
		}		
	}
}
