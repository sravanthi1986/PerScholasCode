package com.perscholas.qeb_selenium_lesson.features;

import static org.hamcrest.CoreMatchers.containsString;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

import java.util.concurrent.TimeUnit;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class ExcerciseTest {
	private static WebDriver driver;
	String actual;
	@BeforeClass
	public static void setUp() {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Student\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.get("http://localhost:8081/qeb_selenium_lesson/");
	}
	@AfterClass
	public static void shutDown() {
		//driver.close();
	}
	@Test
	@Ignore
	public void SignupTest() {
		
		WebElement name = driver.findElement(By.xpath("//*[@id=\"name_input\"]"));
		name.sendKeys("bujji");
		WebElement email = driver.findElement(By.xpath("//*[@id=\"email_input\"]"));
		email.sendKeys("bujji@gmail.com");
		WebElement password = driver.findElement(By.xpath("//*[@id=\"password_input\"]"));
		password.sendKeys("bujji");
		WebElement radioDallas = driver.findElement(By.xpath("//*[@id=\"signup_form\"]/div[4]/input[1]"));
		radioDallas.click();
        WebElement radioIrving = driver.findElement(By.xpath("//*[@id=\"signup_form\"]/div[4]/input[2]"));
        radioIrving.click();

		Select courses = new Select(driver.findElement(By.name("course")));
		// Set the input value by selecting one of the option elements
		courses.selectByValue("Application Support Management");		
		driver.findElement(By.cssSelector("#course_select > option:nth-child(1)")).click();
		//actual = driver.findElement(By.cssSelector("#resultsFieldset > p:nth-child(2)")).getText();
		//assertThat(actual, containsString("Data Engineering"));
		
         
		WebElement csharp = driver.findElement(By.cssSelector("#signup_form > div:nth-child(6) > input:nth-child(2)"));
		csharp.click();
		WebElement java = driver.findElement(By.cssSelector("#signup_form > div:nth-child(6) > input:nth-child(4)"));
		java.click();
		WebElement python = driver.findElement(By.cssSelector("#signup_form > div:nth-child(6) > input:nth-child(6)"));
		python.click();
		WebElement swift = driver.findElement(By.cssSelector("#signup_form > div:nth-child(6) > input:nth-child(8)"));
        swift.click();
		WebElement availCal = driver.findElement(By.cssSelector("#startdate_input"));
		availCal.sendKeys("09092019");
        WebElement submitButton = driver.findElement(By.cssSelector("#signup_form > div:nth-child(8) > input[type=submit]"));
		submitButton.click();
		WebElement output=driver.findElement(By.cssSelector("body > h1"));
		System.out.println(output.getText());
		assertEquals(output.getText(),"Congratulations! You're signed up.");
	}
	
	@Test
	@Ignore
	public void MenuTest() {
		WebElement menuButton = driver.findElement(By.cssSelector("body > header > div > button"));
		menuButton.click();
		// Set the input value by selecting one of the option elements
		driver.findElement(By.cssSelector("body > header > div > div > a:nth-child(4)")).click();
		
	}
	@Test
	public void BookTest() {
		WebElement menuButton = driver.findElement(By.cssSelector("body > header > div > button"));
		menuButton.click();
		// Set the input value by selecting one of the option elements
		driver.findElement(By.cssSelector("body > header > div > div > a:nth-child(3)")).click();
		driver.findElement(By.cssSelector("#book1Add")).click();
		driver.findElement(By.cssSelector("#book_list > div > div:nth-child(4) > form > input[type=submit]")).click();
		WebElement output=driver.findElement(By.cssSelector("body > p"));
		System.out.println(output.getText());
		assertEquals(output.getText(),"Your order is confirmed!");
		
	}
}
