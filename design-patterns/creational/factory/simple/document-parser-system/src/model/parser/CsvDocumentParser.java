package src.model.parser;

import src.model.Document;
import src.model.DocumentParser;

import java.util.HashMap;
import java.util.Map;

public class CsvDocumentParser implements DocumentParser {

    @Override
    public void validate(String content) {
        if (content == null || content.isBlank()) {
            throw new IllegalArgumentException("CSV document cannot be empty");
        }

        System.out.println("Validating CSV document...");
    }

    @Override
    public Map<String, String> extractMetadata(String content) {
        Map<String, String> metadata = new HashMap<>();

        String[] rows = content.split("\n");

        metadata.put("format", "CSV");
        metadata.put("rows", String.valueOf(rows.length));
        metadata.put("columns", String.valueOf(rows[0].split(",").length));

        return metadata;
    }

    @Override
    public Document parse(String content) {
        validate(content);

        Map<String, String> metadata = extractMetadata(content);

        String extractedContent = content.replace(",", " | ");

        return new Document("CSV", extractedContent, metadata);
    }
}
