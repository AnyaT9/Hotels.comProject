/**
 * 
 */
package utilities;

import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.AssertJUnit;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

/**
 * @author Anja T
 *
 */
public class WebDriverActivities {

	/*
	 * Change driver Name to Use diffrent driver Options: chrome / firefox /
	 */

	private static String driverName = "chrome";

	/*
	 * URL of the Site to be tested
	 */
	private static String siteUrl = "https://www.hotels.com/";

	/*
	 * System Informations
	 */
	private final static String operatingSystem = System.getProperty("os.name");
	private final static String operatingSystemVersion = System.getProperty("os.version");
	private final static String systemArchitecture = System.getProperty("os.arch");

	private final static String currentDirectory = System.getProperty("user.dir");
	private final static String fileSeparator = System.getProperty("file.separator");

	public static WebDriver myDriver = null;

	/*
	 * 
	 * Method executed Before Every Class
	 * 
	 */

	@BeforeClass(enabled = true)

	/*
	 * Open a WebDriver to run the test
	 */
	public static void openDriver() {

		String driverPath = currentDirectory + fileSeparator;

		if (driverName.equalsIgnoreCase("fireFox")) {
			myDriver = new FirefoxDriver();
		} else if (isWindows()) {

			driverPath = driverPath + "WinWebDrivers" + fileSeparator;
			if (driverName.equalsIgnoreCase("chrome")) {
				driverPath = driverPath + "chromedriver.exe";
				System.setProperty("webdriver.chrome.driver", driverPath);
				myDriver = new ChromeDriver();
			} else {
				System.out.println("No Driver Found!");
			}
		} else if (isMac()) {
			System.out.println("Crome Driver  to be Initialize..");
			driverPath = driverPath + "MacWebDrivers" + fileSeparator;
			if (driverName.equalsIgnoreCase("chrome")) {
				driverPath = driverPath + "chromedriver";

				System.setProperty("webdriver.chrome.driver", driverPath);

				myDriver = new ChromeDriver();

			} else {
				System.out.println("No Driver Found!");
			}

		} else if (isUnix()) {

			driverPath = driverPath + "UnixWebDrivers" + fileSeparator;
			if (driverName.equalsIgnoreCase("chrome")) {
				driverPath = driverPath + "chromedriver";
				System.setProperty("webdriver.chrome.driver", driverPath);
				myDriver = new ChromeDriver();
			} else {
				System.out.println("No Driver Found!");
			}

		} else {

			AssertJUnit.fail("Your OS is not supported!!");
		}

		myDriver.navigate().to(siteUrl);
		myDriver.manage().window().maximize();
		myDriver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
	}

	/*
	 * Is it a Windows OS ? Return: true / false
	 */
	private static boolean isWindows() {

		//return (operatingSystem.toLowerCase().indexOf("win") >= 0);

	}

	/*
	 * Is it a Mac OS ? Return: true / false
	 */
	private static boolean isMac() {

		return (operatingSystem.toLowerCase().indexOf("mac") >= 0);

	}

	/*
	 * Is it a Unix / Linux OS ? Return: true / false
	 */
	private static boolean isUnix() {

		return (operatingSystem.toLowerCase().indexOf("nix") >= 0 || operatingSystem.toLowerCase().indexOf("nux") >= 0);

	}

	/*
	 * 
	 * Method executed After Every Class
	 * 
	 */
	
	
	@AfterClass(enabled = true)
	public static void closeDriver() {

		myDriver.manage().deleteAllCookies();
		
		myDriver.close();
		myDriver.quit();
	}

}