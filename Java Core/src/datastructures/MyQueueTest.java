package datastructures;

public class MyQueueTest {

public static void main(String[] args) {
	
	
	MyQueue<Integer> myQueue=new MyQueue<Integer>();
	myQueue.enqueue(1);
	myQueue.enqueue(2);
	myQueue.enqueue(3);
	myQueue.enqueue(4);
	myQueue.show();
	System.out.println("Size of the queue : "+myQueue.size());
	System.out.println("Dequeuing element:");
	System.out.println(myQueue.dequeue());
	System.out.println("Printing elements after dequeuing...");
	myQueue.show();
	System.out.println("Dequeuing element:");
	System.out.println(myQueue.dequeue());
	System.out.println("Printing elements after dequeuing...");
	myQueue.show();
	System.out.println("Dequeuing element:");
	System.out.println(myQueue.dequeue());
	System.out.println("Printing elements after dequeuing...");
	myQueue.show();
	System.out.println("Dequeuing element:");
	System.out.println(myQueue.dequeue());
	System.out.println("Printing elements after dequeuing...");
	myQueue.show();
	System.out.println("Dequeuing element:");
	System.out.println(myQueue.dequeue());
	System.out.println("Printing elements after dequeuing...");
	myQueue.show();
	System.out.println("Size of the queue : "+myQueue.size());
}	
}
