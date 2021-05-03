package entity;

import org.springframework.beans.factory.xml.XmlBeanFactory;

import iocContainer.MyFactory;

public class User3 {
	
	public static void main(String[] args) {
		
		XmlBeanFactory xmlBeanFactory=(XmlBeanFactory)MyFactory.getIocContainer();
		
		System.out.println("Requesting B1 bean..");
		B b1=(B)xmlBeanFactory.getBean("b1");
		System.out.println("Requesting b2 bean....");
		B b2=(B)xmlBeanFactory.getBean("b2");
		
		System.out.println("getting b1 and b2 bean destroyed...");
		xmlBeanFactory.destroySingletons();
		System.out.println("App completed...");
	}

}
