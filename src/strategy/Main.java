package strategy;

import strategy.exporter.DocumentExporter;
import strategy.model.Document;
import strategy.strategies.HtmlExportStrategy;
import strategy.strategies.MarkdownExportStrategy;
import strategy.strategies.PdfExportStrategy;

public class Main {
    public static void main(String[] args) {
        Document document = new Document(
                "Design Patterns in Java",
                "Design patterns are reusable solutions to common problems in software design. " +
                        "The Strategy pattern allows you to define a family of algorithms, " +
                        "encapsulate each one, and make them interchangeable.",
                "John Smith");

        DocumentExporter exporter = new DocumentExporter();

        // Export to PDF
        exporter.setExportStrategy(new PdfExportStrategy());
        exporter.exportDocument(document);

        // Export to HTML
        exporter.setExportStrategy(new HtmlExportStrategy());
        exporter.exportDocument(document);

        // Export to Markdown
        exporter.setExportStrategy(new MarkdownExportStrategy());
        exporter.exportDocument(document);

        // Demonstrate flexibility: create another document
        Document report = new Document(
                "Monthly Report",
                "This month's statistics show significant improvement in all metrics.",
                "Jane Doe");

        System.out.println("--- Exporting second document ---");
        System.out.println();

        exporter.setExportStrategy(new HtmlExportStrategy());
        exporter.exportDocument(report);
    }
}
