package src.scaler.lld.parkingLot.DTO;

import lombok.Getter;
import lombok.Setter;
import src.scaler.lld.parkingLot.models.enums.VehicleType;

@Setter
@Getter
public class GenerateTicketRequestDTO {

    private String vehicleNumber;
    private VehicleType vehicleType;
    private Long gateId;


}
