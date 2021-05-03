package entity;

import java.util.Scanner;

public class Complex2 implements Number {
	
	private int i;
	private int j;
	
	private Complex2(int i, int j)
	{
		this.i=i;
		this.j=j;
	}
	public static Number getComplex2()
	{
		Scanner sc = new Scanner(System.in);
		System.out.println("Scanner hashcode "+sc.hashCode());
		System.out.println("Provide the real part:");
		int p=0;
		int j=0;
		sc.next();
		//if(sc.hasNextInt())
		//{
		 p= sc.nextInt();
		//}
		
		System.out.println("Enter the imaginary part:");
		//if(sc.hasNextInt())
		j=sc.nextInt();
		sc.close();
		return new Complex2(p,j);
	}
	
	public void  display()
	{
		
		System.out.println();
	}
	
	public Complex2 add(Number num)
	{
		Complex2 com2=(Complex2)num;
		return new Complex2(this.i+com2.i,this.j+com2.j);
	}
	
	

}
