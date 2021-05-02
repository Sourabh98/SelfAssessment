package datastructures;

import java.util.Scanner;

public class DynamicQueue<T> {

	/*
	 * This variable will always point to the front of the queue irrespective of the
	 * index..i.e. will always store the index of the first element in the queue
	 */
	private int front;
	/*
	 * Below variable will always point to the last element of the queue
	 * irrespective of the queue size and the index..will always store the index of
	 * the last element..
	 */
	private int rear;

	/* This variable will be used to store the current capacity of the queue.. */
	private int queueCapacity;
	/* This array will represent the queue.. */
	private T[] queue;

	/* This variable will give the exact number of elements in the queue; */
	private int size;

	@SuppressWarnings("unchecked")
	public DynamicQueue() {
		System.out.println("Give the initial queue size:");
		Scanner sc = new Scanner(System.in);
		queueCapacity = sc.nextInt();
		queue = (T[]) new Object[queueCapacity];
		sc.close();
	}

	public void enqueue(T o) {
		/*
		 * Now as we are making a dynamic array so before adding the element we will
		 * have to check if we have the space for adding the element in the queue i.e.
		 * if it is full and as we are working on the circular queue so we will have to
		 * work in that way else we will invoke the expandQueue function
		 * 
		 * When we will enqueue it only the rear will change and front will remains the
		 * same Just a note modulus is used for making a circular array you can see by
		 * yourself as well after the array will be finished you will get the index of
		 * the first element
		 * 1%5=1
		   2%5=2
		   3%5=3
		   4%5=4
		   5%5=0
		 */
		if (!isFull()) {
			queue[rear] = o;
			rear = (rear + 1) % queueCapacity;
			size++;
		}

		else {
			expandQueue();
			queue[rear] = o;
			rear = (rear + 1) % queueCapacity;
			size++;

		}

	}

	public T dequeue() {

		/*
		 * first check would be for empty queue while dequeuing only front pointer and
		 * the size will changes..
		 */
		if (!isEmpty()) {
			T data = queue[front];
			front = (front + 1) % queueCapacity;
			size--;
			if (size * 2 < queueCapacity)

				shrinkQueue();
			return data;

		} else {
			System.out.println("Queue is empty..");
			return null;
		}
	}

	/*Need to look bit more but will see later....*/
	@SuppressWarnings("unchecked")
	private void expandQueue() {

		T[] tempQueue = queue;
		queueCapacity = queueCapacity * 2;
		queue = (T[]) new Object[queueCapacity];
		System.arraycopy(tempQueue, 0, queue, 0, (rear+1)%queueCapacity);

	}

	public boolean isFull() {
		return size() == queueCapacity;
	}

	public int size() {
		return size;
	}

	public boolean isEmpty() {
		return size() == 0;
	}

	public void show() {
		System.out.print("Elements: ");
		for (int i = 0; i < size; i++) {
			System.out.print(queue[(front + i)%queueCapacity]+" ");
		}
		System.out.println();
	}

	@SuppressWarnings("unchecked")
	private void shrinkQueue() {
		T[] tempQueue = queue;
		queueCapacity = queueCapacity / 2;
		queue = (T[]) new Object[queueCapacity];
		System.arraycopy(tempQueue, 0, queue, 0, rear);
	}
	
	public int getQueueCapacity()
	{
		return queueCapacity;
	}
}
