package coreJava.designPatterns.creational.singleton;

/*
 *   Author: Akshay Babbar
 *   Purpose: The Purpose of this Program is to demonstrate the Initialisation of the Singleton Method.
 *               Here the approach is eager initialisation.
 *               This can be applied whenever there is no memory intensive work is required.
 *               Like File System Interaction., DataBase Connection.
 *               DrawBack: This is created when the application is loaded even though application may or may not be using this.
 *               */
public class EagerInitialisation {
    // Instance Creation.
    private static final EagerInitialisation INSTANCE = new EagerInitialisation();

    //    Private constructor instance initialisation.
    private EagerInitialisation() {
    }

    //    Returns the instance required.
    public static EagerInitialisation getInstance() {
        return INSTANCE;
    }
}
