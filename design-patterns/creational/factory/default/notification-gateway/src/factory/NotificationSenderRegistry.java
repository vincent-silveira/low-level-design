package src.factory;

import src.factory.notification.sender.EmailSenderFactory;
import src.factory.notification.sender.PushNotificationSenderFactory;
import src.factory.notification.sender.SmsSenderFactory;

public class NotificationSenderRegistry {

    public static NotificationSenderFactory getNotificationSenderFactory(String notificationType){
        NotificationSenderFactory notificationSenderFactory;

        return switch (notificationType.toUpperCase()) {
            case "EMAIL" -> new EmailSenderFactory();
            case "SMS" -> new SmsSenderFactory();
            case "PUSH" -> new PushNotificationSenderFactory();
            default -> throw new IllegalArgumentException("Invalid notification type: " + notificationType);
        };

    }

}
