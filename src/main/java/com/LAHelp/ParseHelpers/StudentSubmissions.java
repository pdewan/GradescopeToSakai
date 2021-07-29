package com.LAHelp.ParseHelpers;

import java.util.List;
import java.util.Map;

public class StudentSubmissions {
	private List<StudentSubmission> studentSubmissions;
	private Map<String, StudentSubmission> map;

	public List<StudentSubmission> getStudentSubmissions() {
		return studentSubmissions;
	}

	public void setStudentSubmissions(List<StudentSubmission> studentSubmissions) {
		this.studentSubmissions = studentSubmissions;
	}
	
	public Map<String, StudentSubmission> getMap() {
		return this.map;
	}
	
	public void setMap(Map<String, StudentSubmission> map) {
		this.map = map;
	}
}
