package com.example.MVCProj_1605.dto;

import org.springframework.stereotype.Component;

@Component
public class ArticleParams {
    private Double lowPrice;
    private Double highPrice;

    public ArticleParams(Double lowPrice, Double highPrice) {
        this.lowPrice = lowPrice;
        this.highPrice = highPrice;
    }

    public ArticleParams() {
    }

    public Double getLowPrice() {
        return lowPrice;
    }

    public void setLowPrice(Double lowPrice) {
        this.lowPrice = lowPrice;
    }

    public Double getHighPrice() {
        return highPrice;
    }

    public void setHighPrice(Double highPrice) {
        this.highPrice = highPrice;
    }
}
