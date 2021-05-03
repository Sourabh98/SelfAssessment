package codiltity;

import java.util.Scanner;

public class AnagramTest3 {

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
		 * In this approach first we will create an array for all the ASCII characters
		 * so we have ASCII characters from 0 to 255 so we will create an array of
		 * length 256 and each index of this array will represent the ASCII value of the
		 * character let's gooo C += A is equivalent to C = C + A
		 */
		byte[] byteArr = new byte[256];
		byte[] s1ByteArr = s1.getBytes();
		byte[] s2ByteArr = s2.getBytes();
		if (s1ByteArr.length != s2ByteArr.length)
			return false;
		else {
			for (byte b : s1ByteArr) {
				byteArr[b] = ++byteArr[b];
			}

			for (byte b : s2ByteArr) {
				byteArr[b] = --byteArr[b];
				if (byteArr[b] < 0)
					return false;
			}
		}

		return true;
	}
}
