package supportlibraries.api;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.StringReader;
import java.net.URI;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;

import javax.json.Json;
import javax.json.JsonObject;
import javax.json.JsonValue.ValueType;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriBuilder;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.config.ClientConfig;
import com.sun.jersey.api.client.config.DefaultClientConfig;
import com.sun.jersey.api.client.filter.ClientFilter;
import com.sun.jersey.api.client.filter.HTTPBasicAuthFilter;

import supportlibraries.Utility_Functions;


public class WikiUpdater{

	private String wikiSpace;

	public WikiUpdater(){
		
	}
	
	private String inMessage;
	private String URL;
	private ClientResponse response;
	private String wikiPageTitle;
	private String wikiPageID;
	public String getWikiPageTitle() {
		return wikiPageTitle;
	}

	public void setWikiPageTitle(String wikiPageTitle) {
		this.wikiPageTitle = wikiPageTitle;
	}
//	private 
	public String getURL() {
		return URL;
	}

	public void setURL(String uRL) {
		URL = uRL;
	}

	public String getInMessage() {
		return inMessage;
	}

	//get smoke test status report
	public void setInMessage(String inMessage) {
		this.inMessage = inMessage;
	}
	
	public ClientResponse getResponse() {
		return response;
	}

	public void setResponse(ClientResponse response) {
		this.response = response;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		

		
		WikiUpdater wiki = new WikiUpdater();
		wiki.wikiPageTitle="Daily Production Stand-up Report - " + wiki.getTodaysDate();
		wiki.wikiSpace= "ITOPS";
		wiki.inMessage = "(100%) Automated Smoke Test Completed on ( prod ) 20160802-050216 -  (Executed: 32 Pass : 32 Fail : 0)";
//		wiki.wikiPageTitle = "Wiki API Test Page";
//		wiki.wikiSpace = "QA";
		wiki.URL = "https://focustech.atlassian.net/wiki/rest/api/content";
		
		JsonObject json  = Json.createReader(new StringReader(wiki.getCurrentPageId())).readObject().getJsonArray("results").getJsonObject(0);
		wiki.wikiPageID = wiki.getJsonValue(json, "id");
//		System.out.println(wiki.wikiPageID);
//		target = wiki.getCurrentVersion();
		json  = Json.createReader(new StringReader(wiki.getCurrentVersion())).readObject();
		int version = Integer.parseInt(wiki.getJsonValue(json, "version.number"));
//		System.out.println(version);
		json = Json.createReader(new StringReader(wiki.getBody())).readObject();
		String body = wiki.getJsonValue(json, "body.storage.value").replace("\"", "\\\"");
		System.out.println(body);
		body = wiki.getUpdatedBody(body);
		System.out.println(body);
		
		System.out.println(wiki.putSmokeResults(body, version));
	}

	private String getTodaysDate(){
		DateFormat dateFormat = new SimpleDateFormat("MM/dd/yy");
		Date date = new Date();
		return dateFormat.format(date);
	}
	
	public void updateWikiPage(String inMessage){
		this.inMessage = inMessage;
//		this.wikiPageTitle = "Wiki API Test Page";
//		this.wikiSpace = "QA";
		this.URL = "https://focustech.atlassian.net/wiki/rest/api/content";
		this.wikiPageTitle="Daily Production Stand-up Report - " + getTodaysDate();
		this.wikiSpace= "ITOPS";
		//get the page ID for the Todays wiki dashboard page
		JsonObject json  = Json.createReader(new StringReader(this.getCurrentPageId())).readObject().getJsonArray("results").getJsonObject(0);
		this.wikiPageID = this.getJsonValue(json, "id");
		//Get current version number of the document/page in WIKI
		json  = Json.createReader(new StringReader(this.getCurrentVersion())).readObject();
		int version = Integer.parseInt(this.getJsonValue(json, "version.number"));
		//get the Current body of WIKI page
		json = Json.createReader(new StringReader(this.getBody())).readObject();
		String body = this.getJsonValue(json, "body.storage.value").replace("\"", "\\\"");
		//Generate the Body with automation results
		body = this.getUpdatedBody(body);
		//Put the results back to WIKI page
		this.putSmokeResults(body, version);
		
	}
	
