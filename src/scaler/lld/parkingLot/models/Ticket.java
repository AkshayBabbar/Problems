package src.scaler.lld.parkingLot.models;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Setter
@Getter
public class Ticket extends BaseModel {
    private Date startTime;
    private ParkingSpot parkingSpotOccupied;
    private Gate entryGate;
    private Operator operator;
    private Vehicle vehicle;
}
