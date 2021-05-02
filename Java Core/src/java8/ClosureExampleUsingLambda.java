package java8;

public class ClosureExampleUsingLambda {
	
	public static void main(String[] args) {
		
		int i=10;
		int b=30;
		doProcess(i, a->
		{
			System.out.println(i);
			System.out.println(i+b);
			}
		);
	}
	
	public static void doProcess(int i, Process p)
	{
		p.process(i);
	}

}
