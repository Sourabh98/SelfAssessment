package java8;

public class TypeInference {
	
	public static void main(String[] args) {
		
		StringLengthLamda myLamda=(String s)->s.length();
		System.out.println(myLamda.getLength("Hello Lambda"));
		
	}
	
	interface StringLengthLamda {
		public int getLength(String s);
	}

}
