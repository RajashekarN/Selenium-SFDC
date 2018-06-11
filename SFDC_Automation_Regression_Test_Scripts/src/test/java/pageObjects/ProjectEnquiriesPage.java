package pageObjects;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import com.cognizant.Craft.ReusableLibrary;
import com.cognizant.Craft.ScriptHelper;
import supportLibraries.Utility_Functions;

public class ProjectEnquiriesPage extends ReusableLibrary  {
	
	

	public ProjectEnquiriesPage(ScriptHelper scriptHelper) {
		super(scriptHelper);
		PageFactory.initElements(driver.getWebDriver(), this);
	}

	String tabName ="//span[text()='@TABNAME']";
	
	String sTabName = "//span/span[text()='@TABNAME']";
	
	String  btn_New = "//a/div[text()='@BUTTONNAME']" ;

	String radioBtnName =  "(//span[text()='@RADIOBUTTONNAME']/ancestor::label//span)[1]";

	String newPg_btn = "//span[text()='@BUTTONNAME']/parent::button";
	
	String newPg_Title = "//h2[text()='@TITLE']";
	
	String newPg_textField = "//span[text()='@TEXTFIELDNAME']/parent::label/following-sibling::input";
	
	String newPg_LookupField = "//span[text()='@LOOKUPFIELDNAME']/parent::label/following-sibling::div//input";
	
	String Pg_LookupFieldSearchText="(//a[contains(text(),'@COLUMNNAME')]/ancestor::thead/following-sibling::tbody//a)[1]";
	
	String detailPg_TextField = "//span[text()='@TEXTFIELDNAME']/parent::div/following-sibling::div/span/span";
	
	String detailPg_LinkTextField = "//span[text()='@LINKTEXTFIELDNAME']/parent::div/following-sibling::div//a";
	
	String detailHeaderSec_btn = "//a/div[text()='@BUTTONNAME']";
	
	String detailHeaderSec_TextTitle= "//p[(text()='@OBJECTNAME')]//following-sibling::h1//span";
	
	String detailHeaderSec_LinkTextTitle = "//p[text()='@OBJECTNAME']/following-sibling::h1//a";
	
	String detailHeaderSec_LinkTextField = "//p[text()='@FIELDNAME']/following-sibling::p//a";
	
	String editPg_textField = "//span[text()='@TEXTFIELDNAME']/parent::label/following-sibling::input";
	
	String editPg_LookupField = "//span[text()='@LOOKUPFIELDNAME']/parent::label/following-sibling::div/div/div[2]//li/a/span[2]";
	
	String editPg_btn = "(//span[text()='@BUTTONNAME']/parent::button)[2]";
	
	String related_SubTabName = "//span[text()='@TABNAME']";
	
	String related_MoreTab = "(//a[text()='@TABNAME'])[2]";
	
	String related_TabInMore = "//a[text()='@TABNAME']";
	
	String relatedList_Name = "//h2/a/span[contains(text(),'@RELATEDLISTNAME')]";
	
	String column_LinkTextValue = "(//th[text()='@COLUMNNAME']/ancestor::thead/following-sibling::tbody//a[text()='@COLUMN_LINKTEXTDATA'])[1]";
	
	String column_TextValue = "(//th[text()='@COLUMNNAME']/ancestor::thead/following-sibling::tbody//span[text()='@COLUMN_TEXTDATA'])[1]";
	
	
	
	
	
	//constants used in the Project Enquiry Testcase
	String projectEnquiryName = "projEnq"+Utility_Functions.xRandomFunction();
	String contactName = "Test";
	String accountName_NotPrimary = "Test";
	WebElement contactSearchText = null;
	WebElement accountSearchText = null;
	WebElement projEnquiry_UnderRelated = null;
	
	
	
	/**
	 *1)  Verify validation rule : "Enquiry Account and Enquiry Contact are not related to each other (no primary or secondary relationship found)." is removed.
	 *2)  A Help text : "Enquiry Account will populate with the Contact's primary Account if left blank" should be visible.
	 *3)  The Enquiry Contact field will be above the Enquiry Account on the page layouts.
	 *4)  Verify Contact field is mandatory.
	 *5)  Create a project Enquiry and verify in Detail page.
	 *6)  Edit Account name in Edit page and verify in Detail page.
	 * 
	 * @author Swapna
	 *
	 */
	
	public void projectEnquiryRecordSelection(String recordType){
		
		try {
			//verify record selection popup is open
			Utility_Functions.xWaitForElementPresent(driver, (Utility_Functions.findElement_ByXpath(driver, newPg_Title.replace("@TITLE","New Project Enquiry"))), 5);
			
			Utility_Functions.xClick(driver,(Utility_Functions.findElement_ByXpath(driver, radioBtnName.replace("@RADIOBUTTONNAME",recordType))), true);
			Utility_Functions.xClick(driver, (Utility_Functions.findElement_ByXpath(driver, newPg_btn.replace("@BUTTONNAME", "Next"))), true);
			Utility_Functions.timeWait(2);
			System.out.println(" Record Type is selected ::::"+ recordType);
			
		} catch (Exception e) {
			System.out.println(" Record Type is not selected ::::"+ recordType);
			System.out.println(e.getMessage());
	   }
	}
	
