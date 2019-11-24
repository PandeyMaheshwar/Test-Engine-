package com.myworldcreations.testengine.user.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Logger;

import com.myworldcreations.testengine.user.dto.UserDTO;
import com.myworldcreations.testengine.utils.CommonDAO;
import com.myworldcreations.testengine.utils.constants.QueryConstant;

class A{
	static{
		System.out.println("A Class Loaded.....");
		
      }
}

public class UserDAO {
//	Logger logger = Logger.getLogger(UserDAO.class);
	public String doRegister(String userid, String password) throws SQLException, ClassNotFoundException{
		Connection connection = null;
		PreparedStatement pstmt = null;
	try{	
		connection = CommonDAO.getConnection();
		pstmt = connection.prepareStatement(QueryConstant.REGISTER_SQL); 
		pstmt.setString(1,userid);
		pstmt.setString(2,password);
		int insertedCount = pstmt.executeUpdate();
		return insertedCount>0?"Register Successfully":"Can't Register";
	}

	finally{
//	logger.debug("Inside Finally");
	
	if(pstmt!=null){
		pstmt.close();
	}
	if(connection!=null){
		connection.close();
	      }
	}
	  
	}


public String doLogin(String userid,String password) throws ClassNotFoundException, SQLException{
	Connection connection = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	
////logger.debug("Inside UserDAO doLogin Going to make connection");
	try{  
  connection = CommonDAO.getConnection();
  pstmt = connection.prepareStatement(QueryConstant.LOGIN_SQL);
  pstmt.setString(1,userid);
  pstmt.setString(2,password);
  

   rs = pstmt.executeQuery();
// //Logger.DEBUG("Execute Query...");

 
   if(rs.next()){
	 return"Welcome"+userid;
  }
 
   else{	 
 return"Invalid userid or password";
 }
}
 
 finally{
	// Logger.DEBUG("Inside finally...");
	 if(rs!=null){
		 rs.close();
	 }
	 
	 if(pstmt!=null){
		 pstmt.close();
	 }
	 
	 if(connection!=null){
		 connection.close();
	 }
 }

}


public String doRegister(UserDTO userDTO) throws SQLException, ClassNotFoundException {
	Connection connection = null;
	PreparedStatement pstmt = null;
try{	
	connection = CommonDAO.getConnection();
	pstmt = connection.prepareStatement(QueryConstant.REGISTER_SQL); 
	pstmt.setString(1, userDTO.getUserid());
	pstmt.setString(2, userDTO.getPassword());
	int insertedCount = pstmt.executeUpdate();
	return insertedCount>0?"Register Successfully":"Can't Register";
}

finally{
//logger.debug("Inside Finally");

if(pstmt!=null){
	pstmt.close();
}
if(connection!=null){
	connection.close();
      }
}
  

  }
}

 




//	public static void main(String[] args) throws ClassNotFoundException, SQLException {
//		Scanner s = new Scanner (System.in);
//		System.out.println("Enter the Userid");
//		String userid = s.next();
//		System.out.println("Enter the Password");
//		String Pwd = s.next();
//		
//		System.out.println("Driver is Loaded...");
//		Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/maheshwar","postgres","maheshwar");
//		if(con!=null){
//			System.out.println("Connection Created..");
//			
//		}
//		
//	
//				
//				PreparedStatement pstmt = con.prepareStatement(SQL);
//		pstmt.setString(1, userid);
//		pstmt.setString(2, Pwd);
//		ResultSet rs = pstmt.executeQuery();
//		if(rs.next()){
//			System.out.println("Welcome"+userid);
//
//		}
//		else{
//			System.out.println("invalid password");
//		}
//		rs.close();
//		pstmt.close();
//		con.close();
//		// TODO Auto-generated method stub
//
//	}
//

