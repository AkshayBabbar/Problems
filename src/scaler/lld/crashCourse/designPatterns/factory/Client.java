package src.scaler.lld.crashCourse.designPatterns.factory;

public class Client {
    public static void main(String[] args) {
        var coin1 = CoinFactory.getCoin(CoinType.COPPER);
        var coin2 = CoinFactory.getCoin(CoinType.GOLD);
        var coin3 = CoinFactory.getCoin(CoinType.SILVER);
        System.out.println(coin1.getDescription());
        System.out.println(coin2.getDescription());
        System.out.println(coin3.getDescription());
    }
}
