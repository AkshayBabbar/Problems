package src.scaler.lld.parkingLot.models;

import src.scaler.lld.parkingLot.models.enums.PaymentMode;
import src.scaler.lld.parkingLot.models.enums.PaymentStatus;

public class Payment {
    private String amount;
    private PaymentStatus paymentStatus;
    private PaymentMode paymentMode;
}
