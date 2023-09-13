package src.scaler.lld.parkingLot.controller;

import src.scaler.lld.parkingLot.DTO.GenerateTicketRequestDTO;
import src.scaler.lld.parkingLot.DTO.GenerateTicketResponseDTO;
import src.scaler.lld.parkingLot.DTO.ResponseStatus;
import src.scaler.lld.parkingLot.models.Ticket;
import src.scaler.lld.parkingLot.services.TicketService;

public class TicketController {

    private TicketService ticketService;

    public TicketController(TicketService ticketService) {
        this.ticketService = ticketService;
    }

    public GenerateTicketResponseDTO generateTicket(GenerateTicketRequestDTO requestObject){
        GenerateTicketResponseDTO responseDTO = new GenerateTicketResponseDTO();
        try{
            Ticket ticket = ticketService.generateTicket(requestObject.getGateId(), requestObject.getVehicleNumber(),
                    requestObject.getVehicleType());

            responseDTO.setGeneratedTicketId(ticket.getId());
            responseDTO.setResponseStatus(ResponseStatus.OK);
        }
        catch (Exception ex){
        responseDTO.setMessage(String.valueOf(ResponseStatus.FAIL));
        responseDTO.setMessage(ex.getMessage());

        }
        return responseDTO;
    }
}
