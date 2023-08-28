package src.scaler.ooad.singleton;

public class DBConnection {

    private static final DBConnection INSTANCE  = new DBConnection();

    private DBConnection(){

    }

    public static DBConnection getINSTANCE() {
        return INSTANCE;
    }
}
