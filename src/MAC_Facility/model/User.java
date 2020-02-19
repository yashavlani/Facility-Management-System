// User.java
package MAC_Facility.model;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

//import company_management.data.CompanyDAO;
import MAC_Facility.data.UserDAO;

public class User implements Serializable {

	private static final long serialVersionUID = 3L;
	private String username;
	private String last_name;
	private String first_name;
	private String role;
	private String phone;
	private String email;

	public void setUser(String username, String last_name, String first_name, String phone, String email, String role) {
		setUser_name(username);
		setLast_name(last_name);
		setfirst_Name(first_name);
		setPhone(phone);
		setEmail(email);
		setUserRole(role);
	}

	public String getUserRole() {
		return role;
	}

	public void setUserRole(String role) {
		this.role = role;
	}

	public String getlastName() {
		return last_name;
	}

	public void setLast_name(String l_name) {
		this.last_name = l_name;
	}

	public String getfirst_Name() {
		return first_name;
	}

	public void setfirst_Name(String first_name) {
		this.first_name = first_name;
	}

	public String getUser_name() {
		return username;
	}

	public void setUser_name(String user_name) {
		this.username = user_name;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
	}


	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
	}

	public void validateUser(String action, User user, UserErrorMsgs errorMsgs) {
		if (action.equalsIgnoreCase("searchUser")) {

			if (last_name.equalsIgnoreCase("")) {
				errorMsgs.setLastNameError("Last Name cannot be blank");
			} else {
				errorMsgs.setLastNameError(validatLast_name(last_name));
			}
			errorMsgs.setErrorMsg();
		} else /* if (action.equalsIgnoreCase("modifyUser")) */ {
			if (!username.equalsIgnoreCase("") && !role.equalsIgnoreCase("")) {
				errorMsgs.setUsernameError(validateUser_name(username));
				errorMsgs.setRoleError(validateUserRole(role));
			} else /* if (username.equalsIgnoreCase("") || role.equalsIgnoreCase("")) */ {
				errorMsgs.setUsernameError("Username and Role cannot be blank");
			}
			errorMsgs.setErrorMsg();
		}
	}

	private String validateUser_name(String username) {
		// Username: is not numeric 8 <= Length <= 20 unique (not in DB)
		String result = "";
		if (!stringSize(username, 8, 20)) {
			result = "Your User Name must between 8 and 20 characters";
		} else if (isTextAnInteger(username)) {
			result = "Your user name cannot be numeric";
		} else if (!UserDAO.userExists(username)) {
			result = "Given user does not exist in database please provide a username for a pre-existing user";
		}
		return result;
	}

	private String validatLast_name(String lastname) {
		// Last name: Starts with Capital Letter, 3 <= Length <= 40, Contains no numeric
		// values
		String result = "";
		if (!stringSize(lastname, 3, 40))
			result = "Your Last Name must be between 3 and 40 characters";
		else if (Character.isLowerCase(lastname.charAt(0))) {
			result = "Your last name must start with a capital letter";
		} else if (containsNumericValue(lastname))
			result = "Your last name cannot contain any numeric values";
		return result;
	}

	private String validateUserRole(String role) {
		// Must be one of the following roles user, repairer, facility_manager, admin
		String result = "";
		Set<String> roles = Stream.of("user", "repairer", "facility_manager", "admin")
				.collect(Collectors.toCollection(HashSet::new));

		if (!roles.contains(role))
			result = "The new role must be one of the following types: user; repairer; facility_manager; admin";

		return result;
	}

//	private String validatFirst_name(String first_name) {
//	String result = "";
//	if (!stringSize(first_name, 3, 40))
//		result = "Your Last Name must be between 3 and 40 characters";
//	else if (Character.isLowerCase(first_name.charAt(0)))
//		result = "Your last name must start with a capital letter";
//	else if (containsNumericValue(first_name))
//		result = "Your last name should not contain any numeric values";
//	return result;
//}

//	private String validatePhone(String phone) {
//		String result = "";
//		if (phone.length() != 10)
//			result = "Phone number must be 10 digits in length";
//		else if (!isTextAnInteger(phone))
//			result = "Phone number must be a number";
//		return result;
//	}

//	private String validateEmail(String email) {
//		String result = "", extension = "";
//		if (!email.contains("@"))
//			result = "Email address needs to contain @";
//		else if (!stringSize(email, 7, 45))
//			result = "Email address must be between 7 and 45 characters long";
//		else {
//			extension = email.substring(email.length() - 4, email.length());
//			if (!extension.equals(".org") && !extension.equals(".edu") && !extension.equals(".com")
//					&& !extension.equals(".net") && !extension.equals(".gov") && !extension.equals(".mil"))
//				result = "Invalid domain name";
//		}
//		return result;
//	}

//	This section is for general purpose methods used internally in this class
	private boolean stringSize(String string, int min, int max) {
		return string.length() >= min && string.length() <= max;
	}

	private boolean isTextAnInteger(String string) {
		boolean result;
		try {
			Long.parseLong(string);
			result = true;
		} catch (NumberFormatException e) {
			result = false;
		}
		return result;
	}

	private boolean containsNumericValue(String string) {
		boolean result;
		if (string.matches(".*\\d.*")) {
			result = true;
		} else {
			result = false;
		}
		return result;
	}
}