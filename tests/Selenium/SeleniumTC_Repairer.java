package Selenium;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import MAC_Facility.model.Repairer;
import functions.RepairerFunctions;
import MAC_Facility.model.Repairer;
import MAC_Facility.util.SQLConnection;
//import company_management.CMFunctions.FunctionEnum;
import junitparams.FileParameters;
import junitparams.JUnitParamsRunner;

@RunWith(JUnitParamsRunner.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING) // the test methods in this test file can run in any order but I prefer a fixed order
public class SeleniumTC_Repairer extends RepairerFunctions {
	static SQLConnection DBMgr = SQLConnection.getInstance();
	private StringBuffer verificationErrors = new StringBuffer();
	public String sAppURL, sSharedUIMapPath, testDelay;

	@Before
	public void setUp() throws Exception {
		//		MAGIC CODE GOES HERE 
		driver = invokeCorrectBrowser();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		prop = new Properties();	  
		prop.load(new FileInputStream("./Configuration/CM_Configuration.properties"));
		sAppURL = prop.getProperty("sAppURL");
		sSharedUIMapPath = prop.getProperty("SharedUIMap");
		testDelay=prop.getProperty("testDelay");
		prop.load(new FileInputStream(sSharedUIMapPath));
	}
	/*
	 * private static ArrayList<Company> ReturnMatchingCompaniesList () {
	 * ArrayList<Company> companyListInDB = new ArrayList<Company>();
	 * 
	 * Statement stmt = null; Connection conn = SQLConnection.getDBConnection(); try
	 * { stmt = conn.createStatement(); ResultSet companyList =
	 * stmt.executeQuery(" SELECT * from COMPANY ORDER BY company_name"); while
	 * (companyList.next()) { Company company = new Company();
	 * company.setIdcompany(companyList.getString("idcompany"));
	 * company.setCompany_name(companyList.getString("company_name"));
	 * company.setPhone(companyList.getString("phone"));
	 * company.setEmail(companyList.getString("email"));
	 * companyListInDB.add(company); } } catch (SQLException e) {} return
	 * companyListInDB; }
	 */

	public static ArrayList<Repairer> searchRepairer() throws SQLException, ClassNotFoundException {
		Statement stmt = null;   
		Class.forName("com.mysql.jdbc.Driver"); 
		String assignedTo = "Yashavlani";
		Connection conn = SQLConnection.getDBConnection();
		String query = "SELECT * FROM mac_facility.mar_details where assigned_to = '"+assignedTo+"';";
		System.out.println("User Search Query ..."+query);
		ArrayList<Repairer> repairerList=new ArrayList<Repairer>();  
		try {
			conn = SQLConnection.getDBConnection();  
			conn.setAutoCommit(false);
			stmt = conn.createStatement();
			ResultSet results = stmt.executeQuery(query);
			System.out.println(results);
			while(results.next()) {
				Repairer repairer = new Repairer();
				repairer.setId(results.getString("mar_number"));
				repairer.setFacility_name(results.getString("facility_name"));
				repairer.setFacility_type(results.getString("facility_type"));
				repairer.setStartDate(results.getString("date"));
				repairer.setStartTime(results.getString("time"));
				//				repairer.setFloor(results.getString("floor"));
				repairerList.add(repairer);
			}
			System.out.println(repairerList);
		}catch (SQLException e) {
			e.printStackTrace();
		}finally {
			stmt.close();
			conn.close();
		}
		return repairerList;
	}


