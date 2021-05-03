package entity;

import java.util.Iterator;
import java.util.Set;

/*This class is for the customer which is going to place the orders..So a customer can place multiple orders but no orders can be repeated so we would be using the sets in this case.*/
public class Customer {
	
	private String customerName;
	private Set<Order> orders;
	
	
	public Customer()
	{
		super();
		System.out.println("Dependency injecting through setter..");
	}
	public Customer(String customerName, Set<Order> orders)
	{
		System.out.println("Dependency injecting through constructor..");
		this.customerName=customerName;
		this.orders=orders;
	}
	
	public void setOrders(Set<Order> orders)
	{
		System.out.println("Dependency injecting through setter..");
		this.orders=orders;
	}
	
	public Set<Order> getOrders()
	{
		return orders;
	}

	public void setCustomerName(String customerName)
	{
		this.customerName=customerName;
	}
	
	public String getCustomerName()
	{
		return customerName;
	}
	
	public String toString()
	{
		StringBuilder stb=new StringBuilder();
		System.out.println("Iterating the orders for a customer with the name:"+getCustomerName());
		Iterator<Order> iterator=orders.iterator();
		while(iterator.hasNext())
		{
			System.out.println(iterator.next());
		}
		return stb.toString();
	}
}
