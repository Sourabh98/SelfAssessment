package java8;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class StreamExample {
	
	public static void main(String[] args) {
		
		List<Person> people= Arrays.asList(
				new Person("Sourabh","Chauhan",11),
				new Person("Gaurav","Singh",23),
				new Person("Vinay","Kumar",15),
				new Person("Deepu","Rajput",15));
		
		people.stream()
		.filter(p->p.getLastName().startsWith("C"))
		.forEach(p->System.out.println(p.getFirstName()));
		
		/*Filters is one of the different mechanic which is working on the conveyor belt and the conveyor belt is the stream, we can apply different different operations on the stream*/
		  Stream<Person>
		  persons=people.stream().filter(p->p.getLastName().startsWith("C"));
		 
		/*This will give the parallel stream which helps in parallel processing and can use multiple cores if required.*/
		  Stream<Person> parallelStream=people.parallelStream();
		 System.out.println("From parallel stream: "+parallelStream.filter(p->p.getLastName().startsWith("S")).count()); 
		 
		/*This is the terminal operation or the end operation, so this will make the stream executed.*/
		System.out.println( persons.count()); 
	
	}

}
