# Problem Statement: Cloud Storage Upload Service

## Scenario

You are developing a file storage service for an application.

The application supports multiple cloud storage providers:

* AWS S3
* Google Cloud Storage
* Azure Blob Storage

Each cloud storage provider has its own implementation for uploading, downloading, deleting, and generating download URLs for files.

## Objective

Build a cloud storage system where the client can manage files using different cloud storage providers.

Each storage provider must support the following operations:

```java
void upload(String fileName, byte[] content);
byte[] download(String fileName);
void delete(String fileName);
String generateDownloadUrl(String fileName);
```

The system should use the Factory Method Pattern to define a common storage service abstraction while allowing subclasses to create their own provider-specific storage client objects.

## Requirements

1. Create separate storage client classes for AWS S3, Google Cloud Storage, and Azure Blob Storage.
2. Each storage client should implement upload, download, delete, and generateDownloadUrl operations.
3. Create an abstract storage service containing the common workflow for uploading a file.
4. The common upload workflow should remain in the parent class.
5. The abstract storage service should use a factory method to create the provider-specific storage client.
6. Provider-specific service subclasses should decide which storage client object to create.
7. Add upload validation before attempting a storage operation.
8. Add retry handling for failed uploads with a configurable maximum number of attempts.
9. The client should not directly instantiate concrete storage client classes.
10. Adding a new cloud provider should require creating a new service and client implementation rather than modifying the existing common workflow.
11. Invalid upload requests and failed uploads should be handled properly.

## Expected Behavior

For example:

* Selecting AWS S3 should create an AWS S3 storage client.
* Selecting Google Cloud Storage should create a Google Cloud Storage client.
* Selecting Azure Blob Storage should create an Azure Blob Storage client.
* An invalid upload request should fail validation before the upload begins.
* A failed upload should be retried until the maximum retry limit is reached.
* After a successful upload, the service should generate and return a download URL.

## Learning Objective

This exercise demonstrates how the Factory Method Pattern and Template Method Pattern can work together to create an extensible cloud storage service.

The parent class controls the common upload workflow, while subclasses decide which provider-specific storage client to create.

## Difficulty

Advanced
