package resources;



import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import dao.EmpDao;
import entity.Employee;
import entity.EmployeeList;

@Path("/empService")
public class EmpService {

	private final EmpDao dao;
	
	/*An object of the EmpService is created by the the interceptor servlet when the request will come for this service using the default contructor as we didn't define any dependency for this service
	 * in the XML and when it will call the contsructor we are gonna create the dao object at thh same time*/
	public EmpService()
	{
		dao=new EmpDao();
	}
	/*This method is when request data comes in the XML format*/
	@POST
	@Consumes(value= {MediaType.APPLICATION_XML})
	@Produces(value= {MediaType.TEXT_PLAIN})
	public String saveEmployeeXml(Employee emp)
	{
		try
		{
			dao.saveEmployee(emp);
			System.out.println("Emp saved by save() method i.e. in XML Format.");
			return "Successfully Saved";
		}
		catch(Exception e)
		{
			return e.getMessage();
		}
	}
	
	
	@POST
	@Consumes(value= {MediaType.APPLICATION_JSON})
	@Produces(value= {MediaType.TEXT_PLAIN})
	public String saveEmployee(Employee emp)
	{
		EmpDao dao=new EmpDao();
		try
		{
		dao.saveEmployee(emp);
		System.out.println("Emp saved by save() method i.e. in JSON Format.");
		return "Successfully Saved";
		}
		catch(Exception e)
		{
			return e.getMessage();
		}
		
	}
	@Path("/id")
	@GET
	@Produces(value= {MediaType.APPLICATION_JSON})
	public Employee getEmployeeById(@PathParam("id")int id)
	{
		EmpDao dao=new EmpDao();
		Employee emp=null;
		try
		{
			 emp= dao.getEmployeeById(id);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return emp;
	}
	
	@GET
	@Produces(value= {MediaType.APPLICATION_JSON})
	public EmployeeList getAllEmployees()
	{
		EmpDao dao=new EmpDao();
		EmployeeList empList=new EmployeeList();
		try
		{
			
			empList.setEmployeeList(dao.getAllEmployees());
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return empList;
	}
	
	
	@DELETE
	@Produces(value= {MediaType.TEXT_PLAIN})
	public String deleteAllEmployees()
	{
		EmpDao dao=new EmpDao();
		try
		{
			if(dao.deleteAllEmployees())
			return "Sucessfully Deleted";
			else
			return "Can't be deleted";
			
		}
		catch(Exception e)
		{
			return e.getMessage();
		}
	}
	
	@Path("/id")
	@DELETE
	@Produces(value= {MediaType.TEXT_PLAIN})
	public String deleteEmployee(@QueryParam("id") int id)
	{
		EmpDao dao=new EmpDao();
		try
		{
			dao.deleteEmployee(id);
			return "Successfully Deleted.";
		}
		catch(Exception e)
		{
			return e.getMessage();
		}
		
		
	}
	
	@PUT
	@Consumes(value= {MediaType.APPLICATION_JSON})
	@Produces(value= {MediaType.TEXT_PLAIN})
	public String updateEmployee(Employee emp)
	{
		try
		{
			dao.updateEmployee(emp);
			return "Successfully updated.";
		}
		catch(Exception e)
		{
			return e.getMessage();
		}
	}
	
}
