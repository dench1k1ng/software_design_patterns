package interfaces;

import stock.Stock;

public interface StockObserver {
    void update(Stock stock, double previousPrice);
}
