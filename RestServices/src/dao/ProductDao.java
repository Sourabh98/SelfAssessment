package dao;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import oracle.jdbc.driver.*;

import entity.Product;

public class ProductDao {

	/*So before the creation of this DAO create a table with the name Products in the DB and then use those DB credentials to create the connection here.
	 * First we need to create the connection to access the DB in which we need to
	 * provide the DB driver which we are going to use to setup the connection, we
	 * are going to load the driver at run time by using reflection API's forName
	 * method and when we load it there is a static block defined in the driver
	 * class which will get executed and will load the DriverManager class then we
	 * will invoke the getConnectin method of driverManager class to make a
	 * connection with the DB..
	 */

	public Connection getConnection() throws Exception {
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

	/* this method will save a product to the database */
	public void saveProduct(Product p) throws Exception {
		Connection con = getConnection();
		/*We are not passing id here when we are saving the product because Id would be generated by the DB itself.*/
		PreparedStatement prepStmnt = con.prepareStatement("Insert into Products(PRODUCT_NAME, PRODUCT_BRAND , PRODUCT_PRICE) values(?,?,?)");
		prepStmnt.setString(1, p.getName());
		prepStmnt.setString(2, p.getBrand());
		prepStmnt.setInt(3, p.getPrice());
		prepStmnt.executeUpdate();
		con.close();
	}

	/* method to load all products.. */
	public List<Product> getAllProducts() throws Exception {
		Connection con = getConnection();
		List<Product> allProducts = new ArrayList<Product>();
		Statement stmnt = con.createStatement();
		ResultSet resultSet = stmnt.executeQuery("Select * from Products");
		/*Fetchins the objects from the resultset and then adding them to the product object and then adding that object to the product list.*/
		while (resultSet.next()) {
			allProducts.add(mapRecord(resultSet));
		}
		con.close();
		return allProducts;

	}

	public Product mapRecord(ResultSet resultSet) throws Exception {
		Product p = new Product();
		p.setId(resultSet.getInt(1));
		p.setName(resultSet.getString(2));
		p.setBrand(resultSet.getString(3));
		p.setPrice(resultSet.getInt(4));
		return p;
	}
	
	public Product getProduct(int id) throws Exception
	{
		Connection con=getConnection();
		//Product product=new Product();
		PreparedStatement prepStmnt=con.prepareStatement("Select * from Products where product_id=?");
		prepStmnt.setInt(1, id);
	/*We won't get the product Object from the result set, we will get the data on the index basis we can fetch the data the sequence of the index would be same as it would be there in the DB
	 * and the index starts from 1 here.*/
		ResultSet rSet=prepStmnt.executeQuery();
		
		/*
		 * product.setId(rSet.getInt(1)); product.setName(rSet.getString(2));
		 * product.setBrand(rSet.getString(3)); product.setPrice(rSet.getInt(4));
		 */
		con.close();
		return mapRecord(rSet);
		
		
	}
}
