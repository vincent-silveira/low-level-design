package src;

import src.factory.StorageClientFactoryProvider;
import src.model.StorageClient;

public class StorageClientApplication {
    public static void main(String[] args) {

        String provider = "AWS";
        String fileName = "document.pdf";
        byte[] content = "Sample file content".getBytes();

        StorageClient storageClient  = StorageClientFactoryProvider
                .getStorageClientFactory(provider)
                .createStorageClient();

        storageClient.upload(fileName, content);

        String downloadUrl =
                storageClient.generateDownloadUrl(fileName);

        System.out.println("Download URL: " + downloadUrl);

        storageClient.delete(fileName);
    }
}
