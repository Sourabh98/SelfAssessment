package codiltity;

public class MissingNumber {

	public static void main(String[] args) {
		int[] arr = { 0, 2, 4, 6, 8, 12, 14, 16, 18 };
		System.out.println("Missing number: " + findMissingNumber(arr));
	}

	private static int findMissingNumber(int[] arr) {
		int initialNumber = 0;
		/*
		 * So here we are doing the linear search which is in terms of time complexity
		 * will take lot of time so instead of that we can use the binary search to
		 * solve this problem
		 */
		for (int i : arr) {

			if (i == initialNumber) {
				initialNumber = initialNumber + 2;
			} else
				return initialNumber;

		}
		return -1;

	}

}
