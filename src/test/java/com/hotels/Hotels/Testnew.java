package com.hotels.Hotels;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class Testnew {
	
	
	
	@Test
	public void test(){
	System.setProperty("webdriver.chrome.driver","C:\\Users\\Romi1\\Downloads\\chromedriver_win32\\chromedriver.exe");
	WebDriver driver = new ChromeDriver();
	driver.get("http://facebook.com");
	driver.getTitle();
	driver.quit();
}
}