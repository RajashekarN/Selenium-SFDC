package pagesAPI;


import java.util.Calendar;
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
import supportLibraries.Utility_Functions;


public class OpportunitiesFunctions extends ReusableLibrary {
	/*
	 * Constructor to initialize the business component library
	 * 
	 * @param scriptHelper The {@link ScriptHelper} object passed from the
	 * {@link DriverScript}
	 */

	public OpportunitiesFunctions(ScriptHelper scriptHelper) {
		super(scriptHelper);
		PageFactory.initElements(driver.getWebDriver(), this);
		// new WebDriverUtil(driver);
		// Utility_Functions utility = new Utility_Functions(scriptHelper);
	}

	static SaveResult[] results;
	static DeleteResult[] deleteResults;
	static com.sforce.soap.partner.Error[] errors;
	static boolean status = false;
	

	/**
	 * Function for the creation of the Opportunity
	 * 
	 * @author Vishnuvardhan
	 *
	 */	
	
	EstablishConnection establishConnection = new EstablishConnection(scriptHelper);

	
	public boolean createOpportunity() {
		try {
			establishConnection.establishConnection();
			SObject opportunity = new SObject();

			opportunity.setType("Opportunity");		
			opportunity.setField("Name","Test Automation_Opportunity");
			SearchTextSOQL accountID = new SearchTextSOQL(scriptHelper);
			String accountId = accountID.fetchRecord("Account", "Id");
			opportunity.setField("AccountId", accountId);
			opportunity.setField("CloseDate",Calendar.getInstance());
			opportunity.setField("RecordTypeId", "012i0000000405n");
			opportunity.setField("StageName","Qualification");
			
			SObject[] opportunities = new SObject[1];
			opportunities[0] = opportunity;
			results = EstablishConnection.connection.create(opportunities);
			System.out.println("Result:::" + results);
			status = establishConnection.saveResults(results);	
			Utility_Functions.timeWait(1);
		} catch (Exception e) {
			System.out.println(e.getMessage());
			System.out.println(e.getStackTrace());
		}
		
		return status;
	}
	
	
	/**
	 * Function for updating the Opportunity
	 * 
	 * @author Vishnuvardhan
	 *
	 */	
	
	public boolean updateOpportunities() {
		try {
			establishConnection.establishConnection();
			SObject[] records = new SObject[1];
			QueryResult queryResults = EstablishConnection.connection.query("SELECT Id, Name FROM Opportunity ORDER BY CreatedDate DESC LIMIT 1");
			System.out.println(queryResults);
			if (queryResults.getSize() > 0) {
				for (int i = 0; i < queryResults.getRecords().length; i++) {
					SObject so = (SObject) queryResults.getRecords()[i];
					SObject soUpdate = new SObject();
					soUpdate.setType("Opportunity");
					soUpdate.setId(so.getId());
					soUpdate.setField("Name", so.getField("Name")+"--UPDATED");
					records[i] = soUpdate;
				}
			}
			results = EstablishConnection.connection.update(records);
			System.out.println("Result:::" + results);
			status = establishConnection.saveResults(results);	
		} catch (Exception e) {
			System.out.println(e.getMessage());
			System.out.println(e.getStackTrace());
		}
		return status;
	}
	
	
	/**
	 * Function for updating the Opportunity field
	 * 
	 * @author Vishnuvardhan
	 *
	 */	
	
	public void updateOpportunityField(String FieldName, String OpportunityID) {
		try {
			establishConnection.establishConnection();
			String fieldName = FieldName;
			String opportunityID = OpportunityID;
			SObject[] records = new SObject[1];
			QueryResult queryResults = EstablishConnection.connection.query("SELECT Id FROM Opportunity Where ID = " +  "'" + opportunityID + "'");
			System.out.println(queryResults);
			if (queryResults.getSize() > 0) {
				for (int i = 0; i < queryResults.getRecords().length; i++) {
					SObject so = (SObject) queryResults.getRecords()[i];
					SObject soUpdate = new SObject();
					soUpdate.setType("Opportunity");
					soUpdate.setId(so.getId());
					if(fieldName.equals("StageName")) {
						soUpdate.setField(fieldName,"19-Closed");
					} else if(fieldName.equals("Total_Size__c")) {
						soUpdate.setField(fieldName,"2900");
					} else if(fieldName.equals("CBRE_Preferred_Property_Type_c__c")) {
						soUpdate.setField(fieldName,"Office");
					} else if(fieldName.equals("Preferred_Property_Sub_Type__c")) {
						soUpdate.setField(fieldName,"General Office");
					} else if(fieldName.equals("Lease_From__c")) {
						soUpdate.setField(fieldName,Calendar.getInstance());
					} else if(fieldName.equals("Lease_To__c")) {
						Calendar calendar = Calendar.getInstance();
						calendar.add(Calendar.DAY_OF_MONTH, 365);
						soUpdate.setField(fieldName,calendar);
					} else if(fieldName.equals("Lease_Term__c")) {
						soUpdate.setField(fieldName,12);
					} else if(fieldName.equals("Lease_Rate_Rent__c")) {
						soUpdate.setField(fieldName,12000);
					} else if(fieldName.equals("Lease_Rate_Rent_Basis__c")) {
						soUpdate.setField(fieldName,"Per Year");
					} else if(fieldName.equals("Service__c")) {
						soUpdate.setField(fieldName,"Project Management");
					} else if(fieldName.equals("EMEA_Success_Probability__c")) {
						soUpdate.setField(fieldName,"100%");
					} else if(fieldName.equals("Unit_of_Measure__c")) {
						soUpdate.setField(fieldName,"Hectares");
					} else if(fieldName.equals("Estimated_Gross_Fee_Commission__c")) {
						soUpdate.setField(fieldName,"50,000");
					} else if(fieldName.equals("Installment_Amount__c")) {
						soUpdate.setField(fieldName,"50,000");
					} else if(fieldName.equals("Installment_Count__c")) {
						soUpdate.setField(fieldName,"2");
					} else if(fieldName.equals("Installment_Quantity__c")) {
						soUpdate.setField(fieldName,"2");
					} else if(fieldName.equals("Installments_Total__c")) {
						soUpdate.setField(fieldName,"30,000");
					} else if(fieldName.equals("Installment_Status__c")) {
						soUpdate.setField(fieldName,"Pending");
					} else if(fieldName.equals("CloseDate")) {
						Calendar calendar = Calendar.getInstance();
						calendar.add(Calendar.DAY_OF_MONTH, 365);
						soUpdate.setField(fieldName,calendar);
					}
					records[i] = soUpdate;
				}
			}
			results = EstablishConnection.connection.update(records);
			System.out.println("Result:::" + results);
		} catch (Exception e) {
			System.out.println(e.getMessage());
			System.out.println(e.getStackTrace());
		}
	}
	
