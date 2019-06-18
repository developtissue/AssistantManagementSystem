package nchu.class1620.dto;

/*
 * author: 16202125-吴俊雄
 * MyEntity2 获取学生作业成绩的dto类
 */

public class MyEntity2 {

	private int s_id;
	private String s_name;
	private String task_name;
	private String task_content;
	private double task_grade;
	
	public MyEntity2() {
		
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
	
	public String getTask_name() {
		return task_name;
	}

	public void setTask_name(String task_name) {
		this.task_name = task_name;
	}
	
	public String getTask_content() {
		return task_content;
	}

	public void setTask_content(String task_content) {
		this.task_content = task_content;
	}

	public double getTask_grade() {
		return task_grade;
	}

	public void setTask_grade(double task_grade) {
		this.task_grade = task_grade;
	}
	
}
