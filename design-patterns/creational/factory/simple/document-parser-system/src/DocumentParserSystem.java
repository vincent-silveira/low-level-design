package src;


import src.exception.UnsupportedDocumentFormatException;
import src.model.Document;
import src.service.DocumentProcessor;

public class DocumentParserSystem {

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

        System.out.println();

        String csvContent = """
                name,age,city
                John,30,Mumbai
                Jane,25,Pune
                """;

        Document csvDocument = processor.processDocument("CSV", csvContent);
        System.out.println(csvDocument);

    }
}