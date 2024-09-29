package src.scaler.lld.crashCourse.designPatterns.singleton;


public class Database {
    public static Database instance = null;

    private Database(){
    }

    /**
     * LazyInitialisation
    public static Database getInstance(){
        if(instance == null){
            instance = new Database();
        }
        return instance;
    }
    */


//    ThreadSafe implementation
    public static synchronized Database getInstance(){
        if(instance == null){
            instance = new Database();
        }
        return instance;
    }
}
