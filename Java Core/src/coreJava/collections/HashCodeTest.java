package coreJava.collections;

public class HashCodeTest {
	
	public static void main(String[] args) {
		
		String s=new String("abc");
		String s2=new String("abc");
		System.out.println(s.hashCode());
		System.out.println(s2.hashCode());
		Emp e1=new Emp("A","B",10000);
		Emp e2=new Emp("A","B",10000);
		Emp e3=new Emp("A","B",10000);
		Emp e4=new Emp("A","B",10000);
		System.out.println("Printing memory reference of the objects..");
		System.out.println(e1+" "+e2+" "+e3+" "+e4);
		System.out.println("Printing hashcode...");
		System.out.println(e1.hashCode()+" "+e2.hashCode()+" "+e3.hashCode()+" "+e4.hashCode());
		
	}

}
