package src.scaler.lld.snakesnLadders;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Snake extends SpecialEntity {

    private int start;
    private int end;
    private SpecialType snake = SpecialType.SNAKE;

    public Snake(int start, int end) {
        this.start = start;
        this.end = end;
    }
}
