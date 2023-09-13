package src.scaler.lld.parkingLot.models;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class Bill extends BaseModel {

    private Ticket ticket;
    private Date endTime;
    private Gate exitGate;
    private Operator operator;
    private int amount;
    private String invoiceNumber;
    private Payment payment;

}
