package coreJava;

/*This is a class which have the print method which is used to print, there are two threads which are sharing the same Printer(instance) and trying to print but as we know in case of 
 * Multi Threading it is Thread scheduler which is responsible for context switching so no thread would be able to complete the printing at once, here threads can be assumed as the users and the printer
 * class can be assumed as the actual printer in the real world*/
public class Printer {
	
	
	public synchronized void print(String msg)
	{
		System.out.println("-------------------------------------------------------------------------------------------------------------------------------------");
		try
		{
			Thread.sleep(1000);
			System.out.println(msg);
			System.out.println("----------------------------------------------------------------------------------------------------------------------------------");
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		}

}
