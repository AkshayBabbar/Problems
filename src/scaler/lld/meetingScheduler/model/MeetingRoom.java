package src.scaler.lld.meetingScheduler.model;

import lombok.Getter;
import lombok.Setter;
import src.scaler.lld.meetingScheduler.Availability;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Getter
@Setter

public class MeetingRoom extends BaseModel {

    private int capacity;
    private String location;
    private Availability meetingRoomAvailability;

}
