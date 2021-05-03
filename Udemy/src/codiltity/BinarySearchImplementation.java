package codiltity;

/*first requirement for binary search the collection on which you are going to implement this algo
 * that collection should be sorted*/
public class BinarySearchImplementation {

	public static void main(String[] args) {
		/*
		 * So if you will see below the array is sorted, now in this array we wanted to
		 * search for the element 59 Binary search basically uses the divide and conquer
		 * approach so in this array will get divided into two parts from the middle
		 */
		int[] inputArr = { 5, 9, 17, 23, 25, 45, 59, 63, 71, 89 };
		System.out.println(findElementUsingBinarySearch(inputArr,4));
	}

	private static int findElementUsingBinarySearch(int[] A, int numberToSearch) {
		/*In binary search we uses the divide and conquer approach and compare the number which
		 * we wanted to search to the mid number, you can see the implementation below*/
		int left = 0;
		int right = A.length - 1;
		int mid = -1;
		while (left<right) {
			mid = (left + right) / 2;
			if (A[mid] == numberToSearch || left>=A.length || right<=0)
				return mid;
			else if (A[mid] > numberToSearch)
				right = mid-1;
			else if (A[mid] < numberToSearch)
				left = mid+1;
		}
		return -1;
	}

}
