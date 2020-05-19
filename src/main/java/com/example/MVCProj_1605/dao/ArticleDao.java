package com.example.MVCProj_1605.dao;


import com.example.MVCProj_1605.entity.Article;

import java.util.List;

public interface ArticleDao {
     Article save(Article article);
     List<Article> getAll();
     Article getById(Long id);
     List<Article> getAvailableArticle ();
     List<Article> getArticleOrderByPrice (boolean desc);
     void erase(Long id);
     List<Article> getBetweenPrice(Double min, Double max);
}

