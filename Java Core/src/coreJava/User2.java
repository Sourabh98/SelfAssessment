package coreJava;

public class User2 extends Thread {
	
	private Printer printer;
	private String msg;
	public User2(Printer printer, String msg)
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
