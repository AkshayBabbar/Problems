package src.scaler.lld.parkingLot.models;

import lombok.Getter;
import lombok.Setter;
import src.scaler.lld.parkingLot.models.enums.VehicleType;

@Setter
@Getter
public class Vehicle extends BaseModel{
    private String name;
    private VehicleType type;
    private String number;
}
