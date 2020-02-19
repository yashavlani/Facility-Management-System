package MAC_Facility.data;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import MAC_Facility.model.MARForm;
import MAC_Facility.model.Registration;
import MAC_Facility.util.SQLConnection;

public class CreateMarDAO {

	static SQLConnection DBMgr = SQLConnection.getInstance();
	static Connection conn = SQLConnection.getDBConnection();  

	public static void createMar(MARForm mf) {
		
		Calendar cal = Calendar.getInstance();
		SimpleDateFormat simpleformat = new SimpleDateFormat("dd/MMMM/yyyy hh:mm:s");

		Format f = new SimpleDateFormat("MM/dd/yy");
	    String strDate = f.format(new Date());
	        
	    Format f1 = new SimpleDateFormat("HH.mm");
	    String strTime = f1.format(new Date());
		    
		Statement stmt = null;   
		String createMar_query = "INSERT INTO mac_facility.mar_details (facility_type, facility_name, description, reported_by, date,time) ";					
		createMar_query += " VALUES ('"  
				+ mf.getFacilityType() + "','"
				+ mf.getFacilityName() + "','"
				+ mf.getDescription()  + "','"
				+ mf.getFk_username() + "','" 
				+ strDate + "','"	
				+ strTime + "')";		
		
//		String register = "SELECT * FROM mac_facility.all_users";
		try {
//			conn = SQLConnection.getDBConnection();  
			conn.setAutoCommit(false);
			stmt = conn.createStatement();
//			stmt = conn.createStatement();
			stmt.executeUpdate(createMar_query);
			conn.commit();		
//			System.out.println("Connection Successful");
		} catch (SQLException e) {
		       System.err.println(e);
		}   
	}
	
//		public List<MARForm> list() throws SQLException {
//			List<MARForm> listFacility = new ArrayList<>();
//			
//			try {
//	            String sql = "SELECT DISTINCT facility_type FROM mac_facility.mac_facilities";
//	            Statement stmt = null;   
//	    		Connection conn = SQLConnection.getDBConnection();  
//	            Statement statement = conn.createStatement();
//	            ResultSet result = statement.executeQuery(sql);
//	             
//	            while (result.next()) {
//					MARForm Mform2 = new MARForm();
//	                String facility_type1 = result.getString("facility_type");
////	                String facility_name1 = result.getString("facility_name");
//	                Mform2.setFacility_type1(facility_type1);
////	                Mform2.setFacility_name1(facility_name1);
//	                listFacility.add(Mform2);
//	            }          
//	             
//	        } catch (SQLException ex) {
//	            ex.printStackTrace();
//	            throw ex;
//	        }
//			
//			for(MARForm model : listFacility) {
//                System.out.println("print LIST IN dao");
////                System.out.println(model.getFacility_name1());
//                System.out.println(model.getFacility_type1());
//
//            }
// 
//	         
//	        return listFacility;
//		}
		
		public ArrayList<MARForm> searchMar(String login_username) {
			    
			Statement stmt = null;  
			ArrayList<MARForm> Mform1_list = new ArrayList<MARForm>();

			Connection conn = SQLConnection.getDBConnection();  
	        String[] ans = new String[2]; 
//			String uname = mf.getFk_username();
			String search_mar_query = "SELECT * FROM mac_facility.mar_details WHERE reported_by = '"+login_username+"'";	
			
//			System.out.println("QUERY PRINTED" +search_mar_query);
			
			try {
				conn = SQLConnection.getDBConnection();  
				conn.setAutoCommit(false);
				stmt = conn.createStatement();
				ResultSet results = stmt.executeQuery(search_mar_query);
				System.out.println("Connection Successful");
				while(results.next()) {
					MARForm Mform1 = new MARForm();

//		              System.out.println("login successful");
					Mform1.setFacilityType(results.getString("facility_type"));
//					System.out.println("facility_type"+ results.getString("facility_type"));
					Mform1.setFacilityName(results.getString("facility_name"));
//					System.out.println("facility_type"+ results.getString("facility_name"));
					Mform1.setDescription(results.getString("description"));
					Mform1.setReportedBy(results.getString("reported_by"));
					Mform1.setstrDate(results.getString("date"));
					Mform1.setstrTime(results.getString("time"));
					Mform1.setMar(results.getString("mar_number"));
					
					Mform1_list.add(Mform1);
		        }
				

			} catch (SQLException e) {
//			       System.err.println(e);
			}   
			System.out.println(Mform1_list);
			return Mform1_list;
	}
		
//		public static List<MARForm> getFacilityName(String facility_type1) throws SQLException {
//			List<MARForm> listFacilityName = new ArrayList<>();
//			
//		try {
//			
//			Statement stmt = null;   
//			Connection conn = SQLConnection.getDBConnection();  
//			String get_facility_name_query = "SELECT facility_name FROM mac_facility.mac_facilities WHERE facility_type = '"+facility_type1+"' ";
//            Statement statement = conn.createStatement();
//            ResultSet result = statement.executeQuery(get_facility_name_query);
//             
//            while (result.next()) {
//				MARForm Mform3 = new MARForm();
//                String facility_name1 = result.getString("facility_name");
//                Mform3.setFacility_name1(facility_name1);
//                listFacilityName.add(Mform3);
//            }          
//             
//        } catch (SQLException ex) {
//            ex.printStackTrace();
//            throw ex;
//        }
//		
//		for(MARForm model : listFacilityName) {
//            System.out.println("print LIST IN dao");
////            System.out.println(model.getFacility_name1());
//            System.out.println(model.getFacility_name1());
//
//        }
//
//         
//        return listFacilityName;
//	}
		
}