package codiltity;

import java.util.Arrays;

public class DiscIntersectionProblemSolution1 {
	
	public static void main(String[] args) {
		int[] inputArr= {1,5,2,1,4,0};
		System.out.println(solution(inputArr));
	}
	
	private static int solution(int[] A)
	{
		int[] startingPointArr=new int[A.length];
		for(int i=0;i<A.length;i++)
		{
			startingPointArr[i]=i-A[i];
		}
		Arrays.sort(startingPointArr);
		return 0;
	}

}
