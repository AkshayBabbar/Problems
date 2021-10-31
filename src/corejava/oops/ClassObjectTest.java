package corejava.oops;

public class ClassObjectTest {
    public static void main(String[] args) {
        Animal animal = new Animal();
        animal.setName("Lion");
        animal.setFood("Flesh");
        System.out.println(animal.getFood());
        System.out.println(animal.getName());
    }

}
