package model;
import static org.junit.Assert.assertTrue;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import MAC_Facility.data.LoginDAO;
import MAC_Facility.model.Login;
import MAC_Facility.model.LoginErrorMsgs;
import MAC_Facility.model.Registration;
import MAC_Facility.model.RegistrationErrorMsgs;
import junitparams.FileParameters;
import junitparams.JUnitParamsRunner;

@RunWith(JUnitParamsRunner.class)
public class LoginTest {
	
	Login login;
	LoginErrorMsgs LoginEerr;
	LoginDAO loginDao;
	
	@Before
	public void setUp() throws Exception {
		login = new Login();
		LoginEerr = new LoginErrorMsgs();
		loginDao = new LoginDAO();
	}

	@Test
	@FileParameters("tests/Excel/Login_test_cases.csv")
	public void test(int testcaseNo, String username, String password, String errorMsg,String usernameError,String passwordError) {
		login.setLogin(username,password);
//	Following 2 lines added to get complete JaCoCo coverage
//		@SuppressWarnings("unused")
//		String dummy=login.getFk_username();
//		login.setFk_username(username);
		login.validateLogin(login, LoginEerr);
		assertTrue(errorMsg.equals(LoginEerr.getErrorMsg()));
		assertTrue(usernameError.equals(LoginEerr.getusernameError()));
		assertTrue(passwordError.equals(LoginEerr.getpasswordError()));
		loginDao.UserLogin(login);
	}
}