import infrastructure.YahooApi;
import infrastructure.SQLitePriceRepository;
import infrastructure.ChartService;

import interfaces.IPriceDataProvider;
import interfaces.IPriceRepository;
import interfaces.IChartService;

import service.SharePriceService;
import service.SharePriceConnector;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {

        IPriceDataProvider provider = new YahooApi();
        IPriceRepository repository = new SQLitePriceRepository();
        IChartService chartService = new ChartService();

        SharePriceService service =
                new SharePriceService(provider, repository, chartService);

        SharePriceConnector connector =
                new SharePriceConnector(provider, repository, chartService, service, service);

        connector.getChart("AAPL",
                LocalDate.now().minusDays(5),
                LocalDate.now());

        System.out.println("Share price workflow executed successfully.");
    }
}
