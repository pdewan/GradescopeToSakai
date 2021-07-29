package com.LAHelp.ParseHelpers;

import java.util.List;

public class StudentSubmission {
	private String name;
	private List<Submitter> submitters;
	private String created_at;
	private double score;
	private String status;
	private Result results;
	private List<StudentSubmission> history;
	private String id;
		
	public String getName() {
		return this.name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public List<Submitter> getSubmitters() {
		return this.submitters;
	}
	
	public void setSubmitters(List<Submitter> submitters) {
		this.submitters = submitters;
	}
	
	public String getCreated_at() {
		return this.created_at;
	}
	
	public void setCreated_at(String created_at) {
		this.created_at = created_at;
	}
	
	public double getScore() {
		return this.score;
	}
	
	public void setScore(double score) {
		this.score = score;
	}
	
	public String getStatus() {
		return this.status;
	}
	
	public void setStatus(String status) {
		this.status = status;
	}
	
	public Result getResults() {
		return this.results;
	}
	
	public void setResults(Result results) {
		this.results = results;
	}
	
	public List<StudentSubmission> getHistory() {
		return this.history;
	}
	
	public void setHistory(List<StudentSubmission> history) {
		this.history = history;
	}
	
	public String getId() {
		return this.id;
	}
	
	public void setId(String id) {
		this.id = id;
	}
}
