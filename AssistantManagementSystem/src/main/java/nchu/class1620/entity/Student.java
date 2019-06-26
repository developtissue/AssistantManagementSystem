package nchu.class1620.entity;

/*
* 16202125-吴俊雄
* Student类 可以获取的学生的相应的信息
*/

public class Student {

	private int s_id;
	private String s_name;
	private int cls_id;
	private String password;

	public Student() {

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

	public int getCls_id() {
		return cls_id;
	}

	public void setCls_id(int cls_id) {
		this.cls_id = cls_id;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
