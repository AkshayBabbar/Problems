package src.scaler.lld.parkingLot;

import src.scaler.lld.parkingLot.DTO.GenerateTicketRequestDTO;
import src.scaler.lld.parkingLot.DTO.GenerateTicketResponseDTO;
import src.scaler.lld.parkingLot.DTO.ResponseStatus;
import src.scaler.lld.parkingLot.controller.TicketController;
import src.scaler.lld.parkingLot.models.enums.VehicleType;
import src.scaler.lld.parkingLot.services.TicketService;

public class Client {
    public static void main(String[] args) {
//        TicketService ts = new TicketService();
//        TicketController tc = new TicketController(ts);

        GenerateTicketRequestDTO requestDTO = new GenerateTicketRequestDTO();
        requestDTO.setGateId(10L);
        requestDTO.setVehicleType(VehicleType.LIGHT);
        requestDTO.setVehicleNumber("DL9C9366");

//        GenerateTicketResponseDTO responseDTO = tc.generateTicket(requestDTO);
//        if(responseDTO.getResponseStatus() == ResponseStatus.OK){
//            System.out.println(responseDTO.getGeneratedTicketId());
//        }
//        else {
//            System.out.println("FAILURE ==>" + responseDTO.getMessage());
//        }
    }
}
