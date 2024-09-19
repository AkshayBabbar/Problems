package src.scaler.lld.crashCourse;

public class User {
    protected long id;
    protected String name;
    protected String email;

    public User(long id, String name, String email) {
        this.id = id;
        this.name = name;
        this.email = email;
    }

    public void printDetails(){
        System.out.println(name + " (" + email + ")");
    }
}
