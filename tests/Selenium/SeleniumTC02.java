package Selenium;

import static org.junit.Assert.assertTrue;

import static org.junit.Assert.fail;

import java.io.FileInputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import functions.SnapshotFunction;
import junitparams.FileParameters;
import junitparams.JUnitParamsRunner;

@RunWith(JUnitParamsRunner.class)
public class SeleniumTC02 {
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
	@FileParameters("tests/Excel/TC02a_test_cases_Admin.csv")
	public void TC02a(int testCaseNumber, String username, String password, String username_test, String errorMessage)
			throws Exception {

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

		// click on change user role
		driver.findElement(By.xpath(prop.getProperty("changeUserRole_ChangeRoleLink"))).click();

		Thread.sleep(1_000);

		// enter value in Username text box
		driver.findElement(By.xpath(prop.getProperty("changeUserRole_UserNameValue"))).sendKeys(username_test);

		snap.takeScreenshot(driver, methodName + " changeUserRole test case " + testCaseNumber);

		Thread.sleep(1_000);

		// click submit
		driver.findElement(By.xpath(prop.getProperty("changeUserRole_submitButton"))).click();
		Thread.sleep(1_000);

		// html/body/table/tbody/tr/td/form/table/tbody/tr[2]/td[3]/input
		assertTrue(driver.findElement(By.name("usernameError")).getAttribute("value").equals(errorMessage));

		snap.takeScreenshot(driver, methodName + " verifyChangeUserRoleErrorMessages test case " + testCaseNumber);

		driver.findElement(By.xpath(prop.getProperty("changeUserRole_MAC_FacilityMgtAppLink"))).click();
	}

	@After
	public void tearDown() throws Exception {
		driver.quit();
		String verificationErrorString = verificationErrors.toString();
		if (!"".equals(verificationErrorString)) {
			fail(verificationErrorString);
		}
	}

	private boolean isElementPresent(By by) {
		try {
			driver.findElement(by);
			return true;
		} catch (NoSuchElementException e) {
			return false;
		}
	}

	private boolean isAlertPresent() {
		try {
			driver.switchTo().alert();
			return true;
		} catch (NoAlertPresentException e) {
			return false;
		}
	}

	private String closeAlertAndGetItsText() {
		try {
			Alert alert = driver.switchTo().alert();
			String alertText = alert.getText();
			if (acceptNextAlert) {
				alert.accept();
			} else {
				alert.dismiss();
			}
			return alertText;
		} finally {
			acceptNextAlert = true;
		}
	}
}
