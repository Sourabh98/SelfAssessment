package controllers;

import java.util.Random;

import javax.servlet.ServletContext;
import javax.servlet.ServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;



@Controller
public class GameController {
	
	/*Through autowiring we are saying to the framework that inject these dependencies before creating the object of the GameController these dependencies will get injected using the constructor of the
	 *  GameController bean if you wanted to inject the dependencies through setter then in that case you will have to define the setter method in this class and will have to autowire the setter method
	 *  and if you wanted to make the dependency mandatory then you can use the required attribute in @Autowired annotation*/
	@Autowired
	private HttpSession session;
	@Autowired
	private ServletContext context;
	
	
	/*String return type means this method will return the view name which needs to be invoked by the view component.*/
	@RequestMapping("/startGame.spring")
	public String startGame(@RequestParam("name") String playerName)
	{
		
		/*Here we are setting the player name in the session scope, session scope is available till the user is playing the game in the same session and request scope is only valid for the same request*/
		session.setAttribute("playerName", playerName);
		
		/*Here we are creating the object of the Random class to get the random number and will put this random number in the session to compare this random number with the number which would be send
		 * by the user in the next requests..*/
		Random r=new Random();
		int num=r.nextInt(100);
		session.setAttribute("rNum", num);
		/*setting the initial attempt as 0 and as many times the user will guess the number we will increase the attempt and each time whatever number would be provided by the user will match that 
		 * number with the random number which we have set in the session scope*/
		session.setAttribute("attempt", 0);
		/*There might be multiple users which can play the game so when any user will play the game very first time then in that case there won't be any counter attribute in the context, when someone will
		 * play the game next time then there would be the counter attribute already in the context so either we will have to set the attribute in the context or will have increment the value of the
		 * attribute which is already set so if counter returns null from the context it means there is no counter attribute set in the context, so this counter will tell how many times a game has been
		 * played since the application has been deployed on the server as the context will remains till the application is deployed on the server */
		Integer counter=(Integer)context.getAttribute("counter");
		if(counter==null)
		{
			//setting the counter attribute here
			context.setAttribute("counter", 1);
		}
		else
		{
			//here we are incrementing the counter attribute value if it is already found in the context..
			context.setAttribute("counter", ++counter);
		}
		
		/*we are not sending any data back so we are only returning the String here, now the JSP page with the name userGuess will get invoked by the view once viewresolver will give the full URL 
		 * of the page back to the view by adding the prefix and suffix*/
		return "userGuess";
	}
	
	/*Request for this method will come from the userGuess.jsp page, we will be receiving num as a request parameter, we don't need to use any annotation to inject ServletRequest, ServletResponse, 
	 * ServletContext and HttpSeession into any method they can be injected just by passing them as parameters in the method. */
	@RequestMapping("/userGuess.spring")
	public String matchNumbers(@RequestParam("num") String num, ServletRequest request) {
		/*Here we fetching the random number that we have put in the session scope when user sent the request for startGame.spring, as we know session is shared in between different requests*/
		Integer rNum = (Integer) session.getAttribute("rNum");
		/*Here we are fetching the attempt attribute which we have put into the session scope on first request.*/
		Integer attempt = (Integer) session.getAttribute("attempt");
		/*if  this is the first user guess so we will increment the value of attempt by 1 and will set it again to the session attribute, initial value of the attempt was 0 which is set in the session
		 * scope.*/
		session.setAttribute("attempt",++attempt);
		/*Here we fetching the username from the session which we have saved in the first request this username was provided by the user on the first page.*/
		String playerName=(String)session.getAttribute("playerName");
		Integer userGuess=Integer.valueOf(num);
		String message=null;
		/*There could be three scenarios either the guesses number would be same as the random number we have picked or smaller or bigger so on the basis of the value we will send back the String which
		 * would be actually representing a view name and then view will invoke that JSP page so whatever String we are sending back we will have to make the jsp page of the same name so that the view
		 * can invoke it.*/
		if (rNum.equals(userGuess)) {
			message=playerName+" You have hit the bull's eyes in "+attempt+" attempts.";
			/*Ending the session as we won't be playing after the user guessed the right number.*/
			request.setAttribute("message", message);
			session.invalidate();
			return "endGame";
		}
		else if(rNum>userGuess)
		{
			message=playerName+" try a higher number.";
			request.setAttribute("message", message);
			
		}
		else if(rNum<userGuess)
		{
			message=playerName+" try a lower number.";
			request.setAttribute("message", message);
			
		}
		return "continueGame";
	}
}
