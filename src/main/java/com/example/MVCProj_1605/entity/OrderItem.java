package com.example.MVCProj_1605.entity;

import javax.persistence.*;

@Entity
@Table (name = "`order_item`")
public class OrderItem {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)

    private Long id;
    @ManyToOne (fetch = FetchType.EAGER, cascade = CascadeType.ALL, optional = false)
    @JoinColumn (name = "article_id")
    private Article article;
    private Integer quantity;

    public OrderItem() {
    }

    public OrderItem(Article article, Integer quantity) {
        this.article = article;
        this.quantity = quantity;
    }

    public Article getArticle() {
        return article;
    }

    public void setArticle(Article article) {
        this.article = article;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }



    @Override
    public String toString() {
        return "OrderItem{" +
                "article=" + article +
                ", quantity=" + quantity +
                '}';
    }
}
