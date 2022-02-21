package src.corejava.serialised;

/**
 * Author: Akshay Babbar
 *
 * @Purpose: This is driver class.
 */


import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

public class CustomisedEmployee implements Externalizable {
    private static final long serialVersionUID = 1L;
    private Integer id;
    private String name;

    public CustomisedEmployee(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public void writeExternal(ObjectOutput writeObject) throws IOException {
        System.out.println("in writeObject() method");
        try {
            writeObject.writeInt(this.id);
            writeObject.writeObject(this.name);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {

        try {
            id = in.readInt();
            name = (String) in.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Override
    public String toString() {
        return "Employee [id = " + this.id + " name = " + this.name + "]";

    }

/*
//  Commented to implement Externalizable interface instead of Serializable
private void writeObject(ObjectOutputStream writeObject){
        System.out.println("in writeObject() method");
        try {
            writeObject.writeInt(this.id);
            writeObject.writeObject(this.name);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void readObject(ObjectInputStream readObject){
        System.out.println("in readObject() method");

        try {
            id = readObject.readInt();
            name = (String) readObject.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }*/
}