	private String [][] getTableContentsFromPage(int listSize, Boolean isModify) { // this method gets the list company table contents from the web page
		String [][] reservationListArray = new String[listSize-1][5];
		for (int i=0; i<listSize-1; i++) {
			System.out.println("for loop i " + i);
			System.out.println(prop.getProperty("listReservation_prefixResrvationTable")+(i+1)+
					prop.getProperty("listResrvation_ResevationTableIDColInput"));
			reservationListArray[i][0]=  driver.findElement(By.xpath(prop.getProperty("listReservation_prefixResrvationTable")+(i+1)+
					prop.getProperty("listResrvation_ResevationTableIDColInput"))).getText();
			reservationListArray[i][1] = driver.findElement(By.xpath(prop.getProperty("listReservation_prefixResrvationTable")+(i+1)+
					prop.getProperty("listResrvation_ResevationTableTypeCol"))).getText();
			reservationListArray[i][2] = driver.findElement(By.xpath(prop.getProperty("listReservation_prefixResrvationTable")+(i+1)+
					prop.getProperty("listResrvation_ResevationTableNameCol"))).getText();
			reservationListArray[i][3] = driver.findElement(By.xpath(prop.getProperty("listReservation_prefixResrvationTable")+(i+1)+
					prop.getProperty("listResrvation_ResevationTableDateCol"))).getText();
			
			if (isModify) {
				reservationListArray[i][4] = driver.findElement(By.xpath(prop.getProperty("listReservation_prefixResrvationTable")+(i+1)+
						prop.getProperty("listResrvation_ResevationTableTimeColInput"))).getAttribute("value");

			} else {
				reservationListArray[i][4] = driver.findElement(By.xpath(prop.getProperty("listReservation_prefixResrvationTable")+(i+1)+
						prop.getProperty("listResrvation_ResevationTableTimeCol"))).getText();

			}
						
			
			System.out.println("ID val : " + reservationListArray[i][0]);
		}
		System.out.println("Webpage Array length " + reservationListArray.length);

		return reservationListArray;
	}

	private String [][] getReservationListFromDB(int listSize) throws SQLException, ClassNotFoundException { // this method gets the list company table contents from the DB
		ArrayList<Repairer> fromDB= searchRepairer();
		String [][] arrayDB = new String [listSize-1][5];
		int i=0;
		for (Repairer p:fromDB) {
			arrayDB[i][0]=p.getId();
			arrayDB[i][1]=p.getFacility_type();
			arrayDB[i][2]=p.getFacility_name();
			arrayDB[i][3]=p.getStartDate();
			arrayDB[i][4]=p.getStartTime();
			i++;
		}

		return arrayDB;
	}

	private Boolean arraysDiff (String [][] array1, String [][] array2, String methodTest) { // this method compares the contents of the two tables
		System.out.println(array1.length);
		System.out.println(array2.length);
		
		Boolean diff=false || (array1.length!=array2.length);

		for (int i=0;i<array1.length && !diff;i++) {

			diff  = !array1[i][0].equals(array2[i][0]) || !array1[i][1].equals(array2[i][1]) || 
					!array1[i][2].equals(array2[i][2]) || !array1[i][3].equals(array2[i][3]) || !array1[i][4].equals(array2[i][4]);
		}

		//		if (methodTest.equalsIgnoreCase("ViewRepair")) {
		//			for (int i=0;i<array1.length && !diff;i++) {
		//
		//				diff  = !array1[i][0].equals(array2[i][0]) || !array1[i][1].equals(array2[i][1]) || 
		//						!array1[i][2].equals(array2[i][2]) || !array1[i][3].equals(array2[i][3]) || !array1[i][4].equals(array2[i][4]);
		//			}
		//		} 
		//		else {
		//			for (int i=0;i<array1.length && !diff;i++) {
		//
		//				diff  = !array1[i][1].equals(array2[i][1]) || 
		//						!array1[i][2].equals(array2[i][2]) || !array1[i][3].equals(array2[i][3]) || !array1[i][4].equals(array2[i][4]);
		//			}
		//		} 

		return diff;
	}

	@Test
	@FileParameters("tests/Excel/TC01a_Repairer.csv")
	public void TC01a(int testCaseNumber, String col1, String col2, String col3, String col4, String col5) throws Exception {

		String methodName= new Throwable().getStackTrace()[0].getMethodName();
		driver.get(sAppURL);
		MAC_Login(driver, "Yashavlani","Yash123#",methodName+" LoginFunction test case 1");

		MainApp_function(driver,FunctionEnum.listReservation); //select list Companies from homepage
		// check company listing headers
		verifyHeaders(driver,"listReservation_col1_Header",col1,"listReservation_col2_Header",col2,
				"listReservation_col3_Header",col3,"listReservation_col4_Header",col4,
				"listReservation_col5_Header",col5,methodName+" verifyHeaders test case "+testCaseNumber);
		//	    verifyContents(driver,"listReservation_Reservation_ID_value",data1,"listReservation_Reservation_Type_value",data2,
		//					 "listReservation_Reservation_Name_value",data3,"listReservation_Reservation_StartDate_value",data4,"listReservation_Reservation_StartTime_value",data5,methodName+" verifyContents test case "+testCaseNumber);
		WebElement reservationTable = driver.findElement(By.xpath(prop.getProperty("listReservation_reservationTable")));
		int rows = reservationTable.findElements(By.tagName("tr")).size(); //find the number of rows in the table including the header

		assertFalse(arraysDiff(getReservationListFromDB(rows),getTableContentsFromPage(rows,false),"ViewRepair"));
		driver.findElement(By.xpath(prop.getProperty("listCompany_repairerHomeLink"))).click(); //go back to homepage

	}


