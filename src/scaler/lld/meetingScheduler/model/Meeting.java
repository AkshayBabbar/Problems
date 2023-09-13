package src.scaler.lld.meetingScheduler.model;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Getter
@Setter
public class Meeting {
    private List<User> users;
    private MeetingRoom allocatedMeetingRoom;
    private Date startTime;
    private Date endTime;
    private MeetingCalendar calendar;

}
