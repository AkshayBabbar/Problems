package src.scaler.lld.crashCourse.designPatterns.builder.director;

import src.scaler.lld.crashCourse.designPatterns.builder.builders.Builder;
import src.scaler.lld.crashCourse.designPatterns.builder.car.CarType;
import src.scaler.lld.crashCourse.designPatterns.builder.components.Engine;
import src.scaler.lld.crashCourse.designPatterns.builder.components.GPSNavigator;
import src.scaler.lld.crashCourse.designPatterns.builder.components.Transmission;

public class Director {

    public void constructSportsCar(Builder builder) {
        builder.setCarType(CarType.SPORTS_CAR);
        builder.setSeats(2);
        builder.setEngine(new Engine(3.0, 6));
        builder.setTransmission(Transmission.SEMI_AUTOMATIC);
        builder.setGPSNavigator(new GPSNavigator());
    }

    public void constructCityCar(Builder builder) {
        builder.setCarType(CarType.CITY_CAR);
        builder.setSeats(2);
        builder.setEngine(new Engine(1.2, 0));
        builder.setTransmission(Transmission.AUTOMATIC);
        builder.setGPSNavigator(new GPSNavigator());
    }

    public void constructSUV(Builder builder) {
        builder.setCarType(CarType.SUV);
        builder.setSeats(4);
        builder.setEngine(new Engine(2.5, 0));
        builder.setTransmission(Transmission.MANUAL);
        builder.setGPSNavigator(new GPSNavigator());
    }
}