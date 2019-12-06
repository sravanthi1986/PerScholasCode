package com.perscholas.selenium_exercise_css_xpath.automation;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ExerciseOneTests {
	private static WebDriver driver;
	String actual;
	@BeforeClass
	public static void setUp() {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Student\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.get("http://localhost:8081/selenium_exercise_css_xpath/");
	}
	@AfterClass
	public static void shutDown() {
		//driver.close();
	}
	@Test
	@Ignore
	public void aTest() {
		//WebElement we = driver.findElement(By.cssSelector("header > h1"));
		WebElement we = driver.findElement(By.xpath("/html/body/header/nav/a[1]"));
		actual = we.getText();
		System.out.println(actual);
		assertEquals(actual,"Per Scholas");
	}
	@Test
	@Ignore
	public void titleTest() {
		actual = driver.getTitle();
		assertEquals(actual, "Selenium Exercise CSS XPath");
	}
	@Test
	@Ignore
	public void headerTest() {
		//WebElement we = driver.findElement(By.cssSelector("header > h1"));
		WebElement we = driver.findElement(By.cssSelector("	body > header > h1"));
		actual = we.getText();
		assertEquals(actual, "Selenium Exercise CSS XPath");
	}
	@Test
	@Ignore
	public void preceedingTest() {
		List<WebElement> preceedingNav = driver.findElements(By.xpath("//nav//preceding::*"));
		StringBuilder sb = new StringBuilder();
		for (WebElement we : preceedingNav) {
			sb.append(we.getTagName() + " ");
		}
		String actual = sb.toString().trim();
		System.out.println(sb);
		assertEquals(actual, "head meta title link style script h1 a a a");
	}
	@Test
	@Ignore
	public void followingTest() {
		List<WebElement> preceedingNav = driver.findElements(By.xpath("//body/div[last()]//following::*"));
		for (WebElement we : preceedingNav) {
			System.out.print(we.getTagName() + " - ");
		}
		System.out.println();
	}
	@Test	
	@Ignore
	public void ancestorTest() {
		List<WebElement> ancestorsOfSecondTR = driver.findElements(By.xpath("//*/table/tbody/tr[2]//ancestor::*"));
		for (WebElement we : ancestorsOfSecondTR) {
			System.out.print(we.getTagName() + " - ");
		}
		System.out.println();
	}
	@Test	
	public void stateTest() {
		List<WebElement> stateListUl = driver.findElements(By.xpath("//*[@id=\"one_right\"]/ul[2]//child::*"));
		List<String> stateList = new ArrayList<String>();
		StringBuilder sb = new StringBuilder();
		for (WebElement we : stateListUl) {
			System.out.println(we.getText());
			//stateList.add(we.getText());
			sb.append(we.getText());
		}
		String actual = sb.toString().trim();
		System.out.println(actual);
		assertThat(actual, containsString("Texas"));
		assertThat(actual, containsString("California"));

	}
	@Test
	@Ignore
	public void CityTest() {
		List<WebElement> stateListUl = driver.findElements(By.xpath("//*[@id=\"one_right\"]/ul[1]//child::*"));
		List<String> stateList = new ArrayList<String>();
		StringBuilder sb = new StringBuilder();
		for (WebElement we : stateListUl) {
			System.out.println(we.getText());
			//stateList.add(we.getText());
			sb.append(we.getText());
		}
		String actual = sb.toString().trim();
		System.out.println(actual);
		assertThat(actual, containsString("Dallas"));
		assertThat(actual, containsString("New York"));

}
	@Test
	@Ignore
	public void SpanTest() {
		WebElement we = driver.findElement(By.cssSelector("#row_two > p:nth-child(2) > span:nth-child(2)"));
		actual = we.getText();
		System.out.println(actual);

		assertEquals(actual, "Per Scholas");
	}
	@Test
	@Ignore
	public void RowTest() {
		WebElement we = driver.findElement(By.cssSelector("#row_two > p:nth-child(3) > span:nth-child(2)"));
		actual = we.getText();
		System.out.println(actual);
        assertEquals(actual, "Quality Engineering and Assurance");
	}
	@Test
	@Ignore
	public void LinkTest() {
		List<WebElement> linkListUl = driver.findElements(By.xpath("/html/body/div[4]/ul//child::*"));
		StringBuilder sb = new StringBuilder();
		for (WebElement we : linkListUl) {
			System.out.println(we.getText());
			
			sb.append(we.getText());
		}
		String actual = sb.toString().trim();
		//System.out.println(actual);
		assertThat(actual, containsString("Corporate"));
		assertThat(actual, containsString("Careers"));
		assertThat(actual, containsString("Customer Service"));
		//assertThat(actual, containsString("charm"));
		//assertFalse(actual, containsString("charm"));

}
	@Test
	@Ignore
	public void GlinkTest() {
				
		driver.findElement(By.cssSelector("body > div:nth-child(6) > a.fa.fa-google")).click();
		//driver.findElement(By.className("fa-google")).click();
		//driver.findElement(By.xpath("/html/body/div[4]/a[3]")).click();

		String mainTitle = driver.getTitle();
		System.out.println(mainTitle);
        assertThat(mainTitle, equalTo("Google"));
        
		String url = driver.getCurrentUrl();
		System.out.println(url);
        assertThat(url, equalTo("https://www.google.com/"));
		
		
	}
	@Test
	public void facebookTitle() {
		String w=driver.findElement(By.cssSelector("body > div:nth-child(6) > a.fa.fa-facebook")).getAttribute("title");
		
		System.out.println(w);
		assertThat(w,equalTo("Facebook"));
	}
	@Test
	@Ignore
	public void DailogboxTesr() {
		String actual;
		WebElement name = driver.findElement(By.cssSelector("body > fieldset > form > div:nth-child(1) > input"));
		name.sendKeys("sravs");
		WebElement email = driver.findElement(By.cssSelector("body > fieldset > form > div:nth-child(2) > input"));
         email.sendKeys("sravs.cqq@gmail.com");
         WebElement submitButton = driver.findElement(By.cssSelector("body > fieldset > form > div:nth-child(3) > input[type=submit]"));
 		submitButton.click();
		actual = driver.switchTo().alert().getText(); 			
		System.out.println(actual);
		 assertThat(actual, equalTo("Thank you sravs for signing up! A welcome message will be sent to sravs.cqq@gmail.com."));
	}
	@Test
	@Ignore
	public void childTest() {
		List<WebElement> childrenOfLastDiv = driver.findElements(By.xpath("//body/div[last()]//child::*"));
		for (WebElement we : childrenOfLastDiv) {
			System.out.print(we.getTagName() + " ");
		}
		System.out.println();
	}
}