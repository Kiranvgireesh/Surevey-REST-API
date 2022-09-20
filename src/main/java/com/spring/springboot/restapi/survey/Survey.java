package com.spring.springboot.restapi.survey;

import java.util.List;
import java.util.Objects;

public class Survey {
	private String id;
	public Survey(String id, String title, String description, List<Questions> questions) {
		super();
		this.id = id;
		this.title = title;
		this.description = description;
		this.questions = questions;
	}
	@Override
	public String toString() {
		return "Survey [id=" + id + ", title=" + title + ", description=" + description + ", questions=" + questions
				+ "]";
	}
	@Override
	public int hashCode() {
		return Objects.hash(description, id, questions, title);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Survey other = (Survey) obj;
		return Objects.equals(description, other.description) && Objects.equals(id, other.id)
				&& Objects.equals(questions, other.questions) && Objects.equals(title, other.title);
	}
	public String getId() {
		return id;
	}
	public String getTitle() {
		return title;
	}
	public String getDescription() {
		return description;
	}
	public List<Questions> getQuestions() {
		return questions;
	}
	private String title;
	private String description;
	private List<Questions> questions;
	
	
	

}
