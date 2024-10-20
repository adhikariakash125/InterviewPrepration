package DesignPatterns.Singelton;

public class DoubleCheckLocking {

    /*
    using volatile will ensure that any read/write which happens will happen from memory and not from cache
    https://youtube.com/clip/Ugkx8t86sgec0Y8_XQ8E6G9CbZaDDrXd4EaV?si=enLNP7MmGmZGC53F
    When first thread comes and creates a new object, it will update it in the memory instead of cache
     */
    private static volatile DoubleCheckLocking doubleCheckLocking;

    private DoubleCheckLocking() {}

    public static DoubleCheckLocking getInstance(){
        if (doubleCheckLocking==null){  // check 1
            synchronized (DoubleCheckLocking.class){
                if (doubleCheckLocking==null){ // check 2
                    doubleCheckLocking = new DoubleCheckLocking();
                }
            }
        }
        return doubleCheckLocking;
    }
}

// Disadvantage - This is still very slow since we are using synchronized keyword