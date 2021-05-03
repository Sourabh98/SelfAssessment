package codiltity;

public class LeaderProblemSolution1 {
	
	public static void main(String[] args) {
		int[] arr= {2,4,3,3,3,2,3,4};
		int res=solution(arr);
		System.out.println(res);
		/*
		 * for(int i: res) { System.out.println(i+" "); }
		 */
	}
	
	/*
	 * This function can return the element but for the worst case it's time
	 * complexity would be quadratic //worst case would be when there won't be any
	 * leader and we will have to go through the whole array to find the leader
	 */
	private static int solution(int[] A)
	{
		int count=0;
		int leader=0;
		for(int i=0;i<A.length;i++)
		{
			leader=A[i];
			for(int j=0;j<A.length; j++)
			{
				if(leader==A[j])
				{
					count++;
				}
			}
			if(count>A.length/2)
				break;
			else
			{
				leader=0;
				count=0;
			}
		}
		return leader;
	}

}
