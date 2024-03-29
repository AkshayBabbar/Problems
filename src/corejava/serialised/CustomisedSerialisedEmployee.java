package src.corejava.serialised;


import java.io.*;

/**
 * Author: Akshay Babbar
 *
 * @Purpose: This is the class that will convert the Objects into serialised file.
 */
public class CustomisedSerialisedEmployee {
    public static void main(String[] args) {
        Employee object1 = new Employee(1, "Babbar");
        Employee object2 = new Employee(2, "Akshay");

        try {
            OutputStream fileOut = new FileOutputStream("customfer.txt");
            ObjectOutput objectOut = new ObjectOutputStream(fileOut);
            System.out.println("The Serialisation process has started.");
            objectOut.writeObject(object1);
            objectOut.writeObject(object2);
            objectOut.close();
            System.out.println("Object serialisation is completed");


        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
