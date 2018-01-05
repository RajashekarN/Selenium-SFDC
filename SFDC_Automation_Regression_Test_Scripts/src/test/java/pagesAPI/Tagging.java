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
import com.sforce.soap.partner.SaveResult;
import com.sforce.soap.partner.sobject.SObject;
import com.sforce.ws.ConnectionException;

import supportLibraries.Utility_Functions;

public class Tagging extends ReusableLibrary {
	/*
	 * Constructor to initialize the business component library
	 * 
	 * @param scriptHelper The {@link ScriptHelper} object passed from the
	 * {@link DriverScript}
	 */

	public Tagging(ScriptHelper scriptHelper) {
		super(scriptHelper);
		PageFactory.initElements(driver.getWebDriver(), this);
		// new WebDriverUtil(driver);
		// Utility_Functions utility = new Utility_Functions(scriptHelper);
	}

	static SaveResult[] results;
	static DeleteResult[] deleteResults;
	static com.sforce.soap.partner.Error[] errors;
	static boolean status = false;
	static String sPrivateTagName;

	EstablishConnection establishConnection = new EstablishConnection(scriptHelper);
	AccountsFunctions accountsFunctions = new AccountsFunctions(scriptHelper);
	ContactsFunctions contactsFunctions = new ContactsFunctions(scriptHelper);
	LeadsFunctions leadsFunctions = new LeadsFunctions(scriptHelper);
	SearchTextSOQL searchTextSOQL = new SearchTextSOQL(scriptHelper);

	/**
	 * Function for the creation of private tag to an account
	 * 
	 * @author Vishnuvardhan
	 *
	 */ 

	public String createPrivateTag() {
		establishConnection.establishConnection();
		SObject privateTag = new SObject();
		privateTag.setType("Private_Tag__c");
		sPrivateTagName = "PrivateTag" +"_" + Utility_Functions.xGenerateAlphaNumericString();
		privateTag.setField("Name", sPrivateTagName);
		SObject[] privateTags = new SObject[1];
		privateTags[0] = privateTag;
		try {
			results = EstablishConnection.connection.create(privateTags);
		} catch (ConnectionException e) {
			e.printStackTrace();
		}
		System.out.println("Result:::" + results);
		String sPrivateTagId = establishConnection.saveResultsId(results);
		if(sPrivateTagId.startsWith("a02")) {
			report.updateTestLog("Verify Create Private Tag", "Private Tag has been created successfully", Status.PASS);
		} else {
			report.updateTestLog("Verify Create Private Tag", "Private Tag creation failed", Status.FAIL);
		}
		return sPrivateTagId;
	}
	
