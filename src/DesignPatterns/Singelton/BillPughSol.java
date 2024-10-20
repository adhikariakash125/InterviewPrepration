package DesignPatterns.Singelton;

// VERY IMPORTANT
public class BillPughSol {

    private BillPughSol() {}

    /*
    1. Private nested class so that no other class can access it
    2. Static as it belongs to the class
    3. Nested class,  since not all the nested class get loaded into the memory when application is started
    4.
     */
    private static class SingletonHelper {
        private static final BillPughSol INSTANCE_OBJECT = new BillPughSol();
    }

    public static BillPughSol getInstance() {
        return SingletonHelper.INSTANCE_OBJECT;
    }
}
