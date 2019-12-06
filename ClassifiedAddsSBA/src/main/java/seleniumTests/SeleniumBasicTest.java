package seleniumTests;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import org.hamcrest.text.IsEqualIgnoringCase;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class SeleniumBasicTest {

	private static WebDriver driver;
	@BeforeClass
	public static void setUp() {
		/***************************/
		//Make sure you know the location of your chrome driver!!!!!!!!
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Student\\Desktop\\chromeDriver\\chromedriver.exe");
				
		driver = new ChromeDriver();
		
		//Sets the webpage that is inside the driver
		driver.get("http://localhost:8080/hibernate_validation_repository/");
	}
	
	//Asserts whether the title is the same as the expected
	@Test
	  public void testRegisterUser() {
	    driver.get("http://localhost:8080/hibernate_validation_repository/");
	    driver.manage().window().setSize(new Dimension(1296, 696));
	    driver.findElement(By.linkText("Register")).click();
	    driver.findElement(By.id("username")).click();
	    driver.findElement(By.id("username")).sendKeys("TestUsername");
	    driver.findElement(By.id("password")).click();
	    driver.findElement(By.id("password")).sendKeys("TestPassword");
	    driver.findElement(By.cssSelector("input:nth-child(3)")).click();
	  }
		
	@Test
	  public void testSignIn() {
	    driver.get("http://localhost:8080/hibernate_validation_repository/");
	    driver.manage().window().setSize(new Dimension(1050, 660));
	    driver.findElement(By.id("username")).click();
	    driver.findElement(By.id("username")).sendKeys("test");
	    driver.findElement(By.cssSelector("div:nth-child(1) > div")).click();
	    driver.findElement(By.id("password")).click();
	    driver.findElement(By.id("password")).sendKeys("test");
	    driver.findElement(By.cssSelector("#user > div:nth-child(2)")).click();
	    driver.findElement(By.cssSelector("input:nth-child(3)")).click();
	    assertThat(driver.getTitle(), is("Adds"));
	  }


	  @Test
	  public void testNewItem() {
	    driver.get("http://localhost:8080/hibernate_validation_repository/");
	    driver.manage().window().setSize(new Dimension(1050, 660));
	    driver.findElement(By.id("user")).click();
	    driver.findElement(By.id("username")).click();
	    driver.findElement(By.id("username")).sendKeys("test");
	    driver.findElement(By.cssSelector("div:nth-child(1)")).click();
	    driver.findElement(By.id("password")).click();
	    driver.findElement(By.id("password")).sendKeys("test");
	    driver.findElement(By.id("user")).click();
	    driver.findElement(By.cssSelector("input:nth-child(3)")).click();
	    driver.findElement(By.id("item")).click();
	    driver.findElement(By.id("item")).sendKeys("testItem");
	    driver.findElement(By.id("price")).click();
	    driver.findElement(By.id("price")).sendKeys("50.50");
	    driver.findElement(By.cssSelector("input:nth-child(3)")).click();
	  }

	
	
	
	

}