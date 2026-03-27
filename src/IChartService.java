package interfaces;

import model.ChartData;
import model.ComparisonData;
import model.PriceData;

public interface IChartService {
    ChartData generateChart(PriceData data);
    ChartData generateComparisonChart(ComparisonData data);
}
