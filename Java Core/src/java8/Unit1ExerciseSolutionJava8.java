package java8;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.function.*;

public class Unit1ExerciseSolutionJava8 {

	public static void main(String[] args) {

		List<Person> people = Arrays.asList(new Person("Sourabh", "Chauhan", 30), new Person("Gaurav", "Singh", 25),
				new Person("Vinay", "Rajput", 15), new Person("Deepu", "Gadha", 13), new Person("Ajju", "Mota", 11));
		/*
		 * Sorting list on the basis of last name, so now instead of creating the
		 * anonymous inner class we will use the lambda expression for the same as the
		 * Comparator interface have only one abstract method so that makes it a
		 * Functional interface hence we can create the lambda expression for this, we
		 * don't need to give the type of the arguments here, compiler will
		 * automatically figure it out on the basis of the mapping of lambda expression
		 * to the method defined in the comparator interface so either we can write it
		 * below or can write the statement as the next block both performs the same
		 * action i.e. will sort the elements on the basis of the last name.
		 */
		Collections.sort(people, (Object o1, Object o2) -> {
			Person p1 = (Person) o1;
			Person p2 = (Person) o2;
			return p1.getLastName().compareTo(p2.getLastName());

		});
		/*Sorting the list elements on the basis of the Person's last name*/
		Collections.sort(people, (p1, p2) -> p1.getLastName().compareTo(p2.getLastName()));

		System.out.println("----------------Printing all people........");
		/*when we want to print all the elements we will have to return true from the test method which is mapped to the lambda expression, so the below method will print all the elements in the list*/
		printConditionally(people, p -> true);
		//printAll(people);

		System.out.println("------------------------------Printing persons last name Starts with C-----------------------------------------------------");
		/*
		 * //Creating a lambda expression instead of anonymous inner class like we did
		 * in java 7 this will print the Persons whose last name starts with C
		 */ 
		printConditionally(people, p -> p.getLastName().startsWith("C"));
		/*this will print the Persons whose last name starts with S*/
		System.out.println("-----------This will print the persons whose last name starts with S------------");
		printConditionally(people, p -> p.getLastName().startsWith("S"));
		
		
		System.out.println("------------------------------------------------Now Performing conditionally-------------------------------------");
		performConditionally(people,p->true,p->System.out.println(p.getFirstName()));
		performConditionally(people,p->p.getLastName().startsWith("C"),p->System.out.println(p));
		performConditionally(people,p->p.getLastName().startsWith("S"),p->System.out.println(p.getFirstName()));

	}

	/*
	 * // this will print all the elements in the people list public static void, we are removing this method as we will use printConditionally method to print all the elements
	 * printAll(List<Person> people) { for (Person person : people) {
	 * System.out.println(person);
	 * 
	 * } }
	 */

	/*
	 *
	 * /*public static void printConditionally(List<Person> people, Condition condition) {
		for (Person p : people) {
			if (condition.test(p))
				System.out.println(p);
		}
	}*/
	
	/* 
	 *  Now instead of Condition Interface which we have created we can also use the
	 * Functional Interfaces which are defined by the Java designers for such common
	 * scenarios so the interface which we can use here is Predicate which have only one abstract method similar to the Condition Interface
	 */
	public static void printConditionally(List<Person> people, Predicate<Person> predicate) {
		for (Person p : people) {
			if (predicate.test(p))
				System.out.println(p);
		}
	}
	
	/*Now in the above method we are printing on the console every time now if we want to print somewhere else then we need to make changes in the method itself and let's say 
	 * if i want to print at different places when invoking this method then we need to define different methods so to avoid this we will pass the action to this method what to print and where
	 * instead of writing the Syso in the method itself, there is a Functional Interface Consumer which is provided by the Java Designers which have the abstract method which takes the single 
	 * argument and returns void so we can use that here for defining the lambda expression. */
	
	public static void performConditionally(List<Person> people, Predicate<Person> predicate, Consumer<Person> consumer)
	{
		for(Person p: people)
		{
			if(predicate.test(p))
				consumer.accept(p);
		}
	}
	

}
