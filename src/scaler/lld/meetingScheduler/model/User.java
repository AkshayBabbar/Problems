package src.scaler.lld.meetingScheduler.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class User extends BaseModel {
    private String userName;
    private String userMailId;
    private String userContactNumber;

}
