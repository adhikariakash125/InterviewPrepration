package LLD.VendingMachine.state;

import LLD.VendingMachine.model.VendingMachine;

public abstract class VendingMachineState {
    VendingMachine machine;
    public VendingMachineState(VendingMachine vendingMachine) {
        this.machine = vendingMachine;
    }

    public abstract void selectItem(int id);
    public abstract void insertMoney(int amount);
    public abstract void dispense();
    public abstract void refund();
}
