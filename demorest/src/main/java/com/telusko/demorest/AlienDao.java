package com.telusko.demorest;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class AlienDao {

	private Connection getConnection() throws SQLException, ClassNotFoundException {
		Connection con = null;
		/*
		 * Here we are using the sql driver class which will load the DriverManager and
		 * through driver manager we will establish the connection to the DB, for MYSql
		 * db you should use the mySql driver class which would be like
		 * Class.forName("com.mysql.jdbc.Driver");
		 */

		Class.forName("oracle.jdbc.driver.OracleDriver");
		/* We will provide the DB details below i.e. DB URL, username, Password */
		con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521/pdborcl", "SYSTEM", "Sourabhcool10");
		return con;
	}

	public List<Alien> getAllAliens() {
		List<Alien> alienList = new ArrayList<Alien>();
		try {
			Connection con = getConnection();
			Statement stmnt = con.createStatement();
			ResultSet rset = stmnt.executeQuery("Select * from Aliens");
			while (rset.next()) {
				Alien alien = new Alien();
				alien.setId(rset.getInt(1));
				alien.setName(rset.getString(2));
				alien.setPoints(rset.getInt(3));
				alienList.add(alien);
			}
			con.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return alienList;
	}

	public Alien getAlien(int id) throws SQLException, ClassNotFoundException {
		Connection con = getConnection();
		Alien alien = new Alien();

		PreparedStatement prepStmnt = con.prepareStatement("Select * from Aliens where id=?");
		prepStmnt.setInt(1, id);
		ResultSet rset = prepStmnt.executeQuery();
		if (rset.next()) {
			alien.setId(rset.getInt(1));
			alien.setName(rset.getString(2));
			alien.setPoints(rset.getInt(3));
		}
		con.close();
		return alien;

	}

	public void saveAlien(Alien a) throws SQLException, ClassNotFoundException {
		Connection con = getConnection();
		PreparedStatement prepStmnt = con.prepareStatement("Insert into Aliens(name, points) values(?,?)");
		prepStmnt.setString(1, a.getName());
		prepStmnt.setInt(2, a.getPoints());
		prepStmnt.executeUpdate();
		con.close();

	}

	public void updateAlien(Alien alien) throws SQLException, ClassNotFoundException {
		Connection con = getConnection();
		PreparedStatement prepStmnt = con.prepareStatement("update Aliens set name=?, points=? where id=?");
		prepStmnt.setString(1, alien.getName());
		prepStmnt.setInt(2, alien.getPoints());
		prepStmnt.setInt(3, alien.getId());
		prepStmnt.executeUpdate();

		con.close();

	}
	
	public int deleteAlien(int id) throws SQLException, ClassNotFoundException
	{
		Connection con=getConnection();
		PreparedStatement prepStmnt=con.prepareStatement("delete from Aliens where id=?");
		prepStmnt.setInt(1, id);
		return prepStmnt.executeUpdate();
		
	}

}