	@Test
	@FileParameters("tests/Excel/TC01b_Repairer.csv")
	public void TC01b(int testCaseNumber, String path1, String col1, String col2, String col3, String col4, String col5, String data1, String data2, String data3, String data4, String data5) throws Exception {
		String methodName= new Throwable().getStackTrace()[0].getMethodName();
		driver.get(sAppURL);
		MAC_Login(driver, "Yashavlani","Yash123#",methodName+" LoginFunction test case 1");
		MainApp_function(driver,FunctionEnum.listReservation); //select list Companies from homepage
		// now we select a company
		System.out.println("Path 1 " + driver.findElement(By.xpath(path1)));
		Thread.sleep(3_000);
		driver.findElement(By.xpath(path1)).click();

		verifyHeaders(driver,"listSpecificReservation_FacilityType_title",col1,"listSpecificReservation_FacilityName_title",col2,
				"listSpecificReservation_StartDate_title",col3,"listSpecificReservation_StartTime_title",col4,
				"listSpecificReservation_Description_title",col5,methodName+" verifyHeaders test case "+testCaseNumber);

		//		verifyHeaders(driver,"listSpecificCompany_Company_ID_title",col1,"listSpecificCompany_Company_Name_title",col2,
		//									         "listSpecificCompany_Phone_title",col3,"listSpecificCompany_Email_title",col4,"","",methodName+" verifyHeaders test case "+testCaseNumber);
		verifyContents(driver,"listSpecificReservation_FacilityType_value",data1,"listSpecificReservation_FacilityName_value",data2,
				"listSpecificReservation_StartDate_value",data3,"listSpecificReservation_StartTime_value",data4,"listSpecificReservation_Description_value",data5,methodName+" verifyContents test case "+testCaseNumber);

		driver.findElement(By.xpath(prop.getProperty("listCompany_repairerHomeLink"))).click(); //go back to homepage	
	}

	@Test
	@FileParameters("tests/Excel/TC02a_Repairer.csv")
	public void TC02a(int testCaseNumber,String requestMessage, String col1, String col2, String col3, String col4, String col5) throws Exception {

		String methodName= new Throwable().getStackTrace()[0].getMethodName();
		driver.get(sAppURL);
		MAC_Login(driver, "Yashavlani","Yash123#",methodName+" LoginFunction test case 1");

		MainApp_function(driver,FunctionEnum.requestReservation); //select list Companies from homepage
		// check company listing headers
		verifyHeaders(driver,"listReservation_col1_Header",col1,"listReservation_col2_Header",col2,
				"listReservation_col3_Header",col3,"listReservation_col4_Header",col4,
				"listReservation_col5_Header",col5,methodName+" verifyHeaders test case "+testCaseNumber);
		WebElement reservationTable = driver.findElement(By.xpath(prop.getProperty("listReservation_reservationTable")));
		int rows = reservationTable.findElements(By.tagName("tr")).size(); //find the number of rows in the table including the header

		assertFalse(arraysDiff(getReservationListFromDB(rows),getTableContentsFromPage(rows,false),"RequestRepair"));
		Thread.sleep(2_000);

		driver.findElement(By.xpath(prop.getProperty("listReservation_requestButton"))).click();
		Thread.sleep(2_000);

		String jspMessage = driver.findElement(By.xpath(prop.getProperty("listReservation_requestConfirmationMessage"))).getAttribute("value");

		assertEquals(requestMessage, jspMessage);
		//		System.out.println(driver.findElement(By.xpath(prop.getProperty("listReservation_cancelConfirmationMessage"))).getText());
		Thread.sleep(2_000);
		driver.findElement(By.xpath(prop.getProperty("listCompany_repairerHomeLink"))).click(); //go back to homepage
		Thread.sleep(2_000);
		driver.findElement(By.xpath(prop.getProperty("MainApp_LogoutLink"))).click();

	}