	/**
	 * Function for deleting the Opportunity
	 * 
	 * @author Vishnuvardhan
	 *
	 */	
	
	public boolean deleteOpportunities() {
		try {
			establishConnection.establishConnection();
			String[] records = new String[1];
			QueryResult queryResults = EstablishConnection.connection.query("SELECT Id, Name FROM Opportunity ORDER BY CreatedDate DESC LIMIT 1");
			if (queryResults.getSize() > 0) {
				for (int i = 0; i < queryResults.getRecords().length; i++) {
					SObject so = (SObject) queryResults.getRecords()[i];
					records[i] = so.getId();		            
					System.out.println("Deleting Id: " + so.getId() + " - Name: "+so.getField("Name"));
					report.updateTestLog("Verify Delete Opportunity", "Opportunity has been deleted successfully:::" + "Deleting Id: " + so.getId() + " - Name: "+so.getField("Name"), Status.PASS);
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
	 * Function for the validating the field on the Opportunities Page
	 * 
	 * @author Vishnuvardhan
	 *
	 */	
	
	public void opportunitiesPageFieldsValidation() {	
		try{
			establishConnection.establishConnection();
			DescribeLayoutResult dlr = EstablishConnection.connection.describeLayout("Contact", null, null);
			for(int i = 0; i < dlr.getLayouts().length; i++) {
				DescribeLayout layout = dlr.getLayouts()[i];
				DescribeLayoutSection[] detailLayoutSectionList = layout.getDetailLayoutSections();
				System.out.println(" There are " + detailLayoutSectionList.length + " detail layout sections");
				report.updateTestLog("Verify Opportunities Page Field Validation", "There are " + detailLayoutSectionList.length + " detail layout sections", Status.PASS);
				DescribeLayoutSection[] editLayoutSectionList = layout.getEditLayoutSections();
				System.out.println(" There are " + editLayoutSectionList.length + " edit layout sections");
				report.updateTestLog("Verify Opportunities Page Field Validation", " There are " + editLayoutSectionList.length + " edit layout sections", Status.PASS);
				for(int j = 0; j < detailLayoutSectionList.length; j++) {
					System.out.println(j +  " This detail layout section has a heading of " +detailLayoutSectionList[j].getHeading());  
					report.updateTestLog("Verify Opportunities Page Field Validation", j +  " This detail layout section has a heading of " +detailLayoutSectionList[j].getHeading(), Status.PASS);
				}
				// Write the headings of the edit layout sections
				for(int x = 0; x < editLayoutSectionList.length; x++) { 
					System.out.println(x + " This edit layout section has a heading of " + editLayoutSectionList[x].getHeading());
					report.updateTestLog("Verify Opportunities Page Field Validation", x + " This edit layout section has a heading of " + editLayoutSectionList[x].getHeading(), Status.PASS);
				}
				// For each edit layout section, get its details.
				for(int k = 0; k < editLayoutSectionList.length; k++) {
					DescribeLayoutSection els = editLayoutSectionList[k];   
					System.out.println("Edit layout section heading: " + els.getHeading());
					report.updateTestLog("Verify Opportunities Page Field Validation", "Edit layout section heading: " + els.getHeading(), Status.PASS);
					DescribeLayoutRow[] dlrList = els.getLayoutRows();
					System.out.println("This edit layout section has " + dlrList.length + " layout rows");
					report.updateTestLog("Verify Opportunities Page Field Validation", "This edit layout section has " + dlrList.length + " layout rows", Status.PASS);
					for(int m = 0; m < dlrList.length; m++) {
						DescribeLayoutRow lr = dlrList[m];
						System.out.println(" This row has " + lr.getNumItems() + " layout items");
						report.updateTestLog("Verify Opportunities Page Field Validation", " This row has " + lr.getNumItems() + " layout items", Status.PASS);
						DescribeLayoutItem[] dliList = lr.getLayoutItems();
						for(int n = 0; n < dliList.length; n++) {
							DescribeLayoutItem li = dliList[n];
							if ((li.getLayoutComponents() != null) && (li.getLayoutComponents().length > 0)) {
								System.out.println("\tLayout item " + n +", layout component: " +li.getLayoutComponents()[0].getValue());
								report.updateTestLog("Verify Opportunities Page Field Validation", "\tLayout item " + n +", layout component: " +li.getLayoutComponents()[0].getValue(), Status.PASS);
							}
							else {
								System.out.println("\tLayout item " + n +", no layout component");                 
								report.updateTestLog("Verify Opportunities Page Field Validation", "\tLayout item " + n +", no layout component", Status.PASS);
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