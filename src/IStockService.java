package com.example.app;

public class Main {

    public static void main(String[] args) {

        YahooApi api = new YahooApi();
        IBrowserView browser = new BrowserView();
        IPriceRepository repo = new PriceRepository();
        IChartService chart = new ChartService();
        CompareService compare = new CompareService();
        SharePriceService share = new SharePriceService();

        // Fetch prices
        IPriceData aapl = api.getPrice("AAPL");
        IPriceData msft = api.getPrice("MSFT");

        // Save to repository
        repo.save(aapl);
        repo.save(msft);

        // Display in browser
        browser.showMessage("Fetched prices for AAPL and MSFT");

        // Draw chart
        chart.drawChart(aapl);

        // Compare
        compare.compare(aapl, msft);

        // Share
        share.share(aapl);

        browser.showMessage("Done.");
    }
}
