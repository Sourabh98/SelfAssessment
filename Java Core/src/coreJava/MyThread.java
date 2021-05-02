package coreJava;

public class MyThread {
	
	/*main method will get executed in the main thread which is created and started by the JRE*/
	public static void main(String[] args) {
		
		Thread th=Thread.currentThread();
		System.out.println("main is executing in the "+th.getName());
		System.out.println("creating and Starting the user defined thread..");
		MyRunnable myRunnable =new MyRunnable();
		Thread userDefinedThread=new Thread(myRunnable);
		userDefinedThread.start();
		for(int i=0;i<10;i++)
		{
			System.out.println("This is in main method "+i);
			try
			{
				Thread.sleep(1000);
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
		}
		System.out.println("Main is completed..");
		
	}
	
	public void finalize()
	{
		System.out.println("This is executed by the gc thread, which is again started by the JRE only to delete unused objects fromt the heap...");
	}

}
