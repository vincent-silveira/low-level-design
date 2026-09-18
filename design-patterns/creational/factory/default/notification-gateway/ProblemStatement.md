# Problem Statement: Notification Gateway

## Scenario

You are developing a notification system for an application.

The application supports multiple notification channels:

* Email
* SMS
* Push Notification

Each notification sender has its own implementation for sending notifications.

## Objective

Build a notification system where the client can send notifications using different notification channels.

Each notification sender must support the following operation:

```java
void send(String recipient, String message);
```

## Requirements

1. Create separate classes for Email, SMS, and Push Notification sending.
2. Each notification sender should implement the `send(String recipient, String message)` method.
3. The client application should be able to select a notification channel based on a notification type.
4. The client should not directly instantiate concrete notification sender classes.
5. Different notification services should decide which sender object to create.
6. Adding a new notification channel in the future should require minimal changes to existing services.
7. Invalid or unsupported notification types should be handled properly.

## Expected Behavior

For example:

* Selecting `"EMAIL"` should create an Email sender.
* Selecting `"SMS"` should create an SMS sender.
* Selecting `"PUSH"` should create a Push Notification sender.
* An invalid notification type should display an appropriate error message or throw an exception.

## Learning Objective

This exercise demonstrates how the Factory Method Pattern can define a common notification service abstraction while allowing subclasses to create their own appropriate notification sender objects.

## Difficulty

Beginner
