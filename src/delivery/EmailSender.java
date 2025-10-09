package delivery;

public final class EmailSender implements DeliveryChannel {
    private final String recipient;

    public EmailSender(String recipient) {
        if (recipient == null || !recipient.contains("@")) {
            throw new IllegalArgumentException("Invalid recipient address.");
        }
        this.recipient = recipient;
    }

    @Override
    public void send(String content, String title) {
        System.out.println("--- Email Delivery ---");
        System.out.println("STATUS: Sending report '" + title + "' to " + recipient + ".");
        System.out.println("BODY:\n" + content);
        System.out.println("----------------------\n");
    }
}
