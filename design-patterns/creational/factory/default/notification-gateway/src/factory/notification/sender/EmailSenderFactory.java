package src.factory.notification.sender;

import src.factory.NotificationSenderFactory;
import src.model.NotificationSender;
import src.model.notification.sender.EmailSender;

public class EmailSenderFactory implements NotificationSenderFactory {

    @Override
    public NotificationSender createNotificationSender() {
        return new EmailSender();
    }
}
