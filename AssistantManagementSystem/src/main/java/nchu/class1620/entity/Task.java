package nchu.class1620.entity;


import java.util.ArrayList;

/*
 * Created by ZhangJing
 * Notes:If you modify this class,you should keep attributes and methods
 *       which i have already done.But you can add what you want.
 * */
public class Task {
	private int t_id;
	private String t_name;
	private String t_content;
	private ArrayList<Student> students;

	public int getT_id() {
		return t_id;
	}

	public void setT_id(int t_id) {
		this.t_id = t_id;
	}

	public String getT_name() {
		return t_name;
	}

	public void setT_name(String t_name) {
		this.t_name = t_name;
	}

	public String getT_content() {
		return t_content;
	}

	public void setT_content(String t_content) {
		this.t_content = t_content;
	}


	public ArrayList<Student> getStudents() {
		return students;
	}

	public void setStudents(ArrayList<Student> students) {
		this.students = students;
	}
}
