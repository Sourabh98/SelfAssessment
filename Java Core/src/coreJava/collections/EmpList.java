package coreJava.collections;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.ListIterator;

public class EmpList {

	public static void main(String[] args) {
		/* List based collections maintains the insertion order.. */
		ArrayList<Emp> empList = new ArrayList<Emp>();
		System.out.println("Creating list of emp type...");
		empList.add(new Emp("A", "B", 10000));
		empList.add(new Emp("C", "D", 20000));
		empList.add(new Emp("E", "F", 30000));
		empList.add(new Emp("G", "H", 50000));
		empList.add(new Emp("I", "J", 60000));

		int size = empList.size();
		System.out.println("Size of the list is " + size);
		System.out.println("Traversig all the elemenest of Emp List using collection iterator..");
		Iterator<Emp> empIterator = empList.iterator();
		while (empIterator.hasNext()) {
			/*
			 * Here i have used the generic type while creating the Iterator so i don't have
			 * to type cast here but if i have used the normal Iterator then in that case i
			 * would have to type cast it here like Emp emp=(Emp)empIterator.next(); this is
			 * because the return type of the next method is object and we know we tries to
			 * store the reference of the Parent class instance to child reference we will
			 * have to do the explicit type casting..
			 */
			Emp emp = empIterator.next();
			emp.display();
		}
		System.out.println(
				"Traversig all the elemenest of Emp List using collection listiterator in reverse order from the last element..");
		ListIterator listIterator = empList.listIterator(size);
		while (listIterator.hasPrevious()) {
			Emp emp = (Emp) listIterator.previous();
			emp.display();
		}

		System.out.println("Traversig all the elemenest of Emp List using for each loop..");
		for (Emp emp : empList) {
			emp.display();
		}

		System.out.println("Searching for an emelemnt in the list if found then will remove it..");
		Emp e1 = new Emp("A", "B", 10000);
		e1.display();
		/*
		 * Search and remove internally calls equals method to check if the elements we
		 * wanted search present in the list in this case the reference of the object
		 * and the object which we passed in the list is different so here we wanted to
		 * search the element on the basis of the object property not on the basis of
		 * reference so will have to override the equals method which should return true
		 * if the object properties are same
		 */
		if (empList.contains(e1)) {
			System.out.println("Found..");
			System.out.println("Removing the found object..");
			empList.remove(e1);
		} else
			System.out.println("Not found..");

		System.out.println("Iterating the list to check if items has been removed..");
		for (Emp emp : empList) {
			emp.display();
		}

	}

}
