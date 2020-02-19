package MAC_Facility.model;

public class LoginErrorMsgs {
	private String usernameError;
	private String passwordError;
	private String errorMsg;

	public LoginErrorMsgs() {
		this.errorMsg = "";
	}
	
	public String getErrorMsg() {
		return errorMsg;
	}
	public void setErrorMsg() {
		if (!usernameError.equals("") || !passwordError.equals(""))   
			this.errorMsg = "Please correct the following errors";
	}
	
	public String getusernameError() {
		return usernameError;
	}
	
	public void setusernameError(String usernameError) {
		this.usernameError = usernameError;
	}
	public void setpasswordError(String passwordError) {
		this.passwordError = passwordError;
	}
	public String getpasswordError() {
		return passwordError;
	}
}
