package datastructures;

public class DynamicQueueTest {

	public static void main(String[] args) {

		DynamicQueue<Integer> dynamicQueue = new DynamicQueue<Integer>();
		/*
		 * Input parameters: 
		 * Test 1 
		 * Initial size : 2
		 * Will enqueue two elements then
		 * dequeue 1 element (0th position element should get dequeue) 
		 * then will add one more element should be added to the 0th index and the front should point to
		 * the 1st index
		 * 
		 */

		/* Adding elements to the dynamic queue */
		dynamicQueue.enqueue(5);
		dynamicQueue.enqueue(10);
		System.out.println("Displaying after enqueuing two elements..");
		dynamicQueue.show();
		/*Removing one element*/
		System.out.println("Dequeuing: "+dynamicQueue.dequeue());
		/*Displaying the elements after removing the elements from the queue..*/
		System.out.println("Displaying after dequeuing one element..");
		dynamicQueue.show();
		/*Adding one more element to the queue as mentioned above it should be added to the 0th index*/
		dynamicQueue.enqueue(15);
		/*Displaying the elements again..*/
		System.out.println("Displaying after enqueuing one element again..");
		dynamicQueue.show();
		System.out.println("Queue capacity: "+dynamicQueue.getQueueCapacity());
		
		System.out.println("Dequeuing: "+dynamicQueue.dequeue());
		System.out.println("Dequeuing: "+dynamicQueue.dequeue());
		dynamicQueue.show();
		
	}
}
