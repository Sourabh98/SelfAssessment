package entity;

import org.springframework.beans.factory.BeanFactory;

import iocContainer.MyFactory;

public class ListTest {
	
	public static void main(String[] args) {
		
		BeanFactory factory=MyFactory.getIocContainer();
		/*Doing explicit typecasting here as we know the getBean return type is Object so we would be needing to type cast it to the Trainer so that we can access the attributes and methods of Trainer 
		 * class.*/
		Trainer trainer=(Trainer)factory.getBean("trainer");
		System.out.println("Trainer details");
		System.out.println(trainer);
	}

}

