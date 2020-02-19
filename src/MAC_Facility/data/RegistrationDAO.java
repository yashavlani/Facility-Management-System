package MAC_Facility.data;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import MAC_Facility.model.Registration;
import MAC_Facility.util.SQLConnection;

public class RegistrationDAO {
	static SQLConnection DBMgr = SQLConnection.getInstance();
	static Connection conn = SQLConnection.getDBConnection();  

	public static void Register(Registration registration) {
		Statement stmt = null;   
//		Connection conn = SQLConnection.getDBConnection();  
		String register = "INSERT INTO mac_facility.all_users (username, password, firstName, lastName, address, city, state, zipCode, utaId, contact,email, role) ";					
		register += " VALUES ('"  
				+ registration.getUsername() + "','"
				+ registration.getPassword() + "','"
				+ registration.getFirstName()  + "','"
				+ registration.getLastName() + "','"
				+ registration.getAddress() + "','"
				+ registration.getCity() + "','"
				+ registration.getState() + "','" 
				+ registration.getZipCode() + "','"
				+ registration.getUtaId() + "','"
				+ registration.getContact() + "','"		
				+ registration.getEmail() + "','"
				+ registration.getRole() + "')";
		
//		String register = "SELECT * FROM mac_facility.all_users";
		try {
//			conn = SQLConnection.getDBConnection();  
			conn.setAutoCommit(false);
			stmt = conn.createStatement();
//			stmt = conn.createStatement();
			stmt.executeUpdate(register);
			conn.commit();		
//			System.out.println("Connection Successful");
		} catch (SQLException e) {
		       System.err.println(e);
		}   
	}
		
		public static Boolean UserExists(Registration user_exists) {
			Boolean res = true;
			Statement stmt = null;   
//			Connection conn = SQLConnection.getDBConnection();  
			
			
			String new_utaID = user_exists.getUtaId();
			String user_exists_query = "SELECT * FROM mac_facility.all_users WHERE utaId = '"+new_utaID+"'";	
			
			try {
//				conn = SQLConnection.getDBConnection();  
				conn.setAutoCommit(false);
				stmt = conn.createStatement();
//				stmt = conn.createStatement();
				ResultSet results = stmt.executeQuery(user_exists_query);
				conn.commit();		
				if(results.next()) {
					res = false;					
		        }
				else {
					res = true;
				}
			} catch (SQLException e) {
//			       System.err.println(e);
			}
//			System.out.println(new_utaID);
			return res;   
		}
		
		public static void UpdateProfile(Registration updateProfile) {
			Statement stmt = null;   
			
//			Connection conn = SQLConnection.getDBConnection();  
//			String register = "INSERT INTO mac_facility.all_users (username, password, firstName, lastName, address, city, state, zipCode, utaId, contact,email, role) ";					
//			register += " VALUES ('"  
//					+ registration.getUsername() + "','"
//					+ registration.getPassword() + "','"
//					+ registration.getFirstName()  + "','"
//					+ registration.getLastName() + "','"
//					+ registration.getAddress() + "','"
//					+ registration.getCity() + "','"
//					+ registration.getState() + "','" 
//					+ registration.getZipCode() + "','"
//					+ registration.getUtaId() + "','"
//					+ registration.getContact() + "','"		
//					+ registration.getEmail() + "','"
//					+ registration.getRole() + "')";
			
			String uname = updateProfile.getFk_username();
			String pwd = updateProfile.getPassword();
			String fname = updateProfile.getFirstName();
			String lname = updateProfile.getLastName();
			String address = updateProfile.getAddress();
			String city = updateProfile.getCity();
			String state = updateProfile.getState();
			String zipcode = updateProfile.getZipCode();
			String utaid = updateProfile.getUtaId();
			String contact = updateProfile.getContact();
			String email = updateProfile.getEmail();
			String role = updateProfile.getRole();
			
			String update_profile_query = "UPDATE mac_facility.all_users SET password = '"+pwd+"', firstName = '"+fname+"',lastName = '"+lname+"',address = '"+address+"',city = '"+city+"',state = '"+state+"',zipCode = '"+zipcode+"',contact = '"+contact+"',email = '"+email+"',role = '"+role+"' WHERE username = '"+uname+"'";
			
//			String register = "SELECT * FROM mac_facility.all_users";
			try {
//				conn = SQLConnection.getDBConnection();  
				conn.setAutoCommit(false);
				stmt = conn.createStatement();
//				stmt = conn.createStatement();
				stmt.executeUpdate(update_profile_query);
//				ResultSet results = stmt.executeQuery(update_profile_query);
				conn.commit();		
//				System.out.println("Connection Successful");
			} catch (SQLException e) {
			       System.err.println(e);
			}   
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