package src.scaler.lld.meetingScheduler.model;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class Notification extends BaseModel {

    private List<User> Users;
    private MeetingRoom meetingRoom;
}
