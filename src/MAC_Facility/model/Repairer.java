package MAC_Facility.model;

import java.util.Date;

public class Repairer {
	private String id;
	private String facility_type;
	private String facility_name;
	private String startDate;
	private String startTime;
	private String floor;
//	private String wing;
	
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getFacility_type() {
		return facility_type;
	}
	public void setFacility_type(String facility_type) {
		this.facility_type = facility_type;
	}
	public String getFacility_name() {
		return facility_name;
	}
	public void setFacility_name(String facility_name) {
		this.facility_name = facility_name;
	}
	
	public String getStartDate() {
		return startDate;
	}
	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}
	public String getStartTime() {
		return startTime;
	}
	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}
	public String getFloor() {
		return floor;
	}
	public void setFloor(String floor) {
		this.floor = floor;
	}
//	public String getWing() {
//		return wing;
//	}
//	public void setWing(String wing) {
//		this.wing = wing;
//	}
	
	
}

