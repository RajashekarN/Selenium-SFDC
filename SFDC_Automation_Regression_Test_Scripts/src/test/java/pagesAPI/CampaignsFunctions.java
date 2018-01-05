package pagesAPI;

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

public class CampaignsFunctions extends ReusableLibrary {
	/*
	 * Constructor to initialize the business component library
	 * 
	 * @param scriptHelper The {@link ScriptHelper} object passed from the
	 * {@link DriverScript}
	 */

	public CampaignsFunctions(ScriptHelper scriptHelper) {
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
	ContactsFunctions contactsFunctions = new ContactsFunctions(scriptHelper);
	LeadsFunctions leadsFunctions = new LeadsFunctions(scriptHelper);
	SearchTextSOQL searchTextSOQL = new SearchTextSOQL(scriptHelper);
	int offsetValue = new Random().nextInt(9);
	
	/**
	 * Function for the creation of Campaign
	 * 
	 * @author Vishnuvardhan
	 *
	 */ 

	public String createCampaign() {
		establishConnection.establishConnection();
		SObject campaign = new SObject();
		campaign.setType("Campaign");
		campaign.setField("Name", "Test Campaign"+ "_" + Utility_Functions.xGenerateAlphaNumericString());
		campaign.setField("Type","Email");
		campaign.setField("Status", "Planned");
		String opportunityQuery = "Select Id from Opportunity ORDER BY CreatedDate DESC"  + " limit 1 offset " + offsetValue;
		String propertyQuery = "Select Id from Property__c ORDER BY CreatedDate DESC"  + " limit 1 offset " + offsetValue;
		String sOpportunityId = searchTextSOQL.fetchRecordFieldValue("Id", opportunityQuery);
		String sPropertyId = searchTextSOQL.fetchRecordFieldValue("Id", propertyQuery);
		campaign.setField("Opportunity__c", sOpportunityId);
		campaign.setField("APAC_Property__c", sPropertyId);
		SObject[] campaigns = new SObject[1];
		campaigns[0] = campaign;
		try {
			results = EstablishConnection.connection.create(campaigns);
			System.out.println(results);
		} catch (ConnectionException e) {			
			e.printStackTrace();
		}
		System.out.println("Result:::" + results);
		String sCampaignId = establishConnection.saveResultsId(results);
		if(sCampaignId.startsWith("701")) {
			report.updateTestLog("Verify Create Campaign", "Campaign has been created successfully", Status.PASS);
		} else {
			report.updateTestLog("Verify Create Campaign", "Campaign creation failed", Status.FAIL);
		}
		return sCampaignId;
	}		
	
	/**
	 * Function for the contact add to Campaign 
	 * 
	 * @author Vishnuvardhan
	 *
	 */ 

	public void associateCampagin() {
		String sCampaignId = createCampaign();
		/*String contactQuery = "Select Id from Contact ORDER BY CreatedDate DESC"  + " limit 1 offset " + offsetValue;
		String sContactId = searchTextSOQL.fetchRecordFieldValue("Id", contactQuery);*/
		
		String noOfContactsQuery, sNoOfContacts = null, noOfLeadsQuery, sNoOfLeads = null;
		
		if(dataTable.getData("General_Data", "TC_ID").contains("Contact")) {
			noOfContactsQuery = "SELECT NumberOfContacts FROM Campaign where Id = " + "'" + sCampaignId +"'";
			sNoOfContacts = searchTextSOQL.fetchRecordFieldValue("NumberOfContacts", noOfContactsQuery);
		} else if(dataTable.getData("General_Data", "TC_ID").contains("Lead")) {
			noOfLeadsQuery = "SELECT NumberOfLeads FROM Campaign where Id = " + "'" + sCampaignId +"'";
			sNoOfLeads = searchTextSOQL.fetchRecordFieldValue("NumberOfLeads", noOfLeadsQuery);
		}		
		String sNewContactID = null, sNewLeadID = null;
		SObject campaignMember = new SObject();
		campaignMember.setType("CampaignMember");
		campaignMember.setField("CampaignId", sCampaignId);
		
		if(dataTable.getData("General_Data", "TC_ID").contains("Contact")) {
			report.updateTestLog("Verify Number of Contacts", "There are these many contacts associated to this Campaign:::" + sNoOfContacts, Status.PASS);
			sNewContactID = contactsFunctions.createContactRequiredFields();
			campaignMember.setField("ContactId", sNewContactID);
		} else 	if(dataTable.getData("General_Data", "TC_ID").contains("Lead")) {
			report.updateTestLog("Verify Number of Leads", "There are these many Lead associated to this Campaign:::" + sNoOfLeads, Status.PASS);
			sNewLeadID = leadsFunctions.createNewLeadConversion();
			campaignMember.setField("LeadId", sNewLeadID);
		}

		SObject[] campaignMembers = new SObject[1];
		campaignMembers[0] = campaignMember;
		try {
			results = EstablishConnection.connection.create(campaignMembers);
			System.out.println(results);
		} catch (ConnectionException e) {			
			e.printStackTrace();
		}
		System.out.println("Result:::" + results);
		String sCampaignContactAssociation = establishConnection.saveResultsId(results);
		if(sCampaignContactAssociation.startsWith("00v")) {
			report.updateTestLog("Verify Create Campaign", "Contact associated to Campaign successfully", Status.PASS);
		} else {
			report.updateTestLog("Verify Create Campaign", "Contact association to Campaign failed", Status.FAIL);
		}	
		if(dataTable.getData("General_Data", "TC_ID").contains("Contact")) {
			String noOfContactsQuerySecond = "SELECT NumberOfContacts FROM Campaign where Id = " + "'" + sCampaignId +"'";
			String sNoOfContactsSecond = searchTextSOQL.fetchRecordFieldValue("NumberOfContacts", noOfContactsQuerySecond);
			//int numberOfContactsAssociated = Integer.parseInt(sNoOfContactsSecond);
			if(sNoOfContactsSecond.equals("1")) {
				report.updateTestLog("Verify Number of Contacts", "After associated the contact the no of contacts is incremented by:::" + sNoOfContactsSecond, Status.PASS);
			} else {
				report.updateTestLog("Verify Number of Contacts", "Count of contacts associated isn't correct:::" + sNoOfContactsSecond, Status.FAIL);
			}
		} else if(dataTable.getData("General_Data", "TC_ID").contains("Lead")) {
			String noOfLeadsQuerySecond = "SELECT NumberOfLeads FROM Campaign where Id = " + "'" + sCampaignId +"'";
			String sNoOfLeadsSecond = searchTextSOQL.fetchRecordFieldValue("NumberOfLeads", noOfLeadsQuerySecond);
			//int numberOfLeadsAssociated = Integer.parseInt(sNoOfLeadsSecond);
			if(sNoOfLeadsSecond.equals("1")) {
				report.updateTestLog("Verify Number of Contacts", "After associating the lead the no of Leads is incremented by:::" + sNoOfLeadsSecond, Status.PASS);
			} else {
				report.updateTestLog("Verify Number of Contacts", "Count of Leads associated isn't correct:::" + sNoOfLeadsSecond, Status.FAIL);
			}
		}		
	}		
}