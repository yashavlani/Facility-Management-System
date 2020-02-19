package MAC_Facility.model;
import java.util.regex.*;  

import java.io.Serializable;
//import MAC_Facility.data.CompanyDAO;

//import company_management.data.CompanyDAO;
//import MAC_Facility.model.String;

public class Registration implements Serializable{

	private static final long serialVersionUID = 3L;
	private String first_name;
	private String last_name;
	private String contact;
	private String email;
	private String uta_id;
	private String address;
	private String city;
	private String zip_code;
	private String state;
	private String username;
	private String password;
	private String role;
	private String fk_username;
	
//	private String regex  = "[1][0][0][0][0-9]{6}";
	private String regex_pwd = "(?=.*[a-z])(?=.*\\d)(?=.*[A-Z])(?=.*[@#$%!]).{8,40}";


	
	public void setRegistration (String state, String role, String first_name, String last_name,String contact, String email, String uta_id, String address, String city, String zip_code, String username, String password) {
		setFirstName(first_name);
		setLastName(last_name);
		setContact(contact);
		setEmail(email);
		setUtaId(uta_id);
		setAddress(address);
		setCity(city);
		setState(state);
		setZipCode(zip_code);
		setUsername(username);
		setPassword(password);
		setRole(role);
	}
	
	public String getFirstName() {
		return first_name;
	}
	public void setFirstName(String first_name) {
		this.first_name = first_name;
	}
	
	public String getLastName() {
		return last_name;
	}
	public void setLastName(String last_name) {
		this.last_name = last_name;
	}
	public String getContact() {
		return contact;
	}
	public void setContact(String contact) {
        this.contact = contact;
	}
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	
	public String getUtaId() {
		return uta_id;
	}
	public void setUtaId(String uta_id) {
		this.uta_id = uta_id;
	}
	
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	
	public String getZipCode() {
		return zip_code;
	}
	public void setZipCode(String zip_code) {
		this.zip_code = zip_code;
	}
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	public String getFk_username() {
		return fk_username;
	}
	public void setFk_username(String fk_username) {
		this.fk_username = fk_username;
	}

	public void validateRegistration (Registration registration, RegistrationErrorMsgs errorMsgs) {
//		if (action.equals("save_registration_details")) {
		errorMsgs.setfirst_nameError(validateFirstName(registration.getFirstName()));
			errorMsgs.setlast_nameError(validateLastName(registration.getLastName()));
			errorMsgs.setcontactError(validateContact(registration.getContact()));
			errorMsgs.setemailError(validateEmail(registration.getEmail()));
			errorMsgs.setaddressError(validateAddress(registration.getAddress()));
			errorMsgs.setutaIDError(validateUtaId(registration.getUtaId()));
			errorMsgs.setcityError(validateCity(registration.getCity()));
			errorMsgs.setzipcodeError(validateZipCode(registration.getZipCode()));
			errorMsgs.setusernameError(validateUsername(registration.getUsername()));
			errorMsgs.setpasswordError(validatePassword(registration.getPassword()));
			errorMsgs.setErrorMsg();
//		}
		//else
		//	if (action.equals("searchCompany")) {
		//		if (company_name.equals("") && idcompany.equals("")) 
			//		errorMsgs.setCompanyNameError("Both Company Name and Company ID cannot be blank");
			//	else
			//		if (!idcompany.equals(""))
			//			errorMsgs.setCompanyIDerror(validateIdcompany(action, idcompany));
			//	errorMsgs.setErrorMsg();				
//			}
			//else { //action=searchEmployee
			//	if (idcompany.equals("")) 
			//		errorMsgs.setCompanyIDerror("Company ID cannot be blank");
//				else
//					errorMsgs.setCompanyIDerror(validateIdcompany(action,idcompany));
//				errorMsgs.setErrorMsg();
//			}
	}
	
	private String validateFirstName(String first_name) {
		String result="";
		if (isTextAnInteger(first_name))
			result="Your First Name must be non-numeric";
		else
//			if (action.equals("save_registration_details")) 
			if (!stringSize(first_name,3,40))
				result= "Your First Name must between 3 and 40 characters.";
			else
//				if (action.equals("save_registration_details")) 
				if (Character.isLowerCase(first_name.charAt(0)))
					result= "Your First Name must start with a capital letter.";
			
		return result;
	}
	
