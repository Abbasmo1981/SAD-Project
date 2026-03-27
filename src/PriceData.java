package model;

import java.time.LocalDate;
import java.util.List;

public class PriceData {
    private final String symbol;
    private final List<Double> prices;
    private final List<LocalDate> dates;

    public PriceData(String symbol, List<Double> prices, List<LocalDate> dates) {
        this.symbol = symbol;
        this.prices = prices;
        this.dates = dates;
    }

    public String getSymbol() { return symbol; }
    public List<Double> getPrices() { return prices; }
    public List<LocalDate> getDates() { return dates; }
}
