package pagesAPI;


import java.util.ArrayList;
import java.util.Calendar;
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
	 * Validate Opportunity Name is not auto generated when manually added by
	 * the user
	 * 
	 * @author Vishnuvardhan
	 *
	 */

	static String result;

	public String manualOpportunityCreation() {
		try {

			boolean isStatus = false;
			while (!isStatus) {
				establishConnection.establishConnection();
				SObject opportunity = new SObject();
				Random random = new Random();
				int value = random.nextInt();
				String opportunityName = "Test Automation_Opportunity" + value;
				opportunity.setType("Opportunity");
				opportunity.setField("Name", opportunityName);
				SearchTextSOQL accountID = new SearchTextSOQL(scriptHelper);
				String accountId = accountID.fetchRecord("Account", "Id");
				opportunity.setField("AccountId", accountId);
				opportunity.setField("CloseDate", Calendar.getInstance());
				opportunity.setField("StageName", "Qualification");

				if ((dataTable.getData("General_Data", "TC_ID").contains("CM")) && (dataTable.getData("General_Data", "TC_ID").contains("DSF"))) {
					opportunity.setField("RecordTypeId", "012i0000000405lAAA");
					// opportunity.setField("Estimated_Gross_Fee_Commission__c", 10000);
					report.updateTestLog("Opportunity Name", "Record type is set as Capital Markets - Debt & Structured Finance:::", Status.PASS);
				} else if ((dataTable.getData("General_Data", "TC_ID").contains("CM")) && (dataTable.getData("General_Data", "TC_ID").contains("PS"))) {
					opportunity.setField("RecordTypeId", "012i0000000405kAAA");
					report.updateTestLog("Opportunity Name", "Record type is set as Property Sales", Status.PASS);
				} else if ((dataTable.getData("General_Data", "TC_ID").contains("GWSAMER"))
						|| (dataTable.getData("General_Data", "TC_ID").contains("GWSAPAC"))
						|| (dataTable.getData("General_Data", "TC_ID").contains("GWSEMEA"))) {
					opportunity.setField("RecordTypeId", "012i0000000405mAAA");
					opportunity.setField("Service__c", "Service Contract Exclusive");
					report.updateTestLog("Opportunity Name", "Record type is set as Global Workplace Solutions",
							Status.PASS);
				} else if ((dataTable.getData("General_Data", "TC_ID").contains("VASAMER"))
						|| (dataTable.getData("General_Data", "TC_ID").contains("VASAPAC"))
						|| (dataTable.getData("General_Data", "TC_ID").contains("VASEMEA"))) {
					opportunity.setField("RecordTypeId", "0121Y000001EVzFQAW");
					opportunity.setField("Region__c", "US National");
					opportunity.setField("Market__c	", "Austin");
					opportunity.setField("Environmental__c	", "Yes");
					opportunity.setField("Property_Condition__c", "Yes");
					opportunity.setField("Facility_Assessment__c", "Yes");
					opportunity.setField("Appraisal__c", "Yes");

					report.updateTestLog("Opportunity Name", "Record type is set as Valuation & Advisory Services",
							Status.PASS);
				} else if ((dataTable.getData("General_Data", "TC_ID").contains("ASAMER"))
						|| (dataTable.getData("General_Data", "TC_ID").contains("ASAPAC"))
						|| (dataTable.getData("General_Data", "TC_ID").contains("ASEMEA"))) {
					opportunityNameAutoGenerate_API();
					isStatus = false;
					break;
				} else if ((dataTable.getData("General_Data", "TC_ID").contains("ABAMER"))
						|| (dataTable.getData("General_Data", "TC_ID").contains("ABAPAC"))
						|| (dataTable.getData("General_Data", "TC_ID").contains("ABEMEA"))) {
					opportunity.setField("RecordTypeId", "012i0000001622CAAQ");
					opportunity.setField("Service__c", "Consulting");
					opportunity.setField("Total_Size__c", 999);
					opportunity.setField("CBRE_Preferred_Property_Type_c__c", "Hotel");
					report.updateTestLog("Opportunity Name", "Record type is set as Agency Brokerage", Status.PASS);
				} else if ((dataTable.getData("General_Data", "TC_ID").contains("OBAMER"))
						|| (dataTable.getData("General_Data", "TC_ID").contains("OBAPAC"))
						|| (dataTable.getData("General_Data", "TC_ID").contains("OBEMEA"))) {
					opportunity.setField("RecordTypeId", "012i0000000405nAAA");
					opportunity.setField("Service__c", "Consulting");
					opportunity.setField("Total_Size__c", 999);
					opportunity.setField("CBRE_Preferred_Property_Type_c__c", "Hotel");
					report.updateTestLog("Opportunity Name", "Record type is set as Occupier Brokerage", Status.PASS);
				} else {
					opportunity.setField("RecordTypeId", "012i0000000405n");
				}
				opportunity.setField("Amount", "20000");
				opportunity.setField("StageName","02-Meeting");
				SObject[] opportunities = new SObject[1];
				opportunities[0] = opportunity;
				try {
					results = EstablishConnection.connection.create(opportunities);
				} catch (Exception e) {
					e.printStackTrace();
				}
				System.out.println("Result:::" + results);
				for (int j = 0; j < results.length; j++) {
					if (results[j].isSuccess()) {
						result = results[j].getId();
					}
				}
				System.out.println(result);
				SearchTextSOQL searchTextSOQL = new SearchTextSOQL(scriptHelper);
				String query = "Select Name from Opportunity where Id = '" + result + "'";
				String generatedOpportunityName = searchTextSOQL.fetchRecordFieldValue("Name", query);
				if (opportunityName.equals(generatedOpportunityName)) {
					report.updateTestLog("Opportunity Name",
							"Opportunity Name is not auto generated when Opportunity is manually added by the User::",
							Status.PASS);
				} else {
					report.updateTestLog("Opportunity Name", "Failure in the Opportunity Name generation:::",
							Status.FAIL);
				}
				if (dataTable.getData("General_Data", "TC_ID").contains("DSF")) {
					String queryRecordType = "Select RecordTypeId from Opportunity where Id = '" + result + "'";
					String recordType = searchTextSOQL.fetchRecordFieldValue("RecordTypeId", queryRecordType);
					if (recordType.equals("012i0000000405lAAA")) {
						report.updateTestLog("Opportunity Name",
								"Opportunity is created by selecting the Record Type as Capital Markets - Debt & Structured Finance:::",
								Status.PASS);
					} else if (recordType.equals("012i0000000405kAAA")) {
						report.updateTestLog("Opportunity Name",
								"Opportunity is created by selecting the Record Type  as Property Sales:::",
								Status.PASS);
					} else if (recordType.equals("012i0000000405mAAA")) {
						report.updateTestLog("Opportunity Name",
								"Opportunity is created by selecting the Record Type  as Global Workplace Solutions:::",
								Status.PASS);
					} else if (recordType.equals("012i0000000405oAAA")) {
						report.updateTestLog("Opportunity Name",
								"Opportunity is created by selecting the Record Type  as Valuation & Advisory Services:::",
								Status.PASS);
					} else if (recordType.equals("012i0000001622CAAQ")) {
						report.updateTestLog("Opportunity Name",
								"Opportunity is created by selecting the Record Type  as Agency Brokerage:::",
								Status.PASS);
					} else if (recordType.equals("012i0000000405nAAA")) {
						report.updateTestLog("Opportunity Name",
								"Opportunity is created by selecting the Record Type  as Occupier Brokerage:::",
								Status.PASS);
					} else {
						report.updateTestLog("Opportunity Name",
								"Opportunity is not as created as per the selection:::", Status.FAIL);
					}
				}
				isStatus = true;
			}

		} catch (Exception e) {
			System.out.println(e.getMessage());
			System.out.println(e.getStackTrace());
		}
		return result;
	}
	
	/**
	 * Function for creating an Opportunity
	 * 
	 * @author Vishnuvardhan
	 *
	 */

	public String opportunityNameAutoGenerate_API() {
		String accountName = null;
		try {
			establishConnection.establishConnection();
			SObject opportunity = new SObject();
			opportunity.setType("Opportunity");
			/*
			 * SearchTextSOQL accountID = new SearchTextSOQL(scriptHelper);
			 * String accountId = accountID.fetchRecord("Account", "Id");
			 */
			int value = Utility_Functions.xRandomFunction();
			opportunity.setField("Name", "Test Automation_" + value);
			opportunity.setField("AccountId", "0010S000004SaIHQA0");
			opportunity.setField("CloseDate", Calendar.getInstance());
			if ((dataTable.getData("General_Data", "TC_ID").contains("ASAMER"))
					|| (dataTable.getData("General_Data", "TC_ID").contains("ASAPAC"))
					|| (dataTable.getData("General_Data", "TC_ID").contains("ASEMEA"))) {
				opportunity.setField("RecordTypeId", "012i0000000405jAAA");
			} else if ((dataTable.getData("General_Data", "TC_ID").contains("GWSAMER"))
					|| (dataTable.getData("General_Data", "TC_ID").contains("GWSAPAC"))
					|| (dataTable.getData("General_Data", "TC_ID").contains("GWSEMEA"))) {
				opportunity.setField("RecordTypeId", "012i0000000405mAAA");
			} else if (dataTable.getData("General_Data", "TC_ID").contains("CM")
					&& (dataTable.getData("General_Data", "TC_ID").contains("DSF"))) {
				opportunity.setField("RecordTypeId", "012i0000000405lAAA");
			} else if ((dataTable.getData("General_Data", "TC_ID").contains("OBAMER"))
					|| (dataTable.getData("General_Data", "TC_ID").contains("OBAPAC"))
					|| (dataTable.getData("General_Data", "TC_ID").contains("OBEMEA"))) {
				opportunity.setField("RecordTypeId", "012i0000000405nAAA");
			}

			opportunity.setField("StageName", "1-Target");
			// opportunity.setField("Service__c", "Business Valuation");
			opportunity.setField("Total_Size__c", 5000);
			opportunity.setField("Unit_of_Measure__c", "Acres");
			opportunity.setField("Type_of_Client__c", "New Business");

			opportunity.setField("Leasing__c", "Yes");
			opportunity.setField("Management__c", "Yes");
			opportunity.setField("Capital_Markets__c", "Yes");
			opportunity.setField("Accounting__c", "Yes");
			opportunity.setField("Tech_Services__c", "Yes");
			opportunity.setField("Project_Management__c	", "Yes");
			opportunity.setField("Sustainability__c", "Yes");
			opportunity.setField("Consultancy__c", "Yes");
			opportunity.setField("FM_Lite__c", "Yes");

			if (dataTable.getData("General_Data", "TC_ID").contains("AMER")) {
				opportunity.setField("Region__c	", "US National");
				opportunity.setField("Market__c	", "Boston");
			} else if (dataTable.getData("General_Data", "TC_ID").contains("EMEA")) {
				opportunity.setField("Region__c	", "EMEA");
				opportunity.setField("Market__c	", "Africa");
			} else if (dataTable.getData("General_Data", "TC_ID").contains("APAC")) {
				opportunity.setField("Region__c	", "APAC");
				opportunity.setField("Market__c	", "Australia");
			}
			SObject[] opportunities = new SObject[1];
			opportunities[0] = opportunity;
			results = EstablishConnection.connection.create(opportunities);
			report.updateTestLog("Opportunity Name",
					"Opportunity for the record type Asset Services is created successfully:::", Status.PASS);
			System.out.println("Result:::" + results);
			for (int j = 0; j < results.length; j++) {
				if (results[j].isSuccess()) {
					result = results[j].getId();
					System.out.println("Save Results:::" + result);
					report.updateTestLog("Opportunity Name", "Opportunity Id:::" + result + " successfully:::",
							Status.PASS);
				}
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
			System.out.println(e.getStackTrace());
		}
		return result + ":" + accountName;
	}
	
	/**
	 * Validating the Auto Generated Opportunity Account Name modification
	 * 
	 * @author Vishnuvardhan
	 *
	 */

	public void modifyAutoGeneratedOpportunityName() {
		try {
			String recordTypeId;
			if (dataTable.getData("General_Data", "TC_ID").contains("DSF")) {
				recordTypeId = "012i0000000405lAAA";
				report.updateTestLog("Opportunity Name",
						"Record type is set as Capital Markets - Debt & Structured Finance:::", Status.PASS);
			} else if (dataTable.getData("General_Data", "TC_ID").contains("PS")) {
				recordTypeId = "012i0000000405kAAA";
				report.updateTestLog("Opportunity Name", "Record type is set as Property Sales", Status.PASS);
			} else if (dataTable.getData("General_Data", "TC_ID").contains("GWS")) {
				recordTypeId = "012i0000000405mAAA";
				report.updateTestLog("Opportunity Name", "Record type is set as Global Workplace Solutions",
						Status.PASS);
			} else if (dataTable.getData("General_Data", "TC_ID").contains("VAS")) {
				recordTypeId = "012i0000000405oAAA";
				report.updateTestLog("Opportunity Name", "Record type is set as Valuation & Advisory Services",
						Status.PASS);
			} else if (dataTable.getData("General_Data", "TC_ID").contains("AS")) {
				recordTypeId = "012i0000000405jAAA";
				report.updateTestLog("Opportunity Name", "Record type is set as Asset Services", Status.PASS);
			} else if (dataTable.getData("General_Data", "TC_ID").contains("AB")) {
				recordTypeId = "012i0000001622CAAQ";
				report.updateTestLog("Opportunity Name", "Record type is set as Agency Brokerage", Status.PASS);
			} else if (dataTable.getData("General_Data", "TC_ID").contains("OB")) {
				recordTypeId = "012i0000000405nAAA";
				report.updateTestLog("Opportunity Name", "Record type is set as Occupier Brokerage", Status.PASS);
			} else {
				recordTypeId = "012i0000000405n";
			}
			boolean isStatus = false;
			String query = "SELECT Name, Id, Service__C, Total_Size__c, Unit_of_Measure__c FROM Opportunity where Name like "
					+ "'%-%-%-%' and StageName > '03-RFP/Proposal' and StageName < '15-Signed Lease' and RecordTypeId = "
					+ "'" + recordTypeId + "'" + "limit 1 offset 9";
			SearchTextSOQL searchTextSOQL = new SearchTextSOQL(scriptHelper);
			String opportunityID = searchTextSOQL.fetchRecordFieldValue("Id", query);
			while (!isStatus) {
				if (opportunityID == null) {
					report.updateTestLog("Opportunity", "No Opportunities present for the Record Type selected:::",
							Status.PASS);
					isStatus = false;
					break;
				} else {
					String opportunityName = searchTextSOQL.fetchRecordFieldValue("Name", query);
					String assignmentType = searchTextSOQL.fetchRecordFieldValue("Service__c", query);
					String totalSize = searchTextSOQL.fetchRecordFieldValue("Total_Size__c", query);
					String unitOfMeasure = searchTextSOQL.fetchRecordFieldValue("Unit_of_Measure__c", query);
					report.updateTestLog("Fetched Opportunity Name", "Opportunity Name:::" + opportunityName,
							Status.PASS);
					report.updateTestLog("Fetched Opportunity Name", "Opportunity Assignment Type:::" + assignmentType,
							Status.PASS);
					report.updateTestLog("Fetched Opportunity Name", "Opportunity Total Size:::" + totalSize,
							Status.PASS);
					report.updateTestLog("Fetched Opportunity Name", "Opportunity Unit of Measure:::" + unitOfMeasure,
							Status.PASS);
					updateOpportunityField("Service__c", opportunityID);
					updateOpportunityField("Total_Size__c", opportunityID);
					updateOpportunityField("Unit_of_Measure__c", opportunityID);

					String updatedAssignmentType = searchTextSOQL.fetchRecordFieldValue("Service__c", query);
					String updatedTotalSize = searchTextSOQL.fetchRecordFieldValue("Total_Size__c", query);
					String updatedUnitOfMeasure = searchTextSOQL.fetchRecordFieldValue("Unit_of_Measure__c", query);
					if (updatedAssignmentType.equals("Project Management")) {
						report.updateTestLog("Modified Opportunity Name",
								"Opportunity Name modified according to the AssignmentType selected:::"
										+ updatedAssignmentType,
								Status.PASS);
					} else {
						report.updateTestLog("Modified Opportunity Name",
								"Opportunity Name didn't get modified according to the AssignmentType selected:::"
										+ updatedAssignmentType,
								Status.FAIL);
					}
					if (updatedTotalSize.equals("2900.0")) {
						report.updateTestLog("Modified Opportunity Name",
								"Opportunity Name modified according to the Total Size selected:::" + updatedTotalSize,
								Status.PASS);
					} else {
						report.updateTestLog("Modified Opportunity Name",
								"Opportunity Name didn't get modified according to the Total Size selected:::"
										+ updatedTotalSize,
								Status.FAIL);
					}
					if (updatedUnitOfMeasure.equals("Hectares")) {
						report.updateTestLog("Modified Opportunity Name",
								"Opportunity Name modified according to the Unit of Measure selected:::"
										+ updatedUnitOfMeasure,
								Status.PASS);
					} else {
						report.updateTestLog("Modified Opportunity Name",
								"Opportunity Name didn't get modified according to the Unit of Measure selected:::"
										+ updatedUnitOfMeasure,
								Status.FAIL);
					}
					isStatus = true;
				}
			}
		} catch (Exception e) {
			e.getMessage();
		}

	}
	
	/**
	 * Verify the required fields based on Sales Stage selected between
	 * 03-RFP/Proposal to 07-Under Contract on Opportunity from a broker profile
	 * 
	 * @author Vishnuvardhan
	 *
	 */
	
	SearchTextSOQL searchTextSOQL = new SearchTextSOQL(scriptHelper);
	
	public void salesStage03_RFPProposal_07UnderContract() {
		String query = "SELECT Estimated_Gross_Fee_Commission__c , Id, Name FROM Opportunity where StageName > '03-RFP/Proposal' and StageName < '07-Under Contract' and Estimated_Gross_Fee_Commission__c = 0.0 limit 10";
		String OpportunityID = searchTextSOQL.searchOpportunity(query);
		System.out.println(OpportunityID);
		if (OpportunityID == null) {
			report.updateTestLog("Verify Opportunity", "There are no Opportunities that falls under this category:::",
					Status.PASS);
		} else {
			report.updateTestLog("Verify Opportunity Required Fields",
					"Opportunity retrived from database is:::" + OpportunityID, Status.PASS);
			String estimatedGrossFeeCommmission = "SELECT Estimated_Gross_Fee_Commission__c FROM Opportunity where Id = "
					+ "'" + OpportunityID + "'";
			String estimatedGrossFeeCommission_Value = searchTextSOQL
					.fetchRecordFieldValue("Estimated_Gross_Fee_Commission__c", estimatedGrossFeeCommmission);
			report.updateTestLog("Verify Opportunity Required Fields",
					"Estimated Gross Fee Commission Value is :::" + estimatedGrossFeeCommission_Value, Status.PASS);

			String stagName = "SELECT stageName FROM Opportunity where Id = " + "'" + OpportunityID + "'";
			String stageName_Value = searchTextSOQL.fetchRecordFieldValue("StageName", stagName);
			report.updateTestLog("Verify Opportunity Required Fields", "Stage Name is :::" + stageName_Value,
					Status.PASS);
			updateOpportunityField("StageName", OpportunityID);
			String stageName_UpdatedValue = searchTextSOQL.fetchRecordFieldValue("StageName", stagName);
			if (stageName_UpdatedValue.equals("07-Under Contract")) {
				report.updateTestLog("Verify Opportunity Required Fields",
						"Opportunity Sales Stage is updated successfully :::" + stageName_UpdatedValue, Status.PASS);
			} else {
				report.updateTestLog("Verify Opportunity Required Fields",
						"Opportunity Sales Stage updation failed:::" + stageName_UpdatedValue, Status.FAIL);
			}
		}
	}
	
	/**
	 * Validating the required fields based on Sales Stage selected between
	 * 03-RFP/Proposal to 15-Signed Lease on Opportunity from a broker profile
	 * 
	 * @author Vishnuvardhan
	 *
	 */

	public void requiredFieldsbetweenw03_15Stages() {
		String query = "SELECT Id, Name FROM Opportunity where StageName > '03-RFP/Proposal' and StageName < '10-Short List' "
				+ " and StageName > '13-LOI/Heads of Terms' and StageName < '15-Signed Lease' and Total_Size__c !=null and CBRE_Preferred_Property_Type_c__c !=null limit 1 offset 9";
		String OpportunityID = searchTextSOQL.searchOpportunity(query);
		if (OpportunityID == null) {
			report.updateTestLog("Verify Opportunity", "There are no Opportunities that falls under this category:::",
					Status.PASS);
		} else {
			report.updateTestLog("Verify Opportunity Required Fields",
					"Opportunity retrived from database is:::" + OpportunityID, Status.PASS);
			String url = driver.getCurrentUrl().split("#")[0];
			String newUrl = url + "#/sObject/" + OpportunityID;
			newUrl = newUrl + "/view";
			report.updateTestLog("Verify Add Opportunity Page Fields",
					"URL has been replaced with the new URL having the retrieved Opportunity:::" + newUrl, Status.PASS);
			driver.get(newUrl);

			SearchTextSOQL searchTextSOQL = new SearchTextSOQL(scriptHelper);
			String query_TotalSize = "Select Total_Size__c from Opportunity where Id = " + "'" + OpportunityID + "'";
			String totalSize = searchTextSOQL.fetchRecordFieldValue("Total_Size__c", query_TotalSize);
			String query_PreferredPropertyType = "Select CBRE_Preferred_Property_Type_c__c  from Opportunity where Id = "
					+ "'" + OpportunityID + "'";
			String preferredPropertyType = searchTextSOQL.fetchRecordFieldValue("CBRE_Preferred_Property_Type_c__c",
					query_PreferredPropertyType);

			try {
				if (!(totalSize.equals("")) && !(preferredPropertyType.equals(" "))) {
					report.updateTestLog("Verify Add Opportunity Page Fields",
							"Total Size Value and Preferred Property Type fields has values present", Status.PASS);
				} else {
					report.updateTestLog("Verify Add Opportunity Page Fields",
							"Total Size Value and Preferred Property Type fields has values present", Status.FAIL);
				}
			} catch (Exception e) {
				e.getMessage();
			}
			OpportunitiesFunctions update = new OpportunitiesFunctions(scriptHelper);
			update.updateOpportunityField("StageName", OpportunityID);
			update.updateOpportunityField("EMEA_Success_Probability__c", OpportunityID);
			String updateQuery = "SELECT Id, Name, StageName FROM Opportunity where Id = " + "'" + OpportunityID + "'";
			searchTextSOQL.searchOpportunity(updateQuery);
			String resultQuery = "SELECT Id, Name, StageName FROM Opportunity where Id = " + "'" + OpportunityID + "'";
			String opportunityStage = searchTextSOQL.fetchRecordFieldValue("StageName", resultQuery);
			System.out.println(opportunityStage);
			if (opportunityStage.contains("Closed")) {
				report.updateTestLog("Verify Opportunity Update", "Sales Stage has been updated successfully",
						Status.PASS);
			} else {
				report.updateTestLog("Verify Opportunity Update", "Sales Stage updation has been failed", Status.FAIL);
			}
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