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

public class TaskEventsFunctions extends ReusableLibrary {
	/*
	 * Constructor to initialize the business component library
	 * 
	 * @param scriptHelper The {@link ScriptHelper} object passed from the
	 * {@link DriverScript}
	 */

	public TaskEventsFunctions(ScriptHelper scriptHelper) {
		super(scriptHelper);
		PageFactory.initElements(driver.getWebDriver(), this);
		// new WebDriverUtil(driver);
		// Utility_Functions utility = new Utility_Functions(scriptHelper);
	}
	public static String leadId;
	public static String accountId;
	static SaveResult[] results;
	static DeleteResult[] deleteResults;
	static com.sforce.soap.partner.Error[] errors;
	static boolean status = false;

	EstablishConnection establishConnection = new EstablishConnection(scriptHelper);
	AccountsFunctions accountsFunctions = new AccountsFunctions(scriptHelper);
	ContactsFunctions contactsFunctions = new ContactsFunctions(scriptHelper);
	OpportunitiesFunctions opportunitiesFunctions = new OpportunitiesFunctions(scriptHelper);
	LeadsFunctions leadsFunctions = new LeadsFunctions(scriptHelper);
	SearchTextSOQL searchTextSOQL = new SearchTextSOQL(scriptHelper);
	int offsetValue = new Random().nextInt(9);

	/**
	 * Function for the creation of an Task
	 * 
	 * @author Vishnuvardhan
	 *
	 */
	Calendar calendar = Calendar.getInstance();

