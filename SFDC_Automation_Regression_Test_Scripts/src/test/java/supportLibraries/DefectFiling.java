package supportLibraries;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Properties;
import org.json.JSONException;
import org.json.JSONObject;
import com.cognizant.framework.Settings;

public class DefectFiling {
	private static Properties properties = Settings.getInstance();
	static boolean sResponseMessage;
	
	public static String environment = System.getProperty("RunEnvironment");
	public static String initializeEnvironment() {
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
	
	public static boolean fileDefect(JSONObject json, String text) {
		initializeEnvironment();
		String textReceived = text;
		try {			
			if(textReceived.equalsIgnoreCase("CreateDefect")) {
				URL url = new URL("http://10.71.77.70:8000");
				HttpURLConnection httpcon = (HttpURLConnection) url.openConnection();
				httpcon.setDoOutput(true);
				httpcon.setDoInput(true);
				httpcon.setRequestMethod("POST");
				httpcon.setRequestProperty("Accept", "application/json");
				httpcon.connect();
				httpcon.setConnectTimeout(20);
				OutputStreamWriter output = new OutputStreamWriter(httpcon.getOutputStream());
				output.write(json.toString());
				output.flush();
				System.out.println(httpcon.getRequestMethod());
				System.out.println(httpcon.getResponseMessage());
				httpcon.disconnect();

				/*BufferedReader in = new BufferedReader(new InputStreamReader(httpcon.getInputStream()));
				String inputLine;
				StringBuffer response = new StringBuffer();
				while((inputLine=in.readLine()) !=null) {
					response.append(inputLine);
				}
				in.close();
				httpcon.disconnect();
				System.out.println(response.toString());
				String response_string = response.toString();
				JSONObject jsonObj = new JSONObject(response_string);
				System.out.println("Defect ID = "+jsonObj.get("id"));	*/
				return true;
			} else if(textReceived.equalsIgnoreCase("SearchDefect")) {
				URL url = new URL("http://10.71.77.70:8000");
				HttpURLConnection httpcon = (HttpURLConnection) url.openConnection();
				httpcon.setDoOutput(true);
				httpcon.setDoInput(true);
				httpcon.setRequestMethod("POST");
				httpcon.setRequestProperty("Accept", "application/json");
				httpcon.connect();
				httpcon.setConnectTimeout(20);
				OutputStreamWriter output = new OutputStreamWriter(httpcon.getOutputStream());
				output.write(json.toString());
				output.flush();
				System.out.println(httpcon.getRequestMethod());
				System.out.println(httpcon.getResponseMessage());
				httpcon.disconnect();
				BufferedReader in = new BufferedReader(new InputStreamReader(httpcon.getInputStream()));
				String inputLine;
				StringBuffer response = new StringBuffer();
				while((inputLine=in.readLine()) !=null) {
					response.append(inputLine);
				}
				in.close();
				System.out.println(response.toString());
				String response_string = response.toString();
				JSONObject jsonObj = new JSONObject(response_string);
				System.out.println("Existing defect = "+jsonObj.get("workItems"));				
				if(jsonObj.get("workItems").toString().contains("id")) {
					return true;				
				}
				else {
					return false;
				}				
			}	
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
	
	public static boolean createDefect(String testTitle, String testRetroSteps) {
		JSONObject json = new JSONObject();
		String sTestTitle = testTitle;
		String sTestRetroSteps = testRetroSteps;
		try {
			json.put("action", "create");
			json.put("title", sTestTitle ); 
			json.put("repro_steps", sTestRetroSteps);
			json.put("project_name_in_TFS", properties.getProperty("ProjectNameinTFS"));
			json.put("SystemInfo", environment);
			json.put("priority", properties.getProperty("Priority"));
			json.put("severity", properties.getProperty("Severity"));
			json.put("worktype", properties.getProperty("WorkType"));
			json.put("history", properties.getProperty("History"));
		} catch (JSONException e) {
			e.printStackTrace();
		}		
		return sResponseMessage = fileDefect(json, "CreateDefect");
	}
	
/*	public void updateDefect() {
		json = new JSONObject();
		json.put("action", "update");
		json.put("id", ); 
		json.put("attribute_to_update", );
		json.put("title", );
		json.put("repro_steps", );
		json.put("defectStatus_to_update", ); 
		fileDefect();
	}*/
	
/*	public static boolean searchDefect(String testDescritpion) {
		JSONObject json = new JSONObject();
		String sTestDesctiption= testDescritpion;
		try {
			json.put("action", "search");
			json.put("defect_title_to_search", sTestDesctiption); 
			json.put("project_name_in_TFS", properties.getProperty("ProjectNameinTFS"));
		} catch (JSONException e) {
			e.printStackTrace();
		}
		return sResponseMessage = fileDefect(json, "SearchDefect");
	}*/
	
}
