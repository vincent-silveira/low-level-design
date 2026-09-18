package src.factory;

import src.factory.clients.AwsS3StorageClientFactory;
import src.factory.clients.AzureBlobStorageClientFactory;
import src.factory.clients.GoogleCloudStorageClientFactory;

public class StorageClientFactoryProvider {

    public static StorageClientFactory getStorageClientFactory(String provider){

        if(provider == null || provider.isBlank()){
            throw new IllegalArgumentException("Invalid cloud storage provider: Cannot be blank");
        }

        return switch (provider.toUpperCase()){
            case "AWS" -> new AwsS3StorageClientFactory();
            case "GOOGLE" -> new GoogleCloudStorageClientFactory();
            case "AZURE" -> new AzureBlobStorageClientFactory();
            default -> throw new IllegalArgumentException("Invalid cloud storage provider: " + provider);
        };
    }
}
