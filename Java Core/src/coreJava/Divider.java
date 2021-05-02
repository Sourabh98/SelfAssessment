package coreJava;

import java.util.Scanner;

public class Divider {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		try {
			int a = sc.nextInt();
			int b = sc.nextInt();
			sc.close();
			/*Throwing the exception conditionally here*/
			if(b==0)
			{
				throw(new Exception("Second number must not be zero"));
			}
			System.out.println("Result" + a / b);
		} catch (Exception e) {
			System.out.println(e);
			throw(new NumberFormatException(""));
			
		}
		
	}
}
