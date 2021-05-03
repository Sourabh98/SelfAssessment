package codiltity;

import java.util.Arrays;

public class PermMissingSolution2 {

	public static void main(String[] args) {

		int[] arr = { 2, 3, 1, 5 };
		System.out.println("Missing element is " + missingElement(arr));
	}

	public static int missingElement(int[] A) {
		boolean found = false;
		Arrays.sort(A);
		int x;
		for (x = 1; x <= A.length + 1; x++) {
			for (int i : A) {
				if (x == i) {
					found = true;
					break;
				}
				else
					found=false;

			}
			if (!found) {
				break;
			}
		}

		return x;
	}

}
