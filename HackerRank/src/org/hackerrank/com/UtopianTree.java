package org.hackerrank.com;

public class UtopianTree {

	public static void main(String[] args) {

		// This input represents the number of cycles
		int[] input = { 0, 1, 4 };
		for(int d: calculateHeight(input))
			{
			System.out.print(d+" ");
			}

	}

	private static int[] calculateHeight(int[] A) {
		/*
		 * Now we will be using the below formula to calculate the the height of the
		 * tree after number of years and as we know there would be two cycles in a
		 * year, formula will be Tn=2n+1 -1
		 */
		
		int[] heightArr=new int[A.length];
		for (int i=0;i<A.length;i++) {
			int height = 0;
			if(A[i]%2==0)
			{
			height = (int)Math.pow(2, (A[i] / 2)+1)-1;
			heightArr[i]=height;
			}
			else
			{

				height =(int) ((Math.pow(2, (A[i] / 2 + 1))-1)*2);
				heightArr[i]=height;
			}
		}
		
		return heightArr;

	}
}
