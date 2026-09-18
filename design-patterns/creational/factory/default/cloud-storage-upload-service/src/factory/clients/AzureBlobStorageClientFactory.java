package src.factory.clients;

import src.factory.StorageClientFactory;
import src.model.StorageClient;
import src.model.clients.AzureBlobStorageClient;

public class AzureBlobStorageClientFactory implements StorageClientFactory {
    @Override
    public StorageClient createStorageClient() {
        return new AzureBlobStorageClient();
    }
}
