package coreJava;

public class MyRunnable implements Runnable {
	
	@Override
	public void run()
	{
		try
		{
			Thread thread=Thread.currentThread();
			thread.setName("Myrunnable thread.");
			System.out.println("run() is running the "+thread.getName()+" thread");
			for(int i=0;i<10;i++)
			{
				System.out.println(thread.getName()+i);
				Thread.sleep(1000);
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
	}

}
