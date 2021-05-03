package filters;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ForwardingServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

		System.out.println(
				"This will forward the request to the Welcome Servlet and as we have applied filter on the Welcome Servlet so "
						+ "first filter will get invoked and then the servlet");
		
		RequestDispatcher rd=getServletContext().getRequestDispatcher("welcomeServlet2");
		res.setContentType("text/html");
		rd.forward(req, res);
		PrintWriter out=res.getWriter();
		out.println("<h3>This is from forwaridng Servlet which is forwarding request to the WelcomeServlet2</h3>");
		out.close();
	}

}
