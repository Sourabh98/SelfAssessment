package datastructures;

import java.util.Scanner;

public class MyQueue<T> {

	private int queueCapacity;
	private T[] queue;
	/*
	 * This will always point to the index of the first element in the queue, the
	 * value of this counter will change when you will delete the element from the
	 * queue.
	 */
	private int front;
	/*
	 * This will always point to the last element index in the queue, value of this
	 * counter will change when you will insert the element in the queue and delete
	 * the element from the queue
	 */
	private int rear;
	/*
	 * The java.lang.Class class instance represent classes and interfaces in a
	 * running Java application.It has no public constructor.
	 */
	
	/*This will represent the number of elements in the queue..*/
	private int size;

	@SuppressWarnings("unchecked")
	public MyQueue() {
		System.out.println("Provide the queue capacity..");
		Scanner sc = new Scanner(System.in);
		queueCapacity = sc.nextInt();
		queue = (T[]) new Object[queueCapacity];
		sc.close();
	}

	/* This method will insert the element in the queue */
	public void enqueue(T o) {
		/* as you would be inserting the element at last the index */
		queue[rear] = o;
		rear++;
		size=rear;
	}

	/*
	 * When you will invoke this method this will always remove the first element
	 * from the queue or we can say this will remove the element the element in FIFO
	 * order and will shift the whole array
	 */
	public T dequeue() {
		T frontElement = queue[front];
		for (int i = 0; i < queue.length - 1; i++) {
			queue[i] = queue[i + 1];
		}
		if (rear != 0)

		{
			queue[rear - 1] = null;
			rear--;
		}
		size=rear;
		return frontElement;
	}

	public void show() {
		for (T o : queue) {
			System.out.println(o);
		}
	}

	public int size() {
		return size;
	}
	
	public int queueCapacity()
	{
		return queueCapacity;
	}
}
