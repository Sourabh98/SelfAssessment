package dao;

import java.sql.Connection;
import java.sql.DriverManager;



public class ConnectionProvider {

	
	public static Connection getConnection() throws Exception
	{
		Connection con = null;
		/*Here we are using the sql driver class which will load the DriverManager and through driver manager we will establish the connection to the DB, for MYSql db you should use the
		 * mySql driver class which would be like Class.forName("com.mysql.jdbc.Driver");*/
		
		Class.forName("oracle.jdbc.driver.OracleDriver");
		/*We will provide the DB details below i.e. DB URL, username, Password*/
		con = DriverManager.getConnection(
				"jdbc:oracle:thin:@localhost:1521/pdborcl",
				"SYSTEM",
				"Sourabhcool10");
		return con;

	}
}
