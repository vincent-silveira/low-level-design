package src.model.parser;

import src.model.Document;
import src.model.DocumentParser;

import java.util.HashMap;
import java.util.Map;

public class PdfDocumentParser implements DocumentParser {

    @Override
    public void validate(String content) {
        if (content == null || content.isBlank()) {
            throw new IllegalArgumentException("PDF document cannot be empty");
        }

        System.out.println("Validating PDF document...");
    }

    @Override
    public Map<String, String> extractMetadata(String content) {
        Map<String, String> metadata = new HashMap<>();

        metadata.put("format", "PDF");
        metadata.put("pages", "Unknown");
        metadata.put("author", "Unknown");

        return metadata;
    }

    @Override
    public Document parse(String content) {
        validate(content);

        Map<String, String> metadata = extractMetadata(content);

        String extractedContent = "Extracted text from PDF";

        return new Document("PDF", extractedContent, metadata);
    }
}