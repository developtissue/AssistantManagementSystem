package nchu.class1620.entity;

/*
* 16202125-吴俊雄
* DOTask类 为学生所做的作业的实体类
* 通过该实体类，我们主要可以获取到学生的作业成绩的信息
*/

public class DoTask {

	private int s_id;
	private int t_id;
	private double t_grade;
	
	public DoTask() {
		
	}
	
	public int getS_id() {
		return s_id;
	}

	public void setS_id(int s_id) {
		this.s_id = s_id;
	}

	public int getT_id() {
		return t_id;
	}

	public void setT_id(int t_id) {
		this.t_id = t_id;
	}

	public double getT_grade() {
		return t_grade;
	}

	public void setT_grade(double t_grade) {
		this.t_grade = t_grade;
	}

}
