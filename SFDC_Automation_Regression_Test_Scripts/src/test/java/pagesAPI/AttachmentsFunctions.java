 package pagesAPI;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Calendar;
import java.util.Random;

import org.openqa.selenium.support.PageFactory;

import com.cognizant.Craft.ReusableLibrary;
import com.cognizant.Craft.ScriptHelper;
import com.cognizant.framework.Status;
import com.sforce.soap.partner.DeleteResult;
import com.sforce.soap.partner.SaveResult;
import com.sforce.soap.partner.sobject.SObject;
import com.sforce.ws.ConnectionException;


public class AttachmentsFunctions extends ReusableLibrary {
	/*
	 * Constructor to initialize the business component library
	 * 
	 * @param scriptHelper The {@link ScriptHelper} object passed from the
	 * {@link DriverScript}
	 */

	public AttachmentsFunctions(ScriptHelper scriptHelper) {
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
	SearchTextSOQL searchTextSOQL = new SearchTextSOQL(scriptHelper);
	TaskEventsFunctions taskEventsFunctions = new TaskEventsFunctions(scriptHelper);
	int offsetValue = new Random().nextInt(9);

	/**
	 * Function for the creation of an Task
	 * 
	 * @author Vishnuvardhan
	 *
	 */
	Calendar calendar = Calendar.getInstance();

	public String createAttachment() {
		String sParentId = null;
		if(dataTable.getData("General_Data", "TC_ID").contains("Task")) 
			sParentId = taskEventsFunctions.createTask();
		else if(dataTable.getData("General_Data", "TC_ID").contains("Event"))
			sParentId = taskEventsFunctions.createEvent();
		//establishConnection.establishConnectionSpecificUser();
		File file = new File("src/test/resources");
		File path = new File(file,"Sample Test Automation.txt");		
		byte[] body = null;
		try {
			InputStream inputStream = new FileInputStream(path.getAbsoluteFile());
			 body = new byte[(int)path.length()];
			inputStream.read(body);
			inputStream.close();
		} catch (Exception e1) {
			e1.printStackTrace();
		}	
		/*String query = "SELECT Id FROM Task where Status = 'Open' ORDER BY CreatedDate DESC LIMIT 1";
		String sTaskId = searchTextSOQL.fetchRecordFieldValue("Id", query);*/
		SObject attachment = new SObject();
		attachment.setType("Attachment");
		attachment.setField("Name", "Sample Test Automation.txt");
		attachment.setField("ParentId", sParentId);
		attachment.setField("Body", body);
  
		SObject[] attachments = new SObject[1];
		attachments[0] = attachment;
		try {
			results = EstablishConnection.connection.create(attachments);
		} catch (ConnectionException e) {
			e.printStackTrace();
		}
		System.out.println("Result:::" + results);
		String status = establishConnection.saveResultsId(results);	
		if(status.startsWith("00P")) {
			report.updateTestLog("Verify Create Task", "Attachment has been created successfully", Status.PASS);
		} else {
			report.updateTestLog("Verify Create Task", "Attachment creation failed", Status.FAIL);
		} 
		return status;
	}

	
}