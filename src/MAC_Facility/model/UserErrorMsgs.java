package MAC_Facility.model;

public class UserErrorMsgs {
	private String errorMsg;
	private String usernameError;
	private String firstNameError;
	private String lastNameError;
	private String roleError;

	public UserErrorMsgs() {
		this.errorMsg = "";
		this.usernameError = "";
		this.firstNameError = "";
		this.lastNameError = "";
		this.roleError = "";
	}

	public String getErrorMsg() {
		return errorMsg;
	}

	public void setErrorMsg() {
		if (!usernameError.equals("") || !lastNameError.equals("") || !roleError.equals(""))
			this.errorMsg = "Please correct the following errors";
	}

	public String getUsernameError() {
		return usernameError;
	}

	public void setUsernameError(String usernameError) {
		this.usernameError = usernameError;
	}

//	public String getFirst_nameError() {
//		return firstNameError;
//	}
//
//	public void setFirst_nameError(String first_nameError) {
//		this.firstNameError = first_nameError;
//	}

	public String getLastNameError() {
		return lastNameError;
	}

	public void setLastNameError(String lastNameError) {
		this.lastNameError = lastNameError;
	}

//	public String getPhoneError() {
//		return phoneError;
//	}
//
//	public void setPhoneError(String phoneError) {
//		this.phoneError = phoneError;
//	}
//
//	public String getEmailError() {
//		return emailError;
//	}
//
//	public void setEmailError(String emailError) {
//		this.emailError = emailError;
//	}

	public String getRoleError() {
		return roleError;
	}

	public void setRoleError(String roleError) {
		this.roleError = roleError;
	}
}
