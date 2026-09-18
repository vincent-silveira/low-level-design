package src.factory.clients;

import src.factory.StorageClientFactory;
import src.model.StorageClient;
import src.model.clients.AwsS3StorageClient;

public class AwsS3StorageClientFactory implements StorageClientFactory {

    @Override
    public StorageClient createStorageClient() {
        return new AwsS3StorageClient();
    }
}
