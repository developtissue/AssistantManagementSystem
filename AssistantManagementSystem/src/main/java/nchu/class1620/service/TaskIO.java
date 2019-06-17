package nchu.class1620.service;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

/*
 * Created by ZhangJing
 * Notes:If you modify this class,you should keep attributes and methods
 *       which i have already done.But you can add what you want.
 * */
public class TaskIO {
	public String ReadTask(int assist_id, int t_id, int s_id) {
		String text = "";
		File file = new File(this.getClass().getResource("").getPath());
		file = file.getParentFile();
		file = file.getParentFile();
		file = file.getParentFile();
		file = file.getParentFile();
		file = file.getParentFile();
		String url = file.getPath() + "/src/main/resources/static/Task/" + assist_id + "/" + t_id + "/" + s_id + ".txt";
		file = new File(url);
		try (FileReader reader = new FileReader(file); BufferedReader br = new BufferedReader(reader)) {
			String line;
			while ((line = br.readLine()) != null) {
				text += line;
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return text;
	}
}
