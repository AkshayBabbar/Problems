package src.scaler.advanced;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Interval {
    int start;
    int end;

    public Interval(){

    }

    public Interval(int start, int end) {
        this.start = start;
        this.end = end;
    }
}
