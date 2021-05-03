package codiltity;

import java.util.Arrays;

public class FindIntersection {
	
	public static void main(String[] args) {
		
		int[] a= {3,1,2,4,7};
		int[] b= {8,2,5,4,6};
		for(int i: findIntersection(a, b))
		{
			System.out.print(i+",");
		}
	}
	
	public static int[] findIntersection(int[] a, int[] b)
	{
		Arrays.sort(a);
		Arrays.sort(b);
		int[] intersectionArr=new int[a.length];
		int k=0;
		for(int i=0, j=0;i<a.length;)
		{
			if(a[i]==b[j])
			{
				intersectionArr[k]=a[i];
				k++;
				i++;
				j++;
			}
			else if(a[i]>b[j])
			{
				j++;
			}
			else if(b[j]>a[i])
			{
				i++;
			}
			
		}
		return intersectionArr;
	}

}
