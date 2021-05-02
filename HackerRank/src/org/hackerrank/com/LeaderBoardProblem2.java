package org.hackerrank.com;

import java.util.Arrays;
import java.util.List;

public class LeaderBoardProblem2 {
	
	public static void main(String[] args) {
		/* This array will always be the sorted array in the descending order. */
		Integer[] score = { 100, 100, 50, 40, 40, 20, 10 };
		Integer[] aliceScore = { 5, 25, 50, 120 };
		for (int i : climbingLeaderboard(Arrays.asList(score), Arrays.asList(aliceScore))) {
			System.out.print(i + " ");
		}

}


public static List<Integer> climbingLeaderboard(List<Integer> ranked, List<Integer> player) {
	
	

	/*
	 * ranked is the score of all the players, player is the score 
	 * Below array will store the rank for the scores which are there on the leader
	 * board
	 */
	int rankedSize=ranked.size();
	
	int[] rank = new int[rankedSize];
	// below variable will basically store the rank as per the leaderboard score
	
	int individualRank = 0;
	for (int i = 0; i < rankedSize; i++) {
		if (i < rankedSize - 1 && ranked.get(i) == ranked.get(i + 1)) {
			individualRank++;
			rank[i] = individualRank;
			rank[i + 1] = individualRank;
			i++;
		} else {
			rank[i] = ++individualRank;
		}

	}
	int playerSize=player.size();
	Integer[] res = new Integer[playerSize];
	for (int i = 0; i < playerSize; i++) {
		/*
		 * Below code is for the boundary check so first we will do the boundary check
		 */
		if (player.get(i) > ranked.get(0)) {
			res[i] = 1;
		} else if (player.get(i) < ranked.get(rankedSize - 1)) {
			res[i] = rank[rank.length-1]+1;
		}

		/*
		 * Now we will perform the binary search and to implement this we will use
		 * divide and conquer approach
		 */
		
		else
		{
			int index=binarySearch(ranked,player.get(i));
			res[i]=rank[index];
		}
	}
	
	return Arrays.asList(res);

}

/*Below is the code for the binary search, binary search can only be applied if the array is sorted and we know that
 * the array which is given above is sorted in the descending order
 * */
private static int binarySearch(List<Integer> a, int key)
{
	int lo=0;
	int hi=a.size()-1;
	while(lo<=hi)
	{
		int mid=lo+(hi-lo)/2;
		if(a.get(mid)==key)
			return mid;
			/*Below is to check if the element lies in between two adjacent indexes if yes then we will
			 * return the index of the higher element
			 * for example if mid=3
			 * a[3]=40
			 * a[2]=50
			 * key=45
			 * then in this case we will return mid which is 3.
			 * */
		else if(a.get(mid)<key && key<a.get(mid-1))
		{
			return mid;
		}
		
		/*Below is to check if the element is greater then two adjacent elements if yes then we will
		 * return the index of the higher element+1
		 * for example if mid=1, mid will get updated when you will do the binary search
		 * a[1]=100
		 * a[2]=50
		 * key=50
		 * then in this case we will return mid which is 3.
		 * */
		else if(a.get(mid)>key && key>=a.get(mid+1))
		{
			return mid+1;
		}
		else if(a.get(mid)<key)
		{
			hi=mid-1;
		}
		else if(a.get(mid)>key)
		{
			lo=mid+1;
		}
	}
	return -1;
}

}
