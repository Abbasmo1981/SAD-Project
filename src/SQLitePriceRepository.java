package infrastructure;

import interfaces.IPriceRepository;
import model.PriceData;

import java.time.LocalDate;

public class SQLitePriceRepository implements IPriceRepository {

    @Override
    public void savePrices(PriceData data) {
        System.out.println("Saving prices for " + data.getSymbol() + " (simulated).");
    }

    @Override
    public PriceData loadPrices(String symbol, LocalDate start, LocalDate end) {
        System.out.println("No cached data found for " + symbol + " (simulated).");
        return null;
    }
}
