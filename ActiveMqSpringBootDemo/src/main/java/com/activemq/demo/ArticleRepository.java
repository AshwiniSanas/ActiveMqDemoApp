package com.activemq.demo;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

/**
 * This is a repository class extending JpaRepository Interface.
 * @author Ashwini.Sanas
 *
 */

@Repository
public interface ArticleRepository extends JpaRepository<Article,Integer>{

	}
