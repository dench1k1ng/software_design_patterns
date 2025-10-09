package report;

import delivery.DeliveryChannel;
import java.util.Objects;

public abstract class Report {

    // Composition: Holds the implementor interface, achieving decoupling.
    protected final DeliveryChannel deliveryChannel;
    protected final String title;


    protected Report(String title, DeliveryChannel deliveryChannel) {
        this.title = Objects.requireNonNull(title, "Report title is required.");
        // Report depends on the interface, not a concrete delivery class.
        this.deliveryChannel = Objects.requireNonNull(deliveryChannel, "Delivery Channel cannot be null.");
    }


    public abstract void generateAndDeliver();

    protected void publish(String content) {
        System.out.println("--- Report Generation Complete ---");
        // Bridge: Delegate the implementation detail to the delivery channel
        deliveryChannel.send(content, title);
    }
}
