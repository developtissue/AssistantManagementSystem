package nchu.class1620.dto;

public class MyStuTaskGrade {

	private int s_id;
	private String s_name;
	private String task_name;
	private double t_grade;

	public MyStuTaskGrade() {
		
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

	public double getT_grade() {
		return t_grade;
	}

	public void setT_grade(double t_grade) {
		this.t_grade = t_grade;
	}

}
