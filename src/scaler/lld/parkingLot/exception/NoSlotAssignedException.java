package src.scaler.lld.parkingLot.exception;

public class NoSlotAssignedException extends Exception {
    public NoSlotAssignedException(){
        super("No slot could be assigned");
    }
}
