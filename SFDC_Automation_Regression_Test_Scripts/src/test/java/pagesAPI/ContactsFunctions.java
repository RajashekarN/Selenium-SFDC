package pagesAPI;

import org.openqa.selenium.support.PageFactory;

import com.cognizant.Craft.ReusableLibrary;
import com.cognizant.Craft.ScriptHelper;
import com.cognizant.framework.Status;
import com.sforce.soap.partner.DeleteResult;
import com.sforce.soap.partner.DescribeLayout;
import com.sforce.soap.partner.DescribeLayoutItem;
import com.sforce.soap.partner.DescribeLayoutResult;
import com.sforce.soap.partner.DescribeLayoutRow;
import com.sforce.soap.partner.DescribeLayoutSection;
import com.sforce.soap.partner.QueryResult;
import com.sforce.soap.partner.SaveResult;
import com.sforce.soap.partner.sobject.SObject;


public class ContactsFunctions extends ReusableLibrary {
	/*
	 * Constructor to initialize the business component library
	 * 
	 * @param scriptHelper The {@link ScriptHelper} object passed from the
	 * {@link DriverScript}
	 */

	public ContactsFunctions(ScriptHelper scriptHelper) {
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
	 * Function for the creation of the Contact
	 * 
	 * @author Vishnuvardhan
	 *
	 */	

	public boolean createContacts() {
		try {
			establishConnection.establishConnection();
			SObject contact = new SObject();

			contact.setType("Contact");
			contact.setField("FirstName", dataTable.getData("General_data", "FirstName"));
			contact.setField("LastName", dataTable.getData("General_data", "LastName"));
			contact.setField("Salutation", dataTable.getData("General_data", "Salutation"));
			contact.setField("Phone", dataTable.getData("General_data", "Phone"));
			contact.setField("Title", dataTable.getData("General_data", "Title"));

			SObject[] contacts = new SObject[1];
			contacts[0] = contact;
			results = EstablishConnection.connection.create(contacts);
			System.out.println("Result:::" + results);
			status = establishConnection.saveResults(results);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return status;
	}

	
	/**
	 * Function for updating the Contact
	 * 
	 * @author Vishnuvardhan
	 *
	 */	
	public boolean updateContacts() {
		try {
			establishConnection.establishConnection();
			SObject[] records = new SObject[1];
			QueryResult queryResults = EstablishConnection.connection.query("SELECT Id, Name FROM Contact ORDER BY CreatedDate DESC LIMIT 1");
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
			results = EstablishConnection.connection.update(records);
			System.out.println("Result:::" + results);
			status = establishConnection.saveResults(results);	
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return status;
	}
	
	/**
	 * Function for deleting the Contact
	 * 
	 * @author Vishnuvardhan
	 *
	 */	

	public boolean deleteContacts() {
		try {
			establishConnection.establishConnection();
			String[] records = new String[1];
			QueryResult queryResults = EstablishConnection.connection.query("SELECT Id, Name FROM Contact ORDER BY CreatedDate DESC LIMIT 1");
			if (queryResults.getSize() > 0) {
				for (int i = 0; i < queryResults.getRecords().length; i++) {
					SObject so = (SObject) queryResults.getRecords()[i];
		            records[i] = so.getId();		            
		            System.out.println("Deleting Id: " + so.getId() + " - Name: "+so.getField("Name"));
					report.updateTestLog("Verify Delete Contact", "Contact has been deleted successfully:::" + "Deleting Id: " + so.getId() + " - Name: "+so.getField("Name"), Status.PASS);
				}
			}
			deleteResults = EstablishConnection.connection.delete(records);
			System.out.println("Result:::" + deleteResults);
			status = establishConnection.deleteResults(deleteResults);	
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return status;
	}
	
	/**
	 * Function for the validating the field on the Contacts Page
	 * 
	 * @author Vishnuvardhan
	 *
	 */	
	
	public void contactsPageFieldsValidation() {	
		try{
			establishConnection.establishConnection();
			DescribeLayoutResult dlr = EstablishConnection.connection.describeLayout("Contact", null, null);
			for(int i = 1; i < dlr.getLayouts().length; i++) {
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