package nchu.class1620.entity;

/*
* 16202125-吴俊雄
* AttendExperiment类 为学生出席的实验课的实体类
* 通过该实体类，我们主要可以获取到学生的实验成绩的信息
*/

public class AttendExperiment {

	private int s_id;
	private int e_id;
	private double ae_grade;
	private String ae_time;
	
	public AttendExperiment() {
		
	}
	
	public int getS_id() {
		return s_id;
	}

	public void setS_id(int s_id) {
		this.s_id = s_id;
	}

	public int getE_id() {
		return e_id;
	}

	public void setE_id(int e_id) {
		this.e_id = e_id;
	}

	public double getAe_grade() {
		return ae_grade;
	}

	public void setAe_grade(double ae_grade) {
		this.ae_grade = ae_grade;
	}

	public String getAe_time() {
		return ae_time;
	}

	public void setAe_time(String ae_time) {
		this.ae_time = ae_time;
	}

	@Override
	public String toString() {
		return "AttendExperiment [s_id=" + s_id + ", e_id=" + e_id + ", ae_grade=" + ae_grade + ", ae_time=" + ae_time
				+ "]";
	}
	
}
