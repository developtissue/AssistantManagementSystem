package nchu.class1620.entity;

import java.util.ArrayList;

public class Experiment {

	private int e_id;
	private String e_name;
	private String e_content;
	/*
	 * Created by ZhangJing Notes:Use students link experiment with students
	 */
	private ArrayList<Student> students;

	public Experiment() {

	}

	public int getE_id() {
		return e_id;
	}

	public void setE_id(int e_id) {
		this.e_id = e_id;
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

	public ArrayList<Student> getStudents() {
		return students;
	}

	public void setStudents(ArrayList<Student> students) {
		this.students = students;
	}

}
