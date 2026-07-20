package LLD.VendingMachine.enums;

public enum Coin {
    RUPEES10(10),
    RUPEES20(20),
    RUPEES100(100);

    public final int value;

    Coin(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
