package com.myworldcreations.testengine.question.dao;

public class QuestionDTO {
	private int id;
	private String Name;
	private String Ans1;
	private String Ans2;
	private String Ans3;
	private String Ans4;
	private String rans;
	private int score;
	public int getId(){
		return id;
	}
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public String getAns1() {
		return Ans1;
	}
	public void setAns1(String ans1) {
		Ans1 = ans1;
	}
	public String getAns2() {
		return Ans2;
	}
	public void setAns2(String ans2) {
		Ans2 = ans2;
	}
	public String getAns3() {
		return Ans3;
	}
	public void setAns3(String ans3) {
		Ans3 = ans3;
	}
	public String getAns4() {
		return Ans4;
	}
	public void setAns4(String ans4) {
		Ans4 = ans4;
	}
	public String getRans() {
		return rans;
	}
	public void setRans(String rans) {
		this.rans = rans;
	}
	public int getScore() {
		return score;
	}
	public void setScore(int score) {
		this.score = score;
	}
	public void setId(int id) {
		this.id = id;
	}
	
@Override
public String toString(){
	return "QuestionDTO [id=" + id + ", name=" + Name +", ans1=" + Ans1 + ", ans2=" + Ans2 + ", ans3=" + Ans3 + ", ans4=" + Ans4 + ", rans=" + rans + ", score=" + score + "]";
		
}
}

