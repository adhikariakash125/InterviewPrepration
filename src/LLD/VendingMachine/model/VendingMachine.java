package LLD.VendingMachine.model;

import LLD.VendingMachine.state.IdleState;
import LLD.VendingMachine.state.VendingMachineState;

import java.util.HashMap;

public class VendingMachine {
    private final HashMap<Integer, Item> itemMap;
    private HashMap<Integer, Integer> itemQuantityMap;
    private VendingMachineState vendingMachineState;
    private int balance = 0;
    private int selectedItemCode;

    public VendingMachine() {
        this.itemMap = new HashMap<>();
        this.itemQuantityMap = new HashMap<>();
        vendingMachineState = new IdleState(this);
    }

    public HashMap<Integer, Item> getItemMap() {
        return itemMap;
    }

    public HashMap<Integer, Integer> getItemQuantityMap() {
        return itemQuantityMap;
    }

    public VendingMachineState getVendingMachineState() {
        return vendingMachineState;
    }

    public void updatedVendingMachineState(VendingMachineState vendingMachineState) {
        this.vendingMachineState = vendingMachineState;
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    public int getSelectedItemCode() {
        return selectedItemCode;
    }

    public void setSelectedItemCode(int selectedItemCode) {
        this.selectedItemCode = selectedItemCode;
    }

    public void selectItem(int id) {
        this.vendingMachineState.selectItem(id);
    }

    public void insertMoney(int amount) {
        this.vendingMachineState.insertMoney(amount);
    }

    public void reset() {
        this.selectedItemCode = -1;
        this.balance = 0;
    }

    public void addItem(Item item) {
        itemMap.put(item.getId(), item);
    }

    public void dispense() {
        this.vendingMachineState.dispense();
    }

    public void initiateRefund() {
        this.vendingMachineState.refund();
    }
}
