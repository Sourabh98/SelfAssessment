package org.hackerrank.com;

import java.util.Arrays;
import java.util.List;

public class LeaderBoardProblemFinal {

	public static void main(String[] args) {
		/* This array will always be the sorted array in the descending order. */
		Integer[] score = { 100, 100, 50, 40, 40, 20, 10 };
		Integer[] aliceScore = { 5, 25, 50, 120 };
		for (int i : climbingLeaderboard(Arrays.asList(score), Arrays.asList(aliceScore))) {
			System.out.print(i + " ");
		}

	}

	public static List<Integer> climbingLeaderboard(List<Integer> ranked, List<Integer> player) {

		int n = ranked.size();
		int m = player.size();
		Integer res[] = new Integer[m];
		Integer rank[] = new Integer[n];
		rank[0] = 1;
		for (int i = 1; i < n; i++) {
			if (ranked.get(i) == ranked.get(i - 1)) {
				rank[i] = rank[i - 1];
			} else {
				rank[i] = rank[i - 1] + 1;
			}
		}

		for (int i = 0; i < m; i++) {
			int aliceScore = player.get(i).intValue();
			if (aliceScore > ranked.get(0)) {
				res[i] = 1;
			} else if (aliceScore < ranked.get(n - 1)) {
				res[i] = rank[n - 1] + 1;
			} else {
				int index = binarySearch(ranked, aliceScore);
				res[i] = rank[index];
			}
		}
		return Arrays.asList(res);

	}

	private static int binarySearch(List<Integer> a, int key) {
		int lo = 0;
		int hi = a.size() - 1;
		while (lo <= hi) {
			int mid = lo + (hi - lo) / 2;
			if (a.get(mid) == key)
				return mid;
			/*
			 * Below is to check if the element lies in between two adjacent indexes if yes
			 * then we will return the index of the higher element for example if mid=3
			 * a[3]=40 a[2]=50 key=45 then in this case we will return mid which is 3.
			 */
			else if (a.get(mid) < key && key < a.get(mid - 1)) {
				return mid;
			}

			/*
			 * Below is to check if the element is greater then two adjacent elements if yes
			 * then we will return the index of the higher element+1 for example if mid=1,
			 * mid will get updated when you will do the binary search a[1]=100 a[2]=50
			 * key=50 then in this case we will return mid which is 3.
			 */
			else if (a.get(mid) > key && key >= a.get(mid + 1)) {
				return mid + 1;
			} else if (a.get(mid) < key) {
				hi = mid - 1;
			} else if (a.get(mid) > key) {
				lo = mid + 1;
			}
		}
		return -1;
	}

}
