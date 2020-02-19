// UserDAO.java
package MAC_Facility.data;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import MAC_Facility.model.User;
import MAC_Facility.util.SQLConnection;

public class UserDAO {

	static SQLConnection DBMgr = SQLConnection.getInstance();

	private static ArrayList<User> ReturnMatchingUsersList(String queryString) {
		System.out.println("queryString = "+queryString);
		ArrayList<User> userListInDB = new ArrayList<User>();

		Statement stmt = null;
		Connection conn = SQLConnection.getDBConnection();
		try {
			stmt = conn.createStatement();
			ResultSet userList = stmt.executeQuery(queryString);
			while (userList.next()) {
				User user = new User();

				user.setUser_name(userList.getString("username"));
				user.setLast_name(userList.getString("lastName"));
				user.setfirst_Name(userList.getString("firstName"));
				user.setPhone(userList.getString("contact"));
				user.setEmail(userList.getString("email"));
				user.setUserRole(userList.getString("role"));
								
				userListInDB.add(user);
			}
		} catch (SQLException e) {
		}
		return userListInDB;
	}

//	 private static void StoreListinDB (Company company,String queryString) {
//	 	Statement stmt = null;
//	 	Connection conn = SQLConnection.getDBConnection();  
//	 	try {
//	 		stmt = conn.createStatement();
//	 		String insertCompany = queryString + " VALUES ('"  
//	 				+ company.getIdcompany()  + "','"
//	 				+ company.getCompany_name() + "','"		
//	 				+ company.getPhone() + "','"
//	 				+ company.getEmail() + "',"
//	 				+ " SYSDATE())";
//	 		stmt.executeUpdate(insertCompany);	
//	 		conn.commit(); 
//	 	} catch (SQLException e) {}
//	 }

	// public static void insertCompany(Company company) {
	// StoreListinDB(company,"INSERT INTO COMPANY
	// (idcompany,company_name,phone,email,date_ins) ");
	// }

	// public static ArrayList<Company> listCompanies() {
	// return ReturnMatchingCompaniesList(" SELECT * from COMPANY ORDER BY
	// company_name");
	// }

	// search user
	public static ArrayList<User> searchUsers(String username) {
		System.out.println("inside UserDAO function searchUsers");
		return ReturnMatchingUsersList(
				" SELECT * from mac_facility.all_users WHERE lastName LIKE '%" + username + "%' ORDER BY '%" + username + "%'"); // Change
	}
	
//	public static Boolean uniqueUserName(String username) {     
//		Connection conn = null;  
//		boolean result = false;
//		
//		conn = SQLConnection.getDBConnection();  
//		
//		try {
//			java.sql.PreparedStatement st = conn.prepareStatement("SELECT * from mac_facility.all_users WHERE username = ?");
//			
//			st.setString(1, username);
//			
//			ResultSet userList = st.executeQuery();
//			
//			if(userList.next()) {
//				result = false;
//			}else {
//				result = true;
//			}
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//		return result;
//	}
	
	public static Boolean userExists(String username) {     
		Connection conn = null;  
		boolean result = false;
		
		conn = SQLConnection.getDBConnection();  
		
		try {
			java.sql.PreparedStatement st = conn.prepareStatement("SELECT * from mac_facility.all_users WHERE username = ?");
			
			st.setString(1, username);
			
			ResultSet userList = st.executeQuery();
			
			if(userList.next()) {
				result = true;
			}else {
				result = false;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}

	private static void ModifyRoleinTable (String queryString, String username, String role) throws SQLException {
		System.out.println(queryString);
		Statement stmt = null;
		Connection conn = SQLConnection.getDBConnection();
		
		java.sql.PreparedStatement prep_stmt = conn.prepareStatement(queryString);
		prep_stmt.setString(1, role);
		prep_stmt.setString(2, username);
		  
		try {
			stmt = conn.createStatement();
			
			int res = prep_stmt.executeUpdate();	
			System.out.println(res);
			conn.commit(); 
		} catch (SQLException e) {}
	}

	public static void modifyUser(String username, String role) throws SQLException{
		System.out.println("in modifyUser");
		System.out.println(username);
		System.out.println(role);
//		String prep_query = "update mac_facility.all_users set role = ? where username = ?";
		
		ModifyRoleinTable("UPDATE mac_facility.all_users set role = ? WHERE username = ?",username,role);
	}

	// //determine if companyID is unique
	// public static Boolean CompanyIDunique(String idComp) {
	// return (ReturnMatchingCompaniesList(" SELECT * from COMPANY WHERE IDCOMPANY =
	// '"+idComp+"' ORDER BY company_name").isEmpty());
	// }
	// //search company with company ID
	// public static ArrayList<Company> searchCompany (String idComp) {
	// return ReturnMatchingCompaniesList(" SELECT * from COMPANY WHERE IDCOMPANY =
	// '"+idComp+"' ORDER BY company_name");
	// }
}