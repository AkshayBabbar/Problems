package src.scaler.lld.parkingLot.services.stratergies;

import src.scaler.lld.parkingLot.models.ParkingFloor;
import src.scaler.lld.parkingLot.models.ParkingSpot;
import src.scaler.lld.parkingLot.models.enums.ParkingSpotStatus;
import src.scaler.lld.parkingLot.models.enums.VehicleType;
import src.scaler.lld.parkingLot.repository.ParkingLotRepository;
import src.scaler.lld.parkingLot.repository.ParkingSpotRepository;

import java.util.List;

public class FirstParkingLotStratergy implements ParkingSlotAllocationStrategy{

    private ParkingLotRepository plRepo;
    private ParkingSpotRepository psRepo;
    @Override
    public ParkingSpot assignParkingSlot(Long gateId, VehicleType vehicleType) {
        ParkingFloor parkingFloor = plRepo.getParkingLotByGateId(gateId);
        List<ParkingSpot> allParkingSlots = psRepo.getAllParkingSlotsByParkingLotId(parkingFloor.getId());

        for(ParkingSpot ps: allParkingSlots){
            if(ps.getParkingSpotStatus().equals(ParkingSpotStatus.AVAILABLE) &&
                    ps.getVehicleTypeSupported().equals(vehicleType)){
                return ps;
            }
        }
        return  null;
    }
}
