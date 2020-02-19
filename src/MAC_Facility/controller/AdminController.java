// AdminController.java
package MAC_Facility.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import MAC_Facility.data.UserDAO;
import MAC_Facility.model.*;

@WebServlet("/AdminController")
public class AdminController extends HttpServlet {

	private static final long serialVersionUID = 1L;

	// private void getCompanyParam (HttpServletRequest request, Company company) {
	// company.setCompany(request.getParameter("idcompany"),request.getParameter("company_name"),request.getParameter("phone"),request.getParameter("email"));
	// }

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// HttpSession session = request.getSession();
		// String action = request.getParameter("action");
		// session.removeAttribute("errorMsgs");
		//// List companies
		// if (action.equalsIgnoreCase("listCompany")) {
		// ArrayList<Company> companyInDB = new ArrayList<Company>();
		// companyInDB=CompanyDAO.listCompanies();
		// session.setAttribute("COMPANIES", companyInDB);
		// getServletContext().getRequestDispatcher("/listCompany.jsp").forward(request,
		// response);
		// }
		// else // redirect all other gets to post
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("in doPost()");

		String action = request.getParameter("action"), url = "";
		HttpSession session = request.getSession();
		User user = new User();
		UserErrorMsgs UerrorMsgs = new UserErrorMsgs();
		// int selectedUserIndex;
		session.removeAttribute("errorMsgs");
		System.out.println("after UserErrorMsgs UerrorMsgs = new UserErrorMsgs();");

		// if (action.equalsIgnoreCase("saveCompany") ) {
		// getCompanyParam(request,user);
		// user.validateCompany(action,user,CerrorMsgs);
		// session.setAttribute("user", user);
		// if (!CerrorMsgs.getErrorMsg().equals("")) {// if error messages
		// getCompanyParam(request,user);
		// session.setAttribute("errorMsgs", CerrorMsgs);
		// url="/formCompany.jsp";
		// }
		// else {// if no error messages
		// CompanyDAO.insertCompany(user);
		// EmployeeErrorMsgs EemperrorMsgs = new EmployeeErrorMsgs();
		// session.setAttribute("errorMsgs", EemperrorMsgs);
		// url="/formEmployee.jsp";
		// }
		// }

		// else
		if (action.equalsIgnoreCase("searchUser")) {
			System.out.println("inside searchUser action");
			String lastname = request.getParameter("user_last_name");
			System.out.println("lastname = " + lastname);
			session.removeAttribute("errorMsgs");

			user.setUser("", lastname, "", "", "", "");

			user.validateUser(action, user, UerrorMsgs);
			System.out.println("after validateUser");

			ArrayList<User> userInDB = new ArrayList<User>();

			System.out.println("after userInDB");
			if (UerrorMsgs.getErrorMsg().equalsIgnoreCase("")) {
				System.out.println("inside IF of UerrorMsgs.getErrorMsg()");
				userInDB = UserDAO.searchUsers(lastname);

				session.setAttribute("USERS", userInDB);

				session.removeAttribute("user");
				System.out.println("before calling userSearchResults.jsp");
				url = "/userSearchResults.jsp";
			} else {
//				System.out.println("inside ELSE");
//				System.out.println(user.getlastName());
				session.setAttribute("user", user);
				session.setAttribute("errorMsgs", UerrorMsgs);
				url = "/searchUser.jsp";
				// }
			}
		} else if (action.equalsIgnoreCase("modifyUser")) {
			System.out.println("inside modifyUser");
			String role = request.getParameter("role");

			String username = request.getParameter("username");

			System.out.println(role);
			System.out.println(username);

			session.removeAttribute("errorMsgs");
			session.removeAttribute("result");

			user.setUser(username, "", "", "", "", role);

			user.validateUser(action, user, UerrorMsgs);

			if (UerrorMsgs.getErrorMsg().equalsIgnoreCase("")) {
				try {
					UserDAO.modifyUser(username, role);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				session.setAttribute("result", "Role has been sucessfully modified");
				url = "/modifyUser.jsp";
			} else {
				session.setAttribute("user", user);
				session.setAttribute("errorMsgs", UerrorMsgs);
				url = "/modifyUser.jsp";
			}
		}
		getServletContext().getRequestDispatcher(url).forward(request, response);
	}
}