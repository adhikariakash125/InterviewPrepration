package DesignPatterns.Singelton;

public class LazyInitialization {
    private static LazyInitialization lazyInitialization;

    private LazyInitialization() {}

    public static LazyInitialization getInstance(){
        if (lazyInitialization==null)
                lazyInitialization = new LazyInitialization();
        return lazyInitialization;
    }
}

/*
Disadvantage
If two threads come at the same time (T1 and T2)
then both of them will create two objects
 */