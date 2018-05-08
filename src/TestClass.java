import java.util.concurrent.TimeUnit;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;



public class TestClass {


	@Test
	public void setUp(){
		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\nalla\\Downloads\\chromedriver.exe");
		
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
driver.get("https://test.salesforce.com/login.jsp?un=test.broker30@cbre.com.crm.devusadmin&pw=sfdc1234&startURL=/006W000000D2rUL");
		driver.findElement(By.id("thePage:inputForm:continue")).submit();
		driver.findElement(By.xpath("//div[@title='Sharing']")).click();
		
		//Add Button
		driver.findElement(By.name("new")).click();
		WebElement searchElement = driver.findElement(By.id("sharing_search"));
		Select select = new Select(searchElement);
		select.selectByVisibleText("Users");
		
		
		WebElement avaialbleUsers =  driver.findElement(By.id("duel_select_0"));
		Select auSelect = new Select(avaialbleUsers);
		auSelect.selectByValue("U:0051Y0000090C8s");
		
		
		
		
		
		
		
		
		
		
	}

}
