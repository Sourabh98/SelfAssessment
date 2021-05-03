package entity;

/*This class is to represent orders*/
public class Order {

	private int id;
	private String desc;
	private int amount;
	private String status;
	
	/*this is for using constructor injection*/
	private Order(int id, String desc, int amount, String status)
	{
		this.id=id;
		this.desc=desc;
		this.amount=amount;
		this.status=status;
	}
	
	public int getId()
	{
		return id;
	}
	
	public String getDesc()
	{
		return desc;
	}
	
	public int getAmount()
	{
		return amount;
	}
	
	public String getStatus()
	{
		return status;
	}
	
	/*This method is to print the decscription of the product*/
	public String toString()
	{
		return id+"\t"+desc+"\t"+amount+"\t"+status;
	}
}
