package src.corejava.oops.in28Minutes;

public class MotorBikeRunner {

    public static void main(String[] args) {
        MotorBike ducati = new MotorBike();
        MotorBike honda = new MotorBike();

        ducati.start();
        honda.start();

        ducati.setSpeed(100);
        honda.setSpeed(80);


    }
}
