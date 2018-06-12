package supportLibraries;

import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.internal.Coordinates;
import org.openqa.selenium.interactions.internal.Locatable;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import com.cognizant.Craft.ReusableLibrary;
import com.cognizant.Craft.ScriptHelper;
import com.cognizant.framework.Status;
import com.cognizant.framework.selenium.CraftDriver;

/*import freemarker.core.ReturnInstruction.Return;
import supportlibraries.api.FileZipper;*/

public class Utility_Functions extends ReusableLibrary {

	public Utility_Functions(ScriptHelper scriptHelper) {
		super(scriptHelper);
		// TODO Auto-generated constructor stub
	}

	/*
	 * *******************************************************************
	 * Function Name: xHighlight Author : CBRE SFDC Automation Purpose :
	 * Highlight the element Parameters: driver, webelement, color = e.g yellow,
	 * green etc
	 * ******************************************************************
	 */
	public static void xHighlight(CraftDriver driver, WebElement element, String color) {
		for (int i = 0; i < 2; i++) {
			JavascriptExecutor js = (JavascriptExecutor) driver.getWebDriver();
			js.executeScript("arguments[0].setAttribute('style', arguments[1]);", element,
					"border: 2px solid " + color + ";");
		}
	}

	/*
	 * *******************************************************************
	 * Function Name: xClick Author : CBRE SFDC Automation Purpose : Click on
	 * element with or without highlight Parameters: driver, webelement,
	 * highlight = true/false
	 * ******************************************************************
	 */
	public static boolean xClick(CraftDriver driver, WebElement el, boolean highlight) {

		if (highlight == true) {
			// if the element needs to be highlighted before click.
			xHighlight(driver, el, "yellow");
		}

		el.click();

		// timeWait(2);
		return true;
	}

	/*
	 * *******************************************************************
	 * Function Name: inputValueWithReport Author : CBRE SFDC Automation Purpose
	 * : Inputs the value with in the report: tagID, value, label
	 * ******************************************************************
	 */

	public void inputValueWithReport(String tagID, String Value, String label) {
		if (!inputData(tagID, Value)) {
			report.updateTestLog("Input Value", "Error Entering value for field: <i>" + label + "</i> Value : " + Value,
					Status.WARNING);
			System.out.println(
					"WARNING : Problem Encountered while Entering value for field: " + label + " for Value : " + Value);
		} else {
			report.updateTestLog("Input Value", "Entering value for field: <i>" + label + "</i> Value : " + Value,
					Status.PASS);
		}
	}

	/*
	 * *******************************************************************
	 * Function Name: inputData Author : CBRE SFDC Automation Purpose : Inputs
	 * the data: tagID, value
	 * ******************************************************************
	 */

	private boolean inputData(String tagID, String Value) {
		boolean isElementFound = false;
		List<WebElement> GenRiskInfoList = driver.findElements(By.xpath(".//*[@id[contains(.,'" + tagID + "')]]"));
		Utility_Functions.timeWait(1);
		// if(GenRiskInfoList.size() != 1){
		// GenRiskInfoList =
		// driver.findElements(By.xpath(".//*[@id[contains(.,'" + tagID + "')]
		// and @type != 'hidden']"));
		// }
		// while(!isElementFound){
		for (WebElement GenRisk : GenRiskInfoList) {
			// System.out.println(GenRisk.getAttribute("id"));
			if (GenRisk.getAttribute("id").endsWith(tagID)) {
				if (GenRisk.getTagName().equals("input")) {
					// Utility_Functions.xHighlight(driver, GenRisk,
					// Color.YELLOW.toString());
					Utility_Functions.xSendKeys(driver, GenRisk, Value);
					// Utility_Functions.xSendKeys(driver, GenRisk, Keys.TAB);
					isElementFound = true;
				}
				if (GenRisk.getTagName().equals("select")) {
					if (Value != null && !(Value.equals(""))) {
						Utility_Functions.xSelectDropdownByName(GenRisk, Value);
						isElementFound = true;
					}
				}
			}
			if (isElementFound)
				break;

		}
		return isElementFound;
		// }
		// System.out.println("WebElement not found for : " + tagID);
	}

	/*
	 * *******************************************************************
	 * Function Name: validateFieldMatch Author : CBRE SFDC Automation Purpose :
	 * Validates field match: driver, webelement, expression value
	 * ******************************************************************
	 */
	public static boolean validateFieldMatch(CraftDriver driver, WebElement tar, String expValue) {
		String val = tar.getAttribute("value");
		if (val.equalsIgnoreCase(expValue)) {
			xHighlight(driver, tar, "green");
			return true;
		} else {
			xHighlight(driver, tar, "red");
			return false;
		}
	}

	/*
	 * *******************************************************************
	 * Function Name: xClickButton Author : CBRE SFDC Automation Purpose : Added
	 * to click on Button items of bootstrap : driver, webelement, highlight
	 * ******************************************************************
	 */

	public static void xClickButton(CraftDriver driver, WebElement el, boolean highlight) {
		Utility_Functions.xSendKeys(driver, el, Keys.ENTER);
		try {
			Utility_Functions.xClick(driver, el, highlight);
		} catch (Exception e) {
			// Stale elements should land here and be harmless
		}
	}

	/*
	 * *******************************************************************
	 * Function Name: xSelectRadio Author : CBRE SFDC Automation Purpose :
	 * Selects the radio button : driver, webelement
	 * ******************************************************************
	 */

	public static void xSelectRadio(CraftDriver driver, WebElement el) {
		boolean orig = el.isSelected();
		Utility_Functions.xClickButton(driver, el, true);
		if (orig == el.isSelected()) {
			Utility_Functions.xSendKeys(driver, el, " ");
		}

	}

	/*
	 * *******************************************************************
	 * Function Name: xSendKeys Author : CBRE SFDC Automation Purpose : Send
	 * keys to the input field: driver, webelement, highlight = true/false
	 * ******************************************************************
	 */
	public static void xSendKeys(CraftDriver driver, WebElement el, String strVal) {
		xHighlight(driver, el, "yellow");
		el.clear();
		el.sendKeys(strVal);
		// timeWait(1);

	}
	
	/*
	 * *******************************************************************
	 * Function Name: xClickVisibleListElement Author : CBRE SFDC Automation Purpose : Click the visible
	 * element field: driver, List<WebElement>
	 * ******************************************************************
	 */
	public static void xClickVisibleListElement(CraftDriver driver, List<WebElement> eleList) {
		
		for(WebElement element : eleList){
			if(element.isDisplayed()){
				xClickHiddenElement(driver, element);
				break;
			}
		}
		

	}
	
