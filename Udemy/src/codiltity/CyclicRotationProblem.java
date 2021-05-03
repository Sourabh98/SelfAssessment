package codiltity;

public class CyclicRotationProblem {

	public static void main(String[] args) {
		
		int[] arr= {5,3,4,1,2};
		for(int x: solution(arr,2))
		{
			System.out.print(x+",");
		}

	}

	private static int[] solution(int[] A, int k) {
		
		int arrSize=A.length;
		int[] newArr=new int[arrSize];
		/*we are going to use the modulus operator here to get the index on the basis of the K
		 * as you can see below we have created a new array of the same size and then returned
		 * it after rotating the elements as number of times given by the variable K*/
		for(int i=0;i<arrSize;i++)
		{
			newArr[(i+k)%arrSize]=A[i];
		}
		return newArr;

	}
}

