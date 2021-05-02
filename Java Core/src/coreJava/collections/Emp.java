package coreJava.collections;

public class Emp implements Comparable<Emp>{
	
	private String empName;
	private String empJob;
	private int salary;
	public Emp(String empName, String empJob, int salary)
	{
		super();
		this.empName=empName;
		this.empJob=empJob;
		this.salary=salary;
	}
	
	public String getEmpName()
	{
		return this.empName;
	}
	
	public String getEmpJob()
	{
		return this.empJob;
	}
	
	public int getSalary()
	{
		return this.salary;
	}
	
	public String display()
	{
		return empName+"\t"+empJob+"\t"+salary;
		//System.out.println(empName+"\t"+empJob+"\t"+salary);
	}
	
	@Override
	public boolean equals(Object o)
	{
		Emp emp=(Emp)o;
		return this.empName.equalsIgnoreCase(emp.empName)&&this.empJob.equalsIgnoreCase(emp.empJob)&&this.salary==emp.salary;
	}
	
	/*
	 * public int hashCode() { return
	 * this.empName.hashCode()+this.empJob.hashCode()+this.salary; }
	 */
	
	/*This will compare on the basis of the emp name */
	@Override
	public int compareTo(Emp e1)
	{
		return this.empName.compareTo(e1.empName);
	}

}
