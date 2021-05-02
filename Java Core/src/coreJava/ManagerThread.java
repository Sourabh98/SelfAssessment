package coreJava;

public class ManagerThread {
	
	public static void main(String[] args) {
		
		DaemonThread th=new DaemonThread();
		th.setDaemon(true);
		th.start();
		
		for(int i=0;i<5;i++)
		{
			System.out.println("main "+i);
			try
			{
				Thread.sleep(1000);
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
		}
		
		System.out.println("Main thread completed..");
	}

}
