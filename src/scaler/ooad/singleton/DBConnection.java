package src.scaler.ooad.singleton;

import lombok.Getter;

public class DBConnection {

    @Getter
    private static final DBConnection INSTANCE  = new DBConnection();

    private DBConnection(){

    }

}
