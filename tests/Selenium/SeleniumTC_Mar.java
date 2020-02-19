package Selenium;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.io.FileInputStream;
import java.security.SecureRandom;
import java.util.Properties;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.openqa.selenium.By;

import functions.MACFunctions;
import junitparams.FileParameters;
import junitparams.JUnitParamsRunner;

@RunWith(JUnitParamsRunner.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING) // the test methods in this test file can run in any order but I prefer a fixed order
public class SeleniumTC_Mar extends MACFunctions {
  private StringBuffer verificationErrors = new StringBuffer();
  public String sAppURL, sSharedUIMapPath, testDelay;
  
  @Before
  public void setUp() throws Exception {
//	MAGIC CODE GOES HERE 
	    driver = invokeCorrectBrowser();
	    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	    prop = new Properties();	  
	    prop.load(new FileInputStream("tests/configuration/CM_Configuration.properties"));
		sAppURL = prop.getProperty("sAppURL");
		sSharedUIMapPath = prop.getProperty("SharedUIMap");
		testDelay=prop.getProperty("testDelay");
		prop.load(new FileInputStream(sSharedUIMapPath));
  }  
  
  @Test
  @FileParameters("tests/Excel/TC01a_reg.csv")
  public void TC01a_reg(int testCaseNumber, String state, String role, String first_name, String last_name,String contact, String email, String uta_id, String address, String city, String zip_code, String username, String password, String errorMsg,String utaIDError, String first_nameError, String last_nameError, String contactError,String emailError,String addressError,String cityError,String zipcodeError,String usernameError,String passwordError) throws Exception {	  
	String methodName= new Throwable().getStackTrace()[0].getMethodName();
    driver.get(sAppURL);
    
    assertTrue(driver.getTitle().contains("Login"));
    MainApp_function(driver,FunctionEnum.registration); //select Insert Company from homepage
    
    assertTrue(driver.getTitle().contains("Registration"));
    MAC_Registration(driver, state, role, first_name, last_name, contact, email, uta_id, address, city, zip_code, username, password,methodName+" LoginFunction test case "+testCaseNumber);
    
    // verify error messages
    verifyRegistrationErrorMessages(driver, errorMsg, utaIDError, first_nameError, last_nameError, contactError, emailError, addressError, cityError, zipcodeError, usernameError, passwordError,methodName+" verifyInsertMarErrorMessages test case "+testCaseNumber);
  }
  
  @Test
  @FileParameters("tests/Excel/TC01b_reg.csv")
  public void TC01b_reg(int testCaseNumber, String state, String role, String first_name, String last_name,String contact, String email, String uta_id, String address, String city, String zip_code, String username, String password) throws Exception {	  
	String methodName= new Throwable().getStackTrace()[0].getMethodName();
    driver.get(sAppURL);
    
    assertTrue(driver.getTitle().contains("Login"));
    MainApp_function(driver,FunctionEnum.registration); //select Insert Company from homepage
    
    assertTrue(driver.getTitle().contains("Registration"));
    MAC_Registration(driver, state, role, first_name, last_name, contact, email, uta_id, address, city, zip_code, username, password,methodName+" LoginFunction test case "+testCaseNumber);
    
    driver.findElement(By.xpath(prop.getProperty("Reg_login_link"))).click(); //click on Login link
    assertTrue(driver.getTitle().contains("Login"));
  }
  
  @Test
  @FileParameters("tests/Excel/TC01c_login.csv")
  public void TC01c_login(int testCaseNumber,String username, String password, String errorMsg,String usernameError,String passwordError) throws Exception {	  
	String methodName= new Throwable().getStackTrace()[0].getMethodName();
    driver.get(sAppURL);
    
    assertTrue(driver.getTitle().contains("Login"));
    MAC_Login(driver,username, password,methodName+" LoginFunction test case "+testCaseNumber);
    
    // verify error messages
    verifyLoginErrorMessages(driver, errorMsg,usernameError,passwordError,methodName+" verifyInsertMarErrorMessages test case "+testCaseNumber);
   }

  @Test
  @FileParameters("tests/Excel/TC02a_mar.csv")
  public void TC02a_mar(int testCaseNumber, String facility_type, String facility_name, String description, String reported_by, String strDate, String strTime, String mar,
		  						String errorMsg, String DescriptionError) throws Exception {	  
	String methodName= new Throwable().getStackTrace()[0].getMethodName();
    driver.get(sAppURL);
    
    assertTrue(driver.getTitle().contains("Login"));
    MAC_Login(driver, "Pujaredij","Pujaredij@123",methodName+" LoginFunction test case "+testCaseNumber);
    
    assertTrue(driver.getTitle().contains("User Home Screen"));
    MainApp_function(driver,FunctionEnum.insertMar); //select Insert Company from homepage
    
    assertTrue(driver.getTitle().contains("MAR Form"));
    insertMar_function(driver, facility_type, facility_name, description, reported_by,strDate,strTime,mar,methodName+" insertMarFunction test case "+testCaseNumber);
    
    // verify error messages
    verifyInsertMarErrorMessages(driver, errorMsg,DescriptionError,methodName+" verifyInsertMarErrorMessages test case "+testCaseNumber);
  }

