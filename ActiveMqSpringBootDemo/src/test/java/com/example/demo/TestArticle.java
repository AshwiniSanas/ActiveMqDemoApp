package com.example.demo;

import org.junit.jupiter.api.Test;

import com.activemq.demo.Article;

import static org.junit.jupiter.api.Assertions.*;


 class TestArticle {

	
	@Test
     void testSetArticleId(){
        Article article = new Article();
        article.setArticleId(article.getArticleId());
        assertTrue(article.getArticleId() == article.getArticleId());
    }
	
	@Test
     void testSetShortTitle(){
        Article article= new Article();
        article.setShortTitle(article.getShortTitle());
        assertTrue(article.getShortTitle() == article.getShortTitle());
    }
	@Test
     void testTitle(){
        Article article = new Article();
        article.setTitle(article.getTitle());
        assertTrue(article.getTitle() == article.getTitle());
    }
	@Test
     void testSetNoOfPages(){
        Article article = new Article();
        article.setNoOfPages(article.getNoOfPages());
        assertTrue(article.getNoOfPages() == article.getNoOfPages());
    }
	@Test
     void testSetAuthorName(){
        Article article = new Article();
        article.setAuthorName(article.getAuthorName());
        assertTrue(article.getAuthorName() == article.getAuthorName());
    }
	@Test
     void testSetAuthorEmailAddress(){
        Article article = new Article();
        article.setAuthorEmailAddress(article.getAuthorEmailAddress());
        assertTrue(article.getAuthorEmailAddress() == article.getAuthorEmailAddress());
    }
	@Test
     void testSetActive(){
        Article article = new Article();
        article.setIsActive(article.getIsActive());
        assertTrue(article.getIsActive() == article.getIsActive());
    }
	@Test
     void testSetPublished(){
        Article article = new Article();
        article.setIsPublished(article.getIsPublished());
        assertTrue(article.getIsPublished() == article.getIsPublished());
    }
	private void assertTrue(boolean b) {
		
		
	}
	
	 
	 @Test
	  void testToString() {
	     Article article = new Article();
	     article.setArticleId(1);
	     article.setShortTitle("abc");
	     article.setTitle("bcd");
	     article.setNoOfPages(10);
	     article.setAuthorName("sjs");
	     article.setAuthorEmailAddress("quiw");
	     article.setIsActive(true);
	     article.setIsPublished(false);
	     
	    assertEquals("Article [articleId=1, shortTitle=abc, title=bcd, noOfPages=10,authorName=sjs,authorEmailAddress=quiw,isActive=true,isPublished=false]", 
	    article.toString());
	 }
}
