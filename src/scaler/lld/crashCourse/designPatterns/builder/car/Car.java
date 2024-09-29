package src.scaler.lld.crashCourse.designPatterns.builder.car;

import src.scaler.lld.crashCourse.designPatterns.builder.components.Engine;
import src.scaler.lld.crashCourse.designPatterns.builder.components.GPSNavigator;
import src.scaler.lld.crashCourse.designPatterns.builder.components.Transmission;

public class Car {
    private final CarType carType;
    private int seats;

    private final Engine engine;

    private final Transmission transmission;
    private final GPSNavigator gpsNavigator;

    public Car(CarType carType, int seats, Engine engine, Transmission transmission, GPSNavigator gpsNavigator) {
        this.carType = carType;
        this.seats = seats;
        this.engine = engine;
        this.transmission = transmission;
        this.gpsNavigator = gpsNavigator;
    }

    public CarType getCarType() {
        return carType;
    }

    public int getSeats() {
        return seats;
    }

    public Engine getEngine() {
        return engine;
    }

    public Transmission getTransmission() {
        return transmission;
    }

    public GPSNavigator getGpsNavigator() {
        return gpsNavigator;
    }
}
