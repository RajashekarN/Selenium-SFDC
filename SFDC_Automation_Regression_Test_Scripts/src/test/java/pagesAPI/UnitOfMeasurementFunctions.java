package pagesAPI;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.openqa.selenium.support.PageFactory;

import com.cognizant.Craft.ReusableLibrary;
import com.cognizant.Craft.ScriptHelper;
import com.cognizant.framework.Status;
import com.sforce.soap.partner.SaveResult;
import com.sforce.soap.partner.sobject.SObject;

import supportLibraries.Utility_Functions;

public class UnitOfMeasurementFunctions extends ReusableLibrary{

	public UnitOfMeasurementFunctions(ScriptHelper scriptHelper) {
		super(scriptHelper);
		PageFactory.initElements(driver.getWebDriver(), this);
	}
	
	static SaveResult[] results;
	static boolean status = false;
	EstablishConnection establishConnection = new EstablishConnection(scriptHelper);

	public Map<String, String> unitOfMeasurementForCountries() {
		Map<String, String> uomForCountries = new HashMap<>();
		
		uomForCountries.put("Andorra", "Square Metres");	uomForCountries.put("United Arab Emirates", "Square Metres");	uomForCountries.put("Afghanistan", "Square Metres");	uomForCountries.put("Antigua and Barbuda", "Square Metres");	
		uomForCountries.put("Anguilla", "Square Feet");	uomForCountries.put("Albania", "Square Metres");	uomForCountries.put("Armenia", "Square Metres");	uomForCountries.put("Angola", "Square Metres");
		uomForCountries.put("Antarctica", "Square Metres");	uomForCountries.put("Argentina", "Square Feet");	uomForCountries.put("Austria", "Square Metres");	uomForCountries.put("Australia", "Square Metres");	
		uomForCountries.put("Aruba", "Square Feet");	uomForCountries.put("Aland Islands", "Square Metres");	uomForCountries.put("Azerbaijan", "Square Metres");	uomForCountries.put("Bosnia and Herzegovina", "Square Metres");
		uomForCountries.put("Barbados", "Square Feet");	uomForCountries.put("Bangladesh", "Square Feet");	uomForCountries.put("Belgium", "Square Metres");	uomForCountries.put("Burkina Faso", "Square Metres");	
		uomForCountries.put("Bulgaria", "Square Metres");	uomForCountries.put("Bahrain", "Square Metres");	uomForCountries.put("Burundi", "Square Metres");	uomForCountries.put("Benin", "Square Metres");
		uomForCountries.put("Saint Barthélemy", "Square Feet");	uomForCountries.put("Bermuda", "Square Feet");	uomForCountries.put("Brunei Darussalam", "Square Metres");	uomForCountries.put("Bolivia, Plurinational State of", "Square Feet");	
		uomForCountries.put("Bonaire, Sint Eustatius and Saba", "Square Feet");	uomForCountries.put("Brazil", "Square Feet");	uomForCountries.put("Bahamas", "Square Feet");	uomForCountries.put("Bhutan", "Square Feet");
		uomForCountries.put("Bouvet Island", "Square Feet");	uomForCountries.put("Botswana", "	Square Metres");	uomForCountries.put("Belarus", "Square Metres");	uomForCountries.put("Belize", "Square Feet");	
		uomForCountries.put("Canada", "Square Feet");	uomForCountries.put("Cocos (Keeling) Islands", "Square Feet");	uomForCountries.put("Congo, the Democratic Republic of the", "Square Metres");	uomForCountries.put("Central African Republic", "Square Metres");
		uomForCountries.put("Congo", "Square Metres");	uomForCountries.put("Switzerland", "Square Metres");	uomForCountries.put("Cote d'Ivoire", "Square Metres");	uomForCountries.put("Cook Islands", "Square Feet");	
		uomForCountries.put("Chile", "Square Feet");	uomForCountries.put("Cameroon", "Square Metres");	uomForCountries.put("China", "Square Metres");	uomForCountries.put("Colombia", "Square Feet");
		uomForCountries.put("Curacao", "Square Feet");	uomForCountries.put("Costa Rica", "Square Feet");	uomForCountries.put("Christmas Island", "Square Feet");	uomForCountries.put("Cyprus", "Square Metres");	
		uomForCountries.put("Czech Republic", "Square Metres");	uomForCountries.put("Germany", "Square Metres");	uomForCountries.put("Djibouti", "Square Metres");	uomForCountries.put("Denmark", "Square Metres");
		uomForCountries.put("Dominica", "Square Feet");	uomForCountries.put("Dominican Republic", "Square Feet");	uomForCountries.put("Algeria", "Square Metres");	uomForCountries.put("Ecuador", "Square Feet");	
		uomForCountries.put("Estonia", "Square Metres");	uomForCountries.put("Egypt", "Square Metres");	uomForCountries.put("Western Sahara", "Square Metres");	uomForCountries.put("Eritrea", "Square Metres");
		uomForCountries.put("Spain", "Square Metres");	uomForCountries.put("Ethiopia", "Square Metres");	uomForCountries.put("Finland", "Square Metres");	uomForCountries.put("Fiji", "Square Feet");	
		uomForCountries.put("Falkland Islands (Malvinas)", "Square Feet");	uomForCountries.put("Cuba", "Square Feet");	uomForCountries.put("Faroe Islands", "Square Metres");	uomForCountries.put("France", "Square Metres");
		uomForCountries.put("Gabon", "Square Metres");	uomForCountries.put("United Kingdom", "Square Feet");	uomForCountries.put("Cape Verde", "Square Feet");	uomForCountries.put("Grenada", "Square Feet");	
		uomForCountries.put("Georgia", "Square Metres");	uomForCountries.put("French Guiana", "Square Feet");	uomForCountries.put("Guernsey", "Square Metres");	uomForCountries.put("Ghana", "Square Metres");
		uomForCountries.put("Gibraltar", "Square Metres");	uomForCountries.put("Greenland", "Square Feet");	uomForCountries.put("Gambia", "Square Metres");	uomForCountries.put("Guinea", "Square Feet");	
		uomForCountries.put("Guadeloupe", "Square Feet");	uomForCountries.put("Equatorial Guinea", "Square Feet");	uomForCountries.put("Greece", "Square Metres");	uomForCountries.put("South Georgia and the South Sandwich Islands", "Square Feet");
		uomForCountries.put("Guatemala", "Square Feet");	uomForCountries.put("Guinea-Bissau", "Square Feet");	uomForCountries.put("Guyana", "	Square Feet");	uomForCountries.put("Heard Island and McDonald Islands", "Square Feet");	
		uomForCountries.put("Honduras", "Square Feet");	uomForCountries.put("Croatia", "Square Metres");	uomForCountries.put("Haiti", "Square Feet");	uomForCountries.put("Hungary", "Square Metres");
		uomForCountries.put("Indonesia", "Square Feet");	uomForCountries.put("Ireland", "Square Metres");	uomForCountries.put("Israel", "Square Metres");	uomForCountries.put("Isle of Man", "Square Metres");	
		uomForCountries.put("India", "Square Feet");	uomForCountries.put("British Indian Ocean Territory", "Square Feet");	uomForCountries.put("Iraq", "Square Metres");	uomForCountries.put("Iran, Islamic Republic of", "Square Metres");
		uomForCountries.put("Iceland", "Square Metres");	uomForCountries.put("Italy", "Square Metres");	uomForCountries.put("Jersey", "Square Metres");	uomForCountries.put("Jamaica", "Square Feet");	
		uomForCountries.put("Jordan", "Square Metres");	uomForCountries.put("Japan", "Tsubo");	uomForCountries.put("Kenya", "Square Metres");	uomForCountries.put("Kyrgyzstan", "Square Metres");
		uomForCountries.put("Cambodia", "Square Feet");	uomForCountries.put("Kiribati", "Square Feet");	uomForCountries.put("Comoros", "Square Metres");	uomForCountries.put("Saint Kitts and Nevis", "Square Feet");	
		uomForCountries.put("Korea, Democratic People's Republic of", "Pyeong");	uomForCountries.put("Korea, Republic of", "Pyeong");	uomForCountries.put("Kuwait", "Square Metres");	uomForCountries.put("Cayman Islands", "Square Feet");
		uomForCountries.put("Kazakhstan", "Square Metres");	uomForCountries.put("Lao People's Democratic Republic", "Square Feet");	uomForCountries.put("Lebanon", "Square Metres");	uomForCountries.put("Saint Lucia", "Square Feet");	
		uomForCountries.put("Liechtenstein", "Square Metres");	uomForCountries.put("Sri Lanka", "Square Feet");	uomForCountries.put("Liberia", "Square Metres");	uomForCountries.put("Lesotho", "Square Metres");
		uomForCountries.put("Lithuania", "Square Metres");	uomForCountries.put("Luxembourg", "Square Metres");	uomForCountries.put("Latvia", "Square Metres");	uomForCountries.put("Libyan Arab Jamahiriya", "Square Metres");	
		uomForCountries.put("Morocco", "Square Metres");	uomForCountries.put("Monaco", "Square Metres");	uomForCountries.put("Moldova, Republic of", "Square Metres");	uomForCountries.put("Montenegro", "Square Metres");
		uomForCountries.put("Saint Martin (French part)", "Square Feet");	uomForCountries.put("Madagascar", "Square Metres");	uomForCountries.put("Macedonia, the former Yugoslav Republic of", "Square Metres");	uomForCountries.put("Mali", "Square Metres");	
		uomForCountries.put("Myanmar", "Square Feet");	uomForCountries.put("Mongolia", "Square Feet");	uomForCountries.put("Macau", "Square Feet");	uomForCountries.put("Martinique", "Square Feet");
		uomForCountries.put("Mauritania", "Square Metres");	uomForCountries.put("Montserrat", "Square Feet");	uomForCountries.put("Malta", "Square Metres");	uomForCountries.put("Mauritius", "Square Metres");	
		uomForCountries.put("Maldives", "Square Feet");	uomForCountries.put("Malawi", "Square Metres");	uomForCountries.put("Mexico", "Square Feet");	uomForCountries.put("Malaysia", "Square Feet");
		uomForCountries.put("Mozambique", "Square Metres");	uomForCountries.put("Namibia", "Square Metres");	uomForCountries.put("New Caledonia", "Square Feet");	uomForCountries.put("Niger", "Square Metres");	
		uomForCountries.put("Norfolk Island", "Square Feet");	uomForCountries.put("Nigeria", "Square Metres");	uomForCountries.put("Nicaragua", "Square Feet");	uomForCountries.put("Netherlands", "Square Metres");
		uomForCountries.put("Norway", "Square Metres");	uomForCountries.put("Nepal", "Square Feet");	uomForCountries.put("Nauru", "Square Feet");	uomForCountries.put("Niue", "Square Feet");	
		uomForCountries.put("New Zealand", "Square Metres");	uomForCountries.put("Oman", "Square Metres");	uomForCountries.put("Panama", "Square Feet");	uomForCountries.put("Peru", "Square Feet");
		uomForCountries.put("French Polynesia", "Square Feet");	uomForCountries.put("Papua New Guinea", "Square Feet");	uomForCountries.put("Philippines", "Square Feet");	uomForCountries.put("Pakistan", "Square Metres");	
		uomForCountries.put("Poland", "Square Metres");	uomForCountries.put("Saint Pierre and Miquelon", "Square Feet");	uomForCountries.put("Pitcairn", "Square Feet");	uomForCountries.put("Palestinian Territory, Occupied", "Square Metres");
		uomForCountries.put("Portugal", "Square Metres");	uomForCountries.put("Paraguay", "Square Feet");	uomForCountries.put("Qatar", "Square Metres");	uomForCountries.put("Reunion", "Square Metres");	
		uomForCountries.put("Romania", "Square Metres");	uomForCountries.put("Serbia", "Square Metres");	uomForCountries.put("Russian Federation", "Square Metres");	uomForCountries.put("Rwanda", "Square Metres");
		uomForCountries.put("Saudi Arabia", "Square Metres");	uomForCountries.put("Solomon Islands", "Square Feet");	uomForCountries.put("Seychelles", "Square Metres");	uomForCountries.put("Sudan", "Square Metres");	
		uomForCountries.put("Sweden", "Square Metres");	uomForCountries.put("Singapore", "Square Feet");	uomForCountries.put("Saint Helena, Ascension and Tristan da Cunha", "Square Feet");	uomForCountries.put("Slovenia", "Square Metres");
		uomForCountries.put("Svalbard and Jan Mayen", "Square Feet");	uomForCountries.put("Slovakia", "Square Metres");	uomForCountries.put("Sierra Leone", "Square Metres");	uomForCountries.put("San Marino", "Square Metres");	
		uomForCountries.put("Senegal", "Square Metres");	uomForCountries.put("Somalia", "Square Metres");	uomForCountries.put("Suriname", "Square Feet");	uomForCountries.put("South Sudan", "Square Metres");
		uomForCountries.put("Sao Tome and Principe", "Square Metres");	uomForCountries.put("El Salvador", "Square Feet");	uomForCountries.put("Sint Maarten (Dutch part)", "Square Feet");	uomForCountries.put("Syrian Arab Republic", "Square Metres");	
		uomForCountries.put("Swaziland", "Square Metres");	uomForCountries.put("Turks and Caicos Islands", "Square Feet");	uomForCountries.put("Chad", "Square Metres");	uomForCountries.put("French Southern Territories", "Square Feet");
		uomForCountries.put("Togo", "Square Metres");	uomForCountries.put("Thailand", "Square Feet");	uomForCountries.put("Tajikistan", "Square Metres");	uomForCountries.put("Tokelau", "Square Feet");	
		uomForCountries.put("Timor-Leste", "Square Feet");	uomForCountries.put("Turkmenistan", "Square Metres");	uomForCountries.put("Tunisia", "Square Metres");	uomForCountries.put("Tonga", "Square Feet");
		uomForCountries.put("Turkey", "Square Metres");	uomForCountries.put("Trinidad and Tobago", "Square Feet");	uomForCountries.put("Tuvalu", "Square Feet");	uomForCountries.put("Taiwan", "Ping");	
		uomForCountries.put("Tanzania, United Republic of", "Square Metres");	uomForCountries.put("Ukraine", "Square Metres");	uomForCountries.put("Uganda", "Square Metres");	uomForCountries.put("United States", "Square Feet");
		uomForCountries.put("Uruguay", "Square Feet");	uomForCountries.put("Uzbekistan", "Square Metres");	uomForCountries.put("Holy See (Vatican City State)", "Square Metres");	uomForCountries.put("Saint Vincent and the Grenadines", "Square Feet");	
		uomForCountries.put("Venezuela, Bolivarian Republic of", "Square Feet");	uomForCountries.put("Virgin Islands, British", "Square Feet");	uomForCountries.put("Viet Nam", "Square Feet");	uomForCountries.put("Vanuatu", "Square Feet");
		uomForCountries.put("Wallis and Futuna", "Square Feet");	uomForCountries.put("Samoa", "Square Feet");	uomForCountries.put("Yemen", "Square Metres");	uomForCountries.put("Mayotte", "Square Feet");	
		uomForCountries.put("South Africa", "Square Metres");	uomForCountries.put("Zambia", "Square Metres");	uomForCountries.put("Zimbabwe", "Square Metres");	uomForCountries.put("Hong Kong", "Square Feet");
		
		return uomForCountries;
	}
	
