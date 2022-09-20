package com.spring.springboot.restapi.survey;

import java.math.BigInteger;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;


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

	public Survey retrieveSurveyById(String surveyId) {
		Predicate<? super Survey> predicate =
				survey -> survey.getId().equalsIgnoreCase(surveyId);
		
		Optional<Survey> optionalSurvey 
				= surveys.stream().filter(predicate).findFirst();
		
		if(optionalSurvey.isEmpty()) return null;
		
		return optionalSurvey.get();
	}
	public List<Questions> retrieveAllSurveyQuestionss(String surveyId) {
		Survey survey = retrieveSurveyById(surveyId);

		if (survey == null)
			return null;

		return survey.getQuestions();
	}

	public Questions retrieveSpecificSurveyQuestions(String surveyId, String QuestionsId) {

		List<Questions> surveyQuestionss = retrieveAllSurveyQuestionss(surveyId);

		if (surveyQuestionss == null)
			return null;

		Optional<Questions> optionalQuestions = surveyQuestionss.stream()
				.filter(q -> q.getId().equalsIgnoreCase(QuestionsId)).findFirst();

		if (optionalQuestions.isEmpty())
			return null;

		return optionalQuestions.get();
	}
	
	public String addNewSurveyQuestion(String surveyId, Questions question) {
		List<Questions> questions = retrieveAllSurveyQuestionss(surveyId);
		question.setId(generateRandomId());
		questions.add(question);
		return question.getId();
	}

	private String generateRandomId() {
		SecureRandom secureRandom = new SecureRandom();
		String randomId = new BigInteger(32, secureRandom).toString();
		return randomId;
	}
	
	public String deleteSurveyQuestion(String surveyId, String questionId) {

		List<Questions> surveyQuestions = retrieveAllSurveyQuestionss(surveyId);

		if (surveyQuestions == null)
			return null;
		

		Predicate<? super Questions> predicate = q -> q.getId().equalsIgnoreCase(questionId);
		boolean removed = surveyQuestions.removeIf(predicate);
		
		if(!removed) return null;

		return questionId;
	}
	
	public void updateSurveyQuestion(String surveyId, String questionId, Questions question) {
		List<Questions> questions = retrieveAllSurveyQuestionss(surveyId);
		questions.removeIf(q -> q.getId().equalsIgnoreCase(questionId));
		questions.add(question);
	}


	
	
	
	}
