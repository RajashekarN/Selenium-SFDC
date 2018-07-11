package pagesAPI;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.cognizant.Craft.ReusableLibrary;
import com.cognizant.Craft.ScriptHelper;
import com.cognizant.framework.Status;
import com.sforce.soap.partner.DeleteResult;
import com.sforce.soap.partner.DescribeLayout;
import com.sforce.soap.partner.DescribeLayoutResult;
import com.sforce.soap.partner.DescribeLayoutSection;
import com.sforce.soap.partner.DescribeSObjectResult;
import com.sforce.soap.partner.Field;
import com.sforce.soap.partner.GetUserInfoResult;
import com.sforce.soap.partner.LeadConvertResult;
import com.sforce.soap.partner.LoginResult;
import com.sforce.soap.partner.PartnerConnection;
import com.sforce.soap.partner.PicklistEntry;
import com.sforce.soap.partner.SaveResult;
import com.sforce.soap.partner.SetPasswordResult;
import com.sforce.ws.ConnectionException;
import com.sforce.ws.ConnectorConfig;
import com.sforce.soap.metadata.Layout;
import com.sforce.soap.metadata.LayoutColumn;
import com.sforce.soap.metadata.LayoutItem;
import com.sforce.soap.metadata.LayoutSection;
import com.sforce.soap.metadata.Metadata;
import com.sforce.soap.metadata.MetadataConnection;
import com.sforce.soap.metadata.PicklistValue;
import com.sforce.soap.metadata.ReadResult;
import com.sforce.soap.metadata.RecordType;
import com.sforce.soap.metadata.RecordTypePicklistValue;

public class EstablishConnection extends ReusableLibrary {
	/*
	 * Constructor to initialize the business component library
	 * 
	 * @param scriptHelper The {@link ScriptHelper} object passed from the
	 * {@link DriverScript}
	 */

	public EstablishConnection(ScriptHelper scriptHelper) {
		super(scriptHelper);
	}

	public static PartnerConnection connection = null;
	static SetPasswordResult setPasswordResults = null;
	static ConnectorConfig config;
	static ConnectorConfig metadataConfig;
	static MetadataConnection metadataConnection;
	static com.sforce.soap.partner.Error[] errors;
	static boolean status = false;
	static String result;

	/**
	 * Function for retrieving the environment
	 * 
	 * @author Vishnuvardhan
	 *
	 */
	public static String environment = System.getProperty("RunEnvironment");

	public String initializeEnvironment() {
		try {
			if (environment.equals(null)) {

			}
		} catch (Exception e) {
			environment = properties.getProperty("RunEnvironment");
			System.out.println(
					"Environment is set as per the RunEnvironment value in Global Settings file:::" + environment);
		}
		return environment;
	}

	/**
	 * Function for establishing the connection
	 * 
	 * @author Vishnuvardhan
	 *
	 */

