package com.myworldcreations.testengine.question.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.myworldcreations.testengine.utils.CommonDAO;
import com.myworldcreations.testengine.utils.constants.QueryConstant;

public class QuestionDAO {
	
	
	public ArrayList<QuestionDTO> getQuestion() throws SQLException, ClassNotFoundException{
	Connection connection = null;
	PreparedStatement pstmt  = null;
	ResultSet rs = null ;
	
	ArrayList<QuestionDTO>questions = new ArrayList<>();
	connection = CommonDAO.getConnection();
	pstmt = connection.prepareStatement(QueryConstant.QUESTION_FETCH_SQL);
	rs = pstmt.executeQuery();
	try{
	while(rs.next()){
		QuestionDTO questionDTO = new QuestionDTO();
		questionDTO.setId(rs.getInt("id"));
		questionDTO.setName(rs.getString("name"));
		questionDTO.setAns1(rs.getString("ans1"));
		questionDTO.setAns2(rs.getString("ans2"));
		questionDTO.setAns3(rs.getString("ans3"));
		questionDTO.setAns4(rs.getString("ans4"));
		questionDTO.setRans(rs.getString("rans"));
		questionDTO.setScore(rs.getInt("score"));
		questions.add(questionDTO);
		
	}
	return questions;
	}

	finally{
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
	

	public void bulkUpload(ArrayList<QuestionDTO> questionList) throws SQLException, ClassNotFoundException{
		Connection connection = null;
		PreparedStatement pstmt = null;
	

	try{
		 connection = CommonDAO.getConnection();
		pstmt = connection.prepareStatement(QueryConstant.QUESTION_UPLOAD_SQL);
		for(QuestionDTO question : questionList){
			pstmt.setInt(1, question.getId());
			
			pstmt.setString(2, question.getName());
			pstmt.setString(3, question.getAns1());
			pstmt.setString(4, question.getAns2());
			pstmt.setString(5, question.getAns3());
			pstmt.setString(6, question.getAns4());
			pstmt.setString(7, question.getRans());
			pstmt.setInt(8, question.getScore());
			pstmt.addBatch();
		}
		
		int records [] = pstmt.executeBatch();
        System.out.println("Record Uploaded...");
	}
	
	finally{
		if(pstmt!=null){
			pstmt.close();
		}
		
		if(connection!=null){
			connection.close();
		}
	}
	}
        


		
	}

