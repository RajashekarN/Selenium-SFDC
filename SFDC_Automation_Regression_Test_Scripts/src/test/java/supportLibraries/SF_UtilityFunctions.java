package supportLibraries;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import com.cognizant.Craft.ReusableLibrary;
import com.cognizant.Craft.ScriptHelper;
import com.cognizant.framework.Status;
import pagesAPI.EstablishConnection;

public class SF_UtilityFunctions extends ReusableLibrary {

	public SF_UtilityFunctions(ScriptHelper scriptHelper) {
		super(scriptHelper);
	}

	/**
	 * Switch to Lightning Experience
	 * 
	 * @author Vishnuvardhan
	 *
	 */

	public void switchToLightningExperience() {
		By switchToLightningExperience = By.xpath("//div[@class='linkElements']/a[contains(text(),'Switch to Lightning Experience')]");
		Utility_Functions.xWaitForElementPresent(driver, switchToLightningExperience, 3);
		driver.findElement(switchToLightningExperience).click();
	}

	/**
	 * Select the Home Page menu items from One App Navigation Bar
	 * 
	 * @author Swapna
	 *
	 */

	public void oneAppNavigationTab(String sText) {
		By oneAppNavigationTab = By.xpath("//one-app-nav-bar[contains(@class,'slds-has-flexi-truncate')]//span[text()='"+sText+"']");
		By oneAppNavigationMoreTab = By.xpath("//one-app-nav-bar[contains(@class,'slds-has-flexi-truncate')]//span[text()='More']");
		
		Utility_Functions.xWaitForElementPresent(driver, oneAppNavigationTab, 3);
		try{
			Utility_Functions.xClick(driver,driver.findElement(oneAppNavigationTab), true);
		}catch(Exception e){
			Utility_Functions.xWaitForElementPresent(driver, oneAppNavigationMoreTab, 3);
			Utility_Functions.xClick(driver, driver.findElement(oneAppNavigationMoreTab), true);
			Utility_Functions.xWaitForElementPresent(driver, oneAppNavigationTab, 1);
			Utility_Functions.xClick(driver, driver.findElement(oneAppNavigationTab), true);
		
		}
	}

