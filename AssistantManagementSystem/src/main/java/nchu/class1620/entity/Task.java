package nchu.class1620.entity;

/*
* 16202125-吴俊雄
* Task类 
* 通过该实体类可以获取到老师发布的作业的相关信息
*/

public class Task {

	private int t_id;
	private String t_name;
	private String t_content;
	
	public Task() {
		
	}

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
		
	
	
}
