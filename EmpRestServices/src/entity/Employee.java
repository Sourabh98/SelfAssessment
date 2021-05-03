package entity;

import javax.xml.bind.annotation.*;

@XmlRootElement
@XmlType(propOrder= {"empId","empName","empJob","empSalary"})
public class Employee {
	
	private int empId;
	private String empName;
	private String empJob;
	private int empSalary;
	
	public void setEmpId(int empId)
	{
		this.empId=empId;
	}
	
	/*This annotation uses to represent each empid in the XML form*/
	@XmlElement
	public int getEmpId()
	{
		return empId;
	}
	
	public void setempName(String empName)
	{
		this.empName=empName;
	}
	
	@XmlElement
	public String getEmpName()
	{
		return empName;
	}

	public void setEmpJob(String empJob)
	{
		this.empJob=empJob;
	}
	
	@XmlElement
	public String getEmpJob()
	{
		return empJob;
	}
	
	public void setEmpSalary(int empSalary)
	{
		this.empSalary=empSalary;
	}
	
	@XmlElement
	public int getEmpSalary()
	{
		return empSalary;
	}
}
