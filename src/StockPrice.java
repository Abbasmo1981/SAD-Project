package com.stockapp.model;

import java.time.LocalDate;

public class StockPrice {

    private String symbol;
    private LocalDate date;
    private double price;

    public StockPrice(String symbol, LocalDate date, double price) {
        this.symbol = symbol;
        this.date = date;
        this.price = price;
    }

    public String getSymbol() { return symbol; }
    public LocalDate getDate() { return date; }
    public double getPrice() { return price; }
}
