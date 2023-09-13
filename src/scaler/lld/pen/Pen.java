package src.scaler.lld.pen;

public abstract class Pen {
    public String name;
    public String brand;
    public int price;

    public WriteStrategy stratergy() {
        return null;
    }

    public abstract void doWrite();



}
