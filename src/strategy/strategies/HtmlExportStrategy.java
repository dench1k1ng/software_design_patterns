package strategy.strategies;

import strategy.model.Document;

public class HtmlExportStrategy implements ExportStrategy {

    @Override
    public void export(Document document) {
        System.out.println("=== Exporting to HTML ===");
        System.out.println("<!DOCTYPE html>");
        System.out.println("<html>");
        System.out.println("  <head>");
        System.out.println("    <title>" + document.getTitle() + "</title>");
        System.out.println("  </head>");
        System.out.println("  <body>");
        System.out.println("    <h1>" + document.getTitle() + "</h1>");
        System.out.println("    <p><strong>Author:</strong> " + document.getAuthor() + "</p>");
        System.out.println("    <p>" + document.getContent() + "</p>");
        System.out.println("  </body>");
        System.out.println("</html>");
        System.out.println("HTML export completed: " + document.getTitle() + ".html");
        System.out.println();
    }

    @Override
    public String getFormatName() {
        return "HTML";
    }
}
