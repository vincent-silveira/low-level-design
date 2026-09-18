package src.factory;

import src.exception.UnsupportedDocumentFormatException;
import src.model.DocumentParser;
import src.model.parser.CsvDocumentParser;
import src.model.parser.JsonDocumentParser;
import src.model.parser.PdfDocumentParser;
import src.model.parser.XmlDocumentParser;

public class DocumentParserFactory {

    public DocumentParser createDocumentParser(String format){

        if(format == null || format.isBlank()){
            throw new UnsupportedDocumentFormatException("Document format cannot be null or empty");
        }
        
        return switch (format.toUpperCase()){
            case "PDF" -> new PdfDocumentParser();
            case "CSV" -> new CsvDocumentParser();
            case "JSON" -> new JsonDocumentParser();
            case "XML" -> new XmlDocumentParser();
            default -> throw new UnsupportedDocumentFormatException("Unsupported document format: " + format);
        };
    }
}