	/*
	 * *******************************************************************
	 * Function Name: xClickVisibleListElement Author : CBRE SFDC Automation Purpose : Click the visible
	 * element field: driver, List<WebElement>
	 * ******************************************************************
	 */
	public static String xGetTextVisibleListElement(CraftDriver driver, List<WebElement> eleList) {
		
		for(WebElement element : eleList){
			if(element.isDisplayed()){
				//xClick(driver, element, true);
				
				return element.getText();
			}
		}
		return null;
		

	}
	/*
	 * *******************************************************************
	 * Function Name: xSendKeysVisibleListElement Author : CBRE SFDC Automation Purpose : SendKeys to the visible
	 * element field: driver, List<WebElement>,string
	 * ******************************************************************
	 */
	public static void xSendKeysVisibleListElement(CraftDriver driver, List<WebElement> eleList,String strVal) {
		
		for(WebElement element : eleList){
			if(element.isDisplayed()){
				xSendKeys(driver, element, strVal);
				break;
			}
		}
		

	}

	public static void xSendKeysNonEmpty(CraftDriver driver, WebElement el, String strVal) {
		if (!(strVal.equals("") || strVal.isEmpty())) {
			// xHighlight(driver, el, "yellow");
			// el.clear();
			// timeWait(1);
			el.sendKeys(strVal);
			el.sendKeys(Keys.TAB);
		}
		// timeWait(1);

	}

	public static void xEraseField(CraftDriver driver, WebElement el) {
		String entry = el.getAttribute("value");
		for (int i = 0; i < entry.length(); i++) {
			el.sendKeys(Keys.BACK_SPACE);
		}
	}

	public static void xSendKeys(CraftDriver driver, WebElement el, Keys keyName) {
		xHighlight(driver, el, "blue");
		el.sendKeys(keyName);

	}

	/*
	 * *******************************************************************
	 * Function Name: xmouseOver Author : CBRE SFDC Automation Purpose :
	 * xHoverElement,xHoverElementDblClk,xHoverElementclicks : Hover and action
	 * Parameters: webelement, driver
	 * ******************************************************************
	 */
	public static void xmouseOver(CraftDriver driver, WebElement el) {
		String mouseOverScript = "if(document.createEvent){" + "var evObj = document.createEvent('MouseEvents');"
				+ "evObj.initEvent('mouseover', true, false); " + "arguments[0].dispatchEvent(evObj);" + "} "
				+ "else if(document.createEventObject) { " + "arguments[0].fireEvent('onmouseover');" + "}";
		JavascriptExecutor js = (JavascriptExecutor) driver.getWebDriver();
		js.executeScript(mouseOverScript, el);
	}

	public static void xmouseOut(CraftDriver driver, WebElement el) {
		String mouseOffScript = "if(document.createEvent){var evObj = document.createEvent('MouseEvents');"
				+ "evObj.initEvent('mouseout', true, false); arguments[0].dispatchEvent(evObj);"
				+ "} else if(document.createEventObject) { arguments[0].fireEvent('onmouseout');}";
		JavascriptExecutor js = (JavascriptExecutor) driver.getWebDriver();
		js.executeScript(mouseOffScript, el);
	}

	public static void xMouseOut(CraftDriver driver, WebElement el) {
		String mouseOffScript = "$(arguments[0]).mouseout();";
		JavascriptExecutor js = (JavascriptExecutor) driver.getWebDriver();
		js.executeScript(mouseOffScript, el);
	}

	public static void xMouseOver(CraftDriver driver, WebElement el) {
		String mouseOverScript = "$(arguments[0]).mouseover();";
		JavascriptExecutor js = (JavascriptExecutor) driver.getWebDriver();
		js.executeScript(mouseOverScript, el);
	}

	public static void xMouseClick(CraftDriver driver, WebElement el) {
		/*
		 * String mouseScript = "if(document.createEvent){" +
		 * "var evObj = document.createEvent('MouseEvents');" +
		 * "evObj.initEvent('click', true, false); " +
		 * "arguments[0].dispatchEvent(evObj);} " +
		 * "else if(document.createEventObject) { " +
		 * "arguments[0].fireEvent('click');}";
		 */
		String mouseScript = "arguments[0].click();";
		JavascriptExecutor js = (JavascriptExecutor) driver.getWebDriver();
		js.executeScript(mouseScript, el);
	}

	public static boolean xHoverElementDblClk(WebElement el, CraftDriver driver) {

		Actions builder = new Actions(driver.getWebDriver());
		builder.moveToElement(el).doubleClick().perform();
		timeWait(1);
		return true;
	}

	public static boolean xHoverElementclicks(WebElement el, CraftDriver driver) {
		Actions builder = new Actions(driver.getWebDriver());
		builder.moveToElement(el).click().build().perform();
		timeWait(2);
		//builder.click().perform();
		return true;
	}

