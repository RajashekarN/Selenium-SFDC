package pagesAPI;

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
import com.sforce.soap.partner.sobject.SObject;
import com.sforce.ws.ConnectionException;
import com.sforce.ws.ConnectorConfig;

import supportlibraries.ReusableLibrary;
import supportlibraries.ScriptHelper;
import supportlibraries.Utility_Functions;

public class ContactsFunctions extends ReusableLibrary {
	/*
	 * Constructor to initialize the business component library
	 * 
	 * @param scriptHelper The {@link ScriptHelper} object passed from the
	 * {@link DriverScript}
	 */

	public ContactsFunctions(ScriptHelper scriptHelper) {
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

	public boolean createContacts() {
		try {
			establishConnection();
			SObject contact = new SObject();

			contact.setType("Contact");
			contact.setField("FirstName", dataTable.getData("General_data", "FirstName"));
			contact.setField("LastName", dataTable.getData("General_data", "LastName"));
			contact.setField("Salutation", dataTable.getData("General_data", "Salutation"));
			contact.setField("Phone", dataTable.getData("General_data", "Phone"));
			contact.setField("Title", dataTable.getData("General_data", "Title"));

			SObject[] contacts = new SObject[1];
			contacts[0] = contact;
			results = connection.create(contacts);
			System.out.println("Result:::" + results);
			status = saveResults();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return status;
	}

	public boolean updateContacts() {
		try {
			establishConnection();
			SObject[] records = new SObject[1];
			QueryResult queryResults = connection.query("SELECT Id, Name FROM Contact ORDER BY CreatedDate DESC LIMIT 1");
			if (queryResults.getSize() > 0) {
				for (int i = 0; i < queryResults.getRecords().length; i++) {
					SObject so = (SObject) queryResults.getRecords()[i];
					SObject soUpdate = new SObject();
					soUpdate.setType("Contact");
					soUpdate.setId(so.getId());
					//soUpdate.setField("Name", dataTable.getData("General_Data", "Name") + "-- Updated");
					soUpdate.setField("LastName", so.getField("LastName")+"--UPDATED");
					records[i] = soUpdate;
				}
			}
			results = connection.update(records);
			System.out.println("Result:::" + results);
			status = saveResults();	
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return status;
	}

	public boolean deleteContacts() {
		try {
			establishConnection();
			String[] records = new String[1];
			QueryResult queryResults = connection.query("SELECT Id, Name FROM Contact ORDER BY CreatedDate DESC LIMIT 1");
			if (queryResults.getSize() > 0) {
				for (int i = 0; i < queryResults.getRecords().length; i++) {
					SObject so = (SObject) queryResults.getRecords()[i];
		            records[i] = so.getId();		            
		            System.out.println("Deleting Id: " + so.getId() + " - Name: "+so.getField("Name"));
					report.updateTestLog("Verify Delete Contact", "Contact has been deleted successfully:::" + "Deleting Id: " + so.getId() + " - Name: "+so.getField("Name"), Status.PASS);
				}
			}
			deleteResults = connection.delete(records);
			System.out.println("Result:::" + deleteResults);
			status = deleteResults();	
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return status;
	}

	public boolean saveResults() {
		System.out.println("Results:::" + results);
		for (int j = 0; j < results.length; j++) {
			if (results[j].isSuccess()) {
				result = results[j].getId();
				System.out.println("Save Results:::" + result);
				report.updateTestLog("Verify Create/ Update Contact", "Result :: " + result, Status.PASS);
				status = true;
			} else {
				for (int i = 0; i < results[j].getErrors().length; i++) {
					com.sforce.soap.partner.Error err = results[j].getErrors()[i];
					report.updateTestLog("Verify Create/ Update Contact", "Errors were found on item:::" + j, Status.FAIL);
					report.updateTestLog("Verify Create/ Update Contact", "Errors code:::" + err.getStatusCode().toString(),Status.FAIL);
					report.updateTestLog("Verify Create/ Update Contact", "Errors message:::" + err.getMessage(), Status.FAIL);
					System.out.println("Errors were found on item " + j);
					System.out.println("Error code::" + err.getStatusCode().toString());
					System.out.println("Error message::" + err.getMessage());
					status = false; 
				}
			}
		}
		return status;
	}
	
	public boolean deleteResults() {
		System.out.println("Results:::" + deleteResults);
		for (int j = 0; j < deleteResults.length; j++) {
			if (deleteResults[j].isSuccess()) {
				deleteResults[j].getId();
				System.out.println("Delete Results:::" + deleteResults[j].getId());
				report.updateTestLog("Verify Delete Contact", "Result :: " + deleteResults[j].getId(), Status.PASS);
				status = true;
			} else {
				errors = deleteResults[j].getErrors();
				for (int i = 0; i < errors.length; i++) {
					report.updateTestLog("Verify Delete Contact", "Errors message:::" + errors[i].getMessage(), Status.FAIL);
					System.out.println("Error message::" + errors[i].getMessage());
					status = false; 
				}
			}
		}
		return status;
	}
	
	public void contactsPageFieldsValidation() {	
		try{
			establishConnection();
			connection =  new PartnerConnection(config);
			DescribeLayoutResult dlr = connection.describeLayout("Contact", null, null);
			for(int i = 0; i < dlr.getLayouts().length; i++) {
				DescribeLayout layout = dlr.getLayouts()[i];
				DescribeLayoutSection[] detailLayoutSectionList = layout.getDetailLayoutSections();
				System.out.println(" There are " + detailLayoutSectionList.length + " detail layout sections");
				report.updateTestLog("Verify Contacts Page Field Validation", "There are " + detailLayoutSectionList.length + " detail layout sections", Status.PASS);
				DescribeLayoutSection[] editLayoutSectionList = layout.getEditLayoutSections();
				System.out.println(" There are " + editLayoutSectionList.length + " edit layout sections");
				report.updateTestLog("Verify Contacts Page Field Validation", " There are " + editLayoutSectionList.length + " edit layout sections", Status.PASS);
				for(int j = 0; j < detailLayoutSectionList.length; j++) {
					System.out.println(j +  " This detail layout section has a heading of " +detailLayoutSectionList[j].getHeading());  
					report.updateTestLog("Verify Contacts Page Field Validation", j +  " This detail layout section has a heading of " +detailLayoutSectionList[j].getHeading(), Status.PASS);
				}
				// Write the headings of the edit layout sections
				for(int x = 0; x < editLayoutSectionList.length; x++) { 
					System.out.println(x + " This edit layout section has a heading of " + editLayoutSectionList[x].getHeading());
					report.updateTestLog("Verify Contacts Page Field Validation", x + " This edit layout section has a heading of " + editLayoutSectionList[x].getHeading(), Status.PASS);
				}
				// For each edit layout section, get its details.
				for(int k = 0; k < editLayoutSectionList.length; k++) {
					DescribeLayoutSection els = editLayoutSectionList[k];   
					System.out.println("Edit layout section heading: " + els.getHeading());
					report.updateTestLog("Verify Contacts Page Field Validation", "Edit layout section heading: " + els.getHeading(), Status.PASS);
					DescribeLayoutRow[] dlrList = els.getLayoutRows();
					System.out.println("This edit layout section has " + dlrList.length + " layout rows");
					report.updateTestLog("Verify Contacts Page Field Validation", "This edit layout section has " + dlrList.length + " layout rows", Status.PASS);
					for(int m = 0; m < dlrList.length; m++) {
						DescribeLayoutRow lr = dlrList[m];
						System.out.println(" This row has " + lr.getNumItems() + " layout items");
						report.updateTestLog("Verify Contacts Page Field Validation", " This row has " + lr.getNumItems() + " layout items", Status.PASS);
						DescribeLayoutItem[] dliList = lr.getLayoutItems();
						for(int n = 0; n < dliList.length; n++) {
							DescribeLayoutItem li = dliList[n];
							if ((li.getLayoutComponents() != null) && (li.getLayoutComponents().length > 0)) {
								System.out.println("\tLayout item " + n +", layout component: " +li.getLayoutComponents()[0].getValue());
								report.updateTestLog("Verify Contacts Page Field Validation", "\tLayout item " + n +", layout component: " +li.getLayoutComponents()[0].getValue(), Status.PASS);
							}
							else {
								System.out.println("\tLayout item " + n +", no layout component");                 
								report.updateTestLog("Verify Contacts Page Field Validation", "\tLayout item " + n +", no layout component", Status.PASS);
							}     
						}
					}
				}
			} 
		}catch (Exception e){
			System.out.println(e.getMessage());
		}
	}

}