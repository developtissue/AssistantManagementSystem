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
public class ExperimentIO {
	public String ReadExperiment(int assist_id, int e_id, int s_id) {
		File file = new File(this.getClass().getResource("").getPath());
		file = file.getParentFile();
		file = file.getParentFile();
		file = file.getParentFile();
		file = file.getParentFile();
		file = file.getParentFile();
		String url = file.getPath() + "/src/main/resources/static/Experiment/" + assist_id + "/" + e_id + "/" + s_id
				+ ".txt";
		file = new File(url);
		String text = "";
		try (FileReader reader = new FileReader(file); BufferedReader br = new BufferedReader(reader)) {
			String line;
			while ((line = br.readLine()) != null) {
				text = text + line + "\n";
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return text;
	}
}
