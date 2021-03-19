package com.activemq.demo.model;

import lombok.*;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * This is an entity class which declares the attributes for the Article
 * @author Ashwini.Sanas
 *This return statement gives a method call to findAll method in ArticleRepository class.
 */

@Entity
@Getter @Setter @ToString @Builder
@NoArgsConstructor @AllArgsConstructor 
@Table(name= "`Article`")
public class Article implements Serializable {
    @Id
    @Column(name = "article_id")
    private int articleId;
    
    @Column(name = "short_title")
    private String shortTitle;
    
    @Column(name = "title")
    private String title;

    @Column(name = "no_of_pages")
    private int noOfPages;

    @Column(name = "author_name")
    private String authorName;

    @Column(name = "author_email_address")
    private String authorEmailAddress;

    @Column(name = "is_active" ,nullable = false)
    private Boolean isActive;

    @Column(name = "is_published", nullable = false)
    private Boolean isPublished;

   
}

