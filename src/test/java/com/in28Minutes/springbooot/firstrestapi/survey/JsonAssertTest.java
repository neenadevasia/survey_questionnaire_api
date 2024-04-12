package com.in28Minutes.springbooot.firstrestapi.survey;

import static org.junit.jupiter.api.Assertions.*;

import org.json.JSONException;
import org.junit.jupiter.api.Test;
import org.skyscreamer.jsonassert.JSONAssert;

class JsonAssertTest {

	@Test
	void jsonAssert_learningBasics() throws JSONException {
		
		String expectedResult = """
				{"id":"Question1","description":"Most Popular Cloud Platform Today","options":["AWS","Azure","Google Cloud","Oracle Cloud"],"correctAnswer":"AWS"}
			""";
		String actualResult = """
				{"id":"Question1","description":"Most Popular Cloud Platform Today","options":["AWS","Azure","Google Cloud","Oracle Cloud"],"correctAnswer":"AWS"}
			""";
		
		JSONAssert.assertEquals(expectedResult, actualResult, true);
	}

}
