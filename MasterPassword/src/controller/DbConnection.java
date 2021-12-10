package controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DbConnection {

	public Connection connect(){
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/MasterPassword","root","");
			return connection;
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}
}
