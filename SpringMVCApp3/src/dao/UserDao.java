package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.datasource.DriverManagerDataSource;

import entity.User;

public class UserDao {

	private DriverManagerDataSource ds;

	public void setDataSource(DriverManagerDataSource ds) {
		this.ds = ds;
	}

	public DriverManagerDataSource getDataSource() {
		return ds;
	}

	public User findUser(String mailId, String password) throws Exception {
		
		User user = null;
		Connection con=ConnectionProvider.getConnection();
		//Connection con=ds.getConnection();
		PreparedStatement prepStmnt = con.prepareStatement("Select * from user_details where EMAIL_ID=? and password=?");
		prepStmnt.setString(1, mailId);
		prepStmnt.setString(2, password);
		ResultSet rSet = prepStmnt.executeQuery();
		/*using if here as we are assuming only one record would be returned as there would be only one entry which would be mapped to mailId and password	*/
		if (rSet.next()) {
			user=new User();
			user.setId(rSet.getInt(1));
			user.setUserName(rSet.getString(2));
			user.setMailId(rSet.getString(3));
			user.setPassword(rSet.getString(4));
		}
		con.close();
		return user;
	}

	public void saveUser(User user) throws Exception {
		Connection con=ConnectionProvider.getConnection();
		//Connection con=ds.getConnection();
		PreparedStatement prepStmnt=con.prepareStatement("INSERT INTO USER_DETAILS(NAME,EMAIL_ID,PASSWORD) VALUES (?,?,?)");
		prepStmnt.setString(1, user.getUserName());
		prepStmnt.setString(2, user.getMailId());
		prepStmnt.setString(3, user.getPassword());
		prepStmnt.executeUpdate();
		con.close();
	}

	public User mapRecord(ResultSet rSet) throws Exception {
		User user = new User();
		user.setUserName(rSet.getString(2));
		user.setMailId(rSet.getString(3));
		user.setPassword(rSet.getString(4));
		return user;

	}
}
