package mypack;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

public class MyListener implements HttpSessionListener, ServletContextListener {

	/*
	 * You can put the below counters in ServletContext object and i think that
	 * would be better as this class will be deloaded from the memory after some
	 * time and in that the variables won't get fetched and you will see null on the
	 * screen, the basic of using context is when you wanted to share the data in
	 * between different sessions and that's what we are doing here..
	 */
	private static int totalUser = 0;
	private static int currentUser = 0;
	private ServletContext context = null;

	public void sessionCreated(HttpSessionEvent event) {
		context.setAttribute("totalUser", ++totalUser);
		context.setAttribute("currentUser", ++currentUser);
	}

	public void sessionDestroyed(HttpSessionEvent event) {
		context.setAttribute("currentUser", --currentUser);

	}

	public void contextInitialized(ServletContextEvent event) {
		context = event.getServletContext();
	}

	public void contextDestroyed(ServletContextEvent event) {

	}

}
