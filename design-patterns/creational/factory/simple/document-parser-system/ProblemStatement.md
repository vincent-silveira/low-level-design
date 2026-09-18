# Document Parser System

## Problem Statement

Build a document ingestion system that processes different document formats and converts them into a common internal representation.

The system should support the following document formats:

* PDF
* CSV
* JSON
* XML

Each document format requires its own parsing and validation logic.

### Functional Requirements

The application must:

1. Validate the document before processing.
2. Extract relevant metadata from the document.
3. Convert the document into a common internal representation.
4. Provide a consistent way for the application to interact with different document parsers.
5. Handle unsupported document formats with a meaningful exception.

### Design Requirements

The application should work with a common `DocumentParser` interface.

Each parser implementation should be responsible for its own parsing logic, including:

* Document validation
* Metadata extraction
* Conversion into the common representation

The parsing logic should remain within the individual parser classes.

The application should use a **Simple Factory** to centralize the creation of document parser objects. Client code should request a parser using the required document format instead of directly instantiating concrete parser classes.

The factory should:

* Accept a document format as input.
* Return the appropriate `DocumentParser` implementation.
* Hide parser object creation from the client.
* Throw a meaningful exception when the requested format is unsupported.

The factory should be responsible only for creating parser objects. Validation, metadata extraction, and document conversion must remain inside the individual parser classes.

### Supported Document Formats

| Format | Parser Class       |
| ------ | ------------------ |
| PDF    | PdfDocumentParser  |
| CSV    | CsvDocumentParser  |
| JSON   | JsonDocumentParser |
| XML    | XmlDocumentParser  |

### Expected Behavior

The application should request a parser from the factory based on the document format and then use the common `DocumentParser` interface to process the document.

For example:

* Requesting a `PDF` parser should return a `PdfDocumentParser`.
* Requesting a `CSV` parser should return a `CsvDocumentParser`.
* Requesting a `JSON` parser should return a `JsonDocumentParser`.
* Requesting an `XML` parser should return an `XmlDocumentParser`.

The client application should not directly create `PdfDocumentParser`, `CsvDocumentParser`, `JsonDocumentParser`, or `XmlDocumentParser` objects.

If the application requests an unsupported format, the factory should throw a meaningful exception explaining that the format is not supported.

### Learning Objective

Implement the document processing system using the **Simple Factory pattern**.

The goal is to separate parser object creation from document processing while allowing the application to work with the common `DocumentParser` interface.

This design should make the client code simpler and ensure that parser creation logic is centralized in one place.