	public String createTask() {
		establishConnection.establishConnection();
		SObject task = new SObject();
		/*SObject taskPast = new SObject();
		SObject taskFuture = new SObject();*/
		task.setType("Task");
		String queryAccountID = "SELECT Id FROM Account ORDER BY CreatedDate DESC"  + " limit 1 offset " + offsetValue;
		String queryContactID = "SELECT Id FROM Contact ORDER BY CreatedDate DESC"  + " limit 1 offset " + offsetValue;
		String queryOpportunityID = "SELECT Id FROM Opportunity ORDER BY CreatedDate DESC"  + " limit 1 offset " + offsetValue;
		//String queryLeadID = "SELECT Id FROM Lead ORDER BY CreatedDate DESC"  + " limit 1 offset " + offsetValue;

		String sAccountID = searchTextSOQL.fetchRecordFieldValue("Id", queryAccountID);
		String sContactID = searchTextSOQL.fetchRecordFieldValue("Id", queryContactID);
		String sOpportunityID = searchTextSOQL.fetchRecordFieldValue("Id", queryOpportunityID);
		//String sLeadID = searchTextSOQL.fetchRecordFieldValue("Id", queryLeadID);	
		String sNewLeadID = null;
		
		String value = Utility_Functions.xGenerateAlphaNumericString();
		task.setField("Subject", value + "Test Automation "+"Present");
		task.setField("Type", "Private - Initial Meeting");
		//Calendar calendar = Calendar.getInstance();
		//calendar.add(Calendar.DATE,-1);
		task.setField("ActivityDate", calendar.getTime());
		/*if(dataTable.getData("General_Data", "TC_ID").contains("Activity")){
			
			taskPast.setType("Task");
			
			taskFuture.setType("Task");
			taskPast.setField("Subject", value + "Test Automation "+"Past");
			taskPast.setField("Type", "Private - Initial Meeting");
			calendar.add(Calendar.DATE,-1);
			taskPast.setField("ActivityDate", calendar.getTime());
			
			taskFuture.setField("Subject", value + "Test Automation "+"Future");
			taskFuture.setField("Type", "Private - Initial Meeting");
			Calendar calendar1 = Calendar.getInstance();
			calendar1.add(Calendar.DATE,1);
			taskFuture.setField("ActivityDate", calendar1.getTime());
		}*/
		if(dataTable.getData("General_Data", "TC_ID").contains("Account"))  {
			task.setField("WhoId", sContactID);
			task.setField("WhatId", sAccountID);
			accountId=sAccountID;
			/*if(dataTable.getData("General_Data", "TC_ID").contains("Activity")){
				taskPast.setField("WhoId", sContactID);
				taskFuture.setField("WhoId", sContactID);
				taskPast.setField("WhatId", sAccountID);
				taskFuture.setField("WhatId", sAccountID);
			}*/
		} else if(dataTable.getData("General_Data", "TC_ID").contains("Opportunity")) {
			task.setField("WhoId", sContactID);
			task.setField("WhatId", sOpportunityID);
		} else if(dataTable.getData("General_Data", "TC_ID").contains("Contact")) {
			task.setField("WhatId", sAccountID);	
			task.setField("WhoId", sContactID);
		} else if (dataTable.getData("General_Data", "TC_ID").contains("Lead")) {
			sNewLeadID = leadsFunctions.createNewLead(); 
			task.setField("WhoId", sNewLeadID);
		}
		SObject[] tasks = new SObject[1];
		tasks[0] = task;
/*		if(dataTable.getData("General_Data", "TC_ID").contains("Activity")){
			tasks[1]=taskPast;
			tasks[2]=taskFuture;
		}*/
		try {
			results = EstablishConnection.connection.create(tasks);
		} catch (ConnectionException e) {
			e.printStackTrace();
		}
		System.out.println("Result:::" + results);
		String status = establishConnection.saveResultsId(results);	
		if(status.startsWith("00T")) {
			report.updateTestLog("Verify Create Task", "Task has been created successfully", Status.PASS);
		} else {
			report.updateTestLog("Verify Create Task", "Task creation failed", Status.FAIL);
		}
		int count=0;
		String leadQuery = "Select WhoId from Task where Id = " + "'" + status + "'";
		String accountQuery = "Select Account__c from Task where Id = " + "'" + status + "'";
		String whatIdQuery = "Select WhatId from Task where Id = " + "'" + status + "'";
		String whatIdValue = searchTextSOQL.fetchRecordFieldValue("WhatId", whatIdQuery);
		if(dataTable.getData("General_Data", "TC_ID").contains("Account"))  {
			String objectValue = searchTextSOQL.fetchRecordFieldValue("Account__c", accountQuery);
			if((objectValue.equals(sAccountID)) && (whatIdValue !=null)) {
				count++;
			}
		} else if(dataTable.getData("General_Data", "TC_ID").contains("Opportunity")) {
			if(whatIdValue.equals(sOpportunityID)) {
				count++;
			}
		} else if(dataTable.getData("General_Data", "TC_ID").contains("Contact")) {
			String objectValue = searchTextSOQL.fetchRecordFieldValue("WhoId", leadQuery);
			if((objectValue.equals(sContactID)) && (whatIdValue != null)) {
				count++;
			}
		} else if (dataTable.getData("General_Data", "TC_ID").contains("Lead")) {
			String objectValue = searchTextSOQL.fetchRecordFieldValue("WhoId", leadQuery);
			if(objectValue.equals(sNewLeadID)) {
				count++;
			}
		}
		if(count==1) 
			report.updateTestLog("Verify Create Task", "Task are created under Accounts/ Contacts/ Opportunities and Leads", Status.PASS);
		else 
			report.updateTestLog("Verify Create Task", "Task are not created under respective objects", Status.FAIL);
		return status;
	}

	/**
	 * Function for the creation of an Event
	 * 
	 * @author Vishnuvardhan
	 *
	 */

