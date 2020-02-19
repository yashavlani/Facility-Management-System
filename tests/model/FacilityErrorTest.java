package model;

import static org.junit.Assert.*;

import javax.servlet.http.HttpServletRequest;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import MAC_Facility.model.Facility;
import MAC_Facility.model.FacilityError;
import junitparams.FileParameters;
import junitparams.JUnitParamsRunner;

@RunWith(JUnitParamsRunner.class)
public class FacilityErrorTest {

	private static final String Type = null;
	Facility facilityDetails = new Facility();
	FacilityError facility=new FacilityError();
	

	@Before
	public void setUp() throws Exception {
		String idfacility = null;
		String duration = null;
		String interval = null;
		String facility_name = null;
		String Date=null;
		facilityDetails.setFacility(idfacility, facility_name, Type, duration, interval);
		facilityDetails.setFacility_name("Badminton courts");
		facilityDetails.setIDFacility("BMC10");
		facilityDetails.setInterval("30 min");
		facilityDetails.setDuration("Same day");
		facilityDetails.setType("Indoor");
		
		
		
		String action ="listfacilities",errorMsgs = null;
		
		facilityDetails.validateFacility( action, facility, errorMsgs);
		
		
		
		
	}


	@Test
	@FileParameters("tests/Excel/FacilityDetailsTest1.csv")
	public void FacilityErrorTest1(String action, String idfacility, String idError) {
		facilityDetails.validateIDFacility(action, idfacility,facility);
		assertEquals(idError, facility.getFacilityIDError());
	}
	@Test
	@FileParameters("tests/Excel/FacilityDetailsTest2.csv")
	public void test(String action, String facility_name, String facError ) {
		facilityDetails.validateFacility_name(action, facility_name,facility);
		assertEquals(facError, facility.getFacilityNameError());
	}
	@Test
	@FileParameters("tests/Excel/FacilityDetailsTest3.csv")
	public void test2(String action, String facError) {
		
		facilityDetails.validateFacility(action, facilityDetails, facility);
		assertEquals(facError, facility.getErrorMsg());
	}
	
	
	@After
	public void tearDown() throws Exception {
		assertEquals("Badminton courts", facilityDetails.getFacility_name());
		assertEquals("BMC10", facilityDetails.getIdfacility());
		assertEquals("30 min", facilityDetails.getInterval());
		assertEquals("Same day", facilityDetails.getDuration());
		assertEquals("Indoor", facilityDetails.getType());
		
		
		
	}
	/*@Test
	@FileParameters("test/")
	public void ObjectTest(int tcNo, String username, String password, String credError) {
		CredentialsError error = Credentials.validateFromDB(new Credentials(username, password), true);
		assertTrue(error.getCredentialError().equals(credError));
	}*/
}