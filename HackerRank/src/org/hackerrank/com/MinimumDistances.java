package org.hackerrank.com;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MinimumDistances {
	
	public static void main(String[] args) {
		
		Integer[] input= {1,2,3,1,7,8,9,1,20,1};
		System.out.println(minimumDistances(Arrays.asList(input)));
		
	}

	 public static int minimumDistances(List<Integer> a) {
		/*First we will create a HashMap to store the list elements with their indices and their values 
		 * while we will be adding the elements to the map first we will search the adding element in the
		 * map if found
		 * 		then we will calculate the distance between both the elements as we already know the distance 
		 * between these two elements would be the difference in between their indices values which we have 
		 * stored as the value in our map*/
		 Map<Integer,Integer> hashMap=new HashMap<Integer,Integer>();
		 int listSize=a.size();
		 int minDis=listSize;
		 for(int i=0;i<listSize;i++)
		 {
			 //here we are checking if the element already exist in the map
			 int currentElement=a.get(i);
			 if(hashMap.containsKey(currentElement))
			 {
				 //here we will find the minimum distance using their indices values.
				 minDis=Math.min(minDis, Math.abs(hashMap.get(currentElement)-i));
			 }
			 
			 hashMap.put(currentElement, i);
		 }
		 if(minDis==listSize)
			 return -1;
		 return minDis;

		    }
}
