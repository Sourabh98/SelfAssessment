package java8;

public class Greeter {
	
	//what if we want to perform different greetings in that case we need to pass the argument to this method
	//and on the basis of the argument this method will perform the greeting 
	public void greet(Greeting greeting)
	{
		greeting.perform();
	}
	
	public static void main(String[] args) {
		
		Greeter greeter=new Greeter();
		HelloWorldGreeting helloWorldGreeting=new HelloWorldGreeting();
		greeter.greet(helloWorldGreeting);
		/*I think in this as well this is creating a class which is implementing this interface and then creating the object
		 * and assigning the reference of that object myLamdaFunctionVariable as i can see in pass this variable to the Greet
		 * method as well and then greet is also printing the below expression when invoking the perform method on this variable, this is what i think not sure about it will update on it later on*/
		
		Greeting myLamdaFunction=() -> System.out.println("Hello World from Lamda Expression");
		/*This expression i was talking about above.*/
		greeter.greet(myLamdaFunction);
		myLamdaFunction.perform();
		
	}

}
