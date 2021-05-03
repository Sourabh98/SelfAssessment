package codiltity;

public class LeaderProblemSolution3 {
	public static void main(String[] args) {
		int[] arr= {2,4,3,3,3,2,3};
		int res=solution(arr);
		System.out.println(res);
		
	}

	/*This is not the right solution as this solution will give you multiple wrong answers..*/
	private static int solution(int[] A)
	{
		int currentElement=0;
		int nextElement=0;
		for(int i=0;i<A.length-1;i++)
		{
			currentElement=A[i];
			nextElement=A[i+1];
			if(currentElement!=nextElement)
			{
				A[i]=0;
				//A[i+1]=0;
			}
		}
		for(int i=0;i<A.length;i++)
		{
			if(A[i]!=0)
			{
				return A[i];
			}
		}
		return -1;
	}

}
