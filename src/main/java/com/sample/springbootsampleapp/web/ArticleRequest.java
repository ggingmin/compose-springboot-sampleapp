package com.sample.springbootsampleapp.web;

import lombok.Getter;
import lombok.Setter;

@Setter @Getter
public class ArticleRequest {
    private Long id;
    private String author;
    private String title;
    private String body;
}
