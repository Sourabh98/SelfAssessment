package org.hackerrank.com;

import java.util.Arrays;
import java.util.List;

public class PickingNumberProblem {

	public static void main(String[] args) {
		Integer[] inputArray = { 1, 1, 2, 2, 4, 4, 5, 5, 5 };
		System.out.println(pickingNumbers(Arrays.asList(inputArray)));

	}

	public static int pickingNumbers(List<Integer> a) {
		// Write your code here
		/*First we will make a frequency table for the input array as discussed in the algo as well
		 *and in the frequency table index will represent the number and the value of the index will represent the 
		 *count */
		int listSize = a.size();
		int[] frequencyTable = new int[101];
		int finalResult = 0;
		for (int i = 0; i < listSize; i++) {
			// here we are making a frequency table
			frequencyTable[a.get(i)] = frequencyTable[a.get(i)] + 1;
		}

		for (int i = 1; i < frequencyTable.length - 1; i++) {
			int sumBetweenCurrentAndPreviousFrequency = frequencyTable[i] + frequencyTable[i - 1];
			int sumBetweenCurrentAndNextFrequency = frequencyTable[i] + frequencyTable[i + 1];
			int maxBetweenTwoFrequencies=Math.max(sumBetweenCurrentAndPreviousFrequency, sumBetweenCurrentAndNextFrequency);

			finalResult = Math.max(finalResult, maxBetweenTwoFrequencies);
		}
		return finalResult;
	}

}
