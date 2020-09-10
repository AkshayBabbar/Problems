package coreJava.designPatterns.creational.factory;

public abstract class Computer {
    public abstract String getRam();
    public abstract String getCPU();
    public abstract String getHDD();
    @Override
    public String toString() {
        return "RAM  = " + this.getRam() + " CPU = " + this.getCPU() + " HDD =" + this.getHDD();
    }


}
