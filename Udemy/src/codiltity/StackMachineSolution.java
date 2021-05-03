package codiltity;

import java.util.Stack;

public class StackMachineSolution {

	public static void main(String[] args) {

		String input = "13+62*7+*";
		System.out.println(solution(input));

	}

	private static int solution(String S) {
		char[] numbersAndOperations = S.toCharArray();
		Stack<Integer> stackMachine = new Stack<Integer>();
		for (int i = 0; i < numbersAndOperations.length; i++) {
			int firstValue = 0;
			int secondValue = 0;
			if (numbersAndOperations[i] != '+' && numbersAndOperations[i] != '*') {
				stackMachine.push(Character.getNumericValue(numbersAndOperations[i]));
			}
			else if (numbersAndOperations[i] == '+') {

				firstValue = stackMachine.isEmpty() ? -1 : stackMachine.pop();
				secondValue = stackMachine.isEmpty() ? -1 : stackMachine.pop();
				stackMachine.push(firstValue + secondValue);
			} else if (numbersAndOperations[i] == '*') {
				firstValue = stackMachine.isEmpty() ? -1 : stackMachine.pop();
				secondValue = stackMachine.isEmpty() ? -1 : stackMachine.pop();
				stackMachine.push(firstValue * secondValue);
			}
			if (firstValue == -1 || secondValue == -1)
				return -1;
		}
		return stackMachine.isEmpty() ? -1 : stackMachine.pop();
	}
}
