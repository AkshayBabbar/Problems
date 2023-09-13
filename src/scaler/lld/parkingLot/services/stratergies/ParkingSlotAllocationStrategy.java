package src.scaler.lld.parkingLot.services.stratergies;

import src.scaler.lld.parkingLot.models.ParkingSpot;
import src.scaler.lld.parkingLot.models.enums.VehicleType;

public interface ParkingSlotAllocationStrategy {
    ParkingSpot assignParkingSlot(Long gateId, VehicleType vehicleType);
}
