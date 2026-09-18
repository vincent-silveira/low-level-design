package src.model;

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
        return "Document {" +
                "\nformat='" + format + '\'' +
                ",\ncontent='\n" + content + '\'' +
                ",\nmetadata=" + metadata +
                '}';
    }
}
