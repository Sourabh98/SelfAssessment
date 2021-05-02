package java8;

public class ClosureExampleJava7 {
	
public static void main(String[] args) {
	int i=10;
	int b=30;
		/*Creating anonymous inner class for Process iterface implementation*/
	doProcess(i, new Process(){
		
		@Override
		public void process(int i)
		{
				/*You can not assign like that because Java Runtime assume this variable as final or we can say effectively final as the scope of using this variable
				 * is different in comparison to where it is declared if you will see this method is invoked in doProcess and there is no 'b' variable there 'b' is defined in main method scope
				 * so when this will get used in process method it is freezed by Java Runtime and then it is used and this value can be changed in future in main but will always be same in
				 * process method, in java7 we used to declare such variable as final but in java8 compiler kind of trust on developer that this value supposed to be final and won't get changed in future 
				 * so freezes the value and this is called closure*/
				/* b=40; */
			System.out.println(i);
			System.out.println(i+b);
		}
	});
	
}

public static void doProcess(int i, Process p)
{
	p.process(i);
}

}

interface Process
{
	public void process(int i);
}
