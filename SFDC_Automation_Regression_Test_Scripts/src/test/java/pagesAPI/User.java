package pagesAPI;


import com.cognizant.Craft.ScriptHelper;
import com.sforce.soap.partner.QueryResult;
import com.sforce.soap.partner.sobject.SObject;
import pagesAPI.EstablishConnection;

/**  
 * @Description : This class constructors are used to get User details based on parametrized values.
 * @author jalapati
 * @Team: CBRE Global
 * @Date 02/18/2018 
 */

public class User extends Object{

	private String Id;
	private String name;
	private String userName;
	private ScriptHelper scriptHelper;
	
 // EstablishApiConnection establishConnection = new EstablishApiConnection(scriptHelper);
	

	
	public User(String userId) throws Exception {
	
		//super("User", userId);
	//	establishConnection.establishConnection();
		
		try{
			
			String query = "SELECT Id,Name,Username FROM User WHERE Id = '" + userId + "'";
			//EstablishApiConnection establishConnection = new EstablishApiConnection(scriptHelper);
			//establishConnection.establishConnection();
			QueryResult result = EstablishConnection.connection.query(query);
			if (result.getSize() > 0) {
				boolean done = false;
				while (!done) {
					for (SObject record : result.getRecords()) {
						this.Id = (String) record.getField("Id");
						this.name = (String) record.getField("Name");
						this.userName = (String) record.getField("Username");
					}
					if (result.isDone()) {
						done = true;
					} else {
						result = EstablishConnection.connection.queryMore(result.getQueryLocator());
					}
				}
			}
		}catch(Exception e){
			e.printStackTrace();
			throw e;
		}
		
	}
	
	public User(String profileName, String isActiveTrueFalse) throws Exception{
		
		//super("User", profileName);
		
		try {
			String query = "SELECT Id,Name,IsActive,profile.name,Pacific_User__c FROM User where IsActive != @ISACTIVE and profile.name = '@PROFILENAME' limit 1 offset 1".replace("@PROFILENAME", profileName).replace("@ISACTIVE", isActiveTrueFalse);
			QueryResult result = EstablishConnection.connection.query(query);
			if (result.getSize() > 0) {
				boolean done = false;
				while (!done) {
					for (SObject record : result.getRecords()) {
						this.Id = (String) record.getField("Id");
						this.name = (String) record.getField("Name");
					}
					if (result.isDone()) {
						done = true;
					} else {
						result = EstablishConnection.connection.queryMore(result.getQueryLocator());
					}
				}
			}
		} catch (Exception e) {
			
			e.printStackTrace();
			throw e;
			
		}
		
	}
	
	
	public User(String userName, String userFirstName, String userLastName) throws Exception{
		//super("User", "profileName");
		
		try {
			
			String query = "SELECT Id,Name FROM User WHERE Name like '@USERNAME%'".replace("@USERNAME", userName);
			QueryResult result = EstablishConnection.connection.query(query);
			if (result.getSize() > 0) {
				boolean done = false;
				while (!done) {
					for (SObject record : result.getRecords()) {
						this.Id = (String) record.getField("Id");
						this.name = (String) record.getField("Name");
					}
					if (result.isDone()) {
						done = true;
					} else {
						result = EstablishConnection.connection.queryMore(result.getQueryLocator());
					}
				}
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
			
		}
	}
	
	
	public User() throws Exception {
		//super("User", "profileName");	
		try{
				
				String query = "SELECT Id,Name,IsActive,profile.name,Pacific_User__c FROM User where IsActive != false and profile.name = 'CBRE Data Admin' limit 1 offset 1";
				
		//	String query = "SELECT Id,name, IsActive,profile.name FROM User where id = '005i0000008XF0c'";
				
			//String query = "SELECT Id,Name,IsActive,profile.name FROM User where IsActive != 'false' limit 1 offset 9";
				
				// SELECT Id,Name,IsActive,profile.name FROM User where IsActive != false limit 1 offset 9
				
				// SELECT Id,Name,IsActive,profile.name FROM User where IsActive != false and profile.name = 'CBRE Data Admin' limit 1 offset 9
				
				// SELECT Id,Name,IsActive,profile.name,Pacific_User__c FROM User where IsActive != false and profile.name = 'CBRE Data Admin' limit 1 offset 10
				
				QueryResult result = EstablishConnection.connection.query(query);
				//ArrayList<HashMap<String, Object>> records = ProjectBase.getSfConnector().getApi().query(query);
				if (result.getSize() > 0) {
					boolean done = false;
					while (!done) {
						for (SObject record : result.getRecords()) {
							this.Id = (String) record.getField("Id");
							this.name = (String) record.getField("Name");
						}
						if (result.isDone()) {
							done = true;
						} else {
							result = EstablishConnection.connection.queryMore(result.getQueryLocator());
						}
					}
				}
			}catch(Exception e){
				e.printStackTrace();
				throw e;
			}
		
	}
	
	 public void setId(String Id) {
		  this.Id = Id;
	  }

	public String getId() {
		return Id;
	}
	
	
	
	public String getName() {
		return name;
	}
	
	public String getUserName() {
		return userName;
	}
	
	

}