	public void CustomPrivateTag() {
		String sPrivateTagId = createPrivateTag();
		SObject privateTag = new SObject();
		
		String accountName = null, opportunityName = null, contactName = null, sNewLead = null, propertyName = null, spropertyName = null;
		
		if(dataTable.getData("General_Data", "TC_ID").contains("Account"))  {
			privateTag.setType("Private_Tag_with_Account__c");
			AccountsFunctions accountsFunctions = new AccountsFunctions(scriptHelper);
			accountName = accountsFunctions.createAccountRequiredFields();
			//accountName = searchTextSOQL.fetchRecord("Account", "Id");
			privateTag.setField("AccountRelatedTo__c", accountName);
		} else if(dataTable.getData("General_Data", "TC_ID").contains("Opportunity")) {
			opportunityName = searchTextSOQL.fetchRecord("Opportunity", "Id");
			privateTag.setType("Private_Tag_with_Opportunity__c");
			privateTag.setField("OpportunityRelatedTo__c", opportunityName);
		} else if(dataTable.getData("General_Data", "TC_ID").contains("Contact")) {
			privateTag.setType("Private_Tag_with_Contact__c");
			ContactsFunctions contactsFunctions = new ContactsFunctions(scriptHelper);
			contactName = contactsFunctions.createContactRequiredFields();
			//contactName = searchTextSOQL.fetchRecord("Contact", "Id");
			privateTag.setField("ContactRelatedTo__c", contactName);
		} else if (dataTable.getData("General_Data", "TC_ID").contains("Lead")) {
			privateTag.setType("Private_Tag_with_Lead__c");
			//String leadName = searchTextSOQL.fetchRecord("Lead", "Id");
			sNewLead = leadsFunctions.createNewLead(); 
			privateTag.setField("LeadRelatedTo__c", sNewLead);
		} else if (dataTable.getData("General_Data", "TC_ID").contains("Property")) {
			privateTag.setType("Private_Tag_with_Property__c");
			propertyName = searchTextSOQL.fetchRecord("Property__c", "Id");
			if(propertyName==null) {
				PropertiesFunctions propertiesFunctions = new PropertiesFunctions(scriptHelper);
				spropertyName = propertiesFunctions.createPropertySpecificUser();
				privateTag.setField("PropertyRelatedTo__c", spropertyName);
			} else 
				privateTag.setField("PropertyRelatedTo__c", propertyName);
		}
		privateTag.setField("CustomPrivateTagRelatedTo__c", sPrivateTagId);
		SObject[] privateTags = new SObject[1];
		privateTags[0] = privateTag;
		try {
			results = EstablishConnection.connection.create(privateTags);
		} catch (ConnectionException e) {
			e.printStackTrace();
		}
		System.out.println("Result:::" + results);
		String sCustomePrivateTagId = establishConnection.saveResultsId(results);
		if(sCustomePrivateTagId.startsWith("a0")) {
			report.updateTestLog("Verify Create Private Tag", "Private Tag for Account has been created successfully", Status.PASS);
		} else if(sCustomePrivateTagId.startsWith("a2")) {
			report.updateTestLog("Verify Create Private Tag", "Private Tag for Property has been created successfully", Status.PASS);
		} else {
			report.updateTestLog("Verify Create Private Tag", "Private Tag for Account creation failed", Status.FAIL);
		}
		int count=0;
		String accountRelation = "Select AccountRelatedTo__c from Private_Tag_with_Account__c where Id = " + "'" + sCustomePrivateTagId + "'";
		String contactRelation = "Select ContactRelatedTo__c from Private_Tag_with_Contact__c where Id = " + "'" + sCustomePrivateTagId + "'";
		String leadRelation = "Select LeadRelatedTo__c from Private_Tag_with_Lead__c where Id = " + "'" + sCustomePrivateTagId + "'";
		String opportunityRelation = "Select OpportunityRelatedTo__c from Private_Tag_with_Opportunity__c where Id = " + "'" + sCustomePrivateTagId + "'";
		String propertyRelation = "Select PropertyRelatedTo__c from Private_Tag_with_Property__c where Id = " + "'" + sCustomePrivateTagId + "'";

		String sAccountRelationId = null, sContactRelationId = null, sLeadRelationId= null, sOpportunityRelationId =null, sPropertyRelationId =null;;
		
		if(dataTable.getData("General_Data", "TC_ID").contains("Account"))  {
			sAccountRelationId = searchTextSOQL.fetchRecordFieldValue("AccountRelatedTo__c", accountRelation);
			if(sAccountRelationId.equals(accountName)) {
				report.updateTestLog("Verify Create Private Tag", "Private Tag for Account has been created successfully", Status.PASS);
				count++;
			}
		} else if(dataTable.getData("General_Data", "TC_ID").contains("Opportunity")) {
			sOpportunityRelationId = searchTextSOQL.fetchRecordFieldValue("OpportunityRelatedTo__c", opportunityRelation);
			if(sOpportunityRelationId.equals(opportunityName)) {
				report.updateTestLog("Verify Create Private Tag", "Private Tag for Opportunity has been created successfully", Status.PASS);
				count++;
			} 
		} else if(dataTable.getData("General_Data", "TC_ID").contains("Contact")) {
			sContactRelationId = searchTextSOQL.fetchRecordFieldValue("ContactRelatedTo__c", contactRelation);
			if(sContactRelationId.equals(contactName)) {
				report.updateTestLog("Verify Create Private Tag", "Private Tag for Contact has been created successfully", Status.PASS);
				count++;
			}
		} else if (dataTable.getData("General_Data", "TC_ID").contains("Lead")) {
			sLeadRelationId = searchTextSOQL.fetchRecordFieldValue("LeadRelatedTo__c", leadRelation);
			if(sLeadRelationId.equals(sNewLead)) {
				report.updateTestLog("Verify Create Private Tag", "Private Tag for Lead has been created successfully", Status.PASS);
				count++;
			} 
		} else if (dataTable.getData("General_Data", "TC_ID").contains("Property")) {
			sPropertyRelationId = searchTextSOQL.fetchRecordFieldValue("PropertyRelatedTo__c", propertyRelation);
			if(propertyName==null) {
				if(sPropertyRelationId.equals(spropertyName)) {
					report.updateTestLog("Verify Create Private Tag", "Private Tag for Property has been created successfully", Status.PASS);
					count++;
				} 
			} else {
				if(sPropertyRelationId.equals(propertyName)) {
					report.updateTestLog("Verify Create Private Tag", "Private Tag for Property has been created successfully", Status.PASS);
					count++;
				} 
			}

		}				
		if(count==1) {
				report.updateTestLog("Verify Create Private Tag", "Private Tag for Account/Contact/ Lead/ Opportunity/ Property creation failed", Status.PASS);
		} else {
			report.updateTestLog("Verify Create Private Tag", "Private Tag for Account/Contact/ Lead/ Opportunity/ Property creation failed", Status.FAIL);
		}
	}
	
