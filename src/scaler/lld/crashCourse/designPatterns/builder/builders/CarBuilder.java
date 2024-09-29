package src.scaler.lld.crashCourse.designPatterns.builder.builders;

import src.scaler.lld.crashCourse.designPatterns.builder.car.Car;
import src.scaler.lld.crashCourse.designPatterns.builder.car.CarType;
import src.scaler.lld.crashCourse.designPatterns.builder.components.Engine;
import src.scaler.lld.crashCourse.designPatterns.builder.components.GPSNavigator;
import src.scaler.lld.crashCourse.designPatterns.builder.components.Transmission;

/**
 * Concrete builders implement steps defined in the common interface.
 */
public class CarBuilder implements Builder {
    private CarType type;
    private int seats;
    private Engine engine;
    private Transmission transmission;
    private GPSNavigator gpsNavigator;

    @Override
    public void setCarType(CarType type) {
        this.type = type;
    }

    @Override
    public void setSeats(int seats) {
        this.seats = seats;
    }

    @Override
    public void setEngine(Engine engine) {
        this.engine = engine;
    }

    @Override
    public void setTransmission(Transmission transmission) {
        this.transmission = transmission;
    }

    @Override
    public void setGPSNavigator(GPSNavigator gpsNavigator) {
        this.gpsNavigator = gpsNavigator;
    }

    public Car getResult() {
        return new Car(type, seats, engine, transmission, gpsNavigator);
    }
}
