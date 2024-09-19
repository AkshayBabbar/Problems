package src.scaler.lld.crashCourse;

import java.util.List;

public class EmailSender implements NotificationSender {

    @Override
    public void sendNotification(List<User> users) {
        System.out.println("Sending email notification");
    }
}