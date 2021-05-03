package codiltity;

public class EquilibriumFinalSolution {

	public EquilibriumFinalSolution() {
		super();
	}

	public static void main(String[] args) {

		int[] arr = { 3, 1, 2, 4, 3 };
		System.out.println(solution(arr));

	}
	
	
	private static int solution(int[] A)
	{
		int leftSum=A[0];
		int rightSum=0;
		for(int x: A)
		{
			rightSum+=x;
		}
		rightSum-=leftSum;
		int diff=Math.abs(leftSum-rightSum);
		for(int i=1;i<A.length-1;i++)
		{
			leftSum+=A[i];
			rightSum-=A[i];
			int currentDiff=Math.abs(leftSum-rightSum);
			if(diff>currentDiff)
			{
				diff=currentDiff;
			}
		}
		return diff;
	}
/*
	private static int solution(int[] A) {
		int leftSum = A[0];
		int rightSum = 0;

		for (int i : A) {
			rightSum += i;
		}
		rightSum -= leftSum;
		int absolutDiff = Math.abs(leftSum - rightSum);
		for (int i = 1; i < A.length-1; i++) {
			leftSum += A[i];
			rightSum -= A[i];
			int localabsolutDiff = Math.abs(leftSum - rightSum);
			if (localabsolutDiff < absolutDiff) {
				absolutDiff = localabsolutDiff;
			}
		}

		return absolutDiff;*/
	//}

}
