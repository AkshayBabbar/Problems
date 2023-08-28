package src.scaler.ooad.prototype;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MeritStudent extends Student {
    private int Rank;

    public MeritStudent(MeritStudent orig){
        super(orig);
        this.Rank = orig.Rank;
    }


    @Override
    public MeritStudent clone() {
        return new MeritStudent(this);
    }
}
