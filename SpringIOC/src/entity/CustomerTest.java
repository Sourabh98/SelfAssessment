package entity;

import org.springframework.beans.factory.BeanFactory;

import iocContainer.MyFactory;

public class CustomerTest {
	
	public static void main(String[] args) {
		
		System.out.println("Asking container to create the customer bean and the container will fullfill all the dependencies: ");
		BeanFactory beanFactory=MyFactory.getIocContainer();
		System.out.println("Dependencies will be injected through constructor injection..");
		Customer customer1=(Customer)beanFactory.getBean("customer1");
		System.out.println(customer1);
		System.out.println("Dependencies will be injected through setter method injection..");
		beanFactory.getBean("customer2");
		Customer customer2=(Customer)beanFactory.getBean("customer2");
		System.out.println(customer2);
	}

}
