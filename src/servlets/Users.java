package servlets;

import java.io.*;
import javax.servlet.http.HttpSession;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import helper.*;


/**
 * Servlet implementation class Register
 */
@MultipartConfig()
@WebServlet("/users")
public class Users extends HttpServlet {
	private static final long serialVersionUID = 1L;
      
	DB db = DB.getInstances();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Users() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		   RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/views/users.html");
		   dispatcher.forward(request,  response);
		   
		   HttpSession session = request.getSession();
		   String name = session.getAttribute("name").toString();
		   
		   User logged = db.loggedData(name);
		   
		   session.setAttribute("email", logged.getEmail());  
		   session.setAttribute("userid", logged.getUserid());  
		   session.setAttribute("password", logged.getPassword());  
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request,
    HttpServletResponse response) 
    throws ServletException, IOException {
		// TODO Auto-generated method stub
		String name =request.getParameter("name");  
        String email =request.getParameter("email");  
        String password =request.getParameter("pass"); 
        
        HttpSession session = request.getSession();
		int userid = Integer.parseInt(session.getAttribute("userid").toString());
        
		User userUpdate = new User(name, password, email, userid);;
		
        db.updateUser(userUpdate);
        
        session.setAttribute("email", userUpdate.getEmail());  
		session.setAttribute("name", userUpdate.getName());  
		session.setAttribute("password", userUpdate.getPassword());  
		
		response.setHeader("Refresh", "0; URL="+ request.getContextPath() + "/users");
	}
	
	
	
	protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doPut(req, resp);
	}
	
	protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
	   
	}
}

