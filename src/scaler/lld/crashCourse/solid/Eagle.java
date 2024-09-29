package src.scaler.lld.crashCourse.solid;

public class Eagle extends Bird implements Flyable,MakeSound,Eats{
    @Override
    public void eats() {
        System.out.println("EAGLE EATS");
    }

    @Override
    public void fly() {
        System.out.println("Eagle roaring in sky");
    }

    @Override
    public void makeSound() {
        System.out.println("Eagle making sound");
    }
}
