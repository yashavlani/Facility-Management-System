package MAC_Facility.model;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import MAC_Facility.data.FacilityDAO;

public class Facility {

	private static final long serialVersionUID = 3L;
	public String idfacility;
	public String facility_name;
	public String Duration;
	public String Type;
	public String duration;
	public String interval;


	public void setFacility (String idfacility, String facility_name,String Type , String duration, String interval) {
		setIDFacility(idfacility);
		setFacility_name(facility_name);
		setType(Type);
		setInterval(interval);
		setDuration(duration);
	
		
	
	
	}

	public Facility() {
		this.Type = Type;
		this.facility_name = facility_name;
		this.interval = interval;
		this.duration = duration;
		
	}
	
	
	
	
	public String getIDFacility() {
		return idfacility;
	}
	public void setIDFacility(String idfacility) {
		this.idfacility = idfacility;
	}
	
	public String getfacility_name() {
		return facility_name;
	}
	public void setFacility_name(String facility_name) {
		this.facility_name = facility_name;
	}
//	public String getDuration() {
//		return Duration;
//	}
	public void setType(String Type) {
        this.Type = Type;
	}
	
	public String getType() {
		return Type;
	}
	
	
	
	public String getIdfacility() {
		return idfacility;
	}





	public String getDuration() {
		return duration;
	}

	public void setDuration(String duration) {
		this.duration = duration;
	}

	public String getInterval() {
		return interval;
	}

	public void setInterval(String interval) {
		this.interval = interval;
	}

	public String getFacility_name() {
		return facility_name;
	}

	public  void validateFacility (String action, Facility facility, FacilityError errorMsgs) {
		if (action.equals("InsertFacility")) {
			validateIDFacility(action,facility.getIDFacility(),errorMsgs);
			validateFacility_name(action,facility.getfacility_name(),errorMsgs);
		
		
			//errorMsgs.setDurationError(validateDuration(facility.getDuration()));
			//errorMsgs.setIntervalError(validateInterval(facility.getDuration()));*/
			//errorMsgs.setErrorMsg();
			
		}
		else{
			errorMsgs.setErrorMsg("Invalid action");
			}
		}
		
		
	

	public void validateIDFacility(String action, String idfacility,FacilityError error) {
		
		
		//System.out.println("Inside validateIDFacility ");
		if (idfacility.isEmpty())
			error.setFacilityIDError("Should not be empty");
		else
			if (Character.isLowerCase(idfacility.charAt(0)))
				error.setFacilityIDError("Must be capital");
		
		else
			if (!stringSize(idfacility,3,20))
				error.setFacilityIDError("Your facility ID must between 3 and 20 digits");
		else
			if(FacilityDAO.checkFacility(idfacility)) 
				error.setFacilityIDError("MUST BE UNIQUE");
			else
				error.setFacilityIDError("");
	
			
		
			
	}
	
	public void validateFacility_name(String action,String facility_name,FacilityError error) {
		
		if (facility_name.isEmpty())
			error.setFacilityNameError("Should not be empty");
		else
			if (Character.isLowerCase(facility_name.charAt(0)))
				error.setFacilityNameError("Must be capital");
		else
			if (!stringSize(facility_name,3,20))
				error.setFacilityNameError("Your facility_name must between 3 and 20 digits");
			else
				error.setFacilityNameError("");
			
	}
	

	
		
	
	
	/*private String validateInterval(String Interval) {
		String result=" ";
		if (!stringSize(Interval,3,45))
			result="Type Should be arounf 3 to 24 characters";
		else
			if (Character.isLowerCase(facility_name.charAt(0)))
				result="Must not be empty";
		
		
		return result;		
	}*/

//	This section is for general purpose methods used internally in this class
	
	private static boolean stringSize(String string, int min, int max) {
		return string.length()>=min && string.length()<=max;
	}

	public void validateFacility(String action, FacilityError facility, String errorMsgs) {
		// TODO Auto-generated method stub
		
	}
}