	/**
	 * Select Accounts, Contacts, Opp's etc from the list of Accounts
	 * 
	 * @author Swapna
	 *
	 */
	public void selectExistingObjectRecord(String tableColumn) {
		By visibleRecords = By.xpath("(//span[text()='"+tableColumn+"')]/ancestor::thead/following-sibling::tbody//th//a)");
		Utility_Functions.timeWait(2);
		try {
			Utility_Functions.xWaitForElementPresent(driver, driver.findElements(visibleRecords), 7);
			Utility_Functions.xclickRandomElement(driver.findElements(visibleRecords));
		} catch (Exception e) {
			By recentlyViewed = By.xpath("//h1//span[text()='Recently Viewed']");
			By all = By.xpath("//span[contains(@class,'virtualAutocompleteOptionText')][contains(text(),'All')]");
			Utility_Functions.xWaitForElementPresent(driver, recentlyViewed, 3);
			driver.findElement(recentlyViewed).click();
			report.updateTestLog("Verify Recently Viewed", "Recently viewed dropdown is clicked::: ", Status.PASS);
			Utility_Functions.xWaitForElementPresent(driver, all, 5);
			driver.findElement(all).click();
			Utility_Functions.xWaitForElementPresent(driver, driver.findElements(visibleRecords), 7);
			Utility_Functions.xclickRandomElement(driver.findElements(visibleRecords));
		}
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
	 * Selects Related Tab in the Detail page {Ex: Select Enquiry & Offers Related List}
	 * @param Swapna
	 */
	public void selectRelatedTab(String tabName){
	  try{
		By relatedtab = By.xpath("//a[text()='"+tabName+"'][1]");
		By MoreTab = By.xpath("//a[text()='More']");
		
		try{
			Utility_Functions.xWaitForElementPresent(driver, relatedtab, 3);
			Utility_Functions.xClick(driver,driver.findElement(relatedtab), true);
		}catch(Exception e){
			Utility_Functions.xWaitForElementPresent(driver, MoreTab, 3);
			Utility_Functions.xClick(driver, driver.findElement(MoreTab), true);
			//Utility_Functions.xWaitForElementPresent(driver, relatedtab, 1);
			Utility_Functions.xClick(driver, driver.findElement(relatedtab), true);
		}
	  }catch(Exception e){
		  System.out.println("Related Tab not found"+tabName +" -- "+e.getMessage());
		  throw e;
	  }
	}

	/**
	 *  This function verifies related list is present {Ex: verify NOTES related list is present}
	 *  @author Swapna
	 */
	public void verifyRelatedListPresent(String relatedListName){
		By RelatedList = By.xpath("//span[text()='"+relatedListName+"']");
		Utility_Functions.xScrollWindowTop(driver);
		Utility_Functions.xScrollWindow(driver);
		int count = driver.findElements(RelatedList).size();
		
		if(count!=0){
			System.out.println("Related list "+relatedListName+" is present in the Related page" );
			report.updateTestLog("Verify related list in the Related Page ",
					"Related list "+relatedListName+" is present in the Related page", Status.PASS);
		}else {
			System.out.println("Related list "+relatedListName+" is not present in the Related page");
			report.updateTestLog("Verify related list in the Related Page ",
					"Related list "+relatedListName+" is not present in the Related page", Status.PASS);
		}
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
		Utility_Functions.timeWait(2);
	}

	/**
	 * Select Record Type radio button out of multiple radio buttons
	 * 
	 * @author Vishnuvardhan
	 *
	 */

	public void selectRecordTypeRadioButton(String radioBtnName) {
		By recordTypeRadioBtn = By.xpath("//div[contains(@class,'changeRecordTypeLeftRightContent')]//span[text()='"+radioBtnName+"']/parent::div/parent::label//span[@class='slds-radio--faux']");
		Utility_Functions.xWaitForElementPresent(driver, recordTypeRadioBtn, 4);
		Utility_Functions.xClick(driver, driver.findElement(recordTypeRadioBtn), true);
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
		By ButtonName = By.xpath("//span[text()='"+buttonName+"']/parent::button");
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
		By ButtonName = By.xpath("(//div[text()='"+buttonName+"']/parent::a)[1]");
		By MoreAction = By.xpath("(//span[text()='Show more actions']/ancestor::a)[1]");
		try{
		    driver.findElement(ButtonName).click();
		}catch(Exception e){
			driver.findElement(MoreAction).click();
			driver.findElement(ButtonName).click();
		}
		Utility_Functions.timeWait(2);
	}

	/**
	 * Select a button from the related list 
	 * 
	 * @author Swapna
	 *
	 */
	public void selectRelatedListsButton(String RelatedListName, String ButtonName) {
		By buttonName = By.xpath("//span[text()='"+RelatedListName+"']/ancestor::header/following-sibling::div//*[text()='"+ButtonName+"']");
		Utility_Functions.xScrollWindowTop(driver);
		Utility_Functions.xScrollWindowToElement(driver, driver.findElement(buttonName));
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
	 * returns the Standard New or Edit popup title[Ex: 'Edit New Contact: ABBport' title from popup]
	 * 
	 * @author Swapna
	 * @return 
	 *
	 */
	public WebElement getStdPopupTitle(String titleText) { 
		By TextTitle= By.xpath("//h2[contains(text(),'"+titleText+"')]");
		Utility_Functions.xScrollWindowTop(driver);
		Utility_Functions.xWaitForElementPresent(driver, TextTitle, 5);
		return driver.findElement(TextTitle);
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
	
	/**  
     * @Description : This method will verify array of elements present under a Section {Ex: Fields under 'Opportunity Information' section on a page}
     * @author Swapna
    */
    
	public void verifyElementsArePresentInSection(String SectionName,List<String> listValues) throws Exception{
          List<String> actualElementNames = new ArrayList<String>();
          Utility_Functions.xScrollWindowTop(driver);
          WebElement Field = null;
          try{ 
        	  for(int i =0;i<listValues.size();i++){ 
        		  String FieldName = listValues.get(i);
        		  By Field_Under_SectionInPopup =By.xpath("//span[text()='"+SectionName+"']/parent::h3/following-sibling::div//span[string-length(text()) > 0 and text()='"+FieldName+"']");
        		  By Field_Under_SectionInDetail =By.xpath("//span[text()='"+SectionName+"']/ancestor::h3/following-sibling::div//span[string-length(text()) > 0 and text()='"+FieldName+"']");
        		  try{
        			  Field =  driver.findElement(Field_Under_SectionInPopup);
        		  }catch(Exception e){
        			  Field =  driver.findElement(Field_Under_SectionInDetail);
        	      }
        		  Utility_Functions.xScrollWindowToElement(driver,Field);
                  actualElementNames.add(Field.getText());
             }
                  Object[] actualEleNames = actualElementNames.toArray();
                  Object[] ExpectedNames = listValues.toArray();
                       
                  Assert.assertEqualsNoOrder(actualEleNames, ExpectedNames);
                 System.out.println("Verified actual Field Name : "+actualElementNames+ " with expected Name : "+listValues+" ::::passed");
          }catch (Exception e) {
              e.printStackTrace();
              System.out.println("[ Error on finding Field Name under Section : "+  SectionName+" ] " +e.getMessage());
           }
    }


	
	
	
	/**
	 * Validate the fields section under the header in the page layout
	 * 
	 * @author Vishnuvardhan
	 *
	 */
	
	public void validateHeaderSectionFields(List<String> FieldsList, List<WebElement> WebElementsList, String Text) {
		List<String> fieldsCount = Utility_Functions.xValidateFieldsPresentonPage(FieldsList, WebElementsList, Text);
		if(fieldsCount.size()==0) {
			report.updateTestLog("Fields List", Text + " header section is having all fields present::", Status.PASS);
		} else {
			report.updateTestLog("Fields List", Text + " header section is having all fields present::", Status.FAIL);
		}
	}
	
	/**
	 * Handling the Stale Element exception
	 *
	 * @author Ramya
	 *
	 */

	public void staleElementHandle(WebElement element) {
		int count = 0;
		boolean clicked = false;
		try {
			while (count < 4 || !clicked) {
				element.click();
				clicked = true;
			}
		} catch (StaleElementReferenceException e) {
			e.toString();
			System.out.println("Trying to recover from a stale element :" + e.getMessage());
			count = count + 1;
		}
	}
	
	/** 
	 * @throws Exception 
	 * @Description: This method opens the detail page of the specified object in lightening view
	 * @Author     : Swapna
	 */
	public void openDetailPage(String testObjectId) throws Exception {
		try{ 
			Utility_Functions.timeWait(2);
			String curentUrl = driver.getCurrentUrl();
			URL url = new URL(curentUrl);
			String base  = url.getAuthority();
			String serverUrl = curentUrl.substring(0,curentUrl.indexOf(base) + base.length());
			String fullUrl = serverUrl + "/" + testObjectId;
			driver.get(fullUrl);
			Utility_Functions.timeWait(2);	
		}catch (Exception e) {
			e.printStackTrace();
			System.out.println("Not able to open detail page with ID ["+testObjectId+"] " +e.getMessage());
		}
	}
	
	/**
	 * Returns the picklist values when we pass the object name, record type and picklist value
	 *
	 * @author Vishnuvardhan
	 *
	 */
	
	public List<String> getPickListValues(String ObjectName, String RecordType, String PickListName) {
		EstablishConnection establishConnection = new EstablishConnection(scriptHelper);
		List<String> pickListValues = establishConnection.establishMetaDataConnection(ObjectName, RecordType, PickListName);
		return pickListValues;
	}
	
	
	/**
	 * Validates the picklist value from the passed pick list in Properties, Project Enquiries and Property Enquiries 
	 *
	 * @author Vishnuvardhan
	 *
	 */
	
	public void verifyPickListValues(String Value, String ObjectName, String RecordType, String PickListName) {
		int count=0;
		List<String> PickListValues = getPickListValues(ObjectName, RecordType, PickListName);
		for(int i=0; i < PickListValues.size(); i++) {
			if(PickListValues.get(i).equals(Value)) {
				count++;
				break;
			}
				
		}
		if (count==1) {
			report.updateTestLog("Verify picklist value", "Pick list value:: " + Value + "is present in the Area UOM Pick List::: " + PickListName, Status.PASS);
		} else {
			report.updateTestLog("Verify picklist value", "Pick list value:: " + Value + "is not present in the Area UOM Pick List::: " + PickListName, Status.FAIL);
		}		
	}
	
	/**
	 * This method selects checkbox on Standard Popup
	 * @author Swapna
	 */
	public void selectCheckBox(String checkBoxFieldName){
	  By checkBox = By.xpath("//span[text()='"+checkBoxFieldName+"']/following-sibling::span");
	   try{ 
		    Utility_Functions.xWaitForElementPresent(driver, checkBox, 3);
			//Utility_Functions.scrollToViewElementAndClick(driver.findElement(checkBox));
			driver.findElement(checkBox).click();
			Utility_Functions.timeWait(1);
		}catch (Exception e) {
			e.printStackTrace();
			System.out.println("Not able to Select Lightning CheckBoxField ["+checkBoxFieldName+"] "+e.getMessage());
		}
	}
	
}
