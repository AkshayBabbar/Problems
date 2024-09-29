package src.scaler.lld.crashCourse.designPatterns.builder;

import src.scaler.lld.crashCourse.designPatterns.builder.car.CarType;
import src.scaler.lld.crashCourse.designPatterns.builder.components.Engine;

public class CarPOJO {
    private String name;
    private CarType carType;
    private Engine engine;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public CarType getCarType() {
        return carType;
    }

    public void setCarType(CarType carType) {
        this.carType = carType;
    }

    public Engine getEngine() {
        return engine;
    }

    public void setEngine(Engine engine) {
        this.engine = engine;
    }
}
