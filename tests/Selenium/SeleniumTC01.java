package Selenium;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.io.FileInputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import functions.SnapshotFunction;

import functions.Facility_ManagerFunctions;
import junitparams.FileParameters;
import junitparams.JUnitParamsRunner;

@RunWith(JUnitParamsRunner.class)
public class SeleniumTC01 extends Facility_ManagerFunctions {
	private WebDriver driver;
	private String baseUrl;
	private boolean acceptNextAlert = true;
	private StringBuffer verificationErrors = new StringBuffer();
	public Properties prop;
	public static String sAppURL, sSharedUIMapPath;

	private SnapshotFunction snap = new SnapshotFunction();

	@Before
	public void setUp() throws Exception {
		System.setProperty("webdriver.chrome.driver", "C:/ChromeDriver/chromedriver.exe");
		driver = new ChromeDriver();
		baseUrl = "http://localhost:8080/";
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		prop = new Properties();
		prop.load(new FileInputStream("tests/configuration/FM_Configuration.properties"));
		sAppURL = prop.getProperty("sAppURL");
		sSharedUIMapPath = prop.getProperty("SharedUIMap");

		prop.load(new FileInputStream(sSharedUIMapPath));
	}

	@Test
	@FileParameters("tests/Excel/TC01a_test_cases_Admin.csv")
	public void TC01a(int testCaseNumber, String username, String password, String lastname, String errorMessage)
			throws Exception {
//		driver.get(baseUrl + "/Mac_Facility/");
		driver.get(sAppURL);

		String methodName = new Throwable().getStackTrace()[0].getMethodName();

		// Login
		driver.findElement(By.xpath(prop.getProperty("Login_username_text"))).clear();
		driver.findElement(By.xpath(prop.getProperty("Login_username_text"))).sendKeys(username);
		driver.findElement(By.xpath(prop.getProperty("Login_password_text"))).clear();
		driver.findElement(By.xpath(prop.getProperty("Login_password_text"))).sendKeys(password);
		driver.findElement(By.xpath(prop.getProperty("Login_login_btn"))).click();

		// Search User passing last name value from csv file
		Thread.sleep(1_000);

		// click on search user
		driver.findElement(By.xpath(prop.getProperty("searchUser_UserSearchLink"))).click();

		Thread.sleep(1_000);

		// enter value in lastname text box
		driver.findElement(By.xpath(prop.getProperty("searchUser_LastNameValue"))).sendKeys(lastname);

		snap.takeScreenshot(driver, methodName + " searchUser test case " + testCaseNumber);

		Thread.sleep(1_000);

		driver.findElement(By.xpath(prop.getProperty("searchUser_SubmitButton"))).click();

		Thread.sleep(1_000);

		// Getting Error message and checking it against csv file value
		if (testCaseNumber != 1) {
			assertEquals(errorMessage, driver.findElement(By.name("lastNameError")).getAttribute("value"));
			assertTrue(driver.findElement(By.name("lastNameError")).getAttribute("value").equals(errorMessage));
		}

		snap.takeScreenshot(driver, methodName + " verifySearchUserErrorMessages test case " + testCaseNumber);
		driver.findElement(By.xpath(prop.getProperty("searchUser_MAC_FacilityMgtAppLink"))).click();
	}

	@Test
	@FileParameters("tests/Excel/TC03_Test_Cases_Admin.csv")
	public void verifyAllLinks(int testcaseNum, String link, String title) throws Exception {

		driver.get(sAppURL);

		Thread.sleep(1000);

//		FM_Login(driver, "Prempatel", "Prempatel@123");

		// Login
		driver.findElement(By.xpath(prop.getProperty("Login_username_text"))).clear();
		driver.findElement(By.xpath(prop.getProperty("Login_username_text"))).sendKeys("Prempatel");
		driver.findElement(By.xpath(prop.getProperty("Login_password_text"))).clear();
		driver.findElement(By.xpath(prop.getProperty("Login_password_text"))).sendKeys("Prempatel@123");
		driver.findElement(By.xpath(prop.getProperty("Login_login_btn"))).click();

		Thread.sleep(1000);

		driver.findElement(By.linkText(prop.getProperty(link))).click();

		try {
			String methodName = new Throwable().getStackTrace()[0].getMethodName();
			takeScreenshot(driver, "FacilityManagerTest" + methodName + testcaseNum);
			assertEquals(title, driver.getTitle());
		} catch (Error e) {
			verificationErrors.append(e.toString());
		}
		Thread.sleep(1000);
	}

	@After
	public void tearDown() throws Exception {
		driver.quit();
		String verificationErrorString = verificationErrors.toString();
		if (!"".equals(verificationErrorString)) {
			fail(verificationErrorString);
		}
	}

//	private boolean isElementPresent(By by) {
//		try {
//			driver.findElement(by);
//			return true;
//		} catch (NoSuchElementException e) {
//			return false;
//		}
//	}
//

}