	public void establishConnection() {
		try {
			String environment = initializeEnvironment();
			System.out.println(environment);
			String Username = null, Password = null;
			if ((environment.equals("UAT")) || (environment.equals("UAT2")) || (environment.equals("FTE"))
					|| (environment.equals("FTE2"))) {
				if ((dataTable.getData("General_Data", "TC_ID").contains("OBEMEA"))
						&& (dataTable.getData("General_Data", "TC_ID").contains("Broker"))
						&& (!dataTable.getData("General_Data", "TC_ID").contains("Admin")))
					Username = properties.getProperty("OBEMEABroker") + "." + environment;
				else if ((dataTable.getData("General_Data", "TC_ID").contains("OBEMEA"))
						&& (dataTable.getData("General_Data", "TC_ID").contains("Manager"))
						&& (!dataTable.getData("General_Data", "TC_ID").contains("Admin")))
					Username = properties.getProperty("OBEMEAManager") + "." + environment;
				else if ((dataTable.getData("General_Data", "TC_ID").contains("OBEMEA"))
						&& (dataTable.getData("General_Data", "TC_ID").contains("CSS"))
						&& (!dataTable.getData("General_Data", "TC_ID").contains("Admin")))
					Username = properties.getProperty("OBEMEACSS") + "." + environment;
				else if ((dataTable.getData("General_Data", "TC_ID").contains("CMAPAC"))
						&& (dataTable.getData("General_Data", "TC_ID").contains("Broker"))
						&& (!dataTable.getData("General_Data", "TC_ID").contains("Admin")))
					Username = properties.getProperty("CMAPACBroker") + "." + environment;
				else if ((dataTable.getData("General_Data", "TC_ID").contains("CMAPAC"))
						&& (dataTable.getData("General_Data", "TC_ID").contains("Manager"))
						&& (!dataTable.getData("General_Data", "TC_ID").contains("Admin")))
					Username = properties.getProperty("CMAPACManager") + "." + environment;
				else if ((dataTable.getData("General_Data", "TC_ID").contains("CMAPAC"))
						&& (dataTable.getData("General_Data", "TC_ID").contains("CSS"))
						&& (!dataTable.getData("General_Data", "TC_ID").contains("Admin")))
					Username = properties.getProperty("CMAPACCSS") + "." + environment;
				else if ((dataTable.getData("General_Data", "TC_ID").contains("CMEMEA"))
						&& (dataTable.getData("General_Data", "TC_ID").contains("Broker"))
						&& (!dataTable.getData("General_Data", "TC_ID").contains("Admin")))
					Username = properties.getProperty("CMEMEABroker") + "." + environment;
				else if ((dataTable.getData("General_Data", "TC_ID").contains("CMEMEA"))
						&& (dataTable.getData("General_Data", "TC_ID").contains("Manager"))
						&& (!dataTable.getData("General_Data", "TC_ID").contains("Admin")))
					Username = properties.getProperty("CMEMEAManager") + "." + environment;
				else if ((dataTable.getData("General_Data", "TC_ID").contains("CMEMEA"))
						&& (dataTable.getData("General_Data", "TC_ID").contains("CSS"))
						&& (!dataTable.getData("General_Data", "TC_ID").contains("Admin")))
					Username = properties.getProperty("CMEMEACSS") + "." + environment;
				else if ((dataTable.getData("General_Data", "TC_ID").contains("ABEMEA"))
						&& (dataTable.getData("General_Data", "TC_ID").contains("Broker"))
						&& (!dataTable.getData("General_Data", "TC_ID").contains("Admin")))
					Username = properties.getProperty("ABEMEABroker") + "." + environment;
				else if ((dataTable.getData("General_Data", "TC_ID").contains("ABEMEA"))
						&& (dataTable.getData("General_Data", "TC_ID").contains("Manager"))
						&& (!dataTable.getData("General_Data", "TC_ID").contains("Admin")))
					Username = properties.getProperty("ABEMEAManager") + "." + environment;
				else if ((dataTable.getData("General_Data", "TC_ID").contains("ABEMEA"))
						&& (dataTable.getData("General_Data", "TC_ID").contains("CSS"))
						&& (!dataTable.getData("General_Data", "TC_ID").contains("Admin")))
					Username = properties.getProperty("ABEMEACSS") + "." + environment;
				else if ((dataTable.getData("General_Data", "TC_ID").contains("ABAMER"))
						&& (dataTable.getData("General_Data", "TC_ID").contains("Admin"))
						&& (!dataTable.getData("General_Data", "TC_ID").contains("Admin")))
					Username = properties.getProperty("SystemAdminUsername") + "." + environment;
				else if ((dataTable.getData("General_Data", "TC_ID").contains("ABAMER"))
						&& (dataTable.getData("General_Data", "TC_ID").contains("Broker"))
						&& (!dataTable.getData("General_Data", "TC_ID").contains("Admin")))
					Username = properties.getProperty("ABAMERBroker") + "." + environment;
				else if ((dataTable.getData("General_Data", "TC_ID").contains("ABAMER"))
						&& (dataTable.getData("General_Data", "TC_ID").contains("Manager"))
						&& (!dataTable.getData("General_Data", "TC_ID").contains("Admin")))
					Username = properties.getProperty("ABAMERManager") + "." + environment;
				else if ((dataTable.getData("General_Data", "TC_ID").contains("ABAMER"))
						&& (dataTable.getData("General_Data", "TC_ID").contains("CSS"))
						&& (!dataTable.getData("General_Data", "TC_ID").contains("Admin")))
					Username = properties.getProperty("ABAMERCSS") + "." + environment;
				else if ((dataTable.getData("General_Data", "TC_ID").contains("OBAMER"))
						&& (dataTable.getData("General_Data", "TC_ID").contains("Broker"))
						&& (!dataTable.getData("General_Data", "TC_ID").contains("Admin")))
					Username = properties.getProperty("OBAMERBroker") + "." + environment;
				else if ((dataTable.getData("General_Data", "TC_ID").contains("OBAMER"))
						&& (dataTable.getData("General_Data", "TC_ID").contains("Manager"))
						&& (!dataTable.getData("General_Data", "TC_ID").contains("Admin")))
					Username = properties.getProperty("OBAMERManager") + "." + environment;
				else if ((dataTable.getData("General_Data", "TC_ID").contains("OBAMER"))
						&& (dataTable.getData("General_Data", "TC_ID").contains("CSS"))
						&& (!dataTable.getData("General_Data", "TC_ID").contains("Admin")))
					Username = properties.getProperty("OBAMERCSS") + "." + environment;
				else if ((dataTable.getData("General_Data", "TC_ID").contains("OBAMER"))
						&& (dataTable.getData("General_Data", "TC_ID").contains("Admin"))
						&& (!dataTable.getData("General_Data", "TC_ID").contains("Admin")))
					Username = properties.getProperty("SystemAdminUsername") + "." + environment;
				else if ((dataTable.getData("General_Data", "TC_ID").contains("OBAPAC"))
						&& (dataTable.getData("General_Data", "TC_ID").contains("Broker"))
						&& (!dataTable.getData("General_Data", "TC_ID").contains("Admin")))
					Username = properties.getProperty("OBAPACBroker") + "." + environment;
				else if ((dataTable.getData("General_Data", "TC_ID").contains("OBAPAC"))
						&& (dataTable.getData("General_Data", "TC_ID").contains("Manager"))
						&& (!dataTable.getData("General_Data", "TC_ID").contains("Admin")))
					Username = properties.getProperty("OBAPACManager") + "." + environment;
				else if ((dataTable.getData("General_Data", "TC_ID").contains("OBAPAC"))
						&& (dataTable.getData("General_Data", "TC_ID").contains("CSS"))
						&& (!dataTable.getData("General_Data", "TC_ID").contains("Admin")))
					Username = properties.getProperty("OBAPACCSS") + "." + environment;
				else if ((dataTable.getData("General_Data", "TC_ID").contains("CMAMER"))
						&& (dataTable.getData("General_Data", "TC_ID").contains("Broker"))
						&& (!dataTable.getData("General_Data", "TC_ID").contains("Admin")))
					Username = properties.getProperty("CMAMERBroker") + "." + environment;
				else if ((dataTable.getData("General_Data", "TC_ID").contains("CMAMER"))
						&& (dataTable.getData("General_Data", "TC_ID").contains("Manager"))
						&& (!dataTable.getData("General_Data", "TC_ID").contains("Admin")))
					Username = properties.getProperty("CMAMERManager") + "." + environment;
				else if ((dataTable.getData("General_Data", "TC_ID").contains("CMAMER"))
						&& (dataTable.getData("General_Data", "TC_ID").contains("CSS"))
						&& (!dataTable.getData("General_Data", "TC_ID").contains("Admin")))
					Username = properties.getProperty("CMAMERCSS") + "." + environment;
				else if ((dataTable.getData("General_Data", "TC_ID").contains("CMEMEA"))
						&& (dataTable.getData("General_Data", "TC_ID").contains("Broker"))
						&& (!dataTable.getData("General_Data", "TC_ID").contains("Admin")))
					Username = properties.getProperty("CMEMEABroker") + "." + environment;
				else if ((dataTable.getData("General_Data", "TC_ID").contains("CMEMEA"))
						&& (dataTable.getData("General_Data", "TC_ID").contains("Manager"))
						&& (!dataTable.getData("General_Data", "TC_ID").contains("Admin")))
					Username = properties.getProperty("CMEMEAManager") + "." + environment;
				else if ((dataTable.getData("General_Data", "TC_ID").contains("CMEMEA"))
						&& (dataTable.getData("General_Data", "TC_ID").contains("CSS"))
						&& (!dataTable.getData("General_Data", "TC_ID").contains("Admin")))
					Username = properties.getProperty("CMEMEACSS") + "." + environment;
				else if ((dataTable.getData("General_Data", "TC_ID").contains("ASAPAC"))
						&& (dataTable.getData("General_Data", "TC_ID").contains("Broker"))
						&& (!dataTable.getData("General_Data", "TC_ID").contains("Admin")))
					Username = properties.getProperty("ASAPACBroker") + "." + environment;
				else if ((dataTable.getData("General_Data", "TC_ID").contains("ASAPAC"))
						&& (dataTable.getData("General_Data", "TC_ID").contains("Manager"))
						&& (!dataTable.getData("General_Data", "TC_ID").contains("Admin")))
					Username = properties.getProperty("ASAPACManager") + "." + environment;
				else if ((dataTable.getData("General_Data", "TC_ID").contains("ASAPAC"))
						&& (dataTable.getData("General_Data", "TC_ID").contains("CSS"))
						&& (!dataTable.getData("General_Data", "TC_ID").contains("Admin")))
					Username = properties.getProperty("ASAPACCSS") + "." + environment;
				else if ((dataTable.getData("General_Data", "TC_ID").contains("GWSAPAC"))
						&& (dataTable.getData("General_Data", "TC_ID").contains("Broker"))
						&& (!dataTable.getData("General_Data", "TC_ID").contains("Admin")))
					Username = properties.getProperty("GWSAPACBroker") + "." + environment;
				else if ((dataTable.getData("General_Data", "TC_ID").contains("GWSAPAC"))
						&& (dataTable.getData("General_Data", "TC_ID").contains("Manager"))
						&& (!dataTable.getData("General_Data", "TC_ID").contains("Admin")))
					Username = properties.getProperty("GWSAPACManager") + "." + environment;
				else if ((dataTable.getData("General_Data", "TC_ID").contains("GWSAPAC"))
						&& (dataTable.getData("General_Data", "TC_ID").contains("CSS"))
						&& (!dataTable.getData("General_Data", "TC_ID").contains("Admin")))
					Username = properties.getProperty("GWSAPACCSS") + "." + environment;
				else if ((dataTable.getData("General_Data", "TC_ID").contains("GWSAMER"))
						&& (dataTable.getData("General_Data", "TC_ID").contains("Broker"))
						&& (!dataTable.getData("General_Data", "TC_ID").contains("Admin")))
					Username = properties.getProperty("GWSAMERBroker") + "." + environment;
				else if ((dataTable.getData("General_Data", "TC_ID").contains("GWSAMER"))
						&& (dataTable.getData("General_Data", "TC_ID").contains("Manager"))
						&& (!dataTable.getData("General_Data", "TC_ID").contains("Admin")))
					Username = properties.getProperty("GWSAMERManager") + "." + environment;
				else if ((dataTable.getData("General_Data", "TC_ID").contains("GWSAMER"))
						&& (dataTable.getData("General_Data", "TC_ID").contains("CSS"))
						&& (!dataTable.getData("General_Data", "TC_ID").contains("Admin")))
					Username = properties.getProperty("GWSAMERCSS") + "." + environment;
				else if ((dataTable.getData("General_Data", "TC_ID").contains("VASAMER"))
						&& (dataTable.getData("General_Data", "TC_ID").contains("Broker"))
						&& (!dataTable.getData("General_Data", "TC_ID").contains("Admin")))
					Username = properties.getProperty("VASAMERBroker") + "." + environment;
				else if ((dataTable.getData("General_Data", "TC_ID").contains("VASAMER"))
						&& (dataTable.getData("General_Data", "TC_ID").contains("Manager"))
						&& (!dataTable.getData("General_Data", "TC_ID").contains("Admin")))
					Username = properties.getProperty("VASAMERManager") + "." + environment;
				else if ((dataTable.getData("General_Data", "TC_ID").contains("VASAMER"))
						&& (dataTable.getData("General_Data", "TC_ID").contains("CSS"))
						&& (!dataTable.getData("General_Data", "TC_ID").contains("Admin")))
					Username = properties.getProperty("VASAMERCSS") + "." + environment;
				else if ((dataTable.getData("General_Data", "TC_ID").contains("VASEMEA"))
						&& (dataTable.getData("General_Data", "TC_ID").contains("Broker"))
						&& (!dataTable.getData("General_Data", "TC_ID").contains("Admin")))
					Username = properties.getProperty("VASEMEABroker") + "." + environment;
				else if ((dataTable.getData("General_Data", "TC_ID").contains("VASEMEA"))
						&& (dataTable.getData("General_Data", "TC_ID").contains("Manager"))
						&& (!dataTable.getData("General_Data", "TC_ID").contains("Admin")))
					Username = properties.getProperty("VASEMEAManager") + "." + environment;
				else if ((dataTable.getData("General_Data", "TC_ID").contains("VASEMEA"))
						&& (dataTable.getData("General_Data", "TC_ID").contains("CSS"))
						&& (!dataTable.getData("General_Data", "TC_ID").contains("Admin")))
					Username = properties.getProperty("VASEMEACSS") + "." + environment;
				else if ((dataTable.getData("General_Data", "TC_ID").contains("FRANEMEA"))
						&& (dataTable.getData("General_Data", "TC_ID").contains("Manager"))
						&& (!dataTable.getData("General_Data", "TC_ID").contains("Admin")))
					Username = properties.getProperty("FRANEMEAManager") + "." + environment;
				else if ((dataTable.getData("General_Data", "TC_ID").contains("FDIGEMEA"))
						&& (dataTable.getData("General_Data", "TC_ID").contains("Manager"))
						&& (!dataTable.getData("General_Data", "TC_ID").contains("Admin")))
					Username = properties.getProperty("FDIGEMEAManager") + "." + environment;
				else if ((dataTable.getData("General_Data", "TC_ID").contains("FDIREMEA"))
						&& (dataTable.getData("General_Data", "TC_ID").contains("Manager"))
						&& (!dataTable.getData("General_Data", "TC_ID").contains("Admin")))
					Username = properties.getProperty("FDIREMEAManager") + "." + environment;
				else if ((dataTable.getData("General_Data", "TC_ID").contains("FDIGEMEA"))
						&& (dataTable.getData("General_Data", "TC_ID").contains("Data"))
						&& (!dataTable.getData("General_Data", "TC_ID").contains("Admin")))
					Username = properties.getProperty("FDIGEMEAData") + "." + environment;
				else if ((dataTable.getData("General_Data", "TC_ID").contains("DAASIA"))
						&& (dataTable.getData("General_Data", "TC_ID").contains("Data"))
						&& (!dataTable.getData("General_Data", "TC_ID").contains("Admin")))
					Username = properties.getProperty("DAASIAData") + "." + environment;
				else if ((dataTable.getData("General_Data", "TC_ID").contains("DAPACI"))
						&& (dataTable.getData("General_Data", "TC_ID").contains("Data"))
						&& (!dataTable.getData("General_Data", "TC_ID").contains("Admin")))
					Username = properties.getProperty("DAPACIData") + "." + environment;
				else if ((dataTable.getData("General_Data", "TC_ID").contains("DAEMEA"))
						&& (dataTable.getData("General_Data", "TC_ID").contains("Data"))
						&& (!dataTable.getData("General_Data", "TC_ID").contains("Admin")))
					Username = properties.getProperty("DAPACIData") + "." + environment;			
				else if ((dataTable.getData("General_Data", "TC_ID").contains("ABAPAC"))
						&& (dataTable.getData("General_Data", "TC_ID").contains("Broker"))
						&& (!dataTable.getData("General_Data", "TC_ID").contains("Admin")))
					Username = properties.getProperty("ABAPACBroker") + "." + environment;
				else if ((dataTable.getData("General_Data", "TC_ID").contains("ABAPAC"))
						&& (dataTable.getData("General_Data", "TC_ID").contains("Manager"))
						&& (!dataTable.getData("General_Data", "TC_ID").contains("Admin")))
					Username = properties.getProperty("ABAPACManager") + "." + environment;
				else if ((dataTable.getData("General_Data", "TC_ID").contains("ABAPAC"))
						&& (dataTable.getData("General_Data", "TC_ID").contains("CSS"))
						&& (!dataTable.getData("General_Data", "TC_ID").contains("Admin")))
					Username = properties.getProperty("ABAPACCSS") + "." + environment;
				else if ((dataTable.getData("General_Data", "TC_ID").contains("ASAMER"))
						&& (dataTable.getData("General_Data", "TC_ID").contains("Manager"))
						&& (!dataTable.getData("General_Data", "TC_ID").contains("Admin")))
					Username = properties.getProperty("ASAMERManager") + "." + environment;
				else if (dataTable.getData("General_Data", "TC_ID").contains("Admin"))
					Username = properties.getProperty("SystemAdminUsername") + "." + environment;
			}

			if (environment.equals("UAT")) {
				if (dataTable.getData("General_Data", "TC_ID").contains("Admin")) {
					Password = properties.getProperty("UATAdminPassword");
				} else {
					Password = properties.getProperty("UATPassword");
				}
				String UAT_AuthEndpoint = properties.getProperty("UATAuthEndpoint");
				config = new ConnectorConfig();
				config.setUsername(Username);
				config.setPassword(Password);
				System.out.println("AuthEndPoint: " + UAT_AuthEndpoint);
				config.setAuthEndpoint(UAT_AuthEndpoint);
				connection = new PartnerConnection(config);
				System.out.println(connection);
			} else if (environment.equals("UAT2")) {
				if (dataTable.getData("General_Data", "TC_ID").contains("Admin")) {
					Password = properties.getProperty("UAT2AdminPassword");
				} else {
					Password = properties.getProperty("UAT2Password");
				}
				String UAT2_AuthEndpoint = properties.getProperty("UAT2AuthEndpoint");
				config = new ConnectorConfig();
				config.setUsername(Username);
				config.setPassword(Password);
				System.out.println("AuthEndPoint: " + UAT2_AuthEndpoint);
				config.setAuthEndpoint(UAT2_AuthEndpoint);
				connection = new PartnerConnection(config);
			} else if (environment.equals("FTE")) {
				if (dataTable.getData("General_Data", "TC_ID").contains("Admin")) {
					Password = properties.getProperty("FTEAdminPassword");
				} else {
					Password = properties.getProperty("FTE2Password");
				}
				String FTE_AuthEndpoint = properties.getProperty("FTEAuthEndpoint");
				config = new ConnectorConfig();
				config.setUsername(Username);
				config.setPassword(Password);
				System.out.println("AuthEndPoint: " + FTE_AuthEndpoint);
				config.setAuthEndpoint(FTE_AuthEndpoint);
				connection = new PartnerConnection(config);
			} else if (environment.equals("FTE2")) {
				if (dataTable.getData("General_Data", "TC_ID").contains("Admin")) {
					Password = properties.getProperty("FTE2AdminPassword");
				} else {
					Password = properties.getProperty("FTE2Password");
				}
				String FTE2_AuthEndpoint = properties.getProperty("FTE2AuthEndpoint");
				config = new ConnectorConfig();
				config.setUsername(Username);
				config.setPassword(Password);
				System.out.println("AuthEndPoint: " + FTE2_AuthEndpoint);
				config.setAuthEndpoint(FTE2_AuthEndpoint);
				connection = new PartnerConnection(config);
			}
		} catch (ConnectionException e) {
			e.printStackTrace();
		}
	}

