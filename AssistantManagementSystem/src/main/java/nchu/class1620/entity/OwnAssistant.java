package nchu.class1620.entity;


/*create by :Hanxj 
 * */
public class OwnAssistant {
  
	private int t_id;
	private int assist_id;
	private int c_id;
	private double assist_grade;
	private String comment;
	
	public OwnAssistant(){
		
	}
	
	public int getT_id() {
		return t_id;
	}

	public void setT_id(int t_id) {
		this.t_id = t_id;
	}

	public int getAssist_id() {
		return assist_id;
	}
	public void setAssist_id(int assist_id) {
		this.assist_id = assist_id;
	}
	
	public int getC_id() {
		return c_id;
	}

	public void setC_id(int c_id) {
		this.c_id = c_id;
	}

	public double getAssist_grade() {
		return assist_grade;
	}
	public void setAssist_grade(double assist_grade) {
		this.assist_grade = assist_grade;
	}
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
	
	 
}
