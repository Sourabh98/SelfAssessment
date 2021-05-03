package codiltity;

import java.util.Arrays;

public class MaxCounterProblemSolution1 {

	public static void main(String[] args) {
		
		//expected O/P [3,2,2,4,2]
		int n=5;
		int insArr[] = {3,4,4,6,1,4,4};
		int[] arr=solution(n, insArr);
		for(int i: arr)
		{
			System.out.print(i+",");
		}
	}
	
	private static int[] solution(int n, int[] A)
	{
		int[] arr=new int[n];

		for(int m: A)
		{
			if(m>n)
			{
				int[] newarr=new int[n];
				System.arraycopy(arr,0,newarr,0,newarr.length) ;
				Arrays.sort(newarr);
				int maxCounter=newarr[n-1];
				for(int i=0;i<arr.length;i++)
				{
					arr[i]=maxCounter;
				}
			}
			else
			{
				arr[m-1]+=1;
			}
		}
		return arr;
	}
}
