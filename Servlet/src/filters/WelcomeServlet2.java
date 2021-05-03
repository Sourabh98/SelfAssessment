package filters;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class WelcomeServlet2 extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		String name = request.getParameter("name");
		HttpSession session = request.getSession(true);
		session.setAttribute("name",name);
		System.out.println("this context has been obtained through servlet Config: " + getServletContext());
		System.out.println(
				"this context has been obtained from the servlet config: " + getServletConfig().getServletContext());
		System.out.println(
				"I think above both the context should be the same that is should return the context of the currrent context.. Yes");
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println("Welcome " + name);
		/*
		 * If you will provide the href like below then the server will append the
		 * exitServlet2 like localhost:8080/exitServlet2 which means it will remove the
		 * app name from the URL now either you can provide the full URL with the app
		 * name or can provide the relative url for providing the relative URL you will
		 * have to use the escape characters.
		 */
		/* out.println("<a href=/exitServlet2> Log out </a>"); */
		/* Full URL would be like below with app name in it. */
		/* out.println("<a href=/Servlet/exitServlet2> Log out </a>"); */
		/*
		 * Or you can provide the relative URL i.e. the below href will append after the
		 * app name so the complete URL which will get generated would be like above,
		 * the escape characters we used will skip the double quotes so you will get the
		 * complete URL
		 */
		/*So through below href we will send a new request to the server*/
		out.println("<a href=\"exitServlet2\"> Log out </a>");
		/*Now if the request is coming to the exit Servlet through WelcomeServlet then it is fine as we are creating the session in the welcome servlet
		 * so that means user is following the correct web flow but if the user is sending the request direclty to the ExitServlet and if the user session
		 * is expired then that means that is not the right web flow in that case we will redirect the user to the index.html so that the user can
		 * again send the request to the WelcomeServlet first.*/
		out.close();
		System.out.println("Session object obtained in Welcome Servlet: "+session);

	}

}
