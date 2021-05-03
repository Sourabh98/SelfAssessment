package codiltity;

import java.util.Arrays;

public class MaxSliceProblemSolution1 {
	
	public static void main(String[] args) {
		int[] arr= {7,-8,4,-1,6,-2,3,-6,5};
		System.out.println(solution(arr));
				
	}
	
	/*So this is the solution for brute
	 * force algo in which we are doing 
	 * the sum one by one.*/
	private static int solution(int[] A)
	{
		int[] sumArr= new int[100];
		int sumArrPointer=0;
		int sum=0;
		for(int i=0;i<A.length;i++)
		{
			sumArr[sumArrPointer]=A[i];
			sumArrPointer++;
			for (int j=i+1;j<A.length;j++)
			{
				sum=A[i]+A[j];
				sumArr[sumArrPointer]=sum;
				sumArrPointer++;
			}
		}
		Arrays.sort(sumArr);
		return sumArr[sumArr.length-1];
	}

}
