package src.scaler.lld.parkingLot.DTO;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class GenerateTicketResponseDTO {
    private String generatedTicketId;
    private ResponseStatus responseStatus;
    private String message;


}
