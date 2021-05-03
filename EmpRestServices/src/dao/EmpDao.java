package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import entity.Employee;

public class EmpDao {
	
	ConnectionProvider connectionProvider=new ConnectionProvider();
	
	public List<Employee> getAllEmployees() throws Exception
	{
		List<Employee> empList=new ArrayList<Employee>();
		Connection con=connectionProvider.getConnection();
		Statement stmnt=con.createStatement();
		ResultSet rSet=stmnt.executeQuery("Select * from Employee");
		while(rSet.next())
		{
			empList.add(mapRecord(rSet));
		}
		con.close();
		return empList;
	}
	
	public Employee mapRecord(ResultSet rSet) throws Exception
	{
		Employee emp=new Employee();
		emp.setEmpId(rSet.getInt(1));
		emp.setempName(rSet.getString(2));
		emp.setEmpJob(rSet.getString(3));
		emp.setEmpSalary(rSet.getInt(4));
		return emp;
	}
	
	public void saveEmployee(Employee emp) throws Exception
	{
		Connection con=connectionProvider.getConnection();
		PreparedStatement prepStmnt=con.prepareStatement("Insert into Employee(employee_name,employee_job,employee_salary) values (?,?,?)");
		prepStmnt.setString(1, emp.getEmpName());
		prepStmnt.setString(2, emp.getEmpJob());
		prepStmnt.setInt(3, emp.getEmpSalary());
		prepStmnt.executeUpdate();
		con.close();
		
	}

	public void deleteEmployee(int empId) throws Exception
	{
		Connection con=connectionProvider.getConnection();
		PreparedStatement prepStmnt=con.prepareStatement("delete from Employee where employee_id=?");
		prepStmnt.setInt(1, empId);
		prepStmnt.executeUpdate();
		con.close();
	}
	
	public boolean deleteAllEmployees() throws Exception
	{
		Connection con=connectionProvider.getConnection();
		Statement stmnt=con.createStatement();
		boolean isDeleted=stmnt.execute("delete from Employee");
		con.close();
		return isDeleted;
		
	}
	
	public Employee getEmployeeById(int id) throws Exception
	{
		Connection con=connectionProvider.getConnection();
		PreparedStatement prepStmnt=con.prepareStatement("Select from Employee where employee_id=?");
		prepStmnt.setInt(1, id);
		ResultSet rSet=prepStmnt.executeQuery();
		con.close();
		return mapRecord(rSet);
	}
	
	public void updateEmployee(Employee emp) throws Exception
	{
	
		Connection con=connectionProvider.getConnection();
		PreparedStatement prepStmnt=con.prepareStatement("update table Employee set employee_name=?, employee_job=?, employee_salary=? where employee_id=?");
		prepStmnt.setString(1, emp.getEmpName());
		prepStmnt.setString(2, emp.getEmpJob());
		prepStmnt.setInt(3, emp.getEmpSalary());
		prepStmnt.setInt(4, emp.getEmpId());
		prepStmnt.executeUpdate();
		con.close();
	}
}
