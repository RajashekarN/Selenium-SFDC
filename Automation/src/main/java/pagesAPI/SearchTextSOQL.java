package pagesAPI;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.support.PageFactory;

import com.cognizant.framework.Status;
import com.sforce.soap.partner.DeleteResult;
import com.sforce.soap.partner.DescribeLayout;
import com.sforce.soap.partner.DescribeLayoutItem;
import com.sforce.soap.partner.DescribeLayoutResult;
import com.sforce.soap.partner.DescribeLayoutRow;
import com.sforce.soap.partner.DescribeLayoutSection;
import com.sforce.soap.partner.GetUserInfoResult;
import com.sforce.soap.partner.PartnerConnection;
import com.sforce.soap.partner.QueryResult;
import com.sforce.soap.partner.SaveResult;
import com.sforce.soap.partner.SearchRecord;
import com.sforce.soap.partner.SearchResult;
import com.sforce.soap.partner.sobject.SObject;
import com.sforce.ws.ConnectionException;
import com.sforce.ws.ConnectorConfig;

import supportlibraries.ReusableLibrary;
import supportlibraries.ScriptHelper;
import supportlibraries.Utility_Functions;
/**
 * API Class for searching the text using SOQL calls
 * 
 * @author Vishnuvardhan
 *
 */
public class SearchTextSOQL extends ReusableLibrary {
	/*
	 * Constructor to initialize the business component library
	 * 
	 * @param scriptHelper The {@link ScriptHelper} object passed from the
	 * {@link DriverScript}
	 */

	public SearchTextSOQL(ScriptHelper scriptHelper) {
		super(scriptHelper);
		PageFactory.initElements(driver, this);
		// new WebDriverUtil(driver);
		utility = new Utility_Functions(scriptHelper);
	}

	static PartnerConnection connection = null;
	static ConnectorConfig config;
	static SaveResult[] results;
	static DeleteResult[] deleteResults;
	static com.sforce.soap.partner.Error[] errors;
	static boolean status = false;
	static String result;

	/**
	 * Validating the Connection functionality
	 * 
	 * @author Vishnuvardhan
	 *
	 */
	public void establishConnection() {
		String username = dataTable.getData("General_Data", "Username");
		String password = dataTable.getData("General_Data", "Password");
		String authEndpoint = dataTable.getData("General_Data", "AuthEndpoint");
		try {
			config = new ConnectorConfig();
			config.setUsername(username);
			config.setPassword(password);
			System.out.println("AuthEndPoint: " + authEndpoint);
			config.setAuthEndpoint(authEndpoint);
			connection = new PartnerConnection(config);
		} catch (ConnectionException ce) {
			ce.printStackTrace();
			System.out.println(ce.getMessage());
		}
	}

	/**
	 * Validating the Search Lead functionality
	 * 
	 * @author Vishnuvardhan
	 *
	 */

	public void searchLead() {
		try
		{
			establishConnection();
			List<String> lstLeadName = new ArrayList<String>();
			//Suppose you have filled lstIds with your ids.
			/*	String query = "select Id, Name from lead "; 
			String strLeadName = dataTable.getData("General_Data", "Lead Name");
			for(String ids:lstLeadName){
				if(strLeadName.equals("")){
					strLeadName = "'" + ids + "'";
				}
				else{
					strLeadName += ",'" + ids + "'";
				}
			}
			query += "where id in (" + strLeadName + ")";*/
			String query = "SELECT Id FROM Lead where Country !=null limit 10";
			QueryResult result = connection.query(query);
			if(result.getSize()>0)
			{
				boolean done=false;
				while(!done)
				{
					for (SObject record : result.getRecords()) 
					{
						System.out.println("###### record.Id: " + (String)record.getField("Id"));
						System.out.println("###### record.Name: " + (String)record.getField("Name"));
					}
					if (result.isDone()) {
						done = true;
					} else {
						result = connection.queryMore(result.getQueryLocator());
					}
				}
			}			
		}
		catch(Exception ex)
		{
			System.out.println("Exception in main : " + ex);
		}
	}

	
	/**
	 * Searching for the Opportunity 
	 * 
	 * @author Vishnuvardhan
	 * @return 
	 *
	 */

