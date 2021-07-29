package com.LAHelp.ParseHelpers;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.yaml.snakeyaml.Yaml;
import org.yaml.snakeyaml.constructor.Constructor;

public class GradescopeParser {
	String resource;
	
	public GradescopeParser(String fileName) {
		this.resource = fileName;
	}
	
	public void setResource(String fileName) {
		this.resource = fileName;
	}
	
	public StudentSubmissions parse() {
		Yaml yaml = new Yaml(new Constructor(StudentSubmissions.class));
//		InputStream inputStream = this.getClass().getClassLoader().getResourceAsStream(resource);
		InputStream inputStream;
		try {
			inputStream = new FileInputStream(resource);
		

		StudentSubmissions studentSubmissions = yaml.load(inputStream);
		studentSubmissions.setMap(new HashMap<String, StudentSubmission>());
		for (StudentSubmission studentSubmission : studentSubmissions.getStudentSubmissions()) {
			studentSubmissions.getMap().put(studentSubmission.getName(), studentSubmission);
		}
		return studentSubmissions;
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.exit(-1);	
			return null;
		}
	}
	
	public List<String> getDataForCSVConversion(StudentSubmissions studentSubmissions) {
		List<String> dataLines = new ArrayList<>();
		for (StudentSubmission studentSubmission : studentSubmissions.getStudentSubmissions()) {
			StringBuilder sb = new StringBuilder();
			sb.append(studentSubmission.getSubmitters().get(0).getSid());
			sb.append(',');
			sb.append(studentSubmission.getSubmitters().get(0).getSid());
			sb.append(',');
			String[] name = studentSubmission.getSubmitters().get(0).getName().split(" ");
			sb.append(name[name.length-1]);
			sb.append(',');
			sb.append(name[0]);
			sb.append(',');
			sb.append(studentSubmission.getScore());
			sb.append(',');
			sb.append(studentSubmission.getCreated_at());
			sb.append(',');
			sb.append("On time");
			//TODO: Change "On time" to be the result of computing whether student submitted before deadline.
			dataLines.add(sb.toString());
		}
		return dataLines;
	}
	
}
