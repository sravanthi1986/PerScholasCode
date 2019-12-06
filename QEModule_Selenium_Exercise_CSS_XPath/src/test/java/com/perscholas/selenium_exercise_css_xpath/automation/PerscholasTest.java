package com.perscholas.selenium_exercise_css_xpath.automation;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.not;
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

public class PerscholasTest {
	
	private static WebDriver driver;
	String actual;
	@BeforeClass
	public static void setUp() {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Student\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.get("https://perscholas.org/");
	}
	@AfterClass
	public static void shutDown() {
		//driver.close();
	}

	@Test
    @Ignore
	public void TitleTest() {
		actual = driver.getTitle();
        System.out.println(actual);
		//assertEquals(actual, "Home");
	}
	@Test
	@Ignore
	public void ClickPageTest() {
	    driver.findElement(By.xpath("//*[@id=\"header\"]/nav[1]/div/div[2]/ul/li[1]/a")).click();
	    driver.findElement(By.xpath("//*[@id=\"people\"]/div/div[3]/a")).click();
	}
	@Test
	@Ignore
	public void LocatingElements() {
	    driver.findElement(By.xpath("//*[@id=\"header\"]/nav[1]/div/div[2]/ul/li[1]/a")).click();
	    driver.findElement(By.xpath("//*[@id=\"people\"]/div/div[3]/a")).click();
	    driver.findElement(By.xpath("//*[@id=\"senior-leadership-team\"]/div/div[1]/a/div/hgroup/h5")).click();
		WebElement we = driver.findElement(By.cssSelector("#main > div > div > div > div.col-sm-8 > h1"));
        actual=we.getText();
        System.out.println(actual);
        assertEquals(actual,"Plinio Ayala");

        }
	@Test
	@Ignore
	public void StaffTest() {
		StringBuilder sb = new StringBuilder();
		driver.findElement(By.xpath("//*[@id=\"header\"]/nav[1]/div/div[2]/ul/li[1]/a")).click();
	    driver.findElement(By.xpath("//*[@id=\"people\"]/div/div[3]/a")).click();
	    List<WebElement> staffLists= driver.findElements(By.cssSelector("hgroup h5"));
	   for(WebElement we : staffLists) {
	    System.out.println(we.getText());
		sb.append(we.getText());

	   }
	   actual = sb.toString().trim();
		assertThat(actual, containsString("Sarah Hoenle"));
		assertThat(actual, containsString("Charlie de la Rosa"));

	}
	@Test
	public void StaffDallasTest() {
		StringBuilder sb = new StringBuilder();
		driver.findElement(By.xpath("//*[@id=\"header\"]/nav[1]/div/div[2]/ul/li[1]/a")).click();
	    driver.findElement(By.xpath("//*[@id=\"people\"]/div/div[3]/a")).click();
	    List<WebElement> staffLists= driver.findElements(By.cssSelector("#staff-dallas hgroup h5"));
	   for(WebElement we : staffLists) {
	    System.out.println(we.getText());
		sb.append(we.getText());

	   }
	   actual = sb.toString().trim();
		assertThat(actual, containsString("Salah Sheber"));
		assertThat(actual, containsString("Charlie de la Rosa"));
	    assertThat(actual, is(not("Montreece Smith")));

	}
	@Test
	public void CustomizedTrainingDallasTest() {
		StringBuilder sb = new StringBuilder();
		driver.findElement(By.xpath("//*[@id=\"header\"]/nav[1]/div/div[2]/ul/li[1]/a")).click();
	    driver.findElement(By.xpath("//*[@id=\"people\"]/div/div[3]/a")).click();
	    List<WebElement> staffLists= driver.findElements(By.cssSelector("#customized-training-dallas hgroup h5"));
	   for(WebElement we : staffLists) {
	    System.out.println(we.getText());
		sb.append(we.getText());

	   }
	   actual = sb.toString().trim();
		assertThat(actual, containsString("Salah Sheber"));
		assertThat(actual, containsString("Charlie de la Rosa"));
	    assertThat(actual, is(not("Montreece Smith")));

	}
}
