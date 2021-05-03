package entity;

public class User {
	
	
	/*This class object will get persisted to the DB*/
	/*This id will be auto generated in the db when we will try to persist some record in DB, now if it is auto generated in DB while we need to keep it here*/
	private int id;
	private String userName, mailId, password;
	
	public void setUserName(String userName)
	{
		this.userName=userName;
	}
	
	public String getUserName()
	{
		return userName;
	}
	
	public void setMailId(String mailId)
	{
		this.mailId=mailId;
	}
	
	public String getMailId()
	{
		return mailId;
	}
	
	public void setPassword(String password)
	{
		this.password=password;
	}
	
	public String getPassword()
	{
		return password;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

}
