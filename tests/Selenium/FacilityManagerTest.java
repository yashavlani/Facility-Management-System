package Selenium;
import java.awt.List;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Properties;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;

import org.junit.*;
import org.junit.runner.RunWith;

import static org.junit.Assert.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;


import junitparams.FileParameters;
import junitparams.JUnitParamsRunner;

@RunWith(JUnitParamsRunner.class)
public class FacilityManagerTest extends functions.Facility_ManagerFunctions {
  private String appURL;
  private boolean acceptNextAlert = true;
  private StringBuffer verificationErrors = new StringBuffer();
  public static String sharedUIMapStr;

  @Before
  public void setUp() throws Exception {
	System.setProperty("webdriver.chrome.driver", "C:/ChromeDriver/chromedriver.exe");
	driver = new ChromeDriver();
    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    prop = new Properties();
    prop.load(new FileInputStream("tests/configuration/FM_Configuration.properties"));
    appURL = prop.getProperty("sAppURL");
    prop.load(new FileInputStream(prop.getProperty("SharedUIMap")));
  }

  
  @Test
  @FileParameters("tests/Excel/TC01FAcilityReg.csv")
  public void Registration(int testcaseNum, 
		  	String username,String password,String utaid,String firstName,String lastName,
		  	String address,
		  	String city,
		  	
		  	String ZipCode,
		  	String email,
		  	
		  	String phone) throws Exception {
	driver.get(appURL);
	
    String methodName = new Throwable().getStackTrace()[0].getMethodName();

    FM_Registration(driver, username, password, utaid, firstName, lastName, address, city, "Texas", ZipCode,email,"Facility Manager",phone, "FacilityManagerTest" + methodName + testcaseNum);
  }
  @Test
  @FileParameters("tests/Excel/TC01VerifyLinks.csv")
  public void verifyAllLinks(int testcaseNum, String link, String title) throws Exception {
	  driver.get(appURL);
	  Thread.sleep(1000);
	  FM_Login(driver, "Prathamesh", "Prathamesh@123");    
	  Thread.sleep(1000);
	  driver.findElement(By.name(prop.getProperty(link))).click();
	 
		  String methodName = new Throwable().getStackTrace()[0].getMethodName();
		  takeScreenshot(driver, "FacilityManagerTest" + methodName + testcaseNum);
		  assertEquals(title,driver.getTitle());
	  
	  Thread.sleep(1000);
	  //Logout();
	 
	  //driver.findElement(By.linkText("Logout")).click();
	  }
@Test
public void Logout() throws Exception{
	driver.get(appURL);
	  Thread.sleep(1000);
	FM_Login(driver, "Prathamesh", "Prathamesh@123");
	 Thread.sleep(1000);
	driver.findElement(By.name("Logout"));
}
@Test
public void viewParticular() throws Exception{
	driver.get(appURL);
	  Thread.sleep(1000);
	FM_Login(driver, "Prathamesh", "Prathamesh@123");
	 Thread.sleep(1000);
	 driver.findElement(By.name(prop.getProperty("MainApp_ListFacilitiesLink"))).click();
	 driver.findElement(By.xpath("html/body/form/table/tbody/tr[2]/td[6]/a")).click();
	 Thread.sleep(5000);
	 driver.findElement(By.xpath(prop.getProperty("btn_listCompany"))).click();
	
}

