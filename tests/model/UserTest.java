package model;

import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import MAC_Facility.model.User;
import MAC_Facility.model.UserErrorMsgs;
import junitparams.FileParameters;
import junitparams.JUnitParamsRunner;

@RunWith(JUnitParamsRunner.class)
public class UserTest {

	User usr;
	UserErrorMsgs UerrorMsgs;

	@Before
	public void setUp() throws Exception {
		usr = new User();
		UerrorMsgs = new UserErrorMsgs();
	}

	@Test
	@FileParameters("tests/Excel/User_test_cases.csv")
	public void test(int testcaseNo, String action, String username, String last_name, String role, String errorMsg,
			String usernameError, String lastNameError, String roleError) {

		usr.setUser(username, last_name, "", "", "", role);

		usr.validateUser(action, usr, UerrorMsgs);

		assertTrue(errorMsg.equals(UerrorMsgs.getErrorMsg()));
		assertTrue(usernameError.equals(UerrorMsgs.getUsernameError()));
		assertTrue(lastNameError.equals(UerrorMsgs.getLastNameError()));
		assertTrue(roleError.equals(UerrorMsgs.getRoleError()));
	}
}
