package org.hackerrank.com;

public class CountingValleys {

	public static void main(String[] args) {
		
		int steps=11;
		String path="DUDDUUUUDDD";
		System.out.println(countingValleys(steps,path));
		
	}
	
	 public static int countingValleys(int steps, String path) {
		    // Write your code here
		 int valley=0;
		 int upDownCounter=0;
		 int seaLevel=0;
		 char[] pathArr=path.toCharArray();
		 for(int i=0;i<steps;i++)
		 {
			 if(pathArr[i]=='U')
			 {
				 upDownCounter++;
				 if(upDownCounter==seaLevel)
					 valley++;
			 }
			 else if(pathArr[i]=='D')
			 {
				 upDownCounter--;
			 }
		 }
		 return valley;

		    }
}