	private ClientFilter basicAuthentication() {
		Properties config = new Properties();
		config = Utility_Functions.setCraftProperty();
//			config.load(new FileInputStream("Global Settings.properties"));
		String user = config.getProperty("mail.smtp.user").substring(0,config.getProperty("mail.smtp.user").indexOf("@"));
		String password = config.getProperty("wiki.password");
		HTTPBasicAuthFilter filter = new HTTPBasicAuthFilter(user, password);
		return filter;
	}
	
	private WebResource getWebResource(){
		
		URI baseUri = UriBuilder.fromPath(URL).build();
		ClientConfig cfg = new DefaultClientConfig();
		Client clientC = Client.create(cfg);
		clientC.addFilter(basicAuthentication());
		WebResource resource = clientC.resource(baseUri);
		return resource;
		
	}
	//get current page id from parent page
	private String getCurrentPageId(){		
		ClientResponse response = this.getWebResource().queryParam("title", this.wikiPageTitle)
				.queryParam("space", this.wikiSpace).accept(MediaType.APPLICATION_JSON)
				.type(MediaType.APPLICATION_JSON).get(ClientResponse.class);
		return response.getEntity(String.class);
	}
	
	//get Current version and iterate
	private String getCurrentVersion(){
		ClientResponse response = this.getWebResource().path(this.wikiPageID).queryParam("expand", "version")
				.queryParam("space", this.wikiSpace).accept(MediaType.APPLICATION_JSON)
				.type(MediaType.APPLICATION_JSON).get(ClientResponse.class);
		return response.getEntity(String.class);
	}

	
	//get current body
	private String getBody(){
		ClientResponse response = this.getWebResource().path(this.wikiPageID).queryParam("expand", "body.storage")
				.queryParam("space", this.wikiSpace).accept(MediaType.APPLICATION_JSON)
				.type(MediaType.APPLICATION_JSON).get(ClientResponse.class);
		return response.getEntity(String.class);
	}
	//update body and add the smoke results
	private String getUpdatedBody(String body){
		String replaceTest = "<strong>Smoke Test Results:</strong><h3>"+ inMessage +"</h3>";
		body = body.replace("<strong>Smoke Test Results:</strong>", replaceTest);
		return body;
		
	}
	
	private String putSmokeResults(String body, int version){
		String input = "{\"id\":\""+this.wikiPageID+"\",\"type\":\"page\",\"title\":\""+this.wikiPageTitle+ "\",\"space\":{\"key\":\""+this.wikiSpace+"\"},\"body\":{\"storage\":{\"value\":\"" + body +"\",\"representation\":\"storage\"}},\"version\":{\"number\":"+ (version + 1)+ "}}";
		ClientResponse response = this.getWebResource().path(this.wikiPageID).queryParam("expand", "body.storage")
				.queryParam("space", this.wikiSpace).accept(MediaType.APPLICATION_JSON)
				.type(MediaType.APPLICATION_JSON).entity(input, MediaType.APPLICATION_JSON).put(ClientResponse.class);
		return response.getEntity(String.class);
	}

	
	private String getJsonValue(JsonObject jsonResponse, String jsonLocator){
		String[] keyPaths = jsonLocator.split("\\.");
		String jsonString = "";
		for (String keypath : keyPaths) {
			if(jsonResponse.containsKey(keypath)){
			if (jsonResponse.get(keypath).getValueType().equals(ValueType.OBJECT))
				jsonResponse = jsonResponse.getJsonObject(keypath);
			}
		}
		if (jsonResponse.containsKey(keyPaths[keyPaths.length - 1])) {
			if(jsonResponse.get(keyPaths[keyPaths.length - 1]).getValueType().equals(ValueType.STRING)){
				jsonString = jsonResponse.getString(keyPaths[keyPaths.length - 1]);
			}else{
			jsonString = String.valueOf(jsonResponse.get(keyPaths[keyPaths.length - 1]));//getSingleJsonvalue(jsonResponse, keyPaths[keyPaths.length - 1]);
			}
		}
		return jsonString;
	}
}
