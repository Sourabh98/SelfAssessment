package dao;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

public class ConnectionProvider {

	static Properties prop;
	static
	{
		try
		{
		prop=new Properties();
		InputStream in=ConnectionProvider.class.getResourceAsStream("/db.properties");
		prop.load(in);
		System.out.println("Properties loaded.");
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	public Connection getConnection() throws Exception
	{
		Class.forName(prop.getProperty("driverClass"));
		
		return DriverManager.getConnection(prop.getProperty("url"),
				prop.getProperty("userName"), 
				prop.getProperty("password"));
	}
}
