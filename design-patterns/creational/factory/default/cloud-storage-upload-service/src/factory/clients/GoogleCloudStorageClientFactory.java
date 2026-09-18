package src.factory.clients;

import src.factory.StorageClientFactory;
import src.model.StorageClient;
import src.model.clients.GoogleCloudStorageClient;

public class GoogleCloudStorageClientFactory implements StorageClientFactory {
    @Override
    public StorageClient createStorageClient() {
        return new GoogleCloudStorageClient();
    }
}