  @Test
  @FileParameters("tests/Excel/TC02b_mar.csv")
  public void TC02b_mar(int testCaseNumber, String facility_type, String facility_name, String description, String reported_by, String strDate, String strTime, String mar) throws Exception {
	String methodName= new Throwable().getStackTrace()[0].getMethodName();
	driver.get(sAppURL);
	
    assertTrue(driver.getTitle().contains("Login"));
    MAC_Login(driver, "Pujaredij","Pujaredij@123",methodName+" LoginFunction test case 1");

    assertTrue(driver.getTitle().contains("User Home Screen"));
    MainApp_function(driver,FunctionEnum.insertMar); //select Insert Company from homepage

    assertTrue(driver.getTitle().contains("MAR Form"));
    insertMar_function(driver, facility_type, facility_name,  description,  reported_by,  strDate,  strTime,  mar,methodName+" insertMar test case 1");
//    assertTrue(driver.findElement(By.xpath(prop.getProperty("insertMar_descriptionError"))).getAttribute("value").equals(""));

    driver.findElement(By.xpath(prop.getProperty("insertMar_logout_link"))).click(); //click on Logout link
    assertTrue(driver.getTitle().contains("Login"));

    // insert valid data in employee form
//	insertEmployee_function(driver,idemployeeRand,name,surname,badgeRand,"done",methodName+" insertEmployeeFunction test case 1");
//    MainApp_function(driver,FunctionEnum.searchCompanies); // select SearchCompany from homepage
//    searchCompany_function(driver,"",idcompanyRand,methodName+" searchCompany_function test case 1"); //search on Company ID previously entered
//    // Verify header for Company Search table results
//    verifyHeaders(driver,"searchCompanyResults_companyIDTitle","Company ID","searchCompanyResults_phoneTitle","Phone","searchCompanyResults_companyNameTitle","Company Name","searchCompanyResults_emailTitle","Email","","",methodName+" verifyHeaders test case 1");
//    // Verify contents for Company Search table results
//    verifyContents(driver,"searchCompanyResults_companyIDValue",idcompanyRand,"searchCompanyResults_phoneValue",phoneRand,"searchCompanyResults_companyNameValue",companyNameRand,"searchCompanyResults_emailValue",emailRand,methodName+" verifyContents test case 1");
//    driver.findElement(By.xpath(prop.getProperty("searchCompanyResults_companyMgtAppLink"))).click(); //return to homepage
  }
  
  @Test
  @FileParameters("tests/Excel/TC03a_mar.csv")
  public void TC03a_mar(int testCaseNumber, String state, String role, String first_name, String last_name,String contact, String email, String address, String city, String zip_code, String password, String errorMsg,String utaIDError, String first_nameError, String last_nameError, String contactError,String emailError,String addressError,String cityError,String zipcodeError,String usernameError,String passwordError) throws Exception {
	String methodName= new Throwable().getStackTrace()[0].getMethodName();
	driver.get(sAppURL);
	
//    System.out.println(driver.getTitle());
    assertTrue(driver.getTitle().contains("Login"));
    MAC_Login(driver, "Pujaredij","Pujaredij@123",methodName+" UpdateFunction test case 1");

    assertTrue(driver.getTitle().contains("User Home Screen"));
    MainApp_function(driver,FunctionEnum.updateProfile); //select Insert Company from homepage

    assertTrue(driver.getTitle().contains("Update Profile"));
    updateProfile_function(driver, state, role, first_name, last_name, contact, email, address, city, zip_code, password,methodName+" updateProfile test case 1");
//    assertTrue(driver.findElement(By.xpath(prop.getProperty("insertMar_descriptionError"))).getAttribute("value").equals(""));

 // verify error messages
    verifyUpdateProfileErrorMessages(driver, errorMsg, first_nameError, last_nameError, contactError, emailError, addressError, cityError, zipcodeError, passwordError,methodName+" verifyInsertMarErrorMessages test case "+testCaseNumber);
 }
  
  	@Test
	@FileParameters("tests/Excel/TC03b_mar.csv")
	public void TC03b_mar(int testCaseNumber, String state, String role, String first_name, String last_name,String contact, String email, String address, String city, String zip_code, String password) throws Exception {	  
		String methodName= new Throwable().getStackTrace()[0].getMethodName();
	  driver.get(sAppURL);
	  
	  assertTrue(driver.getTitle().contains("Login"));
      MAC_Login(driver, "Pujaredij","Pujaredij@123",methodName+" UpdateFunction test case 1");

      assertTrue(driver.getTitle().contains("User Home Screen"));
      MainApp_function(driver,FunctionEnum.updateProfile); //select Insert Company from homepage

	  assertTrue(driver.getTitle().contains("Update Profile"));
	  updateProfile_function(driver, state, role, first_name, last_name, contact, email, address, city, zip_code, password,methodName+" UpdateFunction test case "+testCaseNumber);
	  
	  driver.findElement(By.xpath(prop.getProperty("UpdateProfile_login_link"))).click(); //click on Login link
	  assertTrue(driver.getTitle().contains("Login"));
	}


  @After
  public void tearDown() throws Exception {
    driver.quit();
    String verificationErrorString = verificationErrors.toString();
    if (!"".equals(verificationErrorString)) {
      fail(verificationErrorString);
    }
  }
}
