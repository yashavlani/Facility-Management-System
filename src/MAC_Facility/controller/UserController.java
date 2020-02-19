package MAC_Facility.controller;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.sun.org.apache.xerces.internal.util.URI;
import com.sun.org.apache.xerces.internal.util.URI.MalformedURIException;

import MAC_Facility.data.CreateMarDAO;
import MAC_Facility.data.LoginDAO;
import MAC_Facility.data.RegistrationDAO;
import MAC_Facility.model.*;
import MAC_Facility.controller.*;

@WebServlet("/UserController")
public class UserController extends HttpServlet {

	private static final long serialVersionUID = 1L;
	
//	 public static String getCurrentUrl(HttpServletRequest request) throws MalformedURLException, MalformedURIException{
//
//		    URL url = new URL(request.getRequestURL().toString());
//
//		    String host  = url.getHost();
//		    String userInfo = url.getUserInfo();
//		    String scheme = url.getProtocol();
//		    int port = url.getPort();
//		    String path = (String) request.getAttribute("javax.servlet.forward.request_uri");
//		    String query = (String) request.getAttribute("javax.servlet.forward.query_string");
//		    URI uri = new URI(scheme,userInfo,host,port,path,query,null);
//		    return uri.toString();
//		}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String action=request.getParameter("action"), url="", URL="";
		HttpSession session = request.getSession();

		
		if (action.equals("save_mar_details")) {
			MARForm Mform = new MARForm();
			session.setAttribute("mform",Mform);
//			if (request.getParameter("insertEmpbutton")!=null) {  //insert employee button pressed
//			MARForm Mform = new MARForm();		
			Mform.setMARDetails(request.getParameter("facility_type"), request.getParameter("facility_name"), request.getParameter("description"), request.getParameter("reported_by"), request.getParameter("date"),request.getParameter("time"), request.getParameter("mar"));
			MARFormErrorMsgs MFEerrorMsgs = new MARFormErrorMsgs();
			Mform.validateMARForm(Mform, MFEerrorMsgs);
			session.setAttribute("mferrorMsgs",MFEerrorMsgs);
			String login_username = (String) session.getAttribute("login_username"); 
			Mform.setFk_username(login_username);
			if (MFEerrorMsgs.getErrorMsg().equals("")) {
				CreateMarDAO.createMar(Mform);
				URL = "/mar_successful.jsp";
			}
//				session.removeAttribute("registration");
			else {
			URL = "/MARForm.jsp";
			}
				url = URL; 
			}					
		
		getServletContext().getRequestDispatcher(url).forward(request, response);		
	}
	
	
//	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//
//		String action=request.getParameter("action"), url="";
//		String id=request.getParameter("id");
//
//		HttpSession session = request.getSession();
//		int Mform1Index;
//		
////		if (action.equals("createMar")) {
////            System.out.println("print createmar");
////		CreateMarDAO createMarDAO2 = new CreateMarDAO();
////		
////		try {
////			 
////            List<MARForm> listFacility = createMarDAO2.list();
////            request.setAttribute("listFacility", listFacility);
////            
////            for(MARForm model : listFacility) {
////                System.out.println("print LIST");
//////                System.out.println(model.getFacility_name1());
////                System.out.println(model.getFacility_type1());
////
////            }
//// 
////			url = "/MARForm.jsp"; 
////
////        } catch (SQLException e) {
////            e.printStackTrace();
////            throw new ServletException(e);
////        }
////		}
//		
//		
//		if (action.equals("searchMar")) {
//			System.out.println("LIST RETRIEVE");
//			MARForm Mform1 = new MARForm();
//			ArrayList<MARForm> Mform1_list = new ArrayList<MARForm>();
//			session.setAttribute("mform",Mform1);
//			CreateMarDAO createMarDAO = new CreateMarDAO();
//			String login_username = (String) session.getAttribute("login_username"); 
//			Mform1.setFk_username(login_username);
//			Mform1_list = createMarDAO.searchMar(login_username);
//			
////			System.out.println("LIST RETRIEVE" +Mform1_list + login_username);
//			session.setAttribute("mform_list", Mform1_list);				
//			
////				session.removeAttribute("registration");				
//				url = "/MARList.jsp"; 
//			}
//		
//		if (action.equalsIgnoreCase("searchspecificMar") ) {  
//			System.out.println("Specific LIST RETRIEVE");
//			System.out.println(request);
//			ArrayList<MARForm> Mform1_list = new ArrayList<MARForm>();
//			MARForm Mform1 = new MARForm();
//			CreateMarDAO createMarDAO = new CreateMarDAO();
//			String login_username = (String) session.getAttribute("login_username"); 
//			System.out.println(request.getParameter("lol"));
//			if (id!=null) {
//				Mform1Index = Integer.parseInt(id) - 1;
//				System.out.println(Mform1Index);
//				Mform1_list=createMarDAO.searchMar(login_username); 
//				Mform1.setMARDetails(Mform1_list.get(Mform1Index).getFacilityType(), Mform1_list.get(Mform1Index).getFacilityName(), 
//						Mform1_list.get(Mform1Index).getDescription(), Mform1_list.get(Mform1Index).getReportedBy(), Mform1_list.get(Mform1Index).getstrDate(), Mform1_list.get(Mform1Index).getstrTime(), Mform1_list.get(Mform1Index).getMar());
//				session.setAttribute("MAR", Mform1);
//			}
//			url="/ListSpecificMar.jsp";					
//
//		}
//		getServletContext().getRequestDispatcher(url).forward(request, response);		
//	}
}
