package src.scaler.lld.crashCourse.designPatterns.factory;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.function.Supplier;

@RequiredArgsConstructor
@Getter
public enum CoinType {
    GOLD(GoldCoin::new),
    SILVER(SilverCoin::new),
    COPPER(CopperCoin::new);

    private final Supplier<Coin> constructor;

}
