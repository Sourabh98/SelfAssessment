package iocContainer;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

public class MyFactory {
	
	
	private static BeanFactory iocContainer;
	static
	{
		/*Here we are using the ClassPathResource class which implements the Resource Interface, class path resource is used when we provides the relative path instead of the exact path when we know the
		 * exact path then in that case we can also use FilePathResource*/
		Resource resource=new ClassPathResource("applicationContext.xml");
		/*XmlBeanFactory is one of the implementation of the IOC container this XmlBeanFactory provides the implementation of the BeanFactory Interface*/
		iocContainer=new XmlBeanFactory(resource);
	}

	public static BeanFactory getIocContainer()
	{
		return iocContainer;
	}
}
