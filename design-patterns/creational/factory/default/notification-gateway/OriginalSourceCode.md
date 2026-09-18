# Original Source Code: Notification Gateway Without Design Patterns

## Overview

This implementation creates notification sender objects directly in the client code.

It does not use the Factory Method Pattern.

---

## NotificationSender.java

```java
public interface NotificationSender {

    void send(String recipient, String message);
}
```

---

## EmailSender.java

```java
public class EmailSender implements NotificationSender {

    @Override
    public void send(String recipient, String message) {
        System.out.println("Sending Email to " + recipient + ": " + message);
    }
}
```

---

## SmsSender.java

```java
public class SmsSender implements NotificationSender {

    @Override
    public void send(String recipient, String message) {
        System.out.println("Sending SMS to " + recipient + ": " + message);
    }
}
```

---

## PushNotificationSender.java

```java
public class PushNotificationSender implements NotificationSender {

    @Override
    public void send(String recipient, String message) {
        System.out.println("Sending Push Notification to " + recipient + ": " + message);
    }
}
```

---

## NotificationClient.java

```java
public class NotificationClient {

    public static void main(String[] args) {

        String notificationType = "EMAIL";
        String recipient = "user@example.com";
        String message = "Welcome to our application!";

        NotificationSender sender;

        if (notificationType.equalsIgnoreCase("EMAIL")) {
            sender = new EmailSender();

        } else if (notificationType.equalsIgnoreCase("SMS")) {
            sender = new SmsSender();

        } else if (notificationType.equalsIgnoreCase("PUSH")) {
            sender = new PushNotificationSender();

        } else {
            throw new IllegalArgumentException(
                "Invalid notification type: " + notificationType
            );
        }

        sender.send(recipient, message);
    }
}
```

---

## Sample Output

```text
Sending Email to user@example.com: Welcome to our application!
```

---

## Problems With This Approach

### 1. Direct Object Creation

The client directly creates concrete classes:

```java
new EmailSender();
new SmsSender();
new PushNotificationSender();
```

This creates tight coupling between the client and notification sender implementations.

### 2. Conditional Logic in Client

The client contains multiple `if-else` statements to decide which object to create.

As more notification channels are added, this logic becomes increasingly difficult to maintain.

### 3. Violates Single Responsibility Principle

The client is responsible for:

* Selecting the notification type.
* Creating notification sender objects.
* Sending notifications.

Object creation should ideally be separated from business logic.

### 4. Difficult to Extend

Adding a new notification channel requires modifying the client class.

For example, adding WhatsApp notifications would require another `else-if` block.

---

## Conclusion

This implementation works correctly but creates unnecessary dependencies between the client and concrete notification sender classes.

The Factory Method Pattern can improve this design by introducing a common notification service abstraction and allowing subclasses to decide which sender object to create.
