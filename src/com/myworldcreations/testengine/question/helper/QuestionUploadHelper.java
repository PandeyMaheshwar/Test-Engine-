package com.myworldcreations.testengine.question.helper;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;

import com.myworldcreations.testengine.question.dao.QuestionDAO;
import com.myworldcreations.testengine.question.dao.QuestionDTO;
import com.myworldcreations.testengine.utils.CommonUtil;
import com.myworldcreations.testengine.utils.constants.PathConstants;

public class QuestionUploadHelper {
	
	
	public void writeToDB(String path) throws IOException{
		ArrayList<QuestionDTO> questionList = new ArrayList<>();
		boolean isFirstRowPass = false;
		int cellCounter = 0;
		FileInputStream fs = new FileInputStream(path);
		HSSFWorkbook workBook = new HSSFWorkbook(fs);
		HSSFSheet sheet = workBook.getSheetAt(0);
		
		
		Iterator<Row> rows = sheet.rowIterator();
	    while(rows.hasNext()){
	    	Row currentRow = rows.next();
	    	if(!isFirstRowPass){
	    		isFirstRowPass = true;
	    		continue;
	    	}
	    	cellCounter  = 0;
	    	QuestionDTO questionDTO = new QuestionDTO();
	    	Iterator<Cell> cells = currentRow.cellIterator();
	    	while(cells.hasNext()){
	    		Cell currentCell = cells.next();
	    		cellCounter++;
	    		if(cellCounter==1){
	    			questionDTO.setId((int)currentCell.getNumericCellValue());
	    		}
	    		else
	    			if(cellCounter==2){
		    			questionDTO.setName(currentCell.getStringCellValue());
		    		}
	    		
	    		else
	    			if(cellCounter==3){
						questionDTO.setAns1(currentCell.getStringCellValue());
					}
					else
						if(cellCounter==4){
							questionDTO.setAns2(currentCell.getStringCellValue());
						}
						else
							if(cellCounter==5){
								questionDTO.setAns3(currentCell.getStringCellValue());
							}
							else
								if(cellCounter==6){
									questionDTO.setAns4(currentCell.getStringCellValue());
								}
								else
									if(cellCounter==7){
										questionDTO.setRans(currentCell.getStringCellValue());
									}
									else
										if(cellCounter==8){
											questionDTO.setScore((int)currentCell.getNumericCellValue());
										}
				
		    		}
	    	questionList.add(questionDTO);
	    		}
	    QuestionDAO questiondao = new QuestionDAO();
	    System.out.println("question are:"+questionList);
	    
	    	
	try {
		questiondao.bulkUpload(questionList);
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	catch(ClassNotFoundException e){
		e.printStackTrace();
	}
}
	    
	   
	    		
	    	
	    
	
	
	
	public void write() throws IOException{
		String path = "C://Users//Sh.SANJAY Maheshwar .LAPTOP-6O53OMLG//Documents";
		FileOutputStream fs = new FileOutputStream(path);
		String data = "Hello How are You";
		fs.write(data.getBytes());
		fs.close();
		System.out.println("Write Done....");
		
	}

	public static void main(String[] args) throws IOException {
		QuestionUploadHelper helper =new QuestionUploadHelper();
		helper.write();
		// TODO Auto-generated method stub

	}

	public boolean read(String path)throws IOException {
		//String path = "C:\\Users\\Sh.SANJAY Maheshwar .LAPTOP-6O53OMLG\\Music\\Music";
		boolean isUploaded = false;
		File file = new File(path);
		String fileName = CommonUtil.getFileName(path);
		String fullName = PathConstants.UPLOAD_PATH+fileName;
		FileOutputStream fo = new FileOutputStream(fullName);
		BufferedOutputStream bo = new BufferedOutputStream(fo);
		final int EOF = -1;
		
		
		if(file.exists()){
			System.out.println("File Exists..");
			FileInputStream fs = new FileInputStream(path);
			BufferedInputStream bs = new BufferedInputStream(fs);
			long startTime = System.currentTimeMillis();
			int SingleByte = bs.read();  //read single byte
			while(SingleByte!=EOF){
			//	System.out.println((char)SingleByte);
                bo.write(SingleByte);
				SingleByte = bs.read(); 
			}
	
			isUploaded = true;
			long endTime = System.currentTimeMillis();
			System.out.println("Total time taken"+(endTime-startTime)+"ms");
			bo.close();
			fo.close();
			bs.close();
			fs.close();
			writeToDB(fullName);
		
		}
		
		else{
			System.out.println("File not Exist.....");
		}
		return isUploaded;
		
	}
}

 
	
	
	

