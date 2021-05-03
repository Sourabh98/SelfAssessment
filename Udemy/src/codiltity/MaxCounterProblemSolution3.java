package codiltity;

public class MaxCounterProblemSolution3 {

	public static void main(String[] args) {

		int counter = 5;
		int[] instructions = { 3, 4, 4, 6, 1, 4, 4 };
		int[] arr = solution(counter, instructions);
		for (int i : arr) {
			System.out.print(i + ",");
		}
	}

	private static int[] solution(int N, int[] A)
	{
		//first step would be create an array on the basis of the counter which will store all the counters
		int[] counterArr=new int[N];
		int startLine=0;
		int currentMax=0;
		//Second step would be iterate through the instructions and then as per the instruction work on the counter
		for(int i: A)
		{
		/*x would be the index as the counter will start from 1 but index from 0 so it means for the counter 1 the index would be 0 and
		 * that's why we are subtracting 1 from the instruction as the instruction represent the action which needs to be performed for 
		 * a particular counter*/
			int x=i-1;
			//Below condition is for the maxcounter instruction
			if(i>N)
			{
				/*So when this condition will occur we won't reset the the whole array with the max value but we move the start line to the 
				 * maxCounter like if the maxCounter is 2 then the startline will become 2*/
				startLine=currentMax;
			}
			else if(counterArr[x]<startLine)
			{
				counterArr[x]=startLine+1;
			}
			else
				counterArr[x]+=1;
			/*Below statement will be for the increase instruction as in case of the increase instruction the instruction would be less than or equal to the counter*/
			if(i<=N && counterArr[x]>currentMax)
			{
				currentMax=counterArr[x];
				
			}
		}
		return null;
	}

}
