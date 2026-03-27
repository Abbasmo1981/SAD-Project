package infrastructure;

import interfaces.IPriceDataProvider;
import model.PriceData;

import java.time.LocalDate;
import java.util.Arrays;

public class YahooApi implements IPriceDataProvider {

    @Override
    public PriceData fetchPrices(String symbol, LocalDate start, LocalDate end) {
        return new PriceData(
                symbol,
                Arrays.asList(100.0, 102.5, 101.0),
                Arrays.asList(start, start.plusDays(1), start.plusDays(2))
        );
    }
}
