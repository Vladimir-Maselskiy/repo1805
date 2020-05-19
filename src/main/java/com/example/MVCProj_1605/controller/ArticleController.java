package com.example.MVCProj_1605.controller;

import com.example.MVCProj_1605.dto.ArticleParams;
import com.example.MVCProj_1605.entity.Article;
import com.example.MVCProj_1605.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import java.util.Comparator;
import java.util.List;
import java.util.NoSuchElementException;

@Controller
public class ArticleController {

    private ArticleService articleService;

    @Autowired
    public ArticleController(ArticleService articleService) {
        this.articleService = articleService;
    }

    @GetMapping("/article")
    public String getAll(Model model, @ModelAttribute ArticleParams articleParams) {
        model.addAttribute("articleParams", articleParams);
        List<Article> allArticles = articleService.getAllArticles();
        if (articleParams.getHighPrice() == null) {
            Article max =  allArticles.stream().max(Comparator.comparing(Article::getPrice))
                    .orElseThrow(NoSuchElementException::new);
            articleParams.setHighPrice(max.getPrice());
        }
        if (articleParams.getLowPrice() == null) {
            Article min =  allArticles.stream().min(Comparator.comparing(Article::getPrice))
                    .orElseThrow(NoSuchElementException::new);
            articleParams.setLowPrice(min.getPrice());
        }

        model.addAttribute("all_articles", articleService.getAllArticlesByPriceBetween(articleParams.getLowPrice()
                , articleParams.getHighPrice()));
        return "allarticles";
    }
}
