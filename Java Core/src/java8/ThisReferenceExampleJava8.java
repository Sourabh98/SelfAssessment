package java8;

public class ThisReferenceExampleJava8 {
	
	public static void main(String[] args) {
		
		ThisReferenceExampleJava8 thisReferenceExampleJava8=new ThisReferenceExampleJava8();
		/*
		 * thisReferenceExampleJava8.doProcess(10, i-> {
		 * System.out.println(thisReferenceExampleJava8);
		 * System.out.println("Value of i is "+ i); //System.out.println(this); });
		 */
		thisReferenceExampleJava8.execute();
	}

	public void doProcess(int i, Process p)
	{
		p.process(i);
		System.out.println(this);
	}
	
	public void execute()
	{
	
		doProcess(10, i->
		{
			System.out.println("Value of i is "+i);
			/*So here this will refer to the same isntance which it would be refereing to outside the lambda
			 * expression so in anonymous inner class this reference value gets overridden but in lambdas it remains the same as execute method gets invoked by the thisReferenceExample instance that is why
			 * this is referring to that instance for verifying it we used the toString method as well.*/
			System.out.println(this);
		});
	}
	
	public String toString()
	{
		return "This is from ThisReferenceExample";
	}
}
