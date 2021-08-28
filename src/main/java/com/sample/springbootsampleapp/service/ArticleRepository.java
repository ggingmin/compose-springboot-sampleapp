package com.sample.springbootsampleapp.service;

import com.sample.springbootsampleapp.domain.Article;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ArticleRepository extends JpaRepository<Article, Long> {

    public Article findByAuthor(String author);

    public List<Article> findAllByOrderByIdDesc();

    public Article findArticleById(Long id);
}
