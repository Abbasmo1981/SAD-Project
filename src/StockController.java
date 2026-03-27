package com.stockapp.controller;

import com.stockapp.api.ExternalStockApiClient;
import com.stockapp.api.IExternalStockApiClient;
import com.stockapp.repository.IStockRepository;
import com.stockapp.repository.StockRepository;
import com.stockapp.service.IStockService;
import com.stockapp.service.StockService;
import com.stockapp.validation.DateRangeValidator;
import com.stockapp.validation.IDateRangeValidator;

public class StockController {

    private final IStockService stockService;

    public StockController() {
        IDateRangeValidator validator = new DateRangeValidator();
        IExternalStockApiClient apiClient = new ExternalStockApiClient();
        IStockRepository repository = new StockRepository();

        this.stockService = new StockService(validator, apiClient, repository);
    }

    public void searchSharePrice(String symbol, String startDate, String endDate) {
        stockService.handleSearch(symbol, startDate, endDate);
    }

    public void compareCompanies(String symbol1, String symbol2) {
        stockService.compareCompanies(symbol1, symbol2);
    }

    public void handleOfflineMode() {
        stockService.enableOfflineMode();
    }
}
