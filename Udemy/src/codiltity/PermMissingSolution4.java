package codiltity;

public class PermMissingSolution4 {

	public static void main(String[] args) {

		int[] arr = { 2, 3, 1, 5 };
		System.out.println("Missing element is " + missingElement(arr));
	}

	public static int missingElement(int[] A) {
		int inputArrSum = 0;
		int expectedSum = 0;
		for (int i : A) {
			inputArrSum += i;

		}

		for (int i = 1; i <= A.length + 1; i++) {
			expectedSum += i;
		}
		return expectedSum - inputArrSum;

	}

}
