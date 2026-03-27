package interfaces;

import model.PriceData;
import java.time.LocalDate;

public interface IPriceRepository {
    void savePrices(PriceData data);
    PriceData loadPrices(String symbol, LocalDate start, LocalDate end);
}
