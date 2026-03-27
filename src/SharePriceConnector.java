package service;

import interfaces.IPriceDataProvider;
import interfaces.IPriceRepository;
import interfaces.IChartService;
import interfaces.IGetSharePrices;
import interfaces.ICompareShares;

import model.ChartData;
import model.PriceData;
import model.ComparisonData;

import java.time.LocalDate;

public class SharePriceConnector {

    private final IPriceDataProvider provider;
    private final IPriceRepository repository;
    private final IChartService chartService;
    private final IGetSharePrices getService;
    private final ICompareShares compareService;

    public SharePriceConnector(IPriceDataProvider provider,
                               IPriceRepository repository,
                               IChartService chartService,
                               IGetSharePrices getService,
                               ICompareShares compareService) {
        this.provider = provider;
        this.repository = repository;
        this.chartService = chartService;
        this.getService = getService;
        this.compareService = compareService;
    }

    public ChartData getChart(String symbol, LocalDate start, LocalDate end) {
        PriceData data = getService.getPriceHistory(symbol, start, end);
        return chartService.generateChart(data);
    }

    public ChartData compareCharts(String s1, String s2, LocalDate start, LocalDate end) {
        ComparisonData data = compareService.compareShares(s1, s2, start, end);
        return chartService.generateComparisonChart(data);
    }
}
