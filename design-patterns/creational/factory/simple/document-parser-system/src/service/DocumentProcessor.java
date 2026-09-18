package src.service;


import src.factory.DocumentParserFactory;
import src.model.Document;
import src.model.DocumentParser;


public class DocumentProcessor {

    public Document processDocument(String format, String content) {

        DocumentParser parser = new DocumentParserFactory().createDocumentParser(format);
        return parser.parse(content);
    }
}
