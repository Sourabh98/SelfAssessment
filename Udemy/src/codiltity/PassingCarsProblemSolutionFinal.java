package codiltity;

public class PassingCarsProblemSolutionFinal {
	
	public static void main(String[] args) {
		
		//Expected output 5
		int[] inputArr= {0,1,0,1,1};
		System.out.println(solution(inputArr));
	}
	private static int solution(int[] A)
	{
		/*So here we are using the preffix sum approach to solve the passing cars problem
		 * so for the above input array preffic sum array would be {0,0,1,1,2,3} so basically in 
		 * preffix sum array we just add the previous elements like we will start with 0 and will
		 * add the first element of array A to 0 and will store it at index position 1 in preffix sum
		 * array and then will add the element at index position 1 of array A to the previous element 
		 * in preffix sum array and will store that element at current index position in preffix sum
		 * array and that is how we will get the preffix sum array.*/
		int[] prefixSumArr=new int[A.length+1];
		int passedCarsCount=0;
		for(int i=1;i<A.length+1;i++)
		{
			prefixSumArr[i]=A[i-1]+prefixSumArr[i-1];
		}
		/*Now to get the passed cars count we will perform the subtraction like below*/
		for(int i=0;i<A.length;i++)
		{
			if(A[i]==0)
			{
				passedCarsCount+=prefixSumArr[prefixSumArr.length-1]-prefixSumArr[i];
				if(passedCarsCount>1000000000)
					return -1;
			}
		}
		return passedCarsCount;
	}
	
	

}
