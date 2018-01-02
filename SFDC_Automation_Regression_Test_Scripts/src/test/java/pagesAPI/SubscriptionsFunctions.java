package pagesAPI;

import java.util.Calendar;
import java.util.Random;

import org.openqa.selenium.support.PageFactory;

import com.cognizant.Craft.ReusableLibrary;
import com.cognizant.Craft.ScriptHelper;
import com.cognizant.framework.Status;
import com.sforce.soap.partner.DeleteResult;
import com.sforce.soap.partner.SaveResult;
import com.sforce.soap.partner.sobject.SObject;
import com.sforce.ws.ConnectionException;

import supportLibraries.Utility_Functions;

public class SubscriptionsFunctions extends ReusableLibrary {
	/*
	 * Constructor to initialize the business component library
	 * 
	 * @param scriptHelper The {@link ScriptHelper} object passed from the
	 * {@link DriverScript}
	 */

	public SubscriptionsFunctions(ScriptHelper scriptHelper) {
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
	ContactsFunctions contactsFunctions = new ContactsFunctions(scriptHelper);
	LeadsFunctions leadsFunctions = new LeadsFunctions(scriptHelper);
	SearchTextSOQL searchTextSOQL = new SearchTextSOQL(scriptHelper);
	int offsetValue = new Random().nextInt(9);
	
	/**
	 * Function for the creation of Subscription
	 * 
	 * @author Vishnuvardhan
	 *
	 */ 

	public String createSubscriptions() {
		establishConnection.establishConnection();
		SObject subscription = new SObject();
		subscription.setType("APAC_Subscriptions__c");
		String sMarketingListId = createMarketing();
		subscription.setField("APAC_Publication_Name__c", sMarketingListId);
		String contactQuery = "Select Id from Contact ORDER BY CreatedDate DESC"  + " limit 1 offset " + offsetValue;
		String sContactId = searchTextSOQL.fetchRecordFieldValue("Id", contactQuery);
		subscription.setField("APAC_Contact__c	", sContactId);
		subscription.setField("APAC_Status__c", "Opt In");
		//subscription.setField("APAC_Opt_Out_Reason__c", "--None--");
		SObject[] subscriptions = new SObject[1];
		subscriptions[0] = subscription;
		try {
			results = EstablishConnection.connection.create(subscriptions);
			System.out.println(results);
		} catch (ConnectionException e) {			
			e.printStackTrace();
		}
		System.out.println("Result:::" + results);
		String sSubscriptionId = establishConnection.saveResultsId(results);
		if(sSubscriptionId.startsWith("a2A")) {
			report.updateTestLog("Verify Create Subscription", "Subscription has been created successfully", Status.PASS);
		} else {
			report.updateTestLog("Verify Create Subscription", "Subscription creation failed", Status.FAIL);
		}
		return sSubscriptionId;
	}		
	
	/**
	 * Function for the creation of Marketing
	 * 
	 * @author Vishnuvardhan
	 *
	 */ 

	public String createMarketing() {
		establishConnection.establishConnection();
		SObject marketing = new SObject();
		marketing.setType("APAC_Publication__c");
		marketing.setField("Name", "Test Marketing" + Utility_Functions.xGenerateAlphaNumericString());
		marketing.setField("APAC_Status__c", "Current");
		marketing.setField("APAC_Publication_Due_Date__c", Calendar.getInstance());
		String contactQuery = "Select Id from Contact ORDER BY CreatedDate DESC"  + " limit 1 offset " + offsetValue;
		String sContactId = searchTextSOQL.fetchRecordFieldValue("Id", contactQuery);
		marketing.setField("APAC_Author__c", sContactId);	
		SObject[] marketings = new SObject[1];
		marketings[0] = marketing;
		try {
			results = EstablishConnection.connection.create(marketings);
			System.out.println(results);
		} catch (ConnectionException e) {			
			e.printStackTrace();
		}
		System.out.println("Result:::" + results);
		String sMarketingId = establishConnection.saveResultsId(results);
		if(sMarketingId.startsWith("a1h")) {
			report.updateTestLog("Verify Create Marketing", "Marketing has been created successfully", Status.PASS);
		} else {
			report.updateTestLog("Verify Create Marketing", "Marketing creation failed", Status.FAIL);
		}
		return sMarketingId;
	}	
	
}