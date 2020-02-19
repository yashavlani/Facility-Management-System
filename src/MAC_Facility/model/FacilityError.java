package MAC_Facility.model;

import com.sun.org.apache.xalan.internal.xsltc.compiler.Pattern;

public class FacilityError {
	private String errorMsg;
	private String FacilityIDError;
	private String FacilityNameError;
	




	public FacilityError() {
		this.errorMsg = "";

	
	
	}

	

	public void setErrorMsg(String errorMsg) {
		this.errorMsg = errorMsg;
	}

	public String getErrorMsg() {
		return errorMsg;
	}

	public String getFacilityIDError() {
		return FacilityIDError;
	}

	public String getFacilityNameError() {
		return FacilityNameError;
	}
	public void setFacilityNameError(String FacilityNameError) {
		this.FacilityNameError = FacilityNameError;
	}







	public void setFacilityIDError(Object object) {
		FacilityIDError=(String) object;
		
	}




}

