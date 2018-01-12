package pagesAPI;


import java.util.ArrayList;
import java.util.Calendar;
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

public class OpportunitiesFunctions extends ReusableLibrary {
	/*
	 * Constructor to initialize the business component library
	 * 
	 * @param scriptHelper The {@link ScriptHelper} object passed from the
	 * {@link DriverScript}
	 */

	public OpportunitiesFunctions(ScriptHelper scriptHelper) {
		super(scriptHelper);
	}

	static SaveResult[] results;
	static DeleteResult[] deleteResults;
	static com.sforce.soap.partner.Error[] errors;
	static boolean status = false;

	EstablishConnection establishConnection = new EstablishConnection(scriptHelper);

	/**
	 * Function for the creation of the Opportunity
	 * 
	 * @author Vishnuvardhan
	 *
	 */	

	public String createOpportunity() {
		establishConnection.establishConnection();
		SObject opportunity = new SObject();
		opportunity.setType("Opportunity");		
		opportunity.setField("Name","Test Automation_Opportunity");
		AccountsFunctions accountsFunctions = new AccountsFunctions(scriptHelper);
		String accountId = accountsFunctions.createAccountRequiredFields();		
		opportunity.setField("AccountId", accountId);
		opportunity.setField("CloseDate",Calendar.getInstance());
		String sTestCaseID = dataTable.getData("General_Data", "TC_ID");
		System.out.println(sTestCaseID);
		if(dataTable.getData("General_Data", "TC_ID").contains("APAC")) /*&& (!dataTable.getData("General_Data", "TC_ID").startsWith("VAS")) && 
		(!dataTable.getData("General_Data", "TC_ID").startsWith("GWS")) && (!dataTable.getData("General_Data", "TC_ID").startsWith("OB"))  &&
		(!dataTable.getData("General_Data", "TC_ID").startsWith("AB")))*/ {
			opportunity.setField("RecordTypeId", "012i0000001QOXfAAO");
		} else if((!dataTable.getData("General_Data", "TC_ID").startsWith("TC_SF_FRAN")) 
				&& (!dataTable.getData("General_Data", "TC_ID").startsWith("TC_SF_FDIG")) && (!dataTable.getData("General_Data", "TC_ID").startsWith("TC_SF_FDIR"))
				&& (dataTable.getData("General_Data", "TC_ID").contains("EMEA"))) /*&& (!dataTable.getData("General_Data", "TC_ID").startsWith("VAS")) && 
				(!dataTable.getData("General_Data", "TC_ID").startsWith("GWS")) && (!dataTable.getData("General_Data", "TC_ID").startsWith("OB"))  &&
				(!dataTable.getData("General_Data", "TC_ID").startsWith("AB")))*/ {
			opportunity.setField("RecordTypeId", "012i0000000tvTeAAI");
		} else if((dataTable.getData("General_Data", "TC_ID").startsWith("VAS")) && (dataTable.getData("General_Data", "TC_ID").contains("AMER"))
				&& (!dataTable.getData("General_Data", "TC_ID").startsWith("TC_SF_FRAN")) && (!dataTable.getData("General_Data", "TC_ID").startsWith("TC_SF_FDIG")) 
				&& (!dataTable.getData("General_Data", "TC_ID").startsWith("TC_SF_FDIR"))) {
			opportunity.setField("RecordTypeId", "0121Y000001EVzFQAW");
		} else if((dataTable.getData("General_Data", "TC_ID").startsWith("GWS")) && (dataTable.getData("General_Data", "TC_ID").contains("AMER"))
				&& (!dataTable.getData("General_Data", "TC_ID").startsWith("TC_SF_FRAN")) 
				&& (!dataTable.getData("General_Data", "TC_ID").startsWith("TC_SF_FDIR")) && (!dataTable.getData("General_Data", "TC_ID").startsWith("TC_SF_FDIG"))) {
			opportunity.setField("RecordTypeId", "012i0000000405mAAA");
		} else if((dataTable.getData("General_Data", "TC_ID").startsWith("OB")) && (dataTable.getData("General_Data", "TC_ID").contains("AMER")) 
				&& (!dataTable.getData("General_Data", "TC_ID").startsWith("TC_SF_FRAN")) 
				&& (!dataTable.getData("General_Data", "TC_ID").startsWith("TC_SF_FDIR")) && (!dataTable.getData("General_Data", "TC_ID").startsWith("TC_SF_FDIG"))) {
			opportunity.setField("RecordTypeId", "012i0000000405nAAA");
		} else if((dataTable.getData("General_Data", "TC_ID").startsWith("AB")) && (dataTable.getData("General_Data", "TC_ID").contains("AMER")) 
				&& (!dataTable.getData("General_Data", "TC_ID").startsWith("TC_SF_FRAN")) 
				&& (!dataTable.getData("General_Data", "TC_ID").startsWith("TC_SF_FDIR")) && (!dataTable.getData("General_Data", "TC_ID").startsWith("TC_SF_DIG"))) {
			opportunity.setField("RecordTypeId", "012i0000001622CAAQ");
		} else if((dataTable.getData("General_Data", "TC_ID").startsWith("AS")) && (dataTable.getData("General_Data", "TC_ID").contains("AMER")
				&& (!dataTable.getData("General_Data", "TC_ID").startsWith("TC_SF_FRAN")) 
				&& (!dataTable.getData("General_Data", "TC_ID").startsWith("TC_SF_FDIG")) && (!dataTable.getData("General_Data", "TC_ID").startsWith("TC_SF_FDIR")))) {
			opportunity.setField("RecordTypeId", "012i0000000405jAAA");
		} else if((dataTable.getData("General_Data", "TC_ID").startsWith("CM")) && (dataTable.getData("General_Data", "TC_ID").contains("DSF")) &&
				(dataTable.getData("General_Data", "TC_ID").contains("AMER")) && (!dataTable.getData("General_Data", "TC_ID").startsWith("TC_SF_FRAN")) 
				&& (!dataTable.getData("General_Data", "TC_ID").startsWith("TC_SF_FDIR")) && (!dataTable.getData("General_Data", "TC_ID").startsWith("TC_SF_FDIG"))) {
			opportunity.setField("RecordTypeId", "012i0000000405lAAA");
		}  else if((dataTable.getData("General_Data", "TC_ID").startsWith("CM")) && (dataTable.getData("General_Data", "TC_ID").contains("DSF")) &&
				(dataTable.getData("General_Data", "TC_ID").contains("APAC")) && (!dataTable.getData("General_Data", "TC_ID").startsWith("TC_SF_FRAN")) 
				&& (!dataTable.getData("General_Data", "TC_ID").startsWith("TC_SF_FDIR")) && (!dataTable.getData("General_Data", "TC_ID").startsWith("TC_SF_FDIG"))) {
			opportunity.setField("RecordTypeId", "0121Y000001EW60QAG");
		} else if((dataTable.getData("General_Data", "TC_ID").startsWith("TC_SF_FRAN")) || (dataTable.getData("General_Data", "TC_ID").startsWith("TC_SF_FDIG")) 
				|| (dataTable.getData("General_Data", "TC_ID").startsWith("TC_SF_FDIR"))) {
			opportunity.setField("RecordTypeId", "0121Y000001EVzDQAW");
		}								
		opportunity.setField("Service__c", "Consulting");
		if(dataTable.getData("General_Data", "TC_ID").startsWith("AS")) {
			opportunity.setField("AS_Lead_Source__c", "Business Relationship");
		} else {
			opportunity.setField("LeadSource", "Business Relationship");	
		}		
		opportunity.setField("Amount", "20000");
		opportunity.setField("StageName","02-Meeting");
		SObject[] opportunities = new SObject[1];
		opportunities[0] = opportunity;
		try {
			results = EstablishConnection.connection.create(opportunities);
		} catch (ConnectionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Result:::" + results);
		String opportunityId = establishConnection.saveResultsId(results);	
		return opportunityId;
	}

	/**
	 * Function for the creation Note
	 * 
	 * @author Vishnuvardhan
	 *
	 */	

	public boolean createNote(String parentID) {
		int count =1;
		boolean status=false;
		establishConnection.establishConnection();
		/*SObject Note = new SObject();
		Note.setType("Note");		
		Note.setField("ParentId",parentID);
		Note.setField("Title", "Test Note Title");
		Note.setField("Body","Test Note Body");*/
		if(dataTable.getData("General_Data", "TC_ID").contains("Note") &&dataTable.getData("General_Data", "TC_ID").contains("Attachment") ) /*&& (!dataTable.getData("General_Data", "TC_ID").startsWith("VAS")) && 
		(!dataTable.getData("General_Data", "TC_ID").startsWith("GWS")) && (!dataTable.getData("General_Data", "TC_ID").startsWith("OB"))  &&
		(!dataTable.getData("General_Data", "TC_ID").startsWith("AB")))*/ {
			count = 3;
		}  
		//opportunities[0] = opportunity;
		for(int i =1;i<=count;i++){
			SObject[] Notes = new SObject[1];
			SObject Note = new SObject();
			Note.setType("Note");		
			Note.setField("ParentId",parentID);
			Note.setField("Title", "Test Note Title "+ String.valueOf(i));
			Note.setField("Body","Test Note Body "+ String.valueOf(i));
			Notes[0]= Note;
			try {
				results = EstablishConnection.connection.create(Notes);
			} catch (ConnectionException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("Result:::" + results);
			status = establishConnection.saveResults(results);
			if (!status){
				break;
			}
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
			if(dataTable.getData("General_Data", "TC_ID").contains("CMAMER")) {
				if (queryResults.getSize() > 0) {
					for (int i = 0; i < queryResults.getRecords().length; i++) {
						SObject so = (SObject) queryResults.getRecords()[i];
						SObject soUpdate = new SObject();
						soUpdate.setType("Opportunity");
						soUpdate.setId(so.getId());
						if(fieldName.equals("StageName")) {
							soUpdate.setField(fieldName,"07-Under Contract");
						}
						records[i] = soUpdate;
					}
				}
			} else { 
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
	 * Function for the validating the fields on the Opportunities Page
	 * 
	 * @author Vishnuvardhan
	 *
	 */	

	static ArrayList<String> ASAPACHeaders = new ArrayList<String>();

	public void ASAPACHeadings() {
		ASAPACHeaders.add("Opportunity Information");
		ASAPACHeaders.add("Services");
		ASAPACHeaders.add("Financial Information");
		ASAPACHeaders.add("Additional Information");
		ASAPACHeaders.add("Status Comments");
		ASAPACHeaders.add("Loss Information");
		ASAPACHeaders.add("System Information");
		System.out.println("ASAPAC Headers List are::" + ASAPACHeaders);
	}

	static ArrayList<String> ASAPACField = new ArrayList<String>();

	public void ASAPACFields() {
		ASAPACField.add("Name");
		ASAPACField.add("AccountId");
		ASAPACField.add("CloseDate");
		ASAPACField.add("RecordTypeId");
		ASAPACField.add("StageName");
		ASAPACField.add("Service__c");
		ASAPACField.add("Phase__c");
		ASAPACField.add("Probability");
		ASAPACField.add("Amount");
		ASAPACField.add("CurrencyIsoCode");
		ASAPACField.add("Total_Size__c");
		ASAPACField.add("Unit_of_Measure__c");
		ASAPACField.add("Deal_IQ_URL__c");
		ASAPACField.add("Next_Steps__c");
		ASAPACField.add("Reason_for_Loss__c");
		ASAPACField.add("Other_Reason_for_Loss__c");
		ASAPACField.add("OwnerId");
		ASAPACField.add("Alternate_Opportunity_Owner__c");
		ASAPACField.add("Last_Manually_Modified_By__c");
		ASAPACField.add("Last_Manually_Modified_Date__c");

		System.out.println("Asset Services APAC Fields List are::" + ASAPACField);		
	}

	static ArrayList<String> ASAPACFieldLabelsAPI = new ArrayList<String>();

	public void OpportunitiesPageFieldsValidation() {
		try {
			establishConnection.establishConnection();
			ASAPACHeadings();
			ASAPACFields();
			DescribeLayoutResult dlr = EstablishConnection.connection.describeLayout("Opportunity", null, null);
			int count=0, countLabelList = 0;
			for (int i = 0; i < dlr.getLayouts().length; i++) {
				DescribeLayout layout = dlr.getLayouts()[i];
				DescribeLayoutSection[] editLayoutSectionList = layout.getEditLayoutSections();
				// Write the headings of the edit layout sections
				for (int x = 0; x < editLayoutSectionList.length; x++) {
					if(dataTable.getData("General_Data", "TC_ID").contains("ASAPAC")) {
						if(editLayoutSectionList.length==7) {
							if(editLayoutSectionList[x].getHeading().equals(ASAPACHeaders.get(x))) {
								System.out.println(x + ":::Asset Services APAC has the heading layout section:::" + editLayoutSectionList[x].getHeading());
								report.updateTestLog(x + ":::Asset Services APAC ", " has the heading layout section:::" + editLayoutSectionList[x].getHeading(), Status.PASS);
								count++;
							}
						}				
					}						
				}	
				System.out.println(count);			
				if(dataTable.getData("General_Data", "TC_ID").contains("ASAPAC")) {
					if(editLayoutSectionList.length==7) {
						for (int k = 0; k < editLayoutSectionList.length; k++) {
							DescribeLayoutSection els = editLayoutSectionList[k];
							DescribeLayoutRow[] dlrList = els.getLayoutRows();
							for (int m = 0; m < dlrList.length; m++) {
								DescribeLayoutRow lr = dlrList[m];
								DescribeLayoutItem[] dliList = lr.getLayoutItems();
								for (int n = 0; n < dliList.length; n++) {
									DescribeLayoutItem li = dliList[n];
									if ((li.getLayoutComponents() != null) && (li.getLayoutComponents().length > 0)) {
										ASAPACFieldLabelsAPI.add(li.getLayoutComponents()[0].getValue());
									}
								}
							}
						}	
						System.out.println("ABAMER Field Label::: " + ASAPACFieldLabelsAPI);
						for(int i1=0; i1 < ASAPACField.size(); i1++) {
							if(ASAPACFieldLabelsAPI.get(i1).equals(ASAPACField.get(i1))) {						
								System.out.println("Field Label:::" + ASAPACFieldLabelsAPI.get(i1) + " -- is present in CM APAC:::");
								report.updateTestLog("Verify Field Labels", " has the field label:::" + ASAPACFieldLabelsAPI.get(i1), Status.PASS);
								countLabelList++;
							}			 
						}
						System.out.println("Count of fields present in Asset Services APAC::" + countLabelList);
					}
				}						
			}				
			if(dataTable.getData("General_Data", "TC_ID").contains("ASAPAC")) {
				if(count==7) {
					ASAPACHeaders.clear();
					System.out.println("Asset Services APAC have all the header sections present::");
					report.updateTestLog("Validating Header Sections", "Admin/Agency Brokerage/Occupier Brokerage AMER - All the headers are present", Status.PASS);
				}								
			} 
			ASAPACField.clear();
			if (countLabelList == 20) {
				System.out.println("All the fields are present::");
				report.updateTestLog("Count of fields present", "All the fields are present in Asset Services APAC", Status.PASS);
			} 	
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	/**
	 * Function for the validating the fields on the Opportunities Page
	 * 
	 * @author Vishnuvardhan
	 *
	 */	

	/*public void OpportunitiesPageFieldsValidation() {	
		try{
			establishConnection.establishConnection();
			DescribeLayoutResult dlr = EstablishConnection.connection.describeLayout("Opportunity", null, null);
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
	}*/

}