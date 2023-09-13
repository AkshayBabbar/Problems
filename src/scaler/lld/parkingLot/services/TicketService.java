package src.scaler.lld.parkingLot.services;

import src.scaler.lld.parkingLot.exception.NoSlotAssignedException;
import src.scaler.lld.parkingLot.models.Gate;
import src.scaler.lld.parkingLot.models.ParkingSpot;
import src.scaler.lld.parkingLot.models.Ticket;
import src.scaler.lld.parkingLot.models.Vehicle;
import src.scaler.lld.parkingLot.models.enums.VehicleType;
import src.scaler.lld.parkingLot.repository.TicketRepository;
import src.scaler.lld.parkingLot.services.stratergies.ParkingSlotAllocationStrategy;

import java.util.Date;

public class TicketService {

    private GateService gateService;
    private VehicleService vehicleService;

    private ParkingSlotAllocationStrategy pas; // this is set to null, we have to solve this problem

    private TicketRepository tr;

    public TicketService(GateService gateService, VehicleService vehicleService, ParkingSlotAllocationStrategy pas, TicketRepository tr) {
        this.gateService = gateService;
        this.vehicleService = vehicleService;
        this.pas = pas;
        this.tr = tr;
    }

    public Ticket generateTicket(Long gateId, String vehicleNumber, VehicleType vehicleType) throws NoSlotAssignedException {
        Gate gate = gateService.getGateById(gateId);
        Vehicle vehicle = vehicleService.getVehicleByNumber(vehicleNumber);
        if(vehicle == null){
            vehicle = vehicleService.registerVehicle(vehicleNumber, vehicleType);
        }

        ParkingSpot assignedSlot = pas.assignParkingSlot(gateId, vehicleType);
        if(assignedSlot == null){
            throw new NoSlotAssignedException();
        }

        // HIT the ParkingSlotService to mark this slot as occupied now

        // set 5 properties in ticket and save it to db
        Ticket ticket = new Ticket();
        ticket.setStartTime(new Date());
        ticket.setEntryGate(gate);
        ticket.setVehicle(vehicle);
        ticket.setOperator(gate.getOperator());
        ticket.setParkingSpotOccupied(assignedSlot);

        tr.save(ticket);

        return ticket;
    }

}
