package empConsoleClient;

import java.net.URI;
import java.util.Scanner;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriBuilder;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.config.ClientConfig;
import com.sun.jersey.api.client.config.DefaultClientConfig;

import entity.Employee;

public class EmpUpdator {
	
	public static void main(String[] args) {
		
		System.out.println("Preparing client....");
		ClientConfig config=new DefaultClientConfig();
		Client client=Client.create(config);
		WebResource resource=client.resource(getBaseUri());
		/*First we are going to load the client on the basis of the input id from the user*/
		System.out.println("Enter the emp id:");
		Scanner sc=new Scanner(System.in);
		int id=sc.nextInt();
		sc.nextLine();
		Employee emp=resource.path(Integer.toString(id)).accept(MediaType.APPLICATION_JSON).get(Employee.class);
		System.out.println("Current Employee Details..");
		System.out.println("Employee ID\tEmployee Name\tEmployee Job\tEmployee Salary");
		System.out.println(emp.getEmpId()+"\t"+emp.getEmpName()+"\t"+emp.getEmpJob()+"\t"+emp.getEmpSalary());
		System.out.println("Enter new Name:");
		emp.setempName(sc.nextLine());
		System.out.println("Enter new Job:");
		emp.setEmpJob(sc.nextLine());
		System.out.println("Enter Salary:");
		emp.setEmpSalary(sc.nextInt());
		System.out.println("Updating Emp:");
		
		String response=resource.type(MediaType.APPLICATION_JSON).put(String.class,emp);
		System.out.println(response);
		sc.close();
	}
	
	private static URI getBaseUri()
	{
		return UriBuilder.fromUri("http://localhost:8080/EmpRestServices/rest/empService").build();
	}

}
