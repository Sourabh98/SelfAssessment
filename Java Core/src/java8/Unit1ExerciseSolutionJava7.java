package java8;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Unit1ExerciseSolutionJava7 {

	public static void main(String[] args) {

		List<Person> people = Arrays.asList(new Person("Sourabh", "Chauhan", 30), new Person("Gaurav", "Singh", 25),
				new Person("Vinay", "Rajput", 15), new Person("Deepu", "Gadha", 13), new Person("Ajju", "Mota", 11));
//Sorting list on the basis of last name
		Collections.sort(people, new Comparator<Person>() {
			@Override
			public int compare(Person p1, Person p2) {
				return p1.getLastName().compareTo(p2.getLastName());
			}
		});

		System.out.println("----------------Printing all people........");
		printAll(people);

		System.out.println("Printing persons conditionally-----------------------------------------------------");
		// now we wanted to print the names whose last name starts with C only
		/* printPersonNameBeginsWithC(people); */

		// System.out.println("----------------Printing name
		// conditionally---------------------");
		// here creating a anonymous inner class..
		printConditionally(people, new Condition() {
			@Override
			public boolean test(Person p) {
				return p.getLastName().startsWith("C");
			}
		});

		System.out.println("-----------This will print the persons whose last name starts with S------------");
		printConditionally(people, new Condition() {
			@Override
			public boolean test(Person p) {
				return p.getLastName().startsWith("S");
			}
		});

	}

	// this will print all the elements in the people list
	public static void printAll(List<Person> people) {
		for (Person person : people) {
			System.out.println(person);

		}
	}

	/*
	 * public static void printPersonNameBeginsWithC(List<Person> people) {
	 * for(Person p: people) { if(p.getLastName().startsWith("C")) {
	 * System.out.println(p); } } }
	 */

	public static void printConditionally(List<Person> people, Condition condition) {
		for (Person p : people) {
			if (condition.test(p))
				System.out.println(p);
		}
	}

	/*
	 * //This is a nested inner interface and they are static by default and can
	 * only be referred with the help of outer class
	 */
	public interface Condition {
		boolean test(Person p);
	}

}
