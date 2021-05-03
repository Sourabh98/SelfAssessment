package entity;

public class Rational implements Number {
	
	private int n;
	private int d;
	 
public Rational(int n, int d)
{
	this.n=n;
	this.d=d;
}

public Rational add(Number num)
{
	Rational r=(Rational)num;
	return new Rational(this.n*r.d+this.d*r.n,this.d*r.d);
}

public void display()
{
	System.out.println(this.n+"/"+this.d);
}
}
