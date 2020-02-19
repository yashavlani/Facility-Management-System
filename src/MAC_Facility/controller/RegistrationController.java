package MAC_Facility.controller;

import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import MAC_Facility.data.LoginDAO;
import MAC_Facility.data.RegistrationDAO;
import MAC_Facility.model.*;

@WebServlet("/RegistrationController")
public class RegistrationController extends HttpServlet {

	private static final long serialVersionUID = 1L;
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String action=request.getParameter("action"), url="", URL="";
		HttpSession session = request.getSession();
		//insert user
		if (action.equals("save_registration_details")) {
			Registration registration = new Registration();
			System.out.println(request.getParameter("states"));
			registration.setRegistration(request.getParameter("states"), request.getParameter("roles"), request.getParameter("first_name"), request.getParameter("last_name"), request.getParameter("contact"), request.getParameter("email"), request.getParameter("uta_id"), request.getParameter("address"), request.getParameter("city"), request.getParameter("zip_code"), request.getParameter("username"), request.getParameter("password"));
			RegistrationErrorMsgs EerrorMsgs = new RegistrationErrorMsgs();
			registration.validateRegistration(registration, EerrorMsgs);
			session.setAttribute("registration",registration);
			session.setAttribute("errorMsgs",EerrorMsgs);
			if (EerrorMsgs.getErrorMsg().equals("")) {
				if(RegistrationDAO.UserExists(registration)) {
					RegistrationDAO.Register(registration);
					URL = "/registration_successful.jsp"; 
					session.removeAttribute("registration");	
				}
				else {
					URL = "/Registration_failed.jsp"; 
				}
			}
			else {
				URL = "/Registration.jsp"; 
			}
			
			url = URL; 
		}
		
		if (action.equals("update_registration")) {
			Registration updateProfile = new Registration();
			String login_utaId = (String) session.getAttribute("login_utaId"); 
//			System.out.println(login_utaId);
			String login_username = (String) session.getAttribute("login_username"); 
			updateProfile.setFk_username(login_username);
			
			updateProfile.setRegistration(request.getParameter("states"), request.getParameter("roles"), request.getParameter("first_name"), request.getParameter("last_name"), request.getParameter("contact"), request.getParameter("email"), login_utaId, request.getParameter("address"), request.getParameter("city"), request.getParameter("zip_code"), login_username, request.getParameter("password"));
			RegistrationErrorMsgs EerrorMsgs = new RegistrationErrorMsgs();
			updateProfile.validateRegistration(updateProfile, EerrorMsgs);
			session.setAttribute("updateprofile",updateProfile);
			session.setAttribute("errorMsgs",EerrorMsgs);
			if (EerrorMsgs.getErrorMsg().equals("")) {
				if(RegistrationDAO.UserExists(updateProfile)) {
//					System.out.println("");
				}
				else {
					RegistrationDAO.UpdateProfile(updateProfile);
					URL = "/updateProfile_successful.jsp";
				}
			}
			else {
				URL = "/UpdateProfile.jsp";
			}
				url = URL; 
			}
		getServletContext().getRequestDispatcher(url).forward(request, response);		
	}
}