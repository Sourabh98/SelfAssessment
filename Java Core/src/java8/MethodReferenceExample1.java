package java8;

public class MethodReferenceExample1 {
	
	public static void main(String[] args) {
		
		/*So here we are using the lambda expression to invoke the printMessage method inside the thread..
		 * Now instead of lambda expression we can also use the method reference to invoke the printMessage method, syntax using method reference would be more precise..there are few conditions when 
		 * we can use the method reference for example you can use method reference when number or arguments passed to the lambda expression and the parameters through which the method inside the 
		 * lambda expression invoked should be same..here the arguments and the parameter for the printMessage method are none so we can use the method reference here*/
		//Thread th=new Thread(()->printMessage());
		Thread th=new Thread(MethodReferenceExample1::printMessage);
		th.start();
		
	}
	
	public static void printMessage()
	{
		System.out.println("Hello World..");
	}

}
