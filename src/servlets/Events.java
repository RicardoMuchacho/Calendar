package servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import helper.DB;

/**
 * Servlet implementation class Events
 */
@WebServlet("/events")
public class Events extends HttpServlet {
	private static final long serialVersionUID = 1L;
      DB db = DB.getInstances();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Events() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		int calendarid = Integer.parseInt(request.getParameter("calendarid"));
        
		String str = "En construccion";//db.getCalendarEvents();
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
	     int calendarid = Integer.parseInt(request.getParameter("calendarid"));
		 String title = request.getParameter("title");
	
	     //db.createEvent(calendarid, date, description);

	     //System.out.println(title + " userid: "+userid);
	}
	protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
	   db.deleteEvent(2);
	}

}
