package coreJava;

public class DaemonThread extends Thread
{
	public void run()
	{
		if(isDaemon())
		{
			System.out.println("Child is a daemon thread..");
		}
		else
		{
			System.out.println("CHild thread started normally..");
		}
		
		for(int i=0;i<10;i++)
		{
			System.out.println("run "+i);
			try
			{
			Thread.sleep(1000);
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
		}
			
	}

}
