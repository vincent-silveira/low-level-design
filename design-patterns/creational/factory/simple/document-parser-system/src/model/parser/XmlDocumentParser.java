package src.model.parser;

import src.model.Document;
import src.model.DocumentParser;

import java.util.HashMap;
import java.util.Map;

public class XmlDocumentParser implements DocumentParser {

    @Override
    public void validate(String content) {
        if (content == null || content.isBlank()) {
            throw new IllegalArgumentException("XML document cannot be empty");
        }

        if (!content.trim().startsWith("<")) {
            throw new IllegalArgumentException("Invalid XML document");
        }

        System.out.println("Validating XML document...");
    }

    @Override
    public Map<String, String> extractMetadata(String content) {
        Map<String, String> metadata = new HashMap<>();

        metadata.put("format", "XML");
        metadata.put("length", String.valueOf(content.length()));

        return metadata;
    }

    @Override
    public Document parse(String content) {
        validate(content);

        Map<String, String> metadata = extractMetadata(content);

        String extractedContent = content.trim();

        return new Document("XML", extractedContent, metadata);
    }
}
