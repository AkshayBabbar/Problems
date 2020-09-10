package coreJava.serialised;

/**
 *
 * Author: Akshay Babbar
 * Pupose: Deserialised the Serialised File, so that we can fetch our product.*/

import java.io.*;

public class CustomisedDeserialisedEmployee {


    public static void main(String[] args) {
        try {
            InputStream fin = new FileInputStream("customfer.txt");
            ObjectInputStream objectInputStream = new ObjectInputStream(fin);
            System.out.println("De serialisation is started and hence see the results.");
            Employee employee;
            while ((employee = (Employee) objectInputStream.readObject()) != null) {
                System.out.println(employee);
            }
            objectInputStream.close();
        } catch (IOException | ClassNotFoundException e) {
            if (e instanceof EOFException) {
//                System.out.println("The EOF is reached.");
                return;
            }
            e.printStackTrace();

        }

        System.out.println("De Serialisation is now completed.");

    }
}
