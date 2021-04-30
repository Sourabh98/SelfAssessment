package org.hackerrank.com;

public class JumpOnTheClouds {

	public static void main(String[] args) {

		int[] input = { 0, 0, 1, 0, 0, 1, 0 };
		/*
		 * int[] input= {}; int[] input= {};
		 */

		System.out.println(jumpOnTheClouds(input));

	}

	static int jumpOnTheClouds(int[] A) {
		/*
		 * Initialising count variable with -1 because the count will get increased
		 * when we will be on the last element too as the i<A.length condition will 
		 * be true 
		 */
		int count = -1;
		for (int i = 0; i < A.length; i++, count++) {
			/*
			 * //here we are checking if we would be able to jump //by two step else we will
			 * jump by one step so everytime we are jumping by 1 and in if condition we are 
			 * checking if we would be able to jump by one more so in total we would be able 
			 * to jump by 2 and every time we are increasing the count by 1 which is actually
			 * indicating the number of jumps
			 */
			if ((i + 2) < A.length && A[i + 2] == 0 )
				i++;

		}
		return count;
	}

}
