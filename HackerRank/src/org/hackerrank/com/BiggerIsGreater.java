package org.hackerrank.com;

import java.util.Arrays;

public class BiggerIsGreater {
	public static void main(String[] args) {
		//String s="ecdigf";
		String s="bb";
		for(char c: biggerIsGreater(s).toCharArray())
		{
			System.out.print(c+" ");
		}
		
	}
	
	static String biggerIsGreater(String w)
	
	{
		char[] charArr=w.toCharArray();
		int smallCharIndex=0;
		int nextSmallChar=0;
		int i=0;
		/*In below for loop we are traversing the input string in the reverse direction and 
		 * trying to find out the such two adjacent elements in which the first element is 
		 * greater than the next element*/
		for(i=charArr.length-1;i>0;i--)
		{
			if(charArr[i]>charArr[i-1])
			{
				/*This will be the smaller character in the pair of two adjacent elements*/
				smallCharIndex=i-1;
				/*Below variable will store the index value for the one element which is adjacent 
				 * to the smaller element*/
				nextSmallChar=i;
				/*Now in the below loop we will traverse the element from the index where we find
				 * the two adjacent element one is greater then the other to the end of the array
				 * to find the next greater element to the smaller element which we already found*/
				for(int j=i+1;j<charArr.length;j++)
				{
					if(charArr[j]>charArr[smallCharIndex] && charArr[nextSmallChar]>charArr[j])
					{
						nextSmallChar=j;
					}
				}
				char localSmallCharValue=charArr[smallCharIndex];
				charArr[smallCharIndex]=charArr[nextSmallChar];
				charArr[nextSmallChar]=localSmallCharValue;
				Arrays.sort(charArr, smallCharIndex+1, charArr.length);
				break;
			}
			
		}
		if(i==0)
			return "no answer";
		else
		return String.valueOf(charArr);
	}

}
