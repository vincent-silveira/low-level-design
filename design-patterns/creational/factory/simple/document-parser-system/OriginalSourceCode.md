# Document Parser System

## Overview

This implementation uses a common `DocumentParser` interface and separate parser classes for each supported document format.

No design pattern is used in this implementation.

The application directly creates the appropriate parser based on the document format.

---

## DocumentParser.java

```java
import java.util.Map;

public interface DocumentParser {

    void validate(String content);

    Map<String, String> extractMetadata(String content);

    Document parse(String content);
}
```

The interface defines the common operations that every document parser must implement.

## Document.java

```java
import java.util.Map;

public class Document {

    private final String format;
    private final String content;
    private final Map<String, String> metadata;

    public Document(String format, String content, Map<String, String> metadata) {
        this.format = format;
        this.content = content;
        this.metadata = metadata;
    }

    public String getFormat() {
        return format;
    }

    public String getContent() {
        return content;
    }

    public Map<String, String> getMetadata() {
        return metadata;
    }

    @Override
    public String toString() {
        return "Document{" +
                "format='" + format + '\'' +
                ", content='" + content + '\'' +
                ", metadata=" + metadata +
                '}';
    }
}
```

`Document` represents the common internal representation used by the application.

Regardless of the original document format, all parsers return a `Document` object.

## PdfDocumentParser.java

```java
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
```

## CsvDocumentParser.java

```java
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
```

## JsonDocumentParser.java

```java
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
```

## XmlDocumentParser.java

```java
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
```

## DocumentProcessor.java

```java
public class DocumentProcessor {

    public Document processDocument(String format, String content) {

        DocumentParser parser;

        if (format.equalsIgnoreCase("PDF")) {
            parser = new PdfDocumentParser();

        } else if (format.equalsIgnoreCase("CSV")) {
            parser = new CsvDocumentParser();

        } else if (format.equalsIgnoreCase("JSON")) {
            parser = new JsonDocumentParser();

        } else if (format.equalsIgnoreCase("XML")) {
            parser = new XmlDocumentParser();

        } else {
            throw new UnsupportedDocumentFormatException(
                    "Unsupported document format: " + format
            );
        }

        return parser.parse(content);
    }
}
```

The `DocumentProcessor` determines which parser to instantiate using conditional statements.

This is intentionally a straightforward implementation without applying a factory pattern.

## UnsupportedDocumentFormatException.java

```java
public class UnsupportedDocumentFormatException extends RuntimeException {

    public UnsupportedDocumentFormatException(String message) {
        super(message);
    }
}
```

This exception provides meaningful feedback when an unsupported document format is requested.

## Main.java

```java
public class Main {

    public static void main(String[] args) {

        DocumentProcessor processor = new DocumentProcessor();

        String jsonContent = """
                {
                    "name": "John Doe",
                    "age": 30
                }
                """;

        Document document = processor.processDocument("JSON", jsonContent);

        System.out.println(document);

        String csvContent = """
                name,age,city
                John,30,Mumbai
                Jane,25,Pune
                """;

        Document csvDocument = processor.processDocument("CSV", csvContent);

        System.out.println(csvDocument);

        try {
            processor.processDocument("TXT", "Sample text");

        } catch (UnsupportedDocumentFormatException e) {
            System.out.println(e.getMessage());
        }
    }
}
```

---

## Example Output

```text
Validating JSON document...

Document{
    format='JSON',
    content='{
        "name": "John Doe",
        "age": 30
    }',
    metadata={format=JSON, length=45}
}

Validating CSV document...

Document{
    format='CSV',
    content='name | age | city
    John | 30 | Mumbai
    Jane | 25 | Pune',
    metadata={format=CSV, rows=3, columns=3}
}

Unsupported document format: TXT
```

---

## Limitations of This Implementation

Although the implementation works correctly, it has some design limitations.

### 1. Tight Coupling

`DocumentProcessor` directly depends on every concrete parser class.

```java
new PdfDocumentParser();
new CsvDocumentParser();
new JsonDocumentParser();
new XmlDocumentParser();
```

Adding a new document format requires modifying `DocumentProcessor`.

### 2. Growing Conditional Logic

The `if-else` chain grows as more document formats are introduced.

For example, supporting DOCX would require another condition:

```java
else if (format.equalsIgnoreCase("DOCX")) {
    parser = new DocxDocumentParser();
}
```

### 3. Violation of Open/Closed Principle

The processor must be modified whenever a new parser type is added.

This makes the system harder to maintain as the number of supported formats increases.

### 4. Object Creation Responsibility

`DocumentProcessor` is responsible for both:

* Selecting the appropriate parser.
* Processing the document.

These responsibilities can eventually become difficult to manage in larger applications.

---

## Summary

This implementation demonstrates a basic document ingestion system using:

* A common `DocumentParser` interface.
* Individual parser implementations.
* A shared `Document` representation.
* Direct object creation using conditional statements.
* Meaningful exception handling for unsupported formats.

No design pattern is used intentionally. This implementation serves as the baseline for understanding how a Simple Factory can later improve the object creation process.
