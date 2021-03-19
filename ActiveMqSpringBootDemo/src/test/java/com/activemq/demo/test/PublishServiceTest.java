package com.activemq.demo.test;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.jms.core.JmsTemplate;

import com.activemq.demo.exceptions.CustomErrorResponse;
import com.activemq.demo.exceptions.CustomSuccessResponse;
import com.activemq.demo.exceptions.InvalidInputException;
import com.activemq.demo.model.ArticleDto;
import com.activemq.demo.service.PublishService;
import com.fasterxml.jackson.core.JsonProcessingException;

import static org.mockito.Mockito.*;


import static org.junit.jupiter.api.Assertions.*;


@SpringBootTest
class PublishServiceTest {

    private ArticleDto article;
    
    private ArticleDto article1;

    @Mock
    private JmsTemplate jmsTemplate;

    @InjectMocks
    private PublishService publishService = new PublishService();

    private  String message;

    @BeforeEach
    void setUp() {

    	   article = ArticleDto.builder()
                   .articleId(1)
                   .shortTitle("Physics I")
                   .title("hdh")
                   .noOfPages(100)
                   .authorName("sham")
                   .authorEmailAddress("sham@gmail.com")
                   .isActive(true)
                   .isPublished(true).build();            
           
    	   article1 = ArticleDto.builder()
                   .articleId(2)
                   .shortTitle(1)
                   .title("hdh")
                   .noOfPages(100)
                   .authorName("sham")
                   .authorEmailAddress("sham@gmail.com")
                   .isActive(true)
                   .isPublished(true).build();            
           
    	   message = null;



    }

    @AfterEach
    void tearDown() {
        article = null;
    }

    @Test
    void publishArticle_returns_response_status_as_OK() throws Exception{

        doNothing().when(jmsTemplate).convertAndSend(message,article);
        ResponseEntity<String> response = publishService.publishArticle(article);
        assertEquals(HttpStatus.OK,response.getStatusCode());
       //verify(jmsTemplate,times(1)).convertAndSend(message,article);
    }

    @Test
    void publishArticle_returns_response_as_INTERNAL_SERVER_ERROR() throws InvalidInputException, JsonProcessingException{
        doThrow(RuntimeException.class).when(jmsTemplate).convertAndSend(message,article);
        ResponseEntity<String> response = publishService.publishArticle(article);
        System.out.println(response.getStatusCode());
        assertEquals(HttpStatus.BAD_REQUEST,response.getStatusCode());
        verify(jmsTemplate,times(1)).convertAndSend(message,article);
    }
}
