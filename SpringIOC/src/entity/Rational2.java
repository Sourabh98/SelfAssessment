package entity;

import java.util.Scanner;

public class Rational2 implements Number {

	private int p;
	private int q;

	public Rational2(int p, int q) {
		this.p = p;
		this.q = q;
	}

	/*Now IOC container will create the object using this same class static method and we need to make the changes in the configuration accordingly*/
	public static Number getRational2() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Scanner hashcode "+sc.hashCode());
		System.out.println("Provide the numerator: ");
		int p = sc.nextInt();
		sc.nextLine();
		System.out.println("Provide the denominator: ");
		int q = sc.nextInt();
	
		sc.close();
		
		return new Rational2(p, q);
	}

	public Number add(Number n) {
		Rational2 num = (Rational2) n;
		return new Rational2(this.p * num.q + num.p * this.q, this.q * num.q);
	}

	public void display() {
		System.out.println(this.p + "/" + this.q);
	}

	public int getP() {
		return p;
	}

	public void setP(int p) {
		this.p = p;
	}

	public int getQ() {
		return q;
	}

	public void setQ(int q) {
		this.q = q;
	}
	
	
}
