package codiltity;

import java.util.Stack;

public class BracketProblemSolution1 {

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
			if (b == '[' || b == '{' || b == '(') {
				stack.push(b);
			}
			else if(b==')')
			{
				if(!stack.isEmpty()&&stack.pop()!='(')
					return 0;
			}
			else if(b=='}')
			{
				if(!stack.isEmpty()&&stack.pop()!='{')
					return 0;
			}
			else if(b==']')
			{
				if(!stack.isEmpty()&&stack.pop()!='[')
					return 0;
			}

		}
		
		if(stack.isEmpty())
			return 1;
		else
		return 0;
	}

}
