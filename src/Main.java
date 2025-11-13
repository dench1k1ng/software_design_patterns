import subject.StockMarket;
import stock.Stock;
import observers.InvestorObserver;
import observers.TradingBotObserver;
import observers.NewsReporterObserver;

public class Main {
    public static void main(String[] args) {
        StockMarket market = new StockMarket();

        Stock apple = new Stock("AAPL", "Apple Inc.", 150.00);
        Stock tesla = new Stock("TSLA", "Tesla Inc.", 200.00);
        Stock amazon = new Stock("AMZN", "Amazon.com Inc.", 3500.00);

        market.addStock(apple);
        market.addStock(tesla);
        market.addStock(amazon);

        InvestorObserver johnInvestor = new InvestorObserver("John Smith", 145.00, 160.00);
        InvestorObserver aliceInvestor = new InvestorObserver("Alice Johnson", 190.00, 220.00);

        TradingBotObserver momentumBot = new TradingBotObserver("MomentumBot-v2", 3.0);
        TradingBotObserver arbitrageBot = new TradingBotObserver("ArbitrageBot-Pro", 5.0);

        NewsReporterObserver cnnReporter = new NewsReporterObserver("CNN Business");
        NewsReporterObserver bloombergReporter = new NewsReporterObserver("Bloomberg");

        System.out.println("\n SETTING UP SUBSCRIPTIONS...");
        market.subscribe("AAPL", johnInvestor);
        market.subscribe("AAPL", momentumBot);
        market.subscribe("AAPL", cnnReporter);

        market.subscribe("TSLA", aliceInvestor);
        market.subscribe("TSLA", arbitrageBot);
        market.subscribe("TSLA", bloombergReporter);

        market.subscribe("AMZN", johnInvestor);
        market.subscribe("AMZN", momentumBot);
        market.subscribe("AMZN", cnnReporter);

        market.displayMarket();

        System.out.println("STARTING TRADING SESSION...\n");

        market.updateStockPrice("AAPL", 144.50);
        System.out.println();

        market.updateStockPrice("TSLA", 215.00);
        System.out.println();

        market.updateStockPrice("AMZN", 3520.00);
        System.out.println();

        market.updateStockPrice("AAPL", 162.00);
        System.out.println();

        market.updateStockPrice("TSLA", 185.00);
        System.out.println();

        market.displayMarket();

        System.out.println("TRADING SESSION COMPLETE!");
    }
}
