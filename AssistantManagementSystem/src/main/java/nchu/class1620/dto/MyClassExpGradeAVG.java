package nchu.class1620.dto;

public class MyClassExpGradeAVG {	
	
	private int cls_id;
	private int s_id;
	private String s_name;
	private String c_name;
	private double avgGrade;
	
	public MyClassExpGradeAVG() {
		
	}
	
	public int getCls_id() {
		return cls_id;
	}

	public void setCls_id(int cls_id) {
		this.cls_id = cls_id;
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

	public String getC_name() {
		return c_name;
	}

	public void setC_name(String c_name) {
		this.c_name = c_name;
	}
	
	public double getAvgGrade() {
		return avgGrade;
	}

	public void setAvgGrade(double avgGrade) {
		this.avgGrade = avgGrade;
	}
	
}
