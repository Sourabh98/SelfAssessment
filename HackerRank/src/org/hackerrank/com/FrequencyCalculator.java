package org.hackerrank.com;

public class FrequencyCalculator {
	public static void main(String[] args) {
		String s="aba";
		int n=10;
		System.out.println(calculateFrequency(s,n));
	}
	
	private static int calculateFrequency(String s, int n)
	{
		int completeStringLen=n/s.length();
		int remainderStringLen=n%s.length();
		char[] charArr=s.toCharArray();
		int completeStringCount=0;
		int remainderStringCount=0;
		int totalCount=0;
		for(char c: charArr)
		{
			if(c=='a')
			{
				completeStringCount++;
			}
		}
		
		for(int i=0;i<remainderStringLen;i++)
		{
			if(charArr[i]=='a')
			{
				remainderStringCount++;
			}
		}
		totalCount=completeStringCount*completeStringLen+remainderStringCount;
		return totalCount;
	}

}
