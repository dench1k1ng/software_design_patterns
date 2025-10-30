package strategy.strategies;

import strategy.model.Document;

public class PdfExportStrategy implements ExportStrategy {

    @Override
    public void export(Document document) {
        System.out.println("=== Exporting to PDF ===");
        System.out.println("Generating PDF document...");
        System.out.println("Title: " + document.getTitle());
        System.out.println("Author: " + document.getAuthor());
        System.out.println("Content: " + document.getContent());
        System.out.println("Adding PDF metadata and formatting...");
        System.out.println("PDF export completed: " + document.getTitle() + ".pdf");
        System.out.println();
    }

    @Override
    public String getFormatName() {
        return "PDF";
    }
}