	@Test
	@FileParameters("tests/Excel/TC03a_Repairer.csv")
	public void TC03a(int testCaseNumber,String modificationMessage, String col1, String col2, String col3, String col4, String col5) throws Exception {

		String methodName= new Throwable().getStackTrace()[0].getMethodName();
		driver.get(sAppURL);
		MAC_Login(driver, "Yashavlani","Yash123#",methodName+" LoginFunction test case 1");

		MainApp_function(driver,FunctionEnum.modifyReservation); //select list Companies from homepage
		// check company listing headers
		verifyHeaders(driver,"listReservation_col1_Header",col1,"listReservation_col2_Header",col2,
				"listReservation_col3_Header",col3,"listReservation_col4_Header",col4,
				"listReservation_col5_Header",col5,methodName+" verifyHeaders test case "+testCaseNumber);

		WebElement reservationTable = driver.findElement(By.xpath(prop.getProperty("listReservation_reservationTable")));
		int rows = reservationTable.findElements(By.tagName("tr")).size(); //find the number of rows in the table including the header

		assertFalse(arraysDiff(getReservationListFromDB(rows),getTableContentsFromPage(rows,true),"ModifyRepair"));
		Thread.sleep(2_000);

		driver.findElement(By.xpath(prop.getProperty("listReservation_modifyButton"))).click();
		Thread.sleep(2_000);

		String jspMessage = driver.findElement(By.xpath(prop.getProperty("listReservation_cancelConfirmationMessage"))).getAttribute("value");

		assertEquals(modificationMessage, jspMessage);

		Thread.sleep(2_000);
		driver.findElement(By.xpath(prop.getProperty("listCompany_repairerHomeLink"))).click(); //go back to homepage
		Thread.sleep(2_000);
		driver.findElement(By.xpath(prop.getProperty("MainApp_LogoutLink"))).click();

	}

	@Test
	@FileParameters("tests/Excel/TC04a_Repairer.csv")
	public void TC04a(int testCaseNumber,String cancelationMessage, String col1, String col2, String col3, String col4, String col5) throws Exception {

		String methodName= new Throwable().getStackTrace()[0].getMethodName();
		driver.get(sAppURL);
		MAC_Login(driver, "Yashavlani","Yash123#",methodName+" LoginFunction test case 1");

		MainApp_function(driver,FunctionEnum.cancelReservation); //select list Companies from homepage
		// check company listing headers
		verifyHeaders(driver,"listReservation_col1_Header",col1,"listReservation_col2_Header",col2,
				"listReservation_col3_Header",col3,"listReservation_col4_Header",col4,
				"listReservation_col5_Header",col5,methodName+" verifyHeaders test case "+testCaseNumber);
		//		    verifyContents(driver,"listReservation_Reservation_ID_value",data1,"listReservation_Reservation_Type_value",data2,
		//						 "listReservation_Reservation_Name_value",data3,"listReservation_Reservation_StartDate_value",data4,"listReservation_Reservation_StartTime_value",data5,methodName+" verifyContents test case "+testCaseNumber);
		WebElement reservationTable = driver.findElement(By.xpath(prop.getProperty("listReservation_reservationTable")));
		int rows = reservationTable.findElements(By.tagName("tr")).size(); //find the number of rows in the table including the header

		assertFalse(arraysDiff(getReservationListFromDB(rows),getTableContentsFromPage(rows,false),"CancelRepair"));
		Thread.sleep(2_000);

		driver.findElement(By.xpath(prop.getProperty("listReservation_cancelButton"))).click();
		Thread.sleep(2_000);

		String jspMessage = driver.findElement(By.xpath(prop.getProperty("listReservation_cancelConfirmationMessage"))).getAttribute("value");

		assertEquals(cancelationMessage, jspMessage);
		//		System.out.println(driver.findElement(By.xpath(prop.getProperty("listReservation_cancelConfirmationMessage"))).getText());
		Thread.sleep(2_000);
		driver.findElement(By.xpath(prop.getProperty("listCompany_repairerHomeLink"))).click(); //go back to homepage
		Thread.sleep(2_000);
		driver.findElement(By.xpath(prop.getProperty("MainApp_LogoutLink"))).click();


	}



}