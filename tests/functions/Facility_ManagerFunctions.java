package functions;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.io.File;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Facility_ManagerFunctions {
	public static WebDriver driver;
	public static Properties prop;
	
	public void takeScreenshot(WebDriver driver, String screenshotname) {
		try {
			File source = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(source, new File("./ScreenShots/" + screenshotname +".png"));
		}
		catch(IOException e) {}
		
		try {
//			Change the delay value to 1_000 to insert a 1 second delay after 
//			each screenshot
			Thread.sleep(0);
		}
		catch (InterruptedException e) {}
	}
	
	
	public void FM_Login(WebDriver driver, String sUserName, String sPassword) throws InterruptedException
	{
	    driver.findElement(By.xpath(prop.getProperty("txt_Login_UserName"))).clear();
	    driver.findElement(By.xpath(prop.getProperty("txt_Login_UserName"))).sendKeys(sUserName);
	    
	    driver.findElement(By.xpath(prop.getProperty("txt_Login_Password"))).clear();
	    driver.findElement(By.xpath(prop.getProperty("txt_Login_Password"))).sendKeys(sPassword);
	    
	    Thread.sleep(1000);
	       
	    driver.findElement(By.xpath(prop.getProperty("btn_Login_Submit"))).click();
	}
	
	//public void FM_Logout(WebDriver driver) throws InterruptedException
	//{
	//	driver.findElement(By.name(prop.getProperty("MainApp_Logout")));
	//}
	public void FM_Insertfaciliy(WebDriver driver, String FacilityID, String Facility_Name) throws InterruptedException {
		System.out.println(FacilityID);
		 driver.findElement(By.xpath(prop.getProperty("Txt_Insertfacility_FacilityID"))).clear();
		    driver.findElement(By.xpath(prop.getProperty("Txt_Insertfacility_FacilityID"))).sendKeys(FacilityID);
		    
		    driver.findElement(By.xpath(prop.getProperty("Txt_InsertFacility_facility_Name"))).clear();
		    driver.findElement(By.xpath(prop.getProperty("Txt_InsertFacility_facility_Name"))).sendKeys(Facility_Name);
		    
		    Thread.sleep(1000);
		       
		    
		
	}
	
	public void FM_InsertFacilityError(WebDriver driver, String FacilityError, String FacilityNameError,String snapShotName ) {
		System.out.println(FacilityError);
		//System.out.print(driver.findElement(By.xpath(prop.getProperty("Txt_InsertFacility_FacilityIDEror"))).getAttribute("value").equals(FacilityError));
		assertEquals(FacilityError,driver.findElement(By.xpath(prop.getProperty("Txt_InsertFacility_FacilityIDEror"))).getAttribute("value"));
		assertEquals(FacilityNameError,driver.findElement(By.xpath(prop.getProperty("Txt_InsertFacility_FacilityNameError"))).getAttribute("value"));
	    //assertTrue(driver.findElement(By.xpath(prop.getProperty("Txt_InsertFacility_FacilityIDEror"))).getAttribute("value").equals(FacilityError));
	    //assertTrue(driver.findElement(By.xpath(prop.getProperty("Txt_InsertFacility_FacilityNameError"))).getAttribute("value").equals(FacilityNameError));
	    takeScreenshot(driver,snapShotName);
	}
	
	public void FM_Registration(WebDriver driver, String username,String password,String utaid,String firstName,String lastName,
		  	String address,
		  	String city,
		  	String state,
		  	String ZipCode,
		  	String email,
		  	String role,
		  	String phone,String snapShotName) {
	  	driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
	  	driver.findElement(By.xpath(prop.getProperty("lnk_Login_CreateNewAccountLink"))).click();
		driver.findElement(By.xpath(prop.getProperty("txt_Registration_UserName"))).clear();
	    driver.findElement(By.xpath(prop.getProperty("txt_Registration_UserName"))).sendKeys(username);
	    driver.findElement(By.xpath(prop.getProperty("txt_Registration_Password"))).clear();
	    driver.findElement(By.xpath(prop.getProperty("txt_Registration_Password"))).sendKeys(password);
	    driver.findElement(By.xpath(prop.getProperty("txt_Registration_UTA_ID"))).clear();
	    driver.findElement(By.xpath(prop.getProperty("txt_Registration_UTA_ID"))).sendKeys(utaid);
	    driver.findElement(By.xpath(prop.getProperty("txt_Registration_First_Name"))).clear();
	    driver.findElement(By.xpath(prop.getProperty("txt_Registration_First_Name"))).sendKeys(firstName);
	    driver.findElement(By.xpath(prop.getProperty("txt_Registration_Last_Name"))).clear();
	    driver.findElement(By.xpath(prop.getProperty("txt_Registration_Last_Name"))).sendKeys(lastName);
	    driver.findElement(By.xpath(prop.getProperty("txt_Registration_Address"))).clear();
	    driver.findElement(By.xpath(prop.getProperty("txt_Registration_Address"))).sendKeys(address);
	    driver.findElement(By.xpath(prop.getProperty("txt_Registration_City"))).clear();
	    driver.findElement(By.xpath(prop.getProperty("txt_Registration_City"))).sendKeys(city);
//	    driver.findElement(By.xpath(prop.getProperty("Reg_state"))).clear();
	    driver.findElement(By.name("states")).sendKeys(state);
	    driver.findElement(By.xpath(prop.getProperty("txt_Registration_ZipCode"))).clear();
	    driver.findElement(By.xpath(prop.getProperty("txt_Registration_ZipCode"))).sendKeys(ZipCode);
	   // driver.findElement(By.xpath(prop.getProperty("txt_Registration_Email"))).clear();
	    //driver.findElement(By.xpath(prop.getProperty("txt_Registration_Email"))).sendKeys(email);
//	    driver.findElement(By.xpath(prop.getProperty("Reg_role"))).clear();
	    //driver.findElement(By.xpath(prop.getProperty("Lst_Registration_Roles"))).sendKeys(role);
	    driver.findElement(By.name("email")).sendKeys(email);
	    new Select(driver.findElement(By.name("roles"))).selectByVisibleText(role);
	    driver.findElement(By.name("contact")).clear();
	    driver.findElement(By.name("contact")).sendKeys(phone);
	    driver.findElement(By.xpath(prop.getProperty("btn_Registration_Submit"))).click();
	    takeScreenshot(driver,snapShotName);
	}
}