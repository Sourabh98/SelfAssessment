package java8;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;

public class MethodReferenceExample2 {
	
	public static void main(String[] args) {
		
		List<Person> people=Arrays.asList(
				new Person("Sourabh", "Chauhan", 12),
				new Person("Gaurav","Chauhan",20),
				new Person("Ramu","Sharma",45),
				new Person("Shyam","Sharma",50));
		
		/* performConditionally(people,p->true,p->System.out.println(p)); */
		/*
		 * //Below is the method reference syntax when you try to invoke the
		 * parameterised method and instead of using lambda expression you uses method
		 * reference, as we know method reference is just a pass through mechanism in the last example we invoked the static method and as we know we can invoke the static method using ClassName.MethodName
		 * so for that method reference syntax was simple as well but here we are invoking the instance method println and the static variable which stores reference of the instance is out of System class
		 * now the catch here is how it will know with which parameter method is going to get invoked now if we will go back then we know the lambda expression which we passed to the method is mapped to 
		 * Interface which is passed as parameter in that method(in our case the method is performConditionally) and then looks for the abstract method in that interface which matches the lambda expression 
		 * and when we invoke that method our lambda expression gets executed. So here as well when we invoke the accept method of the consumer with an argument(this is the abstract method which is 
		 * matching with our lambda expression or to the method reference syntax) it will get to know with what parameter println method needs to be invoked and will pass that as an argument to the 
		 * println method.
		 */		performConditionally(people,p->true,System.out::println);
	}
	
	private static void performConditionally(List<Person> people,Predicate<Person> predicate, Consumer<Person> consumer)
	{
		for(Person person: people)
		{
			if(predicate.test(person))
				consumer.accept(person);
		}
	}
}