	public String createEvent() {
		establishConnection.establishConnection();
		SObject event = new SObject();
		event.setType("Event");
		String value = Utility_Functions.xGenerateAlphaNumericString();
		event.setField("Subject", value + "Test Automation");
		event.setField("Type", "Private - Initial Meeting");
		event.setField("ActivityDate", Calendar.getInstance());
		event.setField("ActivityDateTime", Calendar.getInstance());
		event.setField("DurationInMinutes", 10);
		String queryAccountID = "SELECT Id FROM Account ORDER BY CreatedDate DESC"  + " limit 1 offset " + offsetValue;
		String queryContactID = "SELECT Id FROM Contact ORDER BY CreatedDate DESC"  + " limit 1 offset " + offsetValue;
		String queryOpportunityID = "SELECT Id FROM Opportunity ORDER BY CreatedDate DESC"  + " limit 1 offset " + offsetValue;
		String queryLeadID = "SELECT Id FROM Lead ORDER BY CreatedDate DESC"  + " limit 1 offset " + offsetValue;

		String sAccountID = searchTextSOQL.fetchRecordFieldValue("Id", queryAccountID);
		String sContactID = searchTextSOQL.fetchRecordFieldValue("Id", queryContactID);
		String sOpportunityID = searchTextSOQL.fetchRecordFieldValue("Id", queryOpportunityID);
		String sLeadID = searchTextSOQL.fetchRecordFieldValue("Id", queryLeadID);
		String sNewLead = null;
		System.out.println("Account Id:::"+ sAccountID);
		System.out.println("Contact Id:::"+ sContactID);
		System.out.println("Opportunity Id:::"+ sOpportunityID);
		System.out.println("Lead Id:::"+ sLeadID);
		
		if(dataTable.getData("General_Data", "TC_ID").contains("Account"))  {
			event.setField("WhoId", sContactID);
			event.setField("WhatId", sAccountID);
		} else if(dataTable.getData("General_Data", "TC_ID").contains("Opportunity")) {
			event.setField("WhoId", sContactID);
			event.setField("WhatId", sOpportunityID);
		} else if(dataTable.getData("General_Data", "TC_ID").contains("Contact")) {
			event.setField("WhatId", sAccountID);	
			event.setField("WhoId", sContactID);
		} else if (dataTable.getData("General_Data", "TC_ID").contains("Lead")) {
			sNewLead = leadsFunctions.createNewLead(); 
			event.setField("WhoId", sNewLead);
		}
		SObject[] events = new SObject[1];
		events[0] = event;
		try {
			results = EstablishConnection.connection.create(events);
		} catch (ConnectionException e) {
			e.printStackTrace();
		}
		System.out.println("Result:::" + results);
		status = establishConnection.saveResults(results);
		String status = establishConnection.saveResultsId(results);	
		if(status.startsWith("00U")) {
			report.updateTestLog("Verify Create Event", "Event has been created successfully", Status.PASS);
		} else {
			report.updateTestLog("Verify Create Event", "Event creation failed", Status.FAIL);
		}	
		int count=0;
		String leadQuery = "Select WhoId from Event where Id = " + "'" + status + "'";
		String accountQuery = "Select Account__c from Event where Id = " + "'" + status + "'";
		String whatIdQuery = "Select WhatId from Event where Id = " + "'" + status + "'";
		String whatIdValue = searchTextSOQL.fetchRecordFieldValue("WhatId", whatIdQuery);
		if(dataTable.getData("General_Data", "TC_ID").contains("Account"))  {
			String objectValue = searchTextSOQL.fetchRecordFieldValue("Account__c", accountQuery);
			if((objectValue.contains(sAccountID)) && (whatIdValue !=null)) {
				count++;
			}
		} else if(dataTable.getData("General_Data", "TC_ID").contains("Opportunity")) {
			if(whatIdValue.contains(sOpportunityID)) {
				count++;
			}
		} else if(dataTable.getData("General_Data", "TC_ID").contains("Contact")) {
			String objectValue = searchTextSOQL.fetchRecordFieldValue("WhoId", leadQuery);
			if((objectValue.contains(sContactID)) && (whatIdValue != null)) {
				count++;
			}
		} else if (dataTable.getData("General_Data", "TC_ID").contains("Lead")) {
			String objectValue = searchTextSOQL.fetchRecordFieldValue("WhoId", leadQuery);
			if(objectValue.contains(sNewLead)) {
				count++;
			}
		}
		if(count==1) 
			report.updateTestLog("Verify Create Task", "Event are created under Accounts/ Contacts/ Opportunities and Leads", Status.PASS);
		else 
			report.updateTestLog("Verify Create Task", "Event are not created under respective objects", Status.FAIL);
		return status;
	}

