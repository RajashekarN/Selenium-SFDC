package supportlibraries;

import com.cognizant.framework.selenium.Browser;

/**
 * Class for getting the environment parameters
 * @author Vishnuvardhan
 *
 */

public class EnvParameters {

	private  String env;
	private  String client;
	private String URL;
	private String loginId;
	private String password;
	private String DBUrl;
	private String DBUserName;
	private String DBPassword;
	private String runMode;
	private Browser browser;
//	private String STRING_NULL_SPACE = " ";
//	private static final EnvParameters envParameters = new EnvParameters(String en, String cl);
	
	public  EnvParameters(){
		this.env = getEnv();
		this.client = getClient();
		this.DBUrl = getDBUrl();
		this.DBPassword = getDBPassword();
		this.DBUserName = getDBUserName();
		this.runMode = getRunMode();
		this.browser = getBrowser();
		
	}
	
	public String getRunMode() {
		return runMode;
	}

	public void setRunMode(String runMode) {
		if(runMode == null || runMode.equals("")){
			runMode = "Sanity";
		}
		this.runMode = runMode;
	}

	public String getEnv() {
		return env;
	}

	public void setEnv(String env) {
		this.env = env;
	}

	public String getClient() {
		return client;
	}

	public void setClient(String client) {
		this.client = client;
	}


	public String getDBUrl() {
//		DBUrl = getDBParameter("DBUrl");
		return DBUrl;
	}
	public void setDBUrl(String dBUrl) {
		DBUrl = dBUrl;
	}

	public void setDBUserName(String dBUserName) {
		DBUserName = dBUserName;
	}

	public void setDBPassword(String dBPassword) {
		DBPassword = dBPassword;
	}

	public String getDBUserName() {
//		DBUserName = getDBParameter("DBUserName");
		return DBUserName;
	}
	public String getDBPassword() {
//		DBPassword = getDBParameter("DBPassword");
		return DBPassword;
	}

	public String getURL() {
		return URL;
	}

	public void setURL(String uRL) {
		URL = uRL;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getLoginId() {
		return loginId;
	}

	public void setLoginId(String userName) {
		this.loginId = userName;
	}

	public Browser getBrowser() {
		return browser;
	}

	public void setBrowser(Browser browser) {
		this.browser = browser;
	}


//	public static EnvParameters getInstance() {
//		envParameters.setEnv("alph");
//		envParameters.setClient("SFI");
//		return envParameters;
//	}
}
