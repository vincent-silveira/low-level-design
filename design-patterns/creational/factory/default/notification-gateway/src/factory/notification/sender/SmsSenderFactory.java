package src.factory.notification.sender;

import src.factory.NotificationSenderFactory;
import src.model.NotificationSender;
import src.model.notification.sender.SmsSender;

public class SmsSenderFactory implements NotificationSenderFactory {

    @Override
    public NotificationSender createNotificationSender() {
        return new SmsSender();
    }
}
