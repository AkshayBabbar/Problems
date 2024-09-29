package src.scaler.lld.crashCourse.designPatterns.builder.builders;

import src.scaler.lld.crashCourse.designPatterns.builder.car.CarType;
import src.scaler.lld.crashCourse.designPatterns.builder.components.Engine;
import src.scaler.lld.crashCourse.designPatterns.builder.components.GPSNavigator;
import src.scaler.lld.crashCourse.designPatterns.builder.components.Transmission;

public interface Builder {
    void setCarType(CarType type);

    void setSeats(int seats);

    void setEngine(Engine engine);

    void setTransmission(Transmission transmission);

    void setGPSNavigator(GPSNavigator gpsNavigator);

}
