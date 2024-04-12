package com.in28Minutes.springbooot.firstrestapi.survey;

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
	
	private static List<Survey> surveys = new ArrayList<>();
	
	static {
		Question question1 = new Question("Question1",
                "Most Popular Cloud Platform Today", Arrays.asList(
                        "AWS", "Azure", "Google Cloud", "Oracle Cloud"), "AWS");
        Question question2 = new Question("Question2",
                "Fastest Growing Cloud Platform", Arrays.asList(
                        "AWS", "Azure", "Google Cloud", "Oracle Cloud"), "Google Cloud");
        Question question3 = new Question("Question3",
                "Most Popular DevOps Tool", Arrays.asList(
                        "Kubernetes", "Docker", "Terraform", "Azure DevOps"), "Kubernetes");
 
        List<Question> questions = new ArrayList<>(Arrays.asList(question1,
                question2, question3));
 
        Survey survey = new Survey("Survey1", "My Favorite Survey",
                "Description of the Survey", questions);
        
        surveys.add(survey);
	}

	public List<Survey> retrieveAllSurveys(){
		return surveys;
	}
	
	public Survey retrieveSurveyById(String id){
		
		Optional<Survey> optionalSurvey = surveys.stream().filter(survey -> survey.getId().equalsIgnoreCase(id))
														  .findFirst();
		if(optionalSurvey.isEmpty()) return null;
		return optionalSurvey.get();
	}
	
	public List<Question> retrieveAllSurveyQuestions(String surveyId){
		Optional<Survey> optionalSurvey = surveys.stream().filter(survey -> survey.getId().equalsIgnoreCase(surveyId))
														  .findFirst();
		if(optionalSurvey.isEmpty()) return null;
		
		return optionalSurvey.get().getQuestions();
	
	}
	
	public Question retrieveSurveyQuestionById(String surveyId,String questionId){
		Optional<Survey> optionalSurvey = surveys.stream().filter(survey -> survey.getId().equalsIgnoreCase(surveyId))
														  .findFirst();
		if(optionalSurvey.isEmpty()) return null;
		
		//return optionalSurvey.get().getQuestions();
		List<Question> questions = optionalSurvey.get().getQuestions();
		Optional<Question> optionalQuestion = questions.stream().filter(question -> question.getId().equalsIgnoreCase(questionId))
																.findFirst();
		
		if (optionalQuestion.isEmpty()) return null;
		return optionalQuestion.get();
				
	
	}

	public String addNewSurveyQuestion(String surveyId, Question question) {
		// TODO Auto-generated method stub
		
		List<Question> questions = retrieveAllSurveyQuestions(surveyId);
		question.setId(generateRandomId());
		questions.add(question);
		return question.getId();
	}

	private String generateRandomId() {
		SecureRandom secureRandom = new SecureRandom();
		String randomId = new BigInteger(32,secureRandom).toString();
		return randomId;
	}

	public String deleteSurveyQuestionById(String surveyId, String questionId) {
		// TODO Auto-generated method stub
		
		List<Question> questions = retrieveAllSurveyQuestions(surveyId);
		if(questions == null) return null;
		
		Predicate<? super Question> predicate = question -> question.getId().equalsIgnoreCase(questionId);
		
		Boolean removed = questions.removeIf(predicate);
		
		if(!removed) return null;
		
		return questionId;
	}

	public String updateSurveyQuestionById(String surveyId, String questionId, Question question) {
		// TODO Auto-generated method stub
		List<Question> questions = retrieveAllSurveyQuestions(surveyId);
		if(questions == null) return null;
		
		Predicate<? super Question> predicate = q -> q.getId().equalsIgnoreCase(questionId);
		
		Boolean removed = questions.removeIf(predicate);
		
		if(!removed) return null;
		
		questions.add(question);
		
		return questionId;
	}

}
