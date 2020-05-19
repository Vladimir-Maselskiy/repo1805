package com.example.MVCProj_1605.dao;

import com.example.MVCProj_1605.entity.Article;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ArticleSpringJpaDao extends CrudRepository<Article, Long> {

    Article getById(Long id);
    List<Article> findAllByPriceBetween(Double lowPrice, Double highPrice);



}
