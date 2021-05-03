package controllers;

import javax.servlet.ServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import dao.UserDao;
import entity.User;

@Controller
public class UserController {

	/*
	 * When the webcontainer will create the instance of USerController bean(we
	 * don't need to provide the configuration for this bean this is automatically
	 * manager by the WebContainer) then at the same time the USerDao bean will be
	 * created depending on the configuration provided for this bean in
	 * applicationContext .xml file then after the creation of this bean the bean
	 * will be injected in to the UserController bean using setter method this is
	 * just the replacement of the autowire="byName" which we read in Spring IOC
	 */
	@Autowired
	private UserDao dao;

	@RequestMapping("/login.spring")
	public String authenticateUser(@RequestParam("mailId") String mailId, @RequestParam("password") String password,
			HttpSession session) throws Exception {
		
		//dmd.set
		User user = dao.findUser(mailId, password);
		if (user != null) {
			session.setAttribute("user", user);
			return "userHome";
		}

		return "relogin";
	}

	/*@ModelAttribute annotation will create a user object and will initialise with the request parameters just keep in mind the request parameter name should be same 
	 * as the name given to the User variables else only the parameters name matches(both should be in same case) with the user's variable will get initialised only.*/
	@RequestMapping("/register.spring")
	public String resgisterUser(@ModelAttribute User user, @RequestParam("confirmedPassword") String confirmedPassword,
			ServletRequest request) throws Exception {
		if (user.getPassword().equals(confirmedPassword)) {
			/*
			 * This bean is defined in the IOC container and when we will ask the container
			 * for this bean it will inject the data source manager into it and from the
			 * datasource we will get the connection
			 */
			request.setAttribute("user", user);
			dao.saveUser(user);
			return "registered";
		}
		return "unsuccessfulRegistration";
	}

	@RequestMapping("/logout.spring")
	public String logOut(HttpSession session) {

		session.invalidate();
		return "loggedOut";
	}
}
