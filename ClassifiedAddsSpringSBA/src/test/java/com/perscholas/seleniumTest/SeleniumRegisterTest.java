package com.perscholas.seleniumTest;

import org.junit.BeforeClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SeleniumRegisterTest {
	
	private static WebDriver driver;
	@BeforeClass
	public static void setUp() {
		System.setProperty("webdriver.chrome.driver", "C:\\\\Users\\\\Student\\\\eclipse-workspace.chromedriver.exe");
		driver = new ChromeDriver();
	driver.get("http://localhost:8081/hibernate_validation_dao/register");
	  

    }
}
