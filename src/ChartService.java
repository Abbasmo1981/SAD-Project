package infrastructure;

import interfaces.IChartService;
import model.ChartData;
import model.ComparisonData;
import model.PriceData;

public class ChartService implements IChartService {

    @Override
    public ChartData generateChart(PriceData data) {
        return new ChartData("Price chart for " + data.getSymbol(), data.getPrices());
    }

    @Override
    public ChartData generateComparisonChart(ComparisonData data) {
        return new ChartData(
                "Comparison: " + data.getCompany1().getSymbol() + " vs " + data.getCompany2().getSymbol(),
                data.getCompany1().getPrices()
        );
    }
}
