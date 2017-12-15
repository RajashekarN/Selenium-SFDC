package pagesAPI;

import org.openqa.selenium.support.PageFactory;

import com.cognizant.Craft.ReusableLibrary;
import com.cognizant.Craft.ScriptHelper;
import com.cognizant.framework.Status;
import com.sforce.soap.partner.DeleteResult;
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
	SearchTextSOQL searchTextSOQL = new SearchTextSOQL(scriptHelper);

	/**
	 * Function for the creation of private tag to an account
	 * 
	 * @author Vishnuvardhan
	 *
	 */ 

	public String createPrivateTag() {
		establishConnection.establishConnectionSpecificUser();
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
		
		if(dataTable.getData("General_Data", "TC_ID").contains("Account"))  {
			privateTag.setType("Private_Tag_with_Account__c");
			String accountName = searchTextSOQL.fetchRecord("Account", "Id");
			privateTag.setField("AccountRelatedTo__c", accountName);
		} else if(dataTable.getData("General_Data", "TC_ID").contains("Opportunity")) {
			String opportunityName = searchTextSOQL.fetchRecord("Opportunity", "Id");
			privateTag.setType("Private_Tag_with_Opportunity__c");
			privateTag.setField("OpportunityRelatedTo__c", opportunityName);
		} else if(dataTable.getData("General_Data", "TC_ID").contains("Contact")) {
			privateTag.setType("Private_Tag_with_Contact__c");
			String contactName = searchTextSOQL.fetchRecord("Contact", "Id");
			privateTag.setField("ContactRelatedTo__c", contactName);
		} else if (dataTable.getData("General_Data", "TC_ID").contains("Lead")) {
			privateTag.setType("Private_Tag_with_Lead__c");
			String leadName = searchTextSOQL.fetchRecord("Lead", "Id");
			privateTag.setField("LeadRelatedTo__c", leadName);
		} else if (dataTable.getData("General_Data", "TC_ID").contains("Property")) {
			privateTag.setType("Private_Tag_with_Property__c");
			String propertyName = searchTextSOQL.fetchRecord("Property__c", "Id");
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
			if(sAccountRelationId.startsWith("001")) {
				report.updateTestLog("Verify Create Private Tag", "Private Tag for Account has been created successfully", Status.PASS);
				count++;
			}
		} else if(dataTable.getData("General_Data", "TC_ID").contains("Opportunity")) {
			sOpportunityRelationId = searchTextSOQL.fetchRecordFieldValue("OpportunityRelatedTo__c", opportunityRelation);
			if(sOpportunityRelationId.startsWith("006")) {
				report.updateTestLog("Verify Create Private Tag", "Private Tag for Opportunity has been created successfully", Status.PASS);
				count++;
			} 
		} else if(dataTable.getData("General_Data", "TC_ID").contains("Contact")) {
			sContactRelationId = searchTextSOQL.fetchRecordFieldValue("ContactRelatedTo__c", contactRelation);
			if(sContactRelationId.startsWith("003")) {
				report.updateTestLog("Verify Create Private Tag", "Private Tag for Contact has been created successfully", Status.PASS);
				count++;
			}
		} else if (dataTable.getData("General_Data", "TC_ID").contains("Lead")) {
			sLeadRelationId = searchTextSOQL.fetchRecordFieldValue("LeadRelatedTo__c", leadRelation);
			if(sLeadRelationId.startsWith("00Q")) {
				report.updateTestLog("Verify Create Private Tag", "Private Tag for Lead has been created successfully", Status.PASS);
				count++;
			} 
		} else if (dataTable.getData("General_Data", "TC_ID").contains("Property")) {
			sPropertyRelationId = searchTextSOQL.fetchRecordFieldValue("PropertyRelatedTo__c", propertyRelation);
			if(sPropertyRelationId.startsWith("a0M")) {
				report.updateTestLog("Verify Create Private Tag", "Private Tag for Property has been created successfully", Status.PASS);
				count++;
			} 
		}				
		if(count==1) {
				report.updateTestLog("Verify Create Private Tag", "Private Tag for Account/Contact/ Lead/ Opportunity/ Property creation failed", Status.PASS);
		} else {
			report.updateTestLog("Verify Create Private Tag", "Private Tag for Account/Contact/ Lead/ Opportunity/ Property creation failed", Status.FAIL);
		}
	}
}