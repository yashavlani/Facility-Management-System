package functions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import ScreenShots.*;
import static org.junit.Assert.assertTrue;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
@SuppressWarnings("unused")
public class RepairerFunctions {

		  private SnapshotFunction snap = new SnapshotFunction();
		  public WebDriver driver;
		  public Properties prop;
		  public enum FunctionEnum {listReservation, requestReservation, modifyReservation, cancelReservation}
		  
		  public WebDriver invokeCorrectBrowser () {
				System.setProperty("webdriver.chrome.driver", "c:/ChromeDriver/chromedriver.exe");
			    return new ChromeDriver();
/*				System.setProperty("webdriver.firefox.marionette", "C:\\GeckoSelenium\\geckodriver.exe");
			    return new FirefoxDriver();
*/		  }

		  public void takeScreenShot (WebDriver driver, String snapShotName) {
			    snap.takeScreenshot(driver, snapShotName);
			    try {
//				    Change the thread value to run test files with delay
					Thread.sleep(0);
				} catch (InterruptedException e) {}
		  }
		  
		  public void MAC_Login(WebDriver driver, String sUserName, String sPassword,String snapShotName) {
			  	driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
				driver.findElement(By.xpath(prop.getProperty("Login_username_text"))).clear();
			    driver.findElement(By.xpath(prop.getProperty("Login_username_text"))).sendKeys(sUserName);
			    driver.findElement(By.xpath(prop.getProperty("Login_password_text"))).clear();
			    driver.findElement(By.xpath(prop.getProperty("Login_password_text"))).sendKeys(sPassword);
			    driver.findElement(By.xpath(prop.getProperty("Login_login_btn"))).click();
			    takeScreenShot(driver,snapShotName);
			}
		  
		  public void MainApp_function (WebDriver driver, FunctionEnum function) {
			  switch (function) {
			  	case listReservation:
				    driver.findElement(By.xpath(prop.getProperty("MainApp_ListReservationLink"))).click(); //select List Company from homepage
				    break;
			  	case requestReservation:
			  	    driver.findElement(By.xpath(prop.getProperty("MainApp_RequestReservationLink"))).click(); //select Insert Company from homepage
			  	    break;
			  	case modifyReservation:
			  	    driver.findElement(By.xpath(prop.getProperty("MainApp_ModifyReservationLink"))).click(); //select Insert Company from homepage
			  	    break;
			  	case cancelReservation:
			  	    driver.findElement(By.xpath(prop.getProperty("MainApp_CancelReservationLink"))).click(); //select Insert Company from homepage
			  }
		  }
		  
		  public void verifyHeaders(WebDriver driver, String header1OnPage, String expectedHeader1Name,String header2OnPage, String expectedHeader2Name,
				  									String header3OnPage, String expectedHeader3Name,String header4OnPage, String expectedHeader4Name, 
				  									String header5OnPage, String expectedHeader5Name, String snapShotName) {
			  System.out.println(header1OnPage);
			  System.out.println(driver.findElement(By.xpath(prop.getProperty(header1OnPage))).getText());

			  
			  System.out.println(expectedHeader1Name);
			    assertTrue(driver.findElement(By.xpath(prop.getProperty(header1OnPage))).getText().equals(expectedHeader1Name));
			    assertTrue(driver.findElement(By.xpath(prop.getProperty(header2OnPage))).getText().equals(expectedHeader2Name));
			    assertTrue(driver.findElement(By.xpath(prop.getProperty(header3OnPage))).getText().equals(expectedHeader3Name));
			    assertTrue(driver.findElement(By.xpath(prop.getProperty(header4OnPage))).getText().equals(expectedHeader4Name));
			    if (!header5OnPage.equals(""))
			    	assertTrue(driver.findElement(By.xpath(prop.getProperty(header5OnPage))).getText().equals(expectedHeader5Name));
			    takeScreenShot(driver,snapShotName);
		  }
		  
		  public void verifyContents(WebDriver driver, String col1ValueOnPage, String expectedcol1Value,String col2ValueOnPage, String expectedcol2Value,
												String col3ValueOnPage, String expectedcol3Value,String col4ValueOnPage, String expectedcol4Value,String col5ValueOnPage, String expectedcol5Value, String snapShotName) {
			  	assertTrue(driver.findElement(By.xpath(prop.getProperty(col1ValueOnPage))).getText().equals(expectedcol1Value));
				assertTrue(driver.findElement(By.xpath(prop.getProperty(col2ValueOnPage))).getText().equals(expectedcol2Value));
				assertTrue(driver.findElement(By.xpath(prop.getProperty(col3ValueOnPage))).getText().equals(expectedcol3Value));
				assertTrue(driver.findElement(By.xpath(prop.getProperty(col4ValueOnPage))).getText().equals(expectedcol4Value));
				assertTrue(driver.findElement(By.xpath(prop.getProperty(col5ValueOnPage))).getText().equals(expectedcol5Value));
				takeScreenShot(driver,snapShotName);
		  }
		  

}