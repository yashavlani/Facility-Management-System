package MAC_Facility.model;

public class MARFormErrorMsgs {

	private String errorMsg;
	private String DescriptionError;
	private String StrDateError;
	
	public MARFormErrorMsgs() {
		this.errorMsg = "";
		this.DescriptionError = "";		
	}

	public String getErrorMsg() {
		return errorMsg;
	}
	public void setErrorMsg() {
		if (!DescriptionError.equals(""))   
			this.errorMsg = "Please correct the following errors";
	}
	public String getDescriptionError() {
		return DescriptionError;
	}
	public void setDescriptionError(String DescriptionError) {
		this.DescriptionError = DescriptionError;
	}	
}