package Test;

import org.testng.annotations.Test;

import utilities.WebDriverActivities;

/**
 * 
 */

/**
 * @author Anja T
 *
 */
public class TestNew extends WebDriverActivities{
	
	@Test
	public void test(){

	myDriver.get("http://facebook.com");
	myDriver.getTitle();
	myDriver.quit();
}

}
