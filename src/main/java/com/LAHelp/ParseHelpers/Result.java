package com.LAHelp.ParseHelpers;

import java.util.List;

public class Result {
	private double score;
	private List<Test> tests;
	private String output;
	private String extra_data;
	private String visibility;
	private List<String> leaderboard;
	private int exection_time;
	private String execution_time;
	
	public double getScore() {
		return score;
	}
	public void setScore(double score) {
		this.score = score;
	}
	public List<Test> getTests() {
		return tests;
	}
	public void setTests(List<Test> tests) {
		this.tests = tests;
	}
	public String getOutput() {
		return output;
	}
	public void setOutput(String output) {
		this.output = output;
	}
	public String getExtra_data() {
		return extra_data;
	}
	public void setExtra_data(String extra_data) {
		this.extra_data = extra_data;
	}
	public String getVisibility() {
		return visibility;
	}
	public void setVisibility(String visibility) {
		this.visibility = visibility;
	}
	public List<String> getLeaderboard() {
		return leaderboard;
	}
	public void setLeaderboard(List<String> leaderboard) {
		this.leaderboard = leaderboard;
	}
	public int getExection_time() {
		return exection_time;
	}
	public void setExection_time(int exection_time) {
		this.exection_time = exection_time;
	}
	public String getExecution_time() {
		return execution_time;
	}
	public void setExecution_time(String execution_time) {
		this.execution_time = execution_time;
	}	
	
}
