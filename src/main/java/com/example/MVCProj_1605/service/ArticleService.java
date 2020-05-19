package com.example.MVCProj_1605.service;

import com.example.MVCProj_1605.dao.ArticleSpringJpaDao;
import com.example.MVCProj_1605.entity.Article;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ArticleService {
    ArticleSpringJpaDao articleDao;

    @Autowired
    public ArticleService(ArticleSpringJpaDao articleDao) {
        this.articleDao = articleDao;
    }


    public List<Article> getAllArticles() {
        List<Article> articles = (List<Article>) articleDao.findAll();
        return articles;
    }

    public List<Article> getAllArticlesByPriceBetween (Double lowPrice, Double highPrice) {
        List<Article> articles = articleDao.findAllByPriceBetween(lowPrice, highPrice);
        return articles;
    }
}
