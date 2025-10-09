package report;

import delivery.DeliveryChannel;
import java.util.Objects;

public abstract class Report {

    protected final DeliveryChannel deliveryChannel;
    protected final String title;


    protected Report(String title, DeliveryChannel deliveryChannel) {
        this.title = Objects.requireNonNull(title, "Report title is required.");
        this.deliveryChannel = Objects.requireNonNull(deliveryChannel, "Delivery Channel cannot be null.");
    }


    public abstract void generateAndDeliver();

    protected void publish(String content) {
        System.out.println("--- Report Generation Complete ---");
        deliveryChannel.send(content, title);
    }
}
