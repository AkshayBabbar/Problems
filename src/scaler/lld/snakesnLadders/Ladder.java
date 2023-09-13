package src.scaler.lld.snakesnLadders;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Ladder {
    private int start;
    private int end;
    private SpecialType ladders = SpecialType.LADDERS;

    public Ladder(int start, int end) {
        this.start = start;
        this.end = end;
    }
}

