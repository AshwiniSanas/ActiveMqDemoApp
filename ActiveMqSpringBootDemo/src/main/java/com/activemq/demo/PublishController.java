package com.activemq.demo;


import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * This class is used to expose the rest  endpoint for publishing an article.
 * @author Ashwini.Sanas
 *
 */
@RequestMapping("/publisher")
@RestController
public class PublishController {
	
	
	@Autowired
	PublishService publishService;

         /**
          * 
          * @param article
          * -This is ArticleDto object
          * @return This return statement gives a method call to the publishArticle method of PublishService class.
          * @throws InvalidInputException
          */
	    @PostMapping("/articles")
	    public ResponseEntity<CustomSuccessResponse> publishArticle(@RequestBody ArticleDto article) throws InvalidInputException
	    {
	    	
                  return publishService.publishArticle(article);

        }
		
		
}

	

	

