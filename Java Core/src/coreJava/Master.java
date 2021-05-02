package coreJava;

public class Master {
	
	public static void main(String[] args) {
		
		System.out.println("Master started, starting a new thread and giving it 5 seconds to complete..");
		ThreadGroup g=new ThreadGroup("Lazy Group");
		Servant s1=new Servant(g,"lazy1");
		s1.start();
		Servant s2=new Servant(g,"lazy2");
		Servant s3=new Servant(g,"lazy3");
		Servant s4=new Servant(g,"lazy4");
		Servant s5=new Servant(g,"lazy5");
		s2.start();
		s3.start();
		s4.start();
		s5.start();
		try
		{
		/*Here giving 5 seconds to complete the thread..this will suspend the execution of current thread which is the main thread for 5 seconds or till s thread completes whichever is smaller.*/
			s1.join(5000);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		int activeThreads=g.activeCount();
		if(activeThreads>0)
		{
			System.out.println("Number of Active threads: "+activeThreads);
			System.out.println("Suspending all thread which are part of thread group: "+g.getName());
			g.interrupt();
		}
		/*Checking if servant thread completed within the alloted time and if it is alive then we are going to poke it..*/
		
		if(s1.isAlive())
		{
			System.out.println("Servant is taking more time interrupting it..");
			s1.interrupt();
		}
		else
		{
			System.out.println("Servant is completed within the allocated time..");
		}
		
		
	}

}
