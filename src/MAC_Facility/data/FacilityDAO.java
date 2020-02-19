package MAC_Facility.data;



import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import MAC_Facility.model.Facility;
import MAC_Facility.model.MARForm;
import MAC_Facility.util.SQLConnection;




public class FacilityDAO {
static SQLConnection DBMgr = SQLConnection.getInstance();
private static Facility fac;
	
	private static ArrayList<MARForm> ReturnMatchingMAR (String queryString, String action) {
		Statement stmt = null;
		Connection conn = SQLConnection.getDBConnection();
		ArrayList<MARForm> mar_list = new ArrayList<MARForm>();
		try {
			stmt = conn.createStatement();
			ResultSet companyList = stmt.executeQuery(queryString);
			while (companyList.next()) {
					MARForm mar = new MARForm();
					mar.setFacilityName(companyList.getString("facility_name"));
					mar.setFacilityType(companyList.getString("facility_type"));
					mar.setUrgency(companyList.getString("Urgency"));
					mar.setDescription(companyList.getString("description"));
					mar.setReportedBy(companyList.getString("reported_by"));
					mar.setFacilityName(companyList.getString("facility_name"));
					mar.setstrDate(companyList.getString("date"));
					mar.setstrTime(companyList.getString("time"));
					mar.setAssigned_to(companyList.getString("assigned_to"));
					mar.setMar(companyList.getString("mar_number"));
					
					
					mar_list.add(mar);
				}
		} catch (SQLException e) {}
		return mar_list;
	}


	private static void runQuery(boolean update, String queryString) {
		Statement stmt = null;
		Connection conn = SQLConnection.getDBConnection();  
		try {
			stmt = conn.createStatement();
			System.out.println("Firing Query: "+queryString);
			if(update)
				stmt.executeUpdate(queryString);	
//			else 
//				stmt.execute(queryString);
			//System.out.println("Facility Added!");
			conn.commit(); 
		} catch (SQLException e) {}
	}
	
	public static ArrayList<String> getUnassignedMARList(){
		String queryString = "SELECT concat(mar_number, ' | ', facility_name, ' | ', facility_type) as detail FROM Mac_Facility.mar_details";
		Statement stmt = null;
		Connection conn = SQLConnection.getDBConnection();
		ArrayList<String> list = new ArrayList<String>();
		try {
			stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(queryString);
			while (rs.next()) {
				list.add(rs.getString("detail"));
			}
		} catch (SQLException e) {
//			System.out.println("Error occured: "+e);
		}
		return list;
		
	}
	
	public static void assignRepairer(String record, String repairer,String date) {
		String mar_num = record.split("\\|")[0].trim();
		String queryString = "update mar_details set assigned_to = '"+repairer+"',date='"+date+"' where mar_number='"+mar_num+"'";

		runQuery(true, queryString);
	
	}
	
//	public static void updateMAR(String record, String urgency, String time) {
//		String mar_num = record.split("\\|")[0].trim();
//		String queryString = "update mar_details set urgency = '"+urgency+"', time='"+time+"' where mar_number='"+mar_num+"'";
//		runQuery(true, queryString);
//	}
//	
	
	public static ArrayList<Facility>  listfacilities(String queryString, String Action) throws SQLException{  
		System.out.print(queryString);
		Statement stmt = null;
		Connection conn = SQLConnection.getDBConnection();
		ArrayList<Facility> facilities = new ArrayList<Facility>();
		try {
			stmt = conn.createStatement();
			ResultSet facilityList = stmt.executeQuery(queryString);
			while (facilityList.next()) {
					Facility fac = new Facility();
					fac.setIDFacility(facilityList.getString("idFacility"));
					fac.setFacility_name(facilityList.getString("FacilityName"));
					fac.setType(facilityList.getString("Type"));
					fac.setInterval(facilityList.getString("Interval"));
					fac.setDuration(facilityList.getString("Duration"));
					facilities.add(fac);
			}
		} catch (SQLException e) {
//			System.out.println("Error occured: "+e);
		}
		return facilities;

		
	}
	
	//search companies
	
	public static ArrayList<MARForm> searchMAR(String searchMAR){
		return ReturnMatchingMAR("SELECT * from mar_details where assigned_to is null","searchMAR");
		
	}
	
	public static ArrayList<String> getRepairers(){
		String queryString = "select username from all_users where role='repairer'";
		Statement stmt = null;
		Connection conn = SQLConnection.getDBConnection();
		ArrayList<String> list = new ArrayList<String>();
		try {
			stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(queryString);
			while (rs.next()) {
				list.add(rs.getString("username"));
			}
		} catch (SQLException e) {
//			System.out.println("Error occured: "+e);
		}
		return list;
		
	}
	public static boolean checkFacility(String name) {

		Connection conn = SQLConnection.getDBConnection();
		boolean isValid = false;
		try {
			java.sql.PreparedStatement prepareStatement = conn.prepareStatement("select * from Facility where idFacility = ?");
			prepareStatement.setString(1, name);
			ResultSet results = prepareStatement.executeQuery();
			if (results.next()) {
				isValid = true;
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return isValid;
	}
	
	public static void insertFacility(Facility facility){
		StringBuilder sb = new StringBuilder("Insert into Facility values(");
		sb.append("\""+facility.getIdfacility()+"\",");
		sb.append("\""+facility.getfacility_name()+"\",");
		sb.append("\""+facility.getType()+"\",");
		sb.append("\""+facility.getInterval()+"\",");
		sb.append("\""+facility.getDuration()+"\"");
		sb.append(");");
		
		runQuery(true, sb.toString());

		
	}
	
	public static ArrayList<Facility> listfacilities1(String listfacilities) throws SQLException {
		return listfacilities("select * from Facility","listfacilities");
	}
	
	public static ArrayList<MARForm> searchAssignedMAR(){
		return ReturnMatchingMAR("SELECT * from mar_details WHERE assigned_to is not null ","searchAssignedMAR");
	}
	
	public static ArrayList<MARForm> searchDatedAssignedMAR(String date){
		return ReturnMatchingMAR("SELECT * from mar_details WHERE date='"+date+"'","searchDatedAssignedMAR");
	}
	public static ArrayList<MARForm> searchByMAR(String MAR){
		return ReturnMatchingMAR("SELECT * from mar_details WHERE mar_number='"+MAR+"'","searchByMAR");
	}
	public static ArrayList<MARForm> searchTypeAssignedMAR(String type){
		return ReturnMatchingMAR("SELECT * from mar_details WHERE facility_type='"+type+"'","searchTypeAssignedMAR");
	}
//	public static ArrayList<Facility> viewParticularFacility(String id) throws SQLException{
//		return listfacilities("select * from Facility where idFacility='"+id+"' ","viewParticularFacility");
//	}

	
//	public static int assignDayCount(String assignName,String startDate){ 
//		int count=0;
//		try{  
//            Connection con = SQLConnection.getDBConnection();
//            PreparedStatement ps=(PreparedStatement) con.prepareStatement("select count(*) from mar_details where assigned_to='"+assignName+"' and date='"+startDate+"'"); 
//            ResultSet rs=ps.executeQuery();  
//            while(rs.next()){ 
//            	count=rs.getInt(0);
//            }
//        }catch(Exception e){
//        	System.out.println(e);
//        }  
//        return count;  
//    }

	

}