	public void closeTask() {
		String sTaskId = createTask();
		//establishConnection.establishConnectionSpecificUser();
		SObject sObject = new SObject();
		sObject.setType("Task");
		sObject.setField("Id", sTaskId);
		sObject.setField("Status", "Completed");
		SObject[] sObjects = new SObject[1];
		sObjects[0] = sObject;
		try {
			results = EstablishConnection.connection.update(sObjects);
		} catch (ConnectionException e) {
			e.printStackTrace();
		}
		
		/*QueryResult queryResults = null;
		try {
			queryResults = EstablishConnection.connection.query("SELECT Id, Status FROM Task where Status = 'Open' ORDER BY CreatedDate DESC LIMIT 1");
		} catch (ConnectionException e) {
			e.printStackTrace();
		}
		if (queryResults.getSize() > 0) {
			for (int i = 0; i < queryResults.getRecords().length; i++) {
				SObject so = (SObject) queryResults.getRecords()[i];
				SObject soUpdate = new SObject();
				soUpdate.setType("Task");
				soUpdate.setId(so.getId());
				soUpdate.setField("Status", "Completed");
				records[i] = soUpdate;
			}
		} else {
			report.updateTestLog("Verify Update Property", "There are no properties without Property Type and Property Sub Type", Status.WARNING);
		}
		try {
			results = EstablishConnection.connection.update(records);
		} catch (ConnectionException e) {
			e.printStackTrace();
		}*/
		System.out.println("Result:::" + results);
		String status = establishConnection.saveResultsId(results);	
		/*if(status.startsWith("00T")) {
			report.updateTestLog("Verify Close Task", "Task has been closed successfully", Status.PASS);
		} else {
			report.updateTestLog("Verify Close Task", "Task closure failed", Status.FAIL);
		}	*/
		String queryStatus="Select Status from Task where Id = " + "'" + status + "'";
		String sStatus = searchTextSOQL.fetchRecordFieldValue("Status", queryStatus);
		if(sStatus.equals("Completed")) {
			report.updateTestLog("Verify Close Task", "Task has been closed successfully", Status.PASS);
		} else {
			report.updateTestLog("Verify Close Task", "Task closure failed", Status.FAIL);
		}
	}
	
	public String createTaskOnLead() {
		establishConnection.establishConnection();
		SObject task = new SObject();
		task.setType("Task");
		String sNewLeadID = null;
	
		String value = Utility_Functions.xGenerateAlphaNumericString();
		task.setField("Subject", value + "Test Automation "+"Present");
		task.setField("Type", "Private - Initial Meeting");
		task.setField("ActivityDate", calendar.getTime());
		if (dataTable.getData("General_Data", "TC_ID").contains("Lead")) {
			sNewLeadID = leadsFunctions.createNewLeadConversion(); 
			task.setField("WhoId", sNewLeadID);
		}
		SObject[] tasks = new SObject[1];
		tasks[0] = task;
		try {
			results = EstablishConnection.connection.create(tasks);
		} catch (ConnectionException e) {
			e.printStackTrace();
		}
		System.out.println("Result:::" + results);
		String status = establishConnection.saveResultsId(results);	
		if(status.startsWith("00T")) {
			report.updateTestLog("Verify Create Task", "Task has been created successfully", Status.PASS);
		} else {
			report.updateTestLog("Verify Create Task", "Task creation failed", Status.FAIL);
		}
		int count=0;
		String leadQuery = "Select WhoId from Task where Id = " + "'" + status + "'";
		if (dataTable.getData("General_Data", "TC_ID").contains("Lead")) {
			String objectValue = searchTextSOQL.fetchRecordFieldValue("WhoId", leadQuery);
			if(objectValue.equals(sNewLeadID)) {
				count++;
			}
		}
		if(count==1) 
			report.updateTestLog("Verify Create Task", "Task are created under Leads", Status.PASS);
		else 
			report.updateTestLog("Verify Create Task", "Task are not created under respective objects", Status.FAIL);
		String IDs = sNewLeadID + "_" + status;
		return IDs;
	}
}