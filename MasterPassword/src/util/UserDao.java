package util;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import controller.DbConnection;

public class UserDao {

	public static int validate_user(String username,String password){
		int c=0;
		DbConnection connection=new DbConnection();
		Connection myConn =connection.connect() ;
		if(myConn==null){
			}
		else{
			try{
			PreparedStatement mystmt=null;
			mystmt=(PreparedStatement) myConn.prepareStatement("select * from users");
			ResultSet myRes=mystmt.executeQuery();
			while(myRes.next())
			{
				
				String usern= myRes.getString("email");
				String passw=myRes.getString("password");
				if(username.equals(usern) && password.equals(AesEncryption.decrypt(passw)))
				{
					c=1;
				}
				
			}
			}catch(Exception e){
				e.printStackTrace();
			}
		
		}
		
		return c;
	}
	
}
