package src.scaler.lld.parkingLot.models;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
public class ParkingFloor {
    private Long id;
    private List<ParkingSpot> parkingSpots;
    private List<Gate> parkingGates;
    private String location;
}
