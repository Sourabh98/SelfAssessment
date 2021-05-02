package datastructures;

import java.util.Scanner;

public class MyStack<T> {

	private Scanner sc;
	private T[] stack;
	private int arraySize;
	private int top = 0;

	@SuppressWarnings("unchecked")
	public MyStack() {
		System.out.println("Give the size of the array..");
		sc = new Scanner(System.in);
		arraySize = sc.nextInt();
		stack = (T[]) new Object[arraySize];
	}

	

	public void push(T o) {

		/*
		 * Before pushing elements we can put a check if the stack is full or not and if
		 * it not full then only we will add an element to the stack this will help us
		 * avoiding the arrayIndexOutOfBoundException
		 *
		 */
		if (top + 1 > stack.length) {
			expand();
		}
		/*
		 * Now we will use an array to implement our stack, so first we will define
		 * fixed size array and then we will push the elements to that array, we can
		 * make the arrays as dynamic as well where we will take the input from the user
		 * what array size we want, when we push the element we assign the element to
		 * the lowest position which would be 0 in this case
		 */

		stack[top] = o;
		/* Increasing the counter to insert the value at the right position.. */
		top++;

	}

	public T pop() {
		/*
		 * Before popping out the value from the stack first we will check if the stack
		 * is empty or not and if it is empty then we won't pop out the value
		 */
		T popObject = null;
		if (this.isEmpty()) {
			System.out.println("Stack is empty...");
		}
		/*
		 * Now in pop we will remove the values from the stack here in our case we have
		 * implemented the stack using the array so we will remove the value from the
		 * array from the top
		 */
		else {
			if(top-1<stack.length/2)
			{
				shrink();
			}
			popObject = stack[top - 1];
			/*
			 * Here setting the top as null and decrementing the counter as well, we have to
			 * decrement it before setting as null because when you will add the element at
			 * 0th position the top value would be 1 so at the end the top will point to the
			 * index one higher to the index where the value will be actually stored.
			 */
			stack[--top] = null;
			return popObject;
		}
		return popObject;
	}

	public void show() {
		for (T element : stack) {
			System.out.println(element + " ");
		}
	}

	public void peek() {
		/*
		 * Here in peak we are only returning the value from the stack but we are not
		 * removing it means that we won't reset the value of the top counter..
		 */
		if (!this.isEmpty()) {
			System.out.println(stack[top - 1]);
		} else {
			System.out.println("Stack is empty...This is from peek..");
		}

	}

	public int size() {
		/*
		 * Returning top here as top will give us the size of the array as it would
		 * always be pointing to the top element in an array..
		 */
		return stack.length;
	}

	public boolean isEmpty() {
		/*
		 * so if the value of the top is empty then it will return true as it means
		 * there is no value in the stack till now
		 */
		return top <= 0;
	}

	@SuppressWarnings("unchecked")
	private void expand() {
		/*
		 * You can't resize an array in Java. You'd need to either: Create a new array
		 * of the desired size, and copy the contents from the original array to the new
		 * array, using java. ... ArrayList<T> class, which does this for you when you
		 * need to make the array bigger. So expand method is getting invoked when our
		 * stack is full and in this method we are creating a new array of the double
		 * size as the last one and initialising the new array with the values which
		 * were there in the last array.
		 */
		int length = top;
		T[] tempStack = stack;
		stack = (T[]) new Object[stack.length * 2];
		/*
		 * First parameter in this method is from where i want to copy it i.e. the
		 * source, the next parameter is from which index i wanted to copy as i wanted
		 * to copy the whole array so that parameter value would be 0, then will pass the
		 * name of the new array then the next parameter would be for the index in the
		 * destination array like from which index in the destination array i wanted to
		 * copy the source array and the length would means till what length i wanted to
		 * copy as i wanted to copy the whole array so will pass the length only, i
		 * initiliased length with the top as the top will indicate the index for the
		 * last value which we have inserted in the array.
		 */
		System.arraycopy(tempStack, 0, stack, 0, length);

	}
	
	/*This method will shrink the array by half whenever it would be invoked*/
	@SuppressWarnings("unchecked")
	private void shrink()
	{
		int length = top;
		T[] tempStack=stack;
		stack=(T[]) new Object[stack.length/2];
		System.arraycopy(tempStack, 0, stack, 0, length);
	}

}
