package src.model.clients;

import src.model.StorageClient;

import java.util.HashMap;
import java.util.Map;

public class GoogleCloudStorageClient implements StorageClient {

    private final Map<String, byte[]> storage = new HashMap<>();

    @Override
    public void upload(String fileName, byte[] content) {
        System.out.println("Uploading file to Google Cloud Storage: " + fileName);
        storage.put(fileName, content);
    }

    @Override
    public byte[] download(String fileName) {
        System.out.println("Downloading file from Google Cloud Storage: " + fileName);
        return storage.get(fileName);
    }

    @Override
    public void delete(String fileName) {
        System.out.println("Deleting file from Google Cloud Storage: " + fileName);
        storage.remove(fileName);
    }

    @Override
    public String generateDownloadUrl(String fileName) {
        return "https://storage.googleapis.com/bucket/" + fileName;
    }
}