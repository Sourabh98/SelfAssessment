package codiltity;

import java.util.Arrays;

public class PermMissingElement {

	public static void main(String[] args) {

		int[] arr = { 2, 3, 1, 5};
		System.out.println("Missing element is " + missingElement(arr));
	}

	public static int missingElement(int[] arr) {
		Arrays.sort(arr);
		int counter = 1;
		for (int i = 0; i < arr.length; i++) {
			if (counter == arr[i]) {
				counter++;
				continue;

			} else {
				return counter;
			}
		}

		return 0;
	}

}
