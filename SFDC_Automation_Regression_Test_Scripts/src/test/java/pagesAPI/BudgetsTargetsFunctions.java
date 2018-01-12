package pagesAPI;

import java.util.ArrayList;
import java.util.Random;
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
import com.sforce.ws.ConnectionException;



public class BudgetsTargetsFunctions extends ReusableLibrary {
	/*
	 * Constructor to initialize the business component library
	 * 
	 * @param scriptHelper The {@link ScriptHelper} object passed from the
	 * {@link DriverScript}
	 */

	public BudgetsTargetsFunctions(ScriptHelper scriptHelper) {
		super(scriptHelper);
	}

	static SaveResult[] results;
	static DeleteResult[] deleteResults;
	static com.sforce.soap.partner.Error[] errors;
	static boolean status = false;
	static String sPrivateTagName;

	EstablishConnection establishConnection = new EstablishConnection(scriptHelper);
	SearchTextSOQL searchTextSOQL = new SearchTextSOQL(scriptHelper);

	/**
	 * Function for the creation of Budgets Targets
	 * 
	 * @author Vishnuvardhan
	 *
	 */

	public void createBudget() {
		budgetsTargetsFieldsValidation();
		//deleteBudgetTarget();
		/*SObject budget = new SObject();
		budget.setType("Budget_Target__c");
		String query = "SELECT CBRE_Professional__c FROM Budget_Target__c";
		String sCBREProfessional = searchTextSOQL.fetchRecordFieldValue("CBRE_Professional__c", query);
		budget.setField("CBRE_Professional__c", sCBREProfessional);
		budget.setField("Budget_Target_Amount__c", 20000);
		budget.setField("Start_Date__c", Calendar.getInstance());		
		SObject[] budgets = new SObject[1];
		budgets[0] = budget;
		try {
			results = EstablishConnection.connection.create(budgets);
		} catch (ConnectionException e) {
			e.printStackTrace();
		}
		System.out.println("Result:::" + results);
		String sBudgetId = establishConnection.saveResultsId(results);
		if(sBudgetId.startsWith("a14")) {
			report.updateTestLog("Verify Create Budget/Target", "Budget/Target has been created successfully", Status.PASS);
		} else {
			report.updateTestLog("Verify Create Budget/Target", "Budget/Target creation failed", Status.FAIL);
		}*/
	}

	/**
	 * Function for the creation of Budgets Edit
	 * 
	 * @author Vishnuvardhan
	 *
	 */
	public void budgetEdit() {
		establishConnection.establishConnection();
		SObject[] records = new SObject[1];
		QueryResult queryResults = null;
		int value = 0;
		try {
			queryResults = EstablishConnection.connection.query("SELECT Id FROM Budget_Target__c where Start_Date__c >= 2018-01-01 and Start_Date__c  <= 2018-12-31 and createdById != '005W0000002rBtgIAE' ORDER BY CreatedDate DESC LIMIT 1");
		} catch (ConnectionException e1) {
			e1.printStackTrace();
		}
		if (queryResults.getSize() > 0) {
			for (int i = 0; i < queryResults.getRecords().length; i++) {
				SObject so = (SObject) queryResults.getRecords()[i];
				SObject soUpdate = new SObject();
				soUpdate.setType("Budget_Target__c");
				soUpdate.setId(so.getId());
				Random random = new Random();
				value = random.nextInt(50000);
				soUpdate.setField("Budget_Target_Amount__c", value);
				records[i] = soUpdate;
			}
		}
		try {
			results = EstablishConnection.connection.update(records);
		} catch (ConnectionException e) {
			e.printStackTrace();
		}
		System.out.println("Result:::" + results);
		String status= establishConnection.saveResultsId(results);	
		if(status.startsWith("a14")) {
			System.out.println("Budget Amount is edited as::" + value);
			report.updateTestLog("Verify Create Budget/Target", "Budget/Target Edit is successful", Status.PASS);
		} else {
			report.updateTestLog("Verify Create Budget/Target", "Budget/Target Edit failed", Status.FAIL);
		}
	}

	/**
	 * Function for the deletion of Budgets
	 * 
	 * @author Vishnuvardhan
	 *
	 */
	
	public boolean deleteBudgetTarget() {
		establishConnection.establishConnection();
		String[] records = new String[1];
		QueryResult queryResults = null;
		try {
			queryResults = EstablishConnection.connection.query("SELECT Id, Start_Date__c FROM Budget_Target__c where Start_Date__c >= 2017-01-01 and Start_Date__c  <= 2017-12-31");
		} catch (ConnectionException e) {
			e.printStackTrace();
		}
		if (queryResults.getSize() > 0) {
			for (int i = 0; i < queryResults.getRecords().length; i++) {
				SObject so = (SObject) queryResults.getRecords()[i];
				records[i] = so.getId();		            
				System.out.println("Deleting Id: " + so.getId() + " - Name: "+so.getField("Name"));
				report.updateTestLog("Verify Delete Buget", "Budget has been deleted successfully:::" + "Deleting Id: " + so.getId() + " - Name: "+so.getField("Name"), Status.PASS);
			}
		}
		try {
			deleteResults = EstablishConnection.connection.delete(records);
		} catch (ConnectionException e) {
			e.printStackTrace();
		}
		System.out.println("Result:::" + deleteResults);
		status = establishConnection.deleteResults(deleteResults);		
		return status;
	}
	
