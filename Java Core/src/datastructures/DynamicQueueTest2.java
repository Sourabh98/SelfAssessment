package datastructures;

public class DynamicQueueTest2 {
	
	public static void main(String[] args) {
		
		/*
		 * Input parameters: 
		 * Test 2 
		 * Initial size : 2
		 * Will enqueue three elements then
		 * will check the queueCapacity
		 * Output: should get doubled i.e. 4 then
		 * dequeue 1 element the queueCapacity should become 2 again as the number of the elements are 2 so the queuecapacity will get doubled 
		 * when we will add like 3 then it would be 4, if we will add 5
		 * then it would be 8 and will decrease in the same way
		 * 
		 */
		
		DynamicQueue<Integer> dynamicQueue = new DynamicQueue<Integer>();
		System.out.println("Queue Capacity: "+dynamicQueue.getQueueCapacity());
		dynamicQueue.enqueue(5);
		dynamicQueue.enqueue(10);
		dynamicQueue.show();
		dynamicQueue.enqueue(15);
		System.out.println("Queue capacity: "+dynamicQueue.getQueueCapacity());
		dynamicQueue.show();
		System.out.println("Dequeuing: "+dynamicQueue.dequeue());
		
		System.out.println("Queue capacity: "+dynamicQueue.getQueueCapacity());
	}

}
