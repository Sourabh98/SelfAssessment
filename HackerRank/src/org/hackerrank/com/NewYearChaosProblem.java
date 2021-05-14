package org.hackerrank.com;

import java.util.Arrays;
import java.util.List;

public class NewYearChaosProblem {

	public static void main(String[] args) {
		// Integer[] inputArr = { 5, 1, 2, 3, 7, 8, 6, 4 };
		Integer[] inputArr = { 2, 1, 5, 3, 4 };
		minimumBribes(Arrays.asList(inputArr));

	}

	public static void minimumBribes(List<Integer> q) {
		// Write your code here

		int listSize = q.size();
		int swapCount = 0;
		boolean flag = true;
		/*
		 * We will loop it in backward direction as bribe will be given to the person
		 * who is in front of you.
		 */
		for (int i = listSize - 1; i > 0; i--) {
			/*
			 * if this is not equal then that means number has been swapped then we will try
			 * to find out the swap count or to how many people bribe has been given Note:
			 * list will always suppose to start from 1 and then in the ascending order
			 * after that so without swapping the number at index position 0 should be 1 and
			 * if it is not 1 then that means it has been swapped same goes for every
			 * element at any index
			 */ if (q.get(i) != i + 1) {
				if (q.get(i - 1) == i + 1) {
					q = swap(q, i - 1, i);
					swapCount++;
				} else if (q.get(i - 2) == i + 1) {
					q = swap(q, i - 2, i - 1);
					q = swap(q, i - 1, i);
					swapCount += 2;
				} else {
					System.out.println("Too chaotic");
					flag = false;
					break;
				}

			}
		}
		if (flag)
			System.out.println(swapCount);
	}

	static List<Integer> swap(List<Integer> list, int fromIndex, int toIndex) {
		Integer currentElementAtFromPosition = list.get(fromIndex);
		Integer cuurentElementAtToIndex = list.get(toIndex);
		list.set(toIndex, currentElementAtFromPosition);
		list.set(fromIndex, cuurentElementAtToIndex);
		return list;
	}
}
