package com.activemq.demo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * This class declares the attributes for the ArticleDto
 * @author Ashwini.Sanas
 
 */

@Getter@Setter
@Builder
@NoArgsConstructor @AllArgsConstructor
public class ArticleDto 
{
	private Object articleId;
	
    private Object shortTitle;
	
	private Object title;
	
	private Object noOfPages;
	
	private Object authorName;
	
	private Object authorEmailAddress;
	
	private Object isActive;
	
	private Object isPublished;
	
}
