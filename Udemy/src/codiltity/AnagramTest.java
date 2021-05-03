package codiltity;

import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class AnagramTest {

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
		System.out.println("");
		byte[] s1Arr = s1.getBytes(StandardCharsets.US_ASCII);
		byte[] s2Arr = s2.getBytes(StandardCharsets.US_ASCII);
		/*
		 * One way to solve this iterate each array and check the sum if sum is equal
		 * then say both are anagrams but this approach would be bit expensive as you
		 * can get the large strings and hence the big arrays which will take more time
		 * in traversing we will try to find out other approaches as well
		 */
		int s1ArrSum = 0;
		int s2ArrSum = 0;
		for (byte b : s1Arr) {
			s1ArrSum = s1ArrSum + b;
		}

		for (byte b : s2Arr) {
			s2ArrSum = s2ArrSum + b;
		}

		if (s1ArrSum == s2ArrSum)
			return true;
		return false;
	}

}
