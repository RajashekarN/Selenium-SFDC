package supportLibraries;

import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import org.json.JSONObject;

public class TestDefectFiling {
	public static void main(String[] args) throws Exception {
		JSONObject json = new JSONObject();
		json.put("action", "create");
		json.put("title", "Test Defect loggging from Java" ); 
		json.put("repro_steps", "Test Steps");
		json.put("project_name_in_TFS", "SalesForce - Global Enterprise");
		json.put("SystemInfo", "UAT2");
		json.put("priority", "2");
		json.put("severity", "3 - Medium");
		json.put("worktype", "Maintenance/Support");
		json.put("history", "Sample Text"); 
		URL url = new URL("http://10.71.77.70:8000");
		HttpURLConnection httpcon = null;
		httpcon = (HttpURLConnection) url.openConnection();
		httpcon.setDoOutput(true);
		httpcon.setDoInput(true);
		httpcon.setRequestMethod("POST");
		httpcon.setRequestProperty("Accept", "application/json");
		httpcon.connect();
		httpcon.setConnectTimeout(20);
		Utility_Functions.timeWait(25);
		OutputStreamWriter output = new OutputStreamWriter(httpcon.getOutputStream());
		output.write(json.toString());
		output.flush();
		System.out.println(httpcon.getRequestMethod());
		System.out.println(httpcon.getResponseMessage());
	}		
}
