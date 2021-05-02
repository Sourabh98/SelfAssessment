package coreJava.collections;

import coreJava.Printer;
import coreJava.User1;
import coreJava.User2;

public class METest {
	public static void main(String[] args) {
		
		Printer printer=new Printer();
		User1 user1=new User1(printer,"It is user one");
		User2 user2=new User2(printer,"It is user two");
		user1.start();
		user2.start();
		
		System.out.println("Main thread completed..");
	}

}
