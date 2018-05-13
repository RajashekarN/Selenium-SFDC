package pagesAPI;

import java.util.ArrayList;
import java.util.List;
import org.testng.Assert;
import com.cognizant.Craft.ReusableLibrary;
import com.cognizant.Craft.ScriptHelper;
import com.cognizant.framework.Status;
import com.sforce.soap.partner.QueryResult;
import com.sforce.soap.partner.sobject.SObject;
import com.sforce.ws.ConnectionException;

import pageObjects.LoginPage;

import com.sforce.soap.partner.SaveResult;

/**
 * API Class for searching the text using SOQL calls
 * 
 * @author Vishnuvardhan
 *
 */
public class PermissionSetsUsers extends ReusableLibrary {
	/*
	 * Constructor to initialize the business component library
	 * 
	 * @param scriptHelper The {@link ScriptHelper} object passed from the
	 * {@link DriverScript}
	 */

	public PermissionSetsUsers(ScriptHelper scriptHelper) {
		super(scriptHelper);
	}

	static SaveResult[] results;
	static String environment;
	static String roleProfileTimeZoneResult;

	EstablishConnection establishConnection = new EstablishConnection(scriptHelper);
	CreateUsers createUsers = new CreateUsers(scriptHelper);
	LoginPage loginPage = new LoginPage(scriptHelper);
	SearchTextSOQL searchTextSOQL = new SearchTextSOQL(scriptHelper);

	/**
	 * Validating the Permission Sets for different Roles and Profiles
	 * 
	 * @author Vishnuvardhan
	 *
	 */
	public void validatePermissionSets() {
		establishConnection.establishConnection();
		loginPage.userNames();
		try {
			setPermissionSets(LoginPage.userNamesList, permissionSetsLabels);
		} catch (Exception e) {
			System.out.println("Unable to validate the permission sets for the users::" + e.getMessage());
		}
	}

	/**
	 * Function for creation of users 
	 * 
	 * @author Vishnuvardhan
	 *
	 */
	static List<String> userNameCreatedList = new ArrayList<String>();

