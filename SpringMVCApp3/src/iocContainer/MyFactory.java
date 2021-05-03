package iocContainer;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MyFactory {

	
	public static ApplicationContext ctx;
	
	static
	{
		ctx=new ClassPathXmlApplicationContext("applicationContext.xml");
	}
	
	public static ApplicationContext getBeanFactory()
	{
		return ctx;
	}
}
