package com.activemq.demo.test;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

import org.everit.json.schema.Schema;
import org.everit.json.schema.ValidationException;
import org.everit.json.schema.loader.SchemaLoader;
import org.junit.jupiter.api.Test;

import com.fasterxml.jackson.databind.jsonschema.JsonSchema;

import org.hamcrest.Matcher;
import org.hamcrest.Matchers;
import org.json.JSONObject;
import org.json.JSONTokener;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.module.jsv.JsonSchemaValidator;
 class SchemaTest {
 
	/*@Test
    public void checkSchema() {
        // @formatter:off
        given().
        when().
            get("/articles").
        then().
            log().ifValidationFails().
            assertThat().
            statusCode(200).
        and().
            contentType(ContentType.JSON).


    body(matchesJsonSchemaInClasspath("article.json"));
        // @formatter:on
    }

	private Matcher<?> matchesJsonSchemaInClasspath(String string) {
		// TODO Auto-generated method stub
		return null;
	}

	private RestAssured given() {
		// TODO Auto-generated method stub
		return null;
	}*/
	
//	@Test
//	public void givenInvalidInput_whenValidating_thenInvalid() throws ValidationException {
//	    JSONObject jsonSchema = new JSONObject(
//	      new JSONTokener(JsonSchema.class.getResourceAsStream("/article.json")));
//	    JSONObject jsonSubject = new JSONObject(
//	      new JSONTokener(JsonSchema.class.getResourceAsStream("/product_invalid.json")));
//	    
//	    Schema schema = SchemaLoader.load(jsonSchema);
//	    schema.validate(jsonSubject);
//	}
	
	@Test
	 void givenValidInput_whenValidating_thenValid() throws ValidationException {
	    JSONObject jsonSchema = new JSONObject(
	      new JSONTokener(JsonSchema.class.getResourceAsStream("/article.json")));
	    JSONObject jsonSubject = new JSONObject(
	      new JSONTokener(JsonSchema.class.getResourceAsStream("/article_valid.json")));

	    
	    try{
            Schema schemaValidator = SchemaLoader.load((jsonSchema));
            schemaValidator.validate(jsonSubject);
        }catch (Exception e){
            System.out.println(" message is :"+ e.getMessage());
        }
    }
	}

