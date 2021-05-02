package java8;

public class ThisReferenceExample7 {
	
	public static void main(String[] args) {
		ThisReferenceExample7 thisReferenceExample= new ThisReferenceExample7();
		// System.out.println(this);
		thisReferenceExample.doProcess(10, new Process()
				{
			public void process(int i)
			{
				System.out.println("Value of i is "+i);
				System.out.println(this);
			}
			public String toString()
			{
				return "This is from Process instance";
				
			}
				});
		
	}

	public void doProcess(int i, Process p)
	{
	p.process(i);
	System.out.println(this+ " this is from do process");
	}
}