 @Test
 @FileParameters("tests/Excel/TC01SearchMAR.csv")
  public void searchMAR(int testcasenumber,String MAR) throws Exception {
	  driver.get(appURL);
	  Thread.sleep(1000);
	  FM_Login(driver, "Prathamesh", "Prathamesh@123");    
	  Thread.sleep(1000);
	  driver.findElement(By.name(prop.getProperty("MainApp_SearchMARLink"))).click();
	  Thread.sleep(1000);
	  driver.findElement(By.xpath(prop.getProperty("Txt_SearchByMAR_MAR"))).clear();
	  driver.findElement(By.xpath(prop.getProperty("Txt_SearchByMAR_MAR"))).sendKeys(MAR);
	  driver.findElement(By.xpath(prop.getProperty("btn_SearchByMAR_Search_By_MAR"))).click();
	  String methodName = new Throwable().getStackTrace()[0].getMethodName();
	  takeScreenshot(driver, "FacilityManagerTest" + methodName);
	  assertTrue(isElementPresent(By.cssSelector("form")));
	  Thread.sleep(1000);
	  
  }
 @Test
  @FileParameters("tests/Excel/TC01InsertFacility.csv")
  public void insertFacility(int testcasenumber, String FacilityID, String Facility_Name, String FacilityIDError,String FacilityNameError ) throws Exception {
	  driver.get(appURL);
	  Thread.sleep(1000);
	  String methodName = new Throwable().getStackTrace()[0].getMethodName();
	  FM_Login(driver, "Prathamesh", "Prathamesh@123");    
	  Thread.sleep(1000);
	  driver.findElement(By.name(prop.getProperty("MainApp_ADDFacilityLink"))).click();
	  Thread.sleep(1000);
	  FM_Insertfaciliy(driver, FacilityID, Facility_Name);
	  driver.findElement(By.xpath(prop.getProperty("btn_InsertFacility_insertfacility"))).click();
	  FM_InsertFacilityError(driver,FacilityIDError,FacilityNameError,"InsertFacilityTest"+ methodName+testcasenumber);
	  Thread.sleep(1000);
	 
	  takeScreenshot(driver, "FacilityManagerTest" + methodName);
	
	 
	  //driver.findElement(By.linkText("Logout")).click();
  }
  
  @Test
  @FileParameters("tests/Excel/TC01TypeMAR.csv")
   public void TypeMAR(int testcasenumber,String Type) throws Exception {
 	  driver.get(appURL);
 	  Thread.sleep(1000);
 	  FM_Login(driver, "Prathamesh", "Prathamesh@123");    
 	  Thread.sleep(1000);
 	  driver.findElement(By.name(prop.getProperty("MainApp_SearchAssignedMARLink"))).click();
 	  Thread.sleep(1000);
 	  driver.findElement(By.xpath(prop.getProperty("Txt_searchTypeMAR_Type"))).clear();
 	  driver.findElement(By.xpath(prop.getProperty("Txt_searchTypeMAR_Type"))).sendKeys(Type);
 	  driver.findElement(By.xpath(prop.getProperty("btn_searchTypeMAR_searchTypedMAR"))).click();
 	  String methodName = new Throwable().getStackTrace()[0].getMethodName();
 	  takeScreenshot(driver, "TypeMArTest" + methodName+testcasenumber);
 	  assertTrue(isElementPresent(By.cssSelector("form")));
 	  Thread.sleep(1000);
 	  
   }
 	@Test
  @FileParameters("tests/Excel/TC01DatedMAR.csv")
   public void	DatedMAR(int testcasenumber,String Date) throws Exception {
 	  driver.get(appURL);
 	  Thread.sleep(1000);
 	  FM_Login(driver, "Prathamesh", "Prathamesh@123");    
 	  Thread.sleep(1000);
 	  driver.findElement(By.name(prop.getProperty("MainApp_SearchAssignedMARLink"))).click();
 	  Thread.sleep(1000);
 	  driver.findElement(By.xpath(prop.getProperty("Txt_searchDatedMAR_Date"))).clear();
 	  driver.findElement(By.xpath(prop.getProperty("Txt_searchDatedMAR_Date"))).sendKeys(Date);
 	  driver.findElement(By.xpath(prop.getProperty("btn_searchdatedMAR_SearchDatedMAR"))).click();
 	  String methodName = new Throwable().getStackTrace()[0].getMethodName();
 	  takeScreenshot(driver, "DatedMARTest" + methodName+testcasenumber);
 	  assertTrue(isElementPresent(By.cssSelector("form")));
 	  Thread.sleep(1000);
 	  
   }
  @Test
  @FileParameters("tests/Excel/TC01UpdateMAR.csv")
  public void updateMAR(int testcasenumber,String urgency,String EstimatedTime) throws Exception {
	  driver.get(appURL);
	  Thread.sleep(1000);
	  FM_Login(driver, "Prathamesh", "Prathamesh@123");    
	  Thread.sleep(1000);
	  driver.findElement(By.name(prop.getProperty("MainApp_UpdateMARLink"))).click();
	  //new Select(driver.findElement(By.name(prop.getProperty("Lst_UpdateMAR_Facility")))).selectByValue("16 | MR1 | Multipurpose_rooms");
	  //new Select(driver.findElement(By.name(prop.getProperty("Lst_UpdateMAR_Facility")))).selectByVisibleText("16 | MR1 | Multipurpose_rooms");
	  new Select(driver.findElement(By.name(prop.getProperty("Lst_UpdateMAR_Urgency")))).selectByVisibleText(urgency);
	  new Select(driver.findElement(By.name(prop.getProperty("Lst_UpdateMAR_EstimatedTime")))).selectByValue(EstimatedTime);
	  
	  driver.findElement(By.xpath(prop.getProperty("btn_UpdateMAR_updateMAR"))).click();
	  Thread.sleep(500);
	  String methodName = new Throwable().getStackTrace()[0].getMethodName();
	  takeScreenshot(driver, "FacilityManagerTest" + methodName + testcasenumber);
	  Thread.sleep(1000);
	  
  }
 

