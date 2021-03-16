package com.activemq.demo;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.annotations.ApiIgnore;

@RestController
public class ArticleController
{
    @Autowired
    ArticleService articleService;
    
    /**
     * @return Returns the method call for findAll method in ArticleService class
     */
    
    @GetMapping("/articles")
    public List<Article> findAll()
    {
    	return articleService.findAll();
    }
    
    /** 
     * @param id
     * -This variable holds the value for articleId 
     * @return Returns the method call for findById method in ArticleService class
     */
    
    @GetMapping("/articles/{id}")
    public Article findById(@PathVariable int id) 
    {
    	return articleService.findById(id);
    }
    
   /* @ApiIgnore
    @PostMapping("/articles")
    public void save(@RequestBody ArticleDto article)
    {
    	Article theArticle=new Article();
    	theArticle.setArticleId(article.getArticleId());
    	theArticle.setShortTitle(article.getShortTitle());
    	theArticle.setTitle(article.getTitle());
    	theArticle.setNoOfPages(article.getNoOfPages());
    	theArticle.setAuthorName(article.getAuthorName());
    	theArticle.setAuthorEmailAddress(article.getAuthorEmailAddress());
    	theArticle.setActive(article.isActive());
    	theArticle.setPublished(article.isPublished());
    	articleService.save(theArticle);
    	       
    }*/
    
    
    /**
     * @param article
     *  -This is ArticleDto Object which carries the values for attributes
     * @return Returns the method call for save method in ArticleService class
     */
    
    @ApiIgnore
    @PostMapping("/articles")
    public  ResponseEntity<String> save(@RequestBody ArticleDto article) 
    {
        Article theArticle = Article.builder()
                .articleId((int) article.getArticleId())
                .authorEmailAddress((String) article.getAuthorEmailAddress())
                .isActive((boolean) article.getIsActive())
                .authorName((String) article.getAuthorName())
                .isPublished((boolean) article.getIsPublished())
                .noOfPages((int) article.getNoOfPages())
                .shortTitle((String) article.getShortTitle())
                .title((String) article.getTitle()).build();
        
                 return articleService.save(theArticle);
    }

}
