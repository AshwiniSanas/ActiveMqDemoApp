package com.example.demo;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.jms.core.JmsTemplate;

import com.activemq.demo.exceptions.CustomSuccessResponse;
import com.activemq.demo.model.ArticleDto;
import com.activemq.demo.service.PublishService;

import static org.mockito.Mockito.*;


import static org.junit.jupiter.api.Assertions.*;


@SpringBootTest
class PublishServiceTest {

    private ArticleDto article;

    @Mock
    private JmsTemplate jmsTemplate;


//TODO
//Figure out why @Autowired is throwing error for Publicservices
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
           
    	   message = null;



    }

    @AfterEach
    void tearDown() {
        article = null;
    }

    @Test
    void publishArticle_returns_response_status_as_OK() throws Exception{

        doNothing().when(jmsTemplate).convertAndSend(message,article);
        ResponseEntity<CustomSuccessResponse> response = publishService.publishArticle(article);
        assertEquals(HttpStatus.OK,response.getStatusCode());
        verify(jmsTemplate,times(1)).convertAndSend(message,article);
    }

    @Test
    void publishArticle_returns_response_as_INTERNAL_SERVER_ERROR() throws Exception{
        doThrow(RuntimeException.class).when(jmsTemplate).convertAndSend(message,article);
        ResponseEntity<CustomSuccessResponse> response = publishService.publishArticle(article);
        assertEquals(HttpStatus.BAD_REQUEST,response.getStatusCode());
        verify(jmsTemplate,times(1)).convertAndSend(message,article);
    }
}