	public String searchOpportunity(String query) {
		String recordID = null;
		try
		{
			establishConnection();
			String Query = query; 
			//Query = "SELECT Id FROM Lead where Country !=null limit 10";
			QueryResult result = connection.query(Query);
			if(result.getSize()>0)
			{
				boolean done=false;
				while(!done)
				{
					for (SObject record : result.getRecords()) 
					{
					
							recordID = (String)record.getField("Id");
							report.updateTestLog("Verify Fetch Record", "Record has been fetched successfully:::" + recordID, Status.PASS);
							System.out.println("###### record.Id: " + (String)record.getField("Id"));
							System.out.println("###### record.Name: " + (String)record.getField("Name"));
						if(recordID!=null) {
							done = true;
							break;
						}
					}
					if (result.isDone()) {
						done = true;
					} else {
						result = connection.queryMore(result.getQueryLocator());
					}
				}
			}			
		}
		catch(Exception ex)
		{
			System.out.println("Exception in main : " + ex);
		}
		return recordID;
	}
	
	/**
	 * Function to fetch the Account, Contact, Lead, Opportunities from SOQL using the query
	 * 
	 * @author Vishnuvardhan
	 *
	 */

	public String fetchRecord(String table, String Name) {
		String recordID = null;
		String name = Name;
		try
		{
			establishConnection();
			String tableName = table; 
			String query = "select Id, Name from " +  tableName + " order by CreatedDate asc";
			QueryResult result = connection.query(query);
			if(result.getSize()>0)
			{
				boolean done=false;
				while(!done)
				{
					for (SObject record : result.getRecords()) 
					{
						if(name.equals("Name")) {
							recordID = (String)record.getField("Name");
							report.updateTestLog("Verify Fetch Record", "Record has been fetched successfully:::" + recordID, Status.PASS);
						} else if(name.equals("StageName")) {
							recordID = (String)record.getField("StageName");
							report.updateTestLog("Verify Fetch Record", "Record has been fetched successfully:::" + recordID, Status.PASS);
						} else {
							recordID = (String)record.getField("Id");
							report.updateTestLog("Verify Fetch Record", "Record has been fetched successfully:::" + recordID, Status.PASS);
						}
						System.out.println("###### record.Id: " + (String)record.getField("Id"));
						System.out.println("###### record.Name: " + (String)record.getField("Name"));
						if(recordID!=null) {
							done = true;
							break;
						}
					}
					if (result.isDone()) {
						done = true;
					} else {
						result = connection.queryMore(result.getQueryLocator());
					}
				}
			}			
		}
		catch(Exception ex)
		{
			report.updateTestLog("Verify Fetch Record", "Record fetchfailed:::" + recordID, Status.FAIL);
			System.out.println("Exception in main : " + ex);
		}
		return recordID;
	}
	
	/**
	 * Function to fetch the Account, Contact, Lead, Opportunities from SOQL using the query
	 * 
	 * @author Vishnuvardhan
	 *
	 */

	public String fetchRecordFieldValue(String FieldName, String Query) {
		String recordID = null;
		String fieldname = FieldName;
		try
		{
			establishConnection();
			String query = Query;
			QueryResult result = connection.query(query);
			if(result.getSize()>0)
			{
				boolean done=false;
				while(!done)
				{
					for (SObject record : result.getRecords()) 
					{
						if(fieldname.equals("Name")) {
							recordID = (String)record.getField("Name");
							report.updateTestLog("Verify Fetch Record", "Record has been fetched successfully:::" + recordID, Status.PASS);
						} else if(fieldname.equals("StageName")) {
							recordID = (String)record.getField("StageName");
							report.updateTestLog("Verify Fetch Record", "Record has been fetched successfully:::" + recordID, Status.PASS);
						} else {
							recordID = (String)record.getField("Id");
							report.updateTestLog("Verify Fetch Record", "Record has been fetched successfully:::" + recordID, Status.PASS);
						}
						System.out.println("###### record.Id: " + (String)record.getField("Id"));
						System.out.println("###### record.Name: " + (String)record.getField("Name"));
						if(recordID!=null) {
							done = true;
							break;
						}
					}
					if (result.isDone()) {
						done = true;
					} else {
						result = connection.queryMore(result.getQueryLocator());
					}
				}
			}			
		}
		catch(Exception ex)
		{
			report.updateTestLog("Verify Fetch Record", "Record fetchfailed:::" + recordID, Status.FAIL);
			System.out.println("Exception in main : " + ex);
		}
		return recordID;
	}
}


