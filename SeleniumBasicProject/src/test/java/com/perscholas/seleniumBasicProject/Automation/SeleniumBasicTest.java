package com.perscholas.seleniumBasicProject.Automation;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.*;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class SeleniumBasicTest {

	
	private static WebDriver driver;
	@BeforeClass
	public static void setUp() {
		/* The System.setProperty() method accepts two strings as arguments. Be sure 
		 * these strings align with the particular WebDriver that you intend to use 
		 * and the location of the WebDriver file on your computer. In this example, 
		 * we are using the Chrome WebDriver and then providing the path to the 
     		 * location of the WebDriver file on the device used to create this project. 
                 * Also note that the filename must include .exe on Windows computers */
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Student\\Downloads\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver();
	driver.get("http://localhost:8080/ServletJspProject/HomeServlet");
	  driver.get("http://perscholas.org");
	}
	@AfterClass
	public static void shutDown() {
		driver.close();
	}

	@Test
	public void test() {
         WebElement we=driver.findElement(By.cssSelector("#main > div>div>div>div>h1"));
         String actual=we.getText();
         assertThat(actual,equalTo("TECHNOLOGY AT WORK"));
	}
	@Test
	public void clickTest() {
		WebElement we=driver.findElement(By.cssSelector("#header > nav.subNav.navbar.navbar-default.affix-top > div > div.hidden-xs > ul > li.active > a"));
		we.click();
	}
	@Test
	public void inputTest() {
		driver.get("http://google.com");
		WebElement qfeild=driver.findElement(By.name("q"));
		qfeild.sendKeys("Selenium Jobs");
	
	}

}
