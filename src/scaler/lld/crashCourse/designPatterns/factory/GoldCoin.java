package src.scaler.lld.crashCourse.designPatterns.factory;

public class GoldCoin implements Coin{
    static final String DESCRIPTION = "This is a gold coin.";

    public GoldCoin() {
    }
    public String getDescription() {
        return "This is a gold coin.";
    }
}
