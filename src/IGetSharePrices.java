package interfaces;

import model.PriceData;
import java.time.LocalDate;

public interface IGetSharePrices {
    PriceData getPriceHistory(String symbol, LocalDate start, LocalDate end);
}
