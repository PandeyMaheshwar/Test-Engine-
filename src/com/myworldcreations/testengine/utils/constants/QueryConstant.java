package com.myworldcreations.testengine.utils.constants;

public interface QueryConstant {
//String LOGIN_SQL ="select userid,password from exam where userid=? and password=?";
	String LOGIN_SQL = "SELECT USER_MST.USERID, ROLE_MST.NAME AS ROLENAME, RIGHT_MST.NAME "
			+ "AS RIGHTNAME,RIGHT_MST.SCREENNAME FROM USER_MST, "
			+ "ROLE_MST,RIGHT_MST,USER_ROLE_MAPPING,ROLE_RIGHT_MAPPING "
			+ "WHERE USER_MST.UID=USER_ROLE_MAPPING.UID AND "
			+ "ROLE_MST.ROLEID=USER_ROLE_MAPPING.ROLEID AND "
			+ "ROLE_MST.ROLEID=ROLE_RIGHT_MAPPING.ROLEID AND "
			+ "RIGHT_MST.RIGHTID=ROLE_RIGHT_MAPPING.RIGHTID "
			+ "AND USER_MST.USERID=? and USER_MST.PASSWORD=?";

	
String REGISTER_SQL = "insert into USER_MST(userid, password) values(?,?)"; 
String QUESTION_UPLOAD_SQL = "insert into question (id,Name,Ans1,Ans2,Ans3,Ans4,rans,score) values(?,?,?,?,?,?,?,?)";


String QUESTION_FETCH_SQL = "select id, name, ans1, ans2, ans3, ans4, rans,score from question";
}
