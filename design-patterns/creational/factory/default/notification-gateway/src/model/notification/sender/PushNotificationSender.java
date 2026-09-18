package src.model.notification.sender;

import src.model.NotificationSender;

public class PushNotificationSender implements NotificationSender {

    @Override
    public void send(String recipient, String message) {
        System.out.println("Sending Push Notification to " + recipient + ": " + message);
    }
}
