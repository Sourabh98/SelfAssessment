package codiltity;

import java.util.Stack;

public class LeaderProblemSolution4 {
	public static void main(String[] args) {
		int[] arr = { 2, 4, 3, 3, 3, 2, 3 };
		int res = solution(arr);
		System.out.println(res);

	}

	private static int solution(int[] A) {
		Stack<Integer> stack = new Stack<Integer>();
		int count = 0;
		int index = 0;
		for (int i = 0; i < A.length; i++) {
			if (stack.isEmpty() || A[i] == stack.peek()) {
				stack.push(A[i]);
			} else if (A[i] != stack.peek()) {
				stack.pop();
			}
		}
		int toBeLeader = 0;
		boolean flag = false;
		if (!stack.isEmpty()) {
			toBeLeader = stack.pop();
			flag = true;
		}
		int i = 0;
		while (flag && i < A.length) {
			if (A[i] == toBeLeader) {
				count++;
				index = i;
			}
			i++;

		}
		if (A.length != 0 && count > A.length / 2) {
			return index;
		} else
			return -1;
	}
}
