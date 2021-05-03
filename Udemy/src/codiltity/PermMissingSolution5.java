package codiltity;

public class PermMissingSolution5 {
	public static void main(String[] args) {

		int[] arr = { 2, 3, 1, 5 };
		System.out.println("Missing element is " + missingElement(arr));
	}

	public static int missingElement(int[] A) {

		/*We are using long as the array size and the sum could be big*/
		long  inputArrSum = 0;
		long arrSize = A.length + 1;
		for (int i : A) {
			inputArrSum += i;
		}
		/*
		 * Below is the formula which we are using to get the sum instead of using the
		 * for loop array.
		 */
		long expectedSum = (arrSize * (arrSize + 1) / 2);
		return (int)(expectedSum - inputArrSum);
	}

}
