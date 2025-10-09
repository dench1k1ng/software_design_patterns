package report;

import delivery.DeliveryChannel;


public final class FinancialReport extends Report {

    private final int fiscalYear;

    public FinancialReport(String title, DeliveryChannel channel, int fiscalYear) {
        super(title, channel);
        if (fiscalYear < 2000 || fiscalYear > 2050) {
            throw new IllegalArgumentException("Invalid fiscal year.");
        }
        this.fiscalYear = fiscalYear;
    }


    private String generateFinancialData() {
        // Complex data calculation logic goes here...
        return String.format(
                "Financial Data for FY%d:\n" +
                        "  - Revenue: $1.2M\n" +
                        "  - Expenses: $0.8M\n" +
                        "  - Net Profit: $0.4M",
                fiscalYear
        );
    }

    @Override
    public void generateAndDeliver() {
        System.out.println("STATUS: Calculating financial metrics...");
        String data = generateFinancialData();

        publish(data);
    }
}
