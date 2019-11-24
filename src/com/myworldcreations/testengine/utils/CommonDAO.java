package com.myworldcreations.testengine.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ResourceBundle;

public interface CommonDAO {
	
	public static Connection getConnection() throws SQLException, ClassNotFoundException{
		Class.forName("org.postgresql.Driver");
	ResourceBundle rb = ResourceBundle.getBundle("config");
		String dbUrl = rb.getString("url");
		String userid = rb.getString("userid");
		String password = rb.getString("password");
		Connection con = DriverManager.getConnection(dbUrl,userid,password);
		//Connection con1 = DriverManager.getConnection("jdbc:postgresql:\\localhost:5432\\maheshwar","postgres","maheshwar");
	//Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/maheshwar","postgres","maheshwar");
//	if(con!=null){
//	System.out.println("Connection Created..");
////			
	//}
//		
		
		return con;
	}

	}


