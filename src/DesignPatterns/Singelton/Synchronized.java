package DesignPatterns.Singelton;

public class Synchronized {
    private static Synchronized obj;

    private Synchronized() {
    }

    // Using synchronized keyword allows only one Thread to go inside getInstance()
    synchronized public static Synchronized getInstance(){
        if (obj==null){
            obj = new Synchronized();
        }
        return obj;
    }
}

/*
Disadvantage
Very slow since synchronized is put at the method level, it will lock/unlock the getInstance()
 */