package com.sample.springbootsampleapp.service;

import com.sample.springbootsampleapp.domain.Article;
import com.sample.springbootsampleapp.web.ArticleRequest;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ArticleService {

    @Autowired
    private ArticleRepository articleRepository;

    public Long save(ArticleRequest articleRequest) {
        Article article = new Article();
        BeanUtils.copyProperties(articleRequest, article);
        article = articleRepository.save(article);
        return article.getId();
    }

    public List<Article> findAllByOrderByIdDesc() {
        return articleRepository.findAllByOrderByIdDesc();
    }

    public Article findArticleById(Long id) {
        return articleRepository.findArticleById(id);
    }

    public void delete(Long id) {
        articleRepository.deleteById(id);
    }
}
