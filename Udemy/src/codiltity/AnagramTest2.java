package codiltity;

import java.util.Arrays;
import java.util.Scanner;

public class AnagramTest2 {

	public static void main(String[] args) {
		try {
			Scanner sc = new Scanner(System.in);
			System.out.println("Provide the first String for Anagram test: ");
			String s1 = sc.nextLine();
			System.out.println("Provide the second String for Anagram test: ");
			String s2 = sc.nextLine();

			sc.close();
			System.out.println("Anagram Test: " + testAnagram(s1, s2));
		}

		catch (Exception e) {
			e.printStackTrace();
		}

	}

	private static boolean testAnagram(String s1, String s2) {

		/*
		 * Second approach might be to sort both the Strings and then compare them but
		 * in this approach we are using sorting again sorting is an expensive operation
		 * to perform and decrease the performance of the application so we will now
		 * look into the other approach which is the best among them
		 */

		char[] s1CharArr = s1.toCharArray();
		Arrays.sort(s1CharArr);
		char[] s2CharArr = s2.toCharArray();
		Arrays.sort(s2CharArr);

		System.out.println(String.valueOf(s1CharArr));
		System.out.println(String.valueOf(s2CharArr));
		if (String.valueOf(s1CharArr).equals(String.valueOf(s2CharArr)))
			return true;
		return false;
	}

}
