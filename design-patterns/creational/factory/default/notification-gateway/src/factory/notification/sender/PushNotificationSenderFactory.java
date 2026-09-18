package src.factory.notification.sender;

import src.factory.NotificationSenderFactory;
import src.model.NotificationSender;
import src.model.notification.sender.PushNotificationSender;

public class PushNotificationSenderFactory implements NotificationSenderFactory {

    @Override
    public NotificationSender createNotificationSender() {
        return new PushNotificationSender();
    }
}
