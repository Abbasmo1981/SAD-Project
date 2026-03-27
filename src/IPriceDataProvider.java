package interfaces;

import model.PriceData;
import java.time.LocalDate;

public interface IPriceDataProvider {
    PriceData fetchPrices(String symbol, LocalDate start, LocalDate end);
}
