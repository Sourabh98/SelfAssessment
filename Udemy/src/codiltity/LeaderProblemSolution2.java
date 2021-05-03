package codiltity;

import java.util.Arrays;

public class LeaderProblemSolution2 {
	
	public static void main(String[] args) {
		int[] arr= {2,4,3,3,3,2,3};
		int res=solution(arr);
		System.out.println(res);
		/*
		 * for(int i: res) { System.out.println(i+" "); }
		 */
	}
	
	
	private static int solution(int[] A)
	{
		/*First we will sort the array in this solution and then we will pick the middle element in the 
		 * array and will check the occurrences of that element if the number of occurrences would be more
		 * than the half the size of the array then that would be our leader else there won't be any leader
		 * as we know that if the number of occurrences of an element would be more than half the size of the
		 * array then the same should number be the middle element as well*/
		Arrays.sort(A);
		int arraySize=A.length;
		int leader=0;
		if(arraySize!=0)
		{
			leader=A[arraySize/2];
		}
		else
		{
			return -1;
		}
		int leaderIndex=0;
		int count=0;
		for(int i=0;i<A.length;i++)
		{
			if(leader==A[i])
			{
				leaderIndex=i;
				count++;
			}
		}
		if(count>arraySize/2)
		{
			return leaderIndex;
		}
		else
			return -1;

		
	}

}
