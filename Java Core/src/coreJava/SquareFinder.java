package coreJava;

import java.util.Scanner;

/*Only if number is in between 1 to 50 then it's square is displayed else will throw the out of Range exception*/
public class SquareFinder {
	
	public static void main(String[] args) {
		
		Scanner sc=new Scanner(System.in);
		int a=sc.nextInt();
		sc.close();
		try
		{
		if(a<1||a>50)
			throw(new OutOfRangeException("Given number is out of range.."));
		System.out.println("Square of the number is "+a*a);
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		
	}

}
