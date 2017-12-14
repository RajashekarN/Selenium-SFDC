package pagesAPI;

import org.openqa.selenium.support.PageFactory;

import com.cognizant.Craft.ReusableLibrary;
import com.cognizant.Craft.ScriptHelper;
import com.cognizant.framework.Status;
import com.sforce.soap.partner.DeleteResult;
import com.sforce.soap.partner.SaveResult;
import com.sforce.soap.partner.sobject.SObject;
import com.sforce.ws.ConnectionException;

import supportLibraries.Utility_Functions;

public class Tagging extends ReusableLibrary {
	/*
	 * Constructor to initialize the business component library
	 * 
	 * @param scriptHelper The {@link ScriptHelper} object passed from the
	 * {@link DriverScript}
	 */

	public Tagging(ScriptHelper scriptHelper) {
		super(scriptHelper);
		PageFactory.initElements(driver.getWebDriver(), this);
		// new WebDriverUtil(driver);
		// Utility_Functions utility = new Utility_Functions(scriptHelper);
	}

	static SaveResult[] results;
	static DeleteResult[] deleteResults;
	static com.sforce.soap.partner.Error[] errors;
	static boolean status = false;

	EstablishConnection establishConnection = new EstablishConnection(scriptHelper);

	/**
	 * Function for the creation of private tag to an account
	 * 
	 * @author Vishnuvardhan
	 *
	 */ 

	public boolean createPrivateTag() {
		establishConnection.establishConnectionSpecificUser();
		SObject privateTag = new SObject();
		privateTag.setType("Private_Tag_with_Account__c");
		SearchTextSOQL accountID = new SearchTextSOQL(scriptHelper);
		String accountName = accountID.fetchRecord("Account", "Id");
		privateTag.setField("CustomPrivateTagRelatedTo__c", Utility_Functions.xGenerateAlphaNumericString() + "Automation");
		privateTag.setField("AccountRelatedTo__c", accountName);
		SObject[] privateTags = new SObject[1];
		privateTags[0] = privateTag;
		try {
			results = EstablishConnection.connection.create(privateTags);
		} catch (ConnectionException e) {
			e.printStackTrace();
		}
		System.out.println("Result:::" + results);
		status = establishConnection.saveResults(results);
		if(status==true) {
			report.updateTestLog("Verify Create Private Tag", "Private Tag for Account has been created successfully", Status.PASS);
		} else {
			report.updateTestLog("Verify Create Private Tag", "Private Tag for Account creation failed", Status.FAIL);
		}
		return status;
	}
}