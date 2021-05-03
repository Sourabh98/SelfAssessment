package entity;

import org.springframework.beans.factory.BeanNameAware;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

public class B implements BeanNameAware, InitializingBean, DisposableBean{
	
	private String name;
	private A a;
	
	public void setA(A a)
	{
		this.a=a;
	}
	
	public A getA()
	{
		return a;
	}
	public void setBeanName(String name)
	{
		this.name=name;
	}
	
	public String getName()
	{
		return name;
	}

	public void afterPropertiesSet()
	{
		System.out.println(name+" bean is initialised programatically.");
	}
	
	public void postCreate()
	{
		System.out.println(name+" bean is initialised declaratively..");
	}
	public void destroy()
	{
		System.out.println(name+" Bean is destroyed programatically.");
	}
	
	public void preDestroy()
	{
		System.out.println(name+" bean is cleaned up declaratively..");
	}
	
}
