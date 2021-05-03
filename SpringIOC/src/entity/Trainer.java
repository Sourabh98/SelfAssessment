package entity;

import java.util.Iterator;
import java.util.List;

/*Trainer class with the two variables name of the Trainer and the batches that Trainer teaches.*/
public class Trainer {
	
	private String name;
	private List<String> batches;
	
	public void setName(String name)
	{
		this.name=name;
	}

	public String getName()
	{
		return name;
	}
	
	public void setBatches(List<String> batches)
	{
		this.batches=batches;
	}
	
	public String toString()
	{
		/*So here we are using the String Buffer for creating the mutuable String and returning the String Object with multiple values in it. so whatever would be there in this String builder will get 
		 * printed on the console*/
		StringBuilder stb=new StringBuilder();
		stb.append("Name:").append(name);
		stb.append("\n").append("Batch Details: \n");
		Iterator<String> batchIterator=batches.iterator();
		while(batchIterator.hasNext())
		{
			stb.append(batchIterator.next()).append("\n");
		}
		return stb.toString();
	}
}
