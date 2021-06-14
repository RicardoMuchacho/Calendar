package servlets;

import java.io.IOException;

import java.io.PrintWriter;  
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import helper.*;

@MultipartConfig()
@WebServlet("/login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public Login() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		
	        String name =request.getParameter("name");  
	        String password =request.getParameter("pass");  
	 
	        DB db = DB.getInstances();
	        User logged = db.loginData(name, password);
	
	        if(password.equals(logged.getPassword())){  
	         HttpSession session=request.getSession();  
	         session.setAttribute("name",name);
	         session.setAttribute("email",logged.getEmail()); 
	         session.setAttribute("userid",logged.getUserid()); 
	         session.setAttribute("password",logged.getPassword()); 
	         
		     RequestDispatcher dispatcher = request.getRequestDispatcher("home");
			 dispatcher.forward(request,  response);
	        }  
	        else{  
	           System.out.println("User or password not found");  
	   		   RequestDispatcher dispatcher = request.getRequestDispatcher("index.html");
			   dispatcher.forward(request,  response);
	        }
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	    }  
	}

