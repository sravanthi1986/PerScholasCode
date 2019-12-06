package com.perscholas.selenium_javascript.automation;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.number.OrderingComparison.lessThanOrEqualTo;
import static org.hamcrest.number.OrderingComparison.greaterThanOrEqualTo;

import static org.junit.Assert.assertThat;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.concurrent.TimeUnit;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class SeleniumJavaScriptTest {	
	private static WebDriver driver;
	private static JavascriptExecutor js;
	
	@BeforeClass
	public static void setUp() throws IOException {
		System.setProperty("webdriver.chrome.driver", "/Users/Charlie/Documents/"
				+ "Programming/ProgrammingProjects/Java/chromedriver");
		driver = new ChromeDriver();
		driver.get("http://localhost:8080/selenium_javascript/HomeServlet");
		js = (JavascriptExecutor)driver;
		/* The default script timeout is 30 seconds, but it is good pratice to set 
		 * it to a custom value to maximize efficiency. */
		driver.manage().timeouts().setScriptTimeout(10, TimeUnit.SECONDS);
	}
	@AfterClass
	public static void tearDown() throws InterruptedException {
		driver.close();
	}
	/* The first example is a simple JavaScript alert. The driver executor creates 
	 * the alert and the driver retrieves the text to test it and then accepts it which 
	 * is the equivalent of clicking "OK". */
	@Test
	public void javaScriptSimpleAlertTest() throws IOException, InterruptedException {
		js.executeScript("alert('Test Message');");
		String actual = driver.switchTo().alert().getText();
		Thread.sleep(2000);
		driver.switchTo().alert().accept();
		assertThat(actual, equalTo("Test Message"));
	}
	/* The next test locates a link by it's ID and then clicks on the link using 
	 * the JavaScript executor. This is identical to the WebElement.click() 
	 * function. */
	@Test
	public void javaScriptClickLink() {
		WebElement aOne = driver.findElement(By.id("a1"));
		js.executeScript("arguments[arguments.length-1].click();", aOne);
		String actual = driver.findElement(By.id("inlineScript")).getText();
		assertThat(actual, containsString("inline script"));
	}
	/* This test calls a JavaScript custom function written in the JavaServer Page 
	 * between <script> tags. */
	@Test
	public void javaScriptRunFunction() {
		js.executeScript("createNewElement1();");
		String actual = driver.findElement(By.id("header3")).getText();
		assertThat(actual, containsString("This script creates this new h3 element."));
	}
	/* The next two test methods demonstrate the difference between "executeScript()" 
	 * and "executeAsyncScript()" using the "window.setTimeout()" method. The 
	 * "javaScriptSyncTest()" method uses the "executeScript()" method to call the 
	 * JavaScript method, but will not wait for it's completion. This will be reflected 
	 * in the two timestamps which will vary by only a few milliseconds. The test 
	 * method "javaScriptAsyncTest()" uses the "executeAsyncScipt()" which forces 
	 * Selenium to wait until the JavaScript method has completed. In this case, 
	 * there will be a delay of three seconds and the time difference ("actual") 
	 * will reflect this. */
	@Test
	public void javaScriptSyncTest() {
		long startSync = LocalDateTime.now().getSecond();
		js.executeScript("window.setTimeout(arguments[arguments.length-1], 3000)");
		long endSync = LocalDateTime.now().getSecond();
		long actual = endSync - startSync;
		System.out.println("Actual sync difference: " + actual);
		assertThat(actual, lessThanOrEqualTo(1L));
	}
	@Test
	public void javaScriptAsyncTest() {
		long startAsync = LocalDateTime.now().getSecond();
		js.executeAsyncScript("window.setTimeout(arguments[arguments.length-1], 3000)");
		long endAsync = LocalDateTime.now().getSecond();
		long actual = endAsync - startAsync;
		System.out.println("Actual async difference: " + actual);
		assertThat(actual, greaterThanOrEqualTo(2L));
	}
}