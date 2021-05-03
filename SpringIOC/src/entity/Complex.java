package entity;

public class Complex implements Number {
	
	
	/*Every complex number have real and imaginary part*/
	
	private int r;
	private int i;
	
	private Complex(int r, int i)
	{
		super();
		this.r=r;
		this.i=i;
	}
	
	public Number add(Number n)
	{
		Complex complex=(Complex)n;
		return new Complex(this.r+complex.r,this.i+complex.i);
	}
	
	public void display()
	{
		/*This is because the complex numbers are displayed as r+4i in this form */
		System.out.println(this.r+"+"+this.i+"i");
	}

}
