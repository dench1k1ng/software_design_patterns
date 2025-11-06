package subject;

import stock.Stock;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import interfaces.StockObserver;

public class StockMarket {
    private Map<String, List<StockObserver>> observers = new HashMap<>();
    private Map<String, Stock> stocks = new HashMap<>();

    public void addStock(Stock stock) {
        stocks.put(stock.getSymbol(), stock);
        observers.put(stock.getSymbol(), new ArrayList<>());
        System.out.println(" Stock added to market: " + stock);
    }

    public void subscribe(String stockSymbol, StockObserver observer) {
        List<StockObserver> stockObservers = observers.get(stockSymbol);
        if (stockObservers != null) {
            stockObservers.add(observer);
            System.out.println(" New observer subscribed to " + stockSymbol);
        } else {
            System.out.println(" Stock " + stockSymbol + " not found in market");
        }
    }

    public void unsubscribe(String stockSymbol, StockObserver observer) {
        List<StockObserver> stockObservers = observers.get(stockSymbol);
        if (stockObservers != null) {
            stockObservers.remove(observer);
            System.out.println(" Observer unsubscribed from " + stockSymbol);
        }
    }

    public void updateStockPrice(String stockSymbol, double newPrice) {
        Stock stock = stocks.get(stockSymbol);
        if (stock != null) {
            double previousPrice = stock.getPrice();
            stock.setPrice(newPrice);

            System.out.println(" PRICE UPDATE: " + stock + " (was $" + String.format("%.2f", previousPrice) + ")");

            notifyObservers(stockSymbol, stock, previousPrice);
        } else {
            System.out.println(" Stock " + stockSymbol + " not found");
        }
    }

    private void notifyObservers(String stockSymbol, Stock stock, double previousPrice) {
        List<StockObserver> stockObservers = observers.get(stockSymbol);
        for (StockObserver observer : stockObservers) {
            observer.update(stock, previousPrice);
        }
    }

    public void displayMarket() {
        System.out.println("\n CURRENT MARKET STATUS:");
        for (Stock stock : stocks.values()) {
            System.out.println(stock);
        }
    }
}
