package com.stockapp.api;

import java.util.List;

public interface IExternalStockApiClient {
    List<String> fetchPriceData(String symbol, String start, String end);
}
