package functions;

import org.junit.Before;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import functions.SnapshotFunction;
import static org.junit.Assert.assertTrue;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
@SuppressWarnings("unused")
public class MACFunctions {

		  private SnapshotFunction snap = new SnapshotFunction();
		  public WebDriver driver;
		  public Properties prop;
		  public enum FunctionEnum {insertMar,registration,updateProfile}	  
		  
		  public WebDriver invokeCorrectBrowser () {
			    System.setProperty("webdriver.chrome.driver", "C:/ChromeDriver/chromedriver.exe");  
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
		  
		  public void MAC_Registration(WebDriver driver, String state, String role, String first_name, String last_name,String contact, String email, String uta_id, String address, String city, String zip_code, String username, String password,String snapShotName) {
			  	driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
				driver.findElement(By.xpath(prop.getProperty("Reg_username_text"))).clear();
			    driver.findElement(By.xpath(prop.getProperty("Reg_username_text"))).sendKeys(username);
			    driver.findElement(By.xpath(prop.getProperty("Reg_password_text"))).clear();
			    driver.findElement(By.xpath(prop.getProperty("Reg_password_text"))).sendKeys(password);
			    driver.findElement(By.xpath(prop.getProperty("Reg_utaId"))).clear();
			    driver.findElement(By.xpath(prop.getProperty("Reg_utaId"))).sendKeys(uta_id);
			    driver.findElement(By.xpath(prop.getProperty("Reg_firstname"))).clear();
			    driver.findElement(By.xpath(prop.getProperty("Reg_firstname"))).sendKeys(first_name);
			    driver.findElement(By.xpath(prop.getProperty("Reg_lastname"))).clear();
			    driver.findElement(By.xpath(prop.getProperty("Reg_lastname"))).sendKeys(last_name);
			    driver.findElement(By.xpath(prop.getProperty("Reg_address"))).clear();
			    driver.findElement(By.xpath(prop.getProperty("Reg_address"))).sendKeys(address);
			    driver.findElement(By.xpath(prop.getProperty("Reg_city"))).clear();
			    driver.findElement(By.xpath(prop.getProperty("Reg_city"))).sendKeys(city);
//			    driver.findElement(By.xpath(prop.getProperty("Reg_state"))).clear();
			    driver.findElement(By.xpath(prop.getProperty("Reg_state"))).sendKeys(state);
			    driver.findElement(By.xpath(prop.getProperty("Reg_zipcode"))).clear();
			    driver.findElement(By.xpath(prop.getProperty("Reg_zipcode"))).sendKeys(zip_code);
			    driver.findElement(By.xpath(prop.getProperty("Reg_email"))).clear();
			    driver.findElement(By.xpath(prop.getProperty("Reg_email"))).sendKeys(email);
//			    driver.findElement(By.xpath(prop.getProperty("Reg_role"))).clear();
			    driver.findElement(By.xpath(prop.getProperty("Reg_role"))).sendKeys(role);
			    driver.findElement(By.xpath(prop.getProperty("Reg_contact"))).clear();
			    driver.findElement(By.xpath(prop.getProperty("Reg_contact"))).sendKeys(contact);
			    driver.findElement(By.xpath(prop.getProperty("Reg_submit_btn"))).click();
			    takeScreenShot(driver,snapShotName);
			}
		  
		  public void updateProfile_function(WebDriver driver, String state, String role, String first_name, String last_name,String contact, String email, String address, String city, String zip_code, String password,String snapShotName) {
			  	driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
			    driver.findElement(By.xpath(prop.getProperty("UpdateProfile_password_text"))).clear();
			    driver.findElement(By.xpath(prop.getProperty("UpdateProfile_password_text"))).sendKeys(password);
			    driver.findElement(By.xpath(prop.getProperty("UpdateProfile_firstname"))).clear();
			    driver.findElement(By.xpath(prop.getProperty("UpdateProfile_firstname"))).sendKeys(first_name);
			    driver.findElement(By.xpath(prop.getProperty("UpdateProfile_lastname"))).clear();
			    driver.findElement(By.xpath(prop.getProperty("UpdateProfile_lastname"))).sendKeys(last_name);
			    driver.findElement(By.xpath(prop.getProperty("UpdateProfile_address"))).clear();
			    driver.findElement(By.xpath(prop.getProperty("UpdateProfile_address"))).sendKeys(address);
			    driver.findElement(By.xpath(prop.getProperty("UpdateProfile_city"))).clear();
			    driver.findElement(By.xpath(prop.getProperty("UpdateProfile_city"))).sendKeys(city);
//			    driver.findElement(By.xpath(prop.getProperty("Reg_state"))).clear();
			    driver.findElement(By.xpath(prop.getProperty("UpdateProfile_state"))).sendKeys(state);
			    driver.findElement(By.xpath(prop.getProperty("UpdateProfile_zipcode"))).clear();
			    driver.findElement(By.xpath(prop.getProperty("UpdateProfile_zipcode"))).sendKeys(zip_code);
			    driver.findElement(By.xpath(prop.getProperty("UpdateProfile_email"))).clear();
			    driver.findElement(By.xpath(prop.getProperty("UpdateProfile_email"))).sendKeys(email);
//			    driver.findElement(By.xpath(prop.getProperty("Reg_role"))).clear();
			    driver.findElement(By.xpath(prop.getProperty("UpdateProfile_role"))).sendKeys(role);
			    driver.findElement(By.xpath(prop.getProperty("UpdateProfile_contact"))).clear();
			    driver.findElement(By.xpath(prop.getProperty("UpdateProfile_contact"))).sendKeys(contact);
			    driver.findElement(By.xpath(prop.getProperty("UpdateProfile_submit_btn"))).click();
			    takeScreenShot(driver,snapShotName);
			}
		  
		  public void verifyUpdateProfileErrorMessages (WebDriver driver, String errorMsg, String first_nameError, String last_nameError, String contactError,String emailError,String addressError,String cityError,String zipcodeError,String passwordError, String snapShotName) {
//			    assertTrue(driver.findElement(By.xpath(prop.getProperty("insertMar_errMsgError"))).getAttribute("value").equals(errorMsg));
			    assertTrue(driver.findElement(By.xpath(prop.getProperty("UpdateProfile_password_text_error"))).getAttribute("value").equals(passwordError));
			    assertTrue(driver.findElement(By.xpath(prop.getProperty("UpdateProfile_firstname_error"))).getAttribute("value").equals(first_nameError));
			    assertTrue(driver.findElement(By.xpath(prop.getProperty("UpdateProfile_lastname_error"))).getAttribute("value").equals(last_nameError));
			    assertTrue(driver.findElement(By.xpath(prop.getProperty("UpdateProfile_address_error"))).getAttribute("value").equals(addressError));
			    assertTrue(driver.findElement(By.xpath(prop.getProperty("UpdateProfile_city_error"))).getAttribute("value").equals(cityError));
			    assertTrue(driver.findElement(By.xpath(prop.getProperty("UpdateProfile_zipcode_error"))).getAttribute("value").equals(zipcodeError));
			    assertTrue(driver.findElement(By.xpath(prop.getProperty("UpdateProfile_email_error"))).getAttribute("value").equals(emailError));
			    assertTrue(driver.findElement(By.xpath(prop.getProperty("UpdateProfile_contact_error"))).getAttribute("value").equals(contactError));
			    takeScreenShot(driver,snapShotName);
		  }
		  
		  public void verifyRegistrationErrorMessages (WebDriver driver, String errorMsg,String utaIDError, String first_nameError, String last_nameError, String contactError,String emailError,String addressError,String cityError,String zipcodeError,String usernameError,String passwordError, String snapShotName) {
//			    assertTrue(driver.findElement(By.xpath(prop.getProperty("insertMar_errMsgError"))).getAttribute("value").equals(errorMsg));
			    assertTrue(driver.findElement(By.xpath(prop.getProperty("Reg_username_text_error"))).getAttribute("value").equals(usernameError));
			    assertTrue(driver.findElement(By.xpath(prop.getProperty("Reg_password_text_error"))).getAttribute("value").equals(passwordError));
			    assertTrue(driver.findElement(By.xpath(prop.getProperty("Reg_utaId_error"))).getAttribute("value").equals(utaIDError));
			    assertTrue(driver.findElement(By.xpath(prop.getProperty("Reg_firstname_error"))).getAttribute("value").equals(first_nameError));
			    assertTrue(driver.findElement(By.xpath(prop.getProperty("Reg_lastname_error"))).getAttribute("value").equals(last_nameError));
			    assertTrue(driver.findElement(By.xpath(prop.getProperty("Reg_address_error"))).getAttribute("value").equals(addressError));
			    assertTrue(driver.findElement(By.xpath(prop.getProperty("Reg_city_error"))).getAttribute("value").equals(cityError));
			    assertTrue(driver.findElement(By.xpath(prop.getProperty("Reg_zipcode_error"))).getAttribute("value").equals(zipcodeError));
			    assertTrue(driver.findElement(By.xpath(prop.getProperty("Reg_email_error"))).getAttribute("value").equals(emailError));
			    assertTrue(driver.findElement(By.xpath(prop.getProperty("Reg_contact_error"))).getAttribute("value").equals(contactError));
			    takeScreenShot(driver,snapShotName);
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
		  
		  public void verifyLoginErrorMessages (WebDriver driver,String errorMsg,String usernameError,String passwordError, String snapShotName) {
			    assertTrue(driver.findElement(By.xpath(prop.getProperty("login_errMsgError"))).getAttribute("value").equals(errorMsg));
			    assertTrue(driver.findElement(By.xpath(prop.getProperty("login_usernameError"))).getAttribute("value").equals(usernameError));
			    assertTrue(driver.findElement(By.xpath(prop.getProperty("login_passwordError"))).getAttribute("value").equals(passwordError));
			    takeScreenShot(driver,snapShotName);
			    
		  }
		  
		  public void MainApp_function (WebDriver driver, FunctionEnum function) {
			  switch (function) {
			  	case registration:
				    driver.findElement(By.xpath(prop.getProperty("Registration_Link"))).click(); //select List Company from homepage
				    break;
			  	case insertMar:
			  	    driver.findElement(By.xpath(prop.getProperty("insertMar_insertMarLink"))).click(); //select Insert Company from homepage
			  	    break;
			  	case updateProfile:
			  	    driver.findElement(By.xpath(prop.getProperty("MainApp_UpdateProfile_Link"))).click(); //select Insert Company from homepage
			  	    break;
//			  	case searchEmployee:
//			  	    driver.findElement(By.xpath(prop.getProperty("MainApp_SearchEmployeeLink"))).click(); //select Insert Company from homepage
			  }
		  }
		  
		  public void insertMar_function (WebDriver driver, String facility_type, String facility_name, String description, String reported_by, String strDate, String strTime, String mar,String snapShotName) {
//			  	driver.findElement(By.xpath(prop.getProperty("insertMar_insertMarLink"))).click();
			  	driver.findElement(By.xpath(prop.getProperty("insertMar_facilityTypeValue"))).sendKeys(facility_type);
			    driver.findElement(By.xpath(prop.getProperty("insertMar_facilityNameValue"))).sendKeys(facility_name);
			    driver.findElement(By.xpath(prop.getProperty("insertMar_DescriptionValue"))).clear();
			    driver.findElement(By.xpath(prop.getProperty("insertMar_DescriptionValue"))).sendKeys(description);
//			    driver.findElement(By.xpath(prop.getProperty("insertMar_reportedByValue"))).sendKeys(reported_by);
//			    driver.findElement(By.xpath(prop.getProperty("insertMar_strDateValue"))).sendKeys(strDate);
//			    driver.findElement(By.xpath(prop.getProperty("insertMar_strTimeValue"))).sendKeys(strTime);
//			    driver.findElement(By.xpath(prop.getProperty("insertMar_marValue"))).sendKeys(mar);
			    assertTrue(driver.findElement(By.xpath(prop.getProperty("insertMar_descriptionError"))).getAttribute("value").equals(""));

			    driver.findElement(By.xpath(prop.getProperty("insertMar_insertMarButton"))).click(); //click on insertCompany button
			    takeScreenShot(driver,snapShotName);
		  }
		  
		  public void verifyInsertMarErrorMessages (WebDriver driver, String errorMsg, String DescriptionError, String snapShotName) {
//			    assertTrue(driver.findElement(By.xpath(prop.getProperty("insertMar_errMsgError"))).getAttribute("value").equals(errorMsg));
			    assertTrue(driver.findElement(By.xpath(prop.getProperty("insertMar_descriptionError"))).getAttribute("value").equals(DescriptionError));
			    takeScreenShot(driver,snapShotName);
		  }
		  
//		  public void verifyHeaders(WebDriver driver, String header1OnPage, String expectedHeader1Name,String header2OnPage, String expectedHeader2Name,
//				  									String header3OnPage, String expectedHeader3Name,String header4OnPage, String expectedHeader4Name, 
//				  									String header5OnPage, String expectedHeader5Name, String snapShotName) {
//			    assertTrue(driver.findElement(By.xpath(prop.getProperty(header1OnPage))).getText().equals(expectedHeader1Name));
//			    assertTrue(driver.findElement(By.xpath(prop.getProperty(header2OnPage))).getText().equals(expectedHeader2Name));
//			    assertTrue(driver.findElement(By.xpath(prop.getProperty(header3OnPage))).getText().equals(expectedHeader3Name));
//			    assertTrue(driver.findElement(By.xpath(prop.getProperty(header4OnPage))).getText().equals(expectedHeader4Name));
//			    if (!header5OnPage.equals(""))
//			    	assertTrue(driver.findElement(By.xpath(prop.getProperty(header5OnPage))).getText().equals(expectedHeader5Name));
//			    takeScreenShot(driver,snapShotName);
//		  }
//		  
//		  public void verifyContents(WebDriver driver, String col1ValueOnPage, String expectedcol1Value,String col2ValueOnPage, String expectedcol2Value,
//												String col3ValueOnPage, String expectedcol3Value,String col4ValueOnPage, String expectedcol4Value, String snapShotName) {
//			  	assertTrue(driver.findElement(By.xpath(prop.getProperty(col1ValueOnPage))).getText().equals(expectedcol1Value));
//				assertTrue(driver.findElement(By.xpath(prop.getProperty(col2ValueOnPage))).getText().equals(expectedcol2Value));
//				assertTrue(driver.findElement(By.xpath(prop.getProperty(col3ValueOnPage))).getText().equals(expectedcol3Value));
//				assertTrue(driver.findElement(By.xpath(prop.getProperty(col4ValueOnPage))).getText().equals(expectedcol4Value));
//				takeScreenShot(driver,snapShotName);
//		  }
		  
//		  public void insertEmployee_function (WebDriver driver, String employeeID, String firstName, String lastName, String badgeNo, String doneButton, String snapShotName) {
//			    driver.findElement(By.xpath(prop.getProperty("insertEmployee_employeeIDValue"))).sendKeys(employeeID);
//			    driver.findElement(By.xpath(prop.getProperty("insertEmployee_firstNameValue"))).sendKeys(firstName);
//			    driver.findElement(By.xpath(prop.getProperty("insertEmployee_lastNameValue"))).sendKeys(lastName);
//			    driver.findElement(By.xpath(prop.getProperty("insertEmployee_companyBadgeValue"))).sendKeys(badgeNo);
//			    takeScreenShot(driver,snapShotName);
//			    driver.findElement(By.xpath(prop.getProperty("insertEmployee_insertEmployeeButton"))).click(); //click insertEmployee button
//			    if (!doneButton.equals(""))
//			    	driver.findElement(By.xpath(prop.getProperty("insertEmployee_doneButton"))).click(); // click Done button
//		  }
//
//		  public void verifyInsertEmployeeErrorMessages (WebDriver driver, String errorMessage, String employeeIDErrorMessage, 
//					String employeeFirstNameErrorMessage, String employeeLastNameErrorMessage, String employeeBadgeNumberErrorMessage, String snapShotName) {
//				assertTrue(driver.findElement(By.xpath(prop.getProperty("insertEmployee_errMsgError"))).getAttribute("value").equals(errorMessage));
//				assertTrue(driver.findElement(By.xpath(prop.getProperty("insertEmployee_employeeIDError"))).getAttribute("value").equals(employeeIDErrorMessage));
//				assertTrue(driver.findElement(By.xpath(prop.getProperty("insertEmployee_firstNameError"))).getAttribute("value").equals(employeeFirstNameErrorMessage));
//				assertTrue(driver.findElement(By.xpath(prop.getProperty("insertEmployee_lastNameError"))).getAttribute("value").equals(employeeLastNameErrorMessage));
//				assertTrue(driver.findElement(By.xpath(prop.getProperty("insertEmployee_companyBadgeError"))).getAttribute("value").equals(employeeBadgeNumberErrorMessage));
//			    takeScreenShot(driver,snapShotName);
//		  }
//
//		  public void searchCompany_function (WebDriver driver, String companyName, String companyID, String snapShotName) {
//			    driver.findElement(By.xpath(prop.getProperty("searchCompany_companyNameValue"))).sendKeys(companyName);
//			    driver.findElement(By.xpath(prop.getProperty("searchCompany_companyIDValue"))).sendKeys(companyID);
//			    takeScreenShot(driver,snapShotName);
//			    driver.findElement(By.xpath(prop.getProperty("searchCompany_submitButton"))).click();			    
//		  }
//		  
//		  public void verifySearchCompanyErrorMessages (WebDriver driver, String errorMessage, String companyNameErrorMessage, String CompanyIDErrorMessage, String snapShotName) {
//			  	assertTrue(driver.findElement(By.xpath(prop.getProperty("searchCompany_errMsgError"))).getAttribute("value").equals(errorMessage));
//				assertTrue(driver.findElement(By.xpath(prop.getProperty("searchCompany_companyNameError"))).getAttribute("value").equals(companyNameErrorMessage));
//				assertTrue(driver.findElement(By.xpath(prop.getProperty("searchCompany_companyIDError"))).getAttribute("value").equals(CompanyIDErrorMessage));
//			    takeScreenShot(driver,snapShotName);
//		  }
//
//		  public void searchEmployee_function (WebDriver driver, String companyID, String snapShotName) {
//			    driver.findElement(By.xpath(prop.getProperty("searchEmployee_companyIDValue"))).sendKeys(companyID);
//			    takeScreenShot(driver,snapShotName);
//			    driver.findElement(By.xpath(prop.getProperty("searchEmployee_submitButton"))).click();			    
//		  }
//		  
//		  public void verifySearchEmployeeErrorMessages (WebDriver driver, String errorMessage, String CompanyIDErrorMessage, String snapShotName) {
//			  	assertTrue(driver.findElement(By.xpath(prop.getProperty("searchEmployee_errMsgError"))).getAttribute("value").equals(errorMessage));
//				assertTrue(driver.findElement(By.xpath(prop.getProperty("searchEmployee_companyIDError"))).getAttribute("value").equals(CompanyIDErrorMessage));
//			    takeScreenShot(driver,snapShotName);
//		  }

}
