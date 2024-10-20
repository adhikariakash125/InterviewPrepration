package DesignPatterns.Singelton;

import java.io.Serializable;
// TODO: Cross check with the code that is written in Office laptop
public class Singleton implements Cloneable, Serializable {

    private static final Singleton singleton = null;

    private Singleton(){
        if (singleton!=null)
            throw new IllegalStateException("Object is already created");
    }

    static Singleton getSingleton(){
        if (singleton==null){
            synchronized (Singleton.class){
                if (singleton==null){
                    return new Singleton();
                }
            }
        }
        return singleton;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        throw new CloneNotSupportedException("Object is already created");
    }
}