	public void changeUOMForCountry(String countryId, String measurementUnit) {
		try {
			establishConnection.establishConnection();
			SObject country = new SObject();

			country.setType("Country__c");
			country.setField("Id", countryId);
			country.setField("Default_Unit_Of_Measurement__c", measurementUnit);
			
			SObject[] countries = new SObject[1];
			countries[0] = country;
			results = EstablishConnection.connection.create(countries);
			System.out.println("Result:::" + results);
			status = establishConnection.saveResults(results);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	public void updateUserCountry(String userId, String country) {
		try {
			establishConnection.establishConnection();
			SObject user = new SObject();

			user.setType("User");
			user.setField("Id", "005m0000003UY45AAG");
			user.setField("City", "Aukland");
			user.setField("Country", "New Zealand");
			
			SObject[] users = new SObject[1];
			users[0] = user;
			results = EstablishConnection.connection.create(users);
			System.out.println("Result:::" + results);
			status = establishConnection.saveResults(results);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	public void validateUOMForUserAndCountry() {
		SearchTextSOQL soql = new SearchTextSOQL(scriptHelper);
		Map<String, String> uomForCountriesList = unitOfMeasurementForCountries();
		SObject countryUOM = null;
		
		try {
			countryUOM = soql.fetchCountryAndUOMForUser(dataTable.getData("General_Data", "Username"));
			if(countryUOM != null) {
				if(uomForCountriesList.containsKey((String) countryUOM.getField("Country"))){
					if(uomForCountriesList.get((String) countryUOM.getField("Country")).equals((String) countryUOM.getField("UoM__c")))
						report.updateTestLog("Validate Unit of Measurement value for Country", "The user has the correct value populated for UnitOfMeasurement, as per the user's country", Status.PASS);
					else
						report.updateTestLog("Validate Unit of Measurement value for Country", "The user does not have the correct value populated for UnitOfMeasurement, as per the user's country", Status.FAIL);
				}
				else
					report.updateTestLog("Validate Unit of Measurement value for Country", "The country of the user is not present in the Country object", Status.FAIL);
			}
			else
				report.updateTestLog("Validate Unit of Measurement value for Country", "The user record is not present in the database", Status.FAIL);
				
		} catch(Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
		
		String countryId = soql.fetchRecordFieldValue("Id", "Select Id from Country__c where Name ='"+dataTable.getData("General_Data", "Country")+"'");
		changeUOMForCountry(countryId, "Square Yards");
		Map<String, String> usersFromCountry = soql.fetchAllUsersFromCountry(dataTable.getData("General_Data", "Country"));
		Iterator it = usersFromCountry.entrySet().iterator();
		while (it.hasNext()) {
			Map.Entry entry = (Map.Entry)it.next(); 
			if(entry.getValue().equals("Square Yards"))
				report.updateTestLog("Validate Unit of Measurement value for Country", "The user's UOM got updated successfully when the user's country's UOM was changed", Status.PASS);
			else
				report.updateTestLog("Validate Unit of Measurement value for Country", "The user's UOM did not get updated, when the user's country's UOM was changed", Status.FAIL);
		}
		
		
		updateUserCountry((String) countryUOM.getField("Id"), "Australia");
		countryUOM = soql.fetchCountryAndUOMForUser(dataTable.getData("General_Data", "Username"));
		if(((String) countryUOM.getField("UoM__c")).equals(uomForCountriesList.get("Australia")))
			report.updateTestLog("Validate Unit of Measurement value for Country", "The user's UOM got updated successfully when the user's country was changed", Status.PASS);
		else
			report.updateTestLog("Validate Unit of Measurement value for Country", "The user's UOM did not get updated, when the user's country was changed", Status.FAIL);
	}
	
	
}
