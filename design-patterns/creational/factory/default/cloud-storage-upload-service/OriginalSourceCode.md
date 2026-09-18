# Original Source Code: Cloud Storage Upload Service Without Design Patterns

## Overview

This implementation creates cloud storage client objects directly in the client code.

It does not use the Factory Method Pattern or a common abstract storage service.

---

## StorageClient.java

```java
public interface StorageClient {

    void upload(String fileName, byte[] content);

    byte[] download(String fileName);

    void delete(String fileName);

    String generateDownloadUrl(String fileName);
}
```

---

## AwsS3StorageClient.java

```java
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
```

---

## GoogleCloudStorageClient.java

```java
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
```

---

## AzureBlobStorageClient.java

```java
import java.util.HashMap;
import java.util.Map;

public class AzureBlobStorageClient implements StorageClient {

    private final Map<String, byte[]> storage = new HashMap<>();

    @Override
    public void upload(String fileName, byte[] content) {
        System.out.println("Uploading file to Azure Blob Storage: " + fileName);
        storage.put(fileName, content);
    }

    @Override
    public byte[] download(String fileName) {
        System.out.println("Downloading file from Azure Blob Storage: " + fileName);
        return storage.get(fileName);
    }

    @Override
    public void delete(String fileName) {
        System.out.println("Deleting file from Azure Blob Storage: " + fileName);
        storage.remove(fileName);
    }

    @Override
    public String generateDownloadUrl(String fileName) {
        return "https://azure.blob.core.windows.net/container/" + fileName;
    }
}
```

---

## StorageClientApplication.java

```java
public class StorageClientApplication {

    public static void main(String[] args) {

        String provider = "AWS";
        String fileName = "document.pdf";
        byte[] content = "Sample file content".getBytes();

        StorageClient storageClient;

        if (provider.equalsIgnoreCase("AWS")) {
            storageClient = new AwsS3StorageClient();

        } else if (provider.equalsIgnoreCase("GOOGLE")) {
            storageClient = new GoogleCloudStorageClient();

        } else if (provider.equalsIgnoreCase("AZURE")) {
            storageClient = new AzureBlobStorageClient();

        } else {
            throw new IllegalArgumentException(
                "Invalid cloud storage provider: " + provider
            );
        }

        storageClient.upload(fileName, content);

        String downloadUrl =
                storageClient.generateDownloadUrl(fileName);

        System.out.println("Download URL: " + downloadUrl);
    }
}
```

---

## Sample Output

```text
Uploading file to AWS S3: document.pdf
Download URL: https://s3.amazonaws.com/bucket/document.pdf
```

---

## Problems With This Approach

### 1. Direct Object Creation

The client directly creates concrete storage client classes:

```java
new AwsS3StorageClient();
new GoogleCloudStorageClient();
new AzureBlobStorageClient();
```

This creates tight coupling between the application and provider-specific implementations.

### 2. Conditional Logic in Client

The client contains multiple `if-else` statements to decide which storage client to create.

As more cloud providers are added, this logic becomes increasingly difficult to maintain.

### 3. Common Workflow Is Not Centralized

Uploading a file, generating a download URL, and handling provider-specific behavior are mixed together in the client.

If validation or retry logic is added, it may need to be duplicated across different clients.

### 4. Difficult to Extend

Adding a new cloud provider requires modifying the client class.

For example, adding Oracle Cloud Storage would require another `else-if` block.

### 5. Violates Separation of Responsibilities

The client is responsible for:

* Selecting the cloud provider.
* Creating storage client objects.
* Managing upload operations.
* Generating download URLs.

Object creation and the common upload workflow should ideally be separated from the application logic.

---

## Conclusion

This implementation works correctly but creates unnecessary dependencies between the application and concrete cloud storage clients.

The Factory Method Pattern can improve this design by introducing an abstract storage service that defines the common upload workflow while allowing subclasses to decide which provider-specific storage client to create.
