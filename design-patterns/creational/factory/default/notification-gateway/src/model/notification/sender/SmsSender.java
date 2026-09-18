package src.model.notification.sender;

import src.model.NotificationSender;

public class SmsSender implements NotificationSender {

    @Override
    public void send(String recipient, String message) {
        System.out.println("Sending SMS to " + recipient + ": " + message);
    }
}
