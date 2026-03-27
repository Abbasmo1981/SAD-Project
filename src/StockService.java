package com.stockapp.service;

import com.stockapp.api.IExternalStockApiClient;
import com.stockapp.repository.IStockRepository;
import com.stockapp.validation.IDateRangeValidator;

import java.util.List;

public class StockService implements IStockService {

    private final IDateRangeValidator validator;
    private final IExternalStockApiClient apiClient;
    private final IStockRepository repository;

    private boolean offlineMode = false;

    public StockService(IDateRangeValidator validator,
                        IExternalStockApiClient apiClient,
                        IStockRepository repository) {
        this.validator = validator;
        this.apiClient = apiClient;
        this.repository = repository;
    }

    @Override
    public void handleSearch(String symbol, String start, String end) {

        if (!validator.isValidRange(start, end)) {
            System.out.println("Invalid date range. Max 2 years allowed.");
            return;
        }

        if (!offlineMode) {
            List<String> prices = apiClient.fetchPriceData(symbol, start, end);
            repository.storePriceData(prices);
        }

        List<String> storedData = repository.retrievePriceData(symbol, start, end);
        displayChart(storedData);
    }

    @Override
    public void compareCompanies(String symbol1, String symbol2) {
        System.out.println("Comparing " + symbol1 + " vs " + symbol2);
    }

    @Override
    public void enableOfflineMode() {
        offlineMode = true;
        System.out.println("Offline mode enabled.");
    }

    private void displayChart(List<String> data) {
        System.out.println("Displaying price chart...");
    }
}
