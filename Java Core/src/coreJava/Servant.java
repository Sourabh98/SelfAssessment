package coreJava;

import java.util.Random;

public class Servant extends Thread{
	
	private int leisureTime;
	public Servant(ThreadGroup g, String name)
	{
		super(g,name);
		Random r=new Random();
		leisureTime=r.nextInt();
	}
	
	public void run()
	{
		String t=getName();
		System.out.println(t+ "started");
		System.out.println("Don't disturb "+t+" is sleeping for "+leisureTime+" seconds.");
		try
		{
			Thread.sleep(leisureTime);
		}
		catch(InterruptedException e)
		{
			System.out.println("Checking if it is interrupted: "+this.isInterrupted());
			System.out.println(t+" is disturbed.");
		}
	}

}
