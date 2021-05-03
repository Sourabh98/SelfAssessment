package entity;

import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSeeAlso;

@XmlRootElement
@XmlSeeAlso(Employee.class)
public class EmployeeList {
	
	private List<Employee> employee;
	public void setEmployeeList(List<Employee> employee)
	{
		this.employee=employee;
	}

	@XmlElement
	public List<Employee> getEmployeeList()
	{
		return employee;
	}
}