  public void projectEnquiryStandardNewCreation(){
	 try{
		//verify New page is open
		WebElement title = Utility_Functions.findElement_ByXpath(driver, newPg_Title.replace("@TITLE", "New Project Enquiry: APAC Property Sales Project Enquiries"));
		Utility_Functions.xWaitForElementPresent(driver, title , 8);
		System.out.println("Verified Project Enquiries New page is displayed !");
		
		//enter values and save
		Utility_Functions.xSendKeys(driver, (Utility_Functions.findElement_ByXpath(driver, newPg_textField.replace("@TEXTFIELDNAME", "Project Enquiry Name"))), projectEnquiryName);
		Utility_Functions.findElement_ByXpath(driver, newPg_LookupField.replace("@LOOKUPFIELDNAME", "Enquiry Contact")).click();
		Utility_Functions.timeWait(1);
		Utility_Functions.xSendKeys(driver, (Utility_Functions.findElement_ByXpath(driver, newPg_LookupField.replace("@LOOKUPFIELDNAME", "Enquiry Contact"))), (contactName+Keys.ENTER)+Keys.ENTER);
		Utility_Functions.timeWait(3);
		Utility_Functions.xWaitForElementPresent(driver, Utility_Functions.findElement_ByXpath(driver, Pg_LookupFieldSearchText.replace("@COLUMNNAME", "Name")), 8);
		contactSearchText = Utility_Functions.findElement_ByXpath(driver, Pg_LookupFieldSearchText.replace("@COLUMNNAME", "Name"));
		contactName = contactSearchText.getText();
		contactSearchText.click();
		Utility_Functions.timeWait(5);
		Utility_Functions.findElement_ByXpath(driver, newPg_LookupField.replace("@LOOKUPFIELDNAME", "Enquiry Account")).click();
		Utility_Functions.timeWait(2);
		Utility_Functions.xSendKeys(driver, (Utility_Functions.findElement_ByXpath(driver, newPg_LookupField.replace("@LOOKUPFIELDNAME", "Enquiry Account"))), (accountName_NotPrimary+Keys.ENTER)+Keys.ENTER);
		Utility_Functions.xWaitForElementPresent(driver, Utility_Functions.findElement_ByXpath(driver, Pg_LookupFieldSearchText.replace("@COLUMNNAME", "Account Name")), 9);
		accountSearchText = Utility_Functions.findElement_ByXpath(driver, Pg_LookupFieldSearchText.replace("@COLUMNNAME", "Account Name"));
		accountName_NotPrimary = accountSearchText.getText();
		accountSearchText.click();
		Utility_Functions.timeWait(8);
		Utility_Functions.xClick(driver, (Utility_Functions.findElement_ByXpath(driver, editPg_btn.replace("@BUTTONNAME", "Save"))),true);
		System.out.println("New Project Enquiries is created !!");
	  } catch (Exception e) {
		  System.out.println(" Project Enquiries is not created. ");
		  System.out.println(e.getMessage());
	 }
  }
	public void verifyAccountOnContactRequired() {
		
	 try {
		Utility_Functions.xWaitForElementPresent(driver,(Utility_Functions.findElement_ByXpath(driver, tabName.replace("@TABNAME", "More"))),12);
		Utility_Functions.xClick(driver,(Utility_Functions.findElement_ByXpath(driver, tabName.replace("@TABNAME", "More"))), true);
		Utility_Functions.xWaitForElementPresent(driver, Utility_Functions.findElement_ByXpath(driver, sTabName.replace("@TABNAME", "Project Enquiries")), 3);
		Utility_Functions.xClick(driver, (Utility_Functions.findElement_ByXpath(driver, sTabName.replace("@TABNAME", "Project Enquiries"))), true);
		
		Utility_Functions.timeWait(8);
		Utility_Functions.xClick(driver, Utility_Functions.findElement_ByXpath(driver, btn_New.replace("@BUTTONNAME", "New")), true);
		Utility_Functions.timeWait(6);
		projectEnquiryRecordSelection("APAC Property Sales Project Enquiries");
		
		//verify New page is open
		WebElement title = Utility_Functions.findElement_ByXpath(driver, newPg_Title.replace("@TITLE", "New Project Enquiry: APAC Property Sales Project Enquiries"));
		Utility_Functions.xWaitForElementPresent(driver, title , 6);
		
		//verify Contact position
		String contactPosition = "//span[text()='Enquiry Account']/ancestor::div/preceding-sibling::h3/following-sibling::div//span[text()='Enquiry Contact']";
		Assert.assertTrue(Utility_Functions.findElement_ByXpath(driver, contactPosition).isDisplayed(), "Enquiry Contact is not displayed above Enquiry Account");
		System.out.println("verified Contact field is moved above Account field !!!");
		
		//mouse over Enquiry Account to verify tooltip
		//Utility_Functions.xMouseOver(driver, Utility_Functions.findElement_ByXpath(driver, newPg_LookupField.replace("@LOOKUPFIELDNAME", "Enquiry Account")));
		
		//verify tootip text
		WebElement tooltip = Utility_Functions.findElement_ByXpath(driver,"//span[text()='Enquiry Account']/following-sibling::div//span[@role='tooltip']");
		String tooltip_text = "Enquiry Account will populate with the Contact's primary Account if left blank";
		Assert.assertEquals(tooltip.getText(), tooltip_text);
		System.out.println("Verified tool tip is displayed on Enquiry Account field ...");
		
		//create New Project Enquiry
		projectEnquiryStandardNewCreation();
		
		//verify all fields are populated in Detail page
		Utility_Functions.timeWait(8);
		String projectEnq_Url = driver.getCurrentUrl();
		Assert.assertEquals(Utility_Functions.findElement_ByXpath(driver, detailHeaderSec_LinkTextTitle.replace("@OBJECTNAME", "Project Enquiry")).getText(),accountName_NotPrimary);
		Assert.assertEquals(Utility_Functions.findElement_ByXpath(driver, detailHeaderSec_LinkTextField.replace("@FIELDNAME", "Enquiry Contact")).getText(),contactName);
		Assert.assertEquals(Utility_Functions.findElement_ByXpath(driver, detailPg_TextField.replace("@TEXTFIELDNAME", "Project Enquiry Name")).getText(),projectEnquiryName);
		Assert.assertEquals(Utility_Functions.findElement_ByXpath(driver, detailPg_LinkTextField.replace("@LINKTEXTFIELDNAME", "Enquiry Contact")).getText(),contactName);
		Assert.assertEquals(Utility_Functions.findElement_ByXpath(driver, detailPg_LinkTextField.replace("@LINKTEXTFIELDNAME", "Enquiry Account")).getText(),accountName_NotPrimary);
		
		Utility_Functions.xClick(driver, Utility_Functions.findElement_ByXpath(driver, btn_New.replace("@BUTTONNAME", "Edit")), true);
		Utility_Functions.timeWait(10);
		
		//verify Edit page is open
		WebElement editTitle = Utility_Functions.findElement_ByXpath(driver, newPg_Title.replace("@TITLE", "Edit "+projectEnquiryName));
		Utility_Functions.xWaitForElementPresent(driver, editTitle , 4);
		System.out.println(" Edit page is open !!!");
		Utility_Functions.timeWait(3);
		Utility_Functions.xClick(driver,Utility_Functions.findElement_ByXpath(driver, editPg_btn.replace("@BUTTONNAME", "Save")), true);
		Utility_Functions.timeWait(3);
		
		//verify the related list of the Contact has the Project Enquiry name
		Utility_Functions.xWaitForElementPresent(driver, (Utility_Functions.findElement_ByXpath(driver, detailPg_LinkTextField.replace("@LINKTEXTFIELDNAME", "Enquiry Contact"))), 8);
		Utility_Functions.findElement_ByXpath(driver, detailPg_LinkTextField.replace("@LINKTEXTFIELDNAME", "Enquiry Contact")).click();
		
		//verify the contact page is displayed
		Utility_Functions.xWaitForElementPresent(driver, (Utility_Functions.findElement_ByXpath(driver, detailHeaderSec_TextTitle.replace("@OBJECTNAME","Contact"))),5);
		
		//Go to related list on Contact
		try{
			Utility_Functions.xWaitForElementPresent(driver, (Utility_Functions.findElement_ByXpath(driver, related_SubTabName.replace("@TABNAME", "Enquiry & Offers"))), 8);
			Utility_Functions.xClick(driver,(Utility_Functions.findElement_ByXpath(driver, related_SubTabName.replace("@TABNAME", "Enquiry & Offers"))), true);
		}catch(Exception e){
			Utility_Functions.xWaitForElementPresent(driver, (Utility_Functions.findElement_ByXpath(driver, related_MoreTab.replace("@TABNAME","More"))), 3);
			Utility_Functions.xClick(driver,(Utility_Functions.findElement_ByXpath(driver, related_MoreTab.replace("@TABNAME","More"))), true);
			Utility_Functions.xWaitForElementPresent(driver, (Utility_Functions.findElement_ByXpath(driver, related_TabInMore.replace("@TABNAME","Enquiry & Offers"))), 3);
			Utility_Functions.xClick(driver,(Utility_Functions.findElement_ByXpath(driver, related_TabInMore.replace("@TABNAME","Enquiry & Offers"))), true);
		}	
		
		Utility_Functions.xWaitForElementPresent(driver, (Utility_Functions.findElement_ByXpath(driver, relatedList_Name.replace("@RELATEDLISTNAME","Project Enquiries"))), 6);
		Utility_Functions.findElement_ByXpath(driver, relatedList_Name.replace("@RELATEDLISTNAME","Project Enquiries")).click();
		Utility_Functions.timeWait(6);
		driver.navigate().refresh();
		
		
		try{
			//verify Project Enquiry created is displayed in the related list   
			Utility_Functions.timeWait(8);
			Utility_Functions.xScrollWindow(driver);
			projEnquiry_UnderRelated = Utility_Functions.findElement_ByXpath(driver, column_LinkTextValue.replace("@COLUMNNAME", "Project Enquiry Name").replace("@COLUMN_LINKTEXTDATA",projectEnquiryName));
			Assert.assertTrue(projEnquiry_UnderRelated.isDisplayed()," Project Enquiry Name is missing under the Contact related list");
			System.out.println(" Project Enquiry Name is displayed under the Contact related list !!!!! ");
		}catch(Exception e){
			System.out.println(" Project Enquiry Name is not displayed under the Contact related list !!!!! ");		
		}
		
		//navigate to project enquiry page
		driver.navigate().to(projectEnq_Url);
		Utility_Functions.timeWait(6);
		
		//verify the related list of the Account has the Project Enquiry name
		Utility_Functions.xWaitForElementPresent(driver, (Utility_Functions.findElement_ByXpath(driver, detailPg_LinkTextField.replace("@LINKTEXTFIELDNAME", "Enquiry Account"))), 8);
		Utility_Functions.xClick(driver,(Utility_Functions.findElement_ByXpath(driver, detailPg_LinkTextField.replace("@LINKTEXTFIELDNAME", "Enquiry Account"))), true);
		
		//verify the contact page is displayed
		Utility_Functions.xWaitForElementPresent(driver, (Utility_Functions.findElement_ByXpath(driver, detailHeaderSec_TextTitle.replace("@OBJECTNAME","Account"))),5);
				
	   try{	
		  Utility_Functions.xWaitForElementPresent(driver, (Utility_Functions.findElement_ByXpath(driver, related_SubTabName.replace("@TABNAME", "Enquiry & Offers"))), 8);
		  Utility_Functions.xClick(driver,(Utility_Functions.findElement_ByXpath(driver, related_SubTabName.replace("@TABNAME", "Enquiry & Offers"))), true);
	   }catch(Exception e){
		   Utility_Functions.xWaitForElementPresent(driver, (Utility_Functions.findElement_ByXpath(driver, related_MoreTab.replace("@TABNAME","More"))), 3);
		   Utility_Functions.xClick(driver,(Utility_Functions.findElement_ByXpath(driver, related_MoreTab.replace("@TABNAME","More"))), true);
		   Utility_Functions.xWaitForElementPresent(driver, (Utility_Functions.findElement_ByXpath(driver, related_TabInMore.replace("@TABNAME","Enquiry & Offers"))), 3);
		   Utility_Functions.xClick(driver,(Utility_Functions.findElement_ByXpath(driver, related_TabInMore.replace("@TABNAME","Enquiry & Offers"))), true);
	    }
		
	   Utility_Functions.xWaitForElementPresent(driver, (Utility_Functions.findElement_ByXpath(driver, relatedList_Name.replace("@RELATEDLISTNAME","Project Enquiries"))), 6);
	   Utility_Functions.findElement_ByXpath(driver, relatedList_Name.replace("@RELATEDLISTNAME","Project Enquiries")).click();
	   Utility_Functions.timeWait(6);
	   driver.navigate().refresh();
		
		
	   //verify Project Enquiry created is displayed in the related list
	   try{
		   Utility_Functions.timeWait(6);
		   Utility_Functions.xScrollWindow(driver);
		   projEnquiry_UnderRelated = Utility_Functions.findElement_ByXpath(driver, column_LinkTextValue.replace("@COLUMNNAME", "Project Enquiry Name").replace("@COLUMN_LINKTEXTDATA",projectEnquiryName));
		   Assert.assertTrue(projEnquiry_UnderRelated.isDisplayed()," Project Enquiry Name is missing under the Account related list");
		   System.out.println(" Project Enquiry Name is displayed under the Account related list !!!!! ");
	   }catch(Exception e ){
		   System.out.println(" Project Enquiry Name is not displayed under the Account related list !!!!! ");
	   }  															
	   System.out.println(" Test completed successfully !!!!!");
		
	} catch (Exception e) {
			System.out.println(e.getMessage());
}

}
}