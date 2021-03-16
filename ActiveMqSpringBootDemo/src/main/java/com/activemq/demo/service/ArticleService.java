package com.activemq.demo.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.activemq.demo.exceptions.ArticleIdNotFoundException;
import com.activemq.demo.model.Article;
import com.activemq.demo.repository.ArticleRepository;

@Service
public class ArticleService

{
	@Autowired
	 private ArticleRepository articleRepository;
	
	@Autowired
	JmsTemplate jmsTemplate;
	
	@Value("${inbound.endpoint}")
	private String inboundEndpoint;

	/**
	 * 
	 * @return This return statement gives a method call to findAll method in ArticleRepository class.
	 */
	
	@Transactional
	public List<Article> findAll() {
		
		return articleRepository.findAll();
	}

	/**
	 * 
	 * @param articleId
	 * -This variable holds the value for articleId
	 * @return This return statement gives a method call to findById method in ArticleRepository class.
	 * @throws ArticleIdNotFoundException
	 */
	
	@Transactional
	public Article findById(int articleId)  {
		
		   return articleRepository.findById(articleId).orElseThrow(()-> new ArticleIdNotFoundException(articleId));
		}

	
	/**
	 * 
	 * @param articleId
	 * -This variable holds the value for articleId
	 * @return This return statement receives response in a string format.
	 * @throws ArticleIdNotFoundException
	 */
	
    @Transactional
	public ResponseEntity<String> deleteById(int articleId) 
    {
		
    	 try
         {
    		 articleRepository.deleteById(articleId);
             return new ResponseEntity<>("deleted", HttpStatus.OK);
         }
         catch (Exception e)
         {
        	
            throw new ArticleIdNotFoundException(articleId);	
            //return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
         }
         
	}

    /**
     * 
     * @param article
     * -This is an article object to be saved in the database.
     * @return This return statement receives response in a string format
     * @throws Exception
     */
    
    @Transactional
    public  ResponseEntity<String> save(Article article) 
    {
        try
        {
        	articleRepository.save(article);
            return new ResponseEntity<>("saved", HttpStatus.OK);
        }
        catch (Exception e)
        {
        	 return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
        
        
    }
}
