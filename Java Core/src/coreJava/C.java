package coreJava;

public class C implements A,B{
	
	
	public static void main(String[] args) {
		new C().test();
	}

	@Override
	public void test() {
		System.out.println("test");
		
	}

}
