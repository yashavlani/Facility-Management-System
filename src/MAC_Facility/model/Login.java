package MAC_Facility.model;
import java.util.regex.*;

//import MAC_Facility.model.String;

import java.io.Serializable;
//import MAC_Facility.data.CompanyDAO;

//import company_management.data.CompanyDAO;
//import MAC_Facility.model.String;

public class Login implements Serializable{

	private static final long serialVersionUID = 3L;
	private String username;
	private String password;

	
	//private String regex  = "[1][0][0][0][0-9]{6}";
	private String regex_pwd = "(?=.*[a-z])(?=.*\\d)(?=.*[A-Z])(?=.*[@#$%!]).{8,40}";


	
	public void setLogin (String username, String password) {
		
		setUsername(username);
		setPassword(password);
		
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
	

	public void validateLogin(Login login, LoginErrorMsgs errorMsgs) {
		errorMsgs.setusernameError(validateUsername(login.getUsername()));
		errorMsgs.setpasswordError(validatePassword(login.getPassword()));
		errorMsgs.setErrorMsg();
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