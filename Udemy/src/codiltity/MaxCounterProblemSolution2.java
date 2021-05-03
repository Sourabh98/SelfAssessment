package codiltity;

import java.util.Arrays;

public class MaxCounterProblemSolution2 {
	
public static void main(String[] args) {
		
		//expected O/P [3,2,2,4,2]
		/*
		 * int n=5; int insArr[] = {3,4,4,6,1,4,4};
		 */
	
	int n=1;
	int insArr[]= {2, 1, 1, 2, 1};
		int[] arr=solution(n, insArr);
		for(int i: arr)
		{
			System.out.print(i+",");
		}
	}
	
	private static int[] solution(int N, int[] A)
	{
		int[] arr=new int[N];

		for(int i=0;i<A.length; i++)
		{
			if(i>0 && A[i]>N && A[i]>A[i-1])
			{
				int[] newarr=new int[N];
				System.arraycopy(arr,0,newarr,0,newarr.length) ;
				Arrays.sort(newarr);
				int maxCounter=newarr[N-1];
				Arrays.fill(arr, maxCounter);
			}
			else if(A[i]<=N)
			{
				arr[A[i]-1]+=1;
			}
		}
		return arr;
	}

}
