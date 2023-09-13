package src.scaler.lld.parkingLot.models;

import lombok.Getter;
import lombok.Setter;
import src.scaler.lld.parkingLot.models.BaseModel;
import src.scaler.lld.parkingLot.models.enums.GateType;

@Getter
@Setter
public class Gate extends BaseModel {
    private Operator operator;
    private GateType type;
}
