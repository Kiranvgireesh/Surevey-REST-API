package com.spring.springboot.restapi.survey;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SurveyResources {
	
	private SurveyService surveyService;

	public SurveyResources(SurveyService surveyService) {
		super();
		this.surveyService = surveyService;
	}
	
	@RequestMapping("/surveys")
	public List<Survey> retrieveAllSurveys(){
		return surveyService.getAllSurveys();
	}
	

}
