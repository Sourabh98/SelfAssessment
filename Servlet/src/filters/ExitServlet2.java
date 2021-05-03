package filters;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class ExitServlet2 extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(false);
		System.out.println("This is from the exit servlet..");
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		if(session!=null)
		{
		out.println(session.getAttribute("name") + " you have successfully logged out.");
		System.out.println("Invaliding the current session..");
		System.out.println("Invalidating the session from the exit Servlet: " + session);
		session.invalidate();
		}
		out.close();

	}

}
