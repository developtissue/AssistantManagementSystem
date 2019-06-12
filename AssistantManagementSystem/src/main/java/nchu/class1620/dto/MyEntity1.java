package nchu.class1620.dto;

public class MyEntity1 {

	private int s_id;
	private String s_name;
	private String c_name;
	private String e_name;
	private String e_content;
	private double ae_grade;

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

	public String getC_name() {
		return c_name;
	}

	public void setC_name(String c_name) {
		this.c_name = c_name;
	}
	
	public String getE_name() {
		return e_name;
	}

	public void setE_name(String e_name) {
		this.e_name = e_name;
	}

	public String getE_content() {
		return e_content;
	}

	public void setE_content(String e_content) {
		this.e_content = e_content;
	}

	public double getAe_grade() {
		return ae_grade;
	}

	public void setAe_grade(double ae_grade) {
		this.ae_grade = ae_grade;
	}

	@Override
	public String toString() {
		return "MyEntity1 [s_id=" + s_id + ", s_name=" + s_name + ", c_name=" + c_name + ", e_name=" + e_name
				+ ", e_content=" + e_content + ", ae_grade=" + ae_grade + "]";
	}

	
	
}
