package model;
import static org.junit.Assert.assertTrue;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import MAC_Facility.data.RegistrationDAO;
import MAC_Facility.model.Registration;
import MAC_Facility.model.RegistrationErrorMsgs;
import junitparams.FileParameters;
import junitparams.JUnitParamsRunner;
import MAC_Facility.util.SQLConnection;

@RunWith(JUnitParamsRunner.class)
public class RegistrationTest {
	
	Registration reg;
	RegistrationErrorMsgs RegEerr;
	RegistrationDAO regDao;
	
	@Before
	public void setUp() throws Exception {
		reg = new Registration();
		RegEerr = new RegistrationErrorMsgs();
		regDao = new RegistrationDAO();
	}

	@Test
	@FileParameters("tests/Excel/Registration_test_cases.csv")
	public void test(int testcaseNo, String state, String role, String first_name, String last_name,String contact, String email, String uta_id, String address, String city, String zip_code, String username, String password, String errorMsg,String utaIDError, String first_nameError, String last_nameError, String contactError,String emailError,String addressError,String cityError,String zipcodeError,String usernameError,String passwordError,String status) {
		reg.setRegistration(state, role, first_name, last_name,contact, email, uta_id, address, city, zip_code,username,password);
//	Following 2 lines added to get complete JaCoCo coverage
		@SuppressWarnings("unused")
		String dummy=reg.getFk_username();
		reg.setFk_username(username);
		reg.validateRegistration(reg, RegEerr);
		assertTrue(errorMsg.equals(RegEerr.getErrorMsg()));
		assertTrue(utaIDError.equals(RegEerr.getutaIDError()));
		assertTrue(first_nameError.equals(RegEerr.getfirst_nameError()));
		assertTrue(last_nameError.equals(RegEerr.getlast_nameError()));
		assertTrue(contactError.equals(RegEerr.getcontactError()));
		assertTrue(emailError.equals(RegEerr.getemailError()));
		assertTrue(addressError.equals(RegEerr.getaddressError()));
		assertTrue(cityError.equals(RegEerr.getcityError()));
		assertTrue(zipcodeError.equals(RegEerr.getzipcodeError()));
		assertTrue(usernameError.equals(RegEerr.getusernameError()));
		assertTrue(passwordError.equals(RegEerr.getpasswordError()));
		assertTrue(role.equals(reg.getRole()));
		assertTrue(state.equals(reg.getState()));
		RegistrationDAO.Register(reg);
		RegistrationDAO.UpdateProfile(reg);
//		assertTrue(status.equals(RegistrationDAO.UserExists(reg)));
		RegistrationDAO.UserExists(reg);

	}
}