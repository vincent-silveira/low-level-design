package src.model.parser;

import src.model.Document;
import src.model.DocumentParser;

import java.util.HashMap;
import java.util.Map;

public class JsonDocumentParser implements DocumentParser {

    @Override
    public void validate(String content) {
        if (content == null || content.isBlank()) {
            throw new IllegalArgumentException("JSON document cannot be empty");
        }

        if (!content.trim().startsWith("{") && !content.trim().startsWith("[")) {
            throw new IllegalArgumentException("Invalid JSON document");
        }

        System.out.println("Validating JSON document...");
    }

    @Override
    public Map<String, String> extractMetadata(String content) {
        Map<String, String> metadata = new HashMap<>();

        metadata.put("format", "JSON");
        metadata.put("length", String.valueOf(content.length()));

        return metadata;
    }

    @Override
    public Document parse(String content) {
        validate(content);

        Map<String, String> metadata = extractMetadata(content);
        String extractedContent = content.trim();

        return new Document("JSON", extractedContent, metadata);
    }
}
