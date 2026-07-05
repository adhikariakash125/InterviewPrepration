package LLD.VendingMachine;

import LLD.VendingMachine.model.Item;
import LLD.VendingMachine.model.VendingMachine;

public class VendingMachineDemo {
    public static void main(String[] args) {
        // create vending machine
        VendingMachine vendingMachine = new VendingMachine();

        // create items
        Item juice = new Item(1, "Ice-Cream", 40, 50);
        Item coke = new Item(2, "Coke", 30, 10);
        Item pepsi = new Item(3, "Pepsi", 25, 10);
        Item water = new Item(4, "Water", 20, 12);

        // add items to map
        vendingMachine.addItem(juice);
        vendingMachine.addItem(coke);
        vendingMachine.addItem(pepsi);
        vendingMachine.addItem(water);

        // Select an item
        System.out.println("\n--- Step 1: Select an item ---");
        vendingMachine.selectItem(1);

        // Insert money
        System.out.println("\n--- Step 2: Insert money ---");
        vendingMachine.insertMoney(100);

        // Dispense the product
        System.out.println("\n--- Step 3: Dispense item ---");
        vendingMachine.dispense();

        // Select another item
        System.out.println("\n--- Step 4: Select another item ---");
        vendingMachine.selectItem(3);

        // Insert more amount
        System.out.println("\n--- Step 5: Insert more than needed ---");
        vendingMachine.insertMoney(76); // 25

        // Try to dispense the product
        System.out.println("\n--- Step 6: Dispense and return change ---");
        vendingMachine.dispense();

    }
}
