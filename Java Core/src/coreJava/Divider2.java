package coreJava;

import java.util.Scanner;

public class Divider2 {
	
	public static void main(String[] args) {
		
		Scanner sc= new Scanner(System.in);
		int a=sc.nextInt();
		int b=sc.nextInt();	
		System.out.println(divide(a,b));
		sc.close();
	}
	
	private static int divide(int a, int b)
	{
		try
		{
			return a/b;
		}
		catch (ArithmeticException e) {
			System.out.println("Arithmetic excpetion caught in divide..rethrowing..");
			throw(new RuntimeException(""));
		}
	}

}
