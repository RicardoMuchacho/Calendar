package servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import helper.DB;

/**
 * Servlet implementation class Calendar
 */
@WebServlet("/calendar")
public class Calendar extends HttpServlet {
	
	DB db = DB.getInstances();
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Calendar() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		HttpSession session = request.getSession();
		int userid = Integer.parseInt(session.getAttribute("userid").toString());
        
		String str = db.getUserCalendars(userid);
		response.setContentType("text/plain");
        PrintWriter out = response.getWriter();
        out.print(str); 
        out.close(); 
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		 HttpSession session = request.getSession();
	     int userid = Integer.parseInt(session.getAttribute("userid").toString());
		 String title = request.getParameter("title");
	
	     db.createCalendar(userid, title);

	     System.out.println(title + " userid: "+userid);
	}

}
