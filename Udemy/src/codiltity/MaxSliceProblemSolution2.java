package codiltity;

import java.util.Arrays;

public class MaxSliceProblemSolution2 {

	public static void main(String[] args) {
		int[] arr = { 7, -8, 4, -1, 6, -2, 3, -6, 5 };
		System.out.println(solution(arr));
	}

	/*
	 * Here we will be using Divide and Conquer approach to get the sub array with
	 * max sum, so first we will split up our array
	 */
	private static int solution(int[] A) {
		int[] leftSubArr = new int[A.length / 2 + 1];
		int[] rightSubArr = new int[A.length / 2];
		// Below code will form the left sub array
		for (int i = 0; i <= A.length / 2; i++) {
			leftSubArr[i] = A[i];
		}
		/* Below code will form the right sub array */
		for (int i = A.length / 2 + 1, j = 0; i < A.length; i++, j++) {
			rightSubArr[j] = A[i];
		}
		/*
		 * Now we will check for the max sub array in the left part and in the right
		 * part separately
		 */
		int leftArrSumPointer = 0;
		int[] leftSubArrSum = new int[20];
		for (int i = 0; i < leftSubArr.length; i++) {
			for (int j = 0 + i; j < leftSubArr.length; j++) {
				if (leftArrSumPointer == 0) {
					leftSubArrSum[leftArrSumPointer] = leftSubArr[j];
				} else {
					leftSubArrSum[leftArrSumPointer] = leftSubArrSum[leftArrSumPointer - 1] + leftSubArr[j];
				}
				leftArrSumPointer++;
			}
		}
		Arrays.sort(leftSubArrSum);
		int leftSubArrMaxSum = leftSubArrSum[leftSubArrSum.length - 1];

		int rightArrSumPointer = 0;
		int[] rightSubArrSum = new int[20];
		for (int i = 0; i < rightSubArr.length; i++) {
			rightSubArrSum[rightArrSumPointer] = rightSubArr[i];
			rightArrSumPointer++;
			for (int j = 0 + i; j < rightSubArr.length; j++) {
				rightSubArrSum[rightArrSumPointer] = rightSubArr[j];
				rightArrSumPointer++;
			}
		}

		int rightSubArrMaxSum = rightSubArrSum[rightSubArrSum.length - 1];
		System.out.println("Right should be 5:" + rightSubArrMaxSum);
		System.out.println("Left shoulde be 9:" + leftSubArrMaxSum);
		return 0;
	}

}
