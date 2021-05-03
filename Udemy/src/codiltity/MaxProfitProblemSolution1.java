package codiltity;

public class MaxProfitProblemSolution1 {

		
		public static void main(String[] args) {
			
			int[] inputArr= {114,132,119,91,84,29,61,76,38,21,9,63,65,68,81,124,118,78,44,59,80};
			System.out.println(solution(inputArr));
			
		}
		
		private static int solution(int[] A)
		{
			
			/*Below is the code to re encode the input
			 * array so that we can apply Kedane's algorithm
			 * on it to get the maximum profit*/
			int[] reEncodedArr=new int[A.length-1];
			for(int i=1;i<A.length;i++)
			{
				reEncodedArr[i-1]=A[i]-A[i-1];
			}
			/*Below is the variable which we are gonna return
			 * at the end i.e. this variable would contain the
			 * max profit i.e. the sum of the max sub array*/
			int globalMax=A[0];
			/*this variable which we will use to store the temporary
			 * sum of the sub the arrays while processing the input
			 * array.*/
			int localMax=0;
			for(int i=0;i<reEncodedArr.length;i++)
			{
				if(localMax>globalMax)
					globalMax=localMax;
				if(reEncodedArr[i]<=localMax+reEncodedArr[i])
					localMax+=reEncodedArr[i];
				else if(reEncodedArr[i]>localMax+reEncodedArr[i])
					localMax=reEncodedArr[i];
			}
			
			return globalMax;
			
		}

	}


