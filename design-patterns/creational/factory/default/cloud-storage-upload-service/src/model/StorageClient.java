package src.model;

public interface StorageClient {

    void upload(String fileName, byte[] content);

    byte[] download(String fileName);

    void delete(String fileName);

    String generateDownloadUrl(String fileName);
}
