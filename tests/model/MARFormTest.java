package model;
import static org.junit.Assert.assertTrue;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import MAC_Facility.data.CreateMarDAO;
import MAC_Facility.model.MARForm;
import MAC_Facility.model.MARFormErrorMsgs;
import junitparams.FileParameters;
import junitparams.JUnitParamsRunner;

@RunWith(JUnitParamsRunner.class)
public class MARFormTest {
	
	MARForm mar1;
	MARFormErrorMsgs MAREerr;
	CreateMarDAO marDao;
	
	@Before
	public void setUp() throws Exception {
		mar1 = new MARForm();
		MAREerr = new MARFormErrorMsgs();
		marDao = new CreateMarDAO();
	}

	@Test
	@FileParameters("tests/Excel/MAR_test_cases.csv")
	public void test(int testcaseNo, String facility_type, String facility_name, String description, String reported_by,String strDate, String strTime, String mar,String errorMsg,String  DescriptionError ) {
		mar1.setMARDetails(facility_type, facility_name, description, reported_by,strDate, strTime, mar);
//	Following 2 lines added to get complete JaCoCo coverage
//		@SuppressWarnings("unused")
//		String dummy=reg.getFk_username();
//		reg.setFk_username(username);
		mar1.validateMARForm(mar1, MAREerr);
		assertTrue(errorMsg.equals(MAREerr.getErrorMsg()));
		assertTrue(DescriptionError.equals(MAREerr.getDescriptionError()));
		assertTrue(facility_type.equals(mar1.getFacilityType()));
		assertTrue(facility_name.equals(mar1.getFacilityName()));
		assertTrue(description.equals(mar1.getDescription()));
		assertTrue(reported_by.equals(mar1.getReportedBy()));
//		assertTrue(assigned_to.equals(mar1.getAssigned_to()));
		assertTrue(strDate.equals(mar1.getstrDate()));
		assertTrue(strTime.equals(mar1.getstrTime()));
		assertTrue(mar.equals(mar1.getMar()));
		marDao.createMar(mar1);
		marDao.searchMar(mar1.getFk_username());
		
		
	}
}