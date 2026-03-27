package com.stockapp.api;

import java.util.ArrayList;
import java.util.List;

public class ExternalStockApiClient implements IExternalStockApiClient {

    @Override
    public List<String> fetchPriceData(String symbol, String start, String end) {
        System.out.println("Fetching data from external API...");
        return new ArrayList<>();
    }
}
