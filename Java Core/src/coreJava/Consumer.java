package coreJava;

public class Consumer implements Runnable{
	
	private Buffer buffer;
	public Consumer(Buffer b)
	{
		this.buffer=b;
	}
	
	@Override
	public void run()
	{
		//System.out.println("Consumer started, consuming in"+Thread.currentThread().getName());
		for(int i=0;i<10;i++)
		{
		buffer.consume();
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
