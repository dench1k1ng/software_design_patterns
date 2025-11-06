package observers;

import stock.Stock;
import java.text.SimpleDateFormat;
import java.util.Date;

import interfaces.StockObserver;

public class NewsReporterObserver implements StockObserver {
    private String newsAgency;

    public NewsReporterObserver(String newsAgency) {
        this.newsAgency = newsAgency;
    }

    @Override
    public void update(Stock stock, double previousPrice) {
        double currentPrice = stock.getPrice();
        double change = currentPrice - previousPrice;
        double changePercent = (change / previousPrice) * 100;
        String timestamp = new SimpleDateFormat("HH:mm:ss").format(new Date());

        String headline = generateHeadline(stock, change, changePercent);

        System.out.println("[" + newsAgency + " - " + timestamp + "] " + headline);

        // Report significant changes
        if (Math.abs(changePercent) > 5) {
            System.out.println("[" + newsAgency + "] BREAKING NEWS: " + stock.getName() +
                    " experiences " + (change > 0 ? "surge" : "drop") + " of " +
                    String.format("%.1f", Math.abs(changePercent)) + "%!");
        }
    }

    private String generateHeadline(Stock stock, double change, double changePercent) {
        String direction = change > 0 ? "gains" : "falls";
        String sign = change > 0 ? "UP!" : "DOWN!";

        return sign + " " + stock.getName() + " " + direction + " " +
                String.format("%.1f", Math.abs(changePercent)) + "% to $" +
                String.format("%.2f", stock.getPrice());
    }

    public String getNewsAgency() {
        return newsAgency;
    }
}
