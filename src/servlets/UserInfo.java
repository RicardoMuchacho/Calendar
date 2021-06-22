package servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import helper.DB;
import helper.User;

/**
 * Servlet implementation class UserInfo
 */
@WebServlet("/userinfo")
public class UserInfo extends HttpServlet {
	private static final long serialVersionUID = 1L;
     DB db = DB.getInstances();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserInfo() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		   
		   HttpSession session = request.getSession();
		   String name = session.getAttribute("name").toString();
		   
		   User logged = db.loggedData(name);
		   
		   String email =  logged.getEmail();  
		   int userid = logged.getUserid();  
		   String pass = logged.getPassword(); 
		   
		   String json = "{\"status\": 200, \"name\":\""+name+"\", \"email\":\""+email+"\", \"userid\":\""+userid+"\", \"pass\":\""+pass+"\"}";
		   PrintWriter out = response.getWriter();
		   response.setContentType("application/json");
		   response.setCharacterEncoding("UTF-8");
		   out.print(json);
		   out.flush();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
