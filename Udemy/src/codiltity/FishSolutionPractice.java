package codiltity;

import java.util.Stack;

public class FishSolutionPractice {

	public static void main(String[] args) {
		int[] fishWeight = { 4, 3, 2, 1, 5 };
		int[] fishDirection = { 0, 1, 0, 0, 0 };
		int[] fishWeight2 = { 4, 8, 2, 6, 7 };
		int[] fishDirection2 = { 0, 1, 1, 0, 0 };
		// Expected O/P is 2
		System.out.println(solution(fishWeight, fishDirection));
		// Expected output is 2
		System.out.println(solution(fishWeight2, fishDirection2));
	}

	private static int solution(int[] A, int[] B) {
		int survivor = 0;

		Stack<Integer> stack = new Stack<Integer>();
		for (int i = 0; i < A.length; i++) {
			int weight = A[i];
			if (B[i] == 1) {
				stack.push(A[i]);
			} else {

				while (!stack.isEmpty() && weight > stack.peek()) {
					stack.pop();
				}
				if (stack.isEmpty()) {
					survivor++;
				}
			}
		}
		return survivor+stack.size();
	}
}
