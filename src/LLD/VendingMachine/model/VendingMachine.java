package LLD.VendingMachine.model;

import LLD.VendingMachine.enums.Coin;
import LLD.VendingMachine.state.IdleState;
import LLD.VendingMachine.state.VendingMachineState;

import java.util.HashMap;
import java.util.Map;

public class VendingMachine {
    private final HashMap<Integer, Item> itemMap;
    private final CoinInventory coinInventory;
    private VendingMachineState vendingMachineState;
    private int balance = 0;
    private int selectedItemCode;
    private Map<Coin, Integer> insertedCoins;
    private Map<Coin, Integer> refundCoins;

    public VendingMachine() {
        this.itemMap = new HashMap<>();
        this.coinInventory = new CoinInventory();
        this.insertedCoins = new HashMap<>();
        this.refundCoins = new HashMap<>();
        vendingMachineState = new IdleState(this);
    }

    public HashMap<Integer, Item> getItemMap() {
        return itemMap;
    }

    public VendingMachineState getVendingMachineState() {
        return vendingMachineState;
    }

    public void updatedVendingMachineState(VendingMachineState vendingMachineState) {
        this.vendingMachineState = vendingMachineState;
    }

    public CoinInventory getCoinInventory() {
        return coinInventory;
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

    public synchronized void selectItem(int id) {
        this.vendingMachineState.selectItem(id);
    }

    public synchronized void insertMoney(Map<Coin,Integer> coins) {
        this.insertedCoins = new HashMap<>(coins);
        int totalAmount = calculateTotalAmount(coins);
        this.vendingMachineState.insertMoney(totalAmount);
    }

    private int calculateTotalAmount(Map<Coin, Integer> coins) {
        int amount  = 0;
        for (Map.Entry<Coin, Integer> entry : coins.entrySet()) {
            amount += entry.getKey().getValue() * entry.getValue();
        }
        return amount;
    }

    public synchronized void reset() {
        this.selectedItemCode = -1;
        this.balance = 0;
        this.insertedCoins.clear();
        this.refundCoins.clear();
    }

    public void addItem(Item item) {
        itemMap.put(item.getId(), item);
    }

    public void addCoin(Coin coin, int quantity) {
        coinInventory.addCoin(coin, quantity);
    }

    public Map<Coin, Integer> getInsertedCoins() {
        return insertedCoins;
    }

    public void acceptInsertedCoins() {
        coinInventory.addCoins(insertedCoins);
    }

    public void setRefundCoins(Map<Coin, Integer> refundCoins) {
        this.refundCoins = new HashMap<>(refundCoins);
    }

    public Map<Coin, Integer> getRefundCoins() {
        return refundCoins;
    }

    public void deductRefundCoinsFromInventory() {
        coinInventory.decrementCoins(refundCoins);
    }

    public synchronized void dispense() {
        this.vendingMachineState.dispense();
    }

    public synchronized void initiateRefund() {
        this.vendingMachineState.refund();
    }
}