	public void fectchOrCreateUser() {
		try {
			environment = loginPage.initializeEnvironment();
			loginPage.userNames();
			String userName, userResultId;
			for (int i = 0; i < LoginPage.userNamesList.size(); i++) {
				userName = LoginPage.userNamesList.get(i);
				roleProfileTimeZoneResult = setRoleProfileTimeZone(userName);
				String query = "Select Id from User where username ='" + userName + "'";
				userResultId = searchTextSOQL.fetchRecordFieldValue("Id", query);
				if (userResultId == null) {
					String role = roleProfileTimeZoneResult.split("-")[0];
					String profile = roleProfileTimeZoneResult.split("-")[1];
					String geographicalRole = roleProfileTimeZoneResult.split("-")[2];
					String timeZone = roleProfileTimeZoneResult.split("-")[3];
					userResultId = createUsers.createUser(dataTable.getData("General_Data", "FirstName"),
							dataTable.getData("General_Data", "LastName"), dataTable.getData("General_Data", "Alias"),
							"swapna.bitra" + "@cbre.com", userName, role, profile, geographicalRole, timeZone);
					if(userResultId!=null) {
						System.out.println("User has been created");
						report.updateTestLog("User Creation", "User has been created successfully the system::" + userResultId + ":::" + userName, Status.PASS);	
					} else {
						report.updateTestLog("User Creation", "User creation failed::" + userResultId + ":::" + userName, Status.FAIL);
					}					
				} else {
					System.out.println("User already exists");
					report.updateTestLog("User Creation",
							"User already exists in the system::" + userResultId + ":::" + userName, Status.PASS);
				}
				userNameCreatedList.add(userName);
				setPermissionSets(userNameCreatedList, permissionSetsLabels);
				userNameCreatedList.clear();
				//createUsers.setPassword(userResultId, properties.getProperty(environment + "AdminPassword"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	/**
	 * Function for updating Role Profile for the users
	 * 
	 * @author Vishnuvardhan
	 *
	 */
	public void updateRoleProfile() {
		environment = loginPage.initializeEnvironment();
		loginPage.userNames();
		String userName, userResultId;
		try {
			for (int i = 0; i < LoginPage.userNamesList.size(); i++) {
				userName = LoginPage.userNamesList.get(i);
				roleProfileTimeZoneResult = setRoleProfileTimeZone(userName);				
				String query = "Select Id from User where username ='" + userName + "'";
				userResultId = searchTextSOQL.fetchRecordFieldValue("Id", query);
				String role = roleProfileTimeZoneResult.split("-")[0];
				String profile = roleProfileTimeZoneResult.split("-")[1];
				System.out.println("User ID is :::"+ userResultId);
				System.out.println("Role and Profile ID's are:::"+ role + "::::" + profile);
				setRole(userResultId, role);
				setProfile(userResultId, profile);				
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Function to set up the permission sets
	 * 
	 * @author Vishnuvardhan
	 *
	 */

	public static List<String> roleIDLabels = new ArrayList<String>();
	public static List<String> profileIDLabels = new ArrayList<String>();
	public static List<String> timeZone = new ArrayList<String>();
	public static List<String> geographicalRole = new ArrayList<String>();
	public static List<String> permissionSetsLabels = new ArrayList<String>();

	public void setPermissionSets(List<String> userNameList, List<String> permissionSetsLabels) throws Exception {
		for (int i = 0; i < userNameList.size(); i++) {
			String userName;
			LoginPage loginPage = new LoginPage(scriptHelper);
			String environment = loginPage.initializeEnvironment();
			if ((environment.equalsIgnoreCase("FTE2")) || (environment.equalsIgnoreCase("UAT2"))) {
				userName = userNameList.get(i).substring(0, userNameList.get(i).length() - 4);
			} else {
				userName = userNameList.get(i).substring(0, userNameList.get(i).length() - 3);
			}
			switch (userName) {
			case "testuser1@cbre.com.crm.":
				System.out.println("System Administrator User - :::" + userNameList.get(i)
				+ ":::is having the permission set::: Lightning Experience");
				permissionSetsLabels.add("Lightning Experience");
				break;

			case "testuser2@cbre.com.crm.":
				System.out.println("AB AMER Broker User - :::" + userNameList.get(i)
				+ ":::is having the permission set::: Lightning Experience");
				permissionSetsLabels.add("Lightning Experience");
				break;

			case "testuser3@cbre.com.crm.":
				System.out.println("AB AMER Manager User - :::" + userNameList.get(i)
				+ ":::is having the permission set::: Lightning Experience");
				permissionSetsLabels.add("Lightning Experience");
				break;

			case "testuser4@cbre.com.crm.":
				System.out.println("AB AMER CSS User - :::" + userNameList.get(i)
				+ ":::is having the permission set::: Lightning Experience");
				permissionSetsLabels.add("Lightning Experience");
				break;

			case "testuser5@cbre.com.crm.":
				System.out.println("AS AMER Broker User" + userNameList.get(i)
				+ ":::is having the permission sets::: Lightning Experience" + "and Asset Services LOB");
				permissionSetsLabels.add("Lightning Experience");
				permissionSetsLabels.add("Asset Services LOB");
				break;

			case "testuser6@cbre.com.crm.":
				System.out.println("AS AMER Manager User" + userNameList.get(i)
				+ ":::is having the permission sets::: Lightning Experience" + "and Asset Services LOB");
				permissionSetsLabels.add("Lightning Experience");
				permissionSetsLabels.add("Asset Services LOB");
				break;

			case "testuser7@cbre.com.crm.":
				System.out.println("CM AMER Broker User - :::" + userNameList.get(i)
				+ ":::is having the permission set::: Lightning Experience");
				permissionSetsLabels.add("Lightning Experience");
				break;

			case "testuser8@cbre.com.crm.":
				System.out.println("CM AMER Manager User - :::" + userNameList.get(i)
				+ ":::is having the permission set::: Lightning Experience");
				permissionSetsLabels.add("Lightning Experience");
				break;

			case "testuser9@cbre.com.crm.":
				System.out.println("CM AMER CSS User - :::" + userNameList.get(i)
				+ ":::is having the permission set::: Lightning Experience");
				permissionSetsLabels.add("Lightning Experience");
				break;

			case "testuser10@cbre.com.crm.":
				System.out.println("GWS AMER Broker User - :::" + userNameList.get(i)
				+ ":::is having the permission set::: Lightning Experience");
				permissionSetsLabels.add("Lightning Experience");
				break;

			case "testuser11@cbre.com.crm.":
				System.out.println("OB AMER Broker User - :::" + userNameList.get(i)
				+ ":::is having the permission set::: Lightning Experience");
				permissionSetsLabels.add("Lightning Experience");
				break;

			case "testuser12@cbre.com.crm.":
				System.out.println("OB AMER Manager User - :::" + userNameList.get(i)
				+ ":::is having the permission set::: Lightning Experience");
				permissionSetsLabels.add("Lightning Experience");
				break;

			case "testuser13@cbre.com.crm.":
				System.out.println("OB AMER CSS User - :::" + userNameList.get(i)
				+ ":::is having the permission set::: Lightning Experience");
				permissionSetsLabels.add("Lightning Experience");
				break;

			case "testuser15@cbre.com.crm.":
				System.out.println("AB APAC Broker User - :::" + userNameList.get(i)
				+ ":::is having the permission set::: Lightning Experience");
				permissionSetsLabels.add("Lightning Experience");
				break;

			case "testuser16@cbre.com.crm.":
				System.out.println("AB APAC Manager User - :::" + userNameList.get(i)
				+ ":::is having the permission set::: Lightning Experience");
				permissionSetsLabels.add("Lightning Experience");
				break;

			case "testuser17@cbre.com.crm.":
				System.out.println("AB APAC CSS User - :::" + userNameList.get(i)
				+ ":::is having the permission set::: Lightning Experience");
				permissionSetsLabels.add("Lightning Experience");
				break;

			case "testuser18@cbre.com.crm.":
				System.out.println("AS APAC Broker User" + userNameList.get(i)
				+ ":::is having the permission sets::: Lightning Experience" + "and Asset Services LOB");
				permissionSetsLabels.add("Lightning Experience");
				permissionSetsLabels.add("Asset Services LOB");
				break;

			case "testuser19@cbre.com.crm.":
				System.out.println("AS APAC Manager User" + userNameList.get(i)
				+ ":::is having the permission sets::: Lightning Experience" + "and Asset Services LOB");
				permissionSetsLabels.add("Lightning Experience");
				permissionSetsLabels.add("Asset Services LOB");
				break;

			case "testuser20@cbre.com.crm.":
				System.out.println("CM APAC Broker User - :::" + userNameList.get(i)
				+ ":::is having the permission set::: Lightning Experience");
				permissionSetsLabels.add("Lightning Experience");
				permissionSetsLabels.add("Campaigns and CampaignLogic Create/Edit Permissions");
				break;

			case "testuser21@cbre.com.crm.":
				System.out.println("CM APAC Manager User - :::" + userNameList.get(i)
				+ ":::is having the permission set::: Lightning Experience");
				permissionSetsLabels.add("Lightning Experience");
				permissionSetsLabels.add("Campaigns and CampaignLogic Create/Edit Permissions");
				break;

			case "testuser22@cbre.com.crm.":
				System.out.println("CM APAC CSS User - :::" + userNameList.get(i)
				+ ":::is having the permission set::: Lightning Experience");
				permissionSetsLabels.add("Lightning Experience");
				break;

			case "testuser23@cbre.com.crm.":
				System.out.println("GWS EMEA Broker User - :::" + userNameList.get(i)
				+ ":::is having the permission set::: Lightning Experience");
				permissionSetsLabels.add("Lightning Experience");
				break;

			case "testuser24@cbre.com.crm.":
				System.out.println("OB APAC Broker User - :::" + userNameList.get(i)
				+ ":::is having the permission set::: Lightning Experience");
				permissionSetsLabels.add("Lightning Experience");
				permissionSetsLabels.add("Campaigns and CampaignLogic Create/Edit Permissions");
				break;

			case "testuser25@cbre.com.crm.":
				System.out.println("OB APAC Manager User - :::" + userNameList.get(i)
				+ ":::is having the permission set::: Lightning Experience");
				permissionSetsLabels.add("Lightning Experience");
				break;

			case "testuser26@cbre.com.crm.":
				System.out.println("OB APAC CSS User - :::" + userNameList.get(i)
				+ ":::is having the permission set::: Lightning Experience");
				permissionSetsLabels.add("Lightning Experience");
				break;

			case "testuser27@cbre.com.crm.":
				System.out.println("VAS APAC Broker User - :::" + userNameList.get(i)
				+ ":::is having the permission set::: Lightning Experience");
				permissionSetsLabels.add("Lightning Experience");
				break;

			case "testuser28@cbre.com.crm.":
				System.out.println("AB EMEA Broker User - :::" + userNameList.get(i)
				+ ":::is having the permission sets::: Lightning Experience"
				+ ", EMEA A&T Occupier, EMEA A&T Investor, EMEA BC&P, EMEA Capital Markets Capital Advisors, EMEA Property Permissions"
				+ " and EMEA Valuations");
				permissionSetsLabels.add("Lightning Experience");
				permissionSetsLabels.add("EMEA A&T Occupier");
				permissionSetsLabels.add("EMEA A&T Investor");
				permissionSetsLabels.add("EMEA BC&P");
				permissionSetsLabels.add("EMEA Capital Markets Capital Advisors");
				permissionSetsLabels.add("EMEA Property Permissions");
				permissionSetsLabels.add("EMEA Valuations");
				break;

			case "testuser29@cbre.com.crm.":
				System.out.println("AB EMEA Manager User - :::" + userNameList.get(i)
				+ ":::is having the permission sets::: Lightning Experience" + "and EMEA A&T Investor");
				permissionSetsLabels.add("EMEA A&T Investor");
				permissionSetsLabels.add("Lightning Experience");
				break;

			case "testuser31@cbre.com.crm.":
				System.out.println("AS EMEA Broker User - :::" + userNameList.get(i)
				+ ":::is having the permission sets::: Lightning Experience and EMEA Asset Services");
				permissionSetsLabels.add("Lightning Experience");
				permissionSetsLabels.add("EMEA Asset Services");
				break;

			case "testuser32@cbre.com.crm.":
				System.out.println("AS EMEA Manager User - :::" + userNameList.get(i)
				+ ":::is having the permission sets::: Lightning Experience and EMEA Asset Services");
				permissionSetsLabels.add("Lightning Experience");
				permissionSetsLabels.add("EMEA Asset Services");
				break;

			case "testuser36@cbre.com.crm.":
				System.out.println("CM EMEA Broker User - :::" + userNameList.get(i)
				+ ":::is having the permission sets::: Lightning Experience and EMEA Capital Markets Capital Advisors");
				permissionSetsLabels.add("Lightning Experience");
				permissionSetsLabels.add("EMEA Capital Markets Capital Advisors");
				break;

			case "testuser37@cbre.com.crm.":
				System.out.println("CM EMEA Manager User - :::" + userNameList.get(i)
				+ ":::is having the permission sets::: Lightning Experience and EMEA Capital Markets Capital Advisors");
				permissionSetsLabels.add("Lightning Experience");
				permissionSetsLabels.add("EMEA Capital Markets Capital Advisors");
				break;

			case "testuser38@cbre.com.crm.":
				System.out.println("CM EMEA CSS User - :::" + userNameList.get(i)
				+ ":::is having the permission sets::: Lightning Experience and EMEA Capital Markets Capital Advisors");
				permissionSetsLabels.add("Lightning Experience");
				permissionSetsLabels.add("EMEA Capital Markets Capital Advisors");
				break;

			case "testuser39@cbre.com.crm.":
				System.out.println("CM EMEA Broker IP User - :::" + userNameList.get(i)
				+ ":::is having the permission sets::: Lightning Experience and EMEA Capital Markets Investment Properties");
				permissionSetsLabels.add("Lightning Experience");
				permissionSetsLabels.add("EMEA Capital Markets Investment Properties");
				break;

			case "testuser40@cbre.com.crm.":
				System.out.println("CM EMEA Manager IP User - :::" + userNameList.get(i)
				+ ":::is having the permission sets::: Lightning Experience and EMEA Capital Markets Investment Properties");
				permissionSetsLabels.add("Lightning Experience");
				permissionSetsLabels.add("EMEA Capital Markets Investment Properties");
				break;

			case "testuser41@cbre.com.crm.":
				System.out.println("CM EMEA CSS IP User - :::" + userNameList.get(i)
				+ ":::is having the permission sets::: Lightning Experience and EMEA Capital Markets Investment Properties");
				permissionSetsLabels.add("Lightning Experience");
				permissionSetsLabels.add("EMEA Capital Markets Investment Properties");
				break;

			case "testuser45@cbre.com.crm.":
				System.out.println("OB EMEA Broker User - :::" + userNameList.get(i)
				+ ":::is having the permission sets::: Lightning Experience and EMEA A&T Occupier");
				permissionSetsLabels.add("Lightning Experience");
				permissionSetsLabels.add("EMEA A&T Occupier");
				break;

			case "testuser46@cbre.com.crm.":
				System.out.println("OB EMEA Manager User - :::" + userNameList.get(i)
				+ ":::is having the permission sets::: Lightning Experience and EMEA A&T Occupier");
				permissionSetsLabels.add("Lightning Experience");
				permissionSetsLabels.add("EMEA A&T Occupier");
				break;

			case "testuser47@cbre.com.crm.":
				System.out.println("OB EMEA CSS User - :::" + userNameList.get(i)
				+ ":::is having the permission sets::: Lightning Experience and EMEA A&T Occupier");
				permissionSetsLabels.add("Lightning Experience");
				permissionSetsLabels.add("EMEA A&T Occupier");
				break;

			case "testuser48@cbre.com.crm.":
				System.out.println("VAS EMEA Broker User - :::" + userNameList.get(i)
				+ ":::is having the permission sets::: Lightning Experience and EMEA Valuations");
				permissionSetsLabels.add("Lightning Experience");
				permissionSetsLabels.add("EMEA Valuations");
				break;

			case "testuser49@cbre.com.crm.":
				System.out.println("VAS EMEA Manager User - :::" + userNameList.get(i)
				+ ":::is having the permission sets::: Lightning Experience and EMEA Valuations");
				permissionSetsLabels.add("Lightning Experience");
				permissionSetsLabels.add("EMEA Valuations");
				break;
			case "testuser50@cbre.com.crm.":
				System.out.println("VAS EMEA CSS User - :::" + userNameList.get(i)
				+ ":::is having the permission sets::: Lightning Experience and EMEA Valuations");
				permissionSetsLabels.add("Lightning Experience");
				permissionSetsLabels.add("EMEA Valuations");
				break;

			case "testuser51@cbre.com.crm.":
				System.out.println("DataAdmin EMEA Data User - :::" + userNameList.get(i)
				+ ":::is having the permission set::: Lightning Experience");
				permissionSetsLabels.add("Lightning Experience");
				break;
			case "testuser62@cbre.com.crm.":
				System.out.println("GWS APAC Manager User - :::" + userNameList.get(i)
				+ ":::is having the permission set::: Lightning Experience");
				permissionSetsLabels.add("Lightning Experience");
				break;

			case "testuser65@cbre.com.crm.":
				System.out.println("VAS AMER Manager User - :::" + userNameList.get(i)
				+ ":::is having the permission set::: Lightning Experience");
				permissionSetsLabels.add("Lightning Experience");
				break;

			case "testuser66@cbre.com.crm.":
				System.out.println("GWS AMER Manager User - :::" + userNameList.get(i)
				+ ":::is having the permission set::: Lightning Experience");
				permissionSetsLabels.add("Lightning Experience");
				break;

			case "testuser67@cbre.com.crm.":
				System.out.println("GWS APAC Broker User - :::" + userNameList.get(i)
				+ ":::is having the permission set::: Lightning Experience");
				permissionSetsLabels.add("Lightning Experience");
				break;

			case "testuser68@cbre.com.crm.":
				System.out.println("CM EMEA Manager BCP User - :::" + userNameList.get(i)
				+ ":::is having the permission sets::: Lightning Experience and EMEA BC&P");
				permissionSetsLabels.add("Lightning Experience");
				permissionSetsLabels.add("EMEA BC&P");
				break;

			case "testuser69@cbre.com.crm.":
				System.out.println("CM EMEA Manager Dev User - :::" + userNameList.get(i)
				+ ":::is having the permission sets::: Lightning Experience and EMEA Development");
				permissionSetsLabels.add("Lightning Experience");
				permissionSetsLabels.add("EMEA Development");
				break;

			case "testuser70@cbre.com.crm.":
				System.out.println("CM EMEA Broker CA User - :::" + userNameList.get(i)
				+ ":::is having the permission sets::: Lightning Experience and EMEA Capital Markets Capital Advisors");
				permissionSetsLabels.add("Lightning Experience");
				permissionSetsLabels.add("EMEA Capital Markets Capital Advisors");
				break;

			case "testuser71@cbre.com.crm.":
				System.out.println("CM EMEA Broker BCP User - :::" + userNameList.get(i)
				+ ":::is having the permission sets::: Lightning Experience and EMEA BC&P");
				permissionSetsLabels.add("Lightning Experience");
				permissionSetsLabels.add("EMEA BC&P");
				break;

			case "testuser72@cbre.com.crm.":
				System.out.println("CM EMEA Broker Dev User - :::" + userNameList.get(i)
				+ ":::is having the permission sets::: Lightning Experience and EMEA Development");
				permissionSetsLabels.add("Lightning Experience");
				permissionSetsLabels.add("EMEA Development");
				break;

			case "testuser73@cbre.com.crm.":
				System.out.println("CM EMEA CSS Dev User - :::" + userNameList.get(i)
				+ ":::is having the permission sets::: Lightning Experience and EMEA Development");
				permissionSetsLabels.add("Lightning Experience");
				permissionSetsLabels.add("EMEA Development");
				break;

			case "testuser74@cbre.com.crm.":
				System.out.println("CM EMEA CSS Super User - :::" + userNameList.get(i)
				+ ":::is having the permission sets::: Lightning Experience and EMEA Super User");
				permissionSetsLabels.add("Lightning Experience");
				permissionSetsLabels.add("EMEA Super User");
				break;

			case "testuser75@cbre.com.crm.":
				System.out.println("AS EMEA Broker Super User - :::" + userNameList.get(i)
				+ ":::is having the permission sets::: Lightning Experience and EMEA Super User");
				permissionSetsLabels.add("Lightning Experience");
				permissionSetsLabels.add("EMEA Super User");
				break;

			case "testuser76@cbre.com.crm.":
				System.out.println("GWS EMEA Broker Super User - :::" + userNameList.get(i)
				+ ":::is having the permission sets::: Lightning Experience and EMEA Super User");
				permissionSetsLabels.add("Lightning Experience");
				permissionSetsLabels.add("EMEA Super User");
				break;

			case "testuser78@cbre.com.crm.":
				System.out.println("VAS EMEA Broker Super User - :::" + userNameList.get(i)
				+ ":::is having the permission sets::: Lightning Experience, EMEA Super User and "
				+ "EMEA Valuations");
				permissionSetsLabels.add("Lightning Experience");
				permissionSetsLabels.add("EMEA Super User");
				permissionSetsLabels.add("EMEA Valuations");
				break;

			case "testuser79@cbre.com.crm.":
				System.out.println("CM APAC Broker AUC User - :::" + userNameList.get(i)
				+ ":::is having the permission set::: Lightning Experience");
				permissionSetsLabels.add("Lightning Experience");
				break;

			case "testuser80@cbre.com.crm.":
				System.out.println("CM APAC Broker NZL User - :::" + userNameList.get(i)
				+ ":::is having the permission set::: Lightning Experience");
				permissionSetsLabels.add("Lightning Experience");
				break;

			case "testuser81@cbre.com.crm.":
				System.out.println("CM APAC Broker Metro NZL User - :::" + userNameList.get(i)
				+ ":::is having the permission sets::: Lightning Experience,"
				+ "Campaigns and CampaignLogic Create/Edit Permissions, Enquiries & Space Assessment Create/Edit Permissions,"
				+ "Preference & Publication Edit Permissions and Preference Edit & Marketing Lists Read Permissions");
				permissionSetsLabels.add("Campaigns and CampaignLogic Create/Edit Permissions");
				permissionSetsLabels.add("Enquiries & Space Assessment Create/Edit Permissions");
				permissionSetsLabels.add("Preference & Publication Edit Permissions");
				permissionSetsLabels.add("Preference Edit & Marketing Lists Read Permissions");
				permissionSetsLabels.add("Lightning Experience");
				break;

			case "testuser82@cbre.com.crm.":
				System.out.println("CM APAC Brokder Metro User - :::" + userNameList.get(i)
				+ ":::is having the permission set::: Lightning Experience");
				permissionSetsLabels.add("Lightning Experience");
				break;

			case "testuser83@cbre.com.crm.":
				System.out.println("CM APAC Broker AUS User - :::" + userNameList.get(i)
				+ ":::is having the permission set::: Lightning Experience");
				permissionSetsLabels.add("Lightning Experience");
				break;

			case "testuser84@cbre.com.crm.":
				System.out.println("CM APAC Broker NSW User - :::" + userNameList.get(i)
				+ ":::is having the permission set::: Lightning Experience");
				permissionSetsLabels.add("Lightning Experience");
				break;

			case "testuser85@cbre.com.crm.":
				System.out.println("CM APAC Broker Christ Church User - :::" + userNameList.get(i)
				+ ":::is having the permission set::: Lightning Experience");
				permissionSetsLabels.add("Lightning Experience");
				break;

			case "testuser86@cbre.com.crm.":
				System.out.println("OB EMEA Occupier Client Care User - :::" + userNameList.get(i)
				+ ":::is having the permission sets::: Lightning Experience,"
				+ "EMEA A&T Occupier, EMEA Occupier Client Care, EMEA Super User and Tableau Dashboard Permission");
				permissionSetsLabels.add("EMEA A&T Occupier");
				permissionSetsLabels.add("EMEA Occupier Client Care");
				permissionSetsLabels.add("EMEA Super User");
				permissionSetsLabels.add("Tableau Dashboard Permission");
				permissionSetsLabels.add("Lightning Experience");
				break;

			case "testuser87@cbre.com.crm.":
				System.out.println("CM APAC Broker Campaign User - :::" + userNameList.get(i)
				+ ":::is having the permission sets::: Lightning Experience,"
				+ "Campaigns and CampaignLogic Create/Edit Permissions and Enquiries & Space Assessment Create/Edit Permissions");
				permissionSetsLabels.add("Campaigns and CampaignLogic Create/Edit Permissions");
				permissionSetsLabels.add("Enquiries & Space Assessment Create/Edit Permissions");
				permissionSetsLabels.add("Lightning Experience");
				break;

			case "testuser88@cbre.com.crm.":
				System.out.println("CM APAC Broker MVP User - :::" + userNameList.get(i)
				+ ":::is having the permission sets::: Lightning Experience," + "CM - Asia and CM - India");
				permissionSetsLabels.add("Lightning Experience");
				permissionSetsLabels.add("CM - Asia");
				permissionSetsLabels.add("CM - India");
				break;

			case "testuser90@cbre.com.crm.":
				System.out.println("CM EMEA Manager CA User - :::" + userNameList.get(i)
				+ ":::is having the permission sets::: Lightning Experience"
				+ "and EMEA Capital Markets Capital Advisors");
				permissionSetsLabels.add("Lightning Experience");
				permissionSetsLabels.add("EMEA Capital Markets Capital Advisors");
				break;

			case "testuser91@cbre.com.crm.":
				System.out.println("DataAdmin EMEA Data User - :::" + userNameList.get(i)
				+ ":::is having the permission set::: Lightning Experience,"
				+ "APAC Communication Preferences Create/Edit Permissions, Enquiries & Space Assessment Create/Edit Permissions,"
				+ "Preference & Publication Edit Permissions and Preference Edit & Marketing Lists Read Permissions");
				permissionSetsLabels.add("Lightning Experience");
				permissionSetsLabels.add("APAC Communication Preferences Create/Edit Permissions");
				permissionSetsLabels.add("Enquiries & Space Assessment Create/Edit Permissions");
				permissionSetsLabels.add("Preference & Publication Edit Permissions");
				permissionSetsLabels.add("Preference Edit & Marketing Lists Read Permissions");
				break;

			case "testuser92@cbre.com.crm.":
				System.out.println("CM EMEA Manager CA User - :::" + userNameList.get(i)
				+ ":::is having the permission sets::: Lightning Experience" + "and CM - Asia and CM - India");
				permissionSetsLabels.add("Lightning Experience");
				permissionSetsLabels.add("CM - Asia");
				permissionSetsLabels.add("CM - India");
				break;

			case "testuser93@cbre.com.crm.":
				System.out.println("CM EMEA Manager CA User - :::" + userNameList.get(i)
				+ ":::is having the permission sets::: Lightning Experience");
				permissionSetsLabels.add("Lightning Experience");
				break;

			case "testuser94@cbre.com.crm.":
				System.out.println("CM EMEA Manager CA User - :::" + userNameList.get(i)
				+ ":::is having the permission sets::: Lightning Experience");
				permissionSetsLabels.add("Lightning Experience");
				break;

			case "testuser95@cbre.com.crm.":
				System.out.println("France Data User - :::" + userName + environment
						+ ":::is having the Role and Profle as::: FR DIG and CBRE - France - Data Admin");
				permissionSetsLabels.add("Lightning Experience");
				permissionSetsLabels.add("Country Permissions - France");
				permissionSetsLabels.add("France - Consulting & Service");
				permissionSetsLabels.add("France - Investor Relations");
				permissionSetsLabels.add("France - Transaction Demand Agency");
				permissionSetsLabels.add("France - Transaction Offer Agency");
				permissionSetsLabels.add("France Leads");

				break;

			case "testuser96@cbre.com.crm.":

				System.out.println("France Manager - :::" + userName + environment
						+ ":::is having the Role and Profle as::: FR - CODIR+ and CBRE Manager - France - Multi Business Line");
				permissionSetsLabels.add("Country Permissions - France");
				permissionSetsLabels.add("France - Consulting & Service");
				permissionSetsLabels.add("France - Investor Relations");
				permissionSetsLabels.add("France - Transaction Demand Agency");
				permissionSetsLabels.add("France - Transaction Offer Agency");
				permissionSetsLabels.add("France Leads");
				permissionSetsLabels.add("Lightning Experience");
				break;

			case "testuser97@cbre.com.crm.":

				System.out.println("France Manager - :::" + userName + environment
						+ ":::is having the Role and Profle as::: FR DIG and CBRE Manager - France - Multi Business Line");

				permissionSetsLabels.add("Country Permissions - France");
				permissionSetsLabels.add("France - Consulting & Service");
				permissionSetsLabels.add("France - Investor Relations");
				permissionSetsLabels.add("France - Transaction Demand Agency");
				permissionSetsLabels.add("France - Transaction Offer Agency");
				permissionSetsLabels.add("France Leads");
				permissionSetsLabels.add("Reports, Dashboards, & Data Export for Super Users");
				permissionSetsLabels.add("Lightning Experience");
				break;

			case "testuser98@cbre.com.crm.":

				System.out.println("France Manager - :::" + userName + environment
						+ ":::is having the Role and Profle as::: France and CBRE Manager - France - Multi Business Line");
				permissionSetsLabels.add("Cases Permission - Functional Analysts");
				permissionSetsLabels.add("Cases Permission - Regional Support Specialists");
				permissionSetsLabels.add("Cases Permission - Support Specialists");
				permissionSetsLabels.add("Chatter Group Create Permission");
				permissionSetsLabels.add("Composer Administrator");
				permissionSetsLabels.add("Composer User");
				permissionSetsLabels.add("Country Permissions - France");
				permissionSetsLabels.add("France - Consulting & Service");
				permissionSetsLabels.add("France - Investor Relations");
				permissionSetsLabels.add("France - Transaction Demand Agency");
				permissionSetsLabels.add("France - Transaction Offer Agency");
				permissionSetsLabels.add("France Leads");
				permissionSetsLabels.add("Language Entry Translation Permissions");
				permissionSetsLabels.add("Lightning Experience");
				break;

			case "testuser99@cbre.com.crm.":

				System.out.println("SouthEast Asia Data Admin- :::" + userName + environment
						+ ":::is having the Role and Profle as::: SouthEast Asia - CBRE Data Admin");

				permissionSetsLabels.add("APAC Capital Markets – Asia");
				permissionSetsLabels.add("APAC Communication Preferences Create/Edit Permissions");
				permissionSetsLabels.add("Asset Services Investor Services Account Field Rights");
				permissionSetsLabels.add("Asset Services LOB");
				permissionSetsLabels.add("Campaigns and CampaignLogic Create/Edit Permissions");
				permissionSetsLabels.add("Dashboards Create/Edit Permission");
				permissionSetsLabels.add("Enquiries & Space Assessment Create/Edit Permissions");
				permissionSetsLabels.add("Lightning Experience");
				permissionSetsLabels.add("Preference & Publication Edit Permissions");
				permissionSetsLabels.add("Preference Edit & Marketing Lists Read Permissions");

				break;

			case "testuser100@cbre.com.crm.":	
				System.out.println("Pacific Data Admin- :::" + userName + environment
						+ ":::is having the Role and Profle as::: Pacific - CBRE Data Admin");
				permissionSetsLabels.add("Allow updates to Key Client and Pursuit Account LOB fields on Account");
				permissionSetsLabels.add("APAC Communication Preferences Create/Edit Permissions");
				permissionSetsLabels.add("Asset Services LOB");
				permissionSetsLabels.add("Campaigns and CampaignLogic Create/Edit Permissions");
				permissionSetsLabels.add("Country Permissions - Australia");
				permissionSetsLabels.add("Dashboards Create/Edit Permission");
				permissionSetsLabels.add("Enquiries & Space Assessment Create/Edit Permissions");
				permissionSetsLabels.add("Lightning Experience");
				permissionSetsLabels.add("Modify All Data Permission");
				permissionSetsLabels.add("Preference & Publication Edit Permissions");
				permissionSetsLabels.add("Regional Business Support");

				break;
			default:
				break;
			}
			String userId = getUserId(userNameList.get(i));
			for (String permSet : permissionSetsLabels) {
				setPermSetAssigned(userId, getPermSetId(permSet));
				System.out
				.println("Permission Set for the user:::" + userNameList.get(i) + "::::is having:::" + permSet);
				report.updateTestLog("Permission Sets",
						userNameList.get(i) + "::::is having the permission sets:::" + permSet, Status.PASS);
			}
			permissionSetsLabels.clear();
		}
	}

	/**
	 * Function to set up the role, profile, time zone and geographical role
	 * 
	 * @author Vishnuvardhan
	 *
	 */
	public String setRoleProfileTimeZone(String userName) throws Exception {
		String roleProfileTimeZone = null;				
		if ((environment.equalsIgnoreCase("FTE2")) || (environment.equalsIgnoreCase("UAT2"))) {
			userName = userName.substring(0, userName.length() - 4);
		} else {
			userName = userName.substring(0, userName.length() - 3);
		}		
		for (int i = 0; i < 1; i++) {
			switch (userName) {
			case "testuser1@cbre.com.crm.":

				roleIDLabels.add("EXECUTIVE");
				profileIDLabels.add("System Administrator");
				timeZone.add("America/Los_Angeles");
				geographicalRole.add("AMER");
				System.out.println("System Administrator User - :::" + userName + environment
						+ ":::is having the Role and Profle as:::EXECUTIVE and System Administrator");
				break;

			case "testuser2@cbre.com.crm.":

				roleIDLabels.add("AMER");
				profileIDLabels.add("CBRE Broker - AMER - Agency Brokerage");
				timeZone.add("America/Los_Angeles");
				geographicalRole.add("AMER");
				System.out.println("AB AMER Broker User - :::" + userName + environment
						+ ":::is having the Role and Profle as::: AMER and CBRE Broker - AMER - Agency Brokerage");
				break;

			case "testuser3@cbre.com.crm.":

				roleIDLabels.add("AMER");
				profileIDLabels.add("CBRE Manager - AMER - Agency Brokerage");
				timeZone.add("America/Los_Angeles");
				geographicalRole.add("AMER");
				System.out.println("AB AMER Manager User - :::" + userName + environment
						+ ":::is having the Role and Profle as::: AMER and CBRE Manager - AMER - Agency Brokerage");
				break;

			case "testuser4@cbre.com.crm.":

				roleIDLabels.add("AMER");
				profileIDLabels.add("CBRE Support Staff - AMER - Agency Brokerage");
				timeZone.add("America/Los_Angeles");
				geographicalRole.add("AMER");
				System.out.println("AB AMER CSS User - :::" + userName + environment
						+ ":::is having the Role and Profle as::: AMER and CBRE Support Staff - AMER - Agency Brokerage");
				break;

			case "testuser5@cbre.com.crm.":

				roleIDLabels.add("AMER");
				profileIDLabels.add("CBRE Broker - AMER - Asset Services");
				timeZone.add("America/Los_Angeles");
				geographicalRole.add("AMER");
				System.out.println("AS AMER Broker User" + userName + environment
						+ ":::is having the Role and Profle as::: AMER and CBRE Broker - AMER - Asset Services");
				break;

			case "testuser6@cbre.com.crm.":

				roleIDLabels.add("AMER");
				profileIDLabels.add("CBRE Manager - AMER - Asset Services");
				timeZone.add("America/Los_Angeles");
				geographicalRole.add("AMER");
				System.out.println("AS AMER Manager User" + userName + environment
						+ ":::is having the Role and Profle as::: AMER and CBRE Manager - AMER - Asset Services");
				break;

			case "testuser7@cbre.com.crm.":

				roleIDLabels.add("AMER");
				profileIDLabels.add("CBRE Broker - AMER - Capital Markets");
				timeZone.add("America/Los_Angeles");
				geographicalRole.add("AMER");
				System.out.println("CM AMER Broker User - :::" + userName + environment
						+ ":::is having the Role and Profle as::: AMER and CBRE Broker - AMER - Capital Markets");
				break;

			case "testuser8@cbre.com.crm.":

				roleIDLabels.add("AMER");
				profileIDLabels.add("CBRE Manager - AMER - Capital Markets");
				geographicalRole.add("AMER");
				System.out.println("CM AMER Manager User - :::" + userName + environment
						+ ":::is having the Role and Profle as::: AMER and CBRE Manager - AMER - Capital Markets");
				timeZone.add("America/Los_Angeles");
				break;

			case "testuser9@cbre.com.crm.":

				roleIDLabels.add("AMER");
				profileIDLabels.add("CBRE Support Staff - AMER - Capital Markets");
				timeZone.add("America/Los_Angeles");
				geographicalRole.add("AMER");
				System.out.println("CM AMER CSS User - :::" + userName + environment
						+ ":::is having the Role and Profle as::: AMER and CBRE Support Staff - AMER - Capital Markets");
				break;

			case "testuser10@cbre.com.crm.":

				roleIDLabels.add("AMER");
				profileIDLabels.add("CBRE Broker - AMER - GWS");
				timeZone.add("America/Los_Angeles");
				geographicalRole.add("AMER");
				System.out.println("GWS AMER Broker User - :::" + userName + environment
						+ ":::is having the Role and Profle as::: AMER and CBRE Broker - AMER - GWS");
				break;

			case "testuser11@cbre.com.crm.":

				roleIDLabels.add("AMER");
				profileIDLabels.add("CBRE Broker - AMER - Occupier Brokerage");
				timeZone.add("America/Los_Angeles");
				geographicalRole.add("AMER");
				System.out.println("OB AMER Broker User - :::" + userName + environment
						+ ":::is having the Role and Profle as::: AMER and CBRE Broker - AMER - Occupier Brokerage");
				break;

			case "testuser12@cbre.com.crm.":

				roleIDLabels.add("AMER");
				profileIDLabels.add("CBRE Manager - AMER - Occupier Brokerage");
				timeZone.add("America/Los_Angeles");
				geographicalRole.add("AMER");
				System.out.println("OB Manager Broker User - :::" + userName + environment
						+ ":::is having the Role and Profle as::: AMER and CBRE Manager - AMER - Occupier Brokerage");
				break;

			case "testuser13@cbre.com.crm.":

				roleIDLabels.add("AMER");
				profileIDLabels.add("CBRE Support Staff - AMER - Occupier Brokerage");
				timeZone.add("America/Los_Angeles");
				geographicalRole.add("AMER");
				System.out.println("OB CSS Broker User - :::" + userName + environment
						+ ":::is having the Role and Profle as::: AMER and CBRE Support Staff - AMER - Occupier Brokerage");
				break;

			case "testuser15@cbre.com.crm.":

				roleIDLabels.add("APAC");
				profileIDLabels.add("CBRE Broker - APAC - Agency Brokerage");
				timeZone.add("America/Los_Angeles");
				geographicalRole.add("APAC");
				System.out.println("AB APAC Broker User - :::" + userName + environment
						+ ":::is having the Role and Profle as::: APAC and CBRE Broker - APAC - Agency Brokerage");
				break;

			case "testuser16@cbre.com.crm.":

				roleIDLabels.add("APAC");
				profileIDLabels.add("CBRE Manager - APAC - Agency Brokerage");
				timeZone.add("America/Los_Angeles");
				geographicalRole.add("APAC");
				System.out.println("AB APAC Manager User - :::" + userName + environment
						+ ":::is having the Role and Profle as::: APAC and CBRE Manager - APAC - Agency Brokerage");
				break;

			case "testuser17@cbre.com.crm.":

				roleIDLabels.add("APAC");
				profileIDLabels.add("CBRE Support Staff - APAC - Agency Brokerage");
				timeZone.add("America/Los_Angeles");
				geographicalRole.add("APAC");
				System.out.println("AB APAC CSS User - :::" + userName + environment
						+ ":::is having the Role and Profle as::: APAC and CBRE Support Staff - APAC - Agency Brokerage");
				break;

			case "testuser18@cbre.com.crm.":

				roleIDLabels.add("APAC");
				profileIDLabels.add("CBRE Broker - APAC - Asset Services");
				timeZone.add("America/Los_Angeles");
				geographicalRole.add("APAC");
				System.out.println("AS APAC Broker User" + userName + environment
						+ ":::is having the Role and Profle as::: APAC and CBRE Broker - APAC - Asset Services");
				break;

			case "testuser19@cbre.com.crm.":

				roleIDLabels.add("APAC");
				profileIDLabels.add("CBRE Manager - APAC - Asset Services");
				timeZone.add("America/Los_Angeles");
				geographicalRole.add("APAC");
				System.out.println("AS APAC Manager User" + userName + environment
						+ ":::is having the Role and Profle as::: APAC and CBRE Manager - APAC - Asset Services");
				break;

			case "testuser20@cbre.com.crm.":

				roleIDLabels.add("APAC");
				profileIDLabels.add("CBRE Broker - APAC - Capital Markets");
				timeZone.add("America/Los_Angeles");
				geographicalRole.add("APAC");
				System.out.println("CM APAC Broker User - :::" + userName + environment
						+ ":::is having the Role and Profle as::: APAC and CBRE Broker - APAC - Capital Markets");
				break;

			case "testuser21@cbre.com.crm.":

				roleIDLabels.add("APAC");
				profileIDLabels.add("CBRE Manager - APAC - Capital Markets");
				timeZone.add("America/Los_Angeles");
				geographicalRole.add("APAC");
				System.out.println("CM APAC Manager User - :::" + userName + environment
						+ ":::is having the Role and Profle as::: APAC and CBRE Manager - APAC - Capital Markets");
				break;

			case "testuser22@cbre.com.crm.":

				roleIDLabels.add("APAC");
				profileIDLabels.add("CBRE Support Staff - APAC - Capital Markets");
				timeZone.add("America/Los_Angeles");
				geographicalRole.add("APAC");
				System.out.println("CM APAC CSS User - :::" + userName + environment
						+ ":::is having the Role and Profle as::: APAC and CBRE Support Staff - APAC - Capital Markets");
				break;

			case "testuser23@cbre.com.crm.":

				roleIDLabels.add("EMEA");
				profileIDLabels.add("CBRE Broker - EMEA - GWS");
				timeZone.add("America/Los_Angeles");
				geographicalRole.add("EMEA");
				System.out.println("GWS EMEA Broker User - :::" + userName + environment
						+ ":::is having the Role and Profle as::: EMEA and CBRE Broker - EMEA - GWS");
				break;

			case "testuser24@cbre.com.crm.":

				roleIDLabels.add("APAC");
				profileIDLabels.add("CBRE Broker - APAC - Occupier Brokerage");
				timeZone.add("America/Los_Angeles");
				geographicalRole.add("APAC");
				System.out.println("OB APAC Broker User - :::" + userName + environment
						+ ":::is having the Role and Profle as::: APAC and CBRE Broker - APAC - Occupier Brokerage");
				break;

			case "testuser25@cbre.com.crm.":

				roleIDLabels.add("APAC");
				profileIDLabels.add("CBRE Broker - APAC - Occupier Brokerage");
				timeZone.add("America/Los_Angeles");
				geographicalRole.add("APAC");
				System.out.println("OB APAC Manager User - :::" + userName + environment
						+ ":::is having the Role and Profle as::: APAC and CBRE Broker - APAC - Occupier Brokerage");
				break;

			case "testuser26@cbre.com.crm.":

				roleIDLabels.add("APAC");
				profileIDLabels.add("CBRE Broker - APAC - Occupier Brokerage");
				timeZone.add("America/Los_Angeles");
				geographicalRole.add("APAC");
				System.out.println("OB APAC CSS User - :::" + userName + environment
						+ ":::is having the Role and Profle as::: APAC and CBRE Broker - APAC - Occupier Brokerage");
				break;

			case "testuser27@cbre.com.crm.":

				roleIDLabels.add("APAC");
				profileIDLabels.add("CBRE Broker - APAC - Valuation & Advisory");
				timeZone.add("America/Los_Angeles");
				geographicalRole.add("APAC");
				System.out.println("VAS APAC Broker User - :::" + userName + environment
						+ ":::is having the Role and Profle as::: APAC and CBRE Broker - APAC - Valuation & Advisory");
				break;

			case "testuser28@cbre.com.crm.":

				roleIDLabels.add("EMEA");
				profileIDLabels.add("CBRE Broker - EMEA - Multi Business Line");
				timeZone.add("America/Los_Angeles");
				geographicalRole.add("EMEA");
				System.out.println("AB EMEA Broker User - :::" + userName + environment
						+ ":::is having the Role and Profle as::: EMEA and CBRE Broker - EMEA - Multi Business Line");
				break;

			case "testuser29@cbre.com.crm.":

				roleIDLabels.add("EMEA");
				profileIDLabels.add("CBRE Broker - EMEA - Multi Business Line");
				timeZone.add("America/Los_Angeles");
				geographicalRole.add("EMEA");
				System.out.println("AB EMEA Manager User - :::" + userName + environment
						+ ":::is having the Role and Profle as::: EMEA and CBRE Broker - EMEA - Multi Business Line");
				break;

			case "testuser30@cbre.com.crm.":

				roleIDLabels.add("EMEA");
				profileIDLabels.add("CBRE Broker - EMEA - Multi Business Line");
				timeZone.add("America/Los_Angeles");
				geographicalRole.add("EMEA");
				System.out.println("AB EMEA CSS User - :::" + userName + environment
						+ ":::is having the Role and Profle as::: EMEA and CBRE Support Staff - EMEA - Multi Business Line");
				break;

			case "testuser31@cbre.com.crm.":

				roleIDLabels.add("EMEA");
				profileIDLabels.add("CBRE Broker - EMEA - Multi Business Line");
				timeZone.add("America/Los_Angeles");
				geographicalRole.add("EMEA");
				System.out.println("AS EMEA Broker User - :::" + userName + environment
						+ ":::is having the Role and Profle as::: EMEA and CBRE Support Staff - EMEA - Multi Business Line");
				break;

			case "testuser32@cbre.com.crm.":

				roleIDLabels.add("EMEA");
				profileIDLabels.add("CBRE Broker - EMEA - Multi Business Line");
				timeZone.add("America/Los_Angeles");
				geographicalRole.add("EMEA");
				System.out.println("AS EMEA Manager User - :::" + userName + environment
						+ ":::is having the Role and Profle as::: EMEA and CBRE Manager - EMEA - Multi Business Line");
				break;

			case "testuser36@cbre.com.crm.":

				roleIDLabels.add("EMEA");
				profileIDLabels.add("CBRE Broker - EMEA - Multi Business Line");
				timeZone.add("America/Los_Angeles");
				geographicalRole.add("EMEA");
				System.out.println("CM EMEA Broker User - :::" + userName + environment
						+ ":::is having the Role and Profle as::: EMEA and CBRE Broker - EMEA - Multi Business Line");
				break;

			case "testuser37@cbre.com.crm.":

				roleIDLabels.add("EMEA");
				profileIDLabels.add("CBRE Manager - EMEA - Multi Business Line");
				timeZone.add("America/Los_Angeles");
				geographicalRole.add("EMEA");
				System.out.println("CM EMEA Manager User - :::" + userName + environment
						+ ":::is having the Role and Profle as::: EMEA and CBRE Manager - EMEA - Multi Business Line");
				break;

			case "testuser38@cbre.com.crm.":

				roleIDLabels.add("EMEA");
				profileIDLabels.add("CBRE Support Staff - EMEA - Multi Business Line");
				timeZone.add("America/Los_Angeles");
				geographicalRole.add("EMEA");
				System.out.println("CM EMEA CSS User - :::" + userName + environment
						+ ":::is having the Role and Profle as::: EMEA and CBRE Support Staff - EMEA - Multi Business Line");
				break;

			case "testuser39@cbre.com.crm.":

				roleIDLabels.add("EMEA");
				profileIDLabels.add("CBRE Broker - EMEA - Multi Business Line");
				timeZone.add("America/Los_Angeles");
				geographicalRole.add("EMEA");
				System.out.println("CM EMEA Broker IP User - :::" + userName + environment
						+ ":::is having the Role and Profle as::: EMEA and CBRE Broker - EMEA - Multi Business Line");
				break;

			case "testuser40@cbre.com.crm.":

				roleIDLabels.add("EMEA");
				profileIDLabels.add("CBRE Manager - EMEA - Multi Business Line");
				timeZone.add("America/Los_Angeles");
				geographicalRole.add("EMEA");
				System.out.println("CM EMEA Manager IP User - :::" + userName + environment
						+ ":::is having the Role and Profle as::: EMEA and CBRE Manager - EMEA - Multi Business Line");
				break;

			case "testuser41@cbre.com.crm.":

				roleIDLabels.add("EMEA");
				profileIDLabels.add("CBRE Support Staff - EMEA - Multi Business Line");
				timeZone.add("America/Los_Angeles");
				geographicalRole.add("EMEA");
				System.out.println("CM EMEA CSS IP User - :::" + userName + environment
						+ ":::is having the Role and Profle as::: EMEA and CBRE Support Staff - EMEA - Multi Business Line");
				break;

			case "testuser45@cbre.com.crm.":

				roleIDLabels.add("EMEA");
				profileIDLabels.add("CBRE Broker - EMEA - Multi Business Line");
				timeZone.add("America/Los_Angeles");
				geographicalRole.add("EMEA");
				System.out.println("OB EMEA Broker User - :::" + userName + environment
						+ ":::is having the Role and Profle as::: EMEA and CBRE Broker - EMEA - Multi Business Line");
				break;

			case "testuser46@cbre.com.crm.":

				roleIDLabels.add("EMEA");
				profileIDLabels.add("CBRE Manager - EMEA - Multi Business Line");
				timeZone.add("America/Los_Angeles");
				geographicalRole.add("EMEA");
				System.out.println("OB EMEA Manager User - :::" + userName + environment
						+ ":::is having the Role and Profle as::: EMEA and CBRE Manager - EMEA - Multi Business Line");
				break;

			case "testuser47@cbre.com.crm.":

				roleIDLabels.add("EMEA");
				profileIDLabels.add("CBRE Support Staff - EMEA - Multi Business Line");
				timeZone.add("America/Los_Angeles");
				geographicalRole.add("EMEA");
				System.out.println("OB EMEA CSS User - :::" + userName + environment
						+ ":::is having the Role and Profle as::: EMEA and CBRE Support Staff - EMEA - Multi Business Line");
				break;

			case "testuser48@cbre.com.crm.":

				roleIDLabels.add("EMEA");
				profileIDLabels.add("CBRE Broker - EMEA - Multi Business Line");
				timeZone.add("America/Los_Angeles");
				geographicalRole.add("EMEA");
				System.out.println("VAS EMEA Broker User - :::" + userName + environment
						+ ":::is having the Role and Profle as::: EMEA and CBRE Broker - EMEA - Multi Business Line");
				break;

			case "testuser49@cbre.com.crm.":

				roleIDLabels.add("EMEA");
				profileIDLabels.add("CBRE Manager - EMEA - Multi Business Line");
				timeZone.add("America/Los_Angeles");
				geographicalRole.add("EMEA");
				System.out.println("VAS EMEA Manager User - :::" + userName + environment
						+ ":::is having the Role and Profle as::: EMEA and CBRE Manager - EMEA - Multi Business Line");
				break;

			case "testuser50@cbre.com.crm.":

				roleIDLabels.add("EMEA");
				profileIDLabels.add("CBRE Support Staff - EMEA - Multi Business Line");
				timeZone.add("America/Los_Angeles");
				geographicalRole.add("EMEA");
				System.out.println("VAS EMEA CSS User - :::" + userName + environment
						+ ":::is having the Role and Profle as::: EMEA and CBRE Support Staff - EMEA - Multi Business Line");
				break;

			case "testuser51@cbre.com.crm.":

				roleIDLabels.add("EMEA");
				profileIDLabels.add("CBRE - EMEA - Data Admin");
				timeZone.add("America/Los_Angeles");
				geographicalRole.add("EMEA");
				System.out.println("DataAdmin EMEA Data User - :::" + userName + environment
						+ ":::is having the Role and Profle as::: EMEA and CBRE - EMEA - Data Admin");
				break;

			case "testuser62@cbre.com.crm.":

				roleIDLabels.add("APAC");
				profileIDLabels.add("CBRE Manager - APAC - GWS");
				timeZone.add("America/Los_Angeles");
				geographicalRole.add("APAC");
				System.out.println("GWS APAC Manager User - :::" + userName + environment
						+ ":::is having the Role and Profle as::: APAC and CBRE Manager - APAC - GWS");
				break;

			case "testuser65@cbre.com.crm.":

				roleIDLabels.add("AMER");
				profileIDLabels.add("CBRE Manager - AMER - Valuations & Advisory Services");
				timeZone.add("America/Los_Angeles");
				geographicalRole.add("AMER");
				System.out.println("VAS AMER Manager User - :::" + userName + environment
						+ ":::is having the Role and Profle as::: AMER and CBRE Manager-AMER-Valuations &Advisory Services");
				break;

			case "testuser66@cbre.com.crm.":

				roleIDLabels.add("AMER");
				profileIDLabels.add("CBRE Manager - AMER - GWS");
				timeZone.add("America/Los_Angeles");
				geographicalRole.add("AMER");
				System.out.println("GWS AMER Manager User - :::" + userName + environment
						+ ":::is having the Role and Profle as::: AMER and CBRE Manager Staff - AMER - GWS");
				break;

			case "testuser67@cbre.com.crm.":

				roleIDLabels.add("APAC");
				profileIDLabels.add("CBRE Broker - APAC - GWS");
				timeZone.add("America/Los_Angeles");
				geographicalRole.add("APAC");
				System.out.println("GWS APAC Broker User - :::" + userName + environment
						+ ":::is having the Role and Profle as::: APAC and CBRE Broker - APAC - GWS");
				break;

			case "testuser68@cbre.com.crm.":

				roleIDLabels.add("EMEA");
				profileIDLabels.add("CBRE Manager - EMEA - Multi Business Line");
				timeZone.add("America/Los_Angeles");
				geographicalRole.add("EMEA");
				System.out.println("CM EMEA Manager BCP User - :::" + userName + environment
						+ ":::is having the Role and Profle as::: EMEA and CBRE Manager - EMEA - Multi Business Line");
				break;

			case "testuser69@cbre.com.crm.":

				roleIDLabels.add("EMEA");
				profileIDLabels.add("CBRE Manager - EMEA - Multi Business Line");
				timeZone.add("America/Los_Angeles");
				geographicalRole.add("EMEA");
				System.out.println("CM EMEA Manager Dev User - :::" + userName + environment
						+ ":::is having the Role and Profle as::: EMEA and CBRE Manager - EMEA - Multi Business Line");
				break;

			case "testuser70@cbre.com.crm.":

				roleIDLabels.add("UK Investment Advisory");
				profileIDLabels.add("CBRE Broker - EMEA - Multi Business Line");
				timeZone.add("America/Los_Angeles");
				geographicalRole.add("EMEA");
				System.out.println("CM EMEA Broker CA User - :::" + userName + environment
						+ ":::is having the Role and Profle as::: UK Investment Advisory and CBRE Broker - EMEA - Multi Business Line");
				break;

			case "testuser71@cbre.com.crm.":

				roleIDLabels.add("EMEA");
				profileIDLabels.add("CBRE Broker - EMEA - Multi Business Line");
				timeZone.add("America/Los_Angeles");
				geographicalRole.add("EMEA");
				System.out.println("CM EMEA Broker BCP User - :::" + userName + environment
						+ ":::is having the Role and Profle as::: EMEA and CBRE Broker - EMEA - Multi Business Line");
				break;

			case "testuser72@cbre.com.crm.":

				roleIDLabels.add("EMEA");
				profileIDLabels.add("CBRE Broker - EMEA - Multi Business Line");
				timeZone.add("America/Los_Angeles");
				geographicalRole.add("EMEA");
				System.out.println("CM EMEA Broker Dev User - :::" + userName + environment
						+ ":::is having the Role and Profle as::: EMEA and CBRE Broker - EMEA - Multi Business Line");
				break;

			case "testuser73@cbre.com.crm.":

				roleIDLabels.add("EMEA");
				profileIDLabels.add("CBRE Support Staff - EMEA - Multi Business Line");
				timeZone.add("America/Los_Angeles");
				geographicalRole.add("EMEA");
				System.out.println("CM EMEA CSS Dev User - :::" + userName + environment
						+ ":::is having the Role and Profle as::: EMEA and CBRE Support Staff - EMEA - Multi Business Line");
				break;

			case "testuser74@cbre.com.crm.":

				roleIDLabels.add("EMEA");
				profileIDLabels.add("CBRE Support Staff - EMEA - Multi Business Line");
				timeZone.add("America/Los_Angeles");
				geographicalRole.add("EMEA");
				System.out.println("CM EMEA CSS Super User - :::" + userName + environment
						+ ":::is having the Role and Profle as::: EMEA and CBRE Support Staff - EMEA - Multi Business Line");
				break;

			case "testuser75@cbre.com.crm.":

				roleIDLabels.add("EMEA");
				profileIDLabels.add("CBRE Broker - EMEA - Multi Business Line");
				timeZone.add("America/Los_Angeles");
				geographicalRole.add("EMEA");
				System.out.println("AS EMEA Broker Super User - :::" + userName + environment
						+ ":::is having the Role and Profle as::: EMEA and CBRE Broker - EMEA - Multi Business Line");
				break;

			case "testuser76@cbre.com.crm.":

				roleIDLabels.add("EMEA");
				profileIDLabels.add("CBRE Broker - EMEA - GWS");
				timeZone.add("America/Los_Angeles");
				geographicalRole.add("EMEA");
				System.out.println("GWS EMEA Broker Super User - :::" + userName + environment
						+ ":::is having the Role and Profle as::: EMEA and CBRE Broker - EMEA - GWS");
				break;

			case "testuser78@cbre.com.crm.":

				roleIDLabels.add("EMEA");
				profileIDLabels.add("CBRE Broker - EMEA - Multi Business Line");
				timeZone.add("America/Los_Angeles");
				geographicalRole.add("EMEA");
				System.out.println("VAS EMEA Broker Super User - :::" + userName + environment
						+ ":::is having the Role and Profle as::: EMEA and CBRE Broker - EMEA - Multi Business Line");
				break;

			case "testuser79@cbre.com.crm.":

				roleIDLabels.add("PAC_AB_IND_Auckland_Brokers");
				profileIDLabels.add("CBRE Broker - APAC - Capital Markets");
				timeZone.add("America/Los_Angeles");
				geographicalRole.add("APAC");
				System.out.println("CM APAC Broker AUC User - :::" + userName + environment
						+ ":::is having the Role and Profle as::: PAC_AB_IND_Auckland_Brokers and CBRE Broker - APAC - Capital Markets");
				break;

			case "testuser80@cbre.com.crm.":

				roleIDLabels.add("PAC_CM_OFFICE");
				profileIDLabels.add("CBRE Broker - APAC - Capital Markets");
				timeZone.add("America/Los_Angeles");
				geographicalRole.add("APAC");
				System.out.println("CM APAC Broker NZL User - :::" + userName + environment
						+ ":::is having the Role and Profle as::: PAC_CM_OFFICE and CBRE Broker - APAC - Capital Markets");
				break;

			case "testuser81@cbre.com.crm.":

				roleIDLabels.add("PAC_CM_Metro");
				profileIDLabels.add("CBRE Broker - APAC - Capital Markets");
				timeZone.add("America/Los_Angeles");
				geographicalRole.add("APAC");
				System.out.println("CM APAC Broker Metro NZL User - :::" + userName + environment
						+ ":::is having the Role and Profle as::: PAC CM Metro and CBRE Broker - APAC - Capital Markets");
				break;

			case "testuser82@cbre.com.crm.":

				roleIDLabels.add("PAC_CM_Metro");
				profileIDLabels.add("CBRE Broker - APAC - Capital Markets");
				timeZone.add("America/Los_Angeles");
				geographicalRole.add("APAC");
				System.out.println("CM APAC Brokder Metro User - :::" + userName + environment
						+ ":::is having the Role and Profle as::: PAC_CM_Metroa nd CBRE Broker - APAC - Capital Markets");
				permissionSetsLabels.add("Lightning Experience");
				break;

			case "testuser83@cbre.com.crm.":

				roleIDLabels.add("PAC_AB_IND_South Australia_Brokers");
				profileIDLabels.add("CBRE Broker - APAC - Capital Markets");
				timeZone.add("America/Los_Angeles");
				geographicalRole.add("APAC");
				System.out.println("CM APAC Broker AUS User - :::" + userName + environment
						+ ":::is having the Role and Profle as::: PAC_AB_IND_South Australia_Brokers and CBRE Broker - APAC - Capital Markets");
				break;

			case "testuser84@cbre.com.crm.":

				roleIDLabels.add("PAC_AB_Retail_AU_AB_Retail_New South Wales Brokers");
				profileIDLabels.add("CBRE Broker - APAC - Capital Markets");
				timeZone.add("America/Los_Angeles");
				geographicalRole.add("APAC");
				System.out.println("CM APAC Broker NSW User - :::" + userName + environment
						+ ":::is having the Role and Profle as::: PAC_AB_Retail_AU_AB_Retail_New South Wales Brokers and CBRE Broker - APAC - Capital Markets");
				break;

			case "testuser85@cbre.com.crm.":

				roleIDLabels.add("PAC_AB_Retail_NZ_AB_Retail_Christchurch_Brokers");
				profileIDLabels.add("CBRE Broker - APAC - Capital Markets");
				timeZone.add("America/Los_Angeles");
				geographicalRole.add("APAC");
				System.out.println("CM APAC Broker Christ Church User - :::" + userName + environment
						+ ":::is having the Role and Profle as::: PAC_AB_Retail_NZ_AB_Retail_Christchurch_Brokers and "
						+ "CBRE Broker - APAC - Capital Markets");
				break;

			case "testuser86@cbre.com.crm.":

				roleIDLabels.add("UK");
				profileIDLabels.add("CBRE - EMEA - Business Development");
				timeZone.add("America/Los_Angeles");
				geographicalRole.add("EMEA");
				System.out.println("OB EMEA Occupier Client Care User - :::" + userName + environment
						+ ":::is having the Role and Profle as::: UK and CBRE - EMEA - Business Development");
				break;

			case "testuser87@cbre.com.crm.":

				roleIDLabels.add("APAC");
				profileIDLabels.add("CBRE Broker - APAC - Capital Markets");
				timeZone.add("America/Los_Angeles");
				geographicalRole.add("APAC");
				System.out.println("CM APAC Broker Campaign User - :::" + userName + environment
						+ ":::is having the Role and Profle as::: APAC and CBRE Broker - APAC - Capital Markets");
				break;

			case "testuser88@cbre.com.crm.":

				roleIDLabels.add("APAC");
				profileIDLabels.add("CBRE Broker - APAC - Capital Markets");
				timeZone.add("America/Los_Angeles");
				geographicalRole.add("APAC");
				System.out.println("CM APAC Broker MVP User - :::" + userName + environment
						+ ":::is having the Role and Profle as::: APAC and CBRE Broker - APAC - Capital Markets");
				break;

			case "testuser90@cbre.com.crm.":

				roleIDLabels.add("EMEA");
				profileIDLabels.add("CBRE Manager - EMEA - Multi Business Line");
				timeZone.add("America/Los_Angeles");
				geographicalRole.add("EMEA");
				System.out.println("CM EMEA Manager CA User - :::" + userName + environment
						+ ":::is having the Role and Profle as::: EMEA and CBRE Manager - EMEA - Multi Business Line");
				break;

			case "testuser91@cbre.com.crm.":

				roleIDLabels.add("AMER");
				profileIDLabels.add("CBRE Support Staff - AMER - Capital Markets");
				timeZone.add("America/Los_Angeles");
				geographicalRole.add("AMER");
				System.out.println("DataAdmin EMEA Data User - :::" + userName + environment
						+ ":::is having the Role and Profle as::: AMER and CBRE Support Staff - AMER - Capital Markets");
				break;

			case "testuser92@cbre.com.crm.":

				roleIDLabels.add("APAC");
				profileIDLabels.add("CBRE Broker - APAC - Multi Business Line");
				timeZone.add("America/Los_Angeles");
				geographicalRole.add("APAC");
				System.out.println("DataAdmin EMEA Data User - :::" + userName + environment
						+ ":::is having the Role and Profle as::: APAC and CBRE Broker - APAC - Multi Business Line");
				break;

			case "testuser93@cbre.com.crm.":

				roleIDLabels.add("EXECUTIVE");
				profileIDLabels.add("CBRE Broker - JAPAN - Capital Markets");
				timeZone.add("America/Los_Angeles");
				geographicalRole.add("APAC");
				System.out.println("DataAdmin EMEA Data User - :::" + userName + environment
						+ ":::is having the Role and Profle as::: Executive and CBRE Broker - JAPAN - Capital Markets");
				break;

			case "testuser94@cbre.com.crm.":

				roleIDLabels.add("APAC");
				profileIDLabels.add("CBRE - APAC - Project Management");
				timeZone.add("America/Los_Angeles");
				geographicalRole.add("APAC");
				System.out.println("DataAdmin EMEA Data User - :::" + userName + environment
						+ ":::is having the Role and Profle as::: APAC and CBRE - APAC - Project Management");
				break;

			case "testuser95@cbre.com.crm.":

				roleIDLabels.add("FR DIG");
				profileIDLabels.add("CBRE - France - Data Admin");
				timeZone.add("Europe/Paris");
				geographicalRole.add("EMEA");
				System.out.println("France Data User - :::" + userName + environment
						+ ":::is having the Role and Profle as::: FR DIG and CBRE - France - Data Admin");
				break;

			case "testuser96@cbre.com.crm.":

				roleIDLabels.add("FR - CODIR+");
				profileIDLabels.add("CBRE Manager - France - Multi Business Line");
				timeZone.add("Europe/Paris");
				geographicalRole.add("EMEA");
				System.out.println("France Manager - :::" + userName + environment
						+ ":::is having the Role and Profle as::: FR - CODIR+ and CBRE Manager - France - Multi Business Line");
				break;

			case "testuser97@cbre.com.crm.":

				roleIDLabels.add("FR DIG");
				profileIDLabels.add("CBRE Manager - France - Multi Business Line");
				timeZone.add("Europe/Paris");
				geographicalRole.add("EMEA");
				System.out.println("France Manager - :::" + userName + environment
						+ ":::is having the Role and Profle as::: FR DIG and CBRE Manager - France - Multi Business Line");
				break;

			case "testuser98@cbre.com.crm.":

				roleIDLabels.add("FRANCE");
				profileIDLabels.add("CBRE Manager - France - Multi Business Line");
				timeZone.add("Europe/Paris");
				geographicalRole.add("EMEA");
				System.out.println("France Manager - :::" + userName + environment
						+ ":::is having the Role and Profle as::: France and CBRE Manager - France - Multi Business Line");
				break;

			case "testuser99@cbre.com.crm.":

				roleIDLabels.add("SOUTHEAST ASIA");
				profileIDLabels.add("CBRE Data Admin");
				timeZone.add("Asia/Singapore");
				geographicalRole.add("APAC");
				System.out.println("SouthEast Asia Data Admin- :::" + userName + environment
						+ ":::is having the Role and Profle as::: SouthEast Asia - CBRE Data Admin");
				break;

			case "testuser100@cbre.com.crm.":

				roleIDLabels.add("PACIFIC");
				profileIDLabels.add("CBRE Data Admin");
				geographicalRole.add("APAC");
				timeZone.add("Australia/Sydney");
				System.out.println("Pacific Data Admin- :::" + userName + environment
						+ ":::is having the Role and Profle as::: Pacific - CBRE Data Admin");
				break;

			default:

				roleIDLabels.add("EXECUTIVE");
				profileIDLabels.add("System Administrator");
				timeZone.add("America/Los_Angeles");
				geographicalRole.add("AMER");
				System.out.println("System Administrator User - :::" + userName + environment
						+ ":::is having the Role and Profle as:::EXECUTIVE and System Administrator");
				break;
			}
			String abc =null;
			establishConnection.establishConnection();
			roleProfileTimeZone = getRoleId(roleIDLabels.get(i)) + "-" + getProfileId(profileIDLabels.get(i)) + "-" + geographicalRole.get(i) 
			+ "-" + timeZone.get(i);
			profileIDLabels.clear();
			roleIDLabels.clear();
			geographicalRole.clear();
			timeZone.clear();
		}
		return roleProfileTimeZone;
	}

	/**
	 * Function to get the permission set Id
	 * 
	 * @author Vishnuvardhan
	 *
	 */

	public String getPermSetId(String name) throws Exception {
		String query = "SELECT Id FROM PermissionSet where label ='" + name + "'";
		QueryResult result = EstablishConnection.connection.query(query);
		return result.getRecords()[0].getId();
	}

	/**
	 * Function to assign permission set Id
	 * 
	 * @author Vishnuvardhan
	 *
	 */

	public void setPermSetAssigned(String userId, String permSetId) {
		try {
			String query = "SELECT Id FROM PermissionSetAssignment where AssigneeId ='" + userId
					+ "' and PermissionSetId='" + permSetId + "'";
			QueryResult result = EstablishConnection.connection.query(query);
			if (result.getRecords().length == 0) {
				Assert.assertTrue(assignPermSet(userId, permSetId), "Permission Set Assignment Failed");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public boolean assignPermSet(String userId, String permSetId) {
		try {
			SObject permSetAssign = new SObject();
			permSetAssign.setType("PermissionSetAssignment");
			permSetAssign.setField("AssigneeId", userId);
			permSetAssign.setField("PermissionSetId", permSetId);
			results = EstablishConnection.connection.create(new SObject[] { permSetAssign });
		} catch (ConnectionException e) {
			e.printStackTrace();
		}
		return results[0].isSuccess();
	}

	public String getProfileId(String name) {
		String result = null;
		try {
			String query = "SELECT Id FROM Profile where name ='" + name + "'";
			result = searchTextSOQL.fetchRecordFieldValue("Id", query);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	public String getRoleId(String name) throws Exception {
		String query = "SELECT Id FROM UserRole where name ='" + name + "'";
		QueryResult result = EstablishConnection.connection.query(query);
		return result.getRecords()[0].getId();
	}

	public String getRoleName(String userRoleId) throws Exception {
		String query = "SELECT Name FROM UserRole where Id ='" + userRoleId + "'";
		QueryResult result = EstablishConnection.connection.query(query);
		return result.getRecords()[0].getId();
	}

	public String getProfileName(String profileId) throws Exception {
		String query = "SELECT Name FROM Profile where Id ='" + profileId + "'";
		QueryResult result = EstablishConnection.connection.query(query);
		return result.getRecords()[0].getId();
	}
	public String setRole(String userId, String userRoleId) throws Exception {
		String query = "SELECT UserRoleId FROM User where id = '" + userId + "'";
		QueryResult result; String roleName;
		try {
			result = EstablishConnection.connection.query(query);
			String resultId = searchTextSOQL.fetchRecordFieldValue("UserRoleId", query);			
			if (result.getRecords().length == 0) {
				SObject user = new SObject();
				user.setType("user");
				user.setField("Id", userId);
				user.setField("UserRoleId", userRoleId);
				EstablishConnection.connection.update(new SObject[] { user });
			}  else if(!resultId.equals(userRoleId)) { 
				SObject user = new SObject();
				user.setType("user");
				user.setField("Id", userId);
				user.setField("UserRoleId", userRoleId);
				results = EstablishConnection.connection.update(new SObject[] { user });
				System.out.println(results[0].isSuccess());
				roleName = getRoleName(userRoleId);
				report.updateTestLog("Role Update", "Role updated for the user" + getUserName(userId) + ":::" + roleName, Status.PASS);
			}
		} catch (ConnectionException e) {
			e.printStackTrace();
		}
		return userRoleId;
	}

	public QueryResult getTimeZone(String userName) {
		String query = "SELECT TimeZoneSidKey FROM User where userName ='" + userName + "'";
		QueryResult result = null;
		try {
			result = EstablishConnection.connection.query(query);
		} catch (ConnectionException e) {
			e.printStackTrace();
		}
		return result;
	}

	public String setProfile(String userId, String profileId) {
		try {
			String query = "SELECT profileId FROM User where id ='" + userId + "'"; String profileName;
			QueryResult result = EstablishConnection.connection.query(query);
			String resultId = searchTextSOQL.fetchRecordFieldValue("ProfileId", query);
			if (result.getRecords().length == 0) {
				SObject user = new SObject();
				user.setType("user");
				user.setField("Id", userId);
				user.setField("profileId", profileId);
				EstablishConnection.connection.update(new SObject[] { user });
			} else if(!resultId.equals(profileId)) {
				SObject user = new SObject();
				user.setType("user");
				user.setField("Id", userId);
				user.setField("profileId", profileId);
				results = EstablishConnection.connection.update(new SObject[] { user });
				System.out.println(results[0].isSuccess());
				profileName = getProfileName(profileId);
				report.updateTestLog("Profile Update", "Profile updated for the user" + getUserName(userId) + ":::" + profileName, Status.PASS);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return profileId;
	}

	public String getUserId(String userName) {
		QueryResult result;
		String sResult = null;
		try {
			String query = "SELECT Id FROM User where userName ='" + userName + "'";
			result = EstablishConnection.connection.query(query);
			if (result.getRecords().length == 0) {
				sResult = null;
			} else {
				sResult = result.getRecords()[0].getId();
			}
		} catch (ConnectionException e) {
			e.printStackTrace();
		}
		return sResult;
	}

	public String getUserName(String userId) {
		QueryResult result;
		String sResult = null;
		try {
			String query = "SELECT Username FROM User where Id ='" + userId + "'";
			result = EstablishConnection.connection.query(query);

			if (result.getRecords().length == 0) {
				sResult = null;
			} else {
				sResult = searchTextSOQL.fetchRecordFieldValue("Username", query);
				// sResult = result.getRecords()[0].getId();
			}
		} catch (ConnectionException e) {
			e.printStackTrace();
		}
		return sResult;
	}
}