	/**
	 * Function for the validating the fields for Budgets
	 * 
	 * @author Vishnuvardhan
	 *
	 */
	
	static ArrayList<String> BudgetTargetFields = new ArrayList<String>();

	public void BudgetTarget() {
		BudgetTargetFields.add("CBRE_Professional__c");
		BudgetTargetFields.add("OwnerId");
		BudgetTargetFields.add("Budget_Target_Amount__c");
		BudgetTargetFields.add("CurrencyIsoCode");
		BudgetTargetFields.add("Start_Date__c");
		System.out.println("Budget/Target Fields List are::" + BudgetTargetFields);
	}

	static ArrayList<String> BudgetTargetFieldsAPI = new ArrayList<String>();

	public void budgetsTargetsFieldsValidation() {
		try {
			establishConnection.establishConnection();
			BudgetTarget();
			DescribeLayoutResult dlr = EstablishConnection.connection.describeLayout("Budget_Target__c", null, null);
			int count=0, countLabelList = 0;
			for (int i = 0; i < dlr.getLayouts().length; i++) {
				DescribeLayout layout = dlr.getLayouts()[i];
				DescribeLayoutSection[] editLayoutSectionList = layout.getEditLayoutSections();
				// Write the headings of the edit layout sections
				for (int x = 0; x < editLayoutSectionList.length; x++) {
					if(dataTable.getData("General_Data", "TC_ID").contains("CMAPAC")) {
						if(editLayoutSectionList.length==0) {
							if(editLayoutSectionList[x].getHeading().equals("Information")) {
								System.out.println(x + ":::Capital Markets APAC Budget/Target section heading layout section:::" + editLayoutSectionList[x].getHeading());
								report.updateTestLog(x + ":::Capital Markets APAC Budget/Target section", " has the heading layout section:::" + editLayoutSectionList[x].getHeading(), Status.PASS);
								count++;
							}
						}				
					}							
				}	
				System.out.println(count);			
				if(dataTable.getData("General_Data", "TC_ID").contains("CMAPAC")) {
					if(editLayoutSectionList.length==1) {
						for (int k = 0; k < editLayoutSectionList.length; k++) {
							DescribeLayoutSection els = editLayoutSectionList[k];
							DescribeLayoutRow[] dlrList = els.getLayoutRows();
							for (int m = 0; m < dlrList.length; m++) {
								DescribeLayoutRow lr = dlrList[m];
								DescribeLayoutItem[] dliList = lr.getLayoutItems();
								for (int n = 0; n < dliList.length; n++) {
									DescribeLayoutItem li = dliList[n];
									if ((li.getLayoutComponents() != null) && (li.getLayoutComponents().length > 0)) {
										BudgetTargetFieldsAPI.add(li.getLayoutComponents()[0].getValue());
									}
								}
							}
						}	
						System.out.println("Budget/Target API Label::: " + BudgetTargetFieldsAPI);
						for(int i1=0; i1 < BudgetTargetFields.size(); i1++) {
							if(BudgetTargetFieldsAPI.get(i1).equals(BudgetTargetFields.get(i1))) {						
								System.out.println("Field Label:::" + BudgetTargetFields.get(i1) + " -- is present in CM APAC:::");
								report.updateTestLog("Verify Field Labels", " has the field label:::" + BudgetTargetFieldsAPI.get(i1), Status.PASS);
								countLabelList++;
							}			 
						}
						System.out.println("Count of fields present in Capital Markets Budget/ Target::" + countLabelList);
					}
				}					
			}				
			if(dataTable.getData("General_Data", "TC_ID").contains("CMAPAC")) {
				if(count==0) {
					System.out.println("Capital Markets APAC Budget/Target section has the section present::");
					report.updateTestLog("Validating Header Sections", "Capital Markets APAC Budget/Target section has the headers present", Status.PASS);
				}								
			} 
			BudgetTargetFields.clear();
			if (countLabelList == 5) {
				System.out.println("All the fields are present::");
				report.updateTestLog("Count of fields present", "All the fields are present Capital Markets APAC Budget/Target section", Status.PASS);
			} else {
				System.out.println("All the fields are not present::");
				report.updateTestLog("Count of fields present", "All the fields are not present Capital Markets APAC Budget/Target section", Status.FAIL);
			} 		
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

}