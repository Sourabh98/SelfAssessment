package codiltity;

public class MaxProfitSolutionFinal {

	public static void main(String[] args) {

		int[] inputArr = { 114, 132, 119, 91, 84, 29, 61, 76, 38, 21, 9, 63, 65, 68, 81, 124, 118, 78, 44, 59, 80 };
		System.out.println(solution(inputArr));

	}

	private static int solution(int[] A) {
		int globalMaxSum = 0;
		int localmaxSum = 0;
		for (int i = 1; i < A.length; i++) {
			int d = A[i] - A[i - 1];
			/*
			 * max method will return the max from d and localmaxSum for first iteration d
			 * will be the first element of our recoded array and localmaxSum would be zero
			 * so the max would be 'd' and this value will get stored in the localMaxSum, in
			 * next iteration 'd' will be the next element and then we are adding d to the
			 * last localMaxSum and whichever value would be max will get stored in
			 * localMaxSum variable
			 */
			localmaxSum = Math.max(d, localmaxSum + d);
			/*
			 * Here we are checking max in between localMaxSum and globalMaxSum and will
			 * store the max value in globalMaxSum variable
			 */
			globalMaxSum = Math.max(localmaxSum, globalMaxSum);

		}
		return globalMaxSum;
	}
}
