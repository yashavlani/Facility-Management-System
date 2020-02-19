package MAC_Facility.controller;

import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import MAC_Facility.data.CreateMarDAO;
import MAC_Facility.data.LoginDAO;
import MAC_Facility.model.*;

@WebServlet("/LoginController")
public class LoginController extends HttpServlet {

	private static final long serialVersionUID = 1L;
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String action=request.getParameter("action"), url="", URL="";
		HttpSession session = request.getSession();
		Login login = new Login();
//		session.setAttribute("login",login);
		//insert employee
		if (action.equals("loginUser")) {
//			if (request.getParameter("insertEmpbutton")!=null) {  //insert employee button pressed
			login.setLogin(request.getParameter("username"), request.getParameter("password"));
			LoginErrorMsgs EerrorMsgs = new LoginErrorMsgs();
			login.validateLogin(login, EerrorMsgs);
			session.setAttribute("errorMsgs",EerrorMsgs);
			session.setAttribute("uname",request.getParameter("username"));
			if (EerrorMsgs.getErrorMsg().equals("")) {
				String[] ans = LoginDAO.UserLogin(login);
				String role = ans[0];
				String utaId = ans[1];
				session.setAttribute("login_username",login.getUsername());
				session.setAttribute("login_utaId",utaId);
//				System.out.println(role);
				if (role.equalsIgnoreCase("user")) {
					URL = "/UserHome.jsp"; 
				}
				else if (role.equalsIgnoreCase("facility_manager")) {
					URL = "/fmHome.jsp"; 
				}
				else if (role.equalsIgnoreCase("admin")) {
					URL = "/Admin_home.jsp"; 
				}
				else if (role.equalsIgnoreCase("repairer")) {
					URL = "/Repairer_home.jsp"; 
				}
				else {
					URL = "/Index.jsp";
				}
				session.removeAttribute("login");	
				session.removeAttribute("errorMsgs");	
			}
			
			else {
				URL = "/Index.jsp";
			}
				url = URL; 
			}
		
		getServletContext().getRequestDispatcher(url).forward(request, response);		
	}
}