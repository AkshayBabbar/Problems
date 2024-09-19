package src.scaler.lld.crashCourse;

import java.util.List;

public interface NotificationSender {
    void sendNotification(List<User> users);
}