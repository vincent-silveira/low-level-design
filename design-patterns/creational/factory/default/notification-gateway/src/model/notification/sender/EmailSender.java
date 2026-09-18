package src.model.notification.sender;

import src.model.NotificationSender;

public class EmailSender implements NotificationSender {

    @Override
    public void send(String recipient, String message) {
        System.out.println("Sending Email to " + recipient + ": " + message);
    }
}
