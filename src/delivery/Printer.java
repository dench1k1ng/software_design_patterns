package delivery;

public final class Printer implements DeliveryChannel {
    private final String printerName;

    public Printer(String printerName) {
        if (printerName == null || printerName.isBlank()) {
            throw new IllegalArgumentException("Printer name cannot be blank.");
        }
        this.printerName = printerName;
    }

    @Override
    public void send(String content, String title) {
        System.out.println("--- Hardcopy Printout ---");
        System.out.println("STATUS: Printing report '" + title + "' on printer [" + printerName + "].");
        System.out.println("CONTENT:\n" + content);
        System.out.println("-------------------------\n");
    }
}