  @Test
  @FileParameters("tests/Excel/TC01AssignRepairer.csv")
  public void assignRepairer(int testcaseNum,String repairer, String date) throws Exception {
	
	driver.get(appURL);
	
	FM_Login(driver, "Prathamesh", "Prathamesh@123");  
	Thread.sleep(1000);
	driver.findElement(By.name(prop.getProperty("MainApp_AssignRepairerLink"))).click();
    Thread.sleep(1000);
    //driver.findElement(By.name(prop.getProperty("Lst_AssignRepaier_Facility"))).getAttribute("14|MR2|MAC");
  
   /* try
    {
    	new Select(driver.findElement(By.name("facility"))).selectByValue(Facility);;
       // new Select(driver.findElement(By.name(prop.getProperty("Lst_AssignRepaier_Facility")))).selectByVisibleText("14|MR2|MAC");
    	//driver.findElement(By.linkText(prop.getProperty("Lst_AssigRepaier_AssignedTo"))).getAttribute(repairer);
    }
    catch( Exception e)
    { }
    
    */
    WebElement dropdown = driver.findElement(By.xpath("html/body/form/table/tbody/tr[1]/td[2]/select"));
  

		// Click on drop down
		dropdown.click();

		// Waiting till options in drop down are visible
		WebDriverWait wait = new WebDriverWait(driver, 15);
		wait.until(ExpectedConditions
				.visibilityOf(driver.findElement(By.name("facility"))));

		// Getting list of options
		ArrayList<WebElement> itemsInDropdown = (ArrayList<WebElement>) driver
				.findElements(By.name("facility"));

		// Getting size of options available
		int size = itemsInDropdown.size();

		// Generate a random number with in range
		int randnMumber = ThreadLocalRandom.current().nextInt(0, size);

		
		// Selecting random value
		itemsInDropdown.get(randnMumber).click();

		Thread.sleep(2000);

	
    new Select(driver.findElement(By.name("repairer"))).selectByValue(repairer);
    driver.findElement(By.name(prop.getProperty("txt_AssignRepairer_Date"))).sendKeys(date);
    Thread.sleep(500);
    driver.findElement(By.cssSelector("input[type=\"submit\"]")).click();
    Thread.sleep(500);
    String methodName = new Throwable().getStackTrace()[0].getMethodName();
    takeScreenshot(driver, "FacilityManagerTest" + methodName + testcaseNum);
	driver.findElement(By.name("Logout"));

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

  /*private boolean isAlertPresent() {
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
}*/
 
}