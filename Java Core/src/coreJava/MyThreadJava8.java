package coreJava;

public class MyThreadJava8 {
	
	public static void main(String[] args) {
		Thread th=Thread.currentThread();
		th.setName("Main Thread");
		System.out.println("main is executing in the "+th.getName());
		System.out.println("creating and Starting the user defined thread..");
		
		/*Here we are using lambda expression to do the same task which we did in Java7*/
		Runnable myRunnable=()->
		{
			try
			{
				Thread thread=Thread.currentThread();
				thread.setName("Myrunnable thread");
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
		};
		
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
	}


