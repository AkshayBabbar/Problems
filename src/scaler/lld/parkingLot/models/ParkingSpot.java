package src.scaler.lld.parkingLot.models;

import lombok.Getter;
import lombok.Setter;
import src.scaler.lld.parkingLot.models.enums.ParkingSpotStatus;
import src.scaler.lld.parkingLot.models.enums.VehicleType;

@Setter
@Getter
public class ParkingSpot extends BaseModel {
    private VehicleType vehicleTypeSupported;
    private ParkingSpotStatus parkingSpotStatus;
    private String number;

}
