package com.sample.springbootsampleapp.web;

import com.sample.springbootsampleapp.domain.Article;
import com.sample.springbootsampleapp.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ArticleController {
    @Autowired
    private ArticleService articleService;

    @RequestMapping(value="/create", method=RequestMethod.POST)
    public ResponseEntity<String> save(@RequestBody ArticleRequest articleRequest) {
        try {
            Long res = articleService.save(articleRequest);
            return new ResponseEntity<>("SUCCESS", HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("ERROR", HttpStatus.OK);
        }
    }

    @RequestMapping(value="/", method=RequestMethod.GET)
    public ResponseEntity<List<Article>> findAll() {
        return new ResponseEntity<>(articleService.findAllByOrderByIdDesc(), HttpStatus.OK);
    }

    @RequestMapping(value="/article/{id}", method=RequestMethod.GET)
    public ResponseEntity<Article> findArticleById(@PathVariable("id") Long id) {
        return new ResponseEntity<>(articleService.findArticleById(id), HttpStatus.OK);
    }

    @RequestMapping(value="/delete/{id}", method=RequestMethod.DELETE)
    public ResponseEntity<String> delete(@PathVariable("id") Long id) {
        try {
            articleService.delete(id);
            return new ResponseEntity<>("SUCCESS", HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("Error", HttpStatus.OK);
        }
    }

    @RequestMapping(value="/update", method=RequestMethod.PUT)
    public ResponseEntity<String> update(@RequestBody ArticleRequest articleRequest) {
        articleService.save(articleRequest);
        return new ResponseEntity<>("SUCCESS", HttpStatus.OK);
    }
}
