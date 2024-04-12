package com.in28Minutes.springbooot.firstrestapi.survey;

import static org.junit.jupiter.api.Assertions.*;

import org.json.JSONException;
import org.junit.jupiter.api.Test;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.ResponseEntity;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
class SurveyResourceIT {
	
	String str = """
			{
				"id": "Question1",
				"description": "Most Popular Cloud Platform Today updated",
				"correctAnswer": "Google Cloud"
			}
			 """;
	
	private static String SPECIFIC_QUESTION_URL ="/surveys/Survey1/questions/Question1";
	private static String ALL_QUESTION_URL = "/surveys/Survey1/questions";
	
	@Autowired
	TestRestTemplate template;


	@Test
	void retrieveSpecificSurveyQuestion_basicScenario() throws JSONException {
		ResponseEntity<String> responseEntity = template.getForEntity(SPECIFIC_QUESTION_URL, String.class);
		String expectedResult = """
									{"id":"Question1","description":"Most Popular Cloud Platform Today","options":["AWS","Azure","Google Cloud","Oracle Cloud"],"correctAnswer":"AWS"}
								""";
		assertTrue(responseEntity.getStatusCode().is2xxSuccessful());
		assertEquals("application/json", responseEntity.getHeaders().get("Content-Type").get(0));
		JSONAssert.assertEquals(expectedResult.trim(), responseEntity.getBody(),false);
		
	}
	

	@Test
	void retrieveAllSurveyQuestion_basicScenario() throws JSONException {
		ResponseEntity<String> responseEntity = template.getForEntity(SPECIFIC_QUESTION_URL, String.class);
		String expectedResult = """
									[
										{
										"id": "Question1"
										},
										{
										"id": "Question2"
										},
										{
										"id": "Question3"
										}
										]
								""";
		assertTrue(responseEntity.getStatusCode().is2xxSuccessful());
		assertEquals("application/json", responseEntity.getHeaders().get("Content-Type").get(0));
		JSONAssert.assertEquals(expectedResult.trim(), responseEntity.getBody(),false);
		
	}
}