	public void establishConnectionAdminLogin() {
		try {
			String environment = initializeEnvironment();
			System.out.println(environment);
			String Username = null, Password;
			if ((environment.equals("UAT")) || (environment.equals("UAT2")) || (environment.equals("FTE"))
					|| (environment.equals("FTE2"))) {
				Username = properties.getProperty("SystemAdminUsername") + "." + environment;
			}
			if (environment.equals("UAT")) {
				Password = properties.getProperty("UATAdminPassword");
				String UAT_AuthEndpoint = properties.getProperty("UATAuthEndpoint");
				config = new ConnectorConfig();
				config.setUsername(Username);
				config.setPassword(Password);
				System.out.println("AuthEndPoint: " + UAT_AuthEndpoint);
				config.setAuthEndpoint(UAT_AuthEndpoint);
				connection = new PartnerConnection(config);
				System.out.println(connection);
			} else if (environment.equals("UAT2")) {
				Password = properties.getProperty("UAT2AdminPassword");
				String UAT2_AuthEndpoint = properties.getProperty("UAT2AuthEndpoint");
				config = new ConnectorConfig();
				config.setUsername(Username);
				config.setPassword(Password);
				System.out.println("AuthEndPoint: " + UAT2_AuthEndpoint);
				config.setAuthEndpoint(UAT2_AuthEndpoint);
				connection = new PartnerConnection(config);
			} else if (environment.equals("FTE")) {
				Password = properties.getProperty("FTEAdminPassword");
				String FTE_AuthEndpoint = properties.getProperty("FTEAuthEndpoint");
				config = new ConnectorConfig();
				config.setUsername(Username);
				config.setPassword(Password);
				System.out.println("AuthEndPoint: " + FTE_AuthEndpoint);
				config.setAuthEndpoint(FTE_AuthEndpoint);
				connection = new PartnerConnection(config);
			} else if (environment.equals("FTE2")) {
				Password = properties.getProperty("FTE2AdminPassword");
				String FTE2_AuthEndpoint = properties.getProperty("FTE2AuthEndpoint");
				config = new ConnectorConfig();
				config.setUsername(Username);
				config.setPassword(Password);
				System.out.println("AuthEndPoint: " + FTE2_AuthEndpoint);
				config.setAuthEndpoint(FTE2_AuthEndpoint);
				connection = new PartnerConnection(config);
			}
		} catch (ConnectionException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Function for establishing the metadata connection 
	 * 
	 * @author Vishnuvardhan
	 *
	 */

	public void establishMetaDataConnection() {
		String apiVersion = "41.0";
		try {
			String environment = initializeEnvironment();
			if ((environment.equals("UAT")) || (environment.equals("UAT2")) || (environment.equals("FTE"))
					|| (environment.equals("FTE2"))) {
				String Username = properties.getProperty("SystemAdminUsername") + "." + environment;
				String Password = properties.getProperty(environment + "AdminPassword");
				String AuthEndpoint = properties.getProperty(environment + "AuthEndpoint");
				config = new ConnectorConfig();
				config.setUsername(Username);
				config.setPassword(Password);
				config.setAuthEndpoint(AuthEndpoint);
				connection = new PartnerConnection(config);
				LoginResult loginResult = connection.login(Username, Password);
				metadataConfig = new ConnectorConfig();
				metadataConfig.setServiceEndpoint(loginResult.getMetadataServerUrl());
				metadataConfig.setSessionId(connection.getSessionHeader().getSessionId());
				metadataConnection = com.sforce.soap.metadata.Connector.newConnection(metadataConfig);
				config.setSessionId(config.getSessionId());
				String soapEndpoint = config.getServiceEndpoint();
				String restEndpoint = soapEndpoint.substring(0, soapEndpoint.indexOf("Soap/")) + "async/" + apiVersion;
				config.setRestEndpoint(restEndpoint);
				config.setCompression(true);
				config.setTraceMessage(false);				
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}


	/**
	 * Function for establishing the metadata connection for picklist values
	 * 
	 * @author Vishnuvardhan
	 *
	 */

	public List<String> establishMetaDataConnection(String ObjectName, String RecordType, String PickList) {
		establishMetaDataConnection();
		List<String> pickListValues = getPickListValues(ObjectName + "." + RecordType, PickList);
		return pickListValues;
	}

	public List<String> getPickListValues(String recordTypeName, String ProvidedpickList) {
		List<String> PickListValues = null;
		try {
			PickListValues = new ArrayList<String>();
			ReadResult result = metadataConnection.readMetadata("RecordType", new String[] { recordTypeName });
			Metadata[] mds = result.getRecords();
			for (Metadata md : mds) {
				RecordType recordType = (RecordType) md;
				RecordTypePicklistValue[] picklistValues = recordType.getPicklistValues();
				for (RecordTypePicklistValue picklist : picklistValues) {
					System.out.println(picklist);
					if (picklist.getPicklist().equals(ProvidedpickList)) {
						PicklistValue[] values = picklist.getValues();
						for (PicklistValue value : values) {
							PickListValues.add(value.getFullName());
						}
						System.out.println(picklist.getValues());
					}
				}
			}
		} catch (ConnectionException e) {
			e.printStackTrace();
		}
		System.out.println("Pick List values are :::" + PickListValues);
		return PickListValues;
	}

	public boolean getStageValues(String ObjectName, String PickListValue, String ProvidedPickList) {
		establishMetaDataConnection(); boolean isStatus = false;
		DescribeSObjectResult describeSObjectResult = null;
		PicklistEntry[] picklistValues = null;
		try {
			describeSObjectResult = connection.describeSObject(ObjectName);
			Field[] fields = describeSObjectResult.getFields();
			for (int i = 0; i < fields.length; i++) {
				Field field = fields[i];
				if(field.getName().equals(ProvidedPickList)) {
					if (field.isUpdateable()) {
						if(field.getName().equals(ProvidedPickList)) {
							picklistValues = field.getPicklistValues();
							List<String> picklistItems = new ArrayList<String>();
							if (picklistValues != null && picklistValues[0] != null) {
								System.out.println("\t\tPicklist values = ");
								for (int k = 0; k < picklistValues.length; k++) {
									picklistItems.add(picklistValues[k].getLabel());										
									System.out.println("\t\t\tItem: " + picklistValues[k].getLabel());
								}
							}
						}
						System.out.println("Field name: " + field.getName());
						System.out.println("Field label: " + field.getLabel());            
					}
					break;
				}
			}
			for(int i=0; i < picklistValues.length; i++) {
				if(picklistValues[i].getValue().equals(PickListValue)) {
					isStatus = true;
					break;
				}
			}
		} catch (ConnectionException e1) {
			e1.printStackTrace();
		}
		return isStatus;
	}

	/**
	 * Function for establishing the metadata connection for page layouts 
	 * 
	 * @author Vishnuvardhan
	 *
	 */

	public List<String> establishMetaDataConnectionPageLayouts(String ObjectName, String PageLayouts) {
		List<String> UIFieldsOnPage = new ArrayList<String>();
		establishMetaDataConnection();
		List<String> pageLayOutsFields = getFieldNamesOnLayout(ObjectName + "-" + PageLayouts);
		Field[] pageLabels = null;
		try {
			pageLabels = EstablishConnection.connection.describeSObject(ObjectName).getFields();
			for(int i=0; i < pageLabels.length; i++) {
				for(int j=0; j < pageLayOutsFields.size(); j++) {
					if(pageLabels[i].getName().equals(pageLayOutsFields.get(j))) {
						if((pageLabels[i].getCalculatedFormula()==null)) {
							if((pageLabels[i].getLabel().equals("Created Date ID")) || (pageLabels[i].getLabel().equals("Created By ID")) || (pageLabels[i].getLabel().equals("Last Modified By ID"))
									|| (pageLabels[i].getLabel().equals("Last Manually Modified By")) || (pageLabels[i].getLabel().equals("Last Manually Modified Date"))) {
								System.out.println("Not adding the above fields as they are common for all the objects:::");
							} else {
								UIFieldsOnPage.add(pageLabels[i].getLabel());
								break;
							}							
						} 
					}
				}

			}
		} catch (ConnectionException e) {
			e.printStackTrace();
		}
		System.out.println("Opportunity Labels are:::" + UIFieldsOnPage);
		return UIFieldsOnPage;
	}


	public static List<String> getFieldNamesOnLayout(String layoutName) {
		List<String> LayOutValues = new ArrayList<String>();
		try {
			ReadResult result = metadataConnection.readMetadata("Layout", new String[] { layoutName });
			Metadata[] mds = result.getRecords();
			for (Metadata md : mds) {
				Layout layOut = (Layout) md;
				LayoutSection[] sections = layOut.getLayoutSections();
				for (LayoutSection section : sections) {
					LayoutColumn[] columns = section.getLayoutColumns();
					for (LayoutColumn column : columns) {
						LayoutItem[] items = column.getLayoutItems();
						for (LayoutItem item : items) {
							if (item.getField() != null) {
								LayOutValues.add(item.getField());
							}
						}
					}			
				}
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return LayOutValues;
	}

	/**
	 * Function for getting the page headers 
	 * 
	 * @author Vishnuvardhan
	 *
	 */
	public List<String> establishMetaDataConnectionPageHeaders(String ObjectName, String[] recordID) {
		establishMetaDataConnection();
		DescribeLayoutResult dlr = null;
		try {
			dlr = EstablishConnection.connection.describeLayout(ObjectName, null, recordID);
		} catch (ConnectionException e1) {
			e1.printStackTrace();
		}
		List<String> headersList = new ArrayList<String>();
		for (int i = 0; i < dlr.getLayouts().length; i++) {
			DescribeLayout layout = dlr.getLayouts()[i];
			DescribeLayoutSection[] editLayoutSectionList = layout.getEditLayoutSections();
			// Write the headings of the edit layout sections
			for (int x = 0; x < editLayoutSectionList.length; x++) {
						headersList.add(editLayoutSectionList[x].getHeading());
						System.out.println(x + ":::Has the heading layout section:::" + editLayoutSectionList[x].getHeading());
						report.updateTestLog(x + ":::Header Section", " has the heading layout section:::" + editLayoutSectionList[x].getHeading(), Status.PASS);				
			}
		}
		return headersList;
	}

	public static Map<String, String> LayoutMapping() {

		Map<String, String> map = new HashMap<String, String>();
		// Layout and RecordType
		map.put("Opportunity Layout - Agency Brokerage", "Agency_Brokerage");
		map.put("Asset Services - APAC", "APAC_Asset_Services");
		map.put("APAC Capital Markets %E2%80%93 Debt and Structured Finance",
				"APAC_Capital_Markets_Debt_and_Structured_Finance");
		map.put("APAC Debt %26 Structured Finance", "APAC_Debt_Structured_Finance");
		map.put("APAC Global Workplace Solutions", "APAC_Global_Workplace_Solutions");
		map.put("APAC Investors%2FBuyers", "APAC_Investors_Buyers");
		map.put("APAC Occupier - Opportunity Layout", "APAC_Occupier");
		map.put("APAC Project Management", "APAC_Project_Management");
		map.put("APAC Property Purchase - Buy Side", "APAC_Property_Purchase_Buy_Side");
		map.put("APAC Property Sales", "APAC_Property_Sales");
		map.put("Asset Services - Global View", "Asset_Services");
		map.put("Opportunity Layout - Capital Markets Debt %26 Structured Finance",
				"Capital_Markets_Debt_Structured_Finance");
		map.put("Opportunity Layout - Capital Markets Property Sales", "Capital_Markets_Property_Sales");
		map.put("EMEA A%26T Investor Layout", "EMEA_A_T_Investor");
		map.put("EMEA A%26T Occupier Layout", "EMEA_A_T_Occupier");
		map.put("EMEA Asset Services Page Layout", "EMEA_Asset_Services");
		map.put("EMEA BC%26P Page Layout", "BC_P");
		map.put("EMEA Capital Markets Capital Advisors Page Layout", "EMEA_Capital_Markets_Capital_Advisors");
		map.put("EMEA Capital Markets Investment Properties Page Layout", "EMEA_Capital_Markets_Investment_Properties");
		map.put("EMEA Development Page Layout", "EMEA_Development");
		map.put("EMEA Valuations Page Layout", "EMEA_Valuations");
		map.put("France Consulting %26 Service Opportunity Layout", "France_Consulting_Service");
		map.put("France Investor Relations Opportunity Layout", "France_Investor_Relations");
		map.put("France Transaction Demand Agency Opportunity Layout", "France_Transaction_Demand_Agency");
		map.put("France Transaction Offer Agency Opportunity Layout", "France_Transaction_Offer_Agency");
		map.put("Asset Services - GIA", "GIA");
		map.put("Opportunity Layout - Occupier Brokerage", "Occupier_Brokerage");
		map.put("Valuations %26 Advisory Services", "Valuations_Advisory_Services");
		return map;
	}

	/**
	 * Function for retrieving the User Configuration
	 * 
	 * @author Vishnuvardhan
	 *
	 */

	public boolean retrieveUserConfiguration() {
		boolean success = false;
		try {
			establishConnection();
			GetUserInfoResult userInfo = EstablishConnection.connection.getUserInfo();
			System.out.println("UserID: " + userInfo.getUserId());
			System.out.println("User Full Name: " + userInfo.getUserFullName());
			System.out.println("User Email: " + userInfo.getUserEmail());
			System.out.println("SessionID: " + EstablishConnection.config.getSessionId());
			System.out.println("Auth End Point: " + EstablishConnection.config.getAuthEndpoint());
			System.out.println("Service End Point: " + EstablishConnection.config.getServiceEndpoint());
			report.updateTestLog("Verify Login", "User ID used for login using API: " + userInfo.getUserId(),
					Status.PASS);
			report.updateTestLog("Verify Login", "User Full Name: " + userInfo.getUserFullName(), Status.PASS);
			report.updateTestLog("Verify Login", "User Email: " + userInfo.getUserEmail(), Status.PASS);
			report.updateTestLog("Verify Login", "SessionID: " + EstablishConnection.config.getSessionId(),
					Status.PASS);
			report.updateTestLog("Verify Login", "Auth End Point: " + EstablishConnection.config.getAuthEndpoint(),
					Status.PASS);
			report.updateTestLog("Verify Login",
					"Service End Point: " + EstablishConnection.config.getServiceEndpoint(), Status.PASS);
			success = true;
		} catch (ConnectionException ce) {
			ce.printStackTrace();
			System.out.println(ce.getMessage());
		}
		return success;
	}

	/**
	 * Function for the saving the results
	 * 
	 * @author Vishnuvardhan
	 *
	 */

	public boolean saveResults(SaveResult[] Results) {
		SaveResult[] results = Results;
		System.out.println("Results:::" + results);
		for (int j = 0; j < results.length; j++) {
			if (results[j].isSuccess()) {
				result = results[j].getId();
				System.out.println("Save Results:::" + result);
				report.updateTestLog("Verify Create/ Update Account", "Result :: " + result, Status.PASS);
				String query = null;
				if (result.contains("001")) {
					query = "Select Name from Account where Id = " + "'" + result + "'";
				} else if (result.contains("003")) {
					query = "Select Name from Contact where Id = " + "'" + result + "'";
				} else if (result.contains("006")) {
					query = "Select Name from Opportunity where Id = " + "'" + result + "'";
				} else if (result.startsWith("a0")) {
					query = "Select Name from Property__c where Id = " + "'" + result + "'";
				} else if (result.startsWith("002")) {
					query = "Select Title from Note where Id = " + "'" + result + "'";
				} else if (result.startsWith("00P")) {
					query = "Select Title from Attachment where Id = " + "'" + result + "'";
				} else if (result.startsWith("00Q")) {
					query = "Select Id from Lead where Id = " + "'" + result + "'";
				} else if (result.startsWith("005")) {
					query = "Select Id from User where Id = " + "'" + result + "'";
				} else if (result.startsWith("00U")) {
					query = "Select Id from Event where Id = " + "'" + result + "'";
				}
				SearchTextSOQL searchTextSOQL = new SearchTextSOQL(scriptHelper);
				String name = searchTextSOQL.fetchRecordFieldValue("Name", query);
				report.updateTestLog("Verify Create/ Update Account/ Contact/ Opportuntiy",
						"Name of the Account/ Contact/ Opportunity :: " + name, Status.PASS);
				status = true;
			} else {
				for (int i = 0; i < results[j].getErrors().length; i++) {
					com.sforce.soap.partner.Error err = results[j].getErrors()[i];
					report.updateTestLog("Verify Create/ Update Account, Contact, Lead, Opportunities",
							"Errors were found on item:::" + j, Status.FAIL);
					report.updateTestLog("Verify Create/ Update Account",
							"Errors code:::" + err.getStatusCode().toString(), Status.FAIL);
					report.updateTestLog("Verify Create/ Update Account, Contact, Lead, Opportunities",
							"Errors message:::" + err.getMessage(), Status.FAIL);
					System.out.println("Errors were found on item " + j);
					System.out.println("Error code::" + err.getStatusCode().toString());
					System.out.println("Error message::" + err.getMessage());
					status = false;
				}
			}
		}
		return status;
	}

	/**
	 * Function for saving the lead conversion results
	 * 
	 * @author Vishnuvardhan
	 *
	 */

	public String leadConvertResults(LeadConvertResult[] Results) {
		LeadConvertResult[] results = Results;
		String sAccountID = null, sContactID = null, sOpportunityID = null, sLeadID = null;
		String sIDs = null;
		System.out.println("Results:::" + results);
		for (int j = 0; j < results.length; j++) {
			if (results[j].isSuccess()) {
				sAccountID = results[j].getAccountId();
				sContactID = results[j].getContactId();
				sOpportunityID = results[j].getOpportunityId();
				sLeadID = results[j].getLeadId();
				sIDs = sAccountID + "_" + sContactID + "_" + sOpportunityID + "_" + sLeadID;
				System.out.println("Account ID :::" + sAccountID);
				System.out.println("Contact ID:::" + sContactID);
				System.out.println("Opportunity ID:::" + sOpportunityID);
				System.out.println("Lead ID:::" + sLeadID);
			} else {
				for (int i = 0; i < results[j].getErrors().length; i++) {
					com.sforce.soap.partner.Error err = results[j].getErrors()[i];
					report.updateTestLog("Verify Create/ Update Account, Contact, Lead, Opportunities",
							"Errors were found on item:::" + j, Status.FAIL);
					report.updateTestLog("Verify Create/ Update Account",
							"Errors code:::" + err.getStatusCode().toString(), Status.FAIL);
					report.updateTestLog("Verify Create/ Update Account, Contact, Lead, Opportunities",
							"Errors message:::" + err.getMessage(), Status.FAIL);
					System.out.println("Errors were found on item " + j);
					System.out.println("Error code::" + err.getStatusCode().toString());
					System.out.println("Error message::" + err.getMessage());
					status = false;
				}
			}
		}
		return sIDs;
	}

	/**
	 * Function for the getting the Id from results array
	 * 
	 * @author Vishnuvardhan
	 *
	 */
	public String saveResultsId(SaveResult[] Results) {
		SaveResult[] results = Results;
		for (int j = 0; j < results.length; j++) {
			if (results[j].isSuccess()) {
				result = results[j].getId();
				System.out.println("Save Results:::" + result);
				report.updateTestLog("Verify Create/ Update Account", "Result :: " + result, Status.PASS);
			} else {
				for (int i = 0; i < results[j].getErrors().length; i++) {
					com.sforce.soap.partner.Error err = results[j].getErrors()[i];
					report.updateTestLog("Verify Results",
							"Errors code:::" + err.getStatusCode().toString(), Status.FAIL);
					report.updateTestLog("Verify Results",
							"Errors message:::" + err.getMessage(), Status.FAIL);
					System.out.println("Errors were found on item " + j);
					System.out.println("Error code::" + err.getStatusCode().toString());
					System.out.println("Error message::" + err.getMessage());
					result = err.getMessage();
				}
			}
		}
		return result;
	}

	/**
	 * Function for deleting the results
	 * 
	 * @author Vishnuvardhan
	 *
	 */

	public boolean deleteResults(DeleteResult[] DeleteResults) {
		DeleteResult[] deleteResults = DeleteResults;
		System.out.println("Results:::" + deleteResults);
		for (int j = 0; j < deleteResults.length; j++) {
			if (deleteResults[j].isSuccess()) {
				deleteResults[j].getId();
				System.out.println("Delete Results:::" + deleteResults[j].getId());
				report.updateTestLog("Verify Delete Account, Contact, Lead, Opportunities",
						"Result :: " + deleteResults[j].getId(), Status.PASS);
				status = true;
			} else {
				errors = deleteResults[j].getErrors();
				for (int i = 0; i < errors.length; i++) {
					report.updateTestLog("Verify Delete Account, Contact, Lead, Opportunities",
							"Errors message:::" + errors[i].getMessage(), Status.FAIL);
					System.out.println("Error message::" + errors[i].getMessage());
					status = false;
				}
			}
		}
		return status;
	}

}