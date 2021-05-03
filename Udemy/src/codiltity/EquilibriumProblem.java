package codiltity;

import java.util.Arrays;

public class EquilibriumProblem {

	public static void main(String[] args) {

		int[] arr = { 3, 1, 2, 4, 3 };
		System.out.println(solution(arr));
	}

	public static int solution(int[] A) {
		int p = 1;
		long absolutDiff = 0;
		long leftSum = 0;
		long rightSum = 0;
		long[] absoluteDiffArr = new long[A.length - 1];
		for (int i = 0; i < A.length; i++) {
			rightSum += A[i];
		}
		
		while (p < A.length) {
			leftSum += A[p - 1];
			rightSum-=A[p-1];
			absolutDiff = Math.abs(leftSum - rightSum);
			absoluteDiffArr[p - 1] = absolutDiff;
			p++;
		}
		Arrays.sort(absoluteDiffArr);
		return (int) absoluteDiffArr[0];
	}

}
