package nchu.class1620.dto;

/*
 * author: 16202125-吴俊雄
 * MyEntity3 以班级为单位获取学生所以实验的平均成绩的dto类
 */

public class MyEntity3 {

	private int s_id;
	private String s_name;
	private double avgGrade;
	
	public MyEntity3() {
		
	}
	
	public int getS_id() {
		return s_id;
	}
	public void setS_id(int s_id) {
		this.s_id = s_id;
	}
	public String getS_name() {
		return s_name;
	}
	public void setS_name(String s_name) {
		this.s_name = s_name;
	}
	public double getAvgGrade() {
		return avgGrade;
	}
	public void setAvgGrade(double avgGrade) {
		this.avgGrade = avgGrade;
	}
	
}
