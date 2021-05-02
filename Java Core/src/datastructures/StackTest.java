package datastructures;

public class StackTest {

	public static void main(String[] args) {

		/*
		 * Creating the object of MyStack in the constructor we have written the code to
		 * provide the array size and we will read the value from the console through
		 * inputstream. input 1: arraySize=3(this will create the stack with size 3 as
		 * we are using array to implement the stack) input 2: arraySize=4
		 */
		MyStack<Integer> myStack = new MyStack<Integer>();
		/*
		 * Now when we are pushing the element to stack before pushing the elements we
		 * are checking if we have available memory in the stack and if it is not then
		 * we are returning Stack is full, memory is getting allocated when we are
		 * creating the instance of MyStack
		 */
		myStack.push(10);
		myStack.push(15);
		myStack.push(20);
		myStack.show();
		/*
		 * Now we have allocated the memory for 3 elements for stack now we will try to
		 * push one more element to the stack it should print stack is full and the
		 * value will not get added to the stack
		 */
		System.out.println("Pushing 25 to stack...");
		myStack.push(25);
		myStack.show();
		System.out.println("Popping the last value from stack...");
		System.out.println("Popped value: " + myStack.pop());

		myStack.show();
		System.out.println("Popping the second last value from stack...");
		System.out.println("Popped value: " + myStack.pop());
		System.out.println("Popping the first value from stack...");
		System.out.println("Popped value: " + myStack.pop());
		/*
		 * Now we have only three elements in the stack so if we will try to pop out one
		 * more it should throw an ArrayIndexOutOfBoundException but as we handled it in
		 * our code it will say stack is empty
		 */
		System.out.println("Popping out the value again....");
		System.out.println("Popped value: " + myStack.pop());

		/* Trying to peek or get the value after emptying the stack */
		myStack.peek();

		/*
		 * Now we are testing the expand functionality of our array so we will push the
		 * element again after our stack is full and then we will check the size of our
		 * array it should get double
		 */
		System.out.println("Size of the array before the expansion: " + myStack.size());
		myStack.push(30);
		myStack.push(35);
		myStack.push(40);
		myStack.push(45);
		myStack.push(50);
		myStack.show();
		System.out.println("Size of the new array after invoking the expand function: " + myStack.size());
		/*
		 * Now we are testing the expand functionality of our array so we will push the
		 * element again after our stack is full and then we will check the size of our
		 * array it should get double
		 */
		System.out.println("Size of the array before the expansion: " + myStack.size());
		myStack.push(30);
		myStack.push(35);
		myStack.push(40);
		myStack.push(45);
		myStack.push(50);
		myStack.show();
		System.out.println("Size of the new array after invoking the expand function: " + myStack.size());

		System.out.println("Size of the array before the expansion: " + myStack.size());
		myStack.push(30);
		myStack.push(35);
		myStack.push(40);
		myStack.push(45);
		myStack.push(50);
		myStack.show();
		System.out.println("Size of the new array after invoking the expand function: " + myStack.size());

		System.out.println("Size of the array before the expansion: " + myStack.size());
		myStack.push(30);
		myStack.push(35);
		myStack.push(40);
		myStack.push(45);
		myStack.push(50);
		myStack.show();
		System.out.println("Size of the new array after invoking the expand function: " + myStack.size());

		System.out.println(
				"---------------------------------------------------------------------------------------------------------------------------------");
		System.out.println(
				"---------------------------------------------------------------------------------------------------------------------------------");
		System.out.println("Testing the shrink functionality.....................................");
		System.out.println("Creting a new stack here.......");
		/*
		 * We will create the stack of size 4 and will try to add 5 elements as we have
		 * the dynamic stack so when we will add the 5th element the size of the stack
		 * will get doubled i.e. it would become 8 then we will delete the 5th and 4th
		 * element now as we have only 3 elements in the stack and the size is 8 so in
		 * this case the stack should shrink and should become of size 4
		 */
		MyStack<Integer> myStack2 = new MyStack<Integer>();
		myStack2.push(1);
		myStack2.push(2);
		myStack2.push(3);
		myStack2.push(4);
		myStack2.show();
		System.out.println("Current Size of the stack: " + myStack2.size());
		myStack2.push(5);
		myStack2.show();
		System.out.println("Checking size of the stack again: " + myStack2.size());
		System.out.println("Now we are popping out the value from the stack....");
		myStack2.pop();
		System.out.println("Checking the size of the stack after popping out 5: " + myStack2.size());
		myStack2.pop();
		myStack2.show();
		System.out.println(
				"Checking the size of the stack again after popping out 4 now the stack should shrink as the number of elements in the stack are only 3 and the size was 8 so it should become 4 now, checking..."
						+ myStack2.size());
		
		myStack2.pop();
		myStack2.pop();
		System.out.println("Now again only 1 is left in the stack so stack size should shrink and 2 should be size of the stack this time..checking..."+myStack2.size());

	}
}
