package coreJava;

public class User1 extends Thread{
	
	private Printer printer;
	private String msg;
	public User1(Printer printer, String msg)
	{
		this.printer=printer;
		this.msg=msg;
	}
	public void run()
	{
		for(int i=0;i<10;i++)
		printer.print(msg);
	}

}
