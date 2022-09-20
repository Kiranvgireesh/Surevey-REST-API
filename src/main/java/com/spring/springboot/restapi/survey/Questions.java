package com.spring.springboot.restapi.survey;

import java.util.List;

public class Questions {
	private String id;
	
	public Questions() {
		
	}
	
	
	public Questions(String id, String description, List<String> options, String answer) {
		super();
		this.id = id;
		this.description = description;
		this.options = options;
		this.answer = answer;
	}
	private String description;
	private List<String> options;
	private String answer;
	
	
	
	
	
	
	
	@Override
	public String toString() {
		return "Questions [id=" + id + ", description=" + description + ", options=" + options + ", answer=" + answer
				+ "]";
	}
	
	
	
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public List<String> getOptions() {
		return options;
	}
	public void setOptions(List<String> options) {
		this.options = options;
	}
	public String getAnswer() {
		return answer;
	}
	public void setAnswer(String answer) {
		this.answer = answer;
	}
	
	

}
