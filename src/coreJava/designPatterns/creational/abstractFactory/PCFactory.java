package coreJava.designPatterns.creational.abstractFactory;

public class PCFactory implements ComputerAbstractFactory {

    private String ram;
    private String CPU;
    private String hdd;

    public PCFactory(String ram, String CPU, String hdd) {
        this.ram = ram;
        this.CPU = CPU;
        this.hdd = hdd;
    }

    @Override
    public Computer createComputer() {
        return new PC(ram, hdd, CPU);
    }
}
