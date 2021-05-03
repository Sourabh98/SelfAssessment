package resources;

public class Rectangle {
	
	private int length;
	private int breadth;
	private int area;
	
	
	public void setLength(int length) {
		this.length = length;
	}
	 
	
	public int getLength()
	{
		return length;
	}
	
	public void setBreadth(int breadth)
	{
		this.breadth=breadth;
	}
	
	public int getBreadth()
	{
		return breadth;
	}
	
	public void calculateArea()
	{
		area=length*breadth;
	}
	
	public int getArea()
	{
		return area;
	}

}
