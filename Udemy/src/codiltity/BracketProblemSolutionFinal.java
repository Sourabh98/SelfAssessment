package codiltity;

import java.util.Stack;

public class BracketProblemSolutionFinal {

	public static void main(String[] args) {

		// String s="[({})]()";
		// String s="][";
		//String s = "[{()}]";
		String s="([)()]";
		System.out.println(solution(s));
	}

	private static int solution(String S) {
		char[] arr = S.toCharArray();
		Stack<Character> stack = new Stack<Character>();

		
		for (char b : arr) {
			/*Here we are pushing all the left brackets to the stack*/
			if (b == '[' || b == '{' || b == '(') {
				stack.push(b);
			}
			/*here we are checking if we have encountered the right bracket and if yes then we will pop the top element from the stack
			 * and will check if the popped element is the right bracket for this left bracket as if this would be right then only it
			 * would be a properly nested string and we are also checking for the stack is empty as if the stack would be empty then 
			 * we shouldn't pop out the value as this will throw the exception*/
			else if(b==')')
			{
				if(stack.isEmpty()||stack.pop()!='(')
					return 0;
			}
			else if(b=='}')
			{
				if(stack.isEmpty()||stack.pop()!='{')
					return 0;
			}
			else if(b==']')
			{
				if(stack.isEmpty()||stack.pop()!='[')
					return 0;
			}

		}
		
		if(stack.isEmpty())
			return 1;
		else
		return 0;
	}
}
