package mypack;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class WelcomeServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name = request.getParameter("name");
		HttpSession session = request.getSession();
		session.setAttribute("name", name);
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println("Welcome " + name+"<br>");
		
		out.println("<a href=\"exitServlet\">Exit</a>");
		out.close();
		
	}

}