	private String validateLastName(String last_name) {
		String result="";
		if (isTextAnInteger(last_name))
			result="Your Last Name must be non-numeric";
		else
//			if (action.equals("save_registration_details")) 
			if (!stringSize(last_name,3,40))
				result= "Your Last Name must between 3 and 40 characters.";
			else
//				if (action.equals("save_registration_details")) 
				if (Character.isLowerCase(last_name.charAt(0)))
					result= "Your Last Name must start with a capital letter.";
			
		return result;
	}
	
	private String validateContact(String phone) {
		String result="";
		if (phone.length()!=10)
			result="Phone number must be 10 digits in length";
		else
			if (!isTextAnInteger(phone))
				result="Phone number must be a number";
		return result;		
	}
	
	private String validateEmail(String email) {
		String result="",extension="";
		if (!email.contains("@"))
			result = "Email address needs to contain @";
		else
			if (!stringSize(email,7,45))
				result="Email address must be between 7 and 45 characters long";
			else {
				extension = email.substring(email.length()-4, email.length());
				if (!extension.equals(".org") && !extension.equals(".edu") && !extension.equals(".com") 
						&& !extension.equals(".net") && !extension.equals(".gov") && !extension.equals(".mil"))
					result = "Invalid domain name";				
			}
		return result;		
	}
	
	private String validateAddress(String address) {
		String result="";
		if (!isTextAnInteger(address))
			result="Your street address must be numeric";
		else
//			if (action.equals("save_registration_details")) 
			if (!stringSize(address,3,10))
				result= "Your street address must between 3 and 40 characters.";
//			else
////				if (action.equals("save_registration_details")) 
//				if (Character.isLowerCase(first_name.charAt(0)))
//					result= "Your First Name must start with a capital letter.";
			
		return result;
	}
	
	private String validateUtaId(String uta_id) {
		String result="";
		if (!isTextAnInteger(uta_id))
			result="Your UTA ID must be numeric";
		else
//			if (action.equals("save_registration_details")) 
			if (uta_id.length()!=10)
				result= "Your UTA ID must be 10 digits in length.";
			else
				if (!uta_id.startsWith("1000"))
//					result= "Your First Name must start with a capital letter.";
			     // if(Pattern.matches(regex, uta_id))
			    	  result = "Your UTA ID must begin with 1000.";			
		return result;
	}
	
	private String validateCity(String city) {
		String result="";
		if (isTextAnInteger(city))
			result="City must be non-numeric";
		else
//			if (action.equals("save_registration_details")) 
			if (!stringSize(city,3,40))
				result= "City must between 3 and 40 characters.";
			else
//				if (action.equals("save_registration_details")) 
				if (Character.isLowerCase(city.charAt(0)))
					result= "City must start with a capital letter.";
			
		return result;
	}
	
	private String validateZipCode(String zip_code) {
		String result="";
		if (zip_code.length()!=5)
			result="Zip Code must be 5 digits in length";
		else
			if (!isTextAnInteger(zip_code))
				result="Zip Code must be a number";
		return result;		
	}
	
	private String validatePassword(String password) {
		String result="";
		if (!stringSize(password,8,40))
			result= "Your Password must between 3 and 40 characters.";
		else
//				if (action.equals("save_registration_details")) 
			  if(!Pattern.matches(regex_pwd, password))
				  result= "Your Password must contain at least 1 uppercase letter 1 lowercase letter 1 number and 1 special character and should be 8-40 characters long.";
		return result;
	}
	
	private String validateUsername(String username) {
		String result="";
		if (isTextAnInteger(username))
			result="Your User Name must be non-numeric";
		else
//			if (action.equals("save_registration_details")) 
			if (!stringSize(username,8,20))
				result= "Your User Name must between 8 and 20 characters.";
//			else
////				if (action.equals("save_registration_details")) 
//				if (Character.isLowerCase(first_name.charAt(0)))
//					result= "Your First Name must start with a capital letter.";
//			
		return result;
	}
//
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
}