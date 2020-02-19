package MAC_Facility.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import MAC_Facility.data.RepairerDAO;
import MAC_Facility.model.*;

@WebServlet("/RepairerController")
public class RepairerController extends HttpServlet {

	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{

		HttpSession session = request.getSession(false);
		String username = (String) session.getAttribute("uname");
		String user_id = username;
		Repairer repairer = new Repairer();
		ArrayList<Repairer> repairerList = new ArrayList<Repairer>();
		RepairerDAO repairerDAO = new RepairerDAO();
		String action = (String) request.getParameter("action");

		if (action.equals("viewRepairDetails")) {
			String repairId = (String) request.getParameter("repairId");

			repairerList = repairerDAO.viewRepairerDetails(user_id, repairId);
			if (null != repairer){
				session.setAttribute("repairerLists", repairerList);
				//getServletContext().getRequestDispatcher("/viewRepairerDetails.jsp").forward(request, response);

				response.sendRedirect("viewRepairerDetails.jsp");
			}
		} else {
			try {
				repairerList = repairerDAO.searchRepairer(user_id);
			} catch (SQLException e){
				e.printStackTrace();
			} catch (ClassNotFoundException e) {
//				e.printStackTrace();
			}

			if (null != repairer){
				session.setAttribute("repairerList", repairerList);

				String id=request.getParameter("id");
				if(action.equals("viewAssignedRepairs")) {
					response.sendRedirect("viewReservedRepairs.jsp");
				}else if(action.equals("requestReservation")) {
					session.removeAttribute("resultRequest");
					response.sendRedirect("reqReservation.jsp");
				} else if(action.equals("modifyReservedRepairs")) {
					session.removeAttribute("resultModify");
					response.sendRedirect("modifyReservedRepairs.jsp");
				} else if(action.equals("cancelReservedRepairs")) {
					session.removeAttribute("resultCancel");
					response.sendRedirect("cancelReservation.jsp");
				}  

			}

		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		

		String action=request.getParameter("action"), url="", URL="";
		HttpSession session = request.getSession();


		if (action.equals("modifyReservation")) {
			session.removeAttribute("resultCancel");

			Repairer repairer = new Repairer();
			String startTime = request.getParameter("startTime123");
			String id = request.getParameter("id");

			System.out.println(startTime);
			System.out.println(id);

			repairer.setId(id);
			repairer.setStartTime(startTime);
			String username = (String) session.getAttribute("uname");
			String user_id = username;

			RepairerDAO repairerDAO = new RepairerDAO();
			repairerDAO.modifyReservation(repairer);

			System.out.println("Ended");
			session.setAttribute("resultModify", "Faciliy Reservation Modified Successfully.");
			
			ArrayList<Repairer> repairerList = new ArrayList<Repairer>();

			try {
				repairerList = repairerDAO.searchRepairer(user_id);
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
//				e.printStackTrace();
			}

			session.setAttribute("repairerList", repairerList);


			url = "/modifyReservedRepairs.jsp"; 

		}
		else if (action.equals("cancelReservation")) {
			session.removeAttribute("resultCancel");
			Repairer repairer = new Repairer();
			String id = request.getParameter("id");
			System.out.println(id);

			repairer.setId(id);

			RepairerDAO repairerDAO = new RepairerDAO();
			repairerDAO.cancelReservation(repairer);

			System.out.println("Ended");
			session.setAttribute("resultCancel", "Faciliy Reservation Canceled Successfully.");

			String username = (String) session.getAttribute("uname");
			String user_id = username;
			ArrayList<Repairer> repairerList = new ArrayList<Repairer>();

			try {
				repairerList = repairerDAO.searchRepairer(user_id);
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			session.setAttribute("repairerList", repairerList);


			url = "/cancelReservation.jsp"; 
		}else if (action.equals("requestReservation")) {
			Repairer repairer = new Repairer();
			String key = request.getParameter("id");

			System.out.println(key);

			repairer.setId(key);

			RepairerDAO repairerDAO = new RepairerDAO();
			repairerDAO.requestReservation(repairer);

			System.out.println("Ended");
			session.setAttribute("resultRequest", "Faciliy Reservation Requested Successfully.");

			url = "/reqReservation.jsp"; 
		}

		getServletContext().getRequestDispatcher(url).forward(request, response);		


	}
}