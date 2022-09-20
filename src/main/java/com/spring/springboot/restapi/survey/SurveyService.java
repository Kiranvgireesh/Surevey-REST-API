package com.spring.springboot.restapi.survey;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class SurveyService {
	public static List<Survey> surveys =new ArrayList<>();
	
	static {
		
		Questions Questions1 = new Questions("Questions1",
		        "Most Popular Cloud Platform Today", Arrays.asList(
		                "AWS", "Azure", "Google Cloud", "Oracle Cloud"), "AWS");
		Questions Questions2 = new Questions("Questions2",
		        "Fastest Growing Cloud Platform", Arrays.asList(
		                "AWS", "Azure", "Google Cloud", "Oracle Cloud"), "Google Cloud");
		Questions Questions3 = new Questions("Questions3",
		        "Most Popular DevOps Tool", Arrays.asList(
		                "Kubernetes", "Docker", "Terraform", "Azure DevOps"), "Kubernetes");

		List<Questions> Questions = new ArrayList<>(Arrays.asList(Questions1,
		        Questions2, Questions3));

		Survey survey = new Survey("Survey1", "My Favorite Survey",
		        "Description of the Survey", Questions);

		surveys.add(survey);
		
		
		
		
		
		
	}

	public List<Survey> getAllSurveys() {
		// TODO Auto-generated method stub
		return surveys;
	}
	
	
	
	
	}
