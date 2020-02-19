package MAC_Facility.model;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.io.Serializable;
import java.text.Format;
import java.text.ParseException;
import java.text.SimpleDateFormat;


public class MARForm implements Serializable{

	private static final long serialVersionUID = 3L;
	private String facility_type;
	private String facility_name;
	private String description;
	private String reported_by;
	private String mar;
	private String fk_username;
	private String Assigned_to;
	private String Date;
	private String Time;


	public String getTime() {
		return Time;
	}

//	public void setTime(String time) {
//		Time = time;
//	}

	public String getUrgency() {
		return urgency;
	}

	public void setUrgency(String urgency) {
		this.urgency = urgency;
	}
	private String urgency;

	
//	private String regex  = "[1][0][0][0][0-9]{6}";
//	private String regex_pwd = "(?=.*[a-z])(?=.*\\d)(?=.*[A-Z])(?=.*[@#$%!]).{8,40}";
	
//    Calendar cal = Calendar.getInstance();
    SimpleDateFormat simpleformat = new SimpleDateFormat("dd/MMMM/yyyy hh:mm:s");

    Format f = new SimpleDateFormat("MM/dd/yy");
    String strDate = f.format(new Date());
        
    Format f1 = new SimpleDateFormat("HH.mm");
    String strTime = f1.format(new Date());

	public void setMARDetails (String facility_type, String facility_name, String description, String reported_by,String strDate, String strTime, String mar) {
		setFacilityType(facility_type);
		setFacilityName(facility_name);
		setDescription(description);
		setReportedBy(reported_by);
		setstrDate(strDate);
		setstrTime(strTime);
		setMar(mar);
	}
			public String getFacility_type() {
		return facility_type;
	}
//
//	public void setFacility_type(String facility_type) {
//		this.facility_type = facility_type;
//	}

	public String getFacility_name() {
		return facility_name;
	}

//	public void setFacility_name(String facility_name) {
//		this.facility_name = facility_name;
//	}

	public String getAssigned_to() {
		return Assigned_to;
	}

	public void setAssigned_to(String assigned_to) {
		this.Assigned_to = assigned_to;
	}

	public String getFacilityType() {
		return facility_type;
	}
	public void setFacilityType(String facility_type) {
		this.facility_type = facility_type;
	}
	
	public String getFacilityName() {
		return facility_name;
	}
	public void setFacilityName(String facility_name) {
		this.facility_name = facility_name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
        this.description = description;
	}
	
	public String getReportedBy() {
		return reported_by;
	}
	public void setReportedBy(String reported_by) {
		this.reported_by = reported_by;
	}
	
	public String getstrDate() {
		return strDate;
	}
	public void setstrDate(String strDate) {
		this.strDate = strDate;
	}
	
	public String getstrTime() {
		return strTime;
	}
	public void setstrTime(String strTime) {
		this.strTime = strTime;
	}
	
	public String getMar() {
		return mar;
	}
	public void setMar(String mar) {
		this.mar = mar;
	}
//	public String get_Mar() {
//		return newmar;
//	}
//	public void set_Mar(String newmar) {
//		this.newmar = newmar;
//	}
	public String getFk_username() {
		return fk_username;
	}
	public void setFk_username(String fk_username) {
		this.fk_username = fk_username;
	}
	
	public void validateMARForm (MARForm mform, MARFormErrorMsgs mferrorMsgs) {
//		if (action.equals("save_registration_details")) {
//		System.out.println("descr" + mform.getDescription());
		mferrorMsgs.setDescriptionError(validateDescription(mform.getDescription()));

//		System.out.println("error" + mferrorMsgs.getDescriptionError());
		mferrorMsgs.setErrorMsg();
		}
	
	private String validateDescription(String description) {
		String result="";
		if (isTextAnInteger(description))
			result="Your Description must be non-numeric";
		else
//			if (action.equals("save_registration_details")) 
			if (!stringSize(description,1,120))
				result= "Your Description must between 1 and 120 characters.";
			
		return result;

	}


////	This section is for general purpose methods used internally in this class
//	
	private boolean stringSize(String string, int min, int max) {
		return string.length()>=min && string.length()<=max;
	}
	private boolean isTextAnInteger (String string) {
        boolean result;
		try
        {
            Long.parseLong(string);
            result=true;
        } 
        catch (NumberFormatException e) 
        {
            result=false;
        }
		return result;
	}

	public String getDate() {
		return Date;
	}

	public void setDate(String date) {
		Date = date;
	}
}