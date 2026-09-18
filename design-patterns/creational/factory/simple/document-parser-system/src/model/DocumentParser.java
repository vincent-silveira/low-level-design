package src.model;

import java.util.Map;

public interface DocumentParser {

    void validate(String content);

    Map<String, String> extractMetadata(String content);

    Document parse(String content);
}