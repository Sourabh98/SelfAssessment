package coreJava.collections;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.ListIterator;

public class ListTest {

	public static void main(String[] args) {

		ArrayList<String> myList = new ArrayList<String>();

		myList.add("First");
		myList.add("third");
		myList.add(1, "Second");
		myList.add("Fifth");
		myList.add(3, "Fourth");

		System.out.println("Number of elements in the list " + myList.size());

		System.out.println("Iterating the elements using the collection iterator..");
		Iterator<String> iterator = myList.iterator();
		while (iterator.hasNext()) {
			String str = iterator.next();
			System.out.println(str);
		}

		System.out.println("Iterating using the for each loop..");
		for (String str : myList) {
			System.out.println(str);
		}

		ListIterator<String> listIterator = myList.listIterator();
		System.out.println("Iterating in forward direction using the list iterator..");
		while (listIterator.hasNext()) {
			System.out.println(listIterator.next());
		}
		/*
		 * To iterate the elements in the reverse direction first you will have to set
		 * the pointer at the last element in the list so you can traverse in the
		 * reverse order the one way we did it by using the above code where we are
		 * using hasNext to shift the pointer to the next position. Have to find the
		 * other ways to do this..
		 */
		System.out.println("Ietrating using the list Iterator..");
		System.out.println("Iterating in the reverse direction...");
		while (listIterator.hasPrevious()) {
			System.out.println(listIterator.previous());
		}

		System.out.println("Searchin for an element in the list....");
		if (myList.contains("Second"))
			System.out.println("Second found in the list..");
		else
			System.out.println("Item not found in the list...");
		System.out.println("Removing the elements from the list...");
		myList.remove("Second");
		System.out.println("Size of list after removing the element from the list " + myList.size());

	}

}
