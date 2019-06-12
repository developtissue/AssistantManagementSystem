package nchu.class1620.entity;

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
