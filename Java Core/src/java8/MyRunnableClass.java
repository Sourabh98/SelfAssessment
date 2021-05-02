package java8;

public class MyRunnableClass {
	
	public static void main(String[] args) {
		
		//Creating a thread and running it from the main method
		Thread myThread=new Thread(new Runnable() {
			public void run()
			{
				System.out.println("Printed from the runnable interface");
			}
		});	
		myThread.start();
		//or instead of implementing and defining the abstract method we can use lambda expression for the same as well
		Thread myLambdaThread=new Thread(()->System.out.println("Printed from the Runnable lambda expression"));
		myLambdaThread.start();
	}

}
