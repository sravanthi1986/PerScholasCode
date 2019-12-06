package com.perscholas.selenium_cucumber_template.automation;

import static org.hamcrest.CoreMatchers.containsString;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertThat;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PerscholasTest {
	
	private static WebDriver driver;
	private static WebDriverWait  wait;
	String actual;
	@BeforeClass
	public static void setUp() {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Student\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		wait =  new WebDriverWait(driver,30);
		driver.get("https://perscholas.org/");
	}
	@AfterClass
	public static void shutDown() {
	driver.close();
	}

	@Test
	@Ignore
    public void TitleTest() {
		actual = driver.getTitle();
        System.out.println(actual);
		assertEquals(actual, "Per Scholas");
	}
	@Test
	
	public void GreaterBoston() {
		StringBuilder sb = new StringBuilder();
		driver.findElement(By.cssSelector(".dropdown > #mapToggle")).click();
        driver.findElement(By.cssSelector(".list-group-item:nth-child(6) > a")).click();
        driver.findElement(By.cssSelector("#header > nav.subNav.navbar.navbar-default.affix-top > div > div.hidden-xs > ul > li:nth-child(1) > a")).click();
        driver.findElement(By.cssSelector("#people > div > div:nth-child(3) > a")).click();
        
        List<WebElement> bostonStaffList = driver.findElements(By.cssSelector("#greater-boston-team > div"));
		for(WebElement webElmt : bostonStaffList) {
			sb.append(webElmt.getText());
			System.out.println(sb);
		}
		String actual = sb.toString().trim();
		assertThat(actual, containsString("Robin Nadeau"));
		assertFalse(actual.contains("Jake McIntosh"));



	}

}
