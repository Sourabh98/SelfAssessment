package entity;

import org.springframework.beans.factory.BeanFactory;

import iocContainer.MyFactory;

public class User {

	
	public static void main(String[] args) {
		System.out.println("Requesting two beans from the IOC container..");
		
		BeanFactory iocContainer=MyFactory.getIocContainer();
		System.out.println("Getting the bean from the IOC container..");
		Number n1=(Number)iocContainer.getBean("num1");
		Number n2=(Number)iocContainer.getBean("num2");
		System.out.println("Displaying first Number: ");
		n1.display();
		System.out.println("Displaying second number: ");
		n2.display();
		System.out.println("Adding the numbers and displaying them:");
		n1.add(n2).display();
		
		System.out.println("Now creating the objects using the static factory methods defined in the same class..");
		System.out.println("creating the rational 2 bean and invoking the add method on it..");
		Rational2 rational2_1=(Rational2)MyFactory.getIocContainer().getBean("rational2");
		rational2_1.setP(10);
		rational2_1.setQ(15);
		/*When you will ask for the singleton scope bean again from the IOC container it won't even execute the static factory method which we have defined in the class and will return the last reference*/
		Rational2 rational2_2=(Rational2)MyFactory.getIocContainer().getBean("rational2");
		System.out.println("hashcode for rational2_1 : "+rational2_1.hashCode()+" hashcode for rational2_2: "+rational2_2.hashCode());
		System.out.println("Checking equality"+rational2_2.equals(rational2_1));
		System.out.println("Displaying the first number..");
		rational2_1.display();
		System.out.println("Displaying the second number..");
		rational2_2.display();
		System.out.println("Now adding both these numbers and displaying them...");
		rational2_1.add(rational2_2).display();
		
		System.out.println("Now we are asking bean of type Compex2 from the IOC container..the scope of this bean we are setting as prototype");
		System.out.println("Asking IOC conatiner to create the bean on the basis of the static factor method defined in the same class..");
		Complex2 complex_1=(Complex2)MyFactory.getIocContainer().getBean("complex2");
		System.out.println("hashcode of the returned bean from the IOC container: "+complex_1.hashCode());
		System.out.println("Asking again IOC conatiner for Complex2 instance..");
		Complex2 complex_2=(Complex2)MyFactory.getIocContainer().getBean("complex2");
		System.out.println("hashcode of the second complex2 instance: "+complex_2.hashCode());
		System.out.println("Adding both these numbers: \n First Number");
		complex_1.display();
		System.out.println("Second Number: ");
		complex_2.display();
		System.out.println("Result after adding numbers: ");
		complex_1.add(complex_2).display();
		
	}
}
