package coreJava;

public class Producer implements Runnable{
	
	private Buffer buffer;

	public Producer(Buffer b)
	{
		this.buffer=b;
		
	}
	@Override
	public void run()
	{
		//System.out.println("Producer started..Producing in "+Thread.currentThread().getName());
		for(int i=0;i<10;i++)
		{
		buffer.produce(i);
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
