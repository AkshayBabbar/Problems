package src.scaler.ooad.singleton;

public class TargetForAThread implements Runnable {
    @Override
    public void run() {
        DBConn db2 = DBConn.getInstance();
        System.out.println("hello");
    }
}
