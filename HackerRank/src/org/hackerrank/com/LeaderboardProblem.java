package org.hackerrank.com;

public class LeaderboardProblem {

	public static void main(String[] args) {
		/* This array will always be the sorted array in the descending order. */
		int[] score = { 100, 100, 50, 40, 40, 20, 10 };
		int[] aliceScore = { 5, 25, 50, 120 };
		for (int i : findRank(score, aliceScore)) {
			System.out.print(i + " ");
		}
	}

	static int[] findRank(int[] score, int[] aliceScore) {
		/*
		 * Below array will store the rank for the scores which are there on the leader
		 * board
		 */
		int[] rank = new int[score.length];
		// below variable will basically store the rank as per the leaderboard score
		int individualRank = 0;
		for (int i = 0; i < score.length; i++) {
			if (i < score.length - 1 && score[i] == score[i + 1]) {
				individualRank++;
				rank[i] = individualRank;
				rank[i + 1] = individualRank;
				i++;
			} else {
				rank[i] = ++individualRank;
			}

		}
		int[] res = new int[aliceScore.length];
		for (int i = 0; i < aliceScore.length; i++) {
			/*
			 * Below code is for the boundary check so first we will do the boundary check
			 */
			if (aliceScore[i] > score[0]) {
				res[i] = 1;
			} else if (aliceScore[i] < score[score.length - 1]) {
				res[i] = rank[rank.length-1]+1;
			}

			/*
			 * Now we will perform the binary search and to implement this we will use
			 * divide and conquer approach
			 */
			
			else
			{
				int index=binarySearch(score,aliceScore[i]);
				res[i]=rank[index];
			}
		}
		
		return res;
	
	}
	
	/*Below is the code for the binary search, binary search can only be applied if the array is sorted and we know that
	 * the array which is given above is sorted in the descending order
	 * */
	private static int binarySearch(int[] a, int key)
	{
		int lo=0;
		int hi=a.length-1;
		while(lo<=hi)
		{
			int mid=lo+(hi-lo)/2;
			if(a[mid]==key)
				return mid;
			else if(a[mid]<key && key<a[mid-1])
			{
				return mid;
			}
			
			else if(a[mid]>key && key>=a[mid+1])
			{
				return mid+1;
			}
			else if(a[mid]<key)
			{
				hi=mid-1;
			}
			else if(a[mid]>key)
			{
				lo=mid+1;
			}
		}
		return -1;
	}
}
