package strategy.strategies;

import strategy.model.Document;

public class MarkdownExportStrategy implements ExportStrategy {

    @Override
    public void export(Document document) {
        System.out.println("=== Exporting to Markdown ===");
        System.out.println("# " + document.getTitle());
        System.out.println();
        System.out.println("**Author:** " + document.getAuthor());
        System.out.println();
        System.out.println(document.getContent());
        System.out.println();
        System.out.println("Markdown export completed: " + document.getTitle() + ".md");
        System.out.println();
    }

    @Override
    public String getFormatName() {
        return "Markdown";
    }
}
