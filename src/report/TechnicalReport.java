package report;

import delivery.DeliveryChannel;


public final class TechnicalReport extends Report {

    private final String projectName;

    public TechnicalReport(String title, DeliveryChannel channel, String projectName) {
        super(title, channel);
        this.projectName = projectName;
    }


    private String generateTechnicalData() {
        return String.format(
                "Technical Summary for Project %s:\n" +
                        "  - Bugs Fixed: 15\n" +
                        "  - Test Coverage: 85%%\n" +
                        "  - Uptime Last Month: 99.99%%",
                projectName
        );
    }

    @Override
    public void generateAndDeliver() {
        System.out.println("STATUS: Aggregating technical metrics...");
        String data = generateTechnicalData();

        publish(data);
    }
}
