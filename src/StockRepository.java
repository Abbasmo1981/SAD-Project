package com.stockapp.repository;

import java.util.ArrayList;
import java.util.List;

public class StockRepository implements IStockRepository {

    @Override
    public void storePriceData(List<String> prices) {
        System.out.println("Storing data in local database...");
    }

    @Override
    public List<String> retrievePriceData(String symbol, String start, String end) {
        System.out.println("Retrieving stored data...");
        return new ArrayList<>();
    }
}
