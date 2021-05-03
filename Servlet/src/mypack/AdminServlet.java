package mypack;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AdminServlet extends HttpServlet {

	private static final long serialVersionUID = 12345678;

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ServletContext ctx = getServletContext();
		// Below blcok we have written to avoid nill pointer excpetion while doing type
		// casting to int the reason for null pointer exception first it will convert
		// that object to wrapper class which is Integer and then invoke intValue()
		// method on it to get the primitive value so if we will use the Wrapper class
		// like below directly we won't get the null pointer exception
		/*
		 * Object o1=ctx.getAttribute("totalUser"); Object
		 * o2=ctx.getAttribute("currentUser"); int totalUser=0; int currentUser=0;
		 * if(o1!=null && o2!=null) { totalUser=(int)o1; currentUser=(int)o2; }
		 */

		Integer totalUser = (Integer) ctx.getAttribute("totalUser");
		Integer currentUser = (Integer) ctx.getAttribute("currentUser");

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println("<h3>Total User for the app:" + totalUser + "<h3>Current User for the app :<h3>" + currentUser);
		out.close();
	}

}
