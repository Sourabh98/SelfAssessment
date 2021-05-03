package filters;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class SingleEntryFilter implements Filter {

	private FilterConfig config;

	/*
	 * For applying a filter you will have to provide the filter mapping in web.xml
	 * through <filter> and <filter-mapping> tags and the url pattern for which you
	 * wanted to apply that filter will mention in the url-patter for filter mapping
	 * tag
	 */
	/*
	 * This method will get invoked while you will deploy the application on server
	 * as server will create Filter, FilterConfig and chain object at the time when
	 * we will deploy the application on the server
	 */
	public void init(FilterConfig config) {
		this.config = config;
		System.out.println("init method of the  " + this.config.getFilterName() + " filter is invoked.");
	}

	public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain)
			throws ServletException, IOException {
		// in this method we will do the pre and the post processing
		System.out.println("Pre processing is starting in " + config.getFilterName() + " filter..");
		/*
		 * Now for the single entry we will have to check if the session is already
		 * exists if the request comes for the exitservlet. So we would be having three
		 * Servlets Welcome Servlet, Forwarding Servlet and the Exit Servlet and when
		 * the request will come to the exitServlet will check if the session already
		 * exists if not then will redirect to the page which will send the request to
		 * the welcome servlet
		 */
		HttpServletRequest request=(HttpServletRequest) req;
		HttpSession session=request.getSession(false);
		if(session!=null&&!request.getRequestURI().equalsIgnoreCase("/wecomeServlet2"))
		{
			System.out.println("User is following the valid flow...");
		}
		else
		{
			System.out.println("User is coming out of the flow so redirecting user to the welcome page..");
			RequestDispatcher rd=req.getRequestDispatcher("index.html");
			
			res.setContentType("text/html");
			PrintWriter out=res.getWriter();
			out.println("<h2> You have been entered without the proper flow so redirecting you to the home page..</h2>");
			rd.include(req,res);
			out.close();
		}
		
		/*
		 * before invoking this method will be be the pre processing and after this
		 * method will be the post processing
		 */
		chain.doFilter(req, res);
	}

	public void destroy() {

		/*
		 * this method is used to do anything before offloading the filter(i am not sure
		 * what does they mean offloading is it like before destroying the filter object
		 */
	}

}
