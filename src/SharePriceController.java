package presentation;

import interfaces.IGetSharePrices;
import interfaces.ICompareShares;
import interfaces.IChartService;

import model.PriceData;
import model.ComparisonData;
import model.ChartData;

import java.time.LocalDate;

public class SharePriceController {

    private final IGetSharePrices getService;
    private final ICompareShares compareService;
    private final IChartService chartService;

    public SharePriceController(IGetSharePrices getService,
                                ICompareShares compareService,
                                IChartService chartService) {
        this.getService = getService;
        this.compareService = compareService;
        this.chartService = chartService;
    }

    public ChartData requestPrice(String symbol, LocalDate start, LocalDate end) {
        PriceData data = getService.getPriceHistory(symbol, start, end);
        return chartService.generateChart(data);
    }

    public ChartData comparePrices(String s1, String s2, LocalDate start, LocalDate end) {
        ComparisonData data = compareService.compareShares(s1, s2, start, end);
        return chartService.generateComparisonChart(data);
    }
}
