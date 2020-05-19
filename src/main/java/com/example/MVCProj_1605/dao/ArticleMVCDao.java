package com.example.MVCProj_1605.dao;

import com.example.MVCProj_1605.entity.Article;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.NoSuchElementException;

@Component
public class ArticleMVCDao implements ArticleDao{


    public static boolean desc;

    SessionFactory factory = new Configuration()
            .configure()
            .buildSessionFactory();

    public Article save(Article article) {
        Session session = factory.openSession();
        session.beginTransaction();
        session.save(article);
        session.getTransaction().commit();
        session.close();
        return article;
    }

    public List<Article> getAll() {
        Session session = factory.openSession();
        Query query = session.createQuery("FROM Article ");
        List<Article> result = query.list();
        session.close();
        return result;
    }

    public Article getById(Long id) {
        Session session = factory.openSession();
        session.beginTransaction();
        Article article = session.get(Article.class, id);
        session.getTransaction().commit();
        session.close();
        return article;
    }

    public List<Article> getAvailableArticle() {
        Session session = factory.openSession();
        Query query = session.createQuery("FROM Article WHERE quantity > 0");
        List<Article> result = query.list();
        session.close();
        return result;
    }

    @Override
    public List<Article> getArticleOrderByPrice(boolean desc) {
        this.desc = desc;
        Session session = factory.openSession();
        Query query = session.createQuery("FROM Article ");
        List<Article> result = query.list();
        Collections.sort(result);
        session.close();
        return result;
    }

    @Override
    public void erase(Long id) {
        Session session = factory.openSession();
        session.beginTransaction();
        Query query = session.createQuery("DELETE Article WHERE id=:article_id_param");
        query.setParameter("article_id_param", id);
        query.executeUpdate();
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public List<Article> getBetweenPrice(Double min, Double max) {
        List<Article> result = null;
        Session session = factory.openSession();
        Query queryAll = session.createQuery("FROM Article ");
        List<Article> listAll = queryAll.list();
        if (min != null || max != null) {
            if (min == null) {
                Article mininByPrice = listAll.stream().min(Comparator.comparing(Article::getPrice))
                        .orElseThrow(NoSuchElementException::new);
                min = mininByPrice.getPrice();
            }
            if (max == null) {
                Article mininByPrice = listAll.stream().max(Comparator.comparing(Article::getPrice))
                        .orElseThrow(NoSuchElementException::new);
                max = mininByPrice.getPrice();
            }
            Query query = session.createQuery("FROM Article WHERE price>=:low_price AND price<=:high_price");
            query.setParameter("low_price", min);
            query.setParameter("high_price", max);
            result = query.list();
            result.forEach(System.out::println);
        } else {
            System.out.println("NULL");
        }
        session.close();
        return result;
    }
}
