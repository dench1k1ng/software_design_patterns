package strategy.strategies;

import strategy.model.Document;

public interface ExportStrategy {
    void export(Document document);

    String getFormatName();
}
