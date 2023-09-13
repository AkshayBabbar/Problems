package src.scaler.ooad.singleton;

public class AnotherTargetForAThread implements Runnable {
    @Override
    public void run() {

        DBConn db3 = DBConn.getInstance();
        System.out.println("hello");
    }
}
