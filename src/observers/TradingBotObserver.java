package observers;

import interfaces.StockObserver;
import stock.Stock;

public class TradingBotObserver implements StockObserver {
    private String botName;
    private double volatilityThreshold;

    public TradingBotObserver(String botName, double volatilityThreshold) {
        this.botName = botName;
        this.volatilityThreshold = volatilityThreshold;
    }

    @Override
    public void update(Stock stock, double previousPrice) {
        double currentPrice = stock.getPrice();
        double changePercent = Math.abs((currentPrice - previousPrice) / previousPrice) * 100;

        System.out.println("[" + botName + "] Processing " + stock.getSymbol() +
                " - Change: " + String.format("%.2f", changePercent) + "%");

        if (changePercent > volatilityThreshold) {
            System.out.println("⚡ [" + botName + "] HIGH VOLATILITY DETECTED! " +
                    stock.getSymbol() + " changed " + String.format("%.2f", changePercent) +
                    "% (threshold: " + volatilityThreshold + "%)");

            if (currentPrice > previousPrice) {
                System.out.println("[" + botName + "] Auto-executing MOMENTUM BUY strategy");
            } else {
                System.out.println("[" + botName + "] Auto-executing STOP-LOSS strategy");
            }
        }
    }

    public String getBotName() {
        return botName;
    }
}
