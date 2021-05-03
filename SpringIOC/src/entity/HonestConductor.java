package entity;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;

public class HonestConductor extends Conductor implements BeanFactoryAware {

	
	private BeanFactory factory;
	@Override
	public Ticket getTicket()
	{
		return (Ticket)factory.getBean("tic");
	}

	@Override
	public void setBeanFactory(BeanFactory factory) throws BeansException {
		this.factory=factory;
		
	}
	
}