	public void bulkTaggingFieldsValidation() {	
	try{
		establishConnection.establishConnection();
		DescribeLayoutResult dlr = EstablishConnection.connection.describeLayout("OpportunityTag", null, null);
		for(int i = 0; i < dlr.getLayouts().length; i++) {
			DescribeLayout layout = dlr.getLayouts()[i];
			DescribeLayoutSection[] detailLayoutSectionList = layout.getDetailLayoutSections();
			System.out.println(" There are " + detailLayoutSectionList.length + " detail layout sections");
			report.updateTestLog("Verify Accounts Page Field Validation", "There are " + detailLayoutSectionList.length + " detail layout sections", Status.PASS);
			DescribeLayoutSection[] editLayoutSectionList = layout.getEditLayoutSections();
			System.out.println(" There are " + editLayoutSectionList.length + " edit layout sections");
			report.updateTestLog("Verify Accounts Page Field Validation", " There are " + editLayoutSectionList.length + " edit layout sections", Status.PASS);
			for(int j = 0; j < detailLayoutSectionList.length; j++) {
				System.out.println(j +  " This detail layout section has a heading of " +detailLayoutSectionList[j].getHeading());  
				report.updateTestLog("Verify Accounts Page Field Validation", j +  " This detail layout section has a heading of " +detailLayoutSectionList[j].getHeading(), Status.PASS);
			}
			// Write the headings of the edit layout sections
			for(int x = 0; x < editLayoutSectionList.length; x++) { 
				System.out.println(x + " This edit layout section has a heading of " + editLayoutSectionList[x].getHeading());
				report.updateTestLog("Verify Accounts Page Field Validation", x + " This edit layout section has a heading of " + editLayoutSectionList[x].getHeading(), Status.PASS);
			}
			// For each edit layout section, get its details.
			for(int k = 0; k < editLayoutSectionList.length; k++) {
				DescribeLayoutSection els = editLayoutSectionList[k];   
				System.out.println("Edit layout section heading: " + els.getHeading());
				report.updateTestLog("Verify Accounts Page Field Validation", "Edit layout section heading: " + els.getHeading(), Status.PASS);
				DescribeLayoutRow[] dlrList = els.getLayoutRows();
				System.out.println("This edit layout section has " + dlrList.length + " layout rows");
				report.updateTestLog("Verify Accounts Page Field Validation", "This edit layout section has " + dlrList.length + " layout rows", Status.PASS);
				for(int m = 0; m < dlrList.length; m++) {
					DescribeLayoutRow lr = dlrList[m];
					System.out.println(" This row has " + lr.getNumItems() + " layout items");
					report.updateTestLog("Verify Accounts Page Field Validation", " This row has " + lr.getNumItems() + " layout items", Status.PASS);
					DescribeLayoutItem[] dliList = lr.getLayoutItems();
					for(int n = 0; n < dliList.length; n++) {
						DescribeLayoutItem li = dliList[n];
						if ((li.getLayoutComponents() != null) && (li.getLayoutComponents().length > 0)) {
							System.out.println("\tLayout item " + n +", layout component: " +li.getLayoutComponents()[0].getValue());
							report.updateTestLog("Verify Accounts Page Field Validation", "\tLayout item " + n +", layout component: " +li.getLayoutComponents()[0].getValue(), Status.PASS);
						}
						else {
							System.out.println("\tLayout item " + n +", no layout component");                 
							report.updateTestLog("Verify Accounts Page Field Validation", "\tLayout item " + n +", no layout component", Status.PASS);
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