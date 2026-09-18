package src;

import src.factory.NotificationSenderRegistry;
import src.model.NotificationSender;

public class NotificationClient {

    public static void main(String[] args) {

        String notificationType = "EMAIL";
        String recipient = "vincent@gmail.com";
        String message = "Welcome to our application!";


        NotificationSender sender = NotificationSenderRegistry
                .getNotificationSenderFactory(notificationType)
                .createNotificationSender();

        sender.send(recipient, message);
    }
}
