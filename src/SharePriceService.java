package service;

import interfaces.IGetSharePrices;
import interfaces.ICompareShares;
import interfaces.IPriceDataProvider;
import interfaces.IPriceRepository;
import interfaces.IChartService;

import model.PriceData;
import model.ComparisonData;

import java.time.LocalDate;

public class SharePriceService implements IGetSharePrices, ICompareShares {

    private final IPriceDataProvider provider;
    private final IPriceRepository repository;
    private final IChartService chartService;

    public SharePriceService(IPriceDataProvider provider,
                             IPriceRepository repository,
                             IChartService chartService) {
        this.provider = provider;
        this.repository = repository;
        this.chartService = chartService;
    }

    @Override
    public PriceData getPriceHistory(String symbol, LocalDate start, LocalDate end) {
        PriceData data = repository.loadPrices(symbol, start, end);
        if (data == null) {
            data = provider.fetchPrices(symbol, start, end);
            repository.savePrices(data);
        }
        return data;
    }

    @Override
    public ComparisonData compareShares(String s1, String s2, LocalDate start, LocalDate end) {
        PriceData d1 = getPriceHistory(s1, start, end);
        PriceData d2 = getPriceHistory(s2, start, end);
        return new ComparisonData(d1, d2);
    }
}
