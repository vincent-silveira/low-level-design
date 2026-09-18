package src.model.clients;

import src.model.StorageClient;

import java.util.HashMap;
import java.util.Map;

public class AwsS3StorageClient implements StorageClient {

    private final Map<String, byte[]> storage = new HashMap<>();

    @Override
    public void upload(String fileName, byte[] content) {
        System.out.println("Uploading file to AWS S3: " + fileName);
        storage.put(fileName, content);
    }

    @Override
    public byte[] download(String fileName) {
        System.out.println("Downloading file from AWS S3: " + fileName);
        return storage.get(fileName);
    }

    @Override
    public void delete(String fileName) {
        System.out.println("Deleting file from AWS S3: " + fileName);
        storage.remove(fileName);
    }

    @Override
    public String generateDownloadUrl(String fileName) {
        return "https://s3.amazonaws.com/bucket/" + fileName;
    }
}
