package observers;

import interfaces.StockObserver;
import stock.Stock;

public class InvestorObserver implements StockObserver {
    private String investorName;
    private double targetBuyPrice;
    private double targetSellPrice;

    public InvestorObserver(String investorName, double targetBuyPrice, double targetSellPrice) {
        this.investorName = investorName;
        this.targetBuyPrice = targetBuyPrice;
        this.targetSellPrice = targetSellPrice;
    }

    @Override
    public void update(Stock stock, double previousPrice) {
        double currentPrice = stock.getPrice();
        String direction = currentPrice > previousPrice ? "UP" : "DOWN";
        double change = Math.abs(currentPrice - previousPrice);
        double changePercent = (change / previousPrice) * 100;

        System.out.println("[" + investorName + "] Alert for " + stock.getSymbol() +
                " - " + direction + " $" + String.format("%.2f", change) +
                " (" + String.format("%.1f", changePercent) + "%)");

        // Trading logic
        if (currentPrice <= targetBuyPrice && previousPrice > targetBuyPrice) {
            System.out.println("[" + investorName + "] BUY SIGNAL! " + stock.getSymbol() +
                    " hit target buy price: $" + String.format("%.2f", targetBuyPrice));
        } else if (currentPrice >= targetSellPrice && previousPrice < targetSellPrice) {
            System.out.println("[" + investorName + "] SELL SIGNAL! " + stock.getSymbol() +
                    " hit target sell price: $" + String.format("%.2f", targetSellPrice));
        }
    }

    public String getInvestorName() {
        return investorName;
    }
}
