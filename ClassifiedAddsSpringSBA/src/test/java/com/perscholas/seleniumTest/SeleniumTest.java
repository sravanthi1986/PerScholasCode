package com.perscholas.seleniumTest;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;



public class SeleniumTest {

	    @Test public void login() { // TODO Auto-generated method stub 
	  System.setProperty("webdriver.chrome.driver", "C:\\Users\\Student\\eclipse-workspace.chromedriver.exe"); 
	  WebDriver driver=new ChromeDriver(); driver.manage().window().maximize(); 
	  driver.get("http://localhost:8081/hibernate_validation_dao/"); 
	  WebElement username=driver.findElement(By.id("UserName")); 
	  WebElement password=driver.findElement(By.id("Password")); 
	  WebElement login=driver.findElement(By.xpath("//button[text()='Sign in']")); 
	  username.sendKeys("example@gmail.com"); password.sendKeys("password"); 
	  login.click(); String actualUrl="http://localhost:8081/hibernate_validation_dao/"; 
	  String expectedUrl= driver.getCurrentUrl(); 
	  Assert.assertEquals(expectedUrl,actualUrl); 


}
}