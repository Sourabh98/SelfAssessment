package codiltity;

public class MaxSliceProblemSolutionFinal {
	
	public static void main(String[] args) {
		
		int[] inputArr= {5,-4,8,-10,-2,4,-3,2,7,-8,3,-5,3};
		System.out.println(solution(inputArr));
		
	}
	
	private static int solution(int[] A)
	{
		
		/*Below is the variable which we are gonna return
		 * at the end i.e. this variable would contain the
		 * max profit i.e. the sum of the max sub array*/
		int globalMax=A[0];
		/*this variable which we will use to store the temporary
		 * sum of the sub the arrays while processing the input
		 * array.*/
		int localMax=0;
		for(int i=0;i<A.length;i++)
		{
			if(localMax>globalMax)
				globalMax=localMax;
			if(A[i]<=localMax+A[i])
				localMax+=A[i];
			else if(A[i]>localMax+A[i])
				localMax=A[i];
		}
		
		return globalMax;
		
	}

}
