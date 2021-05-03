package codiltity;

public class ArrayRotation {

	public static void main(String[] args) {
		int[] arr = { 7, 2, 8, 3, 5 };
		int[] rotatedArray = rotateArray(arr, 3);
		for (int i : rotatedArray) {
			System.out.println(i);
		}
	}

	private static int[] rotateArray(int[] arr, int numberOfRotation) {
		int arrLength = arr.length;
		int[] localArr = new int[arrLength];
		/*
		 * 1%5=1 2%5=2 3%5=3 4%5=4 5%5=0
		 */
		for (int i = 0; i < arrLength; i++) {
			/*
			 * so 0th index is shifting to third but we need to shift it to only 2nd
			 * position 0+1%5=1+2=3; so it would be like below
			 * (i+numberOfRotation)%arr.length 
			 * 0+2%5=2(so 0th will shift to 2nd index
			 * 1+2%5=3 (1st will shift to 3rd position) 
			 * 4+2%5=1 (4th element will shift to the arr[1] which is the second position
			 */
			int index = (i + numberOfRotation) % arrLength;
			localArr[index] = arr[i];

		}

		return localArr;
	}

}
