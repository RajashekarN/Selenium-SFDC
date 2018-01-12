package pagesAPI;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import com.cognizant.Craft.ReusableLibrary;
import com.cognizant.Craft.ScriptHelper;
import com.sforce.soap.partner.DeleteResult;
import com.sforce.soap.partner.SaveResult;
import com.sforce.soap.partner.sobject.SObject;

import supportLibraries.Utility_Functions;

public class ActivityFunctions extends ReusableLibrary {
	/*
	 * Constructor to initialize the business component library
	 * 
	 * @param scriptHelper The {@link ScriptHelper} object passed from the
	 * {@link DriverScript}
	 */

	public ActivityFunctions(ScriptHelper scriptHelper) {
		super(scriptHelper);
	}

	static SaveResult[] results;
	static DeleteResult[] deleteResults;
	static com.sforce.soap.partner.Error[] errors;
	static boolean status = false;
	
	EstablishConnection establishConnection = new EstablishConnection(scriptHelper);
	
	/**
	 * Function for the creation of an Activity
	 * 
	 * @author Vishnuvardhan
	 *
	 */
	public boolean createActivity() {
		try {
			Calendar calendar = Calendar.getInstance();
			calendar.add(Calendar.DAY_OF_MONTH, 10);
			
			
			SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy hh:mm a");
			System.out.println("Date : " + dateFormat.format(calendar.getTime()));
			
			establishConnection.establishConnection();
			SObject activity = new SObject();

			activity.setType("Activity");
			SearchTextSOQL AccountId = new SearchTextSOQL(scriptHelper);
			String accountId = AccountId.fetchRecord("Account", "Id");
			activity.setField("AccountId", accountId);
			String value = Utility_Functions.xGenerateAlphaNumericString();
			activity.setField("Subject", value + "Test Automation");
			activity.setField("ActivityType", "Private - Follow-Up Task");
			activity.setField("DueDate", dateFormat.format(calendar.getTime()));
			
			SObject[] activities = new SObject[1];
			activities[0] = activity;
			results = EstablishConnection.connection.create(activities);
			System.out.println("Result:::" + results);
			status = establishConnection.saveResults(results);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return status;
	}
	
	/**
	 * Function for the creation of an Activity for Opportunity
	 * 
	 * @author Vishnuvardhan
	 *
	 */
	
	public boolean createActivityForOpportunity() {
		try {
			Calendar calendar = Calendar.getInstance();
			//calendar.add(Calendar.DAY_OF_MONTH, 10);
			
			SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'");
			//SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy hh:mm a");
			System.out.println("Date : " + dateFormat.format(calendar.getTime()));
			
			establishConnection.establishConnection();
			SObject activity = new SObject();

			activity.setType("Activity__c");
			SearchTextSOQL OpportunityID = new SearchTextSOQL(scriptHelper);
			String accountId = OpportunityID.fetchRecord("Opportunity", "Id");
			activity.setField("Opportunity__c", accountId);
			String value = Utility_Functions.xGenerateAlphaNumericString();
			activity.setField("Subject__c", value + "Test Automation");
			//activity.setField("ActivityType__c", "Private - Follow-Up Task");
			activity.setField("DueDate__c", dateFormat.format(calendar.getTime()));
			
			SObject[] activities = new SObject[1];
			activities[0] = activity;
			results = EstablishConnection.connection.create(activities);
			System.out.println("Result:::" + results);
			status = establishConnection.saveResults(results);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return status;
	}

}