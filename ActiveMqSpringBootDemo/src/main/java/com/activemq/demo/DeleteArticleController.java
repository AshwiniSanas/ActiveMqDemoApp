package com.activemq.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * This class defines rest endpoint for deleting an article
 * @author Ashwini.Sanas
 *
 */
@RestController
public class DeleteArticleController 
{
	
	 @Autowired
	 ArticleService articleService;
	
	 
	 /**
	  * 
	  * @param id
	  * @return This return statement gives a method call for deleteById method in ArticleService class.
	  * @throws ArticleIdNotFoundException
	  */
	 
	@DeleteMapping("/articles/{id}")
	public ResponseEntity<String> deleteArticle(@PathVariable int id) throws ArticleIdNotFoundException {
		return articleService.deleteById(id);
	}

}
