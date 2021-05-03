package codiltity;

public class LeaderProblemSolutionFinal {
	
	public static void main(String[] args) {
		int[] arr = { 2, 4, 3, 3, 3, 2, 3 };
		int res = solution(arr);
		System.out.println(res);

	}

	private static int solution(int[] A) {
		int candidate=0;
		int counter=0;
		int index=0;
		//Stack<Integer> stack=new Stack<Integer>();
		for(int i=0;i<A.length;i++)
		{
			if(counter==0)
			{
				//stack.push(A[i]);
				candidate=A[i];
				counter++;	
			}
			else if(candidate==A[i])
			{
				counter++;
			}
			else if(candidate!=A[i])
			{
				counter--;
			}
		}
		
		int count=0;
		for(int i=0;i<A.length;i++)
		{
			if(A[i]==candidate)
			{
				count++;
				index=i;
				
			}
		}
		return count>A.length/2?index:-1;
	}

}
