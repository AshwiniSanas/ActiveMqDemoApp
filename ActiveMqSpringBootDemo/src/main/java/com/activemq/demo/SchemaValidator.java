package com.activemq.demo;

import java.io.IOException;
import java.io.InputStream;

import org.everit.json.schema.Schema;
import org.everit.json.schema.loader.SchemaLoader;
import org.json.JSONObject;
import org.json.JSONTokener;

import com.activemq.demo.model.ArticleDto;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * This class is used to validate the json object against a json schema
 * @author Ashwini.Sanas
 *
 */
public class SchemaValidator
{

/**
 * 
 * @param article
 * -This is an ArticleDto object.
 */
public void validateArticle(ArticleDto article)  
   {
	   try(InputStream inputStream=getClass().getResourceAsStream("/article.json"))
	   {
		   JSONObject jsonObject=new JSONObject(new JSONTokener(inputStream));
		   
		   Schema schema=SchemaLoader.load(jsonObject);
		   
	       ObjectMapper om=new ObjectMapper();

		   String json=om.writerWithDefaultPrettyPrinter().writeValueAsString(article);
	   
           JSONObject myJson = new JSONObject(json); 
	   		  
		   System.out.println(myJson);
		   
		   schema.validate(myJson);
		   
	   }
	   catch(IOException e)
	   {
		   e.printStackTrace();
	   }
   }
}