	/*
	 * *******************************************************************
	 * Function Name: timeWait, impWait, xWaitForElementVisible,
	 * xWaitForElementPresent, xWaitForElementClickable,
	 * xWaitForElementAttribute Author : CBRE SF Automation Purpose : Hover and
	 * action Parameters: webelement, driver
	 * ******************************************************************
	 */
	// Static wait for specified time
	public static void timeWait(int time) {
		try {
			long result = time * 1000;
			Thread.sleep(result);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	// implicit wait
	public static void impWait(CraftDriver driver, int time) {
		driver.manage().timeouts().implicitlyWait(time, TimeUnit.SECONDS);
	}

	// ******************************************************************
	/*
	 * Function Name: findWebElementById Author : CBRE SFDC Automation Purpose :
	 * Element finder by ID
	 * ******************************************************************
	 */
	public static WebElement findWebElementById(CraftDriver driver, String string) {
		return driver.findElement(By.id(string));
	}

	/*
	 * *******************************************************************
	 * Function Name: findWebElementByName Author : CBRE SF Automation Purpose :
	 * Element finder by Name
	 * ******************************************************************
	 */
	public static WebElement findWebElementByName(CraftDriver driver, String string) {
		return driver.findElement(By.name(string));
	}

	/*
	 * *******************************************************************
	 * Function Name: findWebElementByClassName Author : CBRE SF Automation
	 * Purpose : Element finder by ClassName
	 * ******************************************************************
	 */
	public static WebElement findWebElementByClassName(CraftDriver driver, String string) {
		return driver.findElement(By.className(string));
	}

	/*
	 * *******************************************************************
	 * Function Name: findWebElementBylinkText Author : CBRE SF Automation
	 * Purpose : Element finder by linkText
	 * ******************************************************************
	 */

	public static boolean findElementBylinkText(CraftDriver driver, String element_linkText) {
		int count = driver.findElements(By.linkText(element_linkText)).size();
		if (count == 0) {
			System.out.println("The element is not found " + element_linkText);
			return false;
		}

		System.out.println("The element is present " + element_linkText);
		return true;
	}

	/*
	 * *******************************************************************
	 * Function Name: findWebElementByXpath Author : CBRE SF Automation Purpose
	 * : Element finder by xpath
	 * ******************************************************************
	 */

	public static boolean findElementByXpath(CraftDriver driver, String element_xpath) {
		int count = 0;
		count = driver.findElements(By.xpath(element_xpath)).size();
		if (count == 0) {
			System.out.println("The element is not found " + element_xpath);
			return false;
		}
		System.out.println("The element is present" + element_xpath);
		return true;
	}

	// ***********************************************************

	// wait for the element to be visible
	public static boolean xWaitForElementVisible(CraftDriver driver, WebElement el, int timeWait) {
		WebDriverWait wait = new WebDriverWait(driver.getWebDriver(), timeWait);
		wait.until(ExpectedConditions.visibilityOf(el));
		return true;
	}
	
	// ***********************************************************

	// wait for the the expected xpath count to be present
	
	/*public void xWaitForXpathCount(CraftDriver driver, String xpath, int timeWait) {
		WebDriverWait wait = new WebDriverWait(driver.getWebDriver(), timeWait);
	    wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpath)));
	    List<WebElement> elementsList=driver.findElements(By.xpath(xpath));
	    while(elementsList.size()>0){
	    	    	}
		      
	}*/
	
	
	// ******************************************************************
	// wait for element present
	public static boolean xWaitForElementPresent(CraftDriver driver, By locator, int timeWait) {
		WebDriverWait wait = new WebDriverWait(driver.getWebDriver(), timeWait);
		wait.until(ExpectedConditions.presenceOfElementLocated(locator));
		return true;
	}

	// ******************************************************************
	// wait for element present
	public static boolean xWaitForElementPresent(CraftDriver driver, WebElement el, int timeWait) {
		WebDriverWait wait = new WebDriverWait(driver.getWebDriver(), timeWait);
		wait.until(ExpectedConditions.visibilityOf(el));
		return true;
	}

	public static boolean xWaitForElementPresent(CraftDriver driver, List<WebElement> elements, int timeWait) {
		WebDriverWait wait = new WebDriverWait(driver.getWebDriver(), timeWait);
		wait.until(ExpectedConditions.visibilityOfAllElements(elements));
		return true;
	}
	
	
	
	// ******************************************************************
	// wait for element to disappear
	public static boolean xWaitForElementDisappear(CraftDriver driver, By locator, int timeWait) {
		try {
			WebDriverWait wait = new WebDriverWait(driver.getWebDriver(), timeWait);
			wait.until(ExpectedConditions.invisibilityOfElementLocated(locator));
			return true;
		} catch (Exception e) {
			System.out.println("Element could not disappear within the specified time");
			System.out.println(e.getMessage());
			return false;
		}

	}

	// ******************************************************************
	// wait for the element to be clickable
	public static boolean xWaitForElementClickable(CraftDriver driver, WebElement el, int timeWait) {
		WebDriverWait wait = new WebDriverWait(driver.getWebDriver(), timeWait);
		wait.until(ExpectedConditions.elementToBeClickable(el));
		xHighlight(driver, el, "blue");
		return true;
	}

	// ******************************************************************
	// wait for a particular attribute of the webelement
	public static void xWaitForElementAttribute(CraftDriver driver, By Locator, String attribute, String message,
			int timeWait) {
		int timeout = 0;
		while (!driver.findElement(Locator).getAttribute(attribute).contains(message)) {
			if (timeout >= 20) {
				break;
			}
			timeWait(2);
			timeout++;
		}
	}

	/*
	 * wait until the popup windows is open or closed
	 */
	public static boolean xWaitUntilnoOfWindows(CraftDriver driver, int noOfWindows, int timeWait) {
		// TODO Auto-generated method stub
		WebDriverWait wait = new WebDriverWait(driver.getWebDriver(), timeWait);
		wait.until(ExpectedConditions.numberOfWindowsToBe(noOfWindows));
		return true;
	}

	/*
	 * *******************************************************************
	 * Function Name: xScrollWindow Author : CBRE SFDC Automation Purpose :
	 * Hover and action Parameters: driver
	 * ******************************************************************
	 */
	public static void xScrollWindow(CraftDriver driver) {
		for (int timeout = 0;; timeout++) {
			if (timeout >= 5) {
				break;
			}
			JavascriptExecutor js = (JavascriptExecutor) driver.getWebDriver();
			js.executeScript("window.scrollBy(0,400)", "");
			timeWait(2);
		}
	}

	public static void xScrollWindowOnce(CraftDriver driver) {
		for (int timeout = 0;; timeout++) {
			if (timeout >= 5) {
				break;
			}
			JavascriptExecutor js = (JavascriptExecutor) driver.getWebDriver();
			js.executeScript("window.scrollBy(0,200)", "");
			timeWait(2);
		}
	}

	/**
	 * Use this for scrolling directly to an object (javascript scroll). Will
	 * attempt to put that object near the top of the screen.
	 * 
	 * @param driver
	 * @param el
	 */
	public static void xScrollWindowToElement(CraftDriver driver, WebElement el) {
		try {
			JavascriptExecutor js = (JavascriptExecutor) driver.getWebDriver();
			js.executeScript("arguments[0].scrollIntoView(true);", el);
			timeWait(2);
		} catch (Exception e) {
			// Added to prevent false erroring for referencing a "hidden" object
			System.out.println("Internal error: " + e.getMessage() + "\nContinuing after error.");
		}
	}

	public static void xScrollWindowTop(CraftDriver driver) {
		// for (int timeout = 0;; timeout++) {
		// if (timeout >= 5) {
		// break;
		// }
		JavascriptExecutor js = (JavascriptExecutor) driver.getWebDriver();
		js.executeScript("window.scroll(0,0)", "");
		timeWait(2);
		// }
	}

	public static void xClickHiddenElement(CraftDriver driver, WebElement element) {
		JavascriptExecutor js = (JavascriptExecutor) driver.getWebDriver();
		js.executeScript("arguments[0].click()", element);
	}

	/*
	 * *******************************************************************
	 * Function Name: xSelectDropdown,xSelectDropdownByName Author : CBRE SFDC
	 * Automation Purpose : Hover and action Parameters: webelement, index
	 * ******************************************************************
	 */
	// Select dropdown by Index
	public static void xSelectDropdownByIndex(WebElement e, Integer index) {
		Select answer = new Select(e);
		answer.selectByIndex(index);
	}

	public static void xSelectDropdownByName(WebElement e, String visibleName) {
		Select dropdown = new Select(e);
		dropdown.selectByVisibleText(visibleName);
	}

	public static void xSelectDropdownByValue(WebElement e, String value) {
		Select dropdown = new Select(e);
		dropdown.selectByValue(value);
	}

	/*
	 * *******************************************************************
	 * Function Name: xContainsvalue Author : CBRE SFDC Automation Purpose :
	 * Takes a given driver and window title, returns true if the window title
	 * exists ******************************************************************
	 */

	public static boolean xContainsValue(CraftDriver driver, String title) {
		if (driver.getTitle().contains(title)) {
			return true;
		}

		return false;
	}

	/*
	 * *******************************************************************
	 * Function Name: Miscellaneous functions Author : CBRE SF Automation
	 * Purpose : Hover and action Parameters: webelement, index
	 * ******************************************************************
	 */
	// Maximizing the browser size
	public static void xSetBrowserSize(CraftDriver driver) {
		driver.manage().window().maximize();
		// driver.manage().window().setSize(new Dimension(900, 700));
	}

	// Delete Cache
	public static void xDelCache() throws IOException {
		Runtime.getRuntime().exec("cmd /c /windows/system32/RunDll32.exe InetCpl.cpl,ClearMyTracksByProcess 255");
	}

	/**
	 * Window switch by window number
	 * 
	 * @param driver
	 * @param windowNumber
	 */
	public static void xSwitchToWindow(CraftDriver driver, int windowNumber) {
		Set<String> window = driver.getWindowHandles();
		Iterator<String> itr = window.iterator();
		int count = 0;

		if (windowNumber < 0)
			return;

		while (itr.hasNext()) {
			driver.switchTo().window(itr.next());
			if (count == windowNumber)
				break;
			count++;
		}
	}

	/**
	 * Opens a new window based on click. Built on the assumption that only 1
	 * window opens per link click
	 * 
	 * @param driver
	 *            - active webdriver
	 * @param tar
	 *            - target webelement, applies xClickButton(driver,tar,true)
	 * @param waitInSecs
	 */
	public static void xClickSwitchNewWindow(CraftDriver driver, WebElement tar, int waitInSecs) {
		Set<String> baseWindows = driver.getWindowHandles();
		Utility_Functions.xClickButton(driver, tar, true);
		Utility_Functions.xWaitUntilnoOfWindows(driver, baseWindows.size() + 1, waitInSecs * 100);
		Set<String> newWindows = driver.getWindowHandles();
		for (String window : newWindows) {
			if (!baseWindows.contains(window)) {
				driver.switchTo().window(window);
				return;
			}
		}
	}

	// Purpose: switch to windows with specific title
	public static boolean xContainsSwitch(CraftDriver driver, String title) {
		timeWait(2);
		Set<String> windows = driver.getWindowHandles();
		for (Iterator<String> i = windows.iterator(); i.hasNext();) {
			String window = i.next();
			driver.switchTo().window(window);
			if (driver.getTitle().contains(title)) {
				return true;
			}
		}
		return false;
	}

	/*
	 * Purpose: get the current system date
	 */

	public static String getCurrentDate() {
		DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
		Date date = new Date();
		return dateFormat.format(date);
	}

	public static String parseDateFormat(String inDate) {
		String Date = inDate;
		// System.out.println(Date.length());
		if (Date.length() <= 8) {
			DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
			try {
				Date date = new SimpleDateFormat("MM/dd/yy").parse(inDate);
				Date = dateFormat.format(date);
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return Date;
	}
	/*
	 * @Purpose : Find Element by CSS Selector function
	 */

	public static List<WebElement> findElementsByCSSSelector(CraftDriver driver, String xpath) {
		try {
			return driver.findElements(By.cssSelector(xpath));
		} catch (Exception e) {
			System.out.println("Elements not found " + xpath);
			return null;
		}

	}

	public static boolean collapseicon(CraftDriver driver, String xpath) {
		try {
			List<WebElement> expandicons = Utility_Functions.findElementsByCSSSelector(driver, xpath);
			System.out.println(expandicons.size());
			int expandicons_count = expandicons.size();
			for (int i = expandicons_count - 1; i >= 0; i--) {
				expandicons.get(i).click();
				expandicons = Utility_Functions.findElementsByCSSSelector(driver, xpath);
			}
			return true;
		} catch (Exception e) {
			return false;
		}

	}

	public static String isAlertPresent(CraftDriver driver) {
		try {
			Alert al = driver.switchTo().alert();
			String a = al.getText();
			al.accept();
			return a;

		} catch (Exception e) {
			return null;
		}

	}

	public static String iterateAllElements_and_click(CraftDriver driver, String xpath1, String Optional_xpath2) {

		List<WebElement> elements = Utility_Functions.findElementsByCSSSelector(driver, xpath1);
		int total_elements = elements.size();
		String elements_available = "";
		String current_element = "";
		boolean isNewAgentIndicator = true; // indicates if the agent is a
		// newagent or existing agent
		if (total_elements > 0) {
			try {

				for (int i = 0; i <= total_elements - 1; i++) {
					elements.get(i).click();
					Utility_Functions.xWaitForElementDisappear(driver, By.cssSelector("span[id *='status.start']"), 90);
					Utility_Functions.timeWait(5);
					// elements =
					// Utility_Functions.findElementsByCSSSelector(driver,
					// xpath1);
					elements = Utility_Functions.findElementsByCSSSelector(driver, xpath1);
					String text_checkactive = elements.get(i).getAttribute("class");
					if (text_checkactive.contains("rich-tab-active")) {
						current_element = elements.get(i).getText();
					}

					System.out.println("Sucessful on clicking the tab " + current_element);
					if (Optional_xpath2 != "") // to check if the tab is empty
					// or not
					{
						if (!Utility_Functions.findElementByXpath(driver, Optional_xpath2)) {
							System.out.println("tab is empty");
							elements_available = elements_available + "--" + current_element + "--" + "N";

						} else {
							System.out.println("tab is not empty");
							isNewAgentIndicator = false;
							elements_available = elements_available + "--" + current_element + "--" + "Y";
							// tabs_Containingdata= tabs_Containingdata +"//"+
							// current_element;
						}
					}
					// added to get the tab elements name if Optional_xpath2==""
					if (Optional_xpath2 == "") {
						elements_available = elements_available + "--" + current_element;
					}
				} // end of for loop

				if (Optional_xpath2 == "") {
					// results generate based on Optional_xpath2
					return "pass --" + total_elements + elements_available + "--" + " ";
				} else {
					if (isNewAgentIndicator == true) {
						// if new agent
						return "pass --" + total_elements + elements_available + "--All tabs are empty-New User";
					} else {
						// if existing agent
						return "pass --" + total_elements + elements_available + "--Existing User";
					}

				}
			} catch (Exception e) {
				return "fail --" + total_elements + "--" + "failure to click all the tabs" + "--";
			}
		} else {
			return null;
		}

	}

	/*
	 * Function will fetch the data form validation board and retrieve all the
	 * validation present with validation id
	 */
	public static List<List<String>> getErrorTableData(CraftDriver driver) {
		Utility_Functions.xWaitForElementDisappear(driver, By.cssSelector("span[id *='status.start']"), 60);
		String xpathToTable = "//table[@id='q2iForm:validationTableRndr']/tbody/tr";
		List<List<String>> errorTable = new ArrayList<List<String>>();
		int rowCount = driver.findElements(By.xpath(xpathToTable)).size();
		int columnCount = driver.findElements(By.xpath(xpathToTable + "[1]/td")).size();
		for (int i = 1; i <= rowCount; i++) {
			ArrayList<String> row = new ArrayList<String>();
			for (int j = 1; j <= columnCount; j++) {
				String xpathToElement = xpathToTable + "[" + i + "]/td[" + j + "]";
				String value;
				List<WebElement> rowValue = driver.findElements(By.xpath(xpathToElement));
				if (j == 1) {

					value = driver.findElements(By.xpath(xpathToElement + "/img")).get(0).getAttribute("src")
							.toString();
					if (value.contains("validation"))
						value = value.substring(value.lastIndexOf('-') + 1, value.lastIndexOf('.'));
					else
						value = "10";

				} else
					value = rowValue.get(0).getText();
				row.add(value);
			}
			errorTable.add(row);
		}

		return errorTable;
	}

	public static boolean validateErrorMessage(CraftDriver driver) {
		Utility_Functions.xWaitForElementDisappear(driver, By.cssSelector("span[id *='status.start']"), 60);
		List<List<String>> messageTable = getErrorTableData(driver);
		int errorCount = 0;
		for (int i = 0; i < messageTable.size(); i++) {
			if (Integer.parseInt(messageTable.get(i).get(0)) >= 200) {
				errorCount++;
			} else {

			}

			// }
		}
		if (errorCount >= 1) {
			System.out.println("Failed with more than 1 validation error");
			return false;
		} else {
			return true;
		}
	}

	/*
	 * 
	 */

	public static void validateAndClickInformation(CraftDriver driver, String ExpectedValidationText) {
		Utility_Functions.xWaitForElementDisappear(driver, By.cssSelector("span[id *='status.start']"), 60);
		String xpathToTable = "//table[@id='q2iForm:validationTableRndr']/tbody/tr/td[2]";
		List<WebElement> informations = driver.findElements(By.xpath(xpathToTable));
		boolean found = false;
		for (WebElement info : informations) {
			System.out.println(info.getText());
			if (info.getText().contains(ExpectedValidationText)) {
				found = true;
				xClick(driver, info, false);
				Utility_Functions.xWaitForElementDisappear(driver, By.id("workbench:status.start"), 30);
				break;
			}
		}

		if (!found) {
			System.out.println("unable to find validations");
		}

	}

	/*
	 * New Function added to fetch the data from Common sheet for tab based
	 * parameters
	 */
	public String getTable(String tableName, String Columnname) {
		String returnValue = dataTable.getData(tableName, Columnname);
		if (returnValue.startsWith("*")) {
			returnValue = returnValue.split("\\*")[1];
			// returnValue = getEnvParameterDataTable(returnValue);
			// returnValue = getConfiguration(returnValue);
		}
		return returnValue;
	}

	/*
	 * public String getEnvParameterDataTable(String dataValue) { String path =
	 * frameworkParameters.getRelativePath() +
	 * System.getProperty("file.separator") + "Datatables" +
	 * System.getProperty("file.separator"); ExcelDataAccess commonDataAccess =
	 * new ExcelDataAccess(path, "Common_Testdata");
	 * commonDataAccess.setDatasheetName("Env Parameters");
	 * 
	 * int rowNum = commonDataAccess.getRowNum(dataValue, 0, 1); if (rowNum ==
	 * -1) { throw new
	 * FrameworkException("The common test data row identified by \"" +
	 * dataValue + "\"" + "is not found in the common test data sheet!"); }
	 * 
	 * dataValue = commonDataAccess.getValue(rowNum,
	 * envParameters.getEnv().toUpperCase());
	 * 
	 * return dataValue; }
	 * 
	 * 
	 * public String getConfiguration(String Key){ String Value = ""; String
	 * sqlStatement = "select value from configuration where client_name = '" +
	 * envParameters.getClient() + "' and env_name = '"+ envParameters.getEnv()+
	 * "' and parameter = '"+ Key +"'"; DBConnection connection =
	 * getInternalDBConnection(); connection.setSqlStatement(sqlStatement);
	 * Value = connection.getResultString("value", true); return Value; }
	 * 
	 * 
	 * Get configuration parameter from DB when client has to be pass
	 * specifically
	 * 
	 * public String getConfiguration(String client, String env, String Key){
	 * String Value = ""; String sqlStatement =
	 * "select value from configuration where client_name = '" + client +
	 * "' and env_name = '"+ env+ "' and parameter = '"+ Key +"'"; DBConnection
	 * connection = getInternalDBConnection();
	 * connection.setSqlStatement(sqlStatement); Value =
	 * connection.getResultString("value", true); return Value; }
	 * 
	 * 
	 * public static DBConnection getInternalDBConnection(){ Properties property
	 * = new Properties(); try { property.load(new
	 * FileInputStream("Global Settings.properties")); } catch
	 * (FileNotFoundException e) { // TODO Auto-generated catch block
	 * e.printStackTrace(); } catch (IOException e) { // TODO Auto-generated
	 * catch block e.printStackTrace(); } DBConnection connection = new
	 * DBConnection(); connection.setURL(property.getProperty("localdb.url"));
	 * connection.setUsername(property.getProperty("localdb.username"));
	 * connection.setPassword(property.getProperty("localdb.password")); return
	 * connection; }
	 * 
	 * public static Properties setCraftProperty(){ DBConnection connection =
	 * getInternalDBConnection(); Properties property = new Properties(); String
	 * sqlStatement = "select KEYNAME, VALUE from craft_config";
	 * connection.setSqlStatement(sqlStatement); try { ResultSet rset =
	 * connection.executeStatement();//pstmt.executeQuery(); while(rset.next()){
	 * String key = rset.getString("keyname"); String value =
	 * rset.getString("value"); property.setProperty(key, value);
	 * 
	 * } } catch (SQLException e) { // TODO Auto-generated catch block
	 * e.printStackTrace(); }
	 * 
	 * return property; }
	 * 
	 * 
	 * Purpose: get DB connection element from common Functions excel sheet
	 * 
	 * public void getDBDetails(String client) { String DBString = ""; try{
	 * DBString = getConfiguration("DB_DETAILS"); }catch(Exception e){
	 * 
	 * } if (DBString.contains(";")) {
	 * envParameters.setDBUrl(DBString.split(";")[0]);
	 * envParameters.setDBUserName(DBString.split(";")[1]);
	 * envParameters.setDBPassword(DBString.split(";")[2]); } }
	 */

	/*
	 * Function to Navigate to the top menu with Hover properties*
	 */
	public static boolean navigateToPage_using_TopMenu(CraftDriver driver, WebElement Element1, WebElement Element2) {
		xmouseOver(driver, Element1);
		Utility_Functions.timeWait(5);
		Utility_Functions.xSendKeys(driver, Element2, Keys.ENTER);
		return true;
	}

	/*
	 * purpose: Login to a page with username, password and click btn
	 */

	// public static boolean loginToPage(CraftDriver driver, WebElement
	// UserName,
	// WebElement Password, )
	public static List<WebElement> findElementsByTagName(WebElement Ele, String tagName) {
		try {
			return Ele.findElements(By.tagName(tagName));
		} catch (Exception e) {
			System.out.println("Elements not found with tag name" + tagName);
			return null;
		}

	}

	public static boolean isAttributePresent(WebElement element, String attribute) {
		Boolean result = false;
		try {
			String value = element.getAttribute(attribute);
			if (value != null) {
				result = true;
			}
		} catch (Exception e) {
		}

		return result;
	}

	/*
	 * public static void ZipResults(String reportPath) { // TODO Auto-generated
	 * method stub FileZipper appZip = new FileZipper();
	 * appZip.ZipFiles(reportPath); }
	 */

	public static String DateAdd(String effectiveDate, int days) {
		// effectiveDate = effectiveDate.split("T")[0];
		DateFormat df1 = new SimpleDateFormat("M/d/yyyy");
		Calendar c = Calendar.getInstance();
		try {
			// Date date = new
			// SimpleDateFormat("yyyy-M-d").parse(effectiveDate);
			// effectiveDate = df1.format(effectiveDate);
			c.setTime(df1.parse(effectiveDate));

		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// TODO Auto-generated method stub
		c.add(Calendar.DATE, days);
		return df1.format(c.getTime());
	}

	public static void HtmlZoomOut(CraftDriver driver, int zoomOutlevel) {
		WebElement html = driver.findElement(By.tagName("html"));
		// html.sendKeys(Keys.chord(Keys.CONTROL, "0"));
		for (int i = 0; i < zoomOutlevel; i++) {
			html.sendKeys(Keys.chord(org.openqa.selenium.Keys.CONTROL, org.openqa.selenium.Keys.SUBTRACT));
		}
		if (zoomOutlevel == 0)
			html.sendKeys(Keys.chord(Keys.CONTROL, "0"));
		Utility_Functions.timeWait(1);
	}

	public static String dateAddition(String date_claim, int days) {
		// effectiveDate = effectiveDate.split("T")[0];
		DateFormat df1 = new SimpleDateFormat("MM/dd/yyyy");
		Calendar c = Calendar.getInstance();
		try {
			// Date date = new
			// SimpleDateFormat("yyyy-M-d").parse(effectiveDate);
			// effectiveDate = df1.format(effectiveDate);
			c.setTime(df1.parse(date_claim));

		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// TODO Auto-generated method stub
		c.add(Calendar.DATE, days);

		System.out.println(df1.format(c.getTime()));

		return df1.format(c.getTime());
	}

	/*
	 * Web Element detail sniffer: give it the same xpath to get details
	 */
	public static void printElementDetailsByXPath(CraftDriver driver, String xpath) {
		List<WebElement> list = driver.findElements(By.xpath(xpath));
		if (list.size() > 0) {
			WebElement tar = list.get(0);
			System.out.println("[" + xpath + "]:\nEnabled:" + tar.isEnabled() + "\tSelected:" + tar.isSelected()
					+ "\tDisplayed:" + tar.isDisplayed() + "\tSize:" + list.size());
		} else {
			System.out.println("Could not find any element based on XPath:[" + xpath + "]");
		}
	}

	/*
	 * *******************************************************************
	 * Function Name: xHighlight Author : CBRE SF Automation Purpose : Highlight
	 * the element Parameters: driver, webelement, color = e.g yellow, green etc
	 * ******************************************************************
	 */

	/*
	 * public boolean validatePDFViewer(){ boolean isPdfPresent = false; String
	 * pdfPageSource = driver.getPageSource();
	 * switch(envParameters.getBrowser()){ case INTERNET_EXPLORER:
	 * if(pdfPageSource.equals("")) isPdfPresent=true; break; case FIREFOX:
	 * if(pdfPageSource.contains("pdfViewer")) isPdfPresent=true; break; case
	 * CHROME: if(pdfPageSource.contains("application/pdf")) isPdfPresent=true;
	 * break; default: break; }
	 * 
	 * return isPdfPresent; }
	 */

	/*
	 * *******************************************************************
	 * Function Name: xHighlight Author : CBRE SF Automation Purpose : Highlight
	 * the element Parameters: driver, webelement, color = e.g yellow, green etc
	 * ******************************************************************
	 */

	public static boolean validateLinks(List<WebElement> list, String webElementText) {
		for (WebElement element : list) {
			if (element.getText().equals(webElementText)) {
				return true;
			}
		}
		return false;
	}

	public static void xclickOnFirstElementfromList(List<WebElement> list) {
		Utility_Functions.timeWait(1);
		if(list.isEmpty()) {
			System.out.println("List is Empty:::");
			return;
		} else {
			for (WebElement elememt : list) {
				elememt.click();
				return;
			}
		}
	}

	/*
	 * *******************************************************************
	 * Function Name: xHighlight Author : CBRE SF Automation Purpose : Highlight
	 * the element Parameters: driver, webelement, color = e.g yellow, green etc
	 * ******************************************************************
	 */

	public static String xclickRandomElement(List<WebElement> list) {
		String text = null;
		boolean isStatus = false;
		Random random = new Random();
		Utility_Functions.timeWait(1);
		if(list.isEmpty()) {
			System.out.println("List is Empty:::");
			return null;
		} else {
			while (!isStatus) {
				for (WebElement elememt : list) {
					int randomValue = random.nextInt(list.size());
					text = elememt.getText();
					list.get(randomValue).click();
					isStatus = true;
					break;
				}
			}
			return text;
		}		
	}

	/*
	 * *******************************************************************
	 * Function Name: xHighlight Author : CBRE SF Automation Purpose : Highlight
	 * the element Parameters: driver, webelement, color = e.g yellow, green etc
	 * ******************************************************************
	 */

	public static String xclickgetTextofFirstElementfromList(List<WebElement> list) {
		String text = null;
		boolean isStatus = false;
		if(list.isEmpty()) {
			System.out.println("List is Empty:::");
			return null;
		} else {
			while (!isStatus) {
				for (WebElement elememt : list) {
					text = elememt.getText();
					elememt.click();
					isStatus = true;
					break;
				}
			}
			return text;
		}		
	}

	/*
	 * *******************************************************************
	 * Function Name: xSwitc Author : CBRE SF Automation Purpose : Highlight the
	 * element Parameters: driver, webelement, color = e.g yellow, green etc
	 * ******************************************************************
	 */

	public static void xSwitchToWindow(CraftDriver driver, String windowName) {
		WebDriver popup = driver.getWebDriver();
		Set<String> windowIterator = driver.getWindowHandles();
		System.err.println("No of windows :  " + windowIterator.size());
		for (String s : windowIterator) {
			String windowHandle = s;
			popup = driver.switchTo().window(windowHandle);
			System.out.println("Window Title : " + popup.getTitle());
			System.out.println("Window Url : " + popup.getCurrentUrl());
			if (popup.getTitle().contains(windowName)) {
				System.out.println("Selected Window Title : " + popup.getTitle());
				// driver = popup;
				break;

			}
		}
	}

	public static String getText(CraftDriver driver, WebElement element) {
		return (String) ((JavascriptExecutor) driver).executeScript("return jQuery(arguments[0]).text();", element);
	}

	/*
	 * *******************************************************************
	 * Function Name: xSwitchFrames Author : CBRE SF Automation Purpose :
	 * 
	 * ******************************************************************
	 */
	public static void xSwitchtoFrame(CraftDriver driver, WebElement webElement) {
		List<WebElement> iframeList = driver.findElements(By.tagName("iframe"));
		driver.switchTo().defaultContent();
		driver.manage().timeouts().implicitlyWait(0, TimeUnit.MILLISECONDS);
		for (WebElement element : iframeList) {
			driver.switchTo().frame(element);
			try {
				boolean isTextValuePresent = Utility_Functions.xWaitForElementPresent(driver, webElement, 0);
				if (isTextValuePresent) {
					break;
				} else {
					driver.switchTo().defaultContent();
				}
			} catch (Exception ex) {
				driver.switchTo().defaultContent();
			}
		}
		Utility_Functions.timeWait(1);
		driver.manage().timeouts().implicitlyWait(3000, TimeUnit.MILLISECONDS);
	}
	/*
	 * *******************************************************************
	 * Function Name: Random Function Author : CBRE SF Automation Purpose :
	 * ******************************************************************
	 */
	
	public static int xRandomFunction() {
		Random random = new Random();
		int value = random.nextInt(9000000) + 1000000;
		return value;
	}
	
	/*
	 * *******************************************************************
	 * Function Name: Random String Function Author : CBRE SF Automation Purpose :
	 * ******************************************************************
	 */
	private static final String ALPHA_NUMERIC_STRING = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";

	public static String xGenerateAlphaNumericString()
	{	
		int count = 10;
		StringBuilder builder = new StringBuilder();
		while (count-- != 0) {
			int character = (int)(Math.random()*ALPHA_NUMERIC_STRING.length());
			builder.append(ALPHA_NUMERIC_STRING.charAt(character));
		}
		return builder.toString();
	}
	
	/*
	 * *******************************************************************
	 * Function Name: Validate whether the page is ready
	 * ******************************************************************
	 */

	public static void xWaitPageReady(CraftDriver driver) {
		JavascriptExecutor js = (JavascriptExecutor) driver.getWebDriver();
		if (js.executeScript("return document.readyState").toString().equals("complete")) {
			try {
				Thread.sleep(1000);
				driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println("Page is loaded:::");
			return;
		}
		for (int i = 0; i < 10; i++) {
			try {
				Thread.sleep(1000);
			} catch (Exception e) {
				if (js.executeScript("return document.readyState").toString().equals("complete")) {
					break;
				}
			}
		}
	}

	/*
	 * *******************************************************************
	 * Function Name: Validate whether the fields present on the page or not
	 * ******************************************************************
	 */
	
	public static List<String> xValidateFieldsPresentonPage(List<String> List1, List<WebElement> WebElements, String TextToBeDisplayed) {
		List<String> WebElementsList = new ArrayList<String>();
/*		for (String element:List1){
			List1.add(element.replace("%2F", "/"));
		}*/
		for(int i=0; i < List1.size(); i++) {
			if(List1.get(i).contains("%2F")) {
				String sElement = List1.get(i);
				List1.remove(i);
				String sNewElement = sElement.replace("%2F", "/");
				List1.add(sNewElement);
			} 
		}	
		System.out.println("List Elements are::" + List1);
		for(WebElement element: WebElements) {
			WebElementsList.add(element.getText().toString().trim().replace("*", ""));
		}
		System.out.println(TextToBeDisplayed +  " -- " + WebElementsList  + " are present in the page");
		List1.removeAll(WebElementsList);
		System.out.println(TextToBeDisplayed +  " -- " + List1  + " which aren't present in the page");
		return List1;
	}
	
	/*
	 * *******************************************************************
	 * Function Name: Validate whether the fields present on the page or not
	 * ******************************************************************
	 */
	
	
	public static List<String> xValidatePickListValuesPage(List<String> List1, List<String> List2, String TextToBeDisplayed) {
		for(int i=0; i < List1.size(); i++) {
			if(List1.get(i).contains("%2F")) {
				String sElement = List1.get(i);
				List1.remove(i);
				String sNewElement = sElement.replace("%2F", "/");
				List1.add(sNewElement);
			} 
		}	
		List1.removeAll(List2);
		System.out.println(TextToBeDisplayed +  " -- " + List1  + " which aren't present in the page");
		return List1;
	}
	
	/*
	 * *******************************************************************
	 * Function Name: Validate whether the fields present on the page or not
	 * ******************************************************************
	 */
	
	
	public static int xValidateFieldsPresentPage(List<String> FieldList, List<WebElement> WebElements,
			String TextToBeDisplayed) {
		int count = 0;
		if (WebElements.size() == 0) {
			System.out.println("There are no elements identified with the List<WebElement> xpath");
		} else {
			String labelArray[] = new String[WebElements.size()];
			int j = 0, i1 = 0;
			try {
				while (j < FieldList.size()) {
					for (WebElement element : WebElements) {
						labelArray[i1] = element.getText();
						labelArray[i1] = labelArray[i1].replace("\"", "");
						if (labelArray[i1].equalsIgnoreCase(FieldList.get(j))) {
							System.out.println("Verify the " + TextToBeDisplayed + " Fields:::" + element.getText());
							count++;
						}
						i1++;
					}
					i1 = 0;
					j++;
				}
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
			Utility_Functions.timeWait(1);
		}
		return count;
	}
	
	/*
	 * *******************************************************************
	 * Function Name: Validate whether the fields present on the page or not
	 * ******************************************************************
	 */
	

	public int xValidateFieldsPresentonPage(List<WebElement> WebElements, HashMap<String, String> hashMap,
			String TextToBeDisplayed) {
		int count = 0;
		String labelArray[] = new String[WebElements.size()];
		for (int i = 0; i < WebElements.size(); i++) {
			for (WebElement element : WebElements) {
				labelArray[i] = element.getText();
				for (Map.Entry<String, String> entry : hashMap.entrySet()) {
					if (labelArray[i].equals(entry.getKey())) {
						hashMap.put(entry.getKey(), entry.getValue());
						break;
					}
				}
			}
		}
		return count;
	}
	
	/*
	 * *******************************************************************
	 * Function Name: Validate whether the fields present on the page or not
	 * ******************************************************************
	 */
	
	
	public static int xValidateFieldsPresentonPage(String text, List<WebElement> WebElements, String TextToBeDisplayed) {
		int count = 0;
		if (WebElements.size() == 0) {
			System.out.println("There are no elements identified with the List<WebElement> xpath");
		} else {
			String labelArray[] = new String[WebElements.size()];
			int i1 = 0;
			try {
					for (WebElement element : WebElements) {
						labelArray[i1] = element.getText();
						if (labelArray[i1].equalsIgnoreCase(text)) {
							System.out.println("Verify the " + TextToBeDisplayed + " Fields:::" + element.getText());
							count++;
						}
						i1++;
					}
					i1 = 0;				
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
			Utility_Functions.timeWait(1);
		}
		return count;
	}
	/*
	 * *******************************************************************
	 * Function Name: Click on the element from the list of elements
	 * ******************************************************************
	 */

	public static void xClickElementFromList(List<WebElement> WebElements, String ElementToBeClicked) {
		try {
			for (WebElement element : WebElements) {
				if (element.getText().equalsIgnoreCase(ElementToBeClicked)) {
					element.click();
					break;
				}
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	/*
	 * *******************************************************************
	 * Function Name: Verify whether the element is present from the list or not
	 * ******************************************************************
	 */

	public static int xElementPresentFromList(ArrayList<String> ArrayList, String ElementPresent) {
		int count = 0;
		try {
			for (int i = 0; i < ArrayList.size(); i++) {
				if (ArrayList.get(i).equals(ElementPresent)) {
					count++;
					break;
				}
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return count;
	}
	

	/*
	 * *******************************************************************
	 * Function Name: findWebElementByXpath Author : CBRE SF Automation Purpose
	 * : Element finder by xpath
	 * @returns WebElement
	 * ******************************************************************
	 */

	public static WebElement findElement_ByXpath(CraftDriver driver, String element_xpath) {
		int count = 0;
		Utility_Functions.xWaitForElementPresent(driver, By.xpath(element_xpath), 5);
		count = driver.findElements(By.xpath(element_xpath)).size();
		if (count == 0) {
			System.out.println("The element is not found " + element_xpath);
			return null;
		}else{
			return driver.findElement(By.xpath(element_xpath));
		}
	}
	
	public String getRadioButton(String text){
		return "//a/div[text()='"+text+"']";
	}
	
	

    public static java.util.List<String> InitiateListValues(String[] values) {
 	   List<String> ListValues = new java.util.ArrayList<String>();
        for(int i = 0;i<values.length;i++){
          ListValues.add(values[i]);
        }
		return ListValues;
    }
    

	public static void scrollToViewElementAndClick(WebElement element) throws Exception{	
		try {
			Coordinates coordinate = ((Locatable)element).getCoordinates();
			int verticalY = coordinate.inViewPort().getY();
			int horiX = coordinate.inViewPort().getX();
			coordinate.inViewPort().moveBy(horiX, verticalY);
			timeWait(1);
			element.click();
			timeWait(2);
		} catch (Exception e) {
			// Added to prevent false erroring for referencing a "hidden" object
			System.out.println("Internal error: " + e.getMessage() + "\nContinuing after error.");
			e.printStackTrace();
		}
	  }
	
	/**
	 * This method checks if an element is present or not, and returns true or false accordingly
	 * @param driver
	 * @param by
	 * @return
	 */
	
	public static boolean isElementPresent(CraftDriver driver, By by) {  
	    driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);  
	    try {  
	    	driver.findElement(by);
	        return true;  
	    } 
	    catch (NoSuchElementException e) {  
	        return false;  
	    } 
	}
	
}
