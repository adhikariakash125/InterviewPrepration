package DesignPatterns.Singelton.ENUM;

public enum SingletonEnum {
    /*
 1. In ENUM by default all constructors are private
 2. The reflection problem is also not there as only one snapshot of object is present per JVM
 3. Since enums are inherently serializable, we don't need to implement it with a serializable interface.
 */
    INSTANCE;

    int value;

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }
}
