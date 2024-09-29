package src.scaler.lld.crashCourse.generics;

public class Client {
    public static void main(String[] args) {
        try{
            Pair<String, String> pair = new Pair<>("10",null);

        } catch (NullValueException e){
            System.out.println(e.getMessage());
        }

    }
}
