package com.perscholas.servlet.automationtest;

import static org.junit.Assert.assertTrue;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ServletJspAutomationTest {
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
    }
    @AfterClass
    public static void shutDown() {
//        driver.close();
    }
    @Test
    public void test() {
    	WebElement we=driver.findElement(By.cssSelector("h1"));
    	String actuals=we.getText();
    	assertTrue(actuals.equals("hello welcome to college....."));
    }
//   @Test
//   public void testperscholaslink() {
//	   driver.findElement(By.cssSelector("a")).click();
//	   String actual=driver.getTitle();
//	   assertTrue(actual.contentEquals("Per Scholas"));
//	   
//	   }
   @Test
   public void testSecondParagraphtest() {
	   
	  WebElement we = driver.findElement(By.cssSelector("p:nth-child(4)"));
	        String actual = we.getText();
	        System.out.println();
	        assertTrue(actual.equals("sravs"));
	    }
   @Test
   public void testSecondParagraph() {
	   WebElement we = driver.findElement(By.cssSelector("body > div > p"));
       String actual = we.getText();
       System.out.println(actual);
       assertTrue(actual.equals("bujji"));
}
   @Test
	public void xPathContainsStartsWith() {
	

	   
   }
}