package MAC_Facility.data;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import MAC_Facility.model.Login;
import MAC_Facility.util.SQLConnection;

public class LoginDAO {

	static SQLConnection DBMgr = SQLConnection.getInstance();
	static Connection conn = SQLConnection.getDBConnection();  

	public static String[] UserLogin(Login login) {
		Statement stmt = null;   
//		Connection conn = SQLConnection.getDBConnection();  
		
		String role = "";
		String uname = login.getUsername();
		String pwd = login.getPassword();
//		System.out.println(uname);
//		System.out.println(pwd);
		
        String[] ans = new String[2]; 

		String login_query = "SELECT * FROM mac_facility.all_users WHERE username='"+uname+"' and password='"+pwd+"'";					

		
//		String register = "SELECT * FROM mac_facility.all_users";
		try {
//			conn = SQLConnection.getDBConnection();  
			conn.setAutoCommit(false);
			stmt = conn.createStatement();
//			stmt = conn.createStatement();
			ResultSet results = stmt.executeQuery(login_query);
			conn.commit();		
//			System.out.println(results);
			if(results.next()) {

//	              System.out.println("login successful");
	              ans[0] = results.getString(12);
	              ans[1] = results.getString(9);
	        }
			else {
	              System.out.println("login failed");
			}
			System.out.println("Connection Successful");
		} catch (SQLException e) {
//		       System.err.println(e);
		}
		return ans;   
		
	}
	
	//unique employeeID
	//list employees
//	public static Boolean uniqueUsername(String username) {  
//		Statement stmt = null;   
//		Connection conn = null;  
//		conn = SQLConnection.getDBConnection();  
//		ArrayList<Registration> registerListInDB = new ArrayList<Registration>();
//		try {
//			stmt = conn.createStatement();
//			String searchEmployee = " SELECT * from EMPLOYEE WHERE IDEMPLOYEE = '"+idEmp+"' ORDER BY surname";
//			ResultSet employeeList = stmt.executeQuery(searchEmployee);
//			while (employeeList.next()) {
//				Employee employee = new Employee(); 
//				String idemployee = employeeList.getString("idemployee");
//				String name  = employeeList.getString("name");
//				String surname  = employeeList.getString("surname");
//				String badge  = employeeList.getString("badge");				 
//				employee.setIdemployee(idemployee);  
//				employee.setName(name);
//				employee.setSurname(surname);
//				employee.setBadge(badge);
//				employeeListInDB.add(employee);	 
//			} 
//		} catch (SQLException e) {}    
//		return employeeListInDB.isEmpty();
//	}
	
	//list employees
//	public static ArrayList<Employee> listEmployees(String idComp) {  
//		Statement stmt = null;   
//		Connection conn = null;  
//		ArrayList<Registration> registerListInDB = new ArrayList<Registration>();
//		conn = SQLConnection.getDBConnection(); 
//		try {
//		stmt = conn.createStatement();
//		String searchEmployee = " SELECT * from EMPLOYEE WHERE FK_COMPANY = '"+idComp+"' ORDER BY surname";
//
//		ResultSet employeeList = stmt.executeQuery(searchEmployee);
//
//		while (employeeList.next()) {
//			Employee employee = new Employee(); 
//			String idemployee = employeeList.getString("idemployee");
//			String name  = employeeList.getString("name");
//			String surname  = employeeList.getString("surname");
//			String badge  = employeeList.getString("badge");				 
//			employee.setIdemployee(idemployee);  
//			employee.setName(name);
//			employee.setSurname(surname);
//			employee.setBadge(badge);
//			employeeListInDB.add(employee);	 
//		} 
//		} catch (SQLException e) {}    
//		return employeeListInDB;
//	}
}