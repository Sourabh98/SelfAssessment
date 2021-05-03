package controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class SimpleController {

	/*
	 * Defining request processing method now with the URL /greeting.spring and
	 * using @RequestMapping annotation to map the request URI to the method, in the
	 * request we will get the parameter with the name 'name' and will fetch the
	 * value of the parameter into our request processing method
	 * using @RequestParameter annotation, fetched value will be stored in userName
	 * variable and this method will return the ModelAndView
	 */
	/*
	 * This method will be invoked by the DispatcherServlet and the reference of the
	 * ModelAndView object will be returned to the DS then this DS will give this
	 * reference to the View and that view component will take out the View Name and
	 * reference of the ModelObject separately and will provide that view name to
	 * the view Resolver which will add some prefix and suffix to that view name and
	 * will return the full url of the page and will put the ModelObject reference
	 * in the request scope, in jsp we have attribute selector "$" by using this
	 * attribute selector we can fetch the value of the attribute from the request,
	 * session or application scope so to fetch the value of message attribute we
	 * will use this JSP attribute selector and this will fetch the value from the
	 * request scope for message attribute which have been put by the view
	 * component.
	 */
	@RequestMapping("/greeting.spring")
	public ModelAndView sayHello(@RequestParam("name") String userName) {

		ModelAndView mav = new ModelAndView();
		/* Setting the view Name as result */
		mav.setViewName("result");
		/*
		 * Here we setting the objects in ModelAndView Object with the name message
		 * value for this key is "welcome+user name" which we will get in the request
		 * parameter.
		 */
		mav.addObject("message", "Welcome " + userName);

		return mav;
	}

}
