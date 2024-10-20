package DesignPatterns.Singelton;

public class EagerInitialization {

    /*
    1. Private is so that no one can access it outside the class
    2. Static because the object will only belong to the class
    3.
     */
    private static EagerInitialization eagerInitialization = new EagerInitialization();

    // Constructor is private so that no other class can create a new object
    private EagerInitialization() {}

    /*
    1. Made the method public since it needs to be called from outside the class
    2. Static because the method can be called using class name like
    EagerInitialization object = EagerInitialization.getEagerInitializationObject();
     */
    public static EagerInitialization getEagerInitializationObject() {
        return eagerInitialization;
    }
}


/*
Disadvantage
Although I am not using this object still it is in the memory since we have used static to initialize it
 */