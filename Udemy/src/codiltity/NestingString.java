package codiltity;

import java.util.Stack;

public class NestingString {
	public static void main(String[] args) {

		//String s = "[()]";--true
		//String s="[()()]";--true
		//String s="[(]()]";--false
		//String s="[{()}]";--true
		//String s="][";--false but in our case we will get EmptyStack exception as we are popping out before pushing anything.
		/*Below will return true as it is a valid nested String*/
		String s="()[]{}()[]{}";
		System.out.println("Is string nested: " + checkNestedString(s));
		
	}

	private static boolean checkNestedString(String s) {
		/*
		 * For a string to be properly nested there should be opening and closing
		 * bracket so if the String is like [()] so you will have to make sure two
		 * things first every right bracket should have the left bracket this can be
		 * done by using stack push and pop, push the string when there is a right
		 * bracket and pop out when there is a left bracket and the last right bracket
		 * should have the first left bracket and at the end you will check if stack is
		 * empty at the end
		 */

		Stack<Character> stack = new Stack<Character>();
		boolean valid =true;
		/*s=[()]*/
		char[] arr = s.toCharArray();
		for (Character c : arr) {
			/*1st [ -->pushed
			 * 2nd ( --> pushed#
			 * 3rd ) --> pop the last one which was )
			 * 4th ] --> pop the last one which was [	*/
			if(c=='[' || c=='{' || c=='(') {
				stack.push(c);
			}
			else if(c==')')
			{
			if(stack.pop()!='(')
				valid=false;
			}
			else if(c=='}')
			{
			if(stack.pop()!='{')
			valid=false;
			}
			else if(c==']')
			{
				if(stack.pop()!='[')
					valid=false;
			}
			
		}
		if(stack.isEmpty() && valid)
			return true;
		return false;
	}

}
