package nchu.class1620.entity;

/*
* 16202125-吴俊雄
* Course类 为学生出席的课程的实体类
* 通过该实体类，我们主要可以获取到学生的课程的信息
*/

public class Course {

	private int c_id;
	private String c_name;
	
	public Course() {
		
	}

	public int getC_id() {
		return c_id;
	}

	public void setC_id(int c_id) {
		this.c_id = c_id;
	}

	public String getC_name() {
		return c_name;
	}

	public void setC_name(String c_name) {
		this.c_name = c_name;
	}

}
