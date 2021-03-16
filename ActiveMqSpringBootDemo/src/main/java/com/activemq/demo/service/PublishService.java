package com.activemq.demo.service;

import java.util.stream.Collectors;
import org.everit.json.schema.ValidationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;

import com.activemq.demo.SchemaValidator;
import com.activemq.demo.exceptions.CustomSuccessResponse;
import com.activemq.demo.exceptions.InvalidInputException;
import com.activemq.demo.model.Article;
import com.activemq.demo.model.ArticleDto;


/**
 * This class is used to return the response for a valid/invalid post request.
 * @author Ashwini.Sanas
 *
 */
@Service
public class PublishService 

{
	 @Autowired
	 JmsTemplate jmsTemplate;
	 
	 
	 SchemaValidator schemaValidator=new SchemaValidator();

		@Value("${inbound.endpoint}")
		private String inboundEndpoint;

		/**
		 * 
		 * @param articleDto
		 * -This is an ArticleDto object.
		 * @return This return statement returns the response in case of a successful post request.
		 * @throws InvalidInputException
		 */

	    public ResponseEntity<CustomSuccessResponse> publishArticle(ArticleDto articleDto) throws InvalidInputException
	    {

	        try
	        {
	        	schemaValidator.validateArticle(articleDto);

	        	Article theArticle = Article.builder()
		                 .articleId((int) articleDto.getArticleId())
		                 .authorEmailAddress((String) articleDto.getAuthorEmailAddress())
		                 .isActive((boolean) articleDto.getIsActive())
		                 .authorName((String) articleDto.getAuthorName())
		                 .isPublished((boolean) articleDto.getIsPublished())
		                 .noOfPages((int) articleDto.getNoOfPages())
		                 .shortTitle((String) articleDto.getShortTitle())
		                 .title((String) articleDto.getTitle()).build();
		    	 
	                      jmsTemplate.convertAndSend(inboundEndpoint,theArticle);
	            
	                      CustomSuccessResponse responseSuccess=new CustomSuccessResponse();
	            
                          return new ResponseEntity<>(responseSuccess.returnResponse(), HttpStatus.OK);
	          
	        }
     
	        catch (ValidationException e) {
	        	  System.out.println(e.getMessage());
	        	  
	        	 String errors = e.getCausingExceptions().stream()
	                             .map(ValidationException::getMessage)
	                             .collect(Collectors.joining(","));
	        	  
	        	  System.out.println(errors);
	        	  
	              throw new InvalidInputException(errors, e);
	     
	        	 }
	    }


}
