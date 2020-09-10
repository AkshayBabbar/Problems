package coreJava.designPatterns.creational.abstractFactory;


public class PC extends Computer2 {
    private String ram;
    private String hdd;
    private String CPU;

    public PC(String ram, String hdd, String CPU) {
        this.ram = ram;
        this.hdd = hdd;
        this.CPU = CPU;
    }

    @Override
    public String getRam() {
        return this.ram;
    }

    @Override
    public String getHDD() {
        return this.hdd;
    }

    @Override
    public String getCPU() {
        return this.CPU;
    }


}
