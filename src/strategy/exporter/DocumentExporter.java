package strategy.exporter;

import strategy.model.Document;
import strategy.strategies.ExportStrategy;

public class DocumentExporter {
    private ExportStrategy exportStrategy;

    public DocumentExporter() {
    }

    public DocumentExporter(ExportStrategy exportStrategy) {
        this.exportStrategy = exportStrategy;
    }

    public void setExportStrategy(ExportStrategy exportStrategy) {
        this.exportStrategy = exportStrategy;
    }

    public void exportDocument(Document document) {
        if (exportStrategy == null) {
            System.out.println("Error: No export strategy selected!");
            return;
        }

        System.out.println("Starting export process...");
        System.out.println("Format: " + exportStrategy.getFormatName());
        System.out.println();
        exportStrategy.export(document);
    }
}
