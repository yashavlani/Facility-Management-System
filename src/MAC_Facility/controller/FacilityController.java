package MAC_Facility.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import MAC_Facility.data.FacilityDAO;
import MAC_Facility.model.Facility;
import MAC_Facility.model.FacilityError;
import MAC_Facility.model.MARForm;
import MAC_Facility.model.MARFormErrorMsgs;

@WebServlet("/FacilityController")
public class FacilityController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private void getCompanyParam(HttpServletRequest request, Facility facility) {
		facility.setFacility(request.getParameter("idfacility"), request.getParameter("facility_name"),
				request.getParameter("type"), request.getParameter("duration"), request.getParameter("interval"));
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		String action = request.getParameter("action");
		session.removeAttribute("errorMsgs");

		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action = request.getParameter("action"), url = "";
		HttpSession session = request.getSession();
		Facility facility = new Facility();
		FacilityError CerrorMsgs = new FacilityError();
		int selectedFacilityIndex;
		session.removeAttribute("errorMsgs");

		if (action.equalsIgnoreCase("listfacilities")) {
			getCompanyParam(request, facility);
			ArrayList<Facility> result = null;
			try {
				result = FacilityDAO.listfacilities1("listfacilities");
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			session.removeAttribute("facility");
			session.setAttribute("FACILITIES", result);
			url = "/listCompany.jsp";

		} 
		else if (action.equalsIgnoreCase("ADDFacility")) {
			session.removeAttribute("errorMsgs");
			FacilityError EerrorMsgs = new FacilityError();
			session.setAttribute("errorMsgs", EerrorMsgs);

			url = "/ADDFacility.jsp";

		} else if (action.equalsIgnoreCase("InsertFacility")) {
			String facilityID = request.getParameter("idfacility");
			String name = request.getParameter("facility_name");
			getCompanyParam(request, facility);
			//session.setAttribute("errorMsg", CerrorMsgs);
			facility.validateIDFacility(action, facilityID, CerrorMsgs);
			facility.validateFacility_name(action, name, CerrorMsgs);
			session.setAttribute("errorMsg", CerrorMsgs);
			//session.setAttribute("facility", facility);
			if (CerrorMsgs.getFacilityIDError().equals("")&&CerrorMsgs.getFacilityNameError().equals(""))
			{	getCompanyParam(request, facility);
				FacilityDAO.insertFacility(facility);
				url="/ADDFacility.jsp";
				CerrorMsgs.setErrorMsg("Successfully Added");
					
				
			}else {
				
				getCompanyParam(request,facility);
				session.setAttribute("errorMsg", CerrorMsgs);
				CerrorMsgs.setErrorMsg("Invalid Facility ID or Name");
				url="/ADDFacility.jsp";
				System.out.println("UnSuccessfully ");
				
			
				
			}
		}

		
		 else if (action.equalsIgnoreCase("searchMAR")) {

			ArrayList<MARForm> result = FacilityDAO.searchMAR("searchMAR");
			session.removeAttribute("MARS");
			session.setAttribute("MARS", result);
			url = "/viewUnassignedMAR.jsp";
		} else if (action.equalsIgnoreCase("searchAssignedMAR")) {

			ArrayList<MARForm> result = FacilityDAO.searchAssignedMAR();
			session.removeAttribute("MARS");
			session.setAttribute("MARS", result);
			url = "/viewAssigned.jsp";

		} else if (action.equalsIgnoreCase("DatedMAR")) {
			
				ArrayList<MARForm> result = FacilityDAO.searchDatedAssignedMAR(request.getParameter("date"));
				session.removeAttribute("MARS");
				session.setAttribute("MARS", result);
				url = "/viewAssigned.jsp";
			
		}else if(action.equalsIgnoreCase("searchByMAR")){
		
				ArrayList<MARForm> result = FacilityDAO.searchByMAR(request.getParameter("newmar"));
				session.removeAttribute("MARS");
				session.setAttribute("MARS", result);
				url = "/viewUnassignedMAR.jsp";
			
			
		} else if (action.equalsIgnoreCase("typeMAR")) {
			
			getCompanyParam(request, facility);
			ArrayList<MARForm> result = FacilityDAO.searchTypeAssignedMAR(request.getParameter("type"));
			session.setAttribute("MARS", result);
			url = "/viewAssigned.jsp";
			

		} else if (action.equalsIgnoreCase("assignMAR")) {
			ArrayList<String> result1 = FacilityDAO.getRepairers();
			ArrayList<String> result2 = FacilityDAO.getUnassignedMARList();
			session.removeAttribute("repairerList");
			session.setAttribute("repairerList", result1);
			session.removeAttribute("marList");
			session.setAttribute("marList", result2);
			url = "/assignMAR.jsp";

		} else if (action.equalsIgnoreCase("assignRepairer")) {
			String repairer = request.getParameter("repairer");
			FacilityDAO.assignRepairer(request.getParameter("facility"),request.getParameter("repairer"),request.getParameter("date"));
			url = "/fmHome.jsp";
		}
//		else if (action.equalsIgnoreCase("changeMAR")) {
//			ArrayList<String> result = FacilityDAO.getUnassignedMARList();
//			session.removeAttribute("marList");
//			session.setAttribute("marList", result);
//			url = "/updateMAR.jsp";
//
//		}
//		else if (action.equalsIgnoreCase("updateMAR")) {
//			FacilityDAO.updateMAR(request.getParameter("facility"), request.getParameter("urgency"),
//					request.getParameter("time"));
//			url = "/fmHome.jsp";
//
//		} 
//		
//		else if (action.equalsIgnoreCase("viewParticularFacility")) {
//			String view = request.getParameter("id");
//			System.out.print(view);
//			ArrayList<Facility> result=null;
//			try {
//				result= FacilityDAO.viewParticularFacility(request.getParameter("id"));
//			} catch (SQLException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//			session.removeAttribute("facility");
//			session.setAttribute("FACILITIES", result);
//
//			url = "/viewParticular.jsp";
//
//		} 
//		else {
//			session.setAttribute("facility", facility);
//			session.setAttribute("errorMsgs", CerrorMsgs);
//			url = "/searchMAR.jsp";
//		}

		System.out.println("URL: " + url);
		getServletContext().getRequestDispatcher(url).forward(request, response);
	}



}
