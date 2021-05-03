package codiltity;

import java.util.Arrays;

public class IntersectionProblem {

	public static void main(String[] args) {

		int[] a = {1,2,3,4,7};
		int[] b = {2,4,5,6,8};

		int[] intersection=findIntersection(a, b);
		/*
		 * for (int i : findIntersection(a, b)) {
		 * System.out.println("Intersection elements are: " + i);
		 */
		//}
	}

	private static int[] findIntersection(int[] a, int[] b) {
		int[] intersection = new int[a.length];
		int k = 0;
		Arrays.sort(a);
		Arrays.sort(b);
		/*
		 * So in this we will have to check after sorting if both the elements are equal
		 * then add them to the array else increase the pointer for the array which one
		 * is smaller
		 */
		
		for (int i = 0; i < a.length;) {
			for (int j = 0; j < b.length;) {
				if (a[i] == b[j]) {
					intersection[k] = a[i];
					k++;
					i++;
					j++;
				} else if (a[i] < b[j])
					i++;
				else if (a[i] > b[j])
					j++;
				break;
			}
		}
		return intersection;
	}

}
