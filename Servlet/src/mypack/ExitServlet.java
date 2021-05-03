package mypack;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class ExitServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		String userName = String.valueOf(session.getAttribute("name"));
		RequestDispatcher rd = request.getRequestDispatcher("index.html");
		
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println(userName + " you have successfully exited..Try Again");
		//include will always gets invoked after opening the stream
		rd.include(request, response);
		out.close();
		session.invalidate();

	}
}
