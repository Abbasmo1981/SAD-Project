package com.stockapp.repository;

import java.util.List;

public interface IStockRepository {
    void storePriceData(List<String> prices);
    List<String> retrievePriceData(String symbol, String start, String end);
}
